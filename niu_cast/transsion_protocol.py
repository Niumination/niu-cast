"""
NIU CAST — Transsion Protocol (tranCast)
Reverse-engineered protocol for Infinix/Transsion PC Connect (tranCast).

This module implements the TCCP protocol for connecting to Infinix GT 30 Pro
(and other Transsion devices) over TCP.

KEY FINDINGS (2026-07-20, VERIFIED with live phone):
  ═══════════════════════════════════════════════
  TCCP Server runs on port 9452 (fixed, from w4/l1.java S=9452)
  Started via CastSettingActivity button "开启TCCP" (Start TCCP)

  Server auto-sends 7 frames on connect:
    [0x0606] {"port":12000}        - Control channel
    [0x0404] {"a":"xos"}           - Device info
    [0x0607] {"controlPort":9542,   - Auth response with ports
              "filePort":10001,
              "port":8008,
              "supportVersions":[1,2,3]}
    [0x062a] {"data":50314,"type":0} - Device info
    [0x0615] {"count":3}            - Status
    [0x0403] {"scene":0,"videoPort":0} - Scene info
    [0x0900] {"count":0}            - Heartbeat

  After CONN_AUTH (0x700), server continues heartbeats.

  Wire format (VERIFIED):
    [0-3]   "TCCP" magic       (4 bytes)
    [4]     Version/Flags      (1 byte, 0x00 client / 0xFF server)
    [5-8]   Body length        (4 bytes, big-endian, = 15 + payload_len)
    [9-10]  Operator code      (2 bytes, big-endian uint16)
    [11-14] Message ID         (4 bytes, big-endian uint32)
    [15-22] Timestamp          (8 bytes, big-endian, relative ms)
    [23..]  JSON payload       (UTF-8)
    [last]  Payload type       (1 byte, 0x00 = JSON)
  
  Native lib: libCastBaseLinkSDK.so (ARM64)
  IPC: Android Binder to connectx.mirror.source service
  ═══════════════════════════════════════════════

Status: 🟢 AUTH HANDSHAKE WORKING — Need to implement video/UIBC streaming
"""

import asyncio
import json
import logging
import socket
import struct
import time
from typing import Optional, Callable, Dict, Any

logger = logging.getLogger(__name__)

# ── TCCP Ports (dari live handshake decompile) ──────────────────────────────
#
# Port 9452: TCCP handshake — FIXED (konstanta Java w4/l1.java: S=9452)
# Port 8008:  ScreenCast/Video (dari 0x0607: "port":8008)
# Port 9542:  Control channel (dari 0x0607: "controlPort":9542)
# Port 10001: File transfer  (dari 0x0607: "filePort":10001)
# Port 8900:  Old guess (sebelum decompile APK)
# Port 8902:  Old guess (UIBC — ternyata via TCCP stream)
# Port 37651: Old guess (dynamic — ternyata fixed 9452)

PORT_TCCP = 9452          # TCCP handshake (FIXED dari APK)
PORT_CONTROL = 9542       # Control channel
PORT_FILE = 10001         # File transfer
PORT_SCREENCAST = 8008    # ScreenCast/Video stream
PORT_HANDSHAKE_DEFAULT = 9452  # Alias backward compat

# Additional Transsion mDNS service types (discovered from Windows DNS queries)
SERVICE_TRANCAST = "_tranCast._tcp.local."      # Main cast service
SERVICE_TRANFILE = "_tranFile._tcp.local."       # File transfer service
SERVICE_TRAN = "_tran._tcp.local."               # Base Transsion service
SERVICE_TCCP = "_tccp._tcp.local."               # TCCP protocol service

ALL_SERVICES = [SERVICE_TRANCAST, SERVICE_TRANFILE, SERVICE_TRAN, SERVICE_TCCP]

# All known service ports for iteration
TRANSCAST_PORTS = {
    'HandShake': PORT_TCCP,
    'ScreenCast': PORT_SCREENCAST,
    'Control': PORT_CONTROL,
    'File': PORT_FILE,
}

