package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.R;
import c1.c;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import m.a;

/* JADX INFO: loaded from: classes.dex */
public class KeyAttributes extends Key {
    private static final boolean DEBUG = false;
    public static final int KEY_TYPE = 1;
    static final String NAME = "KeyAttribute";
    private static final String TAG = "KeyAttributes";
    private String mTransitionEasing;
    private int mCurveFit = -1;
    private boolean mVisibility = false;
    private float mAlpha = Float.NaN;
    private float mElevation = Float.NaN;
    private float mRotation = Float.NaN;
    private float mRotationX = Float.NaN;
    private float mRotationY = Float.NaN;
    private float mPivotX = Float.NaN;
    private float mPivotY = Float.NaN;
    private float mTransitionPathRotate = Float.NaN;
    private float mScaleX = Float.NaN;
    private float mScaleY = Float.NaN;
    private float mTranslationX = Float.NaN;
    private float mTranslationY = Float.NaN;
    private float mTranslationZ = Float.NaN;
    private float mProgress = Float.NaN;

    public static class Loader {
        private static final int ANDROID_ALPHA = 1;
        private static final int ANDROID_ELEVATION = 2;
        private static final int ANDROID_PIVOT_X = 19;
        private static final int ANDROID_PIVOT_Y = 20;
        private static final int ANDROID_ROTATION = 4;
        private static final int ANDROID_ROTATION_X = 5;
        private static final int ANDROID_ROTATION_Y = 6;
        private static final int ANDROID_SCALE_X = 7;
        private static final int ANDROID_SCALE_Y = 14;
        private static final int ANDROID_TRANSLATION_X = 15;
        private static final int ANDROID_TRANSLATION_Y = 16;
        private static final int ANDROID_TRANSLATION_Z = 17;
        private static final int CURVE_FIT = 13;
        private static final int FRAME_POSITION = 12;
        private static final int PROGRESS = 18;
        private static final int TARGET_ID = 10;
        private static final int TRANSITION_EASING = 9;
        private static final int TRANSITION_PATH_ROTATE = 8;
        private static SparseIntArray mAttrMap;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            mAttrMap = sparseIntArray;
            sparseIntArray.append(R.styleable.KeyAttribute_android_alpha, 1);
            mAttrMap.append(R.styleable.KeyAttribute_android_elevation, 2);
            mAttrMap.append(R.styleable.KeyAttribute_android_rotation, 4);
            mAttrMap.append(R.styleable.KeyAttribute_android_rotationX, 5);
            mAttrMap.append(R.styleable.KeyAttribute_android_rotationY, 6);
            mAttrMap.append(R.styleable.KeyAttribute_android_transformPivotX, 19);
            mAttrMap.append(R.styleable.KeyAttribute_android_transformPivotY, 20);
            mAttrMap.append(R.styleable.KeyAttribute_android_scaleX, 7);
            mAttrMap.append(R.styleable.KeyAttribute_transitionPathRotate, 8);
            mAttrMap.append(R.styleable.KeyAttribute_transitionEasing, 9);
            mAttrMap.append(R.styleable.KeyAttribute_motionTarget, 10);
            mAttrMap.append(R.styleable.KeyAttribute_framePosition, 12);
            mAttrMap.append(R.styleable.KeyAttribute_curveFit, 13);
            mAttrMap.append(R.styleable.KeyAttribute_android_scaleY, 14);
            mAttrMap.append(R.styleable.KeyAttribute_android_translationX, 15);
            mAttrMap.append(R.styleable.KeyAttribute_android_translationY, 16);
            mAttrMap.append(R.styleable.KeyAttribute_android_translationZ, 17);
            mAttrMap.append(R.styleable.KeyAttribute_motionProgress, 18);
        }

        private Loader() {
        }

