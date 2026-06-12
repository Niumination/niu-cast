#!/bin/bash
# ═══════════════════════════════════════════════════════════════════════════════
#                         ADB HELPER TOOL
# ═══════════════════════════════════════════════════════════════════════════════
# Helper script untuk berbagai fungsi ADB
# ═══════════════════════════════════════════════════════════════════════════════

# Colors
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
CYAN='\033[0;36m'
BOLD='\033[1m'
NC='\033[0m'

# ═══════════════════════════════════════════════════════════════════════════════
#                             UTILITY FUNCTIONS
# ═══════════════════════════════════════════════════════════════════════════════

print_header() {
    echo -e "${CYAN}"
    echo "╔════════════════════════════════════════════════════════════════╗"
    echo "║              NIU CAST - ADB Helper Tool                    ║"
    echo "╠════════════════════════════════════════════════════════════════╣"
    echo "╚════════════════════════════════════════════════════════════════╝"
    echo -e "${NC}"
}

check_connection() {
    if ! adb devices 2>/dev/null | grep -q "device$"; then
        echo -e "${RED}✗ No device connected${NC}"
        return 1
    fi
    return 0
}

# ═══════════════════════════════════════════════════════════════════════════════
#                           MENU FUNCTIONS
# ═══════════════════════════════════════════════════════════════════════════════

# Device Info
show_device_info() {
    echo -e "${GREEN}📱 Device Information${NC}"
    echo "─────────────────────────────────"
    
    echo -e "${BOLD}Basic Info:${NC}"
    echo "  Model:        $(adb shell getprop ro.product.model 2>/dev/null | tr -d '\r')"
    echo "  Manufacturer: $(adb shell getprop ro.product.manufacturer 2>/dev/null | tr -d '\r')"
    echo "  Brand:        $(adb shell getprop ro.product.brand 2>/dev/null | tr -d '\r')"
    
    echo ""
    echo -e "${BOLD}System Info:${NC}"
    echo "  Android:      $(adb shell getprop ro.build.version.release 2>/dev/null | tr -d '\r')"
    echo "  SDK:          $(adb shell getprop ro.build.version.sdk 2>/dev/null | tr -d '\r')"
    echo "  Security:     $(adb shell getprop ro.build.version.security_patch 2>/dev/null | tr -d '\r')"
    
    echo ""
    echo -e "${BOLD}Display:${NC}"
    echo "  Resolution:   $(adb shell wm size 2>/dev/null | grep -oP '\d+x\d+' | head -1)"
    echo "  Density:      $(adb shell wm density 2>/dev/null | grep -oP '\d+' | head -1)"
    
    echo ""
    echo -e "${BOLD}Hardware:${NC}"
    echo "  CPU:          $(adb shell getprop ro.hardware 2>/dev/null | tr -d '\r')"
    echo "  GPU:          $(adb shell getprop ro.hardware.gralloc 2>/dev/null | tr -d '\r')"
    echo "  RAM:          $(adb shell cat /proc/meminfo 2>/dev/null | grep MemTotal | awk '{print $2/1024" MB"}')"
    
    echo ""
    echo -e "${BOLD}Network:${NC}"
    echo "  WiFi IP:      $(adb shell ip addr show wlan0 2>/dev/null | grep -oP 'inet \K[\d.]+' | head -1)"
    echo "  WiFi MAC:     $(adb shell cat /sys/class/net/wlan0/address 2>/dev/null | tr -d '\r')"
    
    echo ""
    echo -e "${BOLD}Battery:${NC}"
    local battery=$(adb shell dumpsys battery 2>/dev/null | grep -E "level|status|health|temperature" | head -4)
    echo "$battery" | while read line; do
        echo "  $line" | sed 's/^/  /'
    done
}

