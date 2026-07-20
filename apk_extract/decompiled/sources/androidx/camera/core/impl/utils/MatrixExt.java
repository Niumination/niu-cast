package androidx.camera.core.impl.utils;

import android.opengl.Matrix;
import androidx.annotation.NonNull;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class MatrixExt {
    private static final float[] sTemp = new float[16];

    private MatrixExt() {
    }

    private static void denormalize(float[] fArr, float f, float f4) {
        Matrix.translateM(fArr, 0, -f, -f4, 0.0f);
    }

    private static void normalize(float[] fArr, float f, float f4) {
        Matrix.translateM(fArr, 0, f, f4, 0.0f);
    }

    public static void postRotate(@NonNull float[] fArr, float f, float f4, float f10) {
        float[] fArr2 = sTemp;
        synchronized (fArr2) {
            Matrix.setIdentityM(fArr2, 0);
            normalize(fArr2, f4, f10);
            Matrix.rotateM(fArr2, 0, f, 0.0f, 0.0f, 1.0f);
            denormalize(fArr2, f4, f10);
            Matrix.multiplyMM(fArr, 0, fArr2, 0, fArr, 0);
        }
    }

    public static void preRotate(@NonNull float[] fArr, float f, float f4, float f10) {
        normalize(fArr, f4, f10);
        Matrix.rotateM(fArr, 0, f, 0.0f, 0.0f, 1.0f);
        denormalize(fArr, f4, f10);
    }

    public static void setRotate(@NonNull float[] fArr, float f, float f4, float f10) {
        Matrix.setIdentityM(fArr, 0);
        preRotate(fArr, f, f4, f10);
    }

    @NonNull
    public static String toString(@NonNull float[] fArr, int i8) {
        return String.format(Locale.US, "Matrix:\n%2.1f %2.1f %2.1f %2.1f\n%2.1f %2.1f %2.1f %2.1f\n%2.1f %2.1f %2.1f %2.1f\n%2.1f %2.1f %2.1f %2.1f", Float.valueOf(fArr[i8]), Float.valueOf(fArr[i8 + 4]), Float.valueOf(fArr[i8 + 8]), Float.valueOf(fArr[i8 + 12]), Float.valueOf(fArr[i8 + 1]), Float.valueOf(fArr[i8 + 5]), Float.valueOf(fArr[i8 + 9]), Float.valueOf(fArr[i8 + 13]), Float.valueOf(fArr[i8 + 2]), Float.valueOf(fArr[i8 + 6]), Float.valueOf(fArr[i8 + 10]), Float.valueOf(fArr[i8 + 14]), Float.valueOf(fArr[i8 + 3]), Float.valueOf(fArr[i8 + 7]), Float.valueOf(fArr[i8 + 11]), Float.valueOf(fArr[i8 + 15]));
    }
}
