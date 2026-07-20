"""
NIU CAST — WiFi Direct Bridge

Uses ADB to query and control the phone's WiFi Direct capabilities.
When the phone connects to *something* via P2P (even itself), the Transsion
services listening on ports 8900-8904 become accessible on the P2P interface.

This tool:
  1. Checks phone WiFi/P2P state via ADB shell
  2. Lists known P2P peers
  3. Can initiate P2P connection to the macOS machine (if supported)
  4. Gets P2P interface IP for direct connection

Usage:
    python3 -m niu_cast --wifi-direct          # Show WiFi Direct state
    python3 -m niu_cast --wifi-direct --scan   # Scan for P2P peers
"""

import json
import logging
import re
import subprocess
import sys
import time
from typing import Optional, List, Dict

logger = logging.getLogger(__name__)


def adb_shell(cmd: str) -> str:
    """Run a command via ADB shell, return stdout."""
    try:
        result = subprocess.run(
            ["adb", "shell", cmd],
            capture_output=True,
            text=True,
            timeout=10,
        )
        return result.stdout.strip()
    except Exception as e:
        logger.debug(f"ADB shell error: {e}")
        return ""


def get_wifi_direct_state() -> Dict:
    """Query the phone's WiFi Direct state via ADB."""
    state = {}

    # Check if WiFi is on
    wifi_enabled = adb_shell("dumpsys wifi | grep 'Wi-Fi is' | head -1")
    state["wifi"] = wifi_enabled or "unknown"

    # Get P2P state
    p2p_state = adb_shell("dumpsys wifi p2p | head -50")
    state["p2p_raw"] = p2p_state

    # Check P2P interface
    p2p_iface = adb_shell("iw dev 2>/dev/null | grep Interface | head -5")
    if not p2p_iface:
        p2p_iface = adb_shell("ifconfig | grep -E 'p2p|wlan' | head -5")
    state["interfaces"] = p2p_iface

    # List P2P peers
    peers = adb_shell("wifi p2p peers 2>/dev/null || dumpsys wifi p2p | grep -i peer | head -10")
    state["peers"] = peers

    # Get IP of P2P interface
    ip_addr = adb_shell("ifconfig p2p0 2>/dev/null || ifconfig wlan0 2>/dev/null || ip addr show 2>/dev/null | head -30")
    state["ip_addr"] = ip_addr

    # Check if Transsion services are running
    services = adb_shell("netstat -tlnp 2>/dev/null || ss -tlnp 2>/dev/null || cat /proc/net/tcp 2>/dev/null | head -20")
    state["listening"] = services

    return state


def scan_p2p_peers() -> List[Dict]:
    """Initiate P2P peer discovery and return found devices."""
    logger.info("Starting WiFi Direct peer discovery...")

    # Trigger P2P find
    result = adb_shell("wifi p2p find 2>/dev/null || svc wifi enable 2>/dev/null")
    logger.info(f"P2P find triggered: {result[:100] if result else 'OK'}")

    # Wait for discovery
    time.sleep(3)

    # Get peers
    peers_output = adb_shell("wifi p2p peers 2>/dev/null || dumpsys wifi p2p | grep -A5 'Peer:' | head -40")
    logger.info(f"Peers: {peers_output[:200] if peers_output else 'none found'}")

    peers = []
    for line in peers_output.split("\n"):
        if "device" in line.lower() or "peer" in line.lower() or ":" in line:
            peers.append({"raw": line.strip()})

    return peers


def force_p2p_connect(peer_mac: str) -> bool:
    """
    Try to initiate P2P connection to a peer by MAC address.
    The macOS machine needs to be discoverable (AWDL not available on Hackintosh).

    Alternative: connect to a known P2P device or use the phone as GO.
    """
    logger.info(f"Attempting P2P connect to {peer_mac}...")
    result = adb_shell(f"wifi p2p connect {peer_mac} 2>/dev/null")
    logger.info(f"P2P connect result: {result[:200]}")
    return "success" in result.lower() or "connected" in result.lower()


def find_trancast_services() -> Dict:
    """Check if Transsion services are listening and on which interfaces."""
    services = {}

    # Check for com.transsion processes
    ps = adb_shell("ps -A 2>/dev/null | grep -i transsion || ps | grep -i transsion")
    if ps:
        services["processes"] = [l.strip() for l in ps.split("\n") if l.strip()]

    # Try to query the PC Connect service directly
    # Check if it's a bound service
    dumpsys = adb_shell("dumpsys package com.transsion.pcconnect 2>/dev/null | head -30")
    if dumpsys:
        services["package_info"] = dumpsys

    # Check for Cast/WiFi Display services
    cast = adb_shell("settings list global | grep -i cast 2>/dev/null || settings list system | grep -i cast")
    if cast:
        services["cast_settings"] = cast

    return services


