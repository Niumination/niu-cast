#!/bin/bash
# ═══════════════════════════════════════════════════════════════════════════════
#                    QUICK MIRROR - Simple Screen Mirroring
# ═══════════════════════════════════════════════════════════════════════════════
# ═══════════════════════════════════════════════════════════════════════════════

# Colors
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
CYAN='\033[0;36m'
NC='\033[0m'

clear
echo -e "${CYAN}"
echo "╔════════════════════════════════════════════════════════════════╗"
echo "║          NIU CAST - Quick Mirror                            ║"
echo "╠════════════════════════════════════════════════════════════════╣"
echo "╚════════════════════════════════════════════════════════════════╝"
echo -e "${NC}"

# Check ADB
check_adb() {
    if ! command -v adb &> /dev/null; then
        echo -e "${RED}✗ ADB not found!${NC}"
        echo "  Please install Android SDK Platform Tools"
        echo "  Download from: https://developer.android.com/studio/releases/platform-tools"
        exit 1
    fi
}

# Check device connection
check_device() {
    DEVICES=$(adb devices 2>/dev/null | grep -c "device$" || echo "0")
    if [ "$DEVICES" -eq 0 ]; then
        echo -e "${RED}✗ No device connected!${NC}"
        echo ""
        echo "  1. Enable USB Debugging in Developer Options"
        echo "  2. Authorize this computer for USB debugging"
        echo ""
        echo "To enable Developer Options:"
        echo "  Settings > About Phone > Tap 'Build Number' 7 times"
        exit 1
    fi
}

# Main menu
show_menu() {
    echo ""
    echo -e "${YELLOW}Select option:${NC}"
    echo "  1) Start Screen Mirror (screencap loop)"
    echo "  2) Take Screenshot"
    echo "  3) Start Screen Recording"
    echo "  4) Control Device (Interactive)"
    echo "  5) Install APK"
    echo "  6) Device Info"
    echo "  7) Exit"
    echo ""
    echo -n "Enter choice [1-7]: "
    read choice
}

# Start mirror
start_mirror() {
    echo -e "${GREEN}▶ Starting screen mirror...${NC}"
    echo "Press Ctrl+C to stop"
    echo ""
    
    # Create temp directory
    mkdir -p /tmp/hermes-mirror
    
    # Mirror loop
    while true; do
        # Capture screen
        adb shell screencap -p /sdcard/screen.png 2>/dev/null
        adb pull /sdcard/screen.png /tmp/hermes-mirror/screen.png 2>/dev/null
        
        # Check if image exists and show it
        if [ -f /tmp/hermes-mirror/screen.png ]; then
            # You can use various image viewers here
            # For now, we'll just capture frames
            echo -ne "\r$(date +%H:%M:%S) - Frame captured: $(ls -lh /tmp/hermes-mirror/screen.png | awk '{print $5}')  "
        fi
        
        sleep 0.033  # ~30 FPS
    done
}

# Take screenshot
take_screenshot() {
    TIMESTAMP=$(date +%Y%m%d_%H%M%S)
    SCREENSHOT_PATH="$HOME/Pictures/hermes-screenshot-$TIMESTAMP.png"
    
    echo -e "${GREEN}📷 Taking screenshot...${NC}"
    
    adb shell screencap -p /sdcard/screenshot.png 2>/dev/null
    adb pull /sdcard/screenshot.png "$SCREENSHOT_PATH" 2>/dev/null
    adb shell rm /sdcard/screenshot.png 2>/dev/null
    
    if [ -f "$SCREENSHOT_PATH" ]; then
        echo -e "${GREEN}✓ Screenshot saved: $SCREENSHOT_PATH${NC}"
        
        # Open with default image viewer
        if command -v xdg-open &> /dev/null; then
            xdg-open "$SCREENSHOT_PATH" &
        elif command -v open &> /dev/null; then
            open "$SCREENSHOT_PATH" &
        fi
    else
        echo -e "${RED}✗ Failed to capture screenshot${NC}"
    fi
}