# Magic bytes / headers discovered so far (from native lib)
# These are from libCastBaseLinkSDK.so which is NOT yet reversed
# The NCCN magic in the previous version was a guess
HANDSHAKE_MAGIC = b'TCCP'  # Updated guess based on protocol name
PROTO_VERSION = 1

# TCCP Operator Codes (from v4/g.java decompiled)
# These are 16-bit big-endian command identifiers
TCCP_OP = {
    # Base
    'BASE': 1,
    
    # File operations (0x200-0x302)
    'FILE_BASE': 0x200,
    'FILE_AUTH': 0x300,
    'FILE_AUTH_ACK': 0x301,
    'FILE_CANCEL': 0x302,
    
    # Screen cast (0x400-0x502)
    'CAST_START': 0x400,
    'CAST_STOP': 0x401,
    'CAST_CONFIG': 0x402,
    'CAST_ROTATE': 0x403,
    'CAST_CLOSE': 0x404,
    'CAST_EXTEND': 0x500,
    'CAST_EXTEND_STOP': 0x501,
    'CAST_EXTEND_CLOSE': 0x502,
    
    # File transfer (0x600-0x609)
    'FILE_SEND': 0x600,
    'FILE_RECEIVE': 0x601,
    'FILE_PROGRESS': 0x602,
    'FILE_COMPLETE': 0x603,
    'FILE_ERROR': 0x604,
    'FILE_LIST': 0x605,
    'FILE_DELETE': 0x606,
    'FILE_RENAME': 0x607,
    'FILE_MKDIR': 0x608,
    'FILE_INFO': 0x609,
    
    # Device operations (0x610-0x619)
    'DEVICE_INFO': 0x610,
    'DEVICE_BATTERY': 0x611,
    'DEVICE_SCREENSHOT': 0x612,
    'DEVICE_LOCK': 0x613,
    'DEVICE_UNLOCK': 0x614,
    'DEVICE_VOLUME': 0x615,
    'DEVICE_BRIGHTNESS': 0x616,
    'DEVICE_RING': 0x617,
    'DEVICE_LOCATION': 0x618,
    'DEVICE_CAMERA': 0x619,
    
    # App operations (0x620-0x62B)
    'APP_LIST': 0x620,
    'APP_OPEN': 0x621,
    'APP_CLOSE': 0x622,
    'APP_INSTALL': 0x623,
    'APP_UNINSTALL': 0x624,
    'APP_UPDATE': 0x625,
    'APP_LAUNCH': 0x626,
    'APP_FORCE_STOP': 0x627,
    
    # Clipboard/Notification (0x630-0x634)
    'CLIPBOARD_SYNC': 0x630,
    'CLIPBOARD_GET': 0x631,
    'NOTIFICATION_SYNC': 0x632,
    'NOTIFICATION_ACTION': 0x633,
    'NOTIFICATION_CLEAR': 0x634,
    
    # Connection (0x700-0x720)
    'CONN_AUTH': 0x700,
    'CONN_AUTH_CONFIRM': 0x702,
    'CONN_PAIR': 0x703,
    'CONN_UNPAIR': 0x704,
    'CONN_PING': 0x708,
    'CONN_PONG': 0x709,
    'CONN_CLOSE': 0x710,
    'CONN_RECONNECT': 0x711,
    
    # Extended (0x800+)
    'EXT_AUDIO_START': 0x800,
    'EXT_AUDIO_STOP': 0x816,
    'EXT_AUDIO_VOLUME': 0x819,
    'EXT_SMART_RECOGNITION': 0x820,
    
    # Heartbeat
    'HEARTBEAT': 0x900,
    
    # System
    'SYSTEM': 0x1000,
}


