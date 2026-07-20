package io.netty.handler.codec.serialization;

import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
final class SoftReferenceMap<K, V> extends ReferenceMap<K, V> {
    public SoftReferenceMap(Map<K, Reference<V>> map) {
        super(map);
    }

    @Override // io.netty.handler.codec.serialization.ReferenceMap
    public Reference<V> fold(V v10) {
        return new SoftReference(v10);
    }
}
