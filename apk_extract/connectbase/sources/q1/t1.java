package q1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@o0
@b1.d
public class t1<V> extends FutureTask<V> implements s1<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q0 f13720a;

    public t1(Callable<V> callable) {
        super(callable);
        this.f13720a = new q0();
    }

    public static <V> t1<V> a(Runnable runnable, @c2 V result) {
        return new t1<>(runnable, result);
    }

    public static <V> t1<V> b(Callable<V> callable) {
        return new t1<>(callable);
    }

    @Override // q1.s1
    public void addListener(Runnable listener, Executor exec) {
        this.f13720a.a(listener, exec);
    }

    @Override // java.util.concurrent.FutureTask
    public void done() {
        this.f13720a.b();
    }

    @Override // java.util.concurrent.FutureTask, java.util.concurrent.Future
    @t1.a
    @c2
    public V get(long j10, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j10);
        return nanos <= b2.f13408a ? (V) super.get(j10, timeUnit) : (V) super.get(Math.min(nanos, b2.f13408a), TimeUnit.NANOSECONDS);
    }

    public t1(Runnable runnable, @c2 V result) {
        super(runnable, result);
        this.f13720a = new q0();
    }
}
