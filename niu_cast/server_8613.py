#!/usr/bin/env python3
"""
transConnect TCCP Server — port 8613
Raw TCP server that handles:
  - HTTP GET /ping → respond 200 OK, keep connection alive  
  - TCCP binary protocol → handle handshake
"""
import asyncio
import json
import logging
import os
import signal
import struct
import sys
import time
from datetime import datetime

log = logging.getLogger(__name__)

# ─── TCCP Frame Format ──────────────────────────────────────────────────────────
# Request:  [4B "TCCP"] [1B VER] [4B LEN (N+15)] [2B OP] [4B INT_TS] [8B LONG_TS] [N B PAYLOAD] [1B CRC]
# Response: [4B "%%%%"] [1B VER] [4B LEN (N+19)] [2B STATUS] [4B INT_TS] [4B OP+%%] [8B LONG_TS] [N B PAYLOAD] [1B CRC]

TCCP_REQ_HDR = b"TCCP"
TCCP_RESP_HDR = b"%%%%"
TCCP_VER = b"\x01"

# Operation codes
OP_HANDSHAKE     = bytes([0x06, 0x06])  # {"port":12000}
OP_XOS_INFO      = bytes([0x04, 0x04])  # {"a":"xos"}
OP_CAP_PORT      = bytes([0x06, 0x07])  # {"controlPort":..., ...}
OP_HEARTBEAT     = bytes([0x09, 0x11])  # heartbeat
OP_SCAN_CONFIRM  = bytes([0x09, 0x05])  # scan confirm
OP_SWITCH_ABILITY= bytes([0x09, 0x06])  # switch ability
OP_INIT_PORT     = bytes([0x09, 0x07])  # sdk init port
OP_DISCONNECT    = bytes([0x09, 0x08])  # disconnect
OP_REQ_DISCONNECT= bytes([0x09, 0x16])  # request disconnect

# ─── CRC8 Table ─────────────────────────────────────────────────────────────────
CRC8_TABLE = [
    0x00, 0x07, 0x0E, 0x09, 0x1C, 0x1B, 0x12, 0x15,
    0x38, 0x3F, 0x36, 0x31, 0x24, 0x23, 0x2A, 0x2D,
    0x70, 0x77, 0x7E, 0x79, 0x6C, 0x6B, 0x62, 0x65,
    0x48, 0x4F, 0x46, 0x41, 0x54, 0x53, 0x5A, 0x5D,
    0xE0, 0xE7, 0xEE, 0xE9, 0xFC, 0xFB, 0xF2, 0xF5,
    0xD8, 0xDF, 0xD6, 0xD1, 0xC4, 0xC3, 0xCA, 0xCD,
    0x90, 0x97, 0x9E, 0x99, 0x8C, 0x8B, 0x82, 0x85,
    0xA8, 0xAF, 0xA6, 0xA1, 0xB4, 0xB3, 0xBA, 0xBD,
    0xC7, 0xC0, 0xC9, 0xCE, 0xDB, 0xDC, 0xD5, 0xD2,
    0xFF, 0xF8, 0xF1, 0xF6, 0xE3, 0xE4, 0xED, 0xEA,
    0xB7, 0xB0, 0xB9, 0xBE, 0xAB, 0xAC, 0xA5, 0xA2,
    0x8F, 0x88, 0x81, 0x86, 0x93, 0x94, 0x9D, 0x9A,
    0x27, 0x20, 0x29, 0x2E, 0x3B, 0x3C, 0x35, 0x32,
    0x1F, 0x18, 0x11, 0x16, 0x03, 0x04, 0x0D, 0x0A,
    0x57, 0x50, 0x59, 0x5E, 0x4B, 0x4C, 0x45, 0x42,
    0x6F, 0x68, 0x61, 0x66, 0x73, 0x74, 0x7D, 0x7A,
    0x89, 0x8E, 0x87, 0x80, 0x95, 0x92, 0x9B, 0x9C,
    0xB1, 0xB6, 0xBF, 0xB8, 0xB5, 0xB2, 0xBB, 0xBC,
    0xF9, 0xFE, 0xF7, 0xF0, 0xE5, 0xE2, 0xEB, 0xEC,
    0xC1, 0xC6, 0xCF, 0xC8, 0xDD, 0xDA, 0xD3, 0xD4,
    0x69, 0x6E, 0x67, 0x60, 0x75, 0x72, 0x7B, 0x7C,
    0x51, 0x56, 0x5F, 0x58, 0x4D, 0x4A, 0x43, 0x44,
    0x19, 0x1E, 0x17, 0x10, 0x05, 0x02, 0x0B, 0x0C,
    0x21, 0x26, 0x2F, 0x28, 0x3D, 0x3A, 0x33, 0x34,
    0x4E, 0x49, 0x40, 0x47, 0x52, 0x55, 0x5C, 0x5B,
    0x76, 0x71, 0x78, 0x7F, 0x6A, 0x6D, 0x64, 0x63,
    0x3E, 0x39, 0x30, 0x37, 0x22, 0x25, 0x2C, 0x2B,
    0x06, 0x01, 0x08, 0x0F, 0x1A, 0x1D, 0x14, 0x13,
    0xAE, 0xA9, 0xA0, 0xA7, 0xB2, 0xB5, 0xBC, 0xBB,
    0x96, 0x91, 0x98, 0x9F, 0x8A, 0x8D, 0x84, 0x83,
    0xDE, 0xD9, 0xD0, 0xD7, 0xC2, 0xC5, 0xCC, 0xCB,
    0xE6, 0xE1, 0xE8, 0xEF, 0xFA, 0xFD, 0xF4, 0xF3,
]

