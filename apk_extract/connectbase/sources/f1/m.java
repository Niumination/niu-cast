package f1;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
public abstract class m<K, V> extends e<K, V> implements j6<K, V> {
    private static final long serialVersionUID = 7431625294878419160L;

    public m(Map<K, Collection<V>> map) {
        super(map);
    }

    @Override // f1.h, f1.v4, f1.j6
    public Map<K, Collection<V>> asMap() {
        return super.asMap();
    }

    @Override // f1.e
    public abstract Set<V> createCollection();

    @Override // f1.h, f1.v4, f1.o4
    public boolean equals(@gm.a Object object) {
        return super.equals(object);
    }

    @Override // f1.e, f1.h, f1.v4
    @t1.a
    public boolean put(@m5 K key, @m5 V value) {
        return super.put(key, value);
    }

    @Override // f1.e
    public <E> Collection<E> unmodifiableCollectionSubclass(Collection<E> collection) {
        return Collections.unmodifiableSet((Set) collection);
    }

    @Override // f1.e
    public Collection<V> wrapCollection(@m5 K key, Collection<V> collection) {
        return new e.n(key, (Set) collection);
    }

    @Override // f1.e
    public Set<V> createUnmodifiableEmptyCollection() {
        return Collections.emptySet();
    }

    @Override // f1.e, f1.h, f1.v4
    public Set<Map.Entry<K, V>> entries() {
        return (Set) super.entries();
    }

    @Override // f1.e, f1.v4, f1.o4
    public Set<V> get(@m5 K key) {
        return (Set) super.get((Object) key);
    }

    @Override // f1.e, f1.v4, f1.o4
    @t1.a
    public Set<V> removeAll(@gm.a Object key) {
        return (Set) super.removeAll(key);
    }

    @Override // f1.e, f1.h, f1.v4, f1.o4
    @t1.a
    public Set<V> replaceValues(@m5 K key, Iterable<? extends V> values) {
        return (Set) super.replaceValues((Object) key, (Iterable) values);
    }
}
