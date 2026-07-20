package fq;

import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public final class e<K, V> implements Serializable {
    public final K key;
    public final V value;

    public e(K k10, V v10) {
        this.key = k10;
        this.value = v10;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        K k10 = this.key;
        if (k10 == null) {
            if (eVar.key != null) {
                return false;
            }
        } else if (!k10.equals(eVar.key)) {
            return false;
        }
        V v10 = this.value;
        if (v10 == null) {
            if (eVar.value != null) {
                return false;
            }
        } else if (!v10.equals(eVar.value)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        K k10 = this.key;
        int iHashCode = k10 == null ? 0 : k10.hashCode();
        V v10 = this.value;
        return iHashCode ^ (v10 != null ? v10.hashCode() : 0);
    }

    public String toString() {
        return this.key + "=" + this.value;
    }
}
