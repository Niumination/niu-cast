# <img src="https://raw.githubusercontent.com/niumination/niu-cast/main/.assets/icon.svg" width="40" /> NIU CAST

<div align="center">

**⚡ Gaming Edition • Universal Android ADB Tool & Screen Mirroring ⚡**

*Inspired by Genshin Impact, Xarena, and Cyberpunk aesthetics*

![Version](https://img.shields.io/badge/version-1.1.0-blue)
![Python](https://img.shields.io/badge/python-3.8+-green)
![Platform](https://img.shields.io/badge/platform-macOS%20|%20Linux%20|%20Windows-orange)

</div>

---

## 🎮 Overview

**NiuCast** adalah toolkit Android universal berbasis ADB dengan desain gaming-inspired. Fitur utama:

- 📱 **Real-time Screen Mirroring** - Display layar Android di Mac/PC
- 🖱️ **Touch Input Simulation** - Klik di mirror → tap di device
- 📷 **Screenshot & Recording** - Dokumentasi layar instan
- 📦 **APK Installation** - Drag & drop install
- 🔗 **Wireless Connection** - ADB over WiFi
- ⚡ **Batch Automation** - Script YAML/JSON/Text

```
┌──────────────────┐     USB/WiFi      ┌──────────────────┐
│  Android Device  │ ←───────────────→  │  Host Computer   │
│   Infinix GT 30   │     ADB Protocol   │   ThinkPad X13    │
│      Pro          │                   │   Yoga Gen 1      │
└──────────────────┘                   └──────────────────┘
```

---

## ✨ Features

### 🎨 Gaming UI Theme
- **Cyberpunk-inspired** dark theme dengan neon accents
- **Genshin Impact-style** gradient borders dan glow effects
- **Xarena-inspired** sleek control buttons
- **Animated** status indicators dan transitions

### Core Features
| Feature | Description |
|---------|-------------|
| 📱 Live Stream | Real-time ~60 FPS screen mirroring |
| 🖱️ Touch Input | Click/swipe on mirror → device response |
| 📷 Screenshot | One-click capture dengan instant preview |
| 🎥 Recording | Screen record hingga 180 detik |
| 📦 APK Install | Drag & drop atau file picker |
| 🔗 Wireless | ADB over WiFi tanpa USB |

### Advanced Features
| Feature | Description |
|---------|-------------|
| 🎮 Control Panel | Virtual buttons untuk navigasi |
| 📋 Batch Mode | Automation scripts (YAML/JSON) |
| 🔧 CLI Mode | Lightweight terminal interface |
| 🌐 Network Tools | WiFi configuration, ping test |
| 🔋 Battery Monitor | Detailed battery status |

---

## 🚀 Quick Start

### 1. Installation

```bash
# Clone repository
git clone https://github.com/niumination/niu-cast.git
cd niu-cast

# Create virtual environment
python3 -m venv .venv
source .venv/bin/activate  # Linux/macOS
# .\.venv\Scripts\activate   # Windows

# Install dependencies
pip install -r requirements.txt
```

### 2. Device Setup (Android)

```
1. Settings → About Phone → Tap "Build Number" 7 times
2. Settings → Developer Options → USB Debugging → ON
3. Connect USB cable to computer
4. Authorize USB debugging when prompted
```

### 3. Run Application

**GUI Mode (Recommended):**
```bash
python3 -m niu_cast.core
# atau
source .venv/bin/activate
python niu_cast/core.py
```

**CLI Mode:**
```bash
python3 -m niu_cast.mini --info
python3 -m niu_cast.mini --screenshot
python3 -m niu_cast.mini --control
```

**Quick Scripts:**
```bash
chmod +x quick_mirror.sh
./quick_mirror.sh           # Interactive CLI menu

chmod +x adb_helper.sh
./adb_helper.sh             # Full ADB toolkit
```

---

## 🎨 UI Preview

### Gaming Theme Design

```
┌─────────────────────────────────────────────────────────────────┐
│  ⚡ NIU CAST                                                     │
│  v1.1.0 • Gaming Edition                                        │
│  ══════════════════════════════════════════════════════════════│
│                                                                  │
│  📱 DEVICE CONNECTION                                           │
│  ┌─────────────────────────────────────────┐                   │
│  │ [Device Dropdown              ▼]        │                   │
│  │ [🔄 Refresh]    [⚡ CONNECT]            │                   │
│  └─────────────────────────────────────────┘                   │
│                                                                  │
│  Status: 🔴 Disconnected                                         │
│  Model:  --                                                      │
│  FPS:    --                                                      │
│                                                                  │
│  ══════════════════════════════════════════════════════════════│
│                                                                  │
│  ⚙️ QUICK CONTROLS                                               │
│  ┌─────────────────────────────────────────┐                   │
│  │  [🏠]  [⬅️]  [⏻]     |  [🔊]  [🔉]  [📷] │                   │
│  └─────────────────────────────────────────┘                   │
└─────────────────────────────────────────────────────────────────┘

┌─────────────────────────────────────────────────────────────────┐
│  📺 LIVE STREAM                              Resolution: 1080x2400│
│  ┌────────────────────────────────────────────────────────────┐│
│  │                                                            ││
│  │                    [ANDROID SCREEN]                        ││
│  │                                                            ││
│  │           Click anywhere to tap device                     ││
│  │           Drag to swipe                                    ││
│  │                                                            ││
│  └────────────────────────────────────────────────────────────┘│
│                                                                  │
│  [⏺ REC]  [📦 INSTALL APK]  [🔗 WIRELESS]         [✕ EXIT]   │
└─────────────────────────────────────────────────────────────────┘
```

---

## 🎮 Controls

### Quick Keys
| Action | Description |
|--------|-------------|
| Click on Stream | Tap at position |
| Drag on Stream | Swipe gesture |
| 🏠 Home | Go to home screen |
| ⬅️ Back | Press back button |
| ⏻ Power | Power menu |
| 🔊 Volume | Volume controls |

### CLI Commands
```bash
# Interactive control
python3 -m niu_cast.mini --control

# Within control mode:
home, back, menu, power        # Key events
tap X Y                        # Tap at coordinates
swipe X1 Y1 X2 Y2 [duration]   # Swipe gesture
type TEXT                      # Type text
screenshot                     # Take screenshot
record [sec]                   # Record screen
exit                           # Exit control mode
```

---

## 📁 Project Structure

```
niu-cast/
├── niu_cast/
│   ├── __init__.py           # Package init
│   ├── core.py               # Main GUI (PyQt5 gaming theme)
│   ├── mini.py               # CLI interface
│   └── batch.py              # Automation executor
├── quick_mirror.sh           # Interactive CLI script
├── adb_helper.sh             # Full ADB toolkit
├── install.sh                # Installation script
├── requirements.txt          # Python dependencies
├── setup.py                  # pip installable
└── README.md                 # Documentation
```

---

## 🔧 Configuration

### Environment Variables
```bash
# Optional: Custom ADB path
export NIU_ADB_PATH=/custom/path/to/adb

# Optional: Default save directory
export NIU_SCREENSHOT_DIR=~/Screenshots
export NIU_RECORDING_DIR=~/Videos
```

### Custom Themes
Edit `GamingTheme` class in `core.py` to customize colors:

```python
class GamingTheme:
    BG_DARK = "#0D0D1A"           # Background
    CYAN_PRIMARY = "#00F5FF"      # Primary accent
    MAGENTA_ACCENT = "#FF00FF"    # Secondary accent
    GOLD_ACCENT = "#FFD700"       # Highlight
    # ... more colors
```

---

## 🐛 Troubleshooting

### Device Not Found
```
✗ No device connected
```
**Solutions:**
1. Enable USB Debugging in Developer Options
2. Authorize this computer on device
3. Try different USB cable
4. Restart ADB: `adb kill-server && adb start-server`

### Black Screen on Mirror
**Solutions:**
1. Wake up device screen
2. Unlock device
3. Check if screen capture is blocked

### Performance Issues
**Tips:**
1. Use USB instead of WiFi for lower latency
2. Close background apps on Android
3. Reduce mirror window size
4. Disable battery optimization for screen capture

---

## 🤝 Contributing

Contributions welcome! Please:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit changes (`git commit -m 'Add amazing feature'`)
4. Push to branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

---

## 📝 License

MIT License - See [LICENSE](LICENSE) for details.

---

## 🙏 Acknowledgments

- **scrcpy** - Inspiration for screen mirroring concept
- **Genshin Impact** - UI design inspiration
- **Xarena** - Gaming aesthetics reference
- **Cyberpunk 2077** - Color palette inspiration

---

<div align="center">

**Made with ❤️ by Niumination**

*Universal Android ADB Tool & Screen Mirroring*

**⚡ Gaming Edition ⚡**

</div>