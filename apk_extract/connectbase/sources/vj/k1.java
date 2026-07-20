package vj;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@t0
public final class k1 {

    public interface a<T> extends x2.b<T> {
    }

    @b1.e
    public static <T> Iterable<T> a(Class<T> cls, Iterable<Class<?>> iterable) {
        return x2.b(cls, iterable);
    }

    @b1.e
    public static <T> Iterable<T> b(Class<T> cls, ClassLoader classLoader) {
        return x2.c(cls, classLoader);
    }

    public static boolean c(ClassLoader classLoader) {
        return x2.d(classLoader);
    }

    public static <T> T d(Class<T> cls, Iterable<Class<?>> iterable, ClassLoader classLoader, a<T> aVar) {
        return (T) x2.e(cls, iterable, classLoader, aVar);
    }

    public static <T> List<T> e(Class<T> cls, Iterable<Class<?>> iterable, ClassLoader classLoader, a<T> aVar) {
        return x2.f(cls, iterable, classLoader, aVar);
    }
}
