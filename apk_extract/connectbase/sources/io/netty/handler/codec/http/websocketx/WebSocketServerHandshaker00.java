package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
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
import io.netty.util.internal.logging.InternalLogger;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public class WebSocketServerHandshaker00 extends WebSocketServerHandshaker {
    private static final Pattern BEGINNING_DIGIT = Pattern.compile("[^0-9]");
    private static final Pattern BEGINNING_SPACE = Pattern.compile("[^ ]");

    public WebSocketServerHandshaker00(String str, String str2, int i10) {
        this(str, str2, WebSocketDecoderConfig.newBuilder().maxFramePayloadLength(i10).build());
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker
    public ChannelFuture close(Channel channel, CloseWebSocketFrame closeWebSocketFrame, ChannelPromise channelPromise) {
        return channel.writeAndFlush(closeWebSocketFrame, channelPromise);
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker
    public FullHttpResponse newHandshakeResponse(FullHttpRequest fullHttpRequest, HttpHeaders httpHeaders) {
        HttpMethod httpMethodMethod = fullHttpRequest.method();
        if (!HttpMethod.GET.equals(httpMethodMethod)) {
            throw new WebSocketServerHandshakeException("Invalid WebSocket handshake method: " + httpMethodMethod, fullHttpRequest);
        }
        HttpHeaders httpHeadersHeaders = fullHttpRequest.headers();
        AsciiString asciiString = HttpHeaderNames.CONNECTION;
        AsciiString asciiString2 = HttpHeaderValues.UPGRADE;
        if (httpHeadersHeaders.containsValue(asciiString, asciiString2, true)) {
            AsciiString asciiString3 = HttpHeaderValues.WEBSOCKET;
            HttpHeaders httpHeadersHeaders2 = fullHttpRequest.headers();
            AsciiString asciiString4 = HttpHeaderNames.UPGRADE;
            if (asciiString3.contentEqualsIgnoreCase(httpHeadersHeaders2.get(asciiString4))) {
                HttpHeaders httpHeadersHeaders3 = fullHttpRequest.headers();
                AsciiString asciiString5 = HttpHeaderNames.SEC_WEBSOCKET_KEY1;
                boolean z10 = httpHeadersHeaders3.contains(asciiString5) && fullHttpRequest.headers().contains(HttpHeaderNames.SEC_WEBSOCKET_KEY2);
                String str = fullHttpRequest.headers().get(HttpHeaderNames.ORIGIN);
                if (str == null && !z10) {
                    throw new WebSocketServerHandshakeException("Missing origin header, got only " + fullHttpRequest.headers().names(), fullHttpRequest);
                }
                DefaultFullHttpResponse defaultFullHttpResponse = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, new HttpResponseStatus(101, z10 ? "WebSocket Protocol Handshake" : "Web Socket Protocol Handshake"), fullHttpRequest.content().alloc().buffer(0));
                if (httpHeaders != null) {
                    defaultFullHttpResponse.headers().add(httpHeaders);
                }
                defaultFullHttpResponse.headers().set(asciiString4, asciiString3).set(asciiString, asciiString2);
                if (z10) {
                    defaultFullHttpResponse.headers().add(HttpHeaderNames.SEC_WEBSOCKET_ORIGIN, str);
                    defaultFullHttpResponse.headers().add(HttpHeaderNames.SEC_WEBSOCKET_LOCATION, uri());
                    HttpHeaders httpHeadersHeaders4 = fullHttpRequest.headers();
                    AsciiString asciiString6 = HttpHeaderNames.SEC_WEBSOCKET_PROTOCOL;
                    String str2 = httpHeadersHeaders4.get(asciiString6);
                    if (str2 != null) {
                        String strSelectSubprotocol = selectSubprotocol(str2);
                        if (strSelectSubprotocol == null) {
                            InternalLogger internalLogger = WebSocketServerHandshaker.logger;
                            if (internalLogger.isDebugEnabled()) {
                                internalLogger.debug("Requested subprotocol(s) not supported: {}", str2);
                            }
                        } else {
                            defaultFullHttpResponse.headers().set(asciiString6, strSelectSubprotocol);
                        }
                    }
                    String str3 = fullHttpRequest.headers().get(asciiString5);
                    String str4 = fullHttpRequest.headers().get(HttpHeaderNames.SEC_WEBSOCKET_KEY2);
                    Pattern pattern = BEGINNING_DIGIT;
                    long j10 = Long.parseLong(pattern.matcher(str3).replaceAll(""));
                    Pattern pattern2 = BEGINNING_SPACE;
                    int length = (int) (j10 / ((long) pattern2.matcher(str3).replaceAll("").length()));
                    int i10 = (int) (Long.parseLong(pattern.matcher(str4).replaceAll("")) / ((long) pattern2.matcher(str4).replaceAll("").length()));
                    long j11 = fullHttpRequest.content().readLong();
                    ByteBuf index = Unpooled.wrappedBuffer(new byte[16]).setIndex(0, 0);
                    index.writeInt(length);
                    index.writeInt(i10);
                    index.writeLong(j11);
                    defaultFullHttpResponse.content().writeBytes(WebSocketUtil.md5(index.array()));
                } else {
                    defaultFullHttpResponse.headers().add(HttpHeaderNames.WEBSOCKET_ORIGIN, str);
                    defaultFullHttpResponse.headers().add(HttpHeaderNames.WEBSOCKET_LOCATION, uri());
                    HttpHeaders httpHeadersHeaders5 = fullHttpRequest.headers();
                    AsciiString asciiString7 = HttpHeaderNames.WEBSOCKET_PROTOCOL;
                    String str5 = httpHeadersHeaders5.get(asciiString7);
                    if (str5 != null) {
                        defaultFullHttpResponse.headers().set(asciiString7, selectSubprotocol(str5));
                    }
                }
                return defaultFullHttpResponse;
            }
        }
        throw new WebSocketServerHandshakeException("not a WebSocket handshake request: missing upgrade", fullHttpRequest);
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker
    public WebSocketFrameEncoder newWebSocketEncoder() {
        return new WebSocket00FrameEncoder();
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker
    public WebSocketFrameDecoder newWebsocketDecoder() {
        return new WebSocket00FrameDecoder(decoderConfig());
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker
    public ChannelFuture close(ChannelHandlerContext channelHandlerContext, CloseWebSocketFrame closeWebSocketFrame, ChannelPromise channelPromise) {
        return channelHandlerContext.writeAndFlush(closeWebSocketFrame, channelPromise);
    }

    public WebSocketServerHandshaker00(String str, String str2, WebSocketDecoderConfig webSocketDecoderConfig) {
        super(WebSocketVersion.V00, str, str2, webSocketDecoderConfig);
    }
}