class TCCPFrame:
    """
    TCCP protocol frame.

    Wire format (VERIFIED from live testing against Infinix X6873 on 2026-07-20):

    ALL frames:
      [0-3]   "TCCP" magic       (4 bytes)
      [4]     Version/Flags      (1 byte, 0x00 client / 0xFF server)
      [5-8]   Body length        (4 bytes, big-endian, = 15 + payload_len)
      [9-10]  Operator code      (2 bytes, big-endian uint16)
      [11-14] Message ID         (4 bytes, big-endian uint32)
      [15-22] Timestamp          (8 bytes, big-endian, relative ms elapsed?)
      [23..]  JSON payload       (UTF-8, N bytes)
      [last]  Payload type       (1 byte, 0x00 = JSON)

    body_len = 15 + payload_len  (op+msgId+ts+payload+type)
    total   = 9  + body_len      (magic+ver+body_len+body_len)

    Note: Native lib also supports response format with 4B status code
    (body_len=19+payload_len), but NOT observed in our tests.
    """

    TCCP_MAGIC = b'TCCP'
    PAYLOAD_TYPE_JSON = 0x00
    HEADER_FIXED = 15

    def __init__(self, operator: int, payload: str = ""):
        self.operator = operator
        self.payload = payload
        self.msg_id = 0
        self.status = 0
        self.timestamp = 0
        self.version = 0

    def encode(self, msg_id: int = 1, timestamp: int = None, version: int = 0) -> bytes:
        """Encode a TCCP frame."""
        payload_bytes = self.payload.encode('utf-8') if self.payload else b''
        if timestamp is None:
            timestamp = int(time.time() * 1_000_000)

        body_length = self.HEADER_FIXED + len(payload_bytes)
        buf = bytearray()
        buf.extend(self.TCCP_MAGIC)
        buf.append(version)
        buf.extend(struct.pack('>I', body_length))
        buf.extend(struct.pack('>H', self.operator))
        buf.extend(struct.pack('>I', msg_id))
        buf.extend(struct.pack('>Q', timestamp))
        buf.extend(payload_bytes)
        buf.append(self.PAYLOAD_TYPE_JSON)
        return bytes(buf)

    @classmethod
    def decode(cls, data: bytes) -> 'TCCPFrame':
        """Decode a single TCCP frame from bytes."""
        if len(data) < 10:
            raise ValueError(f"Frame too short: {len(data)} bytes")
        if data[:4] != cls.TCCP_MAGIC:
            raise ValueError(f"Invalid magic: {data[:4]!r}")

        version = data[4]
        body_len = struct.unpack('>I', data[5:9])[0]
        operator = struct.unpack('>H', data[9:11])[0]
        msg_id = struct.unpack('>I', data[11:15])[0]
        timestamp = struct.unpack('>Q', data[15:23])[0]

        frame_total = 9 + body_len

        if len(data) > 23 and data[23:24] == b'{':
            # Request format: JSON starts after timestamp
            payload_raw = data[23:frame_total - 1]
            status = None
        else:
            # Response format: 4B status between ts and payload
            status = struct.unpack('>I', data[23:27])[0]
            payload_raw = data[27:frame_total - 1]

        payload = payload_raw.decode('utf-8', errors='replace') if payload_raw else ""
        frame = cls(operator, payload)
        frame.msg_id = msg_id
        frame.timestamp = timestamp
        frame.status = status or 0
        frame.version = version
        return frame

    @classmethod
    def from_buffer(cls, data: bytes, offset: int = 0):
        """Parse a frame from a buffer, returning (frame, next_offset)."""
        if len(data) < offset + 10:
            return None, offset
        if data[offset:offset+4] != cls.TCCP_MAGIC:
            return None, offset
        body_len = struct.unpack('>I', data[offset+5:offset+9])[0]
        frame_size = 9 + body_len
        if len(data) < offset + frame_size:
            return None, offset
        return cls.decode(data[offset:offset+frame_size]), offset + frame_size

    def __repr__(self):
        op_name = next((k for k, v in TCCP_OP.items() if v == self.operator), f'0x{self.operator:04x}')
        return f"TCCPFrame(op={op_name}, msg_id={self.msg_id}, v={self.version}, payload={self.payload[:80]})"


