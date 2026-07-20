package g4;

import l3.a2;
import l3.b0;
import l3.q0;
import l3.r1;

/* JADX INFO: loaded from: classes.dex */
public final class j extends q0 implements r1 {
    private static final j zza;
    private int zzd;
    private String zze = "";
    private b0 zzf;
    private String zzg;
    private b0 zzh;
    private float zzi;
    private float zzj;
    private float zzk;
    private float zzl;
    private int zzm;

    static {
        j jVar = new j();
        zza = jVar;
        q0.h(j.class, jVar);
    }

    public j() {
        b0 b0Var = b0.zzb;
        this.zzf = b0Var;
        this.zzg = "";
        this.zzh = b0Var;
        this.zzi = 0.25f;
        this.zzj = 0.25f;
        this.zzk = 0.5f;
        this.zzl = 0.85f;
        this.zzm = 1;
    }

    public static i o() {
        return (i) zza.d();
    }

    public static /* synthetic */ void p(j jVar, b0 b0Var) {
        b0Var.getClass();
        jVar.zzd |= 2;
        jVar.zzf = b0Var;
    }

    public static /* synthetic */ void q(j jVar, b0 b0Var) {
        b0Var.getClass();
        jVar.zzd |= 8;
        jVar.zzh = b0Var;
    }

    @Override // l3.q0
    public final Object n(int i8, q0 q0Var) {
        int i9 = i8 - 1;
        if (i9 == 0) {
            return (byte) 1;
        }
        if (i9 == 2) {
            return new a2(zza, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0000\u0000\u0001ဈ\u0000\u0002ည\u0001\u0003ဈ\u0002\u0004ည\u0003\u0005ခ\u0004\u0006ခ\u0005\u0007ခ\u0006\bခ\u0007\tင\b", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm"});
        }
        if (i9 == 3) {
            return new j();
        }
        if (i9 == 4) {
            return new i(zza);
        }
        if (i9 != 5) {
            return null;
        }
        return zza;
    }
}
