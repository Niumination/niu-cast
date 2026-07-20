package g4;

import l3.a2;
import l3.b0;
import l3.c3;
import l3.k0;
import l3.q0;
import l3.r1;
import l3.v0;

/* JADX INFO: loaded from: classes.dex */
public final class g extends q0 implements r1 {
    private static final g zza;
    private int zzd;
    private e zzj;
    private c3 zzm;
    private String zze = "";
    private b0 zzf = b0.zzb;
    private int zzg = 10;
    private float zzh = 0.5f;
    private float zzi = 0.05f;
    private v0 zzk = k0.f7255d;
    private int zzl = 1;
    private int zzn = 320;
    private int zzo = 4;
    private int zzp = 2;

    static {
        g gVar = new g();
        zza = gVar;
        q0.h(g.class, gVar);
    }

    public static f o() {
        return (f) zza.d();
    }

    public static /* synthetic */ void p(g gVar, e eVar) {
        gVar.zzj = eVar;
        gVar.zzd |= 32;
    }

    public static /* synthetic */ void q(g gVar, b0 b0Var) {
        b0Var.getClass();
        gVar.zzd |= 2;
        gVar.zzf = b0Var;
    }

    @Override // l3.q0
    public final Object n(int i8, q0 q0Var) {
        int i9 = i8 - 1;
        if (i9 == 0) {
            return (byte) 1;
        }
        if (i9 == 2) {
            return new a2(zza, "\u0001\f\u0000\u0001\u0001\f\f\u0000\u0001\u0000\u0001ဈ\u0000\u0002ည\u0001\u0003ဋ\u0002\u0004ခ\u0003\u0005ခ\u0004\u0006ဉ\u0005\u0007\u0013\bင\u0006\tဉ\u0007\nင\b\u000bင\t\fင\n", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp"});
        }
        if (i9 == 3) {
            return new g();
        }
        if (i9 == 4) {
            return new f(zza);
        }
        if (i9 != 5) {
            return null;
        }
        return zza;
    }
}
