package f1;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true, serializable = true)
@x0
public class k5<K> extends j5<K> {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f5043r = -2;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @b1.e
    public transient long[] f5044o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public transient int f5045p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public transient int f5046q;

    public k5() {
        this(3);
    }

    public static <K> k5<K> F() {
        return new k5<>(3);
    }

    public static <K> k5<K> G(int expectedSize) {
        return new k5<>(expectedSize);
    }

    public final int H(int entry) {
        return (int) (this.f5044o[entry] >>> 32);
    }

    public final int I(int entry) {
        return (int) this.f5044o[entry];
    }

    public final void J(int entry, int pred) {
        long[] jArr = this.f5044o;
        jArr[entry] = (jArr[entry] & 4294967295L) | (((long) pred) << 32);
    }

    public final void K(int pred, int succ) {
        if (pred == -2) {
            this.f5045p = succ;
        } else {
            L(pred, succ);
        }
        if (succ == -2) {
            this.f5046q = pred;
        } else {
            J(succ, pred);
        }
    }

    public final void L(int entry, int succ) {
        long[] jArr = this.f5044o;
        jArr[entry] = (jArr[entry] & j5.f4984l) | (((long) succ) & 4294967295L);
    }

    @Override // f1.j5
    public void a() {
        super.a();
        this.f5045p = -2;
        this.f5046q = -2;
    }

    @Override // f1.j5
    public int f() {
        int i10 = this.f5045p;
        if (i10 == -2) {
            return -1;
        }
        return i10;
    }

    @Override // f1.j5
    public void o(int expectedSize, float loadFactor) {
        super.o(expectedSize, loadFactor);
        this.f5045p = -2;
        this.f5046q = -2;
        long[] jArr = new long[expectedSize];
        this.f5044o = jArr;
        Arrays.fill(jArr, -1L);
    }

    @Override // f1.j5
    public void p(int entryIndex, @m5 K key, int value, int hash) {
        super.p(entryIndex, key, value, hash);
        K(this.f5046q, entryIndex);
        K(entryIndex, -2);
    }

    @Override // f1.j5
    public void q(int dstIndex) {
        int iD = D() - 1;
        K(H(dstIndex), (int) this.f5044o[dstIndex]);
        if (dstIndex < iD) {
            K(H(iD), dstIndex);
            K(dstIndex, (int) this.f5044o[iD]);
        }
        super.q(dstIndex);
    }

    @Override // f1.j5
    public int t(int index) {
        int i10 = (int) this.f5044o[index];
        if (i10 == -2) {
            return -1;
        }
        return i10;
    }

    @Override // f1.j5
    public int u(int oldNextIndex, int removedIndex) {
        return oldNextIndex == D() ? removedIndex : oldNextIndex;
    }

    @Override // f1.j5
    public void z(int newCapacity) {
        super.z(newCapacity);
        long[] jArr = this.f5044o;
        int length = jArr.length;
        long[] jArrCopyOf = Arrays.copyOf(jArr, newCapacity);
        this.f5044o = jArrCopyOf;
        Arrays.fill(jArrCopyOf, length, newCapacity, -1L);
    }

    public k5(int expectedSize) {
        super(expectedSize, 1.0f);
    }

    public k5(int expectedSize, float loadFactor) {
        super(expectedSize, loadFactor);
    }

    public k5(j5<K> map) {
        o(map.D(), 1.0f);
        int iF = map.f();
        while (iF != -1) {
            v(map.j(iF), map.l(iF));
            iF = map.t(iF);
        }
    }
}
