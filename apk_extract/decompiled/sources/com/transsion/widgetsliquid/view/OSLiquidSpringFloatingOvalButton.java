package com.transsion.widgetsliquid.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.DimenRes;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FloatValueHolder;
import com.transsion.widgetslib.view.liquid.effect.OSLiquidContainer;
import com.transsion.widgetslib.widget.OSIconTextView;
import com.transsion.widgetsliquid.R;
import com.transsion.widgetsliquid.effect.OSLiquidContainerRootLayout;
import java.lang.ref.WeakReference;
import jd.e;
import jd.f;
import jd.g;
import jd.h;
import je.p;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import pd.j;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(29)
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u0000 O2\u00020\u0001:\u0001OB\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u0019\u0010\u000e\u001a\u00020\b2\b\b\u0001\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\bH\u0014¢\u0006\u0004\b\u0010\u0010\nJ\u0015\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\f¢\u0006\u0004\b\u001e\u0010\u000fJ7\u0010$\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\fH\u0014¢\u0006\u0004\b$\u0010%J\u0017\u0010(\u001a\u00020\b2\b\u0010'\u001a\u0004\u0018\u00010&¢\u0006\u0004\b(\u0010)J\u0017\u0010,\u001a\u00020\b2\b\u0010+\u001a\u0004\u0018\u00010*¢\u0006\u0004\b,\u0010-J\u0017\u00100\u001a\u00020\b2\b\u0010/\u001a\u0004\u0018\u00010.¢\u0006\u0004\b0\u00101J\u0017\u00103\u001a\u00020\b2\u0006\u00102\u001a\u00020\fH\u0016¢\u0006\u0004\b3\u0010\u000fR\u001b\u00109\u001a\u0002048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u0018\u0010:\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010<\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010>\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010@\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010B\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010D\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010CR\u0016\u0010E\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010CR\u0016\u0010F\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010CR\u0016\u0010G\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010CR\u0016\u0010H\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010CR\u0016\u0010I\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010K\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010JR\u0018\u0010M\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010N¨\u0006P"}, d2 = {"Lcom/transsion/widgetsliquid/view/OSLiquidSpringFloatingOvalButton;", "Lcom/transsion/widgetsliquid/effect/OSLiquidContainerRootLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "requireAlpha", "()V", "setDefaultInset", "", "iconSize", "setIconSize", "(I)V", "onAttachedToWindow", "", "useDefaultInset", "setUseDefaultInset", "(Z)V", "Ljd/h;", "clickListener", "setOnClickListener", "(Ljd/h;)V", "", TypedValues.Custom.S_STRING, "setIconText", "(Ljava/lang/String;)V", TypedValues.Custom.S_COLOR, "setIconTextColor", "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "Ljd/f;", "onAnimationEndListener", "setOnAnimationEndListener", "(Ljd/f;)V", "Ljd/g;", "onAnimationUpdateListener", "setOnAnimationUpdateListener", "(Ljd/g;)V", "Landroid/view/View$OnTouchListener;", "touchListener", "setOnFabTouchListener", "(Landroid/view/View$OnTouchListener;)V", "visibility", "setVisibility", "Lcom/transsion/widgetslib/widget/OSIconTextView;", "mIconTv$delegate", "Lkotlin/Lazy;", "getMIconTv", "()Lcom/transsion/widgetslib/widget/OSIconTextView;", "mIconTv", "mClickListener", "Ljd/h;", "mOnAnimationEndListener", "Ljd/f;", "mOnAnimationUpdateListener", "Ljd/g;", "mOnTouchListener", "Landroid/view/View$OnTouchListener;", "mBackgroundColor", "I", "mIconColor", "mPaddingTop", "mPaddingBottom", "mPaddingLeft", "mPaddingRight", "mUseDefaultInset", "Z", "isCustomColor", "Lcom/transsion/widgetslib/view/liquid/effect/OSLiquidContainer;", "mLiquidEffectView2", "Lcom/transsion/widgetslib/view/liquid/effect/OSLiquidContainer;", "Companion", "widgetsliquid_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public class OSLiquidSpringFloatingOvalButton extends OSLiquidContainerRootLayout {
    private static final float ANIMATION_FINAL_VALUE = 1.25f;
    private static final float ANIMATION_START_PRESS_DAMPING_RATIO = 0.99f;
    private static final float ANIMATION_START_PRESS_STIFFNESS = 250.0f;
    private static final float ANIMATION_STOP_PRESS_DAMPING_RATIO = 0.4f;
    private static final float ANIMATION_STOP_PRESS_STIFFNESS = 250.0f;
    private static final String TAG = "OSLiquidSpringFloatingOval";
    private boolean isCustomColor;
    private int mBackgroundColor;
    private h mClickListener;
    private int mIconColor;

    /* JADX INFO: renamed from: mIconTv$delegate, reason: from kotlin metadata */
    private final Lazy mIconTv;
    private OSLiquidContainer mLiquidEffectView2;
    private f mOnAnimationEndListener;
    private g mOnAnimationUpdateListener;
    private View.OnTouchListener mOnTouchListener;
    private int mPaddingBottom;
    private int mPaddingLeft;
    private int mPaddingRight;
    private int mPaddingTop;
    private boolean mUseDefaultInset;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public OSLiquidSpringFloatingOvalButton(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$2(OSLiquidSpringFloatingOvalButton this$0, View view, boolean z2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        h hVar = this$0.mClickListener;
        if (hVar != null) {
            Intrinsics.checkNotNull(hVar);
            hVar.b(view, z2);
            if (z2) {
                return;
            }
            this$0.playSoundEffect(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$3(OSLiquidSpringFloatingOvalButton this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View.OnTouchListener onTouchListener = this$0.mOnTouchListener;
        if (onTouchListener == null) {
            return false;
        }
        Intrinsics.checkNotNull(onTouchListener);
        onTouchListener.onTouch(view, motionEvent);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$4(OSLiquidSpringFloatingOvalButton this$0, boolean z2, DynamicAnimation dynamicAnimation, boolean z3, boolean z5, float f, float f4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        f fVar = this$0.mOnAnimationEndListener;
        if (fVar != null) {
            Intrinsics.checkNotNull(fVar);
            fVar.a(z2, dynamicAnimation, z3, z5, f, f4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$5(OSLiquidSpringFloatingOvalButton this$0, boolean z2, DynamicAnimation dynamicAnimation, float f, float f4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        g gVar = this$0.mOnAnimationUpdateListener;
        if (gVar != null) {
            Intrinsics.checkNotNull(gVar);
            gVar.c(dynamicAnimation, z2, f, f4);
        }
    }

    private final OSIconTextView getMIconTv() {
        return (OSIconTextView) this.mIconTv.getValue();
    }

    private final void requireAlpha() {
        setPaddingRelative(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, this.mPaddingBottom);
    }

    private final void setDefaultInset() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.setMarginEnd(getContext().getResources().getDimensionPixelSize(R.dimen.os_fab_margin_end_default));
            marginLayoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(R.dimen.os_fab_margin_bottom_default);
            setLayoutParams(layoutParams);
        }
    }

    private final void setIconSize(@DimenRes int iconSize) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(iconSize);
        OSIconTextView mIconTv = getMIconTv();
        Intrinsics.checkNotNull(mIconTv);
        mIconTv.setTextSize(0, dimensionPixelSize);
        OSIconTextView mIconTv2 = getMIconTv();
        Intrinsics.checkNotNull(mIconTv2);
        ViewGroup.LayoutParams layoutParams = mIconTv2.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = dimensionPixelSize;
        OSIconTextView mIconTv3 = getMIconTv();
        Intrinsics.checkNotNull(mIconTv3);
        OSIconTextView mIconTv4 = getMIconTv();
        Intrinsics.checkNotNull(mIconTv4);
        mIconTv3.setLayoutParams(mIconTv4.getLayoutParams());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) parent;
            viewGroup.setClipChildren(false);
            viewGroup.setClipToPadding(false);
        }
        if (this.mUseDefaultInset) {
            setDefaultInset();
        }
    }

    @Override // com.transsion.widgetslib.view.liquid.effect.OSLiquidContainerRootLayoutInner, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        setShadowCorner(right - (left / 2));
    }

    public final void setIconText(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        OSIconTextView mIconTv = getMIconTv();
        Intrinsics.checkNotNull(mIconTv);
        mIconTv.setText(string);
    }

    public final void setIconTextColor(int color) {
        this.mIconColor = color;
        OSIconTextView mIconTv = getMIconTv();
        Intrinsics.checkNotNull(mIconTv);
        mIconTv.setTextColor(this.mIconColor);
    }

    public final void setOnAnimationEndListener(f onAnimationEndListener) {
        this.mOnAnimationEndListener = onAnimationEndListener;
    }

    public final void setOnAnimationUpdateListener(g onAnimationUpdateListener) {
        this.mOnAnimationUpdateListener = onAnimationUpdateListener;
    }

    public final void setOnClickListener(h clickListener) {
        this.mClickListener = clickListener;
    }

    public final void setOnFabTouchListener(View.OnTouchListener touchListener) {
        this.mOnTouchListener = touchListener;
    }

    public final void setUseDefaultInset(boolean useDefaultInset) {
        this.mUseDefaultInset = useDefaultInset;
    }

    @Override // com.transsion.widgetslib.view.liquid.effect.OSLiquidContainerRootLayoutInner, android.view.View
    public void setVisibility(int visibility) {
        OSIconTextView mIconTv = getMIconTv();
        Intrinsics.checkNotNull(mIconTv);
        mIconTv.setVisibility(visibility);
        super.setVisibility(visibility);
    }

    public /* synthetic */ OSLiquidSpringFloatingOvalButton(Context context, AttributeSet attributeSet, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i8 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSLiquidSpringFloatingOvalButton(final Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mIconTv = LazyKt.lazy(new Function0<OSIconTextView>() { // from class: com.transsion.widgetsliquid.view.OSLiquidSpringFloatingOvalButton$mIconTv$2
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
        setClickable(true);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.OSLiquidFloatingOvalButton);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…LiquidFloatingOvalButton)");
        String string = typedArrayObtainStyledAttributes.getString(R.styleable.OSLiquidFloatingOvalButton_liquid_text_icon);
        this.isCustomColor = typedArrayObtainStyledAttributes.hasValue(R.styleable.OSLiquidFloatingOvalButton_liquid_background_color);
        this.mBackgroundColor = typedArrayObtainStyledAttributes.getColor(R.styleable.OSLiquidFloatingOvalButton_liquid_background_color, 0);
        this.mIconColor = typedArrayObtainStyledAttributes.getColor(R.styleable.OSLiquidFloatingOvalButton_liquid_text_color, j.e(getContext(), R.attr.os_icon_primary, R.color.os_icon_primary_hios));
        this.mUseDefaultInset = typedArrayObtainStyledAttributes.getBoolean(R.styleable.OSLiquidFloatingOvalButton_liquid_use_default_inset, true);
        float dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.OSLiquidFloatingOvalButton_liquid_text_size, getResources().getDimensionPixelSize(R.dimen.os_search_bar_icon_out_size));
        typedArrayObtainStyledAttributes.recycle();
        int i8 = 2;
        setGradientStrokePosition(new float[]{0.0f, 0.7f});
        if (this.isCustomColor) {
            setBrandColor(this.mBackgroundColor);
            setMixLevel(5);
        } else {
            setMixLevel(2);
        }
        addView(getMIconTv());
        OSIconTextView mIconTv = getMIconTv();
        Intrinsics.checkNotNull(mIconTv);
        mIconTv.setTextSize(0, dimensionPixelSize);
        ViewGroup.LayoutParams layoutParams = getMIconTv().getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        OSIconTextView mIconTv2 = getMIconTv();
        Intrinsics.checkNotNull(mIconTv2);
        mIconTv2.setText(string);
        layoutParams2.gravity = 17;
        int i9 = (int) dimensionPixelSize;
        layoutParams2.width = i9;
        layoutParams2.height = i9;
        setWillNotDraw(false);
        setIconTextColor(this.mIconColor);
        e eVar = new e();
        eVar.f6154a = 1.25f;
        eVar.f6155b = 250.0f;
        eVar.f6156c = 250.0f;
        eVar.f6157d = ANIMATION_START_PRESS_DAMPING_RATIO;
        eVar.e = ANIMATION_STOP_PRESS_DAMPING_RATIO;
        eVar.f = new FloatValueHolder();
        eVar.f6161j = new WeakReference(this);
        eVar.f6162k = new p(this);
        eVar.f6160i = new b4.f(this, i8);
        eVar.f6159h = new p(this);
        eVar.f6158g = new p(this);
        eVar.a();
    }
}
