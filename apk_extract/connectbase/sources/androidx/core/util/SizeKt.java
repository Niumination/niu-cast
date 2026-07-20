package androidx.core.util;

import android.util.Size;
import android.util.SizeF;
import androidx.annotation.RequiresApi;
import b.a;
import kn.l0;
import os.l;

/* JADX INFO: loaded from: classes.dex */
@a({"ClassVerificationFailure"})
public final class SizeKt {
    @RequiresApi(21)
    public static final int component1(@l Size size) {
        l0.p(size, "<this>");
        return size.getWidth();
    }

    @RequiresApi(21)
    public static final int component2(@l Size size) {
        l0.p(size, "<this>");
        return size.getHeight();
    }

    @RequiresApi(21)
    public static final float component1(@l SizeF sizeF) {
        l0.p(sizeF, "<this>");
        return sizeF.getWidth();
    }

    @RequiresApi(21)
    public static final float component2(@l SizeF sizeF) {
        l0.p(sizeF, "<this>");
        return sizeF.getHeight();
    }

    public static final float component1(@l SizeFCompat sizeFCompat) {
        l0.p(sizeFCompat, "<this>");
        return sizeFCompat.getWidth();
    }

    public static final float component2(@l SizeFCompat sizeFCompat) {
        l0.p(sizeFCompat, "<this>");
        return sizeFCompat.getHeight();
    }
}
