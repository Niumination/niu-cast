package androidx.camera.core.impl;

/* JADX INFO: loaded from: classes.dex */
final class AutoValue_CamcorderProfileProxy extends CamcorderProfileProxy {
    private final int audioBitRate;
    private final int audioChannels;
    private final int audioCodec;
    private final int audioSampleRate;
    private final int duration;
    private final int fileFormat;
    private final int quality;
    private final int videoBitRate;
    private final int videoCodec;
    private final int videoFrameHeight;
    private final int videoFrameRate;
    private final int videoFrameWidth;

    public AutoValue_CamcorderProfileProxy(int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19) {
        this.duration = i8;
        this.quality = i9;
        this.fileFormat = i10;
        this.videoCodec = i11;
        this.videoBitRate = i12;
        this.videoFrameRate = i13;
        this.videoFrameWidth = i14;
        this.videoFrameHeight = i15;
        this.audioCodec = i16;
        this.audioBitRate = i17;
        this.audioSampleRate = i18;
        this.audioChannels = i19;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CamcorderProfileProxy)) {
            return false;
        }
        CamcorderProfileProxy camcorderProfileProxy = (CamcorderProfileProxy) obj;
        return this.duration == camcorderProfileProxy.getDuration() && this.quality == camcorderProfileProxy.getQuality() && this.fileFormat == camcorderProfileProxy.getFileFormat() && this.videoCodec == camcorderProfileProxy.getVideoCodec() && this.videoBitRate == camcorderProfileProxy.getVideoBitRate() && this.videoFrameRate == camcorderProfileProxy.getVideoFrameRate() && this.videoFrameWidth == camcorderProfileProxy.getVideoFrameWidth() && this.videoFrameHeight == camcorderProfileProxy.getVideoFrameHeight() && this.audioCodec == camcorderProfileProxy.getAudioCodec() && this.audioBitRate == camcorderProfileProxy.getAudioBitRate() && this.audioSampleRate == camcorderProfileProxy.getAudioSampleRate() && this.audioChannels == camcorderProfileProxy.getAudioChannels();
    }

    @Override // androidx.camera.core.impl.CamcorderProfileProxy
    public int getAudioBitRate() {
        return this.audioBitRate;
    }

    @Override // androidx.camera.core.impl.CamcorderProfileProxy
    public int getAudioChannels() {
        return this.audioChannels;
    }

    @Override // androidx.camera.core.impl.CamcorderProfileProxy
    public int getAudioCodec() {
        return this.audioCodec;
    }

    @Override // androidx.camera.core.impl.CamcorderProfileProxy
    public int getAudioSampleRate() {
        return this.audioSampleRate;
    }

    @Override // androidx.camera.core.impl.CamcorderProfileProxy
    public int getDuration() {
        return this.duration;
    }

    @Override // androidx.camera.core.impl.CamcorderProfileProxy
    public int getFileFormat() {
        return this.fileFormat;
    }

    @Override // androidx.camera.core.impl.CamcorderProfileProxy
    public int getQuality() {
        return this.quality;
    }

    @Override // androidx.camera.core.impl.CamcorderProfileProxy
    public int getVideoBitRate() {
        return this.videoBitRate;
    }

    @Override // androidx.camera.core.impl.CamcorderProfileProxy
    public int getVideoCodec() {
        return this.videoCodec;
    }

    @Override // androidx.camera.core.impl.CamcorderProfileProxy
    public int getVideoFrameHeight() {
        return this.videoFrameHeight;
    }

    @Override // androidx.camera.core.impl.CamcorderProfileProxy
    public int getVideoFrameRate() {
        return this.videoFrameRate;
    }

    @Override // androidx.camera.core.impl.CamcorderProfileProxy
    public int getVideoFrameWidth() {
        return this.videoFrameWidth;
    }

    public int hashCode() {
        return this.audioChannels ^ ((((((((((((((((((((((this.duration ^ 1000003) * 1000003) ^ this.quality) * 1000003) ^ this.fileFormat) * 1000003) ^ this.videoCodec) * 1000003) ^ this.videoBitRate) * 1000003) ^ this.videoFrameRate) * 1000003) ^ this.videoFrameWidth) * 1000003) ^ this.videoFrameHeight) * 1000003) ^ this.audioCodec) * 1000003) ^ this.audioBitRate) * 1000003) ^ this.audioSampleRate) * 1000003);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("CamcorderProfileProxy{duration=");
        sb2.append(this.duration);
        sb2.append(", quality=");
        sb2.append(this.quality);
        sb2.append(", fileFormat=");
        sb2.append(this.fileFormat);
        sb2.append(", videoCodec=");
        sb2.append(this.videoCodec);
        sb2.append(", videoBitRate=");
        sb2.append(this.videoBitRate);
        sb2.append(", videoFrameRate=");
        sb2.append(this.videoFrameRate);
        sb2.append(", videoFrameWidth=");
        sb2.append(this.videoFrameWidth);
        sb2.append(", videoFrameHeight=");
        sb2.append(this.videoFrameHeight);
        sb2.append(", audioCodec=");
        sb2.append(this.audioCodec);
        sb2.append(", audioBitRate=");
        sb2.append(this.audioBitRate);
        sb2.append(", audioSampleRate=");
        sb2.append(this.audioSampleRate);
        sb2.append(", audioChannels=");
        return h0.a.m(sb2, "}", this.audioChannels);
    }
}
