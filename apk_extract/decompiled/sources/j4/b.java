package j4;

import k3.v8;
import kotlin.UByte;

/* JADX INFO: loaded from: classes.dex */
public final class b extends e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final char[] f6101d;

    public b(a aVar) {
        super(aVar, (Character) null);
        this.f6101d = new char[512];
        char[] cArr = aVar.f6096b;
        v8.e(cArr.length == 16);
        for (int i8 = 0; i8 < 256; i8++) {
            char[] cArr2 = this.f6101d;
            cArr2[i8] = cArr[i8 >>> 4];
            cArr2[i8 | 256] = cArr[i8 & 15];
        }
    }

    @Override // j4.e
    public final int b(byte[] bArr, CharSequence charSequence) throws d {
        if (charSequence.length() % 2 == 1) {
            throw new d("Invalid input length " + charSequence.length());
        }
        int i8 = 0;
        int i9 = 0;
        while (i8 < charSequence.length()) {
            char cCharAt = charSequence.charAt(i8);
            a aVar = this.f6103a;
            bArr[i9] = (byte) ((aVar.a(cCharAt) << 4) | aVar.a(charSequence.charAt(i8 + 1)));
            i8 += 2;
            i9++;
        }
        return i9;
    }

    @Override // j4.e
    public final void e(StringBuilder sb2, byte[] bArr, int i8) {
        v8.k(0, i8, bArr.length);
        for (int i9 = 0; i9 < i8; i9++) {
            int i10 = bArr[i9] & UByte.MAX_VALUE;
            char[] cArr = this.f6101d;
            sb2.append(cArr[i10]);
            sb2.append(cArr[i10 | 256]);
        }
    }
}
