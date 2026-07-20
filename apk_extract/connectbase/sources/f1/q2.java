package f1;

import java.util.Comparator;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
public abstract class q2<K, V> extends m2<K, V> implements u6<K, V> {
    @Override // f1.m2, f1.f2, f1.j2
    public abstract u6<K, V> delegate();

    @Override // f1.u6
    @gm.a
    public Comparator<? super V> valueComparator() {
        return delegate().valueComparator();
    }

    @Override // f1.m2, f1.f2, f1.v4, f1.o4
    public SortedSet<V> get(@m5 K key) {
        return delegate().get((Object) key);
    }

    @Override // f1.m2, f1.f2, f1.v4, f1.o4
    public SortedSet<V> removeAll(@gm.a Object key) {
        return delegate().removeAll(key);
    }

    @Override // f1.m2, f1.f2, f1.v4, f1.o4
    public SortedSet<V> replaceValues(@m5 K key, Iterable<? extends V> values) {
        return delegate().replaceValues((Object) key, (Iterable) values);
    }
}
