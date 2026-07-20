package androidx.core.graphics;

import android.graphics.Color;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.Size;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ScatterMapKt;
import androidx.core.content.res.CamColor;
import androidx.core.view.ViewCompat;
import com.google.android.material.color.utilities.Contrast;
import java.util.Objects;
import kotlin.jvm.internal.DoubleCompanionObject;

/* JADX INFO: loaded from: classes.dex */
public final class ColorUtils {
    private static final int MIN_ALPHA_SEARCH_MAX_ITERATIONS = 10;
    private static final int MIN_ALPHA_SEARCH_PRECISION = 1;
    private static final ThreadLocal<double[]> TEMP_ARRAY = new ThreadLocal<>();
    private static final double XYZ_EPSILON = 0.008856d;
    private static final double XYZ_KAPPA = 903.3d;
    private static final double XYZ_WHITE_REFERENCE_X = 95.047d;
    private static final double XYZ_WHITE_REFERENCE_Y = 100.0d;
    private static final double XYZ_WHITE_REFERENCE_Z = 108.883d;

    @RequiresApi(26)
    public static class Api26Impl {
        private Api26Impl() {
        }

        public static Color compositeColors(Color color, Color color2) {
            if (!Objects.equals(color.getModel(), color2.getModel())) {
                throw new IllegalArgumentException("Color models must match (" + color.getModel() + " vs. " + color2.getModel() + ")");
            }
            if (!Objects.equals(color2.getColorSpace(), color.getColorSpace())) {
                color = color.convert(color2.getColorSpace());
            }
            float[] components = color.getComponents();
            float[] components2 = color2.getComponents();
            float fAlpha = color.alpha();
            float fAlpha2 = (1.0f - fAlpha) * color2.alpha();
            int componentCount = color2.getComponentCount() - 1;
            float f = fAlpha + fAlpha2;
            components2[componentCount] = f;
            if (f > 0.0f) {
                fAlpha /= f;
                fAlpha2 /= f;
            }
            for (int i8 = 0; i8 < componentCount; i8++) {
                components2[i8] = (components2[i8] * fAlpha2) + (components[i8] * fAlpha);
            }
            return Color.valueOf(components2, color2.getColorSpace());
        }
    }

    private ColorUtils() {
    }

    @ColorInt
    public static int HSLToColor(@NonNull float[] fArr) {
        int iRound;
        int iRound2;
        int iRound3;
        float f = fArr[0];
        float f4 = fArr[1];
        float f10 = fArr[2];
        float fAbs = (1.0f - Math.abs((f10 * 2.0f) - 1.0f)) * f4;
        float f11 = f10 - (0.5f * fAbs);
        float fAbs2 = (1.0f - Math.abs(((f / 60.0f) % 2.0f) - 1.0f)) * fAbs;
        switch (((int) f) / 60) {
            case 0:
                iRound = Math.round((fAbs + f11) * 255.0f);
                iRound2 = Math.round((fAbs2 + f11) * 255.0f);
                iRound3 = Math.round(f11 * 255.0f);
                break;
            case 1:
                iRound = Math.round((fAbs2 + f11) * 255.0f);
                iRound2 = Math.round((fAbs + f11) * 255.0f);
                iRound3 = Math.round(f11 * 255.0f);
                break;
            case 2:
                iRound = Math.round(f11 * 255.0f);
                iRound2 = Math.round((fAbs + f11) * 255.0f);
                iRound3 = Math.round((fAbs2 + f11) * 255.0f);
                break;
            case 3:
                iRound = Math.round(f11 * 255.0f);
                iRound2 = Math.round((fAbs2 + f11) * 255.0f);
                iRound3 = Math.round((fAbs + f11) * 255.0f);
                break;
            case 4:
                iRound = Math.round((fAbs2 + f11) * 255.0f);
                iRound2 = Math.round(f11 * 255.0f);
                iRound3 = Math.round((fAbs + f11) * 255.0f);
                break;
            case 5:
            case 6:
                iRound = Math.round((fAbs + f11) * 255.0f);
                iRound2 = Math.round(f11 * 255.0f);
                iRound3 = Math.round((fAbs2 + f11) * 255.0f);
                break;
            default:
                iRound3 = 0;
                iRound = 0;
                iRound2 = 0;
                break;
        }
        return Color.rgb(constrain(iRound, 0, 255), constrain(iRound2, 0, 255), constrain(iRound3, 0, 255));
    }

