package androidx.constraintlayout.core.motion.utils;

import h0.a;
import o.d;

/* JADX INFO: loaded from: classes.dex */
public class StopLogicEngine implements StopEngine {
    private static final float EPSILON = 1.0E-5f;
    private boolean mBackwards = false;
    private boolean mDone = false;
    private float mLastPosition;
    private int mNumberOfStages;
    private float mStage1Duration;
    private float mStage1EndPosition;
    private float mStage1Velocity;
    private float mStage2Duration;
    private float mStage2EndPosition;
    private float mStage2Velocity;
    private float mStage3Duration;
    private float mStage3EndPosition;
    private float mStage3Velocity;
    private float mStartPosition;
    private String mType;

    private float calcY(float f) {
        this.mDone = false;
        float f4 = this.mStage1Duration;
        if (f <= f4) {
            float f10 = this.mStage1Velocity;
            return ((((this.mStage2Velocity - f10) * f) * f) / (f4 * 2.0f)) + (f10 * f);
        }
        int i8 = this.mNumberOfStages;
        if (i8 == 1) {
            return this.mStage1EndPosition;
        }
        float f11 = f - f4;
        float f12 = this.mStage2Duration;
        if (f11 < f12) {
            float f13 = this.mStage1EndPosition;
            float f14 = this.mStage2Velocity;
            return ((((this.mStage3Velocity - f14) * f11) * f11) / (f12 * 2.0f)) + (f14 * f11) + f13;
        }
        if (i8 == 2) {
            return this.mStage2EndPosition;
        }
        float f15 = f11 - f12;
        float f16 = this.mStage3Duration;
        if (f15 > f16) {
            this.mDone = true;
            return this.mStage3EndPosition;
        }
        float f17 = this.mStage2EndPosition;
        float f18 = this.mStage3Velocity;
        return ((f18 * f15) + f17) - (((f18 * f15) * f15) / (f16 * 2.0f));
    }

    private void setup(float f, float f4, float f10, float f11, float f12) {
        this.mDone = false;
        if (f == 0.0f) {
            f = 1.0E-4f;
        }
        this.mStage1Velocity = f;
        float f13 = f / f10;
        float f14 = (f13 * f) / 2.0f;
        if (f < 0.0f) {
            float fSqrt = (float) Math.sqrt((f4 - ((((-f) / f10) * f) / 2.0f)) * f10);
            if (fSqrt < f11) {
                this.mType = "backward accelerate, decelerate";
                this.mNumberOfStages = 2;
                this.mStage1Velocity = f;
                this.mStage2Velocity = fSqrt;
                this.mStage3Velocity = 0.0f;
                float f15 = (fSqrt - f) / f10;
                this.mStage1Duration = f15;
                this.mStage2Duration = fSqrt / f10;
                this.mStage1EndPosition = ((f + fSqrt) * f15) / 2.0f;
                this.mStage2EndPosition = f4;
                this.mStage3EndPosition = f4;
                return;
            }
            this.mType = "backward accelerate cruse decelerate";
            this.mNumberOfStages = 3;
            this.mStage1Velocity = f;
            this.mStage2Velocity = f11;
            this.mStage3Velocity = f11;
            float f16 = (f11 - f) / f10;
            this.mStage1Duration = f16;
            float f17 = f11 / f10;
            this.mStage3Duration = f17;
            float f18 = ((f + f11) * f16) / 2.0f;
            float f19 = (f17 * f11) / 2.0f;
            this.mStage2Duration = ((f4 - f18) - f19) / f11;
            this.mStage1EndPosition = f18;
            this.mStage2EndPosition = f4 - f19;
            this.mStage3EndPosition = f4;
            return;
        }
        if (f14 >= f4) {
            this.mType = "hard stop";
            this.mNumberOfStages = 1;
            this.mStage1Velocity = f;
            this.mStage2Velocity = 0.0f;
            this.mStage1EndPosition = f4;
            this.mStage1Duration = (2.0f * f4) / f;
            return;
        }
        float f20 = f4 - f14;
        float f21 = f20 / f;
        if (f21 + f13 < f12) {
            this.mType = "cruse decelerate";
            this.mNumberOfStages = 2;
            this.mStage1Velocity = f;
            this.mStage2Velocity = f;
            this.mStage3Velocity = 0.0f;
            this.mStage1EndPosition = f20;
            this.mStage2EndPosition = f4;
            this.mStage1Duration = f21;
            this.mStage2Duration = f13;
            return;
        }
        float fSqrt2 = (float) Math.sqrt(((f * f) / 2.0f) + (f10 * f4));
        float f22 = (fSqrt2 - f) / f10;
        this.mStage1Duration = f22;
        float f23 = fSqrt2 / f10;
        this.mStage2Duration = f23;
        if (fSqrt2 < f11) {
            this.mType = "accelerate decelerate";
            this.mNumberOfStages = 2;
            this.mStage1Velocity = f;
            this.mStage2Velocity = fSqrt2;
            this.mStage3Velocity = 0.0f;
            this.mStage1Duration = f22;
            this.mStage2Duration = f23;
            this.mStage1EndPosition = ((f + fSqrt2) * f22) / 2.0f;
            this.mStage2EndPosition = f4;
            return;
        }
        this.mType = "accelerate cruse decelerate";
        this.mNumberOfStages = 3;
        this.mStage1Velocity = f;
        this.mStage2Velocity = f11;
        this.mStage3Velocity = f11;
        float f24 = (f11 - f) / f10;
        this.mStage1Duration = f24;
        float f25 = f11 / f10;
        this.mStage3Duration = f25;
        float f26 = ((f + f11) * f24) / 2.0f;
        float f27 = (f25 * f11) / 2.0f;
        this.mStage2Duration = ((f4 - f26) - f27) / f11;
        this.mStage1EndPosition = f26;
        this.mStage2EndPosition = f4 - f27;
        this.mStage3EndPosition = f4;
    }

