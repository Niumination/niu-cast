package androidx.camera.core.impl.utils;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class InterruptedRuntimeException extends RuntimeException {
    public InterruptedRuntimeException() {
    }

    public InterruptedRuntimeException(@NonNull String str) {
        super(str);
    }

    public InterruptedRuntimeException(@NonNull String str, @NonNull Throwable th2) {
        super(str, th2);
    }

    public InterruptedRuntimeException(@NonNull Throwable th2) {
        super(th2);
    }
}
