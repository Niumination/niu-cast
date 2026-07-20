package l3;

/* JADX INFO: loaded from: classes.dex */
public final class t3 extends q0 implements r1 {
    private static final t3 zza;
    private int zzd;
    private String zze = "";
    private long zzf;
    private long zzg;
    private long zzh;

    static {
        t3 t3Var = new t3();
        zza = t3Var;
        q0.h(t3.class, t3Var);
    }

    @Override // l3.q0
    public final Object n(int i8, q0 q0Var) {
        int i9 = i8 - 1;
        if (i9 == 0) {
            return (byte) 1;
        }
        if (i9 == 2) {
            return new a2(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဂ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
        }
        if (i9 == 3) {
            return new t3();
        }
        if (i9 == 4) {
            return new a4(26, zza);
        }
        if (i9 != 5) {
            return null;
        }
        return zza;
    }
}