class TranCastProtocol:
    """
    Transsion Cast protocol client.
    
    Connects to a Transsion device over TCP using the TCCP protocol.
    
    Flow:
        1. TCP connect to port 9452 (TCCP server)
        2. Receive server's initial frames (device info, ports, heartbeat)
        3. Send CONN_AUTH (0x700)
        4. Maintain heartbeat loop
    
    Usage:
        client = TranCastProtocol(host="192.168.49.1", handshake_port=9452)
        await client.connect()
        await client.send_request(TCCP_OP['DEVICE_INFO'], '{}')
    """
    
    def __init__(
        self,
        host: str,
        handshake_port: int = 9452,
    ):
        self.host = host
        self.handshake_port = handshake_port
        self._reader: Optional[asyncio.StreamReader] = None
        self._writer: Optional[asyncio.StreamWriter] = None
        self._connected = False
        self._device_id = None
        self._req_id = 0
        self._buf = b''
    
    # ── Connection Lifecycle ─────────────────────────────────────────────────
    
    async def connect(self) -> bool:
        """
        Establish TCCP connection to the device.
        Flow: TCP connect → receive server init frames → send CONN_AUTH → heartbeat
        """
        try:
            logger.info(f"Connecting TCCP to {self.host}:{self.handshake_port}...")
            self._reader, self._writer = await asyncio.wait_for(
                asyncio.open_connection(self.host, self.handshake_port),
                timeout=5.0,
            )
            self._connected = True

            # Server auto-sends frames on connect; collect them
            self._buf = b''
            await asyncio.sleep(0.3)
            for _ in range(30):
                try:
                    chunk = await asyncio.wait_for(
                        self._reader.read(4096), timeout=0.2)
                    if not chunk:
                        break
                    self._buf += chunk
                except asyncio.TimeoutError:
                    if self._buf:
                        break

            if self._buf:
                frames = self._parse_all_frames(self._buf)
                for f in frames:
                    logger.info(f"Server: 0x{f.op:04x} | {f.payload[:80]}")

            # Send CONN_AUTH
            auth_payload = json.dumps({
                'deviceName': 'Mac',
                'deviceType': 'pc',
                'appVersion': '3.0.0',
            })
            frame = TCCPFrame(TCCP_OP['CONN_AUTH'], auth_payload)
            self._writer.write(frame.encode(msg_id=self._next_id()))
            await self._writer.drain()
            logger.info("Sent CONN_AUTH (0x700)")

            # Read response
            await asyncio.sleep(0.5)
            for _ in range(10):
                try:
                    chunk = await asyncio.wait_for(
                        self._reader.read(4096), timeout=0.3)
                    if not chunk:
                        break
                    self._buf += chunk
                except asyncio.TimeoutError:
                    break

            logger.info(f"Buffered {len(self._buf)} bytes total")
            return len(self._buf) > 0

        except (asyncio.TimeoutError, ConnectionRefusedError, OSError) as e:
            logger.error(f"Connection failed: {e}")
            await self.disconnect()
            return False
    
    async def disconnect(self):
        """Close connection."""
        self._connected = False
        self._buf = b''
        if self._writer:
            try:
                self._writer.close()
                await self._writer.wait_closed()
            except Exception:
                pass
            self._writer = None
            self._reader = None

    def _next_id(self) -> int:
        self._req_id += 1
        return self._req_id

    @staticmethod
    def _parse_all_frames(data: bytes) -> list:
        """Parse all complete TCCP frames from a buffer."""
        frames = []
        offset = 0
        while offset < len(data) - 8:
            f, offset = TCCPFrame.from_buffer(data, offset)
            if f is None:
                break
            frames.append(f)
        return frames
    
    # ── TCCP Protocol ────────────────────────────────────────────────────────
    
    async def send_request(self, op: int, payload: str = "") -> bool:
        """Send a TCCP request."""
        if not self._connected or not self._writer:
            return False
        try:
            frame = TCCPFrame(op, payload)
            data = frame.encode(msg_id=self._next_id())
            self._writer.write(data)
            await self._writer.drain()
            logger.debug(f"Sent TCCP 0x{op:04x}: {payload[:80]}")
            return True
        except Exception as e:
            logger.error(f"Failed to send request: {e}")
            return False
    
    async def recv_frame(self) -> Optional[TCCPFrame]:
        """Receive one TCCP frame from the stream."""
        if not self._reader:
            return None
        while self._connected and self._reader:
            # Try to parse from buffer first
            if len(self._buf) >= 10:
                frame, used = TCCPFrame.from_buffer(self._buf, 0)
                if frame:
                    self._buf = self._buf[used:]
                    return frame
            # Read more
            try:
                chunk = await asyncio.wait_for(
                    self._reader.read(4096), timeout=5.0)
                if not chunk:
                    await self.disconnect()
                    return None
                self._buf += chunk
            except asyncio.TimeoutError:
                return None
            except ConnectionResetError:
                await self.disconnect()
                return None
        return None
    
    # ── High-Level API ──────────────────────────────────────────────────────
    
    async def get_device_info(self) -> Optional[Dict[str, Any]]:
        """Request device information."""
        if await self.send_request(TCCP_OP['DEVICE_INFO'], '{}'):
            frame = await self.recv_frame()
            if frame:
                try:
                    return json.loads(frame.payload)
                except json.JSONDecodeError:
                    return {'raw': frame.payload}
        return None
    
    async def start_cast(self, video_config: dict = None) -> bool:
        """Start screen casting."""
        if video_config is None:
            video_config = {
                'width': 1080,
                'height': 2400,
                'dpi': 480,
                'bitrate': 5000000,
                'frameRate': 30,
                'iFrameInterval': 5,
                'encodeType': 'H264',
                'orientation': 0,
            }
        return await self.send_request(
            TCCP_OP['CAST_START'],
            json.dumps(video_config)
        )
    
    async def stop_cast(self) -> bool:
        """Stop screen casting."""
        return await self.send_request(TCCP_OP['CAST_STOP'], '{}')
    
    async def send_heartbeat(self, count: int = 0) -> bool:
        """Send heartbeat."""
        return await self.send_request(TCCP_OP['HEARTBEAT'],
                                        json.dumps({"count": count}))
    
    async def start_heartbeat_loop(self, interval: float = 1.0):
        """Start sending heartbeats periodically."""
        count = 0
        while self._connected:
            await self.send_heartbeat(count)
            count += 1
            await asyncio.sleep(interval)


