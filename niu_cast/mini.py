#!/usr/bin/env python3
"""
╔══════════════════════════════════════════════════════════════════════════════╗
║                      NIU CAST MINI                                        ║
║                 Pure Python - No GUI Dependencies                           ║
║                                                                            ║
║  Compatible dengan:                                                         ║
║  - Python 3.6+ tanpa PyQt5                                                  ║
║  - Lightweight version untuk CLI environments                               ║
╚══════════════════════════════════════════════════════════════════════════════╝
"""

import os
import sys
import time
import subprocess
import argparse
from datetime import datetime

# ═══════════════════════════════════════════════════════════════════════════════
#                              COLORS
# ═══════════════════════════════════════════════════════════════════════════════

class Colors:
    HEADER = '\033[95m'
    BLUE = '\033[94m'
    CYAN = '\033[96m'
    GREEN = '\033[92m'
    YELLOW = '\033[93m'
    RED = '\033[91m'
    ENDC = '\033[0m'
    BOLD = '\033[1m'
    UNDERLINE = '\033[4m'

def print_color(color, text, end='\n'):
    print(f"{color}{text}{Colors.ENDC}", end=end)

def print_header(text):
    print()
    print_color(Colors.CYAN, "═" * 60)
    print_color(Colors.CYAN, f"  {text}", end='')
    print()
    print_color(Colors.CYAN, "═" * 60)

def print_subheader(text):
    print_color(Colors.YELLOW, f"\n▶ {text}")

# ═══════════════════════════════════════════════════════════════════════════════
#                              ADB CLASS
# ═══════════════════════════════════════════════════════════════════════════════

class ADB:
    def __init__(self):
        self.adb_path = self._find_adb()
        self.device = None
        
    def _find_adb(self) -> str:
        paths = ['adb', '/usr/local/bin/adb', '/opt/android-sdk/platform-tools/adb']
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
            self.device = serial
            return True
        devices = self.devices()
        if devices:
            self.device = devices[0]
            return True
        return False
    
    def shell(self, cmd, timeout=30):
        if not self.device:
            return -1, "", "No device"
        return self._run(['-s', self.device, 'shell', cmd], timeout)
    
    def pull(self, remote, local):
        if not self.device:
            return False
        rc, _, _ = self._run(['-s', self.device, 'pull', remote, local], timeout=120)
        return rc == 0
    
    def push(self, local, remote):
        if not self.device:
            return False
        rc, _, _ = self._run(['-s', self.device, 'push', local, remote], timeout=120)
        return rc == 0
    
    def install(self, apk_path):
        if not self.device:
            return False
        rc, out, err = self._run(['-s', self.device, 'install', '-r', apk_path], timeout=300)
        return rc == 0

# ═══════════════════════════════════════════════════════════════════════════════
#                              FUNCTIONS
# ═══════════════════════════════════════════════════════════════════════════════

def check_adb(adb):
    print_subheader("Checking ADB...")
    rc, out, _ = adb._run(['version'])
    if rc == 0:
        print_color(Colors.GREEN, f"  ✓ ADB Found: {out.strip()}")
        return True
    else:
        print_color(Colors.RED, "  ✗ ADB not found!")
        return False

def check_device(adb):
    print_subheader("Checking Devices...")
    devices = adb.devices()
    if devices:
        print_color(Colors.GREEN, f"  ✓ Found {len(devices)} device(s): {', '.join(devices)}")
        return True
    else:
        print_color(Colors.RED, "  ✗ No devices found!")
        print("    Make sure:")
        print("    - USB debugging is enabled")
        print("    - Device is connected")
        print("    - USB debugging is authorized")
        return False

def get_device_info(adb):
    print_subheader("Device Information")
    info = {}
    
    rc, model, _ = adb.shell('getprop ro.product.model')
    info['model'] = model.strip() if rc == 0 else 'Unknown'
    
    rc, manufacturer, _ = adb.shell('getprop ro.product.manufacturer')
    info['manufacturer'] = manufacturer.strip() if rc == 0 else 'Unknown'
    
    rc, android, _ = adb.shell('getprop ro.build.version.release')
    info['android'] = android.strip() if rc == 0 else 'Unknown'
    
    rc, sdk, _ = adb.shell('getprop ro.build.version.sdk')
    info['sdk'] = sdk.strip() if rc == 0 else 'Unknown'
    
    rc, size, _ = adb.shell('wm size')
    info['size'] = size.strip() if rc == 0 else 'Unknown'
    
    print(f"  Manufacturer: {info['manufacturer']}")
    print(f"  Model:        {info['model']}")
    print(f"  Android:      {info['android']} (SDK {info['sdk']})")
    print(f"  Screen:       {info['size']}")

