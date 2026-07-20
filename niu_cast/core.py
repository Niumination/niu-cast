#!/usr/bin/env python3
"""
╔══════════════════════════════════════════════════════════════════════════════╗
║                        NIU CAST - CORE                                      ║
║                    Gaming Edition UI                                        ║
║                                                                            ║
║  UI Inspiration: Genshin Impact, Xarena, Cyberpunk 2077                    ║
║  Features: Real-time mirroring, touch simulation, gaming aesthetics         ║
╚══════════════════════════════════════════════════════════════════════════════╝
"""

import sys
import os
import time
import socket
import threading
import subprocess
import base64
import struct
import io
from datetime import datetime

try:
    from PyQt5.QtWidgets import (
        QApplication, QMainWindow, QWidget, QVBoxLayout, QHBoxLayout,
        QPushButton, QLabel, QComboBox, QSlider, QGroupBox, QStatusBar,
        QMenuBar, QMenu, QAction, QFileDialog, QMessageBox, QTabWidget,
        QCheckBox, QFrame, QGraphicsDropShadowEffect,
        QSizePolicy, QSpacerItem, QProgressBar, QToolButton, QStackedWidget
    )
    from PyQt5.QtCore import (
        Qt, QTimer, pyqtSignal, QThread, QSize, QRect,
        QParallelAnimationGroup, QEasingCurve, QPoint, pyqtProperty,
        QPropertyAnimation
    )
    from PyQt5.QtGui import (
        QImage, QPixmap, QIcon, QPainter, QPen, QColor, QBrush, QFont,
        QLinearGradient, QRadialGradient, QConicalGradient, QPalette,
        QMovie, QPainterPath, QTransform, QCursor
    )
    PYQT5_AVAILABLE = True
except ImportError:
    PYQT5_AVAILABLE = False
    print("PyQt5 not available. Please install: pip install PyQt5")

import numpy as np
import cv2

# Gaming Edition modules
from .theme_manager import ThemeManager
from .game_mode import GameMode, PerformanceMonitor, GameLauncher
from .shortcuts import KeyboardShortcuts
from .file_browser import FileBrowserWidget


# ═══════════════════════════════════════════════════════════════════════════════
#                           GAMING THEME PALETTE
# ═══════════════════════════════════════════════════════════════════════════════

class GamingTheme:
    """Genshin/Xarena inspired color palette"""
    
    # Primary Colors
    BG_DARK = "#0D0D1A"           # Deep space black
    BG_CARD = "#1A1A2E"           # Card background
    BG_PANEL = "#16162A"          # Panel background
    
    # Accent Colors (Cyberpunk inspired)
    CYAN_PRIMARY = "#00F5FF"      # Bright cyan (like Genshin elemental)
    CYAN_GLOW = "#00D4E5"         # Cyan glow
    MAGENTA_ACCENT = "#FF00FF"    # Magenta (energy/power)
    PURPLE_HIGHLIGHT = "#9D4EDD"  # Purple highlight
    GOLD_ACCENT = "#FFD700"       # Gold (premium feel)
    
    # Gradients
    GRADIENT_CYAN = [(0, "#00F5FF"), (1, "#0066FF")]
    GRADIENT_MAGENTA = [(0, "#FF00FF"), (1, "#FF6B00")]
    GRADIENT_GOLD = [(0, "#FFD700"), (1, "#FF8C00")]
    
    # Text Colors
    TEXT_PRIMARY = "#FFFFFF"
    TEXT_SECONDARY = "#A0A0B0"
    TEXT_MUTED = "#606070"
    
    # Status Colors
    STATUS_CONNECTED = "#00FF88"
    STATUS_DISCONNECTED = "#FF4444"
    STATUS_WARNING = "#FFAA00"
    
    # Effects
    BORDER_GLOW = 2
    SHADOW_BLUR = 15
    SHADOW_COLOR = QColor(0, 245, 255, 100)
    
    @classmethod
    def get_gradient(cls, gradient_type='cyan'):
        """Get QLinearGradient based on type"""
        if gradient_type == 'cyan':
            stops = cls.GRADIENT_CYAN
        elif gradient_type == 'magenta':
            stops = cls.GRADIENT_MAGENTA
        elif gradient_type == 'gold':
            stops = cls.GRADIENT_GOLD
        else:
            stops = cls.GRADIENT_CYAN
        
        gradient = QLinearGradient(0, 0, 1, 0)
        for pos, color in stops:
            gradient.setColorAt(pos, QColor(color))
        return gradient


# ═══════════════════════════════════════════════════════════════════════════════
#                           CUSTOM WIDGETS
# ═══════════════════════════════════════════════════════════════════════════════

class GamingButton(QPushButton):
    """Gaming-styled button with glow effect"""
    
    def __init__(self, text="", icon=None, theme='cyan', parent=None):
        super().__init__(text, parent)
        self.theme = GamingTheme
        self.gradient_type = theme
        self.setCursor(QCursor(Qt.PointingHandCursor))
        self._setup_style()
    
    def _setup_style(self):
        self.setMinimumHeight(40)
        self.setFont(QFont("Segoe UI", 10, QFont.Bold))
        
        # Color mapping
        colors = {
            'cyan': GamingTheme.CYAN_PRIMARY,
            'magenta': GamingTheme.MAGENTA_ACCENT,
            'gold': GamingTheme.GOLD_ACCENT,
            'red': GamingTheme.STATUS_DISCONNECTED,
            'green': GamingTheme.STATUS_CONNECTED,
        }
        color = colors.get(self.gradient_type, GamingTheme.CYAN_PRIMARY)
        
        self.setStyleSheet(f"""
            QPushButton {{
                background: qlineargradient(x1:0, y1:0, x2:1, y2:0,
                    stop:0 {color}, stop:1 {GamingTheme.BG_CARD});
                color: {GamingTheme.TEXT_PRIMARY};
                border: 1px solid {color};
                border-radius: 5px;
                padding: 8px 20px;
                font-weight: bold;
                letter-spacing: 1px;
            }}
            QPushButton:hover {{
                background: qlineargradient(x1:0, y1:0, x2:1, y2:0,
                    stop:0 {color}, stop:1 {color}40);
                border: 2px solid {color};
                padding: 7px 19px;
            }}
            QPushButton:pressed {{
                background: {GamingTheme.BG_DARK};
                border: 2px solid {color};
            }}
            QPushButton:disabled {{
                background: {GamingTheme.BG_PANEL};
                color: {GamingTheme.TEXT_MUTED};
                border: 1px solid {GamingTheme.TEXT_MUTED};
            }}
        """)