    @ColorInt
    public static int LABToColor(@FloatRange(from = 0.0d, to = XYZ_WHITE_REFERENCE_Y) double d7, @FloatRange(from = -128.0d, to = 127.0d) double d10, @FloatRange(from = -128.0d, to = 127.0d) double d11) {
        double[] tempDouble3Array = getTempDouble3Array();
        LABToXYZ(d7, d10, d11, tempDouble3Array);
        return XYZToColor(tempDouble3Array[0], tempDouble3Array[1], tempDouble3Array[2]);
    }

    public static void LABToXYZ(@FloatRange(from = 0.0d, to = XYZ_WHITE_REFERENCE_Y) double d7, @FloatRange(from = -128.0d, to = 127.0d) double d10, @FloatRange(from = -128.0d, to = 127.0d) double d11, @NonNull double[] dArr) {
        double d12 = (d7 + 16.0d) / 116.0d;
        double d13 = (d10 / 500.0d) + d12;
        double d14 = d12 - (d11 / 200.0d);
        double dPow = Math.pow(d13, 3.0d);
        if (dPow <= XYZ_EPSILON) {
            dPow = ((d13 * 116.0d) - 16.0d) / XYZ_KAPPA;
        }
        double dPow2 = d7 > 7.9996247999999985d ? Math.pow(d12, 3.0d) : d7 / XYZ_KAPPA;
        double dPow3 = Math.pow(d14, 3.0d);
        if (dPow3 <= XYZ_EPSILON) {
            dPow3 = ((d14 * 116.0d) - 16.0d) / XYZ_KAPPA;
        }
        dArr[0] = dPow * XYZ_WHITE_REFERENCE_X;
        dArr[1] = dPow2 * XYZ_WHITE_REFERENCE_Y;
        dArr[2] = dPow3 * XYZ_WHITE_REFERENCE_Z;
    }

    @ColorInt
    public static int M3HCTToColor(@FloatRange(from = 0.0d, to = 360.0d, toInclusive = false) float f, @FloatRange(from = 0.0d, to = DoubleCompanionObject.POSITIVE_INFINITY, toInclusive = false) float f4, @FloatRange(from = 0.0d, to = XYZ_WHITE_REFERENCE_Y) float f10) {
        return CamColor.toColor(f, f4, f10);
    }

    public static void RGBToHSL(@IntRange(from = 0, to = ScatterMapKt.Sentinel) int i8, @IntRange(from = 0, to = ScatterMapKt.Sentinel) int i9, @IntRange(from = 0, to = ScatterMapKt.Sentinel) int i10, @NonNull float[] fArr) {
        float f;
        float fAbs;
        float f4 = i8 / 255.0f;
        float f10 = i9 / 255.0f;
        float f11 = i10 / 255.0f;
        float fMax = Math.max(f4, Math.max(f10, f11));
        float fMin = Math.min(f4, Math.min(f10, f11));
        float f12 = fMax - fMin;
        float f13 = (fMax + fMin) / 2.0f;
        if (fMax == fMin) {
            f = 0.0f;
            fAbs = 0.0f;
        } else {
            if (fMax == f4) {
                f = ((f10 - f11) / f12) % 6.0f;
            } else {
                f = fMax == f10 ? ((f11 - f4) / f12) + 2.0f : 4.0f + ((f4 - f10) / f12);
            }
            fAbs = f12 / (1.0f - Math.abs((2.0f * f13) - 1.0f));
        }
        float f14 = (f * 60.0f) % 360.0f;
        if (f14 < 0.0f) {
            f14 += 360.0f;
        }
        fArr[0] = constrain(f14, 0.0f, 360.0f);
        fArr[1] = constrain(fAbs, 0.0f, 1.0f);
        fArr[2] = constrain(f13, 0.0f, 1.0f);
    }

