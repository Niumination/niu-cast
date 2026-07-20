package io.netty.handler.codec.compression;

import c1.c;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.util.internal.ObjectUtil;
import java.util.List;
import java.util.zip.Checksum;
import net.jpountz.lz4.LZ4Exception;
import net.jpountz.lz4.LZ4Factory;
import net.jpountz.lz4.LZ4FastDecompressor;

/* JADX INFO: loaded from: classes3.dex */
public class Lz4FrameDecoder extends ByteToMessageDecoder {
    private int blockType;
    private ByteBufChecksum checksum;
    private int compressedLength;
    private int currentChecksum;
    private State currentState;
    private int decompressedLength;
    private LZ4FastDecompressor decompressor;

    /* JADX INFO: renamed from: io.netty.handler.codec.compression.Lz4FrameDecoder$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$compression$Lz4FrameDecoder$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$io$netty$handler$codec$compression$Lz4FrameDecoder$State = iArr;
            try {
                iArr[State.INIT_BLOCK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$Lz4FrameDecoder$State[State.DECOMPRESS_DATA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$Lz4FrameDecoder$State[State.FINISHED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$Lz4FrameDecoder$State[State.CORRUPTED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public enum State {
        INIT_BLOCK,
        DECOMPRESS_DATA,
        FINISHED,
        CORRUPTED
    }

    public Lz4FrameDecoder() {
        this(false);
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        ByteBuf byteBufRetainedSlice;
        try {
            int i10 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$compression$Lz4FrameDecoder$State[this.currentState.ordinal()];
            ByteBuf byteBuf2 = null;
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3 && i10 != 4) {
                        throw new IllegalStateException();
                    }
                    byteBuf.skipBytes(byteBuf.readableBytes());
                    return;
                }
            } else {
                if (byteBuf.readableBytes() < 21) {
                    return;
                }
                if (byteBuf.readLong() != 5501767354678207339L) {
                    throw new DecompressionException("unexpected block identifier");
                }
                byte b10 = byteBuf.readByte();
                int i11 = (b10 & c.f1123q) + 10;
                int i12 = b10 & 240;
                int iReverseBytes = Integer.reverseBytes(byteBuf.readInt());
                if (iReverseBytes < 0 || iReverseBytes > 33554432) {
                    throw new DecompressionException(String.format("invalid compressedLength: %d (expected: 0-%d)", Integer.valueOf(iReverseBytes), 33554432));
                }
                int iReverseBytes2 = Integer.reverseBytes(byteBuf.readInt());
                int i13 = 1 << i11;
                if (iReverseBytes2 < 0 || iReverseBytes2 > i13) {
                    throw new DecompressionException(String.format("invalid decompressedLength: %d (expected: 0-%d)", Integer.valueOf(iReverseBytes2), Integer.valueOf(i13)));
                }
                if ((iReverseBytes2 == 0 && iReverseBytes != 0) || ((iReverseBytes2 != 0 && iReverseBytes == 0) || (i12 == 16 && iReverseBytes2 != iReverseBytes))) {
                    throw new DecompressionException(String.format("stream corrupted: compressedLength(%d) and decompressedLength(%d) mismatch", Integer.valueOf(iReverseBytes), Integer.valueOf(iReverseBytes2)));
                }
                int iReverseBytes3 = Integer.reverseBytes(byteBuf.readInt());
                if (iReverseBytes2 == 0 && iReverseBytes == 0) {
                    if (iReverseBytes3 != 0) {
                        throw new DecompressionException("stream corrupted: checksum error");
                    }
                    this.currentState = State.FINISHED;
                    this.decompressor = null;
                    this.checksum = null;
                    return;
                }
                this.blockType = i12;
                this.compressedLength = iReverseBytes;
                this.decompressedLength = iReverseBytes2;
                this.currentChecksum = iReverseBytes3;
                this.currentState = State.DECOMPRESS_DATA;
            }
            int i14 = this.blockType;
            int i15 = this.compressedLength;
            int i16 = this.decompressedLength;
            int i17 = this.currentChecksum;
            if (byteBuf.readableBytes() < i15) {
                return;
            }
            ByteBufChecksum byteBufChecksum = this.checksum;
            try {
                try {
                    if (i14 == 16) {
                        byteBufRetainedSlice = byteBuf.retainedSlice(byteBuf.readerIndex(), i16);
                    } else {
                        if (i14 != 32) {
                            throw new DecompressionException(String.format("unexpected blockType: %d (expected: %d or %d)", Integer.valueOf(i14), 16, 32));
                        }
                        byteBufRetainedSlice = channelHandlerContext.alloc().buffer(i16, i16);
                        try {
                            this.decompressor.decompress(CompressionUtil.safeReadableNioBuffer(byteBuf), byteBufRetainedSlice.internalNioBuffer(byteBufRetainedSlice.writerIndex(), i16));
                            byteBufRetainedSlice.writerIndex(byteBufRetainedSlice.writerIndex() + i16);
                        } catch (LZ4Exception e10) {
                            e = e10;
                            throw new DecompressionException((Throwable) e);
                        } catch (Throwable th2) {
                            th = th2;
                            byteBuf2 = byteBufRetainedSlice;
                            if (byteBuf2 != null) {
                                byteBuf2.release();
                            }
                            throw th;
                        }
                    }
                    byteBuf.skipBytes(i15);
                    if (byteBufChecksum != null) {
                        CompressionUtil.checkChecksum(byteBufChecksum, byteBufRetainedSlice, i17);
                    }
                    list.add(byteBufRetainedSlice);
                    this.currentState = State.INIT_BLOCK;
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (LZ4Exception e11) {
                e = e11;
            }
        } catch (Exception e12) {
            this.currentState = State.CORRUPTED;
            throw e12;
        }
    }

    public boolean isClosed() {
        return this.currentState == State.FINISHED;
    }

    public Lz4FrameDecoder(boolean z10) {
        this(LZ4Factory.fastestInstance(), z10);
    }

    public Lz4FrameDecoder(LZ4Factory lZ4Factory, boolean z10) {
        this(lZ4Factory, z10 ? new Lz4XXHash32(-1756908916) : null);
    }

    public Lz4FrameDecoder(LZ4Factory lZ4Factory, Checksum checksum) {
        this.currentState = State.INIT_BLOCK;
        this.decompressor = ((LZ4Factory) ObjectUtil.checkNotNull(lZ4Factory, "factory")).fastDecompressor();
        this.checksum = checksum == null ? null : ByteBufChecksum.wrapChecksum(checksum);
    }
}
