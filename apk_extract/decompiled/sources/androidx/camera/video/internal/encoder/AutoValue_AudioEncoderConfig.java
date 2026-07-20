package androidx.camera.video.internal.encoder;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.Timebase;

/* JADX INFO: loaded from: classes.dex */
final class AutoValue_AudioEncoderConfig extends AudioEncoderConfig {
    private final int bitrate;
    private final int channelCount;
    private final Timebase inputTimebase;
    private final String mimeType;
    private final int profile;
    private final int sampleRate;

    public static final class Builder extends AudioEncoderConfig.Builder {
        private Integer bitrate;
        private Integer channelCount;
        private Timebase inputTimebase;
        private String mimeType;
        private Integer profile;
        private Integer sampleRate;

        @Override // androidx.camera.video.internal.encoder.AudioEncoderConfig.Builder
        public AudioEncoderConfig autoBuild() {
            String strB = this.mimeType == null ? " mimeType" : "";
            if (this.profile == null) {
                strB = h0.a.B(strB, " profile");
            }
            if (this.inputTimebase == null) {
                strB = h0.a.B(strB, " inputTimebase");
            }
            if (this.bitrate == null) {
                strB = h0.a.B(strB, " bitrate");
            }
            if (this.sampleRate == null) {
                strB = h0.a.B(strB, " sampleRate");
            }
            if (this.channelCount == null) {
                strB = h0.a.B(strB, " channelCount");
            }
            if (strB.isEmpty()) {
                return new AutoValue_AudioEncoderConfig(this.mimeType, this.profile.intValue(), this.inputTimebase, this.bitrate.intValue(), this.sampleRate.intValue(), this.channelCount.intValue());
            }
            throw new IllegalStateException("Missing required properties:".concat(strB));
        }

        @Override // androidx.camera.video.internal.encoder.AudioEncoderConfig.Builder
        public AudioEncoderConfig.Builder setBitrate(int i8) {
            this.bitrate = Integer.valueOf(i8);
            return this;
        }

        @Override // androidx.camera.video.internal.encoder.AudioEncoderConfig.Builder
        public AudioEncoderConfig.Builder setChannelCount(int i8) {
            this.channelCount = Integer.valueOf(i8);
            return this;
        }

        @Override // androidx.camera.video.internal.encoder.AudioEncoderConfig.Builder
        public AudioEncoderConfig.Builder setInputTimebase(Timebase timebase) {
            if (timebase == null) {
                throw new NullPointerException("Null inputTimebase");
            }
            this.inputTimebase = timebase;
            return this;
        }

        @Override // androidx.camera.video.internal.encoder.AudioEncoderConfig.Builder
        public AudioEncoderConfig.Builder setMimeType(String str) {
            if (str == null) {
                throw new NullPointerException("Null mimeType");
            }
            this.mimeType = str;
            return this;
        }

        @Override // androidx.camera.video.internal.encoder.AudioEncoderConfig.Builder
        public AudioEncoderConfig.Builder setProfile(int i8) {
            this.profile = Integer.valueOf(i8);
            return this;
        }

        @Override // androidx.camera.video.internal.encoder.AudioEncoderConfig.Builder
        public AudioEncoderConfig.Builder setSampleRate(int i8) {
            this.sampleRate = Integer.valueOf(i8);
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AudioEncoderConfig)) {
            return false;
        }
        AudioEncoderConfig audioEncoderConfig = (AudioEncoderConfig) obj;
        return this.mimeType.equals(audioEncoderConfig.getMimeType()) && this.profile == audioEncoderConfig.getProfile() && this.inputTimebase.equals(audioEncoderConfig.getInputTimebase()) && this.bitrate == audioEncoderConfig.getBitrate() && this.sampleRate == audioEncoderConfig.getSampleRate() && this.channelCount == audioEncoderConfig.getChannelCount();
    }

    @Override // androidx.camera.video.internal.encoder.AudioEncoderConfig
    public int getBitrate() {
        return this.bitrate;
    }

    @Override // androidx.camera.video.internal.encoder.AudioEncoderConfig
    public int getChannelCount() {
        return this.channelCount;
    }

    @Override // androidx.camera.video.internal.encoder.AudioEncoderConfig, androidx.camera.video.internal.encoder.EncoderConfig
    @NonNull
    public Timebase getInputTimebase() {
        return this.inputTimebase;
    }

    @Override // androidx.camera.video.internal.encoder.AudioEncoderConfig, androidx.camera.video.internal.encoder.EncoderConfig
    @NonNull
    public String getMimeType() {
        return this.mimeType;
    }

    @Override // androidx.camera.video.internal.encoder.AudioEncoderConfig, androidx.camera.video.internal.encoder.EncoderConfig
    public int getProfile() {
        return this.profile;
    }

    @Override // androidx.camera.video.internal.encoder.AudioEncoderConfig
    public int getSampleRate() {
        return this.sampleRate;
    }

    public int hashCode() {
        return this.channelCount ^ ((((((((((this.mimeType.hashCode() ^ 1000003) * 1000003) ^ this.profile) * 1000003) ^ this.inputTimebase.hashCode()) * 1000003) ^ this.bitrate) * 1000003) ^ this.sampleRate) * 1000003);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("AudioEncoderConfig{mimeType=");
        sb2.append(this.mimeType);
        sb2.append(", profile=");
        sb2.append(this.profile);
        sb2.append(", inputTimebase=");
        sb2.append(this.inputTimebase);
        sb2.append(", bitrate=");
        sb2.append(this.bitrate);
        sb2.append(", sampleRate=");
        sb2.append(this.sampleRate);
        sb2.append(", channelCount=");
        return h0.a.m(sb2, "}", this.channelCount);
    }

    private AutoValue_AudioEncoderConfig(String str, int i8, Timebase timebase, int i9, int i10, int i11) {
        this.mimeType = str;
        this.profile = i8;
        this.inputTimebase = timebase;
        this.bitrate = i9;
        this.sampleRate = i10;
        this.channelCount = i11;
    }
}
