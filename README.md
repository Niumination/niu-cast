# 🏆 NiuCast — Universal Android ADB Tool & Screen Mirroring

<div align="center">

*Built from ryu-cast — adapted for general Android device management*

![Version](https://img.shields.io/badge/version-1.0.0-blue)
![Python](https://img.shields.io/badge/python-3.8+-green)
![Platform](https://img.shields.io/badge/platform-macOS%20%7C%20Linux%20%7C%20Windows-orange)

</div>

---

## 🎯 Overview

**NiuCast** adalah toolkit Android universal berbasis ADB — screen mirroring, remote control, screenshot, recording, APK install, dan batch automation. Mirip **scrcpy** tapi dengan CLI/GUI dual-mode dan fitur batch scripting.

```
┌──────────────────┐     USB/WiFi      ┌──────────────────┐
│  Android Device  │ ←───────────────→  │  Host Computer   │
│                  │     ADB Protocol   │  (macOS/Linux)   │
└──────────────────┘                   └──────────────────┘
```

## ✨ Features

- 📱 **Screen Mirroring** — real-time via PyQt5 GUI
- 📷 **Screenshot** — satu klik
- 🎥 **Screen Recording** — rekam layar
- 📦 **APK Installation** — drag & drop
- 🎮 **Remote Control** — keyevent, tap, swipe
- 🔄 **Wireless Connection** — ADB over WiFi
- 📁 **File Transfer** — push/pull
- 📋 **Batch Automation** — script YAML/JSON/plain text
- 🔧 **CLI Mode** — tanpa GUI, cocok untuk server/SSH

## 🚀 Quick Start

### Install

```bash
git clone https://github.com/niumination/niu-cast.git
cd niu-cast
python3 -m venv .venv
source .venv/bin/activate
pip install -r requirements.txt
```

### USB Debugging (Android)

1. Settings → About Phone → Tap "Build Number" 7x
2. Settings → Developer Options → USB Debugging → ON
3. Hubungkan USB → Authorize komputer

### CLI Mode

```bash
source .venv/bin/activate

# Lihat device
python3 -m niu_cast.mini --info

# Screenshot
python3 -m niu_cast.mini --screenshot

# Record 60 detik
python3 -m niu_cast.mini --record 60

# Menu interaktif
python3 -m niu_cast.mini
```

### GUI Mode

```bash
source .venv/bin/activate
python3 -m niu_cast.core
```

## 🏗️ Architecture

```
niu-cast/
├── niu_cast/
│   ├── __init__.py       # Package init
│   ├── core.py           # GUI app (PyQt5)
│   ├── mini.py           # CLI app (no GUI deps)
│   └── batch.py          # Batch automation
├── quick_mirror.sh       # Shell quick-start
├── adb_helper.sh         # ADB helper
├── setup.py              # pip installable
├── requirements.txt      # Python deps
├── install.sh            # Quick setup
└── README.md
```

## 📝 License

MIT — Niumination

---

<div align="center">

*Adapted from [ryu-cast](https://github.com/ryu-id/ryu-cast)*

</div>
