package wj;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class t2 implements Executor, Runnable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Logger f19297d = Logger.getLogger(t2.class.getName());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f19298e = c();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f19299f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f19300g = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Executor f19301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Queue<Runnable> f19302b = new ConcurrentLinkedQueue();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile int f19303c = 0;

    public static abstract class b {
        public b() {
        }

        public abstract boolean a(t2 t2Var, int i10, int i11);

        public abstract void b(t2 t2Var, int i10);

        public b(a aVar) {
        }
    }

    public static final class c extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicIntegerFieldUpdater<t2> f19304a;

        public c(AtomicIntegerFieldUpdater<t2> atomicIntegerFieldUpdater) {
            this.f19304a = atomicIntegerFieldUpdater;
        }

        @Override // wj.t2.b
        public boolean a(t2 t2Var, int i10, int i11) {
            return this.f19304a.compareAndSet(t2Var, i10, i11);
        }

        @Override // wj.t2.b
        public void b(t2 t2Var, int i10) {
            this.f19304a.set(t2Var, i10);
        }
    }

    public static final class d extends b {
        public d() {
        }

        @Override // wj.t2.b
        public boolean a(t2 t2Var, int i10, int i11) {
            synchronized (t2Var) {
                try {
                    if (t2Var.f19303c != i10) {
                        return false;
                    }
                    t2Var.f19303c = i11;
                    return true;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // wj.t2.b
        public void b(t2 t2Var, int i10) {
            synchronized (t2Var) {
                t2Var.f19303c = i10;
            }
        }

        public d(a aVar) {
        }
    }

    public t2(Executor executor) {
        c1.h0.F(executor, "'executor' must not be null.");
        this.f19301a = executor;
    }

    public static b c() {
        try {
            return new c(AtomicIntegerFieldUpdater.newUpdater(t2.class, "c"));
        } catch (Throwable th2) {
            f19297d.log(Level.SEVERE, "FieldUpdaterAtomicHelper failed", th2);
            return new d();
        }
    }

    public final void d(@gm.j Runnable runnable) {
        if (f19298e.a(this, 0, -1)) {
            try {
                this.f19301a.execute(this);
            } catch (Throwable th2) {
                if (runnable != null) {
                    this.f19302b.remove(runnable);
                }
                f19298e.b(this, 0);
                throw th2;
            }
        }
    }

    public void e(Executor executor) {
        c1.h0.F(executor, "'executor' must not be null.");
        this.f19301a = executor;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f19302b.add((Runnable) c1.h0.F(runnable, "'r' must not be null."));
        d(runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable runnablePoll;
        try {
            Executor executor = this.f19301a;
            while (executor == this.f19301a && (runnablePoll = this.f19302b.poll()) != null) {
                try {
                    runnablePoll.run();
                } catch (RuntimeException e10) {
                    f19297d.log(Level.SEVERE, "Exception while executing runnable " + runnablePoll, (Throwable) e10);
                }
            }
            f19298e.b(this, 0);
            if (this.f19302b.isEmpty()) {
                return;
            }
            d(null);
        } catch (Throwable th2) {
            f19298e.b(this, 0);
            throw th2;
        }
    }
}
