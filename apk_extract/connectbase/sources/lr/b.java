package lr;

import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;

/* JADX INFO: loaded from: classes3.dex */
public enum b {
    UNUSED(null, null),
    GENERAL(null, null),
    DATE(new Class[]{Date.class, Number.class}, new String[]{"date", RtspHeaders.Values.TIME}),
    NUMBER(new Class[]{Number.class}, new String[]{"number", "choice"});


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b[] f10271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b[] f10272b;
    public final String[] strings;
    public final Class<?>[] types;

    static {
        b bVar = DATE;
        b bVar2 = NUMBER;
        f10271a = new b[]{bVar, bVar2};
        f10272b = new b[]{bVar, bVar2};
    }

    b(Class[] clsArr, String[] strArr) {
        this.types = clsArr;
        this.strings = strArr;
    }

    public static <E> Set<E> b(E[] eArr) {
        return new HashSet(Arrays.asList(eArr));
    }

    public static b intersect(b bVar, b bVar2) {
        b bVar3 = UNUSED;
        if (bVar == bVar3) {
            return bVar2;
        }
        if (bVar2 == bVar3) {
            return bVar;
        }
        b bVar4 = GENERAL;
        if (bVar == bVar4) {
            return bVar2;
        }
        if (bVar2 == bVar4) {
            return bVar;
        }
        Set setB = b(bVar.types);
        setB.retainAll(b(bVar2.types));
        for (b bVar5 : f10272b) {
            if (b(bVar5.types).equals(setB)) {
                return bVar5;
            }
        }
        throw new RuntimeException();
    }

    public static boolean isSubsetOf(b bVar, b bVar2) {
        return intersect(bVar, bVar2) == bVar;
    }

    public static b stringToI18nConversionCategory(String str) {
        String lowerCase = str.toLowerCase();
        for (b bVar : f10271a) {
            for (String str2 : bVar.strings) {
                if (str2.equals(lowerCase)) {
                    return bVar;
                }
            }
        }
        throw new IllegalArgumentException(m.a.a("Invalid format type ", lowerCase));
    }

    public static b union(b bVar, b bVar2) {
        b bVar3 = UNUSED;
        return (bVar == bVar3 || bVar2 == bVar3 || bVar == (bVar3 = GENERAL) || bVar2 == bVar3 || bVar == (bVar3 = DATE) || bVar2 == bVar3) ? bVar3 : NUMBER;
    }

    public boolean isAssignableFrom(Class<?> cls) {
        Class<?>[] clsArr = this.types;
        if (clsArr == null || cls == Void.TYPE) {
            return true;
        }
        for (Class<?> cls2 : clsArr) {
            if (cls2.isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.Enum
    public String toString() {
        StringBuilder sb2 = new StringBuilder(name());
        if (this.types == null) {
            sb2.append(" conversion category (all types)");
        } else {
            StringJoiner stringJoiner = new StringJoiner(", ", " conversion category (one of: ", ")");
            for (Class<?> cls : this.types) {
                stringJoiner.add(cls.getCanonicalName());
            }
            sb2.append(stringJoiner);
        }
        return sb2.toString();
    }
}
