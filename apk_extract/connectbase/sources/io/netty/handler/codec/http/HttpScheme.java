package io.netty.handler.codec.http;

import io.netty.util.AsciiString;
import wj.h2;
import wj.v0;

/* JADX INFO: loaded from: classes3.dex */
public final class HttpScheme {
    public static final HttpScheme HTTP = new HttpScheme(80, "http");
    public static final HttpScheme HTTPS = new HttpScheme(v0.f19368n, h2.f18719h);
    private final AsciiString name;
    private final int port;

    private HttpScheme(int i10, String str) {
        this.port = i10;
        this.name = AsciiString.cached(str);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof HttpScheme)) {
            return false;
        }
        HttpScheme httpScheme = (HttpScheme) obj;
        return httpScheme.port() == this.port && httpScheme.name().equals(this.name);
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
