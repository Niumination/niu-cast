package o1;

import c1.h0;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@f
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte f12049a = 64;

    public enum a implements Comparator<byte[]> {
        INSTANCE;

        public static /* synthetic */ a[] a() {
            return new a[]{INSTANCE};
        }

        @Override // java.lang.Enum
        public String toString() {
            return "SignedBytes.lexicographicalComparator()";
        }

        @Override // java.util.Comparator
        public int compare(byte[] left, byte[] right) {
            int iMin = Math.min(left.length, right.length);
            for (int i10 = 0; i10 < iMin; i10++) {
                int i11 = left[i10] - right[i10];
                if (i11 != 0) {
                    return i11;
                }
            }
            return left.length - right.length;
        }
    }

    public static byte a(long value) {
        byte b10 = (byte) value;
        h0.p(((long) b10) == value, "Out of range: %s", value);
        return b10;
    }

    public static int b(byte a10, byte b10) {
        return a10 - b10;
    }

    public static String c(String separator, byte... array) {
        separator.getClass();
        if (array.length == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder(array.length * 5);
        sb2.append((int) array[0]);
        for (int i10 = 1; i10 < array.length; i10++) {
            sb2.append(separator);
            sb2.append((int) array[i10]);
        }
        return sb2.toString();
    }

    public static Comparator<byte[]> d() {
        return a.INSTANCE;
    }

    public static byte e(byte... array) {
        h0.d(array.length > 0);
        byte b10 = array[0];
        for (int i10 = 1; i10 < array.length; i10++) {
            byte b11 = array[i10];
            if (b11 > b10) {
                b10 = b11;
            }
        }
        return b10;
    }

    public static byte f(byte... array) {
        h0.d(array.length > 0);
        byte b10 = array[0];
        for (int i10 = 1; i10 < array.length; i10++) {
            byte b11 = array[i10];
            if (b11 < b10) {
                b10 = b11;
            }
        }
        return b10;
    }

    public static byte g(long value) {
        if (value > 127) {
            return (byte) 127;
        }
        if (value < -128) {
            return (byte) -128;
        }
        return (byte) value;
    }

    public static void h(byte[] array) {
        array.getClass();
        i(array, 0, array.length);
    }

    public static void i(byte[] array, int fromIndex, int toIndex) {
        array.getClass();
        h0.f0(fromIndex, toIndex, array.length);
        Arrays.sort(array, fromIndex, toIndex);
        b.n(array, fromIndex, toIndex);
    }
}
