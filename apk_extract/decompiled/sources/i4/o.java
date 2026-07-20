package i4;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import k3.cb;
import k3.e9;
import k3.f9;
import k3.u8;
import k3.v8;

/* JADX INFO: loaded from: classes.dex */
public final class o extends AbstractMap implements Serializable {
    static final double HASH_FLOODING_FPP = 0.001d;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Object f5659i = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient Object f5660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient int f5661b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient int f5662c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public transient Set f5663d;
    public transient Set e;
    transient int[] entries;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public transient Collection f5664h;
    transient Object[] keys;
    transient Object[] values;

    public o() {
        init(3);
    }

    public static Object access$100(o oVar, int i8) {
        return oVar.e()[i8];
    }

    public static /* synthetic */ int access$1210(o oVar) {
        int i8 = oVar.f5662c;
        oVar.f5662c = i8 - 1;
        return i8;
    }

    public static void access$1300(o oVar, int i8, Object obj) {
        oVar.f()[i8] = obj;
    }

    public static Object access$600(o oVar, int i8) {
        return oVar.f()[i8];
    }

    public static Object access$800(o oVar) {
        Object obj = oVar.f5660a;
        Objects.requireNonNull(obj);
        return obj;
    }

    public static <K, V> o create() {
        return new o();
    }

