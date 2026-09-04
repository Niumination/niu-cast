#!/usr/bin/env python3
"""
VNCAdapter v2 — dengan ADB integration untuk real Android screen capture.
Supports macOS Screen Sharing.app (VNC Authentication + RFB 003.003).
"""

import os
import sys
import shutil
import io
import subprocess
import threading
import socket
import struct
import time
import select
from typing import Optional

try:
    from PIL import Image
    PIL_AVAILABLE = True
except ImportError:
    PIL_AVAILABLE = False

# Add niu_cast to path
sys.path.insert(0, os.path.join(os.path.dirname(os.path.abspath(__file__)), 'niu_cast'))
try:
    from adb_controller import ADBController
    ADB_AVAILABLE = True
except ImportError:
    ADB_AVAILABLE = False
    print("Warning: ADBController not available")

try:
    from Crypto.Cipher import DES
    DES_AVAILABLE = True
except ImportError:
    DES_AVAILABLE = False
    print("Warning: pycryptodome not available — VNC auth disabled")


class VNCAdapter:
    """VNC server dengan ADB screen capture integration."""
    
    def __init__(self, port=5901, adb_path="adb", vnc_password="niucast"):
        self.port = port
        self.adb_path = adb_path
        self.server_socket = None
        self.clients = []
        self.running = False
        
        # VNC password (8 bytes, null-padded) — macOS requires auth
        self.vnc_password = (vnc_password + "\x00" * 8)[:8]
        self.challenge = os.urandom(16)
        
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
                
            # devices is a list of serial strings
            self.device_serial = devices[0]
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
        """Capture Android screen via ADB and return raw BGRX data."""
        if not self.adb or not self.device_serial:
            print("No ADB device connected")
            return None
            
        try:
            result = subprocess.run(
                [self.adb_path, "-s", self.device_serial, "shell", "screencap", "-p"],
                capture_output=True, timeout=5
            )
            
            if result.returncode == 0 and result.stdout:
                try:
                    img = Image.open(io.BytesIO(result.stdout))
                    if img.mode != 'RGB':
                        img.convert('RGB')
                    self.screen_width, self.screen_height = img.size
                    # BGRX byte order for macOS
                    return img.tobytes('raw', 'BGRX')
                except Exception as e:
                    print(f"PIL decode error: {e}")
                    return result.stdout
        except Exception as e:
            print(f"Screen capture error: {e}")
        return None
    
    def encode_rfb_frame(self, client_socket, screen_data: Optional[bytes]):
        """Encode screen data to RFB frame (Raw encoding)."""
        if not screen_data:
            return self.send_black_frame(client_socket)
        
        try:
            message_type = 0
            padding = 0
            num_rectangles = 1
            x = y = 0
            w = self.screen_width
            h = self.screen_height
            encoding_type = 0  # Raw
            
            fb_header = struct.pack('!BBH', message_type, padding, num_rectangles)
            rect_header = struct.pack('!HHHHi', x, y, w, h, encoding_type)
            
            client_socket.sendall(fb_header + rect_header + screen_data)
            return True
        except Exception as e:
            print(f"RFB encode error: {e}")
            return False
    
    def _rfb_keycode_to_android(self, rfb_keycode: int) -> Optional[int]:
        """Map RFB keycodes to Android keycodes."""
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
    
    def _vnc_encrypt(self, challenge, password):
        """VNC Authentication: encrypt challenge with password using DES."""
        key = bytearray(8)
        for i in range(8):
            b = ord(password[i]) if i < len(password) else 0
            key[i] = ((b >> 0) & 0x01) | ((b >> 1) & 0x01) << 1 | \
                     ((b >> 2) & 0x01) << 2 | ((b >> 3) & 0x01) << 3 | \
                     ((b >> 4) & 0x01) << 4 | ((b >> 5) & 0x01) << 5 | \
                     ((b >> 6) & 0x01) << 6 | ((b >> 7) & 0x01) << 7
        
        cipher = DES.new(bytes(key), DES.MODE_ECB)
        return cipher.encrypt(challenge)
    
    def _vnc_authenticate(self, response):
        """Verify VNC authentication response."""
        try:
            expected = self._vnc_encrypt(self.challenge, self.vnc_password)
            return response == expected
        except Exception as e:
            print(f"Auth error: {e}")
            return False
    
    def send_black_frame(self, client_socket):
        """Send a black frame update."""
        try:
            msg = struct.pack('!BBH', 0, 0, 1)  # type, padding, num_rects
            msg += struct.pack('!HHHHi', 0, 0, self.screen_width, self.screen_height, 0)
            client_socket.send(msg)
            return True
        except:
            return False
    
    def handle_client(self, client_socket, client_address):
        """Handle VNC client connection."""
        print(f"VNC client connected: {client_address}")
        
        try:
            # RFB Protocol Version handshake — match client version
            server_version = "RFB 003.008\n"
            client_socket.send(server_version.encode())
            
            # Receive client version
            client_version = client_socket.recv(12).decode()
            print(f"Client RFB version: {client_version.strip()}")
            
            # Match client version for handshake
            is_old_version = "003.003" in client_version or "003.005" in client_version
            
            if is_old_version:
                # RFB 3.3/3.5 handshake: single security type byte, no result
                if DES_AVAILABLE:
                    client_socket.send(struct.pack('!B', 2))  # VNC Auth
                    client_socket.send(self.challenge)
                    response = client_socket.recv(16)
                    if not self._vnc_authenticate(response):
                        print(f"Auth FAILED for {client_address}")
                        return
                    print(f"Auth OK for {client_address}")
                else:
                    client_socket.send(struct.pack('!B', 1))  # None
                # No security result in 3.3!
            else:
                # RFB 3.7+ handshake: list of types + result
                client_socket.send(struct.pack('!B', 2))  # 2 types
                client_socket.send(struct.pack('!BB', 2, 1))  # VNC Auth, None
                
                selected_type = client_socket.recv(1)
                if selected_type[0] == 2 and DES_AVAILABLE:
                    client_socket.send(self.challenge)
                    response = client_socket.recv(16)
                    if self._vnc_authenticate(response):
                        client_socket.send(struct.pack('!I', 0))  # OK
                        print(f"Auth OK for {client_address}")
                    else:
                        client_socket.send(struct.pack('!I', 1))  # Failed
                        print(f"Auth FAILED for {client_address}")
                        return
                else:
                    client_socket.send(struct.pack('!I', 0))  # OK
            
            # ClientInit (shared flag)
            shared_flag = client_socket.recv(1)
            
            # Send ServerInit with pixel format macOS expects
            device_name = "Android Screen" if self.device_serial else "Android Device"
            name_bytes = device_name.encode('latin-1')
            
            # Pixel format: 32bpp, 24depth, LE=0, TC=1, BGRX
            server_init = struct.pack('!HH BBBB HHH BBB 3s I',
                self.screen_width, self.screen_height,  # HH
                32, 24, 0, 1,                           # BBBB (bpp, depth, LE=0, TC=1)
                255, 255, 255,                          # HHH (max)
                16, 8, 0,                               # BBB (shift)
                b'\x00\x00\x00',                        # padding
                len(name_bytes)                           # name length
            ) + name_bytes
            client_socket.sendall(server_init)
            
            print(f"VNC handshake complete for {client_address}")
            self.clients.append(client_socket)
            
            # Send first frame immediately
            try:
                screen_data = self.capture_screen_adb()
                self.encode_rfb_frame(client_socket, screen_data)
                print(f"First frame sent ({len(screen_data) if screen_data else 'no data'})")
            except Exception as e:
                print(f"First frame error: {e}")
            
            # Periodic framebuffer updates
            last_update = time.time()
            while self.running and client_socket in self.clients:
                try:
                    ready = select.select([client_socket], [], [], 0.05)
                    if ready[0]:
                        msg_type = client_socket.recv(1)
                        if not msg_type:
                            break
                        
                        if msg_type[0] == 0:  # SetPixelFormat
                            client_socket.recv(19)
                        elif msg_type[0] == 2:  # SetEncodings
                            data = client_socket.recv(1)
                            if data:
                                n = data[0]
                                client_socket.recv(n * 2)
                        elif msg_type[0] == 3:  # FramebufferUpdateRequest
                            data = client_socket.recv(9)
                            if len(data) >= 9:
                                screen_data = self.capture_screen_adb()
                                self.encode_rfb_frame(client_socket, screen_data)
                        elif msg_type[0] == 4:  # KeyEvent
                            client_socket.recv(7)
                        elif msg_type[0] == 5:  # PointerEvent
                            data = client_socket.recv(5)
                            if len(data) >= 5:
                                button_mask = data[0]
                                px = struct.unpack('!H', data[1:3])[0]
                                py = struct.unpack('!H', data[3:5])[0]
                                if button_mask & 0x01 and self.adb:
                                    self.adb.send_tap(px, py)
                        elif msg_type[0] == 6:  # ClientCutText
                            data = client_socket.recv(7)
                            if len(data) >= 7:
                                length = struct.unpack('!I', data[3:7])[0]
                                client_socket.recv(length)
                    
                    current_time = time.time()
                    if current_time - last_update >= self.screenshot_interval:
                        screen_data = self.capture_screen_adb()
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
            print(f"Password: {self.vnc_password.strip(chr(0))}")
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
    print("=== VNCAdapter v2 dengan ADB Integration ===")
    print("Android Screen Mirror via VNC Protocol")
    
    adb_path = "adb"
    if not shutil.which(adb_path):
        for p in ['/usr/local/bin/adb', '/opt/homebrew/bin/adb']:
            if os.path.exists(p):
                adb_path = p
                break
    
    adapter = VNCAdapter(port=5901, adb_path=adb_path)
    try:
        adapter.start_server()
    except KeyboardInterrupt:
        print("\nShutting down...")
    finally:
        adapter.stop_server()


if __name__ == "__main__":
    main()
