package l3;

/* JADX INFO: loaded from: classes.dex */
public final class e3 extends q0 implements r1 {
    private static final e3 zza;
    private int zzd;
    private int zze = -1;

    static {
        e3 e3Var = new e3();
        zza = e3Var;
        q0.h(e3.class, e3Var);
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
            return new e3();
        }
        if (i9 == 4) {
            return new a4(12, zza);
        }
        if (i9 != 5) {
            return null;
        }
        return zza;
    }
}
