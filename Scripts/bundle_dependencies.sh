#!/bin/bash
set -euo pipefail

cd "$(dirname "$0")/.."

echo "→ Bundling ADB..."
mkdir -p "App/Resources/adb/macos"

if command -v adb &> /dev/null; then
    cp "$(which adb)" "App/Resources/adb/macos/adb"
    echo "  ✅ ADB bundled: $(which adb)"
else
    echo "  ⚠️  ADB not found in PATH — install with: brew install android-platform-tools"
    exit 1
fi

echo "→ Bundling scrcpy-server..."
mkdir -p "App/Resources/scrcpy"

if [ -f "$HOME/.cache/scrcpy/scrcpy-server" ]; then
    cp "$HOME/.cache/scrcpy/scrcpy-server" "App/Resources/scrcpy/scrcpy-server.jar"
    echo "  ✅ scrcpy-server bundled"
else
    echo "  ⚠️  scrcpy-server not found — install scrcpy: brew install scrcpy"
    echo "     Then run scrcpy once to download the server"
fi

echo ""
echo "Done. Run 'xcodegen generate' to regenerate the Xcode project."
