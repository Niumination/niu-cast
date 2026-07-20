package n0;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import androidx.annotation.ColorInt;

/* JADX INFO: loaded from: classes.dex */
public class u extends PorterDuffColorFilter {
    public u(@ColorInt int i10) {
        super(i10, PorterDuff.Mode.SRC_ATOP);
    }
}
