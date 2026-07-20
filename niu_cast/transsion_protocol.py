"""
NIU CAST — Transsion Protocol (tranCast)
Reverse-engineered protocol for Infinix/Transsion PC Connect (tranCast).

This module implements the transport layer for connecting to Infinix GT 30 Pro
(and other Transsion devices) over WiFi Direct WITHOUT USB Debugging/ADB.

Protocol architecture (from mDNS service announcement):
  _tranCast._tcp  →  transConnectService-{device_id}-{session}._tranCast._tcp.local
  cmbSvc: {
    "HandShake": <port>,  → dynamic port, initial negotiation
    "ScreenCast": 8900,   → screen mirror stream
    "UcHoService": 8902,  → unknown (UcHo?)
    "AudioSink": 8904     → audio stream
  }

Status: ⚠️ PARTIAL — protocol payload format unknown (capture pending).
"""

import asyncio
import json
import logging
import socket
import struct
import time
from typing import Optional, Callable

logger = logging.getLogger(__name__)

# Known service ports (from mDNS TXT record cmbSvc)
PORT_SCREENCAST = 8900
PORT_UCHO = 8902
PORT_AUDIOSINK = 8904
PORT_HANDSHAKE_DEFAULT = 37651  # changes per session

# Magic bytes / headers discovered so far (TBD from pcap analysis)
# These are placeholders until the WiFi Direct capture is decoded
HANDSHAKE_MAGIC = b'\x00\x00\x00\x00'
PROTO_VERSION = 1