# Battery Management
battery_menu() {
    echo -e "${GREEN}🔋 Battery Management${NC}"
    echo "─────────────────────────────────"
    echo "  1) Show battery status"
    echo "  2) Enable USB charging (force)"
    echo "  3) Disable battery optimization"
    echo "  4) Reset battery stats"
    echo ""
    echo -n "Select option: "
    read opt
    
    case $opt in
        1)
            adb shell dumpsys battery
            ;;
        2)
            echo "Enabling charging..."
            adb shell dumpsys battery set status 2
            ;;
        3)
            echo "Disabling battery optimization..."
            adb shell dumpsys deviceidle whitelist +pkg
            ;;
        4)
            echo -e "${YELLOW}Resetting battery stats...${NC}"
            adb shell dumpsys battery reset
            echo -e "${GREEN}Battery stats reset${NC}"
            ;;
    esac
}

# Network Tools
network_menu() {
    echo -e "${GREEN}🌐 Network Tools${NC}"
    echo "─────────────────────────────────"
    
    # Get IP
    echo -e "${BOLD}WiFi Information:${NC}"
    IP=$(adb shell ip addr show wlan0 2>/dev/null | grep -oP 'inet \K[\d.]+' | head -1)
    echo "  IP Address: $IP"
    
    echo ""
    echo -e "${BOLD}Options:${NC}"
    echo "  1) Ping test"
    echo "  2) Connect via WiFi (adb connect)"
    echo "  3) Show network details"
    echo "  4) Enable ADB over WiFi"
    echo ""
    echo -n "Select option: "
    read opt
    
    case $opt in
        1)
            echo "Enter host to ping:"
            read host
            adb shell ping -c 4 $host
            ;;
        2)
            if [ -n "$IP" ]; then
                echo "Connecting to $IP:5555..."
                adb connect $IP:5555
            else
                echo -e "${RED}No WiFi IP found${NC}"
            fi
            ;;
        3)
            adb shell ifconfig
            ;;
        4)
            echo "Enabling ADB over WiFi..."
            adb tcpip 5555
            echo -e "${GREEN}ADB over WiFi enabled on port 5555${NC}"
            ;;
    esac
}

# App Management
app_menu() {
    echo -e "${GREEN}📦 App Management${NC}"
    echo "─────────────────────────────────"
    echo "  1) List installed apps"
    echo "  2) List system apps"
    echo "  3) List user apps"
    echo "  4) Show app info"
    echo "  5) Install APK"
    echo "  6) Uninstall app"
    echo "  7) Clear app data"
    echo ""
    echo -n "Select option: "
    read opt
    
    case $opt in
        1)
            adb shell pm list packages
            ;;
        2)
            adb shell pm list packages -s
            ;;
        3)
            adb shell pm list packages -3
            ;;
        4)
            echo "Enter package name (e.g., com.example.app):"
            read pkg
            adb shell dumpsys package $pkg
            ;;
        5)
            echo "Enter APK path:"
            read apk
            if [ -f "$apk" ]; then
                adb install -r "$apk"
            else
                echo -e "${RED}File not found: $apk${NC}"
            fi
            ;;
        6)
            echo "Enter package name to uninstall:"
            read pkg
            adb uninstall $pkg
            ;;
        7)
            echo "Enter package name:"
            read pkg
            adb shell pm clear $pkg
            ;;
    esac
}

# File Management
file_menu() {
    echo -e "${GREEN}📁 File Management${NC}"
    echo "─────────────────────────────────"
    echo "  1) List files on device"
    echo "  2) Pull file from device"
    echo "  3) Push file to device"
    echo "  4) Create directory"
    echo "  5) Delete file/directory"
    echo ""
    echo -n "Select option: "
    read opt
    
    case $opt in
        1)
            echo "Enter directory path (default: /sdcard):"
            read path
            path=${path:-/sdcard}
            adb shell ls -la "$path"
            ;;
        2)
            echo "Enter remote path:"
            read remote
            echo "Enter local path:"
            read local
            adb pull "$remote" "$local"
            ;;
        3)
            echo "Enter local path:"
            read local
            echo "Enter remote path:"
            read remote
            adb push "$local" "$remote"
            ;;
        4)
            echo "Enter directory path:"
            read path
            adb shell mkdir -p "$path"
            ;;
        5)
            echo "Enter path to delete:"
            read path
            adb shell rm -rf "$path"
            ;;
    esac
}

