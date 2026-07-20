package androidx.constraintlayout.motion.widget;

import a1.a;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintSet;
import java.util.Arrays;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes.dex */
class MotionPaths implements Comparable<MotionPaths> {
    static final int CARTESIAN = 0;
    public static final boolean DEBUG = false;
    static final int OFF_HEIGHT = 4;
    static final int OFF_PATH_ROTATE = 5;
    static final int OFF_POSITION = 0;
    static final int OFF_WIDTH = 3;
    static final int OFF_X = 1;
    static final int OFF_Y = 2;
    public static final boolean OLD_WAY = false;
    static final int PERPENDICULAR = 1;
    static final int SCREEN = 2;
    public static final String TAG = "MotionPaths";
    static String[] names = {"position", "x", "y", "width", "height", "pathRotate"};
    LinkedHashMap<String, ConstraintAttribute> attributes;
    float height;
    int mAnimateCircleAngleTo;
    int mAnimateRelativeTo;
    Easing mKeyFrameEasing;
    int mMode;
    int mPathMotionArc;
    float mRelativeAngle;
    MotionController mRelativeToController;
    double[] mTempDelta;
    double[] mTempValue;
    float position;
    float time;
    float width;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    float f1090x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    float f1091y;
    int mDrawPath = 0;
    float mPathRotate = Float.NaN;
    float mProgress = Float.NaN;

    public MotionPaths() {
        int i8 = Key.UNSET;
        this.mPathMotionArc = i8;
        this.mAnimateRelativeTo = i8;
        this.mRelativeAngle = Float.NaN;
        this.mRelativeToController = null;
        this.attributes = new LinkedHashMap<>();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
    }

    private boolean diff(float f, float f4) {
        if (Float.isNaN(f) || Float.isNaN(f4)) {
            return Float.isNaN(f) != Float.isNaN(f4);
        }
        return Math.abs(f - f4) > 1.0E-6f;
    }

    private static final float xRotate(float f, float f4, float f10, float f11, float f12, float f13) {
        return (((f12 - f10) * f4) - ((f13 - f11) * f)) + f10;
    }

    private static final float yRotate(float f, float f4, float f10, float f11, float f12, float f13) {
        return ((f13 - f11) * f4) + ((f12 - f10) * f) + f11;
    }

    public void applyParameters(ConstraintSet.Constraint constraint) {
        this.mKeyFrameEasing = Easing.getInterpolator(constraint.motion.mTransitionEasing);
        ConstraintSet.Motion motion = constraint.motion;
        this.mPathMotionArc = motion.mPathMotionArc;
        this.mAnimateRelativeTo = motion.mAnimateRelativeTo;
        this.mPathRotate = motion.mPathRotate;
        this.mDrawPath = motion.mDrawPath;
        this.mAnimateCircleAngleTo = motion.mAnimateCircleAngleTo;
        this.mProgress = constraint.propertySet.mProgress;
        this.mRelativeAngle = constraint.layout.circleAngle;
        for (String str : constraint.mCustomConstraints.keySet()) {
            ConstraintAttribute constraintAttribute = constraint.mCustomConstraints.get(str);
            if (constraintAttribute != null && constraintAttribute.isContinuous()) {
                this.attributes.put(str, constraintAttribute);
            }
        }
    }

    public void configureRelativeTo(MotionController motionController) {
        motionController.getPos(this.mProgress);
    }

    public void different(MotionPaths motionPaths, boolean[] zArr, String[] strArr, boolean z2) {
        boolean zDiff = diff(this.f1090x, motionPaths.f1090x);
        boolean zDiff2 = diff(this.f1091y, motionPaths.f1091y);
        zArr[0] = zArr[0] | diff(this.position, motionPaths.position);
        boolean z3 = zDiff | zDiff2 | z2;
        zArr[1] = zArr[1] | z3;
        zArr[2] = z3 | zArr[2];
        zArr[3] = zArr[3] | diff(this.width, motionPaths.width);
        zArr[4] = diff(this.height, motionPaths.height) | zArr[4];
    }

