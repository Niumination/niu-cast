#!/usr/bin/env python3
"""End-to-end VNC server test with connected Android device."""
import sys
import socket
import threading
import time

sys.path.insert(0, '.')
from vnc_adapter_v2 import VNCAdapter

print("=== VNC Server E2E Test with Device ===\n")

# Start VNC server
adapter = VNCAdapter(port=5901)

# Verify device detected
print("Step 1: Initialize ADB connection")
if adapter.init_adb():
    print(f"  Device: {adapter.device_serial}")
    print(f"  Resolution: {adapter.screen_width}x{adapter.screen_height}")
else:
    print("  WARNING: No device detected, test may fail")

# Start server in daemon thread
t = threading.Thread(target=adapter.start_server, daemon=True)
t.start()
time.sleep(1)

print("\nStep 2: Connect VNC client")
s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
s.settimeout(5)
s.connect(('localhost', 5901))

# Handshake
ver = s.recv(12).decode()
print(f"  RFB Version: {ver.strip()}")

# Send client version + receive security
s.sendall(b'RFB 003.008\n')
time.sleep(0.3)

# Try to read all available data at once
s.setblocking(False)
sec_data = b''
for _ in range(10):
    try:
        chunk = s.recv(10)
        if chunk:
            sec_data += chunk
        else:
            break
    except BlockingIOError:
        break

print(f"  Security data: {len(sec_data)} bytes received")
if len(sec_data) >= 2:
    print(f"  ✅ Security handshake: PASS")
else:
    print(f"  ⚠️ Incomplete security data")

# Send client init
s.setblocking(True)
s.settimeout(2)
s.sendall(b'\x01')  # select None security
time.sleep(0.2)

s.sendall(b'\x01')  # shared flag
time.sleep(0.3)

# Try to receive ServerInit
try:
    s.setblocking(False)
    server_init = b''
    for _ in range(10):
        try:
            chunk = s.recv(100)
            if chunk:
                server_init += chunk
            else:
                break
        except BlockingIOError:
            break
    
    if server_init:
        print(f"  ✅ ServerInit: PASS ({len(server_init)} bytes)")
    else:
        print(f"  ⚠️ No ServerInit received")
except Exception as e:
    print(f"  ServerInit error: {e}")

print("\nStep 3: Wait for frame updates (3 seconds)")
print("  (VNC server sends framebuffer via ADB screencap)")
time.sleep(3)

# Check if we received any data
s.setblocking(False)
frame_data = b''
for _ in range(20):
    try:
        chunk = s.recv(8192)
        if chunk:
            frame_data += chunk
        else:
            break
    except BlockingIOError:
        break

if frame_data:
    print(f"  ✅ Received {len(frame_data)} bytes of framebuffer data")
else:
    print(f"  ⚠️ No frame data received (non-blocking check)")

s.close()
print("\nStep 4: Cleanup")
adapter.stop_server()
print("  Server stopped")

print("\n=== Test Complete ===")
print(f"Device: {adapter.device_serial}")
print(f"Device connected: {adapter.device_connected}")
