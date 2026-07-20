package androidx.camera.core.impl.compat;

import android.media.CamcorderProfile;
import android.media.EncoderProfiles;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.EncoderProfilesProxy;
import h0.a;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public final class EncoderProfilesProxyCompat {
    private EncoderProfilesProxyCompat() {
    }

    @NonNull
    @RequiresApi(31)
    public static EncoderProfilesProxy from(@NonNull EncoderProfiles encoderProfiles) {
        return EncoderProfilesProxyCompatApi33Impl.from(encoderProfiles);
    }

    @NonNull
    public static EncoderProfilesProxy from(@NonNull CamcorderProfile camcorderProfile) {
        throw new RuntimeException(a.h(Build.VERSION.SDK_INT, "Should not use from(CamcorderProfile) on API ", ". CamcorderProfile is deprecated on API 31, use from(EncoderProfiles) instead."));
    }
}
