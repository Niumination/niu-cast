package l3;

/* JADX INFO: loaded from: classes.dex */
public final class u3 extends q0 implements r1 {
    private static final u3 zza;
    private int zzd;
    private String zze = "";
    private String zzf = "";

    static {
        u3 u3Var = new u3();
        zza = u3Var;
        q0.h(u3.class, u3Var);
    }

    @Override // l3.q0
    public final Object n(int i8, q0 q0Var) {
        int i9 = i8 - 1;
        if (i9 == 0) {
            return (byte) 1;
        }
        if (i9 == 2) {
            return new a2(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i9 == 3) {
            return new u3();
        }
        if (i9 == 4) {
            return new a4(27, zza);
        }
        if (i9 != 5) {
            return null;
        }
        return zza;
    }
}
