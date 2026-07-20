package q1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@o0
@t1.f("Use FakeTimeLimiter")
@b1.d
public interface y2 {
    void a(Runnable runnable, long timeoutDuration, TimeUnit timeoutUnit) throws InterruptedException, TimeoutException;

    <T> T b(T target, Class<T> interfaceType, long timeoutDuration, TimeUnit timeoutUnit);

    void c(Runnable runnable, long timeoutDuration, TimeUnit timeoutUnit) throws TimeoutException;

    @t1.a
    @c2
    <T> T d(Callable<T> callable, long timeoutDuration, TimeUnit timeoutUnit) throws ExecutionException, TimeoutException;

    @t1.a
    @c2
    <T> T e(Callable<T> callable, long timeoutDuration, TimeUnit timeoutUnit) throws ExecutionException, InterruptedException, TimeoutException;
}
