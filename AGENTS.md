# niu-cast — Project AGENTS.md

**Lokasi:** `niu-cast/`
**Stack:** Python 3.8+, PyQt5, ADB + TCP/IP
**Remote:** `github.com/Niumination/niu-cast`
**Versi:** v3.6.0 (Mac Connect Bridge — ADB wireless + scrcpy)
**Last Push:** 21 Jul 2026

## Overview

Android device manager via ADB + **TCCP (Transsion Cast Control Protocol)** reverse engineering.
Target: kontrol Infinix GT 30 Pro dari Mac tanpa USB debugging.

**v3.6.0** menggabungkan **mac-connect** (ADB wireless + scrcpy) sebagai metode koneksi
PRIMER yang TERBUKTI bekerja, sambil tetap mempertahankan TCCP protocol sebagai alternatif.

## Modul

| Modul | LOC | Fungsi |
|-------|-----|--------|
| `adb_controller.py` | 270 | Koneksi ADB, shell, push/pull, device info, screenshot + wireless setup |
| `core.py` | 730 | GUI PyQt5 — 4 tab (Screen + Files + Apps + Mac Connect) |
| `mini.py` | 519 | CLI — device info, screenshot, record, control, APK install |
| `mac_connect_bridge.py` | 585 | **🆕 Mac Connect Bridge** — ADB wireless + scrcpy mirror 🆕 |
| `file_browser.py` | 597 | File explorer Android via ADB |
| `transsion_protocol.py` | ~920 | TCCP protocol handler + UIBC builder + TranCastDiscoverer |
| `video_stream.py` | ~540 | Video stream receiver + integration tests (tanpa device) |
| `port_explorer.py` | ~260 | CLI tool untuk scan port TCCP tambahan |
| `tccp_server.py` | ~440 | TCCP Server (port 9452 — mDNS + 7 frame handshake) |
| `server_8613.py` | ~370 | TCCP Server port 8613 — Joy Connect QR (HTTP /ping + `%%%%` frame) |
| `tccp_qr.py` | ~330 | QR Code generator untuk Joy Connect scan |
| `auto_connect.py` | ~340 | Auto-connect wireless tanpa ADB (mDNS, tether, IPv6, scan) |
| `wfd_bridge.py` | ~250 | WiFi Direct bridge (butuh ADB) |
| `tetherd.py` | ~170 | USB Tether monitor daemon |

## Mac Connect Bridge (v3.6.0)

**Pendekatan baru:** ADB wireless + scrcpy — metode yang TERBUKTI bekerja untuk
Infinix GT 30 Pro, menggantikan Joy Connect/TCCP yang belum stabil.

### Flow

1. **Setup via USB** (sekali): Colok USB → `adb tcpip 5555` → ekstrak IP
2. **Connect Wireless**: ARP scan otomatis → `adb connect IP:5555`
3. **Mirror + Audio**: scrcpy dengan 3 profile performa

### 3 Performance Profile

| Profile | FPS | Bitrate | Use Case |
|---------|:---:|:-------:|----------|
| High    | 120 | 16 Mbps | GT 30 Pro 120Hz display |
| Normal  | 60  | 8 Mbps  | Daily use, balance |
| Eco     | 30  | 4 Mbps  | Battery saver |

### IP Extraction (Multi-Method)

1. `ip route` → extract src address
2. `ip addr show wlan0` → inet address
3. `getprop dhcp.wlan0.ipaddress` → DHCP lease

### Usage

```bash
# CLI — sequence lengkap
python3 -m niu_cast setup-wireless     # USB → tcpip 5555 (sekali)
python3 -m niu_cast wireless-connect   # ARP scan + connect
python3 -m niu_cast mirror             # scrcpy mirror

# CLI — all-in-one
python3 -m niu_cast mac-connect setup    # setup wireless
python3 -m niu_cast mac-connect connect  # connect + mirror
python3 -m niu_cast mac-connect mirror   # launch mirror
python3 -m niu_cast mac-connect status   # status

# GUI — Mac Connect tab
python3 -m niu_cast                      # buka GUI, pilih tab Mac Connect
```

### Config Persistence

- File: `~/.niu-cast/mac-connect.json`
- Fields: `phone_ip`, `profile`, `audio`
- Auto-save setiap perubahan

## TCCP Server — Joy Connect Mode

**Paradigma lama:** Kita yang jadi server, HP yang connect ke kita (mirip Joy Connect di Windows).
**Status:** ⚠️ Masih experimental — QR scan & mDNS belum bekerja stabil.

[remainder of TCCP Server section unchanged]

### Flow

