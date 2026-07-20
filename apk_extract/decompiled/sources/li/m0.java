package li;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.time.DurationKt;

/* JADX INFO: loaded from: classes3.dex */
public final class m0 extends e1 implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final m0 f7477j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final long f7478k;

    static {
        Long l4;
        m0 m0Var = new m0();
        f7477j = m0Var;
        m0Var.o(false);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l4 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l4 = 1000L;
        }
        f7478k = timeUnit.toNanos(l4.longValue());
    }

    @Override // li.f1
    public final void I(long j8, c1 c1Var) {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    @Override // li.e1, li.f1
    public final void N() {
        debugStatus = 4;
        super.N();
    }

    @Override // li.e1
    public final void X(Runnable runnable) {
        if (debugStatus == 4) {
            throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
        }
        super.X(runnable);
    }

    @Override // li.e1, li.q0
    public final x0 g(long j8, Runnable runnable, CoroutineContext coroutineContext) {
        long j10 = 0;
        if (j8 > 0) {
            j10 = j8 >= 9223372036854L ? Long.MAX_VALUE : 1000000 * j8;
        }
        if (j10 >= DurationKt.MAX_MILLIS) {
            return d2.f7443a;
        }
        long jNanoTime = System.nanoTime();
        b1 b1Var = new b1(j10 + jNanoTime, runnable);
        n0(jNanoTime, b1Var);
        return b1Var;
    }

    @Override // li.f1
    public final Thread l() {
        Thread thread = _thread;
        if (thread == null) {
            synchronized (this) {
                thread = _thread;
                if (thread == null) {
                    thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
                    _thread = thread;
                    thread.setContextClassLoader(f7477j.getClass().getClassLoader());
                    thread.setDaemon(true);
                    thread.start();
                }
            }
        }
        return thread;
    }

    public final synchronized void o0() {
        int i8 = debugStatus;
        if (i8 == 2 || i8 == 3) {
            debugStatus = 3;
            e1.e.set(this, null);
            e1.f7446h.set(this, null);
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
            notifyAll();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        k2.f7463a.set(this);
        try {
            synchronized (this) {
                int i8 = debugStatus;
                if (i8 == 2 || i8 == 3) {
                    _thread = null;
                    o0();
                    if (m0()) {
                        return;
                    }
                    l();
                    return;
                }
                debugStatus = 1;
                Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
                notifyAll();
                long j8 = Long.MAX_VALUE;
                long j10 = Long.MAX_VALUE;
                while (true) {
                    Thread.interrupted();
                    long jB = B();
                    if (jB == j8) {
                        long jNanoTime = System.nanoTime();
                        if (j10 == j8) {
                            j10 = f7478k + jNanoTime;
                        }
                        long j11 = j10 - jNanoTime;
                        if (j11 <= 0) {
                            _thread = null;
                            o0();
                            if (m0()) {
                                return;
                            }
                            l();
                            return;
                        }
                        jB = RangesKt.coerceAtMost(jB, j11);
                    } else {
                        j10 = Long.MAX_VALUE;
                    }
                    if (jB > 0) {
                        int i9 = debugStatus;
                        if (i9 == 2 || i9 == 3) {
                            _thread = null;
                            o0();
                            if (m0()) {
                                return;
                            }
                            l();
                            return;
                        }
                        LockSupport.parkNanos(this, jB);
                    }
                    j8 = Long.MAX_VALUE;
                }
            }
        } catch (Throwable th2) {
            _thread = null;
            o0();
            if (!m0()) {
                l();
            }
            throw th2;
        }
    }

    @Override // li.a0
    public final String toString() {
        return "DefaultExecutor";
    }
}
