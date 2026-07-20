package nj;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes2.dex */
public class a implements Interpolator {
    public a() {
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f10) {
        float f11 = f10 - 1.0f;
        return (((f11 * 2.70158f) + 1.70158f) * f11 * f11) + 1.0f;
    }

    public a(Context context, AttributeSet attributeSet) {
    }
}
