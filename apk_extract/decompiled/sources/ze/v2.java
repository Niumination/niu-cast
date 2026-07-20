package ze;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public final class v2 implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Thread.UncaughtExceptionHandler f11457a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentLinkedQueue f11458b = new ConcurrentLinkedQueue();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReference f11459c = new AtomicReference();

    public v2(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f11457a = uncaughtExceptionHandler;
    }

    public final void a() {
        ConcurrentLinkedQueue concurrentLinkedQueue;
        do {
            AtomicReference atomicReference = this.f11459c;
            if (!atomicReference.compareAndSet(null, Thread.currentThread())) {
                return;
            }
            while (true) {
                concurrentLinkedQueue = this.f11458b;
                try {
                    Runnable runnable = (Runnable) concurrentLinkedQueue.poll();
                    if (runnable == null) {
                        break;
                    }
                    try {
                        runnable.run();
                    } catch (Throwable th2) {
                        this.f11457a.uncaughtException(Thread.currentThread(), th2);
                    }
                } catch (Throwable th3) {
                    atomicReference.set(null);
                    throw th3;
                }
            }
            atomicReference.set(null);
        } while (!concurrentLinkedQueue.isEmpty());
    }

    public final void b(Runnable runnable) {
        ConcurrentLinkedQueue concurrentLinkedQueue = this.f11458b;
        v8.i(runnable, "runnable is null");
        concurrentLinkedQueue.add(runnable);
    }

    public final u6.c c(Runnable runnable, long j8, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        u2 u2Var = new u2(runnable);
        return new u6.c(u2Var, scheduledExecutorService.schedule(new af.m0(this, 11, u2Var, runnable), j8, timeUnit));
    }

    public final void d() {
        v8.n(Thread.currentThread() == this.f11459c.get(), "Not called from the SynchronizationContext");
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        b(runnable);
        a();
    }
}
