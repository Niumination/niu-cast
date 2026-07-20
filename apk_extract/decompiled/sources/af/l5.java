package af;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;
import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public final class l5 implements Executor {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Logger f441c = Logger.getLogger(l5.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f442a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayDeque f443b;

    public final void a() {
        while (true) {
            Runnable runnable = (Runnable) this.f443b.poll();
            if (runnable == null) {
                return;
            }
            try {
                runnable.run();
            } catch (Throwable th2) {
                f441c.log(Level.SEVERE, "Exception while executing runnable " + runnable, th2);
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        v8.i(runnable, "'task' must not be null.");
        if (this.f442a) {
            if (this.f443b == null) {
                this.f443b = new ArrayDeque(4);
            }
            this.f443b.add(runnable);
            return;
        }
        this.f442a = true;
        try {
            runnable.run();
            if (this.f443b != null) {
            }
        } catch (Throwable th2) {
            try {
                f441c.log(Level.SEVERE, "Exception while executing runnable " + runnable, th2);
            } finally {
                if (this.f443b != null) {
                    a();
                }
                this.f442a = false;
            }
        }
    }
}
