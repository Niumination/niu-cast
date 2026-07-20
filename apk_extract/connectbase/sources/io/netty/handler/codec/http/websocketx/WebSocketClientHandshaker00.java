package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.http.DefaultFullHttpRequest;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.util.AsciiString;
import io.netty.util.internal.PlatformDependent;
import java.net.URI;
import java.nio.ByteBuffer;
import k.a;

/* JADX INFO: loaded from: classes3.dex */
public class WebSocketClientHandshaker00 extends WebSocketClientHandshaker {
    private ByteBuf expectedChallengeResponseBytes;

    public WebSocketClientHandshaker00(URI uri, WebSocketVersion webSocketVersion, String str, HttpHeaders httpHeaders, int i10) {
        this(uri, webSocketVersion, str, httpHeaders, i10, 10000L);
    }

    private static String insertRandomCharacters(String str) {
        int iRandomNumber = WebSocketUtil.randomNumber(1, 12);
        char[] cArr = new char[iRandomNumber];
        int i10 = 0;
        while (i10 < iRandomNumber) {
            int iNextInt = PlatformDependent.threadLocalRandom().nextInt(126) + 33;
            if ((33 < iNextInt && iNextInt < 47) || (58 < iNextInt && iNextInt < 126)) {
                cArr[i10] = (char) iNextInt;
                i10++;
            }
        }
        for (int i11 = 0; i11 < iRandomNumber; i11++) {
            int iRandomNumber2 = WebSocketUtil.randomNumber(0, str.length());
            String strSubstring = str.substring(0, iRandomNumber2);
            String strSubstring2 = str.substring(iRandomNumber2);
            StringBuilder sbA = a.a(strSubstring);
            sbA.append(cArr[i11]);
            sbA.append(strSubstring2);
            str = sbA.toString();
        }
        return str;
    }

