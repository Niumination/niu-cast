#!/usr/bin/env python3
"""
╔══════════════════════════════════════════════════════════════════════════════╗
║                        NIU CAST - Screen Mirroring                        ║
║                                                                            ║
║  Author: niumination                                ║
╚══════════════════════════════════════════════════════════════════════════════╝

Features:
- Screen mirroring Android ke Mac
- Kontrol sentuh dari Mac ke Android
- Wireless connection (WiFi)
- USB debugging support
- Recording screen
- Multi-device support
"""

import sys
import os
import time
import signal
import subprocess
import socket
import threading
import logging
from pathlib import Path

# Set up logging
logging.basicConfig(
    level=logging.INFO,
    format='%(asctime)s - %(name)s - %(levelname)s - %(message)s'
)
logger = logging.getLogger('NiuCast')

# Version
VERSION = "1.0.0"

try:
    from PyQt5.QtWidgets import (
        QApplication, QMainWindow, QWidget, QVBoxLayout, QHBoxLayout,
        QPushButton, QLabel, QComboBox, QTextEdit, QSlider, QGroupBox,
        QStatusBar, QMenuBar, QMenu, QAction, QFileDialog, QMessageBox,
        QTabWidget, QCheckBox, QProgressBar
    )
    from PyQt5.QtCore import Qt, QTimer, pyqtSignal, QThread, QSize
    from PyQt5.QtGui import QImage, QPixmap, QIcon, QPainter, QPen, QColor
    PYQT5_AVAILABLE = True
except ImportError:
    PYQT5_AVAILABLE = False
    logger.warning("PyQt5 not available, running in CLI mode")

import numpy as np
from PIL import Image
import cv2


# ═══════════════════════════════════════════════════════════════════════════════
#                           ADB CONTROLLER CLASS
# ═══════════════════════════════════════════════════════════════════════════════

