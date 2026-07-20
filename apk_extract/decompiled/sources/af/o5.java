package af;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;
import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public final class o5 implements Executor, Runnable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Logger f486d = Logger.getLogger(o5.class.getName());
    public static final d6 e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentLinkedQueue f488b = new ConcurrentLinkedQueue();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile int f489c = 0;

    static {
        d6 n5Var;
        try {
            n5Var = new m5(AtomicIntegerFieldUpdater.newUpdater(o5.class, "c"));
        } catch (Throwable th2) {
            f486d.log(Level.SEVERE, "FieldUpdaterAtomicHelper failed", th2);
            n5Var = new n5();
        }
        e = n5Var;
    }

    public o5(Executor executor) {
        v8.i(executor, "'executor' must not be null.");
        this.f487a = executor;
    }

    public final void a(Runnable runnable) {
        d6 d6Var = e;
        if (d6Var.s(this)) {
            try {
                this.f487a.execute(this);
            } catch (Throwable th2) {
                if (runnable != null) {
                    this.f488b.remove(runnable);
                }
                d6Var.t(this);
                throw th2;
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        ConcurrentLinkedQueue concurrentLinkedQueue = this.f488b;
        v8.i(runnable, "'r' must not be null.");
        concurrentLinkedQueue.add(runnable);
        a(runnable);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ConcurrentLinkedQueue concurrentLinkedQueue;
        Runnable runnable;
        d6 d6Var = e;
        try {
            Executor executor = this.f487a;
            while (true) {
                Executor executor2 = this.f487a;
                concurrentLinkedQueue = this.f488b;
                if (executor != executor2 || (runnable = (Runnable) concurrentLinkedQueue.poll()) == null) {
                    break;
                }
                try {
                    runnable.run();
                } catch (RuntimeException e4) {
                    f486d.log(Level.SEVERE, "Exception while executing runnable " + runnable, (Throwable) e4);
                }
            }
            d6Var.t(this);
            if (concurrentLinkedQueue.isEmpty()) {
                return;
            }
            a(null);
        } catch (Throwable th2) {
            d6Var.t(this);
            throw th2;
        }
    }
}
