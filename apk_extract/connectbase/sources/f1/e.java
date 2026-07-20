package f1;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
public abstract class e<K, V> extends f1.h<K, V> implements Serializable {
    private static final long serialVersionUID = 2447537837011683357L;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public transient Map<K, Collection<V>> f4807f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public transient int f4808g;

    public class a extends e<K, V>.d<V> {
        public a(final e this$0) {
            super();
        }

        @Override // f1.e.d
        @m5
        public V a(@m5 K key, @m5 V value) {
            return value;
        }
    }

    public class b extends e<K, V>.d<Map.Entry<K, V>> {
        public b(final e this$0) {
            super();
        }

        @Override // f1.e.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> a(@m5 K key, @m5 V value) {
            return new f3(key, value);
        }
    }

    public class c extends t4.r0<K, Collection<V>> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final transient Map<K, Collection<V>> f4809d;

        public class a extends t4.s<K, Collection<V>> {
            public a() {
            }

            @Override // f1.t4.s
            public Map<K, Collection<V>> a() {
                return c.this;
            }

            @Override // f1.t4.s, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(@gm.a Object o10) {
                return c0.j(c.this.f4809d.entrySet(), o10);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                return c.this.new b();
            }

            @Override // f1.t4.s, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(@gm.a Object o10) {
                if (!contains(o10)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) o10;
                Objects.requireNonNull(entry);
                e.this.d(entry.getKey());
                return true;
            }
        }

        public class b implements Iterator<Map.Entry<K, Collection<V>>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Iterator<Map.Entry<K, Collection<V>>> f4812a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            @gm.a
            public Collection<V> f4813b;

            public b() {
                this.f4812a = c.this.f4809d.entrySet().iterator();
            }

            @Override // java.util.Iterator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map.Entry<K, Collection<V>> next() {
                Map.Entry<K, Collection<V>> next = this.f4812a.next();
                this.f4813b = next.getValue();
                return c.this.g(next);
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f4812a.hasNext();
            }

            @Override // java.util.Iterator
            public void remove() {
                c1.h0.h0(this.f4813b != null, "no calls to next() since the last call to remove()");
                this.f4812a.remove();
                e.access$220(e.this, this.f4813b.size());
                this.f4813b.clear();
                this.f4813b = null;
            }
        }

        public c(Map<K, Collection<V>> submap) {
            this.f4809d = submap;
        }

        @Override // f1.t4.r0
        public Set<Map.Entry<K, Collection<V>>> a() {
            return new a();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            if (this.f4809d == e.this.f4807f) {
                e.this.clear();
            } else {
                h4.h(new b());
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@gm.a Object key) {
            return t4.o0(this.f4809d, key);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @gm.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Collection<V> get(@gm.a Object key) {
            Collection<V> collection = (Collection) t4.p0(this.f4809d, key);
            if (collection == null) {
                return null;
            }
            return e.this.wrapCollection(key, collection);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean equals(@gm.a Object object) {
            return this == object || this.f4809d.equals(object);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @gm.a
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Collection<V> remove(@gm.a Object key) {
            Collection<V> collectionRemove = this.f4809d.remove(key);
            if (collectionRemove == null) {
                return null;
            }
            Collection<V> collectionCreateCollection = e.this.createCollection();
            collectionCreateCollection.addAll(collectionRemove);
            e.access$220(e.this, collectionRemove.size());
            collectionRemove.clear();
            return collectionCreateCollection;
        }

        public Map.Entry<K, Collection<V>> g(Map.Entry<K, Collection<V>> entry) {
            K key = entry.getKey();
            return new f3(key, e.this.wrapCollection(key, entry.getValue()));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int hashCode() {
            return this.f4809d.hashCode();
        }

        @Override // f1.t4.r0, java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: keySet */
        public Set<K> i() {
            return e.this.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f4809d.size();
        }

        @Override // java.util.AbstractMap
        public String toString() {
            return this.f4809d.toString();
        }
    }

    public abstract class d<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator<Map.Entry<K, Collection<V>>> f4815a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @gm.a
        public K f4816b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @gm.a
        public Collection<V> f4817c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Iterator<V> f4818d = h4.n.INSTANCE;

        public d() {
            this.f4815a = e.this.f4807f.entrySet().iterator();
        }

        public abstract T a(@m5 K key, @m5 V value);

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f4815a.hasNext() || this.f4818d.hasNext();
        }

        @Override // java.util.Iterator
        @m5
        public T next() {
            if (!this.f4818d.hasNext()) {
                Map.Entry<K, Collection<V>> next = this.f4815a.next();
                this.f4816b = next.getKey();
                Collection<V> value = next.getValue();
                this.f4817c = value;
                this.f4818d = value.iterator();
            }
            return a(this.f4816b, this.f4818d.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f4818d.remove();
            Collection<V> collection = this.f4817c;
            Objects.requireNonNull(collection);
            if (collection.isEmpty()) {
                this.f4815a.remove();
            }
            e.access$210(e.this);
        }
    }

    /* JADX INFO: renamed from: f1.e$e, reason: collision with other inner class name */
    public class C0111e extends t4.b0<K, Collection<V>> {

        /* JADX INFO: renamed from: f1.e$e$a */
        public class a implements Iterator<K> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @gm.a
            public Map.Entry<K, Collection<V>> f4821a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Iterator f4822b;

            public a(final Iterator val$entryIterator) {
                this.f4822b = val$entryIterator;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f4822b.hasNext();
            }

            @Override // java.util.Iterator
            @m5
            public K next() {
                Map.Entry<K, Collection<V>> entry = (Map.Entry) this.f4822b.next();
                this.f4821a = entry;
                return entry.getKey();
            }

            @Override // java.util.Iterator
            public void remove() {
                c1.h0.h0(this.f4821a != null, "no calls to next() since the last call to remove()");
                Collection<V> value = this.f4821a.getValue();
                this.f4822b.remove();
                e.access$220(e.this, value.size());
                value.clear();
                this.f4821a = null;
            }
        }

        public C0111e(final Map<K, Collection<V>> subMap) {
            super(subMap);
        }

        @Override // f1.t4.b0, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            h4.h(iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> c10) {
            return b().keySet().containsAll(c10);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public boolean equals(@gm.a Object object) {
            return this == object || b().keySet().equals(object);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return b().keySet().hashCode();
        }

        @Override // f1.t4.b0, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new a(b().entrySet().iterator());
        }

        @Override // f1.t4.b0, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@gm.a Object key) {
            int size;
            Collection<V> collectionRemove = b().remove(key);
            if (collectionRemove != null) {
                size = collectionRemove.size();
                collectionRemove.clear();
                e.access$220(e.this, size);
            } else {
                size = 0;
            }
            return size > 0;
        }
    }

    public class f extends e<K, V>.i implements NavigableMap<K, Collection<V>> {
        public f(NavigableMap<K, Collection<V>> submap) {
            super(submap);
        }

        @Override // java.util.NavigableMap
        @gm.a
        public Map.Entry<K, Collection<V>> ceilingEntry(@m5 K key) {
            Map.Entry<K, Collection<V>> entryCeilingEntry = j().ceilingEntry(key);
            if (entryCeilingEntry == null) {
                return null;
            }
            return g(entryCeilingEntry);
        }

        @Override // java.util.NavigableMap
        @gm.a
        public K ceilingKey(@m5 K key) {
            return j().ceilingKey(key);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            return descendingMap().navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> descendingMap() {
            return new f(j().descendingMap());
        }

        @Override // java.util.NavigableMap
        @gm.a
        public Map.Entry<K, Collection<V>> firstEntry() {
            Map.Entry<K, Collection<V>> entryFirstEntry = j().firstEntry();
            if (entryFirstEntry == null) {
                return null;
            }
            return g(entryFirstEntry);
        }

        @Override // java.util.NavigableMap
        @gm.a
        public Map.Entry<K, Collection<V>> floorEntry(@m5 K key) {
            Map.Entry<K, Collection<V>> entryFloorEntry = j().floorEntry(key);
            if (entryFloorEntry == null) {
                return null;
            }
            return g(entryFloorEntry);
        }

        @Override // java.util.NavigableMap
        @gm.a
        public K floorKey(@m5 K key) {
            return j().floorKey(key);
        }

        @Override // java.util.NavigableMap
        @gm.a
        public Map.Entry<K, Collection<V>> higherEntry(@m5 K key) {
            Map.Entry<K, Collection<V>> entryHigherEntry = j().higherEntry(key);
            if (entryHigherEntry == null) {
                return null;
            }
            return g(entryHigherEntry);
        }

        @Override // java.util.NavigableMap
        @gm.a
        public K higherKey(@m5 K key) {
            return j().higherKey(key);
        }

        @Override // f1.e.i
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public NavigableSet<K> h() {
            return new g(j());
        }

        @Override // java.util.NavigableMap
        @gm.a
        public Map.Entry<K, Collection<V>> lastEntry() {
            Map.Entry<K, Collection<V>> entryLastEntry = j().lastEntry();
            if (entryLastEntry == null) {
                return null;
            }
            return g(entryLastEntry);
        }

        @Override // java.util.NavigableMap
        @gm.a
        public Map.Entry<K, Collection<V>> lowerEntry(@m5 K key) {
            Map.Entry<K, Collection<V>> entryLowerEntry = j().lowerEntry(key);
            if (entryLowerEntry == null) {
                return null;
            }
            return g(entryLowerEntry);
        }

        @Override // java.util.NavigableMap
        @gm.a
        public K lowerKey(@m5 K key) {
            return j().lowerKey(key);
        }

        @Override // f1.e.i, java.util.SortedMap, java.util.NavigableMap
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public NavigableMap<K, Collection<V>> headMap(@m5 K toKey) {
            return headMap(toKey, false);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            return i();
        }

        @gm.a
        public Map.Entry<K, Collection<V>> p(Iterator<Map.Entry<K, Collection<V>>> entryIterator) {
            if (!entryIterator.hasNext()) {
                return null;
            }
            Map.Entry<K, Collection<V>> next = entryIterator.next();
            Collection<V> collectionCreateCollection = e.this.createCollection();
            collectionCreateCollection.addAll(next.getValue());
            entryIterator.remove();
            return new f3(next.getKey(), e.this.unmodifiableCollectionSubclass(collectionCreateCollection));
        }

        @Override // java.util.NavigableMap
        @gm.a
        public Map.Entry<K, Collection<V>> pollFirstEntry() {
            return p(entrySet().iterator());
        }

        @Override // java.util.NavigableMap
        @gm.a
        public Map.Entry<K, Collection<V>> pollLastEntry() {
            return p(descendingMap().entrySet().iterator());
        }

        @Override // f1.e.i
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public NavigableMap<K, Collection<V>> j() {
            return (NavigableMap) ((SortedMap) this.f4809d);
        }

        @Override // f1.e.i, java.util.SortedMap, java.util.NavigableMap
        /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
        public NavigableMap<K, Collection<V>> subMap(@m5 K fromKey, @m5 K toKey) {
            return subMap(fromKey, true, toKey, false);
        }

        @Override // f1.e.i, java.util.SortedMap, java.util.NavigableMap
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public NavigableMap<K, Collection<V>> tailMap(@m5 K fromKey) {
            return tailMap(fromKey, true);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> headMap(@m5 K toKey, boolean inclusive) {
            return new f(j().headMap(toKey, inclusive));
        }

        @Override // f1.e.i, f1.e.c, f1.t4.r0, java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: keySet, reason: merged with bridge method [inline-methods] */
        public NavigableSet<K> i() {
            return (NavigableSet) super.i();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> subMap(@m5 K fromKey, boolean fromInclusive, @m5 K toKey, boolean toInclusive) {
            return new f(j().subMap(fromKey, fromInclusive, toKey, toInclusive));
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> tailMap(@m5 K fromKey, boolean inclusive) {
            return new f(j().tailMap(fromKey, inclusive));
        }
    }

    public class g extends e<K, V>.j implements NavigableSet<K> {
        public g(NavigableMap<K, Collection<V>> subMap) {
            super(subMap);
        }

        @Override // f1.e.j, java.util.SortedSet, java.util.NavigableSet
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public NavigableSet<K> headSet(@m5 K toElement) {
            return headSet(toElement, false);
        }

        @Override // java.util.NavigableSet
        @gm.a
        public K ceiling(@m5 K k10) {
            return b().ceilingKey(k10);
        }

        @Override // java.util.NavigableSet
        public Iterator<K> descendingIterator() {
            return descendingSet().iterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> descendingSet() {
            return new g(b().descendingMap());
        }

        @Override // f1.e.j
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public NavigableMap<K, Collection<V>> b() {
            return (NavigableMap) ((SortedMap) this.f5299a);
        }

        @Override // f1.e.j, java.util.SortedSet, java.util.NavigableSet
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public NavigableSet<K> subSet(@m5 K fromElement, @m5 K toElement) {
            return subSet(fromElement, true, toElement, false);
        }

        @Override // java.util.NavigableSet
        @gm.a
        public K floor(@m5 K k10) {
            return b().floorKey(k10);
        }

        @Override // f1.e.j, java.util.SortedSet, java.util.NavigableSet
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public NavigableSet<K> tailSet(@m5 K fromElement) {
            return tailSet(fromElement, true);
        }

        @Override // java.util.NavigableSet
        @gm.a
        public K higher(@m5 K k10) {
            return b().higherKey(k10);
        }

        @Override // java.util.NavigableSet
        @gm.a
        public K lower(@m5 K k10) {
            return b().lowerKey(k10);
        }

        @Override // java.util.NavigableSet
        @gm.a
        public K pollFirst() {
            return (K) h4.U(iterator());
        }

        @Override // java.util.NavigableSet
        @gm.a
        public K pollLast() {
            return (K) h4.U(descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> headSet(@m5 K toElement, boolean inclusive) {
            return new g(b().headMap(toElement, inclusive));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> subSet(@m5 K fromElement, boolean fromInclusive, @m5 K toElement, boolean toInclusive) {
            return new g(b().subMap(fromElement, fromInclusive, toElement, toInclusive));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> tailSet(@m5 K fromElement, boolean inclusive) {
            return new g(b().tailMap(fromElement, inclusive));
        }
    }

    public class h extends e<K, V>.l implements RandomAccess {
        public h(@m5 final e this$0, K key, @gm.a List<V> delegate, e<K, V>.k ancestor) {
            super(key, delegate, ancestor);
        }
    }

    public class i extends e<K, V>.c implements SortedMap<K, Collection<V>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @gm.a
        public SortedSet<K> f4826f;

        public i(SortedMap<K, Collection<V>> submap) {
            super(submap);
        }

        @Override // java.util.SortedMap
        @gm.a
        public Comparator<? super K> comparator() {
            return j().comparator();
        }

        @Override // java.util.SortedMap
        @m5
        public K firstKey() {
            return j().firstKey();
        }

        @Override // f1.t4.r0
        public SortedSet<K> h() {
            return new j(j());
        }

        public SortedMap<K, Collection<V>> headMap(@m5 K toKey) {
            return new i(j().headMap(toKey));
        }

        @Override // f1.e.c, f1.t4.r0, java.util.AbstractMap, java.util.Map
        public SortedSet<K> i() {
            SortedSet<K> sortedSet = this.f4826f;
            if (sortedSet != null) {
                return sortedSet;
            }
            SortedSet<K> sortedSetH = h();
            this.f4826f = sortedSetH;
            return sortedSetH;
        }

        public SortedMap<K, Collection<V>> j() {
            return (SortedMap) this.f4809d;
        }

        @Override // java.util.SortedMap
        @m5
        public K lastKey() {
            return j().lastKey();
        }

        public SortedMap<K, Collection<V>> subMap(@m5 K fromKey, @m5 K toKey) {
            return new i(j().subMap(fromKey, toKey));
        }

        public SortedMap<K, Collection<V>> tailMap(@m5 K fromKey) {
            return new i(j().tailMap(fromKey));
        }
    }

    public class j extends e<K, V>.C0111e implements SortedSet<K> {
        public j(SortedMap<K, Collection<V>> subMap) {
            super(subMap);
        }

        public SortedMap<K, Collection<V>> b() {
            return (SortedMap) this.f5299a;
        }

        @Override // java.util.SortedSet
        @gm.a
        public Comparator<? super K> comparator() {
            return b().comparator();
        }

        @Override // java.util.SortedSet
        @m5
        public K first() {
            return b().firstKey();
        }

        public SortedSet<K> headSet(@m5 K toElement) {
            return new j(b().headMap(toElement));
        }

        @Override // java.util.SortedSet
        @m5
        public K last() {
            return b().lastKey();
        }

        public SortedSet<K> subSet(@m5 K fromElement, @m5 K toElement) {
            return new j(b().subMap(fromElement, toElement));
        }

        public SortedSet<K> tailSet(@m5 K fromElement) {
            return new j(b().tailMap(fromElement));
        }
    }

    public class m extends e<K, V>.o implements NavigableSet<V> {
        public m(K key, @gm.a NavigableSet<V> delegate, e<K, V>.k ancestor) {
            super(key, delegate, ancestor);
        }

        @Override // java.util.NavigableSet
        @gm.a
        public V ceiling(@m5 V v10) {
            return i().ceiling(v10);
        }

        @Override // java.util.NavigableSet
        public Iterator<V> descendingIterator() {
            return new k.a(i().descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> descendingSet() {
            return k(i().descendingSet());
        }

        @Override // java.util.NavigableSet
        @gm.a
        public V floor(@m5 V v10) {
            return i().floor(v10);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> headSet(@m5 V toElement, boolean inclusive) {
            return k(i().headSet(toElement, inclusive));
        }

        @Override // java.util.NavigableSet
        @gm.a
        public V higher(@m5 V v10) {
            return i().higher(v10);
        }

        @Override // f1.e.o
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public NavigableSet<V> i() {
            return (NavigableSet) ((SortedSet) c());
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v1, types: [f1.e$k] */
        /* JADX WARN: Type inference failed for: r4v3 */
        /* JADX WARN: Type inference failed for: r4v4 */
        public final NavigableSet<V> k(NavigableSet<V> navigableSet) {
            e eVar = e.this;
            K k10 = this.f4829a;
            e<K, V>.k kVarB = b();
            ?? B = this;
            if (kVarB != null) {
                B = b();
            }
            return new m(k10, navigableSet, B);
        }

        @Override // java.util.NavigableSet
        @gm.a
        public V lower(@m5 V v10) {
            return i().lower(v10);
        }

        @Override // java.util.NavigableSet
        @gm.a
        public V pollFirst() {
            return (V) h4.U(iterator());
        }

        @Override // java.util.NavigableSet
        @gm.a
        public V pollLast() {
            return (V) h4.U(descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> subSet(@m5 V fromElement, boolean fromInclusive, @m5 V toElement, boolean toInclusive) {
            return k(i().subSet(fromElement, fromInclusive, toElement, toInclusive));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> tailSet(@m5 V fromElement, boolean inclusive) {
            return k(i().tailSet(fromElement, inclusive));
        }
    }

    public class n extends e<K, V>.k implements Set<V> {
        public n(K key, Set<V> delegate) {
            super(key, delegate, null);
        }

        @Override // f1.e.k, java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> c10) {
            if (c10.isEmpty()) {
                return false;
            }
            int size = size();
            boolean zI = k6.I((Set) this.f4830b, c10);
            if (zI) {
                e.access$212(e.this, this.f4830b.size() - size);
                g();
            }
            return zI;
        }
    }

    public class o extends e<K, V>.k implements SortedSet<V> {
        public o(K key, @gm.a SortedSet<V> delegate, e<K, V>.k ancestor) {
            super(key, delegate, ancestor);
        }

        @Override // java.util.SortedSet
        @gm.a
        public Comparator<? super V> comparator() {
            return i().comparator();
        }

        @Override // java.util.SortedSet
        @m5
        public V first() {
            f();
            return i().first();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v1, types: [f1.e$k] */
        /* JADX WARN: Type inference failed for: r4v3 */
        /* JADX WARN: Type inference failed for: r4v4 */
        @Override // java.util.SortedSet
        public SortedSet<V> headSet(@m5 V v10) {
            f();
            e eVar = e.this;
            Object objE = e();
            SortedSet<V> sortedSetHeadSet = i().headSet(v10);
            e<K, V>.k kVarB = b();
            ?? B = this;
            if (kVarB != null) {
                B = b();
            }
            return new o(objE, sortedSetHeadSet, B);
        }

        public SortedSet<V> i() {
            return (SortedSet) c();
        }

        @Override // java.util.SortedSet
        @m5
        public V last() {
            f();
            return i().last();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v1, types: [f1.e$k] */
        /* JADX WARN: Type inference failed for: r4v3 */
        /* JADX WARN: Type inference failed for: r4v4 */
        @Override // java.util.SortedSet
        public SortedSet<V> subSet(@m5 V v10, @m5 V v11) {
            f();
            e eVar = e.this;
            Object objE = e();
            SortedSet<V> sortedSetSubSet = i().subSet(v10, v11);
            e<K, V>.k kVarB = b();
            ?? B = this;
            if (kVarB != null) {
                B = b();
            }
            return new o(objE, sortedSetSubSet, B);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v1, types: [f1.e$k] */
        /* JADX WARN: Type inference failed for: r4v3 */
        /* JADX WARN: Type inference failed for: r4v4 */
        @Override // java.util.SortedSet
        public SortedSet<V> tailSet(@m5 V v10) {
            f();
            e eVar = e.this;
            Object objE = e();
            SortedSet<V> sortedSetTailSet = i().tailSet(v10);
            e<K, V>.k kVarB = b();
            ?? B = this;
            if (kVarB != null) {
                B = b();
            }
            return new o(objE, sortedSetTailSet, B);
        }
    }

    public e(Map<K, Collection<V>> map) {
        c1.h0.d(map.isEmpty());
        this.f4807f = map;
    }

    public static /* synthetic */ int access$208(e eVar) {
        int i10 = eVar.f4808g;
        eVar.f4808g = i10 + 1;
        return i10;
    }

    public static /* synthetic */ int access$210(e eVar) {
        int i10 = eVar.f4808g;
        eVar.f4808g = i10 - 1;
        return i10;
    }

    public static /* synthetic */ int access$212(e eVar, int i10) {
        int i11 = eVar.f4808g + i10;
        eVar.f4808g = i11;
        return i11;
    }

    public static /* synthetic */ int access$220(e eVar, int i10) {
        int i11 = eVar.f4808g - i10;
        eVar.f4808g = i11;
        return i11;
    }

    public static <E> Iterator<E> c(Collection<E> collection) {
        return collection instanceof List ? ((List) collection).listIterator() : collection.iterator();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(@gm.a Object key) {
        Collection collection = (Collection) t4.q0(this.f4807f, key);
        if (collection != null) {
            int size = collection.size();
            collection.clear();
            this.f4808g -= size;
        }
    }

    public final Collection<V> b(@m5 K key) {
        Collection<V> collection = this.f4807f.get(key);
        if (collection != null) {
            return collection;
        }
        Collection<V> collectionCreateCollection = createCollection(key);
        this.f4807f.put(key, collectionCreateCollection);
        return collectionCreateCollection;
    }

    public Map<K, Collection<V>> backingMap() {
        return this.f4807f;
    }

    @Override // f1.v4
    public void clear() {
        Iterator<Collection<V>> it = this.f4807f.values().iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
        this.f4807f.clear();
        this.f4808g = 0;
    }

    @Override // f1.v4
    public boolean containsKey(@gm.a Object key) {
        return this.f4807f.containsKey(key);
    }

    @Override // f1.h
    public Map<K, Collection<V>> createAsMap() {
        return new c(this.f4807f);
    }

    public abstract Collection<V> createCollection();

    public Collection<V> createCollection(@m5 K key) {
        return createCollection();
    }

    @Override // f1.h
    public Collection<Map.Entry<K, V>> createEntries() {
        return this instanceof j6 ? new f1.h.b(this) : new f1.h.a();
    }

    @Override // f1.h
    public Set<K> createKeySet() {
        return new C0111e(this.f4807f);
    }

    @Override // f1.h
    public b5<K> createKeys() {
        return new y4.g(this);
    }

    public final Map<K, Collection<V>> createMaybeNavigableAsMap() {
        Map<K, Collection<V>> map = this.f4807f;
        if (map instanceof NavigableMap) {
            return new f((NavigableMap) this.f4807f);
        }
        return map instanceof SortedMap ? new i((SortedMap) this.f4807f) : new c(this.f4807f);
    }

    public final Set<K> createMaybeNavigableKeySet() {
        Map<K, Collection<V>> map = this.f4807f;
        if (map instanceof NavigableMap) {
            return new g((NavigableMap) this.f4807f);
        }
        return map instanceof SortedMap ? new j((SortedMap) this.f4807f) : new C0111e(this.f4807f);
    }

    public Collection<V> createUnmodifiableEmptyCollection() {
        return (Collection<V>) unmodifiableCollectionSubclass(createCollection());
    }

    @Override // f1.h
    public Collection<V> createValues() {
        return new f1.h.c();
    }

    @Override // f1.h, f1.v4
    public Collection<Map.Entry<K, V>> entries() {
        return super.entries();
    }

    @Override // f1.h
    public Iterator<Map.Entry<K, V>> entryIterator() {
        return new b(this);
    }

    @Override // f1.v4, f1.o4
    public Collection<V> get(@m5 K key) {
        Collection<V> collectionCreateCollection = this.f4807f.get(key);
        if (collectionCreateCollection == null) {
            collectionCreateCollection = createCollection(key);
        }
        return wrapCollection(key, collectionCreateCollection);
    }

    @Override // f1.h, f1.v4
    public boolean put(@m5 K key, @m5 V value) {
        Collection<V> collection = this.f4807f.get(key);
        if (collection != null) {
            if (!collection.add(value)) {
                return false;
            }
            this.f4808g++;
            return true;
        }
        Collection<V> collectionCreateCollection = createCollection(key);
        if (!collectionCreateCollection.add(value)) {
            throw new AssertionError("New Collection violated the Collection spec");
        }
        this.f4808g++;
        this.f4807f.put(key, collectionCreateCollection);
        return true;
    }

    @Override // f1.v4, f1.o4
    public Collection<V> removeAll(@gm.a Object obj) {
        Collection<V> collectionRemove = this.f4807f.remove(obj);
        if (collectionRemove == null) {
            return createUnmodifiableEmptyCollection();
        }
        Collection collectionCreateCollection = createCollection();
        collectionCreateCollection.addAll(collectionRemove);
        this.f4808g -= collectionRemove.size();
        collectionRemove.clear();
        return (Collection<V>) unmodifiableCollectionSubclass(collectionCreateCollection);
    }

    @Override // f1.h, f1.v4, f1.o4
    public Collection<V> replaceValues(@m5 K k10, Iterable<? extends V> iterable) {
        Iterator<? extends V> it = iterable.iterator();
        if (!it.hasNext()) {
            return removeAll(k10);
        }
        Collection<V> collectionB = b(k10);
        Collection<V> collectionCreateCollection = createCollection();
        collectionCreateCollection.addAll(collectionB);
        this.f4808g -= collectionB.size();
        collectionB.clear();
        while (it.hasNext()) {
            if (collectionB.add(it.next())) {
                this.f4808g++;
            }
        }
        return (Collection<V>) unmodifiableCollectionSubclass(collectionCreateCollection);
    }

    public final void setMap(Map<K, Collection<V>> map) {
        this.f4807f = map;
        this.f4808g = 0;
        for (Collection<V> collection : map.values()) {
            c1.h0.d(!collection.isEmpty());
            this.f4808g = collection.size() + this.f4808g;
        }
    }

    @Override // f1.v4
    public int size() {
        return this.f4808g;
    }

    public <E> Collection<E> unmodifiableCollectionSubclass(Collection<E> collection) {
        return Collections.unmodifiableCollection(collection);
    }

    @Override // f1.h
    public Iterator<V> valueIterator() {
        return new a(this);
    }

    @Override // f1.h, f1.v4
    public Collection<V> values() {
        return super.values();
    }

    public Collection<V> wrapCollection(@m5 K key, Collection<V> collection) {
        return new k(key, collection, null);
    }

    public final List<V> wrapList(@m5 K key, List<V> list, @gm.a e<K, V>.k ancestor) {
        return list instanceof RandomAccess ? new h(this, key, list, ancestor) : new l(key, list, ancestor);
    }

    public class k extends AbstractCollection<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @m5
        public final K f4829a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Collection<V> f4830b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @gm.a
        public final e<K, V>.k f4831c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @gm.a
        public final Collection<V> f4832d;

        public k(K key, @gm.a Collection<V> delegate, e<K, V>.k ancestor) {
            this.f4829a = key;
            this.f4830b = delegate;
            this.f4831c = ancestor;
            this.f4832d = ancestor == null ? null : ancestor.c();
        }

        public void a() {
            e<K, V>.k kVar = this.f4831c;
            if (kVar != null) {
                kVar.a();
            } else {
                e.this.f4807f.put(this.f4829a, this.f4830b);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean add(@m5 V value) {
            f();
            boolean zIsEmpty = this.f4830b.isEmpty();
            boolean zAdd = this.f4830b.add(value);
            if (zAdd) {
                e.access$208(e.this);
                if (zIsEmpty) {
                    a();
                }
            }
            return zAdd;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean zAddAll = this.f4830b.addAll(collection);
            if (zAddAll) {
                e.access$212(e.this, this.f4830b.size() - size);
                if (size == 0) {
                    a();
                }
            }
            return zAddAll;
        }

        @gm.a
        public e<K, V>.k b() {
            return this.f4831c;
        }

        public Collection<V> c() {
            return this.f4830b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            int size = size();
            if (size == 0) {
                return;
            }
            this.f4830b.clear();
            e.access$220(e.this, size);
            g();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@gm.a Object o10) {
            f();
            return this.f4830b.contains(o10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection<?> c10) {
            f();
            return this.f4830b.containsAll(c10);
        }

        @m5
        public K e() {
            return this.f4829a;
        }

        @Override // java.util.Collection
        public boolean equals(@gm.a Object object) {
            if (object == this) {
                return true;
            }
            f();
            return this.f4830b.equals(object);
        }

        public void f() {
            Collection<V> collection;
            e<K, V>.k kVar = this.f4831c;
            if (kVar != null) {
                kVar.f();
                if (this.f4831c.c() != this.f4832d) {
                    throw new ConcurrentModificationException();
                }
            } else {
                if (!this.f4830b.isEmpty() || (collection = (Collection) e.this.f4807f.get(this.f4829a)) == null) {
                    return;
                }
                this.f4830b = collection;
            }
        }

        public void g() {
            e<K, V>.k kVar = this.f4831c;
            if (kVar != null) {
                kVar.g();
            } else if (this.f4830b.isEmpty()) {
                e.this.f4807f.remove(this.f4829a);
            }
        }

        @Override // java.util.Collection
        public int hashCode() {
            f();
            return this.f4830b.hashCode();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            f();
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(@gm.a Object o10) {
            f();
            boolean zRemove = this.f4830b.remove(o10);
            if (zRemove) {
                e.access$210(e.this);
                g();
            }
            return zRemove;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> c10) {
            if (c10.isEmpty()) {
                return false;
            }
            int size = size();
            boolean zRemoveAll = this.f4830b.removeAll(c10);
            if (zRemoveAll) {
                e.access$212(e.this, this.f4830b.size() - size);
                g();
            }
            return zRemoveAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> c10) {
            c10.getClass();
            int size = size();
            boolean zRetainAll = this.f4830b.retainAll(c10);
            if (zRetainAll) {
                e.access$212(e.this, this.f4830b.size() - size);
                g();
            }
            return zRetainAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            f();
            return this.f4830b.size();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            f();
            return this.f4830b.toString();
        }

        public class a implements Iterator<V> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Iterator<V> f4834a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final Collection<V> f4835b;

            public a() {
                Collection<V> collection = k.this.f4830b;
                this.f4835b = collection;
                this.f4834a = e.c(collection);
            }

            public Iterator<V> a() {
                b();
                return this.f4834a;
            }

            public void b() {
                k.this.f();
                if (k.this.f4830b != this.f4835b) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                b();
                return this.f4834a.hasNext();
            }

            @Override // java.util.Iterator
            @m5
            public V next() {
                b();
                return this.f4834a.next();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.f4834a.remove();
                e.access$210(e.this);
                k.this.g();
            }

            public a(Iterator<V> delegateIterator) {
                this.f4835b = k.this.f4830b;
                this.f4834a = delegateIterator;
            }
        }
    }

    public class l extends e<K, V>.k implements List<V> {

        public class a extends e<K, V>.k.a implements ListIterator<V> {
            public a() {
                super();
            }

            @Override // java.util.ListIterator
            public void add(@m5 V value) {
                boolean zIsEmpty = l.this.isEmpty();
                ((ListIterator) a()).add(value);
                e.access$208(e.this);
                if (zIsEmpty) {
                    l.this.a();
                }
            }

            public final ListIterator<V> c() {
                return (ListIterator) a();
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                return ((ListIterator) a()).hasPrevious();
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return ((ListIterator) a()).nextIndex();
            }

            @Override // java.util.ListIterator
            @m5
            public V previous() {
                return (V) ((ListIterator) a()).previous();
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return ((ListIterator) a()).previousIndex();
            }

            @Override // java.util.ListIterator
            public void set(@m5 V value) {
                ((ListIterator) a()).set(value);
            }

            public a(int index) {
                super(l.this.i().listIterator(index));
            }
        }

        public l(K key, @gm.a List<V> delegate, e<K, V>.k ancestor) {
            super(key, delegate, ancestor);
        }

        @Override // java.util.List
        public void add(int index, @m5 V element) {
            f();
            boolean zIsEmpty = c().isEmpty();
            i().add(index, element);
            e.access$208(e.this);
            if (zIsEmpty) {
                a();
            }
        }

        @Override // java.util.List
        public boolean addAll(int index, Collection<? extends V> c10) {
            if (c10.isEmpty()) {
                return false;
            }
            int size = size();
            boolean zAddAll = i().addAll(index, c10);
            if (zAddAll) {
                e.access$212(e.this, c().size() - size);
                if (size == 0) {
                    a();
                }
            }
            return zAddAll;
        }

        @Override // java.util.List
        @m5
        public V get(int index) {
            f();
            return i().get(index);
        }

        public List<V> i() {
            return (List) c();
        }

        @Override // java.util.List
        public int indexOf(@gm.a Object o10) {
            f();
            return i().indexOf(o10);
        }

        @Override // java.util.List
        public int lastIndexOf(@gm.a Object o10) {
            f();
            return i().lastIndexOf(o10);
        }

        @Override // java.util.List
        public ListIterator<V> listIterator() {
            f();
            return new a();
        }

        @Override // java.util.List
        @m5
        public V remove(int index) {
            f();
            V vRemove = i().remove(index);
            e.access$210(e.this);
            g();
            return vRemove;
        }

        @Override // java.util.List
        @m5
        public V set(int index, @m5 V element) {
            f();
            return i().set(index, element);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [f1.e] */
        /* JADX WARN: Type inference failed for: r3v1, types: [f1.e$k] */
        /* JADX WARN: Type inference failed for: r3v4 */
        /* JADX WARN: Type inference failed for: r3v5 */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // java.util.List
        public List<V> subList(int i10, int i11) {
            f();
            ?? r10 = e.this;
            Object objE = e();
            List<V> listSubList = i().subList(i10, i11);
            e<K, V>.k kVarB = b();
            ?? B = this;
            if (kVarB != null) {
                B = b();
            }
            return r10.wrapList(objE, listSubList, B);
        }

        @Override // java.util.List
        public ListIterator<V> listIterator(int index) {
            f();
            return new a(index);
        }
    }
}