    public void fillStandard(double[] dArr, int[] iArr) {
        float[] fArr = {this.position, this.f1090x, this.f1091y, this.width, this.height, this.mPathRotate};
        int i8 = 0;
        for (int i9 : iArr) {
            if (i9 < 6) {
                dArr[i8] = fArr[i9];
                i8++;
            }
        }
    }

    public void getBounds(int[] iArr, double[] dArr, float[] fArr, int i8) {
        float f = this.width;
        float f4 = this.height;
        for (int i9 = 0; i9 < iArr.length; i9++) {
            float f10 = (float) dArr[i9];
            int i10 = iArr[i9];
            if (i10 == 3) {
                f = f10;
            } else if (i10 == 4) {
                f4 = f10;
            }
        }
        fArr[i8] = f;
        fArr[i8 + 1] = f4;
    }

    public void getCenter(double d7, int[] iArr, double[] dArr, float[] fArr, int i8) {
        float f = this.f1090x;
        float fCos = this.f1091y;
        float f4 = this.width;
        float f10 = this.height;
        for (int i9 = 0; i9 < iArr.length; i9++) {
            float f11 = (float) dArr[i9];
            int i10 = iArr[i9];
            if (i10 == 1) {
                f = f11;
            } else if (i10 == 2) {
                fCos = f11;
            } else if (i10 == 3) {
                f4 = f11;
            } else if (i10 == 4) {
                f10 = f11;
            }
        }
        MotionController motionController = this.mRelativeToController;
        if (motionController != null) {
            float[] fArr2 = new float[2];
            motionController.getCenter(d7, fArr2, new float[2]);
            float f12 = fArr2[0];
            float f13 = fArr2[1];
            double d10 = f;
            double d11 = fCos;
            float fA = (float) (a.a(d11, d10, f12) - ((double) (f4 / 2.0f)));
            fCos = (float) ((((double) f13) - (Math.cos(d11) * d10)) - ((double) (f10 / 2.0f)));
            f = fA;
        }
        fArr[i8] = (f4 / 2.0f) + f + 0.0f;
        fArr[i8 + 1] = (f10 / 2.0f) + fCos + 0.0f;
    }

    public void getCenterVelocity(double d7, int[] iArr, double[] dArr, float[] fArr, int i8) {
        float f = this.f1090x;
        float fCos = this.f1091y;
        float f4 = this.width;
        float f10 = this.height;
        for (int i9 = 0; i9 < iArr.length; i9++) {
            float f11 = (float) dArr[i9];
            int i10 = iArr[i9];
            if (i10 == 1) {
                f = f11;
            } else if (i10 == 2) {
                fCos = f11;
            } else if (i10 == 3) {
                f4 = f11;
            } else if (i10 == 4) {
                f10 = f11;
            }
        }
        MotionController motionController = this.mRelativeToController;
        if (motionController != null) {
            float[] fArr2 = new float[2];
            motionController.getCenter(d7, fArr2, new float[2]);
            float f12 = fArr2[0];
            float f13 = fArr2[1];
            double d10 = f;
            double d11 = fCos;
            float fA = (float) (a.a(d11, d10, f12) - ((double) (f4 / 2.0f)));
            fCos = (float) ((((double) f13) - (Math.cos(d11) * d10)) - ((double) (f10 / 2.0f)));
            f = fA;
        }
        fArr[i8] = (f4 / 2.0f) + f + 0.0f;
        fArr[i8 + 1] = (f10 / 2.0f) + fCos + 0.0f;
    }

    public int getCustomData(String str, double[] dArr, int i8) {
        ConstraintAttribute constraintAttribute = this.attributes.get(str);
        int i9 = 0;
        if (constraintAttribute == null) {
            return 0;
        }
        if (constraintAttribute.numberOfInterpolatedValues() == 1) {
            dArr[i8] = constraintAttribute.getValueToInterpolate();
            return 1;
        }
        int iNumberOfInterpolatedValues = constraintAttribute.numberOfInterpolatedValues();
        float[] fArr = new float[iNumberOfInterpolatedValues];
        constraintAttribute.getValuesToInterpolate(fArr);
        while (i9 < iNumberOfInterpolatedValues) {
            dArr[i8] = fArr[i9];
            i9++;
            i8++;
        }
        return iNumberOfInterpolatedValues;
    }

