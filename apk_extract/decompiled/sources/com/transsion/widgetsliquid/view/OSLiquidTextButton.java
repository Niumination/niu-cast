package com.transsion.widgetsliquid.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.StringRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.TextViewCompat;
import com.transsion.widgetsliquid.R;
import com.transsion.widgetsliquid.effect.OSLiquidContainerRootLayout;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0007H\u0014J\u0016\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0007J\u0010\u0010\u0018\u001a\u00020\u00152\b\b\u0001\u0010\u001a\u001a\u00020\u0007J\u0010\u0010\u001b\u001a\u00020\u00152\b\u0010\u001c\u001a\u0004\u0018\u00010\u0011J\u0010\u0010\u001b\u001a\u00020\u00152\b\b\u0001\u0010\u001d\u001a\u00020\u0007J\u000e\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020 J\u0010\u0010\u001e\u001a\u00020\u00152\b\b\u0001\u0010!\u001a\u00020\u0007J\u0010\u0010\"\u001a\u00020\u00152\b\b\u0001\u0010#\u001a\u00020\u0007R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r¨\u0006$"}, d2 = {"Lcom/transsion/widgetsliquid/view/OSLiquidTextButton;", "Lcom/transsion/widgetsliquid/effect/OSLiquidContainerRootLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mMaxWidthPx", "mText", "Landroid/widget/TextView;", "getMText", "()Landroid/widget/TextView;", "mText$delegate", "Lkotlin/Lazy;", "getText", "", "hasOverlappingRendering", "", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "setMaxWidth", "dp", "dimenRes", "setText", "iconStr", "iconStrRes", "setTextColor", "colorStateList", "Landroid/content/res/ColorStateList;", "colorRes", "setTextSize", "iconSize", "widgetsliquid_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@SourceDebugExtension({"SMAP\nOSLiquidTextButton.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OSLiquidTextButton.kt\ncom/transsion/widgetsliquid/view/OSLiquidTextButton\n+ 2 ContextFunc.kt\ncom/transsion/widgetslib/util/ContextFuncKt\n*L\n1#1,123:1\n13#2,9:124\n*S KotlinDebug\n*F\n+ 1 OSLiquidTextButton.kt\ncom/transsion/widgetsliquid/view/OSLiquidTextButton\n*L\n43#1:124,9\n*E\n"})
public class OSLiquidTextButton extends OSLiquidContainerRootLayout {
    private int mMaxWidthPx;

    /* JADX INFO: renamed from: mText$delegate, reason: from kotlin metadata */
    private final Lazy mText;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSLiquidTextButton(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final TextView getMText() {
        return (TextView) this.mText.getValue();
    }

    public final CharSequence getText() {
        return getMText().getText();
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    @Override // com.transsion.widgetslib.view.liquid.effect.OSLiquidContainerRootLayoutInner, android.widget.FrameLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (this.mMaxWidthPx == Integer.MAX_VALUE) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        } else {
            int mode = View.MeasureSpec.getMode(widthMeasureSpec);
            super.onMeasure(mode == 0 ? View.MeasureSpec.makeMeasureSpec(this.mMaxWidthPx, Integer.MIN_VALUE) : View.MeasureSpec.makeMeasureSpec(RangesKt.coerceAtMost(View.MeasureSpec.getSize(widthMeasureSpec), this.mMaxWidthPx), mode), heightMeasureSpec);
        }
    }

    public final void setMaxWidth(Context context, int dp) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mMaxWidthPx = (int) TypedValue.applyDimension(1, dp, context.getResources().getDisplayMetrics());
        requestLayout();
    }

    public final void setText(CharSequence iconStr) {
        getMText().setText(iconStr);
    }

    public final void setTextColor(@ColorRes int colorRes) {
        getMText().setTextColor(getResources().getColor(colorRes, getContext().getTheme()));
    }

    public final void setTextSize(@DimenRes int iconSize) {
        getMText().setTextSize(0, getResources().getDimensionPixelSize(iconSize));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSLiquidTextButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void setText(@StringRes int iconStrRes) {
        getMText().setText(getResources().getString(iconStrRes));
    }

    public final void setTextColor(ColorStateList colorStateList) {
        Intrinsics.checkNotNullParameter(colorStateList, "colorStateList");
        getMText().setTextColor(colorStateList);
    }

    public /* synthetic */ OSLiquidTextButton(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? 0 : i8);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSLiquidTextButton(final Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mText = LazyKt.lazy(new Function0<TextView>() { // from class: com.transsion.widgetsliquid.view.OSLiquidTextButton$mText$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                TextView textView = new TextView(context);
                textView.setClickable(false);
                textView.setIncludeFontPadding(true);
                textView.setGravity(17);
                textView.setMaxLines(1);
                textView.setEllipsize(TextUtils.TruncateAt.END);
                TextViewCompat.setTextAppearance(textView, R.style.os_semibold_font);
                textView.setPadding(textView.getResources().getDimensionPixelSize(R.dimen.os_space150), 0, textView.getResources().getDimensionPixelSize(R.dimen.os_space150), 0);
                return textView;
            }
        });
        this.mMaxWidthPx = Integer.MAX_VALUE;
        addView(getMText());
        int[] OSLiquidButton = R.styleable.OSLiquidButton;
        Intrinsics.checkNotNullExpressionValue(OSLiquidButton, "OSLiquidButton");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, OSLiquidButton, 0, 0);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        float dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.OSLiquidButton_os_liquid_button_text_size, typedArrayObtainStyledAttributes.getResources().getDimensionPixelSize(R.dimen.os_search_bar_icon_out_size));
        getMText().setTextSize(0, dimensionPixelSize);
        int color = typedArrayObtainStyledAttributes.getColor(R.styleable.OSLiquidButton_os_liquid_button_text_color, typedArrayObtainStyledAttributes.getResources().getColor(R.color.os_text_primary_color));
        String string = typedArrayObtainStyledAttributes.getString(R.styleable.OSLiquidButton_os_liquid_button_text);
        if (!TextUtils.isEmpty(string)) {
            getMText().setText(string);
        }
        getMText().setTextSize(0, dimensionPixelSize);
        getMText().setTextColor(color);
        typedArrayObtainStyledAttributes.recycle();
        setScaleRatio(1.25f);
    }

    public final void setMaxWidth(@DimenRes int dimenRes) {
        this.mMaxWidthPx = getResources().getDimensionPixelSize(dimenRes);
        requestLayout();
    }
}
