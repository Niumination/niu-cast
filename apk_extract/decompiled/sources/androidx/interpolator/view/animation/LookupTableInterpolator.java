package androidx.interpolator.view.animation;

import a1.a;
import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes.dex */
abstract class LookupTableInterpolator implements Interpolator {
    private final float mStepSize;
    private final float[] mValues;

    public LookupTableInterpolator(float[] fArr) {
        this.mValues = fArr;
        this.mStepSize = 1.0f / (fArr.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.mValues;
        int iMin = Math.min((int) ((fArr.length - 1) * f), fArr.length - 2);
        float f4 = this.mStepSize;
        float f10 = (f - (iMin * f4)) / f4;
        float[] fArr2 = this.mValues;
        float f11 = fArr2[iMin];
        return a.b(fArr2[iMin + 1], f11, f10, f11);
    }
}
