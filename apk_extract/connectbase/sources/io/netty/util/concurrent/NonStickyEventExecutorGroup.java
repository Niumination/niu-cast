package io.netty.util.concurrent;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public final class NonStickyEventExecutorGroup implements EventExecutorGroup {
    private final EventExecutorGroup group;
    private final int maxTaskExecutePerRun;

    public static final class NonStickyOrderedEventExecutor extends AbstractEventExecutor implements Runnable, OrderedEventExecutor {
        private static final int NONE = 0;
        private static final int RUNNING = 2;
        private static final int SUBMITTED = 1;
        private final AtomicReference<Thread> executingThread;
        private final EventExecutor executor;
        private final int maxTaskExecutePerRun;
        private final AtomicInteger state;
        private final Queue<Runnable> tasks;

        public NonStickyOrderedEventExecutor(EventExecutor eventExecutor, int i10) {
            super(eventExecutor);
            this.tasks = PlatformDependent.newMpscQueue();
            this.state = new AtomicInteger();
            this.executingThread = new AtomicReference<>();
            this.executor = eventExecutor;
            this.maxTaskExecutePerRun = i10;
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean awaitTermination(long j10, TimeUnit timeUnit) throws InterruptedException {
            return this.executor.awaitTermination(j10, timeUnit);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            if (!this.tasks.offer(runnable)) {
                throw new RejectedExecutionException();
            }
            if (this.state.compareAndSet(0, 1)) {
                this.executor.execute(this);
            }
        }

        @Override // io.netty.util.concurrent.EventExecutor
        public boolean inEventLoop(Thread thread) {
            return this.executingThread.get() == thread;
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isShutdown() {
            return this.executor.isShutdown();
        }

        @Override // io.netty.util.concurrent.EventExecutorGroup
        public boolean isShuttingDown() {
            return this.executor.isShutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isTerminated() {
            return this.executor.isTerminated();
        }

        /* JADX WARN: Code restructure failed: missing block: B:36:0x0090, code lost:
        
            if (r8.state.compareAndSet(0, 2) != false) goto L38;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r8 = this;
                java.util.concurrent.atomic.AtomicInteger r0 = r8.state
                r1 = 1
                r2 = 2
                boolean r0 = r0.compareAndSet(r1, r2)
                if (r0 != 0) goto Lb
                return
            Lb:
                java.lang.Thread r0 = java.lang.Thread.currentThread()
                java.util.concurrent.atomic.AtomicReference<java.lang.Thread> r3 = r8.executingThread
                r3.set(r0)
            L14:
                r3 = 0
                r4 = r3
            L16:
                r5 = 0
                int r6 = r8.maxTaskExecutePerRun     // Catch: java.lang.Throwable -> L2c
                if (r4 >= r6) goto L2e
                java.util.Queue<java.lang.Runnable> r6 = r8.tasks     // Catch: java.lang.Throwable -> L2c
                java.lang.Object r6 = r6.poll()     // Catch: java.lang.Throwable -> L2c
                java.lang.Runnable r6 = (java.lang.Runnable) r6     // Catch: java.lang.Throwable -> L2c
                if (r6 != 0) goto L26
                goto L2e
            L26:
                io.netty.util.concurrent.AbstractEventExecutor.safeExecute(r6)     // Catch: java.lang.Throwable -> L2c
                int r4 = r4 + 1
                goto L16
            L2c:
                r6 = move-exception
                goto L63
            L2e:
                int r6 = r8.maxTaskExecutePerRun
                if (r4 != r6) goto L48
                java.util.concurrent.atomic.AtomicInteger r3 = r8.state     // Catch: java.lang.Throwable -> L42
                r3.set(r1)     // Catch: java.lang.Throwable -> L42
                java.util.concurrent.atomic.AtomicReference<java.lang.Thread> r3 = r8.executingThread     // Catch: java.lang.Throwable -> L42
                g0.e.a(r3, r0, r5)     // Catch: java.lang.Throwable -> L42
                io.netty.util.concurrent.EventExecutor r3 = r8.executor     // Catch: java.lang.Throwable -> L42
                r3.execute(r8)     // Catch: java.lang.Throwable -> L42
                return
            L42:
                java.util.concurrent.atomic.AtomicInteger r3 = r8.state
                r3.set(r2)
                goto L14
            L48:
                java.util.concurrent.atomic.AtomicInteger r4 = r8.state
                r4.set(r3)
                java.util.Queue<java.lang.Runnable> r4 = r8.tasks
                boolean r4 = r4.isEmpty()
                if (r4 != 0) goto L5d
                java.util.concurrent.atomic.AtomicInteger r4 = r8.state
                boolean r3 = r4.compareAndSet(r3, r2)
                if (r3 != 0) goto L14
            L5d:
                java.util.concurrent.atomic.AtomicReference<java.lang.Thread> r8 = r8.executingThread
                g0.e.a(r8, r0, r5)
                return
            L63:
                int r7 = r8.maxTaskExecutePerRun
                if (r4 != r7) goto L7d
                java.util.concurrent.atomic.AtomicInteger r3 = r8.state     // Catch: java.lang.Throwable -> L77
                r3.set(r1)     // Catch: java.lang.Throwable -> L77
                java.util.concurrent.atomic.AtomicReference<java.lang.Thread> r1 = r8.executingThread     // Catch: java.lang.Throwable -> L77
                g0.e.a(r1, r0, r5)     // Catch: java.lang.Throwable -> L77
                io.netty.util.concurrent.EventExecutor r0 = r8.executor     // Catch: java.lang.Throwable -> L77
                r0.execute(r8)     // Catch: java.lang.Throwable -> L77
                return
            L77:
                java.util.concurrent.atomic.AtomicInteger r8 = r8.state
                r8.set(r2)
                goto L93
            L7d:
                java.util.concurrent.atomic.AtomicInteger r1 = r8.state
                r1.set(r3)
                java.util.Queue<java.lang.Runnable> r1 = r8.tasks
                boolean r1 = r1.isEmpty()
                if (r1 != 0) goto L5d
                java.util.concurrent.atomic.AtomicInteger r1 = r8.state
                boolean r1 = r1.compareAndSet(r3, r2)
                if (r1 != 0) goto L93
                goto L5d
            L93:
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.util.concurrent.NonStickyEventExecutorGroup.NonStickyOrderedEventExecutor.run():void");
        }

        @Override // io.netty.util.concurrent.AbstractEventExecutor, java.util.concurrent.ExecutorService, io.netty.util.concurrent.EventExecutorGroup
        public void shutdown() {
            this.executor.shutdown();
        }

        @Override // io.netty.util.concurrent.EventExecutorGroup
        public Future<?> shutdownGracefully(long j10, long j11, TimeUnit timeUnit) {
            return this.executor.shutdownGracefully(j10, j11, timeUnit);
        }

        @Override // io.netty.util.concurrent.EventExecutorGroup
        public Future<?> terminationFuture() {
            return this.executor.terminationFuture();
        }
    }

    public NonStickyEventExecutorGroup(EventExecutorGroup eventExecutorGroup) {
        this(eventExecutorGroup, 1024);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public NonStickyOrderedEventExecutor newExecutor(EventExecutor eventExecutor) {
        return new NonStickyOrderedEventExecutor(eventExecutor, this.maxTaskExecutePerRun);
    }

    private static EventExecutorGroup verify(EventExecutorGroup eventExecutorGroup) {
        for (EventExecutor eventExecutor : (EventExecutorGroup) ObjectUtil.checkNotNull(eventExecutorGroup, "group")) {
            if (eventExecutor instanceof OrderedEventExecutor) {
                throw new IllegalArgumentException("EventExecutorGroup " + eventExecutorGroup + " contains OrderedEventExecutors: " + eventExecutor);
            }
        }
        return eventExecutorGroup;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j10, TimeUnit timeUnit) throws InterruptedException {
        return this.group.awaitTermination(j10, timeUnit);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.group.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<java.util.concurrent.Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
        return this.group.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws ExecutionException, InterruptedException {
        return (T) this.group.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.group.isShutdown();
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public boolean isShuttingDown() {
        return this.group.isShuttingDown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.group.isTerminated();
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup, java.lang.Iterable
    public Iterator<EventExecutor> iterator() {
        final Iterator<EventExecutor> it = this.group.iterator();
        return new Iterator<EventExecutor>() { // from class: io.netty.util.concurrent.NonStickyEventExecutorGroup.1
            @Override // java.util.Iterator
            public boolean hasNext() {
                return it.hasNext();
            }

            @Override // java.util.Iterator
            public void remove() {
                it.remove();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.Iterator
            public EventExecutor next() {
                return NonStickyEventExecutorGroup.this.newExecutor((EventExecutor) it.next());
            }
        };
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public EventExecutor next() {
        return newExecutor(this.group.next());
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup, java.util.concurrent.ExecutorService
    public void shutdown() {
        this.group.shutdown();
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public Future<?> shutdownGracefully() {
        return this.group.shutdownGracefully();
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup, java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        return this.group.shutdownNow();
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public Future<?> terminationFuture() {
        return this.group.terminationFuture();
    }

    public NonStickyEventExecutorGroup(EventExecutorGroup eventExecutorGroup, int i10) {
        this.group = verify(eventExecutorGroup);
        this.maxTaskExecutePerRun = ObjectUtil.checkPositive(i10, "maxTaskExecutePerRun");
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<java.util.concurrent.Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j10, TimeUnit timeUnit) throws InterruptedException {
        return this.group.invokeAll(collection, j10, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j10, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return (T) this.group.invokeAny(collection, j10, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
        return this.group.scheduleAtFixedRate(runnable, j10, j11, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
        return this.group.scheduleWithFixedDelay(runnable, j10, j11, timeUnit);
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public Future<?> shutdownGracefully(long j10, long j11, TimeUnit timeUnit) {
        return this.group.shutdownGracefully(j10, j11, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> schedule(Runnable runnable, long j10, TimeUnit timeUnit) {
        return this.group.schedule(runnable, j10, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public <V> ScheduledFuture<V> schedule(Callable<V> callable, long j10, TimeUnit timeUnit) {
        return this.group.schedule((Callable) callable, j10, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        return this.group.submit(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Runnable runnable, T t10) {
        return this.group.submit(runnable, (Object) t10);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Callable<T> callable) {
        return this.group.submit((Callable) callable);
    }
}
