package f1;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@x0
public class d0<K, V> extends AbstractMap<K, V> implements Serializable {

    @b1.e
    static final double HASH_FLOODING_FPP = 0.001d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Object f4766g = new Object();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f4767i = 9;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @gm.a
    public transient Object f4768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient int f4769b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient int f4770c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @u1.b
    @gm.a
    public transient Set<K> f4771d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @u1.b
    @gm.a
    public transient Set<Map.Entry<K, V>> f4772e;

    @gm.a
    @b1.e
    transient int[] entries;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @u1.b
    @gm.a
    public transient Collection<V> f4773f;

    @gm.a
    @b1.e
    transient Object[] keys;

    @gm.a
    @b1.e
    transient Object[] values;

    public class a extends d0<K, V>.e<K> {
        public a() {
            super();
        }

        @Override // f1.d0.e
        @m5
        public K b(int i10) {
            return (K) d0.access$100(d0.this, i10);
        }
    }

    public class b extends d0<K, V>.e<Map.Entry<K, V>> {
        public b() {
            super();
        }

        @Override // f1.d0.e
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> b(int entry) {
            return new g(entry);
        }
    }

    public class c extends d0<K, V>.e<V> {
        public c() {
            super();
        }

        @Override // f1.d0.e
        @m5
        public V b(int i10) {
            return (V) d0.access$600(d0.this, i10);
        }
    }

    public class d extends AbstractSet<Map.Entry<K, V>> {
        public d() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            d0.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@gm.a Object o10) {
            Map<K, V> mapDelegateOrNull = d0.this.delegateOrNull();
            if (mapDelegateOrNull != null) {
                return mapDelegateOrNull.entrySet().contains(o10);
            }
            if (!(o10 instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) o10;
            int iD = d0.this.d(entry.getKey());
            return iD != -1 && c1.b0.a(d0.access$600(d0.this, iD), entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return d0.this.entrySetIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@gm.a Object o10) {
            Map<K, V> mapDelegateOrNull = d0.this.delegateOrNull();
            if (mapDelegateOrNull != null) {
                return mapDelegateOrNull.entrySet().remove(o10);
            }
            if (!(o10 instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) o10;
            if (d0.this.needsAllocArrays()) {
                return false;
            }
            int iC = d0.this.c();
            int iF = f0.f(entry.getKey(), entry.getValue(), iC, d0.access$800(d0.this), d0.this.g(), d0.this.h(), d0.this.j());
            if (iF == -1) {
                return false;
            }
            d0.this.moveLastEntry(iF, iC);
            d0.access$1210(d0.this);
            d0.this.incrementModCount();
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return d0.this.size();
        }
    }

    public class f extends AbstractSet<K> {
        public f() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            d0.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@gm.a Object o10) {
            return d0.this.containsKey(o10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return d0.this.keySetIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@gm.a Object o10) {
            Map<K, V> mapDelegateOrNull = d0.this.delegateOrNull();
            if (mapDelegateOrNull != null) {
                return mapDelegateOrNull.keySet().remove(o10);
            }
            return d0.this.f(o10) != d0.f4766g;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return d0.this.size();
        }
    }

    public final class g extends f1.g<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @m5
        public final K f4783a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f4784b;

        public g(int i10) {
            this.f4783a = (K) d0.access$100(d0.this, i10);
            this.f4784b = i10;
        }

        public final void a() {
            int i10 = this.f4784b;
            if (i10 == -1 || i10 >= d0.this.size() || !c1.b0.a(this.f4783a, d0.access$100(d0.this, this.f4784b))) {
                this.f4784b = d0.this.d(this.f4783a);
            }
        }

        @Override // f1.g, java.util.Map.Entry
        @m5
        public K getKey() {
            return this.f4783a;
        }

        @Override // f1.g, java.util.Map.Entry
        @m5
        public V getValue() {
            Map<K, V> mapDelegateOrNull = d0.this.delegateOrNull();
            if (mapDelegateOrNull != null) {
                return mapDelegateOrNull.get(this.f4783a);
            }
            a();
            int i10 = this.f4784b;
            if (i10 == -1) {
                return null;
            }
            return (V) d0.access$600(d0.this, i10);
        }

        @Override // f1.g, java.util.Map.Entry
        @m5
        public V setValue(@m5 V v10) {
            Map<K, V> mapDelegateOrNull = d0.this.delegateOrNull();
            if (mapDelegateOrNull != null) {
                return mapDelegateOrNull.put(this.f4783a, v10);
            }
            a();
            int i10 = this.f4784b;
            if (i10 == -1) {
                d0.this.put(this.f4783a, v10);
                return null;
            }
            V v11 = (V) d0.access$600(d0.this, i10);
            d0.this.s(this.f4784b, v10);
            return v11;
        }
    }

    public class h extends AbstractCollection<V> {
        public h() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            d0.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return d0.this.valuesIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return d0.this.size();
        }
    }

