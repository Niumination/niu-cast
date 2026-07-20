package f1;

import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
public abstract class m2<K, V> extends f2<K, V> implements j6<K, V> {
    @Override // f1.f2, f1.j2
    public abstract j6<K, V> delegate();

    @Override // f1.f2, f1.v4
    public Set<Map.Entry<K, V>> entries() {
        return delegate().entries();
    }

    @Override // f1.f2, f1.v4, f1.o4
    public Set<V> get(@m5 K key) {
        return delegate().get((Object) key);
    }

    @Override // f1.f2, f1.v4, f1.o4
    @t1.a
    public Set<V> removeAll(@gm.a Object key) {
        return delegate().removeAll(key);
    }

    @Override // f1.f2, f1.v4, f1.o4
    @t1.a
    public Set<V> replaceValues(@m5 K key, Iterable<? extends V> values) {
        return delegate().replaceValues((Object) key, (Iterable) values);
    }
}
