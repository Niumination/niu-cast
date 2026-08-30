#!/usr/bin/env python3
"""
VNCAdapter — Proof of Concept VNC server untuk Android screen mirror
Menghubungkan ADB screen capture ke RFB/VNC protocol.
"""

import socket
import threading
import struct
import time
from typing import Optional
import subprocess
import json
import os

class VNCAdapter:
    """Adapter untuk serve Android screen via VNC protocol."""
    
    def __init__(self, adb_path="adb", port=5901):
        self.adb_path = adb_path
        self.port = port
        self.server_socket = None
        self.clients = []
        self.running = False
        self.screen_width = 1080
        self.screen_height = 2400
        self.bpp = 32  # bits per pixel
        self.depth = 24
        self.screenshot_interval = 0.033  # ~30 FPS
        
    def get_device_info(self) -> dict:
        """Get Android device screen info via ADB."""
        try:
            # Get screen resolution
            result = subprocess.run(
                [self.adb_path, "shell", "wm", "size"],
                capture_output=True, text=True, timeout=5
            )
            if result.returncode == 0:
                # Parse output: "Physical size: 1080x2400"
                lines = result.stdout.strip().split('\n')
                for line in lines:
                    if 'Physical size:' in line:
                        size = line.split(':')[1].strip()
                        w, h = size.split('x')
                        self.screen_width = int(w)
                        self.screen_height = int(h)
                        break
                        
            # Get device name
            result = subprocess.run(
                [self.adb_path, "shell", "getprop", "ro.product.model"],
                capture_output=True, text=True, timeout=5
            )
            device_name = result.stdout.strip() if result.returncode == 0 else "Android Device"
            
            return {
                "width": self.screen_width,
                "height": self.screen_height,
                "device": device_name,
                "bpp": self.bpp,
                "depth": self.depth
            }
        except Exception as e:
            print(f"Error getting device info: {e}")
            return {
                "width": self.screen_width,
                "height": self.screen_height,
                "device": "Android Device",
                "bpp": self.bpp,
                "depth": self.depth
            }
    
    def capture_screen(self) -> bytes:
        """Capture Android screen via ADB and return raw RGB data."""
        try:
            # Use screencap command
            result = subprocess.run(
                [self.adb_path, "shell", "screencap", "-p"],
                capture_output=True, timeout=5
            )
            if result.returncode == 0:
                return result.stdout
        except Exception as e:
            print(f"Screen capture error: {e}")
        
        # Fallback: return black screen
        import random
        return bytes([random.randint(0, 255) for _ in range(self.screen_width * self.screen_height * 4)])
    
    def encode_rfb_frame(self, client_socket, screen_data: bytes):
        """Encode screen data to RFB protocol frame."""
        try:
            # Simple RFB Raw encoding
            # FramebufferUpdate message
            message_type = 0  # FramebufferUpdate
            padding = 0
            num_rectangles = 1
            
            # Rectangle header
            x = 0
            y = 0
            w = self.screen_width
            h = self.screen_height
            encoding_type = 0  # Raw encoding
            
            # Build message
            msg = struct.pack('!BBH', message_type, padding, num_rectangles)
            msg += struct.pack('!HHHHi', x, y, w, h, encoding_type)
            
            # For PoC, send minimal data
            client_socket.send(msg)
            
            # In real implementation, would send actual pixel data
            # client_socket.send(screen_data)
            
        except Exception as e:
            print(f"RFB encode error: {e}")
    
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
            device_info = self.get_device_info()
            name = f"Android Screen - {device_info['device']}"
            name_bytes = name.encode('utf-8')
            
            server_init = struct.pack('!HHBBBBHHH',
                device_info['width'], device_info['height'],
                device_info['bpp'], device_info['depth'], 0, 0, 0, 0, 0, 0
            )
            server_init += struct.pack('!I', len(name_bytes))
            server_init += name_bytes
            
            client_socket.send(server_init)
            
            print(f"VNC handshake complete for {client_address}")
            
            # Add to clients list
            self.clients.append(client_socket)
            
            # Send periodic framebuffer updates (simplified)
            while self.running and client_socket in self.clients:
                try:
                    # Check for client messages
                    ready = select.select([client_socket], [], [], 0.1)
                    if ready[0]:
                        msg_type = client_socket.recv(1)
                        if not msg_type:
                            break
                            
                        if msg_type[0] == 3:  # KeyEvent
                            client_socket.recv(7)  # Skip key event data
                        elif msg_type[0] == 5:  # PointerEvent
                            client_socket.recv(5)  # Skip pointer event data
                    
                    # Send framebuffer update periodically
                    time.sleep(self.screenshot_interval)
                    # self.encode_rfb_frame(client_socket, b"")
                    
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
        """Start VNC server."""
        import select
        
        self.running = True
        
        try:
            self.server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
            self.server_socket.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
            self.server_socket.bind(('0.0.0.0', self.port))
            self.server_socket.listen(5)
            
            device_info = self.get_device_info()
            print(f"VNC Server starting on port {self.port}")
            print(f"Screen: {device_info['width']}x{device_info['height']}")
            print(f"Device: {device_info['device']}")
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
    """Main entry point for PoC."""
    import sys
    
    print("=== VNCAdapter Proof of Concept ===")
    print("Android Screen Mirror via VNC Protocol")
    
    # Check ADB
    adb_path = "adb"
    if not os.path.exists(adb_path):
        adb_path = "/usr/local/bin/adb"
    
    if not os.path.exists(adb_path):
        print("Error: ADB not found. Please install adb.")
        sys.exit(1)
    
    # Check device connection
    try:
        result = subprocess.run([adb_path, "devices"], capture_output=True, text=True)
        if "device" not in result.stdout:
            print("Warning: No Android device connected via ADB")
            print("Connect device via USB first")
    except:
        print("Warning: Could not check ADB devices")
    
    # Start server
    adapter = VNCAdapter(adb_path=adb_path, port=5901)
    try:
        adapter.start_server()
    except KeyboardInterrupt:
        print("\nShutting down...")
    finally:
        adapter.stop_server()

if __name__ == "__main__":
    main()
