package wj;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public abstract class o0 implements x {
    @Override // wj.r1
    public void a(vj.y2 y2Var) {
        b().a(y2Var);
    }

    public abstract x b();

    @Override // wj.x
    public vj.a c() {
        return b().c();
    }

    @Override // wj.u
    public void d(u.a aVar, Executor executor) {
        b().d(aVar, executor);
    }

    @Override // vj.m1
    public vj.c1 e() {
        return b().e();
    }

    @Override // wj.r1
    public Runnable f(r1.a aVar) {
        return b().f(aVar);
    }

    @Override // vj.a1
    public q1.s1<vj.v0.l> j() {
        return b().j();
    }

    @Override // wj.u
    public s k(vj.w1<?, ?> w1Var, vj.v1 v1Var, vj.e eVar, vj.n[] nVarArr) {
        return b().k(w1Var, v1Var, eVar, nVarArr);
    }

    @Override // wj.r1
    public void n(vj.y2 y2Var) {
        b().n(y2Var);
    }

    public String toString() {
        return c1.z.c(this).j("delegate", b()).toString();
    }
}
