package jq;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'IGNORE_CASE' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:399)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:364)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:349)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:315)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:288)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:160)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes3.dex */
public final class t implements i {
    public static final t CANON_EQ;
    public static final t COMMENTS;
    public static final t DOT_MATCHES_ALL;
    public static final t IGNORE_CASE;
    public static final t LITERAL;
    public static final t MULTILINE;
    public static final t UNIX_LINES;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ t[] f8896a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ ym.a f8897b;
    private final int mask;
    private final int value;

    static {
        int i10 = 2;
        IGNORE_CASE = new t("IGNORE_CASE", 0, i10, 0, 2, null);
        int i11 = 2;
        kn.w wVar = null;
        int i12 = 0;
        MULTILINE = new t("MULTILINE", 1, 8, i12, i11, wVar);
        int i13 = 2;
        kn.w wVar2 = null;
        int i14 = 0;
        LITERAL = new t("LITERAL", i10, 16, i14, i13, wVar2);
        UNIX_LINES = new t("UNIX_LINES", 3, 1, i12, i11, wVar);
        COMMENTS = new t("COMMENTS", 4, 4, i14, i13, wVar2);
        DOT_MATCHES_ALL = new t("DOT_MATCHES_ALL", 5, 32, i12, i11, wVar);
        CANON_EQ = new t("CANON_EQ", 6, 128, i14, i13, wVar2);
        t[] tVarArrA = a();
        f8896a = tVarArrA;
        f8897b = ym.c.c(tVarArrA);
    }

    public t(String str, int i10, int i11, int i12) {
        super(str, i10);
        this.value = i11;
        this.mask = i12;
    }

    public static final /* synthetic */ t[] a() {
        return new t[]{IGNORE_CASE, MULTILINE, LITERAL, UNIX_LINES, COMMENTS, DOT_MATCHES_ALL, CANON_EQ};
    }

    @os.l
    public static ym.a<t> getEntries() {
        return f8897b;
    }

    public static t valueOf(String str) {
        return (t) Enum.valueOf(t.class, str);
    }

    public static t[] values() {
        return (t[]) f8896a.clone();
    }

    @Override // jq.i
    public int getMask() {
        return this.mask;
    }

    @Override // jq.i
    public int getValue() {
        return this.value;
    }

    public /* synthetic */ t(String str, int i10, int i11, int i12, int i13, kn.w wVar) {
        this(str, i10, i11, (i13 & 2) != 0 ? i11 : i12);
    }
}
