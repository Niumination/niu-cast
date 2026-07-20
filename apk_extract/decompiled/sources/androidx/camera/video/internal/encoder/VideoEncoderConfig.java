package androidx.camera.video.internal.encoder;

import android.media.MediaFormat;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.Timebase;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public abstract class VideoEncoderConfig implements EncoderConfig {
    private static final int VIDEO_COLOR_FORMAT_DEFAULT = 2130708361;
    private static final int VIDEO_INTRA_FRAME_INTERVAL_DEFAULT = 1;

    public static abstract class Builder {
        @NonNull
        public abstract VideoEncoderConfig build();

        @NonNull
        public abstract Builder setBitrate(int i8);

        @NonNull
        public abstract Builder setColorFormat(int i8);

        @NonNull
        public abstract Builder setFrameRate(int i8);

        @NonNull
        public abstract Builder setIFrameInterval(int i8);

        @NonNull
        public abstract Builder setInputTimebase(@NonNull Timebase timebase);

        @NonNull
        public abstract Builder setMimeType(@NonNull String str);

        @NonNull
        public abstract Builder setProfile(int i8);

        @NonNull
        public abstract Builder setResolution(@NonNull Size size);
    }

    @NonNull
    public static Builder builder() {
        return new AutoValue_VideoEncoderConfig.Builder().setProfile(EncoderConfig.CODEC_PROFILE_NONE).setIFrameInterval(1).setColorFormat(VIDEO_COLOR_FORMAT_DEFAULT);
    }

    public abstract int getBitrate();

    public abstract int getColorFormat();

    public abstract int getFrameRate();

    public abstract int getIFrameInterval();

    @Override // androidx.camera.video.internal.encoder.EncoderConfig
    @NonNull
    public abstract Timebase getInputTimebase();

    @Override // androidx.camera.video.internal.encoder.EncoderConfig
    @NonNull
    public abstract String getMimeType();

    @Override // androidx.camera.video.internal.encoder.EncoderConfig
    public abstract int getProfile();

    @NonNull
    public abstract Size getResolution();

    @Override // androidx.camera.video.internal.encoder.EncoderConfig
    @NonNull
    public MediaFormat toMediaFormat() {
        Size resolution = getResolution();
        MediaFormat mediaFormatCreateVideoFormat = MediaFormat.createVideoFormat(getMimeType(), resolution.getWidth(), resolution.getHeight());
        mediaFormatCreateVideoFormat.setInteger("color-format", getColorFormat());
        mediaFormatCreateVideoFormat.setInteger("bitrate", getBitrate());
        mediaFormatCreateVideoFormat.setInteger("frame-rate", getFrameRate());
        mediaFormatCreateVideoFormat.setInteger("i-frame-interval", getIFrameInterval());
        if (getProfile() != EncoderConfig.CODEC_PROFILE_NONE) {
            mediaFormatCreateVideoFormat.setInteger("profile", getProfile());
        }
        return mediaFormatCreateVideoFormat;
    }
}
