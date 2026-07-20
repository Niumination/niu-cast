package f1;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
public abstract class e2<K, V> extends j2 implements Map.Entry<K, V> {
    @Override // java.util.Map.Entry
    public boolean equals(@gm.a Object object) {
        return delegate().equals(object);
    }

    @Override // java.util.Map.Entry
    @m5
    public K getKey() {
        return delegate().getKey();
    }

    @Override // java.util.Map.Entry
    @m5
    public V getValue() {
        return delegate().getValue();
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        return delegate().hashCode();
    }

    @Override // f1.j2
    /* JADX INFO: renamed from: l */
    public abstract Map.Entry<K, V> delegate();

    @m5
    public V setValue(@m5 V value) {
        return delegate().setValue(value);
    }

    public boolean standardEquals(@gm.a Object object) {
        if (!(object instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) object;
        return c1.b0.a(getKey(), entry.getKey()) && c1.b0.a(getValue(), entry.getValue());
    }

    public int standardHashCode() {
        K key = getKey();
        V value = getValue();
        return (key == null ? 0 : key.hashCode()) ^ (value != null ? value.hashCode() : 0);
    }

    public String standardToString() {
        return getKey() + "=" + getValue();
    }
}
