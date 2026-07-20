package y5;

import l3.a2;
import l3.q0;
import l3.r1;

/* JADX INFO: loaded from: classes2.dex */
public final class n extends q0 implements r1 {
    private static final n zza;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private boolean zzk;

    static {
        n nVar = new n();
        zza = nVar;
        q0.h(n.class, nVar);
    }

    public static n u() {
        return zza;
    }

    @Override // l3.q0
    public final Object n(int i8, q0 q0Var) {
        int i9 = i8 - 1;
        if (i9 == 0) {
            return (byte) 1;
        }
        if (i9 == 2) {
            return new a2(zza, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002\u0004င\u0003\u0005င\u0004\u0006င\u0005\u0007ဇ\u0006", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        }
        if (i9 == 3) {
            return new n();
        }
        if (i9 == 4) {
            return new c(zza);
        }
        if (i9 != 5) {
            return null;
        }
        return zza;
    }

    public final int o() {
        return this.zzg;
    }

    public final int p() {
        return this.zzh;
    }

    public final int q() {
        return this.zzi;
    }

    public final int r() {
        return this.zzf;
    }

    public final int s() {
        return this.zzj;
    }

    public final int t() {
        return this.zze;
    }

    public final boolean v() {
        return this.zzk;
    }
}
