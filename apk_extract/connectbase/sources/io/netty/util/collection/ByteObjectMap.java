package io.netty.util.collection;

import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface ByteObjectMap<V> extends Map<Byte, V> {

    public interface PrimitiveEntry<V> {
        byte key();

        void setValue(V v10);

        V value();
    }

    boolean containsKey(byte b10);

    Iterable<PrimitiveEntry<V>> entries();

    V get(byte b10);

    V put(byte b10, V v10);

    V remove(byte b10);
}
