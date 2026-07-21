"""
NIU CAST — ADB Controller
Komunikasi ADB untuk koneksi Android device.
"""

import os
import re
import socket
import subprocess
import time
from typing import Optional


class ADBController:
    """ADB communication controller"""

    def __init__(self, adb_path: str = None):
        self.adb_path = adb_path or self._find_adb()
        self.device_serial = None
        self.device_ip = None

    @staticmethod
    def _find_adb():
        paths = [
            '/usr/local/bin/adb',
            '/opt/homebrew/bin/adb',
            '/opt/android-sdk/platform-tools/adb',
            os.path.expanduser('~/Library/Android/sdk/platform-tools/adb'),
            'adb'
        ]
        for path in paths:
            if os.path.exists(path):
                return path
        return 'adb'

    def _run(self, args, timeout=30):
        cmd = [self.adb_path] + args
        try:
            result = subprocess.run(cmd, capture_output=True, text=True, timeout=timeout)
            return result.returncode, result.stdout, result.stderr
        except subprocess.TimeoutExpired:
            return -1, "", "Timeout"
        except Exception as e:
            return -1, "", str(e)

    def devices(self):
        rc, out, _ = self._run(['devices', '-l'])
        devices = []
        if rc == 0:
            for line in out.splitlines()[1:]:
                if line.strip() and 'device' in line and 'unauthorized' not in line:
                    devices.append(line.split()[0])
        return devices

    def connect(self, serial=None):
        if serial:
            rc, _, _ = self._run(['-s', serial, 'get-state'])
            if rc == 0:
                self.device_serial = serial
                return True
        devices = self.devices()
        if devices:
            self.device_serial = devices[0]
            return True
        return False

    def disconnect(self):
        """Putuskan koneksi ADB."""
        self._run(['disconnect'], timeout=5)
        self.device_serial = None

    def shell(self, cmd, timeout=30):
        if not self.device_serial:
            return -1, "", "No device"
        return self._run(['-s', self.device_serial, 'shell', cmd], timeout)

    def pull(self, remote, local):
        if not self.device_serial:
            return False
        rc, _, _ = self._run(['-s', self.device_serial, 'pull', remote, local], timeout=120)
        return rc == 0

    def push(self, local, remote):
        if not self.device_serial:
            return False
        rc, _, _ = self._run(['-s', self.device_serial, 'push', local, remote], timeout=120)
        return rc == 0

    def get_device_info(self):
        info = {}
        rc, model, _ = self.shell('getprop ro.product.model')
        info['model'] = model.strip() if rc == 0 else 'Unknown'
        rc, mf, _ = self.shell('getprop ro.product.manufacturer')
        info['manufacturer'] = mf.strip() if rc == 0 else 'Unknown'
        rc, android, _ = self.shell('getprop ro.build.version.release')
        info['android'] = android.strip() if rc == 0 else 'Unknown'
        rc, sdk, _ = self.shell('getprop ro.build.version.sdk')
        info['sdk'] = sdk.strip() if rc == 0 else 'Unknown'
        rc, size, _ = self.shell('wm size')
        if rc == 0:
            try:
                p = size.strip().split(':')[-1].strip().split('x')
                info['width'], info['height'] = int(p[0]), int(p[1])
            except:
                info['width'], info['height'] = 1080, 2400
        else:
            info['width'], info['height'] = 1080, 2400
        rc, ip_out, _ = self.shell('ip route')
        if rc == 0:
            m = re.search(r'wlan0.*?src (\d+\.\d+\.\d+\.\d+)', ip_out)
            if m:
                self.device_ip = m.group(1)
                info['ip'] = self.device_ip
        return info

    def send_keyevent(self, keycode):
        self.shell(f'input keyevent {keycode}')

    def send_tap(self, x, y):
        self.shell(f'input tap {x} {y}')

    def send_swipe(self, x1, y1, x2, y2, duration=300):
        self.shell(f'input swipe {x1} {y1} {x2} {y2} {duration}')

    def send_text(self, text):
        text = text.replace(' ', '%s')
        self.shell(f'input text {text}')

    def enable_wireless(self):
        self.get_device_info()
        self.shell('setprop service.adb.tcpip 5555', timeout=5)
        time.sleep(2)
        if self.device_ip:
            rc, _, _ = self._run(['connect', f'{self.device_ip}:5555'])
            return rc == 0
        return False

    def screencap(self, local_path):
        """Capture screenshot and save locally"""
        rc, _, _ = self.shell('screencap -p /sdcard/.niu_screen.png', timeout=5)
        if rc != 0:
            return False
        return self.pull('/sdcard/.niu_screen.png', local_path)

    def list_apps(self, system=False):
        """List installed packages"""
        flag = '-s' if system else '-3'
        rc, out, _ = self.shell(f'pm list packages {flag} 2>/dev/null', timeout=10)
        if rc != 0:
            return []
        pkgs = []
        for line in out.strip().split('\n'):
            if line.startswith('package:'):
                pkgs.append(line[8:].strip())
        return sorted(pkgs)

    def uninstall_app(self, package):
        rc, _, _ = self.shell(f'pm uninstall {package}', timeout=15)
        return rc == 0

    # ── Enhanced Wireless Methods (dari mac-connect) ──────────────────────────────

    def connect_wireless(self, ip: str) -> bool:
        """
        Connect ke device via ADB wireless TCP/IP.

        Args:
            ip: IP address HP (format: x.x.x.x)

        Returns:
            True jika berhasil.
        """
        # Disconnect dulu kalo ada
        self._run(['disconnect'], timeout=5)

        rc, out, _ = self._run(['connect', f'{ip}:5555'], timeout=10)
        if 'connected to' in out or 'already connected' in out:
            self.device_serial = f'{ip}:5555'
            self.device_ip = ip
            return True
        return False

    def disconnect_wireless(self):
        """Putuskan koneksi ADB wireless."""
        self._run(['disconnect'], timeout=5)
        self.device_serial = None
        self.device_ip = None

    def setup_tcpip(self) -> bool:
        """
        Setup ADB TCP/IP mode via USB.
        HP harus terhubung via USB dengan USB Debugging ON.

        Returns:
            True jika berhasil.
        """
        rc, _, err = self._run(['-d', 'tcpip', '5555'], timeout=10)
        if rc == 0:
            time.sleep(2)
            return True
        return False

    def extract_ip_usb(self) -> Optional[str]:
        """
        Ekstrak IP address dari HP via USB.
        Mencoba 3 metode: ip route, wlan0, DHCP property.

        Returns:
            IP address string atau None.
        """
        device_ip = None

        # Method 1: ip route
        rc, out, _ = self._run(['-d', 'shell', 'ip route'], timeout=5)
        if rc == 0:
            m = re.search(r'src\s+(\d+\.\d+\.\d+\.\d+)', out)
            if m:
                device_ip = m.group(1)

        # Method 2: wlan0
        if not device_ip:
            rc, out, _ = self._run(['-d', 'shell', 'ip addr show wlan0'], timeout=5)
            if rc == 0:
                m = re.search(r'inet\s+(\d+\.\d+\.\d+\.\d+)', out)
                if m:
                    device_ip = m.group(1)

        # Method 3: DHCP
        if not device_ip:
            rc, out, _ = self._run(['-d', 'shell', 'getprop dhcp.wlan0.ipaddress'], timeout=5)
            if rc == 0 and out.strip():
                device_ip = out.strip()

        if device_ip:
            self.device_ip = device_ip
        return device_ip

    def arp_discover(self) -> Optional[str]:
        """
        Scan ARP table untuk HP dengan ADB port 5555 terbuka.
        Sama kaya mac-connect: test TCP connect ke port 5555.

        Returns:
            IP address atau None.
        """
        try:
            result = subprocess.run(
                ['arp', '-an'],
                capture_output=True, text=True, timeout=5
            )
            if result.returncode != 0:
                return None

            ips = re.findall(r'(\d+\.\d+\.\d+\.\d+)', result.stdout)

            for ip in ips:
                if ip.startswith('127.'):
                    continue
                try:
                    sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
                    sock.settimeout(0.5)
                    r = sock.connect_ex((ip, 5555))
                    sock.close()
                    if r == 0:
                        return ip
                except Exception:
                    continue
            return None
        except Exception:
            return None
