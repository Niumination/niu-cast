package y5;

import l3.a2;
import l3.q0;
import l3.r1;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends q0 implements r1 {
    private static final f zza;
    private int zzd;
    private int zze;
    private int zzf;
    private byte zzg = 2;

    static {
        f fVar = new f();
        zza = fVar;
        q0.h(f.class, fVar);
    }

    public static e q() {
        return (e) zza.d();
    }

    public static /* synthetic */ void r(f fVar, int i8) {
        fVar.zzd |= 1;
        fVar.zze = i8;
    }

    public static /* synthetic */ void s(f fVar, int i8) {
        fVar.zzd |= 2;
        fVar.zzf = i8;
    }

    @Override // l3.q0
    public final Object n(int i8, q0 q0Var) {
        int i9 = i8 - 1;
        if (i9 == 0) {
            return Byte.valueOf(this.zzg);
        }
        if (i9 == 2) {
            return new a2(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001ᔄ\u0000\u0002ᔄ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i9 == 3) {
            return new f();
        }
        if (i9 == 4) {
            return new e(zza);
        }
        if (i9 == 5) {
            return zza;
        }
        this.zzg = q0Var == null ? (byte) 0 : (byte) 1;
        return null;
    }

    public final int o() {
        return this.zze;
    }

    public final int p() {
        return this.zzf;
    }
}
