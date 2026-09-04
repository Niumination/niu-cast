# TCCP Protocol Documentation

> Transsion Cast Control Protocol (TCCP) — Reverse-engineered from Infinix/Transsion PC Connect APK  
> Status: Experimental — handshake verified with live device (2026-07-20)

---

## Overview

TCCP is a TCP-based protocol used by Infinix/Transsion phones for screen mirroring, file transfer, and device control. It is used by the "Joy Connect" Windows application to bridge Windows PCs with Infinix smartphones.

### Ports

| Port | Purpose | Fixed/Dynamic |
|------|---------|---------------|
| 9452 | TCCP Handshake (main) | Fixed (Java constant `w4/l1.java: S=9452`) |
| 8613 | TCCP Handshake (fallback) | Fixed (from client code) |
| 8008 | ScreenCast/Video stream | Fixed (from 0x0607) |
| 9542 | Control channel | Fixed (from 0x0607) |
| 10001 | File transfer | Fixed (from 0x0607) |
| 12000 | Initial control | Fixed (from 0x0606) |

### mDNS Services

The server registers multiple mDNS service types so the phone can discover it:

| Service Type | Purpose |
|--------------|---------|
| `_tranCast._tcp` | Main cast service |
| `_tranFile._tcp` | File transfer service |
| `_tran._tcp` | Base Transsion service |
| `_tccp._tcp` | TCCP protocol service |

**Phone filtering rule (from decompiled `s5.java`):**
- Service name MUST contain `"transConnectService"` (case-sensitive)
- Service type MUST match regex: `.*_tran[^.]*\._tcp.*`
- Must have attributes `cmbSvc`, `cmdSvc`, or `advData`

---

## Wire Format

Each TCCP frame follows this binary format (big-endian):

```
[0-3]   "TCCP" magic (4 bytes, ASCII)
[4]     Version/Flags (1 byte, 0x00 = client, 0xFF = server)
[5-8]   Body length (4 bytes, big-endian, = 15 + payload_len + 1)
[9-10]  Operator code (2 bytes, big-endian uint16)
[11-14] Message ID (4 bytes, big-endian uint32)
[15-22] Timestamp (8 bytes, big-endian uint64, relative ms)
[23..]  JSON payload (UTF-8, variable length)
[last]  Payload type (1 byte, 0x00 = JSON)
```

Total header: 23 bytes. Total minimum frame: 24 bytes (empty payload + type byte).

---

## Operator Codes

### Screen Cast

| Code | Name | Purpose |
|------|------|---------|
| 0x0400 | CAST_START | Start screen cast |
| 0x0401 | CAST_STOP | Stop screen cast |
| 0x0402 | CAST_CONFIG | Configure cast |
| 0x0403 | CAST_ROTATE | Rotate screen |
| 0x0404 | CAST_CLOSE | Close cast |
| 0x0500 | CAST_EXTEND | Extend display |
| 0x0501 | CAST_EXTEND_STOP | Stop extend |
| 0x0502 | CAST_EXTEND_CLOSE | Close extend |

### File Operations

| Code | Name | Purpose |
|------|------|---------|
| 0x0200 | FILE_BASE | Base file operation |
| 0x0300 | FILE_AUTH | File authentication |
| 0x0301 | FILE_AUTH_ACK | File auth acknowledge |
| 0x0302 | FILE_CANCEL | Cancel file operation |
| 0x0600 | FILE_SEND | Send file |
| 0x0601 | FILE_RECEIVE | Receive file |
| 0x0602 | FILE_PROGRESS | File progress |
| 0x0603 | FILE_COMPLETE | File complete |
| 0x0604 | FILE_ERROR | File error |
| 0x0605 | FILE_LIST | List files |
| 0x0606 | FILE_DELETE | Delete file |
| 0x0607 | FILE_RENAME | Rename file |
| 0x0608 | FILE_MKDIR | Create directory |
| 0x0609 | FILE_INFO | File info |

### Device Operations

