package q1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true)
@o0
@t1.f("Use FluentFuture.from(Futures.immediate*Future) or SettableFuture")
public abstract class u0<V> extends m1<V> {

    public static abstract class a<V> extends u0<V> implements f.i<V> {
        @Override // q1.f, q1.s1
        public final void addListener(Runnable listener, Executor executor) {
            super.addListener(listener, executor);
        }

        @Override // q1.f, java.util.concurrent.Future
        @t1.a
        public final boolean cancel(boolean mayInterruptIfRunning) {
            return super.cancel(mayInterruptIfRunning);
        }

        @Override // q1.f, java.util.concurrent.Future
        @t1.a
        @c2
        public final V get() throws ExecutionException, InterruptedException {
            return (V) super.get();
        }

        @Override // q1.f, java.util.concurrent.Future
        public final boolean isCancelled() {
            return this.f13426a instanceof f.c;
        }

        @Override // q1.f, java.util.concurrent.Future
        public final boolean isDone() {
            return super.isDone();
        }

        @Override // q1.f, java.util.concurrent.Future
        @t1.a
        @c2
        public final V get(long j10, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
            return (V) super.get(j10, timeUnit);
        }
    }

    @Deprecated
    public static <V> u0<V> I(u0<V> future) {
        future.getClass();
        return future;
    }

    public static <V> u0<V> J(s1<V> future) {
        return future instanceof u0 ? (u0) future : new z0(future);
    }

    public final void F(e1<? super V> callback, Executor executor) {
        h1.c(this, callback, executor);
    }

    @d2.a("AVAILABLE but requires exceptionType to be Throwable.class")
    @b1.d
    public final <X extends Throwable> u0<V> G(Class<X> exceptionType, c1.t<? super X, ? extends V> fallback, Executor executor) {
        return (u0) q1.a.N(this, exceptionType, fallback, executor);
    }

    @d2.a("AVAILABLE but requires exceptionType to be Throwable.class")
    @b1.d
    public final <X extends Throwable> u0<V> H(Class<X> exceptionType, x<? super X, ? extends V> fallback, Executor executor) {
        return (u0) q1.a.O(this, exceptionType, fallback, executor);
    }

    public final <T> u0<T> K(c1.t<? super V, T> function, Executor executor) {
        return (u0) r.N(this, function, executor);
    }

    public final <T> u0<T> L(x<? super V, T> function, Executor executor) {
        return (u0) r.O(this, function, executor);
    }

    @b1.c
    @b1.d
    public final u0<V> M(long timeout, TimeUnit unit, ScheduledExecutorService scheduledExecutor) {
        return (u0) h1.H(this, timeout, unit, scheduledExecutor);
    }
}
