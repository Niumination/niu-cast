package l3;

/* JADX INFO: loaded from: classes.dex */
public final class c3 extends q0 implements r1 {
    private static final c3 zza;
    private int zzd;
    private int zze;
    private y3 zzf;
    private r3 zzg;
    private s3 zzh;

    static {
        c3 c3Var = new c3();
        zza = c3Var;
        q0.h(c3.class, c3Var);
    }

    @Override // l3.q0
    public final Object n(int i8, q0 q0Var) {
        int i9 = i8 - 1;
        if (i9 == 0) {
            return (byte) 1;
        }
        if (i9 == 2) {
            return new a2(zza, "\u0001\u0004\u0000\u0001\u0001\u0005\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0005ဉ\u0003", new Object[]{"zzd", "zze", d.f7222m, "zzf", "zzg", "zzh"});
        }
        if (i9 == 3) {
            return new c3();
        }
        if (i9 == 4) {
            return new a4(10, zza);
        }
        if (i9 != 5) {
            return null;
        }
        return zza;
    }
}