    public void config(float f, float f4, float f10, float f11, float f12, float f13) {
        this.mDone = false;
        this.mStartPosition = f;
        boolean z2 = f > f4;
        this.mBackwards = z2;
        if (z2) {
            setup(-f10, f - f4, f12, f13, f11);
        } else {
            setup(f10, f4 - f, f12, f13, f11);
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public String debug(String str, float f) {
        StringBuilder sbT = d.t(a.n(d.t(str, " ===== "), this.mType, "\n"), str);
        sbT.append(this.mBackwards ? "backwards" : "forward ");
        sbT.append(" time = ");
        sbT.append(f);
        sbT.append("  stages ");
        String str2 = a.m(sbT, "\n", this.mNumberOfStages) + str + " dur " + this.mStage1Duration + " vel " + this.mStage1Velocity + " pos " + this.mStage1EndPosition + "\n";
        if (this.mNumberOfStages > 1) {
            str2 = str2 + str + " dur " + this.mStage2Duration + " vel " + this.mStage2Velocity + " pos " + this.mStage2EndPosition + "\n";
        }
        if (this.mNumberOfStages > 2) {
            str2 = str2 + str + " dur " + this.mStage3Duration + " vel " + this.mStage3Velocity + " pos " + this.mStage3EndPosition + "\n";
        }
        float f4 = this.mStage1Duration;
        if (f <= f4) {
            return d.l(str2, str, "stage 0\n");
        }
        int i8 = this.mNumberOfStages;
        if (i8 == 1) {
            return d.l(str2, str, "end stage 0\n");
        }
        float f10 = f - f4;
        float f11 = this.mStage2Duration;
        if (f10 < f11) {
            return d.l(str2, str, " stage 1\n");
        }
        if (i8 == 2) {
            return d.l(str2, str, "end stage 1\n");
        }
        return f10 - f11 < this.mStage3Duration ? d.l(str2, str, " stage 2\n") : d.l(str2, str, " end stage 2\n");
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getInterpolation(float f) {
        float fCalcY = calcY(f);
        this.mLastPosition = f;
        boolean z2 = this.mBackwards;
        float f4 = this.mStartPosition;
        return z2 ? f4 - fCalcY : f4 + fCalcY;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getVelocity(float f) {
        float f4 = this.mStage1Duration;
        if (f <= f4) {
            float f10 = this.mStage1Velocity;
            return (((this.mStage2Velocity - f10) * f) / f4) + f10;
        }
        int i8 = this.mNumberOfStages;
        if (i8 == 1) {
            return 0.0f;
        }
        float f11 = f - f4;
        float f12 = this.mStage2Duration;
        if (f11 < f12) {
            float f13 = this.mStage2Velocity;
            return (((this.mStage3Velocity - f13) * f11) / f12) + f13;
        }
        if (i8 == 2) {
            return this.mStage2EndPosition;
        }
        float f14 = f11 - f12;
        float f15 = this.mStage3Duration;
        if (f14 >= f15) {
            return this.mStage3EndPosition;
        }
        float f16 = this.mStage3Velocity;
        return f16 - ((f14 * f16) / f15);
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public boolean isStopped() {
        return getVelocity() < EPSILON && Math.abs(this.mStage3EndPosition - this.mLastPosition) < EPSILON;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getVelocity() {
        return this.mBackwards ? -getVelocity(this.mLastPosition) : getVelocity(this.mLastPosition);
    }
}
