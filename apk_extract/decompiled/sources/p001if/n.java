package p001if;

import java.util.concurrent.atomic.AtomicLong;
import k3.t8;
import o6.a;
import ze.b;
import ze.p1;
import ze.q2;

/* JADX INFO: loaded from: classes3.dex */
public final class n extends ze.n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ze.n f5831b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ p f5832c;

    public n(p pVar, ze.n nVar) {
        this.f5832c = pVar;
        this.f5831b = nVar;
    }

    @Override // ze.n
    public final void a() {
        this.f5831b.a();
    }

    @Override // ze.n
    public final void b() {
        this.f5831b.b();
    }

    @Override // ze.n
    public final void c(int i8) {
        this.f5831b.c(i8);
    }

    @Override // ze.n
    public final void d(int i8, long j8) {
        this.f5831b.d(i8, j8);
    }

    @Override // ze.n
    public final void e(p1 p1Var) {
        this.f5831b.e(p1Var);
    }

    @Override // ze.n
    public final void f(long j8) {
        this.f5831b.f(j8);
    }

    @Override // ze.n
    public final void g(long j8) {
        this.f5831b.g(j8);
    }

    @Override // ze.n
    public final void h() {
        this.f5831b.h();
    }

    @Override // ze.n
    public final void i(int i8) {
        this.f5831b.i(i8);
    }

    @Override // ze.n
    public final void j(int i8, long j8, long j10) {
        this.f5831b.j(i8, j8, j10);
    }

    @Override // ze.n
    public final void k(long j8) {
        this.f5831b.k(j8);
    }

    @Override // ze.n
    public final void l(long j8) {
        this.f5831b.l(j8);
    }

    @Override // ze.n
    public final void m(q2 q2Var) {
        i iVar = this.f5832c.f5834a;
        boolean zE = q2Var.e();
        m mVar = iVar.f5814a;
        if (mVar.e != null || mVar.f != null) {
            if (zE) {
                ((AtomicLong) iVar.f5815b.f92a).getAndIncrement();
            } else {
                ((AtomicLong) iVar.f5815b.f93b).getAndIncrement();
            }
        }
        this.f5831b.m(q2Var);
    }

    @Override // ze.n
    public final void n(b bVar, p1 p1Var) {
        this.f5831b.n(bVar, p1Var);
    }

    public final String toString() {
        a aVarA = t8.a(this);
        aVarA.d(this.f5831b, "delegate");
        return aVarA.toString();
    }
}
