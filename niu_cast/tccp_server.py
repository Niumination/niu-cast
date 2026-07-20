"""
NIU CAST — TCCP Server (sisi Mac, seperti Joy Connect di Windows)

Cara kerja Joy Connect:
  1. PC (Windows) jalanin TCCP server + register mDNS _tranCast._tcp
  2. HP scan jaringan, lihat "PC-Zaryu"
  3. User tap di HP → HP connect ke server (Mac)
  4. Server handle TCCP handshake + kirim 7 frame awal
  5. AUTH + heartbeat berjalan

Module ini:
  - TranCastServer: TCP server TCCP
  - register_mdns() / unregister_mdns() untuk discovery

Usage:
  python3 -m niu_cast server              # jalanin server
  python3 -m niu_cast server --port 9452  # port custom
"""

import asyncio
import json
import logging
import socket
import sys
from typing import Optional, Callable

from .transsion_protocol import (
    PORT_TCCP, TCCPFrame,
    SERVICE_TRANCAST,
)

logger = logging.getLogger(__name__)

# ── Helpers ─────────────────────────────────────────────────────────────────────

def _get_local_ip() -> str:
    """Dapatkan IP lokal yang reachable."""
    s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    s.settimeout(1)
    try:
        s.connect(('8.8.8.8', 80))
        return s.getsockname()[0]
    except Exception:
        return '127.0.0.1'
    finally:
        s.close()


# ── mDNS Registration ──────────────────────────────────────────────────────────
# Zeroconf punya event loop internal sendiri. Biar gak konflik sama asyncio,
# semua operasi Zeroconf dijalankan di thread executor.

_mdns_registrations = []

async def register_mdns(host: str = None, port: int = PORT_TCCP,
                        name: str = None,
                        service_type: str = SERVICE_TRANCAST) -> bool:
    """
    Register mDNS service biar HP bisa discover Mac.
    Mirip kayak Joy Connect di Windows yang register _tranCast._tcp.

    Args:
        host: IP local (auto-detect kalo None)
        port: Port server
        name: Nama yang muncul di HP (default: "NIU-CAST-Mac")
        service_type: mDNS service type
    """
    global _mdns_registrations

    if not name:
        import getpass
        name = f"NIU-CAST-{getpass.getuser()}"

    try:
        from zeroconf import Zeroconf, ServiceInfo

        if not host:
            host = _get_local_ip()

        props = {
            'cmbSvc': json.dumps({
                'HandShake': port,
                'ScreenCast': 8008,
                'File': 10001,
            }),
            'advData': '',
        }

        info = ServiceInfo(
            type_=service_type,
            name=f"{name}.{service_type}",
            addresses=[socket.inet_aton(host)],
            port=port,
            properties=props,
            server=f"{name}.local.",
        )

        loop = asyncio.get_event_loop()
        zc = await loop.run_in_executor(None, lambda: Zeroconf())
        await loop.run_in_executor(None, zc.register_service, info)
        _mdns_registrations.append((zc, info, service_type))

        logger.info(f"mDNS registered: {name} @ {host}:{port} ({service_type})")
        return True

    except ImportError:
        logger.warning("zeroconf not installed. Coba: pip install zeroconf")
        return False
    except Exception as e:
        import traceback
        logger.warning(f"mDNS register error: {e}\n{traceback.format_exc()}")
        return False


async def unregister_mdns_all():
    """Unregister semua mDNS service yang didaftarkan."""
    global _mdns_registrations
    loop = asyncio.get_event_loop()
    for zc, info, svc_type in _mdns_registrations:
        try:
            await loop.run_in_executor(None, zc.unregister_service, info)
            await loop.run_in_executor(None, zc.close)
            logger.info(f"mDNS unregistered: {svc_type}")
        except Exception as e:
            logger.debug(f"mDNS unregister error: {e}")
    _mdns_registrations.clear()


# ── TCCP Server ────────────────────────────────────────────────────────────────

