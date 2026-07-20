package rs;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char f14859a = '{';

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final char f14860b = '}';

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f14861c = "{}";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final char f14862d = '\\';

    public static final d a(String str, Object[] objArr) {
        Throwable thK = k(objArr);
        if (thK != null) {
            objArr = s(objArr);
        }
        return b(str, objArr, thK);
    }

    public static final d b(String str, Object[] objArr, Throwable th2) {
        int i10;
        if (str == null) {
            return new d(null, objArr, th2);
        }
        if (objArr == null) {
            return new d(str, null, null);
        }
        StringBuilder sb2 = new StringBuilder(str.length() + 50);
        int i11 = 0;
        int i12 = 0;
        while (i11 < objArr.length) {
            int iIndexOf = str.indexOf("{}", i12);
            if (iIndexOf == -1) {
                if (i12 == 0) {
                    return new d(str, objArr, th2);
                }
                sb2.append((CharSequence) str, i12, str.length());
                return new d(sb2.toString(), objArr, th2);
            }
            if (n(str, iIndexOf)) {
                if (m(str, iIndexOf)) {
                    sb2.append((CharSequence) str, i12, iIndexOf - 1);
                    f(sb2, objArr[i11], new HashMap());
                } else {
                    i11--;
                    sb2.append((CharSequence) str, i12, iIndexOf - 1);
                    sb2.append(f14859a);
                    i10 = iIndexOf + 1;
                }
                i12 = i10;
                i11++;
            } else {
                sb2.append((CharSequence) str, i12, iIndexOf);
                f(sb2, objArr[i11], new HashMap());
            }
            i10 = iIndexOf + 2;
            i12 = i10;
            i11++;
        }
        sb2.append((CharSequence) str, i12, str.length());
        return new d(sb2.toString(), objArr, th2);
    }

    public static void c(StringBuilder sb2, boolean[] zArr) {
        sb2.append(ks.a.f9445d);
        int length = zArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            sb2.append(zArr[i10]);
            if (i10 != length - 1) {
                sb2.append(", ");
            }
        }
        sb2.append(']');
    }

    public static void d(StringBuilder sb2, byte[] bArr) {
        sb2.append(ks.a.f9445d);
        int length = bArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            sb2.append((int) bArr[i10]);
            if (i10 != length - 1) {
                sb2.append(", ");
            }
        }
        sb2.append(']');
    }

    public static void e(StringBuilder sb2, char[] cArr) {
        sb2.append(ks.a.f9445d);
        int length = cArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            sb2.append(cArr[i10]);
            if (i10 != length - 1) {
                sb2.append(", ");
            }
        }
        sb2.append(']');
    }

    public static void f(StringBuilder sb2, Object obj, Map<Object[], Object> map) {
        if (obj == null) {
            sb2.append(d6.a.E);
            return;
        }
        if (!obj.getClass().isArray()) {
            q(sb2, obj);
            return;
        }
        if (obj instanceof boolean[]) {
            c(sb2, (boolean[]) obj);
            return;
        }
        if (obj instanceof byte[]) {
            d(sb2, (byte[]) obj);
            return;
        }
        if (obj instanceof char[]) {
            e(sb2, (char[]) obj);
            return;
        }
        if (obj instanceof short[]) {
            r(sb2, (short[]) obj);
            return;
        }
        if (obj instanceof int[]) {
            l(sb2, (int[]) obj);
            return;
        }
        if (obj instanceof long[]) {
            o(sb2, (long[]) obj);
            return;
        }
        if (obj instanceof float[]) {
            h(sb2, (float[]) obj);
        } else if (obj instanceof double[]) {
            g(sb2, (double[]) obj);
        } else {
            p(sb2, (Object[]) obj, map);
        }
    }

    public static void g(StringBuilder sb2, double[] dArr) {
        sb2.append(ks.a.f9445d);
        int length = dArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            sb2.append(dArr[i10]);
            if (i10 != length - 1) {
                sb2.append(", ");
            }
        }
        sb2.append(']');
    }

    public static void h(StringBuilder sb2, float[] fArr) {
        sb2.append(ks.a.f9445d);
        int length = fArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            sb2.append(fArr[i10]);
            if (i10 != length - 1) {
                sb2.append(", ");
            }
        }
        sb2.append(']');
    }

    public static final d i(String str, Object obj) {
        return a(str, new Object[]{obj});
    }

    public static final d j(String str, Object obj, Object obj2) {
        return a(str, new Object[]{obj, obj2});
    }

    public static Throwable k(Object[] objArr) {
        if (objArr != null && objArr.length != 0) {
            Object obj = objArr[objArr.length - 1];
            if (obj instanceof Throwable) {
                return (Throwable) obj;
            }
        }
        return null;
    }

    public static void l(StringBuilder sb2, int[] iArr) {
        sb2.append(ks.a.f9445d);
        int length = iArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            sb2.append(iArr[i10]);
            if (i10 != length - 1) {
                sb2.append(", ");
            }
        }
        sb2.append(']');
    }

    public static final boolean m(String str, int i10) {
        return i10 >= 2 && str.charAt(i10 - 2) == '\\';
    }

    public static final boolean n(String str, int i10) {
        return i10 != 0 && str.charAt(i10 - 1) == '\\';
    }

    public static void o(StringBuilder sb2, long[] jArr) {
        sb2.append(ks.a.f9445d);
        int length = jArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            sb2.append(jArr[i10]);
            if (i10 != length - 1) {
                sb2.append(", ");
            }
        }
        sb2.append(']');
    }

    public static void p(StringBuilder sb2, Object[] objArr, Map<Object[], Object> map) {
        sb2.append(ks.a.f9445d);
        if (map.containsKey(objArr)) {
            sb2.append("...");
        } else {
            map.put(objArr, null);
            int length = objArr.length;
            for (int i10 = 0; i10 < length; i10++) {
                f(sb2, objArr[i10], map);
                if (i10 != length - 1) {
                    sb2.append(", ");
                }
            }
            map.remove(objArr);
        }
        sb2.append(']');
    }

    public static void q(StringBuilder sb2, Object obj) {
        try {
            sb2.append(obj.toString());
        } catch (Throwable th2) {
            m.d("SLF4J: Failed toString() invocation on an object of type [" + obj.getClass().getName() + "]", th2);
            sb2.append("[FAILED toString()]");
        }
    }

    public static void r(StringBuilder sb2, short[] sArr) {
        sb2.append(ks.a.f9445d);
        int length = sArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            sb2.append((int) sArr[i10]);
            if (i10 != length - 1) {
                sb2.append(", ");
            }
        }
        sb2.append(']');
    }

    public static Object[] s(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            throw new IllegalStateException("non-sensical empty or null argument array");
        }
        int length = objArr.length - 1;
        Object[] objArr2 = new Object[length];
        if (length > 0) {
            System.arraycopy(objArr, 0, objArr2, 0, length);
        }
        return objArr2;
    }
}
