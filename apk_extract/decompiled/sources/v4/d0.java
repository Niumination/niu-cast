package v4;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public abstract class d0 {
    private static final /* synthetic */ d0[] $VALUES;
    public static final d0 DEFAULT;
    public static final d0 STRING;

    static {
        b0 b0Var = new b0("DEFAULT", 0);
        DEFAULT = b0Var;
        final String str = "STRING";
        final int i8 = 1;
        d0 d0Var = new d0(str, i8) { // from class: v4.c0
            {
                b0 b0Var2 = null;
            }

            @Override // v4.d0
            public u serialize(Long l4) {
                return l4 == null ? w.INSTANCE : new z(l4.toString());
            }
        };
        STRING = d0Var;
        $VALUES = new d0[]{b0Var, d0Var};
    }

    private d0(String str, int i8) {
        super(str, i8);
    }

    public static d0 valueOf(String str) {
        return (d0) Enum.valueOf(d0.class, str);
    }

    public static d0[] values() {
        return (d0[]) $VALUES.clone();
    }

    public abstract u serialize(Long l4);

    public /* synthetic */ d0(String str, int i8, b0 b0Var) {
        this(str, i8);
    }
}
