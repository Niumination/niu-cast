package o1;

import c1.h0;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@f
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f12058a = 4294967295L;

    public enum a implements Comparator<int[]> {
        INSTANCE;

        public static /* synthetic */ a[] a() {
            return new a[]{INSTANCE};
        }

        @Override // java.lang.Enum
        public String toString() {
            return "UnsignedInts.lexicographicalComparator()";
        }

        @Override // java.util.Comparator
        public int compare(int[] left, int[] right) {
            int iMin = Math.min(left.length, right.length);
            for (int i10 = 0; i10 < iMin; i10++) {
                int i11 = left[i10];
                int i12 = right[i10];
                if (i11 != i12) {
                    return w.b(i11, i12);
                }
            }
            return left.length - right.length;
        }
    }

    public static int a(long value) {
        h0.p((value >> 32) == 0, "out of range: %s", value);
        return (int) value;
    }

    public static int b(int a10, int b10) {
        return l.e(a10 ^ Integer.MIN_VALUE, b10 ^ Integer.MIN_VALUE);
    }

    @t1.a
    public static int c(String stringValue) {
        p pVarA = p.a(stringValue);
        try {
            return k(pVarA.f12042a, pVarA.f12043b);
        } catch (NumberFormatException e10) {
            NumberFormatException numberFormatException = new NumberFormatException(m.a.a("Error parsing value: ", stringValue));
            numberFormatException.initCause(e10);
            throw numberFormatException;
        }
    }

    public static int d(int dividend, int divisor) {
        return (int) ((((long) dividend) & 4294967295L) / (((long) divisor) & 4294967295L));
    }

    public static int e(int value) {
        return value ^ Integer.MIN_VALUE;
    }

    public static String f(String separator, int... array) {
        separator.getClass();
        if (array.length == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder(array.length * 5);
        sb2.append(t(array[0], 10));
        for (int i10 = 1; i10 < array.length; i10++) {
            sb2.append(separator);
            sb2.append(t(array[i10], 10));
        }
        return sb2.toString();
    }

    public static Comparator<int[]> g() {
        return a.INSTANCE;
    }

    public static int h(int... array) {
        h0.d(array.length > 0);
        int i10 = array[0] ^ Integer.MIN_VALUE;
        for (int i11 = 1; i11 < array.length; i11++) {
            int i12 = array[i11] ^ Integer.MIN_VALUE;
            if (i12 > i10) {
                i10 = i12;
            }
        }
        return i10 ^ Integer.MIN_VALUE;
    }

    public static int i(int... array) {
        h0.d(array.length > 0);
        int i10 = array[0] ^ Integer.MIN_VALUE;
        for (int i11 = 1; i11 < array.length; i11++) {
            int i12 = array[i11] ^ Integer.MIN_VALUE;
            if (i12 < i10) {
                i10 = i12;
            }
        }
        return i10 ^ Integer.MIN_VALUE;
    }

    @t1.a
    public static int j(String s10) {
        return k(s10, 10);
    }

    @t1.a
    public static int k(String string, int radix) {
        string.getClass();
        long j10 = Long.parseLong(string, radix);
        if ((4294967295L & j10) == j10) {
            return (int) j10;
        }
        throw new NumberFormatException("Input " + string + " in base " + radix + " is not in the range of an unsigned integer");
    }

    public static int l(int dividend, int divisor) {
        return (int) ((((long) dividend) & 4294967295L) % (((long) divisor) & 4294967295L));
    }

    public static int m(long value) {
        if (value <= 0) {
            return 0;
        }
        if (value >= 4294967296L) {
            return -1;
        }
        return (int) value;
    }

    public static void n(int[] array) {
        array.getClass();
        o(array, 0, array.length);
    }

    public static void o(int[] array, int fromIndex, int toIndex) {
        array.getClass();
        h0.f0(fromIndex, toIndex, array.length);
        for (int i10 = fromIndex; i10 < toIndex; i10++) {
            array[i10] = Integer.MIN_VALUE ^ array[i10];
        }
        Arrays.sort(array, fromIndex, toIndex);
        while (fromIndex < toIndex) {
            array[fromIndex] = array[fromIndex] ^ Integer.MIN_VALUE;
            fromIndex++;
        }
    }

    public static void p(int[] array) {
        array.getClass();
        q(array, 0, array.length);
    }

    public static void q(int[] array, int fromIndex, int toIndex) {
        array.getClass();
        h0.f0(fromIndex, toIndex, array.length);
        for (int i10 = fromIndex; i10 < toIndex; i10++) {
            array[i10] = Integer.MAX_VALUE ^ array[i10];
        }
        Arrays.sort(array, fromIndex, toIndex);
        while (fromIndex < toIndex) {
            array[fromIndex] = array[fromIndex] ^ Integer.MAX_VALUE;
            fromIndex++;
        }
    }

    public static long r(int value) {
        return ((long) value) & 4294967295L;
    }

    public static String s(int x10) {
        return t(x10, 10);
    }

    public static String t(int x10, int radix) {
        return Long.toString(((long) x10) & 4294967295L, radix);
    }
}
