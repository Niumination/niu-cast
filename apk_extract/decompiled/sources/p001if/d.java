package p001if;

import af.l;
import k3.t8;
import k3.v8;
import o6.a;
import ze.b1;
import ze.c1;
import ze.q;
import ze.q2;
import ze.y0;
import ze.z0;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends b1 {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final l f5794m = new l(1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f5795d;
    public final a e;
    public c1 f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b1 f5796g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public c1 f5797h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public b1 f5798i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public q f5799j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public z0 f5800k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f5801l;

    public d(a aVar) {
        b bVar = new b(this);
        this.f5795d = bVar;
        this.f5796g = bVar;
        this.f5798i = bVar;
        this.e = aVar;
    }

    @Override // ze.b1
    public final boolean b() {
        return g().b();
    }

    @Override // ze.b1
    public final void c(q2 q2Var) {
        g().c(q2Var);
    }

    @Override // ze.b1
    public final void d(y0 y0Var) {
        g().d(y0Var);
    }

    @Override // ze.b1
    public final void e() {
        g().e();
    }

    @Override // ze.b1
    public final void f() {
        this.f5798i.f();
        this.f5796g.f();
    }

    public final b1 g() {
        b1 b1Var = this.f5798i;
        return b1Var == this.f5795d ? this.f5796g : b1Var;
    }

    public final void h() {
        this.e.m(this.f5799j, this.f5800k);
        this.f5796g.f();
        this.f5796g = this.f5798i;
        this.f = this.f5797h;
        this.f5798i = this.f5795d;
        this.f5797h = null;
    }

    public final void i(c1 c1Var) {
        v8.i(c1Var, "newBalancerFactory");
        if (c1Var.equals(this.f5797h)) {
            return;
        }
        this.f5798i.f();
        this.f5798i = this.f5795d;
        this.f5797h = null;
        this.f5799j = q.CONNECTING;
        this.f5800k = f5794m;
        if (c1Var.equals(this.f)) {
            return;
        }
        c cVar = new c(this);
        b1 b1VarD = c1Var.d(cVar);
        cVar.f5792b = b1VarD;
        this.f5798i = b1VarD;
        this.f5797h = c1Var;
        if (this.f5801l) {
            return;
        }
        h();
    }

    public final String toString() {
        a aVarA = t8.a(this);
        aVarA.d(g(), "delegate");
        return aVarA.toString();
    }
}
