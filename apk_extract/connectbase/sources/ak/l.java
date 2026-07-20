package ak;

import c1.h0;
import vj.a3;
import vj.k2;
import vj.m2;
import vj.v1;
import vj.w1;
import vj.y2;

/* JADX INFO: loaded from: classes2.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @b1.e
    public static final String f294a = "Too many requests";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @b1.e
    public static final String f295b = "Half-closed without a request";

    public interface a<ReqT, RespT> extends f<ReqT, RespT> {
        @Override // ak.l.f
        m<ReqT> invoke(m<RespT> mVar);
    }

    public interface b<ReqT, RespT> extends f<ReqT, RespT> {
        @Override // ak.l.f
        m<ReqT> invoke(m<RespT> mVar);
    }

    public static class c<V> implements m<V> {
        @Override // ak.m
        public void b() {
        }

        @Override // ak.m
        public void c(V v10) {
        }

        @Override // ak.m
        public void onError(Throwable th2) {
        }
    }

    public static final class d<ReqT, RespT> extends k<RespT> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final k2<ReqT, RespT> f296a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f297b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile boolean f298c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f299d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f301f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Runnable f302g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Runnable f303h;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Runnable f306k;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f300e = true;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f304i = false;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f305j = false;

        public d(k2<ReqT, RespT> k2Var, boolean z10) {
            this.f296a = k2Var;
            this.f297b = z10;
        }

        public static void o(d dVar) {
            dVar.f299d = true;
        }

        private void t() {
            this.f299d = true;
        }

        @Override // ak.m
        public void b() {
            this.f296a.a(y2.f17548e, new v1());
            this.f305j = true;
        }

        @Override // ak.m
        public void c(RespT respt) {
            if (this.f298c && this.f297b) {
                y2 y2VarU = y2.f17549f.u("call already cancelled. Use ServerCallStreamObserver.setOnCancelHandler() to disable this exception");
                y2VarU.getClass();
                throw new a3(y2VarU);
            }
            h0.h0(!this.f304i, "Stream was terminated by error, no further calls are allowed");
            h0.h0(!this.f305j, "Stream is already completed, no further calls are allowed");
            if (!this.f301f) {
                this.f296a.i(new v1());
                this.f301f = true;
            }
            this.f296a.j(respt);
        }

        @Override // ak.e
        public void d() {
            i();
        }

        @Override // ak.k, ak.e
        public boolean e() {
            return this.f296a.g();
        }

        @Override // ak.k, ak.e
        public void f(int i10) {
            this.f296a.h(i10);
        }

        @Override // ak.k, ak.e
        public void g(boolean z10) {
            this.f296a.l(z10);
        }

        @Override // ak.k, ak.e
        public void h(Runnable runnable) {
            h0.h0(!this.f299d, "Cannot alter onReadyHandler after initialization. May only be called during the initial call to the application, before the service returns its StreamObserver");
            this.f302g = runnable;
        }

        @Override // ak.k
        public void i() {
            h0.h0(!this.f299d, "Cannot disable auto flow control after initialization");
            this.f300e = false;
        }

        @Override // ak.k
        public boolean j() {
            return this.f296a.f();
        }

        @Override // ak.k
        public void k(String str) {
            this.f296a.k(str);
        }

        @Override // ak.k
        public void l(Runnable runnable) {
            h0.h0(!this.f299d, "Cannot alter onCancelHandler after initialization. May only be called during the initial call to the application, before the service returns its StreamObserver");
            this.f303h = runnable;
        }

        @Override // ak.k
        public void m(Runnable runnable) {
            h0.h0(!this.f299d, "Cannot alter onCloseHandler after initialization. May only be called during the initial call to the application, before the service returns its StreamObserver");
            this.f306k = runnable;
        }

        @Override // ak.k
        public void n(int i10) {
            h0.h0(!this.f299d, "Cannot alter setOnReadyThreshold after initialization. May only be called during the initial call to the application, before the service returns its StreamObserver");
            this.f296a.m(i10);
        }

        @Override // ak.m
        public void onError(Throwable th2) {
            v1 v1VarS = y2.s(th2);
            if (v1VarS == null) {
                v1VarS = new v1();
            }
            this.f296a.a(y2.n(th2), v1VarS);
            this.f304i = true;
        }
    }

    public interface e<ReqT, RespT> extends i<ReqT, RespT> {
        @Override // ak.l.i
        void invoke(ReqT reqt, m<RespT> mVar);
    }

    public interface f<ReqT, RespT> {
        m<ReqT> invoke(m<RespT> mVar);
    }

    public static final class g<ReqT, RespT> implements m2<ReqT, RespT> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f<ReqT, RespT> f307a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f308b;

        public final class a extends k2.a<ReqT> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final m<ReqT> f309a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final d<ReqT, RespT> f310b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final k2<ReqT, RespT> f311c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public boolean f312d = false;

            public a(m<ReqT> mVar, d<ReqT, RespT> dVar, k2<ReqT, RespT> k2Var) {
                this.f309a = mVar;
                this.f310b = dVar;
                this.f311c = k2Var;
            }

            @Override // vj.k2.a
            public void a() {
                d<ReqT, RespT> dVar = this.f310b;
                Runnable runnable = dVar.f303h;
                if (runnable != null) {
                    runnable.run();
                } else {
                    dVar.f298c = true;
                }
                if (this.f312d) {
                    return;
                }
                m<ReqT> mVar = this.f309a;
                y2 y2VarU = y2.f17549f.u("client cancelled");
                y2VarU.getClass();
                mVar.onError(new a3(y2VarU));
            }

            @Override // vj.k2.a
            public void b() {
                Runnable runnable = this.f310b.f306k;
                if (runnable != null) {
                    runnable.run();
                }
            }

            @Override // vj.k2.a
            public void c() {
                this.f312d = true;
                this.f309a.b();
            }

            @Override // vj.k2.a
            public void d(ReqT reqt) {
                this.f309a.c(reqt);
                if (this.f310b.f300e) {
                    this.f311c.h(1);
                }
            }

            @Override // vj.k2.a
            public void e() {
                Runnable runnable = this.f310b.f302g;
                if (runnable != null) {
                    runnable.run();
                }
            }
        }

        public g(f<ReqT, RespT> fVar, boolean z10) {
            this.f307a = fVar;
            this.f308b = z10;
        }

        @Override // vj.m2
        public k2.a<ReqT> a(k2<ReqT, RespT> k2Var, v1 v1Var) {
            d dVar = new d(k2Var, this.f308b);
            m<ReqT> mVarInvoke = this.f307a.invoke(dVar);
            dVar.f299d = true;
            if (dVar.f300e) {
                k2Var.h(1);
            }
            return new a(mVarInvoke, dVar, k2Var);
        }
    }

    public interface h<ReqT, RespT> extends i<ReqT, RespT> {
        @Override // ak.l.i
        void invoke(ReqT reqt, m<RespT> mVar);
    }

    public interface i<ReqT, RespT> {
        void invoke(ReqT reqt, m<RespT> mVar);
    }

    public static final class j<ReqT, RespT> implements m2<ReqT, RespT> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final i<ReqT, RespT> f314a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f315b;

        public final class a extends k2.a<ReqT> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final k2<ReqT, RespT> f316a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final d<ReqT, RespT> f317b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public boolean f318c = true;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public boolean f319d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public ReqT f320e;

            public a(d<ReqT, RespT> dVar, k2<ReqT, RespT> k2Var) {
                this.f316a = k2Var;
                this.f317b = dVar;
            }

            @Override // vj.k2.a
            public void a() {
                d<ReqT, RespT> dVar = this.f317b;
                Runnable runnable = dVar.f303h;
                if (runnable != null) {
                    runnable.run();
                } else {
                    dVar.f298c = true;
                }
            }

            @Override // vj.k2.a
            public void b() {
                Runnable runnable = this.f317b.f306k;
                if (runnable != null) {
                    runnable.run();
                }
            }

            @Override // vj.k2.a
            public void c() {
                if (this.f318c) {
                    ReqT reqt = this.f320e;
                    if (reqt == null) {
                        this.f316a.a(y2.f17562s.u(l.f295b), new v1());
                        return;
                    }
                    j.this.f314a.invoke(reqt, this.f317b);
                    this.f320e = null;
                    this.f317b.f299d = true;
                    if (this.f319d) {
                        e();
                    }
                }
            }

            @Override // vj.k2.a
            public void d(ReqT reqt) {
                if (this.f320e == null) {
                    this.f320e = reqt;
                } else {
                    this.f316a.a(y2.f17562s.u(l.f294a), new v1());
                    this.f318c = false;
                }
            }

            @Override // vj.k2.a
            public void e() {
                this.f319d = true;
                Runnable runnable = this.f317b.f302g;
                if (runnable != null) {
                    runnable.run();
                }
            }
        }

        public j(i<ReqT, RespT> iVar, boolean z10) {
            this.f314a = iVar;
            this.f315b = z10;
        }

        @Override // vj.m2
        public k2.a<ReqT> a(k2<ReqT, RespT> k2Var, v1 v1Var) {
            h0.e(k2Var.d().f17480a.clientSendsOneMessage(), "asyncUnaryRequestCall is only for clientSendsOneMessage methods");
            d dVar = new d(k2Var, this.f315b);
            k2Var.h(2);
            return new a(dVar, k2Var);
        }
    }

    public static <ReqT, RespT> m2<ReqT, RespT> a(a<ReqT, RespT> aVar) {
        return new g(aVar, true);
    }

    public static <ReqT, RespT> m2<ReqT, RespT> b(b<ReqT, RespT> bVar) {
        return new g(bVar, false);
    }

    public static <ReqT, RespT> m2<ReqT, RespT> c(e<ReqT, RespT> eVar) {
        return new j(eVar, true);
    }

    public static <ReqT, RespT> m2<ReqT, RespT> d(h<ReqT, RespT> hVar) {
        return new j(hVar, false);
    }

    public static <ReqT> m<ReqT> e(w1<?, ?> w1Var, m<?> mVar) {
        f(w1Var, mVar);
        return new c();
    }

    public static void f(w1<?, ?> w1Var, m<?> mVar) {
        h0.F(w1Var, "methodDescriptor");
        h0.F(mVar, "responseObserver");
        y2 y2VarU = y2.f17561r.u(String.format("Method %s is unimplemented", w1Var.f17481b));
        y2VarU.getClass();
        mVar.onError(new a3(y2VarU));
    }
}