    public static <K, V> o createWithExpectedSize(int i8) {
        return new o(i8);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        int i8 = objectInputStream.readInt();
        if (i8 < 0) {
            throw new InvalidObjectException(a1.a.o(i8, "Invalid size: "));
        }
        init(i8);
        for (int i9 = 0; i9 < i8; i9++) {
            put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        Iterator<Map.Entry<Object, Object>> itEntrySetIterator = entrySetIterator();
        while (itEntrySetIterator.hasNext()) {
            Map.Entry<Object, Object> next = itEntrySetIterator.next();
            objectOutputStream.writeObject(next.getKey());
            objectOutputStream.writeObject(next.getValue());
        }
    }

    public final int a() {
        return (1 << (this.f5661b & 31)) - 1;
    }

    public void accessEntry(int i8) {
    }

    public int adjustAfterRemove(int i8, int i9) {
        return i8 - 1;
    }

    public int allocArrays() {
        v8.n(needsAllocArrays(), "Arrays already allocated");
        int i8 = this.f5661b;
        int iG = e9.g(i8);
        this.f5660a = e9.a(iG);
        this.f5661b = e9.b(this.f5661b, 32 - Integer.numberOfLeadingZeros(iG - 1), 31);
        this.entries = new int[i8];
        this.keys = new Object[i8];
        this.values = new Object[i8];
        return i8;
    }

    public final int b(Object obj) {
        if (needsAllocArrays()) {
            return -1;
        }
        int iB = f9.b(obj);
        int iA = a();
        Object obj2 = this.f5660a;
        Objects.requireNonNull(obj2);
        int iE = e9.e(iB & iA, obj2);
        if (iE == 0) {
            return -1;
        }
        int i8 = ~iA;
        int i9 = iB & i8;
        do {
            int i10 = iE - 1;
            int i11 = d()[i10];
            if ((i11 & i8) == i9 && u8.a(obj, e()[i10])) {
                return i10;
            }
            iE = i11 & iA;
        } while (iE != 0);
        return -1;
    }

    public final Object c(Object obj) {
        boolean zNeedsAllocArrays = needsAllocArrays();
        Object obj2 = f5659i;
        if (zNeedsAllocArrays) {
            return obj2;
        }
        int iA = a();
        Object obj3 = this.f5660a;
        Objects.requireNonNull(obj3);
        int iD = e9.d(obj, null, iA, obj3, d(), e(), null);
        if (iD == -1) {
            return obj2;
        }
        Object obj4 = f()[iD];
        moveLastEntry(iD, iA);
        this.f5662c--;
        incrementModCount();
        return obj4;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        if (needsAllocArrays()) {
            return;
        }
        incrementModCount();
        Map<Object, Object> mapDelegateOrNull = delegateOrNull();
        if (mapDelegateOrNull != null) {
            this.f5661b = cb.a(size(), 3);
            mapDelegateOrNull.clear();
            this.f5660a = null;
            this.f5662c = 0;
            return;
        }
        Arrays.fill(e(), 0, this.f5662c, (Object) null);
        Arrays.fill(f(), 0, this.f5662c, (Object) null);
        Object obj = this.f5660a;
        Objects.requireNonNull(obj);
        if (obj instanceof byte[]) {
            Arrays.fill((byte[]) obj, (byte) 0);
        } else if (obj instanceof short[]) {
            Arrays.fill((short[]) obj, (short) 0);
        } else {
            Arrays.fill((int[]) obj, 0);
        }
        Arrays.fill(d(), 0, this.f5662c, 0);
        this.f5662c = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Map<Object, Object> mapDelegateOrNull = delegateOrNull();
        if (mapDelegateOrNull != null) {
            return mapDelegateOrNull.containsKey(obj);
        }
        return b(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        Map<Object, Object> mapDelegateOrNull = delegateOrNull();
        if (mapDelegateOrNull != null) {
            return mapDelegateOrNull.containsValue(obj);
        }
        for (int i8 = 0; i8 < this.f5662c; i8++) {
            if (u8.a(obj, f()[i8])) {
                return true;
            }
        }
        return false;
    }

    public Map<Object, Object> convertToHashFloodingResistantImplementation() {
        Map<Object, Object> mapCreateHashFloodingResistantDelegate = createHashFloodingResistantDelegate(a() + 1);
        int iFirstEntryIndex = firstEntryIndex();
        while (iFirstEntryIndex >= 0) {
            mapCreateHashFloodingResistantDelegate.put(e()[iFirstEntryIndex], f()[iFirstEntryIndex]);
            iFirstEntryIndex = getSuccessor(iFirstEntryIndex);
        }
        this.f5660a = mapCreateHashFloodingResistantDelegate;
        this.entries = null;
        this.keys = null;
        this.values = null;
        incrementModCount();
        return mapCreateHashFloodingResistantDelegate;
    }

    public Set<Map.Entry<Object, Object>> createEntrySet() {
        return new l(this, 0);
    }

    public Map<Object, Object> createHashFloodingResistantDelegate(int i8) {
        return new LinkedHashMap(i8, 1.0f);
    }

    public Set<Object> createKeySet() {
        return new l(this, 1);
    }

    public Collection<Object> createValues() {
        return new n(this, 0);
    }

    public final int[] d() {
        int[] iArr = this.entries;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    public Map<Object, Object> delegateOrNull() {
        Object obj = this.f5660a;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    public final Object[] e() {
        Object[] objArr = this.keys;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<Object, Object>> entrySet() {
        Set<Map.Entry<Object, Object>> set = this.e;
        if (set != null) {
            return set;
        }
        Set<Map.Entry<Object, Object>> setCreateEntrySet = createEntrySet();
        this.e = setCreateEntrySet;
        return setCreateEntrySet;
    }

    public Iterator<Map.Entry<Object, Object>> entrySetIterator() {
        Map<Object, Object> mapDelegateOrNull = delegateOrNull();
        return mapDelegateOrNull != null ? mapDelegateOrNull.entrySet().iterator() : new k(this, 1);
    }

    public final Object[] f() {
        Object[] objArr = this.values;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    public int firstEntryIndex() {
        return isEmpty() ? -1 : 0;
    }

    public final int g(int i8, int i9, int i10, int i11) {
        Object objA = e9.a(i9);
        int i12 = i9 - 1;
        if (i11 != 0) {
            e9.f(i10 & i12, i11 + 1, objA);
        }
        Object obj = this.f5660a;
        Objects.requireNonNull(obj);
        int[] iArrD = d();
        for (int i13 = 0; i13 <= i8; i13++) {
            int iE = e9.e(i13, obj);
            while (iE != 0) {
                int i14 = iE - 1;
                int i15 = iArrD[i14];
                int i16 = ((~i8) & i15) | i13;
                int i17 = i16 & i12;
                int iE2 = e9.e(i17, objA);
                e9.f(i17, iE, objA);
                iArrD[i14] = e9.b(i16, iE2, i12);
                iE = i15 & i8;
            }
        }
        this.f5660a = objA;
        this.f5661b = e9.b(this.f5661b, 32 - Integer.numberOfLeadingZeros(i12), 31);
        return i12;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        Map<Object, Object> mapDelegateOrNull = delegateOrNull();
        if (mapDelegateOrNull != null) {
            return mapDelegateOrNull.get(obj);
        }
        int iB = b(obj);
        if (iB == -1) {
            return null;
        }
        accessEntry(iB);
        return f()[iB];
    }

    public int getSuccessor(int i8) {
        int i9 = i8 + 1;
        if (i9 < this.f5662c) {
            return i9;
        }
        return -1;
    }

    public void incrementModCount() {
        this.f5661b += 32;
    }

    public void init(int i8) {
        v8.c("Expected size must be >= 0", i8 >= 0);
        this.f5661b = cb.a(i8, 1);
    }

    public void insertEntry(int i8, Object obj, Object obj2, int i9, int i10) {
        d()[i8] = e9.b(i9, 0, i10);
        e()[i8] = obj;
        f()[i8] = obj2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Object> keySet() {
        Set<Object> set = this.f5663d;
        if (set != null) {
            return set;
        }
        Set<Object> setCreateKeySet = createKeySet();
        this.f5663d = setCreateKeySet;
        return setCreateKeySet;
    }

    public Iterator<Object> keySetIterator() {
        Map<Object, Object> mapDelegateOrNull = delegateOrNull();
        return mapDelegateOrNull != null ? mapDelegateOrNull.keySet().iterator() : new k(this, 0);
    }

    public void moveLastEntry(int i8, int i9) {
        Object obj = this.f5660a;
        Objects.requireNonNull(obj);
        int[] iArrD = d();
        Object[] objArrE = e();
        Object[] objArrF = f();
        int size = size();
        int i10 = size - 1;
        if (i8 >= i10) {
            objArrE[i8] = null;
            objArrF[i8] = null;
            iArrD[i8] = 0;
            return;
        }
        Object obj2 = objArrE[i10];
        objArrE[i8] = obj2;
        objArrF[i8] = objArrF[i10];
        objArrE[i10] = null;
        objArrF[i10] = null;
        iArrD[i8] = iArrD[i10];
        iArrD[i10] = 0;
        int iB = f9.b(obj2) & i9;
        int iE = e9.e(iB, obj);
        if (iE == size) {
            e9.f(iB, i8 + 1, obj);
            return;
        }
        while (true) {
            int i11 = iE - 1;
            int i12 = iArrD[i11];
            int i13 = i12 & i9;
            if (i13 == size) {
                iArrD[i11] = e9.b(i12, i8 + 1, i9);
                return;
            }
            iE = i13;
        }
    }

    public boolean needsAllocArrays() {
        return this.f5660a == null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        int iG;
        int iMin;
        if (needsAllocArrays()) {
            allocArrays();
        }
        Map<Object, Object> mapDelegateOrNull = delegateOrNull();
        if (mapDelegateOrNull != null) {
            return mapDelegateOrNull.put(obj, obj2);
        }
        int[] iArrD = d();
        Object[] objArrE = e();
        Object[] objArrF = f();
        int i8 = this.f5662c;
        int i9 = i8 + 1;
        int iB = f9.b(obj);
        int iA = a();
        int i10 = iB & iA;
        Object obj3 = this.f5660a;
        Objects.requireNonNull(obj3);
        int iE = e9.e(i10, obj3);
        int i11 = 1;
        if (iE != 0) {
            int i12 = ~iA;
            int i13 = iB & i12;
            int i14 = 0;
            while (true) {
                int i15 = iE - i11;
                int i16 = iArrD[i15];
                if ((i16 & i12) == i13 && u8.a(obj, objArrE[i15])) {
                    Object obj4 = objArrF[i15];
                    objArrF[i15] = obj2;
                    accessEntry(i15);
                    return obj4;
                }
                int i17 = i16 & iA;
                i14++;
                if (i17 == 0) {
                    if (i14 < 9) {
                        if (i9 <= iA) {
                            iArrD[i15] = e9.b(i16, i9, iA);
                            break;
                        }
                        iG = g(iA, e9.c(iA), iB, i8);
                        iA = iG;
                        break;
                    }
                    return convertToHashFloodingResistantImplementation().put(obj, obj2);
                }
                iE = i17;
                i11 = 1;
            }
        } else {
            if (i9 > iA) {
                iG = g(iA, e9.c(iA), iB, i8);
                iA = iG;
                break;
            }
            Object obj5 = this.f5660a;
            Objects.requireNonNull(obj5);
            e9.f(i10, i9, obj5);
        }
        int length = d().length;
        if (i9 > length && (iMin = Math.min(1073741823, (Math.max(1, length >>> 1) + length) | 1)) != length) {
            resizeEntries(iMin);
        }
        insertEntry(i8, obj, obj2, iB, iA);
        this.f5662c = i9;
        incrementModCount();
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        Map<Object, Object> mapDelegateOrNull = delegateOrNull();
        if (mapDelegateOrNull != null) {
            return mapDelegateOrNull.remove(obj);
        }
        Object objC = c(obj);
        if (objC == f5659i) {
            return null;
        }
        return objC;
    }

    public void resizeEntries(int i8) {
        this.entries = Arrays.copyOf(d(), i8);
        this.keys = Arrays.copyOf(e(), i8);
        this.values = Arrays.copyOf(f(), i8);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        Map<Object, Object> mapDelegateOrNull = delegateOrNull();
        return mapDelegateOrNull != null ? mapDelegateOrNull.size() : this.f5662c;
    }

    public void trimToSize() {
        if (needsAllocArrays()) {
            return;
        }
        Map<? extends Object, ? extends Object> mapDelegateOrNull = delegateOrNull();
        if (mapDelegateOrNull != null) {
            Map<Object, Object> mapCreateHashFloodingResistantDelegate = createHashFloodingResistantDelegate(size());
            mapCreateHashFloodingResistantDelegate.putAll(mapDelegateOrNull);
            this.f5660a = mapCreateHashFloodingResistantDelegate;
            return;
        }
        int i8 = this.f5662c;
        if (i8 < d().length) {
            resizeEntries(i8);
        }
        int iG = e9.g(i8);
        int iA = a();
        if (iG < iA) {
            g(iA, iG, 0, 0);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<Object> values() {
        Collection<Object> collection = this.f5664h;
        if (collection != null) {
            return collection;
        }
        Collection<Object> collectionCreateValues = createValues();
        this.f5664h = collectionCreateValues;
        return collectionCreateValues;
    }

    public Iterator<Object> valuesIterator() {
        Map<Object, Object> mapDelegateOrNull = delegateOrNull();
        return mapDelegateOrNull != null ? mapDelegateOrNull.values().iterator() : new k(this, 2);
    }

    public o(int i8) {
        init(i8);
    }
}
