package l3;

import java.io.IOException;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public class a0 extends z {
    protected final byte[] zza;

    public a0(byte[] bArr) {
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // l3.b0
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b0) || zzd() != ((b0) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof a0)) {
            return obj.equals(this);
        }
        a0 a0Var = (a0) obj;
        int iZzp = zzp();
        int iZzp2 = a0Var.zzp();
        if (iZzp == 0 || iZzp2 == 0 || iZzp == iZzp2) {
            return zzg(a0Var, 0, zzd());
        }
        return false;
    }

    @Override // l3.b0
    public byte zza(int i8) {
        return this.zza[i8];
    }

    @Override // l3.b0
    public byte zzb(int i8) {
        return this.zza[i8];
    }

    public int zzc() {
        return 0;
    }

    @Override // l3.b0
    public int zzd() {
        return this.zza.length;
    }

    @Override // l3.b0
    public void zze(byte[] bArr, int i8, int i9, int i10) {
        System.arraycopy(this.zza, i8, bArr, i9, i10);
    }

    @Override // l3.z
    public final boolean zzg(b0 b0Var, int i8, int i9) {
        if (i9 > b0Var.zzd()) {
            throw new IllegalArgumentException("Length too large: " + i9 + zzd());
        }
        int i10 = i8 + i9;
        if (i10 > b0Var.zzd()) {
            int iZzd = b0Var.zzd();
            StringBuilder sbR = o.d.r(i8, i9, "Ran off end of other: ", ", ", ", ");
            sbR.append(iZzd);
            throw new IllegalArgumentException(sbR.toString());
        }
        if (!(b0Var instanceof a0)) {
            return b0Var.zzk(i8, i10).equals(zzk(0, i9));
        }
        a0 a0Var = (a0) b0Var;
        byte[] bArr = this.zza;
        byte[] bArr2 = a0Var.zza;
        int iZzc = zzc() + i9;
        int iZzc2 = zzc();
        int iZzc3 = a0Var.zzc() + i8;
        while (iZzc2 < iZzc) {
            if (bArr[iZzc2] != bArr2[iZzc3]) {
                return false;
            }
            iZzc2++;
            iZzc3++;
        }
        return true;
    }

    @Override // l3.b0
    public final int zzi(int i8, int i9, int i10) {
        byte[] bArr = this.zza;
        int iZzc = zzc() + i9;
        Charset charset = z0.f7328a;
        for (int i11 = iZzc; i11 < iZzc + i10; i11++) {
            i8 = (i8 * 31) + bArr[i11];
        }
        return i8;
    }

    @Override // l3.b0
    public final int zzj(int i8, int i9, int i10) {
        int iZzc = zzc() + i9;
        z2.f7333a.getClass();
        return c.a(i8, this.zza, iZzc, i10 + iZzc);
    }

    @Override // l3.b0
    public final b0 zzk(int i8, int i9) {
        int iZzo = b0.zzo(i8, i9, zzd());
        return iZzo == 0 ? b0.zzb : new x(this.zza, zzc() + i8, iZzo);
    }

    @Override // l3.b0
    public final String zzl(Charset charset) {
        return new String(this.zza, zzc(), zzd(), charset);
    }

    @Override // l3.b0
    public final void zzm(u uVar) throws IOException {
        ((c0) uVar).b(this.zza, zzc(), zzd());
    }

    @Override // l3.b0
    public final boolean zzn() {
        int iZzc = zzc();
        byte[] bArr = this.zza;
        int iZzd = zzd() + iZzc;
        z2.f7333a.getClass();
        return c.a(0, bArr, iZzc, iZzd) == 0;
    }
}
