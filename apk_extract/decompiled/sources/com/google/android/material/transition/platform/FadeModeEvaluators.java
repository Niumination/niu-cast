package com.google.android.material.transition.platform;

import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
class FadeModeEvaluators {
    private static final FadeModeEvaluator IN = new FadeModeEvaluator() { // from class: com.google.android.material.transition.platform.FadeModeEvaluators.1
        @Override // com.google.android.material.transition.platform.FadeModeEvaluator
        public FadeModeResult evaluate(float f, float f4, float f10, float f11) {
            return FadeModeResult.endOnTop(255, TransitionUtils.lerp(0, 255, f4, f10, f));
        }
    };
    private static final FadeModeEvaluator OUT = new FadeModeEvaluator() { // from class: com.google.android.material.transition.platform.FadeModeEvaluators.2
        @Override // com.google.android.material.transition.platform.FadeModeEvaluator
        public FadeModeResult evaluate(float f, float f4, float f10, float f11) {
            return FadeModeResult.startOnTop(TransitionUtils.lerp(255, 0, f4, f10, f), 255);
        }
    };
    private static final FadeModeEvaluator CROSS = new FadeModeEvaluator() { // from class: com.google.android.material.transition.platform.FadeModeEvaluators.3
        @Override // com.google.android.material.transition.platform.FadeModeEvaluator
        public FadeModeResult evaluate(float f, float f4, float f10, float f11) {
            return FadeModeResult.startOnTop(TransitionUtils.lerp(255, 0, f4, f10, f), TransitionUtils.lerp(0, 255, f4, f10, f));
        }
    };
    private static final FadeModeEvaluator THROUGH = new FadeModeEvaluator() { // from class: com.google.android.material.transition.platform.FadeModeEvaluators.4
        @Override // com.google.android.material.transition.platform.FadeModeEvaluator
        public FadeModeResult evaluate(float f, float f4, float f10, float f11) {
            float fB = a1.a.b(f10, f4, f11, f4);
            return FadeModeResult.startOnTop(TransitionUtils.lerp(255, 0, f4, fB, f), TransitionUtils.lerp(0, 255, fB, f10, f));
        }
    };

    private FadeModeEvaluators() {
    }

    public static FadeModeEvaluator get(int i8, boolean z2) {
        if (i8 == 0) {
            return z2 ? IN : OUT;
        }
        if (i8 == 1) {
            return z2 ? OUT : IN;
        }
        if (i8 == 2) {
            return CROSS;
        }
        if (i8 == 3) {
            return THROUGH;
        }
        throw new IllegalArgumentException(a1.a.o(i8, "Invalid fade mode: "));
    }
}
