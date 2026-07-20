package af;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import k3.t8;
import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public final class e3 extends ze.j {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Logger f230o = Logger.getLogger(e3.class.getName());
    public static final o0 p = new o0(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScheduledFuture f231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f232b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ze.y f233c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f234d;
    public ze.f0 e;
    public ze.j f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ze.q2 f235g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List f236h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public q0 f237i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ze.y f238j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ze.r1 f239k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ze.f f240l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f241m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ f3 f242n;

    public e3(f3 f3Var, ze.y yVar, ze.r1 r1Var, ze.f fVar) {
        ScheduledFuture<?> scheduledFutureSchedule;
        int i8 = 1;
        this.f242n = f3Var;
        j3 j3Var = f3Var.f281d;
        Logger logger = j3.c0;
        j3Var.getClass();
        Executor executor = fVar.f11348b;
        executor = executor == null ? j3Var.f352h : executor;
        j3 j3Var2 = f3Var.f281d;
        h3 h3Var = j3Var2.f351g;
        this.f236h = new ArrayList();
        v8.i(executor, "callExecutor");
        this.f232b = executor;
        v8.i(h3Var, "scheduler");
        ze.y yVarI = ze.y.i();
        this.f233c = yVarI;
        ze.z zVarL = yVarI.l();
        ze.z zVar = fVar.f11347a;
        if (zVar == null && zVarL == null) {
            scheduledFutureSchedule = null;
        } else {
            long jF = zVar != null ? zVar.f(TimeUnit.NANOSECONDS) : Long.MAX_VALUE;
            if (zVarL != null) {
                TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                if (zVarL.f(timeUnit) < jF) {
                    jF = zVarL.f(timeUnit);
                    Level level = Level.FINE;
                    Logger logger2 = f230o;
                    if (logger2.isLoggable(level)) {
                        Locale locale = Locale.US;
                        StringBuilder sb2 = new StringBuilder("Call timeout set to '" + jF + "' ns, due to context deadline.");
                        if (zVar == null) {
                            sb2.append(" Explicit call timeout was not set.");
                        } else {
                            sb2.append(" Explicit call timeout was '" + zVar.f(timeUnit) + "' ns.");
                        }
                        logger2.fine(sb2.toString());
                    }
                }
            }
            long jAbs = Math.abs(jF);
            TimeUnit timeUnit2 = TimeUnit.SECONDS;
            long nanos = jAbs / timeUnit2.toNanos(1L);
            long jAbs2 = Math.abs(jF) % timeUnit2.toNanos(1L);
            StringBuilder sb3 = new StringBuilder();
            String str = zVar == null ? true : zVarL == null ? false : zVarL.d(zVar) ? "Context" : "CallOptions";
            if (jF < 0) {
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
            scheduledFutureSchedule = h3Var.f308a.schedule(new e(i8, this, sb3), jF, TimeUnit.NANOSECONDS);
        }
        this.f231a = scheduledFutureSchedule;
        this.f238j = yVar;
        this.f239k = r1Var;
        this.f240l = fVar;
        j3Var2.Y.getClass();
        this.f241m = System.nanoTime();
    }

    @Override // ze.j
    public final void a(String str, Throwable th2) {
        ze.q2 q2Var = ze.q2.f;
        ze.q2 q2VarH = str != null ? q2Var.h(str) : q2Var.h("Call cancelled without message");
        if (th2 != null) {
            q2VarH = q2VarH.g(th2);
        }
        g(q2VarH, false);
    }

    @Override // ze.j
    public final void b() {
        h(new n0(this, 0));
    }

    @Override // ze.j
    public final boolean c() {
        if (this.f234d) {
            return this.f.c();
        }
        return false;
    }

    @Override // ze.j
    public final void d(int i8) {
        if (this.f234d) {
            this.f.d(i8);
        } else {
            h(new g(i8, 1, this));
        }
    }

    @Override // ze.j
    public final void e(Object obj) {
        if (this.f234d) {
            this.f.e(obj);
        } else {
            h(new e(3, this, obj));
        }
    }

    @Override // ze.j
    public final void f(ze.f0 f0Var, ze.p1 p1Var) {
        ze.q2 q2Var;
        boolean z2;
        v8.n(this.e == null, "already started");
        synchronized (this) {
            try {
                v8.i(f0Var, "listener");
                this.e = f0Var;
                q2Var = this.f235g;
                z2 = this.f234d;
                if (!z2) {
                    q0 q0Var = new q0(f0Var);
                    this.f237i = q0Var;
                    f0Var = q0Var;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (q2Var != null) {
            this.f232b.execute(new p0(this, f0Var, q2Var));
        } else if (z2) {
            this.f.f(f0Var, p1Var);
        } else {
            h(new m0(this, 0, f0Var, p1Var));
        }
    }

    public final void g(ze.q2 q2Var, boolean z2) {
        ze.f0 f0Var;
        synchronized (this) {
            try {
                ze.j jVar = this.f;
                boolean z3 = true;
                if (jVar == null) {
                    o0 o0Var = p;
                    if (jVar != null) {
                        z3 = false;
                    }
                    v8.l("realCall already set to %s", z3, jVar);
                    ScheduledFuture scheduledFuture = this.f231a;
                    if (scheduledFuture != null) {
                        scheduledFuture.cancel(false);
                    }
                    this.f = o0Var;
                    f0Var = this.e;
                    this.f235g = q2Var;
                    z3 = false;
                } else if (z2) {
                    return;
                } else {
                    f0Var = null;
                }
                if (z3) {
                    h(new e(2, this, q2Var));
                } else {
                    if (f0Var != null) {
                        this.f232b.execute(new p0(this, f0Var, q2Var));
                    }
                    i();
                }
                this.f242n.f281d.f357m.execute(new n0(this, 1));
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void h(Runnable runnable) {
        synchronized (this) {
            try {
                if (this.f234d) {
                    runnable.run();
                } else {
                    this.f236h.add(runnable);
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
    
        ((java.lang.Runnable) r0.next()).run();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i() {
        /*
            r3 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
        L5:
            monitor-enter(r3)
            java.util.List r1 = r3.f236h     // Catch: java.lang.Throwable -> L24
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L24
            if (r1 == 0) goto L26
            r0 = 0
            r3.f236h = r0     // Catch: java.lang.Throwable -> L24
            r0 = 1
            r3.f234d = r0     // Catch: java.lang.Throwable -> L24
            af.q0 r0 = r3.f237i     // Catch: java.lang.Throwable -> L24
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L24
            if (r0 == 0) goto L23
            java.util.concurrent.Executor r1 = r3.f232b
            af.y r2 = new af.y
            r2.<init>(r3, r0)
            r1.execute(r2)
        L23:
            return
        L24:
            r0 = move-exception
            goto L44
        L26:
            java.util.List r1 = r3.f236h     // Catch: java.lang.Throwable -> L24
            r3.f236h = r0     // Catch: java.lang.Throwable -> L24
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
        throw new UnsupportedOperationException("Method not decompiled: af.e3.i():void");
    }

    public final void j() {
        y yVar;
        ze.y yVarC = this.f238j.c();
        try {
            ze.f fVar = this.f240l;
            ze.e eVar = ze.n.f11385a;
            this.f242n.f281d.Y.getClass();
            ze.j jVarH = this.f242n.h(this.f239k, fVar.e(eVar, Long.valueOf(System.nanoTime() - this.f241m)));
            this.f238j.k(yVarC);
            synchronized (this) {
                try {
                    ze.j jVar = this.f;
                    if (jVar != null) {
                        yVar = null;
                    } else {
                        v8.l("realCall already set to %s", jVar == null, jVar);
                        ScheduledFuture scheduledFuture = this.f231a;
                        if (scheduledFuture != null) {
                            scheduledFuture.cancel(false);
                        }
                        this.f = jVarH;
                        yVar = new y(this, this.f233c);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (yVar == null) {
                this.f242n.f281d.f357m.execute(new n0(this, 1));
                return;
            }
            j3 j3Var = this.f242n.f281d;
            ze.f fVar2 = this.f240l;
            j3Var.getClass();
            Executor executor = fVar2.f11348b;
            if (executor == null) {
                executor = j3Var.f352h;
            }
            executor.execute(new e(20, this, yVar));
        } catch (Throwable th3) {
            this.f238j.k(yVarC);
            throw th3;
        }
    }

    public final String toString() {
        o6.a aVarA = t8.a(this);
        aVarA.d(this.f, "realCall");
        return aVarA.toString();
    }
}
