package k3;

import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import kotlin.UByte;
import kotlin.UShort;

/* JADX INFO: loaded from: classes.dex */
public abstract class e9 {
    public static Object a(int i8) {
        if (i8 < 2 || i8 > 1073741824 || Integer.highestOneBit(i8) != i8) {
            throw new IllegalArgumentException(a1.a.o(i8, "must be power of 2 between 2^1 and 2^30: "));
        }
        if (i8 <= 256) {
            return new byte[i8];
        }
        return i8 <= 65536 ? new short[i8] : new int[i8];
    }

    public static int b(int i8, int i9, int i10) {
        return (i8 & (~i10)) | (i9 & i10);
    }

    public static int c(int i8) {
        return (i8 + 1) * (i8 < 32 ? 4 : 2);
    }

    public static int d(Object obj, Object obj2, int i8, Object obj3, int[] iArr, Object[] objArr, Object[] objArr2) {
        int iB = f9.b(obj);
        int i9 = iB & i8;
        int iE = e(i9, obj3);
        if (iE == 0) {
            return -1;
        }
        int i10 = ~i8;
        int i11 = iB & i10;
        int i12 = -1;
        while (true) {
            int i13 = iE - 1;
            int i14 = iArr[i13];
            if ((i14 & i10) == i11 && u8.a(obj, objArr[i13]) && (objArr2 == null || u8.a(obj2, objArr2[i13]))) {
                int i15 = i14 & i8;
                if (i12 == -1) {
                    f(i9, i15, obj3);
                } else {
                    iArr[i12] = b(iArr[i12], i15, i8);
                }
                return i13;
            }
            int i16 = i14 & i8;
            if (i16 == 0) {
                return -1;
            }
            i12 = i13;
            iE = i16;
        }
    }

    public static int e(int i8, Object obj) {
        if (obj instanceof byte[]) {
            return ((byte[]) obj)[i8] & UByte.MAX_VALUE;
        }
        return obj instanceof short[] ? ((short[]) obj)[i8] & UShort.MAX_VALUE : ((int[]) obj)[i8];
    }

    public static void f(int i8, int i9, Object obj) {
        if (obj instanceof byte[]) {
            ((byte[]) obj)[i8] = (byte) i9;
        } else if (obj instanceof short[]) {
            ((short[]) obj)[i8] = (short) i9;
        } else {
            ((int[]) obj)[i8] = i9;
        }
    }

    public static int g(int i8) {
        int iMax = Math.max(i8 + 1, 2);
        int iHighestOneBit = Integer.highestOneBit(iMax);
        if (iMax > ((int) (1.0d * ((double) iHighestOneBit)))) {
            int i9 = iHighestOneBit << 1;
            if (i9 <= 0) {
                i9 = BasicMeasure.EXACTLY;
            }
            iHighestOneBit = i9;
        }
        return Math.max(4, iHighestOneBit);
    }
}
