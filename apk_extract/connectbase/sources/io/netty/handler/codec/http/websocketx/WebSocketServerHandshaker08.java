package io.netty.handler.codec.http.websocketx;

import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.util.AsciiString;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.logging.InternalLogger;

/* JADX INFO: loaded from: classes3.dex */
public class WebSocketServerHandshaker08 extends WebSocketServerHandshaker {
    public static final String WEBSOCKET_08_ACCEPT_GUID = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";

    public WebSocketServerHandshaker08(String str, String str2, boolean z10, int i10) {
        this(str, str2, z10, i10, false);
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker
    public FullHttpResponse newHandshakeResponse(FullHttpRequest fullHttpRequest, HttpHeaders httpHeaders) {
        HttpMethod httpMethodMethod = fullHttpRequest.method();
        if (!HttpMethod.GET.equals(httpMethodMethod)) {
            throw new WebSocketServerHandshakeException("Invalid WebSocket handshake method: " + httpMethodMethod, fullHttpRequest);
        }
        String str = fullHttpRequest.headers().get(HttpHeaderNames.SEC_WEBSOCKET_KEY);
        if (str == null) {
            throw new WebSocketServerHandshakeException("not a WebSocket request: missing key", fullHttpRequest);
        }
        DefaultFullHttpResponse defaultFullHttpResponse = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.SWITCHING_PROTOCOLS, fullHttpRequest.content().alloc().buffer(0));
        if (httpHeaders != null) {
            defaultFullHttpResponse.headers().add(httpHeaders);
        }
        String strBase64 = WebSocketUtil.base64(WebSocketUtil.sha1((((Object) str) + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").getBytes(CharsetUtil.US_ASCII)));
        InternalLogger internalLogger = WebSocketServerHandshaker.logger;
        if (internalLogger.isDebugEnabled()) {
            internalLogger.debug("WebSocket version 08 server handshake key: {}, response: {}", str, strBase64);
        }
        defaultFullHttpResponse.headers().set(HttpHeaderNames.UPGRADE, HttpHeaderValues.WEBSOCKET).set(HttpHeaderNames.CONNECTION, HttpHeaderValues.UPGRADE).set(HttpHeaderNames.SEC_WEBSOCKET_ACCEPT, strBase64);
        HttpHeaders httpHeadersHeaders = fullHttpRequest.headers();
        AsciiString asciiString = HttpHeaderNames.SEC_WEBSOCKET_PROTOCOL;
        String str2 = httpHeadersHeaders.get(asciiString);
        if (str2 != null) {
            String strSelectSubprotocol = selectSubprotocol(str2);
            if (strSelectSubprotocol != null) {
                defaultFullHttpResponse.headers().set(asciiString, strSelectSubprotocol);
            } else if (internalLogger.isDebugEnabled()) {
                internalLogger.debug("Requested subprotocol(s) not supported: {}", str2);
            }
        }
        return defaultFullHttpResponse;
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker
    public WebSocketFrameEncoder newWebSocketEncoder() {
        return new WebSocket08FrameEncoder(false);
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker
    public WebSocketFrameDecoder newWebsocketDecoder() {
        return new WebSocket08FrameDecoder(decoderConfig());
    }

    public WebSocketServerHandshaker08(String str, String str2, boolean z10, int i10, boolean z11) {
        this(str, str2, WebSocketDecoderConfig.newBuilder().allowExtensions(z10).maxFramePayloadLength(i10).allowMaskMismatch(z11).build());
    }

    public WebSocketServerHandshaker08(String str, String str2, WebSocketDecoderConfig webSocketDecoderConfig) {
        super(WebSocketVersion.V08, str, str2, webSocketDecoderConfig);
    }
}
