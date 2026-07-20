package l3;

/* JADX INFO: loaded from: classes.dex */
public final class k3 extends q0 implements r1 {
    private static final k3 zza;
    private int zzd;
    private int zze;
    private i3 zzh;
    private int zzj;
    private int zzk;
    private y0 zzf = z1.f7330d;
    private int zzg = -1;
    private String zzi = "";
    private w0 zzl = r0.f7287d;
    private String zzm = "";

    static {
        k3 k3Var = new k3();
        zza = k3Var;
        q0.h(k3.class, k3Var);
    }

    @Override // l3.q0
    public final Object n(int i8, q0 q0Var) {
        int i9 = i8 - 1;
        if (i9 == 0) {
            return (byte) 1;
        }
        if (i9 == 2) {
            return new a2(zza, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0002\u0000\u0001᠌\u0000\u0002\u001b\u0003င\u0001\u0004ဉ\u0002\u0005ဈ\u0003\u0006᠌\u0004\u0007᠌\u0005\b'\tဈ\u0006", new Object[]{"zzd", "zze", d.f7219j, "zzf", j3.class, "zzg", "zzh", "zzi", "zzj", d.f7220k, "zzk", d.f7221l, "zzl", "zzm"});
        }
        if (i9 == 3) {
            return new k3();
        }
        if (i9 == 4) {
            return new a4(18, zza);
        }
        if (i9 != 5) {
            return null;
        }
        return zza;
    }
}
