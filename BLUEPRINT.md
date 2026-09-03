# niu-cast v4.0 — BLUEPRINT & PRD

> **Status:** Draft untuk review  
> **Target:** Adaptasi arsitektur DroidMirroring-mac ke niu-cast  
> **Prinsip:** Tidak masalah rubah stack, yang penting tujuan tercapai

---

## 1. Executive Summary

niu-cast v3.7 (Python + PyQt5 + VNC/RFB) gagal mencapai tujuan utama: **Android screen mirror ke Mac yang reliable**. VNC handshake tidak kompatibel dengan macOS Screen Sharing.app, latency ~100ms (raw/RFB), dan Joy Connect QR belum bekerja.

**DroidMirroring-mac** (Swift + SwiftUI + scrcpy + VideoToolbox) sudah membuktikan bahwa target ini achievable dengan latency <80ms. niu-cast v4.0 akan mengadopsi arsitektur yang sama, dengan tambahan unique value: **Joy Connect / TCCP protocol support** (yang tidak ada di DroidMirroring).

---

## 2. Masalah & Solusi

### Masalah v3.7

| Masalah | Root Cause | Dampak |
|---|---|---|
| VNC gagal di macOS | Handshake RFB 3.3 tidak benar, VNC auth bermasalah | Tidak bisa mirror |
| Latency tinggi (~100ms) | Raw/RFB encoding tidak di-compress | Tidak responsif |
| Input terbatas | ADB send_keyevent (slow, tidak semua key) | Keyboard/mouse tidak sempurna |
| Joy Connect QR | Protocol Transsion proprietary, experimental | Tidak bisa tanpa USB |
| UI usang | PyQt5 single window, tabs | Tidak macOS-native |

### Solusi v4.0

| Solusi | Sumber | Benefit |
|---|---|---|
| H.265 VideoToolbox decode | DroidMirroring MirrorEngine | <80ms latency |
| UHID keyboard (kernel) | DroidMirroring UHIDKeyboard | Full keyboard support |
| Scrcpy server | DroidMirroring ScrcpyClient | Proven stable |
| mDNS Device Discovery | DroidMirroring DeviceDiscovery | Auto-detect device |
| Wi-Fi Pairing (Android 11+) | DroidMirroring ADBKit | Tanpa USB |
| SwiftUI multi-window | DroidMirroring Scenes | macOS native UX |
| TCCP / Joy Connect | niu-cast existing | Unique value |

---

## 3. Arsitektur Target

### High-Level

```
┌─────────────────────────────────────────────────────────────┐
│                        niu-cast v4.0                        │
├─────────────────────────────────────────────────────────────┤
│  SwiftUI Layer (App/Scenes)                                 │
│  ┌──────────┐ ┌──────────┐ ┌──────────┐ ┌──────────┐       │
│  │MainView  │ │MirrorWin │ │FilesWin  │ │Settings  │       │
│  └──────────┘ └──────────┘ └──────────┘ └──────────┘       │
├─────────────────────────────────────────────────────────────┤
│  ViewModels Layer                                           │
│  ┌──────────────────┐ ┌──────────────┐ ┌──────────────┐    │
│  │SessionCoordinator│ │UHIDKeyboard  │ │FilesViewModel│    │
│  └──────────────────┘ └──────────────┘ └──────────────┘    │
├─────────────────────────────────────────────────────────────┤
│  Packages (SPM)                                             │
│  ┌────────┐ ┌────────┐ ┌────────┐ ┌────────┐ ┌────────┐   │
│  │ADBKit  │ │Scrcpy  │ │Mirror  │ │Fusion  │ │Device  │   │
│  │        │ │Client  │ │Engine  │ │Engine  │ │Discov  │   │
│  └────────┘ └────────┘ └────────┘ └────────┘ └────────┘   │
│  ┌──────────────────────────────────────────────────────┐   │
│  │              TCCPKit (unique)                         │   │
│  │  Joy Connect / QR Scan / Wireless Debug Bridge        │   │
│  └──────────────────────────────────────────────────────┘   │
├─────────────────────────────────────────────────────────────┤
│  Resources                                                  │
│  ┌────────────────┐ ┌────────────────┐ ┌────────────────┐  │
│  │adb (bundled)   │ │scrcpy-server   │ │TCCP Tools      │  │
│  └────────────────┘ └────────────────┘ └────────────────┘  │
└─────────────────────────────────────────────────────────────┘
```

