package androidx.core.graphics;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import kn.l0;
import os.l;

/* JADX INFO: loaded from: classes.dex */
public final class PorterDuffKt {
    @l
    public static final PorterDuffColorFilter toColorFilter(@l PorterDuff.Mode mode, int i10) {
        l0.p(mode, "<this>");
        return new PorterDuffColorFilter(i10, mode);
    }

    @l
    public static final PorterDuffXfermode toXfermode(@l PorterDuff.Mode mode) {
        l0.p(mode, "<this>");
        return new PorterDuffXfermode(mode);
    }
}
