package vp;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final n0 f17659b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final n0 f17660c;

    public a(@os.l n0 n0Var, @os.l n0 n0Var2) {
        kn.l0.p(n0Var, "delegate");
        kn.l0.p(n0Var2, "abbreviation");
        this.f17659b = n0Var;
        this.f17660c = n0Var2;
    }

    @os.l
    public final n0 J() {
        return this.f17659b;
    }

    @Override // vp.q
    @os.l
    public n0 P0() {
        return this.f17659b;
    }

    @os.l
    public final n0 S0() {
        return this.f17660c;
    }

    @Override // vp.n0
    @os.l
    /* JADX INFO: renamed from: T0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public a N0(boolean z10) {
        return new a(this.f17659b.N0(z10), this.f17660c.N0(z10));
    }

    @Override // vp.q
    @os.l
    /* JADX INFO: renamed from: U0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public a Q0(@os.l wp.g gVar) {
        kn.l0.p(gVar, "kotlinTypeRefiner");
        return new a((n0) gVar.a(this.f17659b), (n0) gVar.a(this.f17660c));
    }

    @Override // vp.n0
    @os.l
    /* JADX INFO: renamed from: V0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public a O0(@os.l fo.g gVar) {
        kn.l0.p(gVar, "newAnnotations");
        return new a(this.f17659b.O0(gVar), this.f17660c);
    }

    @Override // vp.q
    @os.l
    /* JADX INFO: renamed from: W0, reason: merged with bridge method [inline-methods] */
    public a R0(@os.l n0 n0Var) {
        kn.l0.p(n0Var, "delegate");
        return new a(n0Var, this.f17660c);
    }
}
