package com.transsion.widgetsliquid.effect;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.widgetsliquid.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import pd.j;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\r\b\u0016\u0018\u0000  2\u00020\u0001:\u0003 !\"B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0014J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0018\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00072\b\b\u0002\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0007J\u000e\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0007J\u000e\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u0007J\u000e\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u0007J\u000e\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u0007R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/transsion/widgetsliquid/effect/OSMaskFrameLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "maskDrawable", "Lcom/transsion/widgetsliquid/effect/OSMaskDrawable;", "maskLayerPosition", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "drawMask", "drawMaskAfterSuper", "drawMaskBeforeSuper", "setFadeEffect", "height", "strength", "", "setMaskColor", TypedValues.Custom.S_COLOR, "setMaskHeight", "fadeHeight", "setMaskLayerPosition", "position", "setMaskPosition", "setMaskVisibility", "visibility", "Companion", "OSMASKLAYERPOSITION", "OSMASKPOSITION", "widgetsliquid_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@SourceDebugExtension({"SMAP\nOSMaskFrameLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OSMaskFrameLayout.kt\ncom/transsion/widgetsliquid/effect/OSMaskFrameLayout\n+ 2 ContextFunc.kt\ncom/transsion/widgetslib/util/ContextFuncKt\n*L\n1#1,138:1\n13#2,9:139\n*S KotlinDebug\n*F\n+ 1 OSMaskFrameLayout.kt\ncom/transsion/widgetsliquid/effect/OSMaskFrameLayout\n*L\n36#1:139,9\n*E\n"})
public class OSMaskFrameLayout extends FrameLayout {
    public static final int OS_MASK_LAYER_POSITION_BOTTOM = 1;
    public static final int OS_MASK_LAYER_POSITION_TOP = 0;
    private final OSMaskDrawable maskDrawable;
    private int maskLayerPosition;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/transsion/widgetsliquid/effect/OSMaskFrameLayout$OSMASKLAYERPOSITION;", "", "widgetsliquid_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface OSMASKLAYERPOSITION {
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/transsion/widgetsliquid/effect/OSMaskFrameLayout$OSMASKPOSITION;", "", "widgetsliquid_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface OSMASKPOSITION {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSMaskFrameLayout(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void drawMask(Canvas canvas) {
        this.maskDrawable.setBounds(0, 0, getWidth(), getHeight());
        this.maskDrawable.draw(canvas);
    }

    private final void drawMaskAfterSuper(Canvas canvas) {
        super.dispatchDraw(canvas);
        drawMask(canvas);
    }

    private final void drawMaskBeforeSuper(Canvas canvas) {
        drawMask(canvas);
        super.dispatchDraw(canvas);
    }

    public static /* synthetic */ void setFadeEffect$default(OSMaskFrameLayout oSMaskFrameLayout, int i8, float f, int i9, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setFadeEffect");
        }
        if ((i9 & 2) != 0) {
            f = 1.0f;
        }
        oSMaskFrameLayout.setFadeEffect(i8, f);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.maskLayerPosition == 1) {
            drawMaskBeforeSuper(canvas);
        } else {
            drawMaskAfterSuper(canvas);
        }
    }

    public final void setFadeEffect(int height, float strength) {
        this.maskDrawable.setFadeEffect(height, strength);
        invalidate();
    }

    public final void setMaskColor(int color) {
        this.maskDrawable.setMaskColor(color);
        invalidate();
    }

    public final void setMaskHeight(int fadeHeight) {
        this.maskDrawable.setMaskHeight(fadeHeight);
        invalidate();
    }

    public final void setMaskLayerPosition(int position) {
        if (position != this.maskLayerPosition) {
            this.maskLayerPosition = position;
            invalidate();
        }
    }

    public final void setMaskPosition(int position) {
        this.maskDrawable.setMaskPosition(position);
        invalidate();
    }

    public final void setMaskVisibility(int visibility) {
        this.maskDrawable.setMaskVisibility(visibility);
        invalidate();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSMaskFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ OSMaskFrameLayout(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? 0 : i8);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSMaskFrameLayout(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.checkNotNullParameter(context, "context");
        this.maskLayerPosition = 1;
        OSMaskDrawable oSMaskDrawable = new OSMaskDrawable(context);
        this.maskDrawable = oSMaskDrawable;
        setWillNotDraw(false);
        int[] OSMaskFrameLayout = R.styleable.OSMaskFrameLayout;
        Intrinsics.checkNotNullExpressionValue(OSMaskFrameLayout, "OSMaskFrameLayout");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, OSMaskFrameLayout, 0, 0);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        int color = typedArrayObtainStyledAttributes.getColor(R.styleable.OSMaskFrameLayout_os_mask_color, j.d(R.attr.os_bg_primary, context.getColor(R.color.os_bg_primary_hios), context));
        int i9 = typedArrayObtainStyledAttributes.getInt(R.styleable.OSMaskFrameLayout_os_mask_position, 1);
        this.maskLayerPosition = typedArrayObtainStyledAttributes.getInt(R.styleable.OSMaskFrameLayout_os_mask_layer_position, 1);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.OSMaskFrameLayout_os_mask_length, context.getResources().getDimensionPixelSize(R.dimen.os_liquid_mask_length));
        oSMaskDrawable.setMaskScene(typedArrayObtainStyledAttributes.getInt(R.styleable.OSMaskFrameLayout_os_mask_scene, 0));
        oSMaskDrawable.setMaskColor(color);
        oSMaskDrawable.setMaskPosition(i9);
        oSMaskDrawable.setMaskHeight(dimensionPixelSize);
        typedArrayObtainStyledAttributes.recycle();
    }
}
