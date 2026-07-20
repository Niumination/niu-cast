package l3;

/* JADX INFO: loaded from: classes.dex */
public final class f3 extends q0 implements r1 {
    private static final f3 zza;
    private int zzd;
    private String zze = "";
    private String zzf = "";

    static {
        f3 f3Var = new f3();
        zza = f3Var;
        q0.h(f3.class, f3Var);
    }

    @Override // l3.q0
    public final Object n(int i8, q0 q0Var) {
        int i9 = i8 - 1;
        if (i9 == 0) {
            return (byte) 1;
        }
        if (i9 == 2) {
            return new a2(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i9 == 3) {
            return new f3();
        }
        if (i9 == 4) {
            return new a4(13, zza);
        }
        if (i9 != 5) {
            return null;
        }
        return zza;
    }
}
