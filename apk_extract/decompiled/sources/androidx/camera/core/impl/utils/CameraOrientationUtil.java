package androidx.camera.core.impl.utils;

import a1.a;
import androidx.annotation.RequiresApi;
import androidx.camera.core.Logger;
import o.d;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public final class CameraOrientationUtil {
    private static final String TAG = "CameraOrientationUtil";

    private CameraOrientationUtil() {
    }

    public static int degreesToSurfaceRotation(int i8) {
        if (i8 == 0) {
            return 0;
        }
        if (i8 == 90) {
            return 1;
        }
        if (i8 == 180) {
            return 2;
        }
        if (i8 == 270) {
            return 3;
        }
        throw new IllegalStateException(a.o(i8, "Invalid sensor rotation: "));
    }

    public static int getRelativeImageRotation(int i8, int i9, boolean z2) {
        int i10 = z2 ? ((i9 - i8) + 360) % 360 : (i9 + i8) % 360;
        if (Logger.isDebugEnabled(TAG)) {
            StringBuilder sbR = d.r(i8, i9, "getRelativeImageRotation: destRotationDegrees=", ", sourceRotationDegrees=", ", isOppositeFacing=");
            sbR.append(z2);
            sbR.append(", result=");
            sbR.append(i10);
            Logger.d(TAG, sbR.toString());
        }
        return i10;
    }

    public static int surfaceRotationToDegrees(int i8) {
        if (i8 == 0) {
            return 0;
        }
        if (i8 == 1) {
            return 90;
        }
        if (i8 == 2) {
            return 180;
        }
        if (i8 == 3) {
            return 270;
        }
        throw new IllegalArgumentException(a.o(i8, "Unsupported surface rotation: "));
    }
}
