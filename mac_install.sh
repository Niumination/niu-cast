#!/bin/bash
#===============================================================================
# NIU CAST — macOS Native Installer
# Install aplikasi ke /Applications + CLI ke /usr/local/bin
#
# Usage:
#   ./mac_install.sh              # Install .app + CLI (default)
#   ./mac_install.sh --py2app     # Build standalone .app via py2app (lambat)
#   ./mac_install.sh --uninstall  # Hapus instalasi
#   ./mac_install.sh --help       # Info lengkap
#===============================================================================

set -e

REPO_DIR="$(cd "$(dirname "$0")" && pwd)"
APP_NAME="NIU CAST"
APP_BUNDLE="$APP_NAME.app"
DEST_APP="/Applications/$APP_BUNDLE"
CLI_NAME="niu-cast"
CLI_DEST="/usr/local/bin/$CLI_NAME"
CONFIG_DIR="$HOME/.niu-cast"
PLIST_DEST="$HOME/Library/Preferences/com.niumination.niucast.plist"

# ── Warna ──────────────────────────────────────
RED='\033[0;31m'
GREEN='\033[0;32m'
BLUE='\033[0;34m'
YELLOW='\033[1;33m'
NC='\033[0m'

info()  { echo -e "${BLUE}•${NC} $1"; }
ok()    { echo -e "${GREEN}✓${NC} $1"; }
warn()  { echo -e "${YELLOW}⚠${NC} $1"; }
err()   { echo -e "${RED}✗${NC} $1"; }
header(){ echo -e "\n${BLUE}══ $1 ══${NC}"; }

# ── Help ───────────────────────────────────────────────────────────────────────

if [ "$1" = "--help" ] || [ "$1" = "-h" ]; then
    echo "NIU CAST — macOS Native Installer v3.6.0"
    echo ""
    echo "Cara Install:"
    echo "  ./mac_install.sh              Install .app (lighter) + CLI symlink"
    echo "  ./mac_install.sh --py2app     Build standalone .app via py2app (heavy but portable)"
    echo ""
    echo "Lainnya:"
    echo "  ./mac_install.sh --uninstall  Hapus semua komponen yang diinstall"
    echo "  ./mac_install.sh --help       Tampilkan ini"
    echo ""
    echo "Setelah install:"
    echo "  • Buka 'NIU CAST' dari Launchpad / Applications"
    echo "  • Atau jalankan: niu-cast [command] dari terminal"
    echo "  • Update: git pull && ./mac_install.sh"
    exit 0
fi

# ── Uninstall ──────────────────────────────────────────────────────────────────

if [ "$1" = "--uninstall" ]; then
    header "UNINSTALL"
    
    # Kill running app
    if pgrep -f "NIU CAST" >/dev/null 2>&1; then
        info "Menutup NIU CAST..."
        pkill -f "NIU CAST" 2>/dev/null || true
        sleep 1
    fi
    
    # Remove .app
    if [ -d "$DEST_APP" ]; then
        rm -rf "$DEST_APP"
        ok "Hapus $DEST_APP"
    fi
    
    # Remove .app from user /Applications too
    USER_APP="$HOME/Applications/$APP_BUNDLE"
    if [ -d "$USER_APP" ]; then
        rm -rf "$USER_APP"
        ok "Hapus $USER_APP"
    fi
    
    # Remove CLI
    if [ -f "$CLI_DEST" ] || [ -L "$CLI_DEST" ]; then
        rm -f "$CLI_DEST"
        ok "Hapus $CLI_DEST"
    fi
    
    # Remove py2app build artifacts
    for d in build dist __pycache__; do
        [ -d "$REPO_DIR/$d" ] && rm -rf "$REPO_DIR/$d" && ok "Hapus $REPO_DIR/$d"
    done
    
    # Remove config (optional — tanya dulu)
    if [ -f "$CONFIG_DIR/mac-connect.json" ]; then
        warn "Config tetap disimpan di $CONFIG_DIR/"
        warn "Hapus manual: rm -rf $CONFIG_DIR"
    fi
    
    # Forget com.niumination.niucast
    if [ -f "$PLIST_DEST" ]; then
        rm -f "$PLIST_DEST"
        ok "Hapus preferences"
    fi
    
    ok "Uninstall selesai."
    exit 0
fi

# ── Prasyarat ──────────────────────────────────────────────────────────────────

header "PRASYARAT"

# Cek Python
PYTHON=""
for py in "/usr/local/bin/python3" "/opt/homebrew/bin/python3" "$(which python3 2>/dev/null)"; do
    [ -x "$py" ] && PYTHON="$py" && break
done
if [ -z "$PYTHON" ]; then
    PYTHON="$(which python3 2>/dev/null || which python 2>/dev/null)"
fi
if [ -z "$PYTHON" ]; then
    err "Python 3 tidak ditemukan. Install dulu: brew install python"
    exit 1
fi
ok "Python: $PYTHON"

# Cek ADB
if ! command -v adb &>/dev/null; then
    warn "ADB tidak ditemukan. Install: brew install android-platform-tools"
else
    ok "ADB: $(which adb)"
fi

# Cek scrcpy
if ! command -v scrcpy &>/dev/null; then
    warn "scrcpy tidak ditemukan. Install: brew install scrcpy"
else
    ok "scrcpy: $(which scrcpy)"
fi

# ── Install .app ───────────────────────────────────────────────────────────────

