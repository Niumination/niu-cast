package androidx.camera.video;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.camera.video.internal.encoder.EncoderConfig;
import androidx.core.util.Consumer;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
@RestrictTo({RestrictTo.Scope.LIBRARY})
public abstract class MediaSpec {
    private static final int AAC_DEFAULT_PROFILE = 2;
    private static final String AUDIO_ENCODER_MIME_MPEG4_DEFAULT = "audio/mp4a-latm";
    private static final String AUDIO_ENCODER_MIME_WEBM_DEFAULT = "audio/vorbis";
    public static final int OUTPUT_FORMAT_AUTO = -1;
    public static final int OUTPUT_FORMAT_MPEG_4 = 0;
    public static final int OUTPUT_FORMAT_WEBM = 1;
    private static final String VIDEO_ENCODER_MIME_MPEG4_DEFAULT = "video/avc";
    private static final String VIDEO_ENCODER_MIME_WEBM_DEFAULT = "video/x-vnd.on2.vp8";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static abstract class Builder {
        @NonNull
        public abstract MediaSpec build();

        @NonNull
        public Builder configureAudio(@NonNull Consumer<AudioSpec.Builder> consumer) {
            AudioSpec.Builder builder = getAudioSpec().toBuilder();
            consumer.accept(builder);
            setAudioSpec(builder.build());
            return this;
        }

        @NonNull
        public Builder configureVideo(@NonNull Consumer<VideoSpec.Builder> consumer) {
            VideoSpec.Builder builder = getVideoSpec().toBuilder();
            consumer.accept(builder);
            setVideoSpec(builder.build());
            return this;
        }

        public abstract AudioSpec getAudioSpec();

        public abstract VideoSpec getVideoSpec();

        @NonNull
        public abstract Builder setAudioSpec(@NonNull AudioSpec audioSpec);

        @NonNull
        public abstract Builder setOutputFormat(int i8);

        @NonNull
        public abstract Builder setVideoSpec(@NonNull VideoSpec videoSpec);
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface OutputFormat {
    }

    @NonNull
    public static Builder builder() {
        return new AutoValue_MediaSpec.Builder().setOutputFormat(-1).setAudioSpec(AudioSpec.builder().build()).setVideoSpec(VideoSpec.builder().build());
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static String outputFormatToAudioMime(int i8) {
        return i8 != 1 ? AUDIO_ENCODER_MIME_MPEG4_DEFAULT : AUDIO_ENCODER_MIME_WEBM_DEFAULT;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static int outputFormatToAudioProfile(int i8) {
        if (Objects.equals(outputFormatToAudioMime(i8), AUDIO_ENCODER_MIME_MPEG4_DEFAULT)) {
            return 2;
        }
        return EncoderConfig.CODEC_PROFILE_NONE;
    }

    public static int outputFormatToMuxerFormat(int i8) {
        return i8 != 1 ? 0 : 1;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static String outputFormatToVideoMime(int i8) {
        return i8 != 1 ? VIDEO_ENCODER_MIME_MPEG4_DEFAULT : VIDEO_ENCODER_MIME_WEBM_DEFAULT;
    }

    @NonNull
    public abstract AudioSpec getAudioSpec();

    public abstract int getOutputFormat();

    @NonNull
    public abstract VideoSpec getVideoSpec();

    @NonNull
    public abstract Builder toBuilder();
}
