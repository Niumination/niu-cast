package wj;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class w2 extends vj.i2 implements vj.a1<vj.v0.j> {
    public static final Logger A = Logger.getLogger(w2.class.getName());
    public static final a3 B = new d();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final z1<? extends Executor> f19459c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Executor f19460d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final vj.o0 f19461e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final vj.o0 f19462f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<vj.v2> f19463g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final vj.o2[] f19464h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f19465i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @hm.a("lock")
    public boolean f19466j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @hm.a("lock")
    public boolean f19467k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @hm.a("lock")
    public vj.y2 f19468l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @hm.a("lock")
    public boolean f19469m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @hm.a("lock")
    public boolean f19470n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final d1 f19471o;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @hm.a("lock")
    public boolean f19473q;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final vj.w f19475s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final vj.a0 f19476t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final vj.t f19477u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final vj.b f19478v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final vj.v0 f19479w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final o f19480x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final vj.y.c f19481y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final vj.l2 f19482z;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Object f19472p = new Object();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @hm.a("lock")
    public final Set<b3> f19474r = new HashSet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final vj.c1 f19458b = vj.c1.b("Server", String.valueOf(U()));

    @b1.e
    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final vj.w.f f19483a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Throwable f19484b;

        public b(vj.w.f fVar, Throwable th2) {
            this.f19483a = fVar;
            this.f19484b = th2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f19483a.U0(this.f19484b);
        }
    }

    @b1.e
    public static final class c implements a3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Executor f19485a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Executor f19486b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final vj.w.f f19487c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final z2 f19488d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final fm.e f19489e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public a3 f19490f;

        public final class a extends a0 {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fm.b f19491b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ vj.y2 f19492c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(fm.b bVar, vj.y2 y2Var) {
                super(c.this.f19487c);
                this.f19491b = bVar;
                this.f19492c = y2Var;
            }

            @Override // wj.a0
            public void a() {
                fm.f fVarZ = fm.c.z("ServerCallListener(app).closed");
                try {
                    fm.c.a(c.this.f19489e);
                    fm.c.n(this.f19491b);
                    c.this.l().e(this.f19492c);
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
        }

        public final class b extends a0 {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fm.b f19494b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(fm.b bVar) {
                super(c.this.f19487c);
                this.f19494b = bVar;
            }

            @Override // wj.a0
            public void a() {
                try {
                    fm.f fVarZ = fm.c.z("ServerCallListener(app).halfClosed");
                    try {
                        fm.c.a(c.this.f19489e);
                        fm.c.n(this.f19494b);
                        c.this.l().c();
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
                    c.this.m(th4);
                    throw th4;
                }
            }
        }

        /* JADX INFO: renamed from: wj.w2$c$c, reason: collision with other inner class name */
        public final class C0480c extends a0 {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fm.b f19496b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ k3.a f19497c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0480c(fm.b bVar, k3.a aVar) {
                super(c.this.f19487c);
                this.f19496b = bVar;
                this.f19497c = aVar;
            }

            @Override // wj.a0
            public void a() {
                try {
                    fm.f fVarZ = fm.c.z("ServerCallListener(app).messagesAvailable");
                    try {
                        fm.c.a(c.this.f19489e);
                        fm.c.n(this.f19496b);
                        c.this.l().a(this.f19497c);
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
                    c.this.m(th4);
                    throw th4;
                }
            }
        }

        public final class d extends a0 {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ fm.b f19499b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(fm.b bVar) {
                super(c.this.f19487c);
                this.f19499b = bVar;
            }

            @Override // wj.a0
            public void a() {
                try {
                    fm.f fVarZ = fm.c.z("ServerCallListener(app).onReady");
                    try {
                        fm.c.a(c.this.f19489e);
                        fm.c.n(this.f19499b);
                        c.this.l().d();
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
                    c.this.m(th4);
                    throw th4;
                }
            }
        }

        public c(Executor executor, Executor executor2, z2 z2Var, vj.w.f fVar, fm.e eVar) {
            this.f19485a = executor;
            this.f19486b = executor2;
            this.f19488d = z2Var;
            this.f19487c = fVar;
            this.f19489e = eVar;
        }

        private void k(vj.y2 y2Var) {
            if (!y2Var.r()) {
                Throwable thA = y2Var.f17570c;
                if (thA == null) {
                    thA = vj.l1.a(vj.y2.f17549f.u("RPC cancelled"), null, false);
                }
                this.f19486b.execute(new b(this.f19487c, thA));
            }
            this.f19485a.execute(new a(fm.c.o(), y2Var));
        }

        @Override // wj.k3
        public void a(k3.a aVar) {
            fm.f fVarZ = fm.c.z("ServerStreamListener.messagesAvailable");
            try {
                fm.c.a(this.f19489e);
                this.f19485a.execute(new C0480c(fm.c.f6114a.k(), aVar));
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

        @Override // wj.a3
        public void c() {
            fm.f fVarZ = fm.c.z("ServerStreamListener.halfClosed");
            try {
                fm.c.a(this.f19489e);
                this.f19485a.execute(new b(fm.c.f6114a.k()));
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

        @Override // wj.k3
        public void d() {
            fm.f fVarZ = fm.c.z("ServerStreamListener.onReady");
            try {
                fm.c.a(this.f19489e);
                this.f19485a.execute(new d(fm.c.f6114a.k()));
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

        @Override // wj.a3
        public void e(vj.y2 y2Var) {
            fm.f fVarZ = fm.c.z("ServerStreamListener.closed");
            try {
                fm.c.a(this.f19489e);
                k(y2Var);
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

        public final a3 l() {
            a3 a3Var = this.f19490f;
            if (a3Var != null) {
                return a3Var;
            }
            throw new IllegalStateException("listener unset");
        }

        public final void m(Throwable th2) {
            this.f19488d.p(vj.y2.f17550g.u("Application error processing RPC").t(th2), new vj.v1());
        }

        @b1.e
        public void n(a3 a3Var) {
            c1.h0.F(a3Var, "listener must not be null");
            c1.h0.h0(this.f19490f == null, "Listener already set");
            this.f19490f = a3Var;
        }
    }

    public static final class d implements a3 {
        public d() {
        }

        @Override // wj.k3
        public void a(k3.a aVar) {
            while (true) {
                InputStream next = aVar.next();
                if (next == null) {
                    return;
                }
                try {
                    next.close();
                } catch (IOException e10) {
                    while (true) {
                        InputStream next2 = aVar.next();
                        if (next2 == null) {
                            throw new RuntimeException(e10);
                        }
                        try {
                            next2.close();
                        } catch (IOException e11) {
                            w2.A.log(Level.WARNING, "Exception closing stream", (Throwable) e11);
                        }
                    }
                }
            }
        }

        @Override // wj.a3
        public void c() {
        }

        @Override // wj.k3
        public void d() {
        }

        @Override // wj.a3
        public void e(vj.y2 y2Var) {
        }

        public d(a aVar) {
        }
    }

    public final class e implements y2 {
        public e() {
        }

        @Override // wj.y2
        public void a() {
            synchronized (w2.this.f19472p) {
                try {
                    if (w2.this.f19469m) {
                        return;
                    }
                    ArrayList<b3> arrayList = new ArrayList(w2.this.f19474r);
                    w2 w2Var = w2.this;
                    vj.y2 y2Var = w2Var.f19468l;
                    w2Var.f19469m = true;
                    for (b3 b3Var : arrayList) {
                        if (y2Var == null) {
                            b3Var.shutdown();
                        } else {
                            b3Var.a(y2Var);
                        }
                    }
                    synchronized (w2.this.f19472p) {
                        w2 w2Var2 = w2.this;
                        w2Var2.f19473q = true;
                        w2Var2.T();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // wj.y2
        public c3 b(b3 b3Var) {
            synchronized (w2.this.f19472p) {
                w2.this.f19474r.add(b3Var);
            }
            f fVar = w2.this.new f(b3Var);
            fVar.h();
            return fVar;
        }
    }

    public final class f implements c3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b3 f19502a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Future<?> f19503b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public vj.a f19504c;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
            }
        }

        public final class b extends a0 {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ vj.w.f f19507b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ fm.b f19508c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ fm.e f19509d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ q1.l2 f19510e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final /* synthetic */ String f19511f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ vj.v1 f19512g;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public final /* synthetic */ z2 f19513i;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            public final /* synthetic */ c f19514n;

            public final class a implements vj.w.g {
                public a() {
                }

                @Override // vj.w.g
                public void a(vj.w wVar) {
                    vj.y2 y2VarB = vj.x.b(wVar);
                    if (vj.y2.f17552i.f17568a.equals(y2VarB.f17568a)) {
                        b.this.f19513i.a(y2VarB);
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(vj.w.f fVar, fm.b bVar, fm.e eVar, q1.l2 l2Var, String str, vj.v1 v1Var, z2 z2Var, c cVar) {
                super(fVar);
                this.f19507b = fVar;
                this.f19508c = bVar;
                this.f19509d = eVar;
                this.f19510e = l2Var;
                this.f19511f = str;
                this.f19512g = v1Var;
                this.f19513i = z2Var;
                this.f19514n = cVar;
            }

            private void b() {
                a3 a3Var = w2.B;
                if (this.f19510e.f13426a instanceof q1.f.c) {
                    return;
                }
                try {
                    this.f19514n.n(f.this.i(this.f19511f, (e) q1.h1.j(this.f19510e), this.f19512g));
                    this.f19507b.b(new a(), q1.n0.INSTANCE);
                } catch (Throwable th2) {
                    try {
                        this.f19513i.p(vj.y2.n(th2), new vj.v1());
                        this.f19507b.U0(null);
                        throw new IllegalStateException(th2);
                    } catch (Throwable th3) {
                        this.f19514n.n(a3Var);
                        throw th3;
                    }
                }
            }

            @Override // wj.a0
            public void a() {
                fm.f fVarZ = fm.c.z("ServerTransportListener$HandleServerCall.startCall");
                try {
                    fm.c.n(this.f19508c);
                    fm.c.a(this.f19509d);
                    b();
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
        }

        public final class c extends a0 {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ vj.w.f f19517b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ fm.e f19518c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ fm.b f19519d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ String f19520e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final /* synthetic */ z2 f19521f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ c f19522g;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public final /* synthetic */ q1.l2 f19523i;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            public final /* synthetic */ i3 f19524n;

            /* JADX INFO: renamed from: p, reason: collision with root package name */
            public final /* synthetic */ vj.v1 f19525p;

            /* JADX INFO: renamed from: v, reason: collision with root package name */
            public final /* synthetic */ Executor f19526v;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(vj.w.f fVar, fm.e eVar, fm.b bVar, String str, z2 z2Var, c cVar, q1.l2 l2Var, i3 i3Var, vj.v1 v1Var, Executor executor) {
                super(fVar);
                this.f19517b = fVar;
                this.f19518c = eVar;
                this.f19519d = bVar;
                this.f19520e = str;
                this.f19521f = z2Var;
                this.f19522g = cVar;
                this.f19523i = l2Var;
                this.f19524n = i3Var;
                this.f19525p = v1Var;
                this.f19526v = executor;
            }

            private void c() {
                try {
                    vj.q2<?, ?> q2VarC = w2.this.f19461e.c(this.f19520e, null);
                    if (q2VarC == null) {
                        q2VarC = w2.this.f19462f.c(this.f19520e, this.f19521f.q());
                    }
                    if (q2VarC != null) {
                        this.f19523i.B(b(f.this.k(this.f19521f, q2VarC, this.f19524n), this.f19521f, this.f19525p, this.f19517b, this.f19518c));
                        return;
                    }
                    vj.y2 y2VarU = vj.y2.f17561r.u("Method not found: " + this.f19520e);
                    this.f19522g.n(w2.B);
                    this.f19521f.p(y2VarU, new vj.v1());
                    this.f19517b.U0(null);
                    this.f19523i.cancel(false);
                } catch (Throwable th2) {
                    this.f19522g.n(w2.B);
                    this.f19521f.p(vj.y2.n(th2), new vj.v1());
                    this.f19517b.U0(null);
                    this.f19523i.cancel(false);
                    throw th2;
                }
            }

            @Override // wj.a0
            public void a() {
                fm.f fVarZ = fm.c.z("ServerTransportListener$MethodLookup.startCall");
                try {
                    fm.c.a(this.f19518c);
                    fm.c.n(this.f19519d);
                    c();
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

            public final <ReqT, RespT> e<ReqT, RespT> b(vj.q2<ReqT, RespT> q2Var, z2 z2Var, vj.v1 v1Var, vj.w.f fVar, fm.e eVar) {
                Executor executorA;
                vj.w1<ReqT, RespT> w1Var = q2Var.f17252a;
                vj.a0 a0Var = w2.this.f19476t;
                w2 w2Var = w2.this;
                u2 u2Var = new u2(z2Var, w1Var, v1Var, fVar, a0Var, w2Var.f19477u, w2Var.f19480x, eVar);
                vj.l2 l2Var = w2.this.f19482z;
                if (l2Var != null && (executorA = l2Var.a(u2Var, v1Var)) != null) {
                    ((t2) this.f19526v).e(executorA);
                }
                return f.this.new e<>(u2Var, q2Var.f17253b);
            }
        }

        public class d implements Runnable {
            public d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                f.this.f19502a.a(vj.y2.f17549f.u("Handshake timeout exceeded"));
            }
        }

        public final class e<ReqT, RespT> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public u2<ReqT, RespT> f19529a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public vj.m2<ReqT, RespT> f19530b;

            public e(u2<ReqT, RespT> u2Var, vj.m2<ReqT, RespT> m2Var) {
                this.f19529a = u2Var;
                this.f19530b = m2Var;
            }
        }

        public f(b3 b3Var) {
            this.f19502a = b3Var;
        }

        @Override // wj.c3
        public void a() {
            Future<?> future = this.f19503b;
            if (future != null) {
                future.cancel(false);
                this.f19503b = null;
            }
            Iterator it = w2.this.f19463g.iterator();
            while (it.hasNext()) {
                ((vj.v2) it.next()).b(this.f19504c);
            }
            w2.this.Y(this.f19502a);
        }

        @Override // wj.c3
        public void b(z2 z2Var, String str, vj.v1 v1Var) {
            fm.e eVarI = fm.c.i(str, z2Var.streamId());
            fm.f fVarZ = fm.c.z("ServerTransportListener.streamCreated");
            try {
                fm.c.a(eVarI);
                j(z2Var, str, v1Var, eVarI);
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

        @Override // wj.c3
        public vj.a c(vj.a aVar) {
            this.f19503b.cancel(false);
            this.f19503b = null;
            for (vj.v2 v2Var : w2.this.f19463g) {
                aVar = (vj.a) c1.h0.V(v2Var.a(aVar), "Filter %s returned null", v2Var);
            }
            this.f19504c = aVar;
            return aVar;
        }

        public final vj.w.f g(vj.v1 v1Var, i3 i3Var) {
            Long l10 = (Long) v1Var.l(v0.f19358d);
            vj.w wVarV0 = i3Var.p(w2.this.f19475s).v0(vj.h1.f17159a, w2.this);
            return l10 == null ? wVarV0.p0() : wVarV0.q0(vj.y.b(l10.longValue(), TimeUnit.NANOSECONDS, w2.this.f19481y), this.f19502a.m());
        }

        public void h() {
            if (w2.this.f19465i != Long.MAX_VALUE) {
                this.f19503b = this.f19502a.m().schedule(new d(), w2.this.f19465i, TimeUnit.MILLISECONDS);
            } else {
                this.f19503b = new FutureTask(new a(), null);
            }
            w2 w2Var = w2.this;
            w2Var.f19479w.g(w2Var, this.f19502a);
        }

        public final <WReqT, WRespT> a3 i(String str, e<WReqT, WRespT> eVar, vj.v1 v1Var) {
            vj.k2.a<WReqT> aVarA = eVar.f19530b.a(eVar.f19529a, v1Var);
            if (aVarA != null) {
                return eVar.f19529a.t(aVarA);
            }
            throw new NullPointerException(m.a.a("startCall() returned a null listener for method ", str));
        }

        public final void j(z2 z2Var, String str, vj.v1 v1Var, fm.e eVar) {
            Executor t2Var;
            if (w2.this.f19482z == null && w2.this.f19460d == q1.n0.INSTANCE) {
                t2Var = new s2();
                z2Var.n();
            } else {
                t2Var = new t2(w2.this.f19460d);
            }
            Executor executor = t2Var;
            vj.v1.i<String> iVar = v0.f19359e;
            if (v1Var.i(iVar)) {
                String str2 = (String) v1Var.l(iVar);
                vj.z zVarF = w2.this.f19476t.f(str2);
                if (zVarF == null) {
                    z2Var.u(w2.B);
                    z2Var.p(vj.y2.f17561r.u(String.format("Can't find decompressor for %s", str2)), new vj.v1());
                    return;
                }
                z2Var.k(zVarF);
            }
            i3 i3Var = (i3) c1.h0.F(z2Var.g(), "statsTraceCtx not present from stream");
            vj.w.f fVarG = g(v1Var, i3Var);
            fm.b bVarO = fm.c.o();
            c cVar = new c(executor, w2.this.f19460d, z2Var, fVarG, eVar);
            z2Var.u(cVar);
            q1.l2 l2VarF = q1.l2.F();
            executor.execute(new c(fVarG, eVar, bVarO, str, z2Var, cVar, l2VarF, i3Var, v1Var, executor));
            executor.execute(new b(fVarG, bVarO, eVar, l2VarF, str, v1Var, z2Var, cVar));
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final <ReqT, RespT> vj.q2<?, ?> k(z2 z2Var, vj.q2<ReqT, RespT> q2Var, i3 i3Var) {
            i3Var.o(new v2(q2Var.f17252a, z2Var.c(), z2Var.q()));
            vj.m2<ReqT, RespT> m2Var = q2Var.f17253b;
            vj.o2[] o2VarArr = w2.this.f19464h;
            int length = o2VarArr.length;
            int i10 = 0;
            while (i10 < length) {
                vj.p2.c cVar = new vj.p2.c(o2VarArr[i10], m2Var);
                i10++;
                m2Var = cVar;
            }
            vj.q2<ReqT, RespT> q2VarD = q2Var.d(m2Var);
            vj.b bVar = w2.this.f19478v;
            return bVar == null ? q2VarD : bVar.c(q2VarD);
        }
    }

    public w2(x2 x2Var, d1 d1Var, vj.w wVar) {
        this.f19459c = (z1) c1.h0.F(x2Var.f19548g, "executorPool");
        this.f19461e = (vj.o0) c1.h0.F(x2Var.f19542a.b(), "registryBuilder");
        this.f19462f = (vj.o0) c1.h0.F(x2Var.f19547f, "fallbackRegistry");
        this.f19471o = (d1) c1.h0.F(d1Var, "transportServer");
        this.f19475s = ((vj.w) c1.h0.F(wVar, "rootContext")).y();
        this.f19476t = x2Var.f19549h;
        this.f19477u = x2Var.f19550i;
        this.f19463g = Collections.unmodifiableList(new ArrayList(x2Var.f19543b));
        List<vj.o2> list = x2Var.f19544c;
        this.f19464h = (vj.o2[]) list.toArray(new vj.o2[list.size()]);
        this.f19465i = x2Var.f19551j;
        this.f19478v = x2Var.f19558q;
        vj.v0 v0Var = x2Var.f19559r;
        this.f19479w = v0Var;
        this.f19480x = x2Var.f19560s.a();
        this.f19481y = (vj.y.c) c1.h0.F(x2Var.f19552k, "ticker");
        v0Var.f(this);
        this.f19482z = x2Var.f19561t;
    }

    public final void T() {
        synchronized (this.f19472p) {
            try {
                if (this.f19467k && this.f19474r.isEmpty() && this.f19473q) {
                    if (this.f19470n) {
                        throw new AssertionError("Server already terminated");
                    }
                    this.f19470n = true;
                    this.f19479w.B(this);
                    Executor executor = this.f19460d;
                    if (executor != null) {
                        this.f19460d = this.f19459c.b(executor);
                    }
                    this.f19472p.notifyAll();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final List<SocketAddress> U() {
        List<SocketAddress> listUnmodifiableList;
        synchronized (this.f19472p) {
            listUnmodifiableList = Collections.unmodifiableList(this.f19471o.l());
        }
        return listUnmodifiableList;
    }

    @Override // vj.i2
    /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
    public w2 s() {
        synchronized (this.f19472p) {
            try {
                if (this.f19467k) {
                    return this;
                }
                this.f19467k = true;
                boolean z10 = this.f19466j;
                if (!z10) {
                    this.f19473q = true;
                    T();
                }
                if (z10) {
                    this.f19471o.shutdown();
                }
                return this;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // vj.i2
    /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
    public w2 t() {
        s();
        vj.y2 y2VarU = vj.y2.f17563t.u("Server shutdownNow invoked");
        synchronized (this.f19472p) {
            try {
                if (this.f19468l != null) {
                    return this;
                }
                this.f19468l = y2VarU;
                ArrayList arrayList = new ArrayList(this.f19474r);
                boolean z10 = this.f19469m;
                if (z10) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((b3) it.next()).a(y2VarU);
                    }
                }
                return this;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // vj.i2
    /* JADX INFO: renamed from: X, reason: merged with bridge method [inline-methods] */
    public w2 u() throws IOException {
        synchronized (this.f19472p) {
            c1.h0.h0(!this.f19466j, "Already started");
            c1.h0.h0(!this.f19467k, "Shutting down");
            this.f19471o.i(new e());
            this.f19460d = (Executor) c1.h0.F(this.f19459c.a(), "executor");
            this.f19466j = true;
        }
        return this;
    }

    public final void Y(b3 b3Var) {
        synchronized (this.f19472p) {
            try {
                if (!this.f19474r.remove(b3Var)) {
                    throw new AssertionError("Transport already removed");
                }
                this.f19479w.C(this, b3Var);
                T();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // vj.i2
    public void b() throws InterruptedException {
        synchronized (this.f19472p) {
            while (!this.f19470n) {
                try {
                    this.f19472p.wait();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    @Override // vj.m1
    public vj.c1 e() {
        return this.f19458b;
    }

    @Override // vj.i2
    public boolean g(long j10, TimeUnit timeUnit) throws InterruptedException {
        boolean z10;
        synchronized (this.f19472p) {
            try {
                long jNanoTime = System.nanoTime() + timeUnit.toNanos(j10);
                while (!this.f19470n) {
                    long jNanoTime2 = jNanoTime - System.nanoTime();
                    if (jNanoTime2 <= 0) {
                        break;
                    }
                    TimeUnit.NANOSECONDS.timedWait(this.f19472p, jNanoTime2);
                }
                z10 = this.f19470n;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return z10;
    }

    @Override // vj.i2
    public List<vj.t2> h() {
        return this.f19461e.a();
    }

    @Override // vj.i2
    public List<SocketAddress> i() {
        List<SocketAddress> listU;
        synchronized (this.f19472p) {
            c1.h0.h0(this.f19466j, "Not started");
            c1.h0.h0(!this.f19470n, "Already terminated");
            listU = U();
        }
        return listU;
    }

    @Override // vj.a1
    public q1.s1<vj.v0.j> j() {
        vj.v0.j.a aVar = new vj.v0.j.a();
        List<vj.a1<vj.v0.l>> listH = this.f19471o.h();
        if (listH != null) {
            aVar.a(listH);
        }
        this.f19480x.e(aVar);
        q1.l2 l2VarF = q1.l2.F();
        l2VarF.B(aVar.b());
        return l2VarF;
    }

    @Override // vj.i2
    public List<vj.t2> l() {
        return Collections.unmodifiableList(this.f19462f.a());
    }

    @Override // vj.i2
    public int o() {
        synchronized (this.f19472p) {
            try {
                c1.h0.h0(this.f19466j, "Not started");
                c1.h0.h0(!this.f19470n, "Already terminated");
                for (SocketAddress socketAddress : this.f19471o.l()) {
                    if (socketAddress instanceof InetSocketAddress) {
                        return ((InetSocketAddress) socketAddress).getPort();
                    }
                }
                return -1;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // vj.i2
    public List<vj.t2> p() {
        List<vj.t2> listA = this.f19462f.a();
        if (listA.isEmpty()) {
            return this.f19461e.a();
        }
        List<vj.t2> listA2 = this.f19461e.a();
        ArrayList arrayList = new ArrayList(listA.size() + listA2.size());
        arrayList.addAll(listA2);
        arrayList.addAll(listA);
        return Collections.unmodifiableList(arrayList);
    }

    @Override // vj.i2
    public boolean q() {
        boolean z10;
        synchronized (this.f19472p) {
            z10 = this.f19467k;
        }
        return z10;
    }

    @Override // vj.i2
    public boolean r() {
        boolean z10;
        synchronized (this.f19472p) {
            z10 = this.f19470n;
        }
        return z10;
    }

    public String toString() {
        return c1.z.c(this).e("logId", this.f19458b.f17063c).j("transportServer", this.f19471o).toString();
    }
}
