package vp;

/* JADX INFO: loaded from: classes3.dex */
public final class b0 extends z implements k1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final z f17664d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final f0 f17665e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b0(@os.l z zVar, @os.l f0 f0Var) {
        super(zVar.f17773b, zVar.f17774c);
        kn.l0.p(zVar, n1.d.a.f11176d);
        kn.l0.p(f0Var, "enhancement");
        this.f17664d = zVar;
        this.f17665e = f0Var;
    }

    @Override // vp.k1
    public n1 B0() {
        return this.f17664d;
    }

    @Override // vp.n1
    @os.l
    /* JADX INFO: renamed from: K0 */
    public n1 N0(boolean z10) {
        return l1.e(this.f17664d.N0(z10), this.f17665e.J0().N0(z10));
    }

    @Override // vp.n1
    @os.l
    /* JADX INFO: renamed from: M0 */
    public n1 O0(@os.l fo.g gVar) {
        kn.l0.p(gVar, "newAnnotations");
        return l1.e(this.f17664d.O0(gVar), this.f17665e);
    }

    @Override // vp.z
    @os.l
    public n0 N0() {
        return this.f17664d.N0();
    }

    @Override // vp.z
    @os.l
    public String Q0(@os.l gp.c cVar, @os.l gp.f fVar) {
        kn.l0.p(cVar, "renderer");
        kn.l0.p(fVar, "options");
        return fVar.c() ? cVar.y(this.f17665e) : this.f17664d.Q0(cVar, fVar);
    }

    @os.l
    public z R0() {
        return this.f17664d;
    }

    @Override // vp.n1
    @os.l
    /* JADX INFO: renamed from: S0, reason: merged with bridge method [inline-methods] */
    public b0 Q0(@os.l wp.g gVar) {
        kn.l0.p(gVar, "kotlinTypeRefiner");
        return new b0((z) gVar.a(this.f17664d), gVar.a(this.f17665e));
    }

    @Override // vp.k1
    @os.l
    public f0 f0() {
        return this.f17665e;
    }

    @Override // vp.z
    @os.l
    public String toString() {
        return "[@EnhancedForWarnings(" + this.f17665e + ")] " + this.f17664d;
    }
}
