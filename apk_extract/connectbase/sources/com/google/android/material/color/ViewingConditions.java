package com.google.android.material.color;

/* JADX INFO: loaded from: classes.dex */
final class ViewingConditions {
    public static final ViewingConditions DEFAULT = make(ColorUtils.whitePointD65(), (float) ((((double) ColorUtils.yFromLstar(50.0f)) * 63.66197723675813d) / 100.0d), 50.0f, 2.0f, false);
    private final float aw;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f1780c;

    /* JADX INFO: renamed from: fl, reason: collision with root package name */
    private final float f1781fl;
    private final float flRoot;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final float f1782n;
    private final float nbb;

    /* JADX INFO: renamed from: nc, reason: collision with root package name */
    private final float f1783nc;
    private final float ncb;
    private final float[] rgbD;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final float f1784z;

    private ViewingConditions(float f10, float f11, float f12, float f13, float f14, float f15, float[] fArr, float f16, float f17, float f18) {
        this.f1782n = f10;
        this.aw = f11;
        this.nbb = f12;
        this.ncb = f13;
        this.f1780c = f14;
        this.f1783nc = f15;
        this.rgbD = fArr;
        this.f1781fl = f16;
        this.flRoot = f17;
        this.f1784z = f18;
    }

    public static ViewingConditions make(float[] fArr, float f10, float f11, float f12, boolean z10) {
        float[][] fArr2 = Cam16.XYZ_TO_CAM16RGB;
        float f13 = fArr[0];
        float[] fArr3 = fArr2[0];
        float f14 = fArr3[0] * f13;
        float f15 = fArr[1];
        float f16 = (fArr3[1] * f15) + f14;
        float f17 = fArr[2];
        float f18 = (fArr3[2] * f17) + f16;
        float[] fArr4 = fArr2[1];
        float f19 = (fArr4[2] * f17) + (fArr4[1] * f15) + (fArr4[0] * f13);
        float[] fArr5 = fArr2[2];
        float f20 = (f17 * fArr5[2]) + (f15 * fArr5[1]) + (f13 * fArr5[0]);
        float f21 = (f12 / 10.0f) + 0.8f;
        float fLerp = ((double) f21) >= 0.9d ? MathUtils.lerp(0.59f, 0.69f, (f21 - 0.9f) * 10.0f) : MathUtils.lerp(0.525f, 0.59f, (f21 - 0.8f) * 10.0f);
        float fExp = z10 ? 1.0f : (1.0f - (((float) Math.exp(((-f10) - 42.0f) / 92.0f)) * 0.2777778f)) * f21;
        double d10 = fExp;
        if (d10 > 1.0d) {
            fExp = 1.0f;
        } else if (d10 < 0.0d) {
            fExp = 0.0f;
        }
        float[] fArr6 = {(((100.0f / f18) * fExp) + 1.0f) - fExp, (((100.0f / f19) * fExp) + 1.0f) - fExp, (((100.0f / f20) * fExp) + 1.0f) - fExp};
        float f22 = 1.0f / ((5.0f * f10) + 1.0f);
        float f23 = f22 * f22 * f22 * f22;
        float f24 = 1.0f - f23;
        float fCbrt = (0.1f * f24 * f24 * ((float) Math.cbrt(((double) f10) * 5.0d))) + (f23 * f10);
        float fYFromLstar = ColorUtils.yFromLstar(f11) / fArr[1];
        double d11 = fYFromLstar;
        float fSqrt = ((float) Math.sqrt(d11)) + 1.48f;
        float fPow = 0.725f / ((float) Math.pow(d11, 0.2d));
        float[] fArr7 = {(float) Math.pow(((double) ((fArr6[0] * fCbrt) * f18)) / 100.0d, 0.42d), (float) Math.pow(((double) ((fArr6[1] * fCbrt) * f19)) / 100.0d, 0.42d), (float) Math.pow(((double) ((fArr6[2] * fCbrt) * f20)) / 100.0d, 0.42d)};
        float f25 = fArr7[0];
        float f26 = (f25 * 400.0f) / (f25 + 27.13f);
        float f27 = fArr7[1];
        float f28 = (f27 * 400.0f) / (f27 + 27.13f);
        float f29 = fArr7[2];
        float[] fArr8 = {f26, f28, (400.0f * f29) / (f29 + 27.13f)};
        return new ViewingConditions(fYFromLstar, ((fArr8[2] * 0.05f) + (fArr8[0] * 2.0f) + fArr8[1]) * fPow, fPow, fPow, fLerp, f21, fArr6, fCbrt, (float) Math.pow(fCbrt, 0.25d), fSqrt);
    }

    public float getAw() {
        return this.aw;
    }

    public float getC() {
        return this.f1780c;
    }

    public float getFl() {
        return this.f1781fl;
    }

    public float getFlRoot() {
        return this.flRoot;
    }

    public float getN() {
        return this.f1782n;
    }

    public float getNbb() {
        return this.nbb;
    }

    public float getNc() {
        return this.f1783nc;
    }

    public float getNcb() {
        return this.ncb;
    }

    public float[] getRgbD() {
        return this.rgbD;
    }

    public float getZ() {
        return this.f1784z;
    }
}
