package f1;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Objects;
import java.util.SortedMap;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true, serializable = true)
@x0
public final class w3<K, V> extends x3<K, V> implements NavigableMap<K, V> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Comparator<Comparable> f5517i = l5.natural();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final w3<Comparable, Object> f5518n = new w3<>(a4.emptySet(l5.natural()), i3.of());
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final transient c6<K> f5519e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final transient i3<V> f5520f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @gm.a
    public transient w3<K, V> f5521g;

    public class a extends l3<K, V> {

        /* JADX INFO: renamed from: f1.w3$a$a, reason: collision with other inner class name */
        public class C0127a extends i3<Map.Entry<K, V>> {
            public C0127a() {
            }

            @Override // f1.e3
            public boolean isPartialView() {
                return true;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return w3.this.size();
            }

            @Override // java.util.List
            public Map.Entry<K, V> get(int index) {
                return new AbstractMap.SimpleImmutableEntry(w3.this.f5519e.asList().get(index), w3.this.f5520f.get(index));
            }
        }

        public a() {
        }

        @Override // f1.t3
        public i3<Map.Entry<K, V>> createAsList() {
            return new C0127a();
        }

        @Override // f1.l3
        public k3<K, V> map() {
            return w3.this;
        }

        @Override // f1.t3, f1.e3, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, f1.n6
        public x7<Map.Entry<K, V>> iterator() {
            return asList().iterator();
        }
    }

    @b1.d
    public static class c<K, V> extends k3.e<K, V> {
        private static final long serialVersionUID = 0;
        private final Comparator<? super K> comparator;

        public c(w3<K, V> sortedMap) {
            super(sortedMap);
            this.comparator = sortedMap.comparator();
        }

        @Override // f1.k3.e
        public b<K, V> makeBuilder(int size) {
            return new b<>(this.comparator, 4);
        }
    }

    public w3(c6<K> keySet, i3<V> valueList) {
        this(keySet, valueList, null);
    }

    public static <K, V> w3<K, V> c(Map<? extends K, ? extends V> map, Comparator<? super K> comparator) {
        boolean zEquals = false;
        if (map instanceof SortedMap) {
            Comparator<? super K> comparator2 = ((SortedMap) map).comparator();
            if (comparator2 != null) {
                zEquals = comparator.equals(comparator2);
            } else if (comparator == f5517i) {
                zEquals = true;
            }
        }
        if (zEquals && (map instanceof w3)) {
            w3<K, V> w3Var = (w3) map;
            if (!w3Var.isPartialView()) {
                return w3Var;
            }
        }
        return d(comparator, zEquals, map.entrySet());
    }

    public static <K, V> w3<K, V> copyOf(Map<? extends K, ? extends V> map) {
        return c(map, (l5) f5517i);
    }

    public static <K, V> w3<K, V> copyOfSorted(SortedMap<K, ? extends V> map) {
        Comparator<? super K> comparator = map.comparator();
        if (comparator == null) {
            comparator = f5517i;
        }
        if (map instanceof w3) {
            w3<K, V> w3Var = (w3) map;
            if (!w3Var.isPartialView()) {
                return w3Var;
            }
        }
        return d(comparator, true, map.entrySet());
    }

    public static <K, V> w3<K, V> d(Comparator<? super K> comparator, boolean sameComparator, Iterable<? extends Map.Entry<? extends K, ? extends V>> entries) {
        Map.Entry[] entryArr = (Map.Entry[]) g4.R(entries, k3.EMPTY_ENTRY_ARRAY);
        return e(comparator, sameComparator, entryArr, entryArr.length);
    }

    public static <K, V> w3<K, V> e(final Comparator<? super K> comparator, boolean sameComparator, Map.Entry<K, V>[] entryArray, int size) {
        if (size == 0) {
            return emptyMap(comparator);
        }
        if (size == 1) {
            Map.Entry<K, V> entry = entryArray[0];
            Objects.requireNonNull(entry);
            Map.Entry<K, V> entry2 = entry;
            return i(comparator, entry2.getKey(), entry2.getValue());
        }
        Object[] objArr = new Object[size];
        Object[] objArr2 = new Object[size];
        if (sameComparator) {
            for (int i10 = 0; i10 < size; i10++) {
                Map.Entry<K, V> entry3 = entryArray[i10];
                Objects.requireNonNull(entry3);
                Map.Entry<K, V> entry4 = entry3;
                K key = entry4.getKey();
                V value = entry4.getValue();
                b0.a(key, value);
                objArr[i10] = key;
                objArr2[i10] = value;
            }
        } else {
            Arrays.sort(entryArray, 0, size, new Comparator() { // from class: f1.v3
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return w3.h(comparator, (Map.Entry) obj, (Map.Entry) obj2);
                }
            });
            Map.Entry<K, V> entry5 = entryArray[0];
            Objects.requireNonNull(entry5);
            Map.Entry<K, V> entry6 = entry5;
            Object key2 = entry6.getKey();
            objArr[0] = key2;
            V value2 = entry6.getValue();
            objArr2[0] = value2;
            b0.a(objArr[0], value2);
            int i11 = 1;
            while (i11 < size) {
                Map.Entry<K, V> entry7 = entryArray[i11 - 1];
                Objects.requireNonNull(entry7);
                Map.Entry<K, V> entry8 = entry7;
                Map.Entry<K, V> entry9 = entryArray[i11];
                Objects.requireNonNull(entry9);
                Map.Entry<K, V> entry10 = entry9;
                Object key3 = entry10.getKey();
                V value3 = entry10.getValue();
                b0.a(key3, value3);
                objArr[i11] = key3;
                objArr2[i11] = value3;
                k3.checkNoConflict(comparator.compare(key2, key3) != 0, cb.b.c.f1408o, entry8, entry10);
                i11++;
                key2 = key3;
            }
        }
        return new w3<>(new c6(i3.asImmutableList(objArr), comparator), i3.asImmutableList(objArr2));
    }

    public static <K, V> w3<K, V> emptyMap(Comparator<? super K> comparator) {
        return l5.natural().equals(comparator) ? of() : new w3<>(a4.emptySet(comparator), i3.of());
    }

    public static <K extends Comparable<? super K>, V> w3<K, V> f(Map.Entry<K, V>... entries) {
        return e(l5.natural(), false, entries, entries.length);
    }

    public static /* synthetic */ int h(Comparator comparator, Map.Entry entry, Map.Entry entry2) {
        Objects.requireNonNull(entry);
        Objects.requireNonNull(entry2);
        return comparator.compare(entry.getKey(), entry2.getKey());
    }

    public static <K, V> w3<K, V> i(Comparator<? super K> comparator, K k10, V v10) {
        i3 i3VarOf = i3.of(k10);
        comparator.getClass();
        return new w3<>(new c6(i3VarOf, comparator), i3.of(v10));
    }

    public static <K extends Comparable<?>, V> b<K, V> naturalOrder() {
        return new b<>(l5.natural(), 4);
    }

    public static <K, V> w3<K, V> of() {
        return (w3<K, V>) f5518n;
    }

    public static <K, V> b<K, V> orderedBy(Comparator<K> comparator) {
        return new b<>(comparator, 4);
    }

    @b1.d
    private void readObject(ObjectInputStream stream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static <K extends Comparable<?>, V> b<K, V> reverseOrder() {
        return new b<>(l5.natural().reverse(), 4);
    }

    @Override // java.util.NavigableMap
    @gm.a
    public Map.Entry<K, V> ceilingEntry(K key) {
        return tailMap((Object) key, true).firstEntry();
    }

    @Override // java.util.NavigableMap
    @gm.a
    public K ceilingKey(K k10) {
        return (K) t4.T(ceilingEntry(k10));
    }

    @Override // java.util.SortedMap
    public Comparator<? super K> comparator() {
        return keySet().comparator();
    }

    @Override // f1.k3
    public t3<Map.Entry<K, V>> createEntrySet() {
        return isEmpty() ? t3.of() : new a();
    }

    @Override // f1.k3
    public t3<K> createKeySet() {
        throw new AssertionError("should never be called");
    }

    @Override // f1.k3
    public e3<V> createValues() {
        throw new AssertionError("should never be called");
    }

    @Override // java.util.NavigableMap
    @gm.a
    public Map.Entry<K, V> firstEntry() {
        if (isEmpty()) {
            return null;
        }
        return entrySet().asList().get(0);
    }

    @Override // java.util.SortedMap
    public K firstKey() {
        return keySet().first();
    }

    @Override // java.util.NavigableMap
    @gm.a
    public Map.Entry<K, V> floorEntry(K key) {
        return headMap((Object) key, true).lastEntry();
    }

    @Override // java.util.NavigableMap
    @gm.a
    public K floorKey(K k10) {
        return (K) t4.T(floorEntry(k10));
    }

    public final w3<K, V> g(int fromIndex, int toIndex) {
        if (fromIndex == 0 && toIndex == size()) {
            return this;
        }
        return fromIndex == toIndex ? emptyMap(comparator()) : new w3<>(this.f5519e.getSubSet(fromIndex, toIndex), this.f5520f.subList(fromIndex, toIndex));
    }

    @Override // f1.k3, java.util.Map
    @gm.a
    public V get(@gm.a Object key) {
        int iIndexOf = this.f5519e.indexOf(key);
        if (iIndexOf == -1) {
            return null;
        }
        return this.f5520f.get(iIndexOf);
    }

    @Override // java.util.NavigableMap
    @gm.a
    public Map.Entry<K, V> higherEntry(K key) {
        return tailMap((Object) key, false).firstEntry();
    }

    @Override // java.util.NavigableMap
    @gm.a
    public K higherKey(K k10) {
        return (K) t4.T(higherEntry(k10));
    }

    @Override // f1.k3
    public boolean isPartialView() {
        return this.f5519e.isPartialView() || this.f5520f.isPartialView();
    }

    @Override // java.util.NavigableMap
    @gm.a
    public Map.Entry<K, V> lastEntry() {
        if (isEmpty()) {
            return null;
        }
        return entrySet().asList().get(size() - 1);
    }

    @Override // java.util.SortedMap
    public K lastKey() {
        return keySet().last();
    }

    @Override // java.util.NavigableMap
    @gm.a
    public Map.Entry<K, V> lowerEntry(K key) {
        return headMap((Object) key, false).lastEntry();
    }

    @Override // java.util.NavigableMap
    @gm.a
    public K lowerKey(K k10) {
        return (K) t4.T(lowerEntry(k10));
    }

    @Override // java.util.NavigableMap
    @gm.a
    @t1.a
    @Deprecated
    @t1.e("Always throws UnsupportedOperationException")
    public final Map.Entry<K, V> pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableMap
    @gm.a
    @t1.a
    @Deprecated
    @t1.e("Always throws UnsupportedOperationException")
    public final Map.Entry<K, V> pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public int size() {
        return this.f5520f.size();
    }

    @Override // f1.k3
    @b1.d
    public Object writeReplace() {
        return new c(this);
    }

    public w3(c6<K> keySet, i3<V> valueList, @gm.a w3<K, V> descendingMap) {
        this.f5519e = keySet;
        this.f5520f = valueList;
        this.f5521g = descendingMap;
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;)Lf1/w3<TK;TV;>; */
    public static w3 of(Comparable k10, Object v10) {
        return i(l5.natural(), k10, v10);
    }

    @Override // java.util.NavigableMap
    public a4<K> descendingKeySet() {
        return this.f5519e.descendingSet();
    }

    @Override // java.util.NavigableMap
    public w3<K, V> descendingMap() {
        w3<K, V> w3Var = this.f5521g;
        if (w3Var == null) {
            return isEmpty() ? emptyMap(l5.from(comparator()).reverse()) : new w3<>((c6) this.f5519e.descendingSet(), this.f5520f.reverse(), this);
        }
        return w3Var;
    }

    @Override // f1.k3, java.util.Map
    public t3<Map.Entry<K, V>> entrySet() {
        return super.entrySet();
    }

    @Override // java.util.NavigableMap
    public a4<K> navigableKeySet() {
        return this.f5519e;
    }

    @Override // f1.k3, java.util.Map, f1.w
    public e3<V> values() {
        return this.f5520f;
    }

    public static <K, V> w3<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> entries) {
        return copyOf(entries, (l5) f5517i);
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;)Lf1/w3<TK;TV;>; */
    public static w3 of(Comparable k10, Object v10, Comparable k11, Object v11) {
        return f(k3.entryOf(k10, v10), k3.entryOf(k11, v11));
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public w3<K, V> headMap(K toKey) {
        return headMap((Object) toKey, false);
    }

    @Override // f1.k3, java.util.Map
    public a4<K> keySet() {
        return this.f5519e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap
    public w3<K, V> subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive) {
        fromKey.getClass();
        toKey.getClass();
        c1.h0.y(comparator().compare(fromKey, toKey) <= 0, "expected fromKey <= toKey but %s > %s", fromKey, toKey);
        return headMap((Object) toKey, toInclusive).tailMap((Object) fromKey, fromInclusive);
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public w3<K, V> tailMap(K fromKey) {
        return tailMap((Object) fromKey, true);
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;)Lf1/w3<TK;TV;>; */
    public static w3 of(Comparable k10, Object v10, Comparable k11, Object v11, Comparable k12, Object v12) {
        return f(k3.entryOf(k10, v10), k3.entryOf(k11, v11), k3.entryOf(k12, v12));
    }

    @Override // java.util.NavigableMap
    public w3<K, V> headMap(K toKey, boolean inclusive) {
        c6<K> c6Var = this.f5519e;
        toKey.getClass();
        return g(0, c6Var.headIndex(toKey, inclusive));
    }

    @Override // java.util.NavigableMap
    public w3<K, V> tailMap(K fromKey, boolean inclusive) {
        c6<K> c6Var = this.f5519e;
        fromKey.getClass();
        return g(c6Var.tailIndex(fromKey, inclusive), size());
    }

    public static class b<K, V> extends k3.b<K, V> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public transient Object[] f5522f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public transient Object[] f5523g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Comparator<? super K> f5524h;

        public b(Comparator<? super K> comparator, int initialCapacity) {
            super(4);
            comparator.getClass();
            this.f5524h = comparator;
            this.f5522f = new Object[initialCapacity];
            this.f5523g = new Object[initialCapacity];
        }

        public final void f(int minCapacity) {
            Object[] objArr = this.f5522f;
            if (minCapacity > objArr.length) {
                int iF = e3.b.f(objArr.length, minCapacity);
                this.f5522f = Arrays.copyOf(this.f5522f, iF);
                this.f5523g = Arrays.copyOf(this.f5523g, iF);
            }
        }

        @Override // f1.k3.b
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public w3<K, V> a() {
            return d();
        }

        @Override // f1.k3.b
        @t1.e
        @Deprecated
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public final w3<K, V> c() {
            throw new UnsupportedOperationException("ImmutableSortedMap.Builder does not yet implement buildKeepingLast()");
        }

        @Override // f1.k3.b
        /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
        public w3<K, V> d() {
            int i10 = this.f5017c;
            if (i10 == 0) {
                return w3.emptyMap(this.f5524h);
            }
            if (i10 == 1) {
                Comparator<? super K> comparator = this.f5524h;
                Object obj = this.f5522f[0];
                Objects.requireNonNull(obj);
                Object obj2 = this.f5523g[0];
                Objects.requireNonNull(obj2);
                return w3.i(comparator, obj, obj2);
            }
            Object[] objArrCopyOf = Arrays.copyOf(this.f5522f, i10);
            Arrays.sort(objArrCopyOf, this.f5524h);
            Object[] objArr = new Object[this.f5017c];
            for (int i11 = 0; i11 < this.f5017c; i11++) {
                if (i11 > 0) {
                    int i12 = i11 - 1;
                    if (this.f5524h.compare(objArrCopyOf[i12], objArrCopyOf[i11]) == 0) {
                        throw new IllegalArgumentException("keys required to be distinct but compared as equal: " + objArrCopyOf[i12] + " and " + objArrCopyOf[i11]);
                    }
                }
                Object obj3 = this.f5522f[i11];
                Objects.requireNonNull(obj3);
                int iBinarySearch = Arrays.binarySearch(objArrCopyOf, obj3, this.f5524h);
                Object obj4 = this.f5523g[i11];
                Objects.requireNonNull(obj4);
                objArr[iBinarySearch] = obj4;
            }
            return new w3<>(new c6(i3.asImmutableList(objArrCopyOf), this.f5524h), i3.asImmutableList(objArr));
        }

        @t1.a
        public b<K, V> q(b<K, V> other) {
            f(this.f5017c + other.f5017c);
            System.arraycopy(other.f5522f, 0, this.f5522f, this.f5017c, other.f5017c);
            System.arraycopy(other.f5523g, 0, this.f5523g, this.f5017c, other.f5017c);
            this.f5017c += other.f5017c;
            return this;
        }

        @Override // f1.k3.b
        @t1.a
        @Deprecated
        @t1.e("Always throws UnsupportedOperationException")
        /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
        public final b<K, V> h(Comparator<? super V> valueComparator) {
            throw new UnsupportedOperationException("Not available on ImmutableSortedMap.Builder");
        }

        @Override // f1.k3.b
        @t1.a
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public b<K, V> i(K key, V value) {
            f(this.f5017c + 1);
            b0.a(key, value);
            Object[] objArr = this.f5522f;
            int i10 = this.f5017c;
            objArr[i10] = key;
            this.f5523g[i10] = value;
            this.f5017c = i10 + 1;
            return this;
        }

        @Override // f1.k3.b
        @t1.a
        /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
        public b<K, V> j(Map.Entry<? extends K, ? extends V> entry) {
            super.j(entry);
            return this;
        }

        @Override // f1.k3.b
        @t1.a
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public b<K, V> k(Iterable<? extends Map.Entry<? extends K, ? extends V>> entries) {
            super.k(entries);
            return this;
        }

        @Override // f1.k3.b
        @t1.a
        /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
        public b<K, V> l(Map<? extends K, ? extends V> map) {
            super.l(map);
            return this;
        }

        public b(Comparator<? super K> comparator) {
            this(comparator, 4);
        }
    }

    public static <K, V> w3<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> entries, Comparator<? super K> comparator) {
        comparator.getClass();
        return d(comparator, false, entries);
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;TK;TV;)Lf1/w3<TK;TV;>; */
    public static w3 of(Comparable k10, Object v10, Comparable k11, Object v11, Comparable k12, Object v12, Comparable k13, Object v13) {
        return f(k3.entryOf(k10, v10), k3.entryOf(k11, v11), k3.entryOf(k12, v12), k3.entryOf(k13, v13));
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;)Lf1/w3<TK;TV;>; */
    public static w3 of(Comparable k10, Object v10, Comparable k11, Object v11, Comparable k12, Object v12, Comparable k13, Object v13, Comparable k14, Object v14) {
        return f(k3.entryOf(k10, v10), k3.entryOf(k11, v11), k3.entryOf(k12, v12), k3.entryOf(k13, v13), k3.entryOf(k14, v14));
    }

    public static <K, V> w3<K, V> copyOf(Map<? extends K, ? extends V> map, Comparator<? super K> comparator) {
        comparator.getClass();
        return c(map, comparator);
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;)Lf1/w3<TK;TV;>; */
    public static w3 of(Comparable k10, Object v10, Comparable k11, Object v11, Comparable k12, Object v12, Comparable k13, Object v13, Comparable k14, Object v14, Comparable k15, Object v15) {
        return f(k3.entryOf(k10, v10), k3.entryOf(k11, v11), k3.entryOf(k12, v12), k3.entryOf(k13, v13), k3.entryOf(k14, v14), k3.entryOf(k15, v15));
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public w3<K, V> subMap(K fromKey, K toKey) {
        return subMap((Object) fromKey, true, (Object) toKey, false);
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;)Lf1/w3<TK;TV;>; */
    public static w3 of(Comparable k10, Object v10, Comparable k11, Object v11, Comparable k12, Object v12, Comparable k13, Object v13, Comparable k14, Object v14, Comparable k15, Object v15, Comparable k16, Object v16) {
        return f(k3.entryOf(k10, v10), k3.entryOf(k11, v11), k3.entryOf(k12, v12), k3.entryOf(k13, v13), k3.entryOf(k14, v14), k3.entryOf(k15, v15), k3.entryOf(k16, v16));
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;)Lf1/w3<TK;TV;>; */
    public static w3 of(Comparable k10, Object v10, Comparable k11, Object v11, Comparable k12, Object v12, Comparable k13, Object v13, Comparable k14, Object v14, Comparable k15, Object v15, Comparable k16, Object v16, Comparable k17, Object v17) {
        return f(k3.entryOf(k10, v10), k3.entryOf(k11, v11), k3.entryOf(k12, v12), k3.entryOf(k13, v13), k3.entryOf(k14, v14), k3.entryOf(k15, v15), k3.entryOf(k16, v16), k3.entryOf(k17, v17));
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;)Lf1/w3<TK;TV;>; */
    public static w3 of(Comparable k10, Object v10, Comparable k11, Object v11, Comparable k12, Object v12, Comparable k13, Object v13, Comparable k14, Object v14, Comparable k15, Object v15, Comparable k16, Object v16, Comparable k17, Object v17, Comparable k18, Object v18) {
        return f(k3.entryOf(k10, v10), k3.entryOf(k11, v11), k3.entryOf(k12, v12), k3.entryOf(k13, v13), k3.entryOf(k14, v14), k3.entryOf(k15, v15), k3.entryOf(k16, v16), k3.entryOf(k17, v17), k3.entryOf(k18, v18));
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;)Lf1/w3<TK;TV;>; */
    public static w3 of(Comparable k10, Object v10, Comparable k11, Object v11, Comparable k12, Object v12, Comparable k13, Object v13, Comparable k14, Object v14, Comparable k15, Object v15, Comparable k16, Object v16, Comparable k17, Object v17, Comparable k18, Object v18, Comparable k19, Object v19) {
        return f(k3.entryOf(k10, v10), k3.entryOf(k11, v11), k3.entryOf(k12, v12), k3.entryOf(k13, v13), k3.entryOf(k14, v14), k3.entryOf(k15, v15), k3.entryOf(k16, v16), k3.entryOf(k17, v17), k3.entryOf(k18, v18), k3.entryOf(k19, v19));
    }
}
