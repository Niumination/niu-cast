package io.netty.handler.stream;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.internal.ObjectUtil;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: classes3.dex */
public class ChunkedFile implements ChunkedInput<ByteBuf> {
    private final int chunkSize;
    private final long endOffset;
    private final RandomAccessFile file;
    private long offset;
    private final long startOffset;

    public ChunkedFile(File file) throws IOException {
        this(file, 8192);
    }

    @Override // io.netty.handler.stream.ChunkedInput
    public void close() throws Exception {
        this.file.close();
    }

    public long currentOffset() {
        return this.offset;
    }

    public long endOffset() {
        return this.endOffset;
    }

    @Override // io.netty.handler.stream.ChunkedInput
    public boolean isEndOfInput() throws Exception {
        return this.offset >= this.endOffset || !this.file.getChannel().isOpen();
    }

    @Override // io.netty.handler.stream.ChunkedInput
    public long length() {
        return this.endOffset - this.startOffset;
    }

    @Override // io.netty.handler.stream.ChunkedInput
    public long progress() {
        return this.offset - this.startOffset;
    }

    public long startOffset() {
        return this.startOffset;
    }

    public ChunkedFile(File file, int i10) throws IOException {
        this(new RandomAccessFile(file, "r"), i10);
    }

    public ChunkedFile(RandomAccessFile randomAccessFile) throws IOException {
        this(randomAccessFile, 8192);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.netty.handler.stream.ChunkedInput
    @Deprecated
    public ByteBuf readChunk(ChannelHandlerContext channelHandlerContext) throws Exception {
        return readChunk(channelHandlerContext.alloc());
    }

    public ChunkedFile(RandomAccessFile randomAccessFile, int i10) throws IOException {
        this(randomAccessFile, 0L, randomAccessFile.length(), i10);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.netty.handler.stream.ChunkedInput
    public ByteBuf readChunk(ByteBufAllocator byteBufAllocator) throws Exception {
        long j10 = this.offset;
        long j11 = this.endOffset;
        if (j10 >= j11) {
            return null;
        }
        int iMin = (int) Math.min(this.chunkSize, j11 - j10);
        ByteBuf byteBufHeapBuffer = byteBufAllocator.heapBuffer(iMin);
        try {
            this.file.readFully(byteBufHeapBuffer.array(), byteBufHeapBuffer.arrayOffset(), iMin);
            byteBufHeapBuffer.writerIndex(iMin);
            this.offset = j10 + ((long) iMin);
            return byteBufHeapBuffer;
        } catch (Throwable th2) {
            byteBufHeapBuffer.release();
            throw th2;
        }
    }

    public ChunkedFile(RandomAccessFile randomAccessFile, long j10, long j11, int i10) throws IOException {
        ObjectUtil.checkNotNull(randomAccessFile, "file");
        ObjectUtil.checkPositiveOrZero(j10, TypedValues.CycleType.S_WAVE_OFFSET);
        ObjectUtil.checkPositiveOrZero(j11, "length");
        ObjectUtil.checkPositive(i10, "chunkSize");
        this.file = randomAccessFile;
        this.startOffset = j10;
        this.offset = j10;
        this.endOffset = j11 + j10;
        this.chunkSize = i10;
        randomAccessFile.seek(j10);
    }
}
