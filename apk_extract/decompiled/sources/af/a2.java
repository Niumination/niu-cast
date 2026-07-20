package af;

/* JADX INFO: loaded from: classes3.dex */
public final class a2 extends g1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j0 f138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r f139b;

    public a2(j0 j0Var, r rVar) {
        this.f138a = j0Var;
        this.f139b = rVar;
    }

    @Override // af.g1
    public final j0 b() {
        return this.f138a;
    }

    @Override // af.e0
    public final b0 f(ze.r1 r1Var, ze.p1 p1Var, ze.f fVar, ze.n[] nVarArr) {
        return new z1(this, b().f(r1Var, p1Var, fVar, nVarArr));
    }
}
