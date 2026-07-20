package f1;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.NavigableSet;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
public abstract class p<K, V> extends m<K, V> implements u6<K, V> {
    private static final long serialVersionUID = 430848587173315748L;

    public p(Map<K, Collection<V>> map) {
        super(map);
    }

    @Override // f1.m, f1.h, f1.v4, f1.j6
    public Map<K, Collection<V>> asMap() {
        return super.asMap();
    }

    @Override // f1.m, f1.e
    public abstract SortedSet<V> createCollection();

    @Override // f1.e, f1.h, f1.v4
    public Collection<V> values() {
        return super.values();
    }

    @Override // f1.m, f1.e
    public Collection<V> wrapCollection(@m5 K key, Collection<V> collection) {
        return collection instanceof NavigableSet ? new e.m(key, (NavigableSet) collection, null) : new e.o(key, (SortedSet) collection, null);
    }

    @Override // f1.m, f1.e
    public <E> SortedSet<E> unmodifiableCollectionSubclass(Collection<E> collection) {
        return collection instanceof NavigableSet ? k6.O((NavigableSet) collection) : Collections.unmodifiableSortedSet((SortedSet) collection);
    }

    @Override // f1.m, f1.e
    public SortedSet<V> createUnmodifiableEmptyCollection() {
        return (SortedSet<V>) unmodifiableCollectionSubclass((Collection) createCollection());
    }

    @Override // f1.m, f1.e, f1.v4, f1.o4
    public SortedSet<V> get(@m5 K key) {
        return (SortedSet) super.get((Object) key);
    }

    @Override // f1.m, f1.e, f1.v4, f1.o4
    @t1.a
    public SortedSet<V> removeAll(@gm.a Object key) {
        return (SortedSet) super.removeAll(key);
    }

    @Override // f1.m, f1.e, f1.h, f1.v4, f1.o4
    @t1.a
    public SortedSet<V> replaceValues(@m5 K key, Iterable<? extends V> values) {
        return (SortedSet) super.replaceValues((Object) key, (Iterable) values);
    }
}
