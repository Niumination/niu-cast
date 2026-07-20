package wj;

import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public class c0<ReqT, RespT> extends vj.k<ReqT, RespT> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Logger f18363j = Logger.getLogger(c0.class.getName());

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final vj.k<Object, Object> f18364k = new j();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ boolean f18365l = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @gm.j
    public final ScheduledFuture<?> f18366a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f18367b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final vj.w f18368c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f18369d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public vj.k.a<RespT> f18370e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public vj.k<ReqT, RespT> f18371f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @hm.a("this")
    public vj.y2 f18372g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @hm.a("this")
    public List<Runnable> f18373h = new ArrayList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @hm.a("this")
    public l<RespT> f18374i;

    public class a extends a0 {
        public a(vj.w wVar) {
            super(wVar);
        }

        @Override // wj.a0
        public void a() {
            c0.this.p();
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ StringBuilder f18376a;

        public b(StringBuilder sb2) {
            this.f18376a = sb2;
        }

        @Override // java.lang.Runnable
        public void run() {
            c0.this.n(vj.y2.f17552i.u(this.f18376a.toString()), true);
        }
    }

    public class c extends a0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ l f18378b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(l lVar) {
            super(c0.this.f18368c);
            this.f18378b = lVar;
        }

        @Override // wj.a0
        public void a() {
            this.f18378b.g();
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ vj.k.a f18380a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ vj.v1 f18381b;

        public d(vj.k.a aVar, vj.v1 v1Var) {
            this.f18380a = aVar;
            this.f18381b = v1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            c0.this.f18371f.h(this.f18380a, this.f18381b);
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ vj.y2 f18383a;

        public e(vj.y2 y2Var) {
            this.f18383a = y2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            vj.k kVar = c0.this.f18371f;
            vj.y2 y2Var = this.f18383a;
            kVar.a(y2Var.f17569b, y2Var.f17570c);
        }
    }

    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f18385a;

        public f(Object obj) {
            this.f18385a = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            c0.this.f18371f.f(this.f18385a);
        }
    }

    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f18387a;

        public g(boolean z10) {
            this.f18387a = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            c0.this.f18371f.g(this.f18387a);
        }
    }

    public class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f18389a;

        public h(int i10) {
            this.f18389a = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            c0.this.f18371f.e(this.f18389a);
        }
    }

    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c0.this.f18371f.c();
        }
    }

    public class j extends vj.k<Object, Object> {
        @Override // vj.k
        public void a(String str, Throwable th2) {
        }

        @Override // vj.k
        public void c() {
        }

        @Override // vj.k
        public boolean d() {
            return false;
        }

        @Override // vj.k
        public void e(int i10) {
        }

        @Override // vj.k
        public void f(Object obj) {
        }

        @Override // vj.k
        public void h(vj.k.a<Object> aVar, vj.v1 v1Var) {
        }
    }

    public final class k extends a0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final vj.k.a<RespT> f18392b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final vj.y2 f18393c;

        public k(vj.k.a<RespT> aVar, vj.y2 y2Var) {
            super(c0.this.f18368c);
            this.f18392b = aVar;
            this.f18393c = y2Var;
        }

        @Override // wj.a0
        public void a() {
            this.f18392b.a(this.f18393c, new vj.v1());
        }
    }

    public static final class l<RespT> extends vj.k.a<RespT> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ boolean f18395d = false;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final vj.k.a<RespT> f18396a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile boolean f18397b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @hm.a("this")
        public List<Runnable> f18398c = new ArrayList();

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ vj.v1 f18399a;

            public a(vj.v1 v1Var) {
                this.f18399a = v1Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                l.this.f18396a.b(this.f18399a);
            }
        }

        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Object f18401a;

            public b(Object obj) {
                this.f18401a = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                l.this.f18396a.c(this.f18401a);
            }
        }

        public class c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ vj.y2 f18403a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ vj.v1 f18404b;

            public c(vj.y2 y2Var, vj.v1 v1Var) {
                this.f18403a = y2Var;
                this.f18404b = v1Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                l.this.f18396a.a(this.f18403a, this.f18404b);
            }
        }

        public class d implements Runnable {
            public d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                l.this.f18396a.d();
            }
        }

        public l(vj.k.a<RespT> aVar) {
            this.f18396a = aVar;
        }

        @Override // vj.k.a
        public void a(vj.y2 y2Var, vj.v1 v1Var) {
            f(new c(y2Var, v1Var));
        }

        @Override // vj.k.a
        public void b(vj.v1 v1Var) {
            if (this.f18397b) {
                this.f18396a.b(v1Var);
            } else {
                f(new a(v1Var));
            }
        }

        @Override // vj.k.a
        public void c(RespT respt) {
            if (this.f18397b) {
                this.f18396a.c(respt);
            } else {
                f(new b(respt));
            }
        }

        @Override // vj.k.a
        public void d() {
            if (this.f18397b) {
                this.f18396a.d();
            } else {
                f(new d());
            }
        }

        public final void f(Runnable runnable) {
            synchronized (this) {
                try {
                    if (this.f18397b) {
                        runnable.run();
                    } else {
                        this.f18398c.add(runnable);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        public void g() {
            List<Runnable> list;
            List<Runnable> arrayList = new ArrayList<>();
            while (true) {
                synchronized (this) {
                    try {
                        if (this.f18398c.isEmpty()) {
                            this.f18398c = null;
                            this.f18397b = true;
                            return;
                        } else {
                            list = this.f18398c;
                            this.f18398c = arrayList;
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

    public c0(Executor executor, ScheduledExecutorService scheduledExecutorService, @gm.j vj.y yVar) {
        this.f18367b = (Executor) c1.h0.F(executor, "callExecutor");
        c1.h0.F(scheduledExecutorService, "scheduler");
        this.f18368c = vj.w.o();
        this.f18366a = s(scheduledExecutorService, yVar);
    }

    @Override // vj.k
    public final void a(@gm.j String str, @gm.j Throwable th2) {
        vj.y2 y2Var = vj.y2.f17549f;
        vj.y2 y2VarU = str != null ? y2Var.u(str) : y2Var.u("Call cancelled without message");
        if (th2 != null) {
            y2VarU = y2VarU.t(th2);
        }
        n(y2VarU, false);
    }

    @Override // vj.k
    public final vj.a b() {
        vj.k<ReqT, RespT> kVar;
        synchronized (this) {
            kVar = this.f18371f;
        }
        return kVar != null ? kVar.b() : vj.a.f17046c;
    }

    @Override // vj.k
    public final void c() {
        o(new i());
    }

    @Override // vj.k
    public final boolean d() {
        if (this.f18369d) {
            return this.f18371f.d();
        }
        return false;
    }

    @Override // vj.k
    public final void e(int i10) {
        if (this.f18369d) {
            this.f18371f.e(i10);
        } else {
            o(new h(i10));
        }
    }

    @Override // vj.k
    public final void f(ReqT reqt) {
        if (this.f18369d) {
            this.f18371f.f(reqt);
        } else {
            o(new f(reqt));
        }
    }

    @Override // vj.k
    public final void g(boolean z10) {
        if (this.f18369d) {
            this.f18371f.g(z10);
        } else {
            o(new g(z10));
        }
    }

    @Override // vj.k
    public final void h(vj.k.a<RespT> aVar, vj.v1 v1Var) {
        vj.y2 y2Var;
        boolean z10;
        c1.h0.h0(this.f18370e == null, "already started");
        synchronized (this) {
            try {
                this.f18370e = (vj.k.a) c1.h0.F(aVar, "listener");
                y2Var = this.f18372g;
                z10 = this.f18369d;
                if (!z10) {
                    l<RespT> lVar = new l<>(aVar);
                    this.f18374i = lVar;
                    aVar = lVar;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (y2Var != null) {
            this.f18367b.execute(new k(aVar, y2Var));
        } else if (z10) {
            this.f18371f.h(aVar, v1Var);
        } else {
            o(new d(aVar, v1Var));
        }
    }

    public void m() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void n(vj.y2 y2Var, boolean z10) {
        boolean z11;
        vj.k.a<RespT> aVar;
        synchronized (this) {
            try {
                if (this.f18371f == null) {
                    u(f18364k);
                    aVar = this.f18370e;
                    this.f18372g = y2Var;
                    z11 = false;
                } else {
                    if (z10) {
                        return;
                    }
                    z11 = true;
                    aVar = null;
                }
                if (z11) {
                    o(new e(y2Var));
                } else {
                    if (aVar != null) {
                        this.f18367b.execute(new k(aVar, y2Var));
                    }
                    p();
                }
                m();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void o(Runnable runnable) {
        synchronized (this) {
            try {
                if (this.f18369d) {
                    runnable.run();
                } else {
                    this.f18373h.add(runnable);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:26:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:9:0x0019  */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002b, code lost:
    
        r0 = r1.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0033, code lost:
    
        if (r0.hasNext() == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0035, code lost:
    
        r0.next().run();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void p() {
        /*
            r3 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
        L5:
            monitor-enter(r3)
            java.util.List<java.lang.Runnable> r1 = r3.f18373h     // Catch: java.lang.Throwable -> L24
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L24
            if (r1 == 0) goto L26
            r0 = 0
            r3.f18373h = r0     // Catch: java.lang.Throwable -> L24
            r0 = 1
            r3.f18369d = r0     // Catch: java.lang.Throwable -> L24
            wj.c0$l<RespT> r0 = r3.f18374i     // Catch: java.lang.Throwable -> L24
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L24
            if (r0 == 0) goto L23
            java.util.concurrent.Executor r1 = r3.f18367b
            wj.c0$c r2 = new wj.c0$c
            r2.<init>(r0)
            r1.execute(r2)
        L23:
            return
        L24:
            r0 = move-exception
            goto L44
        L26:
            java.util.List<java.lang.Runnable> r1 = r3.f18373h     // Catch: java.lang.Throwable -> L24
            r3.f18373h = r0     // Catch: java.lang.Throwable -> L24
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L24
            java.util.Iterator r0 = r1.iterator()
        L2f:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L3f
            java.lang.Object r2 = r0.next()
            java.lang.Runnable r2 = (java.lang.Runnable) r2
            r2.run()
            goto L2f
        L3f:
            r1.clear()
            r0 = r1
            goto L5
        L44:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L24
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: wj.c0.p():void");
    }

    @b1.e
    public final vj.k<ReqT, RespT> q() {
        return this.f18371f;
    }

    public final boolean r(@gm.j vj.y yVar, @gm.j vj.y yVar2) {
        if (yVar2 == null) {
            return true;
        }
        if (yVar == null) {
            return false;
        }
        return yVar.l(yVar2);
    }

    @gm.j
    public final ScheduledFuture<?> s(ScheduledExecutorService scheduledExecutorService, @gm.j vj.y yVar) {
        vj.y yVarA = this.f18368c.A();
        if (yVar == null && yVarA == null) {
            return null;
        }
        long jQ = yVar != null ? yVar.q(TimeUnit.NANOSECONDS) : Long.MAX_VALUE;
        if (yVarA != null) {
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            if (yVarA.q(timeUnit) < jQ) {
                jQ = yVarA.q(timeUnit);
                Logger logger = f18363j;
                if (logger.isLoggable(Level.FINE)) {
                    Locale locale = Locale.US;
                    StringBuilder sb2 = new StringBuilder(String.format(locale, "Call timeout set to '%d' ns, due to context deadline.", Long.valueOf(jQ)));
                    if (yVar == null) {
                        sb2.append(" Explicit call timeout was not set.");
                    } else {
                        sb2.append(String.format(locale, " Explicit call timeout was '%d' ns.", Long.valueOf(yVar.q(timeUnit))));
                    }
                    logger.fine(sb2.toString());
                }
            }
        }
        long jAbs = Math.abs(jQ);
        TimeUnit timeUnit2 = TimeUnit.SECONDS;
        long nanos = jAbs / timeUnit2.toNanos(1L);
        long jAbs2 = Math.abs(jQ) % timeUnit2.toNanos(1L);
        StringBuilder sb3 = new StringBuilder();
        String str = r(yVarA, yVar) ? "Context" : "CallOptions";
        if (jQ < 0) {
            sb3.append("ClientCall started after ");
            sb3.append(str);
            sb3.append(" deadline was exceeded. Deadline has been exceeded for ");
        } else {
            sb3.append("Deadline ");
            sb3.append(str);
            sb3.append(" will be exceeded in ");
        }
        sb3.append(nanos);
        sb3.append(String.format(Locale.US, ".%09d", Long.valueOf(jAbs2)));
        sb3.append("s. ");
        return scheduledExecutorService.schedule(new b(sb3), jQ, TimeUnit.NANOSECONDS);
    }

    public final Runnable t(vj.k<ReqT, RespT> kVar) {
        synchronized (this) {
            try {
                if (this.f18371f != null) {
                    return null;
                }
                u((vj.k) c1.h0.F(kVar, NotificationCompat.CATEGORY_CALL));
                return new a(this.f18368c);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public String toString() {
        return c1.z.c(this).j("realCall", this.f18371f).toString();
    }

    @hm.a("this")
    public final void u(vj.k<ReqT, RespT> kVar) {
        vj.k<ReqT, RespT> kVar2 = this.f18371f;
        c1.h0.x0(kVar2 == null, "realCall already set to %s", kVar2);
        ScheduledFuture<?> scheduledFuture = this.f18366a;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.f18371f = kVar;
    }
}