1. **Mac** jalanin `TranCastServer` — buka port 9452 + register mDNS `_tranCast._tcp`
2. **HP** (Joy Connect) scan jaringan lihat Mac → user tap di HP
3. **HP** connect ke Mac:9452
4. **Server** kirim 7 frame awal (0x606, 0x404, 0x607, 0x62a, 0x615, 0x403, 0x900)
5. **HP** kirim CONN_AUTH (0x700) → **Server** respon AUTH_OK (0x701)
6. **Heartbeat** bidirectional via 0x0900 setiap ~30 detik

### Usage

```bash
# Jalanin server port 9452 (TCCP standard)
python3 -m niu_cast server                  # default port 9452
python3 -m niu_cast server --port 9452      # explicit
python3 -m niu_cast server --name "Mac-Zaryu"  # custom nama

# Jalanin server port 8613 (Joy Connect QR mode — frame format %%%%)
python3 -m niu_cast joyconnect              # default port 8613
python3 -m niu_cast joyconnect --port 8613  # explicit

# Generate QR code (Joy Connect QR scan)
python3 -m niu_cast qr --joyconnect         # mode Joy Connect (port 8613)
python3 -m niu_cast qr --port 9452          # TCCP standard port
python3 -m niu_cast qr --no-server          # hanya generate QR, tanpa server
python3 -m niu_cast qr --terminal           # tampilkan QR ASCII di terminal
```

### mDNS Service yang didaftarkan

```
_tranCast._tcp.local.  →  port 9452
  props:
    cmbSvc = '{"HandShake":9452, "ScreenCast":8008, "File":10001}'
```

### Class Key (tambahan)

| Class | Fungsi |
|-------|--------|
| `TranCastServer` | TCP server TCCP port 9452 — mDNS + 7 frame handshake |
| `TranCastServer8613` | TCP server TCCP port 8613 — Joy Connect QR (HTTP /ping + `%%%%` frame) 🆕 |
| `register_mdns()` | Async: daftarin mDNS service |
| `register_all_mdns()` | Async: daftarin semua service type Transsion |
| `unregister_mdns_all()` | Async: cabut semua mDNS |

## TCCP Protocol (v3.x)

### Dual Mode

| Mode | Server | Client connect | Arah inisiasi |
|:----:|--------|----------------|:-------------:|
| **Client** (`connect`) | HP (port 9452) | Mac → HP | HP advertise mDNS |
| **Server** (`server`) | Mac (port 9452) | HP → Mac | Mac advertise mDNS |

### Port Discovery

| Port | Fungsi | Status | Sumber |
|:----:|--------|:------:|--------|
| 9452 | TCCP handshake — fixed | ✅ Handshake OK | `w4/l1.java: S=9452` |
| 8613 | TCCP handshake alternatif — Joy Connect QR | ✅ `server_8613.py` integrated | `TCCPHandshakeSocketClient.MAIN_SOCKET_PORT` |
| 8008 | ScreenCast/Video | ⚪ Belum diexplore | field `port` di 0x0607 |
| 9542 | Control channel | ⚪ Belum diexplore | field `controlPort` di 0x0607 |
| 10001 | File transfer | ⚪ Belum diexplore | field `filePort` di 0x0607 |

### API Key (dari ITCCPSourceApi)

| Method | Fungsi |
|--------|--------|
| `connectTccpServer(host, port)` | Connect ke TCCP server |
| `disconnectTccpServer()` | Disconnect |
| `startTCCPServer(port)` | Start TCCP server di port tertentu |
| `stopTCCPServer()` | Stop server |
| `enableFeature("uibc", bool)` | Enable/disable UIBC |
| `responseAuth(accept, trust)` | Respon AUTH (accept + trust device) |
| `updateMirrorWindowPoint(x, y)` | Update posisi mouse |
| `executeAction(action, params)` | Execute action generic |
| `castMainScreen()` | Mirror main screen |
| `stopAllCastVideo()` | Stop video casting |

### Connect Types (dari SDK)

| Type | Value |
|------|:-----:|
| `CONNECT_TYPE_USB` | 1 |
| `CONNECT_TYPE_P2P` | 2 |
| `CONNECT_TYPE_WIFI` | 3 |

### TCCP States

| State | Value | Description |
|-------|:-----:|-------------|
| `STATE_CONNECTED` | 1 | Connected |
| `STATE_WAITING` | 2 | Waiting for auth |
| `STATE_STOP` | 3 | Stopped |
| `STATE_MIRROR_CASTING` | 4 | Mirroring active |
| `STATE_EXTEND_SCREEN` | 5 | Extend screen mode |

### Wire Format (dari live capture + Java TCCPPacket)

Confirmed:
- Magic: `TCCP` (4 bytes)
- Version: 1 byte (0x00=client, 0xFF=server)
- Body length: 4 bytes BE (= 15 + payload_len)
- Operator: 2 bytes BE (opcode)
- Message ID: 4 bytes BE
- Timestamp: 8 bytes BE (microseconds)
- JSON payload: N bytes UTF-8
- Terminator: 0x00

