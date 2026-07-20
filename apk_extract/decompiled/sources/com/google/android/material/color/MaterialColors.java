package com.google.android.material.color;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.ScatterMapKt;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.R;
import com.google.android.material.color.utilities.Blend;
import com.google.android.material.color.utilities.Contrast;
import com.google.android.material.color.utilities.Hct;
import com.google.android.material.resources.MaterialAttributes;

/* JADX INFO: loaded from: classes.dex */
public class MaterialColors {
    public static final float ALPHA_DISABLED = 0.38f;
    public static final float ALPHA_DISABLED_LOW = 0.12f;
    public static final float ALPHA_FULL = 1.0f;
    public static final float ALPHA_LOW = 0.32f;
    public static final float ALPHA_MEDIUM = 0.54f;
    private static final int CHROMA_NEUTRAL = 6;
    private static final int TONE_ACCENT_CONTAINER_DARK = 30;
    private static final int TONE_ACCENT_CONTAINER_LIGHT = 90;
    private static final int TONE_ACCENT_DARK = 80;
    private static final int TONE_ACCENT_LIGHT = 40;
    private static final int TONE_ON_ACCENT_CONTAINER_DARK = 90;
    private static final int TONE_ON_ACCENT_CONTAINER_LIGHT = 10;
    private static final int TONE_ON_ACCENT_DARK = 20;
    private static final int TONE_ON_ACCENT_LIGHT = 100;
    private static final int TONE_SURFACE_CONTAINER_DARK = 12;
    private static final int TONE_SURFACE_CONTAINER_HIGH_DARK = 17;
    private static final int TONE_SURFACE_CONTAINER_HIGH_LIGHT = 92;
    private static final int TONE_SURFACE_CONTAINER_LIGHT = 94;

    private MaterialColors() {
    }

    @ColorInt
    public static int compositeARGBWithAlpha(@ColorInt int i8, @IntRange(from = 0, to = ScatterMapKt.Sentinel) int i9) {
        return ColorUtils.setAlphaComponent(i8, (Color.alpha(i8) * i9) / 255);
    }

    @ColorInt
    public static int getColor(@NonNull View view, @AttrRes int i8) {
        return resolveColor(view.getContext(), MaterialAttributes.resolveTypedValueOrThrow(view, i8));
    }

    @Nullable
    @ColorInt
    public static Integer getColorOrNull(@NonNull Context context, @AttrRes int i8) {
        TypedValue typedValueResolve = MaterialAttributes.resolve(context, i8);
        if (typedValueResolve != null) {
            return Integer.valueOf(resolveColor(context, typedValueResolve));
        }
        return null;
    }

    @ColorInt
    private static int getColorRole(@ColorInt int i8, @IntRange(from = 0, to = 100) int i9) {
        Hct hctFromInt = Hct.fromInt(i8);
        hctFromInt.setTone(i9);
        return hctFromInt.toInt();
    }

    @NonNull
    public static ColorRoles getColorRoles(@NonNull Context context, @ColorInt int i8) {
        return getColorRoles(i8, isLightTheme(context));
    }

    @NonNull
    public static ColorStateList getColorStateList(@NonNull Context context, @AttrRes int i8, @NonNull ColorStateList colorStateList) {
        TypedValue typedValueResolve = MaterialAttributes.resolve(context, i8);
        ColorStateList colorStateListResolveColorStateList = typedValueResolve != null ? resolveColorStateList(context, typedValueResolve) : null;
        return colorStateListResolveColorStateList == null ? colorStateList : colorStateListResolveColorStateList;
    }

    @Nullable
    public static ColorStateList getColorStateListOrNull(@NonNull Context context, @AttrRes int i8) {
        TypedValue typedValueResolve = MaterialAttributes.resolve(context, i8);
        if (typedValueResolve == null) {
            return null;
        }
        int i9 = typedValueResolve.resourceId;
        if (i9 != 0) {
            return ContextCompat.getColorStateList(context, i9);
        }
        int i10 = typedValueResolve.data;
        if (i10 != 0) {
            return ColorStateList.valueOf(i10);
        }
        return null;
    }

