#!/usr/bin/env python3
"""
Integration script untuk menambahkan VNC mode ke niu-cast.
"""

import sys
import os
sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))

from vnc_adapter import VNCAdapter
import subprocess
import time

def setup_wireless_adb():
    """Setup ADB wireless connection (mirip niu-cast)."""
    print("Setting up ADB wireless...")
    
    # Check if device is connected via USB
    result = subprocess.run(["adb", "devices"], capture_output=True, text=True)
    if "device" not in result.stdout:
        print("No device connected via USB. Please connect device first.")
        return False
    
    # Enable TCP/IP mode
    try:
        subprocess.run(["adb", "tcpip", "5555"], check=True, timeout=10)
        print("ADB TCP/IP mode enabled (port 5555)")
        time.sleep(2)
        
        # Get device IP
        result = subprocess.run(
            ["adb", "shell", "ip route | grep src | awk '{print $9}'"],
            shell=True, capture_output=True, text=True
        )
        if result.stdout.strip():
            ip = result.stdout.strip()
            print(f"Device IP: {ip}")
            
            # Connect wirelessly
            subprocess.run(["adb", "connect", f"{ip}:5555"], check=True)
            print(f"Connected to {ip}:5555")
            return True
    except Exception as e:
        print(f"Wireless setup failed: {e}")
    
    return False

def start_vnc_mode():
    """Start VNC server mode."""
    print("=== niu-cast VNC Mode ===")
    print("1. Wireless setup")
    print("2. Start VNC server")
    print("3. Connect via macOS Screen Sharing")
    print()
    
    # Setup wireless
    if not setup_wireless_adb():
        print("Falling back to USB mode...")
    
    # Start VNC server
    adapter = VNCAdapter(port=5901)
    print("\nStarting VNC server...")
    print(f"Connect with: Screen Sharing.app -> vnc://localhost:5901")
    print("or use: open vnc://localhost:5901")
    print("\nPress Ctrl+C to stop")
    
    try:
        adapter.start_server()
    except KeyboardInterrupt:
        print("\nStopping VNC server...")
    finally:
        adapter.stop_server()

if __name__ == "__main__":
    start_vnc_mode()
