package y5;

import l3.a2;
import l3.q0;
import l3.r1;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends q0 implements r1 {
    private static final g zza;
    private int zzd;
    private byte zzg = 2;
    private String zze = "";
    private String zzf = "";

    static {
        g gVar = new g();
        zza = gVar;
        q0.h(g.class, gVar);
    }

    public static g o() {
        return zza;
    }

    @Override // l3.q0
    public final Object n(int i8, q0 q0Var) {
        int i9 = i8 - 1;
        if (i9 == 0) {
            return Byte.valueOf(this.zzg);
        }
        if (i9 == 2) {
            return new a2(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001ဈ\u0000\u0002ᔈ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i9 == 3) {
            return new g();
        }
        if (i9 == 4) {
            return new c(zza);
        }
        if (i9 == 5) {
            return zza;
        }
        this.zzg = q0Var == null ? (byte) 0 : (byte) 1;
        return null;
    }

    public final String p() {
        return this.zze;
    }

    public final String q() {
        return this.zzf;
    }
}
