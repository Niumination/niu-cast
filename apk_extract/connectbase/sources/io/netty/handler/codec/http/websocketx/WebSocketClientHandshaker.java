package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelOutboundInvoker;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.EmptyHttpHeaders;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpClientCodec;
import io.netty.handler.codec.http.HttpContentDecompressor;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpObject;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestEncoder;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.HttpResponseDecoder;
import io.netty.handler.codec.http.HttpScheme;
import io.netty.handler.codec.http.LastHttpContent;
import io.netty.util.AsciiString;
import io.netty.util.NetUtil;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.ScheduledFuture;
import io.netty.util.internal.ObjectUtil;
import j.a;
import java.net.URI;
import java.nio.channels.ClosedChannelException;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import ks.g;

/* JADX INFO: loaded from: classes3.dex */
public abstract class WebSocketClientHandshaker {
    protected static final int DEFAULT_FORCE_CLOSE_TIMEOUT_MILLIS = 10000;
    private final boolean absoluteUpgradeUrl;
    private volatile String actualSubprotocol;
    protected final HttpHeaders customHeaders;
    private final String expectedSubprotocol;
    private volatile boolean forceCloseComplete;
    private volatile int forceCloseInit;
    private volatile long forceCloseTimeoutMillis;
    protected final boolean generateOriginHeader;
    private volatile boolean handshakeComplete;
    private final int maxFramePayloadLength;
    private final URI uri;
    private final WebSocketVersion version;
    private static final String HTTP_SCHEME_PREFIX = HttpScheme.HTTP + "://";
    private static final String HTTPS_SCHEME_PREFIX = HttpScheme.HTTPS + "://";
    private static final AtomicIntegerFieldUpdater<WebSocketClientHandshaker> FORCE_CLOSE_INIT_UPDATER = AtomicIntegerFieldUpdater.newUpdater(WebSocketClientHandshaker.class, "forceCloseInit");

    public WebSocketClientHandshaker(URI uri, WebSocketVersion webSocketVersion, String str, HttpHeaders httpHeaders, int i10) {
        this(uri, webSocketVersion, str, httpHeaders, i10, 10000L);
    }

