package androidx.dynamicanimation.animation;

import androidx.annotation.FloatRange;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
public final class SpringForce implements Force {
    public static final float DAMPING_RATIO_HIGH_BOUNCY = 0.2f;
    public static final float DAMPING_RATIO_LOW_BOUNCY = 0.75f;
    public static final float DAMPING_RATIO_MEDIUM_BOUNCY = 0.5f;
    public static final float DAMPING_RATIO_NO_BOUNCY = 1.0f;
    public static final float STIFFNESS_HIGH = 10000.0f;
    public static final float STIFFNESS_LOW = 200.0f;
    public static final float STIFFNESS_MEDIUM = 1500.0f;
    public static final float STIFFNESS_VERY_LOW = 50.0f;
    private static final double UNSET = Double.MAX_VALUE;
    private static final double VELOCITY_THRESHOLD_MULTIPLIER = 62.5d;
    private double mDampedFreq;
    double mDampingRatio;
    private double mFinalPosition;
    private double mGammaMinus;
    private double mGammaPlus;
    private boolean mInitialized;
    private final DynamicAnimation.MassState mMassState;
    double mNaturalFreq;
    private double mValueThreshold;
    private double mVelocityThreshold;

    public SpringForce() {
        this.mNaturalFreq = Math.sqrt(1500.0d);
        this.mDampingRatio = 0.5d;
        this.mInitialized = false;
        this.mFinalPosition = Double.MAX_VALUE;
        this.mMassState = new DynamicAnimation.MassState();
    }

    private void init() {
        if (this.mInitialized) {
            return;
        }
        if (this.mFinalPosition == Double.MAX_VALUE) {
            throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
        }
        double d7 = this.mDampingRatio;
        if (d7 > 1.0d) {
            double d10 = this.mNaturalFreq;
            this.mGammaPlus = (Math.sqrt((d7 * d7) - 1.0d) * d10) + ((-d7) * d10);
            double d11 = this.mDampingRatio;
            double d12 = this.mNaturalFreq;
            this.mGammaMinus = ((-d11) * d12) - (Math.sqrt((d11 * d11) - 1.0d) * d12);
        } else if (d7 >= 0.0d && d7 < 1.0d) {
            this.mDampedFreq = Math.sqrt(1.0d - (d7 * d7)) * this.mNaturalFreq;
        }
        this.mInitialized = true;
    }

    @Override // androidx.dynamicanimation.animation.Force
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public float getAcceleration(float f, float f4) {
        float finalPosition = f - getFinalPosition();
        double d7 = this.mNaturalFreq;
        return (float) (((-(d7 * d7)) * ((double) finalPosition)) - (((d7 * 2.0d) * this.mDampingRatio) * ((double) f4)));
    }

    public float getDampingRatio() {
        return (float) this.mDampingRatio;
    }

    public float getFinalPosition() {
        return (float) this.mFinalPosition;
    }

    public float getStiffness() {
        double d7 = this.mNaturalFreq;
        return (float) (d7 * d7);
    }

    @Override // androidx.dynamicanimation.animation.Force
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean isAtEquilibrium(float f, float f4) {
        return ((double) Math.abs(f4)) < this.mVelocityThreshold && ((double) Math.abs(f - getFinalPosition())) < this.mValueThreshold;
    }

    public SpringForce setDampingRatio(@FloatRange(from = 0.0d) float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("Damping ratio must be non-negative");
        }
        this.mDampingRatio = f;
        this.mInitialized = false;
        return this;
    }

    public SpringForce setFinalPosition(float f) {
        this.mFinalPosition = f;
        return this;
    }

    public SpringForce setStiffness(@FloatRange(from = 0.0d, fromInclusive = false) float f) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("Spring stiffness constant must be positive.");
        }
        this.mNaturalFreq = Math.sqrt(f);
        this.mInitialized = false;
        return this;
    }

    public void setValueThreshold(double d7) {
        double dAbs = Math.abs(d7);
        this.mValueThreshold = dAbs;
        this.mVelocityThreshold = dAbs * VELOCITY_THRESHOLD_MULTIPLIER;
    }

    public DynamicAnimation.MassState updateValues(double d7, double d10, long j8) {
        double dCos;
        double dPow;
        init();
        double d11 = j8 / 1000.0d;
        double d12 = d7 - this.mFinalPosition;
        double d13 = this.mDampingRatio;
        if (d13 > 1.0d) {
            double d14 = this.mGammaMinus;
            double d15 = this.mGammaPlus;
            double d16 = d12 - (((d14 * d12) - d10) / (d14 - d15));
            double d17 = ((d12 * d14) - d10) / (d14 - d15);
            dPow = (Math.pow(2.718281828459045d, this.mGammaPlus * d11) * d17) + (Math.pow(2.718281828459045d, d14 * d11) * d16);
            double d18 = this.mGammaMinus;
            double dPow2 = Math.pow(2.718281828459045d, d18 * d11) * d16 * d18;
            double d19 = this.mGammaPlus;
            dCos = (Math.pow(2.718281828459045d, d19 * d11) * d17 * d19) + dPow2;
        } else if (d13 == 1.0d) {
            double d20 = this.mNaturalFreq;
            double d21 = (d20 * d12) + d10;
            double d22 = (d21 * d11) + d12;
            double dPow3 = Math.pow(2.718281828459045d, (-d20) * d11) * d22;
            double dPow4 = Math.pow(2.718281828459045d, (-this.mNaturalFreq) * d11) * d22;
            double d23 = this.mNaturalFreq;
            dCos = (Math.pow(2.718281828459045d, (-d23) * d11) * d21) + (dPow4 * (-d23));
            dPow = dPow3;
        } else {
            double d24 = 1.0d / this.mDampedFreq;
            double d25 = this.mNaturalFreq;
            double d26 = ((d13 * d25 * d12) + d10) * d24;
            double dSin = ((Math.sin(this.mDampedFreq * d11) * d26) + (Math.cos(this.mDampedFreq * d11) * d12)) * Math.pow(2.718281828459045d, (-d13) * d25 * d11);
            double d27 = this.mNaturalFreq;
            double d28 = this.mDampingRatio;
            double d29 = (-d27) * dSin * d28;
            double dPow5 = Math.pow(2.718281828459045d, (-d28) * d27 * d11);
            double d30 = this.mDampedFreq;
            double dSin2 = Math.sin(d30 * d11) * (-d30) * d12;
            double d31 = this.mDampedFreq;
            dCos = (((Math.cos(d31 * d11) * d26 * d31) + dSin2) * dPow5) + d29;
            dPow = dSin;
        }
        DynamicAnimation.MassState massState = this.mMassState;
        massState.mValue = (float) (dPow + this.mFinalPosition);
        massState.mVelocity = (float) dCos;
        return massState;
    }

    public SpringForce(float f) {
        this.mNaturalFreq = Math.sqrt(1500.0d);
        this.mDampingRatio = 0.5d;
        this.mInitialized = false;
        this.mFinalPosition = Double.MAX_VALUE;
        this.mMassState = new DynamicAnimation.MassState();
        this.mFinalPosition = f;
    }
}
