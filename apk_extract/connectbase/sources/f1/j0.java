package f1;

import java.util.Comparator;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
public final class j0 {
    public static <T> boolean a(Iterable<? extends T> iterable, Comparator<T> comparator) {
        comparator.getClass();
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return true;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (comparator.compare(next, next2) > 0) {
                return false;
            }
            next = next2;
        }
        return true;
    }

    public static <T> boolean b(Iterable<? extends T> iterable, Comparator<T> comparator) {
        comparator.getClass();
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return true;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (comparator.compare(next, next2) >= 0) {
                return false;
            }
            next = next2;
        }
        return true;
    }

    public static <T, S extends T> Comparator<Iterable<S>> c(Comparator<T> comparator) {
        comparator.getClass();
        return new j4(comparator);
    }

    public static <T extends Comparable<? super T>> T d(T a10, T b10) {
        return a10.compareTo(b10) >= 0 ? a10 : b10;
    }

    @m5
    public static <T> T e(@m5 T a10, @m5 T b10, Comparator<T> comparator) {
        return comparator.compare(a10, b10) >= 0 ? a10 : b10;
    }

    public static <T extends Comparable<? super T>> T f(T a10, T b10) {
        return a10.compareTo(b10) <= 0 ? a10 : b10;
    }

    @m5
    public static <T> T g(@m5 T a10, @m5 T b10, Comparator<T> comparator) {
        return comparator.compare(a10, b10) <= 0 ? a10 : b10;
    }
}
