package io.netty.util.collection;

import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface CharObjectMap<V> extends Map<Character, V> {

    public interface PrimitiveEntry<V> {
        char key();

        void setValue(V v10);

        V value();
    }

    boolean containsKey(char c10);

    Iterable<PrimitiveEntry<V>> entries();

    V get(char c10);

    V put(char c10, V v10);

    V remove(char c10);
}
