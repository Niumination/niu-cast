package androidx.camera.video.internal.config;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.impl.CamcorderProfileProxy;
import h0.a;

/* JADX INFO: loaded from: classes.dex */
final class AutoValue_MimeInfo extends MimeInfo {
    private final CamcorderProfileProxy compatibleCamcorderProfile;
    private final String mimeType;
    private final int profile;

    public static final class Builder extends MimeInfo.Builder {
        private CamcorderProfileProxy compatibleCamcorderProfile;
        private String mimeType;
        private Integer profile;

        @Override // androidx.camera.video.internal.config.MimeInfo.Builder
        public MimeInfo build() {
            String strB = this.mimeType == null ? " mimeType" : "";
            if (this.profile == null) {
                strB = a.B(strB, " profile");
            }
            if (strB.isEmpty()) {
                return new AutoValue_MimeInfo(this.mimeType, this.profile.intValue(), this.compatibleCamcorderProfile);
            }
            throw new IllegalStateException("Missing required properties:".concat(strB));
        }

        @Override // androidx.camera.video.internal.config.MimeInfo.Builder
        public MimeInfo.Builder setCompatibleCamcorderProfile(@Nullable CamcorderProfileProxy camcorderProfileProxy) {
            this.compatibleCamcorderProfile = camcorderProfileProxy;
            return this;
        }

        @Override // androidx.camera.video.internal.config.MimeInfo.Builder
        public MimeInfo.Builder setMimeType(String str) {
            if (str == null) {
                throw new NullPointerException("Null mimeType");
            }
            this.mimeType = str;
            return this;
        }

        @Override // androidx.camera.video.internal.config.MimeInfo.Builder
        public MimeInfo.Builder setProfile(int i8) {
            this.profile = Integer.valueOf(i8);
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MimeInfo)) {
            return false;
        }
        MimeInfo mimeInfo = (MimeInfo) obj;
        if (this.mimeType.equals(mimeInfo.getMimeType()) && this.profile == mimeInfo.getProfile()) {
            CamcorderProfileProxy camcorderProfileProxy = this.compatibleCamcorderProfile;
            if (camcorderProfileProxy == null) {
                if (mimeInfo.getCompatibleCamcorderProfile() == null) {
                    return true;
                }
            } else if (camcorderProfileProxy.equals(mimeInfo.getCompatibleCamcorderProfile())) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.video.internal.config.MimeInfo
    @Nullable
    public CamcorderProfileProxy getCompatibleCamcorderProfile() {
        return this.compatibleCamcorderProfile;
    }

    @Override // androidx.camera.video.internal.config.MimeInfo
    @NonNull
    public String getMimeType() {
        return this.mimeType;
    }

    @Override // androidx.camera.video.internal.config.MimeInfo
    public int getProfile() {
        return this.profile;
    }

    public int hashCode() {
        int iHashCode = (((this.mimeType.hashCode() ^ 1000003) * 1000003) ^ this.profile) * 1000003;
        CamcorderProfileProxy camcorderProfileProxy = this.compatibleCamcorderProfile;
        return (camcorderProfileProxy == null ? 0 : camcorderProfileProxy.hashCode()) ^ iHashCode;
    }

    public String toString() {
        return "MimeInfo{mimeType=" + this.mimeType + ", profile=" + this.profile + ", compatibleCamcorderProfile=" + this.compatibleCamcorderProfile + "}";
    }

    private AutoValue_MimeInfo(String str, int i8, @Nullable CamcorderProfileProxy camcorderProfileProxy) {
        this.mimeType = str;
        this.profile = i8;
        this.compatibleCamcorderProfile = camcorderProfileProxy;
    }
}
