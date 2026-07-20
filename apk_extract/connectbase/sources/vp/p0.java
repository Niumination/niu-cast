package vp;

/* JADX INFO: loaded from: classes3.dex */
public final class p0 extends q implements k1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final n0 f17733b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final f0 f17734c;

    public p0(@os.l n0 n0Var, @os.l f0 f0Var) {
        kn.l0.p(n0Var, "delegate");
        kn.l0.p(f0Var, "enhancement");
        this.f17733b = n0Var;
        this.f17734c = f0Var;
    }

    @Override // vp.k1
    public n1 B0() {
        return this.f17733b;
    }

    @Override // vp.n1
    @os.l
    public n0 N0(boolean z10) {
        return (n0) l1.e(this.f17733b.N0(z10), this.f17734c.J0().N0(z10));
    }

    @Override // vp.n1
    @os.l
    public n0 O0(@os.l fo.g gVar) {
        kn.l0.p(gVar, "newAnnotations");
        return (n0) l1.e(this.f17733b.O0(gVar), this.f17734c);
    }

    @Override // vp.q
    @os.l
    public n0 P0() {
        return this.f17733b;
    }

    @os.l
    public n0 S0() {
        return this.f17733b;
    }

    @Override // vp.q
    @os.l
    /* JADX INFO: renamed from: T0, reason: merged with bridge method [inline-methods] */
    public p0 Q0(@os.l wp.g gVar) {
        kn.l0.p(gVar, "kotlinTypeRefiner");
        return new p0((n0) gVar.a(this.f17733b), gVar.a(this.f17734c));
    }

    @Override // vp.q
    @os.l
    /* JADX INFO: renamed from: U0, reason: merged with bridge method [inline-methods] */
    public p0 R0(@os.l n0 n0Var) {
        kn.l0.p(n0Var, "delegate");
        return new p0(n0Var, this.f17734c);
    }

    @Override // vp.k1
    @os.l
    public f0 f0() {
        return this.f17734c;
    }

    @Override // vp.n0
    @os.l
    public String toString() {
        return "[@EnhancedForWarnings(" + this.f17734c + ")] " + this.f17733b;
    }
}
