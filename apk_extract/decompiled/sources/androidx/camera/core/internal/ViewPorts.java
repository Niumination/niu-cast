package androidx.camera.core.internal;

import a1.a;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Rational;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.internal.utils.ImageUtil;
import androidx.core.util.Preconditions;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public class ViewPorts {
    private ViewPorts() {
    }

    @NonNull
    public static Map<UseCase, Rect> calculateViewPortRects(@NonNull Rect rect, boolean z2, @NonNull Rational rational, @IntRange(from = 0, to = 359) int i8, int i9, int i10, @NonNull Map<UseCase, StreamSpec> map) {
        Preconditions.checkArgument(rect.width() > 0 && rect.height() > 0, "Cannot compute viewport crop rects zero sized sensor rect.");
        RectF rectF = new RectF(rect);
        HashMap map2 = new HashMap();
        RectF rectF2 = new RectF(rect);
        for (Map.Entry<UseCase, StreamSpec> entry : map.entrySet()) {
            Matrix matrix = new Matrix();
            RectF rectF3 = new RectF(0.0f, 0.0f, entry.getValue().getResolution().getWidth(), entry.getValue().getResolution().getHeight());
            matrix.setRectToRect(rectF3, rectF, Matrix.ScaleToFit.CENTER);
            map2.put(entry.getKey(), matrix);
            RectF rectF4 = new RectF();
            matrix.mapRect(rectF4, rectF3);
            rectF2.intersect(rectF4);
        }
        RectF scaledRect = getScaledRect(rectF2, ImageUtil.getRotatedAspectRatio(i8, rational), i9, z2, i10, i8);
        HashMap map3 = new HashMap();
        RectF rectF5 = new RectF();
        Matrix matrix2 = new Matrix();
        for (Map.Entry entry2 : map2.entrySet()) {
            ((Matrix) entry2.getValue()).invert(matrix2);
            matrix2.mapRect(rectF5, scaledRect);
            Rect rect2 = new Rect();
            rectF5.round(rect2);
            map3.put((UseCase) entry2.getKey(), rect2);
        }
        return map3;
    }

    private static RectF correctStartOrEnd(boolean z2, @IntRange(from = 0, to = 359) int i8, RectF rectF, RectF rectF2) {
        boolean z3 = false;
        boolean z5 = i8 == 0 && !z2;
        boolean z10 = i8 == 90 && z2;
        if (z5 || z10) {
            return rectF2;
        }
        boolean z11 = i8 == 0 && z2;
        boolean z12 = i8 == 270 && !z2;
        if (z11 || z12) {
            return flipHorizontally(rectF2, rectF.centerX());
        }
        boolean z13 = i8 == 90 && !z2;
        boolean z14 = i8 == 180 && z2;
        if (z13 || z14) {
            return flipVertically(rectF2, rectF.centerY());
        }
        boolean z15 = i8 == 180 && !z2;
        if (i8 == 270 && z2) {
            z3 = true;
        }
        if (z15 || z3) {
            return flipHorizontally(flipVertically(rectF2, rectF.centerY()), rectF.centerX());
        }
        throw new IllegalArgumentException("Invalid argument: mirrored " + z2 + " rotation " + i8);
    }

    private static RectF flipHorizontally(RectF rectF, float f) {
        return new RectF(flipX(rectF.right, f), rectF.top, flipX(rectF.left, f), rectF.bottom);
    }

    private static RectF flipVertically(RectF rectF, float f) {
        return new RectF(rectF.left, flipY(rectF.bottom, f), rectF.right, flipY(rectF.top, f));
    }

    private static float flipX(float f, float f4) {
        return (f4 + f4) - f;
    }

    private static float flipY(float f, float f4) {
        return (f4 + f4) - f;
    }

    @NonNull
    public static RectF getScaledRect(@NonNull RectF rectF, @NonNull Rational rational, int i8, boolean z2, int i9, @IntRange(from = 0, to = 359) int i10) {
        if (i8 == 3) {
            return rectF;
        }
        Matrix matrix = new Matrix();
        RectF rectF2 = new RectF(0.0f, 0.0f, rational.getNumerator(), rational.getDenominator());
        if (i8 == 0) {
            matrix.setRectToRect(rectF2, rectF, Matrix.ScaleToFit.START);
        } else if (i8 == 1) {
            matrix.setRectToRect(rectF2, rectF, Matrix.ScaleToFit.CENTER);
        } else {
            if (i8 != 2) {
                throw new IllegalStateException(a.o(i8, "Unexpected scale type: "));
            }
            matrix.setRectToRect(rectF2, rectF, Matrix.ScaleToFit.END);
        }
        RectF rectF3 = new RectF();
        matrix.mapRect(rectF3, rectF2);
        return correctStartOrEnd(shouldMirrorStartAndEnd(z2, i9), i10, rectF, rectF3);
    }

    private static boolean shouldMirrorStartAndEnd(boolean z2, int i8) {
        return z2 ^ (i8 == 1);
    }
}
