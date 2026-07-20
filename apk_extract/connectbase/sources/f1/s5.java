package f1;

import java.lang.Comparable;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@x0
@t1.f("Use ImmutableRangeMap or TreeRangeMap")
public interface s5<K extends Comparable, V> {
    Map<q5<K>, V> asDescendingMapOfRanges();

    Map<q5<K>, V> asMapOfRanges();

    void clear();

    boolean equals(@gm.a Object o10);

    @gm.a
    V get(K key);

    @gm.a
    Map.Entry<q5<K>, V> getEntry(K key);

    int hashCode();

    void put(q5<K> range, V value);

    void putAll(s5<K, ? extends V> rangeMap);

    void putCoalescing(q5<K> range, V value);

    void remove(q5<K> range);

    q5<K> span();

    s5<K, V> subRangeMap(q5<K> range);

    String toString();
}
