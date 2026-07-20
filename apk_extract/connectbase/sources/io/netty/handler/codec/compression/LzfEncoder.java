package io.netty.handler.codec.compression;

import com.ning.compress.BufferRecycler;
import com.ning.compress.lzf.ChunkEncoder;
import com.ning.compress.lzf.LZFChunk;
import com.ning.compress.lzf.LZFEncoder;
import com.ning.compress.lzf.util.ChunkEncoderFactory;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import k.b;

/* JADX INFO: loaded from: classes3.dex */
public class LzfEncoder extends MessageToByteEncoder<ByteBuf> {
    private static final int MIN_BLOCK_TO_COMPRESS = 16;
    private final int compressThreshold;
    private final ChunkEncoder encoder;
    private final BufferRecycler recycler;

    public LzfEncoder() {
        this(false);
    }

    private int encodeCompress(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) {
        return LZFEncoder.appendEncoded(this.encoder, bArr, i10, i11, bArr2, i12) - i12;
    }

    private static int encodeNonCompress(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) {
        return lzfEncodeNonCompress(bArr, i10, i11, bArr2, i12) - i12;
    }

    private static int lzfEncodeNonCompress(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) {
        int iMin = Math.min(65535, i11);
        int iAppendNonCompressed = LZFChunk.appendNonCompressed(bArr, i10, iMin, bArr2, i12);
        int i13 = i11 - iMin;
        if (i13 < 1) {
            return iAppendNonCompressed;
        }
        int i14 = i10 + iMin;
        do {
            int iMin2 = Math.min(i13, 65535);
            iAppendNonCompressed = LZFChunk.appendNonCompressed(bArr, i14, iMin2, bArr2, iAppendNonCompressed);
            i14 += iMin2;
            i13 -= iMin2;
        } while (i13 > 0);
        return iAppendNonCompressed;
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.encoder.close();
        super.handlerRemoved(channelHandlerContext);
    }

    public LzfEncoder(boolean z10) {
        this(z10, 65535);
    }

    @Override // io.netty.handler.codec.MessageToByteEncoder
    public void encode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, ByteBuf byteBuf2) throws Exception {
        byte[] bArr;
        int iArrayOffset;
        byte[] bArrArray;
        int iWriterIndex;
        int i10 = byteBuf.readableBytes();
        int i11 = byteBuf.readerIndex();
        if (byteBuf.hasArray()) {
            byte[] bArrArray2 = byteBuf.array();
            iArrayOffset = byteBuf.arrayOffset() + i11;
            bArr = bArrArray2;
        } else {
            byte[] bArrAllocInputBuffer = this.recycler.allocInputBuffer(i10);
            byteBuf.getBytes(i11, bArrAllocInputBuffer, 0, i10);
            bArr = bArrAllocInputBuffer;
            iArrayOffset = 0;
        }
        int iEstimateMaxWorkspaceSize = LZFEncoder.estimateMaxWorkspaceSize(i10) + 1;
        byteBuf2.ensureWritable(iEstimateMaxWorkspaceSize);
        if (byteBuf2.hasArray()) {
            bArrArray = byteBuf2.array();
            iWriterIndex = byteBuf2.writerIndex() + byteBuf2.arrayOffset();
        } else {
            bArrArray = new byte[iEstimateMaxWorkspaceSize];
            iWriterIndex = 0;
        }
        int iEncodeCompress = i10 >= this.compressThreshold ? encodeCompress(bArr, iArrayOffset, i10, bArrArray, iWriterIndex) : encodeNonCompress(bArr, iArrayOffset, i10, bArrArray, iWriterIndex);
        if (byteBuf2.hasArray()) {
            byteBuf2.writerIndex(byteBuf2.writerIndex() + iEncodeCompress);
        } else {
            byteBuf2.writeBytes(bArrArray, 0, iEncodeCompress);
        }
        byteBuf.skipBytes(i10);
        if (byteBuf.hasArray()) {
            return;
        }
        this.recycler.releaseInputBuffer(bArr);
    }

    public LzfEncoder(boolean z10, int i10) {
        this(z10, i10, 16);
    }

    public LzfEncoder(int i10) {
        this(false, i10);
    }

    public LzfEncoder(boolean z10, int i10, int i11) {
        ChunkEncoder chunkEncoderOptimalNonAllocatingInstance;
        super(false);
        if (i10 < 16 || i10 > 65535) {
            throw new IllegalArgumentException(b.a("totalLength: ", i10, " (expected: 16-65535)"));
        }
        if (i11 >= 16) {
            this.compressThreshold = i11;
            if (z10) {
                chunkEncoderOptimalNonAllocatingInstance = ChunkEncoderFactory.safeNonAllocatingInstance(i10);
            } else {
                chunkEncoderOptimalNonAllocatingInstance = ChunkEncoderFactory.optimalNonAllocatingInstance(i10);
            }
            this.encoder = chunkEncoderOptimalNonAllocatingInstance;
            this.recycler = BufferRecycler.instance();
            return;
        }
        throw new IllegalArgumentException(b.a("compressThreshold:", i11, " expected >=16"));
    }
}
