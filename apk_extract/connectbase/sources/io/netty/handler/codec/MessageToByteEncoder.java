package io.netty.handler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.TypeParameterMatcher;

/* JADX INFO: loaded from: classes3.dex */
public abstract class MessageToByteEncoder<I> extends ChannelOutboundHandlerAdapter {
    private final TypeParameterMatcher matcher;
    private final boolean preferDirect;

    public MessageToByteEncoder() {
        this(true);
    }

    public boolean acceptOutboundMessage(Object obj) throws Exception {
        return this.matcher.match(obj);
    }

    public ByteBuf allocateBuffer(ChannelHandlerContext channelHandlerContext, I i10, boolean z10) throws Exception {
        return z10 ? channelHandlerContext.alloc().ioBuffer() : channelHandlerContext.alloc().heapBuffer();
    }

    public abstract void encode(ChannelHandlerContext channelHandlerContext, I i10, ByteBuf byteBuf) throws Exception;

    public boolean isPreferDirect() {
        return this.preferDirect;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.channel.ChannelOutboundHandlerAdapter, io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Exception {
        ReferenceCounted referenceCounted = null;
        try {
            try {
                if (!acceptOutboundMessage(obj)) {
                    channelHandlerContext.write(obj, channelPromise);
                    return;
                }
                ByteBuf byteBufAllocateBuffer = allocateBuffer(channelHandlerContext, obj, this.preferDirect);
                try {
                    encode(channelHandlerContext, obj, byteBufAllocateBuffer);
                    ReferenceCountUtil.release(obj);
                    if (byteBufAllocateBuffer.isReadable()) {
                        channelHandlerContext.write(byteBufAllocateBuffer, channelPromise);
                    } else {
                        byteBufAllocateBuffer.release();
                        channelHandlerContext.write(Unpooled.EMPTY_BUFFER, channelPromise);
                    }
                } catch (Throwable th2) {
                    ReferenceCountUtil.release(obj);
                    throw th2;
                }
            } catch (Throwable th3) {
                if (0 != 0) {
                    referenceCounted.release();
                }
                throw th3;
            }
        } catch (EncoderException e10) {
            throw e10;
        } catch (Throwable th4) {
            throw new EncoderException(th4);
        }
    }

    public MessageToByteEncoder(Class<? extends I> cls) {
        this(cls, true);
    }

    public MessageToByteEncoder(boolean z10) {
        this.matcher = TypeParameterMatcher.find(this, MessageToByteEncoder.class, "I");
        this.preferDirect = z10;
    }

    public MessageToByteEncoder(Class<? extends I> cls, boolean z10) {
        this.matcher = TypeParameterMatcher.get(cls);
        this.preferDirect = z10;
    }
}
