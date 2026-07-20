package io.netty.util.concurrent;

import io.netty.util.internal.StringUtil;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;

/* JADX INFO: loaded from: classes3.dex */
class PromiseTask<V> extends DefaultPromise<V> implements RunnableFuture<V> {
    private Object task;
    private static final Runnable COMPLETED = new SentinelRunnable("COMPLETED");
    private static final Runnable CANCELLED = new SentinelRunnable("CANCELLED");
    private static final Runnable FAILED = new SentinelRunnable("FAILED");

    public static final class RunnableAdapter<T> implements Callable<T> {
        final T result;
        final Runnable task;

        public RunnableAdapter(Runnable runnable, T t10) {
            this.task = runnable;
            this.result = t10;
        }

        @Override // java.util.concurrent.Callable
        public T call() {
            this.task.run();
            return this.result;
        }

        public String toString() {
            return "Callable(task: " + this.task + ", result: " + this.result + ')';
        }
    }

    public static class SentinelRunnable implements Runnable {
        private final String name;

        public SentinelRunnable(String str) {
            this.name = str;
        }

        @Override // java.lang.Runnable
        public void run() {
        }

        public String toString() {
            return this.name;
        }
    }

    public PromiseTask(EventExecutor eventExecutor, Runnable runnable, V v10) {
        super(eventExecutor);
        this.task = v10 != null ? new RunnableAdapter(runnable, v10) : runnable;
    }

    private boolean clearTaskAfterCompletion(boolean z10, Runnable runnable) {
        if (z10) {
            this.task = runnable;
        }
        return z10;
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Future, java.util.concurrent.Future
    public boolean cancel(boolean z10) {
        return clearTaskAfterCompletion(super.cancel(z10), CANCELLED);
    }

    public final boolean equals(Object obj) {
        return this == obj;
    }

    public final int hashCode() {
        return System.identityHashCode(this);
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public void run() {
        try {
            if (setUncancellableInternal()) {
                setSuccessInternal(runTask());
            }
        } catch (Throwable th2) {
            setFailureInternal(th2);
        }
    }

    public V runTask() throws Throwable {
        Object obj = this.task;
        if (obj instanceof Callable) {
            return (V) ((Callable) obj).call();
        }
        ((Runnable) obj).run();
        return null;
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Promise, io.netty.channel.ChannelPromise
    public final Promise<V> setFailure(Throwable th2) {
        throw new IllegalStateException();
    }

    public final Promise<V> setFailureInternal(Throwable th2) {
        super.setFailure(th2);
        clearTaskAfterCompletion(true, FAILED);
        return this;
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Promise, io.netty.util.concurrent.ProgressivePromise
    public final Promise<V> setSuccess(V v10) {
        throw new IllegalStateException();
    }

    public final Promise<V> setSuccessInternal(V v10) {
        super.setSuccess(v10);
        clearTaskAfterCompletion(true, COMPLETED);
        return this;
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Promise
    public final boolean setUncancellable() {
        throw new IllegalStateException();
    }

    public final boolean setUncancellableInternal() {
        return super.setUncancellable();
    }

    @Override // io.netty.util.concurrent.DefaultPromise
    public StringBuilder toStringBuilder() {
        StringBuilder stringBuilder = super.toStringBuilder();
        stringBuilder.setCharAt(stringBuilder.length() - 1, StringUtil.COMMA);
        stringBuilder.append(" task: ");
        stringBuilder.append(this.task);
        stringBuilder.append(')');
        return stringBuilder;
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Promise
    public final boolean tryFailure(Throwable th2) {
        return false;
    }

    public final boolean tryFailureInternal(Throwable th2) {
        return clearTaskAfterCompletion(super.tryFailure(th2), FAILED);
    }

    @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Promise
    public final boolean trySuccess(V v10) {
        return false;
    }

    public final boolean trySuccessInternal(V v10) {
        return clearTaskAfterCompletion(super.trySuccess(v10), COMPLETED);
    }

    public PromiseTask(EventExecutor eventExecutor, Runnable runnable) {
        super(eventExecutor);
        this.task = runnable;
    }

    public PromiseTask(EventExecutor eventExecutor, Callable<V> callable) {
        super(eventExecutor);
        this.task = callable;
    }
}
