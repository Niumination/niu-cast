package l3;

/* JADX INFO: loaded from: classes.dex */
public final class q3 extends q0 implements r1 {
    private static final q3 zza;
    private int zzd;
    private int zze;

    static {
        q3 q3Var = new q3();
        zza = q3Var;
        q0.h(q3.class, q3Var);
    }

    @Override // l3.q0
    public final Object n(int i8, q0 q0Var) {
        int i9 = i8 - 1;
        if (i9 == 0) {
            return (byte) 1;
        }
        if (i9 == 2) {
            return new a2(zza, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001င\u0000", new Object[]{"zzd", "zze"});
        }
        if (i9 == 3) {
            return new q3();
        }
        if (i9 == 4) {
            return new a4(23, zza);
        }
        if (i9 != 5) {
            return null;
        }
        return zza;
    }
}
