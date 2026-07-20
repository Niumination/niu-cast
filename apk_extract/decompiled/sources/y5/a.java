package y5;

import java.io.IOException;
import l3.a2;
import l3.b0;
import l3.b1;
import l3.f0;
import l3.f2;
import l3.n2;
import l3.q0;
import l3.r1;
import l3.t;
import l3.y0;
import l3.y1;
import l3.z1;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends q0 implements r1 {
    private static final a zza;
    private int zzd;
    private int zzf;
    private byte zzi = 2;
    private y0 zze = z1.f7330d;
    private String zzg = "";
    private b0 zzh = b0.zzb;

    static {
        a aVar = new a();
        zza = aVar;
        q0.h(a.class, aVar);
    }

    public static a o(byte[] bArr, f0 f0Var) throws b1 {
        a aVar = zza;
        int length = bArr.length;
        q0 q0Var = (q0) aVar.n(4, null);
        try {
            f2 f2VarB = y1.f7325c.b(q0Var.getClass());
            f2VarB.d(q0Var, bArr, 0, length, new t(f0Var));
            f2VarB.b(q0Var);
            if (q0.j(q0Var, true)) {
                return (a) q0Var;
            }
            b1 b1VarZza = new n2(q0Var).zza();
            b1VarZza.zzf(q0Var);
            throw b1VarZza;
        } catch (IndexOutOfBoundsException unused) {
            b1 b1VarZzg = b1.zzg();
            b1VarZzg.zzf(q0Var);
            throw b1VarZzg;
        } catch (b1 e) {
            e.zzf(q0Var);
            throw e;
        } catch (IOException e4) {
            if (e4.getCause() instanceof b1) {
                throw ((b1) e4.getCause());
            }
            b1 b1Var = new b1(e4);
            b1Var.zzf(q0Var);
            throw b1Var;
        } catch (n2 e10) {
            b1 b1VarZza2 = e10.zza();
            b1VarZza2.zzf(q0Var);
            throw b1VarZza2;
        }
    }

    @Override // l3.q0
    public final Object n(int i8, q0 q0Var) {
        int i9 = i8 - 1;
        if (i9 == 0) {
            return Byte.valueOf(this.zzi);
        }
        if (i9 == 2) {
            return new a2(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0002\u0001Л\u0002ᴌ\u0000\u0003ဈ\u0001\u0004ည\u0002", new Object[]{"zzd", "zze", l.class, "zzf", h.f11075b, "zzg", "zzh"});
        }
        if (i9 == 3) {
            return new a();
        }
        if (i9 == 4) {
            return new c(zza);
        }
        if (i9 == 5) {
            return zza;
        }
        this.zzi = q0Var == null ? (byte) 0 : (byte) 1;
        return null;
    }

    public final y0 p() {
        return this.zze;
    }
}
