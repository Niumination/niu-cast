package af;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c extends d6 implements b0, z3 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Logger f194i = Logger.getLogger(c.class.getName());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l6 f195c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i1 f196d;
    public final boolean e;
    public final boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ze.p1 f197g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f198h;

    public c(mg.a0 a0Var, h6 h6Var, l6 l6Var, ze.p1 p1Var, ze.f fVar, boolean z2) {
        v8.i(p1Var, "headers");
        v8.i(l6Var, "transportTracer");
        this.f195c = l6Var;
        this.e = !Boolean.TRUE.equals(fVar.a(l1.f423r));
        this.f = z2;
        if (!z2) {
            this.f196d = new a4(this, a0Var, h6Var);
            this.f197g = p1Var;
            return;
        }
        e8.b bVar = new e8.b();
        bVar.e = this;
        v8.i(p1Var, "headers");
        bVar.f4715b = p1Var;
        bVar.f4716c = h6Var;
        this.f196d = bVar;
    }

    @Override // af.b0
    public final void b(int i8) {
        this.f196d.b(i8);
    }

    @Override // af.b0
    public final void c(d0 d0Var) {
        cf.n nVar = (cf.n) this;
        cf.m mVar = nVar.f1600n;
        v8.n(mVar.f155j == null, "Already called setListener");
        v8.i(d0Var, "listener");
        mVar.f155j = d0Var;
        if (this.f) {
            return;
        }
        nVar.f1601o.A(this.f197g, null);
        this.f197g = null;
    }

    @Override // af.b0
    public final void d(ze.b0 b0Var) {
        cf.m mVar = ((cf.n) this).f1600n;
        v8.n(mVar.f155j == null, "Already called start");
        v8.i(b0Var, "decompressorRegistry");
        mVar.f156k = b0Var;
    }

    @Override // af.b0
    public final void f(int i8) {
        ((cf.n) this).f1600n.f301a.f647b = i8;
    }

    @Override // af.b0
    public final void h(ze.q2 q2Var) {
        v8.c("Should not cancel with OK status", !q2Var.e());
        this.f198h = true;
        se.e eVar = ((cf.n) this).f1601o;
        eVar.getClass();
        ph.b.d();
        try {
            synchronized (((cf.n) eVar.f9720b).f1600n.f1591w) {
                ((cf.n) eVar.f9720b).f1600n.x(q2Var, null, true);
            }
            ph.b.f8887a.getClass();
        } catch (Throwable th2) {
            try {
                ph.b.f8887a.getClass();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    @Override // af.i6
    public final boolean isReady() {
        return v().l() && !this.f198h;
    }

    @Override // af.b0
    public final void j(t1 t1Var) {
        t1Var.a(((cf.n) this).p.f11322a.get(ze.i.f11361a), "remote_addr");
    }

    @Override // af.b0
    public final void k() {
        cf.n nVar = (cf.n) this;
        if (nVar.f1600n.f159n) {
            return;
        }
        nVar.f1600n.f159n = true;
        o().close();
    }

    @Override // af.z3
    public final void l(cf.j0 j0Var, boolean z2, boolean z3, int i8) {
        qj.f fVar;
        v8.c("null frame before EOS", j0Var != null || z2);
        se.e eVar = ((cf.n) this).f1601o;
        eVar.getClass();
        ph.b.d();
        try {
            if (j0Var == null) {
                fVar = cf.n.f1595r;
            } else {
                fVar = j0Var.f1569a;
                int i9 = (int) fVar.f9195b;
                if (i9 > 0) {
                    h hVarV = ((cf.n) eVar.f9720b).v();
                    synchronized (hVarV.f302b) {
                        hVarV.e += i9;
                    }
                }
            }
            synchronized (((cf.n) eVar.f9720b).f1600n.f1591w) {
                cf.m.w(((cf.n) eVar.f9720b).f1600n, fVar, z2, z3);
                l6 l6Var = ((cf.n) eVar.f9720b).f195c;
                if (i8 == 0) {
                    l6Var.getClass();
                } else {
                    ((k2) l6Var.f446b).g();
                }
            }
            ph.b.f8887a.getClass();
        } catch (Throwable th2) {
            try {
                ph.b.f8887a.getClass();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    @Override // af.b0
    public final void m(ze.z zVar) {
        ze.p1 p1Var = this.f197g;
        ze.k1 k1Var = l1.f413d;
        p1Var.a(k1Var);
        this.f197g.f(k1Var, Long.valueOf(Math.max(0L, zVar.f(TimeUnit.NANOSECONDS))));
    }

    @Override // af.d6
    public final i1 o() {
        return this.f196d;
    }
}
