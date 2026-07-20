package m1;

import c1.h0;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@e
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f10308a = 4503599627370495L;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f10309b = 9218868437227405312L;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f10310c = Long.MIN_VALUE;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f10311d = 52;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f10312e = 1023;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final long f10313f = 4503599627370496L;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @b1.e
    public static final long f10314g = 4607182418800017408L;

    public static double a(BigInteger x10) {
        BigInteger bigIntegerAbs = x10.abs();
        int iBitLength = bigIntegerAbs.bitLength();
        int i10 = iBitLength - 1;
        if (i10 < 63) {
            return x10.longValue();
        }
        if (i10 > 1023) {
            return ((double) x10.signum()) * Double.POSITIVE_INFINITY;
        }
        int i11 = iBitLength - 54;
        long jLongValue = bigIntegerAbs.shiftRight(i11).longValue();
        long j10 = jLongValue >> 1;
        long j11 = f10308a & j10;
        if ((jLongValue & 1) != 0 && ((j10 & 1) != 0 || bigIntegerAbs.getLowestSetBit() < i11)) {
            j11++;
        }
        return Double.longBitsToDouble(((((long) (iBitLength + 1022)) << 52) + j11) | (((long) x10.signum()) & Long.MIN_VALUE));
    }

    public static double b(double value) {
        h0.d(!Double.isNaN(value));
        return Math.max(value, 0.0d);
    }

    public static long c(double d10) {
        h0.e(d(d10), "not a normal value");
        int exponent = Math.getExponent(d10);
        long jDoubleToRawLongBits = Double.doubleToRawLongBits(d10) & f10308a;
        return exponent == -1023 ? jDoubleToRawLongBits << 1 : jDoubleToRawLongBits | f10313f;
    }

    public static boolean d(double d10) {
        return Math.getExponent(d10) <= 1023;
    }

    public static boolean e(double d10) {
        return Math.getExponent(d10) >= -1022;
    }

    public static double f(double d10) {
        return -Math.nextUp(-d10);
    }

    public static double g(double x10) {
        return Double.longBitsToDouble((Double.doubleToRawLongBits(x10) & f10308a) | f10314g);
    }
}
