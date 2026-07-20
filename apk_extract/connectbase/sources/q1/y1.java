package q1;

import com.google.j2objc.annotations.Weak;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@o0
@b1.d
public final class y1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f13767a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ReentrantLock f13768b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @gm.a
    @u1.a("lock")
    public a f13769c;

    public static abstract class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Weak
        public final y1 f13770a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Condition f13771b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @u1.a("monitor.lock")
        public int f13772c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @gm.a
        @u1.a("monitor.lock")
        public a f13773d;

        public a(y1 monitor) {
            this.f13770a = (y1) c1.h0.F(monitor, "monitor");
            this.f13771b = monitor.f13768b.newCondition();
        }

        public abstract boolean a();
    }

    public y1() {
        this(false);
    }

    public static long E(long startTime, long timeoutNanos) {
        if (timeoutNanos <= 0) {
            return 0L;
        }
        return timeoutNanos - (System.nanoTime() - startTime);
    }

    public static long H(long time, TimeUnit unit) {
        return o1.n.g(unit.toNanos(time), 0L, 6917529027641081853L);
    }

    public static long y(long timeoutNanos) {
        if (timeoutNanos <= 0) {
            return 0L;
        }
        long jNanoTime = System.nanoTime();
        if (jNanoTime == 0) {
            return 1L;
        }
        return jNanoTime;
    }

    public boolean A() {
        return this.f13768b.isLocked();
    }

    public boolean B() {
        return this.f13768b.isHeldByCurrentThread();
    }

    @u1.a("lock")
    public final boolean C(a guard) {
        try {
            return guard.a();
        } catch (Error | RuntimeException e10) {
            F();
            throw e10;
        }
    }

    public void D() {
        ReentrantLock reentrantLock = this.f13768b;
        try {
            if (reentrantLock.getHoldCount() == 1) {
                G();
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    @u1.a("lock")
    public final void F() {
        for (a aVar = this.f13769c; aVar != null; aVar = aVar.f13773d) {
            aVar.f13771b.signalAll();
        }
    }

    @u1.a("lock")
    public final void G() {
        for (a aVar = this.f13769c; aVar != null; aVar = aVar.f13773d) {
            if (C(aVar)) {
                aVar.f13771b.signal();
                return;
            }
        }
    }

    public boolean I() {
        return this.f13768b.tryLock();
    }

    public boolean J(a guard) {
        if (guard.f13770a != this) {
            throw new IllegalMonitorStateException();
        }
        ReentrantLock reentrantLock = this.f13768b;
        if (!reentrantLock.tryLock()) {
            return false;
        }
        try {
            boolean zA = guard.a();
            if (!zA) {
                reentrantLock.unlock();
            }
            return zA;
        } catch (Throwable th2) {
            reentrantLock.unlock();
            throw th2;
        }
    }

    public void K(a guard) throws InterruptedException {
        if (guard.f13770a != this || !this.f13768b.isHeldByCurrentThread()) {
            throw new IllegalMonitorStateException();
        }
        if (guard.a()) {
            return;
        }
        b(guard, true);
    }

    public boolean L(a guard, long time, TimeUnit unit) throws InterruptedException {
        long jH = H(time, unit);
        if (guard.f13770a != this || !this.f13768b.isHeldByCurrentThread()) {
            throw new IllegalMonitorStateException();
        }
        if (guard.a()) {
            return true;
        }
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        return c(guard, jH, true);
    }

    public void M(a guard) {
        if (guard.f13770a != this || !this.f13768b.isHeldByCurrentThread()) {
            throw new IllegalMonitorStateException();
        }
        if (guard.a()) {
            return;
        }
        d(guard, true);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x004b  */
    public boolean N(a guard, long time, TimeUnit unit) throws Throwable {
        long jH = H(time, unit);
        if (guard.f13770a != this || !this.f13768b.isHeldByCurrentThread()) {
            throw new IllegalMonitorStateException();
        }
        boolean z10 = true;
        if (guard.a()) {
            return true;
        }
        long jY = y(jH);
        boolean zInterrupted = Thread.interrupted();
        long jE = jH;
        boolean z11 = true;
        while (true) {
            try {
                try {
                    boolean zC = this.c(guard, jE, z11);
                    if (zInterrupted) {
                        Thread.currentThread().interrupt();
                    }
                    return zC;
                } catch (Throwable th2) {
                    th = th2;
                    if (z10) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            } catch (InterruptedException unused) {
                if (guard.a()) {
                    Thread.currentThread().interrupt();
                    return true;
                }
                jE = E(jY, jH);
                z11 = false;
                zInterrupted = true;
            } catch (Throwable th3) {
                th = th3;
                z10 = zInterrupted;
                if (z10) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
    }

    @u1.a("lock")
    public final void b(a guard, boolean signalBeforeWaiting) throws InterruptedException {
        if (signalBeforeWaiting) {
            G();
        }
        e(guard);
        do {
            try {
                guard.f13771b.await();
            } finally {
                f(guard);
            }
        } while (!guard.a());
    }

    @u1.a("lock")
    public final boolean c(a guard, long nanos, boolean signalBeforeWaiting) throws InterruptedException {
        boolean z10 = true;
        while (nanos > 0) {
            if (z10) {
                if (signalBeforeWaiting) {
                    try {
                        G();
                    } catch (Throwable th2) {
                        if (!z10) {
                            f(guard);
                        }
                        throw th2;
                    }
                }
                e(guard);
                z10 = false;
            }
            nanos = guard.f13771b.awaitNanos(nanos);
            if (guard.a()) {
                if (!z10) {
                    f(guard);
                }
                return true;
            }
        }
        if (!z10) {
            f(guard);
        }
        return false;
    }

    @u1.a("lock")
    public final void d(a guard, boolean signalBeforeWaiting) {
        if (signalBeforeWaiting) {
            G();
        }
        e(guard);
        do {
            try {
                guard.f13771b.awaitUninterruptibly();
            } finally {
                f(guard);
            }
        } while (!guard.a());
    }

    @u1.a("lock")
    public final void e(a guard) {
        int i10 = guard.f13772c;
        guard.f13772c = i10 + 1;
        if (i10 == 0) {
            guard.f13773d = this.f13769c;
            this.f13769c = guard;
        }
    }

    @u1.a("lock")
    public final void f(a guard) {
        int i10 = guard.f13772c - 1;
        guard.f13772c = i10;
        if (i10 == 0) {
            a aVar = this.f13769c;
            a aVar2 = null;
            while (aVar != guard) {
                aVar2 = aVar;
                aVar = aVar.f13773d;
            }
            if (aVar2 == null) {
                this.f13769c = aVar.f13773d;
            } else {
                aVar2.f13773d = aVar.f13773d;
            }
            aVar.f13773d = null;
        }
    }

    public void g() {
        this.f13768b.lock();
    }

    public boolean h(long time, TimeUnit unit) throws Throwable {
        boolean zTryLock;
        long jH = H(time, unit);
        ReentrantLock reentrantLock = this.f13768b;
        boolean z10 = true;
        if (!this.f13767a && reentrantLock.tryLock()) {
            return true;
        }
        boolean zInterrupted = Thread.interrupted();
        try {
            long jNanoTime = System.nanoTime();
            long jE = jH;
            while (true) {
                try {
                    try {
                        zTryLock = reentrantLock.tryLock(jE, TimeUnit.NANOSECONDS);
                        break;
                    } catch (Throwable th2) {
                        th = th2;
                        if (z10) {
                            Thread.currentThread().interrupt();
                        }
                        throw th;
                    }
                } catch (InterruptedException unused) {
                    jE = E(jNanoTime, jH);
                    zInterrupted = true;
                }
            }
            if (zInterrupted) {
                Thread.currentThread().interrupt();
            }
            return zTryLock;
        } catch (Throwable th3) {
            th = th3;
            z10 = zInterrupted;
        }
    }

    public boolean i(a guard) {
        if (guard.f13770a != this) {
            throw new IllegalMonitorStateException();
        }
        ReentrantLock reentrantLock = this.f13768b;
        reentrantLock.lock();
        try {
            boolean zA = guard.a();
            if (!zA) {
                reentrantLock.unlock();
            }
            return zA;
        } catch (Throwable th2) {
            reentrantLock.unlock();
            throw th2;
        }
    }

    public boolean j(a guard, long time, TimeUnit unit) {
        if (guard.f13770a != this) {
            throw new IllegalMonitorStateException();
        }
        if (!h(time, unit)) {
            return false;
        }
        try {
            boolean zA = guard.a();
            if (!zA) {
                this.f13768b.unlock();
            }
            return zA;
        } catch (Throwable th2) {
            this.f13768b.unlock();
            throw th2;
        }
    }

    public boolean k(a guard) throws InterruptedException {
        if (guard.f13770a != this) {
            throw new IllegalMonitorStateException();
        }
        ReentrantLock reentrantLock = this.f13768b;
        reentrantLock.lockInterruptibly();
        try {
            boolean zA = guard.a();
            if (!zA) {
                reentrantLock.unlock();
            }
            return zA;
        } catch (Throwable th2) {
            reentrantLock.unlock();
            throw th2;
        }
    }

    public boolean l(a guard, long time, TimeUnit unit) throws InterruptedException {
        if (guard.f13770a != this) {
            throw new IllegalMonitorStateException();
        }
        ReentrantLock reentrantLock = this.f13768b;
        if (!reentrantLock.tryLock(time, unit)) {
            return false;
        }
        try {
            boolean zA = guard.a();
            if (!zA) {
                reentrantLock.unlock();
            }
            return zA;
        } catch (Throwable th2) {
            reentrantLock.unlock();
            throw th2;
        }
    }

    public void m() throws InterruptedException {
        this.f13768b.lockInterruptibly();
    }

    public boolean n(long time, TimeUnit unit) throws InterruptedException {
        return this.f13768b.tryLock(time, unit);
    }

    public void o(a guard) throws InterruptedException {
        if (guard.f13770a != this) {
            throw new IllegalMonitorStateException();
        }
        ReentrantLock reentrantLock = this.f13768b;
        boolean zIsHeldByCurrentThread = reentrantLock.isHeldByCurrentThread();
        reentrantLock.lockInterruptibly();
        try {
            if (guard.a()) {
                return;
            }
            b(guard, zIsHeldByCurrentThread);
        } catch (Throwable th2) {
            D();
            throw th2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0029  */
    /* JADX WARN: Code duplicated, block: B:15:0x0033 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:27:0x004c  */
    public boolean p(a guard, long time, TimeUnit unit) throws InterruptedException {
        long jY;
        boolean z10;
        long jH = H(time, unit);
        if (guard.f13770a != this) {
            throw new IllegalMonitorStateException();
        }
        ReentrantLock reentrantLock = this.f13768b;
        boolean zIsHeldByCurrentThread = reentrantLock.isHeldByCurrentThread();
        if (this.f13767a) {
            jY = y(jH);
            if (!reentrantLock.tryLock(time, unit)) {
                return false;
            }
        } else {
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            if (reentrantLock.tryLock()) {
                jY = 0;
            } else {
                jY = y(jH);
                if (!reentrantLock.tryLock(time, unit)) {
                    return false;
                }
            }
        }
        try {
            if (!guard.a()) {
                if (jY != 0) {
                    jH = E(jY, jH);
                }
                z10 = c(guard, jH, zIsHeldByCurrentThread);
            }
            if (!z10) {
                reentrantLock.unlock();
            }
            return z10;
        } catch (Throwable th2) {
            if (!zIsHeldByCurrentThread) {
                try {
                    G();
                } finally {
                    reentrantLock.unlock();
                }
            }
            throw th2;
        }
    }

    public void q(a guard) {
        if (guard.f13770a != this) {
            throw new IllegalMonitorStateException();
        }
        ReentrantLock reentrantLock = this.f13768b;
        boolean zIsHeldByCurrentThread = reentrantLock.isHeldByCurrentThread();
        reentrantLock.lock();
        try {
            if (guard.a()) {
                return;
            }
            d(guard, zIsHeldByCurrentThread);
        } catch (Throwable th2) {
            D();
            throw th2;
        }
    }

    public boolean r(a guard, long time, TimeUnit unit) throws Throwable {
        long jY;
        long jE;
        long jH = H(time, unit);
        if (guard.f13770a != this) {
            throw new IllegalMonitorStateException();
        }
        ReentrantLock reentrantLock = this.f13768b;
        boolean zIsHeldByCurrentThread = reentrantLock.isHeldByCurrentThread();
        boolean zInterrupted = Thread.interrupted();
        try {
            boolean zC = true;
            if (this.f13767a || !reentrantLock.tryLock()) {
                jY = y(jH);
                long jE2 = jH;
                while (true) {
                    try {
                        try {
                            break;
                        } catch (Throwable th2) {
                            th = th2;
                            zInterrupted = true;
                            if (zInterrupted) {
                                Thread.currentThread().interrupt();
                            }
                            throw th;
                        }
                    } catch (InterruptedException unused) {
                        jE2 = E(jY, jH);
                        zInterrupted = true;
                    }
                }
                if (!reentrantLock.tryLock(jE2, TimeUnit.NANOSECONDS)) {
                    if (zInterrupted) {
                        Thread.currentThread().interrupt();
                    }
                    return false;
                }
            } else {
                jY = 0;
            }
            while (!guard.a()) {
                try {
                    if (jY == 0) {
                        jY = y(jH);
                        jE = jH;
                    } else {
                        jE = E(jY, jH);
                    }
                    zC = c(guard, jE, zIsHeldByCurrentThread);
                } catch (InterruptedException unused2) {
                    zIsHeldByCurrentThread = false;
                    zInterrupted = zC;
                } catch (Throwable th3) {
                    reentrantLock.unlock();
                    throw th3;
                }
            }
            if (!zC) {
                reentrantLock.unlock();
            }
            if (zInterrupted) {
                Thread.currentThread().interrupt();
            }
            return zC;
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public int s() {
        return this.f13768b.getHoldCount();
    }

    public int t() {
        return this.f13768b.getQueueLength();
    }

    public int u(a guard) {
        if (guard.f13770a != this) {
            throw new IllegalMonitorStateException();
        }
        this.f13768b.lock();
        try {
            return guard.f13772c;
        } finally {
            this.f13768b.unlock();
        }
    }

    public boolean v(Thread thread) {
        return this.f13768b.hasQueuedThread(thread);
    }

    public boolean w() {
        return this.f13768b.hasQueuedThreads();
    }

    public boolean x(a guard) {
        return u(guard) > 0;
    }

    public boolean z() {
        return this.f13767a;
    }

    public y1(boolean fair) {
        this.f13769c = null;
        this.f13767a = fair;
        this.f13768b = new ReentrantLock(fair);
    }
}
