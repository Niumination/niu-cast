package f1;

import com.google.j2objc.annotations.RetainedWith;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
public final class v2<K, V> extends AbstractMap<K, V> implements w<K, V>, Serializable {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f5450x = -1;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f5451y = -2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient int[] f5452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient int[] f5453b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient int[] f5454c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public transient int[] f5455d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public transient int f5456e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public transient int f5457f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public transient int[] f5458g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public transient int[] f5459i;
    transient K[] keys;
    transient int modCount;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @u1.b
    public transient Set<K> f5460n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @u1.b
    public transient Set<V> f5461p;
    transient int size;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @u1.b
    public transient Set<Map.Entry<K, V>> f5462v;
    transient V[] values;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @u1.b
    @RetainedWith
    @gm.a
    public transient w<V, K> f5463w;

    public final class a extends f1.g<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @m5
        public final K f5464a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f5465b;

        public a(int index) {
            this.f5464a = v2.this.keys[index];
            this.f5465b = index;
        }

        public void a() {
            int i10 = this.f5465b;
            if (i10 != -1) {
                v2 v2Var = v2.this;
                if (i10 <= v2Var.size && c1.b0.a(v2Var.keys[i10], this.f5464a)) {
                    return;
                }
            }
            this.f5465b = v2.this.findEntryByKey(this.f5464a);
        }

        @Override // f1.g, java.util.Map.Entry
        @m5
        public K getKey() {
            return this.f5464a;
        }

        @Override // f1.g, java.util.Map.Entry
        @m5
        public V getValue() {
            a();
            int i10 = this.f5465b;
            if (i10 == -1) {
                return null;
            }
            return v2.this.values[i10];
        }

