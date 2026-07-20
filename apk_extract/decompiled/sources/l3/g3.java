package l3;

/* JADX INFO: loaded from: classes.dex */
public final class g3 extends q0 implements r1 {
    private static final g3 zza;
    private int zzd;
    private String zze = "";
    private int zzf = 1;
    private boolean zzg;
    private int zzh;

    static {
        g3 g3Var = new g3();
        zza = g3Var;
        q0.h(g3.class, g3Var);
    }

    @Override // l3.q0
    public final Object n(int i8, q0 q0Var) {
        int i9 = i8 - 1;
        if (i9 == 0) {
            return (byte) 1;
        }
        if (i9 == 2) {
            return new a2(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002᠌\u0001\u0003ဇ\u0002\u0004င\u0003", new Object[]{"zzd", "zze", "zzf", d.f, "zzg", "zzh"});
        }
        if (i9 == 3) {
            return new g3();
        }
        if (i9 == 4) {
            return new a4(14, zza);
        }
        if (i9 != 5) {
            return null;
        }
        return zza;
    }
}
