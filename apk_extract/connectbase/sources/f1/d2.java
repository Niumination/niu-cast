package f1;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
public abstract class d2<K, V> extends j2 implements Map<K, V> {

    public abstract class a extends t4.s<K, V> {
        public a() {
        }

        @Override // f1.t4.s
        public Map<K, V> a() {
            return d2.this;
        }
    }

    public class b extends t4.b0<K, V> {
        public b(final d2 this$0) {
            super(this$0);
        }
    }

    public class c extends t4.q0<K, V> {
        public c(final d2 this$0) {
            super(this$0);
        }
    }

    public void clear() {
        delegate().clear();
    }

    @Override // java.util.Map
    public boolean containsKey(@gm.a Object key) {
        return delegate().containsKey(key);
    }

    public boolean containsValue(@gm.a Object value) {
        return delegate().containsValue(value);
    }

    @Override // f1.j2
    public abstract Map<K, V> delegate();

    public Set<Map.Entry<K, V>> entrySet() {
        return delegate().entrySet();
    }

    @Override // java.util.Map
    public boolean equals(@gm.a Object object) {
        return object == this || delegate().equals(object);
    }

    @Override // java.util.Map
    @gm.a
    public V get(@gm.a Object key) {
        return delegate().get(key);
    }

    @Override // java.util.Map
    public int hashCode() {
        return delegate().hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return delegate().isEmpty();
    }

    public Set<K> keySet() {
        return delegate().keySet();
    }

    @gm.a
    @t1.a
    public V put(@m5 K key, @m5 V value) {
        return delegate().put(key, value);
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        delegate().putAll(map);
    }

    @gm.a
    @t1.a
    public V remove(@gm.a Object key) {
        return delegate().remove(key);
    }

    @Override // java.util.Map
    public int size() {
        return delegate().size();
    }

    public void standardClear() {
        h4.h(entrySet().iterator());
    }

    public boolean standardContainsKey(@gm.a Object key) {
        return t4.q(this, key);
    }

    public boolean standardContainsValue(@gm.a Object value) {
        return t4.r(this, value);
    }

    public boolean standardEquals(@gm.a Object object) {
        return t4.w(this, object);
    }

    public int standardHashCode() {
        return k6.k(entrySet());
    }

    public boolean standardIsEmpty() {
        return !entrySet().iterator().hasNext();
    }

    public void standardPutAll(Map<? extends K, ? extends V> map) {
        t4.j0(this, map);
    }

    @gm.a
    public V standardRemove(@gm.a Object key) {
        Iterator<Map.Entry<K, V>> it = entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (c1.b0.a(next.getKey(), key)) {
                V value = next.getValue();
                it.remove();
                return value;
            }
        }
        return null;
    }

    public String standardToString() {
        return t4.w0(this);
    }

    public Collection<V> values() {
        return delegate().values();
    }
}
