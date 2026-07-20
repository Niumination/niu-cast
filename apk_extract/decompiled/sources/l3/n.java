package l3;

/* JADX INFO: loaded from: classes.dex */
public final class n extends q0 implements r1 {
    private static final n zza;
    private int zzd;
    private int zze;
    private g1 zzg;
    private byte zzh = 2;
    private y0 zzf = z1.f7330d;

    static {
        n nVar = new n();
        zza = nVar;
        q0.h(n.class, nVar);
    }

    @Override // l3.q0
    public final Object n(int i8, q0 q0Var) {
        int i9 = i8 - 1;
        if (i9 == 0) {
            return Byte.valueOf(this.zzh);
        }
        if (i9 == 2) {
            return new a2(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0001\u0001᠌\u0000\u0002\u001a\u0003ᐉ\u0001", new Object[]{"zzd", "zze", d.f7214c, "zzf", "zzg"});
        }
        if (i9 == 3) {
            return new n();
        }
        if (i9 == 4) {
            return new a4(5, zza);
        }
        if (i9 == 5) {
            return zza;
        }
        this.zzh = q0Var == null ? (byte) 0 : (byte) 1;
        return null;
    }

    public final y0 o() {
        return this.zzf;
    }

    public final int p() {
        int i8;
        int i9 = this.zze;
        if (i9 != 0) {
            i8 = 2;
            if (i9 != 1) {
                i8 = i9 != 2 ? 0 : 3;
            }
        } else {
            i8 = 1;
        }
        if (i8 == 0) {
            return 1;
        }
        return i8;
    }
}
