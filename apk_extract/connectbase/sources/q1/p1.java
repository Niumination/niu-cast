package q1;

import com.google.j2objc.annotations.ReflectionSupport;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.AbstractOwnableSynchronizer;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true)
@o0
@ReflectionSupport(ReflectionSupport.Level.FULL)
public abstract class p1<T> extends AtomicReference<Runnable> implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Runnable f13654a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Runnable f13655b = new c();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f13656c = 1000;

    @b1.e
    public static final class b extends AbstractOwnableSynchronizer implements Runnable {
        private final p1<?> task;

        public final void a(Thread thread) {
            setExclusiveOwnerThread(thread);
        }

        @gm.a
        @b1.e
        public Thread getOwner() {
            return getExclusiveOwnerThread();
        }

        @Override // java.lang.Runnable
        public void run() {
        }

        public String toString() {
            return this.task.toString();
        }

        public b(p1<?> task) {
            this.task = task;
        }
    }

    public static final class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
        }

        public c(a aVar) {
        }
    }

    public final void a(Thread currentThread) {
        Runnable runnable = get();
        b bVar = null;
        boolean z10 = false;
        int i10 = 0;
        while (true) {
            boolean z11 = runnable instanceof b;
            if (!z11 && runnable != f13655b) {
                break;
            }
            if (z11) {
                bVar = (b) runnable;
            }
            i10++;
            if (i10 > 1000) {
                Runnable runnable2 = f13655b;
                if (runnable == runnable2 || compareAndSet(runnable, runnable2)) {
                    z10 = Thread.interrupted() || z10;
                    LockSupport.park(bVar);
                }
            } else {
                Thread.yield();
            }
            runnable = get();
        }
        if (z10) {
            currentThread.interrupt();
        }
    }

    public abstract void afterRanInterruptiblyFailure(Throwable error);

    public abstract void afterRanInterruptiblySuccess(@c2 T result);

    public final void interruptTask() {
        Runnable runnable = get();
        if (runnable instanceof Thread) {
            b bVar = new b();
            bVar.setExclusiveOwnerThread(Thread.currentThread());
            if (compareAndSet(runnable, bVar)) {
                try {
                    ((Thread) runnable).interrupt();
                } finally {
                    if (getAndSet(f13654a) == f13655b) {
                        LockSupport.unpark((Thread) runnable);
                    }
                }
            }
        }
    }

    public abstract boolean isDone();

    @Override // java.lang.Runnable
    public final void run() {
        Thread threadCurrentThread = Thread.currentThread();
        T tRunInterruptibly = null;
        if (compareAndSet(null, threadCurrentThread)) {
            boolean zIsDone = isDone();
            if (!zIsDone) {
                try {
                    tRunInterruptibly = runInterruptibly();
                } catch (Throwable th2) {
                    try {
                        e2.b(th2);
                        if (!compareAndSet(threadCurrentThread, f13654a)) {
                            a(threadCurrentThread);
                        }
                        if (zIsDone) {
                            return;
                        }
                        afterRanInterruptiblyFailure(th2);
                        return;
                    } catch (Throwable th3) {
                        if (!compareAndSet(threadCurrentThread, f13654a)) {
                            a(threadCurrentThread);
                        }
                        if (!zIsDone) {
                            afterRanInterruptiblySuccess(null);
                        }
                        throw th3;
                    }
                }
            }
            if (!compareAndSet(threadCurrentThread, f13654a)) {
                a(threadCurrentThread);
            }
            if (zIsDone) {
                return;
            }
            afterRanInterruptiblySuccess(tRunInterruptibly);
        }
    }

    @c2
    public abstract T runInterruptibly() throws Exception;

    public abstract String toPendingString();

    @Override // java.util.concurrent.atomic.AtomicReference
    public final String toString() {
        String str;
        Runnable runnable = get();
        if (runnable == f13654a) {
            str = "running=[DONE]";
        } else if (runnable instanceof b) {
            str = "running=[INTERRUPTED]";
        } else if (runnable instanceof Thread) {
            str = "running=[RUNNING ON " + ((Thread) runnable).getName() + "]";
        } else {
            str = "running=[NOT STARTED YET]";
        }
        StringBuilder sbA = k.c.a(str, ", ");
        sbA.append(toPendingString());
        return sbA.toString();
    }
}
