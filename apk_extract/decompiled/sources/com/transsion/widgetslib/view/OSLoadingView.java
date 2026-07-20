package com.transsion.widgetslib.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.widgetslib.R$color;
import com.transsion.widgetslib.R$dimen;
import com.transsion.widgetslib.R$integer;
import com.transsion.widgetslib.R$styleable;
import com.transsion.widgetslib.view.OSLoadingView;
import dc.c;
import ke.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import pd.j;
import qd.e;
import qd.f;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\u0006J\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0015\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u001a\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0019R#\u0010 \u001a\n \u001c*\u0004\u0018\u00010\u001b0\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0012\u001a\u0004\b\u001e\u0010\u001fR#\u0010#\u001a\n \u001c*\u0004\u0018\u00010\u001b0\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0012\u001a\u0004\b\"\u0010\u001fR#\u0010&\u001a\n \u001c*\u0004\u0018\u00010\u001b0\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u0012\u001a\u0004\b%\u0010\u001fR\"\u0010.\u001a\u00020'8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-¨\u0006/"}, d2 = {"Lcom/transsion/widgetslib/view/OSLoadingView;", "Landroid/view/View;", "", "runningType", "", "setRunningType", "(I)V", "", "percent", "setPullPercent", "(F)V", "dotColorRes", "setDotColor", "", "getDistance", "()D", "Landroid/graphics/Paint;", "b", "Lkotlin/Lazy;", "getMPaint", "()Landroid/graphics/Paint;", "mPaint", "Landroid/graphics/Path;", "e", "getMPath", "()Landroid/graphics/Path;", "mPath", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "k", "getMAnimAppeal", "()Landroid/animation/ValueAnimator;", "mAnimAppeal", "l", "getMAnimCircle", "mAnimCircle", "m", "getMAnimRepel", "mAnimRepel", "", "w", "Z", "getMVisibilityChangedReStartAnim", "()Z", "setMVisibilityChangedReStartAnim", "(Z)V", "mVisibilityChangedReStartAnim", "widgetsLib_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class OSLoadingView extends View {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final /* synthetic */ int f3165z = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f3166a;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Lazy mPaint;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3168c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f3169d;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final Lazy mPath;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f3170h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f3171i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f3172j;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    public final Lazy mAnimAppeal;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    public final Lazy mAnimCircle;

    /* JADX INFO: renamed from: m, reason: collision with root package name and from kotlin metadata */
    public final Lazy mAnimRepel;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f3176n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f3177o;
    public float p;
    public float q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f3178r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final float f3179s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f3180t;
    public float u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f3181v;

    /* JADX INFO: renamed from: w, reason: collision with root package name and from kotlin metadata */
    public boolean mVisibilityChangedReStartAnim;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final boolean f3183x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f3184y;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSLoadingView(Context context) {
        this(context, null, 0, 14);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final double getDistance() {
        return Math.sqrt(Math.pow(Math.abs(this.f3171i - this.p), 2.0d) + Math.pow(Math.abs(this.f3170h - this.f3177o), 2.0d));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ValueAnimator getMAnimAppeal() {
        return (ValueAnimator) this.mAnimAppeal.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ValueAnimator getMAnimCircle() {
        return (ValueAnimator) this.mAnimCircle.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ValueAnimator getMAnimRepel() {
        return (ValueAnimator) this.mAnimRepel.getValue();
    }

    private final Paint getMPaint() {
        return (Paint) this.mPaint.getValue();
    }

    private final Path getMPath() {
        return (Path) this.mPath.getValue();
    }

    public final void d() {
        ValueAnimator mAnimCircle = getMAnimCircle();
        mAnimCircle.setDuration(850L);
        mAnimCircle.setInterpolator(new c());
        mAnimCircle.removeAllUpdateListeners();
        final int i8 = 0;
        mAnimCircle.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: qd.a

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ OSLoadingView f8978b;

            {
                this.f8978b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator it) {
                OSLoadingView this$0 = this.f8978b;
                switch (i8) {
                    case 0:
                        int i9 = OSLoadingView.f3165z;
                        Intrinsics.checkNotNullParameter(this$0, "this$0");
                        Intrinsics.checkNotNullParameter(it, "it");
                        Object animatedValue = it.getAnimatedValue();
                        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
                        this$0.u = ((Float) animatedValue).floatValue();
                        this$0.invalidate();
                        break;
                    case 1:
                        int i10 = OSLoadingView.f3165z;
                        Intrinsics.checkNotNullParameter(this$0, "this$0");
                        Intrinsics.checkNotNullParameter(it, "it");
                        Object animatedValue2 = it.getAnimatedValue();
                        Intrinsics.checkNotNull(animatedValue2, "null cannot be cast to non-null type kotlin.Float");
                        this$0.f3180t = ((Float) animatedValue2).floatValue();
                        this$0.invalidate();
                        break;
                    default:
                        int i11 = OSLoadingView.f3165z;
                        Intrinsics.checkNotNullParameter(this$0, "this$0");
                        Intrinsics.checkNotNullParameter(it, "it");
                        Object animatedValue3 = it.getAnimatedValue();
                        Intrinsics.checkNotNull(animatedValue3, "null cannot be cast to non-null type kotlin.Float");
                        this$0.f3180t = ((Float) animatedValue3).floatValue();
                        this$0.invalidate();
                        break;
                }
            }
        });
        mAnimCircle.start();
        ValueAnimator mAnimAppeal = getMAnimAppeal();
        mAnimAppeal.setDuration(500L);
        mAnimAppeal.setStartDelay(500L);
        mAnimAppeal.setInterpolator(new c());
        mAnimAppeal.removeAllUpdateListeners();
        final int i9 = 1;
        mAnimAppeal.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: qd.a

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ OSLoadingView f8978b;

            {
                this.f8978b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator it) {
                OSLoadingView this$0 = this.f8978b;
                switch (i9) {
                    case 0:
                        int i10 = OSLoadingView.f3165z;
                        Intrinsics.checkNotNullParameter(this$0, "this$0");
                        Intrinsics.checkNotNullParameter(it, "it");
                        Object animatedValue = it.getAnimatedValue();
                        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
                        this$0.u = ((Float) animatedValue).floatValue();
                        this$0.invalidate();
                        break;
                    case 1:
                        int i11 = OSLoadingView.f3165z;
                        Intrinsics.checkNotNullParameter(this$0, "this$0");
                        Intrinsics.checkNotNullParameter(it, "it");
                        Object animatedValue2 = it.getAnimatedValue();
                        Intrinsics.checkNotNull(animatedValue2, "null cannot be cast to non-null type kotlin.Float");
                        this$0.f3180t = ((Float) animatedValue2).floatValue();
                        this$0.invalidate();
                        break;
                    default:
                        int i12 = OSLoadingView.f3165z;
                        Intrinsics.checkNotNullParameter(this$0, "this$0");
                        Intrinsics.checkNotNullParameter(it, "it");
                        Object animatedValue3 = it.getAnimatedValue();
                        Intrinsics.checkNotNull(animatedValue3, "null cannot be cast to non-null type kotlin.Float");
                        this$0.f3180t = ((Float) animatedValue3).floatValue();
                        this$0.invalidate();
                        break;
                }
            }
        });
        mAnimAppeal.start();
        ValueAnimator mAnimRepel = getMAnimRepel();
        mAnimRepel.setDuration(500L);
        mAnimRepel.setStartDelay(1000L);
        mAnimRepel.setInterpolator(new c());
        mAnimRepel.removeAllUpdateListeners();
        final int i10 = 2;
        mAnimRepel.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: qd.a

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ OSLoadingView f8978b;

            {
                this.f8978b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator it) {
                OSLoadingView this$0 = this.f8978b;
                switch (i10) {
                    case 0:
                        int i11 = OSLoadingView.f3165z;
                        Intrinsics.checkNotNullParameter(this$0, "this$0");
                        Intrinsics.checkNotNullParameter(it, "it");
                        Object animatedValue = it.getAnimatedValue();
                        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
                        this$0.u = ((Float) animatedValue).floatValue();
                        this$0.invalidate();
                        break;
                    case 1:
                        int i12 = OSLoadingView.f3165z;
                        Intrinsics.checkNotNullParameter(this$0, "this$0");
                        Intrinsics.checkNotNullParameter(it, "it");
                        Object animatedValue2 = it.getAnimatedValue();
                        Intrinsics.checkNotNull(animatedValue2, "null cannot be cast to non-null type kotlin.Float");
                        this$0.f3180t = ((Float) animatedValue2).floatValue();
                        this$0.invalidate();
                        break;
                    default:
                        int i13 = OSLoadingView.f3165z;
                        Intrinsics.checkNotNullParameter(this$0, "this$0");
                        Intrinsics.checkNotNullParameter(it, "it");
                        Object animatedValue3 = it.getAnimatedValue();
                        Intrinsics.checkNotNull(animatedValue3, "null cannot be cast to non-null type kotlin.Float");
                        this$0.f3180t = ((Float) animatedValue3).floatValue();
                        this$0.invalidate();
                        break;
                }
            }
        });
        mAnimRepel.removeAllListeners();
        mAnimRepel.addListener(new d(this, 3));
        mAnimRepel.start();
    }

    public final void e(Canvas canvas) {
        double distance = getDistance() / ((double) (this.f3166a * this.f3179s));
        if (distance > 0.9d) {
            distance = 1.0d;
        }
        float f = this.f3169d;
        double d7 = ((double) (2.0f * f)) - (((double) (2.25f * f)) * distance);
        if (d7 > (3 * f) / 4) {
            d7 = f;
        }
        if (d7 < (-f)) {
            d7 = -f;
        }
        double d10 = d7;
        double d11 = 1.5707963267948966d - ((distance * 3.141592653589793d) / ((double) 6));
        double d12 = 6.283185307179586d - ((double) this.u);
        if (d12 < 0.0d) {
            d12 = 0.0d;
        }
        double d13 = d11 + d12;
        float fCos = (float) ((Math.cos(d13) * ((double) f)) + ((double) this.f3177o));
        float fSin = (float) (((double) this.p) - (Math.sin(d13) * ((double) this.f3169d)));
        float f4 = this.q;
        float f10 = this.f3177o;
        float f11 = 2;
        double d14 = 1.5707963267948966d - d12;
        float fCos2 = (float) (((double) (((f4 - f10) / f11) + f10)) - (Math.cos(d14) * d10));
        float f12 = this.f3178r;
        float f13 = this.p;
        float fSin2 = (float) (((double) (((f12 - f13) / f11) + f13)) - (Math.sin(d14) * d10));
        double d15 = d12 - d11;
        float fCos3 = (float) (((double) this.q) - (Math.cos(d15) * ((double) this.f3169d)));
        float fA = (float) a1.a.a(d15, this.f3169d, this.f3178r);
        float fCos4 = (float) ((Math.cos(d15) * ((double) this.f3169d)) + ((double) this.f3177o));
        float fSin3 = (float) (((double) this.p) - (Math.sin(d15) * ((double) this.f3169d)));
        float f14 = this.q;
        float f15 = this.f3177o;
        float fCos5 = (float) ((Math.cos(d14) * d10) + ((double) (((f14 - f15) / f11) + f15)));
        float f16 = this.f3178r;
        float f17 = this.p;
        float fA2 = (float) a1.a.a(d14, d10, ((f16 - f17) / f11) + f17);
        float fCos6 = (float) (((double) this.q) - (Math.cos(d13) * ((double) this.f3169d)));
        float fA3 = (float) a1.a.a(d13, this.f3169d, this.f3178r);
        getMPath().moveTo(fCos, fSin);
        getMPath().quadTo(fCos2, fSin2, fCos3, fA);
        getMPath().lineTo(fCos6, fA3);
        getMPath().quadTo(fCos5, fA2, fCos4, fSin3);
        getMPath().close();
        canvas.drawPath(getMPath(), getMPaint());
    }

    public final void f() {
        int dimensionPixelSize;
        int dimensionPixelSize2;
        int i8 = this.f3176n;
        if (i8 == getContext().getResources().getInteger(R$integer.OSLoadingViewSmall)) {
            dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.os_dimen_loading_view_size_small);
        } else {
            dimensionPixelSize = i8 == getContext().getResources().getInteger(R$integer.OSLoadingViewLarge) ? getResources().getDimensionPixelSize(R$dimen.os_dimen_loading_view_size_large) : getResources().getDimensionPixelSize(R$dimen.os_dimen_loading_view_size_medium);
        }
        this.f3166a = dimensionPixelSize;
        int i9 = this.f3176n;
        if (i9 == getContext().getResources().getInteger(R$integer.OSLoadingViewSmall)) {
            dimensionPixelSize2 = getResources().getDimensionPixelSize(R$dimen.os_dimen_loading_view_dot_size_small);
        } else {
            dimensionPixelSize2 = i9 == getContext().getResources().getInteger(R$integer.OSLoadingViewLarge) ? getResources().getDimensionPixelSize(R$dimen.os_dimen_loading_view_dot_size_large) : getResources().getDimensionPixelSize(R$dimen.os_dimen_loading_view_dot_size_medium);
        }
        float f = dimensionPixelSize2;
        float f4 = 2;
        float f10 = this.f3166a / f4;
        this.f3166a = f10;
        this.f3169d = f / f4;
        if (this.f3172j != 0) {
            f10 = 0.0f;
        }
        this.f3180t = f10;
        getMAnimAppeal().setFloatValues(this.f3166a, 0.0f);
        getMAnimRepel().setFloatValues(0.0f, this.f3166a);
    }

    public final void g() {
        ValueAnimator mAnimRepel = getMAnimRepel();
        if (mAnimRepel != null) {
            mAnimRepel.removeAllListeners();
            mAnimRepel.removeAllUpdateListeners();
            if (mAnimRepel.isStarted()) {
                mAnimRepel.cancel();
            }
        }
        ValueAnimator mAnimCircle = getMAnimCircle();
        if (mAnimCircle != null) {
            mAnimCircle.removeAllUpdateListeners();
            if (mAnimCircle.isStarted()) {
                mAnimCircle.cancel();
            }
        }
        ValueAnimator mAnimAppeal = getMAnimAppeal();
        if (mAnimAppeal != null) {
            mAnimAppeal.removeAllUpdateListeners();
            if (mAnimAppeal.isStarted()) {
                mAnimAppeal.cancel();
            }
        }
        this.u = 6.2831855f;
        this.f3180t = this.f3166a;
    }

    public final boolean getMVisibilityChangedReStartAnim() {
        return this.mVisibilityChangedReStartAnim;
    }

    public final void h() {
        if (getMAnimAppeal().isStarted() || getMAnimRepel().isStarted() || getMAnimCircle().isStarted()) {
            return;
        }
        this.u = 6.2831855f;
        float f = this.f3166a;
        this.f3180t = f;
        this.f3172j = 0;
        this.f3180t = f;
        d();
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        g();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        if (this.f3183x) {
            canvas.scale(0.9f, 0.9f);
            float f = 2;
            canvas.translate((getWidth() * 0.100000024f) / f, (getHeight() * 0.100000024f) / f);
        }
        getMPath().reset();
        int i8 = this.f3172j;
        float f4 = this.f3179s;
        if (i8 == 1) {
            float f10 = this.f3170h;
            float f11 = this.f3166a;
            float f12 = this.f3181v;
            float f13 = f10 - (f11 * f12);
            this.f3177o = f13;
            int i9 = this.f3168c;
            float f14 = i9 / 2.0f;
            this.p = f14;
            this.q = (f11 * f12) + f10;
            this.f3178r = i9 / 2.0f;
            canvas.drawCircle(f13, f14, this.f3169d, getMPaint());
            canvas.drawCircle(this.q, this.f3178r, this.f3169d, getMPaint());
            if (getDistance() <= this.f3166a * f4) {
                e(canvas);
                return;
            }
            return;
        }
        this.f3177o = this.f3170h - (this.f3180t * ((float) Math.cos(this.u)));
        this.p = this.f3171i - (this.f3180t * ((float) Math.sin(this.u)));
        this.q = (this.f3180t * ((float) Math.cos(this.u))) + this.f3170h;
        this.f3178r = (this.f3180t * ((float) Math.sin(this.u))) + this.f3171i;
        canvas.drawCircle(this.f3177o, this.p, this.f3169d, getMPaint());
        canvas.drawCircle(this.q, this.f3178r, this.f3169d, getMPaint());
        if (getDistance() <= this.f3166a * f4) {
            float f15 = this.u;
            if ((f15 <= 0.5235987755982988d || f15 >= 6.283185307179586d) && Math.abs(((double) f15) - 6.283185307179586d) > 1.0E-6d) {
                return;
            }
            e(canvas);
        }
    }

    @Override // android.view.View
    public final void onLayout(boolean z2, int i8, int i9, int i10, int i11) {
        super.onLayout(z2, i8, i9, i10, i11);
        if (this.f3172j != 0 || getMAnimAppeal().isRunning()) {
            return;
        }
        d();
    }

    @Override // android.view.View
    public final void onMeasure(int i8, int i9) {
        int iA;
        int integer;
        super.onMeasure(i8, i9);
        if (View.MeasureSpec.getMode(i8) == 1073741824) {
            if (getMeasuredWidth() < getContext().getResources().getDimensionPixelSize(R$dimen.os_loading_medium_size)) {
                integer = getContext().getResources().getInteger(R$integer.OSLoadingViewSmall);
            } else {
                integer = getMeasuredWidth() < getContext().getResources().getDimensionPixelSize(R$dimen.os_loading_default_size) ? getContext().getResources().getInteger(R$integer.OSLoadingViewMedium) : getContext().getResources().getInteger(R$integer.OSLoadingViewLarge);
            }
            this.f3176n = integer;
            f();
            iA = getMeasuredWidth();
        } else {
            float f = 2;
            float f4 = (this.f3169d * f) + (this.f3166a * f);
            Context context = getContext();
            String[] strArr = j.f8764a;
            iA = (int) (f4 + hd.a.a(context, 2));
            setMeasuredDimension(iA, iA);
        }
        this.f3168c = iA;
        float f10 = iA / 2.0f;
        this.f3170h = f10;
        this.f3171i = f10;
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View changedView, int i8) {
        Intrinsics.checkNotNullParameter(changedView, "changedView");
        super.onVisibilityChanged(changedView, i8);
        if (isAttachedToWindow()) {
            if (!isShown()) {
                g();
            } else if (this.f3172j == 0) {
                h();
            }
        }
    }

    public final void setDotColor(int dotColorRes) {
        this.f3184y = getContext().getResources().getColor(dotColorRes, null);
        getMPaint().setColor(this.f3184y);
        postInvalidate();
    }

    public final void setMVisibilityChangedReStartAnim(boolean z2) {
        this.mVisibilityChangedReStartAnim = z2;
    }

    public final void setPullPercent(float percent) {
        if (this.f3172j != 1) {
            this.f3172j = 1;
        }
        g();
        this.f3181v = percent;
        postInvalidate();
    }

    public void setRunningType(int runningType) {
        this.f3172j = runningType;
        this.f3180t = runningType == 0 ? this.f3166a : 0.0f;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSLoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 12);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSLoadingView(Context context, AttributeSet attributeSet, int i8) {
        this(context, attributeSet, i8, 8);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public OSLoadingView(Context context, AttributeSet attributeSet, int i8, int i9) {
        attributeSet = (i9 & 2) != 0 ? null : attributeSet;
        i8 = (i9 & 4) != 0 ? 0 : i8;
        Intrinsics.checkNotNullParameter(context, "context");
        super(context, attributeSet, i8, 0);
        this.mPaint = LazyKt.lazy(e.INSTANCE);
        this.mPath = LazyKt.lazy(f.INSTANCE);
        this.mAnimAppeal = LazyKt.lazy(new qd.b(this));
        this.mAnimCircle = LazyKt.lazy(qd.c.INSTANCE);
        this.mAnimRepel = LazyKt.lazy(new qd.d(this));
        this.f3179s = 0.6f;
        this.u = 6.2831855f;
        this.f3183x = j.z(getContext());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.OSLoadingView);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr….styleable.OSLoadingView)");
        this.f3176n = typedArrayObtainStyledAttributes.getInteger(R$styleable.OSLoadingView_os_lv_type, context.getResources().getInteger(R$integer.OSLoadingViewMedium));
        this.f3184y = typedArrayObtainStyledAttributes.getColor(R$styleable.OSLoadingView_os_lv_dot_color, context.getColor(R$color.os_comp_color_loading_hios));
        this.f3172j = typedArrayObtainStyledAttributes.getInteger(R$styleable.OSLoadingView_os_lv_running_type, 0);
        typedArrayObtainStyledAttributes.recycle();
        Paint mPaint = getMPaint();
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
        mPaint.setColor(this.f3184y);
        f();
    }
}
