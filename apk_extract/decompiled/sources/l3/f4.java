package l3;

/* JADX INFO: loaded from: classes.dex */
public final class f4 extends q0 implements r1 {
    public static final p0 zza;
    private static final f4 zzd;
    private int zze;
    private long zzf;
    private long zzg;
    private b4 zzh;
    private byte zzi = 2;

    static {
        f4 f4Var = new f4();
        zzd = f4Var;
        q0.h(f4.class, f4Var);
        zza = new p0(b4.p(), f4Var, f4Var, new o0(13258261, a3.zzk));
    }

    @Override // l3.q0
    public final Object n(int i8, q0 q0Var) {
        int i9 = i8 - 1;
        if (i9 == 0) {
            return Byte.valueOf(this.zzi);
        }
        if (i9 == 2) {
            return new a2(zzd, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0003\u0001ᔅ\u0000\u0002ᔅ\u0001\u0003ᐉ\u0002", new Object[]{"zze", "zzf", "zzg", "zzh"});
        }
        if (i9 == 3) {
            return new f4();
        }
        if (i9 == 4) {
            return new x3(zzd);
        }
        if (i9 == 5) {
            return zzd;
        }
        this.zzi = q0Var == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
