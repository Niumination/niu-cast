package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class CorePalette {

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    public TonalPalette f2220a1;

    /* JADX INFO: renamed from: a2, reason: collision with root package name */
    public TonalPalette f2221a2;

    /* JADX INFO: renamed from: a3, reason: collision with root package name */
    public TonalPalette f2222a3;
    public TonalPalette error;

    /* JADX INFO: renamed from: n1, reason: collision with root package name */
    public TonalPalette f2223n1;
    public TonalPalette n2;

    private CorePalette(int i8, boolean z2) {
        Hct hctFromInt = Hct.fromInt(i8);
        double hue = hctFromInt.getHue();
        double chroma = hctFromInt.getChroma();
        if (z2) {
            this.f2220a1 = TonalPalette.fromHueAndChroma(hue, chroma);
            this.f2221a2 = TonalPalette.fromHueAndChroma(hue, chroma / 3.0d);
            this.f2222a3 = TonalPalette.fromHueAndChroma(60.0d + hue, chroma / 2.0d);
            this.f2223n1 = TonalPalette.fromHueAndChroma(hue, Math.min(chroma / 12.0d, 4.0d));
            this.n2 = TonalPalette.fromHueAndChroma(hue, Math.min(chroma / 6.0d, 8.0d));
        } else {
            this.f2220a1 = TonalPalette.fromHueAndChroma(hue, Math.max(48.0d, chroma));
            this.f2221a2 = TonalPalette.fromHueAndChroma(hue, 16.0d);
            this.f2222a3 = TonalPalette.fromHueAndChroma(60.0d + hue, 24.0d);
            this.f2223n1 = TonalPalette.fromHueAndChroma(hue, 4.0d);
            this.n2 = TonalPalette.fromHueAndChroma(hue, 8.0d);
        }
        this.error = TonalPalette.fromHueAndChroma(25.0d, 84.0d);
    }

    public static CorePalette contentOf(int i8) {
        return new CorePalette(i8, true);
    }

    public static CorePalette of(int i8) {
        return new CorePalette(i8, false);
    }
}
