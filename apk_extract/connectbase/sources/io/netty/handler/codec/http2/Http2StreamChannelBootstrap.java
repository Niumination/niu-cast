package io.netty.handler.codec.http2;

import cb.b;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.util.AttributeKey;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.channels.ClosedChannelException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class Http2StreamChannelBootstrap {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Channel channel;
    private volatile ChannelHandler handler;
    private volatile ChannelHandlerContext multiplexCtx;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) Http2StreamChannelBootstrap.class);
    private static final Map.Entry<ChannelOption<?>, Object>[] EMPTY_OPTION_ARRAY = new Map.Entry[0];
    private static final Map.Entry<AttributeKey<?>, Object>[] EMPTY_ATTRIBUTE_ARRAY = new Map.Entry[0];
    private final Map<ChannelOption<?>, Object> options = new LinkedHashMap();
    private final Map<AttributeKey<?>, Object> attrs = new ConcurrentHashMap();

    public Http2StreamChannelBootstrap(Channel channel) {
        this.channel = (Channel) ObjectUtil.checkNotNull(channel, "channel");
    }

    private ChannelHandlerContext findCtx() throws ClosedChannelException {
        ChannelHandlerContext channelHandlerContext = this.multiplexCtx;
        if (channelHandlerContext != null && !channelHandlerContext.isRemoved()) {
            return channelHandlerContext;
        }
        ChannelPipeline channelPipelinePipeline = this.channel.pipeline();
        ChannelHandlerContext channelHandlerContextContext = channelPipelinePipeline.context(Http2MultiplexCodec.class);
        if (channelHandlerContextContext == null) {
            channelHandlerContextContext = channelPipelinePipeline.context(Http2MultiplexHandler.class);
        }
        if (channelHandlerContextContext != null) {
            this.multiplexCtx = channelHandlerContextContext;
            return channelHandlerContextContext;
        }
        if (!this.channel.isActive()) {
            throw new ClosedChannelException();
        }
        throw new IllegalStateException(StringUtil.simpleClassName((Class<?>) Http2MultiplexCodec.class) + " or " + StringUtil.simpleClassName((Class<?>) Http2MultiplexHandler.class) + " must be in the ChannelPipeline of Channel " + this.channel);
    }

    private void init(Channel channel) {
        Map.Entry[] entryArr;
        ChannelPipeline channelPipelinePipeline = channel.pipeline();
        ChannelHandler channelHandler = this.handler;
        if (channelHandler != null) {
            channelPipelinePipeline.addLast(channelHandler);
        }
        synchronized (this.options) {
            entryArr = (Map.Entry[]) this.options.entrySet().toArray(EMPTY_OPTION_ARRAY);
        }
        setChannelOptions(channel, entryArr);
        setAttributes(channel, (Map.Entry[]) this.attrs.entrySet().toArray(EMPTY_ATTRIBUTE_ARRAY));
    }

    private static void setAttributes(Channel channel, Map.Entry<AttributeKey<?>, Object>[] entryArr) {
        for (Map.Entry<AttributeKey<?>, Object> entry : entryArr) {
            channel.attr(entry.getKey()).set(entry.getValue());
        }
    }

    private static void setChannelOption(Channel channel, ChannelOption<?> channelOption, Object obj) {
        try {
            if (channel.config().setOption(channelOption, obj)) {
                return;
            }
            logger.warn("Unknown channel option '{}' for channel '{}'", channelOption, channel);
        } catch (Throwable th2) {
            logger.warn("Failed to set channel option '{}' with value '{}' for channel '{}'", channelOption, obj, channel, th2);
        }
    }

    private static void setChannelOptions(Channel channel, Map.Entry<ChannelOption<?>, Object>[] entryArr) {
        for (Map.Entry<ChannelOption<?>, Object> entry : entryArr) {
            setChannelOption(channel, entry.getKey(), entry.getValue());
        }
    }

    public <T> Http2StreamChannelBootstrap attr(AttributeKey<T> attributeKey, T t10) {
        ObjectUtil.checkNotNull(attributeKey, b.c.f1408o);
        if (t10 == null) {
            this.attrs.remove(attributeKey);
        } else {
            this.attrs.put(attributeKey, t10);
        }
        return this;
    }

    public Http2StreamChannelBootstrap handler(ChannelHandler channelHandler) {
        this.handler = (ChannelHandler) ObjectUtil.checkNotNull(channelHandler, "handler");
        return this;
    }

    public Future<Http2StreamChannel> open() {
        return open(this.channel.eventLoop().newPromise());
    }

    @Deprecated
    public void open0(ChannelHandlerContext channelHandlerContext, final Promise<Http2StreamChannel> promise) {
        if (promise.setUncancellable()) {
            try {
                final Http2StreamChannel http2StreamChannelNewOutboundStream = channelHandlerContext.handler() instanceof Http2MultiplexCodec ? ((Http2MultiplexCodec) channelHandlerContext.handler()).newOutboundStream() : ((Http2MultiplexHandler) channelHandlerContext.handler()).newOutboundStream();
                try {
                    init(http2StreamChannelNewOutboundStream);
                    channelHandlerContext.channel().eventLoop().register(http2StreamChannelNewOutboundStream).addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.codec.http2.Http2StreamChannelBootstrap.2
                        @Override // io.netty.util.concurrent.GenericFutureListener
                        public void operationComplete(ChannelFuture channelFuture) {
                            if (channelFuture.isSuccess()) {
                                promise.setSuccess(http2StreamChannelNewOutboundStream);
                                return;
                            }
                            if (channelFuture.isCancelled()) {
                                promise.cancel(false);
                                return;
                            }
                            if (http2StreamChannelNewOutboundStream.isRegistered()) {
                                http2StreamChannelNewOutboundStream.close();
                            } else {
                                http2StreamChannelNewOutboundStream.unsafe().closeForcibly();
                            }
                            promise.setFailure(channelFuture.cause());
                        }
                    });
                } catch (Exception e10) {
                    http2StreamChannelNewOutboundStream.unsafe().closeForcibly();
                    promise.setFailure(e10);
                }
            } catch (Exception e11) {
                promise.setFailure(e11);
            }
        }
    }

    public <T> Http2StreamChannelBootstrap option(ChannelOption<T> channelOption, T t10) {
        ObjectUtil.checkNotNull(channelOption, "option");
        synchronized (this.options) {
            try {
                if (t10 == null) {
                    this.options.remove(channelOption);
                } else {
                    this.options.put(channelOption, t10);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return this;
    }

    public Future<Http2StreamChannel> open(final Promise<Http2StreamChannel> promise) {
        try {
            final ChannelHandlerContext channelHandlerContextFindCtx = findCtx();
            EventExecutor eventExecutorExecutor = channelHandlerContextFindCtx.executor();
            if (eventExecutorExecutor.inEventLoop()) {
                open0(channelHandlerContextFindCtx, promise);
            } else {
                eventExecutorExecutor.execute(new Runnable() { // from class: io.netty.handler.codec.http2.Http2StreamChannelBootstrap.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (Http2StreamChannelBootstrap.this.channel.isActive()) {
                            Http2StreamChannelBootstrap.this.open0(channelHandlerContextFindCtx, promise);
                        } else {
                            promise.setFailure(new ClosedChannelException());
                        }
                    }
                });
            }
        } catch (Throwable th2) {
            promise.setFailure(th2);
        }
        return promise;
    }
}
