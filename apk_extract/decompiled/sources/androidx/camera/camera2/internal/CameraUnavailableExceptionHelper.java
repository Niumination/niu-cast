package androidx.camera.camera2.internal;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.core.CameraUnavailableException;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public final class CameraUnavailableExceptionHelper {
    private CameraUnavailableExceptionHelper() {
    }

    @NonNull
    public static CameraUnavailableException createFrom(@NonNull CameraAccessExceptionCompat cameraAccessExceptionCompat) {
        int reason = cameraAccessExceptionCompat.getReason();
        int i8 = 1;
        if (reason != 1) {
            i8 = 2;
            if (reason != 2) {
                i8 = 3;
                if (reason != 3) {
                    i8 = 4;
                    if (reason != 4) {
                        i8 = 5;
                        if (reason != 5) {
                            i8 = reason != 10001 ? 0 : 6;
                        }
                    }
                }
            }
        }
        return new CameraUnavailableException(i8, cameraAccessExceptionCompat);
    }
}
