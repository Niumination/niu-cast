package xg;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class i0 implements wg.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f10958a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final wg.c f10959b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ka.d f10960c;

    public i0(r call, wg.c applicationResponse) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(applicationResponse, "applicationResponse");
        this.f10958a = call;
        this.f10959b = applicationResponse;
        this.f10960c = applicationResponse.a();
        applicationResponse.f();
    }

    @Override // wg.a
    public final ka.d a() {
        return this.f10960c;
    }

    @Override // wg.a
    public final boolean b() {
        return this.f10959b.b();
    }

    @Override // wg.a
    public final mg.b c() {
        return this.f10958a;
    }

    @Override // wg.a
    public final zf.z g() {
        return this.f10959b.g();
    }
}
