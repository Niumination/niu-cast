package androidx.camera.video.internal;

import androidx.annotation.IntRange;

/* JADX INFO: loaded from: classes.dex */
final class AutoValue_AudioSource_Settings extends AudioSource.Settings {
    private final int audioFormat;
    private final int audioSource;
    private final int channelCount;
    private final int sampleRate;

    public static final class Builder extends AudioSource.Settings.Builder {
        private Integer audioFormat;
        private Integer audioSource;
        private Integer channelCount;
        private Integer sampleRate;

        @Override // androidx.camera.video.internal.AudioSource.Settings.Builder
        public AudioSource.Settings autoBuild() {
            String strB = this.audioSource == null ? " audioSource" : "";
            if (this.sampleRate == null) {
                strB = h0.a.B(strB, " sampleRate");
            }
            if (this.channelCount == null) {
                strB = h0.a.B(strB, " channelCount");
            }
            if (this.audioFormat == null) {
                strB = h0.a.B(strB, " audioFormat");
            }
            if (strB.isEmpty()) {
                return new AutoValue_AudioSource_Settings(this.audioSource.intValue(), this.sampleRate.intValue(), this.channelCount.intValue(), this.audioFormat.intValue());
            }
            throw new IllegalStateException("Missing required properties:".concat(strB));
        }

        @Override // androidx.camera.video.internal.AudioSource.Settings.Builder
        public AudioSource.Settings.Builder setAudioFormat(int i8) {
            this.audioFormat = Integer.valueOf(i8);
            return this;
        }

        @Override // androidx.camera.video.internal.AudioSource.Settings.Builder
        public AudioSource.Settings.Builder setAudioSource(int i8) {
            this.audioSource = Integer.valueOf(i8);
            return this;
        }

        @Override // androidx.camera.video.internal.AudioSource.Settings.Builder
        public AudioSource.Settings.Builder setChannelCount(int i8) {
            this.channelCount = Integer.valueOf(i8);
            return this;
        }

        @Override // androidx.camera.video.internal.AudioSource.Settings.Builder
        public AudioSource.Settings.Builder setSampleRate(int i8) {
            this.sampleRate = Integer.valueOf(i8);
            return this;
        }

        public Builder() {
        }

        private Builder(AudioSource.Settings settings) {
            this.audioSource = Integer.valueOf(settings.getAudioSource());
            this.sampleRate = Integer.valueOf(settings.getSampleRate());
            this.channelCount = Integer.valueOf(settings.getChannelCount());
            this.audioFormat = Integer.valueOf(settings.getAudioFormat());
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AudioSource.Settings)) {
            return false;
        }
        AudioSource.Settings settings = (AudioSource.Settings) obj;
        return this.audioSource == settings.getAudioSource() && this.sampleRate == settings.getSampleRate() && this.channelCount == settings.getChannelCount() && this.audioFormat == settings.getAudioFormat();
    }

    @Override // androidx.camera.video.internal.AudioSource.Settings
    public int getAudioFormat() {
        return this.audioFormat;
    }

    @Override // androidx.camera.video.internal.AudioSource.Settings
    public int getAudioSource() {
        return this.audioSource;
    }

    @Override // androidx.camera.video.internal.AudioSource.Settings
    @IntRange(from = 1)
    public int getChannelCount() {
        return this.channelCount;
    }

    @Override // androidx.camera.video.internal.AudioSource.Settings
    @IntRange(from = 1)
    public int getSampleRate() {
        return this.sampleRate;
    }

    public int hashCode() {
        return this.audioFormat ^ ((((((this.audioSource ^ 1000003) * 1000003) ^ this.sampleRate) * 1000003) ^ this.channelCount) * 1000003);
    }

    @Override // androidx.camera.video.internal.AudioSource.Settings
    public AudioSource.Settings.Builder toBuilder() {
        return new Builder(this);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("Settings{audioSource=");
        sb2.append(this.audioSource);
        sb2.append(", sampleRate=");
        sb2.append(this.sampleRate);
        sb2.append(", channelCount=");
        sb2.append(this.channelCount);
        sb2.append(", audioFormat=");
        return h0.a.m(sb2, "}", this.audioFormat);
    }

    private AutoValue_AudioSource_Settings(int i8, int i9, int i10, int i11) {
        this.audioSource = i8;
        this.sampleRate = i9;
        this.channelCount = i10;
        this.audioFormat = i11;
    }
}
