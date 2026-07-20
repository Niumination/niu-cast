package io.netty.util.collection;

import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface LongObjectMap<V> extends Map<Long, V> {

    public interface PrimitiveEntry<V> {
        long key();

        void setValue(V v10);

        V value();
    }

    boolean containsKey(long j10);

    Iterable<PrimitiveEntry<V>> entries();

    V get(long j10);

    V put(long j10, V v10);

    V remove(long j10);
}
