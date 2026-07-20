package e1;

import f1.j2;
import f1.k3;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@i
public abstract class j<K, V> extends j2 implements c<K, V> {

    public static abstract class a<K, V> extends j<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c<K, V> f3943a;

        public a(c<K, V> delegate) {
            delegate.getClass();
            this.f3943a = delegate;
        }

        @Override // e1.j, f1.j2
        public final c<K, V> delegate() {
            return this.f3943a;
        }

        @Override // e1.j, f1.j2
        public Object delegate() {
            return this.f3943a;
        }
    }

    @Override // e1.c
    public ConcurrentMap<K, V> asMap() {
        return delegate().asMap();
    }

    @Override // e1.c
    public void cleanUp() {
        delegate().cleanUp();
    }

    @Override // f1.j2
    public abstract c<K, V> delegate();

    @Override // e1.c
    public V get(K key, Callable<? extends V> valueLoader) throws ExecutionException {
        return delegate().get(key, valueLoader);
    }

    @Override // e1.c
    public k3<K, V> getAllPresent(Iterable<? extends Object> keys) {
        return delegate().getAllPresent(keys);
    }

    @Override // e1.c
    @gm.a
    public V getIfPresent(Object key) {
        return delegate().getIfPresent(key);
    }

    @Override // e1.c
    public void invalidate(Object key) {
        delegate().invalidate(key);
    }

    @Override // e1.c
    public void invalidateAll(Iterable<? extends Object> keys) {
        delegate().invalidateAll(keys);
    }

    @Override // e1.c
    public void put(K key, V value) {
        delegate().put(key, value);
    }

    @Override // e1.c
    public void putAll(Map<? extends K, ? extends V> m10) {
        delegate().putAll(m10);
    }

    @Override // e1.c
    public long size() {
        return delegate().size();
    }

    @Override // e1.c
    public h stats() {
        return delegate().stats();
    }

    @Override // e1.c
    public void invalidateAll() {
        delegate().invalidateAll();
    }
}
