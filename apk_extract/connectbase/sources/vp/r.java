package vp;

/* JADX INFO: loaded from: classes3.dex */
public abstract class r extends q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final n0 f17735b;

    public r(@os.l n0 n0Var) {
        kn.l0.p(n0Var, "delegate");
        this.f17735b = n0Var;
    }

    @Override // vp.n1
    @os.l
    public n0 N0(boolean z10) {
        return z10 == H0() ? this : P0().N0(z10).O0(getAnnotations());
    }

    @Override // vp.q
    @os.l
    public n0 P0() {
        return this.f17735b;
    }

    @Override // vp.n0
    @os.l
    /* JADX INFO: renamed from: S0, reason: merged with bridge method [inline-methods] */
    public r O0(@os.l fo.g gVar) {
        kn.l0.p(gVar, "newAnnotations");
        return gVar != getAnnotations() ? new k(this, gVar) : this;
    }
}
