package i4;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicReferenceArray;
import k3.cb;
import k3.h9;

/* JADX INFO: loaded from: classes.dex */
public final class u3 extends AbstractMap implements ConcurrentMap, Serializable {
    static final int CONTAINS_VALUE_RETRIES = 3;
    static final int DRAIN_MAX = 16;
    static final int DRAIN_THRESHOLD = 63;
    static final int MAXIMUM_CAPACITY = 1073741824;
    static final int MAX_SEGMENTS = 65536;
    static final r3 UNSET_WEAK_VALUE_REFERENCE = new j2();
    private static final long serialVersionUID = 5;
    final int concurrencyLevel;
    final transient q2 entryHelper;
    transient Set<Map.Entry<Object, Object>> entrySet;
    final h4.l keyEquivalence;
    transient Set<Object> keySet;
    final transient int segmentMask;
    final transient int segmentShift;
    final transient s2[] segments;
    transient Collection<Object> values;

    public u3(i2 i2Var, q2 q2Var) {
        int i8 = i2Var.f5609c;
        this.concurrencyLevel = Math.min(i8 == -1 ? 4 : i8, 65536);
        h4.l lVar = i2Var.f;
        h4.l lVarDefaultEquivalence = i2Var.a().defaultEquivalence();
        if (lVar == null) {
            if (lVarDefaultEquivalence == null) {
                throw new NullPointerException("Both parameters are null");
            }
            lVar = lVarDefaultEquivalence;
        }
        this.keyEquivalence = lVar;
        this.entryHelper = q2Var;
        int i9 = i2Var.f5608b;
        int iMin = Math.min(i9 == -1 ? 16 : i9, 1073741824);
        int i10 = 1;
        int i11 = 0;
        int i12 = 1;
        int i13 = 0;
        while (i12 < this.concurrencyLevel) {
            i13++;
            i12 <<= 1;
        }
        this.segmentShift = 32 - i13;
        this.segmentMask = i12 - 1;
        this.segments = newSegmentArray(i12);
        int i14 = iMin / i12;
        while (i10 < (i12 * i14 < iMin ? i14 + 1 : i14)) {
            i10 <<= 1;
        }
        while (true) {
            s2[] s2VarArr = this.segments;
            if (i11 >= s2VarArr.length) {
                return;
            }
            s2VarArr[i11] = createSegment(i10);
            i11++;
        }
    }

    public static ArrayList access$1800(Collection collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        h9.a(arrayList, collection.iterator());
        return arrayList;
    }

    public static <K, V> u3 create(i2 i2Var) {
        w2 w2VarA = i2Var.a();
        w2 w2Var = w2.STRONG;
        if (w2VarA == w2Var && i2Var.b() == w2Var) {
            return new u3(i2Var, x2.f5706c);
        }
        if (i2Var.a() == w2Var && i2Var.b() == w2.WEAK) {
            return new u3(i2Var, x2.f5707d);
        }
        w2 w2VarA2 = i2Var.a();
        w2 w2Var2 = w2.WEAK;
        if (w2VarA2 == w2Var2 && i2Var.b() == w2Var) {
            return new u3(i2Var, x2.f);
        }
        if (i2Var.a() == w2Var2 && i2Var.b() == w2Var2) {
            return new u3(i2Var, x2.f5708g);
        }
        throw new AssertionError();
    }

    public static <K> u3 createWithDummyValues(i2 i2Var) {
        w2 w2VarA = i2Var.a();
        w2 w2Var = w2.STRONG;
        if (w2VarA == w2Var && i2Var.b() == w2Var) {
            return new u3(i2Var, x2.f5705b);
        }
        w2 w2VarA2 = i2Var.a();
        w2 w2Var2 = w2.WEAK;
        if (w2VarA2 == w2Var2 && i2Var.b() == w2Var) {
            return new u3(i2Var, x2.e);
        }
        if (i2Var.b() == w2Var2) {
            throw new IllegalArgumentException("Map cannot have both weak and dummy values");
        }
        throw new AssertionError();
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializationProxy");
    }

    public static int rehash(int i8) {
        int i9 = i8 + ((i8 << 15) ^ (-12931));
        int i10 = i9 ^ (i9 >>> 10);
        int i11 = i10 + (i10 << 3);
        int i12 = i11 ^ (i11 >>> 6);
        int i13 = (i12 << 2) + (i12 << 14) + i12;
        return (i13 >>> 16) ^ i13;
    }

