package f1;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
public abstract class f2<K, V> extends j2 implements v4<K, V> {
    @Override // f1.v4, f1.j6
    public Map<K, Collection<V>> asMap() {
        return delegate().asMap();
    }

    @Override // f1.v4
    public void clear() {
        delegate().clear();
    }

    @Override // f1.v4
    public boolean containsEntry(@gm.a Object key, @gm.a Object value) {
        return delegate().containsEntry(key, value);
    }

    @Override // f1.v4
    public boolean containsKey(@gm.a Object key) {
        return delegate().containsKey(key);
    }

    @Override // f1.v4
    public boolean containsValue(@gm.a Object value) {
        return delegate().containsValue(value);
    }

    @Override // f1.j2
    public abstract v4<K, V> delegate();

    @Override // f1.v4
    public Collection<Map.Entry<K, V>> entries() {
        return delegate().entries();
    }

    @Override // f1.v4, f1.o4
    public boolean equals(@gm.a Object object) {
        return object == this || delegate().equals(object);
    }

    public Collection<V> get(@m5 K key) {
        return delegate().get(key);
    }

    @Override // f1.v4
    public int hashCode() {
        return delegate().hashCode();
    }

    @Override // f1.v4
    public boolean isEmpty() {
        return delegate().isEmpty();
    }

    @Override // f1.v4
    public Set<K> keySet() {
        return delegate().keySet();
    }

    @Override // f1.v4
    public b5<K> keys() {
        return delegate().keys();
    }

    @Override // f1.v4
    @t1.a
    public boolean put(@m5 K key, @m5 V value) {
        return delegate().put(key, value);
    }

    @Override // f1.v4
    @t1.a
    public boolean putAll(@m5 K key, Iterable<? extends V> values) {
        return delegate().putAll(key, values);
    }

    @Override // f1.v4
    @t1.a
    public boolean remove(@gm.a Object key, @gm.a Object value) {
        return delegate().remove(key, value);
    }

    @t1.a
    public Collection<V> removeAll(@gm.a Object key) {
        return delegate().removeAll(key);
    }

    @t1.a
    public Collection<V> replaceValues(@m5 K key, Iterable<? extends V> values) {
        return delegate().replaceValues(key, values);
    }

    @Override // f1.v4
    public int size() {
        return delegate().size();
    }

    @Override // f1.v4
    public Collection<V> values() {
        return delegate().values();
    }

    @Override // f1.v4
    @t1.a
    public boolean putAll(v4<? extends K, ? extends V> multimap) {
        return delegate().putAll(multimap);
    }
}
