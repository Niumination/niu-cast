package io.netty.util.internal;

/* JADX INFO: loaded from: classes3.dex */
public final class ConstantTimeUtils {
    private ConstantTimeUtils() {
    }

    public static int equalsConstantTime(int i10, int i11) {
        int i12 = ~(i10 ^ i11);
        int i13 = i12 & (i12 >> 16);
        int i14 = i13 & (i13 >> 8);
        int i15 = i14 & (i14 >> 4);
        int i16 = i15 & (i15 >> 2);
        return i16 & (i16 >> 1) & 1;
    }

    public static int equalsConstantTime(long j10, long j11) {
        long j12 = ~(j10 ^ j11);
        long j13 = j12 & (j12 >> 32);
        long j14 = j13 & (j13 >> 16);
        long j15 = j14 & (j14 >> 8);
        long j16 = j15 & (j15 >> 4);
        long j17 = j16 & (j16 >> 2);
        return (int) (j17 & (j17 >> 1) & 1);
    }

    public static int equalsConstantTime(byte[] bArr, int i10, byte[] bArr2, int i11, int i12) {
        int i13 = i12 + i10;
        int i14 = 0;
        while (i10 < i13) {
            i14 |= bArr[i10] ^ bArr2[i11];
            i10++;
            i11++;
        }
        return equalsConstantTime(i14, 0);
    }

    public static int equalsConstantTime(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence.length() != charSequence2.length()) {
            return 0;
        }
        int iCharAt = 0;
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            iCharAt |= charSequence.charAt(i10) ^ charSequence2.charAt(i10);
        }
        return equalsConstantTime(iCharAt, 0);
    }
}