# System Control
system_menu() {
    echo -e "${GREEN}⚙️ System Control${NC}"
    echo "─────────────────────────────────"
    echo "  1) Reboot device"
    echo "  2) Reboot to recovery"
    echo "  3) Reboot to bootloader"
    echo "  4) Shutdown (power off)"
    echo "  5) Screenshot"
    echo "  6) Screen record (30s)"
    echo "  7) Open settings"
    echo ""
    echo -n "Select option: "
    read opt
    
    case $opt in
        1)
            echo -e "${YELLOW}Rebooting...${NC}"
            adb reboot
            ;;
        2)
            echo -e "${YELLOW}Rebooting to recovery...${NC}"
            adb reboot recovery
            ;;
        3)
            echo -e "${YELLOW}Rebooting to bootloader...${NC}"
            adb reboot bootloader
            ;;
        4)
            echo -e "${YELLOW}Shutting down...${NC}"
            adb shell reboot -p
            ;;
        5)
            TIMESTAMP=$(date +%Y%m%d_%H%M%S)
            adb shell screencap -p /sdcard/screenshot_$TIMESTAMP.png
            adb pull /sdcard/screenshot_$TIMESTAMP.png ~/Pictures/
            echo -e "${GREEN}Screenshot saved to ~/Pictures/screenshot_$TIMESTAMP.png${NC}"
            ;;
        6)
            TIMESTAMP=$(date +%Y%m%d_%H%M%S)
            echo "Recording for 30 seconds..."
            adb shell screenrecord --time-limit 30 /sdcard/video_$TIMESTAMP.mp4
            adb pull /sdcard/video_$TIMESTAMP.mp4 ~/Videos/
            echo -e "${GREEN}Video saved to ~/Videos/video_$TIMESTAMP.mp4${NC}"
            ;;
        7)
            adb shell am start -a android.settings.SETTINGS
            ;;
    esac
}

# Input Control
input_menu() {
    echo -e "${GREEN}🎮 Input Control${NC}"
    echo "─────────────────────────────────"
    echo "Keyevents:"
    echo "  1) Home"
    echo "  2) Back"
    echo "  3) Recents/App Switch"
    echo "  4) Power"
    echo "  5) Volume Up"
    echo "  6) Volume Down"
    echo "  7) Menu"
    echo "  8) Search"
    echo "  9) Custom input"
    echo ""
    echo -n "Select option: "
    read opt
    
    case $opt in
        1) adb shell input keyevent KEYCODE_HOME ;;
        2) adb shell input keyevent KEYCODE_BACK ;;
        3) adb shell input keyevent KEYCODE_APP_SWITCH ;;
        4) adb shell input keyevent KEYCODE_POWER ;;
        5) adb shell input keyevent KEYCODE_VOLUME_UP ;;
        6) adb shell input keyevent KEYCODE_VOLUME_DOWN ;;
        7) adb shell input keyevent KEYCODE_MENU ;;
        8) adb shell input keyevent KEYCODE_SEARCH ;;
        9)
            echo "Enter keyevent code (e.g., KEYCODE_HOME):"
            read key
            adb shell input keyevent $key
            ;;
    esac
}

# Developer Options
developer_menu() {
    echo -e "${GREEN}🔧 Developer Options${NC}"
    echo "─────────────────────────────────"
    echo "  1) Enable USB debugging (print command)"
    echo "  2) Show developer options"
    echo "  3) Kill ADB server"
    echo "  4) Start ADB server"
    echo "  5) Restart ADB"
    echo "  6) Check ADB version"
    echo "  7) Show all props"
    echo ""
    echo -n "Select option: "
    read opt
    
    case $opt in
        1)
            echo "To enable USB debugging on device, run:"
            echo ""
            echo "  adb shell am start -a android.settings.APPLICATION_DEVELOPMENT_SETTINGS"
            ;;
        2)
            adb shell am start -a android.settings.APPLICATION_DEVELOPMENT_SETTINGS
            ;;
        3)
            echo "Stopping ADB server..."
            adb kill-server
            echo -e "${GREEN}ADB server stopped${NC}"
            ;;
        4)
            echo "Starting ADB server..."
            adb start-server
            ;;
        5)
            echo "Restarting ADB..."
            adb kill-server
            adb start-server
            ;;
        6)
            adb version
            ;;
        7)
            adb shell getprop | less
            ;;
    esac
}

