package androidx.core.content.res;

import android.content.res.TypedArray;
import android.graphics.Typeface;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.StyleableRes;
import in.n;
import kn.l0;
import os.l;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(26)
final class TypedArrayApi26ImplKt {

    @l
    public static final TypedArrayApi26ImplKt INSTANCE = new TypedArrayApi26ImplKt();

    private TypedArrayApi26ImplKt() {
    }

    @n
    @DoNotInline
    @l
    public static final Typeface getFont(@l TypedArray typedArray, @StyleableRes int i10) {
        l0.p(typedArray, "typedArray");
        Typeface font = typedArray.getFont(i10);
        l0.m(font);
        return font;
    }
}
