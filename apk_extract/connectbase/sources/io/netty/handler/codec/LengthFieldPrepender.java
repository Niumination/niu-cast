package io.netty.handler.codec;

import h.a;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.internal.ObjectUtil;
import java.nio.ByteOrder;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
@ChannelHandler.Sharable
public class LengthFieldPrepender extends MessageToMessageEncoder<ByteBuf> {
    private final ByteOrder byteOrder;
    private final int lengthAdjustment;
    private final int lengthFieldLength;
    private final boolean lengthIncludesLengthFieldLength;

    public LengthFieldPrepender(int i10) {
        this(i10, false);
    }

    @Override // io.netty.handler.codec.MessageToMessageEncoder
    public /* bridge */ /* synthetic */ void encode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List list) throws Exception {
        encode2(channelHandlerContext, byteBuf, (List<Object>) list);
    }

    public LengthFieldPrepender(int i10, boolean z10) {
        this(i10, 0, z10);
    }

    /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
    public void encode2(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        int i10 = byteBuf.readableBytes() + this.lengthAdjustment;
        if (this.lengthIncludesLengthFieldLength) {
            i10 += this.lengthFieldLength;
        }
        ObjectUtil.checkPositiveOrZero(i10, "length");
        int i11 = this.lengthFieldLength;
        if (i11 != 1) {
            if (i11 != 2) {
                if (i11 != 3) {
                    if (i11 == 4) {
                        list.add(channelHandlerContext.alloc().buffer(4).order(this.byteOrder).writeInt(i10));
                    } else {
                        if (i11 != 8) {
                            throw new Error("should not reach here");
                        }
                        list.add(channelHandlerContext.alloc().buffer(8).order(this.byteOrder).writeLong(i10));
                    }
                } else {
                    if (i10 >= 16777216) {
                        throw new IllegalArgumentException(a.a("length does not fit into a medium integer: ", i10));
                    }
                    list.add(channelHandlerContext.alloc().buffer(3).order(this.byteOrder).writeMedium(i10));
                }
            } else {
                if (i10 >= 65536) {
                    throw new IllegalArgumentException(a.a("length does not fit into a short integer: ", i10));
                }
                list.add(channelHandlerContext.alloc().buffer(2).order(this.byteOrder).writeShort((short) i10));
            }
        } else {
            if (i10 >= 256) {
                throw new IllegalArgumentException(a.a("length does not fit into a byte: ", i10));
            }
            list.add(channelHandlerContext.alloc().buffer(1).order(this.byteOrder).writeByte((byte) i10));
        }
        list.add(byteBuf.retain());
    }

    public LengthFieldPrepender(int i10, int i11) {
        this(i10, i11, false);
    }

    public LengthFieldPrepender(int i10, int i11, boolean z10) {
        this(ByteOrder.BIG_ENDIAN, i10, i11, z10);
    }

    public LengthFieldPrepender(ByteOrder byteOrder, int i10, int i11, boolean z10) {
        if (i10 != 1 && i10 != 2 && i10 != 3 && i10 != 4 && i10 != 8) {
            throw new IllegalArgumentException(a.a("lengthFieldLength must be either 1, 2, 3, 4, or 8: ", i10));
        }
        this.byteOrder = (ByteOrder) ObjectUtil.checkNotNull(byteOrder, "byteOrder");
        this.lengthFieldLength = i10;
        this.lengthIncludesLengthFieldLength = z10;
        this.lengthAdjustment = i11;
    }
}
