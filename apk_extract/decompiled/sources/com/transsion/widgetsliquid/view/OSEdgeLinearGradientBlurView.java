package com.transsion.widgetsliquid.view;

import android.content.Context;
import android.graphics.RenderEffect;
import android.graphics.RuntimeShader;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.widgetsliquid.R;
import com.transsion.widgetsliquid.utils.Utils;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0014J(\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0007H\u0014J\u001c\u0010!\u001a\u00020\u00192\b\u0010\"\u001a\u0004\u0018\u00010\u00012\b\u0010#\u001a\u0004\u0018\u00010\u000fH\u0003J\u0018\u0010$\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0007H\u0002J\u000e\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\r8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u00020\r8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/transsion/widgetsliquid/view/OSEdgeLinearGradientBlurView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "LINEAR_GRADIENT_SHADER", "", "hBlurShader", "Landroid/graphics/RuntimeShader;", "linearGradientBlurEffect", "Landroid/graphics/RenderEffect;", "getLinearGradientBlurEffect", "()Landroid/graphics/RenderEffect;", "setLinearGradientBlurEffect", "(Landroid/graphics/RenderEffect;)V", "mDefaultSize", "maxBlurRadius", "", "vBlurShader", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "onSizeChanged", "w", "h", "oldw", "oldh", "setBackdropRenderEffect", "view", "renderEffect", "setBackdropRuntimeEffect", "setMaxBlurRadius", "radius", "widgetsliquid_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class OSEdgeLinearGradientBlurView extends View {
    private final String LINEAR_GRADIENT_SHADER;

    @RequiresApi(33)
    private final RuntimeShader hBlurShader;
    private RenderEffect linearGradientBlurEffect;
    private int mDefaultSize;
    private float maxBlurRadius;

    @RequiresApi(33)
    private final RuntimeShader vBlurShader;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSEdgeLinearGradientBlurView(Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @RequiresApi(31)
    private final void setBackdropRenderEffect(View view, RenderEffect renderEffect) {
        try {
            View.class.getDeclaredMethod("setBackdropRenderEffectWrapper", RenderEffect.class).invoke(view, renderEffect);
        } catch (Exception e) {
            Log.e("ddd", "reflect call setBackdropRenderEffect fail:", e);
        }
    }

    private final void setBackdropRuntimeEffect(int w8, int h9) {
        if (Utils.INSTANCE.getIS_AFTER_1610() && this.linearGradientBlurEffect == null) {
            this.vBlurShader.setFloatUniform("u_maxRadius", this.maxBlurRadius);
            this.vBlurShader.setFloatUniform("u_blurDirection", 0.0f, 1.0f);
            this.vBlurShader.setFloatUniform("u_gradientStart", 0.0f, getMeasuredHeight());
            this.vBlurShader.setFloatUniform("u_gradientEnd", 0.0f, 0.0f);
            this.hBlurShader.setFloatUniform("u_maxRadius", this.maxBlurRadius);
            this.hBlurShader.setFloatUniform("u_blurDirection", 1.0f, 0.0f);
            this.hBlurShader.setFloatUniform("u_gradientStart", 0.0f, getMeasuredHeight());
            this.hBlurShader.setFloatUniform("u_gradientEnd", 0.0f, 0.0f);
            float f = w8 * 1.0f;
            float f4 = h9 * 1.0f;
            this.hBlurShader.setFloatUniform("u_size", f, f4);
            this.vBlurShader.setFloatUniform("u_size", f, f4);
            RenderEffect renderEffectCreateRuntimeShaderEffect = RenderEffect.createRuntimeShaderEffect(this.vBlurShader, "inputImage");
            Intrinsics.checkNotNullExpressionValue(renderEffectCreateRuntimeShaderEffect, "createRuntimeShaderEffec…BlurShader, \"inputImage\")");
            RenderEffect renderEffectCreateRuntimeShaderEffect2 = RenderEffect.createRuntimeShaderEffect(this.hBlurShader, "inputImage");
            Intrinsics.checkNotNullExpressionValue(renderEffectCreateRuntimeShaderEffect2, "createRuntimeShaderEffec…BlurShader, \"inputImage\")");
            RenderEffect renderEffectCreateChainEffect = RenderEffect.createChainEffect(renderEffectCreateRuntimeShaderEffect2, renderEffectCreateRuntimeShaderEffect);
            this.linearGradientBlurEffect = renderEffectCreateChainEffect;
            setBackdropRenderEffect(this, renderEffectCreateChainEffect);
        }
    }

    public final RenderEffect getLinearGradientBlurEffect() {
        return this.linearGradientBlurEffect;
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (View.MeasureSpec.getMode(heightMeasureSpec) == Integer.MIN_VALUE || View.MeasureSpec.getMode(heightMeasureSpec) == 0) {
            heightMeasureSpec = getPaddingBottom() + getPaddingTop() + View.MeasureSpec.makeMeasureSpec(this.mDefaultSize, BasicMeasure.EXACTLY);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override // android.view.View
    public void onSizeChanged(int w8, int h9, int oldw, int oldh) {
        super.onSizeChanged(w8, h9, oldw, oldh);
        setBackdropRuntimeEffect(w8, h9);
    }

    public final void setLinearGradientBlurEffect(RenderEffect renderEffect) {
        this.linearGradientBlurEffect = renderEffect;
    }

    public final void setMaxBlurRadius(float radius) {
        this.maxBlurRadius = RangesKt.coerceAtLeast(radius, 0.0f);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSEdgeLinearGradientBlurView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSEdgeLinearGradientBlurView(Context context, AttributeSet attributeSet, int i8) {
        this(context, attributeSet, i8, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ OSEdgeLinearGradientBlurView(Context context, AttributeSet attributeSet, int i8, int i9, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i10 & 2) != 0 ? null : attributeSet, (i10 & 4) != 0 ? 0 : i8, (i10 & 8) != 0 ? 0 : i9);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSEdgeLinearGradientBlurView(Context context, AttributeSet attributeSet, int i8, int i9) {
        super(context, attributeSet, i8, i9);
        Intrinsics.checkNotNullParameter(context, "context");
        this.maxBlurRadius = 50.0f;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext()");
        String rawTextFile = Utils.readRawTextFile(context2, R.raw.lineargradient_blur);
        this.LINEAR_GRADIENT_SHADER = rawTextFile;
        this.vBlurShader = new RuntimeShader(rawTextFile);
        this.hBlurShader = new RuntimeShader(rawTextFile);
        this.mDefaultSize = context.getResources().getDimensionPixelSize(R.dimen.os_list_edge_blur_length);
    }
}
