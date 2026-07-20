package eo;

/* JADX INFO: loaded from: classes3.dex */
public abstract class r extends u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final m1 f4625a;

    public r(@os.l m1 m1Var) {
        kn.l0.p(m1Var, "delegate");
        this.f4625a = m1Var;
    }

    @Override // eo.u
    @os.l
    public m1 b() {
        return this.f4625a;
    }

    @Override // eo.u
    @os.l
    public String c() {
        return b().b();
    }

    @Override // eo.u
    @os.l
    public u f() {
        u uVarJ = t.j(b().d());
        kn.l0.o(uVarJ, "toDescriptorVisibility(delegate.normalize())");
        return uVarJ;
    }
}
