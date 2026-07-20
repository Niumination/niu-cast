package wj;

import com.transsion.connectx.mirror.source.receiver.HomeKeyReceiver;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class e0 implements s {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ boolean f18483j = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f18484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public t f18485b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public s f18486c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @hm.a("this")
    public vj.y2 f18487d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @hm.a("this")
    public p f18489f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @hm.a("this")
    public long f18490g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @hm.a("this")
    public long f18491h;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @hm.a("this")
    public List<Runnable> f18488e = new ArrayList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List<Runnable> f18492i = new ArrayList();

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f18493a;

        public a(int i10) {
            this.f18493a = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            e0.this.f18486c.b(this.f18493a);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e0.this.f18486c.n();
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ vj.s f18496a;

        public c(vj.s sVar) {
            this.f18496a = sVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e0.this.f18486c.f(this.f18496a);
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f18498a;

        public d(boolean z10) {
            this.f18498a = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            e0.this.f18486c.o(this.f18498a);
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ vj.a0 f18500a;

        public e(vj.a0 a0Var) {
            this.f18500a = a0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            e0.this.f18486c.m(this.f18500a);
        }
    }

    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f18502a;

        public f(boolean z10) {
            this.f18502a = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            e0.this.f18486c.e(this.f18502a);
        }
    }

    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f18504a;

        public g(int i10) {
            this.f18504a = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            e0.this.f18486c.h(this.f18504a);
        }
    }

    public class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f18506a;

        public h(int i10) {
            this.f18506a = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            e0.this.f18486c.i(this.f18506a);
        }
    }

    public class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ vj.y f18508a;

        public i(vj.y yVar) {
            this.f18508a = yVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e0.this.f18486c.r(this.f18508a);
        }
    }

    public class j implements Runnable {
        public j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e0.this.B();
        }
    }

    public class k implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f18511a;

        public k(String str) {
            this.f18511a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            e0.this.f18486c.t(this.f18511a);
        }
    }

    public class l implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InputStream f18513a;

        public l(InputStream inputStream) {
            this.f18513a = inputStream;
        }

        @Override // java.lang.Runnable
        public void run() {
            e0.this.f18486c.j(this.f18513a);
        }
    }

    public class m implements Runnable {
        public m() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e0.this.f18486c.flush();
        }
    }

    public class n implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ vj.y2 f18516a;

        public n(vj.y2 y2Var) {
            this.f18516a = y2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            e0.this.f18486c.a(this.f18516a);
        }
    }

    public class o implements Runnable {
        public o() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e0.this.f18486c.v();
        }
    }

    public static class p implements t {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ boolean f18519d = false;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final t f18520a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile boolean f18521b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @hm.a("this")
        public List<Runnable> f18522c = new ArrayList();

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ k3.a f18523a;

            public a(k3.a aVar) {
                this.f18523a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                p.this.f18520a.a(this.f18523a);
            }
        }

        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                p.this.f18520a.d();
            }
        }

        public class c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ vj.v1 f18526a;

            public c(vj.v1 v1Var) {
                this.f18526a = v1Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                p.this.f18520a.f(this.f18526a);
            }
        }

        public class d implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ vj.y2 f18528a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ t.a f18529b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ vj.v1 f18530c;

            public d(vj.y2 y2Var, t.a aVar, vj.v1 v1Var) {
                this.f18528a = y2Var;
                this.f18529b = aVar;
                this.f18530c = v1Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                p.this.f18520a.b(this.f18528a, this.f18529b, this.f18530c);
            }
        }

        public p(t tVar) {
            this.f18520a = tVar;
        }

        @Override // wj.k3
        public void a(k3.a aVar) {
            if (this.f18521b) {
                this.f18520a.a(aVar);
            } else {
                h(new a(aVar));
            }
        }

        @Override // wj.t
        public void b(vj.y2 y2Var, t.a aVar, vj.v1 v1Var) {
            h(new d(y2Var, aVar, v1Var));
        }

        @Override // wj.k3
        public void d() {
            if (this.f18521b) {
                this.f18520a.d();
            } else {
                h(new b());
            }
        }

        @Override // wj.t
        public void f(vj.v1 v1Var) {
            h(new c(v1Var));
        }

        public final void h(Runnable runnable) {
            synchronized (this) {
                try {
                    if (this.f18521b) {
                        runnable.run();
                    } else {
                        this.f18522c.add(runnable);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        public void i() {
            List<Runnable> list;
            List<Runnable> arrayList = new ArrayList<>();
            while (true) {
                synchronized (this) {
                    try {
                        if (this.f18522c.isEmpty()) {
                            this.f18522c = null;
                            this.f18521b = true;
                            return;
                        } else {
                            list = this.f18522c;
                            this.f18522c = arrayList;
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                Iterator<Runnable> it = list.iterator();
                while (it.hasNext()) {
                    it.next().run();
                }
                list.clear();
                arrayList = list;
            }
        }
    }

    public final void A(Runnable runnable) {
        c1.h0.h0(this.f18485b != null, "May only be called after start");
        synchronized (this) {
            try {
                if (this.f18484a) {
                    runnable.run();
                } else {
                    this.f18488e.add(runnable);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:26:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:9:0x0019  */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0024, code lost:
    
        r0 = r1.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002c, code lost:
    
        if (r0.hasNext() == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002e, code lost:
    
        r0.next().run();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void B() {
        /*
            r3 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
        L5:
            monitor-enter(r3)
            java.util.List<java.lang.Runnable> r1 = r3.f18488e     // Catch: java.lang.Throwable -> L1d
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L1d
            if (r1 == 0) goto L1f
            r0 = 0
            r3.f18488e = r0     // Catch: java.lang.Throwable -> L1d
            r0 = 1
            r3.f18484a = r0     // Catch: java.lang.Throwable -> L1d
            wj.e0$p r0 = r3.f18489f     // Catch: java.lang.Throwable -> L1d
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L1d
            if (r0 == 0) goto L1c
            r0.i()
        L1c:
            return
        L1d:
            r0 = move-exception
            goto L3d
        L1f:
            java.util.List<java.lang.Runnable> r1 = r3.f18488e     // Catch: java.lang.Throwable -> L1d
            r3.f18488e = r0     // Catch: java.lang.Throwable -> L1d
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L1d
            java.util.Iterator r0 = r1.iterator()
        L28:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L38
            java.lang.Object r2 = r0.next()
            java.lang.Runnable r2 = (java.lang.Runnable) r2
            r2.run()
            goto L28
        L38:
            r1.clear()
            r0 = r1
            goto L5
        L3d:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L1d
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: wj.e0.B():void");
    }

    @b1.e
    public s C() {
        return this.f18486c;
    }

    public final void D(t tVar) {
        Iterator<Runnable> it = this.f18492i.iterator();
        while (it.hasNext()) {
            it.next().run();
        }
        this.f18492i = null;
        this.f18486c.y(tVar);
    }

    public void E(vj.y2 y2Var) {
    }

    @hm.a("this")
    public final void F(s sVar) {
        s sVar2 = this.f18486c;
        c1.h0.x0(sVar2 == null, "realStream already set to %s", sVar2);
        this.f18486c = sVar;
        this.f18491h = System.nanoTime();
    }

    @gm.c
    public final Runnable G(s sVar) {
        synchronized (this) {
            try {
                if (this.f18486c != null) {
                    return null;
                }
                F((s) c1.h0.F(sVar, "stream"));
                t tVar = this.f18485b;
                if (tVar == null) {
                    this.f18488e = null;
                    this.f18484a = true;
                }
                if (tVar == null) {
                    return null;
                }
                D(tVar);
                return new j();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // wj.s
    public void a(vj.y2 y2Var) {
        boolean z10 = false;
        c1.h0.h0(this.f18485b != null, "May only be called after start");
        c1.h0.F(y2Var, HomeKeyReceiver.f2161e);
        synchronized (this) {
            try {
                if (this.f18486c == null) {
                    F(y1.f19572a);
                    this.f18487d = y2Var;
                } else {
                    z10 = true;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (z10) {
            A(new n(y2Var));
            return;
        }
        B();
        E(y2Var);
        this.f18485b.b(y2Var, t.a.PROCESSED, new vj.v1());
    }

    @Override // wj.j3
    public void b(int i10) {
        c1.h0.h0(this.f18485b != null, "May only be called after start");
        if (this.f18484a) {
            this.f18486c.b(i10);
        } else {
            A(new a(i10));
        }
    }

    @Override // wj.s
    public vj.a c() {
        s sVar;
        synchronized (this) {
            sVar = this.f18486c;
        }
        return sVar != null ? sVar.c() : vj.a.f17046c;
    }

    @Override // wj.j3
    public void e(boolean z10) {
        c1.h0.h0(this.f18485b != null, "May only be called after start");
        if (this.f18484a) {
            this.f18486c.e(z10);
        } else {
            A(new f(z10));
        }
    }

    @Override // wj.j3
    public void f(vj.s sVar) {
        c1.h0.h0(this.f18485b == null, "May only be called before start");
        c1.h0.F(sVar, "compressor");
        this.f18492i.add(new c(sVar));
    }

    @Override // wj.j3
    public void flush() {
        c1.h0.h0(this.f18485b != null, "May only be called after start");
        if (this.f18484a) {
            this.f18486c.flush();
        } else {
            A(new m());
        }
    }

    @Override // wj.s
    public void h(int i10) {
        c1.h0.h0(this.f18485b == null, "May only be called before start");
        this.f18492i.add(new g(i10));
    }

    @Override // wj.s
    public void i(int i10) {
        c1.h0.h0(this.f18485b == null, "May only be called before start");
        this.f18492i.add(new h(i10));
    }

    @Override // wj.j3
    public void j(InputStream inputStream) {
        c1.h0.h0(this.f18485b != null, "May only be called after start");
        c1.h0.F(inputStream, "message");
        if (this.f18484a) {
            this.f18486c.j(inputStream);
        } else {
            A(new l(inputStream));
        }
    }

    @Override // wj.s
    public void m(vj.a0 a0Var) {
        c1.h0.h0(this.f18485b == null, "May only be called before start");
        c1.h0.F(a0Var, "decompressorRegistry");
        this.f18492i.add(new e(a0Var));
    }

    @Override // wj.j3
    public void n() {
        c1.h0.h0(this.f18485b == null, "May only be called before start");
        this.f18492i.add(new b());
    }

    @Override // wj.s
    public void o(boolean z10) {
        c1.h0.h0(this.f18485b == null, "May only be called before start");
        this.f18492i.add(new d(z10));
    }

    @Override // wj.s
    public void r(vj.y yVar) {
        c1.h0.h0(this.f18485b == null, "May only be called before start");
        this.f18492i.add(new i(yVar));
    }

    @Override // wj.j3
    public boolean s() {
        if (this.f18484a) {
            return this.f18486c.s();
        }
        return false;
    }

    @Override // wj.s
    public void t(String str) {
        c1.h0.h0(this.f18485b == null, "May only be called before start");
        c1.h0.F(str, "authority");
        this.f18492i.add(new k(str));
    }

    @Override // wj.s
    public void v() {
        c1.h0.h0(this.f18485b != null, "May only be called after start");
        A(new o());
    }

    @Override // wj.s
    public void x(b1 b1Var) {
        synchronized (this) {
            try {
                if (this.f18485b == null) {
                    return;
                }
                if (this.f18486c != null) {
                    b1Var.b("buffered_nanos", Long.valueOf(this.f18491h - this.f18490g));
                    this.f18486c.x(b1Var);
                } else {
                    b1Var.b("buffered_nanos", Long.valueOf(System.nanoTime() - this.f18490g));
                    b1Var.a("waiting_for_connection");
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // wj.s
    public void y(t tVar) {
        vj.y2 y2Var;
        boolean z10;
        c1.h0.F(tVar, "listener");
        c1.h0.h0(this.f18485b == null, "already started");
        synchronized (this) {
            try {
                y2Var = this.f18487d;
                z10 = this.f18484a;
                if (!z10) {
                    p pVar = new p(tVar);
                    this.f18489f = pVar;
                    tVar = pVar;
                }
                this.f18485b = tVar;
                this.f18490g = System.nanoTime();
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (y2Var != null) {
            tVar.b(y2Var, t.a.PROCESSED, new vj.v1());
        } else if (z10) {
            D(tVar);
        }
    }
}
