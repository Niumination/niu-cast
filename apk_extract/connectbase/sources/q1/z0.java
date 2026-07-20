package q1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@o0
public final class z0<V> extends u0<V> {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final s1<V> f13775n;

    public z0(s1<V> delegate) {
        delegate.getClass();
        this.f13775n = delegate;
    }

    @Override // q1.f, q1.s1
    public void addListener(Runnable listener, Executor executor) {
        this.f13775n.addListener(listener, executor);
    }

    @Override // q1.f, java.util.concurrent.Future
    public boolean cancel(boolean mayInterruptIfRunning) {
        return this.f13775n.cancel(mayInterruptIfRunning);
    }

    @Override // q1.f, java.util.concurrent.Future
    @c2
    public V get() throws ExecutionException, InterruptedException {
        return this.f13775n.get();
    }

    @Override // q1.f, java.util.concurrent.Future
    public boolean isCancelled() {
        return this.f13775n.isCancelled();
    }

    @Override // q1.f, java.util.concurrent.Future
    public boolean isDone() {
        return this.f13775n.isDone();
    }

    @Override // q1.f
    public String toString() {
        return this.f13775n.toString();
    }

    @Override // q1.f, java.util.concurrent.Future
    @c2
    public V get(long timeout, TimeUnit unit) throws ExecutionException, InterruptedException, TimeoutException {
        return this.f13775n.get(timeout, unit);
    }
}
