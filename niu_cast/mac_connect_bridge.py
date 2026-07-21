"""
NIU CAST — Mac Connect Bridge (ADB + scrcpy)

Menggabungkan pendekatan mac-connect (ADB wireless + scrcpy) ke dalam niu-cast.
Metode ini TERBUKTI bekerja untuk Infinix GT 30 Pro — berbeda dengan TCCP yang
masih dalam tahap reverse engineering.

Alur koneksi:
  1. Setup Wireless via USB (sekali): USB → adb tcpip 5555 → ekstrak IP
  2. Connect Wireless: auto-discover ARP + connect via ADB TCP
  3. Mirror + Audio: jalankan scrcpy dengan profile performance

Fitur:
  - 3 Performance Profile: High (120fps), Normal (60fps), Eco (30fps)
  - Audio forwarding toggle (scrcpy >= 2.0)
  - ARP-based IP auto-discovery
  - Multi-method IP extraction (ip route, wlan0, DHCP)
  - Config persistence (~/.niu-cast/mac-connect.json)
  - scrcpy crash-resilient flags

Usage:
    from niu_cast.mac_connect_bridge import MacConnectBridge

    bridge = MacConnectBridge()
    bridge.setup_wireless()       # USB → tcpip
    bridge.connect_wireless()     # ARP discovery + ADB connect
    bridge.launch_mirror()        # scrcpy with profile
"""

import json
import logging
import os
import re
import socket
import subprocess
import time
from typing import Optional, List

logger = logging.getLogger(__name__)

# ── Config Path ─────────────────────────────────────────────────────────────────

CONFIG_DIR = os.path.expanduser("~/.niu-cast")
CONFIG_FILE = os.path.join(CONFIG_DIR, "mac-connect.json")


# ── Mac Connect Bridge ──────────────────────────────────────────────────────────

