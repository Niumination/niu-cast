package wp;

import kn.l0;
import vp.f0;
import vp.n1;
import vp.z0;

/* JADX INFO: loaded from: classes3.dex */
public final class m implements l {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final g f19869c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final f f19870d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final hp.j f19871e;

    public m(@os.l g gVar, @os.l f fVar) {
        l0.p(gVar, "kotlinTypeRefiner");
        l0.p(fVar, "kotlinTypePreparator");
        this.f19869c = gVar;
        this.f19870d = fVar;
        hp.j jVarN = hp.j.n(gVar);
        l0.o(jVarN, "createWithTypeRefiner(kotlinTypeRefiner)");
        this.f19871e = jVarN;
    }

    @Override // wp.l
    @os.l
    public hp.j a() {
        return this.f19871e;
    }

    @Override // wp.e
    public boolean b(@os.l f0 f0Var, @os.l f0 f0Var2) {
        l0.p(f0Var, "a");
        l0.p(f0Var2, "b");
        return e(a.b(false, false, null, this.f19870d, this.f19869c, 6, null), f0Var.J0(), f0Var2.J0());
    }

    @Override // wp.e
    public boolean c(@os.l f0 f0Var, @os.l f0 f0Var2) {
        l0.p(f0Var, "subtype");
        l0.p(f0Var2, "supertype");
        return g(a.b(true, false, null, this.f19870d, this.f19869c, 6, null), f0Var.J0(), f0Var2.J0());
    }

    @Override // wp.l
    @os.l
    public g d() {
        return this.f19869c;
    }

    public final boolean e(@os.l z0 z0Var, @os.l n1 n1Var, @os.l n1 n1Var2) {
        l0.p(z0Var, "<this>");
        l0.p(n1Var, "a");
        l0.p(n1Var2, "b");
        return vp.g.f17688a.i(z0Var, n1Var, n1Var2);
    }

    @os.l
    public f f() {
        return this.f19870d;
    }

    public final boolean g(@os.l z0 z0Var, @os.l n1 n1Var, @os.l n1 n1Var2) {
        l0.p(z0Var, "<this>");
        l0.p(n1Var, "subType");
        l0.p(n1Var2, "superType");
        return vp.g.q(vp.g.f17688a, z0Var, n1Var, n1Var2, false, 8, null);
    }

    public /* synthetic */ m(g gVar, f fVar, int i10, kn.w wVar) {
        this(gVar, (i10 & 2) != 0 ? f.a.f19852a : fVar);
    }
}
