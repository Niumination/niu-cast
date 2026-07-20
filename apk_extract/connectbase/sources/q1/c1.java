package q1;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@o0
@b1.d
public abstract class c1 extends y0 implements w1 {
    @Override // q1.y0
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public abstract w1 delegate();

    @Override // q1.y0, java.util.concurrent.ExecutorService, q1.w1
    public <T> s1<T> submit(Callable<T> task) {
        return delegate().submit((Callable) task);
    }

    @Override // q1.y0, java.util.concurrent.ExecutorService, q1.w1
    public s1<?> submit(Runnable task) {
        return delegate().submit(task);
    }

    @Override // q1.y0, java.util.concurrent.ExecutorService, q1.w1
    public <T> s1<T> submit(Runnable task, @c2 T result) {
        return delegate().submit(task, (Object) result);
    }
}
