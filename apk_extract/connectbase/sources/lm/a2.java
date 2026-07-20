package lm;

/* JADX INFO: loaded from: classes3.dex */
@in.g
@p2(markerClass = {t.class})
@f1(version = "1.5")
public final class a2 implements Comparable<a2> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final a f10172b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f10173c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f10174d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f10175e = 8;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f10176f = 64;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f10177a;

    public static final class a {
        public a() {
        }

        public a(kn.w wVar) {
        }
    }

    @an.g
    @z0
    public /* synthetic */ a2(long j10) {
        this.f10177a = j10;
    }

    @an.f
    public static final long A(long j10) {
        return j10 + 1;
    }

    @an.f
    public static final long B(long j10) {
        return ~j10;
    }

    @an.f
    public static final long C(long j10, byte b10) {
        return j10 - (((long) b10) & 255);
    }

    @an.f
    public static final long D(long j10, long j11) {
        return j10 - j11;
    }

    @an.f
    public static final long E(long j10, int i10) {
        return j10 - (((long) i10) & 4294967295L);
    }

    @an.f
    public static final long F(long j10, short s10) {
        return j10 - (((long) s10) & 65535);
    }

    @an.f
    public static final byte G(long j10, byte b10) {
        return s1.m((byte) Long.remainderUnsigned(j10, ((long) b10) & 255));
    }

    @an.f
    public static final long H(long j10, long j11) {
        return Long.remainderUnsigned(j10, j11);
    }

    @an.f
    public static final int I(long j10, int i10) {
        return w1.m((int) Long.remainderUnsigned(j10, ((long) i10) & 4294967295L));
    }

    @an.f
    public static final short J(long j10, short s10) {
        return g2.m((short) Long.remainderUnsigned(j10, ((long) s10) & 65535));
    }

    @an.f
    public static final long K(long j10, long j11) {
        return j10 | j11;
    }

    @an.f
    public static final long L(long j10, byte b10) {
        return j10 + (((long) b10) & 255);
    }

    @an.f
    public static final long M(long j10, long j11) {
        return j10 + j11;
    }

    @an.f
    public static final long N(long j10, int i10) {
        return j10 + (((long) i10) & 4294967295L);
    }

    @an.f
    public static final long O(long j10, short s10) {
        return j10 + (((long) s10) & 65535);
    }

    @an.f
    public static final tn.a0 P(long j10, long j11) {
        return new tn.a0(j10, j11);
    }

    @f1(version = "1.9")
    @an.f
    @p2(markerClass = {r.class})
    public static final tn.a0 Q(long j10, long j11) {
        return tn.c0.X(j10, j11);
    }

    @an.f
    public static final long R(long j10, byte b10) {
        return Long.remainderUnsigned(j10, ((long) b10) & 255);
    }

    @an.f
    public static final long S(long j10, long j11) {
        return o2.i(j10, j11);
    }

    @an.f
    public static final long T(long j10, int i10) {
        return Long.remainderUnsigned(j10, ((long) i10) & 4294967295L);
    }

    @an.f
    public static final long U(long j10, short s10) {
        return Long.remainderUnsigned(j10, ((long) s10) & 65535);
    }

    @an.f
    public static final long V(long j10, int i10) {
        return j10 << i10;
    }

    @an.f
    public static final long W(long j10, int i10) {
        return j10 >>> i10;
    }

    @an.f
    public static final long X(long j10, byte b10) {
        return j10 * (((long) b10) & 255);
    }

    @an.f
    public static final long Y(long j10, long j11) {
        return j10 * j11;
    }

    @an.f
    public static final long Z(long j10, int i10) {
        return j10 * (((long) i10) & 4294967295L);
    }

    @an.f
    public static final long a(long j10, long j11) {
        return j10 & j11;
    }

    @an.f
    public static final long a0(long j10, short s10) {
        return j10 * (((long) s10) & 65535);
    }

    public static final /* synthetic */ a2 b(long j10) {
        return new a2(j10);
    }

    @an.f
    public static final byte b0(long j10) {
        return (byte) j10;
    }

    @an.f
    public static final double c0(long j10) {
        return o2.j(j10);
    }

    @an.f
    public static final int d(long j10, byte b10) {
        return Long.compareUnsigned(j10, ((long) b10) & 255);
    }

    @an.f
    public static final float d0(long j10) {
        return (float) o2.j(j10);
    }

    @an.f
    public static final int e0(long j10) {
        return (int) j10;
    }

    @an.f
    public static final long f0(long j10) {
        return j10;
    }

    @an.f
    public static final short g0(long j10) {
        return (short) j10;
    }

    @an.f
    public static int h(long j10, long j11) {
        return o2.g(j10, j11);
    }

    @os.l
    public static String h0(long j10) {
        return o2.l(j10, 10);
    }

    @an.f
    public static final byte i0(long j10) {
        return s1.m((byte) j10);
    }

    @an.f
    public static final int j0(long j10) {
        return w1.m((int) j10);
    }

    @an.f
    public static final int k(long j10, int i10) {
        return Long.compareUnsigned(j10, ((long) i10) & 4294967295L);
    }

    @an.f
    public static final long k0(long j10) {
        return j10;
    }

    @an.f
    public static final int l(long j10, short s10) {
        return Long.compareUnsigned(j10, ((long) s10) & 65535);
    }

    @an.f
    public static final short l0(long j10) {
        return g2.m((short) j10);
    }

    @an.g
    @z0
    public static long m(long j10) {
        return j10;
    }

    @an.f
    public static final long n(long j10) {
        return j10 - 1;
    }

    @an.f
    public static final long n0(long j10, long j11) {
        return j10 ^ j11;
    }

    @an.f
    public static final long o(long j10, byte b10) {
        return Long.divideUnsigned(j10, ((long) b10) & 255);
    }

    @an.f
    public static final long p(long j10, long j11) {
        return o2.h(j10, j11);
    }

    @an.f
    public static final long q(long j10, int i10) {
        return Long.divideUnsigned(j10, ((long) i10) & 4294967295L);
    }

    @an.f
    public static final long r(long j10, short s10) {
        return Long.divideUnsigned(j10, ((long) s10) & 65535);
    }

    public static boolean s(long j10, Object obj) {
        return (obj instanceof a2) && j10 == ((a2) obj).f10177a;
    }

    public static final boolean t(long j10, long j11) {
        return j10 == j11;
    }

    @an.f
    public static final long u(long j10, byte b10) {
        return Long.divideUnsigned(j10, ((long) b10) & 255);
    }

    @an.f
    public static final long v(long j10, long j11) {
        return Long.divideUnsigned(j10, j11);
    }

    @an.f
    public static final long w(long j10, int i10) {
        return Long.divideUnsigned(j10, ((long) i10) & 4294967295L);
    }

    @an.f
    public static final long x(long j10, short s10) {
        return Long.divideUnsigned(j10, ((long) s10) & 65535);
    }

    @z0
    public static /* synthetic */ void y() {
    }

    public static int z(long j10) {
        return Long.hashCode(j10);
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(a2 a2Var) {
        return o2.g(this.f10177a, a2Var.f10177a);
    }

    public boolean equals(Object obj) {
        return s(this.f10177a, obj);
    }

    @an.f
    public final int f(long j10) {
        return o2.g(this.f10177a, j10);
    }

    public int hashCode() {
        return Long.hashCode(this.f10177a);
    }

    public final /* synthetic */ long m0() {
        return this.f10177a;
    }

    @os.l
    public String toString() {
        return o2.l(this.f10177a, 10);
    }
}
