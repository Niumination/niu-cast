package l3;

/* JADX INFO: loaded from: classes.dex */
public final class z3 extends q0 implements r1 {
    private static final z3 zza;
    private int zzd;
    private int zze;
    private int zzf;

    static {
        z3 z3Var = new z3();
        zza = z3Var;
        q0.h(z3.class, z3Var);
    }

    @Override // l3.q0
    public final Object n(int i8, q0 q0Var) {
        int i9 = i8 - 1;
        if (i9 == 0) {
            return (byte) 1;
        }
        if (i9 == 2) {
            return new a2(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002᠌\u0001", new Object[]{"zzd", "zze", "zzf", d.f7228v});
        }
        if (i9 == 3) {
            return new z3();
        }
        if (i9 == 4) {
            return new x3(zza);
        }
        if (i9 != 5) {
            return null;
        }
        return zza;
    }
}
