package yd;

import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements Interpolator {
    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f) {
        float f4 = f - 1.0f;
        return (f4 * f4 * f4 * f4 * f4) + 1.0f;
    }
}
