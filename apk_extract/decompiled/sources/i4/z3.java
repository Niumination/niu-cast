package i4;

import java.util.Map;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'KEY' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:399)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:364)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:349)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:315)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:288)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes.dex */
public abstract class z3 implements h4.m {
    private static final /* synthetic */ z3[] $VALUES = $values();
    public static final z3 KEY;
    public static final z3 VALUE;

    private static /* synthetic */ z3[] $values() {
        return new z3[]{KEY, VALUE};
    }

    static {
        final String str = "KEY";
        final int i8 = 0;
        KEY = new z3(str, i8) { // from class: i4.x3
            {
                v3 v3Var = null;
            }

            @Override // i4.z3, h4.m
            public Object apply(Map.Entry<?, ?> entry) {
                return entry.getKey();
            }
        };
        final String str2 = "VALUE";
        final int i9 = 1;
        VALUE = new z3(str2, i9) { // from class: i4.y3
            {
                v3 v3Var = null;
            }

            @Override // i4.z3, h4.m
            public Object apply(Map.Entry<?, ?> entry) {
                return entry.getValue();
            }
        };
    }

    private z3(String str, int i8) {
        super(str, i8);
    }

    public static z3 valueOf(String str) {
        return (z3) Enum.valueOf(z3.class, str);
    }

    public static z3[] values() {
        return (z3[]) $VALUES.clone();
    }

    public abstract /* synthetic */ Object apply(Object obj);

    public /* synthetic */ z3(String str, int i8, v3 v3Var) {
        this(str, i8);
    }
}
