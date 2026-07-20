package y5;

import l3.a2;
import l3.q0;
import l3.r1;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends q0 implements r1 {
    private static final b zza;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";
    private String zzk = "";
    private String zzl = "";
    private String zzm = "";

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
            return new a2(zza, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဈ\u0005\u0007ဈ\u0006\bဈ\u0007\tဈ\b", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm"});
        }
        if (i9 == 3) {
            return new b();
        }
        if (i9 == 4) {
            return new c(zza);
        }
        if (i9 != 5) {
            return null;
        }
        return zza;
    }
}
