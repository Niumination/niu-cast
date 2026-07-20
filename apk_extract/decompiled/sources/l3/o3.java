package l3;

/* JADX INFO: loaded from: classes.dex */
public final class o3 extends q0 implements r1 {
    private static final o3 zza;
    private int zzd;
    private boolean zzf;
    private int zzg;
    private boolean zzj;
    private int zzm;
    private int zzn;
    private boolean zzo;
    private int zze = -1;
    private b0 zzh = b0.zzb;
    private String zzi = "";
    private boolean zzk = true;
    private boolean zzl = true;

    static {
        o3 o3Var = new o3();
        zza = o3Var;
        q0.h(o3.class, o3Var);
    }

    @Override // l3.q0
    public final Object n(int i8, q0 q0Var) {
        int i9 = i8 - 1;
        if (i9 == 0) {
            return (byte) 1;
        }
        if (i9 == 2) {
            d dVar = d.q;
            d dVar2 = d.f7225r;
            return new a2(zza, "\u0001\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0000\u0000\u0001င\u0000\u0002ဇ\u0001\u0003᠌\u0002\u0004ည\u0003\u0005ဈ\u0004\u0006ဇ\u0005\u0007ဇ\u0006\bဇ\u0007\t᠌\b\n᠌\t\u000bဇ\n", new Object[]{"zzd", "zze", "zzf", "zzg", dVar, "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", dVar2, "zzn", dVar2, "zzo"});
        }
        if (i9 == 3) {
            return new o3();
        }
        if (i9 == 4) {
            return new a4(21, zza);
        }
        if (i9 != 5) {
            return null;
        }
        return zza;
    }
}
