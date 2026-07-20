package l3;

/* JADX INFO: loaded from: classes.dex */
public final class e extends q0 implements r1 {
    public static final p0 zza;
    private static final x0 zzd = new c();
    private static final e zze;
    private int zzf;
    private g4 zzl;
    private b4 zzm;
    private byte zzn = 2;
    private String zzg = "";
    private String zzh = "";
    private w0 zzi = r0.f7287d;
    private String zzj = "";
    private String zzk = "";

    static {
        e eVar = new e();
        zze = eVar;
        q0.h(e.class, eVar);
        zza = new p0(b4.p(), eVar, eVar, new o0(308676116, a3.zzk));
    }

    @Override // l3.q0
    public final Object n(int i8, q0 q0Var) {
        int i9 = i8 - 1;
        if (i9 == 0) {
            return Byte.valueOf(this.zzn);
        }
        if (i9 == 2) {
            return new a2(zze, "\u0001\u0007\u0000\u0001\u0001Ǵ\u0007\u0000\u0001\u0002\u0001ᔈ\u0000\u0002ဈ\u0001\u0003ࠞ\u0005ဈ\u0002\u0006ဈ\u0003\u000fᐉ\u0005Ǵဉ\u0004", new Object[]{"zzf", "zzg", "zzh", "zzi", d.f7213b, "zzj", "zzk", "zzm", "zzl"});
        }
        if (i9 == 3) {
            return new e();
        }
        if (i9 == 4) {
            return new a4(3, zze);
        }
        if (i9 == 5) {
            return zze;
        }
        this.zzn = q0Var == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
