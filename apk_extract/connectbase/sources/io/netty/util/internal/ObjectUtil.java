package io.netty.util.internal;

import java.util.Collection;
import java.util.Map;
import n.a;

/* JADX INFO: loaded from: classes3.dex */
public final class ObjectUtil {
    private static final double DOUBLE_ZERO = 0.0d;
    private static final float FLOAT_ZERO = 0.0f;
    private static final int INT_ZERO = 0;
    private static final long LONG_ZERO = 0;

    private ObjectUtil() {
    }

    public static int checkInRange(int i10, int i11, int i12, String str) {
        if (i10 >= i11 && i10 <= i12) {
            return i10;
        }
        throw new IllegalArgumentException(str + ": " + i10 + " (expected: " + i11 + "-" + i12 + ")");
    }

    public static <T> T[] checkNonEmpty(T[] tArr, String str) {
        if (((Object[]) checkNotNull(tArr, str)).length != 0) {
            return tArr;
        }
        throw new IllegalArgumentException(a.a("Param '", str, "' must not be empty"));
    }

    public static String checkNonEmptyAfterTrim(String str, String str2) {
        return checkNonEmpty(((String) checkNotNull(str, str2)).trim(), str2);
    }

    public static <T> T checkNotNull(T t10, String str) {
        if (t10 != null) {
            return t10;
        }
        throw new NullPointerException(str);
    }

    public static <T> T checkNotNullArrayParam(T t10, int i10, String str) throws IllegalArgumentException {
        if (t10 != null) {
            return t10;
        }
        throw new IllegalArgumentException("Array index " + i10 + " of parameter '" + str + "' must not be null");
    }

    public static <T> T checkNotNullWithIAE(T t10, String str) throws IllegalArgumentException {
        if (t10 != null) {
            return t10;
        }
        throw new IllegalArgumentException(a.a("Param '", str, "' must not be null"));
    }

    public static int checkPositive(int i10, String str) {
        if (i10 > 0) {
            return i10;
        }
        throw new IllegalArgumentException(str + " : " + i10 + " (expected: > 0)");
    }

    public static int checkPositiveOrZero(int i10, String str) {
        if (i10 >= 0) {
            return i10;
        }
        throw new IllegalArgumentException(str + " : " + i10 + " (expected: >= 0)");
    }

    public static <T> T[] deepCheckNotNull(String str, T... tArr) {
        if (tArr == null) {
            throw new NullPointerException(str);
        }
        for (T t10 : tArr) {
            if (t10 == null) {
                throw new NullPointerException(str);
            }
        }
        return tArr;
    }

    public static int intValue(Integer num, int i10) {
        return num != null ? num.intValue() : i10;
    }

    public static long longValue(Long l10, long j10) {
        return l10 != null ? l10.longValue() : j10;
    }

    public static long checkInRange(long j10, long j11, long j12, String str) {
        if (j10 >= j11 && j10 <= j12) {
            return j10;
        }
        throw new IllegalArgumentException(str + ": " + j10 + " (expected: " + j11 + "-" + j12 + ")");
    }

    public static long checkPositive(long j10, String str) {
        if (j10 > 0) {
            return j10;
        }
        throw new IllegalArgumentException(str + " : " + j10 + " (expected: > 0)");
    }

    public static long checkPositiveOrZero(long j10, String str) {
        if (j10 >= 0) {
            return j10;
        }
        throw new IllegalArgumentException(str + " : " + j10 + " (expected: >= 0)");
    }

    public static double checkPositive(double d10, String str) {
        if (d10 > 0.0d) {
            return d10;
        }
        throw new IllegalArgumentException(str + " : " + d10 + " (expected: > 0)");
    }

    public static double checkPositiveOrZero(double d10, String str) {
        if (d10 >= 0.0d) {
            return d10;
        }
        throw new IllegalArgumentException(str + " : " + d10 + " (expected: >= 0)");
    }

    public static float checkPositive(float f10, String str) {
        if (f10 > 0.0f) {
            return f10;
        }
        throw new IllegalArgumentException(str + " : " + f10 + " (expected: > 0)");
    }

    public static float checkPositiveOrZero(float f10, String str) {
        if (f10 >= 0.0f) {
            return f10;
        }
        throw new IllegalArgumentException(str + " : " + f10 + " (expected: >= 0)");
    }

    public static byte[] checkNonEmpty(byte[] bArr, String str) {
        if (((byte[]) checkNotNull(bArr, str)).length != 0) {
            return bArr;
        }
        throw new IllegalArgumentException(a.a("Param '", str, "' must not be empty"));
    }

    public static char[] checkNonEmpty(char[] cArr, String str) {
        if (((char[]) checkNotNull(cArr, str)).length != 0) {
            return cArr;
        }
        throw new IllegalArgumentException(a.a("Param '", str, "' must not be empty"));
    }

    public static <T extends Collection<?>> T checkNonEmpty(T t10, String str) {
        if (((Collection) checkNotNull(t10, str)).isEmpty()) {
            throw new IllegalArgumentException(a.a("Param '", str, "' must not be empty"));
        }
        return t10;
    }

    public static String checkNonEmpty(String str, String str2) {
        if (((String) checkNotNull(str, str2)).isEmpty()) {
            throw new IllegalArgumentException(a.a("Param '", str2, "' must not be empty"));
        }
        return str;
    }

    public static <K, V, T extends Map<K, V>> T checkNonEmpty(T t10, String str) {
        if (((Map) checkNotNull(t10, str)).isEmpty()) {
            throw new IllegalArgumentException(a.a("Param '", str, "' must not be empty"));
        }
        return t10;
    }

    public static CharSequence checkNonEmpty(CharSequence charSequence, String str) {
        if (((CharSequence) checkNotNull(charSequence, str)).length() != 0) {
            return charSequence;
        }
        throw new IllegalArgumentException(a.a("Param '", str, "' must not be empty"));
    }
}
