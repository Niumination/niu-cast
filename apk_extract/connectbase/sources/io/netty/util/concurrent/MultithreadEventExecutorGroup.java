package io.netty.util.concurrent;

import io.netty.util.internal.ObjectUtil;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public abstract class MultithreadEventExecutorGroup extends AbstractEventExecutorGroup {
    private final EventExecutor[] children;
    private final EventExecutorChooserFactory.EventExecutorChooser chooser;
    private final Set<EventExecutor> readonlyChildren;
    private final AtomicInteger terminatedChildren;
    private final Promise<?> terminationFuture;

    public MultithreadEventExecutorGroup(int i10, ThreadFactory threadFactory, Object... objArr) {
        this(i10, threadFactory == null ? null : new ThreadPerTaskExecutor(threadFactory), objArr);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j10, TimeUnit timeUnit) throws InterruptedException {
        long jNanoTime;
        long nanos = timeUnit.toNanos(j10) + System.nanoTime();
        loop0: for (EventExecutor eventExecutor : this.children) {
            do {
                jNanoTime = nanos - System.nanoTime();
                if (jNanoTime <= 0) {
                    break loop0;
                }
            } while (!eventExecutor.awaitTermination(jNanoTime, TimeUnit.NANOSECONDS));
        }
        return isTerminated();
    }

    public final int executorCount() {
        return this.children.length;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        for (EventExecutor eventExecutor : this.children) {
            if (!eventExecutor.isShutdown()) {
                return false;
            }
        }
        return true;
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public boolean isShuttingDown() {
        for (EventExecutor eventExecutor : this.children) {
            if (!eventExecutor.isShuttingDown()) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        for (EventExecutor eventExecutor : this.children) {
            if (!eventExecutor.isTerminated()) {
                return false;
            }
        }
        return true;
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup, java.lang.Iterable
    public Iterator<EventExecutor> iterator() {
        return this.readonlyChildren.iterator();
    }

    public abstract EventExecutor newChild(Executor executor, Object... objArr) throws Exception;

    public ThreadFactory newDefaultThreadFactory() {
        return new DefaultThreadFactory(getClass());
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public EventExecutor next() {
        return this.chooser.next();
    }

    @Override // io.netty.util.concurrent.AbstractEventExecutorGroup, io.netty.util.concurrent.EventExecutorGroup, java.util.concurrent.ExecutorService
    @Deprecated
    public void shutdown() {
        for (EventExecutor eventExecutor : this.children) {
            eventExecutor.shutdown();
        }
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public Future<?> shutdownGracefully(long j10, long j11, TimeUnit timeUnit) {
        for (EventExecutor eventExecutor : this.children) {
            eventExecutor.shutdownGracefully(j10, j11, timeUnit);
        }
        return terminationFuture();
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public Future<?> terminationFuture() {
        return this.terminationFuture;
    }

    public MultithreadEventExecutorGroup(int i10, Executor executor, Object... objArr) {
        this(i10, executor, DefaultEventExecutorChooserFactory.INSTANCE, objArr);
    }

    public MultithreadEventExecutorGroup(int i10, Executor executor, EventExecutorChooserFactory eventExecutorChooserFactory, Object... objArr) {
        this.terminatedChildren = new AtomicInteger();
        this.terminationFuture = new DefaultPromise(GlobalEventExecutor.INSTANCE);
        ObjectUtil.checkPositive(i10, "nThreads");
        executor = executor == null ? new ThreadPerTaskExecutor(newDefaultThreadFactory()) : executor;
        this.children = new EventExecutor[i10];
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            try {
                try {
                    this.children[i12] = newChild(executor, objArr);
                } catch (Exception e10) {
                    throw new IllegalStateException("failed to create a child event loop", e10);
                }
            } catch (Throwable th2) {
                for (int i13 = 0; i13 < i12; i13++) {
                    this.children[i13].shutdownGracefully();
                }
                while (i11 < i12) {
                    EventExecutor eventExecutor = this.children[i11];
                    while (!eventExecutor.isTerminated()) {
                        try {
                            eventExecutor.awaitTermination(2147483647L, TimeUnit.SECONDS);
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                            throw th2;
                        }
                    }
                    i11++;
                }
                throw th2;
            }
        }
        this.chooser = eventExecutorChooserFactory.newChooser(this.children);
        FutureListener<Object> futureListener = new FutureListener<Object>() { // from class: io.netty.util.concurrent.MultithreadEventExecutorGroup.1
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future<Object> future) throws Exception {
                if (MultithreadEventExecutorGroup.this.terminatedChildren.incrementAndGet() == MultithreadEventExecutorGroup.this.children.length) {
                    MultithreadEventExecutorGroup.this.terminationFuture.setSuccess(null);
                }
            }
        };
        EventExecutor[] eventExecutorArr = this.children;
        int length = eventExecutorArr.length;
        while (i11 < length) {
            eventExecutorArr[i11].terminationFuture().addListener(futureListener);
            i11++;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(this.children.length);
        Collections.addAll(linkedHashSet, this.children);
        this.readonlyChildren = Collections.unmodifiableSet(linkedHashSet);
    }
}