# Screen recording
start_recording() {
    TIMESTAMP=$(date +%Y%m%d_%H%M%S)
    RECORD_PATH="$HOME/Videos/hermes-recording-$TIMESTAMP.mp4"
    
    echo -e "${GREEN}⏺ Starting screen recording...${NC}"
    echo "Press Ctrl+C to stop and save"
    echo ""
    
    # Ensure Videos directory exists
    mkdir -p "$HOME/Videos"
    
    adb shell screenrecord /sdcard/recording.mp4 &
    ADB_PID=$!
    
    # Monitor recording
    while true; do
        echo -ne "\r$(date +%H:%M:%S) - Recording..."
        sleep 1
    done
    
    # Stop recording on Ctrl+C
    trap "kill $ADB_PID 2>/dev/null; echo ''; echo 'Stopping recording...'" SIGINT
    
    wait $ADB_PID
    
    # Pull recording
    echo -e "${GREEN}Pulling recording...${NC}"
    adb pull /sdcard/recording.mp4 "$RECORD_PATH" 2>/dev/null
    adb shell rm /sdcard/recording.mp4 2>/dev/null
    
    if [ -f "$RECORD_PATH" ]; then
        echo -e "${GREEN}✓ Recording saved: $RECORD_PATH${NC}"
    fi
}

# Interactive control
interactive_control() {
    echo -e "${GREEN}🎮 Interactive Control Mode${NC}"
    echo "Commands:"
    echo "  home      - Go to home screen"
    echo "  back      - Press back button"
    echo "  menu      - Open menu"
    echo "  power     - Power button"
    echo "  vol-up    - Volume up"
    echo "  vol-down  - Volume down"
    echo "  swipe-up  - Swipe up (home)"
    echo "  swipe-down - Recent apps"
    echo "  tap X Y   - Tap at coordinates"
    echo "  type TEXT - Type text"
    echo "  exit      - Exit control mode"
    echo ""
    
    while true; do
        echo -n "hermes$ "
        read cmd args
        
        case $cmd in
            home)
                adb shell input keyevent KEYCODE_HOME
                ;;
            back)
                adb shell input keyevent KEYCODE_BACK
                ;;
            menu)
                adb shell input keyevent KEYCODE_MENU
                ;;
            power)
                adb shell input keyevent KEYCODE_POWER
                ;;
            vol-up)
                adb shell input keyevent KEYCODE_VOLUME_UP
                ;;
            vol-down)
                adb shell input keyevent KEYCODE_VOLUME_DOWN
                ;;
            swipe-up)
                adb shell input swipe 540 1800 540 200
                ;;
            swipe-down)
                adb shell input swipe 540 200 540 1800
                ;;
            tap)
                adb shell input tap $args
                ;;
            type)
                adb shell input text "$args"
                ;;
            exit)
                break
                ;;
            *)
                echo "Unknown command: $cmd"
                ;;
        esac
    done
}

# Install APK
install_apk() {
    echo -n "Enter APK path: "
    read apk_path
    
    if [ ! -f "$apk_path" ]; then
        echo -e "${RED}✗ File not found: $apk_path${NC}"
        return
    fi
    
    echo -e "${GREEN}📦 Installing $apk_path...${NC}"
    adb install -r "$apk_path"
    
    if [ $? -eq 0 ]; then
        echo -e "${GREEN}✓ Installation complete!${NC}"
    else
        echo -e "${RED}✗ Installation failed${NC}"
    fi
}

# Device info
show_device_info() {
    echo -e "${GREEN}📱 Device Information:${NC}"
    echo ""
    
    MODEL=$(adb shell getprop ro.product.model 2>/dev/null | tr -d '\r')
    MANUFACTURER=$(adb shell getprop ro.product.manufacturer 2>/dev/null | tr -d '\r')
    ANDROID=$(adb shell getprop ro.build.version.release 2>/dev/null | tr -d '\r')
    SDK=$(adb shell getprop ro.build.version.sdk 2>/dev/null | tr -d '\r')
    SCREEN=$(adb shell wm size 2>/dev/null | grep -oP '\d+x\d+' | head -1)
    BATTERY=$(adb shell dumpsys battery 2>/dev/null | grep level | awk '{print $2}')
    
    echo "  Manufacturer: $MANUFACTURER"
    echo "  Model: $MODEL"
    echo "  Android: $ANDROID (SDK $SDK)"
    echo "  Screen: $SCREEN"
    echo "  Battery: $BATTERY%"
    echo ""
    
    # IP Address
    IP=$(adb shell ip route 2>/dev/null | grep wlan0 | awk '{print $9}' | head -1)
    if [ -n "$IP" ]; then
        echo "  WiFi IP: $IP"
    fi
}

# Main execution
main() {
    check_adb
    check_device
    
    while true; do
        show_menu
        
        case $choice in
            1)
                start_mirror
                ;;
            2)
                take_screenshot
                ;;
            3)
                start_recording
                ;;
            4)
                interactive_control
                ;;
            5)
                install_apk
                ;;
            6)
                show_device_info
                ;;
            7)
                echo -e "${GREEN}Goodbye!${NC}"
                exit 0
                ;;
            *)
                echo -e "${RED}Invalid choice${NC}"
                ;;
        esac
    done
}

main