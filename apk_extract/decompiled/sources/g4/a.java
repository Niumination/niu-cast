package g4;

import l3.a2;
import l3.q0;
import l3.r1;

/* JADX INFO: loaded from: classes.dex */
public final class a extends q0 implements r1 {
    private static final a zza;
    private int zzd;
    private g zze;
    private j zzf;

    static {
        a aVar = new a();
        zza = aVar;
        q0.h(a.class, aVar);
    }

    public static h o() {
        return (h) zza.d();
    }

    public static /* synthetic */ void p(a aVar, g gVar) {
        aVar.zze = gVar;
        aVar.zzd |= 1;
    }

    public static /* synthetic */ void q(a aVar, j jVar) {
        aVar.zzf = jVar;
        aVar.zzd |= 2;
    }

    @Override // l3.q0
    public final Object n(int i8, q0 q0Var) {
        int i9 = i8 - 1;
        if (i9 == 0) {
            return (byte) 1;
        }
        if (i9 == 2) {
            return new a2(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i9 == 3) {
            return new a();
        }
        if (i9 == 4) {
            return new h(zza);
        }
        if (i9 != 5) {
            return null;
        }
        return zza;
    }
}
