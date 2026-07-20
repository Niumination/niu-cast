package k3;

import java.util.Comparator;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes.dex */
public abstract class n9 {
    public static boolean a(Comparator comparator, Iterable iterable) {
        Comparator<Object> comparator2;
        comparator.getClass();
        iterable.getClass();
        if (iterable instanceof SortedSet) {
            comparator2 = ((SortedSet) iterable).comparator();
            if (comparator2 == null) {
                comparator2 = i4.o4.natural();
            }
        } else {
            if (!(iterable instanceof i4.e5)) {
                return false;
            }
            comparator2 = ((i4.z1) ((i4.e5) iterable)).comparator();
        }
        return comparator.equals(comparator2);
    }
}
