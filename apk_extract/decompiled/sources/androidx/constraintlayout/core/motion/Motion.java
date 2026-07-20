package androidx.constraintlayout.core.motion;

import a1.a;
import androidx.constraintlayout.core.motion.key.MotionKey;
import androidx.constraintlayout.core.motion.key.MotionKeyAttributes;
import androidx.constraintlayout.core.motion.key.MotionKeyCycle;
import androidx.constraintlayout.core.motion.key.MotionKeyPosition;
import androidx.constraintlayout.core.motion.key.MotionKeyTimeCycle;
import androidx.constraintlayout.core.motion.key.MotionKeyTrigger;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.DifferentialInterpolator;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.FloatRect;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.motion.utils.KeyCycleOscillator;
import androidx.constraintlayout.core.motion.utils.KeyFrameArray;
import androidx.constraintlayout.core.motion.utils.Rect;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.motion.utils.Utils;
import androidx.constraintlayout.core.motion.utils.VelocityMatrix;
import androidx.constraintlayout.core.motion.utils.ViewState;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import o.d;

/* JADX INFO: loaded from: classes.dex */
public class Motion implements TypedValues {
    static final int BOUNCE = 4;
    private static final boolean DEBUG = false;
    public static final int DRAW_PATH_AS_CONFIGURED = 4;
    public static final int DRAW_PATH_BASIC = 1;
    public static final int DRAW_PATH_CARTESIAN = 3;
    public static final int DRAW_PATH_NONE = 0;
    public static final int DRAW_PATH_RECTANGLE = 5;
    public static final int DRAW_PATH_RELATIVE = 2;
    public static final int DRAW_PATH_SCREEN = 6;
    static final int EASE_IN = 1;
    static final int EASE_IN_OUT = 0;
    static final int EASE_OUT = 2;
    private static final boolean FAVOR_FIXED_SIZE_VIEWS = false;
    public static final int HORIZONTAL_PATH_X = 2;
    public static final int HORIZONTAL_PATH_Y = 3;
    private static final int INTERPOLATOR_REFERENCE_ID = -2;
    private static final int INTERPOLATOR_UNDEFINED = -3;
    static final int LINEAR = 3;
    static final int OVERSHOOT = 5;
    public static final int PATH_PERCENT = 0;
    public static final int PATH_PERPENDICULAR = 1;
    public static final int ROTATION_LEFT = 2;
    public static final int ROTATION_RIGHT = 1;
    private static final int SPLINE_STRING = -1;
    private static final String TAG = "MotionController";
    public static final int VERTICAL_PATH_X = 4;
    public static final int VERTICAL_PATH_Y = 5;
    String[] attributeTable;
    private CurveFit mArcSpline;
    private int[] mAttributeInterpolatorCount;
    private String[] mAttributeNames;
    private HashMap<String, SplineSet> mAttributesMap;
    String mConstraintTag;
    float mCurrentCenterX;
    float mCurrentCenterY;
    private HashMap<String, KeyCycleOscillator> mCycleMap;
    int mId;
    private double[] mInterpolateData;
    private int[] mInterpolateVariables;
    private double[] mInterpolateVelocity;
    private MotionKeyTrigger[] mKeyTriggers;
    private CurveFit[] mSpline;
    private HashMap<String, TimeCycleSplineSet> mTimeCycleAttributesMap;
    MotionWidget mView;
    Rect mTempRect = new Rect();
    private int mCurveFitType = -1;
    private MotionPaths mStartMotionPath = new MotionPaths();
    private MotionPaths mEndMotionPath = new MotionPaths();
    private MotionConstrainedPoint mStartPoint = new MotionConstrainedPoint();
    private MotionConstrainedPoint mEndPoint = new MotionConstrainedPoint();
    float mMotionStagger = Float.NaN;
    float mStaggerOffset = 0.0f;
    float mStaggerScale = 1.0f;
    private int MAX_DIMENSION = 4;
    private float[] mValuesBuff = new float[4];
    private ArrayList<MotionPaths> mMotionPaths = new ArrayList<>();
    private float[] mVelocity = new float[1];
    private ArrayList<MotionKey> mKeyList = new ArrayList<>();
    private int mPathMotionArc = -1;
    private int mTransformPivotTarget = -1;
    private MotionWidget mTransformPivotView = null;
    private int mQuantizeMotionSteps = -1;
    private float mQuantizeMotionPhase = Float.NaN;
    private DifferentialInterpolator mQuantizeMotionInterpolator = null;
    private boolean mNoMovement = false;

    public Motion(MotionWidget motionWidget) {
        setView(motionWidget);
    }

    private float getAdjustedPosition(float f, float[] fArr) {
        float f4 = 0.0f;
        if (fArr != null) {
            fArr[0] = 1.0f;
        } else {
            float f10 = this.mStaggerScale;
            if (f10 != 1.0d) {
                float f11 = this.mStaggerOffset;
                if (f < f11) {
                    f = 0.0f;
                }
                if (f > f11 && f < 1.0d) {
                    f = Math.min((f - f11) * f10, 1.0f);
                }
            }
        }
        Easing easing = this.mStartMotionPath.mKeyFrameEasing;
        float f12 = Float.NaN;
        for (MotionPaths motionPaths : this.mMotionPaths) {
            Easing easing2 = motionPaths.mKeyFrameEasing;
            if (easing2 != null) {
                float f13 = motionPaths.time;
                if (f13 < f) {
                    easing = easing2;
                    f4 = f13;
                } else if (Float.isNaN(f12)) {
                    f12 = motionPaths.time;
                }
            }
        }
        if (easing == null) {
            return f;
        }
        float f14 = (Float.isNaN(f12) ? 1.0f : f12) - f4;
        double d7 = (f - f4) / f14;
        float f15 = f4 + (((float) easing.get(d7)) * f14);
        if (fArr != null) {
            fArr[0] = (float) easing.getDiff(d7);
        }
        return f15;
    }

    private static DifferentialInterpolator getInterpolator(int i8, String str, int i9) {
        if (i8 != -1) {
            return null;
        }
        final Easing interpolator = Easing.getInterpolator(str);
        return new DifferentialInterpolator() { // from class: androidx.constraintlayout.core.motion.Motion.1
            float mX;

            @Override // androidx.constraintlayout.core.motion.utils.DifferentialInterpolator
            public float getInterpolation(float f) {
                this.mX = f;
                return (float) interpolator.get(f);
            }

            @Override // androidx.constraintlayout.core.motion.utils.DifferentialInterpolator
            public float getVelocity() {
                return (float) interpolator.getDiff(this.mX);
            }
        };
    }

