"""
╔══════════════════════════════════════════════════════════════════════════════╗
║                        NIU CAST - Gaming Edition                            ║
║                                                                            ║
║  Universal Android ADB Tool & Screen Mirroring                             ║
║  Designed with Gaming Aesthetics (Genshin/Xarena/Cyberpunk Inspired)        ║
║                                                                            ║
║  © 2024 Niumination | Adapted from HermesCast                              ║
╚══════════════════════════════════════════════════════════════════════════════╝
"""

__version__ = "1.1.1"
__author__ = "Niumination"
__theme__ = "gaming-cyberpunk"
__python_version__ = "3.8+"

# Core modules
from .core import NiuCastWindow, ADBController, GamingTheme
from .batch import BatchExecutor

# Additional modules
from .theme_manager import ThemeManager
from .shortcuts import KeyboardShortcuts
from .game_mode import GameMode, PerformanceMonitor, GameLauncher

__all__ = [
    # Version info
    '__version__',
    '__author__',
    '__theme__',
    
    # Core
    'NiuCastWindow', 
    'ADBController',
    'GamingTheme',
    'BatchExecutor',
    
    # Additional
    'ThemeManager',
    'KeyboardShortcuts',
    'GameMode',
    'PerformanceMonitor',
    'GameLauncher',
]

# Quick reference for gaming themes
AVAILABLE_THEMES = [
    'cyberpunk',
    'genshin', 
    'xarena',
    'valoran',
    'lol',
    'minecraft',
]

# Default key shortcuts
DEFAULT_SHORTCUTS = {
    'Ctrl+H': 'home',
    'Ctrl+B': 'back', 
    'Ctrl+S': 'screenshot',
    'Ctrl+R': 'record',
    'Ctrl+M': 'mute',
}