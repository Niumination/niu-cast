"""
NIU CAST — App Manager Widget
List, search, and uninstall Android apps via ADB.
"""

from PyQt5.QtWidgets import (
    QWidget, QVBoxLayout, QHBoxLayout, QPushButton, QLabel,
    QLineEdit, QListWidget, QListWidgetItem, QMessageBox, QCheckBox
)
from PyQt5.QtCore import Qt, QTimer
from PyQt5.QtGui import QFont

from .adb_controller import ADBController

PALETTE = {
    'bg': "#11111B",
    'surface': "#1E1E2E",
    'overlay': "#313244",
    'text': "#CDD6F4",
    'sub': "#A6ADC8",
    'blue': "#89B4FA",
    'red': "#F38BA8",
    'dim': "#45475A",
    'border': "#313244",
}


class AppManagerWidget(QWidget):
    """Panel untuk list, search, uninstall aplikasi Android."""

    def __init__(self, adb: ADBController):
        super().__init__()
        self.adb = adb
        self._all_apps = []
        self._setup_ui()

    def _setup_ui(self):
        root = QVBoxLayout(self)
        root.setContentsMargins(0, 0, 0, 0)
        root.setSpacing(8)

        # ── Controls ──
        ctrl = QHBoxLayout()
        ctrl.setSpacing(8)

        self.search_input = QLineEdit()
        self.search_input.setPlaceholderText("Search apps…")
        self.search_input.setStyleSheet(f"""
            QLineEdit {{
                background: {PALETTE['surface']};
                color: {PALETTE['text']};
                border: 1px solid {PALETTE['border']};
                border-radius: 6px;
                padding: 5px 8px;
                font-size: 12px;
            }}
        """)
        self.search_input.textChanged.connect(self._filter_apps)
        ctrl.addWidget(self.search_input, 1)

        self.chk_system = QCheckBox("Show system apps")
        self.chk_system.setStyleSheet(f"color: {PALETTE['sub']}; font-size: 11px;")
        self.chk_system.stateChanged.connect(self._filter_apps)
        ctrl.addWidget(self.chk_system)

        self.btn_refresh = QPushButton("↻ Refresh")
        self.btn_refresh.setStyleSheet(f"""
            QPushButton {{
                background: {PALETTE['overlay']};
                color: {PALETTE['text']};
                border: 1px solid {PALETTE['dim']};
                border-radius: 6px;
                padding: 5px 12px;
                font-size: 11px;
            }}
            QPushButton:hover {{
                background: {PALETTE['dim']};
                border-color: {PALETTE['blue']};
            }}
        """)
        self.btn_refresh.clicked.connect(self.refresh)
        ctrl.addWidget(self.btn_refresh)

        self.btn_uninstall = QPushButton("✕ Uninstall")
        self.btn_uninstall.setStyleSheet(f"""
            QPushButton {{
                color: {PALETTE['red']};
                background: {PALETTE['overlay']};
                border: 1px solid {PALETTE['red']}40;
                border-radius: 6px;
                padding: 5px 12px;
                font-size: 11px;
            }}
            QPushButton:hover {{
                background: {PALETTE['red']}20;
                border-color: {PALETTE['red']};
            }}
            QPushButton:disabled {{
                color: {PALETTE['sub']};
                background: {PALETTE['overlay']};
                border-color: {PALETTE['dim']};
            }}
        """)
        self.btn_uninstall.setEnabled(False)
        self.btn_uninstall.clicked.connect(self._uninstall_selected)
        ctrl.addWidget(self.btn_uninstall)

        root.addLayout(ctrl)

        # ── Counter ──
        self.lbl_count = QLabel("")
        self.lbl_count.setStyleSheet(f"color: {PALETTE['dim']}; font-size: 10px; padding-left: 2px;")
        root.addWidget(self.lbl_count)

        # ── List ──
        self.list = QListWidget()
        self.list.setStyleSheet(f"""
            QListWidget {{
                background: {PALETTE['bg']};
                color: {PALETTE['text']};
                border: 1px solid {PALETTE['border']};
                border-radius: 6px;
                font-size: 12px;
            }}
            QListWidget::item {{
                padding: 6px 8px;
                border-bottom: 1px solid {PALETTE['border']}40;
            }}
            QListWidget::item:selected {{
                background: {PALETTE['blue']}20;
                color: {PALETTE['blue']};
            }}
            QListWidget::item:hover:!selected {{
                background: {PALETTE['surface']};
            }}
        """)
        self.list.currentItemChanged.connect(self._on_selection)
        root.addWidget(self.list, 1)

    def refresh(self):
        """Muuat ulang daftar apps dari device."""
        self.list.clear()
        self.btn_uninstall.setEnabled(False)
        self.lbl_count.setText("Loading…")

        if not self.adb.device_serial:
            self.lbl_count.setText("No device connected")
            return

        third_party = self.adb.list_apps(system=False)
        system = self.adb.list_apps(system=True) if self.chk_system.isChecked() else []

        self._all_apps = third_party + system
        self._filter_apps()

    def _filter_apps(self):
        """Filter apps by search query."""
        self.list.clear()
        query = self.search_input.text().strip().lower()
        show_system = self.chk_system.isChecked()

        filtered = []
        for pkg in self._all_apps:
            if show_system or not self._is_system_app(pkg):
                if not query or query in pkg.lower():
                    filtered.append(pkg)

        for pkg in filtered:
            name = self._friendly_name(pkg)
            item = QListWidgetItem(f"{name}\n{pkg}")
            item.setData(Qt.UserRole, pkg)
            item.setToolTip(f"Package: {pkg}")
            self.list.addItem(item)

        total = len(self._all_apps)
        self.lbl_count.setText(f"{len(filtered)}/{total} apps")

    def _is_system_app(self, pkg: str) -> bool:
        """Guess if a package is a system app (not reliable, but heuristic)."""
        # Known system prefixes
        system_prefixes = (
            'android.', 'com.android.', 'com.google.android.',
            'com.qualcomm.', 'com.mediatek.', 'com.infinix.',
            'com.transsion.', 'com.xos.', 'com.oplus.',
        )
        return pkg.startswith(system_prefixes)

    def _friendly_name(self, pkg: str) -> str:
        """Make a display name from package name."""
        # Split on dots, take last meaningful segment
        parts = pkg.split('.')
        if len(parts) >= 3:
            # Try to use second-level domain + name
            name = parts[-1] if parts[-1] != 'ui' and len(parts[-1]) > 2 else parts[-2]
        else:
            name = pkg
        # Clean up
        name = name.replace('_', ' ').replace('-', ' ').title()
        return name

    def _on_selection(self):
        self.btn_uninstall.setEnabled(self.list.currentItem() is not None)

    def _uninstall_selected(self):
        item = self.list.currentItem()
        if not item:
            return
        pkg = item.data(Qt.UserRole)
        name = self._friendly_name(pkg)

        reply = QMessageBox.question(
            self, "Uninstall App",
            f'Uninstall {name}?\n\nPackage: {pkg}',
            QMessageBox.Yes | QMessageBox.No,
            QMessageBox.No,
        )
        if reply != QMessageBox.Yes:
            return

        self.btn_uninstall.setEnabled(False)
        self.lbl_count.setText(f"Uninstalling {pkg}…")

        ok = self.adb.uninstall_app(pkg)
        if ok:
            self._all_apps = [p for p in self._all_apps if p != pkg]
            self._filter_apps()
            self.lbl_count.setText(f"✓ Uninstalled {name}")
        else:
            QMessageBox.critical(self, "Error", f"Failed to uninstall {pkg}")
            self._filter_apps()
