package com.google.android.material.color;

/* JADX INFO: loaded from: classes.dex */
final class Cam16 {
    private final float astar;
    private final float bstar;
    private final float chroma;
    private final float hue;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final float f1776j;
    private final float jstar;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final float f1777m;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final float f1778q;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final float f1779s;
    static final float[][] XYZ_TO_CAM16RGB = {new float[]{0.401288f, 0.650173f, -0.051461f}, new float[]{-0.250268f, 1.204414f, 0.045854f}, new float[]{-0.002079f, 0.048952f, 0.953127f}};
    static final float[][] CAM16RGB_TO_XYZ = {new float[]{1.8620678f, -1.0112547f, 0.14918678f}, new float[]{0.38752654f, 0.62144744f, -0.00897398f}, new float[]{-0.0158415f, -0.03412294f, 1.0499644f}};

    private Cam16(float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18) {
        this.hue = f10;
        this.chroma = f11;
        this.f1776j = f12;
        this.f1778q = f13;
        this.f1777m = f14;
        this.f1779s = f15;
        this.jstar = f16;
        this.astar = f17;
        this.bstar = f18;
    }

    public static Cam16 fromInt(int i10) {
        return fromIntInViewingConditions(i10, ViewingConditions.DEFAULT);
    }

    public static Cam16 fromIntInViewingConditions(int i10, ViewingConditions viewingConditions) {
        float fLinearized = ColorUtils.linearized(((16711680 & i10) >> 16) / 255.0f) * 100.0f;
        float fLinearized2 = ColorUtils.linearized(((65280 & i10) >> 8) / 255.0f) * 100.0f;
        float fLinearized3 = ColorUtils.linearized((i10 & 255) / 255.0f) * 100.0f;
        float f10 = (0.18051042f * fLinearized3) + (0.35762063f * fLinearized2) + (0.41233894f * fLinearized);
        float f11 = (0.0722f * fLinearized3) + (0.7152f * fLinearized2) + (0.2126f * fLinearized);
        float f12 = (fLinearized3 * 0.9503448f) + (fLinearized2 * 0.11916382f) + (fLinearized * 0.01932141f);
        float[][] fArr = XYZ_TO_CAM16RGB;
        float[] fArr2 = fArr[0];
        float f13 = (fArr2[2] * f12) + (fArr2[1] * f11) + (fArr2[0] * f10);
        float[] fArr3 = fArr[1];
        float f14 = (fArr3[2] * f12) + (fArr3[1] * f11) + (fArr3[0] * f10);
        float[] fArr4 = fArr[2];
        float f15 = (f12 * fArr4[2]) + (f11 * fArr4[1]) + (f10 * fArr4[0]);
        float f16 = viewingConditions.getRgbD()[0] * f13;
        float f17 = viewingConditions.getRgbD()[1] * f14;
        float f18 = viewingConditions.getRgbD()[2] * f15;
        float fPow = (float) Math.pow(((double) (Math.abs(f16) * viewingConditions.getFl())) / 100.0d, 0.42d);
        float fPow2 = (float) Math.pow(((double) (Math.abs(f17) * viewingConditions.getFl())) / 100.0d, 0.42d);
        float fPow3 = (float) Math.pow(((double) (Math.abs(f18) * viewingConditions.getFl())) / 100.0d, 0.42d);
        float fSignum = ((Math.signum(f16) * 400.0f) * fPow) / (fPow + 27.13f);
        float fSignum2 = ((Math.signum(f17) * 400.0f) * fPow2) / (fPow2 + 27.13f);
        float fSignum3 = ((Math.signum(f18) * 400.0f) * fPow3) / (fPow3 + 27.13f);
        double d10 = fSignum3;
        float f19 = ((float) (((((double) fSignum2) * (-12.0d)) + (((double) fSignum) * 11.0d)) + d10)) / 11.0f;
        float f20 = ((float) (((double) (fSignum + fSignum2)) - (d10 * 2.0d))) / 9.0f;
        float f21 = fSignum2 * 20.0f;
        float f22 = ((21.0f * fSignum3) + ((fSignum * 20.0f) + f21)) / 20.0f;
        float f23 = (((fSignum * 40.0f) + f21) + fSignum3) / 20.0f;
        double d11 = f20;
        double d12 = f19;
        float fAtan2 = (((float) Math.atan2(d11, d12)) * 180.0f) / 3.1415927f;
        if (fAtan2 < 0.0f) {
            fAtan2 += 360.0f;
        } else if (fAtan2 >= 360.0f) {
            fAtan2 -= 360.0f;
        }
        float f24 = (3.1415927f * fAtan2) / 180.0f;
        float fPow4 = ((float) Math.pow((f23 * viewingConditions.getNbb()) / viewingConditions.getAw(), viewingConditions.getC() * viewingConditions.getZ())) * 100.0f;
        float aw = (viewingConditions.getAw() + 4.0f) * (4.0f / viewingConditions.getC()) * ((float) Math.sqrt(fPow4 / 100.0f)) * viewingConditions.getFlRoot();
        float fPow5 = ((float) Math.pow(1.64d - Math.pow(0.29d, viewingConditions.getN()), 0.73d)) * ((float) Math.pow((((((((float) (Math.cos(Math.toRadians(((double) fAtan2) < 20.14d ? 360.0f + fAtan2 : fAtan2) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * viewingConditions.getNc()) * viewingConditions.getNcb()) * ((float) Math.hypot(d12, d11))) / (f22 + 0.305f), 0.9d));
        float fSqrt = fPow5 * ((float) Math.sqrt(((double) fPow4) / 100.0d));
        float flRoot = fSqrt * viewingConditions.getFlRoot();
        float fSqrt2 = ((float) Math.sqrt((fPow5 * viewingConditions.getC()) / (viewingConditions.getAw() + 4.0f))) * 50.0f;
        float f25 = (1.7f * fPow4) / ((0.007f * fPow4) + 1.0f);
        float fLog1p = ((float) Math.log1p(0.0228f * flRoot)) * 43.85965f;
        double d13 = f24;
        return new Cam16(fAtan2, fSqrt, fPow4, aw, flRoot, fSqrt2, f25, fLog1p * ((float) Math.cos(d13)), fLog1p * ((float) Math.sin(d13)));
    }

    public static Cam16 fromJch(float f10, float f11, float f12) {
        return fromJchInViewingConditions(f10, f11, f12, ViewingConditions.DEFAULT);
    }

    private static Cam16 fromJchInViewingConditions(float f10, float f11, float f12, ViewingConditions viewingConditions) {
        double d10 = ((double) f10) / 100.0d;
        float aw = (viewingConditions.getAw() + 4.0f) * (4.0f / viewingConditions.getC()) * ((float) Math.sqrt(d10)) * viewingConditions.getFlRoot();
        float flRoot = f11 * viewingConditions.getFlRoot();
        float fSqrt = ((float) Math.sqrt(((f11 / ((float) Math.sqrt(d10))) * viewingConditions.getC()) / (viewingConditions.getAw() + 4.0f))) * 50.0f;
        float f13 = (1.7f * f10) / ((0.007f * f10) + 1.0f);
        float fLog1p = ((float) Math.log1p(((double) flRoot) * 0.0228d)) * 43.85965f;
        double d11 = (3.1415927f * f12) / 180.0f;
        return new Cam16(f12, f11, f10, aw, flRoot, fSqrt, f13, fLog1p * ((float) Math.cos(d11)), fLog1p * ((float) Math.sin(d11)));
    }

    public static Cam16 fromUcs(float f10, float f11, float f12) {
        return fromUcsInViewingConditions(f10, f11, f12, ViewingConditions.DEFAULT);
    }

    public static Cam16 fromUcsInViewingConditions(float f10, float f11, float f12, ViewingConditions viewingConditions) {
        double d10 = f11;
        double d11 = f12;
        double dExpm1 = (Math.expm1(Math.hypot(d10, d11) * 0.02280000038444996d) / 0.02280000038444996d) / ((double) viewingConditions.getFlRoot());
        double dAtan2 = Math.atan2(d11, d10) * 57.29577951308232d;
        if (dAtan2 < 0.0d) {
            dAtan2 += 360.0d;
        }
        return fromJchInViewingConditions(f10 / (1.0f - ((f10 - 100.0f) * 0.007f)), (float) dExpm1, (float) dAtan2, viewingConditions);
    }

    public float distance(Cam16 cam16) {
        float jStar = getJStar() - cam16.getJStar();
        float aStar = getAStar() - cam16.getAStar();
        float bStar = getBStar() - cam16.getBStar();
        return (float) (Math.pow(Math.sqrt((bStar * bStar) + (aStar * aStar) + (jStar * jStar)), 0.63d) * 1.41d);
    }

    public float getAStar() {
        return this.astar;
    }

    public float getBStar() {
        return this.bstar;
    }

    public float getChroma() {
        return this.chroma;
    }

    public float getHue() {
        return this.hue;
    }

    public int getInt() {
        return viewed(ViewingConditions.DEFAULT);
    }

    public float getJ() {
        return this.f1776j;
    }

    public float getJStar() {
        return this.jstar;
    }

    public float getM() {
        return this.f1777m;
    }

    public float getQ() {
        return this.f1778q;
    }

    public float getS() {
        return this.f1779s;
    }

    public int viewed(ViewingConditions viewingConditions) {
        float fPow = (float) Math.pow(((double) ((((double) getChroma()) == 0.0d || ((double) getJ()) == 0.0d) ? 0.0f : getChroma() / ((float) Math.sqrt(((double) getJ()) / 100.0d)))) / Math.pow(1.64d - Math.pow(0.29d, viewingConditions.getN()), 0.73d), 1.1111111111111112d);
        double hue = (getHue() * 3.1415927f) / 180.0f;
        float fCos = ((float) (Math.cos(2.0d + hue) + 3.8d)) * 0.25f;
        float aw = viewingConditions.getAw() * ((float) Math.pow(((double) getJ()) / 100.0d, (1.0d / ((double) viewingConditions.getC())) / ((double) viewingConditions.getZ())));
        float nc2 = fCos * 3846.1538f * viewingConditions.getNc() * viewingConditions.getNcb();
        float nbb = aw / viewingConditions.getNbb();
        float fSin = (float) Math.sin(hue);
        float fCos2 = (float) Math.cos(hue);
        float f10 = (((0.305f + nbb) * 23.0f) * fPow) / (((fPow * 108.0f) * fSin) + (((11.0f * fPow) * fCos2) + (nc2 * 23.0f)));
        float f11 = fCos2 * f10;
        float f12 = f10 * fSin;
        float f13 = nbb * 460.0f;
        float f14 = ((288.0f * f12) + ((451.0f * f11) + f13)) / 1403.0f;
        float f15 = ((f13 - (891.0f * f11)) - (261.0f * f12)) / 1403.0f;
        float f16 = ((f13 - (f11 * 220.0f)) - (f12 * 6300.0f)) / 1403.0f;
        float fl2 = (100.0f / viewingConditions.getFl()) * Math.signum(f14) * ((float) Math.pow((float) Math.max(0.0d, (((double) Math.abs(f14)) * 27.13d) / (400.0d - ((double) Math.abs(f14)))), 2.380952380952381d));
        float fl3 = (100.0f / viewingConditions.getFl()) * Math.signum(f15) * ((float) Math.pow((float) Math.max(0.0d, (((double) Math.abs(f15)) * 27.13d) / (400.0d - ((double) Math.abs(f15)))), 2.380952380952381d));
        float fl4 = (100.0f / viewingConditions.getFl()) * Math.signum(f16) * ((float) Math.pow((float) Math.max(0.0d, (((double) Math.abs(f16)) * 27.13d) / (400.0d - ((double) Math.abs(f16)))), 2.380952380952381d));
        float f17 = fl2 / viewingConditions.getRgbD()[0];
        float f18 = fl3 / viewingConditions.getRgbD()[1];
        float f19 = fl4 / viewingConditions.getRgbD()[2];
        float[][] fArr = CAM16RGB_TO_XYZ;
        float[] fArr2 = fArr[0];
        float f20 = (fArr2[2] * f19) + (fArr2[1] * f18) + (fArr2[0] * f17);
        float[] fArr3 = fArr[1];
        float f21 = (fArr3[2] * f19) + (fArr3[1] * f18) + (fArr3[0] * f17);
        float[] fArr4 = fArr[2];
        return ColorUtils.intFromXyzComponents(f20, f21, (f19 * fArr4[2]) + (f18 * fArr4[1]) + (f17 * fArr4[0]));
    }
}
