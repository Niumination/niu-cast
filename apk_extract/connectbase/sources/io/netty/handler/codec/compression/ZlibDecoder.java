package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.util.internal.ObjectUtil;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ZlibDecoder extends ByteToMessageDecoder {
    protected final int maxAllocation;

    public ZlibDecoder() {
        this(0);
    }

    public void decompressionBufferExhausted(ByteBuf byteBuf) {
    }

    public abstract boolean isClosed();

    public ByteBuf prepareDecompressBuffer(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, int i10) {
        if (byteBuf == null) {
            return this.maxAllocation == 0 ? channelHandlerContext.alloc().heapBuffer(i10) : channelHandlerContext.alloc().heapBuffer(Math.min(i10, this.maxAllocation), this.maxAllocation);
        }
        if (byteBuf.ensureWritable(i10, true) != 1) {
            return byteBuf;
        }
        decompressionBufferExhausted(byteBuf.duplicate());
        byteBuf.skipBytes(byteBuf.readableBytes());
        throw new DecompressionException("Decompression buffer has reached maximum size: " + byteBuf.maxCapacity());
    }

    public ZlibDecoder(int i10) {
        this.maxAllocation = ObjectUtil.checkPositiveOrZero(i10, "maxAllocation");
    }
}
