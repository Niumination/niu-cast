package com.transsion.core.pool;

import android.os.Process;
import android.os.StrictMode;
import android.util.Log;
import androidx.annotation.NonNull;
import com.transsion.core.log.LogUtils;
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
public final class TranssionPoolExecutor extends ThreadPoolExecutor {
    private static final String CPU_LOCATION = "/sys/devices/system/cpu/";
    private static final String CPU_NAME_REGEX = "cpu[0-9]+";
    public static final String DEFAULT_DISK_CACHE_EXECUTOR_NAME = "disk-cache";
    public static final int DEFAULT_DISK_CACHE_EXECUTOR_THREADS = 1;
    public static final String DEFAULT_SOURCE_EXECUTOR_NAME = "source";
    private static final int MAXIMUM_AUTOMATIC_THREAD_COUNT = 4;
    private static final String TAG = "ZeroPoolExecutor";
    public static final String TRANSSION_EXECUTOR_NAME = "zero";
    private final boolean executeSynchronously;

    public class ComparableFutureTask<V> extends FutureTask<V> implements Comparable<ComparableFutureTask<V>> {
        private Object object;

        public ComparableFutureTask(Callable<V> callable) {
            super(callable);
            this.object = callable;
        }

        @Override // java.lang.Comparable
        public int compareTo(ComparableFutureTask<V> comparableFutureTask) {
            if (this == comparableFutureTask) {
                return 0;
            }
            if (comparableFutureTask == null) {
                return -1;
            }
            Object obj = this.object;
            if (obj != null && comparableFutureTask.object != null && obj.getClass().equals(comparableFutureTask.object.getClass())) {
                Object obj2 = this.object;
                if (obj2 instanceof Comparable) {
                    return ((Comparable) obj2).compareTo(comparableFutureTask.object);
                }
            }
            return 0;
        }

        public ComparableFutureTask(Runnable runnable, V v3) {
            super(runnable, v3);
            this.object = runnable;
        }
    }

    public static final class DefaultThreadFactory implements ThreadFactory {
        private final String name;
        private final boolean preventNetworkOperations;
        private int threadNum;
        private final UncaughtThrowableStrategy uncaughtThrowableStrategy;

        public DefaultThreadFactory(String str, UncaughtThrowableStrategy uncaughtThrowableStrategy, boolean z2) {
            this.name = str;
            this.uncaughtThrowableStrategy = uncaughtThrowableStrategy;
            this.preventNetworkOperations = z2;
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(@NonNull Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "zero-" + this.name + "-thread-" + this.threadNum) { // from class: com.transsion.core.pool.TranssionPoolExecutor.DefaultThreadFactory.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    Process.setThreadPriority(10);
                    if (DefaultThreadFactory.this.preventNetworkOperations) {
                        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                    }
                    try {
                        super.run();
                    } catch (Throwable th2) {
                        DefaultThreadFactory.this.uncaughtThrowableStrategy.handle(th2);
                    }
                }
            };
            this.threadNum = this.threadNum + 1;
            return thread;
        }
    }

    public enum UncaughtThrowableStrategy {
        IGNORE,
        LOG { // from class: com.transsion.core.pool.TranssionPoolExecutor.UncaughtThrowableStrategy.1
            @Override // com.transsion.core.pool.TranssionPoolExecutor.UncaughtThrowableStrategy
            public void handle(Throwable th2) {
                LogUtils.d(TranssionPoolExecutor.TAG, "Request threw uncaught throwable", th2);
            }
        },
        THROW { // from class: com.transsion.core.pool.TranssionPoolExecutor.UncaughtThrowableStrategy.2
            @Override // com.transsion.core.pool.TranssionPoolExecutor.UncaughtThrowableStrategy
            public void handle(Throwable th2) {
                super.handle(th2);
                if (th2 != null) {
                    throw new RuntimeException("Request threw uncaught throwable", th2);
                }
            }
        };

        public static final UncaughtThrowableStrategy DEFAULT = LOG;

        public void handle(Throwable th2) {
        }
    }

    public TranssionPoolExecutor(int i8, String str, UncaughtThrowableStrategy uncaughtThrowableStrategy, boolean z2, boolean z3) {
        super(0, Integer.MAX_VALUE, 60L, TimeUnit.MILLISECONDS, new SynchronousQueue(), new DefaultThreadFactory(str, uncaughtThrowableStrategy, z2));
        this.executeSynchronously = z3;
        try {
            Log.d("ThreadPool", "size is :" + getPoolSize());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int calculateBestThreadCount() {
        File[] fileArrListFiles;
        try {
            File file = new File(CPU_LOCATION);
            final Pattern patternCompile = Pattern.compile(CPU_NAME_REGEX);
            fileArrListFiles = file.listFiles(new FilenameFilter() { // from class: com.transsion.core.pool.TranssionPoolExecutor.1
                @Override // java.io.FilenameFilter
                public boolean accept(File file2, String str) {
                    return patternCompile.matcher(str).matches();
                }
            });
        } catch (Throwable th2) {
            LogUtils.d(TAG, "Failed to calculate accurate cpu count", th2);
            fileArrListFiles = null;
        }
        return Math.min(4, Math.max(Math.max(1, Runtime.getRuntime().availableProcessors()), fileArrListFiles != null ? fileArrListFiles.length : 0));
    }

    private <T> Future<T> maybeWait(Future<T> future) {
        if (this.executeSynchronously) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        return future;
    }

    public static TranssionPoolExecutor newDiskCacheExecutor() {
        return newDiskCacheExecutor(1, DEFAULT_DISK_CACHE_EXECUTOR_NAME, UncaughtThrowableStrategy.DEFAULT);
    }

    public static TranssionPoolExecutor newSourceExecutor() {
        return newSourceExecutor(calculateBestThreadCount(), DEFAULT_SOURCE_EXECUTOR_NAME, UncaughtThrowableStrategy.DEFAULT);
    }

    public static TranssionPoolExecutor newTranssionExecutor() {
        return new TranssionPoolExecutor(20, TRANSSION_EXECUTOR_NAME, UncaughtThrowableStrategy.DEFAULT, false, false);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (this.executeSynchronously) {
            runnable.run();
        } else {
            super.execute(runnable);
        }
    }

    @Override // java.util.concurrent.AbstractExecutorService
    public <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t3) {
        return new ComparableFutureTask(runnable, t3);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    @NonNull
    public Future<?> submit(Runnable runnable) {
        return maybeWait(super.submit(runnable));
    }

    public static TranssionPoolExecutor newDiskCacheExecutor(int i8, String str, UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        return new TranssionPoolExecutor(i8, str, uncaughtThrowableStrategy, true, false);
    }

    public static TranssionPoolExecutor newSourceExecutor(int i8, String str, UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        return new TranssionPoolExecutor(i8, str, uncaughtThrowableStrategy, false, false);
    }

    public static TranssionPoolExecutor newTranssionExecutor(int i8) {
        if (i8 <= 0) {
            i8 = 20;
        }
        return new TranssionPoolExecutor(i8, TRANSSION_EXECUTOR_NAME, UncaughtThrowableStrategy.DEFAULT, false, false);
    }

    @Override // java.util.concurrent.AbstractExecutorService
    public <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new ComparableFutureTask(callable);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    @NonNull
    public <T> Future<T> submit(Runnable runnable, T t3) {
        return maybeWait(super.submit(runnable, t3));
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Callable<T> callable) {
        return maybeWait(super.submit(callable));
    }
}
