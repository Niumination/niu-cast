#!/usr/bin/env python3
"""
╔══════════════════════════════════════════════════════════════════════════════╗
║                        NIU CAST - THEME MANAGER                             ║
║                    Additional Gaming Themes                                 ║
╚══════════════════════════════════════════════════════════════════════════════╝
"""

from PyQt5.QtGui import QColor, QLinearGradient


class ThemeManager:
    """Manage multiple gaming themes"""
    
    THEMES = {
        'cyberpunk': {
            'name': '🎮 Cyberpunk 2077',
            'bg_dark': '#0D0D1A',
            'bg_card': '#1A1A2E',
            'bg_panel': '#16162A',
            'primary': '#00F5FF',
            'secondary': '#FF00FF',
            'accent': '#9D4EDD',
            'gold': '#FFD700',
            'text_primary': '#FFFFFF',
            'text_secondary': '#A0A0B0',
            'connected': '#00FF88',
            'disconnected': '#FF4444',
            'warning': '#FFAA00',
        },
        'genshin': {
            'name': '⚔️ Genshin Impact',
            'bg_dark': '#0F1419',
            'bg_card': '#1C2530',
            'bg_panel': '#151C25',
            'primary': '#5DCAFF',
            'secondary': '#FFD700',
            'accent': '#4ADE80',
            'gold': '#FBBF24',
            'text_primary': '#F0F6FC',
            'text_secondary': '#8B949E',
            'connected': '#4ADE80',
            'disconnected': '#F85149',
            'warning': '#D29922',
        },
        'xarena': {
            'name': '🎯 Xarena Gaming',
            'bg_dark': '#0A0A0F',
            'bg_card': '#12121A',
            'bg_panel': '#0E0E15',
            'primary': '#00D4FF',
            'secondary': '#FF3366',
            'accent': '#7C3AED',
            'gold': '#F59E0B',
            'text_primary': '#FFFFFF',
            'text_secondary': '#94A3B8',
            'connected': '#10B981',
            'disconnected': '#EF4444',
            'warning': '#F59E0B',
        },
        'valoran': {
            'name': '🔮 Valorant',
            'bg_dark': '#0F1923',
            'bg_card': '#1A2633',
            'bg_panel': '#15202D',
            'primary': '#FF4655',
            'secondary': '#0F1923',
            'accent': '#1FFFA5',
            'gold': '#FF9E00',
            'text_primary': '#FFFFFF',
            'text_secondary': '#8B9AAF',
            'connected': '#1FFFA5',
            'disconnected': '#FF4655',
            'warning': '#FF9E00',
        },
        'lol': {
            'name': '🏆 League of Legends',
            'bg_dark': '#010A13',
            'bg_card': '#0A1428',
            'bg_panel': '#061224',
            'primary': '#C89B3C',
            'secondary': '#005A82',
            'accent': '#C8AA6E',
            'gold': '#FFD700',
            'text_primary': '#F0E6D2',
            'text_secondary': '#A89B7A',
            'connected': '#00FF44',
            'disconnected': '#FF4444',
            'warning': '#FFAA00',
        },
        'minecraft': {
            'name': '⛏️ Minecraft',
            'bg_dark': '#1D1D21',
            'bg_card': '#2D2D2F',
            'bg_panel': '#252529',
            'primary': '#5E9E3E',
            'secondary': '#82693A',
            'accent': '#4AC26D',
            'gold': '#FDD835',
            'text_primary': '#FFFFFF',
            'text_secondary': '#AAAAAA',
            'connected': '#5E9E3E',
            'disconnected': '#FF5555',
            'warning': '#FFAA00',
        },
    }
    
    @classmethod
    def get_theme(cls, theme_name='cyberpunk'):
        """Get theme by name"""
        return cls.THEMES.get(theme_name, cls.THEMES['cyberpunk'])
    
    @classmethod
    def list_themes(cls):
        """List all available themes"""
        return [(name, data['name']) for name, data in cls.THEMES.items()]
    
    @classmethod
    def apply_theme(cls, window, theme_name='cyberpunk'):
        """Apply theme to window"""
        theme = cls.get_theme(theme_name)
        
        # Build stylesheet
        css = f"""
            QMainWindow, QWidget {{
                background: {theme['bg_dark']};
                color: {theme['text_primary']};
            }}
            
            QFrame {{
                background: {theme['bg_card']};
                border: 1px solid {theme['primary']}30;
                border-radius: 8px;
            }}
            
            QPushButton {{
                background: qlineargradient(x1:0, y1:0, x2:1, y2:0,
                    stop:0 {theme['primary']}, stop:1 {theme['bg_card']});
                color: {theme['text_primary']};
                border: 1px solid {theme['primary']};
                border-radius: 5px;
                padding: 8px 20px;
                font-weight: bold;
            }}
            
            QPushButton:hover {{
                border: 2px solid {theme['primary']};
                padding: 7px 19px;
            }}
            
            QComboBox {{
                background: {theme['bg_dark']};
                color: {theme['text_primary']};
                border: 1px solid {theme['primary']}50;
                border-radius: 5px;
                padding: 8px;
            }}
            
            QComboBox::drop-down {{
                border: none;
                width: 30px;
            }}
            
            QComboBox QAbstractItemView {{
                background: {theme['bg_dark']};
                color: {theme['text_primary']};
                border: 1px solid {theme['primary']};
                selection-background-color: {theme['primary']}40;
            }}
            
            QLabel {{
                color: {theme['text_primary']};
            }}
            
            QStatusBar {{
                background: {theme['bg_panel']};
                color: {theme['text_secondary']};
            }}
        """
        
        window.setStyleSheet(css)
        
        # Store current theme
        window.current_theme = theme_name
        
        return theme


# ═══════════════════════════════════════════════════════════════════════════════
#                              THEME PREVIEW
# ═══════════════════════════════════════════════════════════════════════════════

if __name__ == '__main__':
    print("🎨 Available Themes for NiuCast Gaming Edition:")
    print()
    
    for theme_id, theme_data in ThemeManager.THEMES.items():
        print(f"  {theme_data['name']}")
        print(f"    ID: {theme_id}")
        print(f"    Primary: {theme_data['primary']}")
        print(f"    Background: {theme_data['bg_dark']}")
        print()