### Packages Detail

| Package | Responsibility | Reference |
|---|---|---|
| **ADBKit** | ADB communication, wireless pairing, device list | DroidMirroring ADBKit |
| **ScrcpyClient** | scrcpy-server management, socket I/O | DroidMirroring ScrcpyClient |
| **MirrorEngine** | VideoToolbox decode, Metal rendering | DroidMirroring MirrorEngine |
| **FusionEngine** | Session orchestration, ADB+scrcpy launch | DroidMirroring FusionEngine |
| **DeviceDiscovery** | mDNS/Bonjour, device auto-detect | DroidMirroring DeviceDiscovery |
| **TCCPKit** | Joy Connect protocol, QR generator, Transsion handshake | niu-cast existing |

### Kept from niu-cast v3.x

| Module | Alasan |
|---|---|
| `tccp_qr.py` | QR generator logic — pindah ke TCCPKit |
| `tccp_server.py` | TCCP server — pindah ke TCCPKit |
| `auto_connect.py` | mDNS discovery — pindah ke DeviceDiscovery |
| `mac_connect_bridge.py` | ADB wireless setup — pindah ke ADBKit |
| `file_browser.py` | File manager — pindah ke FilesViewModel |
| `transsion_protocol.py` | Protocol parser — pindah ke TCCPKit |

---

## 4. Rencana Implementasi

### Phase 1: Foundation (Minggu 1-2)

**Goal:** Project skeleton + ADB communication

| Task | Deliverable | Verification |
|---|---|---|
| Setup XcodeGen project | `project.yml` + `xcodegen generate` sukses | `xcodegen generate` exit 0 |
| Implement ADBKit core | ADB device list, connect, shell | `adb devices` parsed correctly |
| Bundle ADB binary | Resources/adb/macos/ | App launches with bundled ADB |
| MainView skeleton | Window dengan device list kosong | App launch → empty state |
| README update | Build instructions | Build dari README berhasil |

**Definition of Done:**
- `xcodegen generate` sukses
- App launch tanpa crash
- Device list muncul (saat ada device USB)

### Phase 2: Mirror Engine (Minggu 3-4)

**Goal:** Screen mirroring via scrcpy

| Task | Deliverable | Verification |
|---|---|---|
| Implement ScrcpyClient | scrcpy-server launch, socket connect | Video stream diterima |
| Implement MirrorEngine | VideoToolbox decode + Metal render | Frame muncul di window |
| MirrorWindow UI | Window dengan video surface | Latency < 100ms |
| SessionCoordinator | Launch/stop session | Reconnect setelah disconnect |

**Definition of Done:**
- Mirror muncul di window terpisah
- Latency < 100ms (ukur dengan high-speed camera)
- Reconnect otomatis saat device disconnect/reconnect

### Phase 3: Input & Control (Minggu 5-6)

**Goal:** Keyboard + mouse input

| Task | Deliverable | Verification |
|---|---|---|
| Implement UHIDKeyboard | Kernel-level keyboard input | Semua key bekerja di Android |
| Mouse click/tap | Touch simulation via scrcpy | Click di Mac → tap di Android |
| ClipboardBridge | Two-way clipboard sync | Copy-paste bolak-balik |
| MirrorEventView | Touch/keyboard event handling | Scroll, drag, multi-touch |

**Definition of Done:**
- Keyboard penuh berfungsi (termasuk special keys)
- Mouse click → tap akurat
- Clipboard sync < 1s delay

### Phase 4: File Manager & Discovery (Minggu 7-8)

**Goal:** File transfer + wireless pairing

| Task | Deliverable | Verification |
|---|---|---|
| Implement FilesViewModel | File list, push/pull, delete | Transfer file berhasil |
| FilesWindow UI | File browser dengan drag-drop | Drag file dari Mac → Android |
| Implement DeviceDiscovery | mDNS auto-detect | Device muncul tanpa IP manual |
| Wi-Fi Pairing UI | Pairing code input | Pair tanpa USB |
| Samsung DeX support | Desktop mode | DeX mode muncul |

