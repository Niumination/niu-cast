package l3;

/* JADX INFO: loaded from: classes.dex */
public final class p extends q0 implements r1 {
    private static final p zza;
    private int zzd;
    private int zze;
    private String zzf = "";

    static {
        p pVar = new p();
        zza = pVar;
        q0.h(p.class, pVar);
    }

    public static p o() {
        return zza;
    }

    @Override // l3.q0
    public final Object n(int i8, q0 q0Var) {
        int i9 = i8 - 1;
        if (i9 == 0) {
            return (byte) 1;
        }
        if (i9 == 2) {
            return new a2(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", d.f7215d, "zzf"});
        }
        if (i9 == 3) {
            return new p();
        }
        if (i9 == 4) {
            return new a4(7, zza);
        }
        if (i9 != 5) {
            return null;
        }
        return zza;
    }

    public final String p() {
        return this.zzf;
    }

    public final int q() {
        int i8;
        int i9 = this.zze;
        if (i9 != 0) {
            i8 = 2;
            if (i9 != 1) {
                if (i9 != 2) {
                    i8 = 4;
                    if (i9 != 3) {
                        i8 = i9 != 4 ? 0 : 5;
                    }
                } else {
                    i8 = 3;
                }
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
