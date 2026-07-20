package g4;

import java.util.Arrays;
import java.util.List;
import l3.a2;
import l3.k0;
import l3.q0;
import l3.r;
import l3.r1;
import l3.v0;

/* JADX INFO: loaded from: classes.dex */
public final class c extends q0 implements r1 {
    private static final c zza;
    private int zzd;
    private v0 zze;
    private v0 zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;

    static {
        c cVar = new c();
        zza = cVar;
        q0.h(c.class, cVar);
    }

    public c() {
        k0 k0Var = k0.f7255d;
        this.zze = k0Var;
        this.zzf = k0Var;
    }

    public static b o() {
        return (b) zza.d();
    }

    public static /* synthetic */ void p(c cVar, int i8) {
        cVar.zzd |= 2;
        cVar.zzh = i8;
    }

    public static void q(c cVar, float f) {
        List list = cVar.zze;
        if (!((r) list).f7286a) {
            int size = list.size();
            int i8 = size == 0 ? 10 : size + size;
            k0 k0Var = (k0) list;
            if (i8 < k0Var.f7257c) {
                throw new IllegalArgumentException();
            }
            cVar.zze = new k0(Arrays.copyOf(k0Var.f7256b, i8), k0Var.f7257c, true);
        }
        ((k0) cVar.zze).g(f);
    }

    public static void r(c cVar, float f) {
        List list = cVar.zzf;
        if (!((r) list).f7286a) {
            int size = list.size();
            int i8 = size == 0 ? 10 : size + size;
            k0 k0Var = (k0) list;
            if (i8 < k0Var.f7257c) {
                throw new IllegalArgumentException();
            }
            cVar.zzf = new k0(Arrays.copyOf(k0Var.f7256b, i8), k0Var.f7257c, true);
        }
        ((k0) cVar.zzf).g(f);
    }

    public static /* synthetic */ void s(c cVar, int i8) {
        cVar.zzd |= 1;
        cVar.zzg = i8;
    }

    @Override // l3.q0
    public final Object n(int i8, q0 q0Var) {
        int i9 = i8 - 1;
        if (i9 == 0) {
            return (byte) 1;
        }
        if (i9 == 2) {
            return new a2(zza, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0002\u0000\u0001\u0013\u0002\u0013\u0003ဋ\u0000\u0004ဋ\u0001\u0005ဋ\u0002\u0006ဋ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        }
        if (i9 == 3) {
            return new c();
        }
        if (i9 == 4) {
            return new b(zza);
        }
        if (i9 != 5) {
            return null;
        }
        return zza;
    }
}
