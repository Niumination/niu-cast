package androidx.camera.view.video;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;

/* JADX INFO: loaded from: classes.dex */
@ExperimentalVideo
@RequiresApi(21)
public class AudioConfig {

    @NonNull
    public static final AudioConfig AUDIO_DISABLED = new AudioConfig(false);
    private final boolean mIsAudioEnabled;

    public AudioConfig(boolean z2) {
        this.mIsAudioEnabled = z2;
    }

    @NonNull
    @RequiresPermission("android.permission.RECORD_AUDIO")
    public static AudioConfig create(boolean z2) {
        return new AudioConfig(z2);
    }

    public boolean getAudioEnabled() {
        return this.mIsAudioEnabled;
    }
}
