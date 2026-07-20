package io.netty.util.internal;

/* JADX INFO: loaded from: classes3.dex */
public final class MathUtil {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    private MathUtil() {
    }

    public static int compare(int i10, int i11) {
        if (i10 < i11) {
            return -1;
        }
        return i10 > i11 ? 1 : 0;
    }

    public static int findNextPositivePowerOfTwo(int i10) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i10 - 1));
    }

    public static boolean isOutOfBounds(int i10, int i11, int i12) {
        int i13 = i10 | i11 | i12;
        int i14 = i10 + i11;
        return ((i13 | i14) | (i12 - i14)) < 0;
    }

    public static int safeFindNextPositivePowerOfTwo(int i10) {
        if (i10 <= 0) {
            return 1;
        }
        if (i10 >= 1073741824) {
            return 1073741824;
        }
        return findNextPositivePowerOfTwo(i10);
    }

    public static int compare(long j10, long j11) {
        if (j10 < j11) {
            return -1;
        }
        return j10 > j11 ? 1 : 0;
    }
}
