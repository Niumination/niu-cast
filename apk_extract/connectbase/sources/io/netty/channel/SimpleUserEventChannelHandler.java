package io.netty.channel;

import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.TypeParameterMatcher;

/* JADX INFO: loaded from: classes2.dex */
public abstract class SimpleUserEventChannelHandler<I> extends ChannelInboundHandlerAdapter {
    private final boolean autoRelease;
    private final TypeParameterMatcher matcher;

    public SimpleUserEventChannelHandler() {
        this(true);
    }

    public boolean acceptEvent(Object obj) throws Exception {
        return this.matcher.match(obj);
    }

    public abstract void eventReceived(ChannelHandlerContext channelHandlerContext, I i10) throws Exception;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public final void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        boolean z10 = true;
        try {
            if (acceptEvent(obj)) {
                eventReceived(channelHandlerContext, obj);
            } else {
                z10 = false;
                channelHandlerContext.fireUserEventTriggered(obj);
            }
        } finally {
            if (this.autoRelease && 1 != 0) {
                ReferenceCountUtil.release(obj);
            }
        }
    }

    public SimpleUserEventChannelHandler(boolean z10) {
        this.matcher = TypeParameterMatcher.find(this, SimpleUserEventChannelHandler.class, "I");
        this.autoRelease = z10;
    }

    public SimpleUserEventChannelHandler(Class<? extends I> cls) {
        this(cls, true);
    }

    public SimpleUserEventChannelHandler(Class<? extends I> cls, boolean z10) {
        this.matcher = TypeParameterMatcher.get(cls);
        this.autoRelease = z10;
    }
}
