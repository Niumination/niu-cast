package androidx.camera.video;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
final class AutoValue_AudioStats extends AudioStats {
    private final int audioState;
    private final Throwable errorCause;

    public AutoValue_AudioStats(int i8, @Nullable Throwable th2) {
        this.audioState = i8;
        this.errorCause = th2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AudioStats)) {
            return false;
        }
        AudioStats audioStats = (AudioStats) obj;
        if (this.audioState == audioStats.getAudioState()) {
            Throwable th2 = this.errorCause;
            if (th2 == null) {
                if (audioStats.getErrorCause() == null) {
                    return true;
                }
            } else if (th2.equals(audioStats.getErrorCause())) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.video.AudioStats
    public int getAudioState() {
        return this.audioState;
    }

    @Override // androidx.camera.video.AudioStats
    @Nullable
    public Throwable getErrorCause() {
        return this.errorCause;
    }

    public int hashCode() {
        int i8 = (this.audioState ^ 1000003) * 1000003;
        Throwable th2 = this.errorCause;
        return (th2 == null ? 0 : th2.hashCode()) ^ i8;
    }

    public String toString() {
        return "AudioStats{audioState=" + this.audioState + ", errorCause=" + this.errorCause + "}";
    }
}
