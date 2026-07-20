package f1;

import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
public final class j1<K, V> extends k1<K, V> implements o4<K, V> {
    public j1(o4<K, V> unfiltered, c1.i0<? super K> keyPredicate) {
        super(unfiltered, keyPredicate);
    }

    @Override // f1.k1, f1.m1
    public v4 a() {
        return (o4) this.f5005f;
    }

    public o4<K, V> c() {
        return (o4) this.f5005f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // f1.k1, f1.v4, f1.o4
    public Collection get(@m5 Object key) {
        return (List) super.get(key);
    }

    @Override // f1.k1, f1.v4, f1.o4
    public Collection removeAll(@gm.a Object key) {
        return (List) super.removeAll(key);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // f1.h, f1.v4, f1.o4
    public Collection replaceValues(@m5 Object key, Iterable values) {
        return (List) super.replaceValues(key, values);
    }

    @Override // f1.k1, f1.v4, f1.o4
    public List<V> get(@m5 K key) {
        return (List) super.get((Object) key);
    }

    @Override // f1.k1, f1.v4, f1.o4
    public List<V> removeAll(@gm.a Object key) {
        return (List) super.removeAll(key);
    }

    @Override // f1.h, f1.v4, f1.o4
    public List<V> replaceValues(@m5 K key, Iterable<? extends V> values) {
        return (List) super.replaceValues((Object) key, (Iterable) values);
    }
}
