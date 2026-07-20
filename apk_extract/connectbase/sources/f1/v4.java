package f1;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
@t1.f("Use ImmutableMultimap, HashMultimap, or another implementation")
public interface v4<K, V> {
    Map<K, Collection<V>> asMap();

    void clear();

    boolean containsEntry(@gm.a @t1.c("K") Object key, @gm.a @t1.c("V") Object value);

    boolean containsKey(@gm.a @t1.c("K") Object key);

    boolean containsValue(@gm.a @t1.c("V") Object value);

    Collection<Map.Entry<K, V>> entries();

    boolean equals(@gm.a Object obj);

    Collection<V> get(@m5 K key);

    int hashCode();

    boolean isEmpty();

    Set<K> keySet();

    b5<K> keys();

    @t1.a
    boolean put(@m5 K key, @m5 V value);

    @t1.a
    boolean putAll(v4<? extends K, ? extends V> multimap);

    @t1.a
    boolean putAll(@m5 K key, Iterable<? extends V> values);

    @t1.a
    boolean remove(@gm.a @t1.c("K") Object key, @gm.a @t1.c("V") Object value);

    @t1.a
    Collection<V> removeAll(@gm.a @t1.c("K") Object key);

    @t1.a
    Collection<V> replaceValues(@m5 K key, Iterable<? extends V> values);

    int size();

    Collection<V> values();
}
