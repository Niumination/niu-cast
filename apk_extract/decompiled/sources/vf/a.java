package vf;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import zf.r;
import zf.r0;
import zf.t;
import zf.x;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final kf.c f10552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x f10553b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final r0 f10554c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final cg.j f10555d;
    public final t e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final zg.h f10556h;

    public a(kf.c call, d data) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(data, "data");
        this.f10552a = call;
        this.f10553b = data.f10562b;
        this.f10554c = data.f10561a;
        this.f10555d = data.f10564d;
        this.e = data.f10563c;
        this.f10556h = data.f;
    }

    @Override // vf.b
    public final x X() {
        return this.f10553b;
    }

    @Override // zf.w
    public final r a() {
        return this.e;
    }

    @Override // vf.b
    public final cg.j getContent() {
        return this.f10555d;
    }

    @Override // vf.b, li.g0
    public final CoroutineContext getCoroutineContext() {
        return this.f10552a.getCoroutineContext();
    }

    @Override // vf.b
    public final r0 getUrl() {
        return this.f10554c;
    }

    @Override // vf.b
    public final zg.h i() {
        return this.f10556h;
    }
}
