package i4;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'STRONG' uses external variables
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
public abstract class w2 {
    private static final /* synthetic */ w2[] $VALUES = $values();
    public static final w2 STRONG;
    public static final w2 WEAK;

    private static /* synthetic */ w2[] $values() {
        return new w2[]{STRONG, WEAK};
    }

    static {
        final String str = "STRONG";
        final int i8 = 0;
        STRONG = new w2(str, i8) { // from class: i4.u2
            {
                j2 j2Var = null;
            }

            @Override // i4.w2
            public h4.l defaultEquivalence() {
                return h4.l.equals();
            }
        };
        final String str2 = "WEAK";
        final int i9 = 1;
        WEAK = new w2(str2, i9) { // from class: i4.v2
            {
                j2 j2Var = null;
            }

            @Override // i4.w2
            public h4.l defaultEquivalence() {
                return h4.l.identity();
            }
        };
    }

    private w2(String str, int i8) {
        super(str, i8);
    }

    public static w2 valueOf(String str) {
        return (w2) Enum.valueOf(w2.class, str);
    }

    public static w2[] values() {
        return (w2[]) $VALUES.clone();
    }

    public abstract h4.l defaultEquivalence();

    public /* synthetic */ w2(String str, int i8, j2 j2Var) {
        this(str, i8);
    }
}
