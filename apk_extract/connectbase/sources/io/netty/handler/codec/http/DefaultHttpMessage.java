package io.netty.handler.codec.http;

import io.netty.util.internal.ObjectUtil;
import lb.f;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DefaultHttpMessage extends DefaultHttpObject implements HttpMessage {
    private static final int HASH_CODE_PRIME = 31;
    private final HttpHeaders headers;
    private HttpVersion version;

    public DefaultHttpMessage(HttpVersion httpVersion) {
        this(httpVersion, true, false);
    }

    @Override // io.netty.handler.codec.http.DefaultHttpObject
    public boolean equals(Object obj) {
        if (!(obj instanceof DefaultHttpMessage)) {
            return false;
        }
        DefaultHttpMessage defaultHttpMessage = (DefaultHttpMessage) obj;
        return headers().equals(defaultHttpMessage.headers()) && protocolVersion().equals(defaultHttpMessage.protocolVersion()) && super.equals(obj);
    }

    @Override // io.netty.handler.codec.http.HttpMessage
    @Deprecated
    public HttpVersion getProtocolVersion() {
        return protocolVersion();
    }

    @Override // io.netty.handler.codec.http.DefaultHttpObject
    public int hashCode() {
        return ((this.version.hashCode() + ((this.headers.hashCode() + 31) * 31)) * 31) + super.hashCode();
    }

    @Override // io.netty.handler.codec.http.HttpMessage
    public HttpHeaders headers() {
        return this.headers;
    }

    @Override // io.netty.handler.codec.http.HttpMessage
    public HttpVersion protocolVersion() {
        return this.version;
    }

    public HttpMessage setProtocolVersion(HttpVersion httpVersion) {
        this.version = (HttpVersion) ObjectUtil.checkNotNull(httpVersion, f.f9782f);
        return this;
    }

    public DefaultHttpMessage(HttpVersion httpVersion, boolean z10, boolean z11) {
        this(httpVersion, z11 ? new CombinedHttpHeaders(z10) : new DefaultHttpHeaders(z10));
    }

    public DefaultHttpMessage(HttpVersion httpVersion, HttpHeaders httpHeaders) {
        this.version = (HttpVersion) ObjectUtil.checkNotNull(httpVersion, f.f9782f);
        this.headers = (HttpHeaders) ObjectUtil.checkNotNull(httpHeaders, "headers");
    }
}
