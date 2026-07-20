package com.transsion.widgetslib.view.liquid.effect;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.RenderEffect;
import android.graphics.Shader;
import android.os.Trace;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import com.transsion.widgetslib.R$attr;
import com.transsion.widgetslib.R$color;
import com.transsion.widgetslib.R$dimen;
import com.transsion.widgetslib.R$styleable;
import e9.a;
import e9.b;
import k3.z8;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import pd.j;
import wd.c;
import wd.g;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0011\u0010\rJ\u0017\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0016H\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u0012¢\u0006\u0004\b\u001b\u0010\u0015J\u0015\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u0006¢\u0006\u0004\b\u001d\u0010\rJ\u0015\u0010 \u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J\u0015\u0010$\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b$\u0010%J\u0015\u0010'\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u0006¢\u0006\u0004\b'\u0010\rJ\u0015\u0010)\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020(¢\u0006\u0004\b)\u0010*J\u0015\u0010+\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u0006¢\u0006\u0004\b+\u0010\rJ\u0017\u0010-\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u0016H\u0007¢\u0006\u0004\b-\u0010\u0019J\u0015\u0010/\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u0016¢\u0006\u0004\b/\u0010\u0019J\u0015\u00101\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u0016¢\u0006\u0004\b1\u0010\u0019J\u0017\u00103\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u0016H\u0007¢\u0006\u0004\b3\u0010\u0019J\u0017\u00104\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0016H\u0007¢\u0006\u0004\b4\u0010\u0019J\u0017\u00106\u001a\u00020\u000b2\u0006\u00105\u001a\u00020\u0006H\u0007¢\u0006\u0004\b6\u0010\rJ\u0017\u00107\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0006H\u0007¢\u0006\u0004\b7\u0010\rJ\u0017\u00108\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0006H\u0003¢\u0006\u0004\b8\u0010\rR*\u0010<\u001a\u00020\u00162\u0006\u00109\u001a\u00020\u00168\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010\u0019R\u001b\u0010D\u001a\u00020?8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR\u001b\u0010I\u001a\u00020E8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bF\u0010A\u001a\u0004\bG\u0010HR$\u0010M\u001a\u00020\u00062\u0006\u00109\u001a\u00020\u00068\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\bJ\u0010K\"\u0004\bL\u0010\r¨\u0006N"}, d2 = {"Lcom/transsion/widgetslib/view/liquid/effect/OSLiquidContainer;", "Landroid/view/View;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "level", "", "setMixLevel", "(I)V", "getMixLevel", "()I", "blendColor", "setBackdrop", "", "blurRadius", "setBlurRadius", "(F)V", "", "nightMode", "setNightMode", "(Z)V", "liquidRadius", "setRadius", TypedValues.Custom.S_COLOR, "setFillColor", "Landroid/graphics/BlendMode;", "blendMode", "setStrokeBlendMode", "(Landroid/graphics/BlendMode;)V", "", "floatArray", "setPositionsLT", "([F)V", "width", "setActualWidth", "", "setGradientStrokeColor", "([I)V", "setDefaultBgColor", "showBlenderColor", "setShowBlenderColor", "showBlenderColor2", "setShowBlenderColor2", "showOutline", "setShowOutline", "showBlur", "setShowBlur", "setBlurNightMode", "brandColor", "setBrandColor", "setLiquidLevel", "setUnionBackdrop", "value", "b", "Z", "isUseUnionBlur", "()Z", "setUseUnionBlur", "Le9/b;", "c", "Lkotlin/Lazy;", "getTranView", "()Le9/b;", "tranView", "Le9/a;", "d", "getUnionEffect", "()Le9/a;", "unionEffect", "j", "I", "setMDefaultBgColor", "mDefaultBgColor", "widgetsLib_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@SourceDebugExtension({"SMAP\nOSLiquidContainer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OSLiquidContainer.kt\ncom/transsion/widgetslib/view/liquid/effect/OSLiquidContainer\n+ 2 ContextFunc.kt\ncom/transsion/widgetslib/util/ContextFuncKt\n*L\n1#1,732:1\n13#2,8:733\n13#2,9:741\n21#2:750\n*S KotlinDebug\n*F\n+ 1 OSLiquidContainer.kt\ncom/transsion/widgetslib/view/liquid/effect/OSLiquidContainer\n*L\n83#1:733,8\n96#1:741,9\n83#1:750\n*E\n"})
public class OSLiquidContainer extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3318a;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public boolean isUseUnionBlur;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Lazy tranView;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final Lazy unionEffect;
    public final g e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f3322h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f3323i;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    public int mDefaultBgColor;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f3325k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f3326l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f3327m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f3328n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f3329o;
    public boolean p;
    public int q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f3330r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f3331s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f3332t;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSLiquidContainer(Context context) {
        this(context, null, 6, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static void e(OSLiquidContainer oSLiquidContainer, RenderEffect renderEffect) {
        try {
            View.class.getDeclaredMethod("setBackdropRenderEffectWrapper", RenderEffect.class).invoke(oSLiquidContainer, renderEffect);
        } catch (Exception e) {
            Log.e("ddd", "reflect call setBackdropRenderEffect fail:", e);
        }
    }

    private final void setMDefaultBgColor(int i8) {
        this.mDefaultBgColor = i8;
        this.e.setDefaultBgColor(i8);
        invalidate();
    }

    @RequiresApi(31)
    private final void setUnionBackdrop(int blendColor) {
        a unionEffect = getUnionEffect();
        unionEffect.getClass();
        String str = l9.a.f7348i;
        unionEffect.c(str, true).b(24.0f);
        a unionEffect2 = getUnionEffect();
        unionEffect2.getClass();
        unionEffect2.c(str, true).e();
        if (this.f3325k) {
            a unionEffect3 = getUnionEffect();
            int iOrdinal = BlendMode.COLOR_DODGE.ordinal();
            unionEffect3.getClass();
            unionEffect3.c(str, true).a(iOrdinal, blendColor, 0, 0, 0, 0);
        }
        boolean z2 = this.f3325k;
        String resourceName = null;
        String resourceName2 = getId() != -1 ? getResources().getResourceName(getId()) : null;
        if (getParent() != null) {
            Object parent = getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
            if (((View) parent).getId() != -1) {
                Resources resources = getResources();
                Object parent2 = getParent();
                Intrinsics.checkNotNull(parent2, "null cannot be cast to non-null type android.view.View");
                resourceName = resources.getResourceName(((View) parent2).getId());
            }
        }
        Log.d(this.f3318a, "setUnionBackdrop:mShowBlendColor:" + z2 + ",resourceName:" + resourceName2 + "," + resourceName);
    }

    public final void a(OSLiquidContainer oSLiquidContainer) {
        try {
            View.class.getDeclaredMethod("setBackdropRenderEffectWrapper", RenderEffect.class).invoke(oSLiquidContainer, null);
        } catch (Exception e) {
            Log.e(this.f3318a, "reflect call setBackdropRenderEffect fail:", e);
        }
    }

    public final void b(int i8, int i9) {
        RenderEffect renderEffectCreateColorFilterEffect = RenderEffect.createColorFilterEffect(new BlendModeColorFilter(i8, BlendMode.COLOR_DODGE));
        Intrinsics.checkNotNullExpressionValue(renderEffectCreateColorFilterEffect, "createColorFilterEffect(colorFilter1)");
        RenderEffect renderEffectCreateColorFilterEffect2 = RenderEffect.createColorFilterEffect(new BlendModeColorFilter(i9, BlendMode.SRC_OVER));
        Intrinsics.checkNotNullExpressionValue(renderEffectCreateColorFilterEffect2, "createColorFilterEffect(colorFilter2)");
        float f = this.f3329o;
        RenderEffect renderEffectCreateBlurEffect = RenderEffect.createBlurEffect(f, f, Shader.TileMode.CLAMP);
        Intrinsics.checkNotNullExpressionValue(renderEffectCreateBlurEffect, "createBlurEffect(mBlurRa…s, Shader.TileMode.CLAMP)");
        RenderEffect renderEffectCreateChainEffect = RenderEffect.createChainEffect(renderEffectCreateColorFilterEffect2, renderEffectCreateColorFilterEffect);
        Intrinsics.checkNotNullExpressionValue(renderEffectCreateChainEffect, "createChainEffect(renderEffect12, renderEffect1)");
        RenderEffect renderEffectCreateChainEffect2 = RenderEffect.createChainEffect(renderEffectCreateChainEffect, renderEffectCreateBlurEffect);
        Intrinsics.checkNotNullExpressionValue(renderEffectCreateChainEffect2, "createChainEffect(chainEffect1, blurEffect)");
        z8.b(this.f3318a, "setBackDropInner: mBlurRadius = " + this.f3329o);
        if (j.q && this.f3325k) {
            e(this, renderEffectCreateChainEffect2);
        } else {
            e(this, renderEffectCreateBlurEffect);
        }
    }

    public final void c(int i8, int i9, int i10) {
        RenderEffect renderEffectCreateColorFilterEffect = RenderEffect.createColorFilterEffect(new BlendModeColorFilter(i8, BlendMode.COLOR_BURN));
        Intrinsics.checkNotNullExpressionValue(renderEffectCreateColorFilterEffect, "createColorFilterEffect(colorFilter1)");
        RenderEffect renderEffectCreateColorFilterEffect2 = RenderEffect.createColorFilterEffect(new BlendModeColorFilter(i9, BlendMode.LUMINOSITY));
        Intrinsics.checkNotNullExpressionValue(renderEffectCreateColorFilterEffect2, "createColorFilterEffect(colorFilter2)");
        RenderEffect renderEffectCreateColorFilterEffect3 = RenderEffect.createColorFilterEffect(new BlendModeColorFilter(i10, BlendMode.SRC_OVER));
        Intrinsics.checkNotNullExpressionValue(renderEffectCreateColorFilterEffect3, "createColorFilterEffect(colorFilter3)");
        float f = this.f3329o;
        RenderEffect renderEffectCreateBlurEffect = RenderEffect.createBlurEffect(f, f, Shader.TileMode.CLAMP);
        Intrinsics.checkNotNullExpressionValue(renderEffectCreateBlurEffect, "createBlurEffect(mBlurRa…s, Shader.TileMode.CLAMP)");
        RenderEffect renderEffectCreateChainEffect = RenderEffect.createChainEffect(renderEffectCreateColorFilterEffect, renderEffectCreateColorFilterEffect2);
        Intrinsics.checkNotNullExpressionValue(renderEffectCreateChainEffect, "createChainEffect(renderEffect1, renderEffect12)");
        RenderEffect renderEffectCreateChainEffect2 = RenderEffect.createChainEffect(renderEffectCreateChainEffect, renderEffectCreateColorFilterEffect3);
        Intrinsics.checkNotNullExpressionValue(renderEffectCreateChainEffect2, "createChainEffect(chainEffect1, renderEffect13)");
        RenderEffect renderEffectCreateChainEffect3 = RenderEffect.createChainEffect(renderEffectCreateChainEffect2, renderEffectCreateBlurEffect);
        Intrinsics.checkNotNullExpressionValue(renderEffectCreateChainEffect3, "createChainEffect(chainEffect2, blurEffect)");
        z8.b(this.f3318a, "setBackDropInner: mBlurRadius = " + this.f3329o);
        if (j.q && this.f3325k) {
            e(this, renderEffectCreateChainEffect3);
        } else {
            e(this, renderEffectCreateBlurEffect);
        }
    }

    public final int d(int i8, boolean z2) {
        Log.d(this.f3318a, "setBCBackDropInner = " + i8 + " blurNightMode = " + z2);
        if (i8 == 0) {
            return j.e(getContext(), R$attr.os_liq_clear1_bc_light_attr, R$color.os_liquid_clear1_bc_color);
        }
        if (i8 == 1) {
            return z2 ? getContext().getColor(R$color.os_liquid_clear2_bc_night_color) : j.e(getContext(), R$attr.os_liq_clear2_bc_light_attr, R$color.os_liquid_clear2_bc_light_color);
        }
        if (i8 == 2) {
            return z2 ? getContext().getColor(R$color.os_liquid_small_bc_night_color) : j.e(getContext(), R$attr.os_liq_small_bc_light_attr, R$color.os_liquid_small_bc_light_color);
        }
        if (i8 == 3) {
            return z2 ? getContext().getColor(R$color.os_liquid_midle_bc_night_color) : j.e(getContext(), R$attr.os_liq_middle_bc_light_attr, R$color.os_liquid_midle_bc_light_color);
        }
        if (i8 != 4) {
            return i8 != 5 ? j.e(getContext(), R$attr.os_liq_clear1_bc_light_attr, R$color.os_liquid_clear1_bc_color) : this.f3331s;
        }
        return z2 ? getContext().getColor(R$color.os_liquid_big_bc_night_color) : j.e(getContext(), R$attr.os_liq_big_bc_light_attr, R$color.os_liquid_big_bc_light_color);
    }

    /* JADX INFO: renamed from: getMixLevel, reason: from getter */
    public final int getQ() {
        return this.q;
    }

    public final b getTranView() {
        return (b) this.tranView.getValue();
    }

    public final a getUnionEffect() {
        return (a) this.unionEffect.getValue();
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (j.f8776o) {
            boolean z2 = this.isUseUnionBlur;
            boolean z3 = this.f3332t;
            if (z2 || z3) {
                if (z3 && a.a() >= 2) {
                    a unionEffect = getUnionEffect();
                    unionEffect.getClass();
                    unionEffect.c(l9.a.f7352m, true).d();
                }
                b tranView = getTranView();
                a unionEffect2 = getUnionEffect();
                tranView.getClass();
                String str = l9.a.f7342a;
                tranView.a().a(this, unionEffect2);
            }
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        float width = getWidth();
        float height = getHeight();
        g gVar = this.e;
        gVar.getClass();
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (width == 0.0f || height == 0.0f) {
            return;
        }
        Trace.beginSection("GradientBorder");
        int i8 = gVar.f10718h;
        if (i8 != -1) {
            height = i8;
        }
        int i9 = gVar.f10717g;
        if (i9 != -1) {
            width = i9;
        }
        RectF rectF = gVar.f10716d;
        rectF.set(0.0f, 0.0f, width, height);
        boolean z2 = j.p;
        Paint paint = gVar.f;
        if (z2) {
            boolean z3 = j.f8776o;
            if (!z3) {
                paint.setColor(gVar.f10714b);
                float f = gVar.f10713a;
                canvas.drawRoundRect(rectF, f, f, paint);
            }
            Paint paint2 = gVar.e;
            if (z3) {
                paint2.setBlendMode(paint2.getBlendMode());
            } else {
                paint2.setBlendMode(null);
            }
            if (j.f8777r && gVar.f10715c) {
                paint2.setShader(gVar.f10721k);
                float f4 = gVar.f10713a;
                canvas.drawRoundRect(rectF, f4, f4, paint2);
            }
        } else {
            paint.setColor(gVar.f10714b);
            float f10 = gVar.f10713a;
            canvas.drawRoundRect(rectF, f10, f10, paint);
        }
        Trace.endSection();
    }

    @Override // android.view.View
    public final void onSizeChanged(int i8, int i9, int i10, int i11) {
        super.onSizeChanged(i8, i9, i10, i11);
        g gVar = this.e;
        gVar.getClass();
        double d7 = i8;
        double dAtan2 = Math.atan2(i9, d7);
        Log.d("OSLiquidDrawable", "degree: " + Math.toDegrees(dAtan2) + " radian:" + dAtan2);
        double dSin = Math.sin(dAtan2);
        double d10 = d7 * dSin * ((double) 1.0f);
        gVar.f10721k = new LinearGradient(0.0f, 0.0f, (float) (dSin * d10), (float) (d10 * Math.cos(dAtan2)), gVar.f10720j, gVar.f10719i, Shader.TileMode.MIRROR);
    }

    public final void setActualWidth(int width) {
        this.e.setActualWidth(width);
        invalidate();
    }

    @RequiresApi(31)
    public final void setBackdrop(int blendColor) {
        int color;
        int color2;
        int iOrdinal;
        int iOrdinal2;
        int i8;
        int color3;
        int color4;
        int color5;
        int iOrdinal3;
        this.f3322h = blendColor;
        if (j.f8776o && j.u && this.f3328n) {
            if (this.isUseUnionBlur) {
                a(this);
                setUnionBackdrop(blendColor);
                return;
            }
            boolean z2 = this.f3332t;
            String str = this.f3318a;
            if (!z2) {
                boolean z3 = this.p;
                int i9 = this.q;
                if (i9 == 0) {
                    b(getContext().getColor(R$color.os_liquid_clear1_color1), getContext().getColor(R$color.os_liquid_clear1_color2));
                    return;
                }
                if (i9 == 1) {
                    if (!z3) {
                        b(getContext().getColor(R$color.os_liquid_clear2_color1), getContext().getColor(R$color.os_liquid_clear2_color2));
                        return;
                    }
                    RenderEffect renderEffectCreateColorFilterEffect = RenderEffect.createColorFilterEffect(new BlendModeColorFilter(getContext().getColor(R$color.os_liquid_clear2_night_color1), BlendMode.LUMINOSITY));
                    Intrinsics.checkNotNullExpressionValue(renderEffectCreateColorFilterEffect, "createColorFilterEffect(colorFilter1)");
                    float f = this.f3329o;
                    RenderEffect renderEffectCreateBlurEffect = RenderEffect.createBlurEffect(f, f, Shader.TileMode.CLAMP);
                    Intrinsics.checkNotNullExpressionValue(renderEffectCreateBlurEffect, "createBlurEffect(mBlurRa…s, Shader.TileMode.CLAMP)");
                    RenderEffect renderEffectCreateChainEffect = RenderEffect.createChainEffect(renderEffectCreateColorFilterEffect, renderEffectCreateBlurEffect);
                    Intrinsics.checkNotNullExpressionValue(renderEffectCreateChainEffect, "createChainEffect(renderEffect1, blurEffect)");
                    z8.b(str, "setBackDropInner: mBlurRadius = " + this.f3329o);
                    if (j.q && this.f3325k) {
                        e(this, renderEffectCreateChainEffect);
                        return;
                    } else {
                        e(this, renderEffectCreateBlurEffect);
                        return;
                    }
                }
                if (i9 == 2) {
                    if (z3) {
                        c(getContext().getColor(R$color.os_liquid_small_night_color3), getContext().getColor(R$color.os_liquid_small_night_color2), getContext().getColor(R$color.os_liquid_small_night_color1));
                        return;
                    } else {
                        b(getContext().getColor(R$color.os_liquid_small_light_color1), getContext().getColor(R$color.os_liquid_small_light_color2));
                        return;
                    }
                }
                if (i9 == 3) {
                    if (z3) {
                        c(getContext().getColor(R$color.os_liquid_midle_night_color3), getContext().getColor(R$color.os_liquid_midle_night_color2), getContext().getColor(R$color.os_liquid_midle_night_color1));
                        return;
                    } else {
                        b(getContext().getColor(R$color.os_liquid_midle_light_color1), getContext().getColor(R$color.os_liquid_midle_light_color2));
                        return;
                    }
                }
                if (i9 == 4) {
                    if (z3) {
                        c(getContext().getColor(R$color.os_liquid_big_night_color3), getContext().getColor(R$color.os_liquid_big_night_color2), getContext().getColor(R$color.os_liquid_big_night_color1));
                        return;
                    } else {
                        b(getContext().getColor(R$color.os_liquid_big_light_color1), getContext().getColor(R$color.os_liquid_big_light_color2));
                        return;
                    }
                }
                if (i9 != 5) {
                    b(this.f3330r, blendColor);
                    return;
                }
                if (!z3) {
                    int color6 = getContext().getColor(R$color.os_liquid_brand_light_color1);
                    RenderEffect renderEffectCreateColorFilterEffect2 = RenderEffect.createColorFilterEffect(new BlendModeColorFilter((int) (((long) (this.f3331s & ViewCompat.MEASURED_SIZE_MASK)) | 3858759680L), BlendMode.DARKEN));
                    Intrinsics.checkNotNullExpressionValue(renderEffectCreateColorFilterEffect2, "createColorFilterEffect(colorFilter1)");
                    RenderEffect renderEffectCreateColorFilterEffect3 = RenderEffect.createColorFilterEffect(new BlendModeColorFilter(color6, BlendMode.LUMINOSITY));
                    Intrinsics.checkNotNullExpressionValue(renderEffectCreateColorFilterEffect3, "createColorFilterEffect(colorFilter2)");
                    float f4 = this.f3329o;
                    RenderEffect renderEffectCreateBlurEffect2 = RenderEffect.createBlurEffect(f4, f4, Shader.TileMode.CLAMP);
                    Intrinsics.checkNotNullExpressionValue(renderEffectCreateBlurEffect2, "createBlurEffect(mBlurRa…s, Shader.TileMode.CLAMP)");
                    RenderEffect renderEffectCreateChainEffect2 = RenderEffect.createChainEffect(renderEffectCreateColorFilterEffect2, renderEffectCreateColorFilterEffect3);
                    Intrinsics.checkNotNullExpressionValue(renderEffectCreateChainEffect2, "createChainEffect(renderEffect1, renderEffect12)");
                    RenderEffect renderEffectCreateChainEffect3 = RenderEffect.createChainEffect(renderEffectCreateChainEffect2, renderEffectCreateBlurEffect2);
                    Intrinsics.checkNotNullExpressionValue(renderEffectCreateChainEffect3, "createChainEffect(chainEffect1, blurEffect)");
                    z8.b(str, "setBackDropInner: mBlurRadius = " + this.f3329o);
                    if (j.q && this.f3325k) {
                        e(this, renderEffectCreateChainEffect3);
                        return;
                    } else {
                        e(this, renderEffectCreateBlurEffect2);
                        return;
                    }
                }
                int i10 = this.f3331s;
                int color7 = getContext().getColor(R$color.os_liquid_brand_night_color2);
                int color8 = getContext().getColor(R$color.os_liquid_brand_night_color3);
                RenderEffect renderEffectCreateColorFilterEffect4 = RenderEffect.createColorFilterEffect(new BlendModeColorFilter(i10, BlendMode.DARKEN));
                Intrinsics.checkNotNullExpressionValue(renderEffectCreateColorFilterEffect4, "createColorFilterEffect(colorFilter1)");
                RenderEffect renderEffectCreateColorFilterEffect5 = RenderEffect.createColorFilterEffect(new BlendModeColorFilter(color7, BlendMode.PLUS));
                Intrinsics.checkNotNullExpressionValue(renderEffectCreateColorFilterEffect5, "createColorFilterEffect(colorFilter2)");
                RenderEffect renderEffectCreateColorFilterEffect6 = RenderEffect.createColorFilterEffect(new BlendModeColorFilter(color8, BlendMode.SRC_OVER));
                Intrinsics.checkNotNullExpressionValue(renderEffectCreateColorFilterEffect6, "createColorFilterEffect(colorFilter3)");
                float f10 = this.f3329o;
                RenderEffect renderEffectCreateBlurEffect3 = RenderEffect.createBlurEffect(f10, f10, Shader.TileMode.CLAMP);
                Intrinsics.checkNotNullExpressionValue(renderEffectCreateBlurEffect3, "createBlurEffect(mBlurRa…s, Shader.TileMode.CLAMP)");
                RenderEffect renderEffectCreateChainEffect4 = RenderEffect.createChainEffect(renderEffectCreateColorFilterEffect4, renderEffectCreateColorFilterEffect5);
                Intrinsics.checkNotNullExpressionValue(renderEffectCreateChainEffect4, "createChainEffect(renderEffect1, renderEffect12)");
                RenderEffect renderEffectCreateChainEffect5 = RenderEffect.createChainEffect(renderEffectCreateChainEffect4, renderEffectCreateColorFilterEffect6);
                Intrinsics.checkNotNullExpressionValue(renderEffectCreateChainEffect5, "createChainEffect(chainEffect1, renderEffect13)");
                RenderEffect renderEffectCreateChainEffect6 = RenderEffect.createChainEffect(renderEffectCreateChainEffect5, renderEffectCreateBlurEffect3);
                Intrinsics.checkNotNullExpressionValue(renderEffectCreateChainEffect6, "createChainEffect(chainEffect2, blurEffect)");
                z8.b(str, "setBackDropInner: mBlurRadius = " + this.f3329o);
                if (j.q && this.f3325k) {
                    e(this, renderEffectCreateChainEffect6);
                    return;
                } else {
                    e(this, renderEffectCreateBlurEffect3);
                    return;
                }
            }
            a(this);
            boolean z5 = this.p;
            a unionEffect = getUnionEffect();
            float f11 = this.f3329o;
            unionEffect.getClass();
            String str2 = l9.a.f7348i;
            unionEffect.c(str2, true).b(f11);
            if (j.q && this.f3325k) {
                a unionEffect2 = getUnionEffect();
                unionEffect2.getClass();
                unionEffect2.c(str2, true).g();
                z8.b(str, "liquidLevel = " + this.q + " mBlurRadius = " + this.f3329o + " blurNightMode = " + z5);
                int i11 = this.q;
                int i12 = 0;
                if (i11 != 0) {
                    if (i11 != 1) {
                        if (i11 != 2) {
                            if (i11 != 3) {
                                if (i11 != 4) {
                                    if (i11 != 5) {
                                        color = 0;
                                        color2 = 0;
                                        iOrdinal = 0;
                                        iOrdinal2 = 0;
                                        i8 = iOrdinal2;
                                    } else if (z5) {
                                        color3 = getContext().getColor(R$color.os_liquid_brand_night_color3);
                                        color4 = getContext().getColor(R$color.os_liquid_brand_night_color2);
                                        color5 = getContext().getColor(R$color.os_liquid_brand_night_color1);
                                        iOrdinal = BlendMode.DARKEN.ordinal();
                                        iOrdinal2 = BlendMode.LIGHTEN.ordinal();
                                        iOrdinal3 = BlendMode.SRC_OVER.ordinal();
                                        int i13 = color5;
                                        color2 = color4;
                                        color = color3;
                                        i12 = iOrdinal3;
                                        i8 = i13;
                                    } else {
                                        color = getContext().getColor(R$color.os_liquid_brand_light_color1);
                                        color2 = getContext().getColor(R$color.os_liquid_brand_light_color2);
                                        iOrdinal = BlendMode.LUMINOSITY.ordinal();
                                        iOrdinal2 = BlendMode.DARKEN.ordinal();
                                    }
                                } else if (z5) {
                                    color3 = getContext().getColor(R$color.os_liquid_big_night_color1);
                                    color4 = getContext().getColor(R$color.os_liquid_big_night_color2);
                                    color5 = getContext().getColor(R$color.os_liquid_big_night_color3);
                                    iOrdinal = BlendMode.SRC_OVER.ordinal();
                                    iOrdinal2 = BlendMode.LUMINOSITY.ordinal();
                                    iOrdinal3 = BlendMode.COLOR_BURN.ordinal();
                                    int i14 = color5;
                                    color2 = color4;
                                    color = color3;
                                    i12 = iOrdinal3;
                                    i8 = i14;
                                } else {
                                    color = getContext().getColor(R$color.os_liquid_big_light_color1);
                                    color2 = getContext().getColor(R$color.os_liquid_big_light_color2);
                                    iOrdinal = BlendMode.COLOR_DODGE.ordinal();
                                    iOrdinal2 = BlendMode.SRC_OVER.ordinal();
                                }
                            } else if (z5) {
                                color3 = getContext().getColor(R$color.os_liquid_midle_night_color1);
                                color4 = getContext().getColor(R$color.os_liquid_midle_night_color2);
                                color5 = getContext().getColor(R$color.os_liquid_midle_night_color3);
                                iOrdinal = BlendMode.SRC_OVER.ordinal();
                                iOrdinal2 = BlendMode.LUMINOSITY.ordinal();
                                iOrdinal3 = BlendMode.COLOR_BURN.ordinal();
                                int i15 = color5;
                                color2 = color4;
                                color = color3;
                                i12 = iOrdinal3;
                                i8 = i15;
                            } else {
                                color = getContext().getColor(R$color.os_liquid_midle_light_color1);
                                color2 = getContext().getColor(R$color.os_liquid_midle_light_color2);
                                iOrdinal = BlendMode.COLOR_DODGE.ordinal();
                                iOrdinal2 = BlendMode.SRC_OVER.ordinal();
                            }
                        } else if (z5) {
                            color3 = getContext().getColor(R$color.os_liquid_small_night_color1);
                            color4 = getContext().getColor(R$color.os_liquid_small_night_color2);
                            color5 = getContext().getColor(R$color.os_liquid_small_night_color3);
                            iOrdinal = BlendMode.SRC_OVER.ordinal();
                            iOrdinal2 = BlendMode.LUMINOSITY.ordinal();
                            iOrdinal3 = BlendMode.COLOR_BURN.ordinal();
                            int i16 = color5;
                            color2 = color4;
                            color = color3;
                            i12 = iOrdinal3;
                            i8 = i16;
                        } else {
                            color = getContext().getColor(R$color.os_liquid_small_light_color1);
                            color2 = getContext().getColor(R$color.os_liquid_small_light_color2);
                            iOrdinal = BlendMode.COLOR_DODGE.ordinal();
                            iOrdinal2 = BlendMode.SRC_OVER.ordinal();
                        }
                    } else if (z5) {
                        color = getContext().getColor(R$color.os_liquid_clear2_night_color1);
                        iOrdinal = BlendMode.COLOR_DODGE.ordinal();
                        color2 = 0;
                        iOrdinal2 = 0;
                        i8 = iOrdinal2;
                    } else {
                        color = getContext().getColor(R$color.os_liquid_clear2_color1);
                        color2 = getContext().getColor(R$color.os_liquid_clear2_color2);
                        iOrdinal = BlendMode.COLOR_DODGE.ordinal();
                        iOrdinal2 = BlendMode.SRC_OVER.ordinal();
                    }
                    a unionEffect3 = getUnionEffect();
                    unionEffect3.getClass();
                    unionEffect3.c(str2, true).a(iOrdinal, color, iOrdinal2, color2, i12, i8);
                    a unionEffect4 = getUnionEffect();
                    unionEffect4.getClass();
                    unionEffect4.c(str2, true).f(iOrdinal, color, iOrdinal2, color2, i12, i8);
                }
                color = getContext().getColor(R$color.os_liquid_clear1_color1);
                color2 = getContext().getColor(R$color.os_liquid_clear1_color2);
                iOrdinal = BlendMode.COLOR_DODGE.ordinal();
                iOrdinal2 = BlendMode.SRC_OVER.ordinal();
                i8 = 0;
                a unionEffect5 = getUnionEffect();
                unionEffect5.getClass();
                unionEffect5.c(str2, true).a(iOrdinal, color, iOrdinal2, color2, i12, i8);
                a unionEffect6 = getUnionEffect();
                unionEffect6.getClass();
                unionEffect6.c(str2, true).f(iOrdinal, color, iOrdinal2, color2, i12, i8);
            }
        }
    }

    @RequiresApi(31)
    public final void setBlurNightMode(boolean nightMode) {
        if (this.p != nightMode) {
            this.p = nightMode;
            setBackdrop(this.f3322h);
        }
    }

    @RequiresApi(31)
    public final void setBlurRadius(float blurRadius) {
        this.f3329o = blurRadius;
        setBackdrop(this.f3322h);
    }

    @RequiresApi(31)
    public final void setBrandColor(int brandColor) {
        if (this.f3331s != brandColor) {
            this.f3331s = brandColor;
            setBackdrop(this.f3322h);
        }
    }

    public final void setDefaultBgColor(int color) {
        setMDefaultBgColor(color);
        this.f3323i = true;
        invalidate();
    }

    public final void setFillColor(int color) {
        this.f3330r = color;
        this.q = -1;
        setBackdrop(this.f3322h);
    }

    public final void setGradientStrokeColor(int[] color) {
        Intrinsics.checkNotNullParameter(color, "color");
        this.e.setGradientStrokeColor(color);
        invalidate();
    }

    @RequiresApi(31)
    public final void setLiquidLevel(int level) {
        this.q = level;
        setBackdrop(this.f3322h);
    }

    @RequiresApi(31)
    public final void setMixLevel(int level) {
        if (this.q != level) {
            this.q = level;
            setBackdrop(this.f3322h);
            if (this.f3323i) {
                return;
            }
            setMDefaultBgColor(d(this.q, this.p));
        }
    }

    @RequiresApi(31)
    public final void setNightMode(boolean nightMode) {
        if (nightMode != this.p) {
            this.p = nightMode;
            setBackdrop(this.f3322h);
        }
    }

    public final void setPositionsLT(float[] floatArray) {
        Intrinsics.checkNotNullParameter(floatArray, "floatArray");
        this.e.setPositionsLT(floatArray);
        invalidate();
    }

    public final void setRadius(float liquidRadius) {
        g gVar = this.e;
        gVar.setRadius(liquidRadius);
        setOutlineProvider(new c(gVar.getCornerRadius()));
        invalidate();
    }

    @RequiresApi(31)
    public final void setShowBlenderColor(boolean showBlenderColor) {
        if (this.f3325k != showBlenderColor) {
            this.f3325k = showBlenderColor;
            setBackdrop(this.f3322h);
        }
    }

    public final void setShowBlenderColor2(boolean showBlenderColor2) {
        this.f3326l = showBlenderColor2;
        this.e.setShowBlendColor2(showBlenderColor2);
        invalidate();
    }

    @RequiresApi(31)
    public final void setShowBlur(boolean showBlur) {
        if (this.f3328n != showBlur) {
            this.f3328n = showBlur;
            setBackdrop(this.f3322h);
        }
    }

    public final void setShowOutline(boolean showOutline) {
        this.f3327m = showOutline;
        this.e.setShowOutline(showOutline);
        invalidate();
    }

    public final void setStrokeBlendMode(BlendMode blendMode) {
        Intrinsics.checkNotNullParameter(blendMode, "blendMode");
        this.e.setStrokeBlendMode(blendMode);
        invalidate();
    }

    public final void setUseUnionBlur(boolean z2) {
        this.isUseUnionBlur = z2;
        setBackdrop(this.f3322h);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSLiquidContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 4, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ OSLiquidContainer(Context context, AttributeSet attributeSet, int i8, int i9) {
        this(context, (i8 & 2) != 0 ? null : attributeSet, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSLiquidContainer(Context context, AttributeSet attributeSet, int i8) {
        int dimensionPixelSize;
        int color;
        super(context, attributeSet, i8);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f3318a = "OSLiquidContainer";
        this.tranView = LazyKt.lazy(wd.a.INSTANCE);
        this.unionEffect = LazyKt.lazy(new wd.b(this));
        g gVar = new g(context);
        gVar.setEndsLeftTop(0.95f);
        this.e = gVar;
        this.f3325k = true;
        this.f3326l = true;
        this.f3327m = true;
        this.f3328n = true;
        this.f3330r = Color.parseColor("#80262626");
        BlendMode blendMode = BlendMode.SRC_OVER;
        this.f3322h = getResources().getColor(R$color.os_liquid_container_blender_color);
        int i9 = R$attr.os_liquid_container_bg_color_attr;
        int i10 = R$color.os_liquid_container_bg_color;
        String[] strArr = j.f8764a;
        setMDefaultBgColor(j.d(i9, context.getColor(i10), context));
        int[] OSLiquidContainer = R$styleable.OSLiquidContainer;
        Intrinsics.checkNotNullExpressionValue(OSLiquidContainer, "OSLiquidContainer");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, OSLiquidContainer, 0, 0);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        int dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.OSLiquidContainer_os_liquid_radius, hd.a.a(context, 30));
        this.f3322h = typedArrayObtainStyledAttributes.getColor(R$styleable.OSLiquidContainer_os_liquid_blur_blend_color, this.f3322h);
        this.f3325k = typedArrayObtainStyledAttributes.getBoolean(R$styleable.OSLiquidContainer_os_liquid_show_blender_color, this.f3325k);
        this.f3326l = typedArrayObtainStyledAttributes.getBoolean(R$styleable.OSLiquidContainer_os_liquid_show_blender_color2, this.f3326l);
        this.f3327m = typedArrayObtainStyledAttributes.getBoolean(R$styleable.OSLiquidContainer_os_liquid_show_outline, this.f3327m);
        this.f3328n = typedArrayObtainStyledAttributes.getBoolean(R$styleable.OSLiquidContainer_os_liquid_show_blur, this.f3328n);
        this.q = typedArrayObtainStyledAttributes.getInt(R$styleable.OSLiquidContainer_os_liquid_mixlevel, this.q);
        this.f3332t = typedArrayObtainStyledAttributes.getBoolean(R$styleable.OSLiquidContainer_os_liquid_dailog, this.f3332t);
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, new int[]{R$attr.os_platform_basic_color}, 0, 0);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes2, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        this.f3331s = typedArrayObtainStyledAttributes2.getColor(0, typedArrayObtainStyledAttributes2.getResources().getColor(R$color.os_platform_basic_color_xos));
        typedArrayObtainStyledAttributes2.recycle();
        this.f3331s = typedArrayObtainStyledAttributes.getColor(R$styleable.OSLiquidContainer_os_liquid_brand_color, this.f3331s);
        int i11 = this.q;
        if (i11 == 2) {
            dimensionPixelSize = typedArrayObtainStyledAttributes.getResources().getDimensionPixelSize(R$dimen.os_liquid_blur_small_radius);
        } else if (i11 == 3) {
            dimensionPixelSize = typedArrayObtainStyledAttributes.getResources().getDimensionPixelSize(R$dimen.os_liquid_blur_middle_radius);
        } else if (i11 != 4) {
            dimensionPixelSize = typedArrayObtainStyledAttributes.getResources().getDimensionPixelSize(R$dimen.os_liquid_blur_radius);
        } else {
            dimensionPixelSize = typedArrayObtainStyledAttributes.getResources().getDimensionPixelSize(R$dimen.os_liquid_blur_big_radius);
        }
        float f = dimensionPixelSize;
        this.f3329o = f;
        this.f3329o = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.OSLiquidContainer_os_liquid_blur_radius, (int) f);
        int i12 = R$styleable.OSLiquidContainer_os_liquid_night_mode;
        boolean z2 = (getContext().getResources().getConfiguration().uiMode & 48) == 32;
        z8.b("OSLiquidContainer", "nightMode = " + z2);
        this.p = typedArrayObtainStyledAttributes.getBoolean(i12, z2);
        gVar.setRadius((float) dimensionPixelSize2);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(R$styleable.OSLiquidContainer_os_liquid_bg_color);
        this.f3323i = zHasValue;
        if (!zHasValue) {
            color = d(this.q, this.p);
        } else {
            color = typedArrayObtainStyledAttributes.getColor(R$styleable.OSLiquidContainer_os_liquid_bg_color, this.mDefaultBgColor);
        }
        setMDefaultBgColor(color);
        gVar.setShowOutline(this.f3327m);
        gVar.setShowBlendColor2(this.f3326l);
        typedArrayObtainStyledAttributes.recycle();
        BlendMode blendMode2 = BlendMode.COLOR_DODGE;
        setWillNotDraw(false);
        setOutlineProvider(new c(gVar.getCornerRadius()));
        setClipToOutline(true);
        setBackdrop(this.f3322h);
    }
}
