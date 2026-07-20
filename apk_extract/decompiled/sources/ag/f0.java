package ag;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class f0 extends g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final li.r f767a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final jh.k f768b;

    public f0(li.r headers, jh.k body) {
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(body, "body");
        this.f767a = headers;
        this.f768b = body;
    }

    @Override // ag.g0
    public final void a() throws Throwable {
        this.f767a.A(new d0(this, 0));
        li.l0.q(new e0(this, null));
    }
}
