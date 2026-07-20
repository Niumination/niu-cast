package androidx.camera.video.internal.workaround;

import a1.a;
import android.util.Range;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.Logger;
import androidx.camera.video.internal.compat.quirk.DeviceQuirks;
import androidx.camera.video.internal.compat.quirk.MediaCodecInfoReportIncorrectInfoQuirk;
import androidx.camera.video.internal.encoder.VideoEncoderInfo;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public class VideoEncoderInfoWrapper implements VideoEncoderInfo {
    private static final int HEIGHT_4KDCI = 2160;
    private static final String TAG = "VideoEncoderInfoWrapper";
    private static final int WIDTH_4KDCI = 4096;
    private final Range<Integer> mSupportedHeights;
    private final Range<Integer> mSupportedWidths;
    private final VideoEncoderInfo mVideoEncoderInfo;

    public VideoEncoderInfoWrapper(@NonNull VideoEncoderInfo videoEncoderInfo) {
        this.mVideoEncoderInfo = videoEncoderInfo;
        int widthAlignment = videoEncoderInfo.getWidthAlignment();
        this.mSupportedWidths = Range.create(Integer.valueOf(widthAlignment), Integer.valueOf(((int) Math.ceil(4096.0d / ((double) widthAlignment))) * widthAlignment));
        int heightAlignment = videoEncoderInfo.getHeightAlignment();
        this.mSupportedHeights = Range.create(Integer.valueOf(heightAlignment), Integer.valueOf(((int) Math.ceil(2160.0d / ((double) heightAlignment))) * heightAlignment));
    }

    @NonNull
    public static VideoEncoderInfo from(@NonNull VideoEncoderInfo videoEncoderInfo, @Nullable Size size) {
        if (videoEncoderInfo instanceof VideoEncoderInfoWrapper) {
            return videoEncoderInfo;
        }
        if (DeviceQuirks.get(MediaCodecInfoReportIncorrectInfoQuirk.class) == null) {
            if (size == null || videoEncoderInfo.isSizeSupported(size.getWidth(), size.getHeight())) {
                return videoEncoderInfo;
            }
            Logger.w(TAG, "Detected that the device does not support a size " + size + " that should be valid in widths/heights = " + videoEncoderInfo.getSupportedWidths() + "/" + videoEncoderInfo.getSupportedHeights());
        }
        return new VideoEncoderInfoWrapper(videoEncoderInfo);
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public int getHeightAlignment() {
        return this.mVideoEncoderInfo.getHeightAlignment();
    }

    @Override // androidx.camera.video.internal.encoder.EncoderInfo
    @NonNull
    public String getName() {
        return this.mVideoEncoderInfo.getName();
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    @NonNull
    public Range<Integer> getSupportedBitrateRange() {
        return this.mVideoEncoderInfo.getSupportedBitrateRange();
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    @NonNull
    public Range<Integer> getSupportedHeights() {
        return this.mSupportedHeights;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    @NonNull
    public Range<Integer> getSupportedHeightsFor(int i8) {
        boolean z2 = this.mSupportedWidths.contains(Integer.valueOf(i8)) && i8 % this.mVideoEncoderInfo.getWidthAlignment() == 0;
        StringBuilder sbU = a.u(i8, "Not supported width: ", " which is not in ");
        sbU.append(this.mSupportedWidths);
        sbU.append(" or can not be divided by alignment ");
        sbU.append(this.mVideoEncoderInfo.getWidthAlignment());
        Preconditions.checkArgument(z2, sbU.toString());
        return this.mSupportedHeights;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    @NonNull
    public Range<Integer> getSupportedWidths() {
        return this.mSupportedWidths;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    @NonNull
    public Range<Integer> getSupportedWidthsFor(int i8) {
        boolean z2 = this.mSupportedHeights.contains(Integer.valueOf(i8)) && i8 % this.mVideoEncoderInfo.getHeightAlignment() == 0;
        StringBuilder sbU = a.u(i8, "Not supported height: ", " which is not in ");
        sbU.append(this.mSupportedHeights);
        sbU.append(" or can not be divided by alignment ");
        sbU.append(this.mVideoEncoderInfo.getHeightAlignment());
        Preconditions.checkArgument(z2, sbU.toString());
        return this.mSupportedWidths;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public int getWidthAlignment() {
        return this.mVideoEncoderInfo.getWidthAlignment();
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderInfo
    public boolean isSizeSupported(int i8, int i9) {
        return this.mSupportedWidths.contains(Integer.valueOf(i8)) && this.mSupportedHeights.contains(Integer.valueOf(i9)) && i8 % this.mVideoEncoderInfo.getWidthAlignment() == 0 && i9 % this.mVideoEncoderInfo.getHeightAlignment() == 0;
    }
}
