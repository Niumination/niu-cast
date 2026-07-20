package f1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
public class g1<K, V> extends h<K, V> implements m1<K, V> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final v4<K, V> f4886f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c1.i0<? super Map.Entry<K, V>> f4887g;

    public class a extends t4.r0<K, Collection<V>> {

        /* JADX INFO: renamed from: f1.g1$a$a, reason: collision with other inner class name */
        public class C0112a extends t4.s<K, Collection<V>> {

            /* JADX INFO: renamed from: f1.g1$a$a$a, reason: collision with other inner class name */
            public class C0113a extends f1.c<Map.Entry<K, Collection<V>>> {

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                public final Iterator<Map.Entry<K, Collection<V>>> f4890c;

                public C0113a() {
                    this.f4890c = g1.this.f4886f.asMap().entrySet().iterator();
                }

                @Override // f1.c
                @gm.a
                /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
                public Map.Entry<K, Collection<V>> a() {
                    while (this.f4890c.hasNext()) {
                        Map.Entry<K, Collection<V>> next = this.f4890c.next();
                        K key = next.getKey();
                        Collection collectionC = g1.c(next.getValue(), new c(key));
                        if (!collectionC.isEmpty()) {
                            return new f3(key, collectionC);
                        }
                    }
                    this.f4711a = f1.c.b.DONE;
                    return null;
                }
            }

            public C0112a() {
            }

            @Override // f1.t4.s
            public Map<K, Collection<V>> a() {
                return a.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                return new C0113a();
            }

            @Override // f1.t4.s, f1.k6.k, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean removeAll(Collection<?> c10) {
                return g1.this.d(c1.j0.n(c10));
            }

            @Override // f1.t4.s, f1.k6.k, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> c10) {
                return g1.this.d(new c1.j0.i(c1.j0.n(c10)));
            }

            @Override // f1.t4.s, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return h4.Z(iterator());
            }
        }

        public class b extends t4.b0<K, Collection<V>> {
            public b() {
                super(a.this);
            }

            @Override // f1.t4.b0, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(@gm.a Object o10) {
                return a.this.remove(o10) != null;
            }

            @Override // f1.k6.k, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean removeAll(Collection<?> c10) {
                return g1.this.d(c1.j0.h(c1.j0.n(c10), t4.r.KEY));
            }

            @Override // f1.k6.k, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> c10) {
                return g1.this.d(c1.j0.h(new c1.j0.i(c1.j0.n(c10)), t4.r.KEY));
            }
        }

        public class c extends t4.q0<K, Collection<V>> {
            public c() {
                super(a.this);
            }

            @Override // f1.t4.q0, java.util.AbstractCollection, java.util.Collection
            public boolean remove(@gm.a Object o10) {
                if (!(o10 instanceof Collection)) {
                    return false;
                }
                Collection collection = (Collection) o10;
                Iterator<Map.Entry<K, Collection<V>>> it = g1.this.f4886f.asMap().entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<K, Collection<V>> next = it.next();
                    Collection collectionC = g1.c(next.getValue(), new c(next.getKey()));
                    if (!collectionC.isEmpty() && collection.equals(collectionC)) {
                        if (collectionC.size() == next.getValue().size()) {
                            it.remove();
                            return true;
                        }
                        collectionC.clear();
                        return true;
                    }
                }
                return false;
            }

            @Override // f1.t4.q0, java.util.AbstractCollection, java.util.Collection
            public boolean removeAll(Collection<?> c10) {
                return g1.this.d(c1.j0.h(c1.j0.n(c10), t4.r.VALUE));
            }

            @Override // f1.t4.q0, java.util.AbstractCollection, java.util.Collection
            public boolean retainAll(Collection<?> c10) {
                return g1.this.d(c1.j0.h(new c1.j0.i(c1.j0.n(c10)), t4.r.VALUE));
            }
        }

        public a() {
        }

        @Override // f1.t4.r0
        public Set<Map.Entry<K, Collection<V>>> a() {
            return new C0112a();
        }

        @Override // f1.t4.r0
        /* JADX INFO: renamed from: c */
        public Set<K> h() {
            return new b();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            g1.this.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@gm.a Object key) {
            return get(key) != null;
        }

        @Override // f1.t4.r0
        public Collection<Collection<V>> d() {
            return new c();
        }

        @Override // java.util.AbstractMap, java.util.Map
        @gm.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Collection<V> get(@gm.a Object key) {
            Collection<V> collection = g1.this.f4886f.asMap().get(key);
            if (collection == null) {
                return null;
            }
            Collection<V> collectionC = g1.c(collection, new c(key));
            if (collectionC.isEmpty()) {
                return null;
            }
            return collectionC;
        }

        @Override // java.util.AbstractMap, java.util.Map
        @gm.a
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Collection<V> remove(@gm.a Object key) {
            Collection<V> collection = g1.this.f4886f.asMap().get(key);
            if (collection == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            Iterator<V> it = collection.iterator();
            while (it.hasNext()) {
                V next = it.next();
                if (g1.this.e(key, next)) {
                    it.remove();
                    arrayList.add(next);
                }
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            return g1.this.f4886f instanceof j6 ? Collections.unmodifiableSet(k6.B(arrayList)) : Collections.unmodifiableList(arrayList);
        }
    }

    public class b extends y4.g<K, V> {

        public class a extends c5.i<K> {
            public a() {
            }

            public static boolean c(c1.i0 i0Var, Map.Entry entry) {
                return i0Var.apply(new c5.k(entry.getKey(), ((Collection) entry.getValue()).size()));
            }

            @Override // f1.c5.i
            public b5<K> a() {
                return b.this;
            }

            public final boolean e(final c1.i0<? super b5.a<K>> predicate) {
                return g1.this.d(new c1.i0() { // from class: f1.h1
                    @Override // c1.i0
                    public final boolean apply(Object obj) {
                        return g1.b.a.c(predicate, (Map.Entry) obj);
                    }
                });
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<b5.a<K>> iterator() {
                return b.this.entryIterator();
            }

            @Override // f1.k6.k, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean removeAll(Collection<?> c10) {
                return e(c1.j0.n(c10));
            }

            @Override // f1.k6.k, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> c10) {
                return e(new c1.j0.i(c1.j0.n(c10)));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return g1.this.keySet().size();
            }
        }

        public b() {
            super(g1.this);
        }

        @Override // f1.i, f1.b5
        public Set<b5.a<K>> entrySet() {
            return new a();
        }

        @Override // f1.y4.g, f1.i, f1.b5
        public int remove(@gm.a Object key, int occurrences) {
            b0.b(occurrences, "occurrences");
            if (occurrences == 0) {
                return count(key);
            }
            Collection<V> collection = g1.this.f4886f.asMap().get(key);
            int i10 = 0;
            if (collection == null) {
                return 0;
            }
            Iterator<V> it = collection.iterator();
            while (it.hasNext()) {
                if (g1.this.e(key, it.next()) && (i10 = i10 + 1) <= occurrences) {
                    it.remove();
                }
            }
            return i10;
        }
    }

    public final class c implements c1.i0<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @m5
        public final K f4896a;

        public c(K key) {
            this.f4896a = key;
        }

        @Override // c1.i0
        public boolean apply(@m5 V value) {
            return g1.this.e(this.f4896a, value);
        }
    }

    public g1(v4<K, V> unfiltered, c1.i0<? super Map.Entry<K, V>> predicate) {
        unfiltered.getClass();
        this.f4886f = unfiltered;
        predicate.getClass();
        this.f4887g = predicate;
    }

    public static <E> Collection<E> c(Collection<E> collection, c1.i0<? super E> predicate) {
        return collection instanceof Set ? k6.i((Set) collection, predicate) : c0.d(collection, predicate);
    }

    @Override // f1.m1
    public v4<K, V> a() {
        return this.f4886f;
    }

    @Override // f1.v4
    public void clear() {
        entries().clear();
    }

    @Override // f1.v4
    public boolean containsKey(@gm.a Object key) {
        return asMap().get(key) != null;
    }

    @Override // f1.h
    public Map<K, Collection<V>> createAsMap() {
        return new a();
    }

    @Override // f1.h
    public Collection<Map.Entry<K, V>> createEntries() {
        return c(this.f4886f.entries(), this.f4887g);
    }

    @Override // f1.h
    public Set<K> createKeySet() {
        return asMap().keySet();
    }

    @Override // f1.h
    public b5<K> createKeys() {
        return new b();
    }

    @Override // f1.h
    public Collection<V> createValues() {
        return new n1(this);
    }

    public boolean d(c1.i0<? super Map.Entry<K, Collection<V>>> predicate) {
        Iterator<Map.Entry<K, Collection<V>>> it = this.f4886f.asMap().entrySet().iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            Map.Entry<K, Collection<V>> next = it.next();
            K key = next.getKey();
            Collection collectionC = c(next.getValue(), new c(key));
            if (!collectionC.isEmpty() && predicate.apply(new f3(key, collectionC))) {
                if (collectionC.size() == next.getValue().size()) {
                    it.remove();
                } else {
                    collectionC.clear();
                }
                z10 = true;
            }
        }
        return z10;
    }

    public final boolean e(@m5 K key, @m5 V value) {
        return this.f4887g.apply(new f3(key, value));
    }

    @Override // f1.h
    public Iterator<Map.Entry<K, V>> entryIterator() {
        throw new AssertionError("should never be called");
    }

    @Override // f1.m1
    public c1.i0<? super Map.Entry<K, V>> f() {
        return this.f4887g;
    }

    public Collection<V> g() {
        return this.f4886f instanceof j6 ? Collections.emptySet() : Collections.emptyList();
    }

    @Override // f1.v4, f1.o4
    public Collection<V> get(@m5 K key) {
        return c(this.f4886f.get(key), new c(key));
    }

    @Override // f1.v4, f1.o4
    public Collection<V> removeAll(@gm.a Object key) {
        return (Collection) c1.z.a(asMap().remove(key), g());
    }

    @Override // f1.v4
    public int size() {
        return entries().size();
    }
}
