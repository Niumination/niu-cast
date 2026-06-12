# <img src="https://raw.githubusercontent.com/niumination/niu-cast/main/.assets/icon.svg" width="40" /> NIU CAST

<div align="center">

**⚡ Gaming Edition v1.1.1 • Universal Android ADB Tool & Screen Mirroring ⚡**

*Inspired by Genshin Impact, Xarena, and Cyberpunk aesthetics*

![Version](https://img.shields.io/badge/version-1.1.1-blue)
![Python](https://img.shields.io/badge/python-3.8+-green)
![Platform](https://img.shields.io/badge/platform-macOS%20|%20Linux%20|%20Windows-orange)

</div>

---

## 🎮 Overview

**NiuCast** adalah toolkit Android universal berbasis ADB dengan desain gaming-inspired dan fitur lengkap pengelolaan device Android via USB/Wireless.

**Fitur Unggulan:**

- 📱 **Real-time Screen Mirroring** — Display layar Android di komputer
- 🎮 **Game Mode** — Optimasi device untuk gaming
- 📊 **Performance Monitor** — CPU temp, battery, RAM real-time
- 🎨 **Theme Switcher** — 6 tema gaming (Cyberpunk, Genshin, Valorant, dll)
- 🚀 **Game Launcher** — Launch 12 game populer langsung dari NiuCast
- ⌨️ **Keyboard Shortcuts** — Hotkey navigasi tanpa sentuh
- 📷 **Screenshot & Recording** — Dokumentasi layar instan
- 🔗 **Wireless ADB** — Via USB tethering atau WiFi
- 📦 **APK Installation** — Install APK langsung
- ⚡ **Batch Automation** — Script YAML/JSON/Text

---

## ✨ Features

### 🎮 Gaming Edition (v1.1.1)

| Feature | Description |
|---------|-------------|
| 🎮 **Game Mode** | Optimasi otomatis: mati animasi, boost GPU, kill background apps, max brightness |
| 📊 **Perf Monitor** | Live monitoring CPU temp, battery temp, RAM usage via status bar |
| 🎨 **Theme Switcher** | 6 tema: Cyberpunk, Genshin, Xarena, Valorant, LoL, Minecraft |
| 🚀 **Game Launcher** | Launch 12 game populer + auto-detect game terinstall |
| ⌨️ **Keyboard Shortcuts** | Ctrl+H (Home), Ctrl+B (Back), Ctrl+S (Screenshot), Ctrl+R (Record), dll |

### 🔧 Core Features

| Feature | Description |
|---------|-------------|
| 📱 Live Stream | Real-time ~60 FPS screen mirroring |
| 🖱️ Touch Input | Click/swipe on mirror → device response |
| 📷 Screenshot | One-click capture with instant preview |
| 🎥 Recording | Screen record hingga 180 detik |
| 📦 APK Install | Drag & drop atau file picker |
| 🔗 Wireless | ADB over TCP/IP via USB atau WiFi |

---

## 🚀 Quick Start

### 1. Prerequisites

```bash
# Android Debug Bridge
# macOS:
brew install android-platform-tools

# Linux:
sudo apt install adb   # atau: sudo pacman -S android-tools
```

### 2. Install NiuCast

```bash
git clone https://github.com/niumination/niu-cast.git
cd niu-cast

# Virtual environment
python3 -m venv .venv
source .venv/bin/activate

# Install dependencies
pip install -r requirements.txt
# atau langsung:
pip install numpy opencv-python Pillow PyQt5
```

### 3. Device Setup (Android)

```
1. Settings → About Phone → Tap "Build Number" 7x
2. Settings → Developer Options → USB Debugging → ON
3. Connect USB cable → Authorize on device
```

### 4. Run

**GUI Mode (Recommended):**
```bash
source .venv/bin/activate
python3 -m niu_cast.core
```

**CLI Mode:**
```bash
# Info device
python3 -m niu_cast.mini --info

# Screenshot
python3 -m niu_cast.mini --screenshot

# Game Mode
python3 -m niu_cast.mini --game-mode on
python3 -m niu_cast.mini --game-mode off

# Performance Monitor
python3 -m niu_cast.mini --monitor 10

# Interactive menu
python3 -m niu_cast.mini
```

---

## 🎮 CLI Menu

```
 1) Device Information
 2) Screenshot
 3) Screen Record
 4) Interactive Control
 5) Install APK
 6) Wireless Setup
 7) Live Preview
 8) 🎮 Game Mode (on/off)
 9) 📊 Performance Monitor
 0) Exit
```

### CLI Flags

| Flag | Description |
|------|-------------|
| `--info` | Show device info |
| `--screenshot` | Take screenshot |
| `--record [sec]` | Record screen (default 30s) |
| `--control` | Interactive control mode |
| `--wireless` | Enable ADB over TCP/IP |
| `--preview` | Live screen preview |
| `--install APK` | Install APK file |
| `--game-mode {on,off}` | Enable/disable game optimizations |
| `--monitor [sec]` | Monitor performance (default 10s) |
| `--device SERIAL` | Specify device serial |

---

## ⌨️ Keyboard Shortcuts

| Shortcut | Action |
|----------|--------|
| `Ctrl+H` / `Cmd+H` | Home |
| `Ctrl+B` / `Cmd+B` | Back |
| `Ctrl+R` / `Cmd+R` | Recent apps |
| `Ctrl+P` / `Cmd+P` | Power menu |
| `Ctrl+Up` / `Cmd+Up` | Volume Up |
| `Ctrl+Down` / `Cmd+Down` | Volume Down |
| `Ctrl+M` / `Cmd+M` | Mute |
| `Ctrl+S` / `Cmd+S` | Screenshot |
| `Ctrl+Shift+R` / `Cmd+Shift+R` | Start/stop recording |
| `Ctrl+Q` / `Cmd+Q` | Exit |

---

## 🎨 Themes

| Theme | Description |
|-------|-------------|
| `cyberpunk` | Neon cyan + magenta, dark grid background (default) |
| `genshin` | Teal + gold, star motifs, warm glow |
| `xarena` | Red accents, dark carbon, bold gaming |
| `valorant` | Red + white, minimal sharp edges |
| `lol` | Blue + gold, dark purple undertones |
| `minecraft` | Green + brown, pixel-style |

Switch via GUI dropdown di bottom bar.

---

## 📁 Project Structure

```
niu-cast/
├── niu_cast/
│   ├── __init__.py           # Package init (v1.1.1)
│   ├── core.py               # GUI — PyQt5 gaming theme + all integrations
│   ├── mini.py               # CLI — interactive + flags
│   ├── game_mode.py          # GameMode, PerformanceMonitor, GameLauncher
│   ├── shortcuts.py          # KeyboardShortcuts (15 hotkeys)
│   ├── theme_manager.py      # ThemeManager (6 themes)
│   └── batch.py              # Batch automation (YAML/JSON/Text)
├── .assets/
│   └── icon.svg              # NiuCast icon
├── CHANGELOG.md
├── requirements.txt
├── setup.py
└── README.md
```

---

## 🔧 Configuration

### Game Mode

Game Mode mengoptimasi device untuk gaming:
- Disable animations (window, transition, animator)
- Set GPU renderer ke OpenGL
- Kill background apps
- Set brightness maksimum
- Force GPU rendering

### Wireless ADB

```bash
# Via USB — enable TCP
adb tcpip 5555

# Connect via IP
adb connect <device_ip>:5555

# Lepas USB — device tetap terhubung via WiFi/data
```

---

## 🐛 Troubleshooting

| Problem | Solution |
|---------|----------|
| Device not found | Enable USB Debugging, authorize PC, ganti kabel |
| Black screen mirror | Wake device, unlock screen |
| Wireless fail | `adb tcpip 5555` via USB dulu, lalu `adb connect IP` |
| Game Mode error | Pastikan device terhubung & ADB authorized |
| ADB not found | `brew install android-platform-tools` atau `sudo apt install adb` |

---

## 📝 License

MIT License — See [LICENSE](LICENSE) for details.

---

## 🙏 Acknowledgments

- **scrcpy** — Inspiration for screen mirroring concept
- **Genshin Impact** — UI design inspiration
- **Xarena** — Gaming aesthetics reference
- **Cyberpunk 2077** — Color palette inspiration

---

<div align="center">

**Made with ❤️ by Niumination**

*Universal Android ADB Tool & Screen Mirroring*

</div>
