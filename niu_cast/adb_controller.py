"""
NIU CAST — ADB Controller
Komunikasi ADB untuk koneksi Android device.
"""

import os
import time
import subprocess


class ADBController:
    """ADB communication controller"""

    def __init__(self):
        self.adb_path = self._find_adb()
        self.device_serial = None
        self.device_ip = None

    def _find_adb(self):
        paths = [
            '/usr/local/bin/adb',
            '/opt/android-sdk/platform-tools/adb',
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
            import re
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
