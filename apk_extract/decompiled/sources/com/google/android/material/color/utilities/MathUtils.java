package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class MathUtils {
    private MathUtils() {
    }

    public static double clampDouble(double d7, double d10, double d11) {
        if (d11 < d7) {
            return d7;
        }
        return d11 > d10 ? d10 : d11;
    }

    public static int clampInt(int i8, int i9, int i10) {
        if (i10 < i8) {
            return i8;
        }
        return i10 > i9 ? i9 : i10;
    }

    public static double differenceDegrees(double d7, double d10) {
        return 180.0d - Math.abs(Math.abs(d7 - d10) - 180.0d);
    }

    public static double lerp(double d7, double d10, double d11) {
        return (d11 * d10) + ((1.0d - d11) * d7);
    }

    public static double[] matrixMultiply(double[] dArr, double[][] dArr2) {
        double d7 = dArr[0];
        double[] dArr3 = dArr2[0];
        double d10 = dArr3[0] * d7;
        double d11 = dArr[1];
        double d12 = (dArr3[1] * d11) + d10;
        double d13 = dArr[2];
        double d14 = (dArr3[2] * d13) + d12;
        double[] dArr4 = dArr2[1];
        double d15 = (dArr4[2] * d13) + (dArr4[1] * d11) + (dArr4[0] * d7);
        double[] dArr5 = dArr2[2];
        return new double[]{d14, d15, (d13 * dArr5[2]) + (d11 * dArr5[1]) + (d7 * dArr5[0])};
    }

    public static double rotationDirection(double d7, double d10) {
        return sanitizeDegreesDouble(d10 - d7) <= 180.0d ? 1.0d : -1.0d;
    }

    public static double sanitizeDegreesDouble(double d7) {
        double d10 = d7 % 360.0d;
        return d10 < 0.0d ? d10 + 360.0d : d10;
    }

    public static int sanitizeDegreesInt(int i8) {
        int i9 = i8 % 360;
        return i9 < 0 ? i9 + 360 : i9;
    }

    public static int signum(double d7) {
        if (d7 < 0.0d) {
            return -1;
        }
        return d7 == 0.0d ? 0 : 1;
    }
}
