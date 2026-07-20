package l3;

/* JADX INFO: loaded from: classes.dex */
public final class c4 extends q0 implements r1 {
    private static final c4 zza;
    private int zzd;
    private y0 zze = z1.f7330d;
    private String zzf = "";

    static {
        c4 c4Var = new c4();
        zza = c4Var;
        q0.h(c4.class, c4Var);
    }

    @Override // l3.q0
    public final Object n(int i8, q0 q0Var) {
        int i9 = i8 - 1;
        if (i9 == 0) {
            return (byte) 1;
        }
        if (i9 == 2) {
            return new a2(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001a\u0002ဈ\u0000", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i9 == 3) {
            return new c4();
        }
        if (i9 == 4) {
            return new x3(zza);
        }
        if (i9 != 5) {
            return null;
        }
        return zza;
    }
}
