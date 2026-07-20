package com.google.android.material.transition;

/* JADX INFO: loaded from: classes.dex */
class FadeModeResult {
    final int endAlpha;
    final boolean endOnTop;
    final int startAlpha;

    private FadeModeResult(int i8, int i9, boolean z2) {
        this.startAlpha = i8;
        this.endAlpha = i9;
        this.endOnTop = z2;
    }

    public static FadeModeResult endOnTop(int i8, int i9) {
        return new FadeModeResult(i8, i9, true);
    }

    public static FadeModeResult startOnTop(int i8, int i9) {
        return new FadeModeResult(i8, i9, false);
    }
}
