package l3;

/* JADX INFO: loaded from: classes.dex */
public final class o extends q0 implements r1 {
    private static final o zza;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";
    private String zzk = "";

    static {
        o oVar = new o();
        zza = oVar;
        q0.h(o.class, oVar);
    }

    public static o o() {
        return zza;
    }

    @Override // l3.q0
    public final Object n(int i8, q0 q0Var) {
        int i9 = i8 - 1;
        if (i9 == 0) {
            return (byte) 1;
        }
        if (i9 == 2) {
            return new a2(zza, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဈ\u0005\u0007ဈ\u0006", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        }
        if (i9 == 3) {
            return new o();
        }
        if (i9 == 4) {
            return new a4(6, zza);
        }
        if (i9 != 5) {
            return null;
        }
        return zza;
    }

    public final String p() {
        return this.zzh;
    }

    public final String q() {
        return this.zze;
    }

    public final String r() {
        return this.zzj;
    }

    public final String s() {
        return this.zzi;
    }

    public final String t() {
        return this.zzg;
    }

    public final String u() {
        return this.zzf;
    }

    public final String v() {
        return this.zzk;
    }
}
