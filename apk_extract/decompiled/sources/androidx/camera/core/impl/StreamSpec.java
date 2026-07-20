package androidx.camera.core.impl;

import android.util.Range;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public abstract class StreamSpec {
    public static final Range<Integer> FRAME_RATE_RANGE_UNSPECIFIED = new Range<>(0, 0);

    public static abstract class Builder {
        @NonNull
        public abstract StreamSpec build();

        @NonNull
        public abstract Builder setExpectedFrameRateRange(@NonNull Range<Integer> range);

        @NonNull
        public abstract Builder setResolution(@NonNull Size size);
    }

    @NonNull
    public static Builder builder(@NonNull Size size) {
        return new AutoValue_StreamSpec.Builder().setResolution(size).setExpectedFrameRateRange(FRAME_RATE_RANGE_UNSPECIFIED);
    }

    @NonNull
    public abstract Range<Integer> getExpectedFrameRateRange();

    @NonNull
    public abstract Size getResolution();

    @NonNull
    public abstract Builder toBuilder();
}
