package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import k.b;
import lzma.sdk.ICodeProgress;
import lzma.sdk.lzma.Encoder;

/* JADX INFO: loaded from: classes3.dex */
public class LzmaFrameEncoder extends MessageToByteEncoder<ByteBuf> {
    private static final int DEFAULT_LC = 3;
    private static final int DEFAULT_LP = 0;
    private static final int DEFAULT_MATCH_FINDER = 1;
    private static final int DEFAULT_PB = 2;
    private static final int MAX_FAST_BYTES = 273;
    private static final int MEDIUM_DICTIONARY_SIZE = 65536;
    private static final int MEDIUM_FAST_BYTES = 32;
    private static final int MIN_FAST_BYTES = 5;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) LzmaFrameEncoder.class);
    private static boolean warningLogged;
    private final Encoder encoder;
    private final int littleEndianDictionarySize;
    private final byte properties;

    public LzmaFrameEncoder() {
        this(65536);
    }

    private static int maxOutputBufferLength(int i10) {
        double d10;
        if (i10 < 200) {
            d10 = 1.5d;
        } else if (i10 < 500) {
            d10 = 1.2d;
        } else if (i10 < 1000) {
            d10 = 1.1d;
        } else {
            d10 = i10 < 10000 ? 1.05d : 1.02d;
        }
        return ((int) (((double) i10) * d10)) + 13;
    }

    public LzmaFrameEncoder(int i10, int i11, int i12) {
        this(i10, i11, i12, 65536);
    }

    @Override // io.netty.handler.codec.MessageToByteEncoder
    public ByteBuf allocateBuffer(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, boolean z10) throws Exception {
        return channelHandlerContext.alloc().ioBuffer(maxOutputBufferLength(byteBuf.readableBytes()));
    }

    @Override // io.netty.handler.codec.MessageToByteEncoder
    public void encode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, ByteBuf byteBuf2) throws Exception {
        ByteBufOutputStream byteBufOutputStream;
        int i10 = byteBuf.readableBytes();
        ByteBufInputStream byteBufInputStream = null;
        try {
            ByteBufInputStream byteBufInputStream2 = new ByteBufInputStream(byteBuf);
            try {
                byteBufOutputStream = new ByteBufOutputStream(byteBuf2);
                try {
                    byteBufOutputStream.writeByte(this.properties);
                    byteBufOutputStream.writeInt(this.littleEndianDictionarySize);
                    byteBufOutputStream.writeLong(Long.reverseBytes(i10));
                    this.encoder.code(byteBufInputStream2, byteBufOutputStream, -1L, -1L, (ICodeProgress) null);
                    byteBufInputStream2.close();
                    byteBufOutputStream.close();
                } catch (Throwable th2) {
                    th = th2;
                    byteBufInputStream = byteBufInputStream2;
                    if (byteBufInputStream != null) {
                        byteBufInputStream.close();
                    }
                    if (byteBufOutputStream != null) {
                        byteBufOutputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                byteBufOutputStream = null;
            }
        } catch (Throwable th4) {
            th = th4;
            byteBufOutputStream = null;
        }
    }

    public LzmaFrameEncoder(int i10) {
        this(3, 0, 2, i10);
    }

    public LzmaFrameEncoder(int i10, int i11, int i12, int i13) {
        this(i10, i11, i12, i13, false, 32);
    }

    public LzmaFrameEncoder(int i10, int i11, int i12, int i13, boolean z10, int i14) {
        if (i10 < 0 || i10 > 8) {
            throw new IllegalArgumentException(b.a("lc: ", i10, " (expected: 0-8)"));
        }
        if (i11 < 0 || i11 > 4) {
            throw new IllegalArgumentException(b.a("lp: ", i11, " (expected: 0-4)"));
        }
        if (i12 >= 0 && i12 <= 4) {
            if (i10 + i11 > 4 && !warningLogged) {
                logger.warn("The latest versions of LZMA libraries (for example, XZ Utils) has an additional requirement: lc + lp <= 4. Data which don't follow this requirement cannot be decompressed with this libraries.");
                warningLogged = true;
            }
            if (i13 < 0) {
                throw new IllegalArgumentException(b.a("dictionarySize: ", i13, " (expected: 0+)"));
            }
            if (i14 >= 5 && i14 <= MAX_FAST_BYTES) {
                Encoder encoder = new Encoder();
                this.encoder = encoder;
                encoder.setDictionarySize(i13);
                encoder.setEndMarkerMode(z10);
                encoder.setMatchFinder(1);
                encoder.setNumFastBytes(i14);
                encoder.setLcLpPb(i10, i11, i12);
                this.properties = (byte) ((((i12 * 5) + i11) * 9) + i10);
                this.littleEndianDictionarySize = Integer.reverseBytes(i13);
                return;
            }
            throw new IllegalArgumentException(String.format("numFastBytes: %d (expected: %d-%d)", Integer.valueOf(i14), 5, Integer.valueOf(MAX_FAST_BYTES)));
        }
        throw new IllegalArgumentException(b.a("pb: ", i12, " (expected: 0-4)"));
    }
}
