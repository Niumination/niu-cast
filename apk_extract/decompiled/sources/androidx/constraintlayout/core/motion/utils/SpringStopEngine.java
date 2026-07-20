package androidx.constraintlayout.core.motion.utils;

/* JADX INFO: loaded from: classes.dex */
public class SpringStopEngine implements StopEngine {
    private static final double UNSET = Double.MAX_VALUE;
    private float mLastTime;
    private double mLastVelocity;
    private float mMass;
    private float mPos;
    private double mStiffness;
    private float mStopThreshold;
    private double mTargetPos;
    private float mV;
    double mDamping = 0.5d;
    private boolean mInitialized = false;
    private int mBoundaryMode = 0;

    private void compute(double d7) {
        double d10 = this.mStiffness;
        double d11 = this.mDamping;
        int iSqrt = (int) ((9.0d / ((Math.sqrt(d10 / ((double) this.mMass)) * d7) * 4.0d)) + 1.0d);
        double d12 = d7 / ((double) iSqrt);
        int i8 = 0;
        while (i8 < iSqrt) {
            float f = this.mPos;
            double d13 = this.mTargetPos;
            float f4 = this.mV;
            double d14 = d10;
            double d15 = ((-d10) * (((double) f) - d13)) - (((double) f4) * d11);
            float f10 = this.mMass;
            double d16 = d11;
            double d17 = (((d15 / ((double) f10)) * d12) / 2.0d) + ((double) f4);
            double d18 = ((((-((((d12 * d17) / 2.0d) + ((double) f)) - d13)) * d14) - (d17 * d16)) / ((double) f10)) * d12;
            float f11 = (float) (((double) f4) + d18);
            this.mV = f11;
            float f12 = (float) ((((d18 / 2.0d) + ((double) f4)) * d12) + ((double) f));
            this.mPos = f12;
            int i9 = this.mBoundaryMode;
            if (i9 > 0) {
                if (f12 < 0.0f && (i9 & 1) == 1) {
                    this.mPos = -f12;
                    this.mV = -f11;
                }
                float f13 = this.mPos;
                if (f13 > 1.0f && (i9 & 2) == 2) {
                    this.mPos = 2.0f - f13;
                    this.mV = -this.mV;
                }
            }
            i8++;
            d10 = d14;
            d11 = d16;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public String debug(String str, float f) {
        return null;
    }

    public float getAcceleration() {
        double d7 = this.mStiffness;
        return ((float) (((-d7) * (((double) this.mPos) - this.mTargetPos)) - (this.mDamping * ((double) this.mV)))) / this.mMass;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getInterpolation(float f) {
        compute(f - this.mLastTime);
        this.mLastTime = f;
        return this.mPos;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getVelocity() {
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public boolean isStopped() {
        double d7 = ((double) this.mPos) - this.mTargetPos;
        double d10 = this.mStiffness;
        double d11 = this.mV;
        return Math.sqrt((((d10 * d7) * d7) + ((d11 * d11) * ((double) this.mMass))) / d10) <= ((double) this.mStopThreshold);
    }

    public void log(String str) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        String str2 = ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName() + "() ";
        System.out.println(str2 + str);
    }

    public void springConfig(float f, float f4, float f10, float f11, float f12, float f13, float f14, int i8) {
        this.mTargetPos = f4;
        this.mDamping = f13;
        this.mInitialized = false;
        this.mPos = f;
        this.mLastVelocity = f10;
        this.mStiffness = f12;
        this.mMass = f11;
        this.mStopThreshold = f14;
        this.mBoundaryMode = i8;
        this.mLastTime = 0.0f;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getVelocity(float f) {
        return this.mV;
    }
}
