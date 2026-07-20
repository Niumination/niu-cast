package l3;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'zzc' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes.dex */
public final class a3 {
    public static final a3 zza;
    public static final a3 zzb;
    public static final a3 zzc;
    public static final a3 zzd;
    public static final a3 zze;
    public static final a3 zzf;
    public static final a3 zzg;
    public static final a3 zzh;
    public static final a3 zzi;
    public static final a3 zzj;
    public static final a3 zzk;
    public static final a3 zzl;
    public static final a3 zzm;
    public static final a3 zzn;
    public static final a3 zzo;
    public static final a3 zzp;
    public static final a3 zzq;
    public static final a3 zzr;
    private static final /* synthetic */ a3[] zzs;
    private final b3 zzt;

    static {
        a3 a3Var = new a3("DOUBLE", 0, b3.DOUBLE, 1);
        zza = a3Var;
        a3 a3Var2 = new a3("FLOAT", 1, b3.FLOAT, 5);
        zzb = a3Var2;
        b3 b3Var = b3.LONG;
        a3 a3Var3 = new a3("INT64", 2, b3Var, 0);
        zzc = a3Var3;
        a3 a3Var4 = new a3("UINT64", 3, b3Var, 0);
        zzd = a3Var4;
        b3 b3Var2 = b3.INT;
        a3 a3Var5 = new a3("INT32", 4, b3Var2, 0);
        zze = a3Var5;
        a3 a3Var6 = new a3("FIXED64", 5, b3Var, 1);
        zzf = a3Var6;
        a3 a3Var7 = new a3("FIXED32", 6, b3Var2, 5);
        zzg = a3Var7;
        a3 a3Var8 = new a3("BOOL", 7, b3.BOOLEAN, 0);
        zzh = a3Var8;
        a3 a3Var9 = new a3("STRING", 8, b3.STRING, 2);
        zzi = a3Var9;
        b3 b3Var3 = b3.MESSAGE;
        a3 a3Var10 = new a3("GROUP", 9, b3Var3, 3);
        zzj = a3Var10;
        a3 a3Var11 = new a3("MESSAGE", 10, b3Var3, 2);
        zzk = a3Var11;
        a3 a3Var12 = new a3("BYTES", 11, b3.BYTE_STRING, 2);
        zzl = a3Var12;
        a3 a3Var13 = new a3("UINT32", 12, b3Var2, 0);
        zzm = a3Var13;
        a3 a3Var14 = new a3("ENUM", 13, b3.ENUM, 0);
        zzn = a3Var14;
        a3 a3Var15 = new a3("SFIXED32", 14, b3Var2, 5);
        zzo = a3Var15;
        a3 a3Var16 = new a3("SFIXED64", 15, b3Var, 1);
        zzp = a3Var16;
        a3 a3Var17 = new a3("SINT32", 16, b3Var2, 0);
        zzq = a3Var17;
        a3 a3Var18 = new a3("SINT64", 17, b3Var, 0);
        zzr = a3Var18;
        zzs = new a3[]{a3Var, a3Var2, a3Var3, a3Var4, a3Var5, a3Var6, a3Var7, a3Var8, a3Var9, a3Var10, a3Var11, a3Var12, a3Var13, a3Var14, a3Var15, a3Var16, a3Var17, a3Var18};
    }

    private a3(String str, int i8, b3 b3Var, int i9) {
        super(str, i8);
        this.zzt = b3Var;
    }

    public static a3[] values() {
        return (a3[]) zzs.clone();
    }

    public final b3 zza() {
        return this.zzt;
    }
}
