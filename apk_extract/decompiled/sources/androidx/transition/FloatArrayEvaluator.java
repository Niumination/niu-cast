package androidx.transition;

import android.animation.TypeEvaluator;

/* JADX INFO: loaded from: classes.dex */
class FloatArrayEvaluator implements TypeEvaluator<float[]> {
    private float[] mArray;

    public FloatArrayEvaluator(float[] fArr) {
        this.mArray = fArr;
    }

    @Override // android.animation.TypeEvaluator
    public float[] evaluate(float f, float[] fArr, float[] fArr2) {
        float[] fArr3 = this.mArray;
        if (fArr3 == null) {
            fArr3 = new float[fArr.length];
        }
        for (int i8 = 0; i8 < fArr3.length; i8++) {
            float f4 = fArr[i8];
            fArr3[i8] = a1.a.b(fArr2[i8], f4, f, f4);
        }
        return fArr3;
    }
}
