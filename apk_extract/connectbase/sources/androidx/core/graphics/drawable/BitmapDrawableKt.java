package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import kn.l0;
import os.l;

/* JADX INFO: loaded from: classes.dex */
public final class BitmapDrawableKt {
    @l
    public static final BitmapDrawable toDrawable(@l Bitmap bitmap, @l Resources resources) {
        l0.p(bitmap, "<this>");
        l0.p(resources, "resources");
        return new BitmapDrawable(resources, bitmap);
    }
}
