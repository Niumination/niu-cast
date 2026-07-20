package l3;

/* JADX INFO: loaded from: classes.dex */
public final class l3 extends q0 implements r1 {
    private static final l3 zza;
    private int zzd;
    private boolean zze;
    private boolean zzf;

    static {
        l3 l3Var = new l3();
        zza = l3Var;
        q0.h(l3.class, l3Var);
    }

    @Override // l3.q0
    public final Object n(int i8, q0 q0Var) {
        int i9 = i8 - 1;
        if (i9 == 0) {
            return (byte) 1;
        }
        if (i9 == 2) {
            return new a2(zza, "\u0001\u0002\u0000\u0001\u0005\u0006\u0002\u0000\u0000\u0000\u0005ဇ\u0000\u0006ဇ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i9 == 3) {
            return new l3();
        }
        if (i9 == 4) {
            return new a4(19, zza);
        }
        if (i9 != 5) {
            return null;
        }
        return zza;
    }
}
