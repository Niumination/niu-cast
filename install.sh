#!/bin/bash
# ═══════════════════════════════════════════════════════════════════════════════
#                    NIU CAST - SETUP SCRIPT
# ═══════════════════════════════════════════════════════════════════════════════
# Agent: Hermes + DeepSeek-V4-Flash
# ═══════════════════════════════════════════════════════════════════════════════

set -e

echo "╔════════════════════════════════════════════════════════════════╗"
echo "║           NIU CAST - Installation Script                    ║"
echo "╠════════════════════════════════════════════════════════════════╣"
echo "╚════════════════════════════════════════════════════════════════╝"
echo ""

# Colors
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
RED='\033[0;31m'
NC='\033[0m' # No Color

# Check Python
echo -e "${YELLOW}[*] Checking Python version...${NC}"
PYTHON_VERSION=$(python3 --version 2>&1 | cut -d' ' -f2 | cut -d'.' -f1,2)
echo "    Found Python $PYTHON_VERSION"

if [[ $(echo "$PYTHON_VERSION < 3.8" | bc -l 2>/dev/null || echo "0") -eq 1 ]]; then
    echo -e "${RED}[!] Python 3.8+ required${NC}"
    exit 1
fi

# Check if pip available
if ! command -v pip3 &> /dev/null; then
    echo -e "${RED}[!] pip3 not found${NC}"
    exit 1
fi

# Create virtual environment (optional but recommended)
if [ ! -d "venv" ]; then
    echo -e "${YELLOW}[*] Creating virtual environment...${NC}"
    python3 -m venv venv
fi

# Activate venv
echo -e "${YELLOW}[*] Activating virtual environment...${NC}"
source venv/bin/activate

# Upgrade pip
echo -e "${YELLOW}[*] Upgrading pip...${NC}"
pip install --upgrade pip

# Install dependencies
echo -e "${YELLOW}[*] Installing dependencies...${NC}"
pip install -r requirements.txt

# Check ADB
echo -e "${YELLOW}[*] Checking ADB...${NC}"
if command -v adb &> /dev/null; then
    echo -e "${GREEN}[+] ADB found: $(which adb)${NC}"
    adb version
else
    echo -e "${YELLOW}[!] ADB not found in PATH${NC}"
    echo "    Please install Android SDK Platform Tools"
    echo "    Or set ANDROID_HOME environment variable"
fi

# Create directories
echo -e "${YELLOW}[*] Creating directories...${NC}"
mkdir -p ~/.hermes-cast/screenshots
mkdir -p ~/.hermes-cast/recordings
mkdir -p /tmp/hermes-cast

# Make scripts executable
chmod +x niu_cast.py
chmod +x quick_mirror.sh
chmod +x adb_helper.sh

echo ""
echo -e "${GREEN}╔════════════════════════════════════════════════════════════════╗"
echo "║                  INSTALLATION COMPLETE!                        ║"
echo "╠════════════════════════════════════════════════════════════════╣"
echo "║                                                                ║"
echo "║  To run NiuCast:                                            ║"
echo "║                                                                ║"
echo "║  1. GUI Mode (with screen mirroring):                          ║"
echo "║     source venv/bin/activate                                   ║"
echo "║     python3 niu_cast.py                                     ║"
echo "║                                                                ║"
echo "║  2. Quick mirror (CLI):                                        ║"
echo "║     ./quick_mirror.sh                                          ║"
echo "║                                                                ║"
echo "║  3. ADB helper:                                                ║"
echo "║     ./adb_helper.sh                                            ║"
echo "║                                                                ║"
echo "╚════════════════════════════════════════════════════════════════╝"
echo ""
echo "      and you have authorized this computer for USB debugging."
echo ""