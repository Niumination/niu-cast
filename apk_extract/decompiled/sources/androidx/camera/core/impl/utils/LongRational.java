package androidx.camera.core.impl.utils;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.work.WorkRequest;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
final class LongRational {
    private final long mDenominator;
    private final long mNumerator;

    public LongRational(long j8, long j10) {
        this.mNumerator = j8;
        this.mDenominator = j10;
    }

    public long getDenominator() {
        return this.mDenominator;
    }

    public long getNumerator() {
        return this.mNumerator;
    }

    public double toDouble() {
        return this.mNumerator / this.mDenominator;
    }

    @NonNull
    public String toString() {
        return this.mNumerator + "/" + this.mDenominator;
    }

    public LongRational(double d7) {
        this((long) (d7 * 10000.0d), WorkRequest.MIN_BACKOFF_MILLIS);
    }
}
