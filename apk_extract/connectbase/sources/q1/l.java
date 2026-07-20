package q1;

import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@o0
@t1.b
@b1.d
public abstract class l extends AbstractExecutorService implements w1 {
    @Override // java.util.concurrent.AbstractExecutorService
    @t1.a
    public final <T> RunnableFuture<T> newTaskFor(Runnable runnable, @c2 T value) {
        return a3.N(runnable, value);
    }

    @Override // java.util.concurrent.AbstractExecutorService
    @t1.a
    public final <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return a3.O(callable);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, q1.w1
    @t1.a
    public s1<?> submit(Runnable task) {
        return (s1) super.submit(task);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, q1.w1
    @t1.a
    public <T> s1<T> submit(Runnable task, @c2 T result) {
        return (s1) super.submit(task, (Object) result);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, q1.w1
    @t1.a
    public <T> s1<T> submit(Callable<T> task) {
        return (s1) super.submit((Callable) task);
    }
}