header "INSTALL .APP"

# Build .app dari template (kalau --py2app, build standalone)
if [ "$1" = "--py2app" ]; then
    info "Building standalone .app via py2app (mungkin 2-5 menit)..."
    
    # Install deps for py2app
    pip install py2app 2>/dev/null || pip3 install py2app 2>/dev/null || true
    
    cd "$REPO_DIR"
    rm -rf build dist
    
    # Run py2app build
    "$PYTHON" setup.py py2app 2>&1 | grep -v "^$"
    
    if [ -d "dist/$APP_BUNDLE" ]; then
        APP_SOURCE="dist/$APP_BUNDLE"
    else
        err "py2app build gagal — dist/$APP_BUNDLE not found"
        err "Cek error di atas. Fallback ke template .app..."
        APP_SOURCE="$REPO_DIR/macos/$APP_BUNDLE"
    fi
else
    info "Menggunakan template .app (lighter — symlinks ke repo)"
    APP_SOURCE="$REPO_DIR/macos/$APP_BUNDLE"
fi

# Hapus yang lama kalau ada
if [ -d "$DEST_APP" ]; then
    info "Menimpa instalasi lama..."
    rm -rf "$DEST_APP"
fi

# Copy
cp -R "$APP_SOURCE" "$DEST_APP"
ok "Installed: $DEST_APP"

# Bypass macOS Gatekeeper (app from unidentified developer)
xattr -d com.apple.quarantine "$DEST_APP" 2>/dev/null || true
ok "Gatekeeper: trusted"

# ── CLI Symlink ────────────────────────────────────────────────────────────────

header "CLI (% niu-cast [command])"

# Buat /usr/local/bin kalau belum ada
if [ ! -d "/usr/local/bin" ]; then
    sudo mkdir -p "/usr/local/bin"
fi

# Create CLI wrapper script
CLI_WRAPPER="$REPO_DIR/macos/$CLI_NAME"
cat > "$CLI_WRAPPER" << 'CLIEOF'
#!/bin/bash
# NIU CAST — CLI wrapper
REPO_DIR="$(cd "$(dirname "$0")/.." && pwd)"
cd "$REPO_DIR"

PYTHON=""
for py in "/usr/local/bin/python3" "/opt/homebrew/bin/python3" "$HOME/.hermes-portable/venv/bin/python3" "/usr/bin/python3"; do
    [ -x "$py" ] && PYTHON="$py" && break
done
[ -z "$PYTHON" ] && PYTHON="$(which python3 2>/dev/null || which python 2>/dev/null)"

exec "$PYTHON" -m niu_cast "$@"
CLIEOF
chmod +x "$CLI_WRAPPER"

# Install CLI ke PATH
CLI_TARGET=""
for dir in "$HOME/.local/bin" "$HOME/bin" "/usr/local/bin"; do
    if [ -d "$dir" ] && [ -w "$dir" ]; then
        CLI_TARGET="$dir/$CLI_NAME"
        break
    fi
done

if [ -z "$CLI_TARGET" ]; then
    # Fallback: try sudo for /usr/local/bin
    if [ -d "/usr/local/bin" ]; then
        if [ -L "/usr/local/bin/$CLI_NAME" ] || [ -f "/usr/local/bin/$CLI_NAME" ]; then
            rm -f "/usr/local/bin/$CLI_NAME"
        fi
        ln -sf "$CLI_WRAPPER" "/usr/local/bin/$CLI_NAME" 2>/dev/null && CLI_TARGET="/usr/local/bin/$CLI_NAME"
    fi
fi

# If still no target, use ~/.local/bin
if [ -z "$CLI_TARGET" ]; then
    mkdir -p "$HOME/.local/bin"
    CLI_TARGET="$HOME/.local/bin/$CLI_NAME"
    ln -sf "$CLI_WRAPPER" "$CLI_TARGET"
    warn "Tambahkan ~/.local/bin ke PATH jika belum:"
    warn '  echo '"'"'export PATH="$HOME/.local/bin:$PATH"'"'"' >> ~/.zshrc'
    warn '  source ~/.zshrc'
fi

ok "CLI: $CLI_TARGET → $CLI_WRAPPER"

# ── Config Directory ───────────────────────────────────────────────────────────

header "KONFIGURASI"

mkdir -p "$CONFIG_DIR"

# Symlink repo so .app can find it
if [ ! -L "$CONFIG_DIR/repo" ]; then
    ln -sf "$REPO_DIR" "$CONFIG_DIR/repo"
    ok "Repo symlink: $CONFIG_DIR/repo"
else
    ok "Repo symlink exists"
fi

# ── Selesai ────────────────────────────────────────────────────────────────────

header "INSTALLASI SELESAI 🎉"

echo -e "  ${GREEN}NIU CAST v3.6.0${NC} berhasil diinstall!"
echo ""
echo "  Cara pakai:"
echo "    • Buka ${BLUE}NIU CAST${NC} dari Launchpad / Applications"
echo "    • Terminal: ${BLUE}niu-cast${NC} ${YELLOW}[command]${NC}"
echo "    • Mac Connect: ${BLUE}niu-cast mc${NC} atau ${BLUE}niu-cast mirror${NC}"
echo "    • Help: ${BLUE}niu-cast --help${NC}"
echo ""
echo -e "  ${YELLOW}Update:${NC} cd $REPO_DIR && git pull && ./mac_install.sh"
echo ""
