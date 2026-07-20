package cf;

import af.h6;
import af.j6;
import af.k2;
import af.l6;
import af.z5;
import k3.v8;
import ze.q2;
import ze.s2;

/* JADX INFO: loaded from: classes3.dex */
public final class a0 extends af.h implements k0, g0 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f1467h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public z5 f1468i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final h6 f1469j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f1470k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f1471l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f1472m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Runnable f1473n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public q2 f1474o;
    public final h0 p;
    public final int q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f1475r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Object f1476s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f1477t;
    public int u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f1478v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final e f1479w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final o0 f1480x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f1481y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final l0 f1482z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(h0 h0Var, int i8, int i9, h6 h6Var, Object obj, e eVar, o0 o0Var, int i10, l6 l6Var) {
        super(i9, h6Var, l6Var);
        v8.i(l6Var, "transportTracer");
        this.f1470k = false;
        this.f1471l = false;
        this.f1472m = false;
        this.f1469j = h6Var;
        this.f1477t = false;
        this.p = h0Var;
        this.q = i8;
        v8.i(obj, "lock");
        this.f1476s = obj;
        this.f1479w = eVar;
        this.f1480x = o0Var;
        this.u = i10;
        this.f1478v = i10;
        this.f1475r = i10;
        ph.b.f8887a.getClass();
        this.f1482z = new l0(o0Var, i8, o0Var.f1603a, this);
    }

    @Override // cf.g0
    public final void b(boolean z2, int i8, qj.f fVar, int i9) {
        synchronized (this.f1476s) {
            try {
                ph.b.b();
                if (z2) {
                    this.f1481y = true;
                }
                this.u -= i8 + i9;
                this.f1478v -= i9;
                v vVar = new v(fVar);
                v8.n(!this.f1470k, "Past end of stream");
                try {
                    this.f301a.a(vVar);
                } catch (Throwable th2) {
                    j(th2);
                }
                if (z2) {
                    this.f1470k = true;
                    i(false);
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    @Override // cf.g0
    public final int c() {
        int i8;
        synchronized (this.f1476s) {
            i8 = this.u;
        }
        return i8;
    }

    @Override // cf.g0
    public final void d(q2 q2Var) {
        ph.b.b();
        f(q2Var);
    }

    @Override // cf.g0
    public final boolean e() {
        boolean z2;
        synchronized (this.f1476s) {
            z2 = this.f1481y;
        }
        return z2;
    }

    @Override // cf.g0
    public final void f(q2 q2Var) {
        v8.c("status must not be OK", !q2Var.e());
        if (this.f1471l) {
            this.f1473n = null;
            p(q2Var);
        } else {
            this.f1473n = new af.e(0, this, q2Var);
            this.f1472m = true;
            i(true);
        }
    }

    @Override // cf.g0
    public final l0 g() {
        return this.f1482z;
    }

    @Override // af.h
    public final void h(int i8) {
        int i9 = this.f1478v - i8;
        this.f1478v = i9;
        float f = i9;
        int i10 = this.f1475r;
        if (f <= i10 * 0.5f) {
            int i11 = i10 - i9;
            this.u += i11;
            this.f1478v = i9 + i11;
            e eVar = this.f1479w;
            eVar.d(this.q, i11);
            eVar.flush();
        }
    }

    @Override // af.h
    public final void j(Throwable th2) {
        ef.a aVar = ef.a.INTERNAL_ERROR;
        q2 q2VarD = q2.d(th2);
        if (this.f1477t) {
            return;
        }
        this.f1477t = true;
        e eVar = this.f1479w;
        int i8 = this.q;
        eVar.f(i8, aVar);
        f(q2VarD);
        this.p.l(i8, true);
    }

    @Override // af.h
    public final void k(boolean z2) {
        this.f1471l = true;
        if (this.f1470k && !this.f1472m) {
            if (z2) {
                j(new s2(q2.f11410m.h("Encountered end-of-stream mid-frame")));
                this.f1473n = null;
                return;
            }
            this.f1468i.n();
        }
        Runnable runnable = this.f1473n;
        if (runnable != null) {
            runnable.run();
            this.f1473n = null;
        }
    }

    @Override // af.h
    public final j6 m() {
        return this.f1468i;
    }

    @Override // af.h
    public final void n() {
        super.n();
        l6 l6Var = this.f303c;
        l6Var.getClass();
        ((k2) l6Var.f446b).g();
    }

    @Override // af.h
    public final void o(Runnable runnable) {
        synchronized (this.f1476s) {
            runnable.run();
        }
    }

    public final void p(q2 q2Var) {
        v8.m((q2Var.e() && this.f1474o == null) ? false : true);
        if (this.f1467h) {
            return;
        }
        boolean zE = q2Var.e();
        l6 l6Var = this.f303c;
        h6 h6Var = this.f1469j;
        if (zE) {
            h6Var.b(this.f1474o);
            this.f1474o.e();
            l6Var.getClass();
        } else {
            h6Var.b(q2Var);
            l6Var.getClass();
        }
        this.f1467h = true;
        synchronized (this.f302b) {
            this.f305g = true;
        }
        this.f1468i.p(q2Var);
    }
}
