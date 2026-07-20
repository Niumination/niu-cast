package androidx.camera.video.internal.config;

import android.util.Range;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.Timebase;
import androidx.camera.video.VideoSpec;
import androidx.camera.video.internal.encoder.VideoEncoderConfig;
import androidx.core.util.Supplier;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public class VideoEncoderConfigDefaultResolver implements Supplier<VideoEncoderConfig> {
    private static final String TAG = "VidEncCfgDefaultRslvr";
    private static final int VIDEO_BITRATE_BASE = 14000000;
    private static final int VIDEO_FRAME_RATE_BASE = 30;
    private static final int VIDEO_FRAME_RATE_FIXED_DEFAULT = 30;

    @Nullable
    private final Range<Integer> mExpectedFrameRateRange;
    private final Timebase mInputTimebase;
    private final String mMimeType;
    private final Size mSurfaceSize;
    private final VideoSpec mVideoSpec;
    private static final Size VIDEO_SIZE_BASE = new Size(1280, 720);
    private static final Range<Integer> VALID_FRAME_RATE_RANGE = new Range<>(1, 60);

    public VideoEncoderConfigDefaultResolver(@NonNull String str, @NonNull Timebase timebase, @NonNull VideoSpec videoSpec, @NonNull Size size, @Nullable Range<Integer> range) {
        this.mMimeType = str;
        this.mInputTimebase = timebase;
        this.mVideoSpec = videoSpec;
        this.mSurfaceSize = size;
        this.mExpectedFrameRateRange = range;
    }

    private int resolveFrameRate() {
        Range<Integer> frameRate = this.mVideoSpec.getFrameRate();
        int iIntValue = !VideoSpec.FRAME_RATE_RANGE_AUTO.equals(frameRate) ? ((Integer) VALID_FRAME_RATE_RANGE.clamp((Integer) frameRate.getUpper())).intValue() : 30;
        Logger.d(TAG, String.format("Frame rate default: %dfps. [Requested range: %s, Expected operating range: %s]", Integer.valueOf(iIntValue), frameRate, this.mExpectedFrameRateRange));
        return VideoConfigUtil.resolveFrameRate(frameRate, iIntValue, this.mExpectedFrameRateRange);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.core.util.Supplier
    @NonNull
    public VideoEncoderConfig get() {
        int iResolveFrameRate = resolveFrameRate();
        Logger.d(TAG, "Resolved VIDEO frame rate: " + iResolveFrameRate + "fps");
        Range<Integer> bitrate = this.mVideoSpec.getBitrate();
        Logger.d(TAG, "Using fallback VIDEO bitrate");
        int width = this.mSurfaceSize.getWidth();
        Size size = VIDEO_SIZE_BASE;
        return VideoEncoderConfig.builder().setMimeType(this.mMimeType).setInputTimebase(this.mInputTimebase).setResolution(this.mSurfaceSize).setBitrate(VideoConfigUtil.scaleAndClampBitrate(VIDEO_BITRATE_BASE, iResolveFrameRate, 30, width, size.getWidth(), this.mSurfaceSize.getHeight(), size.getHeight(), bitrate)).setFrameRate(iResolveFrameRate).build();
    }
}