    public int getCustomDataCount(String str) {
        ConstraintAttribute constraintAttribute = this.attributes.get(str);
        if (constraintAttribute == null) {
            return 0;
        }
        return constraintAttribute.numberOfInterpolatedValues();
    }

    public void getRect(int[] iArr, double[] dArr, float[] fArr, int i8) {
        float f = this.f1090x;
        float fCos = this.f1091y;
        float f4 = this.width;
        float f10 = this.height;
        for (int i9 = 0; i9 < iArr.length; i9++) {
            float f11 = (float) dArr[i9];
            int i10 = iArr[i9];
            if (i10 == 1) {
                f = f11;
            } else if (i10 == 2) {
                fCos = f11;
            } else if (i10 == 3) {
                f4 = f11;
            } else if (i10 == 4) {
                f10 = f11;
            }
        }
        MotionController motionController = this.mRelativeToController;
        if (motionController != null) {
            float centerX = motionController.getCenterX();
            float centerY = this.mRelativeToController.getCenterY();
            double d7 = centerX;
            double d10 = f;
            double d11 = fCos;
            float fA = (float) (a.a(d11, d10, d7) - ((double) (f4 / 2.0f)));
            fCos = (float) ((((double) centerY) - (Math.cos(d11) * d10)) - ((double) (f10 / 2.0f)));
            f = fA;
        }
        float f12 = f4 + f;
        float f13 = f10 + fCos;
        Float.isNaN(Float.NaN);
        Float.isNaN(Float.NaN);
        fArr[i8] = f + 0.0f;
        fArr[i8 + 1] = fCos + 0.0f;
        fArr[i8 + 2] = f12 + 0.0f;
        fArr[i8 + 3] = fCos + 0.0f;
        fArr[i8 + 4] = f12 + 0.0f;
        fArr[i8 + 5] = f13 + 0.0f;
        fArr[i8 + 6] = f + 0.0f;
        fArr[i8 + 7] = f13 + 0.0f;
    }

    public boolean hasCustomData(String str) {
        return this.attributes.containsKey(str);
    }

    public void initCartesian(KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f = keyPosition.mFramePosition / 100.0f;
        this.time = f;
        this.mDrawPath = keyPosition.mDrawPath;
        float f4 = Float.isNaN(keyPosition.mPercentWidth) ? f : keyPosition.mPercentWidth;
        float f10 = Float.isNaN(keyPosition.mPercentHeight) ? f : keyPosition.mPercentHeight;
        float f11 = motionPaths2.width;
        float f12 = motionPaths.width;
        float f13 = f11 - f12;
        float f14 = motionPaths2.height;
        float f15 = motionPaths.height;
        float f16 = f14 - f15;
        this.position = this.time;
        float f17 = motionPaths.f1090x;
        float f18 = motionPaths.f1091y;
        float f19 = ((f11 / 2.0f) + motionPaths2.f1090x) - ((f12 / 2.0f) + f17);
        float f20 = ((f14 / 2.0f) + motionPaths2.f1091y) - ((f15 / 2.0f) + f18);
        float f21 = f13 * f4;
        float f22 = f21 / 2.0f;
        this.f1090x = (int) (((f19 * f) + f17) - f22);
        float f23 = (f20 * f) + f18;
        float f24 = f16 * f10;
        float f25 = f24 / 2.0f;
        this.f1091y = (int) (f23 - f25);
        this.width = (int) (f12 + f21);
        this.height = (int) (f15 + f24);
        float f26 = Float.isNaN(keyPosition.mPercentX) ? f : keyPosition.mPercentX;
        float f27 = Float.isNaN(keyPosition.mAltPercentY) ? 0.0f : keyPosition.mAltPercentY;
        if (!Float.isNaN(keyPosition.mPercentY)) {
            f = keyPosition.mPercentY;
        }
        float f28 = Float.isNaN(keyPosition.mAltPercentX) ? 0.0f : keyPosition.mAltPercentX;
        this.mMode = 0;
        this.f1090x = (int) (((f28 * f20) + ((f26 * f19) + motionPaths.f1090x)) - f22);
        this.f1091y = (int) (((f20 * f) + ((f19 * f27) + motionPaths.f1091y)) - f25);
        this.mKeyFrameEasing = Easing.getInterpolator(keyPosition.mTransitionEasing);
        this.mPathMotionArc = keyPosition.mPathMotionArc;
    }

