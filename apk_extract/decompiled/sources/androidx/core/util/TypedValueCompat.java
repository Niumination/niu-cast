package androidx.core.util;

import a1.a;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public class TypedValueCompat {
    private static final float INCHES_PER_MM = 0.03937008f;
    private static final float INCHES_PER_PT = 0.013888889f;

    @RequiresApi(34)
    public static class Api34Impl {
        private Api34Impl() {
        }

        public static float deriveDimension(int i8, float f, DisplayMetrics displayMetrics) {
            return TypedValue.deriveDimension(i8, f, displayMetrics);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface ComplexDimensionUnit {
    }

    private TypedValueCompat() {
    }

    public static float deriveDimension(int i8, float f, @NonNull DisplayMetrics displayMetrics) {
        float f4;
        float f10;
        if (Build.VERSION.SDK_INT >= 34) {
            return Api34Impl.deriveDimension(i8, f, displayMetrics);
        }
        if (i8 == 0) {
            return f;
        }
        if (i8 == 1) {
            float f11 = displayMetrics.density;
            if (f11 == 0.0f) {
                return 0.0f;
            }
            return f / f11;
        }
        if (i8 == 2) {
            float f12 = displayMetrics.scaledDensity;
            if (f12 == 0.0f) {
                return 0.0f;
            }
            return f / f12;
        }
        if (i8 == 3) {
            float f13 = displayMetrics.xdpi;
            if (f13 == 0.0f) {
                return 0.0f;
            }
            f4 = f / f13;
            f10 = INCHES_PER_PT;
        } else {
            if (i8 == 4) {
                float f14 = displayMetrics.xdpi;
                if (f14 == 0.0f) {
                    return 0.0f;
                }
                return f / f14;
            }
            if (i8 != 5) {
                throw new IllegalArgumentException(a.o(i8, "Invalid unitToConvertTo "));
            }
            float f15 = displayMetrics.xdpi;
            if (f15 == 0.0f) {
                return 0.0f;
            }
            f4 = f / f15;
            f10 = INCHES_PER_MM;
        }
        return f4 / f10;
    }

    public static float dpToPx(float f, @NonNull DisplayMetrics displayMetrics) {
        return TypedValue.applyDimension(1, f, displayMetrics);
    }

    public static int getUnitFromComplexDimension(int i8) {
        return i8 & 15;
    }

    public static float pxToDp(float f, @NonNull DisplayMetrics displayMetrics) {
        return deriveDimension(1, f, displayMetrics);
    }

    public static float pxToSp(float f, @NonNull DisplayMetrics displayMetrics) {
        return deriveDimension(2, f, displayMetrics);
    }

    public static float spToPx(float f, @NonNull DisplayMetrics displayMetrics) {
        return TypedValue.applyDimension(2, f, displayMetrics);
    }
}