def crc8(data: bytes) -> int:
    crc = 0
    for b in data:
        crc = CRC8_TABLE[(crc ^ b) & 0xFF]
    return crc

# ─── TCCP Frame Parsing ──────────────────────────────────────────────────────────

def build_tccp_request(op: bytes, payload: str) -> bytes:
    pbytes = payload.encode('utf-8')
    length = len(pbytes) + 15  # op(2) + int_ts(4) + long_ts(8) + payload(N) + crc(1)
    buf = bytearray()
    buf.extend(TCCP_REQ_HDR)      # 4
    buf.extend(TCCP_VER)           # 1
    buf.extend(struct.pack('>I', length))  # 4
    buf.extend(op)                 # 2
    now_ms = int(time.time() * 1000)
    buf.extend(struct.pack('>I', now_ms & 0xFFFFFFFF))  # 4
    buf.extend(struct.pack('>Q', now_ms))               # 8
    buf.extend(pbytes)
    crc_input = bytes(buf[9:])
    buf.append(crc8(crc_input))
    return bytes(buf)

def build_tccp_resp(op: bytes, payload: str, status: int = 200) -> bytes:
    pbytes = payload.encode('utf-8')
    length = len(pbytes) + 19
    buf = bytearray()
    buf.extend(TCCP_RESP_HDR)     # 4
    buf.extend(TCCP_VER)          # 1
    buf.extend(struct.pack('>I', length))  # 4
    buf.extend(struct.pack('>H', status))  # 2
    now_ms = int(time.time() * 1000)
    buf.extend(struct.pack('>I', now_ms & 0xFFFFFFFF))  # 4
    buf.extend(op)                # 2
    buf.extend(b'\x25\x25')       # 2 (%%)
    buf.extend(struct.pack('>Q', now_ms))  # 8
    buf.extend(pbytes)
    crc_input = bytes(buf[9:])
    buf.append(crc8(crc_input))
    return bytes(buf)

def parse_tccp_request(data: bytes):
    """Parse a TCCP request frame. Returns (operation, payload) or raises ValueError."""
    if len(data) < 10:
        raise ValueError(f"Frame too short: {len(data)}")
    if data[:4] != TCCP_REQ_HDR:
        raise ValueError(f"Bad header: {data[:4].hex()}")
    length = struct.unpack('>I', data[5:9])[0]
    total = 9 + length
    if len(data) < total:
        raise ValueError(f"Incomplete frame: need {total}, have {len(data)}")
    op = data[9:11]
    payload_len = length - 15
    payload = data[23:23+payload_len].decode('utf-8', errors='replace')
    return op, payload

# ─── TCCP Handshake Handler ──────────────────────────────────────────────────────