    public void initPath(KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f = keyPosition.mFramePosition / 100.0f;
        this.time = f;
        this.mDrawPath = keyPosition.mDrawPath;
        float f4 = Float.isNaN(keyPosition.mPercentWidth) ? f : keyPosition.mPercentWidth;
        float f10 = Float.isNaN(keyPosition.mPercentHeight) ? f : keyPosition.mPercentHeight;
        float f11 = motionPaths2.width - motionPaths.width;
        float f12 = motionPaths2.height - motionPaths.height;
        this.position = this.time;
        if (!Float.isNaN(keyPosition.mPercentX)) {
            f = keyPosition.mPercentX;
        }
        float f13 = motionPaths.f1090x;
        float f14 = motionPaths.width;
        float f15 = motionPaths.f1091y;
        float f16 = motionPaths.height;
        float f17 = ((motionPaths2.width / 2.0f) + motionPaths2.f1090x) - ((f14 / 2.0f) + f13);
        float f18 = ((motionPaths2.height / 2.0f) + motionPaths2.f1091y) - ((f16 / 2.0f) + f15);
        float f19 = f17 * f;
        float f20 = f11 * f4;
        float f21 = f20 / 2.0f;
        this.f1090x = (int) ((f13 + f19) - f21);
        float f22 = f * f18;
        float f23 = f12 * f10;
        float f24 = f23 / 2.0f;
        this.f1091y = (int) ((f15 + f22) - f24);
        this.width = (int) (f14 + f20);
        this.height = (int) (f16 + f23);
        float f25 = Float.isNaN(keyPosition.mPercentY) ? 0.0f : keyPosition.mPercentY;
        this.mMode = 1;
        float f26 = (int) ((motionPaths.f1090x + f19) - f21);
        float f27 = (int) ((motionPaths.f1091y + f22) - f24);
        this.f1090x = f26 + ((-f18) * f25);
        this.f1091y = f27 + (f17 * f25);
        this.mAnimateRelativeTo = this.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(keyPosition.mTransitionEasing);
        this.mPathMotionArc = keyPosition.mPathMotionArc;
    }

    public void initPolar(int i8, int i9, KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float fMin;
        float fB;
        float f = keyPosition.mFramePosition / 100.0f;
        this.time = f;
        this.mDrawPath = keyPosition.mDrawPath;
        this.mMode = keyPosition.mPositionType;
        float f4 = Float.isNaN(keyPosition.mPercentWidth) ? f : keyPosition.mPercentWidth;
        float f10 = Float.isNaN(keyPosition.mPercentHeight) ? f : keyPosition.mPercentHeight;
        float f11 = motionPaths2.width;
        float f12 = motionPaths.width;
        float f13 = motionPaths2.height;
        float f14 = motionPaths.height;
        this.position = this.time;
        this.width = (int) (((f11 - f12) * f4) + f12);
        this.height = (int) (((f13 - f14) * f10) + f14);
        int i10 = keyPosition.mPositionType;
        if (i10 == 1) {
            float f15 = Float.isNaN(keyPosition.mPercentX) ? f : keyPosition.mPercentX;
            float f16 = motionPaths2.f1090x;
            float f17 = motionPaths.f1090x;
            this.f1090x = a.b(f16, f17, f15, f17);
            if (!Float.isNaN(keyPosition.mPercentY)) {
                f = keyPosition.mPercentY;
            }
            float f18 = motionPaths2.f1091y;
            float f19 = motionPaths.f1091y;
            this.f1091y = a.b(f18, f19, f, f19);
        } else if (i10 != 2) {
            float f20 = Float.isNaN(keyPosition.mPercentX) ? f : keyPosition.mPercentX;
            float f21 = motionPaths2.f1090x;
            float f22 = motionPaths.f1090x;
            this.f1090x = a.b(f21, f22, f20, f22);
            if (!Float.isNaN(keyPosition.mPercentY)) {
                f = keyPosition.mPercentY;
            }
            float f23 = motionPaths2.f1091y;
            float f24 = motionPaths.f1091y;
            this.f1091y = a.b(f23, f24, f, f24);
        } else {
            if (Float.isNaN(keyPosition.mPercentX)) {
                float f25 = motionPaths2.f1090x;
                float f26 = motionPaths.f1090x;
                fMin = a.b(f25, f26, f, f26);
            } else {
                fMin = Math.min(f10, f4) * keyPosition.mPercentX;
            }
            this.f1090x = fMin;
            if (Float.isNaN(keyPosition.mPercentY)) {
                float f27 = motionPaths2.f1091y;
                float f28 = motionPaths.f1091y;
                fB = a.b(f27, f28, f, f28);
            } else {
                fB = keyPosition.mPercentY;
            }
            this.f1091y = fB;
        }
        this.mAnimateRelativeTo = motionPaths.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(keyPosition.mTransitionEasing);
        this.mPathMotionArc = keyPosition.mPathMotionArc;
    }

