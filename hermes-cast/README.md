# 🏆 HermesCast - Screen Mirroring Application

<div align="center">

**For Android ↔ Hackintosh (ThinkPad X13 Yoga Gen 1)**

*Built with Hermes Agent + DeepSeek-V4-Flash*

![Version](https://img.shields.io/badge/version-1.0.0-blue)
![Python](https://img.shields.io/badge/python-3.8+-green)
![Platform](https://img.shields.io/badge/platform-Mac%20Tahoe-orange)

</div>

---

## 📋 Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Requirements](#requirements)
- [Installation](#installation)
- [Quick Start](#quick-start)
- [Usage](#usage)
- [Troubleshooting](#troubleshooting)
- [Architecture](#architecture)

---

## 🎯 Overview

**HermesCast** adalah aplikasi screen mirroring yang memungkinkan kamu menampilkan dan mengontrol layar Android (Infinix GT 30 Pro) dari ThinkPad X13 Yoga Gen 1 yang menjalankan Hackintosh Mac Tahoe.

Mirip dengan **scrcpy**, tapi dengan fitur tambahan dan interface yang lebih user-friendly.

```
┌─────────────────────┐      USB/WiFi      ┌─────────────────────┐
│   Infinix GT 30 Pro  │ ←───────────────→  │  ThinkPad X13 Yoga  │
│    (Android 14)      │     ADB Protocol   │    (Hackintosh)     │
└─────────────────────┘                    └─────────────────────┘
```

---

## ✨ Features

### Core Features
- 📱 **Real-time Screen Mirroring** - Display Android screen di Mac
- 🎮 **Remote Control** - Kontrol device dari keyboard/mouse
- 📷 **Screenshot** - Ambil screenshot dengan satu klik
- 🎥 **Screen Recording** - Rekam layar untuk berbagai keperluan
- 📦 **APK Installation** - Install aplikasi langsung dari Mac

### Advanced Features
- 🔄 **Wireless Connection** - Koneksi via WiFi (tanpa USB)
- 📁 **File Transfer** - Pull/Push file antara device
- 🔋 **Battery Monitoring** - Monitor status baterai
- 🌐 **Network Tools** - Ping, IP configuration, dll
- 📋 **Log Viewer** - View real-time logs

### Developer Tools
- 🔧 **Shell Access** - Direct ADB shell command
- 📊 **System Info** - Detailed device information
- 🎛️ **Input Simulation** - Send keyevents dan gestures

---

## 📦 Requirements

### Hardware
- **Host**: ThinkPad X13 Yoga Gen 1 (Hackintosh)
- **Target**: Infinix GT 30 Pro (Android 14)
- **Cable**: USB-C to USB-A/C untuk koneksi awal

### Software
- Python 3.8+
- ADB (Android Debug Bridge)
- PyQt5 (untuk GUI mode)

### Android Device Settings
1. **Developer Options** enabled
2. **USB Debugging** enabled
3. **USB Authorization** given untuk komputer ini

---

## 🚀 Installation

### Step 1: Clone atau Download

```bash
# Jika di repo
git clone <repository-url> hermes-cast
cd hermes-cast

# Atau extract manual
unzip hermes-cast.zip
cd hermes-cast
```

### Step 2: Install Dependencies

```bash
# Method 1: Using install script (recommended)
chmod +x install.sh
./install.sh

# Method 2: Manual installation
python3 -m venv venv
source venv/bin/activate
pip install -r requirements.txt

# Method 3: System-wide (not recommended)
pip3 install PyQt5 opencv-python numpy
```

### Step 3: Install ADB (jika belum ada)

**macOS (Homebrew):**
```bash
brew install android-platform-tools
```

**Linux:**
```bash
sudo apt install adb          # Debian/Ubuntu
sudo yum install android-tools # Fedora
```

**Windows:**
Download dari [Android Developer](https://developer.android.com/studio/releases/platform-tools)

---

## ⚡ Quick Start

### Option 1: GUI Mode (Recommended)

```bash
cd hermes-cast
source venv/bin/activate
python3 hermes_cast.py
```

### Option 2: CLI Quick Mirror

```bash
cd hermes-cast
chmod +x quick_mirror.sh
./quick_mirror.sh
```

### Option 3: ADB Helper

```bash
cd hermes-cast
chmod +x adb_helper.sh
./adb_helper.sh
```

---

## 📖 Usage

### First Time Setup

1. **Connect Device via USB**
2. **Enable Developer Options** di Infinix GT 30 Pro:
   - Settings → About Phone → Tap "Build Number" 7 times
3. **Enable USB Debugging**:
   - Settings → Developer Options → USB Debugging → ON
4. **Authorize Computer**:
   - Saat muncul popup "Allow USB debugging?", pilih "Allow"
5. **Test Connection**:
   ```bash
   adb devices
   # Should show: XXXXXXXXXX device
   ```

### Using HermesCast GUI

1. Jalankan aplikasi:
   ```bash
   python3 hermes_cast.py
   ```

2. **Connect Tab**:
   - Klik "Refresh Devices" untuk scan devices
   - Pilih device dari dropdown
   - Klik "Connect"

3. **Mirror Tab**:
   - Layar device akan tampil di window
   - Klik pada layar untuk mengontrol device

4. **Control Tab**:
   - Tombol virtual untuk kontrol
   - Screenshot, Recording, Install APK

### Using CLI Tools

#### Quick Mirror
```bash
./quick_mirror.sh
# Menu:
# 1) Start Screen Mirror
# 2) Take Screenshot
# 3) Start Recording
# 4) Interactive Control
# 5) Install APK
# 6) Device Info
```

#### ADB Helper
```bash
./adb_helper.sh
# Full menu dengan semua fitur ADB
```

### Common Commands

```bash
# Screenshot
adb shell screencap -p /sdcard/screen.png
adb pull /sdcard/screen.png ~/Pictures/

# Screen Recording (max 180 detik)
adb shell screenrecord --time-limit 60 /sdcard/video.mp4
adb pull /sdcard/video.mp4 ~/Videos/

# Install APK
adb install -r app.apk

# Reboot
adb reboot
adb reboot recovery
adb reboot bootloader
```

### Input Commands

```bash
# Keyevents
adb shell input keyevent KEYCODE_HOME
adb shell input keyevent KEYCODE_BACK
adb shell input keyevent KEYCODE_POWER

# Text input
adb shell input text "Hello World"

# Tap
adb shell input tap 540 960

# Swipe
adb shell input swipe 540 1800 540 200 300
```

---

## 🔧 Troubleshooting

### Device Not Found

```
✗ No device connected
```

**Solutions:**
1. Check USB cable connection
2. Enable USB Debugging
3. Authorize computer on device
4. Restart ADB server:
   ```bash
   adb kill-server
   adb start-server
   adb devices
   ```

### ADB Not Found

```
adb: command not found
```

**Solutions:**
1. Install ADB (see Installation section)
2. Add ADB to PATH:
   ```bash
   export PATH=$PATH:/path/to/platform-tools
   ```

### Permission Denied

```
error: device unauthorized
```

**Solution:**
1. Disconnect USB
2. Revoke USB debugging authorizations on device
3. Reconnect USB
4. Allow USB debugging when prompted

### Black Screen on Mirror

**Solutions:**
1. Check if screen is off (press power)
2. Unlock device
3. Kill and restart capture

### Performance Issues

**Tips:**
1. Use USB instead of WiFi for lower latency
2. Reduce mirror resolution in settings
3. Close other apps on Android device
4. Disable battery saver for screen capture app

---

## 🏗️ Architecture

```
hermes-cast/
├── hermes_cast.py      # Main GUI application (PyQt5)
├── requirements.txt    # Python dependencies
├── install.sh          # Installation script
├── quick_mirror.sh     # CLI quick mirror tool
├── adb_helper.sh       # ADB helper CLI tool
└── README.md           # Documentation

Classes:
├── ADBController       # ADB communication handler
├── ScreenCaptureThread # Screen capture worker thread
└── HermesCastWindow    # Main GUI window
```

### Flow Diagram

```
┌──────────────┐     ADB      ┌──────────────┐
│   Android    │◄────────────►│   Mac/Host   │
│   Device     │              │              │
└──────┬───────┘              └──────┬───────┘
       │                             │
       │ screencap                   │ display
       │                             │
   ┌───▼───┐                     ┌───▼───┐
   │ Frame │                     │  UI   │
   │ Capture│                     │ Window│
   └───────┘                     └───────┘
```

---

## 🎨 Customization

### Change Mirror Quality

Edit `hermes_cast.py`:
```python
# Change FPS
self.capture_thread = ScreenCaptureThread(self.adb, fps=60)

# Change resolution
cv2.resize(frame, (1080, 2400))  # Full resolution
```

### Add Custom Shortcuts

Edit shortcut mappings in `hermes_cast.py`:
```python
# Find this section and add your shortcuts
shortcuts = {
    'Ctrl+H': 'KEYCODE_HOME',
    'Ctrl+B': 'KEYCODE_BACK',
    # Add more...
}
```

---

## 📝 License

This project is built by **Hermes Agent** with **DeepSeek-V4-Flash** for personal use.

---

## 🤝 Contributing

Contributions welcome! Please:
1. Fork the repo
2. Create a feature branch
3. Submit a pull request

---

## 📞 Support

For issues or questions:
1. Check [Troubleshooting](#troubleshooting) section
2. Check ADB documentation
3. Check scrcpy documentation for comparison

---

<div align="center">

**Made with ❤️ by Hermes Agent + DeepSeek-V4-Flash**

*Target: Infinix GT 30 Pro ↔ ThinkPad X13 Yoga Gen 1*

</div>