    public static void RGBToLAB(@IntRange(from = 0, to = ScatterMapKt.Sentinel) int i8, @IntRange(from = 0, to = ScatterMapKt.Sentinel) int i9, @IntRange(from = 0, to = ScatterMapKt.Sentinel) int i10, @NonNull double[] dArr) {
        RGBToXYZ(i8, i9, i10, dArr);
        XYZToLAB(dArr[0], dArr[1], dArr[2], dArr);
    }

    public static void RGBToXYZ(@IntRange(from = 0, to = ScatterMapKt.Sentinel) int i8, @IntRange(from = 0, to = ScatterMapKt.Sentinel) int i9, @IntRange(from = 0, to = ScatterMapKt.Sentinel) int i10, @NonNull double[] dArr) {
        if (dArr.length != 3) {
            throw new IllegalArgumentException("outXyz must have a length of 3.");
        }
        double d7 = ((double) i8) / 255.0d;
        double dPow = d7 < 0.04045d ? d7 / 12.92d : Math.pow((d7 + 0.055d) / 1.055d, 2.4d);
        double d10 = ((double) i9) / 255.0d;
        double dPow2 = d10 < 0.04045d ? d10 / 12.92d : Math.pow((d10 + 0.055d) / 1.055d, 2.4d);
        double d11 = ((double) i10) / 255.0d;
        double dPow3 = d11 < 0.04045d ? d11 / 12.92d : Math.pow((d11 + 0.055d) / 1.055d, 2.4d);
        dArr[0] = ((0.1805d * dPow3) + (0.3576d * dPow2) + (0.4124d * dPow)) * XYZ_WHITE_REFERENCE_Y;
        dArr[1] = ((0.0722d * dPow3) + (0.7152d * dPow2) + (0.2126d * dPow)) * XYZ_WHITE_REFERENCE_Y;
        dArr[2] = ((dPow3 * 0.9505d) + (dPow2 * 0.1192d) + (dPow * 0.0193d)) * XYZ_WHITE_REFERENCE_Y;
    }

    @ColorInt
    public static int XYZToColor(@FloatRange(from = 0.0d, to = XYZ_WHITE_REFERENCE_X) double d7, @FloatRange(from = 0.0d, to = XYZ_WHITE_REFERENCE_Y) double d10, @FloatRange(from = 0.0d, to = XYZ_WHITE_REFERENCE_Z) double d11) {
        double d12 = (((-0.4986d) * d11) + (((-1.5372d) * d10) + (3.2406d * d7))) / XYZ_WHITE_REFERENCE_Y;
        double d13 = ((0.0415d * d11) + ((1.8758d * d10) + ((-0.9689d) * d7))) / XYZ_WHITE_REFERENCE_Y;
        double d14 = ((1.057d * d11) + (((-0.204d) * d10) + (0.0557d * d7))) / XYZ_WHITE_REFERENCE_Y;
        return Color.rgb(constrain((int) Math.round((d12 > 0.0031308d ? (Math.pow(d12, 0.4166666666666667d) * 1.055d) - 0.055d : d12 * 12.92d) * 255.0d), 0, 255), constrain((int) Math.round((d13 > 0.0031308d ? (Math.pow(d13, 0.4166666666666667d) * 1.055d) - 0.055d : d13 * 12.92d) * 255.0d), 0, 255), constrain((int) Math.round((d14 > 0.0031308d ? (Math.pow(d14, 0.4166666666666667d) * 1.055d) - 0.055d : d14 * 12.92d) * 255.0d), 0, 255));
    }

