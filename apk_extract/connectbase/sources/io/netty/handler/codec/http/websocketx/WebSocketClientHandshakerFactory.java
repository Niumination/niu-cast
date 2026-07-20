package io.netty.handler.codec.http.websocketx;

import io.netty.handler.codec.http.HttpHeaders;
import java.net.URI;

/* JADX INFO: loaded from: classes3.dex */
public final class WebSocketClientHandshakerFactory {
    private WebSocketClientHandshakerFactory() {
    }

    public static WebSocketClientHandshaker newHandshaker(URI uri, WebSocketVersion webSocketVersion, String str, boolean z10, HttpHeaders httpHeaders) {
        return newHandshaker(uri, webSocketVersion, str, z10, httpHeaders, 65536);
    }

    public static WebSocketClientHandshaker newHandshaker(URI uri, WebSocketVersion webSocketVersion, String str, boolean z10, HttpHeaders httpHeaders, int i10) {
        return newHandshaker(uri, webSocketVersion, str, z10, httpHeaders, i10, true, false);
    }

    public static WebSocketClientHandshaker newHandshaker(URI uri, WebSocketVersion webSocketVersion, String str, boolean z10, HttpHeaders httpHeaders, int i10, boolean z11, boolean z12) {
        return newHandshaker(uri, webSocketVersion, str, z10, httpHeaders, i10, z11, z12, -1L);
    }

    public static WebSocketClientHandshaker newHandshaker(URI uri, WebSocketVersion webSocketVersion, String str, boolean z10, HttpHeaders httpHeaders, int i10, boolean z11, boolean z12, long j10) {
        WebSocketVersion webSocketVersion2 = WebSocketVersion.V13;
        if (webSocketVersion == webSocketVersion2) {
            return new WebSocketClientHandshaker13(uri, webSocketVersion2, str, z10, httpHeaders, i10, z11, z12, j10);
        }
        WebSocketVersion webSocketVersion3 = WebSocketVersion.V08;
        if (webSocketVersion == webSocketVersion3) {
            return new WebSocketClientHandshaker08(uri, webSocketVersion3, str, z10, httpHeaders, i10, z11, z12, j10);
        }
        WebSocketVersion webSocketVersion4 = WebSocketVersion.V07;
        if (webSocketVersion == webSocketVersion4) {
            return new WebSocketClientHandshaker07(uri, webSocketVersion4, str, z10, httpHeaders, i10, z11, z12, j10);
        }
        WebSocketVersion webSocketVersion5 = WebSocketVersion.V00;
        if (webSocketVersion == webSocketVersion5) {
            return new WebSocketClientHandshaker00(uri, webSocketVersion5, str, httpHeaders, i10, j10);
        }
        throw new WebSocketClientHandshakeException("Protocol version " + webSocketVersion + " not supported.");
    }

    public static WebSocketClientHandshaker newHandshaker(URI uri, WebSocketVersion webSocketVersion, String str, boolean z10, HttpHeaders httpHeaders, int i10, boolean z11, boolean z12, long j10, boolean z13) {
        WebSocketVersion webSocketVersion2 = WebSocketVersion.V13;
        if (webSocketVersion == webSocketVersion2) {
            return new WebSocketClientHandshaker13(uri, webSocketVersion2, str, z10, httpHeaders, i10, z11, z12, j10, z13);
        }
        WebSocketVersion webSocketVersion3 = WebSocketVersion.V08;
        if (webSocketVersion == webSocketVersion3) {
            return new WebSocketClientHandshaker08(uri, webSocketVersion3, str, z10, httpHeaders, i10, z11, z12, j10, z13);
        }
        WebSocketVersion webSocketVersion4 = WebSocketVersion.V07;
        if (webSocketVersion == webSocketVersion4) {
            return new WebSocketClientHandshaker07(uri, webSocketVersion4, str, z10, httpHeaders, i10, z11, z12, j10, z13);
        }
        WebSocketVersion webSocketVersion5 = WebSocketVersion.V00;
        if (webSocketVersion == webSocketVersion5) {
            return new WebSocketClientHandshaker00(uri, webSocketVersion5, str, httpHeaders, i10, j10, z13);
        }
        throw new WebSocketClientHandshakeException("Protocol version " + webSocketVersion + " not supported.");
    }

    public static WebSocketClientHandshaker newHandshaker(URI uri, WebSocketVersion webSocketVersion, String str, boolean z10, HttpHeaders httpHeaders, int i10, boolean z11, boolean z12, long j10, boolean z13, boolean z14) {
        WebSocketVersion webSocketVersion2 = WebSocketVersion.V13;
        if (webSocketVersion == webSocketVersion2) {
            return new WebSocketClientHandshaker13(uri, webSocketVersion2, str, z10, httpHeaders, i10, z11, z12, j10, z13, z14);
        }
        WebSocketVersion webSocketVersion3 = WebSocketVersion.V08;
        if (webSocketVersion == webSocketVersion3) {
            return new WebSocketClientHandshaker08(uri, webSocketVersion3, str, z10, httpHeaders, i10, z11, z12, j10, z13, z14);
        }
        WebSocketVersion webSocketVersion4 = WebSocketVersion.V07;
        if (webSocketVersion == webSocketVersion4) {
            return new WebSocketClientHandshaker07(uri, webSocketVersion4, str, z10, httpHeaders, i10, z11, z12, j10, z13, z14);
        }
        WebSocketVersion webSocketVersion5 = WebSocketVersion.V00;
        if (webSocketVersion == webSocketVersion5) {
            return new WebSocketClientHandshaker00(uri, webSocketVersion5, str, httpHeaders, i10, j10, z13, z14);
        }
        throw new WebSocketClientHandshakeException("Protocol version " + webSocketVersion + " not supported.");
    }
}
