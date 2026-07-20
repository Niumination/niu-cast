#!/usr/bin/env python3
"""
╔══════════════════════════════════════════════════════════════════════════════╗
║                        NIU CAST - FILE BROWSER                              ║
║                    Android File Explorer via ADB                             ║
║                                                                            ║
║  Feature ported from joy-connect-for-mac (Swift) → Python/PyQt5             ║
║  Uses ADB shell commands for filesystem navigation                          ║
╚══════════════════════════════════════════════════════════════════════════════╝
"""

import os

from PyQt5.QtWidgets import (
    QWidget, QVBoxLayout, QHBoxLayout, QPushButton, QLabel, QLineEdit,
    QTreeWidget, QTreeWidgetItem, QHeaderView, QFileDialog, QMessageBox,
    QMenu, QInputDialog, QProgressBar, QSplitter, QAbstractItemView,
    QFrame, QApplication
)
from PyQt5.QtCore import Qt, QTimer, pyqtSignal, QThread
from PyQt5.QtGui import QFont, QIcon, QColor, QBrush

from .theme_manager import ThemeManager


# ─── Constants ────────────────────────────────────────────────────────────────

FS_COL_NAME = 0
FS_COL_SIZE = 1
FS_COL_TYPE = 2
FS_COL_DATE = 3

FILE_TYPE_DIR = "folder"
FILE_TYPE_FILE = "file"
FILE_TYPE_LINK = "symlink"

# Android top-level dirs
ANDROID_ROOT_DIRS = [
    "/sdcard",
    "/storage/emulated/0",
    "/data",
    "/system",
]

ICONS = {
    "folder": "📁",
    "file": "📄",
    "apk": "📦",
    "image": "🖼️",
    "video": "🎬",
    "audio": "🎵",
    "archive": "🗜️",
    "text": "📝",
    "pdf": "📋",
    "symlink": "🔗",
    "back": "🔙",
}


def guess_file_type(name: str) -> str:
    """Guess file type from extension"""
    ext = name.lower().rsplit(".", 1)[-1] if "." in name else ""
    if ext in ("jpg", "jpeg", "png", "gif", "bmp", "webp", "svg", "heic"):
        return "image"
    if ext in ("mp4", "mkv", "avi", "mov", "wmv", "flv", "3gp", "webm"):
        return "video"
    if ext in ("mp3", "wav", "flac", "aac", "ogg", "m4a", "wma"):
        return "audio"
    if ext in ("zip", "rar", "7z", "tar", "gz", "bz2", "xz"):
        return "archive"
    if ext in ("txt", "md", "json", "xml", "csv", "log", "ini", "cfg"):
        return "text"
    if ext == "pdf":
        return "pdf"
    if ext == "apk":
        return "apk"
    return "file"


# ─── Worker thread for ADB operations ─────────────────────────────────────────

class AdbWorker(QThread):
    finished = pyqtSignal(object)
    error = pyqtSignal(str)

    def __init__(self, fn, *args, **kwargs):
        super().__init__()
        self.fn = fn
        self.args = args
        self.kwargs = kwargs

    def run(self):
        try:
            result = self.fn(*self.args, **self.kwargs)
            self.finished.emit(result)
        except Exception as e:
            self.error.emit(str(e))


# ─── File Browser Widget ──────────────────────────────────────────────────────

