package com.google.android.material.divider;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* JADX INFO: loaded from: classes.dex */
public class MaterialDivider extends View {
    private static final int DEF_STYLE_RES = R.style.Widget_MaterialComponents_MaterialDivider;

    @ColorInt
    private int color;

    @NonNull
    private final MaterialShapeDrawable dividerDrawable;
    private int insetEnd;
    private int insetStart;
    private int thickness;

    public MaterialDivider(@NonNull Context context) {
        this(context, null);
    }

    public int getDividerColor() {
        return this.color;
    }

    @Px
    public int getDividerInsetEnd() {
        return this.insetEnd;
    }

    @Px
    public int getDividerInsetStart() {
        return this.insetStart;
    }

    public int getDividerThickness() {
        return this.thickness;
    }

    @Override // android.view.View
    public void onDraw(@NonNull Canvas canvas) {
        int width;
        int i8;
        super.onDraw(canvas);
        boolean z2 = ViewCompat.getLayoutDirection(this) == 1;
        int i9 = z2 ? this.insetEnd : this.insetStart;
        if (z2) {
            width = getWidth();
            i8 = this.insetStart;
        } else {
            width = getWidth();
            i8 = this.insetEnd;
        }
        this.dividerDrawable.setBounds(i9, 0, width - i8, getBottom() - getTop());
        this.dividerDrawable.draw(canvas);
    }

    @Override // android.view.View
    public void onMeasure(int i8, int i9) {
        super.onMeasure(i8, i9);
        int mode = View.MeasureSpec.getMode(i9);
        int measuredHeight = getMeasuredHeight();
        if (mode == Integer.MIN_VALUE || mode == 0) {
            int i10 = this.thickness;
            if (i10 > 0 && measuredHeight != i10) {
                measuredHeight = i10;
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
    }

    public void setDividerColor(@ColorInt int i8) {
        if (this.color != i8) {
            this.color = i8;
            this.dividerDrawable.setFillColor(ColorStateList.valueOf(i8));
            invalidate();
        }
    }

    public void setDividerColorResource(@ColorRes int i8) {
        setDividerColor(ContextCompat.getColor(getContext(), i8));
    }

    public void setDividerInsetEnd(@Px int i8) {
        this.insetEnd = i8;
    }

    public void setDividerInsetEndResource(@DimenRes int i8) {
        setDividerInsetEnd(getContext().getResources().getDimensionPixelOffset(i8));
    }

    public void setDividerInsetStart(@Px int i8) {
        this.insetStart = i8;
    }

    public void setDividerInsetStartResource(@DimenRes int i8) {
        setDividerInsetStart(getContext().getResources().getDimensionPixelOffset(i8));
    }

    public void setDividerThickness(@Px int i8) {
        if (this.thickness != i8) {
            this.thickness = i8;
            requestLayout();
        }
    }

    public void setDividerThicknessResource(@DimenRes int i8) {
        setDividerThickness(getContext().getResources().getDimensionPixelSize(i8));
    }

    public MaterialDivider(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialDividerStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialDivider(@NonNull Context context, @Nullable AttributeSet attributeSet, int i8) {
        int i9 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(context, attributeSet, i8, i9), attributeSet, i8);
        Context context2 = getContext();
        this.dividerDrawable = new MaterialShapeDrawable();
        TypedArray typedArrayObtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, R.styleable.MaterialDivider, i8, i9, new int[0]);
        this.thickness = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.MaterialDivider_dividerThickness, getResources().getDimensionPixelSize(R.dimen.material_divider_thickness));
        this.insetStart = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.MaterialDivider_dividerInsetStart, 0);
        this.insetEnd = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.MaterialDivider_dividerInsetEnd, 0);
        setDividerColor(MaterialResources.getColorStateList(context2, typedArrayObtainStyledAttributes, R.styleable.MaterialDivider_dividerColor).getDefaultColor());
        typedArrayObtainStyledAttributes.recycle();
    }
}
