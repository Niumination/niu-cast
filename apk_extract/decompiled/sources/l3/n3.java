package l3;

/* JADX INFO: loaded from: classes.dex */
public final class n3 extends q0 implements r1 {
    private static final n3 zza;
    private int zzd;
    private y0 zzf;
    private int zzg;
    private f4 zzh;
    private d4 zzi;
    private b4 zzj;
    private int zzk;
    private y0 zzl;
    private byte zzm = 2;
    private int zze = 17;

    static {
        n3 n3Var = new n3();
        zza = n3Var;
        q0.h(n3.class, n3Var);
    }

    public n3() {
        z1 z1Var = z1.f7330d;
        this.zzf = z1Var;
        this.zzl = z1Var;
    }

    @Override // l3.q0
    public final Object n(int i8, q0 q0Var) {
        int i9 = i8 - 1;
        if (i9 == 0) {
            return Byte.valueOf(this.zzm);
        }
        if (i9 == 2) {
            return new a2(zza, "\u0001\b\u0000\u0001\u0001\u000f\b\u0000\u0002\u0004\u0001᠌\u0000\u0003Л\u0004င\u0001\u0005ᐉ\u0002\u0006ᐉ\u0003\u0007င\u0005\b\u001b\u000fᐉ\u0004", new Object[]{"zzd", "zze", d.e, "zzf", e.class, "zzg", "zzh", "zzi", "zzk", "zzl", f.class, "zzj"});
        }
        if (i9 == 3) {
            return new n3();
        }
        if (i9 == 4) {
            return new a4(9, zza);
        }
        if (i9 == 5) {
            return zza;
        }
        this.zzm = q0Var == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
