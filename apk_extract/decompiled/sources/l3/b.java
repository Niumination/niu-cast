package l3;

/* JADX INFO: loaded from: classes.dex */
public final class b extends q0 implements r1 {
    private static final b zza;
    private int zzd;
    private int zze = 4369;
    private String zzf = "";

    static {
        b bVar = new b();
        zza = bVar;
        q0.h(b.class, bVar);
    }

    @Override // l3.q0
    public final Object n(int i8, q0 q0Var) {
        int i9 = i8 - 1;
        if (i9 == 0) {
            return (byte) 1;
        }
        if (i9 == 2) {
            return new a2(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", d.f7229w, "zzf"});
        }
        if (i9 == 3) {
            return new b();
        }
        if (i9 == 4) {
            return new a4(2, zza);
        }
        if (i9 != 5) {
            return null;
        }
        return zza;
    }
}