| Code | Name | Purpose |
|------|------|---------|
| 0x0610 | DEVICE_INFO | Get device info |
| 0x0611 | DEVICE_BATTERY | Get battery status |
| 0x0612 | DEVICE_SCREENSHOT | Take screenshot |
| 0x0613 | DEVICE_LOCK | Lock device |
| 0x0614 | DEVICE_UNLOCK | Unlock device |
| 0x0615 | DEVICE_VOLUME | Set volume |
| 0x0616 | DEVICE_BRIGHTNESS | Set brightness |
| 0x0617 | DEVICE_RING | Ring device |
| 0x0618 | DEVICE_LOCATION | Get location |
| 0x0619 | DEVICE_CAMERA | Camera control |

### App Operations

| Code | Name | Purpose |
|------|------|---------|
| 0x0620 | APP_LIST | List installed apps |
| 0x0621 | APP_OPEN | Open app |
| 0x0622 | APP_CLOSE | Close app |
| 0x0623 | APP_INSTALL | Install app |
| 0x0624 | APP_UNINSTALL | Uninstall app |
| 0x0625 | APP_UPDATE | Update app |
| 0x0626 | APP_LAUNCH | Launch app |
| 0x0627 | APP_FORCE_STOP | Force stop app |

### Auth & Heartbeat

| Code | Name | Purpose |
|------|------|---------|
| 0x0700 | CONN_AUTH | Authentication request |
| 0x0701 | AUTH_OK | Authentication success |
| 0x0900 | HEARTBEAT | Bidirectional heartbeat |

---

## Handshake Sequence

When a phone connects to the TCCP server, the server immediately sends 7 frames:

```
Frame 1 [0x0606] {"port":12000} — Control channel port
Frame 2 [0x0404] {"a":"xos"} — Device info (platform = xos)
Frame 3 [0x0607] {"controlPort":9542,"filePort":10001,"port":8008,"supportVersions":[1,2,3]} — Ports
Frame 4 [0x062a] {"data":50314,"type":0} — Device data
Frame 5 [0x0615] {"count":3} — Status count
Frame 6 [0x0403] {"scene":0,"videoPort":0} — Scene info
Frame 7 [0x0900] {"count":0} — Initial heartbeat
```

After the 7 frames, the phone sends `CONN_AUTH (0x700)` and the server responds with `AUTH_OK (0x701)`.

Heartbeat is then exchanged bidirectionally every ~30 seconds.

---

## Joy Connect QR Code

The QR code is scanned by the phone's Joy Connect app to initiate a connection without manual IP entry.

### Format

```
tqr://a=com.transsion.intent.wls.MULTISCREEN_SCAN_CONNECT&c=PID=xxx&DeviceName=xxx&DPORT=xxx&DID=xxx&SSID=xxx&PWD=xxx&Chan=xxx
```

### Parameters

| Field | Length | Description |
|-------|--------|-------------|
| PID | 12 hex chars | Product ID: TTBBXXXXXXXX (TT=device type, BB=brand, XXXXXXXX=unique) |
| DeviceName | Variable | Display name on phone |
| DPORT | Variable | TCCP port (default 9452) |
| DID | 16 hex chars | Device ID (SHA-256 of device name, uppercased) |
| SSID | Variable | WiFi SSID (optional) |
| PWD | Variable | WiFi password (optional) |
| Chan | Variable | WiFi channel (default 0 = auto) |

### Requirements

- All 7 fields are REQUIRED (phone parses them in fixed order)
- Missing fields may cause the phone to use an old format path

---

## Implementation

### TCCPModels.swift
Protocol constants, operator codes, frame encoding/decoding, handshake sequence builder.

### TCCPServer.swift
TCP server using Network framework. Handles incoming connections, sends handshake sequence, processes incoming frames.

### TCCPQRGenerator.swift
Builds QR string in Transsion format, generates QR code image via CoreImage.

---

## References

- `niu_cast/transsion_protocol.py` — Python implementation (920 LOC)
- `niu_cast/tccp_server.py` — Python TCCP server (444 LOC)
- `niu_cast/tccp_qr.py` — Python QR generator (337 LOC)
- APK decompile: `apk_extract/com.transsion.connectx.mirror.source.apk`
- Native lib: `libCastBaseLinkSDK.so` (ARM64)
