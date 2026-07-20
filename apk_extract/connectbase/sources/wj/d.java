package wj;

import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d implements j3 {

    public static abstract class a implements f.h, t1.b {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @b1.e
        public static final int f18440j = 32768;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public b0 f18441a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f18442b = new Object();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final i3 f18443c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final q3 f18444d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final t1 f18445e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @hm.a("onReadyLock")
        public int f18446f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @hm.a("onReadyLock")
        public boolean f18447g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @hm.a("onReadyLock")
        public boolean f18448h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @hm.a("onReadyLock")
        public int f18449i;

        /* JADX INFO: renamed from: wj.d$a$a, reason: collision with other inner class name */
        public class RunnableC0474a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ fm.b f18450a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f18451b;

            public RunnableC0474a(fm.b bVar, int i10) {
                this.f18450a = bVar;
                this.f18451b = i10;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    fm.f fVarZ = fm.c.z("AbstractStream.request");
                    try {
                        fm.c.n(this.f18450a);
                        a.this.f18441a.b(this.f18451b);
                        if (fVarZ != null) {
                            fm.c.u();
                        }
                    } catch (Throwable th2) {
                        if (fVarZ != null) {
                            try {
                                fm.c.u();
                            } catch (Throwable th3) {
                                th2.addSuppressed(th3);
                            }
                        }
                        throw th2;
                    }
                } catch (Throwable th4) {
                    a.this.c(th4);
                }
            }
        }

        public a(int i10, i3 i3Var, q3 q3Var) {
            this.f18443c = (i3) c1.h0.F(i3Var, "statsTraceCtx");
            this.f18444d = (q3) c1.h0.F(q3Var, "transportTracer");
            t1 t1Var = new t1(this, vj.p.b.f17223a, i10, i3Var, q3Var);
            this.f18445e = t1Var;
            this.f18441a = t1Var;
            this.f18449i = 32768;
        }

        public final void A(int i10) {
            this.f18441a.h(i10);
        }

        public void B(int i10) {
            synchronized (this.f18442b) {
                this.f18449i = i10;
            }
        }

        @Override // wj.t1.b
        public void a(k3.a aVar) {
            p().a(aVar);
        }

        public final void k(boolean z10) {
            if (z10) {
                this.f18441a.close();
            } else {
                this.f18441a.p();
            }
        }

        public final void l(i2 i2Var) {
            try {
                this.f18441a.n(i2Var);
            } catch (Throwable th2) {
                c(th2);
            }
        }

        public final i3 m() {
            return this.f18443c;
        }

        public q3 n() {
            return this.f18444d;
        }

        public final boolean o() {
            boolean z10;
            synchronized (this.f18442b) {
                try {
                    z10 = this.f18447g && this.f18446f < this.f18449i && !this.f18448h;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return z10;
        }

        public abstract k3 p();

        public final void q() {
            boolean zO;
            synchronized (this.f18442b) {
                zO = o();
            }
            if (zO) {
                p().d();
            }
        }

        public final void r(int i10) {
            synchronized (this.f18442b) {
                this.f18446f += i10;
            }
        }

        public final void s(int i10) {
            boolean z10;
            synchronized (this.f18442b) {
                c1.h0.h0(this.f18447g, "onStreamAllocated was not called, but it seems the stream is active");
                int i11 = this.f18446f;
                int i12 = this.f18449i;
                z10 = false;
                boolean z11 = i11 < i12;
                int i13 = i11 - i10;
                this.f18446f = i13;
                boolean z12 = i13 < i12;
                if (!z11 && z12) {
                    z10 = true;
                }
            }
            if (z10) {
                q();
            }
        }

        public void t() {
            c1.h0.g0(p() != null);
            synchronized (this.f18442b) {
                c1.h0.h0(!this.f18447g, "Already allocated");
                this.f18447g = true;
            }
            q();
        }

        public final void u() {
            synchronized (this.f18442b) {
                this.f18448h = true;
            }
        }

        public final void v() {
            this.f18445e.f0(this);
            this.f18441a = this.f18445e;
        }

        public final void w(int i10) {
            if (!(this.f18441a instanceof m3)) {
                f(new RunnableC0474a(fm.c.o(), i10));
                return;
            }
            fm.f fVarZ = fm.c.z("AbstractStream.request");
            try {
                this.f18441a.b(i10);
                if (fVarZ != null) {
                    fm.c.u();
                }
            } catch (Throwable th2) {
                if (fVarZ != null) {
                    try {
                        fm.c.u();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }

        @b1.e
        public final void x(int i10) {
            w(i10);
        }

        public final void y(vj.z zVar) {
            this.f18441a.k(zVar);
        }

        public void z(w0 w0Var) {
            this.f18445e.o(w0Var);
            this.f18441a = new f(this, this, this.f18445e);
        }
    }

    public abstract t0 A();

    public final void B(int i10) {
        C().r(i10);
    }

    public abstract a C();

    @Override // wj.j3
    public final void b(int i10) {
        C().w(i10);
    }

    @Override // wj.j3
    public final void e(boolean z10) {
        A().e(z10);
    }

    @Override // wj.j3
    public final void f(vj.s sVar) {
        A().f((vj.s) c1.h0.F(sVar, "compressor"));
    }

    @Override // wj.j3
    public final void flush() {
        if (A().g()) {
            return;
        }
        A().flush();
    }

    @Override // wj.j3
    public final void j(InputStream inputStream) {
        c1.h0.F(inputStream, "message");
        try {
            if (!A().g()) {
                A().h(inputStream);
            }
        } finally {
            v0.e(inputStream);
        }
    }

    public void l(int i10) {
        C().B(i10);
    }

    @Override // wj.j3
    public void n() {
        C().v();
    }

    @Override // wj.j3
    public boolean s() {
        return C().o();
    }

    public final void z() {
        A().close();
    }
}
