"""
NIU CAST — APK Extractor

Extracts the PC Connect APK from a connected Transsion device for
reverse engineering the tranCast protocol.

Usage:
    python3 -m niu_cast.apk_extract          # Extract PC Connect APK
    python3 -m niu_cast.apk_extract --list   # List all Transsion packages
    python3 -m niu_cast.apk_extract --all    # Extract all Transsion APKs

Requires ADB connection (USB Debugging).
"""

import logging
import os
import subprocess
import sys
import zipfile
from pathlib import Path
from typing import List, Optional

logger = logging.getLogger(__name__)

# Transsion-related package patterns
TRANSSION_PACKAGES = [
    "com.transsion.pcconnect",
    "com.transsion.pcconnect.*",
    "com.transsion.*cast*",
    "com.transsion.*mirror*",
    "com.transsion.*screen*",
    "com.transsion.cast",
    "com.transsion.mirror",
    "com.transsion.connect",
    "com.transsion.phoenix",
    "com.transsion.wfd",
    "com.transsion.wifidisplay",
]

# Known Transsion packages from various sources
KNOWN_PACKAGES = [
    "com.transsion.pcconnect",
    "com.transsion.pcconnect.service",
    "com.transsion.cast",
    "com.transsion.wifidisplay",
    "com.transsion.mirror",
    "com.transsion.screenrecorder",
]


def adb_command(args: List[str]) -> str:
    """Run an ADB command and return stdout."""
    try:
        result = subprocess.run(
            ["adb"] + args,
            capture_output=True,
            text=True,
            timeout=30,
        )
        if result.returncode != 0:
            logger.error(f"ADB error: {result.stderr}")
            return ""
        return result.stdout.strip()
    except FileNotFoundError:
        logger.error("adb not found in PATH")
        return ""
    except subprocess.TimeoutExpired:
        logger.error("ADB command timed out")
        return ""


def check_adb_device() -> bool:
    """Check if a device is connected via ADB."""
    output = adb_command(["devices"])
    lines = output.split("\n")
    for line in lines[1:]:  # skip "List of devices attached"
        if line.strip() and "device" in line and "offline" not in line:
            return True
    return False


def list_transsion_packages() -> List[str]:
    """List all packages matching Transsion patterns."""
    output = adb_command(["shell", "pm", "list", "packages", "transsion"])
    packages = []
    for line in output.split("\n"):
        line = line.strip()
        if line.startswith("package:"):
            packages.append(line[8:])
    return packages


def find_pc_connect_apk(package_name: str) -> Optional[str]:
    """Find the APK path for a given package."""
    output = adb_command(["shell", "pm", "path", package_name])
    if output.startswith("package:"):
        return output[8:]
    return None


def pull_apk(package_name: str, output_dir: Path) -> Optional[Path]:
    """Pull an APK from the device and save to output_dir."""
    apk_path = find_pc_connect_apk(package_name)
    if not apk_path:
        logger.error(f"Package {package_name} not found on device")
        return None

    output_dir.mkdir(parents=True, exist_ok=True)
    output_path = output_dir / f"{package_name}.apk"

    logger.info(f"Pulling {package_name} from {apk_path}...")
    result = subprocess.run(
        ["adb", "pull", apk_path, str(output_path)],
        capture_output=True,
        text=True,
        timeout=60,
    )

    if result.returncode != 0:
        logger.error(f"Pull failed: {result.stderr}")
        return None

    if output_path.exists():
        size_mb = output_path.stat().st_size / (1024 * 1024)
        logger.info(f"Saved {output_path} ({size_mb:.1f} MB)")
        return output_path
    return None


def analyze_apk(apk_path: Path) -> dict:
    """Basic analysis of an APK file."""
    info = {"path": str(apk_path), "size": apk_path.stat().st_size}

    try:
        with zipfile.ZipFile(apk_path, "r") as zf:
            # List files that might contain protocol info
            interesting = []
            for name in zf.namelist():
                lower = name.lower()
                if any(x in lower for x in [
                    "protocol", "handshake", "socket", "connect",
                    "trancast", "transsion", "mirror", "cast",
                    "native", "so", "lib",
                ]):
                    interesting.append(name)

            info["interesting_files"] = interesting[:30]

            # Check for native libraries
            libs = [n for n in zf.namelist() if "lib/" in n and n.endswith((".so", ".dll"))]
            info["native_libs"] = libs[:20]

    except Exception as e:
        logger.warning(f"APK analysis error: {e}")

    return info


