package l3;

/* JADX INFO: loaded from: classes.dex */
public final class h3 extends q0 implements r1 {
    private static final h3 zza;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh = 2;

    static {
        h3 h3Var = new h3();
        zza = h3Var;
        q0.h(h3.class, h3Var);
    }

    @Override // l3.q0
    public final Object n(int i8, q0 q0Var) {
        int i9 = i8 - 1;
        if (i9 == 0) {
            return (byte) 1;
        }
        if (i9 == 2) {
            return new a2(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002င\u0001\u0003င\u0002\u0004င\u0003", new Object[]{"zzd", "zze", d.f7216g, "zzf", "zzg", "zzh"});
        }
        if (i9 == 3) {
            return new h3();
        }
        if (i9 == 4) {
            return new a4(15, zza);
        }
        if (i9 != 5) {
            return null;
        }
        return zza;
    }
}