class MacConnectBridge:
    """
    ADB + scrcpy bridge untuk koneksi wireless ke Infinix GT 30 Pro.

    Menggabungkan pendekatan mac-connect yang TERBUKTI bekerja dengan
    arsitektur modular niu-cast.

    Performance Profiles:
      - high:   120 FPS, 16 Mbps bitrate (GT 30 Pro 120Hz display)
      - normal:  60 FPS,  8 Mbps bitrate
      - eco:     30 FPS,  4 Mbps bitrate (battery saver)
    """

    def __init__(self, adb_path: str = None):
        self.adb_path = adb_path or self._find_adb()
        self.phone_ip: Optional[str] = None
        self.phone_model: Optional[str] = None
        self.performance_profile: str = "high"
        self.forward_audio: bool = True
        self._load_config()

    # ── ADB Discovery ───────────────────────────────────────────────────────────

    @staticmethod
    def _find_adb() -> str:
        """Cari ADB binary di sistem."""
        paths = [
            '/usr/local/bin/adb',
            '/opt/homebrew/bin/adb',
            '/opt/android-sdk/platform-tools/adb',
            os.path.expanduser('~/Library/Android/sdk/platform-tools/adb'),
            'adb',
        ]
        for path in paths:
            if os.path.exists(path):
                return path
        return 'adb'

    def _run_adb(self, args: list, timeout: int = 30) -> tuple:
        """Jalankan command ADB."""
        cmd = [self.adb_path] + args
        try:
            result = subprocess.run(
                cmd, capture_output=True, text=True, timeout=timeout
            )
            return result.returncode, result.stdout.strip(), result.stderr.strip()
        except subprocess.TimeoutExpired:
            return -1, "", "Timeout"
        except FileNotFoundError:
            return -1, "", "ADB not found"
        except Exception as e:
            return -1, "", str(e)

    def _find_scrcpy(self) -> Optional[str]:
        """Cari scrcpy binary."""
        try:
            rc, out, _ = self._run_adb(['--help'])  # check ADB first
            if rc == -1 and 'ADB not found' in out:
                return None
        except:
            pass
        for path in ['/usr/local/bin/scrcpy', '/opt/homebrew/bin/scrcpy', 'scrcpy']:
            if os.path.exists(path) or path == 'scrcpy':
                try:
                    subprocess.run(['which', 'scrcpy'], capture_output=True, timeout=5)
                    return 'scrcpy'
                except:
                    if os.path.exists(path):
                        return path
        return None

    # ── Config Persistence ──────────────────────────────────────────────────────

    def _load_config(self):
        """Load konfigurasi dari file."""
        try:
            os.makedirs(CONFIG_DIR, exist_ok=True)
            if os.path.exists(CONFIG_FILE):
                with open(CONFIG_FILE) as f:
                    cfg = json.load(f)
                self.phone_ip = cfg.get('phone_ip')
                self.performance_profile = cfg.get('profile', 'high')
                self.forward_audio = cfg.get('audio', True)
                logger.info(f"Config loaded: IP={self.phone_ip}, "
                            f"profile={self.performance_profile}, "
                            f"audio={self.forward_audio}")
        except Exception as e:
            logger.debug(f"Config load error: {e}")

    def _save_config(self):
        """Simpan konfigurasi."""
        try:
            os.makedirs(CONFIG_DIR, exist_ok=True)
            cfg = {
                'phone_ip': self.phone_ip,
                'profile': self.performance_profile,
                'audio': self.forward_audio,
            }
            with open(CONFIG_FILE, 'w') as f:
                json.dump(cfg, f, indent=2)
            logger.info(f"Config saved: {CONFIG_FILE}")
        except Exception as e:
            logger.warning(f"Config save error: {e}")

    # ── IP Extraction (multi-method) ────────────────────────────────────────────

    def _extract_phone_ip_usb(self) -> Optional[str]:
        """
        Ekstrak IP HP dari koneksi USB via ADB.
        Mencoba 3 metode berurutan (sama kaya mac-connect).

        Returns:
            IP address string atau None.
        """
        device_ip = None

        # Method 1: ip route → extract src address
        rc, out, _ = self._run_adb(['-d', 'shell', 'ip route'], timeout=5)
        if rc == 0:
            m = re.search(r'src\s+(\d+\.\d+\.\d+\.\d+)', out)
            if m:
                device_ip = m.group(1)
                logger.info(f"  IP method 1 (ip route): {device_ip}")

        # Method 2: wlan0 interface
        if not device_ip:
            rc, out, _ = self._run_adb(
                ['-d', 'shell', 'ip addr show wlan0'], timeout=5
            )
            if rc == 0:
                m = re.search(r'inet\s+(\d+\.\d+\.\d+\.\d+)', out)
                if m:
                    device_ip = m.group(1)
                    logger.info(f"  IP method 2 (wlan0): {device_ip}")

        # Method 3: DHCP property
        if not device_ip:
            rc, out, _ = self._run_adb(
                ['-d', 'shell', 'getprop dhcp.wlan0.ipaddress'], timeout=5
            )
            if rc == 0 and out.strip():
                device_ip = out.strip()
                logger.info(f"  IP method 3 (DHCP): {device_ip}")

        return device_ip

    def _arp_discover(self) -> Optional[str]:
        """
        Scan ARP table untuk HP Infinix dengan port 5555 terbuka.

        Sama kaya mac-connect: scan seluruh ARP cache, test TCP ke port 5555.

        Returns:
            IP address atau None.
        """
        logger.info("  Scanning ARP table for ADB port 5555...")
        try:
            rc, out, _ = self._run_adb(['--help'])  # just check ADB accessible
            # Get ARP table
            result = subprocess.run(
                ['arp', '-an'],
                capture_output=True, text=True, timeout=5
            )
            if result.returncode != 0:
                return None

            ips = re.findall(r'(\d+\.\d+\.\d+\.\d+)', result.stdout)
            logger.info(f"  ARP entries found: {len(ips)}")

            for ip in ips:
                if ip.startswith('127.'):
                    continue
                # Test TCP port 5555 (ADB)
                try:
                    sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
                    sock.settimeout(0.5)
                    result = sock.connect_ex((ip, 5555))
                    sock.close()
                    if result == 0:
                        logger.info(f"  ✓ Found ADB device at {ip}:5555")
                        return ip
                except Exception:
                    continue

            return None
        except Exception as e:
            logger.debug(f"ARP discovery error: {e}")
            return None

    # ── Wireless Setup (via USB — once) ─────────────────────────────────────────

    def setup_wireless(self) -> bool:
        """
        Setup wireless ADB via USB (perlu kabel USB).

        Flow:
          1. Tunggu USB device
          2. Identifikasi HP
          3. Ekstrak IP (multi-method)
          4. adb tcpip 5555
          5. Simpan IP ke config

        Returns:
            True jika berhasil.
        """
        logger.info("=" * 60)
        logger.info("  SETUP WIRELESS VIA USB")
        logger.info("  Pastikan HP terhubung via USB + USB Debugging ON")
        logger.info("=" * 60)

        # Wait for USB device
        rc, out, _ = self._run_adb(['-d', 'wait-for-device'], timeout=15)
        if rc != 0:
            logger.error("  ✗ Tidak ada USB device terdeteksi")
            return False

        # Get device model
        rc, model, _ = self._run_adb(
            ['-d', 'shell', 'getprop ro.product.model'], timeout=5
        )
        if rc == 0 and model:
            self.phone_model = model.strip()
            logger.info(f"  ✓ USB Device: {self.phone_model}")

        # Extract IP
        ip = self._extract_phone_ip_usb()
        if not ip:
            logger.warning("  ! Gagal extract IP otomatis")
            logger.warning("  Cek IP di Settings > About Phone > Status")
            return False

        logger.info(f"  ✓ IP terdeteksi: {ip}")

        # Enable TCP/IP mode
        logger.info("  Mengaktifkan ADB TCP/IP mode (port 5555)...")
        rc, _, err = self._run_adb(['-d', 'tcpip', '5555'], timeout=10)
        if rc != 0:
            logger.error(f"  ✗ Gagal enable TCP/IP: {err}")
            return False

        logger.info("  ✓ ADB TCP/IP mode aktif di port 5555")
        logger.info("  ✓ USB bisa dicabut sekarang")

        # Simpan IP
        self.phone_ip = ip
        self._save_config()

        logger.info(f"\n  ✅ Setup selesai! IP HP: {ip}")
        logger.info("  Jalankan: niu-cast connect")
        return True

    # ── Wireless Connect (ARP + ADB connect) ────────────────────────────────────

    def connect_wireless(self, force_discover: bool = False) -> bool:
        """
        Connect ke HP via ADB wireless.

        Flow:
          1. Coba cached IP
          2. Kalo gagal → ARP discovery
          3. adb connect IP:5555
          4. Simpan IP

        Args:
            force_discover: Abaikan cached IP, force ARP scan.

        Returns:
            True jika berhasil connect.
        """
        logger.info("=" * 60)
        logger.info("  CONNECT WIRELESS")
        logger.info("=" * 60)

        target_ip = None

        # Coba cached IP
        if self.phone_ip and not force_discover:
            logger.info(f"  Menguji cached IP: {self.phone_ip}...")
            try:
                sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
                sock.settimeout(1)
                result = sock.connect_ex((self.phone_ip, 5555))
                sock.close()
                if result == 0:
                    target_ip = self.phone_ip
                    logger.info(f"  ✓ Cached IP {target_ip} reachable")
                else:
                    logger.info(f"  ! Cached IP {self.phone_ip} unreachable")
            except Exception:
                pass

        # Fallback: ARP discovery
        if not target_ip:
            logger.info("  Mencari HP via ARP scan...")
            target_ip = self._arp_discover()
            if not target_ip:
                logger.error("  ✗ Tidak ada HP terdeteksi di jaringan")
                return False

        # ADB connect
        logger.info(f"  Menghubungkan ke {target_ip}:5555...")

        # Disconnect dulu kalo ada
        self._run_adb(['disconnect'], timeout=5)

        rc, out, err = self._run_adb(['connect', f'{target_ip}:5555'], timeout=10)

        if 'connected to' in out or 'already connected' in out:
            logger.info(f"  ✓ Berhasil connect ke {target_ip}:5555")
            self.phone_ip = target_ip
            self._save_config()

            # Dapatkan info device
            rc, model, _ = self._run_adb(
                ['-s', f'{target_ip}:5555', 'shell', 'getprop ro.product.model'],
                timeout=5
            )
            if rc == 0 and model:
                self.phone_model = model.strip()
                logger.info(f"  📱 Device: {self.phone_model}")
            return True
        else:
            logger.error(f"  ✗ Gagal connect: {out} {err}")
            return False

    # ── Screen Mirror via scrcpy ────────────────────────────────────────────────

    def launch_mirror(self) -> bool:
        """
        Jalankan scrcpy mirroring dengan profile & audio config.

        Flow:
          1. Verifikasi device connected
          2. Build scrcpy args berdasarkan profile
          3. Launch scrcpy

        Returns:
            True jika scrcpy berjalan (exit code 0).
        """
        logger.info("=" * 60)
        logger.info("  LAUNCH SCREEN MIRROR")
        logger.info("=" * 60)

        # Verifikasi device
        if not self._check_device():
            logger.error("  ✗ Tidak ada device terhubung")
            logger.error("  Jalankan 'connect' dulu")
            return False

        # Cek scrcpy
        scrcpy = self._find_scrcpy()
        if not scrcpy:
            logger.error("  ✗ scrcpy tidak ditemukan")
            logger.error("  Install: brew install scrcpy")
            return False

        # Build args
        args = [scrcpy]

        # Performance profile
        profile_map = {
            'high':   (120, '16M'),
            'normal': (60,  '8M'),
            'eco':    (30,  '4M'),
        }
        fps, bitrate = profile_map.get(self.performance_profile, (60, '8M'))
        args += ['--max-fps', str(fps), '--video-bit-rate', bitrate]
        logger.info(f"  Profile: {self.performance_profile} "
                    f"({fps} FPS, {bitrate} bitrate)")

        # Audio
        if not self.forward_audio:
            args += ['--no-audio']
            logger.info("  Audio: disabled (phone speaker)")
        else:
            logger.info("  Audio: enabled (Mac speakers)")

        # Robust flags (from mac-connect)
        args += [
            '--stay-awake',
            '--window-title=Infinix GT 30 Pro',
            '--shortcut-mod=lalt,lsuper',
            '--forward-all-clicks',
            '--power-off-on-close',
            '--prefer-text',
            '--show-touches',
        ]

        logger.info(f"\n  Menjalankan: {' '.join(args)}")
        logger.info("  Tutup jendela scrcpy untuk berhenti\n")

        # Serial device — jalankan dengan -s
        serial = f'{self.phone_ip}:5555' if self.phone_ip else None
        if serial:
            args = [scrcpy, '-s', serial] + args[1:]

        try:
            result = subprocess.run(args)
            if result.returncode == 0:
                logger.info("  ✓ Mirror selesai")
                return True
            else:
                logger.warning(f"  ! scrcpy exit code: {result.returncode}")
                return False
        except KeyboardInterrupt:
            logger.info("  Mirror dihentikan")
            return True
        except Exception as e:
            logger.error(f"  ✗ Gagal jalankan scrcpy: {e}")
            return False

    # ── Profile & Audio Controls ────────────────────────────────────────────────

    def cycle_profile(self):
        """Cycle profile: high → normal → eco → high."""
        profiles = ['high', 'normal', 'eco']
        idx = profiles.index(self.performance_profile)
        self.performance_profile = profiles[(idx + 1) % len(profiles)]
        self._save_config()
        logger.info(f"  Profile: {self.performance_profile}")

    def toggle_audio(self):
        """Toggle audio forwarding."""
        self.forward_audio = not self.forward_audio
        self._save_config()
        status = "enabled" if self.forward_audio else "disabled"
        logger.info(f"  Audio: {status}")

    # ── Helpers ─────────────────────────────────────────────────────────────────

    def _check_device(self) -> bool:
        """Cek apakah ada ADB device terhubung."""
        rc, out, _ = self._run_adb(['devices'], timeout=5)
        if rc == 0:
            for line in out.splitlines():
                if '5555' in line and 'device' in line:
                    return True
                if line.strip().endswith('\tdevice'):
                    return True
        return False

    def get_status(self) -> dict:
        """Dapatkan status bridge saat ini."""
        connected = self._check_device()
        device_info = {}
        if connected:
            serial = f'{self.phone_ip}:5555' if self.phone_ip else None
            if serial:
                rc, model, _ = self._run_adb(
                    ['-s', serial, 'shell', 'getprop ro.product.model'], timeout=5
                )
                if rc == 0 and model:
                    device_info['model'] = model.strip()
        return {
            'connected': connected,
            'phone_ip': self.phone_ip,
            'phone_model': self.phone_model or device_info.get('model'),
            'profile': self.performance_profile,
            'audio': self.forward_audio,
        }

    def disconnect(self):
        """Putuskan koneksi ADB."""
        self._run_adb(['disconnect'], timeout=5)
        self.phone_ip = None
        logger.info("  Disconnected")


