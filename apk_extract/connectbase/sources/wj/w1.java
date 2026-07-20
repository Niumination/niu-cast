package wj;

import java.io.Closeable;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: loaded from: classes2.dex */
public final class w1 implements m3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t1.b f19434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final wj.g f19435b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h f19436c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final wj.g.d f19437d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final t1 f19438e;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @hm.a("lock")
    public boolean f19441i;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @hm.a("lock")
    public boolean f19443p;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final g f19439f = new g();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f19440g = new Object();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @hm.a("lock")
    public final Queue<i> f19442n = new ArrayDeque();

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ fm.b f19444a;

        public a(fm.b bVar) {
            this.f19444a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            fm.f fVarZ = fm.c.z("MigratingThreadDeframer.messageAvailable");
            try {
                fm.c.n(this.f19444a);
                w1 w1Var = w1.this;
                w1Var.f19434a.a(w1Var.f19439f);
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

    public class b implements i {
        public b() {
        }

        @Override // wj.w1.i
        public void b(boolean z10) {
            w1.this.f19438e.close();
        }
    }

    public class c implements i {
        public c() {
        }

        @Override // wj.w1.i
        public void b(boolean z10) {
            w1.this.f19438e.p();
        }
    }

    public class d implements i, Closeable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i2 f19448a;

        public d(i2 i2Var) {
            this.f19448a = i2Var;
        }

        @Override // wj.w1.i
        public void b(boolean z10) {
            fm.f fVarZ = fm.c.z("MigratingThreadDeframer.deframe");
            try {
                if (z10) {
                    w1.this.f19438e.n(this.f19448a);
                    if (fVarZ != null) {
                        fm.c.u();
                        return;
                    }
                    return;
                }
                try {
                    w1.this.f19438e.n(this.f19448a);
                } catch (Throwable th2) {
                    w1.this.f19435b.c(th2);
                    w1.this.f19438e.close();
                }
                if (fVarZ != null) {
                    fm.c.u();
                }
            } catch (Throwable th3) {
                if (fVarZ != null) {
                    try {
                        fm.c.u();
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                    }
                }
                throw th3;
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f19448a.close();
        }
    }

    public class e implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f19450a;

        public e(int i10) {
            this.f19450a = i10;
        }

        @Override // wj.w1.i
        public void b(boolean z10) {
            if (!z10) {
                w1.this.b(this.f19450a);
                return;
            }
            try {
                w1.this.f19438e.b(this.f19450a);
            } catch (Throwable th2) {
                w1.this.f19435b.c(th2);
                w1.this.f19438e.close();
            }
            if (w1.this.f19438e.t()) {
                return;
            }
            synchronized (w1.this.f19440g) {
                fm.c.j("MigratingThreadDeframer.deframerOnApplicationThread");
                w1 w1Var = w1.this;
                w1Var.f19436c.f(w1Var.f19435b);
                w1.this.f19441i = false;
            }
        }
    }

    public class f implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f19452a;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ fm.b f19454a;

            public a(fm.b bVar) {
                this.f19454a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                fm.f fVarZ = fm.c.z("MigratingThreadDeframer.request");
                try {
                    fm.c.n(this.f19454a);
                    f fVar = f.this;
                    w1.this.r(fVar.f19452a);
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

        public f(int i10) {
            this.f19452a = i10;
        }

        @Override // wj.w1.i
        public void b(boolean z10) {
            if (z10) {
                w1.this.f19437d.f(new a(fm.c.o()));
                return;
            }
            try {
                fm.f fVarZ = fm.c.z("MigratingThreadDeframer.request");
                try {
                    w1.this.f19438e.b(this.f19452a);
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
                w1.this.f19435b.c(th4);
                w1.this.f19438e.close();
            }
        }
    }

    public class g implements k3.a, Closeable {
        public g() {
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            i iVarPoll;
            while (true) {
                synchronized (w1.this.f19440g) {
                    do {
                        try {
                            iVarPoll = w1.this.f19442n.poll();
                            if (iVarPoll == null) {
                                break;
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    } while (!(iVarPoll instanceof Closeable));
                    if (iVarPoll == null) {
                        w1.this.f19443p = false;
                        return;
                    }
                }
                v0.e((Closeable) iVarPoll);
            }
        }

        @Override // wj.k3.a
        public InputStream next() {
            i iVarPoll;
            while (true) {
                InputStream inputStreamF = w1.this.f19435b.f();
                if (inputStreamF != null) {
                    return inputStreamF;
                }
                synchronized (w1.this.f19440g) {
                    try {
                        iVarPoll = w1.this.f19442n.poll();
                        if (iVarPoll == null) {
                            if (w1.this.f19438e.t()) {
                                fm.c.j("MigratingThreadDeframer.deframerOnTransportThread");
                                w1 w1Var = w1.this;
                                w1Var.f19436c.f(w1Var.f19434a);
                                w1.this.f19441i = true;
                            }
                            w1.this.f19443p = false;
                            return null;
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                iVarPoll.b(false);
            }
        }
    }

    public static class h extends p0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public t1.b f19457a;

        public h(t1.b bVar) {
            f(bVar);
        }

        @Override // wj.p0
        public t1.b d() {
            return this.f19457a;
        }

        public void f(t1.b bVar) {
            this.f19457a = (t1.b) c1.h0.F(bVar, "delegate");
        }
    }

    public interface i {
        void b(boolean z10);
    }

    public w1(t1.b bVar, wj.g.d dVar, t1 t1Var) {
        h3 h3Var = new h3((t1.b) c1.h0.F(bVar, "listener"));
        this.f19434a = h3Var;
        this.f19437d = (wj.g.d) c1.h0.F(dVar, "transportExecutor");
        wj.g gVar = new wj.g(h3Var, dVar);
        this.f19435b = gVar;
        h hVar = new h(gVar);
        this.f19436c = hVar;
        t1Var.f0(hVar);
        this.f19438e = t1Var;
    }

    @Override // wj.m3, wj.b0
    public void b(int i10) {
        t(new f(i10), false);
    }

    @Override // wj.b0
    public void close() {
        if (t(new b(), true)) {
            return;
        }
        this.f19438e.g0();
    }

    @Override // wj.b0
    public void h(int i10) {
        this.f19438e.h(i10);
    }

    @Override // wj.b0
    public void k(vj.z zVar) {
        this.f19438e.k(zVar);
    }

    @Override // wj.b0
    public void n(i2 i2Var) {
        t(new d(i2Var), true);
    }

    @Override // wj.b0
    public void o(w0 w0Var) {
        this.f19438e.o(w0Var);
    }

    @Override // wj.b0
    public void p() {
        t(new c(), true);
    }

    public final void r(int i10) {
        t(new e(i10), true);
    }

    public final boolean s(i iVar) {
        return t(iVar, true);
    }

    public final boolean t(i iVar, boolean z10) {
        boolean z11;
        boolean z12;
        synchronized (this.f19440g) {
            try {
                z11 = this.f19441i;
                z12 = this.f19443p;
                if (!z11) {
                    this.f19442n.offer(iVar);
                    this.f19443p = true;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (z11) {
            iVar.b(true);
            return true;
        }
        if (z12) {
            return false;
        }
        if (!z10) {
            this.f19437d.f(new a(fm.c.o()));
            return false;
        }
        fm.f fVarZ = fm.c.z("MigratingThreadDeframer.messageAvailable");
        try {
            this.f19434a.a(this.f19439f);
            if (fVarZ == null) {
                return false;
            }
            fm.c.u();
            return false;
        } catch (Throwable th3) {
            if (fVarZ != null) {
                try {
                    fm.c.u();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
            }
            throw th3;
        }
    }
}
