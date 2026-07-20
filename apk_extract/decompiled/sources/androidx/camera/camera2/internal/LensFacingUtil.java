package androidx.camera.camera2.internal;

import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import androidx.camera.core.ExperimentalLensFacing;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public class LensFacingUtil {
    private LensFacingUtil() {
    }

    @OptIn(markerClass = {ExperimentalLensFacing.class})
    public static int getCameraSelectorLensFacing(int i8) {
        if (i8 == 0) {
            return 0;
        }
        if (i8 == 1) {
            return 1;
        }
        if (i8 == 2) {
            return 2;
        }
        throw new IllegalArgumentException(h0.a.h(i8, "The given lens facing integer: ", " can not be recognized."));
    }

    @OptIn(markerClass = {ExperimentalLensFacing.class})
    public static int getLensFacingInt(int i8) {
        if (i8 == 0) {
            return 0;
        }
        if (i8 == 1) {
            return 1;
        }
        if (i8 == 2) {
            return 2;
        }
        throw new IllegalArgumentException(h0.a.h(i8, "The given lens facing: ", " can not be recognized."));
    }
}