        @Override // f1.g, java.util.Map.Entry
        @m5
        public V setValue(@m5 V value) {
            a();
            int i10 = this.f5465b;
            if (i10 == -1) {
                v2.this.put(this.f5464a, value);
                return null;
            }
            V v10 = v2.this.values[i10];
            if (c1.b0.a(v10, value)) {
                return value;
            }
            v2.this.p(this.f5465b, value, false);
            return v10;
        }
    }

    public static final class b<K, V> extends f1.g<V, K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final v2<K, V> f5467a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @m5
        public final V f5468b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f5469c;

        public b(v2<K, V> biMap, int index) {
            this.f5467a = biMap;
            this.f5468b = biMap.values[index];
            this.f5469c = index;
        }

        private void a() {
            int i10 = this.f5469c;
            if (i10 != -1) {
                v2<K, V> v2Var = this.f5467a;
                if (i10 <= v2Var.size && c1.b0.a(this.f5468b, v2Var.values[i10])) {
                    return;
                }
            }
            this.f5469c = this.f5467a.findEntryByValue(this.f5468b);
        }

        @Override // f1.g, java.util.Map.Entry
        @m5
        public V getKey() {
            return this.f5468b;
        }

        @Override // f1.g, java.util.Map.Entry
        @m5
        public K getValue() {
            a();
            int i10 = this.f5469c;
            if (i10 == -1) {
                return null;
            }
            return this.f5467a.keys[i10];
        }

        @Override // f1.g, java.util.Map.Entry
        @m5
        public K setValue(@m5 K key) {
            a();
            int i10 = this.f5469c;
            if (i10 == -1) {
                this.f5467a.putInverse(this.f5468b, key, false);
                return null;
            }
            K k10 = this.f5467a.keys[i10];
            if (c1.b0.a(k10, key)) {
                return key;
            }
            this.f5467a.m(this.f5469c, key, false);
            return k10;
        }
    }

    public final class c extends h<K, V, Map.Entry<K, V>> {
        public c() {
            super(v2.this);
        }

        @Override // f1.v2.h
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> a(int entry) {
            return new a(entry);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@gm.a Object o10) {
            if (!(o10 instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) o10;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int iFindEntryByKey = v2.this.findEntryByKey(key);
            return iFindEntryByKey != -1 && c1.b0.a(value, v2.this.values[iFindEntryByKey]);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @t1.a
        public boolean remove(@gm.a Object o10) {
            if (!(o10 instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) o10;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int iD = z2.d(key);
            int iFindEntryByKey = v2.this.findEntryByKey(key, iD);
            if (iFindEntryByKey == -1 || !c1.b0.a(value, v2.this.values[iFindEntryByKey])) {
                return false;
            }
            v2.this.removeEntryKeyHashKnown(iFindEntryByKey, iD);
            return true;
        }
    }

    public static class d<K, V> extends AbstractMap<V, K> implements w<V, K>, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public transient Set<Map.Entry<V, K>> f5471a;
        private final v2<K, V> forward;

        public d(v2<K, V> forward) {
            this.forward = forward;
        }

        @b1.c("serialization")
        private void readObject(ObjectInputStream in2) throws ClassNotFoundException, IOException {
            in2.defaultReadObject();
            this.forward.f5463w = this;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            this.forward.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@gm.a Object key) {
            return this.forward.containsValue(key);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsValue(@gm.a Object value) {
            return this.forward.containsKey(value);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<V, K>> entrySet() {
            Set<Map.Entry<V, K>> set = this.f5471a;
            if (set != null) {
                return set;
            }
            e eVar = new e(this.forward);
            this.f5471a = eVar;
            return eVar;
        }

        @Override // f1.w
        @gm.a
        @t1.a
        public K forcePut(@m5 V value, @m5 K key) {
            return this.forward.putInverse(value, key, true);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @gm.a
        public K get(@gm.a Object key) {
            return this.forward.getInverse(key);
        }

        @Override // f1.w
        public w<K, V> inverse() {
            return this.forward;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<V> keySet() {
            return this.forward.values();
        }

        @Override // java.util.AbstractMap, java.util.Map, f1.w
        @gm.a
        @t1.a
        public K put(@m5 V value, @m5 K key) {
            return this.forward.putInverse(value, key, false);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @gm.a
        @t1.a
        public K remove(@gm.a Object value) {
            return this.forward.removeInverse(value);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.forward.size;
        }

        @Override // java.util.AbstractMap, java.util.Map, f1.w
        public Set<K> values() {
            return this.forward.keySet();
        }
    }

    public static class e<K, V> extends h<K, V, Map.Entry<V, K>> {
        public e(v2<K, V> biMap) {
            super(biMap);
        }

        @Override // f1.v2.h
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry<V, K> a(int entry) {
            return new b(this.f5474a, entry);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@gm.a Object o10) {
            if (!(o10 instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) o10;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int iFindEntryByValue = this.f5474a.findEntryByValue(key);
            return iFindEntryByValue != -1 && c1.b0.a(this.f5474a.keys[iFindEntryByValue], value);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@gm.a Object o10) {
            if (!(o10 instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) o10;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int iD = z2.d(key);
            int iFindEntryByValue = this.f5474a.findEntryByValue(key, iD);
            if (iFindEntryByValue == -1 || !c1.b0.a(this.f5474a.keys[iFindEntryByValue], value)) {
                return false;
            }
            this.f5474a.removeEntryValueHashKnown(iFindEntryByValue, iD);
            return true;
        }
    }

    public final class f extends h<K, V, K> {
        public f() {
            super(v2.this);
        }

        @Override // f1.v2.h
        @m5
        public K a(int entry) {
            return v2.this.keys[entry];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@gm.a Object o10) {
            return v2.this.containsKey(o10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@gm.a Object o10) {
            int iD = z2.d(o10);
            int iFindEntryByKey = v2.this.findEntryByKey(o10, iD);
            if (iFindEntryByKey == -1) {
                return false;
            }
            v2.this.removeEntryKeyHashKnown(iFindEntryByKey, iD);
            return true;
        }
    }

    public final class g extends h<K, V, V> {
        public g() {
            super(v2.this);
        }

        @Override // f1.v2.h
        @m5
        public V a(int entry) {
            return v2.this.values[entry];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@gm.a Object o10) {
            return v2.this.containsValue(o10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@gm.a Object o10) {
            int iD = z2.d(o10);
            int iFindEntryByValue = v2.this.findEntryByValue(o10, iD);
            if (iFindEntryByValue == -1) {
                return false;
            }
            v2.this.removeEntryValueHashKnown(iFindEntryByValue, iD);
            return true;
        }
    }

    public static abstract class h<K, V, T> extends AbstractSet<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final v2<K, V> f5474a;

        public class a implements Iterator<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f5475a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f5476b = -1;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f5477c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f5478d;

            public a() {
                this.f5475a = h.this.f5474a.f5456e;
                v2<K, V> v2Var = h.this.f5474a;
                this.f5477c = v2Var.modCount;
                this.f5478d = v2Var.size;
            }

            public final void a() {
                if (h.this.f5474a.modCount != this.f5477c) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                a();
                return this.f5475a != -2 && this.f5478d > 0;
            }

            @Override // java.util.Iterator
            @m5
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T t10 = (T) h.this.a(this.f5475a);
                this.f5476b = this.f5475a;
                this.f5475a = h.this.f5474a.f5459i[this.f5475a];
                this.f5478d--;
                return t10;
            }

            @Override // java.util.Iterator
            public void remove() {
                a();
                b0.e(this.f5476b != -1);
                h.this.f5474a.removeEntry(this.f5476b);
                int i10 = this.f5475a;
                v2<K, V> v2Var = h.this.f5474a;
                if (i10 == v2Var.size) {
                    this.f5475a = this.f5476b;
                }
                this.f5476b = -1;
                this.f5477c = v2Var.modCount;
            }
        }

        public h(v2<K, V> biMap) {
            this.f5474a = biMap;
        }

        @m5
        public abstract T a(int entry);

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.f5474a.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<T> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f5474a.size;
        }
    }

    public v2(int expectedSize) {
        init(expectedSize);
    }

    public static int[] c(int size) {
        int[] iArr = new int[size];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    public static <K, V> v2<K, V> create() {
        return create(16);
    }

    public static int[] g(int[] array, int newSize) {
        int length = array.length;
        int[] iArrCopyOf = Arrays.copyOf(array, newSize);
        Arrays.fill(iArrCopyOf, length, newSize, -1);
        return iArrCopyOf;
    }

    @b1.c
    @b1.d
    private void readObject(ObjectInputStream stream) throws ClassNotFoundException, IOException {
        stream.defaultReadObject();
        int i10 = stream.readInt();
        init(16);
        i6.c(this, stream, i10);
    }

    @b1.c
    @b1.d
    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        i6.i(this, stream);
    }

    public final int a(int hash) {
        return (this.f5452a.length - 1) & hash;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Arrays.fill(this.keys, 0, this.size, (Object) null);
        Arrays.fill(this.values, 0, this.size, (Object) null);
        Arrays.fill(this.f5452a, -1);
        Arrays.fill(this.f5453b, -1);
        Arrays.fill(this.f5454c, 0, this.size, -1);
        Arrays.fill(this.f5455d, 0, this.size, -1);
        Arrays.fill(this.f5458g, 0, this.size, -1);
        Arrays.fill(this.f5459i, 0, this.size, -1);
        this.size = 0;
        this.f5456e = -2;
        this.f5457f = -2;
        this.modCount++;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(@gm.a Object key) {
        return findEntryByKey(key) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(@gm.a Object value) {
        return findEntryByValue(value) != -1;
    }

    public final void d(int entry, int keyHash) {
        c1.h0.d(entry != -1);
        int iA = a(keyHash);
        int[] iArr = this.f5452a;
        int i10 = iArr[iA];
        if (i10 == entry) {
            int[] iArr2 = this.f5454c;
            iArr[iA] = iArr2[entry];
            iArr2[entry] = -1;
            return;
        }
        int i11 = this.f5454c[i10];
        while (true) {
            int i12 = i10;
            i10 = i11;
            if (i10 == -1) {
                throw new AssertionError("Expected to find entry with key " + this.keys[entry]);
            }
            if (i10 == entry) {
                int[] iArr3 = this.f5454c;
                iArr3[i12] = iArr3[entry];
                iArr3[entry] = -1;
                return;
            }
            i11 = this.f5454c[i10];
        }
    }

    public final void e(int entry, int valueHash) {
        c1.h0.d(entry != -1);
        int iA = a(valueHash);
        int[] iArr = this.f5453b;
        int i10 = iArr[iA];
        if (i10 == entry) {
            int[] iArr2 = this.f5455d;
            iArr[iA] = iArr2[entry];
            iArr2[entry] = -1;
            return;
        }
        int i11 = this.f5455d[i10];
        while (true) {
            int i12 = i10;
            i10 = i11;
            if (i10 == -1) {
                throw new AssertionError("Expected to find entry with value " + this.values[entry]);
            }
            if (i10 == entry) {
                int[] iArr3 = this.f5455d;
                iArr3[i12] = iArr3[entry];
                iArr3[entry] = -1;
                return;
            }
            i11 = this.f5455d[i10];
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.f5462v;
        if (set != null) {
            return set;
        }
        c cVar = new c();
        this.f5462v = cVar;
        return cVar;
    }

    public final void f(int i10) {
        int[] iArr = this.f5454c;
        if (iArr.length < i10) {
            int iF = e3.b.f(iArr.length, i10);
            this.keys = (K[]) Arrays.copyOf(this.keys, iF);
            this.values = (V[]) Arrays.copyOf(this.values, iF);
            this.f5454c = g(this.f5454c, iF);
            this.f5455d = g(this.f5455d, iF);
            this.f5458g = g(this.f5458g, iF);
            this.f5459i = g(this.f5459i, iF);
        }
        if (this.f5452a.length < i10) {
            int iA = z2.a(i10, 1.0d);
            this.f5452a = c(iA);
            this.f5453b = c(iA);
            for (int i11 = 0; i11 < this.size; i11++) {
                int iA2 = a(z2.d(this.keys[i11]));
                int[] iArr2 = this.f5454c;
                int[] iArr3 = this.f5452a;
                iArr2[i11] = iArr3[iA2];
                iArr3[iA2] = i11;
                int iA3 = a(z2.d(this.values[i11]));
                int[] iArr4 = this.f5455d;
                int[] iArr5 = this.f5453b;
                iArr4[i11] = iArr5[iA3];
                iArr5[iA3] = i11;
            }
        }
    }

    public int findEntry(@gm.a Object o10, int oHash, int[] hashTable, int[] nextInBucket, Object[] array) {
        int i10 = hashTable[a(oHash)];
        while (i10 != -1) {
            if (c1.b0.a(array[i10], o10)) {
                return i10;
            }
            i10 = nextInBucket[i10];
        }
        return -1;
    }

    public int findEntryByKey(@gm.a Object key) {
        return findEntryByKey(key, z2.d(key));
    }

    public int findEntryByValue(@gm.a Object value) {
        return findEntryByValue(value, z2.d(value));
    }

    @Override // f1.w
    @gm.a
    @t1.a
    public V forcePut(@m5 K key, @m5 V value) {
        return put(key, value, true);
    }

    @Override // java.util.AbstractMap, java.util.Map
    @gm.a
    public V get(@gm.a Object key) {
        int iFindEntryByKey = findEntryByKey(key);
        if (iFindEntryByKey == -1) {
            return null;
        }
        return this.values[iFindEntryByKey];
    }

    @gm.a
    public K getInverse(@gm.a Object value) {
        int iFindEntryByValue = findEntryByValue(value);
        if (iFindEntryByValue == -1) {
            return null;
        }
        return this.keys[iFindEntryByValue];
    }

    public final void h(int entry, int keyHash) {
        c1.h0.d(entry != -1);
        int iA = a(keyHash);
        int[] iArr = this.f5454c;
        int[] iArr2 = this.f5452a;
        iArr[entry] = iArr2[iA];
        iArr2[iA] = entry;
    }

    public final void i(int entry, int valueHash) {
        c1.h0.d(entry != -1);
        int iA = a(valueHash);
        int[] iArr = this.f5455d;
        int[] iArr2 = this.f5453b;
        iArr[entry] = iArr2[iA];
        iArr2[iA] = entry;
    }

    public void init(int i10) {
        b0.b(i10, "expectedSize");
        int iA = z2.a(i10, 1.0d);
        this.size = 0;
        this.keys = (K[]) new Object[i10];
        this.values = (V[]) new Object[i10];
        this.f5452a = c(iA);
        this.f5453b = c(iA);
        this.f5454c = c(i10);
        this.f5455d = c(i10);
        this.f5456e = -2;
        this.f5457f = -2;
        this.f5458g = c(i10);
        this.f5459i = c(i10);
    }

    @Override // f1.w
    public w<V, K> inverse() {
        w<V, K> wVar = this.f5463w;
        if (wVar != null) {
            return wVar;
        }
        d dVar = new d(this);
        this.f5463w = dVar;
        return dVar;
    }

    public final void j(int src, int dest) {
        int i10;
        int i11;
        if (src == dest) {
            return;
        }
        int i12 = this.f5458g[src];
        int i13 = this.f5459i[src];
        q(i12, dest);
        q(dest, i13);
        K[] kArr = this.keys;
        K k10 = kArr[src];
        V[] vArr = this.values;
        V v10 = vArr[src];
        kArr[dest] = k10;
        vArr[dest] = v10;
        int iA = a(z2.d(k10));
        int[] iArr = this.f5452a;
        int i14 = iArr[iA];
        if (i14 == src) {
            iArr[iA] = dest;
        } else {
            int i15 = this.f5454c[i14];
            while (true) {
                i10 = i14;
                i14 = i15;
                if (i14 == src) {
                    break;
                } else {
                    i15 = this.f5454c[i14];
                }
            }
            this.f5454c[i10] = dest;
        }
        int[] iArr2 = this.f5454c;
        iArr2[dest] = iArr2[src];
        iArr2[src] = -1;
        int iA2 = a(z2.d(v10));
        int[] iArr3 = this.f5453b;
        int i16 = iArr3[iA2];
        if (i16 == src) {
            iArr3[iA2] = dest;
        } else {
            int i17 = this.f5455d[i16];
            while (true) {
                i11 = i16;
                i16 = i17;
                if (i16 == src) {
                    break;
                } else {
                    i17 = this.f5455d[i16];
                }
            }
            this.f5455d[i11] = dest;
        }
        int[] iArr4 = this.f5455d;
        iArr4[dest] = iArr4[src];
        iArr4[src] = -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.f5460n;
        if (set != null) {
            return set;
        }
        f fVar = new f();
        this.f5460n = fVar;
        return fVar;
    }

    public final void l(int entry, int keyHash, int valueHash) {
        c1.h0.d(entry != -1);
        d(entry, keyHash);
        e(entry, valueHash);
        q(this.f5458g[entry], this.f5459i[entry]);
        j(this.size - 1, entry);
        K[] kArr = this.keys;
        int i10 = this.size;
        kArr[i10 - 1] = null;
        this.values[i10 - 1] = null;
        this.size = i10 - 1;
        this.modCount++;
    }

    public final void m(int entry, @m5 K newKey, boolean force) {
        int i10;
        c1.h0.d(entry != -1);
        int iD = z2.d(newKey);
        int iFindEntryByKey = findEntryByKey(newKey, iD);
        int i11 = this.f5457f;
        if (iFindEntryByKey == -1) {
            i10 = -2;
        } else {
            if (!force) {
                throw new IllegalArgumentException(c0.a.a("Key already present in map: ", newKey));
            }
            i11 = this.f5458g[iFindEntryByKey];
            i10 = this.f5459i[iFindEntryByKey];
            removeEntryKeyHashKnown(iFindEntryByKey, iD);
            if (entry == this.size) {
                entry = iFindEntryByKey;
            }
        }
        if (i11 == entry) {
            i11 = this.f5458g[entry];
        } else if (i11 == this.size) {
            i11 = iFindEntryByKey;
        }
        if (i10 == entry) {
            iFindEntryByKey = this.f5459i[entry];
        } else if (i10 != this.size) {
            iFindEntryByKey = i10;
        }
        q(this.f5458g[entry], this.f5459i[entry]);
        d(entry, z2.d(this.keys[entry]));
        this.keys[entry] = newKey;
        h(entry, z2.d(newKey));
        q(i11, entry);
        q(entry, iFindEntryByKey);
    }

    public final void p(int entry, @m5 V newValue, boolean force) {
        c1.h0.d(entry != -1);
        int iD = z2.d(newValue);
        int iFindEntryByValue = findEntryByValue(newValue, iD);
        if (iFindEntryByValue != -1) {
            if (!force) {
                throw new IllegalArgumentException(c0.a.a("Value already present in map: ", newValue));
            }
            removeEntryValueHashKnown(iFindEntryByValue, iD);
            if (entry == this.size) {
                entry = iFindEntryByValue;
            }
        }
        e(entry, z2.d(this.values[entry]));
        this.values[entry] = newValue;
        i(entry, iD);
    }

    @Override // java.util.AbstractMap, java.util.Map, f1.w
    @gm.a
    @t1.a
    public V put(@m5 K key, @m5 V value) {
        return put(key, value, false);
    }

    @gm.a
    @t1.a
    public K putInverse(@m5 V value, @m5 K key, boolean force) {
        int iD = z2.d(value);
        int iFindEntryByValue = findEntryByValue(value, iD);
        if (iFindEntryByValue != -1) {
            K k10 = this.keys[iFindEntryByValue];
            if (c1.b0.a(k10, key)) {
                return key;
            }
            m(iFindEntryByValue, key, force);
            return k10;
        }
        int i10 = this.f5457f;
        int iD2 = z2.d(key);
        int iFindEntryByKey = findEntryByKey(key, iD2);
        if (!force) {
            c1.h0.u(iFindEntryByKey == -1, "Key already present: %s", key);
        } else if (iFindEntryByKey != -1) {
            i10 = this.f5458g[iFindEntryByKey];
            removeEntryKeyHashKnown(iFindEntryByKey, iD2);
        }
        f(this.size + 1);
        K[] kArr = this.keys;
        int i11 = this.size;
        kArr[i11] = key;
        this.values[i11] = value;
        h(i11, iD2);
        i(this.size, iD);
        int i12 = i10 == -2 ? this.f5456e : this.f5459i[i10];
        q(i10, this.size);
        q(this.size, i12);
        this.size++;
        this.modCount++;
        return null;
    }

    public final void q(int prev, int next) {
        if (prev == -2) {
            this.f5456e = next;
        } else {
            this.f5459i[prev] = next;
        }
        if (next == -2) {
            this.f5457f = prev;
        } else {
            this.f5458g[next] = prev;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    @gm.a
    @t1.a
    public V remove(@gm.a Object key) {
        int iD = z2.d(key);
        int iFindEntryByKey = findEntryByKey(key, iD);
        if (iFindEntryByKey == -1) {
            return null;
        }
        V v10 = this.values[iFindEntryByKey];
        removeEntryKeyHashKnown(iFindEntryByKey, iD);
        return v10;
    }

    public void removeEntry(int entry) {
        removeEntryKeyHashKnown(entry, z2.d(this.keys[entry]));
    }

    public void removeEntryKeyHashKnown(int entry, int keyHash) {
        l(entry, keyHash, z2.d(this.values[entry]));
    }

    public void removeEntryValueHashKnown(int entry, int valueHash) {
        l(entry, z2.d(this.keys[entry]), valueHash);
    }

    @gm.a
    public K removeInverse(@gm.a Object value) {
        int iD = z2.d(value);
        int iFindEntryByValue = findEntryByValue(value, iD);
        if (iFindEntryByValue == -1) {
            return null;
        }
        K k10 = this.keys[iFindEntryByValue];
        removeEntryValueHashKnown(iFindEntryByValue, iD);
        return k10;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    public static <K, V> v2<K, V> create(int expectedSize) {
        return new v2<>(expectedSize);
    }

    public int findEntryByKey(@gm.a Object key, int keyHash) {
        return findEntry(key, keyHash, this.f5452a, this.f5454c, this.keys);
    }

    public int findEntryByValue(@gm.a Object value, int valueHash) {
        return findEntry(value, valueHash, this.f5453b, this.f5455d, this.values);
    }

    @gm.a
    public V put(@m5 K key, @m5 V value, boolean force) {
        int iD = z2.d(key);
        int iFindEntryByKey = findEntryByKey(key, iD);
        if (iFindEntryByKey != -1) {
            V v10 = this.values[iFindEntryByKey];
            if (c1.b0.a(v10, value)) {
                return value;
            }
            p(iFindEntryByKey, value, force);
            return v10;
        }
        int iD2 = z2.d(value);
        int iFindEntryByValue = findEntryByValue(value, iD2);
        if (!force) {
            c1.h0.u(iFindEntryByValue == -1, "Value already present: %s", value);
        } else if (iFindEntryByValue != -1) {
            removeEntryValueHashKnown(iFindEntryByValue, iD2);
        }
        f(this.size + 1);
        K[] kArr = this.keys;
        int i10 = this.size;
        kArr[i10] = key;
        this.values[i10] = value;
        h(i10, iD);
        i(this.size, iD2);
        q(this.f5457f, this.size);
        q(this.size, -2);
        this.size++;
        this.modCount++;
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map, f1.w
    public Set<V> values() {
        Set<V> set = this.f5461p;
        if (set != null) {
            return set;
        }
        g gVar = new g();
        this.f5461p = gVar;
        return gVar;
    }

    public static <K, V> v2<K, V> create(Map<? extends K, ? extends V> map) {
        v2<K, V> v2VarCreate = create(map.size());
        v2VarCreate.putAll(map);
        return v2VarCreate;
    }
}
