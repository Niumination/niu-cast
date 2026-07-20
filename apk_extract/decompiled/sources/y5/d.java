package y5;

import l3.a2;
import l3.q0;
import l3.r1;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends q0 implements r1 {
    private static final d zza;
    private int zzd;
    private double zze;
    private double zzf;
    private byte zzg = 2;

    static {
        d dVar = new d();
        zza = dVar;
        q0.h(d.class, dVar);
    }

    public static d q() {
        return zza;
    }

    @Override // l3.q0
    public final Object n(int i8, q0 q0Var) {
        int i9 = i8 - 1;
        if (i9 == 0) {
            return Byte.valueOf(this.zzg);
        }
        if (i9 == 2) {
            return new a2(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001ᔀ\u0000\u0002ᔀ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i9 == 3) {
            return new d();
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

    public final double o() {
        return this.zze;
    }

    public final double p() {
        return this.zzf;
    }
}
