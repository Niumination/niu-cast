"""
NIU CAST — QR Code Generator untuk Joy Connect

Format QR Transsion (dari decompile b0/d.java):
  tqr://a=com.transsion.intent.wls.MULTISCREEN_SCAN_CONNECT&c=PID=xxx&DeviceName=xxx&DPORT=xxx&DID=xxx&SSID=xxx&PWD=xxx&Chan=xxx

Alur:
  1. Mac generate QR → tampilkan di layar
  2. HP scan QR via Joy Connect → "scan QR Code to add device"
  3. HP validasi prefix "tqr://a=com.transsion.intent.wls.MULTISCREEN_SCAN_CONNECT"
  4. HP extract substring setelah "c=" → parse parameter
  5. HP connect ke Mac:DPORT via TCCP

Usage:
  python3 -m niu_cast qr                    # generate + tampilkan QR
  python3 -m niu_cast qr --save qr.png      # simpan ke file
  python3 -m niu_cast qr --terminal          # tampilkan di terminal
"""

import argparse
import hashlib
import json
import logging
import os
import socket
import sys
import tempfile
import time
from typing import Optional
from urllib.parse import quote

logger = logging.getLogger(__name__)

# ── QR Parameter Builder ───────────────────────────────────────────────────────

def build_qr_string(
    device_name: str = "NIU-CAST-Mac",
    port: int = 9452,
    ssid: str = "",
    password: str = "",
    channel: str = "0",
) -> str:
    """
    Build QR string format Transsion.
    
    PENTING: P2PConnectService butuh minimal 6 field (PID, DeviceName, DPORT, DID, SSID, PWD, Chan).
    Kurang dari 6 field -> masuk old format path yang salah.
    
    Args:
        device_name: Nama yang muncul di HP
        port: Port TCCP server (DPORT) — default 9452 (Joy Connect)
        ssid: WiFi SSID (default: "")
        password: WiFi password (default: "")
        channel: WiFi channel (default: "0")
    
    Returns:
        Format: tqr://a=...&c=PID=xxx&DeviceName=xxx&DPORT=xxx&DID=xxx&SSID=xxx&PWD=xxx&Chan=xxx
    """
    # PID harus 12 hex chars! Format: TTBBXXXXXXXX
    #   TT (2): device type code (hex byte) — 00 = default PC
    #   BB (2): brand code (hex int) — 00 = default
    #   XXXXXXXX (8): unique device ID
    unique_id = hashlib.md5(
        f"{device_name}-{port}-{socket.gethostname()}".encode()
    ).hexdigest()[:8]
    pid = f"0000{unique_id}"
    
    # DID = unique identifier (16 hex chars)
    did = hashlib.sha256(
        f"{device_name}-{port}-{socket.gethostname()}".encode()
    ).hexdigest()[:16].upper()
    
    # Build params — ALL 7 fields WAJIB!
    # HP parse parameter dalam urutan fix:
    #   0:PID, 1:DeviceName, 2:DPORT, 3:DID, 4:SSID, 5:PWD, 6:Chan
    # Kalo Chan = 0 (default channel)
    # URL-encode DeviceName dan PWD untuk handle karakter spesial
    params = f"PID={pid}&DeviceName={quote(device_name)}&DPORT={port}&DID={did}"
    params += f"&SSID={ssid}&PWD={quote(password)}&Chan={channel}"
    
    # Format Transsion: tqr://a=ACTION&c=KEY=VALUE&...
    prefix = "tqr://a=com.transsion.intent.wls.MULTISCREEN_SCAN_CONNECT&c="
    return prefix + params


def parse_qr_string(qr_full: str) -> dict:
    """
    Parse full QR string or params-only string.
    
    Args:
        qr_full: Full QR (tqr://a=...&c=...) or just params (PID=...)
    
    Returns:
        Dictionary of extracted parameters
    """
    # Extract params after "c=" if present
    if "&c=" in qr_full:
        params_str = qr_full.split("&c=", 1)[1]
    elif "c=" in qr_full and qr_full.startswith("tqr://"):
        params_str = qr_full.split("c=", 1)[1]
    else:
        params_str = qr_full
    
    result = {}
    for part in params_str.split('&'):
        if '=' in part:
            k, v = part.split('=', 1)
            result[k] = v
    return result


# ── QR Image Generator ─────────────────────────────────────────────────────────

def generate_qr(data: str, save_path: Optional[str] = None) -> Optional[str]:
    """
    Generate QR code image.
    
    Args:
        data: QR string content
        save_path: Path untuk simpan PNG (opsional, default: /tmp/niu-cast-qr-xxx.png)
    
    Returns:
        Path ke file PNG yang digenerate, atau None kalo gagal
    """
    try:
        import qrcode
    except ImportError:
        logger.error("qrcode library not installed. Coba: pip install qrcode[pil]")
        return None
    
    qr = qrcode.QRCode(
        version=None,
        error_correction=qrcode.constants.ERROR_CORRECT_M,
        box_size=10,
        border=4,
    )
    qr.add_data(data)
    qr.make(fit=True)
    
    img = qr.make_image(fill='black', back_color='white')
    
    if not save_path:
        save_path = f"/tmp/niu-cast-qr-{int(time.time())}.png"
    
    img.save(save_path)
    logger.info(f"QR code saved: {save_path}")
    return save_path


