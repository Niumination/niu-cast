package q1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@o0
public abstract class a1<V> extends f1.j2 implements Future<V> {

    public static abstract class a<V> extends a1<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Future<V> f13404a;

        public a(Future<V> delegate) {
            delegate.getClass();
            this.f13404a = delegate;
        }

        @Override // q1.a1, f1.j2
        public Object delegate() {
            return this.f13404a;
        }

        @Override // q1.a1
        /* JADX INFO: renamed from: l */
        public final Future<V> delegate() {
            return this.f13404a;
        }
    }

    @Override // java.util.concurrent.Future
    @t1.a
    public boolean cancel(boolean mayInterruptIfRunning) {
        return delegate().cancel(mayInterruptIfRunning);
    }

    @Override // java.util.concurrent.Future
    @t1.a
    @c2
    public V get() throws ExecutionException, InterruptedException {
        return delegate().get();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return delegate().isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return delegate().isDone();
    }

    @Override // f1.j2
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public abstract Future<? extends V> delegate();

    @Override // java.util.concurrent.Future
    @t1.a
    @c2
    public V get(long timeout, TimeUnit unit) throws ExecutionException, InterruptedException, TimeoutException {
        return delegate().get(timeout, unit);
    }
}
