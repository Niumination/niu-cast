package o1;

import c1.h0;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@f
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f12061a = -1;

    public enum a implements Comparator<long[]> {
        INSTANCE;

        public static /* synthetic */ a[] a() {
            return new a[]{INSTANCE};
        }

        @Override // java.lang.Enum
        public String toString() {
            return "UnsignedLongs.lexicographicalComparator()";
        }

        @Override // java.util.Comparator
        public int compare(long[] left, long[] right) {
            int iMin = Math.min(left.length, right.length);
            for (int i10 = 0; i10 < iMin; i10++) {
                long j10 = left[i10];
                long j11 = right[i10];
                if (j10 != j11) {
                    return y.a(j10, j11);
                }
            }
            return left.length - right.length;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final long[] f12063a = new long[37];

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int[] f12064b = new int[37];

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int[] f12065c = new int[37];

        static {
            BigInteger bigInteger = new BigInteger("10000000000000000", 16);
            for (int i10 = 2; i10 <= 36; i10++) {
                long j10 = i10;
                f12063a[i10] = y.c(-1L, j10);
                f12064b[i10] = (int) y.k(-1L, j10);
                f12065c[i10] = bigInteger.toString(i10).length() - 1;
            }
        }

        public static boolean a(long current, int digit, int radix) {
            if (current < 0) {
                return true;
            }
            long j10 = f12063a[radix];
            if (current < j10) {
                return false;
            }
            return current > j10 || digit > f12064b[radix];
        }
    }

    public static int a(long a10, long b10) {
        return n.e(a10 ^ Long.MIN_VALUE, b10 ^ Long.MIN_VALUE);
    }

    @t1.a
    public static long b(String stringValue) {
        p pVarA = p.a(stringValue);
        try {
            return j(pVarA.f12042a, pVarA.f12043b);
        } catch (NumberFormatException e10) {
            NumberFormatException numberFormatException = new NumberFormatException(m.a.a("Error parsing value: ", stringValue));
            numberFormatException.initCause(e10);
            throw numberFormatException;
        }
    }

    public static long c(long dividend, long divisor) {
        if (divisor < 0) {
            return a(dividend, divisor) < 0 ? 0L : 1L;
        }
        if (dividend >= 0) {
            return dividend / divisor;
        }
        long j10 = ((dividend >>> 1) / divisor) << 1;
        return j10 + ((long) (a(dividend - (j10 * divisor), divisor) < 0 ? 0 : 1));
    }

    public static long d(long a10) {
        return a10 ^ Long.MIN_VALUE;
    }

    public static String e(String separator, long... array) {
        separator.getClass();
        if (array.length == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder(array.length * 5);
        sb2.append(q(array[0], 10));
        for (int i10 = 1; i10 < array.length; i10++) {
            sb2.append(separator);
            sb2.append(q(array[i10], 10));
        }
        return sb2.toString();
    }

    public static Comparator<long[]> f() {
        return a.INSTANCE;
    }

    public static long g(long... array) {
        h0.d(array.length > 0);
        long j10 = array[0] ^ Long.MIN_VALUE;
        for (int i10 = 1; i10 < array.length; i10++) {
            long j11 = array[i10] ^ Long.MIN_VALUE;
            if (j11 > j10) {
                j10 = j11;
            }
        }
        return j10 ^ Long.MIN_VALUE;
    }

    public static long h(long... array) {
        h0.d(array.length > 0);
        long j10 = array[0] ^ Long.MIN_VALUE;
        for (int i10 = 1; i10 < array.length; i10++) {
            long j11 = array[i10] ^ Long.MIN_VALUE;
            if (j11 < j10) {
                j10 = j11;
            }
        }
        return j10 ^ Long.MIN_VALUE;
    }

    @t1.a
    public static long i(String string) {
        return j(string, 10);
    }

    @t1.a
    public static long j(String string, int radix) {
        string.getClass();
        if (string.length() == 0) {
            throw new NumberFormatException("empty string");
        }
        if (radix < 2 || radix > 36) {
            throw new NumberFormatException(h.a.a("illegal radix: ", radix));
        }
        int i10 = b.f12065c[radix] - 1;
        long j10 = 0;
        for (int i11 = 0; i11 < string.length(); i11++) {
            int iDigit = Character.digit(string.charAt(i11), radix);
            if (iDigit == -1) {
                throw new NumberFormatException(string);
            }
            if (i11 > i10 && b.a(j10, iDigit, radix)) {
                throw new NumberFormatException("Too large for unsigned long: ".concat(string));
            }
            j10 = (j10 * ((long) radix)) + ((long) iDigit);
        }
        return j10;
    }

    public static long k(long dividend, long divisor) {
        if (divisor < 0) {
            return a(dividend, divisor) < 0 ? dividend : dividend - divisor;
        }
        if (dividend >= 0) {
            return dividend % divisor;
        }
        long j10 = dividend - ((((dividend >>> 1) / divisor) << 1) * divisor);
        if (a(j10, divisor) < 0) {
            divisor = 0;
        }
        return j10 - divisor;
    }

    public static void l(long[] array) {
        array.getClass();
        m(array, 0, array.length);
    }

    public static void m(long[] array, int fromIndex, int toIndex) {
        array.getClass();
        h0.f0(fromIndex, toIndex, array.length);
        for (int i10 = fromIndex; i10 < toIndex; i10++) {
            array[i10] = Long.MIN_VALUE ^ array[i10];
        }
        Arrays.sort(array, fromIndex, toIndex);
        while (fromIndex < toIndex) {
            array[fromIndex] = array[fromIndex] ^ Long.MIN_VALUE;
            fromIndex++;
        }
    }

    public static void n(long[] array) {
        array.getClass();
        o(array, 0, array.length);
    }

    public static void o(long[] array, int fromIndex, int toIndex) {
        array.getClass();
        h0.f0(fromIndex, toIndex, array.length);
        for (int i10 = fromIndex; i10 < toIndex; i10++) {
            array[i10] = Long.MAX_VALUE ^ array[i10];
        }
        Arrays.sort(array, fromIndex, toIndex);
        while (fromIndex < toIndex) {
            array[fromIndex] = array[fromIndex] ^ Long.MAX_VALUE;
            fromIndex++;
        }
    }

    public static String p(long x10) {
        return q(x10, 10);
    }

    public static String q(long x10, int radix) {
        h0.k(radix >= 2 && radix <= 36, "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", radix);
        if (x10 == 0) {
            return hi.b.f7118g;
        }
        if (x10 > 0) {
            return Long.toString(x10, radix);
        }
        int i10 = 64;
        char[] cArr = new char[64];
        int i11 = radix - 1;
        if ((radix & i11) == 0) {
            int iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(radix);
            do {
                i10--;
                cArr[i10] = Character.forDigit(((int) x10) & i11, radix);
                x10 >>>= iNumberOfTrailingZeros;
            } while (x10 != 0);
        } else {
            long jC = (radix & 1) == 0 ? (x10 >>> 1) / ((long) (radix >>> 1)) : c(x10, radix);
            long j10 = radix;
            int i12 = 63;
            cArr[63] = Character.forDigit((int) (x10 - (jC * j10)), radix);
            while (jC > 0) {
                i12--;
                cArr[i12] = Character.forDigit((int) (jC % j10), radix);
                jC /= j10;
            }
            i10 = i12;
        }
        return new String(cArr, i10, 64 - i10);
    }
}
