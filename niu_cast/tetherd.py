"""
NIU CAST — Tether Daemon (tetherd)

Persistent background monitor that watches for USB tether interface changes
on macOS and automatically attempts Transsion protocol connection.

Usage:
    niu-cast tetherd              # run in foreground
    niu-cast tetherd --daemon     # daemonize (macOS launchd)

When a new non-WiFi interface with internet connectivity appears:
  1. Detect the phone's IP (gateway of that subnet)
  2. Discover the handshake port via mDNS
  3. Attempt TranCastProtocol connection on each known port
  4. Report success/failure
"""

import asyncio
import logging
import os
import subprocess
import sys
import time
from typing import Optional, Set

from .transsion_protocol import (
    TRANSCAST_PORTS,
    TranCastDiscoverer,
    TranCastProtocol,
    logger as proto_logger,
)

logger = logging.getLogger(__name__)

# Polling interval (seconds)
POLL_INTERVAL = 2.0

# Interfaces to ignore (macOS)
IGNORE_IFACES = {'lo0', 'gif0', 'stf0', 'utun0', 'utun1', 'utun2', 'utun3', 'utun4', 'utun5'}


def get_active_interfaces() -> dict:
    """Return {iface_name: ip_address} for all non-lo non-utun interfaces."""
    result = {}
    try:
        output = subprocess.check_output(
            ['ifconfig', '-a'], text=True, timeout=5
        )
        current = None
        for line in output.splitlines():
            if line and line[0].isalpha():
                current = line.split(':')[0]
            if 'inet ' in line and current:
                if current in IGNORE_IFACES:
                    continue
                parts = line.strip().split()
                addr_idx = parts.index('inet') + 1
                if addr_idx < len(parts):
                    ip = parts[addr_idx]
                    result[current] = ip
    except Exception:
        pass
    return result


def find_phone_on_subnet(ip: str) -> Optional[str]:
    """Given Mac's IP on a subnet, find phone's IP (gateway.1 or .254)."""
    subnet = ip.rsplit('.', 1)[0]
    for suffix in ['.1', '.254']:
        candidate = f"{subnet}{suffix}"
        if candidate != ip:
            rc = subprocess.call(
                ['ping', '-c', '1', '-W', '1', candidate],
                stdout=subprocess.DEVNULL,
                stderr=subprocess.DEVNULL,
            )
            if rc == 0:
                return candidate
    return None


async def try_connect_all(phone_ip: str) -> Optional[TranCastProtocol]:
    """Try connecting to phone on all known Transsion ports."""
    # First try to get handshake port from mDNS
    logger.info(f"Discovering services via mDNS (max 3s)...")
    devices = TranCastDiscoverer.discover(timeout=3.0)

    ports_to_try = set(TRANSCAST_PORTS.values())
    if devices:
        hs_port = devices[0].get('port')
        if hs_port:
            ports_to_try.add(hs_port)
            logger.info(f"mDNS suggests handshake port: {hs_port}")

    for port in sorted(ports_to_try):
        logger.info(f"  Trying {phone_ip}:{port}...")
        client = TranCastProtocol(host=phone_ip, handshake_port=port)
        if await client.connect():
            logger.info(f"✅ Connected on port {port}!")
            return client
    return None


async def monitor_loop():
    """Continuously monitor interfaces for a tethered phone."""
    logger.info("=" * 50)
    logger.info("tetherd — USB Tether Monitor")
    logger.info("=" * 50)
    logger.info(f"Polling every {POLL_INTERVAL}s for new interfaces...")
    logger.info("")
    logger.info("To connect your phone:")
    logger.info("  1. Plug phone via USB")
    logger.info("  2. Settings → Network → Hotspot & Tethering → USB Tethering → ON")
    logger.info("")

    prev_interfaces: dict = {}

    while True:
        current = get_active_interfaces()
        new_ifaces = {
            k: v for k, v in current.items() if k not in prev_interfaces
        }

        if new_ifaces:
            logger.info(f"New interface(s) detected: {new_ifaces}")
            for iface, ip in new_ifaces.items():
                # Check if this is a known WiFi interface
                if iface.startswith('en') and ip.startswith('10.234.'):
                    logger.info(f"  Skipping main LAN interface ({iface}: {ip})")
                    continue

                phone_ip = find_phone_on_subnet(ip)
                if phone_ip:
                    logger.info(f"  Possible phone at {phone_ip}")
                    client = await try_connect_all(phone_ip)
                    if client:
                        logger.info(f"🎉 Connected via {iface} ({ip}) → phone {phone_ip}!")
                        # Keep the connection alive — return it
                        return client, phone_ip, iface
                    else:
                        logger.info(f"  No Transsion services on {phone_ip}")
                else:
                    logger.info(f"  No reachable gateway on {iface} ({ip})")

        prev_interfaces = current
        await asyncio.sleep(POLL_INTERVAL)


def main():
    """Entry point for `niu-cast tetherd` command."""
    logging.basicConfig(
        level=logging.INFO,
        format="%(asctime)s [%(levelname)s] %(message)s",
        datefmt="%H:%M:%S",
    )

    if '--daemon' in sys.argv:
        # TODO: launchd plist setup
        logger.warning("Daemon mode not yet implemented, running in foreground")

    try:
        client, phone_ip, iface = asyncio.run(monitor_loop())
        print(f"\n✅ Connected! {iface} via {phone_ip}")
        print("  Integration with GUI TBD.")
    except KeyboardInterrupt:
        print("\nShutting down tetherd.")
    except SystemExit:
        pass


if __name__ == "__main__":
    main()
