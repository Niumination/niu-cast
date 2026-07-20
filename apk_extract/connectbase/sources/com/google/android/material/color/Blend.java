package com.google.android.material.color;

import g.a;

/* JADX INFO: loaded from: classes.dex */
final class Blend {
    private static final float HARMONIZE_MAX_DEGREES = 15.0f;
    private static final float HARMONIZE_PERCENTAGE = 0.5f;

    private Blend() {
    }

    public static int blendCam16Ucs(int i10, int i11, float f10) {
        Cam16 cam16FromInt = Cam16.fromInt(i10);
        Cam16 cam16FromInt2 = Cam16.fromInt(i11);
        float jStar = cam16FromInt.getJStar();
        float aStar = cam16FromInt.getAStar();
        float bStar = cam16FromInt.getBStar();
        return Cam16.fromUcs(a.a(cam16FromInt2.getJStar(), jStar, f10, jStar), a.a(cam16FromInt2.getAStar(), aStar, f10, aStar), a.a(cam16FromInt2.getBStar(), bStar, f10, bStar)).getInt();
    }

    public static int blendHctHue(int i10, int i11, float f10) {
        return Hct.from(Cam16.fromInt(blendCam16Ucs(i10, i11, f10)).getHue(), Cam16.fromInt(i10).getChroma(), ColorUtils.lstarFromInt(i10)).toInt();
    }

    public static int harmonize(int i10, int i11) {
        Hct hctFromInt = Hct.fromInt(i10);
        Hct hctFromInt2 = Hct.fromInt(i11);
        float fMin = Math.min(MathUtils.differenceDegrees(hctFromInt.getHue(), hctFromInt2.getHue()) * 0.5f, HARMONIZE_MAX_DEGREES);
        return Hct.from(MathUtils.sanitizeDegrees((fMin * rotationDirection(hctFromInt.getHue(), hctFromInt2.getHue())) + hctFromInt.getHue()), hctFromInt.getChroma(), hctFromInt.getTone()).toInt();
    }

    private static float rotationDirection(float f10, float f11) {
        float f12 = f11 - f10;
        float f13 = f12 + 360.0f;
        float f14 = f12 - 360.0f;
        float fAbs = Math.abs(f12);
        float fAbs2 = Math.abs(f13);
        float fAbs3 = Math.abs(f14);
        if (fAbs <= fAbs2 && fAbs <= fAbs3) {
            return ((double) f12) >= 0.0d ? 1.0f : -1.0f;
        }
        if (fAbs2 > fAbs || fAbs2 > fAbs3) {
            return ((double) f14) >= 0.0d ? 1.0f : -1.0f;
        }
        return ((double) f13) >= 0.0d ? 1.0f : -1.0f;
    }
}