class TranCastMultiPort:
    """
    Multi-port TCCP client.
    
    Setelah TCCP AUTH, phone memberikan port tambahan:
      - controlPort (9542): Control channel
      - filePort (10001): File transfer
      - port (8008): ? (unknown)
    
    Class ini mengelola koneksi ke semua port.
    """
    
    PORT_TCCP = 9452
    PORT_CONTROL = 9542
    PORT_FILE = 10001
    PORT_UNKNOWN = 8008
    
    def __init__(self, host: str):
        self.host = host
        self.tccp: Optional[TranCastProtocol] = None
        self.control: Optional[TranCastProtocol] = None
        self.file: Optional[TranCastProtocol] = None
        self._heartbeat_task: Optional[asyncio.Task] = None
    
    async def connect_all(self) -> bool:
        """Konek ke semua port."""
        self.tccp = TranCastProtocol(self.host, self.PORT_TCCP)
        if not await self.tccp.connect():
            logger.error("Gagal konek ke TCCP port")
            return False
        
        # Parse server initial frames untuk dapat port info
        for f in TranCastProtocol._parse_all_frames(self.tccp._buf):
            if f.operator == 0x607:
                try:
                    info = json.loads(f.payload)
                    logger.info(f"Port info dari server: {info}")
                except json.JSONDecodeError:
                    pass
        
        logger.info("Multi-port: TCCP OK, port lain menyusul...")
        return True
    
    async def disconnect_all(self):
        """Putus semua koneksi."""
        if self._heartbeat_task:
            self._heartbeat_task.cancel()
        if self.tccp:
            await self.tccp.disconnect()
        if self.control:
            await self.control.disconnect()
        if self.file:
            await self.file.disconnect()


# ── UIBC Touch/Keyboard Builder ─────────────────────────────────────────────

