package androidx.core.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.annotation.AnyRes;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleableRes;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class TypedArrayUtils {
    private static final String NAMESPACE = "http://schemas.android.com/apk/res/android";

    private TypedArrayUtils() {
    }

    public static int getAttr(@NonNull Context context, int i8, int i9) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i8, typedValue, true);
        return typedValue.resourceId != 0 ? i8 : i9;
    }

    public static boolean getBoolean(@NonNull TypedArray typedArray, @StyleableRes int i8, @StyleableRes int i9, boolean z2) {
        return typedArray.getBoolean(i8, typedArray.getBoolean(i9, z2));
    }

    @Nullable
    public static Drawable getDrawable(@NonNull TypedArray typedArray, @StyleableRes int i8, @StyleableRes int i9) {
        Drawable drawable = typedArray.getDrawable(i8);
        return drawable == null ? typedArray.getDrawable(i9) : drawable;
    }

    public static int getInt(@NonNull TypedArray typedArray, @StyleableRes int i8, @StyleableRes int i9, int i10) {
        return typedArray.getInt(i8, typedArray.getInt(i9, i10));
    }

    public static boolean getNamedBoolean(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, @StyleableRes int i8, boolean z2) {
        return !hasAttribute(xmlPullParser, str) ? z2 : typedArray.getBoolean(i8, z2);
    }

    @ColorInt
    public static int getNamedColor(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, @StyleableRes int i8, @ColorInt int i9) {
        return !hasAttribute(xmlPullParser, str) ? i9 : typedArray.getColor(i8, i9);
    }

    @Nullable
    public static ColorStateList getNamedColorStateList(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @Nullable Resources.Theme theme, @NonNull String str, @StyleableRes int i8) {
        if (!hasAttribute(xmlPullParser, str)) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(i8, typedValue);
        int i9 = typedValue.type;
        if (i9 != 2) {
            return (i9 < 28 || i9 > 31) ? ColorStateListInflaterCompat.inflate(typedArray.getResources(), typedArray.getResourceId(i8, 0), theme) : getNamedColorStateListFromInt(typedValue);
        }
        throw new UnsupportedOperationException("Failed to resolve attribute at index " + i8 + ": " + typedValue);
    }

    @NonNull
    private static ColorStateList getNamedColorStateListFromInt(@NonNull TypedValue typedValue) {
        return ColorStateList.valueOf(typedValue.data);
    }

    public static ComplexColorCompat getNamedComplexColor(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @Nullable Resources.Theme theme, @NonNull String str, @StyleableRes int i8, @ColorInt int i9) {
        if (hasAttribute(xmlPullParser, str)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i8, typedValue);
            int i10 = typedValue.type;
            if (i10 >= 28 && i10 <= 31) {
                return ComplexColorCompat.from(typedValue.data);
            }
            ComplexColorCompat complexColorCompatInflate = ComplexColorCompat.inflate(typedArray.getResources(), typedArray.getResourceId(i8, 0), theme);
            if (complexColorCompatInflate != null) {
                return complexColorCompatInflate;
            }
        }
        return ComplexColorCompat.from(i9);
    }

    public static float getNamedFloat(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, @StyleableRes int i8, float f) {
        return !hasAttribute(xmlPullParser, str) ? f : typedArray.getFloat(i8, f);
    }

    public static int getNamedInt(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, @StyleableRes int i8, int i9) {
        return !hasAttribute(xmlPullParser, str) ? i9 : typedArray.getInt(i8, i9);
    }

    @AnyRes
    public static int getNamedResourceId(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, @StyleableRes int i8, @AnyRes int i9) {
        return !hasAttribute(xmlPullParser, str) ? i9 : typedArray.getResourceId(i8, i9);
    }

    @Nullable
    public static String getNamedString(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, @StyleableRes int i8) {
        if (hasAttribute(xmlPullParser, str)) {
            return typedArray.getString(i8);
        }
        return null;
    }

    @AnyRes
    public static int getResourceId(@NonNull TypedArray typedArray, @StyleableRes int i8, @StyleableRes int i9, @AnyRes int i10) {
        return typedArray.getResourceId(i8, typedArray.getResourceId(i9, i10));
    }

    @Nullable
    public static String getString(@NonNull TypedArray typedArray, @StyleableRes int i8, @StyleableRes int i9) {
        String string = typedArray.getString(i8);
        return string == null ? typedArray.getString(i9) : string;
    }

    @Nullable
    public static CharSequence getText(@NonNull TypedArray typedArray, @StyleableRes int i8, @StyleableRes int i9) {
        CharSequence text = typedArray.getText(i8);
        return text == null ? typedArray.getText(i9) : text;
    }

    @Nullable
    public static CharSequence[] getTextArray(@NonNull TypedArray typedArray, @StyleableRes int i8, @StyleableRes int i9) {
        CharSequence[] textArray = typedArray.getTextArray(i8);
        return textArray == null ? typedArray.getTextArray(i9) : textArray;
    }

    public static boolean hasAttribute(@NonNull XmlPullParser xmlPullParser, @NonNull String str) {
        return xmlPullParser.getAttributeValue(NAMESPACE, str) != null;
    }

    @NonNull
    public static TypedArray obtainAttributes(@NonNull Resources resources, @Nullable Resources.Theme theme, @NonNull AttributeSet attributeSet, @NonNull int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    @Nullable
    public static TypedValue peekNamedValue(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, int i8) {
        if (hasAttribute(xmlPullParser, str)) {
            return typedArray.peekValue(i8);
        }
        return null;
    }
}
