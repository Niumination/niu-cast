#!/usr/bin/env python3
"""
NIU CAST — CLI
Command Line Interface untuk Android device management via ADB
"""

import os
import sys
import time
import subprocess
import argparse
from datetime import datetime

# ═══════════════════════════════════════════════════════════════════════════════
#                              COLORS & STYLING
# ═══════════════════════════════════════════════════════════════════════════════

class Colors:
    CYAN = '\033[0;96m'
    GREEN = '\033[0;92m'
    RED = '\033[0;91m'
    YELLOW = '\033[0;93m'
    GOLD = '\033[0;93m'
    WHITE = '\033[0;97m'
    BOLD = '\033[1m'
    DIM = '\033[2m'
    RESET = '\033[0m'



def print_header(text):
    """Print section header"""
    print(f"\n{Colors.CYAN}{Colors.BOLD}═══ {text} ═══{Colors.RESET}")

def print_success(text):
    print(f"{Colors.GREEN}✓ {text}{Colors.RESET}")

def print_error(text):
    print(f"{Colors.RED}✗ {text}{Colors.RESET}")

def print_warning(text):
    print(f"{Colors.YELLOW}⚠ {text}{Colors.RESET}")

def print_info(text):
    print(f"{Colors.CYAN}ℹ {text}{Colors.RESET}")


# ═══════════════════════════════════════════════════════════════════════════════
#                              ADB CLASS
# ═══════════════════════════════════════════════════════════════════════════════

class ADB:
    def __init__(self):
        self.adb_path = self._find_adb()
        self.device = None
        self.device_ip = None
        
    def _find_adb(self):
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
    
    def get_device_info(self):
        info = {}
        
        rc, model, _ = self.shell('getprop ro.product.model')
        info['model'] = model.strip() if rc == 0 else 'Unknown'
        
        rc, manufacturer, _ = self.shell('getprop ro.product.manufacturer')
        info['manufacturer'] = manufacturer.strip() if rc == 0 else 'Unknown'
        
        rc, android, _ = self.shell('getprop ro.build.version.release')
        info['android'] = android.strip() if rc == 0 else 'Unknown'
        
        rc, sdk, _ = self.shell('getprop ro.build.version.sdk')
        info['sdk'] = sdk.strip() if rc == 0 else 'Unknown'
        
        rc, size, _ = self.shell('wm size')
        if rc == 0:
            try:
                parts = size.strip().split(':')[-1].strip().split('x')
                info['width'] = int(parts[0])
                info['height'] = int(parts[1])
            except:
                info['width'], info['height'] = 1080, 2400
        else:
            info['width'], info['height'] = 1080, 2400
        
        # Get WiFi IP
        rc, ip_out, _ = self.shell('ip route')
        if rc == 0:
            import re
            ip_match = re.search(r'wlan0.*?src (\d+\.\d+\.\d+\.\d+)', ip_out)
            if ip_match:
                self.device_ip = ip_match.group(1)
                info['ip'] = self.device_ip
        
        return info


# ═══════════════════════════════════════════════════════════════════════════════
#                              FUNCTIONS
# ═══════════════════════════════════════════════════════════════════════════════

def check_adb(adb):
    """Check if ADB is available"""
    rc, out, _ = adb._run(['version'])
    if rc == 0:
        print_success(f"ADB Found: {out.strip()}")
        return True
    print_error("ADB not found! Install Android SDK Platform Tools.")
    return False

def check_device(adb):
    """Check for connected devices"""
    devices = adb.devices()
    if devices:
        print_success(f"Found {len(devices)} device(s): {', '.join(devices)}")
        return True
    print_error("No devices found!")
    print_info("Enable USB debugging and authorize this computer on your device.")
    return False

def show_device_info(adb):
    """Show device information"""
    print_header("DEVICE INFORMATION")
    
    info = adb.get_device_info()
    
    print(f"\n  {Colors.CYAN}Manufacturer:{Colors.RESET} {info['manufacturer']}")
    print(f"  {Colors.CYAN}Model:{Colors.RESET}        {info['model']}")
    print(f"  {Colors.CYAN}Android:{Colors.RESET}      {info['android']} (SDK {info['sdk']})")
    print(f"  {Colors.CYAN}Resolution:{Colors.RESET}   {info['width']} x {info['height']}")
    
    if 'ip' in info:
        print(f"  {Colors.CYAN}WiFi IP:{Colors.RESET}      {info['ip']}")

