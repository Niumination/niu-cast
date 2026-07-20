package io.netty.util.concurrent;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class ImmediateEventExecutor extends AbstractEventExecutor {
    private final Future<?> terminationFuture = new FailedFuture(GlobalEventExecutor.INSTANCE, new UnsupportedOperationException());
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) ImmediateEventExecutor.class);
    public static final ImmediateEventExecutor INSTANCE = new ImmediateEventExecutor();
    private static final FastThreadLocal<Queue<Runnable>> DELAYED_RUNNABLES = new FastThreadLocal<Queue<Runnable>>() { // from class: io.netty.util.concurrent.ImmediateEventExecutor.1
        @Override // io.netty.util.concurrent.FastThreadLocal
        public Queue<Runnable> initialValue() throws Exception {
            return new ArrayDeque();
        }
    };
    private static final FastThreadLocal<Boolean> RUNNING = new FastThreadLocal<Boolean>() { // from class: io.netty.util.concurrent.ImmediateEventExecutor.2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.netty.util.concurrent.FastThreadLocal
        public Boolean initialValue() throws Exception {
            return Boolean.FALSE;
        }
    };

    public static class ImmediateProgressivePromise<V> extends DefaultProgressivePromise<V> {
        public ImmediateProgressivePromise(EventExecutor eventExecutor) {
            super(eventExecutor);
        }

        @Override // io.netty.util.concurrent.DefaultPromise
        public void checkDeadLock() {
        }
    }

    public static class ImmediatePromise<V> extends DefaultPromise<V> {
        public ImmediatePromise(EventExecutor eventExecutor) {
            super(eventExecutor);
        }

        @Override // io.netty.util.concurrent.DefaultPromise
        public void checkDeadLock() {
        }
    }

    private ImmediateEventExecutor() {
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j10, TimeUnit timeUnit) {
        return false;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) throws Throwable {
        ObjectUtil.checkNotNull(runnable, "command");
        FastThreadLocal<Boolean> fastThreadLocal = RUNNING;
        if (fastThreadLocal.get().booleanValue()) {
            DELAYED_RUNNABLES.get().add(runnable);
            return;
        }
        fastThreadLocal.set(Boolean.TRUE);
        try {
            runnable.run();
            Queue<Runnable> queue = DELAYED_RUNNABLES.get();
            while (true) {
                Runnable runnablePoll = queue.poll();
                if (runnablePoll == null) {
                    break;
                }
                try {
                    runnablePoll.run();
                } catch (Throwable th2) {
                    logger.info("Throwable caught while executing Runnable {}", runnablePoll, th2);
                }
            }
        } catch (Throwable th3) {
            try {
                logger.info("Throwable caught while executing Runnable {}", runnable, th3);
                while (true) {
                }
            } finally {
                Queue<Runnable> queue2 = DELAYED_RUNNABLES.get();
                while (true) {
                    Runnable runnablePoll2 = queue2.poll();
                    if (runnablePoll2 == null) {
                        RUNNING.set(Boolean.FALSE);
                    }
                    try {
                        runnablePoll2.run();
                    } catch (Throwable th4) {
                        logger.info("Throwable caught while executing Runnable {}", runnablePoll2, th4);
                    }
                }
            }
        }
    }

    @Override // io.netty.util.concurrent.AbstractEventExecutor, io.netty.util.concurrent.EventExecutor
    public boolean inEventLoop() {
        return true;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return false;
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public boolean isShuttingDown() {
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return false;
    }

    @Override // io.netty.util.concurrent.AbstractEventExecutor, io.netty.util.concurrent.EventExecutor
    public <V> ProgressivePromise<V> newProgressivePromise() {
        return new ImmediateProgressivePromise(this);
    }

    @Override // io.netty.util.concurrent.AbstractEventExecutor, io.netty.util.concurrent.EventExecutor
    public <V> Promise<V> newPromise() {
        return new ImmediatePromise(this);
    }

    @Override // io.netty.util.concurrent.AbstractEventExecutor, java.util.concurrent.ExecutorService, io.netty.util.concurrent.EventExecutorGroup
    @Deprecated
    public void shutdown() {
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public Future<?> shutdownGracefully(long j10, long j11, TimeUnit timeUnit) {
        return terminationFuture();
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public Future<?> terminationFuture() {
        return this.terminationFuture;
    }

    @Override // io.netty.util.concurrent.EventExecutor
    public boolean inEventLoop(Thread thread) {
        return true;
    }
}
