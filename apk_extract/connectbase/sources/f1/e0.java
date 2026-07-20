package f1;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@x0
public class e0<E> extends AbstractSet<E> implements Serializable {

    @b1.e
    static final double HASH_FLOODING_FPP = 0.001d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f4842e = 9;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @gm.a
    public transient Object f4843a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @gm.a
    public transient int[] f4844b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient int f4845c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public transient int f4846d;

    @gm.a
    @b1.e
    transient Object[] elements;

    public class a implements Iterator<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f4847a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f4848b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f4849c = -1;

        public a() {
            this.f4847a = e0.this.f4845c;
            this.f4848b = e0.this.firstEntryIndex();
        }

        public final void a() {
            if (e0.this.f4845c != this.f4847a) {
                throw new ConcurrentModificationException();
            }
        }

        public void b() {
            this.f4847a += 32;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f4848b >= 0;
        }

        @Override // java.util.Iterator
        @m5
        public E next() {
            a();
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int i10 = this.f4848b;
            this.f4849c = i10;
            E e10 = (E) e0.access$100(e0.this, i10);
            this.f4848b = e0.this.getSuccessor(this.f4848b);
            return e10;
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            b0.e(this.f4849c >= 0);
            b();
            e0 e0Var = e0.this;
            e0Var.remove(e0.access$100(e0Var, this.f4849c));
            this.f4848b = e0.this.adjustAfterRemove(this.f4848b, this.f4849c);
            this.f4849c = -1;
        }
    }

    public e0() {
        init(3);
    }

    public static Object access$100(e0 e0Var, int i10) {
        return e0Var.f()[i10];
    }

    public static <E> e0<E> create() {
        return new e0<>();
    }

    public static <E> e0<E> createWithExpectedSize(int expectedSize) {
        return new e0<>(expectedSize);
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
            add(stream.readObject());
        }
    }

    @b1.d
    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeInt(size());
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            stream.writeObject(it.next());
        }
    }

    public final Set<E> a(int tableSize) {
        return new LinkedHashSet(tableSize, 1.0f);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    @t1.a
    public boolean add(@m5 E object) {
        if (needsAllocArrays()) {
            allocArrays();
        }
        Set<E> setDelegateOrNull = delegateOrNull();
        if (setDelegateOrNull != null) {
            return setDelegateOrNull.add(object);
        }
        int[] iArrG = g();
        Object[] objArrF = f();
        int i10 = this.f4846d;
        int i11 = i10 + 1;
        int iD = z2.d(object);
        int iE = e();
        int i12 = iD & iE;
        Object obj = this.f4843a;
        Objects.requireNonNull(obj);
        int iH = f0.h(obj, i12);
        if (iH != 0) {
            int i13 = ~iE;
            int i14 = iD & i13;
            int i15 = 0;
            while (true) {
                int i16 = iH - 1;
                int i17 = iArrG[i16];
                if ((i17 & i13) == i14 && c1.b0.a(object, objArrF[i16])) {
                    return false;
                }
                int i18 = i17 & iE;
                i15++;
                if (i18 != 0) {
                    iH = i18;
                } else {
                    if (i15 >= 9) {
                        return convertToHashFloodingResistantImplementation().add(object);
                    }
                    if (i11 > iE) {
                        iE = k(iE, f0.e(iE), iD, i10);
                    } else {
                        iArrG[i16] = f0.d(i17, i11, iE);
                    }
                }
            }
        } else if (i11 > iE) {
            iE = k(iE, f0.e(iE), iD, i10);
        } else {
            Object obj2 = this.f4843a;
            Objects.requireNonNull(obj2);
            f0.i(obj2, i12, i11);
        }
        j(i11);
        insertEntry(i10, object, iD, iE);
        this.f4846d = i11;
        incrementModCount();
        return true;
    }

    public int adjustAfterRemove(int indexBeforeRemove, int indexRemoved) {
        return indexBeforeRemove - 1;
    }

    @t1.a
    public int allocArrays() {
        c1.h0.h0(needsAllocArrays(), "Arrays already allocated");
        int i10 = this.f4845c;
        int iJ = f0.j(i10);
        this.f4843a = f0.a(iJ);
        n(iJ - 1);
        this.f4844b = new int[i10];
        this.elements = new Object[i10];
        return i10;
    }

    public final E b(int i10) {
        return (E) f()[i10];
    }

    public final int c(int i10) {
        return g()[i10];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        if (needsAllocArrays()) {
            return;
        }
        incrementModCount();
        Set<E> setDelegateOrNull = delegateOrNull();
        if (setDelegateOrNull != null) {
            this.f4845c = o1.l.g(size(), 3, 1073741823);
            setDelegateOrNull.clear();
            this.f4843a = null;
            this.f4846d = 0;
            return;
        }
        Arrays.fill(f(), 0, this.f4846d, (Object) null);
        Object obj = this.f4843a;
        Objects.requireNonNull(obj);
        f0.g(obj);
        Arrays.fill(g(), 0, this.f4846d, 0);
        this.f4846d = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@gm.a Object object) {
        if (needsAllocArrays()) {
            return false;
        }
        Set<E> setDelegateOrNull = delegateOrNull();
        if (setDelegateOrNull != null) {
            return setDelegateOrNull.contains(object);
        }
        int iD = z2.d(object);
        int iE = e();
        Object obj = this.f4843a;
        Objects.requireNonNull(obj);
        int iH = f0.h(obj, iD & iE);
        if (iH == 0) {
            return false;
        }
        int i10 = ~iE;
        int i11 = iD & i10;
        do {
            int i12 = iH - 1;
            int i13 = g()[i12];
            if ((i13 & i10) == i11 && c1.b0.a(object, f()[i12])) {
                return true;
            }
            iH = i13 & iE;
        } while (iH != 0);
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @t1.a
    @b1.e
    public Set<E> convertToHashFloodingResistantImplementation() {
        Set<E> setA = a(e() + 1);
        int iFirstEntryIndex = firstEntryIndex();
        while (iFirstEntryIndex >= 0) {
            setA.add(f()[iFirstEntryIndex]);
            iFirstEntryIndex = getSuccessor(iFirstEntryIndex);
        }
        this.f4843a = setA;
        this.f4844b = null;
        this.elements = null;
        incrementModCount();
        return setA;
    }

    @gm.a
    @b1.e
    public Set<E> delegateOrNull() {
        Object obj = this.f4843a;
        if (obj instanceof Set) {
            return (Set) obj;
        }
        return null;
    }

    public final int e() {
        return (1 << (this.f4845c & 31)) - 1;
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
        int[] iArr = this.f4844b;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    public int getSuccessor(int entryIndex) {
        int i10 = entryIndex + 1;
        if (i10 < this.f4846d) {
            return i10;
        }
        return -1;
    }

    public final Object i() {
        Object obj = this.f4843a;
        Objects.requireNonNull(obj);
        return obj;
    }

    public void incrementModCount() {
        this.f4845c += 32;
    }

    public void init(int expectedSize) {
        c1.h0.e(expectedSize >= 0, "Expected size must be >= 0");
        this.f4845c = o1.l.g(expectedSize, 1, 1073741823);
    }

    public void insertEntry(int entryIndex, @m5 E object, int hash, int mask) {
        m(entryIndex, f0.d(hash, 0, mask));
        l(entryIndex, object);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return size() == 0;
    }

    @b1.e
    public boolean isUsingHashFloodingResistance() {
        return delegateOrNull() != null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        Set<E> setDelegateOrNull = delegateOrNull();
        return setDelegateOrNull != null ? setDelegateOrNull.iterator() : new a();
    }

    public final void j(int newSize) {
        int iMin;
        int length = g().length;
        if (newSize <= length || (iMin = Math.min(1073741823, (Math.max(1, length >>> 1) + length) | 1)) == length) {
            return;
        }
        resizeEntries(iMin);
    }

    @t1.a
    public final int k(int oldMask, int newCapacity, int targetHash, int targetEntryIndex) {
        Object objA = f0.a(newCapacity);
        int i10 = newCapacity - 1;
        if (targetEntryIndex != 0) {
            f0.i(objA, targetHash & i10, targetEntryIndex + 1);
        }
        Object obj = this.f4843a;
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
        this.f4843a = objA;
        n(i10);
        return i10;
    }

    public final void l(int i10, E value) {
        f()[i10] = value;
    }

    public final void m(int i10, int value) {
        g()[i10] = value;
    }

    public void moveLastEntry(int dstIndex, int mask) {
        Object obj = this.f4843a;
        Objects.requireNonNull(obj);
        int[] iArrG = g();
        Object[] objArrF = f();
        int size = size();
        int i10 = size - 1;
        if (dstIndex >= i10) {
            objArrF[dstIndex] = null;
            iArrG[dstIndex] = 0;
            return;
        }
        Object obj2 = objArrF[i10];
        objArrF[dstIndex] = obj2;
        objArrF[i10] = null;
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

    public final void n(int mask) {
        this.f4845c = f0.d(this.f4845c, 32 - Integer.numberOfLeadingZeros(mask), 31);
    }

    @b1.e
    public boolean needsAllocArrays() {
        return this.f4843a == null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    @t1.a
    public boolean remove(@gm.a Object object) {
        if (needsAllocArrays()) {
            return false;
        }
        Set<E> setDelegateOrNull = delegateOrNull();
        if (setDelegateOrNull != null) {
            return setDelegateOrNull.remove(object);
        }
        int iE = e();
        Object obj = this.f4843a;
        Objects.requireNonNull(obj);
        int iF = f0.f(object, null, iE, obj, g(), f(), null);
        if (iF == -1) {
            return false;
        }
        moveLastEntry(iF, iE);
        this.f4846d--;
        incrementModCount();
        return true;
    }

    public void resizeEntries(int newCapacity) {
        this.f4844b = Arrays.copyOf(g(), newCapacity);
        this.elements = Arrays.copyOf(f(), newCapacity);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        Set<E> setDelegateOrNull = delegateOrNull();
        return setDelegateOrNull != null ? setDelegateOrNull.size() : this.f4846d;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        if (needsAllocArrays()) {
            return new Object[0];
        }
        Set<E> setDelegateOrNull = delegateOrNull();
        return setDelegateOrNull != null ? setDelegateOrNull.toArray() : Arrays.copyOf(f(), this.f4846d);
    }

    public void trimToSize() {
        if (needsAllocArrays()) {
            return;
        }
        Set<E> setDelegateOrNull = delegateOrNull();
        if (setDelegateOrNull != null) {
            Set<E> setA = a(size());
            setA.addAll(setDelegateOrNull);
            this.f4843a = setA;
            return;
        }
        int i10 = this.f4846d;
        if (i10 < g().length) {
            resizeEntries(i10);
        }
        int iJ = f0.j(i10);
        int iE = e();
        if (iJ < iE) {
            k(iE, iJ, 0, 0);
        }
    }

    public static <E> e0<E> create(Collection<? extends E> collection) {
        e0<E> e0VarCreateWithExpectedSize = createWithExpectedSize(collection.size());
        e0VarCreateWithExpectedSize.addAll(collection);
        return e0VarCreateWithExpectedSize;
    }

    public e0(int expectedSize) {
        init(expectedSize);
    }

    @SafeVarargs
    public static <E> e0<E> create(E... elements) {
        e0<E> e0VarCreateWithExpectedSize = createWithExpectedSize(elements.length);
        Collections.addAll(e0VarCreateWithExpectedSize, elements);
        return e0VarCreateWithExpectedSize;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    @t1.a
    public <T> T[] toArray(T[] tArr) {
        if (needsAllocArrays()) {
            if (tArr.length > 0) {
                tArr[0] = null;
            }
            return tArr;
        }
        Set<E> setDelegateOrNull = delegateOrNull();
        if (setDelegateOrNull != null) {
            return (T[]) setDelegateOrNull.toArray(tArr);
        }
        return (T[]) i5.n(f(), 0, this.f4846d, tArr);
    }
}
