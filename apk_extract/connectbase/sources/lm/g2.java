package lm;

/* JADX INFO: loaded from: classes3.dex */
@in.g
@p2(markerClass = {t.class})
@f1(version = "1.5")
public final class g2 implements Comparable<g2> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final a f10188b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final short f10189c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final short f10190d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f10191e = 2;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f10192f = 16;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final short f10193a;

    public static final class a {
        public a() {
        }

        public a(kn.w wVar) {
        }
    }

    @an.g
    @z0
    public /* synthetic */ g2(short s10) {
        this.f10193a = s10;
    }

    @an.f
    public static final short A(short s10) {
        return (short) (s10 + 1);
    }

    @an.f
    public static final short B(short s10) {
        return (short) (~s10);
    }

    @an.f
    public static final int C(short s10, byte b10) {
        return w1.m(s10 & f10190d) - (b10 & 255);
    }

    @an.f
    public static final long D(short s10, long j10) {
        return a2.m(((long) s10) & 65535) - j10;
    }

    @an.f
    public static final int E(short s10, int i10) {
        return w1.m(s10 & f10190d) - i10;
    }

    @an.f
    public static final int F(short s10, short s11) {
        return w1.m(s10 & f10190d) - (s11 & f10190d);
    }

    @an.f
    public static final byte G(short s10, byte b10) {
        return s1.m((byte) Integer.remainderUnsigned(w1.m(s10 & f10190d), b10 & 255));
    }

    @an.f
    public static final long H(short s10, long j10) {
        return Long.remainderUnsigned(a2.m(((long) s10) & 65535), j10);
    }

    @an.f
    public static final int I(short s10, int i10) {
        return Integer.remainderUnsigned(w1.m(s10 & f10190d), i10);
    }

    @an.f
    public static final short J(short s10, short s11) {
        return (short) Integer.remainderUnsigned(w1.m(s10 & f10190d), s11 & f10190d);
    }

    @an.f
    public static final short K(short s10, short s11) {
        return (short) (s10 | s11);
    }

    @an.f
    public static final int L(short s10, byte b10) {
        return w1.m(s10 & f10190d) + (b10 & 255);
    }

    @an.f
    public static final long M(short s10, long j10) {
        return a2.m(((long) s10) & 65535) + j10;
    }

    @an.f
    public static final int N(short s10, int i10) {
        return w1.m(s10 & f10190d) + i10;
    }

    @an.f
    public static final int O(short s10, short s11) {
        return w1.m(s10 & f10190d) + (s11 & f10190d);
    }

    @an.f
    public static final tn.x P(short s10, short s11) {
        return new tn.x(w1.m(s10 & f10190d), s11 & f10190d, 1);
    }

    @f1(version = "1.9")
    @an.f
    @p2(markerClass = {r.class})
    public static final tn.x Q(short s10, short s11) {
        return tn.c0.V(w1.m(s10 & f10190d), s11 & f10190d);
    }

    @an.f
    public static final int R(short s10, byte b10) {
        return Integer.remainderUnsigned(w1.m(s10 & f10190d), b10 & 255);
    }

    @an.f
    public static final long S(short s10, long j10) {
        return Long.remainderUnsigned(a2.m(((long) s10) & 65535), j10);
    }

    @an.f
    public static final int T(short s10, int i10) {
        return Integer.remainderUnsigned(w1.m(s10 & f10190d), i10);
    }

    @an.f
    public static final int U(short s10, short s11) {
        return Integer.remainderUnsigned(w1.m(s10 & f10190d), s11 & f10190d);
    }

    @an.f
    public static final int V(short s10, byte b10) {
        return w1.m(s10 & f10190d) * (b10 & 255);
    }

    @an.f
    public static final long W(short s10, long j10) {
        return a2.m(((long) s10) & 65535) * j10;
    }

    @an.f
    public static final int X(short s10, int i10) {
        return w1.m(s10 & f10190d) * i10;
    }

    @an.f
    public static final int Y(short s10, short s11) {
        return w1.m(s10 & f10190d) * (s11 & f10190d);
    }

    @an.f
    public static final byte Z(short s10) {
        return (byte) s10;
    }

    @an.f
    public static final short a(short s10, short s11) {
        return (short) (s10 & s11);
    }

    @an.f
    public static final double a0(short s10) {
        return s10 & f10190d;
    }

    public static final /* synthetic */ g2 b(short s10) {
        return new g2(s10);
    }

    @an.f
    public static final float b0(short s10) {
        return s10 & f10190d;
    }

    @an.f
    public static final int c0(short s10) {
        return s10 & f10190d;
    }

    @an.f
    public static final int d(short s10, byte b10) {
        return kn.l0.t(s10 & f10190d, b10 & 255);
    }

    @an.f
    public static final long d0(short s10) {
        return ((long) s10) & 65535;
    }

    @an.f
    public static final short e0(short s10) {
        return s10;
    }

    @an.f
    public static final int f(short s10, long j10) {
        return Long.compareUnsigned(a2.m(((long) s10) & 65535), j10);
    }

    @os.l
    public static String f0(short s10) {
        return String.valueOf(s10 & f10190d);
    }

    @an.f
    public static final byte g0(short s10) {
        return s1.m((byte) s10);
    }

    @an.f
    public static final int h(short s10, int i10) {
        return Integer.compareUnsigned(w1.m(s10 & f10190d), i10);
    }

    @an.f
    public static final int h0(short s10) {
        return w1.m(s10 & f10190d);
    }

    @an.f
    public static final long i0(short s10) {
        return a2.m(((long) s10) & 65535);
    }

    @an.f
    public static final short j0(short s10) {
        return s10;
    }

    @an.f
    public static int l(short s10, short s11) {
        return kn.l0.t(s10 & f10190d, s11 & f10190d);
    }

    @an.f
    public static final short l0(short s10, short s11) {
        return (short) (s10 ^ s11);
    }

    @an.g
    @z0
    public static short m(short s10) {
        return s10;
    }

    @an.f
    public static final short n(short s10) {
        return (short) (s10 - 1);
    }

    @an.f
    public static final int o(short s10, byte b10) {
        return Integer.divideUnsigned(w1.m(s10 & f10190d), b10 & 255);
    }

    @an.f
    public static final long p(short s10, long j10) {
        return Long.divideUnsigned(a2.m(((long) s10) & 65535), j10);
    }

    @an.f
    public static final int q(short s10, int i10) {
        return Integer.divideUnsigned(w1.m(s10 & f10190d), i10);
    }

    @an.f
    public static final int r(short s10, short s11) {
        return Integer.divideUnsigned(w1.m(s10 & f10190d), s11 & f10190d);
    }

    public static boolean s(short s10, Object obj) {
        return (obj instanceof g2) && s10 == ((g2) obj).f10193a;
    }

    public static final boolean t(short s10, short s11) {
        return s10 == s11;
    }

    @an.f
    public static final int u(short s10, byte b10) {
        return Integer.divideUnsigned(w1.m(s10 & f10190d), b10 & 255);
    }

    @an.f
    public static final long v(short s10, long j10) {
        return Long.divideUnsigned(a2.m(((long) s10) & 65535), j10);
    }

    @an.f
    public static final int w(short s10, int i10) {
        return Integer.divideUnsigned(w1.m(s10 & f10190d), i10);
    }

    @an.f
    public static final int x(short s10, short s11) {
        return Integer.divideUnsigned(w1.m(s10 & f10190d), s11 & f10190d);
    }

    @z0
    public static /* synthetic */ void y() {
    }

    public static int z(short s10) {
        return Short.hashCode(s10);
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(g2 g2Var) {
        return kn.l0.t(this.f10193a & f10190d, g2Var.f10193a & f10190d);
    }

    public boolean equals(Object obj) {
        return s(this.f10193a, obj);
    }

    public int hashCode() {
        return Short.hashCode(this.f10193a);
    }

    @an.f
    public final int k(short s10) {
        return kn.l0.t(this.f10193a & f10190d, s10 & f10190d);
    }

    public final /* synthetic */ short k0() {
        return this.f10193a;
    }

    @os.l
    public String toString() {
        return f0(this.f10193a);
    }
}
