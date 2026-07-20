package androidx.camera.video.internal.encoder;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public class InvalidConfigException extends Exception {
    public InvalidConfigException(@Nullable String str) {
        super(str);
    }

    public InvalidConfigException(@Nullable String str, @Nullable Throwable th2) {
        super(str, th2);
    }

    public InvalidConfigException(@Nullable Throwable th2) {
        super(th2);
    }
}
