package e6;

import android.os.Process;
import android.os.StrictMode;
import android.util.Log;
import androidx.annotation.NonNull;
import java.io.File;
import java.io.FilenameFilter;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends ThreadPoolExecutor {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f4071b = "source";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f4072c = "zero";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f4073d = "disk-cache";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f4074e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f4075f = "ZeroPoolExecutor";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f4076g = "cpu[0-9]+";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f4077i = "/sys/devices/system/cpu/";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f4078n = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f4079a;

    public static class a implements FilenameFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Pattern f4080a;

        public a(Pattern pattern) {
            this.f4080a = pattern;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return this.f4080a.matcher(str).matches();
        }
    }

    /* JADX INFO: renamed from: e6.c$c, reason: collision with other inner class name */
    public static final class ThreadFactoryC0095c implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f4083a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final d f4084b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f4085c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f4086d;

        /* JADX INFO: renamed from: e6.c$c$a */
        public class a extends Thread {
            public a(Runnable runnable, String str) {
                super(runnable, str);
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(10);
                if (ThreadFactoryC0095c.this.f4085c) {
                    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                }
                try {
                    super.run();
                } catch (Throwable th2) {
                    ThreadFactoryC0095c.this.f4084b.handle(th2);
                }
            }
        }

        public ThreadFactoryC0095c(String str, d dVar, boolean z10) {
            this.f4083a = str;
            this.f4084b = dVar;
            this.f4085c = z10;
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(@NonNull Runnable runnable) {
            a aVar;
            aVar = new a(runnable, "zero-" + this.f4083a + "-thread-" + this.f4086d);
            this.f4086d = this.f4086d + 1;
            return aVar;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static class d {
        public static final d DEFAULT;
        public static final d IGNORE;
        public static final d LOG;
        public static final d THROW;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ d[] f4088a;

        public static enum a extends d {
            public a(String str, int i10) {
                super(str, i10, null);
            }

            @Override // e6.c.d
            public void handle(Throwable th2) {
                d6.a.G(c.f4075f, "Request threw uncaught throwable", th2);
            }
        }

        public static enum b extends d {
            public b(String str, int i10) {
                super(str, i10, null);
            }

            @Override // e6.c.d
            public void handle(Throwable th2) {
                super.handle(th2);
                if (th2 != null) {
                    throw new RuntimeException("Request threw uncaught throwable", th2);
                }
            }
        }

        static {
            d dVar = new d("IGNORE", 0);
            IGNORE = dVar;
            a aVar = new a("LOG", 1);
            LOG = aVar;
            b bVar = new b("THROW", 2);
            THROW = bVar;
            f4088a = new d[]{dVar, aVar, bVar};
            DEFAULT = aVar;
        }

        public d(String str, int i10) {
            super(str, i10);
        }

        public static d valueOf(String str) {
            return (d) Enum.valueOf(d.class, str);
        }

        public static d[] values() {
            return (d[]) f4088a.clone();
        }

        public void handle(Throwable th2) {
        }

        public d(String str, int i10, a aVar) {
            super(str, i10);
        }
    }

    public c(int i10, String str, d dVar, boolean z10, boolean z11) {
        super(0, Integer.MAX_VALUE, 60L, TimeUnit.MILLISECONDS, new SynchronousQueue(), new ThreadFactoryC0095c(str, dVar, z10));
        this.f4079a = z11;
        try {
            Log.d("ThreadPool", "size is :" + getPoolSize());
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static int a() {
        File[] fileArrListFiles;
        try {
            fileArrListFiles = new File(f4077i).listFiles(new a(Pattern.compile(f4076g)));
        } catch (Throwable th2) {
            d6.a.G(f4075f, "Failed to calculate accurate cpu count", th2);
            fileArrListFiles = null;
        }
        return Math.min(4, Math.max(Math.max(1, Runtime.getRuntime().availableProcessors()), fileArrListFiles != null ? fileArrListFiles.length : 0));
    }

    public static c c() {
        return d(1, f4073d, d.DEFAULT);
    }

    public static c d(int i10, String str, d dVar) {
        return new c(i10, str, dVar, true, false);
    }

    public static c e() {
        return f(a(), "source", d.DEFAULT);
    }

    public static c f(int i10, String str, d dVar) {
        return new c(i10, str, dVar, false, false);
    }

    public static c g() {
        return new c(20, f4072c, d.DEFAULT, false, false);
    }

    public static c h(int i10) {
        if (i10 <= 0) {
            i10 = 20;
        }
        return new c(i10, f4072c, d.DEFAULT, false, false);
    }

    public final <T> Future<T> b(Future<T> future) {
        if (this.f4079a) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e10) {
                throw new RuntimeException(e10);
            }
        }
        return future;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (this.f4079a) {
            runnable.run();
        } else {
            super.execute(runnable);
        }
    }

    @Override // java.util.concurrent.AbstractExecutorService
    public <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t10) {
        return new b(runnable, t10);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    @NonNull
    public Future<?> submit(Runnable runnable) {
        return b(super.submit(runnable));
    }

    @Override // java.util.concurrent.AbstractExecutorService
    public <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new b(callable);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    @NonNull
    public <T> Future<T> submit(Runnable runnable, T t10) {
        return b(super.submit(runnable, t10));
    }

    public class b<V> extends FutureTask<V> implements Comparable<b<V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f4081a;

        public b(Callable<V> callable) {
            super(callable);
            this.f4081a = callable;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(b<V> bVar) {
            if (this == bVar) {
                return 0;
            }
            if (bVar == null) {
                return -1;
            }
            Object obj = this.f4081a;
            if (obj != null && bVar.f4081a != null && obj.getClass().equals(bVar.f4081a.getClass())) {
                Object obj2 = this.f4081a;
                if (obj2 instanceof Comparable) {
                    return ((Comparable) obj2).compareTo(bVar.f4081a);
                }
            }
            return 0;
        }

        public b(Runnable runnable, V v10) {
            super(runnable, v10);
            this.f4081a = runnable;
        }
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Callable<T> callable) {
        return b(super.submit(callable));
    }
}
