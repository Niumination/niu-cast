package wj;

import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public abstract class l0 implements s {
    @Override // wj.s
    public void a(vj.y2 y2Var) {
        w().a(y2Var);
    }

    @Override // wj.j3
    public void b(int i10) {
        w().b(i10);
    }

    @Override // wj.s
    public vj.a c() {
        return w().c();
    }

    @Override // wj.j3
    public void e(boolean z10) {
        w().e(z10);
    }

    @Override // wj.j3
    public void f(vj.s sVar) {
        w().f(sVar);
    }

    @Override // wj.j3
    public void flush() {
        w().flush();
    }

    @Override // wj.s
    public void h(int i10) {
        w().h(i10);
    }

    @Override // wj.s
    public void i(int i10) {
        w().i(i10);
    }

    @Override // wj.j3
    public void j(InputStream inputStream) {
        w().j(inputStream);
    }

    @Override // wj.s
    public void m(vj.a0 a0Var) {
        w().m(a0Var);
    }

    @Override // wj.j3
    public void n() {
        w().n();
    }

    @Override // wj.s
    public void o(boolean z10) {
        w().o(z10);
    }

    @Override // wj.s
    public void r(vj.y yVar) {
        w().r(yVar);
    }

    @Override // wj.j3
    public boolean s() {
        return w().s();
    }

    @Override // wj.s
    public void t(String str) {
        w().t(str);
    }

    public String toString() {
        return c1.z.c(this).j("delegate", w()).toString();
    }

    @Override // wj.s
    public void v() {
        w().v();
    }

    public abstract s w();

    @Override // wj.s
    public void x(b1 b1Var) {
        w().x(b1Var);
    }

    @Override // wj.s
    public void y(t tVar) {
        w().y(tVar);
    }
}