class FileBrowserWidget(QWidget):
    """Android file browser widget using ADB shell commands"""

    def __init__(self, adb_controller, parent=None):
        super().__init__(parent)
        self.adb = adb_controller
        self.current_path = "/sdcard"
        self.history = []
        self.worker = None
        self._init_ui()
        self._refresh()

    # ── UI Setup ──────────────────────────────────────────────────────────────

    def _init_ui(self):
        layout = QVBoxLayout(self)
        layout.setContentsMargins(0, 0, 0, 0)
        layout.setSpacing(8)

        # ── Navigation bar ──
        nav = QHBoxLayout()
        nav.setSpacing(6)

        self.btn_back = QPushButton("🔙 Back")
        self.btn_back.setFixedWidth(80)
        self.btn_back.clicked.connect(self._go_back)
        self.btn_back.setEnabled(False)

        self.path_bar = QLineEdit()
        self.path_bar.setPlaceholderText("Enter path (e.g. /sdcard/Download)")
        self.path_bar.returnPressed.connect(self._navigate_to_path)
        self.path_bar.setStyleSheet("""
            QLineEdit {
                background: #1A1A2E;
                color: #FFFFFF;
                border: 1px solid #00F5FF40;
                border-radius: 5px;
                padding: 5px 8px;
                font-size: 12px;
            }
        """)

        self.btn_go = QPushButton("Go")
        self.btn_go.setFixedWidth(50)
        self.btn_go.clicked.connect(self._navigate_to_path)

        nav.addWidget(self.btn_back)
        nav.addWidget(self.path_bar, 1)
        nav.addWidget(self.btn_go)
        layout.addLayout(nav)

        # ── Quick shortcuts ──
        shortcuts = QHBoxLayout()
        shortcuts.setSpacing(4)
        for label, path in [
            ("🏠 /sdcard", "/sdcard"),
            ("📷 DCIM", "/sdcard/DCIM"),
            ("📸 Pictures", "/sdcard/Pictures"),
            ("🎵 Music", "/sdcard/Music"),
            ("📥 Download", "/sdcard/Download"),
            ("📦 Apps", "/data/app"),
        ]:
            btn = QPushButton(label)
            btn.setFixedHeight(28)
            btn.setStyleSheet("""
                QPushButton {
                    background: #16162A;
                    color: #00F5FF;
                    border: 1px solid #00F5FF20;
                    border-radius: 4px;
                    font-size: 10px;
                    padding: 2px 8px;
                }
                QPushButton:hover {
                    background: #00F5FF20;
                }
            """)
            btn.clicked.connect(lambda checked, p=path: self.navigate_to(p))
            shortcuts.addWidget(btn)
        shortcuts.addStretch()
        layout.addLayout(shortcuts)

        # ── Tree widget ──
        self.tree = QTreeWidget()
        self.tree.setColumnCount(4)
        self.tree.setHeaderLabels(["Name", "Size", "Type", "Date"])
        self.tree.setRootIsDecorated(False)
        self.tree.setAlternatingRowColors(True)
        self.tree.setSortingEnabled(True)
        self.tree.setContextMenuPolicy(Qt.CustomContextMenu)
        self.tree.customContextMenuRequested.connect(self._show_context_menu)
        self.tree.itemDoubleClicked.connect(self._on_item_double_click)
        self.tree.setSelectionMode(QAbstractItemView.ExtendedSelection)
        self.tree.setAnimated(True)

        self.tree.setStyleSheet("""
            QTreeWidget {
                background: #0D0D1A;
                color: #FFFFFF;
                border: 1px solid #00F5FF20;
                border-radius: 6px;
                font-size: 12px;
                alternate-background-color: #12122A;
            }
            QTreeWidget::item {
                padding: 4px 2px;
                border-radius: 3px;
            }
            QTreeWidget::item:selected {
                background: #00F5FF30;
                color: #00F5FF;
            }
            QHeaderView::section {
                background: #1A1A2E;
                color: #00F5FF;
                border: none;
                border-bottom: 1px solid #00F5FF30;
                padding: 6px;
                font-weight: bold;
            }
        """)

        header = self.tree.header()
        header.setStretchLastSection(False)
        header.setSectionResizeMode(FS_COL_NAME, QHeaderView.Stretch)
        header.setSectionResizeMode(FS_COL_SIZE, QHeaderView.ResizeToContents)
        header.setSectionResizeMode(FS_COL_TYPE, QHeaderView.ResizeToContents)
        header.setSectionResizeMode(FS_COL_DATE, QHeaderView.ResizeToContents)

        layout.addWidget(self.tree, 1)

        # ── Status bar ──
        status = QHBoxLayout()
        self.lbl_status = QLabel("Ready")
        self.lbl_status.setStyleSheet("color: #606070; font-size: 11px;")
        self.progress = QProgressBar()
        self.progress.setFixedHeight(8)
        self.progress.setFixedWidth(120)
        self.progress.setVisible(False)
        self.progress.setStyleSheet("""
            QProgressBar {
                background: #1A1A2E;
                border: none;
                border-radius: 4px;
                text-align: center;
            }
            QProgressBar::chunk {
                background: qlineargradient(x1:0, y1:0, x2:1, y2:0,
                    stop:0 #00F5FF, stop:1 #FF00FF);
                border-radius: 4px;
            }
        """)
        status.addWidget(self.lbl_status, 1)
        status.addWidget(self.progress)
        layout.addLayout(status)

    # ── Navigation ───────────────────────────────────────────────────────────

    def navigate_to(self, path: str):
        """Navigate to a path and refresh"""
        if self.current_path:
            self.history.append(self.current_path)
        self.current_path = path
        self.btn_back.setEnabled(True)
        self.path_bar.setText(path)
        self._refresh()

    def _navigate_to_path(self):
        path = self.path_bar.text().strip()
        if path:
            self.navigate_to(path)

    def _go_back(self):
        if self.history:
            path = self.history.pop()
            self.current_path = path
            self.path_bar.setText(path)
            self.btn_back.setEnabled(len(self.history) > 0)
            self._refresh()

    def _on_item_double_click(self, item: QTreeWidgetItem, column: int):
        if item.data(FS_COL_TYPE, Qt.UserRole) == FILE_TYPE_DIR:
            name = item.text(FS_COL_NAME)
            new_path = self._join_path(self.current_path, name)
            self.navigate_to(new_path)
        elif item.data(FS_COL_TYPE, Qt.UserRole) == FILE_TYPE_LINK:
            # Try to follow symlink
            target = item.data(FS_COL_TYPE, Qt.UserRole + 1)
            if target:
                self.navigate_to(target)

    def _join_path(self, base: str, name: str) -> str:
        base = base.rstrip("/")
        return f"{base}/{name}"

    # ── Refresh / List Directory ─────────────────────────────────────────────

    def _refresh(self):
        """Refresh current directory listing"""
        self._set_loading(True)
        self.worker = AdbWorker(self._list_directory, self.current_path)
        self.worker.finished.connect(self._on_list_result)
        self.worker.error.connect(self._on_list_error)
        self.worker.start()

    def _list_directory(self, path: str) -> list:
        """List directory contents via ADB shell"""
        rc, out, err = self.adb.shell(f'ls -la "{path}"', timeout=10)
        if rc != 0:
            raise RuntimeError(f"Failed to list {path}: {err}")

        items = []
        lines = out.strip().split("\n")
        for line in lines:
            if not line.strip():
                continue
            parts = line.split()
            # ls -la output format (Android BusyBox):
            # permissions links owner group size YYYY-MM-DD HH:MM name
            # 0          1      2     3     4    5          6     7+
            if len(parts) < 8:
                continue

            perms = parts[0]
            is_dir = perms.startswith("d")
            is_link = perms.startswith("l")
            size_str = parts[4]
            date_str = f"{parts[5]} {parts[6]}"  # "2026-07-15 11:34"
            name = " ".join(parts[7:])  # name may have spaces

            # Strip symlink target
            target = None
            if " -> " in name:
                name, target = name.split(" -> ", 1)

            size = 0
            try:
                size = int(size_str)
            except ValueError:
                size = 0

            # date_str already set from parts[5] parts[6] above
            ftype = FILE_TYPE_DIR if is_dir else (FILE_TYPE_LINK if is_link else "file")
            ftype_icon = guess_file_type(name) if ftype == "file" else ftype

            items.append({
                "name": name,
                "size": size,
                "date": date_str,
                "type": ftype,
                "type_icon": ftype_icon,
                "perm": perms,
                "target": target,
            })

        # Sort: directories first, then files alphabetically
        items.sort(key=lambda x: (0 if x["type"] == FILE_TYPE_DIR else 1, x["name"].lower()))
        return items

    def _on_list_result(self, items: list):
        """Populate tree from listing result"""
        self.tree.clear()
        for item_data in items:
            row = QTreeWidgetItem()
            name = item_data["name"]
            ftype = item_data["type"]
            ficon = ICONS.get(item_data["type_icon"], ICONS.get(ftype, "📄"))

            # Name column with icon
            if ftype == FILE_TYPE_DIR:
                display = f" {ficon}  {name}"
                row.setForeground(FS_COL_NAME, QBrush(QColor("#00F5FF")))
            else:
                display = f" {ficon}  {name}"
                row.setForeground(FS_COL_NAME, QBrush(QColor("#FFFFFF")))

            row.setText(FS_COL_NAME, display)
            row.setData(FS_COL_NAME, Qt.UserRole, name)  # store raw name

            # Size
            if ftype == FILE_TYPE_DIR:
                row.setText(FS_COL_SIZE, "")
            else:
                row.setText(FS_COL_SIZE, self._format_size(item_data["size"]))

            # Type
            row.setText(FS_COL_TYPE, item_data["type_icon"].upper())

            # Date
            row.setText(FS_COL_DATE, item_data["date"])

            # Metadata
            row.setData(FS_COL_TYPE, Qt.UserRole, ftype)
            if item_data.get("target"):
                row.setData(FS_COL_TYPE, Qt.UserRole + 1, item_data["target"])

            self.tree.addTopLevelItem(row)

        self.lbl_status.setText(f"📂 {self.current_path}  •  {len(items)} items")
        self._set_loading(False)

    def _on_list_error(self, error: str):
        QMessageBox.warning(self, "Error", f"Failed to list directory:\n{error}")
        self.lbl_status.setText(f"⚠ Error: {error}")
        self._set_loading(False)

    # ── File operations ──────────────────────────────────────────────────────

    def _show_context_menu(self, pos):
        """Right-click context menu"""
        item = self.tree.itemAt(pos)
        if not item:
            return

        name = item.data(FS_COL_NAME, Qt.UserRole)
        ftype = item.data(FS_COL_TYPE, Qt.UserRole)
        full_path = self._join_path(self.current_path, name)

        menu = QMenu(self)
        menu.setStyleSheet("""
            QMenu {
                background: #1A1A2E;
                color: #FFFFFF;
                border: 1px solid #00F5FF40;
                border-radius: 5px;
                padding: 4px;
            }
            QMenu::item {
                padding: 6px 20px;
                border-radius: 3px;
            }
            QMenu::item:selected {
                background: #00F5FF30;
                color: #00F5FF;
            }
        """)

        if ftype == FILE_TYPE_DIR:
            open_action = menu.addAction("📂 Open")
            upload_action = menu.addAction("📤 Upload Here")
            new_folder = menu.addAction("📁 New Folder")

            action = menu.exec_(self.tree.viewport().mapToGlobal(pos))
            if action == open_action:
                self.navigate_to(full_path)
            elif action == upload_action:
                self._upload_to(full_path)
            elif action == new_folder:
                self._create_folder(full_path)

        else:
            download_action = menu.addAction("📥 Download")
            delete_action = menu.addAction("🗑️ Delete")
            rename_action = menu.addAction("✏️ Rename")
            properties_action = menu.addAction("ℹ️ Properties")

            action = menu.exec_(self.tree.viewport().mapToGlobal(pos))
            if action == download_action:
                self._download_file(full_path, name)
            elif action == delete_action:
                self._delete_file(full_path)
            elif action == rename_action:
                self._rename_file(full_path, name)
            elif action == properties_action:
                self._show_properties(full_path)

    def _upload_to(self, remote_dir: str):
        """Upload files from local to Android device"""
        file_paths, _ = QFileDialog.getOpenFileNames(
            self, "Select files to upload", "",
            "All files (*)"
        )
        if not file_paths:
            return

        self._set_loading(True)
        success = 0
        errors = []
        for local_path in file_paths:
            remote_path = self._join_path(remote_dir, os.path.basename(local_path))
            self.lbl_status.setText(f"📤 Uploading {os.path.basename(local_path)}...")
            if self.adb.push(local_path, remote_path):
                success += 1
            else:
                errors.append(os.path.basename(local_path))
        self._set_loading(False)

        if errors:
            QMessageBox.warning(self, "Upload",
                f"Uploaded {success}/{len(file_paths)} files.\n"
                f"Failed: {', '.join(errors)}")
        else:
            QMessageBox.information(self, "Upload",
                f"✅ {success} file(s) uploaded successfully")
        self._refresh()

    def _download_file(self, remote_path: str, name: str):
        """Download file from Android to local"""
        save_path, _ = QFileDialog.getSaveFileName(
            self, "Save file", name, "All files (*)"
        )
        if not save_path:
            return

        self._set_loading(True)
        self.lbl_status.setText(f"📥 Downloading {name}...")
        if self.adb.pull(remote_path, save_path):
            self._set_loading(False)
            QMessageBox.information(self, "Download", f"✅ Saved to:\n{save_path}")
        else:
            self._set_loading(False)
            QMessageBox.critical(self, "Error", f"Failed to download {name}")

    def _delete_file(self, remote_path: str):
        """Delete file on Android"""
        reply = QMessageBox.question(
            self, "Confirm Delete",
            f"Delete this file?\n{remote_path}",
            QMessageBox.Yes | QMessageBox.No
        )
        if reply != QMessageBox.Yes:
            return

        self._set_loading(True)
        rc, _, _ = self.adb.shell(f'rm -f "{remote_path}"', timeout=10)
        self._set_loading(False)

        if rc == 0:
            self._refresh()
        else:
            QMessageBox.critical(self, "Error", f"Failed to delete:\n{remote_path}")

    def _rename_file(self, remote_path: str, old_name: str):
        """Rename file on Android"""
        new_name, ok = QInputDialog.getText(
            self, "Rename", "New name:", text=old_name
        )
        if not ok or not new_name or new_name == old_name:
            return

        new_path = self._join_path(self.current_path, new_name)
        self._set_loading(True)
        rc, _, _ = self.adb.shell(f'mv "{remote_path}" "{new_path}"', timeout=10)
        self._set_loading(False)

        if rc == 0:
            self._refresh()
        else:
            QMessageBox.critical(self, "Error", "Failed to rename")

    def _create_folder(self, parent_path: str):
        """Create new folder on Android"""
        name, ok = QInputDialog.getText(
            self, "New Folder", "Folder name:"
        )
        if not ok or not name:
            return

        new_path = self._join_path(parent_path, name)
        self._set_loading(True)
        rc, _, _ = self.adb.shell(f'mkdir -p "{new_path}"', timeout=10)
        self._set_loading(False)

        if rc == 0:
            self._refresh()
        else:
            QMessageBox.critical(self, "Error", f"Failed to create folder:\n{name}")

    def _show_properties(self, remote_path: str):
        """Show file properties"""
        rc, out, _ = self.adb.shell(f'stat "{remote_path}"', timeout=5)
        if rc == 0:
            QMessageBox.information(self, "Properties",
                f"Path: {remote_path}\n\n{out.strip()}")
        else:
            QMessageBox.information(self, "Properties",
                f"Path: {remote_path}\n(Could not retrieve details)")

    # ── Utilities ────────────────────────────────────────────────────────────

    def _format_size(self, size: int) -> str:
        if size < 1024:
            return f"{size} B"
        elif size < 1024 ** 2:
            return f"{size / 1024:.1f} KB"
        elif size < 1024 ** 3:
            return f"{size / 1024 ** 2:.1f} MB"
        else:
            return f"{size / 1024 ** 3:.1f} GB"

    def _set_loading(self, loading: bool):
        self.progress.setVisible(loading)
        if loading:
            self.progress.setRange(0, 0)  # indeterminate
            self.lbl_status.setText("⏳ Loading...")
        else:
            self.progress.setRange(0, 100)
            self.progress.setValue(0)