def generate_qr_terminal(data: str) -> Optional[str]:
    """
    Generate QR code sebagai string ASCII untuk display di terminal.
    """
    try:
        import qrcode
        from io import StringIO
    except ImportError:
        return None
    
    qr = qrcode.QRCode(
        version=None,
        error_correction=qrcode.constants.ERROR_CORRECT_M,
        box_size=1,
        border=2,
    )
    qr.add_data(data)
    qr.make(fit=True)
    
    # ASCII render
    buf = StringIO()
    matrix = qr.get_matrix()
    for row in matrix:
        line = ''.join('██' if cell else '  ' for cell in row)
        buf.write(line + '\n')
    
    return buf.getvalue()


# ── Display ────────────────────────────────────────────────────────────────────

def show_qr(data: str, terminal: bool = False, port: int = 9452):
    """Generate dan tampilkan QR code."""
    qr_str = build_qr_string(
        device_name="NIU-CAST-Mac",
        port=port,
    )
    
    if terminal:
        ascii_art = generate_qr_terminal(qr_str)
        if ascii_art:
            print("\nScan QR code ini dengan Joy Connect HP:\n")
            print(ascii_art)
            print(f"\nData: {qr_str}")
            return
    
    # Save + open
    path = generate_qr(qr_str)
    if path:
        import subprocess
        subprocess.run(['open', path], check=False)
        logger.info(f"QR code dibuka: {path}")
    
    print(f"\nQR data: {qr_str}")
    print("\nScan QR code dengan Joy Connect > scan QR Code to add device")


# ── Full Flow (QR + Server) ────────────────────────────────────────────────────

def run_qr_flow(port: int = 9452, name: str = "NIU-CAST-Mac",
                terminal: bool = False, save: Optional[str] = None):
    """
    Generate QR + jalanin server.
    
    Alur:
      1. Generate QR code
      2. Tampilkan di layar
      3. Jalanin TCCP server (port 9452)
      4. Tunggu HP connect
    """
    import asyncio
    
    qr_str = build_qr_string(device_name=name, port=port)
    
    # Display QR
    if terminal:
        ascii_art = generate_qr_terminal(qr_str)
        if ascii_art:
            print("\n" + "=" * 60)
            print("  Scan QR ini dengan Joy Connect HP")
            print("=" * 60)
            print(ascii_art)
            print(f"\n  {qr_str}")
    else:
        path = save or generate_qr(qr_str)
        if path:
            import subprocess
            subprocess.run(['open', path], check=False)
    
    print(f"\nQR data: {qr_str}")
    params = parse_qr_string(qr_str)
    print(f"\n  PID: {params.get('PID', '?')}")
    print(f"  Device: {params.get('DeviceName', '?')}")
    print(f"  Port: {params.get('DPORT', '?')}")
    print(f"  DID: {params.get('DID', '?')}")
    print()
    
    # Start server — pilih yang sesuai port
    try:
        if port == 8613:
            from .server_8613 import TranCastServer8613
            
            async def run():
                server = TranCastServer8613(port=port, mdns_name=name)
                await server.start()
            
            asyncio.run(run())
        else:
            from .tccp_server import TranCastServer
            
            async def run():
                server = TranCastServer(port=port, mdns_name=name)
                # Override start to not register mDNS (QR mode doesn't need it)
                server._server = await asyncio.start_server(
                    server._handle_client,
                    host='0.0.0.0',
                    port=port,
                )
                
                logger.info("")
                logger.info(f"  ╔═══════════════════════════════════════╗")
                logger.info(f"  ║   QR CODE MODE — NIU-CAST TCCP       ║")
                logger.info(f"  ║   Listening: 0.0.0.0:{port:<5}          ║")
                logger.info(f"  ╚═══════════════════════════════════════╝")
                logger.info("")
                logger.info("  Scan QR code yang sudah terbuka")
                logger.info("  dengan Joy Connect HP > scan QR")
                logger.info("")
                
                async with server._server:
                    await server._server.serve_forever()
            
            asyncio.run(run())
    except KeyboardInterrupt:
        print("\nShutting down...")
    except ImportError:
        logger.error("Gagal import server module")


# ── CLI ────────────────────────────────────────────────────────────────────────

def main():
    logging.basicConfig(level=logging.INFO,
                       format='%(asctime)s.%(msecs)03d %(message)s',
                       datefmt='%H:%M:%S')
    
    parser = argparse.ArgumentParser(
        description='NIU CAST — QR Code Generator untuk Joy Connect'
    )
    parser.add_argument('--port', type=int, default=9452,
                       help='Port TCCP server (default: 9452, Joy Connect: 8613)')
    parser.add_argument('--name', default='NIU-CAST-Mac',
                       help='Nama device di QR')
    parser.add_argument('--save', default=None,
                       help='Path simpan QR PNG')
    parser.add_argument('--terminal', action='store_true',
                       help='Tampilkan QR di terminal (ASCII)')
    parser.add_argument('--no-server', action='store_true',
                       help='Hanya generate QR, tanpa jalanin server')
    parser.add_argument('--joyconnect', action='store_true',
                       help='Mode Joy Connect (port=8613, protocol 8613)')
    args = parser.parse_args()
    
    # --joyconnect override port and server type
    if args.joyconnect:
        args.port = 8613
    
    if args.no_server:
        qr_str = build_qr_string(device_name=args.name, port=args.port)
        if args.terminal:
            art = generate_qr_terminal(qr_str)
            if art:
                print(art)
        else:
            path = generate_qr(qr_str, save_path=args.save)
            if path and not args.save:
                import subprocess
                subprocess.run(['open', path], check=False)
        print(f"\nQR data: {qr_str}")
        return 0
    
    run_qr_flow(port=args.port, name=args.name,
                terminal=args.terminal, save=args.save)
    return 0


if __name__ == '__main__':
    sys.exit(main())
