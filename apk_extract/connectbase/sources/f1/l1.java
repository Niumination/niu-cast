package f1;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
public final class l1<K, V> extends k1<K, V> implements o1<K, V> {

    public class a extends k1<K, V>.c implements Set<Map.Entry<K, V>> {
        public a(final l1 this$0) {
            super();
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(@gm.a Object o10) {
            return k6.g(this, o10);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return k6.k(this);
        }
    }

    public l1(j6<K, V> unfiltered, c1.i0<? super K> keyPredicate) {
        super(unfiltered, keyPredicate);
    }

    @Override // f1.k1, f1.m1
    public v4 a() {
        return (j6) this.f5005f;
    }

    public Set<Map.Entry<K, V>> c() {
        return new a();
    }

    @Override // f1.k1, f1.h
    public Collection createEntries() {
        return new a();
    }

    @Override // f1.h, f1.v4
    public Collection entries() {
        return (Set) super.entries();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // f1.k1, f1.v4, f1.o4
    public Collection get(@m5 Object key) {
        return (Set) super.get(key);
    }

    @Override // f1.k1, f1.v4, f1.o4
    public Collection removeAll(@gm.a Object key) {
        return (Set) super.removeAll(key);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // f1.h, f1.v4, f1.o4
    public Collection replaceValues(@m5 Object key, Iterable values) {
        return (Set) super.replaceValues(key, values);
    }

    @Override // f1.k1, f1.m1
    public j6<K, V> a() {
        return (j6) this.f5005f;
    }

    @Override // f1.h, f1.v4
    public Set<Map.Entry<K, V>> entries() {
        return (Set) super.entries();
    }

    @Override // f1.k1, f1.v4, f1.o4
    public Set<V> get(@m5 K key) {
        return (Set) super.get((Object) key);
    }

    @Override // f1.k1, f1.v4, f1.o4
    public Set<V> removeAll(@gm.a Object key) {
        return (Set) super.removeAll(key);
    }

    @Override // f1.h, f1.v4, f1.o4
    public Set<V> replaceValues(@m5 K key, Iterable<? extends V> values) {
        return (Set) super.replaceValues((Object) key, (Iterable) values);
    }
}
