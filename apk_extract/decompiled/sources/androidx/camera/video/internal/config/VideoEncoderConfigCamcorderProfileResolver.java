package androidx.camera.video.internal.config;

import android.util.Range;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CamcorderProfileProxy;
import androidx.camera.core.impl.Timebase;
import androidx.camera.video.VideoSpec;
import androidx.camera.video.internal.encoder.VideoEncoderConfig;
import androidx.core.util.Supplier;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public class VideoEncoderConfigCamcorderProfileResolver implements Supplier<VideoEncoderConfig> {
    private static final String TAG = "VidEncCmcrdrPrflRslvr";
    private final CamcorderProfileProxy mCamcorderProfile;

    @Nullable
    private final Range<Integer> mExpectedFrameRateRange;
    private final Timebase mInputTimebase;
    private final String mMimeType;
    private final Size mSurfaceSize;
    private final VideoSpec mVideoSpec;

    public VideoEncoderConfigCamcorderProfileResolver(@NonNull String str, @NonNull Timebase timebase, @NonNull VideoSpec videoSpec, @NonNull Size size, @NonNull CamcorderProfileProxy camcorderProfileProxy, @Nullable Range<Integer> range) {
        this.mMimeType = str;
        this.mInputTimebase = timebase;
        this.mVideoSpec = videoSpec;
        this.mSurfaceSize = size;
        this.mCamcorderProfile = camcorderProfileProxy;
        this.mExpectedFrameRateRange = range;
    }

    private int resolveFrameRate() {
        Range<Integer> frameRate = this.mVideoSpec.getFrameRate();
        int videoFrameRate = this.mCamcorderProfile.getVideoFrameRate();
        Logger.d(TAG, String.format("Frame rate from camcorder profile: %dfps. [Requested range: %s, Expected operating range: %s]", Integer.valueOf(videoFrameRate), frameRate, this.mExpectedFrameRateRange));
        return VideoConfigUtil.resolveFrameRate(frameRate, videoFrameRate, this.mExpectedFrameRateRange);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.core.util.Supplier
    @NonNull
    public VideoEncoderConfig get() {
        int iResolveFrameRate = resolveFrameRate();
        Logger.d(TAG, "Resolved VIDEO frame rate: " + iResolveFrameRate + "fps");
        Range<Integer> bitrate = this.mVideoSpec.getBitrate();
        Logger.d(TAG, "Using resolved VIDEO bitrate from CamcorderProfile");
        return VideoEncoderConfig.builder().setMimeType(this.mMimeType).setInputTimebase(this.mInputTimebase).setResolution(this.mSurfaceSize).setBitrate(VideoConfigUtil.scaleAndClampBitrate(this.mCamcorderProfile.getVideoBitRate(), iResolveFrameRate, this.mCamcorderProfile.getVideoFrameRate(), this.mSurfaceSize.getWidth(), this.mCamcorderProfile.getVideoFrameWidth(), this.mSurfaceSize.getHeight(), this.mCamcorderProfile.getVideoFrameHeight(), bitrate)).setFrameRate(iResolveFrameRate).build();
    }
}
