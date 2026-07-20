package nq;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: loaded from: classes3.dex */
@kn.r1({"SMAP\nDefaultExecutor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DefaultExecutor.kt\nkotlinx/coroutines/DefaultExecutor\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,187:1\n1#2:188\n*E\n"})
public final class y0 extends s1 implements Runnable {

    @os.m
    private static volatile Thread _thread = null;
    private static volatile int debugStatus = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public static final y0 f11985g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @os.l
    public static final String f11986i = "kotlinx.coroutines.DefaultExecutor";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final long f11987n = 1000;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final long f11988p;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f11989v = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f11990w = 1;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f11991x = 2;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f11992y = 3;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f11993z = 4;

    static {
        Long l10;
        y0 y0Var = new y0();
        f11985g = y0Var;
        r1.J0(y0Var, false, 1, null);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l10 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l10 = 1000L;
        }
        f11988p = timeUnit.toNanos(l10.longValue());
    }

    public static /* synthetic */ void x2() {
    }

    public final boolean A2() {
        return _thread != null;
    }

    public final synchronized boolean B2() {
        if (z2()) {
            return false;
        }
        debugStatus = 1;
        kn.l0.n(this, "null cannot be cast to non-null type java.lang.Object");
        notifyAll();
        return true;
    }

    public final void C2() {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    public final synchronized void D2(long j10) {
        lm.l2 l2Var;
        try {
            long jCurrentTimeMillis = System.currentTimeMillis() + j10;
            if (!z2()) {
                debugStatus = 2;
            }
            while (debugStatus != 3 && _thread != null) {
                Thread thread = _thread;
                if (thread != null) {
                    b bVarB = c.b();
                    if (bVarB != null) {
                        bVarB.g(thread);
                        l2Var = lm.l2.f10208a;
                    } else {
                        l2Var = null;
                    }
                    if (l2Var == null) {
                        LockSupport.unpark(thread);
                    }
                }
                if (jCurrentTimeMillis - System.currentTimeMillis() <= 0) {
                    break;
                }
                kn.l0.n(this, "null cannot be cast to non-null type java.lang.Object");
                wait(j10);
            }
            debugStatus = 0;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // nq.s1, nq.c1
    @os.l
    public n1 E(long j10, @os.l Runnable runnable, @os.l um.g gVar) {
        return r2(j10, runnable);
    }

    @Override // nq.t1
    @os.l
    public Thread b2() {
        Thread thread = _thread;
        return thread == null ? v2() : thread;
    }

    @Override // nq.t1
    public void f2(long j10, @os.l s1.c cVar) {
        C2();
    }

    @Override // nq.s1
    public void k2(@os.l Runnable runnable) {
        if (y2()) {
            C2();
        }
        super.k2(runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean zQ0;
        lm.l2 l2Var;
        p3.f11893a.d(this);
        b bVarB = c.b();
        if (bVarB != null) {
            bVarB.d();
        }
        try {
            if (!B2()) {
                if (zQ0) {
                    return;
                } else {
                    return;
                }
            }
            long j10 = Long.MAX_VALUE;
            while (true) {
                Thread.interrupted();
                long jC1 = c1();
                if (jC1 == Long.MAX_VALUE) {
                    b bVar = c.f11825a;
                    long jB = bVar != null ? bVar.b() : System.nanoTime();
                    if (j10 == Long.MAX_VALUE) {
                        j10 = f11988p + jB;
                    }
                    long j11 = j10 - jB;
                    if (j11 <= 0) {
                        if (zQ0) {
                            return;
                        } else {
                            return;
                        }
                    }
                    jC1 = tn.u.C(jC1, j11);
                } else {
                    j10 = Long.MAX_VALUE;
                }
                if (jC1 > 0) {
                    if (z2()) {
                        if (zQ0) {
                            return;
                        } else {
                            return;
                        }
                    }
                    b bVar2 = c.f11825a;
                    if (bVar2 != null) {
                        bVar2.c(this, jC1);
                        l2Var = lm.l2.f10208a;
                    } else {
                        l2Var = null;
                    }
                    if (l2Var == null) {
                        LockSupport.parkNanos(this, jC1);
                    }
                }
            }
        } finally {
            _thread = null;
            u2();
            b bVar3 = c.f11825a;
            if (bVar3 != null) {
                bVar3.h();
            }
            if (!Q0()) {
                b2();
            }
        }
    }

    @Override // nq.s1, nq.r1
    public void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }

    public final synchronized void u2() {
        if (z2()) {
            debugStatus = 3;
            o2();
            kn.l0.n(this, "null cannot be cast to non-null type java.lang.Object");
            notifyAll();
        }
    }

    public final synchronized Thread v2() {
        Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new Thread(this, f11986i);
            _thread = thread;
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    public final synchronized void w2() {
        debugStatus = 0;
        v2();
        while (debugStatus == 0) {
            kn.l0.n(this, "null cannot be cast to non-null type java.lang.Object");
            wait();
        }
    }

    public final boolean y2() {
        return debugStatus == 4;
    }

    public final boolean z2() {
        int i10 = debugStatus;
        return i10 == 2 || i10 == 3;
    }
}
