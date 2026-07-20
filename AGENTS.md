# niu-cast — Project AGENTS.md

**Lokasi:** `niu-cast/`
**Stack:** Python 3.8+, PyQt5, ADB
**Remote:** `github.com/Niumination/niu-cast`
**Versi:** v2.0.0 (refactor)
**Last Push:** 20 Jul 2026

## Overview

Android device manager via ADB. Refactor total dari Gaming Edition v1.x:
- **Buang:** gaming themes, game mode, performance monitor, batch executor, gaming UI widgets
- **Tambah:** arsitektur modular (adb_controller terpisah), UI minimal dark theme

## Refactor Stats

| Metrik | Sebelum | Sesudah | Δ |
|--------|---------|---------|---|
| Total LOC | 4.082 | 1.693 | -58.5% |
| core.py | 1.664 | 409 | -75.4% |
| Module count | 8 | 4 | -50% |
| __init__.py | 66 | 16 | -75.8% |

## Modul

| Modul | LOC | Fungsi |
|-------|-----|--------|
| `adb_controller.py` | 152 | Koneksi ADB, shell, push/pull, device info, screenshot |
| `core.py` | 409 | GUI PyQt5 minimal — 2 tab (Mirror + Files) |
| `mini.py` | 519 | CLI — device info, screenshot, record, control, APK install |
| `file_browser.py` | 597 | File explorer Android via ADB |

## Roadmap

1. ✅ **v2.0** — Refactor, buang bloat
2. ⟳ **Transsion Protocol** — Reverse engineering Joy Connect protocol (traffic capture via Windows)
3. ⟳ **App Management** — List + uninstall apps
4. ⟳ **Wireless discovery** — mDNS/Bonjour
