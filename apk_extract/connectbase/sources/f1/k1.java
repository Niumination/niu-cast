package f1;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
public class k1<K, V> extends h<K, V> implements m1<K, V> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final v4<K, V> f5005f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c1.i0<? super K> f5006g;

    public static class a<K, V> extends a2<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @m5
        public final K f5007a;

        public a(@m5 K key) {
            this.f5007a = key;
        }

        @Override // f1.s1, java.util.Collection, f1.b5
        public boolean add(@m5 V v10) {
            add(0, v10);
            return true;
        }

        @Override // f1.s1, java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            addAll(0, collection);
            return true;
        }

        @Override // f1.a2, f1.s1, f1.j2
        /* JADX INFO: renamed from: l */
        public List<V> delegate() {
            return Collections.emptyList();
        }

        @Override // f1.a2, java.util.List
        public void add(int index, @m5 V element) {
            c1.h0.d0(index, 0);
            throw new IllegalArgumentException("Key does not satisfy predicate: " + this.f5007a);
        }

        @Override // f1.a2, java.util.List
        @t1.a
        public boolean addAll(int index, Collection<? extends V> elements) {
            elements.getClass();
            c1.h0.d0(index, 0);
            throw new IllegalArgumentException("Key does not satisfy predicate: " + this.f5007a);
        }
    }

    public class c extends s1<Map.Entry<K, V>> {
        public c() {
        }

        @Override // f1.s1, java.util.Collection, java.util.Set
        public boolean remove(@gm.a Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (k1.this.f5005f.containsKey(entry.getKey()) && k1.this.f5006g.apply((Object) entry.getKey())) {
                return k1.this.f5005f.remove(entry.getKey(), entry.getValue());
            }
            return false;
        }

        @Override // f1.s1, f1.j2
        public Collection<Map.Entry<K, V>> delegate() {
            return c0.d(k1.this.f5005f.entries(), k1.this.f());
        }
    }

    public k1(v4<K, V> unfiltered, c1.i0<? super K> keyPredicate) {
        unfiltered.getClass();
        this.f5005f = unfiltered;
        keyPredicate.getClass();
        this.f5006g = keyPredicate;
    }

    public v4<K, V> a() {
        return this.f5005f;
    }

    public Collection<V> b() {
        return this.f5005f instanceof j6 ? Collections.emptySet() : Collections.emptyList();
    }

    @Override // f1.v4
    public void clear() {
        keySet().clear();
    }

    @Override // f1.v4
    public boolean containsKey(@gm.a Object key) {
        if (this.f5005f.containsKey(key)) {
            return this.f5006g.apply(key);
        }
        return false;
    }

    @Override // f1.h
    public Map<K, Collection<V>> createAsMap() {
        return t4.G(this.f5005f.asMap(), this.f5006g);
    }

    @Override // f1.h
    public Collection<Map.Entry<K, V>> createEntries() {
        return new c();
    }

    @Override // f1.h
    public Set<K> createKeySet() {
        return k6.i(this.f5005f.keySet(), this.f5006g);
    }

    @Override // f1.h
    public b5<K> createKeys() {
        return c5.j(this.f5005f.keys(), this.f5006g);
    }

    @Override // f1.h
    public Collection<V> createValues() {
        return new n1(this);
    }

    @Override // f1.h
    public Iterator<Map.Entry<K, V>> entryIterator() {
        throw new AssertionError("should never be called");
    }

    @Override // f1.m1
    public c1.i0<? super Map.Entry<K, V>> f() {
        return c1.j0.h(this.f5006g, t4.r.KEY);
    }

    @Override // f1.v4, f1.o4
    public Collection<V> get(@m5 K key) {
        if (this.f5006g.apply(key)) {
            return this.f5005f.get(key);
        }
        return this.f5005f instanceof j6 ? new b(key) : new a(key);
    }

    @Override // f1.v4, f1.o4
    public Collection<V> removeAll(@gm.a Object key) {
        return containsKey(key) ? this.f5005f.removeAll(key) : b();
    }

    @Override // f1.v4
    public int size() {
        Iterator<Collection<V>> it = asMap().values().iterator();
        int size = 0;
        while (it.hasNext()) {
            size += it.next().size();
        }
        return size;
    }

    public static class b<K, V> extends l2<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @m5
        public final K f5008a;

        public b(@m5 K key) {
            this.f5008a = key;
        }

        @Override // f1.s1, java.util.Collection, f1.b5
        public boolean add(@m5 V element) {
            throw new IllegalArgumentException("Key does not satisfy predicate: " + this.f5008a);
        }

        @Override // f1.s1, java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            collection.getClass();
            throw new IllegalArgumentException("Key does not satisfy predicate: " + this.f5008a);
        }

        @Override // f1.l2, f1.s1, f1.j2
        public Set<V> delegate() {
            return Collections.emptySet();
        }
    }
}
