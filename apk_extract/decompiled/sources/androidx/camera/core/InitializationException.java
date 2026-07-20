package androidx.camera.core;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public class InitializationException extends Exception {
    public InitializationException(@Nullable String str) {
        super(str);
    }

    public InitializationException(@Nullable String str, @Nullable Throwable th2) {
        super(str, th2);
    }

    public InitializationException(@Nullable Throwable th2) {
        super(th2);
    }
}
