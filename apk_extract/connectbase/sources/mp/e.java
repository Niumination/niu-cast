package mp;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import ao.i;
import ik.y0;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import os.l;

/* JADX INFO: loaded from: classes3.dex */
public enum e {
    BOOLEAN(i.BOOLEAN, TypedValues.Custom.S_BOOLEAN, "Z", "java.lang.Boolean"),
    CHAR(i.CHAR, "char", "C", "java.lang.Character"),
    BYTE(i.BYTE, "byte", "B", "java.lang.Byte"),
    SHORT(i.SHORT, "short", "S", "java.lang.Short"),
    INT(i.INT, "int", "I", "java.lang.Integer"),
    FLOAT(i.FLOAT, TypedValues.Custom.S_FLOAT, "F", "java.lang.Float"),
    LONG(i.LONG, "long", "J", "java.lang.Long"),
    DOUBLE(i.DOUBLE, "double", "D", "java.lang.Double");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<dp.c> f10864a = new HashSet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, e> f10865b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<i, e> f10866c = new EnumMap(i.class);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<String, e> f10867d = new HashMap();
    private final String desc;
    private final String name;
    private final i primitiveType;
    private final dp.c wrapperFqName;

    static {
        for (e eVar : values()) {
            f10864a.add(eVar.getWrapperFqName());
            f10865b.put(eVar.getJavaKeywordName(), eVar);
            f10866c.put(eVar.getPrimitiveType(), eVar);
            f10867d.put(eVar.getDesc(), eVar);
        }
    }

    e(@l i iVar, @l String str, String str2, String str3) {
        if (iVar == null) {
            a(6);
        }
        if (str == null) {
            a(7);
        }
        if (str2 == null) {
            a(8);
        }
        if (str3 == null) {
            a(9);
        }
        this.primitiveType = iVar;
        this.name = str;
        this.desc = str2;
        this.wrapperFqName = new dp.c(str3);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x000c  */
    public static /* synthetic */ void a(int i10) {
        String str;
        int i11;
        if (i10 != 2 && i10 != 4) {
            switch (i10) {
                case 10:
                case 11:
                case 12:
                case 13:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
        } else {
            str = "@NotNull method %s.%s must not return null";
        }
        if (i10 != 2 && i10 != 4) {
            switch (i10) {
                case 10:
                case 11:
                case 12:
                case 13:
                    i11 = 2;
                    break;
                default:
                    i11 = 3;
                    break;
            }
        } else {
            i11 = 2;
        }
        Object[] objArr = new Object[i11];
        switch (i10) {
            case 1:
            case 7:
                objArr[0] = "name";
                break;
            case 2:
            case 4:
            case 10:
            case 11:
            case 12:
            case 13:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType";
                break;
            case 3:
                objArr[0] = y0.a.f8215h;
                break;
            case 5:
            case 8:
                objArr[0] = "desc";
                break;
            case 6:
                objArr[0] = "primitiveType";
                break;
            case 9:
                objArr[0] = "wrapperClassName";
                break;
            default:
                objArr[0] = cb.b.C0062b.f1395b;
                break;
        }
        if (i10 != 2 && i10 != 4) {
            switch (i10) {
                case 10:
                    objArr[1] = "getPrimitiveType";
                    break;
                case 11:
                    objArr[1] = "getJavaKeywordName";
                    break;
                case 12:
                    objArr[1] = "getDesc";
                    break;
                case 13:
                    objArr[1] = "getWrapperFqName";
                    break;
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType";
                    break;
            }
        } else {
            objArr[1] = "get";
        }
        switch (i10) {
            case 1:
            case 3:
                objArr[2] = "get";
                break;
            case 2:
            case 4:
            case 10:
            case 11:
            case 12:
            case 13:
                break;
            case 5:
                objArr[2] = "getByDesc";
                break;
            case 6:
            case 7:
            case 8:
            case 9:
                objArr[2] = "<init>";
                break;
            default:
                objArr[2] = "isWrapperClassName";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i10 != 2 && i10 != 4) {
            switch (i10) {
                case 10:
                case 11:
                case 12:
                case 13:
                    break;
                default:
                    throw new IllegalArgumentException(str2);
            }
        }
        throw new IllegalStateException(str2);
    }

    @l
    public static e get(@l String str) {
        if (str == null) {
            a(1);
        }
        e eVar = f10865b.get(str);
        if (eVar != null) {
            return eVar;
        }
        throw new AssertionError(m.a.a("Non-primitive type name passed: ", str));
    }

    @l
    public String getDesc() {
        String str = this.desc;
        if (str == null) {
            a(12);
        }
        return str;
    }

    @l
    public String getJavaKeywordName() {
        String str = this.name;
        if (str == null) {
            a(11);
        }
        return str;
    }

    @l
    public i getPrimitiveType() {
        i iVar = this.primitiveType;
        if (iVar == null) {
            a(10);
        }
        return iVar;
    }

    @l
    public dp.c getWrapperFqName() {
        dp.c cVar = this.wrapperFqName;
        if (cVar == null) {
            a(13);
        }
        return cVar;
    }

    @l
    public static e get(@l i iVar) {
        if (iVar == null) {
            a(3);
        }
        e eVar = f10866c.get(iVar);
        if (eVar == null) {
            a(4);
        }
        return eVar;
    }
}
