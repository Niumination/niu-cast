#!/usr/bin/env python3
"""
Test ADB integration dengan VNC server.
"""

import sys
import os
sys.path.insert(0, os.path.join(os.path.dirname(os.path.abspath(__file__)), 'niu_cast'))
sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))

def test_adb_detection():
    """Test ADB device detection."""
    print("\n=== Testing ADB Detection ===")
    
    try:
        from vnc_adapter_v2 import VNCAdapter
        adapter = VNCAdapter(port=5903)  # Use different port
        
        # Try to initialize ADB
        adb_ready = adapter.init_adb()
        if adb_ready:
            print(f"✅ ADB device detected: {adapter.device_serial}")
            print(f"✅ Screen resolution: {adapter.screen_width}x{adapter.screen_height}")
            return True
        else:
            print("⚠️  No ADB device detected or ADBController not available")
            return False
    except Exception as e:
        print(f"❌ Error: {e}")
        return False

def test_screen_capture():
    """Test screen capture via ADB."""
    print("\n=== Testing Screen Capture ===")
    
    try:
        from vnc_adapter_v2 import VNCAdapter
        adapter = VNCAdapter(port=5904)
        adapter.init_adb()  # Try to initialize
        
        if adapter.device_connected:
            screen_data = adapter.capture_screen_adb()
            if screen_data:
                print(f"✅ Screen capture successful: {len(screen_data)} bytes")
                return True
            else:
                print("❌ Screen capture failed")
                return False
        else:
            print("⚠️  Skipping screen capture test (no device)")
            return None
    except Exception as e:
        print(f"❌ Error: {e}")
        return False

def test_vnc_handshake_with_adb():
    """Test VNC server handshake with ADB integration."""
    print("\n=== Testing VNC Server with ADB ===")
    
    import threading
    import time
    import socket
    
    try:
        from vnc_adapter_v2 import VNCAdapter
        adapter = VNCAdapter(port=5905)
        
        # Start server in background thread
        server_thread = threading.Thread(target=adapter.start_server)
        server_thread.daemon = True
        server_thread.start()
        
        time.sleep(2)  # Let server start
        
        # Try to connect
        try:
            sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
            sock.settimeout(3)
            sock.connect(('localhost', 5905))
            
            # Receive RFB version
            version = sock.recv(12)
            print(f"✅ Server responded: {version.decode().strip()}")
            
            sock.close()
            print("✅ VNC handshake successful")
            return True
        except Exception as e:
            print(f"❌ Connection failed: {e}")
            return False
        finally:
            adapter.stop_server()
            time.sleep(1)
    except Exception as e:
        print(f"❌ Error: {e}")
        return False

if __name__ == "__main__":
    print("VNC Server ADB Integration Test")
    print("=" * 40)
    
    # Run tests
    test1 = test_adb_detection()
    test2 = test_screen_capture()
    test3 = test_vnc_handshake_with_adb()
    
    print("\n=== Test Summary ===")
    print(f"ADB Detection: {'✅' if test1 else '❌'}")
    print(f"Screen Capture: {'✅' if test2 is True else '❌' if test2 is False else '⚠️'}")
    print(f"VNC Handshake: {'✅' if test3 else '❌'}")
    
    if test1 and test3:
        print("\n✅ ADB Integration READY untuk Phase 1")
    else:
        print("\n⚠️  Some tests failed. Check ADB connection.")
