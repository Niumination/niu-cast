package com.transsion.widgetslib.view.liquid.effect;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.MarginLayoutParamsCompat;
import com.transsion.widgetslib.R$dimen;
import com.transsion.widgetslib.R$id;
import com.transsion.widgetslib.R$styleable;
import com.transsion.widgetslib.widget.OsPressSmoothCornerDrawable;
import hd.a;
import jd.i;
import k3.z8;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import pd.j;
import se.e;
import wd.d;
import wd.f;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 \u0099\u00012\u00020\u0001:\u0004\u009a\u0001\u009b\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u0006¢\u0006\u0004\b\u001c\u0010\u0017J\u001f\u0010 \u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001dH\u0007¢\u0006\u0004\b \u0010!J\u001d\u0010%\u001a\u00020\f2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u001d¢\u0006\u0004\b%\u0010&J7\u0010,\u001a\u00020\f2\u0006\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u0006H\u0014¢\u0006\u0004\b,\u0010-J\u0015\u0010/\u001a\u00020\f2\u0006\u0010.\u001a\u00020\u0018¢\u0006\u0004\b/\u00100J\u0017\u00102\u001a\u00020\f2\b\b\u0001\u00101\u001a\u00020\u0006¢\u0006\u0004\b2\u0010\u0017J\u0015\u00104\u001a\u00020\f2\u0006\u00103\u001a\u00020\u0018¢\u0006\u0004\b4\u00100J\u0015\u00106\u001a\u00020\f2\u0006\u00105\u001a\u00020\u0018¢\u0006\u0004\b6\u00100J\u001b\u00109\u001a\u00020\f2\f\u00108\u001a\b\u0012\u0004\u0012\u00020\f07¢\u0006\u0004\b9\u0010:J\u0015\u0010<\u001a\u00020\f2\u0006\u0010;\u001a\u00020\u0018¢\u0006\u0004\b<\u00100J\r\u0010=\u001a\u00020\f¢\u0006\u0004\b=\u0010>J\r\u0010?\u001a\u00020\f¢\u0006\u0004\b?\u0010>J\u0017\u0010B\u001a\u00020\f2\u0006\u0010A\u001a\u00020@H\u0014¢\u0006\u0004\bB\u0010CJ\u0017\u0010E\u001a\u00020\f2\u0006\u0010D\u001a\u00020\u0006H\u0016¢\u0006\u0004\bE\u0010\u0017J\u0015\u0010G\u001a\u00020\f2\u0006\u0010F\u001a\u00020\u0006¢\u0006\u0004\bG\u0010\u0017J\u0015\u0010I\u001a\u00020\f2\u0006\u0010H\u001a\u00020\n¢\u0006\u0004\bI\u0010JJ\u001f\u0010M\u001a\u00020\f2\u0006\u0010K\u001a\u00020\u00062\u0006\u0010L\u001a\u00020\u0006H\u0014¢\u0006\u0004\bM\u0010NJ\u0017\u0010P\u001a\u00020\f2\u0006\u0010O\u001a\u00020\u0006H\u0007¢\u0006\u0004\bP\u0010\u0017J\u0015\u0010R\u001a\u00020\f2\u0006\u0010Q\u001a\u00020\u0006¢\u0006\u0004\bR\u0010\u0017J\u0017\u0010T\u001a\u00020\f2\u0006\u0010S\u001a\u00020\nH\u0007¢\u0006\u0004\bT\u0010JJ\u0015\u0010V\u001a\u00020\f2\u0006\u0010U\u001a\u00020\n¢\u0006\u0004\bV\u0010JJ\u0017\u0010X\u001a\u00020\f2\u0006\u0010W\u001a\u00020\nH\u0007¢\u0006\u0004\bX\u0010JJ\u0015\u0010Z\u001a\u00020\f2\u0006\u0010Y\u001a\u00020\n¢\u0006\u0004\bZ\u0010JJ\u0015\u0010\\\u001a\u00020\f2\u0006\u0010[\u001a\u00020\n¢\u0006\u0004\b\\\u0010JJ\u0017\u0010]\u001a\u00020\f2\u0006\u0010S\u001a\u00020\nH\u0007¢\u0006\u0004\b]\u0010JJ\u0017\u0010_\u001a\u00020\f2\u0006\u0010^\u001a\u00020\u0006H\u0007¢\u0006\u0004\b_\u0010\u0017J\u0017\u0010a\u001a\u00020\f2\u0006\u0010`\u001a\u00020\u0018H\u0007¢\u0006\u0004\ba\u00100J\u0017\u0010c\u001a\u00020\f2\u0006\u0010b\u001a\u00020\u0006H\u0007¢\u0006\u0004\bc\u0010\u0017J\u000f\u0010d\u001a\u00020\fH\u0014¢\u0006\u0004\bd\u0010>J\r\u0010f\u001a\u00020e¢\u0006\u0004\bf\u0010gJ\u0015\u0010h\u001a\u00020\f2\u0006\u0010U\u001a\u00020\n¢\u0006\u0004\bh\u0010JR\u0014\u0010j\u001a\u00020i8\u0002X\u0082D¢\u0006\u0006\n\u0004\bj\u0010kR\u0014\u0010m\u001a\u00020l8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bm\u0010nR\u0016\u0010o\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bo\u0010pR\u0016\u0010q\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010rR\u0016\u0010s\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010rR\u0016\u0010t\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bt\u0010rR\u0016\u0010u\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bu\u0010rR\u0014\u0010w\u001a\u00020v8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bw\u0010xR\u0016\u0010y\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\by\u0010rR\u0016\u0010z\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bz\u0010{R\u0014\u0010}\u001a\u00020|8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b}\u0010~R\u0014\u0010\u007f\u001a\u00020|8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u007f\u0010~R\u0016\u0010\u0080\u0001\u001a\u00020|8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0080\u0001\u0010~R\u0018\u0010\u0082\u0001\u001a\u00030\u0081\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R!\u0010\u0084\u0001\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0084\u0001\u0010\u0085\u0001R\u001c\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0086\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R\u001c\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u0086\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0089\u0001\u0010\u0088\u0001R\u001c\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008a\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008b\u0001\u0010\u008c\u0001R\u0018\u0010\u008d\u0001\u001a\u00020l8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008d\u0001\u0010nR\u0018\u0010\u008e\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008e\u0001\u0010{R\u001f\u0010\u0092\u0001\u001a\u00020e8BX\u0082\u0084\u0002¢\u0006\u000f\n\u0006\b\u008f\u0001\u0010\u0090\u0001\u001a\u0005\b\u0091\u0001\u0010gR+\u0010\u0098\u0001\u001a\r \u0094\u0001*\u0005\u0018\u00010\u0093\u00010\u0093\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u0095\u0001\u0010\u0090\u0001\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001¨\u0006\u009c\u0001"}, d2 = {"Lcom/transsion/widgetslib/view/liquid/effect/OSLiquidContainerRootLayoutInner;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "addMoreViews", "", "addOsLiquidEffectViews", "(ZLandroid/util/AttributeSet;)V", "", "floatArray", "setGradientStrokePosition", "([F)V", "getMixLevel", "()I", "mixLevel", "setMixLevel", "(I)V", "", "getRoundRadius", "()F", "bgColor", "setFillBasicColor", "Landroid/graphics/BlendMode;", "basicBlendMode", "maskBlendMode", "setBgBlendMode", "(Landroid/graphics/BlendMode;Landroid/graphics/BlendMode;)V", "", TypedValues.Custom.S_COLOR, "strokeBlendMode", "setGradientStroke", "([ILandroid/graphics/BlendMode;)V", "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "corner", "setShadowCorner", "(F)V", "shadowColor", "setShadowColor", "progress", "updShadowColor", "dy", "setShadowDy", "Lkotlin/Function0;", "listener", "setOnLiquidClickListener", "(Lkotlin/jvm/functions/Function0;)V", "scaleRatio", "setScaleRatio", "detachPressAnim", "()V", "attachPressAnim", "Landroid/graphics/Canvas;", "canvas", "dispatchDraw", "(Landroid/graphics/Canvas;)V", "visibility", "setVisibility", "width", "setActualWidth", "showShadow", "setShowShadow", "(Z)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "blendColor", "setBlendColor", "defaultBgColor", "setDefaultBgColor", "nightMode", "setNightMode", "enable", "enableUnionBlur", "showBlenderColor", "setShowBlenderColor", "showBlenderColor2", "setShowBlenderColor2", "showOutline", "setShowOutline", "setBlurNightMode", "brandColor", "setBrandColor", "blurRadius", "setBlurRadius", "level", "setDialogMixLevel", "onDetachedFromWindow", "Lcom/transsion/widgetslib/widget/OsPressSmoothCornerDrawable;", "getOsPressView", "()Lcom/transsion/widgetslib/widget/OsPressSmoothCornerDrawable;", "enabledPressView", "", "TAG", "Ljava/lang/String;", "Landroid/graphics/RectF;", "mRectF", "Landroid/graphics/RectF;", "mShadowColor", "I", "mShadowAlphaProgress", "F", "mShadowRadius", "mShadowRadiusBC", "mShadowDy", "Landroid/graphics/Path;", "mRoundPath", "Landroid/graphics/Path;", "cornerRadius", "mShowShadow", "Z", "Landroid/graphics/Paint;", "shadowPaint", "Landroid/graphics/Paint;", "bitmapPaint", "clearPaint", "Landroid/graphics/PorterDuffXfermode;", "clearPorterDuffXfermode", "Landroid/graphics/PorterDuffXfermode;", "onClickListener", "Lkotlin/jvm/functions/Function0;", "Lcom/transsion/widgetslib/view/liquid/effect/OSLiquidContainer;", "mLiquidEffectView", "Lcom/transsion/widgetslib/view/liquid/effect/OSLiquidContainer;", "mLiquidEffectView2", "Landroid/graphics/Bitmap;", "mCachedShadowBitmap", "Landroid/graphics/Bitmap;", "mShadowRect", "mAddMoreViews", "mOsPressSmoothCornerDrawable$delegate", "Lkotlin/Lazy;", "getMOsPressSmoothCornerDrawable", "mOsPressSmoothCornerDrawable", "Ljd/i;", "kotlin.jvm.PlatformType", "mOSSpringPressSealAnimation$delegate", "getMOSSpringPressSealAnimation", "()Ljd/i;", "mOSSpringPressSealAnimation", "Companion", "wd/d", "se/e", "widgetsLib_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@SourceDebugExtension({"SMAP\nOSLiquidContainerRootLayoutInner.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OSLiquidContainerRootLayoutInner.kt\ncom/transsion/widgetslib/view/liquid/effect/OSLiquidContainerRootLayoutInner\n+ 2 ContextFunc.kt\ncom/transsion/widgetslib/util/ContextFuncKt\n+ 3 ViewGroup.kt\nandroidx/core/view/ViewGroupKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 Bitmap.kt\nandroidx/core/graphics/BitmapKt\n+ 6 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,444:1\n13#2,9:445\n36#3:454\n36#3:455\n36#3:469\n36#3:470\n1#4:456\n90#5,6:457\n379#6,2:463\n392#6,2:465\n350#6:467\n368#6:468\n*S KotlinDebug\n*F\n+ 1 OSLiquidContainerRootLayoutInner.kt\ncom/transsion/widgetslib/view/liquid/effect/OSLiquidContainerRootLayoutInner\n*L\n86#1:445,9\n113#1:454\n128#1:455\n412#1:469\n421#1:470\n255#1:457,6\n312#1:463,2\n312#1:465,2\n313#1:467\n313#1:468\n*E\n"})
public class OSLiquidContainerRootLayoutInner extends FrameLayout {
    public static final d Companion = new d();
    public static final float LIQUID_SCALE_RATIO_BUTTON = 1.25f;
    public static final float LIQUID_SCALE_RATIO_CONTAINER = 1.05f;
    public static final int LIQUID_SHADOW_RADIUS_BC = 8;
    private final String TAG;
    private final Paint bitmapPaint;
    private final Paint clearPaint;
    private final PorterDuffXfermode clearPorterDuffXfermode;
    private float cornerRadius;
    private boolean mAddMoreViews;
    private Bitmap mCachedShadowBitmap;
    private OSLiquidContainer mLiquidEffectView;
    private OSLiquidContainer mLiquidEffectView2;

    /* JADX INFO: renamed from: mOSSpringPressSealAnimation$delegate, reason: from kotlin metadata */
    private final Lazy mOSSpringPressSealAnimation;

    /* JADX INFO: renamed from: mOsPressSmoothCornerDrawable$delegate, reason: from kotlin metadata */
    private final Lazy mOsPressSmoothCornerDrawable;
    private final RectF mRectF;
    private final Path mRoundPath;
    private float mShadowAlphaProgress;
    private int mShadowColor;
    private float mShadowDy;
    private float mShadowRadius;
    private float mShadowRadiusBC;
    private RectF mShadowRect;
    private boolean mShowShadow;
    private Function0<Unit> onClickListener;
    private final Paint shadowPaint;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSLiquidContainerRootLayoutInner(Context context) {
        this(context, null, 6, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final i getMOSSpringPressSealAnimation() {
        return (i) this.mOSSpringPressSealAnimation.getValue();
    }

    private final OsPressSmoothCornerDrawable getMOsPressSmoothCornerDrawable() {
        return (OsPressSmoothCornerDrawable) this.mOsPressSmoothCornerDrawable.getValue();
    }

    public final void addOsLiquidEffectViews(boolean addMoreViews, AttributeSet attrs) {
        removeAllViews();
        this.mAddMoreViews = addMoreViews;
        int i8 = 0;
        int i9 = 4;
        if (addMoreViews) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            OSLiquidContainer oSLiquidContainer = new OSLiquidContainer(context, attrs, i9, i8);
            new ViewGroup.LayoutParams(-1, -1);
            oSLiquidContainer.setBackground(null);
            this.mLiquidEffectView2 = oSLiquidContainer;
            Intrinsics.checkNotNull(oSLiquidContainer);
            if (indexOfChild(oSLiquidContainer) == -1) {
                addView(this.mLiquidEffectView2);
            }
        }
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        OSLiquidContainer oSLiquidContainer2 = new OSLiquidContainer(context2, attrs, i9, i8);
        oSLiquidContainer2.setId(R$id.os_liquid_auto_fill_id);
        new ViewGroup.LayoutParams(-1, -1);
        oSLiquidContainer2.setBackground(null);
        this.mLiquidEffectView = oSLiquidContainer2;
        Intrinsics.checkNotNull(oSLiquidContainer2);
        if (indexOfChild(oSLiquidContainer2) != -1) {
            return;
        }
        addView(this.mLiquidEffectView);
    }

    public final void attachPressAnim() {
        getMOSSpringPressSealAnimation().f6180w = false;
    }

    public final void detachPressAnim() {
        getMOSSpringPressSealAnimation().f6180w = true;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0049  */
    /* JADX WARN: Code duplicated, block: B:20:0x004d  */
    /* JADX WARN: Code duplicated, block: B:23:0x006b  */
    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Bitmap bitmap;
        Bitmap bitmapCreateBitmap;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.dispatchDraw(canvas);
        if (j.f8779t && this.mShowShadow) {
            if (!j.f8778s) {
                this.mShadowRadius = this.mShadowRadiusBC;
            }
            float fAbs = Math.abs(this.mShadowDy) + this.mShadowRadius;
            int width = getWidth();
            int height = getHeight();
            int i8 = (int) fAbs;
            Bitmap bitmap2 = this.mCachedShadowBitmap;
            if (bitmap2 == null) {
                bitmap = this.mCachedShadowBitmap;
                if (bitmap != null) {
                    bitmap.recycle();
                }
                int i9 = i8 * 2;
                bitmapCreateBitmap = Bitmap.createBitmap(getWidth() + i9, getHeight() + i9, Bitmap.Config.ARGB_8888);
                Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(width, height, config)");
                this.mCachedShadowBitmap = bitmapCreateBitmap;
                if (bitmapCreateBitmap != null) {
                    Canvas canvas2 = new Canvas(bitmapCreateBitmap);
                    String str = this.TAG;
                    int width2 = canvas2.getWidth();
                    int height2 = canvas2.getHeight();
                    int width3 = getWidth();
                    int height3 = getHeight();
                    StringBuilder sbR = o.d.r(width2, height2, "recreateShadowBitmap: mCachedCanvas.width = ", " mCachedCanvas.height = ", " canvas.width = ");
                    sbR.append(width3);
                    sbR.append(" canvas.height = ");
                    sbR.append(height3);
                    sbR.append(" shadowSize = ");
                    sbR.append(fAbs);
                    z8.b(str, sbR.toString());
                    canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
                    this.shadowPaint.setColor(0);
                    this.shadowPaint.setShadowLayer(this.mShadowRadius, 0.0f, this.mShadowDy, this.mShadowColor);
                    this.mShadowRect.set(fAbs, fAbs, bitmapCreateBitmap.getWidth() - fAbs, bitmapCreateBitmap.getHeight() - fAbs);
                    RectF rectF = this.mShadowRect;
                    float f = this.cornerRadius;
                    canvas2.drawRoundRect(rectF, f, f, this.shadowPaint);
                    this.clearPaint.setXfermode(this.clearPorterDuffXfermode);
                    RectF rectF2 = this.mShadowRect;
                    float f4 = this.cornerRadius;
                    canvas2.drawRoundRect(rectF2, f4, f4, this.clearPaint);
                }
            } else {
                int i10 = i8 * 2;
                int i11 = width + i10;
                int i12 = height + i10;
                Intrinsics.checkNotNull(bitmap2);
                if (bitmap2.getWidth() == i11) {
                    Bitmap bitmap3 = this.mCachedShadowBitmap;
                    Intrinsics.checkNotNull(bitmap3);
                    if (bitmap3.getHeight() != i12) {
                        bitmap = this.mCachedShadowBitmap;
                        if (bitmap != null) {
                            bitmap.recycle();
                        }
                        int i13 = i8 * 2;
                        bitmapCreateBitmap = Bitmap.createBitmap(getWidth() + i13, getHeight() + i13, Bitmap.Config.ARGB_8888);
                        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(width, height, config)");
                        this.mCachedShadowBitmap = bitmapCreateBitmap;
                        if (bitmapCreateBitmap != null) {
                            Canvas canvas3 = new Canvas(bitmapCreateBitmap);
                            String str2 = this.TAG;
                            int width4 = canvas3.getWidth();
                            int height4 = canvas3.getHeight();
                            int width5 = getWidth();
                            int height5 = getHeight();
                            StringBuilder sbR2 = o.d.r(width4, height4, "recreateShadowBitmap: mCachedCanvas.width = ", " mCachedCanvas.height = ", " canvas.width = ");
                            sbR2.append(width5);
                            sbR2.append(" canvas.height = ");
                            sbR2.append(height5);
                            sbR2.append(" shadowSize = ");
                            sbR2.append(fAbs);
                            z8.b(str2, sbR2.toString());
                            canvas3.drawColor(0, PorterDuff.Mode.CLEAR);
                            this.shadowPaint.setColor(0);
                            this.shadowPaint.setShadowLayer(this.mShadowRadius, 0.0f, this.mShadowDy, this.mShadowColor);
                            this.mShadowRect.set(fAbs, fAbs, bitmapCreateBitmap.getWidth() - fAbs, bitmapCreateBitmap.getHeight() - fAbs);
                            RectF rectF3 = this.mShadowRect;
                            float f10 = this.cornerRadius;
                            canvas3.drawRoundRect(rectF3, f10, f10, this.shadowPaint);
                            this.clearPaint.setXfermode(this.clearPorterDuffXfermode);
                            RectF rectF4 = this.mShadowRect;
                            float f11 = this.cornerRadius;
                            canvas3.drawRoundRect(rectF4, f11, f11, this.clearPaint);
                        }
                    }
                } else {
                    bitmap = this.mCachedShadowBitmap;
                    if (bitmap != null) {
                        bitmap.recycle();
                    }
                    int i14 = i8 * 2;
                    bitmapCreateBitmap = Bitmap.createBitmap(getWidth() + i14, getHeight() + i14, Bitmap.Config.ARGB_8888);
                    Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(width, height, config)");
                    this.mCachedShadowBitmap = bitmapCreateBitmap;
                    if (bitmapCreateBitmap != null) {
                        Canvas canvas4 = new Canvas(bitmapCreateBitmap);
                        String str3 = this.TAG;
                        int width6 = canvas4.getWidth();
                        int height6 = canvas4.getHeight();
                        int width7 = getWidth();
                        int height7 = getHeight();
                        StringBuilder sbR3 = o.d.r(width6, height6, "recreateShadowBitmap: mCachedCanvas.width = ", " mCachedCanvas.height = ", " canvas.width = ");
                        sbR3.append(width7);
                        sbR3.append(" canvas.height = ");
                        sbR3.append(height7);
                        sbR3.append(" shadowSize = ");
                        sbR3.append(fAbs);
                        z8.b(str3, sbR3.toString());
                        canvas4.drawColor(0, PorterDuff.Mode.CLEAR);
                        this.shadowPaint.setColor(0);
                        this.shadowPaint.setShadowLayer(this.mShadowRadius, 0.0f, this.mShadowDy, this.mShadowColor);
                        this.mShadowRect.set(fAbs, fAbs, bitmapCreateBitmap.getWidth() - fAbs, bitmapCreateBitmap.getHeight() - fAbs);
                        RectF rectF5 = this.mShadowRect;
                        float f12 = this.cornerRadius;
                        canvas4.drawRoundRect(rectF5, f12, f12, this.shadowPaint);
                        this.clearPaint.setXfermode(this.clearPorterDuffXfermode);
                        RectF rectF6 = this.mShadowRect;
                        float f13 = this.cornerRadius;
                        canvas4.drawRoundRect(rectF6, f13, f13, this.clearPaint);
                    }
                }
            }
            Bitmap bitmap4 = this.mCachedShadowBitmap;
            if (bitmap4 != null) {
                if (bitmap4.isRecycled()) {
                    bitmap4 = null;
                }
                if (bitmap4 != null) {
                    float f14 = -fAbs;
                    canvas.drawBitmap(bitmap4, f14, f14, this.bitmapPaint);
                }
            }
        }
    }

    public final void enableUnionBlur(boolean enable) {
        OSLiquidContainer oSLiquidContainer = this.mLiquidEffectView;
        if (oSLiquidContainer == null) {
            return;
        }
        oSLiquidContainer.setUseUnionBlur(enable);
    }

    public final void enabledPressView(boolean enable) {
        if (!enable) {
            if (indexOfChild(getMOsPressSmoothCornerDrawable()) != -1) {
                removeView(getMOsPressSmoothCornerDrawable());
            }
        } else {
            if (indexOfChild(getMOsPressSmoothCornerDrawable()) == -1) {
                if (this.mAddMoreViews) {
                    addView(getMOsPressSmoothCornerDrawable(), 2);
                } else {
                    addView(getMOsPressSmoothCornerDrawable(), 1);
                }
            }
            getMOsPressSmoothCornerDrawable().setVisibility(0);
        }
    }

    public final int getMixLevel() {
        OSLiquidContainer oSLiquidContainer = this.mLiquidEffectView;
        if (oSLiquidContainer != null) {
            return oSLiquidContainer.getQ();
        }
        return 0;
    }

    public final OsPressSmoothCornerDrawable getOsPressView() {
        return getMOsPressSmoothCornerDrawable();
    }

    /* JADX INFO: renamed from: getRoundRadius, reason: from getter */
    public final float getCornerRadius() {
        return this.cornerRadius;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Bitmap bitmap = this.mCachedShadowBitmap;
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.mCachedShadowBitmap = null;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        this.mRectF.set(0.0f, 0.0f, getWidth(), getHeight());
        Path path = this.mRoundPath;
        RectF rectF = this.mRectF;
        float f = this.mShadowRadius;
        path.addRoundRect(rectF, f, f, Path.Direction.CW);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        ViewGroup.LayoutParams layoutParams;
        if (getChildCount() <= 0) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        int childCount = getChildCount();
        int marginEnd = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            View child = getChildAt(i9);
            if (!(child instanceof OSLiquidContainer) && !(child instanceof OsPressSmoothCornerDrawable)) {
                measureChild(child, widthMeasureSpec, heightMeasureSpec);
                int measuredWidth = child.getMeasuredWidth();
                int measuredHeight = child.getMeasuredHeight();
                int iCoerceAtLeast = RangesKt.coerceAtLeast(marginEnd, measuredWidth);
                Intrinsics.checkNotNullExpressionValue(child, "child");
                ViewGroup.LayoutParams layoutParams2 = child.getLayoutParams();
                int marginStart = iCoerceAtLeast + (layoutParams2 instanceof ViewGroup.MarginLayoutParams ? MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams) layoutParams2) : 0);
                ViewGroup.LayoutParams layoutParams3 = child.getLayoutParams();
                marginEnd = marginStart + (layoutParams3 instanceof ViewGroup.MarginLayoutParams ? MarginLayoutParamsCompat.getMarginEnd((ViewGroup.MarginLayoutParams) layoutParams3) : 0);
                int iCoerceAtLeast2 = RangesKt.coerceAtLeast(i8, measuredHeight);
                ViewGroup.LayoutParams layoutParams4 = child.getLayoutParams();
                ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams4 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams4 : null;
                int i10 = iCoerceAtLeast2 + (marginLayoutParams != null ? marginLayoutParams.topMargin : 0);
                ViewGroup.LayoutParams layoutParams5 = child.getLayoutParams();
                ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams5 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams5 : null;
                i8 = i10 + (marginLayoutParams2 != null ? marginLayoutParams2.bottomMargin : 0);
            }
        }
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
        if (mode == Integer.MIN_VALUE) {
            widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(marginEnd, BasicMeasure.EXACTLY);
        }
        if (mode2 == Integer.MIN_VALUE) {
            heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(i8, BasicMeasure.EXACTLY);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        OSLiquidContainer oSLiquidContainer = this.mLiquidEffectView;
        if (oSLiquidContainer == null || (layoutParams = oSLiquidContainer.getLayoutParams()) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(layoutParams, "layoutParams");
        if (layoutParams.width == getMeasuredWidth() && layoutParams.height == getMeasuredHeight()) {
            return;
        }
        layoutParams.width = getMeasuredWidth();
        layoutParams.height = getMeasuredHeight();
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public final void setActualWidth(int width) {
        OSLiquidContainer oSLiquidContainer = this.mLiquidEffectView;
        if (oSLiquidContainer != null) {
            oSLiquidContainer.setActualWidth(width);
        }
    }

    @RequiresApi(29)
    public final void setBgBlendMode(BlendMode basicBlendMode, BlendMode maskBlendMode) {
        Intrinsics.checkNotNullParameter(basicBlendMode, "basicBlendMode");
        Intrinsics.checkNotNullParameter(maskBlendMode, "maskBlendMode");
        OSLiquidContainer oSLiquidContainer = this.mLiquidEffectView;
        if (oSLiquidContainer != null) {
            Intrinsics.checkNotNullParameter(basicBlendMode, "basicBlendMode");
            Intrinsics.checkNotNullParameter(maskBlendMode, "maskBlendMode");
            oSLiquidContainer.setBackdrop(oSLiquidContainer.f3322h);
        }
        invalidate();
    }

    @RequiresApi(31)
    public final void setBlendColor(int blendColor) {
        OSLiquidContainer oSLiquidContainer = this.mLiquidEffectView;
        if (oSLiquidContainer != null) {
            oSLiquidContainer.setBackdrop(blendColor);
        }
    }

    @RequiresApi(31)
    public final void setBlurNightMode(boolean nightMode) {
        z8.b(null, getContext().getPackageName() + " setBlurNightMode = " + nightMode + ".");
        OSLiquidContainer oSLiquidContainer = this.mLiquidEffectView;
        if (oSLiquidContainer != null) {
            oSLiquidContainer.setBlurNightMode(nightMode);
        }
    }

    @RequiresApi(31)
    public final void setBlurRadius(float blurRadius) {
        z8.b(null, getContext().getPackageName() + " setBlurRadius = " + blurRadius + ".");
        OSLiquidContainer oSLiquidContainer = this.mLiquidEffectView;
        if (oSLiquidContainer != null) {
            oSLiquidContainer.setBlurRadius(blurRadius);
        }
    }

    @RequiresApi(31)
    public final void setBrandColor(int brandColor) {
        z8.b(null, getContext().getPackageName() + " setBrandColor = " + brandColor + ".");
        OSLiquidContainer oSLiquidContainer = this.mLiquidEffectView;
        if (oSLiquidContainer != null) {
            oSLiquidContainer.setBrandColor(brandColor);
        }
    }

    public final void setDefaultBgColor(int defaultBgColor) {
        OSLiquidContainer oSLiquidContainer = this.mLiquidEffectView;
        if (oSLiquidContainer != null) {
            oSLiquidContainer.setDefaultBgColor(defaultBgColor);
        }
    }

    @RequiresApi(31)
    public final void setDialogMixLevel(int level) {
        OSLiquidContainer oSLiquidContainer = this.mLiquidEffectView;
        if (oSLiquidContainer != null) {
            oSLiquidContainer.setLiquidLevel(level);
        }
    }

    public final void setFillBasicColor(int bgColor) {
        OSLiquidContainer oSLiquidContainer = this.mLiquidEffectView;
        if (oSLiquidContainer != null) {
            oSLiquidContainer.setFillColor(bgColor);
        }
        invalidate();
    }

    public final void setGradientStroke(int[] color, BlendMode strokeBlendMode) {
        Intrinsics.checkNotNullParameter(color, "color");
        Intrinsics.checkNotNullParameter(strokeBlendMode, "strokeBlendMode");
        OSLiquidContainer oSLiquidContainer = this.mLiquidEffectView;
        if (oSLiquidContainer != null) {
            oSLiquidContainer.setGradientStrokeColor(color);
        }
        OSLiquidContainer oSLiquidContainer2 = this.mLiquidEffectView;
        if (oSLiquidContainer2 != null) {
            oSLiquidContainer2.setStrokeBlendMode(strokeBlendMode);
        }
        invalidate();
    }

    public final void setGradientStrokePosition(float[] floatArray) {
        Intrinsics.checkNotNullParameter(floatArray, "floatArray");
        OSLiquidContainer oSLiquidContainer = this.mLiquidEffectView;
        if (oSLiquidContainer != null) {
            oSLiquidContainer.setPositionsLT(floatArray);
        }
        invalidate();
    }

    @RequiresApi(31)
    public final void setMixLevel(int mixLevel) {
        OSLiquidContainer oSLiquidContainer = this.mLiquidEffectView;
        if (oSLiquidContainer != null) {
            oSLiquidContainer.setMixLevel(mixLevel);
        }
    }

    @RequiresApi(31)
    public final void setNightMode(boolean nightMode) {
        OSLiquidContainer oSLiquidContainer = this.mLiquidEffectView;
        if (oSLiquidContainer != null) {
            oSLiquidContainer.setNightMode(nightMode);
        }
        invalidate();
    }

    public final void setOnLiquidClickListener(Function0<Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onClickListener = listener;
        getMOSSpringPressSealAnimation().setOnSpringClickListener(new e(this.onClickListener));
    }

    public final void setScaleRatio(float scaleRatio) {
        getMOSSpringPressSealAnimation().setEndValue(scaleRatio);
    }

    public final void setShadowColor(@ColorInt int shadowColor) {
        if (this.mShadowColor == shadowColor) {
            return;
        }
        this.mShadowColor = shadowColor;
        invalidate();
    }

    public final void setShadowCorner(float corner) {
        this.cornerRadius = corner;
        OSLiquidContainer oSLiquidContainer = this.mLiquidEffectView;
        if (oSLiquidContainer != null) {
            oSLiquidContainer.setRadius(corner);
        }
        invalidate();
    }

    public final void setShadowDy(float dy) {
        this.mShadowDy = dy;
        invalidate();
    }

    @RequiresApi(31)
    public final void setShowBlenderColor(boolean showBlenderColor) {
        z8.b(null, getContext().getPackageName() + " showBlenderColor = " + showBlenderColor + ".");
        OSLiquidContainer oSLiquidContainer = this.mLiquidEffectView;
        if (oSLiquidContainer != null) {
            oSLiquidContainer.setShowBlenderColor(showBlenderColor);
        }
    }

    public final void setShowBlenderColor2(boolean showBlenderColor2) {
        z8.b(null, getContext().getPackageName() + " setShowBlenderColor2 = " + showBlenderColor2 + ".");
        OSLiquidContainer oSLiquidContainer = this.mLiquidEffectView;
        if (oSLiquidContainer != null) {
            oSLiquidContainer.setShowBlenderColor2(showBlenderColor2);
        }
    }

    public final void setShowOutline(boolean showOutline) {
        z8.b(null, getContext().getPackageName() + " setShowOutline = " + showOutline + ".");
        OSLiquidContainer oSLiquidContainer = this.mLiquidEffectView;
        if (oSLiquidContainer != null) {
            oSLiquidContainer.setShowOutline(showOutline);
        }
    }

    public final void setShowShadow(boolean showShadow) {
        this.mShowShadow = showShadow;
        z8.b(null, getContext().getPackageName() + " showShadow = " + this.mShowShadow + ".");
        invalidate();
    }

    @Override // android.view.View
    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        OSLiquidContainer oSLiquidContainer = this.mLiquidEffectView;
        if (oSLiquidContainer == null) {
            return;
        }
        oSLiquidContainer.setVisibility(visibility);
    }

    public final void updShadowColor(float progress) {
        this.mShadowAlphaProgress = progress;
        invalidate();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSLiquidContainerRootLayoutInner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 4, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ OSLiquidContainerRootLayoutInner(Context context, AttributeSet attributeSet, int i8, int i9) {
        this(context, (i8 & 2) != 0 ? null : attributeSet, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSLiquidContainerRootLayoutInner(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.checkNotNullParameter(context, "context");
        this.TAG = "OSLiquidContainerRootLa";
        this.mRectF = new RectF();
        this.mShadowAlphaProgress = 1.0f;
        this.mRoundPath = new Path();
        this.cornerRadius = 90.0f;
        this.mShowShadow = true;
        this.shadowPaint = new Paint();
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        this.bitmapPaint = paint;
        this.clearPaint = new Paint();
        this.clearPorterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.mShadowRect = new RectF();
        this.mOsPressSmoothCornerDrawable = LazyKt.lazy(new f(context));
        this.mOSSpringPressSealAnimation = LazyKt.lazy(new wd.e(this));
        this.mShadowColor = 335544320;
        this.mShadowRadius = getContext().getResources().getDimensionPixelSize(R$dimen.os_liquid_shadow_radius);
        this.mShadowDy = getContext().getResources().getDimensionPixelSize(R$dimen.os_liquid_shadow_dy);
        Context context2 = getContext();
        String[] strArr = j.f8764a;
        this.mShadowRadiusBC = a.a(context2, 8);
        int[] OSLiquidContainer = R$styleable.OSLiquidContainer;
        Intrinsics.checkNotNullExpressionValue(OSLiquidContainer, "OSLiquidContainer");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, OSLiquidContainer, 0, 0);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        this.cornerRadius = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.OSLiquidContainer_os_liquid_radius, (int) (typedArrayObtainStyledAttributes.getResources().getDimensionPixelSize(R$dimen.os_liquid_fob_default_height) / 2.0f));
        this.mShowShadow = typedArrayObtainStyledAttributes.getBoolean(R$styleable.OSLiquidContainer_os_liquid_show_shadow, true);
        this.mShadowColor = typedArrayObtainStyledAttributes.getColor(R$styleable.OSLiquidContainer_os_liquid_shadow_color, this.mShadowColor);
        typedArrayObtainStyledAttributes.recycle();
        addOsLiquidEffectViews(false, attributeSet);
        setClickable(true);
        setBackground(null);
    }
}
