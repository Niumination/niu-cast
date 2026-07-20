package androidx.constraintlayout.motion.widget;

import a1.a;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.motion.utils.VelocityMatrix;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.motion.utils.CustomSupport;
import androidx.constraintlayout.motion.utils.ViewOscillator;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.motion.utils.ViewState;
import androidx.constraintlayout.motion.utils.ViewTimeCycle;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import o.d;

/* JADX INFO: loaded from: classes.dex */
public class MotionController {
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
    private HashMap<String, ViewSpline> mAttributesMap;
    String mConstraintTag;
    float mCurrentCenterX;
    float mCurrentCenterY;
    private HashMap<String, ViewOscillator> mCycleMap;
    int mId;
    private double[] mInterpolateData;
    private int[] mInterpolateVariables;
    private double[] mInterpolateVelocity;
    private KeyTrigger[] mKeyTriggers;
    private boolean mNoMovement;
    private int mPathMotionArc;
    private Interpolator mQuantizeMotionInterpolator;
    private float mQuantizeMotionPhase;
    private int mQuantizeMotionSteps;
    private CurveFit[] mSpline;
    private HashMap<String, ViewTimeCycle> mTimeCycleAttributesMap;
    private int mTransformPivotTarget;
    private View mTransformPivotView;
    View mView;
    Rect mTempRect = new Rect();
    boolean mForceMeasure = false;
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
    private ArrayList<Key> mKeyList = new ArrayList<>();

