package vp;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class z extends n1 implements yp.g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final n0 f17773b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final n0 f17774c;

    public z(@os.l n0 n0Var, @os.l n0 n0Var2) {
        kn.l0.p(n0Var, "lowerBound");
        kn.l0.p(n0Var2, "upperBound");
        this.f17773b = n0Var;
        this.f17774c = n0Var2;
    }

    @Override // vp.f0
    @os.l
    public List<c1> F0() {
        return N0().F0();
    }

    @Override // vp.f0
    @os.l
    public a1 G0() {
        return N0().G0();
    }

    @Override // vp.f0
    public boolean H0() {
        return N0().H0();
    }

    @os.l
    public abstract n0 N0();

    @os.l
    public final n0 O0() {
        return this.f17773b;
    }

    @os.l
    public final n0 P0() {
        return this.f17774c;
    }

    @os.l
    public abstract String Q0(@os.l gp.c cVar, @os.l gp.f fVar);

    @Override // fo.a
    @os.l
    public fo.g getAnnotations() {
        return N0().getAnnotations();
    }

    @Override // vp.f0
    @os.l
    public op.h o() {
        return N0().o();
    }

    @os.l
    public String toString() {
        return gp.c.f6770j.y(this);
    }
}
