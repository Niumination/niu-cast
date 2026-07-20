package f1;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true)
@x0
public final class m3<K, V> extends d4<K> {
    private final k3<K, V> map;

    @b1.c
    @b1.d
    public static class a<K> implements Serializable {
        private static final long serialVersionUID = 0;
        final k3<K, ?> map;

        public a(k3<K, ?> map) {
            this.map = map;
        }

        public Object readResolve() {
            return this.map.keySet();
        }
    }

    public m3(k3<K, V> map) {
        this.map = map;
    }

    @Override // f1.e3, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@gm.a Object object) {
        return this.map.containsKey(object);
    }

    @Override // f1.d4
    public K get(int index) {
        return this.map.entrySet().asList().get(index).getKey();
    }

    @Override // f1.e3
    public boolean isPartialView() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.map.size();
    }

    @Override // f1.t3, f1.e3
    @b1.c
    public Object writeReplace() {
        return new a(this.map);
    }

    @Override // f1.d4, f1.t3, f1.e3, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, f1.n6
    public x7<K> iterator() {
        return this.map.keyIterator();
    }
}
