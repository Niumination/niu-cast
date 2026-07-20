package androidx.camera.video.internal.encoder;

import android.util.Size;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.Timebase;

/* JADX INFO: loaded from: classes.dex */
final class AutoValue_VideoEncoderConfig extends VideoEncoderConfig {
    private final int IFrameInterval;
    private final int bitrate;
    private final int colorFormat;
    private final int frameRate;
    private final Timebase inputTimebase;
    private final String mimeType;
    private final int profile;
    private final Size resolution;

    public static final class Builder extends VideoEncoderConfig.Builder {
        private Integer IFrameInterval;
        private Integer bitrate;
        private Integer colorFormat;
        private Integer frameRate;
        private Timebase inputTimebase;
        private String mimeType;
        private Integer profile;
        private Size resolution;

        @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig.Builder
        public VideoEncoderConfig build() {
            String strB = this.mimeType == null ? " mimeType" : "";
            if (this.profile == null) {
                strB = h0.a.B(strB, " profile");
            }
            if (this.inputTimebase == null) {
                strB = h0.a.B(strB, " inputTimebase");
            }
            if (this.resolution == null) {
                strB = h0.a.B(strB, " resolution");
            }
            if (this.colorFormat == null) {
                strB = h0.a.B(strB, " colorFormat");
            }
            if (this.frameRate == null) {
                strB = h0.a.B(strB, " frameRate");
            }
            if (this.IFrameInterval == null) {
                strB = h0.a.B(strB, " IFrameInterval");
            }
            if (this.bitrate == null) {
                strB = h0.a.B(strB, " bitrate");
            }
            if (strB.isEmpty()) {
                return new AutoValue_VideoEncoderConfig(this.mimeType, this.profile.intValue(), this.inputTimebase, this.resolution, this.colorFormat.intValue(), this.frameRate.intValue(), this.IFrameInterval.intValue(), this.bitrate.intValue());
            }
            throw new IllegalStateException("Missing required properties:".concat(strB));
        }

        @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig.Builder
        public VideoEncoderConfig.Builder setBitrate(int i8) {
            this.bitrate = Integer.valueOf(i8);
            return this;
        }

        @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig.Builder
        public VideoEncoderConfig.Builder setColorFormat(int i8) {
            this.colorFormat = Integer.valueOf(i8);
            return this;
        }

        @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig.Builder
        public VideoEncoderConfig.Builder setFrameRate(int i8) {
            this.frameRate = Integer.valueOf(i8);
            return this;
        }

        @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig.Builder
        public VideoEncoderConfig.Builder setIFrameInterval(int i8) {
            this.IFrameInterval = Integer.valueOf(i8);
            return this;
        }

        @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig.Builder
        public VideoEncoderConfig.Builder setInputTimebase(Timebase timebase) {
            if (timebase == null) {
                throw new NullPointerException("Null inputTimebase");
            }
            this.inputTimebase = timebase;
            return this;
        }

        @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig.Builder
        public VideoEncoderConfig.Builder setMimeType(String str) {
            if (str == null) {
                throw new NullPointerException("Null mimeType");
            }
            this.mimeType = str;
            return this;
        }

        @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig.Builder
        public VideoEncoderConfig.Builder setProfile(int i8) {
            this.profile = Integer.valueOf(i8);
            return this;
        }

        @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig.Builder
        public VideoEncoderConfig.Builder setResolution(Size size) {
            if (size == null) {
                throw new NullPointerException("Null resolution");
            }
            this.resolution = size;
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof VideoEncoderConfig)) {
            return false;
        }
        VideoEncoderConfig videoEncoderConfig = (VideoEncoderConfig) obj;
        return this.mimeType.equals(videoEncoderConfig.getMimeType()) && this.profile == videoEncoderConfig.getProfile() && this.inputTimebase.equals(videoEncoderConfig.getInputTimebase()) && this.resolution.equals(videoEncoderConfig.getResolution()) && this.colorFormat == videoEncoderConfig.getColorFormat() && this.frameRate == videoEncoderConfig.getFrameRate() && this.IFrameInterval == videoEncoderConfig.getIFrameInterval() && this.bitrate == videoEncoderConfig.getBitrate();
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig
    public int getBitrate() {
        return this.bitrate;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig
    public int getColorFormat() {
        return this.colorFormat;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig
    public int getFrameRate() {
        return this.frameRate;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig
    public int getIFrameInterval() {
        return this.IFrameInterval;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig, androidx.camera.video.internal.encoder.EncoderConfig
    @NonNull
    public Timebase getInputTimebase() {
        return this.inputTimebase;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig, androidx.camera.video.internal.encoder.EncoderConfig
    @NonNull
    public String getMimeType() {
        return this.mimeType;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig, androidx.camera.video.internal.encoder.EncoderConfig
    public int getProfile() {
        return this.profile;
    }

    @Override // androidx.camera.video.internal.encoder.VideoEncoderConfig
    @NonNull
    public Size getResolution() {
        return this.resolution;
    }

    public int hashCode() {
        return this.bitrate ^ ((((((((((((((this.mimeType.hashCode() ^ 1000003) * 1000003) ^ this.profile) * 1000003) ^ this.inputTimebase.hashCode()) * 1000003) ^ this.resolution.hashCode()) * 1000003) ^ this.colorFormat) * 1000003) ^ this.frameRate) * 1000003) ^ this.IFrameInterval) * 1000003);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("VideoEncoderConfig{mimeType=");
        sb2.append(this.mimeType);
        sb2.append(", profile=");
        sb2.append(this.profile);
        sb2.append(", inputTimebase=");
        sb2.append(this.inputTimebase);
        sb2.append(", resolution=");
        sb2.append(this.resolution);
        sb2.append(", colorFormat=");
        sb2.append(this.colorFormat);
        sb2.append(", frameRate=");
        sb2.append(this.frameRate);
        sb2.append(", IFrameInterval=");
        sb2.append(this.IFrameInterval);
        sb2.append(", bitrate=");
        return h0.a.m(sb2, "}", this.bitrate);
    }

    private AutoValue_VideoEncoderConfig(String str, int i8, Timebase timebase, Size size, int i9, int i10, int i11, int i12) {
        this.mimeType = str;
        this.profile = i8;
        this.inputTimebase = timebase;
        this.resolution = size;
        this.colorFormat = i9;
        this.frameRate = i10;
        this.IFrameInterval = i11;
        this.bitrate = i12;
    }
}
