package k3;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class q implements Map.Entry {
    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            if (ia.a(getKey(), entry.getKey()) && ia.a(getValue(), entry.getValue())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Object key = getKey();
        Object value = getValue();
        return (key == null ? 0 : key.hashCode()) ^ (value != null ? value.hashCode() : 0);
    }

    public final String toString() {
        return o.d.l(String.valueOf(getKey()), "=", String.valueOf(getValue()));
    }
}