def take_screenshot(adb, save_dir=None):
    print_subheader("Taking Screenshot...")
    
    timestamp = datetime.now().strftime("%Y%m%d_%H%M%S")
    remote_path = '/sdcard/screenshot.png'
    save_dir = save_dir or os.path.expanduser('~/Pictures')
    local_path = os.path.join(save_dir, f'niu_screenshot_{timestamp}.png')
    
    os.makedirs(save_dir, exist_ok=True)
    
    # Capture
    adb.shell('screencap -p /sdcard/screenshot.png', timeout=5)
    
    # Pull
    if adb.pull(remote_path, local_path):
        print_color(Colors.GREEN, f"  ✓ Screenshot saved: {local_path}")
        
        # Try to open
        if sys.platform == 'darwin':
            subprocess.run(['open', local_path])
        elif sys.platform == 'linux':
            subprocess.run(['xdg-open', local_path])
    else:
        print_color(Colors.RED, "  ✗ Failed to capture screenshot")

def screen_record(adb, duration=30, save_dir=None):
    print_subheader(f"Recording Screen for {duration} seconds...")
    
    timestamp = datetime.now().strftime("%Y%m%d_%H%M%S")
    remote_path = '/sdcard/recording.mp4'
    save_dir = save_dir or os.path.expanduser('~/Videos')
    local_path = os.path.join(save_dir, f'niu_recording_{timestamp}.mp4')
    
    os.makedirs(save_dir, exist_ok=True)
    
    # Start recording
    print(f"  Recording to {remote_path}...")
    adb.shell(f'screenrecord --time-limit {duration} {remote_path}', timeout=duration + 10)
    
    # Pull
    print("  Pulling recording...")
    if adb.pull(remote_path, local_path):
        print_color(Colors.GREEN, f"  ✓ Recording saved: {local_path}")
        
        # Open
        if sys.platform == 'darwin':
            subprocess.run(['open', local_path])
        elif sys.platform == 'linux':
            subprocess.run(['xdg-open', local_path])
    else:
        print_color(Colors.RED, "  ✗ Failed to save recording")

def send_keyevent(adb, keyevent):
    print_subheader(f"Sending Keyevent: {keyevent}")
    rc, _, _ = adb.shell(f'input keyevent {keyevent}')
    if rc == 0:
        print_color(Colors.GREEN, f"  ✓ Sent {keyevent}")
    else:
        print_color(Colors.RED, f"  ✗ Failed to send {keyevent}")

def install_apk(adb):
    print_subheader("Install APK")
    print("  Enter path to APK file:", end=' ')
    apk_path = input().strip()
    
    if not os.path.exists(apk_path):
        print_color(Colors.RED, f"  ✗ File not found: {apk_path}")
        return
    
    print(f"  Installing {apk_path}...")
    if adb.install(apk_path):
        print_color(Colors.GREEN, "  ✓ Installation complete!")
    else:
        print_color(Colors.RED, "  ✗ Installation failed")

def interactive_control(adb):
    print_subheader("Interactive Control Mode")
    print("Commands:")
    print("  home, back, menu, power")
    print("  vol-up, vol-down, mute")
    print("  tap X Y, swipe X1 Y1 X2 Y2")
    print("  type TEXT, screenshot, record")
    print("  exit")
    print()
    
    keyevents = {
        'home': 'KEYCODE_HOME',
        'back': 'KEYCODE_BACK',
        'menu': 'KEYCODE_MENU',
        'power': 'KEYCODE_POWER',
        'vol-up': 'KEYCODE_VOLUME_UP',
        'vol-down': 'KEYCODE_VOLUME_DOWN',
        'mute': 'KEYCODE_MUTE',
        'search': 'KEYCODE_SEARCH',
        'camera': 'KEYCODE_CAMERA',
    }
    
    while True:
        try:
            cmd = input("niu> ").strip().split()
            if not cmd:
                continue
            
            action = cmd[0].lower()
            
            if action == 'exit':
                break
            elif action in keyevents:
                adb.shell(f'input keyevent {keyevents[action]}')
            elif action == 'screenshot':
                take_screenshot(adb)
            elif action == 'record':
                screen_record(adb)
            elif action == 'tap' and len(cmd) == 3:
                adb.shell(f'input tap {cmd[1]} {cmd[2]}')
            elif action == 'swipe' and len(cmd) == 5:
                adb.shell(f'input swipe {cmd[1]} {cmd[2]} {cmd[3]} {cmd[4]}')
            elif action == 'type' and len(cmd) > 1:
                text = ' '.join(cmd[1:]).replace(' ', '%s')
                adb.shell(f'input text {text}')
            else:
                print(f"Unknown command: {action}")
                
        except KeyboardInterrupt:
            print("\nExiting...")
            break
        except EOFError:
            break

