package m1;

import java.math.BigInteger;
import java.math.RoundingMode;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@e
public final class i {
    public static void a(boolean condition, double input, RoundingMode mode) {
        if (condition) {
            return;
        }
        throw new ArithmeticException("rounded value is out of range for input " + input + " and rounding mode " + mode);
    }

    public static void b(boolean condition, String methodName, int a10, int b10) {
        if (condition) {
            return;
        }
        StringBuilder sb2 = new StringBuilder("overflow: ");
        sb2.append(methodName);
        sb2.append("(");
        sb2.append(a10);
        sb2.append(", ");
        throw new ArithmeticException(c.a.a(sb2, b10, ")"));
    }

    public static void c(boolean condition, String methodName, long a10, long b10) {
        if (condition) {
            return;
        }
        throw new ArithmeticException("overflow: " + methodName + "(" + a10 + ", " + b10 + ")");
    }

    @t1.a
    public static double d(String role, double x10) {
        if (x10 >= 0.0d) {
            return x10;
        }
        throw new IllegalArgumentException(role + " (" + x10 + ") must be >= 0");
    }

    @t1.a
    public static int e(String role, int x10) {
        if (x10 >= 0) {
            return x10;
        }
        throw new IllegalArgumentException(role + " (" + x10 + ") must be >= 0");
    }

    @t1.a
    public static long f(String role, long x10) {
        if (x10 >= 0) {
            return x10;
        }
        throw new IllegalArgumentException(role + " (" + x10 + ") must be >= 0");
    }

    @t1.a
    public static BigInteger g(String role, BigInteger x10) {
        if (x10.signum() >= 0) {
            return x10;
        }
        throw new IllegalArgumentException(role + " (" + x10 + ") must be >= 0");
    }

    @t1.a
    public static int h(String role, int x10) {
        if (x10 > 0) {
            return x10;
        }
        throw new IllegalArgumentException(role + " (" + x10 + ") must be > 0");
    }

    @t1.a
    public static long i(String role, long x10) {
        if (x10 > 0) {
            return x10;
        }
        throw new IllegalArgumentException(role + " (" + x10 + ") must be > 0");
    }

    @t1.a
    public static BigInteger j(String role, BigInteger x10) {
        if (x10.signum() > 0) {
            return x10;
        }
        throw new IllegalArgumentException(role + " (" + x10 + ") must be > 0");
    }

    public static void k(boolean condition) {
        if (!condition) {
            throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
        }
    }
}
