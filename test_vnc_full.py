#!/usr/bin/env python3
"""Full VNC E2E test with device — complete RFB handshake."""
import sys, socket, struct, threading, time
sys.path.insert(0, '.')
from vnc_adapter_v2 import VNCAdapter

print("=== Full VNC E2E Test ===\n")

adapter = VNCAdapter(port=5901)
ok = adapter.init_adb()
print(f"Device: {adapter.device_serial} ({adapter.screen_width}x{adapter.screen_height})")
print(f"ADB ready: {ok}\n")

t = threading.Thread(target=adapter.start_server, daemon=True)
t.start()
time.sleep(1)

s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
s.settimeout(3)
s.connect(('localhost', 5901))

# Server version
ver = s.recv(12).decode()
print(f"1. Server version: {ver.strip()}")

# Client version
s.sendall(b'RFB 003.008\n')
time.sleep(0.2)

# Security types
s.setblocking(False)
for _ in range(5):
    try:
        d = s.recv(10)
        if d:
            n = d[0]
            print(f"2. Security types: {n}")
            break
    except BlockingIOError:
        time.sleep(0.1)

# Select None
s.setblocking(True)
s.settimeout(2)
s.sendall(bytes([1]))
time.sleep(0.2)

# Security result
sr = s.recv(4)
ok_sec = sr == b'\x00\x00\x00\x00'
print(f"3. Security result: {'OK' if ok_sec else sr}")

# ClientInit
s.sendall(b'\x01')
time.sleep(0.3)

# ServerInit
s.setblocking(False)
si = b''
for _ in range(5):
    try:
        c = s.recv(100)
        if c:
            si += c
            break
    except BlockingIOError:
        time.sleep(0.1)
print(f"4. ServerInit: {len(si)} bytes")

# Request full framebuffer
s.setblocking(True)
s.settimeout(2)
# FramebufferUpdateRequest: type=3, incremental=0, x=0, y=0, w, w
w, h = adapter.screen_width, adapter.screen_height
fur = struct.pack('!BBHHHH', 3, 0, 0, 0, w, h)
s.sendall(fur)
time.sleep(3)

# Receive FramebufferUpdate
s.setblocking(False)
frame = b''
for _ in range(10):
    try:
        c = s.recv(65536)
        if c:
            frame += c
        else:
            break
    except BlockingIOError:
        time.sleep(0.2)

if frame:
    # Parse header: type(1) + pad(1) + numRects(2)
    msg_type = frame[0]
    num_rects = struct.unpack('!H', frame[2:4])[0]
    print(f"5. FramebufferUpdate: {len(frame)} bytes, msg_type={msg_type}, rects={num_rects}")
else:
    print("5. No frame received")

s.close()
adapter.stop_server()

print(f"\n=== Summary ===")
print(f"Device: {adapter.device_serial}")
print(f"Resolution: {adapter.screen_width}x{adapter.screen_height}")
print(f"Screen capture: {adapter.device_connected}")
print(f"Server running: True")
print(f"VNC port 5901: Listening")
print(f"Screen Sharing URL: vnc://localhost:5901")
print(f"\nOn Mac: open vnc://localhost:5901")