def wireless_connect(adb):
    """Wireless ADB — auto-detect IP dan enable TCP mode"""
    print_subheader("Wireless Connection Setup")
    print("  Metode: deteksi IP dari interface aktif + adb tcpip")
    print()
    
    import re
    
    # Step 1: Cek apakah sudah di TCP mode
    rc, port_out, _ = adb.shell('getprop service.adb.tcp.port')
    already_tcp = (rc == 0 and port_out.strip() == '5555')
    
    if already_tcp:
        print_color(Colors.GREEN, "  ✓ ADB sudah dalam TCP mode (port 5555)")
    else:
        # Step 2: Enable TCP mode via USB (tanpa root)
        print("  Mengaktifkan ADB over TCP...")
        rc_tcp, out_tcp, err_tcp = adb._run(['tcpip', '5555'])
        if rc_tcp != 0:
            print_color(Colors.RED, f"  ✗ Gagal enable TCP: {err_tcp}")
            print("  Coba metode alternatif (setprop)...")
            adb.shell('setprop service.adb.tcp.port 5555')
            adb.shell('stop adbd')
            adb.shell('start adbd')
            time.sleep(2)
        else:
            print_color(Colors.GREEN, "  ✓ ADB TCP mode enabled (via adb tcpip 5555)")
            time.sleep(2)
    
    # Step 3: Auto-detect IP dari berbagai interface
    print()
    print("  Mendeteksi IP device...")
    
    # Coba beberapa interface umum
    interfaces = ['wlan0', 'wlan1', 'eth0', 'ccmni0', 'ccmni1', 'ccmni2']
    ip_found = None
    
    for iface in interfaces:
        rc, output, _ = adb.shell(f'ip addr show {iface}')
        if rc == 0:
            ip_match = re.search(r'inet (\d+\.\d+\.\d+\.\d+)', output)
            if ip_match:
                ip = ip_match.group(1)
                if ip != '127.0.0.1' and not ip.startswith('172.'):
                    ip_found = ip
                    print_color(Colors.GREEN, f"  ✓ Ditemukan IP di {iface}: {ip}")
                    break
                elif ip != '127.0.0.1':
                    ip_found = ip
                    print(f"    IP di {iface}: {ip} (Hotspot/NAT — mungkin tidak reachable)")
    
    # Fallback: ambil IP pertama dari interface mana pun
    if not ip_found:
        rc, output, _ = adb.shell('ip addr show')
        if rc == 0:
            ips = re.findall(r'inet (\d+\.\d+\.\d+\.\d+)', output)
            for ip in ips:
                if ip != '127.0.0.1' and not ip.startswith('172.'):
                    ip_found = ip
                    print_color(Colors.GREEN, f"  ✓ Ditemukan IP: {ip}")
                    break
    
    # Step 4: Konek
    if ip_found:
        print()
        print(f"  Menghubungkan ke {ip_found}:5555...")
        
        # Coba langsung
        rc, out, err = adb._run(['connect', f'{ip_found}:5555'])
        
        if rc == 0 and 'connected' in out.lower():
            print_color(Colors.GREEN, f"  ✓ Wireless connected! → {ip_found}:5555")
            adb.device = f'{ip_found}:5555'
        else:
            # Coba dengan usb fallback
            print(f"  ⚠ Gagal: {err.strip()}")
            print("  Mencoba connect ulang...")
            time.sleep(1)
            rc2, out2, err2 = adb._run(['connect', f'{ip_found}:5555'])
            if rc2 == 0 and 'connected' in out2.lower():
                print_color(Colors.GREEN, f"  ✓ Wireless connected! → {ip_found}:5555")
                adb.device = f'{ip_found}:5555'
            else:
                print_color(Colors.RED, f"  ✗ Wireless failed: {err2.strip()}")
                print()
                print("  💡 Tips:")
                print("  1. Pastikan HP & Mac di jaringan yang SAMA")
                print("  2. Coba manual: adb connect <IP>:5555")
                print("  3. Atau input IP manual di menu ini:")
                manual_ip = input("  Masukkan IP device: ").strip()
                if manual_ip:
                    rc3, out3, err3 = adb._run(['connect', f'{manual_ip}:5555'])
                    if rc3 == 0 and 'connected' in out3.lower():
                        print_color(Colors.GREEN, f"  ✓ Connected via manual IP: {manual_ip}:5555")
                        adb.device = f'{manual_ip}:5555'
                    else:
                        print_color(Colors.RED, f"  ✗ Gagal: {err3.strip()}")
    else:
        print_color(Colors.RED, "  ✗ Tidak ada IP terdeteksi")
        print()
        print("  💡 Coba manual:")
        print("  1. Cek IP HP: Settings → About → Status → IP Address")
        print("  2. Jalankan: adb connect <IP>:5555")
        print()
        manual_ip = input("  Atau masukkan IP device: ").strip()
        if manual_ip:
            rc, out, err = adb._run(['connect', f'{manual_ip}:5555'])
            if rc == 0 and 'connected' in out.lower():
                print_color(Colors.GREEN, f"  ✓ Connected via manual IP: {manual_ip}:5555")
                adb.device = f'{manual_ip}:5555'
            else:
                print_color(Colors.RED, f"  ✗ Gagal: {err.strip()}")
    
    # Step 5: Verify
    if adb.device and ':' in str(adb.device):
        print()
        print("  Memverifikasi koneksi...")
        rc_v, out_v, _ = adb._run(['devices'])
        if str(adb.device) in out_v:
            print_color(Colors.GREEN, f"  ✅ Wireless ADB aktif! Device: {adb.device}")
            print("  📌 USB bisa dicabut sekarang")
        else:
            print_color(Colors.RED, "  ✗ Device tidak muncul di daftar ADB")

