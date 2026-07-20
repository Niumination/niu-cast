package lm;

/* JADX INFO: loaded from: classes3.dex */
@in.i(name = "UNumbersKt")
public final class f2 {
    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {t.class, r.class})
    public static final int A(int i10) {
        return w1.m(Integer.lowestOneBit(i10));
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {t.class, r.class})
    public static final short B(short s10) {
        return g2.m((short) Integer.lowestOneBit(s10 & g2.f10190d));
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {t.class, r.class})
    public static final int a(byte b10) {
        return Integer.numberOfLeadingZeros(b10 & 255) - 24;
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {t.class, r.class})
    public static final int b(long j10) {
        return Long.numberOfLeadingZeros(j10);
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {t.class, r.class})
    public static final int c(int i10) {
        return Integer.numberOfLeadingZeros(i10);
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {t.class, r.class})
    public static final int d(short s10) {
        return Integer.numberOfLeadingZeros(s10 & g2.f10190d) - 16;
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {t.class, r.class})
    public static final int e(byte b10) {
        return Integer.bitCount(w1.m(b10 & 255));
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {t.class, r.class})
    public static final int f(long j10) {
        return Long.bitCount(j10);
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {t.class, r.class})
    public static final int g(int i10) {
        return Integer.bitCount(i10);
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {t.class, r.class})
    public static final int h(short s10) {
        return Integer.bitCount(w1.m(s10 & g2.f10190d));
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {t.class, r.class})
    public static final int i(byte b10) {
        return Integer.numberOfTrailingZeros(b10 | 256);
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {t.class, r.class})
    public static final int j(long j10) {
        return Long.numberOfTrailingZeros(j10);
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {t.class, r.class})
    public static final int k(int i10) {
        return Integer.numberOfTrailingZeros(i10);
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {t.class, r.class})
    public static final int l(short s10) {
        return Integer.numberOfTrailingZeros(s10 | g2.f10189c);
    }

    @f1(version = "1.6")
    @an.f
    @p2(markerClass = {r.class, t.class})
    public static final long m(long j10, int i10) {
        return a2.m(Long.rotateLeft(j10, i10));
    }

    @f1(version = "1.6")
    @an.f
    @p2(markerClass = {r.class, t.class})
    public static final byte n(byte b10, int i10) {
        return s1.m(p0.Z0(b10, i10));
    }

    @f1(version = "1.6")
    @an.f
    @p2(markerClass = {r.class, t.class})
    public static final int o(int i10, int i11) {
        return w1.m(Integer.rotateLeft(i10, i11));
    }

    @f1(version = "1.6")
    @an.f
    @p2(markerClass = {r.class, t.class})
    public static final short p(short s10, int i10) {
        return g2.m(p0.a1(s10, i10));
    }

    @f1(version = "1.6")
    @an.f
    @p2(markerClass = {r.class, t.class})
    public static final long q(long j10, int i10) {
        return a2.m(Long.rotateRight(j10, i10));
    }

    @f1(version = "1.6")
    @an.f
    @p2(markerClass = {r.class, t.class})
    public static final byte r(byte b10, int i10) {
        return s1.m(p0.b1(b10, i10));
    }

    @f1(version = "1.6")
    @an.f
    @p2(markerClass = {r.class, t.class})
    public static final int s(int i10, int i11) {
        return w1.m(Integer.rotateRight(i10, i11));
    }

    @f1(version = "1.6")
    @an.f
    @p2(markerClass = {r.class, t.class})
    public static final short t(short s10, int i10) {
        return g2.m(p0.c1(s10, i10));
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {t.class, r.class})
    public static final byte u(byte b10) {
        return s1.m((byte) Integer.highestOneBit(b10 & 255));
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {t.class, r.class})
    public static final long v(long j10) {
        return a2.m(Long.highestOneBit(j10));
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {t.class, r.class})
    public static final int w(int i10) {
        return w1.m(Integer.highestOneBit(i10));
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {t.class, r.class})
    public static final short x(short s10) {
        return g2.m((short) Integer.highestOneBit(s10 & g2.f10190d));
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {t.class, r.class})
    public static final byte y(byte b10) {
        return s1.m((byte) Integer.lowestOneBit(b10 & 255));
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {t.class, r.class})
    public static final long z(long j10) {
        return a2.m(Long.lowestOneBit(j10));
    }
}
