package eo;

import java.util.List;
import vp.o1;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final e1 f4593a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final m f4594b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f4595c;

    public c(@os.l e1 e1Var, @os.l m mVar, int i10) {
        kn.l0.p(e1Var, "originalDescriptor");
        kn.l0.p(mVar, "declarationDescriptor");
        this.f4593a = e1Var;
        this.f4594b = mVar;
        this.f4595c = i10;
    }

    @Override // eo.m
    public <R, D> R A(o<R, D> oVar, D d10) {
        return (R) this.f4593a.A(oVar, d10);
    }

    @Override // eo.e1
    @os.l
    public up.n P() {
        return this.f4593a.P();
    }

    @Override // eo.e1
    public boolean T() {
        return true;
    }

    @Override // eo.n, eo.m
    @os.l
    public m b() {
        return this.f4594b;
    }

    @Override // eo.e1
    public int f() {
        return this.f4593a.f() + this.f4595c;
    }

    @Override // fo.a
    @os.l
    public fo.g getAnnotations() {
        return this.f4593a.getAnnotations();
    }

    @Override // eo.i0
    @os.l
    public dp.f getName() {
        return this.f4593a.getName();
    }

    @Override // eo.p
    @os.l
    public z0 getSource() {
        return this.f4593a.getSource();
    }

    @Override // eo.e1
    @os.l
    public List<vp.f0> getUpperBounds() {
        return this.f4593a.getUpperBounds();
    }

    @Override // eo.e1, eo.h
    @os.l
    public vp.a1 i() {
        return this.f4593a.i();
    }

    @Override // eo.e1
    public boolean j() {
        return this.f4593a.j();
    }

    @Override // eo.e1
    @os.l
    public o1 m() {
        return this.f4593a.m();
    }

    @Override // eo.h
    @os.l
    public vp.n0 q() {
        return this.f4593a.q();
    }

    @os.l
    public String toString() {
        return this.f4593a + "[inner-copy]";
    }

    @Override // eo.m
    @os.l
    public e1 a() {
        e1 e1VarA = this.f4593a.a();
        kn.l0.o(e1VarA, "originalDescriptor.original");
        return e1VarA;
    }
}