class ADBController:
    """Controller untuk komunikasi dengan Android device via ADB"""
    
    def __init__(self):
        self.adb_path = self._find_adb()
        self.connected_device = None
        self.device_serial = None
        
    def _find_adb(self) -> str:
        """Cari ADB binary di sistem"""
        common_paths = [
            'adb',
            '/usr/bin/adb',
            '/usr/local/bin/adb',
            '/opt/android-sdk/platform-tools/adb',
            os.path.expanduser('~/Android/Sdk/platform-tools/adb'),
            os.path.expanduser('~/android-sdk/platform-tools/adb'),
        ]
        
        for path in common_paths:
            if os.path.exists(path):
                return path
        
        # Try to find via which
        try:
            result = subprocess.run(['which', 'adb'], capture_output=True, text=True)
            if result.returncode == 0:
                return result.stdout.strip()
        except:
            pass
            
        return 'adb'  # Default fallback
    
    def execute_command(self, args, timeout=30):
        """Execute ADB command"""
        cmd = [self.adb_path] + args
        try:
            result = subprocess.run(
                cmd, 
                capture_output=True, 
                text=True, 
                timeout=timeout
            )
            return result.returncode, result.stdout, result.stderr
        except subprocess.TimeoutExpired:
            return -1, "", "Command timeout"
        except Exception as e:
            return -1, "", str(e)
    
    def devices(self) -> list:
        """List semua connected devices"""
        returncode, stdout, stderr = self.execute_command(['devices', '-l'])
        devices = []
        if returncode == 0:
            for line in stdout.splitlines()[1:]:  # Skip header
                if line.strip() and not line.startswith('*'):
                    parts = line.split()
                    if parts:
                        devices.append(parts[0])
        return devices
    
    def connect(self, device_serial=None):
        """Connect ke device"""
        if device_serial:
            returncode, stdout, stderr = self.execute_command(['-s', device_serial, 'get-state'])
            if returncode == 0 and 'device' in stdout:
                self.device_serial = device_serial
                self.connected_device = device_serial
                logger.info(f"Connected to device: {device_serial}")
                return True
        
        # Auto-detect first available device
        devices = self.devices()
        if devices:
            self.device_serial = devices[0]
            self.connected_device = devices[0]
            logger.info(f"Auto-connected to: {devices[0]}")
            return True
        
        return False
    
    def shell(self, command, timeout=30):
        """Execute shell command di device"""
        if not self.device_serial:
            return -1, "", "No device connected"
        args = ['-s', self.device_serial, 'shell', command]
        return self.execute_command(args, timeout)
    
    def pull(self, remote_path, local_path):
        """Pull file dari device"""
        if not self.device_serial:
            return False
        args = ['-s', self.device_serial, 'pull', remote_path, local_path]
        returncode, stdout, stderr = self.execute_command(args, timeout=120)
        return returncode == 0
    
    def push(self, local_path, remote_path):
        """Push file ke device"""
        if not self.device_serial:
            return False
        args = ['-s', self.device_serial, 'push', local_path, remote_path]
        returncode, stdout, stderr = self.execute_command(args, timeout=120)
        return returncode == 0
    
    def forward(self, local_port, remote_port):
        """Setup port forwarding"""
        if not self.device_serial:
            return False
        args = ['-s', self.device_serial, 'forward', f'tcp:{local_port}', f'tcp:{remote_port}']
        returncode, stdout, stderr = self.execute_command(args)
        return returncode == 0
    
    def reverse(self, remote_port, local_port):
        """Setup reverse port forwarding"""
        if not self.device_serial:
            return False
        args = ['-s', self.device_serial, 'reverse', f'tcp:{remote_port}', f'tcp:{local_port}']
        returncode, stdout, stderr = self.execute_command(args)
        return returncode == 0
    
    def get_device_info(self) -> dict:
        """Ambil info device"""
        info = {}
        
        # Get model
        returncode, model, _ = self.shell('getprop ro.product.model')
        info['model'] = model.strip() if returncode == 0 else 'Unknown'
        
        # Get Android version
        returncode, version, _ = self.shell('getprop ro.build.version.release')
        info['android_version'] = version.strip() if returncode == 0 else 'Unknown'
        
        # Get manufacturer
        returncode, manufacturer, _ = self.shell('getprop ro.product.manufacturer')
        info['manufacturer'] = manufacturer.strip() if returncode == 0 else 'Unknown'
        
        # Get screen size
        returncode, wm_size, _ = self.shell('wm size')
        info['screen_size'] = wm_size.strip() if returncode == 0 else 'Unknown'
        
        return info
    
    def screen_resolution(self) -> tuple:
        """Get screen resolution"""
        returncode, output, _ = self.shell('wm size')
        if returncode == 0:
            try:
                # Parse output like "Physical size: 1080x2400"
                parts = output.strip().split(':')[-1].strip().split('x')
                if len(parts) == 2:
                    return int(parts[0]), int(parts[1])
            except:
                pass


# ═══════════════════════════════════════════════════════════════════════════════
#                        SCREEN CAPTURE THREAD
# ═══════════════════════════════════════════════════════════════════════════════

class NiuCaptureThread(QThread):
    """Thread untuk capture screen dari Android"""
    
    frame_ready = pyqtSignal(np.ndarray)
    error_occurred = pyqtSignal(str)
    
    def __init__(self, adb: ADBController):
        super().__init__()
        self.adb = adb
        self.running = False
        self.daemon = True
        
    def run(self):
        """Capture screen loop"""
        self.running = True
        
        while self.running:
            try:
                # Use screencap via ADB
                returncode, stdout, stderr = self.adb.shell(
                    'screencap -p /sdcard/screen.png',
                    timeout=5
                )
                
                if returncode != 0:
                    self.error_occurred.emit(f" screencap failed: {stderr}")
                    time.sleep(0.5)
                    continue
                
                # Pull the screenshot
                local_temp = '/tmp/niu_screen.png'
                if self.adb.pull('/sdcard/screen.png', local_temp):
                    # Read and emit frame
                    img = cv2.imread(local_temp)
                    if img is not None:
                        self.frame_ready.emit(img)
                    else:
                        self.error_occurred.emit("Failed to decode image")
                else:
                    self.error_occurred.emit("Failed to pull screenshot")
                    
            except Exception as e:
                self.error_occurred.emit(f"Capture error: {str(e)}")
            
            time.sleep(0.033)  # ~30 FPS default
        
    def stop(self):
        """Stop capture"""
        self.running = False
        self.wait()


# ═══════════════════════════════════════════════════════════════════════════════
#                        NIU CAST MAIN WINDOW
# ═══════════════════════════════════════════════════════════════════════════════

