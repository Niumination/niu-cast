package com.google.android.material.transition;

import g.a;

/* JADX INFO: loaded from: classes.dex */
class FadeModeEvaluators {
    private static final FadeModeEvaluator IN = new FadeModeEvaluator() { // from class: com.google.android.material.transition.FadeModeEvaluators.1
        @Override // com.google.android.material.transition.FadeModeEvaluator
        public FadeModeResult evaluate(float f10, float f11, float f12, float f13) {
            return FadeModeResult.endOnTop(255, TransitionUtils.lerp(0, 255, f11, f12, f10));
        }
    };
    private static final FadeModeEvaluator OUT = new FadeModeEvaluator() { // from class: com.google.android.material.transition.FadeModeEvaluators.2
        @Override // com.google.android.material.transition.FadeModeEvaluator
        public FadeModeResult evaluate(float f10, float f11, float f12, float f13) {
            return FadeModeResult.startOnTop(TransitionUtils.lerp(255, 0, f11, f12, f10), 255);
        }
    };
    private static final FadeModeEvaluator CROSS = new FadeModeEvaluator() { // from class: com.google.android.material.transition.FadeModeEvaluators.3
        @Override // com.google.android.material.transition.FadeModeEvaluator
        public FadeModeResult evaluate(float f10, float f11, float f12, float f13) {
            return FadeModeResult.startOnTop(TransitionUtils.lerp(255, 0, f11, f12, f10), TransitionUtils.lerp(0, 255, f11, f12, f10));
        }
    };
    private static final FadeModeEvaluator THROUGH = new FadeModeEvaluator() { // from class: com.google.android.material.transition.FadeModeEvaluators.4
        @Override // com.google.android.material.transition.FadeModeEvaluator
        public FadeModeResult evaluate(float f10, float f11, float f12, float f13) {
            float fA = a.a(f12, f11, f13, f11);
            return FadeModeResult.startOnTop(TransitionUtils.lerp(255, 0, f11, fA, f10), TransitionUtils.lerp(0, 255, fA, f12, f10));
        }
    };

    private FadeModeEvaluators() {
    }

    public static FadeModeEvaluator get(int i10, boolean z10) {
        if (i10 == 0) {
            return z10 ? IN : OUT;
        }
        if (i10 == 1) {
            return z10 ? OUT : IN;
        }
        if (i10 == 2) {
            return CROSS;
        }
        if (i10 == 3) {
            return THROUGH;
        }
        throw new IllegalArgumentException(h.a.a("Invalid fade mode: ", i10));
    }
}
