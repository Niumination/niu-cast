package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.util.AttributeKey;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.ObjectUtil;
import java.net.SocketAddress;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class WebSocketServerProtocolHandler extends WebSocketProtocolHandler {
    private static final AttributeKey<WebSocketServerHandshaker> HANDSHAKER_ATTR_KEY = AttributeKey.valueOf(WebSocketServerHandshaker.class, "HANDSHAKER");
    private final WebSocketServerProtocolConfig serverConfig;

    public static final class HandshakeComplete {
        private final HttpHeaders requestHeaders;
        private final String requestUri;
        private final String selectedSubprotocol;

        public HandshakeComplete(String str, HttpHeaders httpHeaders, String str2) {
            this.requestUri = str;
            this.requestHeaders = httpHeaders;
            this.selectedSubprotocol = str2;
        }

        public HttpHeaders requestHeaders() {
            return this.requestHeaders;
        }

        public String requestUri() {
            return this.requestUri;
        }

        public String selectedSubprotocol() {
            return this.selectedSubprotocol;
        }
    }

    public enum ServerHandshakeStateEvent {
        HANDSHAKE_COMPLETE,
        HANDSHAKE_TIMEOUT
    }

    public WebSocketServerProtocolHandler(WebSocketServerProtocolConfig webSocketServerProtocolConfig) {
        super(((WebSocketServerProtocolConfig) ObjectUtil.checkNotNull(webSocketServerProtocolConfig, "serverConfig")).dropPongFrames(), webSocketServerProtocolConfig.sendCloseFrame(), webSocketServerProtocolConfig.forceCloseTimeoutMillis());
        this.serverConfig = webSocketServerProtocolConfig;
    }

    public static WebSocketServerHandshaker getHandshaker(Channel channel) {
        return (WebSocketServerHandshaker) channel.attr(HANDSHAKER_ATTR_KEY).get();
    }

    public static void setHandshaker(Channel channel, WebSocketServerHandshaker webSocketServerHandshaker) {
        channel.attr(HANDSHAKER_ATTR_KEY).set(webSocketServerHandshaker);
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketProtocolHandler, io.netty.channel.ChannelOutboundHandler
    public /* bridge */ /* synthetic */ void bind(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, ChannelPromise channelPromise) throws Exception {
        super.bind(channelHandlerContext, socketAddress, channelPromise);
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketProtocolHandler, io.netty.channel.ChannelOutboundHandler
    public /* bridge */ /* synthetic */ void close(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        super.close(channelHandlerContext, channelPromise);
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketProtocolHandler, io.netty.channel.ChannelOutboundHandler
    public /* bridge */ /* synthetic */ void connect(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) throws Exception {
        super.connect(channelHandlerContext, socketAddress, socketAddress2, channelPromise);
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketProtocolHandler, io.netty.handler.codec.MessageToMessageDecoder
    public /* bridge */ /* synthetic */ void decode(ChannelHandlerContext channelHandlerContext, WebSocketFrame webSocketFrame, List list) throws Exception {
        decode(channelHandlerContext, webSocketFrame, (List<Object>) list);
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketProtocolHandler, io.netty.channel.ChannelOutboundHandler
    public /* bridge */ /* synthetic */ void deregister(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        super.deregister(channelHandlerContext, channelPromise);
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketProtocolHandler, io.netty.channel.ChannelOutboundHandler
    public /* bridge */ /* synthetic */ void disconnect(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        super.disconnect(channelHandlerContext, channelPromise);
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketProtocolHandler, io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th2) throws Exception {
        if (th2 instanceof WebSocketHandshakeException) {
            channelHandlerContext.channel().writeAndFlush(new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.BAD_REQUEST, Unpooled.wrappedBuffer(th2.getMessage().getBytes()))).addListener((GenericFutureListener<? extends Future<? super Void>>) ChannelFutureListener.CLOSE);
        } else {
            channelHandlerContext.fireExceptionCaught(th2);
            channelHandlerContext.close();
        }
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketProtocolHandler, io.netty.channel.ChannelOutboundHandler
    public /* bridge */ /* synthetic */ void flush(ChannelHandlerContext channelHandlerContext) throws Exception {
        super.flush(channelHandlerContext);
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) {
        ChannelPipeline channelPipelinePipeline = channelHandlerContext.pipeline();
        if (channelPipelinePipeline.get(WebSocketServerProtocolHandshakeHandler.class) == null) {
            channelPipelinePipeline.addBefore(channelHandlerContext.name(), WebSocketServerProtocolHandshakeHandler.class.getName(), new WebSocketServerProtocolHandshakeHandler(this.serverConfig));
        }
        if (this.serverConfig.decoderConfig().withUTF8Validator() && channelPipelinePipeline.get(Utf8FrameValidator.class) == null) {
            channelPipelinePipeline.addBefore(channelHandlerContext.name(), Utf8FrameValidator.class.getName(), new Utf8FrameValidator(this.serverConfig.decoderConfig().closeOnProtocolViolation()));
        }
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketProtocolHandler, io.netty.channel.ChannelOutboundHandler
    public /* bridge */ /* synthetic */ void read(ChannelHandlerContext channelHandlerContext) throws Exception {
        super.read(channelHandlerContext);
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketProtocolHandler, io.netty.channel.ChannelOutboundHandler
    public /* bridge */ /* synthetic */ void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Exception {
        super.write(channelHandlerContext, obj, channelPromise);
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketProtocolHandler
    public WebSocketServerHandshakeException buildHandshakeException(String str) {
        return new WebSocketServerHandshakeException(str);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.netty.handler.codec.http.websocketx.WebSocketProtocolHandler
    public void decode(ChannelHandlerContext channelHandlerContext, WebSocketFrame webSocketFrame, List<Object> list) throws Exception {
        if (!this.serverConfig.handleCloseFrames() || !(webSocketFrame instanceof CloseWebSocketFrame)) {
            super.decode(channelHandlerContext, webSocketFrame, list);
            return;
        }
        WebSocketServerHandshaker handshaker = getHandshaker(channelHandlerContext.channel());
        if (handshaker == null) {
            channelHandlerContext.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener((GenericFutureListener<? extends Future<? super Void>>) ChannelFutureListener.CLOSE);
            return;
        }
        webSocketFrame.retain();
        ChannelPromise channelPromiseNewPromise = channelHandlerContext.newPromise();
        closeSent(channelPromiseNewPromise);
        handshaker.close(channelHandlerContext, (CloseWebSocketFrame) webSocketFrame, channelPromiseNewPromise);
    }

    public WebSocketServerProtocolHandler(String str) {
        this(str, 10000L);
    }

    public WebSocketServerProtocolHandler(String str, long j10) {
        this(str, false, j10);
    }

    public WebSocketServerProtocolHandler(String str, boolean z10) {
        this(str, z10, 10000L);
    }

    public WebSocketServerProtocolHandler(String str, boolean z10, long j10) {
        this(str, (String) null, false, 65536, false, z10, j10);
    }

    public WebSocketServerProtocolHandler(String str, String str2) {
        this(str, str2, 10000L);
    }

    public WebSocketServerProtocolHandler(String str, String str2, long j10) {
        this(str, str2, false, j10);
    }

    public WebSocketServerProtocolHandler(String str, String str2, boolean z10) {
        this(str, str2, z10, 10000L);
    }

    public WebSocketServerProtocolHandler(String str, String str2, boolean z10, long j10) {
        this(str, str2, z10, 65536, j10);
    }

    public WebSocketServerProtocolHandler(String str, String str2, boolean z10, int i10) {
        this(str, str2, z10, i10, 10000L);
    }

    public WebSocketServerProtocolHandler(String str, String str2, boolean z10, int i10, long j10) {
        this(str, str2, z10, i10, false, j10);
    }

    public WebSocketServerProtocolHandler(String str, String str2, boolean z10, int i10, boolean z11) {
        this(str, str2, z10, i10, z11, 10000L);
    }

    public WebSocketServerProtocolHandler(String str, String str2, boolean z10, int i10, boolean z11, long j10) {
        this(str, str2, z10, i10, z11, false, j10);
    }

    public WebSocketServerProtocolHandler(String str, String str2, boolean z10, int i10, boolean z11, boolean z12) {
        this(str, str2, z10, i10, z11, z12, 10000L);
    }

    public WebSocketServerProtocolHandler(String str, String str2, boolean z10, int i10, boolean z11, boolean z12, long j10) {
        this(str, str2, z10, i10, z11, z12, true, j10);
    }

    public WebSocketServerProtocolHandler(String str, String str2, boolean z10, int i10, boolean z11, boolean z12, boolean z13) {
        this(str, str2, z10, i10, z11, z12, z13, 10000L);
    }

    public WebSocketServerProtocolHandler(String str, String str2, boolean z10, int i10, boolean z11, boolean z12, boolean z13, long j10) {
        this(str, str2, z12, z13, j10, WebSocketDecoderConfig.newBuilder().maxFramePayloadLength(i10).allowMaskMismatch(z11).allowExtensions(z10).build());
    }

    public WebSocketServerProtocolHandler(String str, String str2, boolean z10, boolean z11, long j10, WebSocketDecoderConfig webSocketDecoderConfig) {
        this(WebSocketServerProtocolConfig.newBuilder().websocketPath(str).subprotocols(str2).checkStartsWith(z10).handshakeTimeoutMillis(j10).dropPongFrames(z11).decoderConfig(webSocketDecoderConfig).build());
    }
}
