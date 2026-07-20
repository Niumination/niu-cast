package androidx.core.graphics.drawable;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import b.a;
import kn.l0;
import os.l;

/* JADX INFO: loaded from: classes.dex */
public final class ColorDrawableKt {
    @l
    public static final ColorDrawable toDrawable(@ColorInt int i10) {
        return new ColorDrawable(i10);
    }

    @RequiresApi(26)
    @a({"ClassVerificationFailure"})
    @l
    public static final ColorDrawable toDrawable(@l Color color) {
        l0.p(color, "<this>");
        return new ColorDrawable(color.toArgb());
    }
}
