package j4;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import k3.cb;

/* JADX INFO: loaded from: classes.dex */
public abstract class g {
    static {
        new f();
    }

    public static byte[] a(ArrayDeque arrayDeque, int i8) {
        if (arrayDeque.isEmpty()) {
            return new byte[0];
        }
        byte[] bArr = (byte[]) arrayDeque.remove();
        if (bArr.length == i8) {
            return bArr;
        }
        int length = i8 - bArr.length;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, i8);
        while (length > 0) {
            byte[] bArr2 = (byte[]) arrayDeque.remove();
            int iMin = Math.min(length, bArr2.length);
            System.arraycopy(bArr2, 0, bArrCopyOf, i8 - length, iMin);
            length -= iMin;
        }
        return bArrCopyOf;
    }

    public static byte[] b(gf.a aVar) throws IOException {
        ArrayDeque arrayDeque = new ArrayDeque(20);
        int iMin = Math.min(8192, Math.max(128, Integer.highestOneBit(0) * 2));
        int i8 = 0;
        while (i8 < 2147483639) {
            int iMin2 = Math.min(iMin, 2147483639 - i8);
            byte[] bArr = new byte[iMin2];
            arrayDeque.add(bArr);
            int i9 = 0;
            while (i9 < iMin2) {
                int i10 = aVar.read(bArr, i9, iMin2 - i9);
                if (i10 == -1) {
                    return a(arrayDeque, i8);
                }
                i9 += i10;
                i8 += i10;
            }
            iMin = cb.b(((long) iMin) * ((long) (iMin < 4096 ? 4 : 2)));
        }
        if (aVar.read() == -1) {
            return a(arrayDeque, 2147483639);
        }
        throw new OutOfMemoryError("input is too large to fit in a byte array");
    }
}