    public void initScreen(int i8, int i9, KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f = keyPosition.mFramePosition / 100.0f;
        this.time = f;
        this.mDrawPath = keyPosition.mDrawPath;
        float f4 = Float.isNaN(keyPosition.mPercentWidth) ? f : keyPosition.mPercentWidth;
        float f10 = Float.isNaN(keyPosition.mPercentHeight) ? f : keyPosition.mPercentHeight;
        float f11 = motionPaths2.width;
        float f12 = motionPaths.width;
        float f13 = f11 - f12;
        float f14 = motionPaths2.height;
        float f15 = motionPaths.height;
        float f16 = f14 - f15;
        this.position = this.time;
        float f17 = motionPaths.f1090x;
        float f18 = motionPaths.f1091y;
        float f19 = (f11 / 2.0f) + motionPaths2.f1090x;
        float f20 = (f14 / 2.0f) + motionPaths2.f1091y;
        float f21 = f13 * f4;
        this.f1090x = (int) ((((f19 - ((f12 / 2.0f) + f17)) * f) + f17) - (f21 / 2.0f));
        float f22 = f16 * f10;
        this.f1091y = (int) ((((f20 - ((f15 / 2.0f) + f18)) * f) + f18) - (f22 / 2.0f));
        this.width = (int) (f12 + f21);
        this.height = (int) (f15 + f22);
        this.mMode = 2;
        if (!Float.isNaN(keyPosition.mPercentX)) {
            this.f1090x = (int) (keyPosition.mPercentX * ((int) (i8 - this.width)));
        }
        if (!Float.isNaN(keyPosition.mPercentY)) {
            this.f1091y = (int) (keyPosition.mPercentY * ((int) (i9 - this.height)));
        }
        this.mAnimateRelativeTo = this.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(keyPosition.mTransitionEasing);
        this.mPathMotionArc = keyPosition.mPathMotionArc;
    }

    public void setBounds(float f, float f4, float f10, float f11) {
        this.f1090x = f;
        this.f1091y = f4;
        this.width = f10;
        this.height = f11;
    }

