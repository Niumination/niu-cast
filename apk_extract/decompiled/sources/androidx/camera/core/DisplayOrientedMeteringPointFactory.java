package androidx.camera.core;

import android.graphics.PointF;
import android.view.Display;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public final class DisplayOrientedMeteringPointFactory extends MeteringPointFactory {

    @NonNull
    private final CameraInfo mCameraInfo;

    @NonNull
    private final Display mDisplay;
    private final float mHeight;
    private final float mWidth;

    public DisplayOrientedMeteringPointFactory(@NonNull Display display, @NonNull CameraInfo cameraInfo, float f, float f4) {
        this.mWidth = f;
        this.mHeight = f4;
        this.mDisplay = display;
        this.mCameraInfo = cameraInfo;
    }

    private int getRelativeCameraOrientation(boolean z2) {
        try {
            int sensorRotationDegrees = this.mCameraInfo.getSensorRotationDegrees(this.mDisplay.getRotation());
            return z2 ? (360 - sensorRotationDegrees) % 360 : sensorRotationDegrees;
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // androidx.camera.core.MeteringPointFactory
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public PointF convertPoint(float f, float f4) {
        float f10 = this.mWidth;
        float f11 = this.mHeight;
        boolean z2 = this.mCameraInfo.getLensFacing() == 0;
        int relativeCameraOrientation = getRelativeCameraOrientation(z2);
        if (relativeCameraOrientation != 90 && relativeCameraOrientation != 270) {
            f4 = f;
            f = f4;
            f11 = f10;
            f10 = f11;
        }
        if (relativeCameraOrientation == 90) {
            f = f10 - f;
        } else if (relativeCameraOrientation == 180) {
            f4 = f11 - f4;
            f = f10 - f;
        } else if (relativeCameraOrientation == 270) {
            f4 = f11 - f4;
        }
        if (z2) {
            f4 = f11 - f4;
        }
        return new PointF(f4 / f11, f / f10);
    }
}
