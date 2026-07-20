package f1;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@x0
public class h0<E> extends e0<E> {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f4927p = -2;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @gm.a
    public transient int[] f4928f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @gm.a
    public transient int[] f4929g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public transient int f4930i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public transient int f4931n;

    public h0() {
    }

    public static <E> h0<E> create() {
        return new h0<>();
    }

    public static <E> h0<E> createWithExpectedSize(int expectedSize) {
        return new h0<>(expectedSize);
    }

    @Override // f1.e0
    public int adjustAfterRemove(int indexBeforeRemove, int indexRemoved) {
        return indexBeforeRemove >= size() ? indexRemoved : indexBeforeRemove;
    }

    @Override // f1.e0
    public int allocArrays() {
        int iAllocArrays = super.allocArrays();
        this.f4928f = new int[iAllocArrays];
        this.f4929g = new int[iAllocArrays];
        return iAllocArrays;
    }

    @Override // f1.e0, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        if (needsAllocArrays()) {
            return;
        }
        this.f4930i = -2;
        this.f4931n = -2;
        int[] iArr = this.f4928f;
        if (iArr != null && this.f4929g != null) {
            Arrays.fill(iArr, 0, size(), 0);
            Arrays.fill(this.f4929g, 0, size(), 0);
        }
        super.clear();
    }

    @Override // f1.e0
    @t1.a
    public Set<E> convertToHashFloodingResistantImplementation() {
        Set<E> setConvertToHashFloodingResistantImplementation = super.convertToHashFloodingResistantImplementation();
        this.f4928f = null;
        this.f4929g = null;
        return setConvertToHashFloodingResistantImplementation;
    }

    @Override // f1.e0
    public int firstEntryIndex() {
        return this.f4930i;
    }

    @Override // f1.e0
    public int getSuccessor(int entry) {
        return r()[entry] - 1;
    }

    @Override // f1.e0
    public void init(int expectedSize) {
        super.init(expectedSize);
        this.f4930i = -2;
        this.f4931n = -2;
    }

    @Override // f1.e0
    public void insertEntry(int entryIndex, @m5 E object, int hash, int mask) {
        super.insertEntry(entryIndex, object, hash, mask);
        t(this.f4931n, entryIndex);
        t(entryIndex, -2);
    }

    @Override // f1.e0
    public void moveLastEntry(int dstIndex, int mask) {
        int size = size() - 1;
        super.moveLastEntry(dstIndex, mask);
        t(o(dstIndex), getSuccessor(dstIndex));
        if (dstIndex < size) {
            t(o(size), dstIndex);
            t(dstIndex, getSuccessor(size));
        }
        q()[size] = 0;
        r()[size] = 0;
    }

    public final int o(int entry) {
        return q()[entry] - 1;
    }

    public final int[] q() {
        int[] iArr = this.f4928f;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    public final int[] r() {
        int[] iArr = this.f4929g;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    @Override // f1.e0
    public void resizeEntries(int newCapacity) {
        super.resizeEntries(newCapacity);
        this.f4928f = Arrays.copyOf(q(), newCapacity);
        this.f4929g = Arrays.copyOf(r(), newCapacity);
    }

    public final void s(int entry, int pred) {
        q()[entry] = pred + 1;
    }

    public final void t(int pred, int succ) {
        if (pred == -2) {
            this.f4930i = succ;
        } else {
            u(pred, succ);
        }
        if (succ == -2) {
            this.f4931n = pred;
        } else {
            s(succ, pred);
        }
    }

    @Override // f1.e0, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return i5.l(this);
    }

    public final void u(int entry, int succ) {
        r()[entry] = succ + 1;
    }

    public h0(int expectedSize) {
        super(expectedSize);
    }

    public static <E> h0<E> create(Collection<? extends E> collection) {
        h0<E> h0VarCreateWithExpectedSize = createWithExpectedSize(collection.size());
        h0VarCreateWithExpectedSize.addAll(collection);
        return h0VarCreateWithExpectedSize;
    }

    @Override // f1.e0, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        return (T[]) i5.m(this, tArr);
    }

    @SafeVarargs
    public static <E> h0<E> create(E... elements) {
        h0<E> h0VarCreateWithExpectedSize = createWithExpectedSize(elements.length);
        Collections.addAll(h0VarCreateWithExpectedSize, elements);
        return h0VarCreateWithExpectedSize;
    }
}
