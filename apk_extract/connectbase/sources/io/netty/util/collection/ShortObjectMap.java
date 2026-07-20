package io.netty.util.collection;

import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface ShortObjectMap<V> extends Map<Short, V> {

    public interface PrimitiveEntry<V> {
        short key();

        void setValue(V v10);

        V value();
    }

    boolean containsKey(short s10);

    Iterable<PrimitiveEntry<V>> entries();

    V get(short s10);

    V put(short s10, V v10);

    V remove(short s10);
}
