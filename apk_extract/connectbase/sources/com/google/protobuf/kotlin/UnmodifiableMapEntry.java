package com.google.protobuf.kotlin;

import java.util.Map;
import kn.l0;
import ln.a;
import os.l;

/* JADX INFO: loaded from: classes.dex */
public final class UnmodifiableMapEntry<K, V> implements Map.Entry<K, V>, a {
    private final /* synthetic */ Map.Entry<K, V> $$delegate_0;

    /* JADX WARN: Multi-variable type inference failed */
    public UnmodifiableMapEntry(@l Map.Entry<? extends K, ? extends V> entry) {
        l0.p(entry, "delegate");
        this.$$delegate_0 = entry;
    }

    @Override // java.util.Map.Entry
    public K getKey() {
        return this.$$delegate_0.getKey();
    }

    @Override // java.util.Map.Entry
    public V getValue() {
        return this.$$delegate_0.getValue();
    }

    @Override // java.util.Map.Entry
    public V setValue(V v10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
