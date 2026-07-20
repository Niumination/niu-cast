package q1;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@o0
@b1.d
public abstract class g3 implements ExecutorService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f13466a;

    public g3(ExecutorService delegate) {
        delegate.getClass();
        this.f13466a = delegate;
    }

    public static /* synthetic */ void b(Callable callable) {
        try {
            callable.call();
        } catch (Exception e10) {
            e2.b(e10);
            c1.t0.w(e10);
            throw new RuntimeException(e10);
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return this.f13466a.awaitTermination(timeout, unit);
    }

    public Runnable c(Runnable command) {
        final Callable callableD = d(Executors.callable(command, null));
        return new Runnable() { // from class: q1.f3
            @Override // java.lang.Runnable
            public final void run() {
                g3.b(callableD);
            }
        };
    }

    public abstract <T> Callable<T> d(Callable<T> callable);

    public final <T> f1.i3<Callable<T>> e(Collection<? extends Callable<T>> tasks) {
        f1.i3.a aVarBuilder = f1.i3.builder();
        Iterator<? extends Callable<T>> it = tasks.iterator();
        while (it.hasNext()) {
            aVarBuilder.j(d(it.next()));
        }
        return aVarBuilder.e();
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable command) {
        this.f13466a.execute(c(command));
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
        return this.f13466a.invokeAll(e(tasks));
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> T invokeAny(Collection<? extends Callable<T>> collection) throws ExecutionException, InterruptedException {
        return (T) this.f13466a.invokeAny(e(collection));
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isShutdown() {
        return this.f13466a.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isTerminated() {
        return this.f13466a.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public final void shutdown() {
        this.f13466a.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    @t1.a
    public final List<Runnable> shutdownNow() {
        return this.f13466a.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> Future<T> submit(Callable<T> task) {
        ExecutorService executorService = this.f13466a;
        task.getClass();
        return executorService.submit(d(task));
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException {
        return this.f13466a.invokeAll(e(tasks), timeout, unit);
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> T invokeAny(Collection<? extends Callable<T>> collection, long j10, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return (T) this.f13466a.invokeAny(e(collection), j10, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public final Future<?> submit(Runnable task) {
        return this.f13466a.submit(c(task));
    }

    @Override // java.util.concurrent.ExecutorService
    public final <T> Future<T> submit(Runnable task, @c2 T result) {
        return this.f13466a.submit(c(task), result);
    }
}