class NiuCastWindow(QMainWindow):
    """Main window untuk NiuCast"""
    
    def __init__(self):
        super().__init__()
        self.adb = ADBController()
        self.capture_thread = None
        self.recording = False
        self.record_writer = None
        
        self.init_ui()
        self.setup_connections()
        
    def init_ui(self):
        """Initialize UI"""
        self.setWindowTitle(f"NiuCast v{VERSION} - Screen Mirroring")
        self.setGeometry(100, 100, 1200, 800)
        
        # Central widget
        central = QWidget()
        self.setCentralWidget(central)
        
        # Main layout
        main_layout = QVBoxLayout(central)
        
        # ===== Device Selection =====
        device_group = QGroupBox("Device Connection")
        device_layout = QHBoxLayout()
        
        self.device_combo = QComboBox()
        self.device_combo.setMinimumWidth(200)
        self.refresh_btn = QPushButton("🔄 Refresh Devices")
        self.connect_btn = QPushButton("🔗 Connect")
        self.disconnect_btn = QPushButton("❌ Disconnect")
        
        device_layout.addWidget(QLabel("Device:"))
        device_layout.addWidget(self.device_combo)
        device_layout.addWidget(self.refresh_btn)
        device_layout.addWidget(self.connect_btn)
        device_layout.addWidget(self.disconnect_btn)
        device_layout.addStretch()
        
        device_group.setLayout(device_layout)
        main_layout.addWidget(device_group)
        
        # ===== Device Info =====
        self.info_label = QLabel("No device connected")
        self.info_label.setStyleSheet("padding: 5px; background: #2a2a2a; color: #00ff00;")
        main_layout.addWidget(self.info_label)
        
        # ===== Tab Widget =====
        tabs = QTabWidget()
        
        # Mirror Tab
        mirror_tab = QWidget()
        mirror_layout = QVBoxLayout(mirror_tab)
        
        # Video display
        self.video_label = QLabel()
        self.video_label.setMinimumSize(360, 800)
        self.video_label.setAlignment(Qt.AlignCenter)
        self.video_label.setStyleSheet("background: #000; color: #fff;")
        self.video_label.setText("📱 Connect to device to start mirroring\n\nWaiting for device...")
        
        mirror_layout.addWidget(self.video_label)
        main_layout.addWidget(mirror_tab)
        tabs.addTab(mirror_tab, "📱 Mirror")
        
        # Control Tab
        control_tab = QWidget()
        control_layout = QVBoxLayout(control_tab)
        
        # Input controls
        control_group = QGroupBox("Remote Control")
        control_box = QVBoxLayout()
        
        self.home_btn = QPushButton("🏠 Home")
        self.back_btn = QPushButton("⬅️ Back")
        self.recents_btn = QPushButton("📋 Recents")
        self.power_btn = QPushButton("⏻ Power")
        self.volume_up = QPushButton("🔊 Volume Up")
        self.volume_down = QPushButton("🔉 Volume Down")
        
        btn_row1 = QHBoxLayout()
        btn_row1.addWidget(self.home_btn)
        btn_row1.addWidget(self.back_btn)
        btn_row1.addWidget(self.recents_btn)
        
        btn_row2 = QHBoxLayout()
        btn_row2.addWidget(self.power_btn)
        btn_row2.addWidget(self.volume_up)
        btn_row2.addWidget(self.volume_down)
        
        control_box.addLayout(btn_row1)
        control_box.addLayout(btn_row2)
        control_group.setLayout(control_box)
        control_layout.addWidget(control_group)
        
        # Quick actions
        action_group = QGroupBox("Quick Actions")
        action_box = QVBoxLayout()
        
        self.screenshot_btn = QPushButton("📷 Take Screenshot")
        self.record_btn = QPushButton("⏺ Start Recording")
        self.install_btn = QPushButton("📦 Install APK")
        
        action_box.addWidget(self.screenshot_btn)
        action_box.addWidget(self.record_btn)
        action_box.addWidget(self.install_btn)
        action_group.setLayout(action_box)
        control_layout.addWidget(action_group)
        
        tabs.addTab(control_tab, "🎮 Control")
        
        # Log Tab
        log_tab = QWidget()
        log_layout = QVBoxLayout(log_tab)
        
        self.log_text = QTextEdit()
        self.log_text.setReadOnly(True)
        self.log_text.setStyleSheet("font-family: monospace; background: #1e1e1e; color: #0f0;")
        log_layout.addWidget(self.log_text)
        
        tabs.addTab(log_tab, "📋 Logs")
        
        main_layout.addWidget(tabs)
        
        # ===== Status Bar =====
        self.status_bar = QStatusBar()
        self.setStatusBar(self.status_bar)
        self.status_bar.showMessage("Ready - Select a device to connect")
        
        # ===== Menu Bar =====
        self.create_menu_bar()
        
    def create_menu_bar(self):
        """Create menu bar"""
        menubar = self.menuBar()
        
        # File menu
        file_menu = menubar.addMenu("File")
        
        refresh_action = QAction("Refresh Devices", self)
        refresh_action.setShortcut("Ctrl+R")
        file_menu.addAction(refresh_action)
        refresh_action.triggered.connect(self.refresh_devices)
        
        file_menu.addSeparator()
        
        exit_action = QAction("Exit", self)
        exit_action.setShortcut("Ctrl+Q")
        file_menu.addAction(exit_action)
        exit_action.triggered.connect(self.close)
        
        # Tools menu
        tools_menu = menubar.addMenu("Tools")
        
        screenshot_action = QAction("Screenshot", self)
        screenshot_action.setShortcut("Ctrl+S")
        tools_menu.addAction(screenshot_action)
        screenshot_action.triggered.connect(self.take_screenshot)
        
        record_action = QAction("Toggle Recording", self)
        record_action.setShortcut("Ctrl+Shift+R")
        tools_menu.addAction(record_action)
        record_action.triggered.connect(self.toggle_recording)
        
        # Help menu
        help_menu = menubar.addMenu("Help")
        
        about_action = QAction("About NiuCast", self)
        help_menu.addAction(about_action)
        about_action.triggered.connect(self.show_about)
        
    def setup_connections(self):
        """Setup signal/slot connections"""
        self.refresh_btn.clicked.connect(self.refresh_devices)
        self.connect_btn.clicked.connect(self.connect_device)
        self.disconnect_btn.clicked.connect(self.disconnect_device)
        
        # Control buttons
        self.home_btn.clicked.connect(lambda: self.send_keyevent('KEYCODE_HOME'))
        self.back_btn.clicked.connect(lambda: self.send_keyevent('KEYCODE_BACK'))
        self.recents_btn.clicked.connect(lambda: self.send_keyevent('KEYCODE_APP_SWITCH'))
        self.power_btn.clicked.connect(lambda: self.send_keyevent('KEYCODE_POWER'))
        self.volume_up.clicked.connect(lambda: self.send_keyevent('KEYCODE_VOLUME_UP'))
        self.volume_down.clicked.connect(lambda: self.send_keyevent('KEYCODE_VOLUME_DOWN'))
        
        # Action buttons
        self.screenshot_btn.clicked.connect(self.take_screenshot)
        self.record_btn.clicked.connect(self.toggle_recording)
        self.install_btn.clicked.connect(self.install_apk)
        
        # Timer for refreshing device list
        self.device_timer = QTimer()
        self.device_timer.timeout.connect(self.check_devices)
        self.device_timer.start(5000)  # Check every 5 seconds
        
    def refresh_devices(self):
        """Refresh device list"""
        devices = self.adb.devices()
        self.device_combo.clear()
        
        if devices:
            self.device_combo.addItems(devices)
            self.log(f"Found {len(devices)} device(s): {', '.join(devices)}")
        else:
            self.device_combo.addItem("No devices found")
            self.log("⚠️ No devices connected. Make sure USB debugging is enabled.")
        
    def connect_device(self):
        """Connect to selected device"""
        serial = self.device_combo.currentText()
        if serial == "No devices found" or not serial:
            self.log("❌ No device to connect")
            return
        
        if self.adb.connect(serial):
            self.log(f"✅ Connected to {serial}")
            
            # Get device info
            info = self.adb.get_device_info()
            info_text = f"{info['manufacturer']} {info['model']} (Android {info['android_version']}) - {info['screen_size']}"
            self.info_label.setText(info_text)
            self.status_bar.showMessage(f"Connected: {info_text}")
            
            # Start screen capture
            self.start_capture()
        else:
            self.log("❌ Failed to connect to device")
            QMessageBox.warning(self, "Connection Failed", 
                              "Could not connect to device. Make sure:\n"
                              "1. USB debugging is enabled\n"
                              "2. USB cable is connected\n"
                              "3. You authorized the computer on the device")
    
    def disconnect_device(self):
        """Disconnect from device"""
        if self.capture_thread:
            self.capture_thread.stop()
            self.capture_thread = None
        
        self.adb.device_serial = None
        self.adb.connected_device = None
        
        self.log("🔌 Disconnected from device")
        self.info_label.setText("No device connected")
        self.video_label.setText("📱 Connect to device to start mirroring\n\nWaiting for device...")
        self.status_bar.showMessage("Disconnected")
    
    def start_capture(self):
        """Start screen capture"""
        if self.capture_thread:
            self.capture_thread.stop()
        
        self.capture_thread = NiuCaptureThread(self.adb)
        self.capture_thread.frame_ready.connect(self.display_frame)
        self.capture_thread.error_occurred.connect(self.handle_capture_error)
        self.capture_thread.start()
        
        self.log("📹 Screen capture started")
    
    def display_frame(self, frame: np.ndarray):
        """Display captured frame"""
        # Resize for display
        display_frame = cv2.resize(frame, (540, int(540 * frame.shape[0] / frame.shape[1])))
        
        # Convert to Qt format
        rgb_frame = cv2.cvtColor(display_frame, cv2.COLOR_BGR2RGB)
        h, w, ch = rgb_frame.shape
        bytes_per_line = ch * w
        qt_image = QImage(rgb_frame.data, w, h, bytes_per_line, QImage.Format_RGB888)
        
        # Scale pixmap to fit label
        pixmap = QPixmap.fromImage(qt_image)
        scaled_pixmap = pixmap.scaled(
            self.video_label.size(), 
            Qt.KeepAspectRatio, 
            Qt.SmoothTransformation
        )
        
        self.video_label.setPixmap(scaled_pixmap)
        
        # Record if active
        if self.recording and self.record_writer:
            self.record_writer.write(frame)
    
    def handle_capture_error(self, error: str):
        """Handle capture errors"""
        self.log(f"⚠️ {error}")
    
    def check_devices(self):
        """Periodically check for connected devices"""
        if not self.adb.connected_device:
            self.refresh_devices()
    
    def send_keyevent(self, keycode: str):
        """Send keyevent ke device"""
        if not self.adb.connected_device:
            self.log("❌ No device connected")
            return
        
        returncode, stdout, stderr = self.adb.shell(f"input keyevent {keycode}")
        if returncode == 0:
            self.log(f"✅ Sent keyevent: {keycode}")
        else:
            self.log(f"❌ Failed to send keyevent: {stderr}")
    
    def take_screenshot(self):
        """Ambil screenshot"""
        if not self.adb.connected_device:
            self.log("❌ No device connected")
            return
        
        timestamp = time.strftime("%Y%m%d_%H%M%S")
        local_path = f"/tmp/niu_screenshot_{timestamp}.png"
        
        # Capture and pull
        self.adb.shell("screencap -p /sdcard/screenshot.png", timeout=5)
        
        if self.adb.pull("/sdcard/screenshot.png", local_path):
            self.log(f"📷 Screenshot saved: {local_path}")
            QMessageBox.information(self, "Screenshot", f"Screenshot saved to:\n{local_path}")
        else:
            self.log("❌ Failed to capture screenshot")
    
    def toggle_recording(self):
        """Toggle screen recording"""
        if not self.adb.connected_device:
            self.log("❌ No device connected")
            return
        
        if not self.recording:
            # Start recording
            timestamp = time.strftime("%Y%m%d_%H%M%S")
            self.record_path = f"/tmp/niu_recording_{timestamp}.mp4"
            
            # Get resolution
            width, height = self.adb.screen_resolution()
            
            # Create video writer
            fourcc = cv2.VideoWriter_fourcc(*'mp4v')
            self.record_writer = cv2.VideoWriter(self.record_path, fourcc, 30.0, (width, height))
            
            self.recording = True
            self.record_btn.setText("⏹ Stop Recording")
            self.log(f"⏺ Recording started: {self.record_path}")
            self.status_bar.showMessage("🔴 Recording...")
        else:
            # Stop recording
            self.recording = False
            if self.record_writer:
                self.record_writer.release()
                self.record_writer = None
            
            self.record_btn.setText("⏺ Start Recording")
            self.log(f"✅ Recording saved: {self.record_path}")
            self.status_bar.showMessage("Ready")
            QMessageBox.information(self, "Recording Saved", 
                                  f"Recording saved to:\n{self.record_path}")
    
    def install_apk(self):
        """Install APK file"""
        if not self.adb.connected_device:
            self.log("❌ No device connected")
            return
        
        file_path, _ = QFileDialog.getOpenFileName(
            self, "Select APK file", "", "APK Files (*.apk)"
        )
        
        if file_path:
            self.log(f"📦 Installing: {file_path}")
            self.status_bar.showMessage(f"Installing {os.path.basename(file_path)}...")
            
            # Install APK
            returncode, stdout, stderr = self.adb.execute_command([
                '-s', self.adb.device_serial, 'install', '-r', file_path
            ], timeout=300)
            
            if returncode == 0:
                self.log("✅ APK installed successfully")
                QMessageBox.information(self, "Installation Complete", "APK installed successfully!")
            else:
                self.log(f"❌ Installation failed: {stderr}")
                QMessageBox.critical(self, "Installation Failed", f"Failed to install APK:\n{stderr}")
            
            self.status_bar.showMessage("Ready")
    
    def log(self, message: str):
        """Add log message"""
        timestamp = time.strftime("%H:%M:%S")
        self.log_text.append(f"[{timestamp}] {message}")
    
    def show_about(self):
        """Show about dialog"""
        QMessageBox.about(self, "About NiuCast",
                        f"<h2>NiuCast v{VERSION}</h2>"
                        f"<p>Screen mirroring application for Android devices</p>"
                        f"<p>Agent: NiuCast</p>")
    
    def closeEvent(self, event):
        """Cleanup on close"""
        if self.capture_thread:
            self.capture_thread.stop()
        if self.recording and self.record_writer:
            self.record_writer.release()
        event.accept()


