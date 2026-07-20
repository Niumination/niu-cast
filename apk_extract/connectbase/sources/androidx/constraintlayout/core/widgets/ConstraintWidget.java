package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.ArrayRow;
import androidx.constraintlayout.core.Cache;
import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.Metrics;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.state.WidgetFrame;
import androidx.constraintlayout.core.widgets.analyzer.ChainRun;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun;
import androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;
import c.a;
import ik.f;
import j.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import ks.g;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintWidget {
    public static final int ANCHOR_BASELINE = 4;
    public static final int ANCHOR_BOTTOM = 3;
    public static final int ANCHOR_LEFT = 0;
    public static final int ANCHOR_RIGHT = 1;
    public static final int ANCHOR_TOP = 2;
    private static final boolean AUTOTAG_CENTER = false;
    public static final int BOTH = 2;
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    public static float DEFAULT_BIAS = 0.5f;
    static final int DIMENSION_HORIZONTAL = 0;
    static final int DIMENSION_VERTICAL = 1;
    protected static final int DIRECT = 2;
    public static final int GONE = 8;
    public static final int HORIZONTAL = 0;
    public static final int INVISIBLE = 4;
    public static final int MATCH_CONSTRAINT_PERCENT = 2;
    public static final int MATCH_CONSTRAINT_RATIO = 3;
    public static final int MATCH_CONSTRAINT_RATIO_RESOLVED = 4;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    protected static final int SOLVER = 1;
    public static final int UNKNOWN = -1;
    private static final boolean USE_WRAP_DIMENSION_FOR_SPREAD = false;
    public static final int VERTICAL = 1;
    public static final int VISIBLE = 0;
    private static final int WRAP = -2;
    public static final int WRAP_BEHAVIOR_HORIZONTAL_ONLY = 1;
    public static final int WRAP_BEHAVIOR_INCLUDED = 0;
    public static final int WRAP_BEHAVIOR_SKIPPED = 3;
    public static final int WRAP_BEHAVIOR_VERTICAL_ONLY = 2;
    private boolean OPTIMIZE_WRAP;
    private boolean OPTIMIZE_WRAP_ON_RESOLVED;
    public WidgetFrame frame;
    private boolean hasBaseline;
    public ChainRun horizontalChainRun;
    public int horizontalGroup;
    public HorizontalWidgetRun horizontalRun;
    private boolean horizontalSolvingPass;
    private boolean inPlaceholder;
    public boolean[] isTerminalWidget;
    protected ArrayList<ConstraintAnchor> mAnchors;
    public ConstraintAnchor mBaseline;
    int mBaselineDistance;
    public ConstraintAnchor mBottom;
    boolean mBottomHasCentered;
    public ConstraintAnchor mCenter;
    ConstraintAnchor mCenterX;
    ConstraintAnchor mCenterY;
    private float mCircleConstraintAngle;
    private Object mCompanionWidget;
    private int mContainerItemSkip;
    private String mDebugName;
    public float mDimensionRatio;
    protected int mDimensionRatioSide;
    int mDistToBottom;
    int mDistToLeft;
    int mDistToRight;
    int mDistToTop;
    boolean mGroupsToSolver;
    int mHeight;
    private int mHeightOverride;
    float mHorizontalBiasPercent;
    boolean mHorizontalChainFixedPosition;
    int mHorizontalChainStyle;
    ConstraintWidget mHorizontalNextWidget;
    public int mHorizontalResolution;
    boolean mHorizontalWrapVisited;
    private boolean mInVirtualLayout;
    public boolean mIsHeightWrapContent;
    private boolean[] mIsInBarrier;
    public boolean mIsWidthWrapContent;
    private int mLastHorizontalMeasureSpec;
    private int mLastVerticalMeasureSpec;
    public ConstraintAnchor mLeft;
    boolean mLeftHasCentered;
    public ConstraintAnchor[] mListAnchors;
    public DimensionBehaviour[] mListDimensionBehaviors;
    protected ConstraintWidget[] mListNextMatchConstraintsWidget;
    public int mMatchConstraintDefaultHeight;
    public int mMatchConstraintDefaultWidth;
    public int mMatchConstraintMaxHeight;
    public int mMatchConstraintMaxWidth;
    public int mMatchConstraintMinHeight;
    public int mMatchConstraintMinWidth;
    public float mMatchConstraintPercentHeight;
    public float mMatchConstraintPercentWidth;
    private int[] mMaxDimension;
    private boolean mMeasureRequested;
    protected int mMinHeight;
    protected int mMinWidth;
    protected ConstraintWidget[] mNextChainWidget;
    protected int mOffsetX;
    protected int mOffsetY;
    public ConstraintWidget mParent;
    int mRelX;
    int mRelY;
    float mResolvedDimensionRatio;
    int mResolvedDimensionRatioSide;
    boolean mResolvedHasRatio;
    public int[] mResolvedMatchConstraintDefault;
    public ConstraintAnchor mRight;
    boolean mRightHasCentered;
    public ConstraintAnchor mTop;
    boolean mTopHasCentered;
    private String mType;
    float mVerticalBiasPercent;
    boolean mVerticalChainFixedPosition;
    int mVerticalChainStyle;
    ConstraintWidget mVerticalNextWidget;
    public int mVerticalResolution;
    boolean mVerticalWrapVisited;
    private int mVisibility;
    public float[] mWeight;
    int mWidth;
    private int mWidthOverride;
    private int mWrapBehaviorInParent;
    protected int mX;
    protected int mY;
    public boolean measured;
    private boolean resolvedHorizontal;
    private boolean resolvedVertical;
    public WidgetRun[] run;
    public String stringId;
    public ChainRun verticalChainRun;
    public int verticalGroup;
    public VerticalWidgetRun verticalRun;
    private boolean verticalSolvingPass;

    /* JADX INFO: renamed from: androidx.constraintlayout.core.widgets.ConstraintWidget$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type;
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintWidget$DimensionBehaviour;

        static {
            int[] iArr = new int[DimensionBehaviour.values().length];
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintWidget$DimensionBehaviour = iArr;
            try {
                iArr[DimensionBehaviour.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintWidget$DimensionBehaviour[DimensionBehaviour.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintWidget$DimensionBehaviour[DimensionBehaviour.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintWidget$DimensionBehaviour[DimensionBehaviour.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[ConstraintAnchor.Type.values().length];
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type = iArr2;
            try {
                iArr2[ConstraintAnchor.Type.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    public enum DimensionBehaviour {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public ConstraintWidget() {
        this.measured = false;
        this.run = new WidgetRun[2];
        this.horizontalRun = null;
        this.verticalRun = null;
        this.isTerminalWidget = new boolean[]{true, true};
        this.mResolvedHasRatio = false;
        this.mMeasureRequested = true;
        this.OPTIMIZE_WRAP = false;
        this.OPTIMIZE_WRAP_ON_RESOLVED = true;
        this.mWidthOverride = -1;
        this.mHeightOverride = -1;
        this.frame = new WidgetFrame(this);
        this.resolvedHorizontal = false;
        this.resolvedVertical = false;
        this.horizontalSolvingPass = false;
        this.verticalSolvingPass = false;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mWrapBehaviorInParent = 0;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = 0.0f;
        this.hasBaseline = false;
        this.mInVirtualLayout = false;
        this.mLastHorizontalMeasureSpec = 0;
        this.mLastVerticalMeasureSpec = 0;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mCenter = constraintAnchor;
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, constraintAnchor};
        this.mAnchors = new ArrayList<>();
        this.mIsInBarrier = new boolean[2];
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors = new DimensionBehaviour[]{dimensionBehaviour, dimensionBehaviour};
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        float f10 = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f10;
        this.mVerticalBiasPercent = f10;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        this.horizontalGroup = -1;
        this.verticalGroup = -1;
        addAnchors();
    }

    private void addAnchors() {
        this.mAnchors.add(this.mLeft);
        this.mAnchors.add(this.mTop);
        this.mAnchors.add(this.mRight);
        this.mAnchors.add(this.mBottom);
        this.mAnchors.add(this.mCenterX);
        this.mAnchors.add(this.mCenterY);
        this.mAnchors.add(this.mCenter);
        this.mAnchors.add(this.mBaseline);
    }

    /* JADX WARN: Code duplicated, block: B:104:0x0197  */
    /* JADX WARN: Code duplicated, block: B:107:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:109:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:235:0x03ac  */
    /* JADX WARN: Code duplicated, block: B:237:0x03b0  */
    /* JADX WARN: Code duplicated, block: B:243:0x03c3  */
    /* JADX WARN: Code duplicated, block: B:245:0x03f4  */
    /* JADX WARN: Code duplicated, block: B:252:0x040d  */
    /* JADX WARN: Code duplicated, block: B:261:0x042f  */
    /* JADX WARN: Code duplicated, block: B:271:0x0447  */
    /* JADX WARN: Code duplicated, block: B:274:0x044d  */
    /* JADX WARN: Code duplicated, block: B:275:0x044f A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:278:0x0455 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:281:0x045a  */
    /* JADX WARN: Code duplicated, block: B:284:0x0460  */
    /* JADX WARN: Code duplicated, block: B:286:0x0464  */
    /* JADX WARN: Code duplicated, block: B:289:0x0469  */
    /* JADX WARN: Code duplicated, block: B:291:0x046d  */
    /* JADX WARN: Code duplicated, block: B:293:0x0470  */
    /* JADX WARN: Code duplicated, block: B:296:0x0477  */
    /* JADX WARN: Code duplicated, block: B:298:0x047d A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:302:0x0485  */
    /* JADX WARN: Code duplicated, block: B:305:0x0497  */
    /* JADX WARN: Code duplicated, block: B:307:0x049b  */
    /* JADX WARN: Code duplicated, block: B:308:0x04a0  */
    /* JADX WARN: Code duplicated, block: B:310:0x04a3  */
    /* JADX WARN: Code duplicated, block: B:312:0x04a9 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:31:0x008c  */
    /* JADX WARN: Code duplicated, block: B:320:0x04c4  */
    /* JADX WARN: Code duplicated, block: B:364:0x053e  */
    /* JADX WARN: Code duplicated, block: B:38:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:40:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:44:0x00b2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:45:0x00b4 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:48:0x00bf A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:49:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:51:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:54:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:55:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:57:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:67:0x0113  */
    /* JADX WARN: Code duplicated, block: B:69:0x0116  */
    /* JADX WARN: Code duplicated, block: B:70:0x0118  */
    /* JADX WARN: Code duplicated, block: B:72:0x011b  */
    /* JADX WARN: Code duplicated, block: B:73:0x011d  */
    /* JADX WARN: Code duplicated, block: B:75:0x0120  */
    /* JADX WARN: Code duplicated, block: B:80:0x0128  */
    /* JADX WARN: Code duplicated, block: B:83:0x0132  */
    /* JADX WARN: Code duplicated, block: B:84:0x0134 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:86:0x0137  */
    /* JADX WARN: Code duplicated, block: B:89:0x0140 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:90:0x0142  */
    /* JADX WARN: Code duplicated, block: B:91:0x0147 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:92:0x0149  */
    /* JADX WARN: Code duplicated, block: B:93:0x0151  */
    /* JADX WARN: Code duplicated, block: B:95:0x0166  */
    /* JADX WARN: Code duplicated, block: B:97:0x016a  */
    /* JADX WARN: Code duplicated, block: B:99:0x0172  */
    private void applyConstraints(LinearSystem linearSystem, boolean z10, boolean z11, boolean z12, boolean z13, SolverVariable solverVariable, SolverVariable solverVariable2, DimensionBehaviour dimensionBehaviour, boolean z14, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i10, int i11, int i12, int i13, float f10, boolean z15, boolean z16, boolean z17, boolean z18, boolean z19, int i14, int i15, int i16, int i17, float f11, boolean z20) {
        int i18;
        boolean z21;
        int iMin;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        boolean z22;
        boolean z23;
        ConstraintAnchor.Type type;
        ConstraintAnchor.Type type2;
        SolverVariable solverVariableCreateObjectVariable;
        SolverVariable solverVariableCreateObjectVariable2;
        int i24;
        char c10;
        int i25;
        ConstraintAnchor constraintAnchor3;
        int i26;
        int i27;
        boolean z24;
        boolean z25;
        boolean z26;
        boolean z27;
        int i28;
        ConstraintWidget constraintWidget;
        boolean z28;
        ConstraintWidget constraintWidget2;
        int iMax;
        int i29;
        int i30;
        int margin;
        int iMin2;
        int i31;
        int i32;
        boolean z29;
        int i33;
        int i34;
        int i35;
        boolean z30;
        int i36;
        boolean z31;
        ConstraintWidget constraintWidget3;
        int i37;
        ConstraintWidget constraintWidget4;
        SolverVariable solverVariableCreateObjectVariable3 = linearSystem.createObjectVariable(constraintAnchor);
        SolverVariable solverVariableCreateObjectVariable4 = linearSystem.createObjectVariable(constraintAnchor2);
        SolverVariable solverVariableCreateObjectVariable5 = linearSystem.createObjectVariable(constraintAnchor.getTarget());
        SolverVariable solverVariableCreateObjectVariable6 = linearSystem.createObjectVariable(constraintAnchor2.getTarget());
        if (LinearSystem.getMetrics() != null) {
            LinearSystem.getMetrics().nonresolvedWidgets++;
        }
        boolean zIsConnected = constraintAnchor.isConnected();
        boolean zIsConnected2 = constraintAnchor2.isConnected();
        boolean zIsConnected3 = this.mCenter.isConnected();
        int i38 = zIsConnected2 ? (zIsConnected ? 1 : 0) + 1 : zIsConnected ? 1 : 0;
        if (zIsConnected3) {
            i38++;
        }
        int i39 = z15 ? 3 : i14;
        int i40 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$widgets$ConstraintWidget$DimensionBehaviour[dimensionBehaviour.ordinal()];
        if (i40 != 1 && i40 != 2 && i40 != 3 && i40 == 4) {
            i18 = i39;
            z21 = i18 != 4;
            iMin = this.mWidthOverride;
            if (iMin == -1 && z10) {
                this.mWidthOverride = -1;
                z21 = false;
            } else {
                iMin = i11;
            }
            i19 = this.mHeightOverride;
            if (i19 != -1 && !z10) {
                this.mHeightOverride = -1;
                iMin = i19;
                z21 = false;
            }
            if (this.mVisibility == 8) {
                iMin = 0;
                z21 = false;
            }
            if (z20) {
                if (zIsConnected && !zIsConnected2 && !zIsConnected3) {
                    linearSystem.addEquality(solverVariableCreateObjectVariable3, i10);
                } else if (zIsConnected && !zIsConnected2) {
                    linearSystem.addEquality(solverVariableCreateObjectVariable3, solverVariableCreateObjectVariable5, constraintAnchor.getMargin(), 8);
                }
            }
            if (!z21) {
                if (z14) {
                    linearSystem.addEquality(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, 0, 3);
                    if (i12 > 0) {
                        linearSystem.addGreaterThan(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, i12, 8);
                    }
                    if (i13 < Integer.MAX_VALUE) {
                        linearSystem.addLowerThan(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, i13, 8);
                    }
                } else {
                    linearSystem.addEquality(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, iMin, 8);
                }
                i21 = i17;
                i22 = i38;
                z22 = z21;
                z23 = z13;
                i23 = i16;
            } else if (i38 == 2 && !z15 && (i18 == 1 || i18 == 0)) {
                int iMax2 = Math.max(i16, iMin);
                if (i17 > 0) {
                    iMax2 = Math.min(i17, iMax2);
                }
                linearSystem.addEquality(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, iMax2, 8);
                z23 = z13;
                i21 = i17;
                i22 = i38;
                z22 = false;
                i23 = i16;
            } else {
                if (i16 == -2) {
                    i20 = iMin;
                } else {
                    i20 = i16;
                }
                if (i17 == -2) {
                    i21 = iMin;
                } else {
                    i21 = i17;
                }
                if (iMin > 0 && i18 != 1) {
                    iMin = 0;
                }
                if (i20 > 0) {
                    linearSystem.addGreaterThan(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, i20, 8);
                    iMin = Math.max(iMin, i20);
                }
                if (i21 > 0) {
                    if (z11 || i18 != 1) {
                        linearSystem.addLowerThan(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, i21, 8);
                    }
                    iMin = Math.min(iMin, i21);
                }
                if (i18 == 1) {
                    if (z11) {
                        linearSystem.addEquality(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, iMin, 8);
                    } else if (z17) {
                        linearSystem.addEquality(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, iMin, 5);
                        linearSystem.addLowerThan(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, iMin, 8);
                    } else {
                        linearSystem.addEquality(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, iMin, 5);
                        linearSystem.addLowerThan(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, iMin, 8);
                    }
                    i22 = i38;
                    z22 = z21;
                    z23 = z13;
                    i23 = i20;
                } else if (i18 == 2) {
                    type = constraintAnchor.getType();
                    type2 = ConstraintAnchor.Type.TOP;
                    if (type != type2 || constraintAnchor.getType() == ConstraintAnchor.Type.BOTTOM) {
                        solverVariableCreateObjectVariable = linearSystem.createObjectVariable(this.mParent.getAnchor(type2));
                        solverVariableCreateObjectVariable2 = linearSystem.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.BOTTOM));
                    } else {
                        solverVariableCreateObjectVariable = linearSystem.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.LEFT));
                        solverVariableCreateObjectVariable2 = linearSystem.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.RIGHT));
                    }
                    SolverVariable solverVariable3 = solverVariableCreateObjectVariable;
                    SolverVariable solverVariable4 = solverVariableCreateObjectVariable2;
                    ArrayRow arrayRowCreateRow = linearSystem.createRow();
                    i22 = i38 == true ? 1 : 0;
                    i23 = i20;
                    linearSystem.addConstraint(arrayRowCreateRow.createRowDimensionRatio(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, solverVariable4, solverVariable3, f11));
                    if (z11) {
                        z21 = false;
                    }
                    z22 = z21;
                    z23 = z13;
                } else {
                    i22 = i38;
                    i23 = i20;
                    z22 = z21;
                    z23 = true;
                }
            }
            if (z20 || z17) {
                i24 = 0;
                c10 = 2;
                if (i22 >= c10 && z11 && z23) {
                    linearSystem.addGreaterThan(solverVariableCreateObjectVariable3, solverVariable, i24, 8);
                    int i41 = (z10 || this.mBaseline.mTarget == null) ? 1 : i24;
                    if (z10 || (constraintAnchor3 = this.mBaseline.mTarget) == null) {
                        i25 = i41;
                    } else {
                        ConstraintWidget constraintWidget5 = constraintAnchor3.mOwner;
                        if (constraintWidget5.mDimensionRatio != 0.0f) {
                            DimensionBehaviour[] dimensionBehaviourArr = constraintWidget5.mListDimensionBehaviors;
                            DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[i24];
                            DimensionBehaviour dimensionBehaviour3 = DimensionBehaviour.MATCH_CONSTRAINT;
                            if (dimensionBehaviour2 == dimensionBehaviour3 && dimensionBehaviourArr[1] == dimensionBehaviour3) {
                                i25 = 1;
                            } else {
                                i25 = i24;
                            }
                        } else {
                            i25 = i24;
                        }
                    }
                    if (i25 != 0) {
                        linearSystem.addGreaterThan(solverVariable2, solverVariableCreateObjectVariable4, i24, 8);
                        return;
                    }
                    return;
                }
                return;
            }
            if (zIsConnected || zIsConnected2 || zIsConnected3) {
                if (!zIsConnected || zIsConnected2) {
                    if (zIsConnected || !zIsConnected2) {
                        if (zIsConnected && zIsConnected2) {
                            ConstraintWidget constraintWidget6 = constraintAnchor.mTarget.mOwner;
                            ConstraintWidget constraintWidget7 = constraintAnchor2.mTarget.mOwner;
                            ConstraintWidget parent = getParent();
                            int i42 = 6;
                            if (z22) {
                                if (i18 == 0) {
                                    if (i21 != 0 || i23 != 0) {
                                        z30 = false;
                                        i34 = 5;
                                        i36 = 5;
                                        z31 = true;
                                        z24 = true;
                                    } else if (solverVariableCreateObjectVariable5.isFinalValue && solverVariableCreateObjectVariable6.isFinalValue) {
                                        linearSystem.addEquality(solverVariableCreateObjectVariable3, solverVariableCreateObjectVariable5, constraintAnchor.getMargin(), 8);
                                        linearSystem.addEquality(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable6, -constraintAnchor2.getMargin(), 8);
                                        return;
                                    } else {
                                        z31 = false;
                                        z24 = false;
                                        i34 = 8;
                                        i36 = 8;
                                        z30 = true;
                                    }
                                    if ((constraintWidget6 instanceof Barrier) || (constraintWidget7 instanceof Barrier)) {
                                        solverVariable2 = solverVariable2;
                                        i26 = i34;
                                        i42 = 6;
                                        z26 = z30;
                                        z25 = z31;
                                        i27 = 4;
                                    } else {
                                        z26 = z30;
                                        z25 = z31;
                                        i27 = i36;
                                        i26 = i34;
                                        i42 = 6;
                                    }
                                } else if (i18 == 2) {
                                    if (!(constraintWidget6 instanceof Barrier) && !(constraintWidget7 instanceof Barrier)) {
                                        solverVariable2 = solverVariable2;
                                        i42 = 6;
                                        i26 = 5;
                                        i27 = 5;
                                    }
                                    z25 = true;
                                    z24 = true;
                                    z26 = false;
                                } else if (i18 == 1) {
                                    i26 = 8;
                                    i27 = 4;
                                    z25 = true;
                                    z24 = true;
                                    z26 = false;
                                } else if (i18 == 3) {
                                    if (this.mResolvedDimensionRatioSide == -1) {
                                        if (z18) {
                                            solverVariable2 = solverVariable2;
                                            i42 = z11 ? 5 : 4;
                                        } else {
                                            solverVariable2 = solverVariable2;
                                            i42 = 8;
                                        }
                                        i26 = 8;
                                    } else if (z15) {
                                        if (i15 == 2 || i15 == 1) {
                                            i34 = 5;
                                            i35 = 4;
                                        } else {
                                            i34 = 8;
                                            i35 = 5;
                                        }
                                        i27 = i35;
                                        z25 = true;
                                        z24 = true;
                                        z26 = true;
                                        i26 = i34;
                                        i42 = 6;
                                    } else {
                                        if (i21 > 0) {
                                            solverVariable2 = solverVariable2;
                                            i42 = 6;
                                            i26 = 5;
                                        } else {
                                            if (i21 != 0 || i23 != 0) {
                                                i26 = 5;
                                            } else if (z18) {
                                                i26 = (constraintWidget6 == parent || constraintWidget7 == parent) ? 5 : 4;
                                            } else {
                                                solverVariable2 = solverVariable2;
                                                i42 = 6;
                                                i26 = 5;
                                                i27 = 8;
                                            }
                                            i27 = 4;
                                        }
                                        z25 = true;
                                        z24 = true;
                                        z26 = true;
                                    }
                                    i27 = 5;
                                    z25 = true;
                                    z24 = true;
                                    z26 = true;
                                } else {
                                    solverVariable2 = solverVariable2;
                                    i42 = 6;
                                    i26 = 5;
                                    i27 = 4;
                                    z25 = false;
                                    z24 = false;
                                    z26 = false;
                                }
                                if (z24 || solverVariableCreateObjectVariable5 != solverVariableCreateObjectVariable6 || constraintWidget6 == parent) {
                                    z27 = true;
                                } else {
                                    z24 = false;
                                    z27 = false;
                                }
                                if (z25) {
                                    if (z22 && !z16 && !z18 && solverVariableCreateObjectVariable5 == solverVariable && solverVariableCreateObjectVariable6 == solverVariable2) {
                                        z28 = false;
                                        i33 = 8;
                                        i32 = 8;
                                        z29 = false;
                                    } else {
                                        z28 = z11;
                                        i32 = i42;
                                        z29 = z27;
                                        i33 = i26;
                                    }
                                    i28 = i18;
                                    constraintWidget = parent;
                                    linearSystem.addCentering(solverVariableCreateObjectVariable3, solverVariableCreateObjectVariable5, constraintAnchor.getMargin(), f10, solverVariableCreateObjectVariable6, solverVariableCreateObjectVariable4, constraintAnchor2.getMargin(), i32);
                                    i26 = i33;
                                    z27 = z29;
                                } else {
                                    i28 = i18;
                                    constraintWidget = parent;
                                    z28 = z11;
                                }
                                if (this.mVisibility != 8 && !constraintAnchor2.hasDependents()) {
                                    return;
                                }
                                if (z24) {
                                    if (z28 && solverVariableCreateObjectVariable5 != solverVariableCreateObjectVariable6 && !z22 && ((constraintWidget6 instanceof Barrier) || (constraintWidget7 instanceof Barrier))) {
                                        i26 = 6;
                                    }
                                    linearSystem.addGreaterThan(solverVariableCreateObjectVariable3, solverVariableCreateObjectVariable5, constraintAnchor.getMargin(), i26);
                                    solverVariableCreateObjectVariable4 = solverVariableCreateObjectVariable4;
                                    linearSystem.addLowerThan(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable6, -constraintAnchor2.getMargin(), i26);
                                } else {
                                    solverVariableCreateObjectVariable4 = solverVariableCreateObjectVariable4;
                                }
                                if (z28 || !z19 || (constraintWidget6 instanceof Barrier) || (constraintWidget7 instanceof Barrier)) {
                                    constraintWidget2 = constraintWidget;
                                } else {
                                    constraintWidget2 = constraintWidget;
                                    if (constraintWidget7 != constraintWidget2) {
                                        i26 = 6;
                                        iMax = 6;
                                        z27 = true;
                                    }
                                    if (z27) {
                                        if (z26 && (!z18 || z12)) {
                                            if (constraintWidget6 != constraintWidget2 || constraintWidget7 == constraintWidget2) {
                                                i31 = 6;
                                            } else {
                                                i31 = iMax;
                                            }
                                            if ((constraintWidget6 instanceof Guideline) || (constraintWidget7 instanceof Guideline)) {
                                                i31 = 5;
                                            }
                                            if ((constraintWidget6 instanceof Barrier) || (constraintWidget7 instanceof Barrier)) {
                                                i31 = 5;
                                            }
                                            if (z18) {
                                                i31 = 5;
                                            }
                                            iMax = Math.max(i31, iMax);
                                        }
                                        if (z28) {
                                            iMin2 = Math.min(i26, iMax);
                                            if (z15 || z18 || !(constraintWidget6 == constraintWidget2 || constraintWidget7 == constraintWidget2)) {
                                                iMax = iMin2;
                                            } else {
                                                iMax = 4;
                                            }
                                        }
                                        linearSystem.addEquality(solverVariableCreateObjectVariable3, solverVariableCreateObjectVariable5, constraintAnchor.getMargin(), iMax);
                                        linearSystem.addEquality(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable6, -constraintAnchor2.getMargin(), iMax);
                                    }
                                    if (z28) {
                                        if (solverVariable == solverVariableCreateObjectVariable5) {
                                            margin = constraintAnchor.getMargin();
                                        } else {
                                            margin = 0;
                                        }
                                        if (solverVariableCreateObjectVariable5 != solverVariable) {
                                            linearSystem.addGreaterThan(solverVariableCreateObjectVariable3, solverVariable, margin, 5);
                                        }
                                    }
                                    if (z28 || !z22 || i12 != 0 || i23 != 0) {
                                        i29 = 5;
                                        i30 = 0;
                                    } else if (z22 && i28 == 3) {
                                        i30 = 0;
                                        linearSystem.addGreaterThan(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, 0, 8);
                                        i29 = 5;
                                    } else {
                                        i30 = 0;
                                        i29 = 5;
                                        linearSystem.addGreaterThan(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, 0, 5);
                                    }
                                }
                                iMax = i27;
                                if (z27) {
                                    if (z26) {
                                        if (constraintWidget6 != constraintWidget2) {
                                            i31 = 6;
                                        } else {
                                            i31 = 6;
                                        }
                                        if (constraintWidget6 instanceof Guideline) {
                                            i31 = 5;
                                        } else {
                                            i31 = 5;
                                        }
                                        if (constraintWidget6 instanceof Barrier) {
                                            i31 = 5;
                                        } else {
                                            i31 = 5;
                                        }
                                        if (z18) {
                                            i31 = 5;
                                        }
                                        iMax = Math.max(i31, iMax);
                                    }
                                    if (z28) {
                                        iMin2 = Math.min(i26, iMax);
                                        if (z15) {
                                            iMax = iMin2;
                                        } else {
                                            iMax = iMin2;
                                        }
                                    }
                                    linearSystem.addEquality(solverVariableCreateObjectVariable3, solverVariableCreateObjectVariable5, constraintAnchor.getMargin(), iMax);
                                    linearSystem.addEquality(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable6, -constraintAnchor2.getMargin(), iMax);
                                }
                                if (z28) {
                                    if (solverVariable == solverVariableCreateObjectVariable5) {
                                        margin = constraintAnchor.getMargin();
                                    } else {
                                        margin = 0;
                                    }
                                    if (solverVariableCreateObjectVariable5 != solverVariable) {
                                        linearSystem.addGreaterThan(solverVariableCreateObjectVariable3, solverVariable, margin, 5);
                                    }
                                }
                                if (z28) {
                                    i29 = 5;
                                    i30 = 0;
                                } else {
                                    i29 = 5;
                                    i30 = 0;
                                }
                            } else if (solverVariableCreateObjectVariable5.isFinalValue && solverVariableCreateObjectVariable6.isFinalValue) {
                                linearSystem.addCentering(solverVariableCreateObjectVariable3, solverVariableCreateObjectVariable5, constraintAnchor.getMargin(), f10, solverVariableCreateObjectVariable6, solverVariableCreateObjectVariable4, constraintAnchor2.getMargin(), 8);
                                if (z11 && z23) {
                                    int margin2 = constraintAnchor2.mTarget != null ? constraintAnchor2.getMargin() : 0;
                                    if (solverVariableCreateObjectVariable6 != solverVariable2) {
                                        linearSystem.addGreaterThan(solverVariable2, solverVariableCreateObjectVariable4, margin2, 5);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            i26 = 5;
                            i27 = 4;
                            z25 = true;
                            z24 = true;
                            z26 = false;
                            if (z24) {
                                z27 = true;
                            } else {
                                z27 = true;
                            }
                            if (z25) {
                                if (z22) {
                                    z28 = z11;
                                    i32 = i42;
                                    z29 = z27;
                                    i33 = i26;
                                } else {
                                    z28 = z11;
                                    i32 = i42;
                                    z29 = z27;
                                    i33 = i26;
                                }
                                i28 = i18;
                                constraintWidget = parent;
                                linearSystem.addCentering(solverVariableCreateObjectVariable3, solverVariableCreateObjectVariable5, constraintAnchor.getMargin(), f10, solverVariableCreateObjectVariable6, solverVariableCreateObjectVariable4, constraintAnchor2.getMargin(), i32);
                                i26 = i33;
                                z27 = z29;
                            } else {
                                i28 = i18;
                                constraintWidget = parent;
                                z28 = z11;
                            }
                            if (this.mVisibility != 8) {
                            }
                            if (z24) {
                                if (z28) {
                                    i26 = 6;
                                }
                                linearSystem.addGreaterThan(solverVariableCreateObjectVariable3, solverVariableCreateObjectVariable5, constraintAnchor.getMargin(), i26);
                                solverVariableCreateObjectVariable4 = solverVariableCreateObjectVariable4;
                                linearSystem.addLowerThan(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable6, -constraintAnchor2.getMargin(), i26);
                            } else {
                                solverVariableCreateObjectVariable4 = solverVariableCreateObjectVariable4;
                            }
                            if (z28) {
                                constraintWidget2 = constraintWidget;
                                iMax = i27;
                            } else {
                                constraintWidget2 = constraintWidget;
                                iMax = i27;
                            }
                            if (z27) {
                                if (z26) {
                                    if (constraintWidget6 != constraintWidget2) {
                                        i31 = 6;
                                    } else {
                                        i31 = 6;
                                    }
                                    if (constraintWidget6 instanceof Guideline) {
                                        i31 = 5;
                                    } else {
                                        i31 = 5;
                                    }
                                    if (constraintWidget6 instanceof Barrier) {
                                        i31 = 5;
                                    } else {
                                        i31 = 5;
                                    }
                                    if (z18) {
                                        i31 = 5;
                                    }
                                    iMax = Math.max(i31, iMax);
                                }
                                if (z28) {
                                    iMin2 = Math.min(i26, iMax);
                                    if (z15) {
                                        iMax = iMin2;
                                    } else {
                                        iMax = iMin2;
                                    }
                                }
                                linearSystem.addEquality(solverVariableCreateObjectVariable3, solverVariableCreateObjectVariable5, constraintAnchor.getMargin(), iMax);
                                linearSystem.addEquality(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable6, -constraintAnchor2.getMargin(), iMax);
                            }
                            if (z28) {
                                if (solverVariable == solverVariableCreateObjectVariable5) {
                                    margin = constraintAnchor.getMargin();
                                } else {
                                    margin = 0;
                                }
                                if (solverVariableCreateObjectVariable5 != solverVariable) {
                                    linearSystem.addGreaterThan(solverVariableCreateObjectVariable3, solverVariable, margin, 5);
                                }
                            }
                            if (z28) {
                                i29 = 5;
                                i30 = 0;
                            } else {
                                i29 = 5;
                                i30 = 0;
                            }
                        }
                        i37 = i29;
                    } else {
                        linearSystem.addEquality(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable6, -constraintAnchor2.getMargin(), 8);
                        if (z11) {
                            if (this.OPTIMIZE_WRAP && solverVariableCreateObjectVariable3.isFinalValue && (constraintWidget3 = this.mParent) != null) {
                                ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) constraintWidget3;
                                if (z10) {
                                    constraintWidgetContainer.addHorizontalWrapMinVariable(constraintAnchor);
                                } else {
                                    constraintWidgetContainer.addVerticalWrapMinVariable(constraintAnchor);
                                }
                            } else {
                                i29 = 5;
                                linearSystem.addGreaterThan(solverVariableCreateObjectVariable3, solverVariable, 0, 5);
                                i30 = 0;
                            }
                        }
                    }
                    i30 = 0;
                    i29 = 5;
                } else {
                    z28 = z11;
                    i30 = 0;
                    i37 = (z11 && (constraintAnchor.mTarget.mOwner instanceof Barrier)) ? 8 : 5;
                    solverVariableCreateObjectVariable4 = solverVariableCreateObjectVariable4;
                }
                if (z28 || !z23) {
                    return;
                }
                int margin3 = constraintAnchor2.mTarget != null ? constraintAnchor2.getMargin() : i30;
                if (solverVariableCreateObjectVariable6 != solverVariable2) {
                    if (!this.OPTIMIZE_WRAP || !solverVariableCreateObjectVariable4.isFinalValue || (constraintWidget4 = this.mParent) == null) {
                        linearSystem.addGreaterThan(solverVariable2, solverVariableCreateObjectVariable4, margin3, i37);
                        return;
                    }
                    ConstraintWidgetContainer constraintWidgetContainer2 = (ConstraintWidgetContainer) constraintWidget4;
                    if (z10) {
                        constraintWidgetContainer2.addHorizontalWrapMaxVariable(constraintAnchor2);
                        return;
                    } else {
                        constraintWidgetContainer2.addVerticalWrapMaxVariable(constraintAnchor2);
                        return;
                    }
                }
                return;
            }
            i29 = 5;
            i30 = 0;
            z28 = z11;
            i37 = i29;
            if (z28) {
                return;
            } else {
                return;
            }
        }
        i18 = i39;
        iMin = this.mWidthOverride;
        if (iMin == -1) {
            iMin = i11;
        } else {
            iMin = i11;
        }
        i19 = this.mHeightOverride;
        if (i19 != -1) {
            this.mHeightOverride = -1;
            iMin = i19;
            z21 = false;
        }
        if (this.mVisibility == 8) {
            iMin = 0;
            z21 = false;
        }
        if (z20) {
            if (zIsConnected) {
                if (zIsConnected) {
                    linearSystem.addEquality(solverVariableCreateObjectVariable3, solverVariableCreateObjectVariable5, constraintAnchor.getMargin(), 8);
                }
            } else if (zIsConnected) {
                linearSystem.addEquality(solverVariableCreateObjectVariable3, solverVariableCreateObjectVariable5, constraintAnchor.getMargin(), 8);
            }
        }
        if (!z21) {
            if (z14) {
                linearSystem.addEquality(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, 0, 3);
                if (i12 > 0) {
                    linearSystem.addGreaterThan(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, i12, 8);
                }
                if (i13 < Integer.MAX_VALUE) {
                    linearSystem.addLowerThan(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, i13, 8);
                }
            } else {
                linearSystem.addEquality(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, iMin, 8);
            }
            i21 = i17;
            i22 = i38;
            z22 = z21;
            z23 = z13;
            i23 = i16;
        } else if (i38 == 2) {
            if (i16 == -2) {
                i20 = iMin;
            } else {
                i20 = i16;
            }
            if (i17 == -2) {
                i21 = iMin;
            } else {
                i21 = i17;
            }
            if (iMin > 0) {
                iMin = 0;
            }
            if (i20 > 0) {
                linearSystem.addGreaterThan(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, i20, 8);
                iMin = Math.max(iMin, i20);
            }
            if (i21 > 0) {
                if (z11) {
                    linearSystem.addLowerThan(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, i21, 8);
                } else {
                    linearSystem.addLowerThan(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, i21, 8);
                }
                iMin = Math.min(iMin, i21);
            }
            if (i18 == 1) {
                if (z11) {
                    linearSystem.addEquality(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, iMin, 8);
                } else if (z17) {
                    linearSystem.addEquality(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, iMin, 5);
                    linearSystem.addLowerThan(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, iMin, 8);
                } else {
                    linearSystem.addEquality(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, iMin, 5);
                    linearSystem.addLowerThan(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, iMin, 8);
                }
                i22 = i38;
                z22 = z21;
                z23 = z13;
                i23 = i20;
            } else if (i18 == 2) {
                type = constraintAnchor.getType();
                type2 = ConstraintAnchor.Type.TOP;
                if (type != type2) {
                    solverVariableCreateObjectVariable = linearSystem.createObjectVariable(this.mParent.getAnchor(type2));
                    solverVariableCreateObjectVariable2 = linearSystem.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.BOTTOM));
                } else {
                    solverVariableCreateObjectVariable = linearSystem.createObjectVariable(this.mParent.getAnchor(type2));
                    solverVariableCreateObjectVariable2 = linearSystem.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.BOTTOM));
                }
                SolverVariable solverVariable5 = solverVariableCreateObjectVariable;
                SolverVariable solverVariable6 = solverVariableCreateObjectVariable2;
                ArrayRow arrayRowCreateRow2 = linearSystem.createRow();
                i22 = i38 == true ? 1 : 0;
                i23 = i20;
                linearSystem.addConstraint(arrayRowCreateRow2.createRowDimensionRatio(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, solverVariable6, solverVariable5, f11));
                if (z11) {
                    z21 = false;
                }
                z22 = z21;
                z23 = z13;
            } else {
                i22 = i38;
                i23 = i20;
                z22 = z21;
                z23 = true;
            }
        } else {
            if (i16 == -2) {
                i20 = iMin;
            } else {
                i20 = i16;
            }
            if (i17 == -2) {
                i21 = iMin;
            } else {
                i21 = i17;
            }
            if (iMin > 0) {
                iMin = 0;
            }
            if (i20 > 0) {
                linearSystem.addGreaterThan(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, i20, 8);
                iMin = Math.max(iMin, i20);
            }
            if (i21 > 0) {
                if (z11) {
                    linearSystem.addLowerThan(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, i21, 8);
                } else {
                    linearSystem.addLowerThan(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, i21, 8);
                }
                iMin = Math.min(iMin, i21);
            }
            if (i18 == 1) {
                if (z11) {
                    linearSystem.addEquality(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, iMin, 8);
                } else if (z17) {
                    linearSystem.addEquality(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, iMin, 5);
                    linearSystem.addLowerThan(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, iMin, 8);
                } else {
                    linearSystem.addEquality(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, iMin, 5);
                    linearSystem.addLowerThan(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, iMin, 8);
                }
                i22 = i38;
                z22 = z21;
                z23 = z13;
                i23 = i20;
            } else if (i18 == 2) {
                type = constraintAnchor.getType();
                type2 = ConstraintAnchor.Type.TOP;
                if (type != type2) {
                    solverVariableCreateObjectVariable = linearSystem.createObjectVariable(this.mParent.getAnchor(type2));
                    solverVariableCreateObjectVariable2 = linearSystem.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.BOTTOM));
                } else {
                    solverVariableCreateObjectVariable = linearSystem.createObjectVariable(this.mParent.getAnchor(type2));
                    solverVariableCreateObjectVariable2 = linearSystem.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.BOTTOM));
                }
                SolverVariable solverVariable7 = solverVariableCreateObjectVariable;
                SolverVariable solverVariable8 = solverVariableCreateObjectVariable2;
                ArrayRow arrayRowCreateRow3 = linearSystem.createRow();
                i22 = i38 == true ? 1 : 0;
                i23 = i20;
                linearSystem.addConstraint(arrayRowCreateRow3.createRowDimensionRatio(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, solverVariable8, solverVariable7, f11));
                if (z11) {
                    z21 = false;
                }
                z22 = z21;
                z23 = z13;
            } else {
                i22 = i38;
                i23 = i20;
                z22 = z21;
                z23 = true;
            }
        }
        if (z20) {
            i24 = 0;
            c10 = 2;
        } else {
            i24 = 0;
            c10 = 2;
        }
        if (i22 >= c10) {
        }
    }

    private boolean isChainHead(int i10) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        int i11 = i10 * 2;
        ConstraintAnchor[] constraintAnchorArr = this.mListAnchors;
        ConstraintAnchor constraintAnchor3 = constraintAnchorArr[i11];
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
        return (constraintAnchor4 == null || constraintAnchor4.mTarget == constraintAnchor3 || (constraintAnchor2 = (constraintAnchor = constraintAnchorArr[i11 + 1]).mTarget) == null || constraintAnchor2.mTarget != constraintAnchor) ? false : true;
    }

    private void serializeAnchor(StringBuilder sb2, String str, ConstraintAnchor constraintAnchor) {
        if (constraintAnchor.mTarget == null) {
            return;
        }
        sb2.append(str);
        sb2.append(" : [ '");
        sb2.append(constraintAnchor.mTarget);
        sb2.append("',");
        sb2.append(constraintAnchor.mMargin);
        sb2.append(g.f9491d);
        sb2.append(constraintAnchor.mGoneMargin);
        sb2.append(g.f9491d);
        sb2.append(" ] ,\n");
    }

    private void serializeAttribute(StringBuilder sb2, String str, float f10, float f11) {
        if (f10 == f11) {
            return;
        }
        sb2.append(str);
        sb2.append(" :   ");
        sb2.append(f10);
        sb2.append(",\n");
    }

    private void serializeCircle(StringBuilder sb2, ConstraintAnchor constraintAnchor, float f10) {
        if (constraintAnchor.mTarget == null) {
            return;
        }
        sb2.append("circle : [ '");
        sb2.append(constraintAnchor.mTarget);
        sb2.append("',");
        sb2.append(constraintAnchor.mMargin);
        sb2.append(g.f9491d);
        sb2.append(f10);
        sb2.append(g.f9491d);
        sb2.append(" ] ,\n");
    }

    private void serializeDimensionRatio(StringBuilder sb2, String str, float f10, int i10) {
        if (f10 == 0.0f) {
            return;
        }
        sb2.append(str);
        sb2.append(" :  [");
        sb2.append(f10);
        sb2.append(g.f9491d);
        sb2.append(i10);
        sb2.append("");
        sb2.append("],\n");
    }

    private void serializeSize(StringBuilder sb2, String str, int i10, int i11, int i12, int i13, int i14, int i15, float f10, float f11) {
        sb2.append(str);
        sb2.append(" :  {\n");
        serializeAttribute(sb2, f.b.f7973h, i10, Integer.MIN_VALUE);
        serializeAttribute(sb2, "min", i11, 0);
        serializeAttribute(sb2, "max", i12, Integer.MAX_VALUE);
        serializeAttribute(sb2, "matchMin", i14, 0);
        serializeAttribute(sb2, "matchDef", i15, 0);
        serializeAttribute(sb2, "matchPercent", i15, 1);
        sb2.append("},\n");
    }

    public void addChildrenToSolverByDependency(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, HashSet<ConstraintWidget> hashSet, int i10, boolean z10) {
        if (z10) {
            if (!hashSet.contains(this)) {
                return;
            }
            Optimizer.checkMatchParent(constraintWidgetContainer, linearSystem, this);
            hashSet.remove(this);
            addToSolver(linearSystem, constraintWidgetContainer.optimizeFor(64));
        }
        if (i10 == 0) {
            HashSet<ConstraintAnchor> dependents = this.mLeft.getDependents();
            if (dependents != null) {
                Iterator<ConstraintAnchor> it = dependents.iterator();
                while (it.hasNext()) {
                    it.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i10, true);
                }
            }
            HashSet<ConstraintAnchor> dependents2 = this.mRight.getDependents();
            if (dependents2 != null) {
                Iterator<ConstraintAnchor> it2 = dependents2.iterator();
                while (it2.hasNext()) {
                    it2.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i10, true);
                }
                return;
            }
            return;
        }
        HashSet<ConstraintAnchor> dependents3 = this.mTop.getDependents();
        if (dependents3 != null) {
            Iterator<ConstraintAnchor> it3 = dependents3.iterator();
            while (it3.hasNext()) {
                it3.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i10, true);
            }
        }
        HashSet<ConstraintAnchor> dependents4 = this.mBottom.getDependents();
        if (dependents4 != null) {
            Iterator<ConstraintAnchor> it4 = dependents4.iterator();
            while (it4.hasNext()) {
                it4.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i10, true);
            }
        }
        HashSet<ConstraintAnchor> dependents5 = this.mBaseline.getDependents();
        if (dependents5 != null) {
            Iterator<ConstraintAnchor> it5 = dependents5.iterator();
            while (it5.hasNext()) {
                it5.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i10, true);
            }
        }
    }

    public boolean addFirst() {
        return (this instanceof VirtualLayout) || (this instanceof Guideline);
    }

    /* JADX WARN: Code duplicated, block: B:188:0x02d7  */
    /* JADX WARN: Code duplicated, block: B:190:0x02dc A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:192:0x02e1  */
    /* JADX WARN: Code duplicated, block: B:195:0x02e6  */
    /* JADX WARN: Code duplicated, block: B:199:0x02f0  */
    /* JADX WARN: Code duplicated, block: B:19:0x004f  */
    /* JADX WARN: Code duplicated, block: B:202:0x02fb  */
    /* JADX WARN: Code duplicated, block: B:205:0x0301  */
    /* JADX WARN: Code duplicated, block: B:207:0x0304  */
    /* JADX WARN: Code duplicated, block: B:208:0x0307  */
    /* JADX WARN: Code duplicated, block: B:211:0x0320  */
    /* JADX WARN: Code duplicated, block: B:220:0x0336  */
    /* JADX WARN: Code duplicated, block: B:232:0x038e  */
    /* JADX WARN: Code duplicated, block: B:235:0x03a8  */
    /* JADX WARN: Code duplicated, block: B:236:0x03b0  */
    /* JADX WARN: Code duplicated, block: B:239:0x03b6  */
    /* JADX WARN: Code duplicated, block: B:240:0x03bf  */
    /* JADX WARN: Code duplicated, block: B:243:0x03e3  */
    /* JADX WARN: Code duplicated, block: B:244:0x03e6  */
    /* JADX WARN: Code duplicated, block: B:247:0x0447  */
    /* JADX WARN: Code duplicated, block: B:249:0x044d  */
    /* JADX WARN: Code duplicated, block: B:251:0x0453  */
    /* JADX WARN: Code duplicated, block: B:264:0x04ab  */
    /* JADX WARN: Code duplicated, block: B:268:0x04bf  */
    /* JADX WARN: Code duplicated, block: B:269:0x04c1  */
    /* JADX WARN: Code duplicated, block: B:271:0x04c4  */
    /* JADX WARN: Code duplicated, block: B:309:0x05a3  */
    /* JADX WARN: Code duplicated, block: B:312:0x05ab  */
    /* JADX WARN: Code duplicated, block: B:314:0x05b2  */
    /* JADX WARN: Code duplicated, block: B:315:0x05c2  */
    /* JADX WARN: Code duplicated, block: B:318:0x05d9  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v3, types: [androidx.constraintlayout.core.widgets.ConstraintWidget] */
    /* JADX WARN: Type inference failed for: r15v5, types: [androidx.constraintlayout.core.widgets.ConstraintWidget] */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r15v8 */
    /* JADX WARN: Type inference failed for: r27v1 */
    /* JADX WARN: Type inference failed for: r27v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r27v3 */
    /* JADX WARN: Type inference failed for: r53v0, types: [androidx.constraintlayout.core.widgets.ConstraintWidget] */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v6 */
    public void addToSolver(LinearSystem linearSystem, boolean z10) {
        boolean z11;
        boolean z12;
        ConstraintWidget constraintWidget;
        ConstraintWidget constraintWidget2;
        boolean z13;
        boolean z14;
        int i10;
        boolean z15;
        int i11;
        boolean z16;
        DimensionBehaviour dimensionBehaviour;
        DimensionBehaviour dimensionBehaviour2;
        boolean z17;
        int i12;
        SolverVariable solverVariable;
        SolverVariable solverVariable2;
        int i13;
        int i14;
        int i15;
        ?? r15;
        int i16;
        ?? r16;
        int i17;
        ?? r27;
        VerticalWidgetRun verticalWidgetRun;
        DependencyNode dependencyNode;
        ConstraintWidget constraintWidget3;
        SolverVariable solverVariableCreateObjectVariable;
        ConstraintWidget constraintWidget4;
        SolverVariable solverVariableCreateObjectVariable2;
        DimensionBehaviour[] dimensionBehaviourArr;
        boolean z18;
        HorizontalWidgetRun horizontalWidgetRun;
        int i18;
        int i19;
        boolean zIsInHorizontalChain;
        boolean zIsInVerticalChain;
        HorizontalWidgetRun horizontalWidgetRun2;
        VerticalWidgetRun verticalWidgetRun2;
        SolverVariable solverVariableCreateObjectVariable3 = linearSystem.createObjectVariable(this.mLeft);
        SolverVariable solverVariableCreateObjectVariable4 = linearSystem.createObjectVariable(this.mRight);
        SolverVariable solverVariableCreateObjectVariable5 = linearSystem.createObjectVariable(this.mTop);
        SolverVariable solverVariableCreateObjectVariable6 = linearSystem.createObjectVariable(this.mBottom);
        SolverVariable solverVariableCreateObjectVariable7 = linearSystem.createObjectVariable(this.mBaseline);
        ConstraintWidget constraintWidget5 = this.mParent;
        if (constraintWidget5 == null) {
            z11 = false;
            z12 = false;
        } else {
            boolean z19 = constraintWidget5 != null && constraintWidget5.mListDimensionBehaviors[0] == DimensionBehaviour.WRAP_CONTENT;
            boolean z20 = constraintWidget5 != null && constraintWidget5.mListDimensionBehaviors[1] == DimensionBehaviour.WRAP_CONTENT;
            int i20 = this.mWrapBehaviorInParent;
            if (i20 == 1) {
                z11 = z19;
                z12 = false;
            } else if (i20 == 2) {
                z12 = z20;
                z11 = false;
            } else if (i20 != 3) {
                z12 = z20;
                z11 = z19;
            } else {
                z11 = false;
                z12 = false;
            }
        }
        if (this.mVisibility == 8 && !hasDependencies()) {
            boolean[] zArr = this.mIsInBarrier;
            if (!zArr[0] && !zArr[1]) {
                return;
            }
        }
        boolean z21 = this.resolvedHorizontal;
        if (z21 || this.resolvedVertical) {
            if (z21) {
                linearSystem.addEquality(solverVariableCreateObjectVariable3, this.mX);
                linearSystem.addEquality(solverVariableCreateObjectVariable4, this.mX + this.mWidth);
                if (z11 && (constraintWidget2 = this.mParent) != null) {
                    if (this.OPTIMIZE_WRAP_ON_RESOLVED) {
                        ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) constraintWidget2;
                        constraintWidgetContainer.addHorizontalWrapMinVariable(this.mLeft);
                        constraintWidgetContainer.addHorizontalWrapMaxVariable(this.mRight);
                    } else {
                        linearSystem.addGreaterThan(linearSystem.createObjectVariable(constraintWidget2.mRight), solverVariableCreateObjectVariable4, 0, 5);
                    }
                }
            }
            if (this.resolvedVertical) {
                linearSystem.addEquality(solverVariableCreateObjectVariable5, this.mY);
                linearSystem.addEquality(solverVariableCreateObjectVariable6, this.mY + this.mHeight);
                if (this.mBaseline.hasDependents()) {
                    linearSystem.addEquality(solverVariableCreateObjectVariable7, this.mY + this.mBaselineDistance);
                }
                if (z12 && (constraintWidget = this.mParent) != null) {
                    if (this.OPTIMIZE_WRAP_ON_RESOLVED) {
                        ConstraintWidgetContainer constraintWidgetContainer2 = (ConstraintWidgetContainer) constraintWidget;
                        constraintWidgetContainer2.addVerticalWrapMinVariable(this.mTop);
                        constraintWidgetContainer2.addVerticalWrapMaxVariable(this.mBottom);
                    } else {
                        linearSystem.addGreaterThan(linearSystem.createObjectVariable(constraintWidget.mBottom), solverVariableCreateObjectVariable6, 0, 5);
                    }
                }
            }
            if (this.resolvedHorizontal && this.resolvedVertical) {
                this.resolvedHorizontal = false;
                this.resolvedVertical = false;
                return;
            }
        }
        Metrics metrics = LinearSystem.sMetrics;
        if (metrics != null) {
            metrics.widgets++;
        }
        if (z10 && (horizontalWidgetRun2 = this.horizontalRun) != null && (verticalWidgetRun2 = this.verticalRun) != null) {
            DependencyNode dependencyNode2 = horizontalWidgetRun2.start;
            if (dependencyNode2.resolved && horizontalWidgetRun2.end.resolved && verticalWidgetRun2.start.resolved && verticalWidgetRun2.end.resolved) {
                if (metrics != null) {
                    metrics.graphSolved++;
                }
                linearSystem.addEquality(solverVariableCreateObjectVariable3, dependencyNode2.value);
                linearSystem.addEquality(solverVariableCreateObjectVariable4, this.horizontalRun.end.value);
                linearSystem.addEquality(solverVariableCreateObjectVariable5, this.verticalRun.start.value);
                linearSystem.addEquality(solverVariableCreateObjectVariable6, this.verticalRun.end.value);
                linearSystem.addEquality(solverVariableCreateObjectVariable7, this.verticalRun.baseline.value);
                if (this.mParent != null) {
                    if (z11 && this.isTerminalWidget[0] && !isInHorizontalChain()) {
                        linearSystem.addGreaterThan(linearSystem.createObjectVariable(this.mParent.mRight), solverVariableCreateObjectVariable4, 0, 8);
                    }
                    if (z12 && this.isTerminalWidget[1] && !isInVerticalChain()) {
                        linearSystem.addGreaterThan(linearSystem.createObjectVariable(this.mParent.mBottom), solverVariableCreateObjectVariable6, 0, 8);
                    }
                }
                this.resolvedHorizontal = false;
                this.resolvedVertical = false;
                return;
            }
        }
        if (metrics != null) {
            metrics.linearSolved++;
        }
        if (this.mParent != null) {
            if (isChainHead(0)) {
                ((ConstraintWidgetContainer) this.mParent).addChain(this, 0);
                zIsInHorizontalChain = true;
            } else {
                zIsInHorizontalChain = isInHorizontalChain();
            }
            if (isChainHead(1)) {
                ((ConstraintWidgetContainer) this.mParent).addChain(this, 1);
                zIsInVerticalChain = true;
            } else {
                zIsInVerticalChain = isInVerticalChain();
            }
            if (!zIsInHorizontalChain && z11 && this.mVisibility != 8 && this.mLeft.mTarget == null && this.mRight.mTarget == null) {
                linearSystem.addGreaterThan(linearSystem.createObjectVariable(this.mParent.mRight), solverVariableCreateObjectVariable4, 0, 1);
            }
            if (!zIsInVerticalChain && z12 && this.mVisibility != 8 && this.mTop.mTarget == null && this.mBottom.mTarget == null && this.mBaseline == null) {
                linearSystem.addGreaterThan(linearSystem.createObjectVariable(this.mParent.mBottom), solverVariableCreateObjectVariable6, 0, 1);
            }
            z14 = zIsInHorizontalChain;
            z13 = zIsInVerticalChain;
        } else {
            z13 = false;
            z14 = false;
        }
        int i21 = this.mWidth;
        int i22 = this.mMinWidth;
        if (i21 >= i22) {
            i22 = i21;
        }
        int i23 = this.mHeight;
        int i24 = this.mMinHeight;
        if (i23 >= i24) {
            i24 = i23;
        }
        DimensionBehaviour[] dimensionBehaviourArr2 = this.mListDimensionBehaviors;
        DimensionBehaviour dimensionBehaviour3 = dimensionBehaviourArr2[0];
        DimensionBehaviour dimensionBehaviour4 = DimensionBehaviour.MATCH_CONSTRAINT;
        int i25 = i22;
        boolean z22 = dimensionBehaviour3 != dimensionBehaviour4;
        DimensionBehaviour dimensionBehaviour5 = dimensionBehaviourArr2[1];
        int i26 = i24;
        SolverVariable solverVariable3 = solverVariableCreateObjectVariable7;
        boolean z23 = dimensionBehaviour5 != dimensionBehaviour4;
        int i27 = this.mDimensionRatioSide;
        this.mResolvedDimensionRatioSide = i27;
        SolverVariable solverVariable4 = solverVariableCreateObjectVariable6;
        float f10 = this.mDimensionRatio;
        this.mResolvedDimensionRatio = f10;
        SolverVariable solverVariable5 = solverVariableCreateObjectVariable5;
        int i28 = this.mMatchConstraintDefaultWidth;
        int i29 = this.mMatchConstraintDefaultHeight;
        if (f10 > 0.0f && this.mVisibility != 8) {
            if (dimensionBehaviour3 == dimensionBehaviour4 && i28 == 0) {
                i28 = 3;
            }
            if (dimensionBehaviour5 == dimensionBehaviour4 && i29 == 0) {
                i29 = 3;
            }
            if (dimensionBehaviour3 == dimensionBehaviour4 && dimensionBehaviour5 == dimensionBehaviour4) {
                i19 = 3;
                if (i28 == 3 && i29 == 3) {
                    setupDimensionRatio(z11, z12, z22, z23);
                }
                i25 = i25;
                i10 = i26;
                z15 = true;
                int[] iArr = this.mResolvedMatchConstraintDefault;
                iArr[0] = i28;
                iArr[1] = i29;
                this.mResolvedHasRatio = z15;
                if (z15) {
                    int i30 = this.mResolvedDimensionRatioSide;
                    i11 = -1;
                    boolean z24 = i30 != 0 || i30 == -1;
                    if (z15 || !((i18 = this.mResolvedDimensionRatioSide) == 1 || i18 == i11)) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    dimensionBehaviour = this.mListDimensionBehaviors[0];
                    dimensionBehaviour2 = DimensionBehaviour.WRAP_CONTENT;
                    if (dimensionBehaviour == dimensionBehaviour2 || !(this instanceof ConstraintWidgetContainer)) {
                        z17 = false;
                    } else {
                        z17 = true;
                    }
                    if (z17) {
                        i12 = 0;
                    } else {
                        i12 = i25;
                    }
                    boolean z25 = !this.mCenter.isConnected();
                    boolean[] zArr2 = this.mIsInBarrier;
                    boolean z26 = zArr2[0];
                    boolean z27 = zArr2[1];
                    if (this.mHorizontalResolution != 2 || this.resolvedHorizontal) {
                        solverVariable = solverVariableCreateObjectVariable4;
                        solverVariable2 = solverVariableCreateObjectVariable3;
                    } else if (!z10 || (horizontalWidgetRun = this.horizontalRun) == null) {
                        constraintWidget3 = this.mParent;
                        if (constraintWidget3 != null) {
                            solverVariableCreateObjectVariable = linearSystem.createObjectVariable(constraintWidget3.mRight);
                        } else {
                            solverVariableCreateObjectVariable = null;
                        }
                        constraintWidget4 = this.mParent;
                        if (constraintWidget4 != null) {
                            solverVariableCreateObjectVariable2 = linearSystem.createObjectVariable(constraintWidget4.mLeft);
                        } else {
                            solverVariableCreateObjectVariable2 = null;
                        }
                        boolean z28 = this.isTerminalWidget[0];
                        dimensionBehaviourArr = this.mListDimensionBehaviors;
                        DimensionBehaviour dimensionBehaviour6 = dimensionBehaviourArr[0];
                        ConstraintAnchor constraintAnchor = this.mLeft;
                        ConstraintAnchor constraintAnchor2 = this.mRight;
                        int i31 = this.mX;
                        int i32 = this.mMinWidth;
                        int i33 = this.mMaxDimension[0];
                        float f11 = this.mHorizontalBiasPercent;
                        if (dimensionBehaviourArr[1] == dimensionBehaviour4) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                        solverVariable = solverVariableCreateObjectVariable4;
                        solverVariable2 = solverVariableCreateObjectVariable3;
                        applyConstraints(linearSystem, true, z11, z12, z28, solverVariableCreateObjectVariable2, solverVariableCreateObjectVariable, dimensionBehaviour6, z17, constraintAnchor, constraintAnchor2, i31, i12, i32, i33, f11, z24, z18, z14, z13, z26, i28, i29, this.mMatchConstraintMinWidth, this.mMatchConstraintMaxWidth, this.mMatchConstraintPercentWidth, z25);
                    } else {
                        DependencyNode dependencyNode3 = horizontalWidgetRun.start;
                        if (!dependencyNode3.resolved || !horizontalWidgetRun.end.resolved) {
                            constraintWidget3 = this.mParent;
                            if (constraintWidget3 != null) {
                                solverVariableCreateObjectVariable = linearSystem.createObjectVariable(constraintWidget3.mRight);
                            } else {
                                solverVariableCreateObjectVariable = null;
                            }
                            constraintWidget4 = this.mParent;
                            if (constraintWidget4 != null) {
                                solverVariableCreateObjectVariable2 = linearSystem.createObjectVariable(constraintWidget4.mLeft);
                            } else {
                                solverVariableCreateObjectVariable2 = null;
                            }
                            boolean z29 = this.isTerminalWidget[0];
                            dimensionBehaviourArr = this.mListDimensionBehaviors;
                            DimensionBehaviour dimensionBehaviour7 = dimensionBehaviourArr[0];
                            ConstraintAnchor constraintAnchor3 = this.mLeft;
                            ConstraintAnchor constraintAnchor4 = this.mRight;
                            int i34 = this.mX;
                            int i35 = this.mMinWidth;
                            int i36 = this.mMaxDimension[0];
                            float f12 = this.mHorizontalBiasPercent;
                            if (dimensionBehaviourArr[1] == dimensionBehaviour4) {
                                z18 = true;
                            } else {
                                z18 = false;
                            }
                            solverVariable = solverVariableCreateObjectVariable4;
                            solverVariable2 = solverVariableCreateObjectVariable3;
                            applyConstraints(linearSystem, true, z11, z12, z29, solverVariableCreateObjectVariable2, solverVariableCreateObjectVariable, dimensionBehaviour7, z17, constraintAnchor3, constraintAnchor4, i34, i12, i35, i36, f12, z24, z18, z14, z13, z26, i28, i29, this.mMatchConstraintMinWidth, this.mMatchConstraintMaxWidth, this.mMatchConstraintPercentWidth, z25);
                        } else if (z10) {
                            linearSystem.addEquality(solverVariableCreateObjectVariable3, dependencyNode3.value);
                            linearSystem.addEquality(solverVariableCreateObjectVariable4, this.horizontalRun.end.value);
                            if (this.mParent != null && z11 && this.isTerminalWidget[0] && !isInHorizontalChain()) {
                                linearSystem.addGreaterThan(linearSystem.createObjectVariable(this.mParent.mRight), solverVariableCreateObjectVariable4, 0, 8);
                            }
                            solverVariable = solverVariableCreateObjectVariable4;
                            solverVariable2 = solverVariableCreateObjectVariable3;
                        } else {
                            solverVariable = solverVariableCreateObjectVariable4;
                            solverVariable2 = solverVariableCreateObjectVariable3;
                        }
                    }
                    if (z10) {
                        ?? r17 = this;
                        verticalWidgetRun = r17.verticalRun;
                        if (verticalWidgetRun != null) {
                            dependencyNode = verticalWidgetRun.start;
                            if (!dependencyNode.resolved && verticalWidgetRun.end.resolved) {
                                linearSystem = linearSystem;
                                solverVariable5 = solverVariable5;
                                linearSystem.addEquality(solverVariable5, dependencyNode.value);
                                solverVariable4 = solverVariable4;
                                linearSystem.addEquality(solverVariable4, r17.verticalRun.end.value);
                                solverVariable3 = solverVariable3;
                                linearSystem.addEquality(solverVariable3, r17.verticalRun.baseline.value);
                                ConstraintWidget constraintWidget6 = r17.mParent;
                                if (constraintWidget6 == null || z13 || !z12) {
                                    i13 = 8;
                                    i14 = 0;
                                    i15 = 1;
                                } else {
                                    i15 = 1;
                                    if (r17.isTerminalWidget[1]) {
                                        i13 = 8;
                                        i14 = 0;
                                        linearSystem.addGreaterThan(linearSystem.createObjectVariable(constraintWidget6.mBottom), solverVariable4, 0, 8);
                                    } else {
                                        i13 = 8;
                                        i14 = 0;
                                    }
                                }
                                i16 = i14;
                                r16 = r17;
                            }
                            if (r16.mVerticalResolution == 2) {
                                i17 = i14;
                            } else {
                                i17 = i16;
                            }
                            if (i17 == 0 && !r16.resolvedVertical) {
                                ?? r10 = (r16.mListDimensionBehaviors[i15] == dimensionBehaviour2 && (r16 instanceof ConstraintWidgetContainer)) ? i15 : i14;
                                if (r10 != 0) {
                                    i10 = i14;
                                }
                                ConstraintWidget constraintWidget7 = r16.mParent;
                                SolverVariable solverVariableCreateObjectVariable8 = constraintWidget7 != null ? linearSystem.createObjectVariable(constraintWidget7.mBottom) : null;
                                ConstraintWidget constraintWidget8 = r16.mParent;
                                SolverVariable solverVariableCreateObjectVariable9 = constraintWidget8 != null ? linearSystem.createObjectVariable(constraintWidget8.mTop) : null;
                                if (r16.mBaselineDistance > 0 || r16.mVisibility == i13) {
                                    ConstraintAnchor constraintAnchor5 = r16.mBaseline;
                                    if (constraintAnchor5.mTarget != null) {
                                        linearSystem.addEquality(solverVariable3, solverVariable5, getBaselineDistance(), i13);
                                        linearSystem.addEquality(solverVariable3, linearSystem.createObjectVariable(r16.mBaseline.mTarget), r16.mBaseline.getMargin(), i13);
                                        if (z12 != 0) {
                                            linearSystem.addGreaterThan(solverVariableCreateObjectVariable8, linearSystem.createObjectVariable(r16.mBottom), i14, 5);
                                        }
                                        r27 = i14;
                                    } else {
                                        if (r16.mVisibility == i13) {
                                            linearSystem.addEquality(solverVariable3, solverVariable5, constraintAnchor5.getMargin(), i13);
                                        } else {
                                            linearSystem.addEquality(solverVariable3, solverVariable5, getBaselineDistance(), i13);
                                        }
                                        r27 = z25;
                                    }
                                } else {
                                    r27 = z25;
                                }
                                boolean z30 = r16.isTerminalWidget[i15];
                                DimensionBehaviour[] dimensionBehaviourArr3 = r16.mListDimensionBehaviors;
                                applyConstraints(linearSystem, false, z12, z11, z30, solverVariableCreateObjectVariable9, solverVariableCreateObjectVariable8, dimensionBehaviourArr3[i15], r10, r16.mTop, r16.mBottom, r16.mY, i10, r16.mMinHeight, r16.mMaxDimension[i15], r16.mVerticalBiasPercent, z16, dimensionBehaviourArr3[0] == dimensionBehaviour4, z13, z14, z27, i29, i28, r16.mMatchConstraintMinHeight, r16.mMatchConstraintMaxHeight, r16.mMatchConstraintPercentHeight, r27);
                            }
                            if (z15) {
                                if (this.mResolvedDimensionRatioSide == 1) {
                                    linearSystem.addRatio(solverVariable4, solverVariable5, solverVariable, solverVariable2, this.mResolvedDimensionRatio, 8);
                                } else {
                                    linearSystem.addRatio(solverVariable, solverVariable2, solverVariable4, solverVariable5, this.mResolvedDimensionRatio, 8);
                                }
                            }
                            if (this.mCenter.isConnected()) {
                                linearSystem.addCenterPoint(this, this.mCenter.getTarget().getOwner(), (float) Math.toRadians(this.mCircleConstraintAngle + 90.0f), this.mCenter.getMargin());
                            }
                            this.resolvedHorizontal = false;
                            this.resolvedVertical = false;
                        }
                        i13 = 8;
                        i14 = 0;
                        i15 = 1;
                        r15 = r17;
                    } else {
                        i13 = 8;
                        i14 = 0;
                        i15 = 1;
                        r15 = this;
                    }
                    i16 = i15;
                    r16 = r15;
                    if (r16.mVerticalResolution == 2) {
                        i17 = i14;
                    } else {
                        i17 = i16;
                    }
                    if (i17 == 0) {
                    }
                    if (z15) {
                        if (this.mResolvedDimensionRatioSide == 1) {
                            linearSystem.addRatio(solverVariable4, solverVariable5, solverVariable, solverVariable2, this.mResolvedDimensionRatio, 8);
                        } else {
                            linearSystem.addRatio(solverVariable, solverVariable2, solverVariable4, solverVariable5, this.mResolvedDimensionRatio, 8);
                        }
                    }
                    if (this.mCenter.isConnected()) {
                        linearSystem.addCenterPoint(this, this.mCenter.getTarget().getOwner(), (float) Math.toRadians(this.mCircleConstraintAngle + 90.0f), this.mCenter.getMargin());
                    }
                    this.resolvedHorizontal = false;
                    this.resolvedVertical = false;
                }
                i11 = -1;
                if (z15) {
                    z16 = false;
                } else {
                    z16 = false;
                }
                dimensionBehaviour = this.mListDimensionBehaviors[0];
                dimensionBehaviour2 = DimensionBehaviour.WRAP_CONTENT;
                if (dimensionBehaviour == dimensionBehaviour2) {
                    z17 = false;
                } else {
                    z17 = false;
                }
                if (z17) {
                    i12 = 0;
                } else {
                    i12 = i25;
                }
                boolean z210 = !this.mCenter.isConnected();
                boolean[] zArr3 = this.mIsInBarrier;
                boolean z211 = zArr3[0];
                boolean z212 = zArr3[1];
                if (this.mHorizontalResolution != 2) {
                    solverVariable = solverVariableCreateObjectVariable4;
                    solverVariable2 = solverVariableCreateObjectVariable3;
                } else {
                    solverVariable = solverVariableCreateObjectVariable4;
                    solverVariable2 = solverVariableCreateObjectVariable3;
                }
                if (z10) {
                    ?? r18 = this;
                    verticalWidgetRun = r18.verticalRun;
                    if (verticalWidgetRun != null) {
                        dependencyNode = verticalWidgetRun.start;
                        if (!dependencyNode.resolved) {
                        }
                    }
                    i13 = 8;
                    i14 = 0;
                    i15 = 1;
                    r15 = r18;
                } else {
                    i13 = 8;
                    i14 = 0;
                    i15 = 1;
                    r15 = this;
                }
                i16 = i15;
                r16 = r15;
                if (r16.mVerticalResolution == 2) {
                    i17 = i14;
                } else {
                    i17 = i16;
                }
                if (i17 == 0) {
                }
                if (z15) {
                    if (this.mResolvedDimensionRatioSide == 1) {
                        linearSystem.addRatio(solverVariable4, solverVariable5, solverVariable, solverVariable2, this.mResolvedDimensionRatio, 8);
                    } else {
                        linearSystem.addRatio(solverVariable, solverVariable2, solverVariable4, solverVariable5, this.mResolvedDimensionRatio, 8);
                    }
                }
                if (this.mCenter.isConnected()) {
                    linearSystem.addCenterPoint(this, this.mCenter.getTarget().getOwner(), (float) Math.toRadians(this.mCircleConstraintAngle + 90.0f), this.mCenter.getMargin());
                }
                this.resolvedHorizontal = false;
                this.resolvedVertical = false;
            }
            i19 = 3;
            if (dimensionBehaviour3 == dimensionBehaviour4 && i28 == i19) {
                this.mResolvedDimensionRatioSide = 0;
                int i37 = (int) (f10 * i23);
                if (dimensionBehaviour5 != dimensionBehaviour4) {
                    i28 = 4;
                    i29 = i29;
                    i10 = i26;
                    z15 = false;
                    i25 = i37;
                } else {
                    i25 = i37;
                    i10 = i26;
                    z15 = true;
                }
            } else {
                if (dimensionBehaviour5 == dimensionBehaviour4 && i29 == i19) {
                    this.mResolvedDimensionRatioSide = 1;
                    if (i27 == -1) {
                        this.mResolvedDimensionRatio = 1.0f / f10;
                    }
                    int i38 = (int) (this.mResolvedDimensionRatio * i21);
                    if (dimensionBehaviour3 != dimensionBehaviour4) {
                        i29 = 4;
                        i10 = i38;
                        i28 = i28;
                    } else {
                        i10 = i38;
                        i28 = i28;
                        i29 = i29;
                        i25 = i25;
                    }
                } else {
                    i25 = i25;
                    i10 = i26;
                }
                z15 = true;
            }
            int[] iArr2 = this.mResolvedMatchConstraintDefault;
            iArr2[0] = i28;
            iArr2[1] = i29;
            this.mResolvedHasRatio = z15;
            if (z15) {
                int i39 = this.mResolvedDimensionRatioSide;
                i11 = -1;
                if (i39 != 0) {
                }
                if (z15) {
                    z16 = false;
                } else {
                    z16 = false;
                }
                dimensionBehaviour = this.mListDimensionBehaviors[0];
                dimensionBehaviour2 = DimensionBehaviour.WRAP_CONTENT;
                if (dimensionBehaviour == dimensionBehaviour2) {
                    z17 = false;
                } else {
                    z17 = false;
                }
                if (z17) {
                    i12 = 0;
                } else {
                    i12 = i25;
                }
                boolean z213 = !this.mCenter.isConnected();
                boolean[] zArr4 = this.mIsInBarrier;
                boolean z214 = zArr4[0];
                boolean z215 = zArr4[1];
                if (this.mHorizontalResolution != 2) {
                    solverVariable = solverVariableCreateObjectVariable4;
                    solverVariable2 = solverVariableCreateObjectVariable3;
                } else {
                    solverVariable = solverVariableCreateObjectVariable4;
                    solverVariable2 = solverVariableCreateObjectVariable3;
                }
                if (z10) {
                    ?? r19 = this;
                    verticalWidgetRun = r19.verticalRun;
                    if (verticalWidgetRun != null) {
                        dependencyNode = verticalWidgetRun.start;
                        if (!dependencyNode.resolved) {
                        }
                    }
                    i13 = 8;
                    i14 = 0;
                    i15 = 1;
                    r15 = r19;
                } else {
                    i13 = 8;
                    i14 = 0;
                    i15 = 1;
                    r15 = this;
                }
                i16 = i15;
                r16 = r15;
                if (r16.mVerticalResolution == 2) {
                    i17 = i14;
                } else {
                    i17 = i16;
                }
                if (i17 == 0) {
                }
                if (z15) {
                    if (this.mResolvedDimensionRatioSide == 1) {
                        linearSystem.addRatio(solverVariable4, solverVariable5, solverVariable, solverVariable2, this.mResolvedDimensionRatio, 8);
                    } else {
                        linearSystem.addRatio(solverVariable, solverVariable2, solverVariable4, solverVariable5, this.mResolvedDimensionRatio, 8);
                    }
                }
                if (this.mCenter.isConnected()) {
                    linearSystem.addCenterPoint(this, this.mCenter.getTarget().getOwner(), (float) Math.toRadians(this.mCircleConstraintAngle + 90.0f), this.mCenter.getMargin());
                }
                this.resolvedHorizontal = false;
                this.resolvedVertical = false;
            }
            i11 = -1;
            if (z15) {
                z16 = false;
            } else {
                z16 = false;
            }
            dimensionBehaviour = this.mListDimensionBehaviors[0];
            dimensionBehaviour2 = DimensionBehaviour.WRAP_CONTENT;
            if (dimensionBehaviour == dimensionBehaviour2) {
                z17 = false;
            } else {
                z17 = false;
            }
            if (z17) {
                i12 = 0;
            } else {
                i12 = i25;
            }
            boolean z216 = !this.mCenter.isConnected();
            boolean[] zArr5 = this.mIsInBarrier;
            boolean z217 = zArr5[0];
            boolean z218 = zArr5[1];
            if (this.mHorizontalResolution != 2) {
                solverVariable = solverVariableCreateObjectVariable4;
                solverVariable2 = solverVariableCreateObjectVariable3;
            } else {
                solverVariable = solverVariableCreateObjectVariable4;
                solverVariable2 = solverVariableCreateObjectVariable3;
            }
            if (z10) {
                ?? r110 = this;
                verticalWidgetRun = r110.verticalRun;
                if (verticalWidgetRun != null) {
                    dependencyNode = verticalWidgetRun.start;
                    if (!dependencyNode.resolved) {
                    }
                }
                i13 = 8;
                i14 = 0;
                i15 = 1;
                r15 = r110;
            } else {
                i13 = 8;
                i14 = 0;
                i15 = 1;
                r15 = this;
            }
            i16 = i15;
            r16 = r15;
            if (r16.mVerticalResolution == 2) {
                i17 = i14;
            } else {
                i17 = i16;
            }
            if (i17 == 0) {
            }
            if (z15) {
                if (this.mResolvedDimensionRatioSide == 1) {
                    linearSystem.addRatio(solverVariable4, solverVariable5, solverVariable, solverVariable2, this.mResolvedDimensionRatio, 8);
                } else {
                    linearSystem.addRatio(solverVariable, solverVariable2, solverVariable4, solverVariable5, this.mResolvedDimensionRatio, 8);
                }
            }
            if (this.mCenter.isConnected()) {
                linearSystem.addCenterPoint(this, this.mCenter.getTarget().getOwner(), (float) Math.toRadians(this.mCircleConstraintAngle + 90.0f), this.mCenter.getMargin());
            }
            this.resolvedHorizontal = false;
            this.resolvedVertical = false;
        }
        i28 = i28;
        i29 = i29;
        i10 = i26;
        z15 = false;
        int[] iArr3 = this.mResolvedMatchConstraintDefault;
        iArr3[0] = i28;
        iArr3[1] = i29;
        this.mResolvedHasRatio = z15;
        if (z15) {
            int i310 = this.mResolvedDimensionRatioSide;
            i11 = -1;
            if (i310 != 0) {
            }
            if (z15) {
                z16 = false;
            } else {
                z16 = false;
            }
            dimensionBehaviour = this.mListDimensionBehaviors[0];
            dimensionBehaviour2 = DimensionBehaviour.WRAP_CONTENT;
            if (dimensionBehaviour == dimensionBehaviour2) {
                z17 = false;
            } else {
                z17 = false;
            }
            if (z17) {
                i12 = 0;
            } else {
                i12 = i25;
            }
            boolean z219 = !this.mCenter.isConnected();
            boolean[] zArr6 = this.mIsInBarrier;
            boolean z2110 = zArr6[0];
            boolean z2111 = zArr6[1];
            if (this.mHorizontalResolution != 2) {
                solverVariable = solverVariableCreateObjectVariable4;
                solverVariable2 = solverVariableCreateObjectVariable3;
            } else {
                solverVariable = solverVariableCreateObjectVariable4;
                solverVariable2 = solverVariableCreateObjectVariable3;
            }
            if (z10) {
                ?? r111 = this;
                verticalWidgetRun = r111.verticalRun;
                if (verticalWidgetRun != null) {
                    dependencyNode = verticalWidgetRun.start;
                    if (!dependencyNode.resolved) {
                    }
                }
                i13 = 8;
                i14 = 0;
                i15 = 1;
                r15 = r111;
            } else {
                i13 = 8;
                i14 = 0;
                i15 = 1;
                r15 = this;
            }
            i16 = i15;
            r16 = r15;
            if (r16.mVerticalResolution == 2) {
                i17 = i14;
            } else {
                i17 = i16;
            }
            if (i17 == 0) {
            }
            if (z15) {
                if (this.mResolvedDimensionRatioSide == 1) {
                    linearSystem.addRatio(solverVariable4, solverVariable5, solverVariable, solverVariable2, this.mResolvedDimensionRatio, 8);
                } else {
                    linearSystem.addRatio(solverVariable, solverVariable2, solverVariable4, solverVariable5, this.mResolvedDimensionRatio, 8);
                }
            }
            if (this.mCenter.isConnected()) {
                linearSystem.addCenterPoint(this, this.mCenter.getTarget().getOwner(), (float) Math.toRadians(this.mCircleConstraintAngle + 90.0f), this.mCenter.getMargin());
            }
            this.resolvedHorizontal = false;
            this.resolvedVertical = false;
        }
        i11 = -1;
        if (z15) {
            z16 = false;
        } else {
            z16 = false;
        }
        dimensionBehaviour = this.mListDimensionBehaviors[0];
        dimensionBehaviour2 = DimensionBehaviour.WRAP_CONTENT;
        if (dimensionBehaviour == dimensionBehaviour2) {
            z17 = false;
        } else {
            z17 = false;
        }
        if (z17) {
            i12 = 0;
        } else {
            i12 = i25;
        }
        boolean z2112 = !this.mCenter.isConnected();
        boolean[] zArr7 = this.mIsInBarrier;
        boolean z2113 = zArr7[0];
        boolean z2114 = zArr7[1];
        if (this.mHorizontalResolution != 2) {
            solverVariable = solverVariableCreateObjectVariable4;
            solverVariable2 = solverVariableCreateObjectVariable3;
        } else {
            solverVariable = solverVariableCreateObjectVariable4;
            solverVariable2 = solverVariableCreateObjectVariable3;
        }
        if (z10) {
            ?? r112 = this;
            verticalWidgetRun = r112.verticalRun;
            if (verticalWidgetRun != null) {
                dependencyNode = verticalWidgetRun.start;
                if (!dependencyNode.resolved) {
                }
            }
            i13 = 8;
            i14 = 0;
            i15 = 1;
            r15 = r112;
        } else {
            i13 = 8;
            i14 = 0;
            i15 = 1;
            r15 = this;
        }
        i16 = i15;
        r16 = r15;
        if (r16.mVerticalResolution == 2) {
            i17 = i14;
        } else {
            i17 = i16;
        }
        if (i17 == 0) {
        }
        if (z15) {
            if (this.mResolvedDimensionRatioSide == 1) {
                linearSystem.addRatio(solverVariable4, solverVariable5, solverVariable, solverVariable2, this.mResolvedDimensionRatio, 8);
            } else {
                linearSystem.addRatio(solverVariable, solverVariable2, solverVariable4, solverVariable5, this.mResolvedDimensionRatio, 8);
            }
        }
        if (this.mCenter.isConnected()) {
            linearSystem.addCenterPoint(this, this.mCenter.getTarget().getOwner(), (float) Math.toRadians(this.mCircleConstraintAngle + 90.0f), this.mCenter.getMargin());
        }
        this.resolvedHorizontal = false;
        this.resolvedVertical = false;
    }

    public boolean allowedInBarrier() {
        return this.mVisibility != 8;
    }

    public void connect(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i10) {
        if (constraintAnchor.getOwner() == this) {
            connect(constraintAnchor.getType(), constraintAnchor2.getOwner(), constraintAnchor2.getType(), i10);
        }
    }

    public void connectCircularConstraint(ConstraintWidget constraintWidget, float f10, int i10) {
        ConstraintAnchor.Type type = ConstraintAnchor.Type.CENTER;
        immediateConnect(type, constraintWidget, type, i10, 0);
        this.mCircleConstraintAngle = f10;
    }

    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> map) {
        this.mHorizontalResolution = constraintWidget.mHorizontalResolution;
        this.mVerticalResolution = constraintWidget.mVerticalResolution;
        this.mMatchConstraintDefaultWidth = constraintWidget.mMatchConstraintDefaultWidth;
        this.mMatchConstraintDefaultHeight = constraintWidget.mMatchConstraintDefaultHeight;
        int[] iArr = this.mResolvedMatchConstraintDefault;
        int[] iArr2 = constraintWidget.mResolvedMatchConstraintDefault;
        iArr[0] = iArr2[0];
        iArr[1] = iArr2[1];
        this.mMatchConstraintMinWidth = constraintWidget.mMatchConstraintMinWidth;
        this.mMatchConstraintMaxWidth = constraintWidget.mMatchConstraintMaxWidth;
        this.mMatchConstraintMinHeight = constraintWidget.mMatchConstraintMinHeight;
        this.mMatchConstraintMaxHeight = constraintWidget.mMatchConstraintMaxHeight;
        this.mMatchConstraintPercentHeight = constraintWidget.mMatchConstraintPercentHeight;
        this.mIsWidthWrapContent = constraintWidget.mIsWidthWrapContent;
        this.mIsHeightWrapContent = constraintWidget.mIsHeightWrapContent;
        this.mResolvedDimensionRatioSide = constraintWidget.mResolvedDimensionRatioSide;
        this.mResolvedDimensionRatio = constraintWidget.mResolvedDimensionRatio;
        int[] iArr3 = constraintWidget.mMaxDimension;
        this.mMaxDimension = Arrays.copyOf(iArr3, iArr3.length);
        this.mCircleConstraintAngle = constraintWidget.mCircleConstraintAngle;
        this.hasBaseline = constraintWidget.hasBaseline;
        this.inPlaceholder = constraintWidget.inPlaceholder;
        this.mLeft.reset();
        this.mTop.reset();
        this.mRight.reset();
        this.mBottom.reset();
        this.mBaseline.reset();
        this.mCenterX.reset();
        this.mCenterY.reset();
        this.mCenter.reset();
        this.mListDimensionBehaviors = (DimensionBehaviour[]) Arrays.copyOf(this.mListDimensionBehaviors, 2);
        this.mParent = this.mParent == null ? null : map.get(constraintWidget.mParent);
        this.mWidth = constraintWidget.mWidth;
        this.mHeight = constraintWidget.mHeight;
        this.mDimensionRatio = constraintWidget.mDimensionRatio;
        this.mDimensionRatioSide = constraintWidget.mDimensionRatioSide;
        this.mX = constraintWidget.mX;
        this.mY = constraintWidget.mY;
        this.mRelX = constraintWidget.mRelX;
        this.mRelY = constraintWidget.mRelY;
        this.mOffsetX = constraintWidget.mOffsetX;
        this.mOffsetY = constraintWidget.mOffsetY;
        this.mBaselineDistance = constraintWidget.mBaselineDistance;
        this.mMinWidth = constraintWidget.mMinWidth;
        this.mMinHeight = constraintWidget.mMinHeight;
        this.mHorizontalBiasPercent = constraintWidget.mHorizontalBiasPercent;
        this.mVerticalBiasPercent = constraintWidget.mVerticalBiasPercent;
        this.mCompanionWidget = constraintWidget.mCompanionWidget;
        this.mContainerItemSkip = constraintWidget.mContainerItemSkip;
        this.mVisibility = constraintWidget.mVisibility;
        this.mDebugName = constraintWidget.mDebugName;
        this.mType = constraintWidget.mType;
        this.mDistToTop = constraintWidget.mDistToTop;
        this.mDistToLeft = constraintWidget.mDistToLeft;
        this.mDistToRight = constraintWidget.mDistToRight;
        this.mDistToBottom = constraintWidget.mDistToBottom;
        this.mLeftHasCentered = constraintWidget.mLeftHasCentered;
        this.mRightHasCentered = constraintWidget.mRightHasCentered;
        this.mTopHasCentered = constraintWidget.mTopHasCentered;
        this.mBottomHasCentered = constraintWidget.mBottomHasCentered;
        this.mHorizontalWrapVisited = constraintWidget.mHorizontalWrapVisited;
        this.mVerticalWrapVisited = constraintWidget.mVerticalWrapVisited;
        this.mHorizontalChainStyle = constraintWidget.mHorizontalChainStyle;
        this.mVerticalChainStyle = constraintWidget.mVerticalChainStyle;
        this.mHorizontalChainFixedPosition = constraintWidget.mHorizontalChainFixedPosition;
        this.mVerticalChainFixedPosition = constraintWidget.mVerticalChainFixedPosition;
        float[] fArr = this.mWeight;
        float[] fArr2 = constraintWidget.mWeight;
        fArr[0] = fArr2[0];
        fArr[1] = fArr2[1];
        ConstraintWidget[] constraintWidgetArr = this.mListNextMatchConstraintsWidget;
        ConstraintWidget[] constraintWidgetArr2 = constraintWidget.mListNextMatchConstraintsWidget;
        constraintWidgetArr[0] = constraintWidgetArr2[0];
        constraintWidgetArr[1] = constraintWidgetArr2[1];
        ConstraintWidget[] constraintWidgetArr3 = this.mNextChainWidget;
        ConstraintWidget[] constraintWidgetArr4 = constraintWidget.mNextChainWidget;
        constraintWidgetArr3[0] = constraintWidgetArr4[0];
        constraintWidgetArr3[1] = constraintWidgetArr4[1];
        ConstraintWidget constraintWidget2 = constraintWidget.mHorizontalNextWidget;
        this.mHorizontalNextWidget = constraintWidget2 == null ? null : map.get(constraintWidget2);
        ConstraintWidget constraintWidget3 = constraintWidget.mVerticalNextWidget;
        this.mVerticalNextWidget = constraintWidget3 != null ? map.get(constraintWidget3) : null;
    }

    public void createObjectVariables(LinearSystem linearSystem) {
        linearSystem.createObjectVariable(this.mLeft);
        linearSystem.createObjectVariable(this.mTop);
        linearSystem.createObjectVariable(this.mRight);
        linearSystem.createObjectVariable(this.mBottom);
        if (this.mBaselineDistance > 0) {
            linearSystem.createObjectVariable(this.mBaseline);
        }
    }

    public void ensureMeasureRequested() {
        this.mMeasureRequested = true;
    }

    public void ensureWidgetRuns() {
        if (this.horizontalRun == null) {
            this.horizontalRun = new HorizontalWidgetRun(this);
        }
        if (this.verticalRun == null) {
            this.verticalRun = new VerticalWidgetRun(this);
        }
    }

    public ConstraintAnchor getAnchor(ConstraintAnchor.Type type) {
        switch (AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[type.ordinal()]) {
            case 1:
                return this.mLeft;
            case 2:
                return this.mTop;
            case 3:
                return this.mRight;
            case 4:
                return this.mBottom;
            case 5:
                return this.mBaseline;
            case 6:
                return this.mCenter;
            case 7:
                return this.mCenterX;
            case 8:
                return this.mCenterY;
            case 9:
                return null;
            default:
                throw new AssertionError(type.name());
        }
    }

    public ArrayList<ConstraintAnchor> getAnchors() {
        return this.mAnchors;
    }

    public int getBaselineDistance() {
        return this.mBaselineDistance;
    }

    public float getBiasPercent(int i10) {
        if (i10 == 0) {
            return this.mHorizontalBiasPercent;
        }
        if (i10 == 1) {
            return this.mVerticalBiasPercent;
        }
        return -1.0f;
    }

    public int getBottom() {
        return getY() + this.mHeight;
    }

    public Object getCompanionWidget() {
        return this.mCompanionWidget;
    }

    public int getContainerItemSkip() {
        return this.mContainerItemSkip;
    }

    public String getDebugName() {
        return this.mDebugName;
    }

    public DimensionBehaviour getDimensionBehaviour(int i10) {
        if (i10 == 0) {
            return getHorizontalDimensionBehaviour();
        }
        if (i10 == 1) {
            return getVerticalDimensionBehaviour();
        }
        return null;
    }

    public float getDimensionRatio() {
        return this.mDimensionRatio;
    }

    public int getDimensionRatioSide() {
        return this.mDimensionRatioSide;
    }

    public boolean getHasBaseline() {
        return this.hasBaseline;
    }

    public int getHeight() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.mHeight;
    }

    public float getHorizontalBiasPercent() {
        return this.mHorizontalBiasPercent;
    }

    public ConstraintWidget getHorizontalChainControlWidget() {
        if (!isInHorizontalChain()) {
            return null;
        }
        ConstraintWidget constraintWidget = this;
        ConstraintWidget constraintWidget2 = null;
        while (constraintWidget2 == null && constraintWidget != null) {
            ConstraintAnchor anchor = constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT);
            ConstraintAnchor target = anchor == null ? null : anchor.getTarget();
            ConstraintWidget owner = target == null ? null : target.getOwner();
            if (owner == getParent()) {
                return constraintWidget;
            }
            ConstraintAnchor target2 = owner == null ? null : owner.getAnchor(ConstraintAnchor.Type.RIGHT).getTarget();
            if (target2 == null || target2.getOwner() == constraintWidget) {
                constraintWidget = owner;
            } else {
                constraintWidget2 = constraintWidget;
            }
        }
        return constraintWidget2;
    }

    public int getHorizontalChainStyle() {
        return this.mHorizontalChainStyle;
    }

    public DimensionBehaviour getHorizontalDimensionBehaviour() {
        return this.mListDimensionBehaviors[0];
    }

    public int getHorizontalMargin() {
        ConstraintAnchor constraintAnchor = this.mLeft;
        int i10 = constraintAnchor != null ? constraintAnchor.mMargin : 0;
        ConstraintAnchor constraintAnchor2 = this.mRight;
        return constraintAnchor2 != null ? i10 + constraintAnchor2.mMargin : i10;
    }

    public int getLastHorizontalMeasureSpec() {
        return this.mLastHorizontalMeasureSpec;
    }

    public int getLastVerticalMeasureSpec() {
        return this.mLastVerticalMeasureSpec;
    }

    public int getLeft() {
        return getX();
    }

    public int getLength(int i10) {
        if (i10 == 0) {
            return getWidth();
        }
        if (i10 == 1) {
            return getHeight();
        }
        return 0;
    }

    public int getMaxHeight() {
        return this.mMaxDimension[1];
    }

    public int getMaxWidth() {
        return this.mMaxDimension[0];
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public ConstraintWidget getNextChainMember(int i10) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i10 != 0) {
            if (i10 == 1 && (constraintAnchor2 = (constraintAnchor = this.mBottom).mTarget) != null && constraintAnchor2.mTarget == constraintAnchor) {
                return constraintAnchor2.mOwner;
            }
            return null;
        }
        ConstraintAnchor constraintAnchor3 = this.mRight;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
        if (constraintAnchor4 == null || constraintAnchor4.mTarget != constraintAnchor3) {
            return null;
        }
        return constraintAnchor4.mOwner;
    }

    public int getOptimizerWrapHeight() {
        int iMax;
        int i10 = this.mHeight;
        if (this.mListDimensionBehaviors[1] != DimensionBehaviour.MATCH_CONSTRAINT) {
            return i10;
        }
        if (this.mMatchConstraintDefaultHeight == 1) {
            iMax = Math.max(this.mMatchConstraintMinHeight, i10);
        } else {
            iMax = this.mMatchConstraintMinHeight;
            if (iMax > 0) {
                this.mHeight = iMax;
            } else {
                iMax = 0;
            }
        }
        int i11 = this.mMatchConstraintMaxHeight;
        return (i11 <= 0 || i11 >= iMax) ? iMax : i11;
    }

    public int getOptimizerWrapWidth() {
        int iMax;
        int i10 = this.mWidth;
        if (this.mListDimensionBehaviors[0] != DimensionBehaviour.MATCH_CONSTRAINT) {
            return i10;
        }
        if (this.mMatchConstraintDefaultWidth == 1) {
            iMax = Math.max(this.mMatchConstraintMinWidth, i10);
        } else {
            iMax = this.mMatchConstraintMinWidth;
            if (iMax > 0) {
                this.mWidth = iMax;
            } else {
                iMax = 0;
            }
        }
        int i11 = this.mMatchConstraintMaxWidth;
        return (i11 <= 0 || i11 >= iMax) ? iMax : i11;
    }

    public ConstraintWidget getParent() {
        return this.mParent;
    }

    public ConstraintWidget getPreviousChainMember(int i10) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i10 != 0) {
            if (i10 == 1 && (constraintAnchor2 = (constraintAnchor = this.mTop).mTarget) != null && constraintAnchor2.mTarget == constraintAnchor) {
                return constraintAnchor2.mOwner;
            }
            return null;
        }
        ConstraintAnchor constraintAnchor3 = this.mLeft;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
        if (constraintAnchor4 == null || constraintAnchor4.mTarget != constraintAnchor3) {
            return null;
        }
        return constraintAnchor4.mOwner;
    }

    public int getRelativePositioning(int i10) {
        if (i10 == 0) {
            return this.mRelX;
        }
        if (i10 == 1) {
            return this.mRelY;
        }
        return 0;
    }

    public int getRight() {
        return getX() + this.mWidth;
    }

    public int getRootX() {
        return this.mX + this.mOffsetX;
    }

    public int getRootY() {
        return this.mY + this.mOffsetY;
    }

    public WidgetRun getRun(int i10) {
        if (i10 == 0) {
            return this.horizontalRun;
        }
        if (i10 == 1) {
            return this.verticalRun;
        }
        return null;
    }

    public void getSceneString(StringBuilder sb2) {
        sb2.append("  " + this.stringId + ":{\n");
        StringBuilder sb3 = new StringBuilder("    actualWidth:");
        sb3.append(this.mWidth);
        sb2.append(sb3.toString());
        sb2.append("\n");
        sb2.append("    actualHeight:" + this.mHeight);
        sb2.append("\n");
        sb2.append("    actualLeft:" + this.mX);
        sb2.append("\n");
        sb2.append("    actualTop:" + this.mY);
        sb2.append("\n");
        getSceneString(sb2, "left", this.mLeft);
        getSceneString(sb2, "top", this.mTop);
        getSceneString(sb2, "right", this.mRight);
        getSceneString(sb2, "bottom", this.mBottom);
        getSceneString(sb2, "baseline", this.mBaseline);
        getSceneString(sb2, "centerX", this.mCenterX);
        getSceneString(sb2, "centerY", this.mCenterY);
        getSceneString(sb2, "    width", this.mWidth, this.mMinWidth, this.mMaxDimension[0], this.mWidthOverride, this.mMatchConstraintMinWidth, this.mMatchConstraintDefaultWidth, this.mMatchConstraintPercentWidth, this.mWeight[0]);
        getSceneString(sb2, "    height", this.mHeight, this.mMinHeight, this.mMaxDimension[1], this.mHeightOverride, this.mMatchConstraintMinHeight, this.mMatchConstraintDefaultHeight, this.mMatchConstraintPercentHeight, this.mWeight[1]);
        serializeDimensionRatio(sb2, "    dimensionRatio", this.mDimensionRatio, this.mDimensionRatioSide);
        serializeAttribute(sb2, "    horizontalBias", this.mHorizontalBiasPercent, DEFAULT_BIAS);
        serializeAttribute(sb2, "    verticalBias", this.mVerticalBiasPercent, DEFAULT_BIAS);
        serializeAttribute(sb2, "    horizontalChainStyle", this.mHorizontalChainStyle, 0);
        serializeAttribute(sb2, "    verticalChainStyle", this.mVerticalChainStyle, 0);
        sb2.append("  }");
    }

    public int getTop() {
        return getY();
    }

    public String getType() {
        return this.mType;
    }

    public float getVerticalBiasPercent() {
        return this.mVerticalBiasPercent;
    }

    public ConstraintWidget getVerticalChainControlWidget() {
        if (!isInVerticalChain()) {
            return null;
        }
        ConstraintWidget constraintWidget = this;
        ConstraintWidget constraintWidget2 = null;
        while (constraintWidget2 == null && constraintWidget != null) {
            ConstraintAnchor anchor = constraintWidget.getAnchor(ConstraintAnchor.Type.TOP);
            ConstraintAnchor target = anchor == null ? null : anchor.getTarget();
            ConstraintWidget owner = target == null ? null : target.getOwner();
            if (owner == getParent()) {
                return constraintWidget;
            }
            ConstraintAnchor target2 = owner == null ? null : owner.getAnchor(ConstraintAnchor.Type.BOTTOM).getTarget();
            if (target2 == null || target2.getOwner() == constraintWidget) {
                constraintWidget = owner;
            } else {
                constraintWidget2 = constraintWidget;
            }
        }
        return constraintWidget2;
    }

    public int getVerticalChainStyle() {
        return this.mVerticalChainStyle;
    }

    public DimensionBehaviour getVerticalDimensionBehaviour() {
        return this.mListDimensionBehaviors[1];
    }

    public int getVerticalMargin() {
        int i10 = this.mLeft != null ? this.mTop.mMargin : 0;
        return this.mRight != null ? i10 + this.mBottom.mMargin : i10;
    }

    public int getVisibility() {
        return this.mVisibility;
    }

    public int getWidth() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.mWidth;
    }

    public int getWrapBehaviorInParent() {
        return this.mWrapBehaviorInParent;
    }

    public int getX() {
        ConstraintWidget constraintWidget = this.mParent;
        return (constraintWidget == null || !(constraintWidget instanceof ConstraintWidgetContainer)) ? this.mX : ((ConstraintWidgetContainer) constraintWidget).mPaddingLeft + this.mX;
    }

    public int getY() {
        ConstraintWidget constraintWidget = this.mParent;
        return (constraintWidget == null || !(constraintWidget instanceof ConstraintWidgetContainer)) ? this.mY : ((ConstraintWidgetContainer) constraintWidget).mPaddingTop + this.mY;
    }

    public boolean hasBaseline() {
        return this.hasBaseline;
    }

    public boolean hasDanglingDimension(int i10) {
        if (i10 == 0) {
            return (this.mLeft.mTarget != null ? 1 : 0) + (this.mRight.mTarget != null ? 1 : 0) < 2;
        }
        return ((this.mTop.mTarget != null ? 1 : 0) + (this.mBottom.mTarget != null ? 1 : 0)) + (this.mBaseline.mTarget != null ? 1 : 0) < 2;
    }

    public boolean hasDependencies() {
        int size = this.mAnchors.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (this.mAnchors.get(i10).hasDependents()) {
                return true;
            }
        }
        return false;
    }

    public boolean hasDimensionOverride() {
        return (this.mWidthOverride == -1 && this.mHeightOverride == -1) ? false : true;
    }

    public boolean hasResolvedTargets(int i10, int i11) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i10 == 0) {
            ConstraintAnchor constraintAnchor3 = this.mLeft.mTarget;
            if (constraintAnchor3 != null && constraintAnchor3.hasFinalValue() && (constraintAnchor2 = this.mRight.mTarget) != null && constraintAnchor2.hasFinalValue()) {
                return (this.mRight.mTarget.getFinalValue() - this.mRight.getMargin()) - (this.mLeft.getMargin() + this.mLeft.mTarget.getFinalValue()) >= i11;
            }
        } else {
            ConstraintAnchor constraintAnchor4 = this.mTop.mTarget;
            if (constraintAnchor4 != null && constraintAnchor4.hasFinalValue() && (constraintAnchor = this.mBottom.mTarget) != null && constraintAnchor.hasFinalValue()) {
                return (this.mBottom.mTarget.getFinalValue() - this.mBottom.getMargin()) - (this.mTop.getMargin() + this.mTop.mTarget.getFinalValue()) >= i11;
            }
        }
        return false;
    }

    public void immediateConnect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i10, int i11) {
        getAnchor(type).connect(constraintWidget.getAnchor(type2), i10, i11, true);
    }

    public boolean isHeightWrapContent() {
        return this.mIsHeightWrapContent;
    }

    public boolean isHorizontalSolvingPassDone() {
        return this.horizontalSolvingPass;
    }

    public boolean isInBarrier(int i10) {
        return this.mIsInBarrier[i10];
    }

    public boolean isInHorizontalChain() {
        ConstraintAnchor constraintAnchor = this.mLeft;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        if (constraintAnchor2 != null && constraintAnchor2.mTarget == constraintAnchor) {
            return true;
        }
        ConstraintAnchor constraintAnchor3 = this.mRight;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
        return constraintAnchor4 != null && constraintAnchor4.mTarget == constraintAnchor3;
    }

    public boolean isInPlaceholder() {
        return this.inPlaceholder;
    }

    public boolean isInVerticalChain() {
        ConstraintAnchor constraintAnchor = this.mTop;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        if (constraintAnchor2 != null && constraintAnchor2.mTarget == constraintAnchor) {
            return true;
        }
        ConstraintAnchor constraintAnchor3 = this.mBottom;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
        return constraintAnchor4 != null && constraintAnchor4.mTarget == constraintAnchor3;
    }

    public boolean isInVirtualLayout() {
        return this.mInVirtualLayout;
    }

    public boolean isMeasureRequested() {
        return this.mMeasureRequested && this.mVisibility != 8;
    }

    public boolean isResolvedHorizontally() {
        return this.resolvedHorizontal || (this.mLeft.hasFinalValue() && this.mRight.hasFinalValue());
    }

    public boolean isResolvedVertically() {
        return this.resolvedVertical || (this.mTop.hasFinalValue() && this.mBottom.hasFinalValue());
    }

    public boolean isRoot() {
        return this.mParent == null;
    }

    public boolean isSpreadHeight() {
        return this.mMatchConstraintDefaultHeight == 0 && this.mDimensionRatio == 0.0f && this.mMatchConstraintMinHeight == 0 && this.mMatchConstraintMaxHeight == 0 && this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT;
    }

    public boolean isSpreadWidth() {
        return this.mMatchConstraintDefaultWidth == 0 && this.mDimensionRatio == 0.0f && this.mMatchConstraintMinWidth == 0 && this.mMatchConstraintMaxWidth == 0 && this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT;
    }

    public boolean isVerticalSolvingPassDone() {
        return this.verticalSolvingPass;
    }

    public boolean isWidthWrapContent() {
        return this.mIsWidthWrapContent;
    }

    public void markHorizontalSolvingPassDone() {
        this.horizontalSolvingPass = true;
    }

    public void markVerticalSolvingPassDone() {
        this.verticalSolvingPass = true;
    }

    public boolean oppositeDimensionDependsOn(int i10) {
        char c10 = i10 == 0 ? (char) 1 : (char) 0;
        DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
        DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[i10];
        DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[c10];
        DimensionBehaviour dimensionBehaviour3 = DimensionBehaviour.MATCH_CONSTRAINT;
        return dimensionBehaviour == dimensionBehaviour3 && dimensionBehaviour2 == dimensionBehaviour3;
    }

    public boolean oppositeDimensionsTied() {
        DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
        DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
        DimensionBehaviour dimensionBehaviour2 = DimensionBehaviour.MATCH_CONSTRAINT;
        return dimensionBehaviour == dimensionBehaviour2 && dimensionBehaviourArr[1] == dimensionBehaviour2;
    }

    public void reset() {
        this.mLeft.reset();
        this.mTop.reset();
        this.mRight.reset();
        this.mBottom.reset();
        this.mBaseline.reset();
        this.mCenterX.reset();
        this.mCenterY.reset();
        this.mCenter.reset();
        this.mParent = null;
        this.mCircleConstraintAngle = 0.0f;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        float f10 = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f10;
        this.mVerticalBiasPercent = f10;
        DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        dimensionBehaviourArr[0] = dimensionBehaviour;
        dimensionBehaviourArr[1] = dimensionBehaviour;
        this.mCompanionWidget = null;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mType = null;
        this.mHorizontalWrapVisited = false;
        this.mVerticalWrapVisited = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mHorizontalChainFixedPosition = false;
        this.mVerticalChainFixedPosition = false;
        float[] fArr = this.mWeight;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        int[] iArr = this.mMaxDimension;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mMatchConstraintMaxWidth = Integer.MAX_VALUE;
        this.mMatchConstraintMaxHeight = Integer.MAX_VALUE;
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMinHeight = 0;
        this.mResolvedHasRatio = false;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mGroupsToSolver = false;
        boolean[] zArr = this.isTerminalWidget;
        zArr[0] = true;
        zArr[1] = true;
        this.mInVirtualLayout = false;
        boolean[] zArr2 = this.mIsInBarrier;
        zArr2[0] = false;
        zArr2[1] = false;
        this.mMeasureRequested = true;
        int[] iArr2 = this.mResolvedMatchConstraintDefault;
        iArr2[0] = 0;
        iArr2[1] = 0;
        this.mWidthOverride = -1;
        this.mHeightOverride = -1;
    }

    public void resetAllConstraints() {
        resetAnchors();
        setVerticalBiasPercent(DEFAULT_BIAS);
        setHorizontalBiasPercent(DEFAULT_BIAS);
    }

    public void resetAnchor(ConstraintAnchor constraintAnchor) {
        if (getParent() != null && (getParent() instanceof ConstraintWidgetContainer) && ((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
            return;
        }
        ConstraintAnchor anchor = getAnchor(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor anchor2 = getAnchor(ConstraintAnchor.Type.RIGHT);
        ConstraintAnchor anchor3 = getAnchor(ConstraintAnchor.Type.TOP);
        ConstraintAnchor anchor4 = getAnchor(ConstraintAnchor.Type.BOTTOM);
        ConstraintAnchor anchor5 = getAnchor(ConstraintAnchor.Type.CENTER);
        ConstraintAnchor anchor6 = getAnchor(ConstraintAnchor.Type.CENTER_X);
        ConstraintAnchor anchor7 = getAnchor(ConstraintAnchor.Type.CENTER_Y);
        if (constraintAnchor == anchor5) {
            if (anchor.isConnected() && anchor2.isConnected() && anchor.getTarget() == anchor2.getTarget()) {
                anchor.reset();
                anchor2.reset();
            }
            if (anchor3.isConnected() && anchor4.isConnected() && anchor3.getTarget() == anchor4.getTarget()) {
                anchor3.reset();
                anchor4.reset();
            }
            this.mHorizontalBiasPercent = 0.5f;
            this.mVerticalBiasPercent = 0.5f;
        } else if (constraintAnchor == anchor6) {
            if (anchor.isConnected() && anchor2.isConnected() && anchor.getTarget().getOwner() == anchor2.getTarget().getOwner()) {
                anchor.reset();
                anchor2.reset();
            }
            this.mHorizontalBiasPercent = 0.5f;
        } else if (constraintAnchor == anchor7) {
            if (anchor3.isConnected() && anchor4.isConnected() && anchor3.getTarget().getOwner() == anchor4.getTarget().getOwner()) {
                anchor3.reset();
                anchor4.reset();
            }
            this.mVerticalBiasPercent = 0.5f;
        } else if (constraintAnchor == anchor || constraintAnchor == anchor2) {
            if (anchor.isConnected() && anchor.getTarget() == anchor2.getTarget()) {
                anchor5.reset();
            }
        } else if ((constraintAnchor == anchor3 || constraintAnchor == anchor4) && anchor3.isConnected() && anchor3.getTarget() == anchor4.getTarget()) {
            anchor5.reset();
        }
        constraintAnchor.reset();
    }

    public void resetAnchors() {
        ConstraintWidget parent = getParent();
        if (parent != null && (parent instanceof ConstraintWidgetContainer) && ((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
            return;
        }
        int size = this.mAnchors.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.mAnchors.get(i10).reset();
        }
    }

    public void resetFinalResolution() {
        this.resolvedHorizontal = false;
        this.resolvedVertical = false;
        this.horizontalSolvingPass = false;
        this.verticalSolvingPass = false;
        int size = this.mAnchors.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.mAnchors.get(i10).resetFinalResolution();
        }
    }

    public void resetSolverVariables(Cache cache) {
        this.mLeft.resetSolverVariable(cache);
        this.mTop.resetSolverVariable(cache);
        this.mRight.resetSolverVariable(cache);
        this.mBottom.resetSolverVariable(cache);
        this.mBaseline.resetSolverVariable(cache);
        this.mCenter.resetSolverVariable(cache);
        this.mCenterX.resetSolverVariable(cache);
        this.mCenterY.resetSolverVariable(cache);
    }

    public void resetSolvingPassFlag() {
        this.horizontalSolvingPass = false;
        this.verticalSolvingPass = false;
    }

    public StringBuilder serialize(StringBuilder sb2) {
        sb2.append("{\n");
        serializeAnchor(sb2, "left", this.mLeft);
        serializeAnchor(sb2, "top", this.mTop);
        serializeAnchor(sb2, "right", this.mRight);
        serializeAnchor(sb2, "bottom", this.mBottom);
        serializeAnchor(sb2, "baseline", this.mBaseline);
        serializeAnchor(sb2, "centerX", this.mCenterX);
        serializeAnchor(sb2, "centerY", this.mCenterY);
        serializeCircle(sb2, this.mCenter, this.mCircleConstraintAngle);
        serializeSize(sb2, "width", this.mWidth, this.mMinWidth, this.mMaxDimension[0], this.mWidthOverride, this.mMatchConstraintMinWidth, this.mMatchConstraintDefaultWidth, this.mMatchConstraintPercentWidth, this.mWeight[0]);
        serializeSize(sb2, "height", this.mHeight, this.mMinHeight, this.mMaxDimension[1], this.mHeightOverride, this.mMatchConstraintMinHeight, this.mMatchConstraintDefaultHeight, this.mMatchConstraintPercentHeight, this.mWeight[1]);
        serializeDimensionRatio(sb2, "dimensionRatio", this.mDimensionRatio, this.mDimensionRatioSide);
        serializeAttribute(sb2, "horizontalBias", this.mHorizontalBiasPercent, DEFAULT_BIAS);
        serializeAttribute(sb2, "verticalBias", this.mVerticalBiasPercent, DEFAULT_BIAS);
        sb2.append("}\n");
        return sb2;
    }

    public void setBaselineDistance(int i10) {
        this.mBaselineDistance = i10;
        this.hasBaseline = i10 > 0;
    }

    public void setCompanionWidget(Object obj) {
        this.mCompanionWidget = obj;
    }

    public void setContainerItemSkip(int i10) {
        if (i10 >= 0) {
            this.mContainerItemSkip = i10;
        } else {
            this.mContainerItemSkip = 0;
        }
    }

    public void setDebugName(String str) {
        this.mDebugName = str;
    }

    public void setDebugSolverName(LinearSystem linearSystem, String str) {
        this.mDebugName = str;
        SolverVariable solverVariableCreateObjectVariable = linearSystem.createObjectVariable(this.mLeft);
        SolverVariable solverVariableCreateObjectVariable2 = linearSystem.createObjectVariable(this.mTop);
        SolverVariable solverVariableCreateObjectVariable3 = linearSystem.createObjectVariable(this.mRight);
        SolverVariable solverVariableCreateObjectVariable4 = linearSystem.createObjectVariable(this.mBottom);
        solverVariableCreateObjectVariable.setName(str + ".left");
        solverVariableCreateObjectVariable2.setName(str + ".top");
        solverVariableCreateObjectVariable3.setName(str + ".right");
        solverVariableCreateObjectVariable4.setName(str + ".bottom");
        linearSystem.createObjectVariable(this.mBaseline).setName(str + ".baseline");
    }

    public void setDimension(int i10, int i11) {
        this.mWidth = i10;
        int i12 = this.mMinWidth;
        if (i10 < i12) {
            this.mWidth = i12;
        }
        this.mHeight = i11;
        int i13 = this.mMinHeight;
        if (i11 < i13) {
            this.mHeight = i13;
        }
    }

    /* JADX WARN: Code duplicated, block: B:39:0x0086 A[PHI: r0
      0x0086: PHI (r0v2 int) = (r0v1 int), (r0v0 int), (r0v0 int), (r0v0 int), (r0v0 int), (r0v0 int) binds: [B:46:0x0086, B:36:0x007f, B:24:0x0051, B:26:0x0057, B:28:0x0063, B:30:0x0067] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x0086 -> B:40:0x0087). Please report as a decompilation issue!!! */
    public void setDimensionRatio(String str) {
        float fAbs;
        int i10 = 0;
        if (str == null || str.length() == 0) {
            this.mDimensionRatio = 0.0f;
            return;
        }
        int length = str.length();
        int iIndexOf = str.indexOf(44);
        int i11 = 0;
        int i12 = -1;
        if (iIndexOf > 0 && iIndexOf < length - 1) {
            String strSubstring = str.substring(0, iIndexOf);
            if (!strSubstring.equalsIgnoreCase("W")) {
                i11 = strSubstring.equalsIgnoreCase("H") ? 1 : -1;
            }
            i12 = i11;
            i11 = iIndexOf + 1;
        }
        int iIndexOf2 = str.indexOf(58);
        try {
            if (iIndexOf2 < 0 || iIndexOf2 >= length - 1) {
                String strSubstring2 = str.substring(i11);
                if (strSubstring2.length() > 0) {
                    fAbs = Float.parseFloat(strSubstring2);
                } else {
                    fAbs = i10;
                }
            } else {
                String strSubstring3 = str.substring(i11, iIndexOf2);
                String strSubstring4 = str.substring(iIndexOf2 + 1);
                if (strSubstring3.length() <= 0 || strSubstring4.length() <= 0) {
                    fAbs = i10;
                } else {
                    float f10 = Float.parseFloat(strSubstring3);
                    float f11 = Float.parseFloat(strSubstring4);
                    if (f10 <= 0.0f || f11 <= 0.0f) {
                        fAbs = i10;
                    } else {
                        fAbs = i12 == 1 ? Math.abs(f11 / f10) : Math.abs(f10 / f11);
                    }
                }
            }
        } catch (NumberFormatException unused) {
        }
        i10 = (fAbs > i10 ? 1 : (fAbs == i10 ? 0 : -1));
        if (i10 > 0) {
            this.mDimensionRatio = fAbs;
            this.mDimensionRatioSide = i12;
        }
    }

    public void setFinalBaseline(int i10) {
        if (this.hasBaseline) {
            int i11 = i10 - this.mBaselineDistance;
            int i12 = this.mHeight + i11;
            this.mY = i11;
            this.mTop.setFinalValue(i11);
            this.mBottom.setFinalValue(i12);
            this.mBaseline.setFinalValue(i10);
            this.resolvedVertical = true;
        }
    }

    public void setFinalFrame(int i10, int i11, int i12, int i13, int i14, int i15) {
        setFrame(i10, i11, i12, i13);
        setBaselineDistance(i14);
        if (i15 == 0) {
            this.resolvedHorizontal = true;
            this.resolvedVertical = false;
        } else if (i15 == 1) {
            this.resolvedHorizontal = false;
            this.resolvedVertical = true;
        } else if (i15 == 2) {
            this.resolvedHorizontal = true;
            this.resolvedVertical = true;
        } else {
            this.resolvedHorizontal = false;
            this.resolvedVertical = false;
        }
    }

    public void setFinalHorizontal(int i10, int i11) {
        if (this.resolvedHorizontal) {
            return;
        }
        this.mLeft.setFinalValue(i10);
        this.mRight.setFinalValue(i11);
        this.mX = i10;
        this.mWidth = i11 - i10;
        this.resolvedHorizontal = true;
    }

    public void setFinalLeft(int i10) {
        this.mLeft.setFinalValue(i10);
        this.mX = i10;
    }

    public void setFinalTop(int i10) {
        this.mTop.setFinalValue(i10);
        this.mY = i10;
    }

    public void setFinalVertical(int i10, int i11) {
        if (this.resolvedVertical) {
            return;
        }
        this.mTop.setFinalValue(i10);
        this.mBottom.setFinalValue(i11);
        this.mY = i10;
        this.mHeight = i11 - i10;
        if (this.hasBaseline) {
            this.mBaseline.setFinalValue(i10 + this.mBaselineDistance);
        }
        this.resolvedVertical = true;
    }

    public void setFrame(int i10, int i11, int i12, int i13) {
        int i14;
        int i15;
        int i16 = i12 - i10;
        int i17 = i13 - i11;
        this.mX = i10;
        this.mY = i11;
        if (this.mVisibility == 8) {
            this.mWidth = 0;
            this.mHeight = 0;
            return;
        }
        DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
        DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
        DimensionBehaviour dimensionBehaviour2 = DimensionBehaviour.FIXED;
        if (dimensionBehaviour == dimensionBehaviour2 && i16 < (i15 = this.mWidth)) {
            i16 = i15;
        }
        if (dimensionBehaviourArr[1] == dimensionBehaviour2 && i17 < (i14 = this.mHeight)) {
            i17 = i14;
        }
        this.mWidth = i16;
        this.mHeight = i17;
        int i18 = this.mMinHeight;
        if (i17 < i18) {
            this.mHeight = i18;
        }
        int i19 = this.mMinWidth;
        if (i16 < i19) {
            this.mWidth = i19;
        }
        int i20 = this.mMatchConstraintMaxWidth;
        if (i20 > 0 && dimensionBehaviour == DimensionBehaviour.MATCH_CONSTRAINT) {
            this.mWidth = Math.min(this.mWidth, i20);
        }
        int i21 = this.mMatchConstraintMaxHeight;
        if (i21 > 0 && this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT) {
            this.mHeight = Math.min(this.mHeight, i21);
        }
        int i22 = this.mWidth;
        if (i16 != i22) {
            this.mWidthOverride = i22;
        }
        int i23 = this.mHeight;
        if (i17 != i23) {
            this.mHeightOverride = i23;
        }
    }

    public void setGoneMargin(ConstraintAnchor.Type type, int i10) {
        int i11 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[type.ordinal()];
        if (i11 == 1) {
            this.mLeft.mGoneMargin = i10;
            return;
        }
        if (i11 == 2) {
            this.mTop.mGoneMargin = i10;
            return;
        }
        if (i11 == 3) {
            this.mRight.mGoneMargin = i10;
        } else if (i11 == 4) {
            this.mBottom.mGoneMargin = i10;
        } else {
            if (i11 != 5) {
                return;
            }
            this.mBaseline.mGoneMargin = i10;
        }
    }

    public void setHasBaseline(boolean z10) {
        this.hasBaseline = z10;
    }

    public void setHeight(int i10) {
        this.mHeight = i10;
        int i11 = this.mMinHeight;
        if (i10 < i11) {
            this.mHeight = i11;
        }
    }

    public void setHeightWrapContent(boolean z10) {
        this.mIsHeightWrapContent = z10;
    }

    public void setHorizontalBiasPercent(float f10) {
        this.mHorizontalBiasPercent = f10;
    }

    public void setHorizontalChainStyle(int i10) {
        this.mHorizontalChainStyle = i10;
    }

    public void setHorizontalDimension(int i10, int i11) {
        this.mX = i10;
        int i12 = i11 - i10;
        this.mWidth = i12;
        int i13 = this.mMinWidth;
        if (i12 < i13) {
            this.mWidth = i13;
        }
    }

    public void setHorizontalDimensionBehaviour(DimensionBehaviour dimensionBehaviour) {
        this.mListDimensionBehaviors[0] = dimensionBehaviour;
    }

    public void setHorizontalMatchStyle(int i10, int i11, int i12, float f10) {
        this.mMatchConstraintDefaultWidth = i10;
        this.mMatchConstraintMinWidth = i11;
        if (i12 == Integer.MAX_VALUE) {
            i12 = 0;
        }
        this.mMatchConstraintMaxWidth = i12;
        this.mMatchConstraintPercentWidth = f10;
        if (f10 <= 0.0f || f10 >= 1.0f || i10 != 0) {
            return;
        }
        this.mMatchConstraintDefaultWidth = 2;
    }

    public void setHorizontalWeight(float f10) {
        this.mWeight[0] = f10;
    }

    public void setInBarrier(int i10, boolean z10) {
        this.mIsInBarrier[i10] = z10;
    }

    public void setInPlaceholder(boolean z10) {
        this.inPlaceholder = z10;
    }

    public void setInVirtualLayout(boolean z10) {
        this.mInVirtualLayout = z10;
    }

    public void setLastMeasureSpec(int i10, int i11) {
        this.mLastHorizontalMeasureSpec = i10;
        this.mLastVerticalMeasureSpec = i11;
        setMeasureRequested(false);
    }

    public void setLength(int i10, int i11) {
        if (i11 == 0) {
            setWidth(i10);
        } else if (i11 == 1) {
            setHeight(i10);
        }
    }

    public void setMaxHeight(int i10) {
        this.mMaxDimension[1] = i10;
    }

    public void setMaxWidth(int i10) {
        this.mMaxDimension[0] = i10;
    }

    public void setMeasureRequested(boolean z10) {
        this.mMeasureRequested = z10;
    }

    public void setMinHeight(int i10) {
        if (i10 < 0) {
            this.mMinHeight = 0;
        } else {
            this.mMinHeight = i10;
        }
    }

    public void setMinWidth(int i10) {
        if (i10 < 0) {
            this.mMinWidth = 0;
        } else {
            this.mMinWidth = i10;
        }
    }

    public void setOffset(int i10, int i11) {
        this.mOffsetX = i10;
        this.mOffsetY = i11;
    }

    public void setOrigin(int i10, int i11) {
        this.mX = i10;
        this.mY = i11;
    }

    public void setParent(ConstraintWidget constraintWidget) {
        this.mParent = constraintWidget;
    }

    public void setRelativePositioning(int i10, int i11) {
        if (i11 == 0) {
            this.mRelX = i10;
        } else if (i11 == 1) {
            this.mRelY = i10;
        }
    }

    public void setType(String str) {
        this.mType = str;
    }

    public void setVerticalBiasPercent(float f10) {
        this.mVerticalBiasPercent = f10;
    }

    public void setVerticalChainStyle(int i10) {
        this.mVerticalChainStyle = i10;
    }

    public void setVerticalDimension(int i10, int i11) {
        this.mY = i10;
        int i12 = i11 - i10;
        this.mHeight = i12;
        int i13 = this.mMinHeight;
        if (i12 < i13) {
            this.mHeight = i13;
        }
    }

    public void setVerticalDimensionBehaviour(DimensionBehaviour dimensionBehaviour) {
        this.mListDimensionBehaviors[1] = dimensionBehaviour;
    }

    public void setVerticalMatchStyle(int i10, int i11, int i12, float f10) {
        this.mMatchConstraintDefaultHeight = i10;
        this.mMatchConstraintMinHeight = i11;
        if (i12 == Integer.MAX_VALUE) {
            i12 = 0;
        }
        this.mMatchConstraintMaxHeight = i12;
        this.mMatchConstraintPercentHeight = f10;
        if (f10 <= 0.0f || f10 >= 1.0f || i10 != 0) {
            return;
        }
        this.mMatchConstraintDefaultHeight = 2;
    }

    public void setVerticalWeight(float f10) {
        this.mWeight[1] = f10;
    }

    public void setVisibility(int i10) {
        this.mVisibility = i10;
    }

    public void setWidth(int i10) {
        this.mWidth = i10;
        int i11 = this.mMinWidth;
        if (i10 < i11) {
            this.mWidth = i11;
        }
    }

    public void setWidthWrapContent(boolean z10) {
        this.mIsWidthWrapContent = z10;
    }

    public void setWrapBehaviorInParent(int i10) {
        if (i10 < 0 || i10 > 3) {
            return;
        }
        this.mWrapBehaviorInParent = i10;
    }

    public void setX(int i10) {
        this.mX = i10;
    }

    public void setY(int i10) {
        this.mY = i10;
    }

    public void setupDimensionRatio(boolean z10, boolean z11, boolean z12, boolean z13) {
        if (this.mResolvedDimensionRatioSide == -1) {
            if (z12 && !z13) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (!z12 && z13) {
                this.mResolvedDimensionRatioSide = 1;
                if (this.mDimensionRatioSide == -1) {
                    this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                }
            }
        }
        if (this.mResolvedDimensionRatioSide == 0 && (!this.mTop.isConnected() || !this.mBottom.isConnected())) {
            this.mResolvedDimensionRatioSide = 1;
        } else if (this.mResolvedDimensionRatioSide == 1 && (!this.mLeft.isConnected() || !this.mRight.isConnected())) {
            this.mResolvedDimensionRatioSide = 0;
        }
        if (this.mResolvedDimensionRatioSide == -1 && (!this.mTop.isConnected() || !this.mBottom.isConnected() || !this.mLeft.isConnected() || !this.mRight.isConnected())) {
            if (this.mTop.isConnected() && this.mBottom.isConnected()) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (this.mLeft.isConnected() && this.mRight.isConnected()) {
                this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                this.mResolvedDimensionRatioSide = 1;
            }
        }
        if (this.mResolvedDimensionRatioSide == -1) {
            int i10 = this.mMatchConstraintMinWidth;
            if (i10 > 0 && this.mMatchConstraintMinHeight == 0) {
                this.mResolvedDimensionRatioSide = 0;
            } else {
                if (i10 != 0 || this.mMatchConstraintMinHeight <= 0) {
                    return;
                }
                this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                this.mResolvedDimensionRatioSide = 1;
            }
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.mType != null ? c.a(new StringBuilder("type: "), this.mType, " ") : "");
        sb2.append(this.mDebugName != null ? c.a(new StringBuilder("id: "), this.mDebugName, " ") : "");
        sb2.append("(");
        sb2.append(this.mX);
        sb2.append(", ");
        sb2.append(this.mY);
        sb2.append(") - (");
        sb2.append(this.mWidth);
        sb2.append(" x ");
        return a.a(sb2, this.mHeight, ")");
    }

    public void updateFromRuns(boolean z10, boolean z11) {
        int i10;
        int i11;
        boolean zIsResolved = z10 & this.horizontalRun.isResolved();
        boolean zIsResolved2 = z11 & this.verticalRun.isResolved();
        HorizontalWidgetRun horizontalWidgetRun = this.horizontalRun;
        int i12 = horizontalWidgetRun.start.value;
        VerticalWidgetRun verticalWidgetRun = this.verticalRun;
        int i13 = verticalWidgetRun.start.value;
        int i14 = horizontalWidgetRun.end.value;
        int i15 = verticalWidgetRun.end.value;
        int i16 = i15 - i13;
        if (i14 - i12 < 0 || i16 < 0 || i12 == Integer.MIN_VALUE || i12 == Integer.MAX_VALUE || i13 == Integer.MIN_VALUE || i13 == Integer.MAX_VALUE || i14 == Integer.MIN_VALUE || i14 == Integer.MAX_VALUE || i15 == Integer.MIN_VALUE || i15 == Integer.MAX_VALUE) {
            i14 = 0;
            i12 = 0;
            i15 = 0;
            i13 = 0;
        }
        int i17 = i14 - i12;
        int i18 = i15 - i13;
        if (zIsResolved) {
            this.mX = i12;
        }
        if (zIsResolved2) {
            this.mY = i13;
        }
        if (this.mVisibility == 8) {
            this.mWidth = 0;
            this.mHeight = 0;
            return;
        }
        if (zIsResolved) {
            if (this.mListDimensionBehaviors[0] == DimensionBehaviour.FIXED && i17 < (i11 = this.mWidth)) {
                i17 = i11;
            }
            this.mWidth = i17;
            int i19 = this.mMinWidth;
            if (i17 < i19) {
                this.mWidth = i19;
            }
        }
        if (zIsResolved2) {
            if (this.mListDimensionBehaviors[1] == DimensionBehaviour.FIXED && i18 < (i10 = this.mHeight)) {
                i18 = i10;
            }
            this.mHeight = i18;
            int i20 = this.mMinHeight;
            if (i18 < i20) {
                this.mHeight = i20;
            }
        }
    }

    public void updateFromSolver(LinearSystem linearSystem, boolean z10) {
        VerticalWidgetRun verticalWidgetRun;
        HorizontalWidgetRun horizontalWidgetRun;
        int objectVariableValue = linearSystem.getObjectVariableValue(this.mLeft);
        int objectVariableValue2 = linearSystem.getObjectVariableValue(this.mTop);
        int objectVariableValue3 = linearSystem.getObjectVariableValue(this.mRight);
        int objectVariableValue4 = linearSystem.getObjectVariableValue(this.mBottom);
        if (z10 && (horizontalWidgetRun = this.horizontalRun) != null) {
            DependencyNode dependencyNode = horizontalWidgetRun.start;
            if (dependencyNode.resolved) {
                DependencyNode dependencyNode2 = horizontalWidgetRun.end;
                if (dependencyNode2.resolved) {
                    objectVariableValue = dependencyNode.value;
                    objectVariableValue3 = dependencyNode2.value;
                }
            }
        }
        if (z10 && (verticalWidgetRun = this.verticalRun) != null) {
            DependencyNode dependencyNode3 = verticalWidgetRun.start;
            if (dependencyNode3.resolved) {
                DependencyNode dependencyNode4 = verticalWidgetRun.end;
                if (dependencyNode4.resolved) {
                    objectVariableValue2 = dependencyNode3.value;
                    objectVariableValue4 = dependencyNode4.value;
                }
            }
        }
        int i10 = objectVariableValue4 - objectVariableValue2;
        if (objectVariableValue3 - objectVariableValue < 0 || i10 < 0 || objectVariableValue == Integer.MIN_VALUE || objectVariableValue == Integer.MAX_VALUE || objectVariableValue2 == Integer.MIN_VALUE || objectVariableValue2 == Integer.MAX_VALUE || objectVariableValue3 == Integer.MIN_VALUE || objectVariableValue3 == Integer.MAX_VALUE || objectVariableValue4 == Integer.MIN_VALUE || objectVariableValue4 == Integer.MAX_VALUE) {
            objectVariableValue = 0;
            objectVariableValue4 = 0;
            objectVariableValue2 = 0;
            objectVariableValue3 = 0;
        }
        setFrame(objectVariableValue, objectVariableValue2, objectVariableValue3, objectVariableValue4);
    }

    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2) {
        connect(type, constraintWidget, type2, 0);
    }

    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i10) {
        ConstraintAnchor.Type type3;
        ConstraintAnchor.Type type4;
        boolean z10;
        ConstraintAnchor.Type type5 = ConstraintAnchor.Type.CENTER;
        if (type == type5) {
            if (type2 == type5) {
                ConstraintAnchor.Type type6 = ConstraintAnchor.Type.LEFT;
                ConstraintAnchor anchor = getAnchor(type6);
                ConstraintAnchor.Type type7 = ConstraintAnchor.Type.RIGHT;
                ConstraintAnchor anchor2 = getAnchor(type7);
                ConstraintAnchor.Type type8 = ConstraintAnchor.Type.TOP;
                ConstraintAnchor anchor3 = getAnchor(type8);
                ConstraintAnchor.Type type9 = ConstraintAnchor.Type.BOTTOM;
                ConstraintAnchor anchor4 = getAnchor(type9);
                boolean z11 = true;
                if ((anchor == null || !anchor.isConnected()) && (anchor2 == null || !anchor2.isConnected())) {
                    connect(type6, constraintWidget, type6, 0);
                    connect(type7, constraintWidget, type7, 0);
                    z10 = true;
                } else {
                    z10 = false;
                }
                if ((anchor3 == null || !anchor3.isConnected()) && (anchor4 == null || !anchor4.isConnected())) {
                    connect(type8, constraintWidget, type8, 0);
                    connect(type9, constraintWidget, type9, 0);
                } else {
                    z11 = false;
                }
                if (z10 && z11) {
                    getAnchor(type5).connect(constraintWidget.getAnchor(type5), 0);
                    return;
                }
                if (z10) {
                    ConstraintAnchor.Type type10 = ConstraintAnchor.Type.CENTER_X;
                    getAnchor(type10).connect(constraintWidget.getAnchor(type10), 0);
                    return;
                } else {
                    if (z11) {
                        ConstraintAnchor.Type type11 = ConstraintAnchor.Type.CENTER_Y;
                        getAnchor(type11).connect(constraintWidget.getAnchor(type11), 0);
                        return;
                    }
                    return;
                }
            }
            ConstraintAnchor.Type type12 = ConstraintAnchor.Type.LEFT;
            if (type2 != type12 && type2 != ConstraintAnchor.Type.RIGHT) {
                ConstraintAnchor.Type type13 = ConstraintAnchor.Type.TOP;
                if (type2 == type13 || type2 == ConstraintAnchor.Type.BOTTOM) {
                    connect(type13, constraintWidget, type2, 0);
                    connect(ConstraintAnchor.Type.BOTTOM, constraintWidget, type2, 0);
                    getAnchor(type5).connect(constraintWidget.getAnchor(type2), 0);
                    return;
                }
                return;
            }
            connect(type12, constraintWidget, type2, 0);
            connect(ConstraintAnchor.Type.RIGHT, constraintWidget, type2, 0);
            getAnchor(type5).connect(constraintWidget.getAnchor(type2), 0);
            return;
        }
        ConstraintAnchor.Type type14 = ConstraintAnchor.Type.CENTER_X;
        if (type == type14 && (type2 == (type4 = ConstraintAnchor.Type.LEFT) || type2 == ConstraintAnchor.Type.RIGHT)) {
            ConstraintAnchor anchor5 = getAnchor(type4);
            ConstraintAnchor anchor6 = constraintWidget.getAnchor(type2);
            ConstraintAnchor anchor7 = getAnchor(ConstraintAnchor.Type.RIGHT);
            anchor5.connect(anchor6, 0);
            anchor7.connect(anchor6, 0);
            getAnchor(type14).connect(anchor6, 0);
            return;
        }
        ConstraintAnchor.Type type15 = ConstraintAnchor.Type.CENTER_Y;
        if (type == type15 && (type2 == (type3 = ConstraintAnchor.Type.TOP) || type2 == ConstraintAnchor.Type.BOTTOM)) {
            ConstraintAnchor anchor8 = constraintWidget.getAnchor(type2);
            getAnchor(type3).connect(anchor8, 0);
            getAnchor(ConstraintAnchor.Type.BOTTOM).connect(anchor8, 0);
            getAnchor(type15).connect(anchor8, 0);
            return;
        }
        if (type == type14 && type2 == type14) {
            ConstraintAnchor.Type type16 = ConstraintAnchor.Type.LEFT;
            getAnchor(type16).connect(constraintWidget.getAnchor(type16), 0);
            ConstraintAnchor.Type type17 = ConstraintAnchor.Type.RIGHT;
            getAnchor(type17).connect(constraintWidget.getAnchor(type17), 0);
            getAnchor(type14).connect(constraintWidget.getAnchor(type2), 0);
            return;
        }
        if (type == type15 && type2 == type15) {
            ConstraintAnchor.Type type18 = ConstraintAnchor.Type.TOP;
            getAnchor(type18).connect(constraintWidget.getAnchor(type18), 0);
            ConstraintAnchor.Type type19 = ConstraintAnchor.Type.BOTTOM;
            getAnchor(type19).connect(constraintWidget.getAnchor(type19), 0);
            getAnchor(type15).connect(constraintWidget.getAnchor(type2), 0);
            return;
        }
        ConstraintAnchor anchor9 = getAnchor(type);
        ConstraintAnchor anchor10 = constraintWidget.getAnchor(type2);
        if (anchor9.isValidConnection(anchor10)) {
            ConstraintAnchor.Type type20 = ConstraintAnchor.Type.BASELINE;
            if (type == type20) {
                ConstraintAnchor anchor11 = getAnchor(ConstraintAnchor.Type.TOP);
                ConstraintAnchor anchor12 = getAnchor(ConstraintAnchor.Type.BOTTOM);
                if (anchor11 != null) {
                    anchor11.reset();
                }
                if (anchor12 != null) {
                    anchor12.reset();
                }
            } else if (type != ConstraintAnchor.Type.TOP && type != ConstraintAnchor.Type.BOTTOM) {
                if (type == ConstraintAnchor.Type.LEFT || type == ConstraintAnchor.Type.RIGHT) {
                    ConstraintAnchor anchor13 = getAnchor(type5);
                    if (anchor13.getTarget() != anchor10) {
                        anchor13.reset();
                    }
                    ConstraintAnchor opposite = getAnchor(type).getOpposite();
                    ConstraintAnchor anchor14 = getAnchor(type14);
                    if (anchor14.isConnected()) {
                        opposite.reset();
                        anchor14.reset();
                    }
                }
            } else {
                ConstraintAnchor anchor15 = getAnchor(type20);
                if (anchor15 != null) {
                    anchor15.reset();
                }
                ConstraintAnchor anchor16 = getAnchor(type5);
                if (anchor16.getTarget() != anchor10) {
                    anchor16.reset();
                }
                ConstraintAnchor opposite2 = getAnchor(type).getOpposite();
                ConstraintAnchor anchor17 = getAnchor(type15);
                if (anchor17.isConnected()) {
                    opposite2.reset();
                    anchor17.reset();
                }
            }
            anchor9.connect(anchor10, i10);
        }
    }

    private void serializeAttribute(StringBuilder sb2, String str, int i10, int i11) {
        if (i10 == i11) {
            return;
        }
        sb2.append(str);
        sb2.append(" :   ");
        sb2.append(i10);
        sb2.append(",\n");
    }

    public void setDimensionRatio(float f10, int i10) {
        this.mDimensionRatio = f10;
        this.mDimensionRatioSide = i10;
    }

    public void setFrame(int i10, int i11, int i12) {
        if (i12 == 0) {
            setHorizontalDimension(i10, i11);
        } else if (i12 == 1) {
            setVerticalDimension(i10, i11);
        }
    }

    private void getSceneString(StringBuilder sb2, String str, int i10, int i11, int i12, int i13, int i14, int i15, float f10, float f11) {
        sb2.append(str);
        sb2.append(" :  {\n");
        serializeAttribute(sb2, "      size", i10, 0);
        serializeAttribute(sb2, "      min", i11, 0);
        serializeAttribute(sb2, "      max", i12, Integer.MAX_VALUE);
        serializeAttribute(sb2, "      matchMin", i14, 0);
        serializeAttribute(sb2, "      matchDef", i15, 0);
        serializeAttribute(sb2, "      matchPercent", f10, 1.0f);
        sb2.append("    },\n");
    }

    private void getSceneString(StringBuilder sb2, String str, ConstraintAnchor constraintAnchor) {
        if (constraintAnchor.mTarget == null) {
            return;
        }
        sb2.append("    ");
        sb2.append(str);
        sb2.append(" : [ '");
        sb2.append(constraintAnchor.mTarget);
        sb2.append("'");
        if (constraintAnchor.mGoneMargin != Integer.MIN_VALUE || constraintAnchor.mMargin != 0) {
            sb2.append(g.f9491d);
            sb2.append(constraintAnchor.mMargin);
            if (constraintAnchor.mGoneMargin != Integer.MIN_VALUE) {
                sb2.append(g.f9491d);
                sb2.append(constraintAnchor.mGoneMargin);
                sb2.append(g.f9491d);
            }
        }
        sb2.append(" ] ,\n");
    }

    public ConstraintWidget(String str) {
        this.measured = false;
        this.run = new WidgetRun[2];
        this.horizontalRun = null;
        this.verticalRun = null;
        this.isTerminalWidget = new boolean[]{true, true};
        this.mResolvedHasRatio = false;
        this.mMeasureRequested = true;
        this.OPTIMIZE_WRAP = false;
        this.OPTIMIZE_WRAP_ON_RESOLVED = true;
        this.mWidthOverride = -1;
        this.mHeightOverride = -1;
        this.frame = new WidgetFrame(this);
        this.resolvedHorizontal = false;
        this.resolvedVertical = false;
        this.horizontalSolvingPass = false;
        this.verticalSolvingPass = false;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mWrapBehaviorInParent = 0;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = 0.0f;
        this.hasBaseline = false;
        this.mInVirtualLayout = false;
        this.mLastHorizontalMeasureSpec = 0;
        this.mLastVerticalMeasureSpec = 0;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mCenter = constraintAnchor;
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, constraintAnchor};
        this.mAnchors = new ArrayList<>();
        this.mIsInBarrier = new boolean[2];
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors = new DimensionBehaviour[]{dimensionBehaviour, dimensionBehaviour};
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        float f10 = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f10;
        this.mVerticalBiasPercent = f10;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        this.horizontalGroup = -1;
        this.verticalGroup = -1;
        addAnchors();
        setDebugName(str);
    }

    public ConstraintWidget(int i10, int i11, int i12, int i13) {
        this.measured = false;
        this.run = new WidgetRun[2];
        this.horizontalRun = null;
        this.verticalRun = null;
        this.isTerminalWidget = new boolean[]{true, true};
        this.mResolvedHasRatio = false;
        this.mMeasureRequested = true;
        this.OPTIMIZE_WRAP = false;
        this.OPTIMIZE_WRAP_ON_RESOLVED = true;
        this.mWidthOverride = -1;
        this.mHeightOverride = -1;
        this.frame = new WidgetFrame(this);
        this.resolvedHorizontal = false;
        this.resolvedVertical = false;
        this.horizontalSolvingPass = false;
        this.verticalSolvingPass = false;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mWrapBehaviorInParent = 0;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = 0.0f;
        this.hasBaseline = false;
        this.mInVirtualLayout = false;
        this.mLastHorizontalMeasureSpec = 0;
        this.mLastVerticalMeasureSpec = 0;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mCenter = constraintAnchor;
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, constraintAnchor};
        this.mAnchors = new ArrayList<>();
        this.mIsInBarrier = new boolean[2];
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors = new DimensionBehaviour[]{dimensionBehaviour, dimensionBehaviour};
        this.mParent = null;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        float f10 = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f10;
        this.mVerticalBiasPercent = f10;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        this.horizontalGroup = -1;
        this.verticalGroup = -1;
        this.mX = i10;
        this.mY = i11;
        this.mWidth = i12;
        this.mHeight = i13;
        addAnchors();
    }

    public ConstraintWidget(String str, int i10, int i11, int i12, int i13) {
        this(i10, i11, i12, i13);
        setDebugName(str);
    }

    public ConstraintWidget(int i10, int i11) {
        this(0, 0, i10, i11);
    }

    public ConstraintWidget(String str, int i10, int i11) {
        this(i10, i11);
        setDebugName(str);
    }
}
