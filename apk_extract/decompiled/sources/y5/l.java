package y5;

import l3.a2;
import l3.b0;
import l3.q0;
import l3.r0;
import l3.r1;
import l3.w0;
import l3.y0;
import l3.z1;
import m3.c0;

/* JADX INFO: loaded from: classes2.dex */
public final class l extends q0 implements r1 {
    private static final l zza;
    private int zzd;
    private int zze;
    private b0 zzf;
    private String zzg;
    private int zzh;
    private p zzi;
    private r zzj;
    private l3.p zzk;
    private g zzl;
    private j zzm;
    private i zzn;
    private d zzo;
    private o zzp;
    private q zzq;
    private m zzr;
    private y0 zzs;
    private w0 zzt;
    private String zzu;
    private y0 zzv;
    private boolean zzw;
    private double zzx;
    private b0 zzy;
    private byte zzz = 2;

    static {
        l lVar = new l();
        zza = lVar;
        q0.h(l.class, lVar);
    }

    public l() {
        b0 b0Var = b0.zzb;
        this.zzf = b0Var;
        this.zzg = "";
        z1 z1Var = z1.f7330d;
        this.zzs = z1Var;
        this.zzt = r0.f7287d;
        this.zzu = "";
        this.zzv = z1Var;
        this.zzw = true;
        this.zzy = b0Var;
    }

    public static void C(l lVar, int i8, f fVar) {
        y0 y0Var = lVar.zzs;
        if (!((l3.r) y0Var).f7286a) {
            int size = y0Var.size();
            lVar.zzs = y0Var.b(size == 0 ? 10 : size + size);
        }
        lVar.zzs.set(i8, fVar);
    }

    public final String A() {
        return this.zzg;
    }

    public final y0 B() {
        return this.zzs;
    }

    public final boolean D() {
        return (this.zzd & 2048) != 0;
    }

    public final boolean E() {
        return (this.zzd & 16) != 0;
    }

    public final boolean F() {
        return (this.zzd & 4096) != 0;
    }

    public final boolean G() {
        return (this.zzd & 32) != 0;
    }

    public final boolean H() {
        return (this.zzd & 1024) != 0;
    }

    public final boolean I() {
        return (this.zzd & 64) != 0;
    }

    public final boolean J() {
        return (this.zzd & 128) != 0;
    }

    public final boolean K() {
        return (this.zzd & 512) != 0;
    }

    public final boolean L() {
        return (this.zzd & 256) != 0;
    }

    public final int M() {
        int iA = m3.b0.a(this.zze);
        if (iA == 0) {
            return 1;
        }
        return iA;
    }

    @Override // l3.q0
    public final Object n(int i8, q0 q0Var) {
        int i9 = i8 - 1;
        if (i9 == 0) {
            return Byte.valueOf(this.zzz);
        }
        if (i9 == 2) {
            return new a2(zza, "\u0001\u0015\u0000\u0001\u0001\u0015\u0015\u0000\u0003\u000b\u0001ᴌ\u0000\u0002ᔊ\u0001\u0003ᔈ\u0002\u0004ᴌ\u0003\u0005ᐉ\u0004\u0006ဉ\u0005\u0007ဉ\u0006\bᐉ\u0007\tᐉ\b\nᐉ\t\u000bЛ\fဈ\u000e\rЛ\u000eည\u0011\u000fᐉ\n\u0010ဉ\u000b\u0011ဉ\f\u0012\u0016\u0013ဉ\r\u0014ဇ\u000f\u0015က\u0010", new Object[]{"zzd", "zze", h.f11077d, "zzf", "zzg", "zzh", h.e, "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzs", f.class, "zzu", "zzv", f.class, "zzy", "zzo", "zzp", "zzq", "zzt", "zzr", "zzw", "zzx"});
        }
        if (i9 == 3) {
            return new l();
        }
        if (i9 == 4) {
            return new k(zza);
        }
        if (i9 == 5) {
            return zza;
        }
        this.zzz = q0Var == null ? (byte) 0 : (byte) 1;
        return null;
    }

    public final int o() {
        int iA = c0.a(this.zzh);
        if (iA == 0) {
            return 1;
        }
        return iA;
    }

    public final int p() {
        return this.zzs.size();
    }

    public final l3.p q() {
        l3.p pVar = this.zzk;
        return pVar == null ? l3.p.o() : pVar;
    }

    public final o r() {
        o oVar = this.zzp;
        return oVar == null ? o.q() : oVar;
    }

    public final p s() {
        p pVar = this.zzi;
        return pVar == null ? p.p() : pVar;
    }

    public final q t() {
        q qVar = this.zzq;
        return qVar == null ? q.o() : qVar;
    }

    public final r u() {
        r rVar = this.zzj;
        return rVar == null ? r.o() : rVar;
    }

    public final d v() {
        d dVar = this.zzo;
        return dVar == null ? d.q() : dVar;
    }

    public final g w() {
        g gVar = this.zzl;
        return gVar == null ? g.o() : gVar;
    }

    public final i x() {
        i iVar = this.zzn;
        return iVar == null ? i.o() : iVar;
    }

    public final j y() {
        j jVar = this.zzm;
        return jVar == null ? j.o() : jVar;
    }

    public final b0 z() {
        return this.zzf;
    }
}
