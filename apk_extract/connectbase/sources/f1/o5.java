package f1;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true)
@x0
public final class o5 {
    public static <T> T[] a(Object[] objArr, int i10, int i11, T[] tArr) {
        return (T[]) Arrays.copyOfRange(objArr, i10, i11, tArr.getClass());
    }

    public static <E extends Enum<E>> Class<E> b(E e10) {
        return e10.getDeclaringClass();
    }

    public static <T> T[] c(T[] tArr, int i10) {
        if (tArr.length != 0) {
            tArr = (T[]) Arrays.copyOf(tArr, 0);
        }
        return (T[]) Arrays.copyOf(tArr, i10);
    }

    public static <K, V> Map<K, V> d(int expectedSize) {
        return d0.createWithExpectedSize(expectedSize);
    }

    public static <E> Set<E> e(int expectedSize) {
        return e0.createWithExpectedSize(expectedSize);
    }

    public static <K, V> Map<K, V> f(int expectedSize) {
        return g0.createWithExpectedSize(expectedSize);
    }

    public static <E> Set<E> g(int expectedSize) {
        return h0.createWithExpectedSize(expectedSize);
    }

    public static <E> Set<E> h() {
        return e0.create();
    }

    public static <K, V> Map<K, V> i() {
        return d0.create();
    }

    public static int j(int exponent) {
        return exponent;
    }

    public static int k(int iterations) {
        return iterations;
    }

    @b1.d
    public static r4 l(r4 mapMaker) {
        mapMaker.getClass();
        return mapMaker.j(s4.q.WEAK);
    }
}
