package f1;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
public interface u6<K, V> extends j6<K, V> {
    @Override // f1.j6
    Map<K, Collection<V>> asMap();

    @Override // f1.j6, f1.v4, f1.o4
    SortedSet<V> get(@m5 K key);

    @Override // f1.j6, f1.v4, f1.o4
    @t1.a
    SortedSet<V> removeAll(@gm.a Object key);

    @Override // f1.j6, f1.v4, f1.o4
    @t1.a
    SortedSet<V> replaceValues(@m5 K key, Iterable<? extends V> values);

    @gm.a
    Comparator<? super V> valueComparator();
}
