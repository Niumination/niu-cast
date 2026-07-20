package io.netty.handler.ssl;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.ChannelInputShutdownEvent;
import io.netty.handler.codec.DecoderException;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.RecyclableArrayList;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import javax.net.ssl.SSLException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ApplicationProtocolNegotiationHandler extends ChannelInboundHandlerAdapter {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) ApplicationProtocolNegotiationHandler.class);
    private final RecyclableArrayList bufferedMessages = RecyclableArrayList.newInstance();
    private ChannelHandlerContext ctx;
    private final String fallbackProtocol;
    private boolean sslHandlerChecked;

    public ApplicationProtocolNegotiationHandler(String str) {
        this.fallbackProtocol = (String) ObjectUtil.checkNotNull(str, "fallbackProtocol");
    }

    private void fireBufferedMessages() {
        if (this.bufferedMessages.isEmpty()) {
            return;
        }
        for (int i10 = 0; i10 < this.bufferedMessages.size(); i10++) {
            this.ctx.fireChannelRead(this.bufferedMessages.get(i10));
        }
        this.ctx.fireChannelReadComplete();
        this.bufferedMessages.clear();
    }

    private void removeSelfIfPresent(ChannelHandlerContext channelHandlerContext) {
        ChannelPipeline channelPipelinePipeline = channelHandlerContext.pipeline();
        if (channelHandlerContext.isRemoved()) {
            return;
        }
        channelPipelinePipeline.remove(this);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
        fireBufferedMessages();
        super.channelInactive(channelHandlerContext);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        this.bufferedMessages.add(obj);
        if (this.sslHandlerChecked) {
            return;
        }
        this.sslHandlerChecked = true;
        if (channelHandlerContext.pipeline().get(SslHandler.class) == null) {
            removeSelfIfPresent(channelHandlerContext);
        }
    }

    public abstract void configurePipeline(ChannelHandlerContext channelHandlerContext, String str) throws Exception;

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th2) throws Exception {
        if (th2 instanceof DecoderException) {
            Throwable cause = th2.getCause();
            if (cause instanceof SSLException) {
                try {
                    handshakeFailure(channelHandlerContext, cause);
                    return;
                } finally {
                    removeSelfIfPresent(channelHandlerContext);
                }
            }
        }
        logger.warn("{} Failed to select the application-level protocol:", channelHandlerContext.channel(), th2);
        channelHandlerContext.fireExceptionCaught(th2);
        channelHandlerContext.close();
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.ctx = channelHandlerContext;
        super.handlerAdded(channelHandlerContext);
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
        fireBufferedMessages();
        this.bufferedMessages.recycle();
        super.handlerRemoved(channelHandlerContext);
    }

    public void handshakeFailure(ChannelHandlerContext channelHandlerContext, Throwable th2) throws Exception {
        logger.warn("{} TLS handshake failed:", channelHandlerContext.channel(), th2);
        channelHandlerContext.close();
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        if (obj instanceof SslHandshakeCompletionEvent) {
            SslHandshakeCompletionEvent sslHandshakeCompletionEvent = (SslHandshakeCompletionEvent) obj;
            try {
                if (sslHandshakeCompletionEvent.isSuccess()) {
                    SslHandler sslHandler = (SslHandler) channelHandlerContext.pipeline().get(SslHandler.class);
                    if (sslHandler == null) {
                        throw new IllegalStateException("cannot find an SslHandler in the pipeline (required for application-level protocol negotiation)");
                    }
                    String strApplicationProtocol = sslHandler.applicationProtocol();
                    if (strApplicationProtocol == null) {
                        strApplicationProtocol = this.fallbackProtocol;
                    }
                    configurePipeline(channelHandlerContext, strApplicationProtocol);
                }
                if (sslHandshakeCompletionEvent.isSuccess()) {
                    removeSelfIfPresent(channelHandlerContext);
                }
            } catch (Throwable th2) {
                try {
                    exceptionCaught(channelHandlerContext, th2);
                    if (sslHandshakeCompletionEvent.isSuccess()) {
                    }
                } catch (Throwable th3) {
                    if (sslHandshakeCompletionEvent.isSuccess()) {
                        removeSelfIfPresent(channelHandlerContext);
                    }
                    throw th3;
                }
            }
        }
        if (obj instanceof ChannelInputShutdownEvent) {
            fireBufferedMessages();
        }
        channelHandlerContext.fireUserEventTriggered(obj);
    }
}