class TCCPHandler:
    """Handles TCCP protocol exchange over a raw TCP connection."""
    
    def __init__(self):
        self.state = "INIT"
    
    async def handle(self, reader: asyncio.StreamReader, writer: asyncio.StreamWriter):
        peer = writer.get_extra_info('peername')
        log.info(f"🔌 HP CONNECTED: {peer}")
        
        try:
            # Step 1: Wait for data from HP
            data = await asyncio.wait_for(reader.read(65536), timeout=10.0)
            if not data:
                log.info(f"  EOF from {peer}")
                return
            
            log.info(f"  ← HP sent {len(data)} bytes: {data[:80]}")
            
            # Step 2: Check if it's HTTP /ping
            if data.startswith(b"GET /ping"):
                log.info(f"  ⚡ HTTP /ping")
                # Respond with 200 OK (keep-alive)
                resp = (
                    b"HTTP/1.1 200 OK\r\n"
                    b"Content-Length: 0\r\n"
                    b"Connection: keep-alive\r\n"
                    b"\r\n"
                )
                writer.write(resp)
                await writer.drain()
                log.info(f"  ✓ Sent HTTP 200 OK, waiting for TCCP frames...")
                
                # Step 3: Now wait for TCCP frames on the same connection
                while True:
                    try:
                        data2 = await asyncio.wait_for(reader.read(65536), timeout=30.0)
                        if not data2:
                            log.info(f"  EOF from {peer}")
                            break
                        await self._process_tccp_data(data2, writer, peer)
                    except asyncio.TimeoutError:
                        log.info(f"  ⏱️ Timeout waiting for data from {peer}")
                        break
            elif data[:4] == TCCP_REQ_HDR:
                # Direct TCCP without /ping
                await self._process_tccp_data(data, writer, peer)
            else:
                log.warning(f"  ⚠️ Unknown initial data from {peer}")
                log.info(f"  Hex: {data[:60].hex()}")
        except asyncio.TimeoutError:
            log.info(f"  ⏱️ Timeout waiting for initial data from {peer}")
        except ConnectionResetError:
            log.info(f"  👋 Connection reset by {peer}")
        except Exception as e:
            log.error(f"  ❌ Error: {e}")
            import traceback
            traceback.print_exc()
        finally:
            try:
                writer.close()
            except:
                pass
            log.info(f"  🔌 Disconnected: {peer}")
    
    async def _process_tccp_data(self, data: bytes, writer, peer):
        """Process TCCP binary data."""
        off = 0
        while off < len(data):
            if off + 4 > len(data):
                break
            if data[off:off+4] != TCCP_REQ_HDR:
                log.info(f"  ⚠️ Bad TCCP header at offset {off}: {data[off:off+4].hex()}")
                off += 1
                continue
            
            try:
                op, payload = parse_tccp_request(data[off:])
                await self._handle_op(op, payload, writer, peer)
                
                # Calculate frame total size to advance
                length = struct.unpack('>I', data[off+5:off+9])[0]
                total = 9 + length
                off += total
            except ValueError as e:
                log.warning(f"  ⚠️ Parse error: {e}")
                off += 1
    
    async def _handle_op(self, op: bytes, payload: str, writer, peer):
        op_hex = op.hex()
        log.info(f"  ← [{op_hex}] {payload}")
        
        if op == OP_HANDSHAKE:
            # {"port":12000} - HP sends its port
            log.info(f"  📱 HP handshake port: {payload}")
            resp = build_tccp_resp(op, '{"result":"ok"}')
            writer.write(resp)
            await writer.drain()
            log.info(f"  → [RESP {op_hex}] {{\"result\":\"ok\"}}")
            
            # Send XOS info probe
            frame = build_tccp_request(OP_XOS_INFO, '{"a":"xos"}')
            writer.write(frame)
            await writer.drain()
            log.info(f"  → [{OP_XOS_INFO.hex()}] {{\"a\":\"xos\"}}")
            
        elif op == OP_XOS_INFO:
            # {"a":"xos"} - XOS capability check
            resp = build_tccp_resp(op, '{"result":"ok"}')
            writer.write(resp)
            await writer.drain()
            log.info(f"  → [RESP {op_hex}] {{\"result\":\"ok\"}}")
            
            # Send scan confirm
            frame = build_tccp_request(OP_SCAN_CONFIRM, '{"confirmed":true}')
            writer.write(frame)
            await writer.drain()
            log.info(f"  → [{OP_SCAN_CONFIRM.hex()}] {{\"confirmed\":true}}")
            
        elif op == OP_HEARTBEAT:
            resp = build_tccp_resp(op, '{"result":"pong"}')
            writer.write(resp)
            await writer.drain()
            log.info(f"  → [RESP {op_hex}] pong")
            
        elif op == OP_SCAN_CONFIRM:
            log.info(f"  ✅ Scan confirmed!")
            resp = build_tccp_resp(op, '{"result":"ok"}')
            writer.write(resp)
            await writer.drain()
            
            # Send capability/switch ability
            frame2 = build_tccp_request(OP_SWITCH_ABILITY, '{"scene":0,"videoPort":0}')
            writer.write(frame2)
            await writer.drain()
            log.info(f"  → [{OP_SWITCH_ABILITY.hex()}] switch ability")
            
        elif op == OP_SWITCH_ABILITY:
            log.info(f"  🔄 Switch ability: {payload}")
            resp = build_tccp_resp(op, '{"result":"ok"}')
            writer.write(resp)
            await writer.drain()
            
            # Send init port info
            frame = build_tccp_request(OP_INIT_PORT, '{"controlPort":9542,"filePort":10001,"port":8613}')
            writer.write(frame)
            await writer.drain()
            log.info(f"  → [{OP_INIT_PORT.hex()}] init port")
            
        elif op == OP_INIT_PORT:
            log.info(f"  🔌 SDK init port: {payload}")
            resp = build_tccp_resp(op, '{"result":"ok"}')
            writer.write(resp)
            await writer.drain()
            
        elif op == OP_DISCONNECT or op == OP_REQ_DISCONNECT:
            log.info(f"  👋 Disconnect requested")
            resp = build_tccp_resp(op, '{"result":"ok"}')
            writer.write(resp)
            await writer.drain()
            
        else:
            log.warning(f"  ⚠️ Unknown op: {op_hex}, payload: {payload}")
            resp = build_tccp_resp(op, '{"result":"ok"}')
            writer.write(resp)
            await writer.drain()

