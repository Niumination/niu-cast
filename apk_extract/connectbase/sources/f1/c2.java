package f1;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
public abstract class c2<K, V> extends f2<K, V> implements o4<K, V> {
    @Override // f1.f2, f1.j2
    public abstract o4<K, V> delegate();

    @Override // f1.f2, f1.v4, f1.o4
    public List<V> get(@m5 K key) {
        return delegate().get((Object) key);
    }

    @Override // f1.f2, f1.v4, f1.o4
    @t1.a
    public List<V> removeAll(@gm.a Object key) {
        return delegate().removeAll(key);
    }

    @Override // f1.f2, f1.v4, f1.o4
    @t1.a
    public List<V> replaceValues(@m5 K key, Iterable<? extends V> values) {
        return delegate().replaceValues((Object) key, (Iterable) values);
    }
}
