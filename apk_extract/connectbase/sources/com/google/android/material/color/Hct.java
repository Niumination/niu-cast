package com.google.android.material.color;

import t.a;

/* JADX INFO: loaded from: classes.dex */
final class Hct {
    private static final float CHROMA_SEARCH_ENDPOINT = 0.4f;
    private static final float DE_MAX = 1.0f;
    private static final float DE_MAX_ERROR = 1.0E-9f;
    private static final float DL_MAX = 0.2f;
    private static final float LIGHTNESS_SEARCH_ENDPOINT = 0.01f;
    private float chroma;
    private float hue;
    private float tone;

    private Hct(float f10, float f11, float f12) {
        setInternalState(gamutMap(f10, f11, f12));
    }

    private static Cam16 findCamByJ(float f10, float f11, float f12) {
        float f13 = 100.0f;
        float f14 = 1000.0f;
        float f15 = 0.0f;
        Cam16 cam16 = null;
        float f16 = 1000.0f;
        while (Math.abs(f15 - f13) > LIGHTNESS_SEARCH_ENDPOINT) {
            float fA = a.a(f13, f15, 2.0f, f15);
            int i10 = Cam16.fromJch(fA, f11, f10).getInt();
            float fLstarFromInt = ColorUtils.lstarFromInt(i10);
            float fAbs = Math.abs(f12 - fLstarFromInt);
            if (fAbs < 0.2f) {
                Cam16 cam16FromInt = Cam16.fromInt(i10);
                float fDistance = cam16FromInt.distance(Cam16.fromJch(cam16FromInt.getJ(), cam16FromInt.getChroma(), f10));
                if (fDistance <= 1.0f && fDistance <= f14) {
                    cam16 = cam16FromInt;
                    f16 = fAbs;
                    f14 = fDistance;
                }
            }
            if (f16 == 0.0f && f14 < DE_MAX_ERROR) {
                break;
            }
            if (fLstarFromInt < f12) {
                f15 = fA;
            } else {
                f13 = fA;
            }
        }
        return cam16;
    }

    public static Hct from(float f10, float f11, float f12) {
        return new Hct(f10, f11, f12);
    }

    public static Hct fromInt(int i10) {
        Cam16 cam16FromInt = Cam16.fromInt(i10);
        return new Hct(cam16FromInt.getHue(), cam16FromInt.getChroma(), ColorUtils.lstarFromInt(i10));
    }

    private static int gamutMap(float f10, float f11, float f12) {
        return gamutMapInViewingConditions(f10, f11, f12, ViewingConditions.DEFAULT);
    }

    public static int gamutMapInViewingConditions(float f10, float f11, float f12, ViewingConditions viewingConditions) {
        if (f11 < 1.0d || Math.round(f12) <= 0.0d || Math.round(f12) >= 100.0d) {
            return ColorUtils.intFromLstar(f12);
        }
        float fSanitizeDegrees = MathUtils.sanitizeDegrees(f10);
        Cam16 cam16 = null;
        boolean z10 = true;
        float f13 = 0.0f;
        float fA = f11;
        while (Math.abs(f13 - f11) >= CHROMA_SEARCH_ENDPOINT) {
            Cam16 cam16FindCamByJ = findCamByJ(fSanitizeDegrees, fA, f12);
            if (!z10) {
                if (cam16FindCamByJ == null) {
                    f11 = fA;
                } else {
                    f13 = fA;
                    cam16 = cam16FindCamByJ;
                }
                fA = a.a(f11, f13, 2.0f, f13);
            } else {
                if (cam16FindCamByJ != null) {
                    return cam16FindCamByJ.viewed(viewingConditions);
                }
                fA = a.a(f11, f13, 2.0f, f13);
                z10 = false;
            }
        }
        return cam16 == null ? ColorUtils.intFromLstar(f12) : cam16.viewed(viewingConditions);
    }

    private void setInternalState(int i10) {
        Cam16 cam16FromInt = Cam16.fromInt(i10);
        float fLstarFromInt = ColorUtils.lstarFromInt(i10);
        this.hue = cam16FromInt.getHue();
        this.chroma = cam16FromInt.getChroma();
        this.tone = fLstarFromInt;
    }

    public float getChroma() {
        return this.chroma;
    }

    public float getHue() {
        return this.hue;
    }

    public float getTone() {
        return this.tone;
    }

    public void setChroma(float f10) {
        setInternalState(gamutMap(this.hue, f10, this.tone));
    }

    public void setHue(float f10) {
        setInternalState(gamutMap(MathUtils.sanitizeDegrees(f10), this.chroma, this.tone));
    }

    public void setTone(float f10) {
        setInternalState(gamutMap(this.hue, this.chroma, f10));
    }

    public int toInt() {
        return gamutMap(this.hue, this.chroma, this.tone);
    }
}
