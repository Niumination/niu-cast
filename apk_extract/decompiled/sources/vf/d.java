package vf;

import java.util.Map;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import li.i2;
import pf.z0;
import zf.r0;
import zf.t;
import zf.x;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r0 f10561a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x f10562b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final t f10563c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final cg.j f10564d;
    public final i2 e;
    public final zg.h f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Set f10565g;

    public d(r0 url, x method, t headers, cg.j body, i2 executionContext, zg.h attributes) {
        Set setKeySet;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(executionContext, "executionContext");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        this.f10561a = url;
        this.f10562b = method;
        this.f10563c = headers;
        this.f10564d = body;
        this.e = executionContext;
        this.f = attributes;
        Map map = (Map) attributes.d(mf.j.f8037a);
        this.f10565g = (map == null || (setKeySet = map.keySet()) == null) ? SetsKt.emptySet() : setKeySet;
    }

    public final Object a() {
        z0 key = z0.f8882a;
        Intrinsics.checkNotNullParameter(key, "key");
        Map map = (Map) this.f.d(mf.j.f8037a);
        if (map != null) {
            return map.get(key);
        }
        return null;
    }

    public final String toString() {
        return "HttpRequestData(url=" + this.f10561a + ", method=" + this.f10562b + ')';
    }
}
