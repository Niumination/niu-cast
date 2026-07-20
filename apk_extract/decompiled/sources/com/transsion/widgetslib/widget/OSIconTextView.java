package com.transsion.widgetslib.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.widgetslib.R$attr;
import com.transsion.widgetslib.R$color;
import com.transsion.widgetslib.R$dimen;
import com.transsion.widgetslib.R$styleable;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import pd.j;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/transsion/widgetslib/widget/OSIconTextView;", "Landroid/widget/TextView;", "", "supportRtl", "", "setSupportRtl", "(Z)V", "widgetsLib_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@SourceDebugExtension({"SMAP\nOSIconTextView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OSIconTextView.kt\ncom/transsion/widgetslib/widget/OSIconTextView\n+ 2 Context.kt\nandroidx/core/content/ContextKt\n*L\n1#1,105:1\n52#2,9:106\n*S KotlinDebug\n*F\n+ 1 OSIconTextView.kt\ncom/transsion/widgetslib/widget/OSIconTextView\n*L\n37#1:106,9\n*E\n"})
public class OSIconTextView extends TextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3394a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f3395b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSIconTextView(Context context) {
        this(context, null, 0, 14);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int i8, int i9) {
        if ((View.MeasureSpec.getMode(i8) == Integer.MIN_VALUE || View.MeasureSpec.getMode(i8) == 0) && (View.MeasureSpec.getMode(i9) == Integer.MIN_VALUE || View.MeasureSpec.getMode(i9) == 0)) {
            int i10 = this.f3394a;
            int paddingEnd = getPaddingEnd() + getPaddingStart() + View.MeasureSpec.makeMeasureSpec(i10, BasicMeasure.EXACTLY);
            i9 = getPaddingTop() + View.MeasureSpec.makeMeasureSpec(i10, BasicMeasure.EXACTLY) + getPaddingBottom();
            i8 = paddingEnd;
        }
        super.onMeasure(i8, i9);
    }

    public final void setSupportRtl(boolean supportRtl) {
        this.f3395b = supportRtl;
        if (supportRtl) {
            setRotationY(j.v() ? 180.0f : 0.0f);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSIconTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 12);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSIconTextView(Context context, AttributeSet attributeSet, int i8) {
        this(context, attributeSet, i8, 8);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public OSIconTextView(Context context, AttributeSet attributeSet, int i8, int i9) {
        attributeSet = (i9 & 2) != 0 ? null : attributeSet;
        i8 = (i9 & 4) != 0 ? 0 : i8;
        Intrinsics.checkNotNullParameter(context, "context");
        super(context, attributeSet, i8, 0);
        setTypeface(Typeface.createFromAsset(context.getAssets(), "tossymbol.ttf"));
        setGravity(17);
        this.f3394a = context.getResources().getDimensionPixelSize(R$dimen.os_icon_textview_default_size);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.textSize, R.attr.textColor, R.attr.clickable}, 0, 0);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        if (!typedArrayObtainStyledAttributes.getValue(0, new TypedValue())) {
            setTextSize(0, context.getResources().getDimensionPixelSize(R$dimen.os_icon_textview_default_text_size));
        }
        if (typedArrayObtainStyledAttributes.hasValue(1)) {
            ColorStateList colorStateList = typedArrayObtainStyledAttributes.getColorStateList(1);
            if (colorStateList != null) {
                setTextColor(colorStateList);
            } else {
                setTextColor(typedArrayObtainStyledAttributes.getColor(1, 0));
            }
        } else {
            setTextColor(j.d(R$attr.os_icon_tertiary, context.getColor(R$color.os_icon_tertiary_hios), context));
        }
        if (!typedArrayObtainStyledAttributes.hasValue(2)) {
            setClickable(true);
        }
        typedArrayObtainStyledAttributes.recycle();
        setVerticalScrollBarEnabled(false);
        setElegantTextHeight(false);
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R$styleable.OSIconTextView);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes2, "context.obtainStyledAttr…styleable.OSIconTextView)");
        int indexCount = typedArrayObtainStyledAttributes2.getIndexCount();
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = typedArrayObtainStyledAttributes2.getIndex(i10);
            if (index == R$styleable.OSIconTextView_os_icon_support_rtl) {
                this.f3395b = typedArrayObtainStyledAttributes2.getBoolean(index, false);
            }
        }
        typedArrayObtainStyledAttributes2.recycle();
        setSupportRtl(this.f3395b);
    }
}
