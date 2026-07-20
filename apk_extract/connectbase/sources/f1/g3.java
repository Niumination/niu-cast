package f1;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.Enum;
import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true, serializable = true)
@x0
public final class g3<K extends Enum<K>, V> extends k3.c<K, V> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final transient EnumMap<K, V> f4899e;

    @b1.d
    public static class b<K extends Enum<K>, V> implements Serializable {
        private static final long serialVersionUID = 0;
        final EnumMap<K, V> delegate;

        public b(EnumMap<K, V> delegate) {
            this.delegate = delegate;
        }

        public Object readResolve() {
            return new g3(this.delegate);
        }
    }

    public static <K extends Enum<K>, V> k3<K, V> asImmutable(EnumMap<K, V> map) {
        int size = map.size();
        if (size == 0) {
            return k3.of();
        }
        if (size != 1) {
            return new g3(map);
        }
        Map.Entry entry = (Map.Entry) g4.z(map.entrySet());
        return k3.of((Enum) entry.getKey(), entry.getValue());
    }

    @b1.d
    private void readObject(ObjectInputStream stream) throws InvalidObjectException {
        throw new InvalidObjectException("Use EnumSerializedForm");
    }

    @Override // f1.k3, java.util.Map
    public boolean containsKey(@gm.a Object key) {
        return this.f4899e.containsKey(key);
    }

    @Override // f1.k3.c
    public x7<Map.Entry<K, V>> entryIterator() {
        return new t4.l(this.f4899e.entrySet().iterator());
    }

    @Override // f1.k3, java.util.Map
    public boolean equals(@gm.a Object object) {
        if (object == this) {
            return true;
        }
        if (object instanceof g3) {
            object = ((g3) object).f4899e;
        }
        return this.f4899e.equals(object);
    }

    @Override // f1.k3, java.util.Map
    @gm.a
    public V get(@gm.a Object key) {
        return this.f4899e.get(key);
    }

    @Override // f1.k3
    public boolean isPartialView() {
        return false;
    }

    @Override // f1.k3
    public x7<K> keyIterator() {
        return h4.f0(this.f4899e.keySet().iterator());
    }

    @Override // java.util.Map
    public int size() {
        return this.f4899e.size();
    }

    @Override // f1.k3
    @b1.d
    public Object writeReplace() {
        return new b(this.f4899e);
    }

    public g3(EnumMap<K, V> delegate) {
        this.f4899e = delegate;
        c1.h0.d(!delegate.isEmpty());
    }
}
