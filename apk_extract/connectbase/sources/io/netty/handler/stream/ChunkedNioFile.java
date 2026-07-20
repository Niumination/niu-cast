package io.netty.handler.stream;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.internal.ObjectUtil;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes3.dex */
public class ChunkedNioFile implements ChunkedInput<ByteBuf> {
    private final int chunkSize;
    private final long endOffset;

    /* JADX INFO: renamed from: in, reason: collision with root package name */
    private final FileChannel f8339in;
    private long offset;
    private final long startOffset;

    public ChunkedNioFile(File file) throws IOException {
        this(new RandomAccessFile(file, "r").getChannel());
    }

    @Override // io.netty.handler.stream.ChunkedInput
    public void close() throws Exception {
        this.f8339in.close();
    }

    public long currentOffset() {
        return this.offset;
    }

    public long endOffset() {
        return this.endOffset;
    }

    @Override // io.netty.handler.stream.ChunkedInput
    public boolean isEndOfInput() throws Exception {
        return this.offset >= this.endOffset || !this.f8339in.isOpen();
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

    public ChunkedNioFile(File file, int i10) throws IOException {
        this(new RandomAccessFile(file, "r").getChannel(), i10);
    }

    public ChunkedNioFile(FileChannel fileChannel) throws IOException {
        this(fileChannel, 8192);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.netty.handler.stream.ChunkedInput
    @Deprecated
    public ByteBuf readChunk(ChannelHandlerContext channelHandlerContext) throws Exception {
        return readChunk(channelHandlerContext.alloc());
    }

    public ChunkedNioFile(FileChannel fileChannel, int i10) throws IOException {
        this(fileChannel, 0L, fileChannel.size(), i10);
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
        ByteBuf byteBufBuffer = byteBufAllocator.buffer(iMin);
        int i10 = 0;
        do {
            try {
                int iWriteBytes = byteBufBuffer.writeBytes(this.f8339in, ((long) i10) + j10, iMin - i10);
                if (iWriteBytes < 0) {
                    break;
                }
                i10 += iWriteBytes;
            } catch (Throwable th2) {
                byteBufBuffer.release();
                throw th2;
            }
        } while (i10 != iMin);
        this.offset += (long) i10;
        return byteBufBuffer;
    }

    public ChunkedNioFile(FileChannel fileChannel, long j10, long j11, int i10) throws IOException {
        ObjectUtil.checkNotNull(fileChannel, "in");
        ObjectUtil.checkPositiveOrZero(j10, TypedValues.CycleType.S_WAVE_OFFSET);
        ObjectUtil.checkPositiveOrZero(j11, "length");
        ObjectUtil.checkPositive(i10, "chunkSize");
        if (fileChannel.isOpen()) {
            this.f8339in = fileChannel;
            this.chunkSize = i10;
            this.startOffset = j10;
            this.offset = j10;
            this.endOffset = j10 + j11;
            return;
        }
        throw new ClosedChannelException();
    }
}
