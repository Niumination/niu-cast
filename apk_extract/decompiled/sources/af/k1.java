package af;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'NO_ERROR' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes3.dex */
public final class k1 {
    private static final /* synthetic */ k1[] $VALUES;
    public static final k1 CANCEL;
    public static final k1 COMPRESSION_ERROR;
    public static final k1 CONNECT_ERROR;
    public static final k1 ENHANCE_YOUR_CALM;
    public static final k1 FLOW_CONTROL_ERROR;
    public static final k1 FRAME_SIZE_ERROR;
    public static final k1 HTTP_1_1_REQUIRED;
    public static final k1 INADEQUATE_SECURITY;
    public static final k1 INTERNAL_ERROR;
    public static final k1 NO_ERROR;
    public static final k1 PROTOCOL_ERROR;
    public static final k1 REFUSED_STREAM;
    public static final k1 SETTINGS_TIMEOUT;
    public static final k1 STREAM_CLOSED;
    private static final k1[] codeMap;
    private final int code;
    private final ze.q2 status;

    static {
        ze.q2 q2Var = ze.q2.f11411n;
        k1 k1Var = new k1("NO_ERROR", 0, 0, q2Var);
        NO_ERROR = k1Var;
        ze.q2 q2Var2 = ze.q2.f11410m;
        k1 k1Var2 = new k1("PROTOCOL_ERROR", 1, 1, q2Var2);
        PROTOCOL_ERROR = k1Var2;
        k1 k1Var3 = new k1("INTERNAL_ERROR", 2, 2, q2Var2);
        INTERNAL_ERROR = k1Var3;
        k1 k1Var4 = new k1("FLOW_CONTROL_ERROR", 3, 3, q2Var2);
        FLOW_CONTROL_ERROR = k1Var4;
        k1 k1Var5 = new k1("SETTINGS_TIMEOUT", 4, 4, q2Var2);
        SETTINGS_TIMEOUT = k1Var5;
        k1 k1Var6 = new k1("STREAM_CLOSED", 5, 5, q2Var2);
        STREAM_CLOSED = k1Var6;
        k1 k1Var7 = new k1("FRAME_SIZE_ERROR", 6, 6, q2Var2);
        FRAME_SIZE_ERROR = k1Var7;
        k1 k1Var8 = new k1("REFUSED_STREAM", 7, 7, q2Var);
        REFUSED_STREAM = k1Var8;
        k1 k1Var9 = new k1("CANCEL", 8, 8, ze.q2.f);
        CANCEL = k1Var9;
        k1 k1Var10 = new k1("COMPRESSION_ERROR", 9, 9, q2Var2);
        COMPRESSION_ERROR = k1Var10;
        k1 k1Var11 = new k1("CONNECT_ERROR", 10, 10, q2Var2);
        CONNECT_ERROR = k1Var11;
        k1 k1Var12 = new k1("ENHANCE_YOUR_CALM", 11, 11, ze.q2.f11408k.h("Bandwidth exhausted"));
        ENHANCE_YOUR_CALM = k1Var12;
        k1 k1Var13 = new k1("INADEQUATE_SECURITY", 12, 12, ze.q2.f11406i.h("Permission denied as protocol is not secure enough to call"));
        INADEQUATE_SECURITY = k1Var13;
        k1 k1Var14 = new k1("HTTP_1_1_REQUIRED", 13, 13, ze.q2.f11404g);
        HTTP_1_1_REQUIRED = k1Var14;
        $VALUES = new k1[]{k1Var, k1Var2, k1Var3, k1Var4, k1Var5, k1Var6, k1Var7, k1Var8, k1Var9, k1Var10, k1Var11, k1Var12, k1Var13, k1Var14};
        codeMap = buildHttp2CodeMap();
    }

    private k1(String str, int i8, int i9, ze.q2 q2Var) {
        super(str, i8);
        this.code = i9;
        String str2 = "HTTP/2 error code: " + name();
        this.status = q2Var.h(q2Var.f11414b != null ? h0.a.n(o.d.t(str2, " ("), q2Var.f11414b, ")") : str2);
    }

    private static k1[] buildHttp2CodeMap() {
        k1[] k1VarArrValues = values();
        k1[] k1VarArr = new k1[((int) k1VarArrValues[k1VarArrValues.length - 1].code()) + 1];
        for (k1 k1Var : k1VarArrValues) {
            k1VarArr[(int) k1Var.code()] = k1Var;
        }
        return k1VarArr;
    }

    public static k1 forCode(long j8) {
        k1[] k1VarArr = codeMap;
        if (j8 >= k1VarArr.length || j8 < 0) {
            return null;
        }
        return k1VarArr[(int) j8];
    }

    public static ze.q2 statusForCode(long j8) {
        k1 k1VarForCode = forCode(j8);
        if (k1VarForCode != null) {
            return k1VarForCode.status();
        }
        return ze.q2.c(INTERNAL_ERROR.status().f11413a.value()).h("Unrecognized HTTP/2 error code: " + j8);
    }

    public static k1 valueOf(String str) {
        return (k1) Enum.valueOf(k1.class, str);
    }

    public static k1[] values() {
        return (k1[]) $VALUES.clone();
    }

    public long code() {
        return this.code;
    }

    public ze.q2 status() {
        return this.status;
    }
}
