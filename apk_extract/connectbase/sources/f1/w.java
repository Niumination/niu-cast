package f1;

import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
public interface w<K, V> extends Map<K, V> {
    @gm.a
    @t1.a
    V forcePut(@m5 K key, @m5 V value);

    w<V, K> inverse();

    @gm.a
    @t1.a
    V put(@m5 K key, @m5 V value);

    void putAll(Map<? extends K, ? extends V> map);

    @Override // f1.w
    Set<V> values();
}
