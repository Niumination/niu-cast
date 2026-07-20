package e1;

import f1.k3;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@i
public abstract class a<K, V> implements c<K, V> {

    /* JADX INFO: renamed from: e1.a$a, reason: collision with other inner class name */
    public static final class C0089a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final p f3858a = q.a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final p f3859b = q.a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final p f3860c = q.a();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final p f3861d = q.a();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final p f3862e = q.a();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final p f3863f = q.a();

        public static long h(long value) {
            if (value >= 0) {
                return value;
            }
            return Long.MAX_VALUE;
        }

        @Override // e1.a.b
        public void a(int count) {
            this.f3858a.add(count);
        }

        @Override // e1.a.b
        public void b(int count) {
            this.f3859b.add(count);
        }

        @Override // e1.a.b
        public void c() {
            this.f3863f.increment();
        }

        @Override // e1.a.b
        public void d(long loadTime) {
            this.f3861d.increment();
            this.f3862e.add(loadTime);
        }

        @Override // e1.a.b
        public void e(long loadTime) {
            this.f3860c.increment();
            this.f3862e.add(loadTime);
        }

        @Override // e1.a.b
        public h f() {
            return new h(h(this.f3858a.sum()), h(this.f3859b.sum()), h(this.f3860c.sum()), h(this.f3861d.sum()), h(this.f3862e.sum()), h(this.f3863f.sum()));
        }

        public void g(b other) {
            h hVarF = other.f();
            this.f3858a.add(hVarF.f3937a);
            this.f3859b.add(hVarF.f3938b);
            this.f3860c.add(hVarF.f3939c);
            this.f3861d.add(hVarF.f3940d);
            this.f3862e.add(hVarF.f3941e);
            this.f3863f.add(hVarF.f3942f);
        }
    }

    public interface b {
        void a(int count);

        void b(int count);

        void c();

        void d(long loadTime);

        void e(long loadTime);

        h f();
    }

    @Override // e1.c
    public ConcurrentMap<K, V> asMap() {
        throw new UnsupportedOperationException();
    }

    @Override // e1.c
    public void cleanUp() {
    }

    @Override // e1.c
    public V get(K key, Callable<? extends V> valueLoader) throws ExecutionException {
        throw new UnsupportedOperationException();
    }

    @Override // e1.c
    public k3<K, V> getAllPresent(Iterable<? extends Object> keys) {
        V ifPresent;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : keys) {
            if (!linkedHashMap.containsKey(obj) && (ifPresent = getIfPresent(obj)) != null) {
                linkedHashMap.put(obj, ifPresent);
            }
        }
        return k3.copyOf((Map) linkedHashMap);
    }

    @Override // e1.c
    public void invalidate(Object key) {
        throw new UnsupportedOperationException();
    }

    @Override // e1.c
    public void invalidateAll(Iterable<? extends Object> keys) {
        Iterator<? extends Object> it = keys.iterator();
        while (it.hasNext()) {
            invalidate(it.next());
        }
    }

    @Override // e1.c
    public void put(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override // e1.c
    public void putAll(Map<? extends K, ? extends V> m10) {
        for (Map.Entry<? extends K, ? extends V> entry : m10.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // e1.c
    public long size() {
        throw new UnsupportedOperationException();
    }

    @Override // e1.c
    public h stats() {
        throw new UnsupportedOperationException();
    }

    @Override // e1.c
    public void invalidateAll() {
        throw new UnsupportedOperationException();
    }
}
