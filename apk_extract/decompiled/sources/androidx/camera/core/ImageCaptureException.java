package androidx.camera.core;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public class ImageCaptureException extends Exception {
    private final int mImageCaptureError;

    public ImageCaptureException(int i8, @NonNull String str, @Nullable Throwable th2) {
        super(str, th2);
        this.mImageCaptureError = i8;
    }

    public int getImageCaptureError() {
        return this.mImageCaptureError;
    }
}
