package io.netty.handler.codec;

import c.a;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.internal.ObjectUtil;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class DelimiterBasedFrameDecoder extends ByteToMessageDecoder {
    private final ByteBuf[] delimiters;
    private boolean discardingTooLongFrame;
    private final boolean failFast;
    private final LineBasedFrameDecoder lineBasedDecoder;
    private final int maxFrameLength;
    private final boolean stripDelimiter;
    private int tooLongFrameLength;

    public DelimiterBasedFrameDecoder(int i10, ByteBuf byteBuf) {
        this(i10, true, byteBuf);
    }

    private void fail(long j10) {
        if (j10 <= 0) {
            throw new TooLongFrameException(a.a(new StringBuilder("frame length exceeds "), this.maxFrameLength, " - discarding"));
        }
        throw new TooLongFrameException("frame length exceeds " + this.maxFrameLength + ": " + j10 + " - discarded");
    }

    private static int indexOf(ByteBuf byteBuf, ByteBuf byteBuf2) {
        int iIndexOf = ByteBufUtil.indexOf(byteBuf2, byteBuf);
        if (iIndexOf == -1) {
            return -1;
        }
        return iIndexOf - byteBuf.readerIndex();
    }

    private static boolean isLineBased(ByteBuf[] byteBufArr) {
        if (byteBufArr.length != 2) {
            return false;
        }
        ByteBuf byteBuf = byteBufArr[0];
        ByteBuf byteBuf2 = byteBufArr[1];
        if (byteBuf.capacity() < byteBuf2.capacity()) {
            byteBuf = byteBufArr[1];
            byteBuf2 = byteBufArr[0];
        }
        return byteBuf.capacity() == 2 && byteBuf2.capacity() == 1 && byteBuf.getByte(0) == 13 && byteBuf.getByte(1) == 10 && byteBuf2.getByte(0) == 10;
    }

    private boolean isSubclass() {
        return getClass() != DelimiterBasedFrameDecoder.class;
    }

    private static void validateDelimiter(ByteBuf byteBuf) {
        ObjectUtil.checkNotNull(byteBuf, "delimiter");
        if (!byteBuf.isReadable()) {
            throw new IllegalArgumentException("empty delimiter");
        }
    }

    private static void validateMaxFrameLength(int i10) {
        ObjectUtil.checkPositive(i10, "maxFrameLength");
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public final void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        Object objDecode = decode(channelHandlerContext, byteBuf);
        if (objDecode != null) {
            list.add(objDecode);
        }
    }

    public DelimiterBasedFrameDecoder(int i10, boolean z10, ByteBuf byteBuf) {
        this(i10, z10, true, byteBuf);
    }

    public DelimiterBasedFrameDecoder(int i10, boolean z10, boolean z11, ByteBuf byteBuf) {
        this(i10, z10, z11, byteBuf.slice(byteBuf.readerIndex(), byteBuf.readableBytes()));
    }

    public Object decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
        LineBasedFrameDecoder lineBasedFrameDecoder = this.lineBasedDecoder;
        if (lineBasedFrameDecoder != null) {
            return lineBasedFrameDecoder.decode(channelHandlerContext, byteBuf);
        }
        int i10 = Integer.MAX_VALUE;
        ByteBuf byteBuf2 = null;
        for (ByteBuf byteBuf3 : this.delimiters) {
            int iIndexOf = indexOf(byteBuf, byteBuf3);
            if (iIndexOf >= 0 && iIndexOf < i10) {
                byteBuf2 = byteBuf3;
                i10 = iIndexOf;
            }
        }
        if (byteBuf2 != null) {
            int iCapacity = byteBuf2.capacity();
            if (this.discardingTooLongFrame) {
                this.discardingTooLongFrame = false;
                byteBuf.skipBytes(i10 + iCapacity);
                int i11 = this.tooLongFrameLength;
                this.tooLongFrameLength = 0;
                if (!this.failFast) {
                    fail(i11);
                }
                return null;
            }
            if (i10 > this.maxFrameLength) {
                byteBuf.skipBytes(iCapacity + i10);
                fail(i10);
                return null;
            }
            if (this.stripDelimiter) {
                ByteBuf retainedSlice = byteBuf.readRetainedSlice(i10);
                byteBuf.skipBytes(iCapacity);
                return retainedSlice;
            }
            return byteBuf.readRetainedSlice(i10 + iCapacity);
        }
        if (!this.discardingTooLongFrame) {
            if (byteBuf.readableBytes() > this.maxFrameLength) {
                this.tooLongFrameLength = byteBuf.readableBytes();
                byteBuf.skipBytes(byteBuf.readableBytes());
                this.discardingTooLongFrame = true;
                if (this.failFast) {
                    fail(this.tooLongFrameLength);
                }
            }
        } else {
            this.tooLongFrameLength = byteBuf.readableBytes() + this.tooLongFrameLength;
            byteBuf.skipBytes(byteBuf.readableBytes());
        }
        return null;
    }

    public DelimiterBasedFrameDecoder(int i10, ByteBuf... byteBufArr) {
        this(i10, true, byteBufArr);
    }

    public DelimiterBasedFrameDecoder(int i10, boolean z10, ByteBuf... byteBufArr) {
        this(i10, z10, true, byteBufArr);
    }

    public DelimiterBasedFrameDecoder(int i10, boolean z10, boolean z11, ByteBuf... byteBufArr) {
        validateMaxFrameLength(i10);
        ObjectUtil.checkNonEmpty(byteBufArr, "delimiters");
        if (isLineBased(byteBufArr) && !isSubclass()) {
            this.lineBasedDecoder = new LineBasedFrameDecoder(i10, z10, z11);
            this.delimiters = null;
        } else {
            this.delimiters = new ByteBuf[byteBufArr.length];
            for (int i11 = 0; i11 < byteBufArr.length; i11++) {
                ByteBuf byteBuf = byteBufArr[i11];
                validateDelimiter(byteBuf);
                this.delimiters[i11] = byteBuf.slice(byteBuf.readerIndex(), byteBuf.readableBytes());
            }
            this.lineBasedDecoder = null;
        }
        this.maxFrameLength = i10;
        this.stripDelimiter = z10;
        this.failFast = z11;
    }
}
