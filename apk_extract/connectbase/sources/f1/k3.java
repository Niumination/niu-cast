package f1;

import com.google.j2objc.annotations.RetainedWith;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true, serializable = true)
@x0
@t1.f("Use ImmutableMap.of or another implementation")
public abstract class k3<K, V> implements Map<K, V>, Serializable {
    static final Map.Entry<?, ?>[] EMPTY_ENTRY_ARRAY = new Map.Entry[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @u1.b
    @RetainedWith
    @gm.a
    public transient t3<Map.Entry<K, V>> f5010a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @u1.b
    @RetainedWith
    @gm.a
    public transient t3<K> f5011b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @u1.b
    @RetainedWith
    @gm.a
    public transient e3<V> f5012c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @u1.b
    @gm.a
    public transient u3<K, V> f5013d;

    public class a extends x7<K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ x7 f5014a;

        public a(final k3 this$0, final x7 val$entryIterator) {
            this.f5014a = val$entryIterator;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f5014a.hasNext();
        }

        @Override // java.util.Iterator
        public K next() {
            return (K) ((Map.Entry) this.f5014a.next()).getKey();
        }
    }

    @t1.f
    public static class b<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @gm.a
        public Comparator<? super V> f5015a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object[] f5016b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f5017c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f5018d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public a f5019e;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Object f5020a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final Object f5021b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final Object f5022c;

            public a(Object key, Object value1, Object value2) {
                this.f5020a = key;
                this.f5021b = value1;
                this.f5022c = value2;
            }

