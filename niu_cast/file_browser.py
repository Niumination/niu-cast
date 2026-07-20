"""
NIU CAST — File Browser Widget
Android File Explorer via ADB (lazy PyQt5 import for CLI compatibility).
"""

import os


class FileBrowserWidget:
    """Proxy that lazily creates the real FileBrowser QWidget on first use."""

    def __init__(self, adb):
        self._adb = adb
        self._widget = None

    def __getattr__(self, name):
        if self._widget is None:
            self._widget = self._build()
        return getattr(self._widget, name)

    def _build(self):
        from PyQt5.QtWidgets import (
            QWidget, QVBoxLayout, QHBoxLayout, QPushButton, QLabel, QLineEdit,
            QTreeWidget, QTreeWidgetItem, QHeaderView, QFileDialog, QMessageBox,
            QMenu, QInputDialog, QProgressBar, QSplitter, QAbstractItemView,
            QFrame, QApplication,
        )
        from PyQt5.QtCore import Qt, QTimer
        from PyQt5.QtGui import QFont

        from .adb_controller import ADBController

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

        class _RealFileBrowser(QWidget):
            """
            Android File Browser via ADB shell commands.

            Ported from joy-connect-for-mac (Swift) → Python/PyQt5.
            Uses 'adb shell ls -la' for file listing, push/pull for transfer.
            """

            def __init__(self, adb):
                super().__init__()
                self.adb = adb
                self._current_path = "/sdcard"
                self._history = []
                self._is_loading = False
                self._setup_ui()
                self._browse("/sdcard")

            def _setup_ui(self):
                root = QVBoxLayout(self)
                root.setContentsMargins(0, 0, 0, 0)
                root.setSpacing(6)

                # ── Path bar ──
                path_bar = QHBoxLayout()
                path_bar.setSpacing(6)

                self.btn_back = QPushButton("← Back")
                self.btn_back.setFixedWidth(72)
                self.btn_back.setStyleSheet(f"""
                    QPushButton {{ background: {OVERLAY}; color: {TEXT};
                        border: 1px solid {DIM}; border-radius: 6px;
                        padding: 5px 8px; font-size: 11px; }}
                    QPushButton:hover {{ background: {DIM}; border-color: {BLUE}; }}
                    QPushButton:disabled {{ color: {SUB}; }}
                """)
                self.btn_back.clicked.connect(self._go_back)
                path_bar.addWidget(self.btn_back)

                self.path_input = QLineEdit()
                self.path_input.setText(self._current_path)
                self.path_input.setStyleSheet(f"""
                    QLineEdit {{ background: {SURFACE}; color: {TEXT};
                        border: 1px solid {BORDER}; border-radius: 6px;
                        padding: 5px 8px; font-size: 11px; }}
                """)
                self.path_input.returnPressed.connect(self._navigate_to_path)
                path_bar.addWidget(self.path_input, 1)

                self.btn_go = QPushButton("Go")
                self.btn_go.setFixedWidth(44)
                self.btn_go.setStyleSheet(f"""
                    QPushButton {{ background: {BLUE}; color: {BG};
                        border: none; border-radius: 6px;
                        padding: 5px 8px; font-size: 11px; font-weight: bold; }}
                """)
                self.btn_go.clicked.connect(self._navigate_to_path)
                path_bar.addWidget(self.btn_go)

                self.btn_home = QPushButton("⌂")
                self.btn_home.setFixedWidth(32)
                self.btn_home.setToolTip("Go to /sdcard")
                self.btn_home.setStyleSheet(f"""
                    QPushButton {{ background: {OVERLAY}; color: {TEXT};
                        border: 1px solid {DIM}; border-radius: 6px; font-size: 14px; }}
                    QPushButton:hover {{ background: {DIM}; }}
                """)
                self.btn_home.clicked.connect(lambda: self._browse("/sdcard"))
                path_bar.addWidget(self.btn_home)

                self.btn_refresh = QPushButton("↻")
                self.btn_refresh.setFixedWidth(32)
                self.btn_refresh.setToolTip("Refresh")
                self.btn_refresh.setStyleSheet(f"""
                    QPushButton {{ background: {OVERLAY}; color: {TEXT};
                        border: 1px solid {DIM}; border-radius: 6px; font-size: 14px; }}
                    QPushButton:hover {{ background: {DIM}; }}
                """)
                self.btn_refresh.clicked.connect(self._refresh)
                path_bar.addWidget(self.btn_refresh)

                root.addLayout(path_bar)

                # ── Toolbar ──
                toolbar = QHBoxLayout()
                toolbar.setSpacing(6)

                self.btn_upload = QPushButton("↑ Upload")
                self.btn_upload.setStyleSheet(f"""
                    QPushButton {{ background: {OVERLAY}; color: {TEXT};
                        border: 1px solid {DIM}; border-radius: 6px;
                        padding: 4px 10px; font-size: 10px; }}
                    QPushButton:hover {{ border-color: {BLUE}; }}
                """)
                self.btn_upload.clicked.connect(self._upload)
                toolbar.addWidget(self.btn_upload)

                self.btn_download = QPushButton("↓ Download")
                self.btn_download.setStyleSheet(f"""
                    QPushButton {{ background: {OVERLAY}; color: {TEXT};
                        border: 1px solid {DIM}; border-radius: 6px;
                        padding: 4px 10px; font-size: 10px; }}
                    QPushButton:hover {{ border-color: {GREEN}; }}
                """)
                self.btn_download.clicked.connect(self._download)
                toolbar.addWidget(self.btn_download)

                self.btn_delete = QPushButton("✕ Delete")
                self.btn_delete.setStyleSheet(f"""
                    QPushButton {{ color: {RED};
                        background: {OVERLAY};
                        border: 1px solid {RED}40; border-radius: 6px;
                        padding: 4px 10px; font-size: 10px; }}
                    QPushButton:hover {{ background: {RED}20; border-color: {RED}; }}
                """)
                self.btn_delete.clicked.connect(self._delete)
                toolbar.addWidget(self.btn_delete)

                self.btn_new_folder = QPushButton("+ Folder")
                self.btn_new_folder.setStyleSheet(f"""
                    QPushButton {{ background: {OVERLAY}; color: {TEXT};
                        border: 1px solid {DIM}; border-radius: 6px;
                        padding: 4px 10px; font-size: 10px; }}
                    QPushButton:hover {{ border-color: {BLUE}; }}
                """)
                self.btn_new_folder.clicked.connect(self._new_folder)
                toolbar.addWidget(self.btn_new_folder)

                self.btn_rename = QPushButton("✎ Rename")
                self.btn_rename.setStyleSheet(f"""
                    QPushButton {{ background: {OVERLAY}; color: {TEXT};
                        border: 1px solid {DIM}; border-radius: 6px;
                        padding: 4px 10px; font-size: 10px; }}
                    QPushButton:hover {{ border-color: {BLUE}; }}
                """)
                self.btn_rename.clicked.connect(self._rename)
                toolbar.addWidget(self.btn_rename)

                toolbar.addStretch()

                self.lbl_status = QLabel("")
                self.lbl_status.setStyleSheet(f"color: {DIM}; font-size: 10px;")
                toolbar.addWidget(self.lbl_status)

                root.addLayout(toolbar)

                # ── File tree ──
                self.tree = QTreeWidget()
                self.tree.setColumnCount(4)
                self.tree.setHeaderLabels(["Name", "Size", "Modified", "Type"])
                self.tree.setAlternatingRowColors(True)
                self.tree.setRootIsDecorated(False)
                self.tree.setSelectionMode(QAbstractItemView.SingleSelection)
                self.tree.setContextMenuPolicy(Qt.CustomContextMenu)
                self.tree.customContextMenuRequested.connect(self._context_menu)
                self.tree.itemDoubleClicked.connect(self._on_item_double_click)
                header = self.tree.header()
                header.setStretchLastSection(False)
                header.setSectionResizeMode(0, QHeaderView.Stretch)
                header.setSectionResizeMode(1, QHeaderView.ResizeToContents)
                header.setSectionResizeMode(2, QHeaderView.ResizeToContents)
                header.setSectionResizeMode(3, QHeaderView.ResizeToContents)
                self.tree.setStyleSheet(f"""
                    QTreeWidget {{ background: {BG}; color: {TEXT};
                        border: 1px solid {BORDER}; border-radius: 6px;
                        alternate-background-color: {SURFACE};
                        font-size: 11px; }}
                    QTreeWidget::item {{ padding: 3px 4px; }}
                    QTreeWidget::item:selected {{
                        background: {BLUE}20; color: {BLUE}; }}
                    QHeaderView::section {{ background: transparent; color: {SUB};
                        border: none; border-bottom: 1px solid {BORDER};
                        padding: 3px; font-weight: 600; font-size: 10px; }}
                """)

                root.addWidget(self.tree, 1)

            # ── Navigation ──

            def _browse(self, path, add_history=True):
                """List directory contents."""
                if self._is_loading:
                    return
                self._is_loading = True
                self.lbl_status.setText("Loading…")
                QApplication.processEvents()

                if add_history and self._current_path:
                    self._history.append(self._current_path)
                self._current_path = path
                self.path_input.setText(path)
                self.tree.clear()

                # Use ls -la for detailed listing
                rc, out, _ = self.adb.shell(
                    f'cd "{path}" 2>/dev/null && ls -la 2>/dev/null',
                    timeout=10,
                )

                if rc != 0 or not out.strip():
                    # Fallback: try without cd
                    rc, out, _ = self.adb.shell(
                        f'ls -la "{path}" 2>/dev/null',
                        timeout=10,
                    )

                if rc == 0 and out.strip():
                    self._parse_listing(out)
                else:
                    err_item = QTreeWidgetItem(["⚠ Cannot read directory"])
                    self.tree.addTopLevelItem(err_item)
                    self.lbl_status.setText("Error reading directory")

                self._is_loading = False
                self.lbl_status.setText(
                    f"{self.tree.topLevelItemCount()} items — {self._current_path}"
                )

            def _parse_listing(self, output):
                """Parse 'ls -la' output into tree items."""
                lines = output.strip().split('\n')
                for line in lines:
                    line = line.strip()
                    if not line:
                        continue

                    parts = line.split()
                    # ls -la format: permissions links owner group size month day time name
                    if len(parts) < 8:
                        continue

                    perms = parts[0]

                    # Determine name index: name is at index 7 (after perms, links, owner, group, size, month, day)
                    # But time may have hour:minute or year — 3 parts (month, day, time_or_year)
                    # So name = parts[7] + possibly more for names with spaces
                    name = parts[7] if len(parts) > 7 else ""
                    if len(parts) > 8:
                        name = ' '.join(parts[7:])

                    # Skip . and ..
                    if name in ('.', '..'):
                        continue

                    is_dir = perms.startswith('d')
                    is_link = perms.startswith('l')
                    size = parts[4] if len(parts) > 4 else ""
                    # Date: month, day, time
                    date_str = ' '.join(parts[5:7]) if len(parts) > 7 else ""

                    display_name = name
                    icon_prefix = "📁 " if is_dir else ("🔗 " if is_link else "📄 ")

                    item = QTreeWidgetItem()
                    item.setText(0, f"{icon_prefix}{display_name}")
                    item.setText(1, size)
                    item.setText(2, date_str)
                    item.setText(3, "Directory" if is_dir else ("Link" if is_link else "File"))
                    item.setData(0, Qt.UserRole, {
                        'name': name,
                        'is_dir': is_dir,
                        'path': f"{self._current_path}/{name}" if self._current_path != "/"
                                else f"/{name}",
                        'size': size,
                    })
                    self.tree.addTopLevelItem(item)

            def _on_item_double_click(self, item, column):
                data = item.data(0, Qt.UserRole)
                if data and data.get('is_dir'):
                    self._browse(data['path'])

            def _navigate_to_path(self):
                path = self.path_input.text().strip()
                if path:
                    self._browse(path)

            def _go_back(self):
                if self._history:
                    path = self._history.pop()
                    self._browse(path, add_history=False)

            def _refresh(self):
                if self._current_path:
                    self._browse(self._current_path)

            # ── Operations ──

            def _upload(self):
                paths, _ = QFileDialog.getOpenFileNames(self, "Upload Files")
                if not paths:
                    return
                self.lbl_status.setText("Uploading…")
                for local_path in paths:
                    remote = f"{self._current_path}/{os.path.basename(local_path)}"
                    self.adb.push(local_path, remote)
                self._refresh()
                self.lbl_status.setText(f"Uploaded {len(paths)} file(s)")

            def _download(self):
                item = self.tree.currentItem()
                if not item:
                    return
                data = item.data(0, Qt.UserRole)
                if not data or data.get('is_dir'):
                    QMessageBox.information(self, "Download", "Select a file to download.")
                    return
                dest = QFileDialog.getExistingDirectory(self, "Download to")
                if not dest:
                    return
                self.lbl_status.setText("Downloading…")
                local = os.path.join(dest, data['name'])
                if self.adb.pull(data['path'], local):
                    self.lbl_status.setText(f"Downloaded → {local}")
                else:
                    QMessageBox.critical(self, "Error", "Download failed")
                    self.lbl_status.setText("Download failed")

            def _delete(self):
                item = self.tree.currentItem()
                if not item:
                    return
                data = item.data(0, Qt.UserRole)
                if not data:
                    return
                name = data['name']
                path = data['path']
                is_dir = data['is_dir']

                reply = QMessageBox.question(
                    self, "Delete",
                    f'Delete {name}?',
                    QMessageBox.Yes | QMessageBox.No,
                    QMessageBox.No,
                )
                if reply != QMessageBox.Yes:
                    return

                self.lbl_status.setText(f"Deleting {name}…")
                if is_dir:
                    self.adb.shell(f'rm -rf "{path}"', timeout=10)
                else:
                    self.adb.shell(f'rm "{path}"', timeout=10)
                self._refresh()
                self.lbl_status.setText(f"Deleted {name}")

            def _new_folder(self):
                name, ok = QInputDialog.getText(self, "New Folder", "Folder name:")
                if ok and name.strip():
                    path = f"{self._current_path}/{name.strip()}"
                    self.adb.shell(f'mkdir -p "{path}"', timeout=5)
                    self._refresh()
                    self.lbl_status.setText(f"Created {name.strip()}")

            def _rename(self):
                item = self.tree.currentItem()
                if not item:
                    return
                data = item.data(0, Qt.UserRole)
                if not data:
                    return
                old_name = data['name']
                new_name, ok = QInputDialog.getText(
                    self, "Rename", "New name:", text=old_name,
                )
                if ok and new_name.strip() and new_name.strip() != old_name:
                    old_path = data['path']
                    new_path = f"{self._current_path}/{new_name.strip()}"
                    self.adb.shell(f'mv "{old_path}" "{new_path}"', timeout=10)
                    self._refresh()
                    self.lbl_status.setText(f"Renamed → {new_name.strip()}")

            def _context_menu(self, pos):
                item = self.tree.itemAt(pos)
                if not item:
                    return
                data = item.data(0, Qt.UserRole)
                if not data:
                    return
                menu = QMenu(self)
                if not data.get('is_dir'):
                    act_download = menu.addAction("↓ Download")
                    act_download.triggered.connect(self._download)
                act_rename = menu.addAction("✎ Rename")
                act_rename.triggered.connect(self._rename)
                act_delete = menu.addAction("✕ Delete")
                act_delete.triggered.connect(self._delete)
                menu.exec_(self.tree.viewport().mapToGlobal(pos))

        return _RealFileBrowser(self._adb)