    private float getPreCycleDistance() {
        char c9;
        float fHypot;
        float[] fArr = new float[2];
        float f = 1.0f / 99;
        double d7 = 0.0d;
        double d10 = 0.0d;
        float f4 = 0.0f;
        int i8 = 0;
        while (i8 < 100) {
            float f10 = i8 * f;
            double d11 = f10;
            Easing easing = this.mStartMotionPath.mKeyFrameEasing;
            float f11 = Float.NaN;
            float f12 = 0.0f;
            for (MotionPaths motionPaths : this.mMotionPaths) {
                Easing easing2 = motionPaths.mKeyFrameEasing;
                if (easing2 != null) {
                    float f13 = motionPaths.time;
                    if (f13 < f10) {
                        easing = easing2;
                        f12 = f13;
                    } else if (Float.isNaN(f11)) {
                        f11 = motionPaths.time;
                    }
                }
            }
            if (easing != null) {
                if (Float.isNaN(f11)) {
                    f11 = 1.0f;
                }
                float f14 = f11 - f12;
                d11 = (((float) easing.get((f10 - f12) / f14)) * f14) + f12;
            }
            this.mSpline[0].getPos(d11, this.mInterpolateData);
            float f15 = f4;
            int i9 = i8;
            this.mStartMotionPath.getCenter(d11, this.mInterpolateVariables, this.mInterpolateData, fArr, 0);
            if (i9 > 0) {
                c9 = 0;
                fHypot = (float) (Math.hypot(d10 - ((double) fArr[1]), d7 - ((double) fArr[0])) + ((double) f15));
            } else {
                c9 = 0;
                fHypot = f15;
            }
            d7 = fArr[c9];
            i8 = i9 + 1;
            f4 = fHypot;
            d10 = fArr[1];
        }
        return f4;
    }

    private void insertKey(MotionPaths motionPaths) {
        MotionPaths motionPaths2 = null;
        for (MotionPaths motionPaths3 : this.mMotionPaths) {
            if (motionPaths.position == motionPaths3.position) {
                motionPaths2 = motionPaths3;
            }
        }
        if (motionPaths2 != null) {
            this.mMotionPaths.remove(motionPaths2);
        }
        int iBinarySearch = Collections.binarySearch(this.mMotionPaths, motionPaths);
        if (iBinarySearch == 0) {
            Utils.loge(TAG, " KeyPath position \"" + motionPaths.position + "\" outside of range");
        }
        this.mMotionPaths.add((-iBinarySearch) - 1, motionPaths);
    }

    private void readView(MotionPaths motionPaths) {
        motionPaths.setBounds(this.mView.getX(), this.mView.getY(), this.mView.getWidth(), this.mView.getHeight());
    }

    public void addKey(MotionKey motionKey) {
        this.mKeyList.add(motionKey);
    }

    public void addKeys(ArrayList<MotionKey> arrayList) {
        this.mKeyList.addAll(arrayList);
    }

    public void buildBounds(float[] fArr, int i8) {
        float f = 1.0f / (i8 - 1);
        HashMap<String, SplineSet> map = this.mAttributesMap;
        if (map != null) {
            map.get("translationX");
        }
        HashMap<String, SplineSet> map2 = this.mAttributesMap;
        if (map2 != null) {
            map2.get("translationY");
        }
        HashMap<String, KeyCycleOscillator> map3 = this.mCycleMap;
        if (map3 != null) {
            map3.get("translationX");
        }
        HashMap<String, KeyCycleOscillator> map4 = this.mCycleMap;
        if (map4 != null) {
            map4.get("translationY");
        }
        for (int i9 = 0; i9 < i8; i9++) {
            float fMin = i9 * f;
            float f4 = this.mStaggerScale;
            float f10 = 0.0f;
            if (f4 != 1.0f) {
                float f11 = this.mStaggerOffset;
                if (fMin < f11) {
                    fMin = 0.0f;
                }
                if (fMin > f11 && fMin < 1.0d) {
                    fMin = Math.min((fMin - f11) * f4, 1.0f);
                }
            }
            double d7 = fMin;
            Easing easing = this.mStartMotionPath.mKeyFrameEasing;
            float f12 = Float.NaN;
            for (MotionPaths motionPaths : this.mMotionPaths) {
                Easing easing2 = motionPaths.mKeyFrameEasing;
                if (easing2 != null) {
                    float f13 = motionPaths.time;
                    if (f13 < fMin) {
                        easing = easing2;
                        f10 = f13;
                    } else if (Float.isNaN(f12)) {
                        f12 = motionPaths.time;
                    }
                }
            }
            if (easing != null) {
                if (Float.isNaN(f12)) {
                    f12 = 1.0f;
                }
                float f14 = f12 - f10;
                d7 = (((float) easing.get((fMin - f10) / f14)) * f14) + f10;
            }
            this.mSpline[0].getPos(d7, this.mInterpolateData);
            CurveFit curveFit = this.mArcSpline;
            if (curveFit != null) {
                double[] dArr = this.mInterpolateData;
                if (dArr.length > 0) {
                    curveFit.getPos(d7, dArr);
                }
            }
            this.mStartMotionPath.getBounds(this.mInterpolateVariables, this.mInterpolateData, fArr, i9 * 2);
        }
    }

    public int buildKeyBounds(float[] fArr, int[] iArr) {
        if (fArr == null) {
            return 0;
        }
        double[] timePoints = this.mSpline[0].getTimePoints();
        if (iArr != null) {
            Iterator<MotionPaths> it = this.mMotionPaths.iterator();
            int i8 = 0;
            while (it.hasNext()) {
                iArr[i8] = it.next().mMode;
                i8++;
            }
        }
        int i9 = 0;
        for (double d7 : timePoints) {
            this.mSpline[0].getPos(d7, this.mInterpolateData);
            this.mStartMotionPath.getBounds(this.mInterpolateVariables, this.mInterpolateData, fArr, i9);
            i9 += 2;
        }
        return i9 / 2;
    }

    public int buildKeyFrames(float[] fArr, int[] iArr, int[] iArr2) {
        if (fArr == null) {
            return 0;
        }
        double[] timePoints = this.mSpline[0].getTimePoints();
        if (iArr != null) {
            Iterator<MotionPaths> it = this.mMotionPaths.iterator();
            int i8 = 0;
            while (it.hasNext()) {
                iArr[i8] = it.next().mMode;
                i8++;
            }
        }
        if (iArr2 != null) {
            Iterator<MotionPaths> it2 = this.mMotionPaths.iterator();
            int i9 = 0;
            while (it2.hasNext()) {
                iArr2[i9] = (int) (it2.next().position * 100.0f);
                i9++;
            }
        }
        int i10 = 0;
        for (int i11 = 0; i11 < timePoints.length; i11++) {
            this.mSpline[0].getPos(timePoints[i11], this.mInterpolateData);
            this.mStartMotionPath.getCenter(timePoints[i11], this.mInterpolateVariables, this.mInterpolateData, fArr, i10);
            i10 += 2;
        }
        return i10 / 2;
    }

