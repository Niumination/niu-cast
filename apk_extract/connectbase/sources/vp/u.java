package vp;

/* JADX INFO: loaded from: classes3.dex */
public final class u extends z implements yp.f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final fo.g f17743d;

    /* JADX WARN: Illegal instructions before constructor call */
    public u(@os.l ao.h hVar, @os.l fo.g gVar) {
        kn.l0.p(hVar, "builtIns");
        kn.l0.p(gVar, "annotations");
        n0 n0VarH = hVar.H();
        kn.l0.o(n0VarH, "builtIns.nothingType");
        n0 n0VarI = hVar.I();
        kn.l0.o(n0VarI, "builtIns.nullableAnyType");
        super(n0VarH, n0VarI);
        this.f17743d = gVar;
    }

    @Override // vp.z, vp.f0
    public boolean H0() {
        return false;
    }

    @Override // vp.f0
    /* JADX INFO: renamed from: I0 */
    public f0 Q0(wp.g gVar) {
        kn.l0.p(gVar, "kotlinTypeRefiner");
        return this;
    }

    @Override // vp.n1
    /* JADX INFO: renamed from: K0 */
    public n1 N0(boolean z10) {
        return this;
    }

    @Override // vp.n1
    /* JADX INFO: renamed from: L0 */
    public n1 Q0(wp.g gVar) {
        kn.l0.p(gVar, "kotlinTypeRefiner");
        return this;
    }

    @Override // vp.z
    @os.l
    public n0 N0() {
        return this.f17774c;
    }

    @Override // vp.z
    @os.l
    public String Q0(@os.l gp.c cVar, @os.l gp.f fVar) {
        kn.l0.p(cVar, "renderer");
        kn.l0.p(fVar, "options");
        return "dynamic";
    }

    @os.l
    public u R0(boolean z10) {
        return this;
    }

    @os.l
    public u S0(@os.l wp.g gVar) {
        kn.l0.p(gVar, "kotlinTypeRefiner");
        return this;
    }

    @Override // vp.n1
    @os.l
    /* JADX INFO: renamed from: T0, reason: merged with bridge method [inline-methods] */
    public u O0(@os.l fo.g gVar) {
        kn.l0.p(gVar, "newAnnotations");
        return new u(zp.a.h(this.f17774c), gVar);
    }

    @Override // vp.z, fo.a
    @os.l
    public fo.g getAnnotations() {
        return this.f17743d;
    }
}
