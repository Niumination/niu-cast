package j4;

import java.io.IOException;
import java.math.RoundingMode;
import java.util.Objects;
import k3.ta;
import k3.v8;
import kotlin.UByte;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f6102c = new c("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f6103a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Character f6104b;

    static {
        new c("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_");
        new e("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567");
        new e("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV");
        new b(new a("base16()", "0123456789ABCDEF".toCharArray()));
    }

    /* JADX WARN: Code duplicated, block: B:9:0x001a  */
    public e(a aVar, Character ch2) {
        boolean z2;
        aVar.getClass();
        this.f6103a = aVar;
        if (ch2 != null) {
            char cCharValue = ch2.charValue();
            byte[] bArr = aVar.f6099g;
            if (cCharValue >= bArr.length || bArr[cCharValue] == -1) {
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            z2 = true;
        }
        v8.d("Padding character %s was already in alphabet", z2, ch2);
        this.f6104b = ch2;
    }

    public final byte[] a(String str) {
        try {
            CharSequence charSequenceF = f(str);
            int length = (int) (((((long) this.f6103a.f6098d) * ((long) charSequenceF.length())) + 7) / 8);
            byte[] bArr = new byte[length];
            int iB = b(bArr, charSequenceF);
            if (iB == length) {
                return bArr;
            }
            byte[] bArr2 = new byte[iB];
            System.arraycopy(bArr, 0, bArr2, 0, iB);
            return bArr2;
        } catch (d e) {
            throw new IllegalArgumentException(e);
        }
    }

    public int b(byte[] bArr, CharSequence charSequence) throws d {
        int i8;
        int i9;
        CharSequence charSequenceF = f(charSequence);
        int length = charSequenceF.length();
        a aVar = this.f6103a;
        if (!aVar.f6100h[length % aVar.e]) {
            throw new d("Invalid input length " + charSequenceF.length());
        }
        int i10 = 0;
        int i11 = 0;
        while (i10 < charSequenceF.length()) {
            long jA = 0;
            int i12 = 0;
            int i13 = 0;
            while (true) {
                i8 = aVar.f6098d;
                i9 = aVar.e;
                if (i12 >= i9) {
                    break;
                }
                jA <<= i8;
                if (i10 + i12 < charSequenceF.length()) {
                    jA |= (long) aVar.a(charSequenceF.charAt(i13 + i10));
                    i13++;
                }
                i12++;
            }
            int i14 = aVar.f;
            int i15 = (i14 * 8) - (i13 * i8);
            int i16 = (i14 - 1) * 8;
            while (i16 >= i15) {
                bArr[i11] = (byte) ((jA >>> i16) & 255);
                i16 -= 8;
                i11++;
            }
            i10 += i9;
        }
        return i11;
    }

    public final String c(byte[] bArr) {
        int length = bArr.length;
        v8.k(0, length, bArr.length);
        a aVar = this.f6103a;
        StringBuilder sb2 = new StringBuilder(ta.a(length, aVar.f, RoundingMode.CEILING) * aVar.e);
        try {
            e(sb2, bArr, length);
            return sb2.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    public final void d(StringBuilder sb2, byte[] bArr, int i8, int i9) {
        v8.k(i8, i8 + i9, bArr.length);
        a aVar = this.f6103a;
        int i10 = 0;
        v8.e(i9 <= aVar.f);
        long j8 = 0;
        for (int i11 = 0; i11 < i9; i11++) {
            j8 = (j8 | ((long) (bArr[i8 + i11] & UByte.MAX_VALUE))) << 8;
        }
        int i12 = aVar.f6098d;
        int i13 = ((i9 + 1) * 8) - i12;
        while (i10 < i9 * 8) {
            sb2.append(aVar.f6096b[((int) (j8 >>> (i13 - i10))) & aVar.f6097c]);
            i10 += i12;
        }
        Character ch2 = this.f6104b;
        if (ch2 != null) {
            while (i10 < aVar.f * 8) {
                sb2.append(ch2.charValue());
                i10 += i12;
            }
        }
    }

    public void e(StringBuilder sb2, byte[] bArr, int i8) {
        int i9 = 0;
        v8.k(0, i8, bArr.length);
        while (i9 < i8) {
            a aVar = this.f6103a;
            d(sb2, bArr, i9, Math.min(aVar.f, i8 - i9));
            i9 += aVar.f;
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.f6103a.equals(eVar.f6103a) && Objects.equals(this.f6104b, eVar.f6104b);
    }

    public final CharSequence f(CharSequence charSequence) {
        charSequence.getClass();
        Character ch2 = this.f6104b;
        if (ch2 == null) {
            return charSequence;
        }
        char cCharValue = ch2.charValue();
        int length = charSequence.length() - 1;
        while (length >= 0 && charSequence.charAt(length) == cCharValue) {
            length--;
        }
        return charSequence.subSequence(0, length + 1);
    }

    public final int hashCode() {
        return Objects.hashCode(this.f6104b) ^ this.f6103a.hashCode();
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("BaseEncoding.");
        a aVar = this.f6103a;
        sb2.append(aVar);
        if (8 % aVar.f6098d != 0) {
            Character ch2 = this.f6104b;
            if (ch2 == null) {
                sb2.append(".omitPadding()");
            } else {
                sb2.append(".withPadChar('");
                sb2.append(ch2);
                sb2.append("')");
            }
        }
        return sb2.toString();
    }

    public e(String str, String str2) {
        this(new a(str, str2.toCharArray()), (Character) '=');
    }
}
