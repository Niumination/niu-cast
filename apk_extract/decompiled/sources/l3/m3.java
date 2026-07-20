package l3;

/* JADX INFO: loaded from: classes.dex */
public final class m3 extends q0 implements r1 {
    private static final m3 zza;
    private int zzd;
    private boolean zze;
    private int zzf;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private boolean zzg = true;
    private String zzl = "";
    private String zzm = "";

    static {
        m3 m3Var = new m3();
        zza = m3Var;
        q0.h(m3.class, m3Var);
    }

    @Override // l3.q0
    public final Object n(int i8, q0 q0Var) {
        int i9 = i8 - 1;
        if (i9 == 0) {
            return (byte) 1;
        }
        if (i9 == 2) {
            d dVar = d.p;
            d dVar2 = d.f7223n;
            d dVar3 = d.f7224o;
            return new a2(zza, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0000\u0000\u0001ဇ\u0000\u0002᠌\u0001\u0003ဇ\u0002\u0004᠌\u0003\u0005᠌\u0004\u0006᠌\u0005\u0007᠌\u0006\bဈ\u0007\tဈ\b", new Object[]{"zzd", "zze", "zzf", dVar, "zzg", "zzh", dVar2, "zzi", dVar3, "zzj", dVar3, "zzk", dVar3, "zzl", "zzm"});
        }
        if (i9 == 3) {
            return new m3();
        }
        if (i9 == 4) {
            return new a4(20, zza);
        }
        if (i9 != 5) {
            return null;
        }
        return zza;
    }
}
