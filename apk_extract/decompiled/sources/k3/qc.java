package k3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class qc {
    public static final boolean a(byte[] a6, int i8, byte[] b9, int i9, int i10) {
        Intrinsics.checkNotNullParameter(a6, "a");
        Intrinsics.checkNotNullParameter(b9, "b");
        for (int i11 = 0; i11 < i10; i11++) {
            if (a6[i11 + i8] != b9[i11 + i9]) {
                return false;
            }
        }
        return true;
    }

    public static final void b(long j8, long j10, long j11) {
        if ((j10 | j11) < 0 || j10 > j8 || j8 - j10 < j11) {
            throw new ArrayIndexOutOfBoundsException("size=" + j8 + " offset=" + j10 + " byteCount=" + j11);
        }
    }
}
