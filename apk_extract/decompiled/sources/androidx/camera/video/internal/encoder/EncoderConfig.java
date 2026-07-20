package androidx.camera.video.internal.encoder;

import android.media.MediaFormat;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.CamcorderProfileProxy;
import androidx.camera.core.impl.Timebase;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public interface EncoderConfig {
    public static final int CODEC_PROFILE_NONE = CamcorderProfileProxy.CODEC_PROFILE_NONE;

    @NonNull
    Timebase getInputTimebase();

    @NonNull
    String getMimeType();

    int getProfile();

    @NonNull
    MediaFormat toMediaFormat() throws InvalidConfigException;
}
