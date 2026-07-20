package com.transsion.widgetsliquid.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.RuntimeXfermode;
import android.graphics.Shader;
import android.graphics.Xfermode;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import androidx.annotation.ColorRes;
import androidx.annotation.RawRes;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.widgetsliquid.R;
import com.transsion.widgetsliquid.utils.Utils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.LinkedHashMap;
import java.util.Map;
import k3.z8;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import pd.j;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(36)
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u0014\n\u0002\b\u0003\b\u0017\u0018\u0000 K2\u00020\u0001:\u0002KLB\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u001e\u00109\u001a\u00020:2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010;\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\nJ\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010;\u001a\u00020\u0019H\u0002J\u0018\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010;\u001a\u00020\u0019H\u0002J\u0018\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010;\u001a\u00020\u0019H\u0002J\u0018\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010;\u001a\u00020\u0019H\u0002J\b\u0010<\u001a\u00020\u0019H\u0016J(\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\n2\u0006\u0010@\u001a\u00020\n2\u0006\u0010A\u001a\u00020\n2\u0006\u0010B\u001a\u00020\nH\u0014J\u0006\u0010C\u001a\u00020>J.\u0010D\u001a\u00020>2\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000f\u001a\u00020\n2\b\b\u0001\u0010\u0012\u001a\u00020\n2\b\b\u0001\u0010\u0015\u001a\u00020\nJ\u000e\u0010E\u001a\u00020>2\u0006\u0010F\u001a\u00020\u0019J\u000e\u0010G\u001a\u00020>2\u0006\u0010H\u001a\u00020\nJ\n\u0010I\u001a\u00020J*\u00020\nR\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0015\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000eR\u001a\u0010!\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\f\"\u0004\b#\u0010\u000eR\u001a\u0010$\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001b\"\u0004\b&\u0010\u001dR\u001c\u0010'\u001a\u0004\u0018\u00010(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\f\"\u0004\b/\u0010\u000eR\u001b\u00100\u001a\u0002018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b2\u00103R\u001b\u00106\u001a\u0002018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u00105\u001a\u0004\b7\u00103¨\u0006M"}, d2 = {"Lcom/transsion/widgetsliquid/view/OSMixColorTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "blendShader1", "", "getBlendShader1", "()I", "setBlendShader1", "(I)V", "blendShader2", "getBlendShader2", "setBlendShader2", "color1", "getColor1", "setColor1", "color2", "getColor2", "setColor2", "custom", "", "getCustom", "()Z", "setCustom", "(Z)V", "mCurrentLevel", "getMCurrentLevel", "setMCurrentLevel", "mEndColor", "getMEndColor", "setMEndColor", "mGradientEnable", "getMGradientEnable", "setMGradientEnable", "mLinearGradient", "Landroid/graphics/LinearGradient;", "getMLinearGradient", "()Landroid/graphics/LinearGradient;", "setMLinearGradient", "(Landroid/graphics/LinearGradient;)V", "mStartColor", "getMStartColor", "setMStartColor", "textColarToken", "", "getTextColarToken", "()[I", "textColarToken$delegate", "Lkotlin/Lazy;", "textColors", "getTextColors", "textColors$delegate", "applyMultiBlendMode", "Landroid/graphics/RuntimeXfermode;", "gradientEnable", "hasOverlappingRendering", "onSizeChanged", "", "w", "h", "oldw", "oldh", "resetGradientShader", "setCustomParam", "setGradientEnable", "gradient", "setMixLevel", "level", "toNormalizedRGBA", "", "Companion", "MIX_LEVEL", "widgetsliquid_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@SourceDebugExtension({"SMAP\nOSMixColorTextView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OSMixColorTextView.kt\ncom/transsion/widgetsliquid/view/OSMixColorTextView\n+ 2 ContextFunc.kt\ncom/transsion/widgetslib/util/ContextFuncKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,367:1\n13#2,9:368\n13#2,9:377\n361#3,7:386\n361#3,7:393\n*S KotlinDebug\n*F\n+ 1 OSMixColorTextView.kt\ncom/transsion/widgetsliquid/view/OSMixColorTextView\n*L\n74#1:368,9\n97#1:377,9\n303#1:386,7\n325#1:393,7\n*E\n"})
public class OSMixColorTextView extends AppCompatTextView {
    public static final int MIX_LEVEL_1 = 0;
    public static final int MIX_LEVEL_2 = 1;
    public static final int MIX_LEVEL_3 = 2;
    public static final int MIX_LEVEL_4 = 3;
    private final String TAG;
    private int blendShader1;
    private int blendShader2;
    private int color1;
    private int color2;
    private boolean custom;
    private int mCurrentLevel;
    private int mEndColor;
    private boolean mGradientEnable;
    private LinearGradient mLinearGradient;
    private int mStartColor;

    /* JADX INFO: renamed from: textColarToken$delegate, reason: from kotlin metadata */
    private final Lazy textColarToken;

    /* JADX INFO: renamed from: textColors$delegate, reason: from kotlin metadata */
    private final Lazy textColors;
    private static final Map<String, RuntimeXfermode> xfermodeCache = new LinkedHashMap();

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/transsion/widgetsliquid/view/OSMixColorTextView$MIX_LEVEL;", "", "widgetsliquid_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface MIX_LEVEL {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public OSMixColorTextView(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final int[] getTextColarToken() {
        return (int[]) this.textColarToken.getValue();
    }

    private final int[] getTextColors() {
        return (int[]) this.textColors.getValue();
    }

    public final RuntimeXfermode applyMultiBlendMode(Context context, boolean gradientEnable, int mCurrentLevel) {
        String blendShader1;
        String blendShader2;
        int color1;
        int color2;
        float[] normalizedRGBA;
        float[] normalizedRGBA2;
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.custom) {
            blendShader1 = Utils.readRawTextFile(context, this.blendShader1);
            blendShader2 = Utils.readRawTextFile(context, this.blendShader2);
            normalizedRGBA = toNormalizedRGBA(this.color1);
            normalizedRGBA2 = toNormalizedRGBA(this.color2);
            color1 = 0;
            color2 = 0;
        } else {
            blendShader1 = getBlendShader1(context, gradientEnable);
            blendShader2 = getBlendShader2(context, gradientEnable);
            color1 = getColor1(context, gradientEnable);
            color2 = getColor2(context, gradientEnable);
            normalizedRGBA = toNormalizedRGBA(color1);
            normalizedRGBA2 = toNormalizedRGBA(color2);
        }
        String str = ((Object) blendShader1) + "|" + ((Object) blendShader2) + "|" + color1 + "|" + color2 + "|" + gradientEnable + "|" + this.custom;
        if (!gradientEnable) {
            Map<String, RuntimeXfermode> map = xfermodeCache;
            RuntimeXfermode runtimeXfermode = map.get(str);
            if (runtimeXfermode == null) {
                runtimeXfermode = new RuntimeXfermode("uniform blender blender1;\nuniform float4 color1;\nuniform blender blender2;\nuniform float4 color2;\nhalf4 main(half4 src, half4 dst) {\n\thalf4 dst1 = blender1.eval(color1, dst);\n\thalf4 dst2 = blender2.eval(color2, dst1);\n\treturn mix(dst,dst2,src.a);\n}");
                runtimeXfermode.setInputXfermode("blender1", new RuntimeXfermode(blendShader1));
                runtimeXfermode.setInputXfermode("blender2", new RuntimeXfermode(blendShader2));
                map.put(str, runtimeXfermode);
            }
            RuntimeXfermode runtimeXfermode2 = runtimeXfermode;
            runtimeXfermode2.setFloatUniform("color1", normalizedRGBA[0], normalizedRGBA[1], normalizedRGBA[2], normalizedRGBA[3]);
            runtimeXfermode2.setFloatUniform("color2", normalizedRGBA2[0], normalizedRGBA2[1], normalizedRGBA2[2], normalizedRGBA2[3]);
            return runtimeXfermode2;
        }
        Map<String, RuntimeXfermode> map2 = xfermodeCache;
        RuntimeXfermode runtimeXfermode3 = map2.get(str);
        if (runtimeXfermode3 == null) {
            runtimeXfermode3 = new RuntimeXfermode("uniform blender blender1;\nuniform float4 color1;\nuniform blender blender2;\nuniform float4 color2;\nuniform blender blender3;\nuniform float4 color3;\nhalf4 main(half4 src, half4 dst) {\n\thalf4 dst1 = blender1.eval(src, dst);\n\thalf4 dst2 = blender2.eval(color2, dst1);\n\thalf4 dst3 = blender3.eval(color3, dst2);\n\treturn mix(dst,dst3,src.a);\n}");
            runtimeXfermode3.setInputXfermode("blender1", new RuntimeXfermode(Utils.readRawTextFile(context, R.raw.blender_srcover)));
            runtimeXfermode3.setInputXfermode("blender2", new RuntimeXfermode(Utils.readRawTextFile(context, R.raw.blender_test_colordodge)));
            runtimeXfermode3.setInputXfermode("blender3", new RuntimeXfermode(Utils.readRawTextFile(context, R.raw.blender_srcover)));
            map2.put(str, runtimeXfermode3);
        }
        RuntimeXfermode runtimeXfermode4 = runtimeXfermode3;
        runtimeXfermode4.setFloatUniform("color2", 0.325f, 0.325f, 0.325f, 1.0f);
        runtimeXfermode4.setFloatUniform("color3", 1.0f, 1.0f, 1.0f, 0.6f);
        return runtimeXfermode4;
    }

    public final int getBlendShader1() {
        return this.blendShader1;
    }

    public final int getBlendShader2() {
        return this.blendShader2;
    }

    public final int getColor1() {
        return this.color1;
    }

    public final int getColor2() {
        return this.color2;
    }

    public final boolean getCustom() {
        return this.custom;
    }

    public final int getMCurrentLevel() {
        return this.mCurrentLevel;
    }

    public final int getMEndColor() {
        return this.mEndColor;
    }

    public final boolean getMGradientEnable() {
        return this.mGradientEnable;
    }

    public final LinearGradient getMLinearGradient() {
        return this.mLinearGradient;
    }

    public final int getMStartColor() {
        return this.mStartColor;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    @Override // android.view.View
    public void onSizeChanged(int w8, int h9, int oldw, int oldh) {
        super.onSizeChanged(w8, h9, oldw, oldh);
        if (this.mGradientEnable) {
            resetGradientShader();
        }
    }

    public final void resetGradientShader() {
        if (j.f8776o) {
            this.mLinearGradient = new LinearGradient(0.0f, 0.0f, 0.0f, getHeight(), this.mStartColor, this.mEndColor, Shader.TileMode.CLAMP);
            getPaint().setShader(this.mLinearGradient);
            invalidate();
        }
    }

    public final void setBlendShader1(int i8) {
        this.blendShader1 = i8;
    }

    public final void setBlendShader2(int i8) {
        this.blendShader2 = i8;
    }

    public final void setColor1(int i8) {
        this.color1 = i8;
    }

    public final void setColor2(int i8) {
        this.color2 = i8;
    }

    public final void setCustom(boolean z2) {
        this.custom = z2;
    }

    public final void setCustomParam(@RawRes int blendShader1, @RawRes int blendShader2, @ColorRes int color1, @ColorRes int color2) {
        if (j.f8776o) {
            this.blendShader1 = blendShader1;
            this.blendShader2 = blendShader2;
            this.color1 = getContext().getColor(color1);
            this.color2 = getContext().getColor(color2);
            TextPaint paint = getPaint();
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            paint.setXfermode((Xfermode) applyMultiBlendMode(context, this.mGradientEnable, this.mCurrentLevel));
            invalidate();
        }
    }

    public final void setGradientEnable(boolean gradient) {
        if (j.f8776o) {
            if (this.mGradientEnable != gradient) {
                this.mGradientEnable = gradient;
                if (gradient) {
                    resetGradientShader();
                } else {
                    getPaint().setShader(null);
                }
                TextPaint paint = getPaint();
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                paint.setXfermode((Xfermode) applyMultiBlendMode(context, gradient, this.mCurrentLevel));
            }
            invalidate();
        }
    }

    public final void setMCurrentLevel(int i8) {
        this.mCurrentLevel = i8;
    }

    public final void setMEndColor(int i8) {
        this.mEndColor = i8;
    }

    public final void setMGradientEnable(boolean z2) {
        this.mGradientEnable = z2;
    }

    public final void setMLinearGradient(LinearGradient linearGradient) {
        this.mLinearGradient = linearGradient;
    }

    public final void setMStartColor(int i8) {
        this.mStartColor = i8;
    }

    public final void setMixLevel(int level) {
        if (!j.f8776o) {
            setTextColor(getTextColors()[level]);
            return;
        }
        if (this.mCurrentLevel != level) {
            this.mCurrentLevel = level;
            TextPaint paint = getPaint();
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            paint.setXfermode((Xfermode) applyMultiBlendMode(context, this.mGradientEnable, this.mCurrentLevel));
        }
        invalidate();
    }

    public final float[] toNormalizedRGBA(int i8) {
        float[] fArr = {Color.red(i8) / 255.0f, Color.green(i8) / 255.0f, Color.blue(i8) / 255.0f, Color.alpha(i8) / 255.0f};
        Log.d(this.TAG, "toNormalizedRGBA: red = " + fArr[0] + " green = " + fArr[1] + " blue = " + fArr[2] + " alpha = " + fArr[3] + " color" + fArr);
        return fArr;
    }

    public /* synthetic */ OSMixColorTextView(Context context, AttributeSet attributeSet, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i8 & 2) != 0 ? null : attributeSet);
    }

    private final String getBlendShader1(Context context, boolean gradientEnable) {
        return !context.getResources().getConfiguration().isNightModeActive() ? Utils.readRawTextFile(context, R.raw.blender_test_luminosity) : Utils.readRawTextFile(context, R.raw.blender_srcover);
    }

    private final String getBlendShader2(Context context, boolean gradientEnable) {
        return !context.getResources().getConfiguration().isNightModeActive() ? Utils.readRawTextFile(context, R.raw.blender_test_color_burn) : Utils.readRawTextFile(context, R.raw.blender_test_colordodge);
    }

    private final int getColor1(Context context, boolean gradientEnable) {
        if (context.getResources().getConfiguration().isNightModeActive()) {
            int i8 = this.mCurrentLevel;
            if (i8 == 2) {
                return context.getColor(R.color.os_mix_text_l3_light_color_light);
            }
            if (i8 == 1) {
                return context.getColor(R.color.os_mix_text_l2_light_color_light);
            }
            return i8 == 0 ? context.getColor(R.color.os_mix_text_l1_light_color_light) : context.getColor(R.color.os_mix_text_l4_light_color_light);
        }
        int i9 = this.mCurrentLevel;
        if (i9 == 2 || gradientEnable) {
            return context.getColor(R.color.os_mix_text_l3_night_color_luminosity);
        }
        if (i9 == 1) {
            return context.getColor(R.color.os_mix_text_l2_night_color_luminosity);
        }
        return i9 == 0 ? context.getColor(R.color.os_mix_text_l1_night_color_luminosity) : context.getColor(R.color.os_mix_text_l4_night_color_luminosity);
    }

    private final int getColor2(Context context, boolean gradientEnable) {
        boolean zIsNightModeActive = context.getResources().getConfiguration().isNightModeActive();
        if (gradientEnable) {
            return -1;
        }
        if (zIsNightModeActive) {
            int i8 = this.mCurrentLevel;
            if (i8 == 2) {
                return context.getColor(R.color.os_mix_text_l3_light_color_dodge);
            }
            if (i8 == 1) {
                return context.getColor(R.color.os_mix_text_l2_light_color_dodge);
            }
            return i8 == 0 ? context.getColor(R.color.os_mix_text_l1_light_color_dodge) : context.getColor(R.color.os_mix_text_l4_light_color_dodge);
        }
        int i9 = this.mCurrentLevel;
        if (i9 == 2) {
            return context.getColor(R.color.os_mix_text_l3_night_color_burn);
        }
        if (i9 == 1) {
            return context.getColor(R.color.os_mix_text_l2_night_color_burn);
        }
        return i9 == 0 ? context.getColor(R.color.os_mix_text_l1_night_color_burn) : context.getColor(R.color.os_mix_text_l4_night_color_burn);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSMixColorTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.TAG = "OSMixColorTextView";
        this.mStartColor = Color.argb(229, 255, 255, 255);
        this.mEndColor = Color.argb(178, 255, 255, 255);
        this.mCurrentLevel = 2;
        this.textColors = LazyKt.lazy(new Function0<int[]>() { // from class: com.transsion.widgetsliquid.view.OSMixColorTextView$textColors$2
            @Override // kotlin.jvm.functions.Function0
            public final int[] invoke() {
                return new int[4];
            }
        });
        this.textColarToken = LazyKt.lazy(new Function0<int[]>() { // from class: com.transsion.widgetsliquid.view.OSMixColorTextView$textColarToken$2
            @Override // kotlin.jvm.functions.Function0
            public final int[] invoke() {
                return new int[]{R.attr.os_text_info, R.attr.os_text_tertiary, R.attr.os_text_secondary, R.attr.os_text_primary};
            }
        });
        int[] OSMixColorTextView = R.styleable.OSMixColorTextView;
        Intrinsics.checkNotNullExpressionValue(OSMixColorTextView, "OSMixColorTextView");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, OSMixColorTextView, 0, 0);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        this.mGradientEnable = typedArrayObtainStyledAttributes.getBoolean(R.styleable.OSMixColorTextView_os_grident, false);
        this.custom = typedArrayObtainStyledAttributes.getBoolean(R.styleable.OSMixColorTextView_os_mix_custom, false);
        this.blendShader1 = typedArrayObtainStyledAttributes.getResourceId(R.styleable.OSMixColorTextView_os_mix_blendShader1, 0);
        this.blendShader2 = typedArrayObtainStyledAttributes.getResourceId(R.styleable.OSMixColorTextView_os_mix_blendShader2, 0);
        this.color1 = typedArrayObtainStyledAttributes.getColor(R.styleable.OSMixColorTextView_os_mix_color1, 0);
        this.color2 = typedArrayObtainStyledAttributes.getColor(R.styleable.OSMixColorTextView_os_mix_color2, 0);
        int i8 = typedArrayObtainStyledAttributes.getInt(R.styleable.OSMixColorTextView_os_mix_level, 2);
        this.mCurrentLevel = i8;
        z8.b("OSMixColorTextView", "mCurrentLevel: " + i8 + " custom " + this.custom + " color1 " + this.color1 + " blendShader1 " + this.blendShader1);
        boolean z2 = j.f8776o;
        if (z2) {
            setTextColor(Color.parseColor("#FFFFFFFF"));
            setHintTextColor(Color.parseColor("#FFFFFFFF"));
            if (this.custom && !this.mGradientEnable) {
                setTextColor(context.getColor(R.color.os_mix_text_color_l4));
            } else {
                getPaint().setXfermode((Xfermode) applyMultiBlendMode(context, this.mGradientEnable, this.mCurrentLevel));
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        if (z2) {
            return;
        }
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, getTextColarToken(), 0, 0);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes2, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        getTextColors()[0] = typedArrayObtainStyledAttributes2.getColor(0, 0);
        getTextColors()[1] = typedArrayObtainStyledAttributes2.getColor(1, 0);
        getTextColors()[2] = typedArrayObtainStyledAttributes2.getColor(2, 0);
        getTextColors()[3] = typedArrayObtainStyledAttributes2.getColor(3, 0);
        typedArrayObtainStyledAttributes2.recycle();
        setTextColor(getTextColors()[this.mCurrentLevel]);
    }
}
