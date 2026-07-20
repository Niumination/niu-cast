package io.netty.util.concurrent;

import io.netty.util.internal.InternalThreadLocalMap;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.ThrowableUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import j.d;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import nq.v1;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultPromise<V> extends AbstractFuture<V> implements Promise<V> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final CauseHolder CANCELLATION_CAUSE_HOLDER;
    private static final StackTraceElement[] CANCELLATION_STACK;
    private final EventExecutor executor;
    private GenericFutureListener<? extends Future<?>> listener;
    private DefaultFutureListeners listeners;
    private boolean notifyingListeners;
    private volatile Object result;
    private short waiters;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) DefaultPromise.class);
    private static final InternalLogger rejectedExecutionLogger = InternalLoggerFactory.getInstance(DefaultPromise.class.getName().concat(".rejectedExecution"));
    private static final int MAX_LISTENER_STACK_DEPTH = Math.min(8, SystemPropertyUtil.getInt("io.netty.defaultPromise.maxListenerStackDepth", 8));
    private static final AtomicReferenceFieldUpdater<DefaultPromise, Object> RESULT_UPDATER = AtomicReferenceFieldUpdater.newUpdater(DefaultPromise.class, Object.class, "result");
    private static final Object SUCCESS = new Object();
    private static final Object UNCANCELLABLE = new Object();

    public static final class CauseHolder {
        final Throwable cause;

        public CauseHolder(Throwable th2) {
            this.cause = th2;
        }
    }

    public static final class LeanCancellationException extends CancellationException {
        private static final long serialVersionUID = 2794674970981187807L;

        private LeanCancellationException() {
        }

        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            setStackTrace(DefaultPromise.CANCELLATION_STACK);
            return this;
        }

        @Override // java.lang.Throwable
        public String toString() {
            return CancellationException.class.getName();
        }
    }

    public static final class StacklessCancellationException extends CancellationException {
        private static final long serialVersionUID = -2974906711413716191L;

        private StacklessCancellationException() {
        }

        public static StacklessCancellationException newInstance(Class<?> cls, String str) {
            return (StacklessCancellationException) ThrowableUtil.unknownStackTrace(new StacklessCancellationException(), cls, str);
        }

        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            return this;
        }
    }

    static {
        CauseHolder causeHolder = new CauseHolder(StacklessCancellationException.newInstance(DefaultPromise.class, "cancel(...)"));
        CANCELLATION_CAUSE_HOLDER = causeHolder;
        CANCELLATION_STACK = causeHolder.cause.getStackTrace();
    }

    public DefaultPromise(EventExecutor eventExecutor) {
        this.executor = (EventExecutor) ObjectUtil.checkNotNull(eventExecutor, "executor");
    }

    private void addListener0(GenericFutureListener<? extends Future<? super V>> genericFutureListener) {
        GenericFutureListener<? extends Future<?>> genericFutureListener2 = this.listener;
        if (genericFutureListener2 != null) {
            this.listeners = new DefaultFutureListeners(genericFutureListener2, genericFutureListener);
            this.listener = null;
            return;
        }
        DefaultFutureListeners defaultFutureListeners = this.listeners;
        if (defaultFutureListeners == null) {
            this.listener = genericFutureListener;
        } else {
            defaultFutureListeners.add(genericFutureListener);
        }
    }

    /* JADX WARN: Code duplicated, block: B:56:0x008b A[Catch: all -> 0x0067, TryCatch #2 {all -> 0x0067, blocks: (B:38:0x005f, B:41:0x0069, B:56:0x008b, B:57:0x0092, B:52:0x0080, B:53:0x0087), top: B:64:0x0030 }] */
    private boolean await0(long j10, boolean z10) throws InterruptedException {
        boolean z11 = true;
        if (isDone()) {
            return true;
        }
        if (j10 <= 0) {
            return isDone();
        }
        if (z10 && Thread.interrupted()) {
            throw new InterruptedException(toString());
        }
        checkDeadLock();
        long jNanoTime = System.nanoTime();
        synchronized (this) {
            boolean z12 = false;
            long jNanoTime2 = j10;
            while (!isDone() && jNanoTime2 > 0) {
                try {
                    try {
                        incWaiters();
                        try {
                            try {
                                wait(jNanoTime2 / v1.f11967e, (int) (jNanoTime2 % v1.f11967e));
                                decWaiters();
                            } catch (InterruptedException e10) {
                                if (z10) {
                                    throw e10;
                                }
                                try {
                                    decWaiters();
                                    z12 = true;
                                } catch (Throwable th2) {
                                    th = th2;
                                    if (z11) {
                                        Thread.currentThread().interrupt();
                                    }
                                    throw th;
                                }
                            }
                            if (isDone()) {
                                if (z12) {
                                    Thread.currentThread().interrupt();
                                }
                                return true;
                            }
                            jNanoTime2 = j10 - (System.nanoTime() - jNanoTime);
                        } catch (Throwable th3) {
                            decWaiters();
                            throw th3;
                        }
                    } catch (Throwable th4) {
                        throw th4;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    z11 = z12;
                    if (z11) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            }
            boolean zIsDone = isDone();
            if (z12) {
                Thread.currentThread().interrupt();
            }
            return zIsDone;
        }
    }

    private Throwable cause0(Object obj) {
        if (!(obj instanceof CauseHolder)) {
            return null;
        }
        CauseHolder causeHolder = CANCELLATION_CAUSE_HOLDER;
        if (obj == causeHolder) {
            LeanCancellationException leanCancellationException = new LeanCancellationException();
            if (d.a(RESULT_UPDATER, this, causeHolder, new CauseHolder(leanCancellationException))) {
                return leanCancellationException;
            }
            obj = this.result;
        }
        return ((CauseHolder) obj).cause;
    }

    private synchronized boolean checkNotifyWaiters() {
        try {
            if (this.waiters > 0) {
                notifyAll();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return (this.listener == null && this.listeners == null) ? false : true;
    }

    private void decWaiters() {
        this.waiters = (short) (this.waiters - 1);
    }

    private void incWaiters() {
        short s10 = this.waiters;
        if (s10 != Short.MAX_VALUE) {
            this.waiters = (short) (s10 + 1);
        } else {
            throw new IllegalStateException("too many waiters: " + this);
        }
    }

    private static boolean isCancelled0(Object obj) {
        return (obj instanceof CauseHolder) && (((CauseHolder) obj).cause instanceof CancellationException);
    }

    private static boolean isDone0(Object obj) {
        return (obj == null || obj == UNCANCELLABLE) ? false : true;
    }

    public static void notifyListener(EventExecutor eventExecutor, Future<?> future, GenericFutureListener<?> genericFutureListener) {
        notifyListenerWithStackOverFlowProtection((EventExecutor) ObjectUtil.checkNotNull(eventExecutor, "eventExecutor"), (Future) ObjectUtil.checkNotNull(future, "future"), (GenericFutureListener) ObjectUtil.checkNotNull(genericFutureListener, "listener"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void notifyListener0(Future future, GenericFutureListener genericFutureListener) {
        try {
            genericFutureListener.operationComplete(future);
        } catch (Throwable th2) {
            if (logger.isWarnEnabled()) {
                logger.warn("An exception was thrown by " + genericFutureListener.getClass().getName() + ".operationComplete()", th2);
            }
        }
    }

    private static void notifyListenerWithStackOverFlowProtection(EventExecutor eventExecutor, final Future<?> future, final GenericFutureListener<?> genericFutureListener) {
        InternalThreadLocalMap internalThreadLocalMap;
        int iFutureListenerStackDepth;
        if (!eventExecutor.inEventLoop() || (iFutureListenerStackDepth = (internalThreadLocalMap = InternalThreadLocalMap.get()).futureListenerStackDepth()) >= MAX_LISTENER_STACK_DEPTH) {
            safeExecute(eventExecutor, new Runnable() { // from class: io.netty.util.concurrent.DefaultPromise.2
                @Override // java.lang.Runnable
                public void run() {
                    DefaultPromise.notifyListener0(future, genericFutureListener);
                }
            });
            return;
        }
        internalThreadLocalMap.setFutureListenerStackDepth(iFutureListenerStackDepth + 1);
        try {
            notifyListener0(future, genericFutureListener);
        } finally {
            internalThreadLocalMap.setFutureListenerStackDepth(iFutureListenerStackDepth);
        }
    }

    private void notifyListeners() {
        InternalThreadLocalMap internalThreadLocalMap;
        int iFutureListenerStackDepth;
        EventExecutor eventExecutorExecutor = executor();
        if (!eventExecutorExecutor.inEventLoop() || (iFutureListenerStackDepth = (internalThreadLocalMap = InternalThreadLocalMap.get()).futureListenerStackDepth()) >= MAX_LISTENER_STACK_DEPTH) {
            safeExecute(eventExecutorExecutor, new Runnable() { // from class: io.netty.util.concurrent.DefaultPromise.1
                @Override // java.lang.Runnable
                public void run() {
                    DefaultPromise.this.notifyListenersNow();
                }
            });
            return;
        }
        internalThreadLocalMap.setFutureListenerStackDepth(iFutureListenerStackDepth + 1);
        try {
            notifyListenersNow();
        } finally {
            internalThreadLocalMap.setFutureListenerStackDepth(iFutureListenerStackDepth);
        }
    }

    private void notifyListeners0(DefaultFutureListeners defaultFutureListeners) {
        GenericFutureListener<? extends Future<?>>[] genericFutureListenerArrListeners = defaultFutureListeners.listeners();
        int size = defaultFutureListeners.size();
        for (int i10 = 0; i10 < size; i10++) {
            notifyListener0(this, genericFutureListenerArrListeners[i10]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyListenersNow() {
        synchronized (this) {
            try {
                GenericFutureListener<? extends Future<?>> genericFutureListener = this.listener;
                DefaultFutureListeners defaultFutureListeners = this.listeners;
                if (!this.notifyingListeners && (genericFutureListener != null || defaultFutureListeners != null)) {
                    this.notifyingListeners = true;
                    if (genericFutureListener != null) {
                        this.listener = null;
                    } else {
                        this.listeners = null;
                    }
                    while (true) {
                        if (genericFutureListener != null) {
                            notifyListener0(this, genericFutureListener);
                        } else {
                            notifyListeners0(defaultFutureListeners);
                        }
                        synchronized (this) {
                            try {
                                genericFutureListener = this.listener;
                                if (genericFutureListener == null && this.listeners == null) {
                                    this.notifyingListeners = false;
                                    return;
                                }
                                defaultFutureListeners = this.listeners;
                                if (genericFutureListener != null) {
                                    this.listener = null;
                                } else {
                                    this.listeners = null;
                                }
                            } catch (Throwable th2) {
                                throw th2;
                            }
                        }
                    }
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void notifyProgressiveListener0(ProgressiveFuture progressiveFuture, GenericProgressiveFutureListener genericProgressiveFutureListener, long j10, long j11) {
        try {
            genericProgressiveFutureListener.operationProgressed(progressiveFuture, j10, j11);
        } catch (Throwable th2) {
            if (logger.isWarnEnabled()) {
                logger.warn("An exception was thrown by " + genericProgressiveFutureListener.getClass().getName() + ".operationProgressed()", th2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void notifyProgressiveListeners0(ProgressiveFuture<?> progressiveFuture, GenericProgressiveFutureListener<?>[] genericProgressiveFutureListenerArr, long j10, long j11) {
        for (GenericProgressiveFutureListener<?> genericProgressiveFutureListener : genericProgressiveFutureListenerArr) {
            if (genericProgressiveFutureListener == null) {
                return;
            }
            notifyProgressiveListener0(progressiveFuture, genericProgressiveFutureListener, j10, j11);
        }
    }

    private synchronized Object progressiveListeners() {
        GenericFutureListener<? extends Future<?>> genericFutureListener = this.listener;
        DefaultFutureListeners defaultFutureListeners = this.listeners;
        if (genericFutureListener == null && defaultFutureListeners == null) {
            return null;
        }
        if (defaultFutureListeners == null) {
            if (genericFutureListener instanceof GenericProgressiveFutureListener) {
                return genericFutureListener;
            }
            return null;
        }
        int iProgressiveSize = defaultFutureListeners.progressiveSize();
        if (iProgressiveSize == 0) {
            return null;
        }
        int i10 = 0;
        if (iProgressiveSize == 1) {
            GenericFutureListener<? extends Future<?>>[] genericFutureListenerArrListeners = defaultFutureListeners.listeners();
            int length = genericFutureListenerArrListeners.length;
            while (i10 < length) {
                GenericFutureListener<? extends Future<?>> genericFutureListener2 = genericFutureListenerArrListeners[i10];
                if (genericFutureListener2 instanceof GenericProgressiveFutureListener) {
                    return genericFutureListener2;
                }
                i10++;
            }
            return null;
        }
        GenericFutureListener<? extends Future<?>>[] genericFutureListenerArrListeners2 = defaultFutureListeners.listeners();
        GenericProgressiveFutureListener[] genericProgressiveFutureListenerArr = new GenericProgressiveFutureListener[iProgressiveSize];
        int i11 = 0;
        while (i10 < iProgressiveSize) {
            GenericFutureListener<? extends Future<?>> genericFutureListener3 = genericFutureListenerArrListeners2[i11];
            if (genericFutureListener3 instanceof GenericProgressiveFutureListener) {
                int i12 = i10 + 1;
                genericProgressiveFutureListenerArr[i10] = (GenericProgressiveFutureListener) genericFutureListener3;
                i10 = i12;
            }
            i11++;
        }
        return genericProgressiveFutureListenerArr;
    }

    private void removeListener0(GenericFutureListener<? extends Future<? super V>> genericFutureListener) {
        if (this.listener == genericFutureListener) {
            this.listener = null;
            return;
        }
        DefaultFutureListeners defaultFutureListeners = this.listeners;
        if (defaultFutureListeners != null) {
            defaultFutureListeners.remove(genericFutureListener);
            if (this.listeners.size() == 0) {
                this.listeners = null;
            }
        }
    }

    private void rethrowIfFailed() throws Throwable {
        Throwable thCause = cause();
        if (thCause == null) {
            return;
        }
        PlatformDependent.throwException(thCause);
    }

    private static void safeExecute(EventExecutor eventExecutor, Runnable runnable) {
        try {
            eventExecutor.execute(runnable);
        } catch (Throwable th2) {
            rejectedExecutionLogger.error("Failed to submit a listener notification task. Event loop shut down?", th2);
        }
    }

    private boolean setFailure0(Throwable th2) {
        return setValue0(new CauseHolder((Throwable) ObjectUtil.checkNotNull(th2, "cause")));
    }

    private boolean setSuccess0(V v10) {
        if (v10 == null) {
            v10 = (V) SUCCESS;
        }
        return setValue0(v10);
    }

    private boolean setValue0(Object obj) {
        AtomicReferenceFieldUpdater<DefaultPromise, Object> atomicReferenceFieldUpdater = RESULT_UPDATER;
        if (!d.a(atomicReferenceFieldUpdater, this, null, obj) && !d.a(atomicReferenceFieldUpdater, this, UNCANCELLABLE, obj)) {
            return false;
        }
        if (!checkNotifyWaiters()) {
            return true;
        }
        notifyListeners();
        return true;
    }

    @Override // io.netty.util.concurrent.Future, java.util.concurrent.Future
    public boolean cancel(boolean z10) {
        if (!d.a(RESULT_UPDATER, this, null, CANCELLATION_CAUSE_HOLDER)) {
            return false;
        }
        if (!checkNotifyWaiters()) {
            return true;
        }
        notifyListeners();
        return true;
    }

    @Override // io.netty.util.concurrent.Future
    public Throwable cause() {
        return cause0(this.result);
    }

    public void checkDeadLock() {
        EventExecutor eventExecutorExecutor = executor();
        if (eventExecutorExecutor != null && eventExecutorExecutor.inEventLoop()) {
            throw new BlockingOperationException(toString());
        }
    }

    public EventExecutor executor() {
        return this.executor;
    }

    @Override // io.netty.util.concurrent.AbstractFuture, java.util.concurrent.Future
    public V get() throws ExecutionException, InterruptedException {
        V v10 = (V) this.result;
        if (!isDone0(v10)) {
            await();
            v10 = (V) this.result;
        }
        if (v10 == SUCCESS || v10 == UNCANCELLABLE) {
            return null;
        }
        Throwable thCause0 = cause0(v10);
        if (thCause0 == null) {
            return v10;
        }
        if (thCause0 instanceof CancellationException) {
            throw ((CancellationException) thCause0);
        }
        throw new ExecutionException(thCause0);
    }

    @Override // io.netty.util.concurrent.Future
    public V getNow() {
        V v10 = (V) this.result;
        if ((v10 instanceof CauseHolder) || v10 == SUCCESS || v10 == UNCANCELLABLE) {
            return null;
        }
        return v10;
    }

    @Override // io.netty.util.concurrent.Future
    public boolean isCancellable() {
        return this.result == null;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return isCancelled0(this.result);
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return isDone0(this.result);
    }

    @Override // io.netty.util.concurrent.Future
    public boolean isSuccess() {
        Object obj = this.result;
        return (obj == null || obj == UNCANCELLABLE || (obj instanceof CauseHolder)) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void notifyProgressiveListeners(final long j10, final long j11) {
        Object objProgressiveListeners = progressiveListeners();
        if (objProgressiveListeners == null) {
            return;
        }
        final ProgressiveFuture progressiveFuture = (ProgressiveFuture) this;
        EventExecutor eventExecutorExecutor = executor();
        if (eventExecutorExecutor.inEventLoop()) {
            if (objProgressiveListeners instanceof GenericProgressiveFutureListener[]) {
                notifyProgressiveListeners0(progressiveFuture, (GenericProgressiveFutureListener[]) objProgressiveListeners, j10, j11);
                return;
            } else {
                notifyProgressiveListener0(progressiveFuture, (GenericProgressiveFutureListener) objProgressiveListeners, j10, j11);
                return;
            }
        }
        if (objProgressiveListeners instanceof GenericProgressiveFutureListener[]) {
            final GenericProgressiveFutureListener[] genericProgressiveFutureListenerArr = (GenericProgressiveFutureListener[]) objProgressiveListeners;
            safeExecute(eventExecutorExecutor, new Runnable() { // from class: io.netty.util.concurrent.DefaultPromise.3
                @Override // java.lang.Runnable
                public void run() {
                    DefaultPromise.notifyProgressiveListeners0(progressiveFuture, genericProgressiveFutureListenerArr, j10, j11);
                }
            });
        } else {
            final GenericProgressiveFutureListener genericProgressiveFutureListener = (GenericProgressiveFutureListener) objProgressiveListeners;
            safeExecute(eventExecutorExecutor, new Runnable() { // from class: io.netty.util.concurrent.DefaultPromise.4
                @Override // java.lang.Runnable
                public void run() {
                    DefaultPromise.notifyProgressiveListener0(progressiveFuture, genericProgressiveFutureListener, j10, j11);
                }
            });
        }
    }

    public Promise<V> setFailure(Throwable th2) {
        if (setFailure0(th2)) {
            return this;
        }
        throw new IllegalStateException("complete already: " + this, th2);
    }

    public Promise<V> setSuccess(V v10) {
        if (setSuccess0(v10)) {
            return this;
        }
        throw new IllegalStateException("complete already: " + this);
    }

    @Override // io.netty.util.concurrent.Promise
    public boolean setUncancellable() {
        if (d.a(RESULT_UPDATER, this, null, UNCANCELLABLE)) {
            return true;
        }
        Object obj = this.result;
        return (isDone0(obj) && isCancelled0(obj)) ? false : true;
    }

    public String toString() {
        return toStringBuilder().toString();
    }

    public StringBuilder toStringBuilder() {
        StringBuilder sb2 = new StringBuilder(64);
        sb2.append(StringUtil.simpleClassName(this));
        sb2.append('@');
        sb2.append(Integer.toHexString(hashCode()));
        Object obj = this.result;
        if (obj == SUCCESS) {
            sb2.append("(success)");
        } else if (obj == UNCANCELLABLE) {
            sb2.append("(uncancellable)");
        } else if (obj instanceof CauseHolder) {
            sb2.append("(failure: ");
            sb2.append(((CauseHolder) obj).cause);
            sb2.append(')');
        } else if (obj != null) {
            sb2.append("(success: ");
            sb2.append(obj);
            sb2.append(')');
        } else {
            sb2.append("(incomplete)");
        }
        return sb2;
    }

    public boolean tryFailure(Throwable th2) {
        return setFailure0(th2);
    }

    public boolean trySuccess(V v10) {
        return setSuccess0(v10);
    }

    @Override // io.netty.util.concurrent.Future
    public Promise<V> addListener(GenericFutureListener<? extends Future<? super V>> genericFutureListener) {
        ObjectUtil.checkNotNull(genericFutureListener, "listener");
        synchronized (this) {
            addListener0(genericFutureListener);
        }
        if (isDone()) {
            notifyListeners();
        }
        return this;
    }

    @Override // io.netty.util.concurrent.Future
    public Promise<V> addListeners(GenericFutureListener<? extends Future<? super V>>... genericFutureListenerArr) {
        ObjectUtil.checkNotNull(genericFutureListenerArr, "listeners");
        synchronized (this) {
            try {
                for (GenericFutureListener<? extends Future<? super V>> genericFutureListener : genericFutureListenerArr) {
                    if (genericFutureListener == null) {
                        break;
                    }
                    addListener0(genericFutureListener);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (isDone()) {
            notifyListeners();
        }
        return this;
    }

    @Override // io.netty.util.concurrent.Future
    public Promise<V> await() throws InterruptedException {
        if (isDone()) {
            return this;
        }
        if (Thread.interrupted()) {
            throw new InterruptedException(toString());
        }
        checkDeadLock();
        synchronized (this) {
            while (!isDone()) {
                try {
                    incWaiters();
                    try {
                        wait();
                        decWaiters();
                    } catch (Throwable th2) {
                        decWaiters();
                        throw th2;
                    }
                } catch (Throwable th3) {
                    throw th3;
                }
            }
        }
        return this;
    }

    @Override // io.netty.util.concurrent.Future
    public Promise<V> awaitUninterruptibly() {
        boolean z10;
        if (isDone()) {
            return this;
        }
        checkDeadLock();
        synchronized (this) {
            z10 = false;
            while (!isDone()) {
                try {
                    incWaiters();
                    try {
                        wait();
                        decWaiters();
                    } catch (InterruptedException unused) {
                        decWaiters();
                        z10 = true;
                    } catch (Throwable th2) {
                        decWaiters();
                        throw th2;
                    }
                } catch (Throwable th3) {
                    throw th3;
                }
            }
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
        return this;
    }

    @Override // io.netty.util.concurrent.Future
    public Promise<V> removeListener(GenericFutureListener<? extends Future<? super V>> genericFutureListener) {
        ObjectUtil.checkNotNull(genericFutureListener, "listener");
        synchronized (this) {
            removeListener0(genericFutureListener);
        }
        return this;
    }

    @Override // io.netty.util.concurrent.Future
    public Promise<V> removeListeners(GenericFutureListener<? extends Future<? super V>>... genericFutureListenerArr) {
        ObjectUtil.checkNotNull(genericFutureListenerArr, "listeners");
        synchronized (this) {
            try {
                for (GenericFutureListener<? extends Future<? super V>> genericFutureListener : genericFutureListenerArr) {
                    if (genericFutureListener == null) {
                        break;
                    }
                    removeListener0(genericFutureListener);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return this;
    }

    @Override // io.netty.util.concurrent.Future
    public Promise<V> sync() throws Throwable {
        await();
        rethrowIfFailed();
        return this;
    }

    @Override // io.netty.util.concurrent.Future
    public Promise<V> syncUninterruptibly() throws Throwable {
        awaitUninterruptibly();
        rethrowIfFailed();
        return this;
    }

    public DefaultPromise() {
        this.executor = null;
    }

    @Override // io.netty.util.concurrent.AbstractFuture, java.util.concurrent.Future
    public V get(long j10, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        V v10 = (V) this.result;
        if (!isDone0(v10)) {
            if (await(j10, timeUnit)) {
                v10 = (V) this.result;
            } else {
                throw new TimeoutException();
            }
        }
        if (v10 == SUCCESS || v10 == UNCANCELLABLE) {
            return null;
        }
        Throwable thCause0 = cause0(v10);
        if (thCause0 == null) {
            return v10;
        }
        if (thCause0 instanceof CancellationException) {
            throw ((CancellationException) thCause0);
        }
        throw new ExecutionException(thCause0);
    }

    @Override // io.netty.util.concurrent.Future
    public boolean await(long j10, TimeUnit timeUnit) throws InterruptedException {
        return await0(timeUnit.toNanos(j10), true);
    }

    @Override // io.netty.util.concurrent.Future
    public boolean await(long j10) throws InterruptedException {
        return await0(TimeUnit.MILLISECONDS.toNanos(j10), true);
    }

    @Override // io.netty.util.concurrent.Future
    public boolean awaitUninterruptibly(long j10, TimeUnit timeUnit) {
        try {
            return await0(timeUnit.toNanos(j10), false);
        } catch (InterruptedException unused) {
            throw new InternalError();
        }
    }

    @Override // io.netty.util.concurrent.Future
    public boolean awaitUninterruptibly(long j10) {
        try {
            return await0(TimeUnit.MILLISECONDS.toNanos(j10), false);
        } catch (InterruptedException unused) {
            throw new InternalError();
        }
    }
}
