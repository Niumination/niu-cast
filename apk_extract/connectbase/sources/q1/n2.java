package q1;

import f1.i5;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@o0
@b1.d
public final class n2 implements y2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f13633a;

    public class a implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f13634a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f13635b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ TimeUnit f13636c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Set f13637d;

        public a(final Object val$target, final long val$timeoutDuration, final TimeUnit val$timeoutUnit, final Set val$interruptibleMethods) {
            this.f13634a = val$target;
            this.f13635b = val$timeoutDuration;
            this.f13636c = val$timeoutUnit;
            this.f13637d = val$interruptibleMethods;
        }

        public static /* synthetic */ Object b(Method method, Object obj, Object[] objArr) throws Exception {
            try {
                return method.invoke(obj, objArr);
            } catch (InvocationTargetException e10) {
                throw n2.n(e10, false);
            }
        }

        @Override // java.lang.reflect.InvocationHandler
        @gm.a
        public Object invoke(Object obj, final Method method, @gm.a final Object[] args) throws Throwable {
            final Object obj2 = this.f13634a;
            return n2.this.h(new Callable() { // from class: q1.m2
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return n2.a.b(method, obj2, args);
                }
            }, this.f13635b, this.f13636c, this.f13637d.contains(method));
        }
    }

    public n2(ExecutorService executor) {
        executor.getClass();
        this.f13633a = executor;
    }

    public static void i(long timeoutDuration) {
        c1.h0.p(timeoutDuration > 0, "timeout must be positive: %s", timeoutDuration);
    }

    public static n2 j(ExecutorService executor) {
        return new n2(executor);
    }

    public static boolean k(Method method) {
        for (Class<?> cls : method.getExceptionTypes()) {
            if (cls == InterruptedException.class) {
                return true;
            }
        }
        return false;
    }

    public static Set<Method> l(Class<?> interfaceType) {
        HashSet hashSet = new HashSet();
        for (Method method : interfaceType.getMethods()) {
            if (k(method)) {
                hashSet.add(method);
            }
        }
        return hashSet;
    }

    public static <T> T m(Class<T> interfaceType, InvocationHandler handler) {
        return interfaceType.cast(Proxy.newProxyInstance(interfaceType.getClassLoader(), new Class[]{interfaceType}, handler));
    }

    public static Exception n(Exception e10, boolean combineStackTraces) throws Exception {
        Throwable cause = e10.getCause();
        if (cause == null) {
            throw e10;
        }
        if (combineStackTraces) {
            cause.setStackTrace((StackTraceElement[]) i5.f(cause.getStackTrace(), e10.getStackTrace(), StackTraceElement.class));
        }
        if (cause instanceof Exception) {
            throw ((Exception) cause);
        }
        if (cause instanceof Error) {
            throw ((Error) cause);
        }
        throw e10;
    }

    @Override // q1.y2
    public void a(Runnable runnable, long timeoutDuration, TimeUnit timeoutUnit) throws InterruptedException, TimeoutException {
        runnable.getClass();
        timeoutUnit.getClass();
        i(timeoutDuration);
        Future<?> futureSubmit = this.f13633a.submit(runnable);
        try {
            futureSubmit.get(timeoutDuration, timeoutUnit);
        } catch (InterruptedException | TimeoutException e10) {
            futureSubmit.cancel(true);
            throw e10;
        } catch (ExecutionException e11) {
            p(e11.getCause());
            throw new AssertionError();
        }
    }

    @Override // q1.y2
    public <T> T b(T t10, Class<T> cls, long j10, TimeUnit timeUnit) {
        t10.getClass();
        cls.getClass();
        timeUnit.getClass();
        i(j10);
        c1.h0.e(cls.isInterface(), "interfaceType must be an interface type");
        return (T) m(cls, new a(t10, j10, timeUnit, l(cls)));
    }

    @Override // q1.y2
    public void c(Runnable runnable, long timeoutDuration, TimeUnit timeoutUnit) throws TimeoutException {
        runnable.getClass();
        timeoutUnit.getClass();
        i(timeoutDuration);
        Future<?> futureSubmit = this.f13633a.submit(runnable);
        try {
            e3.g(futureSubmit, timeoutDuration, timeoutUnit);
        } catch (ExecutionException e10) {
            p(e10.getCause());
            throw new AssertionError();
        } catch (TimeoutException e11) {
            futureSubmit.cancel(true);
            throw e11;
        }
    }

    @Override // q1.y2
    @t1.a
    @c2
    public <T> T d(Callable<T> callable, long j10, TimeUnit timeUnit) throws ExecutionException, TimeoutException {
        callable.getClass();
        timeUnit.getClass();
        i(j10);
        Future<T> futureSubmit = this.f13633a.submit(callable);
        try {
            return (T) e3.g(futureSubmit, j10, timeUnit);
        } catch (ExecutionException e10) {
            o(e10.getCause());
            throw new AssertionError();
        } catch (TimeoutException e11) {
            futureSubmit.cancel(true);
            throw e11;
        }
    }

    @Override // q1.y2
    @t1.a
    @c2
    public <T> T e(Callable<T> callable, long timeoutDuration, TimeUnit timeoutUnit) throws ExecutionException, InterruptedException, TimeoutException {
        callable.getClass();
        timeoutUnit.getClass();
        i(timeoutDuration);
        Future<T> futureSubmit = this.f13633a.submit(callable);
        try {
            return futureSubmit.get(timeoutDuration, timeoutUnit);
        } catch (InterruptedException | TimeoutException e10) {
            futureSubmit.cancel(true);
            throw e10;
        } catch (ExecutionException e11) {
            o(e11.getCause());
            throw new AssertionError();
        }
    }

    @c2
    public final <T> T h(Callable<T> callable, long j10, TimeUnit timeUnit, boolean z10) throws Exception {
        callable.getClass();
        timeUnit.getClass();
        i(j10);
        Future future = (T) this.f13633a.submit(callable);
        try {
            future = z10 ? (T) future.get(j10, timeUnit) : (T) e3.g(future, j10, timeUnit);
            return (T) future;
        } catch (InterruptedException e10) {
            future.cancel(true);
            throw e10;
        } catch (ExecutionException e11) {
            throw n(e11, true);
        } catch (TimeoutException e12) {
            future.cancel(true);
            throw new d3(e12);
        }
    }

    public final void o(Throwable cause) throws ExecutionException {
        if (cause instanceof Error) {
            throw new p0((Error) cause);
        }
        if (!(cause instanceof RuntimeException)) {
            throw new ExecutionException(cause);
        }
        throw new c3(cause);
    }

    public final void p(Throwable cause) {
        if (!(cause instanceof Error)) {
            throw new c3(cause);
        }
        throw new p0((Error) cause);
    }
}
