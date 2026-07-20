package g4;

import l3.a2;
import l3.q0;
import l3.r;
import l3.r1;
import l3.y0;
import l3.z1;

/* JADX INFO: loaded from: classes.dex */
public final class e extends q0 implements r1 {
    private static final e zza;
    private y0 zzd = z1.f7330d;

    static {
        e eVar = new e();
        zza = eVar;
        q0.h(e.class, eVar);
    }

    public static d o() {
        return (d) zza.d();
    }

    public static void p(e eVar, c cVar) {
        y0 y0Var = eVar.zzd;
        if (!((r) y0Var).f7286a) {
            int size = y0Var.size();
            eVar.zzd = y0Var.b(size == 0 ? 10 : size + size);
        }
        eVar.zzd.add(cVar);
    }

    @Override // l3.q0
    public final Object n(int i8, q0 q0Var) {
        int i9 = i8 - 1;
        if (i9 == 0) {
            return (byte) 1;
        }
        if (i9 == 2) {
            return new a2(zza, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", c.class});
        }
        if (i9 == 3) {
            return new e();
        }
        if (i9 == 4) {
            return new d(zza);
        }
        if (i9 != 5) {
            return null;
        }
        return zza;
    }
}
