package io.netty.util.internal.logging;

import d6.a;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class MessageFormatter {
    private static final String DELIM_STR = "{}";
    private static final char ESCAPE_CHAR = '\\';

    private MessageFormatter() {
    }

    public static FormattingTuple arrayFormat(String str, Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            return new FormattingTuple(str, null);
        }
        int length = objArr.length - 1;
        Object obj = objArr[length];
        Throwable th2 = obj instanceof Throwable ? (Throwable) obj : null;
        if (str == null) {
            return new FormattingTuple(null, th2);
        }
        int iIndexOf = str.indexOf("{}");
        if (iIndexOf == -1) {
            return new FormattingTuple(str, th2);
        }
        StringBuilder sb2 = new StringBuilder(str.length() + 50);
        int i10 = 0;
        int i11 = 0;
        do {
            boolean z10 = iIndexOf == 0 || str.charAt(iIndexOf + (-1)) != '\\';
            if (z10) {
                sb2.append((CharSequence) str, i10, iIndexOf);
            } else {
                sb2.append((CharSequence) str, i10, iIndexOf - 1);
                z10 = iIndexOf >= 2 && str.charAt(iIndexOf + (-2)) == '\\';
            }
            i10 = iIndexOf + 2;
            if (z10) {
                deeplyAppendParameter(sb2, objArr[i11], null);
                i11++;
                if (i11 <= length) {
                    break;
                }
                break;
            }
            sb2.append("{}");
            iIndexOf = str.indexOf("{}", i10);
        } while (iIndexOf != -1);
        sb2.append((CharSequence) str, i10, str.length());
        return new FormattingTuple(sb2.toString(), i11 <= length ? th2 : null);
    }

    private static void booleanArrayAppend(StringBuilder sb2, boolean[] zArr) {
        if (zArr.length == 0) {
            return;
        }
        sb2.append(zArr[0]);
        for (int i10 = 1; i10 < zArr.length; i10++) {
            sb2.append(", ");
            sb2.append(zArr[i10]);
        }
    }

    private static void byteArrayAppend(StringBuilder sb2, byte[] bArr) {
        if (bArr.length == 0) {
            return;
        }
        sb2.append((int) bArr[0]);
        for (int i10 = 1; i10 < bArr.length; i10++) {
            sb2.append(", ");
            sb2.append((int) bArr[i10]);
        }
    }

    private static void charArrayAppend(StringBuilder sb2, char[] cArr) {
        if (cArr.length == 0) {
            return;
        }
        sb2.append(cArr[0]);
        for (int i10 = 1; i10 < cArr.length; i10++) {
            sb2.append(", ");
            sb2.append(cArr[i10]);
        }
    }

    private static void deeplyAppendParameter(StringBuilder sb2, Object obj, Set<Object[]> set) {
        if (obj == null) {
            sb2.append(a.E);
            return;
        }
        Class<?> cls = obj.getClass();
        if (!cls.isArray()) {
            if (!Number.class.isAssignableFrom(cls)) {
                safeObjectAppend(sb2, obj);
                return;
            }
            if (cls == Long.class) {
                sb2.append(((Long) obj).longValue());
                return;
            }
            if (cls == Integer.class || cls == Short.class || cls == Byte.class) {
                sb2.append(((Number) obj).intValue());
                return;
            }
            if (cls == Double.class) {
                sb2.append(((Double) obj).doubleValue());
                return;
            } else if (cls == Float.class) {
                sb2.append(((Float) obj).floatValue());
                return;
            } else {
                safeObjectAppend(sb2, obj);
                return;
            }
        }
        sb2.append(ks.a.f9445d);
        if (cls == boolean[].class) {
            booleanArrayAppend(sb2, (boolean[]) obj);
        } else if (cls == byte[].class) {
            byteArrayAppend(sb2, (byte[]) obj);
        } else if (cls == char[].class) {
            charArrayAppend(sb2, (char[]) obj);
        } else if (cls == short[].class) {
            shortArrayAppend(sb2, (short[]) obj);
        } else if (cls == int[].class) {
            intArrayAppend(sb2, (int[]) obj);
        } else if (cls == long[].class) {
            longArrayAppend(sb2, (long[]) obj);
        } else if (cls == float[].class) {
            floatArrayAppend(sb2, (float[]) obj);
        } else if (cls == double[].class) {
            doubleArrayAppend(sb2, (double[]) obj);
        } else {
            objectArrayAppend(sb2, (Object[]) obj, set);
        }
        sb2.append(']');
    }

    private static void doubleArrayAppend(StringBuilder sb2, double[] dArr) {
        if (dArr.length == 0) {
            return;
        }
        sb2.append(dArr[0]);
        for (int i10 = 1; i10 < dArr.length; i10++) {
            sb2.append(", ");
            sb2.append(dArr[i10]);
        }
    }

    private static void floatArrayAppend(StringBuilder sb2, float[] fArr) {
        if (fArr.length == 0) {
            return;
        }
        sb2.append(fArr[0]);
        for (int i10 = 1; i10 < fArr.length; i10++) {
            sb2.append(", ");
            sb2.append(fArr[i10]);
        }
    }

    public static FormattingTuple format(String str, Object obj) {
        return arrayFormat(str, new Object[]{obj});
    }

    private static void intArrayAppend(StringBuilder sb2, int[] iArr) {
        if (iArr.length == 0) {
            return;
        }
        sb2.append(iArr[0]);
        for (int i10 = 1; i10 < iArr.length; i10++) {
            sb2.append(", ");
            sb2.append(iArr[i10]);
        }
    }

    private static void longArrayAppend(StringBuilder sb2, long[] jArr) {
        if (jArr.length == 0) {
            return;
        }
        sb2.append(jArr[0]);
        for (int i10 = 1; i10 < jArr.length; i10++) {
            sb2.append(", ");
            sb2.append(jArr[i10]);
        }
    }

    private static void objectArrayAppend(StringBuilder sb2, Object[] objArr, Set<Object[]> set) {
        if (objArr.length == 0) {
            return;
        }
        if (set == null) {
            set = new HashSet<>(objArr.length);
        }
        if (!set.add(objArr)) {
            sb2.append("...");
            return;
        }
        deeplyAppendParameter(sb2, objArr[0], set);
        for (int i10 = 1; i10 < objArr.length; i10++) {
            sb2.append(", ");
            deeplyAppendParameter(sb2, objArr[i10], set);
        }
        set.remove(objArr);
    }

    private static void safeObjectAppend(StringBuilder sb2, Object obj) {
        try {
            sb2.append(obj.toString());
        } catch (Throwable th2) {
            System.err.println("SLF4J: Failed toString() invocation on an object of type [" + obj.getClass().getName() + ']');
            th2.printStackTrace();
            sb2.append("[FAILED toString()]");
        }
    }

    private static void shortArrayAppend(StringBuilder sb2, short[] sArr) {
        if (sArr.length == 0) {
            return;
        }
        sb2.append((int) sArr[0]);
        for (int i10 = 1; i10 < sArr.length; i10++) {
            sb2.append(", ");
            sb2.append((int) sArr[i10]);
        }
    }

    public static FormattingTuple format(String str, Object obj, Object obj2) {
        return arrayFormat(str, new Object[]{obj, obj2});
    }
}
