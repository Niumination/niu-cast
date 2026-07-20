package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inspector.PropertyMapper;
import android.view.inspector.PropertyReader;
import android.widget.LinearLayout;
import androidx.annotation.GravityInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.view.GravityCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.transsion.iotcardsdk.bean.DeviceType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashSet;
import java.util.Set;
import java.util.function.IntFunction;

/* JADX INFO: loaded from: classes.dex */
public class LinearLayoutCompat extends ViewGroup {
    private static final String ACCESSIBILITY_CLASS_NAME = "androidx.appcompat.widget.LinearLayoutCompat";
    public static final int HORIZONTAL = 0;
    private static final int INDEX_BOTTOM = 2;
    private static final int INDEX_CENTER_VERTICAL = 0;
    private static final int INDEX_FILL = 3;
    private static final int INDEX_TOP = 1;
    public static final int SHOW_DIVIDER_BEGINNING = 1;
    public static final int SHOW_DIVIDER_END = 4;
    public static final int SHOW_DIVIDER_MIDDLE = 2;
    public static final int SHOW_DIVIDER_NONE = 0;
    public static final int VERTICAL = 1;
    private static final int VERTICAL_GRAVITY_COUNT = 4;
    private boolean mBaselineAligned;
    private int mBaselineAlignedChildIndex;
    private int mBaselineChildTop;
    private Drawable mDivider;
    private int mDividerHeight;
    private int mDividerPadding;
    private int mDividerWidth;
    private int mGravity;
    private int[] mMaxAscent;
    private int[] mMaxDescent;
    private int mOrientation;
    private int mShowDividers;
    private int mTotalLength;
    private boolean mUseLargestChild;
    private float mWeightSum;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface DividerMode {
    }

    @RequiresApi(29)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final class InspectionCompanion implements android.view.inspector.InspectionCompanion<LinearLayoutCompat> {
        private int mBaselineAlignedChildIndexId;
        private int mBaselineAlignedId;
        private int mDividerId;
        private int mDividerPaddingId;
        private int mGravityId;
        private int mMeasureWithLargestChildId;
        private int mOrientationId;
        private boolean mPropertiesMapped = false;
        private int mShowDividersId;
        private int mWeightSumId;

        @Override // android.view.inspector.InspectionCompanion
        public void mapProperties(@NonNull PropertyMapper propertyMapper) {
            this.mBaselineAlignedId = propertyMapper.mapBoolean("baselineAligned", R.attr.baselineAligned);
            this.mBaselineAlignedChildIndexId = propertyMapper.mapInt("baselineAlignedChildIndex", R.attr.baselineAlignedChildIndex);
            this.mGravityId = propertyMapper.mapGravity("gravity", R.attr.gravity);
            this.mOrientationId = propertyMapper.mapIntEnum("orientation", R.attr.orientation, new IntFunction<String>() { // from class: androidx.appcompat.widget.LinearLayoutCompat.InspectionCompanion.1
                @Override // java.util.function.IntFunction
                public String apply(int i8) {
                    if (i8 != 0) {
                        return i8 != 1 ? String.valueOf(i8) : "vertical";
                    }
                    return "horizontal";
                }
            });
            this.mWeightSumId = propertyMapper.mapFloat("weightSum", R.attr.weightSum);
            this.mDividerId = propertyMapper.mapObject("divider", androidx.appcompat.R.attr.divider);
            this.mDividerPaddingId = propertyMapper.mapInt("dividerPadding", androidx.appcompat.R.attr.dividerPadding);
            this.mMeasureWithLargestChildId = propertyMapper.mapBoolean("measureWithLargestChild", androidx.appcompat.R.attr.measureWithLargestChild);
            this.mShowDividersId = propertyMapper.mapIntFlag("showDividers", androidx.appcompat.R.attr.showDividers, new IntFunction<Set<String>>() { // from class: androidx.appcompat.widget.LinearLayoutCompat.InspectionCompanion.2
                @Override // java.util.function.IntFunction
                public Set<String> apply(int i8) {
                    HashSet hashSet = new HashSet();
                    if (i8 == 0) {
                        hashSet.add("none");
                    }
                    if (i8 == 1) {
                        hashSet.add("beginning");
                    }
                    if (i8 == 2) {
                        hashSet.add("middle");
                    }
                    if (i8 == 4) {
                        hashSet.add("end");
                    }
                    return hashSet;
                }
            });
            this.mPropertiesMapped = true;
        }

        @Override // android.view.inspector.InspectionCompanion
        public void readProperties(@NonNull LinearLayoutCompat linearLayoutCompat, @NonNull PropertyReader propertyReader) {
            if (!this.mPropertiesMapped) {
                throw new android.view.inspector.InspectionCompanion.UninitializedPropertyMapException();
            }
            propertyReader.readBoolean(this.mBaselineAlignedId, linearLayoutCompat.isBaselineAligned());
            propertyReader.readInt(this.mBaselineAlignedChildIndexId, linearLayoutCompat.getBaselineAlignedChildIndex());
            propertyReader.readGravity(this.mGravityId, linearLayoutCompat.getGravity());
            propertyReader.readIntEnum(this.mOrientationId, linearLayoutCompat.getOrientation());
            propertyReader.readFloat(this.mWeightSumId, linearLayoutCompat.getWeightSum());
            propertyReader.readObject(this.mDividerId, linearLayoutCompat.getDividerDrawable());
            propertyReader.readInt(this.mDividerPaddingId, linearLayoutCompat.getDividerPadding());
            propertyReader.readBoolean(this.mMeasureWithLargestChildId, linearLayoutCompat.isMeasureWithLargestChildEnabled());
            propertyReader.readIntFlag(this.mShowDividersId, linearLayoutCompat.getShowDividers());
        }
    }

