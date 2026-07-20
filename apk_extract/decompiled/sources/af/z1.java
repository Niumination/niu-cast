package af;

import k3.t8;

/* JADX INFO: loaded from: classes3.dex */
public final class z1 implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b0 f745a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a2 f746b;

    public z1(a2 a2Var, b0 b0Var) {
        this.f746b = a2Var;
        this.f745a = b0Var;
    }

    @Override // af.i6
    public final void a(ze.o oVar) {
        this.f745a.a(oVar);
    }

    @Override // af.b0
    public final void b(int i8) {
        this.f745a.b(i8);
    }

    @Override // af.b0
    public final void c(d0 d0Var) {
        r rVar = this.f746b.f139b;
        ((s2) rVar.f539b).e();
        ((k2) rVar.f538a).g();
        this.f745a.c(new l6(2, this, d0Var));
    }

    @Override // af.b0
    public final void d(ze.b0 b0Var) {
        this.f745a.d(b0Var);
    }

    @Override // af.i6
    public final void e(int i8) {
        this.f745a.e(i8);
    }

    @Override // af.b0
    public final void f(int i8) {
        this.f745a.f(i8);
    }

    @Override // af.i6
    public final void flush() {
        this.f745a.flush();
    }

    @Override // af.i6
    public final void g() {
        this.f745a.g();
    }

    @Override // af.b0
    public final void h(ze.q2 q2Var) {
        this.f745a.h(q2Var);
    }

    @Override // af.i6
    public final void i(gf.a aVar) {
        this.f745a.i(aVar);
    }

    @Override // af.i6
    public final boolean isReady() {
        return this.f745a.isReady();
    }

    @Override // af.b0
    public final void j(t1 t1Var) {
        this.f745a.j(t1Var);
    }

    @Override // af.b0
    public final void k() {
        this.f745a.k();
    }

    @Override // af.b0
    public final void m(ze.z zVar) {
        this.f745a.m(zVar);
    }

    public final String toString() {
        o6.a aVarA = t8.a(this);
        aVarA.d(this.f745a, "delegate");
        return aVarA.toString();
    }
}
