package androidx.camera.video.internal.config;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.CamcorderProfileProxy;
import androidx.camera.video.internal.encoder.EncoderConfig;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public abstract class MimeInfo {

    public static abstract class Builder {
        @NonNull
        public abstract MimeInfo build();

        @NonNull
        public abstract Builder setCompatibleCamcorderProfile(@Nullable CamcorderProfileProxy camcorderProfileProxy);

        @NonNull
        public abstract Builder setMimeType(@NonNull String str);

        @NonNull
        public abstract Builder setProfile(int i8);
    }

    @NonNull
    public static Builder builder(@NonNull String str) {
        return new AutoValue_MimeInfo.Builder().setMimeType(str).setProfile(EncoderConfig.CODEC_PROFILE_NONE);
    }

    @Nullable
    public abstract CamcorderProfileProxy getCompatibleCamcorderProfile();

    @NonNull
    public abstract String getMimeType();

    public abstract int getProfile();
}
