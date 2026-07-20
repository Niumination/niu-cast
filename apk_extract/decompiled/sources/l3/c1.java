package l3;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'zzb' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes.dex */
public final class c1 {
    public static final c1 zza;
    public static final c1 zzb;
    public static final c1 zzc;
    public static final c1 zzd;
    public static final c1 zze;
    public static final c1 zzf;
    public static final c1 zzg;
    public static final c1 zzh;
    public static final c1 zzi;
    public static final c1 zzj;
    private static final /* synthetic */ c1[] zzk;
    private final Class zzl;
    private final Class zzm;
    private final Object zzn;

    static {
        c1 c1Var = new c1("VOID", 0, Void.class, Void.class, null);
        zza = c1Var;
        Class cls = Integer.TYPE;
        c1 c1Var2 = new c1("INT", 1, cls, Integer.class, 0);
        zzb = c1Var2;
        c1 c1Var3 = new c1("LONG", 2, Long.TYPE, Long.class, 0L);
        zzc = c1Var3;
        c1 c1Var4 = new c1("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        zzd = c1Var4;
        c1 c1Var5 = new c1("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(0.0d));
        zze = c1Var5;
        c1 c1Var6 = new c1("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        zzf = c1Var6;
        c1 c1Var7 = new c1("STRING", 6, String.class, String.class, "");
        zzg = c1Var7;
        c1 c1Var8 = new c1("BYTE_STRING", 7, b0.class, b0.class, b0.zzb);
        zzh = c1Var8;
        c1 c1Var9 = new c1("ENUM", 8, cls, Integer.class, null);
        zzi = c1Var9;
        c1 c1Var10 = new c1("MESSAGE", 9, Object.class, Object.class, null);
        zzj = c1Var10;
        zzk = new c1[]{c1Var, c1Var2, c1Var3, c1Var4, c1Var5, c1Var6, c1Var7, c1Var8, c1Var9, c1Var10};
    }

    private c1(String str, int i8, Class cls, Class cls2, Object obj) {
        super(str, i8);
        this.zzl = cls;
        this.zzm = cls2;
        this.zzn = obj;
    }

    public static c1[] values() {
        return (c1[]) zzk.clone();
    }

    public final Class zza() {
        return this.zzm;
    }
}