class UIBCBuilder:
    """
    Membangun packet UIBC untuk touch/keyboard/mouse.
    
    Dari SourceNativeLinkManager.java:
      short type  = k4.c.l(bytes[0:2])   // 0=touch, 1=audio, 2=video, 3=keyboard, 4=mouse, 5=clipboard
      short port  = k4.c.l(bytes[2:4])   // port number
      byte[4]     = reserved/padding
      byte[8+]    = content data
    
    UIBC dispatch types (dari v4/e.java):
      0 = video
      1 = audio
      2 = touch
      3 = keyboard
      4 = mouse
      5 = clipboard
    """
    
    TYPE_TOUCH = 2
    TYPE_KEYBOARD = 3
    TYPE_MOUSE = 4
    
    # Touch actions (Android MotionEvent constants)
    ACTION_DOWN = 0
    ACTION_UP = 1
    ACTION_MOVE = 2
    ACTION_CANCEL = 3
    
    @staticmethod
    def build_touch(x: int, y: int, action: int = 0,
                    width: int = 1224, height: int = 2720) -> bytes:
        """
        Bangun packet touch UIBC.
        
        Format dari decompiled code:
          Bytes 0-1: Type (2 = touch)
          Bytes 2-3: Port (0 atau 8902)
          Bytes 4-7: Reserved (0)
          Bytes 8+:  Content data
                      Format content kemungkinan: action, x, y, width, height
        """
        pkt = bytearray()
        pkt.extend(struct.pack('>H', UIBCBuilder.TYPE_TOUCH))
        pkt.extend(struct.pack('>H', 0))
        pkt.extend(b'\x00\x00\x00\x00')
        # Content: action(4B) + x(4B) + y(4B) + width(4B) + height(4B) ?
        pkt.extend(struct.pack('>III', action, x, y))
        return bytes(pkt)
    
    @staticmethod
    def build_keyboard(key_code: int, action: int = 0) -> bytes:
        """
        Bangun packet keyboard UIBC.
        
        Args:
          key_code: Android key code (KEYCODE_A=29, KEYCODE_ENTER=66, etc.)
          action: 0=down, 1=up
        """
        pkt = bytearray()
        pkt.extend(struct.pack('>H', UIBCBuilder.TYPE_KEYBOARD))
        pkt.extend(struct.pack('>H', 0))
        pkt.extend(b'\x00\x00\x00\x00')
        pkt.extend(struct.pack('>II', action, key_code))
        return bytes(pkt)
    
    @staticmethod
    def build_mouse(dx: int, dy: int, buttons: int = 0) -> bytes:
        """
        Bangun packet mouse UIBC.
        
        Args:
          dx: delta x
          dy: delta y
          buttons: 0=none, 1=left, 2=right
        """
        pkt = bytearray()
        pkt.extend(struct.pack('>H', UIBCBuilder.TYPE_MOUSE))
        pkt.extend(struct.pack('>H', 0))
        pkt.extend(b'\x00\x00\x00\x00')
        pkt.extend(struct.pack('>III', buttons, dx, dy))
        return bytes(pkt)


