package io.netty.util.concurrent;

/* JADX INFO: loaded from: classes3.dex */
public interface EventExecutor extends EventExecutorGroup {
    boolean inEventLoop();

    boolean inEventLoop(Thread thread);

    <V> Future<V> newFailedFuture(Throwable th2);

    <V> ProgressivePromise<V> newProgressivePromise();

    <V> Promise<V> newPromise();

    <V> Future<V> newSucceededFuture(V v10);

    @Override // io.netty.util.concurrent.EventExecutorGroup
    EventExecutor next();

    EventExecutorGroup parent();
}
