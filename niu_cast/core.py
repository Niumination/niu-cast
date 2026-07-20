#! /usr/bin/env python3
"""
NIU CAST — Core GUI
Minimal dark-themed interface untuk Android device management via ADB.
"""

import sys
import os
import subprocess
import tempfile
from datetime import datetime

from PyQt5.QtWidgets import (
    QApplication, QMainWindow, QWidget, QVBoxLayout, QHBoxLayout,
    QPushButton, QLabel, QComboBox, QMessageBox, QFrame, QTabWidget,
    QFileDialog, QStatusBar, QSplitter, QTextEdit
)
from PyQt5.QtCore import Qt, QTimer
from PyQt5.QtGui import QFont, QPixmap, QImage

from .adb_controller import ADBController
from .file_browser import FileBrowserWidget

__version__ = "2.0.0"

# ── Dark theme palette ──────────────────────────────────────────────────────────

DARK_BG = "#1E1E2E"
DARK_SURFACE = "#2B2B3D"
DARK_CARD = "#363649"
TEXT_PRIMARY = "#CDD6F4"
TEXT_SECONDARY = "#A6ADC8"
ACCENT = "#89B4FA"
ACCENT_DIM = "#89B4FA40"
RED = "#F38BA8"
GREEN = "#A6E3A1"

STYLESHEET = f"""
QMainWindow, QWidget {{
    background: {DARK_BG};
    color: {TEXT_PRIMARY};
    font-family: 'SF Pro Display', 'Helvetica Neue', 'Segoe UI', sans-serif;
}}
QLabel {{
    background: transparent;
    color: {TEXT_PRIMARY};
}}
QLineEdit {{
    background: {DARK_SURFACE};
    color: {TEXT_PRIMARY};
    border: 1px solid {ACCENT_DIM};
    border-radius: 4px;
    padding: 4px 8px;
}}
QPushButton {{
    background: {DARK_CARD};
    color: {TEXT_PRIMARY};
    border: 1px solid {ACCENT_DIM};
    border-radius: 4px;
    padding: 6px 14px;
    font-size: 12px;
}}
QPushButton:hover {{
    background: {ACCENT}30;
    border-color: {ACCENT};
}}
QPushButton:pressed {{
    background: {ACCENT}50;
}}
QPushButton:disabled {{
    color: {TEXT_SECONDARY};
    border-color: transparent;
}}
QComboBox {{
    background: {DARK_SURFACE};
    color: {TEXT_PRIMARY};
    border: 1px solid {ACCENT_DIM};
    border-radius: 4px;
    padding: 4px 8px;
    min-width: 120px;
}}
QComboBox::drop-down {{
    border: none;
    width: 20px;
}}
QComboBox QAbstractItemView {{
    background: {DARK_SURFACE};
    color: {TEXT_PRIMARY};
    selection-background-color: {ACCENT}40;
}}
QFrame#card {{
    background: {DARK_SURFACE};
    border: 1px solid {ACCENT_DIM};
    border-radius: 6px;
    padding: 10px;
}}
QStatusBar {{
    background: {DARK_SURFACE};
    color: {TEXT_SECONDARY};
    border-top: 1px solid {ACCENT_DIM};
}}
QTabWidget::pane {{
    background: {DARK_BG};
    border: none;
}}
QTabBar::tab {{
    background: {DARK_SURFACE};
    color: {TEXT_SECONDARY};
    border: 1px solid transparent;
    border-top-left-radius: 4px;
    border-top-right-radius: 4px;
    padding: 6px 16px;
    margin-right: 2px;
}}
QTabBar::tab:selected {{
    background: {DARK_CARD};
    color: {ACCENT};
    border-color: {ACCENT_DIM};
    border-bottom-color: {DARK_CARD};
}}
QTabBar::tab:hover!selected {{
    background: {DARK_CARD};
}}
QTreeWidget {{
    background: {DARK_BG};
    color: {TEXT_PRIMARY};
    border: 1px solid {ACCENT_DIM};
    border-radius: 4px;
    alternate-background-color: {DARK_SURFACE};
}}
QTreeWidget::item:selected {{
    background: {ACCENT}30;
    color: {ACCENT};
}}
QHeaderView::section {{
    background: {DARK_SURFACE};
    color: {ACCENT};
    border: none;
    border-bottom: 1px solid {ACCENT_DIM};
    padding: 4px;
    font-weight: bold;
}}
QProgressBar {{
    background: {DARK_SURFACE};
    border: none;
    border-radius: 3px;
    text-align: center;
    height: 6px;
}}
QProgressBar::chunk {{
    background: {ACCENT};
    border-radius: 3px;
}}
QTextEdit {{
    background: {DARK_BG};
    color: {TEXT_PRIMARY};
    border: 1px solid {ACCENT_DIM};
    border-radius: 4px;
    font-family: 'SF Mono', 'Menlo', monospace;
    font-size: 11px;
}}
"""