    public static class LayoutParams extends LinearLayout.LayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i8, int i9) {
            super(i8, i9);
        }

        public LayoutParams(int i8, int i9, float f) {
            super(i8, i9, f);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface OrientationMode {
    }

    public LinearLayoutCompat(@NonNull Context context) {
        this(context, null);
    }

    private void forceUniformHeight(int i8, int i9) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), BasicMeasure.EXACTLY);
        for (int i10 = 0; i10 < i8; i10++) {
            View virtualChildAt = getVirtualChildAt(i10);
            if (virtualChildAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (((LinearLayout.LayoutParams) layoutParams).height == -1) {
                    int i11 = ((LinearLayout.LayoutParams) layoutParams).width;
                    ((LinearLayout.LayoutParams) layoutParams).width = virtualChildAt.getMeasuredWidth();
                    measureChildWithMargins(virtualChildAt, i9, 0, iMakeMeasureSpec, 0);
                    ((LinearLayout.LayoutParams) layoutParams).width = i11;
                }
            }
        }
    }

    private void forceUniformWidth(int i8, int i9) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), BasicMeasure.EXACTLY);
        for (int i10 = 0; i10 < i8; i10++) {
            View virtualChildAt = getVirtualChildAt(i10);
            if (virtualChildAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (((LinearLayout.LayoutParams) layoutParams).width == -1) {
                    int i11 = ((LinearLayout.LayoutParams) layoutParams).height;
                    ((LinearLayout.LayoutParams) layoutParams).height = virtualChildAt.getMeasuredHeight();
                    measureChildWithMargins(virtualChildAt, iMakeMeasureSpec, 0, i9, 0);
                    ((LinearLayout.LayoutParams) layoutParams).height = i11;
                }
            }
        }
    }

    private void setChildFrame(View view, int i8, int i9, int i10, int i11) {
        view.layout(i8, i9, i10 + i8, i11 + i9);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void drawDividersHorizontal(Canvas canvas) {
        int right;
        int left;
        int i8;
        int virtualChildCount = getVirtualChildCount();
        boolean zIsLayoutRtl = ViewUtils.isLayoutRtl(this);
        for (int i9 = 0; i9 < virtualChildCount; i9++) {
            View virtualChildAt = getVirtualChildAt(i9);
            if (virtualChildAt != null && virtualChildAt.getVisibility() != 8 && hasDividerBeforeChildAt(i9)) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                drawVerticalDivider(canvas, zIsLayoutRtl ? virtualChildAt.getRight() + ((LinearLayout.LayoutParams) layoutParams).rightMargin : (virtualChildAt.getLeft() - ((LinearLayout.LayoutParams) layoutParams).leftMargin) - this.mDividerWidth);
            }
        }
        if (hasDividerBeforeChildAt(virtualChildCount)) {
            View virtualChildAt2 = getVirtualChildAt(virtualChildCount - 1);
            if (virtualChildAt2 != null) {
                LayoutParams layoutParams2 = (LayoutParams) virtualChildAt2.getLayoutParams();
                if (zIsLayoutRtl) {
                    left = virtualChildAt2.getLeft() - ((LinearLayout.LayoutParams) layoutParams2).leftMargin;
                    i8 = this.mDividerWidth;
                    right = left - i8;
                } else {
                    right = virtualChildAt2.getRight() + ((LinearLayout.LayoutParams) layoutParams2).rightMargin;
                }
            } else if (zIsLayoutRtl) {
                right = getPaddingLeft();
            } else {
                left = getWidth() - getPaddingRight();
                i8 = this.mDividerWidth;
                right = left - i8;
            }
            drawVerticalDivider(canvas, right);
        }
    }

    public void drawDividersVertical(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        for (int i8 = 0; i8 < virtualChildCount; i8++) {
            View virtualChildAt = getVirtualChildAt(i8);
            if (virtualChildAt != null && virtualChildAt.getVisibility() != 8 && hasDividerBeforeChildAt(i8)) {
                drawHorizontalDivider(canvas, (virtualChildAt.getTop() - ((LinearLayout.LayoutParams) ((LayoutParams) virtualChildAt.getLayoutParams())).topMargin) - this.mDividerHeight);
            }
        }
        if (hasDividerBeforeChildAt(virtualChildCount)) {
            View virtualChildAt2 = getVirtualChildAt(virtualChildCount - 1);
            drawHorizontalDivider(canvas, virtualChildAt2 == null ? (getHeight() - getPaddingBottom()) - this.mDividerHeight : virtualChildAt2.getBottom() + ((LinearLayout.LayoutParams) ((LayoutParams) virtualChildAt2.getLayoutParams())).bottomMargin);
        }
    }

    public void drawHorizontalDivider(Canvas canvas, int i8) {
        this.mDivider.setBounds(getPaddingLeft() + this.mDividerPadding, i8, (getWidth() - getPaddingRight()) - this.mDividerPadding, this.mDividerHeight + i8);
        this.mDivider.draw(canvas);
    }

    public void drawVerticalDivider(Canvas canvas, int i8) {
        this.mDivider.setBounds(i8, getPaddingTop() + this.mDividerPadding, this.mDividerWidth + i8, (getHeight() - getPaddingBottom()) - this.mDividerPadding);
        this.mDivider.draw(canvas);
    }

    @Override // android.view.View
    public int getBaseline() {
        int i8;
        if (this.mBaselineAlignedChildIndex < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i9 = this.mBaselineAlignedChildIndex;
        if (childCount <= i9) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(i9);
        int baseline = childAt.getBaseline();
        if (baseline == -1) {
            if (this.mBaselineAlignedChildIndex == 0) {
                return -1;
            }
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
        int iD = this.mBaselineChildTop;
        if (this.mOrientation == 1 && (i8 = this.mGravity & DeviceType.INFRARED_HEATER) != 48) {
            if (i8 == 16) {
                iD = a1.a.d(((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom(), this.mTotalLength, 2, iD);
            } else if (i8 == 80) {
                iD = ((getBottom() - getTop()) - getPaddingBottom()) - this.mTotalLength;
            }
        }
        return iD + ((LinearLayout.LayoutParams) ((LayoutParams) childAt.getLayoutParams())).topMargin + baseline;
    }

    public int getBaselineAlignedChildIndex() {
        return this.mBaselineAlignedChildIndex;
    }

    public int getChildrenSkipCount(View view, int i8) {
        return 0;
    }

    public Drawable getDividerDrawable() {
        return this.mDivider;
    }

    public int getDividerPadding() {
        return this.mDividerPadding;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getDividerWidth() {
        return this.mDividerWidth;
    }

    @GravityInt
    public int getGravity() {
        return this.mGravity;
    }

    public int getLocationOffset(View view) {
        return 0;
    }

    public int getNextLocationOffset(View view) {
        return 0;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public int getShowDividers() {
        return this.mShowDividers;
    }

    public View getVirtualChildAt(int i8) {
        return getChildAt(i8);
    }

    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.mWeightSum;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean hasDividerBeforeChildAt(int i8) {
        if (i8 == 0) {
            return (this.mShowDividers & 1) != 0;
        }
        if (i8 == getChildCount()) {
            return (this.mShowDividers & 4) != 0;
        }
        if ((this.mShowDividers & 2) == 0) {
            return false;
        }
        for (int i9 = i8 - 1; i9 >= 0; i9--) {
            if (getChildAt(i9).getVisibility() != 8) {
                return true;
            }
        }
        return false;
    }

    public boolean isBaselineAligned() {
        return this.mBaselineAligned;
    }

    public boolean isMeasureWithLargestChildEnabled() {
        return this.mUseLargestChild;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:33:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:35:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:37:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:39:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:41:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:42:0x00df  */
    /* JADX WARN: Code duplicated, block: B:44:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:45:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:48:0x0104  */
    public void layoutHorizontal(int i8, int i9, int i10, int i11) {
        int iD;
        int i12;
        int i13;
        boolean z2;
        int baseline;
        int i14;
        int i15;
        int iD2;
        boolean zIsLayoutRtl = ViewUtils.isLayoutRtl(this);
        int paddingTop = getPaddingTop();
        int i16 = i11 - i9;
        int paddingBottom = i16 - getPaddingBottom();
        int paddingBottom2 = (i16 - paddingTop) - getPaddingBottom();
        int virtualChildCount = getVirtualChildCount();
        int i17 = this.mGravity;
        int i18 = i17 & DeviceType.INFRARED_HEATER;
        boolean z3 = this.mBaselineAligned;
        int[] iArr = this.mMaxAscent;
        int[] iArr2 = this.mMaxDescent;
        int absoluteGravity = GravityCompat.getAbsoluteGravity(8388615 & i17, getLayoutDirection());
        boolean z5 = true;
        if (absoluteGravity != 1) {
            iD = absoluteGravity != 5 ? getPaddingLeft() : ((getPaddingLeft() + i10) - i8) - this.mTotalLength;
        } else {
            iD = a1.a.d(i10 - i8, this.mTotalLength, 2, getPaddingLeft());
        }
        if (zIsLayoutRtl) {
            i12 = virtualChildCount - 1;
            i13 = -1;
        } else {
            i12 = 0;
            i13 = 1;
        }
        int childrenSkipCount = 0;
        while (childrenSkipCount < virtualChildCount) {
            int i19 = (i13 * childrenSkipCount) + i12;
            View virtualChildAt = getVirtualChildAt(i19);
            if (virtualChildAt == null) {
                iD = measureNullChild(i19) + iD;
                z2 = z5;
            } else {
                if (virtualChildAt.getVisibility() != 8) {
                    int measuredWidth = virtualChildAt.getMeasuredWidth();
                    int measuredHeight = virtualChildAt.getMeasuredHeight();
                    LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                    int i20 = childrenSkipCount;
                    if (z3) {
                        virtualChildCount = virtualChildCount;
                        baseline = ((LinearLayout.LayoutParams) layoutParams).height != -1 ? virtualChildAt.getBaseline() : -1;
                        i14 = ((LinearLayout.LayoutParams) layoutParams).gravity;
                        if (i14 < 0) {
                            i14 = i18;
                        }
                        i15 = i14 & DeviceType.INFRARED_HEATER;
                        i18 = i18;
                        if (i15 != 16) {
                            if (i15 != 48) {
                                iD2 = ((LinearLayout.LayoutParams) layoutParams).topMargin + paddingTop;
                                if (baseline != -1) {
                                    z2 = true;
                                    iD2 = (iArr[1] - baseline) + iD2;
                                }
                            } else if (i15 != 80) {
                                iD2 = paddingTop;
                            } else {
                                iD2 = (paddingBottom - measuredHeight) - ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                                if (baseline != -1) {
                                    iD2 -= iArr2[2] - (virtualChildAt.getMeasuredHeight() - baseline);
                                }
                            }
                            z2 = true;
                        } else {
                            z2 = true;
                            iD2 = (a1.a.d(paddingBottom2, measuredHeight, 2, paddingTop) + ((LinearLayout.LayoutParams) layoutParams).topMargin) - ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                        }
                        if (hasDividerBeforeChildAt(i19)) {
                            iD += this.mDividerWidth;
                        }
                        int i21 = ((LinearLayout.LayoutParams) layoutParams).leftMargin + iD;
                        paddingTop = paddingTop;
                        setChildFrame(virtualChildAt, getLocationOffset(virtualChildAt) + i21, iD2, measuredWidth, measuredHeight);
                        iD = getNextLocationOffset(virtualChildAt) + measuredWidth + ((LinearLayout.LayoutParams) layoutParams).rightMargin + i21;
                        childrenSkipCount = getChildrenSkipCount(virtualChildAt, i19) + i20;
                    } else {
                        virtualChildCount = virtualChildCount;
                    }
                    i14 = ((LinearLayout.LayoutParams) layoutParams).gravity;
                    if (i14 < 0) {
                        i14 = i18;
                    }
                    i15 = i14 & DeviceType.INFRARED_HEATER;
                    i18 = i18;
                    if (i15 != 16) {
                        if (i15 != 48) {
                            iD2 = ((LinearLayout.LayoutParams) layoutParams).topMargin + paddingTop;
                            if (baseline != -1) {
                                z2 = true;
                                iD2 = (iArr[1] - baseline) + iD2;
                            }
                        } else if (i15 != 80) {
                            iD2 = paddingTop;
                        } else {
                            iD2 = (paddingBottom - measuredHeight) - ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                            if (baseline != -1) {
                                iD2 -= iArr2[2] - (virtualChildAt.getMeasuredHeight() - baseline);
                            }
                        }
                        z2 = true;
                    } else {
                        z2 = true;
                        iD2 = (a1.a.d(paddingBottom2, measuredHeight, 2, paddingTop) + ((LinearLayout.LayoutParams) layoutParams).topMargin) - ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                    }
                    if (hasDividerBeforeChildAt(i19)) {
                        iD += this.mDividerWidth;
                    }
                    int i22 = ((LinearLayout.LayoutParams) layoutParams).leftMargin + iD;
                    paddingTop = paddingTop;
                    setChildFrame(virtualChildAt, getLocationOffset(virtualChildAt) + i22, iD2, measuredWidth, measuredHeight);
                    iD = getNextLocationOffset(virtualChildAt) + measuredWidth + ((LinearLayout.LayoutParams) layoutParams).rightMargin + i22;
                    childrenSkipCount = getChildrenSkipCount(virtualChildAt, i19) + i20;
                } else {
                    z2 = true;
                }
                childrenSkipCount++;
                virtualChildCount = virtualChildCount;
                i18 = i18;
                z5 = z2;
                paddingTop = paddingTop;
            }
            childrenSkipCount++;
            virtualChildCount = virtualChildCount;
            i18 = i18;
            z5 = z2;
            paddingTop = paddingTop;
        }
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00a1  */
    public void layoutVertical(int i8, int i9, int i10, int i11) {
        int iD;
        int iD2;
        int i12;
        int i13;
        int paddingLeft = getPaddingLeft();
        int i14 = i10 - i8;
        int paddingRight = i14 - getPaddingRight();
        int paddingRight2 = (i14 - paddingLeft) - getPaddingRight();
        int virtualChildCount = getVirtualChildCount();
        int i15 = this.mGravity;
        int i16 = i15 & DeviceType.INFRARED_HEATER;
        int i17 = i15 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        int i18 = 2;
        if (i16 != 16) {
            iD = i16 != 80 ? getPaddingTop() : ((getPaddingTop() + i11) - i9) - this.mTotalLength;
        } else {
            iD = a1.a.d(i11 - i9, this.mTotalLength, 2, getPaddingTop());
        }
        int childrenSkipCount = 0;
        while (childrenSkipCount < virtualChildCount) {
            View virtualChildAt = getVirtualChildAt(childrenSkipCount);
            if (virtualChildAt == null) {
                iD = measureNullChild(childrenSkipCount) + iD;
            } else if (virtualChildAt.getVisibility() != 8) {
                int measuredWidth = virtualChildAt.getMeasuredWidth();
                int measuredHeight = virtualChildAt.getMeasuredHeight();
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                int i19 = ((LinearLayout.LayoutParams) layoutParams).gravity;
                if (i19 < 0) {
                    i19 = i17;
                }
                int absoluteGravity = GravityCompat.getAbsoluteGravity(i19, getLayoutDirection()) & 7;
                if (absoluteGravity != 1) {
                    if (absoluteGravity != 5) {
                        i13 = ((LinearLayout.LayoutParams) layoutParams).leftMargin + paddingLeft;
                    } else {
                        iD2 = paddingRight - measuredWidth;
                        i12 = ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                    }
                    int i20 = i13;
                    if (hasDividerBeforeChildAt(childrenSkipCount)) {
                        iD += this.mDividerHeight;
                    }
                    int i21 = iD + ((LinearLayout.LayoutParams) layoutParams).topMargin;
                    setChildFrame(virtualChildAt, i20, getLocationOffset(virtualChildAt) + i21, measuredWidth, measuredHeight);
                    iD = getNextLocationOffset(virtualChildAt) + measuredHeight + ((LinearLayout.LayoutParams) layoutParams).bottomMargin + i21;
                    childrenSkipCount += getChildrenSkipCount(virtualChildAt, childrenSkipCount);
                } else {
                    iD2 = a1.a.d(paddingRight2, measuredWidth, i18, paddingLeft) + ((LinearLayout.LayoutParams) layoutParams).leftMargin;
                    i12 = ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                }
                i13 = iD2 - i12;
                int i22 = i13;
                if (hasDividerBeforeChildAt(childrenSkipCount)) {
                    iD += this.mDividerHeight;
                }
                int i23 = iD + ((LinearLayout.LayoutParams) layoutParams).topMargin;
                setChildFrame(virtualChildAt, i22, getLocationOffset(virtualChildAt) + i23, measuredWidth, measuredHeight);
                iD = getNextLocationOffset(virtualChildAt) + measuredHeight + ((LinearLayout.LayoutParams) layoutParams).bottomMargin + i23;
                childrenSkipCount += getChildrenSkipCount(virtualChildAt, childrenSkipCount);
            }
            childrenSkipCount++;
            i18 = 2;
        }
    }

    public void measureChildBeforeLayout(View view, int i8, int i9, int i10, int i11, int i12) {
        measureChildWithMargins(view, i9, i10, i11, i12);
    }

    /* JADX WARN: Code duplicated, block: B:200:0x045c  */
    /* JADX WARN: Code duplicated, block: B:60:0x0175  */
    /* JADX WARN: Code duplicated, block: B:67:0x0197  */
    /* JADX WARN: Code duplicated, block: B:74:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:77:0x01cb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:79:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:82:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:85:0x01e0  */
    public void measureHorizontal(int i8, int i9) {
        int[] iArr;
        int iCombineMeasuredStates;
        int i10;
        int iMax;
        int i11;
        int i12;
        int baseline;
        int i13;
        int i14;
        byte b9;
        int i15;
        int i16;
        boolean z2;
        boolean z3;
        View view;
        int i17;
        boolean z5;
        int i18;
        int measuredHeight;
        int childrenSkipCount;
        int baseline2;
        int i19;
        this.mTotalLength = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i8);
        int mode2 = View.MeasureSpec.getMode(i9);
        if (this.mMaxAscent == null || this.mMaxDescent == null) {
            this.mMaxAscent = new int[4];
            this.mMaxDescent = new int[4];
        }
        int[] iArr2 = this.mMaxAscent;
        int[] iArr3 = this.mMaxDescent;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        iArr3[3] = -1;
        iArr3[2] = -1;
        iArr3[1] = -1;
        iArr3[0] = -1;
        boolean z10 = this.mBaselineAligned;
        boolean z11 = this.mUseLargestChild;
        int i20 = BasicMeasure.EXACTLY;
        boolean z12 = mode == 1073741824;
        int childrenSkipCount2 = 0;
        int iMax2 = 0;
        int iMax3 = 0;
        int iMax4 = 0;
        int iMax5 = 0;
        boolean z13 = false;
        int iCombineMeasuredStates2 = 0;
        boolean z14 = false;
        boolean z15 = true;
        float f = 0.0f;
        while (true) {
            iArr = iArr3;
            if (childrenSkipCount2 >= virtualChildCount) {
                break;
            }
            View virtualChildAt = getVirtualChildAt(childrenSkipCount2);
            if (virtualChildAt == null) {
                this.mTotalLength = measureNullChild(childrenSkipCount2) + this.mTotalLength;
            } else {
                if (virtualChildAt.getVisibility() == 8) {
                    childrenSkipCount2 += getChildrenSkipCount(virtualChildAt, childrenSkipCount2);
                } else {
                    if (hasDividerBeforeChildAt(childrenSkipCount2)) {
                        this.mTotalLength += this.mDividerWidth;
                    }
                    LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                    float f4 = ((LinearLayout.LayoutParams) layoutParams).weight;
                    float f10 = f + f4;
                    if (mode == i20 && ((LinearLayout.LayoutParams) layoutParams).width == 0 && f4 > 0.0f) {
                        if (z12) {
                            this.mTotalLength = ((LinearLayout.LayoutParams) layoutParams).leftMargin + ((LinearLayout.LayoutParams) layoutParams).rightMargin + this.mTotalLength;
                        } else {
                            int i21 = this.mTotalLength;
                            this.mTotalLength = Math.max(i21, ((LinearLayout.LayoutParams) layoutParams).leftMargin + i21 + ((LinearLayout.LayoutParams) layoutParams).rightMargin);
                        }
                        if (z10) {
                            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                            virtualChildAt.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                            i16 = childrenSkipCount2;
                            z2 = z11;
                            z3 = z10;
                            view = virtualChildAt;
                        } else {
                            i16 = childrenSkipCount2;
                            z2 = z11;
                            z3 = z10;
                            view = virtualChildAt;
                            z13 = true;
                            i17 = BasicMeasure.EXACTLY;
                        }
                        if (mode2 == i17 && ((LinearLayout.LayoutParams) layoutParams).height == -1) {
                            z5 = true;
                            z14 = true;
                        } else {
                            z5 = false;
                        }
                        i18 = ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                        measuredHeight = view.getMeasuredHeight() + i18;
                        iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, view.getMeasuredState());
                        if (z3 && (baseline2 = view.getBaseline()) != -1) {
                            i19 = ((LinearLayout.LayoutParams) layoutParams).gravity;
                            if (i19 < 0) {
                                i19 = this.mGravity;
                            }
                            int i22 = (((i19 & DeviceType.INFRARED_HEATER) >> 4) & (-2)) >> 1;
                            iArr2[i22] = Math.max(iArr2[i22], baseline2);
                            iArr[i22] = Math.max(iArr[i22], measuredHeight - baseline2);
                        }
                        iMax3 = Math.max(iMax3, measuredHeight);
                        if (z15 || ((LinearLayout.LayoutParams) layoutParams).height != -1) {
                            z15 = false;
                        } else {
                            z15 = true;
                        }
                        if (((LinearLayout.LayoutParams) layoutParams).weight > 0.0f) {
                            if (!z5) {
                                i18 = measuredHeight;
                            }
                            iMax5 = Math.max(iMax5, i18);
                        } else {
                            int i23 = iMax5;
                            if (!z5) {
                                i18 = measuredHeight;
                            }
                            iMax4 = Math.max(iMax4, i18);
                            iMax5 = i23;
                        }
                        int i24 = i16;
                        childrenSkipCount = getChildrenSkipCount(view, i24) + i24;
                        f = f10;
                    } else {
                        if (((LinearLayout.LayoutParams) layoutParams).width != 0 || f4 <= 0.0f) {
                            b9 = -2;
                            i15 = Integer.MIN_VALUE;
                        } else {
                            b9 = -2;
                            ((LinearLayout.LayoutParams) layoutParams).width = -2;
                            i15 = 0;
                        }
                        i16 = childrenSkipCount2;
                        int i25 = i15;
                        z2 = z11;
                        z3 = z10;
                        measureChildBeforeLayout(virtualChildAt, i16, i8, f10 == 0.0f ? this.mTotalLength : 0, i9, 0);
                        if (i25 != Integer.MIN_VALUE) {
                            ((LinearLayout.LayoutParams) layoutParams).width = i25;
                        }
                        int measuredWidth = virtualChildAt.getMeasuredWidth();
                        if (z12) {
                            view = virtualChildAt;
                            this.mTotalLength = getNextLocationOffset(view) + ((LinearLayout.LayoutParams) layoutParams).leftMargin + measuredWidth + ((LinearLayout.LayoutParams) layoutParams).rightMargin + this.mTotalLength;
                        } else {
                            view = virtualChildAt;
                            int i26 = this.mTotalLength;
                            this.mTotalLength = Math.max(i26, getNextLocationOffset(view) + i26 + measuredWidth + ((LinearLayout.LayoutParams) layoutParams).leftMargin + ((LinearLayout.LayoutParams) layoutParams).rightMargin);
                        }
                        if (z2) {
                            iMax2 = Math.max(measuredWidth, iMax2);
                        }
                    }
                    i17 = BasicMeasure.EXACTLY;
                    if (mode2 == i17) {
                        z5 = false;
                    } else {
                        z5 = false;
                    }
                    i18 = ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                    measuredHeight = view.getMeasuredHeight() + i18;
                    iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, view.getMeasuredState());
                    if (z3) {
                        i19 = ((LinearLayout.LayoutParams) layoutParams).gravity;
                        if (i19 < 0) {
                            i19 = this.mGravity;
                        }
                        int i27 = (((i19 & DeviceType.INFRARED_HEATER) >> 4) & (-2)) >> 1;
                        iArr2[i27] = Math.max(iArr2[i27], baseline2);
                        iArr[i27] = Math.max(iArr[i27], measuredHeight - baseline2);
                    }
                    iMax3 = Math.max(iMax3, measuredHeight);
                    if (z15) {
                        z15 = false;
                    } else {
                        z15 = false;
                    }
                    if (((LinearLayout.LayoutParams) layoutParams).weight > 0.0f) {
                        if (!z5) {
                            i18 = measuredHeight;
                        }
                        iMax5 = Math.max(iMax5, i18);
                    } else {
                        int i28 = iMax5;
                        if (!z5) {
                            i18 = measuredHeight;
                        }
                        iMax4 = Math.max(iMax4, i18);
                        iMax5 = i28;
                    }
                    int i29 = i16;
                    childrenSkipCount = getChildrenSkipCount(view, i29) + i29;
                    f = f10;
                }
                int i30 = childrenSkipCount + 1;
                iArr3 = iArr;
                z11 = z2;
                z10 = z3;
                i20 = i17;
                childrenSkipCount2 = i30;
            }
            z2 = z11;
            z3 = z10;
            int i31 = i20;
            childrenSkipCount = childrenSkipCount2;
            i17 = i31;
            int i32 = childrenSkipCount + 1;
            iArr3 = iArr;
            z11 = z2;
            z10 = z3;
            i20 = i17;
            childrenSkipCount2 = i32;
        }
        boolean z16 = z11;
        boolean z17 = z10;
        int i33 = iMax3;
        int i34 = iMax4;
        int i35 = iMax5;
        int i36 = iCombineMeasuredStates2;
        if (this.mTotalLength > 0 && hasDividerBeforeChildAt(virtualChildCount)) {
            this.mTotalLength += this.mDividerWidth;
        }
        int i37 = iArr2[1];
        int iMax6 = (i37 == -1 && iArr2[0] == -1 && iArr2[2] == -1 && iArr2[3] == -1) ? i33 : Math.max(i33, Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))) + Math.max(iArr2[3], Math.max(iArr2[0], Math.max(i37, iArr2[2]))));
        if (z16 && (mode == Integer.MIN_VALUE || mode == 0)) {
            this.mTotalLength = 0;
            int childrenSkipCount3 = 0;
            while (childrenSkipCount3 < virtualChildCount) {
                View virtualChildAt2 = getVirtualChildAt(childrenSkipCount3);
                if (virtualChildAt2 == null) {
                    this.mTotalLength = measureNullChild(childrenSkipCount3) + this.mTotalLength;
                } else if (virtualChildAt2.getVisibility() == 8) {
                    childrenSkipCount3 += getChildrenSkipCount(virtualChildAt2, childrenSkipCount3);
                } else {
                    LayoutParams layoutParams2 = (LayoutParams) virtualChildAt2.getLayoutParams();
                    if (z12) {
                        this.mTotalLength = getNextLocationOffset(virtualChildAt2) + ((LinearLayout.LayoutParams) layoutParams2).leftMargin + iMax2 + ((LinearLayout.LayoutParams) layoutParams2).rightMargin + this.mTotalLength;
                    } else {
                        int i38 = this.mTotalLength;
                        this.mTotalLength = Math.max(i38, getNextLocationOffset(virtualChildAt2) + i38 + iMax2 + ((LinearLayout.LayoutParams) layoutParams2).leftMargin + ((LinearLayout.LayoutParams) layoutParams2).rightMargin);
                    }
                    childrenSkipCount3++;
                    iMax6 = iMax6;
                }
                childrenSkipCount3++;
                iMax6 = iMax6;
            }
        }
        int iMax7 = iMax6;
        int paddingRight = getPaddingRight() + getPaddingLeft() + this.mTotalLength;
        this.mTotalLength = paddingRight;
        int iResolveSizeAndState = View.resolveSizeAndState(Math.max(paddingRight, getSuggestedMinimumWidth()), i8, 0);
        int i39 = (16777215 & iResolveSizeAndState) - this.mTotalLength;
        if (z13 || (i39 != 0 && f > 0.0f)) {
            float f11 = this.mWeightSum;
            if (f11 > 0.0f) {
                f = f11;
            }
            iArr2[3] = -1;
            iArr2[2] = -1;
            iArr2[1] = -1;
            iArr2[0] = -1;
            iArr[3] = -1;
            iArr[2] = -1;
            iArr[1] = -1;
            iArr[0] = -1;
            this.mTotalLength = 0;
            int i40 = i34;
            int iMax8 = -1;
            iCombineMeasuredStates = i36;
            int i41 = 0;
            while (i41 < virtualChildCount) {
                View virtualChildAt3 = getVirtualChildAt(i41);
                if (virtualChildAt3 == null || virtualChildAt3.getVisibility() == 8) {
                    i11 = i39;
                    virtualChildCount = virtualChildCount;
                } else {
                    LayoutParams layoutParams3 = (LayoutParams) virtualChildAt3.getLayoutParams();
                    float f12 = ((LinearLayout.LayoutParams) layoutParams3).weight;
                    if (f12 > 0.0f) {
                        int i42 = (int) ((i39 * f12) / f);
                        float f13 = f - f12;
                        int i43 = i39 - i42;
                        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i9, getPaddingBottom() + getPaddingTop() + ((LinearLayout.LayoutParams) layoutParams3).topMargin + ((LinearLayout.LayoutParams) layoutParams3).bottomMargin, ((LinearLayout.LayoutParams) layoutParams3).height);
                        if (((LinearLayout.LayoutParams) layoutParams3).width == 0) {
                            i14 = BasicMeasure.EXACTLY;
                            if (mode == 1073741824) {
                                if (i42 <= 0) {
                                    i42 = 0;
                                }
                                virtualChildAt3.measure(View.MeasureSpec.makeMeasureSpec(i42, BasicMeasure.EXACTLY), childMeasureSpec);
                            }
                            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, virtualChildAt3.getMeasuredState() & ViewCompat.MEASURED_STATE_MASK);
                            f = f13;
                            i11 = i43;
                        } else {
                            i14 = BasicMeasure.EXACTLY;
                        }
                        int measuredWidth2 = virtualChildAt3.getMeasuredWidth() + i42;
                        if (measuredWidth2 < 0) {
                            measuredWidth2 = 0;
                        }
                        virtualChildAt3.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth2, i14), childMeasureSpec);
                        iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, virtualChildAt3.getMeasuredState() & ViewCompat.MEASURED_STATE_MASK);
                        f = f13;
                        i11 = i43;
                    } else {
                        i11 = i39;
                    }
                    if (z12) {
                        this.mTotalLength = getNextLocationOffset(virtualChildAt3) + virtualChildAt3.getMeasuredWidth() + ((LinearLayout.LayoutParams) layoutParams3).leftMargin + ((LinearLayout.LayoutParams) layoutParams3).rightMargin + this.mTotalLength;
                    } else {
                        int i44 = this.mTotalLength;
                        this.mTotalLength = Math.max(i44, getNextLocationOffset(virtualChildAt3) + virtualChildAt3.getMeasuredWidth() + i44 + ((LinearLayout.LayoutParams) layoutParams3).leftMargin + ((LinearLayout.LayoutParams) layoutParams3).rightMargin);
                    }
                    boolean z18 = mode2 != 1073741824 && ((LinearLayout.LayoutParams) layoutParams3).height == -1;
                    int i45 = ((LinearLayout.LayoutParams) layoutParams3).topMargin + ((LinearLayout.LayoutParams) layoutParams3).bottomMargin;
                    int measuredHeight2 = virtualChildAt3.getMeasuredHeight() + i45;
                    iMax8 = Math.max(iMax8, measuredHeight2);
                    if (!z18) {
                        i45 = measuredHeight2;
                    }
                    int iMax9 = Math.max(i40, i45);
                    if (z15) {
                        i12 = -1;
                        boolean z19 = ((LinearLayout.LayoutParams) layoutParams3).height == -1;
                        if (z17 && (baseline = virtualChildAt3.getBaseline()) != i12) {
                            i13 = ((LinearLayout.LayoutParams) layoutParams3).gravity;
                            if (i13 < 0) {
                                i13 = this.mGravity;
                            }
                            int i46 = (((i13 & DeviceType.INFRARED_HEATER) >> 4) & (-2)) >> 1;
                            iArr2[i46] = Math.max(iArr2[i46], baseline);
                            iArr[i46] = Math.max(iArr[i46], measuredHeight2 - baseline);
                        }
                        z15 = z19;
                        i40 = iMax9;
                        f = f;
                    } else {
                        i12 = -1;
                    }
                    if (z17) {
                        i13 = ((LinearLayout.LayoutParams) layoutParams3).gravity;
                        if (i13 < 0) {
                            i13 = this.mGravity;
                        }
                        int i47 = (((i13 & DeviceType.INFRARED_HEATER) >> 4) & (-2)) >> 1;
                        iArr2[i47] = Math.max(iArr2[i47], baseline);
                        iArr[i47] = Math.max(iArr[i47], measuredHeight2 - baseline);
                    }
                    z15 = z19;
                    i40 = iMax9;
                    f = f;
                }
                i41++;
                i39 = i11;
                virtualChildCount = virtualChildCount;
            }
            i10 = virtualChildCount;
            this.mTotalLength = getPaddingRight() + getPaddingLeft() + this.mTotalLength;
            int i48 = iArr2[1];
            iMax7 = (i48 == -1 && iArr2[0] == -1 && iArr2[2] == -1 && iArr2[3] == -1) ? iMax8 : Math.max(iMax8, Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))) + Math.max(iArr2[3], Math.max(iArr2[0], Math.max(i48, iArr2[2]))));
            iMax = i40;
        } else {
            iMax = Math.max(i34, i35);
            if (z16 && mode != 1073741824) {
                for (int i49 = 0; i49 < virtualChildCount; i49++) {
                    View virtualChildAt4 = getVirtualChildAt(i49);
                    if (virtualChildAt4 != null && virtualChildAt4.getVisibility() != 8 && ((LinearLayout.LayoutParams) ((LayoutParams) virtualChildAt4.getLayoutParams())).weight > 0.0f) {
                        virtualChildAt4.measure(View.MeasureSpec.makeMeasureSpec(iMax2, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(virtualChildAt4.getMeasuredHeight(), BasicMeasure.EXACTLY));
                    }
                }
            }
            i10 = virtualChildCount;
            iCombineMeasuredStates = i36;
        }
        if (z15 || mode2 == 1073741824) {
            iMax = iMax7;
        }
        setMeasuredDimension(iResolveSizeAndState | ((-16777216) & iCombineMeasuredStates), View.resolveSizeAndState(Math.max(getPaddingBottom() + getPaddingTop() + iMax, getSuggestedMinimumHeight()), i9, iCombineMeasuredStates << 16));
        if (z14) {
            forceUniformHeight(i10, i8);
        }
    }

    public int measureNullChild(int i8) {
        return 0;
    }

    /* JADX WARN: Code duplicated, block: B:152:0x0331  */
    public void measureVertical(int i8, int i9) {
        int i10;
        int iCombineMeasuredStates;
        int iMax;
        int i11;
        int i12;
        int i13;
        boolean z2;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int iMax2;
        int i21;
        View view;
        int iMax3;
        boolean z3;
        this.mTotalLength = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i8);
        int mode2 = View.MeasureSpec.getMode(i9);
        int i22 = this.mBaselineAlignedChildIndex;
        boolean z5 = this.mUseLargestChild;
        int i23 = 0;
        int i24 = 0;
        int i25 = 0;
        int iMax4 = 0;
        int i26 = 0;
        int childrenSkipCount = 0;
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = true;
        float f = 0.0f;
        while (true) {
            int i27 = 8;
            int i28 = iMax4;
            if (childrenSkipCount >= virtualChildCount) {
                int i29 = i23;
                int i30 = i25;
                int i31 = i26;
                int i32 = mode2;
                int iMax5 = i24;
                int i33 = virtualChildCount;
                if (this.mTotalLength > 0) {
                    i10 = i33;
                    if (hasDividerBeforeChildAt(i10)) {
                        this.mTotalLength += this.mDividerHeight;
                    }
                } else {
                    i10 = i33;
                }
                if (z5 && (i32 == Integer.MIN_VALUE || i32 == 0)) {
                    this.mTotalLength = 0;
                    int childrenSkipCount2 = 0;
                    while (childrenSkipCount2 < i10) {
                        View virtualChildAt = getVirtualChildAt(childrenSkipCount2);
                        if (virtualChildAt == null) {
                            this.mTotalLength = measureNullChild(childrenSkipCount2) + this.mTotalLength;
                        } else if (virtualChildAt.getVisibility() == i27) {
                            childrenSkipCount2 += getChildrenSkipCount(virtualChildAt, childrenSkipCount2);
                        } else {
                            LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                            int i34 = this.mTotalLength;
                            this.mTotalLength = Math.max(i34, getNextLocationOffset(virtualChildAt) + i34 + i30 + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin);
                        }
                        childrenSkipCount2++;
                        i27 = 8;
                    }
                }
                int paddingBottom = getPaddingBottom() + getPaddingTop() + this.mTotalLength;
                this.mTotalLength = paddingBottom;
                int iResolveSizeAndState = View.resolveSizeAndState(Math.max(paddingBottom, getSuggestedMinimumHeight()), i9, 0);
                int i35 = (16777215 & iResolveSizeAndState) - this.mTotalLength;
                if (z10 || (i35 != 0 && f > 0.0f)) {
                    float f4 = this.mWeightSum;
                    if (f4 > 0.0f) {
                        f = f4;
                    }
                    this.mTotalLength = 0;
                    int i36 = i35;
                    int i37 = i31;
                    iCombineMeasuredStates = i29;
                    int i38 = 0;
                    while (i38 < i10) {
                        View virtualChildAt2 = getVirtualChildAt(i38);
                        if (virtualChildAt2.getVisibility() == 8) {
                            i11 = i36;
                        } else {
                            LayoutParams layoutParams2 = (LayoutParams) virtualChildAt2.getLayoutParams();
                            float f10 = ((LinearLayout.LayoutParams) layoutParams2).weight;
                            if (f10 > 0.0f) {
                                int i39 = (int) ((i36 * f10) / f);
                                float f11 = f - f10;
                                i11 = i36 - i39;
                                int childMeasureSpec = ViewGroup.getChildMeasureSpec(i8, getPaddingRight() + getPaddingLeft() + ((LinearLayout.LayoutParams) layoutParams2).leftMargin + ((LinearLayout.LayoutParams) layoutParams2).rightMargin, ((LinearLayout.LayoutParams) layoutParams2).width);
                                if (((LinearLayout.LayoutParams) layoutParams2).height == 0) {
                                    i14 = BasicMeasure.EXACTLY;
                                    if (i32 == 1073741824) {
                                        if (i39 <= 0) {
                                            i39 = 0;
                                        }
                                        virtualChildAt2.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(i39, BasicMeasure.EXACTLY));
                                    }
                                    iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, virtualChildAt2.getMeasuredState() & InputDeviceCompat.SOURCE_ANY);
                                    f = f11;
                                } else {
                                    i14 = BasicMeasure.EXACTLY;
                                }
                                int measuredHeight = virtualChildAt2.getMeasuredHeight() + i39;
                                if (measuredHeight < 0) {
                                    measuredHeight = 0;
                                }
                                virtualChildAt2.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(measuredHeight, i14));
                                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, virtualChildAt2.getMeasuredState() & InputDeviceCompat.SOURCE_ANY);
                                f = f11;
                            } else {
                                i11 = i36;
                            }
                            int i40 = ((LinearLayout.LayoutParams) layoutParams2).leftMargin + ((LinearLayout.LayoutParams) layoutParams2).rightMargin;
                            int measuredWidth = virtualChildAt2.getMeasuredWidth() + i40;
                            iMax5 = Math.max(iMax5, measuredWidth);
                            float f12 = f;
                            if (mode != 1073741824) {
                                i12 = iCombineMeasuredStates;
                                i13 = -1;
                                if (((LinearLayout.LayoutParams) layoutParams2).width != -1) {
                                }
                                int iMax6 = Math.max(i37, i40);
                                if (z12 || ((LinearLayout.LayoutParams) layoutParams2).width != i13) {
                                    z2 = false;
                                } else {
                                    z2 = true;
                                }
                                int i41 = this.mTotalLength;
                                this.mTotalLength = Math.max(i41, getNextLocationOffset(virtualChildAt2) + virtualChildAt2.getMeasuredHeight() + i41 + ((LinearLayout.LayoutParams) layoutParams2).topMargin + ((LinearLayout.LayoutParams) layoutParams2).bottomMargin);
                                z12 = z2;
                                iCombineMeasuredStates = i12;
                                i37 = iMax6;
                                f = f12;
                            } else {
                                i12 = iCombineMeasuredStates;
                                i13 = -1;
                            }
                            i40 = measuredWidth;
                            int iMax7 = Math.max(i37, i40);
                            if (z12) {
                                z2 = false;
                            } else {
                                z2 = false;
                            }
                            int i42 = this.mTotalLength;
                            this.mTotalLength = Math.max(i42, getNextLocationOffset(virtualChildAt2) + virtualChildAt2.getMeasuredHeight() + i42 + ((LinearLayout.LayoutParams) layoutParams2).topMargin + ((LinearLayout.LayoutParams) layoutParams2).bottomMargin);
                            z12 = z2;
                            iCombineMeasuredStates = i12;
                            i37 = iMax7;
                            f = f12;
                        }
                        i38++;
                        i36 = i11;
                    }
                    this.mTotalLength = getPaddingBottom() + getPaddingTop() + this.mTotalLength;
                    iMax = i37;
                } else {
                    iMax = Math.max(i31, i28);
                    if (z5 && i32 != 1073741824) {
                        for (int i43 = 0; i43 < i10; i43++) {
                            View virtualChildAt3 = getVirtualChildAt(i43);
                            if (virtualChildAt3 != null && virtualChildAt3.getVisibility() != 8 && ((LinearLayout.LayoutParams) ((LayoutParams) virtualChildAt3.getLayoutParams())).weight > 0.0f) {
                                virtualChildAt3.measure(View.MeasureSpec.makeMeasureSpec(virtualChildAt3.getMeasuredWidth(), BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(i30, BasicMeasure.EXACTLY));
                            }
                        }
                    }
                    iCombineMeasuredStates = i29;
                }
                if (z12 || mode == 1073741824) {
                    iMax = iMax5;
                }
                setMeasuredDimension(View.resolveSizeAndState(Math.max(getPaddingRight() + getPaddingLeft() + iMax, getSuggestedMinimumWidth()), i8, iCombineMeasuredStates), iResolveSizeAndState);
                if (z11) {
                    forceUniformWidth(i10, i9);
                    return;
                }
                return;
            }
            View virtualChildAt4 = getVirtualChildAt(childrenSkipCount);
            if (virtualChildAt4 == null) {
                this.mTotalLength = measureNullChild(childrenSkipCount) + this.mTotalLength;
                i18 = mode2;
                iMax4 = i28;
                i20 = virtualChildCount;
            } else {
                int i44 = i23;
                if (virtualChildAt4.getVisibility() == 8) {
                    childrenSkipCount += getChildrenSkipCount(virtualChildAt4, childrenSkipCount);
                    iMax4 = i28;
                    i23 = i44;
                    i20 = virtualChildCount;
                    i18 = mode2;
                } else {
                    if (hasDividerBeforeChildAt(childrenSkipCount)) {
                        this.mTotalLength += this.mDividerHeight;
                    }
                    LayoutParams layoutParams3 = (LayoutParams) virtualChildAt4.getLayoutParams();
                    float f13 = ((LinearLayout.LayoutParams) layoutParams3).weight;
                    float f14 = f + f13;
                    if (mode2 == 1073741824 && ((LinearLayout.LayoutParams) layoutParams3).height == 0 && f13 > 0.0f) {
                        int i45 = this.mTotalLength;
                        this.mTotalLength = Math.max(i45, ((LinearLayout.LayoutParams) layoutParams3).topMargin + i45 + ((LinearLayout.LayoutParams) layoutParams3).bottomMargin);
                        iMax3 = i25;
                        view = virtualChildAt4;
                        iMax2 = i26;
                        z10 = true;
                        i16 = i44;
                        i17 = i24;
                        i18 = mode2;
                        i19 = i28;
                        i20 = virtualChildCount;
                        i21 = childrenSkipCount;
                    } else {
                        int i46 = i24;
                        if (((LinearLayout.LayoutParams) layoutParams3).height != 0 || f13 <= 0.0f) {
                            i15 = Integer.MIN_VALUE;
                        } else {
                            ((LinearLayout.LayoutParams) layoutParams3).height = -2;
                            i15 = 0;
                        }
                        i16 = i44;
                        int i47 = i15;
                        i17 = i46;
                        int i48 = i25;
                        i18 = mode2;
                        i19 = i28;
                        i20 = virtualChildCount;
                        iMax2 = i26;
                        i21 = childrenSkipCount;
                        measureChildBeforeLayout(virtualChildAt4, childrenSkipCount, i8, 0, i9, f14 == 0.0f ? this.mTotalLength : 0);
                        if (i47 != Integer.MIN_VALUE) {
                            ((LinearLayout.LayoutParams) layoutParams3).height = i47;
                        }
                        int measuredHeight2 = virtualChildAt4.getMeasuredHeight();
                        int i49 = this.mTotalLength;
                        view = virtualChildAt4;
                        this.mTotalLength = Math.max(i49, getNextLocationOffset(view) + i49 + measuredHeight2 + ((LinearLayout.LayoutParams) layoutParams3).topMargin + ((LinearLayout.LayoutParams) layoutParams3).bottomMargin);
                        iMax3 = z5 ? Math.max(measuredHeight2, i48) : i48;
                    }
                    if (i22 >= 0 && i22 == i21 + 1) {
                        this.mBaselineChildTop = this.mTotalLength;
                    }
                    if (i21 < i22 && ((LinearLayout.LayoutParams) layoutParams3).weight > 0.0f) {
                        throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                    }
                    if (mode == 1073741824 || ((LinearLayout.LayoutParams) layoutParams3).width != -1) {
                        z3 = false;
                    } else {
                        z3 = true;
                        z11 = true;
                    }
                    int i50 = ((LinearLayout.LayoutParams) layoutParams3).leftMargin + ((LinearLayout.LayoutParams) layoutParams3).rightMargin;
                    int measuredWidth2 = view.getMeasuredWidth() + i50;
                    int iMax8 = Math.max(i17, measuredWidth2);
                    int iCombineMeasuredStates2 = View.combineMeasuredStates(i16, view.getMeasuredState());
                    z12 = z12 && ((LinearLayout.LayoutParams) layoutParams3).width == -1;
                    if (((LinearLayout.LayoutParams) layoutParams3).weight > 0.0f) {
                        if (!z3) {
                            i50 = measuredWidth2;
                        }
                        iMax4 = Math.max(i19, i50);
                    } else {
                        if (!z3) {
                            i50 = measuredWidth2;
                        }
                        iMax2 = Math.max(iMax2, i50);
                        iMax4 = i19;
                    }
                    int childrenSkipCount3 = getChildrenSkipCount(view, i21) + i21;
                    i25 = iMax3;
                    i24 = iMax8;
                    f = f14;
                    i26 = iMax2;
                    childrenSkipCount = childrenSkipCount3;
                    i23 = iCombineMeasuredStates2;
                }
            }
            childrenSkipCount++;
            virtualChildCount = i20;
            mode2 = i18;
        }
    }

    @Override // android.view.View
    public void onDraw(@NonNull Canvas canvas) {
        if (this.mDivider == null) {
            return;
        }
        if (this.mOrientation == 1) {
            drawDividersVertical(canvas);
        } else {
            drawDividersHorizontal(canvas);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(ACCESSIBILITY_CLASS_NAME);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ACCESSIBILITY_CLASS_NAME);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i8, int i9, int i10, int i11) {
        if (this.mOrientation == 1) {
            layoutVertical(i8, i9, i10, i11);
        } else {
            layoutHorizontal(i8, i9, i10, i11);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i8, int i9) {
        if (this.mOrientation == 1) {
            measureVertical(i8, i9);
        } else {
            measureHorizontal(i8, i9);
        }
    }

    public void setBaselineAligned(boolean z2) {
        this.mBaselineAligned = z2;
    }

    public void setBaselineAlignedChildIndex(int i8) {
        if (i8 >= 0 && i8 < getChildCount()) {
            this.mBaselineAlignedChildIndex = i8;
            return;
        }
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.mDivider) {
            return;
        }
        this.mDivider = drawable;
        if (drawable != null) {
            this.mDividerWidth = drawable.getIntrinsicWidth();
            this.mDividerHeight = drawable.getIntrinsicHeight();
        } else {
            this.mDividerWidth = 0;
            this.mDividerHeight = 0;
        }
        setWillNotDraw(drawable == null);
        requestLayout();
    }

    public void setDividerPadding(int i8) {
        this.mDividerPadding = i8;
    }

    public void setGravity(@GravityInt int i8) {
        if (this.mGravity != i8) {
            if ((8388615 & i8) == 0) {
                i8 |= GravityCompat.START;
            }
            if ((i8 & DeviceType.INFRARED_HEATER) == 0) {
                i8 |= 48;
            }
            this.mGravity = i8;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i8) {
        int i9 = i8 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        int i10 = this.mGravity;
        if ((8388615 & i10) != i9) {
            this.mGravity = i9 | ((-8388616) & i10);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z2) {
        this.mUseLargestChild = z2;
    }

    public void setOrientation(int i8) {
        if (this.mOrientation != i8) {
            this.mOrientation = i8;
            requestLayout();
        }
    }

    public void setShowDividers(int i8) {
        if (i8 != this.mShowDividers) {
            requestLayout();
        }
        this.mShowDividers = i8;
    }

    public void setVerticalGravity(int i8) {
        int i9 = i8 & DeviceType.INFRARED_HEATER;
        int i10 = this.mGravity;
        if ((i10 & DeviceType.INFRARED_HEATER) != i9) {
            this.mGravity = i9 | (i10 & (-113));
            requestLayout();
        }
    }

    public void setWeightSum(float f) {
        this.mWeightSum = Math.max(0.0f, f);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public LinearLayoutCompat(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        int i8 = this.mOrientation;
        if (i8 == 0) {
            return new LayoutParams(-2, -2);
        }
        if (i8 == 1) {
            return new LayoutParams(-1, -2);
        }
        return null;
    }

    public LinearLayoutCompat(@NonNull Context context, @Nullable AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        this.mBaselineAligned = true;
        this.mBaselineAlignedChildIndex = -1;
        this.mBaselineChildTop = 0;
        this.mGravity = 8388659;
        TintTypedArray tintTypedArrayObtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, androidx.appcompat.R.styleable.LinearLayoutCompat, i8, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, androidx.appcompat.R.styleable.LinearLayoutCompat, attributeSet, tintTypedArrayObtainStyledAttributes.getWrappedTypeArray(), i8, 0);
        int i9 = tintTypedArrayObtainStyledAttributes.getInt(androidx.appcompat.R.styleable.LinearLayoutCompat_android_orientation, -1);
        if (i9 >= 0) {
            setOrientation(i9);
        }
        int i10 = tintTypedArrayObtainStyledAttributes.getInt(androidx.appcompat.R.styleable.LinearLayoutCompat_android_gravity, -1);
        if (i10 >= 0) {
            setGravity(i10);
        }
        boolean z2 = tintTypedArrayObtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.LinearLayoutCompat_android_baselineAligned, true);
        if (!z2) {
            setBaselineAligned(z2);
        }
        this.mWeightSum = tintTypedArrayObtainStyledAttributes.getFloat(androidx.appcompat.R.styleable.LinearLayoutCompat_android_weightSum, -1.0f);
        this.mBaselineAlignedChildIndex = tintTypedArrayObtainStyledAttributes.getInt(androidx.appcompat.R.styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.mUseLargestChild = tintTypedArrayObtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(tintTypedArrayObtainStyledAttributes.getDrawable(androidx.appcompat.R.styleable.LinearLayoutCompat_divider));
        this.mShowDividers = tintTypedArrayObtainStyledAttributes.getInt(androidx.appcompat.R.styleable.LinearLayoutCompat_showDividers, 0);
        this.mDividerPadding = tintTypedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.LinearLayoutCompat_dividerPadding, 0);
        tintTypedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }
}
