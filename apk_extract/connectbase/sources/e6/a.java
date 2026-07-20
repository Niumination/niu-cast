package e6;

import java.lang.ref.WeakReference;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes2.dex */
public class a implements b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile a f4069b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ThreadPoolExecutor f4070a;

    public static a d() {
        if (f4069b == null) {
            synchronized (a.class) {
                try {
                    if (f4069b == null) {
                        f4069b = new a();
                        f4069b.f4070a = c.e();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f4069b;
    }

    @Override // e6.b
    public void a(Runnable runnable) {
        ThreadPoolExecutor threadPoolExecutor = this.f4070a;
        if (threadPoolExecutor != null) {
            if (threadPoolExecutor.isShutdown()) {
                this.f4070a.prestartAllCoreThreads();
            }
            this.f4070a.execute(runnable);
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
        ThreadPoolExecutor threadPoolExecutor = this.f4070a;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.purge();
        }
    }

    @Override // e6.b
    public void destroy() {
        ThreadPoolExecutor threadPoolExecutor = this.f4070a;
        if (threadPoolExecutor == null || threadPoolExecutor.isShutdown()) {
            return;
        }
        this.f4070a.shutdown();
        this.f4070a = null;
    }

    @Override // e6.b
    public void shutdown() {
        ThreadPoolExecutor threadPoolExecutor = this.f4070a;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.shutdown();
        }
    }
}