def screenshot(adb, save_dir=None):
    """Take screenshot"""
    print_header("SCREENSHOT")
    
    timestamp = datetime.now().strftime("%Y%m%d_%H%M%S")
    save_dir = save_dir or os.path.expanduser('~/Pictures')
    local_path = os.path.join(save_dir, f'niu_screenshot_{timestamp}.png')
    
    os.makedirs(save_dir, exist_ok=True)
    
    print_info(f"Capturing screenshot...")
    
    adb.shell('screencap -p /sdcard/.niu_screenshot.png', timeout=5)
    
    if adb.pull('/sdcard/.niu_screenshot.png', local_path):
        print_success(f"Saved: {local_path}")
        
        # Open screenshot
        try:
            if sys.platform == 'darwin':
                subprocess.run(['open', local_path])
            elif sys.platform == 'linux':
                subprocess.run(['xdg-open', local_path])
        except:
            pass
    else:
        print_error("Failed to capture screenshot")

def screen_record(adb, duration=30):
    """Record screen"""
    print_header("SCREEN RECORDING")
    
    timestamp = datetime.now().strftime("%Y%m%d_%H%M%S")
    save_dir = os.path.expanduser('~/Videos')
    local_path = os.path.join(save_dir, f'niu_recording_{timestamp}.mp4')
    
    os.makedirs(save_dir, exist_ok=True)
    
    print_info(f"Recording for {duration} seconds...")
    print_info(f"Output: {local_path}")
    
    adb.shell(f'screenrecord --time-limit {duration} /sdcard/.niu_recording.mp4', timeout=duration + 10)
    
    print_info("Pulling recording...")
    
    if adb.pull('/sdcard/.niu_recording.mp4', local_path):
        print_success(f"Saved: {local_path}")
        
        try:
            if sys.platform == 'darwin':
                subprocess.run(['open', local_path])
            elif sys.platform == 'linux':
                subprocess.run(['xdg-open', local_path])
        except:
            pass
    else:
        print_error("Failed to save recording")

def interactive_control(adb):
    """Interactive control mode"""
    print_header("INTERACTIVE CONTROL MODE")
    
    print(f"""
  {Colors.GOLD}Key Commands:{Colors.RESET}
    home, back, menu, power
    vol-up, vol-down, mute
    search, camera, screenshot
    
  {Colors.GOLD}Touch Commands:{Colors.RESET}
    tap X Y         - Tap at coordinates
    swipe X1 Y1 X2 Y2 [duration]
    type TEXT       - Type text
    
  {Colors.GOLD}Utilities:{Colors.RESET}
    record [sec]    - Record screen
    screenshot      - Take screenshot
    info            - Show device info
    wireless        - Enable WiFi ADB
    exit            - Exit control mode
""")
    
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
            cmd = input(f"{Colors.CYAN}niu>{Colors.RESET} ").strip().split()
            if not cmd:
                continue
            
            action = cmd[0].lower()
            
            if action == 'exit':
                print_info("Exiting control mode...")
                break
            elif action in keyevents:
                adb.shell(f'input keyevent {keyevents[action]}')
                print_success(f"Sent: {action}")
            elif action == 'tap' and len(cmd) >= 3:
                x, y = cmd[1], cmd[2]
                adb.shell(f'input tap {x} {y}')
                print_success(f"Tapped: {x}, {y}")
            elif action == 'swipe' and len(cmd) >= 5:
                x1, y1, x2, y2 = cmd[1], cmd[2], cmd[3], cmd[4]
                duration = cmd[5] if len(cmd) > 5 else 300
                adb.shell(f'input swipe {x1} {y1} {x2} {y2} {duration}')
                print_success(f"Swiped: {x1},{y1} → {x2},{y2}")
            elif action == 'type' and len(cmd) > 1:
                text = ' '.join(cmd[1:]).replace(' ', '%s')
                adb.shell(f'input text {text}')
                print_success(f"Typed: {' '.join(cmd[1:])}")
            elif action == 'screenshot':
                screenshot(adb)
            elif action == 'record':
                duration = int(cmd[1]) if len(cmd) > 1 else 30
                screen_record(adb, duration)
            elif action == 'info':
                show_device_info(adb)
            elif action == 'wireless':
                enable_wireless(adb)
            else:
                print_warning(f"Unknown command: {action}")
                
        except KeyboardInterrupt:
            print(f"\n{Colors.YELLOW}Exiting...{Colors.RESET}")
            break
        except EOFError:
            break

def install_apk(adb):
    """Install APK"""
    print_header("INSTALL APK")
    
    print("Enter APK path:", end=' ')
    apk_path = input().strip()
    
    if not os.path.exists(apk_path):
        print_error(f"File not found: {apk_path}")
        return
    
    print_info(f"Installing {apk_path}...")
    
    if adb.install(apk_path):
        print_success("Installation complete!")
    else:
        print_error("Installation failed")

def enable_wireless(adb):
    """Enable ADB over WiFi"""
    print_header("WIRELESS CONNECTION")
    
    info = adb.get_device_info()
    
    if 'ip' not in info:
        print_error("No WiFi IP found. Connect device to WiFi first.")
        return
    
    print_info(f"Device WiFi IP: {info['ip']}")
    print_info("Enabling ADB over TCP...")
    
    adb.shell('setprop service.adb.tcpip 5555', timeout=5)
    time.sleep(2)
    
    rc, _, _ = adb._run(['connect', f"{info['ip']}:5555"])
    
    if rc == 0:
        print_success(f"Wireless enabled!")
        print_info(f"Connect: adb connect {info['ip']}:5555")
    else:
        print_error("Failed to enable wireless")

