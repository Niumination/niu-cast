package io.netty.channel;

import io.netty.util.concurrent.AbstractEventExecutorGroup;
import io.netty.util.concurrent.DefaultPromise;
import io.netty.util.concurrent.DefaultThreadFactory;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import io.netty.util.concurrent.GlobalEventExecutor;
import io.netty.util.concurrent.Promise;
import io.netty.util.concurrent.ThreadPerTaskExecutor;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.ReadOnlyIterator;
import java.util.Collections;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class ThreadPerChannelEventLoopGroup extends AbstractEventExecutorGroup implements EventLoopGroup {
    final Set<EventLoop> activeChildren;
    private final Object[] childArgs;
    private final FutureListener<Object> childTerminationListener;
    final Executor executor;
    final Queue<EventLoop> idleChildren;
    private final int maxChannels;
    private volatile boolean shuttingDown;
    private final Promise<?> terminationFuture;
    private final ChannelException tooManyChannels;

    public ThreadPerChannelEventLoopGroup() {
        this(0);
    }

    private EventLoop nextChild() throws Exception {
        if (this.shuttingDown) {
            throw new RejectedExecutionException("shutting down");
        }
        EventLoop eventLoopPoll = this.idleChildren.poll();
        if (eventLoopPoll == null) {
            if (this.maxChannels > 0 && this.activeChildren.size() >= this.maxChannels) {
                throw this.tooManyChannels;
            }
            eventLoopPoll = newChild(this.childArgs);
            eventLoopPoll.terminationFuture().addListener(this.childTerminationListener);
        }
        this.activeChildren.add(eventLoopPoll);
        return eventLoopPoll;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j10, TimeUnit timeUnit) throws InterruptedException {
        long jNanoTime;
        long jNanoTime2;
        long nanos = timeUnit.toNanos(j10) + System.nanoTime();
        for (EventLoop eventLoop : this.activeChildren) {
            do {
                jNanoTime2 = nanos - System.nanoTime();
                if (jNanoTime2 <= 0) {
                    return isTerminated();
                }
            } while (!eventLoop.awaitTermination(jNanoTime2, TimeUnit.NANOSECONDS));
        }
        for (EventLoop eventLoop2 : this.idleChildren) {
            do {
                jNanoTime = nanos - System.nanoTime();
                if (jNanoTime <= 0) {
                    return isTerminated();
                }
            } while (!eventLoop2.awaitTermination(jNanoTime, TimeUnit.NANOSECONDS));
        }
        return isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        Iterator<EventLoop> it = this.activeChildren.iterator();
        while (it.hasNext()) {
            if (!it.next().isShutdown()) {
                return false;
            }
        }
        Iterator<EventLoop> it2 = this.idleChildren.iterator();
        while (it2.hasNext()) {
            if (!it2.next().isShutdown()) {
                return false;
            }
        }
        return true;
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public boolean isShuttingDown() {
        Iterator<EventLoop> it = this.activeChildren.iterator();
        while (it.hasNext()) {
            if (!it.next().isShuttingDown()) {
                return false;
            }
        }
        Iterator<EventLoop> it2 = this.idleChildren.iterator();
        while (it2.hasNext()) {
            if (!it2.next().isShuttingDown()) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        Iterator<EventLoop> it = this.activeChildren.iterator();
        while (it.hasNext()) {
            if (!it.next().isTerminated()) {
                return false;
            }
        }
        Iterator<EventLoop> it2 = this.idleChildren.iterator();
        while (it2.hasNext()) {
            if (!it2.next().isTerminated()) {
                return false;
            }
        }
        return true;
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup, java.lang.Iterable
    public Iterator<EventExecutor> iterator() {
        return new ReadOnlyIterator(this.activeChildren.iterator());
    }

    public EventLoop newChild(Object... objArr) throws Exception {
        return new ThreadPerChannelEventLoop(this);
    }

    @Override // io.netty.channel.EventLoopGroup
    public ChannelFuture register(Channel channel) {
        ObjectUtil.checkNotNull(channel, "channel");
        try {
            EventLoop eventLoopNextChild = nextChild();
            return eventLoopNextChild.register(new DefaultChannelPromise(channel, eventLoopNextChild));
        } catch (Throwable th2) {
            return new FailedChannelFuture(channel, GlobalEventExecutor.INSTANCE, th2);
        }
    }

    @Override // io.netty.util.concurrent.AbstractEventExecutorGroup, io.netty.util.concurrent.EventExecutorGroup, java.util.concurrent.ExecutorService
    @Deprecated
    public void shutdown() {
        this.shuttingDown = true;
        Iterator<EventLoop> it = this.activeChildren.iterator();
        while (it.hasNext()) {
            it.next().shutdown();
        }
        Iterator<EventLoop> it2 = this.idleChildren.iterator();
        while (it2.hasNext()) {
            it2.next().shutdown();
        }
        if (isTerminated()) {
            this.terminationFuture.trySuccess(null);
        }
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public Future<?> shutdownGracefully(long j10, long j11, TimeUnit timeUnit) {
        this.shuttingDown = true;
        Iterator<EventLoop> it = this.activeChildren.iterator();
        while (it.hasNext()) {
            it.next().shutdownGracefully(j10, j11, timeUnit);
        }
        Iterator<EventLoop> it2 = this.idleChildren.iterator();
        while (it2.hasNext()) {
            it2.next().shutdownGracefully(j10, j11, timeUnit);
        }
        if (isTerminated()) {
            this.terminationFuture.trySuccess(null);
        }
        return terminationFuture();
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public Future<?> terminationFuture() {
        return this.terminationFuture;
    }

    public ThreadPerChannelEventLoopGroup(int i10) {
        this(i10, (ThreadFactory) null, new Object[0]);
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public EventLoop next() {
        throw new UnsupportedOperationException();
    }

    public ThreadPerChannelEventLoopGroup(int i10, ThreadFactory threadFactory, Object... objArr) {
        this(i10, threadFactory == null ? null : new ThreadPerTaskExecutor(threadFactory), objArr);
    }

    public ThreadPerChannelEventLoopGroup(int i10, Executor executor, Object... objArr) {
        this.activeChildren = Collections.newSetFromMap(PlatformDependent.newConcurrentHashMap());
        this.idleChildren = new ConcurrentLinkedQueue();
        this.terminationFuture = new DefaultPromise(GlobalEventExecutor.INSTANCE);
        this.childTerminationListener = new FutureListener<Object>() { // from class: io.netty.channel.ThreadPerChannelEventLoopGroup.1
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future<Object> future) throws Exception {
                if (ThreadPerChannelEventLoopGroup.this.isTerminated()) {
                    ThreadPerChannelEventLoopGroup.this.terminationFuture.trySuccess(null);
                }
            }
        };
        ObjectUtil.checkPositiveOrZero(i10, "maxChannels");
        executor = executor == null ? new ThreadPerTaskExecutor(new DefaultThreadFactory(getClass())) : executor;
        if (objArr == null) {
            this.childArgs = EmptyArrays.EMPTY_OBJECTS;
        } else {
            this.childArgs = (Object[]) objArr.clone();
        }
        this.maxChannels = i10;
        this.executor = executor;
        this.tooManyChannels = ChannelException.newStatic("too many channels (max: " + i10 + ')', ThreadPerChannelEventLoopGroup.class, "nextChild()");
    }

    @Override // io.netty.channel.EventLoopGroup
    public ChannelFuture register(ChannelPromise channelPromise) {
        try {
            return nextChild().register(channelPromise);
        } catch (Throwable th2) {
            channelPromise.setFailure(th2);
            return channelPromise;
        }
    }

    @Override // io.netty.channel.EventLoopGroup
    @Deprecated
    public ChannelFuture register(Channel channel, ChannelPromise channelPromise) {
        ObjectUtil.checkNotNull(channel, "channel");
        try {
            return nextChild().register(channel, channelPromise);
        } catch (Throwable th2) {
            channelPromise.setFailure(th2);
            return channelPromise;
        }
    }
}
