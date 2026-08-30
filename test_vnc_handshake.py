#!/usr/bin/env python3
"""Test VNC server handshake only."""
import socket
import time

def test_vnc_handshake():
    """Test basic VNC server connectivity."""
    print("Testing VNC server handshake...")
    
    # Start server in separate thread
    import threading
    from vnc_adapter import VNCAdapter
    
    adapter = VNCAdapter(port=5902)
    adapter.screenshot_interval = 1.0  # Slow updates for test
    
    server_thread = threading.Thread(target=adapter.start_server)
    server_thread.daemon = True
    server_thread.start()
    
    time.sleep(2)  # Let server start
    
    # Try to connect
    try:
        sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        sock.settimeout(3)
        sock.connect(('localhost', 5902))
        
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

if __name__ == "__main__":
    test_vnc_handshake()
