package wj;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public abstract class q0 extends vj.r1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final vj.r1 f19174a;

    public q0(vj.r1 r1Var) {
        this.f19174a = r1Var;
    }

    @Override // vj.f
    public String b() {
        return this.f19174a.b();
    }

    @Override // vj.f
    public <RequestT, ResponseT> vj.k<RequestT, ResponseT> g(vj.w1<RequestT, ResponseT> w1Var, vj.e eVar) {
        return this.f19174a.g(w1Var, eVar);
    }

    @Override // vj.r1
    public boolean h(long j10, TimeUnit timeUnit) throws InterruptedException {
        return this.f19174a.h(j10, timeUnit);
    }

    @Override // vj.r1
    public void i() {
        this.f19174a.i();
    }

    @Override // vj.r1
    public vj.u l(boolean z10) {
        return this.f19174a.l(z10);
    }

    @Override // vj.r1
    public boolean o() {
        return this.f19174a.o();
    }

    @Override // vj.r1
    public boolean p() {
        return this.f19174a.p();
    }

    @Override // vj.r1
    public void q(vj.u uVar, Runnable runnable) {
        this.f19174a.q(uVar, runnable);
    }

    @Override // vj.r1
    public void r() {
        this.f19174a.r();
    }

    @Override // vj.r1
    public vj.r1 s() {
        return this.f19174a.s();
    }

    @Override // vj.r1
    public vj.r1 t() {
        return this.f19174a.t();
    }

    public String toString() {
        return c1.z.c(this).j("delegate", this.f19174a).toString();
    }
}
