"""
NIU CAST — Video Stream Receiver

Menerima dan memproses video stream dari TCCP port 8008 (ScreenCast).

Berdasarkan analisis decompile APK:
  - Port 8008 = ScreenCast/Video stream (field "port" di 0x0607)
  - Format: H.264 (encodeType) atau H.265
  - Stream dikirim setelah CAST_START (0x0604) disetujui

Alur:
  1. TCCP handshake di port 9452 ✅
  2. CAST_START request → server mulai stream di port 8008
  3. Konek ke port 8008 → terima H.264/H.265 NAL units
  4. Decode dan render

Usage:
  python3 -m niu_cast video-stream         # auto-connect + stream
  python3 -m niu_cast video-stream --save  # simpan ke file
"""

import asyncio
import json
import logging
import os
import struct
import subprocess
import sys
import tempfile
import time
from typing import Optional

from .transsion_protocol import (
    PORT_TCCP, PORT_CONTROL, PORT_FILE, PORT_SCREENCAST,
    TCCP_OP, TranCastProtocol, TranCastMultiPort,
    logger as proto_logger,
)

logger = logging.getLogger(__name__)

# Constants for common NAL unit types (H.264)
NAL_TYPE_NON_IDR = 1
NAL_TYPE_IDR = 5
NAL_TYPE_SEI = 6
NAL_TYPE_SPS = 7
NAL_TYPE_PPS = 8

# H.265 NAL unit types
HEVC_NAL_TYPE_VPS = 32
HEVC_NAL_TYPE_SPS = 33
HEVC_NAL_TYPE_PPS = 34
HEVC_NAL_TYPE_IDR = 19
HEVC_NAL_TYPE_NON_IDR = 1


class VideoStreamParser:
    """
    Parse video stream dari TCCP port 8008.
    
    Stream format (dari decompile code analysis):
      Setiap frame punya header:
        [4 bytes]  Frame length (big-endian, includes header)
        [1 byte]   Frame type (0x01=video, 0x02=config, 0x03=keyframe)
        [4 bytes]  Timestamp (ms)
        [N bytes]  Video data (H.264 NAL units with 4-byte length prefix)
    
    Atau format alternatif (raw H.264):
        [4 bytes]  NAL unit length (big-endian)
        [N bytes]  NAL unit data
    """
    
    def __init__(self):
        self._buffer = bytearray()
        self._frame_count = 0
        self._total_bytes = 0
        self._config_data = b''  # SPS/PPS
        
    def feed(self, data: bytes) -> list:
        """
        Feed data ke parser, return list of parsed frames.
        
        Setiap frame dict:
          - type: 'config' | 'keyframe' | 'delta' | 'unknown'
          - ts: timestamp (ms)
          - size: size in bytes
          - nal_units: list of NAL types found
          - raw: raw frame data
        """
        self._buffer.extend(data)
        frames = []
        
        while len(self._buffer) >= 8:
            # Cek format: apakah ada frame header?
            # Frame header: [4B length][1B type][4B timestamp]
            frame_len = struct.unpack('>I', self._buffer[0:4])[0]
            
            if frame_len > 1024 * 1024 * 10:  # > 10MB = invalid
                logger.warning(f"Frame length too large: {frame_len}, skipping")
                self._buffer.clear()
                break
            
            if frame_len <= 0:
                self._buffer.pop(0)
                continue
            
            total_len = frame_len
            if total_len > len(self._buffer):
                break  # incomplete, wait for more data
            
            # Parse frame
            raw_frame = bytes(self._buffer[:total_len])
            self._buffer = self._buffer[total_len:]
            
            frame = self._parse_frame(raw_frame)
            if frame:
                frames.append(frame)
                
        return frames
    
    def _parse_frame(self, raw: bytes) -> Optional[dict]:
        """Parse single frame."""
        if len(raw) < 9:
            return None
            
        frame_len = struct.unpack('>I', raw[0:4])[0]
        frame_type = raw[4]
        ts = struct.unpack('>I', raw[5:9])[0]
        video_data = raw[9:]
        
        self._frame_count += 1
        self._total_bytes += len(raw)
        
        # Parse NAL units dari video data
        nal_types = self._parse_nal_units(video_data)
        
        type_map = {1: 'config', 2: 'keyframe', 3: 'delta'}
        ftype = type_map.get(frame_type, 'unknown')
        
        # Save SPS/PPS
        if ftype == 'config' and not self._config_data:
            self._config_data = video_data
            logger.info(f"  Config frame: {len(video_data)} bytes, NALs: {nal_types}")
        
        if self._frame_count <= 5:
            logger.debug(f"  Frame #{self._frame_count}: type={ftype}, "
                        f"ts={ts}ms, size={len(video_data)}B, NALs={nal_types}")
        
        return {
            'type': ftype,
            'ts': ts,
            'size': len(video_data),
            'total_size': len(raw),
            'nal_units': nal_types,
            'raw': video_data,
            'frame_num': self._frame_count,
        }
    
    def _parse_nal_units(self, data: bytes) -> list:
        """Parse NAL units dari H.264/H.265 stream."""
        nal_types = []
        offset = 0
        
        while offset + 4 <= len(data):
            nal_len = struct.unpack('>I', data[offset:offset+4])[0]
            if nal_len <= 0 or nal_len > len(data) - offset - 4:
                break
            
            offset += 4
            nal_data = data[offset:offset+nal_len]
            offset += nal_len
            
            if nal_data:
                # H.264: first byte = [F|NRI|TYPE]
                nal_type_h264 = nal_data[0] & 0x1F
                # H.265: first byte = [LAYER|TYPE>>6], second byte = [TYPE<<2|...]
                nal_type_hevc = (nal_data[0] >> 1) & 0x3F if len(nal_data) > 1 else 0
                
                nal_types.append({
                    'h264': nal_type_h264,
                    'hevc': nal_type_hevc,
                    'size': nal_len,
                })
        
        return nal_types
    
    def get_stats(self) -> dict:
        """Get stream statistics."""
        return {
            'frames': self._frame_count,
            'bytes': self._total_bytes,
            'has_config': len(self._config_data) > 0,
            'config_size': len(self._config_data),
        }


