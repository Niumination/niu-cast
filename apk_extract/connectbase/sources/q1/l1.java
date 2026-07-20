package q1;

import f1.l5;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@o0
@b1.d
public final class l1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l5<List<Class<?>>> f13587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final l5<Constructor<?>> f13588b;

    @b1.e
    public interface a {
        void validateClass(Class<? extends Exception> exceptionClass);
    }

    @b1.e
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f13589a = l1.q();

        public enum a implements a {
            INSTANCE;


            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final Set<WeakReference<Class<? extends Exception>>> f13590a = new CopyOnWriteArraySet();

            public static /* synthetic */ a[] a() {
                return new a[]{INSTANCE};
            }

            @Override // q1.l1.a
            public void validateClass(Class<? extends Exception> exceptionClass) {
                Iterator<WeakReference<Class<? extends Exception>>> it = f13590a.iterator();
                while (it.hasNext()) {
                    if (exceptionClass.equals(it.next().get())) {
                        return;
                    }
                }
                l1.e(exceptionClass);
                Set<WeakReference<Class<? extends Exception>>> set = f13590a;
                if (set.size() > 1000) {
                    set.clear();
                }
                set.add(new WeakReference<>(exceptionClass));
            }
        }

        public static a a() {
            return l1.q();
        }
    }

    static {
        l5<List<Class<?>>> l5VarReverse = l5.natural().onResultOf(new i1()).compound(l5.natural().onResultOf(new j1())).reverse();
        f13587a = l5VarReverse;
        f13588b = l5VarReverse.onResultOf(new k1());
    }

    public static a d() {
        return b.f13589a;
    }

    @b1.e
    public static void e(Class<? extends Exception> exceptionClass) {
        c1.h0.u(j(exceptionClass), "Futures.getChecked exception type (%s) must not be a RuntimeException", exceptionClass);
        c1.h0.u(i(exceptionClass), "Futures.getChecked exception type (%s) must be an accessible class with an accessible constructor whose parameters (if any) must be of type String and/or Throwable", exceptionClass);
    }

    @t1.a
    @c2
    public static <V, X extends Exception> V f(Future<V> future, Class<X> cls) throws Exception {
        return (V) h(b.f13589a, future, cls);
    }

    @t1.a
    @c2
    public static <V, X extends Exception> V g(Future<V> future, Class<X> exceptionClass, long timeout, TimeUnit unit) throws Exception {
        b.f13589a.validateClass(exceptionClass);
        try {
            return future.get(timeout, unit);
        } catch (InterruptedException e10) {
            Thread.currentThread().interrupt();
            throw o(exceptionClass, e10);
        } catch (ExecutionException e11) {
            r(e11.getCause(), exceptionClass);
            throw new AssertionError();
        } catch (TimeoutException e12) {
            throw o(exceptionClass, e12);
        }
    }

    @t1.a
    @b1.e
    @c2
    public static <V, X extends Exception> V h(a validator, Future<V> future, Class<X> exceptionClass) throws Exception {
        validator.validateClass(exceptionClass);
        try {
            return future.get();
        } catch (InterruptedException e10) {
            Thread.currentThread().interrupt();
            throw o(exceptionClass, e10);
        } catch (ExecutionException e11) {
            r(e11.getCause(), exceptionClass);
            throw new AssertionError();
        }
    }

    public static boolean i(Class<? extends Exception> exceptionClass) {
        try {
            o(exceptionClass, new Exception());
            return true;
        } catch (Error | RuntimeException unused) {
            return false;
        }
    }

    @b1.e
    public static boolean j(Class<? extends Exception> type) {
        return !RuntimeException.class.isAssignableFrom(type);
    }

    public static /* synthetic */ Comparable k(List list) {
        return Boolean.valueOf(list.contains(String.class));
    }

    public static /* synthetic */ Comparable l(List list) {
        return Boolean.valueOf(list.contains(Throwable.class));
    }

    public static /* synthetic */ List m(Constructor constructor) {
        return Arrays.asList(constructor.getParameterTypes());
    }

    @gm.a
    public static <X> X n(Constructor<X> constructor, Throwable cause) {
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        Object[] objArr = new Object[parameterTypes.length];
        for (int i10 = 0; i10 < parameterTypes.length; i10++) {
            Class<?> cls = parameterTypes[i10];
            if (cls.equals(String.class)) {
                objArr[i10] = cause.toString();
            } else {
                if (!cls.equals(Throwable.class)) {
                    return null;
                }
                objArr[i10] = cause;
            }
        }
        try {
            return constructor.newInstance(objArr);
        } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    public static <X extends Exception> X o(Class<X> exceptionClass, Throwable cause) {
        Iterator it = f13588b.sortedCopy(Arrays.asList(exceptionClass.getConstructors())).iterator();
        while (it.hasNext()) {
            X x10 = (X) n((Constructor) it.next(), cause);
            if (x10 != null) {
                if (x10.getCause() == null) {
                    x10.initCause(cause);
                }
                return x10;
            }
        }
        throw new IllegalArgumentException("No appropriate constructor for exception of type " + exceptionClass + " in response to chained exception", cause);
    }

    public static <X extends Exception> List<Constructor<X>> p(List<Constructor<X>> list) {
        return (List<Constructor<X>>) f13588b.sortedCopy(list);
    }

    @b1.e
    public static a q() {
        return b.a.INSTANCE;
    }

    public static <X extends Exception> void r(Throwable cause, Class<X> exceptionClass) throws Exception {
        if (cause instanceof Error) {
            throw new p0((Error) cause);
        }
        if (!(cause instanceof RuntimeException)) {
            throw o(exceptionClass, cause);
        }
        throw new c3(cause);
    }
}
