package io.netty.util.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultEventExecutorGroup extends MultithreadEventExecutorGroup {
    public DefaultEventExecutorGroup(int i10) {
        this(i10, null);
    }

    @Override // io.netty.util.concurrent.MultithreadEventExecutorGroup
    public EventExecutor newChild(Executor executor, Object... objArr) throws Exception {
        return new DefaultEventExecutor(this, executor, ((Integer) objArr[0]).intValue(), (RejectedExecutionHandler) objArr[1]);
    }

    public DefaultEventExecutorGroup(int i10, ThreadFactory threadFactory) {
        this(i10, threadFactory, SingleThreadEventExecutor.DEFAULT_MAX_PENDING_EXECUTOR_TASKS, RejectedExecutionHandlers.reject());
    }

    public DefaultEventExecutorGroup(int i10, ThreadFactory threadFactory, int i11, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i10, threadFactory, Integer.valueOf(i11), rejectedExecutionHandler);
    }
}
