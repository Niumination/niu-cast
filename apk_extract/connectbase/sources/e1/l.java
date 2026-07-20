package e1;

import f1.k3;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@i
public interface l<K, V> extends c<K, V>, c1.t<K, V> {
    @Override // c1.t
    @Deprecated
    V apply(K key);

    @Override // e1.c
    ConcurrentMap<K, V> asMap();

    @t1.a
    V get(K key) throws ExecutionException;

    @t1.a
    k3<K, V> getAll(Iterable<? extends K> keys) throws ExecutionException;

    @t1.a
    V getUnchecked(K key);

    void refresh(K key);
}
