#!/usr/bin/env python3
"""Full VNC E2E test with device."""
import sys, struct, threading, time, socket, select, subprocess
sys.path.insert(0, '.')
from vnc_adapter_v2 import VNCAdapter

adapter = VNCAdapter(port=5901)
adapter.init_adb()
print(f"Device: {adapter.device_serial}")
print(f"Resolution: {adapter.screen_width}x{adapter.screen_height}")

t = threading.Thread(target=adapter.start_server, daemon=True)
t.start()
print("VNC server running on port 5901")

subprocess.run(["open", "vnc://localhost:5901"])
print("Waiting 20s...")
for i in range(20):
    time.sleep(1)
    n = len(adapter.clients)
    print(f"  {i+1}s: clients={n}")
adapter.stop_server()