class TranCastDiscoverer:
    """
    Discover Transsion devices on the local network via mDNS (_tranCast._tcp).
    Now scans ALL known Transsion service types:
      - _tranCast._tcp (main)
      - _tranFile._tcp (file transfer)
      - _tran._tcp (base)
      - _tccp._tcp (TCCP protocol)
    """
    
    SERVICE_TYPE = SERVICE_TRANCAST
    
    @staticmethod
    def discover(timeout: float = 4.0, service_types: list = None) -> list:
        """
        Scan mDNS for Transsion services using zeroconf.
        
        Args:
            timeout: Seconds to wait for responses
            service_types: List of service types to scan (default: all known)
        
        Returns list of dicts with device info.
        """
        if service_types is None:
            service_types = ALL_SERVICES
        
        devices = []
        
        try:
            from zeroconf import Zeroconf, ServiceBrowser
            
            class _Listener:
                def __init__(self):
                    self.found = []
                
                def add_service(self, zc, type_, name):
                    info = zc.get_service_info(type_, name)
                    if info:
                        self.found.append(info)
                
                def update_service(self, zc, type_, name):
                    pass
            
            zc = Zeroconf()
            listener = _Listener()
            browsers = []
            for svc_type in service_types:
                browsers.append(ServiceBrowser(zc, svc_type, listener))
            
            import time as _time
            _time.sleep(timeout)
            zc.close()
            
            for info in listener.found:
                dev = TranCastDiscoverer._parse_service(info)
                if dev:
                    dev['service_type'] = info.type
                    devices.append(dev)
        
        except ImportError:
            logger.warning("zeroconf not installed, falling back to dns-sd")
            import asyncio as _asyncio
            import asyncio.subprocess
            for svc_type in service_types:
                try:
                    proc = _asyncio.run(_asyncio.create_subprocess_exec(
                        'dns-sd', '-B', svc_type.replace('.local.', '').replace('._tcp', ''),
                        stdout=asyncio.subprocess.PIPE,
                        stderr=asyncio.subprocess.DEVNULL,
                    ))
                    try:
                        stdout_data, _ = _asyncio.run(_asyncio.wait_for(
                            proc.communicate(), timeout=timeout
                        ))
                        for line in stdout_data.decode('utf-8', errors='replace').splitlines():
                            if any(x in line for x in ['tranCast', 'tranFile', 'tran.', 'tccp']):
                                devices.append({'name': line, 'raw': True, 'service_type': svc_type})
                    except _asyncio.TimeoutError:
                        proc.kill()
                        _asyncio.run(proc.wait())
                except FileNotFoundError:
                    pass
        
        return devices
    
    @staticmethod
    def _parse_service(info) -> Optional[dict]:
        """Parse zeroconf ServiceInfo into device dict."""
        try:
            result = {
                'host': info.parsed_addresses()[0] if info.parsed_addresses() else '?',
                'port': info.port or 9452,
                'name': info.name.split('.')[0] if info.name else 'Unknown',
                'device_id': '',
                'services': {},
                'server': info.server or '',
            }
            
            if info.properties:
                txt = {}
                for k, v in info.properties.items():
                    key = k.decode('utf-8', errors='replace') if isinstance(k, bytes) else str(k)
                    val = v.decode('utf-8', errors='replace') if isinstance(v, bytes) else str(v)
                    txt[key] = val
                
                if 'cmbSvc' in txt:
                    try:
                        svc = json.loads(txt['cmbSvc'])
                        result['services'] = svc
                        if 'HandShake' in svc:
                            result['port'] = int(svc['HandShake'])
                    except (json.JSONDecodeError, ValueError):
                        pass
                
                name = result['name']
                if 'transConnectService-' in name:
                    parts = name.split('transConnectService-', 1)
                    if len(parts) > 1:
                        id_part = parts[1].rsplit('-', 1)
                        result['device_id'] = id_part[0]
                
                if 'advData' in txt:
                    adv = txt['advData']
                    for brand in ['Infinix', 'Tecno', 'Itel']:
                        if brand in adv:
                            start = adv.index(brand)
                            end = min(start + 40, len(adv))
                            name_bytes = bytes.fromhex(adv[start:end])
                            result['name'] = name_bytes.decode('utf-8', errors='replace').rstrip('\x00').strip()
                            break
            
            return result
        except Exception as e:
            logger.debug(f"Service parse error: {e}")
            return None


# ── Probe Utilities ───────────────────────────────────

async def probe_device(host: str, ports: list = None) -> dict:
    """
    Probe a Transsion device by connecting to its known ports.
    Used to observe response patterns for reverse engineering.
    
    Args:
        host: Device IP
        ports: List of ports to probe (default: handshake candidates)
    
    Returns dict of {port: response_bytes_hex} for ports that responded.
    """
    if ports is None:
        ports = [9452, 8008, 9542, 10001]
    
    results = {}
    
    for port in ports:
        try:
            reader, writer = await asyncio.wait_for(
                asyncio.open_connection(host, port),
                timeout=2.0,
            )
            writer.write(b'\x00')
            await writer.drain()
            
            try:
                data = await asyncio.wait_for(reader.read(4096), timeout=1.0)
                results[port] = {
                    'len': len(data),
                    'hex': data.hex()[:200],
                    'ascii': data[:80],
                }
                logger.info(f"Port {port}: got {len(data)} bytes response")
            except asyncio.TimeoutError:
                results[port] = {'len': 0, 'hex': '', 'ascii': b'', 'note': 'connected but no response'}
                logger.info(f"Port {port}: connected, no response")
            
            writer.close()
            await writer.wait_closed()
        
        except ConnectionRefusedError:
            logger.debug(f"Port {port}: refused")
        except (asyncio.TimeoutError, OSError) as e:
            logger.debug(f"Port {port}: {e}")
    
    return results


