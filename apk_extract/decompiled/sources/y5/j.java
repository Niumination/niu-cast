package y5;

import l3.a2;
import l3.q0;
import l3.r1;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends q0 implements r1 {
    private static final j zza;
    private int zzd;
    private int zzf;
    private boolean zzh;
    private byte zzi = 2;
    private String zze = "";
    private String zzg = "";

    static {
        j jVar = new j();
        zza = jVar;
        q0.h(j.class, jVar);
    }

    public static j o() {
        return zza;
    }

    @Override // l3.q0
    public final Object n(int i8, q0 q0Var) {
        int i9 = i8 - 1;
        if (i9 == 0) {
            return Byte.valueOf(this.zzi);
        }
        if (i9 == 2) {
            return new a2(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0001\u0001ᔈ\u0000\u0002᠌\u0001\u0003ဈ\u0002\u0004ဇ\u0003", new Object[]{"zzd", "zze", "zzf", h.f11076c, "zzg", "zzh"});
        }
        if (i9 == 3) {
            return new j();
        }
        if (i9 == 4) {
            return new c(zza);
        }
        if (i9 == 5) {
            return zza;
        }
        this.zzi = q0Var == null ? (byte) 0 : (byte) 1;
        return null;
    }

    public final String p() {
        return this.zzg;
    }

    public final String q() {
        return this.zze;
    }

    public final int r() {
        int i8;
        int i9 = this.zzf;
        if (i9 != 0) {
            i8 = 2;
            if (i9 != 1) {
                if (i9 != 2) {
                    i8 = i9 != 3 ? 0 : 4;
                } else {
                    i8 = 3;
                }
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