        public static void read(KeyAttributes c10, TypedArray a10) {
            int indexCount = a10.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = a10.getIndex(i10);
                switch (mAttrMap.get(index)) {
                    case 1:
                        c10.mAlpha = a10.getFloat(index, c10.mAlpha);
                        break;
                    case 2:
                        c10.mElevation = a10.getDimension(index, c10.mElevation);
                        break;
                    case 3:
                    case 11:
                    default:
                        Log.e(KeyAttributes.NAME, "unused attribute 0x" + Integer.toHexString(index) + "   " + mAttrMap.get(index));
                        break;
                    case 4:
                        c10.mRotation = a10.getFloat(index, c10.mRotation);
                        break;
                    case 5:
                        c10.mRotationX = a10.getFloat(index, c10.mRotationX);
                        break;
                    case 6:
                        c10.mRotationY = a10.getFloat(index, c10.mRotationY);
                        break;
                    case 7:
                        c10.mScaleX = a10.getFloat(index, c10.mScaleX);
                        break;
                    case 8:
                        c10.mTransitionPathRotate = a10.getFloat(index, c10.mTransitionPathRotate);
                        break;
                    case 9:
                        c10.mTransitionEasing = a10.getString(index);
                        break;
                    case 10:
                        if (MotionLayout.IS_IN_EDIT_MODE) {
                            int resourceId = a10.getResourceId(index, c10.mTargetId);
                            c10.mTargetId = resourceId;
                            if (resourceId == -1) {
                                c10.mTargetString = a10.getString(index);
                            }
                        } else if (a10.peekValue(index).type == 3) {
                            c10.mTargetString = a10.getString(index);
                        } else {
                            c10.mTargetId = a10.getResourceId(index, c10.mTargetId);
                        }
                        break;
                    case 12:
                        c10.mFramePosition = a10.getInt(index, c10.mFramePosition);
                        break;
                    case 13:
                        c10.mCurveFit = a10.getInteger(index, c10.mCurveFit);
                        break;
                    case 14:
                        c10.mScaleY = a10.getFloat(index, c10.mScaleY);
                        break;
                    case 15:
                        c10.mTranslationX = a10.getDimension(index, c10.mTranslationX);
                        break;
                    case 16:
                        c10.mTranslationY = a10.getDimension(index, c10.mTranslationY);
                        break;
                    case 17:
                        c10.mTranslationZ = a10.getDimension(index, c10.mTranslationZ);
                        break;
                    case 18:
                        c10.mProgress = a10.getFloat(index, c10.mProgress);
                        break;
                    case 19:
                        c10.mPivotX = a10.getDimension(index, c10.mPivotX);
                        break;
                    case 20:
                        c10.mPivotY = a10.getDimension(index, c10.mPivotY);
                        break;
                }
            }
        }
    }

    public KeyAttributes() {
        this.mType = 1;
        this.mCustomConstraints = new HashMap<>();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // androidx.constraintlayout.motion.widget.Key
    public void addValues(HashMap<String, ViewSpline> splines) {
        for (String str : splines.keySet()) {
            ViewSpline viewSpline = splines.get(str);
            if (viewSpline != null) {
                if (!str.startsWith("CUSTOM")) {
                    byte b10 = -1;
                    switch (str.hashCode()) {
                        case -1249320806:
                            if (str.equals("rotationX")) {
                                b10 = 0;
                            }
                            break;
                        case -1249320805:
                            if (str.equals("rotationY")) {
                                b10 = 1;
                            }
                            break;
                        case -1225497657:
                            if (str.equals("translationX")) {
                                b10 = 2;
                            }
                            break;
                        case -1225497656:
                            if (str.equals("translationY")) {
                                b10 = 3;
                            }
                            break;
                        case -1225497655:
                            if (str.equals("translationZ")) {
                                b10 = 4;
                            }
                            break;
                        case -1001078227:
                            if (str.equals("progress")) {
                                b10 = 5;
                            }
                            break;
                        case -908189618:
                            if (str.equals("scaleX")) {
                                b10 = 6;
                            }
                            break;
                        case -908189617:
                            if (str.equals("scaleY")) {
                                b10 = 7;
                            }
                            break;
                        case -760884510:
                            if (str.equals(Key.PIVOT_X)) {
                                b10 = 8;
                            }
                            break;
                        case -760884509:
                            if (str.equals(Key.PIVOT_Y)) {
                                b10 = 9;
                            }
                            break;
                        case -40300674:
                            if (str.equals(Key.ROTATION)) {
                                b10 = 10;
                            }
                            break;
                        case -4379043:
                            if (str.equals("elevation")) {
                                b10 = c.f1119m;
                            }
                            break;
                        case 37232917:
                            if (str.equals("transitionPathRotate")) {
                                b10 = c.f1120n;
                            }
                            break;
                        case 92909918:
                            if (str.equals("alpha")) {
                                b10 = 13;
                            }
                            break;
                    }
                    switch (b10) {
                        case 0:
                            if (!Float.isNaN(this.mRotationX)) {
                                viewSpline.setPoint(this.mFramePosition, this.mRotationX);
                            }
                            break;
                        case 1:
                            if (!Float.isNaN(this.mRotationY)) {
                                viewSpline.setPoint(this.mFramePosition, this.mRotationY);
                            }
                            break;
                        case 2:
                            if (!Float.isNaN(this.mTranslationX)) {
                                viewSpline.setPoint(this.mFramePosition, this.mTranslationX);
                            }
                            break;
                        case 3:
                            if (!Float.isNaN(this.mTranslationY)) {
                                viewSpline.setPoint(this.mFramePosition, this.mTranslationY);
                            }
                            break;
                        case 4:
                            if (!Float.isNaN(this.mTranslationZ)) {
                                viewSpline.setPoint(this.mFramePosition, this.mTranslationZ);
                            }
                            break;
                        case 5:
                            if (!Float.isNaN(this.mProgress)) {
                                viewSpline.setPoint(this.mFramePosition, this.mProgress);
                            }
                            break;
                        case 6:
                            if (!Float.isNaN(this.mScaleX)) {
                                viewSpline.setPoint(this.mFramePosition, this.mScaleX);
                            }
                            break;
                        case 7:
                            if (!Float.isNaN(this.mScaleY)) {
                                viewSpline.setPoint(this.mFramePosition, this.mScaleY);
                            }
                            break;
                        case 8:
                            if (!Float.isNaN(this.mRotationX)) {
                                viewSpline.setPoint(this.mFramePosition, this.mPivotX);
                            }
                            break;
                        case 9:
                            if (!Float.isNaN(this.mRotationY)) {
                                viewSpline.setPoint(this.mFramePosition, this.mPivotY);
                            }
                            break;
                        case 10:
                            if (!Float.isNaN(this.mRotation)) {
                                viewSpline.setPoint(this.mFramePosition, this.mRotation);
                            }
                            break;
                        case 11:
                            if (!Float.isNaN(this.mElevation)) {
                                viewSpline.setPoint(this.mFramePosition, this.mElevation);
                            }
                            break;
                        case 12:
                            if (!Float.isNaN(this.mTransitionPathRotate)) {
                                viewSpline.setPoint(this.mFramePosition, this.mTransitionPathRotate);
                            }
                            break;
                        case 13:
                            if (!Float.isNaN(this.mAlpha)) {
                                viewSpline.setPoint(this.mFramePosition, this.mAlpha);
                            }
                            break;
                    }
                } else {
                    ConstraintAttribute constraintAttribute = this.mCustomConstraints.get(str.substring(7));
                    if (constraintAttribute != null) {
                        ((ViewSpline.CustomSet) viewSpline).setPoint(this.mFramePosition, constraintAttribute);
                    }
                }
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public Key copy(Key src) {
        super.copy(src);
        KeyAttributes keyAttributes = (KeyAttributes) src;
        this.mCurveFit = keyAttributes.mCurveFit;
        this.mVisibility = keyAttributes.mVisibility;
        this.mAlpha = keyAttributes.mAlpha;
        this.mElevation = keyAttributes.mElevation;
        this.mRotation = keyAttributes.mRotation;
        this.mRotationX = keyAttributes.mRotationX;
        this.mRotationY = keyAttributes.mRotationY;
        this.mPivotX = keyAttributes.mPivotX;
        this.mPivotY = keyAttributes.mPivotY;
        this.mTransitionPathRotate = keyAttributes.mTransitionPathRotate;
        this.mScaleX = keyAttributes.mScaleX;
        this.mScaleY = keyAttributes.mScaleY;
        this.mTranslationX = keyAttributes.mTranslationX;
        this.mTranslationY = keyAttributes.mTranslationY;
        this.mTranslationZ = keyAttributes.mTranslationZ;
        this.mProgress = keyAttributes.mProgress;
        return this;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void getAttributeNames(HashSet<String> attributes) {
        if (!Float.isNaN(this.mAlpha)) {
            attributes.add("alpha");
        }
        if (!Float.isNaN(this.mElevation)) {
            attributes.add("elevation");
        }
        if (!Float.isNaN(this.mRotation)) {
            attributes.add(Key.ROTATION);
        }
        if (!Float.isNaN(this.mRotationX)) {
            attributes.add("rotationX");
        }
        if (!Float.isNaN(this.mRotationY)) {
            attributes.add("rotationY");
        }
        if (!Float.isNaN(this.mPivotX)) {
            attributes.add(Key.PIVOT_X);
        }
        if (!Float.isNaN(this.mPivotY)) {
            attributes.add(Key.PIVOT_Y);
        }
        if (!Float.isNaN(this.mTranslationX)) {
            attributes.add("translationX");
        }
        if (!Float.isNaN(this.mTranslationY)) {
            attributes.add("translationY");
        }
        if (!Float.isNaN(this.mTranslationZ)) {
            attributes.add("translationZ");
        }
        if (!Float.isNaN(this.mTransitionPathRotate)) {
            attributes.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.mScaleX)) {
            attributes.add("scaleX");
        }
        if (!Float.isNaN(this.mScaleY)) {
            attributes.add("scaleY");
        }
        if (!Float.isNaN(this.mProgress)) {
            attributes.add("progress");
        }
        if (this.mCustomConstraints.size() > 0) {
            Iterator<String> it = this.mCustomConstraints.keySet().iterator();
            while (it.hasNext()) {
                attributes.add("CUSTOM," + it.next());
            }
        }
    }

    public int getCurveFit() {
        return this.mCurveFit;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void load(Context context, AttributeSet attrs) {
        Loader.read(this, context.obtainStyledAttributes(attrs, R.styleable.KeyAttribute));
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void setInterpolation(HashMap<String, Integer> interpolation) {
        if (this.mCurveFit == -1) {
            return;
        }
        if (!Float.isNaN(this.mAlpha)) {
            interpolation.put("alpha", Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mElevation)) {
            interpolation.put("elevation", Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mRotation)) {
            interpolation.put(Key.ROTATION, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mRotationX)) {
            interpolation.put("rotationX", Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mRotationY)) {
            interpolation.put("rotationY", Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mPivotX)) {
            interpolation.put(Key.PIVOT_X, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mPivotY)) {
            interpolation.put(Key.PIVOT_Y, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mTranslationX)) {
            interpolation.put("translationX", Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mTranslationY)) {
            interpolation.put("translationY", Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mTranslationZ)) {
            interpolation.put("translationZ", Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mTransitionPathRotate)) {
            interpolation.put("transitionPathRotate", Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mScaleX)) {
            interpolation.put("scaleX", Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mScaleY)) {
            interpolation.put("scaleY", Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mProgress)) {
            interpolation.put("progress", Integer.valueOf(this.mCurveFit));
        }
        if (this.mCustomConstraints.size() > 0) {
            Iterator<String> it = this.mCustomConstraints.keySet().iterator();
            while (it.hasNext()) {
                interpolation.put(a.a("CUSTOM,", it.next()), Integer.valueOf(this.mCurveFit));
            }
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // androidx.constraintlayout.motion.widget.Key
    public void setValue(String tag, Object value) {
        tag.getClass();
        byte b10 = -1;
        switch (tag.hashCode()) {
            case -1913008125:
                if (tag.equals(Key.MOTIONPROGRESS)) {
                    b10 = 0;
                }
                break;
            case -1812823328:
                if (tag.equals("transitionEasing")) {
                    b10 = 1;
                }
                break;
            case -1249320806:
                if (tag.equals("rotationX")) {
                    b10 = 2;
                }
                break;
            case -1249320805:
                if (tag.equals("rotationY")) {
                    b10 = 3;
                }
                break;
            case -1225497657:
                if (tag.equals("translationX")) {
                    b10 = 4;
                }
                break;
            case -1225497656:
                if (tag.equals("translationY")) {
                    b10 = 5;
                }
                break;
            case -1225497655:
                if (tag.equals("translationZ")) {
                    b10 = 6;
                }
                break;
            case -908189618:
                if (tag.equals("scaleX")) {
                    b10 = 7;
                }
                break;
            case -908189617:
                if (tag.equals("scaleY")) {
                    b10 = 8;
                }
                break;
            case -760884510:
                if (tag.equals(Key.PIVOT_X)) {
                    b10 = 9;
                }
                break;
            case -760884509:
                if (tag.equals(Key.PIVOT_Y)) {
                    b10 = 10;
                }
                break;
            case -40300674:
                if (tag.equals(Key.ROTATION)) {
                    b10 = c.f1119m;
                }
                break;
            case -4379043:
                if (tag.equals("elevation")) {
                    b10 = c.f1120n;
                }
                break;
            case 37232917:
                if (tag.equals("transitionPathRotate")) {
                    b10 = 13;
                }
                break;
            case 92909918:
                if (tag.equals("alpha")) {
                    b10 = c.f1122p;
                }
                break;
            case 579057826:
                if (tag.equals("curveFit")) {
                    b10 = c.f1123q;
                }
                break;
            case 1941332754:
                if (tag.equals("visibility")) {
                    b10 = c.f1124r;
                }
                break;
        }
        switch (b10) {
            case 0:
                this.mProgress = toFloat(value);
                break;
            case 1:
                this.mTransitionEasing = value.toString();
                break;
            case 2:
                this.mRotationX = toFloat(value);
                break;
            case 3:
                this.mRotationY = toFloat(value);
                break;
            case 4:
                this.mTranslationX = toFloat(value);
                break;
            case 5:
                this.mTranslationY = toFloat(value);
                break;
            case 6:
                this.mTranslationZ = toFloat(value);
                break;
            case 7:
                this.mScaleX = toFloat(value);
                break;
            case 8:
                this.mScaleY = toFloat(value);
                break;
            case 9:
                this.mPivotX = toFloat(value);
                break;
            case 10:
                this.mPivotY = toFloat(value);
                break;
            case 11:
                this.mRotation = toFloat(value);
                break;
            case 12:
                this.mElevation = toFloat(value);
                break;
            case 13:
                this.mTransitionPathRotate = toFloat(value);
                break;
            case 14:
                this.mAlpha = toFloat(value);
                break;
            case 15:
                this.mCurveFit = toInt(value);
                break;
            case 16:
                this.mVisibility = toBoolean(value);
                break;
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    /* JADX INFO: renamed from: clone */
    public Key mo4clone() {
        return new KeyAttributes().copy(this);
    }
}
