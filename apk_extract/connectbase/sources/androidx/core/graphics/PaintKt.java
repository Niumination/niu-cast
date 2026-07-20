package androidx.core.graphics;

import android.graphics.Paint;
import kn.l0;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes.dex */
public final class PaintKt {
    public static final boolean setBlendMode(@l Paint paint, @m BlendModeCompat blendModeCompat) {
        l0.p(paint, "<this>");
        return PaintCompat.setBlendMode(paint, blendModeCompat);
    }
}
