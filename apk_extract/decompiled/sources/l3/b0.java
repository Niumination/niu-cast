package l3;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public abstract class b0 implements Iterable, Serializable {
    public static final b0 zzb = new a0(z0.f7329b);
    private int zzc = 0;

    static {
        int i8 = s.f7291a;
    }

    public static b0 e(Iterator it, int i8) {
        if (i8 <= 0) {
            throw new IllegalArgumentException(h0.a.h(i8, "length (", ") must be >= 1"));
        }
        if (i8 == 1) {
            return (b0) it.next();
        }
        int i9 = i8 >>> 1;
        b0 b0VarE = e(it, i9);
        b0 b0VarE2 = e(it, i8 - i9);
        if (Integer.MAX_VALUE - b0VarE.zzd() >= b0VarE2.zzd()) {
            return e2.zzz(b0VarE, b0VarE2);
        }
        throw new IllegalArgumentException(o.d.f(b0VarE.zzd(), b0VarE2.zzd(), "ByteString would be too long: ", vj.e.ANY_NON_NULL_MARKER));
    }

    public static int zzo(int i8, int i9, int i10) {
        int i11 = i9 - i8;
        if ((i8 | i9 | i11 | (i10 - i9)) >= 0) {
            return i11;
        }
        if (i8 < 0) {
            throw new IndexOutOfBoundsException(h0.a.h(i8, "Beginning index: ", " < 0"));
        }
        if (i9 < i8) {
            throw new IndexOutOfBoundsException(o.d.f(i8, i9, "Beginning index larger than ending index: ", ", "));
        }
        throw new IndexOutOfBoundsException(o.d.f(i9, i10, "End index: ", " >= "));
    }

    public static b0 zzr(byte[] bArr, int i8, int i9) {
        zzo(i8, i8 + i9, bArr.length);
        byte[] bArr2 = new byte[i9];
        System.arraycopy(bArr, i8, bArr2, 0, i9);
        return new a0(bArr2);
    }

    public static b0 zzs(InputStream inputStream) throws IOException {
        ArrayList arrayList = new ArrayList();
        int iMin = 256;
        while (true) {
            byte[] bArr = new byte[iMin];
            int i8 = 0;
            while (i8 < iMin) {
                int i9 = inputStream.read(bArr, i8, iMin - i8);
                if (i9 == -1) {
                    break;
                }
                i8 += i9;
            }
            b0 b0VarZzr = i8 == 0 ? null : zzr(bArr, 0, i8);
            if (b0VarZzr == null) {
                break;
            }
            arrayList.add(b0VarZzr);
            iMin = Math.min(iMin + iMin, 8192);
        }
        int size = arrayList.size();
        return size == 0 ? zzb : e(arrayList.iterator(), size);
    }

    public static void zzv(int i8, int i9) {
        if (((i9 - (i8 + 1)) | i8) < 0) {
            if (i8 >= 0) {
                throw new ArrayIndexOutOfBoundsException(o.d.f(i8, i9, "Index > length: ", ", "));
            }
            throw new ArrayIndexOutOfBoundsException(a1.a.o(i8, "Index < 0: "));
        }
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int iZzi = this.zzc;
        if (iZzi == 0) {
            int iZzd = zzd();
            iZzi = zzi(iZzd, 0, iZzd);
            if (iZzi == 0) {
                iZzi = 1;
            }
            this.zzc = iZzi;
        }
        return iZzi;
    }

    public final String toString() {
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        int iZzd = zzd();
        String strB = zzd() <= 50 ? k2.b(this) : k2.b(zzk(0, 47)).concat("...");
        StringBuilder sb2 = new StringBuilder("<ByteString@");
        sb2.append(hexString);
        sb2.append(" size=");
        sb2.append(iZzd);
        sb2.append(" contents=\"");
        return h0.a.n(sb2, strB, "\">");
    }

    public abstract byte zza(int i8);

    public abstract byte zzb(int i8);

    public abstract int zzd();

    public abstract void zze(byte[] bArr, int i8, int i9, int i10);

    public abstract int zzf();

    public abstract boolean zzh();

    public abstract int zzi(int i8, int i9, int i10);

    public abstract int zzj(int i8, int i9, int i10);

    public abstract b0 zzk(int i8, int i9);

    public abstract String zzl(Charset charset);

    public abstract void zzm(u uVar) throws IOException;

    public abstract boolean zzn();

    public final int zzp() {
        return this.zzc;
    }

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: zzq, reason: merged with bridge method [inline-methods] */
    public y iterator() {
        return new v(this);
    }

    public final String zzt(Charset charset) {
        return zzd() == 0 ? "" : zzl(charset);
    }

    public final String zzu() {
        return zzt(z0.f7328a);
    }

    @Deprecated
    public final void zzw(byte[] bArr, int i8, int i9, int i10) {
        zzo(0, i10, zzd());
        zzo(i9, i9 + i10, bArr.length);
        if (i10 > 0) {
            zze(bArr, 0, i9, i10);
        }
    }

    public final byte[] zzx() {
        int iZzd = zzd();
        if (iZzd == 0) {
            return z0.f7329b;
        }
        byte[] bArr = new byte[iZzd];
        zze(bArr, 0, 0, iZzd);
        return bArr;
    }
}
