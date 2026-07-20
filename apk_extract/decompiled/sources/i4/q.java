package i4;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import k3.cb;
import k3.e9;
import k3.f9;
import k3.u8;
import k3.v8;

/* JADX INFO: loaded from: classes.dex */
public final class q extends AbstractSet implements Serializable {
    static final double HASH_FLOODING_FPP = 0.001d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient Object f5676a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient int[] f5677b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient int f5678c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public transient int f5679d;
    transient Object[] elements;

    public q() {
        init(3);
    }

    public static Object access$100(q qVar, int i8) {
        return qVar.f()[i8];
    }

    public static <E> q create() {
        return new q();
    }

    public static <E> q createWithExpectedSize(int i8) {
        return new q(i8);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        int i8 = objectInputStream.readInt();
        if (i8 < 0) {
            throw new InvalidObjectException(a1.a.o(i8, "Invalid size: "));
        }
        init(i8);
        for (int i9 = 0; i9 < i8; i9++) {
            add(objectInputStream.readObject());
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        Iterator<Object> it = iterator();
        while (it.hasNext()) {
            objectOutputStream.writeObject(it.next());
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(Object obj) {
        int iMin;
        if (needsAllocArrays()) {
            allocArrays();
        }
        Set<Object> setDelegateOrNull = delegateOrNull();
        if (setDelegateOrNull != null) {
            return setDelegateOrNull.add(obj);
        }
        int[] iArrG = g();
        Object[] objArrF = f();
        int i8 = this.f5679d;
        int i9 = i8 + 1;
        int iB = f9.b(obj);
        int iE = e();
        int i10 = iB & iE;
        Object obj2 = this.f5676a;
        Objects.requireNonNull(obj2);
        int iE2 = e9.e(i10, obj2);
        if (iE2 != 0) {
            int i11 = ~iE;
            int i12 = iB & i11;
            int i13 = 0;
            while (true) {
                int i14 = iE2 - 1;
                int i15 = iArrG[i14];
                if ((i15 & i11) == i12 && u8.a(obj, objArrF[i14])) {
                    return false;
                }
                int i16 = i15 & iE;
                i13++;
                if (i16 == 0) {
                    if (i13 < 9) {
                        if (i9 <= iE) {
                            iArrG[i14] = e9.b(i15, i9, iE);
                            break;
                        }
                        iE = h(iE, e9.c(iE), iB, i8);
                        break;
                    }
                    return convertToHashFloodingResistantImplementation().add(obj);
                }
                iE2 = i16;
            }
        } else if (i9 > iE) {
            iE = h(iE, e9.c(iE), iB, i8);
        } else {
            Object obj3 = this.f5676a;
            Objects.requireNonNull(obj3);
            e9.f(i10, i9, obj3);
        }
        int length = g().length;
        if (i9 > length && (iMin = Math.min(1073741823, (Math.max(1, length >>> 1) + length) | 1)) != length) {
            resizeEntries(iMin);
        }
        insertEntry(i8, obj, iB, iE);
        this.f5679d = i9;
        incrementModCount();
        return true;
    }

    public int adjustAfterRemove(int i8, int i9) {
        return i8 - 1;
    }

    public int allocArrays() {
        v8.n(needsAllocArrays(), "Arrays already allocated");
        int i8 = this.f5678c;
        int iG = e9.g(i8);
        this.f5676a = e9.a(iG);
        this.f5678c = e9.b(this.f5678c, 32 - Integer.numberOfLeadingZeros(iG - 1), 31);
        this.f5677b = new int[i8];
        this.elements = new Object[i8];
        return i8;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        if (needsAllocArrays()) {
            return;
        }
        incrementModCount();
        Set<Object> setDelegateOrNull = delegateOrNull();
        if (setDelegateOrNull != null) {
            this.f5678c = cb.a(size(), 3);
            setDelegateOrNull.clear();
            this.f5676a = null;
            this.f5679d = 0;
            return;
        }
        Arrays.fill(f(), 0, this.f5679d, (Object) null);
        Object obj = this.f5676a;
        Objects.requireNonNull(obj);
        if (obj instanceof byte[]) {
            Arrays.fill((byte[]) obj, (byte) 0);
        } else if (obj instanceof short[]) {
            Arrays.fill((short[]) obj, (short) 0);
        } else {
            Arrays.fill((int[]) obj, 0);
        }
        Arrays.fill(g(), 0, this.f5679d, 0);
        this.f5679d = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        if (needsAllocArrays()) {
            return false;
        }
        Set<Object> setDelegateOrNull = delegateOrNull();
        if (setDelegateOrNull != null) {
            return setDelegateOrNull.contains(obj);
        }
        int iB = f9.b(obj);
        int iE = e();
        Object obj2 = this.f5676a;
        Objects.requireNonNull(obj2);
        int iE2 = e9.e(iB & iE, obj2);
        if (iE2 == 0) {
            return false;
        }
        int i8 = ~iE;
        int i9 = iB & i8;
        do {
            int i10 = iE2 - 1;
            int i11 = g()[i10];
            if ((i11 & i8) == i9 && u8.a(obj, f()[i10])) {
                return true;
            }
            iE2 = i11 & iE;
        } while (iE2 != 0);
        return false;
    }

    public Set<Object> convertToHashFloodingResistantImplementation() {
        LinkedHashSet linkedHashSet = new LinkedHashSet(e() + 1, 1.0f);
        int iFirstEntryIndex = firstEntryIndex();
        while (iFirstEntryIndex >= 0) {
            linkedHashSet.add(f()[iFirstEntryIndex]);
            iFirstEntryIndex = getSuccessor(iFirstEntryIndex);
        }
        this.f5676a = linkedHashSet;
        this.f5677b = null;
        this.elements = null;
        incrementModCount();
        return linkedHashSet;
    }

    public Set<Object> delegateOrNull() {
        Object obj = this.f5676a;
        if (obj instanceof Set) {
            return (Set) obj;
        }
        return null;
    }

    public final int e() {
        return (1 << (this.f5678c & 31)) - 1;
    }

    public final Object[] f() {
        Object[] objArr = this.elements;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    public int firstEntryIndex() {
        return isEmpty() ? -1 : 0;
    }

    public final int[] g() {
        int[] iArr = this.f5677b;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    public int getSuccessor(int i8) {
        int i9 = i8 + 1;
        if (i9 < this.f5679d) {
            return i9;
        }
        return -1;
    }

    public final int h(int i8, int i9, int i10, int i11) {
        Object objA = e9.a(i9);
        int i12 = i9 - 1;
        if (i11 != 0) {
            e9.f(i10 & i12, i11 + 1, objA);
        }
        Object obj = this.f5676a;
        Objects.requireNonNull(obj);
        int[] iArrG = g();
        for (int i13 = 0; i13 <= i8; i13++) {
            int iE = e9.e(i13, obj);
            while (iE != 0) {
                int i14 = iE - 1;
                int i15 = iArrG[i14];
                int i16 = ((~i8) & i15) | i13;
                int i17 = i16 & i12;
                int iE2 = e9.e(i17, objA);
                e9.f(i17, iE, objA);
                iArrG[i14] = e9.b(i16, iE2, i12);
                iE = i15 & i8;
            }
        }
        this.f5676a = objA;
        this.f5678c = e9.b(this.f5678c, 32 - Integer.numberOfLeadingZeros(i12), 31);
        return i12;
    }

    public void incrementModCount() {
        this.f5678c += 32;
    }

    public void init(int i8) {
        v8.c("Expected size must be >= 0", i8 >= 0);
        this.f5678c = cb.a(i8, 1);
    }

    public void insertEntry(int i8, Object obj, int i9, int i10) {
        g()[i8] = e9.b(i9, 0, i10);
        f()[i8] = obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean isUsingHashFloodingResistance() {
        return delegateOrNull() != null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<Object> iterator() {
        Set<Object> setDelegateOrNull = delegateOrNull();
        return setDelegateOrNull != null ? setDelegateOrNull.iterator() : new p(this);
    }

    public void moveLastEntry(int i8, int i9) {
        Object obj = this.f5676a;
        Objects.requireNonNull(obj);
        int[] iArrG = g();
        Object[] objArrF = f();
        int size = size();
        int i10 = size - 1;
        if (i8 >= i10) {
            objArrF[i8] = null;
            iArrG[i8] = 0;
            return;
        }
        Object obj2 = objArrF[i10];
        objArrF[i8] = obj2;
        objArrF[i10] = null;
        iArrG[i8] = iArrG[i10];
        iArrG[i10] = 0;
        int iB = f9.b(obj2) & i9;
        int iE = e9.e(iB, obj);
        if (iE == size) {
            e9.f(iB, i8 + 1, obj);
            return;
        }
        while (true) {
            int i11 = iE - 1;
            int i12 = iArrG[i11];
            int i13 = i12 & i9;
            if (i13 == size) {
                iArrG[i11] = e9.b(i12, i8 + 1, i9);
                return;
            }
            iE = i13;
        }
    }

    public boolean needsAllocArrays() {
        return this.f5676a == null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        if (needsAllocArrays()) {
            return false;
        }
        Set<Object> setDelegateOrNull = delegateOrNull();
        if (setDelegateOrNull != null) {
            return setDelegateOrNull.remove(obj);
        }
        int iE = e();
        Object obj2 = this.f5676a;
        Objects.requireNonNull(obj2);
        int iD = e9.d(obj, null, iE, obj2, g(), f(), null);
        if (iD == -1) {
            return false;
        }
        moveLastEntry(iD, iE);
        this.f5679d--;
        incrementModCount();
        return true;
    }

    public void resizeEntries(int i8) {
        this.f5677b = Arrays.copyOf(g(), i8);
        this.elements = Arrays.copyOf(f(), i8);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        Set<Object> setDelegateOrNull = delegateOrNull();
        return setDelegateOrNull != null ? setDelegateOrNull.size() : this.f5679d;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        if (needsAllocArrays()) {
            return new Object[0];
        }
        Set<Object> setDelegateOrNull = delegateOrNull();
        return setDelegateOrNull != null ? setDelegateOrNull.toArray() : Arrays.copyOf(f(), this.f5679d);
    }

    public void trimToSize() {
        if (needsAllocArrays()) {
            return;
        }
        Set<Object> setDelegateOrNull = delegateOrNull();
        if (setDelegateOrNull != null) {
            LinkedHashSet linkedHashSet = new LinkedHashSet(size(), 1.0f);
            linkedHashSet.addAll(setDelegateOrNull);
            this.f5676a = linkedHashSet;
            return;
        }
        int i8 = this.f5679d;
        if (i8 < g().length) {
            resizeEntries(i8);
        }
        int iG = e9.g(i8);
        int iE = e();
        if (iG < iE) {
            h(iE, iG, 0, 0);
        }
    }

    public static <E> q create(Collection<? extends E> collection) {
        q qVarCreateWithExpectedSize = createWithExpectedSize(collection.size());
        qVarCreateWithExpectedSize.addAll(collection);
        return qVarCreateWithExpectedSize;
    }

    public q(int i8) {
        init(i8);
    }

    @SafeVarargs
    public static <E> q create(E... eArr) {
        q qVarCreateWithExpectedSize = createWithExpectedSize(eArr.length);
        Collections.addAll(qVarCreateWithExpectedSize, eArr);
        return qVarCreateWithExpectedSize;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        if (needsAllocArrays()) {
            if (tArr.length > 0) {
                tArr[0] = null;
            }
            return tArr;
        }
        Set<Object> setDelegateOrNull = delegateOrNull();
        if (setDelegateOrNull != null) {
            return (T[]) setDelegateOrNull.toArray(tArr);
        }
        Object[] objArrF = f();
        int i8 = this.f5679d;
        v8.k(0, i8, objArrF.length);
        if (tArr.length < i8) {
            if (tArr.length != 0) {
                tArr = (T[]) Arrays.copyOf(tArr, 0);
            }
            tArr = (T[]) Arrays.copyOf(tArr, i8);
        } else if (tArr.length > i8) {
            tArr[i8] = null;
        }
        System.arraycopy(objArrF, 0, tArr, 0, i8);
        return tArr;
    }
}
