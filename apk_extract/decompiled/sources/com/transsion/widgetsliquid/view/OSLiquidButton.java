package com.transsion.widgetsliquid.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.StringRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.widgetslib.widget.OSIconTextView;
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

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\u00122\b\b\u0001\u0010\u0015\u001a\u00020\u0007J\u0010\u0010\u0014\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u000e\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010\u0018\u001a\u00020\u00122\b\b\u0001\u0010\u001b\u001a\u00020\u0007J\u0010\u0010\u001c\u001a\u00020\u00122\b\b\u0001\u0010\u001d\u001a\u00020\u0007J\u000e\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u0010R\u001b\u0010\t\u001a\u00020\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006 "}, d2 = {"Lcom/transsion/widgetsliquid/view/OSLiquidButton;", "Lcom/transsion/widgetsliquid/effect/OSLiquidContainerRootLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mIconText", "Lcom/transsion/widgetslib/widget/OSIconTextView;", "getMIconText", "()Lcom/transsion/widgetslib/widget/OSIconTextView;", "mIconText$delegate", "Lkotlin/Lazy;", "hasOverlappingRendering", "", "setEnabled", "", "enabled", "setIcon", "iconStrRes", "iconStr", "", "setIconColor", "colorStateList", "Landroid/content/res/ColorStateList;", "colorRes", "setIconSize", "iconSize", "setSupportIconMirror", "isSupportMirror", "widgetsliquid_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@SourceDebugExtension({"SMAP\nOSLiquidButton.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OSLiquidButton.kt\ncom/transsion/widgetsliquid/view/OSLiquidButton\n+ 2 ContextFunc.kt\ncom/transsion/widgetslib/util/ContextFuncKt\n*L\n1#1,100:1\n13#2,9:101\n*S KotlinDebug\n*F\n+ 1 OSLiquidButton.kt\ncom/transsion/widgetsliquid/view/OSLiquidButton\n*L\n33#1:101,9\n*E\n"})
public class OSLiquidButton extends OSLiquidContainerRootLayout {

    /* JADX INFO: renamed from: mIconText$delegate, reason: from kotlin metadata */
    private final Lazy mIconText;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSLiquidButton(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final OSIconTextView getMIconText() {
        return (OSIconTextView) this.mIconText.getValue();
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    @Override // android.view.View
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        setAlpha(enabled ? 1.0f : 0.4f);
    }

    public final void setIcon(String iconStr) {
        getMIconText().setText(iconStr);
    }

    public final void setIconColor(@ColorRes int colorRes) {
        getMIconText().setTextColor(getResources().getColor(colorRes, getContext().getTheme()));
    }

    public final void setIconSize(@DimenRes int iconSize) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(iconSize);
        getMIconText().setTextSize(0, dimensionPixelSize);
        ViewGroup.LayoutParams layoutParams = getMIconText().getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = dimensionPixelSize;
        getMIconText().setLayoutParams(getMIconText().getLayoutParams());
    }

    public final void setSupportIconMirror(boolean isSupportMirror) {
        getMIconText().setSupportRtl(isSupportMirror);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSLiquidButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void setIcon(@StringRes int iconStrRes) {
        getMIconText().setText(getResources().getString(iconStrRes));
    }

    public final void setIconColor(ColorStateList colorStateList) {
        Intrinsics.checkNotNullParameter(colorStateList, "colorStateList");
        getMIconText().setTextColor(colorStateList);
    }

    public /* synthetic */ OSLiquidButton(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? 0 : i8);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSLiquidButton(final Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mIconText = LazyKt.lazy(new Function0<OSIconTextView>() { // from class: com.transsion.widgetsliquid.view.OSLiquidButton$mIconText$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final OSIconTextView invoke() {
                OSIconTextView oSIconTextView = new OSIconTextView(context, null, 0, 14);
                oSIconTextView.setClickable(false);
                return oSIconTextView;
            }
        });
        addView(getMIconText());
        int[] OSLiquidButton = R.styleable.OSLiquidButton;
        Intrinsics.checkNotNullExpressionValue(OSLiquidButton, "OSLiquidButton");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, OSLiquidButton, 0, 0);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        float dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.OSLiquidButton_os_liquid_button_text_size, typedArrayObtainStyledAttributes.getResources().getDimensionPixelSize(R.dimen.os_search_bar_icon_out_size));
        getMIconText().setTextSize(0, dimensionPixelSize);
        int color = typedArrayObtainStyledAttributes.getColor(R.styleable.OSLiquidButton_os_liquid_button_text_color, typedArrayObtainStyledAttributes.getResources().getColor(R.color.os_text_primary_color));
        String string = typedArrayObtainStyledAttributes.getString(R.styleable.OSLiquidButton_os_liquid_button_text);
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.OSLiquidButton_os_liquid_button_icon_mirror, false);
        if (!TextUtils.isEmpty(string)) {
            getMIconText().setText(string);
        }
        getMIconText().setSupportRtl(z2);
        getMIconText().setTextSize(0, dimensionPixelSize);
        getMIconText().setTextColor(color);
        ViewGroup.LayoutParams layoutParams = getMIconText().getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.gravity = 17;
        int i9 = (int) dimensionPixelSize;
        layoutParams2.width = i9;
        layoutParams2.height = i9;
        typedArrayObtainStyledAttributes.recycle();
        setScaleRatio(1.25f);
    }
}
