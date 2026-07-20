package androidx.core.graphics;

import android.graphics.Color;
import android.graphics.ColorSpace;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import b.a;
import kn.l0;
import os.l;

/* JADX INFO: loaded from: classes.dex */
public final class ColorKt {
    public static final int component1(@ColorInt int i10) {
        return (i10 >> 24) & 255;
    }

    public static final int component2(@ColorInt int i10) {
        return (i10 >> 16) & 255;
    }

    public static final int component3(@ColorInt int i10) {
        return (i10 >> 8) & 255;
    }

    public static final int component4(@ColorInt int i10) {
        return i10 & 255;
    }

    @RequiresApi(26)
    @a({"ClassVerificationFailure"})
    public static final long convertTo(@ColorInt int i10, @l ColorSpace.Named named) {
        l0.p(named, "colorSpace");
        return Color.convert(i10, ColorSpace.get(named));
    }

    public static final int getAlpha(@ColorInt int i10) {
        return (i10 >> 24) & 255;
    }

    public static final int getBlue(@ColorInt int i10) {
        return i10 & 255;
    }

    @RequiresApi(26)
    @a({"ClassVerificationFailure"})
    @l
    public static final ColorSpace getColorSpace(long j10) {
        ColorSpace colorSpace = Color.colorSpace(j10);
        l0.o(colorSpace, "colorSpace(this)");
        return colorSpace;
    }

    public static final int getGreen(@ColorInt int i10) {
        return (i10 >> 8) & 255;
    }

    @RequiresApi(26)
    @a({"ClassVerificationFailure"})
    public static final float getLuminance(@ColorInt int i10) {
        return Color.luminance(i10);
    }

    public static final int getRed(@ColorInt int i10) {
        return (i10 >> 16) & 255;
    }

    @RequiresApi(26)
    @a({"ClassVerificationFailure"})
    public static final boolean isSrgb(long j10) {
        return Color.isSrgb(j10);
    }

    @RequiresApi(26)
    @a({"ClassVerificationFailure"})
    public static final boolean isWideGamut(long j10) {
        return Color.isWideGamut(j10);
    }

    @RequiresApi(26)
    @a({"ClassVerificationFailure"})
    @l
    public static final Color plus(@l Color color, @l Color color2) {
        l0.p(color, "<this>");
        l0.p(color2, "c");
        Color colorCompositeColors = ColorUtils.compositeColors(color2, color);
        l0.o(colorCompositeColors, "compositeColors(c, this)");
        return colorCompositeColors;
    }

    @RequiresApi(26)
    @a({"ClassVerificationFailure"})
    @l
    public static final Color toColor(@ColorInt int i10) {
        Color colorValueOf = Color.valueOf(i10);
        l0.o(colorValueOf, "valueOf(this)");
        return colorValueOf;
    }

    @ColorInt
    @RequiresApi(26)
    @a({"ClassVerificationFailure"})
    public static final int toColorInt(long j10) {
        return Color.toArgb(j10);
    }

    @RequiresApi(26)
    @a({"ClassVerificationFailure"})
    public static final long toColorLong(@ColorInt int i10) {
        return Color.pack(i10);
    }

    @RequiresApi(26)
    @a({"ClassVerificationFailure"})
    public static final float component1(@l Color color) {
        l0.p(color, "<this>");
        return color.getComponent(0);
    }

    @RequiresApi(26)
    @a({"ClassVerificationFailure"})
    public static final float component2(@l Color color) {
        l0.p(color, "<this>");
        return color.getComponent(1);
    }

    @RequiresApi(26)
    @a({"ClassVerificationFailure"})
    public static final float component3(@l Color color) {
        l0.p(color, "<this>");
        return color.getComponent(2);
    }

    @RequiresApi(26)
    @a({"ClassVerificationFailure"})
    public static final float component4(@l Color color) {
        l0.p(color, "<this>");
        return color.getComponent(3);
    }

    @RequiresApi(26)
    @a({"ClassVerificationFailure"})
    public static final long convertTo(@ColorInt int i10, @l ColorSpace colorSpace) {
        l0.p(colorSpace, "colorSpace");
        return Color.convert(i10, colorSpace);
    }

    @RequiresApi(26)
    @a({"ClassVerificationFailure"})
    public static final float getAlpha(long j10) {
        return Color.alpha(j10);
    }

    @RequiresApi(26)
    @a({"ClassVerificationFailure"})
    public static final float getBlue(long j10) {
        return Color.blue(j10);
    }

    @RequiresApi(26)
    @a({"ClassVerificationFailure"})
    public static final float getGreen(long j10) {
        return Color.green(j10);
    }

    @RequiresApi(26)
    @a({"ClassVerificationFailure"})
    public static final float getLuminance(long j10) {
        return Color.luminance(j10);
    }

    @RequiresApi(26)
    @a({"ClassVerificationFailure"})
    public static final float getRed(long j10) {
        return Color.red(j10);
    }

    @RequiresApi(26)
    @a({"ClassVerificationFailure"})
    @l
    public static final Color toColor(long j10) {
        Color colorValueOf = Color.valueOf(j10);
        l0.o(colorValueOf, "valueOf(this)");
        return colorValueOf;
    }

    @ColorInt
    public static final int toColorInt(@l String str) {
        l0.p(str, "<this>");
        return Color.parseColor(str);
    }

    @RequiresApi(26)
    @a({"ClassVerificationFailure"})
    public static final float component1(long j10) {
        return Color.red(j10);
    }

    @RequiresApi(26)
    @a({"ClassVerificationFailure"})
    public static final float component2(long j10) {
        return Color.green(j10);
    }

    @RequiresApi(26)
    @a({"ClassVerificationFailure"})
    public static final float component3(long j10) {
        return Color.blue(j10);
    }

    @RequiresApi(26)
    @a({"ClassVerificationFailure"})
    public static final float component4(long j10) {
        return Color.alpha(j10);
    }

    @RequiresApi(26)
    @a({"ClassVerificationFailure"})
    public static final long convertTo(long j10, @l ColorSpace.Named named) {
        l0.p(named, "colorSpace");
        return Color.convert(j10, ColorSpace.get(named));
    }

    @RequiresApi(26)
    @a({"ClassVerificationFailure"})
    public static final long convertTo(long j10, @l ColorSpace colorSpace) {
        l0.p(colorSpace, "colorSpace");
        return Color.convert(j10, colorSpace);
    }

    @RequiresApi(26)
    @a({"ClassVerificationFailure"})
    @l
    public static final Color convertTo(@l Color color, @l ColorSpace.Named named) {
        l0.p(color, "<this>");
        l0.p(named, "colorSpace");
        Color colorConvert = color.convert(ColorSpace.get(named));
        l0.o(colorConvert, "convert(ColorSpace.get(colorSpace))");
        return colorConvert;
    }

    @RequiresApi(26)
    @a({"ClassVerificationFailure"})
    @l
    public static final Color convertTo(@l Color color, @l ColorSpace colorSpace) {
        l0.p(color, "<this>");
        l0.p(colorSpace, "colorSpace");
        Color colorConvert = color.convert(colorSpace);
        l0.o(colorConvert, "convert(colorSpace)");
        return colorConvert;
    }
}
