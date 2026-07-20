package i6;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f7721a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f7722b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f7723c;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f7724a = new a(new c(), new m());
    }

    public static class c implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f7725a;

        public c() {
            this.f7725a = new Handler(Looper.getMainLooper());
        }

        public void a(Runnable runnable, int i10) {
            this.f7725a.postDelayed(runnable, i10);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f7725a.post(runnable);
        }
    }

    public static a c() {
        return b.f7724a;
    }

    public void a(Runnable runnable) {
        this.f7721a.execute(runnable);
    }

    public void b(Runnable runnable) {
        this.f7722b.execute(runnable);
    }

    public void d(Runnable runnable, int i10) {
        this.f7721a.a(runnable, i10);
    }

    public e e() {
        return this.f7723c;
    }

    public a(c cVar, e eVar) {
        this.f7721a = cVar;
        this.f7723c = eVar;
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        this.f7722b = new ThreadPoolExecutor(iAvailableProcessors, iAvailableProcessors * 2, 60L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    }
}
