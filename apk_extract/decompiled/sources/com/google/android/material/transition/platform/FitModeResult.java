package com.google.android.material.transition.platform;

import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
class FitModeResult {
    final float currentEndHeight;
    final float currentEndWidth;
    final float currentStartHeight;
    final float currentStartWidth;
    final float endScale;
    final float startScale;

    public FitModeResult(float f, float f4, float f10, float f11, float f12, float f13) {
        this.startScale = f;
        this.endScale = f4;
        this.currentStartWidth = f10;
        this.currentStartHeight = f11;
        this.currentEndWidth = f12;
        this.currentEndHeight = f13;
    }
}