    public d0() {
        init(3);
    }

    public static Object access$100(d0 d0Var, int i10) {
        return d0Var.h()[i10];
    }

    public static /* synthetic */ int access$1210(d0 d0Var) {
        int i10 = d0Var.f4770c;
        d0Var.f4770c = i10 - 1;
        return i10;
    }

    public static Object access$600(d0 d0Var, int i10) {
        return d0Var.j()[i10];
    }

    public static Object access$800(d0 d0Var) {
        Object obj = d0Var.f4768a;
        Objects.requireNonNull(obj);
        return obj;
    }

    public static <K, V> d0<K, V> create() {
        return new d0<>();
    }

    public static <K, V> d0<K, V> createWithExpectedSize(int expectedSize) {
        return new d0<>(expectedSize);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @b1.d
    private void readObject(ObjectInputStream stream) throws ClassNotFoundException, IOException {
        stream.defaultReadObject();
        int i10 = stream.readInt();
        if (i10 < 0) {
            throw new InvalidObjectException(h.a.a("Invalid size: ", i10));
        }
        init(i10);
        for (int i11 = 0; i11 < i10; i11++) {
            put(stream.readObject(), stream.readObject());
        }
    }

    @b1.d
    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeInt(size());
        Iterator<Map.Entry<K, V>> itEntrySetIterator = entrySetIterator();
        while (itEntrySetIterator.hasNext()) {
            Map.Entry<K, V> next = itEntrySetIterator.next();
            stream.writeObject(next.getKey());
            stream.writeObject(next.getValue());
        }
    }

    public final int a(int i10) {
        return g()[i10];
    }

    public void accessEntry(int index) {
    }

    public int adjustAfterRemove(int indexBeforeRemove, int indexRemoved) {
        return indexBeforeRemove - 1;
    }

    @t1.a
    public int allocArrays() {
        c1.h0.h0(needsAllocArrays(), "Arrays already allocated");
        int i10 = this.f4769b;
        int iJ = f0.j(i10);
        this.f4768a = f0.a(iJ);
        q(iJ - 1);
        this.entries = new int[i10];
        this.keys = new Object[i10];
        this.values = new Object[i10];
        return i10;
    }

