package wj;

/* JADX INFO: loaded from: classes2.dex */
public abstract class r0 extends vj.x1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final vj.x1 f19252a;

    public r0(vj.x1 x1Var) {
        c1.h0.F(x1Var, "delegate can not be null");
        this.f19252a = x1Var;
    }

    @Override // vj.x1
    public String a() {
        return this.f19252a.a();
    }

    @Override // vj.x1
    public void b() {
        this.f19252a.b();
    }

    @Override // vj.x1
    public void c() {
        this.f19252a.c();
    }

    @Override // vj.x1
    public void d(vj.x1.e eVar) {
        this.f19252a.d(eVar);
    }

    @Override // vj.x1
    @Deprecated
    public void e(vj.x1.f fVar) {
        this.f19252a.e(fVar);
    }

    public String toString() {
        return c1.z.c(this).j("delegate", this.f19252a).toString();
    }
}