class TranCastServer:
    """
    TCP server TCCP — sisi PC (mirip Joy Connect Windows).

    Flow:
      1. start() → buka ServerSocket + register mDNS
      2. HP connect → accept()
      3. Kirim 7 frame awal (0x606, 0x404, 0x607, 0x62a, 0x615, 0x403, 0x900)
      4. Tunggu CONN_AUTH (0x700) dari HP
      5. Kirim response AUTH_OK
      6. Heartbeat loop

    Callback:
      on_connect(client_ip) — ada HP connect
      on_auth(phone_info) — AUTH diterima
      on_disconnect() — koneksi putus
      on_frame(frame) — setiap frame dari HP
    """

    def __init__(self, host: str = '0.0.0.0', port: int = PORT_TCCP,
                 mdns_name: str = None):
        self._host = host
        self._port = port
        self._mdns_name = mdns_name
        self._server: Optional[asyncio.AbstractServer] = None
        self._phone: Optional[dict] = None  # info HP setelah AUTH
        self._connected = False

        # Callbacks
        self.on_connect: Optional[Callable] = None
        self.on_auth: Optional[Callable] = None
        self.on_disconnect: Optional[Callable] = None
        self.on_frame: Optional[Callable] = None

    async def start(self):
        """Start server + register mDNS."""
        self._server = await asyncio.start_server(
            self._handle_client,
            host=self._host,
            port=self._port,
        )

        # Register mDNS — gagal gak masalah, server tetap jalan
        try:
            host_ip = _get_local_ip()
            await register_mdns(host=host_ip, port=self._port, name=self._mdns_name)
        except Exception as e:
            logger.warning(f"mDNS registration skipped: {e}")

        addr = self._server.sockets[0].getsockname()
        logger.info("")
        logger.info(f"  ╔═══════════════════════════════════════╗")
        logger.info(f"  ║   NIU-CAST TCCP Server               ║")
        logger.info(f"  ║   Listening: {addr[0]}:{addr[1]}         ")
        logger.info(f"  ║   mDNS: {SERVICE_TRANCAST:<33}║")
        logger.info(f"  ╚═══════════════════════════════════════╝")
        logger.info("")
        logger.info("  Buka Joy Connect di HP Infinix,")
        logger.info(f"  nanti akan muncul '{self._mdns_name or _get_mdns_default()}'")
        logger.info("  atau nama yang bisa di-tap.")
        logger.info("")

        async with self._server:
            await self._server.serve_forever()

    async def stop(self):
        """Stop server."""
        self._connected = False
        await unregister_mdns_all()
        if self._server:
            self._server.close()
            await self._server.wait_closed()
        logger.info("Server stopped")

    async def _handle_client(self, reader: asyncio.StreamReader,
                             writer: asyncio.StreamWriter):
        """Handle satu koneksi dari HP."""
        peer = writer.get_extra_info('peername')
        logger.info(f"\n📱 HP connect dari {peer}")
        self._connected = True

        if self.on_connect:
            await self._on_callback(self.on_connect, peer)

        try:
            # Kirim 7 frame awal (sama kayak yang dikirim HP ke kita)
            await self._send_initial_frames(writer)

            # Loop baca frame dari HP
            buf = b''
            while self._connected:
                try:
                    data = await asyncio.wait_for(reader.read(65536), timeout=30.0)
                    if not data:
                        logger.info("HP disconnected (EOF)")
                        break

                    buf += data

                    # Parse semua frame dari buffer
                    while len(buf) >= 23:
                        frame, used = TCCPFrame.from_buffer(buf, 0)
                        if frame is None:
                            break
                        buf = buf[used:]

                        await self._handle_frame(frame, writer)

                except asyncio.TimeoutError:
                    # Kirim heartbeat periodik
                    await self._send_frame(writer, 0x0900, '{"count":0}')

        except Exception as e:
            logger.error(f"Error: {e}")
        finally:
            self._connected = False
            writer.close()
            try:
                await writer.wait_closed()
            except Exception:
                pass
            logger.info(f"❌ HP disconnected: {peer}")
            if self.on_disconnect:
                await self._on_callback(self.on_disconnect)

    async def _send_initial_frames(self, writer: asyncio.StreamWriter):
        """Kirim 7 frame awal kaya yang dikirim server HP."""
        logger.info("  Mengirim 7 frame awal...")

        frames = [
            (0x0606, '{"port":12000}'),
            (0x0404, '{"a":"xos"}'),
            (0x0607, json.dumps({
                "controlPort": 9542,
                "filePort": 10001,
                "port": 8008,
                "supportVersions": [1, 2, 3],
            })),
            (0x062a, '{"data":50314,"type":0}'),
            (0x0615, '{"count":3}'),
            (0x0403, '{"scene":0,"videoPort":0}'),
            (0x0900, '{"count":0}'),
        ]

        for op, payload in frames:
            await self._send_frame(writer, op, payload)
            await asyncio.sleep(0.05)

        logger.info(f"  ✓ {len(frames)} frames sent")

    async def _send_frame(self, writer: asyncio.StreamWriter,
                          op: int, payload: str):
        """Kirim satu TCCP frame."""
        try:
            frame = TCCPFrame(op, payload)
            data = frame.encode(msg_id=1, version=0xFF)  # 0xFF = server
            writer.write(data)
            await writer.drain()
            logger.debug(f"  → [0x{op:04x}] {payload[:60]}")
        except Exception as e:
            logger.error(f"  Gagal kirim frame: {e}")

    async def _handle_frame(self, frame: TCCPFrame,
                            writer: asyncio.StreamWriter):
        """Proses frame dari HP."""
        op = frame.operator

        if self.on_frame:
            await self._on_callback(self.on_frame, frame)

        if op == 0x0700:  # CONN_AUTH
            logger.info(f"  📱 AUTH dari HP: {frame.payload[:120]}")
            try:
                info = json.loads(frame.payload)
                self._phone = info

                # Kirim AUTH_OK
                await self._send_frame(writer, 0x0701,
                    json.dumps({"result": 0, "msg": "ok"}))
                logger.info(f"  ✓ AUTH OK! HP: {info.get('deviceName', '?')}")

                if self.on_auth:
                    await self._on_callback(self.on_auth, info)

            except json.JSONDecodeError:
                logger.warning(f"  AUTH payload bukan JSON")

        elif op == 0x0900:  # Heartbeat
            logger.debug(f"  ♥ Heartbeat: {frame.payload[:40]}")
            await self._send_frame(writer, 0x0900, '{"count":0}')

        elif op == 0x0604:  # CAST_START
            logger.info(f"  📺 CAST_START: {frame.payload[:120]}")
            await self._send_frame(writer, 0x0605,
                json.dumps({"result": 0, "videoPort": 8008}))

        elif op == 0x0403:  # Scene info
            logger.debug(f"  Scene: {frame.payload[:60]}")

        else:
            logger.debug(f"  Frame [0x{op:04x}]: {frame.payload[:80]}")

    async def _on_callback(self, callback, *args):
        """Panggil callback, tangani kalo async/sync."""
        try:
            if asyncio.iscoroutinefunction(callback):
                await callback(*args)
            else:
                callback(*args)
        except Exception as e:
            logger.error(f"Callback error: {e}")


# ── Helpers (internal) ──────────────────────────────────────────────────────────

def _get_mdns_default() -> str:
    import getpass
    return f"NIU-CAST-{getpass.getuser()}"


# ── CLI ────────────────────────────────────────────────────────────────────────

def main():
    """CLI entry."""
    import argparse
    logging.basicConfig(level=logging.INFO,
                       format='%(asctime)s.%(msecs)03d %(message)s',
                       datefmt='%H:%M:%S')

    parser = argparse.ArgumentParser(
        description='NIU CAST — TCCP Server (seperti Joy Connect Windows)',
    )
    parser.add_argument('--port', type=int, default=PORT_TCCP,
                       help=f'Port (default: {PORT_TCCP})')
    parser.add_argument('--name', default=None,
                       help='Nama yang muncul di HP')
    args = parser.parse_args()

    server = TranCastServer(port=args.port, mdns_name=args.name)

    try:
        asyncio.run(server.start())
    except KeyboardInterrupt:
        print("\nShutting down...")
        asyncio.run(server.stop())

    return 0


if __name__ == '__main__':
    sys.exit(main())
