package y5;

import l3.a2;
import l3.q0;
import l3.r1;

/* JADX INFO: loaded from: classes2.dex */
public final class r extends q0 implements r1 {
    private static final r zza;
    private int zzd;
    private int zze;
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";

    static {
        r rVar = new r();
        zza = rVar;
        q0.h(r.class, rVar);
    }

    public static r o() {
        return zza;
    }

    @Override // l3.q0
    public final Object n(int i8, q0 q0Var) {
        int i9 = i8 - 1;
        if (i9 == 0) {
            return (byte) 1;
        }
        if (i9 == 2) {
            return new a2(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003", new Object[]{"zzd", "zze", h.f, "zzf", "zzg", "zzh"});
        }
        if (i9 == 3) {
            return new r();
        }
        if (i9 == 4) {
            return new c(zza);
        }
        if (i9 != 5) {
            return null;
        }
        return zza;
    }

    public final String p() {
        return this.zzf;
    }

    public final String q() {
        return this.zzh;
    }

    public final String r() {
        return this.zzg;
    }

    public final int s() {
        int i8;
        int i9 = this.zze;
        if (i9 != 0) {
            i8 = 2;
            if (i9 != 1) {
                i8 = i9 != 2 ? 0 : 3;
            }
        } else {
            i8 = 1;
        }
        if (i8 == 0) {
            return 1;
        }
        return i8;
    }
}
