package f1;

import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
public abstract class t1<K, V> extends d2<K, V> implements ConcurrentMap<K, V> {
    @Override // f1.d2, f1.j2
    public abstract ConcurrentMap<K, V> delegate();

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @gm.a
    @t1.a
    public V putIfAbsent(K key, V value) {
        return delegate().putIfAbsent(key, value);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @t1.a
    public boolean remove(@gm.a Object key, @gm.a Object value) {
        return delegate().remove(key, value);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @gm.a
    @t1.a
    public V replace(K key, V value) {
        return delegate().replace(key, value);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @t1.a
    public boolean replace(K key, V oldValue, V newValue) {
        return delegate().replace(key, oldValue, newValue);
    }
}
