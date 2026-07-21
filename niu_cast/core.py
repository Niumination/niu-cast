#! /usr/bin/env python3
"""
NIU CAST — Core GUI
Ultra-minimal modern interface dengan interactive screen mirror + touch control.
"""

import sys
import os
import subprocess
import tempfile
from datetime import datetime

from PyQt5.QtWidgets import (
    QApplication, QMainWindow, QWidget, QVBoxLayout, QHBoxLayout,
    QPushButton, QLabel, QComboBox, QMessageBox, QFrame, QTabWidget,
    QStatusBar, QCheckBox
)
from PyQt5.QtCore import Qt, QTimer
from PyQt5.QtGui import QFont, QPixmap, QImage, QMouseEvent, QPainter, QColor, QPen

from . import __version__
from .adb_controller import ADBController
from .app_manager import AppManagerWidget
from .file_browser import FileBrowserWidget
from .mac_connect_bridge import MacConnectBridge

# ── Palette (Catppuccin Mocha inspired) ─────────────────────────────────────────

BG = "#11111B"
SURFACE = "#1E1E2E"
OVERLAY = "#313244"
TEXT = "#CDD6F4"
SUB = "#A6ADC8"
BLUE = "#89B4FA"
GREEN = "#A6E3A1"
RED = "#F38BA8"
DIM = "#45475A"
BORDER = "#313244"

STYLESHEET = f"""
QMainWindow, QWidget {{
    background: {BG};
    color: {TEXT};
    font-family: '.AppleSystemUIFont', 'Helvetica Neue', sans-serif;
    font-size: 12px;
}}
QLabel {{
    background: transparent;
    color: {TEXT};
}}
QPushButton {{
    background: {OVERLAY};
    color: {TEXT};
    border: 1px solid {DIM};
    border-radius: 6px;
    padding: 6px 14px;
    font-size: 11px;
    font-weight: 500;
}}
QPushButton:hover {{
    background: {DIM};
    border-color: {BLUE};
}}
QPushButton:pressed {{
    background: {BLUE}30;
}}
QPushButton:disabled {{
    color: {SUB};
    background: {OVERLAY};
}}
QPushButton#primary {{
    background: {BLUE};
    color: {BG};
    border: none;
    font-weight: bold;
}}
QPushButton#primary:hover {{
    background: {BLUE}DD;
}}
QPushButton#danger {{
    color: {RED};
    border-color: {RED}40;
}}
QPushButton#danger:hover {{
    background: {RED}20;
    border-color: {RED};
}}
QComboBox {{
    background: {OVERLAY};
    color: {TEXT};
    border: 1px solid {DIM};
    border-radius: 6px;
    padding: 5px 8px;
    min-width: 160px;
}}
QComboBox::drop-down {{ border: none; width: 20px; }}
QComboBox QAbstractItemView {{
    background: {OVERLAY};
    color: {TEXT};
    selection-background-color: {BLUE}40;
    border-radius: 4px;
}}
QTabWidget::pane {{ background: transparent; border: none; }}
QTabBar::tab {{
    background: transparent;
    color: {SUB};
    border: none;
    border-bottom: 2px solid transparent;
    padding: 6px 14px;
    font-size: 11px;
    font-weight: 500;
    text-transform: uppercase;
}}
QTabBar::tab:selected {{
    color: {BLUE};
    border-bottom-color: {BLUE};
}}
QTabBar::tab:hover!selected {{
    color: {TEXT};
}}
QTreeWidget {{
    background: {BG};
    color: {TEXT};
    border: 1px solid {BORDER};
    border-radius: 6px;
    alternate-background-color: {SURFACE};
}}
QTreeWidget::item:selected {{
    background: {BLUE}20;
    color: {BLUE};
}}
QHeaderView::section {{
    background: transparent;
    color: {SUB};
    border: none;
    border-bottom: 1px solid {BORDER};
    padding: 4px;
    font-weight: 600;
}}
QStatusBar {{
    background: {SURFACE};
    color: {SUB};
    border-top: 1px solid {BORDER};
    font-size: 10px;
}}
QCheckBox {{
    spacing: 6px;
    color: {SUB};
}}
QCheckBox::indicator {{
    width: 14px;
    height: 14px;
    border-radius: 3px;
    border: 1px solid {DIM};
    background: {OVERLAY};
}}
QCheckBox::indicator:checked {{
    background: {BLUE};
    border-color: {BLUE};
}}
QLineEdit {{
    background: {SURFACE};
    color: {TEXT};
    border: 1px solid {BORDER};
    border-radius: 6px;
    padding: 5px 8px;
}}
"""


