package androidx.camera.core;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import com.google.android.material.color.utilities.Contrast;
import m4.l;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public interface CameraControl {

    public static final class OperationCanceledException extends Exception {
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public OperationCanceledException(@NonNull String str) {
            super(str);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public OperationCanceledException(@NonNull String str, @NonNull Throwable th2) {
            super(str, th2);
        }
    }

    @NonNull
    l cancelFocusAndMetering();

    @NonNull
    l enableTorch(boolean z2);

    @NonNull
    l setExposureCompensationIndex(int i8);

    @NonNull
    l setLinearZoom(@FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f);

    @NonNull
    l setZoomRatio(float f);

    @NonNull
    l startFocusAndMetering(@NonNull FocusMeteringAction focusMeteringAction);
}
