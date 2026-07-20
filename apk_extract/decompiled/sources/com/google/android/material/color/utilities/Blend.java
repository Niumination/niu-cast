package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class Blend {
    private Blend() {
    }

    public static int cam16Ucs(int i8, int i9, double d7) {
        Cam16 cam16FromInt = Cam16.fromInt(i8);
        Cam16 cam16FromInt2 = Cam16.fromInt(i9);
        double jstar = cam16FromInt.getJstar();
        double astar = cam16FromInt.getAstar();
        double bstar = cam16FromInt.getBstar();
        return Cam16.fromUcs(((cam16FromInt2.getJstar() - jstar) * d7) + jstar, ((cam16FromInt2.getAstar() - astar) * d7) + astar, ((cam16FromInt2.getBstar() - bstar) * d7) + bstar).toInt();
    }

    public static int harmonize(int i8, int i9) {
        Hct hctFromInt = Hct.fromInt(i8);
        Hct hctFromInt2 = Hct.fromInt(i9);
        double dMin = Math.min(MathUtils.differenceDegrees(hctFromInt.getHue(), hctFromInt2.getHue()) * 0.5d, 15.0d);
        return Hct.from(MathUtils.sanitizeDegreesDouble((MathUtils.rotationDirection(hctFromInt.getHue(), hctFromInt2.getHue()) * dMin) + hctFromInt.getHue()), hctFromInt.getChroma(), hctFromInt.getTone()).toInt();
    }

    public static int hctHue(int i8, int i9, double d7) {
        return Hct.from(Cam16.fromInt(cam16Ucs(i8, i9, d7)).getHue(), Cam16.fromInt(i8).getChroma(), ColorUtils.lstarFromArgb(i8)).toInt();
    }
}
