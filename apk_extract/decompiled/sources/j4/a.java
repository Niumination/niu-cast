package j4;

import java.math.RoundingMode;
import java.util.Arrays;
import k3.ta;
import k3.w8;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final char[] f6096b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f6097c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f6098d;
    public final int e;
    public final int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final byte[] f6099g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean[] f6100h;

    public a(String str, char[] cArr) {
        byte[] bArr = new byte[128];
        Arrays.fill(bArr, (byte) -1);
        int i8 = 0;
        while (true) {
            if (i8 >= cArr.length) {
                this.f6095a = str;
                this.f6096b = cArr;
                try {
                    int iB = ta.b(cArr.length, RoundingMode.UNNECESSARY);
                    this.f6098d = iB;
                    int iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(iB);
                    int i9 = 1 << (3 - iNumberOfTrailingZeros);
                    this.e = i9;
                    this.f = iB >> iNumberOfTrailingZeros;
                    this.f6097c = cArr.length - 1;
                    this.f6099g = bArr;
                    boolean[] zArr = new boolean[i9];
                    for (int i10 = 0; i10 < this.f; i10++) {
                        zArr[ta.a(i10 * 8, this.f6098d, RoundingMode.CEILING)] = true;
                    }
                    this.f6100h = zArr;
                    return;
                } catch (ArithmeticException e) {
                    throw new IllegalArgumentException("Illegal alphabet length " + cArr.length, e);
                }
            }
            char c9 = cArr[i8];
            if (!(c9 < 128)) {
                throw new IllegalArgumentException(w8.a("Non-ASCII character: %s", Character.valueOf(c9)));
            }
            if (!(bArr[c9] == -1)) {
                throw new IllegalArgumentException(w8.a("Duplicate character: %s", Character.valueOf(c9)));
            }
            bArr[c9] = (byte) i8;
            i8++;
        }
    }

    public final int a(char c9) throws d {
        if (c9 > 127) {
            throw new d("Unrecognized character: 0x" + Integer.toHexString(c9));
        }
        byte b9 = this.f6099g[c9];
        if (b9 != -1) {
            return b9;
        }
        if (c9 <= ' ' || c9 == 127) {
            throw new d("Unrecognized character: 0x" + Integer.toHexString(c9));
        }
        throw new d("Unrecognized character: " + c9);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        aVar.getClass();
        return Arrays.equals(this.f6096b, aVar.f6096b);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f6096b) + 1237;
    }

    public final String toString() {
        return this.f6095a;
    }
}