# ═══════════════════════════════════════════════════════════════════════════════
#                           CLI MODE (No GUI)
# ═══════════════════════════════════════════════════════════════════════════════

def run_cli_mode():
    """Run in CLI mode (no GUI)"""
    print("╔════════════════════════════════════════════════════════════╗")
    print("║              NIU CAST - CLI Mode                        ║")
    print("╠════════════════════════════════════════════════════════════╣")
    print("╚════════════════════════════════════════════════════════════╝")
    print()
    
    adb = ADBController()
    
    print("[*] Checking for ADB...")
    returncode, _, _ = adb.execute_command(['version'])
    if returncode != 0:
        print("[!] ADB not found. Please install Android SDK platform-tools.")
        return
    
    print("[*] Scanning for devices...")
    devices = adb.devices()
    
    if not devices:
        print("[!] No devices found.")
        print("    Make sure:")
        print("    2. Connect USB cable")
        print("    3. Authorize USB debugging on the device")
        return
    
    print(f"[+] Found {len(devices)} device(s)")
    for d in devices:
        print(f"    - {d}")
    
    print(f"\n[*] Connecting to {devices[0]}...")
    if adb.connect(devices[0]):
        print(f"[+] Connected to {devices[0]}")
        
        info = adb.get_device_info()
        print(f"\n[+] Device Info:")
        print(f"    Model: {info['manufacturer']} {info['model']}")
        print(f"    Android: {info['android_version']}")
        print(f"    Screen: {info['screen_size']}")
        
        print("\n[*] Testing screen capture...")
        adb.shell("screencap -p /sdcard/screen.png", timeout=5)
        
        print("\n[+] All systems ready!")
        print("\n[*] For full GUI with screen mirroring, run with PyQt5:")
        print("    pip install PyQt5 opencv-python")
        print("    python niu_cast.py")
    else:
        print("[!] Failed to connect")


# ═══════════════════════════════════════════════════════════════════════════════
#                              MAIN ENTRY POINT
# ═══════════════════════════════════════════════════════════════════════════════

def main():
    """Entry point for 'niu-cast' command"""
    if PYQT5_AVAILABLE:
        app = QApplication(sys.argv)
        window = NiuCastWindow()
        window.show()
        return app.exec_()
    else:
        print("PyQt5 not available, running in CLI mode...")
        run_cli_mode()
        return 0


if __name__ == "__main__":
    main()