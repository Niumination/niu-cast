# Changelog

All notable changes to NiuCast Gaming Edition will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/).

## [1.1.1] - Module Integration - 2024-06-13

### 🔧 Integrated
- **Game Mode** → GUI (`core.py`): Toggle button di bottom bar + sidebar integration
- **Game Mode** → CLI (`mini.py`): `--game-mode on/off` + menu option 8
- **Performance Monitor** → GUI: Live CPU temp, battery, RAM di status bar
- **Performance Monitor** → CLI: `--monitor [sec]` + menu option 9
- **Theme Switcher** → GUI: QComboBox di bottom bar, 6 themes via ThemeManager
- **Keyboard Shortcuts** → GUI: 15 hotkeys via shortcuts.py registered to QShortcut
- **Game Launcher** → GUI: Dialog popup + LAUNCH GAME button di sidebar

### 🧹 Cleanup
- Graceful cleanup on device disconnect — perf_monitor stop, game_mode disable
- Graceful cleanup on window close — all monitors stopped
- Removed `_import .mini` from `__init__.py` to prevent RuntimeWarning
- Fixed indent error in `_disconnect_device`

### 📝 Updated
- README.md — complete rewrite with Gaming Edition features, updated CLI flags, keyboard shortcuts, themes table

## [1.1.0] - Gaming Edition - 2024-06-12

### 🎨 Added
- **Gaming Theme System** - Cyberpunk/Genshin/Xarena inspired UI
  - GamingTheme class with pre-defined color palettes
  - Custom widgets: GamingButton, GamingCard, StatusIndicator, GlowingLine, CircularButton
  - Gradient borders with glow effects
  - Animated pulsing status indicators
- **Multiple Theme Support** - ThemeManager for switching themes
  - Cyberpunk 2077 (default)
  - Genshin Impact
  - Xarena Gaming
  - Valorant
  - League of Legends
  - Minecraft
- **Keyboard Shortcuts** - Pre-configured hotkeys
  - Navigation: Home, Back, Recents, Power
  - Volume: Up, Down, Mute
  - Capture: Screenshot, Record
  - Mac/Windows compatible shortcuts

### ⚡ Added
- **Game Mode** - Mobile gaming optimizations
  - Disable animations for performance
  - Boost GPU settings
  - Kill background apps
  - Max brightness for gaming
  - Performance monitor
- **Game Launcher** - Quick launch popular games
  - Genshin Impact, PUBG Mobile, Free Fire
  - Mobile Legends, Call of Duty
  - And 7 more popular games

### 🖥️ Added
- **Touch Input Simulation**
  - Click on stream → Tap on device
  - Drag on stream → Swipe on device
  - Coordinate scaling for any resolution
- **Real-time FPS Counter**
  - Live FPS display
  - Performance tracking

### 🔧 Changed
- **UI/UX Overhaul**
  - Dark theme with neon accents
  - Gaming-styled buttons
  - Card-based layout
  - Sidebar navigation
  - Status bar integration
- **Video Streaming**
  - Optimized screencap loop
  - ~60 FPS streaming capability
  - FPS tracking and display

### 📝 Updated
- README.md with gaming preview ASCII art
- requirements.txt with core dependencies
- setup.py with proper entry points
- Shell scripts with gaming ASCII art banners

---

## [1.0.0] - Initial Release - 2024-06-12

### 🎉 Added
- Basic screen mirroring via ADB
- Screenshot capture
- Screen recording
- APK installation
- Wireless ADB support
- CLI and GUI modes
- Batch automation scripts
- ADB helper toolkit

---

## [Unreleased]

### Planned Features
- [ ] Real video streaming (scrcpy-style)
- [ ] Audio streaming support
- [ ] Clipboard sync
- [ ] File drag & drop
- [ ] Multi-device support
- [ ] Recording with audio
- [ ] Custom themes editor

---

## Contributing

When adding new features:
1. Add entry to this changelog
2. Update version in `__init__.py`
3. Update README.md if needed
4. Test thoroughly

---

**Legend:**
- 🎨 Added - New UI/Visual features
- ⚡ Added - Performance/Optimization features  
- 🖥️ Added - Core functionality
- 🔧 Changed - Modified existing features
- 📝 Updated - Documentation changes
- 🔨 Fixed - Bug fixes