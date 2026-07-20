package l3;

/* JADX INFO: loaded from: classes.dex */
public final class g4 extends q0 implements r1 {
    private static final g4 zza;
    private int zzd;
    private a zze;

    static {
        g4 g4Var = new g4();
        zza = g4Var;
        q0.h(g4.class, g4Var);
    }

    @Override // l3.q0
    public final Object n(int i8, q0 q0Var) {
        int i9 = i8 - 1;
        if (i9 == 0) {
            return (byte) 1;
        }
        if (i9 == 2) {
            return new a2(zza, "\u0001\u0001\u0000\u0001\u000f\u000f\u0001\u0000\u0000\u0000\u000fဉ\u0000", new Object[]{"zzd", "zze"});
        }
        if (i9 == 3) {
            return new g4();
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
