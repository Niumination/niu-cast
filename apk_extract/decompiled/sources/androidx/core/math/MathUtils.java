package androidx.core.math;

/* JADX INFO: loaded from: classes.dex */
public class MathUtils {
    private MathUtils() {
    }

    public static int addExact(int i8, int i9) {
        int i10 = i8 + i9;
        if ((i8 >= 0) == (i9 >= 0)) {
            if ((i8 >= 0) != (i10 >= 0)) {
                throw new ArithmeticException("integer overflow");
            }
        }
        return i10;
    }

    public static double clamp(double d7, double d10, double d11) {
        if (d7 < d10) {
            return d10;
        }
        return d7 > d11 ? d11 : d7;
    }

    public static int decrementExact(int i8) {
        if (i8 != Integer.MIN_VALUE) {
            return i8 - 1;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static int incrementExact(int i8) {
        if (i8 != Integer.MAX_VALUE) {
            return i8 + 1;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static int multiplyExact(int i8, int i9) {
        int i10 = i8 * i9;
        if (i8 == 0 || i9 == 0 || (i10 / i8 == i9 && i10 / i9 == i8)) {
            return i10;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static int negateExact(int i8) {
        if (i8 != Integer.MIN_VALUE) {
            return -i8;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static int subtractExact(int i8, int i9) {
        int i10 = i8 - i9;
        if ((i8 < 0) != (i9 < 0)) {
            if ((i8 < 0) != (i10 < 0)) {
                throw new ArithmeticException("integer overflow");
            }
        }
        return i10;
    }

    public static int toIntExact(long j8) {
        if (j8 > 2147483647L || j8 < -2147483648L) {
            throw new ArithmeticException("integer overflow");
        }
        return (int) j8;
    }

    public static long addExact(long j8, long j10) {
        long j11 = j8 + j10;
        if ((j8 >= 0) == (j10 >= 0)) {
            if ((j8 >= 0) != (j11 >= 0)) {
                throw new ArithmeticException("integer overflow");
            }
        }
        return j11;
    }

    public static float clamp(float f, float f4, float f10) {
        if (f < f4) {
            return f4;
        }
        return f > f10 ? f10 : f;
    }

    public static long decrementExact(long j8) {
        if (j8 != Long.MIN_VALUE) {
            return j8 - 1;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long incrementExact(long j8) {
        if (j8 != Long.MAX_VALUE) {
            return j8 + 1;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long negateExact(long j8) {
        if (j8 != Long.MIN_VALUE) {
            return -j8;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long subtractExact(long j8, long j10) {
        long j11 = j8 - j10;
        if ((j8 < 0) != (j10 < 0)) {
            if ((j8 < 0) != (j11 < 0)) {
                throw new ArithmeticException("integer overflow");
            }
        }
        return j11;
    }

    public static int clamp(int i8, int i9, int i10) {
        if (i8 < i9) {
            return i9;
        }
        return i8 > i10 ? i10 : i8;
    }

    public static long multiplyExact(long j8, long j10) {
        long j11 = j8 * j10;
        if (j8 == 0 || j10 == 0 || (j11 / j8 == j10 && j11 / j10 == j8)) {
            return j11;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long clamp(long j8, long j10, long j11) {
        if (j8 < j10) {
            return j10;
        }
        return j8 > j11 ? j11 : j8;
    }
}