            public IllegalArgumentException a() {
                return new IllegalArgumentException("Multiple entries with same key: " + this.f5020a + "=" + this.f5021b + " and " + this.f5020a + "=" + this.f5022c);
            }
        }

        public b() {
            this(4);
        }

        private void f(int minCapacity) {
            int i10 = minCapacity * 2;
            Object[] objArr = this.f5016b;
            if (i10 > objArr.length) {
                this.f5016b = Arrays.copyOf(objArr, e3.b.f(objArr.length, i10));
                this.f5018d = false;
            }
        }

        public static <V> void m(Object[] alternatingKeysAndValues, int size, Comparator<? super V> valueComparator) {
            Map.Entry[] entryArr = new Map.Entry[size];
            for (int i10 = 0; i10 < size; i10++) {
                int i11 = i10 * 2;
                Object obj = alternatingKeysAndValues[i11];
                Objects.requireNonNull(obj);
                Object obj2 = alternatingKeysAndValues[i11 + 1];
                Objects.requireNonNull(obj2);
                entryArr[i10] = new AbstractMap.SimpleImmutableEntry(obj, obj2);
            }
            Arrays.sort(entryArr, 0, size, l5.from(valueComparator).onResultOf(t4.r.VALUE));
            for (int i12 = 0; i12 < size; i12++) {
                int i13 = i12 * 2;
                alternatingKeysAndValues[i13] = entryArr[i12].getKey();
                alternatingKeysAndValues[i13 + 1] = entryArr[i12].getValue();
            }
        }

        public k3<K, V> a() {
            return d();
        }

        public final k3<K, V> b(boolean throwIfDuplicateKeys) {
            Object[] objArrG;
            a aVar;
            a aVar2;
            if (throwIfDuplicateKeys && (aVar2 = this.f5019e) != null) {
                throw aVar2.a();
            }
            int length = this.f5017c;
            if (this.f5015a == null) {
                objArrG = this.f5016b;
            } else {
                if (this.f5018d) {
                    this.f5016b = Arrays.copyOf(this.f5016b, length * 2);
                }
                objArrG = this.f5016b;
                if (!throwIfDuplicateKeys) {
                    objArrG = g(objArrG, this.f5017c);
                    if (objArrG.length < this.f5016b.length) {
                        length = objArrG.length >>> 1;
                    }
                }
                m(objArrG, length, this.f5015a);
            }
            this.f5018d = true;
            y5 y5VarCreate = y5.create(length, objArrG, this);
            if (!throwIfDuplicateKeys || (aVar = this.f5019e) == null) {
                return y5VarCreate;
            }
            throw aVar.a();
        }

        public k3<K, V> c() {
            return b(false);
        }

        public k3<K, V> d() {
            return b(true);
        }

        @t1.a
        public b<K, V> e(b<K, V> other) {
            other.getClass();
            f(this.f5017c + other.f5017c);
            System.arraycopy(other.f5016b, 0, this.f5016b, this.f5017c * 2, other.f5017c * 2);
            this.f5017c += other.f5017c;
            return this;
        }

        public final Object[] g(Object[] localAlternatingKeysAndValues, int size) {
            HashSet hashSet = new HashSet();
            BitSet bitSet = new BitSet();
            for (int i10 = size - 1; i10 >= 0; i10--) {
                Object obj = localAlternatingKeysAndValues[i10 * 2];
                Objects.requireNonNull(obj);
                if (!hashSet.add(obj)) {
                    bitSet.set(i10);
                }
            }
            if (bitSet.isEmpty()) {
                return localAlternatingKeysAndValues;
            }
            Object[] objArr = new Object[(size - bitSet.cardinality()) * 2];
            int i11 = 0;
            int i12 = 0;
            while (i11 < size * 2) {
                if (bitSet.get(i11 >>> 1)) {
                    i11 += 2;
                } else {
                    int i13 = i12 + 1;
                    int i14 = i11 + 1;
                    Object obj2 = localAlternatingKeysAndValues[i11];
                    Objects.requireNonNull(obj2);
                    objArr[i12] = obj2;
                    i12 += 2;
                    i11 += 2;
                    Object obj3 = localAlternatingKeysAndValues[i14];
                    Objects.requireNonNull(obj3);
                    objArr[i13] = obj3;
                }
            }
            return objArr;
        }

        @t1.a
        public b<K, V> h(Comparator<? super V> valueComparator) {
            c1.h0.h0(this.f5015a == null, "valueComparator was already set");
            this.f5015a = (Comparator) c1.h0.F(valueComparator, "valueComparator");
            return this;
        }

        @t1.a
        public b<K, V> i(K key, V value) {
            f(this.f5017c + 1);
            b0.a(key, value);
            Object[] objArr = this.f5016b;
            int i10 = this.f5017c;
            objArr[i10 * 2] = key;
            objArr[(i10 * 2) + 1] = value;
            this.f5017c = i10 + 1;
            return this;
        }

        @t1.a
        public b<K, V> j(Map.Entry<? extends K, ? extends V> entry) {
            return i(entry.getKey(), entry.getValue());
        }

        @t1.a
        public b<K, V> k(Iterable<? extends Map.Entry<? extends K, ? extends V>> entries) {
            if (entries instanceof Collection) {
                f(((Collection) entries).size() + this.f5017c);
            }
            Iterator<? extends Map.Entry<? extends K, ? extends V>> it = entries.iterator();
            while (it.hasNext()) {
                j(it.next());
            }
            return this;
        }

        @t1.a
        public b<K, V> l(Map<? extends K, ? extends V> map) {
            return k(map.entrySet());
        }

        public b(int initialCapacity) {
            this.f5016b = new Object[initialCapacity * 2];
            this.f5017c = 0;
            this.f5018d = false;
        }
    }

    public static abstract class c<K, V> extends k3<K, V> {

        public class a extends l3<K, V> {
            public a() {
            }

            @Override // f1.l3
            public k3<K, V> map() {
                return c.this;
            }

            @Override // f1.t3, f1.e3, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, f1.n6
            public x7<Map.Entry<K, V>> iterator() {
                return c.this.entryIterator();
            }
        }

        @Override // f1.k3
        public t3<Map.Entry<K, V>> createEntrySet() {
            return new a();
        }

        @Override // f1.k3
        public t3<K> createKeySet() {
            return new m3(this);
        }

        @Override // f1.k3
        public e3<V> createValues() {
            return new n3(this);
        }

        public abstract x7<Map.Entry<K, V>> entryIterator();

        @Override // f1.k3, java.util.Map
        public /* bridge */ /* synthetic */ Set entrySet() {
            return super.entrySet();
        }

        @Override // f1.k3, java.util.Map
        public /* bridge */ /* synthetic */ Set keySet() {
            return super.keySet();
        }

        @Override // f1.k3, java.util.Map, f1.w
        public /* bridge */ /* synthetic */ Collection values() {
            return super.values();
        }
    }

    public final class d extends c<K, t3<V>> {

        public class a extends x7<Map.Entry<K, t3<V>>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Iterator f5023a;

            /* JADX INFO: renamed from: f1.k3$d$a$a, reason: collision with other inner class name */
            public class C0115a extends g<K, t3<V>> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ Map.Entry f5024a;

                public C0115a(final a this$2, final Map.Entry val$backingEntry) {
                    this.f5024a = val$backingEntry;
                }

                @Override // f1.g, java.util.Map.Entry
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public t3<V> getValue() {
                    return t3.of(this.f5024a.getValue());
                }

                @Override // f1.g, java.util.Map.Entry
                public K getKey() {
                    return (K) this.f5024a.getKey();
                }
            }

            public a(final d this$1, final Iterator val$backingIterator) {
                this.f5023a = val$backingIterator;
            }

            @Override // java.util.Iterator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map.Entry<K, t3<V>> next() {
                return new C0115a(this, (Map.Entry) this.f5023a.next());
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f5023a.hasNext();
            }
        }

        public d() {
        }

        @Override // f1.k3, java.util.Map
        public boolean containsKey(@gm.a Object key) {
            return k3.this.containsKey(key);
        }

        @Override // f1.k3.c, f1.k3
        public t3<K> createKeySet() {
            return k3.this.keySet();
        }

        @Override // f1.k3.c
        public x7<Map.Entry<K, t3<V>>> entryIterator() {
            return new a(this, k3.this.entrySet().iterator());
        }

        @Override // f1.k3, java.util.Map
        public int hashCode() {
            return k3.this.hashCode();
        }

        @Override // f1.k3
        public boolean isHashCodeFast() {
            return k3.this.isHashCodeFast();
        }

        @Override // f1.k3
        public boolean isPartialView() {
            return k3.this.isPartialView();
        }

        @Override // java.util.Map
        public int size() {
            return k3.this.size();
        }

        public /* synthetic */ d(k3 k3Var, a aVar) {
            this();
        }

        @Override // f1.k3, java.util.Map
        @gm.a
        public t3<V> get(@gm.a Object key) {
            Object obj = k3.this.get(key);
            if (obj == null) {
                return null;
            }
            return t3.of(obj);
        }
    }

    @b1.d
    public static class e<K, V> implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final boolean f5025a = true;
        private static final long serialVersionUID = 0;
        private final Object keys;
        private final Object values;

        public e(k3<K, V> map) {
            Object[] objArr = new Object[map.size()];
            Object[] objArr2 = new Object[map.size()];
            x7<Map.Entry<K, V>> it = map.entrySet().iterator();
            int i10 = 0;
            while (it.hasNext()) {
                Map.Entry<K, V> next = it.next();
                objArr[i10] = next.getKey();
                objArr2[i10] = next.getValue();
                i10++;
            }
            this.keys = objArr;
            this.values = objArr2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final Object legacyReadResolve() {
            Object[] objArr = (Object[]) this.keys;
            Object[] objArr2 = (Object[]) this.values;
            b<K, V> bVarMakeBuilder = makeBuilder(objArr.length);
            for (int i10 = 0; i10 < objArr.length; i10++) {
                bVarMakeBuilder.i(objArr[i10], objArr2[i10]);
            }
            return bVarMakeBuilder.d();
        }

        public b<K, V> makeBuilder(int size) {
            return new b<>(size);
        }

        public final Object readResolve() {
            Object obj = this.keys;
            if (!(obj instanceof t3)) {
                return legacyReadResolve();
            }
            t3 t3Var = (t3) obj;
            e3 e3Var = (e3) this.values;
            b<K, V> bVarMakeBuilder = makeBuilder(t3Var.size());
            x7 it = t3Var.iterator();
            x7 it2 = e3Var.iterator();
            while (it.hasNext()) {
                bVarMakeBuilder.i(it.next(), it2.next());
            }
            return bVarMakeBuilder.d();
        }
    }

    public static <K, V> b<K, V> builder() {
        return new b<>(4);
    }

    public static <K, V> b<K, V> builderWithExpectedSize(int expectedSize) {
        b0.b(expectedSize, "expectedSize");
        return new b<>(expectedSize);
    }

    public static void checkNoConflict(boolean safe, String conflictDescription, Object entry1, Object entry2) {
        if (!safe) {
            throw conflictException(conflictDescription, entry1, entry2);
        }
    }

    public static IllegalArgumentException conflictException(String conflictDescription, Object entry1, Object entry2) {
        return new IllegalArgumentException("Multiple entries with same " + conflictDescription + ": " + entry1 + " and " + entry2);
    }

    public static <K, V> k3<K, V> copyOf(Map<? extends K, ? extends V> map) {
        if ((map instanceof k3) && !(map instanceof SortedMap)) {
            k3<K, V> k3Var = (k3) map;
            if (!k3Var.isPartialView()) {
                return k3Var;
            }
        }
        return copyOf(map.entrySet());
    }

    public static <K, V> Map.Entry<K, V> entryOf(K key, V value) {
        b0.a(key, value);
        return new AbstractMap.SimpleImmutableEntry(key, value);
    }

    public static <K, V> k3<K, V> of() {
        return (k3<K, V>) y5.EMPTY;
    }

    @SafeVarargs
    public static <K, V> k3<K, V> ofEntries(Map.Entry<? extends K, ? extends V>... entries) {
        return copyOf(Arrays.asList(entries));
    }

    @b1.d
    private void readObject(ObjectInputStream stream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public u3<K, V> asMultimap() {
        if (isEmpty()) {
            return u3.of();
        }
        u3<K, V> u3Var = this.f5013d;
        if (u3Var != null) {
            return u3Var;
        }
        u3<K, V> u3Var2 = new u3<>(new d(this, null), size(), null);
        this.f5013d = u3Var2;
        return u3Var2;
    }

    @Override // java.util.Map
    @t1.e("Always throws UnsupportedOperationException")
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public boolean containsKey(@gm.a Object key) {
        return get(key) != null;
    }

    @Override // java.util.Map
    public boolean containsValue(@gm.a Object value) {
        return values().contains(value);
    }

    public abstract t3<Map.Entry<K, V>> createEntrySet();

    public abstract t3<K> createKeySet();

    public abstract e3<V> createValues();

    @Override // java.util.Map
    public boolean equals(@gm.a Object object) {
        return t4.w(this, object);
    }

    @Override // java.util.Map
    @gm.a
    public abstract V get(@gm.a Object key);

    @Override // java.util.Map
    @gm.a
    public final V getOrDefault(@gm.a Object key, @gm.a V defaultValue) {
        V v10 = get(key);
        return v10 != null ? v10 : defaultValue;
    }

    @Override // java.util.Map
    public int hashCode() {
        return k6.k(entrySet());
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean isHashCodeFast() {
        return false;
    }

    public abstract boolean isPartialView();

    public x7<K> keyIterator() {
        return new a(this, entrySet().iterator());
    }

    @Override // java.util.Map
    @gm.a
    @t1.a
    @Deprecated
    @t1.e("Always throws UnsupportedOperationException")
    public final V put(K k10, V v10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @t1.e("Always throws UnsupportedOperationException")
    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @gm.a
    @t1.a
    @Deprecated
    public final V remove(@gm.a Object o10) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return t4.w0(this);
    }

    @b1.d
    public Object writeReplace() {
        return new e(this);
    }

    public static <K, V> k3<K, V> of(K k10, V v10) {
        b0.a(k10, v10);
        return y5.create(1, new Object[]{k10, v10});
    }

    @Override // java.util.Map
    public t3<Map.Entry<K, V>> entrySet() {
        t3<Map.Entry<K, V>> t3Var = this.f5010a;
        if (t3Var != null) {
            return t3Var;
        }
        t3<Map.Entry<K, V>> t3VarCreateEntrySet = createEntrySet();
        this.f5010a = t3VarCreateEntrySet;
        return t3VarCreateEntrySet;
    }

    @Override // java.util.Map
    public t3<K> keySet() {
        t3<K> t3Var = this.f5011b;
        if (t3Var != null) {
            return t3Var;
        }
        t3<K> t3VarCreateKeySet = createKeySet();
        this.f5011b = t3VarCreateKeySet;
        return t3VarCreateKeySet;
    }

    @Override // java.util.Map, f1.w
    public e3<V> values() {
        e3<V> e3Var = this.f5012c;
        if (e3Var != null) {
            return e3Var;
        }
        e3<V> e3VarCreateValues = createValues();
        this.f5012c = e3VarCreateValues;
        return e3VarCreateValues;
    }

    public static <K, V> k3<K, V> of(K k10, V v10, K k11, V v11) {
        b0.a(k10, v10);
        b0.a(k11, v11);
        return y5.create(2, new Object[]{k10, v10, k11, v11});
    }

    public static <K, V> k3<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> entries) {
        b bVar = new b(entries instanceof Collection ? ((Collection) entries).size() : 4);
        bVar.k(entries);
        return bVar.d();
    }

    public static <K, V> k3<K, V> of(K k10, V v10, K k11, V v11, K k12, V v12) {
        b0.a(k10, v10);
        b0.a(k11, v11);
        b0.a(k12, v12);
        return y5.create(3, new Object[]{k10, v10, k11, v11, k12, v12});
    }

    public static <K, V> k3<K, V> of(K k10, V v10, K k11, V v11, K k12, V v12, K k13, V v13) {
        b0.a(k10, v10);
        b0.a(k11, v11);
        b0.a(k12, v12);
        b0.a(k13, v13);
        return y5.create(4, new Object[]{k10, v10, k11, v11, k12, v12, k13, v13});
    }

    public static <K, V> k3<K, V> of(K k10, V v10, K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14) {
        b0.a(k10, v10);
        b0.a(k11, v11);
        b0.a(k12, v12);
        b0.a(k13, v13);
        b0.a(k14, v14);
        return y5.create(5, new Object[]{k10, v10, k11, v11, k12, v12, k13, v13, k14, v14});
    }

    public static <K, V> k3<K, V> of(K k10, V v10, K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14, K k15, V v15) {
        b0.a(k10, v10);
        b0.a(k11, v11);
        b0.a(k12, v12);
        b0.a(k13, v13);
        b0.a(k14, v14);
        b0.a(k15, v15);
        return y5.create(6, new Object[]{k10, v10, k11, v11, k12, v12, k13, v13, k14, v14, k15, v15});
    }

    public static <K, V> k3<K, V> of(K k10, V v10, K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14, K k15, V v15, K k16, V v16) {
        b0.a(k10, v10);
        b0.a(k11, v11);
        b0.a(k12, v12);
        b0.a(k13, v13);
        b0.a(k14, v14);
        b0.a(k15, v15);
        b0.a(k16, v16);
        return y5.create(7, new Object[]{k10, v10, k11, v11, k12, v12, k13, v13, k14, v14, k15, v15, k16, v16});
    }

    public static <K, V> k3<K, V> of(K k10, V v10, K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14, K k15, V v15, K k16, V v16, K k17, V v17) {
        b0.a(k10, v10);
        b0.a(k11, v11);
        b0.a(k12, v12);
        b0.a(k13, v13);
        b0.a(k14, v14);
        b0.a(k15, v15);
        b0.a(k16, v16);
        b0.a(k17, v17);
        return y5.create(8, new Object[]{k10, v10, k11, v11, k12, v12, k13, v13, k14, v14, k15, v15, k16, v16, k17, v17});
    }

    public static <K, V> k3<K, V> of(K k10, V v10, K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14, K k15, V v15, K k16, V v16, K k17, V v17, K k18, V v18) {
        b0.a(k10, v10);
        b0.a(k11, v11);
        b0.a(k12, v12);
        b0.a(k13, v13);
        b0.a(k14, v14);
        b0.a(k15, v15);
        b0.a(k16, v16);
        b0.a(k17, v17);
        b0.a(k18, v18);
        return y5.create(9, new Object[]{k10, v10, k11, v11, k12, v12, k13, v13, k14, v14, k15, v15, k16, v16, k17, v17, k18, v18});
    }

    public static <K, V> k3<K, V> of(K k10, V v10, K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14, K k15, V v15, K k16, V v16, K k17, V v17, K k18, V v18, K k19, V v19) {
        b0.a(k10, v10);
        b0.a(k11, v11);
        b0.a(k12, v12);
        b0.a(k13, v13);
        b0.a(k14, v14);
        b0.a(k15, v15);
        b0.a(k16, v16);
        b0.a(k17, v17);
        b0.a(k18, v18);
        b0.a(k19, v19);
        return y5.create(10, new Object[]{k10, v10, k11, v11, k12, v12, k13, v13, k14, v14, k15, v15, k16, v16, k17, v17, k18, v18, k19, v19});
    }
}
