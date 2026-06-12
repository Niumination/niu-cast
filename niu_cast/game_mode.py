#!/usr/bin/env python3
"""
╔══════════════════════════════════════════════════════════════════════════════╗
║                        NIU CAST - GAME MODE                                 ║
║                    Optimized for Mobile Gaming                              ║
╚══════════════════════════════════════════════════════════════════════════════╝
"""

import subprocess
import time
import threading


class GameMode:
    """Optimize device for mobile gaming while mirroring"""
    
    def __init__(self, adb_controller):
        self.adb = adb_controller
        self.enabled = False
        self.original_settings = {}
    
    def enable(self):
        """Enable gaming optimizations"""
        if self.enabled:
            return
        
        print("🎮 Enabling Game Mode...")
        
        # Store original settings
        self._store_original_settings()
        
        # Apply gaming optimizations
        optimizations = [
            # Disable animations
            ('settings put global window_animation_scale 0', 'Window animation disabled'),
            ('settings put global transition_animation_scale 0', 'Transition animation disabled'),
            ('settings put global animator_duration_scale 0', 'Animator disabled'),
            
            # Boost performance
            ('settings put global hw_ui_driver 1', 'HW UI driver enabled'),
            
            # Disable power saving for this session
            ('settings put global power_save_mode_enabled 0', 'Power save disabled'),
        ]
        
        for cmd, desc in optimizations:
            returncode, _, _ = self.adb.shell(cmd, timeout=5)
            if returncode == 0:
                print(f"  ✓ {desc}")
        
        # Request high performance mode
        self.adb.shell('dumpsys deviceidle disable', timeout=5)
        
        self.enabled = True
        print("✅ Game Mode Enabled!")
    
    def disable(self):
        """Restore original settings"""
        if not self.enabled:
            return
        
        print("🔄 Restoring original settings...")
        
        # Restore window animations
        for setting, value in self.original_settings.items():
            self.adb.shell(f'settings put global {setting} {value}', timeout=5)
        
        self.enabled = False
        print("✅ Game Mode Disabled!")
    
    def _store_original_settings(self):
        """Store current settings before modifying"""
        settings_to_store = [
            'window_animation_scale',
            'transition_animation_scale',
            'animator_duration_scale',
        ]
        
        for setting in settings_to_store:
            returncode, stdout, _ = self.adb.shell(f'settings get global {setting}')
            if returncode == 0:
                self.original_settings[setting] = stdout.strip()
    
    def kill_background_apps(self):
        """Kill background apps to free RAM"""
        print("🧹 Clearing background apps...")
        
        # Get list of packages and kill non-essential ones
        returncode, packages, _ = self.adb.shell('pm list packages -3', timeout=10)
        
        if returncode == 0:
            # Common bloatware to skip
            skip_packages = [
                'com.android.', 'com.google.android.',
                'com.qualcomm.', 'com.android.systemui',
            ]
            
            count = 0
            for pkg in packages.splitlines():
                pkg = pkg.replace('package:', '').strip()
                
                # Skip system packages
                if any(skip in pkg for skip in skip_packages):
                    continue
                
                # Force stop package
                self.adb.shell(f'am force-stop {pkg}', timeout=2)
                count += 1
            
            print(f"  ✓ Stopped {count} background apps")
    
    def set_max_brightness(self):
        """Set screen to maximum brightness for gaming"""
        print("☀️ Setting max brightness...")
        
        # Get current brightness (0-255 scale)
        returncode, current, _ = self.adb.shell('settings get system screen_brightness')
        
        if returncode == 0:
            self.original_brightness = current.strip()
            # Set to maximum (255)
            self.adb.shell('settings put system screen_brightness_mode 0', timeout=5)
            self.adb.shell('settings put system screen_brightness 255', timeout=5)
            print("  ✓ Brightness set to maximum")
    
    def restore_brightness(self):
        """Restore original brightness"""
        if hasattr(self, 'original_brightness'):
            self.adb.shell(f'settings put system screen_brightness {self.original_brightness}', timeout=5)
    
    def boost_gpu(self):
        """Try to boost GPU performance"""
        print("🚀 Boosting GPU...")
        
        # These may not work on all devices
        gpu_commands = [
            # Mali GPU boost (if available)
            'echo performance > /sys/class/misc/mali0/device/power_policy',
            # Qualcomm GPU boost
            'echo 1 > /sys/class/kgsl/kgsl-3d0/max_pwrlevel',
        ]
        
        for cmd in gpu_commands:
            self.adb.shell(cmd, timeout=2)
        
        print("  ✓ GPU boost applied")


# ═══════════════════════════════════════════════════════════════════════════════
#                              PERFORMANCE MONITOR
# ═══════════════════════════════════════════════════════════════════════════════

