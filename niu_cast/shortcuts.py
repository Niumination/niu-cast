#!/usr/bin/env python3
"""
╔══════════════════════════════════════════════════════════════════════════════╗
║                        NIU CAST - KEYBOARD SHORTCUTS                        ║
║                    Pre-configured Hotkeys for Gaming                        ║
╚══════════════════════════════════════════════════════════════════════════════╝
"""

from PyQt5.QtGui import QKeySequence
from PyQt5.QtCore import Qt


class KeyboardShortcuts:
    """Pre-configured keyboard shortcuts for quick actions"""
    
    # Action -> (Key Sequence, Description)
    SHORTCUTS = {
        # Navigation
        'home': (Qt.CTRL + Qt.Key_H, 'Go to Home Screen'),
        'back': (Qt.CTRL + Qt.Key_B, 'Press Back Button'),
        'recents': (Qt.CTRL + Qt.Key_Tab, 'Open Recent Apps'),
        'power': (Qt.CTRL + Qt.Key_P, 'Power Menu'),
        
        # Volume
        'volume_up': (Qt.CTRL + Qt.Key_Up, 'Volume Up'),
        'volume_down': (Qt.CTRL + Qt.Key_Down, 'Volume Down'),
        'mute': (Qt.CTRL + Qt.Key_M, 'Mute'),
        
        # Capture
        'screenshot': (Qt.CTRL + Qt.Key_S, 'Take Screenshot'),
        'record_start': (Qt.CTRL + Qt.Key_R, 'Start/Stop Recording'),
        
        # Utilities
        'rotate': (Qt.CTRL + Qt.Key_R + Qt.CTRL + Qt.Key_O, 'Rotate Screen'),
        'settings': (Qt.CTRL + Qt.Key_E, 'Open Device Settings'),
        
        # Quick Actions
        'unlock': (Qt.CTRL + Qt.Key_U, 'Unlock Device'),
        'swipe_up': (Qt.CTRL + Qt.Key_W, 'Swipe Up (Home)'),
        'swipe_down': (Qt.CTRL + Qt.Key_S + Qt.CTRL + Qt.Key_S, 'Swipe Down (Recents)'),
    }
    
    # Alternative shortcuts (for Mac compatibility)
    MAC_SHORTCUTS = {
        'home': (Qt.META + Qt.Key_H, 'Go to Home Screen'),
        'back': (Qt.META + Qt.Key_B, 'Press Back Button'),
        'recents': (Qt.META + Qt.Key_Tab, 'Open Recent Apps'),
        'power': (Qt.META + Qt.Key_P, 'Power Menu'),
        'screenshot': (Qt.META + Qt.Key_S, 'Take Screenshot'),
        'record_start': (Qt.META + Qt.Key_R, 'Start/Stop Recording'),
    }
    
    @classmethod
    def get_all(cls, is_mac=False):
        """Get all shortcuts based on platform"""
        shortcuts = cls.MAC_SHORTCUTS if is_mac else cls.SHORTCUTS
        return shortcuts
    
    @classmethod
    def get_action(cls, key_sequence, is_mac=False):
        """Get action by key sequence"""
        shortcuts = cls.get_all(is_mac)
        
        for action, (key, desc) in shortcuts.items():
            if key == key_sequence:
                return action
        
        return None
    
    @classmethod
    def get_sequence(cls, action, is_mac=False):
        """Get key sequence by action"""
        shortcuts = cls.get_all(is_mac)
        
        if action in shortcuts:
            return shortcuts[action][0]
        
        return None
    
    @classmethod
    def register_shortcuts(cls, window, adb_controller, is_mac=False):
        """Register all shortcuts to window"""
        shortcuts = cls.get_all(is_mac)
        
        from PyQt5.QtWidgets import QShortcut
        
        for action, (key, desc) in shortcuts.items():
            shortcut = QShortcut(QKeySequence(key), window)
            
            # Map action to handler
            def make_handler(act):
                def handler():
                    cls.execute_action(act, adb_controller)
                return handler
            
            shortcut.activated.connect(make_handler(action))
    
    @classmethod
    def execute_action(cls, action, adb):
        """Execute shortcut action"""
        keyevents = {
            'home': 'KEYCODE_HOME',
            'back': 'KEYCODE_BACK',
            'recents': 'KEYCODE_APP_SWITCH',
            'power': 'KEYCODE_POWER',
            'volume_up': 'KEYCODE_VOLUME_UP',
            'volume_down': 'KEYCODE_VOLUME_DOWN',
            'mute': 'KEYCODE_MUTE',
            'settings': 'android.settings.SETTINGS',
            'unlock': 'KEYCODE_MENU',  # Unlock screen
        }
        
        if action in keyevents:
            if 'settings' in action:
                adb.shell(f'am start -a android.{keyevents[action]}')
            else:
                adb.send_keyevent(keyevents[action])
        
        # Special gestures
        gestures = {
            'swipe_up': (540, 1800, 540, 200, 300),
            'swipe_down': (540, 200, 540, 1800, 300),
            'rotate': None,  # Implement rotation
        }
        
        if action in gestures and action.startswith('swipe'):
            coords = gestures[action]
            if coords:
                adb.send_swipe(*coords)


# ═══════════════════════════════════════════════════════════════════════════════
#                              SHORTCUT HELPER
# ═══════════════════════════════════════════════════════════════════════════════

if __name__ == '__main__':
    print("🎮 NiuCast Gaming Edition - Keyboard Shortcuts")
    print("=" * 60)
    print()
    
    print("Windows/Linux Shortcuts:")
    print("-" * 40)
    for action, (key, desc) in KeyboardShortcuts.SHORTCUTS.items():
        key_str = QKeySequence(key).toString()
        print(f"  {key_str:15} - {desc}")
    
    print()
    print("Mac Shortcuts:")
    print("-" * 40)
    for action, (key, desc) in KeyboardShortcuts.MAC_SHORTCUTS.items():
        key_str = QKeySequence(key).toString()
        print(f"  ⌘{key_str.replace('Ctrl+', ''):13} - {desc}")
    
    print()
    print("Usage: Press shortcuts while NiuCast is focused")
    print("       to control your Android device remotely!")