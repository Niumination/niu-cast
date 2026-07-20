package com.transsion.widgetslib.widget.seekbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import com.transsion.widgetslib.R$attr;
import com.transsion.widgetslib.R$color;
import com.transsion.widgetslib.R$dimen;
import com.transsion.widgetslib.R$style;
import com.transsion.widgetslib.R$styleable;
import ee.g;
import ee.h;
import ee.i;
import ee.k;
import ee.l;
import ie.a;
import java.lang.ref.WeakReference;
import jd.j;
import k3.a2;
import k3.z8;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001:\u0003VN\u0013B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0011\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0017\u001a\u00020\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0006¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u0006¢\u0006\u0004\b\u001d\u0010\u001bJ\u0015\u0010\u001f\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u0006¢\u0006\u0004\b\u001f\u0010\u001bJ\u0015\u0010!\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u0006¢\u0006\u0004\b!\u0010\u001bJ\u0015\u0010\"\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u0006¢\u0006\u0004\b\"\u0010\u001bJ\u000f\u0010$\u001a\u0004\u0018\u00010#¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u0004\u0018\u00010#¢\u0006\u0004\b&\u0010%J\u0011\u0010(\u001a\u0004\u0018\u00010'H\u0007¢\u0006\u0004\b(\u0010)J\u0019\u0010+\u001a\u00020\f2\b\u0010*\u001a\u0004\u0018\u00010'H\u0007¢\u0006\u0004\b+\u0010,J\u0015\u0010.\u001a\u00020\f2\u0006\u0010-\u001a\u00020\u000f¢\u0006\u0004\b.\u0010\u0012J\u000f\u0010/\u001a\u00020\u0006H\u0002¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\u0006H\u0002¢\u0006\u0004\b1\u00100J\u000f\u00102\u001a\u00020\u0006H\u0002¢\u0006\u0004\b2\u00100J\u000f\u00103\u001a\u00020\u0006H\u0002¢\u0006\u0004\b3\u00100R$\u00109\u001a\u00020\n2\u0006\u00104\u001a\u00020\n8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R$\u0010<\u001a\u00020\n2\u0006\u00104\u001a\u00020\n8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b:\u00106\u001a\u0004\b;\u00108R$\u0010A\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010)\"\u0004\b@\u0010,R\"\u0010G\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010\u0012R\"\u0010I\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bH\u0010C\u001a\u0004\bI\u0010E\"\u0004\bJ\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\bK\u00100R\u0011\u0010M\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\bL\u00108R\u0011\u0010Q\u001a\u00020N8F¢\u0006\u0006\u001a\u0004\bO\u0010PR\u0014\u0010S\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bR\u00100R\u0014\u0010U\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bT\u00108¨\u0006W"}, d2 = {"Lcom/transsion/widgetslib/widget/seekbar/OSSeekbar;", "Landroid/view/View;", "Landroid/content/Context;", "mContext", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "progress", "", "setProgress", "(F)V", "", "isForceProgress", "setForceProgress", "(Z)V", "Lee/j;", "getOnProgressChangedListener", "()Lee/j;", "listener", "setOnProgressChangedListener", "(Lee/j;)V", "trackColor", "setTrackColor", "(I)V", "secondTrackColor", "setSecondTrackColor", "thumbInsideUnAbleColorHios", "setThumbInsideUnAbleColorHios", "thumbColor", "setThumbOutColor", "setThumbInsideColor", "Landroid/widget/ImageView;", "getLeftIcon", "()Landroid/widget/ImageView;", "getRightIcon", "Landroid/graphics/drawable/Drawable;", "getThumb", "()Landroid/graphics/drawable/Drawable;", "drawable", "setThumb", "(Landroid/graphics/drawable/Drawable;)V", "vibrateAble", "setVibrateAble", "getDotColor", "()I", "getSecondTrackColor", "getThumbOutColor", "getThumbInSideColor", "<set-?>", "b", "F", "getMin", "()F", "min", "c", "getMax", "max", "r0", "Landroid/graphics/drawable/Drawable;", "getThumbDrawable", "setThumbDrawable", "thumbDrawable", "s0", "Z", "getOnlyHiOSStyle", "()Z", "setOnlyHiOSStyle", "onlyHiOSStyle", "t0", "isNoThumb", "setNoThumb", "getProgress", "getProgressFloat", "progressFloat", "Lee/i;", "getConfigBuilder", "()Lee/i;", "configBuilder", "getContentHeight", "contentHeight", "getThumbHalfSizeOnTouchDown", "thumbHalfSizeOnTouchDown", "k3/a2", "widgetsLib_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public class OSSeekbar extends View {
    public static final /* synthetic */ int D0 = 0;
    public float A;
    public boolean A0;
    public float B;
    public final int B0;
    public float C;
    public int C0;
    public float D;
    public float E;
    public float F;
    public float G;
    public float H;
    public float I;
    public float J;
    public float K;
    public float L;
    public float M;
    public float N;
    public boolean O;
    public float P;
    public int Q;
    public int R;
    public int S;
    public int T;
    public int U;
    public int V;
    public boolean W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f3576a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public int f3577a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public float min;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public int f3579b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    public float max;
    public int c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f3581d;
    public boolean d0;
    public float e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public boolean f3582e0;
    public boolean f0;
    public boolean g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f3583h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public final j f3584h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f3585i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public final j f3586i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f3587j;
    public ValueAnimator j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f3588k;
    public ValueAnimator k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f3589l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public ValueAnimator f3590l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f3591m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public final Paint f3592m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f3593n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public final Paint f3594n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f3595o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public i f3596o0;
    public float p;
    public ImageView p0;
    public float q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public ImageView f3597q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f3598r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name and from kotlin metadata */
    public Drawable thumbDrawable;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f3600s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name and from kotlin metadata */
    public boolean onlyHiOSStyle;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f3602t;

    /* JADX INFO: renamed from: t0, reason: from kotlin metadata */
    public boolean isNoThumb;
    public float u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public int f3603u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f3604v;
    public int v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f3605w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public int f3606w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f3607x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public int f3608x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f3609y;
    public final h y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f3610z;
    public boolean z0;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSSeekbar(Context mContext) {
        this(mContext, null, 6, 0);
        Intrinsics.checkNotNullParameter(mContext, "mContext");
    }

    private final int getContentHeight() {
        if (i()) {
            return (int) (this.E * 2);
        }
        return (int) Math.max((int) (((this.f3605w * this.H) + (this.f3610z * this.D)) * 2), this.e);
    }

    private final int getDotColor() {
        return isEnabled() ? this.f3606w0 : this.f3608x0;
    }

    private final int getSecondTrackColor() {
        return isEnabled() ? this.R : this.f3577a0;
    }

    private final float getThumbHalfSizeOnTouchDown() {
        if (i()) {
            return this.f3607x;
        }
        return (this.f3605w * this.H) + (this.f3607x * this.D);
    }

    private final int getThumbInSideColor() {
        return isEnabled() ? this.U : this.c0;
    }

    private final int getThumbOutColor() {
        return isEnabled() ? this.T : this.f3579b0;
    }

    public final float a(float f) {
        float f4 = this.q;
        if (f <= f4) {
            return f4;
        }
        float f10 = this.f3598r;
        return f >= f10 ? f10 : f;
    }

    public final float b(float f) {
        if (j() && this.f3604v) {
            return this.f3581d;
        }
        float f4 = ((f - this.q) * this.f3589l) / this.f3595o;
        float f10 = this.min;
        float f11 = f4 + f10;
        if (f11 < f10) {
            return f10;
        }
        float f12 = this.max;
        return f11 > f12 ? f12 : f11;
    }

    public final ValueAnimator c(float f, float f4) {
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(f, f4);
        valueAnimator.setDuration(250L);
        valueAnimator.setInterpolator(new a(0.25f, 0.0f));
        valueAnimator.addUpdateListener(new g(this, 1));
        Intrinsics.checkNotNullExpressionValue(valueAnimator, "valueAnimator");
        return valueAnimator;
    }

    public final ValueAnimator d() {
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0.0f, 0.5f, 1.0f);
        valueAnimator.setDuration(500L);
        valueAnimator.setInterpolator(new a(0.4f, 0.2f));
        valueAnimator.addUpdateListener(new k(this, 0));
        valueAnimator.addListener(new l(this, 0));
        Intrinsics.checkNotNullExpressionValue(valueAnimator, "valueAnimator");
        return valueAnimator;
    }

    public final ValueAnimator e() {
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0.0f, 0.5f, 1.0f);
        valueAnimator.addUpdateListener(new g(this, 2));
        valueAnimator.addListener(new l(this, 1));
        Intrinsics.checkNotNullExpressionValue(valueAnimator, "valueAnimator");
        return valueAnimator;
    }

    public final ValueAnimator f(float f, float f4) {
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(f, f4);
        valueAnimator.setDuration(250L);
        valueAnimator.setInterpolator(new a(0.4f, 0.2f));
        valueAnimator.addUpdateListener(new g(this, 0));
        Intrinsics.checkNotNullExpressionValue(valueAnimator, "valueAnimator");
        return valueAnimator;
    }

    public final ImageView g(int i8) {
        ImageView imageView = new ImageView(getContext());
        int dimensionPixelOffset = getContext().getResources().getDimensionPixelOffset(R$dimen.os_dimen_icon_common_size);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(dimensionPixelOffset, dimensionPixelOffset));
        imageView.setImageResource(i8);
        return imageView;
    }

    public final i getConfigBuilder() {
        if (this.f3596o0 == null) {
            this.f3596o0 = new i(this);
        }
        i iVar = this.f3596o0;
        Intrinsics.checkNotNull(iVar);
        return iVar;
    }

    /* JADX INFO: renamed from: getLeftIcon, reason: from getter */
    public final ImageView getP0() {
        return this.p0;
    }

    public final float getMax() {
        return this.max;
    }

    public final float getMin() {
        return this.min;
    }

    public ee.j getOnProgressChangedListener() {
        return null;
    }

    public final boolean getOnlyHiOSStyle() {
        return this.onlyHiOSStyle;
    }

    public final int getProgress() {
        return j() ? Math.round(b(this.J)) : Math.round(this.f3581d);
    }

    public final float getProgressFloat() {
        return j() ? b(this.J) : this.f3581d;
    }

    /* JADX INFO: renamed from: getRightIcon, reason: from getter */
    public final ImageView getF3597q0() {
        return this.f3597q0;
    }

    @Nullable
    /* JADX INFO: renamed from: getThumb, reason: from getter */
    public final Drawable getThumbDrawable() {
        return this.thumbDrawable;
    }

    public final Drawable getThumbDrawable() {
        return this.thumbDrawable;
    }

    public final void h() {
        if (this.min == this.max) {
            this.min = 0.0f;
            this.max = 100.0f;
        }
        float f = this.min;
        float f4 = this.max;
        if (f > f4) {
            this.max = f;
            this.min = f4;
        }
        float f10 = this.f3581d;
        float f11 = this.min;
        if (f10 < f11) {
            this.f3581d = f11;
        }
        float f12 = this.f3581d;
        float f13 = this.max;
        if (f12 > f13) {
            this.f3581d = f13;
        }
        this.f3589l = f13 - f11;
        setProgress(this.f3581d);
    }

    public final boolean i() {
        return pd.j.f8765b || this.onlyHiOSStyle;
    }

    public final boolean j() {
        ValueAnimator valueAnimator = this.f3590l0;
        if (valueAnimator != null) {
            Intrinsics.checkNotNull(valueAnimator);
            if (valueAnimator.isRunning()) {
                return true;
            }
        }
        return false;
    }

    public final void k(float f) {
        if (this.A0) {
            int iB = (int) b(f);
            if (iB == this.B0 && iB != this.C0) {
                if (!this.z0) {
                    z8.f(null, "vibrate Able is false");
                } else if (pd.j.f8781w && getHandler() != null && pd.j.f8772k) {
                    Handler handler = getHandler();
                    h hVar = this.y0;
                    if (!handler.hasCallbacks(hVar)) {
                        getHandler().postDelayed(hVar, 50L);
                    }
                }
                z8.f("OSSeekbar", "onProgressVibrate: vibrate calculateProgress = " + iB);
            }
            this.C0 = iB;
        }
    }

    public final void l(float f, float f4) {
        this.f3582e0 = true;
        ValueAnimator valueAnimator = this.f3590l0;
        if (valueAnimator == null) {
            this.f3590l0 = d();
        } else {
            Intrinsics.checkNotNull(valueAnimator);
            if (valueAnimator.isRunning()) {
                ValueAnimator valueAnimator2 = this.f3590l0;
                Intrinsics.checkNotNull(valueAnimator2);
                valueAnimator2.cancel();
                this.f3590l0 = d();
            }
        }
        ValueAnimator valueAnimator3 = this.f3590l0;
        Intrinsics.checkNotNull(valueAnimator3);
        valueAnimator3.setDuration(250L);
        this.V = 1;
        float fAbs = (float) Math.abs(f4 - f);
        float f10 = this.f3607x;
        if (fAbs > f10) {
            float fB = a1.a.b(fAbs, f10, 0.18f, f10);
            float f11 = this.f3609y;
            if (fB > f11) {
                fB = f11;
            }
            this.K = this.A;
            this.L = fB;
            this.M = f10;
        } else {
            this.K = this.A;
            this.L = f10;
            this.M = f10;
        }
        this.I = f;
        this.J = f4;
        ValueAnimator valueAnimator4 = this.f3590l0;
        Intrinsics.checkNotNull(valueAnimator4);
        valueAnimator4.start();
    }

    public final void m(float f, float f4, long j8, boolean z2) {
        this.f3582e0 = true;
        ValueAnimator valueAnimator = this.f3590l0;
        if (valueAnimator == null) {
            this.f3590l0 = e();
        } else {
            Intrinsics.checkNotNull(valueAnimator);
            if (valueAnimator.isRunning()) {
                ValueAnimator valueAnimator2 = this.f3590l0;
                Intrinsics.checkNotNull(valueAnimator2);
                valueAnimator2.cancel();
                this.f3590l0 = e();
            }
        }
        ValueAnimator valueAnimator3 = this.f3590l0;
        Intrinsics.checkNotNull(valueAnimator3);
        valueAnimator3.setDuration(j8);
        this.I = f;
        this.J = f4;
        this.N = this.f3585i;
        this.O = z2;
        this.G = this.F;
        ValueAnimator valueAnimator4 = this.f3590l0;
        if (valueAnimator4 != null) {
            valueAnimator4.setInterpolator(z2 ? new PathInterpolator(0.0f, 0.0f, 0.2f, 1.0f) : new LinearInterpolator());
            valueAnimator4.start();
        }
    }

    public final void n(float f, float f4) {
        ValueAnimator valueAnimator = this.k0;
        if (valueAnimator == null) {
            this.k0 = c(f, f4);
        } else {
            Intrinsics.checkNotNull(valueAnimator);
            if (valueAnimator.isRunning()) {
                ValueAnimator valueAnimator2 = this.k0;
                Intrinsics.checkNotNull(valueAnimator2);
                valueAnimator2.cancel();
                this.k0 = c(f, f4);
            } else {
                ValueAnimator valueAnimator3 = this.k0;
                Intrinsics.checkNotNull(valueAnimator3);
                valueAnimator3.setFloatValues(f, f4);
            }
        }
        ValueAnimator valueAnimator4 = this.k0;
        Intrinsics.checkNotNull(valueAnimator4);
        valueAnimator4.start();
    }

    public final void o(float f, float f4) {
        if (!this.f3584h0.f6183c) {
            this.f3584h0.set(f);
        }
        this.f3584h0.setTargValue(f4);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        float f;
        float f4;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        if (i()) {
            float f10 = this.q;
            float f11 = this.f3598r;
            float f12 = this.f3593n;
            if (!this.W && !this.f3582e0) {
                float f13 = this.f3595o / this.f3589l;
                float f14 = this.f3581d;
                float f15 = this.min;
                this.f3591m = a1.a.b(f14, f15, f13, f10);
                if (this.isNoThumb) {
                    if (f14 == this.max) {
                        this.f3591m = (this.E / 2) + f11;
                    } else if (f14 == f15) {
                        this.f3591m = f10 - (this.E / 2);
                    }
                }
            }
            Paint paint = this.f3592m0;
            paint.setColor(this.Q);
            paint.setStrokeWidth(this.f3585i);
            float f16 = 2;
            canvas.drawLine((paint.getStrokeWidth() / f16) + (f10 - this.E), f12, ((this.E + f11) - (paint.getStrokeWidth() / f16)) - (this.u / f16), f12, paint);
            float f17 = this.f3591m;
            paint.setColor(getSecondTrackColor());
            paint.setStrokeWidth(this.f3587j);
            canvas.drawLine((paint.getStrokeWidth() / f16) + (f10 - this.E), f12, f17, f12, paint);
            if (this.A0) {
                float f18 = (f11 - this.q) / f16;
                float f19 = pd.j.v() ? f11 - f18 : f18 + this.q;
                if (f18 >= this.f3591m) {
                    paint.setColor(this.v0);
                } else {
                    paint.setColor(getDotColor());
                }
                canvas.drawCircle(f19, f12, this.f3603u0 * 0.5f, paint);
            }
            Drawable drawable = this.thumbDrawable;
            if (drawable != null) {
                float f20 = this.E;
                float f21 = this.F;
                float f22 = (int) (((0.1f * f21) + 0.9f) * f20 * f21);
                float f23 = this.f3593n;
                Intrinsics.checkNotNull(drawable);
                drawable.setBounds((int) (f17 - f22), (int) (f23 - f22), (int) (f17 + f22), (int) (f23 + f22));
                Drawable drawable2 = this.thumbDrawable;
                Intrinsics.checkNotNull(drawable2);
                drawable2.draw(canvas);
                return;
            }
            Paint paint2 = this.f3594n0;
            Paint.Style style = Paint.Style.FILL;
            paint2.setStyle(style);
            paint2.setColor(getThumbOutColor());
            paint2.setAlpha(255);
            float f24 = this.E;
            float f25 = f24 - this.f3605w;
            float f26 = this.F;
            if (f26 > 0.0f && !this.isNoThumb) {
                canvas.drawCircle(f17, this.f3593n, ((f26 * 0.1f) + 0.9f) * f24, paint2);
            }
            paint2.setStyle(style);
            int thumbInSideColor = getThumbInSideColor();
            paint2.setColor((thumbInSideColor & ViewCompat.MEASURED_SIZE_MASK) | (((int) ((thumbInSideColor >>> 24) * this.F)) << 24));
            if (this.isNoThumb) {
                return;
            }
            canvas.drawCircle(f17, this.f3593n, f25 * this.F, paint2);
            return;
        }
        float f27 = this.q;
        float f28 = this.f3598r;
        float f29 = this.f3593n;
        if (!this.W && !this.f3582e0) {
            this.f3591m = a1.a.b(this.f3581d, this.min, this.f3595o / this.f3589l, f27);
        }
        this.f3592m0.setColor(this.Q);
        this.f3592m0.setStrokeWidth(this.e);
        float f30 = this.E;
        float f31 = this.f3605w;
        canvas.drawLine((f27 - f30) + f31, f29, (f30 + f28) - f31, f29, this.f3592m0);
        float f32 = this.f3591m;
        this.f3592m0.setColor(getSecondTrackColor());
        this.f3592m0.setStrokeWidth(this.f3583h);
        canvas.drawLine((f27 - this.E) + this.f3605w, f29, f32, f29, this.f3592m0);
        if (this.A0) {
            float f33 = (f28 - this.q) / 2;
            float f34 = pd.j.v() ? f28 - f33 : f33 + this.q;
            float f35 = this.f3591m;
            Paint paint3 = this.f3592m0;
            if (f33 < f35 && isEnabled()) {
                paint3.setColor(this.f3606w0);
            } else {
                paint3.setColor(this.v0);
            }
            canvas.drawCircle(f34, f29, this.f3603u0 * 0.5f, paint3);
        }
        this.f3594n0.setColor(getThumbOutColor());
        Paint paint4 = this.f3594n0;
        Paint.Style style2 = Paint.Style.FILL;
        paint4.setStyle(style2);
        boolean zA = false;
        if (!j()) {
            if (this.f3584h0.f6183c) {
                zA = this.f3584h0.a(0.064f);
                this.A = this.f3584h0.getAnimatedValue();
            }
            if (this.f3586i0.f6183c) {
                zA |= this.f3586i0.a(0.256f);
                float animatedValue = this.f3586i0.getAnimatedValue();
                this.f3591m = animatedValue;
                this.f3581d = b(animatedValue);
            }
        }
        boolean z2 = zA;
        float f36 = this.B;
        float f37 = this.A;
        float f38 = this.f3593n;
        float f39 = this.f3610z * f36;
        float f40 = f38 - f39;
        float f41 = f39 + f38;
        int i8 = this.V;
        if (i8 == 0) {
            float f42 = this.f3607x;
            float f43 = f32 - (((f37 - f42) + f37) * f36);
            f = f32 + (f42 * f36);
            f4 = f43;
        } else if (i8 == 1 || i8 != 2) {
            float f44 = f37 * f36;
            f4 = f32 - f44;
            f = f32 + f44;
        } else {
            float f45 = this.f3607x;
            float f46 = f32 - (f45 * f36);
            f = f32 + (((f37 - f45) + f37) * f36);
            f4 = f46;
        }
        float f47 = this.f3605w * this.C;
        float fMax = (float) Math.max(f4, f47);
        float fMin = (float) Math.min(f, getWidth() - f47);
        float fMax2 = (float) Math.max(fMax - f47, 0.0d);
        float f48 = f40 - f47;
        float fMin2 = (float) Math.min(fMin + f47, getWidth());
        float f49 = f41 + f47;
        float f50 = this.f3610z * f36;
        float f51 = f50 + f47;
        Drawable drawable3 = this.thumbDrawable;
        if (drawable3 == null) {
            canvas.drawRoundRect(fMax2, f48, fMin2, f49, f51, f51, this.f3594n0);
            this.f3594n0.setStyle(style2);
            this.f3594n0.setColor(getThumbInSideColor());
            canvas.drawRoundRect(fMax, f40, fMin, f41, f50, f50, this.f3594n0);
            if (z2) {
                invalidate();
                return;
            }
            return;
        }
        Intrinsics.checkNotNull(drawable3);
        drawable3.setBounds((int) fMax2, (int) f48, (int) fMin2, (int) f49);
        Drawable drawable4 = this.thumbDrawable;
        Intrinsics.checkNotNull(drawable4);
        drawable4.draw(canvas);
        if (z2) {
            invalidate();
        }
    }

    @Override // android.view.View
    public final void onLayout(boolean z2, int i8, int i9, int i10, int i11) {
        super.onLayout(z2, i8, i9, i10, i11);
    }

    @Override // android.view.View
    public final void onMeasure(int i8, int i9) {
        super.onMeasure(i8, i9);
        int iMax = (int) Math.max(getPaddingBottom() + getPaddingTop() + getContentHeight(), i() ? hd.a.a(getContext(), 30) : hd.a.a(getContext(), 20));
        z8.f("OSSeekbar", "height = " + iMax);
        setMeasuredDimension(View.resolveSize(a2.a(180), i8), iMax);
        this.E = this.f3607x + this.f3605w;
        this.q = getPaddingStart() + this.E;
        float measuredWidth = (getMeasuredWidth() - getPaddingEnd()) - this.E;
        this.f3598r = measuredWidth;
        this.f3595o = measuredWidth - this.q;
        this.f3593n = getMeasuredHeight() * 0.5f;
        this.u = (this.E * 2) - this.f3588k;
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (!(state instanceof Bundle)) {
            super.onRestoreInstanceState(state);
            return;
        }
        Bundle bundle = (Bundle) state;
        this.f3581d = bundle.getFloat("progress");
        super.onRestoreInstanceState(bundle.getParcelable("save_instance"));
        setProgress(this.f3581d);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("save_instance", super.onSaveInstanceState());
        bundle.putFloat("progress", this.f3581d);
        return bundle;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i8, int i9, int i10, int i11) {
        super.onSizeChanged(i8, i9, i10, i11);
        post(new h(this, 0));
    }

    /* JADX WARN: Code duplicated, block: B:107:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:108:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:110:0x01dc  */
    /* JADX WARN: Code duplicated, block: B:116:0x0209  */
    /* JADX WARN: Code duplicated, block: B:118:0x020f  */
    /* JADX WARN: Code duplicated, block: B:121:0x0218  */
    /* JADX WARN: Code duplicated, block: B:123:0x021c  */
    /* JADX WARN: Code duplicated, block: B:124:0x0223  */
    /* JADX WARN: Code duplicated, block: B:126:0x022c  */
    /* JADX WARN: Code duplicated, block: B:127:0x023b  */
    /* JADX WARN: Code duplicated, block: B:132:0x0258  */
    /* JADX WARN: Code duplicated, block: B:139:0x0277  */
    /* JADX WARN: Code duplicated, block: B:92:0x0191  */
    /* JADX WARN: Code duplicated, block: B:94:0x019c  */
    /* JADX WARN: Code duplicated, block: B:96:0x01a2  */
    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent event) {
        float fA;
        boolean zJ;
        float f;
        float f4;
        ValueAnimator valueAnimator;
        float fA2;
        boolean z2;
        long j8;
        boolean z3 = false;
        Intrinsics.checkNotNullParameter(event, "event");
        int actionMasked = event.getActionMasked();
        if (actionMasked == 0) {
            this.f3604v = false;
            super.performClick();
            getParent().requestDisallowInterceptTouchEvent(true);
            boolean zIsEnabled = isEnabled();
            this.W = zIsEnabled;
            if (zIsEnabled) {
                if (this.isNoThumb) {
                    if (event.getX() < this.q || event.getX() > this.f3598r) {
                        this.W = false;
                        return false;
                    }
                } else if (event.getX() < this.q - this.E || event.getX() > this.f3598r + this.E) {
                    this.W = false;
                    return false;
                }
                this.f3600s = (float) Math.min(Math.max(this.q, event.getX()), this.f3598r);
                this.d0 = Math.abs((double) (event.getX() - this.f3591m)) <= ((double) getThumbHalfSizeOnTouchDown());
                if (i()) {
                    float f10 = this.f3591m;
                    float f11 = this.E;
                    if (f10 < f11) {
                        f10 = f11;
                    }
                    this.f3591m = f10;
                    float f12 = this.f3598r;
                    float f13 = f10 > f12 ? f12 : f10;
                    this.f3591m = f13;
                    m(f13, f13, 200L, false);
                }
            }
        } else if (actionMasked == 1) {
            getParent().requestDisallowInterceptTouchEvent(false);
            if (this.W) {
                if (i()) {
                    fA2 = a(event.getX());
                    z2 = this.isNoThumb;
                    if (z2 && fA2 == this.q) {
                        fA2 -= this.E / 2;
                    }
                    if (z2 && fA2 == this.f3598r) {
                        fA2 += this.E / 2;
                    }
                    float f14 = fA2;
                    k(f14);
                    float f15 = this.f3591m;
                    if (this.d0) {
                        j8 = 200;
                    } else {
                        j8 = 250;
                    }
                    m(f15, f14, j8, true);
                } else {
                    j jVar = this.f3584h0;
                    jVar.f6183c = false;
                    jVar.f6182b = jVar.f6181a;
                    j jVar2 = this.f3586i0;
                    jVar2.f6183c = false;
                    jVar2.f6182b = jVar2.f6181a;
                    fA = a(event.getX());
                    if (this.f0 && !i()) {
                        n(this.B, 1.0f);
                        zJ = j();
                        if (zJ) {
                            this.M = this.f3607x;
                        }
                        if (!zJ) {
                            f = this.A;
                            f4 = this.f3607x;
                            if (f != f4) {
                                valueAnimator = this.j0;
                                if (valueAnimator == null) {
                                    this.j0 = f(f, f4);
                                } else {
                                    Intrinsics.checkNotNull(valueAnimator);
                                    if (valueAnimator.isRunning()) {
                                        ValueAnimator valueAnimator2 = this.j0;
                                        Intrinsics.checkNotNull(valueAnimator2);
                                        valueAnimator2.cancel();
                                        this.j0 = f(f, f4);
                                    } else {
                                        ValueAnimator valueAnimator3 = this.j0;
                                        Intrinsics.checkNotNull(valueAnimator3);
                                        valueAnimator3.setFloatValues(f, f4);
                                    }
                                }
                                ValueAnimator valueAnimator4 = this.j0;
                                Intrinsics.checkNotNull(valueAnimator4);
                                valueAnimator4.start();
                            }
                        }
                    }
                    if (this.f3591m != fA) {
                        if (this.f0 || !j() || Math.abs(this.p - fA) >= a2.a(6)) {
                            l(this.f3591m, fA);
                        } else {
                            this.J = fA;
                        }
                        k(fA);
                    }
                    this.p = fA;
                }
            }
            this.W = false;
            this.f0 = false;
            this.g0 = false;
            invalidate();
        } else if (actionMasked == 2) {
            this.f3604v = false;
            this.W = isEnabled();
            if (i()) {
                if (this.W) {
                    float fA3 = a(event.getX());
                    float fAbs = Math.abs(fA3 - this.f3600s);
                    this.f3602t = fAbs;
                    if (fA3 != this.p && (fAbs > a2.a(1) || this.g0)) {
                        if (!this.g0 && !this.d0) {
                            m(this.f3591m, fA3, 200L, false);
                        } else if (j()) {
                            this.J = fA3;
                        } else {
                            this.p = fA3;
                            this.f3591m = fA3;
                            this.f3581d = b(fA3);
                            invalidate();
                        }
                        this.g0 = true;
                        k(fA3);
                    }
                }
            } else if (this.W) {
                if (this.f0) {
                    float fA4 = a(event.getX());
                    this.f3602t = (float) Math.abs(fA4 - this.f3600s);
                    if (Math.abs(fA4 - this.p) >= a2.a(1) && (this.f3602t > a2.a(1) || this.g0)) {
                        if (this.g0 || this.d0) {
                            float fAbs2 = (float) Math.abs(fA4 - this.P);
                            if (fAbs2 < a2.a(1)) {
                                fAbs2 = 0.0f;
                            }
                            this.V = 1;
                            float f16 = this.f3607x + (fAbs2 * 1.3f);
                            float f17 = this.f3609y;
                            if (f16 > f17) {
                                f16 = f17;
                            }
                            if (j()) {
                                this.J = fA4;
                                this.M = f16;
                            } else {
                                if (!this.f3586i0.f6183c && (!this.f3584h0.f6183c || i())) {
                                    z3 = true;
                                }
                                o(this.A, f16);
                                float f18 = this.f3591m;
                                if (!this.f3586i0.f6183c) {
                                    this.f3586i0.set(f18);
                                }
                                this.f3586i0.setTargValue(fA4);
                                if (z3) {
                                    invalidate();
                                }
                            }
                        } else {
                            l(this.f3591m, fA4);
                        }
                        this.p = fA4;
                        this.g0 = true;
                        k(fA4);
                    } else if (!j() && this.A != this.f3607x) {
                        if (!this.f3586i0.f6183c && !this.f3584h0.f6183c) {
                            z3 = true;
                        }
                        o(this.A, this.f3607x);
                        if (z3) {
                            invalidate();
                        }
                    }
                    this.P = fA4;
                } else {
                    n(1.0f, this.D);
                    this.P = event.getX();
                    this.p = this.f3591m;
                }
            } else if (this.A != this.f3607x) {
                float targValue = this.f3584h0.getTargValue();
                float f19 = this.f3607x;
                if (targValue != f19) {
                    o(this.A, f19);
                    invalidate();
                }
            }
            this.f0 = true;
        } else if (actionMasked == 3) {
            getParent().requestDisallowInterceptTouchEvent(false);
            if (this.W) {
                if (i()) {
                    fA2 = a(event.getX());
                    z2 = this.isNoThumb;
                    if (z2) {
                        fA2 -= this.E / 2;
                    }
                    if (z2) {
                        fA2 += this.E / 2;
                    }
                    float f110 = fA2;
                    k(f110);
                    float f111 = this.f3591m;
                    if (this.d0) {
                        j8 = 200;
                    } else {
                        j8 = 250;
                    }
                    m(f111, f110, j8, true);
                } else {
                    j jVar3 = this.f3584h0;
                    jVar3.f6183c = false;
                    jVar3.f6182b = jVar3.f6181a;
                    j jVar4 = this.f3586i0;
                    jVar4.f6183c = false;
                    jVar4.f6182b = jVar4.f6181a;
                    fA = a(event.getX());
                    if (this.f0) {
                        n(this.B, 1.0f);
                        zJ = j();
                        if (zJ) {
                            this.M = this.f3607x;
                        }
                        if (!zJ) {
                            f = this.A;
                            f4 = this.f3607x;
                            if (f != f4) {
                                valueAnimator = this.j0;
                                if (valueAnimator == null) {
                                    this.j0 = f(f, f4);
                                } else {
                                    Intrinsics.checkNotNull(valueAnimator);
                                    if (valueAnimator.isRunning()) {
                                        ValueAnimator valueAnimator5 = this.j0;
                                        Intrinsics.checkNotNull(valueAnimator5);
                                        valueAnimator5.cancel();
                                        this.j0 = f(f, f4);
                                    } else {
                                        ValueAnimator valueAnimator6 = this.j0;
                                        Intrinsics.checkNotNull(valueAnimator6);
                                        valueAnimator6.setFloatValues(f, f4);
                                    }
                                }
                                ValueAnimator valueAnimator7 = this.j0;
                                Intrinsics.checkNotNull(valueAnimator7);
                                valueAnimator7.start();
                            }
                        }
                    }
                    if (this.f3591m != fA) {
                        if (this.f0) {
                            l(this.f3591m, fA);
                        } else {
                            l(this.f3591m, fA);
                        }
                        k(fA);
                    }
                    this.p = fA;
                }
            }
            this.W = false;
            this.f0 = false;
            this.g0 = false;
            invalidate();
        }
        return true;
    }

    public final void setForceProgress(boolean isForceProgress) {
        this.f3604v = isForceProgress;
        invalidate();
    }

    public final void setNoThumb(boolean z2) {
        this.isNoThumb = z2;
    }

    public void setOnProgressChangedListener(ee.j listener) {
    }

    public final void setOnlyHiOSStyle(boolean z2) {
        this.onlyHiOSStyle = z2;
    }

    public final void setProgress(float progress) {
        this.f3581d = progress;
        postInvalidate();
    }

    public final void setSecondTrackColor(int secondTrackColor) {
        if (this.R != secondTrackColor) {
            this.R = secondTrackColor;
            invalidate();
        }
    }

    @Nullable
    public final void setThumb(Drawable drawable) {
        this.thumbDrawable = drawable;
    }

    public final void setThumbDrawable(Drawable drawable) {
        this.thumbDrawable = drawable;
    }

    public final void setThumbInsideColor(int thumbColor) {
        if (this.U != thumbColor) {
            this.U = thumbColor;
            invalidate();
        }
    }

    public final void setThumbInsideUnAbleColorHios(int thumbInsideUnAbleColorHios) {
        if (this.S != thumbInsideUnAbleColorHios) {
            this.S = thumbInsideUnAbleColorHios;
            invalidate();
        }
    }

    public final void setThumbOutColor(int thumbColor) {
        if (this.T != thumbColor) {
            this.T = thumbColor;
            invalidate();
        }
    }

    public final void setTrackColor(int trackColor) {
        if (this.Q != trackColor) {
            this.Q = trackColor;
            invalidate();
        }
    }

    public final void setVibrateAble(boolean vibrateAble) {
        this.z0 = vibrateAble;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSSeekbar(Context mContext, AttributeSet attributeSet) {
        this(mContext, attributeSet, 4, 0);
        Intrinsics.checkNotNullParameter(mContext, "mContext");
    }

    public /* synthetic */ OSSeekbar(Context context, AttributeSet attributeSet, int i8, int i9) {
        this(context, (i8 & 2) != 0 ? null : attributeSet, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSSeekbar(Context mContext, AttributeSet attributeSet, int i8) {
        super(mContext, attributeSet, i8);
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.f3576a = mContext;
        this.B = 1.0f;
        this.C = 1.0f;
        this.F = 1.0f;
        this.G = 1.0f;
        this.f3584h0 = new j();
        j jVar = new j();
        this.f3586i0 = jVar;
        this.y0 = new h(this, 1);
        this.z0 = true;
        this.B0 = 50;
        getConfigBuilder().a();
        TypedArray typedArrayObtainStyledAttributes = mContext.obtainStyledAttributes(attributeSet, R$styleable.OSSeekbar, i8, 0);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "mContext.obtainStyledAtt…Seekbar, defStyleAttr, 0)");
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.OSSeekbar_osSeekbarOnlyHiOSStyle, false);
        this.onlyHiOSStyle = z2;
        if (z2) {
            i configBuilder = getConfigBuilder();
            OSSeekbar oSSeekbar = configBuilder.f4878a;
            if (oSSeekbar != null) {
                configBuilder.C = new WeakReference(oSSeekbar);
                configBuilder.f4880c = 0.0f;
                configBuilder.f4881d = 100.0f;
                configBuilder.e = 0.0f;
                ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(oSSeekbar.f3576a, R$style.OS_Theme_Material_hios);
                configBuilder.f = pd.j.f(R$attr.os_seekbar_track_width, a2.a(3), contextThemeWrapper);
                configBuilder.f4882g = pd.j.f(R$attr.os_seekbar_second_track_width, a2.a(3), contextThemeWrapper);
                configBuilder.f4883h = pd.j.f(R$attr.os_seekbar_t_track_width, a2.a(3), contextThemeWrapper);
                configBuilder.f4884i = pd.j.d(R$attr.os_fill_weaker, contextThemeWrapper.getColor(R$color.os_fill_weaker_hios), contextThemeWrapper);
                configBuilder.f4885j = pd.j.d(R$attr.os_platform_basic_color, contextThemeWrapper.getColor(R$color.os_platform_basic_color_hios), contextThemeWrapper);
                configBuilder.f4886k = pd.j.d(R$attr.os_platform_basic_color, contextThemeWrapper.getColor(R$color.os_platform_basic_color_hios), contextThemeWrapper);
                configBuilder.f4887l = pd.j.d(R$attr.os_seekbar_section_thumb_in_color, contextThemeWrapper.getColor(R$color.os_color_white100), contextThemeWrapper);
                configBuilder.f4888m = pd.j.f(R$attr.os_seekbar_thumb_in_width, a2.a(8), contextThemeWrapper);
                configBuilder.f4889n = pd.j.f(R$attr.os_seekbar_thumb_out_width, a2.a(14), contextThemeWrapper);
                configBuilder.f4890o = a2.a(20);
                int iD = pd.j.d(R$attr.os_grayfill_base, contextThemeWrapper.getColor(R$color.os_grayfill_base_hios), contextThemeWrapper);
                configBuilder.f4892s = iD;
                configBuilder.f4893t = iD;
                configBuilder.u = pd.j.d(R$attr.os_seekbar_thumb_in_disable_color, contextThemeWrapper.getColor(R$color.os_layer_low_hios), contextThemeWrapper);
            }
            configBuilder.a();
            this.isNoThumb = typedArrayObtainStyledAttributes.getBoolean(R$styleable.OSSeekbar_osSeekbarNoThumb, false);
        }
        this.min = typedArrayObtainStyledAttributes.getFloat(R$styleable.OSSeekbar_osSeekbarMin, 0.0f);
        this.max = typedArrayObtainStyledAttributes.getFloat(R$styleable.OSSeekbar_osSeekbarMax, 100.0f);
        this.f3581d = typedArrayObtainStyledAttributes.getFloat(R$styleable.OSSeekbar_osSeekbarProgress, this.min);
        setEnabled(typedArrayObtainStyledAttributes.getBoolean(R$styleable.OSSeekbar_android_enabled, isEnabled()));
        this.thumbDrawable = typedArrayObtainStyledAttributes.getDrawable(R$styleable.OSSeekbar_osSeekbarThumb);
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.OSSeekbar_osSeekbarTrackColor)) {
            setTrackColor(typedArrayObtainStyledAttributes.getColor(R$styleable.OSSeekbar_osSeekbarTrackColor, this.Q));
        }
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.OSSeekbar_osSeekbarSecondTrackColor)) {
            setSecondTrackColor(typedArrayObtainStyledAttributes.getColor(R$styleable.OSSeekbar_osSeekbarSecondTrackColor, this.R));
        }
        typedArrayObtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.f3592m0 = paint;
        paint.setAntiAlias(true);
        Paint.Cap cap = Paint.Cap.ROUND;
        paint.setStrokeCap(cap);
        Paint.Align align = Paint.Align.CENTER;
        paint.setTextAlign(align);
        Paint paint2 = new Paint();
        this.f3594n0 = paint2;
        paint2.setAntiAlias(true);
        paint2.setDither(true);
        paint2.setStrokeCap(cap);
        paint2.setTextAlign(align);
        jVar.setMaxSpeedFractor(0.25f);
        jVar.setMinSpeedFractor(0.25f);
        h();
        if (pd.j.v() && getRotation() == 0.0f) {
            setRotation(180.0f);
        }
    }
}