class TranCastVideoStream:
    """
    Client video streaming via TCCP.
    
    Flow:
      1. TCCP handshake (9452)
      2. Send CAST_START
      3. Connect ke port 8008 untuk video
      4. Parse stream
      5. Send CAST_STOP saat selesai
    """
    
    def __init__(self, host: str, tccp_port: int = PORT_TCCP,
                 video_port: int = PORT_SCREENCAST):
        self._host = host
        self._tccp_port = tccp_port
        self._video_port = video_port
        self._tccp: Optional[TranCastProtocol] = None
        self._reader: Optional[asyncio.StreamReader] = None
        self._writer: Optional[asyncio.StreamWriter] = None
        self._parser = VideoStreamParser()
        self._running = False
        self._frames = []
    
    async def connect(self) -> bool:
        """Connect TCCP + start video stream."""
        # Step 1: TCCP handshake
        logger.info("Step 1: TCCP handshake...")
        self._tccp = TranCastProtocol(self._host, self._tccp_port)
        if not await self._tccp.connect():
            logger.error("Gagal TCCP handshake")
            return False
        
        # Step 2: Kirim CAST_START
        logger.info("Step 2: Mengirim CAST_START...")
        config = {
            'width': 1080,
            'height': 2400,
            'dpi': 480,
            'bitrate': 5000000,
            'frameRate': 30,
            'iFrameInterval': 5,
            'encodeType': 'H264',
            'orientation': 0,
        }
        if not await self._tccp.send_request(
            TCCP_OP.get('CAST_START', 0x604),
            json.dumps(config)
        ):
            logger.error("Gagal CAST_START")
            await self._tccp.disconnect()
            return False
        
        logger.info(f"  CAST_START sent, waiting for response...")
        resp = await self._tccp.recv_frame()
        if resp:
            logger.info(f"  Response: [{hex(resp.operator)}] {resp.payload[:200]}")
        
        # Step 3: Connect ke video port
        logger.info(f"Step 3: Connect ke video port {self._video_port}...")
        try:
            self._reader, self._writer = await asyncio.wait_for(
                asyncio.open_connection(self._host, self._video_port),
                timeout=5.0,
            )
            self._running = True
            logger.info(f"  ✓ Connected to video stream!")
            return True
            
        except (asyncio.TimeoutError, ConnectionRefusedError, OSError) as e:
            logger.error(f"  Gagal connect ke port {self._video_port}: {e}")
            await self._tccp.disconnect()
            return False
    
    async def receive_stream(self, duration: float = 10.0,
                              callback=None, save_to: str = None):
        """
        Receive video stream.
        
        Args:
            duration: Max duration in seconds
            callback: Optional callback(frame) per frame
            save_to: Optional path to save raw stream
        """
        if not self._running:
            logger.error("Stream not running")
            return
        
        start_time = time.time()
        save_fd = None
        if save_to:
            save_fd = open(save_to, 'wb')
        
        try:
            while self._running and (time.time() - start_time) < duration:
                try:
                    data = await asyncio.wait_for(
                        self._reader.read(65536), timeout=2.0
                    )
                    if not data:
                        logger.info("Stream ended (EOF)")
                        break
                    
                    if save_fd:
                        save_fd.write(data)
                    
                    frames = self._parser.feed(data)
                    self._frames.extend(frames)
                    
                    for frame in frames:
                        if callback:
                            await callback(frame)
                    
                    # Progress setiap 30 frame
                    if self._parser._frame_count % 30 == 0:
                        stats = self._parser.get_stats()
                        elapsed = time.time() - start_time
                        mbps = (stats['bytes'] * 8) / (elapsed * 1_000_000) if elapsed > 0 else 0
                        logger.info(
                            f"  Stream: {stats['frames']} frames, "
                            f"{stats['bytes']/1024:.0f}KB, "
                            f"{mbps:.1f} Mbps"
                        )
                        
                except asyncio.TimeoutError:
                    # No data for 2s - still connected, just idle
                    continue
                    
        except asyncio.CancelledError:
            logger.info("Stream cancelled")
        except Exception as e:
            logger.error(f"Stream error: {e}")
        finally:
            if save_fd:
                save_fd.close()
            self._running = False
    
    async def stop(self):
        """Stop stream."""
        self._running = False
        if self._writer:
            self._writer.close()
            try:
                await self._writer.wait_closed()
            except Exception:
                pass
        if self._tccp:
            await self._tccp.send_request(
                TCCP_OP.get('CAST_STOP', 0x605), '{}'
            )
            await self._tccp.disconnect()
        
        stats = self._parser.get_stats()
        logger.info(f"\nStream summary:")
        logger.info(f"  Frames: {stats['frames']}")
        logger.info(f"  Data:   {stats['bytes']/1024:.1f} KB")
        logger.info(f"  Config: {'✓' if stats['has_config'] else '✗'}")


