package l3;

/* JADX INFO: loaded from: classes.dex */
public final class v3 extends q0 implements r1 {
    private static final v3 zza;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private String zzg = "";
    private int zzh;
    private int zzi;
    private l3 zzj;
    private boolean zzk;
    private int zzl;
    private boolean zzm;
    private boolean zzn;
    private boolean zzo;
    private long zzp;

    static {
        v3 v3Var = new v3();
        zza = v3Var;
        q0.h(v3.class, v3Var);
    }

    @Override // l3.q0
    public final Object n(int i8, q0 q0Var) {
        int i9 = i8 - 1;
        if (i9 == 0) {
            return (byte) 1;
        }
        if (i9 == 2) {
            return new a2(zza, "\u0001\f\u0000\u0001\u0001\f\f\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004᠌\u0003\u0005င\u0004\u0006ဉ\u0005\u0007ဇ\u0006\b᠌\u0007\tဇ\b\nဇ\t\u000bဇ\n\fဂ\u000b", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", d.f7227t, "zzi", "zzj", "zzk", "zzl", d.u, "zzm", "zzn", "zzo", "zzp"});
        }
        if (i9 == 3) {
            return new v3();
        }
        if (i9 == 4) {
            return new a4(28, zza);
        }
        if (i9 != 5) {
            return null;
        }
        return zza;
    }
}
