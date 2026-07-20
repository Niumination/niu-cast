package l3;

/* JADX INFO: loaded from: classes.dex */
public final class d4 extends q0 implements r1 {
    private static final d4 zza;
    private int zzd;
    private b4 zzj;
    private byte zzk = 2;
    private w0 zze = r0.f7287d;
    private v0 zzf = k0.f7255d;
    private boolean zzg = true;
    private String zzh = "";
    private String zzi = "";

    static {
        d4 d4Var = new d4();
        zza = d4Var;
        q0.h(d4.class, d4Var);
    }

    @Override // l3.q0
    public final Object n(int i8, q0 q0Var) {
        int i9 = i8 - 1;
        if (i9 == 0) {
            return Byte.valueOf(this.zzk);
        }
        if (i9 == 2) {
            return new a2(zza, "\u0001\u0006\u0000\u0001\u0001\u000f\u0006\u0000\u0002\u0001\u0001\u0016\u0002\u0013\u0003ဇ\u0000\u0004ဈ\u0001\u0005ဈ\u0002\u000fᐉ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        }
        if (i9 == 3) {
            return new d4();
        }
        if (i9 == 4) {
            return new x3(zza);
        }
        if (i9 == 5) {
            return zza;
        }
        this.zzk = q0Var == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
