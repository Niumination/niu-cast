package f1;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
public interface o4<K, V> extends v4<K, V> {
    @Override // f1.v4, f1.j6
    Map<K, Collection<V>> asMap();

    boolean equals(@gm.a Object obj);

    @Override // 
    List<V> get(@m5 K key);

    @Override // 
    @t1.a
    List<V> removeAll(@gm.a Object key);

    @Override // 
    @t1.a
    List<V> replaceValues(@m5 K key, Iterable<? extends V> values);
}
