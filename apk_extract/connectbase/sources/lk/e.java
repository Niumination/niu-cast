package lk;

import java.nio.ByteBuffer;
import kn.l0;
import os.l;

/* JADX INFO: loaded from: classes2.dex */
public final class e {
    @l
    public static final byte[] a(int i10, int i11) {
        if (i11 <= 0) {
            throw new IllegalArgumentException("Does only work for positive numbers");
        }
        byte[] bArrE = f.e();
        byte[] bArr = new byte[8];
        for (int i12 = 0; i12 < 8; i12++) {
            int i13 = i11 & 15;
            i11 >>>= 4;
            bArr[7 - i12] = bArrE[i13];
        }
        return bArr;
    }

    public static final int b(@l ByteBuffer byteBuffer, int i10) {
        l0.p(byteBuffer, "<this>");
        if (i10 <= 0) {
            throw new IllegalArgumentException("Does only work for positive numbers");
        }
        byte[] bArrE = f.e();
        int i11 = 0;
        int i12 = 0;
        while (i11 < 8) {
            int i13 = i11 + 1;
            int i14 = i10 & 15;
            i12 = i14 == 0 ? i12 + 1 : 0;
            i10 >>>= 4;
            byteBuffer.put(7 - i11, bArrE[i14]);
            i11 = i13;
        }
        return i12;
    }
}
