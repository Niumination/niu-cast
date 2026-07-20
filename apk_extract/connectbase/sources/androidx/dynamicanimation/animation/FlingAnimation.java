package androidx.dynamicanimation.animation;

import androidx.annotation.FloatRange;

/* JADX INFO: loaded from: classes.dex */
public final class FlingAnimation extends DynamicAnimation<FlingAnimation> {
    private final DragForce mFlingForce;

    public static final class DragForce implements Force {
        private static final float DEFAULT_FRICTION = -4.2f;
        private static final float VELOCITY_THRESHOLD_MULTIPLIER = 62.5f;
        private float mFriction = DEFAULT_FRICTION;
        private final DynamicAnimation.MassState mMassState = new DynamicAnimation.MassState();
        private float mVelocityThreshold;

        @Override // androidx.dynamicanimation.animation.Force
        public float getAcceleration(float f10, float f11) {
            return f11 * this.mFriction;
        }

        public float getFrictionScalar() {
            return this.mFriction / DEFAULT_FRICTION;
        }

        @Override // androidx.dynamicanimation.animation.Force
        public boolean isAtEquilibrium(float f10, float f11) {
            return Math.abs(f11) < this.mVelocityThreshold;
        }

        public void setFrictionScalar(float f10) {
            this.mFriction = f10 * DEFAULT_FRICTION;
        }

        public void setValueThreshold(float f10) {
            this.mVelocityThreshold = f10 * VELOCITY_THRESHOLD_MULTIPLIER;
        }

        public DynamicAnimation.MassState updateValueAndVelocity(float f10, float f11, long j10) {
            float f12 = j10;
            this.mMassState.mVelocity = (float) (Math.exp((f12 / 1000.0f) * this.mFriction) * ((double) f11));
            DynamicAnimation.MassState massState = this.mMassState;
            float f13 = this.mFriction;
            massState.mValue = (float) ((Math.exp((f13 * f12) / 1000.0f) * ((double) (f11 / f13))) + ((double) (f10 - (f11 / f13))));
            DynamicAnimation.MassState massState2 = this.mMassState;
            if (isAtEquilibrium(massState2.mValue, massState2.mVelocity)) {
                this.mMassState.mVelocity = 0.0f;
            }
            return this.mMassState;
        }
    }

    public FlingAnimation(FloatValueHolder floatValueHolder) {
        super(floatValueHolder);
        DragForce dragForce = new DragForce();
        this.mFlingForce = dragForce;
        dragForce.setValueThreshold(getValueThreshold());
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public float getAcceleration(float f10, float f11) {
        return this.mFlingForce.getAcceleration(f10, f11);
    }

    public float getFriction() {
        return this.mFlingForce.getFrictionScalar();
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public boolean isAtEquilibrium(float f10, float f11) {
        return f10 >= this.mMaxValue || f10 <= this.mMinValue || this.mFlingForce.isAtEquilibrium(f10, f11);
    }

    public FlingAnimation setFriction(@FloatRange(from = 0.0d, fromInclusive = false) float f10) {
        if (f10 <= 0.0f) {
            throw new IllegalArgumentException("Friction must be positive");
        }
        this.mFlingForce.setFrictionScalar(f10);
        return this;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public void setValueThreshold(float f10) {
        this.mFlingForce.setValueThreshold(f10);
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public boolean updateValueAndVelocity(long j10) {
        DynamicAnimation.MassState massStateUpdateValueAndVelocity = this.mFlingForce.updateValueAndVelocity(this.mValue, this.mVelocity, j10);
        float f10 = massStateUpdateValueAndVelocity.mValue;
        this.mValue = f10;
        float f11 = massStateUpdateValueAndVelocity.mVelocity;
        this.mVelocity = f11;
        float f12 = this.mMinValue;
        if (f10 < f12) {
            this.mValue = f12;
            return true;
        }
        float f13 = this.mMaxValue;
        if (f10 <= f13) {
            return isAtEquilibrium(f10, f11);
        }
        this.mValue = f13;
        return true;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public FlingAnimation setMaxValue(float f10) {
        super.setMaxValue(f10);
        return this;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public FlingAnimation setMinValue(float f10) {
        super.setMinValue(f10);
        return this;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public FlingAnimation setStartVelocity(float f10) {
        super.setStartVelocity(f10);
        return this;
    }

    public <K> FlingAnimation(K k10, FloatPropertyCompat<K> floatPropertyCompat) {
        super(k10, floatPropertyCompat);
        DragForce dragForce = new DragForce();
        this.mFlingForce = dragForce;
        dragForce.setValueThreshold(getValueThreshold());
    }
}
