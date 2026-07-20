package vp;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class q extends n0 {
    @Override // vp.f0
    @os.l
    public List<c1> F0() {
        return P0().F0();
    }

    @Override // vp.f0
    @os.l
    public a1 G0() {
        return P0().G0();
    }

    @Override // vp.f0
    public boolean H0() {
        return P0().H0();
    }

    @os.l
    public abstract n0 P0();

    @Override // vp.n1
    @os.l
    public n0 Q0(@os.l wp.g gVar) {
        kn.l0.p(gVar, "kotlinTypeRefiner");
        return R0((n0) gVar.a(P0()));
    }

    @os.l
    public abstract q R0(@os.l n0 n0Var);

    @Override // fo.a
    @os.l
    public fo.g getAnnotations() {
        return P0().getAnnotations();
    }

    @Override // vp.f0
    @os.l
    public op.h o() {
        return P0().o();
    }
}
