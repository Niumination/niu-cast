package com.google.android.material.math;

/* JADX INFO: loaded from: classes.dex */
public final class MathUtils {
    public static final float DEFAULT_EPSILON = 1.0E-4f;

    private MathUtils() {
    }

    public static float dist(float f, float f4, float f10, float f11) {
        return (float) Math.hypot(f10 - f, f11 - f4);
    }

    public static float distanceToFurthestCorner(float f, float f4, float f10, float f11, float f12, float f13) {
        return max(dist(f, f4, f10, f11), dist(f, f4, f12, f11), dist(f, f4, f12, f13), dist(f, f4, f10, f13));
    }

    public static float floorMod(float f, int i8) {
        float f4 = i8;
        int i9 = (int) (f / f4);
        if (Math.signum(f) * f4 < 0.0f && i9 * i8 != f) {
            i9--;
        }
        return f - (i9 * i8);
    }

    public static boolean geq(float f, float f4, float f10) {
        return f + f10 >= f4;
    }

    public static float lerp(float f, float f4, float f10) {
        return (f10 * f4) + ((1.0f - f10) * f);
    }

    private static float max(float f, float f4, float f10, float f11) {
        if (f > f4 && f > f10 && f > f11) {
            return f;
        }
        if (f4 <= f10 || f4 <= f11) {
            return f10 > f11 ? f10 : f11;
        }
        return f4;
    }

    public static int floorMod(int i8, int i9) {
        int i10 = i8 / i9;
        if ((i8 ^ i9) < 0 && i10 * i9 != i8) {
            i10--;
        }
        return i8 - (i10 * i9);
    }
}
