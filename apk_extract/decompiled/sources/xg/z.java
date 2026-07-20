package xg;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class z implements vg.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f11002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final zf.d0 f11003b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final zf.r f11004c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final zf.i0 f11005d;

    public z(zf.d0 pathVariables, vg.e request, r call) {
        Intrinsics.checkNotNullParameter(pathVariables, "pathVariables");
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(call, "call");
        this.f11002a = call;
        request.s();
        this.f11003b = request.h();
        this.f11004c = request.a();
        this.f11005d = request.g();
        request.f();
    }

    @Override // vg.c
    public final zf.r a() {
        return this.f11004c;
    }

    @Override // vg.c
    public final mg.b c() {
        return this.f11002a;
    }

    @Override // vg.c
    public final zf.i0 g() {
        return this.f11005d;
    }

    @Override // vg.c
    public final zf.d0 h() {
        return this.f11003b;
    }
}
