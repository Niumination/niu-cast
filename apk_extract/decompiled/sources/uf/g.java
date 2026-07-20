package uf;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import m3.m6;
import zf.r;
import zf.s;
import zf.t;
import zf.v;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends cg.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f10428a = LazyKt.lazy(new ob.c(16));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t f10429b;

    public g() {
        String str = zg.b.a(m6.a(16));
        Intrinsics.checkNotNullExpressionValue(str, "toString(...)");
        s sVar = new s();
        String[] strArr = v.f11551a;
        sVar.d("Upgrade", "websocket");
        sVar.d("Connection", "Upgrade");
        sVar.d("Sec-WebSocket-Key", str);
        sVar.d("Sec-WebSocket-Version", "13");
        this.f10429b = sVar.o();
    }

    @Override // cg.j
    public final r c() {
        return this.f10429b;
    }

    public final String toString() {
        return "WebSocketContent";
    }
}