def live_preview(adb):
    """Live screen preview (terminal version)"""
    print_header("LIVE PREVIEW")
    print_info("Press Ctrl+C to exit")
    print()
    
    frame_count = 0
    start_time = time.time()
    
    try:
        while True:
            timestamp = datetime.now().strftime("%H:%M:%S")
            
            # Capture frame
            adb.shell('screencap -p /sdcard/.niu_preview.png', timeout=2)
            
            if adb.pull('/sdcard/.niu_preview.png', '/tmp/niu_preview.png'):
                # Get file size as approximate activity indicator
                try:
                    size = os.path.getsize('/tmp/niu_preview.png')
                    frame_count += 1
                    
                    elapsed = time.time() - start_time
                    fps = frame_count / elapsed if elapsed > 0 else 0
                    
                    print(f"\r{timestamp} | Frame: {frame_count} | FPS: {fps:.1f} | Size: {size/1024:.1f}KB", end='')
                except:
                    pass
            
            time.sleep(0.033)  # ~30 FPS
            
    except KeyboardInterrupt:
        print(f"\n\n{Colors.GREEN}Preview ended.{Colors.RESET}")
        print_info(f"Total frames: {frame_count}")


# ═══════════════════════════════════════════════════════════════════════════════
#                              MAIN
# ═══════════════════════════════════════════════════════════════════════════════

def main():
    parser = argparse.ArgumentParser(
        description='NIU CAST CLI — Android device manager via ADB',
        formatter_class=argparse.RawDescriptionHelpFormatter,
        epilog=f"""
Examples:
  %(prog)s --info             Show device info
  %(prog)s --screenshot       Take screenshot
  %(prog)s --record 60        Record for 60 seconds
  %(prog)s --control          Interactive control
  %(prog)s --wireless         Enable WiFi ADB
        """
    )
    
    parser.add_argument('--info', action='store_true', help='Show device information')
    parser.add_argument('--screenshot', action='store_true', help='Take screenshot')
    parser.add_argument('--record', type=int, nargs='?', const=30, help='Record screen (seconds)')
    parser.add_argument('--control', action='store_true', help='Interactive control mode')
    parser.add_argument('--wireless', action='store_true', help='Enable ADB over WiFi')
    parser.add_argument('--preview', action='store_true', help='Live screen preview')
    parser.add_argument('--install', metavar='APK', help='Install APK file')
    parser.add_argument('--device', metavar='SERIAL', help='Specify device serial')
    
    args = parser.parse_args()
    
    adb = ADB()
    
    # Check prerequisites
    if not check_adb(adb):
        return 1
    
    if not check_device(adb):
        return 1
    
    # Connect to device
    if not adb.connect(args.device):
        print_error("Failed to connect to device")
        return 1
    
    print_success(f"Connected to {adb.device}")
    
    # Execute commands
    if args.info:
        show_device_info(adb)
    
    if args.screenshot:
        screenshot(adb)
    
    if args.record:
        screen_record(adb, args.record)
    
    if args.control:
        interactive_control(adb)
    
    if args.wireless:
        enable_wireless(adb)
    
    if args.preview:
        live_preview(adb)
    
    if args.install:
        if adb.install(args.install):
            print_success("Installation complete!")
        else:
            print_error("Installation failed")
    
    # If no args, show menu
    if len(sys.argv) == 1:
        show_menu(adb)


def show_menu(adb):
    """Interactive menu"""
    while True:
        print_header("MAIN MENU")
        print(f"""
  {Colors.CYAN}1){Colors.RESET} Device Information
  {Colors.CYAN}2){Colors.RESET} Screenshot
  {Colors.CYAN}3){Colors.RESET} Screen Record
  {Colors.CYAN}4){Colors.RESET} Interactive Control
  {Colors.CYAN}5){Colors.RESET} Install APK
  {Colors.CYAN}6){Colors.RESET} Wireless Setup
  {Colors.CYAN}7){Colors.RESET} Live Preview
  {Colors.CYAN}0){Colors.RESET} Exit
        """)
        
        choice = input(f"{Colors.CYAN}niu-menu>{Colors.RESET} ").strip()
        
        if choice == '1':
            show_device_info(adb)
        elif choice == '2':
            screenshot(adb)
        elif choice == '3':
            screen_record(adb)
        elif choice == '4':
            interactive_control(adb)
        elif choice == '5':
            install_apk(adb)
        elif choice == '6':
            enable_wireless(adb)
        elif choice == '7':
            live_preview(adb)
        elif choice == '0':
            print_info("Goodbye!")
            break


if __name__ == '__main__':
    sys.exit(main())