"""
NIU CAST — Android device manager via ADB + wireless TCCP
"""

__version__ = "3.6.0"
__author__ = "Niumination"

from .adb_controller import ADBController
from .app_manager import AppManagerWidget
from .file_browser import FileBrowserWidget
from .mac_connect_bridge import MacConnectBridge
from .tccp_server import TranCastServer, register_mdns, register_all_mdns, unregister_mdns_all
from .server_8613 import TranCastServer8613

__all__ = [
    '__version__',
    '__author__',
    'ADBController',
    'AppManagerWidget',
    'FileBrowserWidget',
    'MacConnectBridge',
    'TranCastServer',
    'TranCastServer8613',
    'register_mdns',
    'register_all_mdns',
    'unregister_mdns_all',
]
