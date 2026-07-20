package l3;

/* JADX INFO: loaded from: classes.dex */
public final class f extends q0 implements r1 {
    private static final f zza;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private String zzg = "";

    static {
        f fVar = new f();
        zza = fVar;
        q0.h(f.class, fVar);
    }

    @Override // l3.q0
    public final Object n(int i8, q0 q0Var) {
        int i9 = i8 - 1;
        if (i9 == 0) {
            return (byte) 1;
        }
        if (i9 == 2) {
            return new a2(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i9 == 3) {
            return new f();
        }
        if (i9 == 4) {
            return new a4(4, zza);
        }
        if (i9 != 5) {
            return null;
        }
        return zza;
    }
}