    public static <K, V, E extends p2> r3 unsetWeakValueReference() {
        return UNSET_WEAK_VALUE_REFERENCE;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        for (s2 s2Var : this.segments) {
            s2Var.clear();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        if (obj == null) {
            return false;
        }
        int iHash = hash(obj);
        return segmentFor(iHash).containsKey(obj, iHash);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1, types: [int] */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1, types: [int] */
    /* JADX WARN: Type inference failed for: r13v3 */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        boolean z2 = false;
        if (obj == null) {
            return false;
        }
        s2[] s2VarArr = this.segments;
        long j8 = -1;
        int i8 = 0;
        while (i8 < 3) {
            int length = s2VarArr.length;
            long j10 = 0;
            for (?? r10 = z2; r10 < length; r10++) {
                s2 s2Var = s2VarArr[r10];
                int i9 = s2Var.count;
                AtomicReferenceArray<p2> atomicReferenceArray = s2Var.table;
                for (?? r13 = z2; r13 < atomicReferenceArray.length(); r13++) {
                    for (p2 p2VarC = atomicReferenceArray.get(r13); p2VarC != null; p2VarC = p2VarC.c()) {
                        Object liveValue = s2Var.getLiveValue(p2VarC);
                        if (liveValue != null && valueEquivalence().equivalent(obj, liveValue)) {
                            return true;
                        }
                    }
                }
                j10 += (long) s2Var.modCount;
                z2 = false;
            }
            if (j10 == j8) {
                return false;
            }
            i8++;
            j8 = j10;
            z2 = false;
        }
        return z2;
    }

    public p2 copyEntry(p2 p2Var, p2 p2Var2) {
        return segmentFor(p2Var.b()).copyEntry(p2Var, p2Var2);
    }

    public s2 createSegment(int i8) {
        return this.entryHelper.b(this, i8);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<Object, Object>> entrySet() {
        Set<Map.Entry<Object, Object>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        o2 o2Var = new o2(this, 0);
        this.entrySet = o2Var;
        return o2Var;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        if (obj == null) {
            return null;
        }
        int iHash = hash(obj);
        return segmentFor(iHash).get(obj, iHash);
    }

    public p2 getEntry(Object obj) {
        if (obj == null) {
            return null;
        }
        int iHash = hash(obj);
        return segmentFor(iHash).getEntry(obj, iHash);
    }

    public Object getLiveValue(p2 p2Var) {
        if (p2Var.getKey() == null) {
            return null;
        }
        return p2Var.getValue();
    }

    public int hash(Object obj) {
        return rehash(this.keyEquivalence.hash(obj));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        s2[] s2VarArr = this.segments;
        long j8 = 0;
        for (int i8 = 0; i8 < s2VarArr.length; i8++) {
            if (s2VarArr[i8].count != 0) {
                return false;
            }
            j8 += (long) s2VarArr[i8].modCount;
        }
        if (j8 == 0) {
            return true;
        }
        for (int i9 = 0; i9 < s2VarArr.length; i9++) {
            if (s2VarArr[i9].count != 0) {
                return false;
            }
            j8 -= (long) s2VarArr[i9].modCount;
        }
        return j8 == 0;
    }

    public boolean isLiveForTesting(p2 p2Var) {
        return segmentFor(p2Var.b()).getLiveValueForTesting(p2Var) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Object> keySet() {
        Set<Object> set = this.keySet;
        if (set != null) {
            return set;
        }
        o2 o2Var = new o2(this, 1);
        this.keySet = o2Var;
        return o2Var;
    }

    public w2 keyStrength() {
        return this.entryHelper.d();
    }

    public final s2[] newSegmentArray(int i8) {
        return new s2[i8];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        obj.getClass();
        obj2.getClass();
        int iHash = hash(obj);
        return segmentFor(iHash).put(obj, iHash, obj2, false);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<Object, Object> map) {
        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public Object putIfAbsent(Object obj, Object obj2) {
        obj.getClass();
        obj2.getClass();
        int iHash = hash(obj);
        return segmentFor(iHash).put(obj, iHash, obj2, true);
    }

    public void reclaimKey(p2 p2Var) {
        int iB = p2Var.b();
        segmentFor(iB).reclaimKey(p2Var, iB);
    }

    public void reclaimValue(r3 r3Var) {
        p2 p2VarB = r3Var.b();
        int iB = p2VarB.b();
        segmentFor(iB).reclaimValue(p2VarB.getKey(), iB, r3Var);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        if (obj == null) {
            return null;
        }
        int iHash = hash(obj);
        return segmentFor(iHash).remove(obj, iHash);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public Object replace(Object obj, Object obj2) {
        obj.getClass();
        obj2.getClass();
        int iHash = hash(obj);
        return segmentFor(iHash).replace(obj, iHash, obj2);
    }

    public s2 segmentFor(int i8) {
        return this.segments[this.segmentMask & (i8 >>> this.segmentShift)];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        long j8 = 0;
        for (s2 s2Var : this.segments) {
            j8 += (long) s2Var.count;
        }
        return cb.b(j8);
    }

    public h4.l valueEquivalence() {
        return this.entryHelper.a().defaultEquivalence();
    }

    public w2 valueStrength() {
        return this.entryHelper.a();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<Object> values() {
        Collection<Object> collection = this.values;
        if (collection != null) {
            return collection;
        }
        n nVar = new n(this, 1);
        this.values = nVar;
        return nVar;
    }

    public Object writeReplace() {
        return new t2(this.entryHelper.d(), this.entryHelper.a(), this.keyEquivalence, this.entryHelper.a().defaultEquivalence(), this.concurrencyLevel, this);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean remove(Object obj, Object obj2) {
        if (obj == null || obj2 == null) {
            return false;
        }
        int iHash = hash(obj);
        return segmentFor(iHash).remove(obj, iHash, obj2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean replace(Object obj, Object obj2, Object obj3) {
        obj.getClass();
        obj3.getClass();
        if (obj2 == null) {
            return false;
        }
        int iHash = hash(obj);
        return segmentFor(iHash).replace(obj, iHash, obj2, obj3);
    }
}