**Definition of Done:**
- File transfer reliable (100+ MB file)
- Device auto-detect via mDNS
- Wi-Fi pairing berhasil (Android 11+)
- Samsung DeX mode berfungsi (jika device support)

### Phase 5: TCCP/Joy Connect (Minggu 9-10)

**Goal:** Unique value — Joy Connect protocol

| Task | Deliverable | Verification |
|---|---|---|
| Port tccp_qr.py ke Swift | QR generator native | QR muncul di screen |
| Port tccp_server.py ke Swift | TCCP server native | Server listen di port 9452/8613 |
| Joy Connect integration | Scan QR → connect | Connection established |
| Protocol documentation | TCCP v1 spec | Dokumentasi lengkap |

**Definition of Done:**
- QR generate + display
- Server listen dan respond 7-frame handshake
- Connection established via Joy Connect

---

## 5. Struktur Proyek Baru

```
niu-cast/
├── project.yml                    ← XcodeGen source of truth
├── niu-cast.xcodeproj             ← GENERATED
├── Scripts/
│   ├── build.sh
│   ├── bootstrap.sh               ← fetch scrcpy-server + adb
│   └── bundle_dependencies.sh
├── App/
│   ├── niu_castApp.swift          ← @main
│   ├── Scenes/
│   │   ├── MainView.swift
│   │   ├── MirrorWindow.swift
│   │   ├── MirrorEventView.swift
│   │   ├── FilesWindow.swift
│   │   ├── SettingsView.swift
│   │   └── PairingWindow.swift
│   ├── ViewModels/
│   │   ├── SessionCoordinator.swift
│   │   ├── ClipboardBridge.swift
│   │   ├── FilesViewModel.swift
│   │   ├── UHIDKeyboard.swift
│   │   └── DeviceListViewModel.swift
│   └── Resources/
│       ├── Assets.xcassets
│       ├── Info.plist
│       └── niu-cast.entitlements
├── Packages/
│   ├── ADBKit/
│   │   ├── Package.swift
│   │   └── Sources/
│   │       ├── ADBConnection.swift
│   │       ├── ADBDevice.swift
│   │       └── ADBWireless.swift
│   ├── ScrcpyClient/
│   │   ├── Package.swift
│   │   └── Sources/
│   │       ├── ScrcpyServer.swift
│   │       └── ScrcpySocket.swift
│   ├── MirrorEngine/
│   │   ├── Package.swift
│   │   └── Sources/
│   │       ├── VideoDecoder.swift
│   │       └── MetalRenderer.swift
│   ├── FusionEngine/
│   │   ├── Package.swift
│   │   └── Sources/
│   │       ├── FusionLauncher.swift
│   │       └── ScreenStateManager.swift
│   ├── DeviceDiscovery/
│   │   ├── Package.swift
│   │   └── Sources/
│   │       └── MDNSBrowser.swift
│   ├── TCCPKit/                    ← UNIQUE
│   │   ├── Package.swift
│   │   └── Sources/
│   │       ├── TCCPServer.swift
│   │       ├── TCCPQRGenerator.swift
│   │       └── TCCPHandshake.swift
│   └── SharedModels/
│       ├── Package.swift
│       └── Sources/
│           ├── Device.swift
│           ├── Session.swift
│           └── FileItem.swift
├── Helpers/
│   └── CLI/
│       ├── niu-cast-cli.swift      ← CLI entry point
│       └── Commands/
│           ├── MirrorCommand.swift
│           ├── FileCommand.swift
│           └── QRCommand.swift
├── docs/
│   ├── BUILDING.md
│   ├── ARCHITECTURE.md
│   └── TCCP_PROTOCOL.md
└── tests/
    ├── ADBKitTests/
    ├── ScrcpyClientTests/
    ├── MirrorEngineTests/
    └── TCCPKitTests/
```

---

## 6. Dependencies

### External (SPM)

| Package | Version | Purpose |
|---|---|---|
| `swift-argument-parser` |latest | CLI parsing |
| `swift-log` | latest | Logging |
| `swift-async-algorithms` | latest | Async sequences |

