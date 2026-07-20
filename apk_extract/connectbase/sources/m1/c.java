package m1;

import c1.h0;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true)
@e
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final double f10300a = -2.147483648E9d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final double f10301b = 2.147483647E9d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final double f10302c = -9.223372036854776E18d;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final double f10303d = 9.223372036854776E18d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @b1.e
    public static final int f10305f = 170;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final double f10304e = Math.log(2.0d);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @b1.e
    public static final double[] f10306g = {1.0d, 2.0922789888E13d, 2.631308369336935E35d, 1.2413915592536073E61d, 1.2688693218588417E89d, 7.156945704626381E118d, 9.916779348709496E149d, 1.974506857221074E182d, 3.856204823625804E215d, 5.5502938327393044E249d, 4.7147236359920616E284d};

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10307a;

        static {
            int[] iArr = new int[RoundingMode.values().length];
            f10307a = iArr;
            try {
                iArr[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10307a[RoundingMode.FLOOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10307a[RoundingMode.CEILING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10307a[RoundingMode.DOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f10307a[RoundingMode.UP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f10307a[RoundingMode.HALF_EVEN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f10307a[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f10307a[RoundingMode.HALF_DOWN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    @b1.c
    @t1.a
    @b1.d
    public static double a(double argument) {
        h0.d(d.d(argument));
        return argument;
    }

    public static double b(int n10) {
        i.e(p6.n.f13005a, n10);
        if (n10 > 170) {
            return Double.POSITIVE_INFINITY;
        }
        double d10 = 1.0d;
        for (int i10 = (n10 & (-16)) + 1; i10 <= n10; i10++) {
            d10 *= (double) i10;
        }
        return d10 * f10306g[n10 >> 4];
    }

    public static int c(double a10, double b10, double tolerance) {
        if (d(a10, b10, tolerance)) {
            return 0;
        }
        if (a10 < b10) {
            return -1;
        }
        if (a10 > b10) {
            return 1;
        }
        return o1.a.d(Double.isNaN(a10), Double.isNaN(b10));
    }

    public static boolean d(double a10, double b10, double tolerance) {
        i.d("tolerance", tolerance);
        return Math.copySign(a10 - b10, 1.0d) <= tolerance || a10 == b10 || (Double.isNaN(a10) && Double.isNaN(b10));
    }

    @b1.c
    public static boolean e(double x10) {
        return d.d(x10) && (x10 == 0.0d || 52 - Long.numberOfTrailingZeros(d.c(x10)) <= Math.getExponent(x10));
    }

    @b1.c
    @b1.d
    public static boolean f(double x10) {
        if (x10 <= 0.0d || !d.d(x10)) {
            return false;
        }
        long jC = d.c(x10);
        return (jC & (jC - 1)) == 0;
    }

    public static double g(double x10) {
        return Math.log(x10) / f10304e;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:29:0x006a  */
    /* JADX WARN: Code duplicated, block: B:31:? A[RETURN, SYNTHETIC] */
    @b1.c
    @b1.d
    public static int h(double x10, RoundingMode mode) {
        boolean zF;
        boolean z10 = false;
        h0.e(x10 > 0.0d && d.d(x10), "x must be positive and finite");
        int exponent = Math.getExponent(x10);
        if (!d.e(x10)) {
            return h(x10 * 4.503599627370496E15d, mode) - 52;
        }
        switch (a.f10307a[mode.ordinal()]) {
            case 1:
                i.k(f(x10));
                if (z10) {
                    return exponent + 1;
                }
                return exponent;
            case 2:
                if (z10) {
                    return exponent + 1;
                }
                return exponent;
            case 3:
                z10 = !f(x10);
                if (z10) {
                    return exponent + 1;
                }
                return exponent;
            case 4:
                z10 = exponent < 0;
                zF = f(x10);
                z10 &= !zF;
                if (z10) {
                    return exponent + 1;
                }
                return exponent;
            case 5:
                z10 = exponent >= 0;
                zF = f(x10);
                z10 &= !zF;
                if (z10) {
                    return exponent + 1;
                }
                return exponent;
            case 6:
            case 7:
            case 8:
                double dG = d.g(x10);
                if (dG * dG > 2.0d) {
                    z10 = true;
                }
                if (z10) {
                    return exponent + 1;
                }
                return exponent;
            default:
                throw new AssertionError();
        }
    }

    @b1.c
    @Deprecated
    @b1.d
    public static double i(Iterable<? extends Number> values) {
        return j(values.iterator());
    }

    @b1.c
    @Deprecated
    @b1.d
    public static double j(Iterator<? extends Number> values) {
        h0.e(values.hasNext(), "Cannot take mean of 0 values");
        double dA = a(values.next().doubleValue());
        long j10 = 1;
        while (values.hasNext()) {
            j10++;
            dA += (a(values.next().doubleValue()) - dA) / j10;
        }
        return dA;
    }

    @b1.c
    @b1.d
    @Deprecated
    public static double k(double... values) {
        h0.e(values.length > 0, "Cannot take mean of 0 values");
        double dA = a(values[0]);
        long j10 = 1;
        for (int i10 = 1; i10 < values.length; i10++) {
            a(values[i10]);
            j10++;
            dA += (values[i10] - dA) / j10;
        }
        return dA;
    }

    @Deprecated
    public static double l(int... values) {
        h0.e(values.length > 0, "Cannot take mean of 0 values");
        long j10 = 0;
        for (int i10 : values) {
            j10 += (long) i10;
        }
        return j10 / ((double) values.length);
    }

    @Deprecated
    public static double m(long... values) {
        h0.e(values.length > 0, "Cannot take mean of 0 values");
        double d10 = values[0];
        long j10 = 1;
        for (int i10 = 1; i10 < values.length; i10++) {
            j10++;
            d10 += (values[i10] - d10) / j10;
        }
        return d10;
    }

    @b1.c
    @b1.d
    public static double n(double x10, RoundingMode mode) {
        if (!d.d(x10)) {
            throw new ArithmeticException("input is infinite or NaN");
        }
        switch (a.f10307a[mode.ordinal()]) {
            case 1:
                i.k(e(x10));
                return x10;
            case 2:
                return (x10 >= 0.0d || e(x10)) ? x10 : ((long) x10) - 1;
            case 3:
                return (x10 <= 0.0d || e(x10)) ? x10 : ((long) x10) + 1;
            case 4:
                return x10;
            case 5:
                if (e(x10)) {
                    return x10;
                }
                return ((long) x10) + ((long) (x10 > 0.0d ? 1 : -1));
            case 6:
                return Math.rint(x10);
            case 7:
                double dRint = Math.rint(x10);
                return Math.abs(x10 - dRint) == 0.5d ? Math.copySign(0.5d, x10) + x10 : dRint;
            case 8:
                double dRint2 = Math.rint(x10);
                return Math.abs(x10 - dRint2) == 0.5d ? x10 : dRint2;
            default:
                throw new AssertionError();
        }
    }

    @b1.c
    @b1.d
    public static BigInteger o(double x10, RoundingMode mode) {
        double dN = n(x10, mode);
        if (((-9.223372036854776E18d) - dN < 1.0d) && (dN < 9.223372036854776E18d)) {
            return BigInteger.valueOf((long) dN);
        }
        BigInteger bigIntegerShiftLeft = BigInteger.valueOf(d.c(dN)).shiftLeft(Math.getExponent(dN) - 52);
        return dN < 0.0d ? bigIntegerShiftLeft.negate() : bigIntegerShiftLeft;
    }

    @b1.c
    @b1.d
    public static int p(double x10, RoundingMode mode) {
        double dN = n(x10, mode);
        i.a((dN > -2.147483649E9d) & (dN < 2.147483648E9d), x10, mode);
        return (int) dN;
    }

    @b1.c
    @b1.d
    public static long q(double x10, RoundingMode mode) {
        double dN = n(x10, mode);
        i.a(((-9.223372036854776E18d) - dN < 1.0d) & (dN < 9.223372036854776E18d), x10, mode);
        return (long) dN;
    }
}
