package qg;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class i implements vg.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ng.b f9077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f9078b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final vg.b f9079c;
    private volatile /* synthetic */ Object receiveChannel;

    public i(ng.b call) {
        Intrinsics.checkNotNullParameter(call, "call");
        this.f9077a = call;
        this.receiveChannel = null;
        this.f9078b = LazyKt.lazy(new ag.a(this, 10));
        vg.b bVar = new vg.b(call.f8244a.f8054h);
        vg.b from = call.f8244a.f8056j;
        Intrinsics.checkNotNullParameter(from, "from");
        bVar.f5398b.clear();
        if (bVar.f5399c != 0) {
            throw new IllegalStateException("Check failed.");
        }
        bVar.d(from);
        this.f9079c = bVar;
    }

    @Override // vg.c
    public final zf.r a() {
        return (zf.r) this.f9078b.getValue();
    }

    @Override // vg.c
    public final /* bridge */ /* synthetic */ mg.b c() {
        return this.f9077a;
    }

    @Override // vg.e
    public final vg.b e() {
        return this.f9079c;
    }

    @Override // vg.c
    public final jh.o k() {
        jh.o oVar = (jh.o) this.receiveChannel;
        return oVar == null ? ((ng.r) this).f8271h : oVar;
    }
}
