package f1;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true, serializable = true)
@x0
public final class w5<K, V> extends c3<K, V> {
    static final w5<Object, Object> EMPTY = new w5<>();

    @b1.e
    final transient Object[] alternatingKeysAndValues;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @gm.a
    public final transient Object f5543e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final transient int f5544f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final transient int f5545g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final transient w5<V, K> f5546i;

    /* JADX WARN: Multi-variable type inference failed */
    public w5() {
        this.f5543e = null;
        this.alternatingKeysAndValues = new Object[0];
        this.f5544f = 0;
        this.f5545g = 0;
        this.f5546i = this;
    }

    @Override // f1.k3
    public t3<Map.Entry<K, V>> createEntrySet() {
        return new y5.a(this, this.alternatingKeysAndValues, this.f5544f, this.f5545g);
    }

    @Override // f1.k3
    public t3<K> createKeySet() {
        return new y5.b(this, new y5.c(this.alternatingKeysAndValues, this.f5544f, this.f5545g));
    }

    @Override // f1.k3, java.util.Map
    @gm.a
    public V get(@gm.a Object obj) {
        V v10 = (V) y5.get(this.f5543e, this.alternatingKeysAndValues, this.f5545g, this.f5544f, obj);
        if (v10 == null) {
            return null;
        }
        return v10;
    }

    @Override // f1.k3
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.Map
    public int size() {
        return this.f5545g;
    }

    @Override // f1.c3, f1.w
    public c3<V, K> inverse() {
        return this.f5546i;
    }

    public w5(Object[] alternatingKeysAndValues, int size) {
        this.alternatingKeysAndValues = alternatingKeysAndValues;
        this.f5545g = size;
        this.f5544f = 0;
        int iChooseTableSize = size >= 2 ? t3.chooseTableSize(size) : 0;
        this.f5543e = y5.createHashTableOrThrow(alternatingKeysAndValues, size, iChooseTableSize, 0);
        this.f5546i = new w5<>(y5.createHashTableOrThrow(alternatingKeysAndValues, size, iChooseTableSize, 1), alternatingKeysAndValues, size, this);
    }

    public w5(@gm.a Object valueHashTable, Object[] alternatingKeysAndValues, int size, w5<V, K> inverse) {
        this.f5543e = valueHashTable;
        this.alternatingKeysAndValues = alternatingKeysAndValues;
        this.f5544f = 1;
        this.f5545g = size;
        this.f5546i = inverse;
    }
}
