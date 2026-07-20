package androidx.camera.camera2.internal;

import android.media.CamcorderProfile;
import android.media.EncoderProfiles;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.EncoderProfilesProvider;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.core.impl.compat.EncoderProfilesProxyCompat;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public class Camera2EncoderProfilesProvider implements EncoderProfilesProvider {
    private static final String TAG = "Camera2EncoderProfilesProvider";
    private final String mCameraId;
    private final boolean mHasValidCameraId;
    private final int mIntCameraId;

    @RequiresApi(31)
    public static class Api31Impl {
        private Api31Impl() {
        }

        @DoNotInline
        public static EncoderProfiles getAll(String str, int i8) {
            return CamcorderProfile.getAll(str, i8);
        }
    }

    public Camera2EncoderProfilesProvider(@NonNull String str) {
        boolean z2;
        int i8;
        this.mCameraId = str;
        try {
            i8 = Integer.parseInt(str);
            z2 = true;
        } catch (NumberFormatException unused) {
            Logger.w(TAG, "Camera id is not an integer: " + str + ", unable to create Camera2EncoderProfilesProvider");
            z2 = false;
            i8 = -1;
        }
        this.mHasValidCameraId = z2;
        this.mIntCameraId = i8;
    }

    @Nullable
    private EncoderProfilesProxy getProfilesInternal(int i8) {
        EncoderProfiles all = Api31Impl.getAll(this.mCameraId, i8);
        if (all != null) {
            return EncoderProfilesProxyCompat.from(all);
        }
        return null;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProvider
    @Nullable
    public EncoderProfilesProxy getAll(int i8) {
        if (this.mHasValidCameraId && CamcorderProfile.hasProfile(this.mIntCameraId, i8)) {
            return getProfilesInternal(i8);
        }
        return null;
    }

    @Override // androidx.camera.core.impl.EncoderProfilesProvider
    public boolean hasProfile(int i8) {
        if (this.mHasValidCameraId) {
            return CamcorderProfile.hasProfile(this.mIntCameraId, i8);
        }
        return false;
    }
}
