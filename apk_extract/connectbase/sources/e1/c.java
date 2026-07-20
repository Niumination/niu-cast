package e1;

import f1.k3;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@t1.f("Use CacheBuilder.newBuilder().build()")
@i
public interface c<K, V> {
    ConcurrentMap<K, V> asMap();

    void cleanUp();

    @t1.a
    V get(K key, Callable<? extends V> loader) throws ExecutionException;

    k3<K, V> getAllPresent(Iterable<? extends Object> keys);

    @gm.a
    @t1.a
    V getIfPresent(@t1.c("K") Object key);

    void invalidate(@t1.c("K") Object key);

    void invalidateAll();

    void invalidateAll(Iterable<? extends Object> keys);

    void put(K key, V value);

    void putAll(Map<? extends K, ? extends V> m10);

    long size();

    h stats();
}
