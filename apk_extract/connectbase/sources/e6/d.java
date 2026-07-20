package e6;

import java.lang.ref.WeakReference;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes2.dex */
public class d implements b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile d f4089b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static ThreadPoolExecutor f4090c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ThreadPoolExecutor f4091a;

    public static d d() {
        if (f4089b == null) {
            synchronized (d.class) {
                try {
                    if (f4089b == null) {
                        f4089b = new d();
                        d dVar = f4089b;
                        ThreadPoolExecutor threadPoolExecutorG = f4090c;
                        if (threadPoolExecutorG == null) {
                            threadPoolExecutorG = c.g();
                        }
                        dVar.f4091a = threadPoolExecutorG;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f4089b;
    }

    public static synchronized d e(int i10) {
        try {
            if (f4089b == null) {
                synchronized (d.class) {
                    try {
                        if (f4089b == null) {
                            f4089b = new d();
                            d dVar = f4089b;
                            ThreadPoolExecutor threadPoolExecutorH = f4090c;
                            if (threadPoolExecutorH == null) {
                                threadPoolExecutorH = c.h(i10);
                            }
                            dVar.f4091a = threadPoolExecutorH;
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
        } catch (Throwable th3) {
            throw th3;
        }
        return f4089b;
    }

    public static void f(ThreadPoolExecutor threadPoolExecutor) {
        f4090c = threadPoolExecutor;
    }

    @Override // e6.b
    public void a(Runnable runnable) {
        ThreadPoolExecutor threadPoolExecutor = this.f4091a;
        if (threadPoolExecutor != null) {
            if (threadPoolExecutor.isShutdown()) {
                this.f4091a.prestartAllCoreThreads();
            }
            this.f4091a.execute(runnable);
        }
    }

    @Override // e6.b
    public void b(WeakReference<Runnable> weakReference) {
        Runnable runnable = weakReference.get();
        if (runnable != null) {
            a(runnable);
        }
    }

    @Override // e6.b
    public void c() {
        ThreadPoolExecutor threadPoolExecutor = this.f4091a;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.purge();
        }
    }

    @Override // e6.b
    public void destroy() {
        ThreadPoolExecutor threadPoolExecutor = this.f4091a;
        if (threadPoolExecutor == null || threadPoolExecutor.isShutdown()) {
            return;
        }
        this.f4091a.shutdown();
        this.f4091a = null;
    }

    @Override // e6.b
    public void shutdown() {
        ThreadPoolExecutor threadPoolExecutor = this.f4091a;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.shutdown();
        }
    }
}
