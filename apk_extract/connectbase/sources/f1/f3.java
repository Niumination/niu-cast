package f1;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
@b1.b(serializable = true)
@x0
public class f3<K, V> extends g<K, V> implements Serializable {
    private static final long serialVersionUID = 0;

    @m5
    final K key;

    @m5
    final V value;

    public f3(@m5 K key, @m5 V value) {
        this.key = key;
        this.value = value;
    }

    @Override // f1.g, java.util.Map.Entry
    @m5
    public final K getKey() {
        return this.key;
    }

    @Override // f1.g, java.util.Map.Entry
    @m5
    public final V getValue() {
        return this.value;
    }

    @Override // f1.g, java.util.Map.Entry
    @m5
    public final V setValue(@m5 V value) {
        throw new UnsupportedOperationException();
    }
}