class TranCastProtocol:
    """
    Transsion Cast protocol client.

    Connects to a Transsion device over WiFi Direct using the _tranCast._tcp
    protocol, without requiring USB Debugging.

    Usage:
        client = TranCastProtocol(host="192.168.49.1", handshake_port=37651)
        await client.connect()
        frame = await client.recv_frame()
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

    # ── Connection Lifecycle ─────────────────────────────────────────────────

    async def connect(self) -> bool:
        """
        Establish connection to the device.
        Steps:
          1. TCP connect to HandShake port
          2. Perform handshake exchange
          3. Upgrade to ScreenCast port
        """
        try:
            logger.info(f"Connecting to {self.host}:{self.handshake_port}...")
            self._reader, self._writer = await asyncio.wait_for(
                asyncio.open_connection(self.host, self.handshake_port),
                timeout=5.0,
            )
            self._connected = True

            if await self._handshake():
                logger.info("Handshake successful")
                return True
            else:
                logger.error("Handshake failed")
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

    # ── Handshake ────────────────────────────────────────────────────────────

    async def _handshake(self) -> bool:
        """
        Perform initial handshake with the device.

        NOTE: This is a PLACEHOLDER. The actual handshake format needs to
        be determined from WiFi Direct packet capture.

        Expected flow (TBD):
          1. Client sends handshake request (device info, auth token?)
          2. Server responds with session parameters (resolution, codec, etc.)
          3. Client acknowledges → ready to stream
        """
        if not self._writer or not self._reader:
            return False

        # ── Placeholder handshake ──
        # Send a probe packet to observe response
        probe = self._build_handshake_packet()
        logger.debug(f"Sending handshake: {probe.hex()}")
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

    def _build_handshake_packet(self) -> bytes:
        """
        Build handshake packet.

        TODO: Reverse engineer from pcap capture.
        For now, send a minimal probe with magic + device ID placeholder.
        """
        # Format TBD — this is a guess based on common patterns
        pkt = bytearray()
        pkt.extend(b'NCCN')           # 4-byte magic? "NCCN" = NiuCast Connect?
        pkt.extend(struct.pack('>I', PROTO_VERSION))  # protocol version
        pkt.extend(b'\x00' * 32)      # reserved / device ID placeholder
        return bytes(pkt)

    def _parse_handshake_response(self, data: bytes) -> bool:
        """
        Parse handshake response.

        TODO: Reverse engineer from pcap capture.
        Returns True if handshake was accepted.
        """
        # Placeholder — accept any response > 0 bytes for now
        if len(data) >= 4:
            # Check for magic response
            if data[:4] == b'NCCN':
                logger.info("Handshake accepted")
                return True
        # Fallback: accept non-empty response
        return len(data) > 0

    # ── Screen Capture ───────────────────────────────────────────────────────

    async def recv_frame(self) -> Optional[bytes]:
        """
        Receive one screen frame.

        TODO: Implement actual frame reception once protocol is decoded.

        Returns raw JPEG/PNG bytes or None on failure.
        """
        if not self._connected or not self._reader:
            return None

        try:
            # Placeholder: assume server pushes frames after handshake
            data = await asyncio.wait_for(self._reader.read(65536), timeout=2.0)
            return data if data else None
        except asyncio.TimeoutError:
            return None
        except ConnectionResetError:
            await self.disconnect()
            return None

    # ── Touch Events ─────────────────────────────────────────────────────────

    async def send_touch(self, x: int, y: int, action: int = 0) -> bool:
        """
        Send touch event to device.

        TODO: Implement touch event encoding once protocol is decoded.

        Args:
            x, y: Screen coordinates
            action: 0=down, 1=up, 2=move
        """
        if not self._connected or not self._writer:
            return False
        # Placeholder — format TBD
        pkt = struct.pack('>BIII', 0x01, action, x, y, int(time.time() * 1000))
        try:
            self._writer.write(pkt)
            await self._writer.drain()
            return True
        except Exception:
            return False


class TranCastDiscoverer:
    """
    Discover Transsion devices on the local network via mDNS (_tranCast._tcp).

    Usage:
        discoverer = TranCastDiscoverer()
        devices = await discoverer.discover(timeout=3.0)
        for dev in devices:
            print(dev['host'], dev['handshake_port'])
    """

    SERVICE_TYPE = "_tranCast._tcp.local."

    @staticmethod
    async def discover(timeout: float = 3.0) -> list:
        """
        Scan mDNS for _tranCast._tcp services.

        Returns list of dicts with device info:
        {
            'host': str (IP),
            'port': int (handshake),
            'name': str,
            'device_id': str,
            'services': dict  # from cmbSvc TXT record
        }
        """
        # Use subprocess to call `dns-sd` on macOS or `avahi-browse` on Linux
        # This avoids needing a full mDNS library
        import asyncio.subprocess

        devices = []

        # Try macOS dns-sd
        try:
            proc = await asyncio.create_subprocess_exec(
                'dns-sd', '-B', '_tranCast._tcp', 'local',
                stdout=asyncio.subprocess.PIPE,
                stderr=asyncio.subprocess.PIPE,
            )

            try:
                stdout_data, _ = await asyncio.wait_for(
                    proc.communicate(), timeout=timeout
                )
                # Parse dns-sd output
                for line in stdout_data.decode('utf-8', errors='replace').splitlines():
                    if 'tranCast' in line:
                        parts = line.split()
                        if len(parts) >= 7:
                            devices.append({
                                'name': parts[6] if len(parts) > 6 else 'Unknown',
                                'raw': line,
                            })
            except asyncio.TimeoutError:
                proc.kill()
                await proc.wait()

        except FileNotFoundError:
            logger.debug("dns-sd not found (not macOS?)")

        # Fallback: try to resolve via mDNS query
        if not devices:
            sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
            sock.settimeout(timeout)

            # Send standard mDNS query for _tranCast._tcp
            # mDNS query packet (simplified)
            query = bytes.fromhex(
                "0000 0000 0001 0000 0000 0000"
                "095f7472616e43617374045f746370"
                "056c6f63616c 0000 0c00 01"
                .replace(" ", "")
            )
            try:
                sock.sendto(query, ('224.0.0.251', 5353))
                while True:
                    try:
                        data, addr = sock.recvfrom(1024)
                        # Parse mDNS response
                        result = self._parse_mdns_response(data, addr[0])
                        if result:
                            devices.append(result)
                    except socket.timeout:
                        break
            finally:
                sock.close()

        return devices

    @staticmethod
    def _parse_mdns_response(data: bytes, src_ip: str) -> Optional[dict]:
        """
        Parse a raw mDNS response packet to extract Transsion service info.
        """
        try:
            payload = data[12:]  # Skip DNS header
            # Find _tranCast service name
            text = payload.decode('utf-8', errors='replace')
            if '_tranCast' not in text:
                return None

            result = {
                'host': src_ip,
                'port': PORT_HANDSHAKE_DEFAULT,
                'name': 'Unknown',
                'device_id': '',
                'services': {},
            }

            # Extract TXT records (cmbSvc JSON)
            if 'cmbSvc=' in text:
                try:
                    svc_start = text.index('cmbSvc=') + 7
                    svc_end = text.index('}', svc_start) + 1
                    svc_json = text[svc_start:svc_end]
                    result['services'] = json.loads(svc_json)
                    if 'HandShake' in result['services']:
                        result['port'] = int(result['services']['HandShake'])
                except (ValueError, json.JSONDecodeError):
                    pass

            # Extract device name
            if 'Infinix' in text or 'Tecno' in text or 'Itel' in text:
                result['name'] = text.split('Infinix')[1].split(',')[0].strip()[:32]

            return result

        except Exception as e:
            logger.debug(f"mDNS parse error: {e}")
            return None


# ── Convenience API ───────────────────────────────────────────────────────────

async def discover_and_connect(timeout: float = 3.0) -> Optional[TranCastProtocol]:
    """
    Discover Transsion device on network and connect.
    Returns connected TranCastProtocol instance or None.
    """
    devices = await TranCastDiscoverer.discover(timeout=timeout)
    if not devices:
        logger.warning("No Transsion devices found on network")
        return None

    dev = devices[0]
    logger.info(f"Found device: {dev['name']} at {dev['host']}:{dev['port']}")

    client = TranCastProtocol(
        host=dev['host'],
        handshake_port=dev['port'],
    )

    if await client.connect():
        return client

    return None
