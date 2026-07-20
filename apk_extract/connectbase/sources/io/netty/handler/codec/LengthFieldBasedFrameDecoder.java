package io.netty.handler.codec;

import c.a;
import h0.b;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.internal.ObjectUtil;
import java.nio.ByteOrder;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class LengthFieldBasedFrameDecoder extends ByteToMessageDecoder {
    private final ByteOrder byteOrder;
    private long bytesToDiscard;
    private boolean discardingTooLongFrame;
    private final boolean failFast;
    private int frameLengthInt;
    private final int initialBytesToStrip;
    private final int lengthAdjustment;
    private final int lengthFieldEndOffset;
    private final int lengthFieldLength;
    private final int lengthFieldOffset;
    private final int maxFrameLength;
    private long tooLongFrameLength;

    public LengthFieldBasedFrameDecoder(int i10, int i11, int i12) {
        this(i10, i11, i12, 0, 0);
    }

    private void discardingTooLongFrame(ByteBuf byteBuf) {
        long j10 = this.bytesToDiscard;
        int iMin = (int) Math.min(j10, byteBuf.readableBytes());
        byteBuf.skipBytes(iMin);
        this.bytesToDiscard = j10 - ((long) iMin);
        failIfNecessary(false);
    }

    private void exceededFrameLength(ByteBuf byteBuf, long j10) {
        long j11 = j10 - ((long) byteBuf.readableBytes());
        this.tooLongFrameLength = j10;
        if (j11 < 0) {
            byteBuf.skipBytes((int) j10);
        } else {
            this.discardingTooLongFrame = true;
            this.bytesToDiscard = j11;
            byteBuf.skipBytes(byteBuf.readableBytes());
        }
        failIfNecessary(true);
    }

    private void fail(long j10) {
        if (j10 <= 0) {
            throw new TooLongFrameException(a.a(new StringBuilder("Adjusted frame length exceeds "), this.maxFrameLength, " - discarding"));
        }
        throw new TooLongFrameException("Adjusted frame length exceeds " + this.maxFrameLength + ": " + j10 + " - discarded");
    }

    private void failIfNecessary(boolean z10) {
        if (this.bytesToDiscard != 0) {
            if (this.failFast && z10) {
                fail(this.tooLongFrameLength);
                return;
            }
            return;
        }
        long j10 = this.tooLongFrameLength;
        this.tooLongFrameLength = 0L;
        this.discardingTooLongFrame = false;
        if (!this.failFast || z10) {
            fail(j10);
        }
    }

    private static void failOnFrameLengthLessThanInitialBytesToStrip(ByteBuf byteBuf, long j10, int i10) {
        byteBuf.skipBytes((int) j10);
        throw new CorruptedFrameException("Adjusted frame length (" + j10 + ") is less than initialBytesToStrip: " + i10);
    }

    private static void failOnFrameLengthLessThanLengthFieldEndOffset(ByteBuf byteBuf, long j10, int i10) {
        byteBuf.skipBytes(i10);
        throw new CorruptedFrameException("Adjusted frame length (" + j10 + ") is less than lengthFieldEndOffset: " + i10);
    }

    private static void failOnNegativeLengthField(ByteBuf byteBuf, long j10, int i10) {
        byteBuf.skipBytes(i10);
        throw new CorruptedFrameException(b.a("negative pre-adjustment length field: ", j10));
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public final void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        Object objDecode = decode(channelHandlerContext, byteBuf);
        if (objDecode != null) {
            list.add(objDecode);
        }
    }

    public ByteBuf extractFrame(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, int i10, int i11) {
        return byteBuf.retainedSlice(i10, i11);
    }

    public long getUnadjustedFrameLength(ByteBuf byteBuf, int i10, int i11, ByteOrder byteOrder) {
        int unsignedByte;
        ByteBuf byteBufOrder = byteBuf.order(byteOrder);
        if (i11 == 1) {
            unsignedByte = byteBufOrder.getUnsignedByte(i10);
        } else if (i11 == 2) {
            unsignedByte = byteBufOrder.getUnsignedShort(i10);
        } else {
            if (i11 != 3) {
                if (i11 == 4) {
                    return byteBufOrder.getUnsignedInt(i10);
                }
                if (i11 == 8) {
                    return byteBufOrder.getLong(i10);
                }
                throw new DecoderException(a.a(new StringBuilder("unsupported lengthFieldLength: "), this.lengthFieldLength, " (expected: 1, 2, 3, 4, or 8)"));
            }
            unsignedByte = byteBufOrder.getUnsignedMedium(i10);
        }
        return unsignedByte;
    }

    public LengthFieldBasedFrameDecoder(int i10, int i11, int i12, int i13, int i14) {
        this(i10, i11, i12, i13, i14, true);
    }

    public LengthFieldBasedFrameDecoder(int i10, int i11, int i12, int i13, int i14, boolean z10) {
        this(ByteOrder.BIG_ENDIAN, i10, i11, i12, i13, i14, z10);
    }

    public Object decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
        long j10 = 0;
        if (this.frameLengthInt == -1) {
            if (this.discardingTooLongFrame) {
                discardingTooLongFrame(byteBuf);
            }
            if (byteBuf.readableBytes() < this.lengthFieldEndOffset) {
                return null;
            }
            long unadjustedFrameLength = getUnadjustedFrameLength(byteBuf, byteBuf.readerIndex() + this.lengthFieldOffset, this.lengthFieldLength, this.byteOrder);
            if (unadjustedFrameLength < 0) {
                failOnNegativeLengthField(byteBuf, unadjustedFrameLength, this.lengthFieldEndOffset);
            }
            int i10 = this.lengthAdjustment;
            int i11 = this.lengthFieldEndOffset;
            long j11 = unadjustedFrameLength + ((long) (i10 + i11));
            if (j11 < i11) {
                failOnFrameLengthLessThanLengthFieldEndOffset(byteBuf, j11, i11);
            }
            if (j11 > this.maxFrameLength) {
                exceededFrameLength(byteBuf, j11);
                return null;
            }
            this.frameLengthInt = (int) j11;
            j10 = j11;
        }
        int i12 = byteBuf.readableBytes();
        int i13 = this.frameLengthInt;
        if (i12 < i13) {
            return null;
        }
        int i14 = this.initialBytesToStrip;
        if (i14 > i13) {
            failOnFrameLengthLessThanInitialBytesToStrip(byteBuf, j10, i14);
        }
        byteBuf.skipBytes(this.initialBytesToStrip);
        int i15 = byteBuf.readerIndex();
        int i16 = this.frameLengthInt - this.initialBytesToStrip;
        ByteBuf byteBufExtractFrame = extractFrame(channelHandlerContext, byteBuf, i15, i16);
        byteBuf.readerIndex(i15 + i16);
        this.frameLengthInt = -1;
        return byteBufExtractFrame;
    }

    public LengthFieldBasedFrameDecoder(ByteOrder byteOrder, int i10, int i11, int i12, int i13, int i14, boolean z10) {
        this.frameLengthInt = -1;
        this.byteOrder = (ByteOrder) ObjectUtil.checkNotNull(byteOrder, "byteOrder");
        ObjectUtil.checkPositive(i10, "maxFrameLength");
        ObjectUtil.checkPositiveOrZero(i11, "lengthFieldOffset");
        ObjectUtil.checkPositiveOrZero(i14, "initialBytesToStrip");
        if (i11 <= i10 - i12) {
            this.maxFrameLength = i10;
            this.lengthFieldOffset = i11;
            this.lengthFieldLength = i12;
            this.lengthAdjustment = i13;
            this.lengthFieldEndOffset = i11 + i12;
            this.initialBytesToStrip = i14;
            this.failFast = z10;
            return;
        }
        throw new IllegalArgumentException(a.a(i0.a.a("maxFrameLength (", i10, ") must be equal to or greater than lengthFieldOffset (", i11, ") + lengthFieldLength ("), i12, ")."));
    }
}
