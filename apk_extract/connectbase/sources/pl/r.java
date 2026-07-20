package pl;

import nq.s0;

/* JADX INFO: loaded from: classes2.dex */
public final class r implements i0, m0, s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final c f13210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ s0 f13211b;

    public r(@os.l s0 s0Var, @os.l c cVar) {
        kn.l0.p(s0Var, "delegate");
        kn.l0.p(cVar, "channel");
        this.f13210a = cVar;
        this.f13211b = s0Var;
    }

    @Override // pl.i0
    public k a() {
        return this.f13210a;
    }

    @os.l
    public c b() {
        return this.f13210a;
    }

    @Override // nq.s0
    @os.l
    public um.g getCoroutineContext() {
        return this.f13211b.getCoroutineContext();
    }

    @Override // pl.m0
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public n mo71a() {
        return this.f13210a;
    }
}