class GamingCard(QFrame):
    """Gaming-styled card with glow border"""
    
    def __init__(self, title="", glow_color=None, parent=None):
        super().__init__(parent)
        self.glow_color = glow_color or GamingTheme.CYAN_PRIMARY
        self.title_text = title
        self.setFrameStyle(QFrame.StyledPanel | QFrame.Raised)
        self._setup_style()
    
    def _setup_style(self):
        self.setStyleSheet(f"""
            QFrame {{
                background: {GamingTheme.BG_CARD};
                border: 1px solid {self.glow_color}40;
                border-radius: 10px;
            }}
        """)
        
        # Add shadow effect
        shadow = QGraphicsDropShadowEffect()
        shadow.setBlurRadius(15)
        shadow.setColor(QColor(self.glow_color).lighter(150))
        shadow.setOffset(0, 0)
        self.setGraphicsEffect(shadow)
    
    def paintEvent(self, event):
        """Custom paint for gradient border glow"""
        painter = QPainter(self)
        painter.setRenderHint(QPainter.Antialiasing)
        
        # Draw gradient border
        rect = self.rect().adjusted(1, 1, -1, -1)
        
        # Background
        painter.fillRect(rect, QColor(GamingTheme.BG_CARD))
        
        # Glow effect on border
        pen = QPen(QColor(self.glow_color).lighter(180))
        pen.setWidth(2)
        painter.setPen(pen)
        painter.drawRoundedRect(rect, 10, 10)


class AnimatedLabel(QLabel):
    """Label with typing/pulse animation"""
    
    def __init__(self, text="", parent=None):
        super().__init__(text, parent)
        self.setFont(QFont("Segoe UI", 11))
        self.setStyleSheet(f"color: {GamingTheme.TEXT_PRIMARY};")
        
        # Pulse animation
        self._opacity = 1.0
        self._direction = -0.05
        self._timer = QTimer()
        self._timer.timeout.connect(self._pulse)
    
    def start_pulse(self, speed=50):
        self._timer.start(speed)
    
    def stop_pulse(self):
        self._timer.stop()
        self.setStyleSheet(f"color: {GamingTheme.TEXT_PRIMARY};")
    
    def _pulse(self):
        self._opacity += self._direction
        if self._opacity <= 0.5 or self._opacity >= 1.0:
            self._direction *= -1
        color = f"rgba(255, 255, 255, {int(self._opacity * 255)})"
        self.setStyleSheet(f"color: {color};")


class StatusIndicator(QLabel):
    """Animated status indicator dot"""
    
    def __init__(self, status='disconnected', parent=None):
        super().__init__(parent)
        self.status = status
        self._setup_ui()
        self._start_animation()
    
    def _setup_ui(self):
        self.setFixedSize(12, 12)
        self.update_color()
    
    def update_color(self):
        colors = {
            'connected': GamingTheme.STATUS_CONNECTED,
            'disconnected': GamingTheme.STATUS_DISCONNECTED,
            'warning': GamingTheme.STATUS_WARNING,
            'syncing': GamingTheme.CYAN_PRIMARY,
        }
        color = colors.get(self.status, GamingTheme.STATUS_DISCONNECTED)
        self.setStyleSheet(f"""
            QLabel {{
                background: {color};
                border-radius: 6px;
            }}
        """)
    
    def _start_animation(self):
        self._timer = QTimer()
        self._timer.timeout.connect(self._animate)
        self._angle = 0
        self._timer.start(50)
    
    def _animate(self):
        self._angle += 10
        glow = abs(int(128 + 127 * (self._angle % 360) / 180 - 63.5))
        
        colors = {
            'connected': f"rgb(0, {glow}, 136)",
            'disconnected': f"rgb({glow}, 68, 68)",
            'warning': f"rgb({glow}, 170, 0)",
            'syncing': f"rgb(0, {glow}, 255)",
        }
        color = colors.get(self.status, colors['disconnected'])
        self.setStyleSheet(f"background: {color}; border-radius: 6px;")


class GlowingLine(QFrame):
    """Horizontal glowing divider"""
    
    def __init__(self, color=GamingTheme.CYAN_PRIMARY, parent=None):
        super().__init__(parent)
        self.glow_color = color
        self.setFixedHeight(2)
        self.setFrameShape(QFrame.HLine)
        self.setStyleSheet(f"background: transparent; border: none;")
    
    def paintEvent(self, event):
        painter = QPainter(self)
        painter.setRenderHint(QPainter.Antialiasing)
        
        gradient = QLinearGradient(0, 0, self.width(), 0)
        gradient.setColorAt(0, QColor(self.glow_color).lighter(200).lighter(200))
        gradient.setColorAt(0.5, QColor(self.glow_color))
        gradient.setColorAt(1, QColor(self.glow_color).lighter(200).lighter(200))
        
        painter.setPen(QPen(QBrush(gradient), 2))
        painter.drawLine(0, 1, self.width(), 1)


class CircularButton(QPushButton):
    """Circular icon button with glow"""
    
    def __init__(self, icon_text="", size=50, color=GamingTheme.CYAN_PRIMARY, parent=None):
        super().__init__(parent)
        self.glow_color = color
        self.setFixedSize(size, size)
        self.setText(icon_text)
        self.setCursor(QCursor(Qt.PointingHandCursor))
        self._setup_style()
    
    def _setup_style(self):
        self.setStyleSheet(f"""
            QPushButton {{
                background: {GamingTheme.BG_PANEL};
                color: {self.glow_color};
                border: 2px solid {self.glow_color};
                border-radius: {self.width()//2}px;
                font-size: 18px;
                font-weight: bold;
            }}
            QPushButton:hover {{
                background: {self.glow_color}30;
                border: 3px solid {self.glow_color};
            }}
            QPushButton:pressed {{
                background: {self.glow_color};
                color: {GamingTheme.BG_DARK};
            }}
        """)


# ═══════════════════════════════════════════════════════════════════════════════
#                           ADB CONTROLLER
# ═══════════════════════════════════════════════════════════════════════════════

class ADBController:
    """ADB communication controller with streaming support"""
    
    def __init__(self):
        self.adb_path = self._find_adb()
        self.device_serial = None
        self.device_ip = None
        self.streaming = False
        
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
        except Exception as e:
            return -1, "", str(e)
    
    def devices(self):
        rc, out, _ = self._run(['devices', '-l'])
        devices = []
        if rc == 0:
            for line in out.splitlines()[1:]:
                if line.strip() and 'device' in line and 'unauthorized' not in line:
                    parts = line.split()
                    if parts:
                        devices.append(parts[0])
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
    
    def forward(self, local_port, remote_port):
        if not self.device_serial:
            return False
        rc, _, _ = self._run(['-s', self.device_serial, 'forward', f'tcp:{local_port}', f'tcp:{remote_port}'])
        return rc == 0
    
    def reverse(self, remote_port, local_port):
        if not self.device_serial:
            return False
        rc, _, _ = self._run(['-s', self.device_serial, 'reverse', f'tcp:{remote_port}', f'tcp:{local_port}'])
        return rc == 0
    
    def get_device_info(self):
        info = {}
        rc, model, _ = self.shell('getprop ro.product.model')
        info['model'] = model.strip() if rc == 0 else 'Unknown'
        
        rc, manufacturer, _ = self.shell('getprop ro.product.manufacturer')
        info['manufacturer'] = manufacturer.strip() if rc == 0 else 'Unknown'
        
        rc, android, _ = self.shell('getprop ro.build.version.release')
        info['android'] = android.strip() if rc == 0 else 'Unknown'
        
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
        
        # Get IP for wireless
        rc, ip_out, _ = self.shell('ip route')
        if rc == 0:
            import re
            ip_match = re.search(r'wlan0.*?src (\d+\.\d+\.\d+\.\d+)', ip_out)
            if ip_match:
                self.device_ip = ip_match.group(1)
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
        """Enable ADB over WiFi"""
        # Get IP first
        self.get_device_info()
        
        # Restart ADB in TCP mode
        self.shell('setprop service.adb.tcpip 5555', timeout=5)
        time.sleep(2)
        
        # If we have IP, connect
        if self.device_ip:
            self._run(['connect', f'{self.device_ip}:5555'])
            return True
        return False


