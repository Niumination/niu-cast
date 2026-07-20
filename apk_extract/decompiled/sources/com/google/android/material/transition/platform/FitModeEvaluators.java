package com.google.android.material.transition.platform;

import android.graphics.RectF;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
class FitModeEvaluators {
    private static final FitModeEvaluator WIDTH = new FitModeEvaluator() { // from class: com.google.android.material.transition.platform.FitModeEvaluators.1
        @Override // com.google.android.material.transition.platform.FitModeEvaluator
        public void applyMask(RectF rectF, float f, FitModeResult fitModeResult) {
            rectF.bottom -= Math.abs(fitModeResult.currentEndHeight - fitModeResult.currentStartHeight) * f;
        }

        @Override // com.google.android.material.transition.platform.FitModeEvaluator
        public FitModeResult evaluate(float f, float f4, float f10, float f11, float f12, float f13, float f14) {
            float fLerp = TransitionUtils.lerp(f11, f13, f4, f10, f, true);
            float f15 = fLerp / f11;
            float f16 = fLerp / f13;
            return new FitModeResult(f15, f16, fLerp, f12 * f15, fLerp, f14 * f16);
        }

        @Override // com.google.android.material.transition.platform.FitModeEvaluator
        public boolean shouldMaskStartBounds(FitModeResult fitModeResult) {
            return fitModeResult.currentStartHeight > fitModeResult.currentEndHeight;
        }
    };
    private static final FitModeEvaluator HEIGHT = new FitModeEvaluator() { // from class: com.google.android.material.transition.platform.FitModeEvaluators.2
        @Override // com.google.android.material.transition.platform.FitModeEvaluator
        public void applyMask(RectF rectF, float f, FitModeResult fitModeResult) {
            float fAbs = (Math.abs(fitModeResult.currentEndWidth - fitModeResult.currentStartWidth) / 2.0f) * f;
            rectF.left += fAbs;
            rectF.right -= fAbs;
        }

        @Override // com.google.android.material.transition.platform.FitModeEvaluator
        public FitModeResult evaluate(float f, float f4, float f10, float f11, float f12, float f13, float f14) {
            float fLerp = TransitionUtils.lerp(f12, f14, f4, f10, f, true);
            float f15 = fLerp / f12;
            float f16 = fLerp / f14;
            return new FitModeResult(f15, f16, f11 * f15, fLerp, f13 * f16, fLerp);
        }

        @Override // com.google.android.material.transition.platform.FitModeEvaluator
        public boolean shouldMaskStartBounds(FitModeResult fitModeResult) {
            return fitModeResult.currentStartWidth > fitModeResult.currentEndWidth;
        }
    };

    private FitModeEvaluators() {
    }

    public static FitModeEvaluator get(int i8, boolean z2, RectF rectF, RectF rectF2) {
        if (i8 == 0) {
            return shouldAutoFitToWidth(z2, rectF, rectF2) ? WIDTH : HEIGHT;
        }
        if (i8 == 1) {
            return WIDTH;
        }
        if (i8 == 2) {
            return HEIGHT;
        }
        throw new IllegalArgumentException(a1.a.o(i8, "Invalid fit mode: "));
    }

    private static boolean shouldAutoFitToWidth(boolean z2, RectF rectF, RectF rectF2) {
        float fWidth = rectF.width();
        float fHeight = rectF.height();
        float fWidth2 = rectF2.width();
        float fHeight2 = rectF2.height();
        float f = (fHeight2 * fWidth) / fWidth2;
        float f4 = (fWidth2 * fHeight) / fWidth;
        if (z2) {
            if (f < fHeight) {
                return false;
            }
        } else if (f4 < fHeight2) {
            return false;
        }
        return true;
    }
}
