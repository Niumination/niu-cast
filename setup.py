"""
NIU CAST — Setup / macOS py2app build
"""
import sys
import os
from setuptools import setup, find_packages

with open("README.md", "r", encoding="utf-8") as fh:
    long_description = fh.read()

with open("requirements.txt", "r", encoding="utf-8") as fh:
    requirements = [
        line.strip()
        for line in fh
        if line.strip() and not line.startswith("#") and not line.startswith("-")
    ]

# ── py2app macOS .app options ────────────────────────────────────────────────

APP_NAME = "NIU CAST"
APP_VERSION = "3.6.0"

icon_file = "NiuCast.icns"
if not os.path.exists(icon_file):
    icon_file = None

APP = ['niu_cast/__main__.py']

DATA_FILES = []
if icon_file:
    DATA_FILES.append(icon_file)

PY2APP_OPTIONS = {
    'argv_emulation': False,
    'packages': ['PyQt5', 'cv2', 'numpy', 'PIL'],
    'includes': [
        'niu_cast',
        'niu_cast.adb_controller',
        'niu_cast.mac_connect_bridge',
        'niu_cast.core',
        'niu_cast.app_manager',
        'niu_cast.file_browser',
        'niu_cast.mini',
        'niu_cast.video_stream',
        'niu_cast.tccp_server',
        'niu_cast.server_8613',
        'niu_cast.tccp_qr',
        'niu_cast.port_explorer',
        'niu_cast.auto_connect',
        'niu_cast.wfd_bridge',
        'niu_cast.transsion_protocol',
        'niu_cast.apk_extract',
    ],
    'excludes': ['tkinter', 'PyQt4', 'PySide', 'PySide2'],
    'iconfile': icon_file,
    'plist': {
        'CFBundleName': APP_NAME,
        'CFBundleDisplayName': APP_NAME,
        'CFBundleIdentifier': 'com.niumination.niucast',
        'CFBundleVersion': APP_VERSION,
        'CFBundleShortVersionString': APP_VERSION,
        'CFBundleExecutable': 'niu-cast',
        'CFBundleIconFile': os.path.basename(icon_file) if icon_file else None,
        'NSHighResolutionCapable': True,
        'NSHumanReadableCopyright': '© 2026 Niumination',
        'NSSupportsAutomaticGraphicsSwitching': True,
    },
    'resources': [],
    'site_packages': True,
    'use_pythonpath': True,
}

is_py2app = 'py2app' in sys.argv or 'py2app' in sys.modules

setup(
    name="niu-cast",
    version=APP_VERSION,
    author="Niumination",
    author_email="opensource@niumination.dev",
    description="Android device manager via ADB + wireless mirror for macOS",
    long_description=long_description,
    long_description_content_type="text/markdown",
    url="https://github.com/Niumination/niu-cast",
    packages=find_packages(),
    classifiers=[
        "Development Status :: 4 - Beta",
        "Intended Audience :: Developers",
        "License :: OSI Approved :: MIT License",
        "Programming Language :: Python :: 3",
        "Programming Language :: Python :: 3.8",
        "Programming Language :: Python :: 3.9",
        "Programming Language :: Python :: 3.10",
        "Programming Language :: Python :: 3.11",
        "Operating System :: MacOS :: MacOS X",
    ],
    python_requires=">=3.8",
    install_requires=requirements,
    entry_points={
        "console_scripts": [
            "niu-cast=niu_cast.__main__:main",
            "niu-mini=niu_cast.mini:main",
        ],
    },
    include_package_data=True,
    zip_safe=False,
    app=APP,
    options={'py2app': PY2APP_OPTIONS} if is_py2app else {},
    setup_requires=['py2app'] if is_py2app else [],
)
