package androidx.camera.core;

import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public final class CameraInfoUnavailableException extends Exception {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public CameraInfoUnavailableException(String str, Throwable th2) {
        super(str, th2);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public CameraInfoUnavailableException(String str) {
        super(str);
    }
}
