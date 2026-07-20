package io.netty.handler.codec.http.websocketx;

import io.netty.util.AsciiString;
import wj.v0;

/* JADX INFO: loaded from: classes3.dex */
public final class WebSocketScheme {
    public static final WebSocketScheme WS = new WebSocketScheme(80, "ws");
    public static final WebSocketScheme WSS = new WebSocketScheme(v0.f19368n, "wss");
    private final AsciiString name;
    private final int port;

    private WebSocketScheme(int i10, String str) {
        this.port = i10;
        this.name = AsciiString.cached(str);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof WebSocketScheme)) {
            return false;
        }
        WebSocketScheme webSocketScheme = (WebSocketScheme) obj;
        return webSocketScheme.port() == this.port && webSocketScheme.name().equals(this.name);
    }

    public int hashCode() {
        return this.name.hashCode() + (this.port * 31);
    }

    public AsciiString name() {
        return this.name;
    }

    public int port() {
        return this.port;
    }

    public String toString() {
        return this.name.toString();
    }
}
