# Roadmap VNC Mode untuk niu-cast v3.7

## Tujuan
Enable Android screen mirror via macOS native Screen Sharing.app menggunakan VNC protocol.

## Current Status (Proof of Concept)
✅ Basic VNC server implementation (`vnc_adapter.py`)
✅ RFB protocol handshake working
✅ Modular design ready for ADB integration
❌ Real screen capture from ADB
❌ Input event forwarding
❌ Performance optimization

## Phase 1: ADB Integration (1-2 minggu)
- [ ] Capture real Android screen via `adb shell screencap -p`
- [ ] Convert PNG → RGB raw format
- [ ] Frame rate control (1-30 FPS)
- [ ] Resolution detection from device

## Phase 2: Input Handling (1 minggu)
- [ ] Forward mouse events from VNC client → ADB input
- [ ] Forward keyboard events
- [ ] Touch simulation for Android

## Phase 3: Performance (1 minggu)
- [ ] Frame encoding optimization
- [ ] Bandwidth management
- [ ] Quality settings (low/medium/high)
- [ ] Compression (optional)

## Phase 4: Integration (3-4 hari)
- [ ] CLI commands for VNC mode
- [ ] GUI tab in PyQt5 interface
- [ ] Settings persistence
- [ ] Auto-start with wireless connection

## Phase 5: Testing & Release (1 minggu)
- [ ] Test with macOS Screen Sharing.app
- [ ] Test with various VNC clients
- [ ] Performance benchmarks vs scrcpy
- [ ] Documentation update

## Technical Stack
- **Protocol:** RFB/VNC (port 5901)
- **Encoding:** Raw/RFB (initially), bisa extend ke tight encoding
- **Transport:** TCP/IP over WiFi
- **Backend:** ADB for screen capture + input
- **Frontend:** macOS Screen Sharing.app atau VNC client lain

## Files Created
1. `vnc_adapter.py` — VNC server implementation
2. `vnc_integration.py` — Integration with wireless setup
3. `test_vnc_handshake.py` — Test script
4. `ROADMAP_VNC_MODE.md` — This file

## Integration Points dengan niu-cast
- Reuse wireless setup dari `mac_connect_bridge.py`
- Reuse ADB controller dari `adb_controller.py`
- Add new tab "VNC" di GUI `core.py`
- Add CLI commands di `mini.py`

## Performance Targets
- Latency: < 150ms
- Frame rate: 15-30 FPS (adjustable)
- Resolution: Adaptive (based on network)
- CPU usage: < 30% on Mac

## Testing Checklist
- [ ] Connect via macOS Screen Sharing.app
- [ ] Connect via RealVNC Viewer
- [ ] Connect via TigerVNC
- [ ] Test mouse/keyboard input
- [ ] Test multiple clients
- [ ] Test different resolutions
- [ ] Test bandwidth usage

## Success Metrics
1. macOS Screen Sharing.app bisa connect ke Android
2. Latency acceptable untuk basic control
3. Input events work correctly
4. Memory/CPU usage reasonable

## Next Immediate Actions
1. Integrate ADB screen capture
2. Test with actual Android device
3. Create CLI command `niu-cast vnc`
4. Document connection instructions
