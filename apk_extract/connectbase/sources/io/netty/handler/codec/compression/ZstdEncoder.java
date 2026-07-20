package io.netty.handler.codec.compression;

import c.a;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.EncoderException;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.util.internal.ObjectUtil;
import j.b;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public final class ZstdEncoder extends MessageToByteEncoder<ByteBuf> {
    private final int blockSize;
    private ByteBuf buffer;
    private final int compressionLevel;
    private final int maxEncodeSize;

    public ZstdEncoder() {
        this(3, 65536, 33554432);
    }

    private void flushBufferedData(ByteBuf byteBuf) {
        int i10 = this.buffer.readableBytes();
        if (i10 == 0) {
            return;
        }
        byteBuf.ensureWritable((int) com.github.luben.zstd.Zstd.compressBound(i10));
        int iWriterIndex = byteBuf.writerIndex();
        try {
            ByteBuffer byteBufferInternalNioBuffer = byteBuf.internalNioBuffer(iWriterIndex, byteBuf.writableBytes());
            ByteBuf byteBuf2 = this.buffer;
            byteBuf.writerIndex(iWriterIndex + com.github.luben.zstd.Zstd.compress(byteBufferInternalNioBuffer, byteBuf2.internalNioBuffer(byteBuf2.readerIndex(), i10), this.compressionLevel));
            this.buffer.clear();
        } catch (Exception e10) {
            throw new CompressionException(e10);
        }
    }

    @Override // io.netty.channel.ChannelOutboundHandlerAdapter, io.netty.channel.ChannelOutboundHandler
    public void flush(ChannelHandlerContext channelHandlerContext) {
        ByteBuf byteBuf = this.buffer;
        if (byteBuf != null && byteBuf.isReadable()) {
            ByteBuf byteBufAllocateBuffer = allocateBuffer(channelHandlerContext, Unpooled.EMPTY_BUFFER, isPreferDirect());
            flushBufferedData(byteBufAllocateBuffer);
            channelHandlerContext.write(byteBufAllocateBuffer);
        }
        channelHandlerContext.flush();
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) {
        ByteBuf byteBufDirectBuffer = channelHandlerContext.alloc().directBuffer(this.blockSize);
        this.buffer = byteBufDirectBuffer;
        byteBufDirectBuffer.clear();
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
        super.handlerRemoved(channelHandlerContext);
        ByteBuf byteBuf = this.buffer;
        if (byteBuf != null) {
            byteBuf.release();
            this.buffer = null;
        }
    }

    public ZstdEncoder(int i10) {
        this(i10, 65536, 33554432);
    }

    @Override // io.netty.handler.codec.MessageToByteEncoder
    public ByteBuf allocateBuffer(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, boolean z10) {
        if (this.buffer == null) {
            throw new IllegalStateException("not added to a pipeline,or has been removed,buffer is null");
        }
        int i10 = this.buffer.readableBytes() + byteBuf.readableBytes();
        if (i10 < 0) {
            throw new EncoderException("too much data to allocate a buffer for compression");
        }
        long jCompressBound = 0;
        while (i10 > 0) {
            int iMin = Math.min(this.blockSize, i10);
            i10 -= iMin;
            jCompressBound += com.github.luben.zstd.Zstd.compressBound(iMin);
        }
        if (jCompressBound > this.maxEncodeSize || 0 > jCompressBound) {
            throw new EncoderException(a.a(b.a("requested encode buffer size (", jCompressBound, " bytes) exceeds the maximum allowable size ("), this.maxEncodeSize, " bytes)"));
        }
        return channelHandlerContext.alloc().directBuffer((int) jCompressBound);
    }

    @Override // io.netty.handler.codec.MessageToByteEncoder
    public void encode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, ByteBuf byteBuf2) {
        ByteBuf byteBuf3 = this.buffer;
        if (byteBuf3 == null) {
            throw new IllegalStateException("not added to a pipeline,or has been removed,buffer is null");
        }
        while (true) {
            int i10 = byteBuf.readableBytes();
            if (i10 <= 0) {
                return;
            }
            byteBuf.readBytes(byteBuf3, Math.min(i10, byteBuf3.writableBytes()));
            if (!byteBuf3.isWritable()) {
                flushBufferedData(byteBuf2);
            }
        }
    }

    public ZstdEncoder(int i10, int i11) {
        this(3, i10, i11);
    }

    public ZstdEncoder(int i10, int i11, int i12) {
        super(true);
        this.compressionLevel = ObjectUtil.checkInRange(i10, 0, 22, "compressionLevel");
        this.blockSize = ObjectUtil.checkPositive(i11, "blockSize");
        this.maxEncodeSize = ObjectUtil.checkPositive(i12, "maxEncodeSize");
    }
}
