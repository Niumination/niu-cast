package q1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@o0
@b1.d
public final class t0 implements y2 {
    @Override // q1.y2
    public void a(Runnable runnable, long timeoutDuration, TimeUnit timeoutUnit) {
        runnable.getClass();
        timeoutUnit.getClass();
        try {
            runnable.run();
        } catch (Error e10) {
            throw new p0(e10);
        } catch (RuntimeException e11) {
            throw new c3(e11);
        }
    }

    @Override // q1.y2
    @t1.a
    public <T> T b(T target, Class<T> interfaceType, long timeoutDuration, TimeUnit timeoutUnit) {
        target.getClass();
        interfaceType.getClass();
        timeoutUnit.getClass();
        return target;
    }

    @Override // q1.y2
    public void c(Runnable runnable, long timeoutDuration, TimeUnit timeoutUnit) {
        a(runnable, timeoutDuration, timeoutUnit);
    }

    @Override // q1.y2
    @t1.a
    @c2
    public <T> T d(Callable<T> callable, long j10, TimeUnit timeUnit) throws ExecutionException {
        return (T) e(callable, j10, timeUnit);
    }

    @Override // q1.y2
    @t1.a
    @c2
    public <T> T e(Callable<T> callable, long timeoutDuration, TimeUnit timeoutUnit) throws ExecutionException {
        callable.getClass();
        timeoutUnit.getClass();
        try {
            return callable.call();
        } catch (Error e10) {
            throw new p0(e10);
        } catch (RuntimeException e11) {
            throw new c3(e11);
        } catch (Exception e12) {
            e2.b(e12);
            throw new ExecutionException(e12);
        }
    }
}
