package com.google.android.material.color;

/* JADX INFO: loaded from: classes.dex */
final class MathUtils {
    private MathUtils() {
    }

    public static float clamp(float f10, float f11, float f12) {
        return Math.min(Math.max(f12, f10), f11);
    }

    public static float differenceDegrees(float f10, float f11) {
        return 180.0f - Math.abs(Math.abs(f10 - f11) - 180.0f);
    }

    public static float lerp(float f10, float f11, float f12) {
        return (f12 * f11) + ((1.0f - f12) * f10);
    }

    public static float sanitizeDegrees(float f10) {
        if (f10 < 0.0f) {
            return (f10 % 360.0f) + 360.0f;
        }
        return f10 >= 360.0f ? f10 % 360.0f : f10;
    }

    public static float toDegrees(float f10) {
        return (f10 * 180.0f) / 3.1415927f;
    }

    public static float toRadians(float f10) {
        return (f10 / 180.0f) * 3.1415927f;
    }

    public static int sanitizeDegrees(int i10) {
        if (i10 < 0) {
            return (i10 % 360) + 360;
        }
        return i10 >= 360 ? i10 % 360 : i10;
    }
}
