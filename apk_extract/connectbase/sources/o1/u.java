package o1;

import c1.h0;
import java.lang.reflect.Field;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@f
@b1.d
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte f12051a = -128;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte f12052b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f12053c = 255;

    @b1.e
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f12054a = a.class.getName().concat("$UnsafeComparator");

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Comparator<byte[]> f12055b = a();

        /* JADX INFO: renamed from: o1.u$a$a, reason: collision with other inner class name */
        public enum EnumC0307a implements Comparator<byte[]> {
            INSTANCE;

            public static /* synthetic */ EnumC0307a[] a() {
                return new EnumC0307a[]{INSTANCE};
            }

            @Override // java.lang.Enum
            public String toString() {
                return "UnsignedBytes.lexicographicalComparator() (pure Java version)";
            }

            @Override // java.util.Comparator
            public int compare(byte[] left, byte[] right) {
                int iMin = Math.min(left.length, right.length);
                for (int i10 = 0; i10 < iMin; i10++) {
                    int iB = u.b(left[i10], right[i10]);
                    if (iB != 0) {
                        return iB;
                    }
                }
                return left.length - right.length;
            }
        }

        @b1.e
        public enum b implements Comparator<byte[]> {
            INSTANCE;

            static final boolean BIG_ENDIAN = ByteOrder.nativeOrder().equals(ByteOrder.BIG_ENDIAN);
            static final int BYTE_ARRAY_BASE_OFFSET;
            static final Unsafe theUnsafe;

            /* JADX INFO: renamed from: o1.u$a$b$a, reason: collision with other inner class name */
            public class C0308a implements PrivilegedExceptionAction<Unsafe> {
                @Override // java.security.PrivilegedExceptionAction
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Unsafe run() throws Exception {
                    for (Field field : Unsafe.class.getDeclaredFields()) {
                        field.setAccessible(true);
                        Object obj = field.get(null);
                        if (Unsafe.class.isInstance(obj)) {
                            return (Unsafe) Unsafe.class.cast(obj);
                        }
                    }
                    throw new NoSuchFieldError("the Unsafe");
                }
            }

            static {
                Unsafe unsafeB = b();
                theUnsafe = unsafeB;
                int iArrayBaseOffset = unsafeB.arrayBaseOffset(byte[].class);
                BYTE_ARRAY_BASE_OFFSET = iArrayBaseOffset;
                if (!"64".equals(System.getProperty("sun.arch.data.model")) || iArrayBaseOffset % 8 != 0 || unsafeB.arrayIndexScale(byte[].class) != 1) {
                    throw new Error();
                }
            }

            public static /* synthetic */ b[] a() {
                return new b[]{INSTANCE};
            }

            public static Unsafe b() {
                try {
                    try {
                        return Unsafe.getUnsafe();
                    } catch (PrivilegedActionException e10) {
                        throw new RuntimeException("Could not initialize intrinsics", e10.getCause());
                    }
                } catch (SecurityException unused) {
                    return (Unsafe) AccessController.doPrivileged(new C0308a());
                }
            }

            @Override // java.lang.Enum
            public String toString() {
                return "UnsignedBytes.lexicographicalComparator() (sun.misc.Unsafe version)";
            }

            @Override // java.util.Comparator
            public int compare(byte[] left, byte[] right) {
                int iMin = Math.min(left.length, right.length);
                int i10 = iMin & (-8);
                int i11 = 0;
                while (i11 < i10) {
                    Unsafe unsafe = theUnsafe;
                    int i12 = BYTE_ARRAY_BASE_OFFSET;
                    long j10 = i11;
                    long j11 = unsafe.getLong(left, ((long) i12) + j10);
                    long j12 = unsafe.getLong(right, ((long) i12) + j10);
                    if (j11 != j12) {
                        if (BIG_ENDIAN) {
                            return y.a(j11, j12);
                        }
                        int iNumberOfTrailingZeros = Long.numberOfTrailingZeros(j11 ^ j12) & (-8);
                        return ((int) ((j11 >>> iNumberOfTrailingZeros) & 255)) - ((int) (255 & (j12 >>> iNumberOfTrailingZeros)));
                    }
                    i11 += 8;
                }
                while (i11 < iMin) {
                    int iB = u.b(left[i11], right[i11]);
                    if (iB != 0) {
                        return iB;
                    }
                    i11++;
                }
                return left.length - right.length;
            }
        }

        public static Comparator<byte[]> a() {
            try {
                Object[] enumConstants = Class.forName(f12054a).getEnumConstants();
                Objects.requireNonNull(enumConstants);
                return (Comparator) enumConstants[0];
            } catch (Throwable unused) {
                return EnumC0307a.INSTANCE;
            }
        }
    }

    @t1.a
    public static byte a(long value) {
        h0.p((value >> 8) == 0, "out of range: %s", value);
        return (byte) value;
    }

    public static int b(byte a10, byte b10) {
        return (a10 & 255) - (b10 & 255);
    }

    public static byte c(byte b10) {
        return (byte) (b10 ^ 128);
    }

    public static String d(String separator, byte... array) {
        separator.getClass();
        if (array.length == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder((separator.length() + 3) * array.length);
        sb2.append(array[0] & 255);
        for (int i10 = 1; i10 < array.length; i10++) {
            sb2.append(separator);
            sb2.append(r(array[i10], 10));
        }
        return sb2.toString();
    }

    public static Comparator<byte[]> e() {
        return a.f12055b;
    }

    @b1.e
    public static Comparator<byte[]> f() {
        return a.EnumC0307a.INSTANCE;
    }

    public static byte g(byte... array) {
        h0.d(array.length > 0);
        int i10 = array[0] & 255;
        for (int i11 = 1; i11 < array.length; i11++) {
            int i12 = array[i11] & 255;
            if (i12 > i10) {
                i10 = i12;
            }
        }
        return (byte) i10;
    }

    public static byte h(byte... array) {
        h0.d(array.length > 0);
        int i10 = array[0] & 255;
        for (int i11 = 1; i11 < array.length; i11++) {
            int i12 = array[i11] & 255;
            if (i12 < i10) {
                i10 = i12;
            }
        }
        return (byte) i10;
    }

    @t1.a
    public static byte i(String string) {
        return j(string, 10);
    }

    @t1.a
    public static byte j(String string, int radix) {
        string.getClass();
        int i10 = Integer.parseInt(string, radix);
        if ((i10 >> 8) == 0) {
            return (byte) i10;
        }
        throw new NumberFormatException(h.a.a("out of range: ", i10));
    }

    public static byte k(long value) {
        if (value > 255) {
            return (byte) -1;
        }
        if (value < 0) {
            return (byte) 0;
        }
        return (byte) value;
    }

    public static void l(byte[] array) {
        array.getClass();
        m(array, 0, array.length);
    }

    public static void m(byte[] array, int fromIndex, int toIndex) {
        array.getClass();
        h0.f0(fromIndex, toIndex, array.length);
        for (int i10 = fromIndex; i10 < toIndex; i10++) {
            array[i10] = (byte) (array[i10] ^ 128);
        }
        Arrays.sort(array, fromIndex, toIndex);
        while (fromIndex < toIndex) {
            array[fromIndex] = (byte) (array[fromIndex] ^ 128);
            fromIndex++;
        }
    }

    public static void n(byte[] array) {
        array.getClass();
        o(array, 0, array.length);
    }

    public static void o(byte[] array, int fromIndex, int toIndex) {
        array.getClass();
        h0.f0(fromIndex, toIndex, array.length);
        for (int i10 = fromIndex; i10 < toIndex; i10++) {
            array[i10] = (byte) (array[i10] ^ 127);
        }
        Arrays.sort(array, fromIndex, toIndex);
        while (fromIndex < toIndex) {
            array[fromIndex] = (byte) (array[fromIndex] ^ 127);
            fromIndex++;
        }
    }

    public static int p(byte value) {
        return value & 255;
    }

    public static String q(byte x10) {
        return r(x10, 10);
    }

    public static String r(byte x10, int radix) {
        h0.k(radix >= 2 && radix <= 36, "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", radix);
        return Integer.toString(x10 & 255, radix);
    }
}
