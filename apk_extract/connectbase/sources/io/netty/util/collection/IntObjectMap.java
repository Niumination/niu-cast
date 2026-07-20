package io.netty.util.collection;

import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface IntObjectMap<V> extends Map<Integer, V> {

    public interface PrimitiveEntry<V> {
        int key();

        void setValue(V v10);

        V value();
    }

    boolean containsKey(int i10);

    Iterable<PrimitiveEntry<V>> entries();

    V get(int i10);

    V put(int i10, V v10);

    V remove(int i10);
}
