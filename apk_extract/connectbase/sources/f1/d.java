package f1;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
public abstract class d<K, V> extends e<K, V> implements o4<K, V> {
    private static final long serialVersionUID = 6588350623831699109L;

    public d(Map<K, Collection<V>> map) {
        super(map);
    }

    @Override // f1.h, f1.v4, f1.j6
    public Map<K, Collection<V>> asMap() {
        return super.asMap();
    }

    @Override // f1.e
    public abstract List<V> createCollection();

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
        return Collections.unmodifiableList((List) collection);
    }

    @Override // f1.e
    public Collection<V> wrapCollection(@m5 K key, Collection<V> collection) {
        return wrapList(key, (List) collection, null);
    }

    @Override // f1.e
    public List<V> createUnmodifiableEmptyCollection() {
        return Collections.emptyList();
    }

    @Override // f1.e, f1.v4, f1.o4
    public List<V> get(@m5 K key) {
        return (List) super.get((Object) key);
    }

    @Override // f1.e, f1.v4, f1.o4
    @t1.a
    public List<V> removeAll(@gm.a Object key) {
        return (List) super.removeAll(key);
    }

    @Override // f1.e, f1.h, f1.v4, f1.o4
    @t1.a
    public List<V> replaceValues(@m5 K key, Iterable<? extends V> values) {
        return (List) super.replaceValues((Object) key, (Iterable) values);
    }
}