class NiuCastWindow(QMainWindow):
    """Main window — Android device management"""

    def __init__(self):
        super().__init__()
        self.adb = ADBController()
        self.setWindowTitle("NIU CAST")
        self.setGeometry(200, 100, 1200, 800)
        self.setMinimumSize(900, 600)
        self.setStyleSheet(STYLESHEET)

        self._setup_ui()
        self._setup_timers()

    # ── UI Setup ──────────────────────────────────────────────────────────────

    def _setup_ui(self):
        central = QWidget()
        self.setCentralWidget(central)
        layout = QVBoxLayout(central)
        layout.setContentsMargins(12, 12, 12, 12)
        layout.setSpacing(8)

        # ── Top bar ──
        top = QHBoxLayout()
        top.setSpacing(8)

        title = QLabel("NIU CAST")
        title.setStyleSheet(f"font-size: 18px; font-weight: bold; color: {ACCENT}; letter-spacing: 2px;")
        top.addWidget(title)

        top.addStretch()

        self.device_combo = QComboBox()
        self.device_combo.setMinimumWidth(220)
        top.addWidget(self.device_combo)

        self.btn_refresh = QPushButton("⟳ Refresh")
        self.btn_refresh.setFixedWidth(90)
        self.btn_refresh.clicked.connect(self._refresh_devices)
        top.addWidget(self.btn_refresh)

        self.btn_connect = QPushButton("🔗 Connect")
        self.btn_connect.setFixedWidth(100)
        self.btn_connect.clicked.connect(self._connect_device)
        top.addWidget(self.btn_connect)

        self.lbl_status = QLabel("⏻ Disconnected")
        self.lbl_status.setStyleSheet(f"color: {RED}; font-weight: bold;")
        top.addWidget(self.lbl_status)

        layout.addLayout(top)

        # ── Device info bar ──
        self.info_bar = QFrame()
        self.info_bar.setObjectName("card")
        info_layout = QHBoxLayout(self.info_bar)
        info_layout.setContentsMargins(10, 6, 10, 6)
        self.lbl_device_info = QLabel("No device connected")
        self.lbl_device_info.setStyleSheet(f"color: {TEXT_SECONDARY}; font-size: 11px;")
        info_layout.addWidget(self.lbl_device_info)
        info_layout.addStretch()
        self.lbl_device_info_detail = QLabel("")
        self.lbl_device_info_detail.setStyleSheet(f"color: {TEXT_SECONDARY}; font-size: 11px;")
        info_layout.addWidget(self.lbl_device_info_detail)
        layout.addWidget(self.info_bar)

        # ── Tabs ──
        self.tabs = QTabWidget()

        # Mirror tab
        mirror_tab = QWidget()
        mirror_layout = QVBoxLayout(mirror_tab)
        mirror_layout.setContentsMargins(0, 8, 0, 0)

        mirror_controls = QHBoxLayout()
        self.btn_start_mirror = QPushButton("▶ Start Mirror")
        self.btn_start_mirror.clicked.connect(self._start_mirror)
        mirror_controls.addWidget(self.btn_start_mirror)
        self.btn_screenshot = QPushButton("📷 Screenshot")
        self.btn_screenshot.clicked.connect(self._take_screenshot)
        mirror_controls.addWidget(self.btn_screenshot)
        mirror_controls.addStretch()
        self.lbl_mirror_status = QLabel("")
        self.lbl_mirror_status.setStyleSheet(f"color: {TEXT_SECONDARY};")
        mirror_controls.addWidget(self.lbl_mirror_status)
        mirror_layout.addLayout(mirror_controls)

        self.mirror_label = QLabel("Click 'Start Mirror' to begin")
        self.mirror_label.setAlignment(Qt.AlignCenter)
        self.mirror_label.setStyleSheet(f"""
            color: {TEXT_SECONDARY};
            font-size: 14px;
            background: {DARK_SURFACE};
            border: 1px solid {ACCENT_DIM};
            border-radius: 6px;
        """)
        self.mirror_label.setMinimumHeight(300)
        mirror_layout.addWidget(self.mirror_label, 1)

        self.tabs.addTab(mirror_tab, "📺 Mirror")

        # Files tab
        files_tab = QWidget()
        files_layout = QVBoxLayout(files_tab)
        files_layout.setContentsMargins(0, 8, 0, 0)
        self.file_browser = FileBrowserWidget(self.adb)
        files_layout.addWidget(self.file_browser)
        self.tabs.addTab(files_tab, "📁 Files")

        layout.addWidget(self.tabs, 1)

        # ── Status bar ──
        self.status_bar = QStatusBar()
        self.status_bar.showMessage("Ready")
        self.setStatusBar(self.status_bar)

    # ── Timers ────────────────────────────────────────────────────────────────

    def _setup_timers(self):
        self.device_timer = QTimer()
        self.device_timer.timeout.connect(self._check_device)
        self.device_timer.start(3000)

    # ── Device ────────────────────────────────────────────────────────────────

    def _refresh_devices(self):
        self.device_combo.clear()
        devices = self.adb.devices()
        if devices:
            self.device_combo.addItems(devices)
            self.status_bar.showMessage(f"Found {len(devices)} device(s)")
        else:
            self.device_combo.addItem("No devices found")
            self.status_bar.showMessage("No devices — enable USB debugging")

    def _connect_device(self):
        serial = self.device_combo.currentText()
        if not serial or serial == "No devices found":
            QMessageBox.warning(self, "No Device",
                "No device detected.\n\nEnable USB Debugging on your Android device\nand connect via USB.")
            return
        if self.adb.connect(serial):
            self._update_device_info()
            self.status_bar.showMessage(f"Connected: {serial}")
        else:
            QMessageBox.critical(self, "Error", "Failed to connect to device")

    def _disconnect_device(self):
        self.adb.disconnect()
        self.lbl_status.setText("⏻ Disconnected")
        self.lbl_status.setStyleSheet(f"color: {RED}; font-weight: bold;")
        self.lbl_device_info.setText("No device connected")
        self.lbl_device_info_detail.setText("")
        self.lbl_mirror_status.setText("")
        self.mirror_label.setText("Click 'Start Mirror' to begin")
        self.status_bar.showMessage("Disconnected")

    def _check_device(self):
        if self.adb.device_serial:
            rc, _, _ = self.adb._run(['-s', self.adb.device_serial, 'get-state'])
            if rc != 0:
                self._disconnect_device()

    def _update_device_info(self):
        info = self.adb.get_device_info()
        serial = self.adb.device_serial
        self.lbl_status.setText("● Connected")
        self.lbl_status.setStyleSheet(f"color: {GREEN}; font-weight: bold;")
        self.lbl_device_info.setText(f"{info.get('manufacturer', '?')}  {info.get('model', '?')}")
        detail = f"Android {info.get('android', '?')}  •  {info.get('width', '?')}×{info.get('height', '?')}"
        if 'ip' in info:
            detail += f"  •  WiFi {info['ip']}"
        self.lbl_device_info_detail.setText(detail)
        self.status_bar.showMessage(f"Connected: {serial}")

    # ── Mirror ────────────────────────────────────────────────────────────────

    def _start_mirror(self):
        """Take a screenshot and display it (basic preview)"""
        if not self.adb.device_serial:
            QMessageBox.warning(self, "No Device", "Connect a device first")
            return

        self.lbl_mirror_status.setText("Capturing...")
        tmp = os.path.join(tempfile.gettempdir(), "niu_mirror.png")
        if self.adb.screencap(tmp):
            pixmap = QPixmap(tmp)
            if not pixmap.isNull():
                scaled = pixmap.scaled(
                    self.mirror_label.width(), 700,
                    Qt.KeepAspectRatio, Qt.SmoothTransformation
                )
                self.mirror_label.setPixmap(scaled)
                self.mirror_label.setAlignment(Qt.AlignCenter)
                self.lbl_mirror_status.setText("Static preview (1 frame)")
                self.status_bar.showMessage("Screenshot captured")
            else:
                self.lbl_mirror_status.setText("Failed to decode image")
        else:
            self.lbl_mirror_status.setText("Capture failed")

    def _take_screenshot(self):
        if not self.adb.device_serial:
            QMessageBox.warning(self, "No Device", "Connect a device first")
            return

        save_dir = os.path.expanduser("~/Pictures")
        os.makedirs(save_dir, exist_ok=True)
        ts = datetime.now().strftime("%Y%m%d_%H%M%S")
        path = os.path.join(save_dir, f"niu_screenshot_{ts}.png")

        if self.adb.screencap(path):
            self.status_bar.showMessage(f"Screenshot saved: {path}")
            subprocess.run(['open', path])
        else:
            QMessageBox.critical(self, "Error", "Failed to capture screenshot")

    # ── Other ─────────────────────────────────────────────────────────────────

    def closeEvent(self, event):
        event.accept()


def main():
    import argparse
    parser = argparse.ArgumentParser(description="NIU CAST — Android device manager via ADB")
    parser.add_argument('--version', action='store_true', help='Show version')
    args, _ = parser.parse_known_args()

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
