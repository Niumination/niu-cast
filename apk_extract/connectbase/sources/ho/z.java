package ho;

import eo.z0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class z extends k implements eo.k0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final dp.c f7473e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public final String f7474f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(@os.l eo.h0 h0Var, @os.l dp.c cVar) {
        super(h0Var, fo.g.a.f6169b, cVar.h(), z0.f4654a);
        kn.l0.p(h0Var, "module");
        kn.l0.p(cVar, "fqName");
        fo.g.f6167h.getClass();
        this.f7473e = cVar;
        this.f7474f = "package " + cVar + " of " + h0Var;
    }

    @Override // eo.m
    public <R, D> R A(@os.l eo.o<R, D> oVar, D d10) {
        kn.l0.p(oVar, "visitor");
        return oVar.d(this, d10);
    }

    @Override // eo.k0
    @os.l
    public final dp.c e() {
        return this.f7473e;
    }

    @Override // ho.k, eo.p
    @os.l
    public z0 getSource() {
        z0 z0Var = z0.f4654a;
        kn.l0.o(z0Var, "NO_SOURCE");
        return z0Var;
    }

    @Override // ho.j
    @os.l
    public String toString() {
        return this.f7474f;
    }

    @Override // ho.k, eo.m
    @os.l
    public eo.h0 b() {
        return (eo.h0) super.b();
    }
}
