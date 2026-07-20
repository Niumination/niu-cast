"""
NIU CAST — Auto-Connect (tanpa ADB)

Mencoba semua metode koneksi wireless ke HP Infinix:
  1. mDNS discovery → connect langsung
  2. USB Tether detection → connect via gateway
  3. IPv6 Link-Local → connect via NDP
  4. TCP scan subnet → brute-force port 9452

Usage:
    python3 -m niu_cast.auto_connect                    # auto
    python3 -m niu_cast.auto_connect --scan-subnet      # scan 192.168.1.0/24
    python3 -m niu_cast.auto_connect --monitor          # monitor mode
"""

import asyncio
import ipaddress
import logging
import socket
import subprocess
import sys
import time
from typing import Optional, List

from .transsion_protocol import (
    PORT_TCCP, PORT_CONTROL, PORT_FILE, PORT_SCREENCAST,
    TranCastProtocol, TranCastDiscoverer,
    logger as proto_logger,
)

logger = logging.getLogger(__name__)

# ── Utility ────────────────────────────────────────────────────────────────────

def ping(host: str, timeout: float = 1.0) -> bool:
    """Cek apakah host reachable via ping."""
    try:
        rc = subprocess.call(
            ['ping', '-c', '1', '-W', str(int(timeout)), host],
            stdout=subprocess.DEVNULL, stderr=subprocess.DEVNULL,
            timeout=timeout + 1,
        )
        return rc == 0
    except Exception:
        return False


def get_local_ip() -> Optional[str]:
    """Dapatkan IP lokal (bukan loopback)."""
    try:
        s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
        s.settimeout(1)
        s.connect(('8.8.8.8', 80))
        ip = s.getsockname()[0]
        s.close()
        return ip
    except Exception:
        return None


def scan_subnet(subnet: str = '192.168.1.0/24', port: int = PORT_TCCP,
                timeout: float = 0.5) -> List[str]:
    """
    Scan subnet untuk device yang buka port TCCP.
    Cepet karena cuma test TCP connect.
    """
    found = []
    net = ipaddress.ip_network(subnet, strict=False)
    hosts = list(net.hosts())

    logger.info(f"Scan {subnet} port {port} ({len(hosts)} hosts)...")

    for host in hosts:
        ip = str(host)
        if ping(ip, timeout=0.3):
            try:
                sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
                sock.settimeout(timeout)
                result = sock.connect_ex((ip, port))
                sock.close()
                if result == 0:
                    logger.info(f"  ✓ {ip}:{port} — TERBUKA!")
                    found.append(ip)
            except Exception:
                pass

    return found


# ── Metode Koneksi ─────────────────────────────────────────────────────────────

async def try_mdns(timeout: float = 3.0) -> Optional[TranCastProtocol]:
    """Coba discover via mDNS lalu connect."""
    logger.info("[1/4] Mencari via mDNS...")
    devices = TranCastDiscoverer.discover(timeout=timeout)
    if not devices:
        logger.info("  Tidak ada device via mDNS")
        return None

    for dev in devices:
        host = dev.get('host', '')
        port = dev.get('port', PORT_TCCP)
        logger.info(f"  Ditemukan: {dev.get('name', '?')} @ {host}:{port}")

        client = TranCastProtocol(host, port)
        if await client.connect():
            logger.info(f"  ✓ Connect OK ke {host}:{port}")
            return client

    return None


def detect_usb_tether() -> Optional[str]:
    """
    Deteksi phone via USB Tethering.
    Cari interface non-WiFi dengan IP di subnet 192.168.42.x atau 192.168.43.x.
    """
    logger.info("[2/4] Deteksi USB Tether...")
    try:
        output = subprocess.check_output(['ifconfig', '-a'], text=True, timeout=5)
        current_iface = None

        for line in output.splitlines():
            if line and line[0].isalpha():
                current_iface = line.split(':')[0]
            if 'inet ' in line and current_iface:
                if current_iface in {'lo0', 'gif0', 'stf0', 'en0', 'en1'} or \
                   current_iface.startswith('utun'):
                    continue
                parts = line.strip().split()
                idx = parts.index('inet') + 1
                if idx < len(parts):
                    ip = parts[idx]
                    logger.info(f"  Interface {current_iface}: {ip}")
                    if ip.startswith('192.168.42.') or ip.startswith('192.168.43.'):
                        gateway = ip.rsplit('.', 1)[0] + '.1'
                        logger.info(f"  → USB Tether detected! Phone: {gateway}")
                        return gateway

        logger.info("  Tidak ada USB Tether")
        return None
    except Exception as e:
        logger.debug(f"  Error: {e}")
        return None


async def try_usb_tether() -> Optional[TranCastProtocol]:
    """Coba connect via USB Tether."""
    phone_ip = detect_usb_tether()
    if not phone_ip:
        return None

    if not ping(phone_ip):
        logger.info(f"  {phone_ip} tidak reachable")
        return None

    client = TranCastProtocol(phone_ip, PORT_TCCP)
    if await client.connect():
        logger.info(f"  ✓ Connect OK via USB Tether ke {phone_ip}")
        return client

    return None


def find_phone_ipv6(mac_prefix: str = "2e:8c:a8") -> Optional[str]:
    """Cari IPv6 link-local phone via NDP."""
    logger.info("[3/4] Deteksi IPv6 Link-Local...")
    try:
        output = subprocess.check_output(
            ['ndp', '-an'], text=True, timeout=5, stderr=subprocess.DEVNULL
        )
        import re
        for line in output.splitlines():
            if mac_prefix.lower() in line.lower():
                m = re.search(r'([a-f0-9:]+)%?(\w*)', line)
                if m:
                    ipv6 = m.group(1)
                    scope = m.group(2) or 'en0'
                    logger.info(f"  Ditemukan: {ipv6}%{scope}")
                    return f"{ipv6}%{scope}"
    except Exception as e:
        logger.debug(f"  Error: {e}")

    logger.info("  Tidak ada IPv6 link-local")
    return None


