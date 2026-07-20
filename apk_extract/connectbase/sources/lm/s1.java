package lm;

import io.netty.handler.codec.http2.Http2CodecUtil;

/* JADX INFO: loaded from: classes3.dex */
@in.g
@p2(markerClass = {t.class})
@f1(version = "1.5")
public final class s1 implements Comparable<s1> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final a f10213b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte f10214c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final byte f10215d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f10216e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f10217f = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte f10218a;

    public static final class a {
        public a() {
        }

        public a(kn.w wVar) {
        }
    }

    @an.g
    @z0
    public /* synthetic */ s1(byte b10) {
        this.f10218a = b10;
    }

    @an.f
    public static final byte A(byte b10) {
        return (byte) (b10 + 1);
    }

    @an.f
    public static final byte B(byte b10) {
        return (byte) (~b10);
    }

    @an.f
    public static final int C(byte b10, byte b11) {
        return w1.m(b10 & 255) - (b11 & 255);
    }

    @an.f
    public static final long D(byte b10, long j10) {
        return a2.m(((long) b10) & 255) - j10;
    }

    @an.f
    public static final int E(byte b10, int i10) {
        return w1.m(b10 & 255) - i10;
    }

    @an.f
    public static final int F(byte b10, short s10) {
        return w1.m(b10 & 255) - (s10 & g2.f10190d);
    }

    @an.f
    public static final byte G(byte b10, byte b11) {
        return (byte) Integer.remainderUnsigned(w1.m(b10 & 255), b11 & 255);
    }

    @an.f
    public static final long H(byte b10, long j10) {
        return Long.remainderUnsigned(a2.m(((long) b10) & 255), j10);
    }

    @an.f
    public static final int I(byte b10, int i10) {
        return Integer.remainderUnsigned(w1.m(b10 & 255), i10);
    }

    @an.f
    public static final short J(byte b10, short s10) {
        return g2.m((short) Integer.remainderUnsigned(w1.m(b10 & 255), s10 & g2.f10190d));
    }

    @an.f
    public static final byte K(byte b10, byte b11) {
        return (byte) (b10 | b11);
    }

    @an.f
    public static final int L(byte b10, byte b11) {
        return w1.m(b10 & 255) + (b11 & 255);
    }

    @an.f
    public static final long M(byte b10, long j10) {
        return a2.m(((long) b10) & 255) + j10;
    }

    @an.f
    public static final int N(byte b10, int i10) {
        return w1.m(b10 & 255) + i10;
    }

    @an.f
    public static final int O(byte b10, short s10) {
        return w1.m(b10 & 255) + (s10 & g2.f10190d);
    }

    @an.f
    public static final tn.x P(byte b10, byte b11) {
        return new tn.x(w1.m(b10 & 255), b11 & 255, 1);
    }

    @f1(version = "1.9")
    @an.f
    @p2(markerClass = {r.class})
    public static final tn.x Q(byte b10, byte b11) {
        return tn.c0.V(w1.m(b10 & 255), b11 & 255);
    }

    @an.f
    public static final int R(byte b10, byte b11) {
        return Integer.remainderUnsigned(w1.m(b10 & 255), b11 & 255);
    }

    @an.f
    public static final long S(byte b10, long j10) {
        return Long.remainderUnsigned(a2.m(((long) b10) & 255), j10);
    }

    @an.f
    public static final int T(byte b10, int i10) {
        return Integer.remainderUnsigned(w1.m(b10 & 255), i10);
    }

    @an.f
    public static final int U(byte b10, short s10) {
        return Integer.remainderUnsigned(w1.m(b10 & 255), s10 & g2.f10190d);
    }

    @an.f
    public static final int V(byte b10, byte b11) {
        return w1.m(b10 & 255) * (b11 & 255);
    }

    @an.f
    public static final long W(byte b10, long j10) {
        return a2.m(((long) b10) & 255) * j10;
    }

    @an.f
    public static final int X(byte b10, int i10) {
        return w1.m(b10 & 255) * i10;
    }

    @an.f
    public static final int Y(byte b10, short s10) {
        return w1.m(b10 & 255) * (s10 & g2.f10190d);
    }

    @an.f
    public static final byte Z(byte b10) {
        return b10;
    }

    @an.f
    public static final byte a(byte b10, byte b11) {
        return (byte) (b10 & b11);
    }

    @an.f
    public static final double a0(byte b10) {
        return b10 & 255;
    }

    public static final /* synthetic */ s1 b(byte b10) {
        return new s1(b10);
    }

    @an.f
    public static final float b0(byte b10) {
        return b10 & 255;
    }

    @an.f
    public static final int c0(byte b10) {
        return b10 & 255;
    }

    @an.f
    public static final long d0(byte b10) {
        return ((long) b10) & 255;
    }

    @an.f
    public static final short e0(byte b10) {
        return (short) (b10 & Http2CodecUtil.MAX_UNSIGNED_BYTE);
    }

    @an.f
    public static int f(byte b10, byte b11) {
        return kn.l0.t(b10 & 255, b11 & 255);
    }

    @os.l
    public static String f0(byte b10) {
        return String.valueOf(b10 & 255);
    }

    @an.f
    public static final byte g0(byte b10) {
        return b10;
    }

    @an.f
    public static final int h(byte b10, long j10) {
        return Long.compareUnsigned(a2.m(((long) b10) & 255), j10);
    }

    @an.f
    public static final int h0(byte b10) {
        return w1.m(b10 & 255);
    }

    @an.f
    public static final long i0(byte b10) {
        return a2.m(((long) b10) & 255);
    }

    @an.f
    public static final short j0(byte b10) {
        return g2.m((short) (b10 & Http2CodecUtil.MAX_UNSIGNED_BYTE));
    }

    @an.f
    public static final int k(byte b10, int i10) {
        return Integer.compareUnsigned(w1.m(b10 & 255), i10);
    }

    @an.f
    public static final int l(byte b10, short s10) {
        return kn.l0.t(b10 & 255, s10 & g2.f10190d);
    }

    @an.f
    public static final byte l0(byte b10, byte b11) {
        return (byte) (b10 ^ b11);
    }

    @an.g
    @z0
    public static byte m(byte b10) {
        return b10;
    }

    @an.f
    public static final byte n(byte b10) {
        return (byte) (b10 - 1);
    }

    @an.f
    public static final int o(byte b10, byte b11) {
        return Integer.divideUnsigned(w1.m(b10 & 255), b11 & 255);
    }

    @an.f
    public static final long p(byte b10, long j10) {
        return Long.divideUnsigned(a2.m(((long) b10) & 255), j10);
    }

    @an.f
    public static final int q(byte b10, int i10) {
        return Integer.divideUnsigned(w1.m(b10 & 255), i10);
    }

    @an.f
    public static final int r(byte b10, short s10) {
        return Integer.divideUnsigned(w1.m(b10 & 255), s10 & g2.f10190d);
    }

    public static boolean s(byte b10, Object obj) {
        return (obj instanceof s1) && b10 == ((s1) obj).f10218a;
    }

    public static final boolean t(byte b10, byte b11) {
        return b10 == b11;
    }

    @an.f
    public static final int u(byte b10, byte b11) {
        return Integer.divideUnsigned(w1.m(b10 & 255), b11 & 255);
    }

    @an.f
    public static final long v(byte b10, long j10) {
        return Long.divideUnsigned(a2.m(((long) b10) & 255), j10);
    }

    @an.f
    public static final int w(byte b10, int i10) {
        return Integer.divideUnsigned(w1.m(b10 & 255), i10);
    }

    @an.f
    public static final int x(byte b10, short s10) {
        return Integer.divideUnsigned(w1.m(b10 & 255), s10 & g2.f10190d);
    }

    @z0
    public static /* synthetic */ void y() {
    }

    public static int z(byte b10) {
        return Byte.hashCode(b10);
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(s1 s1Var) {
        return kn.l0.t(this.f10218a & 255, s1Var.f10218a & 255);
    }

    @an.f
    public final int d(byte b10) {
        return kn.l0.t(this.f10218a & 255, b10 & 255);
    }

    public boolean equals(Object obj) {
        return s(this.f10218a, obj);
    }

    public int hashCode() {
        return Byte.hashCode(this.f10218a);
    }

    public final /* synthetic */ byte k0() {
        return this.f10218a;
    }

    @os.l
    public String toString() {
        return f0(this.f10218a);
    }
}
