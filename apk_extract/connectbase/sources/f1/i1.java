package f1;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
public final class i1<K, V> extends g1<K, V> implements o1<K, V> {
    public i1(j6<K, V> unfiltered, c1.i0<? super Map.Entry<K, V>> predicate) {
        super(unfiltered, predicate);
    }

    @Override // f1.g1, f1.m1
    public v4 a() {
        return (j6) this.f4886f;
    }

    @Override // f1.h, f1.v4
    public Collection entries() {
        return (Set) super.entries();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // f1.g1, f1.v4, f1.o4
    public Collection get(@m5 Object key) {
        return (Set) super.get(key);
    }

    @Override // f1.g1, f1.h
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public Set<Map.Entry<K, V>> createEntries() {
        return k6.i(((j6) this.f4886f).entries(), this.f4887g);
    }

    @Override // f1.g1, f1.v4, f1.o4
    public Collection removeAll(@gm.a Object key) {
        return (Set) super.removeAll(key);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // f1.h, f1.v4, f1.o4
    public Collection replaceValues(@m5 Object key, Iterable values) {
        return (Set) super.replaceValues(key, values);
    }

    @Override // f1.g1, f1.m1
    public j6<K, V> a() {
        return (j6) this.f4886f;
    }

    @Override // f1.h, f1.v4
    public Set<Map.Entry<K, V>> entries() {
        return (Set) super.entries();
    }

    @Override // f1.g1, f1.v4, f1.o4
    public Set<V> get(@m5 K key) {
        return (Set) super.get((Object) key);
    }

    @Override // f1.g1, f1.v4, f1.o4
    public Set<V> removeAll(@gm.a Object key) {
        return (Set) super.removeAll(key);
    }

    @Override // f1.h, f1.v4, f1.o4
    public Set<V> replaceValues(@m5 K key, Iterable<? extends V> values) {
        return (Set) super.replaceValues((Object) key, (Iterable) values);
    }
}
