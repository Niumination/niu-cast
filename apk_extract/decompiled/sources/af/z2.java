package af;

import java.util.concurrent.Executor;
import k3.v8;
import k3.w8;

/* JADX INFO: loaded from: classes3.dex */
public final class z2 implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a8.a f747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Executor f748b;

    public z2(a8.a aVar) {
        v8.i(aVar, "executorPool");
        this.f747a = aVar;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        Executor executor;
        synchronized (this) {
            try {
                if (this.f748b == null) {
                    Executor executor2 = (Executor) g6.a((f6) this.f747a.f44b);
                    Executor executor3 = this.f748b;
                    if (executor2 == null) {
                        throw new NullPointerException(w8.a("%s.getObject()", executor3));
                    }
                    this.f748b = executor2;
                }
                executor = this.f748b;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        executor.execute(runnable);
    }
}
