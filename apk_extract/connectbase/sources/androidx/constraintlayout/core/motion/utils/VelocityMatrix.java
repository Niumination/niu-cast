package androidx.constraintlayout.core.motion.utils;

/* JADX INFO: loaded from: classes.dex */
public class VelocityMatrix {
    private static String TAG = "VelocityMatrix";
    float mDRotate;
    float mDScaleX;
    float mDScaleY;
    float mDTranslateX;
    float mDTranslateY;
    float mRotate;

    public void applyTransform(float f10, float f11, int i10, int i11, float[] fArr) {
        float f12 = fArr[0];
        float f13 = fArr[1];
        float f14 = (f10 - 0.5f) * 2.0f;
        float f15 = (f11 - 0.5f) * 2.0f;
        float f16 = f12 + this.mDTranslateX;
        float f17 = f13 + this.mDTranslateY;
        float f18 = (this.mDScaleX * f14) + f16;
        float f19 = (this.mDScaleY * f15) + f17;
        float radians = (float) Math.toRadians(this.mRotate);
        float radians2 = (float) Math.toRadians(this.mDRotate);
        double d10 = radians;
        double d11 = i11 * f15;
        float fSin = (((float) ((Math.sin(d10) * ((double) ((-i10) * f14))) - (Math.cos(d10) * d11))) * radians2) + f18;
        float fCos = (radians2 * ((float) ((Math.cos(d10) * ((double) (i10 * f14))) - (Math.sin(d10) * d11)))) + f19;
        fArr[0] = fSin;
        fArr[1] = fCos;
    }

    public void clear() {
        this.mDRotate = 0.0f;
        this.mDTranslateY = 0.0f;
        this.mDTranslateX = 0.0f;
        this.mDScaleY = 0.0f;
        this.mDScaleX = 0.0f;
    }

    public void setRotationVelocity(SplineSet splineSet, float f10) {
        if (splineSet != null) {
            this.mDRotate = splineSet.getSlope(f10);
            this.mRotate = splineSet.get(f10);
        }
    }

    public void setScaleVelocity(SplineSet splineSet, SplineSet splineSet2, float f10) {
        if (splineSet != null) {
            this.mDScaleX = splineSet.getSlope(f10);
        }
        if (splineSet2 != null) {
            this.mDScaleY = splineSet2.getSlope(f10);
        }
    }

    public void setTranslationVelocity(SplineSet splineSet, SplineSet splineSet2, float f10) {
        if (splineSet != null) {
            this.mDTranslateX = splineSet.getSlope(f10);
        }
        if (splineSet2 != null) {
            this.mDTranslateY = splineSet2.getSlope(f10);
        }
    }

    public void setRotationVelocity(KeyCycleOscillator keyCycleOscillator, float f10) {
        if (keyCycleOscillator != null) {
            this.mDRotate = keyCycleOscillator.getSlope(f10);
        }
    }

    public void setScaleVelocity(KeyCycleOscillator keyCycleOscillator, KeyCycleOscillator keyCycleOscillator2, float f10) {
        if (keyCycleOscillator != null) {
            this.mDScaleX = keyCycleOscillator.getSlope(f10);
        }
        if (keyCycleOscillator2 != null) {
            this.mDScaleY = keyCycleOscillator2.getSlope(f10);
        }
    }

    public void setTranslationVelocity(KeyCycleOscillator keyCycleOscillator, KeyCycleOscillator keyCycleOscillator2, float f10) {
        if (keyCycleOscillator != null) {
            this.mDTranslateX = keyCycleOscillator.getSlope(f10);
        }
        if (keyCycleOscillator2 != null) {
            this.mDTranslateY = keyCycleOscillator2.getSlope(f10);
        }
    }
}
