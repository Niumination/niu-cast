#!/usr/bin/env python3
"""
VNCAdapter v2 — dengan ADB integration untuk real Android screen capture.
"""

import socket
import threading
import struct
import time
import select
from typing import Optional
import subprocess
import io
import json
import os
import sys


# Add niu_cast to path
sys.path.insert(0, os.path.join(os.path.dirname(os.path.abspath(__file__)), 'niu_cast'))
try:
    from adb_controller import ADBController
    ADB_AVAILABLE = True
except ImportError:
    ADB_AVAILABLE = False
    print("Warning: ADBController not available")

class VNCAdapter:
    """VNC server dengan ADB screen capture integration."""
    
    def __init__(self, port=5901, adb_path="adb"):
        self.port = port
        self.adb_path = adb_path
        self.server_socket = None
        self.clients = []
        self.running = False
        
        # Screen properties (akan diupdate dari device)
        self.screen_width = 1080
        self.screen_height = 2400
        self.bpp = 32
        self.depth = 24
        self.screenshot_interval = 0.033  # ~30 FPS
        
        # ADB controller
        self.adb = None
        self.device_serial = None
        self.device_connected = False
        
    def init_adb(self):
        """Initialize ADB controller and connect to device."""
        if not ADB_AVAILABLE:
            print("Error: ADBController not available")
            return False
            
        try:
            self.adb = ADBController(adb_path=self.adb_path)
            
            # Check devices
            devices = self.adb.devices()
            if not devices:
                print("No Android devices connected via ADB")
                return False
                
            # Use first device
            self.device_serial = devices[0].get('serial')
            print(f"Connected to device: {self.device_serial}")
            
            # Get screen resolution
            resolution = self.get_screen_resolution()
            if resolution:
                self.screen_width, self.screen_height = resolution
                print(f"Screen resolution: {self.screen_width}x{self.screen_height}")
            
            self.device_connected = True
            return True
            
        except Exception as e:
            print(f"ADB init error: {e}")
            return False
    
    def get_screen_resolution(self):
        """Get screen resolution from Android device."""
        if not self.adb or not self.device_serial:
            return None
            
        try:
            # Run adb shell wm size
            result = subprocess.run(
                [self.adb_path, "-s", self.device_serial, "shell", "wm", "size"],
                capture_output=True, text=True, timeout=5
            )
            if result.returncode == 0:
                # Parse output: "Physical size: 1080x2400"
                for line in result.stdout.strip().split('\n'):
                    if 'Physical size:' in line:
                        size = line.split(':')[1].strip()
                        w, h = size.split('x')
                        return int(w), int(h)
        except Exception as e:
            print(f"Resolution detection error: {e}")
            
        return None
    
    def capture_screen_adb(self):
        """Capture Android screen via ADB and return raw RGB data (bytes)."""
        if not self.adb or not self.device_serial:
            print("No ADB device connected")
            return None
            
        try:
            # Capture screen via ADB
            result = subprocess.run(
                [self.adb_path, "-s", self.device_serial, "shell", "screencap", "-p"],
                capture_output=True, timeout=5
            )
            
            if result.returncode == 0 and result.stdout:
                # Decode PNG to RGB raw data using PIL
                try:
                    img = Image.open(io.BytesIO(result.stdout))
                    # Convert to RGB if needed
                    if img.mode != 'RGB':
                        img = img.convert('RGB')
                    width, height = img.size
                    # Update screen dimensions
                    self.screen_width = width
                    self.screen_height = height
                    # Return raw RGB bytes (RGBX for RFB)
                    raw_data = img.tobytes('raw', 'RGBX')
                    return raw_data
                except Exception as e:
                    print(f"PIL decode error: {e}")
                    return result.stdout  # Fallback to PNG
                    
        except Exception as e:
            print(f"Screen capture error: {e}")
            
        return None
    
    def encode_rfb_frame(self, client_socket, screen_data: Optional[bytes]):
        """Encode screen data to RFB protocol frame (Raw encoding)."""
        if not screen_data:
            return self.send_black_frame(client_socket)
            
        try:
            # RFB FramebufferUpdate message
            message_type = 0  # FramebufferUpdate
            padding = 0
            num_rectangles = 1
            
            # Rectangle header (x, y, w, h, encoding_type)
            x = 0
            y = 0
            w = self.screen_width
            h = self.screen_height
            encoding_type = 0  # Raw encoding (type 0)
            
            # Send FramebufferUpdate header (3 bytes: type + padding + num_rects)
            fb_header = struct.pack('!BBH', message_type, padding, num_rectangles)
            client_socket.sendall(fb_header)
            
            # Send Rectangle header (12 bytes: x, y, w, h, encoding_type)
            rect_header = struct.pack('!HHHHi', x, y, w, h, encoding_type)
            client_socket.sendall(rect_header)
            
            # Send Pixel data (RGBX format) — sendAll to ensure complete transfer
            client_socket.sendall(screen_data)
            
            return True
            
        except Exception as e:
            print(f"RFB encode error: {e}")
            return False
    

    def _rfb_keycode_to_android(self, rfb_keycode: int) -> Optional[int]:
        # Map common RFB keycodes to Android keycode for input forwarding
        # Reference: https://github.com/rfb/rfbproto/blob/master/rfbproto.rfb
        rfb_to_android = {
            1: 7, 2: 8, 3: 19, 4: 20, 5: 21, 6: 22, 7: 13, 8: 12,
            9: 15, 10: 14, 11: 92, 12: 93, 13: 67, 14: 66, 15: 4,
            16: 29, 17: 30, 18: 31, 19: 32, 20: 33, 21: 34, 22: 35,
            23: 36, 24: 37, 25: 38, 26: 39, 27: 40, 28: 41, 29: 42,
            30: 43, 31: 44, 32: 45, 33: 46, 34: 47, 35: 48, 36: 49,
            37: 50, 38: 51, 39: 52, 40: 53, 41: 54, 42: 7, 43: 8,
            44: 9, 45: 10, 46: 11, 47: 12, 48: 13, 49: 14, 50: 15,
            51: 16, 65: 97, 66: 98, 67: 99, 68: 100, 69: 101, 70: 102,
            71: 103, 72: 104, 73: 105, 74: 106, 75: 107, 76: 108,
            77: 109, 78: 110, 79: 111, 80: 112, 81: 113, 82: 114,
            83: 115, 84: 116, 85: 117, 86: 118, 87: 119, 88: 120,
            89: 121, 90: 122, 91: 66, 92: 7, 93: 8, 94: 9, 95: 10,
            127: 67
        }
        
        if rfb_keycode in rfb_to_android:
            return rfb_to_android[rfb_keycode]
        
        if 0x20 <= rfb_keycode <= 0x7E:
            return rfb_keycode
        
        return None
    def send_black_frame(self, client_socket):
        """Send a black frame update."""
        try:
            message_type = 0  # FramebufferUpdate
            padding = 0
            num_rectangles = 1
            
            x = 0
            y = 0
            w = self.screen_width
            h = self.screen_height
            encoding_type = 0  # Raw encoding
            
            msg = struct.pack('!BBH', message_type, padding, num_rectangles)
            msg += struct.pack('!HHHHi', x, y, w, h, encoding_type)
            
            client_socket.send(msg)
            return True
        except:
            return False
    
    def handle_client(self, client_socket, client_address):
        """Handle VNC client connection."""
        print(f"VNC client connected: {client_address}")
        
        try:
            # RFB Protocol Version handshake
            version = "RFB 003.008\n"
            client_socket.send(version.encode())
            
            # Receive client version
            client_version = client_socket.recv(12).decode()
            print(f"Client RFB version: {client_version}")
            
            # Security handshake (simplified)
            num_security_types = 1
            security_type = 1  # None
            client_socket.send(struct.pack('!B', num_security_types))
            client_socket.send(struct.pack('!B', security_type))
            
            # Client selects security type
            selected_type = client_socket.recv(1)
            
            # Security result (OK)
            client_socket.send(struct.pack('!I', 0))  # OK
            
            # ClientInit/ServerInit
            shared_flag = client_socket.recv(1)
            
            # Send ServerInit
            device_name = "Android Screen" if self.device_serial else "Android Device"
            name_bytes = device_name.encode('latin-1')
            
            server_init = struct.pack('!HHBBBBHH',
                self.screen_width, self.screen_height,
                self.bpp, self.depth, 0, 0, 0, 0
            )
            server_init += struct.pack('!I', len(name_bytes))
            server_init += name_bytes
            
            # Send all data at once to avoid fragmentation
            client_socket.sendall(server_init)
            
            print(f"VNC handshake complete for {client_address}")
            
            # Add to clients list
            self.clients.append(client_socket)
            
            # Send periodic framebuffer updates
            last_update = time.time()
            while self.running and client_socket in self.clients:
                try:
                    # Check for client messages (non-blocking)
                    ready = select.select([client_socket], [], [], 0.1)
                    if ready[0]:
                        msg_type = client_socket.recv(1)
                        if not msg_type:
                            break
                            
                        # Handle client events (RFB protocol)
                        if msg_type[0] == 3:  # KeyEvent
                            # RFB KeyEvent: 1 byte (down/up) + 4 bytes (keycode)
                            key_event_data = client_socket.recv(4)
                            if len(key_event_data) >= 4:
                                # keycode in big-endian
                                keycode = struct.unpack('!I', key_event_data[:4])[0]
                                # RFB keycode mapping ke Android keycode
                                android_keycode = self._rfb_keycode_to_android(keycode)
                                if android_keycode is not None:
                                    if self.adb and self.device_serial:
                                        self.adb.send_keyevent(android_keycode)
                        elif msg_type[0] == 4 or msg_type[0] == 5:  # PointerEvent
                            # RFB PtrEvent: 1 byte (button mask) + 2 bytes (x) + 2 bytes (y)
                            pointer_data = client_socket.recv(5)
                            if len(pointer_data) >= 5:
                                button_mask = pointer_data[0]
                                px = struct.unpack('!H', pointer_data[1:3])[0]
                                py = struct.unpack('!H', pointer_data[3:5])[0]
                                # Map button mask ke ADB tap
                                # Button1 (left click) = 0x40, no button = 0x00
                                if (button_mask & 0x40) or button_mask == 0x40:
                                    if self.adb and self.device_serial:
                                        self.adb.send_tap(px, py)
                                # Mouse move without button: no action in ADB
                        elif msg_type[0] == 6:  # ClientCutText
                            # Skip cut text data
                            pass
                    
                    # Send framebuffer update periodically
                    current_time = time.time()
                    if current_time - last_update >= self.screenshot_interval:
                        # Capture screen via ADB
                        screen_data = None
                        if self.device_connected:
                            screen_data = self.capture_screen_adb()
                        
                        # Encode and send frame
                        self.encode_rfb_frame(client_socket, screen_data)
                        last_update = current_time
                        
                except (socket.error, ConnectionResetError):
                    break
                    
        except Exception as e:
            print(f"Client handler error: {e}")
        finally:
            if client_socket in self.clients:
                self.clients.remove(client_socket)
            client_socket.close()
            print(f"VNC client disconnected: {client_address}")
    
    def start_server(self):
        """Start VNC server with ADB integration."""
        import select
        
        # Initialize ADB
        adb_ready = self.init_adb()
        if not adb_ready:
            print("Warning: Starting VNC server without ADB device")
        
        self.running = True
        
        try:
            self.server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
            self.server_socket.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
            self.server_socket.bind(('0.0.0.0', self.port))
            self.server_socket.listen(5)
            
            print(f"VNC Server starting on port {self.port}")
            print(f"Screen: {self.screen_width}x{self.screen_height}")
            if self.device_connected:
                print(f"Device: {self.device_serial}")
            print(f"Connect with: Screen Sharing -> vnc://localhost:{self.port}")
            print("Press Ctrl+C to stop")
            
            while self.running:
                try:
                    client_socket, client_address = self.server_socket.accept()
                    client_thread = threading.Thread(
                        target=self.handle_client,
                        args=(client_socket, client_address)
                    )
                    client_thread.daemon = True
                    client_thread.start()
                except socket.timeout:
                    continue
                except KeyboardInterrupt:
                    break
                except Exception as e:
                    print(f"Accept error: {e}")
                    break
                    
        except Exception as e:
            print(f"Server error: {e}")
        finally:
            self.stop_server()
    
    def stop_server(self):
        """Stop VNC server."""
        self.running = False
        if self.server_socket:
            self.server_socket.close()
        for client in self.clients:
            try:
                client.close()
            except:
                pass
        self.clients.clear()
        print("VNC Server stopped")

def main():
    """Main entry point for VNCAdapter v2."""
    import sys

    
    print("=== VNCAdapter v2 dengan ADB Integration ===")
    print("Android Screen Mirror via VNC Protocol")
    
    # Check ADB
    adb_path = "adb"
    if not os.path.exists(adb_path):
        adb_path = "/usr/local/bin/adb"
    
    if not os.path.exists(adb_path):
        print("Error: ADB not found. Please install adb.")
        sys.exit(1)
    
    # Start server
    adapter = VNCAdapter(port=5901, adb_path=adb_path)
    try:
        adapter.start_server()
    except KeyboardInterrupt:
        print("\nShutting down...")
    finally:
        adapter.stop_server()

if __name__ == "__main__":
    main()