    public MotionController(View view) {
        int i8 = Key.UNSET;
        this.mPathMotionArc = i8;
        this.mTransformPivotTarget = i8;
        this.mTransformPivotView = null;
        this.mQuantizeMotionSteps = i8;
        this.mQuantizeMotionPhase = Float.NaN;
        this.mQuantizeMotionInterpolator = null;
        this.mNoMovement = false;
        setView(view);
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

    private static Interpolator getInterpolator(Context context, int i8, String str, int i9) {
        if (i8 == -2) {
            return AnimationUtils.loadInterpolator(context, i9);
        }
        if (i8 == -1) {
            final Easing interpolator = Easing.getInterpolator(str);
            return new Interpolator() { // from class: androidx.constraintlayout.motion.widget.MotionController.1
                @Override // android.animation.TimeInterpolator
                public float getInterpolation(float f) {
                    return (float) interpolator.get(f);
                }
            };
        }
        if (i8 == 0) {
            return new AccelerateDecelerateInterpolator();
        }
        if (i8 == 1) {
            return new AccelerateInterpolator();
        }
        if (i8 == 2) {
            return new DecelerateInterpolator();
        }
        if (i8 == 4) {
            return new BounceInterpolator();
        }
        if (i8 != 5) {
            return null;
        }
        return new OvershootInterpolator();
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
        int iBinarySearch = Collections.binarySearch(this.mMotionPaths, motionPaths);
        if (iBinarySearch == 0) {
            Log.e(TAG, " KeyPath position \"" + motionPaths.position + "\" outside of range");
        }
        this.mMotionPaths.add((-iBinarySearch) - 1, motionPaths);
    }

    private void readView(MotionPaths motionPaths) {
        motionPaths.setBounds((int) this.mView.getX(), (int) this.mView.getY(), this.mView.getWidth(), this.mView.getHeight());
    }

    public void addKey(Key key) {
        this.mKeyList.add(key);
    }

    public void addKeys(ArrayList<Key> arrayList) {
        this.mKeyList.addAll(arrayList);
    }

    public void buildBounds(float[] fArr, int i8) {
        float f = 1.0f / (i8 - 1);
        HashMap<String, ViewSpline> map = this.mAttributesMap;
        if (map != null) {
            map.get("translationX");
        }
        HashMap<String, ViewSpline> map2 = this.mAttributesMap;
        if (map2 != null) {
            map2.get("translationY");
        }
        HashMap<String, ViewOscillator> map3 = this.mCycleMap;
        if (map3 != null) {
            map3.get("translationX");
        }
        HashMap<String, ViewOscillator> map4 = this.mCycleMap;
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

    public int buildKeyFrames(float[] fArr, int[] iArr) {
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
        for (int i10 = 0; i10 < timePoints.length; i10++) {
            this.mSpline[0].getPos(timePoints[i10], this.mInterpolateData);
            this.mStartMotionPath.getCenter(timePoints[i10], this.mInterpolateVariables, this.mInterpolateData, fArr, i9);
            i9 += 2;
        }
        return i9 / 2;
    }

    public void buildPath(float[] fArr, int i8) {
        double d7;
        float f = 1.0f;
        float f4 = 1.0f / (i8 - 1);
        HashMap<String, ViewSpline> map = this.mAttributesMap;
        ViewSpline viewSpline = map == null ? null : map.get("translationX");
        HashMap<String, ViewSpline> map2 = this.mAttributesMap;
        ViewSpline viewSpline2 = map2 == null ? null : map2.get("translationY");
        HashMap<String, ViewOscillator> map3 = this.mCycleMap;
        ViewOscillator viewOscillator = map3 == null ? null : map3.get("translationX");
        HashMap<String, ViewOscillator> map4 = this.mCycleMap;
        ViewOscillator viewOscillator2 = map4 != null ? map4.get("translationY") : null;
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
            if (viewOscillator != null) {
                fArr[i10] = viewOscillator.get(f13) + fArr[i10];
            } else if (viewSpline != null) {
                fArr[i10] = viewSpline.get(f13) + fArr[i10];
            }
            if (viewOscillator2 != null) {
                int i12 = i10 + 1;
                fArr[i12] = viewOscillator2.get(f13) + fArr[i12];
            } else if (viewSpline2 != null) {
                int i13 = i10 + 1;
                fArr[i13] = viewSpline2.get(f13) + fArr[i13];
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
        if (!"button".equals(Debug.getName(this.mView)) || this.mKeyTriggers == null) {
            return;
        }
        int i8 = 0;
        while (true) {
            KeyTrigger[] keyTriggerArr = this.mKeyTriggers;
            if (i8 >= keyTriggerArr.length) {
                return;
            }
            keyTriggerArr[i8].conditionallyFire(z2 ? -100.0f : 100.0f, this.mView);
            i8++;
        }
    }

    public int getAnimateRelativeTo() {
        return this.mStartMotionPath.mAnimateRelativeTo;
    }

    public int getAttributeValues(String str, float[] fArr, int i8) {
        ViewSpline viewSpline = this.mAttributesMap.get(str);
        if (viewSpline == null) {
            return -1;
        }
        for (int i9 = 0; i9 < fArr.length; i9++) {
            fArr[i9] = viewSpline.get(i9 / (fArr.length - 1));
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
            float f11 = motionPaths.f1090x;
            MotionPaths motionPaths2 = this.mStartMotionPath;
            float f12 = f11 - motionPaths2.f1090x;
            float f13 = motionPaths.f1091y - motionPaths2.f1091y;
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
        return this.mEndMotionPath.f1090x;
    }

    public float getFinalY() {
        return this.mEndMotionPath.f1091y;
    }

    public MotionPaths getKeyFrame(int i8) {
        return this.mMotionPaths.get(i8);
    }

    public int getKeyFrameInfo(int i8, int[] iArr) {
        float[] fArr = new float[2];
        int i9 = 0;
        int i10 = 0;
        for (Key key : this.mKeyList) {
            int i11 = key.mType;
            if (i11 == i8 || i8 != -1) {
                iArr[i10] = 0;
                iArr[i10 + 1] = i11;
                int i12 = key.mFramePosition;
                iArr[i10 + 2] = i12;
                double d7 = i12 / 100.0f;
                this.mSpline[0].getPos(d7, this.mInterpolateData);
                this.mStartMotionPath.getCenter(d7, this.mInterpolateVariables, this.mInterpolateData, fArr, 0);
                iArr[i10 + 3] = Float.floatToIntBits(fArr[0]);
                int i13 = i10 + 4;
                iArr[i13] = Float.floatToIntBits(fArr[1]);
                if (key instanceof KeyPosition) {
                    KeyPosition keyPosition = (KeyPosition) key;
                    iArr[i10 + 5] = keyPosition.mPositionType;
                    iArr[i10 + 6] = Float.floatToIntBits(keyPosition.mPercentX);
                    i13 = i10 + 7;
                    iArr[i13] = Float.floatToIntBits(keyPosition.mPercentY);
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
        float f10 = motionPaths.f1090x;
        MotionPaths motionPaths2 = this.mStartMotionPath;
        float f11 = motionPaths2.f1090x;
        float f12 = f10 - f11;
        float f13 = motionPaths.f1091y;
        float f14 = motionPaths2.f1091y;
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
        for (Key key : this.mKeyList) {
            int i10 = key.mFramePosition;
            iArr[i8] = (key.mType * 1000) + i10;
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

    public KeyPositionBase getPositionKeyframe(int i8, int i9, float f, float f4) {
        RectF rectF = new RectF();
        MotionPaths motionPaths = this.mStartMotionPath;
        float f10 = motionPaths.f1090x;
        rectF.left = f10;
        float f11 = motionPaths.f1091y;
        rectF.top = f11;
        rectF.right = f10 + motionPaths.width;
        rectF.bottom = f11 + motionPaths.height;
        RectF rectF2 = new RectF();
        MotionPaths motionPaths2 = this.mEndMotionPath;
        float f12 = motionPaths2.f1090x;
        rectF2.left = f12;
        float f13 = motionPaths2.f1091y;
        rectF2.top = f13;
        rectF2.right = f12 + motionPaths2.width;
        rectF2.bottom = f13 + motionPaths2.height;
        for (Key key : this.mKeyList) {
            if (key instanceof KeyPositionBase) {
                KeyPositionBase keyPositionBase = (KeyPositionBase) key;
                if (keyPositionBase.intersects(i8, i9, rectF, rectF2, f, f4)) {
                    return keyPositionBase;
                }
            }
        }
        return null;
    }

    public void getPostLayoutDvDp(float f, int i8, int i9, float f4, float f10, float[] fArr) {
        float adjustedPosition = getAdjustedPosition(f, this.mVelocity);
        HashMap<String, ViewSpline> map = this.mAttributesMap;
        ViewSpline viewSpline = map == null ? null : map.get("translationX");
        HashMap<String, ViewSpline> map2 = this.mAttributesMap;
        ViewSpline viewSpline2 = map2 == null ? null : map2.get("translationY");
        HashMap<String, ViewSpline> map3 = this.mAttributesMap;
        ViewSpline viewSpline3 = map3 == null ? null : map3.get(Key.ROTATION);
        HashMap<String, ViewSpline> map4 = this.mAttributesMap;
        ViewSpline viewSpline4 = map4 == null ? null : map4.get("scaleX");
        HashMap<String, ViewSpline> map5 = this.mAttributesMap;
        ViewSpline viewSpline5 = map5 == null ? null : map5.get("scaleY");
        HashMap<String, ViewOscillator> map6 = this.mCycleMap;
        ViewOscillator viewOscillator = map6 == null ? null : map6.get("translationX");
        HashMap<String, ViewOscillator> map7 = this.mCycleMap;
        ViewOscillator viewOscillator2 = map7 == null ? null : map7.get("translationY");
        HashMap<String, ViewOscillator> map8 = this.mCycleMap;
        ViewOscillator viewOscillator3 = map8 == null ? null : map8.get(Key.ROTATION);
        HashMap<String, ViewOscillator> map9 = this.mCycleMap;
        ViewOscillator viewOscillator4 = map9 == null ? null : map9.get("scaleX");
        HashMap<String, ViewOscillator> map10 = this.mCycleMap;
        ViewOscillator viewOscillator5 = map10 != null ? map10.get("scaleY") : null;
        VelocityMatrix velocityMatrix = new VelocityMatrix();
        velocityMatrix.clear();
        velocityMatrix.setRotationVelocity(viewSpline3, adjustedPosition);
        velocityMatrix.setTranslationVelocity(viewSpline, viewSpline2, adjustedPosition);
        velocityMatrix.setScaleVelocity(viewSpline4, viewSpline5, adjustedPosition);
        velocityMatrix.setRotationVelocity(viewOscillator3, adjustedPosition);
        velocityMatrix.setTranslationVelocity(viewOscillator, viewOscillator2, adjustedPosition);
        velocityMatrix.setScaleVelocity(viewOscillator4, viewOscillator5, adjustedPosition);
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
            float f11 = motionPaths.f1090x;
            MotionPaths motionPaths2 = this.mStartMotionPath;
            float f12 = f11 - motionPaths2.f1090x;
            ViewOscillator viewOscillator6 = viewOscillator5;
            float f13 = motionPaths.f1091y - motionPaths2.f1091y;
            ViewOscillator viewOscillator7 = viewOscillator4;
            float f14 = motionPaths.width - motionPaths2.width;
            float f15 = (motionPaths.height - motionPaths2.height) + f13;
            fArr[0] = ((f14 + f12) * f4) + ((1.0f - f4) * f12);
            fArr[1] = (f15 * f10) + ((1.0f - f10) * f13);
            velocityMatrix.clear();
            velocityMatrix.setRotationVelocity(viewSpline3, adjustedPosition);
            velocityMatrix.setTranslationVelocity(viewSpline, viewSpline2, adjustedPosition);
            velocityMatrix.setScaleVelocity(viewSpline4, viewSpline5, adjustedPosition);
            velocityMatrix.setRotationVelocity(viewOscillator3, adjustedPosition);
            velocityMatrix.setTranslationVelocity(viewOscillator, viewOscillator2, adjustedPosition);
            velocityMatrix.setScaleVelocity(viewOscillator7, viewOscillator6, adjustedPosition);
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
        return this.mStartMotionPath.f1090x;
    }

    public float getStartY() {
        return this.mStartMotionPath.f1091y;
    }

    public int getTransformPivotTarget() {
        return this.mTransformPivotTarget;
    }

    public View getView() {
        return this.mView;
    }

    public boolean interpolate(View view, float f, long j8, KeyCache keyCache) {
        ViewTimeCycle.PathRotate pathRotate;
        boolean pathRotate2;
        float adjustedPosition = getAdjustedPosition(f, null);
        int i8 = this.mQuantizeMotionSteps;
        if (i8 != Key.UNSET) {
            float f4 = 1.0f / i8;
            float fFloor = ((float) Math.floor(adjustedPosition / f4)) * f4;
            float f10 = (adjustedPosition % f4) / f4;
            if (!Float.isNaN(this.mQuantizeMotionPhase)) {
                f10 = (f10 + this.mQuantizeMotionPhase) % 1.0f;
            }
            Interpolator interpolator = this.mQuantizeMotionInterpolator;
            adjustedPosition = ((interpolator != null ? interpolator.getInterpolation(f10) : ((double) f10) > 0.5d ? 1.0f : 0.0f) * f4) + fFloor;
        }
        float f11 = adjustedPosition;
        HashMap<String, ViewSpline> map = this.mAttributesMap;
        if (map != null) {
            Iterator<ViewSpline> it = map.values().iterator();
            while (it.hasNext()) {
                it.next().setProperty(view, f11);
            }
        }
        HashMap<String, ViewTimeCycle> map2 = this.mTimeCycleAttributesMap;
        if (map2 != null) {
            ViewTimeCycle.PathRotate pathRotate3 = null;
            boolean property = false;
            for (ViewTimeCycle viewTimeCycle : map2.values()) {
                if (viewTimeCycle instanceof ViewTimeCycle.PathRotate) {
                    pathRotate3 = (ViewTimeCycle.PathRotate) viewTimeCycle;
                } else {
                    property |= viewTimeCycle.setProperty(view, f11, j8, keyCache);
                }
            }
            pathRotate2 = property;
            pathRotate = pathRotate3;
        } else {
            pathRotate = null;
            pathRotate2 = false;
        }
        CurveFit[] curveFitArr = this.mSpline;
        int i9 = 1;
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
                this.mStartMotionPath.setView(f11, view, this.mInterpolateVariables, this.mInterpolateData, this.mInterpolateVelocity, null, this.mForceMeasure);
                this.mForceMeasure = false;
            }
            if (this.mTransformPivotTarget != Key.UNSET) {
                if (this.mTransformPivotView == null) {
                    this.mTransformPivotView = ((View) view.getParent()).findViewById(this.mTransformPivotTarget);
                }
                View view2 = this.mTransformPivotView;
                if (view2 != null) {
                    float bottom = (this.mTransformPivotView.getBottom() + view2.getTop()) / 2.0f;
                    float right = (this.mTransformPivotView.getRight() + this.mTransformPivotView.getLeft()) / 2.0f;
                    if (view.getRight() - view.getLeft() > 0 && view.getBottom() - view.getTop() > 0) {
                        float left = right - view.getLeft();
                        float top = bottom - view.getTop();
                        view.setPivotX(left);
                        view.setPivotY(top);
                    }
                }
            }
            HashMap<String, ViewSpline> map3 = this.mAttributesMap;
            if (map3 != null) {
                for (ViewSpline viewSpline : map3.values()) {
                    if (viewSpline instanceof ViewSpline.PathRotate) {
                        double[] dArr2 = this.mInterpolateVelocity;
                        if (dArr2.length > 1) {
                            ((ViewSpline.PathRotate) viewSpline).setPathRotate(view, f11, dArr2[0], dArr2[1]);
                        }
                    }
                }
            }
            if (pathRotate != null) {
                double[] dArr3 = this.mInterpolateVelocity;
                pathRotate2 |= pathRotate.setPathRotate(view, keyCache, f11, j8, dArr3[0], dArr3[1]);
            }
            int i10 = i9;
            while (true) {
                CurveFit[] curveFitArr2 = this.mSpline;
                if (i10 >= curveFitArr2.length) {
                    break;
                }
                curveFitArr2[i10].getPos(d7, this.mValuesBuff);
                CustomSupport.setInterpolatedValue(this.mStartMotionPath.attributes.get(this.mAttributeNames[i10 - 1]), view, this.mValuesBuff);
                i10++;
            }
            MotionConstrainedPoint motionConstrainedPoint = this.mStartPoint;
            if (motionConstrainedPoint.mVisibilityMode == 0) {
                if (f11 <= 0.0f) {
                    view.setVisibility(motionConstrainedPoint.visibility);
                } else if (f11 >= 1.0f) {
                    view.setVisibility(this.mEndPoint.visibility);
                } else if (this.mEndPoint.visibility != motionConstrainedPoint.visibility) {
                    view.setVisibility(0);
                }
            }
            if (this.mKeyTriggers != null) {
                int i11 = 0;
                while (true) {
                    KeyTrigger[] keyTriggerArr = this.mKeyTriggers;
                    if (i11 >= keyTriggerArr.length) {
                        break;
                    }
                    keyTriggerArr[i11].conditionallyFire(f11, view);
                    i11++;
                }
            }
        } else {
            i9 = 1;
            MotionPaths motionPaths = this.mStartMotionPath;
            float f12 = motionPaths.f1090x;
            MotionPaths motionPaths2 = this.mEndMotionPath;
            float fB = a.b(motionPaths2.f1090x, f12, f11, f12);
            float f13 = motionPaths.f1091y;
            float fB2 = a.b(motionPaths2.f1091y, f13, f11, f13);
            float f14 = motionPaths.width;
            float f15 = motionPaths2.width;
            float fB3 = a.b(f15, f14, f11, f14);
            float f16 = motionPaths.height;
            float f17 = motionPaths2.height;
            float f18 = fB + 0.5f;
            int i12 = (int) f18;
            float f19 = fB2 + 0.5f;
            int i13 = (int) f19;
            int i14 = (int) (f18 + fB3);
            int iB = (int) (f19 + a.b(f17, f16, f11, f16));
            int i15 = i14 - i12;
            int i16 = iB - i13;
            if (f15 != f14 || f17 != f16 || this.mForceMeasure) {
                view.measure(View.MeasureSpec.makeMeasureSpec(i15, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(i16, BasicMeasure.EXACTLY));
                this.mForceMeasure = false;
            }
            view.layout(i12, i13, i14, iB);
        }
        HashMap<String, ViewOscillator> map4 = this.mCycleMap;
        if (map4 != null) {
            for (ViewOscillator viewOscillator : map4.values()) {
                if (viewOscillator instanceof ViewOscillator.PathRotateSet) {
                    double[] dArr4 = this.mInterpolateVelocity;
                    ((ViewOscillator.PathRotateSet) viewOscillator).setPathRotate(view, f11, dArr4[0], dArr4[i9]);
                } else {
                    viewOscillator.setProperty(view, f11);
                }
            }
        }
        return pathRotate2;
    }

    public String name() {
        return this.mView.getContext().getResources().getResourceEntryName(this.mView.getId());
    }

    public void positionKeyframe(View view, KeyPositionBase keyPositionBase, float f, float f4, String[] strArr, float[] fArr) {
        RectF rectF = new RectF();
        MotionPaths motionPaths = this.mStartMotionPath;
        float f10 = motionPaths.f1090x;
        rectF.left = f10;
        float f11 = motionPaths.f1091y;
        rectF.top = f11;
        rectF.right = f10 + motionPaths.width;
        rectF.bottom = f11 + motionPaths.height;
        RectF rectF2 = new RectF();
        MotionPaths motionPaths2 = this.mEndMotionPath;
        float f12 = motionPaths2.f1090x;
        rectF2.left = f12;
        float f13 = motionPaths2.f1091y;
        rectF2.top = f13;
        rectF2.right = f12 + motionPaths2.width;
        rectF2.bottom = f13 + motionPaths2.height;
        keyPositionBase.positionAttributes(view, rectF, rectF2, f, f4, strArr, fArr);
    }

    public void remeasure() {
        this.mForceMeasure = true;
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

    public void setBothStates(View view) {
        MotionPaths motionPaths = this.mStartMotionPath;
        motionPaths.time = 0.0f;
        motionPaths.position = 0.0f;
        this.mNoMovement = true;
        motionPaths.setBounds(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        this.mEndMotionPath.setBounds(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        this.mStartPoint.setState(view);
        this.mEndPoint.setState(view);
    }

    public void setDrawPath(int i8) {
        this.mStartMotionPath.mDrawPath = i8;
    }

    public void setEndState(Rect rect, ConstraintSet constraintSet, int i8, int i9) {
        int i10 = constraintSet.mRotate;
        if (i10 != 0) {
            rotate(rect, this.mTempRect, i10, i8, i9);
            rect = this.mTempRect;
        }
        MotionPaths motionPaths = this.mEndMotionPath;
        motionPaths.time = 1.0f;
        motionPaths.position = 1.0f;
        readView(motionPaths);
        this.mEndMotionPath.setBounds(rect.left, rect.top, rect.width(), rect.height());
        this.mEndMotionPath.applyParameters(constraintSet.getParameters(this.mId));
        this.mEndPoint.setState(rect, constraintSet, i10, this.mId);
    }

    public void setPathMotionArc(int i8) {
        this.mPathMotionArc = i8;
    }

    public void setStartCurrentState(View view) {
        MotionPaths motionPaths = this.mStartMotionPath;
        motionPaths.time = 0.0f;
        motionPaths.position = 0.0f;
        motionPaths.setBounds(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        this.mStartPoint.setState(view);
    }

    public void setStartState(ViewState viewState, View view, int i8, int i9, int i10) {
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
        this.mStartPoint.setState(rect, view, i8, viewState.rotation);
    }

    public void setTransformPivotTarget(int i8) {
        this.mTransformPivotTarget = i8;
        this.mTransformPivotView = null;
    }

    public void setView(View view) {
        this.mView = view;
        this.mId = view.getId();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            this.mConstraintTag = ((ConstraintLayout.LayoutParams) layoutParams).getConstraintTag();
        }
    }

    public void setup(int i8, int i9, float f, long j8) {
        ArrayList arrayList;
        String[] strArr;
        ConstraintAttribute constraintAttribute;
        ViewTimeCycle viewTimeCycleMakeSpline;
        ConstraintAttribute constraintAttribute2;
        Integer num;
        ViewSpline viewSplineMakeSpline;
        ConstraintAttribute constraintAttribute3;
        new HashSet();
        HashSet<String> hashSet = new HashSet<>();
        HashSet<String> hashSet2 = new HashSet<>();
        HashSet<String> hashSet3 = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();
        int i10 = this.mPathMotionArc;
        if (i10 != Key.UNSET) {
            this.mStartMotionPath.mPathMotionArc = i10;
        }
        this.mStartPoint.different(this.mEndPoint, hashSet2);
        ArrayList<Key> arrayList2 = this.mKeyList;
        if (arrayList2 != null) {
            arrayList = null;
            for (Key key : arrayList2) {
                if (key instanceof KeyPosition) {
                    KeyPosition keyPosition = (KeyPosition) key;
                    insertKey(new MotionPaths(i8, i9, keyPosition, this.mStartMotionPath, this.mEndMotionPath));
                    int i11 = keyPosition.mCurveFit;
                    if (i11 != Key.UNSET) {
                        this.mCurveFitType = i11;
                    }
                } else if (key instanceof KeyCycle) {
                    key.getAttributeNames(hashSet3);
                } else if (key instanceof KeyTimeCycle) {
                    key.getAttributeNames(hashSet);
                } else if (key instanceof KeyTrigger) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add((KeyTrigger) key);
                } else {
                    key.setInterpolation(map);
                    key.getAttributeNames(hashSet2);
                }
            }
        } else {
            arrayList = null;
        }
        if (arrayList != null) {
            this.mKeyTriggers = (KeyTrigger[]) arrayList.toArray(new KeyTrigger[0]);
        }
        char c9 = 1;
        if (!hashSet2.isEmpty()) {
            this.mAttributesMap = new HashMap<>();
            for (String str : hashSet2) {
                if (str.startsWith("CUSTOM,")) {
                    SparseArray sparseArray = new SparseArray();
                    String str2 = str.split(",")[1];
                    for (Key key2 : this.mKeyList) {
                        HashMap<String, ConstraintAttribute> map2 = key2.mCustomConstraints;
                        if (map2 != null && (constraintAttribute3 = map2.get(str2)) != null) {
                            sparseArray.append(key2.mFramePosition, constraintAttribute3);
                        }
                    }
                    viewSplineMakeSpline = ViewSpline.makeCustomSpline(str, (SparseArray<ConstraintAttribute>) sparseArray);
                } else {
                    viewSplineMakeSpline = ViewSpline.makeSpline(str);
                }
                if (viewSplineMakeSpline != null) {
                    viewSplineMakeSpline.setType(str);
                    this.mAttributesMap.put(str, viewSplineMakeSpline);
                }
            }
            ArrayList<Key> arrayList3 = this.mKeyList;
            if (arrayList3 != null) {
                for (Key key3 : arrayList3) {
                    if (key3 instanceof KeyAttributes) {
                        key3.addValues(this.mAttributesMap);
                    }
                }
            }
            this.mStartPoint.addValues(this.mAttributesMap, 0);
            this.mEndPoint.addValues(this.mAttributesMap, 100);
            for (String str3 : this.mAttributesMap.keySet()) {
                int iIntValue = (!map.containsKey(str3) || (num = map.get(str3)) == null) ? 0 : num.intValue();
                ViewSpline viewSpline = this.mAttributesMap.get(str3);
                if (viewSpline != null) {
                    viewSpline.setup(iIntValue);
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
                        SparseArray sparseArray2 = new SparseArray();
                        String str5 = str4.split(",")[1];
                        for (Key key4 : this.mKeyList) {
                            HashMap<String, ConstraintAttribute> map3 = key4.mCustomConstraints;
                            if (map3 != null && (constraintAttribute2 = map3.get(str5)) != null) {
                                sparseArray2.append(key4.mFramePosition, constraintAttribute2);
                            }
                        }
                        viewTimeCycleMakeSpline = ViewTimeCycle.makeCustomSpline(str4, sparseArray2);
                    } else {
                        viewTimeCycleMakeSpline = ViewTimeCycle.makeSpline(str4, j8);
                    }
                    if (viewTimeCycleMakeSpline != null) {
                        viewTimeCycleMakeSpline.setType(str4);
                        this.mTimeCycleAttributesMap.put(str4, viewTimeCycleMakeSpline);
                    }
                }
            }
            ArrayList<Key> arrayList4 = this.mKeyList;
            if (arrayList4 != null) {
                for (Key key5 : arrayList4) {
                    if (key5 instanceof KeyTimeCycle) {
                        ((KeyTimeCycle) key5).addTimeValues(this.mTimeCycleAttributesMap);
                    }
                }
            }
            for (String str6 : this.mTimeCycleAttributesMap.keySet()) {
                this.mTimeCycleAttributesMap.get(str6).setup(map.containsKey(str6) ? map.get(str6).intValue() : 0);
            }
        }
        int size = this.mMotionPaths.size();
        int i12 = size + 2;
        MotionPaths[] motionPathsArr = new MotionPaths[i12];
        motionPathsArr[0] = this.mStartMotionPath;
        motionPathsArr[size + 1] = this.mEndMotionPath;
        if (this.mMotionPaths.size() > 0 && this.mCurveFitType == -1) {
            this.mCurveFitType = 0;
        }
        Iterator<MotionPaths> it = this.mMotionPaths.iterator();
        int i13 = 1;
        while (it.hasNext()) {
            motionPathsArr[i13] = it.next();
            i13++;
        }
        HashSet hashSet4 = new HashSet();
        for (String str7 : this.mEndMotionPath.attributes.keySet()) {
            if (this.mStartMotionPath.attributes.containsKey(str7)) {
                if (!hashSet2.contains("CUSTOM," + str7)) {
                    hashSet4.add(str7);
                }
            }
        }
        String[] strArr2 = (String[]) hashSet4.toArray(new String[0]);
        this.mAttributeNames = strArr2;
        this.mAttributeInterpolatorCount = new int[strArr2.length];
        int i14 = 0;
        while (true) {
            strArr = this.mAttributeNames;
            if (i14 >= strArr.length) {
                break;
            }
            String str8 = strArr[i14];
            this.mAttributeInterpolatorCount[i14] = 0;
            for (int i15 = 0; i15 < i12; i15++) {
                if (motionPathsArr[i15].attributes.containsKey(str8) && (constraintAttribute = motionPathsArr[i15].attributes.get(str8)) != null) {
                    int[] iArr = this.mAttributeInterpolatorCount;
                    iArr[i14] = constraintAttribute.numberOfInterpolatedValues() + iArr[i14];
                    break;
                }
            }
            i14++;
        }
        boolean z2 = motionPathsArr[0].mPathMotionArc != Key.UNSET;
        int length = 18 + strArr.length;
        boolean[] zArr = new boolean[length];
        for (int i16 = 1; i16 < i12; i16++) {
            motionPathsArr[i16].different(motionPathsArr[i16 - 1], zArr, this.mAttributeNames, z2);
        }
        int i17 = 0;
        for (int i18 = 1; i18 < length; i18++) {
            if (zArr[i18]) {
                i17++;
            }
        }
        this.mInterpolateVariables = new int[i17];
        int i19 = 2;
        int iMax = Math.max(2, i17);
        this.mInterpolateData = new double[iMax];
        this.mInterpolateVelocity = new double[iMax];
        int i20 = 0;
        for (int i21 = 1; i21 < length; i21++) {
            if (zArr[i21]) {
                this.mInterpolateVariables[i20] = i21;
                i20++;
            }
        }
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i12, this.mInterpolateVariables.length);
        double[] dArr2 = new double[i12];
        for (int i22 = 0; i22 < i12; i22++) {
            motionPathsArr[i22].fillStandard(dArr[i22], this.mInterpolateVariables);
            dArr2[i22] = motionPathsArr[i22].time;
        }
        int i23 = 0;
        while (true) {
            int[] iArr2 = this.mInterpolateVariables;
            if (i23 >= iArr2.length) {
                break;
            }
            if (iArr2[i23] < MotionPaths.names.length) {
                String strN = h0.a.n(new StringBuilder(), MotionPaths.names[this.mInterpolateVariables[i23]], " [");
                for (int i24 = 0; i24 < i12; i24++) {
                    StringBuilder sbS = d.s(strN);
                    sbS.append(dArr[i24][i23]);
                    strN = sbS.toString();
                }
            }
            i23++;
        }
        this.mSpline = new CurveFit[this.mAttributeNames.length + 1];
        int i25 = 0;
        while (true) {
            String[] strArr3 = this.mAttributeNames;
            if (i25 >= strArr3.length) {
                break;
            }
            String str9 = strArr3[i25];
            int i26 = 0;
            int i27 = 0;
            double[] dArr3 = null;
            double[][] dArr4 = null;
            while (i26 < i12) {
                if (motionPathsArr[i26].hasCustomData(str9)) {
                    if (dArr4 == null) {
                        dArr3 = new double[i12];
                        int[] iArr3 = new int[i19];
                        iArr3[c9] = motionPathsArr[i26].getCustomDataCount(str9);
                        iArr3[0] = i12;
                        dArr4 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, iArr3);
                    }
                    MotionPaths motionPaths = motionPathsArr[i26];
                    dArr3[i27] = motionPaths.time;
                    motionPaths.getCustomData(str9, dArr4[i27], 0);
                    i27++;
                }
                i26++;
                dArr = dArr;
                i19 = 2;
                c9 = 1;
            }
            i25++;
            this.mSpline[i25] = CurveFit.get(this.mCurveFitType, Arrays.copyOf(dArr3, i27), (double[][]) Arrays.copyOf(dArr4, i27));
            dArr = dArr;
            i19 = 2;
            c9 = 1;
        }
        this.mSpline[0] = CurveFit.get(this.mCurveFitType, dArr2, dArr);
        if (motionPathsArr[0].mPathMotionArc != Key.UNSET) {
            int[] iArr4 = new int[i12];
            double[] dArr5 = new double[i12];
            double[][] dArr6 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i12, 2);
            for (int i28 = 0; i28 < i12; i28++) {
                MotionPaths motionPaths2 = motionPathsArr[i28];
                iArr4[i28] = motionPaths2.mPathMotionArc;
                dArr5[i28] = motionPaths2.time;
                double[] dArr7 = dArr6[i28];
                dArr7[0] = motionPaths2.f1090x;
                dArr7[1] = motionPaths2.f1091y;
            }
            this.mArcSpline = CurveFit.getArc(iArr4, dArr5, dArr6);
        }
        this.mCycleMap = new HashMap<>();
        if (this.mKeyList != null) {
            float preCycleDistance = Float.NaN;
            for (String str10 : hashSet3) {
                ViewOscillator viewOscillatorMakeSpline = ViewOscillator.makeSpline(str10);
                if (viewOscillatorMakeSpline != null) {
                    if (viewOscillatorMakeSpline.variesByPath() && Float.isNaN(preCycleDistance)) {
                        preCycleDistance = getPreCycleDistance();
                    }
                    viewOscillatorMakeSpline.setType(str10);
                    this.mCycleMap.put(str10, viewOscillatorMakeSpline);
                }
            }
            for (Key key6 : this.mKeyList) {
                if (key6 instanceof KeyCycle) {
                    ((KeyCycle) key6).addCycleValues(this.mCycleMap);
                }
            }
            Iterator<ViewOscillator> it2 = this.mCycleMap.values().iterator();
            while (it2.hasNext()) {
                it2.next().setup(preCycleDistance);
            }
        }
    }

    public void setupRelative(MotionController motionController) {
        this.mStartMotionPath.setupRelative(motionController, motionController.mStartMotionPath);
        this.mEndMotionPath.setupRelative(motionController, motionController.mEndMotionPath);
    }

    public String toString() {
        return " start: x: " + this.mStartMotionPath.f1090x + " y: " + this.mStartMotionPath.f1091y + " end: x: " + this.mEndMotionPath.f1090x + " y: " + this.mEndMotionPath.f1091y;
    }

    public void setStartState(Rect rect, ConstraintSet constraintSet, int i8, int i9) {
        int i10 = constraintSet.mRotate;
        if (i10 != 0) {
            rotate(rect, this.mTempRect, i10, i8, i9);
        }
        MotionPaths motionPaths = this.mStartMotionPath;
        motionPaths.time = 0.0f;
        motionPaths.position = 0.0f;
        readView(motionPaths);
        this.mStartMotionPath.setBounds(rect.left, rect.top, rect.width(), rect.height());
        ConstraintSet.Constraint parameters = constraintSet.getParameters(this.mId);
        this.mStartMotionPath.applyParameters(parameters);
        this.mMotionStagger = parameters.motion.mMotionStagger;
        this.mStartPoint.setState(rect, constraintSet, i10, this.mId);
        this.mTransformPivotTarget = parameters.transform.transformPivotTarget;
        ConstraintSet.Motion motion = parameters.motion;
        this.mQuantizeMotionSteps = motion.mQuantizeMotionSteps;
        this.mQuantizeMotionPhase = motion.mQuantizeMotionPhase;
        Context context = this.mView.getContext();
        ConstraintSet.Motion motion2 = parameters.motion;
        this.mQuantizeMotionInterpolator = getInterpolator(context, motion2.mQuantizeInterpolatorType, motion2.mQuantizeInterpolatorString, motion2.mQuantizeInterpolatorID);
    }
}
