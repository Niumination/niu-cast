package wj;

import java.text.ParseException;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class h1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f18711a = -315576000000L;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f18712b = 315576000000L;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f18713c = TimeUnit.SECONDS.toNanos(1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ boolean f18714d = false;

    /* JADX WARN: Multi-variable type inference failed */
    public static List<Map<String, ?>> a(List<?> list) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            if (!(list.get(i10) instanceof Map)) {
                throw new ClassCastException(String.format(Locale.US, "value %s for idx %d in %s is not object", list.get(i10), Integer.valueOf(i10), list));
            }
        }
        return list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static List<String> b(List<?> list) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            if (!(list.get(i10) instanceof String)) {
                throw new ClassCastException(String.format(Locale.US, "value '%s' for idx %d in '%s' is not string", list.get(i10), Integer.valueOf(i10), list));
            }
        }
        return list;
    }

    public static boolean c(long j10, int i10) {
        if (j10 >= f18711a && j10 <= f18712b) {
            long j11 = i10;
            if (j11 >= -999999999 && j11 < f18713c) {
                if (j10 >= 0 && i10 >= 0) {
                    return true;
                }
                if (j10 <= 0 && i10 <= 0) {
                    return true;
                }
            }
        }
        return false;
    }

    @gm.j
    public static Boolean d(Map<String, ?> map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        Object obj = map.get(str);
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        throw new ClassCastException(String.format("value '%s' for key '%s' in '%s' is not Boolean", obj, str, map));
    }

    @gm.j
    public static List<?> e(Map<String, ?> map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        Object obj = map.get(str);
        if (obj instanceof List) {
            return (List) obj;
        }
        throw new ClassCastException(String.format("value '%s' for key '%s' in '%s' is not List", obj, str, map));
    }

    @gm.j
    public static List<Map<String, ?>> f(Map<String, ?> map, String str) {
        List<?> listE = e(map, str);
        if (listE == null) {
            return null;
        }
        return a(listE);
    }

    @gm.j
    public static List<String> g(Map<String, ?> map, String str) {
        List<?> listE = e(map, str);
        if (listE == null) {
            return null;
        }
        return b(listE);
    }

    @gm.j
    public static Double h(Map<String, ?> map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        Object obj = map.get(str);
        if (obj instanceof Double) {
            return (Double) obj;
        }
        if (!(obj instanceof String)) {
            throw new IllegalArgumentException(String.format("value '%s' for key '%s' in '%s' is not a number", obj, str, map));
        }
        try {
            return Double.valueOf(Double.parseDouble((String) obj));
        } catch (NumberFormatException unused) {
            throw new IllegalArgumentException(String.format("value '%s' for key '%s' is not a double", obj, str));
        }
    }

    @gm.j
    public static Float i(Map<String, ?> map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        Object obj = map.get(str);
        if (obj instanceof Float) {
            return (Float) obj;
        }
        if (!(obj instanceof String)) {
            throw new IllegalArgumentException(String.format("value %s for key '%s' is not a float", obj, str));
        }
        try {
            return Float.valueOf(Float.parseFloat((String) obj));
        } catch (NumberFormatException unused) {
            throw new IllegalArgumentException(String.format("string value '%s' for key '%s' cannot be parsed as a float", obj, str));
        }
    }

    @gm.j
    public static Integer j(Map<String, ?> map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        Object obj = map.get(str);
        if (!(obj instanceof Double)) {
            if (!(obj instanceof String)) {
                throw new IllegalArgumentException(String.format("value '%s' for key '%s' is not an integer", obj, str));
            }
            try {
                return Integer.valueOf(Integer.parseInt((String) obj));
            } catch (NumberFormatException unused) {
                throw new IllegalArgumentException(String.format("value '%s' for key '%s' is not an integer", obj, str));
            }
        }
        Double d10 = (Double) obj;
        int iIntValue = d10.intValue();
        if (iIntValue == d10.doubleValue()) {
            return Integer.valueOf(iIntValue);
        }
        throw new ClassCastException("Number expected to be integer: " + d10);
    }

    public static Long k(Map<String, ?> map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        Object obj = map.get(str);
        if (!(obj instanceof Double)) {
            if (!(obj instanceof String)) {
                throw new IllegalArgumentException(String.format("value '%s' for key '%s' is not a long integer", obj, str));
            }
            try {
                return Long.valueOf(Long.parseLong((String) obj));
            } catch (NumberFormatException unused) {
                throw new IllegalArgumentException(String.format("value '%s' for key '%s' is not a long integer", obj, str));
            }
        }
        Double d10 = (Double) obj;
        long jLongValue = d10.longValue();
        if (jLongValue == d10.doubleValue()) {
            return Long.valueOf(jLongValue);
        }
        throw new ClassCastException("Number expected to be long: " + d10);
    }

    @gm.j
    public static Map<String, ?> l(Map<String, ?> map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        Object obj = map.get(str);
        if (obj instanceof Map) {
            return (Map) obj;
        }
        throw new ClassCastException(String.format("value '%s' for key '%s' in '%s' is not object", obj, str, map));
    }

    @gm.j
    public static String m(Map<String, ?> map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        Object obj = map.get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        throw new ClassCastException(String.format("value '%s' for key '%s' in '%s' is not String", obj, str, map));
    }

    public static Long n(Map<String, ?> map, String str) {
        String strM = m(map, str);
        if (strM == null) {
            return null;
        }
        try {
            return Long.valueOf(p(strM));
        } catch (ParseException e10) {
            throw new RuntimeException(e10);
        }
    }

    public static long o(long j10, int i10) {
        long j11 = i10;
        long j12 = f18713c;
        if (j11 <= (-j12) || j11 >= j12) {
            j10 = m1.h.c(j10, j11 / j12);
            i10 = (int) (j11 % j12);
        }
        if (j10 > 0 && i10 < 0) {
            i10 = (int) (((long) i10) + j12);
            j10--;
        }
        if (j10 < 0 && i10 > 0) {
            i10 = (int) (((long) i10) - j12);
            j10++;
        }
        if (c(j10, i10)) {
            return r(TimeUnit.SECONDS.toNanos(j10), i10);
        }
        throw new IllegalArgumentException(String.format("Duration is not valid. See proto definition for valid values. Seconds (%s) must be in range [-315,576,000,000, +315,576,000,000]. Nanos (%s) must be in range [-999,999,999, +999,999,999]. Nanos must have the same sign as seconds", Long.valueOf(j10), Integer.valueOf(i10)));
    }

    public static long p(String str) throws ParseException {
        boolean z10;
        String strSubstring;
        if (str.isEmpty() || str.charAt(str.length() - 1) != 's') {
            throw new ParseException("Invalid duration string: ".concat(str), 0);
        }
        if (str.charAt(0) == '-') {
            str = str.substring(1);
            z10 = true;
        } else {
            z10 = false;
        }
        String strA = c0.b.a(str, 1, 0);
        int iIndexOf = strA.indexOf(46);
        if (iIndexOf != -1) {
            strSubstring = strA.substring(iIndexOf + 1);
            strA = strA.substring(0, iIndexOf);
        } else {
            strSubstring = "";
        }
        long j10 = Long.parseLong(strA);
        int iQ = strSubstring.isEmpty() ? 0 : q(strSubstring);
        if (j10 < 0) {
            throw new ParseException("Invalid duration string: ".concat(str), 0);
        }
        if (z10) {
            j10 = -j10;
            iQ = -iQ;
        }
        try {
            return o(j10, iQ);
        } catch (IllegalArgumentException unused) {
            throw new ParseException("Duration value is out of range.", 0);
        }
    }

    public static int q(String str) throws ParseException {
        int iCharAt = 0;
        for (int i10 = 0; i10 < 9; i10++) {
            iCharAt *= 10;
            if (i10 < str.length()) {
                if (str.charAt(i10) < '0' || str.charAt(i10) > '9') {
                    throw new ParseException("Invalid nanoseconds.", 0);
                }
                iCharAt = (str.charAt(i10) - '0') + iCharAt;
            }
        }
        return iCharAt;
    }

    public static long r(long j10, long j11) {
        long j12 = j10 + j11;
        return (((j11 ^ j10) > 0L ? 1 : ((j11 ^ j10) == 0L ? 0 : -1)) < 0) | ((j10 ^ j12) >= 0) ? j12 : ((j12 >>> 63) ^ 1) + Long.MAX_VALUE;
    }
}
