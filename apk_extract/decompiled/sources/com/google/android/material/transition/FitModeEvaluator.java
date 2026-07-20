package com.google.android.material.transition;

import android.graphics.RectF;

/* JADX INFO: loaded from: classes.dex */
interface FitModeEvaluator {
    void applyMask(RectF rectF, float f, FitModeResult fitModeResult);

    FitModeResult evaluate(float f, float f4, float f10, float f11, float f12, float f13, float f14);

    boolean shouldMaskStartBounds(FitModeResult fitModeResult);
}
