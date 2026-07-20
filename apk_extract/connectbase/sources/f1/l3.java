package f1;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true)
@x0
public abstract class l3<K, V> extends t3<Map.Entry<K, V>> {

    @b1.c
    @b1.d
    public static class a<K, V> implements Serializable {
        private static final long serialVersionUID = 0;
        final k3<K, V> map;

        public a(k3<K, V> map) {
            this.map = map;
        }

        public Object readResolve() {
            return this.map.entrySet();
        }
    }

    public static final class b<K, V> extends l3<K, V> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final transient k3<K, V> f5085e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final transient i3<Map.Entry<K, V>> f5086f;

        public b(k3<K, V> map, Map.Entry<K, V>[] entries) {
            this(map, i3.asImmutableList(entries));
        }

        @Override // f1.e3
        @b1.c("not used in GWT")
        public int copyIntoArray(Object[] dst, int offset) {
            return this.f5086f.copyIntoArray(dst, offset);
        }

        @Override // f1.t3
        public i3<Map.Entry<K, V>> createAsList() {
            return this.f5086f;
        }

        @Override // f1.l3
        public k3<K, V> map() {
            return this.f5085e;
        }

        public b(k3<K, V> map, i3<Map.Entry<K, V>> entries) {
            this.f5085e = map;
            this.f5086f = entries;
        }

        @Override // f1.t3, f1.e3, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, f1.n6
        public x7<Map.Entry<K, V>> iterator() {
            return this.f5086f.iterator();
        }
    }

    @b1.c
    @b1.d
    private void readObject(ObjectInputStream stream) throws InvalidObjectException {
        throw new InvalidObjectException("Use EntrySetSerializedForm");
    }

    @Override // f1.e3, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@gm.a Object object) {
        if (!(object instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) object;
        V v10 = map().get(entry.getKey());
        return v10 != null && v10.equals(entry.getValue());
    }

    @Override // f1.t3, java.util.Collection, java.util.Set
    public int hashCode() {
        return map().hashCode();
    }

    @Override // f1.t3
    @b1.c
    public boolean isHashCodeFast() {
        return map().isHashCodeFast();
    }

    @Override // f1.e3
    public boolean isPartialView() {
        return map().isPartialView();
    }

    public abstract k3<K, V> map();

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return map().size();
    }

    @Override // f1.t3, f1.e3
    @b1.c
    @b1.d
    public Object writeReplace() {
        return new a(map());
    }
}
