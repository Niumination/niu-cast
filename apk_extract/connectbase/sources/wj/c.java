package wj;

import androidx.core.app.NotificationCompat;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c extends d implements z2, u1.d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ boolean f18347e = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u1 f18348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i3 f18349b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f18350c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f18351d;

    public interface a {
        void a(vj.y2 y2Var);

        void d(vj.v1 v1Var, boolean z10);

        void e(vj.v1 v1Var, boolean z10, vj.y2 y2Var);

        void f(r3 r3Var, boolean z10, int i10);
    }

    public static abstract class b extends d.a {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f18352k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public a3 f18353l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final i3 f18354m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f18355n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f18356o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public boolean f18357p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public Runnable f18358q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        @gm.j
        public vj.y2 f18359r;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ vj.y2 f18360a;

            public a(vj.y2 y2Var) {
                this.f18360a = y2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.E(this.f18360a);
            }
        }

        /* JADX INFO: renamed from: wj.c$b$b, reason: collision with other inner class name */
        public class RunnableC0473b implements Runnable {
            public RunnableC0473b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.E(vj.y2.f17548e);
            }
        }

        public b(int i10, i3 i3Var, q3 q3Var) {
            super(i10, i3Var, (q3) c1.h0.F(q3Var, "transportTracer"));
            this.f18355n = false;
            this.f18356o = false;
            this.f18357p = false;
            this.f18354m = (i3) c1.h0.F(i3Var, "statsTraceCtx");
        }

        public final void E(vj.y2 y2Var) {
            c1.h0.g0((y2Var.r() && this.f18359r == null) ? false : true);
            if (this.f18352k) {
                return;
            }
            if (y2Var.r()) {
                this.f18354m.q(this.f18359r);
                n().h(this.f18359r.r());
            } else {
                this.f18354m.q(y2Var);
                n().h(false);
            }
            this.f18352k = true;
            u();
            p().e(y2Var);
        }

        public void F() {
            if (this.f18356o) {
                this.f18358q = null;
                E(vj.y2.f17548e);
            } else {
                this.f18358q = new RunnableC0473b();
                this.f18357p = true;
                k(true);
            }
        }

        public void G(i2 i2Var, boolean z10) {
            c1.h0.h0(!this.f18355n, "Past end of stream");
            l(i2Var);
            if (z10) {
                this.f18355n = true;
                k(false);
            }
        }

        @Override // wj.d.a
        /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
        public a3 p() {
            return this.f18353l;
        }

        public final void I(vj.y2 y2Var) {
            c1.h0.h0(this.f18359r == null, "closedStatus can only be set once");
            this.f18359r = y2Var;
        }

        public final void J(a3 a3Var) {
            c1.h0.h0(this.f18353l == null, "setListener should be called only once");
            this.f18353l = (a3) c1.h0.F(a3Var, "listener");
        }

        public final void K(vj.y2 y2Var) {
            c1.h0.e(!y2Var.r(), "status must not be OK");
            if (this.f18356o) {
                this.f18358q = null;
                E(y2Var);
            } else {
                this.f18358q = new a(y2Var);
                this.f18357p = true;
                k(true);
            }
        }

        @Override // wj.t1.b
        public void e(boolean z10) {
            this.f18356o = true;
            if (this.f18355n && !this.f18357p) {
                if (z10) {
                    vj.y2 y2VarU = vj.y2.f17562s.u("Encountered end-of-stream mid-frame");
                    y2VarU.getClass();
                    c(new vj.a3(y2VarU));
                    this.f18358q = null;
                    return;
                }
                this.f18353l.c();
            }
            Runnable runnable = this.f18358q;
            if (runnable != null) {
                runnable.run();
                this.f18358q = null;
            }
        }

        @Override // wj.d.a
        public final void t() {
            super.t();
            n().g();
        }
    }

    public c(s3 s3Var, i3 i3Var) {
        this.f18349b = (i3) c1.h0.F(i3Var, "statsTraceCtx");
        this.f18348a = new u1(this, s3Var, i3Var);
    }

    @Override // wj.d
    public t0 A() {
        return this.f18348a;
    }

    public abstract a D();

    public final void E(vj.v1 v1Var, vj.y2 y2Var) {
        vj.v1.i<vj.y2> iVar = vj.l1.f17168b;
        v1Var.j(iVar);
        vj.v1.i<String> iVar2 = vj.l1.f17167a;
        v1Var.j(iVar2);
        v1Var.w(iVar, y2Var);
        String str = y2Var.f17569b;
        if (str != null) {
            v1Var.w(iVar2, str);
        }
    }

    public final u1 F() {
        return this.f18348a;
    }

    @Override // wj.d
    /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
    public abstract b C();

    @Override // wj.z2
    public final void a(vj.y2 y2Var) {
        D().a(y2Var);
    }

    @Override // wj.z2
    public vj.a c() {
        return vj.a.f17046c;
    }

    @Override // wj.z2
    public final void d(vj.v1 v1Var, boolean z10) {
        c1.h0.F(v1Var, "headers");
        this.f18351d = true;
        D().d(v1Var, z10);
    }

    @Override // wj.z2
    public i3 g() {
        return this.f18349b;
    }

    @Override // wj.z2
    public final void k(vj.z zVar) {
        C().y((vj.z) c1.h0.F(zVar, "decompressor"));
    }

    @Override // wj.d, wj.z2
    public void l(int i10) {
        super.l(i10);
    }

    @Override // wj.z2
    public final void p(vj.y2 y2Var, vj.v1 v1Var) {
        c1.h0.F(y2Var, NotificationCompat.CATEGORY_STATUS);
        c1.h0.F(v1Var, "trailers");
        if (this.f18350c) {
            return;
        }
        this.f18350c = true;
        z();
        E(v1Var, y2Var);
        C().I(y2Var);
        D().e(v1Var, this.f18351d, y2Var);
    }

    @Override // wj.z2
    public String q() {
        return null;
    }

    @Override // wj.d, wj.j3
    public final boolean s() {
        return super.s();
    }

    @Override // wj.z2
    public final void u(a3 a3Var) {
        C().J(a3Var);
    }

    @Override // wj.u1.d
    public final void w(r3 r3Var, boolean z10, boolean z11, int i10) {
        if (r3Var == null) {
            return;
        }
        if (z10) {
            z11 = false;
        }
        D().f(r3Var, z11, i10);
    }
}
