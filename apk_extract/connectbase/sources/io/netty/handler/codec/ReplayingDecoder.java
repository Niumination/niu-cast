package io.netty.handler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.Signal;
import io.netty.util.internal.StringUtil;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ReplayingDecoder<S> extends ByteToMessageDecoder {
    static final Signal REPLAY = Signal.valueOf(ReplayingDecoder.class, "REPLAY");
    private int checkpoint;
    private final ReplayingDecoderByteBuf replayable;
    private S state;

    public ReplayingDecoder() {
        this(null);
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public void callDecode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
        int i10;
        this.replayable.setCumulation(byteBuf);
        while (byteBuf.isReadable()) {
            try {
                int i11 = byteBuf.readerIndex();
                this.checkpoint = i11;
                int size = list.size();
                if (size > 0) {
                    ByteToMessageDecoder.fireChannelRead(channelHandlerContext, list, size);
                    list.clear();
                    if (channelHandlerContext.isRemoved()) {
                        return;
                    } else {
                        size = 0;
                    }
                }
                S s10 = this.state;
                int i12 = byteBuf.readableBytes();
                try {
                    decodeRemovalReentryProtection(channelHandlerContext, this.replayable, list);
                    if (channelHandlerContext.isRemoved()) {
                        return;
                    }
                    if (size != list.size()) {
                        if (i11 == byteBuf.readerIndex() && s10 == this.state) {
                            throw new DecoderException(StringUtil.simpleClassName(getClass()) + ".decode() method must consume the inbound data or change its state if it decoded something.");
                        }
                        if (isSingleDecode()) {
                            return;
                        }
                    } else if (i12 == byteBuf.readableBytes() && s10 == this.state) {
                        throw new DecoderException(StringUtil.simpleClassName(getClass()) + ".decode() must consume the inbound data or change its state if it did not decode anything.");
                    }
                } catch (Signal e10) {
                    e10.expect(REPLAY);
                    if (!channelHandlerContext.isRemoved() && (i10 = this.checkpoint) >= 0) {
                        byteBuf.readerIndex(i10);
                        return;
                    }
                    return;
                }
            } catch (DecoderException e11) {
                throw e11;
            } catch (Exception e12) {
                throw new DecoderException(e12);
            }
        }
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public final void channelInputClosed(ChannelHandlerContext channelHandlerContext, List<Object> list) throws Exception {
        try {
            this.replayable.terminate();
            if (this.cumulation != null) {
                callDecode(channelHandlerContext, internalBuffer(), list);
            } else {
                this.replayable.setCumulation(Unpooled.EMPTY_BUFFER);
            }
            decodeLast(channelHandlerContext, this.replayable, list);
        } catch (Signal e10) {
            e10.expect(REPLAY);
        }
    }

    public void checkpoint() {
        this.checkpoint = internalBuffer().readerIndex();
    }

    public S state() {
        return this.state;
    }

    public ReplayingDecoder(S s10) {
        this.replayable = new ReplayingDecoderByteBuf();
        this.checkpoint = -1;
        this.state = s10;
    }

    public void checkpoint(S s10) {
        checkpoint();
        state(s10);
    }

    public S state(S s10) {
        S s11 = this.state;
        this.state = s10;
        return s11;
    }
}
