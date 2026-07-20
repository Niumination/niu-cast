package androidx.camera.camera2.internal;

import android.hardware.camera2.CaptureFailure;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.CameraCaptureFailure;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public final class Camera2CameraCaptureFailure extends CameraCaptureFailure {
    private final CaptureFailure mCaptureFailure;

    public Camera2CameraCaptureFailure(@NonNull CameraCaptureFailure.Reason reason, @NonNull CaptureFailure captureFailure) {
        super(reason);
        this.mCaptureFailure = captureFailure;
    }

    @NonNull
    public CaptureFailure getCaptureFailure() {
        return this.mCaptureFailure;
    }
}