# ── CLI ─────────────────────────────────────────────────────────────────────────

def main():
    """CLI entry point untuk mac-connect bridge."""
    import argparse

    logging.basicConfig(
        level=logging.INFO,
        format='%(asctime)s.%(msecs)03d %(message)s',
        datefmt='%H:%M:%S',
    )

    parser = argparse.ArgumentParser(
        description='NIU CAST — Mac Connect Bridge (ADB + scrcpy)',
    )
    parser.add_argument('action', nargs='?', default='status',
                       choices=['setup', 'connect', 'mirror', 'status',
                                'disconnect', 'profile', 'audio'],
                       help='Action')

    args = parser.parse_args()
    bridge = MacConnectBridge()

    if args.action == 'setup':
        success = bridge.setup_wireless()
        return 0 if success else 1

    elif args.action == 'connect':
        success = bridge.connect_wireless()
        return 0 if success else 1

    elif args.action == 'mirror':
        success = bridge.launch_mirror()
        return 0 if success else 1

    elif args.action == 'status':
        status = bridge.get_status()
        print(f"\n  ╔═══════════════════════════════╗")
        print(f"  ║   Mac Connect Bridge Status   ║")
        print(f"  ╚═══════════════════════════════╝")
        print(f"  Connected:      {'✓' if status['connected'] else '✗'}")
        print(f"  IP:             {status['phone_ip'] or '-'}")
        print(f"  Device:         {status['phone_model'] or '-'}")
        print(f"  Profile:        {status['profile']}")
        print(f"  Audio:          {'✓' if status['audio'] else '✗'}")
        print()
        return 0

    elif args.action == 'disconnect':
        bridge.disconnect()
        return 0

    elif args.action == 'profile':
        bridge.cycle_profile()
        print(f"  Profile: {bridge.performance_profile}")
        return 0

    elif args.action == 'audio':
        bridge.toggle_audio()
        status = "enabled" if bridge.forward_audio else "disabled"
        print(f"  Audio: {status}")
        return 0

    return 0


if __name__ == '__main__':
    import sys
    sys.exit(main())