    private static String insertSpaces(String str, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            int iRandomNumber = WebSocketUtil.randomNumber(1, str.length() - 1);
            str = str.substring(0, iRandomNumber) + ' ' + str.substring(iRandomNumber);
        }
        return str;
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketClientHandshaker
    public FullHttpRequest newHandshakeRequest() {
        int iRandomNumber = WebSocketUtil.randomNumber(1, 12);
        int iRandomNumber2 = WebSocketUtil.randomNumber(1, 12);
        int iRandomNumber3 = WebSocketUtil.randomNumber(0, Integer.MAX_VALUE / iRandomNumber);
        int iRandomNumber4 = WebSocketUtil.randomNumber(0, Integer.MAX_VALUE / iRandomNumber2);
        String string = Integer.toString(iRandomNumber3 * iRandomNumber);
        String string2 = Integer.toString(iRandomNumber4 * iRandomNumber2);
        String strInsertRandomCharacters = insertRandomCharacters(string);
        String strInsertRandomCharacters2 = insertRandomCharacters(string2);
        String strInsertSpaces = insertSpaces(strInsertRandomCharacters, iRandomNumber);
        String strInsertSpaces2 = insertSpaces(strInsertRandomCharacters2, iRandomNumber2);
        byte[] bArrRandomBytes = WebSocketUtil.randomBytes(8);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.putInt(iRandomNumber3);
        byte[] bArrArray = byteBufferAllocate.array();
        ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(4);
        byteBufferAllocate2.putInt(iRandomNumber4);
        byte[] bArrArray2 = byteBufferAllocate2.array();
        byte[] bArr = new byte[16];
        System.arraycopy(bArrArray, 0, bArr, 0, 4);
        System.arraycopy(bArrArray2, 0, bArr, 4, 4);
        System.arraycopy(bArrRandomBytes, 0, bArr, 8, 8);
        this.expectedChallengeResponseBytes = Unpooled.wrappedBuffer(WebSocketUtil.md5(bArr));
        URI uri = uri();
        DefaultFullHttpRequest defaultFullHttpRequest = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, upgradeUrl(uri), Unpooled.wrappedBuffer(bArrRandomBytes));
        HttpHeaders httpHeadersHeaders = defaultFullHttpRequest.headers();
        HttpHeaders httpHeaders = this.customHeaders;
        if (httpHeaders != null) {
            httpHeadersHeaders.add(httpHeaders);
            AsciiString asciiString = HttpHeaderNames.HOST;
            if (!httpHeadersHeaders.contains(asciiString)) {
                httpHeadersHeaders.set(asciiString, WebSocketClientHandshaker.websocketHostValue(uri));
            }
        } else {
            httpHeadersHeaders.set(HttpHeaderNames.HOST, WebSocketClientHandshaker.websocketHostValue(uri));
        }
        httpHeadersHeaders.set(HttpHeaderNames.UPGRADE, HttpHeaderValues.WEBSOCKET).set(HttpHeaderNames.CONNECTION, HttpHeaderValues.UPGRADE).set(HttpHeaderNames.SEC_WEBSOCKET_KEY1, strInsertSpaces).set(HttpHeaderNames.SEC_WEBSOCKET_KEY2, strInsertSpaces2);
        if (this.generateOriginHeader) {
            AsciiString asciiString2 = HttpHeaderNames.ORIGIN;
            if (!httpHeadersHeaders.contains(asciiString2)) {
                httpHeadersHeaders.set(asciiString2, WebSocketClientHandshaker.websocketOriginValue(uri));
            }
        }
        String strExpectedSubprotocol = expectedSubprotocol();
        if (strExpectedSubprotocol != null && !strExpectedSubprotocol.isEmpty()) {
            httpHeadersHeaders.set(HttpHeaderNames.SEC_WEBSOCKET_PROTOCOL, strExpectedSubprotocol);
        }
        httpHeadersHeaders.set(HttpHeaderNames.CONTENT_LENGTH, Integer.valueOf(bArrRandomBytes.length));
        return defaultFullHttpRequest;
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketClientHandshaker
    public WebSocketFrameEncoder newWebSocketEncoder() {
        return new WebSocket00FrameEncoder();
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketClientHandshaker
    public WebSocketFrameDecoder newWebsocketDecoder() {
        return new WebSocket00FrameDecoder(maxFramePayloadLength());
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketClientHandshaker
    public void verify(FullHttpResponse fullHttpResponse) {
        HttpResponseStatus httpResponseStatusStatus = fullHttpResponse.status();
        if (!HttpResponseStatus.SWITCHING_PROTOCOLS.equals(httpResponseStatusStatus)) {
            throw new WebSocketClientHandshakeException("Invalid handshake response getStatus: " + httpResponseStatusStatus, fullHttpResponse);
        }
        HttpHeaders httpHeadersHeaders = fullHttpResponse.headers();
        String str = httpHeadersHeaders.get(HttpHeaderNames.UPGRADE);
        if (!HttpHeaderValues.WEBSOCKET.contentEqualsIgnoreCase(str)) {
            throw new WebSocketClientHandshakeException("Invalid handshake response upgrade: " + ((Object) str), fullHttpResponse);
        }
        AsciiString asciiString = HttpHeaderNames.CONNECTION;
        if (httpHeadersHeaders.containsValue(asciiString, HttpHeaderValues.UPGRADE, true)) {
            if (!fullHttpResponse.content().equals(this.expectedChallengeResponseBytes)) {
                throw new WebSocketClientHandshakeException("Invalid challenge", fullHttpResponse);
            }
        } else {
            throw new WebSocketClientHandshakeException("Invalid handshake response connection: " + httpHeadersHeaders.get(asciiString), fullHttpResponse);
        }
    }

    public WebSocketClientHandshaker00(URI uri, WebSocketVersion webSocketVersion, String str, HttpHeaders httpHeaders, int i10, long j10) {
        this(uri, webSocketVersion, str, httpHeaders, i10, j10, false);
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketClientHandshaker
    public WebSocketClientHandshaker00 setForceCloseTimeoutMillis(long j10) {
        super.setForceCloseTimeoutMillis(j10);
        return this;
    }

    public WebSocketClientHandshaker00(URI uri, WebSocketVersion webSocketVersion, String str, HttpHeaders httpHeaders, int i10, long j10, boolean z10) {
        this(uri, webSocketVersion, str, httpHeaders, i10, j10, z10, true);
    }

    public WebSocketClientHandshaker00(URI uri, WebSocketVersion webSocketVersion, String str, HttpHeaders httpHeaders, int i10, long j10, boolean z10, boolean z11) {
        super(uri, webSocketVersion, str, httpHeaders, i10, j10, z10, z11);
    }
}
