package androidx.camera.video.internal.workaround;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.Timebase;
import androidx.camera.video.internal.encoder.TimeProvider;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public class VideoTimebaseConverter {
    private static final String TAG = "VideoTimebaseConverter";
    private Timebase mInputTimebase;
    private final TimeProvider mTimeProvider;
    private long mUptimeToRealtimeOffsetUs = -1;

    /* JADX INFO: renamed from: androidx.camera.video.internal.workaround.VideoTimebaseConverter$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$camera$core$impl$Timebase;

        static {
            int[] iArr = new int[Timebase.values().length];
            $SwitchMap$androidx$camera$core$impl$Timebase = iArr;
            try {
                iArr[Timebase.REALTIME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$camera$core$impl$Timebase[Timebase.UPTIME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public VideoTimebaseConverter(@NonNull TimeProvider timeProvider, @Nullable Timebase timebase) {
        this.mTimeProvider = timeProvider;
        this.mInputTimebase = timebase;
    }

    private long calculateUptimeToRealtimeOffsetUs() {
        long j8 = Long.MAX_VALUE;
        long j10 = 0;
        for (int i8 = 0; i8 < 3; i8++) {
            long jUptimeUs = this.mTimeProvider.uptimeUs();
            long jRealtimeUs = this.mTimeProvider.realtimeUs();
            long jUptimeUs2 = this.mTimeProvider.uptimeUs();
            long j11 = jUptimeUs2 - jUptimeUs;
            if (i8 == 0 || j11 < j8) {
                j10 = jRealtimeUs - ((jUptimeUs + jUptimeUs2) >> 1);
                j8 = j11;
            }
        }
        return Math.max(0L, j10);
    }

    private boolean isCloseToRealtime(long j8) {
        return Math.abs(j8 - this.mTimeProvider.realtimeUs()) < Math.abs(j8 - this.mTimeProvider.uptimeUs());
    }

    public long convertToUptimeUs(long j8) {
        if (this.mInputTimebase == null) {
            if (isCloseToRealtime(j8)) {
                Logger.w(TAG, "Detected video buffer timestamp is close to realtime.");
                this.mInputTimebase = Timebase.REALTIME;
            } else {
                this.mInputTimebase = Timebase.UPTIME;
            }
        }
        int i8 = AnonymousClass1.$SwitchMap$androidx$camera$core$impl$Timebase[this.mInputTimebase.ordinal()];
        if (i8 == 1) {
            if (this.mUptimeToRealtimeOffsetUs == -1) {
                this.mUptimeToRealtimeOffsetUs = calculateUptimeToRealtimeOffsetUs();
            }
            return j8 - this.mUptimeToRealtimeOffsetUs;
        }
        if (i8 == 2) {
            return j8;
        }
        throw new AssertionError("Unknown timebase: " + this.mInputTimebase);
    }
}
