package af;

import java.util.concurrent.Executor;
import k3.t8;
import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public final class y2 extends ze.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ze.p0 f712a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c3 f713b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f714c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ze.r1 f715d;
    public final ze.y e;
    public ze.f f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ze.j f716g;

    public y2(ze.p0 p0Var, c3 c3Var, Executor executor, ze.r1 r1Var, ze.f fVar) {
        this.f712a = p0Var;
        this.f713b = c3Var;
        this.f715d = r1Var;
        Executor executor2 = fVar.f11348b;
        executor = executor2 != null ? executor2 : executor;
        this.f714c = executor;
        ze.d dVarB = ze.f.b(fVar);
        dVarB.f11336b = executor;
        this.f = new ze.f(dVarB);
        this.e = ze.y.i();
    }

    @Override // ze.j
    public final void a(String str, Throwable th2) {
        ze.j jVar = this.f716g;
        if (jVar != null) {
            jVar.a(str, th2);
        }
    }

    @Override // ze.j
    public final void b() {
        this.f716g.b();
    }

    @Override // ze.j
    public final boolean c() {
        return this.f716g.c();
    }

    @Override // ze.j
    public final void d(int i8) {
        this.f716g.d(i8);
    }

    @Override // ze.j
    public final void e(Object obj) {
        this.f716g.e(obj);
    }

    @Override // ze.j
    public final void f(ze.f0 f0Var, ze.p1 p1Var) {
        ze.f fVar = this.f;
        ze.r1 r1Var = this.f715d;
        v8.i(r1Var, "method");
        v8.i(fVar, "callOptions");
        o4.a aVarA = this.f712a.a();
        aVarA.getClass();
        ze.q2 q2Var = ze.q2.e;
        if (!q2Var.e()) {
            this.f714c.execute(new p0(this, f0Var, l1.j(q2Var)));
            this.f716g = j3.j0;
            return;
        }
        p3 p3Var = (p3) aVarA.f8369a;
        p3Var.getClass();
        n3 n3Var = (n3) p3Var.f501b.get(r1Var.f11423b);
        if (n3Var == null) {
            n3Var = (n3) p3Var.f502c.get(r1Var.f11424c);
        }
        if (n3Var == null) {
            n3Var = p3Var.f500a;
        }
        if (n3Var != null) {
            this.f = this.f.e(n3.f465g, n3Var);
        }
        ze.j jVarE = this.f713b.e(r1Var, this.f);
        this.f716g = jVarE;
        jVarE.f(f0Var, p1Var);
    }

    public final String toString() {
        o6.a aVarA = t8.a(this);
        aVarA.d(this.f716g, "delegate");
        return aVarA.toString();
    }
}
