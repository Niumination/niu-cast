# niu-cast — Project AGENTS.md

**Lokasi:** `niu-cast/`
**Stack:** Python 3.8+, PyQt5, ADB + TCP/IP
**Remote:** `github.com/Niumination/niu-cast`
**Versi:** v3.2.0 (TCCP handshake + UIBC builder)
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
| `port_explorer.py` | ~260 | CLI tool untuk scan port TCCP tambahan |
| `auto_connect.py` | ~340 | Auto-connect wireless tanpa ADB (mDNS, tether, IPv6, scan) |
| `wfd_bridge.py` | ~250 | WiFi Direct bridge (butuh ADB) |
| `tetherd.py` | ~170 | USB Tether monitor daemon |

## TCCP Protocol (v3.x)

### Port Discovery

| Port | Fungsi | Status |
|------|--------|:------:|
| 9452 | TCCP handshake — fixed port (dari konstanta Java `w4/l1.S=9452`) | ✅ Handshake OK |
| 8008 | ? (dari 0x0607 auth response) | ⚪ Belum diexplore |
| 9542 | controlPort (dari 0x0607) | ⚪ Belum diexplore |
| 10001 | filePort (dari 0x0607) | ⚪ Belum diexplore |

### Class Key

| Class | Fungsi |
|-------|--------|
| `TCCPFrame` | Encode/decode frame TCCP (magic TCCP + opcode + JSON payload) |
| `TranCastProtocol` | TCP client: connect, AUTH, bidirectional heartbeat, request/response |
| `TranCastMultiPort` | Manager untuk semua port TCCP (9452, 8008, 9542, 10001) |
| `UIBCBuilder` | Bangun packet UIBC: touch, keyboard, mouse |
| `TranCastDiscoverer` | mDNS discovery (_tranCast, _tranFile, _tran, _tccp) |

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
6. ⟳ **v3.4** — UIBC touch/keyboard live test (butuh ADB reconnect)
7. ⟳ **Wireless discovery** — WiFi Direct via macOS AWDL/P2P
8. ⟳ **Video streaming** — H.264/H.265 decode
