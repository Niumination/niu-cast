package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class TonalPalette {
    Map<Integer, Integer> cache = new HashMap();
    double chroma;
    double hue;
    Hct keyColor;

    private TonalPalette(double d7, double d10, Hct hct) {
        this.hue = d7;
        this.chroma = d10;
        this.keyColor = hct;
    }

    private static Hct createKeyColor(double d7, double d10) {
        Hct hctFrom = Hct.from(d7, d10, 50.0d);
        Hct hct = hctFrom;
        double dAbs = Math.abs(hctFrom.getChroma() - d10);
        for (double d11 = 1.0d; d11 < 50.0d && Math.round(d10) != Math.round(hct.getChroma()); d11 += 1.0d) {
            Hct hctFrom2 = Hct.from(d7, d10, 50.0d + d11);
            double dAbs2 = Math.abs(hctFrom2.getChroma() - d10);
            if (dAbs2 < dAbs) {
                hct = hctFrom2;
                dAbs = dAbs2;
            }
            Hct hctFrom3 = Hct.from(d7, d10, 50.0d - d11);
            double dAbs3 = Math.abs(hctFrom3.getChroma() - d10);
            if (dAbs3 < dAbs) {
                hct = hctFrom3;
                dAbs = dAbs3;
            }
        }
        return hct;
    }

    public static TonalPalette fromHct(Hct hct) {
        return new TonalPalette(hct.getHue(), hct.getChroma(), hct);
    }

    public static TonalPalette fromHueAndChroma(double d7, double d10) {
        return new TonalPalette(d7, d10, createKeyColor(d7, d10));
    }

    public static TonalPalette fromInt(int i8) {
        return fromHct(Hct.fromInt(i8));
    }

    public double getChroma() {
        return this.chroma;
    }

    public Hct getHct(double d7) {
        return Hct.from(this.hue, this.chroma, d7);
    }

    public double getHue() {
        return this.hue;
    }

    public Hct getKeyColor() {
        return this.keyColor;
    }

    public int tone(int i8) {
        Integer numValueOf = this.cache.get(Integer.valueOf(i8));
        if (numValueOf == null) {
            numValueOf = Integer.valueOf(Hct.from(this.hue, this.chroma, i8).toInt());
            this.cache.put(Integer.valueOf(i8), numValueOf);
        }
        return numValueOf.intValue();
    }
}
