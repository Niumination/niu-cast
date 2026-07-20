package androidx.camera.video;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public abstract class RecordingStats {
    @NonNull
    public static RecordingStats of(long j8, long j10, @NonNull AudioStats audioStats) {
        Preconditions.checkArgument(j8 >= 0, "duration must be positive value.");
        Preconditions.checkArgument(j10 >= 0, "bytes must be positive value.");
        return new AutoValue_RecordingStats(j8, j10, audioStats);
    }

    @NonNull
    public abstract AudioStats getAudioStats();

    public abstract long getNumBytesRecorded();

    public abstract long getRecordedDurationNanos();
}