    private ChannelFuture close0(final ChannelOutboundInvoker channelOutboundInvoker, final Channel channel, CloseWebSocketFrame closeWebSocketFrame, ChannelPromise channelPromise) {
        channelOutboundInvoker.writeAndFlush(closeWebSocketFrame, channelPromise);
        final long j10 = this.forceCloseTimeoutMillis;
        if (j10 > 0 && channel.isActive() && this.forceCloseInit == 0) {
            channelPromise.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.codec.http.websocketx.WebSocketClientHandshaker.5
                @Override // io.netty.util.concurrent.GenericFutureListener
                public void operationComplete(ChannelFuture channelFuture) {
                    if (channelFuture.isSuccess() && channel.isActive() && WebSocketClientHandshaker.FORCE_CLOSE_INIT_UPDATER.compareAndSet(this, 0, 1)) {
                        final ScheduledFuture<?> scheduledFutureSchedule = channel.eventLoop().schedule(new Runnable() { // from class: io.netty.handler.codec.http.websocketx.WebSocketClientHandshaker.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (channel.isActive()) {
                                    channelOutboundInvoker.close();
                                    WebSocketClientHandshaker.this.forceCloseComplete = true;
                                }
                            }
                        }, j10, TimeUnit.MILLISECONDS);
                        channel.closeFuture().addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.codec.http.websocketx.WebSocketClientHandshaker.5.2
                            @Override // io.netty.util.concurrent.GenericFutureListener
                            public void operationComplete(ChannelFuture channelFuture2) throws Exception {
                                scheduledFutureSchedule.cancel(false);
                            }
                        });
                    }
                }
            });
        }
        return channelPromise;
    }

    private void setActualSubprotocol(String str) {
        this.actualSubprotocol = str;
    }

    private void setHandshakeComplete() {
        this.handshakeComplete = true;
    }

    public static CharSequence websocketHostValue(URI uri) {
        int port = uri.getPort();
        if (port == -1) {
            return uri.getHost();
        }
        String host = uri.getHost();
        String scheme = uri.getScheme();
        HttpScheme httpScheme = HttpScheme.HTTP;
        if (port == httpScheme.port()) {
            return (httpScheme.name().contentEquals(scheme) || WebSocketScheme.WS.name().contentEquals(scheme)) ? host : NetUtil.toSocketAddressString(host, port);
        }
        HttpScheme httpScheme2 = HttpScheme.HTTPS;
        if (port == httpScheme2.port()) {
            return (httpScheme2.name().contentEquals(scheme) || WebSocketScheme.WSS.name().contentEquals(scheme)) ? host : NetUtil.toSocketAddressString(host, port);
        }
        return NetUtil.toSocketAddressString(host, port);
    }

    public static CharSequence websocketOriginValue(URI uri) {
        String str;
        int iPort;
        String scheme = uri.getScheme();
        int port = uri.getPort();
        WebSocketScheme webSocketScheme = WebSocketScheme.WSS;
        if (webSocketScheme.name().contentEquals(scheme) || HttpScheme.HTTPS.name().contentEquals(scheme) || (scheme == null && port == webSocketScheme.port())) {
            str = HTTPS_SCHEME_PREFIX;
            iPort = webSocketScheme.port();
        } else {
            str = HTTP_SCHEME_PREFIX;
            iPort = WebSocketScheme.WS.port();
        }
        String lowerCase = uri.getHost().toLowerCase(Locale.US);
        if (port == iPort || port == -1) {
            return a.a(str, lowerCase);
        }
        StringBuilder sbA = k.a.a(str);
        sbA.append(NetUtil.toSocketAddressString(lowerCase, port));
        return sbA.toString();
    }

    public String actualSubprotocol() {
        return this.actualSubprotocol;
    }

    public ChannelFuture close(Channel channel, CloseWebSocketFrame closeWebSocketFrame) {
        ObjectUtil.checkNotNull(channel, "channel");
        return close(channel, closeWebSocketFrame, channel.newPromise());
    }

    public String expectedSubprotocol() {
        return this.expectedSubprotocol;
    }

    public final void finishHandshake(Channel channel, FullHttpResponse fullHttpResponse) {
        verify(fullHttpResponse);
        String str = fullHttpResponse.headers().get(HttpHeaderNames.SEC_WEBSOCKET_PROTOCOL);
        String strTrim = str != null ? str.trim() : null;
        String str2 = this.expectedSubprotocol;
        if (str2 == null) {
            str2 = "";
        }
        if (!str2.isEmpty() || strTrim != null) {
            if (!str2.isEmpty() && strTrim != null && !strTrim.isEmpty()) {
                String[] strArrSplit = str2.split(g.f9491d);
                int length = strArrSplit.length;
                int i10 = 0;
                while (true) {
                    if (i10 < length) {
                        if (strArrSplit[i10].trim().equals(strTrim)) {
                            setActualSubprotocol(strTrim);
                            break;
                        }
                        i10++;
                    }
                }
            }
            throw new WebSocketClientHandshakeException(String.format("Invalid subprotocol. Actual: %s. Expected one of: %s", strTrim, this.expectedSubprotocol), fullHttpResponse);
        }
        setActualSubprotocol(this.expectedSubprotocol);
        setHandshakeComplete();
        final ChannelPipeline channelPipelinePipeline = channel.pipeline();
        HttpContentDecompressor httpContentDecompressor = (HttpContentDecompressor) channelPipelinePipeline.get(HttpContentDecompressor.class);
        if (httpContentDecompressor != null) {
            channelPipelinePipeline.remove(httpContentDecompressor);
        }
        HttpObjectAggregator httpObjectAggregator = (HttpObjectAggregator) channelPipelinePipeline.get(HttpObjectAggregator.class);
        if (httpObjectAggregator != null) {
            channelPipelinePipeline.remove(httpObjectAggregator);
        }
        final ChannelHandlerContext channelHandlerContextContext = channelPipelinePipeline.context(HttpResponseDecoder.class);
        if (channelHandlerContextContext != null) {
            if (channelPipelinePipeline.get(HttpRequestEncoder.class) != null) {
                channelPipelinePipeline.remove(HttpRequestEncoder.class);
            }
            channelPipelinePipeline.addAfter(channelHandlerContextContext.name(), "ws-decoder", newWebsocketDecoder());
            channel.eventLoop().execute(new Runnable() { // from class: io.netty.handler.codec.http.websocketx.WebSocketClientHandshaker.3
                @Override // java.lang.Runnable
                public void run() {
                    channelPipelinePipeline.remove(channelHandlerContextContext.handler());
                }
            });
            return;
        }
        ChannelHandlerContext channelHandlerContextContext2 = channelPipelinePipeline.context(HttpClientCodec.class);
        if (channelHandlerContextContext2 == null) {
            throw new IllegalStateException("ChannelPipeline does not contain an HttpRequestEncoder or HttpClientCodec");
        }
        final HttpClientCodec httpClientCodec = (HttpClientCodec) channelHandlerContextContext2.handler();
        httpClientCodec.removeOutboundHandler();
        channelPipelinePipeline.addAfter(channelHandlerContextContext2.name(), "ws-decoder", newWebsocketDecoder());
        channel.eventLoop().execute(new Runnable() { // from class: io.netty.handler.codec.http.websocketx.WebSocketClientHandshaker.2
            @Override // java.lang.Runnable
            public void run() {
                channelPipelinePipeline.remove(httpClientCodec);
            }
        });
    }

    public long forceCloseTimeoutMillis() {
        return this.forceCloseTimeoutMillis;
    }

    public ChannelFuture handshake(Channel channel) {
        ObjectUtil.checkNotNull(channel, "channel");
        return handshake(channel, channel.newPromise());
    }

    public boolean isForceCloseComplete() {
        return this.forceCloseComplete;
    }

    public boolean isHandshakeComplete() {
        return this.handshakeComplete;
    }

    public int maxFramePayloadLength() {
        return this.maxFramePayloadLength;
    }

    public abstract FullHttpRequest newHandshakeRequest();

    public abstract WebSocketFrameEncoder newWebSocketEncoder();

    public abstract WebSocketFrameDecoder newWebsocketDecoder();

    public final ChannelFuture processHandshake(Channel channel, HttpResponse httpResponse) {
        return processHandshake(channel, httpResponse, channel.newPromise());
    }

    public WebSocketClientHandshaker setForceCloseTimeoutMillis(long j10) {
        this.forceCloseTimeoutMillis = j10;
        return this;
    }

    public String upgradeUrl(URI uri) {
        if (this.absoluteUpgradeUrl) {
            return uri.toString();
        }
        String rawPath = uri.getRawPath();
        if (rawPath == null || rawPath.isEmpty()) {
            rawPath = "/";
        }
        String rawQuery = uri.getRawQuery();
        if (rawQuery == null || rawQuery.isEmpty()) {
            return rawPath;
        }
        return rawPath + '?' + rawQuery;
    }

    public URI uri() {
        return this.uri;
    }

    public abstract void verify(FullHttpResponse fullHttpResponse);

    public WebSocketVersion version() {
        return this.version;
    }

    public WebSocketClientHandshaker(URI uri, WebSocketVersion webSocketVersion, String str, HttpHeaders httpHeaders, int i10, long j10) {
        this(uri, webSocketVersion, str, httpHeaders, i10, j10, false);
    }

    public final ChannelFuture processHandshake(final Channel channel, HttpResponse httpResponse, final ChannelPromise channelPromise) {
        if (httpResponse instanceof FullHttpResponse) {
            try {
                finishHandshake(channel, (FullHttpResponse) httpResponse);
                channelPromise.setSuccess();
            } catch (Throwable th2) {
                channelPromise.setFailure(th2);
            }
        } else {
            ChannelPipeline channelPipelinePipeline = channel.pipeline();
            ChannelHandlerContext channelHandlerContextContext = channelPipelinePipeline.context(HttpResponseDecoder.class);
            if (channelHandlerContextContext == null && (channelHandlerContextContext = channelPipelinePipeline.context(HttpClientCodec.class)) == null) {
                return channelPromise.setFailure((Throwable) new IllegalStateException("ChannelPipeline does not contain an HttpResponseDecoder or HttpClientCodec"));
            }
            String strName = channelHandlerContextContext.name();
            if (this.version == WebSocketVersion.V00) {
                channelPipelinePipeline.addAfter(channelHandlerContextContext.name(), "httpAggregator", new HttpObjectAggregator(8192));
                strName = "httpAggregator";
            }
            channelPipelinePipeline.addAfter(strName, "handshaker", new ChannelInboundHandlerAdapter() { // from class: io.netty.handler.codec.http.websocketx.WebSocketClientHandshaker.4
                static final /* synthetic */ boolean $assertionsDisabled = false;
                private FullHttpResponse fullHttpResponse;

                private void handleHandshakeResponse(ChannelHandlerContext channelHandlerContext, HttpObject httpObject) {
                    if (httpObject instanceof FullHttpResponse) {
                        channelHandlerContext.pipeline().remove(this);
                        tryFinishHandshake((FullHttpResponse) httpObject);
                        return;
                    }
                    if (httpObject instanceof LastHttpContent) {
                        FullHttpResponse fullHttpResponse = this.fullHttpResponse;
                        this.fullHttpResponse = null;
                        try {
                            channelHandlerContext.pipeline().remove(this);
                            tryFinishHandshake(fullHttpResponse);
                            return;
                        } finally {
                            fullHttpResponse.release();
                        }
                    }
                    if (httpObject instanceof HttpResponse) {
                        HttpResponse httpResponse2 = (HttpResponse) httpObject;
                        this.fullHttpResponse = new DefaultFullHttpResponse(httpResponse2.protocolVersion(), httpResponse2.status(), Unpooled.EMPTY_BUFFER, httpResponse2.headers(), EmptyHttpHeaders.INSTANCE);
                        if (httpResponse2.decoderResult().isFailure()) {
                            this.fullHttpResponse.setDecoderResult(httpResponse2.decoderResult());
                        }
                    }
                }

                private void releaseFullHttpResponse() {
                    FullHttpResponse fullHttpResponse = this.fullHttpResponse;
                    if (fullHttpResponse != null) {
                        fullHttpResponse.release();
                        this.fullHttpResponse = null;
                    }
                }

                private void tryFinishHandshake(FullHttpResponse fullHttpResponse) {
                    try {
                        WebSocketClientHandshaker.this.finishHandshake(channel, fullHttpResponse);
                        channelPromise.setSuccess();
                    } catch (Throwable th3) {
                        channelPromise.setFailure(th3);
                    }
                }

                @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
                public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
                    try {
                        if (!channelPromise.isDone()) {
                            channelPromise.tryFailure(new ClosedChannelException());
                        }
                        channelHandlerContext.fireChannelInactive();
                    } finally {
                        releaseFullHttpResponse();
                    }
                }

                @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
                public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
                    if (!(obj instanceof HttpObject)) {
                        super.channelRead(channelHandlerContext, obj);
                        return;
                    }
                    try {
                        handleHandshakeResponse(channelHandlerContext, (HttpObject) obj);
                    } finally {
                        ReferenceCountUtil.release(obj);
                    }
                }

                @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
                public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th3) throws Exception {
                    channelHandlerContext.pipeline().remove(this);
                    channelPromise.setFailure(th3);
                }

                @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
                public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
                    releaseFullHttpResponse();
                }
            });
            try {
                channelHandlerContextContext.fireChannelRead(ReferenceCountUtil.retain(httpResponse));
            } catch (Throwable th3) {
                channelPromise.setFailure(th3);
            }
        }
        return channelPromise;
    }

    public WebSocketClientHandshaker(URI uri, WebSocketVersion webSocketVersion, String str, HttpHeaders httpHeaders, int i10, long j10, boolean z10) {
        this(uri, webSocketVersion, str, httpHeaders, i10, j10, z10, true);
    }

    public ChannelFuture close(Channel channel, CloseWebSocketFrame closeWebSocketFrame, ChannelPromise channelPromise) {
        ObjectUtil.checkNotNull(channel, "channel");
        return close0(channel, channel, closeWebSocketFrame, channelPromise);
    }

    public final ChannelFuture handshake(Channel channel, final ChannelPromise channelPromise) {
        String string;
        ChannelPipeline channelPipelinePipeline = channel.pipeline();
        if (((HttpResponseDecoder) channelPipelinePipeline.get(HttpResponseDecoder.class)) == null && ((HttpClientCodec) channelPipelinePipeline.get(HttpClientCodec.class)) == null) {
            channelPromise.setFailure((Throwable) new IllegalStateException("ChannelPipeline does not contain an HttpResponseDecoder or HttpClientCodec"));
            return channelPromise;
        }
        if (this.uri.getHost() == null) {
            HttpHeaders httpHeaders = this.customHeaders;
            if (httpHeaders != null && httpHeaders.contains(HttpHeaderNames.HOST)) {
                if (this.generateOriginHeader) {
                    HttpHeaders httpHeaders2 = this.customHeaders;
                    AsciiString asciiString = HttpHeaderNames.ORIGIN;
                    if (!httpHeaders2.contains(asciiString)) {
                        WebSocketVersion webSocketVersion = this.version;
                        if (webSocketVersion != WebSocketVersion.V07 && webSocketVersion != WebSocketVersion.V08) {
                            string = asciiString.toString();
                        } else {
                            string = HttpHeaderNames.SEC_WEBSOCKET_ORIGIN.toString();
                        }
                        channelPromise.setFailure((Throwable) new IllegalArgumentException(n.a.a("Cannot generate the '", string, "' header value, webSocketURI should contain host or disable generateOriginHeader or pass value through customHeaders")));
                        return channelPromise;
                    }
                }
            } else {
                channelPromise.setFailure((Throwable) new IllegalArgumentException("Cannot generate the 'host' header value, webSocketURI should contain host or passed through customHeaders"));
                return channelPromise;
            }
        }
        channel.writeAndFlush(newHandshakeRequest()).addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.codec.http.websocketx.WebSocketClientHandshaker.1
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(ChannelFuture channelFuture) {
                if (!channelFuture.isSuccess()) {
                    channelPromise.setFailure(channelFuture.cause());
                    return;
                }
                ChannelPipeline channelPipelinePipeline2 = channelFuture.channel().pipeline();
                ChannelHandlerContext channelHandlerContextContext = channelPipelinePipeline2.context(HttpRequestEncoder.class);
                if (channelHandlerContextContext == null) {
                    channelHandlerContextContext = channelPipelinePipeline2.context(HttpClientCodec.class);
                }
                if (channelHandlerContextContext == null) {
                    channelPromise.setFailure((Throwable) new IllegalStateException("ChannelPipeline does not contain an HttpRequestEncoder or HttpClientCodec"));
                } else {
                    channelPipelinePipeline2.addAfter(channelHandlerContextContext.name(), "ws-encoder", WebSocketClientHandshaker.this.newWebSocketEncoder());
                    channelPromise.setSuccess();
                }
            }
        });
        return channelPromise;
    }

    public WebSocketClientHandshaker(URI uri, WebSocketVersion webSocketVersion, String str, HttpHeaders httpHeaders, int i10, long j10, boolean z10, boolean z11) {
        this.forceCloseTimeoutMillis = 10000L;
        this.uri = uri;
        this.version = webSocketVersion;
        this.expectedSubprotocol = str;
        this.customHeaders = httpHeaders;
        this.maxFramePayloadLength = i10;
        this.forceCloseTimeoutMillis = j10;
        this.absoluteUpgradeUrl = z10;
        this.generateOriginHeader = z11;
    }

    public ChannelFuture close(ChannelHandlerContext channelHandlerContext, CloseWebSocketFrame closeWebSocketFrame) {
        ObjectUtil.checkNotNull(channelHandlerContext, "ctx");
        return close(channelHandlerContext, closeWebSocketFrame, channelHandlerContext.newPromise());
    }

    public ChannelFuture close(ChannelHandlerContext channelHandlerContext, CloseWebSocketFrame closeWebSocketFrame, ChannelPromise channelPromise) {
        ObjectUtil.checkNotNull(channelHandlerContext, "ctx");
        return close0(channelHandlerContext, channelHandlerContext.channel(), closeWebSocketFrame, channelPromise);
    }
}