def decompile_apk(apk_path: Path, output_dir: Path) -> Optional[Path]:
    """Try to decompile APK using apktool or jadx if available."""
    # Check for jadx
    jadx = subprocess.run(["which", "jadx"], capture_output=True, text=True).stdout.strip()
    if jadx:
        out = output_dir / apk_path.stem
        logger.info(f"Decompiling with jadx to {out}...")
        result = subprocess.run(
            ["jadx", "-d", str(out), str(apk_path)],
            capture_output=True,
            text=True,
            timeout=120,
        )
        if result.returncode == 0:
            return out
        logger.warning(f"jadx failed: {result.stderr[:200]}")
    else:
        logger.info("jadx not installed, skipping decompilation")

    # Check for apktool
    apktool = subprocess.run(["which", "apktool"], capture_output=True, text=True).stdout.strip()
    if apktool:
        out = output_dir / f"{apktool_path.stem}_decoded"
        logger.info(f"Decompiling with apktool to {out}...")
        result = subprocess.run(
            ["apktool", "d", str(apk_path), "-o", str(out), "-f"],
            capture_output=True,
            text=True,
            timeout=120,
        )
        if result.returncode == 0:
            return out
        logger.warning(f"apktool failed: {result.stderr[:200]}")

    return None


def main():
    """CLI entry point."""
    import argparse

    parser = argparse.ArgumentParser(
        description="NIU CAST — APK Extractor for Transsion PC Connect"
    )
    parser.add_argument("--list", action="store_true", help="List Transsion packages on device")
    parser.add_argument("--all", action="store_true", help="Extract all Transsion packages")
    parser.add_argument("--decompile", action="store_true", help="Decompile extracted APKs")
    parser.add_argument("-o", "--output", default="apk_extract", help="Output directory")
    args = parser.parse_args()

    logging.basicConfig(
        level=logging.INFO,
        format="%(asctime)s [%(levelname)s] %(message)s",
        datefmt="%H:%M:%S",
    )

    # Check ADB
    if not check_adb_device():
        logger.error("No ADB device connected. Connect your phone with USB Debugging enabled.")
        return 1

    output_dir = Path(args.output)

    if args.list:
        packages = list_transsion_packages()
        if not packages:
            logger.info("No Transsion packages found on device")
        else:
            print("\nTranssion packages on device:")
            print("=" * 40)
            for pkg in packages:
                print(f"  📦 {pkg}")
        return 0

    # Extract packages
    packages = list_transsion_packages()
    if not packages:
        logger.warning("No Transsion packages found. Trying known package names...")
        # Try known package names directly
        for pkg in KNOWN_PACKAGES:
            apk_path = find_pc_connect_apk(pkg)
            if apk_path:
                packages.append(pkg)

    if not packages:
        logger.error("Could not find any Transsion packages on device.")
        logger.info("Make sure PC Connect is installed and you're using USB Debugging.")
        return 1

    logger.info(f"Found {len(packages)} Transsion package(s): {packages}")

    extracted = []
    for pkg in packages:
        apk = pull_apk(pkg, output_dir)
        if apk:
            info = analyze_apk(apk)
            extracted.append(info)

    if not extracted:
        logger.error("Failed to extract any APKs.")
        return 1

    print(f"\nExtracted {len(extracted)} APK(s) to {output_dir.absolute()}:")
    for info in extracted:
        size_mb = info["size"] / (1024 * 1024)
        print(f"  📦 {Path(info['path']).name} ({size_mb:.1f} MB)")
        if info.get("interesting_files"):
            print(f"     Interesting files: {len(info['interesting_files'])}")
            for f in info["interesting_files"][:5]:
                print(f"       - {f}")
        if info.get("native_libs"):
            print(f"     Native libs: {len(info['native_libs'])}")
            for lib in info["native_libs"][:5]:
                print(f"       - {lib}")

    # Decompile if requested
    if args.decompile:
        decompiled_dir = output_dir / "decompiled"
        for info in extracted:
            apk_path = Path(info["path"])
            out = decompile_apk(apk_path, decompiled_dir)
            if out:
                print(f"  Decompiled to {out}")

    return 0


if __name__ == "__main__":
    sys.exit(main())
