package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class Flow extends VirtualLayout {
    public static final int HORIZONTAL_ALIGN_CENTER = 2;
    public static final int HORIZONTAL_ALIGN_END = 1;
    public static final int HORIZONTAL_ALIGN_START = 0;
    public static final int VERTICAL_ALIGN_BASELINE = 3;
    public static final int VERTICAL_ALIGN_BOTTOM = 1;
    public static final int VERTICAL_ALIGN_CENTER = 2;
    public static final int VERTICAL_ALIGN_TOP = 0;
    public static final int WRAP_ALIGNED = 2;
    public static final int WRAP_CHAIN = 1;
    public static final int WRAP_CHAIN_NEW = 3;
    public static final int WRAP_NONE = 0;
    private ConstraintWidget[] mDisplayedWidgets;
    private int mHorizontalStyle = -1;
    private int mVerticalStyle = -1;
    private int mFirstHorizontalStyle = -1;
    private int mFirstVerticalStyle = -1;
    private int mLastHorizontalStyle = -1;
    private int mLastVerticalStyle = -1;
    private float mHorizontalBias = 0.5f;
    private float mVerticalBias = 0.5f;
    private float mFirstHorizontalBias = 0.5f;
    private float mFirstVerticalBias = 0.5f;
    private float mLastHorizontalBias = 0.5f;
    private float mLastVerticalBias = 0.5f;
    private int mHorizontalGap = 0;
    private int mVerticalGap = 0;
    private int mHorizontalAlign = 2;
    private int mVerticalAlign = 2;
    private int mWrapMode = 0;
    private int mMaxElementsWrap = -1;
    private int mOrientation = 0;
    private ArrayList<WidgetsList> mChainList = new ArrayList<>();
    private ConstraintWidget[] mAlignedBiggestElementsInRows = null;
    private ConstraintWidget[] mAlignedBiggestElementsInCols = null;
    private int[] mAlignedDimensions = null;
    private int mDisplayedWidgetsCount = 0;

    public class WidgetsList {
        private ConstraintAnchor mBottom;
        private ConstraintAnchor mLeft;
        private int mMax;
        private int mOrientation;
        private int mPaddingBottom;
        private int mPaddingLeft;
        private int mPaddingRight;
        private int mPaddingTop;
        private ConstraintAnchor mRight;
        private ConstraintAnchor mTop;
        private ConstraintWidget biggest = null;
        int biggestDimension = 0;
        private int mWidth = 0;
        private int mHeight = 0;
        private int mStartIndex = 0;
        private int mCount = 0;
        private int mNbMatchConstraintsWidgets = 0;

        public WidgetsList(int i8, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i9) {
            this.mPaddingLeft = 0;
            this.mPaddingTop = 0;
            this.mPaddingRight = 0;
            this.mPaddingBottom = 0;
            this.mMax = 0;
            this.mOrientation = i8;
            this.mLeft = constraintAnchor;
            this.mTop = constraintAnchor2;
            this.mRight = constraintAnchor3;
            this.mBottom = constraintAnchor4;
            this.mPaddingLeft = Flow.this.getPaddingLeft();
            this.mPaddingTop = Flow.this.getPaddingTop();
            this.mPaddingRight = Flow.this.getPaddingRight();
            this.mPaddingBottom = Flow.this.getPaddingBottom();
            this.mMax = i9;
        }

        private void recomputeDimensions() {
            this.mWidth = 0;
            this.mHeight = 0;
            this.biggest = null;
            this.biggestDimension = 0;
            int i8 = this.mCount;
            for (int i9 = 0; i9 < i8 && this.mStartIndex + i9 < Flow.this.mDisplayedWidgetsCount; i9++) {
                ConstraintWidget constraintWidget = Flow.this.mDisplayedWidgets[this.mStartIndex + i9];
                if (this.mOrientation == 0) {
                    int width = constraintWidget.getWidth();
                    int i10 = Flow.this.mHorizontalGap;
                    if (constraintWidget.getVisibility() == 8) {
                        i10 = 0;
                    }
                    this.mWidth = width + i10 + this.mWidth;
                    int widgetHeight = Flow.this.getWidgetHeight(constraintWidget, this.mMax);
                    if (this.biggest == null || this.biggestDimension < widgetHeight) {
                        this.biggest = constraintWidget;
                        this.biggestDimension = widgetHeight;
                        this.mHeight = widgetHeight;
                    }
                } else {
                    int widgetWidth = Flow.this.getWidgetWidth(constraintWidget, this.mMax);
                    int widgetHeight2 = Flow.this.getWidgetHeight(constraintWidget, this.mMax);
                    int i11 = Flow.this.mVerticalGap;
                    if (constraintWidget.getVisibility() == 8) {
                        i11 = 0;
                    }
                    this.mHeight = widgetHeight2 + i11 + this.mHeight;
                    if (this.biggest == null || this.biggestDimension < widgetWidth) {
                        this.biggest = constraintWidget;
                        this.biggestDimension = widgetWidth;
                        this.mWidth = widgetWidth;
                    }
                }
            }
        }

        public void add(ConstraintWidget constraintWidget) {
            if (this.mOrientation == 0) {
                int widgetWidth = Flow.this.getWidgetWidth(constraintWidget, this.mMax);
                if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.mNbMatchConstraintsWidgets++;
                    widgetWidth = 0;
                }
                this.mWidth = widgetWidth + (constraintWidget.getVisibility() != 8 ? Flow.this.mHorizontalGap : 0) + this.mWidth;
                int widgetHeight = Flow.this.getWidgetHeight(constraintWidget, this.mMax);
                if (this.biggest == null || this.biggestDimension < widgetHeight) {
                    this.biggest = constraintWidget;
                    this.biggestDimension = widgetHeight;
                    this.mHeight = widgetHeight;
                }
            } else {
                int widgetWidth2 = Flow.this.getWidgetWidth(constraintWidget, this.mMax);
                int widgetHeight2 = Flow.this.getWidgetHeight(constraintWidget, this.mMax);
                if (constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.mNbMatchConstraintsWidgets++;
                    widgetHeight2 = 0;
                }
                this.mHeight = widgetHeight2 + (constraintWidget.getVisibility() != 8 ? Flow.this.mVerticalGap : 0) + this.mHeight;
                if (this.biggest == null || this.biggestDimension < widgetWidth2) {
                    this.biggest = constraintWidget;
                    this.biggestDimension = widgetWidth2;
                    this.mWidth = widgetWidth2;
                }
            }
            this.mCount++;
        }

        public void clear() {
            this.biggestDimension = 0;
            this.biggest = null;
            this.mWidth = 0;
            this.mHeight = 0;
            this.mStartIndex = 0;
            this.mCount = 0;
            this.mNbMatchConstraintsWidgets = 0;
        }

        public void createConstraints(boolean z2, int i8, boolean z3) {
            ConstraintWidget constraintWidget;
            char c9;
            float f;
            float f4;
            int i9 = this.mCount;
            for (int i10 = 0; i10 < i9 && this.mStartIndex + i10 < Flow.this.mDisplayedWidgetsCount; i10++) {
                ConstraintWidget constraintWidget2 = Flow.this.mDisplayedWidgets[this.mStartIndex + i10];
                if (constraintWidget2 != null) {
                    constraintWidget2.resetAnchors();
                }
            }
            if (i9 == 0 || this.biggest == null) {
                return;
            }
            boolean z5 = z3 && i8 == 0;
            int i11 = -1;
            int i12 = -1;
            for (int i13 = 0; i13 < i9; i13++) {
                int i14 = z2 ? (i9 - 1) - i13 : i13;
                if (this.mStartIndex + i14 >= Flow.this.mDisplayedWidgetsCount) {
                    break;
                }
                ConstraintWidget constraintWidget3 = Flow.this.mDisplayedWidgets[this.mStartIndex + i14];
                if (constraintWidget3 != null && constraintWidget3.getVisibility() == 0) {
                    if (i11 == -1) {
                        i11 = i13;
                    }
                    i12 = i13;
                }
            }
            ConstraintWidget constraintWidget4 = null;
            if (this.mOrientation != 0) {
                ConstraintWidget constraintWidget5 = this.biggest;
                constraintWidget5.setHorizontalChainStyle(Flow.this.mHorizontalStyle);
                int i15 = this.mPaddingLeft;
                if (i8 > 0) {
                    i15 += Flow.this.mHorizontalGap;
                }
                if (z2) {
                    constraintWidget5.mRight.connect(this.mRight, i15);
                    if (z3) {
                        constraintWidget5.mLeft.connect(this.mLeft, this.mPaddingRight);
                    }
                    if (i8 > 0) {
                        this.mRight.mOwner.mLeft.connect(constraintWidget5.mRight, 0);
                    }
                } else {
                    constraintWidget5.mLeft.connect(this.mLeft, i15);
                    if (z3) {
                        constraintWidget5.mRight.connect(this.mRight, this.mPaddingRight);
                    }
                    if (i8 > 0) {
                        this.mLeft.mOwner.mRight.connect(constraintWidget5.mLeft, 0);
                    }
                }
                for (int i16 = 0; i16 < i9 && this.mStartIndex + i16 < Flow.this.mDisplayedWidgetsCount; i16++) {
                    ConstraintWidget constraintWidget6 = Flow.this.mDisplayedWidgets[this.mStartIndex + i16];
                    if (constraintWidget6 != null) {
                        if (i16 == 0) {
                            constraintWidget6.connect(constraintWidget6.mTop, this.mTop, this.mPaddingTop);
                            int i17 = Flow.this.mVerticalStyle;
                            float f10 = Flow.this.mVerticalBias;
                            if (this.mStartIndex == 0 && Flow.this.mFirstVerticalStyle != -1) {
                                i17 = Flow.this.mFirstVerticalStyle;
                                f10 = Flow.this.mFirstVerticalBias;
                            } else if (z3 && Flow.this.mLastVerticalStyle != -1) {
                                i17 = Flow.this.mLastVerticalStyle;
                                f10 = Flow.this.mLastVerticalBias;
                            }
                            constraintWidget6.setVerticalChainStyle(i17);
                            constraintWidget6.setVerticalBiasPercent(f10);
                        }
                        if (i16 == i9 - 1) {
                            constraintWidget6.connect(constraintWidget6.mBottom, this.mBottom, this.mPaddingBottom);
                        }
                        if (constraintWidget4 != null) {
                            constraintWidget6.mTop.connect(constraintWidget4.mBottom, Flow.this.mVerticalGap);
                            if (i16 == i11) {
                                constraintWidget6.mTop.setGoneMargin(this.mPaddingTop);
                            }
                            constraintWidget4.mBottom.connect(constraintWidget6.mTop, 0);
                            if (i16 == i12 + 1) {
                                constraintWidget4.mBottom.setGoneMargin(this.mPaddingBottom);
                            }
                        }
                        if (constraintWidget6 != constraintWidget5) {
                            if (z2) {
                                int i18 = Flow.this.mHorizontalAlign;
                                if (i18 == 0) {
                                    constraintWidget6.mRight.connect(constraintWidget5.mRight, 0);
                                } else if (i18 == 1) {
                                    constraintWidget6.mLeft.connect(constraintWidget5.mLeft, 0);
                                } else if (i18 == 2) {
                                    constraintWidget6.mLeft.connect(constraintWidget5.mLeft, 0);
                                    constraintWidget6.mRight.connect(constraintWidget5.mRight, 0);
                                }
                            } else {
                                int i19 = Flow.this.mHorizontalAlign;
                                if (i19 == 0) {
                                    constraintWidget6.mLeft.connect(constraintWidget5.mLeft, 0);
                                } else if (i19 == 1) {
                                    constraintWidget6.mRight.connect(constraintWidget5.mRight, 0);
                                } else if (i19 == 2) {
                                    if (z5) {
                                        constraintWidget6.mLeft.connect(this.mLeft, this.mPaddingLeft);
                                        constraintWidget6.mRight.connect(this.mRight, this.mPaddingRight);
                                    } else {
                                        constraintWidget6.mLeft.connect(constraintWidget5.mLeft, 0);
                                        constraintWidget6.mRight.connect(constraintWidget5.mRight, 0);
                                    }
                                }
                            }
                        }
                        constraintWidget4 = constraintWidget6;
                    }
                }
                return;
            }
            ConstraintWidget constraintWidget7 = this.biggest;
            constraintWidget7.setVerticalChainStyle(Flow.this.mVerticalStyle);
            int i20 = this.mPaddingTop;
            if (i8 > 0) {
                i20 += Flow.this.mVerticalGap;
            }
            constraintWidget7.mTop.connect(this.mTop, i20);
            if (z3) {
                constraintWidget7.mBottom.connect(this.mBottom, this.mPaddingBottom);
            }
            if (i8 > 0) {
                this.mTop.mOwner.mBottom.connect(constraintWidget7.mTop, 0);
            }
            char c10 = 3;
            if (Flow.this.mVerticalAlign != 3 || constraintWidget7.hasBaseline()) {
                constraintWidget = constraintWidget7;
                break;
            }
            int i21 = 0;
            while (true) {
                if (i21 < i9) {
                    int i22 = z2 ? (i9 - 1) - i21 : i21;
                    if (this.mStartIndex + i22 < Flow.this.mDisplayedWidgetsCount) {
                        constraintWidget = Flow.this.mDisplayedWidgets[this.mStartIndex + i22];
                        if (constraintWidget.hasBaseline()) {
                            break;
                        } else {
                            i21++;
                        }
                    }
                }
                constraintWidget = constraintWidget7;
                break;
            }
            int i23 = 0;
            while (i23 < i9) {
                int i24 = z2 ? (i9 - 1) - i23 : i23;
                if (this.mStartIndex + i24 >= Flow.this.mDisplayedWidgetsCount) {
                    return;
                }
                ConstraintWidget constraintWidget8 = Flow.this.mDisplayedWidgets[this.mStartIndex + i24];
                if (constraintWidget8 == null) {
                    constraintWidget8 = constraintWidget4;
                    c9 = c10;
                } else {
                    if (i23 == 0) {
                        constraintWidget8.connect(constraintWidget8.mLeft, this.mLeft, this.mPaddingLeft);
                    }
                    if (i24 == 0) {
                        int i25 = Flow.this.mHorizontalStyle;
                        float f11 = Flow.this.mHorizontalBias;
                        if (z2) {
                            f11 = 1.0f - f11;
                        }
                        if (this.mStartIndex == 0 && Flow.this.mFirstHorizontalStyle != -1) {
                            i25 = Flow.this.mFirstHorizontalStyle;
                            if (z2) {
                                f4 = Flow.this.mFirstHorizontalBias;
                                f = 1.0f - f4;
                            } else {
                                f = Flow.this.mFirstHorizontalBias;
                            }
                            f11 = f;
                        } else if (z3 && Flow.this.mLastHorizontalStyle != -1) {
                            i25 = Flow.this.mLastHorizontalStyle;
                            if (z2) {
                                f4 = Flow.this.mLastHorizontalBias;
                                f = 1.0f - f4;
                            } else {
                                f = Flow.this.mLastHorizontalBias;
                            }
                            f11 = f;
                        }
                        constraintWidget8.setHorizontalChainStyle(i25);
                        constraintWidget8.setHorizontalBiasPercent(f11);
                    }
                    if (i23 == i9 - 1) {
                        constraintWidget8.connect(constraintWidget8.mRight, this.mRight, this.mPaddingRight);
                    }
                    if (constraintWidget4 != null) {
                        constraintWidget8.mLeft.connect(constraintWidget4.mRight, Flow.this.mHorizontalGap);
                        if (i23 == i11) {
                            constraintWidget8.mLeft.setGoneMargin(this.mPaddingLeft);
                        }
                        constraintWidget4.mRight.connect(constraintWidget8.mLeft, 0);
                        if (i23 == i12 + 1) {
                            constraintWidget4.mRight.setGoneMargin(this.mPaddingRight);
                        }
                    }
                    if (constraintWidget8 != constraintWidget7) {
                        c9 = 3;
                        if (Flow.this.mVerticalAlign == 3 && constraintWidget.hasBaseline() && constraintWidget8 != constraintWidget && constraintWidget8.hasBaseline()) {
                            constraintWidget8.mBaseline.connect(constraintWidget.mBaseline, 0);
                        } else {
                            int i26 = Flow.this.mVerticalAlign;
                            if (i26 == 0) {
                                constraintWidget8.mTop.connect(constraintWidget7.mTop, 0);
                            } else if (i26 == 1) {
                                constraintWidget8.mBottom.connect(constraintWidget7.mBottom, 0);
                            } else if (z5) {
                                constraintWidget8.mTop.connect(this.mTop, this.mPaddingTop);
                                constraintWidget8.mBottom.connect(this.mBottom, this.mPaddingBottom);
                            } else {
                                constraintWidget8.mTop.connect(constraintWidget7.mTop, 0);
                                constraintWidget8.mBottom.connect(constraintWidget7.mBottom, 0);
                            }
                        }
                    } else {
                        c9 = 3;
                    }
                }
                i23++;
                c10 = c9;
                constraintWidget4 = constraintWidget8;
            }
        }

        public int getHeight() {
            return this.mOrientation == 1 ? this.mHeight - Flow.this.mVerticalGap : this.mHeight;
        }

        public int getWidth() {
            return this.mOrientation == 0 ? this.mWidth - Flow.this.mHorizontalGap : this.mWidth;
        }

        public void measureMatchConstraints(int i8) {
            int i9 = this.mNbMatchConstraintsWidgets;
            if (i9 == 0) {
                return;
            }
            int i10 = this.mCount;
            int i11 = i8 / i9;
            for (int i12 = 0; i12 < i10 && this.mStartIndex + i12 < Flow.this.mDisplayedWidgetsCount; i12++) {
                ConstraintWidget constraintWidget = Flow.this.mDisplayedWidgets[this.mStartIndex + i12];
                if (this.mOrientation == 0) {
                    if (constraintWidget != null && constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mMatchConstraintDefaultWidth == 0) {
                        Flow.this.measure(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, i11, constraintWidget.getVerticalDimensionBehaviour(), constraintWidget.getHeight());
                    }
                } else if (constraintWidget != null && constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mMatchConstraintDefaultHeight == 0) {
                    Flow.this.measure(constraintWidget, constraintWidget.getHorizontalDimensionBehaviour(), constraintWidget.getWidth(), ConstraintWidget.DimensionBehaviour.FIXED, i11);
                }
            }
            recomputeDimensions();
        }

        public void setStartIndex(int i8) {
            this.mStartIndex = i8;
        }

        public void setup(int i8, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i9, int i10, int i11, int i12, int i13) {
            this.mOrientation = i8;
            this.mLeft = constraintAnchor;
            this.mTop = constraintAnchor2;
            this.mRight = constraintAnchor3;
            this.mBottom = constraintAnchor4;
            this.mPaddingLeft = i9;
            this.mPaddingTop = i10;
            this.mPaddingRight = i11;
            this.mPaddingBottom = i12;
            this.mMax = i13;
        }
    }

    private void createAlignedConstraints(boolean z2) {
        ConstraintWidget constraintWidget;
        float f;
        int i8;
        if (this.mAlignedDimensions == null || this.mAlignedBiggestElementsInCols == null || this.mAlignedBiggestElementsInRows == null) {
            return;
        }
        for (int i9 = 0; i9 < this.mDisplayedWidgetsCount; i9++) {
            this.mDisplayedWidgets[i9].resetAnchors();
        }
        int[] iArr = this.mAlignedDimensions;
        int i10 = iArr[0];
        int i11 = iArr[1];
        float f4 = this.mHorizontalBias;
        ConstraintWidget constraintWidget2 = null;
        int i12 = 0;
        while (i12 < i10) {
            if (z2) {
                i8 = (i10 - i12) - 1;
                f = 1.0f - this.mHorizontalBias;
            } else {
                f = f4;
                i8 = i12;
            }
            ConstraintWidget constraintWidget3 = this.mAlignedBiggestElementsInCols[i8];
            if (constraintWidget3 != null && constraintWidget3.getVisibility() != 8) {
                if (i12 == 0) {
                    constraintWidget3.connect(constraintWidget3.mLeft, this.mLeft, getPaddingLeft());
                    constraintWidget3.setHorizontalChainStyle(this.mHorizontalStyle);
                    constraintWidget3.setHorizontalBiasPercent(f);
                }
                if (i12 == i10 - 1) {
                    constraintWidget3.connect(constraintWidget3.mRight, this.mRight, getPaddingRight());
                }
                if (i12 > 0 && constraintWidget2 != null) {
                    constraintWidget3.connect(constraintWidget3.mLeft, constraintWidget2.mRight, this.mHorizontalGap);
                    constraintWidget2.connect(constraintWidget2.mRight, constraintWidget3.mLeft, 0);
                }
                constraintWidget2 = constraintWidget3;
            }
            i12++;
            f4 = f;
        }
        for (int i13 = 0; i13 < i11; i13++) {
            ConstraintWidget constraintWidget4 = this.mAlignedBiggestElementsInRows[i13];
            if (constraintWidget4 != null && constraintWidget4.getVisibility() != 8) {
                if (i13 == 0) {
                    constraintWidget4.connect(constraintWidget4.mTop, this.mTop, getPaddingTop());
                    constraintWidget4.setVerticalChainStyle(this.mVerticalStyle);
                    constraintWidget4.setVerticalBiasPercent(this.mVerticalBias);
                }
                if (i13 == i11 - 1) {
                    constraintWidget4.connect(constraintWidget4.mBottom, this.mBottom, getPaddingBottom());
                }
                if (i13 > 0 && constraintWidget2 != null) {
                    constraintWidget4.connect(constraintWidget4.mTop, constraintWidget2.mBottom, this.mVerticalGap);
                    constraintWidget2.connect(constraintWidget2.mBottom, constraintWidget4.mTop, 0);
                }
                constraintWidget2 = constraintWidget4;
            }
        }
        for (int i14 = 0; i14 < i10; i14++) {
            for (int i15 = 0; i15 < i11; i15++) {
                int i16 = (i15 * i10) + i14;
                if (this.mOrientation == 1) {
                    i16 = (i14 * i11) + i15;
                }
                ConstraintWidget[] constraintWidgetArr = this.mDisplayedWidgets;
                if (i16 < constraintWidgetArr.length && (constraintWidget = constraintWidgetArr[i16]) != null && constraintWidget.getVisibility() != 8) {
                    ConstraintWidget constraintWidget5 = this.mAlignedBiggestElementsInCols[i14];
                    ConstraintWidget constraintWidget6 = this.mAlignedBiggestElementsInRows[i15];
                    if (constraintWidget != constraintWidget5) {
                        constraintWidget.connect(constraintWidget.mLeft, constraintWidget5.mLeft, 0);
                        constraintWidget.connect(constraintWidget.mRight, constraintWidget5.mRight, 0);
                    }
                    if (constraintWidget != constraintWidget6) {
                        constraintWidget.connect(constraintWidget.mTop, constraintWidget6.mTop, 0);
                        constraintWidget.connect(constraintWidget.mBottom, constraintWidget6.mBottom, 0);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getWidgetHeight(ConstraintWidget constraintWidget, int i8) {
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int i9 = constraintWidget.mMatchConstraintDefaultHeight;
            if (i9 == 0) {
                return 0;
            }
            if (i9 == 2) {
                int i10 = (int) (constraintWidget.mMatchConstraintPercentHeight * i8);
                if (i10 != constraintWidget.getHeight()) {
                    constraintWidget.setMeasureRequested(true);
                    measure(constraintWidget, constraintWidget.getHorizontalDimensionBehaviour(), constraintWidget.getWidth(), ConstraintWidget.DimensionBehaviour.FIXED, i10);
                }
                return i10;
            }
            if (i9 == 1) {
                return constraintWidget.getHeight();
            }
            if (i9 == 3) {
                return (int) ((constraintWidget.getWidth() * constraintWidget.mDimensionRatio) + 0.5f);
            }
        }
        return constraintWidget.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getWidgetWidth(ConstraintWidget constraintWidget, int i8) {
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int i9 = constraintWidget.mMatchConstraintDefaultWidth;
            if (i9 == 0) {
                return 0;
            }
            if (i9 == 2) {
                int i10 = (int) (constraintWidget.mMatchConstraintPercentWidth * i8);
                if (i10 != constraintWidget.getWidth()) {
                    constraintWidget.setMeasureRequested(true);
                    measure(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, i10, constraintWidget.getVerticalDimensionBehaviour(), constraintWidget.getHeight());
                }
                return i10;
            }
            if (i9 == 1) {
                return constraintWidget.getWidth();
            }
            if (i9 == 3) {
                return (int) ((constraintWidget.getHeight() * constraintWidget.mDimensionRatio) + 0.5f);
            }
        }
        return constraintWidget.getWidth();
    }

    /* JADX WARN: Code duplicated, block: B:100:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:106:0x010f A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:109:0x0117 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:117:0x011d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:118:0x0115 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:119:0x0059 A[ADDED_TO_REGION, EDGE_INSN: B:119:0x0059->B:42:0x0059 BREAK  A[LOOP:1: B:44:0x005c->B:124:0x005c], REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:121:0x010d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:122:0x0059 A[ADDED_TO_REGION, EDGE_INSN: B:122:0x0059->B:42:0x0059 BREAK  A[LOOP:1: B:44:0x005c->B:124:0x005c], REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:132:0x00d3 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:136:0x00ed A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:139:0x0104 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:45:0x005e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:46:0x0060  */
    /* JADX WARN: Code duplicated, block: B:47:0x006a  */
    /* JADX WARN: Code duplicated, block: B:50:0x0078  */
    /* JADX WARN: Code duplicated, block: B:54:0x0080  */
    /* JADX WARN: Code duplicated, block: B:57:0x0088  */
    /* JADX WARN: Code duplicated, block: B:61:0x0090  */
    /* JADX WARN: Code duplicated, block: B:64:0x0097  */
    /* JADX WARN: Code duplicated, block: B:66:0x009a  */
    /* JADX WARN: Code duplicated, block: B:68:0x009f  */
    /* JADX WARN: Code duplicated, block: B:72:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:77:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:79:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:82:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:84:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:89:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:91:0x00e3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:92:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:97:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:99:0x00fa A[DONT_INVERT] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:105:0x010d -> B:42:0x0059). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:106:0x010f -> B:42:0x0059). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:108:0x0115 -> B:42:0x0059). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:109:0x0117 -> B:42:0x0059). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:45:0x005e
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private void measureAligned(androidx.constraintlayout.core.widgets.ConstraintWidget[] r11, int r12, int r13, int r14, int[] r15) {
        /*
            Method dump skipped, instruction units count: 292
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.Flow.measureAligned(androidx.constraintlayout.core.widgets.ConstraintWidget[], int, int, int, int[]):void");
    }

    private void measureChainWrap(ConstraintWidget[] constraintWidgetArr, int i8, int i9, int i10, int[] iArr) {
        int i11;
        int i12;
        int i13;
        ConstraintAnchor constraintAnchor;
        int paddingRight;
        ConstraintAnchor constraintAnchor2;
        int paddingBottom;
        int i14;
        if (i8 == 0) {
            return;
        }
        this.mChainList.clear();
        WidgetsList widgetsList = new WidgetsList(i9, this.mLeft, this.mTop, this.mRight, this.mBottom, i10);
        this.mChainList.add(widgetsList);
        if (i9 == 0) {
            i11 = 0;
            int i15 = 0;
            int i16 = 0;
            while (i16 < i8) {
                ConstraintWidget constraintWidget = constraintWidgetArr[i16];
                int widgetWidth = getWidgetWidth(constraintWidget, i10);
                if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i11++;
                }
                int i17 = i11;
                boolean z2 = (i15 == i10 || (this.mHorizontalGap + i15) + widgetWidth > i10) && widgetsList.biggest != null;
                if (!z2 && i16 > 0 && (i14 = this.mMaxElementsWrap) > 0 && i16 % i14 == 0) {
                    z2 = true;
                }
                if (z2) {
                    widgetsList = new WidgetsList(i9, this.mLeft, this.mTop, this.mRight, this.mBottom, i10);
                    widgetsList.setStartIndex(i16);
                    this.mChainList.add(widgetsList);
                } else {
                    if (i16 > 0) {
                        i15 = this.mHorizontalGap + widgetWidth + i15;
                    }
                    widgetsList.add(constraintWidget);
                    i16++;
                    i11 = i17;
                }
                i15 = widgetWidth;
                widgetsList.add(constraintWidget);
                i16++;
                i11 = i17;
            }
        } else {
            i11 = 0;
            int i18 = 0;
            int i19 = 0;
            while (i19 < i8) {
                ConstraintWidget constraintWidget2 = constraintWidgetArr[i19];
                int widgetHeight = getWidgetHeight(constraintWidget2, i10);
                if (constraintWidget2.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i11++;
                }
                int i20 = i11;
                boolean z3 = (i18 == i10 || (this.mVerticalGap + i18) + widgetHeight > i10) && widgetsList.biggest != null;
                if (!z3 && i19 > 0 && (i12 = this.mMaxElementsWrap) > 0 && i19 % i12 == 0) {
                    z3 = true;
                }
                if (z3) {
                    widgetsList = new WidgetsList(i9, this.mLeft, this.mTop, this.mRight, this.mBottom, i10);
                    widgetsList.setStartIndex(i19);
                    this.mChainList.add(widgetsList);
                } else {
                    if (i19 > 0) {
                        i18 = this.mVerticalGap + widgetHeight + i18;
                    }
                    widgetsList.add(constraintWidget2);
                    i19++;
                    i11 = i20;
                }
                i18 = widgetHeight;
                widgetsList.add(constraintWidget2);
                i19++;
                i11 = i20;
            }
        }
        int size = this.mChainList.size();
        ConstraintAnchor constraintAnchor3 = this.mLeft;
        ConstraintAnchor constraintAnchor4 = this.mTop;
        ConstraintAnchor constraintAnchor5 = this.mRight;
        ConstraintAnchor constraintAnchor6 = this.mBottom;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight2 = getPaddingRight();
        int paddingBottom2 = getPaddingBottom();
        ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        boolean z5 = horizontalDimensionBehaviour == dimensionBehaviour || getVerticalDimensionBehaviour() == dimensionBehaviour;
        if (i11 > 0 && z5) {
            for (int i21 = 0; i21 < size; i21++) {
                WidgetsList widgetsList2 = this.mChainList.get(i21);
                if (i9 == 0) {
                    widgetsList2.measureMatchConstraints(i10 - widgetsList2.getWidth());
                } else {
                    widgetsList2.measureMatchConstraints(i10 - widgetsList2.getHeight());
                }
            }
        }
        int i22 = paddingTop;
        int i23 = paddingRight2;
        int height = 0;
        int width = 0;
        int i24 = 0;
        int i25 = paddingLeft;
        ConstraintAnchor constraintAnchor7 = constraintAnchor4;
        ConstraintAnchor constraintAnchor8 = constraintAnchor3;
        int i26 = paddingBottom2;
        while (i24 < size) {
            WidgetsList widgetsList3 = this.mChainList.get(i24);
            if (i9 == 0) {
                if (i24 < size - 1) {
                    constraintAnchor2 = this.mChainList.get(i24 + 1).biggest.mTop;
                    paddingBottom = 0;
                } else {
                    constraintAnchor2 = this.mBottom;
                    paddingBottom = getPaddingBottom();
                }
                ConstraintAnchor constraintAnchor9 = widgetsList3.biggest.mBottom;
                ConstraintAnchor constraintAnchor10 = constraintAnchor8;
                ConstraintAnchor constraintAnchor11 = constraintAnchor8;
                int i27 = height;
                ConstraintAnchor constraintAnchor12 = constraintAnchor7;
                int i28 = width;
                ConstraintAnchor constraintAnchor13 = constraintAnchor5;
                ConstraintAnchor constraintAnchor14 = constraintAnchor5;
                i13 = i24;
                widgetsList3.setup(i9, constraintAnchor10, constraintAnchor12, constraintAnchor13, constraintAnchor2, i25, i22, i23, paddingBottom, i10);
                int iMax = Math.max(i28, widgetsList3.getWidth());
                height = i27 + widgetsList3.getHeight();
                if (i13 > 0) {
                    height += this.mVerticalGap;
                }
                constraintAnchor8 = constraintAnchor11;
                width = iMax;
                i22 = 0;
                constraintAnchor7 = constraintAnchor9;
                constraintAnchor = constraintAnchor14;
                int i29 = paddingBottom;
                constraintAnchor6 = constraintAnchor2;
                i26 = i29;
            } else {
                ConstraintAnchor constraintAnchor15 = constraintAnchor8;
                int i30 = height;
                int i31 = width;
                i13 = i24;
                if (i13 < size - 1) {
                    constraintAnchor = this.mChainList.get(i13 + 1).biggest.mLeft;
                    paddingRight = 0;
                } else {
                    constraintAnchor = this.mRight;
                    paddingRight = getPaddingRight();
                }
                ConstraintAnchor constraintAnchor16 = widgetsList3.biggest.mRight;
                widgetsList3.setup(i9, constraintAnchor15, constraintAnchor7, constraintAnchor, constraintAnchor6, i25, i22, paddingRight, i26, i10);
                width = i31 + widgetsList3.getWidth();
                int iMax2 = Math.max(i30, widgetsList3.getHeight());
                if (i13 > 0) {
                    width += this.mHorizontalGap;
                }
                height = iMax2;
                i25 = 0;
                i23 = paddingRight;
                constraintAnchor8 = constraintAnchor16;
            }
            i24 = i13 + 1;
            constraintAnchor5 = constraintAnchor;
        }
        iArr[0] = width;
        iArr[1] = height;
    }

    private void measureChainWrap_new(ConstraintWidget[] constraintWidgetArr, int i8, int i9, int i10, int[] iArr) {
        int i11;
        int i12;
        int i13;
        ConstraintAnchor constraintAnchor;
        int paddingRight;
        ConstraintAnchor constraintAnchor2;
        int paddingBottom;
        int i14;
        if (i8 == 0) {
            return;
        }
        this.mChainList.clear();
        WidgetsList widgetsList = new WidgetsList(i9, this.mLeft, this.mTop, this.mRight, this.mBottom, i10);
        this.mChainList.add(widgetsList);
        if (i9 == 0) {
            int i15 = 0;
            i11 = 0;
            int i16 = 0;
            int i17 = 0;
            while (i17 < i8) {
                int i18 = i15 + 1;
                ConstraintWidget constraintWidget = constraintWidgetArr[i17];
                int widgetWidth = getWidgetWidth(constraintWidget, i10);
                if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i11++;
                }
                int i19 = i11;
                boolean z2 = (i16 == i10 || (this.mHorizontalGap + i16) + widgetWidth > i10) && widgetsList.biggest != null;
                if (!z2 && i17 > 0 && (i14 = this.mMaxElementsWrap) > 0 && i18 > i14) {
                    z2 = true;
                }
                if (z2) {
                    widgetsList = new WidgetsList(i9, this.mLeft, this.mTop, this.mRight, this.mBottom, i10);
                    widgetsList.setStartIndex(i17);
                    this.mChainList.add(widgetsList);
                    i15 = i18;
                    i16 = widgetWidth;
                } else {
                    i16 = i17 > 0 ? this.mHorizontalGap + widgetWidth + i16 : widgetWidth;
                    i15 = 0;
                }
                widgetsList.add(constraintWidget);
                i17++;
                i11 = i19;
            }
        } else {
            int i20 = 0;
            i11 = 0;
            int i21 = 0;
            while (i21 < i8) {
                ConstraintWidget constraintWidget2 = constraintWidgetArr[i21];
                int widgetHeight = getWidgetHeight(constraintWidget2, i10);
                if (constraintWidget2.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i11++;
                }
                int i22 = i11;
                boolean z3 = (i20 == i10 || (this.mVerticalGap + i20) + widgetHeight > i10) && widgetsList.biggest != null;
                if (!z3 && i21 > 0 && (i12 = this.mMaxElementsWrap) > 0 && i12 < 0) {
                    z3 = true;
                }
                if (z3) {
                    widgetsList = new WidgetsList(i9, this.mLeft, this.mTop, this.mRight, this.mBottom, i10);
                    widgetsList.setStartIndex(i21);
                    this.mChainList.add(widgetsList);
                } else {
                    if (i21 > 0) {
                        i20 = this.mVerticalGap + widgetHeight + i20;
                    }
                    widgetsList.add(constraintWidget2);
                    i21++;
                    i11 = i22;
                }
                i20 = widgetHeight;
                widgetsList.add(constraintWidget2);
                i21++;
                i11 = i22;
            }
        }
        int size = this.mChainList.size();
        ConstraintAnchor constraintAnchor3 = this.mLeft;
        ConstraintAnchor constraintAnchor4 = this.mTop;
        ConstraintAnchor constraintAnchor5 = this.mRight;
        ConstraintAnchor constraintAnchor6 = this.mBottom;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight2 = getPaddingRight();
        int paddingBottom2 = getPaddingBottom();
        ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        boolean z5 = horizontalDimensionBehaviour == dimensionBehaviour || getVerticalDimensionBehaviour() == dimensionBehaviour;
        if (i11 > 0 && z5) {
            for (int i23 = 0; i23 < size; i23++) {
                WidgetsList widgetsList2 = this.mChainList.get(i23);
                if (i9 == 0) {
                    widgetsList2.measureMatchConstraints(i10 - widgetsList2.getWidth());
                } else {
                    widgetsList2.measureMatchConstraints(i10 - widgetsList2.getHeight());
                }
            }
        }
        int i24 = paddingTop;
        int i25 = paddingRight2;
        int height = 0;
        int width = 0;
        int i26 = 0;
        int i27 = paddingLeft;
        ConstraintAnchor constraintAnchor7 = constraintAnchor4;
        ConstraintAnchor constraintAnchor8 = constraintAnchor3;
        int i28 = paddingBottom2;
        while (i26 < size) {
            WidgetsList widgetsList3 = this.mChainList.get(i26);
            if (i9 == 0) {
                if (i26 < size - 1) {
                    constraintAnchor2 = this.mChainList.get(i26 + 1).biggest.mTop;
                    paddingBottom = 0;
                } else {
                    constraintAnchor2 = this.mBottom;
                    paddingBottom = getPaddingBottom();
                }
                ConstraintAnchor constraintAnchor9 = widgetsList3.biggest.mBottom;
                ConstraintAnchor constraintAnchor10 = constraintAnchor8;
                ConstraintAnchor constraintAnchor11 = constraintAnchor8;
                int i29 = height;
                ConstraintAnchor constraintAnchor12 = constraintAnchor7;
                int i30 = width;
                ConstraintAnchor constraintAnchor13 = constraintAnchor5;
                ConstraintAnchor constraintAnchor14 = constraintAnchor5;
                i13 = i26;
                widgetsList3.setup(i9, constraintAnchor10, constraintAnchor12, constraintAnchor13, constraintAnchor2, i27, i24, i25, paddingBottom, i10);
                int iMax = Math.max(i30, widgetsList3.getWidth());
                height = i29 + widgetsList3.getHeight();
                if (i13 > 0) {
                    height += this.mVerticalGap;
                }
                constraintAnchor8 = constraintAnchor11;
                width = iMax;
                i24 = 0;
                constraintAnchor7 = constraintAnchor9;
                constraintAnchor = constraintAnchor14;
                int i31 = paddingBottom;
                constraintAnchor6 = constraintAnchor2;
                i28 = i31;
            } else {
                ConstraintAnchor constraintAnchor15 = constraintAnchor8;
                int i32 = height;
                int i33 = width;
                i13 = i26;
                if (i13 < size - 1) {
                    constraintAnchor = this.mChainList.get(i13 + 1).biggest.mLeft;
                    paddingRight = 0;
                } else {
                    constraintAnchor = this.mRight;
                    paddingRight = getPaddingRight();
                }
                ConstraintAnchor constraintAnchor16 = widgetsList3.biggest.mRight;
                widgetsList3.setup(i9, constraintAnchor15, constraintAnchor7, constraintAnchor, constraintAnchor6, i27, i24, paddingRight, i28, i10);
                width = i33 + widgetsList3.getWidth();
                int iMax2 = Math.max(i32, widgetsList3.getHeight());
                if (i13 > 0) {
                    width += this.mHorizontalGap;
                }
                height = iMax2;
                i27 = 0;
                i25 = paddingRight;
                constraintAnchor8 = constraintAnchor16;
            }
            i26 = i13 + 1;
            constraintAnchor5 = constraintAnchor;
        }
        iArr[0] = width;
        iArr[1] = height;
    }

    private void measureNoWrap(ConstraintWidget[] constraintWidgetArr, int i8, int i9, int i10, int[] iArr) {
        WidgetsList widgetsList;
        if (i8 == 0) {
            return;
        }
        if (this.mChainList.size() == 0) {
            widgetsList = new WidgetsList(i9, this.mLeft, this.mTop, this.mRight, this.mBottom, i10);
            this.mChainList.add(widgetsList);
        } else {
            WidgetsList widgetsList2 = this.mChainList.get(0);
            widgetsList2.clear();
            widgetsList = widgetsList2;
            widgetsList.setup(i9, this.mLeft, this.mTop, this.mRight, this.mBottom, getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom(), i10);
        }
        for (int i11 = 0; i11 < i8; i11++) {
            widgetsList.add(constraintWidgetArr[i11]);
        }
        iArr[0] = widgetsList.getWidth();
        iArr[1] = widgetsList.getHeight();
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void addToSolver(LinearSystem linearSystem, boolean z2) {
        super.addToSolver(linearSystem, z2);
        boolean z3 = getParent() != null && ((ConstraintWidgetContainer) getParent()).isRtl();
        int i8 = this.mWrapMode;
        if (i8 != 0) {
            if (i8 == 1) {
                int size = this.mChainList.size();
                int i9 = 0;
                while (i9 < size) {
                    this.mChainList.get(i9).createConstraints(z3, i9, i9 == size + (-1));
                    i9++;
                }
            } else if (i8 == 2) {
                createAlignedConstraints(z3);
            } else if (i8 == 3) {
                int size2 = this.mChainList.size();
                int i10 = 0;
                while (i10 < size2) {
                    this.mChainList.get(i10).createConstraints(z3, i10, i10 == size2 + (-1));
                    i10++;
                }
            }
        } else if (this.mChainList.size() > 0) {
            this.mChainList.get(0).createConstraints(z3, 0, true);
        }
        needsCallbackFromSolver(false);
    }

    @Override // androidx.constraintlayout.core.widgets.HelperWidget, androidx.constraintlayout.core.widgets.ConstraintWidget
    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> map) {
        super.copy(constraintWidget, map);
        Flow flow = (Flow) constraintWidget;
        this.mHorizontalStyle = flow.mHorizontalStyle;
        this.mVerticalStyle = flow.mVerticalStyle;
        this.mFirstHorizontalStyle = flow.mFirstHorizontalStyle;
        this.mFirstVerticalStyle = flow.mFirstVerticalStyle;
        this.mLastHorizontalStyle = flow.mLastHorizontalStyle;
        this.mLastVerticalStyle = flow.mLastVerticalStyle;
        this.mHorizontalBias = flow.mHorizontalBias;
        this.mVerticalBias = flow.mVerticalBias;
        this.mFirstHorizontalBias = flow.mFirstHorizontalBias;
        this.mFirstVerticalBias = flow.mFirstVerticalBias;
        this.mLastHorizontalBias = flow.mLastHorizontalBias;
        this.mLastVerticalBias = flow.mLastVerticalBias;
        this.mHorizontalGap = flow.mHorizontalGap;
        this.mVerticalGap = flow.mVerticalGap;
        this.mHorizontalAlign = flow.mHorizontalAlign;
        this.mVerticalAlign = flow.mVerticalAlign;
        this.mWrapMode = flow.mWrapMode;
        this.mMaxElementsWrap = flow.mMaxElementsWrap;
        this.mOrientation = flow.mOrientation;
    }

    public float getMaxElementsWrap() {
        return this.mMaxElementsWrap;
    }

    @Override // androidx.constraintlayout.core.widgets.VirtualLayout
    public void measure(int i8, int i9, int i10, int i11) {
        int i12;
        int i13;
        boolean z2;
        if (this.mWidgetsCount > 0 && !measureChildren()) {
            setMeasure(0, 0);
            needsCallbackFromSolver(false);
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int[] iArr = new int[2];
        int i14 = (i9 - paddingLeft) - paddingRight;
        int i15 = this.mOrientation;
        if (i15 == 1) {
            i14 = (i11 - paddingTop) - paddingBottom;
        }
        int i16 = i14;
        if (i15 == 0) {
            if (this.mHorizontalStyle == -1) {
                this.mHorizontalStyle = 0;
            }
            if (this.mVerticalStyle == -1) {
                this.mVerticalStyle = 0;
            }
        } else {
            if (this.mHorizontalStyle == -1) {
                this.mHorizontalStyle = 0;
            }
            if (this.mVerticalStyle == -1) {
                this.mVerticalStyle = 0;
            }
        }
        ConstraintWidget[] constraintWidgetArr = this.mWidgets;
        int i17 = 0;
        int i18 = 0;
        while (true) {
            i12 = this.mWidgetsCount;
            if (i17 >= i12) {
                break;
            }
            if (this.mWidgets[i17].getVisibility() == 8) {
                i18++;
            }
            i17++;
        }
        if (i18 > 0) {
            constraintWidgetArr = new ConstraintWidget[i12 - i18];
            int i19 = 0;
            for (int i20 = 0; i20 < this.mWidgetsCount; i20++) {
                ConstraintWidget constraintWidget = this.mWidgets[i20];
                if (constraintWidget.getVisibility() != 8) {
                    constraintWidgetArr[i19] = constraintWidget;
                    i19++;
                }
            }
            i13 = i19;
        } else {
            i13 = i12;
        }
        this.mDisplayedWidgets = constraintWidgetArr;
        this.mDisplayedWidgetsCount = i13;
        int i21 = this.mWrapMode;
        if (i21 == 0) {
            z2 = true;
            measureNoWrap(constraintWidgetArr, i13, this.mOrientation, i16, iArr);
        } else if (i21 == 1) {
            z2 = true;
            measureChainWrap(constraintWidgetArr, i13, this.mOrientation, i16, iArr);
        } else if (i21 == 2) {
            z2 = true;
            measureAligned(constraintWidgetArr, i13, this.mOrientation, i16, iArr);
        } else if (i21 != 3) {
            z2 = true;
        } else {
            z2 = true;
            measureChainWrap_new(constraintWidgetArr, i13, this.mOrientation, i16, iArr);
        }
        int iMin = iArr[0] + paddingLeft + paddingRight;
        int iMin2 = iArr[z2 ? 1 : 0] + paddingTop + paddingBottom;
        if (i8 == 1073741824) {
            iMin = i9;
        } else if (i8 == Integer.MIN_VALUE) {
            iMin = Math.min(iMin, i9);
        } else if (i8 != 0) {
            iMin = 0;
        }
        if (i10 == 1073741824) {
            iMin2 = i11;
        } else if (i10 == Integer.MIN_VALUE) {
            iMin2 = Math.min(iMin2, i11);
        } else if (i10 != 0) {
            iMin2 = 0;
        }
        setMeasure(iMin, iMin2);
        setWidth(iMin);
        setHeight(iMin2);
        if (this.mWidgetsCount <= 0) {
            z2 = false;
        }
        needsCallbackFromSolver(z2);
    }

    public void setFirstHorizontalBias(float f) {
        this.mFirstHorizontalBias = f;
    }

    public void setFirstHorizontalStyle(int i8) {
        this.mFirstHorizontalStyle = i8;
    }

    public void setFirstVerticalBias(float f) {
        this.mFirstVerticalBias = f;
    }

    public void setFirstVerticalStyle(int i8) {
        this.mFirstVerticalStyle = i8;
    }

    public void setHorizontalAlign(int i8) {
        this.mHorizontalAlign = i8;
    }

    public void setHorizontalBias(float f) {
        this.mHorizontalBias = f;
    }

    public void setHorizontalGap(int i8) {
        this.mHorizontalGap = i8;
    }

    public void setHorizontalStyle(int i8) {
        this.mHorizontalStyle = i8;
    }

    public void setLastHorizontalBias(float f) {
        this.mLastHorizontalBias = f;
    }

    public void setLastHorizontalStyle(int i8) {
        this.mLastHorizontalStyle = i8;
    }

    public void setLastVerticalBias(float f) {
        this.mLastVerticalBias = f;
    }

    public void setLastVerticalStyle(int i8) {
        this.mLastVerticalStyle = i8;
    }

    public void setMaxElementsWrap(int i8) {
        this.mMaxElementsWrap = i8;
    }

    public void setOrientation(int i8) {
        this.mOrientation = i8;
    }

    public void setVerticalAlign(int i8) {
        this.mVerticalAlign = i8;
    }

    public void setVerticalBias(float f) {
        this.mVerticalBias = f;
    }

    public void setVerticalGap(int i8) {
        this.mVerticalGap = i8;
    }

    public void setVerticalStyle(int i8) {
        this.mVerticalStyle = i8;
    }

    public void setWrapMode(int i8) {
        this.mWrapMode = i8;
    }
}
