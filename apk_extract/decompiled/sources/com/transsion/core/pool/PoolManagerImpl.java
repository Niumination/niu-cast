package com.transsion.core.pool;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public interface PoolManagerImpl {
    void addTask(Runnable runnable);

    void destroy();

    void execute(WeakReference<Runnable> weakReference);

    void purge();

    void shutdown();
}
