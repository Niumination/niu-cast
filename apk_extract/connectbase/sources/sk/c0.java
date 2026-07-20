package sk;

import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class c0 implements k<c0, e0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final rk.j f15109a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public e0 f15110b;

    public c0(@os.l rk.j jVar, @os.l e0 e0Var) {
        kn.l0.p(jVar, "selector");
        kn.l0.p(e0Var, "options");
        this.f15109a = jVar;
        this.f15110b = e0Var;
    }

    @Override // sk.k
    public k a(jn.l lVar) {
        return (c0) k.a.a(this, lVar);
    }

    @Override // sk.k
    public void b(@os.l e0 e0Var) {
        kn.l0.p(e0Var, "<set-?>");
        this.f15110b = e0Var;
    }

    @os.l
    public c0 c(@os.l jn.l<? super e0, l2> lVar) {
        return (c0) k.a.a(this, lVar);
    }

    @os.l
    public final k0 d() {
        return new k0(this.f15109a, this.f15110b.h());
    }

    @os.l
    public final m0 e() {
        return new m0(this.f15109a, this.f15110b.h().r());
    }

    @Override // sk.k
    @os.l
    public e0 getOptions() {
        return this.f15110b;
    }
}
