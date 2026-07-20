package k3;

import kotlin.UByte;

/* JADX INFO: loaded from: classes.dex */
public abstract class pa {
    public static int a(Object obj, Object obj2, int i8, Object obj3, int[] iArr, Object[] objArr, Object[] objArr2) {
        int iA = qa.a(obj);
        int i9 = iA & i8;
        int iB = b(i9, obj3);
        if (iB != 0) {
            int i10 = ~i8;
            int i11 = iA & i10;
            int i12 = -1;
            while (true) {
                int i13 = iB - 1;
                int i14 = iArr[i13];
                if ((i14 & i10) != i11 || !ia.a(obj, objArr[i13]) || (objArr2 != null && !ia.a(obj2, objArr2[i13]))) {
                    int i15 = i14 & i8;
                    if (i15 == 0) {
                        break;
                    }
                    i12 = i13;
                    iB = i15;
                } else {
                    int i16 = i14 & i8;
                    if (i12 == -1) {
                        d(i9, i16, obj3);
                    } else {
                        iArr[i12] = (i16 & i8) | (iArr[i12] & i10);
                    }
                    return i13;
                }
            }
        }
        return -1;
    }

    public static int b(int i8, Object obj) {
        if (obj instanceof byte[]) {
            return ((byte[]) obj)[i8] & UByte.MAX_VALUE;
        }
        return obj instanceof short[] ? (char) ((short[]) obj)[i8] : ((int[]) obj)[i8];
    }

    public static Object c(int i8) {
        if (i8 < 2 || i8 > 1073741824 || Integer.highestOneBit(i8) != i8) {
            throw new IllegalArgumentException(a1.a.o(i8, "must be power of 2 between 2^1 and 2^30: "));
        }
        if (i8 <= 256) {
            return new byte[i8];
        }
        return i8 <= 65536 ? new short[i8] : new int[i8];
    }

    public static void d(int i8, int i9, Object obj) {
        if (obj instanceof byte[]) {
            ((byte[]) obj)[i8] = (byte) i9;
        } else if (obj instanceof short[]) {
            ((short[]) obj)[i8] = (short) i9;
        } else {
            ((int[]) obj)[i8] = i9;
        }
    }
}
