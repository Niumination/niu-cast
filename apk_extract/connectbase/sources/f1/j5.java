package f1;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true, serializable = true)
@x0
public class j5<K> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f4981i = 1073741824;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final float f4982j = 1.0f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final long f4983k = 4294967295L;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final long f4984l = -4294967296L;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f4985m = 3;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f4986n = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient Object[] f4987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient int[] f4988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient int f4989c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public transient int f4990d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public transient int[] f4991e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @b1.e
    public transient long[] f4992f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public transient float f4993g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public transient int f4994h;

    public class a extends c5.f<K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @m5
        public final K f4995a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f4996b;

        public a(int i10) {
            this.f4995a = (K) j5.this.f4987a[i10];
            this.f4996b = i10;
        }

        @t1.a
        public int a(int count) {
            b();
            int i10 = this.f4996b;
            if (i10 == -1) {
                j5.this.v(this.f4995a, count);
                return 0;
            }
            int[] iArr = j5.this.f4988b;
            int i11 = iArr[i10];
            iArr[i10] = count;
            return i11;
        }

        public void b() {
            int i10 = this.f4996b;
            if (i10 == -1 || i10 >= j5.this.D() || !c1.b0.a(this.f4995a, j5.this.f4987a[this.f4996b])) {
                this.f4996b = j5.this.n(this.f4995a);
            }
        }

        @Override // f1.b5.a
        public int getCount() {
            b();
            int i10 = this.f4996b;
            if (i10 == -1) {
                return 0;
            }
            return j5.this.f4988b[i10];
        }

        @Override // f1.b5.a
        @m5
        public K getElement() {
            return this.f4995a;
        }
    }

    public j5() {
        o(3, 1.0f);
    }

    public static long E(long entry, int newNext) {
        return (entry & f4984l) | (4294967295L & ((long) newNext));
    }

    public static <K> j5<K> c() {
        return new j5<>();
    }

    public static <K> j5<K> d(int expectedSize) {
        return new j5<>(expectedSize);
    }

    public static int i(long entry) {
        return (int) (entry >>> 32);
    }

    public static int k(long entry) {
        return (int) entry;
    }

    public static long[] r(int size) {
        long[] jArr = new long[size];
        Arrays.fill(jArr, -1L);
        return jArr;
    }

    public static int[] s(int size) {
        int[] iArr = new int[size];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    public final void A(int newSize) {
        int length = this.f4992f.length;
        if (newSize > length) {
            int iMax = Math.max(1, length >>> 1) + length;
            if (iMax < 0) {
                iMax = Integer.MAX_VALUE;
            }
            if (iMax != length) {
                z(iMax);
            }
        }
    }

    public final void B(int newCapacity) {
        if (this.f4991e.length >= 1073741824) {
            this.f4994h = Integer.MAX_VALUE;
            return;
        }
        int i10 = ((int) (newCapacity * this.f4993g)) + 1;
        int[] iArrS = s(newCapacity);
        long[] jArr = this.f4992f;
        int length = iArrS.length - 1;
        for (int i11 = 0; i11 < this.f4989c; i11++) {
            int i12 = (int) (jArr[i11] >>> 32);
            int i13 = i12 & length;
            int i14 = iArrS[i13];
            iArrS[i13] = i11;
            jArr[i11] = (((long) i12) << 32) | (((long) i14) & 4294967295L);
        }
        this.f4994h = i10;
        this.f4991e = iArrS;
    }

    public void C(int index, int newValue) {
        c1.h0.C(index, this.f4989c);
        this.f4988b[index] = newValue;
    }

    public int D() {
        return this.f4989c;
    }

    public void a() {
        this.f4990d++;
        Arrays.fill(this.f4987a, 0, this.f4989c, (Object) null);
        Arrays.fill(this.f4988b, 0, this.f4989c, 0);
        Arrays.fill(this.f4991e, -1);
        Arrays.fill(this.f4992f, -1L);
        this.f4989c = 0;
    }

    public boolean b(@gm.a Object key) {
        return n(key) != -1;
    }

    public void e(int minCapacity) {
        if (minCapacity > this.f4992f.length) {
            z(minCapacity);
        }
        if (minCapacity >= this.f4994h) {
            B(Math.max(2, Integer.highestOneBit(minCapacity - 1) << 1));
        }
    }

    public int f() {
        return this.f4989c == 0 ? -1 : 0;
    }

    public int g(@gm.a Object key) {
        int iN = n(key);
        if (iN == -1) {
            return 0;
        }
        return this.f4988b[iN];
    }

    public b5.a<K> h(int index) {
        c1.h0.C(index, this.f4989c);
        return new a(index);
    }

    @m5
    public K j(int i10) {
        c1.h0.C(i10, this.f4989c);
        return (K) this.f4987a[i10];
    }

    public int l(int index) {
        c1.h0.C(index, this.f4989c);
        return this.f4988b[index];
    }

    public final int m() {
        return this.f4991e.length - 1;
    }

    public int n(@gm.a Object key) {
        int iD = z2.d(key);
        int i10 = this.f4991e[m() & iD];
        while (i10 != -1) {
            long j10 = this.f4992f[i10];
            if (((int) (j10 >>> 32)) == iD && c1.b0.a(key, this.f4987a[i10])) {
                return i10;
            }
            i10 = (int) j10;
        }
        return -1;
    }

    public void o(int expectedSize, float loadFactor) {
        c1.h0.e(expectedSize >= 0, "Initial capacity must be non-negative");
        c1.h0.e(loadFactor > 0.0f, "Illegal load factor");
        int iA = z2.a(expectedSize, loadFactor);
        this.f4991e = s(iA);
        this.f4993g = loadFactor;
        this.f4987a = new Object[expectedSize];
        this.f4988b = new int[expectedSize];
        this.f4992f = r(expectedSize);
        this.f4994h = Math.max(1, (int) (iA * loadFactor));
    }

    public void p(int entryIndex, @m5 K key, int value, int hash) {
        this.f4992f[entryIndex] = (((long) hash) << 32) | 4294967295L;
        this.f4987a[entryIndex] = key;
        this.f4988b[entryIndex] = value;
    }

    public void q(int dstIndex) {
        int iD = D() - 1;
        if (dstIndex >= iD) {
            this.f4987a[dstIndex] = null;
            this.f4988b[dstIndex] = 0;
            this.f4992f[dstIndex] = -1;
            return;
        }
        Object[] objArr = this.f4987a;
        objArr[dstIndex] = objArr[iD];
        int[] iArr = this.f4988b;
        iArr[dstIndex] = iArr[iD];
        objArr[iD] = null;
        iArr[iD] = 0;
        long[] jArr = this.f4992f;
        long j10 = jArr[iD];
        jArr[dstIndex] = j10;
        jArr[iD] = -1;
        int iM = ((int) (j10 >>> 32)) & m();
        int[] iArr2 = this.f4991e;
        int i10 = iArr2[iM];
        if (i10 == iD) {
            iArr2[iM] = dstIndex;
            return;
        }
        while (true) {
            long[] jArr2 = this.f4992f;
            long j11 = jArr2[i10];
            int i11 = (int) j11;
            if (i11 == iD) {
                jArr2[i10] = E(j11, dstIndex);
                return;
            }
            i10 = i11;
        }
    }

    public int t(int index) {
        int i10 = index + 1;
        if (i10 < this.f4989c) {
            return i10;
        }
        return -1;
    }

    public int u(int oldNextIndex, int removedIndex) {
        return oldNextIndex - 1;
    }

    @t1.a
    public int v(@m5 K key, int value) {
        b0.d(value, "count");
        long[] jArr = this.f4992f;
        Object[] objArr = this.f4987a;
        int[] iArr = this.f4988b;
        int iD = z2.d(key);
        int iM = m() & iD;
        int i10 = this.f4989c;
        int[] iArr2 = this.f4991e;
        int i11 = iArr2[iM];
        if (i11 == -1) {
            iArr2[iM] = i10;
        } else {
            while (true) {
                long j10 = jArr[i11];
                if (((int) (j10 >>> 32)) == iD && c1.b0.a(key, objArr[i11])) {
                    int i12 = iArr[i11];
                    iArr[i11] = value;
                    return i12;
                }
                int i13 = (int) j10;
                if (i13 == -1) {
                    jArr[i11] = E(j10, i10);
                    break;
                }
                i11 = i13;
            }
        }
        if (i10 == Integer.MAX_VALUE) {
            throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
        }
        int i14 = i10 + 1;
        A(i14);
        p(i10, key, value, iD);
        this.f4989c = i14;
        if (i10 >= this.f4994h) {
            B(this.f4991e.length * 2);
        }
        this.f4990d++;
        return 0;
    }

    @t1.a
    public int w(@gm.a Object key) {
        return x(key, z2.d(key));
    }

    public final int x(@gm.a Object key, int hash) {
        int iM = m() & hash;
        int i10 = this.f4991e[iM];
        if (i10 == -1) {
            return 0;
        }
        int i11 = -1;
        while (true) {
            if (((int) (this.f4992f[i10] >>> 32)) == hash && c1.b0.a(key, this.f4987a[i10])) {
                int i12 = this.f4988b[i10];
                if (i11 == -1) {
                    this.f4991e[iM] = (int) this.f4992f[i10];
                } else {
                    long[] jArr = this.f4992f;
                    jArr[i11] = E(jArr[i11], (int) jArr[i10]);
                }
                q(i10);
                this.f4989c--;
                this.f4990d++;
                return i12;
            }
            int i13 = (int) this.f4992f[i10];
            if (i13 == -1) {
                return 0;
            }
            i11 = i10;
            i10 = i13;
        }
    }

    @t1.a
    public int y(int entryIndex) {
        return x(this.f4987a[entryIndex], (int) (this.f4992f[entryIndex] >>> 32));
    }

    public void z(int newCapacity) {
        this.f4987a = Arrays.copyOf(this.f4987a, newCapacity);
        this.f4988b = Arrays.copyOf(this.f4988b, newCapacity);
        long[] jArr = this.f4992f;
        int length = jArr.length;
        long[] jArrCopyOf = Arrays.copyOf(jArr, newCapacity);
        if (newCapacity > length) {
            Arrays.fill(jArrCopyOf, length, newCapacity, -1L);
        }
        this.f4992f = jArrCopyOf;
    }

    public j5(j5<? extends K> map) {
        o(map.D(), 1.0f);
        int iF = map.f();
        while (iF != -1) {
            v(map.j(iF), map.l(iF));
            iF = map.t(iF);
        }
    }

    public j5(int capacity) {
        this(capacity, 1.0f);
    }

    public j5(int expectedSize, float loadFactor) {
        o(expectedSize, loadFactor);
    }
}
