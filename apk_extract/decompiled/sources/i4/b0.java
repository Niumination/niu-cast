package i4;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public final class b0 extends e implements Serializable {
    private static final long serialVersionUID = 0;
    final Object key;
    final Object value;

    public b0(Object obj, Object obj2) {
        this.key = obj;
        this.value = obj2;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.key;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.value;
    }

    @Override // i4.e, java.util.Map.Entry
    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException();
    }
}