async def try_ipv6() -> Optional[TranCastProtocol]:
    """Coba connect via IPv6 link-local."""
    phone_ip = find_phone_ipv6()
    if not phone_ip:
        return None

    client = TranCastProtocol(phone_ip, PORT_TCCP)
    if await client.connect():
        logger.info(f"  ✓ Connect OK via IPv6 ke {phone_ip}")
        return client

    return None


async def try_subnet_scan(subnet: str = None) -> Optional[TranCastProtocol]:
    """Scan subnet untuk port 9452."""
    logger.info(f"[4/4] Scan subnet..." )
    if subnet is None:
        local_ip = get_local_ip()
        if not local_ip:
            logger.info("  Tidak bisa deteksi subnet lokal")
            return None
        subnet = str(ipaddress.ip_network(f"{local_ip}/24", strict=False))

    found = scan_subnet(subnet, port=PORT_TCCP)
    if not found:
        logger.info("  Tidak ada yang buka port 9452")
        return None

    for ip in found:
        client = TranCastProtocol(ip, PORT_TCCP)
        if await client.connect():
            logger.info(f"  ✓ Connect OK via subnet scan ke {ip}")
            return client

    return None


# ── Orchestrator ───────────────────────────────────────────────────────────────

async def auto_connect(subnet: str = None) -> Optional[TranCastProtocol]:
    """
    Coba semua metode koneksi wireless secara berurutan.
    Return client pertama yang berhasil.
    """
    methods = [
        ('mDNS', lambda: try_mdns()),
        ('USB Tether', lambda: try_usb_tether()),
        ('IPv6 Link-Local', lambda: try_ipv6()),
        ('Subnet Scan', lambda: try_subnet_scan(subnet)),
    ]

    for name, method in methods:
        logger.info(f"\n{'='*50}")
        logger.info(f"Mencoba: {name}")
        logger.info(f"{'='*50}")
        try:
            result = await method()
            if result:
                logger.info(f"\n✅ CONNECTED via {name}!")
                return result
        except Exception as e:
            logger.debug(f"  Error: {e}")

    logger.info("\n❌ Semua metode gagal.")
    logger.info("\nTips:")
    logger.info("  1. USB Tether: Settings → Hotspot & Tethering → USB Tethering")
    logger.info("  2. WiFi: Pastikan HP dan Mac di jaringan yang sama")
    logger.info("  3. Nyalakan 'PC Connect' / 'TCCP' di HP Infinix")
    return None


# ── Monitor Mode ───────────────────────────────────────────────────────────────

async def monitor_loop(interval: float = 5.0):
    """Monitor terus-menerus, auto-connect kalo ada device baru."""
    logger.info("=" * 50)
    logger.info("  NIU CAST — Auto-Connect Monitor")
    logger.info("  Mencari HP Infinix setiap %d detik..." % interval)
    logger.info("  Tekan Ctrl+C untuk stop")
    logger.info("=" * 50)

    connected = False
    while True:
        if not connected:
            client = await auto_connect()
            if client:
                connected = True
                logger.info("\nTerhubung! Mencoba get_device_info...")
                info = await client.get_device_info()
                logger.info(f"Device info: {info}")
                await client.disconnect()
                logger.info("Disconnected. Melanjutkan monitor...")
        await asyncio.sleep(interval)


# ── CLI ────────────────────────────────────────────────────────────────────────

def main():
    """CLI entry."""
    import argparse
    logging.basicConfig(level=logging.INFO, format='%(message)s')

    parser = argparse.ArgumentParser(
        description='NIU CAST — Auto-Connect tanpa ADB',
    )
    parser.add_argument('--scan-subnet', metavar='SUBNET', nargs='?',
                        const='auto', help='Scan subnet untuk port 9452')
    parser.add_argument('--monitor', action='store_true',
                        help='Monitor mode (auto-connect tiap 5 detik)')
    parser.add_argument('--list-mdns', action='store_true',
                        help='List device via mDNS')
    args = parser.parse_args()

    if args.list_mdns:
        devices = TranCastDiscoverer.discover(timeout=4.0)
        if devices:
            print(f"\nDitemukan {len(devices)} device(s):")
            for d in devices:
                print(f"  {d.get('name', '?')} @ {d.get('host', '?')}:{d.get('port', '?')}")
                if d.get('services'):
                    print(f"    Services: {d['services']}")
        else:
            print("Tidak ada device Transsion di jaringan")
        return 0

    if args.scan_subnet:
        if args.scan_subnet == 'auto':
            local_ip = get_local_ip()
            if not local_ip:
                print("Gagal deteksi IP lokal")
                return 1
            subnet = str(ipaddress.ip_network(f"{local_ip}/24", strict=False))
        else:
            subnet = args.scan_subnet
        found = scan_subnet(subnet, port=PORT_TCCP)
        if found:
            print(f"\nDevice dengan port {PORT_TCCP} terbuka:")
            for ip in found:
                print(f"  ✓ {ip}")
        else:
            print(f"Tidak ada device dengan port {PORT_TCCP} di {subnet}")
        return 0

    if args.monitor:
        asyncio.run(monitor_loop())
        return 0

    # Default: auto-connect sekali
    asyncio.run(auto_connect())
    return 0


if __name__ == '__main__':
    sys.exit(main())
