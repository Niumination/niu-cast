package com.transsion.core.pool;

import java.lang.ref.WeakReference;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes2.dex */
public class TranssionPoolManager implements PoolManagerImpl {
    private static volatile TranssionPoolManager mInstance;
    private static ThreadPoolExecutor sDefaultExecutor;
    private ThreadPoolExecutor executor;

    public static TranssionPoolManager getInstance() {
        if (mInstance == null) {
            synchronized (TranssionPoolManager.class) {
                try {
                    if (mInstance == null) {
                        mInstance = new TranssionPoolManager();
                        TranssionPoolManager transsionPoolManager = mInstance;
                        ThreadPoolExecutor threadPoolExecutorNewTranssionExecutor = sDefaultExecutor;
                        if (threadPoolExecutorNewTranssionExecutor == null) {
                            threadPoolExecutorNewTranssionExecutor = TranssionPoolExecutor.newTranssionExecutor();
                        }
                        transsionPoolManager.executor = threadPoolExecutorNewTranssionExecutor;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return mInstance;
    }

    public static void setDefaultExecutor(ThreadPoolExecutor threadPoolExecutor) {
        sDefaultExecutor = threadPoolExecutor;
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

    public static synchronized TranssionPoolManager getInstance(int i8) {
        try {
            if (mInstance == null) {
                synchronized (TranssionPoolManager.class) {
                    try {
                        if (mInstance == null) {
                            mInstance = new TranssionPoolManager();
                            TranssionPoolManager transsionPoolManager = mInstance;
                            ThreadPoolExecutor threadPoolExecutorNewTranssionExecutor = sDefaultExecutor;
                            if (threadPoolExecutorNewTranssionExecutor == null) {
                                threadPoolExecutorNewTranssionExecutor = TranssionPoolExecutor.newTranssionExecutor(i8);
                            }
                            transsionPoolManager.executor = threadPoolExecutorNewTranssionExecutor;
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
        } catch (Throwable th3) {
            throw th3;
        }
        return mInstance;
    }
}
