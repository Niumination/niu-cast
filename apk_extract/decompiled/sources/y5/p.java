package y5;

import l3.a2;
import l3.q0;
import l3.r1;
import l3.y0;
import l3.z1;

/* JADX INFO: loaded from: classes2.dex */
public final class p extends q0 implements r1 {
    private static final p zza;
    private int zzd;
    private l3.o zze;
    private y0 zzh;
    private y0 zzi;
    private y0 zzj;
    private y0 zzk;
    private String zzl;
    private byte zzm = 2;
    private String zzf = "";
    private String zzg = "";

    static {
        p pVar = new p();
        zza = pVar;
        q0.h(p.class, pVar);
    }

    public p() {
        z1 z1Var = z1.f7330d;
        this.zzh = z1Var;
        this.zzi = z1Var;
        this.zzj = z1Var;
        this.zzk = z1Var;
        this.zzl = "";
    }

    public static p p() {
        return zza;
    }

    @Override // l3.q0
    public final Object n(int i8, q0 q0Var) {
        int i9 = i8 - 1;
        if (i9 == 0) {
            return Byte.valueOf(this.zzm);
        }
        if (i9 == 2) {
            return new a2(zza, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0004\u0001\u0001ဉ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004\u001b\u0005\u001b\u0006\u001a\u0007Л\bဈ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", l3.p.class, "zzi", r.class, "zzj", "zzk", l3.n.class, "zzl"});
        }
        if (i9 == 3) {
            return new p();
        }
        if (i9 == 4) {
            return new c(zza);
        }
        if (i9 == 5) {
            return zza;
        }
        this.zzm = q0Var == null ? (byte) 0 : (byte) 1;
        return null;
    }

    public final l3.o o() {
        l3.o oVar = this.zze;
        return oVar == null ? l3.o.o() : oVar;
    }

    public final String q() {
        return this.zzf;
    }

    public final String r() {
        return this.zzg;
    }

    public final y0 s() {
        return this.zzk;
    }

    public final y0 t() {
        return this.zzi;
    }

    public final y0 u() {
        return this.zzh;
    }

    public final y0 v() {
        return this.zzj;
    }
}
