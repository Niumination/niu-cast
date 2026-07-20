package q1;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true)
@o0
public final class g0 {
    public static /* synthetic */ Object d(Object obj) {
        return obj;
    }

    @b1.c
    @b1.d
    public static <T> w<T> e(final Callable<T> callable, final w1 listeningExecutorService) {
        callable.getClass();
        listeningExecutorService.getClass();
        return new w() { // from class: q1.d0
            @Override // q1.w
            public final s1 call() {
                return listeningExecutorService.submit(callable);
            }
        };
    }

    public static /* synthetic */ Object g(Object obj) throws Exception {
        return obj;
    }

    public static /* synthetic */ Object h(c1.q0 q0Var, Callable callable) throws Exception {
        Thread threadCurrentThread = Thread.currentThread();
        String name = threadCurrentThread.getName();
        boolean zM = m((String) q0Var.get(), threadCurrentThread);
        try {
            return callable.call();
        } finally {
            if (zM) {
                m(name, threadCurrentThread);
            }
        }
    }

    public static /* synthetic */ void i(c1.q0 q0Var, Runnable runnable) {
        Thread threadCurrentThread = Thread.currentThread();
        String name = threadCurrentThread.getName();
        boolean zM = m((String) q0Var.get(), threadCurrentThread);
        try {
            runnable.run();
        } finally {
            if (zM) {
                m(name, threadCurrentThread);
            }
        }
    }

    public static <T> Callable<T> j(@c2 final T value) {
        return new Callable() { // from class: q1.e0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return value;
            }
        };
    }

    @b1.c
    @b1.d
    public static Runnable k(final Runnable task, final c1.q0<String> nameSupplier) {
        nameSupplier.getClass();
        task.getClass();
        return new Runnable() { // from class: q1.f0
            @Override // java.lang.Runnable
            public final void run() {
                g0.i(nameSupplier, task);
            }
        };
    }

    @b1.c
    @b1.d
    public static <T> Callable<T> l(final Callable<T> callable, final c1.q0<String> nameSupplier) {
        nameSupplier.getClass();
        callable.getClass();
        return new Callable() { // from class: q1.c0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return g0.h(nameSupplier, callable);
            }
        };
    }

    @b1.c
    @b1.d
    public static boolean m(String threadName, Thread currentThread) {
        try {
            currentThread.setName(threadName);
            return true;
        } catch (SecurityException unused) {
            return false;
        }
    }
}
