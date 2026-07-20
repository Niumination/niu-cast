package io.netty.channel.pool;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.GlobalEventExecutor;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.ObjectUtil;
import j1.g;
import java.nio.channels.ClosedChannelException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import k4.f;

/* JADX INFO: loaded from: classes2.dex */
public class FixedChannelPool extends SimpleChannelPool {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final long acquireTimeoutNanos;
    private final AtomicInteger acquiredChannelCount;
    private boolean closed;
    private final EventExecutor executor;
    private final int maxConnections;
    private final int maxPendingAcquires;
    private int pendingAcquireCount;
    private final Queue<AcquireTask> pendingAcquireQueue;
    private final Runnable timeoutTask;

    /* JADX INFO: renamed from: io.netty.channel.pool.FixedChannelPool$7, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass7 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$channel$pool$FixedChannelPool$AcquireTimeoutAction;

        static {
            int[] iArr = new int[AcquireTimeoutAction.values().length];
            $SwitchMap$io$netty$channel$pool$FixedChannelPool$AcquireTimeoutAction = iArr;
            try {
                iArr[AcquireTimeoutAction.FAIL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$channel$pool$FixedChannelPool$AcquireTimeoutAction[AcquireTimeoutAction.NEW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public class AcquireListener implements FutureListener<Channel> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        protected boolean acquired;
        private final Promise<Channel> originalPromise;

        public AcquireListener(Promise<Channel> promise) {
            this.originalPromise = promise;
        }

        public void acquired() {
            if (this.acquired) {
                return;
            }
            FixedChannelPool.this.acquiredChannelCount.incrementAndGet();
            this.acquired = true;
        }

        @Override // io.netty.util.concurrent.GenericFutureListener
        public void operationComplete(Future<Channel> future) throws Exception {
            try {
                if (FixedChannelPool.this.closed) {
                    if (future.isSuccess()) {
                        future.getNow().close();
                    }
                    this.originalPromise.setFailure(new IllegalStateException("FixedChannelPool was closed"));
                } else {
                    if (future.isSuccess()) {
                        this.originalPromise.setSuccess(future.getNow());
                        return;
                    }
                    if (this.acquired) {
                        FixedChannelPool.this.decrementAndRunTaskQueue();
                    } else {
                        FixedChannelPool.this.runTaskQueue();
                    }
                    this.originalPromise.setFailure(future.cause());
                }
            } catch (Throwable th2) {
                this.originalPromise.tryFailure(th2);
            }
        }
    }

    public final class AcquireTask extends AcquireListener {
        final long expireNanoTime;
        final Promise<Channel> promise;
        ScheduledFuture<?> timeoutFuture;

        public AcquireTask(Promise<Channel> promise) {
            super(promise);
            this.expireNanoTime = FixedChannelPool.this.acquireTimeoutNanos + System.nanoTime();
            this.promise = FixedChannelPool.this.executor.newPromise().addListener((GenericFutureListener) this);
        }
    }

    public enum AcquireTimeoutAction {
        NEW,
        FAIL
    }

    public static final class AcquireTimeoutException extends TimeoutException {
        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            return this;
        }

        private AcquireTimeoutException() {
            super("Acquire operation took longer then configured maximum time");
        }
    }

    public abstract class TimeoutTask implements Runnable {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        private TimeoutTask() {
        }

        public abstract void onTimeout(AcquireTask acquireTask);

        @Override // java.lang.Runnable
        public final void run() {
            long jNanoTime = System.nanoTime();
            while (true) {
                AcquireTask acquireTask = (AcquireTask) FixedChannelPool.this.pendingAcquireQueue.peek();
                if (acquireTask == null || jNanoTime - acquireTask.expireNanoTime < 0) {
                    return;
                }
                FixedChannelPool.this.pendingAcquireQueue.remove();
                FixedChannelPool.access$906(FixedChannelPool.this);
                onTimeout(acquireTask);
            }
        }
    }

    public FixedChannelPool(Bootstrap bootstrap, ChannelPoolHandler channelPoolHandler, int i10) {
        this(bootstrap, channelPoolHandler, i10, Integer.MAX_VALUE);
    }

    public static /* synthetic */ int access$906(FixedChannelPool fixedChannelPool) {
        int i10 = fixedChannelPool.pendingAcquireCount - 1;
        fixedChannelPool.pendingAcquireCount = i10;
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acquire0(Promise<Channel> promise) {
        try {
            if (this.closed) {
                promise.setFailure(new IllegalStateException("FixedChannelPool was closed"));
                return;
            }
            if (this.acquiredChannelCount.get() < this.maxConnections) {
                Promise<Channel> promiseNewPromise = this.executor.newPromise();
                AcquireListener acquireListener = new AcquireListener(promise);
                acquireListener.acquired();
                promiseNewPromise.addListener((GenericFutureListener<? extends Future<? super Channel>>) acquireListener);
                super.acquire(promiseNewPromise);
                return;
            }
            if (this.pendingAcquireCount >= this.maxPendingAcquires) {
                tooManyOutstanding(promise);
                return;
            }
            AcquireTask acquireTask = new AcquireTask(promise);
            if (!this.pendingAcquireQueue.offer(acquireTask)) {
                tooManyOutstanding(promise);
                return;
            }
            this.pendingAcquireCount++;
            Runnable runnable = this.timeoutTask;
            if (runnable != null) {
                acquireTask.timeoutFuture = this.executor.schedule(runnable, this.acquireTimeoutNanos, TimeUnit.NANOSECONDS);
            }
        } catch (Throwable th2) {
            promise.tryFailure(th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Future<Void> close0() {
        if (this.closed) {
            return GlobalEventExecutor.INSTANCE.newSucceededFuture(null);
        }
        this.closed = true;
        while (true) {
            AcquireTask acquireTaskPoll = this.pendingAcquireQueue.poll();
            if (acquireTaskPoll == null) {
                this.acquiredChannelCount.set(0);
                this.pendingAcquireCount = 0;
                return GlobalEventExecutor.INSTANCE.submit((Callable) new Callable<Void>() { // from class: io.netty.channel.pool.FixedChannelPool.6
                    @Override // java.util.concurrent.Callable
                    public Void call() throws Exception {
                        FixedChannelPool.super.close();
                        return null;
                    }
                });
            }
            ScheduledFuture<?> scheduledFuture = acquireTaskPoll.timeoutFuture;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            acquireTaskPoll.promise.setFailure(new ClosedChannelException());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void decrementAndRunTaskQueue() {
        this.acquiredChannelCount.decrementAndGet();
        runTaskQueue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runTaskQueue() {
        AcquireTask acquireTaskPoll;
        while (this.acquiredChannelCount.get() < this.maxConnections && (acquireTaskPoll = this.pendingAcquireQueue.poll()) != null) {
            ScheduledFuture<?> scheduledFuture = acquireTaskPoll.timeoutFuture;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            this.pendingAcquireCount--;
            acquireTaskPoll.acquired();
            super.acquire(acquireTaskPoll.promise);
        }
    }

    private void tooManyOutstanding(Promise<?> promise) {
        promise.setFailure(new IllegalStateException("Too many outstanding acquire operations"));
    }

    @Override // io.netty.channel.pool.SimpleChannelPool, io.netty.channel.pool.ChannelPool
    public Future<Channel> acquire(final Promise<Channel> promise) {
        try {
            if (this.executor.inEventLoop()) {
                acquire0(promise);
            } else {
                this.executor.execute(new Runnable() { // from class: io.netty.channel.pool.FixedChannelPool.3
                    @Override // java.lang.Runnable
                    public void run() {
                        FixedChannelPool.this.acquire0(promise);
                    }
                });
            }
        } catch (Throwable th2) {
            promise.tryFailure(th2);
        }
        return promise;
    }

    public int acquiredChannelCount() {
        return this.acquiredChannelCount.get();
    }

    @Override // io.netty.channel.pool.SimpleChannelPool, io.netty.channel.pool.ChannelPool, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            closeAsync().await();
        } catch (InterruptedException e10) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e10);
        }
    }

    @Override // io.netty.channel.pool.SimpleChannelPool
    public Future<Void> closeAsync() {
        if (this.executor.inEventLoop()) {
            return close0();
        }
        final Promise promiseNewPromise = this.executor.newPromise();
        this.executor.execute(new Runnable() { // from class: io.netty.channel.pool.FixedChannelPool.5
            @Override // java.lang.Runnable
            public void run() {
                FixedChannelPool.this.close0().addListener(new FutureListener<Void>() { // from class: io.netty.channel.pool.FixedChannelPool.5.1
                    @Override // io.netty.util.concurrent.GenericFutureListener
                    public void operationComplete(Future<Void> future) throws Exception {
                        if (future.isSuccess()) {
                            promiseNewPromise.setSuccess(null);
                        } else {
                            promiseNewPromise.setFailure(future.cause());
                        }
                    }
                });
            }
        });
        return promiseNewPromise;
    }

    @Override // io.netty.channel.pool.SimpleChannelPool, io.netty.channel.pool.ChannelPool
    public Future<Void> release(final Channel channel, final Promise<Void> promise) {
        ObjectUtil.checkNotNull(promise, "promise");
        super.release(channel, this.executor.newPromise().addListener((GenericFutureListener) new FutureListener<Void>() { // from class: io.netty.channel.pool.FixedChannelPool.4
            static final /* synthetic */ boolean $assertionsDisabled = false;

            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future<Void> future) {
                try {
                    if (FixedChannelPool.this.closed) {
                        channel.close();
                        promise.setFailure(new IllegalStateException("FixedChannelPool was closed"));
                    } else if (future.isSuccess()) {
                        FixedChannelPool.this.decrementAndRunTaskQueue();
                        promise.setSuccess(null);
                    } else {
                        if (!(future.cause() instanceof IllegalArgumentException)) {
                            FixedChannelPool.this.decrementAndRunTaskQueue();
                        }
                        promise.setFailure(future.cause());
                    }
                } catch (Throwable th2) {
                    promise.tryFailure(th2);
                }
            }
        }));
        return promise;
    }

    public FixedChannelPool(Bootstrap bootstrap, ChannelPoolHandler channelPoolHandler, int i10, int i11) {
        this(bootstrap, channelPoolHandler, ChannelHealthChecker.ACTIVE, null, -1L, i10, i11);
    }

    public FixedChannelPool(Bootstrap bootstrap, ChannelPoolHandler channelPoolHandler, ChannelHealthChecker channelHealthChecker, AcquireTimeoutAction acquireTimeoutAction, long j10, int i10, int i11) {
        this(bootstrap, channelPoolHandler, channelHealthChecker, acquireTimeoutAction, j10, i10, i11, true);
    }

    public FixedChannelPool(Bootstrap bootstrap, ChannelPoolHandler channelPoolHandler, ChannelHealthChecker channelHealthChecker, AcquireTimeoutAction acquireTimeoutAction, long j10, int i10, int i11, boolean z10) {
        this(bootstrap, channelPoolHandler, channelHealthChecker, acquireTimeoutAction, j10, i10, i11, z10, true);
    }

    public FixedChannelPool(Bootstrap bootstrap, ChannelPoolHandler channelPoolHandler, ChannelHealthChecker channelHealthChecker, AcquireTimeoutAction acquireTimeoutAction, long j10, int i10, int i11, boolean z10, boolean z11) {
        super(bootstrap, channelPoolHandler, channelHealthChecker, z10, z11);
        this.pendingAcquireQueue = new ArrayDeque();
        this.acquiredChannelCount = new AtomicInteger();
        ObjectUtil.checkPositive(i10, "maxConnections");
        ObjectUtil.checkPositive(i11, "maxPendingAcquires");
        if (acquireTimeoutAction == null && j10 == -1) {
            this.timeoutTask = null;
            this.acquireTimeoutNanos = -1L;
        } else {
            if (acquireTimeoutAction == null && j10 != -1) {
                throw new NullPointerException(f.f8937e);
            }
            if (acquireTimeoutAction != null && j10 < 0) {
                throw new IllegalArgumentException(g.a("acquireTimeoutMillis: ", j10, " (expected: >= 0)"));
            }
            this.acquireTimeoutNanos = TimeUnit.MILLISECONDS.toNanos(j10);
            int i12 = AnonymousClass7.$SwitchMap$io$netty$channel$pool$FixedChannelPool$AcquireTimeoutAction[acquireTimeoutAction.ordinal()];
            if (i12 == 1) {
                this.timeoutTask = new TimeoutTask() { // from class: io.netty.channel.pool.FixedChannelPool.1
                    @Override // io.netty.channel.pool.FixedChannelPool.TimeoutTask
                    public void onTimeout(AcquireTask acquireTask) {
                        acquireTask.promise.setFailure(new AcquireTimeoutException());
                    }
                };
            } else if (i12 == 2) {
                this.timeoutTask = new TimeoutTask() { // from class: io.netty.channel.pool.FixedChannelPool.2
                    @Override // io.netty.channel.pool.FixedChannelPool.TimeoutTask
                    public void onTimeout(AcquireTask acquireTask) {
                        acquireTask.acquired();
                        FixedChannelPool.super.acquire(acquireTask.promise);
                    }
                };
            } else {
                throw new Error();
            }
        }
        this.executor = bootstrap.config().group().next();
        this.maxConnections = i10;
        this.maxPendingAcquires = i11;
    }
}
