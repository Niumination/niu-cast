package rm;

import kn.l0;
import lm.a2;
import lm.f1;
import lm.g2;
import lm.p2;
import lm.s1;
import lm.t;
import lm.w1;

/* JADX INFO: loaded from: classes3.dex */
public class n {
    @f1(version = "1.5")
    @p2(markerClass = {t.class})
    public static final short a(short s10, short s11) {
        return l0.t(s10 & g2.f10190d, 65535 & s11) >= 0 ? s10 : s11;
    }

    @f1(version = "1.5")
    @p2(markerClass = {t.class})
    public static int b(int i10, int i11) {
        return Integer.compareUnsigned(i10, i11) >= 0 ? i10 : i11;
    }

    @f1(version = "1.5")
    @p2(markerClass = {t.class})
    public static final byte c(byte b10, byte b11) {
        return l0.t(b10 & 255, b11 & 255) >= 0 ? b10 : b11;
    }

    @f1(version = "1.4")
    @t
    public static final int d(int i10, @os.l int... iArr) {
        l0.p(iArr, "other");
        for (int i11 : iArr) {
            i10 = b(i10, w1.m(i11));
        }
        return i10;
    }

    @f1(version = "1.4")
    @t
    public static final long e(long j10, @os.l long... jArr) {
        l0.p(jArr, "other");
        for (long j11 : jArr) {
            j10 = j(j10, a2.m(j11));
        }
        return j10;
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {t.class})
    public static final short f(short s10, short s11, short s12) {
        return a(s10, a(s11, s12));
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {t.class})
    public static final int g(int i10, int i11, int i12) {
        return b(i10, b(i11, i12));
    }

    @f1(version = "1.4")
    @t
    public static final byte h(byte b10, @os.l byte... bArr) {
        l0.p(bArr, "other");
        for (byte b11 : bArr) {
            b10 = c(b10, s1.m(b11));
        }
        return b10;
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {t.class})
    public static final byte i(byte b10, byte b11, byte b12) {
        return c(b10, c(b11, b12));
    }

    @f1(version = "1.5")
    @p2(markerClass = {t.class})
    public static long j(long j10, long j11) {
        return Long.compareUnsigned(j10, j11) >= 0 ? j10 : j11;
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {t.class})
    public static final long k(long j10, long j11, long j12) {
        return j(j10, j(j11, j12));
    }

    @f1(version = "1.4")
    @t
    public static final short l(short s10, @os.l short... sArr) {
        l0.p(sArr, "other");
        for (short s11 : sArr) {
            s10 = a(s10, g2.m(s11));
        }
        return s10;
    }

    @f1(version = "1.5")
    @p2(markerClass = {t.class})
    public static final short m(short s10, short s11) {
        return l0.t(s10 & g2.f10190d, 65535 & s11) <= 0 ? s10 : s11;
    }

    @f1(version = "1.5")
    @p2(markerClass = {t.class})
    public static int n(int i10, int i11) {
        return Integer.compareUnsigned(i10, i11) <= 0 ? i10 : i11;
    }

    @f1(version = "1.5")
    @p2(markerClass = {t.class})
    public static final byte o(byte b10, byte b11) {
        return l0.t(b10 & 255, b11 & 255) <= 0 ? b10 : b11;
    }

    @f1(version = "1.4")
    @t
    public static final int p(int i10, @os.l int... iArr) {
        l0.p(iArr, "other");
        for (int i11 : iArr) {
            i10 = n(i10, w1.m(i11));
        }
        return i10;
    }

    @f1(version = "1.4")
    @t
    public static final long q(long j10, @os.l long... jArr) {
        l0.p(jArr, "other");
        for (long j11 : jArr) {
            j10 = v(j10, a2.m(j11));
        }
        return j10;
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {t.class})
    public static final short r(short s10, short s11, short s12) {
        return m(s10, m(s11, s12));
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {t.class})
    public static final int s(int i10, int i11, int i12) {
        return n(i10, n(i11, i12));
    }

    @f1(version = "1.4")
    @t
    public static final byte t(byte b10, @os.l byte... bArr) {
        l0.p(bArr, "other");
        for (byte b11 : bArr) {
            b10 = o(b10, s1.m(b11));
        }
        return b10;
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {t.class})
    public static final byte u(byte b10, byte b11, byte b12) {
        return o(b10, o(b11, b12));
    }

    @f1(version = "1.5")
    @p2(markerClass = {t.class})
    public static long v(long j10, long j11) {
        return Long.compareUnsigned(j10, j11) <= 0 ? j10 : j11;
    }

    @f1(version = "1.5")
    @an.f
    @p2(markerClass = {t.class})
    public static final long w(long j10, long j11, long j12) {
        return v(j10, v(j11, j12));
    }

    @f1(version = "1.4")
    @t
    public static final short x(short s10, @os.l short... sArr) {
        l0.p(sArr, "other");
        for (short s11 : sArr) {
            s10 = m(s10, g2.m(s11));
        }
        return s10;
    }
}