    public static void XYZToLAB(@FloatRange(from = 0.0d, to = XYZ_WHITE_REFERENCE_X) double d7, @FloatRange(from = 0.0d, to = XYZ_WHITE_REFERENCE_Y) double d10, @FloatRange(from = 0.0d, to = XYZ_WHITE_REFERENCE_Z) double d11, @NonNull double[] dArr) {
        if (dArr.length != 3) {
            throw new IllegalArgumentException("outLab must have a length of 3.");
        }
        double dPivotXyzComponent = pivotXyzComponent(d7 / XYZ_WHITE_REFERENCE_X);
        double dPivotXyzComponent2 = pivotXyzComponent(d10 / XYZ_WHITE_REFERENCE_Y);
        double dPivotXyzComponent3 = pivotXyzComponent(d11 / XYZ_WHITE_REFERENCE_Z);
        dArr[0] = Math.max(0.0d, (116.0d * dPivotXyzComponent2) - 16.0d);
        dArr[1] = (dPivotXyzComponent - dPivotXyzComponent2) * 500.0d;
        dArr[2] = (dPivotXyzComponent2 - dPivotXyzComponent3) * 200.0d;
    }

    @ColorInt
    public static int blendARGB(@ColorInt int i8, @ColorInt int i9, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f) {
        float f4 = 1.0f - f;
        return Color.argb((int) ((Color.alpha(i9) * f) + (Color.alpha(i8) * f4)), (int) ((Color.red(i9) * f) + (Color.red(i8) * f4)), (int) ((Color.green(i9) * f) + (Color.green(i8) * f4)), (int) ((Color.blue(i9) * f) + (Color.blue(i8) * f4)));
    }

    public static void blendHSL(@NonNull float[] fArr, @NonNull float[] fArr2, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f, @NonNull float[] fArr3) {
        if (fArr3.length != 3) {
            throw new IllegalArgumentException("result must have a length of 3.");
        }
        float f4 = 1.0f - f;
        fArr3[0] = circularInterpolate(fArr[0], fArr2[0], f);
        fArr3[1] = (fArr2[1] * f) + (fArr[1] * f4);
        fArr3[2] = (fArr2[2] * f) + (fArr[2] * f4);
    }

