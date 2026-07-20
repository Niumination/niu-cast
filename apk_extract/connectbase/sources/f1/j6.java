package f1;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
public interface j6<K, V> extends v4<K, V> {
    Map<K, Collection<V>> asMap();

    @Override // f1.v4
    Set<Map.Entry<K, V>> entries();

    @Override // f1.v4, f1.o4
    boolean equals(@gm.a Object obj);

    @Override // f1.v4, f1.o4
    Set<V> get(@m5 K key);

    @Override // f1.v4, f1.o4
    @t1.a
    Set<V> removeAll(@gm.a Object key);

    @Override // f1.v4, f1.o4
    @t1.a
    Set<V> replaceValues(@m5 K key, Iterable<? extends V> values);
}
