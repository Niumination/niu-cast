package io.netty.handler.proxy;

import io.netty.channel.Channel;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.channel.PendingWriteQueue;
import io.netty.handler.codec.rtsp.RtspHeaders;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.DefaultPromise;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.SocketAddress;
import java.nio.channels.ConnectionPendingException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ProxyHandler extends ChannelDuplexHandler {
    static final String AUTH_NONE = "none";
    private static final long DEFAULT_CONNECT_TIMEOUT_MILLIS = 10000;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) ProxyHandler.class);
    private Future<?> connectTimeoutFuture;
    private volatile ChannelHandlerContext ctx;
    private volatile SocketAddress destinationAddress;
    private boolean finished;
    private boolean flushedPrematurely;
    private PendingWriteQueue pendingWrites;
    private final SocketAddress proxyAddress;
    private boolean suppressChannelReadComplete;
    private volatile long connectTimeoutMillis = DEFAULT_CONNECT_TIMEOUT_MILLIS;
    private final LazyChannelPromise connectPromise = new LazyChannelPromise();
    private final ChannelFutureListener writeListener = new ChannelFutureListener() { // from class: io.netty.handler.proxy.ProxyHandler.1
        @Override // io.netty.util.concurrent.GenericFutureListener
        public void operationComplete(ChannelFuture channelFuture) throws Exception {
            if (channelFuture.isSuccess()) {
                return;
            }
            ProxyHandler.this.setConnectFailure(channelFuture.cause());
        }
    };

    public final class LazyChannelPromise extends DefaultPromise<Channel> {
        private LazyChannelPromise() {
        }

        @Override // io.netty.util.concurrent.DefaultPromise
        public EventExecutor executor() {
            if (ProxyHandler.this.ctx != null) {
                return ProxyHandler.this.ctx.executor();
            }
            throw new IllegalStateException();
        }
    }

    public ProxyHandler(SocketAddress socketAddress) {
        this.proxyAddress = (SocketAddress) ObjectUtil.checkNotNull(socketAddress, "proxyAddress");
    }

    private void addPendingWrite(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) {
        PendingWriteQueue pendingWriteQueue = this.pendingWrites;
        if (pendingWriteQueue == null) {
            pendingWriteQueue = new PendingWriteQueue(channelHandlerContext);
            this.pendingWrites = pendingWriteQueue;
        }
        pendingWriteQueue.add(obj, channelPromise);
    }

    private void cancelConnectTimeoutFuture() {
        Future<?> future = this.connectTimeoutFuture;
        if (future != null) {
            future.cancel(false);
            this.connectTimeoutFuture = null;
        }
    }

    private void failPendingWrites(Throwable th2) {
        PendingWriteQueue pendingWriteQueue = this.pendingWrites;
        if (pendingWriteQueue != null) {
            pendingWriteQueue.removeAndFailAll(th2);
            this.pendingWrites = null;
        }
    }

    private void failPendingWritesAndClose(Throwable th2) {
        failPendingWrites(th2);
        this.connectPromise.tryFailure(th2);
        this.ctx.fireExceptionCaught(th2);
        this.ctx.close();
    }

    private static void readIfNeeded(ChannelHandlerContext channelHandlerContext) {
        if (channelHandlerContext.channel().config().isAutoRead()) {
            return;
        }
        channelHandlerContext.read();
    }

    private boolean safeRemoveDecoder() {
        try {
            removeDecoder(this.ctx);
            return true;
        } catch (Exception e10) {
            logger.warn("Failed to remove proxy decoders:", (Throwable) e10);
            return false;
        }
    }

    private boolean safeRemoveEncoder() {
        try {
            removeEncoder(this.ctx);
            return true;
        } catch (Exception e10) {
            logger.warn("Failed to remove proxy encoders:", (Throwable) e10);
            return false;
        }
    }

    private void sendInitialMessage(ChannelHandlerContext channelHandlerContext) throws Exception {
        long j10 = this.connectTimeoutMillis;
        if (j10 > 0) {
            this.connectTimeoutFuture = channelHandlerContext.executor().schedule(new Runnable() { // from class: io.netty.handler.proxy.ProxyHandler.2
                @Override // java.lang.Runnable
                public void run() {
                    if (ProxyHandler.this.connectPromise.isDone()) {
                        return;
                    }
                    ProxyHandler.this.setConnectFailure(new ProxyConnectException(ProxyHandler.this.exceptionMessage(RtspHeaders.Values.TIMEOUT)));
                }
            }, j10, TimeUnit.MILLISECONDS);
        }
        Object objNewInitialMessage = newInitialMessage(channelHandlerContext);
        if (objNewInitialMessage != null) {
            sendToProxyServer(objNewInitialMessage);
        }
        readIfNeeded(channelHandlerContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setConnectFailure(Throwable th2) {
        this.finished = true;
        cancelConnectTimeoutFuture();
        if (this.connectPromise.isDone()) {
            return;
        }
        if (!(th2 instanceof ProxyConnectException)) {
            th2 = new ProxyConnectException(exceptionMessage(th2.toString()), th2);
        }
        safeRemoveDecoder();
        safeRemoveEncoder();
        failPendingWritesAndClose(th2);
    }

    private void setConnectSuccess() {
        this.finished = true;
        cancelConnectTimeoutFuture();
        if (this.connectPromise.isDone()) {
            return;
        }
        boolean zSafeRemoveEncoder = safeRemoveEncoder();
        this.ctx.fireUserEventTriggered((Object) new ProxyConnectionEvent(protocol(), authScheme(), this.proxyAddress, this.destinationAddress));
        if (!zSafeRemoveEncoder || !safeRemoveDecoder()) {
            failPendingWritesAndClose(new ProxyConnectException("failed to remove all codec handlers added by the proxy handler; bug?"));
            return;
        }
        writePendingWrites();
        if (this.flushedPrematurely) {
            this.ctx.flush();
        }
        this.connectPromise.trySuccess(this.ctx.channel());
    }

    private void writePendingWrites() {
        PendingWriteQueue pendingWriteQueue = this.pendingWrites;
        if (pendingWriteQueue != null) {
            pendingWriteQueue.removeAndWriteAll();
            this.pendingWrites = null;
        }
    }

    public abstract void addCodec(ChannelHandlerContext channelHandlerContext) throws Exception;

    public abstract String authScheme();

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public final void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception {
        sendInitialMessage(channelHandlerContext);
        channelHandlerContext.fireChannelActive();
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public final void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (this.finished) {
            channelHandlerContext.fireChannelInactive();
        } else {
            setConnectFailure(new ProxyConnectException(exceptionMessage("disconnected")));
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public final void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        if (this.finished) {
            this.suppressChannelReadComplete = false;
            channelHandlerContext.fireChannelRead(obj);
            return;
        }
        this.suppressChannelReadComplete = true;
        try {
            if (handleResponse(channelHandlerContext, obj)) {
                setConnectSuccess();
            }
            ReferenceCountUtil.release(obj);
        } catch (Throwable th2) {
            ReferenceCountUtil.release(obj);
            setConnectFailure(th2);
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public final void channelReadComplete(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (!this.suppressChannelReadComplete) {
            channelHandlerContext.fireChannelReadComplete();
        } else {
            this.suppressChannelReadComplete = false;
            readIfNeeded(channelHandlerContext);
        }
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public final void connect(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) throws Exception {
        if (this.destinationAddress != null) {
            channelPromise.setFailure((Throwable) new ConnectionPendingException());
        } else {
            this.destinationAddress = socketAddress;
            channelHandlerContext.connect(this.proxyAddress, socketAddress2, channelPromise);
        }
    }

    public final Future<Channel> connectFuture() {
        return this.connectPromise;
    }

    public final long connectTimeoutMillis() {
        return this.connectTimeoutMillis;
    }

    public final <T extends SocketAddress> T destinationAddress() {
        return (T) this.destinationAddress;
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
    public final void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th2) throws Exception {
        if (this.finished) {
            channelHandlerContext.fireExceptionCaught(th2);
        } else {
            setConnectFailure(th2);
        }
    }

    public final String exceptionMessage(String str) {
        if (str == null) {
            str = "";
        }
        StringBuilder sb2 = new StringBuilder(str.length() + 128);
        sb2.append(protocol());
        sb2.append(", ");
        sb2.append(authScheme());
        sb2.append(", ");
        sb2.append(this.proxyAddress);
        sb2.append(" => ");
        sb2.append(this.destinationAddress);
        if (!str.isEmpty()) {
            sb2.append(", ");
            sb2.append(str);
        }
        return sb2.toString();
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public final void flush(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (!this.finished) {
            this.flushedPrematurely = true;
        } else {
            writePendingWrites();
            channelHandlerContext.flush();
        }
    }

    public abstract boolean handleResponse(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception;

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public final void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.ctx = channelHandlerContext;
        addCodec(channelHandlerContext);
        if (channelHandlerContext.channel().isActive()) {
            sendInitialMessage(channelHandlerContext);
        }
    }

    public final boolean isConnected() {
        return this.connectPromise.isSuccess();
    }

    public abstract Object newInitialMessage(ChannelHandlerContext channelHandlerContext) throws Exception;

    public abstract String protocol();

    public final <T extends SocketAddress> T proxyAddress() {
        return (T) this.proxyAddress;
    }

    public abstract void removeDecoder(ChannelHandlerContext channelHandlerContext) throws Exception;

    public abstract void removeEncoder(ChannelHandlerContext channelHandlerContext) throws Exception;

    public final void sendToProxyServer(Object obj) {
        this.ctx.writeAndFlush(obj).addListener((GenericFutureListener<? extends Future<? super Void>>) this.writeListener);
    }

    public final void setConnectTimeoutMillis(long j10) {
        if (j10 <= 0) {
            j10 = 0;
        }
        this.connectTimeoutMillis = j10;
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public final void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Exception {
        if (!this.finished) {
            addPendingWrite(channelHandlerContext, obj, channelPromise);
        } else {
            writePendingWrites();
            channelHandlerContext.write(obj, channelPromise);
        }
    }
}