    public static void blendLAB(@NonNull double[] dArr, @NonNull double[] dArr2, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) double d7, @NonNull double[] dArr3) {
        if (dArr3.length != 3) {
            throw new IllegalArgumentException("outResult must have a length of 3.");
        }
        double d10 = 1.0d - d7;
        dArr3[0] = (dArr2[0] * d7) + (dArr[0] * d10);
        dArr3[1] = (dArr2[1] * d7) + (dArr[1] * d10);
        dArr3[2] = (dArr2[2] * d7) + (dArr[2] * d10);
    }

    public static double calculateContrast(@ColorInt int i8, @ColorInt int i9) {
        if (Color.alpha(i9) != 255) {
            throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(i9));
        }
        if (Color.alpha(i8) < 255) {
            i8 = compositeColors(i8, i9);
        }
        double dCalculateLuminance = calculateLuminance(i8) + 0.05d;
        double dCalculateLuminance2 = calculateLuminance(i9) + 0.05d;
        return Math.max(dCalculateLuminance, dCalculateLuminance2) / Math.min(dCalculateLuminance, dCalculateLuminance2);
    }

    @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN)
    public static double calculateLuminance(@ColorInt int i8) {
        double[] tempDouble3Array = getTempDouble3Array();
        colorToXYZ(i8, tempDouble3Array);
        return tempDouble3Array[1] / XYZ_WHITE_REFERENCE_Y;
    }

    public static int calculateMinimumAlpha(@ColorInt int i8, @ColorInt int i9, float f) {
        int i10 = 255;
        if (Color.alpha(i9) != 255) {
            throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(i9));
        }
        double d7 = f;
        if (calculateContrast(setAlphaComponent(i8, 255), i9) < d7) {
            return -1;
        }
        int i11 = 0;
        for (int i12 = 0; i12 <= 10 && i10 - i11 > 1; i12++) {
            int i13 = (i11 + i10) / 2;
            if (calculateContrast(setAlphaComponent(i8, i13), i9) < d7) {
                i11 = i13;
            } else {
                i10 = i13;
            }
        }
        return i10;
    }

    @VisibleForTesting
    public static float circularInterpolate(float f, float f4, float f10) {
        if (Math.abs(f4 - f) > 180.0f) {
            if (f4 > f) {
                f += 360.0f;
            } else {
                f4 += 360.0f;
            }
        }
        return (((f4 - f) * f10) + f) % 360.0f;
    }

    public static void colorToHSL(@ColorInt int i8, @NonNull float[] fArr) {
        RGBToHSL(Color.red(i8), Color.green(i8), Color.blue(i8), fArr);
    }

    public static void colorToLAB(@ColorInt int i8, @NonNull double[] dArr) {
        RGBToLAB(Color.red(i8), Color.green(i8), Color.blue(i8), dArr);
    }

    public static void colorToM3HCT(@ColorInt int i8, @NonNull @Size(3) float[] fArr) {
        CamColor.getM3HCTfromColor(i8, fArr);
    }

    public static void colorToXYZ(@ColorInt int i8, @NonNull double[] dArr) {
        RGBToXYZ(Color.red(i8), Color.green(i8), Color.blue(i8), dArr);
    }

    private static int compositeAlpha(int i8, int i9) {
        return 255 - (((255 - i8) * (255 - i9)) / 255);
    }

    public static int compositeColors(@ColorInt int i8, @ColorInt int i9) {
        int iAlpha = Color.alpha(i9);
        int iAlpha2 = Color.alpha(i8);
        int iCompositeAlpha = compositeAlpha(iAlpha2, iAlpha);
        return Color.argb(iCompositeAlpha, compositeComponent(Color.red(i8), iAlpha2, Color.red(i9), iAlpha, iCompositeAlpha), compositeComponent(Color.green(i8), iAlpha2, Color.green(i9), iAlpha, iCompositeAlpha), compositeComponent(Color.blue(i8), iAlpha2, Color.blue(i9), iAlpha, iCompositeAlpha));
    }

    private static int compositeComponent(int i8, int i9, int i10, int i11, int i12) {
        if (i12 == 0) {
            return 0;
        }
        return (((255 - i9) * (i10 * i11)) + ((i8 * 255) * i9)) / (i12 * 255);
    }

    private static float constrain(float f, float f4, float f10) {
        return f < f4 ? f4 : Math.min(f, f10);
    }

    public static double distanceEuclidean(@NonNull double[] dArr, @NonNull double[] dArr2) {
        return Math.sqrt(Math.pow(dArr[2] - dArr2[2], 2.0d) + Math.pow(dArr[1] - dArr2[1], 2.0d) + Math.pow(dArr[0] - dArr2[0], 2.0d));
    }

    private static double[] getTempDouble3Array() {
        ThreadLocal<double[]> threadLocal = TEMP_ARRAY;
        double[] dArr = threadLocal.get();
        if (dArr != null) {
            return dArr;
        }
        double[] dArr2 = new double[3];
        threadLocal.set(dArr2);
        return dArr2;
    }

    private static double pivotXyzComponent(double d7) {
        return d7 > XYZ_EPSILON ? Math.pow(d7, 0.3333333333333333d) : ((d7 * XYZ_KAPPA) + 16.0d) / 116.0d;
    }

    @ColorInt
    public static int setAlphaComponent(@ColorInt int i8, @IntRange(from = 0, to = ScatterMapKt.Sentinel) int i9) {
        if (i9 < 0 || i9 > 255) {
            throw new IllegalArgumentException("alpha must be between 0 and 255.");
        }
        return (i8 & ViewCompat.MEASURED_SIZE_MASK) | (i9 << 24);
    }

    private static int constrain(int i8, int i9, int i10) {
        return i8 < i9 ? i9 : Math.min(i8, i10);
    }

    @NonNull
    @RequiresApi(26)
    public static Color compositeColors(@NonNull Color color, @NonNull Color color2) {
        return Api26Impl.compositeColors(color, color2);
    }
}
