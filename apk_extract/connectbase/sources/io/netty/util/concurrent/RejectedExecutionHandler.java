package io.netty.util.concurrent;

/* JADX INFO: loaded from: classes3.dex */
public interface RejectedExecutionHandler {
    void rejected(Runnable runnable, SingleThreadEventExecutor singleThreadEventExecutor);
}
