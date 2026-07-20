package f1;

import java.util.Comparator;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
public final class o6 {
    public static <E> Comparator<? super E> a(SortedSet<E> sortedSet) {
        Comparator<? super E> comparator = sortedSet.comparator();
        return comparator == null ? l5.natural() : comparator;
    }

    public static boolean b(Comparator<?> comparator, Iterable<?> elements) {
        Comparator comparator2;
        comparator.getClass();
        elements.getClass();
        if (elements instanceof SortedSet) {
            comparator2 = a((SortedSet) elements);
        } else {
            if (!(elements instanceof n6)) {
                return false;
            }
            comparator2 = ((n6) elements).comparator();
        }
        return comparator.equals(comparator2);
    }
}