    public final int c() {
        return (1 << (this.f4769b & 31)) - 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        if (needsAllocArrays()) {
            return;
        }
        incrementModCount();
        Map<K, V> mapDelegateOrNull = delegateOrNull();
        if (mapDelegateOrNull != null) {
            this.f4769b = o1.l.g(size(), 3, 1073741823);
            mapDelegateOrNull.clear();
            this.f4768a = null;
            this.f4770c = 0;
            return;
        }
        Arrays.fill(h(), 0, this.f4770c, (Object) null);
        Arrays.fill(j(), 0, this.f4770c, (Object) null);
        Object obj = this.f4768a;
        Objects.requireNonNull(obj);
        f0.g(obj);
        Arrays.fill(g(), 0, this.f4770c, 0);
        this.f4770c = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(@gm.a Object key) {
        Map<K, V> mapDelegateOrNull = delegateOrNull();
        if (mapDelegateOrNull != null) {
            return mapDelegateOrNull.containsKey(key);
        }
        return d(key) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(@gm.a Object value) {
        Map<K, V> mapDelegateOrNull = delegateOrNull();
        if (mapDelegateOrNull != null) {
            return mapDelegateOrNull.containsValue(value);
        }
        for (int i10 = 0; i10 < this.f4770c; i10++) {
            if (c1.b0.a(value, j()[i10])) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @t1.a
    @b1.e
    public Map<K, V> convertToHashFloodingResistantImplementation() {
        Map<K, V> mapCreateHashFloodingResistantDelegate = createHashFloodingResistantDelegate(c() + 1);
        int iFirstEntryIndex = firstEntryIndex();
        while (iFirstEntryIndex >= 0) {
            mapCreateHashFloodingResistantDelegate.put(h()[iFirstEntryIndex], j()[iFirstEntryIndex]);
            iFirstEntryIndex = getSuccessor(iFirstEntryIndex);
        }
        this.f4768a = mapCreateHashFloodingResistantDelegate;
        this.entries = null;
        this.keys = null;
        this.values = null;
        incrementModCount();
        return mapCreateHashFloodingResistantDelegate;
    }

    public Set<Map.Entry<K, V>> createEntrySet() {
        return new d();
    }

    public Map<K, V> createHashFloodingResistantDelegate(int tableSize) {
        return new LinkedHashMap(tableSize, 1.0f);
    }

    public Set<K> createKeySet() {
        return new f();
    }

    public Collection<V> createValues() {
        return new h();
    }

    public final int d(@gm.a Object key) {
        if (needsAllocArrays()) {
            return -1;
        }
        int iD = z2.d(key);
        int iC = c();
        Object obj = this.f4768a;
        Objects.requireNonNull(obj);
        int iH = f0.h(obj, iD & iC);
        if (iH == 0) {
            return -1;
        }
        int i10 = ~iC;
        int i11 = iD & i10;
        do {
            int i12 = iH - 1;
            int i13 = g()[i12];
            if ((i13 & i10) == i11 && c1.b0.a(key, h()[i12])) {
                return i12;
            }
            iH = i13 & iC;
        } while (iH != 0);
        return -1;
    }

    @gm.a
    @b1.e
    public Map<K, V> delegateOrNull() {
        Object obj = this.f4768a;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    public final K e(int i10) {
        return (K) h()[i10];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.f4772e;
        if (set != null) {
            return set;
        }
        Set<Map.Entry<K, V>> setCreateEntrySet = createEntrySet();
        this.f4772e = setCreateEntrySet;
        return setCreateEntrySet;
    }

    public Iterator<Map.Entry<K, V>> entrySetIterator() {
        Map<K, V> mapDelegateOrNull = delegateOrNull();
        return mapDelegateOrNull != null ? mapDelegateOrNull.entrySet().iterator() : new b();
    }

    public final Object f(@gm.a Object key) {
        if (needsAllocArrays()) {
            return f4766g;
        }
        int iC = c();
        Object obj = this.f4768a;
        Objects.requireNonNull(obj);
        int iF = f0.f(key, null, iC, obj, g(), h(), null);
        if (iF == -1) {
            return f4766g;
        }
        Object obj2 = j()[iF];
        moveLastEntry(iF, iC);
        this.f4770c--;
        incrementModCount();
        return obj2;
    }

    public int firstEntryIndex() {
        return isEmpty() ? -1 : 0;
    }

    public final int[] g() {
        int[] iArr = this.entries;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @gm.a
    public V get(@gm.a Object obj) {
        Map<K, V> mapDelegateOrNull = delegateOrNull();
        if (mapDelegateOrNull != null) {
            return mapDelegateOrNull.get(obj);
        }
        int iD = d(obj);
        if (iD == -1) {
            return null;
        }
        accessEntry(iD);
        return (V) j()[iD];
    }

    public int getSuccessor(int entryIndex) {
        int i10 = entryIndex + 1;
        if (i10 < this.f4770c) {
            return i10;
        }
        return -1;
    }

    public final Object[] h() {
        Object[] objArr = this.keys;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    public final Object i() {
        Object obj = this.f4768a;
        Objects.requireNonNull(obj);
        return obj;
    }

    public void incrementModCount() {
        this.f4769b += 32;
    }

    public void init(int expectedSize) {
        c1.h0.e(expectedSize >= 0, "Expected size must be >= 0");
        this.f4769b = o1.l.g(expectedSize, 1, 1073741823);
    }

    public void insertEntry(int entryIndex, @m5 K key, @m5 V value, int hash, int mask) {
        p(entryIndex, f0.d(hash, 0, mask));
        r(entryIndex, key);
        s(entryIndex, value);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    public final Object[] j() {
        Object[] objArr = this.values;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.f4771d;
        if (set != null) {
            return set;
        }
        Set<K> setCreateKeySet = createKeySet();
        this.f4771d = setCreateKeySet;
        return setCreateKeySet;
    }

    public Iterator<K> keySetIterator() {
        Map<K, V> mapDelegateOrNull = delegateOrNull();
        return mapDelegateOrNull != null ? mapDelegateOrNull.keySet().iterator() : new a();
    }

    public final void l(int newSize) {
        int iMin;
        int length = g().length;
        if (newSize <= length || (iMin = Math.min(1073741823, (Math.max(1, length >>> 1) + length) | 1)) == length) {
            return;
        }
        resizeEntries(iMin);
    }

    @t1.a
    public final int m(int oldMask, int newCapacity, int targetHash, int targetEntryIndex) {
        Object objA = f0.a(newCapacity);
        int i10 = newCapacity - 1;
        if (targetEntryIndex != 0) {
            f0.i(objA, targetHash & i10, targetEntryIndex + 1);
        }
        Object obj = this.f4768a;
        Objects.requireNonNull(obj);
        int[] iArrG = g();
        for (int i11 = 0; i11 <= oldMask; i11++) {
            int iH = f0.h(obj, i11);
            while (iH != 0) {
                int i12 = iH - 1;
                int i13 = iArrG[i12];
                int i14 = ((~oldMask) & i13) | i11;
                int i15 = i14 & i10;
                int iH2 = f0.h(objA, i15);
                f0.i(objA, i15, iH);
                iArrG[i12] = f0.d(i14, iH2, i10);
                iH = i13 & oldMask;
            }
        }
        this.f4768a = objA;
        q(i10);
        return i10;
    }

    public void moveLastEntry(int dstIndex, int mask) {
        Object obj = this.f4768a;
        Objects.requireNonNull(obj);
        int[] iArrG = g();
        Object[] objArrH = h();
        Object[] objArrJ = j();
        int size = size();
        int i10 = size - 1;
        if (dstIndex >= i10) {
            objArrH[dstIndex] = null;
            objArrJ[dstIndex] = null;
            iArrG[dstIndex] = 0;
            return;
        }
        Object obj2 = objArrH[i10];
        objArrH[dstIndex] = obj2;
        objArrJ[dstIndex] = objArrJ[i10];
        objArrH[i10] = null;
        objArrJ[i10] = null;
        iArrG[dstIndex] = iArrG[i10];
        iArrG[i10] = 0;
        int iD = z2.d(obj2) & mask;
        int iH = f0.h(obj, iD);
        if (iH == size) {
            f0.i(obj, iD, dstIndex + 1);
            return;
        }
        while (true) {
            int i11 = iH - 1;
            int i12 = iArrG[i11];
            int i13 = i12 & mask;
            if (i13 == size) {
                iArrG[i11] = f0.d(i12, dstIndex + 1, mask);
                return;
            }
            iH = i13;
        }
    }

    @b1.e
    public boolean needsAllocArrays() {
        return this.f4768a == null;
    }

    public final void p(int i10, int value) {
        g()[i10] = value;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @gm.a
    @t1.a
    public V put(@m5 K k10, @m5 V v10) {
        int iM;
        int i10;
        if (needsAllocArrays()) {
            allocArrays();
        }
        Map<K, V> mapDelegateOrNull = delegateOrNull();
        if (mapDelegateOrNull != null) {
            return mapDelegateOrNull.put(k10, v10);
        }
        int[] iArrG = g();
        Object[] objArrH = h();
        Object[] objArrJ = j();
        int i11 = this.f4770c;
        int i12 = i11 + 1;
        int iD = z2.d(k10);
        int iC = c();
        int i13 = iD & iC;
        Object obj = this.f4768a;
        Objects.requireNonNull(obj);
        int iH = f0.h(obj, i13);
        if (iH != 0) {
            int i14 = ~iC;
            int i15 = iD & i14;
            int i16 = 0;
            while (true) {
                int i17 = iH - 1;
                int i18 = iArrG[i17];
                if ((i18 & i14) == i15 && c1.b0.a(k10, objArrH[i17])) {
                    V v11 = (V) objArrJ[i17];
                    objArrJ[i17] = v10;
                    accessEntry(i17);
                    return v11;
                }
                int i19 = i18 & iC;
                i16++;
                if (i19 != 0) {
                    iH = i19;
                } else {
                    if (i16 >= 9) {
                        return convertToHashFloodingResistantImplementation().put(k10, v10);
                    }
                    if (i12 > iC) {
                        iM = m(iC, f0.e(iC), iD, i11);
                        i10 = iM;
                    } else {
                        iArrG[i17] = f0.d(i18, i12, iC);
                        i10 = iC;
                    }
                }
            }
        } else if (i12 > iC) {
            iM = m(iC, f0.e(iC), iD, i11);
            i10 = iM;
        } else {
            Object obj2 = this.f4768a;
            Objects.requireNonNull(obj2);
            f0.i(obj2, i13, i12);
            i10 = iC;
        }
        l(i12);
        insertEntry(i11, k10, v10, iD, i10);
        this.f4770c = i12;
        incrementModCount();
        return null;
    }

    public final void q(int mask) {
        this.f4769b = f0.d(this.f4769b, 32 - Integer.numberOfLeadingZeros(mask), 31);
    }

    public final void r(int i10, K key) {
        h()[i10] = key;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @gm.a
    @t1.a
    public V remove(@gm.a Object obj) {
        Map<K, V> mapDelegateOrNull = delegateOrNull();
        if (mapDelegateOrNull != null) {
            return mapDelegateOrNull.remove(obj);
        }
        V v10 = (V) f(obj);
        if (v10 == f4766g) {
            return null;
        }
        return v10;
    }

    public void resizeEntries(int newCapacity) {
        this.entries = Arrays.copyOf(g(), newCapacity);
        this.keys = Arrays.copyOf(h(), newCapacity);
        this.values = Arrays.copyOf(j(), newCapacity);
    }

    public final void s(int i10, V value) {
        j()[i10] = value;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        Map<K, V> mapDelegateOrNull = delegateOrNull();
        return mapDelegateOrNull != null ? mapDelegateOrNull.size() : this.f4770c;
    }

    public final V t(int i10) {
        return (V) j()[i10];
    }

    public void trimToSize() {
        if (needsAllocArrays()) {
            return;
        }
        Map<K, V> mapDelegateOrNull = delegateOrNull();
        if (mapDelegateOrNull != null) {
            Map<K, V> mapCreateHashFloodingResistantDelegate = createHashFloodingResistantDelegate(size());
            mapCreateHashFloodingResistantDelegate.putAll(mapDelegateOrNull);
            this.f4768a = mapCreateHashFloodingResistantDelegate;
            return;
        }
        int i10 = this.f4770c;
        if (i10 < g().length) {
            resizeEntries(i10);
        }
        int iJ = f0.j(i10);
        int iC = c();
        if (iJ < iC) {
            m(iC, iJ, 0, 0);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.f4773f;
        if (collection != null) {
            return collection;
        }
        Collection<V> collectionCreateValues = createValues();
        this.f4773f = collectionCreateValues;
        return collectionCreateValues;
    }

    public Iterator<V> valuesIterator() {
        Map<K, V> mapDelegateOrNull = delegateOrNull();
        return mapDelegateOrNull != null ? mapDelegateOrNull.values().iterator() : new c();
    }

    public d0(int expectedSize) {
        init(expectedSize);
    }

    public abstract class e<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f4778a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f4779b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f4780c;

        public e() {
            this.f4778a = d0.this.f4769b;
            this.f4779b = d0.this.firstEntryIndex();
            this.f4780c = -1;
        }

        public final void a() {
            if (d0.this.f4769b != this.f4778a) {
                throw new ConcurrentModificationException();
            }
        }

        @m5
        public abstract T b(int entry);

        public void c() {
            this.f4778a += 32;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f4779b >= 0;
        }

        @Override // java.util.Iterator
        @m5
        public T next() {
            a();
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int i10 = this.f4779b;
            this.f4780c = i10;
            T tB = b(i10);
            this.f4779b = d0.this.getSuccessor(this.f4779b);
            return tB;
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            b0.e(this.f4780c >= 0);
            c();
            d0 d0Var = d0.this;
            d0Var.remove(d0.access$100(d0Var, this.f4780c));
            this.f4779b = d0.this.adjustAfterRemove(this.f4779b, this.f4780c);
            this.f4780c = -1;
        }

        public /* synthetic */ e(d0 d0Var, a aVar) {
            this();
        }
    }
}
