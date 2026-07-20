package f1;

import com.google.j2objc.annotations.Weak;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true)
@x0
public abstract class o3<K, V> extends v<K, V> implements Serializable {

    @b1.d
    private static final long serialVersionUID = 0;
    final transient k3<K, ? extends e3<V>> map;
    final transient int size;

    public class a extends x7<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator<? extends Map.Entry<K, ? extends e3<V>>> f5161a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @gm.a
        public K f5162b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Iterator<V> f5163c = h4.l.f4958e;

        public a() {
            this.f5161a = o3.this.map.entrySet().iterator();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            if (!this.f5163c.hasNext()) {
                Map.Entry<K, ? extends e3<V>> next = this.f5161a.next();
                this.f5162b = next.getKey();
                this.f5163c = next.getValue().iterator();
            }
            K k10 = this.f5162b;
            Objects.requireNonNull(k10);
            return new f3(k10, this.f5163c.next());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f5163c.hasNext() || this.f5161a.hasNext();
        }
    }

    public class b extends x7<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Iterator<? extends e3<V>> f5165a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Iterator<V> f5166b = h4.l.f4958e;

        public b() {
            this.f5165a = o3.this.map.values().iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f5166b.hasNext() || this.f5165a.hasNext();
        }

        @Override // java.util.Iterator
        public V next() {
            if (!this.f5166b.hasNext()) {
                this.f5166b = this.f5165a.next().iterator();
            }
            return this.f5166b.next();
        }
    }

    @t1.f
    public static class c<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<K, Collection<V>> f5168a = d0.create();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @gm.a
        public Comparator<? super K> f5169b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @gm.a
        public Comparator<? super V> f5170c;

        public o3<K, V> a() {
            Collection collectionEntrySet = this.f5168a.entrySet();
            Comparator<? super K> comparator = this.f5169b;
            if (comparator != null) {
                collectionEntrySet = l5.from(comparator).onKeys().immutableSortedCopy(collectionEntrySet);
            }
            return j3.fromMapEntries(collectionEntrySet, this.f5170c);
        }

        @t1.a
        public c<K, V> b(c<K, V> other) {
            for (Map.Entry<K, Collection<V>> entry : other.f5168a.entrySet()) {
                j(entry.getKey(), entry.getValue());
            }
            return this;
        }

        public Collection<V> c() {
            return new ArrayList();
        }

        @t1.a
        public c<K, V> d(Comparator<? super K> keyComparator) {
            keyComparator.getClass();
            this.f5169b = keyComparator;
            return this;
        }

        @t1.a
        public c<K, V> e(Comparator<? super V> valueComparator) {
            valueComparator.getClass();
            this.f5170c = valueComparator;
            return this;
        }

        @t1.a
        public c<K, V> f(K key, V value) {
            b0.a(key, value);
            Collection<V> collection = this.f5168a.get(key);
            if (collection == null) {
                Map<K, Collection<V>> map = this.f5168a;
                Collection<V> collectionC = c();
                map.put(key, collectionC);
                collection = collectionC;
            }
            collection.add(value);
            return this;
        }

        @t1.a
        public c<K, V> g(Map.Entry<? extends K, ? extends V> entry) {
            return f(entry.getKey(), entry.getValue());
        }

        @t1.a
        public c<K, V> h(v4<? extends K, ? extends V> multimap) {
            for (Map.Entry<? extends K, Collection<? extends V>> entry : multimap.asMap().entrySet()) {
                j(entry.getKey(), entry.getValue());
            }
            return this;
        }

        @t1.a
        public c<K, V> i(Iterable<? extends Map.Entry<? extends K, ? extends V>> entries) {
            Iterator<? extends Map.Entry<? extends K, ? extends V>> it = entries.iterator();
            while (it.hasNext()) {
                g(it.next());
            }
            return this;
        }

        @t1.a
        public c<K, V> j(K key, Iterable<? extends V> values) {
            if (key == null) {
                throw new NullPointerException("null key in entry: null=" + g4.S(values));
            }
            Collection<V> collection = this.f5168a.get(key);
            if (collection != null) {
                for (V v10 : values) {
                    b0.a(key, v10);
                    collection.add(v10);
                }
                return this;
            }
            Iterator<? extends V> it = values.iterator();
            if (!it.hasNext()) {
                return this;
            }
            Collection<V> collectionC = c();
            while (it.hasNext()) {
                V next = it.next();
                b0.a(key, next);
                collectionC.add(next);
            }
            this.f5168a.put(key, collectionC);
            return this;
        }

        @t1.a
        public c<K, V> k(K key, V... values) {
            return j(key, Arrays.asList(values));
        }
    }

    public static class d<K, V> extends e3<Map.Entry<K, V>> {
        private static final long serialVersionUID = 0;

        @Weak
        final o3<K, V> multimap;

        public d(o3<K, V> multimap) {
            this.multimap = multimap;
        }

        @Override // f1.e3, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@gm.a Object object) {
            if (!(object instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) object;
            return this.multimap.containsEntry(entry.getKey(), entry.getValue());
        }

        @Override // f1.e3
        public boolean isPartialView() {
            return this.multimap.isPartialView();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.multimap.size();
        }

        @Override // f1.e3, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, f1.n6
        public x7<Map.Entry<K, V>> iterator() {
            return this.multimap.entryIterator();
        }
    }

    @b1.c
    @b1.d
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i6.b<o3> f5171a = i6.a(o3.class, "map");

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final i6.b<o3> f5172b = i6.a(o3.class, ik.f.b.f7973h);
    }

    public class f extends p3<K> {
        public f() {
        }

        @b1.c
        @b1.d
        private void readObject(ObjectInputStream stream) throws InvalidObjectException {
            throw new InvalidObjectException("Use KeysSerializedForm");
        }

        @Override // f1.p3, f1.e3, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@gm.a Object object) {
            return o3.this.containsKey(object);
        }

        @Override // f1.b5
        public int count(@gm.a Object element) {
            e3<V> e3Var = o3.this.map.get(element);
            if (e3Var == null) {
                return 0;
            }
            return e3Var.size();
        }

        @Override // f1.p3
        public b5.a<K> getEntry(int index) {
            Map.Entry<K, ? extends e3<V>> entry = o3.this.map.entrySet().asList().get(index);
            return c5.k(entry.getKey(), entry.getValue().size());
        }

        @Override // f1.e3
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, f1.b5
        public int size() {
            return o3.this.size();
        }

        @Override // f1.p3, f1.e3
        @b1.c
        @b1.d
        public Object writeReplace() {
            return new g(o3.this);
        }

        @Override // f1.p3, f1.b5, f1.r6, f1.s6
        public t3<K> elementSet() {
            return o3.this.keySet();
        }
    }

    @b1.c
    @b1.d
    public static final class g implements Serializable {
        final o3<?, ?> multimap;

        public g(o3<?, ?> multimap) {
            this.multimap = multimap;
        }

        public Object readResolve() {
            return this.multimap.keys();
        }
    }

    public static final class h<K, V> extends e3<V> {

        @b1.d
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Weak
        public final transient o3<K, V> f5173b;

        public h(o3<K, V> multimap) {
            this.f5173b = multimap;
        }

        @Override // f1.e3, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@gm.a Object object) {
            return this.f5173b.containsValue(object);
        }

        @Override // f1.e3
        @b1.c
        public int copyIntoArray(Object[] dst, int offset) {
            x7<? extends e3<V>> it = this.f5173b.map.values().iterator();
            while (it.hasNext()) {
                offset = it.next().copyIntoArray(dst, offset);
            }
            return offset;
        }

        @Override // f1.e3
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.f5173b.size();
        }

        @Override // f1.e3, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, f1.n6
        public x7<V> iterator() {
            return this.f5173b.valueIterator();
        }
    }

    public o3(k3<K, ? extends e3<V>> map, int size) {
        this.map = map;
        this.size = size;
    }

    public static <K, V> c<K, V> builder() {
        return new c<>();
    }

    public static <K, V> o3<K, V> copyOf(v4<? extends K, ? extends V> multimap) {
        if (multimap instanceof o3) {
            o3<K, V> o3Var = (o3) multimap;
            if (!o3Var.isPartialView()) {
                return o3Var;
            }
        }
        return j3.copyOf((v4) multimap);
    }

    public static <K, V> o3<K, V> of() {
        return j3.of();
    }

    @Override // f1.v4
    @t1.e("Always throws UnsupportedOperationException")
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // f1.h, f1.v4
    public /* bridge */ /* synthetic */ boolean containsEntry(@gm.a Object key, @gm.a Object value) {
        return super.containsEntry(key, value);
    }

    @Override // f1.v4
    public boolean containsKey(@gm.a Object key) {
        return this.map.containsKey(key);
    }

    @Override // f1.h, f1.v4
    public boolean containsValue(@gm.a Object value) {
        return value != null && super.containsValue(value);
    }

    @Override // f1.h
    public Map<K, Collection<V>> createAsMap() {
        throw new AssertionError("should never be called");
    }

    @Override // f1.h
    public Set<K> createKeySet() {
        throw new AssertionError("unreachable");
    }

    @Override // f1.h, f1.v4, f1.o4
    public /* bridge */ /* synthetic */ boolean equals(@gm.a Object object) {
        return super.equals(object);
    }

    @Override // f1.v4, f1.o4
    public abstract e3<V> get(K key);

    @Override // f1.h, f1.v4
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public abstract o3<V, K> inverse();

    @Override // f1.h, f1.v4
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    public boolean isPartialView() {
        return this.map.isPartialView();
    }

    @Override // f1.h, f1.v4
    @t1.a
    @Deprecated
    @t1.e("Always throws UnsupportedOperationException")
    public final boolean put(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override // f1.h, f1.v4
    @t1.a
    @Deprecated
    @t1.e("Always throws UnsupportedOperationException")
    public final boolean putAll(K key, Iterable<? extends V> values) {
        throw new UnsupportedOperationException();
    }

    @Override // f1.h, f1.v4
    @t1.a
    @t1.e("Always throws UnsupportedOperationException")
    @Deprecated
    public final boolean remove(@gm.a Object key, @gm.a Object value) {
        throw new UnsupportedOperationException();
    }

    @Override // f1.v4
    public int size() {
        return this.size;
    }

    @Override // f1.h
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public static <K, V> o3<K, V> of(K k10, V v10) {
        return j3.of((Object) k10, (Object) v10);
    }

    @Override // f1.h, f1.v4, f1.j6
    public k3<K, Collection<V>> asMap() {
        return this.map;
    }

    @Override // f1.h
    public e3<Map.Entry<K, V>> createEntries() {
        return new d(this);
    }

    @Override // f1.h
    public p3<K> createKeys() {
        return new f();
    }

    @Override // f1.h
    public e3<V> createValues() {
        return new h(this);
    }

    @Override // f1.h, f1.v4
    public e3<Map.Entry<K, V>> entries() {
        return (e3) super.entries();
    }

    @Override // f1.h
    public x7<Map.Entry<K, V>> entryIterator() {
        return new a();
    }

    @Override // f1.h, f1.v4
    public t3<K> keySet() {
        return this.map.keySet();
    }

    @Override // f1.h, f1.v4
    public p3<K> keys() {
        return (p3) super.keys();
    }

    @Override // f1.h, f1.v4
    @t1.a
    @Deprecated
    @t1.e("Always throws UnsupportedOperationException")
    public final boolean putAll(v4<? extends K, ? extends V> multimap) {
        throw new UnsupportedOperationException();
    }

    @Override // f1.v4, f1.o4
    @t1.a
    @Deprecated
    @t1.e("Always throws UnsupportedOperationException")
    public e3<V> removeAll(@gm.a Object key) {
        throw new UnsupportedOperationException();
    }

    @Override // f1.h, f1.v4, f1.o4
    @t1.a
    @Deprecated
    @t1.e("Always throws UnsupportedOperationException")
    public e3<V> replaceValues(K key, Iterable<? extends V> values) {
        throw new UnsupportedOperationException();
    }

    @Override // f1.h
    public x7<V> valueIterator() {
        return new b();
    }

    @Override // f1.h, f1.v4
    public e3<V> values() {
        return (e3) super.values();
    }

    public static <K, V> o3<K, V> of(K k10, V v10, K k11, V v11) {
        return j3.of((Object) k10, (Object) v10, (Object) k11, (Object) v11);
    }

    public static <K, V> o3<K, V> of(K k10, V v10, K k11, V v11, K k12, V v12) {
        return j3.of((Object) k10, (Object) v10, (Object) k11, (Object) v11, (Object) k12, (Object) v12);
    }

    public static <K, V> o3<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> entries) {
        return j3.copyOf((Iterable) entries);
    }

    public static <K, V> o3<K, V> of(K k10, V v10, K k11, V v11, K k12, V v12, K k13, V v13) {
        return j3.of((Object) k10, (Object) v10, (Object) k11, (Object) v11, (Object) k12, (Object) v12, (Object) k13, (Object) v13);
    }

    public static <K, V> o3<K, V> of(K k10, V v10, K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14) {
        return j3.of((Object) k10, (Object) v10, (Object) k11, (Object) v11, (Object) k12, (Object) v12, (Object) k13, (Object) v13, (Object) k14, (Object) v14);
    }
}
