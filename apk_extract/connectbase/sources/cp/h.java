package cp;

import kn.l0;
import os.l;

/* JADX INFO: loaded from: classes3.dex */
public final class h {
    @l
    public static final byte[] a(@l String[] strArr) {
        int i10;
        l0.p(strArr, "strings");
        int length = strArr.length;
        int i11 = 0;
        int length2 = 0;
        while (i11 < length) {
            String str = strArr[i11];
            i11++;
            length2 += str.length();
        }
        byte[] bArr = new byte[length2];
        int length3 = strArr.length;
        int i12 = 0;
        int i13 = 0;
        while (i12 < length3) {
            String str2 = strArr[i12];
            i12++;
            int length4 = str2.length() - 1;
            if (length4 >= 0) {
                int i14 = 0;
                while (true) {
                    int i15 = i14 + 1;
                    i10 = i13 + 1;
                    bArr[i13] = (byte) str2.charAt(i14);
                    if (i14 == length4) {
                        break;
                    }
                    i14 = i15;
                    i13 = i10;
                }
                i13 = i10;
            }
        }
        return bArr;
    }
}
