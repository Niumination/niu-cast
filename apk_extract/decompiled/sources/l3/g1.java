package l3;

/* JADX INFO: loaded from: classes.dex */
public final class g1 extends q0 implements r1 {
    public static final p0 zza;
    private static final g1 zzd;
    private int zze;
    private y0 zzg;
    private y0 zzh;
    private y0 zzi;
    private b4 zzj;
    private g1 zzk;
    private g4 zzl;
    private byte zzm = 2;
    private String zzf = "";

    static {
        g1 g1Var = new g1();
        zzd = g1Var;
        q0.h(g1.class, g1Var);
        zza = new p0(b4.p(), g1Var, g1Var, new o0(12208774, a3.zzk));
    }

    public g1() {
        z1 z1Var = z1.f7330d;
        this.zzg = z1Var;
        this.zzh = z1Var;
        this.zzi = z1Var;
    }

    @Override // l3.q0
    public final Object n(int i8, q0 q0Var) {
        int i9 = i8 - 1;
        if (i9 == 0) {
            return Byte.valueOf(this.zzm);
        }
        if (i9 == 2) {
            return new a2(zzd, "\u0001\u0007\u0000\u0001\u0002Ǵ\u0007\u0000\u0003\u0004\u0002Л\u0005Л\u0006\u001b\bᐉ\u0001\nဈ\u0000\u000bᐉ\u0002Ǵဉ\u0003", new Object[]{"zze", "zzg", n3.class, "zzi", n3.class, "zzh", c4.class, "zzj", "zzf", "zzk", "zzl"});
        }
        if (i9 == 3) {
            return new g1();
        }
        if (i9 == 4) {
            return new a4(8, zzd);
        }
        if (i9 == 5) {
            return zzd;
        }
        this.zzm = q0Var == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
