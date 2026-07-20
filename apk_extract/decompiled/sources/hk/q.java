package hk;

import ik.v;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public final class q extends AtomicReference implements Runnable, ck.j {
    private static final long serialVersionUID = -3962399486978279857L;
    final ek.a action;
    final v cancel;

    public q(ek.a aVar) {
        this.action = aVar;
        this.cancel = new v();
    }

    public void add(ck.j jVar) {
        this.cancel.a(jVar);
    }

    public void addParent(qk.b bVar) {
        this.cancel.a(new p(this, bVar));
    }

    @Override // ck.j
    public boolean isUnsubscribed() {
        return this.cancel.f5909b;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            lazySet(Thread.currentThread());
            this.action.call();
        } catch (Throwable th2) {
            try {
                IllegalStateException illegalStateException = th2 instanceof dk.g ? new IllegalStateException("Exception thrown on Scheduler.Worker thread. Add `onError` handling.", th2) : new IllegalStateException("Fatal Exception thrown on Scheduler.Worker thread.", th2);
                nk.c.f8331d.a().getClass();
                Thread threadCurrentThread = Thread.currentThread();
                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, illegalStateException);
            } finally {
                unsubscribe();
            }
        }
    }

    @Override // ck.j
    public void unsubscribe() {
        if (this.cancel.f5909b) {
            return;
        }
        this.cancel.unsubscribe();
    }

    public void add(Future<?> future) {
        this.cancel.a(new n(this, future));
    }

    public void addParent(v vVar) {
        this.cancel.a(new o(this, vVar));
    }

    public q(ek.a aVar, qk.b bVar) {
        this.action = aVar;
        this.cancel = new v(new p(this, bVar));
    }

    public q(ek.a aVar, v vVar) {
        this.action = aVar;
        this.cancel = new v(new o(this, vVar));
    }
}
