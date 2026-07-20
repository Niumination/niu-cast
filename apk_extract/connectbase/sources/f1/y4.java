package f1;

import com.google.j2objc.annotations.Weak;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true)
@x0
public final class y4 {

    public static final class a<K, V> extends t4.r0<K, Collection<V>> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Weak
        public final v4<K, V> f5606d;

        /* JADX INFO: renamed from: f1.y4$a$a, reason: collision with other inner class name */
        public class C0131a extends t4.s<K, Collection<V>> {
            public C0131a() {
            }

            @Override // f1.t4.s
            public Map<K, Collection<V>> a() {
                return a.this;
            }

            public final /* synthetic */ Collection c(Object obj) {
                return a.this.f5606d.get(obj);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                return t4.m(a.this.f5606d.keySet(), new c1.t() { // from class: f1.x4
                    @Override // c1.t
                    public final Object apply(Object obj) {
                        return this.f5564a.c(obj);
                    }
                });
            }

            @Override // f1.t4.s, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(@gm.a Object o10) {
                if (!contains(o10)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) o10;
                Objects.requireNonNull(entry);
                a.this.h(entry.getKey());
                return true;
            }
        }

        public a(v4<K, V> multimap) {
            multimap.getClass();
            this.f5606d = multimap;
        }

        @Override // f1.t4.r0
        public Set<Map.Entry<K, Collection<V>>> a() {
            return new C0131a();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            this.f5606d.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@gm.a Object key) {
            return this.f5606d.containsKey(key);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @gm.a
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Collection<V> get(@gm.a Object key) {
            if (this.f5606d.containsKey(key)) {
                return this.f5606d.get(key);
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        @gm.a
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public Collection<V> remove(@gm.a Object key) {
            if (this.f5606d.containsKey(key)) {
                return this.f5606d.removeAll(key);
            }
            return null;
        }

        public void h(@gm.a Object key) {
            this.f5606d.keySet().remove(key);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return this.f5606d.isEmpty();
        }

        @Override // f1.t4.r0, java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: keySet */
        public Set<K> i() {
            return this.f5606d.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f5606d.keySet().size();
        }
    }

    public static class b<K, V> extends f1.d<K, V> {

        @b1.c
        @b1.d
        private static final long serialVersionUID = 0;
        transient c1.q0<? extends List<V>> factory;

        public b(Map<K, Collection<V>> map, c1.q0<? extends List<V>> factory) {
            super(map);
            factory.getClass();
            this.factory = factory;
        }

        @b1.c
        @b1.d
        private void readObject(ObjectInputStream stream) throws ClassNotFoundException, IOException {
            stream.defaultReadObject();
            Object object = stream.readObject();
            Objects.requireNonNull(object);
            this.factory = (c1.q0) object;
            Object object2 = stream.readObject();
            Objects.requireNonNull(object2);
            setMap((Map) object2);
        }

        @b1.c
        @b1.d
        private void writeObject(ObjectOutputStream stream) throws IOException {
            stream.defaultWriteObject();
            stream.writeObject(this.factory);
            stream.writeObject(backingMap());
        }

        @Override // f1.e, f1.h
        public Map<K, Collection<V>> createAsMap() {
            return createMaybeNavigableAsMap();
        }

        @Override // f1.e, f1.h
        public Set<K> createKeySet() {
            return createMaybeNavigableKeySet();
        }

        @Override // f1.d, f1.e
        public List<V> createCollection() {
            return this.factory.get();
        }
    }

    public static class c<K, V> extends f1.e<K, V> {

        @b1.c
        @b1.d
        private static final long serialVersionUID = 0;
        transient c1.q0<? extends Collection<V>> factory;

        public c(Map<K, Collection<V>> map, c1.q0<? extends Collection<V>> factory) {
            super(map);
            factory.getClass();
            this.factory = factory;
        }

        @b1.c
        @b1.d
        private void readObject(ObjectInputStream stream) throws ClassNotFoundException, IOException {
            stream.defaultReadObject();
            Object object = stream.readObject();
            Objects.requireNonNull(object);
            this.factory = (c1.q0) object;
            Object object2 = stream.readObject();
            Objects.requireNonNull(object2);
            setMap((Map) object2);
        }

        @b1.c
        @b1.d
        private void writeObject(ObjectOutputStream stream) throws IOException {
            stream.defaultWriteObject();
            stream.writeObject(this.factory);
            stream.writeObject(backingMap());
        }

        @Override // f1.e, f1.h
        public Map<K, Collection<V>> createAsMap() {
            return createMaybeNavigableAsMap();
        }

        @Override // f1.e
        public Collection<V> createCollection() {
            return this.factory.get();
        }

        @Override // f1.e, f1.h
        public Set<K> createKeySet() {
            return createMaybeNavigableKeySet();
        }

        @Override // f1.e
        public <E> Collection<E> unmodifiableCollectionSubclass(Collection<E> collection) {
            if (collection instanceof NavigableSet) {
                return k6.O((NavigableSet) collection);
            }
            if (collection instanceof SortedSet) {
                return Collections.unmodifiableSortedSet((SortedSet) collection);
            }
            if (collection instanceof Set) {
                return Collections.unmodifiableSet((Set) collection);
            }
            return collection instanceof List ? Collections.unmodifiableList((List) collection) : Collections.unmodifiableCollection(collection);
        }

        @Override // f1.e
        public Collection<V> wrapCollection(@m5 K key, Collection<V> collection) {
            if (collection instanceof List) {
                return wrapList(key, (List) collection, null);
            }
            if (collection instanceof NavigableSet) {
                return new f1.e.m(key, (NavigableSet) collection, null);
            }
            if (collection instanceof SortedSet) {
                return new f1.e.o(key, (SortedSet) collection, null);
            }
            return collection instanceof Set ? new f1.e.n(key, (Set) collection) : new f1.e.k(key, collection, null);
        }
    }

    public static class d<K, V> extends f1.m<K, V> {

        @b1.c
        @b1.d
        private static final long serialVersionUID = 0;
        transient c1.q0<? extends Set<V>> factory;

        public d(Map<K, Collection<V>> map, c1.q0<? extends Set<V>> factory) {
            super(map);
            factory.getClass();
            this.factory = factory;
        }

        @b1.c
        @b1.d
        private void readObject(ObjectInputStream stream) throws ClassNotFoundException, IOException {
            stream.defaultReadObject();
            Object object = stream.readObject();
            Objects.requireNonNull(object);
            this.factory = (c1.q0) object;
            Object object2 = stream.readObject();
            Objects.requireNonNull(object2);
            setMap((Map) object2);
        }

        @b1.c
        @b1.d
        private void writeObject(ObjectOutputStream stream) throws IOException {
            stream.defaultWriteObject();
            stream.writeObject(this.factory);
            stream.writeObject(backingMap());
        }

        @Override // f1.e, f1.h
        public Map<K, Collection<V>> createAsMap() {
            return createMaybeNavigableAsMap();
        }

        @Override // f1.e, f1.h
        public Set<K> createKeySet() {
            return createMaybeNavigableKeySet();
        }

        @Override // f1.m, f1.e
        public <E> Collection<E> unmodifiableCollectionSubclass(Collection<E> collection) {
            if (collection instanceof NavigableSet) {
                return k6.O((NavigableSet) collection);
            }
            return collection instanceof SortedSet ? Collections.unmodifiableSortedSet((SortedSet) collection) : Collections.unmodifiableSet((Set) collection);
        }

        @Override // f1.m, f1.e
        public Collection<V> wrapCollection(@m5 K key, Collection<V> collection) {
            if (collection instanceof NavigableSet) {
                return new f1.e.m(key, (NavigableSet) collection, null);
            }
            return collection instanceof SortedSet ? new f1.e.o(key, (SortedSet) collection, null) : new f1.e.n(key, (Set) collection);
        }

        @Override // f1.m, f1.e
        public Set<V> createCollection() {
            return this.factory.get();
        }
    }

    public static abstract class f<K, V> extends AbstractCollection<Map.Entry<K, V>> {
        public abstract v4<K, V> a();

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@gm.a Object o10) {
            if (!(o10 instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) o10;
            return a().containsEntry(entry.getKey(), entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(@gm.a Object o10) {
            if (!(o10 instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) o10;
            return a().remove(entry.getKey(), entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return a().size();
        }
    }

    public static class g<K, V> extends f1.i<K> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Weak
        public final v4<K, V> f5608c;

        public class a extends o7<Map.Entry<K, Collection<V>>, b5.a<K>> {

            /* JADX INFO: renamed from: f1.y4$g$a$a, reason: collision with other inner class name */
            public class C0132a extends c5.f<K> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ Map.Entry f5609a;

                public C0132a(final a this$1, final Map.Entry val$backingEntry) {
                    this.f5609a = val$backingEntry;
                }

                @Override // f1.b5.a
                public int getCount() {
                    return ((Collection) this.f5609a.getValue()).size();
                }

                @Override // f1.b5.a
                @m5
                public K getElement() {
                    return (K) this.f5609a.getKey();
                }
            }

            public a(final g this$0, Iterator backingIterator) {
                super(backingIterator);
            }

            @Override // f1.o7
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public b5.a<K> a(final Map.Entry<K, Collection<V>> backingEntry) {
                return new C0132a(this, backingEntry);
            }
        }

        public g(v4<K, V> multimap) {
            this.f5608c = multimap;
        }

        @Override // f1.i, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.f5608c.clear();
        }

        @Override // f1.i, java.util.AbstractCollection, java.util.Collection, f1.b5
        public boolean contains(@gm.a Object element) {
            return this.f5608c.containsKey(element);
        }

        @Override // f1.b5
        public int count(@gm.a Object element) {
            Collection collection = (Collection) t4.p0(this.f5608c.asMap(), element);
            if (collection == null) {
                return 0;
            }
            return collection.size();
        }

        @Override // f1.i
        public int distinctElements() {
            return this.f5608c.asMap().size();
        }

        @Override // f1.i
        public Iterator<K> elementIterator() {
            throw new AssertionError("should never be called");
        }

        @Override // f1.i, f1.b5, f1.r6, f1.s6
        public Set<K> elementSet() {
            return this.f5608c.keySet();
        }

        @Override // f1.i
        public Iterator<b5.a<K>> entryIterator() {
            return new a(this.f5608c.asMap().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, f1.b5
        public Iterator<K> iterator() {
            return new t4.e(this.f5608c.entries().iterator());
        }

        @Override // f1.i, f1.b5
        public int remove(@gm.a Object element, int occurrences) {
            b0.b(occurrences, "occurrences");
            if (occurrences == 0) {
                return count(element);
            }
            Collection collection = (Collection) t4.p0(this.f5608c.asMap(), element);
            if (collection == null) {
                return 0;
            }
            int size = collection.size();
            if (occurrences >= size) {
                collection.clear();
            } else {
                Iterator it = collection.iterator();
                for (int i10 = 0; i10 < occurrences; i10++) {
                    it.next();
                    it.remove();
                }
            }
            return size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, f1.b5
        public int size() {
            return this.f5608c.size();
        }
    }

    public static class h<K, V> extends f1.h<K, V> implements j6<K, V>, Serializable {
        private static final long serialVersionUID = 7845222491160860175L;
        final Map<K, V> map;

        public class a extends k6.k<V> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Object f5610a;

            /* JADX INFO: renamed from: f1.y4$h$a$a, reason: collision with other inner class name */
            public class C0133a implements Iterator<V> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public int f5612a;

                public C0133a() {
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    if (this.f5612a == 0) {
                        a aVar = a.this;
                        if (h.this.map.containsKey(aVar.f5610a)) {
                            return true;
                        }
                    }
                    return false;
                }

                @Override // java.util.Iterator
                @m5
                public V next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    this.f5612a++;
                    a aVar = a.this;
                    return h.this.map.get(aVar.f5610a);
                }

                @Override // java.util.Iterator
                public void remove() {
                    b0.e(this.f5612a == 1);
                    this.f5612a = -1;
                    a aVar = a.this;
                    h.this.map.remove(aVar.f5610a);
                }
            }

            public a(final Object val$key) {
                this.f5610a = val$key;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<V> iterator() {
                return new C0133a();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return h.this.map.containsKey(this.f5610a) ? 1 : 0;
            }
        }

        public h(Map<K, V> map) {
            map.getClass();
            this.map = map;
        }

        @Override // f1.v4
        public void clear() {
            this.map.clear();
        }

        @Override // f1.h, f1.v4
        public boolean containsEntry(@gm.a Object key, @gm.a Object value) {
            return this.map.entrySet().contains(new f3(key, value));
        }

        @Override // f1.v4
        public boolean containsKey(@gm.a Object key) {
            return this.map.containsKey(key);
        }

        @Override // f1.h, f1.v4
        public boolean containsValue(@gm.a Object value) {
            return this.map.containsValue(value);
        }

        @Override // f1.h
        public Map<K, Collection<V>> createAsMap() {
            return new a(this);
        }

        @Override // f1.h
        public Collection<Map.Entry<K, V>> createEntries() {
            throw new AssertionError("unreachable");
        }

        @Override // f1.h
        public Set<K> createKeySet() {
            return this.map.keySet();
        }

        @Override // f1.h
        public b5<K> createKeys() {
            return new g(this);
        }

        @Override // f1.h
        public Collection<V> createValues() {
            return this.map.values();
        }

        @Override // f1.h
        public Iterator<Map.Entry<K, V>> entryIterator() {
            return this.map.entrySet().iterator();
        }

        @Override // f1.h, f1.v4
        public int hashCode() {
            return this.map.hashCode();
        }

        @Override // f1.h, f1.v4
        public boolean put(@m5 K key, @m5 V value) {
            throw new UnsupportedOperationException();
        }

        @Override // f1.h, f1.v4
        public boolean putAll(@m5 K key, Iterable<? extends V> values) {
            throw new UnsupportedOperationException();
        }

        @Override // f1.h, f1.v4
        public boolean remove(@gm.a Object key, @gm.a Object value) {
            return this.map.entrySet().remove(new f3(key, value));
        }

        @Override // f1.v4
        public int size() {
            return this.map.size();
        }

        @Override // f1.h, f1.v4
        public Set<Map.Entry<K, V>> entries() {
            return this.map.entrySet();
        }

        @Override // f1.v4, f1.o4
        public Set<V> get(@m5 final K key) {
            return new a(key);
        }

        @Override // f1.h, f1.v4
        public boolean putAll(v4<? extends K, ? extends V> multimap) {
            throw new UnsupportedOperationException();
        }

        @Override // f1.v4, f1.o4
        public Set<V> removeAll(@gm.a Object key) {
            HashSet hashSet = new HashSet(2);
            if (!this.map.containsKey(key)) {
                return hashSet;
            }
            hashSet.add(this.map.remove(key));
            return hashSet;
        }

        @Override // f1.h, f1.v4, f1.o4
        public Set<V> replaceValues(@m5 K key, Iterable<? extends V> values) {
            throw new UnsupportedOperationException();
        }
    }

    public static final class i<K, V1, V2> extends j<K, V1, V2> implements o4<K, V2> {
        public i(o4<K, V1> fromMultimap, t4.t<? super K, ? super V1, V2> transformer) {
            super(fromMultimap, transformer);
        }

        @Override // f1.y4.j
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public List<V2> c(@m5 K key, Collection<V1> values) {
            return p4.D((List) values, t4.n(this.f5615g, key));
        }

        @Override // f1.y4.j, f1.h, f1.v4, f1.o4
        public Collection replaceValues(@m5 Object key, Iterable values) {
            throw new UnsupportedOperationException();
        }

        @Override // f1.y4.j, f1.v4, f1.o4
        public List<V2> get(@m5 K key) {
            return d(key, this.f5614f.get(key));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // f1.y4.j, f1.v4, f1.o4
        public List<V2> removeAll(@gm.a Object key) {
            return d(key, this.f5614f.removeAll(key));
        }

        @Override // f1.y4.j, f1.h, f1.v4, f1.o4
        public List<V2> replaceValues(@m5 K key, Iterable<? extends V2> values) {
            throw new UnsupportedOperationException();
        }
    }

    public static class j<K, V1, V2> extends f1.h<K, V2> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final v4<K, V1> f5614f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final t4.t<? super K, ? super V1, V2> f5615g;

        public j(v4<K, V1> fromMultimap, final t4.t<? super K, ? super V1, V2> transformer) {
            fromMultimap.getClass();
            this.f5614f = fromMultimap;
            transformer.getClass();
            this.f5615g = transformer;
        }

        @Override // f1.v4
        public void clear() {
            this.f5614f.clear();
        }

        @Override // f1.v4
        public boolean containsKey(@gm.a Object key) {
            return this.f5614f.containsKey(key);
        }

        @Override // f1.h
        public Map<K, Collection<V2>> createAsMap() {
            return new t4.i0(this.f5614f.asMap(), new t4.t() { // from class: f1.z4
                @Override // f1.t4.t
                public final Object a(Object obj, Object obj2) {
                    return this.f5645a.c(obj, (Collection) obj2);
                }
            });
        }

        @Override // f1.h
        public Collection<Map.Entry<K, V2>> createEntries() {
            return new f1.h.a();
        }

        @Override // f1.h
        public Set<K> createKeySet() {
            return this.f5614f.keySet();
        }

        @Override // f1.h
        public b5<K> createKeys() {
            return this.f5614f.keys();
        }

        @Override // f1.h
        public Collection<V2> createValues() {
            return new c0.f(this.f5614f.entries(), t4.h(this.f5615g));
        }

        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Collection<V2> c(@m5 K key, Collection<V1> values) {
            c1.t tVarN = t4.n(this.f5615g, key);
            return values instanceof List ? p4.D((List) values, tVarN) : new c0.f(values, tVarN);
        }

        @Override // f1.h
        public Iterator<Map.Entry<K, V2>> entryIterator() {
            return h4.c0(this.f5614f.entries().iterator(), t4.g(this.f5615g));
        }

        @Override // f1.v4, f1.o4
        public Collection<V2> get(@m5 final K key) {
            return c(key, this.f5614f.get(key));
        }

        @Override // f1.h, f1.v4
        public boolean isEmpty() {
            return this.f5614f.isEmpty();
        }

        @Override // f1.h, f1.v4
        public boolean put(@m5 K key, @m5 V2 value) {
            throw new UnsupportedOperationException();
        }

        @Override // f1.h, f1.v4
        public boolean putAll(@m5 K key, Iterable<? extends V2> values) {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // f1.h, f1.v4
        public boolean remove(@gm.a Object key, @gm.a Object value) {
            return get(key).remove(value);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // f1.v4, f1.o4
        public Collection<V2> removeAll(@gm.a Object key) {
            return c(key, this.f5614f.removeAll(key));
        }

        @Override // f1.h, f1.v4, f1.o4
        public Collection<V2> replaceValues(@m5 K key, Iterable<? extends V2> values) {
            throw new UnsupportedOperationException();
        }

        @Override // f1.v4
        public int size() {
            return this.f5614f.size();
        }

        @Override // f1.h, f1.v4
        public boolean putAll(v4<? extends K, ? extends V2> multimap) {
            throw new UnsupportedOperationException();
        }
    }

    public static class k<K, V> extends l<K, V> implements o4<K, V> {
        private static final long serialVersionUID = 0;

        public k(o4<K, V> delegate) {
            super(delegate);
        }

        @Override // f1.y4.l, f1.f2, f1.v4, f1.o4
        public List<V> get(@m5 K key) {
            return Collections.unmodifiableList(delegate().get((Object) key));
        }

        @Override // f1.y4.l, f1.f2, f1.v4, f1.o4
        public List<V> removeAll(@gm.a Object key) {
            throw new UnsupportedOperationException();
        }

        @Override // f1.y4.l, f1.f2, f1.v4, f1.o4
        public List<V> replaceValues(@m5 K key, Iterable<? extends V> values) {
            throw new UnsupportedOperationException();
        }

        @Override // f1.y4.l, f1.f2, f1.j2
        public o4<K, V> delegate() {
            return (o4) super.delegate();
        }
    }

    public static class l<K, V> extends f2<K, V> implements Serializable {
        private static final long serialVersionUID = 0;
        final v4<K, V> delegate;

        @u1.b
        @gm.a
        transient Collection<Map.Entry<K, V>> entries;

        @u1.b
        @gm.a
        transient Set<K> keySet;

        @u1.b
        @gm.a
        transient b5<K> keys;

        @u1.b
        @gm.a
        transient Map<K, Collection<V>> map;

        @u1.b
        @gm.a
        transient Collection<V> values;

        public l(final v4<K, V> delegate) {
            delegate.getClass();
            this.delegate = delegate;
        }

        @Override // f1.f2, f1.v4, f1.j6
        public Map<K, Collection<V>> asMap() {
            Map<K, Collection<V>> map = this.map;
            if (map != null) {
                return map;
            }
            Map<K, Collection<V>> mapUnmodifiableMap = Collections.unmodifiableMap(t4.B0(this.delegate.asMap(), new a5()));
            this.map = mapUnmodifiableMap;
            return mapUnmodifiableMap;
        }

        @Override // f1.f2, f1.v4
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // f1.f2, f1.v4
        public Collection<Map.Entry<K, V>> entries() {
            Collection<Map.Entry<K, V>> collection = this.entries;
            if (collection != null) {
                return collection;
            }
            Collection<Map.Entry<K, V>> collectionG = y4.G(this.delegate.entries());
            this.entries = collectionG;
            return collectionG;
        }

        @Override // f1.f2, f1.v4, f1.o4
        public Collection<V> get(@m5 K key) {
            return y4.O(this.delegate.get(key));
        }

        @Override // f1.f2, f1.v4
        public Set<K> keySet() {
            Set<K> set = this.keySet;
            if (set != null) {
                return set;
            }
            Set<K> setUnmodifiableSet = Collections.unmodifiableSet(this.delegate.keySet());
            this.keySet = setUnmodifiableSet;
            return setUnmodifiableSet;
        }

        @Override // f1.f2, f1.v4
        public b5<K> keys() {
            b5<K> b5Var = this.keys;
            if (b5Var != null) {
                return b5Var;
            }
            b5<K> b5VarA = c5.A(this.delegate.keys());
            this.keys = b5VarA;
            return b5VarA;
        }

        @Override // f1.f2, f1.v4
        public boolean put(@m5 K key, @m5 V value) {
            throw new UnsupportedOperationException();
        }

        @Override // f1.f2, f1.v4
        public boolean putAll(@m5 K key, Iterable<? extends V> values) {
            throw new UnsupportedOperationException();
        }

        @Override // f1.f2, f1.v4
        public boolean remove(@gm.a Object key, @gm.a Object value) {
            throw new UnsupportedOperationException();
        }

        @Override // f1.f2, f1.v4, f1.o4
        public Collection<V> removeAll(@gm.a Object key) {
            throw new UnsupportedOperationException();
        }

        @Override // f1.f2, f1.v4, f1.o4
        public Collection<V> replaceValues(@m5 K key, Iterable<? extends V> values) {
            throw new UnsupportedOperationException();
        }

        @Override // f1.f2, f1.v4
        public Collection<V> values() {
            Collection<V> collection = this.values;
            if (collection != null) {
                return collection;
            }
            Collection<V> collectionUnmodifiableCollection = Collections.unmodifiableCollection(this.delegate.values());
            this.values = collectionUnmodifiableCollection;
            return collectionUnmodifiableCollection;
        }

        @Override // f1.f2, f1.j2
        public v4<K, V> delegate() {
            return this.delegate;
        }

        @Override // f1.f2, f1.v4
        public boolean putAll(v4<? extends K, ? extends V> multimap) {
            throw new UnsupportedOperationException();
        }
    }

    public static class m<K, V> extends l<K, V> implements j6<K, V> {
        private static final long serialVersionUID = 0;

        public m(j6<K, V> delegate) {
            super(delegate);
        }

        @Override // f1.y4.l, f1.f2, f1.v4
        public Set<Map.Entry<K, V>> entries() {
            return t4.K0(delegate().entries());
        }

        @Override // f1.y4.l, f1.f2, f1.v4, f1.o4
        public Set<V> get(@m5 K key) {
            return Collections.unmodifiableSet(delegate().get((Object) key));
        }

        @Override // f1.y4.l, f1.f2, f1.v4, f1.o4
        public Set<V> removeAll(@gm.a Object key) {
            throw new UnsupportedOperationException();
        }

        @Override // f1.y4.l, f1.f2, f1.v4, f1.o4
        public Set<V> replaceValues(@m5 K key, Iterable<? extends V> values) {
            throw new UnsupportedOperationException();
        }

        @Override // f1.y4.l, f1.f2, f1.j2
        public j6<K, V> delegate() {
            return (j6) super.delegate();
        }
    }

    public static <K, V> j6<K, V> A(j6<K, V> multimap) {
        return y6.v(multimap, null);
    }

    public static <K, V> u6<K, V> B(u6<K, V> multimap) {
        return y6.y(multimap, null);
    }

    public static <K, V1, V2> o4<K, V2> C(o4<K, V1> fromMap, t4.t<? super K, ? super V1, V2> transformer) {
        return new i((v4) fromMap, (t4.t) transformer);
    }

    public static <K, V1, V2> v4<K, V2> D(v4<K, V1> fromMap, t4.t<? super K, ? super V1, V2> transformer) {
        return new j(fromMap, transformer);
    }

    public static <K, V1, V2> o4<K, V2> E(o4<K, V1> fromMultimap, final c1.t<? super V1, V2> function) {
        function.getClass();
        return new i((v4) fromMultimap, t4.i(function));
    }

    public static <K, V1, V2> v4<K, V2> F(v4<K, V1> fromMultimap, final c1.t<? super V1, V2> function) {
        function.getClass();
        return new j(fromMultimap, t4.i(function));
    }

    public static <K, V> Collection<Map.Entry<K, V>> G(Collection<Map.Entry<K, V>> entries) {
        return entries instanceof Set ? t4.K0((Set) entries) : new t4.m0(Collections.unmodifiableCollection(entries));
    }

    @Deprecated
    public static <K, V> o4<K, V> H(j3<K, V> delegate) {
        delegate.getClass();
        return delegate;
    }

    public static <K, V> o4<K, V> I(o4<K, V> delegate) {
        return ((delegate instanceof k) || (delegate instanceof j3)) ? delegate : new k(delegate);
    }

    @Deprecated
    public static <K, V> v4<K, V> J(o3<K, V> delegate) {
        delegate.getClass();
        return delegate;
    }

    public static <K, V> v4<K, V> K(v4<K, V> delegate) {
        return ((delegate instanceof l) || (delegate instanceof o3)) ? delegate : new l(delegate);
    }

    @Deprecated
    public static <K, V> j6<K, V> L(u3<K, V> delegate) {
        delegate.getClass();
        return delegate;
    }

    public static <K, V> j6<K, V> M(j6<K, V> delegate) {
        return ((delegate instanceof m) || (delegate instanceof u3)) ? delegate : new m(delegate);
    }

    public static <K, V> u6<K, V> N(u6<K, V> delegate) {
        return delegate instanceof n ? delegate : new n(delegate);
    }

    public static <V> Collection<V> O(Collection<V> collection) {
        if (collection instanceof SortedSet) {
            return Collections.unmodifiableSortedSet((SortedSet) collection);
        }
        if (collection instanceof Set) {
            return Collections.unmodifiableSet((Set) collection);
        }
        return collection instanceof List ? Collections.unmodifiableList((List) collection) : Collections.unmodifiableCollection(collection);
    }

    public static <K, V> Map<K, List<V>> c(o4<K, V> o4Var) {
        return o4Var.asMap();
    }

    public static <K, V> Map<K, Collection<V>> d(v4<K, V> multimap) {
        return multimap.asMap();
    }

    public static <K, V> Map<K, Set<V>> e(j6<K, V> j6Var) {
        return j6Var.asMap();
    }

    public static <K, V> Map<K, SortedSet<V>> f(u6<K, V> u6Var) {
        return u6Var.asMap();
    }

    public static boolean g(v4<?, ?> multimap, @gm.a Object object) {
        if (object == multimap) {
            return true;
        }
        if (object instanceof v4) {
            return multimap.asMap().equals(((v4) object).asMap());
        }
        return false;
    }

    public static <K, V> v4<K, V> h(v4<K, V> unfiltered, c1.i0<? super Map.Entry<K, V>> entryPredicate) {
        entryPredicate.getClass();
        if (unfiltered instanceof j6) {
            return i((j6) unfiltered, entryPredicate);
        }
        if (unfiltered instanceof m1) {
            return j((m1) unfiltered, entryPredicate);
        }
        unfiltered.getClass();
        return new g1(unfiltered, entryPredicate);
    }

    public static <K, V> j6<K, V> i(j6<K, V> unfiltered, c1.i0<? super Map.Entry<K, V>> entryPredicate) {
        entryPredicate.getClass();
        if (unfiltered instanceof o1) {
            return k((o1) unfiltered, entryPredicate);
        }
        unfiltered.getClass();
        return new i1((v4) unfiltered, (c1.i0) entryPredicate);
    }

    public static <K, V> v4<K, V> j(m1<K, V> multimap, c1.i0<? super Map.Entry<K, V>> entryPredicate) {
        return new g1(multimap.a(), c1.j0.d(multimap.f(), entryPredicate));
    }

    public static <K, V> j6<K, V> k(o1<K, V> multimap, c1.i0<? super Map.Entry<K, V>> entryPredicate) {
        return new i1((v4) multimap.a(), c1.j0.d(multimap.f(), entryPredicate));
    }

    public static <K, V> o4<K, V> l(o4<K, V> unfiltered, final c1.i0<? super K> keyPredicate) {
        if (!(unfiltered instanceof j1)) {
            return new j1((v4) unfiltered, (c1.i0) keyPredicate);
        }
        j1 j1Var = (j1) unfiltered;
        return new j1(j1Var.f5005f, c1.j0.d(j1Var.f5006g, keyPredicate));
    }

    public static <K, V> v4<K, V> m(v4<K, V> unfiltered, final c1.i0<? super K> keyPredicate) {
        if (unfiltered instanceof j6) {
            return n((j6) unfiltered, keyPredicate);
        }
        if (unfiltered instanceof o4) {
            return l((o4) unfiltered, keyPredicate);
        }
        if (!(unfiltered instanceof k1)) {
            return unfiltered instanceof m1 ? j((m1) unfiltered, c1.j0.h(keyPredicate, t4.r.KEY)) : new k1(unfiltered, keyPredicate);
        }
        k1 k1Var = (k1) unfiltered;
        return new k1(k1Var.f5005f, c1.j0.d(k1Var.f5006g, keyPredicate));
    }

    public static <K, V> j6<K, V> n(j6<K, V> unfiltered, final c1.i0<? super K> keyPredicate) {
        if (!(unfiltered instanceof l1)) {
            return unfiltered instanceof o1 ? k((o1) unfiltered, c1.j0.h(keyPredicate, t4.r.KEY)) : new l1((v4) unfiltered, (c1.i0) keyPredicate);
        }
        l1 l1Var = (l1) unfiltered;
        return new l1(l1Var.f5005f, c1.j0.d(l1Var.f5006g, keyPredicate));
    }

    public static <K, V> v4<K, V> o(v4<K, V> unfiltered, final c1.i0<? super V> valuePredicate) {
        return h(unfiltered, c1.j0.h(valuePredicate, t4.r.VALUE));
    }

    public static <K, V> j6<K, V> p(j6<K, V> unfiltered, final c1.i0<? super V> valuePredicate) {
        return i(unfiltered, c1.j0.h(valuePredicate, t4.r.VALUE));
    }

    public static <K, V> j6<K, V> q(Map<K, V> map) {
        return new h(map);
    }

    public static <K, V> j3<K, V> r(Iterable<V> values, c1.t<? super V, K> keyFunction) {
        return s(values.iterator(), keyFunction);
    }

    public static <K, V> j3<K, V> s(Iterator<V> values, c1.t<? super V, K> keyFunction) {
        keyFunction.getClass();
        j3.a aVarBuilder = j3.builder();
        while (values.hasNext()) {
            V next = values.next();
            c1.h0.F(next, values);
            aVarBuilder.p(keyFunction.apply(next), next);
        }
        return aVarBuilder.l();
    }

    @t1.a
    public static <K, V, M extends v4<K, V>> M t(v4<? extends V, ? extends K> source, M dest) {
        dest.getClass();
        for (Map.Entry<? extends V, ? extends K> entry : source.entries()) {
            dest.put(entry.getValue(), entry.getKey());
        }
        return dest;
    }

    public static <K, V> o4<K, V> u(Map<K, Collection<V>> map, final c1.q0<? extends List<V>> factory) {
        return new b(map, factory);
    }

    public static <K, V> v4<K, V> v(Map<K, Collection<V>> map, final c1.q0<? extends Collection<V>> factory) {
        return new c(map, factory);
    }

    public static <K, V> j6<K, V> w(Map<K, Collection<V>> map, final c1.q0<? extends Set<V>> factory) {
        return new d(map, factory);
    }

    public static <K, V> u6<K, V> x(Map<K, Collection<V>> map, final c1.q0<? extends SortedSet<V>> factory) {
        return new e(map, factory);
    }

    public static <K, V> o4<K, V> y(o4<K, V> multimap) {
        return y6.k(multimap, null);
    }

    public static <K, V> v4<K, V> z(v4<K, V> multimap) {
        return y6.m(multimap, null);
    }

    public static class e<K, V> extends p<K, V> {

        @b1.c
        @b1.d
        private static final long serialVersionUID = 0;
        transient c1.q0<? extends SortedSet<V>> factory;

        @gm.a
        transient Comparator<? super V> valueComparator;

        public e(Map<K, Collection<V>> map, c1.q0<? extends SortedSet<V>> factory) {
            super(map);
            factory.getClass();
            this.factory = factory;
            this.valueComparator = factory.get().comparator();
        }

        @b1.c
        @b1.d
        private void readObject(ObjectInputStream stream) throws ClassNotFoundException, IOException {
            stream.defaultReadObject();
            Object object = stream.readObject();
            Objects.requireNonNull(object);
            c1.q0<? extends SortedSet<V>> q0Var = (c1.q0) object;
            this.factory = q0Var;
            this.valueComparator = q0Var.get().comparator();
            Object object2 = stream.readObject();
            Objects.requireNonNull(object2);
            setMap((Map) object2);
        }

        @b1.c
        @b1.d
        private void writeObject(ObjectOutputStream stream) throws IOException {
            stream.defaultWriteObject();
            stream.writeObject(this.factory);
            stream.writeObject(backingMap());
        }

        @Override // f1.e, f1.h
        public Map<K, Collection<V>> createAsMap() {
            return createMaybeNavigableAsMap();
        }

        @Override // f1.e, f1.h
        public Set<K> createKeySet() {
            return createMaybeNavigableKeySet();
        }

        @Override // f1.u6
        @gm.a
        public Comparator<? super V> valueComparator() {
            return this.valueComparator;
        }

        @Override // f1.p, f1.m, f1.e
        public SortedSet<V> createCollection() {
            return this.factory.get();
        }
    }

    public static class n<K, V> extends m<K, V> implements u6<K, V> {
        private static final long serialVersionUID = 0;

        public n(u6<K, V> delegate) {
            super(delegate);
        }

        @Override // f1.u6
        @gm.a
        public Comparator<? super V> valueComparator() {
            return delegate().valueComparator();
        }

        @Override // f1.y4.m, f1.y4.l, f1.f2, f1.v4, f1.o4
        public SortedSet<V> get(@m5 K key) {
            return Collections.unmodifiableSortedSet(delegate().get((Object) key));
        }

        @Override // f1.y4.m, f1.y4.l, f1.f2, f1.v4, f1.o4
        public SortedSet<V> removeAll(@gm.a Object key) {
            throw new UnsupportedOperationException();
        }

        @Override // f1.y4.m, f1.y4.l, f1.f2, f1.v4, f1.o4
        public SortedSet<V> replaceValues(@m5 K key, Iterable<? extends V> values) {
            throw new UnsupportedOperationException();
        }

        @Override // f1.y4.m, f1.y4.l, f1.f2, f1.j2
        public u6<K, V> delegate() {
            return (u6) super.delegate();
        }
    }
}
