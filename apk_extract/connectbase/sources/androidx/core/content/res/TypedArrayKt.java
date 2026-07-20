package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import androidx.annotation.AnyRes;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.RequiresApi;
import androidx.annotation.StyleableRes;
import kn.l0;
import os.l;

/* JADX INFO: loaded from: classes.dex */
public final class TypedArrayKt {
    private static final void checkAttribute(TypedArray typedArray, @StyleableRes int i10) {
        if (!typedArray.hasValue(i10)) {
            throw new IllegalArgumentException("Attribute not defined in set.");
        }
    }

    public static final boolean getBooleanOrThrow(@l TypedArray typedArray, @StyleableRes int i10) {
        l0.p(typedArray, "<this>");
        checkAttribute(typedArray, i10);
        return typedArray.getBoolean(i10, false);
    }

    @ColorInt
    public static final int getColorOrThrow(@l TypedArray typedArray, @StyleableRes int i10) {
        l0.p(typedArray, "<this>");
        checkAttribute(typedArray, i10);
        return typedArray.getColor(i10, 0);
    }

    @l
    public static final ColorStateList getColorStateListOrThrow(@l TypedArray typedArray, @StyleableRes int i10) {
        l0.p(typedArray, "<this>");
        checkAttribute(typedArray, i10);
        ColorStateList colorStateList = typedArray.getColorStateList(i10);
        if (colorStateList != null) {
            return colorStateList;
        }
        throw new IllegalStateException("Attribute value was not a color or color state list.");
    }

    public static final float getDimensionOrThrow(@l TypedArray typedArray, @StyleableRes int i10) {
        l0.p(typedArray, "<this>");
        checkAttribute(typedArray, i10);
        return typedArray.getDimension(i10, 0.0f);
    }

    @Dimension
    public static final int getDimensionPixelOffsetOrThrow(@l TypedArray typedArray, @StyleableRes int i10) {
        l0.p(typedArray, "<this>");
        checkAttribute(typedArray, i10);
        return typedArray.getDimensionPixelOffset(i10, 0);
    }

    @Dimension
    public static final int getDimensionPixelSizeOrThrow(@l TypedArray typedArray, @StyleableRes int i10) {
        l0.p(typedArray, "<this>");
        checkAttribute(typedArray, i10);
        return typedArray.getDimensionPixelSize(i10, 0);
    }

    @l
    public static final Drawable getDrawableOrThrow(@l TypedArray typedArray, @StyleableRes int i10) {
        l0.p(typedArray, "<this>");
        checkAttribute(typedArray, i10);
        Drawable drawable = typedArray.getDrawable(i10);
        l0.m(drawable);
        return drawable;
    }

    public static final float getFloatOrThrow(@l TypedArray typedArray, @StyleableRes int i10) {
        l0.p(typedArray, "<this>");
        checkAttribute(typedArray, i10);
        return typedArray.getFloat(i10, 0.0f);
    }

    @RequiresApi(26)
    @l
    public static final Typeface getFontOrThrow(@l TypedArray typedArray, @StyleableRes int i10) {
        l0.p(typedArray, "<this>");
        checkAttribute(typedArray, i10);
        return TypedArrayApi26ImplKt.getFont(typedArray, i10);
    }

    public static final int getIntOrThrow(@l TypedArray typedArray, @StyleableRes int i10) {
        l0.p(typedArray, "<this>");
        checkAttribute(typedArray, i10);
        return typedArray.getInt(i10, 0);
    }

    public static final int getIntegerOrThrow(@l TypedArray typedArray, @StyleableRes int i10) {
        l0.p(typedArray, "<this>");
        checkAttribute(typedArray, i10);
        return typedArray.getInteger(i10, 0);
    }

    @AnyRes
    public static final int getResourceIdOrThrow(@l TypedArray typedArray, @StyleableRes int i10) {
        l0.p(typedArray, "<this>");
        checkAttribute(typedArray, i10);
        return typedArray.getResourceId(i10, 0);
    }

    @l
    public static final String getStringOrThrow(@l TypedArray typedArray, @StyleableRes int i10) {
        l0.p(typedArray, "<this>");
        checkAttribute(typedArray, i10);
        String string = typedArray.getString(i10);
        if (string != null) {
            return string;
        }
        throw new IllegalStateException("Attribute value could not be coerced to String.");
    }

    @l
    public static final CharSequence[] getTextArrayOrThrow(@l TypedArray typedArray, @StyleableRes int i10) {
        l0.p(typedArray, "<this>");
        checkAttribute(typedArray, i10);
        CharSequence[] textArray = typedArray.getTextArray(i10);
        l0.o(textArray, "getTextArray(index)");
        return textArray;
    }

    @l
    public static final CharSequence getTextOrThrow(@l TypedArray typedArray, @StyleableRes int i10) {
        l0.p(typedArray, "<this>");
        checkAttribute(typedArray, i10);
        CharSequence text = typedArray.getText(i10);
        if (text != null) {
            return text;
        }
        throw new IllegalStateException("Attribute value could not be coerced to CharSequence.");
    }

    public static final <R> R use(@l TypedArray typedArray, @l jn.l<? super TypedArray, ? extends R> lVar) {
        l0.p(typedArray, "<this>");
        l0.p(lVar, "block");
        R rInvoke = lVar.invoke(typedArray);
        typedArray.recycle();
        return rInvoke;
    }
}