    public void buildPath(float[] fArr, int i8) {
        double d7;
        float f = 1.0f;
        float f4 = 1.0f / (i8 - 1);
        HashMap<String, SplineSet> map = this.mAttributesMap;
        SplineSet splineSet = map == null ? null : map.get("translationX");
        HashMap<String, SplineSet> map2 = this.mAttributesMap;
        SplineSet splineSet2 = map2 == null ? null : map2.get("translationY");
        HashMap<String, KeyCycleOscillator> map3 = this.mCycleMap;
        KeyCycleOscillator keyCycleOscillator = map3 == null ? null : map3.get("translationX");
        HashMap<String, KeyCycleOscillator> map4 = this.mCycleMap;
        KeyCycleOscillator keyCycleOscillator2 = map4 != null ? map4.get("translationY") : null;
        int i9 = 0;
        while (i9 < i8) {
            float fMin = i9 * f4;
            float f10 = this.mStaggerScale;
            float f11 = 0.0f;
            if (f10 != f) {
                float f12 = this.mStaggerOffset;
                if (fMin < f12) {
                    fMin = 0.0f;
                }
                if (fMin > f12 && fMin < 1.0d) {
                    fMin = Math.min((fMin - f12) * f10, f);
                }
            }
            float f13 = fMin;
            double d10 = f13;
            Easing easing = this.mStartMotionPath.mKeyFrameEasing;
            float f14 = Float.NaN;
            for (MotionPaths motionPaths : this.mMotionPaths) {
                Easing easing2 = motionPaths.mKeyFrameEasing;
                double d11 = d10;
                if (easing2 != null) {
                    float f15 = motionPaths.time;
                    if (f15 < f13) {
                        f11 = f15;
                        easing = easing2;
                    } else if (Float.isNaN(f14)) {
                        f14 = motionPaths.time;
                    }
                }
                d10 = d11;
            }
            double d12 = d10;
            if (easing != null) {
                if (Float.isNaN(f14)) {
                    f14 = 1.0f;
                }
                float f16 = f14 - f11;
                d7 = (((float) easing.get((f13 - f11) / f16)) * f16) + f11;
            } else {
                d7 = d12;
            }
            this.mSpline[0].getPos(d7, this.mInterpolateData);
            CurveFit curveFit = this.mArcSpline;
            if (curveFit != null) {
                double[] dArr = this.mInterpolateData;
                if (dArr.length > 0) {
                    curveFit.getPos(d7, dArr);
                }
            }
            int i10 = i9 * 2;
            int i11 = i9;
            this.mStartMotionPath.getCenter(d7, this.mInterpolateVariables, this.mInterpolateData, fArr, i10);
            if (keyCycleOscillator != null) {
                fArr[i10] = keyCycleOscillator.get(f13) + fArr[i10];
            } else if (splineSet != null) {
                fArr[i10] = splineSet.get(f13) + fArr[i10];
            }
            if (keyCycleOscillator2 != null) {
                int i12 = i10 + 1;
                fArr[i12] = keyCycleOscillator2.get(f13) + fArr[i12];
            } else if (splineSet2 != null) {
                int i13 = i10 + 1;
                fArr[i13] = splineSet2.get(f13) + fArr[i13];
            }
            i9 = i11 + 1;
            f = 1.0f;
        }
    }

    public void buildRect(float f, float[] fArr, int i8) {
        this.mSpline[0].getPos(getAdjustedPosition(f, null), this.mInterpolateData);
        this.mStartMotionPath.getRect(this.mInterpolateVariables, this.mInterpolateData, fArr, i8);
    }

    public void buildRectangles(float[] fArr, int i8) {
        float f = 1.0f / (i8 - 1);
        for (int i9 = 0; i9 < i8; i9++) {
            this.mSpline[0].getPos(getAdjustedPosition(i9 * f, null), this.mInterpolateData);
            this.mStartMotionPath.getRect(this.mInterpolateVariables, this.mInterpolateData, fArr, i9 * 8);
        }
    }

    public void endTrigger(boolean z2) {
    }

    public int getAnimateRelativeTo() {
        return this.mStartMotionPath.mAnimateRelativeTo;
    }

    public int getAttributeValues(String str, float[] fArr, int i8) {
        SplineSet splineSet = this.mAttributesMap.get(str);
        if (splineSet == null) {
            return -1;
        }
        for (int i9 = 0; i9 < fArr.length; i9++) {
            fArr[i9] = splineSet.get(i9 / (fArr.length - 1));
        }
        return fArr.length;
    }

    public void getCenter(double d7, float[] fArr, float[] fArr2) {
        double[] dArr = new double[4];
        double[] dArr2 = new double[4];
        this.mSpline[0].getPos(d7, dArr);
        this.mSpline[0].getSlope(d7, dArr2);
        Arrays.fill(fArr2, 0.0f);
        this.mStartMotionPath.getCenter(d7, this.mInterpolateVariables, dArr, fArr, dArr2, fArr2);
    }

    public float getCenterX() {
        return this.mCurrentCenterX;
    }

    public float getCenterY() {
        return this.mCurrentCenterY;
    }