# Quick Actions
quick_actions() {
    echo -e "${GREEN}⚡ Quick Actions${NC}"
    echo "─────────────────────────────────"
    echo "  1) 📱 Screenshot"
    echo "  2) 🎥 Screen Record (30s)"
    echo "  3) 🏠 Go Home"
    echo "  4) ⬅️ Back"
    echo "  5) 📋 Recent Apps"
    echo "  6) ⏻ Power Menu"
    echo "  7) 🔇 Mute"
    echo "  8) 🔊 Max Volume"
    echo ""
    echo -n "Select action: "
    read opt
    
    case $opt in
        1)
            TIMESTAMP=$(date +%Y%m%d_%H%M%S)
            adb shell screencap -p /sdcard/screenshot_$TIMESTAMP.png
            adb pull /sdcard/screenshot_$TIMESTAMP.png ~/Pictures/
            echo -e "${GREEN}✓ Screenshot saved${NC}"
            ;;
        2)
            TIMESTAMP=$(date +%Y%m%d_%H%M%S)
            adb shell screenrecord --time-limit 30 /sdcard/video_$TIMESTAMP.mp4
            adb pull /sdcard/video_$TIMESTAMP.mp4 ~/Videos/
            echo -e "${GREEN}✓ Recording saved${NC}"
            ;;
        3) adb shell input keyevent KEYCODE_HOME ;;
        4) adb shell input keyevent KEYCODE_BACK ;;
        5) adb shell input keyevent KEYCODE_APP_SWITCH ;;
        6) adb shell input keyevent KEYCODE_POWER ;;
        7) adb shell input keyevent KEYCODE_MUTE ;;
        8) 
            for i in {1..10}; do adb shell input keyevent KEYCODE_VOLUME_UP; done
            ;;
    esac
}

# ═══════════════════════════════════════════════════════════════════════════════
#                              MAIN MENU
# ═══════════════════════════════════════════════════════════════════════════════

show_main_menu() {
    echo ""
    echo -e "${BOLD}Main Menu:${NC}"
    echo "  1) 📱 Device Info"
    echo "  2) 🔋 Battery"
    echo "  3) 🌐 Network"
    echo "  4) 📦 Apps"
    echo "  5) 📁 Files"
    echo "  6) ⚙️ System"
    echo "  7) 🎮 Input"
    echo "  8) 🔧 Developer"
    echo "  9) ⚡ Quick Actions"
    echo "  0) ❌ Exit"
    echo ""
    echo -n "Select option: "
    read choice
    
    case $choice in
        1) show_device_info ;;
        2) battery_menu ;;
        3) network_menu ;;
        4) app_menu ;;
        5) file_menu ;;
        6) system_menu ;;
        7) input_menu ;;
        8) developer_menu ;;
        9) quick_actions ;;
        0) 
            echo -e "${GREEN}Goodbye!${NC}"
            exit 0
            ;;
        *)
            echo -e "${RED}Invalid option${NC}"
            ;;
    esac
}

# ═══════════════════════════════════════════════════════════════════════════════
#                                 MAIN
# ═══════════════════════════════════════════════════════════════════════════════

main() {
    print_header
    
    if ! check_connection; then
        echo ""
        echo -e "${YELLOW}Attempting to start ADB server...${NC}"
        adb start-server 2>/dev/null
        sleep 2
        
        if ! check_connection; then
            echo ""
            echo -e "${RED}Still no device. Please check:${NC}"
            echo "  1. USB cable is connected"
            echo "  2. USB debugging is enabled on device"
            echo "  3. Authorize this computer on device"
            exit 1
        fi
    fi
    
    echo -e "${GREEN}✓ Device connected!${NC}"
    echo ""
    
    while true; do
        show_main_menu
        echo ""
        echo "Press Enter to continue..."
        read
    done
}

main