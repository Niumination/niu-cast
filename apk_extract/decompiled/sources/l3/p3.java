package l3;

/* JADX INFO: loaded from: classes.dex */
public final class p3 extends q0 implements r1 {
    private static final p3 zza;
    private int zzd;
    private int zze;
    private int zzf = 100;
    private int zzg;

    static {
        p3 p3Var = new p3();
        zza = p3Var;
        q0.h(p3.class, p3Var);
    }

    @Override // l3.q0
    public final Object n(int i8, q0 q0Var) {
        int i9 = i8 - 1;
        if (i9 == 0) {
            return (byte) 1;
        }
        if (i9 == 2) {
            return new a2(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002င\u0001\u0003င\u0002", new Object[]{"zzd", "zze", d.f7226s, "zzf", "zzg"});
        }
        if (i9 == 3) {
            return new p3();
        }
        if (i9 == 4) {
            return new a4(22, zza);
        }
        if (i9 != 5) {
            return null;
        }
        return zza;
    }
}
