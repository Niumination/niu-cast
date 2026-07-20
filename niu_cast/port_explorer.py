"""
NIU CAST — Port Explorer untuk Infinix GT 30 Pro
Menjelajahi port-port TCCP tambahan yang ditemukan dari auth response.

Port yang diketahui:
  - 9452  : TCCP control server (fixed)
  - 8008  : ? (dari 0x0607 auth response)
  - 9542  : Control channel (dari 0x0607 auth response)
  - 10001 : File transfer (dari 0x0607 auth response)

Usage:
  python -m niu_cast.port_explorer
  python -m niu_cast.port_explorer --port 9542 --tccp
"""

import asyncio
import json
import logging
import struct
import sys
import time
from typing import Optional

logging.basicConfig(level=logging.INFO, format='%(message)s')
log = logging.getLogger('port_explorer')

TCCP_MAGIC = b'TCCP'

def make_tccp_frame(op: int, payload: dict, msg_id: int = 1) -> bytes:
    """Buat TCCP frame untuk dikirim."""
    p = json.dumps(payload, separators=(',', ':'))
    bl = 15 + len(p)
    ts = int(time.time() * 1000000)
    return (TCCP_MAGIC + b'\x00' +
            struct.pack('>I', bl) +
            struct.pack('>H', op) +
            struct.pack('>I', msg_id) +
            struct.pack('>Q', ts) +
            p.encode() + b'\x00')

def parse_tccp_frames(data: bytes):
    """Parse semua TCCP frame dari buffer."""
    frames = []
    offset = 0
    while offset < len(data) - 8:
        if data[offset:offset+4] != TCCP_MAGIC:
            break
        bl = struct.unpack('>I', data[offset+5:offset+9])[0]
        op = struct.unpack('>H', data[offset+9:offset+11])[0]
        mid = struct.unpack('>I', data[offset+11:offset+15])[0]
        ts = struct.unpack('>Q', data[offset+15:offset+23])[0]
        pstart = offset + 23

        if data[pstart:pstart+1] == b'{':
            st = None
            pl = data[pstart:pstart+bl-15-1]
        else:
            st = struct.unpack('>I', data[pstart:pstart+4])[0]
            pl = data[pstart+4:pstart+4+bl-19-1]

        frames.append({
            'op': op, 'mid': mid, 'ts': ts, 'status': st,
            'payload': pl.decode(errors='replace'),
            'hex': data[offset:offset+9+bl].hex(),
        })
        offset += 9 + bl
    return frames, data[offset:]

async def probe_tcp(host: str, port: int, timeout: float = 3.0) -> dict:
    """Coba TCP connect dan baca data awal."""
    result = {'port': port, 'connected': False, 'initial_data': b'', 'error': None}
    try:
        r, w = await asyncio.wait_for(
            asyncio.open_connection(host, port), timeout=timeout)
        result['connected'] = True
        log.info(f"  ✓ Port {port}: TERKONEKSI!")

        # Baca data awal
        buf = b''
        for _ in range(30):
            try:
                chunk = await asyncio.wait_for(r.read(4096), timeout=0.3)
                if not chunk:
                    break
                buf += chunk
            except asyncio.TimeoutError:
                if buf:
                    break
                continue

        result['initial_data'] = buf
        if buf:
            log.info(f"    Data awal: {len(buf)} bytes")

            # Cek apakah ini TCCP
            if buf[:4] == TCCP_MAGIC:
                frames, rest = parse_tccp_frames(buf)
                result['protocol'] = 'TCCP'
                result['tccp_frames'] = frames
                log.info(f"    Protocol: TCCP ({len(frames)} frame(s))")
                for f in frames[:5]:
                    log.info(f"      [0x{f['op']:04x}] {f['payload'][:120]}")
                if rest:
                    log.info(f"    Sisa buffer: {rest.hex()[:60]}")
            elif buf[:4] == b'HTTP':
                result['protocol'] = 'HTTP'
                log.info(f"    Protocol: HTTP")
                log.info(f"    Response: {buf[:200].decode(errors='replace')}")
            else:
                result['protocol'] = 'RAW'
                log.info(f"    Protocol: RAW")
                log.info(f"    Hex: {buf.hex()[:200]}")
        else:
            log.info(f"    Tidak ada data awal (koneksi diam)")

        w.close()
        await w.wait_closed()

    except ConnectionRefusedError:
        result['error'] = 'refused'
        log.info(f"  ✗ Port {port}: DITOLAK")
    except asyncio.TimeoutError:
        result['error'] = 'timeout'
        log.info(f"  ✗ Port {port}: TIMEOUT")
    except OSError as e:
        result['error'] = str(e)
        log.info(f"  ✗ Port {port}: {e}")

    return result


