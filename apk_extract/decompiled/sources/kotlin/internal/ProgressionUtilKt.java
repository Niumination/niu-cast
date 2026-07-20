package kotlin.internal;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.PublishedApi;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a \u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0002\u001a \u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002\u001a \u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0001H\u0001\u001a \u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0001¨\u0006\u000b"}, d2 = {"mod", "", "a", "b", "", "differenceModulo", "c", "getProgressionLastElement", "start", "end", "step", "kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class ProgressionUtilKt {
    private static final int differenceModulo(int i8, int i9, int i10) {
        return mod(mod(i8, i10) - mod(i9, i10), i10);
    }

    @PublishedApi
    public static final int getProgressionLastElement(int i8, int i9, int i10) {
        if (i10 > 0) {
            return i8 >= i9 ? i9 : i9 - differenceModulo(i9, i8, i10);
        }
        if (i10 < 0) {
            return i8 <= i9 ? i9 : i9 + differenceModulo(i8, i9, -i10);
        }
        throw new IllegalArgumentException("Step is zero.");
    }

    private static final int mod(int i8, int i9) {
        int i10 = i8 % i9;
        return i10 >= 0 ? i10 : i10 + i9;
    }

    private static final long differenceModulo(long j8, long j10, long j11) {
        return mod(mod(j8, j11) - mod(j10, j11), j11);
    }

    private static final long mod(long j8, long j10) {
        long j11 = j8 % j10;
        return j11 >= 0 ? j11 : j11 + j10;
    }

    @PublishedApi
    public static final long getProgressionLastElement(long j8, long j10, long j11) {
        if (j11 > 0) {
            return j8 >= j10 ? j10 : j10 - differenceModulo(j10, j8, j11);
        }
        if (j11 < 0) {
            return j8 <= j10 ? j10 : j10 + differenceModulo(j8, j10, -j11);
        }
        throw new IllegalArgumentException("Step is zero.");
    }
}