# ═══════════════════════════════════════════════════════════════════════════════
#                           VIDEO STREAM THREAD
# ═══════════════════════════════════════════════════════════════════════════════

class VideoStreamThread(QThread):
    """High-performance video streaming via ADB tunnel"""
    
    frame_ready = pyqtSignal(np.ndarray)
    error_occurred = pyqtSignal(str)
    fps_updated = pyqtSignal(float)
    
    def __init__(self, adb: ADBController):
        super().__init__()
        self.adb = adb
        self.running = False
        self.daemon = True
        self.fps = 0
        self._frame_count = 0
        self._start_time = time.time()
        
    def run(self):
        """Optimized screencap loop with FPS tracking"""
        self.running = True
        
        while self.running:
            try:
                start = time.time()
                
                # Screencap to temp file
                rc, _, _ = self.adb.shell('screencap -p /sdcard/.niu_stream.png', timeout=5)
                
                if rc != 0:
                    self.error_occurred.emit("Failed to capture frame")
                    time.sleep(0.1)
                    continue
                
                # Pull frame
                if self.adb.pull('/sdcard/.niu_stream.png', '/tmp/niu_frame.png'):
                    img = cv2.imread('/tmp/niu_frame.png')
                    if img is not None:
                        # Calculate FPS
                        self._frame_count += 1
                        elapsed = time.time() - self._start_time
                        if elapsed >= 1.0:
                            self.fps = self._frame_count / elapsed
                            self.fps_updated.emit(self.fps)
                            self._frame_count = 0
                            self._start_time = time.time()
                        
                        self.frame_ready.emit(img)
                    else:
                        self.error_occurred.emit("Failed to decode image")
                else:
                    self.error_occurred.emit("Failed to pull frame")
                    
            except Exception as e:
                self.error_occurred.emit(f"Stream error: {str(e)}")
            
            # Target ~60 FPS
            elapsed = time.time() - start
            sleep_time = max(0.016 - elapsed, 0.001)  # ~60 FPS max
            time.sleep(sleep_time)
        
    def stop(self):
        self.running = False
        self.wait()


# ═══════════════════════════════════════════════════════════════════════════════
#                           TOUCH INPUT HANDLER
# ═══════════════════════════════════════════════════════════════════════════════

class TouchInputHandler:
    """Handle touch input from mirrored screen"""
    
    def __init__(self, adb: ADBController, screen_label):
        self.adb = adb
        self.screen_label = screen_label
        self.enabled = True
        self.device_width = 1080
        self.device_height = 2400
        
    def set_device_resolution(self, width, height):
        self.device_width = width
        self.device_height = height
    
    def handle_click(self, event):
        """Convert click position to device coordinates"""
        if not self.enabled:
            return
        
        # Get label geometry
        label_rect = self.screen_label.rect()
        
        # Get click position relative to label
        x = event.x()
        y = event.y()
        
        # Calculate scale
        scale_x = self.device_width / label_rect.width()
        scale_y = self.device_height / label_rect.height()
        
        # Convert to device coordinates
        device_x = int(x * scale_x)
        device_y = int(y * scale_y)
        
        # Send tap
        self.adb.send_tap(device_x, device_y)
        
    def handle_drag(self, start_pos, end_pos):
        """Handle drag gesture"""
        if not self.enabled:
            return
        
        label_rect = self.screen_label.rect()
        scale_x = self.device_width / label_rect.width()
        scale_y = self.device_height / label_rect.height()
        
        x1, y1 = int(start_pos.x() * scale_x), int(start_pos.y() * scale_y)
        x2, y2 = int(end_pos.x() * scale_x), int(end_pos.y() * scale_y)
        
        self.adb.send_swipe(x1, y1, x2, y2, duration=500)


# ═══════════════════════════════════════════════════════════════════════════════
#                           MAIN WINDOW
# ═══════════════════════════════════════════════════════════════════════════════

