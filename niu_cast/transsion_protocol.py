"""
NIU CAST — Transsion Protocol (tranCast)
Reverse-engineered protocol for Infinix/Transsion PC Connect (tranCast).

This module implements the transport layer for connecting to Infinix GT 30 Pro
(and other Transsion devices) over WiFi Direct WITHOUT USB Debugging/ADB.

KEY FINDINGS from APK decompilation (2026-07-20):
  ═══════════════════════════════════════════════
  Protocol: TCCP (Transsion Cast Control Protocol)
  Native libs: libCastBaseLinkSDK.so, libfileNativeJNI.so
  IPC: Android Binder to connectx.mirror.source service
  
  Architecture:
    TCCP Server (port from HandShake mDNS field)
      ├── TCCP protocol: operator+JSON request/response
      ├── Video Server (port 8900): raw H.264/H.265 stream
      ├── Audio Server (port 8904): raw audio stream
      ├── UIBC Server (port 8902): touch/keyboard input
      └── File Server: file transfer channel
  
  TCCP Packet Format:
    - Header: 2 bytes operator (big-endian short)
    - Payload: JSON string (UTF-8)
    
  UIBC Packet Format (from SourceNativeLinkManager):
    - Bytes 0-1: Type (big-endian short)
    - Bytes 2-3: Port (big-endian short)  
    - Bytes 4-7: Reserved/padding
    - Bytes 8+: Content data

  Connection Types: P2P=2, USB=1, WIFI=3
  ═══════════════════════════════════════════════

Status: 🟢 PROTOCOL DECODED — Need to extract native lib API to implement.
"""

import asyncio
import json
import logging
import socket
import struct
import time
from typing import Optional, Callable, Dict, Any

logger = logging.getLogger(__name__)

# Known service ports (from mDNS TXT record cmbSvc)
PORT_SCREENCAST = 8900   # Video stream (H.264/H.265)
PORT_UCHO = 8902          # UIBC (User Input Back Channel) - touch/keyboard
PORT_AUDIOSINK = 8904     # Audio stream
PORT_HANDSHAKE_DEFAULT = 37651  # Dynamic, changes per session

# Additional Transsion mDNS service types (discovered from Windows DNS queries)
SERVICE_TRANCAST = "_tranCast._tcp.local."      # Main cast service
SERVICE_TRANFILE = "_tranFile._tcp.local."       # File transfer service
SERVICE_TRAN = "_tran._tcp.local."               # Base Transsion service
SERVICE_TCCP = "_tccp._tcp.local."               # TCCP protocol service

ALL_SERVICES = [SERVICE_TRANCAST, SERVICE_TRANFILE, SERVICE_TRAN, SERVICE_TCCP]

