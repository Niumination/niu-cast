package androidx.databinding.adapters;

import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import androidx.databinding.BindingConversion;

/* JADX INFO: loaded from: classes.dex */
public class Converters {
    @BindingConversion
    public static ColorStateList convertColorToColorStateList(int i8) {
        return ColorStateList.valueOf(i8);
    }

    @BindingConversion
    public static ColorDrawable convertColorToDrawable(int i8) {
        return new ColorDrawable(i8);
    }
}
