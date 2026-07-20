package c3;

import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class q extends l implements x2.g {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final x2.g f1326d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(@os.l x2.g gVar) {
        super(gVar);
        l0.p(gVar, "listener");
        this.f1326d = gVar;
    }

    @Override // x2.g
    public void e(long j10, boolean z10, @os.m String str) {
        if (!z10) {
            m.f1313a.h(j10, 5);
        }
        this.f1326d.e(j10, z10, str);
    }

    @Override // x2.g
    public void f(@os.l String str) {
        l0.p(str, "data");
        this.f1326d.f(str);
    }

    @Override // c3.l, x2.d
    public void g(long j10) {
        r2.k kVarD = m.f1313a.d(j10);
        if (kVarD != null) {
            kVarD.f14191e = 1;
        }
        this.f1326d.g(j10);
    }
}
