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

Status: 🔬 ACTIVE DEVELOPMENT — mDNS discovery uses zeroconf library.
              Handshake payload format TBD (placeholder).
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
HANDSHAKE_MAGIC = b'NCCN'
PROTO_VERSION = 1

# All known service ports for iteration
TRANSCAST_PORTS = {
    'HandShake': PORT_HANDSHAKE_DEFAULT,
    'ScreenCast': PORT_SCREENCAST,
    'UcHoService': PORT_UCHO,
    'AudioSink': PORT_AUDIOSINK,
}


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

    Uses zeroconf library for reliable service discovery.

    Usage:
        devices = TranCastDiscoverer.discover(timeout=4.0)
        for dev in devices:
            print(dev['host'], dev['handshake_port'])
    """

    SERVICE_TYPE = "_tranCast._tcp.local."

    @staticmethod
    def discover(timeout: float = 4.0) -> list:
        """
        Scan mDNS for _tranCast._tcp services using zeroconf.

        Returns list of dicts with device info.
        """
        devices = []

        try:
            from zeroconf import Zeroconf, ServiceBrowser, ServiceStateChange

            class _Listener:
                def __init__(self):
                    self.found = []

                def add_service(self, zeroconf, type_, name):
                    info = zeroconf.get_service_info(type_, name)
                    if info:
                        self.found.append(info)

                def update_service(self, zeroconf, type_, name):
                    pass  # required by zeroconf API

            zc = Zeroconf()
            listener = _Listener()
            browser = ServiceBrowser(zc, TranCastDiscoverer.SERVICE_TYPE, listener)

            import time as _time
            _time.sleep(timeout)

            zc.close()

            for info in listener.found:
                dev = TranCastDiscoverer._parse_service(info)
                if dev:
                    devices.append(dev)

        except ImportError:
            logger.warning("zeroconf not installed, falling back to dns-sd")
            import asyncio
            import asyncio.subprocess
            try:
                proc = asyncio.run(asyncio.create_subprocess_exec(
                    'dns-sd', '-B', '_tranCast._tcp', 'local',
                    stdout=asyncio.subprocess.PIPE,
                    stderr=asyncio.subprocess.DEVNULL,
                ))
                try:
                    stdout_data, _ = asyncio.run(asyncio.wait_for(
                        proc.communicate(), timeout=timeout
                    ))
                    for line in stdout_data.decode('utf-8', errors='replace').splitlines():
                        if 'tranCast' in line:
                            devices.append({'name': line, 'raw': True})
                except asyncio.TimeoutError:
                    proc.kill()
                    asyncio.run(proc.wait())
            except FileNotFoundError:
                logger.debug("dns-sd not found")

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

            # Extract TXT records
            if info.properties:
                txt = {}
                for k, v in info.properties.items():
                    key = k.decode('utf-8', errors='replace') if isinstance(k, bytes) else str(k)
                    val = v.decode('utf-8', errors='replace') if isinstance(v, bytes) else str(v)
                    txt[key] = val

                # Parse cmbSvc JSON
                if 'cmbSvc' in txt:
                    try:
                        svc = json.loads(txt['cmbSvc'])
                        result['services'] = svc
                        if 'HandShake' in svc:
                            result['port'] = int(svc['HandShake'])
                    except (json.JSONDecodeError, ValueError):
                        pass

                # Extract device ID from name
                # transConnectService-{device_id}-{timestamp}
                name = result['name']
                if 'transConnectService-' in name:
                    parts = name.split('transConnectService-', 1)
                    if len(parts) > 1:
                        id_part = parts[1].rsplit('-', 1)  # remove timestamp
                        result['device_id'] = id_part[0]

                # Get friendly name from advData or model
                if 'advData' in txt:
                    adv = txt['advData']
                    if 'Infinix' in adv or 'Tecno' in adv or 'Itel' in adv:
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

    for port in ports[:4]:  # limit to avoid flooding
        try:
            reader, writer = await asyncio.wait_for(
                asyncio.open_connection(host, port),
                timeout=2.0,
            )
            # Send a probe (0x00 byte to see if server responds)
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
        # Get all interfaces with IPs
        output = subprocess.check_output(
            ['ifconfig', '-a'], text=True, timeout=5
        )

        current_iface = None
        wifi_ifaces = {'en0', 'en1'}  # typical macOS WiFi Ethernet interfaces
        for line in output.splitlines():
            if line and line[0].isalpha():
                current_iface = line.split(':')[0]
            if 'inet ' in line and current_iface:
                # Skip known WiFi interfaces
                if current_iface in wifi_ifaces:
                    continue
                # Skip loopback
                if current_iface == 'lo0':
                    continue
                parts = line.strip().split()
                addr_idx = parts.index('inet') + 1
                if addr_idx < len(parts):
                    ip = parts[addr_idx]
                    # Android USB tether typically uses 192.168.42.x or 192.168.43.x
                    if ip.startswith('192.168.42.') or ip.startswith('192.168.43.'):
                        # Phone is the gateway (.1 or .254 usually)
                        gateway = ip.rsplit('.', 1)[0] + '.1'
                        logger.info(f"USB tether detected on {current_iface}: {ip}, phone->{gateway}")
                        return gateway
                    # Also check other non-WiFi interfaces for USB Ethernet
                    if ip.startswith('10.') or ip.startswith('172.') or ip.startswith('192.168.'):
                        # Try both .1 and .254 as gateway
                        for suffix in ['.1', '.254']:
                            candidate = ip.rsplit('.', 1)[0] + suffix
                            if candidate != ip:
                                # Quick check if this IP is reachable
                                rc = subprocess.call(
                                    ['ping', '-c', '1', '-W', '1', candidate],
                                    stdout=subprocess.DEVNULL,
                                    stderr=subprocess.DEVNULL,
                                )
                                if rc == 0:
                                    # Don't match if it's a known router IP (common on en0 subnet)
                                    # Only return if this is a DIFFERENT subnet from en0
                                    logger.info(f"USB tether phone at {candidate}")
                                    return candidate

        return None
    except Exception as e:
        logger.debug(f"USB tether detection error: {e}")
        return None


async def try_tether_connect() -> Optional[TranCastProtocol]:
    """
    Detect phone via USB tether and try to connect using TranCastProtocol.

    Returns connected protocol instance or None.
    """
    phone_ip = detect_usb_tether_phone()
    if not phone_ip:
        logger.warning("No USB tethered phone detected")
        return None

    # First try to get handshake port from mDNS
    devices = TranCastDiscoverer.discover(timeout=2.0)
    handshake_port = PORT_HANDSHAKE_DEFAULT
    if devices:
        handshake_port = devices[0].get('port', PORT_HANDSHAKE_DEFAULT)
        logger.info(f"Using handshake port {handshake_port} from mDNS discovery")

    client = TranCastProtocol(host=phone_ip, handshake_port=handshake_port)
    if await client.connect():
        logger.info(f"Connected to phone at {phone_ip}:{handshake_port} via USB tether!")
        return client

    # Try known ports as fallback
    for port in [handshake_port, PORT_SCREENCAST, PORT_UCHO, PORT_AUDIOSINK]:
        if port != handshake_port:
            client = TranCastProtocol(host=phone_ip, handshake_port=port)
            if await client.connect():
                logger.info(f"Connected via port {port}")
                return client

    return None


# ── IPv6 Link-Local Connection ────────────────────────────────────────────────

def find_phone_ipv6(mac_prefix: str = "2e:8c:a8") -> Optional[str]:
    """
    Try to find phone's IPv6 link-local address via ARP/neighbor table.
    Phone's MAC in the capture starts with 2e:8c:a8.

    Returns full IPv6 address string or None.
    """
    import subprocess
    import re
    try:
        # Check neighbor cache
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
