package e1;

import f1.k3;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import q1.c3;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@i
public abstract class b<K, V> extends a<K, V> implements l<K, V> {
    @Override // e1.l, c1.t
    public final V apply(K key) {
        return getUnchecked(key);
    }

    @Override // e1.l
    public k3<K, V> getAll(Iterable<? extends K> keys) throws ExecutionException {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (K k10 : keys) {
            if (!linkedHashMap.containsKey(k10)) {
                linkedHashMap.put(k10, get(k10));
            }
        }
        return k3.copyOf((Map) linkedHashMap);
    }

    @Override // e1.l
    @t1.a
    public V getUnchecked(K key) {
        try {
            return get(key);
        } catch (ExecutionException e10) {
            throw new c3(e10.getCause());
        }
    }

    @Override // e1.l
    public void refresh(K key) {
        throw new UnsupportedOperationException();
    }
}
