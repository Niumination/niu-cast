package e1;

import java.util.AbstractMap;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@i
public final class z<K, V> extends AbstractMap.SimpleImmutableEntry<K, V> {
    private static final long serialVersionUID = 0;
    private final u cause;

    public z(@gm.a K key, @gm.a V value, u cause) {
        super(key, value);
        cause.getClass();
        this.cause = cause;
    }

    public static <K, V> z<K, V> create(@gm.a K key, @gm.a V value, u cause) {
        return new z<>(key, value, cause);
    }

    public u getCause() {
        return this.cause;
    }

    public boolean wasEvicted() {
        return this.cause.wasEvicted();
    }
}
