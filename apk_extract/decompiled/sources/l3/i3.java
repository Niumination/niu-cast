package l3;

/* JADX INFO: loaded from: classes.dex */
public final class i3 extends q0 implements r1 {
    private static final i3 zza;
    private int zzd;
    private int zze;
    private int zzf;
    private y0 zzg = z1.f7330d;
    private int zzh;

    static {
        i3 i3Var = new i3();
        zza = i3Var;
        q0.h(i3.class, i3Var);
    }

    @Override // l3.q0
    public final Object n(int i8, q0 q0Var) {
        int i9 = i8 - 1;
        if (i9 == 0) {
            return (byte) 1;
        }
        if (i9 == 2) {
            return new a2(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001᠌\u0000\u0002င\u0001\u0003\u001a\u0004င\u0002", new Object[]{"zzd", "zze", d.f7218i, "zzf", "zzg", "zzh"});
        }
        if (i9 == 3) {
            return new i3();
        }
        if (i9 == 4) {
            return new a4(16, zza);
        }
        if (i9 != 5) {
            return null;
        }
        return zza;
    }
}
