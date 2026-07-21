"""
NIU CAST — Android device manager via ADB + wireless TCCP
"""

__version__ = "3.5.0"
__author__ = "Niumination"

from .adb_controller import ADBController
from .app_manager import AppManagerWidget
from .file_browser import FileBrowserWidget
from .tccp_server import TranCastServer, register_mdns, register_all_mdns, unregister_mdns_all
from .server_8613 import TranCastServer8613

__all__ = [
    '__version__',
    '__author__',
    'ADBController',
    'AppManagerWidget',
    'FileBrowserWidget',
    'TranCastServer',
    'TranCastServer8613',
    'register_mdns',
    'register_all_mdns',
    'unregister_mdns_all',
]
