package v1;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public abstract class v {
    private static final /* synthetic */ v[] $VALUES;
    public static final v DEFAULT;
    public static final v STRING;

    public final enum a extends v {
        public a(String str, int i10) {
            super(str, i10, null);
        }

        @Override // v1.v
        public k serialize(Long l10) {
            return l10 == null ? m.INSTANCE : new q(l10);
        }
    }

    static {
        a aVar = new a("DEFAULT", 0);
        DEFAULT = aVar;
        v vVar = new v("STRING", 1) { // from class: v1.v.b
            {
                a aVar2 = null;
            }

            @Override // v1.v
            public k serialize(Long l10) {
                return l10 == null ? m.INSTANCE : new q(l10.toString());
            }
        };
        STRING = vVar;
        $VALUES = new v[]{aVar, vVar};
    }

    private v(String str, int i10) {
        super(str, i10);
    }

    public static v valueOf(String str) {
        return (v) Enum.valueOf(v.class, str);
    }

    public static v[] values() {
        return (v[]) $VALUES.clone();
    }

    public abstract k serialize(Long l10);

    public /* synthetic */ v(String str, int i10, a aVar) {
        this(str, i10);
    }
}
