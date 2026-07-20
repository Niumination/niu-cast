package ck;

import c1.z;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import vj.c3;
import vj.d0;
import vj.e0;
import vj.o1;
import vj.r1;
import vj.s1;
import vj.u;
import vj.x1;
import vj.z1;

/* JADX INFO: loaded from: classes2.dex */
@e0("https://github.com/grpc/grpc-java/issues/1771")
public abstract class f extends o1.f {
    @Override // vj.o1.f
    public r1 a(List<d0> list, String str) {
        return t().a(list, str);
    }

    @Override // vj.o1.f
    public r1 b(d0 d0Var, String str) {
        return t().b(d0Var, str);
    }

    @Override // vj.o1.f
    public r1 c(String str) {
        return t().c(str);
    }

    @Override // vj.o1.f
    @Deprecated
    public s1<?> d(String str) {
        return t().d(str);
    }

    @Override // vj.o1.f
    public s1<?> e(String str, vj.g gVar) {
        return t().e(str, gVar);
    }

    @Override // vj.o1.f
    public o1.j f(o1.b bVar) {
        return t().f(bVar);
    }

    @Override // vj.o1.f
    public String g() {
        return t().g();
    }

    @Override // vj.o1.f
    public vj.g h() {
        return t().h();
    }

    @Override // vj.o1.f
    public vj.h i() {
        return t().i();
    }

    @Override // vj.o1.f
    public x1.b j() {
        return t().j();
    }

    @Override // vj.o1.f
    public z1 k() {
        return t().k();
    }

    @Override // vj.o1.f
    public ScheduledExecutorService l() {
        return t().l();
    }

    @Override // vj.o1.f
    public c3 m() {
        return t().m();
    }

    @Override // vj.o1.f
    public vj.g n() {
        return t().n();
    }

    @Override // vj.o1.f
    @Deprecated
    public void o() {
        t().o();
    }

    @Override // vj.o1.f
    public void p() {
        t().p();
    }

    @Override // vj.o1.f
    public void q(u uVar, o1.k kVar) {
        t().q(uVar, kVar);
    }

    @Override // vj.o1.f
    public void r(r1 r1Var, List<d0> list) {
        t().r(r1Var, list);
    }

    @Override // vj.o1.f
    public void s(r1 r1Var, d0 d0Var) {
        t().s(r1Var, d0Var);
    }

    public abstract o1.f t();

    public String toString() {
        return z.c(this).j("delegate", t()).toString();
    }
}