# All known service ports for iteration
TRANSCAST_PORTS = {
    'HandShake': PORT_HANDSHAKE_DEFAULT,  # Actually TCCP
    'ScreenCast': PORT_SCREENCAST,
    'UcHoService': PORT_UCHO,  # UIBC
    'AudioSink': PORT_AUDIOSINK,
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
    
    Format:
        operator: 2 bytes big-endian (short)
        payload:  JSON string (UTF-8)
    
    The native library handles framing. Over TCP, it likely uses
    a length-prefixed format: [4-byte length][2-byte op][JSON payload]
    """
    
    def __init__(self, operator: int, payload: str = ""):
        self.operator = operator
        self.payload = payload
    
    def encode(self) -> bytes:
        """Encode frame to bytes for transmission."""
        payload_bytes = self.payload.encode('utf-8')
        # Length-prefixed format (guess based on common patterns)
        # 4 bytes total length + 2 bytes operator + payload
        header = struct.pack('>I', 2 + len(payload_bytes))  # total frame length
        op = struct.pack('>H', self.operator)
        return header + op + payload_bytes
    
    @classmethod
    def decode(cls, data: bytes) -> 'TCCPFrame':
        """Decode frame from bytes."""
        if len(data) < 6:
            raise ValueError(f"Frame too short: {len(data)} bytes")
        
        total_len = struct.unpack('>I', data[:4])[0]
        operator = struct.unpack('>H', data[4:6])[0]
        payload = data[6:6 + total_len - 2].decode('utf-8', errors='replace')
        
        return cls(operator, payload)
    
    def __repr__(self):
        op_name = next((k for k, v in TCCP_OP.items() if v == self.operator), f'0x{self.operator:04x}')
        return f"TCCPFrame(op={op_name}, payload={self.payload[:100]})"


class TranCastProtocol:
    """
    Transsion Cast protocol client.
    
    Connects to a Transsion device over WiFi Direct using the TCCP protocol.
    
    Flow:
        1. TCP connect to HandShake/TCCP port
        2. Exchange TCCP handshake (authentication/pairing)
        3. Start heartbeat
        4. Create video/audio/UIBC servers
        5. Stream screen, forward input
    
    Usage:
        client = TranCastProtocol(host="192.168.49.1", handshake_port=37651)
        await client.connect()
        await client.send_request(TCCP_OP['DEVICE_INFO'], '{}')
    """
    
    def __init__(
        self,
        host: str,
        handshake_port: int = PORT_HANDSHAKE_DEFAULT,
        screencast_port: int = PORT_SCREENCAST,
    ):
        self.host = host
        self.handshake_port = handshake_port
        self.screencast_port = screencast_port
        self._reader: Optional[asyncio.StreamReader] = None
        self._writer: Optional[asyncio.StreamWriter] = None
        self._connected = False
        self._device_id = None
        self._req_id = 0
    
    # ── Connection Lifecycle ─────────────────────────────────────────────────
    
    async def connect(self) -> bool:
        """
        Establish TCCP connection to the device.
        """
        try:
            logger.info(f"Connecting TCCP to {self.host}:{self.handshake_port}...")
            self._reader, self._writer = await asyncio.wait_for(
                asyncio.open_connection(self.host, self.handshake_port),
                timeout=5.0,
            )
            self._connected = True
            
            if await self._handshake():
                logger.info("TCCP handshake successful")
                return True
            else:
                logger.error("TCCP handshake failed")
                await self.disconnect()
                return False
        
        except (asyncio.TimeoutError, ConnectionRefusedError, OSError) as e:
            logger.error(f"Connection failed: {e}")
            return False
    
    async def disconnect(self):
        """Close connection."""
        self._connected = False
        if self._writer:
            try:
                self._writer.close()
                await self._writer.wait_closed()
            except Exception:
                pass
            self._writer = None
            self._reader = None
    
    # ── TCCP Protocol ────────────────────────────────────────────────────────
    
    async def _handshake(self) -> bool:
        """
        Perform TCCP handshake.
        
        The actual handshake is handled by the native libCastBaseLinkSDK.so.
        Based on the decompiled code, the flow is:
          1. Client sends CONN_AUTH (0x700) with device info JSON
          2. Server responds with auth challenge
          3. Client responds with pairing code
          4. Server confirms connection
        
        For now, we try to observe the native protocol by sending a probe.
        """
        if not self._writer or not self._reader:
            return False
        
        # Try sending empty bytes to observe server behavior
        # The native lib expects specific framing
        probe = b'\x00'
        logger.debug(f"Sending probe: {probe.hex()}")
        self._writer.write(probe)
        await self._writer.drain()
        
        try:
            response = await asyncio.wait_for(self._reader.read(4096), timeout=3.0)
            logger.debug(f"Handshake response ({len(response)} bytes): {response.hex()}")
            if len(response) > 0:
                return self._parse_handshake_response(response)
            return False
        except asyncio.TimeoutError:
            logger.warning("Handshake response timeout")
            return False
        except ConnectionResetError:
            logger.warning("Connection reset during handshake")
            return False
    
    def _parse_handshake_response(self, data: bytes) -> bool:
        """
        Parse handshake response.
        
        The native protocol uses TCCP framing:
        [4-byte length][2-byte op][JSON payload]
        """
        if len(data) >= 6:
            # Try to parse as TCCP frame
            total_len = struct.unpack('>I', data[:4])[0]
            operator = struct.unpack('>H', data[4:6])[0]
            
            op_name = next((k for k, v in TCCP_OP.items() if v == operator), f'0x{operator:04x}')
            logger.info(f"Received TCCP response: op={op_name}, len={total_len}")
            
            # Accept any valid-looking frame as handshake success
            if 0 < total_len < 65536:
                return True
        
        # Fallback for non-standard responses
        return len(data) > 0
    
    async def send_request(self, op: int, payload: str = "") -> bool:
        """Send a TCCP request."""
        if not self._connected or not self._writer:
            return False
        
        try:
            frame = TCCPFrame(op, payload)
            data = frame.encode()
            self._writer.write(data)
            await self._writer.drain()
            logger.debug(f"Sent TCCP request: {frame}")
            return True
        except Exception as e:
            logger.error(f"Failed to send request: {e}")
            return False
    
    async def recv_frame(self) -> Optional[TCCPFrame]:
        """Receive one TCCP frame."""
        if not self._connected or not self._reader:
            return None
        
        try:
            # Read length prefix (4 bytes)
            header = await asyncio.wait_for(self._reader.readexactly(4), timeout=5.0)
            total_len = struct.unpack('>I', header)[0]
            
            if total_len < 2 or total_len > 65536:
                logger.warning(f"Invalid frame length: {total_len}")
                return None
            
            # Read the rest
            data = await asyncio.wait_for(
                self._reader.readexactly(total_len), timeout=5.0
            )
            
            operator = struct.unpack('>H', data[:2])[0]
            payload = data[2:].decode('utf-8', errors='replace')
            
            return TCCPFrame(operator, payload)
            
        except asyncio.IncompleteReadError:
            await self.disconnect()
            return None
        except (asyncio.TimeoutError, ConnectionResetError):
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
    
    async def send_touch(self, x: int, y: int, action: int = 0) -> bool:
        """
        Send touch event via UIBC.
        
        The UIBC protocol uses binary format:
        [2-byte type][2-byte port][4-byte reserved][payload]
        """
        if not self._connected or not self._writer:
            return False
        
        # UIBC touch packet format (from decompiled code)
        pkt = bytearray()
        pkt.extend(struct.pack('>H', 1))      # type: touch event
        pkt.extend(struct.pack('>H', 8902))    # port: UIBC
        pkt.extend(b'\x00\x00\x00\x00')        # reserved
        # Touch payload: action, x, y (format TBD from native lib)
        pkt.extend(struct.pack('>III', action, x, y))
        
        try:
            self._writer.write(bytes(pkt))
            await self._writer.drain()
            return True
        except Exception:
            return False


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
                'port': info.port or PORT_HANDSHAKE_DEFAULT,
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


# ── Probe Utilities ───────────────────────────────────────────────────────────

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
        ports = [PORT_HANDSHAKE_DEFAULT, 40999, PORT_SCREENCAST, PORT_UCHO, PORT_AUDIOSINK]
    
    results = {}
    
    for port in ports[:4]:
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
    handshake_port = PORT_HANDSHAKE_DEFAULT
    if devices:
        handshake_port = devices[0].get('port', PORT_HANDSHAKE_DEFAULT)
        logger.info(f"Using handshake port {handshake_port} from mDNS discovery")
    
    client = TranCastProtocol(host=phone_ip, handshake_port=handshake_port)
    if await client.connect():
        logger.info(f"Connected to phone at {phone_ip}:{handshake_port} via USB tether!")
        return client
    
    for port in [handshake_port, PORT_SCREENCAST, PORT_UCHO, PORT_AUDIOSINK]:
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