# ─── Server ──────────────────────────────────────────────────────────────────────

class TranCastServer8613:
    """TCCP Server for port 8613 — Joy Connect QR mode."""
    
    def __init__(self, host: str = '0.0.0.0', port: int = 8613, mdns_name: str = None):
        self._host = host
        self._port = port
        self._mdns_name = mdns_name
        self._server = None
    
    async def start(self):
        """Start server + register mDNS."""
        handler = TCCPHandler()
        self._server = await asyncio.start_server(handler.handle, self._host, self._port)
        
        # Register mDNS for all Transsion service types
        try:
            from .tccp_server import register_all_mdns
            from .transsion_protocol import PORT_TCCP
            await register_all_mdns(port=self._port, name=self._mdns_name)
        except Exception as e:
            log.warning(f"mDNS registration skipped: {e}")
        
        log.info(f"")
        log.info(f"╔══════════════════════════════════════════════════════════╗")
        log.info(f"║  TCCP Server 8613 — Joy Connect QR Mode                ║")
        log.info(f"║  Listening on {self._host}:{self._port}                              ║")
        log.info(f"║  Raw TCP: HTTP /ping + TCCP binary protocol            ║")
        log.info(f"╚══════════════════════════════════════════════════════════╝")
        log.info(f"")
        
        async with self._server:
            await self._server.serve_forever()
    
    async def stop(self):
        """Stop server."""
        from .tccp_server import unregister_mdns_all
        await unregister_mdns_all()
        if self._server:
            self._server.close()
            await self._server.wait_closed()
        log.info("Server 8613 stopped")


def main():
    """CLI entry point for server 8613."""
    import argparse
    
    parser = argparse.ArgumentParser(
        description='NIU CAST — TCCP Server 8613 (Joy Connect QR mode)',
    )
    parser.add_argument('--port', type=int, default=8613,
                       help='Port (default: 8613)')
    parser.add_argument('--name', default=None,
                       help='Nama yang muncul di HP')
    args = parser.parse_args()
    
    async def _run():
        server = TranCastServer8613(port=args.port, mdns_name=args.name)
        await server.start()
    
    try:
        asyncio.run(_run())
    except KeyboardInterrupt:
        pass
