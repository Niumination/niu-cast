package l3;

/* JADX INFO: loaded from: classes.dex */
public final class s3 extends q0 implements r1 {
    private static final s3 zza;
    private int zzd;
    private y0 zze = z1.f7330d;
    private t3 zzf;
    private d3 zzg;

    static {
        s3 s3Var = new s3();
        zza = s3Var;
        q0.h(s3.class, s3Var);
    }

    @Override // l3.q0
    public final Object n(int i8, q0 q0Var) {
        int i9 = i8 - 1;
        if (i9 == 0) {
            return (byte) 1;
        }
        if (i9 == 2) {
            return new a2(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000\u0003ဉ\u0001", new Object[]{"zzd", "zze", y3.class, "zzf", "zzg"});
        }
        if (i9 == 3) {
            return new s3();
        }
        if (i9 == 4) {
            return new a4(25, zza);
        }
        if (i9 != 5) {
            return null;
        }
        return zza;
    }
}
