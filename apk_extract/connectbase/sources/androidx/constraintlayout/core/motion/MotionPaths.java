package androidx.constraintlayout.core.motion;

import androidx.constraintlayout.core.motion.key.MotionKeyPosition;
import androidx.constraintlayout.core.motion.utils.Easing;
import g.a;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class MotionPaths implements Comparable<MotionPaths> {
    public static final int CARTESIAN = 0;
    public static final boolean DEBUG = false;
    static final int OFF_HEIGHT = 4;
    static final int OFF_PATH_ROTATE = 5;
    static final int OFF_POSITION = 0;
    static final int OFF_WIDTH = 3;
    static final int OFF_X = 1;
    static final int OFF_Y = 2;
    public static final boolean OLD_WAY = false;
    public static final int PERPENDICULAR = 1;
    public static final int SCREEN = 2;
    public static final String TAG = "MotionPaths";
    static String[] names = {"position", "x", "y", "width", "height", "pathRotate"};
    HashMap<String, CustomVariable> customAttributes;
    float height;
    int mAnimateCircleAngleTo;
    int mAnimateRelativeTo;
    int mDrawPath;
    Easing mKeyFrameEasing;
    int mMode;
    int mPathMotionArc;
    float mPathRotate;
    float mProgress;
    float mRelativeAngle;
    Motion mRelativeToController;
    double[] mTempDelta;
    double[] mTempValue;
    float position;
    float time;
    float width;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    float f432x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    float f433y;

    public MotionPaths() {
        this.mDrawPath = 0;
        this.mPathRotate = Float.NaN;
        this.mProgress = Float.NaN;
        this.mPathMotionArc = -1;
        this.mAnimateRelativeTo = -1;
        this.mRelativeAngle = Float.NaN;
        this.mRelativeToController = null;
        this.customAttributes = new HashMap<>();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
    }

    private boolean diff(float f10, float f11) {
        if (Float.isNaN(f10) || Float.isNaN(f11)) {
            return Float.isNaN(f10) != Float.isNaN(f11);
        }
        return Math.abs(f10 - f11) > 1.0E-6f;
    }

    private static final float xRotate(float f10, float f11, float f12, float f13, float f14, float f15) {
        return (((f14 - f12) * f11) - ((f15 - f13) * f10)) + f12;
    }

    private static final float yRotate(float f10, float f11, float f12, float f13, float f14, float f15) {
        return ((f15 - f13) * f11) + ((f14 - f12) * f10) + f13;
    }

    public void applyParameters(MotionWidget motionWidget) {
        this.mKeyFrameEasing = Easing.getInterpolator(motionWidget.motion.mTransitionEasing);
        MotionWidget.Motion motion = motionWidget.motion;
        this.mPathMotionArc = motion.mPathMotionArc;
        this.mAnimateRelativeTo = motion.mAnimateRelativeTo;
        this.mPathRotate = motion.mPathRotate;
        this.mDrawPath = motion.mDrawPath;
        this.mAnimateCircleAngleTo = motion.mAnimateCircleAngleTo;
        this.mProgress = motionWidget.propertySet.mProgress;
        this.mRelativeAngle = 0.0f;
        for (String str : motionWidget.getCustomAttributeNames()) {
            CustomVariable customAttribute = motionWidget.getCustomAttribute(str);
            if (customAttribute != null && customAttribute.isContinuous()) {
                this.customAttributes.put(str, customAttribute);
            }
        }
    }

    public void configureRelativeTo(Motion motion) {
        motion.getPos(this.mProgress);
    }

    public void different(MotionPaths motionPaths, boolean[] zArr, String[] strArr, boolean z10) {
        boolean zDiff = diff(this.f432x, motionPaths.f432x);
        boolean zDiff2 = diff(this.f433y, motionPaths.f433y);
        zArr[0] = zArr[0] | diff(this.position, motionPaths.position);
        boolean z11 = zDiff | zDiff2 | z10;
        zArr[1] = zArr[1] | z11;
        zArr[2] = z11 | zArr[2];
        zArr[3] = zArr[3] | diff(this.width, motionPaths.width);
        zArr[4] = diff(this.height, motionPaths.height) | zArr[4];
    }

    public void fillStandard(double[] dArr, int[] iArr) {
        float[] fArr = {this.position, this.f432x, this.f433y, this.width, this.height, this.mPathRotate};
        int i10 = 0;
        for (int i11 : iArr) {
            if (i11 < 6) {
                dArr[i10] = fArr[i11];
                i10++;
            }
        }
    }

    public void getBounds(int[] iArr, double[] dArr, float[] fArr, int i10) {
        float f10 = this.width;
        float f11 = this.height;
        for (int i11 = 0; i11 < iArr.length; i11++) {
            float f12 = (float) dArr[i11];
            int i12 = iArr[i11];
            if (i12 == 3) {
                f10 = f12;
            } else if (i12 == 4) {
                f11 = f12;
            }
        }
        fArr[i10] = f10;
        fArr[i10 + 1] = f11;
    }

    public void getCenter(double d10, int[] iArr, double[] dArr, float[] fArr, int i10) {
        float f10 = this.f432x;
        float fCos = this.f433y;
        float f11 = this.width;
        float f12 = this.height;
        for (int i11 = 0; i11 < iArr.length; i11++) {
            float f13 = (float) dArr[i11];
            int i12 = iArr[i11];
            if (i12 == 1) {
                f10 = f13;
            } else if (i12 == 2) {
                fCos = f13;
            } else if (i12 == 3) {
                f11 = f13;
            } else if (i12 == 4) {
                f12 = f13;
            }
        }
        Motion motion = this.mRelativeToController;
        if (motion != null) {
            float[] fArr2 = new float[2];
            motion.getCenter(d10, fArr2, new float[2]);
            float f14 = fArr2[0];
            float f15 = fArr2[1];
            double d11 = f10;
            double d12 = fCos;
            double dSin = Math.sin(d12) * d11;
            fCos = (float) ((((double) f15) - (Math.cos(d12) * d11)) - ((double) (f12 / 2.0f)));
            f10 = (float) ((dSin + ((double) f14)) - ((double) (f11 / 2.0f)));
        }
        fArr[i10] = (f11 / 2.0f) + f10 + 0.0f;
        fArr[i10 + 1] = (f12 / 2.0f) + fCos + 0.0f;
    }

    public void getCenterVelocity(double d10, int[] iArr, double[] dArr, float[] fArr, int i10) {
        float f10 = this.f432x;
        float fCos = this.f433y;
        float f11 = this.width;
        float f12 = this.height;
        for (int i11 = 0; i11 < iArr.length; i11++) {
            float f13 = (float) dArr[i11];
            int i12 = iArr[i11];
            if (i12 == 1) {
                f10 = f13;
            } else if (i12 == 2) {
                fCos = f13;
            } else if (i12 == 3) {
                f11 = f13;
            } else if (i12 == 4) {
                f12 = f13;
            }
        }
        Motion motion = this.mRelativeToController;
        if (motion != null) {
            float[] fArr2 = new float[2];
            motion.getCenter(d10, fArr2, new float[2]);
            float f14 = fArr2[0];
            float f15 = fArr2[1];
            double d11 = f10;
            double d12 = fCos;
            double dSin = Math.sin(d12) * d11;
            fCos = (float) ((((double) f15) - (Math.cos(d12) * d11)) - ((double) (f12 / 2.0f)));
            f10 = (float) ((dSin + ((double) f14)) - ((double) (f11 / 2.0f)));
        }
        fArr[i10] = (f11 / 2.0f) + f10 + 0.0f;
        fArr[i10 + 1] = (f12 / 2.0f) + fCos + 0.0f;
    }

    public int getCustomData(String str, double[] dArr, int i10) {
        CustomVariable customVariable = this.customAttributes.get(str);
        int i11 = 0;
        if (customVariable == null) {
            return 0;
        }
        if (customVariable.numberOfInterpolatedValues() == 1) {
            dArr[i10] = customVariable.getValueToInterpolate();
            return 1;
        }
        int iNumberOfInterpolatedValues = customVariable.numberOfInterpolatedValues();
        float[] fArr = new float[iNumberOfInterpolatedValues];
        customVariable.getValuesToInterpolate(fArr);
        while (i11 < iNumberOfInterpolatedValues) {
            dArr[i10] = fArr[i11];
            i11++;
            i10++;
        }
        return iNumberOfInterpolatedValues;
    }

    public int getCustomDataCount(String str) {
        CustomVariable customVariable = this.customAttributes.get(str);
        if (customVariable == null) {
            return 0;
        }
        return customVariable.numberOfInterpolatedValues();
    }

    public void getRect(int[] iArr, double[] dArr, float[] fArr, int i10) {
        float f10 = this.f432x;
        float fCos = this.f433y;
        float f11 = this.width;
        float f12 = this.height;
        for (int i11 = 0; i11 < iArr.length; i11++) {
            float f13 = (float) dArr[i11];
            int i12 = iArr[i11];
            if (i12 == 1) {
                f10 = f13;
            } else if (i12 == 2) {
                fCos = f13;
            } else if (i12 == 3) {
                f11 = f13;
            } else if (i12 == 4) {
                f12 = f13;
            }
        }
        Motion motion = this.mRelativeToController;
        if (motion != null) {
            float centerX = motion.getCenterX();
            float centerY = this.mRelativeToController.getCenterY();
            double d10 = f10;
            double d11 = fCos;
            float fSin = (float) (((Math.sin(d11) * d10) + ((double) centerX)) - ((double) (f11 / 2.0f)));
            fCos = (float) ((((double) centerY) - (Math.cos(d11) * d10)) - ((double) (f12 / 2.0f)));
            f10 = fSin;
        }
        float f14 = f11 + f10;
        float f15 = f12 + fCos;
        Float.isNaN(Float.NaN);
        Float.isNaN(Float.NaN);
        fArr[i10] = f10 + 0.0f;
        fArr[i10 + 1] = fCos + 0.0f;
        fArr[i10 + 2] = f14 + 0.0f;
        fArr[i10 + 3] = fCos + 0.0f;
        fArr[i10 + 4] = f14 + 0.0f;
        fArr[i10 + 5] = f15 + 0.0f;
        fArr[i10 + 6] = f10 + 0.0f;
        fArr[i10 + 7] = f15 + 0.0f;
    }

    public boolean hasCustomData(String str) {
        return this.customAttributes.containsKey(str);
    }

    public void initCartesian(MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f10 = motionKeyPosition.mFramePosition / 100.0f;
        this.time = f10;
        this.mDrawPath = motionKeyPosition.mDrawPath;
        float f11 = Float.isNaN(motionKeyPosition.mPercentWidth) ? f10 : motionKeyPosition.mPercentWidth;
        float f12 = Float.isNaN(motionKeyPosition.mPercentHeight) ? f10 : motionKeyPosition.mPercentHeight;
        float f13 = motionPaths2.width;
        float f14 = motionPaths.width;
        float f15 = f13 - f14;
        float f16 = motionPaths2.height;
        float f17 = motionPaths.height;
        float f18 = f16 - f17;
        this.position = this.time;
        float f19 = motionPaths.f432x;
        float f20 = motionPaths.f433y;
        float f21 = ((f13 / 2.0f) + motionPaths2.f432x) - ((f14 / 2.0f) + f19);
        float f22 = ((f16 / 2.0f) + motionPaths2.f433y) - ((f17 / 2.0f) + f20);
        float f23 = f15 * f11;
        float f24 = f23 / 2.0f;
        this.f432x = (int) (((f21 * f10) + f19) - f24);
        float f25 = (f22 * f10) + f20;
        float f26 = f18 * f12;
        float f27 = f26 / 2.0f;
        this.f433y = (int) (f25 - f27);
        this.width = (int) (f14 + f23);
        this.height = (int) (f17 + f26);
        float f28 = Float.isNaN(motionKeyPosition.mPercentX) ? f10 : motionKeyPosition.mPercentX;
        float f29 = Float.isNaN(motionKeyPosition.mAltPercentY) ? 0.0f : motionKeyPosition.mAltPercentY;
        if (!Float.isNaN(motionKeyPosition.mPercentY)) {
            f10 = motionKeyPosition.mPercentY;
        }
        float f30 = Float.isNaN(motionKeyPosition.mAltPercentX) ? 0.0f : motionKeyPosition.mAltPercentX;
        this.mMode = 0;
        this.f432x = (int) (((f30 * f22) + ((f28 * f21) + motionPaths.f432x)) - f24);
        this.f433y = (int) (((f22 * f10) + ((f21 * f29) + motionPaths.f433y)) - f27);
        this.mKeyFrameEasing = Easing.getInterpolator(motionKeyPosition.mTransitionEasing);
        this.mPathMotionArc = motionKeyPosition.mPathMotionArc;
    }

    public void initPath(MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f10 = motionKeyPosition.mFramePosition / 100.0f;
        this.time = f10;
        this.mDrawPath = motionKeyPosition.mDrawPath;
        float f11 = Float.isNaN(motionKeyPosition.mPercentWidth) ? f10 : motionKeyPosition.mPercentWidth;
        float f12 = Float.isNaN(motionKeyPosition.mPercentHeight) ? f10 : motionKeyPosition.mPercentHeight;
        float f13 = motionPaths2.width - motionPaths.width;
        float f14 = motionPaths2.height - motionPaths.height;
        this.position = this.time;
        if (!Float.isNaN(motionKeyPosition.mPercentX)) {
            f10 = motionKeyPosition.mPercentX;
        }
        float f15 = motionPaths.f432x;
        float f16 = motionPaths.width;
        float f17 = motionPaths.f433y;
        float f18 = motionPaths.height;
        float f19 = ((motionPaths2.width / 2.0f) + motionPaths2.f432x) - ((f16 / 2.0f) + f15);
        float f20 = ((motionPaths2.height / 2.0f) + motionPaths2.f433y) - ((f18 / 2.0f) + f17);
        float f21 = f19 * f10;
        float f22 = f13 * f11;
        float f23 = f22 / 2.0f;
        this.f432x = (int) ((f15 + f21) - f23);
        float f24 = f10 * f20;
        float f25 = f14 * f12;
        float f26 = f25 / 2.0f;
        this.f433y = (int) ((f17 + f24) - f26);
        this.width = (int) (f16 + f22);
        this.height = (int) (f18 + f25);
        float f27 = Float.isNaN(motionKeyPosition.mPercentY) ? 0.0f : motionKeyPosition.mPercentY;
        this.mMode = 1;
        float f28 = (int) ((motionPaths.f432x + f21) - f23);
        float f29 = (int) ((motionPaths.f433y + f24) - f26);
        this.f432x = f28 + ((-f20) * f27);
        this.f433y = f29 + (f19 * f27);
        this.mAnimateRelativeTo = this.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(motionKeyPosition.mTransitionEasing);
        this.mPathMotionArc = motionKeyPosition.mPathMotionArc;
    }

    public void initPolar(int i10, int i11, MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float fMin;
        float fA;
        float f10 = motionKeyPosition.mFramePosition / 100.0f;
        this.time = f10;
        this.mDrawPath = motionKeyPosition.mDrawPath;
        this.mMode = motionKeyPosition.mPositionType;
        float f11 = Float.isNaN(motionKeyPosition.mPercentWidth) ? f10 : motionKeyPosition.mPercentWidth;
        float f12 = Float.isNaN(motionKeyPosition.mPercentHeight) ? f10 : motionKeyPosition.mPercentHeight;
        float f13 = motionPaths2.width;
        float f14 = motionPaths.width;
        float f15 = motionPaths2.height;
        float f16 = motionPaths.height;
        this.position = this.time;
        this.width = (int) (((f13 - f14) * f11) + f14);
        this.height = (int) (((f15 - f16) * f12) + f16);
        int i12 = motionKeyPosition.mPositionType;
        if (i12 == 1) {
            float f17 = Float.isNaN(motionKeyPosition.mPercentX) ? f10 : motionKeyPosition.mPercentX;
            float f18 = motionPaths2.f432x;
            float f19 = motionPaths.f432x;
            this.f432x = a.a(f18, f19, f17, f19);
            if (!Float.isNaN(motionKeyPosition.mPercentY)) {
                f10 = motionKeyPosition.mPercentY;
            }
            float f20 = motionPaths2.f433y;
            float f21 = motionPaths.f433y;
            this.f433y = a.a(f20, f21, f10, f21);
        } else if (i12 != 2) {
            float f22 = Float.isNaN(motionKeyPosition.mPercentX) ? f10 : motionKeyPosition.mPercentX;
            float f23 = motionPaths2.f432x;
            float f24 = motionPaths.f432x;
            this.f432x = a.a(f23, f24, f22, f24);
            if (!Float.isNaN(motionKeyPosition.mPercentY)) {
                f10 = motionKeyPosition.mPercentY;
            }
            float f25 = motionPaths2.f433y;
            float f26 = motionPaths.f433y;
            this.f433y = a.a(f25, f26, f10, f26);
        } else {
            if (Float.isNaN(motionKeyPosition.mPercentX)) {
                float f27 = motionPaths2.f432x;
                float f28 = motionPaths.f432x;
                fMin = a.a(f27, f28, f10, f28);
            } else {
                fMin = Math.min(f12, f11) * motionKeyPosition.mPercentX;
            }
            this.f432x = fMin;
            if (Float.isNaN(motionKeyPosition.mPercentY)) {
                float f29 = motionPaths2.f433y;
                float f30 = motionPaths.f433y;
                fA = a.a(f29, f30, f10, f30);
            } else {
                fA = motionKeyPosition.mPercentY;
            }
            this.f433y = fA;
        }
        this.mAnimateRelativeTo = motionPaths.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(motionKeyPosition.mTransitionEasing);
        this.mPathMotionArc = motionKeyPosition.mPathMotionArc;
    }

    public void initScreen(int i10, int i11, MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f10 = motionKeyPosition.mFramePosition / 100.0f;
        this.time = f10;
        this.mDrawPath = motionKeyPosition.mDrawPath;
        float f11 = Float.isNaN(motionKeyPosition.mPercentWidth) ? f10 : motionKeyPosition.mPercentWidth;
        float f12 = Float.isNaN(motionKeyPosition.mPercentHeight) ? f10 : motionKeyPosition.mPercentHeight;
        float f13 = motionPaths2.width;
        float f14 = motionPaths.width;
        float f15 = f13 - f14;
        float f16 = motionPaths2.height;
        float f17 = motionPaths.height;
        float f18 = f16 - f17;
        this.position = this.time;
        float f19 = motionPaths.f432x;
        float f20 = motionPaths.f433y;
        float f21 = (f13 / 2.0f) + motionPaths2.f432x;
        float f22 = (f16 / 2.0f) + motionPaths2.f433y;
        float f23 = f15 * f11;
        this.f432x = (int) ((((f21 - ((f14 / 2.0f) + f19)) * f10) + f19) - (f23 / 2.0f));
        float f24 = f18 * f12;
        this.f433y = (int) ((((f22 - ((f17 / 2.0f) + f20)) * f10) + f20) - (f24 / 2.0f));
        this.width = (int) (f14 + f23);
        this.height = (int) (f17 + f24);
        this.mMode = 2;
        if (!Float.isNaN(motionKeyPosition.mPercentX)) {
            this.f432x = (int) (motionKeyPosition.mPercentX * ((int) (i10 - this.width)));
        }
        if (!Float.isNaN(motionKeyPosition.mPercentY)) {
            this.f433y = (int) (motionKeyPosition.mPercentY * ((int) (i11 - this.height)));
        }
        this.mAnimateRelativeTo = this.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(motionKeyPosition.mTransitionEasing);
        this.mPathMotionArc = motionKeyPosition.mPathMotionArc;
    }

    public void setBounds(float f10, float f11, float f12, float f13) {
        this.f432x = f10;
        this.f433y = f11;
        this.width = f12;
        this.height = f13;
    }

    public void setDpDt(float f10, float f11, float[] fArr, int[] iArr, double[] dArr, double[] dArr2) {
        float f12 = 0.0f;
        float f13 = 0.0f;
        float f14 = 0.0f;
        float f15 = 0.0f;
        for (int i10 = 0; i10 < iArr.length; i10++) {
            float f16 = (float) dArr[i10];
            double d10 = dArr2[i10];
            int i11 = iArr[i10];
            if (i11 == 1) {
                f12 = f16;
            } else if (i11 == 2) {
                f14 = f16;
            } else if (i11 == 3) {
                f13 = f16;
            } else if (i11 == 4) {
                f15 = f16;
            }
        }
        float f17 = f12 - ((0.0f * f13) / 2.0f);
        float f18 = f14 - ((0.0f * f15) / 2.0f);
        fArr[0] = (((f13 * 1.0f) + f17) * f10) + ((1.0f - f10) * f17) + 0.0f;
        fArr[1] = (((f15 * 1.0f) + f18) * f11) + ((1.0f - f11) * f18) + 0.0f;
    }

    public void setView(float f10, MotionWidget motionWidget, int[] iArr, double[] dArr, double[] dArr2, double[] dArr3) {
        float f11;
        float f12;
        float f13 = this.f432x;
        float f14 = this.f433y;
        float f15 = this.width;
        float f16 = this.height;
        if (iArr.length != 0 && this.mTempValue.length <= iArr[iArr.length - 1]) {
            int i10 = iArr[iArr.length - 1] + 1;
            this.mTempValue = new double[i10];
            this.mTempDelta = new double[i10];
        }
        Arrays.fill(this.mTempValue, Double.NaN);
        for (int i11 = 0; i11 < iArr.length; i11++) {
            double[] dArr4 = this.mTempValue;
            int i12 = iArr[i11];
            dArr4[i12] = dArr[i11];
            this.mTempDelta[i12] = dArr2[i11];
        }
        float f17 = Float.NaN;
        int i13 = 0;
        float f18 = 0.0f;
        float f19 = 0.0f;
        float f20 = 0.0f;
        float f21 = 0.0f;
        while (true) {
            double[] dArr5 = this.mTempValue;
            if (i13 >= dArr5.length) {
                break;
            }
            if (Double.isNaN(dArr5[i13]) && (dArr3 == null || dArr3[i13] == 0.0d)) {
                f12 = f17;
            } else {
                double d10 = dArr3 != null ? dArr3[i13] : 0.0d;
                if (!Double.isNaN(this.mTempValue[i13])) {
                    d10 = this.mTempValue[i13] + d10;
                }
                f12 = f17;
                float f22 = (float) d10;
                float f23 = (float) this.mTempDelta[i13];
                if (i13 == 1) {
                    f17 = f12;
                    f13 = f22;
                    f18 = f23;
                } else if (i13 == 2) {
                    f17 = f12;
                    f14 = f22;
                    f19 = f23;
                } else if (i13 == 3) {
                    f17 = f12;
                    f15 = f22;
                    f20 = f23;
                } else if (i13 == 4) {
                    f17 = f12;
                    f16 = f22;
                    f21 = f23;
                } else if (i13 == 5) {
                    f17 = f22;
                }
                i13++;
            }
            f17 = f12;
            i13++;
        }
        float f24 = f17;
        Motion motion = this.mRelativeToController;
        if (motion != null) {
            float[] fArr = new float[2];
            float[] fArr2 = new float[2];
            motion.getCenter(f10, fArr, fArr2);
            float f25 = fArr[0];
            float f26 = fArr[1];
            float f27 = fArr2[0];
            float f28 = fArr2[1];
            double d11 = f13;
            double d12 = f14;
            float fSin = (float) (((Math.sin(d12) * d11) + ((double) f25)) - ((double) (f15 / 2.0f)));
            float fCos = (float) ((((double) f26) - (Math.cos(d12) * d11)) - ((double) (f16 / 2.0f)));
            double d13 = f18;
            double d14 = f19;
            float fCos2 = (float) ((Math.cos(d12) * d11 * d14) + (Math.sin(d12) * d13) + ((double) f27));
            f11 = f16;
            float fSin2 = (float) ((Math.sin(d12) * d11 * d14) + (((double) f28) - (Math.cos(d12) * d13)));
            if (dArr2.length >= 2) {
                dArr2[0] = fCos2;
                dArr2[1] = fSin2;
            }
            if (!Float.isNaN(f24)) {
                motionWidget.setRotationZ((float) (Math.toDegrees(Math.atan2(fSin2, fCos2)) + ((double) f24)));
            }
            f13 = fSin;
            f14 = fCos;
        } else {
            f11 = f16;
            if (!Float.isNaN(f24)) {
                motionWidget.setRotationZ((float) (Math.toDegrees(Math.atan2((f21 / 2.0f) + f19, (f20 / 2.0f) + f18)) + ((double) f24) + ((double) 0.0f)));
            }
        }
        float f29 = f13 + 0.5f;
        float f30 = f14 + 0.5f;
        motionWidget.layout((int) f29, (int) f30, (int) (f29 + f15), (int) (f30 + f11));
    }

    public void setupRelative(Motion motion, MotionPaths motionPaths) {
        double d10 = (((this.width / 2.0f) + this.f432x) - motionPaths.f432x) - (motionPaths.width / 2.0f);
        double d11 = (((this.height / 2.0f) + this.f433y) - motionPaths.f433y) - (motionPaths.height / 2.0f);
        this.mRelativeToController = motion;
        this.f432x = (float) Math.hypot(d11, d10);
        if (Float.isNaN(this.mRelativeAngle)) {
            this.f433y = (float) (Math.atan2(d11, d10) + 1.5707963267948966d);
        } else {
            this.f433y = (float) Math.toRadians(this.mRelativeAngle);
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(MotionPaths motionPaths) {
        return Float.compare(this.position, motionPaths.position);
    }

    public MotionPaths(int i10, int i11, MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        this.mDrawPath = 0;
        this.mPathRotate = Float.NaN;
        this.mProgress = Float.NaN;
        this.mPathMotionArc = -1;
        this.mAnimateRelativeTo = -1;
        this.mRelativeAngle = Float.NaN;
        this.mRelativeToController = null;
        this.customAttributes = new HashMap<>();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
        if (motionPaths.mAnimateRelativeTo != -1) {
            initPolar(i10, i11, motionKeyPosition, motionPaths, motionPaths2);
            return;
        }
        int i12 = motionKeyPosition.mPositionType;
        if (i12 == 1) {
            initPath(motionKeyPosition, motionPaths, motionPaths2);
        } else if (i12 != 2) {
            initCartesian(motionKeyPosition, motionPaths, motionPaths2);
        } else {
            initScreen(i10, i11, motionKeyPosition, motionPaths, motionPaths2);
        }
    }

    public void getCenter(double d10, int[] iArr, double[] dArr, float[] fArr, double[] dArr2, float[] fArr2) {
        float f10;
        float f11 = this.f432x;
        float fCos = this.f433y;
        float f12 = this.width;
        float f13 = this.height;
        float f14 = 0.0f;
        float f15 = 0.0f;
        float f16 = 0.0f;
        float f17 = 0.0f;
        for (int i10 = 0; i10 < iArr.length; i10++) {
            float f18 = (float) dArr[i10];
            float f19 = (float) dArr2[i10];
            int i11 = iArr[i10];
            if (i11 == 1) {
                f11 = f18;
                f14 = f19;
            } else if (i11 == 2) {
                fCos = f18;
                f16 = f19;
            } else if (i11 == 3) {
                f12 = f18;
                f15 = f19;
            } else if (i11 == 4) {
                f13 = f18;
                f17 = f19;
            }
        }
        float f20 = (f15 / 2.0f) + f14;
        float fSin = (f17 / 2.0f) + f16;
        Motion motion = this.mRelativeToController;
        if (motion != null) {
            float[] fArr3 = new float[2];
            float[] fArr4 = new float[2];
            motion.getCenter(d10, fArr3, fArr4);
            float f21 = fArr3[0];
            float f22 = fArr3[1];
            float f23 = fArr4[0];
            float f24 = fArr4[1];
            double d11 = f11;
            double d12 = fCos;
            float fSin2 = (float) (((Math.sin(d12) * d11) + ((double) f21)) - ((double) (f12 / 2.0f)));
            fCos = (float) ((((double) f22) - (Math.cos(d12) * d11)) - ((double) (f13 / 2.0f)));
            double d13 = f14;
            double d14 = f16;
            float fCos2 = (float) ((Math.cos(d12) * d14) + (Math.sin(d12) * d13) + ((double) f23));
            fSin = (float) ((Math.sin(d12) * d14) + (((double) f24) - (Math.cos(d12) * d13)));
            f20 = fCos2;
            f11 = fSin2;
            f10 = 2.0f;
        } else {
            f10 = 2.0f;
        }
        fArr[0] = (f12 / f10) + f11 + 0.0f;
        fArr[1] = (f13 / f10) + fCos + 0.0f;
        fArr2[0] = f20;
        fArr2[1] = fSin;
    }
}