# ── USB Tether Detection ──────────────────────────────────────────────────────

def detect_usb_tether_phone() -> Optional[str]:
    """
    Detect phone connected via USB tethering.
    
    Scans network interfaces for a phone subnet (192.168.42.x or 192.168.43.x
    typical for Android USB tether) and returns the gateway IP (phone's IP).
    
    Returns phone IP string or None if not detected.
    """
    import subprocess
    try:
        output = subprocess.check_output(
            ['ifconfig', '-a'], text=True, timeout=5
        )
        
        current_iface = None
        wifi_ifaces = {'en0', 'en1'}
        for line in output.splitlines():
            if line and line[0].isalpha():
                current_iface = line.split(':')[0]
            if 'inet ' in line and current_iface:
                if current_iface in wifi_ifaces or current_iface == 'lo0':
                    continue
                parts = line.strip().split()
                addr_idx = parts.index('inet') + 1
                if addr_idx < len(parts):
                    ip = parts[addr_idx]
                    if ip.startswith('192.168.42.') or ip.startswith('192.168.43.'):
                        gateway = ip.rsplit('.', 1)[0] + '.1'
                        logger.info(f"USB tether detected on {current_iface}: {ip}, phone->{gateway}")
                        return gateway
                    if ip.startswith('10.') or ip.startswith('172.') or ip.startswith('192.168.'):
                        for suffix in ['.1', '.254']:
                            candidate = ip.rsplit('.', 1)[0] + suffix
                            if candidate != ip:
                                rc = subprocess.call(
                                    ['ping', '-c', '1', '-W', '1', candidate],
                                    stdout=subprocess.DEVNULL,
                                    stderr=subprocess.DEVNULL,
                                )
                                if rc == 0:
                                    logger.info(f"USB tether phone at {candidate}")
                                    return candidate
        return None
    except Exception as e:
        logger.debug(f"USB tether detection error: {e}")
        return None


async def try_tether_connect() -> Optional[TranCastProtocol]:
    """Detect phone via USB tether and try to connect."""
    phone_ip = detect_usb_tether_phone()
    if not phone_ip:
        logger.warning("No USB tethered phone detected")
        return None
    
    devices = TranCastDiscoverer.discover(timeout=2.0)
    handshake_port = 9452
    if devices:
        handshake_port = devices[0].get('port', 9452)
        logger.info(f"Using handshake port {handshake_port} from mDNS discovery")
    
    client = TranCastProtocol(host=phone_ip, handshake_port=handshake_port)
    if await client.connect():
        logger.info(f"Connected to phone at {phone_ip}:{handshake_port} via USB tether!")
        return client
    
    for port in [handshake_port, 8008, 9542, 10001]:
        if port != handshake_port:
            client = TranCastProtocol(host=phone_ip, handshake_port=port)
            if await client.connect():
                logger.info(f"Connected via port {port}")
                return client
    
    return None


# ── IPv6 Link-Local Connection ────────────────────────────────────────────────

def find_phone_ipv6(mac_prefix: str = "2e:8c:a8") -> Optional[str]:
    """Try to find phone's IPv6 link-local address via ARP/neighbor table."""
    import subprocess
    import re
    try:
        output = subprocess.check_output(
            ['ndp', '-an'], text=True, timeout=5, stderr=subprocess.DEVNULL
        )
        for line in output.splitlines():
            if mac_prefix.lower() in line.lower():
                m = re.search(r'([a-f0-9:]+)%?(\w*)', line)
                if m:
                    ipv6 = m.group(1)
                    scope = m.group(2) or 'en0'
                    return f"{ipv6}%{scope}"
    except Exception:
        pass
    return None
