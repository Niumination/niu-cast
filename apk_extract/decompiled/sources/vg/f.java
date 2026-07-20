package vg;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f10590a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f10591b;

    public f(c request) {
        Intrinsics.checkNotNullParameter(request, "request");
        this.f10590a = request;
        new ConcurrentHashMap(true & true ? 32 : 0);
        this.f10591b = LazyKt.lazy(new ag.a(this, 19));
    }
}
