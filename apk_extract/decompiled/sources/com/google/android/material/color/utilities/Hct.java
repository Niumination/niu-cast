package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class Hct {
    private int argb;
    private double chroma;
    private double hue;
    private double tone;

    private Hct(int i8) {
        setInternalState(i8);
    }

    public static Hct from(double d7, double d10, double d11) {
        return new Hct(HctSolver.solveToInt(d7, d10, d11));
    }

    public static Hct fromInt(int i8) {
        return new Hct(i8);
    }

    private void setInternalState(int i8) {
        this.argb = i8;
        Cam16 cam16FromInt = Cam16.fromInt(i8);
        this.hue = cam16FromInt.getHue();
        this.chroma = cam16FromInt.getChroma();
        this.tone = ColorUtils.lstarFromArgb(i8);
    }

    public double getChroma() {
        return this.chroma;
    }

    public double getHue() {
        return this.hue;
    }

    public double getTone() {
        return this.tone;
    }

    public Hct inViewingConditions(ViewingConditions viewingConditions) {
        double[] dArrXyzInViewingConditions = Cam16.fromInt(toInt()).xyzInViewingConditions(viewingConditions, null);
        Cam16 cam16FromXyzInViewingConditions = Cam16.fromXyzInViewingConditions(dArrXyzInViewingConditions[0], dArrXyzInViewingConditions[1], dArrXyzInViewingConditions[2], ViewingConditions.DEFAULT);
        return from(cam16FromXyzInViewingConditions.getHue(), cam16FromXyzInViewingConditions.getChroma(), ColorUtils.lstarFromY(dArrXyzInViewingConditions[1]));
    }

    public void setChroma(double d7) {
        setInternalState(HctSolver.solveToInt(this.hue, d7, this.tone));
    }

    public void setHue(double d7) {
        setInternalState(HctSolver.solveToInt(d7, this.chroma, this.tone));
    }

    public void setTone(double d7) {
        setInternalState(HctSolver.solveToInt(this.hue, this.chroma, d7));
    }

    public int toInt() {
        return this.argb;
    }
}