    public void getDpDt(float f, float f4, float f10, float[] fArr) {
        double[] dArr;
        float adjustedPosition = getAdjustedPosition(f, this.mVelocity);
        CurveFit[] curveFitArr = this.mSpline;
        int i8 = 0;
        if (curveFitArr == null) {
            MotionPaths motionPaths = this.mEndMotionPath;
            float f11 = motionPaths.f1078x;
            MotionPaths motionPaths2 = this.mStartMotionPath;
            float f12 = f11 - motionPaths2.f1078x;
            float f13 = motionPaths.f1079y - motionPaths2.f1079y;
            float f14 = motionPaths.width - motionPaths2.width;
            float f15 = (motionPaths.height - motionPaths2.height) + f13;
            fArr[0] = ((f14 + f12) * f4) + ((1.0f - f4) * f12);
            fArr[1] = (f15 * f10) + ((1.0f - f10) * f13);
            return;
        }
        double d7 = adjustedPosition;
        curveFitArr[0].getSlope(d7, this.mInterpolateVelocity);
        this.mSpline[0].getPos(d7, this.mInterpolateData);
        float f16 = this.mVelocity[0];
        while (true) {
            dArr = this.mInterpolateVelocity;
            if (i8 >= dArr.length) {
                break;
            }
            dArr[i8] = dArr[i8] * ((double) f16);
            i8++;
        }
        CurveFit curveFit = this.mArcSpline;
        if (curveFit == null) {
            this.mStartMotionPath.setDpDt(f4, f10, fArr, this.mInterpolateVariables, dArr, this.mInterpolateData);
            return;
        }
        double[] dArr2 = this.mInterpolateData;
        if (dArr2.length > 0) {
            curveFit.getPos(d7, dArr2);
            this.mArcSpline.getSlope(d7, this.mInterpolateVelocity);
            this.mStartMotionPath.setDpDt(f4, f10, fArr, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
        }
    }

    public int getDrawPath() {
        int iMax = this.mStartMotionPath.mDrawPath;
        Iterator<MotionPaths> it = this.mMotionPaths.iterator();
        while (it.hasNext()) {
            iMax = Math.max(iMax, it.next().mDrawPath);
        }
        return Math.max(iMax, this.mEndMotionPath.mDrawPath);
    }

    public float getFinalHeight() {
        return this.mEndMotionPath.height;
    }

    public float getFinalWidth() {
        return this.mEndMotionPath.width;
    }

    public float getFinalX() {
        return this.mEndMotionPath.f1078x;
    }

    public float getFinalY() {
        return this.mEndMotionPath.f1079y;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public int getId(String str) {
        return 0;
    }

    public MotionPaths getKeyFrame(int i8) {
        return this.mMotionPaths.get(i8);
    }

    public int getKeyFrameInfo(int i8, int[] iArr) {
        float[] fArr = new float[2];
        int i9 = 0;
        int i10 = 0;
        for (MotionKey motionKey : this.mKeyList) {
            int i11 = motionKey.mType;
            if (i11 == i8 || i8 != -1) {
                iArr[i10] = 0;
                iArr[i10 + 1] = i11;
                int i12 = motionKey.mFramePosition;
                iArr[i10 + 2] = i12;
                double d7 = i12 / 100.0f;
                this.mSpline[0].getPos(d7, this.mInterpolateData);
                this.mStartMotionPath.getCenter(d7, this.mInterpolateVariables, this.mInterpolateData, fArr, 0);
                iArr[i10 + 3] = Float.floatToIntBits(fArr[0]);
                int i13 = i10 + 4;
                iArr[i13] = Float.floatToIntBits(fArr[1]);
                if (motionKey instanceof MotionKeyPosition) {
                    MotionKeyPosition motionKeyPosition = (MotionKeyPosition) motionKey;
                    iArr[i10 + 5] = motionKeyPosition.mPositionType;
                    iArr[i10 + 6] = Float.floatToIntBits(motionKeyPosition.mPercentX);
                    i13 = i10 + 7;
                    iArr[i13] = Float.floatToIntBits(motionKeyPosition.mPercentY);
                }
                int i14 = i13 + 1;
                iArr[i10] = i14 - i10;
                i9++;
                i10 = i14;
            }
        }
        return i9;
    }

    public float getKeyFrameParameter(int i8, float f, float f4) {
        MotionPaths motionPaths = this.mEndMotionPath;
        float f10 = motionPaths.f1078x;
        MotionPaths motionPaths2 = this.mStartMotionPath;
        float f11 = motionPaths2.f1078x;
        float f12 = f10 - f11;
        float f13 = motionPaths.f1079y;
        float f14 = motionPaths2.f1079y;
        float f15 = f13 - f14;
        float f16 = (motionPaths2.width / 2.0f) + f11;
        float f17 = (motionPaths2.height / 2.0f) + f14;
        float fHypot = (float) Math.hypot(f12, f15);
        if (fHypot < 1.0E-7d) {
            return Float.NaN;
        }
        float f18 = f - f16;
        float f19 = f4 - f17;
        if (((float) Math.hypot(f18, f19)) == 0.0f) {
            return 0.0f;
        }
        float f20 = (f19 * f15) + (f18 * f12);
        if (i8 == 0) {
            return f20 / fHypot;
        }
        if (i8 == 1) {
            return (float) Math.sqrt((fHypot * fHypot) - (f20 * f20));
        }
        if (i8 == 2) {
            return f18 / f12;
        }
        if (i8 == 3) {
            return f19 / f12;
        }
        if (i8 == 4) {
            return f18 / f15;
        }
        if (i8 != 5) {
            return 0.0f;
        }
        return f19 / f15;
    }

    public int getKeyFramePositions(int[] iArr, float[] fArr) {
        int i8 = 0;
        int i9 = 0;
        for (MotionKey motionKey : this.mKeyList) {
            int i10 = motionKey.mFramePosition;
            iArr[i8] = (motionKey.mType * 1000) + i10;
            double d7 = i10 / 100.0f;
            this.mSpline[0].getPos(d7, this.mInterpolateData);
            this.mStartMotionPath.getCenter(d7, this.mInterpolateVariables, this.mInterpolateData, fArr, i9);
            i9 += 2;
            i8++;
        }
        return i8;
    }

    public double[] getPos(double d7) {
        this.mSpline[0].getPos(d7, this.mInterpolateData);
        CurveFit curveFit = this.mArcSpline;
        if (curveFit != null) {
            double[] dArr = this.mInterpolateData;
            if (dArr.length > 0) {
                curveFit.getPos(d7, dArr);
            }
        }
        return this.mInterpolateData;
    }

    public MotionKeyPosition getPositionKeyframe(int i8, int i9, float f, float f4) {
        FloatRect floatRect = new FloatRect();
        MotionPaths motionPaths = this.mStartMotionPath;
        float f10 = motionPaths.f1078x;
        floatRect.left = f10;
        float f11 = motionPaths.f1079y;
        floatRect.top = f11;
        floatRect.right = f10 + motionPaths.width;
        floatRect.bottom = f11 + motionPaths.height;
        FloatRect floatRect2 = new FloatRect();
        MotionPaths motionPaths2 = this.mEndMotionPath;
        float f12 = motionPaths2.f1078x;
        floatRect2.left = f12;
        float f13 = motionPaths2.f1079y;
        floatRect2.top = f13;
        floatRect2.right = f12 + motionPaths2.width;
        floatRect2.bottom = f13 + motionPaths2.height;
        for (MotionKey motionKey : this.mKeyList) {
            if (motionKey instanceof MotionKeyPosition) {
                MotionKeyPosition motionKeyPosition = (MotionKeyPosition) motionKey;
                if (motionKeyPosition.intersects(i8, i9, floatRect, floatRect2, f, f4)) {
                    return motionKeyPosition;
                }
            }
        }
        return null;
    }

    public void getPostLayoutDvDp(float f, int i8, int i9, float f4, float f10, float[] fArr) {
        float adjustedPosition = getAdjustedPosition(f, this.mVelocity);
        HashMap<String, SplineSet> map = this.mAttributesMap;
        SplineSet splineSet = map == null ? null : map.get("translationX");
        HashMap<String, SplineSet> map2 = this.mAttributesMap;
        SplineSet splineSet2 = map2 == null ? null : map2.get("translationY");
        HashMap<String, SplineSet> map3 = this.mAttributesMap;
        SplineSet splineSet3 = map3 == null ? null : map3.get("rotationZ");
        HashMap<String, SplineSet> map4 = this.mAttributesMap;
        SplineSet splineSet4 = map4 == null ? null : map4.get("scaleX");
        HashMap<String, SplineSet> map5 = this.mAttributesMap;
        SplineSet splineSet5 = map5 == null ? null : map5.get("scaleY");
        HashMap<String, KeyCycleOscillator> map6 = this.mCycleMap;
        KeyCycleOscillator keyCycleOscillator = map6 == null ? null : map6.get("translationX");
        HashMap<String, KeyCycleOscillator> map7 = this.mCycleMap;
        KeyCycleOscillator keyCycleOscillator2 = map7 == null ? null : map7.get("translationY");
        HashMap<String, KeyCycleOscillator> map8 = this.mCycleMap;
        KeyCycleOscillator keyCycleOscillator3 = map8 == null ? null : map8.get("rotationZ");
        HashMap<String, KeyCycleOscillator> map9 = this.mCycleMap;
        KeyCycleOscillator keyCycleOscillator4 = map9 == null ? null : map9.get("scaleX");
        HashMap<String, KeyCycleOscillator> map10 = this.mCycleMap;
        KeyCycleOscillator keyCycleOscillator5 = map10 != null ? map10.get("scaleY") : null;
        VelocityMatrix velocityMatrix = new VelocityMatrix();
        velocityMatrix.clear();
        velocityMatrix.setRotationVelocity(splineSet3, adjustedPosition);
        velocityMatrix.setTranslationVelocity(splineSet, splineSet2, adjustedPosition);
        velocityMatrix.setScaleVelocity(splineSet4, splineSet5, adjustedPosition);
        velocityMatrix.setRotationVelocity(keyCycleOscillator3, adjustedPosition);
        velocityMatrix.setTranslationVelocity(keyCycleOscillator, keyCycleOscillator2, adjustedPosition);
        velocityMatrix.setScaleVelocity(keyCycleOscillator4, keyCycleOscillator5, adjustedPosition);
        CurveFit curveFit = this.mArcSpline;
        if (curveFit != null) {
            double[] dArr = this.mInterpolateData;
            if (dArr.length > 0) {
                double d7 = adjustedPosition;
                curveFit.getPos(d7, dArr);
                this.mArcSpline.getSlope(d7, this.mInterpolateVelocity);
                this.mStartMotionPath.setDpDt(f4, f10, fArr, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
            }
            velocityMatrix.applyTransform(f4, f10, i8, i9, fArr);
            return;
        }
        int i10 = 0;
        if (this.mSpline == null) {
            MotionPaths motionPaths = this.mEndMotionPath;
            float f11 = motionPaths.f1078x;
            MotionPaths motionPaths2 = this.mStartMotionPath;
            float f12 = f11 - motionPaths2.f1078x;
            KeyCycleOscillator keyCycleOscillator6 = keyCycleOscillator5;
            float f13 = motionPaths.f1079y - motionPaths2.f1079y;
            KeyCycleOscillator keyCycleOscillator7 = keyCycleOscillator4;
            float f14 = motionPaths.width - motionPaths2.width;
            float f15 = (motionPaths.height - motionPaths2.height) + f13;
            fArr[0] = ((f14 + f12) * f4) + ((1.0f - f4) * f12);
            fArr[1] = (f15 * f10) + ((1.0f - f10) * f13);
            velocityMatrix.clear();
            velocityMatrix.setRotationVelocity(splineSet3, adjustedPosition);
            velocityMatrix.setTranslationVelocity(splineSet, splineSet2, adjustedPosition);
            velocityMatrix.setScaleVelocity(splineSet4, splineSet5, adjustedPosition);
            velocityMatrix.setRotationVelocity(keyCycleOscillator3, adjustedPosition);
            velocityMatrix.setTranslationVelocity(keyCycleOscillator, keyCycleOscillator2, adjustedPosition);
            velocityMatrix.setScaleVelocity(keyCycleOscillator7, keyCycleOscillator6, adjustedPosition);
            velocityMatrix.applyTransform(f4, f10, i8, i9, fArr);
            return;
        }
        double adjustedPosition2 = getAdjustedPosition(adjustedPosition, this.mVelocity);
        this.mSpline[0].getSlope(adjustedPosition2, this.mInterpolateVelocity);
        this.mSpline[0].getPos(adjustedPosition2, this.mInterpolateData);
        float f16 = this.mVelocity[0];
        while (true) {
            double[] dArr2 = this.mInterpolateVelocity;
            if (i10 >= dArr2.length) {
                this.mStartMotionPath.setDpDt(f4, f10, fArr, this.mInterpolateVariables, dArr2, this.mInterpolateData);
                velocityMatrix.applyTransform(f4, f10, i8, i9, fArr);
                return;
            } else {
                dArr2[i10] = dArr2[i10] * ((double) f16);
                i10++;
            }
        }
    }

    public float getStartHeight() {
        return this.mStartMotionPath.height;
    }

    public float getStartWidth() {
        return this.mStartMotionPath.width;
    }

    public float getStartX() {
        return this.mStartMotionPath.f1078x;
    }

    public float getStartY() {
        return this.mStartMotionPath.f1079y;
    }

    public int getTransformPivotTarget() {
        return this.mTransformPivotTarget;
    }

    public MotionWidget getView() {
        return this.mView;
    }

    public boolean interpolate(MotionWidget motionWidget, float f, long j8, KeyCache keyCache) {
        float adjustedPosition = getAdjustedPosition(f, null);
        int i8 = this.mQuantizeMotionSteps;
        if (i8 != -1) {
            float f4 = 1.0f / i8;
            float fFloor = ((float) Math.floor(adjustedPosition / f4)) * f4;
            float f10 = (adjustedPosition % f4) / f4;
            if (!Float.isNaN(this.mQuantizeMotionPhase)) {
                f10 = (f10 + this.mQuantizeMotionPhase) % 1.0f;
            }
            DifferentialInterpolator differentialInterpolator = this.mQuantizeMotionInterpolator;
            adjustedPosition = ((differentialInterpolator != null ? differentialInterpolator.getInterpolation(f10) : ((double) f10) > 0.5d ? 1.0f : 0.0f) * f4) + fFloor;
        }
        float f11 = adjustedPosition;
        HashMap<String, SplineSet> map = this.mAttributesMap;
        if (map != null) {
            Iterator<SplineSet> it = map.values().iterator();
            while (it.hasNext()) {
                it.next().setProperty(motionWidget, f11);
            }
        }
        CurveFit[] curveFitArr = this.mSpline;
        if (curveFitArr != null) {
            double d7 = f11;
            curveFitArr[0].getPos(d7, this.mInterpolateData);
            this.mSpline[0].getSlope(d7, this.mInterpolateVelocity);
            CurveFit curveFit = this.mArcSpline;
            if (curveFit != null) {
                double[] dArr = this.mInterpolateData;
                if (dArr.length > 0) {
                    curveFit.getPos(d7, dArr);
                    this.mArcSpline.getSlope(d7, this.mInterpolateVelocity);
                }
            }
            if (!this.mNoMovement) {
                this.mStartMotionPath.setView(f11, motionWidget, this.mInterpolateVariables, this.mInterpolateData, this.mInterpolateVelocity, null);
            }
            if (this.mTransformPivotTarget != -1) {
                if (this.mTransformPivotView == null) {
                    this.mTransformPivotView = motionWidget.getParent().findViewById(this.mTransformPivotTarget);
                }
                MotionWidget motionWidget2 = this.mTransformPivotView;
                if (motionWidget2 != null) {
                    float bottom = (this.mTransformPivotView.getBottom() + motionWidget2.getTop()) / 2.0f;
                    float right = (this.mTransformPivotView.getRight() + this.mTransformPivotView.getLeft()) / 2.0f;
                    if (motionWidget.getRight() - motionWidget.getLeft() > 0 && motionWidget.getBottom() - motionWidget.getTop() > 0) {
                        float left = right - motionWidget.getLeft();
                        float top = bottom - motionWidget.getTop();
                        motionWidget.setPivotX(left);
                        motionWidget.setPivotY(top);
                    }
                }
            }
            int i9 = 1;
            while (true) {
                CurveFit[] curveFitArr2 = this.mSpline;
                if (i9 >= curveFitArr2.length) {
                    break;
                }
                curveFitArr2[i9].getPos(d7, this.mValuesBuff);
                this.mStartMotionPath.customAttributes.get(this.mAttributeNames[i9 - 1]).setInterpolatedValue(motionWidget, this.mValuesBuff);
                i9++;
            }
            MotionConstrainedPoint motionConstrainedPoint = this.mStartPoint;
            if (motionConstrainedPoint.mVisibilityMode == 0) {
                if (f11 <= 0.0f) {
                    motionWidget.setVisibility(motionConstrainedPoint.visibility);
                } else if (f11 >= 1.0f) {
                    motionWidget.setVisibility(this.mEndPoint.visibility);
                } else if (this.mEndPoint.visibility != motionConstrainedPoint.visibility) {
                    motionWidget.setVisibility(4);
                }
            }
            if (this.mKeyTriggers != null) {
                int i10 = 0;
                while (true) {
                    MotionKeyTrigger[] motionKeyTriggerArr = this.mKeyTriggers;
                    if (i10 >= motionKeyTriggerArr.length) {
                        break;
                    }
                    motionKeyTriggerArr[i10].conditionallyFire(f11, motionWidget);
                    i10++;
                }
            }
        } else {
            MotionPaths motionPaths = this.mStartMotionPath;
            float f12 = motionPaths.f1078x;
            MotionPaths motionPaths2 = this.mEndMotionPath;
            float fB = a.b(motionPaths2.f1078x, f12, f11, f12);
            float f13 = motionPaths.f1079y;
            float fB2 = a.b(motionPaths2.f1079y, f13, f11, f13);
            float f14 = motionPaths.width;
            float fB3 = a.b(motionPaths2.width, f14, f11, f14);
            float f15 = motionPaths.height;
            float f16 = fB + 0.5f;
            float f17 = fB2 + 0.5f;
            motionWidget.layout((int) f16, (int) f17, (int) (f16 + fB3), (int) (f17 + a.b(motionPaths2.height, f15, f11, f15)));
        }
        HashMap<String, KeyCycleOscillator> map2 = this.mCycleMap;
        if (map2 == null) {
            return false;
        }
        for (KeyCycleOscillator keyCycleOscillator : map2.values()) {
            if (keyCycleOscillator instanceof KeyCycleOscillator.PathRotateSet) {
                double[] dArr2 = this.mInterpolateVelocity;
                ((KeyCycleOscillator.PathRotateSet) keyCycleOscillator).setPathRotate(motionWidget, f11, dArr2[0], dArr2[1]);
            } else {
                keyCycleOscillator.setProperty(motionWidget, f11);
            }
        }
        return false;
    }

    public String name() {
        return this.mView.getName();
    }

    public void positionKeyframe(MotionWidget motionWidget, MotionKeyPosition motionKeyPosition, float f, float f4, String[] strArr, float[] fArr) {
        FloatRect floatRect = new FloatRect();
        MotionPaths motionPaths = this.mStartMotionPath;
        float f10 = motionPaths.f1078x;
        floatRect.left = f10;
        float f11 = motionPaths.f1079y;
        floatRect.top = f11;
        floatRect.right = f10 + motionPaths.width;
        floatRect.bottom = f11 + motionPaths.height;
        FloatRect floatRect2 = new FloatRect();
        MotionPaths motionPaths2 = this.mEndMotionPath;
        float f12 = motionPaths2.f1078x;
        floatRect2.left = f12;
        float f13 = motionPaths2.f1079y;
        floatRect2.top = f13;
        floatRect2.right = f12 + motionPaths2.width;
        floatRect2.bottom = f13 + motionPaths2.height;
        motionKeyPosition.positionAttributes(motionWidget, floatRect, floatRect2, f, f4, strArr, fArr);
    }

    public void rotate(Rect rect, Rect rect2, int i8, int i9, int i10) {
        if (i8 == 1) {
            int i11 = rect.left + rect.right;
            rect2.left = ((rect.top + rect.bottom) - rect.width()) / 2;
            rect2.top = i10 - ((rect.height() + i11) / 2);
            rect2.right = rect.width() + rect2.left;
            rect2.bottom = rect.height() + rect2.top;
            return;
        }
        if (i8 == 2) {
            int i12 = rect.left + rect.right;
            rect2.left = i9 - ((rect.width() + (rect.top + rect.bottom)) / 2);
            rect2.top = (i12 - rect.height()) / 2;
            rect2.right = rect.width() + rect2.left;
            rect2.bottom = rect.height() + rect2.top;
            return;
        }
        if (i8 == 3) {
            int i13 = rect.left + rect.right;
            rect2.left = ((rect.height() / 2) + rect.top) - (i13 / 2);
            rect2.top = i10 - ((rect.height() + i13) / 2);
            rect2.right = rect.width() + rect2.left;
            rect2.bottom = rect.height() + rect2.top;
            return;
        }
        if (i8 != 4) {
            return;
        }
        int i14 = rect.left + rect.right;
        rect2.left = i9 - ((rect.width() + (rect.bottom + rect.top)) / 2);
        rect2.top = (i14 - rect.height()) / 2;
        rect2.right = rect.width() + rect2.left;
        rect2.bottom = rect.height() + rect2.top;
    }

    public void setBothStates(MotionWidget motionWidget) {
        MotionPaths motionPaths = this.mStartMotionPath;
        motionPaths.time = 0.0f;
        motionPaths.position = 0.0f;
        this.mNoMovement = true;
        motionPaths.setBounds(motionWidget.getX(), motionWidget.getY(), motionWidget.getWidth(), motionWidget.getHeight());
        this.mEndMotionPath.setBounds(motionWidget.getX(), motionWidget.getY(), motionWidget.getWidth(), motionWidget.getHeight());
        this.mStartPoint.setState(motionWidget);
        this.mEndPoint.setState(motionWidget);
    }

    public void setDrawPath(int i8) {
        this.mStartMotionPath.mDrawPath = i8;
    }

    public void setEnd(MotionWidget motionWidget) {
        MotionPaths motionPaths = this.mEndMotionPath;
        motionPaths.time = 1.0f;
        motionPaths.position = 1.0f;
        readView(motionPaths);
        this.mEndMotionPath.setBounds(motionWidget.getLeft(), motionWidget.getTop(), motionWidget.getWidth(), motionWidget.getHeight());
        this.mEndMotionPath.applyParameters(motionWidget);
        this.mEndPoint.setState(motionWidget);
    }

    public void setPathMotionArc(int i8) {
        this.mPathMotionArc = i8;
    }

    public void setStart(MotionWidget motionWidget) {
        MotionPaths motionPaths = this.mStartMotionPath;
        motionPaths.time = 0.0f;
        motionPaths.position = 0.0f;
        motionPaths.setBounds(motionWidget.getX(), motionWidget.getY(), motionWidget.getWidth(), motionWidget.getHeight());
        this.mStartMotionPath.applyParameters(motionWidget);
        this.mStartPoint.setState(motionWidget);
    }

    public void setStartState(ViewState viewState, MotionWidget motionWidget, int i8, int i9, int i10) {
        MotionPaths motionPaths = this.mStartMotionPath;
        motionPaths.time = 0.0f;
        motionPaths.position = 0.0f;
        Rect rect = new Rect();
        if (i8 == 1) {
            int i11 = viewState.left + viewState.right;
            rect.left = ((viewState.top + viewState.bottom) - viewState.width()) / 2;
            rect.top = i9 - ((viewState.height() + i11) / 2);
            rect.right = viewState.width() + rect.left;
            rect.bottom = viewState.height() + rect.top;
        } else if (i8 == 2) {
            int i12 = viewState.left + viewState.right;
            rect.left = i10 - ((viewState.width() + (viewState.top + viewState.bottom)) / 2);
            rect.top = (i12 - viewState.height()) / 2;
            rect.right = viewState.width() + rect.left;
            rect.bottom = viewState.height() + rect.top;
        }
        this.mStartMotionPath.setBounds(rect.left, rect.top, rect.width(), rect.height());
        this.mStartPoint.setState(rect, motionWidget, i8, viewState.rotation);
    }

    public void setTransformPivotTarget(int i8) {
        this.mTransformPivotTarget = i8;
        this.mTransformPivotView = null;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i8, float f) {
        return false;
    }

    public void setView(MotionWidget motionWidget) {
        this.mView = motionWidget;
    }

    public void setup(int i8, int i9, float f, long j8) {
        ArrayList arrayList;
        String[] strArr;
        int i10;
        CustomVariable customVariable;
        SplineSet splineSetMakeSpline;
        CustomVariable customVariable2;
        Integer num;
        SplineSet splineSetMakeSpline2;
        CustomVariable customVariable3;
        new HashSet();
        HashSet<String> hashSet = new HashSet<>();
        HashSet<String> hashSet2 = new HashSet<>();
        HashSet<String> hashSet3 = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();
        int i11 = this.mPathMotionArc;
        if (i11 != -1) {
            this.mStartMotionPath.mPathMotionArc = i11;
        }
        this.mStartPoint.different(this.mEndPoint, hashSet2);
        ArrayList<MotionKey> arrayList2 = this.mKeyList;
        if (arrayList2 != null) {
            arrayList = null;
            for (MotionKey motionKey : arrayList2) {
                if (motionKey instanceof MotionKeyPosition) {
                    MotionKeyPosition motionKeyPosition = (MotionKeyPosition) motionKey;
                    insertKey(new MotionPaths(i8, i9, motionKeyPosition, this.mStartMotionPath, this.mEndMotionPath));
                    int i12 = motionKeyPosition.mCurveFit;
                    if (i12 != -1) {
                        this.mCurveFitType = i12;
                    }
                } else if (motionKey instanceof MotionKeyCycle) {
                    motionKey.getAttributeNames(hashSet3);
                } else if (motionKey instanceof MotionKeyTimeCycle) {
                    motionKey.getAttributeNames(hashSet);
                } else if (motionKey instanceof MotionKeyTrigger) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add((MotionKeyTrigger) motionKey);
                } else {
                    motionKey.setInterpolation(map);
                    motionKey.getAttributeNames(hashSet2);
                }
            }
        } else {
            arrayList = null;
        }
        if (arrayList != null) {
            this.mKeyTriggers = (MotionKeyTrigger[]) arrayList.toArray(new MotionKeyTrigger[0]);
        }
        char c9 = 1;
        if (!hashSet2.isEmpty()) {
            this.mAttributesMap = new HashMap<>();
            for (String str : hashSet2) {
                if (str.startsWith("CUSTOM,")) {
                    KeyFrameArray.CustomVar customVar = new KeyFrameArray.CustomVar();
                    String str2 = str.split(",")[c9];
                    for (MotionKey motionKey2 : this.mKeyList) {
                        HashMap<String, CustomVariable> map2 = motionKey2.mCustom;
                        if (map2 != null && (customVariable3 = map2.get(str2)) != null) {
                            customVar.append(motionKey2.mFramePosition, customVariable3);
                        }
                    }
                    splineSetMakeSpline2 = SplineSet.makeCustomSplineSet(str, customVar);
                } else {
                    splineSetMakeSpline2 = SplineSet.makeSpline(str, j8);
                }
                if (splineSetMakeSpline2 != null) {
                    splineSetMakeSpline2.setType(str);
                    this.mAttributesMap.put(str, splineSetMakeSpline2);
                }
                c9 = 1;
            }
            ArrayList<MotionKey> arrayList3 = this.mKeyList;
            if (arrayList3 != null) {
                for (MotionKey motionKey3 : arrayList3) {
                    if (motionKey3 instanceof MotionKeyAttributes) {
                        motionKey3.addValues(this.mAttributesMap);
                    }
                }
            }
            this.mStartPoint.addValues(this.mAttributesMap, 0);
            this.mEndPoint.addValues(this.mAttributesMap, 100);
            for (String str3 : this.mAttributesMap.keySet()) {
                int iIntValue = (!map.containsKey(str3) || (num = map.get(str3)) == null) ? 0 : num.intValue();
                SplineSet splineSet = this.mAttributesMap.get(str3);
                if (splineSet != null) {
                    splineSet.setup(iIntValue);
                }
            }
        }
        if (!hashSet.isEmpty()) {
            if (this.mTimeCycleAttributesMap == null) {
                this.mTimeCycleAttributesMap = new HashMap<>();
            }
            for (String str4 : hashSet) {
                if (!this.mTimeCycleAttributesMap.containsKey(str4)) {
                    if (str4.startsWith("CUSTOM,")) {
                        KeyFrameArray.CustomVar customVar2 = new KeyFrameArray.CustomVar();
                        String str5 = str4.split(",")[1];
                        for (MotionKey motionKey4 : this.mKeyList) {
                            HashMap<String, CustomVariable> map3 = motionKey4.mCustom;
                            if (map3 != null && (customVariable2 = map3.get(str5)) != null) {
                                customVar2.append(motionKey4.mFramePosition, customVariable2);
                            }
                        }
                        splineSetMakeSpline = SplineSet.makeCustomSplineSet(str4, customVar2);
                    } else {
                        splineSetMakeSpline = SplineSet.makeSpline(str4, j8);
                    }
                    if (splineSetMakeSpline != null) {
                        splineSetMakeSpline.setType(str4);
                    }
                }
            }
            ArrayList<MotionKey> arrayList4 = this.mKeyList;
            if (arrayList4 != null) {
                for (MotionKey motionKey5 : arrayList4) {
                    if (motionKey5 instanceof MotionKeyTimeCycle) {
                        ((MotionKeyTimeCycle) motionKey5).addTimeValues(this.mTimeCycleAttributesMap);
                    }
                }
            }
            for (String str6 : this.mTimeCycleAttributesMap.keySet()) {
                this.mTimeCycleAttributesMap.get(str6).setup(map.containsKey(str6) ? map.get(str6).intValue() : 0);
            }
        }
        int size = this.mMotionPaths.size();
        int i13 = size + 2;
        MotionPaths[] motionPathsArr = new MotionPaths[i13];
        motionPathsArr[0] = this.mStartMotionPath;
        motionPathsArr[size + 1] = this.mEndMotionPath;
        if (this.mMotionPaths.size() > 0 && this.mCurveFitType == MotionKey.UNSET) {
            this.mCurveFitType = 0;
        }
        Iterator<MotionPaths> it = this.mMotionPaths.iterator();
        int i14 = 1;
        while (it.hasNext()) {
            motionPathsArr[i14] = it.next();
            i14++;
        }
        HashSet hashSet4 = new HashSet();
        for (String str7 : this.mEndMotionPath.customAttributes.keySet()) {
            if (this.mStartMotionPath.customAttributes.containsKey(str7)) {
                if (!hashSet2.contains("CUSTOM," + str7)) {
                    hashSet4.add(str7);
                }
            }
        }
        String[] strArr2 = (String[]) hashSet4.toArray(new String[0]);
        this.mAttributeNames = strArr2;
        this.mAttributeInterpolatorCount = new int[strArr2.length];
        int i15 = 0;
        while (true) {
            strArr = this.mAttributeNames;
            if (i15 >= strArr.length) {
                break;
            }
            String str8 = strArr[i15];
            this.mAttributeInterpolatorCount[i15] = 0;
            for (int i16 = 0; i16 < i13; i16++) {
                if (motionPathsArr[i16].customAttributes.containsKey(str8) && (customVariable = motionPathsArr[i16].customAttributes.get(str8)) != null) {
                    int[] iArr = this.mAttributeInterpolatorCount;
                    iArr[i15] = customVariable.numberOfInterpolatedValues() + iArr[i15];
                    break;
                }
            }
            i15++;
        }
        boolean z2 = motionPathsArr[0].mPathMotionArc != -1;
        int length = 18 + strArr.length;
        boolean[] zArr = new boolean[length];
        for (int i17 = 1; i17 < i13; i17++) {
            motionPathsArr[i17].different(motionPathsArr[i17 - 1], zArr, this.mAttributeNames, z2);
        }
        int i18 = 0;
        for (int i19 = 1; i19 < length; i19++) {
            if (zArr[i19]) {
                i18++;
            }
        }
        this.mInterpolateVariables = new int[i18];
        int i20 = 2;
        int iMax = Math.max(2, i18);
        this.mInterpolateData = new double[iMax];
        this.mInterpolateVelocity = new double[iMax];
        int i21 = 0;
        for (int i22 = 1; i22 < length; i22++) {
            if (zArr[i22]) {
                this.mInterpolateVariables[i21] = i22;
                i21++;
            }
        }
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i13, this.mInterpolateVariables.length);
        double[] dArr2 = new double[i13];
        for (int i23 = 0; i23 < i13; i23++) {
            motionPathsArr[i23].fillStandard(dArr[i23], this.mInterpolateVariables);
            dArr2[i23] = motionPathsArr[i23].time;
        }
        int i24 = 0;
        while (true) {
            int[] iArr2 = this.mInterpolateVariables;
            if (i24 >= iArr2.length) {
                break;
            }
            if (iArr2[i24] < MotionPaths.names.length) {
                String strN = h0.a.n(new StringBuilder(), MotionPaths.names[this.mInterpolateVariables[i24]], " [");
                for (int i25 = 0; i25 < i13; i25++) {
                    StringBuilder sbS = d.s(strN);
                    sbS.append(dArr[i25][i24]);
                    strN = sbS.toString();
                }
            }
            i24++;
        }
        this.mSpline = new CurveFit[this.mAttributeNames.length + 1];
        int i26 = 0;
        while (true) {
            String[] strArr3 = this.mAttributeNames;
            if (i26 >= strArr3.length) {
                break;
            }
            String str9 = strArr3[i26];
            int i27 = 0;
            int i28 = 0;
            double[] dArr3 = null;
            double[][] dArr4 = null;
            while (i27 < i13) {
                if (motionPathsArr[i27].hasCustomData(str9)) {
                    if (dArr4 == null) {
                        dArr3 = new double[i13];
                        int[] iArr3 = new int[i20];
                        iArr3[1] = motionPathsArr[i27].getCustomDataCount(str9);
                        i10 = 0;
                        iArr3[0] = i13;
                        dArr4 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, iArr3);
                    } else {
                        i10 = 0;
                    }
                    MotionPaths motionPaths = motionPathsArr[i27];
                    dArr3[i28] = motionPaths.time;
                    motionPaths.getCustomData(str9, dArr4[i28], i10);
                    i28++;
                }
                i27++;
                i13 = i13;
                i20 = 2;
            }
            i26++;
            this.mSpline[i26] = CurveFit.get(this.mCurveFitType, Arrays.copyOf(dArr3, i28), (double[][]) Arrays.copyOf(dArr4, i28));
            i13 = i13;
            i20 = 2;
        }
        int i29 = i13;
        this.mSpline[0] = CurveFit.get(this.mCurveFitType, dArr2, dArr);
        if (motionPathsArr[0].mPathMotionArc != -1) {
            int[] iArr4 = new int[i29];
            double[] dArr5 = new double[i29];
            double[][] dArr6 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i29, 2);
            for (int i30 = 0; i30 < i29; i30++) {
                MotionPaths motionPaths2 = motionPathsArr[i30];
                iArr4[i30] = motionPaths2.mPathMotionArc;
                dArr5[i30] = motionPaths2.time;
                double[] dArr7 = dArr6[i30];
                dArr7[0] = motionPaths2.f1078x;
                dArr7[1] = motionPaths2.f1079y;
            }
            this.mArcSpline = CurveFit.getArc(iArr4, dArr5, dArr6);
        }
        this.mCycleMap = new HashMap<>();
        if (this.mKeyList != null) {
            float preCycleDistance = Float.NaN;
            for (String str10 : hashSet3) {
                KeyCycleOscillator keyCycleOscillatorMakeWidgetCycle = KeyCycleOscillator.makeWidgetCycle(str10);
                if (keyCycleOscillatorMakeWidgetCycle != null) {
                    if (keyCycleOscillatorMakeWidgetCycle.variesByPath() && Float.isNaN(preCycleDistance)) {
                        preCycleDistance = getPreCycleDistance();
                    }
                    keyCycleOscillatorMakeWidgetCycle.setType(str10);
                    this.mCycleMap.put(str10, keyCycleOscillatorMakeWidgetCycle);
                }
            }
            for (MotionKey motionKey6 : this.mKeyList) {
                if (motionKey6 instanceof MotionKeyCycle) {
                    ((MotionKeyCycle) motionKey6).addCycleValues(this.mCycleMap);
                }
            }
            Iterator<KeyCycleOscillator> it2 = this.mCycleMap.values().iterator();
            while (it2.hasNext()) {
                it2.next().setup(preCycleDistance);
            }
        }
    }

    public void setupRelative(Motion motion) {
        this.mStartMotionPath.setupRelative(motion, motion.mStartMotionPath);
        this.mEndMotionPath.setupRelative(motion, motion.mEndMotionPath);
    }

    public String toString() {
        return " start: x: " + this.mStartMotionPath.f1078x + " y: " + this.mStartMotionPath.f1079y + " end: x: " + this.mEndMotionPath.f1078x + " y: " + this.mEndMotionPath.f1079y;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i8, boolean z2) {
        return false;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i8, int i9) {
        if (i8 != 509) {
            return i8 == 704;
        }
        setPathMotionArc(i9);
        return true;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i8, String str) {
        if (705 == i8) {
            System.out.println("TYPE_INTERPOLATOR  " + str);
            this.mQuantizeMotionInterpolator = getInterpolator(-1, str, 0);
        }
        return false;
    }
}
