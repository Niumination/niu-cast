package io.netty.channel.epoll;

import io.netty.channel.DefaultSelectStrategyFactory;
import io.netty.channel.EventLoop;
import io.netty.channel.EventLoopTaskQueueFactory;
import io.netty.channel.MultithreadEventLoopGroup;
import io.netty.channel.SelectStrategyFactory;
import io.netty.util.concurrent.EventExecutorChooserFactory;
import io.netty.util.concurrent.RejectedExecutionHandler;
import io.netty.util.concurrent.RejectedExecutionHandlers;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;
import k.b;

/* JADX INFO: loaded from: classes2.dex */
public final class EpollEventLoopGroup extends MultithreadEventLoopGroup {
    public EpollEventLoopGroup() {
        this(0);
    }

    @Deprecated
    public void setIoRatio(int i10) {
        if (i10 <= 0 || i10 > 100) {
            throw new IllegalArgumentException(b.a("ioRatio: ", i10, " (expected: 0 < ioRatio <= 100)"));
        }
    }

    public EpollEventLoopGroup(int i10) {
        this(i10, (ThreadFactory) null);
    }

    @Override // io.netty.channel.MultithreadEventLoopGroup, io.netty.util.concurrent.MultithreadEventExecutorGroup
    public EventLoop newChild(Executor executor, Object... objArr) throws Exception {
        Integer num = (Integer) objArr[0];
        SelectStrategyFactory selectStrategyFactory = (SelectStrategyFactory) objArr[1];
        RejectedExecutionHandler rejectedExecutionHandler = (RejectedExecutionHandler) objArr[2];
        int length = objArr.length;
        return new EpollEventLoop(this, executor, num.intValue(), selectStrategyFactory.newSelectStrategy(), rejectedExecutionHandler, length > 3 ? (EventLoopTaskQueueFactory) objArr[3] : null, length > 4 ? (EventLoopTaskQueueFactory) objArr[4] : null);
    }

    public EpollEventLoopGroup(ThreadFactory threadFactory) {
        this(0, threadFactory, 0);
    }

    public EpollEventLoopGroup(int i10, SelectStrategyFactory selectStrategyFactory) {
        this(i10, (ThreadFactory) null, selectStrategyFactory);
    }

    public EpollEventLoopGroup(int i10, ThreadFactory threadFactory) {
        this(i10, threadFactory, 0);
    }

    public EpollEventLoopGroup(int i10, Executor executor) {
        this(i10, executor, DefaultSelectStrategyFactory.INSTANCE);
    }

    public EpollEventLoopGroup(int i10, ThreadFactory threadFactory, SelectStrategyFactory selectStrategyFactory) {
        this(i10, threadFactory, 0, selectStrategyFactory);
    }

    @Deprecated
    public EpollEventLoopGroup(int i10, ThreadFactory threadFactory, int i11) {
        this(i10, threadFactory, i11, DefaultSelectStrategyFactory.INSTANCE);
    }

    @Deprecated
    public EpollEventLoopGroup(int i10, ThreadFactory threadFactory, int i11, SelectStrategyFactory selectStrategyFactory) {
        super(i10, threadFactory, Integer.valueOf(i11), selectStrategyFactory, RejectedExecutionHandlers.reject());
        Epoll.ensureAvailability();
    }

    public EpollEventLoopGroup(int i10, Executor executor, SelectStrategyFactory selectStrategyFactory) {
        super(i10, executor, 0, selectStrategyFactory, RejectedExecutionHandlers.reject());
        Epoll.ensureAvailability();
    }

    public EpollEventLoopGroup(int i10, Executor executor, EventExecutorChooserFactory eventExecutorChooserFactory, SelectStrategyFactory selectStrategyFactory) {
        super(i10, executor, eventExecutorChooserFactory, 0, selectStrategyFactory, RejectedExecutionHandlers.reject());
        Epoll.ensureAvailability();
    }

    public EpollEventLoopGroup(int i10, Executor executor, EventExecutorChooserFactory eventExecutorChooserFactory, SelectStrategyFactory selectStrategyFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i10, executor, eventExecutorChooserFactory, 0, selectStrategyFactory, rejectedExecutionHandler);
        Epoll.ensureAvailability();
    }

    public EpollEventLoopGroup(int i10, Executor executor, EventExecutorChooserFactory eventExecutorChooserFactory, SelectStrategyFactory selectStrategyFactory, RejectedExecutionHandler rejectedExecutionHandler, EventLoopTaskQueueFactory eventLoopTaskQueueFactory) {
        super(i10, executor, eventExecutorChooserFactory, 0, selectStrategyFactory, rejectedExecutionHandler, eventLoopTaskQueueFactory);
        Epoll.ensureAvailability();
    }

    public EpollEventLoopGroup(int i10, Executor executor, EventExecutorChooserFactory eventExecutorChooserFactory, SelectStrategyFactory selectStrategyFactory, RejectedExecutionHandler rejectedExecutionHandler, EventLoopTaskQueueFactory eventLoopTaskQueueFactory, EventLoopTaskQueueFactory eventLoopTaskQueueFactory2) {
        super(i10, executor, eventExecutorChooserFactory, 0, selectStrategyFactory, rejectedExecutionHandler, eventLoopTaskQueueFactory, eventLoopTaskQueueFactory2);
        Epoll.ensureAvailability();
    }
}