# ── Tests (tanpa device) ──────────────────────────────────────────────────────

def test_video_stream_parser():
    """Test parser dengan synthetic H.264 data."""
    parser = VideoStreamParser()
    
    def make_sps_pps():
        """Buat synthetic SPS/PPS config frame."""
        # H.264 SPS NAL (type 7)
        sps = bytes([0x67, 0x42, 0x00, 0x1e, 0x99])  # SPS
        pps = bytes([0x68, 0xce, 0x38, 0x80])         # PPS
        
        # NAL length prefix (4 bytes)
        nal_data = (
            struct.pack('>I', len(sps)) + sps +
            struct.pack('>I', len(pps)) + pps
        )
        
        # Frame header: length + type(1=config) + timestamp
        frame = (
            struct.pack('>I', 9 + len(nal_data)) +  # total length
            bytes([0x01]) +                          # type=config
            struct.pack('>I', 0) +                   # ts=0
            nal_data
        )
        return frame
    
    def make_idr_frame(ts: int):
        """Buat synthetic IDR frame."""
        # H.264 IDR NAL (type 5)
        idr = bytes([0x65, 0x88, 0x84, 0x00, 0x01, 0x23, 0x45] +
                     [0x00] * 50)  # dummy data
        
        nal_data = struct.pack('>I', len(idr)) + idr
        frame = (
            struct.pack('>I', 9 + len(nal_data)) +
            bytes([0x02]) +                          # type=keyframe
            struct.pack('>I', ts) +
            nal_data
        )
        return frame
    
    # Test 1: Config frame
    frames = parser.feed(make_sps_pps())
    assert len(frames) == 1
    assert frames[0]['type'] == 'config'
    assert len(frames[0]['nal_units']) == 2  # SPS + PPS
    print("✓ Config frame parsed correctly")
    
    # Test 2: IDR frame  
    frames = parser.feed(make_idr_frame(33))
    assert len(frames) == 1
    assert frames[0]['type'] == 'keyframe'
    assert frames[0]['ts'] == 33
    print("✓ IDR frame parsed correctly")
    
    # Test 3: Multiple frames
    data = b''
    for ts in range(0, 100, 33):
        data += make_idr_frame(ts)
    frames = parser.feed(data)
    assert len(frames) == 4  # 0, 33, 66, 99
    print(f"✓ {len(frames)} frames parsed from batch")
    
    # Test 4: Stats
    stats = parser.get_stats()
    assert stats['frames'] >= 6
    assert stats['has_config']
    print(f"✓ Stats: {stats['frames']} frames, {stats['bytes']} bytes")
    
    print("\n✓ All video parser tests passed!")