    @ColorInt
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static int getSurfaceContainerFromSeed(@NonNull Context context, @ColorInt int i8) {
        return getColorRole(i8, isLightTheme(context) ? TONE_SURFACE_CONTAINER_LIGHT : 12, 6);
    }

    @ColorInt
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static int getSurfaceContainerHighFromSeed(@NonNull Context context, @ColorInt int i8) {
        return getColorRole(i8, isLightTheme(context) ? TONE_SURFACE_CONTAINER_HIGH_LIGHT : 17, 6);
    }

    @ColorInt
    public static int harmonize(@ColorInt int i8, @ColorInt int i9) {
        return Blend.harmonize(i8, i9);
    }

    @ColorInt
    public static int harmonizeWithPrimary(@NonNull Context context, @ColorInt int i8) {
        return harmonize(i8, getColor(context, R.attr.colorPrimary, MaterialColors.class.getCanonicalName()));
    }

    public static boolean isColorLight(@ColorInt int i8) {
        return i8 != 0 && ColorUtils.calculateLuminance(i8) > 0.5d;
    }

    public static boolean isLightTheme(@NonNull Context context) {
        return MaterialAttributes.resolveBoolean(context, R.attr.isLightTheme, true);
    }

    @ColorInt
    public static int layer(@NonNull View view, @AttrRes int i8, @AttrRes int i9) {
        return layer(view, i8, i9, 1.0f);
    }

    private static int resolveColor(@NonNull Context context, @NonNull TypedValue typedValue) {
        int i8 = typedValue.resourceId;
        return i8 != 0 ? ContextCompat.getColor(context, i8) : typedValue.data;
    }

    private static ColorStateList resolveColorStateList(@NonNull Context context, @NonNull TypedValue typedValue) {
        int i8 = typedValue.resourceId;
        return i8 != 0 ? ContextCompat.getColorStateList(context, i8) : ColorStateList.valueOf(typedValue.data);
    }

    @NonNull
    public static ColorRoles getColorRoles(@ColorInt int i8, boolean z2) {
        return z2 ? new ColorRoles(getColorRole(i8, 40), getColorRole(i8, 100), getColorRole(i8, 90), getColorRole(i8, 10)) : new ColorRoles(getColorRole(i8, TONE_ACCENT_DARK), getColorRole(i8, 20), getColorRole(i8, 30), getColorRole(i8, 90));
    }

    @ColorInt
    public static int layer(@NonNull View view, @AttrRes int i8, @AttrRes int i9, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f) {
        return layer(getColor(view, i8), getColor(view, i9), f);
    }

    @ColorInt
    public static int getColor(Context context, @AttrRes int i8, String str) {
        return resolveColor(context, MaterialAttributes.resolveTypedValueOrThrow(context, i8, str));
    }

    @ColorInt
    private static int getColorRole(@ColorInt int i8, @IntRange(from = 0, to = 100) int i9, int i10) {
        Hct hctFromInt = Hct.fromInt(getColorRole(i8, i9));
        hctFromInt.setChroma(i10);
        return hctFromInt.toInt();
    }

    @ColorInt
    public static int layer(@ColorInt int i8, @ColorInt int i9, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f) {
        return layer(i8, ColorUtils.setAlphaComponent(i9, Math.round(Color.alpha(i9) * f)));
    }

    @ColorInt
    public static int getColor(@NonNull View view, @AttrRes int i8, @ColorInt int i9) {
        return getColor(view.getContext(), i8, i9);
    }

    @ColorInt
    public static int getColor(@NonNull Context context, @AttrRes int i8, @ColorInt int i9) {
        Integer colorOrNull = getColorOrNull(context, i8);
        return colorOrNull != null ? colorOrNull.intValue() : i9;
    }

    @ColorInt
    public static int layer(@ColorInt int i8, @ColorInt int i9) {
        return ColorUtils.compositeColors(i9, i8);
    }
}
