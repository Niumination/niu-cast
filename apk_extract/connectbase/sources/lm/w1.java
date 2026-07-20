package lm;

/* JADX INFO: loaded from: classes3.dex */
@in.g
@p2(markerClass = {t.class})
@f1(version = "1.5")
public final class w1 implements Comparable<w1> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final a f10222b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f10223c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f10224d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f10225e = 4;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f10226f = 32;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f10227a;

    public static final class a {
        public a() {
        }

        public a(kn.w wVar) {
        }
    }

    @an.g
    @z0
    public /* synthetic */ w1(int i10) {
        this.f10227a = i10;
    }

    @an.f
    public static final int A(int i10) {
        return i10 + 1;
    }

    @an.f
    public static final int B(int i10) {
        return ~i10;
    }

    @an.f
    public static final int C(int i10, byte b10) {
        return i10 - (b10 & 255);
    }

    @an.f
    public static final long D(int i10, long j10) {
        return a2.m(((long) i10) & 4294967295L) - j10;
    }

    @an.f
    public static final int E(int i10, int i11) {
        return i10 - i11;
    }

    @an.f
    public static final int F(int i10, short s10) {
        return i10 - (s10 & g2.f10190d);
    }

    @an.f
    public static final byte G(int i10, byte b10) {
        return s1.m((byte) Integer.remainderUnsigned(i10, b10 & 255));
    }

    @an.f
    public static final long H(int i10, long j10) {
        return Long.remainderUnsigned(a2.m(((long) i10) & 4294967295L), j10);
    }

    @an.f
    public static final int I(int i10, int i11) {
        return Integer.remainderUnsigned(i10, i11);
    }

    @an.f
    public static final short J(int i10, short s10) {
        return g2.m((short) Integer.remainderUnsigned(i10, s10 & g2.f10190d));
    }

    @an.f
    public static final int K(int i10, int i11) {
        return i10 | i11;
    }

    @an.f
    public static final int L(int i10, byte b10) {
        return i10 + (b10 & 255);
    }

    @an.f
    public static final long M(int i10, long j10) {
        return a2.m(((long) i10) & 4294967295L) + j10;
    }

    @an.f
    public static final int N(int i10, int i11) {
        return i10 + i11;
    }

    @an.f
    public static final int O(int i10, short s10) {
        return i10 + (s10 & g2.f10190d);
    }

    @an.f
    public static final tn.x P(int i10, int i11) {
        return new tn.x(i10, i11, 1);
    }

    @f1(version = "1.9")
    @an.f
    @p2(markerClass = {r.class})
    public static final tn.x Q(int i10, int i11) {
        return tn.c0.V(i10, i11);
    }

    @an.f
    public static final int R(int i10, byte b10) {
        return Integer.remainderUnsigned(i10, b10 & 255);
    }

    @an.f
    public static final long S(int i10, long j10) {
        return Long.remainderUnsigned(a2.m(((long) i10) & 4294967295L), j10);
    }

    @an.f
    public static final int T(int i10, int i11) {
        return o2.e(i10, i11);
    }

    @an.f
    public static final int U(int i10, short s10) {
        return Integer.remainderUnsigned(i10, s10 & g2.f10190d);
    }

    @an.f
    public static final int V(int i10, int i11) {
        return i10 << i11;
    }

    @an.f
    public static final int W(int i10, int i11) {
        return i10 >>> i11;
    }

    @an.f
    public static final int X(int i10, byte b10) {
        return i10 * (b10 & 255);
    }

    @an.f
    public static final long Y(int i10, long j10) {
        return a2.m(((long) i10) & 4294967295L) * j10;
    }

    @an.f
    public static final int Z(int i10, int i11) {
        return i10 * i11;
    }

    @an.f
    public static final int a(int i10, int i11) {
        return i10 & i11;
    }

    @an.f
    public static final int a0(int i10, short s10) {
        return i10 * (s10 & g2.f10190d);
    }

    public static final /* synthetic */ w1 b(int i10) {
        return new w1(i10);
    }

    @an.f
    public static final byte b0(int i10) {
        return (byte) i10;
    }

    @an.f
    public static final double c0(int i10) {
        return o2.f(i10);
    }

    @an.f
    public static final int d(int i10, byte b10) {
        return Integer.compareUnsigned(i10, b10 & 255);
    }

    @an.f
    public static final float d0(int i10) {
        return (float) o2.f(i10);
    }

    @an.f
    public static final int e0(int i10) {
        return i10;
    }

    @an.f
    public static final int f(int i10, long j10) {
        return Long.compareUnsigned(a2.m(((long) i10) & 4294967295L), j10);
    }

    @an.f
    public static final long f0(int i10) {
        return ((long) i10) & 4294967295L;
    }

    @an.f
    public static final short g0(int i10) {
        return (short) i10;
    }

    @os.l
    public static String h0(int i10) {
        return String.valueOf(((long) i10) & 4294967295L);
    }

    @an.f
    public static final byte i0(int i10) {
        return s1.m((byte) i10);
    }

    @an.f
    public static final int j0(int i10) {
        return i10;
    }

    @an.f
    public static int k(int i10, int i11) {
        return o2.c(i10, i11);
    }

    @an.f
    public static final long k0(int i10) {
        return a2.m(((long) i10) & 4294967295L);
    }

    @an.f
    public static final int l(int i10, short s10) {
        return Integer.compareUnsigned(i10, s10 & g2.f10190d);
    }

    @an.f
    public static final short l0(int i10) {
        return g2.m((short) i10);
    }

    @an.g
    @z0
    public static int m(int i10) {
        return i10;
    }

    @an.f
    public static final int n(int i10) {
        return i10 - 1;
    }

    @an.f
    public static final int n0(int i10, int i11) {
        return i10 ^ i11;
    }

    @an.f
    public static final int o(int i10, byte b10) {
        return Integer.divideUnsigned(i10, b10 & 255);
    }

    @an.f
    public static final long p(int i10, long j10) {
        return Long.divideUnsigned(a2.m(((long) i10) & 4294967295L), j10);
    }

    @an.f
    public static final int q(int i10, int i11) {
        return o2.d(i10, i11);
    }

    @an.f
    public static final int r(int i10, short s10) {
        return Integer.divideUnsigned(i10, s10 & g2.f10190d);
    }

    public static boolean s(int i10, Object obj) {
        return (obj instanceof w1) && i10 == ((w1) obj).f10227a;
    }

    public static final boolean t(int i10, int i11) {
        return i10 == i11;
    }

    @an.f
    public static final int u(int i10, byte b10) {
        return Integer.divideUnsigned(i10, b10 & 255);
    }

    @an.f
    public static final long v(int i10, long j10) {
        return Long.divideUnsigned(a2.m(((long) i10) & 4294967295L), j10);
    }

    @an.f
    public static final int w(int i10, int i11) {
        return Integer.divideUnsigned(i10, i11);
    }

    @an.f
    public static final int x(int i10, short s10) {
        return Integer.divideUnsigned(i10, s10 & g2.f10190d);
    }

    @z0
    public static /* synthetic */ void y() {
    }

    public static int z(int i10) {
        return Integer.hashCode(i10);
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(w1 w1Var) {
        return o2.c(this.f10227a, w1Var.f10227a);
    }

    public boolean equals(Object obj) {
        return s(this.f10227a, obj);
    }

    @an.f
    public final int h(int i10) {
        return o2.c(this.f10227a, i10);
    }

    public int hashCode() {
        return Integer.hashCode(this.f10227a);
    }

    public final /* synthetic */ int m0() {
        return this.f10227a;
    }

    @os.l
    public String toString() {
        return h0(this.f10227a);
    }
}