# ═══════════════════════════════════════════════════════════════════════════════
#                              MAIN
# ═══════════════════════════════════════════════════════════════════════════════

def main():
    parser = argparse.ArgumentParser(
        description='NiuCast Mini - Lightweight Screen Mirroring Tool',
        formatter_class=argparse.RawDescriptionHelpFormatter,
        epilog="""
Examples:
  %(prog)s --screenshot           Take a screenshot
  %(prog)s --record 60            Record for 60 seconds
  %(prog)s --install app.apk      Install APK
  %(prog)s --control              Interactive control mode
  %(prog)s --info                 Show device info
        """
    )
    
    parser.add_argument('--screenshot', action='store_true', help='Take screenshot')
    parser.add_argument('--record', type=int, nargs='?', const=30, help='Record screen (duration in seconds)')
    parser.add_argument('--install', metavar='APK', help='Install APK file')
    parser.add_argument('--control', action='store_true', help='Interactive control mode')
    parser.add_argument('--info', action='store_true', help='Show device information')
    parser.add_argument('--wireless', action='store_true', help='Setup wireless connection')
    parser.add_argument('--keyevent', metavar='KEY', help='Send keyevent (e.g., KEYCODE_HOME)')
    parser.add_argument('--reboot', metavar='MODE', nargs='?', const='normal', help='Reboot device (normal/recovery/bootloader)')
    parser.add_argument('--device', metavar='SERIAL', help='Specify device serial')
    
    args = parser.parse_args()
    
    print_header("NIU CAST MINI")
    print(f"Python: {sys.version.split()[0]}")
    print(f"Platform: {sys.platform}")
    print()
    
    adb = ADB()
    
    # Check prerequisites
    if not check_adb(adb):
        return 1
    
    if not check_device(adb):
        return 1
    
    # Connect to device
    if not adb.connect(args.device):
        print_color(Colors.RED, "✗ Failed to connect to device")
        return 1
    
    print_color(Colors.GREEN, f"✓ Connected to {adb.device}")
    print()
    
    # Execute commands
    if args.screenshot:
        take_screenshot(adb)
    
    if args.record:
        screen_record(adb, args.record)
    
    if args.install:
        if adb.install(args.install):
            print_color(Colors.GREEN, "✓ Installation complete!")
        else:
            print_color(Colors.RED, "✗ Installation failed")
    
    if args.info:
        get_device_info(adb)
    
    if args.control:
        interactive_control(adb)
    
    if args.wireless:
        wireless_connect(adb)
    
    if args.keyevent:
        send_keyevent(adb, args.keyevent)
    
    if args.reboot:
        mode = args.reboot
        if mode == 'normal':
            adb.shell('reboot')
        elif mode == 'recovery':
            adb._run(['reboot', 'recovery'])
        elif mode == 'bootloader':
            adb._run(['reboot', 'bootloader'])
        print_color(Colors.YELLOW, f"  Rebooting to {mode}...")
    
    # If no args, show menu
    if len(sys.argv) == 1:
        while True:
            print()
            print("Select action:")
            print("  1) Device Info")
            print("  2) Screenshot")
            print("  3) Screen Record")
            print("  4) Interactive Control")
            print("  5) Install APK")
            print("  6) Wireless Setup")
            print("  7) Exit")
            print()
            choice = input("Choice [1-7]: ").strip()
            
            if choice == '1':
                get_device_info(adb)
            elif choice == '2':
                take_screenshot(adb)
            elif choice == '3':
                screen_record(adb)
            elif choice == '4':
                interactive_control(adb)
            elif choice == '5':
                install_apk(adb)
            elif choice == '6':
                wireless_connect(adb)
            elif choice == '7':
                print("Goodbye!")
                break
    
    return 0

if __name__ == '__main__':
    sys.exit(main())