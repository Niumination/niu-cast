package io.netty.channel;

import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.TypeParameterMatcher;

/* JADX INFO: loaded from: classes2.dex */
public abstract class SimpleChannelInboundHandler<I> extends ChannelInboundHandlerAdapter {
    private final boolean autoRelease;
    private final TypeParameterMatcher matcher;

    public SimpleChannelInboundHandler() {
        this(true);
    }

    public boolean acceptInboundMessage(Object obj) throws Exception {
        return this.matcher.match(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        boolean z10 = true;
        try {
            if (acceptInboundMessage(obj)) {
                channelRead0(channelHandlerContext, obj);
            } else {
                z10 = false;
                channelHandlerContext.fireChannelRead(obj);
            }
        } finally {
            if (this.autoRelease && 1 != 0) {
                ReferenceCountUtil.release(obj);
            }
        }
    }

    public abstract void channelRead0(ChannelHandlerContext channelHandlerContext, I i10) throws Exception;

    public SimpleChannelInboundHandler(boolean z10) {
        this.matcher = TypeParameterMatcher.find(this, SimpleChannelInboundHandler.class, "I");
        this.autoRelease = z10;
    }

    public SimpleChannelInboundHandler(Class<? extends I> cls) {
        this(cls, true);
    }

    public SimpleChannelInboundHandler(Class<? extends I> cls, boolean z10) {
        this.matcher = TypeParameterMatcher.get(cls);
        this.autoRelease = z10;
    }
}
