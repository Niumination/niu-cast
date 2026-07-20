package yj;

import io.netty.handler.codec.http2.Http2Headers;

/* JADX INFO: loaded from: classes2.dex */
public class f extends k1.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Http2Headers f20942c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i0.c f20943d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f20944e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f20945f;

    public f(Http2Headers http2Headers, i0.c cVar, boolean z10, boolean z11) {
        this.f20943d = (i0.c) c1.h0.F(cVar, "stream");
        this.f20942c = (Http2Headers) c1.h0.F(http2Headers, "headers");
        this.f20944e = z10;
        this.f20945f = z11;
    }

    public Http2Headers d() {
        return this.f20942c;
    }

    public boolean e() {
        return this.f20945f;
    }

    public boolean f() {
        return this.f20944e;
    }

    public i0.c g() {
        return this.f20943d;
    }
}