class NiuCastWindow(QMainWindow):
    """Main window"""

    def __init__(self):
        super().__init__()
        self.adb = ADBController()
        self.setWindowTitle("NIU CAST")
        self.setGeometry(200, 100, 1100, 780)
        self.setMinimumSize(860, 560)
        self.setStyleSheet(STYLESHEET)

        self._streaming = False
        self._stream_timer = QTimer()
        self._stream_timer.timeout.connect(self._capture_frame)

        # Device resolution for touch mapping
        self._dev_w = 0
        self._dev_h = 0

        self._setup_ui()
        self._setup_check()

    # ── UI ─────────────────────────────────────────────────────────────────────

    def _setup_ui(self):
        central = QWidget()
        self.setCentralWidget(central)
        root = QVBoxLayout(central)
        root.setContentsMargins(0, 0, 0, 0)
        root.setSpacing(0)

        # ── Top bar ──
        top = QFrame()
        top.setObjectName("topbar")
        top.setStyleSheet(f"QFrame#topbar {{ background: {SURFACE}; border-bottom: 1px solid {BORDER}; }}")
        bar = QHBoxLayout(top)
        bar.setContentsMargins(16, 8, 16, 8)
        bar.setSpacing(10)

        title = QLabel("NIU CAST")
        title.setStyleSheet(f"font-size: 15px; font-weight: 700; color: {TEXT}; letter-spacing: 1px;")
        bar.addWidget(title)

        # Status dot
        self.dot = QLabel("○")
        self.dot.setStyleSheet(f"color: {DIM}; font-size: 10px;")
        bar.addWidget(self.dot)

        bar.addStretch()

        self.device_combo = QComboBox()
        self.device_combo.setMinimumWidth(180)
        bar.addWidget(self.device_combo)

        self.btn_refresh = QPushButton("↻")
        self.btn_refresh.setFixedSize(30, 28)
        self.btn_refresh.setToolTip("Refresh devices")
        self.btn_refresh.clicked.connect(self._refresh_devices)
        bar.addWidget(self.btn_refresh)

        self.btn_connect = QPushButton("Connect")
        self.btn_connect.setObjectName("primary")
        self.btn_connect.setFixedWidth(90)
        self.btn_connect.clicked.connect(self._connect_device)
        bar.addWidget(self.btn_connect)

        self.btn_disconnect = QPushButton("Disconnect")
        self.btn_disconnect.setObjectName("danger")
        self.btn_disconnect.setFixedWidth(90)
        self.btn_disconnect.setVisible(False)
        self.btn_disconnect.clicked.connect(self._disconnect_device)
        bar.addWidget(self.btn_disconnect)

        root.addWidget(top)

        # ── Info bar (thin, only visible when connected) ──
        self.info_bar = QFrame()
        self.info_bar.setObjectName("info")
        self.info_bar.setStyleSheet(f"QFrame#info {{ background: {SURFACE}; border-bottom: 1px solid {BORDER}; }}")
        self.info_bar.setVisible(False)
        info_layout = QHBoxLayout(self.info_bar)
        info_layout.setContentsMargins(16, 4, 16, 4)
        info_layout.setSpacing(16)
        self.lbl_model = QLabel("")
        self.lbl_model.setStyleSheet(f"color: {TEXT}; font-weight: 500; font-size: 11px;")
        info_layout.addWidget(self.lbl_model)
        self.lbl_detail = QLabel("")
        self.lbl_detail.setStyleSheet(f"color: {SUB}; font-size: 11px;")
        info_layout.addWidget(self.lbl_detail)
        info_layout.addStretch()
        self.lbl_res = QLabel("")
        self.lbl_res.setStyleSheet(f"color: {DIM}; font-size: 10px;")
        info_layout.addWidget(self.lbl_res)
        root.addWidget(self.info_bar)

        # ── Content ──
        self.tabs = QTabWidget()
        self.tabs.setDocumentMode(True)

        # ── Tab 1: Screen ──
        screen_tab = QWidget()
        screen_layout = QVBoxLayout(screen_tab)
        screen_layout.setContentsMargins(12, 8, 12, 8)
        screen_layout.setSpacing(8)

        controls = QHBoxLayout()
        controls.setSpacing(8)

        self.btn_mirror = QPushButton("Live Mirror")
        self.btn_mirror.setObjectName("primary")
        self.btn_mirror.setCheckable(True)
        self.btn_mirror.clicked.connect(self._toggle_mirror)
        controls.addWidget(self.btn_mirror)

        self.btn_shot = QPushButton("Screenshot")
        self.btn_shot.clicked.connect(self._take_screenshot)
        controls.addWidget(self.btn_shot)

        controls.addStretch()
        self.lbl_fps = QLabel("")
        self.lbl_fps.setStyleSheet(f"color: {DIM}; font-size: 10px;")
        controls.addWidget(self.lbl_fps)
        screen_layout.addLayout(controls)

        self.screen = QLabel()
        self.screen.setAlignment(Qt.AlignCenter)
        self.screen.setStyleSheet(f"""
            background: {SURFACE};
            border: 1px solid {BORDER};
            border-radius: 8px;
        """)
        self.screen.setMinimumHeight(400)
        self.screen.mousePressEvent = self._on_screen_click
        self.screen.mouseMoveEvent = self._on_screen_drag
        self.screen.mouseReleaseEvent = self._on_screen_release
        self.screen.setMouseTracking(True)
        screen_layout.addWidget(self.screen, 1)

        self.tabs.addTab(screen_tab, "Screen")

        # ── Tab 2: Files ──
        files_tab = QWidget()
        files_layout = QVBoxLayout(files_tab)
        files_layout.setContentsMargins(12, 8, 12, 8)
        self.file_browser = FileBrowserWidget(self.adb)
        files_layout.addWidget(self.file_browser)
        self.tabs.addTab(files_tab, "Files")

        # ── Tab 3: Apps ──
        self.app_manager = AppManagerWidget(self.adb)
        self.tabs.addTab(self.app_manager, "Apps")

        # ── Tab 4: Mac Connect ──
        mac_tab = QWidget()
        mac_layout = QVBoxLayout(mac_tab)
        mac_layout.setContentsMargins(16, 12, 16, 12)
        mac_layout.setSpacing(10)

        # Header
        mac_title = QLabel("Mac Connect — ADB Wireless + scrcpy")
        mac_title.setStyleSheet(f"font-size: 14px; font-weight: 700; color: {TEXT};")
        mac_layout.addWidget(mac_title)

        mac_desc = QLabel(
            "Hubungkan Infinix GT 30 Pro via ADB Wireless. "
            "Metode ini TERBUKTI bekerja.\n"
            "Pertama: Setup via USB sekali. Selanjutnya: Connect Wireless + Mirror."
        )
        mac_desc.setStyleSheet(f"color: {SUB}; font-size: 11px;")
        mac_desc.setWordWrap(True)
        mac_layout.addWidget(mac_desc)

        # Status frame
        mac_status_frame = QFrame()
        mac_status_frame.setObjectName("mac_status")
        mac_status_frame.setStyleSheet(
            f"QFrame#mac_status {{ background: {SURFACE}; "
            f"border: 1px solid {BORDER}; border-radius: 8px; }}"
        )
        mac_status_layout = QVBoxLayout(mac_status_frame)
        mac_status_layout.setContentsMargins(12, 8, 12, 8)
        mac_status_layout.setSpacing(4)

        self.mac_lbl_status = QLabel("○ Not connected")
        self.mac_lbl_status.setStyleSheet(f"color: {DIM}; font-size: 12px; font-weight: 600;")
        mac_status_layout.addWidget(self.mac_lbl_status)

        self.mac_lbl_ip = QLabel("IP: -")
        self.mac_lbl_ip.setStyleSheet(f"color: {SUB}; font-size: 11px;")
        mac_status_layout.addWidget(self.mac_lbl_ip)

        self.mac_lbl_device = QLabel("Device: -")
        self.mac_lbl_device.setStyleSheet(f"color: {SUB}; font-size: 11px;")
        mac_status_layout.addWidget(self.mac_lbl_device)

        self.mac_lbl_profile = QLabel("Profile: High (120 FPS)")
        self.mac_lbl_profile.setStyleSheet(f"color: {SUB}; font-size: 11px;")
        mac_status_layout.addWidget(self.mac_lbl_profile)

        self.mac_lbl_audio = QLabel("Audio: Enabled")
        self.mac_lbl_audio.setStyleSheet(f"color: {SUB}; font-size: 11px;")
        mac_status_layout.addWidget(self.mac_lbl_audio)

        mac_layout.addWidget(mac_status_frame)

        # Action buttons
        mac_actions = QHBoxLayout()
        mac_actions.setSpacing(8)

        self.mac_btn_setup = QPushButton("❶ Setup via USB")
        self.mac_btn_setup.setObjectName("primary")
        self.mac_btn_setup.setToolTip("USB → adb tcpip 5555 (perlu kabel, sekali saja)")
        self.mac_btn_setup.clicked.connect(self._mac_setup)
        mac_actions.addWidget(self.mac_btn_setup)

        self.mac_btn_connect = QPushButton("❷ Connect Wireless")
        self.mac_btn_connect.setToolTip("ARP scan + ADB connect")
        self.mac_btn_connect.clicked.connect(self._mac_connect)
        mac_actions.addWidget(self.mac_btn_connect)

        self.mac_btn_mirror = QPushButton("❸ Mirror + Audio")
        self.mac_btn_mirror.setToolTip("Jalankan scrcpy dengan profile terpilih")
        self.mac_btn_mirror.clicked.connect(self._mac_mirror)
        mac_actions.addWidget(self.mac_btn_mirror)

        self.mac_btn_disconnect = QPushButton("Disconnect")
        self.mac_btn_disconnect.setObjectName("danger")
        self.mac_btn_disconnect.clicked.connect(self._mac_disconnect)
        mac_actions.addWidget(self.mac_btn_disconnect)

        mac_layout.addLayout(mac_actions)

        # Settings
        mac_settings = QHBoxLayout()
        mac_settings.setSpacing(8)

        self.mac_btn_profile = QPushButton("Profile: High")
        self.mac_btn_profile.setToolTip("Cycle: High (120fps) → Normal (60fps) → Eco (30fps)")
        self.mac_btn_profile.clicked.connect(self._mac_cycle_profile)
        mac_settings.addWidget(self.mac_btn_profile)

        self.mac_btn_audio = QPushButton("Audio: ON")
        self.mac_btn_audio.setToolTip("Toggle audio forwarding")
        self.mac_btn_audio.clicked.connect(self._mac_toggle_audio)
        mac_settings.addWidget(self.mac_btn_audio)

        self.mac_btn_refresh = QPushButton("↻ Refresh Status")
        self.mac_btn_refresh.clicked.connect(self._mac_refresh)
        mac_settings.addWidget(self.mac_btn_refresh)

        mac_settings.addStretch()
        mac_layout.addLayout(mac_settings)

        mac_layout.addStretch()
        self.tabs.addTab(mac_tab, "Mac Connect")

        self._mac_bridge = MacConnectBridge()
        self._mac_refresh()

        root.addWidget(self.tabs, 1)

        # ── Status bar ──
        self.sb = QStatusBar()
        self.sb.showMessage("Ready")
        self.setStatusBar(self.sb)

    def _setup_check(self):
        self._refresh_devices()
        self._check_timer = QTimer()
        self._check_timer.timeout.connect(self._check_loop)
        self._check_timer.start(3000)

    # ── Device ──────────────────────────────────────────────────────────────────

    def _refresh_devices(self):
        self.device_combo.clear()
        devices = self.adb.devices()
        if devices:
            self.device_combo.addItems(devices)
            self.sb.showMessage(f"{len(devices)} device(s) found")
        else:
            self.device_combo.addItem("No devices")
            self.sb.showMessage("No devices — enable USB debugging")

    def _connect_device(self):
        serial = self.device_combo.currentText()
        if not serial or serial == "No devices":
            QMessageBox.warning(self, "No Device",
                "No device detected.\nEnable USB Debugging and connect via USB.")
            return
        if self.adb.connect(serial):
            self._on_connected()
        else:
            QMessageBox.critical(self, "Error", "Failed to connect")

    def _on_connected(self):
        info = self.adb.get_device_info()
        self._dev_w = info.get('width', 1080)
        self._dev_h = info.get('height', 2400)
        self.dot.setStyleSheet(f"color: {GREEN}; font-size: 10px;")
        self.dot.setText("●")
        self.lbl_model.setText(f"{info.get('manufacturer', '?')} {info.get('model', '?')}")
        parts = [f"Android {info.get('android', '?')}"]
        if 'ip' in info:
            parts.append(f"WiFi {info['ip']}")
        self.lbl_detail.setText(" • ".join(parts))
        self.lbl_res.setText(f"{info.get('width', '?')}×{info.get('height', '?')}")
        self.info_bar.setVisible(True)
        self.btn_connect.setVisible(False)
        self.btn_disconnect.setVisible(True)
        self.dot.setToolTip(f"Connected: {self.adb.device_serial}")
        self.sb.showMessage(f"Connected: {self.adb.device_serial}")
        self.app_manager.refresh()

    def _disconnect_device(self):
        self.adb.disconnect()
        self.dot.setStyleSheet(f"color: {DIM}; font-size: 10px;")
        self.dot.setText("○")
        self.info_bar.setVisible(False)
        self.btn_connect.setVisible(True)
        self.btn_disconnect.setVisible(False)
        if self._streaming:
            self._toggle_mirror()
        self.app_manager.list.clear()
        self.app_manager.lbl_count.setText("No device connected")
        self.sb.showMessage("Disconnected")

    def _check_loop(self):
        if self.adb.device_serial:
            rc, _, _ = self.adb._run(['-s', self.adb.device_serial, 'get-state'], timeout=5)
            if rc != 0:
                self._disconnect_device()

    # ── Live Mirror ─────────────────────────────────────────────────────────────

    def _toggle_mirror(self):
        if not self.adb.device_serial:
            self.btn_mirror.setChecked(False)
            QMessageBox.warning(self, "No Device", "Connect a device first")
            return
        self._streaming = not self._streaming
        if self._streaming:
            self.btn_mirror.setText("■ Stop")
            self.btn_mirror.setObjectName("danger")
            self.btn_mirror.setStyleSheet("")
            self._frame_count = 0
            self._frame_time = datetime.now()
            self._capture_frame()
            self._stream_timer.start(500)  # 2 FPS — smooth enough for basic interaction
            self.sb.showMessage("Live mirror started")
        else:
            self._stream_timer.stop()
            self.btn_mirror.setText("Live Mirror")
            self.btn_mirror.setObjectName("primary")
            self.btn_mirror.setStyleSheet("")
            self.lbl_fps.setText("")
            self.sb.showMessage("Mirror stopped")

    def _capture_frame(self):
        if not self.adb.device_serial or not self._streaming:
            return
        tmp = os.path.join(tempfile.gettempdir(), "niu_frame.png")
        if self.adb.screencap(tmp):
            pix = QPixmap(tmp)
            if not pix.isNull():
                scaled = pix.scaled(
                    self.screen.width() - 4,
                    self.screen.height() - 4,
                    Qt.KeepAspectRatio,
                    Qt.SmoothTransformation,
                )
                self.screen.setPixmap(scaled)
                self._frame_count += 1
                now = datetime.now()
                dt = (now - self._frame_time).total_seconds()
                if dt >= 2:
                    fps = self._frame_count / dt
                    self.lbl_fps.setText(f"{fps:.1f} fps")
                    self._frame_count = 0
                    self._frame_time = now

    # ── Touch / Mouse Control ──────────────────────────────────────────────────

    def _map_coord(self, x, y):
        """Map screen click coordinates to device coordinates"""
        pix = self.screen.pixmap()
        if not pix:
            return x, y
        # pixmap may be smaller than label (aspect ratio preserved)
        pw = pix.width()
        ph = pix.height()
        lw = self.screen.width()
        lh = self.screen.height()
        # Centered within label
        offset_x = (lw - pw) // 2
        offset_y = (lh - ph) // 2
        img_x = x - offset_x
        img_y = y - offset_y
        if img_x < 0 or img_y < 0 or img_x > pw or img_y > ph:
            return None, None
        # Scale to device resolution
        dev_x = int(img_x * self._dev_w / pw)
        dev_y = int(img_y * self._dev_h / ph)
        return dev_x, dev_y

    def _on_screen_click(self, event: QMouseEvent):
        if not self.adb.device_serial:
            return
        x, y = self._map_coord(event.x(), event.y())
        if x is not None:
            self.adb.send_tap(x, y)
            self.sb.showMessage(f"Tap at ({x}, {y})")
            self._drag_origin = (x, y)

    def _on_screen_drag(self, event: QMouseEvent):
        if hasattr(self, '_drag_origin') and self._drag_origin:
            x, y = self._map_coord(event.x(), event.y())
            if x is not None:
                self._drag_current = (x, y)

    def _on_screen_release(self, event: QMouseEvent):
        if hasattr(self, '_drag_origin') and self._drag_origin and hasattr(self, '_drag_current') and self._drag_current:
            x1, y1 = self._drag_origin
            x2, y2 = self._drag_current
            if abs(x2 - x1) > 10 or abs(y2 - y1) > 10:
                self.adb.send_swipe(x1, y1, x2, y2)
                self.sb.showMessage(f"Swipe ({x1},{y1}) → ({x2},{y2})")
        self._drag_origin = None
        self._drag_current = None

    # ── Screenshot ─────────────────────────────────────────────────────────────

    def _take_screenshot(self):
        if not self.adb.device_serial:
            QMessageBox.warning(self, "No Device", "Connect a device first")
            return
        save = os.path.expanduser("~/Pictures")
        os.makedirs(save, exist_ok=True)
        ts = datetime.now().strftime("%Y%m%d_%H%M%S")
        path = os.path.join(save, f"niu_{ts}.png")
        if self.adb.screencap(path):
            self.sb.showMessage(f"Screenshot → {path}")
            subprocess.run(['open', path])
        else:
            QMessageBox.critical(self, "Error", "Failed to capture")

    # ── Mac Connect Callbacks ──────────────────────────────────────────────────

    def _mac_refresh(self):
        """Refresh Mac Connect status display."""
        status = self._mac_bridge.get_status()
        if status['connected']:
            self.mac_lbl_status.setText("● Connected")
            self.mac_lbl_status.setStyleSheet(f"color: {GREEN}; font-size: 12px; font-weight: 600;")
        else:
            self.mac_lbl_status.setText("○ Not connected")
            self.mac_lbl_status.setStyleSheet(f"color: {DIM}; font-size: 12px; font-weight: 600;")
        self.mac_lbl_ip.setText(f"IP: {status['phone_ip'] or '-'}")
        self.mac_lbl_device.setText(f"Device: {status['phone_model'] or '-'}")
        profile_names = {'high': 'High (120 FPS)', 'normal': 'Normal (60 FPS)', 'eco': 'Eco (30 FPS)'}
        self.mac_lbl_profile.setText(f"Profile: {profile_names.get(status['profile'], status['profile'])}")
        self.mac_lbl_audio.setText(f"Audio: {'Enabled' if status['audio'] else 'Disabled'}")
        self.mac_btn_profile.setText(f"Profile: {status['profile'].title()}")
        self.mac_btn_audio.setText(f"Audio: {'ON' if status['audio'] else 'OFF'}")
        self.mac_btn_setup.setEnabled(not status['connected'])
        self.mac_btn_connect.setEnabled(not status['connected'])
        self.mac_btn_mirror.setEnabled(status['connected'])
        self.mac_btn_disconnect.setEnabled(status['connected'])

    def _mac_setup(self):
        """Setup wireless via USB."""
        self.sb.showMessage("Mac Connect: Setting up wireless ADB via USB...")
        # Jalankan di thread supaya gak freeze GUI
        from PyQt5.QtCore import QTimer
        QTimer.singleShot(100, self._do_mac_setup)

    def _do_mac_setup(self):
        """Actual setup work (non-blocking via QTimer chain)."""
        self.mac_btn_setup.setEnabled(False)
        self.mac_btn_setup.setText("⏳ Waiting for USB...")
        success = self._mac_bridge.setup_wireless()
        if success:
            QMessageBox.information(self, "Mac Connect",
                "✓ Wireless ADB setup berhasil!\n\n"
                "USB bisa dicabut. Sekarang klik 'Connect Wireless' "
                "untuk terhubung tanpa kabel.")
            self.sb.showMessage("Mac Connect: Setup berhasil!")
        else:
            QMessageBox.warning(self, "Mac Connect",
                "✗ Setup gagal.\n\n"
                "Pastikan:\n"
                "1. HP terhubung via USB\n"
                "2. USB Debugging ON (Developer Options)\n"
                "3. Kabel data (bukan charge-only)")
            self.sb.showMessage("Mac Connect: Setup gagal")
        self.mac_btn_setup.setText("❶ Setup via USB")
        self.mac_btn_setup.setEnabled(True)
        self._mac_refresh()

    def _mac_connect(self):
        """Connect wireless via ADB."""
        self.sb.showMessage("Mac Connect: Scanning ARP + connecting...")
        from PyQt5.QtCore import QTimer
        QTimer.singleShot(100, self._do_mac_connect)

    def _do_mac_connect(self):
        """Actual connect work."""
        self.mac_btn_connect.setEnabled(False)
        self.mac_btn_connect.setText("⏳ Scanning...")
        success = self._mac_bridge.connect_wireless()
        if success:
            QMessageBox.information(self, "Mac Connect",
                "✓ Berhasil terhubung ke HP Infinix!\n\n"
                "Sekarang klik 'Mirror + Audio' untuk mulai mirroring.")
            self.sb.showMessage("Mac Connect: Connected!")
        else:
            QMessageBox.warning(self, "Mac Connect",
                "✗ Gagal connect.\n\n"
                "Pastikan:\n"
                "1. HP dan Mac di WiFi yang SAMA\n"
                "2. Wireless Debugging sudah di-setup (via USB sekali)\n"
                "3. HP tidak sleep/mati")
            self.sb.showMessage("Mac Connect: Connection failed")
        self.mac_btn_connect.setText("❷ Connect Wireless")
        self.mac_btn_connect.setEnabled(True)
        self._mac_refresh()

    def _mac_mirror(self):
        """Launch scrcpy mirror."""
        self.sb.showMessage("Mac Connect: Launching scrcpy...")
        from PyQt5.QtCore import QTimer
        QTimer.singleShot(100, self._do_mac_mirror)

    def _do_mac_mirror(self):
        """Actual mirror work."""
        self.mac_btn_mirror.setEnabled(False)
        success = self._mac_bridge.launch_mirror()
        if success:
            self.sb.showMessage("Mac Connect: Mirror selesai")
        else:
            self.sb.showMessage("Mac Connect: Mirror gagal")
        self.mac_btn_mirror.setEnabled(True)

    def _mac_cycle_profile(self):
        """Cycle performance profile."""
        self._mac_bridge.cycle_profile()
        self._mac_refresh()
        self.sb.showMessage(f"Mac Connect: Profile → {self._mac_bridge.performance_profile}")

    def _mac_toggle_audio(self):
        """Toggle audio forwarding."""
        self._mac_bridge.toggle_audio()
        self._mac_refresh()
        status = "enabled" if self._mac_bridge.forward_audio else "disabled"
        self.sb.showMessage(f"Mac Connect: Audio {status}")

    def _mac_disconnect(self):
        """Disconnect wireless ADB."""
        self._mac_bridge.disconnect()
        self._mac_refresh()
        self.sb.showMessage("Mac Connect: Disconnected")

    def closeEvent(self, event):
        self._stream_timer.stop()
        event.accept()


def main():
    import argparse
    ap = argparse.ArgumentParser(description="NIU CAST — Android device manager")
    ap.add_argument('--version', action='store_true', help='Show version')
    args, _ = ap.parse_known_args()
    if args.version:
        print(f"NIU CAST v{__version__}")
        return 0
    app = QApplication(sys.argv)
    app.setApplicationName("NIU CAST")
    app.setStyle('Fusion')
    win = NiuCastWindow()
    win.show()
    return app.exec_()


if __name__ == '__main__':
    sys.exit(main())
