package androidx.camera.video.internal.config;

import android.util.Range;
import android.util.Rational;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CamcorderProfileProxy;
import androidx.camera.core.impl.Timebase;
import androidx.camera.video.MediaSpec;
import androidx.camera.video.VideoSpec;
import androidx.camera.video.internal.encoder.VideoEncoderConfig;
import h0.a;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public final class VideoConfigUtil {
    private static final String TAG = "VideoConfigUtil";

    private VideoConfigUtil() {
    }

    public static int resolveFrameRate(@NonNull Range<Integer> range, int i8, @Nullable Range<Integer> range2) {
        if (range2 != null) {
            try {
                range = range2.intersect(range);
            } catch (IllegalArgumentException unused) {
                return ((Integer) range.getUpper()).intValue() < ((Integer) range2.getLower()).intValue() ? ((Integer) range2.getLower()).intValue() : ((Integer) range2.getUpper()).intValue();
            }
        }
        return ((Integer) range.clamp(Integer.valueOf(i8))).intValue();
    }

    @NonNull
    public static VideoEncoderConfig resolveVideoEncoderConfig(@NonNull MimeInfo mimeInfo, @NonNull Timebase timebase, @NonNull VideoSpec videoSpec, @NonNull Size size, @Nullable Range<Integer> range) {
        return (VideoEncoderConfig) (mimeInfo.getCompatibleCamcorderProfile() != null ? new VideoEncoderConfigCamcorderProfileResolver(mimeInfo.getMimeType(), timebase, videoSpec, size, mimeInfo.getCompatibleCamcorderProfile(), range) : new VideoEncoderConfigDefaultResolver(mimeInfo.getMimeType(), timebase, videoSpec, size, range)).get();
    }

    @NonNull
    public static MimeInfo resolveVideoMimeInfo(@NonNull MediaSpec mediaSpec, @Nullable CamcorderProfileProxy camcorderProfileProxy) {
        String strOutputFormatToVideoMime = MediaSpec.outputFormatToVideoMime(mediaSpec.getOutputFormat());
        boolean z2 = false;
        if (camcorderProfileProxy != null) {
            String videoCodecMimeType = camcorderProfileProxy.getVideoCodecMimeType();
            if (videoCodecMimeType == null) {
                Logger.d(TAG, "CamcorderProfile contains undefined VIDEO mime type so cannot be used. May rely on fallback defaults to derive settings [chosen mime type: " + strOutputFormatToVideoMime + "]");
            } else {
                if (mediaSpec.getOutputFormat() == -1) {
                    Logger.d(TAG, "MediaSpec contains OUTPUT_FORMAT_AUTO. Using CamcorderProfile to derive VIDEO settings [mime type: " + videoCodecMimeType + "]");
                } else if (Objects.equals(strOutputFormatToVideoMime, videoCodecMimeType)) {
                    Logger.d(TAG, "MediaSpec video mime matches CamcorderProfile. Using CamcorderProfile to derive VIDEO settings [mime type: " + videoCodecMimeType + "]");
                } else {
                    Logger.d(TAG, a.l("MediaSpec video mime does not match CamcorderProfile, so CamcorderProfile settings cannot be used. May rely on fallback defaults to derive VIDEO settings [CamcorderProfile mime type: ", videoCodecMimeType, ", chosen mime type: ", strOutputFormatToVideoMime, "]"));
                }
                strOutputFormatToVideoMime = videoCodecMimeType;
                z2 = true;
            }
        } else {
            Logger.d(TAG, "No CamcorderProfile present. May rely on fallback defaults to derive VIDEO settings [chosen mime type: " + strOutputFormatToVideoMime + "]");
        }
        MimeInfo.Builder builder = MimeInfo.builder(strOutputFormatToVideoMime);
        if (z2) {
            builder.setCompatibleCamcorderProfile(camcorderProfileProxy);
        }
        return builder.build();
    }

    public static int scaleAndClampBitrate(int i8, int i9, int i10, int i11, int i12, int i13, int i14, @NonNull Range<Integer> range) {
        Rational rational = new Rational(i9, i10);
        Rational rational2 = new Rational(i11, i12);
        int iDoubleValue = (int) (new Rational(i13, i14).doubleValue() * rational2.doubleValue() * rational.doubleValue() * ((double) i8));
        String strConcat = Logger.isDebugEnabled(TAG) ? String.format("Base Bitrate(%dbps) * Frame Rate Ratio(%d / %d) * Width Ratio(%d / %d) * Height Ratio(%d / %d) = %d", Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14), Integer.valueOf(iDoubleValue)) : "";
        if (!VideoSpec.BITRATE_RANGE_AUTO.equals(range)) {
            Integer num = (Integer) range.clamp(Integer.valueOf(iDoubleValue));
            int iIntValue = num.intValue();
            if (Logger.isDebugEnabled(TAG)) {
                strConcat = strConcat.concat(String.format("\nClamped to range %s -> %dbps", range, num));
            }
            iDoubleValue = iIntValue;
        }
        Logger.d(TAG, strConcat);
        return iDoubleValue;
    }
}
