package io.netty.handler.codec.compression;

import c1.c;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import java.util.List;
import java.util.zip.Adler32;
import java.util.zip.Checksum;

/* JADX INFO: loaded from: classes3.dex */
public class FastLzFrameDecoder extends ByteToMessageDecoder {
    private final ByteBufChecksum checksum;
    private int chunkLength;
    private int currentChecksum;
    private State currentState;
    private boolean hasChecksum;
    private boolean isCompressed;
    private int originalLength;

    /* JADX INFO: renamed from: io.netty.handler.codec.compression.FastLzFrameDecoder$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$compression$FastLzFrameDecoder$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$io$netty$handler$codec$compression$FastLzFrameDecoder$State = iArr;
            try {
                iArr[State.INIT_BLOCK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$FastLzFrameDecoder$State[State.INIT_BLOCK_PARAMS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$FastLzFrameDecoder$State[State.DECOMPRESS_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$FastLzFrameDecoder$State[State.CORRUPTED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public enum State {
        INIT_BLOCK,
        INIT_BLOCK_PARAMS,
        DECOMPRESS_DATA,
        CORRUPTED
    }

    public FastLzFrameDecoder() {
        this(false);
    }

    /* JADX WARN: Code duplicated, block: B:46:0x008f  */
    /* JADX WARN: Code duplicated, block: B:47:0x0091 A[Catch: Exception -> 0x0020, TRY_LEAVE, TryCatch #0 {Exception -> 0x0020, blocks: (B:2:0x0000, B:8:0x0017, B:11:0x0023, B:12:0x0028, B:44:0x0087, B:47:0x0091, B:77:0x012d, B:78:0x0130, B:27:0x0054, B:31:0x005f, B:35:0x0066, B:39:0x006d, B:40:0x0071, B:42:0x007d, B:43:0x0081, B:13:0x0029, B:16:0x0031, B:18:0x003a, B:22:0x0045, B:26:0x004e, B:79:0x0131, B:80:0x0138), top: B:83:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x009c A[Catch: all -> 0x00d6, TRY_LEAVE, TryCatch #1 {all -> 0x00d6, blocks: (B:49:0x0098, B:51:0x009c, B:74:0x0123, B:61:0x00d8), top: B:84:0x0098 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x00b2 A[Catch: all -> 0x00bb, TryCatch #2 {all -> 0x00bb, blocks: (B:52:0x00a4, B:54:0x00b2, B:62:0x00dc, B:65:0x00e4, B:68:0x00fc, B:69:0x0115, B:70:0x0116, B:72:0x011c, B:73:0x0120, B:57:0x00be, B:58:0x00d5), top: B:86:0x00a4 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x00be A[Catch: all -> 0x00bb, TryCatch #2 {all -> 0x00bb, blocks: (B:52:0x00a4, B:54:0x00b2, B:62:0x00dc, B:65:0x00e4, B:68:0x00fc, B:69:0x0115, B:70:0x0116, B:72:0x011c, B:73:0x0120, B:57:0x00be, B:58:0x00d5), top: B:86:0x00a4 }] */
    /* JADX WARN: Code duplicated, block: B:61:0x00d8 A[Catch: all -> 0x00d6, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x00d6, blocks: (B:49:0x0098, B:51:0x009c, B:74:0x0123, B:61:0x00d8), top: B:84:0x0098 }] */
    /* JADX WARN: Code duplicated, block: B:67:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:68:0x00fc A[Catch: all -> 0x00bb, TryCatch #2 {all -> 0x00bb, blocks: (B:52:0x00a4, B:54:0x00b2, B:62:0x00dc, B:65:0x00e4, B:68:0x00fc, B:69:0x0115, B:70:0x0116, B:72:0x011c, B:73:0x0120, B:57:0x00be, B:58:0x00d5), top: B:86:0x00a4 }] */
    /* JADX WARN: Code duplicated, block: B:72:0x011c A[Catch: all -> 0x00bb, TryCatch #2 {all -> 0x00bb, blocks: (B:52:0x00a4, B:54:0x00b2, B:62:0x00dc, B:65:0x00e4, B:68:0x00fc, B:69:0x0115, B:70:0x0116, B:72:0x011c, B:73:0x0120, B:57:0x00be, B:58:0x00d5), top: B:86:0x00a4 }] */
    /* JADX WARN: Code duplicated, block: B:73:0x0120 A[Catch: all -> 0x00bb, TRY_LEAVE, TryCatch #2 {all -> 0x00bb, blocks: (B:52:0x00a4, B:54:0x00b2, B:62:0x00dc, B:65:0x00e4, B:68:0x00fc, B:69:0x0115, B:70:0x0116, B:72:0x011c, B:73:0x0120, B:57:0x00be, B:58:0x00d5), top: B:86:0x00a4 }] */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        int i10;
        int i11;
        int i12;
        ByteBuf byteBufRetainedSlice;
        ByteBufChecksum byteBufChecksum;
        int value;
        int iDecompress;
        try {
            int i13 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$compression$FastLzFrameDecoder$State[this.currentState.ordinal()];
            int i14 = 4;
            boolean z10 = true;
            if (i13 != 1) {
                if (i13 != 2) {
                    if (i13 != 3) {
                        if (i13 != 4) {
                            throw new IllegalStateException();
                        }
                        byteBuf.skipBytes(byteBuf.readableBytes());
                        return;
                    }
                }
                i10 = this.chunkLength;
                if (byteBuf.readableBytes() < i10) {
                    return;
                }
                i11 = byteBuf.readerIndex();
                i12 = this.originalLength;
                ByteBuf byteBuf2 = null;
                try {
                    if (this.isCompressed) {
                        byteBufRetainedSlice = channelHandlerContext.alloc().buffer(i12);
                        try {
                            iDecompress = FastLz.decompress(byteBuf, i11, i10, byteBufRetainedSlice, byteBufRetainedSlice.writerIndex(), i12);
                            if (i12 == iDecompress) {
                                throw new DecompressionException(String.format("stream corrupted: originalLength(%d) and actual length(%d) mismatch", Integer.valueOf(i12), Integer.valueOf(iDecompress)));
                            }
                            byteBufRetainedSlice.writerIndex(byteBufRetainedSlice.writerIndex() + iDecompress);
                        } catch (Throwable th2) {
                            th = th2;
                            byteBuf2 = byteBufRetainedSlice;
                            if (byteBuf2 != null) {
                                byteBuf2.release();
                            }
                            throw th;
                        }
                    } else {
                        byteBufRetainedSlice = byteBuf.retainedSlice(i11, i10);
                    }
                    byteBufChecksum = this.checksum;
                    if (this.hasChecksum && byteBufChecksum != null) {
                        byteBufChecksum.reset();
                        byteBufChecksum.update(byteBufRetainedSlice, byteBufRetainedSlice.readerIndex(), byteBufRetainedSlice.readableBytes());
                        value = (int) byteBufChecksum.getValue();
                        if (value == this.currentChecksum) {
                            throw new DecompressionException(String.format("stream corrupted: mismatching checksum: %d (expected: %d)", Integer.valueOf(value), Integer.valueOf(this.currentChecksum)));
                        }
                    }
                    if (byteBufRetainedSlice.readableBytes() > 0) {
                        list.add(byteBufRetainedSlice);
                    } else {
                        byteBufRetainedSlice.release();
                    }
                    byteBuf.skipBytes(i10);
                    this.currentState = State.INIT_BLOCK;
                } catch (Throwable th3) {
                    th = th3;
                }
            } else {
                if (byteBuf.readableBytes() < 4) {
                    return;
                }
                if (byteBuf.readUnsignedMedium() != 4607066) {
                    throw new DecompressionException("unexpected block identifier");
                }
                byte b10 = byteBuf.readByte();
                this.isCompressed = (b10 & 1) == 1;
                if ((b10 & c.f1124r) != 16) {
                    z10 = false;
                }
                this.hasChecksum = z10;
                this.currentState = State.INIT_BLOCK_PARAMS;
            }
            int i15 = byteBuf.readableBytes();
            int i16 = 2 + (this.isCompressed ? 2 : 0);
            boolean z11 = this.hasChecksum;
            if (!z11) {
                i14 = 0;
            }
            if (i15 < i16 + i14) {
                return;
            }
            this.currentChecksum = z11 ? byteBuf.readInt() : 0;
            int unsignedShort = byteBuf.readUnsignedShort();
            this.chunkLength = unsignedShort;
            if (this.isCompressed) {
                unsignedShort = byteBuf.readUnsignedShort();
            }
            this.originalLength = unsignedShort;
            this.currentState = State.DECOMPRESS_DATA;
            i10 = this.chunkLength;
            if (byteBuf.readableBytes() < i10) {
                return;
            }
            i11 = byteBuf.readerIndex();
            i12 = this.originalLength;
            ByteBuf byteBuf3 = null;
            if (this.isCompressed) {
                byteBufRetainedSlice = channelHandlerContext.alloc().buffer(i12);
                iDecompress = FastLz.decompress(byteBuf, i11, i10, byteBufRetainedSlice, byteBufRetainedSlice.writerIndex(), i12);
                if (i12 == iDecompress) {
                    throw new DecompressionException(String.format("stream corrupted: originalLength(%d) and actual length(%d) mismatch", Integer.valueOf(i12), Integer.valueOf(iDecompress)));
                }
                byteBufRetainedSlice.writerIndex(byteBufRetainedSlice.writerIndex() + iDecompress);
            } else {
                byteBufRetainedSlice = byteBuf.retainedSlice(i11, i10);
            }
            byteBufChecksum = this.checksum;
            if (this.hasChecksum) {
                byteBufChecksum.reset();
                byteBufChecksum.update(byteBufRetainedSlice, byteBufRetainedSlice.readerIndex(), byteBufRetainedSlice.readableBytes());
                value = (int) byteBufChecksum.getValue();
                if (value == this.currentChecksum) {
                    throw new DecompressionException(String.format("stream corrupted: mismatching checksum: %d (expected: %d)", Integer.valueOf(value), Integer.valueOf(this.currentChecksum)));
                }
            }
            if (byteBufRetainedSlice.readableBytes() > 0) {
                list.add(byteBufRetainedSlice);
            } else {
                byteBufRetainedSlice.release();
            }
            byteBuf.skipBytes(i10);
            this.currentState = State.INIT_BLOCK;
        } catch (Exception e10) {
            this.currentState = State.CORRUPTED;
            throw e10;
        }
    }

    public FastLzFrameDecoder(boolean z10) {
        this(z10 ? new Adler32() : null);
    }

    public FastLzFrameDecoder(Checksum checksum) {
        this.currentState = State.INIT_BLOCK;
        this.checksum = checksum == null ? null : ByteBufChecksum.wrapChecksum(checksum);
    }
}
