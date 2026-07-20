package io.netty.handler.codec.http.websocketx;

import hi.b;
import io.netty.util.AsciiString;

/* JADX INFO: loaded from: classes3.dex */
public enum WebSocketVersion {
    UNKNOWN(AsciiString.cached("")),
    V00(AsciiString.cached(b.f7118g)),
    V07(AsciiString.cached("7")),
    V08(AsciiString.cached("8")),
    V13(AsciiString.cached("13"));

    private final AsciiString headerValue;

    WebSocketVersion(AsciiString asciiString) {
        this.headerValue = asciiString;
    }

    public AsciiString toAsciiString() {
        if (this != UNKNOWN) {
            return this.headerValue;
        }
        throw new IllegalStateException("Unknown web socket version: " + this);
    }

    public String toHttpHeaderValue() {
        return toAsciiString().toString();
    }
}
