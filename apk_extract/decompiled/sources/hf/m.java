package hf;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
public final class m extends ConcurrentLinkedQueue implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f5315a = Logger.getLogger(m.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f5316b = new Object();
    private volatile Object waiter;

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        add(runnable);
        Object obj = this.waiter;
        if (obj != f5316b) {
            LockSupport.unpark((Thread) obj);
        } else if (remove(runnable) && n.f5318b) {
            throw new RejectedExecutionException();
        }
    }

    public void shutdown() {
        this.waiter = f5316b;
        while (true) {
            Runnable runnable = (Runnable) poll();
            if (runnable == null) {
                return;
            }
            try {
                runnable.run();
            } catch (Throwable th2) {
                f5315a.log(Level.WARNING, "Runnable threw exception", th2);
            }
        }
    }

    public void waitAndDrain() throws InterruptedException {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Runnable runnable = (Runnable) poll();
        if (runnable == null) {
            this.waiter = Thread.currentThread();
            while (true) {
                try {
                    Runnable runnable2 = (Runnable) poll();
                    if (runnable2 != null) {
                        this.waiter = null;
                        runnable = runnable2;
                        break;
                    } else {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            throw new InterruptedException();
                        }
                    }
                } catch (Throwable th2) {
                    this.waiter = null;
                    throw th2;
                }
            }
        }
        do {
            try {
                runnable.run();
            } catch (Throwable th3) {
                f5315a.log(Level.WARNING, "Runnable threw exception", th3);
            }
            runnable = (Runnable) poll();
        } while (runnable != null);
    }
}
