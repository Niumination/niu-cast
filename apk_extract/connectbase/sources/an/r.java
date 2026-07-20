package an;

import lm.a2;
import lm.f1;
import lm.w1;
import lm.z0;

/* JADX INFO: loaded from: classes3.dex */
public final class r {
    public static final int a(int i10, int i11, int i12) {
        int iRemainderUnsigned = Integer.remainderUnsigned(i10, i12);
        int iRemainderUnsigned2 = Integer.remainderUnsigned(i11, i12);
        int iCompareUnsigned = Integer.compareUnsigned(iRemainderUnsigned, iRemainderUnsigned2);
        int iM = w1.m(iRemainderUnsigned - iRemainderUnsigned2);
        return iCompareUnsigned >= 0 ? iM : iM + i12;
    }

    public static final long b(long j10, long j11, long j12) {
        long jRemainderUnsigned = Long.remainderUnsigned(j10, j12);
        long jRemainderUnsigned2 = Long.remainderUnsigned(j11, j12);
        int iCompareUnsigned = Long.compareUnsigned(jRemainderUnsigned, jRemainderUnsigned2);
        long jM = a2.m(jRemainderUnsigned - jRemainderUnsigned2);
        return iCompareUnsigned >= 0 ? jM : jM + j12;
    }

    @f1(version = "1.3")
    @z0
    public static final long c(long j10, long j11, long j12) {
        if (j12 > 0) {
            return Long.compareUnsigned(j10, j11) >= 0 ? j11 : j11 - b(j11, j10, a2.m(j12));
        }
        if (j12 < 0) {
            return Long.compareUnsigned(j10, j11) <= 0 ? j11 : j11 + b(j10, j11, a2.m(-j12));
        }
        throw new IllegalArgumentException("Step is zero.");
    }

    @f1(version = "1.3")
    @z0
    public static final int d(int i10, int i11, int i12) {
        if (i12 > 0) {
            return Integer.compareUnsigned(i10, i11) >= 0 ? i11 : i11 - a(i11, i10, w1.m(i12));
        }
        if (i12 < 0) {
            return Integer.compareUnsigned(i10, i11) <= 0 ? i11 : i11 + a(i10, i11, w1.m(-i12));
        }
        throw new IllegalArgumentException("Step is zero.");
    }
}
