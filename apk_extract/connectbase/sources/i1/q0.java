package i1;

import f1.x7;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@w
public class q0<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<K, V> f7616a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @gm.a
    public volatile transient Map.Entry<K, V> f7617b;

    public class a extends AbstractSet<K> {

        /* JADX INFO: renamed from: i1.q0$a$a, reason: collision with other inner class name */
        public class C0208a extends x7<K> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Iterator f7619a;

            public C0208a(final Iterator val$entryIterator) {
                this.f7619a = val$entryIterator;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f7619a.hasNext();
            }

            @Override // java.util.Iterator
            public K next() {
                Map.Entry<K, V> entry = (Map.Entry) this.f7619a.next();
                q0.this.f7617b = entry;
                return entry.getKey();
            }
        }

        public a() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public x7<K> iterator() {
            return new C0208a(q0.this.f7616a.entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@gm.a Object key) {
            return q0.this.e(key);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return q0.this.f7616a.size();
        }
    }

    public q0(Map<K, V> backingMap) {
        backingMap.getClass();
        this.f7616a = backingMap;
    }

    public final void c() {
        d();
        this.f7616a.clear();
    }

    public void d() {
        this.f7617b = null;
    }

    public final boolean e(@gm.a Object key) {
        return g(key) != null || this.f7616a.containsKey(key);
    }

    @gm.a
    public V f(Object key) {
        key.getClass();
        V vG = g(key);
        return vG == null ? h(key) : vG;
    }

    @gm.a
    public V g(@gm.a Object key) {
        Map.Entry<K, V> entry = this.f7617b;
        if (entry == null || entry.getKey() != key) {
            return null;
        }
        return entry.getValue();
    }

    @gm.a
    public final V h(Object key) {
        key.getClass();
        return this.f7616a.get(key);
    }

    @gm.a
    @t1.a
    public final V i(K key, V value) {
        key.getClass();
        value.getClass();
        d();
        return this.f7616a.put(key, value);
    }

    @gm.a
    @t1.a
    public final V j(Object key) {
        key.getClass();
        d();
        return this.f7616a.remove(key);
    }

    public final Set<K> k() {
        return new a();
    }
}
