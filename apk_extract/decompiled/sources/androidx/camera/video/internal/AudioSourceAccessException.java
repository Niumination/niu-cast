package androidx.camera.video.internal;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public class AudioSourceAccessException extends Exception {
    public AudioSourceAccessException(@Nullable String str) {
        super(str);
    }

    public AudioSourceAccessException(@Nullable String str, @Nullable Throwable th2) {
        super(str, th2);
    }

    public AudioSourceAccessException(@Nullable Throwable th2) {
        super(th2);
    }
}
