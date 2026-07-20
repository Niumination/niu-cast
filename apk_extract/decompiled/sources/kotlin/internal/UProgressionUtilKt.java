package kotlin.internal;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.UInt;
import kotlin.ULong;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a'\u0010\u0000\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\t\u001a'\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000eH\u0001¢\u0006\u0004\b\u000f\u0010\u0006\u001a'\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0010H\u0001¢\u0006\u0004\b\u0011\u0010\t¨\u0006\u0012"}, d2 = {"differenceModulo", "Lkotlin/UInt;", "a", "b", "c", "differenceModulo-WZ9TVnA", "(III)I", "Lkotlin/ULong;", "differenceModulo-sambcqE", "(JJJ)J", "getProgressionLastElement", "start", "end", "step", "", "getProgressionLastElement-Nkh28Cs", "", "getProgressionLastElement-7ftBX0g", "kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class UProgressionUtilKt {
    /* JADX INFO: renamed from: differenceModulo-WZ9TVnA, reason: not valid java name */
    private static final int m1364differenceModuloWZ9TVnA(int i8, int i9, int i10) {
        int iRemainderUnsigned = Integer.remainderUnsigned(i8, i10);
        int iRemainderUnsigned2 = Integer.remainderUnsigned(i9, i10);
        int iCompareUnsigned = Integer.compareUnsigned(iRemainderUnsigned, iRemainderUnsigned2);
        int iM254constructorimpl = UInt.m254constructorimpl(iRemainderUnsigned - iRemainderUnsigned2);
        return iCompareUnsigned >= 0 ? iM254constructorimpl : UInt.m254constructorimpl(iM254constructorimpl + i10);
    }

    /* JADX INFO: renamed from: differenceModulo-sambcqE, reason: not valid java name */
    private static final long m1365differenceModulosambcqE(long j8, long j10, long j11) {
        long jRemainderUnsigned = Long.remainderUnsigned(j8, j11);
        long jRemainderUnsigned2 = Long.remainderUnsigned(j10, j11);
        int iCompareUnsigned = Long.compareUnsigned(jRemainderUnsigned, jRemainderUnsigned2);
        long jM333constructorimpl = ULong.m333constructorimpl(jRemainderUnsigned - jRemainderUnsigned2);
        return iCompareUnsigned >= 0 ? jM333constructorimpl : ULong.m333constructorimpl(jM333constructorimpl + j11);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    /* JADX INFO: renamed from: getProgressionLastElement-7ftBX0g, reason: not valid java name */
    public static final long m1366getProgressionLastElement7ftBX0g(long j8, long j10, long j11) {
        if (j11 > 0) {
            return Long.compareUnsigned(j8, j10) >= 0 ? j10 : ULong.m333constructorimpl(j10 - m1365differenceModulosambcqE(j10, j8, ULong.m333constructorimpl(j11)));
        }
        if (j11 < 0) {
            return Long.compareUnsigned(j8, j10) <= 0 ? j10 : ULong.m333constructorimpl(j10 + m1365differenceModulosambcqE(j8, j10, ULong.m333constructorimpl(-j11)));
        }
        throw new IllegalArgumentException("Step is zero.");
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    /* JADX INFO: renamed from: getProgressionLastElement-Nkh28Cs, reason: not valid java name */
    public static final int m1367getProgressionLastElementNkh28Cs(int i8, int i9, int i10) {
        if (i10 > 0) {
            return Integer.compareUnsigned(i8, i9) >= 0 ? i9 : UInt.m254constructorimpl(i9 - m1364differenceModuloWZ9TVnA(i9, i8, UInt.m254constructorimpl(i10)));
        }
        if (i10 < 0) {
            return Integer.compareUnsigned(i8, i9) <= 0 ? i9 : UInt.m254constructorimpl(i9 + m1364differenceModuloWZ9TVnA(i8, i9, UInt.m254constructorimpl(-i10)));
        }
        throw new IllegalArgumentException("Step is zero.");
    }
}
