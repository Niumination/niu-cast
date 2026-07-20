package f1;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
public abstract class g<K, V> implements Map.Entry<K, V> {
    @Override // java.util.Map.Entry
    public boolean equals(@gm.a Object object) {
        if (!(object instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) object;
        return c1.b0.a(getKey(), entry.getKey()) && c1.b0.a(getValue(), entry.getValue());
    }

    @Override // java.util.Map.Entry
    @m5
    public abstract K getKey();

    @Override // java.util.Map.Entry
    @m5
    public abstract V getValue();

    @Override // java.util.Map.Entry
    public int hashCode() {
        K key = getKey();
        V value = getValue();
        return (key == null ? 0 : key.hashCode()) ^ (value != null ? value.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    @m5
    public V setValue(@m5 V value) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return getKey() + "=" + getValue();
    }
}
