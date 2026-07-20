package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.motion.utils.ViewOscillator;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.R;
import c1.c;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class KeyCycle extends Key {
    public static final int KEY_TYPE = 4;
    static final String NAME = "KeyCycle";
    public static final int SHAPE_BOUNCE = 6;
    public static final int SHAPE_COS_WAVE = 5;
    public static final int SHAPE_REVERSE_SAW_WAVE = 4;
    public static final int SHAPE_SAW_WAVE = 3;
    public static final int SHAPE_SIN_WAVE = 0;
    public static final int SHAPE_SQUARE_WAVE = 1;
    public static final int SHAPE_TRIANGLE_WAVE = 2;
    private static final String TAG = "KeyCycle";
    public static final String WAVE_OFFSET = "waveOffset";
    public static final String WAVE_PERIOD = "wavePeriod";
    public static final String WAVE_PHASE = "wavePhase";
    public static final String WAVE_SHAPE = "waveShape";
    private String mTransitionEasing = null;
    private int mCurveFit = 0;
    private int mWaveShape = -1;
    private String mCustomWaveShape = null;
    private float mWavePeriod = Float.NaN;
    private float mWaveOffset = 0.0f;
    private float mWavePhase = 0.0f;
    private float mProgress = Float.NaN;
    private int mWaveVariesBy = -1;
    private float mAlpha = Float.NaN;
    private float mElevation = Float.NaN;
    private float mRotation = Float.NaN;
    private float mTransitionPathRotate = Float.NaN;
    private float mRotationX = Float.NaN;
    private float mRotationY = Float.NaN;
    private float mScaleX = Float.NaN;
    private float mScaleY = Float.NaN;
    private float mTranslationX = Float.NaN;
    private float mTranslationY = Float.NaN;
    private float mTranslationZ = Float.NaN;

    public static class Loader {
        private static final int ANDROID_ALPHA = 9;
        private static final int ANDROID_ELEVATION = 10;
        private static final int ANDROID_ROTATION = 11;
        private static final int ANDROID_ROTATION_X = 12;
        private static final int ANDROID_ROTATION_Y = 13;
        private static final int ANDROID_SCALE_X = 15;
        private static final int ANDROID_SCALE_Y = 16;
        private static final int ANDROID_TRANSLATION_X = 17;
        private static final int ANDROID_TRANSLATION_Y = 18;
        private static final int ANDROID_TRANSLATION_Z = 19;
        private static final int CURVE_FIT = 4;
        private static final int FRAME_POSITION = 2;
        private static final int PROGRESS = 20;
        private static final int TARGET_ID = 1;
        private static final int TRANSITION_EASING = 3;
        private static final int TRANSITION_PATH_ROTATE = 14;
        private static final int WAVE_OFFSET = 7;
        private static final int WAVE_PERIOD = 6;
        private static final int WAVE_PHASE = 21;
        private static final int WAVE_SHAPE = 5;
        private static final int WAVE_VARIES_BY = 8;
        private static SparseIntArray mAttrMap;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            mAttrMap = sparseIntArray;
            sparseIntArray.append(R.styleable.KeyCycle_motionTarget, 1);
            mAttrMap.append(R.styleable.KeyCycle_framePosition, 2);
            mAttrMap.append(R.styleable.KeyCycle_transitionEasing, 3);
            mAttrMap.append(R.styleable.KeyCycle_curveFit, 4);
            mAttrMap.append(R.styleable.KeyCycle_waveShape, 5);
            mAttrMap.append(R.styleable.KeyCycle_wavePeriod, 6);
            mAttrMap.append(R.styleable.KeyCycle_waveOffset, 7);
            mAttrMap.append(R.styleable.KeyCycle_waveVariesBy, 8);
            mAttrMap.append(R.styleable.KeyCycle_android_alpha, 9);
            mAttrMap.append(R.styleable.KeyCycle_android_elevation, 10);
            mAttrMap.append(R.styleable.KeyCycle_android_rotation, 11);
            mAttrMap.append(R.styleable.KeyCycle_android_rotationX, 12);
            mAttrMap.append(R.styleable.KeyCycle_android_rotationY, 13);
            mAttrMap.append(R.styleable.KeyCycle_transitionPathRotate, 14);
            mAttrMap.append(R.styleable.KeyCycle_android_scaleX, 15);
            mAttrMap.append(R.styleable.KeyCycle_android_scaleY, 16);
            mAttrMap.append(R.styleable.KeyCycle_android_translationX, 17);
            mAttrMap.append(R.styleable.KeyCycle_android_translationY, 18);
            mAttrMap.append(R.styleable.KeyCycle_android_translationZ, 19);
            mAttrMap.append(R.styleable.KeyCycle_motionProgress, 20);
            mAttrMap.append(R.styleable.KeyCycle_wavePhase, 21);
        }

        private Loader() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void read(KeyCycle c10, TypedArray a10) {
            int indexCount = a10.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = a10.getIndex(i10);
                switch (mAttrMap.get(index)) {
                    case 1:
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
                    case 2:
                        c10.mFramePosition = a10.getInt(index, c10.mFramePosition);
                        break;
                    case 3:
                        c10.mTransitionEasing = a10.getString(index);
                        break;
                    case 4:
                        c10.mCurveFit = a10.getInteger(index, c10.mCurveFit);
                        break;
                    case 5:
                        if (a10.peekValue(index).type == 3) {
                            c10.mCustomWaveShape = a10.getString(index);
                            c10.mWaveShape = 7;
                        } else {
                            c10.mWaveShape = a10.getInt(index, c10.mWaveShape);
                        }
                        break;
                    case 6:
                        c10.mWavePeriod = a10.getFloat(index, c10.mWavePeriod);
                        break;
                    case 7:
                        if (a10.peekValue(index).type == 5) {
                            c10.mWaveOffset = a10.getDimension(index, c10.mWaveOffset);
                        } else {
                            c10.mWaveOffset = a10.getFloat(index, c10.mWaveOffset);
                        }
                        break;
                    case 8:
                        c10.mWaveVariesBy = a10.getInt(index, c10.mWaveVariesBy);
                        break;
                    case 9:
                        c10.mAlpha = a10.getFloat(index, c10.mAlpha);
                        break;
                    case 10:
                        c10.mElevation = a10.getDimension(index, c10.mElevation);
                        break;
                    case 11:
                        c10.mRotation = a10.getFloat(index, c10.mRotation);
                        break;
                    case 12:
                        c10.mRotationX = a10.getFloat(index, c10.mRotationX);
                        break;
                    case 13:
                        c10.mRotationY = a10.getFloat(index, c10.mRotationY);
                        break;
                    case 14:
                        c10.mTransitionPathRotate = a10.getFloat(index, c10.mTransitionPathRotate);
                        break;
                    case 15:
                        c10.mScaleX = a10.getFloat(index, c10.mScaleX);
                        break;
                    case 16:
                        c10.mScaleY = a10.getFloat(index, c10.mScaleY);
                        break;
                    case 17:
                        c10.mTranslationX = a10.getDimension(index, c10.mTranslationX);
                        break;
                    case 18:
                        c10.mTranslationY = a10.getDimension(index, c10.mTranslationY);
                        break;
                    case 19:
                        c10.mTranslationZ = a10.getDimension(index, c10.mTranslationZ);
                        break;
                    case 20:
                        c10.mProgress = a10.getFloat(index, c10.mProgress);
                        break;
                    case 21:
                        c10.mWavePhase = a10.getFloat(index, c10.mWavePhase) / 360.0f;
                        break;
                    default:
                        Log.e(TypedValues.CycleType.NAME, "unused attribute 0x" + Integer.toHexString(index) + "   " + mAttrMap.get(index));
                        break;
                }
            }
        }
    }

    public KeyCycle() {
        this.mType = 4;
        this.mCustomConstraints = new HashMap<>();
    }

    public void addCycleValues(HashMap<String, ViewOscillator> oscSet) {
        ViewOscillator viewOscillator;
        ViewOscillator viewOscillator2;
        for (String str : oscSet.keySet()) {
            if (str.startsWith("CUSTOM")) {
                ConstraintAttribute constraintAttribute = this.mCustomConstraints.get(str.substring(7));
                if (constraintAttribute != null && constraintAttribute.getType() == ConstraintAttribute.AttributeType.FLOAT_TYPE && (viewOscillator = oscSet.get(str)) != null) {
                    viewOscillator.setPoint(this.mFramePosition, this.mWaveShape, this.mCustomWaveShape, this.mWaveVariesBy, this.mWavePeriod, this.mWaveOffset, this.mWavePhase, constraintAttribute.getValueToInterpolate(), constraintAttribute);
                }
            } else {
                float value = getValue(str);
                if (!Float.isNaN(value) && (viewOscillator2 = oscSet.get(str)) != null) {
                    viewOscillator2.setPoint(this.mFramePosition, this.mWaveShape, this.mCustomWaveShape, this.mWaveVariesBy, this.mWavePeriod, this.mWaveOffset, this.mWavePhase, value);
                }
            }
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // androidx.constraintlayout.motion.widget.Key
    public void addValues(HashMap<String, ViewSpline> splines) {
        Debug.logStack(TypedValues.CycleType.NAME, "add " + splines.size() + " values", 2);
        for (String str : splines.keySet()) {
            ViewSpline viewSpline = splines.get(str);
            if (viewSpline != null) {
                str.getClass();
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
                    case -40300674:
                        if (str.equals(Key.ROTATION)) {
                            b10 = 8;
                        }
                        break;
                    case -4379043:
                        if (str.equals("elevation")) {
                            b10 = 9;
                        }
                        break;
                    case 37232917:
                        if (str.equals("transitionPathRotate")) {
                            b10 = 10;
                        }
                        break;
                    case 92909918:
                        if (str.equals("alpha")) {
                            b10 = c.f1119m;
                        }
                        break;
                    case 156108012:
                        if (str.equals("waveOffset")) {
                            b10 = c.f1120n;
                        }
                        break;
                    case 1530034690:
                        if (str.equals("wavePhase")) {
                            b10 = 13;
                        }
                        break;
                }
                switch (b10) {
                    case 0:
                        viewSpline.setPoint(this.mFramePosition, this.mRotationX);
                        break;
                    case 1:
                        viewSpline.setPoint(this.mFramePosition, this.mRotationY);
                        break;
                    case 2:
                        viewSpline.setPoint(this.mFramePosition, this.mTranslationX);
                        break;
                    case 3:
                        viewSpline.setPoint(this.mFramePosition, this.mTranslationY);
                        break;
                    case 4:
                        viewSpline.setPoint(this.mFramePosition, this.mTranslationZ);
                        break;
                    case 5:
                        viewSpline.setPoint(this.mFramePosition, this.mProgress);
                        break;
                    case 6:
                        viewSpline.setPoint(this.mFramePosition, this.mScaleX);
                        break;
                    case 7:
                        viewSpline.setPoint(this.mFramePosition, this.mScaleY);
                        break;
                    case 8:
                        viewSpline.setPoint(this.mFramePosition, this.mRotation);
                        break;
                    case 9:
                        viewSpline.setPoint(this.mFramePosition, this.mElevation);
                        break;
                    case 10:
                        viewSpline.setPoint(this.mFramePosition, this.mTransitionPathRotate);
                        break;
                    case 11:
                        viewSpline.setPoint(this.mFramePosition, this.mAlpha);
                        break;
                    case 12:
                        viewSpline.setPoint(this.mFramePosition, this.mWaveOffset);
                        break;
                    case 13:
                        viewSpline.setPoint(this.mFramePosition, this.mWavePhase);
                        break;
                    default:
                        if (!str.startsWith("CUSTOM")) {
                            Log.v("WARNING KeyCycle", "  UNKNOWN  ".concat(str));
                        }
                        break;
                }
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public Key copy(Key src) {
        super.copy(src);
        KeyCycle keyCycle = (KeyCycle) src;
        this.mTransitionEasing = keyCycle.mTransitionEasing;
        this.mCurveFit = keyCycle.mCurveFit;
        this.mWaveShape = keyCycle.mWaveShape;
        this.mCustomWaveShape = keyCycle.mCustomWaveShape;
        this.mWavePeriod = keyCycle.mWavePeriod;
        this.mWaveOffset = keyCycle.mWaveOffset;
        this.mWavePhase = keyCycle.mWavePhase;
        this.mProgress = keyCycle.mProgress;
        this.mWaveVariesBy = keyCycle.mWaveVariesBy;
        this.mAlpha = keyCycle.mAlpha;
        this.mElevation = keyCycle.mElevation;
        this.mRotation = keyCycle.mRotation;
        this.mTransitionPathRotate = keyCycle.mTransitionPathRotate;
        this.mRotationX = keyCycle.mRotationX;
        this.mRotationY = keyCycle.mRotationY;
        this.mScaleX = keyCycle.mScaleX;
        this.mScaleY = keyCycle.mScaleY;
        this.mTranslationX = keyCycle.mTranslationX;
        this.mTranslationY = keyCycle.mTranslationY;
        this.mTranslationZ = keyCycle.mTranslationZ;
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
        if (!Float.isNaN(this.mScaleX)) {
            attributes.add("scaleX");
        }
        if (!Float.isNaN(this.mScaleY)) {
            attributes.add("scaleY");
        }
        if (!Float.isNaN(this.mTransitionPathRotate)) {
            attributes.add("transitionPathRotate");
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
        if (this.mCustomConstraints.size() > 0) {
            Iterator<String> it = this.mCustomConstraints.keySet().iterator();
            while (it.hasNext()) {
                attributes.add("CUSTOM," + it.next());
            }
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public float getValue(String key) {
        key.getClass();
        byte b10 = -1;
        switch (key.hashCode()) {
            case -1249320806:
                if (key.equals("rotationX")) {
                    b10 = 0;
                }
                break;
            case -1249320805:
                if (key.equals("rotationY")) {
                    b10 = 1;
                }
                break;
            case -1225497657:
                if (key.equals("translationX")) {
                    b10 = 2;
                }
                break;
            case -1225497656:
                if (key.equals("translationY")) {
                    b10 = 3;
                }
                break;
            case -1225497655:
                if (key.equals("translationZ")) {
                    b10 = 4;
                }
                break;
            case -1001078227:
                if (key.equals("progress")) {
                    b10 = 5;
                }
                break;
            case -908189618:
                if (key.equals("scaleX")) {
                    b10 = 6;
                }
                break;
            case -908189617:
                if (key.equals("scaleY")) {
                    b10 = 7;
                }
                break;
            case -40300674:
                if (key.equals(Key.ROTATION)) {
                    b10 = 8;
                }
                break;
            case -4379043:
                if (key.equals("elevation")) {
                    b10 = 9;
                }
                break;
            case 37232917:
                if (key.equals("transitionPathRotate")) {
                    b10 = 10;
                }
                break;
            case 92909918:
                if (key.equals("alpha")) {
                    b10 = c.f1119m;
                }
                break;
            case 156108012:
                if (key.equals("waveOffset")) {
                    b10 = c.f1120n;
                }
                break;
            case 1530034690:
                if (key.equals("wavePhase")) {
                    b10 = 13;
                }
                break;
        }
        switch (b10) {
            case 0:
                return this.mRotationX;
            case 1:
                return this.mRotationY;
            case 2:
                return this.mTranslationX;
            case 3:
                return this.mTranslationY;
            case 4:
                return this.mTranslationZ;
            case 5:
                return this.mProgress;
            case 6:
                return this.mScaleX;
            case 7:
                return this.mScaleY;
            case 8:
                return this.mRotation;
            case 9:
                return this.mElevation;
            case 10:
                return this.mTransitionPathRotate;
            case 11:
                return this.mAlpha;
            case 12:
                return this.mWaveOffset;
            case 13:
                return this.mWavePhase;
            default:
                if (key.startsWith("CUSTOM")) {
                    return Float.NaN;
                }
                Log.v("WARNING! KeyCycle", "  UNKNOWN  ".concat(key));
                return Float.NaN;
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void load(Context context, AttributeSet attrs) {
        Loader.read(this, context.obtainStyledAttributes(attrs, R.styleable.KeyCycle));
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
            case -40300674:
                if (tag.equals(Key.ROTATION)) {
                    b10 = 9;
                }
                break;
            case -4379043:
                if (tag.equals("elevation")) {
                    b10 = 10;
                }
                break;
            case 37232917:
                if (tag.equals("transitionPathRotate")) {
                    b10 = c.f1119m;
                }
                break;
            case 92909918:
                if (tag.equals("alpha")) {
                    b10 = c.f1120n;
                }
                break;
            case 156108012:
                if (tag.equals("waveOffset")) {
                    b10 = 13;
                }
                break;
            case 184161818:
                if (tag.equals("wavePeriod")) {
                    b10 = c.f1122p;
                }
                break;
            case 579057826:
                if (tag.equals("curveFit")) {
                    b10 = c.f1123q;
                }
                break;
            case 1530034690:
                if (tag.equals("wavePhase")) {
                    b10 = c.f1124r;
                }
                break;
            case 1532805160:
                if (tag.equals("waveShape")) {
                    b10 = 17;
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
                this.mRotation = toFloat(value);
                break;
            case 10:
                this.mElevation = toFloat(value);
                break;
            case 11:
                this.mTransitionPathRotate = toFloat(value);
                break;
            case 12:
                this.mAlpha = toFloat(value);
                break;
            case 13:
                this.mWaveOffset = toFloat(value);
                break;
            case 14:
                this.mWavePeriod = toFloat(value);
                break;
            case 15:
                this.mCurveFit = toInt(value);
                break;
            case 16:
                this.mWavePhase = toFloat(value);
                break;
            case 17:
                if (!(value instanceof Integer)) {
                    this.mWaveShape = 7;
                    this.mCustomWaveShape = value.toString();
                } else {
                    this.mWaveShape = toInt(value);
                }
                break;
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    /* JADX INFO: renamed from: clone */
    public Key mo4clone() {
        return new KeyCycle().copy(this);
    }
}
