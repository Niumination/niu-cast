package io.netty.handler.codec.compression;

import com.ning.compress.BufferRecycler;
import com.ning.compress.lzf.ChunkDecoder;
import com.ning.compress.lzf.util.ChunkDecoderFactory;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class LzfDecoder extends ByteToMessageDecoder {
    private static final short MAGIC_NUMBER = 23126;
    private int chunkLength;
    private State currentState;
    private ChunkDecoder decoder;
    private boolean isCompressed;
    private int originalLength;
    private BufferRecycler recycler;

    /* JADX INFO: renamed from: io.netty.handler.codec.compression.LzfDecoder$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$compression$LzfDecoder$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$io$netty$handler$codec$compression$LzfDecoder$State = iArr;
            try {
                iArr[State.INIT_BLOCK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$LzfDecoder$State[State.INIT_ORIGINAL_LENGTH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$LzfDecoder$State[State.DECOMPRESS_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$LzfDecoder$State[State.CORRUPTED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public enum State {
        INIT_BLOCK,
        INIT_ORIGINAL_LENGTH,
        DECOMPRESS_DATA,
        CORRUPTED
    }

    public LzfDecoder() {
        this(false);
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0096  */
    /* JADX WARN: Code duplicated, block: B:39:0x0098 A[Catch: Exception -> 0x0023, TryCatch #1 {Exception -> 0x0023, blocks: (B:2:0x0000, B:9:0x001a, B:12:0x0026, B:13:0x002b, B:36:0x008e, B:39:0x0098, B:41:0x009e, B:43:0x00a8, B:45:0x00bd, B:47:0x00cb, B:58:0x0100, B:60:0x0106, B:65:0x0119, B:61:0x010c, B:62:0x010f, B:49:0x00da, B:44:0x00b3, B:64:0x0112, B:30:0x007a, B:33:0x0082, B:35:0x008a, B:67:0x011e, B:68:0x0137, B:14:0x002c, B:17:0x0035, B:19:0x003d, B:22:0x0045, B:26:0x006e, B:69:0x0138, B:70:0x0151, B:23:0x004c, B:24:0x0067, B:25:0x0068, B:71:0x0152, B:72:0x0159, B:51:0x00dd, B:53:0x00ec, B:57:0x00fa, B:56:0x00f7), top: B:77:0x0000, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x009e A[Catch: Exception -> 0x0023, TryCatch #1 {Exception -> 0x0023, blocks: (B:2:0x0000, B:9:0x001a, B:12:0x0026, B:13:0x002b, B:36:0x008e, B:39:0x0098, B:41:0x009e, B:43:0x00a8, B:45:0x00bd, B:47:0x00cb, B:58:0x0100, B:60:0x0106, B:65:0x0119, B:61:0x010c, B:62:0x010f, B:49:0x00da, B:44:0x00b3, B:64:0x0112, B:30:0x007a, B:33:0x0082, B:35:0x008a, B:67:0x011e, B:68:0x0137, B:14:0x002c, B:17:0x0035, B:19:0x003d, B:22:0x0045, B:26:0x006e, B:69:0x0138, B:70:0x0151, B:23:0x004c, B:24:0x0067, B:25:0x0068, B:71:0x0152, B:72:0x0159, B:51:0x00dd, B:53:0x00ec, B:57:0x00fa, B:56:0x00f7), top: B:77:0x0000, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x00a8 A[Catch: Exception -> 0x0023, TryCatch #1 {Exception -> 0x0023, blocks: (B:2:0x0000, B:9:0x001a, B:12:0x0026, B:13:0x002b, B:36:0x008e, B:39:0x0098, B:41:0x009e, B:43:0x00a8, B:45:0x00bd, B:47:0x00cb, B:58:0x0100, B:60:0x0106, B:65:0x0119, B:61:0x010c, B:62:0x010f, B:49:0x00da, B:44:0x00b3, B:64:0x0112, B:30:0x007a, B:33:0x0082, B:35:0x008a, B:67:0x011e, B:68:0x0137, B:14:0x002c, B:17:0x0035, B:19:0x003d, B:22:0x0045, B:26:0x006e, B:69:0x0138, B:70:0x0151, B:23:0x004c, B:24:0x0067, B:25:0x0068, B:71:0x0152, B:72:0x0159, B:51:0x00dd, B:53:0x00ec, B:57:0x00fa, B:56:0x00f7), top: B:77:0x0000, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x00b3 A[Catch: Exception -> 0x0023, TryCatch #1 {Exception -> 0x0023, blocks: (B:2:0x0000, B:9:0x001a, B:12:0x0026, B:13:0x002b, B:36:0x008e, B:39:0x0098, B:41:0x009e, B:43:0x00a8, B:45:0x00bd, B:47:0x00cb, B:58:0x0100, B:60:0x0106, B:65:0x0119, B:61:0x010c, B:62:0x010f, B:49:0x00da, B:44:0x00b3, B:64:0x0112, B:30:0x007a, B:33:0x0082, B:35:0x008a, B:67:0x011e, B:68:0x0137, B:14:0x002c, B:17:0x0035, B:19:0x003d, B:22:0x0045, B:26:0x006e, B:69:0x0138, B:70:0x0151, B:23:0x004c, B:24:0x0067, B:25:0x0068, B:71:0x0152, B:72:0x0159, B:51:0x00dd, B:53:0x00ec, B:57:0x00fa, B:56:0x00f7), top: B:77:0x0000, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x00cb A[Catch: Exception -> 0x0023, TryCatch #1 {Exception -> 0x0023, blocks: (B:2:0x0000, B:9:0x001a, B:12:0x0026, B:13:0x002b, B:36:0x008e, B:39:0x0098, B:41:0x009e, B:43:0x00a8, B:45:0x00bd, B:47:0x00cb, B:58:0x0100, B:60:0x0106, B:65:0x0119, B:61:0x010c, B:62:0x010f, B:49:0x00da, B:44:0x00b3, B:64:0x0112, B:30:0x007a, B:33:0x0082, B:35:0x008a, B:67:0x011e, B:68:0x0137, B:14:0x002c, B:17:0x0035, B:19:0x003d, B:22:0x0045, B:26:0x006e, B:69:0x0138, B:70:0x0151, B:23:0x004c, B:24:0x0067, B:25:0x0068, B:71:0x0152, B:72:0x0159, B:51:0x00dd, B:53:0x00ec, B:57:0x00fa, B:56:0x00f7), top: B:77:0x0000, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x00da A[Catch: Exception -> 0x0023, TRY_LEAVE, TryCatch #1 {Exception -> 0x0023, blocks: (B:2:0x0000, B:9:0x001a, B:12:0x0026, B:13:0x002b, B:36:0x008e, B:39:0x0098, B:41:0x009e, B:43:0x00a8, B:45:0x00bd, B:47:0x00cb, B:58:0x0100, B:60:0x0106, B:65:0x0119, B:61:0x010c, B:62:0x010f, B:49:0x00da, B:44:0x00b3, B:64:0x0112, B:30:0x007a, B:33:0x0082, B:35:0x008a, B:67:0x011e, B:68:0x0137, B:14:0x002c, B:17:0x0035, B:19:0x003d, B:22:0x0045, B:26:0x006e, B:69:0x0138, B:70:0x0151, B:23:0x004c, B:24:0x0067, B:25:0x0068, B:71:0x0152, B:72:0x0159, B:51:0x00dd, B:53:0x00ec, B:57:0x00fa, B:56:0x00f7), top: B:77:0x0000, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:53:0x00ec A[Catch: all -> 0x00f5, TryCatch #0 {all -> 0x00f5, blocks: (B:51:0x00dd, B:53:0x00ec, B:57:0x00fa, B:56:0x00f7), top: B:75:0x00dd, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x00f7 A[Catch: all -> 0x00f5, TryCatch #0 {all -> 0x00f5, blocks: (B:51:0x00dd, B:53:0x00ec, B:57:0x00fa, B:56:0x00f7), top: B:75:0x00dd, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x0106 A[Catch: Exception -> 0x0023, TryCatch #1 {Exception -> 0x0023, blocks: (B:2:0x0000, B:9:0x001a, B:12:0x0026, B:13:0x002b, B:36:0x008e, B:39:0x0098, B:41:0x009e, B:43:0x00a8, B:45:0x00bd, B:47:0x00cb, B:58:0x0100, B:60:0x0106, B:65:0x0119, B:61:0x010c, B:62:0x010f, B:49:0x00da, B:44:0x00b3, B:64:0x0112, B:30:0x007a, B:33:0x0082, B:35:0x008a, B:67:0x011e, B:68:0x0137, B:14:0x002c, B:17:0x0035, B:19:0x003d, B:22:0x0045, B:26:0x006e, B:69:0x0138, B:70:0x0151, B:23:0x004c, B:24:0x0067, B:25:0x0068, B:71:0x0152, B:72:0x0159, B:51:0x00dd, B:53:0x00ec, B:57:0x00fa, B:56:0x00f7), top: B:77:0x0000, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x0110 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:64:0x0112 A[Catch: Exception -> 0x0023, TryCatch #1 {Exception -> 0x0023, blocks: (B:2:0x0000, B:9:0x001a, B:12:0x0026, B:13:0x002b, B:36:0x008e, B:39:0x0098, B:41:0x009e, B:43:0x00a8, B:45:0x00bd, B:47:0x00cb, B:58:0x0100, B:60:0x0106, B:65:0x0119, B:61:0x010c, B:62:0x010f, B:49:0x00da, B:44:0x00b3, B:64:0x0112, B:30:0x007a, B:33:0x0082, B:35:0x008a, B:67:0x011e, B:68:0x0137, B:14:0x002c, B:17:0x0035, B:19:0x003d, B:22:0x0045, B:26:0x006e, B:69:0x0138, B:70:0x0151, B:23:0x004c, B:24:0x0067, B:25:0x0068, B:71:0x0152, B:72:0x0159, B:51:0x00dd, B:53:0x00ec, B:57:0x00fa, B:56:0x00f7), top: B:77:0x0000, inners: #0 }] */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        int i10;
        int i11;
        int i12;
        byte[] bArrAllocInputBuffer;
        int iArrayOffset;
        ByteBuf byteBufHeapBuffer;
        byte[] bArrArray;
        try {
            int i13 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$compression$LzfDecoder$State[this.currentState.ordinal()];
            int iArrayOffset2 = 0;
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
                i11 = this.originalLength;
                if (this.isCompressed) {
                    i12 = byteBuf.readerIndex();
                    if (byteBuf.hasArray()) {
                        bArrAllocInputBuffer = byteBuf.array();
                        iArrayOffset = byteBuf.arrayOffset() + i12;
                    } else {
                        bArrAllocInputBuffer = this.recycler.allocInputBuffer(i10);
                        byteBuf.getBytes(i12, bArrAllocInputBuffer, 0, i10);
                        iArrayOffset = 0;
                    }
                    byteBufHeapBuffer = channelHandlerContext.alloc().heapBuffer(i11, i11);
                    if (byteBufHeapBuffer.hasArray()) {
                        bArrArray = byteBufHeapBuffer.array();
                        iArrayOffset2 = byteBufHeapBuffer.arrayOffset() + byteBufHeapBuffer.writerIndex();
                    } else {
                        bArrArray = new byte[i11];
                    }
                    int i14 = iArrayOffset2;
                    try {
                        this.decoder.decodeChunk(bArrAllocInputBuffer, iArrayOffset, bArrArray, i14, i14 + i11);
                        if (byteBufHeapBuffer.hasArray()) {
                            byteBufHeapBuffer.writerIndex(byteBufHeapBuffer.writerIndex() + i11);
                        } else {
                            byteBufHeapBuffer.writeBytes(bArrArray);
                        }
                        list.add(byteBufHeapBuffer);
                        byteBuf.skipBytes(i10);
                        if (!byteBuf.hasArray()) {
                            this.recycler.releaseInputBuffer(bArrAllocInputBuffer);
                        }
                    } catch (Throwable th2) {
                        byteBufHeapBuffer.release();
                        throw th2;
                    }
                } else if (i10 > 0) {
                    list.add(byteBuf.readRetainedSlice(i10));
                }
                this.currentState = State.INIT_BLOCK;
            }
            if (byteBuf.readableBytes() < 5) {
                return;
            }
            if (byteBuf.readUnsignedShort() != 23126) {
                throw new DecompressionException("unexpected block identifier");
            }
            byte b10 = byteBuf.readByte();
            if (b10 == 0) {
                this.isCompressed = false;
                this.currentState = State.DECOMPRESS_DATA;
            } else {
                if (b10 != 1) {
                    throw new DecompressionException(String.format("unknown type of chunk: %d (expected: %d or %d)", Integer.valueOf(b10), 0, 1));
                }
                this.isCompressed = true;
                this.currentState = State.INIT_ORIGINAL_LENGTH;
            }
            int unsignedShort = byteBuf.readUnsignedShort();
            this.chunkLength = unsignedShort;
            if (unsignedShort > 65535) {
                throw new DecompressionException(String.format("chunk length exceeds maximum: %d (expected: =< %d)", Integer.valueOf(this.chunkLength), 65535));
            }
            if (b10 != 1) {
                return;
            }
            if (byteBuf.readableBytes() < 2) {
                return;
            }
            int unsignedShort2 = byteBuf.readUnsignedShort();
            this.originalLength = unsignedShort2;
            if (unsignedShort2 > 65535) {
                throw new DecompressionException(String.format("original length exceeds maximum: %d (expected: =< %d)", Integer.valueOf(this.chunkLength), 65535));
            }
            this.currentState = State.DECOMPRESS_DATA;
            i10 = this.chunkLength;
            if (byteBuf.readableBytes() < i10) {
                return;
            }
            i11 = this.originalLength;
            if (this.isCompressed) {
                i12 = byteBuf.readerIndex();
                if (byteBuf.hasArray()) {
                    bArrAllocInputBuffer = byteBuf.array();
                    iArrayOffset = byteBuf.arrayOffset() + i12;
                } else {
                    bArrAllocInputBuffer = this.recycler.allocInputBuffer(i10);
                    byteBuf.getBytes(i12, bArrAllocInputBuffer, 0, i10);
                    iArrayOffset = 0;
                }
                byteBufHeapBuffer = channelHandlerContext.alloc().heapBuffer(i11, i11);
                if (byteBufHeapBuffer.hasArray()) {
                    bArrArray = byteBufHeapBuffer.array();
                    iArrayOffset2 = byteBufHeapBuffer.arrayOffset() + byteBufHeapBuffer.writerIndex();
                } else {
                    bArrArray = new byte[i11];
                }
                int i15 = iArrayOffset2;
                this.decoder.decodeChunk(bArrAllocInputBuffer, iArrayOffset, bArrArray, i15, i15 + i11);
                if (byteBufHeapBuffer.hasArray()) {
                    byteBufHeapBuffer.writerIndex(byteBufHeapBuffer.writerIndex() + i11);
                } else {
                    byteBufHeapBuffer.writeBytes(bArrArray);
                }
                list.add(byteBufHeapBuffer);
                byteBuf.skipBytes(i10);
                if (!byteBuf.hasArray()) {
                    this.recycler.releaseInputBuffer(bArrAllocInputBuffer);
                }
            } else if (i10 > 0) {
                list.add(byteBuf.readRetainedSlice(i10));
            }
            this.currentState = State.INIT_BLOCK;
        } catch (Exception e10) {
            this.currentState = State.CORRUPTED;
            this.decoder = null;
            this.recycler = null;
            throw e10;
        }
    }

    public LzfDecoder(boolean z10) {
        this.currentState = State.INIT_BLOCK;
        this.decoder = z10 ? ChunkDecoderFactory.safeInstance() : ChunkDecoderFactory.optimalInstance();
        this.recycler = BufferRecycler.instance();
    }
}
