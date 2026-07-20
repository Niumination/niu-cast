package j4;

import k3.v8;
import kotlin.UByte;

/* JADX INFO: loaded from: classes.dex */
public final class c extends e {
    public c(String str, String str2) {
        this(new a(str, str2.toCharArray()), (Character) '=');
    }

    @Override // j4.e
    public final int b(byte[] bArr, CharSequence charSequence) throws d {
        CharSequence charSequenceF = f(charSequence);
        int length = charSequenceF.length();
        a aVar = this.f6103a;
        if (!aVar.f6100h[length % aVar.e]) {
            throw new d("Invalid input length " + charSequenceF.length());
        }
        int i8 = 0;
        int i9 = 0;
        while (i8 < charSequenceF.length()) {
            int i10 = i8 + 2;
            int iA = (aVar.a(charSequenceF.charAt(i8 + 1)) << 12) | (aVar.a(charSequenceF.charAt(i8)) << 18);
            int i11 = i9 + 1;
            bArr[i9] = (byte) (iA >>> 16);
            if (i10 < charSequenceF.length()) {
                int i12 = i8 + 3;
                int iA2 = iA | (aVar.a(charSequenceF.charAt(i10)) << 6);
                int i13 = i9 + 2;
                bArr[i11] = (byte) ((iA2 >>> 8) & 255);
                if (i12 < charSequenceF.length()) {
                    i8 += 4;
                    i9 += 3;
                    bArr[i13] = (byte) ((iA2 | aVar.a(charSequenceF.charAt(i12))) & 255);
                } else {
                    i9 = i13;
                    i8 = i12;
                }
            } else {
                i9 = i11;
                i8 = i10;
            }
        }
        return i9;
    }

    @Override // j4.e
    public final void e(StringBuilder sb2, byte[] bArr, int i8) {
        int i9 = 0;
        v8.k(0, i8, bArr.length);
        for (int i10 = i8; i10 >= 3; i10 -= 3) {
            int i11 = i9 + 2;
            int i12 = ((bArr[i9 + 1] & UByte.MAX_VALUE) << 8) | ((bArr[i9] & UByte.MAX_VALUE) << 16);
            i9 += 3;
            int i13 = i12 | (bArr[i11] & UByte.MAX_VALUE);
            a aVar = this.f6103a;
            sb2.append(aVar.f6096b[i13 >>> 18]);
            char[] cArr = aVar.f6096b;
            sb2.append(cArr[(i13 >>> 12) & 63]);
            sb2.append(cArr[(i13 >>> 6) & 63]);
            sb2.append(cArr[i13 & 63]);
        }
        if (i9 < i8) {
            d(sb2, bArr, i9, i8 - i9);
        }
    }

    public c(a aVar, Character ch2) {
        super(aVar, ch2);
        v8.e(aVar.f6096b.length == 64);
    }
}