Java class `TCCPPacket` confirms:
- `isResp` (boolean) — apakah response
- `operationFlag` (byte[2]) — opcode 2 bytes
- `stateCode` (Integer) — optional status code
- `payloadJson` (String) — JSON payload

### Class Key

| Class | Fungsi |
|-------|--------|
| `TCCPFrame` | Encode/decode frame TCCP (magic TCCP + opcode + JSON payload) |
| `TranCastProtocol` | TCP client: connect, AUTH, bidirectional heartbeat, request/response |
| `TranCastMultiPort` | Manager untuk semua port TCCP (9452, 8008, 9542, 10001) |
| `UIBCBuilder` | Bangun packet UIBC: touch, keyboard, mouse |
| `TranCastDiscoverer` | mDNS discovery (_tranCast, _tranFile, _tran, _tccp) |
| `TranCastServer` | TCP server TCCP port 9452 — mDNS + 7 frame handshake |
| `TranCastServer8613` | TCP server TCCP port 8613 — QR Joy Connect (`%%%%` frame + CRC8) 🆕 |
| `TCCPHandler` (server_8613) | Handler protocol TCCP port 8613: HTTP /ping + TCCP binary 🆕 |

## Wireless Mode Strategy

Tanpa ADB, auto_connect.py mencoba 4 metode berurutan:

| # | Metode | Deskripsi | Status |
|:-:|--------|-----------|:------:|
| 1 | **mDNS** | Discover device di jaringan lokal via zeroconf | ✅ Live |
| 2 | **USB Tether** | Deteksi interface 192.168.42.x/43.x, gateway = HP | ✅ Live |
| 3 | **IPv6 Link-Local** | Cari MAC prefix `2e:8c:a8` di NDP table | ✅ Live |
| 4 | **Subnet Scan** | TCP scan port 9452 ke seluruh subnet | ✅ Live |

Usage: `python3 -m niu_cast connect` (auto, sekali) atau `python3 -m niu_cast monitor` (loop)

---

## macOS Native Installation (v3.6.0+)

NIU CAST sekarang bisa diinstall sebagai aplikasi macOS native dengan CLI terintegrasi.

### Quick Install

```bash
cd /Users/zaryu/Desktop/Niumination/projects/niu-cast
./mac_install.sh
```

Ini akan:
1. Install **NIU CAST.app** ke `/Applications` — bisa dibuka dari Launchpad
2. Install **`niu-cast`** CLI ke PATH (`~/.local/bin/niu-cast`)
3. Buat symlink repo di `~/.niu-cast/repo` untuk update mudah

### Setelah Install

- **Buka app:** Cari "NIU CAST" di Launchpad / Applications
- **CLI:** `niu-cast mc status`, `niu-cast mirror`, dll
- **Update:** `cd niu-cast && git pull && ./mac_install.sh`

### Standalone Build (py2app)

Untuk distribusi tanpa dependensi Python:

```bash
./mac_install.sh --py2app
```

Build memakan waktu 2-5 menit, bundle ~150-200 MB.

### Uninstall

```bash
./mac_install.sh --uninstall
```

Config (`~/.niu-cast/`) tidak dihapus.

---

## Roadmap

1. ✅ **v2.0** — Refactor, buang bloat
2. ✅ **v3.0** — TCCP handshake discovery + port 9452
3. ✅ **v3.1** — TCCPFrame encode/decode, unified send_request
4. ✅ **v3.2** — UIBCBuilder, TranCastMultiPort, port_explorer.py
5. ✅ **v3.3** — Auto-connect tanpa ADB (auto_connect.py: mDNS, tether, IPv6, scan)
6. ✅ **v3.4** — Video stream receiver + integration tests (video_stream.py)
7. ✅ **v3.5** — TCCP Server mode (tccp_server.py: Joy Connect compatible)
8. ✅ **v3.5.1** — QR Generator (`tccp_qr.py`) + Server 8613 (`server_8613.py`) integrated
9. ✅ **v3.6.0** — **Mac Connect Bridge** (`mac_connect_bridge.py`) — ADB wireless + scrcpy merge from mac-connect ✅
    - 3 Performance Profile (120/60/30 FPS)
    - Audio forwarding toggle
    - ARP-based IP auto-discovery
    - GUI Mac Connect tab
    - CLI commands: `setup-wireless`, `wireless-connect`, `mirror`, `mac-connect`
    - **macOS Native App** (.app bundle + mac_install.sh + py2app) 🆕
    - **scrcpy v4.1 fix** (removed deprecated `--forward-all-clicks`)
10. ⟳ **v3.7** — UIBC touch/keyboard live test via ADB
11. ⟳ **Wireless discovery** — WiFi Direct via macOS AWDL/P2P
12. ⟳ **Video streaming** — H.264/H.265 decode live render
13. ⟳ **OpenCore Config Parser** — Hackintosh integration dari mac-connect
