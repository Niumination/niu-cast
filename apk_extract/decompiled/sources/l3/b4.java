package l3;

/* JADX INFO: loaded from: classes.dex */
public final class b4 extends n0 {
    private static final b4 zzd;
    private byte zze;

    static {
        b4 b4Var = new b4();
        zzd = b4Var;
        q0.h(b4.class, b4Var);
    }

    public b4() {
        this.zza = i0.f7249c;
        this.zze = (byte) 2;
    }

    public static b4 p() {
        return zzd;
    }

    @Override // l3.q0
    public final Object n(int i8, q0 q0Var) {
        int i9 = i8 - 1;
        if (i9 == 0) {
            return Byte.valueOf(this.zze);
        }
        if (i9 == 2) {
            return new a2(zzd, "\u0003\u0000", null);
        }
        if (i9 == 3) {
            return new b4();
        }
        if (i9 == 4) {
            return new a4(0, zzd);
        }
        if (i9 == 5) {
            return zzd;
        }
        this.zze = q0Var == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