def test_uibc_builder():
    """Test UIBC packet construction."""
    from .transsion_protocol import UIBCBuilder
    
    # Touch
    touch = UIBCBuilder.build_touch(500, 1000, UIBCBuilder.ACTION_DOWN)
    assert len(touch) == 20
    assert touch[0:2] == struct.pack('>H', 2)  # type touch
    print(f"✓ Touch packet: {len(touch)} bytes")
    
    # Keyboard
    kb = UIBCBuilder.build_keyboard(66)  # KEYCODE_ENTER
    assert len(kb) == 16
    assert kb[0:2] == struct.pack('>H', 3)  # type keyboard
    print(f"✓ Keyboard packet: {len(kb)} bytes")
    
    # Mouse
    mouse = UIBCBuilder.build_mouse(10, 20, 1)
    assert len(mouse) == 20
    assert mouse[0:2] == struct.pack('>H', 4)  # type mouse
    print(f"✓ Mouse packet: {len(mouse)} bytes")
    
    print("✓ All UIBC tests passed!")


def test_trancast_multiport():
    """Test TranCastMultiPort creation."""
    from .transsion_protocol import TranCastMultiPort
    
    mp = TranCastMultiPort('192.168.1.100')
    assert mp.PORT_TCCP == 9452
    assert mp.PORT_CONTROL == 9542
    assert mp.PORT_FILE == 10001
    print(f"✓ TranCastMultiPort: {mp.PORT_TCCP}, {mp.PORT_CONTROL}, {mp.PORT_FILE}")


def run_all_tests():
    """Run semua tests."""
    print("=" * 50)
    print("  NIU-CAST Integration Tests")
    print("=" * 50)
    print()
    
    test_uibc_builder()
    print()
    test_video_stream_parser()
    print()
    test_trancast_multiport()
    
    print()
    print("=" * 50)
    print("  ✅ ALL TESTS PASSED")
    print("  (No device required)")
    print("=" * 50)


# ── CLI ────────────────────────────────────────────────────────────────────────

def main():
    """CLI entry."""
    import argparse
    logging.basicConfig(level=logging.INFO, format='%(message)s')
    
    parser = argparse.ArgumentParser(
        description='NIU CAST — Video Stream',
    )
    parser.add_argument('--save', metavar='FILE',
                        help='Save raw stream to file')
    parser.add_argument('--duration', type=float, default=10.0,
                        help='Stream duration in seconds')
    parser.add_argument('--test', action='store_true',
                        help='Run integration tests (no device)')
    parser.add_argument('--host', default=None,
                        help='Phone IP (auto-detect if omitted)')
    args = parser.parse_args()
    
    if args.test:
        run_all_tests()
        return 0
    
    # Live streaming mode (butuh device)
    host = args.host
    if not host:
        logger.info("No host specified. Auto-detecting...")
        from .auto_connect import auto_connect
        client = asyncio.run(auto_connect(subnet='192.168.1.0/24'))
        if client:
            host = client._host
            logger.info(f"Found phone at {host}")
            asyncio.run(client.disconnect())
        else:
            logger.error("No phone found. Use --host IP or connect phone")
            logger.info("\nCoba: python3 -m niu_cast video-stream --test")
            return 1
    
    logger.info(f"Connecting to {host} for video stream...")
    streamer = TranCastVideoStream(host)
    
    async def run():
        if not await streamer.connect():
            return False
        
        await streamer.receive_stream(
            duration=args.duration,
            save_to=args.save,
        )
        await streamer.stop()
        return True
    
    success = asyncio.run(run())
    return 0 if success else 1


if __name__ == '__main__':
    sys.exit(main())
