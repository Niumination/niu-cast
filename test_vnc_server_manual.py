#!/usr/bin/env python3
"""Manual test for VNC server — simulates what core.py does."""
import sys
import socket
import threading
import time

sys.path.insert(0, '.')
from vnc_adapter_v2 import VNCAdapter

print("=== VNC Server Manual Test ===\n")

# Start VNC server in daemon thread (sama seperti fix di core.py)
adapter = VNCAdapter(port=5901)
t = threading.Thread(target=adapter.start_server, daemon=True)
t.start()
time.sleep(1)

# Test 1: Port listening
print("TEST 1: Port 5901 listening")
s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
s.settimeout(2)
try:
    s.connect(('localhost', 5901))
    print("  PASS")
except Exception as e:
    print(f"  FAIL: {e}")
    sys.exit(1)

# Test 2: RFB handshake
print("TEST 2: RFB Protocol Version")
ver = s.recv(12).decode()
assert 'RFB 003.008' in ver, f"Unexpected: {ver}"
print(f"  PASS ({ver.strip()})")

# Test 3: Security handshake
print("TEST 3: Security Handshake")
# Send client version
s.send(b'RFB 003.008\n')
time.sleep(0.1)
# Read security types (2 bytes: num_types + type)
sec = s.recv(2)
if len(sec) == 2:
    num_types = sec[0]
    print(f"  PASS (offers {num_types} type(s))")
elif len(sec) == 1:
    num_types = sec[0]
    s.recv(1)  # read the type byte
    print(f"  PASS (offers {num_types} type(s))")
else:
    print(f"  FAIL: got {len(sec)} bytes")
    sys.exit(1)

# Select None (type 1)
s.send(b'\x01')
time.sleep(0.1)
result = s.recv(4)
if result == b'\x00\x00\x00\x00':
    print("  PASS (security OK)")
elif len(result) < 4:
    # Try to read remaining bytes
    result += s.recv(4 - len(result))
    if result == b'\x00\x00\x00\x00':
        print("  PASS (security OK)")
    else:
        print(f"  FAIL: security result = {result}")
        sys.exit(1)
else:
    print(f"  FAIL: security result = {result}")
    sys.exit(1)

# Test 4: ClientInit + ServerInit
print("TEST 4: ClientInit + ServerInit")
s.send(b'\x01')  # shared flag
time.sleep(0.1)
server_init = s.recv(100)
if len(server_init) > 0:
    print(f"  PASS ({len(server_init)} bytes)")
else:
    print("  FAIL: no ServerInit")
    sys.exit(1)

s.close()
print()

# Test 5: Server status
print("TEST 5: Server Status")
print(f"  Running: {adapter.running}")
print(f"  Port: {adapter.port}")
print(f"  Screen: {adapter.screen_width}x{adapter.screen_height}")
print(f"  Device: {adapter.device_connected}")
print()

# Cleanup
adapter.stop_server()
print("TEST 6: Server stopped cleanly")
print()
print("=== All tests passed ===")
