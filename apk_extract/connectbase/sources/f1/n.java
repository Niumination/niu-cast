package f1;

import java.util.Collection;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
public abstract class n<K, V> extends p<K, V> {
    public n(SortedMap<K, Collection<V>> map) {
        super(map);
    }

    @Override // f1.e, f1.h
    public Set<K> createKeySet() {
        return createMaybeNavigableKeySet();
    }

    @Override // f1.p, f1.m, f1.h, f1.v4, f1.j6
    public SortedMap<K, Collection<V>> asMap() {
        return (SortedMap) super.asMap();
    }

    @Override // f1.e
    public SortedMap<K, Collection<V>> backingMap() {
        return (SortedMap) super.backingMap();
    }

    @Override // f1.h, f1.v4
    public SortedSet<K> keySet() {
        return (SortedSet) super.keySet();
    }
}
