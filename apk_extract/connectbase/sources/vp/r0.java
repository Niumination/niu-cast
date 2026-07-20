package vp;

/* JADX INFO: loaded from: classes3.dex */
public final class r0 extends d1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final f0 f17736a;

    public r0(@os.l ao.h hVar) {
        kn.l0.p(hVar, "kotlinBuiltIns");
        n0 n0VarI = hVar.I();
        kn.l0.o(n0VarI, "kotlinBuiltIns.nullableAnyType");
        this.f17736a = n0VarI;
    }

    @Override // vp.c1
    public boolean a() {
        return true;
    }

    @Override // vp.c1
    @os.l
    public c1 b(@os.l wp.g gVar) {
        kn.l0.p(gVar, "kotlinTypeRefiner");
        return this;
    }

    @Override // vp.c1
    @os.l
    public o1 c() {
        return o1.OUT_VARIANCE;
    }

    @Override // vp.c1
    @os.l
    public f0 getType() {
        return this.f17736a;
    }
}
