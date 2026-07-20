package y5;

import l3.a2;
import l3.q0;
import l3.r1;
import l3.y0;
import l3.z1;

/* JADX INFO: loaded from: classes2.dex */
public final class m extends q0 implements r1 {
    private static final m zza;
    private int zzd;
    private String zze = "";
    private y0 zzf = z1.f7330d;

    static {
        m mVar = new m();
        zza = mVar;
        q0.h(m.class, mVar);
    }

    @Override // l3.q0
    public final Object n(int i8, q0 q0Var) {
        int i9 = i8 - 1;
        if (i9 == 0) {
            return (byte) 1;
        }
        if (i9 == 2) {
            return new a2(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b", new Object[]{"zzd", "zze", "zzf", b.class});
        }
        if (i9 == 3) {
            return new m();
        }
        if (i9 == 4) {
            return new c(zza);
        }
        if (i9 != 5) {
            return null;
        }
        return zza;
    }
}
