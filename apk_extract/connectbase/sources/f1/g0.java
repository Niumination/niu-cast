package f1;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@x0
@b1.d
public class g0<K, V> extends d0<K, V> {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f4883v = -2;
    private final boolean accessOrder;

    @gm.a
    @b1.e
    transient long[] links;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public transient int f4884n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public transient int f4885p;

    public g0() {
        this(3);
    }

    public static <K, V> g0<K, V> create() {
        return new g0<>();
    }

    public static <K, V> g0<K, V> createWithExpectedSize(int expectedSize) {
        return new g0<>(expectedSize);
    }

    public final void A(int entry, int succ) {
        x(entry, (w()[entry] & j5.f4984l) | (((long) (succ + 1)) & 4294967295L));
    }

    @Override // f1.d0
    public void accessEntry(int index) {
        if (this.accessOrder) {
            z(u(index), getSuccessor(index));
            z(this.f4885p, index);
            z(index, -2);
            incrementModCount();
        }
    }

    @Override // f1.d0
    public int adjustAfterRemove(int indexBeforeRemove, int indexRemoved) {
        return indexBeforeRemove >= size() ? indexRemoved : indexBeforeRemove;
    }

    @Override // f1.d0
    public int allocArrays() {
        int iAllocArrays = super.allocArrays();
        this.links = new long[iAllocArrays];
        return iAllocArrays;
    }

    @Override // f1.d0, java.util.AbstractMap, java.util.Map
    public void clear() {
        if (needsAllocArrays()) {
            return;
        }
        this.f4884n = -2;
        this.f4885p = -2;
        long[] jArr = this.links;
        if (jArr != null) {
            Arrays.fill(jArr, 0, size(), 0L);
        }
        super.clear();
    }

    @Override // f1.d0
    @t1.a
    public Map<K, V> convertToHashFloodingResistantImplementation() {
        Map<K, V> mapConvertToHashFloodingResistantImplementation = super.convertToHashFloodingResistantImplementation();
        this.links = null;
        return mapConvertToHashFloodingResistantImplementation;
    }

    @Override // f1.d0
    public Map<K, V> createHashFloodingResistantDelegate(int tableSize) {
        return new LinkedHashMap(tableSize, 1.0f, this.accessOrder);
    }

    @Override // f1.d0
    public int firstEntryIndex() {
        return this.f4884n;
    }

    @Override // f1.d0
    public int getSuccessor(int entry) {
        return ((int) w()[entry]) - 1;
    }

    @Override // f1.d0
    public void init(int expectedSize) {
        super.init(expectedSize);
        this.f4884n = -2;
        this.f4885p = -2;
    }

    @Override // f1.d0
    public void insertEntry(int entryIndex, @m5 K key, @m5 V value, int hash, int mask) {
        super.insertEntry(entryIndex, key, value, hash, mask);
        z(this.f4885p, entryIndex);
        z(entryIndex, -2);
    }

    @Override // f1.d0
    public void moveLastEntry(int dstIndex, int mask) {
        int size = size() - 1;
        super.moveLastEntry(dstIndex, mask);
        z(u(dstIndex), getSuccessor(dstIndex));
        if (dstIndex < size) {
            z(u(size), dstIndex);
            z(dstIndex, getSuccessor(size));
        }
        x(size, 0L);
    }

    @Override // f1.d0
    public void resizeEntries(int newCapacity) {
        super.resizeEntries(newCapacity);
        this.links = Arrays.copyOf(w(), newCapacity);
    }

    public final int u(int entry) {
        return ((int) (w()[entry] >>> 32)) - 1;
    }

    public final long v(int i10) {
        return w()[i10];
    }

    public final long[] w() {
        long[] jArr = this.links;
        Objects.requireNonNull(jArr);
        return jArr;
    }

    public final void x(int i10, long value) {
        w()[i10] = value;
    }

    public final void y(int entry, int pred) {
        x(entry, (w()[entry] & 4294967295L) | (((long) (pred + 1)) << 32));
    }

    public final void z(int pred, int succ) {
        if (pred == -2) {
            this.f4884n = succ;
        } else {
            A(pred, succ);
        }
        if (succ == -2) {
            this.f4885p = pred;
        } else {
            y(succ, pred);
        }
    }

    public g0(int expectedSize) {
        this(expectedSize, false);
    }

    public g0(int expectedSize, boolean accessOrder) {
        super(expectedSize);
        this.accessOrder = accessOrder;
    }
}