async def probe_tccp(host: str, port: int, timeout: float = 3.0) -> dict:
    """Konek ke port, kirim TCCP AUTH, baca response."""
    result = {'port': port, 'connected': False, 'auth_response': b'', 'error': None}
    try:
        r, w = await asyncio.wait_for(
            asyncio.open_connection(host, port), timeout=timeout)
        result['connected'] = True
        log.info(f"  ✓ Port {port}: KONEK (TCCP probe)")

        # Kirim CONN_AUTH
        auth_frame = make_tccp_frame(0x700, {
            'deviceName': 'Mac',
            'deviceType': 'pc',
            'appVersion': '3.0.0'
        })
        w.write(auth_frame)
        await w.drain()
        log.info(f"    Mengirim AUTH ({len(auth_frame)} bytes)")

        # Baca response
        buf = b''
        for _ in range(30):
            try:
                chunk = await asyncio.wait_for(r.read(4096), timeout=0.3)
                if not chunk:
                    break
                buf += chunk
            except asyncio.TimeoutError:
                if buf:
                    break
                continue

        result['auth_response'] = buf
        if buf:
            log.info(f"    Response: {len(buf)} bytes")
            if buf[:4] == TCCP_MAGIC:
                frames, rest = parse_tccp_frames(buf)
                log.info(f"    TCCP frames: {len(frames)}")
                for f in frames:
                    log.info(f"      [0x{f['op']:04x}] {f['payload'][:120]}")
            else:
                log.info(f"    Hex: {buf.hex()[:200]}")
        else:
            log.info(f"    Tidak ada response")

        w.close()
        await w.wait_closed()

    except ConnectionRefusedError:
        result['error'] = 'refused'
        log.info(f"  ✗ Port {port}: DITOLAK")
    except asyncio.TimeoutError:
        result['error'] = 'timeout'
        log.info(f"  ✗ Port {port}: TIMEOUT")
    except OSError as e:
        result['error'] = str(e)
        log.info(f"  ✗ Port {port}: {e}")
    except Exception as e:
        result['error'] = str(e)
        log.info(f"  ✗ Port {port}: ERROR {e}")

    return result


async def explore_all(host: str, ports: list = None, do_tccp: bool = False):
    """Jelajahi semua port."""
    if ports is None:
        ports = [8008, 9542, 10001]

    print(f"\n{'='*60}")
    print(f"  EXPLORE PORTS: {host}")
    print(f"  TCCP probe: {'YES' if do_tccp else 'NO'}")
    print(f"{'='*60}")

    results = {}
    for port in ports:
        print(f"\n--- Port {port} ---")
        if do_tccp:
            res = await probe_tccp(host, port)
        else:
            res = await probe_tcp(host, port)
        results[port] = res

    print(f"\n{'='*60}")
    print(f"  RINGKASAN:")
    for port, res in results.items():
        icon = '✓' if res['connected'] else '✗'
        proto = res.get('protocol', '?')
        err = res.get('error', '')
        status = f"{proto}" if res['connected'] else f"ERROR: {err}"
        print(f"  {icon} Port {port}: {status}")
    print(f"{'='*60}\n")

    return results


async def main():
    import argparse
    parser = argparse.ArgumentParser(description='TCCP Port Explorer')
    parser.add_argument('--host', default='127.0.0.1',
                        help='Host HP (default: 127.0.0.1 via ADB)')
    parser.add_argument('--port', type=int, default=None,
                        help='Port spesifik (default: semua 8008,9542,10001)')
    parser.add_argument('--tccp', action='store_true',
                        help='Kirim TCCP AUTH setelah konek')
    parser.add_argument('--adb', action='store_true',
                        help='Forward port via ADB otomatis')
    args = parser.parse_args()

    host = args.host
    ports = [args.port] if args.port else [8008, 9542, 10001]

    if args.adb:
        import subprocess
        for p in [9452] + ports:
            log.info(f"ADB forward tcp:{p} tcp:{p}")
            subprocess.run(['adb', 'forward', f'tcp:{p}', f'tcp:{p}'],
                          capture_output=True)
        host = '127.0.0.1'

    await explore_all(host, ports, do_tccp=args.tccp)


if __name__ == '__main__':
    asyncio.run(main())