def show_full_state() -> bool:
    """Show full WiFi Direct state. Returns True if ADB connected."""
    result = subprocess.run(["adb", "devices"], capture_output=True, text=True, timeout=5)
    lines = result.stdout.strip().split("\n")
    has_device = False
    for line in lines[1:]:
        if line.strip() and "device" in line and "offline" not in line:
            has_device = True
            break

    if not has_device:
        print("No ADB device connected.", file=sys.stderr)
        print("Connect phone via USB with USB Debugging enabled.", file=sys.stderr)
        return False

    print("\n=== WiFi Direct State ===")
    state = get_wifi_direct_state()
    print(f"WiFi: {state.get('wifi', 'unknown')}")
    print(f"Interfaces: {state.get('interfaces', 'unknown')}")
    print(f"P2P Peers: {state.get('peers', 'none')}")
    print(f"\nIP Addresses:\n{state.get('ip_addr', 'N/A')[:300]}")
    print(f"\nListening ports:\n{state.get('listening', 'N/A')[:300]}")

    print("\n=== Transsion Services ===")
    svc = find_trancast_services()
    if svc.get("processes"):
        print("Processes:")
        for p in svc["processes"]:
            print(f"  {p}")
    else:
        print("  No Transsion processes detected")

    return True


def main():
    """CLI entry."""
    import argparse

    parser = argparse.ArgumentParser(
        description="NIU CAST — WiFi Direct Bridge",
    )
    parser.add_argument("--scan", action="store_true", help="Scan for P2P peers")
    parser.add_argument("--connect", metavar="MAC", help="Connect to P2P peer by MAC")
    parser.add_argument("--services", action="store_true", help="Check Transsion service status")
    args = parser.parse_args()

    # Check ADB first
    result = subprocess.run(["adb", "devices"], capture_output=True, text=True, timeout=5)
    if "device" not in result.stdout or "attached" in result.stdout and "device" not in result.stdout.split("\n")[-1]:
        # Check more carefully
        lines = result.stdout.strip().split("\n")
        has_device = False
        for line in lines[1:]:
            if line.strip() and "device" in line and "offline" not in line:
                has_device = True
                break
        if not has_device:
            print("No ADB device connected.")
            return 1

    if args.connect:
        success = force_p2p_connect(args.connect)
        print(f"P2P connect {'succeeded' if success else 'failed'}")
        return 0 if success else 1

    if args.scan:
        peers = scan_p2p_peers()
        if peers:
            print(f"\nFound {len(peers)} P2P device(s):")
            for p in peers:
                print(f"  {p['raw']}")
        else:
            print("No P2P peers found.")
        return 0

    if args.services:
        svc = find_trancast_services()
        print("\nTranssion Service Status:")
        print("=" * 40)
        if svc.get("processes"):
            print("Processes running:")
            for p in svc["processes"]:
                print(f"  {p}")
        if svc.get("package_info"):
            print(f"\nPackage info:\n{svc['package_info'][:500]}")
        if svc.get("cast_settings"):
            print(f"\nCast settings:\n{svc['cast_settings']}")
        if not svc:
            print("No Transsion services detected.")
        return 0

    # Default: show full state
    print("\n=== WiFi Direct State ===")
    state = get_wifi_direct_state()
    print(f"WiFi: {state.get('wifi', 'unknown')}")
    print(f"Interfaces: {state.get('interfaces', 'unknown')}")
    print(f"P2P Peers: {state.get('peers', 'none')}")
    print(f"\nIP Addresses:\n{state.get('ip_addr', 'N/A')[:300]}")
    print(f"\nListening ports:\n{state.get('listening', 'N/A')[:300]}")
    print(f"\nP2P Raw State:\n{state.get('p2p_raw', 'N/A')[:500]}")

    # Also show Transsion services
    print("\n=== Transsion Services ===")
    svc = find_trancast_services()
    if svc.get("processes"):
        print("Processes:")
        for p in svc["processes"]:
            print(f"  {p}")
    else:
        print("  No Transsion processes detected (PC Connect may not be active)")

    return 0


if __name__ == "__main__":
    sys.exit(main())
