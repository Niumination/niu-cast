package com.transsion.core.pool;

import java.lang.ref.WeakReference;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes2.dex */
public class HttpPoolManager implements PoolManagerImpl {
    private static volatile HttpPoolManager mInstance;
    private ThreadPoolExecutor executor;

    public static HttpPoolManager getInstance() {
        if (mInstance == null) {
            synchronized (HttpPoolManager.class) {
                try {
                    if (mInstance == null) {
                        mInstance = new HttpPoolManager();
                        mInstance.executor = TranssionPoolExecutor.newSourceExecutor();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return mInstance;
    }

    @Override // com.transsion.core.pool.PoolManagerImpl
    public void addTask(Runnable runnable) {
        ThreadPoolExecutor threadPoolExecutor = this.executor;
        if (threadPoolExecutor != null) {
            if (threadPoolExecutor.isShutdown()) {
                this.executor.prestartAllCoreThreads();
            }
            this.executor.execute(runnable);
        }
    }

    @Override // com.transsion.core.pool.PoolManagerImpl
    public void destroy() {
        ThreadPoolExecutor threadPoolExecutor = this.executor;
        if (threadPoolExecutor == null || threadPoolExecutor.isShutdown()) {
            return;
        }
        this.executor.shutdown();
        this.executor = null;
    }

    @Override // com.transsion.core.pool.PoolManagerImpl
    public void execute(WeakReference<Runnable> weakReference) {
        Runnable runnable = weakReference.get();
        if (runnable != null) {
            addTask(runnable);
        }
    }

    @Override // com.transsion.core.pool.PoolManagerImpl
    public void purge() {
        ThreadPoolExecutor threadPoolExecutor = this.executor;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.purge();
        }
    }

    @Override // com.transsion.core.pool.PoolManagerImpl
    public void shutdown() {
        ThreadPoolExecutor threadPoolExecutor = this.executor;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.shutdown();
        }
    }
}
