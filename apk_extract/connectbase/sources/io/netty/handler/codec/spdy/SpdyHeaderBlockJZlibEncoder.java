package io.netty.handler.codec.spdy;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.jcraft.jzlib.Deflater;
import com.jcraft.jzlib.JZlib;
import h.a;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.compression.CompressionException;
import io.netty.util.internal.ObjectUtil;
import k.b;

/* JADX INFO: loaded from: classes3.dex */
class SpdyHeaderBlockJZlibEncoder extends SpdyHeaderBlockRawEncoder {
    private boolean finished;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final Deflater f8331z;

    public SpdyHeaderBlockJZlibEncoder(SpdyVersion spdyVersion, int i10, int i11, int i12) {
        super(spdyVersion);
        Deflater deflater = new Deflater();
        this.f8331z = deflater;
        if (i10 < 0 || i10 > 9) {
            throw new IllegalArgumentException(b.a("compressionLevel: ", i10, " (expected: 0-9)"));
        }
        if (i11 < 9 || i11 > 15) {
            throw new IllegalArgumentException(b.a("windowBits: ", i11, " (expected: 9-15)"));
        }
        if (i12 < 1 || i12 > 9) {
            throw new IllegalArgumentException(b.a("memLevel: ", i12, " (expected: 1-9)"));
        }
        int iDeflateInit = deflater.deflateInit(i10, i11, i12, JZlib.W_ZLIB);
        if (iDeflateInit != 0) {
            throw new CompressionException(a.a("failed to initialize an SPDY header block deflater: ", iDeflateInit));
        }
        byte[] bArr = SpdyCodecUtil.SPDY_DICT;
        int iDeflateSetDictionary = deflater.deflateSetDictionary(bArr, bArr.length);
        if (iDeflateSetDictionary != 0) {
            throw new CompressionException(a.a("failed to set the SPDY dictionary: ", iDeflateSetDictionary));
        }
    }

    private ByteBuf encode(ByteBufAllocator byteBufAllocator) throws Throwable {
        ByteBuf byteBufHeapBuffer;
        try {
            int i10 = this.f8331z.next_in_index;
            int i11 = this.f8331z.next_out_index;
            int iCeil = ((int) Math.ceil(((double) this.f8331z.next_in.length) * 1.001d)) + 12;
            byteBufHeapBuffer = byteBufAllocator.heapBuffer(iCeil);
            try {
                this.f8331z.next_out = byteBufHeapBuffer.array();
                this.f8331z.next_out_index = byteBufHeapBuffer.arrayOffset() + byteBufHeapBuffer.writerIndex();
                this.f8331z.avail_out = iCeil;
                try {
                    int iDeflate = this.f8331z.deflate(2);
                    byteBufHeapBuffer.skipBytes(this.f8331z.next_in_index - i10);
                    if (iDeflate != 0) {
                        throw new CompressionException("compression failure: " + iDeflate);
                    }
                    int i12 = this.f8331z.next_out_index - i11;
                    if (i12 > 0) {
                        byteBufHeapBuffer.writerIndex(byteBufHeapBuffer.writerIndex() + i12);
                    }
                    this.f8331z.next_in = null;
                    this.f8331z.next_out = null;
                    return byteBufHeapBuffer;
                } catch (Throwable th2) {
                    byteBufHeapBuffer.skipBytes(this.f8331z.next_in_index - i10);
                    throw th2;
                }
            } catch (Throwable th3) {
                th = th3;
                this.f8331z.next_in = null;
                this.f8331z.next_out = null;
                if (byteBufHeapBuffer != null) {
                    byteBufHeapBuffer.release();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            byteBufHeapBuffer = null;
        }
    }

    private void setInput(ByteBuf byteBuf) {
        byte[] bArrArray;
        int iArrayOffset;
        int i10 = byteBuf.readableBytes();
        if (byteBuf.hasArray()) {
            bArrArray = byteBuf.array();
            iArrayOffset = byteBuf.readerIndex() + byteBuf.arrayOffset();
        } else {
            bArrArray = new byte[i10];
            byteBuf.getBytes(byteBuf.readerIndex(), bArrArray);
            iArrayOffset = 0;
        }
        this.f8331z.next_in = bArrArray;
        this.f8331z.next_in_index = iArrayOffset;
        this.f8331z.avail_in = i10;
    }

    @Override // io.netty.handler.codec.spdy.SpdyHeaderBlockRawEncoder, io.netty.handler.codec.spdy.SpdyHeaderBlockEncoder
    public void end() {
        if (this.finished) {
            return;
        }
        this.finished = true;
        this.f8331z.deflateEnd();
        this.f8331z.next_in = null;
        this.f8331z.next_out = null;
    }

    @Override // io.netty.handler.codec.spdy.SpdyHeaderBlockRawEncoder, io.netty.handler.codec.spdy.SpdyHeaderBlockEncoder
    public ByteBuf encode(ByteBufAllocator byteBufAllocator, SpdyHeadersFrame spdyHeadersFrame) throws Exception {
        ObjectUtil.checkNotNullWithIAE(byteBufAllocator, "alloc");
        ObjectUtil.checkNotNullWithIAE(spdyHeadersFrame, TypedValues.AttributesType.S_FRAME);
        if (this.finished) {
            return Unpooled.EMPTY_BUFFER;
        }
        ByteBuf byteBufEncode = super.encode(byteBufAllocator, spdyHeadersFrame);
        try {
            if (!byteBufEncode.isReadable()) {
                return Unpooled.EMPTY_BUFFER;
            }
            setInput(byteBufEncode);
            return encode(byteBufAllocator);
        } finally {
            byteBufEncode.release();
        }
    }
}