class NiuCastWindow(QMainWindow):
    """Main gaming-styled window"""
    
    def __init__(self):
        super().__init__()
        self.adb = ADBController()
        self.stream_thread = None
        self.touch_handler = None
        self.recording = False
        self.record_writer = None
        self.drag_start = None
        
        # Gaming Edition modules
        self.game_mode = GameMode(self.adb)
        self.perf_monitor = PerformanceMonitor(self.adb)
        self.launcher = GameLauncher(self.adb)
        self.current_theme = 'cyberpunk'
        self.perf_labels = {}
        
        self._init_ui()
        self._setup_connections()
        self._start_animations()
    
    def _init_ui(self):
        """Initialize gaming-styled UI"""
        self.setWindowTitle("✦ NIU CAST • Gaming Edition ✦")
        self.setGeometry(100, 50, 1400, 900)
        self.setMinimumSize(1200, 700)
        
        # Dark theme background
        self.setStyleSheet(f"""
            QMainWindow {{
                background: {GamingTheme.BG_DARK};
            }}
            QWidget {{
                background: {GamingTheme.BG_DARK};
                color: {GamingTheme.TEXT_PRIMARY};
            }}
        """)
        
        # Central widget
        central = QWidget()
        self.setCentralWidget(central)
        
        # Main layout
        main_layout = QHBoxLayout(central)
        main_layout.setContentsMargins(0, 0, 0, 0)
        
        # ===== LEFT SIDEBAR =====
        sidebar = self._create_sidebar()
        main_layout.addWidget(sidebar, 0)
        
        # ===== MAIN CONTENT =====
        content = self._create_main_content()
        main_layout.addWidget(content, 1)
        
        # ===== STATUS BAR =====
        self._create_status_bar()
    
    def _create_sidebar(self):
        """Create gaming-styled sidebar"""
        sidebar = QFrame()
        sidebar.setFixedWidth(280)
        sidebar.setStyleSheet(f"""
            QFrame {{
                background: {GamingTheme.BG_PANEL};
                border-right: 1px solid {GamingTheme.CYAN_PRIMARY}30;
            }}
        """)
        
        layout = QVBoxLayout(sidebar)
        layout.setContentsMargins(15, 20, 15, 20)
        layout.setSpacing(15)
        
        # Logo/Title
        title = QLabel("⚡ NIU CAST")
        title.setFont(QFont("Segoe UI", 20, QFont.Bold))
        title.setAlignment(Qt.AlignCenter)
        title.setStyleSheet(f"""
            color: qlineargradient(x1:0, y1:0, x2:1, y2:0,
                stop:0 {GamingTheme.CYAN_PRIMARY},
                stop:1 {GamingTheme.MAGENTA_ACCENT});
            letter-spacing: 3px;
        """)
        layout.addWidget(title)
        
        # Version
        version = QLabel("v1.1.1 • Gaming Edition")
        version.setFont(QFont("Segoe UI", 9))
        version.setAlignment(Qt.AlignCenter)
        version.setStyleSheet(f"color: {GamingTheme.TEXT_MUTED};")
        layout.addWidget(version)
        
        layout.addWidget(GlowingLine(GamingTheme.CYAN_PRIMARY))
        
        # Device Connection Card
        device_card = self._create_device_card()
        layout.addWidget(device_card)
        
        # Connection Status
        status_card = self._create_status_card()
        layout.addWidget(status_card)
        
        layout.addWidget(GlowingLine(GamingTheme.CYAN_PRIMARY))
        
        # Quick Controls
        controls_label = QLabel("⚙️ QUICK CONTROLS")
        controls_label.setFont(QFont("Segoe UI", 10, QFont.Bold))
        controls_label.setStyleSheet(f"color: {GamingTheme.TEXT_SECONDARY}; letter-spacing: 2px;")
        layout.addWidget(controls_label)
        
        controls_card = self._create_quick_controls()
        layout.addWidget(controls_card)
        
        # Game Launcher
        self.btn_launcher = GamingButton("🎮 LAUNCH GAME", theme='gold')
        self.btn_launcher.clicked.connect(self._show_game_launcher)
        layout.addWidget(self.btn_launcher)
        
        layout.addStretch()
        
        # Footer
        footer = QLabel("Niumination © 2024")
        footer.setFont(QFont("Segoe UI", 8))
        footer.setAlignment(Qt.AlignCenter)
        footer.setStyleSheet(f"color: {GamingTheme.TEXT_MUTED};")
        layout.addWidget(footer)
        
        return sidebar
    
    def _create_device_card(self):
        """Device selection card"""
        card = QFrame()
        card.setStyleSheet(f"""
            QFrame {{
                background: {GamingTheme.BG_CARD};
                border: 1px solid {GamingTheme.CYAN_PRIMARY}30;
                border-radius: 8px;
                padding: 10px;
            }}
        """)
        
        layout = QVBoxLayout(card)
        layout.setSpacing(10)
        
        # Header
        header = QLabel("📱 DEVICE CONNECTION")
        header.setFont(QFont("Segoe UI", 9, QFont.Bold))
        header.setStyleSheet(f"color: {GamingTheme.CYAN_PRIMARY}; letter-spacing: 1px;")
        layout.addWidget(header)
        
        # Device dropdown
        self.device_combo = QComboBox()
        self.device_combo.setStyleSheet(f"""
            QComboBox {{
                background: {GamingTheme.BG_DARK};
                color: {GamingTheme.TEXT_PRIMARY};
                border: 1px solid {GamingTheme.CYAN_PRIMARY}50;
                border-radius: 5px;
                padding: 8px;
                font-size: 12px;
            }}
            QComboBox:hover {{
                border: 1px solid {GamingTheme.CYAN_PRIMARY};
            }}
            QComboBox::drop-down {{
                border: none;
                width: 30px;
            }}
            QComboBox QAbstractItemView {{
                background: {GamingTheme.BG_DARK};
                color: {GamingTheme.TEXT_PRIMARY};
                border: 1px solid {GamingTheme.CYAN_PRIMARY};
                selection-background-color: {GamingTheme.CYAN_PRIMARY}40;
            }}
        """)
        layout.addWidget(self.device_combo)
        
        # Buttons
        btn_layout = QHBoxLayout()
        
        self.btn_refresh = GamingButton("🔄", theme='cyan')
        self.btn_refresh.setFixedSize(40, 35)
        self.btn_refresh.clicked.connect(self._refresh_devices)
        
        self.btn_connect = GamingButton("CONNECT", theme='green')
        self.btn_connect.clicked.connect(self._connect_device)
        
        btn_layout.addWidget(self.btn_refresh)
        btn_layout.addWidget(self.btn_connect)
        
        layout.addLayout(btn_layout)
        
        return card
    
    def _create_status_card(self):
        """Connection status card"""
        card = QFrame()
        card.setStyleSheet(f"""
            QFrame {{
                background: {GamingTheme.BG_CARD};
                border: 1px solid {GamingTheme.CYAN_PRIMARY}30;
                border-radius: 8px;
                padding: 10px;
            }}
        """)
        
        layout = QVBoxLayout(card)
        layout.setSpacing(8)
        
        # Connection status
        status_layout = QHBoxLayout()
        status_layout.addWidget(QLabel("Status:"))
        self.status_indicator = StatusIndicator('disconnected')
        self.status_text = QLabel("Disconnected")
        self.status_text.setStyleSheet(f"color: {GamingTheme.STATUS_DISCONNECTED}; font-weight: bold;")
        status_layout.addWidget(self.status_indicator)
        status_layout.addWidget(self.status_text)
        status_layout.addStretch()
        layout.addLayout(status_layout)
        
        # Device info
        self.info_label = QLabel("No device info")
        self.info_label.setStyleSheet(f"color: {GamingTheme.TEXT_SECONDARY}; font-size: 10px;")
        layout.addWidget(self.info_label)
        
        # FPS counter
        fps_layout = QHBoxLayout()
        fps_layout.addWidget(QLabel("FPS:"))
        self.fps_label = QLabel("--")
        self.fps_label.setStyleSheet(f"color: {GamingTheme.CYAN_PRIMARY}; font-weight: bold; font-size: 14px;")
        fps_layout.addWidget(self.fps_label)
        fps_layout.addStretch()
        layout.addLayout(fps_layout)
        
        return card
    
    def _create_quick_controls(self):
        """Quick control buttons card"""
        card = QFrame()
        card.setStyleSheet(f"""
            QFrame {{
                background: {GamingTheme.BG_CARD};
                border: 1px solid {GamingTheme.CYAN_PRIMARY}30;
                border-radius: 8px;
                padding: 10px;
            }}
        """)
        
        layout = QVBoxLayout(card)
        layout.setSpacing(8)
        
        # Row 1: Key controls
        row1 = QHBoxLayout()
        self.btn_home = CircularButton("🏠", 40, GamingTheme.CYAN_PRIMARY)
        self.btn_back = CircularButton("⬅️", 40, GamingTheme.CYAN_PRIMARY)
        self.btn_power = CircularButton("⏻", 40, GamingTheme.MAGENTA_ACCENT)
        row1.addWidget(self.btn_home)
        row1.addWidget(self.btn_back)
        row1.addWidget(self.btn_power)
        row1.addStretch()
        layout.addLayout(row1)
        
        # Row 2: Volume controls
        row2 = QHBoxLayout()
        self.btn_vol_up = CircularButton("🔊", 40, GamingTheme.GOLD_ACCENT)
        self.btn_vol_down = CircularButton("🔉", 40, GamingTheme.GOLD_ACCENT)
        self.btn_screenshot = CircularButton("📷", 40, GamingTheme.GOLD_ACCENT)
        row2.addWidget(self.btn_vol_up)
        row2.addWidget(self.btn_vol_down)
        row2.addWidget(self.btn_screenshot)
        row2.addStretch()
        layout.addLayout(row2)
        
        return card
    
    def _create_main_content(self):
        """Create main content area with tabs"""
        content = QFrame()
        content.setStyleSheet(f"background: {GamingTheme.BG_DARK};")
        
        layout = QVBoxLayout(content)
        layout.setContentsMargins(20, 20, 20, 20)
        layout.setSpacing(15)
        
        # ===== HEADER =====
        header = self._create_header()
        layout.addWidget(header)
        
        # ===== TAB WIDGET =====
        self.tab_widget = QTabWidget()
        self.tab_widget.setStyleSheet(f"""
            QTabWidget::pane {{
                background: {GamingTheme.BG_DARK};
                border: none;
            }}
            QTabBar::tab {{
                background: {GamingTheme.BG_PANEL};
                color: {GamingTheme.TEXT_SECONDARY};
                border: 1px solid {GamingTheme.CYAN_PRIMARY}20;
                border-bottom: none;
                border-radius: 6px 6px 0 0;
                padding: 8px 18px;
                margin-right: 2px;
                font-size: 11px;
                font-weight: bold;
                letter-spacing: 1px;
            }}
            QTabBar::tab:selected {{
                background: {GamingTheme.CYAN_PRIMARY}20;
                color: {GamingTheme.CYAN_PRIMARY};
                border-color: {GamingTheme.CYAN_PRIMARY};
            }}
            QTabBar::tab:hover!selected {{
                background: {GamingTheme.CYAN_PRIMARY}10;
            }}
        """)
        
        # Tab 1: Stream / Mirror
        stream_tab = QWidget()
        stream_layout = QVBoxLayout(stream_tab)
        stream_layout.setContentsMargins(0, 15, 0, 0)
        stream_layout.setSpacing(15)
        stream_view = self._create_stream_view()
        stream_layout.addWidget(stream_view, 1)
        self.tab_widget.addTab(stream_tab, "📺 STREAM")
        
        # Tab 2: File Browser
        self.file_browser = FileBrowserWidget(self.adb)
        self.tab_widget.addTab(self.file_browser, "📁 FILES")
        
        layout.addWidget(self.tab_widget, 1)
        
        # ===== BOTTOM BAR =====
        bottom_bar = self._create_bottom_bar()
        layout.addWidget(bottom_bar)
        
        return content
    
    def _create_header(self):
        """Header with stream info"""
        header = QFrame()
        header.setFixedHeight(50)
        header.setStyleSheet(f"""
            QFrame {{
                background: {GamingTheme.BG_PANEL};
                border-radius: 8px;
                border: 1px solid {GamingTheme.CYAN_PRIMARY}30;
            }}
        """)
        
        layout = QHBoxLayout(header)
        layout.setContentsMargins(15, 0, 15, 0)
        
        # Left: Title
        title = QLabel("📺 LIVE STREAM")
        title.setFont(QFont("Segoe UI", 12, QFont.Bold))
        title.setStyleSheet(f"color: {GamingTheme.CYAN_PRIMARY}; letter-spacing: 2px;")
        layout.addWidget(title)
        
        # Center: Resolution info
        self.resolution_label = QLabel("Resolution: --")
        self.resolution_label.setStyleSheet(f"color: {GamingTheme.TEXT_SECONDARY};")
        layout.addWidget(self.resolution_label)
        
        # Right: Touch toggle
        self.touch_toggle = QCheckBox("🖱️ Touch Input")
        self.touch_toggle.setChecked(True)
        self.touch_toggle.setStyleSheet(f"""
            QCheckBox {{
                color: {GamingTheme.TEXT_PRIMARY};
                spacing: 8px;
            }}
            QCheckBox::indicator {{
                width: 18px;
                height: 18px;
                border: 2px solid {GamingTheme.CYAN_PRIMARY};
                border-radius: 4px;
                background: {GamingTheme.BG_DARK};
            }}
            QCheckBox::indicator:checked {{
                background: {GamingTheme.CYAN_PRIMARY};
            }}
        """)
        layout.addWidget(self.touch_toggle)
        
        return header
    
    def _create_stream_view(self):
        """Video stream display area"""
        container = QFrame()
        container.setStyleSheet(f"""
            QFrame {{
                background: {GamingTheme.BG_CARD};
                border: 2px solid {GamingTheme.CYAN_PRIMARY}30;
                border-radius: 10px;
            }}
        """)
        
        layout = QVBoxLayout(container)
        layout.setContentsMargins(5, 5, 5, 5)
        
        # Stream label (clickable for touch input)
        self.stream_label = QLabel()
        self.stream_label.setAlignment(Qt.AlignCenter)
        self.stream_label.setMinimumSize(400, 600)
        self.stream_label.setStyleSheet(f"""
            QLabel {{
                background: {GamingTheme.BG_DARK};
                color: {GamingTheme.TEXT_MUTED};
                border: 1px solid {GamingTheme.TEXT_MUTED}30;
                border-radius: 5px;
                font-size: 16px;
            }}
        """)
        self.stream_label.setText("\n\n\n\n📱 CONNECT TO DEVICE\nTO START STREAMING\n\n\n\n")
        
        # Enable mouse tracking for touch input
        self.stream_label.setMouseTracking(True)
        self.stream_label.mousePressEvent = self._on_stream_click
        self.stream_label.mouseMoveEvent = self._on_stream_drag_start
        self.stream_label.mouseReleaseEvent = self._on_stream_drag_end
        
        layout.addWidget(self.stream_label, 1)
        
        return container
    
    def _create_bottom_bar(self):
        """Bottom action bar"""
        bar = QFrame()
        bar.setFixedHeight(60)
        bar.setStyleSheet(f"""
            QFrame {{
                background: {GamingTheme.BG_PANEL};
                border-radius: 8px;
                border: 1px solid {GamingTheme.CYAN_PRIMARY}30;
            }}
        """)
        
        layout = QHBoxLayout(bar)
        layout.setContentsMargins(15, 0, 15, 0)
        
        # Recording button
        self.btn_record = GamingButton("⏺ REC", theme='magenta')
        self.btn_record.setIcon(QIcon())
        self.btn_record.clicked.connect(self._toggle_recording)
        
        # Install APK
        self.btn_install = GamingButton("📦 INSTALL APK", theme='gold')
        self.btn_install.clicked.connect(self._install_apk)
        
        # Wireless toggle
        self.btn_wireless = GamingButton("🔗 WIRELESS", theme='cyan')
        self.btn_wireless.clicked.connect(self._toggle_wireless)
        
        # Theme selector
        from PyQt5.QtWidgets import QComboBox
        self.theme_combo = QComboBox()
        for tid, tname in ThemeManager.list_themes():
            self.theme_combo.addItem(tname, tid)
        self.theme_combo.setFixedWidth(160)
        self.theme_combo.setStyleSheet(f"""
            QComboBox {{
                background: {GamingTheme.BG_DARK};
                color: {GamingTheme.TEXT_PRIMARY};
                border: 1px solid {GamingTheme.CYAN_PRIMARY}50;
                border-radius: 5px;
                padding: 6px 10px;
                font-family: 'Segoe UI';
                font-size: 12px;
            }}
            QComboBox::drop-down {{
                border: none;
                width: 25px;
            }}
            QComboBox QAbstractItemView {{
                background: {GamingTheme.BG_DARK};
                color: {GamingTheme.TEXT_PRIMARY};
                border: 1px solid {GamingTheme.CYAN_PRIMARY};
                selection-background-color: {GamingTheme.CYAN_PRIMARY}40;
            }}
        """)
        self.theme_combo.currentIndexChanged.connect(self._on_theme_changed)
        
        # Game Mode toggle
        self.btn_game_mode = GamingButton("🎮 GAME MODE OFF", theme='cyan')
        self.btn_game_mode.setCheckable(True)
        self.btn_game_mode.clicked.connect(self._toggle_game_mode)
        self.btn_game_mode.setFixedWidth(170)
        
        # Quit button
        self.btn_quit = GamingButton("✕ EXIT", theme='red')
        self.btn_quit.clicked.connect(self.close)
        
        layout.addWidget(self.btn_record)
        layout.addWidget(self.btn_install)
        layout.addWidget(self.btn_wireless)
        layout.addWidget(self.theme_combo)
        layout.addWidget(self.btn_game_mode)
        layout.addStretch()
        layout.addWidget(self.btn_quit)
        
        return bar
    
    def _create_status_bar(self):
        """Custom status bar"""
        self.statusBar().setStyleSheet(f"""
            QStatusBar {{
                background: {GamingTheme.BG_PANEL};
                color: {GamingTheme.TEXT_SECONDARY};
                border-top: 1px solid {GamingTheme.CYAN_PRIMARY}30;
            }}
        """)
        self.statusBar().showMessage("Ready • Select a device to connect")
    
    def _setup_connections(self):
        """Setup signal connections"""
        # Device controls
        self.btn_refresh.clicked.connect(self._refresh_devices)
        self.btn_connect.clicked.connect(self._connect_device)
        
        # Quick controls
        self.btn_home.clicked.connect(lambda: self.adb.send_keyevent('KEYCODE_HOME'))
        self.btn_back.clicked.connect(lambda: self.adb.send_keyevent('KEYCODE_BACK'))
        self.btn_power.clicked.connect(lambda: self.adb.send_keyevent('KEYCODE_POWER'))
        self.btn_vol_up.clicked.connect(lambda: self.adb.send_keyevent('KEYCODE_VOLUME_UP'))
        self.btn_vol_down.clicked.connect(lambda: self.adb.send_keyevent('KEYCODE_VOLUME_DOWN'))
        self.btn_screenshot.clicked.connect(self._take_screenshot)
        
        # Touch toggle
        self.touch_toggle.toggled.connect(self._toggle_touch)
        
        # Timer for device refresh
        self.device_timer = QTimer()
        self.device_timer.timeout.connect(self._check_devices)
        self.device_timer.start(5000)
        
        # Gaming Edition: keyboard shortcuts
        KeyboardShortcuts.register_shortcuts(self, self.adb)
    
    def _start_animations(self):
        """Start UI animations"""
        # Title pulse animation
        pass
    
    # ═══════════════════════════════════════════════════════════════════════════
    #                           EVENT HANDLERS
    # ═══════════════════════════════════════════════════════════════════════════
    
    def _refresh_devices(self):
        """Refresh device list"""
        devices = self.adb.devices()
        self.device_combo.clear()
        
        if devices:
            self.device_combo.addItems(devices)
            self.statusBar().showMessage(f"Found {len(devices)} device(s)")
        else:
            self.device_combo.addItem("No devices found")
            self.statusBar().showMessage("No devices • Enable USB debugging")
    
    def _connect_device(self):
        """Connect to selected device"""
        serial = self.device_combo.currentText()
        
        if serial == "No devices found" or not serial:
            QMessageBox.warning(self, "No Device", 
                "No device connected.\n\n"
                "Please ensure:\n"
                "1. USB debugging is enabled\n"
                "2. Device is connected via USB\n"
                "3. USB debugging is authorized")
            return
        
        if self.adb.connect(serial):
            self._on_connected()
        else:
            QMessageBox.critical(self, "Connection Failed",
                "Could not connect to device.\n"
                "Please check USB debugging authorization.")
    
    # ═══════════════════════════════════════════════════════════════════════════
    #                    GAMING EDITION METHODS
    # ═══════════════════════════════════════════════════════════════════════════
    
    def _on_theme_changed(self, index):
        """Change UI theme"""
        theme_id = self.theme_combo.itemData(index)
        if theme_id:
            self.current_theme = theme_id
            ThemeManager.apply_theme(self, theme_id)
            self.statusBar().showMessage(f"Theme: {self.theme_combo.currentText()}")
    
    def _toggle_game_mode(self, checked):
        """Toggle game mode optimizations"""
        if checked:
            self.btn_game_mode.setText("🎮 GAME MODE ON")
            self.btn_game_mode.set_theme('green')
            self.game_mode.enable()
            self.perf_monitor.start(self._update_perf_display)
            self.statusBar().showMessage("🎮 Game Mode ENABLED • Performance monitoring active")
        else:
            self.btn_game_mode.setText("🎮 GAME MODE OFF")
            self.btn_game_mode.set_theme('cyan')
            self.perf_monitor.stop()
            self.game_mode.disable()
            self._clear_perf_display()
            self.statusBar().showMessage("Game Mode DISABLED")
    
    def _update_perf_display(self, stats):
        """Update performance stats in status bar"""
        parts = []
        if 'cpu_temp' in stats:
            parts.append(f"🌡 CPU: {stats['cpu_temp']['current']:.1f}°C")
        if 'battery' in stats:
            parts.append(f"🔋 Bat: {stats['battery']['current']:.1f}°C")
        if 'memory' in stats:
            parts.append(f"💾 RAM: {stats['memory']['current']:.0f}MB")
        if parts:
            self.statusBar().showMessage(" | ".join(parts))
    
    def _clear_perf_display(self):
        """Clear performance stats"""
        self.perf_labels = {}
    
    def _launch_game(self, game_name):
        """Launch a game from the GameLauncher"""
        if not self.adb or not self.adb.device_serial:
            QMessageBox.warning(self, "Warning", "Please connect a device first.")
            return
        success = self.launcher.launch_game(game_name)
        if success:
            self.statusBar().showMessage(f"🎮 {game_name} launched!")
    
    def _show_game_launcher(self):
        """Show game launcher dialog"""
        from PyQt5.QtWidgets import QDialog, QVBoxLayout, QPushButton, QLabel, QScrollArea
        
        dialog = QDialog(self)
        dialog.setWindowTitle("🎮 Game Launcher")
        dialog.setGeometry(200, 200, 400, 500)
        dialog.setStyleSheet(f"""
            QDialog {{ background: {GamingTheme.BG_DARK}; color: {GamingTheme.TEXT_PRIMARY}; }}
            QPushButton {{
                background: {GamingTheme.BG_CARD};
                color: {GamingTheme.TEXT_PRIMARY};
                border: 1px solid {GamingTheme.CYAN_PRIMARY}50;
                border-radius: 5px;
                padding: 10px;
                font-size: 14px;
                text-align: left;
            }}
            QPushButton:hover {{
                border: 1px solid {GamingTheme.CYAN_PRIMARY};
                background: {GamingTheme.CYAN_PRIMARY}20;
            }}
        """)
        
        layout = QVBoxLayout(dialog)
        
        title = QLabel("🎮 Select a Game to Launch")
        title.setStyleSheet(f"font-size: 16px; font-weight: bold; color: {GamingTheme.CYAN_PRIMARY}; padding: 10px;")
        layout.addWidget(title)
        
        scroll = QScrollArea()
        scroll.setWidgetResizable(True)
        scroll_widget = QWidget()
        scroll_layout = QVBoxLayout(scroll_widget)
        
        # Add installed games first, then all games
        installed = self.launcher.search_installed_games()
        added = set()
        
        if installed:
            installed_label = QLabel("📱 Installed Games")
            installed_label.setStyleSheet(f"color: {GamingTheme.GOLD_ACCENT}; padding: 5px;")
            scroll_layout.addWidget(installed_label)
            for game, pkg in installed:
                btn = QPushButton(f"  {game}")
                btn.clicked.connect(lambda checked, g=game: (self._launch_game(g), dialog.close()))
                scroll_layout.addWidget(btn)
                added.add(game)
        
        all_label = QLabel("\n📋 All Games")
        all_label.setStyleSheet(f"color: {GamingTheme.TEXT_MUTED}; padding: 5px;")
        scroll_layout.addWidget(all_label)
        
        for game, pkg in GameLauncher.GAMES.items():
            if game not in added:
                btn = QPushButton(f"  {game}")
                btn.clicked.connect(lambda checked, g=game: (self._launch_game(g), dialog.close()))
                scroll_layout.addWidget(btn)
        
        scroll_layout.addStretch()
        scroll.setWidget(scroll_widget)
        layout.addWidget(scroll)
        
        close_btn = QPushButton("✕ Close")
        close_btn.setStyleSheet(f"""
            QPushButton {{
                background: {GamingTheme.STATUS_DISCONNECTED}40;
                color: {GamingTheme.TEXT_PRIMARY};
                border: 1px solid {GamingTheme.STATUS_DISCONNECTED};
                border-radius: 5px;
                padding: 8px;
            }}
        """)
        close_btn.clicked.connect(dialog.close)
        layout.addWidget(close_btn)
        
        dialog.exec_()
    
    def _on_connected(self):
        """Handle successful connection"""
        # Update status
        self.status_indicator.status = 'connected'
        self.status_indicator.update_color()
        self.status_text.setText("Connected")
        self.status_text.setStyleSheet(f"color: {GamingTheme.STATUS_CONNECTED}; font-weight: bold;")
        
        # Start performance monitoring if game mode already on
        if hasattr(self, 'perf_monitor') and self.btn_game_mode.isChecked():
            self.perf_monitor.start(self._update_perf_display)
        
        # Get device info
        info = self.adb.get_device_info()
        info_text = f"{info['manufacturer']} {info['model']}\nAndroid {info['android']}"
        if 'ip' in info:
            info_text += f" • IP: {info['ip']}"
        self.info_label.setText(info_text)
        
        # Update resolution label
        self.resolution_label.setText(f"Resolution: {info['width']}x{info['height']}")
        
        # Create touch handler
        self.touch_handler = TouchInputHandler(self.adb, self.stream_label)
        self.touch_handler.set_device_resolution(info['width'], info['height'])
        
        # Start video stream
        self._start_stream()
        
        # Update status bar
        self.statusBar().showMessage(f"Connected to {info['model']} • Streaming...")
        
        # Update button
        self.btn_connect.setText("DISCONNECT")
        self.btn_connect.setStyleSheet("""
            QPushButton {
                background: qlineargradient(x1:0, y1:0, x2:1, y2:0,
                    stop:0 #FF4444, stop:1 #AA0000);
                color: white;
                border: 1px solid #FF4444;
                border-radius: 5px;
                padding: 8px 20px;
                font-weight: bold;
            }
            QPushButton:hover {
                background: qlineargradient(x1:0, y1:0, x2:1, y2:0,
                    stop:0 #FF6666, stop:1 #CC0000);
            }
        """)
        self.btn_connect.clicked.disconnect()
        self.btn_connect.clicked.connect(self._disconnect_device)
    
    def _disconnect_device(self):
        """Disconnect from device"""
        if self.stream_thread:
            self.stream_thread.stop()
        
        # Stop performance monitoring
        if hasattr(self, 'perf_monitor'):
            self.perf_monitor.stop()
        if hasattr(self, 'game_mode'):
            self.game_mode.disable()
        self._clear_perf_display()
        self.stream_thread = None
        
        self.adb.device_serial = None
        
        # Reset UI
        self.status_indicator.status = 'disconnected'
        self.status_indicator.update_color()
        self.status_text.setText("Disconnected")
        self.status_text.setStyleSheet(f"color: {GamingTheme.STATUS_DISCONNECTED}; font-weight: bold;")
        self.info_label.setText("No device info")
        self.resolution_label.setText("Resolution: --")
        self.fps_label.setText("--")
        self.stream_label.setText("\n\n\n\n📱 CONNECT TO DEVICE\nTO START STREAMING\n\n\n\n")
        
        self.statusBar().showMessage("Disconnected")
        
        # Reset button
        self.btn_connect.setText("CONNECT")
        self.btn_connect.setStyleSheet("""
            QPushButton {
                background: qlineargradient(x1:0, y1:0, x2:1, y2:0,
                    stop:0 #00FF88, stop:1 #00AA55);
                color: white;
                border: 1px solid #00FF88;
                border-radius: 5px;
                padding: 8px 20px;
                font-weight: bold;
            }
            QPushButton:hover {
                background: qlineargradient(x1:0, y1:0, x2:1, y2:0,
                    stop:0 #33FF99, stop:1 #00CC66);
            }
        """)
        self.btn_connect.clicked.disconnect()
        self.btn_connect.clicked.connect(self._connect_device)
    
    def _start_stream(self):
        """Start video streaming"""
        if self.stream_thread:
            self.stream_thread.stop()
        
        self.stream_thread = VideoStreamThread(self.adb)
        self.stream_thread.frame_ready.connect(self._display_frame)
        self.stream_thread.error_occurred.connect(self._handle_stream_error)
        self.stream_thread.fps_updated.connect(self._update_fps)
        self.stream_thread.start()
        
        # Update status
        self.status_indicator.status = 'syncing'
    
    def _display_frame(self, frame):
        """Display video frame"""
        # Resize for display while maintaining aspect ratio
        display_h, display_w = self.stream_label.height(), self.stream_label.width()
        
        if display_w > 0 and display_h > 0:
            scale = min(display_w / frame.shape[1], display_h / frame.shape[0])
            new_w = int(frame.shape[1] * scale)
            new_h = int(frame.shape[0] * scale)
            
            display_frame = cv2.resize(frame, (new_w, new_h))
        else:
            display_frame = cv2.resize(frame, (540, 960))
        
        # Convert to RGB and then to QPixmap
        rgb_frame = cv2.cvtColor(display_frame, cv2.COLOR_BGR2RGB)
        h, w, ch = rgb_frame.shape
        bytes_per_line = ch * w
        qt_image = QImage(rgb_frame.data, w, h, bytes_per_line, QImage.Format_RGB888)
        
        # Set pixmap
        pixmap = QPixmap.fromImage(qt_image)
        self.stream_label.setPixmap(pixmap)
        
        # Record if active
        if self.recording and self.record_writer:
            self.record_writer.write(frame)
    
    def _handle_stream_error(self, error):
        """Handle stream errors"""
        self.statusBar().showMessage(f"Stream error: {error}")
    
    def _update_fps(self, fps):
        """Update FPS display"""
        color = GamingTheme.STATUS_CONNECTED if fps > 20 else GamingTheme.STATUS_WARNING
        self.fps_label.setText(f"{fps:.1f}")
        self.fps_label.setStyleSheet(f"color: {color}; font-weight: bold; font-size: 14px;")
    
    def _on_stream_click(self, event):
        """Handle click on stream for touch input"""
        if self.touch_handler and self.touch_toggle.isChecked():
            self.touch_handler.handle_click(event)
    
    def _on_stream_drag_start(self, event):
        """Handle drag start"""
        if event.buttons() & Qt.LeftButton:
            self.drag_start = event.pos()
    
    def _on_stream_drag_end(self, event):
        """Handle drag end for swipe gesture"""
        if self.drag_start and self.touch_handler and self.touch_toggle.isChecked():
            self.touch_handler.handle_drag(self.drag_start, event.pos())
        self.drag_start = None
    
    def _toggle_touch(self, checked):
        """Toggle touch input"""
        if self.touch_handler:
            self.touch_handler.enabled = checked
    
    def _toggle_recording(self):
        """Toggle screen recording"""
        if not self.adb.device_serial:
            QMessageBox.warning(self, "No Device", "Please connect a device first")
            return
        
        if not self.recording:
            # Start recording
            timestamp = datetime.now().strftime("%Y%m%d_%H%M%S")
            self.record_path = os.path.expanduser(f"~/Videos/niu_record_{timestamp}.mp4")
            
            os.makedirs(os.path.expanduser("~/Videos"), exist_ok=True)
            
            info = self.adb.get_device_info()
            fourcc = cv2.VideoWriter_fourcc(*'mp4v')
            self.record_writer = cv2.VideoWriter(self.record_path, fourcc, 30.0, (info['width'], info['height']))
            
            self.recording = True
            self.btn_record.setText("⏹ STOP")
            self.statusBar().showMessage(f"Recording... {self.record_path}")
        else:
            # Stop recording
            self.recording = False
            if self.record_writer:
                self.record_writer.release()
                self.record_writer = None
            
            self.btn_record.setText("⏺ REC")
            self.statusBar().showMessage(f"Recording saved: {self.record_path}")
            QMessageBox.information(self, "Recording Complete", f"Video saved to:\n{self.record_path}")
    
    def _take_screenshot(self):
        """Take screenshot"""
        if not self.adb.device_serial:
            QMessageBox.warning(self, "No Device", "Please connect a device first")
            return
        
        timestamp = datetime.now().strftime("%Y%m%d_%H%M%S")
        path = os.path.expanduser(f"~/Pictures/niu_screenshot_{timestamp}.png")
        
        os.makedirs(os.path.expanduser("~/Pictures"), exist_ok=True)
        
        self.adb.shell('screencap -p /sdcard/.niu_screenshot.png', timeout=5)
        
        if self.adb.pull('/sdcard/.niu_screenshot.png', path):
            self.statusBar().showMessage(f"Screenshot saved: {path}")
            QMessageBox.information(self, "Screenshot", f"Saved to:\n{path}")
        else:
            QMessageBox.critical(self, "Error", "Failed to capture screenshot")
    
    def _install_apk(self):
        """Install APK file"""
        if not self.adb.device_serial:
            QMessageBox.warning(self, "No Device", "Please connect a device first")
            return
        
        file_path, _ = QFileDialog.getOpenFileName(
            self, "Select APK", "", "APK Files (*.apk)"
        )
        
        if file_path:
            self.statusBar().showMessage(f"Installing {os.path.basename(file_path)}...")
            
            rc, out, err = self.adb._run([
                '-s', self.adb.device_serial, 'install', '-r', file_path
            ], timeout=300)
            
            if rc == 0:
                self.statusBar().showMessage("Installation complete!")
                QMessageBox.information(self, "Success", "APK installed successfully!")
            else:
                self.statusBar().showMessage("Installation failed")
                QMessageBox.critical(self, "Error", f"Installation failed:\n{err}")
    
    def _toggle_wireless(self):
        """Toggle wireless connection"""
        if not self.adb.device_serial:
            QMessageBox.warning(self, "No Device", "Please connect via USB first")
            return
        
        # Get device IP
        info = self.adb.get_device_info()
        
        if 'ip' not in info or not info['ip']:
            QMessageBox.warning(self, "No WiFi", 
                "Could not detect WiFi IP.\n"
                "Please connect device to WiFi first.")
            return
        
        # Enable wireless
        self.statusBar().showMessage(f"Enabling ADB over WiFi on {info['ip']}...")
        
        if self.adb.enable_wireless():
            self.statusBar().showMessage(f"Wireless enabled! Connect: adb connect {info['ip']}:5555")
            QMessageBox.information(self, "Wireless Enabled", 
                f"ADB over WiFi enabled!\n\n"
                f"Connect with:\n"
                f"  adb connect {info['ip']}:5555")
        else:
            QMessageBox.critical(self, "Error", "Failed to enable wireless ADB")
    
    def _check_devices(self):
        """Periodically check device connection"""
        if not self.adb.device_serial:
            self._refresh_devices()
    
    def closeEvent(self, event):
        """Cleanup on close"""
        if self.stream_thread:
            self.stream_thread.stop()
        if self.recording and self.record_writer:
            self.record_writer.release()
        
        # Gaming Edition cleanup
        if hasattr(self, 'perf_monitor'):
            self.perf_monitor.stop()
        if hasattr(self, 'game_mode'):
            self.game_mode.disable()
        
        event.accept()


# ═══════════════════════════════════════════════════════════════════════════════
#                              ENTRY POINT
# ═══════════════════════════════════════════════════════════════════════════════

def main():
    """Entry point: launch GUI or show help"""
    import argparse
    parser = argparse.ArgumentParser(
        description='NIU CAST Gaming Edition - Android ADB Tool & Screen Mirroring',
        epilog=f"""
Examples:
  niu-cast                    Launch GUI
  niu-cast --help             Show this help
  niu-mini --info             CLI version for device info
  niu-batch script.yml        Batch executor
        """
    )
    parser.add_argument('--version', action='store_true', help='Show version')
    args, _ = parser.parse_known_args()
    
    if args.version:
        from . import __version__
        print(f"NIU CAST v{__version__} • Gaming Edition")
        return 0
    
    if not PYQT5_AVAILABLE:
        print("ERROR: PyQt5 is required. Install with: pip install PyQt5")
        return 1
    
    app = QApplication(sys.argv)
    app.setApplicationName("NiuCast")
    app.setApplicationVersion("1.1.1")
    
    # Apply dark theme
    app.setStyle('Fusion')
    
    window = NiuCastWindow()
    window.show()
    
    return app.exec_()


if __name__ == '__main__':
    sys.exit(main())