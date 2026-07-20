package l3;

/* JADX INFO: loaded from: classes.dex */
public final class a extends q0 implements r1 {
    private static final a zza;
    private int zzd;
    private b zze;
    private boolean zzf;

    static {
        a aVar = new a();
        zza = aVar;
        q0.h(a.class, aVar);
    }

    @Override // l3.q0
    public final Object n(int i8, q0 q0Var) {
        int i9 = i8 - 1;
        if (i9 == 0) {
            return (byte) 1;
        }
        if (i9 == 2) {
            return new a2(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဇ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i9 == 3) {
            return new a();
        }
        if (i9 == 4) {
            return new a4(1, zza);
        }
        if (i9 != 5) {
            return null;
        }
        return zza;
    }
}
