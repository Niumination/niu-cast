package io.netty.handler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ByteProcessor;
import java.util.List;
import u.a;

/* JADX INFO: loaded from: classes3.dex */
public class LineBasedFrameDecoder extends ByteToMessageDecoder {
    private int discardedBytes;
    private boolean discarding;
    private final boolean failFast;
    private final int maxLength;
    private int offset;
    private final boolean stripDelimiter;

    public LineBasedFrameDecoder(int i10) {
        this(i10, true, false);
    }

    private void fail(ChannelHandlerContext channelHandlerContext, int i10) {
        fail(channelHandlerContext, String.valueOf(i10));
    }

    private int findEndOfLine(ByteBuf byteBuf) {
        int i10 = byteBuf.readableBytes();
        int i11 = byteBuf.readerIndex();
        int i12 = this.offset;
        int iForEachByte = byteBuf.forEachByte(i11 + i12, i10 - i12, ByteProcessor.FIND_LF);
        if (iForEachByte >= 0) {
            this.offset = 0;
            return (iForEachByte <= 0 || byteBuf.getByte(iForEachByte + (-1)) != 13) ? iForEachByte : iForEachByte - 1;
        }
        this.offset = i10;
        return iForEachByte;
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public final void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        Object objDecode = decode(channelHandlerContext, byteBuf);
        if (objDecode != null) {
            list.add(objDecode);
        }
    }

    public LineBasedFrameDecoder(int i10, boolean z10, boolean z11) {
        this.maxLength = i10;
        this.failFast = z11;
        this.stripDelimiter = z10;
    }

    private void fail(ChannelHandlerContext channelHandlerContext, String str) {
        channelHandlerContext.fireExceptionCaught((Throwable) new TooLongFrameException(a.a(e.a.a("frame length (", str, ") exceeds the allowed maximum ("), this.maxLength, ')')));
    }

    public Object decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
        int iFindEndOfLine = findEndOfLine(byteBuf);
        if (this.discarding) {
            if (iFindEndOfLine >= 0) {
                int i10 = (this.discardedBytes + iFindEndOfLine) - byteBuf.readerIndex();
                byteBuf.readerIndex(iFindEndOfLine + (byteBuf.getByte(iFindEndOfLine) != 13 ? 1 : 2));
                this.discardedBytes = 0;
                this.discarding = false;
                if (!this.failFast) {
                    fail(channelHandlerContext, i10);
                }
            } else {
                this.discardedBytes = byteBuf.readableBytes() + this.discardedBytes;
                byteBuf.readerIndex(byteBuf.writerIndex());
                this.offset = 0;
            }
            return null;
        }
        if (iFindEndOfLine >= 0) {
            int i11 = iFindEndOfLine - byteBuf.readerIndex();
            int i12 = byteBuf.getByte(iFindEndOfLine) != 13 ? 1 : 2;
            if (i11 > this.maxLength) {
                byteBuf.readerIndex(iFindEndOfLine + i12);
                fail(channelHandlerContext, i11);
                return null;
            }
            if (this.stripDelimiter) {
                ByteBuf retainedSlice = byteBuf.readRetainedSlice(i11);
                byteBuf.skipBytes(i12);
                return retainedSlice;
            }
            return byteBuf.readRetainedSlice(i11 + i12);
        }
        int i13 = byteBuf.readableBytes();
        if (i13 > this.maxLength) {
            this.discardedBytes = i13;
            byteBuf.readerIndex(byteBuf.writerIndex());
            this.discarding = true;
            this.offset = 0;
            if (this.failFast) {
                fail(channelHandlerContext, "over " + this.discardedBytes);
            }
        }
        return null;
    }
}