    public void setDpDt(float f, float f4, float[] fArr, int[] iArr, double[] dArr, double[] dArr2) {
        float f10 = 0.0f;
        float f11 = 0.0f;
        float f12 = 0.0f;
        float f13 = 0.0f;
        for (int i8 = 0; i8 < iArr.length; i8++) {
            float f14 = (float) dArr[i8];
            double d7 = dArr2[i8];
            int i9 = iArr[i8];
            if (i9 == 1) {
                f10 = f14;
            } else if (i9 == 2) {
                f12 = f14;
            } else if (i9 == 3) {
                f11 = f14;
            } else if (i9 == 4) {
                f13 = f14;
            }
        }
        float f15 = f10 - ((0.0f * f11) / 2.0f);
        float f16 = f12 - ((0.0f * f13) / 2.0f);
        fArr[0] = (((f11 * 1.0f) + f15) * f) + ((1.0f - f) * f15) + 0.0f;
        fArr[1] = (((f13 * 1.0f) + f16) * f4) + ((1.0f - f4) * f16) + 0.0f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setView(float f, View view, int[] iArr, double[] dArr, double[] dArr2, double[] dArr3, boolean z2) {
        float f4;
        float f10;
        float f11 = this.f1090x;
        float f12 = this.f1091y;
        float f13 = this.width;
        float f14 = this.height;
        if (iArr.length != 0 && this.mTempValue.length <= iArr[iArr.length - 1]) {
            int i8 = iArr[iArr.length - 1] + 1;
            this.mTempValue = new double[i8];
            this.mTempDelta = new double[i8];
        }
        Arrays.fill(this.mTempValue, Double.NaN);
        for (int i9 = 0; i9 < iArr.length; i9++) {
            double[] dArr4 = this.mTempValue;
            int i10 = iArr[i9];
            dArr4[i10] = dArr[i9];
            this.mTempDelta[i10] = dArr2[i9];
        }
        float f15 = Float.NaN;
        int i11 = 0;
        float f16 = 0.0f;
        float f17 = 0.0f;
        float f18 = 0.0f;
        float f19 = 0.0f;
        while (true) {
            double[] dArr5 = this.mTempValue;
            if (i11 >= dArr5.length) {
                break;
            }
            if (Double.isNaN(dArr5[i11]) && (dArr3 == null || dArr3[i11] == 0.0d)) {
                f10 = f15;
            } else {
                double d7 = dArr3 != null ? dArr3[i11] : 0.0d;
                if (!Double.isNaN(this.mTempValue[i11])) {
                    d7 = this.mTempValue[i11] + d7;
                }
                f10 = f15;
                float f20 = (float) d7;
                float f21 = (float) this.mTempDelta[i11];
                if (i11 == 1) {
                    f15 = f10;
                    f11 = f20;
                    f16 = f21;
                } else if (i11 == 2) {
                    f15 = f10;
                    f12 = f20;
                    f17 = f21;
                } else if (i11 == 3) {
                    f15 = f10;
                    f13 = f20;
                    f18 = f21;
                } else if (i11 == 4) {
                    f15 = f10;
                    f14 = f20;
                    f19 = f21;
                } else if (i11 == 5) {
                    f15 = f20;
                }
                i11++;
            }
            f15 = f10;
            i11++;
        }
        float f22 = f15;
        MotionController motionController = this.mRelativeToController;
        if (motionController != null) {
            float[] fArr = new float[2];
            float[] fArr2 = new float[2];
            motionController.getCenter(f, fArr, fArr2);
            float f23 = fArr[0];
            float f24 = fArr[1];
            float f25 = fArr2[0];
            float f26 = fArr2[1];
            double d10 = f11;
            double d11 = f12;
            float fA = (float) (a.a(d11, d10, f23) - ((double) (f13 / 2.0f)));
            f4 = f14;
            float fCos = (float) ((((double) f24) - (Math.cos(d11) * d10)) - ((double) (f14 / 2.0f)));
            double d12 = f16;
            double d13 = f17;
            float fCos2 = (float) ((Math.cos(d11) * d10 * d13) + a.a(d11, d12, f25));
            float fSin = (float) ((Math.sin(d11) * d10 * d13) + (((double) f26) - (Math.cos(d11) * d12)));
            if (dArr2.length >= 2) {
                dArr2[0] = fCos2;
                dArr2[1] = fSin;
            }
            if (!Float.isNaN(f22)) {
                view.setRotation((float) (Math.toDegrees(Math.atan2(fSin, fCos2)) + ((double) f22)));
            }
            f11 = fA;
            f12 = fCos;
        } else {
            f4 = f14;
            if (!Float.isNaN(f22)) {
                view.setRotation((float) (Math.toDegrees(Math.atan2((f19 / 2.0f) + f17, (f18 / 2.0f) + f16)) + ((double) f22) + ((double) 0.0f)));
            }
        }
        if (view instanceof FloatLayout) {
            ((FloatLayout) view).layout(f11, f12, f13 + f11, f12 + f4);
            return;
        }
        float f27 = f11 + 0.5f;
        int i12 = (int) f27;
        float f28 = f12 + 0.5f;
        int i13 = (int) f28;
        int i14 = (int) (f27 + f13);
        int i15 = (int) (f28 + f4);
        int i16 = i14 - i12;
        int i17 = i15 - i13;
        if (i16 != view.getMeasuredWidth() || i17 != view.getMeasuredHeight() || z2) {
            view.measure(View.MeasureSpec.makeMeasureSpec(i16, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(i17, BasicMeasure.EXACTLY));
        }
        view.layout(i12, i13, i14, i15);
    }

    public void setupRelative(MotionController motionController, MotionPaths motionPaths) {
        double d7 = (((this.width / 2.0f) + this.f1090x) - motionPaths.f1090x) - (motionPaths.width / 2.0f);
        double d10 = (((this.height / 2.0f) + this.f1091y) - motionPaths.f1091y) - (motionPaths.height / 2.0f);
        this.mRelativeToController = motionController;
        this.f1090x = (float) Math.hypot(d10, d7);
        if (Float.isNaN(this.mRelativeAngle)) {
            this.f1091y = (float) (Math.atan2(d10, d7) + 1.5707963267948966d);
        } else {
            this.f1091y = (float) Math.toRadians(this.mRelativeAngle);
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(@NonNull MotionPaths motionPaths) {
        return Float.compare(this.position, motionPaths.position);
    }

    public MotionPaths(int i8, int i9, KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        int i10 = Key.UNSET;
        this.mPathMotionArc = i10;
        this.mAnimateRelativeTo = i10;
        this.mRelativeAngle = Float.NaN;
        this.mRelativeToController = null;
        this.attributes = new LinkedHashMap<>();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
        if (motionPaths.mAnimateRelativeTo != Key.UNSET) {
            initPolar(i8, i9, keyPosition, motionPaths, motionPaths2);
            return;
        }
        int i11 = keyPosition.mPositionType;
        if (i11 == 1) {
            initPath(keyPosition, motionPaths, motionPaths2);
        } else if (i11 != 2) {
            initCartesian(keyPosition, motionPaths, motionPaths2);
        } else {
            initScreen(i8, i9, keyPosition, motionPaths, motionPaths2);
        }
    }

    public void getCenter(double d7, int[] iArr, double[] dArr, float[] fArr, double[] dArr2, float[] fArr2) {
        float f;
        float f4 = this.f1090x;
        float f10 = this.f1091y;
        float f11 = this.width;
        float f12 = this.height;
        float f13 = 0.0f;
        float f14 = 0.0f;
        float f15 = 0.0f;
        float f16 = 0.0f;
        for (int i8 = 0; i8 < iArr.length; i8++) {
            float f17 = (float) dArr[i8];
            float f18 = (float) dArr2[i8];
            int i9 = iArr[i8];
            if (i9 == 1) {
                f4 = f17;
                f13 = f18;
            } else if (i9 == 2) {
                f10 = f17;
                f15 = f18;
            } else if (i9 == 3) {
                f11 = f17;
                f14 = f18;
            } else if (i9 == 4) {
                f12 = f17;
                f16 = f18;
            }
        }
        float f19 = (f14 / 2.0f) + f13;
        float fA = (f16 / 2.0f) + f15;
        MotionController motionController = this.mRelativeToController;
        if (motionController != null) {
            float[] fArr3 = new float[2];
            float[] fArr4 = new float[2];
            motionController.getCenter(d7, fArr3, fArr4);
            float f20 = fArr3[0];
            float f21 = fArr3[1];
            float f22 = fArr4[0];
            float f23 = fArr4[1];
            double d10 = f4;
            double d11 = f10;
            float fA2 = (float) (a.a(d11, d10, f20) - ((double) (f11 / 2.0f)));
            float fCos = (float) ((((double) f21) - (Math.cos(d11) * d10)) - ((double) (f12 / 2.0f)));
            double d12 = f13;
            double d13 = f15;
            float fCos2 = (float) ((Math.cos(d11) * d13) + a.a(d11, d12, f22));
            fA = (float) a.a(d11, d13, ((double) f23) - (Math.cos(d11) * d12));
            f4 = fA2;
            f10 = fCos;
            f19 = fCos2;
            f = 2.0f;
        } else {
            f = 2.0f;
        }
        fArr[0] = (f11 / f) + f4 + 0.0f;
        fArr[1] = (f12 / f) + f10 + 0.0f;
        fArr2[0] = f19;
        fArr2[1] = fA;
    }
}
