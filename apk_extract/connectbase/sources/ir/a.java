package ir;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v0 ir.a, still in use, count: 1, list:
  (r0v0 ir.a) from 0x009c: FILLED_NEW_ARRAY (r0v0 ir.a), (r1v1 ir.a), (r3v3 ir.a), (r12v1 ir.a), (r13v1 ir.a) A[WRAPPED] elemType: ir.a
	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:257)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:187)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    GENERAL("bBhHsS", null),
    CHAR("cC", Character.class, Byte.class, Short.class, Integer.class),
    INT("doxX", Byte.class, Short.class, Integer.class, Long.class, BigInteger.class),
    FLOAT("eEfgGaA", Float.class, Double.class, BigDecimal.class),
    TIME("tT", Long.class, Calendar.class, Date.class),
    CHAR_AND_INT(null, Byte.class, Short.class, Integer.class),
    INT_AND_TIME(null, Long.class),
    NULL(null, new Class[0]),
    UNUSED(null, null);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a[] f8353a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a[] f8354b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a[] f8355c;
    public final String chars;
    public final Class<?>[] types;

    static {
        a aVar = CHAR;
        a aVar2 = INT;
        a aVar3 = FLOAT;
        a aVar4 = TIME;
        a aVar5 = CHAR_AND_INT;
        a aVar6 = INT_AND_TIME;
        a aVar7 = NULL;
        f8353a = new a[]{aVar, aVar, aVar2, aVar3, aVar4};
        f8354b = new a[]{aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7};
        f8355c = new a[]{aVar7, aVar5, aVar6, aVar, aVar2, aVar3, aVar4};
    }

    public a(String str, Class... clsArr) {
        super(str, i);
        this.chars = str;
        if (clsArr == null) {
            this.types = clsArr;
            return;
        }
        ArrayList arrayList = new ArrayList(clsArr.length);
        for (Class cls : clsArr) {
            arrayList.add(cls);
            Class<? extends Object> clsD = d(cls);
            if (clsD != null) {
                arrayList.add(clsD);
            }
        }
        this.types = (Class[]) arrayList.toArray(new Class[arrayList.size()]);
    }

    public static <E> Set<E> b(E[] eArr) {
        return new HashSet(Arrays.asList(eArr));
    }

    public static Class<? extends Object> d(Class<?> cls) {
        if (cls == Byte.class) {
            return Byte.TYPE;
        }
        if (cls == Character.class) {
            return Character.TYPE;
        }
        if (cls == Short.class) {
            return Short.TYPE;
        }
        if (cls == Integer.class) {
            return Integer.TYPE;
        }
        if (cls == Long.class) {
            return Long.TYPE;
        }
        if (cls == Float.class) {
            return Float.TYPE;
        }
        if (cls == Double.class) {
            return Double.TYPE;
        }
        if (cls == Boolean.class) {
            return Boolean.TYPE;
        }
        return null;
    }

    public static a fromConversionChar(char c10) {
        for (a aVar : f8353a) {
            if (aVar.chars.contains(String.valueOf(c10))) {
                return aVar;
            }
        }
        throw new IllegalArgumentException("Bad conversion character " + c10);
    }

    public static a intersect(a aVar, a aVar2) {
        a aVar3 = UNUSED;
        if (aVar == aVar3) {
            return aVar2;
        }
        if (aVar2 == aVar3) {
            return aVar;
        }
        a aVar4 = GENERAL;
        if (aVar == aVar4) {
            return aVar2;
        }
        if (aVar2 == aVar4) {
            return aVar;
        }
        Set setB = b(aVar.types);
        setB.retainAll(b(aVar2.types));
        for (a aVar5 : f8354b) {
            if (b(aVar5.types).equals(setB)) {
                return aVar5;
            }
        }
        throw new RuntimeException();
    }

    public static boolean isSubsetOf(a aVar, a aVar2) {
        return intersect(aVar, aVar2) == aVar;
    }

    public static a union(a aVar, a aVar2) {
        a aVar3 = UNUSED;
        if (aVar == aVar3 || aVar2 == aVar3 || aVar == (aVar3 = GENERAL) || aVar2 == aVar3) {
            return aVar3;
        }
        a aVar4 = CHAR_AND_INT;
        if ((aVar == aVar4 && aVar2 == INT_AND_TIME) || (aVar == INT_AND_TIME && aVar2 == aVar4)) {
            return INT;
        }
        Set setB = b(aVar.types);
        setB.addAll(b(aVar2.types));
        for (a aVar5 : f8355c) {
            if (b(aVar5.types).equals(setB)) {
                return aVar5;
            }
        }
        return GENERAL;
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) f8356d.clone();
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
    @gs.c
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(name());
        sb2.append(" conversion category");
        Class<?>[] clsArr = this.types;
        if (clsArr == null || clsArr.length == 0) {
            return sb2.toString();
        }
        StringJoiner stringJoiner = new StringJoiner(", ", "(one of: ", ")");
        for (Class<?> cls : this.types) {
            stringJoiner.add(cls.getSimpleName());
        }
        sb2.append(" ");
        sb2.append(stringJoiner);
        return sb2.toString();
    }
}
