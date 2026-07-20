package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class ContentFrameLayout extends FrameLayout {
    private OnAttachListener mAttachListener;
    private final Rect mDecorPadding;
    private TypedValue mFixedHeightMajor;
    private TypedValue mFixedHeightMinor;
    private TypedValue mFixedWidthMajor;
    private TypedValue mFixedWidthMinor;
    private TypedValue mMinWidthMajor;
    private TypedValue mMinWidthMinor;

    public interface OnAttachListener {
        void onAttachedFromWindow();

        void onDetachedFromWindow();
    }

    public ContentFrameLayout(@NonNull Context context) {
        this(context, null);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void dispatchFitSystemWindows(Rect rect) {
        fitSystemWindows(rect);
    }

    public TypedValue getFixedHeightMajor() {
        if (this.mFixedHeightMajor == null) {
            this.mFixedHeightMajor = new TypedValue();
        }
        return this.mFixedHeightMajor;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.mFixedHeightMinor == null) {
            this.mFixedHeightMinor = new TypedValue();
        }
        return this.mFixedHeightMinor;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.mFixedWidthMajor == null) {
            this.mFixedWidthMajor = new TypedValue();
        }
        return this.mFixedWidthMajor;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.mFixedWidthMinor == null) {
            this.mFixedWidthMinor = new TypedValue();
        }
        return this.mFixedWidthMinor;
    }

    public TypedValue getMinWidthMajor() {
        if (this.mMinWidthMajor == null) {
            this.mMinWidthMajor = new TypedValue();
        }
        return this.mMinWidthMajor;
    }

    public TypedValue getMinWidthMinor() {
        if (this.mMinWidthMinor == null) {
            this.mMinWidthMinor = new TypedValue();
        }
        return this.mMinWidthMinor;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        OnAttachListener onAttachListener = this.mAttachListener;
        if (onAttachListener != null) {
            onAttachListener.onAttachedFromWindow();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        OnAttachListener onAttachListener = this.mAttachListener;
        if (onAttachListener != null) {
            onAttachListener.onDetachedFromWindow();
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0049  */
    /* JADX WARN: Code duplicated, block: B:22:0x005f  */
    /* JADX WARN: Code duplicated, block: B:37:0x0084  */
    /* JADX WARN: Code duplicated, block: B:54:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:56:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:57:0x00d8  */
    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i8, int i9) {
        boolean z2;
        int i10;
        int i11;
        float fraction;
        int i12;
        int i13;
        float fraction2;
        int i14;
        int i15;
        float fraction3;
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        boolean z3 = true;
        boolean z5 = displayMetrics.widthPixels < displayMetrics.heightPixels;
        int mode = View.MeasureSpec.getMode(i8);
        int mode2 = View.MeasureSpec.getMode(i9);
        if (mode != Integer.MIN_VALUE) {
            z2 = false;
        } else {
            TypedValue typedValue = z5 ? this.mFixedWidthMinor : this.mFixedWidthMajor;
            if (typedValue == null || (i14 = typedValue.type) == 0) {
                z2 = false;
            } else {
                if (i14 == 5) {
                    fraction3 = typedValue.getDimension(displayMetrics);
                } else {
                    if (i14 == 6) {
                        float f = displayMetrics.widthPixels;
                        fraction3 = typedValue.getFraction(f, f);
                    } else {
                        i15 = 0;
                    }
                    if (i15 > 0) {
                        Rect rect = this.mDecorPadding;
                        i8 = View.MeasureSpec.makeMeasureSpec(Math.min(i15 - (rect.left + rect.right), View.MeasureSpec.getSize(i8)), BasicMeasure.EXACTLY);
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                }
                i15 = (int) fraction3;
                if (i15 > 0) {
                    Rect rect2 = this.mDecorPadding;
                    i8 = View.MeasureSpec.makeMeasureSpec(Math.min(i15 - (rect2.left + rect2.right), View.MeasureSpec.getSize(i8)), BasicMeasure.EXACTLY);
                    z2 = true;
                } else {
                    z2 = false;
                }
            }
        }
        if (mode2 == Integer.MIN_VALUE) {
            TypedValue typedValue2 = z5 ? this.mFixedHeightMajor : this.mFixedHeightMinor;
            if (typedValue2 != null && (i12 = typedValue2.type) != 0) {
                if (i12 == 5) {
                    fraction2 = typedValue2.getDimension(displayMetrics);
                } else {
                    if (i12 == 6) {
                        float f4 = displayMetrics.heightPixels;
                        fraction2 = typedValue2.getFraction(f4, f4);
                    } else {
                        i13 = 0;
                    }
                    if (i13 > 0) {
                        Rect rect3 = this.mDecorPadding;
                        i9 = View.MeasureSpec.makeMeasureSpec(Math.min(i13 - (rect3.top + rect3.bottom), View.MeasureSpec.getSize(i9)), BasicMeasure.EXACTLY);
                    }
                }
                i13 = (int) fraction2;
                if (i13 > 0) {
                    Rect rect4 = this.mDecorPadding;
                    i9 = View.MeasureSpec.makeMeasureSpec(Math.min(i13 - (rect4.top + rect4.bottom), View.MeasureSpec.getSize(i9)), BasicMeasure.EXACTLY);
                }
            }
        }
        super.onMeasure(i8, i9);
        int measuredWidth = getMeasuredWidth();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, BasicMeasure.EXACTLY);
        if (z2 || mode != Integer.MIN_VALUE) {
            z3 = false;
        } else {
            TypedValue typedValue3 = z5 ? this.mMinWidthMinor : this.mMinWidthMajor;
            if (typedValue3 == null || (i10 = typedValue3.type) == 0) {
                z3 = false;
            } else {
                if (i10 == 5) {
                    fraction = typedValue3.getDimension(displayMetrics);
                } else {
                    if (i10 == 6) {
                        float f10 = displayMetrics.widthPixels;
                        fraction = typedValue3.getFraction(f10, f10);
                    } else {
                        i11 = 0;
                    }
                    if (i11 > 0) {
                        Rect rect5 = this.mDecorPadding;
                        i11 -= rect5.left + rect5.right;
                    }
                    if (measuredWidth < i11) {
                        iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i11, BasicMeasure.EXACTLY);
                    } else {
                        z3 = false;
                    }
                }
                i11 = (int) fraction;
                if (i11 > 0) {
                    Rect rect6 = this.mDecorPadding;
                    i11 -= rect6.left + rect6.right;
                }
                if (measuredWidth < i11) {
                    iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i11, BasicMeasure.EXACTLY);
                } else {
                    z3 = false;
                }
            }
        }
        if (z3) {
            super.onMeasure(iMakeMeasureSpec, i9);
        }
    }

    public void setAttachListener(OnAttachListener onAttachListener) {
        this.mAttachListener = onAttachListener;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setDecorPadding(int i8, int i9, int i10, int i11) {
        this.mDecorPadding.set(i8, i9, i10, i11);
        if (isLaidOut()) {
            requestLayout();
        }
    }

    public ContentFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContentFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        this.mDecorPadding = new Rect();
    }
}
