package wj;

import androidx.core.app.NotificationCompat;
import java.net.SocketAddress;
import java.util.Collection;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class n implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f18935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final vj.d f18936b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f18937c;

    public class a extends o0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final x f18938a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f18939b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public volatile vj.y2 f18941d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @hm.a("this")
        public vj.y2 f18942e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @hm.a("this")
        public vj.y2 f18943f;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AtomicInteger f18940c = new AtomicInteger(-2147483647);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final v1.a f18944g = new C0477a();

        /* JADX INFO: renamed from: wj.n$a$a, reason: collision with other inner class name */
        public class C0477a implements v1.a {
            public C0477a() {
            }

            @Override // wj.v1.a
            public void a() {
                if (a.this.f18940c.decrementAndGet() == 0) {
                    a.this.o();
                }
            }
        }

        public class b extends vj.d.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ vj.w1 f18947a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ vj.e f18948b;

            public b(vj.w1 w1Var, vj.e eVar) {
                this.f18947a = w1Var;
                this.f18948b = eVar;
            }

            @Override // vj.d.b
            public String a() {
                return (String) c1.z.a(this.f18948b.f17088c, a.this.f18939b);
            }

            @Override // vj.d.b
            public vj.e b() {
                return this.f18948b;
            }

            @Override // vj.d.b
            public vj.w1<?, ?> c() {
                return this.f18947a;
            }

            @Override // vj.d.b
            public vj.h2 d() {
                vj.a aVarC = a.this.f18938a.c();
                return (vj.h2) c1.z.a((vj.h2) aVarC.f17048a.get(u0.f19305a), vj.h2.NONE);
            }

            @Override // vj.d.b
            public vj.a e() {
                return a.this.f18938a.c();
            }
        }

        public a(x xVar, String str) {
            this.f18938a = (x) c1.h0.F(xVar, "delegate");
            this.f18939b = (String) c1.h0.F(str, "authority");
        }

        @Override // wj.o0, wj.r1
        public void a(vj.y2 y2Var) {
            c1.h0.F(y2Var, NotificationCompat.CATEGORY_STATUS);
            synchronized (this) {
                try {
                    if (this.f18940c.get() < 0) {
                        this.f18941d = y2Var;
                        this.f18940c.addAndGet(Integer.MAX_VALUE);
                    } else if (this.f18943f != null) {
                        return;
                    }
                    if (this.f18940c.get() != 0) {
                        this.f18943f = y2Var;
                    } else {
                        super.a(y2Var);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // wj.o0
        public x b() {
            return this.f18938a;
        }

        @Override // wj.o0, wj.u
        public s k(vj.w1<?, ?> w1Var, vj.v1 v1Var, vj.e eVar, vj.n[] nVarArr) {
            Executor executor;
            vj.d qVar = eVar.f17089d;
            if (qVar == null) {
                qVar = n.this.f18936b;
            } else {
                vj.d dVar = n.this.f18936b;
                if (dVar != null) {
                    qVar = new vj.q(dVar, qVar);
                }
            }
            if (qVar == null) {
                return this.f18940c.get() >= 0 ? new i0(this.f18941d, nVarArr) : this.f18938a.k(w1Var, v1Var, eVar, nVarArr);
            }
            v1 v1Var2 = new v1(this.f18938a, w1Var, v1Var, eVar, this.f18944g, nVarArr);
            if (this.f18940c.incrementAndGet() > 0) {
                this.f18944g.a();
                return new i0(this.f18941d, nVarArr);
            }
            b bVar = new b(w1Var, eVar);
            try {
                if (!(qVar instanceof vj.e1) || !((vj.e1) qVar).a() || (executor = eVar.f17087b) == null) {
                    executor = n.this.f18937c;
                }
                qVar.a(bVar, executor, v1Var2);
            } catch (Throwable th2) {
                v1Var2.b(vj.y2.f17556m.u("Credentials should use fail() instead of throwing exceptions").t(th2));
            }
            return v1Var2.d();
        }

        @Override // wj.o0, wj.r1
        public void n(vj.y2 y2Var) {
            c1.h0.F(y2Var, NotificationCompat.CATEGORY_STATUS);
            synchronized (this) {
                try {
                    if (this.f18940c.get() < 0) {
                        this.f18941d = y2Var;
                        this.f18940c.addAndGet(Integer.MAX_VALUE);
                        if (this.f18940c.get() != 0) {
                            this.f18942e = y2Var;
                        } else {
                            super.n(y2Var);
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        public final void o() {
            synchronized (this) {
                try {
                    if (this.f18940c.get() != 0) {
                        return;
                    }
                    vj.y2 y2Var = this.f18942e;
                    vj.y2 y2Var2 = this.f18943f;
                    this.f18942e = null;
                    this.f18943f = null;
                    if (y2Var != null) {
                        super.n(y2Var);
                    }
                    if (y2Var2 != null) {
                        super.a(y2Var2);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public n(v vVar, vj.d dVar, Executor executor) {
        this.f18935a = (v) c1.h0.F(vVar, "delegate");
        this.f18936b = dVar;
        this.f18937c = (Executor) c1.h0.F(executor, "appExecutor");
    }

    @Override // wj.v
    public x D(SocketAddress socketAddress, v.a aVar, vj.h hVar) {
        return new a(this.f18935a.D(socketAddress, aVar, hVar), aVar.f19349b);
    }

    @Override // wj.v
    public v.b E1(vj.g gVar) {
        throw new UnsupportedOperationException();
    }

    @Override // wj.v
    public Collection<Class<? extends SocketAddress>> a2() {
        return this.f18935a.a2();
    }

    @Override // wj.v, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f18935a.close();
    }

    @Override // wj.v
    public ScheduledExecutorService m() {
        return this.f18935a.m();
    }
}
