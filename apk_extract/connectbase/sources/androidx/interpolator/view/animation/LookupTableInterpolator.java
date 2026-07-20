package androidx.interpolator.view.animation;

import android.view.animation.Interpolator;
import g.a;

/* JADX INFO: loaded from: classes.dex */
abstract class LookupTableInterpolator implements Interpolator {
    private final float mStepSize;
    private final float[] mValues;

    public LookupTableInterpolator(float[] fArr) {
        this.mValues = fArr;
        this.mStepSize = 1.0f / (fArr.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f10) {
        if (f10 >= 1.0f) {
            return 1.0f;
        }
        if (f10 <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.mValues;
        int iMin = Math.min((int) ((fArr.length - 1) * f10), fArr.length - 2);
        float f11 = this.mStepSize;
        float f12 = (f10 - (iMin * f11)) / f11;
        float[] fArr2 = this.mValues;
        float f13 = fArr2[iMin];
        return a.a(fArr2[iMin + 1], f13, f12, f13);
    }
}
