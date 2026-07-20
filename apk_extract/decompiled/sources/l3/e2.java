package l3;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayDeque;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class e2 extends b0 {
    static final int[] zza = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, Integer.MAX_VALUE};
    private final int zzc;
    private final b0 zzd;
    private final b0 zze;
    private final int zzf;
    private final int zzg;

    public static int zzc(int i8) {
        int[] iArr = zza;
        int length = iArr.length;
        if (i8 >= 47) {
            return Integer.MAX_VALUE;
        }
        return iArr[i8];
    }

    public static b0 zzz(b0 b0Var, b0 b0Var2) {
        if (b0Var2.zzd() == 0) {
            return b0Var;
        }
        if (b0Var.zzd() == 0) {
            return b0Var2;
        }
        int iZzd = b0Var2.zzd() + b0Var.zzd();
        if (iZzd < 128) {
            int iZzd2 = b0Var.zzd();
            int iZzd3 = b0Var2.zzd();
            byte[] bArr = new byte[iZzd2 + iZzd3];
            b0Var.zzw(bArr, 0, 0, iZzd2);
            b0Var2.zzw(bArr, 0, iZzd2, iZzd3);
            return new a0(bArr);
        }
        if (b0Var instanceof e2) {
            e2 e2Var = (e2) b0Var;
            if (b0Var2.zzd() + e2Var.zze.zzd() < 128) {
                b0 b0Var3 = e2Var.zze;
                int iZzd4 = b0Var3.zzd();
                int iZzd5 = b0Var2.zzd();
                byte[] bArr2 = new byte[iZzd4 + iZzd5];
                b0Var3.zzw(bArr2, 0, 0, iZzd4);
                b0Var2.zzw(bArr2, 0, iZzd4, iZzd5);
                return new e2(e2Var.zzd, new a0(bArr2));
            }
            if (e2Var.zzd.zzf() > e2Var.zze.zzf() && e2Var.zzg > b0Var2.zzf()) {
                return new e2(e2Var.zzd, new e2(e2Var.zze, b0Var2));
            }
        }
        if (iZzd >= zzc(Math.max(b0Var.zzf(), b0Var2.zzf()) + 1)) {
            return new e2(b0Var, b0Var2);
        }
        l1 l1Var = new l1(1);
        l1Var.f(b0Var);
        l1Var.f(b0Var2);
        ArrayDeque arrayDeque = (ArrayDeque) l1Var.f7264a;
        b0 e2Var2 = (b0) arrayDeque.pop();
        while (!arrayDeque.isEmpty()) {
            e2Var2 = new e2((b0) arrayDeque.pop(), e2Var2);
        }
        return e2Var2;
    }

    @Override // l3.b0
    public final boolean equals(Object obj) {
        z zVarA;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b0)) {
            return false;
        }
        b0 b0Var = (b0) obj;
        if (this.zzc != b0Var.zzd()) {
            return false;
        }
        if (this.zzc == 0) {
            return true;
        }
        int iZzp = zzp();
        int iZzp2 = b0Var.zzp();
        if (iZzp != 0 && iZzp2 != 0 && iZzp != iZzp2) {
            return false;
        }
        c2 c2Var = new c2(this);
        z zVarA2 = c2Var.a();
        c2 c2Var2 = new c2(b0Var);
        z zVarA3 = c2Var2.a();
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (true) {
            int iZzd = zVarA2.zzd() - i8;
            int iZzd2 = zVarA3.zzd() - i9;
            int iMin = Math.min(iZzd, iZzd2);
            if (!(i8 == 0 ? zVarA2.zzg(zVarA3, i9, iMin) : zVarA3.zzg(zVarA2, i8, iMin))) {
                return false;
            }
            i10 += iMin;
            int i11 = this.zzc;
            if (i10 >= i11) {
                if (i10 == i11) {
                    return true;
                }
                throw new IllegalStateException();
            }
            if (iMin == iZzd) {
                zVarA = c2Var.a();
                i8 = 0;
            } else {
                i8 += iMin;
            }
            if (iMin == iZzd2) {
                zVarA2 = zVarA2;
                zVarA2 = zVarA;
                zVarA3 = c2Var2.a();
                i9 = 0;
            } else {
                zVarA2 = zVarA2;
                zVarA2 = zVarA;
                i9 += iMin;
            }
        }
    }

    @Override // l3.b0, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new b2(this);
    }

    @Override // l3.b0
    public final byte zza(int i8) {
        b0.zzv(i8, this.zzc);
        return zzb(i8);
    }

    @Override // l3.b0
    public final byte zzb(int i8) {
        int i9 = this.zzf;
        return i8 < i9 ? this.zzd.zzb(i8) : this.zze.zzb(i8 - i9);
    }

    @Override // l3.b0
    public final int zzd() {
        return this.zzc;
    }

    @Override // l3.b0
    public final void zze(byte[] bArr, int i8, int i9, int i10) {
        int i11 = i8 + i10;
        int i12 = this.zzf;
        if (i11 <= i12) {
            this.zzd.zze(bArr, i8, i9, i10);
        } else {
            if (i8 >= i12) {
                this.zze.zze(bArr, i8 - i12, i9, i10);
                return;
            }
            int i13 = i12 - i8;
            this.zzd.zze(bArr, i8, i9, i13);
            this.zze.zze(bArr, 0, i9 + i13, i10 - i13);
        }
    }

    @Override // l3.b0
    public final int zzf() {
        return this.zzg;
    }

    @Override // l3.b0
    public final boolean zzh() {
        return this.zzc >= zzc(this.zzg);
    }

    @Override // l3.b0
    public final int zzi(int i8, int i9, int i10) {
        int i11 = i9 + i10;
        int i12 = this.zzf;
        if (i11 <= i12) {
            return this.zzd.zzi(i8, i9, i10);
        }
        if (i9 >= i12) {
            return this.zze.zzi(i8, i9 - i12, i10);
        }
        int i13 = i12 - i9;
        return this.zze.zzi(this.zzd.zzi(i8, i9, i13), 0, i10 - i13);
    }

    @Override // l3.b0
    public final int zzj(int i8, int i9, int i10) {
        int i11 = i9 + i10;
        int i12 = this.zzf;
        if (i11 <= i12) {
            return this.zzd.zzj(i8, i9, i10);
        }
        if (i9 >= i12) {
            return this.zze.zzj(i8, i9 - i12, i10);
        }
        int i13 = i12 - i9;
        return this.zze.zzj(this.zzd.zzj(i8, i9, i13), 0, i10 - i13);
    }

    @Override // l3.b0
    public final b0 zzk(int i8, int i9) {
        int iZzo = b0.zzo(i8, i9, this.zzc);
        if (iZzo == 0) {
            return b0.zzb;
        }
        if (iZzo == this.zzc) {
            return this;
        }
        int i10 = this.zzf;
        if (i9 <= i10) {
            return this.zzd.zzk(i8, i9);
        }
        if (i8 >= i10) {
            return this.zze.zzk(i8 - i10, i9 - i10);
        }
        b0 b0Var = this.zzd;
        return new e2(b0Var.zzk(i8, b0Var.zzd()), this.zze.zzk(0, i9 - this.zzf));
    }

    @Override // l3.b0
    public final String zzl(Charset charset) {
        return new String(zzx(), charset);
    }

    @Override // l3.b0
    public final void zzm(u uVar) throws IOException {
        this.zzd.zzm(uVar);
        this.zze.zzm(uVar);
    }

    @Override // l3.b0
    public final boolean zzn() {
        int iZzj = this.zzd.zzj(0, 0, this.zzf);
        b0 b0Var = this.zze;
        return b0Var.zzj(iZzj, 0, b0Var.zzd()) == 0;
    }

    @Override // l3.b0
    /* JADX INFO: renamed from: zzq */
    public final y iterator() {
        return new b2(this);
    }

    public e2(b0 b0Var, b0 b0Var2) {
        this.zzd = b0Var;
        this.zze = b0Var2;
        int iZzd = b0Var.zzd();
        this.zzf = iZzd;
        this.zzc = b0Var2.zzd() + iZzd;
        this.zzg = Math.max(b0Var.zzf(), b0Var2.zzf()) + 1;
    }
}