class PerformanceMonitor:
    """Monitor device performance during mirroring"""
    
    def __init__(self, adb_controller):
        self.adb = adb_controller
        self.monitoring = False
        self.thread = None
        self.stats = {
            'fps': [],
            'cpu_temp': [],
            'memory': [],
            'battery': [],
        }
    
    def start(self, callback=None):
        """Start performance monitoring"""
        if self.monitoring:
            return
        
        self.monitoring = True
        self.callback = callback
        
        self.thread = threading.Thread(target=self._monitor_loop)
        self.thread.daemon = True
        self.thread.start()
        
        print("📊 Performance monitoring started")
    
    def stop(self):
        """Stop monitoring"""
        self.monitoring = False
        if self.thread:
            self.thread.join(timeout=2)
        
        print("📊 Performance monitoring stopped")
    
    def _monitor_loop(self):
        """Monitoring loop"""
        while self.monitoring:
            try:
                # Get CPU temperature
                returncode, temp, _ = self.adb.shell('cat /sys/class/thermal/thermal_zone0/temp')
                if returncode == 0:
                    try:
                        cpu_temp = int(temp.strip()) / 1000
                        self.stats['cpu_temp'].append(cpu_temp)
                    except:
                        pass
                
                # Get memory info
                returncode, mem, _ = self.adb.shell('cat /proc/meminfo | grep MemAvailable')
                if returncode == 0:
                    try:
                        mem_mb = int(''.join(filter(str.isdigit, mem.split()[1]))) / 1024
                        self.stats['memory'].append(mem_mb)
                    except:
                        pass
                
                # Get battery temperature
                returncode, battery, _ = self.adb.shell('dumpsys battery | grep temperature')
                if returncode == 0:
                    try:
                        bat_temp = int(''.join(filter(str.isdigit, battery.split()[1]))) / 10
                        self.stats['battery'].append(bat_temp)
                    except:
                        pass
                
                if self.callback:
                    self.callback(self.get_current_stats())
                
                time.sleep(5)  # Update every 5 seconds
                
            except Exception as e:
                print(f"Monitor error: {e}")
                time.sleep(5)
    
    def get_current_stats(self):
        """Get current statistics"""
        stats = {}
        
        for key, values in self.stats.items():
            if values:
                stats[key] = {
                    'current': values[-1] if values else 0,
                    'avg': sum(values) / len(values) if values else 0,
                    'max': max(values) if values else 0,
                    'min': min(values) if values else 0,
                }
        
        return stats
    
    def get_summary(self):
        """Get performance summary"""
        summary = "📊 Performance Summary\n"
        summary += "=" * 40 + "\n"
        
        for key, data in self.get_current_stats().items():
            label = key.upper()
            summary += f"{label}:\n"
            summary += f"  Current: {data['current']:.1f}\n"
            summary += f"  Avg:     {data['avg']:.1f}\n"
            summary += f"  Max:     {data['max']:.1f}\n"
            summary += f"  Min:     {data['min']:.1f}\n\n"
        
        return summary


# ═══════════════════════════════════════════════════════════════════════════════
#                              QUICK GAME LAUNCHER
# ═══════════════════════════════════════════════════════════════════════════════

class GameLauncher:
    """Quick launcher for mobile games"""
    
    # Popular games with their package names
    GAMES = {
        'Genshin Impact': 'com.miHoYo.GenshinImpact',
        'PUBG Mobile': 'com.tencent.ig',
        'Free Fire': 'com.dts.freefireth',
        'Mobile Legends': 'com.mobile.legend',
        'Call of Duty': 'com.activision.callofduty.shooter',
        'Clash Royale': 'com.supercell.lasher',
        'Clash of Clans': 'com.supercell.clashofclans',
        'Among Us': 'com.innersloth.amongus',
        'PUBG New State': 'com.pubg.newstate',
        'Apex Legends': 'com.ea.gp.apexlegendsmobilefps',
        'Diablo Immortal': 'com.blizzard.diabloimmortal',
        'League of Legends: Wild Rift': 'com.riotgames.league.wildrift',
    }
    
    def __init__(self, adb_controller):
        self.adb = adb_controller
    
    def launch_game(self, game_name):
        """Launch a game by name"""
        if game_name in self.GAMES:
            package = self.GAMES[game_name]
            return self.launch_package(package)
        else:
            return False
    
    def launch_package(self, package):
        """Launch by package name"""
        # First check if installed
        returncode, _, _ = self.adb.shell(f'pm path {package}', timeout=5)
        
        if returncode != 0:
            print(f"❌ {package} not installed")
            return False
        
        # Launch the game
        print(f"🎮 Launching {package}...")
        
        # Clear any previous instance
        self.adb.shell(f'am force-stop {package}', timeout=2)
        
        # Start the game
        returncode, _, _ = self.adb.shell(f'am start -n {package}/com.unity3d.player.UnityPlayerActivity', timeout=10)
        
        if returncode == 0:
            print(f"✅ Game launched!")
            return True
        else:
            # Try alternative launch method
            returncode, _, _ = self.adb.shell(f'am start -a android.intent.action.MAIN -n {package}/-', timeout=10)
            
            if returncode == 0:
                print(f"✅ Game launched!")
                return True
        
        print(f"❌ Failed to launch game")
        return False
    
    def list_installed_games(self):
        """List installed games from our database"""
        installed = []
        
        for game, package in self.GAMES.items():
            returncode, _, _ = self.adb.shell(f'pm path {package}', timeout=5)
            if returncode == 0:
                installed.append((game, package))
        
        return installed
    
    def search_installed_games(self):
        """Search for installed games"""
        returncode, packages, _ = self.adb.shell('pm list packages -3', timeout=30)
        
        if returncode != 0:
            return []
        
        games_found = []
        packages = packages.lower()
        
        for game, package in self.GAMES.items():
            if package.lower() in packages:
                games_found.append((game, package))
        
        return games_found


# ═══════════════════════════════════════════════════════════════════════════════
#                              MAIN
# ═══════════════════════════════════════════════════════════════════════════════

if __name__ == '__main__':
    print("🎮 NiuCast Game Mode")
    print("=" * 50)
    print()
    
    print("Available Games in Database:")
    print("-" * 40)
    for game, package in GameLauncher.GAMES.items():
        print(f"  {game}")
        print(f"    └─ {package}")
    
    print()
    print("Note: Import and use these classes in your application")
    print("      to enable gaming optimizations!")