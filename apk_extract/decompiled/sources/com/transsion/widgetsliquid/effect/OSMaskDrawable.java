package com.transsion.widgetsliquid.effect;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.iotcardsdk.bean.DeviceType;
import com.transsion.widgetslib.R$dimen;
import com.transsion.widgetsliquid.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import k3.z8;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import pd.j;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 <2\u00020\u0001:\u0002<=B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020!H\u0002J\b\u0010#\u001a\u00020!H\u0002J\u0010\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020!2\u0006\u0010%\u001a\u00020&H\u0002J\u0010\u0010(\u001a\u00020!2\u0006\u0010%\u001a\u00020&H\u0002J\b\u0010)\u001a\u00020\u000fH\u0016J\b\u0010*\u001a\u00020!H\u0002J\u0010\u0010+\u001a\u00020!2\u0006\u0010,\u001a\u00020\u000fH\u0016J\u0012\u0010-\u001a\u00020!2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u0018\u00100\u001a\u00020!2\u0006\u00101\u001a\u00020\u000f2\b\b\u0002\u00102\u001a\u00020\u0013J\u000e\u00103\u001a\u00020!2\u0006\u00104\u001a\u00020\u000fJ\u000e\u00105\u001a\u00020!2\u0006\u00101\u001a\u00020\u000fJ\u000e\u00106\u001a\u00020!2\u0006\u00107\u001a\u00020\u000fJ\u000e\u00108\u001a\u00020!2\u0006\u00109\u001a\u00020\u000fJ\u000e\u0010:\u001a\u00020!2\u0006\u0010;\u001a\u00020\u000fR\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\bR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001d¨\u0006>"}, d2 = {"Lcom/transsion/widgetsliquid/effect/OSMaskDrawable;", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TBLfadeShader", "Landroid/graphics/LinearGradient;", "getTBLfadeShader", "()Landroid/graphics/LinearGradient;", "TBNfadeShader", "getTBNfadeShader", "_TBLfadeShader", "_TBNfadeShader", "_fadeShader", "fadeHeight", "", "fadeShader", "getFadeShader", "fadeStrength", "", "maskColor", "maskPosition", "maskScene", "maskVisibility", "matrix", "Landroid/graphics/Matrix;", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "paint$delegate", "Lkotlin/Lazy;", "createFadeShader", "", "createTBLFadeShader", "createTBNFadeShader", "draw", "canvas", "Landroid/graphics/Canvas;", "drawBottomFade", "drawTopFade", "getOpacity", "initMaskShader", "setAlpha", "alpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "setFadeEffect", "height", "strength", "setMaskColor", TypedValues.Custom.S_COLOR, "setMaskHeight", "setMaskPosition", "position", "setMaskScene", "scene", "setMaskVisibility", "visibility", "Companion", "OSMASKPOSITION", "widgetsliquid_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class OSMaskDrawable extends Drawable {
    public static final int OS_MASK_POSITION_ALL = 2;
    public static final int OS_MASK_POSITION_BOTTOM = 1;
    public static final int OS_MASK_POSITION_NONE = 3;
    public static final int OS_MASK_POSITION_TOP = 0;
    public static final int OS_MASK_SCENE_DEFAULT = 0;
    public static final int OS_MASK_SCENE_MODEL_PANEL = 1;
    private LinearGradient _TBLfadeShader;
    private LinearGradient _TBNfadeShader;
    private LinearGradient _fadeShader;
    private final Context context;
    private int fadeHeight;
    private float fadeStrength;
    private int maskColor;
    private int maskPosition;
    private int maskScene;
    private int maskVisibility;
    private final Matrix matrix;

    /* JADX INFO: renamed from: paint$delegate, reason: from kotlin metadata */
    private final Lazy paint;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/transsion/widgetsliquid/effect/OSMaskDrawable$OSMASKPOSITION;", "", "widgetsliquid_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface OSMASKPOSITION {
    }

    public OSMaskDrawable(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.fadeHeight = DeviceType.INFRARED_HEATER;
        this.fadeStrength = 1.0f;
        this.maskPosition = 1;
        this.paint = LazyKt.lazy(new Function0<Paint>() { // from class: com.transsion.widgetsliquid.effect.OSMaskDrawable$paint$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Paint invoke() {
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                return paint;
            }
        });
        this.matrix = new Matrix();
        this.fadeHeight = context.getResources().getDimensionPixelSize(R.dimen.os_liquid_mask_length);
        int i8 = R.attr.os_bg_primary;
        int i9 = R.color.os_bg_primary_hios;
        String[] strArr = j.f8764a;
        this.maskColor = j.d(i8, context.getColor(i9), context);
        initMaskShader();
    }

    private final void createFadeShader() {
        int iAlpha = Color.alpha(this.maskColor);
        int iRed = Color.red(this.maskColor);
        int iGreen = Color.green(this.maskColor);
        int iBlue = Color.blue(this.maskColor);
        int i8 = this.maskScene;
        if (i8 == 0) {
            float f = iAlpha;
            this._fadeShader = new LinearGradient(0.0f, 0.0f, 0.0f, 1.0f, new int[]{Color.argb(0, iRed, iGreen, iBlue), Color.argb((int) (0.5f * f), iRed, iGreen, iBlue), Color.argb((int) (f * 1.0f), iRed, iGreen, iBlue)}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP);
        } else if (i8 == 1) {
            float f4 = iAlpha;
            this._fadeShader = new LinearGradient(0.0f, 0.0f, 0.0f, 1.0f, new int[]{Color.argb(0, iRed, iGreen, iBlue), Color.argb((int) (0.8f * f4), iRed, iGreen, iBlue), Color.argb((int) (0.9f * f4), iRed, iGreen, iBlue), Color.argb((int) (f4 * 1.0f), iRed, iGreen, iBlue)}, new float[]{0.0f, 0.35f, 0.45f, 1.0f}, Shader.TileMode.CLAMP);
        }
    }

    private final void createTBLFadeShader() {
        int iAlpha = Color.alpha(this.maskColor);
        int iRed = Color.red(this.maskColor);
        int iGreen = Color.green(this.maskColor);
        int iBlue = Color.blue(this.maskColor);
        float f = iAlpha;
        this._TBLfadeShader = new LinearGradient(0.0f, 0.0f, 0.0f, 1.0f, new int[]{Color.argb((int) (1.0f * f), iRed, iGreen, iBlue), Color.argb((int) (0.95f * f), iRed, iGreen, iBlue), Color.argb((int) (0.9f * f), iRed, iGreen, iBlue), Color.argb((int) (f * 0.8f), iRed, iGreen, iBlue), Color.argb(0, iRed, iGreen, iBlue)}, new float[]{0.0f, 0.25f, 0.55f, 0.65f, 1.0f}, Shader.TileMode.CLAMP);
    }

    private final void createTBNFadeShader() {
        int iAlpha = Color.alpha(this.maskColor);
        int iRed = Color.red(this.maskColor);
        int iGreen = Color.green(this.maskColor);
        int iBlue = Color.blue(this.maskColor);
        float f = iAlpha;
        this._TBNfadeShader = new LinearGradient(0.0f, 0.0f, 0.0f, 1.0f, new int[]{Color.argb((int) (0.85f * f), iRed, iGreen, iBlue), Color.argb((int) (0.8f * f), iRed, iGreen, iBlue), Color.argb((int) (0.75f * f), iRed, iGreen, iBlue), Color.argb((int) (f * 0.65f), iRed, iGreen, iBlue), Color.argb(0, iRed, iGreen, iBlue)}, new float[]{0.0f, 0.35f, 0.55f, 0.65f, 1.0f}, Shader.TileMode.CLAMP);
    }

    private final void drawBottomFade(Canvas canvas) {
        float fHeight = getBounds().height();
        float fWidth = getBounds().width();
        if (fHeight <= 0.0f || fWidth <= 0.0f || this.fadeHeight <= 0) {
            return;
        }
        getPaint().setShader(getFadeShader());
        float f = this.fadeHeight;
        this.matrix.reset();
        this.matrix.setScale(1.0f, this.fadeStrength * f);
        float f4 = fHeight - f;
        this.matrix.postTranslate(0.0f, f4);
        getFadeShader().setLocalMatrix(this.matrix);
        if (this.maskScene == 1) {
            Context context = this.context;
            if (j.f8768g) {
                float dimension = context.getResources().getDimension(R$dimen.os_radius_xxxl);
                canvas.drawRoundRect(0.0f, f4, fWidth, fHeight, dimension, dimension, getPaint());
                return;
            }
        }
        canvas.drawRect(0.0f, f4, fWidth, fHeight, getPaint());
    }

    private final void drawTopFade(Canvas canvas) {
        int i8;
        float fHeight = getBounds().height();
        float fWidth = getBounds().width();
        if (fHeight <= 0.0f || fWidth <= 0.0f || (i8 = this.fadeHeight) <= 0) {
            return;
        }
        float f = i8;
        this.matrix.reset();
        this.matrix.setScale(1.0f, this.fadeStrength * f);
        this.matrix.postTranslate(0.0f, 0.0f);
        Context context = this.context;
        String[] strArr = j.f8764a;
        boolean z2 = (context.getResources().getConfiguration().uiMode & 48) == 32;
        z8.f(null, "isNightMode = " + z2);
        if (z2) {
            getPaint().setShader(getTBNfadeShader());
            getTBNfadeShader().setLocalMatrix(this.matrix);
        } else {
            getPaint().setShader(getTBLfadeShader());
            getTBLfadeShader().setLocalMatrix(this.matrix);
        }
        canvas.drawRect(0.0f, 0.0f, fWidth, f, getPaint());
    }

    private final LinearGradient getFadeShader() {
        if (this._fadeShader == null) {
            createFadeShader();
        }
        LinearGradient linearGradient = this._fadeShader;
        Intrinsics.checkNotNull(linearGradient);
        return linearGradient;
    }

    private final Paint getPaint() {
        return (Paint) this.paint.getValue();
    }

    private final LinearGradient getTBLfadeShader() {
        if (this._TBLfadeShader == null) {
            createTBLFadeShader();
        }
        LinearGradient linearGradient = this._TBLfadeShader;
        Intrinsics.checkNotNull(linearGradient);
        return linearGradient;
    }

    private final LinearGradient getTBNfadeShader() {
        if (this._TBNfadeShader == null) {
            createTBNFadeShader();
        }
        LinearGradient linearGradient = this._TBNfadeShader;
        Intrinsics.checkNotNull(linearGradient);
        return linearGradient;
    }

    private final void initMaskShader() {
        this._fadeShader = null;
        this._TBNfadeShader = null;
        this._TBLfadeShader = null;
    }

    public static /* synthetic */ void setFadeEffect$default(OSMaskDrawable oSMaskDrawable, int i8, float f, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            f = 1.0f;
        }
        oSMaskDrawable.setFadeEffect(i8, f);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.maskVisibility == 8) {
            return;
        }
        int i8 = this.maskPosition;
        if (i8 == 0) {
            drawTopFade(canvas);
            return;
        }
        if (i8 == 1) {
            drawBottomFade(canvas);
        } else {
            if (i8 != 2) {
                return;
            }
            drawBottomFade(canvas);
            drawTopFade(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        getPaint().setAlpha(alpha);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        getPaint().setColorFilter(colorFilter);
        invalidateSelf();
    }

    public final void setFadeEffect(int height, float strength) {
        this.fadeHeight = height;
        this.fadeStrength = RangesKt___RangesKt.coerceIn(strength, 0.0f, 1.0f);
        invalidateSelf();
    }

    public final void setMaskColor(int color) {
        if (color != this.maskColor) {
            this.maskColor = color;
            initMaskShader();
            invalidateSelf();
        }
    }

    public final void setMaskHeight(int height) {
        if (height != this.fadeHeight) {
            this.fadeHeight = height;
            invalidateSelf();
        }
    }

    public final void setMaskPosition(int position) {
        if (position != this.maskPosition) {
            this.maskPosition = position;
            invalidateSelf();
        }
    }

    public final void setMaskScene(int scene) {
        if (scene != this.maskScene) {
            this.maskScene = scene;
            initMaskShader();
            invalidateSelf();
        }
    }

    public final void setMaskVisibility(int visibility) {
        if (visibility != this.maskVisibility) {
            this.maskVisibility = visibility;
            invalidateSelf();
        }
    }
}
