# niu-cast — Project AGENTS.md

**Lokasi:** `niu-cast/`
**Stack:** Python 3.8+, PyQt5, ADB + TCP/IP
**Remote:** `github.com/Niumination/niu-cast`
**Versi:** v3.5.0 (TCCP Server — Joy Connect mode di Mac)
**Last Push:** 20 Jul 2026

## Overview

Android device manager via ADB + **TCCP (Transsion Cast Control Protocol)** reverse engineering.
Target: kontrol Infinix GT 30 Pro dari Mac tanpa USB debugging.

## Modul

| Modul | LOC | Fungsi |
|-------|-----|--------|
| `adb_controller.py` | 152 | Koneksi ADB, shell, push/pull, device info, screenshot |
| `core.py` | 409 | GUI PyQt5 minimal — 2 tab (Mirror + Files) |
| `mini.py` | 519 | CLI — device info, screenshot, record, control, APK install |
| `file_browser.py` | 597 | File explorer Android via ADB |
| `transsion_protocol.py` | ~920 | TCCP protocol handler + UIBC builder + TranCastDiscoverer |
| `video_stream.py` | ~540 | Video stream receiver + integration tests (tanpa device) |
| `port_explorer.py` | ~260 | CLI tool untuk scan port TCCP tambahan |
| `tccp_server.py` | ~380 | TCCP Server (seperti Joy Connect Windows — Mac listen, HP connect) |
| `auto_connect.py` | ~340 | Auto-connect wireless tanpa ADB (mDNS, tether, IPv6, scan) |
| `wfd_bridge.py` | ~250 | WiFi Direct bridge (butuh ADB) |
| `tetherd.py` | ~170 | USB Tether monitor daemon |

## TCCP Server — Joy Connect Mode

**Paradigma baru:** Kita yang jadi server, HP yang connect ke kita (mirip Joy Connect di Windows).

### Flow

1. **Mac** jalanin `TranCastServer` — buka port 9452 + register mDNS `_tranCast._tcp`
2. **HP** (Joy Connect) scan jaringan lihat Mac → user tap di HP
3. **HP** connect ke Mac:9452
4. **Server** kirim 7 frame awal (0x606, 0x404, 0x607, 0x62a, 0x615, 0x403, 0x900)
5. **HP** kirim CONN_AUTH (0x700) → **Server** respon AUTH_OK (0x701)
6. **Heartbeat** bidirectional via 0x0900 setiap ~30 detik

### Usage

```bash
# Jalanin server
python3 -m niu_cast server              # default port 9452
python3 -m niu_cast server --port 9452  # explicit
python3 -m niu_cast server --name "Mac-Zaryu"  # custom nama
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
| `TranCastServer` | TCP server TCCP — listen 9452 + mDNS + handle incoming HP |
| `register_mdns()` | Async: daftarin mDNS service |
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
| 8613 | TCCP handshake alternatif | ⚪ Belum dicoba | `TCCPHandshakeSocketClient.MAIN_SOCKET_PORT` |
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
| `TranCastServer` | TCP server TCCP — listen 9452 + mDNS + handle incoming HP |

## Wireless Mode Strategy

Tanpa ADB, auto_connect.py mencoba 4 metode berurutan:

| # | Metode | Deskripsi | Status |
|:-:|--------|-----------|:------:|
| 1 | **mDNS** | Discover device di jaringan lokal via zeroconf | ✅ Live |
| 2 | **USB Tether** | Deteksi interface 192.168.42.x/43.x, gateway = HP | ✅ Live |
| 3 | **IPv6 Link-Local** | Cari MAC prefix `2e:8c:a8` di NDP table | ✅ Live |
| 4 | **Subnet Scan** | TCP scan port 9452 ke seluruh subnet | ✅ Live |

Usage: `python3 -m niu_cast connect` (auto, sekali) atau `python3 -m niu_cast monitor` (loop)

## Roadmap

1. ✅ **v2.0** — Refactor, buang bloat
2. ✅ **v3.0** — TCCP handshake discovery + port 9452
3. ✅ **v3.1** — TCCPFrame encode/decode, unified send_request
4. ✅ **v3.2** — UIBCBuilder, TranCastMultiPort, port_explorer.py
5. ✅ **v3.3** — Auto-connect tanpa ADB (auto_connect.py: mDNS, tether, IPv6, scan)
6. ✅ **v3.4** — Video stream receiver + integration tests (video_stream.py)
7. ✅ **v3.5** — TCCP Server mode (tccp_server.py: Joy Connect compatible)
8. ⟳ **v3.6** — UIBC touch/keyboard live test (butuh ADB reconnect)
9. ⟳ **Wireless discovery** — WiFi Direct via macOS AWDL/P2P
10. ⟳ **Video streaming** — H.264/H.265 decode live render