### Bundled

| Binary | Version | Source |
|---|---|---|
| `adb` | 37.0.1+ | Android SDK |
| `scrcpy-server.jar` | 4.1 | Genymobile |

### System Requirements

| Requirement | Minimum |
|---|---|
| macOS | 15.0 (Sequoia) |
| Xcode | 16.0+ |
| Swift | 6.0+ |
| Android | 7.0+ (mirror), 11+ (wireless pairing) |

---

## 7. Success Metrics

| Metric | Target | Measurement |
|---|---|---|
| Mirror latency | < 80ms | High-speed camera |
| Frame rate | 60 FPS | `scrcpy --max-fps 60` |
| Input latency | < 20ms | Click-to-response |
| App launch time | < 2s | Cold start |
| Memory usage | < 200MB | Activity Monitor |
| CPU usage | < 30% | Activity Monitor (Apple Silicon) |
| Wi-Fi pairing success | > 95% | 10 trial |
| mDNS discovery | < 3s | Device appear time |
| File transfer | > 50 MB/s | 100MB file transfer |

---

## 8. Risk & Mitigation

| Risk | Likelihood | Impact | Mitigation |
|---|---|---|---|
| Tidak ada Xcode di mesin ini | High | Build blocked | CI/CD GitHub Actions, atau build di mesin lain |
| VideoToolbox Swift complexity | Medium | Delay | Mulai dengan AKScreencapture fallback |
| UHID kernel rejection | Medium | Keyboard tidak berfungsi | Fallback ke ADB input |
| scrcpy-server compatibility | Low | Mirror ganti | Test dengan scrcpy 4.x |
| TCCP protocol berubah | High | QR tidak berfungsi | Protocol sniffing, version negotiation |

---

## 9. Migration Path

### Dari v3.7 ke v4.0

```
v3.7 (Python)                    v4.0 (Swift)
─────────────                    ─────────────
core.py (GUI)        ──────────→ Scenes/Window.swift
adb_controller.py    ──────────→ ADBKit
mac_connect_bridge.py ─────────→ FusionEngine + ADBWireless
mini.py (CLI)        ──────────→ CLI/Commands/
file_browser.py      ──────────→ FilesViewModel
tccp_qr.py           ──────────→ TCCPKit/QRGenerator
tccp_server.py       ──────────→ TCCPKit/Server
auto_connect.py      ──────────→ DeviceDiscovery
vnc_adapter*.py      ──────────→ MirrorEngine (replaced)
```

### Backward Compatibility

- CLI commands dipertahankan (mirror, file, qr, server)
- Config file `~/.niu-cast/` tetap dipakai
- Tidak ada breaking change untuk end-user

---

## 10. Timeline

| Phase | Minggu | Deliverable |
|---|---|---|
| Phase 1 | 1-2 | Project skeleton + ADBKit + MainView |
| Phase 2 | 3-4 | MirrorEngine + ScrcpyClient + MirrorWindow |
| Phase 3 | 5-6 | UHIDKeyboard + ClipboardBridge + Input |
| Phase 4 | 7-8 | FilesViewModel + DeviceDiscovery + Wi-Fi pairing |
| Phase 5 | 9-10 | TCCPKit + Joy Connect |
| Buffer | 11-12 | Testing, bugfix, documentation |

**Total:** 12 minggu (~3 bulan)

---

## 11. Open Questions

1. **Build environment:** Mesin ini tidak punya Xcode.app. Opsi:
   - (A) CI/CD GitHub Actions untuk build
   - (B) Build di mesin lain (Mac Mini, Hackintosh)
   - (C) Install Xcode.app (butuh 12GB+ storage)

2. **Python tools:** Apakah tools Python (qr generator, protocol analyzer) tetap dipertahankan sebagai standalone CLI, atau diintegrasikan ke Swift?

3. **Distribution:** DMG notarized? atau Homebrew?

4. **TCCP Priority:** TCCP/Joy Connect di Phase 5 (rendah), atau naik ke Phase 2 (high priority)?

---

**Next Steps:**
1. Review dan approve blueprint ini
2. Setup project skeleton (Phase 1)
3. Mulai development
