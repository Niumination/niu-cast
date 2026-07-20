package m3;

import kotlin.UByte;

/* JADX INFO: loaded from: classes.dex */
public abstract class v {
    public static int[] a(byte[] bArr) {
        int[] iArr = new int[(bArr.length & 3) == 0 ? bArr.length >>> 2 : (bArr.length >>> 2) + 1];
        int length = bArr.length;
        for (int i8 = 0; i8 < length; i8++) {
            int i9 = i8 >>> 2;
            iArr[i9] = iArr[i9] | ((bArr[i8] & UByte.MAX_VALUE) << ((i8 & 3) << 3));
        }
        return iArr;
    }
}
