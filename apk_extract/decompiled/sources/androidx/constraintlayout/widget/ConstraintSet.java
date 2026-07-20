package androidx.constraintlayout.widget;

import a1.a;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.HelperWidget;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.core.os.EnvironmentCompat;
import androidx.exifinterface.media.ExifInterface;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintSet {
    private static final int ALPHA = 43;
    private static final int ANIMATE_CIRCLE_ANGLE_TO = 82;
    private static final int ANIMATE_RELATIVE_TO = 64;
    private static final int BARRIER_ALLOWS_GONE_WIDGETS = 75;
    private static final int BARRIER_DIRECTION = 72;
    private static final int BARRIER_MARGIN = 73;
    private static final int BARRIER_TYPE = 1;
    public static final int BASELINE = 5;
    private static final int BASELINE_MARGIN = 93;
    private static final int BASELINE_TO_BASELINE = 1;
    private static final int BASELINE_TO_BOTTOM = 92;
    private static final int BASELINE_TO_TOP = 91;
    public static final int BOTTOM = 4;
    private static final int BOTTOM_MARGIN = 2;
    private static final int BOTTOM_TO_BOTTOM = 3;
    private static final int BOTTOM_TO_TOP = 4;
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    private static final int CHAIN_USE_RTL = 71;
    private static final int CIRCLE = 61;
    private static final int CIRCLE_ANGLE = 63;
    private static final int CIRCLE_RADIUS = 62;
    public static final int CIRCLE_REFERENCE = 8;
    private static final int CONSTRAINED_HEIGHT = 81;
    private static final int CONSTRAINED_WIDTH = 80;
    private static final int CONSTRAINT_REFERENCED_IDS = 74;
    private static final int CONSTRAINT_TAG = 77;
    private static final boolean DEBUG = false;
    private static final int DIMENSION_RATIO = 5;
    private static final int DRAW_PATH = 66;
    private static final int EDITOR_ABSOLUTE_X = 6;
    private static final int EDITOR_ABSOLUTE_Y = 7;
    private static final int ELEVATION = 44;
    public static final int END = 7;
    private static final int END_MARGIN = 8;
    private static final int END_TO_END = 9;
    private static final int END_TO_START = 10;
    private static final String ERROR_MESSAGE = "XML parser error must be within a Constraint ";
    public static final int GONE = 8;
    private static final int GONE_BASELINE_MARGIN = 94;
    private static final int GONE_BOTTOM_MARGIN = 11;
    private static final int GONE_END_MARGIN = 12;
    private static final int GONE_LEFT_MARGIN = 13;
    private static final int GONE_RIGHT_MARGIN = 14;
    private static final int GONE_START_MARGIN = 15;
    private static final int GONE_TOP_MARGIN = 16;
    private static final int GUIDELINE_USE_RTL = 99;
    private static final int GUIDE_BEGIN = 17;
    private static final int GUIDE_END = 18;
    private static final int GUIDE_PERCENT = 19;
    private static final int HEIGHT_DEFAULT = 55;
    private static final int HEIGHT_MAX = 57;
    private static final int HEIGHT_MIN = 59;
    private static final int HEIGHT_PERCENT = 70;
    public static final int HORIZONTAL = 0;
    private static final int HORIZONTAL_BIAS = 20;
    public static final int HORIZONTAL_GUIDELINE = 0;
    private static final int HORIZONTAL_STYLE = 41;
    private static final int HORIZONTAL_WEIGHT = 39;
    private static final int INTERNAL_MATCH_CONSTRAINT = -3;
    private static final int INTERNAL_MATCH_PARENT = -1;
    private static final int INTERNAL_WRAP_CONTENT = -2;
    private static final int INTERNAL_WRAP_CONTENT_CONSTRAINED = -4;
    public static final int INVISIBLE = 4;
    private static final String KEY_PERCENT_PARENT = "parent";
    private static final String KEY_RATIO = "ratio";
    private static final String KEY_WEIGHT = "weight";
    private static final int LAYOUT_CONSTRAINT_HEIGHT = 96;
    private static final int LAYOUT_CONSTRAINT_WIDTH = 95;
    private static final int LAYOUT_HEIGHT = 21;
    private static final int LAYOUT_VISIBILITY = 22;
    private static final int LAYOUT_WIDTH = 23;
    private static final int LAYOUT_WRAP_BEHAVIOR = 97;
    public static final int LEFT = 1;
    private static final int LEFT_MARGIN = 24;
    private static final int LEFT_TO_LEFT = 25;
    private static final int LEFT_TO_RIGHT = 26;
    public static final int MATCH_CONSTRAINT = 0;
    public static final int MATCH_CONSTRAINT_PERCENT = 2;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    private static final int MOTION_STAGGER = 79;
    private static final int MOTION_TARGET = 98;
    private static final int ORIENTATION = 27;
    public static final int PARENT_ID = 0;
    private static final int PATH_MOTION_ARC = 76;
    private static final int PROGRESS = 68;
    private static final int QUANTIZE_MOTION_INTERPOLATOR = 86;
    private static final int QUANTIZE_MOTION_INTERPOLATOR_ID = 89;
    private static final int QUANTIZE_MOTION_INTERPOLATOR_STR = 90;
    private static final int QUANTIZE_MOTION_INTERPOLATOR_TYPE = 88;
    private static final int QUANTIZE_MOTION_PHASE = 85;
    private static final int QUANTIZE_MOTION_STEPS = 84;
    public static final int RIGHT = 2;
    private static final int RIGHT_MARGIN = 28;
    private static final int RIGHT_TO_LEFT = 29;
    private static final int RIGHT_TO_RIGHT = 30;
    public static final int ROTATE_LEFT_OF_PORTRATE = 4;
    public static final int ROTATE_NONE = 0;
    public static final int ROTATE_PORTRATE_OF_LEFT = 2;
    public static final int ROTATE_PORTRATE_OF_RIGHT = 1;
    public static final int ROTATE_RIGHT_OF_PORTRATE = 3;
    private static final int ROTATION = 60;
    private static final int ROTATION_X = 45;
    private static final int ROTATION_Y = 46;
    private static final int SCALE_X = 47;
    private static final int SCALE_Y = 48;
    public static final int START = 6;
    private static final int START_MARGIN = 31;
    private static final int START_TO_END = 32;
    private static final int START_TO_START = 33;
    private static final String TAG = "ConstraintSet";
    public static final int TOP = 3;
    private static final int TOP_MARGIN = 34;
    private static final int TOP_TO_BOTTOM = 35;
    private static final int TOP_TO_TOP = 36;
    private static final int TRANSFORM_PIVOT_TARGET = 83;
    private static final int TRANSFORM_PIVOT_X = 49;
    private static final int TRANSFORM_PIVOT_Y = 50;
    private static final int TRANSITION_EASING = 65;
    private static final int TRANSITION_PATH_ROTATE = 67;
    private static final int TRANSLATION_X = 51;
    private static final int TRANSLATION_Y = 52;
    private static final int TRANSLATION_Z = 53;
    public static final int UNSET = -1;
    private static final int UNUSED = 87;
    public static final int VERTICAL = 1;
    private static final int VERTICAL_BIAS = 37;
    public static final int VERTICAL_GUIDELINE = 1;
    private static final int VERTICAL_STYLE = 42;
    private static final int VERTICAL_WEIGHT = 40;
    private static final int VIEW_ID = 38;
    private static final int VISIBILITY_MODE = 78;
    public static final int VISIBILITY_MODE_IGNORE = 1;
    public static final int VISIBILITY_MODE_NORMAL = 0;
    public static final int VISIBLE = 0;
    private static final int WIDTH_DEFAULT = 54;
    private static final int WIDTH_MAX = 56;
    private static final int WIDTH_MIN = 58;
    private static final int WIDTH_PERCENT = 69;
    public static final int WRAP_CONTENT = -2;
    public String mIdString;
    private boolean mValidate;
    private static final int[] VISIBILITY_FLAGS = {0, 4, 8};
    private static SparseIntArray mapToConstant = new SparseIntArray();
    private static SparseIntArray overrideMapToConstant = new SparseIntArray();
    public String derivedState = "";
    public int mRotate = 0;
    private HashMap<String, ConstraintAttribute> mSavedAttributes = new HashMap<>();
    private boolean mForceId = true;
    private HashMap<Integer, Constraint> mConstraints = new HashMap<>();

    public static class Constraint {
        Delta mDelta;
        String mTargetString;
        int mViewId;
        public final PropertySet propertySet = new PropertySet();
        public final Motion motion = new Motion();
        public final Layout layout = new Layout();
        public final Transform transform = new Transform();
        public HashMap<String, ConstraintAttribute> mCustomConstraints = new HashMap<>();

        /* JADX INFO: Access modifiers changed from: private */
        public void fillFrom(int i8, ConstraintLayout.LayoutParams layoutParams) {
            this.mViewId = i8;
            Layout layout = this.layout;
            layout.leftToLeft = layoutParams.leftToLeft;
            layout.leftToRight = layoutParams.leftToRight;
            layout.rightToLeft = layoutParams.rightToLeft;
            layout.rightToRight = layoutParams.rightToRight;
            layout.topToTop = layoutParams.topToTop;
            layout.topToBottom = layoutParams.topToBottom;
            layout.bottomToTop = layoutParams.bottomToTop;
            layout.bottomToBottom = layoutParams.bottomToBottom;
            layout.baselineToBaseline = layoutParams.baselineToBaseline;
            layout.baselineToTop = layoutParams.baselineToTop;
            layout.baselineToBottom = layoutParams.baselineToBottom;
            layout.startToEnd = layoutParams.startToEnd;
            layout.startToStart = layoutParams.startToStart;
            layout.endToStart = layoutParams.endToStart;
            layout.endToEnd = layoutParams.endToEnd;
            layout.horizontalBias = layoutParams.horizontalBias;
            layout.verticalBias = layoutParams.verticalBias;
            layout.dimensionRatio = layoutParams.dimensionRatio;
            layout.circleConstraint = layoutParams.circleConstraint;
            layout.circleRadius = layoutParams.circleRadius;
            layout.circleAngle = layoutParams.circleAngle;
            layout.editorAbsoluteX = layoutParams.editorAbsoluteX;
            layout.editorAbsoluteY = layoutParams.editorAbsoluteY;
            layout.orientation = layoutParams.orientation;
            layout.guidePercent = layoutParams.guidePercent;
            layout.guideBegin = layoutParams.guideBegin;
            layout.guideEnd = layoutParams.guideEnd;
            layout.mWidth = ((ViewGroup.MarginLayoutParams) layoutParams).width;
            layout.mHeight = ((ViewGroup.MarginLayoutParams) layoutParams).height;
            layout.leftMargin = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
            layout.rightMargin = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            layout.topMargin = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
            layout.bottomMargin = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            layout.baselineMargin = layoutParams.baselineMargin;
            layout.verticalWeight = layoutParams.verticalWeight;
            layout.horizontalWeight = layoutParams.horizontalWeight;
            layout.verticalChainStyle = layoutParams.verticalChainStyle;
            layout.horizontalChainStyle = layoutParams.horizontalChainStyle;
            layout.constrainedWidth = layoutParams.constrainedWidth;
            layout.constrainedHeight = layoutParams.constrainedHeight;
            layout.widthDefault = layoutParams.matchConstraintDefaultWidth;
            layout.heightDefault = layoutParams.matchConstraintDefaultHeight;
            layout.widthMax = layoutParams.matchConstraintMaxWidth;
            layout.heightMax = layoutParams.matchConstraintMaxHeight;
            layout.widthMin = layoutParams.matchConstraintMinWidth;
            layout.heightMin = layoutParams.matchConstraintMinHeight;
            layout.widthPercent = layoutParams.matchConstraintPercentWidth;
            layout.heightPercent = layoutParams.matchConstraintPercentHeight;
            layout.mConstraintTag = layoutParams.constraintTag;
            layout.goneTopMargin = layoutParams.goneTopMargin;
            layout.goneBottomMargin = layoutParams.goneBottomMargin;
            layout.goneLeftMargin = layoutParams.goneLeftMargin;
            layout.goneRightMargin = layoutParams.goneRightMargin;
            layout.goneStartMargin = layoutParams.goneStartMargin;
            layout.goneEndMargin = layoutParams.goneEndMargin;
            layout.goneBaselineMargin = layoutParams.goneBaselineMargin;
            layout.mWrapBehavior = layoutParams.wrapBehaviorInParent;
            layout.endMargin = layoutParams.getMarginEnd();
            this.layout.startMargin = layoutParams.getMarginStart();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void fillFromConstraints(ConstraintHelper constraintHelper, int i8, Constraints.LayoutParams layoutParams) {
            fillFromConstraints(i8, layoutParams);
            if (constraintHelper instanceof Barrier) {
                Layout layout = this.layout;
                layout.mHelperType = 1;
                Barrier barrier = (Barrier) constraintHelper;
                layout.mBarrierDirection = barrier.getType();
                this.layout.mReferenceIds = barrier.getReferencedIds();
                this.layout.mBarrierMargin = barrier.getMargin();
            }
        }

        private ConstraintAttribute get(String str, ConstraintAttribute.AttributeType attributeType) {
            if (!this.mCustomConstraints.containsKey(str)) {
                ConstraintAttribute constraintAttribute = new ConstraintAttribute(str, attributeType);
                this.mCustomConstraints.put(str, constraintAttribute);
                return constraintAttribute;
            }
            ConstraintAttribute constraintAttribute2 = this.mCustomConstraints.get(str);
            if (constraintAttribute2.getType() == attributeType) {
                return constraintAttribute2;
            }
            throw new IllegalArgumentException("ConstraintAttribute is already a " + constraintAttribute2.getType().name());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setColorValue(String str, int i8) {
            get(str, ConstraintAttribute.AttributeType.COLOR_TYPE).setColorValue(i8);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFloatValue(String str, float f) {
            get(str, ConstraintAttribute.AttributeType.FLOAT_TYPE).setFloatValue(f);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIntValue(String str, int i8) {
            get(str, ConstraintAttribute.AttributeType.INT_TYPE).setIntValue(i8);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStringValue(String str, String str2) {
            get(str, ConstraintAttribute.AttributeType.STRING_TYPE).setStringValue(str2);
        }

        public void applyDelta(Constraint constraint) {
            Delta delta = this.mDelta;
            if (delta != null) {
                delta.applyDelta(constraint);
            }
        }

        public void applyTo(ConstraintLayout.LayoutParams layoutParams) {
            Layout layout = this.layout;
            layoutParams.leftToLeft = layout.leftToLeft;
            layoutParams.leftToRight = layout.leftToRight;
            layoutParams.rightToLeft = layout.rightToLeft;
            layoutParams.rightToRight = layout.rightToRight;
            layoutParams.topToTop = layout.topToTop;
            layoutParams.topToBottom = layout.topToBottom;
            layoutParams.bottomToTop = layout.bottomToTop;
            layoutParams.bottomToBottom = layout.bottomToBottom;
            layoutParams.baselineToBaseline = layout.baselineToBaseline;
            layoutParams.baselineToTop = layout.baselineToTop;
            layoutParams.baselineToBottom = layout.baselineToBottom;
            layoutParams.startToEnd = layout.startToEnd;
            layoutParams.startToStart = layout.startToStart;
            layoutParams.endToStart = layout.endToStart;
            layoutParams.endToEnd = layout.endToEnd;
            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = layout.leftMargin;
            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = layout.rightMargin;
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = layout.topMargin;
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = layout.bottomMargin;
            layoutParams.goneStartMargin = layout.goneStartMargin;
            layoutParams.goneEndMargin = layout.goneEndMargin;
            layoutParams.goneTopMargin = layout.goneTopMargin;
            layoutParams.goneBottomMargin = layout.goneBottomMargin;
            layoutParams.horizontalBias = layout.horizontalBias;
            layoutParams.verticalBias = layout.verticalBias;
            layoutParams.circleConstraint = layout.circleConstraint;
            layoutParams.circleRadius = layout.circleRadius;
            layoutParams.circleAngle = layout.circleAngle;
            layoutParams.dimensionRatio = layout.dimensionRatio;
            layoutParams.editorAbsoluteX = layout.editorAbsoluteX;
            layoutParams.editorAbsoluteY = layout.editorAbsoluteY;
            layoutParams.verticalWeight = layout.verticalWeight;
            layoutParams.horizontalWeight = layout.horizontalWeight;
            layoutParams.verticalChainStyle = layout.verticalChainStyle;
            layoutParams.horizontalChainStyle = layout.horizontalChainStyle;
            layoutParams.constrainedWidth = layout.constrainedWidth;
            layoutParams.constrainedHeight = layout.constrainedHeight;
            layoutParams.matchConstraintDefaultWidth = layout.widthDefault;
            layoutParams.matchConstraintDefaultHeight = layout.heightDefault;
            layoutParams.matchConstraintMaxWidth = layout.widthMax;
            layoutParams.matchConstraintMaxHeight = layout.heightMax;
            layoutParams.matchConstraintMinWidth = layout.widthMin;
            layoutParams.matchConstraintMinHeight = layout.heightMin;
            layoutParams.matchConstraintPercentWidth = layout.widthPercent;
            layoutParams.matchConstraintPercentHeight = layout.heightPercent;
            layoutParams.orientation = layout.orientation;
            layoutParams.guidePercent = layout.guidePercent;
            layoutParams.guideBegin = layout.guideBegin;
            layoutParams.guideEnd = layout.guideEnd;
            ((ViewGroup.MarginLayoutParams) layoutParams).width = layout.mWidth;
            ((ViewGroup.MarginLayoutParams) layoutParams).height = layout.mHeight;
            String str = layout.mConstraintTag;
            if (str != null) {
                layoutParams.constraintTag = str;
            }
            layoutParams.wrapBehaviorInParent = layout.mWrapBehavior;
            layoutParams.setMarginStart(layout.startMargin);
            layoutParams.setMarginEnd(this.layout.endMargin);
            layoutParams.validate();
        }

        public void printDelta(String str) {
            Delta delta = this.mDelta;
            if (delta != null) {
                delta.printDelta(str);
            } else {
                Log.v(str, "DELTA IS NULL");
            }
        }

        /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
        public Constraint m32clone() {
            Constraint constraint = new Constraint();
            constraint.layout.copyFrom(this.layout);
            constraint.motion.copyFrom(this.motion);
            constraint.propertySet.copyFrom(this.propertySet);
            constraint.transform.copyFrom(this.transform);
            constraint.mViewId = this.mViewId;
            constraint.mDelta = this.mDelta;
            return constraint;
        }

        public static class Delta {
            private static final int INITIAL_BOOLEAN = 4;
            private static final int INITIAL_FLOAT = 10;
            private static final int INITIAL_INT = 10;
            private static final int INITIAL_STRING = 5;
            int[] mTypeInt = new int[10];
            int[] mValueInt = new int[10];
            int mCountInt = 0;
            int[] mTypeFloat = new int[10];
            float[] mValueFloat = new float[10];
            int mCountFloat = 0;
            int[] mTypeString = new int[5];
            String[] mValueString = new String[5];
            int mCountString = 0;
            int[] mTypeBoolean = new int[4];
            boolean[] mValueBoolean = new boolean[4];
            int mCountBoolean = 0;

            public void add(int i8, int i9) {
                int i10 = this.mCountInt;
                int[] iArr = this.mTypeInt;
                if (i10 >= iArr.length) {
                    this.mTypeInt = Arrays.copyOf(iArr, iArr.length * 2);
                    int[] iArr2 = this.mValueInt;
                    this.mValueInt = Arrays.copyOf(iArr2, iArr2.length * 2);
                }
                int[] iArr3 = this.mTypeInt;
                int i11 = this.mCountInt;
                iArr3[i11] = i8;
                int[] iArr4 = this.mValueInt;
                this.mCountInt = i11 + 1;
                iArr4[i11] = i9;
            }

            public void applyDelta(Constraint constraint) {
                for (int i8 = 0; i8 < this.mCountInt; i8++) {
                    ConstraintSet.setDeltaValue(constraint, this.mTypeInt[i8], this.mValueInt[i8]);
                }
                for (int i9 = 0; i9 < this.mCountFloat; i9++) {
                    ConstraintSet.setDeltaValue(constraint, this.mTypeFloat[i9], this.mValueFloat[i9]);
                }
                for (int i10 = 0; i10 < this.mCountString; i10++) {
                    ConstraintSet.setDeltaValue(constraint, this.mTypeString[i10], this.mValueString[i10]);
                }
                for (int i11 = 0; i11 < this.mCountBoolean; i11++) {
                    ConstraintSet.setDeltaValue(constraint, this.mTypeBoolean[i11], this.mValueBoolean[i11]);
                }
            }

            public void printDelta(String str) {
                Log.v(str, "int");
                for (int i8 = 0; i8 < this.mCountInt; i8++) {
                    Log.v(str, this.mTypeInt[i8] + " = " + this.mValueInt[i8]);
                }
                Log.v(str, TypedValues.Custom.S_FLOAT);
                for (int i9 = 0; i9 < this.mCountFloat; i9++) {
                    Log.v(str, this.mTypeFloat[i9] + " = " + this.mValueFloat[i9]);
                }
                Log.v(str, "strings");
                for (int i10 = 0; i10 < this.mCountString; i10++) {
                    Log.v(str, this.mTypeString[i10] + " = " + this.mValueString[i10]);
                }
                Log.v(str, TypedValues.Custom.S_BOOLEAN);
                for (int i11 = 0; i11 < this.mCountBoolean; i11++) {
                    Log.v(str, this.mTypeBoolean[i11] + " = " + this.mValueBoolean[i11]);
                }
            }

            public void add(int i8, float f) {
                int i9 = this.mCountFloat;
                int[] iArr = this.mTypeFloat;
                if (i9 >= iArr.length) {
                    this.mTypeFloat = Arrays.copyOf(iArr, iArr.length * 2);
                    float[] fArr = this.mValueFloat;
                    this.mValueFloat = Arrays.copyOf(fArr, fArr.length * 2);
                }
                int[] iArr2 = this.mTypeFloat;
                int i10 = this.mCountFloat;
                iArr2[i10] = i8;
                float[] fArr2 = this.mValueFloat;
                this.mCountFloat = i10 + 1;
                fArr2[i10] = f;
            }

            public void add(int i8, String str) {
                int i9 = this.mCountString;
                int[] iArr = this.mTypeString;
                if (i9 >= iArr.length) {
                    this.mTypeString = Arrays.copyOf(iArr, iArr.length * 2);
                    String[] strArr = this.mValueString;
                    this.mValueString = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                }
                int[] iArr2 = this.mTypeString;
                int i10 = this.mCountString;
                iArr2[i10] = i8;
                String[] strArr2 = this.mValueString;
                this.mCountString = i10 + 1;
                strArr2[i10] = str;
            }

            public void add(int i8, boolean z2) {
                int i9 = this.mCountBoolean;
                int[] iArr = this.mTypeBoolean;
                if (i9 >= iArr.length) {
                    this.mTypeBoolean = Arrays.copyOf(iArr, iArr.length * 2);
                    boolean[] zArr = this.mValueBoolean;
                    this.mValueBoolean = Arrays.copyOf(zArr, zArr.length * 2);
                }
                int[] iArr2 = this.mTypeBoolean;
                int i10 = this.mCountBoolean;
                iArr2[i10] = i8;
                boolean[] zArr2 = this.mValueBoolean;
                this.mCountBoolean = i10 + 1;
                zArr2[i10] = z2;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void fillFromConstraints(int i8, Constraints.LayoutParams layoutParams) {
            fillFrom(i8, layoutParams);
            this.propertySet.alpha = layoutParams.alpha;
            Transform transform = this.transform;
            transform.rotation = layoutParams.rotation;
            transform.rotationX = layoutParams.rotationX;
            transform.rotationY = layoutParams.rotationY;
            transform.scaleX = layoutParams.scaleX;
            transform.scaleY = layoutParams.scaleY;
            transform.transformPivotX = layoutParams.transformPivotX;
            transform.transformPivotY = layoutParams.transformPivotY;
            transform.translationX = layoutParams.translationX;
            transform.translationY = layoutParams.translationY;
            transform.translationZ = layoutParams.translationZ;
            transform.elevation = layoutParams.elevation;
            transform.applyElevation = layoutParams.applyElevation;
        }
    }

    public static class Layout {
        private static final int BARRIER_ALLOWS_GONE_WIDGETS = 75;
        private static final int BARRIER_DIRECTION = 72;
        private static final int BARRIER_MARGIN = 73;
        private static final int BASELINE_MARGIN = 80;
        private static final int BASELINE_TO_BASELINE = 1;
        private static final int BASELINE_TO_BOTTOM = 78;
        private static final int BASELINE_TO_TOP = 77;
        private static final int BOTTOM_MARGIN = 2;
        private static final int BOTTOM_TO_BOTTOM = 3;
        private static final int BOTTOM_TO_TOP = 4;
        private static final int CHAIN_USE_RTL = 71;
        private static final int CIRCLE = 61;
        private static final int CIRCLE_ANGLE = 63;
        private static final int CIRCLE_RADIUS = 62;
        private static final int CONSTRAINED_HEIGHT = 88;
        private static final int CONSTRAINED_WIDTH = 87;
        private static final int CONSTRAINT_REFERENCED_IDS = 74;
        private static final int CONSTRAINT_TAG = 89;
        private static final int DIMENSION_RATIO = 5;
        private static final int EDITOR_ABSOLUTE_X = 6;
        private static final int EDITOR_ABSOLUTE_Y = 7;
        private static final int END_MARGIN = 8;
        private static final int END_TO_END = 9;
        private static final int END_TO_START = 10;
        private static final int GONE_BASELINE_MARGIN = 79;
        private static final int GONE_BOTTOM_MARGIN = 11;
        private static final int GONE_END_MARGIN = 12;
        private static final int GONE_LEFT_MARGIN = 13;
        private static final int GONE_RIGHT_MARGIN = 14;
        private static final int GONE_START_MARGIN = 15;
        private static final int GONE_TOP_MARGIN = 16;
        private static final int GUIDE_BEGIN = 17;
        private static final int GUIDE_END = 18;
        private static final int GUIDE_PERCENT = 19;
        private static final int GUIDE_USE_RTL = 90;
        private static final int HEIGHT_DEFAULT = 82;
        private static final int HEIGHT_MAX = 83;
        private static final int HEIGHT_MIN = 85;
        private static final int HEIGHT_PERCENT = 70;
        private static final int HORIZONTAL_BIAS = 20;
        private static final int HORIZONTAL_STYLE = 39;
        private static final int HORIZONTAL_WEIGHT = 37;
        private static final int LAYOUT_CONSTRAINT_HEIGHT = 42;
        private static final int LAYOUT_CONSTRAINT_WIDTH = 41;
        private static final int LAYOUT_HEIGHT = 21;
        private static final int LAYOUT_WIDTH = 22;
        private static final int LAYOUT_WRAP_BEHAVIOR = 76;
        private static final int LEFT_MARGIN = 23;
        private static final int LEFT_TO_LEFT = 24;
        private static final int LEFT_TO_RIGHT = 25;
        private static final int ORIENTATION = 26;
        private static final int RIGHT_MARGIN = 27;
        private static final int RIGHT_TO_LEFT = 28;
        private static final int RIGHT_TO_RIGHT = 29;
        private static final int START_MARGIN = 30;
        private static final int START_TO_END = 31;
        private static final int START_TO_START = 32;
        private static final int TOP_MARGIN = 33;
        private static final int TOP_TO_BOTTOM = 34;
        private static final int TOP_TO_TOP = 35;
        public static final int UNSET = -1;
        public static final int UNSET_GONE_MARGIN = Integer.MIN_VALUE;
        private static final int UNUSED = 91;
        private static final int VERTICAL_BIAS = 36;
        private static final int VERTICAL_STYLE = 40;
        private static final int VERTICAL_WEIGHT = 38;
        private static final int WIDTH_DEFAULT = 81;
        private static final int WIDTH_MAX = 84;
        private static final int WIDTH_MIN = 86;
        private static final int WIDTH_PERCENT = 69;
        private static SparseIntArray mapToConstant;
        public String mConstraintTag;
        public int mHeight;
        public String mReferenceIdString;
        public int[] mReferenceIds;
        public int mWidth;
        public boolean mIsGuideline = false;
        public boolean mApply = false;
        public boolean mOverride = false;
        public int guideBegin = -1;
        public int guideEnd = -1;
        public float guidePercent = -1.0f;
        public boolean guidelineUseRtl = true;
        public int leftToLeft = -1;
        public int leftToRight = -1;
        public int rightToLeft = -1;
        public int rightToRight = -1;
        public int topToTop = -1;
        public int topToBottom = -1;
        public int bottomToTop = -1;
        public int bottomToBottom = -1;
        public int baselineToBaseline = -1;
        public int baselineToTop = -1;
        public int baselineToBottom = -1;
        public int startToEnd = -1;
        public int startToStart = -1;
        public int endToStart = -1;
        public int endToEnd = -1;
        public float horizontalBias = 0.5f;
        public float verticalBias = 0.5f;
        public String dimensionRatio = null;
        public int circleConstraint = -1;
        public int circleRadius = 0;
        public float circleAngle = 0.0f;
        public int editorAbsoluteX = -1;
        public int editorAbsoluteY = -1;
        public int orientation = -1;
        public int leftMargin = 0;
        public int rightMargin = 0;
        public int topMargin = 0;
        public int bottomMargin = 0;
        public int endMargin = 0;
        public int startMargin = 0;
        public int baselineMargin = 0;
        public int goneLeftMargin = Integer.MIN_VALUE;
        public int goneTopMargin = Integer.MIN_VALUE;
        public int goneRightMargin = Integer.MIN_VALUE;
        public int goneBottomMargin = Integer.MIN_VALUE;
        public int goneEndMargin = Integer.MIN_VALUE;
        public int goneStartMargin = Integer.MIN_VALUE;
        public int goneBaselineMargin = Integer.MIN_VALUE;
        public float verticalWeight = -1.0f;
        public float horizontalWeight = -1.0f;
        public int horizontalChainStyle = 0;
        public int verticalChainStyle = 0;
        public int widthDefault = 0;
        public int heightDefault = 0;
        public int widthMax = 0;
        public int heightMax = 0;
        public int widthMin = 0;
        public int heightMin = 0;
        public float widthPercent = 1.0f;
        public float heightPercent = 1.0f;
        public int mBarrierDirection = -1;
        public int mBarrierMargin = 0;
        public int mHelperType = -1;
        public boolean constrainedWidth = false;
        public boolean constrainedHeight = false;
        public boolean mBarrierAllowsGoneWidgets = true;
        public int mWrapBehavior = 0;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            mapToConstant = sparseIntArray;
            sparseIntArray.append(R.styleable.Layout_layout_constraintLeft_toLeftOf, 24);
            mapToConstant.append(R.styleable.Layout_layout_constraintLeft_toRightOf, 25);
            mapToConstant.append(R.styleable.Layout_layout_constraintRight_toLeftOf, 28);
            mapToConstant.append(R.styleable.Layout_layout_constraintRight_toRightOf, 29);
            mapToConstant.append(R.styleable.Layout_layout_constraintTop_toTopOf, 35);
            mapToConstant.append(R.styleable.Layout_layout_constraintTop_toBottomOf, 34);
            mapToConstant.append(R.styleable.Layout_layout_constraintBottom_toTopOf, 4);
            mapToConstant.append(R.styleable.Layout_layout_constraintBottom_toBottomOf, 3);
            mapToConstant.append(R.styleable.Layout_layout_constraintBaseline_toBaselineOf, 1);
            mapToConstant.append(R.styleable.Layout_layout_editor_absoluteX, 6);
            mapToConstant.append(R.styleable.Layout_layout_editor_absoluteY, 7);
            mapToConstant.append(R.styleable.Layout_layout_constraintGuide_begin, 17);
            mapToConstant.append(R.styleable.Layout_layout_constraintGuide_end, 18);
            mapToConstant.append(R.styleable.Layout_layout_constraintGuide_percent, 19);
            mapToConstant.append(R.styleable.Layout_guidelineUseRtl, GUIDE_USE_RTL);
            mapToConstant.append(R.styleable.Layout_android_orientation, 26);
            mapToConstant.append(R.styleable.Layout_layout_constraintStart_toEndOf, 31);
            mapToConstant.append(R.styleable.Layout_layout_constraintStart_toStartOf, 32);
            mapToConstant.append(R.styleable.Layout_layout_constraintEnd_toStartOf, 10);
            mapToConstant.append(R.styleable.Layout_layout_constraintEnd_toEndOf, 9);
            mapToConstant.append(R.styleable.Layout_layout_goneMarginLeft, 13);
            mapToConstant.append(R.styleable.Layout_layout_goneMarginTop, 16);
            mapToConstant.append(R.styleable.Layout_layout_goneMarginRight, 14);
            mapToConstant.append(R.styleable.Layout_layout_goneMarginBottom, 11);
            mapToConstant.append(R.styleable.Layout_layout_goneMarginStart, 15);
            mapToConstant.append(R.styleable.Layout_layout_goneMarginEnd, 12);
            mapToConstant.append(R.styleable.Layout_layout_constraintVertical_weight, 38);
            mapToConstant.append(R.styleable.Layout_layout_constraintHorizontal_weight, 37);
            mapToConstant.append(R.styleable.Layout_layout_constraintHorizontal_chainStyle, 39);
            mapToConstant.append(R.styleable.Layout_layout_constraintVertical_chainStyle, 40);
            mapToConstant.append(R.styleable.Layout_layout_constraintHorizontal_bias, 20);
            mapToConstant.append(R.styleable.Layout_layout_constraintVertical_bias, 36);
            mapToConstant.append(R.styleable.Layout_layout_constraintDimensionRatio, 5);
            mapToConstant.append(R.styleable.Layout_layout_constraintLeft_creator, UNUSED);
            mapToConstant.append(R.styleable.Layout_layout_constraintTop_creator, UNUSED);
            mapToConstant.append(R.styleable.Layout_layout_constraintRight_creator, UNUSED);
            mapToConstant.append(R.styleable.Layout_layout_constraintBottom_creator, UNUSED);
            mapToConstant.append(R.styleable.Layout_layout_constraintBaseline_creator, UNUSED);
            mapToConstant.append(R.styleable.Layout_android_layout_marginLeft, 23);
            mapToConstant.append(R.styleable.Layout_android_layout_marginRight, 27);
            mapToConstant.append(R.styleable.Layout_android_layout_marginStart, 30);
            mapToConstant.append(R.styleable.Layout_android_layout_marginEnd, 8);
            mapToConstant.append(R.styleable.Layout_android_layout_marginTop, 33);
            mapToConstant.append(R.styleable.Layout_android_layout_marginBottom, 2);
            mapToConstant.append(R.styleable.Layout_android_layout_width, 22);
            mapToConstant.append(R.styleable.Layout_android_layout_height, 21);
            mapToConstant.append(R.styleable.Layout_layout_constraintWidth, 41);
            mapToConstant.append(R.styleable.Layout_layout_constraintHeight, 42);
            mapToConstant.append(R.styleable.Layout_layout_constrainedWidth, 41);
            mapToConstant.append(R.styleable.Layout_layout_constrainedHeight, 42);
            mapToConstant.append(R.styleable.Layout_layout_wrapBehaviorInParent, 76);
            mapToConstant.append(R.styleable.Layout_layout_constraintCircle, CIRCLE);
            mapToConstant.append(R.styleable.Layout_layout_constraintCircleRadius, CIRCLE_RADIUS);
            mapToConstant.append(R.styleable.Layout_layout_constraintCircleAngle, 63);
            mapToConstant.append(R.styleable.Layout_layout_constraintWidth_percent, WIDTH_PERCENT);
            mapToConstant.append(R.styleable.Layout_layout_constraintHeight_percent, HEIGHT_PERCENT);
            mapToConstant.append(R.styleable.Layout_chainUseRtl, CHAIN_USE_RTL);
            mapToConstant.append(R.styleable.Layout_barrierDirection, BARRIER_DIRECTION);
            mapToConstant.append(R.styleable.Layout_barrierMargin, BARRIER_MARGIN);
            mapToConstant.append(R.styleable.Layout_constraint_referenced_ids, CONSTRAINT_REFERENCED_IDS);
            mapToConstant.append(R.styleable.Layout_barrierAllowsGoneWidgets, BARRIER_ALLOWS_GONE_WIDGETS);
        }

        public void copyFrom(Layout layout) {
            this.mIsGuideline = layout.mIsGuideline;
            this.mWidth = layout.mWidth;
            this.mApply = layout.mApply;
            this.mHeight = layout.mHeight;
            this.guideBegin = layout.guideBegin;
            this.guideEnd = layout.guideEnd;
            this.guidePercent = layout.guidePercent;
            this.guidelineUseRtl = layout.guidelineUseRtl;
            this.leftToLeft = layout.leftToLeft;
            this.leftToRight = layout.leftToRight;
            this.rightToLeft = layout.rightToLeft;
            this.rightToRight = layout.rightToRight;
            this.topToTop = layout.topToTop;
            this.topToBottom = layout.topToBottom;
            this.bottomToTop = layout.bottomToTop;
            this.bottomToBottom = layout.bottomToBottom;
            this.baselineToBaseline = layout.baselineToBaseline;
            this.baselineToTop = layout.baselineToTop;
            this.baselineToBottom = layout.baselineToBottom;
            this.startToEnd = layout.startToEnd;
            this.startToStart = layout.startToStart;
            this.endToStart = layout.endToStart;
            this.endToEnd = layout.endToEnd;
            this.horizontalBias = layout.horizontalBias;
            this.verticalBias = layout.verticalBias;
            this.dimensionRatio = layout.dimensionRatio;
            this.circleConstraint = layout.circleConstraint;
            this.circleRadius = layout.circleRadius;
            this.circleAngle = layout.circleAngle;
            this.editorAbsoluteX = layout.editorAbsoluteX;
            this.editorAbsoluteY = layout.editorAbsoluteY;
            this.orientation = layout.orientation;
            this.leftMargin = layout.leftMargin;
            this.rightMargin = layout.rightMargin;
            this.topMargin = layout.topMargin;
            this.bottomMargin = layout.bottomMargin;
            this.endMargin = layout.endMargin;
            this.startMargin = layout.startMargin;
            this.baselineMargin = layout.baselineMargin;
            this.goneLeftMargin = layout.goneLeftMargin;
            this.goneTopMargin = layout.goneTopMargin;
            this.goneRightMargin = layout.goneRightMargin;
            this.goneBottomMargin = layout.goneBottomMargin;
            this.goneEndMargin = layout.goneEndMargin;
            this.goneStartMargin = layout.goneStartMargin;
            this.goneBaselineMargin = layout.goneBaselineMargin;
            this.verticalWeight = layout.verticalWeight;
            this.horizontalWeight = layout.horizontalWeight;
            this.horizontalChainStyle = layout.horizontalChainStyle;
            this.verticalChainStyle = layout.verticalChainStyle;
            this.widthDefault = layout.widthDefault;
            this.heightDefault = layout.heightDefault;
            this.widthMax = layout.widthMax;
            this.heightMax = layout.heightMax;
            this.widthMin = layout.widthMin;
            this.heightMin = layout.heightMin;
            this.widthPercent = layout.widthPercent;
            this.heightPercent = layout.heightPercent;
            this.mBarrierDirection = layout.mBarrierDirection;
            this.mBarrierMargin = layout.mBarrierMargin;
            this.mHelperType = layout.mHelperType;
            this.mConstraintTag = layout.mConstraintTag;
            int[] iArr = layout.mReferenceIds;
            if (iArr == null || layout.mReferenceIdString != null) {
                this.mReferenceIds = null;
            } else {
                this.mReferenceIds = Arrays.copyOf(iArr, iArr.length);
            }
            this.mReferenceIdString = layout.mReferenceIdString;
            this.constrainedWidth = layout.constrainedWidth;
            this.constrainedHeight = layout.constrainedHeight;
            this.mBarrierAllowsGoneWidgets = layout.mBarrierAllowsGoneWidgets;
            this.mWrapBehavior = layout.mWrapBehavior;
        }

        public void dump(MotionScene motionScene, StringBuilder sb2) {
            Field[] declaredFields = getClass().getDeclaredFields();
            sb2.append("\n");
            for (Field field : declaredFields) {
                String name = field.getName();
                if (!Modifier.isStatic(field.getModifiers())) {
                    try {
                        Object obj = field.get(this);
                        Class<?> type = field.getType();
                        if (type == Integer.TYPE) {
                            Integer num = (Integer) obj;
                            if (num.intValue() != -1) {
                                Object objLookUpConstraintName = motionScene.lookUpConstraintName(num.intValue());
                                sb2.append("    ");
                                sb2.append(name);
                                sb2.append(" = \"");
                                sb2.append(objLookUpConstraintName == null ? num : objLookUpConstraintName);
                                sb2.append("\"\n");
                            }
                        } else if (type == Float.TYPE) {
                            Float f = (Float) obj;
                            if (f.floatValue() != -1.0f) {
                                sb2.append("    ");
                                sb2.append(name);
                                sb2.append(" = \"");
                                sb2.append(f);
                                sb2.append("\"\n");
                            }
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public void fillFromAttributeList(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Layout);
            this.mApply = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i8 = 0; i8 < indexCount; i8++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i8);
                int i9 = mapToConstant.get(index);
                switch (i9) {
                    case 1:
                        this.baselineToBaseline = ConstraintSet.lookupID(typedArrayObtainStyledAttributes, index, this.baselineToBaseline);
                        break;
                    case 2:
                        this.bottomMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.bottomMargin);
                        break;
                    case 3:
                        this.bottomToBottom = ConstraintSet.lookupID(typedArrayObtainStyledAttributes, index, this.bottomToBottom);
                        break;
                    case 4:
                        this.bottomToTop = ConstraintSet.lookupID(typedArrayObtainStyledAttributes, index, this.bottomToTop);
                        break;
                    case 5:
                        this.dimensionRatio = typedArrayObtainStyledAttributes.getString(index);
                        break;
                    case 6:
                        this.editorAbsoluteX = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.editorAbsoluteX);
                        break;
                    case 7:
                        this.editorAbsoluteY = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.editorAbsoluteY);
                        break;
                    case 8:
                        this.endMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.endMargin);
                        break;
                    case 9:
                        this.endToEnd = ConstraintSet.lookupID(typedArrayObtainStyledAttributes, index, this.endToEnd);
                        break;
                    case 10:
                        this.endToStart = ConstraintSet.lookupID(typedArrayObtainStyledAttributes, index, this.endToStart);
                        break;
                    case 11:
                        this.goneBottomMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.goneBottomMargin);
                        break;
                    case 12:
                        this.goneEndMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.goneEndMargin);
                        break;
                    case 13:
                        this.goneLeftMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.goneLeftMargin);
                        break;
                    case 14:
                        this.goneRightMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.goneRightMargin);
                        break;
                    case 15:
                        this.goneStartMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.goneStartMargin);
                        break;
                    case 16:
                        this.goneTopMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.goneTopMargin);
                        break;
                    case 17:
                        this.guideBegin = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.guideBegin);
                        break;
                    case 18:
                        this.guideEnd = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.guideEnd);
                        break;
                    case 19:
                        this.guidePercent = typedArrayObtainStyledAttributes.getFloat(index, this.guidePercent);
                        break;
                    case 20:
                        this.horizontalBias = typedArrayObtainStyledAttributes.getFloat(index, this.horizontalBias);
                        break;
                    case 21:
                        this.mHeight = typedArrayObtainStyledAttributes.getLayoutDimension(index, this.mHeight);
                        break;
                    case 22:
                        this.mWidth = typedArrayObtainStyledAttributes.getLayoutDimension(index, this.mWidth);
                        break;
                    case 23:
                        this.leftMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.leftMargin);
                        break;
                    case 24:
                        this.leftToLeft = ConstraintSet.lookupID(typedArrayObtainStyledAttributes, index, this.leftToLeft);
                        break;
                    case 25:
                        this.leftToRight = ConstraintSet.lookupID(typedArrayObtainStyledAttributes, index, this.leftToRight);
                        break;
                    case 26:
                        this.orientation = typedArrayObtainStyledAttributes.getInt(index, this.orientation);
                        break;
                    case 27:
                        this.rightMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.rightMargin);
                        break;
                    case 28:
                        this.rightToLeft = ConstraintSet.lookupID(typedArrayObtainStyledAttributes, index, this.rightToLeft);
                        break;
                    case 29:
                        this.rightToRight = ConstraintSet.lookupID(typedArrayObtainStyledAttributes, index, this.rightToRight);
                        break;
                    case 30:
                        this.startMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.startMargin);
                        break;
                    case 31:
                        this.startToEnd = ConstraintSet.lookupID(typedArrayObtainStyledAttributes, index, this.startToEnd);
                        break;
                    case 32:
                        this.startToStart = ConstraintSet.lookupID(typedArrayObtainStyledAttributes, index, this.startToStart);
                        break;
                    case 33:
                        this.topMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.topMargin);
                        break;
                    case 34:
                        this.topToBottom = ConstraintSet.lookupID(typedArrayObtainStyledAttributes, index, this.topToBottom);
                        break;
                    case 35:
                        this.topToTop = ConstraintSet.lookupID(typedArrayObtainStyledAttributes, index, this.topToTop);
                        break;
                    case 36:
                        this.verticalBias = typedArrayObtainStyledAttributes.getFloat(index, this.verticalBias);
                        break;
                    case 37:
                        this.horizontalWeight = typedArrayObtainStyledAttributes.getFloat(index, this.horizontalWeight);
                        break;
                    case 38:
                        this.verticalWeight = typedArrayObtainStyledAttributes.getFloat(index, this.verticalWeight);
                        break;
                    case 39:
                        this.horizontalChainStyle = typedArrayObtainStyledAttributes.getInt(index, this.horizontalChainStyle);
                        break;
                    case 40:
                        this.verticalChainStyle = typedArrayObtainStyledAttributes.getInt(index, this.verticalChainStyle);
                        break;
                    case 41:
                        ConstraintSet.parseDimensionConstraints(this, typedArrayObtainStyledAttributes, index, 0);
                        break;
                    case 42:
                        ConstraintSet.parseDimensionConstraints(this, typedArrayObtainStyledAttributes, index, 1);
                        break;
                    default:
                        switch (i9) {
                            case CIRCLE /* 61 */:
                                this.circleConstraint = ConstraintSet.lookupID(typedArrayObtainStyledAttributes, index, this.circleConstraint);
                                break;
                            case CIRCLE_RADIUS /* 62 */:
                                this.circleRadius = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.circleRadius);
                                break;
                            case 63:
                                this.circleAngle = typedArrayObtainStyledAttributes.getFloat(index, this.circleAngle);
                                break;
                            default:
                                switch (i9) {
                                    case WIDTH_PERCENT /* 69 */:
                                        this.widthPercent = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                                        break;
                                    case HEIGHT_PERCENT /* 70 */:
                                        this.heightPercent = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                                        break;
                                    case CHAIN_USE_RTL /* 71 */:
                                        Log.e(ConstraintSet.TAG, "CURRENTLY UNSUPPORTED");
                                        break;
                                    case BARRIER_DIRECTION /* 72 */:
                                        this.mBarrierDirection = typedArrayObtainStyledAttributes.getInt(index, this.mBarrierDirection);
                                        break;
                                    case BARRIER_MARGIN /* 73 */:
                                        this.mBarrierMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.mBarrierMargin);
                                        break;
                                    case CONSTRAINT_REFERENCED_IDS /* 74 */:
                                        this.mReferenceIdString = typedArrayObtainStyledAttributes.getString(index);
                                        break;
                                    case BARRIER_ALLOWS_GONE_WIDGETS /* 75 */:
                                        this.mBarrierAllowsGoneWidgets = typedArrayObtainStyledAttributes.getBoolean(index, this.mBarrierAllowsGoneWidgets);
                                        break;
                                    case 76:
                                        this.mWrapBehavior = typedArrayObtainStyledAttributes.getInt(index, this.mWrapBehavior);
                                        break;
                                    case BASELINE_TO_TOP /* 77 */:
                                        this.baselineToTop = ConstraintSet.lookupID(typedArrayObtainStyledAttributes, index, this.baselineToTop);
                                        break;
                                    case BASELINE_TO_BOTTOM /* 78 */:
                                        this.baselineToBottom = ConstraintSet.lookupID(typedArrayObtainStyledAttributes, index, this.baselineToBottom);
                                        break;
                                    case GONE_BASELINE_MARGIN /* 79 */:
                                        this.goneBaselineMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.goneBaselineMargin);
                                        break;
                                    case BASELINE_MARGIN /* 80 */:
                                        this.baselineMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.baselineMargin);
                                        break;
                                    case WIDTH_DEFAULT /* 81 */:
                                        this.widthDefault = typedArrayObtainStyledAttributes.getInt(index, this.widthDefault);
                                        break;
                                    case HEIGHT_DEFAULT /* 82 */:
                                        this.heightDefault = typedArrayObtainStyledAttributes.getInt(index, this.heightDefault);
                                        break;
                                    case HEIGHT_MAX /* 83 */:
                                        this.heightMax = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.heightMax);
                                        break;
                                    case WIDTH_MAX /* 84 */:
                                        this.widthMax = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.widthMax);
                                        break;
                                    case HEIGHT_MIN /* 85 */:
                                        this.heightMin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.heightMin);
                                        break;
                                    case WIDTH_MIN /* 86 */:
                                        this.widthMin = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.widthMin);
                                        break;
                                    case CONSTRAINED_WIDTH /* 87 */:
                                        this.constrainedWidth = typedArrayObtainStyledAttributes.getBoolean(index, this.constrainedWidth);
                                        break;
                                    case CONSTRAINED_HEIGHT /* 88 */:
                                        this.constrainedHeight = typedArrayObtainStyledAttributes.getBoolean(index, this.constrainedHeight);
                                        break;
                                    case CONSTRAINT_TAG /* 89 */:
                                        this.mConstraintTag = typedArrayObtainStyledAttributes.getString(index);
                                        break;
                                    case GUIDE_USE_RTL /* 90 */:
                                        this.guidelineUseRtl = typedArrayObtainStyledAttributes.getBoolean(index, this.guidelineUseRtl);
                                        break;
                                    case UNUSED /* 91 */:
                                        Log.w(ConstraintSet.TAG, "unused attribute 0x" + Integer.toHexString(index) + "   " + mapToConstant.get(index));
                                        break;
                                    default:
                                        Log.w(ConstraintSet.TAG, "Unknown attribute 0x" + Integer.toHexString(index) + "   " + mapToConstant.get(index));
                                        break;
                                }
                                break;
                        }
                        break;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static class Motion {
        private static final int ANIMATE_CIRCLE_ANGLE_TO = 6;
        private static final int ANIMATE_RELATIVE_TO = 5;
        private static final int INTERPOLATOR_REFERENCE_ID = -2;
        private static final int INTERPOLATOR_UNDEFINED = -3;
        private static final int MOTION_DRAW_PATH = 4;
        private static final int MOTION_STAGGER = 7;
        private static final int PATH_MOTION_ARC = 2;
        private static final int QUANTIZE_MOTION_INTERPOLATOR = 10;
        private static final int QUANTIZE_MOTION_PHASE = 9;
        private static final int QUANTIZE_MOTION_STEPS = 8;
        private static final int SPLINE_STRING = -1;
        private static final int TRANSITION_EASING = 3;
        private static final int TRANSITION_PATH_ROTATE = 1;
        private static SparseIntArray mapToConstant;
        public boolean mApply = false;
        public int mAnimateRelativeTo = -1;
        public int mAnimateCircleAngleTo = 0;
        public String mTransitionEasing = null;
        public int mPathMotionArc = -1;
        public int mDrawPath = 0;
        public float mMotionStagger = Float.NaN;
        public int mPolarRelativeTo = -1;
        public float mPathRotate = Float.NaN;
        public float mQuantizeMotionPhase = Float.NaN;
        public int mQuantizeMotionSteps = -1;
        public String mQuantizeInterpolatorString = null;
        public int mQuantizeInterpolatorType = -3;
        public int mQuantizeInterpolatorID = -1;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            mapToConstant = sparseIntArray;
            sparseIntArray.append(R.styleable.Motion_motionPathRotate, 1);
            mapToConstant.append(R.styleable.Motion_pathMotionArc, 2);
            mapToConstant.append(R.styleable.Motion_transitionEasing, 3);
            mapToConstant.append(R.styleable.Motion_drawPath, 4);
            mapToConstant.append(R.styleable.Motion_animateRelativeTo, 5);
            mapToConstant.append(R.styleable.Motion_animateCircleAngleTo, 6);
            mapToConstant.append(R.styleable.Motion_motionStagger, 7);
            mapToConstant.append(R.styleable.Motion_quantizeMotionSteps, 8);
            mapToConstant.append(R.styleable.Motion_quantizeMotionPhase, 9);
            mapToConstant.append(R.styleable.Motion_quantizeMotionInterpolator, 10);
        }

        public void copyFrom(Motion motion) {
            this.mApply = motion.mApply;
            this.mAnimateRelativeTo = motion.mAnimateRelativeTo;
            this.mTransitionEasing = motion.mTransitionEasing;
            this.mPathMotionArc = motion.mPathMotionArc;
            this.mDrawPath = motion.mDrawPath;
            this.mPathRotate = motion.mPathRotate;
            this.mMotionStagger = motion.mMotionStagger;
            this.mPolarRelativeTo = motion.mPolarRelativeTo;
        }

        public void fillFromAttributeList(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Motion);
            this.mApply = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i8 = 0; i8 < indexCount; i8++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i8);
                switch (mapToConstant.get(index)) {
                    case 1:
                        this.mPathRotate = typedArrayObtainStyledAttributes.getFloat(index, this.mPathRotate);
                        break;
                    case 2:
                        this.mPathMotionArc = typedArrayObtainStyledAttributes.getInt(index, this.mPathMotionArc);
                        break;
                    case 3:
                        if (typedArrayObtainStyledAttributes.peekValue(index).type == 3) {
                            this.mTransitionEasing = typedArrayObtainStyledAttributes.getString(index);
                        } else {
                            this.mTransitionEasing = Easing.NAMED_EASING[typedArrayObtainStyledAttributes.getInteger(index, 0)];
                        }
                        break;
                    case 4:
                        this.mDrawPath = typedArrayObtainStyledAttributes.getInt(index, 0);
                        break;
                    case 5:
                        this.mAnimateRelativeTo = ConstraintSet.lookupID(typedArrayObtainStyledAttributes, index, this.mAnimateRelativeTo);
                        break;
                    case 6:
                        this.mAnimateCircleAngleTo = typedArrayObtainStyledAttributes.getInteger(index, this.mAnimateCircleAngleTo);
                        break;
                    case 7:
                        this.mMotionStagger = typedArrayObtainStyledAttributes.getFloat(index, this.mMotionStagger);
                        break;
                    case 8:
                        this.mQuantizeMotionSteps = typedArrayObtainStyledAttributes.getInteger(index, this.mQuantizeMotionSteps);
                        break;
                    case 9:
                        this.mQuantizeMotionPhase = typedArrayObtainStyledAttributes.getFloat(index, this.mQuantizeMotionPhase);
                        break;
                    case 10:
                        int i9 = typedArrayObtainStyledAttributes.peekValue(index).type;
                        if (i9 == 1) {
                            int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                            this.mQuantizeInterpolatorID = resourceId;
                            if (resourceId != -1) {
                                this.mQuantizeInterpolatorType = -2;
                            }
                        } else if (i9 == 3) {
                            String string = typedArrayObtainStyledAttributes.getString(index);
                            this.mQuantizeInterpolatorString = string;
                            if (string.indexOf("/") > 0) {
                                this.mQuantizeInterpolatorID = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                                this.mQuantizeInterpolatorType = -2;
                            } else {
                                this.mQuantizeInterpolatorType = -1;
                            }
                        } else {
                            this.mQuantizeInterpolatorType = typedArrayObtainStyledAttributes.getInteger(index, this.mQuantizeInterpolatorID);
                        }
                        break;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static class PropertySet {
        public boolean mApply = false;
        public int visibility = 0;
        public int mVisibilityMode = 0;
        public float alpha = 1.0f;
        public float mProgress = Float.NaN;

        public void copyFrom(PropertySet propertySet) {
            this.mApply = propertySet.mApply;
            this.visibility = propertySet.visibility;
            this.alpha = propertySet.alpha;
            this.mProgress = propertySet.mProgress;
            this.mVisibilityMode = propertySet.mVisibilityMode;
        }

        public void fillFromAttributeList(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PropertySet);
            this.mApply = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i8 = 0; i8 < indexCount; i8++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i8);
                if (index == R.styleable.PropertySet_android_alpha) {
                    this.alpha = typedArrayObtainStyledAttributes.getFloat(index, this.alpha);
                } else if (index == R.styleable.PropertySet_android_visibility) {
                    this.visibility = typedArrayObtainStyledAttributes.getInt(index, this.visibility);
                    this.visibility = ConstraintSet.VISIBILITY_FLAGS[this.visibility];
                } else if (index == R.styleable.PropertySet_visibilityMode) {
                    this.mVisibilityMode = typedArrayObtainStyledAttributes.getInt(index, this.mVisibilityMode);
                } else if (index == R.styleable.PropertySet_motionProgress) {
                    this.mProgress = typedArrayObtainStyledAttributes.getFloat(index, this.mProgress);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static class Transform {
        private static final int ELEVATION = 11;
        private static final int ROTATION = 1;
        private static final int ROTATION_X = 2;
        private static final int ROTATION_Y = 3;
        private static final int SCALE_X = 4;
        private static final int SCALE_Y = 5;
        private static final int TRANSFORM_PIVOT_TARGET = 12;
        private static final int TRANSFORM_PIVOT_X = 6;
        private static final int TRANSFORM_PIVOT_Y = 7;
        private static final int TRANSLATION_X = 8;
        private static final int TRANSLATION_Y = 9;
        private static final int TRANSLATION_Z = 10;
        private static SparseIntArray mapToConstant;
        public boolean mApply = false;
        public float rotation = 0.0f;
        public float rotationX = 0.0f;
        public float rotationY = 0.0f;
        public float scaleX = 1.0f;
        public float scaleY = 1.0f;
        public float transformPivotX = Float.NaN;
        public float transformPivotY = Float.NaN;
        public int transformPivotTarget = -1;
        public float translationX = 0.0f;
        public float translationY = 0.0f;
        public float translationZ = 0.0f;
        public boolean applyElevation = false;
        public float elevation = 0.0f;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            mapToConstant = sparseIntArray;
            sparseIntArray.append(R.styleable.Transform_android_rotation, 1);
            mapToConstant.append(R.styleable.Transform_android_rotationX, 2);
            mapToConstant.append(R.styleable.Transform_android_rotationY, 3);
            mapToConstant.append(R.styleable.Transform_android_scaleX, 4);
            mapToConstant.append(R.styleable.Transform_android_scaleY, 5);
            mapToConstant.append(R.styleable.Transform_android_transformPivotX, 6);
            mapToConstant.append(R.styleable.Transform_android_transformPivotY, 7);
            mapToConstant.append(R.styleable.Transform_android_translationX, 8);
            mapToConstant.append(R.styleable.Transform_android_translationY, 9);
            mapToConstant.append(R.styleable.Transform_android_translationZ, 10);
            mapToConstant.append(R.styleable.Transform_android_elevation, 11);
            mapToConstant.append(R.styleable.Transform_transformPivotTarget, 12);
        }

        public void copyFrom(Transform transform) {
            this.mApply = transform.mApply;
            this.rotation = transform.rotation;
            this.rotationX = transform.rotationX;
            this.rotationY = transform.rotationY;
            this.scaleX = transform.scaleX;
            this.scaleY = transform.scaleY;
            this.transformPivotX = transform.transformPivotX;
            this.transformPivotY = transform.transformPivotY;
            this.transformPivotTarget = transform.transformPivotTarget;
            this.translationX = transform.translationX;
            this.translationY = transform.translationY;
            this.translationZ = transform.translationZ;
            this.applyElevation = transform.applyElevation;
            this.elevation = transform.elevation;
        }

        public void fillFromAttributeList(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Transform);
            this.mApply = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i8 = 0; i8 < indexCount; i8++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i8);
                switch (mapToConstant.get(index)) {
                    case 1:
                        this.rotation = typedArrayObtainStyledAttributes.getFloat(index, this.rotation);
                        break;
                    case 2:
                        this.rotationX = typedArrayObtainStyledAttributes.getFloat(index, this.rotationX);
                        break;
                    case 3:
                        this.rotationY = typedArrayObtainStyledAttributes.getFloat(index, this.rotationY);
                        break;
                    case 4:
                        this.scaleX = typedArrayObtainStyledAttributes.getFloat(index, this.scaleX);
                        break;
                    case 5:
                        this.scaleY = typedArrayObtainStyledAttributes.getFloat(index, this.scaleY);
                        break;
                    case 6:
                        this.transformPivotX = typedArrayObtainStyledAttributes.getDimension(index, this.transformPivotX);
                        break;
                    case 7:
                        this.transformPivotY = typedArrayObtainStyledAttributes.getDimension(index, this.transformPivotY);
                        break;
                    case 8:
                        this.translationX = typedArrayObtainStyledAttributes.getDimension(index, this.translationX);
                        break;
                    case 9:
                        this.translationY = typedArrayObtainStyledAttributes.getDimension(index, this.translationY);
                        break;
                    case 10:
                        this.translationZ = typedArrayObtainStyledAttributes.getDimension(index, this.translationZ);
                        break;
                    case 11:
                        this.applyElevation = true;
                        this.elevation = typedArrayObtainStyledAttributes.getDimension(index, this.elevation);
                        break;
                    case 12:
                        this.transformPivotTarget = ConstraintSet.lookupID(typedArrayObtainStyledAttributes, index, this.transformPivotTarget);
                        break;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public class WriteXmlEngine {
        private static final String SPACE = "\n       ";
        Context context;
        int flags;
        ConstraintLayout layout;
        Writer writer;
        int unknownCount = 0;
        final String LEFT = "'left'";
        final String RIGHT = "'right'";
        final String BASELINE = "'baseline'";
        final String BOTTOM = "'bottom'";
        final String TOP = "'top'";
        final String START = "'start'";
        final String END = "'end'";
        HashMap<Integer, String> idMap = new HashMap<>();

        public WriteXmlEngine(Writer writer, ConstraintLayout constraintLayout, int i8) throws IOException {
            this.writer = writer;
            this.layout = constraintLayout;
            this.context = constraintLayout.getContext();
            this.flags = i8;
        }

        private void writeBaseDimension(String str, int i8, int i9) throws IOException {
            if (i8 != i9) {
                if (i8 == -2) {
                    this.writer.write(SPACE + str + "=\"wrap_content\"");
                    return;
                }
                if (i8 == -1) {
                    this.writer.write(SPACE + str + "=\"match_parent\"");
                    return;
                }
                this.writer.write(SPACE + str + "=\"" + i8 + "dp\"");
            }
        }

        private void writeBoolen(String str, boolean z2, boolean z3) throws IOException {
            if (z2 != z3) {
                this.writer.write(SPACE + str + "=\"" + z2 + "dp\"");
            }
        }

        private void writeDimension(String str, int i8, int i9) throws IOException {
            if (i8 != i9) {
                this.writer.write(SPACE + str + "=\"" + i8 + "dp\"");
            }
        }

        private void writeEnum(String str, int i8, String[] strArr, int i9) throws IOException {
            if (i8 != i9) {
                Writer writer = this.writer;
                StringBuilder sbY = a.y(SPACE, str, "=\"");
                sbY.append(strArr[i8]);
                sbY.append("\"");
                writer.write(sbY.toString());
            }
        }

        public String getName(int i8) {
            if (this.idMap.containsKey(Integer.valueOf(i8))) {
                return h0.a.n(new StringBuilder("@+id/"), this.idMap.get(Integer.valueOf(i8)), "");
            }
            if (i8 == 0) {
                return ConstraintSet.KEY_PERCENT_PARENT;
            }
            String strLookup = lookup(i8);
            this.idMap.put(Integer.valueOf(i8), strLookup);
            return "@+id/" + strLookup + "";
        }

        public String lookup(int i8) {
            try {
                if (i8 != -1) {
                    return this.context.getResources().getResourceEntryName(i8);
                }
                StringBuilder sb2 = new StringBuilder(EnvironmentCompat.MEDIA_UNKNOWN);
                int i9 = this.unknownCount + 1;
                this.unknownCount = i9;
                sb2.append(i9);
                return sb2.toString();
            } catch (Exception unused) {
                StringBuilder sb3 = new StringBuilder(EnvironmentCompat.MEDIA_UNKNOWN);
                int i10 = this.unknownCount + 1;
                this.unknownCount = i10;
                sb3.append(i10);
                return sb3.toString();
            }
        }

        public void writeCircle(int i8, float f, int i9) throws IOException {
            if (i8 == -1) {
                return;
            }
            this.writer.write("circle");
            this.writer.write(":[");
            this.writer.write(getName(i8));
            this.writer.write(", " + f);
            this.writer.write(i9 + "]");
        }

        public void writeConstraint(String str, int i8, String str2, int i9, int i10) throws IOException {
            if (i8 == -1) {
                return;
            }
            this.writer.write(SPACE + str);
            this.writer.write(":[");
            this.writer.write(getName(i8));
            this.writer.write(" , ");
            this.writer.write(str2);
            if (i9 != 0) {
                this.writer.write(" , " + i9);
            }
            this.writer.write("],\n");
        }

        public void writeLayout() throws IOException {
            this.writer.write("\n<ConstraintSet>\n");
            for (Integer num : ConstraintSet.this.mConstraints.keySet()) {
                Constraint constraint = (Constraint) ConstraintSet.this.mConstraints.get(num);
                String name = getName(num.intValue());
                this.writer.write("  <Constraint");
                this.writer.write("\n       android:id=\"" + name + "\"");
                Layout layout = constraint.layout;
                writeBaseDimension("android:layout_width", layout.mWidth, -5);
                writeBaseDimension("android:layout_height", layout.mHeight, -5);
                writeVariable("app:layout_constraintGuide_begin", layout.guideBegin, -1.0f);
                writeVariable("app:layout_constraintGuide_end", layout.guideEnd, -1.0f);
                writeVariable("app:layout_constraintGuide_percent", layout.guidePercent, -1.0f);
                writeVariable("app:layout_constraintHorizontal_bias", layout.horizontalBias, 0.5f);
                writeVariable("app:layout_constraintVertical_bias", layout.verticalBias, 0.5f);
                writeVariable("app:layout_constraintDimensionRatio", layout.dimensionRatio, (String) null);
                writeXmlConstraint("app:layout_constraintCircle", layout.circleConstraint);
                writeVariable("app:layout_constraintCircleRadius", layout.circleRadius, 0.0f);
                writeVariable("app:layout_constraintCircleAngle", layout.circleAngle, 0.0f);
                writeVariable("android:orientation", layout.orientation, -1.0f);
                writeVariable("app:layout_constraintVertical_weight", layout.verticalWeight, -1.0f);
                writeVariable("app:layout_constraintHorizontal_weight", layout.horizontalWeight, -1.0f);
                writeVariable("app:layout_constraintHorizontal_chainStyle", layout.horizontalChainStyle, 0.0f);
                writeVariable("app:layout_constraintVertical_chainStyle", layout.verticalChainStyle, 0.0f);
                writeVariable("app:barrierDirection", layout.mBarrierDirection, -1.0f);
                writeVariable("app:barrierMargin", layout.mBarrierMargin, 0.0f);
                writeDimension("app:layout_marginLeft", layout.leftMargin, 0);
                writeDimension("app:layout_goneMarginLeft", layout.goneLeftMargin, Integer.MIN_VALUE);
                writeDimension("app:layout_marginRight", layout.rightMargin, 0);
                writeDimension("app:layout_goneMarginRight", layout.goneRightMargin, Integer.MIN_VALUE);
                writeDimension("app:layout_marginStart", layout.startMargin, 0);
                writeDimension("app:layout_goneMarginStart", layout.goneStartMargin, Integer.MIN_VALUE);
                writeDimension("app:layout_marginEnd", layout.endMargin, 0);
                writeDimension("app:layout_goneMarginEnd", layout.goneEndMargin, Integer.MIN_VALUE);
                writeDimension("app:layout_marginTop", layout.topMargin, 0);
                writeDimension("app:layout_goneMarginTop", layout.goneTopMargin, Integer.MIN_VALUE);
                writeDimension("app:layout_marginBottom", layout.bottomMargin, 0);
                writeDimension("app:layout_goneMarginBottom", layout.goneBottomMargin, Integer.MIN_VALUE);
                writeDimension("app:goneBaselineMargin", layout.goneBaselineMargin, Integer.MIN_VALUE);
                writeDimension("app:baselineMargin", layout.baselineMargin, 0);
                writeBoolen("app:layout_constrainedWidth", layout.constrainedWidth, false);
                writeBoolen("app:layout_constrainedHeight", layout.constrainedHeight, false);
                writeBoolen("app:barrierAllowsGoneWidgets", layout.mBarrierAllowsGoneWidgets, true);
                writeVariable("app:layout_wrapBehaviorInParent", layout.mWrapBehavior, 0.0f);
                writeXmlConstraint("app:baselineToBaseline", layout.baselineToBaseline);
                writeXmlConstraint("app:baselineToBottom", layout.baselineToBottom);
                writeXmlConstraint("app:baselineToTop", layout.baselineToTop);
                writeXmlConstraint("app:layout_constraintBottom_toBottomOf", layout.bottomToBottom);
                writeXmlConstraint("app:layout_constraintBottom_toTopOf", layout.bottomToTop);
                writeXmlConstraint("app:layout_constraintEnd_toEndOf", layout.endToEnd);
                writeXmlConstraint("app:layout_constraintEnd_toStartOf", layout.endToStart);
                writeXmlConstraint("app:layout_constraintLeft_toLeftOf", layout.leftToLeft);
                writeXmlConstraint("app:layout_constraintLeft_toRightOf", layout.leftToRight);
                writeXmlConstraint("app:layout_constraintRight_toLeftOf", layout.rightToLeft);
                writeXmlConstraint("app:layout_constraintRight_toRightOf", layout.rightToRight);
                writeXmlConstraint("app:layout_constraintStart_toEndOf", layout.startToEnd);
                writeXmlConstraint("app:layout_constraintStart_toStartOf", layout.startToStart);
                writeXmlConstraint("app:layout_constraintTop_toBottomOf", layout.topToBottom);
                writeXmlConstraint("app:layout_constraintTop_toTopOf", layout.topToTop);
                String[] strArr = {"spread", "wrap", "percent"};
                writeEnum("app:layout_constraintHeight_default", layout.heightDefault, strArr, 0);
                writeVariable("app:layout_constraintHeight_percent", layout.heightPercent, 1.0f);
                writeDimension("app:layout_constraintHeight_min", layout.heightMin, 0);
                writeDimension("app:layout_constraintHeight_max", layout.heightMax, 0);
                writeBoolen("android:layout_constrainedHeight", layout.constrainedHeight, false);
                writeEnum("app:layout_constraintWidth_default", layout.widthDefault, strArr, 0);
                writeVariable("app:layout_constraintWidth_percent", layout.widthPercent, 1.0f);
                writeDimension("app:layout_constraintWidth_min", layout.widthMin, 0);
                writeDimension("app:layout_constraintWidth_max", layout.widthMax, 0);
                writeBoolen("android:layout_constrainedWidth", layout.constrainedWidth, false);
                writeVariable("app:layout_constraintVertical_weight", layout.verticalWeight, -1.0f);
                writeVariable("app:layout_constraintHorizontal_weight", layout.horizontalWeight, -1.0f);
                writeVariable("app:layout_constraintHorizontal_chainStyle", layout.horizontalChainStyle);
                writeVariable("app:layout_constraintVertical_chainStyle", layout.verticalChainStyle);
                writeEnum("app:barrierDirection", layout.mBarrierDirection, new String[]{"left", "right", "top", "bottom", "start", "end"}, -1);
                writeVariable("app:layout_constraintTag", layout.mConstraintTag, (String) null);
                int[] iArr = layout.mReferenceIds;
                if (iArr != null) {
                    writeVariable("'ReferenceIds'", iArr);
                }
                this.writer.write(" />\n");
            }
            this.writer.write("</ConstraintSet>\n");
        }

        public void writeVariable(String str, int i8) throws IOException {
            if (i8 == 0 || i8 == -1) {
                return;
            }
            this.writer.write(SPACE + str + "=\"" + i8 + "\"\n");
        }

        public void writeXmlConstraint(String str, int i8) throws IOException {
            if (i8 == -1) {
                return;
            }
            this.writer.write(SPACE + str);
            this.writer.write("=\"" + getName(i8) + "\"");
        }

        public void writeVariable(String str, float f, float f4) throws IOException {
            if (f == f4) {
                return;
            }
            this.writer.write(SPACE + str);
            this.writer.write("=\"" + f + "\"");
        }

        public void writeVariable(String str, String str2, String str3) throws IOException {
            if (str2 == null || str2.equals(str3)) {
                return;
            }
            this.writer.write(SPACE + str);
            this.writer.write("=\"" + str2 + "\"");
        }

        public void writeVariable(String str, int[] iArr) throws IOException {
            if (iArr == null) {
                return;
            }
            this.writer.write(SPACE + str);
            this.writer.write(":");
            int i8 = 0;
            while (i8 < iArr.length) {
                Writer writer = this.writer;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(i8 == 0 ? "[" : ", ");
                sb2.append(getName(iArr[i8]));
                writer.write(sb2.toString());
                i8++;
            }
            this.writer.write("],\n");
        }

        public void writeVariable(String str, String str2) throws IOException {
            if (str2 == null) {
                return;
            }
            this.writer.write(str);
            this.writer.write(":");
            this.writer.write(", ".concat(str2));
            this.writer.write("\n");
        }
    }

    static {
        mapToConstant.append(R.styleable.Constraint_layout_constraintLeft_toLeftOf, 25);
        mapToConstant.append(R.styleable.Constraint_layout_constraintLeft_toRightOf, 26);
        mapToConstant.append(R.styleable.Constraint_layout_constraintRight_toLeftOf, 29);
        mapToConstant.append(R.styleable.Constraint_layout_constraintRight_toRightOf, 30);
        mapToConstant.append(R.styleable.Constraint_layout_constraintTop_toTopOf, 36);
        mapToConstant.append(R.styleable.Constraint_layout_constraintTop_toBottomOf, 35);
        mapToConstant.append(R.styleable.Constraint_layout_constraintBottom_toTopOf, 4);
        mapToConstant.append(R.styleable.Constraint_layout_constraintBottom_toBottomOf, 3);
        mapToConstant.append(R.styleable.Constraint_layout_constraintBaseline_toBaselineOf, 1);
        mapToConstant.append(R.styleable.Constraint_layout_constraintBaseline_toTopOf, BASELINE_TO_TOP);
        mapToConstant.append(R.styleable.Constraint_layout_constraintBaseline_toBottomOf, BASELINE_TO_BOTTOM);
        mapToConstant.append(R.styleable.Constraint_layout_editor_absoluteX, 6);
        mapToConstant.append(R.styleable.Constraint_layout_editor_absoluteY, 7);
        mapToConstant.append(R.styleable.Constraint_layout_constraintGuide_begin, 17);
        mapToConstant.append(R.styleable.Constraint_layout_constraintGuide_end, 18);
        mapToConstant.append(R.styleable.Constraint_layout_constraintGuide_percent, 19);
        mapToConstant.append(R.styleable.Constraint_guidelineUseRtl, GUIDELINE_USE_RTL);
        mapToConstant.append(R.styleable.Constraint_android_orientation, 27);
        mapToConstant.append(R.styleable.Constraint_layout_constraintStart_toEndOf, 32);
        mapToConstant.append(R.styleable.Constraint_layout_constraintStart_toStartOf, 33);
        mapToConstant.append(R.styleable.Constraint_layout_constraintEnd_toStartOf, 10);
        mapToConstant.append(R.styleable.Constraint_layout_constraintEnd_toEndOf, 9);
        mapToConstant.append(R.styleable.Constraint_layout_goneMarginLeft, 13);
        mapToConstant.append(R.styleable.Constraint_layout_goneMarginTop, 16);
        mapToConstant.append(R.styleable.Constraint_layout_goneMarginRight, 14);
        mapToConstant.append(R.styleable.Constraint_layout_goneMarginBottom, 11);
        mapToConstant.append(R.styleable.Constraint_layout_goneMarginStart, 15);
        mapToConstant.append(R.styleable.Constraint_layout_goneMarginEnd, 12);
        mapToConstant.append(R.styleable.Constraint_layout_constraintVertical_weight, 40);
        mapToConstant.append(R.styleable.Constraint_layout_constraintHorizontal_weight, 39);
        mapToConstant.append(R.styleable.Constraint_layout_constraintHorizontal_chainStyle, 41);
        mapToConstant.append(R.styleable.Constraint_layout_constraintVertical_chainStyle, 42);
        mapToConstant.append(R.styleable.Constraint_layout_constraintHorizontal_bias, 20);
        mapToConstant.append(R.styleable.Constraint_layout_constraintVertical_bias, 37);
        mapToConstant.append(R.styleable.Constraint_layout_constraintDimensionRatio, 5);
        mapToConstant.append(R.styleable.Constraint_layout_constraintLeft_creator, UNUSED);
        mapToConstant.append(R.styleable.Constraint_layout_constraintTop_creator, UNUSED);
        mapToConstant.append(R.styleable.Constraint_layout_constraintRight_creator, UNUSED);
        mapToConstant.append(R.styleable.Constraint_layout_constraintBottom_creator, UNUSED);
        mapToConstant.append(R.styleable.Constraint_layout_constraintBaseline_creator, UNUSED);
        mapToConstant.append(R.styleable.Constraint_android_layout_marginLeft, 24);
        mapToConstant.append(R.styleable.Constraint_android_layout_marginRight, 28);
        mapToConstant.append(R.styleable.Constraint_android_layout_marginStart, 31);
        mapToConstant.append(R.styleable.Constraint_android_layout_marginEnd, 8);
        mapToConstant.append(R.styleable.Constraint_android_layout_marginTop, 34);
        mapToConstant.append(R.styleable.Constraint_android_layout_marginBottom, 2);
        mapToConstant.append(R.styleable.Constraint_android_layout_width, 23);
        mapToConstant.append(R.styleable.Constraint_android_layout_height, 21);
        mapToConstant.append(R.styleable.Constraint_layout_constraintWidth, LAYOUT_CONSTRAINT_WIDTH);
        mapToConstant.append(R.styleable.Constraint_layout_constraintHeight, LAYOUT_CONSTRAINT_HEIGHT);
        mapToConstant.append(R.styleable.Constraint_android_visibility, 22);
        mapToConstant.append(R.styleable.Constraint_android_alpha, 43);
        mapToConstant.append(R.styleable.Constraint_android_elevation, 44);
        mapToConstant.append(R.styleable.Constraint_android_rotationX, 45);
        mapToConstant.append(R.styleable.Constraint_android_rotationY, 46);
        mapToConstant.append(R.styleable.Constraint_android_rotation, ROTATION);
        mapToConstant.append(R.styleable.Constraint_android_scaleX, 47);
        mapToConstant.append(R.styleable.Constraint_android_scaleY, 48);
        mapToConstant.append(R.styleable.Constraint_android_transformPivotX, 49);
        mapToConstant.append(R.styleable.Constraint_android_transformPivotY, 50);
        mapToConstant.append(R.styleable.Constraint_android_translationX, 51);
        mapToConstant.append(R.styleable.Constraint_android_translationY, 52);
        mapToConstant.append(R.styleable.Constraint_android_translationZ, 53);
        mapToConstant.append(R.styleable.Constraint_layout_constraintWidth_default, 54);
        mapToConstant.append(R.styleable.Constraint_layout_constraintHeight_default, 55);
        mapToConstant.append(R.styleable.Constraint_layout_constraintWidth_max, WIDTH_MAX);
        mapToConstant.append(R.styleable.Constraint_layout_constraintHeight_max, HEIGHT_MAX);
        mapToConstant.append(R.styleable.Constraint_layout_constraintWidth_min, WIDTH_MIN);
        mapToConstant.append(R.styleable.Constraint_layout_constraintHeight_min, HEIGHT_MIN);
        mapToConstant.append(R.styleable.Constraint_layout_constraintCircle, CIRCLE);
        mapToConstant.append(R.styleable.Constraint_layout_constraintCircleRadius, CIRCLE_RADIUS);
        mapToConstant.append(R.styleable.Constraint_layout_constraintCircleAngle, 63);
        mapToConstant.append(R.styleable.Constraint_animateRelativeTo, 64);
        mapToConstant.append(R.styleable.Constraint_transitionEasing, 65);
        mapToConstant.append(R.styleable.Constraint_drawPath, 66);
        mapToConstant.append(R.styleable.Constraint_transitionPathRotate, 67);
        mapToConstant.append(R.styleable.Constraint_motionStagger, MOTION_STAGGER);
        mapToConstant.append(R.styleable.Constraint_android_id, 38);
        mapToConstant.append(R.styleable.Constraint_motionProgress, PROGRESS);
        mapToConstant.append(R.styleable.Constraint_layout_constraintWidth_percent, WIDTH_PERCENT);
        mapToConstant.append(R.styleable.Constraint_layout_constraintHeight_percent, HEIGHT_PERCENT);
        mapToConstant.append(R.styleable.Constraint_layout_wrapBehaviorInParent, LAYOUT_WRAP_BEHAVIOR);
        mapToConstant.append(R.styleable.Constraint_chainUseRtl, CHAIN_USE_RTL);
        mapToConstant.append(R.styleable.Constraint_barrierDirection, BARRIER_DIRECTION);
        mapToConstant.append(R.styleable.Constraint_barrierMargin, BARRIER_MARGIN);
        mapToConstant.append(R.styleable.Constraint_constraint_referenced_ids, CONSTRAINT_REFERENCED_IDS);
        mapToConstant.append(R.styleable.Constraint_barrierAllowsGoneWidgets, BARRIER_ALLOWS_GONE_WIDGETS);
        mapToConstant.append(R.styleable.Constraint_pathMotionArc, 76);
        mapToConstant.append(R.styleable.Constraint_layout_constraintTag, CONSTRAINT_TAG);
        mapToConstant.append(R.styleable.Constraint_visibilityMode, VISIBILITY_MODE);
        mapToConstant.append(R.styleable.Constraint_layout_constrainedWidth, CONSTRAINED_WIDTH);
        mapToConstant.append(R.styleable.Constraint_layout_constrainedHeight, CONSTRAINED_HEIGHT);
        mapToConstant.append(R.styleable.Constraint_polarRelativeTo, ANIMATE_CIRCLE_ANGLE_TO);
        mapToConstant.append(R.styleable.Constraint_transformPivotTarget, TRANSFORM_PIVOT_TARGET);
        mapToConstant.append(R.styleable.Constraint_quantizeMotionSteps, QUANTIZE_MOTION_STEPS);
        mapToConstant.append(R.styleable.Constraint_quantizeMotionPhase, QUANTIZE_MOTION_PHASE);
        mapToConstant.append(R.styleable.Constraint_quantizeMotionInterpolator, QUANTIZE_MOTION_INTERPOLATOR);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_editor_absoluteY, 6);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_editor_absoluteY, 7);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_orientation, 27);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_goneMarginLeft, 13);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_goneMarginTop, 16);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_goneMarginRight, 14);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_goneMarginBottom, 11);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_goneMarginStart, 15);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_goneMarginEnd, 12);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintVertical_weight, 40);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintHorizontal_weight, 39);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintHorizontal_chainStyle, 41);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintVertical_chainStyle, 42);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintHorizontal_bias, 20);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintVertical_bias, 37);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintDimensionRatio, 5);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintLeft_creator, UNUSED);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintTop_creator, UNUSED);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintRight_creator, UNUSED);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintBottom_creator, UNUSED);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintBaseline_creator, UNUSED);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_layout_marginLeft, 24);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_layout_marginRight, 28);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_layout_marginStart, 31);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_layout_marginEnd, 8);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_layout_marginTop, 34);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_layout_marginBottom, 2);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_layout_width, 23);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_layout_height, 21);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintWidth, LAYOUT_CONSTRAINT_WIDTH);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintHeight, LAYOUT_CONSTRAINT_HEIGHT);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_visibility, 22);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_alpha, 43);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_elevation, 44);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_rotationX, 45);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_rotationY, 46);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_rotation, ROTATION);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_scaleX, 47);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_scaleY, 48);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_transformPivotX, 49);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_transformPivotY, 50);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_translationX, 51);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_translationY, 52);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_translationZ, 53);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintWidth_default, 54);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintHeight_default, 55);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintWidth_max, WIDTH_MAX);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintHeight_max, HEIGHT_MAX);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintWidth_min, WIDTH_MIN);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintHeight_min, HEIGHT_MIN);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintCircleRadius, CIRCLE_RADIUS);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintCircleAngle, 63);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_animateRelativeTo, 64);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_transitionEasing, 65);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_drawPath, 66);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_transitionPathRotate, 67);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_motionStagger, MOTION_STAGGER);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_id, 38);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_motionTarget, MOTION_TARGET);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_motionProgress, PROGRESS);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintWidth_percent, WIDTH_PERCENT);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintHeight_percent, HEIGHT_PERCENT);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_chainUseRtl, CHAIN_USE_RTL);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_barrierDirection, BARRIER_DIRECTION);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_barrierMargin, BARRIER_MARGIN);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_constraint_referenced_ids, CONSTRAINT_REFERENCED_IDS);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_barrierAllowsGoneWidgets, BARRIER_ALLOWS_GONE_WIDGETS);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_pathMotionArc, 76);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintTag, CONSTRAINT_TAG);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_visibilityMode, VISIBILITY_MODE);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constrainedWidth, CONSTRAINED_WIDTH);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constrainedHeight, CONSTRAINED_HEIGHT);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_polarRelativeTo, ANIMATE_CIRCLE_ANGLE_TO);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_transformPivotTarget, TRANSFORM_PIVOT_TARGET);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_quantizeMotionSteps, QUANTIZE_MOTION_STEPS);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_quantizeMotionPhase, QUANTIZE_MOTION_PHASE);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_quantizeMotionInterpolator, QUANTIZE_MOTION_INTERPOLATOR);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_wrapBehaviorInParent, LAYOUT_WRAP_BEHAVIOR);
    }

    private void addAttributes(ConstraintAttribute.AttributeType attributeType, String... strArr) {
        for (int i8 = 0; i8 < strArr.length; i8++) {
            if (this.mSavedAttributes.containsKey(strArr[i8])) {
                ConstraintAttribute constraintAttribute = this.mSavedAttributes.get(strArr[i8]);
                if (constraintAttribute != null && constraintAttribute.getType() != attributeType) {
                    throw new IllegalArgumentException("ConstraintAttribute is already a " + constraintAttribute.getType().name());
                }
            } else {
                this.mSavedAttributes.put(strArr[i8], new ConstraintAttribute(strArr[i8], attributeType));
            }
        }
    }

    public static Constraint buildDelta(Context context, XmlPullParser xmlPullParser) {
        AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xmlPullParser);
        Constraint constraint = new Constraint();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSetAsAttributeSet, R.styleable.ConstraintOverride);
        populateOverride(context, constraint, typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
        return constraint;
    }

    private int[] convertReferenceString(View view, String str) {
        int iIntValue;
        Object designInformation;
        String[] strArrSplit = str.split(",");
        Context context = view.getContext();
        int[] iArr = new int[strArrSplit.length];
        int i8 = 0;
        int i9 = 0;
        while (i8 < strArrSplit.length) {
            String strTrim = strArrSplit[i8].trim();
            try {
                iIntValue = R.id.class.getField(strTrim).getInt(null);
            } catch (Exception unused) {
                iIntValue = 0;
            }
            if (iIntValue == 0) {
                iIntValue = context.getResources().getIdentifier(strTrim, "id", context.getPackageName());
            }
            if (iIntValue == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout) && (designInformation = ((ConstraintLayout) view.getParent()).getDesignInformation(0, strTrim)) != null && (designInformation instanceof Integer)) {
                iIntValue = ((Integer) designInformation).intValue();
            }
            iArr[i9] = iIntValue;
            i8++;
            i9++;
        }
        return i9 != strArrSplit.length ? Arrays.copyOf(iArr, i9) : iArr;
    }

    private Constraint fillFromAttributeList(Context context, AttributeSet attributeSet, boolean z2) {
        Constraint constraint = new Constraint();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, z2 ? R.styleable.ConstraintOverride : R.styleable.Constraint);
        populateConstraint(context, constraint, typedArrayObtainStyledAttributes, z2);
        typedArrayObtainStyledAttributes.recycle();
        return constraint;
    }

    private Constraint get(int i8) {
        if (!this.mConstraints.containsKey(Integer.valueOf(i8))) {
            this.mConstraints.put(Integer.valueOf(i8), new Constraint());
        }
        return this.mConstraints.get(Integer.valueOf(i8));
    }

    public static String getDebugName(int i8) {
        for (Field field : ConstraintSet.class.getDeclaredFields()) {
            if (field.getName().contains("_") && field.getType() == Integer.TYPE && Modifier.isStatic(field.getModifiers()) && Modifier.isFinal(field.getModifiers())) {
                try {
                    if (field.getInt(null) == i8) {
                        return field.getName();
                    }
                    continue;
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return "UNKNOWN";
    }

    public static String getLine(Context context, int i8, XmlPullParser xmlPullParser) {
        return ".(" + Debug.getName(context, i8) + ".xml:" + xmlPullParser.getLineNumber() + ") \"" + xmlPullParser.getName() + "\"";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int lookupID(TypedArray typedArray, int i8, int i9) {
        int resourceId = typedArray.getResourceId(i8, i9);
        return resourceId == -1 ? typedArray.getInt(i8, -1) : resourceId;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0033  */
    /* JADX WARN: Code duplicated, block: B:23:0x0037  */
    /* JADX WARN: Code duplicated, block: B:24:0x003c  */
    /* JADX WARN: Code duplicated, block: B:25:0x0041  */
    /* JADX WARN: Code duplicated, block: B:27:0x0045  */
    /* JADX WARN: Code duplicated, block: B:29:0x0049  */
    /* JADX WARN: Code duplicated, block: B:30:0x004e  */
    /* JADX WARN: Code duplicated, block: B:31:0x0053  */
    /* JADX WARN: Code duplicated, block: B:33:0x0057  */
    /* JADX WARN: Code duplicated, block: B:35:0x005b  */
    /* JADX WARN: Code duplicated, block: B:36:0x0066  */
    /* JADX WARN: Code duplicated, block: B:44:? A[RETURN, SYNTHETIC] */
    public static void parseDimensionConstraints(Object obj, TypedArray typedArray, int i8, int i9) {
        int dimensionPixelSize;
        boolean z2;
        Constraint.Delta delta;
        Layout layout;
        ConstraintLayout.LayoutParams layoutParams;
        if (obj == null) {
            return;
        }
        int i10 = typedArray.peekValue(i8).type;
        if (i10 == 3) {
            parseDimensionConstraintsString(obj, typedArray.getString(i8), i9);
            return;
        }
        int i11 = 0;
        if (i10 != 5) {
            dimensionPixelSize = typedArray.getInt(i8, 0);
            if (dimensionPixelSize == -4) {
                z2 = true;
                i11 = -2;
            } else if (dimensionPixelSize == -3 || (dimensionPixelSize != -2 && dimensionPixelSize != -1)) {
                z2 = false;
            }
            if (obj instanceof ConstraintLayout.LayoutParams) {
                layoutParams = (ConstraintLayout.LayoutParams) obj;
                if (i9 == 0) {
                    ((ViewGroup.MarginLayoutParams) layoutParams).width = i11;
                    layoutParams.constrainedWidth = z2;
                    return;
                } else {
                    ((ViewGroup.MarginLayoutParams) layoutParams).height = i11;
                    layoutParams.constrainedHeight = z2;
                    return;
                }
            }
            if (obj instanceof Layout) {
                layout = (Layout) obj;
                if (i9 == 0) {
                    layout.mWidth = i11;
                    layout.constrainedWidth = z2;
                    return;
                } else {
                    layout.mHeight = i11;
                    layout.constrainedHeight = z2;
                    return;
                }
            }
            if (obj instanceof Constraint.Delta) {
                delta = (Constraint.Delta) obj;
                if (i9 == 0) {
                    delta.add(23, i11);
                    delta.add(CONSTRAINED_WIDTH, z2);
                } else {
                    delta.add(21, i11);
                    delta.add(CONSTRAINED_HEIGHT, z2);
                }
            }
        }
        dimensionPixelSize = typedArray.getDimensionPixelSize(i8, 0);
        i11 = dimensionPixelSize;
        z2 = false;
        if (obj instanceof ConstraintLayout.LayoutParams) {
            layoutParams = (ConstraintLayout.LayoutParams) obj;
            if (i9 == 0) {
                ((ViewGroup.MarginLayoutParams) layoutParams).width = i11;
                layoutParams.constrainedWidth = z2;
                return;
            } else {
                ((ViewGroup.MarginLayoutParams) layoutParams).height = i11;
                layoutParams.constrainedHeight = z2;
                return;
            }
        }
        if (obj instanceof Layout) {
            layout = (Layout) obj;
            if (i9 == 0) {
                layout.mWidth = i11;
                layout.constrainedWidth = z2;
                return;
            } else {
                layout.mHeight = i11;
                layout.constrainedHeight = z2;
                return;
            }
        }
        if (obj instanceof Constraint.Delta) {
            delta = (Constraint.Delta) obj;
            if (i9 == 0) {
                delta.add(23, i11);
                delta.add(CONSTRAINED_WIDTH, z2);
            } else {
                delta.add(21, i11);
                delta.add(CONSTRAINED_HEIGHT, z2);
            }
        }
    }

    public static void parseDimensionConstraintsString(Object obj, String str, int i8) {
        if (str == null) {
            return;
        }
        int iIndexOf = str.indexOf(CIRCLE);
        int length = str.length();
        if (iIndexOf <= 0 || iIndexOf >= length - 1) {
            return;
        }
        String strSubstring = str.substring(0, iIndexOf);
        String strSubstring2 = str.substring(iIndexOf + 1);
        if (strSubstring2.length() > 0) {
            String strTrim = strSubstring.trim();
            String strTrim2 = strSubstring2.trim();
            if (KEY_RATIO.equalsIgnoreCase(strTrim)) {
                if (obj instanceof ConstraintLayout.LayoutParams) {
                    ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) obj;
                    if (i8 == 0) {
                        ((ViewGroup.MarginLayoutParams) layoutParams).width = 0;
                    } else {
                        ((ViewGroup.MarginLayoutParams) layoutParams).height = 0;
                    }
                    parseDimensionRatioString(layoutParams, strTrim2);
                    return;
                }
                if (obj instanceof Layout) {
                    ((Layout) obj).dimensionRatio = strTrim2;
                    return;
                } else {
                    if (obj instanceof Constraint.Delta) {
                        ((Constraint.Delta) obj).add(5, strTrim2);
                        return;
                    }
                    return;
                }
            }
            try {
                if (KEY_WEIGHT.equalsIgnoreCase(strTrim)) {
                    float f = Float.parseFloat(strTrim2);
                    if (obj instanceof ConstraintLayout.LayoutParams) {
                        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) obj;
                        if (i8 == 0) {
                            ((ViewGroup.MarginLayoutParams) layoutParams2).width = 0;
                            layoutParams2.horizontalWeight = f;
                        } else {
                            ((ViewGroup.MarginLayoutParams) layoutParams2).height = 0;
                            layoutParams2.verticalWeight = f;
                        }
                    } else if (obj instanceof Layout) {
                        Layout layout = (Layout) obj;
                        if (i8 == 0) {
                            layout.mWidth = 0;
                            layout.horizontalWeight = f;
                        } else {
                            layout.mHeight = 0;
                            layout.verticalWeight = f;
                        }
                    } else if (obj instanceof Constraint.Delta) {
                        Constraint.Delta delta = (Constraint.Delta) obj;
                        if (i8 == 0) {
                            delta.add(23, 0);
                            delta.add(39, f);
                        } else {
                            delta.add(21, 0);
                            delta.add(40, f);
                        }
                    }
                } else {
                    if (!KEY_PERCENT_PARENT.equalsIgnoreCase(strTrim)) {
                        return;
                    }
                    float fMax = Math.max(0.0f, Math.min(1.0f, Float.parseFloat(strTrim2)));
                    if (obj instanceof ConstraintLayout.LayoutParams) {
                        ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) obj;
                        if (i8 == 0) {
                            ((ViewGroup.MarginLayoutParams) layoutParams3).width = 0;
                            layoutParams3.matchConstraintPercentWidth = fMax;
                            layoutParams3.matchConstraintDefaultWidth = 2;
                        } else {
                            ((ViewGroup.MarginLayoutParams) layoutParams3).height = 0;
                            layoutParams3.matchConstraintPercentHeight = fMax;
                            layoutParams3.matchConstraintDefaultHeight = 2;
                        }
                    } else if (obj instanceof Layout) {
                        Layout layout2 = (Layout) obj;
                        if (i8 == 0) {
                            layout2.mWidth = 0;
                            layout2.widthPercent = fMax;
                            layout2.widthDefault = 2;
                        } else {
                            layout2.mHeight = 0;
                            layout2.heightPercent = fMax;
                            layout2.heightDefault = 2;
                        }
                    } else if (obj instanceof Constraint.Delta) {
                        Constraint.Delta delta2 = (Constraint.Delta) obj;
                        if (i8 == 0) {
                            delta2.add(23, 0);
                            delta2.add(54, 2);
                        } else {
                            delta2.add(21, 0);
                            delta2.add(55, 2);
                        }
                    }
                }
            } catch (NumberFormatException unused) {
            }
        }
    }

    public static void parseDimensionRatioString(ConstraintLayout.LayoutParams layoutParams, String str) {
        float fAbs = Float.NaN;
        int i8 = -1;
        if (str != null) {
            int length = str.length();
            int iIndexOf = str.indexOf(44);
            int i9 = 0;
            if (iIndexOf > 0 && iIndexOf < length - 1) {
                String strSubstring = str.substring(0, iIndexOf);
                if (strSubstring.equalsIgnoreCase(ExifInterface.LONGITUDE_WEST)) {
                    i8 = 0;
                } else if (strSubstring.equalsIgnoreCase("H")) {
                    i8 = 1;
                }
                i9 = iIndexOf + 1;
            }
            int iIndexOf2 = str.indexOf(WIDTH_MIN);
            try {
                if (iIndexOf2 < 0 || iIndexOf2 >= length - 1) {
                    String strSubstring2 = str.substring(i9);
                    if (strSubstring2.length() > 0) {
                        fAbs = Float.parseFloat(strSubstring2);
                    }
                } else {
                    String strSubstring3 = str.substring(i9, iIndexOf2);
                    String strSubstring4 = str.substring(iIndexOf2 + 1);
                    if (strSubstring3.length() > 0 && strSubstring4.length() > 0) {
                        float f = Float.parseFloat(strSubstring3);
                        float f4 = Float.parseFloat(strSubstring4);
                        if (f > 0.0f && f4 > 0.0f) {
                            fAbs = i8 == 1 ? Math.abs(f4 / f) : Math.abs(f / f4);
                        }
                    }
                }
            } catch (NumberFormatException unused) {
            }
        }
        layoutParams.dimensionRatio = str;
        layoutParams.dimensionRatioValue = fAbs;
        layoutParams.dimensionRatioSide = i8;
    }

    private void populateConstraint(Context context, Constraint constraint, TypedArray typedArray, boolean z2) {
        if (z2) {
            populateOverride(context, constraint, typedArray);
            return;
        }
        int indexCount = typedArray.getIndexCount();
        for (int i8 = 0; i8 < indexCount; i8++) {
            int index = typedArray.getIndex(i8);
            if (index != R.styleable.Constraint_android_id && R.styleable.Constraint_android_layout_marginStart != index && R.styleable.Constraint_android_layout_marginEnd != index) {
                constraint.motion.mApply = true;
                constraint.layout.mApply = true;
                constraint.propertySet.mApply = true;
                constraint.transform.mApply = true;
            }
            switch (mapToConstant.get(index)) {
                case 1:
                    Layout layout = constraint.layout;
                    layout.baselineToBaseline = lookupID(typedArray, index, layout.baselineToBaseline);
                    break;
                case 2:
                    Layout layout2 = constraint.layout;
                    layout2.bottomMargin = typedArray.getDimensionPixelSize(index, layout2.bottomMargin);
                    break;
                case 3:
                    Layout layout3 = constraint.layout;
                    layout3.bottomToBottom = lookupID(typedArray, index, layout3.bottomToBottom);
                    break;
                case 4:
                    Layout layout4 = constraint.layout;
                    layout4.bottomToTop = lookupID(typedArray, index, layout4.bottomToTop);
                    break;
                case 5:
                    constraint.layout.dimensionRatio = typedArray.getString(index);
                    break;
                case 6:
                    Layout layout5 = constraint.layout;
                    layout5.editorAbsoluteX = typedArray.getDimensionPixelOffset(index, layout5.editorAbsoluteX);
                    break;
                case 7:
                    Layout layout6 = constraint.layout;
                    layout6.editorAbsoluteY = typedArray.getDimensionPixelOffset(index, layout6.editorAbsoluteY);
                    break;
                case 8:
                    Layout layout7 = constraint.layout;
                    layout7.endMargin = typedArray.getDimensionPixelSize(index, layout7.endMargin);
                    break;
                case 9:
                    Layout layout8 = constraint.layout;
                    layout8.endToEnd = lookupID(typedArray, index, layout8.endToEnd);
                    break;
                case 10:
                    Layout layout9 = constraint.layout;
                    layout9.endToStart = lookupID(typedArray, index, layout9.endToStart);
                    break;
                case 11:
                    Layout layout10 = constraint.layout;
                    layout10.goneBottomMargin = typedArray.getDimensionPixelSize(index, layout10.goneBottomMargin);
                    break;
                case 12:
                    Layout layout11 = constraint.layout;
                    layout11.goneEndMargin = typedArray.getDimensionPixelSize(index, layout11.goneEndMargin);
                    break;
                case 13:
                    Layout layout12 = constraint.layout;
                    layout12.goneLeftMargin = typedArray.getDimensionPixelSize(index, layout12.goneLeftMargin);
                    break;
                case 14:
                    Layout layout13 = constraint.layout;
                    layout13.goneRightMargin = typedArray.getDimensionPixelSize(index, layout13.goneRightMargin);
                    break;
                case 15:
                    Layout layout14 = constraint.layout;
                    layout14.goneStartMargin = typedArray.getDimensionPixelSize(index, layout14.goneStartMargin);
                    break;
                case 16:
                    Layout layout15 = constraint.layout;
                    layout15.goneTopMargin = typedArray.getDimensionPixelSize(index, layout15.goneTopMargin);
                    break;
                case 17:
                    Layout layout16 = constraint.layout;
                    layout16.guideBegin = typedArray.getDimensionPixelOffset(index, layout16.guideBegin);
                    break;
                case 18:
                    Layout layout17 = constraint.layout;
                    layout17.guideEnd = typedArray.getDimensionPixelOffset(index, layout17.guideEnd);
                    break;
                case 19:
                    Layout layout18 = constraint.layout;
                    layout18.guidePercent = typedArray.getFloat(index, layout18.guidePercent);
                    break;
                case 20:
                    Layout layout19 = constraint.layout;
                    layout19.horizontalBias = typedArray.getFloat(index, layout19.horizontalBias);
                    break;
                case 21:
                    Layout layout20 = constraint.layout;
                    layout20.mHeight = typedArray.getLayoutDimension(index, layout20.mHeight);
                    break;
                case 22:
                    PropertySet propertySet = constraint.propertySet;
                    propertySet.visibility = typedArray.getInt(index, propertySet.visibility);
                    PropertySet propertySet2 = constraint.propertySet;
                    propertySet2.visibility = VISIBILITY_FLAGS[propertySet2.visibility];
                    break;
                case 23:
                    Layout layout21 = constraint.layout;
                    layout21.mWidth = typedArray.getLayoutDimension(index, layout21.mWidth);
                    break;
                case 24:
                    Layout layout22 = constraint.layout;
                    layout22.leftMargin = typedArray.getDimensionPixelSize(index, layout22.leftMargin);
                    break;
                case 25:
                    Layout layout23 = constraint.layout;
                    layout23.leftToLeft = lookupID(typedArray, index, layout23.leftToLeft);
                    break;
                case 26:
                    Layout layout24 = constraint.layout;
                    layout24.leftToRight = lookupID(typedArray, index, layout24.leftToRight);
                    break;
                case 27:
                    Layout layout25 = constraint.layout;
                    layout25.orientation = typedArray.getInt(index, layout25.orientation);
                    break;
                case 28:
                    Layout layout26 = constraint.layout;
                    layout26.rightMargin = typedArray.getDimensionPixelSize(index, layout26.rightMargin);
                    break;
                case 29:
                    Layout layout27 = constraint.layout;
                    layout27.rightToLeft = lookupID(typedArray, index, layout27.rightToLeft);
                    break;
                case 30:
                    Layout layout28 = constraint.layout;
                    layout28.rightToRight = lookupID(typedArray, index, layout28.rightToRight);
                    break;
                case 31:
                    Layout layout29 = constraint.layout;
                    layout29.startMargin = typedArray.getDimensionPixelSize(index, layout29.startMargin);
                    break;
                case 32:
                    Layout layout30 = constraint.layout;
                    layout30.startToEnd = lookupID(typedArray, index, layout30.startToEnd);
                    break;
                case 33:
                    Layout layout31 = constraint.layout;
                    layout31.startToStart = lookupID(typedArray, index, layout31.startToStart);
                    break;
                case 34:
                    Layout layout32 = constraint.layout;
                    layout32.topMargin = typedArray.getDimensionPixelSize(index, layout32.topMargin);
                    break;
                case 35:
                    Layout layout33 = constraint.layout;
                    layout33.topToBottom = lookupID(typedArray, index, layout33.topToBottom);
                    break;
                case 36:
                    Layout layout34 = constraint.layout;
                    layout34.topToTop = lookupID(typedArray, index, layout34.topToTop);
                    break;
                case 37:
                    Layout layout35 = constraint.layout;
                    layout35.verticalBias = typedArray.getFloat(index, layout35.verticalBias);
                    break;
                case 38:
                    constraint.mViewId = typedArray.getResourceId(index, constraint.mViewId);
                    break;
                case 39:
                    Layout layout36 = constraint.layout;
                    layout36.horizontalWeight = typedArray.getFloat(index, layout36.horizontalWeight);
                    break;
                case 40:
                    Layout layout37 = constraint.layout;
                    layout37.verticalWeight = typedArray.getFloat(index, layout37.verticalWeight);
                    break;
                case 41:
                    Layout layout38 = constraint.layout;
                    layout38.horizontalChainStyle = typedArray.getInt(index, layout38.horizontalChainStyle);
                    break;
                case 42:
                    Layout layout39 = constraint.layout;
                    layout39.verticalChainStyle = typedArray.getInt(index, layout39.verticalChainStyle);
                    break;
                case 43:
                    PropertySet propertySet3 = constraint.propertySet;
                    propertySet3.alpha = typedArray.getFloat(index, propertySet3.alpha);
                    break;
                case 44:
                    Transform transform = constraint.transform;
                    transform.applyElevation = true;
                    transform.elevation = typedArray.getDimension(index, transform.elevation);
                    break;
                case 45:
                    Transform transform2 = constraint.transform;
                    transform2.rotationX = typedArray.getFloat(index, transform2.rotationX);
                    break;
                case 46:
                    Transform transform3 = constraint.transform;
                    transform3.rotationY = typedArray.getFloat(index, transform3.rotationY);
                    break;
                case 47:
                    Transform transform4 = constraint.transform;
                    transform4.scaleX = typedArray.getFloat(index, transform4.scaleX);
                    break;
                case 48:
                    Transform transform5 = constraint.transform;
                    transform5.scaleY = typedArray.getFloat(index, transform5.scaleY);
                    break;
                case 49:
                    Transform transform6 = constraint.transform;
                    transform6.transformPivotX = typedArray.getDimension(index, transform6.transformPivotX);
                    break;
                case 50:
                    Transform transform7 = constraint.transform;
                    transform7.transformPivotY = typedArray.getDimension(index, transform7.transformPivotY);
                    break;
                case 51:
                    Transform transform8 = constraint.transform;
                    transform8.translationX = typedArray.getDimension(index, transform8.translationX);
                    break;
                case 52:
                    Transform transform9 = constraint.transform;
                    transform9.translationY = typedArray.getDimension(index, transform9.translationY);
                    break;
                case 53:
                    Transform transform10 = constraint.transform;
                    transform10.translationZ = typedArray.getDimension(index, transform10.translationZ);
                    break;
                case 54:
                    Layout layout40 = constraint.layout;
                    layout40.widthDefault = typedArray.getInt(index, layout40.widthDefault);
                    break;
                case 55:
                    Layout layout41 = constraint.layout;
                    layout41.heightDefault = typedArray.getInt(index, layout41.heightDefault);
                    break;
                case WIDTH_MAX /* 56 */:
                    Layout layout42 = constraint.layout;
                    layout42.widthMax = typedArray.getDimensionPixelSize(index, layout42.widthMax);
                    break;
                case HEIGHT_MAX /* 57 */:
                    Layout layout43 = constraint.layout;
                    layout43.heightMax = typedArray.getDimensionPixelSize(index, layout43.heightMax);
                    break;
                case WIDTH_MIN /* 58 */:
                    Layout layout44 = constraint.layout;
                    layout44.widthMin = typedArray.getDimensionPixelSize(index, layout44.widthMin);
                    break;
                case HEIGHT_MIN /* 59 */:
                    Layout layout45 = constraint.layout;
                    layout45.heightMin = typedArray.getDimensionPixelSize(index, layout45.heightMin);
                    break;
                case ROTATION /* 60 */:
                    Transform transform11 = constraint.transform;
                    transform11.rotation = typedArray.getFloat(index, transform11.rotation);
                    break;
                case CIRCLE /* 61 */:
                    Layout layout46 = constraint.layout;
                    layout46.circleConstraint = lookupID(typedArray, index, layout46.circleConstraint);
                    break;
                case CIRCLE_RADIUS /* 62 */:
                    Layout layout47 = constraint.layout;
                    layout47.circleRadius = typedArray.getDimensionPixelSize(index, layout47.circleRadius);
                    break;
                case 63:
                    Layout layout48 = constraint.layout;
                    layout48.circleAngle = typedArray.getFloat(index, layout48.circleAngle);
                    break;
                case 64:
                    Motion motion = constraint.motion;
                    motion.mAnimateRelativeTo = lookupID(typedArray, index, motion.mAnimateRelativeTo);
                    break;
                case 65:
                    if (typedArray.peekValue(index).type == 3) {
                        constraint.motion.mTransitionEasing = typedArray.getString(index);
                    } else {
                        constraint.motion.mTransitionEasing = Easing.NAMED_EASING[typedArray.getInteger(index, 0)];
                    }
                    break;
                case 66:
                    constraint.motion.mDrawPath = typedArray.getInt(index, 0);
                    break;
                case 67:
                    Motion motion2 = constraint.motion;
                    motion2.mPathRotate = typedArray.getFloat(index, motion2.mPathRotate);
                    break;
                case PROGRESS /* 68 */:
                    PropertySet propertySet4 = constraint.propertySet;
                    propertySet4.mProgress = typedArray.getFloat(index, propertySet4.mProgress);
                    break;
                case WIDTH_PERCENT /* 69 */:
                    constraint.layout.widthPercent = typedArray.getFloat(index, 1.0f);
                    break;
                case HEIGHT_PERCENT /* 70 */:
                    constraint.layout.heightPercent = typedArray.getFloat(index, 1.0f);
                    break;
                case CHAIN_USE_RTL /* 71 */:
                    Log.e(TAG, "CURRENTLY UNSUPPORTED");
                    break;
                case BARRIER_DIRECTION /* 72 */:
                    Layout layout49 = constraint.layout;
                    layout49.mBarrierDirection = typedArray.getInt(index, layout49.mBarrierDirection);
                    break;
                case BARRIER_MARGIN /* 73 */:
                    Layout layout50 = constraint.layout;
                    layout50.mBarrierMargin = typedArray.getDimensionPixelSize(index, layout50.mBarrierMargin);
                    break;
                case CONSTRAINT_REFERENCED_IDS /* 74 */:
                    constraint.layout.mReferenceIdString = typedArray.getString(index);
                    break;
                case BARRIER_ALLOWS_GONE_WIDGETS /* 75 */:
                    Layout layout51 = constraint.layout;
                    layout51.mBarrierAllowsGoneWidgets = typedArray.getBoolean(index, layout51.mBarrierAllowsGoneWidgets);
                    break;
                case 76:
                    Motion motion3 = constraint.motion;
                    motion3.mPathMotionArc = typedArray.getInt(index, motion3.mPathMotionArc);
                    break;
                case CONSTRAINT_TAG /* 77 */:
                    constraint.layout.mConstraintTag = typedArray.getString(index);
                    break;
                case VISIBILITY_MODE /* 78 */:
                    PropertySet propertySet5 = constraint.propertySet;
                    propertySet5.mVisibilityMode = typedArray.getInt(index, propertySet5.mVisibilityMode);
                    break;
                case MOTION_STAGGER /* 79 */:
                    Motion motion4 = constraint.motion;
                    motion4.mMotionStagger = typedArray.getFloat(index, motion4.mMotionStagger);
                    break;
                case CONSTRAINED_WIDTH /* 80 */:
                    Layout layout52 = constraint.layout;
                    layout52.constrainedWidth = typedArray.getBoolean(index, layout52.constrainedWidth);
                    break;
                case CONSTRAINED_HEIGHT /* 81 */:
                    Layout layout53 = constraint.layout;
                    layout53.constrainedHeight = typedArray.getBoolean(index, layout53.constrainedHeight);
                    break;
                case ANIMATE_CIRCLE_ANGLE_TO /* 82 */:
                    Motion motion5 = constraint.motion;
                    motion5.mAnimateCircleAngleTo = typedArray.getInteger(index, motion5.mAnimateCircleAngleTo);
                    break;
                case TRANSFORM_PIVOT_TARGET /* 83 */:
                    Transform transform12 = constraint.transform;
                    transform12.transformPivotTarget = lookupID(typedArray, index, transform12.transformPivotTarget);
                    break;
                case QUANTIZE_MOTION_STEPS /* 84 */:
                    Motion motion6 = constraint.motion;
                    motion6.mQuantizeMotionSteps = typedArray.getInteger(index, motion6.mQuantizeMotionSteps);
                    break;
                case QUANTIZE_MOTION_PHASE /* 85 */:
                    Motion motion7 = constraint.motion;
                    motion7.mQuantizeMotionPhase = typedArray.getFloat(index, motion7.mQuantizeMotionPhase);
                    break;
                case QUANTIZE_MOTION_INTERPOLATOR /* 86 */:
                    int i9 = typedArray.peekValue(index).type;
                    if (i9 == 1) {
                        constraint.motion.mQuantizeInterpolatorID = typedArray.getResourceId(index, -1);
                        Motion motion8 = constraint.motion;
                        if (motion8.mQuantizeInterpolatorID != -1) {
                            motion8.mQuantizeInterpolatorType = -2;
                        }
                    } else if (i9 == 3) {
                        constraint.motion.mQuantizeInterpolatorString = typedArray.getString(index);
                        if (constraint.motion.mQuantizeInterpolatorString.indexOf("/") > 0) {
                            constraint.motion.mQuantizeInterpolatorID = typedArray.getResourceId(index, -1);
                            constraint.motion.mQuantizeInterpolatorType = -2;
                        } else {
                            constraint.motion.mQuantizeInterpolatorType = -1;
                        }
                    } else {
                        Motion motion9 = constraint.motion;
                        motion9.mQuantizeInterpolatorType = typedArray.getInteger(index, motion9.mQuantizeInterpolatorID);
                    }
                    break;
                case UNUSED /* 87 */:
                    Log.w(TAG, "unused attribute 0x" + Integer.toHexString(index) + "   " + mapToConstant.get(index));
                    break;
                case QUANTIZE_MOTION_INTERPOLATOR_TYPE /* 88 */:
                case QUANTIZE_MOTION_INTERPOLATOR_ID /* 89 */:
                case QUANTIZE_MOTION_INTERPOLATOR_STR /* 90 */:
                default:
                    Log.w(TAG, "Unknown attribute 0x" + Integer.toHexString(index) + "   " + mapToConstant.get(index));
                    break;
                case BASELINE_TO_TOP /* 91 */:
                    Layout layout54 = constraint.layout;
                    layout54.baselineToTop = lookupID(typedArray, index, layout54.baselineToTop);
                    break;
                case BASELINE_TO_BOTTOM /* 92 */:
                    Layout layout55 = constraint.layout;
                    layout55.baselineToBottom = lookupID(typedArray, index, layout55.baselineToBottom);
                    break;
                case BASELINE_MARGIN /* 93 */:
                    Layout layout56 = constraint.layout;
                    layout56.baselineMargin = typedArray.getDimensionPixelSize(index, layout56.baselineMargin);
                    break;
                case GONE_BASELINE_MARGIN /* 94 */:
                    Layout layout57 = constraint.layout;
                    layout57.goneBaselineMargin = typedArray.getDimensionPixelSize(index, layout57.goneBaselineMargin);
                    break;
                case LAYOUT_CONSTRAINT_WIDTH /* 95 */:
                    parseDimensionConstraints(constraint.layout, typedArray, index, 0);
                    break;
                case LAYOUT_CONSTRAINT_HEIGHT /* 96 */:
                    parseDimensionConstraints(constraint.layout, typedArray, index, 1);
                    break;
                case LAYOUT_WRAP_BEHAVIOR /* 97 */:
                    Layout layout58 = constraint.layout;
                    layout58.mWrapBehavior = typedArray.getInt(index, layout58.mWrapBehavior);
                    break;
            }
        }
        Layout layout59 = constraint.layout;
        if (layout59.mReferenceIdString != null) {
            layout59.mReferenceIds = null;
        }
    }

    private static void populateOverride(Context context, Constraint constraint, TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        Constraint.Delta delta = new Constraint.Delta();
        constraint.mDelta = delta;
        constraint.motion.mApply = false;
        constraint.layout.mApply = false;
        constraint.propertySet.mApply = false;
        constraint.transform.mApply = false;
        for (int i8 = 0; i8 < indexCount; i8++) {
            int index = typedArray.getIndex(i8);
            switch (overrideMapToConstant.get(index)) {
                case 2:
                    delta.add(2, typedArray.getDimensionPixelSize(index, constraint.layout.bottomMargin));
                    break;
                case 3:
                case 4:
                case 9:
                case 10:
                case 25:
                case 26:
                case 29:
                case 30:
                case 32:
                case 33:
                case 35:
                case 36:
                case CIRCLE /* 61 */:
                case QUANTIZE_MOTION_INTERPOLATOR_TYPE /* 88 */:
                case QUANTIZE_MOTION_INTERPOLATOR_ID /* 89 */:
                case QUANTIZE_MOTION_INTERPOLATOR_STR /* 90 */:
                case BASELINE_TO_TOP /* 91 */:
                case BASELINE_TO_BOTTOM /* 92 */:
                default:
                    Log.w(TAG, "Unknown attribute 0x" + Integer.toHexString(index) + "   " + mapToConstant.get(index));
                    break;
                case 5:
                    delta.add(5, typedArray.getString(index));
                    break;
                case 6:
                    delta.add(6, typedArray.getDimensionPixelOffset(index, constraint.layout.editorAbsoluteX));
                    break;
                case 7:
                    delta.add(7, typedArray.getDimensionPixelOffset(index, constraint.layout.editorAbsoluteY));
                    break;
                case 8:
                    delta.add(8, typedArray.getDimensionPixelSize(index, constraint.layout.endMargin));
                    break;
                case 11:
                    delta.add(11, typedArray.getDimensionPixelSize(index, constraint.layout.goneBottomMargin));
                    break;
                case 12:
                    delta.add(12, typedArray.getDimensionPixelSize(index, constraint.layout.goneEndMargin));
                    break;
                case 13:
                    delta.add(13, typedArray.getDimensionPixelSize(index, constraint.layout.goneLeftMargin));
                    break;
                case 14:
                    delta.add(14, typedArray.getDimensionPixelSize(index, constraint.layout.goneRightMargin));
                    break;
                case 15:
                    delta.add(15, typedArray.getDimensionPixelSize(index, constraint.layout.goneStartMargin));
                    break;
                case 16:
                    delta.add(16, typedArray.getDimensionPixelSize(index, constraint.layout.goneTopMargin));
                    break;
                case 17:
                    delta.add(17, typedArray.getDimensionPixelOffset(index, constraint.layout.guideBegin));
                    break;
                case 18:
                    delta.add(18, typedArray.getDimensionPixelOffset(index, constraint.layout.guideEnd));
                    break;
                case 19:
                    delta.add(19, typedArray.getFloat(index, constraint.layout.guidePercent));
                    break;
                case 20:
                    delta.add(20, typedArray.getFloat(index, constraint.layout.horizontalBias));
                    break;
                case 21:
                    delta.add(21, typedArray.getLayoutDimension(index, constraint.layout.mHeight));
                    break;
                case 22:
                    delta.add(22, VISIBILITY_FLAGS[typedArray.getInt(index, constraint.propertySet.visibility)]);
                    break;
                case 23:
                    delta.add(23, typedArray.getLayoutDimension(index, constraint.layout.mWidth));
                    break;
                case 24:
                    delta.add(24, typedArray.getDimensionPixelSize(index, constraint.layout.leftMargin));
                    break;
                case 27:
                    delta.add(27, typedArray.getInt(index, constraint.layout.orientation));
                    break;
                case 28:
                    delta.add(28, typedArray.getDimensionPixelSize(index, constraint.layout.rightMargin));
                    break;
                case 31:
                    delta.add(31, typedArray.getDimensionPixelSize(index, constraint.layout.startMargin));
                    break;
                case 34:
                    delta.add(34, typedArray.getDimensionPixelSize(index, constraint.layout.topMargin));
                    break;
                case 37:
                    delta.add(37, typedArray.getFloat(index, constraint.layout.verticalBias));
                    break;
                case 38:
                    int resourceId = typedArray.getResourceId(index, constraint.mViewId);
                    constraint.mViewId = resourceId;
                    delta.add(38, resourceId);
                    break;
                case 39:
                    delta.add(39, typedArray.getFloat(index, constraint.layout.horizontalWeight));
                    break;
                case 40:
                    delta.add(40, typedArray.getFloat(index, constraint.layout.verticalWeight));
                    break;
                case 41:
                    delta.add(41, typedArray.getInt(index, constraint.layout.horizontalChainStyle));
                    break;
                case 42:
                    delta.add(42, typedArray.getInt(index, constraint.layout.verticalChainStyle));
                    break;
                case 43:
                    delta.add(43, typedArray.getFloat(index, constraint.propertySet.alpha));
                    break;
                case 44:
                    delta.add(44, true);
                    delta.add(44, typedArray.getDimension(index, constraint.transform.elevation));
                    break;
                case 45:
                    delta.add(45, typedArray.getFloat(index, constraint.transform.rotationX));
                    break;
                case 46:
                    delta.add(46, typedArray.getFloat(index, constraint.transform.rotationY));
                    break;
                case 47:
                    delta.add(47, typedArray.getFloat(index, constraint.transform.scaleX));
                    break;
                case 48:
                    delta.add(48, typedArray.getFloat(index, constraint.transform.scaleY));
                    break;
                case 49:
                    delta.add(49, typedArray.getDimension(index, constraint.transform.transformPivotX));
                    break;
                case 50:
                    delta.add(50, typedArray.getDimension(index, constraint.transform.transformPivotY));
                    break;
                case 51:
                    delta.add(51, typedArray.getDimension(index, constraint.transform.translationX));
                    break;
                case 52:
                    delta.add(52, typedArray.getDimension(index, constraint.transform.translationY));
                    break;
                case 53:
                    delta.add(53, typedArray.getDimension(index, constraint.transform.translationZ));
                    break;
                case 54:
                    delta.add(54, typedArray.getInt(index, constraint.layout.widthDefault));
                    break;
                case 55:
                    delta.add(55, typedArray.getInt(index, constraint.layout.heightDefault));
                    break;
                case WIDTH_MAX /* 56 */:
                    delta.add(WIDTH_MAX, typedArray.getDimensionPixelSize(index, constraint.layout.widthMax));
                    break;
                case HEIGHT_MAX /* 57 */:
                    delta.add(HEIGHT_MAX, typedArray.getDimensionPixelSize(index, constraint.layout.heightMax));
                    break;
                case WIDTH_MIN /* 58 */:
                    delta.add(WIDTH_MIN, typedArray.getDimensionPixelSize(index, constraint.layout.widthMin));
                    break;
                case HEIGHT_MIN /* 59 */:
                    delta.add(HEIGHT_MIN, typedArray.getDimensionPixelSize(index, constraint.layout.heightMin));
                    break;
                case ROTATION /* 60 */:
                    delta.add(ROTATION, typedArray.getFloat(index, constraint.transform.rotation));
                    break;
                case CIRCLE_RADIUS /* 62 */:
                    delta.add(CIRCLE_RADIUS, typedArray.getDimensionPixelSize(index, constraint.layout.circleRadius));
                    break;
                case 63:
                    delta.add(63, typedArray.getFloat(index, constraint.layout.circleAngle));
                    break;
                case 64:
                    delta.add(64, lookupID(typedArray, index, constraint.motion.mAnimateRelativeTo));
                    break;
                case 65:
                    if (typedArray.peekValue(index).type == 3) {
                        delta.add(65, typedArray.getString(index));
                    } else {
                        delta.add(65, Easing.NAMED_EASING[typedArray.getInteger(index, 0)]);
                    }
                    break;
                case 66:
                    delta.add(66, typedArray.getInt(index, 0));
                    break;
                case 67:
                    delta.add(67, typedArray.getFloat(index, constraint.motion.mPathRotate));
                    break;
                case PROGRESS /* 68 */:
                    delta.add(PROGRESS, typedArray.getFloat(index, constraint.propertySet.mProgress));
                    break;
                case WIDTH_PERCENT /* 69 */:
                    delta.add(WIDTH_PERCENT, typedArray.getFloat(index, 1.0f));
                    break;
                case HEIGHT_PERCENT /* 70 */:
                    delta.add(HEIGHT_PERCENT, typedArray.getFloat(index, 1.0f));
                    break;
                case CHAIN_USE_RTL /* 71 */:
                    Log.e(TAG, "CURRENTLY UNSUPPORTED");
                    break;
                case BARRIER_DIRECTION /* 72 */:
                    delta.add(BARRIER_DIRECTION, typedArray.getInt(index, constraint.layout.mBarrierDirection));
                    break;
                case BARRIER_MARGIN /* 73 */:
                    delta.add(BARRIER_MARGIN, typedArray.getDimensionPixelSize(index, constraint.layout.mBarrierMargin));
                    break;
                case CONSTRAINT_REFERENCED_IDS /* 74 */:
                    delta.add(CONSTRAINT_REFERENCED_IDS, typedArray.getString(index));
                    break;
                case BARRIER_ALLOWS_GONE_WIDGETS /* 75 */:
                    delta.add(BARRIER_ALLOWS_GONE_WIDGETS, typedArray.getBoolean(index, constraint.layout.mBarrierAllowsGoneWidgets));
                    break;
                case 76:
                    delta.add(76, typedArray.getInt(index, constraint.motion.mPathMotionArc));
                    break;
                case CONSTRAINT_TAG /* 77 */:
                    delta.add(CONSTRAINT_TAG, typedArray.getString(index));
                    break;
                case VISIBILITY_MODE /* 78 */:
                    delta.add(VISIBILITY_MODE, typedArray.getInt(index, constraint.propertySet.mVisibilityMode));
                    break;
                case MOTION_STAGGER /* 79 */:
                    delta.add(MOTION_STAGGER, typedArray.getFloat(index, constraint.motion.mMotionStagger));
                    break;
                case CONSTRAINED_WIDTH /* 80 */:
                    delta.add(CONSTRAINED_WIDTH, typedArray.getBoolean(index, constraint.layout.constrainedWidth));
                    break;
                case CONSTRAINED_HEIGHT /* 81 */:
                    delta.add(CONSTRAINED_HEIGHT, typedArray.getBoolean(index, constraint.layout.constrainedHeight));
                    break;
                case ANIMATE_CIRCLE_ANGLE_TO /* 82 */:
                    delta.add(ANIMATE_CIRCLE_ANGLE_TO, typedArray.getInteger(index, constraint.motion.mAnimateCircleAngleTo));
                    break;
                case TRANSFORM_PIVOT_TARGET /* 83 */:
                    delta.add(TRANSFORM_PIVOT_TARGET, lookupID(typedArray, index, constraint.transform.transformPivotTarget));
                    break;
                case QUANTIZE_MOTION_STEPS /* 84 */:
                    delta.add(QUANTIZE_MOTION_STEPS, typedArray.getInteger(index, constraint.motion.mQuantizeMotionSteps));
                    break;
                case QUANTIZE_MOTION_PHASE /* 85 */:
                    delta.add(QUANTIZE_MOTION_PHASE, typedArray.getFloat(index, constraint.motion.mQuantizeMotionPhase));
                    break;
                case QUANTIZE_MOTION_INTERPOLATOR /* 86 */:
                    int i9 = typedArray.peekValue(index).type;
                    if (i9 == 1) {
                        constraint.motion.mQuantizeInterpolatorID = typedArray.getResourceId(index, -1);
                        delta.add(QUANTIZE_MOTION_INTERPOLATOR_ID, constraint.motion.mQuantizeInterpolatorID);
                        Motion motion = constraint.motion;
                        if (motion.mQuantizeInterpolatorID != -1) {
                            motion.mQuantizeInterpolatorType = -2;
                            delta.add(QUANTIZE_MOTION_INTERPOLATOR_TYPE, -2);
                        }
                    } else if (i9 == 3) {
                        constraint.motion.mQuantizeInterpolatorString = typedArray.getString(index);
                        delta.add(QUANTIZE_MOTION_INTERPOLATOR_STR, constraint.motion.mQuantizeInterpolatorString);
                        if (constraint.motion.mQuantizeInterpolatorString.indexOf("/") > 0) {
                            constraint.motion.mQuantizeInterpolatorID = typedArray.getResourceId(index, -1);
                            delta.add(QUANTIZE_MOTION_INTERPOLATOR_ID, constraint.motion.mQuantizeInterpolatorID);
                            constraint.motion.mQuantizeInterpolatorType = -2;
                            delta.add(QUANTIZE_MOTION_INTERPOLATOR_TYPE, -2);
                        } else {
                            constraint.motion.mQuantizeInterpolatorType = -1;
                            delta.add(QUANTIZE_MOTION_INTERPOLATOR_TYPE, -1);
                        }
                    } else {
                        Motion motion2 = constraint.motion;
                        motion2.mQuantizeInterpolatorType = typedArray.getInteger(index, motion2.mQuantizeInterpolatorID);
                        delta.add(QUANTIZE_MOTION_INTERPOLATOR_TYPE, constraint.motion.mQuantizeInterpolatorType);
                    }
                    break;
                case UNUSED /* 87 */:
                    Log.w(TAG, "unused attribute 0x" + Integer.toHexString(index) + "   " + mapToConstant.get(index));
                    break;
                case BASELINE_MARGIN /* 93 */:
                    delta.add(BASELINE_MARGIN, typedArray.getDimensionPixelSize(index, constraint.layout.baselineMargin));
                    break;
                case GONE_BASELINE_MARGIN /* 94 */:
                    delta.add(GONE_BASELINE_MARGIN, typedArray.getDimensionPixelSize(index, constraint.layout.goneBaselineMargin));
                    break;
                case LAYOUT_CONSTRAINT_WIDTH /* 95 */:
                    parseDimensionConstraints(delta, typedArray, index, 0);
                    break;
                case LAYOUT_CONSTRAINT_HEIGHT /* 96 */:
                    parseDimensionConstraints(delta, typedArray, index, 1);
                    break;
                case LAYOUT_WRAP_BEHAVIOR /* 97 */:
                    delta.add(LAYOUT_WRAP_BEHAVIOR, typedArray.getInt(index, constraint.layout.mWrapBehavior));
                    break;
                case MOTION_TARGET /* 98 */:
                    if (MotionLayout.IS_IN_EDIT_MODE) {
                        int resourceId2 = typedArray.getResourceId(index, constraint.mViewId);
                        constraint.mViewId = resourceId2;
                        if (resourceId2 == -1) {
                            constraint.mTargetString = typedArray.getString(index);
                        }
                    } else if (typedArray.peekValue(index).type == 3) {
                        constraint.mTargetString = typedArray.getString(index);
                    } else {
                        constraint.mViewId = typedArray.getResourceId(index, constraint.mViewId);
                    }
                    break;
                case GUIDELINE_USE_RTL /* 99 */:
                    delta.add(GUIDELINE_USE_RTL, typedArray.getBoolean(index, constraint.layout.guidelineUseRtl));
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setDeltaValue(Constraint constraint, int i8, float f) {
        if (i8 == 19) {
            constraint.layout.guidePercent = f;
        }
        if (i8 == 20) {
            constraint.layout.horizontalBias = f;
            return;
        }
        if (i8 == 37) {
            constraint.layout.verticalBias = f;
            return;
        }
        if (i8 == ROTATION) {
            constraint.transform.rotation = f;
            return;
        }
        if (i8 == 63) {
            constraint.layout.circleAngle = f;
            return;
        }
        if (i8 == MOTION_STAGGER) {
            constraint.motion.mMotionStagger = f;
            return;
        }
        if (i8 == QUANTIZE_MOTION_PHASE) {
            constraint.motion.mQuantizeMotionPhase = f;
            return;
        }
        if (i8 != UNUSED) {
            if (i8 == 39) {
                constraint.layout.horizontalWeight = f;
                return;
            }
            if (i8 == 40) {
                constraint.layout.verticalWeight = f;
                return;
            }
            switch (i8) {
                case 43:
                    constraint.propertySet.alpha = f;
                    break;
                case 44:
                    Transform transform = constraint.transform;
                    transform.elevation = f;
                    transform.applyElevation = true;
                    break;
                case 45:
                    constraint.transform.rotationX = f;
                    break;
                case 46:
                    constraint.transform.rotationY = f;
                    break;
                case 47:
                    constraint.transform.scaleX = f;
                    break;
                case 48:
                    constraint.transform.scaleY = f;
                    break;
                case 49:
                    constraint.transform.transformPivotX = f;
                    break;
                case 50:
                    constraint.transform.transformPivotY = f;
                    break;
                case 51:
                    constraint.transform.translationX = f;
                    break;
                case 52:
                    constraint.transform.translationY = f;
                    break;
                case 53:
                    constraint.transform.translationZ = f;
                    break;
                default:
                    switch (i8) {
                        case 67:
                            constraint.motion.mPathRotate = f;
                            break;
                        case PROGRESS /* 68 */:
                            constraint.propertySet.mProgress = f;
                            break;
                        case WIDTH_PERCENT /* 69 */:
                            constraint.layout.widthPercent = f;
                            break;
                        case HEIGHT_PERCENT /* 70 */:
                            constraint.layout.heightPercent = f;
                            break;
                        default:
                            Log.w(TAG, "Unknown attribute 0x");
                            break;
                    }
                    break;
            }
        }
    }

    private String sideToString(int i8) {
        switch (i8) {
            case 1:
                return "left";
            case 2:
                return "right";
            case 3:
                return "top";
            case 4:
                return "bottom";
            case 5:
                return "baseline";
            case 6:
                return "start";
            case 7:
                return "end";
            default:
                return "undefined";
        }
    }

    private static String[] splitString(String str) {
        char[] charArray = str.toCharArray();
        ArrayList arrayList = new ArrayList();
        int i8 = 0;
        boolean z2 = false;
        for (int i9 = 0; i9 < charArray.length; i9++) {
            char c9 = charArray[i9];
            if (c9 == ',' && !z2) {
                arrayList.add(new String(charArray, i8, i9 - i8));
                i8 = i9 + 1;
            } else if (c9 == '\"') {
                z2 = !z2;
            }
        }
        arrayList.add(new String(charArray, i8, charArray.length - i8));
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public void addColorAttributes(String... strArr) {
        addAttributes(ConstraintAttribute.AttributeType.COLOR_TYPE, strArr);
    }

    public void addFloatAttributes(String... strArr) {
        addAttributes(ConstraintAttribute.AttributeType.FLOAT_TYPE, strArr);
    }

    public void addIntAttributes(String... strArr) {
        addAttributes(ConstraintAttribute.AttributeType.INT_TYPE, strArr);
    }

    public void addStringAttributes(String... strArr) {
        addAttributes(ConstraintAttribute.AttributeType.STRING_TYPE, strArr);
    }

    public void addToHorizontalChain(int i8, int i9, int i10) {
        connect(i8, 1, i9, i9 == 0 ? 1 : 2, 0);
        connect(i8, 2, i10, i10 == 0 ? 2 : 1, 0);
        if (i9 != 0) {
            connect(i9, 2, i8, 1, 0);
        }
        if (i10 != 0) {
            connect(i10, 1, i8, 2, 0);
        }
    }

    public void addToHorizontalChainRTL(int i8, int i9, int i10) {
        connect(i8, 6, i9, i9 == 0 ? 6 : 7, 0);
        connect(i8, 7, i10, i10 == 0 ? 7 : 6, 0);
        if (i9 != 0) {
            connect(i9, 7, i8, 6, 0);
        }
        if (i10 != 0) {
            connect(i10, 6, i8, 7, 0);
        }
    }

    public void addToVerticalChain(int i8, int i9, int i10) {
        connect(i8, 3, i9, i9 == 0 ? 3 : 4, 0);
        connect(i8, 4, i10, i10 == 0 ? 4 : 3, 0);
        if (i9 != 0) {
            connect(i9, 4, i8, 3, 0);
        }
        if (i10 != 0) {
            connect(i10, 3, i8, 4, 0);
        }
    }

    public void applyCustomAttributes(ConstraintLayout constraintLayout) {
        Constraint constraint;
        int childCount = constraintLayout.getChildCount();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = constraintLayout.getChildAt(i8);
            int id2 = childAt.getId();
            if (!this.mConstraints.containsKey(Integer.valueOf(id2))) {
                Log.w(TAG, "id unknown " + Debug.getName(childAt));
            } else {
                if (this.mForceId && id2 == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (this.mConstraints.containsKey(Integer.valueOf(id2)) && (constraint = this.mConstraints.get(Integer.valueOf(id2))) != null) {
                    ConstraintAttribute.setAttributes(childAt, constraint.mCustomConstraints);
                }
            }
        }
    }

    public void applyDeltaFrom(ConstraintSet constraintSet) {
        for (Constraint constraint : constraintSet.mConstraints.values()) {
            if (constraint.mDelta != null) {
                if (constraint.mTargetString != null) {
                    Iterator<Integer> it = this.mConstraints.keySet().iterator();
                    while (it.hasNext()) {
                        Constraint constraint2 = getConstraint(it.next().intValue());
                        String str = constraint2.layout.mConstraintTag;
                        if (str != null && constraint.mTargetString.matches(str)) {
                            constraint.mDelta.applyDelta(constraint2);
                            constraint2.mCustomConstraints.putAll((HashMap) constraint.mCustomConstraints.clone());
                        }
                    }
                } else {
                    constraint.mDelta.applyDelta(getConstraint(constraint.mViewId));
                }
            }
        }
    }

    public void applyTo(ConstraintLayout constraintLayout) {
        applyToInternal(constraintLayout, true);
        constraintLayout.setConstraintSet(null);
        constraintLayout.requestLayout();
    }

    public void applyToHelper(ConstraintHelper constraintHelper, ConstraintWidget constraintWidget, ConstraintLayout.LayoutParams layoutParams, SparseArray<ConstraintWidget> sparseArray) {
        Constraint constraint;
        int id2 = constraintHelper.getId();
        if (this.mConstraints.containsKey(Integer.valueOf(id2)) && (constraint = this.mConstraints.get(Integer.valueOf(id2))) != null && (constraintWidget instanceof HelperWidget)) {
            constraintHelper.loadParameters(constraint, (HelperWidget) constraintWidget, layoutParams, sparseArray);
        }
    }

    public void applyToInternal(ConstraintLayout constraintLayout, boolean z2) {
        int childCount = constraintLayout.getChildCount();
        HashSet<Integer> hashSet = new HashSet(this.mConstraints.keySet());
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = constraintLayout.getChildAt(i8);
            int id2 = childAt.getId();
            if (!this.mConstraints.containsKey(Integer.valueOf(id2))) {
                Log.w(TAG, "id unknown " + Debug.getName(childAt));
            } else {
                if (this.mForceId && id2 == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (id2 != -1) {
                    if (this.mConstraints.containsKey(Integer.valueOf(id2))) {
                        hashSet.remove(Integer.valueOf(id2));
                        Constraint constraint = this.mConstraints.get(Integer.valueOf(id2));
                        if (constraint != null) {
                            if (childAt instanceof Barrier) {
                                constraint.layout.mHelperType = 1;
                                Barrier barrier = (Barrier) childAt;
                                barrier.setId(id2);
                                barrier.setType(constraint.layout.mBarrierDirection);
                                barrier.setMargin(constraint.layout.mBarrierMargin);
                                barrier.setAllowsGoneWidget(constraint.layout.mBarrierAllowsGoneWidgets);
                                Layout layout = constraint.layout;
                                int[] iArr = layout.mReferenceIds;
                                if (iArr != null) {
                                    barrier.setReferencedIds(iArr);
                                } else {
                                    String str = layout.mReferenceIdString;
                                    if (str != null) {
                                        layout.mReferenceIds = convertReferenceString(barrier, str);
                                        barrier.setReferencedIds(constraint.layout.mReferenceIds);
                                    }
                                }
                            }
                            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
                            layoutParams.validate();
                            constraint.applyTo(layoutParams);
                            if (z2) {
                                ConstraintAttribute.setAttributes(childAt, constraint.mCustomConstraints);
                            }
                            childAt.setLayoutParams(layoutParams);
                            PropertySet propertySet = constraint.propertySet;
                            if (propertySet.mVisibilityMode == 0) {
                                childAt.setVisibility(propertySet.visibility);
                            }
                            childAt.setAlpha(constraint.propertySet.alpha);
                            childAt.setRotation(constraint.transform.rotation);
                            childAt.setRotationX(constraint.transform.rotationX);
                            childAt.setRotationY(constraint.transform.rotationY);
                            childAt.setScaleX(constraint.transform.scaleX);
                            childAt.setScaleY(constraint.transform.scaleY);
                            Transform transform = constraint.transform;
                            if (transform.transformPivotTarget != -1) {
                                View viewFindViewById = ((View) childAt.getParent()).findViewById(constraint.transform.transformPivotTarget);
                                if (viewFindViewById != null) {
                                    float bottom = (viewFindViewById.getBottom() + viewFindViewById.getTop()) / 2.0f;
                                    float right = (viewFindViewById.getRight() + viewFindViewById.getLeft()) / 2.0f;
                                    if (childAt.getRight() - childAt.getLeft() > 0 && childAt.getBottom() - childAt.getTop() > 0) {
                                        float left = right - childAt.getLeft();
                                        float top = bottom - childAt.getTop();
                                        childAt.setPivotX(left);
                                        childAt.setPivotY(top);
                                    }
                                }
                            } else {
                                if (!Float.isNaN(transform.transformPivotX)) {
                                    childAt.setPivotX(constraint.transform.transformPivotX);
                                }
                                if (!Float.isNaN(constraint.transform.transformPivotY)) {
                                    childAt.setPivotY(constraint.transform.transformPivotY);
                                }
                            }
                            childAt.setTranslationX(constraint.transform.translationX);
                            childAt.setTranslationY(constraint.transform.translationY);
                            childAt.setTranslationZ(constraint.transform.translationZ);
                            Transform transform2 = constraint.transform;
                            if (transform2.applyElevation) {
                                childAt.setElevation(transform2.elevation);
                            }
                        }
                    } else {
                        Log.v(TAG, "WARNING NO CONSTRAINTS for view " + id2);
                    }
                }
            }
        }
        for (Integer num : hashSet) {
            Constraint constraint2 = this.mConstraints.get(num);
            if (constraint2 != null) {
                if (constraint2.layout.mHelperType == 1) {
                    Barrier barrier2 = new Barrier(constraintLayout.getContext());
                    barrier2.setId(num.intValue());
                    Layout layout2 = constraint2.layout;
                    int[] iArr2 = layout2.mReferenceIds;
                    if (iArr2 != null) {
                        barrier2.setReferencedIds(iArr2);
                    } else {
                        String str2 = layout2.mReferenceIdString;
                        if (str2 != null) {
                            layout2.mReferenceIds = convertReferenceString(barrier2, str2);
                            barrier2.setReferencedIds(constraint2.layout.mReferenceIds);
                        }
                    }
                    barrier2.setType(constraint2.layout.mBarrierDirection);
                    barrier2.setMargin(constraint2.layout.mBarrierMargin);
                    ConstraintLayout.LayoutParams layoutParamsGenerateDefaultLayoutParams = constraintLayout.generateDefaultLayoutParams();
                    barrier2.validateParams();
                    constraint2.applyTo(layoutParamsGenerateDefaultLayoutParams);
                    constraintLayout.addView(barrier2, layoutParamsGenerateDefaultLayoutParams);
                }
                if (constraint2.layout.mIsGuideline) {
                    View guideline = new Guideline(constraintLayout.getContext());
                    guideline.setId(num.intValue());
                    ConstraintLayout.LayoutParams layoutParamsGenerateDefaultLayoutParams2 = constraintLayout.generateDefaultLayoutParams();
                    constraint2.applyTo(layoutParamsGenerateDefaultLayoutParams2);
                    constraintLayout.addView(guideline, layoutParamsGenerateDefaultLayoutParams2);
                }
            }
        }
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt2 = constraintLayout.getChildAt(i9);
            if (childAt2 instanceof ConstraintHelper) {
                ((ConstraintHelper) childAt2).applyLayoutFeaturesInConstraintSet(constraintLayout);
            }
        }
    }

    public void applyToLayoutParams(int i8, ConstraintLayout.LayoutParams layoutParams) {
        Constraint constraint;
        if (!this.mConstraints.containsKey(Integer.valueOf(i8)) || (constraint = this.mConstraints.get(Integer.valueOf(i8))) == null) {
            return;
        }
        constraint.applyTo(layoutParams);
    }

    public void applyToWithoutCustom(ConstraintLayout constraintLayout) {
        applyToInternal(constraintLayout, false);
        constraintLayout.setConstraintSet(null);
    }

    public void center(int i8, int i9, int i10, int i11, int i12, int i13, int i14, float f) {
        if (i11 < 0) {
            throw new IllegalArgumentException("margin must be > 0");
        }
        if (i14 < 0) {
            throw new IllegalArgumentException("margin must be > 0");
        }
        if (f <= 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("bias must be between 0 and 1 inclusive");
        }
        if (i10 == 1 || i10 == 2) {
            connect(i8, 1, i9, i10, i11);
            connect(i8, 2, i12, i13, i14);
            Constraint constraint = this.mConstraints.get(Integer.valueOf(i8));
            if (constraint != null) {
                constraint.layout.horizontalBias = f;
                return;
            }
            return;
        }
        if (i10 == 6 || i10 == 7) {
            connect(i8, 6, i9, i10, i11);
            connect(i8, 7, i12, i13, i14);
            Constraint constraint2 = this.mConstraints.get(Integer.valueOf(i8));
            if (constraint2 != null) {
                constraint2.layout.horizontalBias = f;
                return;
            }
            return;
        }
        connect(i8, 3, i9, i10, i11);
        connect(i8, 4, i12, i13, i14);
        Constraint constraint3 = this.mConstraints.get(Integer.valueOf(i8));
        if (constraint3 != null) {
            constraint3.layout.verticalBias = f;
        }
    }

    public void centerHorizontally(int i8, int i9, int i10, int i11, int i12, int i13, int i14, float f) {
        connect(i8, 1, i9, i10, i11);
        connect(i8, 2, i12, i13, i14);
        Constraint constraint = this.mConstraints.get(Integer.valueOf(i8));
        if (constraint != null) {
            constraint.layout.horizontalBias = f;
        }
    }

    public void centerHorizontallyRtl(int i8, int i9, int i10, int i11, int i12, int i13, int i14, float f) {
        connect(i8, 6, i9, i10, i11);
        connect(i8, 7, i12, i13, i14);
        Constraint constraint = this.mConstraints.get(Integer.valueOf(i8));
        if (constraint != null) {
            constraint.layout.horizontalBias = f;
        }
    }

    public void centerVertically(int i8, int i9, int i10, int i11, int i12, int i13, int i14, float f) {
        connect(i8, 3, i9, i10, i11);
        connect(i8, 4, i12, i13, i14);
        Constraint constraint = this.mConstraints.get(Integer.valueOf(i8));
        if (constraint != null) {
            constraint.layout.verticalBias = f;
        }
    }

    public void clear(int i8) {
        this.mConstraints.remove(Integer.valueOf(i8));
    }

    public void clone(Context context, int i8) {
        clone((ConstraintLayout) LayoutInflater.from(context).inflate(i8, (ViewGroup) null));
    }

    public void connect(int i8, int i9, int i10, int i11, int i12) {
        if (!this.mConstraints.containsKey(Integer.valueOf(i8))) {
            this.mConstraints.put(Integer.valueOf(i8), new Constraint());
        }
        Constraint constraint = this.mConstraints.get(Integer.valueOf(i8));
        if (constraint == null) {
            return;
        }
        switch (i9) {
            case 1:
                if (i11 == 1) {
                    Layout layout = constraint.layout;
                    layout.leftToLeft = i10;
                    layout.leftToRight = -1;
                } else {
                    if (i11 != 2) {
                        throw new IllegalArgumentException(h0.a.n(new StringBuilder("Left to "), sideToString(i11), " undefined"));
                    }
                    Layout layout2 = constraint.layout;
                    layout2.leftToRight = i10;
                    layout2.leftToLeft = -1;
                }
                constraint.layout.leftMargin = i12;
                return;
            case 2:
                if (i11 == 1) {
                    Layout layout3 = constraint.layout;
                    layout3.rightToLeft = i10;
                    layout3.rightToRight = -1;
                } else {
                    if (i11 != 2) {
                        throw new IllegalArgumentException(h0.a.n(new StringBuilder("right to "), sideToString(i11), " undefined"));
                    }
                    Layout layout4 = constraint.layout;
                    layout4.rightToRight = i10;
                    layout4.rightToLeft = -1;
                }
                constraint.layout.rightMargin = i12;
                return;
            case 3:
                if (i11 == 3) {
                    Layout layout5 = constraint.layout;
                    layout5.topToTop = i10;
                    layout5.topToBottom = -1;
                    layout5.baselineToBaseline = -1;
                    layout5.baselineToTop = -1;
                    layout5.baselineToBottom = -1;
                } else {
                    if (i11 != 4) {
                        throw new IllegalArgumentException(h0.a.n(new StringBuilder("right to "), sideToString(i11), " undefined"));
                    }
                    Layout layout6 = constraint.layout;
                    layout6.topToBottom = i10;
                    layout6.topToTop = -1;
                    layout6.baselineToBaseline = -1;
                    layout6.baselineToTop = -1;
                    layout6.baselineToBottom = -1;
                }
                constraint.layout.topMargin = i12;
                return;
            case 4:
                if (i11 == 4) {
                    Layout layout7 = constraint.layout;
                    layout7.bottomToBottom = i10;
                    layout7.bottomToTop = -1;
                    layout7.baselineToBaseline = -1;
                    layout7.baselineToTop = -1;
                    layout7.baselineToBottom = -1;
                } else {
                    if (i11 != 3) {
                        throw new IllegalArgumentException(h0.a.n(new StringBuilder("right to "), sideToString(i11), " undefined"));
                    }
                    Layout layout8 = constraint.layout;
                    layout8.bottomToTop = i10;
                    layout8.bottomToBottom = -1;
                    layout8.baselineToBaseline = -1;
                    layout8.baselineToTop = -1;
                    layout8.baselineToBottom = -1;
                }
                constraint.layout.bottomMargin = i12;
                return;
            case 5:
                if (i11 == 5) {
                    Layout layout9 = constraint.layout;
                    layout9.baselineToBaseline = i10;
                    layout9.bottomToBottom = -1;
                    layout9.bottomToTop = -1;
                    layout9.topToTop = -1;
                    layout9.topToBottom = -1;
                    return;
                }
                if (i11 == 3) {
                    Layout layout10 = constraint.layout;
                    layout10.baselineToTop = i10;
                    layout10.bottomToBottom = -1;
                    layout10.bottomToTop = -1;
                    layout10.topToTop = -1;
                    layout10.topToBottom = -1;
                    return;
                }
                if (i11 != 4) {
                    throw new IllegalArgumentException(h0.a.n(new StringBuilder("right to "), sideToString(i11), " undefined"));
                }
                Layout layout11 = constraint.layout;
                layout11.baselineToBottom = i10;
                layout11.bottomToBottom = -1;
                layout11.bottomToTop = -1;
                layout11.topToTop = -1;
                layout11.topToBottom = -1;
                return;
            case 6:
                if (i11 == 6) {
                    Layout layout12 = constraint.layout;
                    layout12.startToStart = i10;
                    layout12.startToEnd = -1;
                } else {
                    if (i11 != 7) {
                        throw new IllegalArgumentException(h0.a.n(new StringBuilder("right to "), sideToString(i11), " undefined"));
                    }
                    Layout layout13 = constraint.layout;
                    layout13.startToEnd = i10;
                    layout13.startToStart = -1;
                }
                constraint.layout.startMargin = i12;
                return;
            case 7:
                if (i11 == 7) {
                    Layout layout14 = constraint.layout;
                    layout14.endToEnd = i10;
                    layout14.endToStart = -1;
                } else {
                    if (i11 != 6) {
                        throw new IllegalArgumentException(h0.a.n(new StringBuilder("right to "), sideToString(i11), " undefined"));
                    }
                    Layout layout15 = constraint.layout;
                    layout15.endToStart = i10;
                    layout15.endToEnd = -1;
                }
                constraint.layout.endMargin = i12;
                return;
            default:
                StringBuilder sb2 = new StringBuilder();
                sb2.append(sideToString(i9));
                sb2.append(" to ");
                throw new IllegalArgumentException(h0.a.n(sb2, sideToString(i11), " unknown"));
        }
    }

    public void constrainCircle(int i8, int i9, int i10, float f) {
        Layout layout = get(i8).layout;
        layout.circleConstraint = i9;
        layout.circleRadius = i10;
        layout.circleAngle = f;
    }

    public void constrainDefaultHeight(int i8, int i9) {
        get(i8).layout.heightDefault = i9;
    }

    public void constrainDefaultWidth(int i8, int i9) {
        get(i8).layout.widthDefault = i9;
    }

    public void constrainHeight(int i8, int i9) {
        get(i8).layout.mHeight = i9;
    }

    public void constrainMaxHeight(int i8, int i9) {
        get(i8).layout.heightMax = i9;
    }

    public void constrainMaxWidth(int i8, int i9) {
        get(i8).layout.widthMax = i9;
    }

    public void constrainMinHeight(int i8, int i9) {
        get(i8).layout.heightMin = i9;
    }

    public void constrainMinWidth(int i8, int i9) {
        get(i8).layout.widthMin = i9;
    }

    public void constrainPercentHeight(int i8, float f) {
        get(i8).layout.heightPercent = f;
    }

    public void constrainPercentWidth(int i8, float f) {
        get(i8).layout.widthPercent = f;
    }

    public void constrainWidth(int i8, int i9) {
        get(i8).layout.mWidth = i9;
    }

    public void constrainedHeight(int i8, boolean z2) {
        get(i8).layout.constrainedHeight = z2;
    }

    public void constrainedWidth(int i8, boolean z2) {
        get(i8).layout.constrainedWidth = z2;
    }

    public void create(int i8, int i9) {
        Layout layout = get(i8).layout;
        layout.mIsGuideline = true;
        layout.orientation = i9;
    }

    public void createBarrier(int i8, int i9, int i10, int... iArr) {
        Layout layout = get(i8).layout;
        layout.mHelperType = 1;
        layout.mBarrierDirection = i9;
        layout.mBarrierMargin = i10;
        layout.mIsGuideline = false;
        layout.mReferenceIds = iArr;
    }

    public void createHorizontalChain(int i8, int i9, int i10, int i11, int[] iArr, float[] fArr, int i12) {
        createHorizontalChain(i8, i9, i10, i11, iArr, fArr, i12, 1, 2);
    }

    public void createHorizontalChainRtl(int i8, int i9, int i10, int i11, int[] iArr, float[] fArr, int i12) {
        createHorizontalChain(i8, i9, i10, i11, iArr, fArr, i12, 6, 7);
    }

    public void createVerticalChain(int i8, int i9, int i10, int i11, int[] iArr, float[] fArr, int i12) {
        if (iArr.length < 2) {
            throw new IllegalArgumentException("must have 2 or more widgets in a chain");
        }
        if (fArr != null && fArr.length != iArr.length) {
            throw new IllegalArgumentException("must have 2 or more widgets in a chain");
        }
        if (fArr != null) {
            get(iArr[0]).layout.verticalWeight = fArr[0];
        }
        get(iArr[0]).layout.verticalChainStyle = i12;
        connect(iArr[0], 3, i8, i9, 0);
        for (int i13 = 1; i13 < iArr.length; i13++) {
            int i14 = i13 - 1;
            connect(iArr[i13], 3, iArr[i14], 4, 0);
            connect(iArr[i14], 4, iArr[i13], 3, 0);
            if (fArr != null) {
                get(iArr[i13]).layout.verticalWeight = fArr[i13];
            }
        }
        connect(iArr[iArr.length - 1], 4, i10, i11, 0);
    }

    public void dump(MotionScene motionScene, int... iArr) {
        HashSet hashSet;
        Set<Integer> setKeySet = this.mConstraints.keySet();
        if (iArr.length != 0) {
            hashSet = new HashSet();
            for (int i8 : iArr) {
                hashSet.add(Integer.valueOf(i8));
            }
        } else {
            hashSet = new HashSet(setKeySet);
        }
        System.out.println(hashSet.size() + " constraints");
        StringBuilder sb2 = new StringBuilder();
        for (Integer num : (Integer[]) hashSet.toArray(new Integer[0])) {
            Constraint constraint = this.mConstraints.get(num);
            if (constraint != null) {
                sb2.append("<Constraint id=");
                sb2.append(num);
                sb2.append(" \n");
                constraint.layout.dump(motionScene, sb2);
                sb2.append("/>\n");
            }
        }
        System.out.println(sb2.toString());
    }

    public boolean getApplyElevation(int i8) {
        return get(i8).transform.applyElevation;
    }

    public Constraint getConstraint(int i8) {
        if (this.mConstraints.containsKey(Integer.valueOf(i8))) {
            return this.mConstraints.get(Integer.valueOf(i8));
        }
        return null;
    }

    public HashMap<String, ConstraintAttribute> getCustomAttributeSet() {
        return this.mSavedAttributes;
    }

    public int getHeight(int i8) {
        return get(i8).layout.mHeight;
    }

    public int[] getKnownIds() {
        Integer[] numArr = (Integer[]) this.mConstraints.keySet().toArray(new Integer[0]);
        int length = numArr.length;
        int[] iArr = new int[length];
        for (int i8 = 0; i8 < length; i8++) {
            iArr[i8] = numArr[i8].intValue();
        }
        return iArr;
    }

    public Constraint getParameters(int i8) {
        return get(i8);
    }

    public int[] getReferencedIds(int i8) {
        int[] iArr = get(i8).layout.mReferenceIds;
        return iArr == null ? new int[0] : Arrays.copyOf(iArr, iArr.length);
    }

    public int getVisibility(int i8) {
        return get(i8).propertySet.visibility;
    }

    public int getVisibilityMode(int i8) {
        return get(i8).propertySet.mVisibilityMode;
    }

    public int getWidth(int i8) {
        return get(i8).layout.mWidth;
    }

    public boolean isForceId() {
        return this.mForceId;
    }

    public void load(Context context, int i8) {
        XmlResourceParser xml = context.getResources().getXml(i8);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    Constraint constraintFillFromAttributeList = fillFromAttributeList(context, Xml.asAttributeSet(xml), false);
                    if (name.equalsIgnoreCase("Guideline")) {
                        constraintFillFromAttributeList.layout.mIsGuideline = true;
                    }
                    this.mConstraints.put(Integer.valueOf(constraintFillFromAttributeList.mViewId), constraintFillFromAttributeList);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e4) {
            e4.printStackTrace();
        }
    }

    public void parseColorAttributes(Constraint constraint, String str) {
        String[] strArrSplit = str.split(",");
        for (int i8 = 0; i8 < strArrSplit.length; i8++) {
            String[] strArrSplit2 = strArrSplit[i8].split("=");
            if (strArrSplit2.length != 2) {
                Log.w(TAG, " Unable to parse " + strArrSplit[i8]);
            } else {
                constraint.setColorValue(strArrSplit2[0], Color.parseColor(strArrSplit2[1]));
            }
        }
    }

    public void parseFloatAttributes(Constraint constraint, String str) {
        String[] strArrSplit = str.split(",");
        for (int i8 = 0; i8 < strArrSplit.length; i8++) {
            String[] strArrSplit2 = strArrSplit[i8].split("=");
            if (strArrSplit2.length != 2) {
                Log.w(TAG, " Unable to parse " + strArrSplit[i8]);
            } else {
                constraint.setFloatValue(strArrSplit2[0], Float.parseFloat(strArrSplit2[1]));
            }
        }
    }

    public void parseIntAttributes(Constraint constraint, String str) {
        String[] strArrSplit = str.split(",");
        for (int i8 = 0; i8 < strArrSplit.length; i8++) {
            String[] strArrSplit2 = strArrSplit[i8].split("=");
            if (strArrSplit2.length != 2) {
                Log.w(TAG, " Unable to parse " + strArrSplit[i8]);
            } else {
                constraint.setFloatValue(strArrSplit2[0], Integer.decode(strArrSplit2[1]).intValue());
            }
        }
    }

    public void parseStringAttributes(Constraint constraint, String str) {
        String[] strArrSplitString = splitString(str);
        for (int i8 = 0; i8 < strArrSplitString.length; i8++) {
            String[] strArrSplit = strArrSplitString[i8].split("=");
            Log.w(TAG, " Unable to parse " + strArrSplitString[i8]);
            constraint.setStringValue(strArrSplit[0], strArrSplit[1]);
        }
    }

    public void readFallback(ConstraintSet constraintSet) {
        for (Integer num : constraintSet.mConstraints.keySet()) {
            num.intValue();
            Constraint constraint = constraintSet.mConstraints.get(num);
            if (!this.mConstraints.containsKey(num)) {
                this.mConstraints.put(num, new Constraint());
            }
            Constraint constraint2 = this.mConstraints.get(num);
            if (constraint2 != null) {
                Layout layout = constraint2.layout;
                if (!layout.mApply) {
                    layout.copyFrom(constraint.layout);
                }
                PropertySet propertySet = constraint2.propertySet;
                if (!propertySet.mApply) {
                    propertySet.copyFrom(constraint.propertySet);
                }
                Transform transform = constraint2.transform;
                if (!transform.mApply) {
                    transform.copyFrom(constraint.transform);
                }
                Motion motion = constraint2.motion;
                if (!motion.mApply) {
                    motion.copyFrom(constraint.motion);
                }
                for (String str : constraint.mCustomConstraints.keySet()) {
                    if (!constraint2.mCustomConstraints.containsKey(str)) {
                        constraint2.mCustomConstraints.put(str, constraint.mCustomConstraints.get(str));
                    }
                }
            }
        }
    }

    public void removeAttribute(String str) {
        this.mSavedAttributes.remove(str);
    }

    public void removeFromHorizontalChain(int i8) {
        Constraint constraint;
        if (!this.mConstraints.containsKey(Integer.valueOf(i8)) || (constraint = this.mConstraints.get(Integer.valueOf(i8))) == null) {
            return;
        }
        Layout layout = constraint.layout;
        int i9 = layout.leftToRight;
        int i10 = layout.rightToLeft;
        if (i9 != -1 || i10 != -1) {
            if (i9 == -1 || i10 == -1) {
                int i11 = layout.rightToRight;
                if (i11 != -1) {
                    connect(i9, 2, i11, 2, 0);
                } else {
                    int i12 = layout.leftToLeft;
                    if (i12 != -1) {
                        connect(i10, 1, i12, 1, 0);
                    }
                }
            } else {
                connect(i9, 2, i10, 1, 0);
                connect(i10, 1, i9, 2, 0);
            }
            clear(i8, 1);
            clear(i8, 2);
            return;
        }
        int i13 = layout.startToEnd;
        int i14 = layout.endToStart;
        if (i13 != -1 || i14 != -1) {
            if (i13 != -1 && i14 != -1) {
                connect(i13, 7, i14, 6, 0);
                connect(i14, 6, i9, 7, 0);
            } else if (i14 != -1) {
                int i15 = layout.rightToRight;
                if (i15 != -1) {
                    connect(i9, 7, i15, 7, 0);
                } else {
                    int i16 = layout.leftToLeft;
                    if (i16 != -1) {
                        connect(i14, 6, i16, 6, 0);
                    }
                }
            }
        }
        clear(i8, 6);
        clear(i8, 7);
    }

    public void removeFromVerticalChain(int i8) {
        if (this.mConstraints.containsKey(Integer.valueOf(i8))) {
            Constraint constraint = this.mConstraints.get(Integer.valueOf(i8));
            if (constraint == null) {
                return;
            }
            Layout layout = constraint.layout;
            int i9 = layout.topToBottom;
            int i10 = layout.bottomToTop;
            if (i9 != -1 || i10 != -1) {
                if (i9 == -1 || i10 == -1) {
                    int i11 = layout.bottomToBottom;
                    if (i11 != -1) {
                        connect(i9, 4, i11, 4, 0);
                    } else {
                        int i12 = layout.topToTop;
                        if (i12 != -1) {
                            connect(i10, 3, i12, 3, 0);
                        }
                    }
                } else {
                    connect(i9, 4, i10, 3, 0);
                    connect(i10, 3, i9, 4, 0);
                }
            }
        }
        clear(i8, 3);
        clear(i8, 4);
    }

    public void setAlpha(int i8, float f) {
        get(i8).propertySet.alpha = f;
    }

    public void setApplyElevation(int i8, boolean z2) {
        get(i8).transform.applyElevation = z2;
    }

    public void setBarrierType(int i8, int i9) {
        get(i8).layout.mHelperType = i9;
    }

    public void setColorValue(int i8, String str, int i9) {
        get(i8).setColorValue(str, i9);
    }

    public void setDimensionRatio(int i8, String str) {
        get(i8).layout.dimensionRatio = str;
    }

    public void setEditorAbsoluteX(int i8, int i9) {
        get(i8).layout.editorAbsoluteX = i9;
    }

    public void setEditorAbsoluteY(int i8, int i9) {
        get(i8).layout.editorAbsoluteY = i9;
    }

    public void setElevation(int i8, float f) {
        get(i8).transform.elevation = f;
        get(i8).transform.applyElevation = true;
    }

    public void setFloatValue(int i8, String str, float f) {
        get(i8).setFloatValue(str, f);
    }

    public void setForceId(boolean z2) {
        this.mForceId = z2;
    }

    public void setGoneMargin(int i8, int i9, int i10) {
        Constraint constraint = get(i8);
        switch (i9) {
            case 1:
                constraint.layout.goneLeftMargin = i10;
                return;
            case 2:
                constraint.layout.goneRightMargin = i10;
                return;
            case 3:
                constraint.layout.goneTopMargin = i10;
                return;
            case 4:
                constraint.layout.goneBottomMargin = i10;
                return;
            case 5:
                constraint.layout.goneBaselineMargin = i10;
                return;
            case 6:
                constraint.layout.goneStartMargin = i10;
                return;
            case 7:
                constraint.layout.goneEndMargin = i10;
                return;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public void setGuidelineBegin(int i8, int i9) {
        get(i8).layout.guideBegin = i9;
        get(i8).layout.guideEnd = -1;
        get(i8).layout.guidePercent = -1.0f;
    }

    public void setGuidelineEnd(int i8, int i9) {
        get(i8).layout.guideEnd = i9;
        get(i8).layout.guideBegin = -1;
        get(i8).layout.guidePercent = -1.0f;
    }

    public void setGuidelinePercent(int i8, float f) {
        get(i8).layout.guidePercent = f;
        get(i8).layout.guideEnd = -1;
        get(i8).layout.guideBegin = -1;
    }

    public void setHorizontalBias(int i8, float f) {
        get(i8).layout.horizontalBias = f;
    }

    public void setHorizontalChainStyle(int i8, int i9) {
        get(i8).layout.horizontalChainStyle = i9;
    }

    public void setHorizontalWeight(int i8, float f) {
        get(i8).layout.horizontalWeight = f;
    }

    public void setIntValue(int i8, String str, int i9) {
        get(i8).setIntValue(str, i9);
    }

    public void setLayoutWrapBehavior(int i8, int i9) {
        if (i9 < 0 || i9 > 3) {
            return;
        }
        get(i8).layout.mWrapBehavior = i9;
    }

    public void setMargin(int i8, int i9, int i10) {
        Constraint constraint = get(i8);
        switch (i9) {
            case 1:
                constraint.layout.leftMargin = i10;
                return;
            case 2:
                constraint.layout.rightMargin = i10;
                return;
            case 3:
                constraint.layout.topMargin = i10;
                return;
            case 4:
                constraint.layout.bottomMargin = i10;
                return;
            case 5:
                constraint.layout.baselineMargin = i10;
                return;
            case 6:
                constraint.layout.startMargin = i10;
                return;
            case 7:
                constraint.layout.endMargin = i10;
                return;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public void setReferencedIds(int i8, int... iArr) {
        get(i8).layout.mReferenceIds = iArr;
    }

    public void setRotation(int i8, float f) {
        get(i8).transform.rotation = f;
    }

    public void setRotationX(int i8, float f) {
        get(i8).transform.rotationX = f;
    }

    public void setRotationY(int i8, float f) {
        get(i8).transform.rotationY = f;
    }

    public void setScaleX(int i8, float f) {
        get(i8).transform.scaleX = f;
    }

    public void setScaleY(int i8, float f) {
        get(i8).transform.scaleY = f;
    }

    public void setStringValue(int i8, String str, String str2) {
        get(i8).setStringValue(str, str2);
    }

    public void setTransformPivot(int i8, float f, float f4) {
        Transform transform = get(i8).transform;
        transform.transformPivotY = f4;
        transform.transformPivotX = f;
    }

    public void setTransformPivotX(int i8, float f) {
        get(i8).transform.transformPivotX = f;
    }

    public void setTransformPivotY(int i8, float f) {
        get(i8).transform.transformPivotY = f;
    }

    public void setTranslation(int i8, float f, float f4) {
        Transform transform = get(i8).transform;
        transform.translationX = f;
        transform.translationY = f4;
    }

    public void setTranslationX(int i8, float f) {
        get(i8).transform.translationX = f;
    }

    public void setTranslationY(int i8, float f) {
        get(i8).transform.translationY = f;
    }

    public void setTranslationZ(int i8, float f) {
        get(i8).transform.translationZ = f;
    }

    public void setValidateOnParse(boolean z2) {
        this.mValidate = z2;
    }

    public void setVerticalBias(int i8, float f) {
        get(i8).layout.verticalBias = f;
    }

    public void setVerticalChainStyle(int i8, int i9) {
        get(i8).layout.verticalChainStyle = i9;
    }

    public void setVerticalWeight(int i8, float f) {
        get(i8).layout.verticalWeight = f;
    }

    public void setVisibility(int i8, int i9) {
        get(i8).propertySet.visibility = i9;
    }

    public void setVisibilityMode(int i8, int i9) {
        get(i8).propertySet.mVisibilityMode = i9;
    }

    public void writeState(Writer writer, ConstraintLayout constraintLayout, int i8) throws IOException {
        writer.write("\n---------------------------------------------\n");
        if ((i8 & 1) == 1) {
            new WriteXmlEngine(writer, constraintLayout, i8).writeLayout();
        } else {
            new WriteJsonEngine(writer, constraintLayout, i8).writeLayout();
        }
        writer.write("\n---------------------------------------------\n");
    }

    private void createHorizontalChain(int i8, int i9, int i10, int i11, int[] iArr, float[] fArr, int i12, int i13, int i14) {
        if (iArr.length < 2) {
            throw new IllegalArgumentException("must have 2 or more widgets in a chain");
        }
        if (fArr != null && fArr.length != iArr.length) {
            throw new IllegalArgumentException("must have 2 or more widgets in a chain");
        }
        if (fArr != null) {
            get(iArr[0]).layout.horizontalWeight = fArr[0];
        }
        get(iArr[0]).layout.horizontalChainStyle = i12;
        connect(iArr[0], i13, i8, i9, -1);
        for (int i15 = 1; i15 < iArr.length; i15++) {
            int i16 = i15 - 1;
            connect(iArr[i15], i13, iArr[i16], i14, -1);
            connect(iArr[i16], i14, iArr[i15], i13, -1);
            if (fArr != null) {
                get(iArr[i15]).layout.horizontalWeight = fArr[i15];
            }
        }
        connect(iArr[iArr.length - 1], i14, i10, i11, -1);
    }

    public void clear(int i8, int i9) {
        Constraint constraint;
        if (!this.mConstraints.containsKey(Integer.valueOf(i8)) || (constraint = this.mConstraints.get(Integer.valueOf(i8))) == null) {
            return;
        }
        switch (i9) {
            case 1:
                Layout layout = constraint.layout;
                layout.leftToRight = -1;
                layout.leftToLeft = -1;
                layout.leftMargin = -1;
                layout.goneLeftMargin = Integer.MIN_VALUE;
                return;
            case 2:
                Layout layout2 = constraint.layout;
                layout2.rightToRight = -1;
                layout2.rightToLeft = -1;
                layout2.rightMargin = -1;
                layout2.goneRightMargin = Integer.MIN_VALUE;
                return;
            case 3:
                Layout layout3 = constraint.layout;
                layout3.topToBottom = -1;
                layout3.topToTop = -1;
                layout3.topMargin = 0;
                layout3.goneTopMargin = Integer.MIN_VALUE;
                return;
            case 4:
                Layout layout4 = constraint.layout;
                layout4.bottomToTop = -1;
                layout4.bottomToBottom = -1;
                layout4.bottomMargin = 0;
                layout4.goneBottomMargin = Integer.MIN_VALUE;
                return;
            case 5:
                Layout layout5 = constraint.layout;
                layout5.baselineToBaseline = -1;
                layout5.baselineToTop = -1;
                layout5.baselineToBottom = -1;
                layout5.baselineMargin = 0;
                layout5.goneBaselineMargin = Integer.MIN_VALUE;
                return;
            case 6:
                Layout layout6 = constraint.layout;
                layout6.startToEnd = -1;
                layout6.startToStart = -1;
                layout6.startMargin = 0;
                layout6.goneStartMargin = Integer.MIN_VALUE;
                return;
            case 7:
                Layout layout7 = constraint.layout;
                layout7.endToStart = -1;
                layout7.endToEnd = -1;
                layout7.endMargin = 0;
                layout7.goneEndMargin = Integer.MIN_VALUE;
                return;
            case 8:
                Layout layout8 = constraint.layout;
                layout8.circleAngle = -1.0f;
                layout8.circleRadius = -1;
                layout8.circleConstraint = -1;
                return;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public void clone(ConstraintSet constraintSet) {
        this.mConstraints.clear();
        for (Integer num : constraintSet.mConstraints.keySet()) {
            Constraint constraint = constraintSet.mConstraints.get(num);
            if (constraint != null) {
                this.mConstraints.put(num, constraint.m32clone());
            }
        }
    }

    public class WriteJsonEngine {
        private static final String SPACE = "       ";
        Context context;
        int flags;
        ConstraintLayout layout;
        Writer writer;
        int unknownCount = 0;
        final String LEFT = "'left'";
        final String RIGHT = "'right'";
        final String BASELINE = "'baseline'";
        final String BOTTOM = "'bottom'";
        final String TOP = "'top'";
        final String START = "'start'";
        final String END = "'end'";
        HashMap<Integer, String> idMap = new HashMap<>();

        public WriteJsonEngine(Writer writer, ConstraintLayout constraintLayout, int i8) throws IOException {
            this.writer = writer;
            this.layout = constraintLayout;
            this.context = constraintLayout.getContext();
            this.flags = i8;
        }

        private void writeDimension(String str, int i8, int i9, float f, int i10, int i11, boolean z2) throws IOException {
            if (i8 != 0) {
                if (i8 == -2) {
                    this.writer.write(SPACE + str + ": 'wrap'\n");
                    return;
                }
                if (i8 == -1) {
                    this.writer.write(SPACE + str + ": 'parent'\n");
                    return;
                }
                this.writer.write(SPACE + str + ": " + i8 + ",\n");
                return;
            }
            if (i11 == -1 && i10 == -1) {
                if (i9 == 1) {
                    this.writer.write(SPACE + str + ": '???????????',\n");
                    return;
                }
                if (i9 != 2) {
                    return;
                }
                this.writer.write(SPACE + str + ": '" + f + "%',\n");
                return;
            }
            if (i9 == 0) {
                this.writer.write(SPACE + str + ": {'spread' ," + i10 + ", " + i11 + "}\n");
                return;
            }
            if (i9 == 1) {
                this.writer.write(SPACE + str + ": {'wrap' ," + i10 + ", " + i11 + "}\n");
                return;
            }
            if (i9 != 2) {
                return;
            }
            this.writer.write(SPACE + str + ": {'" + f + "'% ," + i10 + ", " + i11 + "}\n");
        }

        private void writeGuideline(int i8, int i9, int i10, float f) {
        }

        public String getName(int i8) {
            if (this.idMap.containsKey(Integer.valueOf(i8))) {
                return h0.a.n(new StringBuilder("'"), this.idMap.get(Integer.valueOf(i8)), "'");
            }
            if (i8 == 0) {
                return "'parent'";
            }
            String strLookup = lookup(i8);
            this.idMap.put(Integer.valueOf(i8), strLookup);
            return "'" + strLookup + "'";
        }

        public String lookup(int i8) {
            try {
                if (i8 != -1) {
                    return this.context.getResources().getResourceEntryName(i8);
                }
                StringBuilder sb2 = new StringBuilder(EnvironmentCompat.MEDIA_UNKNOWN);
                int i9 = this.unknownCount + 1;
                this.unknownCount = i9;
                sb2.append(i9);
                return sb2.toString();
            } catch (Exception unused) {
                StringBuilder sb3 = new StringBuilder(EnvironmentCompat.MEDIA_UNKNOWN);
                int i10 = this.unknownCount + 1;
                this.unknownCount = i10;
                sb3.append(i10);
                return sb3.toString();
            }
        }

        public void writeCircle(int i8, float f, int i9) throws IOException {
            if (i8 == -1) {
                return;
            }
            this.writer.write("       circle");
            this.writer.write(":[");
            this.writer.write(getName(i8));
            this.writer.write(", " + f);
            this.writer.write(i9 + "]");
        }

        public void writeConstraint(String str, int i8, String str2, int i9, int i10) throws IOException {
            if (i8 == -1) {
                return;
            }
            this.writer.write(SPACE + str);
            this.writer.write(":[");
            this.writer.write(getName(i8));
            this.writer.write(" , ");
            this.writer.write(str2);
            if (i9 != 0) {
                this.writer.write(" , " + i9);
            }
            this.writer.write("],\n");
        }

        public void writeLayout() throws IOException {
            this.writer.write("\n'ConstraintSet':{\n");
            for (Integer num : ConstraintSet.this.mConstraints.keySet()) {
                Constraint constraint = (Constraint) ConstraintSet.this.mConstraints.get(num);
                String name = getName(num.intValue());
                this.writer.write(name + ":{\n");
                Layout layout = constraint.layout;
                writeDimension("height", layout.mHeight, layout.heightDefault, layout.heightPercent, layout.heightMin, layout.heightMax, layout.constrainedHeight);
                writeDimension("width", layout.mWidth, layout.widthDefault, layout.widthPercent, layout.widthMin, layout.widthMax, layout.constrainedWidth);
                writeConstraint("'left'", layout.leftToLeft, "'left'", layout.leftMargin, layout.goneLeftMargin);
                writeConstraint("'left'", layout.leftToRight, "'right'", layout.leftMargin, layout.goneLeftMargin);
                writeConstraint("'right'", layout.rightToLeft, "'left'", layout.rightMargin, layout.goneRightMargin);
                writeConstraint("'right'", layout.rightToRight, "'right'", layout.rightMargin, layout.goneRightMargin);
                writeConstraint("'baseline'", layout.baselineToBaseline, "'baseline'", -1, layout.goneBaselineMargin);
                writeConstraint("'baseline'", layout.baselineToTop, "'top'", -1, layout.goneBaselineMargin);
                writeConstraint("'baseline'", layout.baselineToBottom, "'bottom'", -1, layout.goneBaselineMargin);
                writeConstraint("'top'", layout.topToBottom, "'bottom'", layout.topMargin, layout.goneTopMargin);
                writeConstraint("'top'", layout.topToTop, "'top'", layout.topMargin, layout.goneTopMargin);
                writeConstraint("'bottom'", layout.bottomToBottom, "'bottom'", layout.bottomMargin, layout.goneBottomMargin);
                writeConstraint("'bottom'", layout.bottomToTop, "'top'", layout.bottomMargin, layout.goneBottomMargin);
                writeConstraint("'start'", layout.startToStart, "'start'", layout.startMargin, layout.goneStartMargin);
                writeConstraint("'start'", layout.startToEnd, "'end'", layout.startMargin, layout.goneStartMargin);
                writeConstraint("'end'", layout.endToStart, "'start'", layout.endMargin, layout.goneEndMargin);
                writeConstraint("'end'", layout.endToEnd, "'end'", layout.endMargin, layout.goneEndMargin);
                writeVariable("'horizontalBias'", layout.horizontalBias, 0.5f);
                writeVariable("'verticalBias'", layout.verticalBias, 0.5f);
                writeCircle(layout.circleConstraint, layout.circleAngle, layout.circleRadius);
                writeGuideline(layout.orientation, layout.guideBegin, layout.guideEnd, layout.guidePercent);
                writeVariable("'dimensionRatio'", layout.dimensionRatio);
                writeVariable("'barrierMargin'", layout.mBarrierMargin);
                writeVariable("'type'", layout.mHelperType);
                writeVariable("'ReferenceId'", layout.mReferenceIdString);
                writeVariable("'mBarrierAllowsGoneWidgets'", layout.mBarrierAllowsGoneWidgets, true);
                writeVariable("'WrapBehavior'", layout.mWrapBehavior);
                writeVariable("'verticalWeight'", layout.verticalWeight);
                writeVariable("'horizontalWeight'", layout.horizontalWeight);
                writeVariable("'horizontalChainStyle'", layout.horizontalChainStyle);
                writeVariable("'verticalChainStyle'", layout.verticalChainStyle);
                writeVariable("'barrierDirection'", layout.mBarrierDirection);
                int[] iArr = layout.mReferenceIds;
                if (iArr != null) {
                    writeVariable("'ReferenceIds'", iArr);
                }
                this.writer.write("}\n");
            }
            this.writer.write("}\n");
        }

        public void writeVariable(String str, int i8) throws IOException {
            if (i8 == 0 || i8 == -1) {
                return;
            }
            this.writer.write(SPACE + str);
            this.writer.write(":");
            this.writer.write(", " + i8);
            this.writer.write("\n");
        }

        public void writeVariable(String str, float f) throws IOException {
            if (f == -1.0f) {
                return;
            }
            this.writer.write(SPACE + str);
            this.writer.write(": " + f);
            this.writer.write(",\n");
        }

        public void writeVariable(String str, float f, float f4) throws IOException {
            if (f == f4) {
                return;
            }
            this.writer.write(SPACE + str);
            this.writer.write(": " + f);
            this.writer.write(",\n");
        }

        public void writeVariable(String str, boolean z2) throws IOException {
            if (z2) {
                this.writer.write(SPACE + str);
                this.writer.write(": " + z2);
                this.writer.write(",\n");
            }
        }

        public void writeVariable(String str, boolean z2, boolean z3) throws IOException {
            if (z2 == z3) {
                return;
            }
            this.writer.write(SPACE + str);
            this.writer.write(": " + z2);
            this.writer.write(",\n");
        }

        public void writeVariable(String str, int[] iArr) throws IOException {
            if (iArr == null) {
                return;
            }
            this.writer.write(SPACE + str);
            this.writer.write(": ");
            int i8 = 0;
            while (i8 < iArr.length) {
                Writer writer = this.writer;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(i8 == 0 ? "[" : ", ");
                sb2.append(getName(iArr[i8]));
                writer.write(sb2.toString());
                i8++;
            }
            this.writer.write("],\n");
        }

        public void writeVariable(String str, String str2) throws IOException {
            if (str2 == null) {
                return;
            }
            this.writer.write(SPACE + str);
            this.writer.write(":");
            this.writer.write(", ".concat(str2));
            this.writer.write("\n");
        }
    }

    public void centerHorizontally(int i8, int i9) {
        if (i9 == 0) {
            center(i8, 0, 1, 0, 0, 2, 0, 0.5f);
        } else {
            center(i8, i9, 2, 0, i9, 1, 0, 0.5f);
        }
    }

    public void centerHorizontallyRtl(int i8, int i9) {
        if (i9 == 0) {
            center(i8, 0, 6, 0, 0, 7, 0, 0.5f);
        } else {
            center(i8, i9, 7, 0, i9, 6, 0, 0.5f);
        }
    }

    public void centerVertically(int i8, int i9) {
        if (i9 == 0) {
            center(i8, 0, 3, 0, 0, 4, 0, 0.5f);
        } else {
            center(i8, i9, 4, 0, i9, 3, 0, 0.5f);
        }
    }

    public void clone(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        this.mConstraints.clear();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = constraintLayout.getChildAt(i8);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
            int id2 = childAt.getId();
            if (this.mForceId && id2 == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.mConstraints.containsKey(Integer.valueOf(id2))) {
                this.mConstraints.put(Integer.valueOf(id2), new Constraint());
            }
            Constraint constraint = this.mConstraints.get(Integer.valueOf(id2));
            if (constraint != null) {
                constraint.mCustomConstraints = ConstraintAttribute.extractAttributes(this.mSavedAttributes, childAt);
                constraint.fillFrom(id2, layoutParams);
                constraint.propertySet.visibility = childAt.getVisibility();
                constraint.propertySet.alpha = childAt.getAlpha();
                constraint.transform.rotation = childAt.getRotation();
                constraint.transform.rotationX = childAt.getRotationX();
                constraint.transform.rotationY = childAt.getRotationY();
                constraint.transform.scaleX = childAt.getScaleX();
                constraint.transform.scaleY = childAt.getScaleY();
                float pivotX = childAt.getPivotX();
                float pivotY = childAt.getPivotY();
                if (pivotX != 0.0d || pivotY != 0.0d) {
                    Transform transform = constraint.transform;
                    transform.transformPivotX = pivotX;
                    transform.transformPivotY = pivotY;
                }
                constraint.transform.translationX = childAt.getTranslationX();
                constraint.transform.translationY = childAt.getTranslationY();
                constraint.transform.translationZ = childAt.getTranslationZ();
                Transform transform2 = constraint.transform;
                if (transform2.applyElevation) {
                    transform2.elevation = childAt.getElevation();
                }
                if (childAt instanceof Barrier) {
                    Barrier barrier = (Barrier) childAt;
                    constraint.layout.mBarrierAllowsGoneWidgets = barrier.getAllowsGoneWidget();
                    constraint.layout.mReferenceIds = barrier.getReferencedIds();
                    constraint.layout.mBarrierDirection = barrier.getType();
                    constraint.layout.mBarrierMargin = barrier.getMargin();
                }
            }
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void load(Context context, XmlPullParser xmlPullParser) {
        try {
            int eventType = xmlPullParser.getEventType();
            Constraint constraintFillFromAttributeList = null;
            while (eventType != 1) {
                if (eventType == 0) {
                    xmlPullParser.getName();
                } else if (eventType == 2) {
                    switch (xmlPullParser.getName()) {
                        case "Constraint":
                            constraintFillFromAttributeList = fillFromAttributeList(context, Xml.asAttributeSet(xmlPullParser), false);
                            break;
                        case "ConstraintOverride":
                            constraintFillFromAttributeList = fillFromAttributeList(context, Xml.asAttributeSet(xmlPullParser), true);
                            break;
                        case "Guideline":
                            constraintFillFromAttributeList = fillFromAttributeList(context, Xml.asAttributeSet(xmlPullParser), false);
                            Layout layout = constraintFillFromAttributeList.layout;
                            layout.mIsGuideline = true;
                            layout.mApply = true;
                            break;
                        case "Barrier":
                            constraintFillFromAttributeList = fillFromAttributeList(context, Xml.asAttributeSet(xmlPullParser), false);
                            constraintFillFromAttributeList.layout.mHelperType = 1;
                            break;
                        case "PropertySet":
                            if (constraintFillFromAttributeList != null) {
                                constraintFillFromAttributeList.propertySet.fillFromAttributeList(context, Xml.asAttributeSet(xmlPullParser));
                                break;
                            } else {
                                throw new RuntimeException(ERROR_MESSAGE + xmlPullParser.getLineNumber());
                            }
                            break;
                        case "Transform":
                            if (constraintFillFromAttributeList != null) {
                                constraintFillFromAttributeList.transform.fillFromAttributeList(context, Xml.asAttributeSet(xmlPullParser));
                                break;
                            } else {
                                throw new RuntimeException(ERROR_MESSAGE + xmlPullParser.getLineNumber());
                            }
                            break;
                        case "Layout":
                            if (constraintFillFromAttributeList != null) {
                                constraintFillFromAttributeList.layout.fillFromAttributeList(context, Xml.asAttributeSet(xmlPullParser));
                                break;
                            } else {
                                throw new RuntimeException(ERROR_MESSAGE + xmlPullParser.getLineNumber());
                            }
                            break;
                        case "Motion":
                            if (constraintFillFromAttributeList != null) {
                                constraintFillFromAttributeList.motion.fillFromAttributeList(context, Xml.asAttributeSet(xmlPullParser));
                                break;
                            } else {
                                throw new RuntimeException(ERROR_MESSAGE + xmlPullParser.getLineNumber());
                            }
                            break;
                        case "CustomAttribute":
                        case "CustomMethod":
                            if (constraintFillFromAttributeList != null) {
                                ConstraintAttribute.parse(context, xmlPullParser, constraintFillFromAttributeList.mCustomConstraints);
                                break;
                            } else {
                                throw new RuntimeException(ERROR_MESSAGE + xmlPullParser.getLineNumber());
                            }
                            break;
                    }
                } else if (eventType == 3) {
                    String lowerCase = xmlPullParser.getName().toLowerCase(Locale.ROOT);
                    switch (lowerCase.hashCode()) {
                        case -2075718416:
                            if (lowerCase.equals("guideline")) {
                            }
                            break;
                        case -190376483:
                            if (lowerCase.equals("constraint")) {
                            }
                            break;
                        case 426575017:
                            if (lowerCase.equals("constraintoverride")) {
                            }
                            break;
                        case 2146106725:
                            if (lowerCase.equals("constraintset")) {
                            }
                            break;
                    }
                    if (r4 == 0) {
                        return;
                    }
                    if (r4 == 1 || r4 == 2 || r4 == 3) {
                        this.mConstraints.put(Integer.valueOf(constraintFillFromAttributeList.mViewId), constraintFillFromAttributeList);
                        constraintFillFromAttributeList = null;
                    }
                }
                eventType = xmlPullParser.next();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e4) {
            e4.printStackTrace();
        }
    }

    public void readFallback(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = constraintLayout.getChildAt(i8);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
            int id2 = childAt.getId();
            if (this.mForceId && id2 == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.mConstraints.containsKey(Integer.valueOf(id2))) {
                this.mConstraints.put(Integer.valueOf(id2), new Constraint());
            }
            Constraint constraint = this.mConstraints.get(Integer.valueOf(id2));
            if (constraint != null) {
                if (!constraint.layout.mApply) {
                    constraint.fillFrom(id2, layoutParams);
                    if (childAt instanceof ConstraintHelper) {
                        constraint.layout.mReferenceIds = ((ConstraintHelper) childAt).getReferencedIds();
                        if (childAt instanceof Barrier) {
                            Barrier barrier = (Barrier) childAt;
                            constraint.layout.mBarrierAllowsGoneWidgets = barrier.getAllowsGoneWidget();
                            constraint.layout.mBarrierDirection = barrier.getType();
                            constraint.layout.mBarrierMargin = barrier.getMargin();
                        }
                    }
                    constraint.layout.mApply = true;
                }
                PropertySet propertySet = constraint.propertySet;
                if (!propertySet.mApply) {
                    propertySet.visibility = childAt.getVisibility();
                    constraint.propertySet.alpha = childAt.getAlpha();
                    constraint.propertySet.mApply = true;
                }
                Transform transform = constraint.transform;
                if (!transform.mApply) {
                    transform.mApply = true;
                    transform.rotation = childAt.getRotation();
                    constraint.transform.rotationX = childAt.getRotationX();
                    constraint.transform.rotationY = childAt.getRotationY();
                    constraint.transform.scaleX = childAt.getScaleX();
                    constraint.transform.scaleY = childAt.getScaleY();
                    float pivotX = childAt.getPivotX();
                    float pivotY = childAt.getPivotY();
                    if (pivotX != 0.0d || pivotY != 0.0d) {
                        Transform transform2 = constraint.transform;
                        transform2.transformPivotX = pivotX;
                        transform2.transformPivotY = pivotY;
                    }
                    constraint.transform.translationX = childAt.getTranslationX();
                    constraint.transform.translationY = childAt.getTranslationY();
                    constraint.transform.translationZ = childAt.getTranslationZ();
                    Transform transform3 = constraint.transform;
                    if (transform3.applyElevation) {
                        transform3.elevation = childAt.getElevation();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setDeltaValue(Constraint constraint, int i8, int i9) {
        if (i8 == 6) {
            constraint.layout.editorAbsoluteX = i9;
            return;
        }
        if (i8 == 7) {
            constraint.layout.editorAbsoluteY = i9;
            return;
        }
        if (i8 == 8) {
            constraint.layout.endMargin = i9;
            return;
        }
        if (i8 == 27) {
            constraint.layout.orientation = i9;
            return;
        }
        if (i8 == 28) {
            constraint.layout.rightMargin = i9;
            return;
        }
        if (i8 == 41) {
            constraint.layout.horizontalChainStyle = i9;
            return;
        }
        if (i8 == 42) {
            constraint.layout.verticalChainStyle = i9;
            return;
        }
        if (i8 == CIRCLE) {
            constraint.layout.circleConstraint = i9;
            return;
        }
        if (i8 == CIRCLE_RADIUS) {
            constraint.layout.circleRadius = i9;
            return;
        }
        if (i8 == BARRIER_DIRECTION) {
            constraint.layout.mBarrierDirection = i9;
            return;
        }
        if (i8 != BARRIER_MARGIN) {
            switch (i8) {
                case 2:
                    constraint.layout.bottomMargin = i9;
                    break;
                case 11:
                    constraint.layout.goneBottomMargin = i9;
                    break;
                case 12:
                    constraint.layout.goneEndMargin = i9;
                    break;
                case 13:
                    constraint.layout.goneLeftMargin = i9;
                    break;
                case 14:
                    constraint.layout.goneRightMargin = i9;
                    break;
                case 15:
                    constraint.layout.goneStartMargin = i9;
                    break;
                case 16:
                    constraint.layout.goneTopMargin = i9;
                    break;
                case 17:
                    constraint.layout.guideBegin = i9;
                    break;
                case 18:
                    constraint.layout.guideEnd = i9;
                    break;
                case 31:
                    constraint.layout.startMargin = i9;
                    break;
                case 34:
                    constraint.layout.topMargin = i9;
                    break;
                case 38:
                    constraint.mViewId = i9;
                    break;
                case 64:
                    constraint.motion.mAnimateRelativeTo = i9;
                    break;
                case 66:
                    constraint.motion.mDrawPath = i9;
                    break;
                case 76:
                    constraint.motion.mPathMotionArc = i9;
                    break;
                case VISIBILITY_MODE /* 78 */:
                    constraint.propertySet.mVisibilityMode = i9;
                    break;
                case BASELINE_MARGIN /* 93 */:
                    constraint.layout.baselineMargin = i9;
                    break;
                case GONE_BASELINE_MARGIN /* 94 */:
                    constraint.layout.goneBaselineMargin = i9;
                    break;
                case LAYOUT_WRAP_BEHAVIOR /* 97 */:
                    constraint.layout.mWrapBehavior = i9;
                    break;
                default:
                    switch (i8) {
                        case 21:
                            constraint.layout.mHeight = i9;
                            break;
                        case 22:
                            constraint.propertySet.visibility = i9;
                            break;
                        case 23:
                            constraint.layout.mWidth = i9;
                            break;
                        case 24:
                            constraint.layout.leftMargin = i9;
                            break;
                        default:
                            switch (i8) {
                                case 54:
                                    constraint.layout.widthDefault = i9;
                                    break;
                                case 55:
                                    constraint.layout.heightDefault = i9;
                                    break;
                                case WIDTH_MAX /* 56 */:
                                    constraint.layout.widthMax = i9;
                                    break;
                                case HEIGHT_MAX /* 57 */:
                                    constraint.layout.heightMax = i9;
                                    break;
                                case WIDTH_MIN /* 58 */:
                                    constraint.layout.widthMin = i9;
                                    break;
                                case HEIGHT_MIN /* 59 */:
                                    constraint.layout.heightMin = i9;
                                    break;
                                default:
                                    switch (i8) {
                                        case ANIMATE_CIRCLE_ANGLE_TO /* 82 */:
                                            constraint.motion.mAnimateCircleAngleTo = i9;
                                            break;
                                        case TRANSFORM_PIVOT_TARGET /* 83 */:
                                            constraint.transform.transformPivotTarget = i9;
                                            break;
                                        case QUANTIZE_MOTION_STEPS /* 84 */:
                                            constraint.motion.mQuantizeMotionSteps = i9;
                                            break;
                                        default:
                                            switch (i8) {
                                                case UNUSED /* 87 */:
                                                    break;
                                                case QUANTIZE_MOTION_INTERPOLATOR_TYPE /* 88 */:
                                                    constraint.motion.mQuantizeInterpolatorType = i9;
                                                    break;
                                                case QUANTIZE_MOTION_INTERPOLATOR_ID /* 89 */:
                                                    constraint.motion.mQuantizeInterpolatorID = i9;
                                                    break;
                                                default:
                                                    Log.w(TAG, "Unknown attribute 0x");
                                                    break;
                                            }
                                            break;
                                    }
                                    break;
                            }
                            break;
                    }
                    break;
            }
            return;
        }
        constraint.layout.mBarrierMargin = i9;
    }

    public void clone(Constraints constraints) {
        int childCount = constraints.getChildCount();
        this.mConstraints.clear();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = constraints.getChildAt(i8);
            Constraints.LayoutParams layoutParams = (Constraints.LayoutParams) childAt.getLayoutParams();
            int id2 = childAt.getId();
            if (this.mForceId && id2 == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.mConstraints.containsKey(Integer.valueOf(id2))) {
                this.mConstraints.put(Integer.valueOf(id2), new Constraint());
            }
            Constraint constraint = this.mConstraints.get(Integer.valueOf(id2));
            if (constraint != null) {
                if (childAt instanceof ConstraintHelper) {
                    constraint.fillFromConstraints((ConstraintHelper) childAt, id2, layoutParams);
                }
                constraint.fillFromConstraints(id2, layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setDeltaValue(Constraint constraint, int i8, String str) {
        if (i8 == 5) {
            constraint.layout.dimensionRatio = str;
            return;
        }
        if (i8 == 65) {
            constraint.motion.mTransitionEasing = str;
            return;
        }
        if (i8 == CONSTRAINT_REFERENCED_IDS) {
            Layout layout = constraint.layout;
            layout.mReferenceIdString = str;
            layout.mReferenceIds = null;
        } else if (i8 == CONSTRAINT_TAG) {
            constraint.layout.mConstraintTag = str;
        } else if (i8 != UNUSED) {
            if (i8 != QUANTIZE_MOTION_INTERPOLATOR_STR) {
                Log.w(TAG, "Unknown attribute 0x");
            } else {
                constraint.motion.mQuantizeInterpolatorString = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setDeltaValue(Constraint constraint, int i8, boolean z2) {
        if (i8 == 44) {
            constraint.transform.applyElevation = z2;
            return;
        }
        if (i8 == BARRIER_ALLOWS_GONE_WIDGETS) {
            constraint.layout.mBarrierAllowsGoneWidgets = z2;
            return;
        }
        if (i8 != UNUSED) {
            if (i8 == CONSTRAINED_WIDTH) {
                constraint.layout.constrainedWidth = z2;
            } else if (i8 != CONSTRAINED_HEIGHT) {
                Log.w(TAG, "Unknown attribute 0x");
            } else {
                constraint.layout.constrainedHeight = z2;
            }
        }
    }

    public void connect(int i8, int i9, int i10, int i11) {
        if (!this.mConstraints.containsKey(Integer.valueOf(i8))) {
            this.mConstraints.put(Integer.valueOf(i8), new Constraint());
        }
        Constraint constraint = this.mConstraints.get(Integer.valueOf(i8));
        if (constraint == null) {
            return;
        }
        switch (i9) {
            case 1:
                if (i11 == 1) {
                    Layout layout = constraint.layout;
                    layout.leftToLeft = i10;
                    layout.leftToRight = -1;
                    return;
                } else {
                    if (i11 == 2) {
                        Layout layout2 = constraint.layout;
                        layout2.leftToRight = i10;
                        layout2.leftToLeft = -1;
                        return;
                    }
                    throw new IllegalArgumentException(h0.a.n(new StringBuilder("left to "), sideToString(i11), " undefined"));
                }
            case 2:
                if (i11 == 1) {
                    Layout layout3 = constraint.layout;
                    layout3.rightToLeft = i10;
                    layout3.rightToRight = -1;
                    return;
                } else {
                    if (i11 == 2) {
                        Layout layout4 = constraint.layout;
                        layout4.rightToRight = i10;
                        layout4.rightToLeft = -1;
                        return;
                    }
                    throw new IllegalArgumentException(h0.a.n(new StringBuilder("right to "), sideToString(i11), " undefined"));
                }
            case 3:
                if (i11 == 3) {
                    Layout layout5 = constraint.layout;
                    layout5.topToTop = i10;
                    layout5.topToBottom = -1;
                    layout5.baselineToBaseline = -1;
                    layout5.baselineToTop = -1;
                    layout5.baselineToBottom = -1;
                    return;
                }
                if (i11 == 4) {
                    Layout layout6 = constraint.layout;
                    layout6.topToBottom = i10;
                    layout6.topToTop = -1;
                    layout6.baselineToBaseline = -1;
                    layout6.baselineToTop = -1;
                    layout6.baselineToBottom = -1;
                    return;
                }
                throw new IllegalArgumentException(h0.a.n(new StringBuilder("right to "), sideToString(i11), " undefined"));
            case 4:
                if (i11 == 4) {
                    Layout layout7 = constraint.layout;
                    layout7.bottomToBottom = i10;
                    layout7.bottomToTop = -1;
                    layout7.baselineToBaseline = -1;
                    layout7.baselineToTop = -1;
                    layout7.baselineToBottom = -1;
                    return;
                }
                if (i11 == 3) {
                    Layout layout8 = constraint.layout;
                    layout8.bottomToTop = i10;
                    layout8.bottomToBottom = -1;
                    layout8.baselineToBaseline = -1;
                    layout8.baselineToTop = -1;
                    layout8.baselineToBottom = -1;
                    return;
                }
                throw new IllegalArgumentException(h0.a.n(new StringBuilder("right to "), sideToString(i11), " undefined"));
            case 5:
                if (i11 == 5) {
                    Layout layout9 = constraint.layout;
                    layout9.baselineToBaseline = i10;
                    layout9.bottomToBottom = -1;
                    layout9.bottomToTop = -1;
                    layout9.topToTop = -1;
                    layout9.topToBottom = -1;
                    return;
                }
                if (i11 == 3) {
                    Layout layout10 = constraint.layout;
                    layout10.baselineToTop = i10;
                    layout10.bottomToBottom = -1;
                    layout10.bottomToTop = -1;
                    layout10.topToTop = -1;
                    layout10.topToBottom = -1;
                    return;
                }
                if (i11 == 4) {
                    Layout layout11 = constraint.layout;
                    layout11.baselineToBottom = i10;
                    layout11.bottomToBottom = -1;
                    layout11.bottomToTop = -1;
                    layout11.topToTop = -1;
                    layout11.topToBottom = -1;
                    return;
                }
                throw new IllegalArgumentException(h0.a.n(new StringBuilder("right to "), sideToString(i11), " undefined"));
            case 6:
                if (i11 == 6) {
                    Layout layout12 = constraint.layout;
                    layout12.startToStart = i10;
                    layout12.startToEnd = -1;
                    return;
                } else {
                    if (i11 == 7) {
                        Layout layout13 = constraint.layout;
                        layout13.startToEnd = i10;
                        layout13.startToStart = -1;
                        return;
                    }
                    throw new IllegalArgumentException(h0.a.n(new StringBuilder("right to "), sideToString(i11), " undefined"));
                }
            case 7:
                if (i11 == 7) {
                    Layout layout14 = constraint.layout;
                    layout14.endToEnd = i10;
                    layout14.endToStart = -1;
                    return;
                } else {
                    if (i11 == 6) {
                        Layout layout15 = constraint.layout;
                        layout15.endToStart = i10;
                        layout15.endToEnd = -1;
                        return;
                    }
                    throw new IllegalArgumentException(h0.a.n(new StringBuilder("right to "), sideToString(i11), " undefined"));
                }
            default:
                StringBuilder sb2 = new StringBuilder();
                sb2.append(sideToString(i9));
                sb2.append(" to ");
                throw new IllegalArgumentException(h0.a.n(sb2, sideToString(i11), " unknown"));
        }
    }
}
