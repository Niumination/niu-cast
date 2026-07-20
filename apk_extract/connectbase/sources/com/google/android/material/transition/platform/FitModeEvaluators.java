package com.google.android.material.transition.platform;

import android.graphics.RectF;
import androidx.annotation.RequiresApi;
import h.a;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
class FitModeEvaluators {
    private static final FitModeEvaluator WIDTH = new FitModeEvaluator() { // from class: com.google.android.material.transition.platform.FitModeEvaluators.1
        @Override // com.google.android.material.transition.platform.FitModeEvaluator
        public void applyMask(RectF rectF, float f10, FitModeResult fitModeResult) {
            rectF.bottom -= Math.abs(fitModeResult.currentEndHeight - fitModeResult.currentStartHeight) * f10;
        }

        @Override // com.google.android.material.transition.platform.FitModeEvaluator
        public FitModeResult evaluate(float f10, float f11, float f12, float f13, float f14, float f15, float f16) {
            float fLerp = TransitionUtils.lerp(f13, f15, f11, f12, f10, true);
            float f17 = fLerp / f13;
            float f18 = fLerp / f15;
            return new FitModeResult(f17, f18, fLerp, f14 * f17, fLerp, f16 * f18);
        }

        @Override // com.google.android.material.transition.platform.FitModeEvaluator
        public boolean shouldMaskStartBounds(FitModeResult fitModeResult) {
            return fitModeResult.currentStartHeight > fitModeResult.currentEndHeight;
        }
    };
    private static final FitModeEvaluator HEIGHT = new FitModeEvaluator() { // from class: com.google.android.material.transition.platform.FitModeEvaluators.2
        @Override // com.google.android.material.transition.platform.FitModeEvaluator
        public void applyMask(RectF rectF, float f10, FitModeResult fitModeResult) {
            float fAbs = (Math.abs(fitModeResult.currentEndWidth - fitModeResult.currentStartWidth) / 2.0f) * f10;
            rectF.left += fAbs;
            rectF.right -= fAbs;
        }

        @Override // com.google.android.material.transition.platform.FitModeEvaluator
        public FitModeResult evaluate(float f10, float f11, float f12, float f13, float f14, float f15, float f16) {
            float fLerp = TransitionUtils.lerp(f14, f16, f11, f12, f10, true);
            float f17 = fLerp / f14;
            float f18 = fLerp / f16;
            return new FitModeResult(f17, f18, f13 * f17, fLerp, f15 * f18, fLerp);
        }

        @Override // com.google.android.material.transition.platform.FitModeEvaluator
        public boolean shouldMaskStartBounds(FitModeResult fitModeResult) {
            return fitModeResult.currentStartWidth > fitModeResult.currentEndWidth;
        }
    };

    private FitModeEvaluators() {
    }

    public static FitModeEvaluator get(int i10, boolean z10, RectF rectF, RectF rectF2) {
        if (i10 == 0) {
            return shouldAutoFitToWidth(z10, rectF, rectF2) ? WIDTH : HEIGHT;
        }
        if (i10 == 1) {
            return WIDTH;
        }
        if (i10 == 2) {
            return HEIGHT;
        }
        throw new IllegalArgumentException(a.a("Invalid fit mode: ", i10));
    }

    private static boolean shouldAutoFitToWidth(boolean z10, RectF rectF, RectF rectF2) {
        float fWidth = rectF.width();
        float fHeight = rectF.height();
        float fWidth2 = rectF2.width();
        float fHeight2 = rectF2.height();
        float f10 = (fHeight2 * fWidth) / fWidth2;
        float f11 = (fWidth2 * fHeight) / fWidth;
        if (z10) {
            if (f10 < fHeight) {
                return false;
            }
        } else if (f11 < fHeight2) {
            return false;
        }
        return true;
    }
}
