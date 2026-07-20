"""
NIU CAST — Android device manager via ADB
"""

__version__ = "2.0.0"
__author__ = "Niumination"

from .adb_controller import ADBController
from .file_browser import FileBrowserWidget

__all__ = [
    '__version__',
    '__author__',
    'ADBController',
    'FileBrowserWidget',
]
