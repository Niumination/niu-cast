package com.transsion.widgetslib.widget.seekbar;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.transsion.widgetslib.R;
import hj.h;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes2.dex */
public class OSSeekbar extends View {

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public static final int f2965s0 = 0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public static final int f2966t0 = 1;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public static final int f2967u0 = 2;
    public float H;
    public final Paint I;
    public final Context J;
    public f K;
    public float L;
    public float M;
    public final Paint N;
    public int O;
    public int P;
    public float Q;
    public float R;
    public float S;
    public float T;
    public float U;
    public float V;
    public float W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f2968a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public float f2969a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f2970b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public float f2971b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f2972c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public int f2973c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f2974d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public boolean f2975d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f2976e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public boolean f2977e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2978f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public ValueAnimator f2979f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f2980g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public ValueAnimator f2981g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public float f2982h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f2983i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public float f2984i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public float f2985j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public float f2986k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public float f2987l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public ValueAnimator f2988m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f2989n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public float f2990n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public boolean f2991o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f2992p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public boolean f2993p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public final xi.e f2994q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public final xi.e f2995r0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f2996v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f2997w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f2998x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public g f2999y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f3000z;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            OSSeekbar.this.requestLayout();
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            OSSeekbar.this.U = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            OSSeekbar.this.invalidate();
        }
    }

    public class c implements ValueAnimator.AnimatorUpdateListener {
        public c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            OSSeekbar.this.V = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            OSSeekbar oSSeekbar = OSSeekbar.this;
            float f10 = oSSeekbar.f2969a0;
            if (f10 != 0.0f) {
                oSSeekbar.W = (((1.0f - oSSeekbar.f2971b0) * oSSeekbar.V) / f10) + 1.0f;
            }
            oSSeekbar.invalidate();
        }
    }

    public class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            OSSeekbar oSSeekbar = OSSeekbar.this;
            float f10 = oSSeekbar.f2982h0;
            OSSeekbar oSSeekbar2 = OSSeekbar.this;
            oSSeekbar.f2989n = g.a.a(oSSeekbar2.f2984i0, oSSeekbar2.f2982h0, fFloatValue, f10);
            oSSeekbar2.f2972c = oSSeekbar2.v(oSSeekbar2.f2989n);
            OSSeekbar oSSeekbar3 = OSSeekbar.this;
            g gVar = oSSeekbar3.f2999y;
            if (gVar != null) {
                gVar.c(oSSeekbar3, oSSeekbar3.getProgress(), OSSeekbar.this.getProgressFloat(), true);
            }
            if (fFloatValue <= 0.5f) {
                OSSeekbar oSSeekbar4 = OSSeekbar.this;
                float f11 = oSSeekbar4.f2985j0;
                oSSeekbar4.U = g.a.a(oSSeekbar4.f2986k0, f11, fFloatValue * 2.0f, f11);
            } else {
                OSSeekbar oSSeekbar5 = OSSeekbar.this;
                float f12 = oSSeekbar5.f2986k0;
                oSSeekbar5.U = g.a.a(oSSeekbar5.f2987l0, f12, (fFloatValue - 0.5f) * 2.0f, f12);
            }
            OSSeekbar.this.invalidate();
        }
    }

    public class e implements Animator.AnimatorListener {
        public e() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            OSSeekbar.this.f2977e0 = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            OSSeekbar.this.f2977e0 = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            OSSeekbar.this.f2977e0 = true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            OSSeekbar.this.f2977e0 = true;
        }
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f3006a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f3007b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f3008c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f3009d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f3010e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f3011f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f3012g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f3013h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f3014i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f3015j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f3016k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f3017l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public float f3018m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public float f3019n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public WeakReference<OSSeekbar> f3020o;

        public f(OSSeekbar oSSeekbar) {
            if (oSSeekbar != null) {
                this.f3020o = new WeakReference<>(oSSeekbar);
                this.f3006a = 0.0f;
                this.f3007b = 100.0f;
                this.f3008c = 0.0f;
                this.f3009d = OSSeekbar.A(3);
                this.f3010e = OSSeekbar.A(3);
                this.f3011f = ContextCompat.getColor(oSSeekbar.J, R.color.os_gray_tertiary_color);
                this.f3012g = oSSeekbar.E();
                this.f3013h = oSSeekbar.L();
                this.f3014i = ContextCompat.getColor(oSSeekbar.J, R.color.os_seekbar_thumbinside_color);
                this.f3015j = OSSeekbar.A(8);
                this.f3016k = OSSeekbar.A(14);
                this.f3017l = OSSeekbar.A(20);
                this.f3018m = 1.25f;
                this.f3019n = 1.142857f;
            }
        }

        public void a() {
            if (this.f3020o.get() != null) {
                this.f3020o.get().w(this);
            }
        }

        public f b(float f10) {
            this.f3007b = f10;
            return this;
        }

        public f c(float f10) {
            this.f3006a = f10;
            this.f3008c = f10;
            return this;
        }

        public f d(float f10) {
            this.f3008c = f10;
            return this;
        }

        public f e(int i10) {
            this.f3012g = i10;
            return this;
        }

        public f f(int i10) {
            this.f3010e = OSSeekbar.A(i10);
            return this;
        }

        public f g(int i10) {
            this.f3018m = i10;
            return this;
        }

        public f h(int i10) {
            this.f3017l = i10;
            return this;
        }

        public f i(int i10) {
            this.f3015j = i10;
            return this;
        }

        public f j(int i10) {
            this.f3019n = i10;
            return this;
        }

        public f k(int i10) {
            this.f3016k = i10;
            return this;
        }

        public f l(int i10) {
            this.f3011f = i10;
            return this;
        }

        public f m(int i10) {
            this.f3009d = OSSeekbar.A(i10);
            return this;
        }
    }

    public interface g {
        void a(OSSeekbar oSSeekbar);

        void b(OSSeekbar oSSeekbar);

        void c(OSSeekbar oSSeekbar, int i10, float f10, boolean z10);
    }

    public OSSeekbar(Context context) {
        this(context, null, 0);
    }

    public static int A(int i10) {
        return (int) TypedValue.applyDimension(1, i10, Resources.getSystem().getDisplayMetrics());
    }

    public static int F(int i10) {
        return (int) TypedValue.applyDimension(2, i10, Resources.getSystem().getDisplayMetrics());
    }

    public final float B(float f10) {
        return BigDecimal.valueOf(f10).setScale(1, 4).floatValue();
    }

    public final void C() {
        if (this.f2968a == this.f2970b) {
            this.f2968a = 0.0f;
            this.f2970b = 100.0f;
        }
        float f10 = this.f2968a;
        float f11 = this.f2970b;
        if (f10 > f11) {
            this.f2970b = f10;
            this.f2968a = f11;
        }
        float f12 = this.f2972c;
        float f13 = this.f2968a;
        if (f12 < f13) {
            this.f2972c = f13;
        }
        float f14 = this.f2972c;
        float f15 = this.f2970b;
        if (f14 > f15) {
            this.f2972c = f15;
        }
        this.f2983i = f15 - f13;
        setProgress(this.f2972c);
    }

    public final boolean D() {
        ValueAnimator valueAnimator = this.f2988m0;
        return valueAnimator != null && valueAnimator.isRunning();
    }

    public final int E() {
        TypedValue typedValue = new TypedValue();
        return this.J.getTheme().resolveAttribute(R.attr.os_platform_basic_color, typedValue, true) ? ContextCompat.getColor(this.J, typedValue.resourceId) : ContextCompat.getColor(this.J, R.color.os_platform_basic_color_hios);
    }

    public final void G(float f10, float f11) {
        if (!this.f2995r0.g()) {
            this.f2995r0.h(f10);
        }
        this.f2995r0.k(f11);
    }

    public final void H(float f10, float f11, long j10) {
        this.f2977e0 = true;
        ValueAnimator valueAnimator = this.f2988m0;
        if (valueAnimator == null) {
            this.f2988m0 = y();
        } else if (valueAnimator.isRunning()) {
            this.f2988m0.cancel();
            this.f2988m0 = y();
        }
        this.f2988m0.setDuration(j10);
        this.f2973c0 = 1;
        float fAbs = Math.abs(f11 - f10);
        float f12 = this.R;
        if (fAbs > f12) {
            float fA = g.a.a(fAbs, f12, 0.18f, f12);
            float f13 = this.S;
            if (fA > f13) {
                fA = f13;
            }
            this.f2985j0 = this.U;
            this.f2986k0 = fA;
            this.f2987l0 = f12;
        } else {
            this.f2985j0 = this.U;
            this.f2986k0 = f12;
            this.f2987l0 = f12;
        }
        this.f2982h0 = f10;
        this.f2984i0 = f11;
        this.f2988m0.start();
    }

    public final void I(float f10, float f11) {
        ValueAnimator valueAnimator = this.f2981g0;
        if (valueAnimator == null) {
            this.f2981g0 = x(f10, f11);
        } else if (valueAnimator.isRunning()) {
            this.f2981g0.cancel();
            this.f2981g0 = x(f10, f11);
        } else {
            this.f2981g0.setFloatValues(f10, f11);
        }
        this.f2981g0.start();
    }

    public final void J(float f10, float f11) {
        ValueAnimator valueAnimator = this.f2979f0;
        if (valueAnimator == null) {
            this.f2979f0 = z(f10, f11);
        } else if (valueAnimator.isRunning()) {
            this.f2979f0.cancel();
            this.f2979f0 = z(f10, f11);
        } else {
            this.f2979f0.setFloatValues(f10, f11);
        }
        this.f2979f0.start();
    }

    public final void K(float f10, float f11) {
        if (!this.f2994q0.g()) {
            this.f2994q0.h(f10);
        }
        this.f2994q0.k(f11);
    }

    public final int L() {
        TypedValue typedValue = new TypedValue();
        return this.J.getTheme().resolveAttribute(R.attr.os_platform_basic_color, typedValue, true) ? ContextCompat.getColor(this.J, typedValue.resourceId) : ContextCompat.getColor(this.J, R.color.os_platform_basic_color_hios);
    }

    public final boolean M() {
        boolean zL = false;
        if (!D()) {
            if (this.f2994q0.g()) {
                zL = this.f2994q0.l(0.064f);
                this.U = this.f2994q0.f20238b;
            }
            if (this.f2995r0.g()) {
                zL |= this.f2995r0.l(0.256f);
                float f10 = this.f2995r0.f20238b;
                this.f2989n = f10;
                this.f2972c = v(f10);
                g gVar = this.f2999y;
                if (gVar != null) {
                    gVar.c(this, getProgress(), getProgressFloat(), true);
                }
            }
        }
        return zL;
    }

    public f getConfigBuilder() {
        if (this.K == null) {
            this.K = new f(this);
        }
        return this.K;
    }

    public float getMax() {
        return this.f2970b;
    }

    public float getMin() {
        return this.f2968a;
    }

    public g getOnProgressChangedListener() {
        return this.f2999y;
    }

    public int getProgress() {
        ValueAnimator valueAnimator = this.f2988m0;
        return (valueAnimator == null || !valueAnimator.isRunning()) ? Math.round(this.f2972c) : Math.round(v(this.f2984i0));
    }

    public float getProgressFloat() {
        ValueAnimator valueAnimator = this.f2988m0;
        return (valueAnimator == null || !valueAnimator.isRunning()) ? this.f2972c : v(this.f2984i0);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float f10;
        float f11;
        super.onDraw(canvas);
        float f12 = this.f3000z;
        float f13 = this.H;
        float f14 = this.f2992p;
        if (!this.f2997w && !this.f2977e0) {
            this.f2989n = g.a.a(this.f2972c, this.f2968a, this.f2996v / this.f2983i, f12);
        }
        this.I.setColor(this.f2978f);
        this.I.setStrokeWidth(this.f2974d);
        canvas.drawLine(f12, f14, f13, f14, this.I);
        float f15 = this.f2989n;
        this.I.setColor(this.f2980g);
        this.I.setStrokeWidth(this.f2976e);
        canvas.drawLine(f12, f14, f15, f14, this.I);
        this.N.setColor(this.O);
        Paint paint = this.N;
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        boolean zM = M();
        float f16 = this.V;
        float f17 = this.U;
        float f18 = this.f2992p;
        float f19 = this.T;
        float f20 = f18 - (f19 * f16);
        float f21 = (f19 * f16) + f18;
        int i10 = this.f2973c0;
        if (i10 == 0) {
            float f22 = this.R;
            float f23 = f15 - (((f17 - f22) + f17) * f16);
            f10 = f15 + (f22 * f16);
            f11 = f23;
        } else if (i10 == 1 || i10 != 2) {
            float f24 = f17 * f16;
            f11 = f15 - f24;
            f10 = f15 + f24;
        } else {
            float f25 = this.R;
            float f26 = f15 - (f25 * f16);
            f10 = f15 + (((f17 - f25) + f17) * f16);
            f11 = f26;
        }
        float f27 = this.Q * this.W;
        float fMax = Math.max(f11, f27);
        float fMin = Math.min(f10, getWidth() - f27);
        float f28 = f16 * this.T;
        float f29 = f28 + f27;
        canvas.drawRoundRect(Math.max(fMax - f27, 0.0f), f20 - f27, Math.min(fMin + f27, getWidth()), f21 + f27, f29, f29, this.N);
        this.N.setStyle(style);
        this.N.setColor(this.P);
        canvas.drawRoundRect(fMax, f20, fMin, f21, f28, f28, this.N);
        if (zM) {
            invalidate();
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        int paddingBottom = getPaddingBottom() + getPaddingTop() + ((int) Math.max((int) (((this.Q * this.f2971b0) + (this.T * this.f2969a0)) * 2.0f), this.f2974d));
        if (paddingBottom < A(20)) {
            paddingBottom = A(20);
        }
        setMeasuredDimension(View.resolveSize(A(180), i10), paddingBottom);
        float f10 = (this.Q * this.f2971b0) + (this.R * this.f2969a0);
        this.f3000z = getPaddingLeft() + f10;
        float measuredWidth = (getMeasuredWidth() - getPaddingRight()) - f10;
        this.H = measuredWidth;
        this.f2996v = measuredWidth - this.f3000z;
        this.f2992p = getMeasuredHeight() * 0.5f;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        this.f2972c = bundle.getFloat("progress");
        super.onRestoreInstanceState(bundle.getParcelable("save_instance"));
        setProgress(this.f2972c);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("save_instance", super.onSaveInstanceState());
        bundle.putFloat("progress", this.f2972c);
        return bundle;
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        post(new a());
    }

    /* JADX WARN: Code duplicated, block: B:59:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:61:0x0101  */
    /* JADX WARN: Code duplicated, block: B:63:0x0117  */
    /* JADX WARN: Code duplicated, block: B:65:0x0122  */
    /* JADX WARN: Code duplicated, block: B:67:0x0128  */
    /* JADX WARN: Code duplicated, block: B:69:0x0130  */
    /* JADX WARN: Code duplicated, block: B:72:0x0139  */
    /* JADX WARN: Code duplicated, block: B:79:0x0157  */
    /* JADX WARN: Code duplicated, block: B:83:0x0164  */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        g gVar;
        float fU;
        boolean zD;
        float f10;
        float f11;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            performClick();
            getParent().requestDisallowInterceptTouchEvent(true);
            boolean zIsEnabled = isEnabled();
            this.f2997w = zIsEnabled;
            if (zIsEnabled) {
                if (motionEvent.getX() < this.f3000z || motionEvent.getX() > this.H) {
                    this.f2997w = false;
                    return false;
                }
                this.L = motionEvent.getX();
                g gVar2 = this.f2999y;
                if (gVar2 != null) {
                    gVar2.a(this);
                }
                float f12 = (this.Q * this.f2971b0) + (this.R * this.f2969a0);
                if (motionEvent.getX() > this.f2989n + f12 || motionEvent.getX() < this.f2989n - f12) {
                    this.f2975d0 = false;
                } else {
                    this.f2975d0 = true;
                }
            }
        } else if (actionMasked == 1) {
            getParent().requestDisallowInterceptTouchEvent(false);
            if (this.f2997w) {
                this.f2994q0.d();
                this.f2995r0.d();
                fU = u(motionEvent.getX());
                if (this.f2991o0) {
                    I(this.V, 1.0f);
                    zD = D();
                    if (zD) {
                        this.f2987l0 = this.R;
                    }
                    if (!zD) {
                        f10 = this.U;
                        f11 = this.R;
                        if (f10 != f11) {
                            J(f10, f11);
                        }
                    }
                }
                if (this.f2989n != fU) {
                    if (this.f2991o0 || !D() || Math.abs(this.f2998x - fU) >= A(6)) {
                        H(this.f2989n, fU, 500L);
                    } else {
                        this.f2984i0 = fU;
                    }
                }
                this.f2998x = fU;
            }
            this.f2997w = false;
            gVar = this.f2999y;
            if (gVar != null) {
                gVar.b(this);
            }
            this.f2991o0 = false;
            this.f2993p0 = false;
        } else if (actionMasked == 2) {
            boolean zIsEnabled2 = isEnabled();
            this.f2997w = zIsEnabled2;
            if (zIsEnabled2) {
                if (this.f2991o0) {
                    float fU2 = u(motionEvent.getX());
                    this.M = Math.abs(fU2 - this.L);
                    if (Math.abs(fU2 - this.f2998x) >= A(1) && this.M > A(1)) {
                        if (this.f2993p0 || this.f2975d0) {
                            float fAbs = Math.abs(fU2 - this.f2990n0);
                            if (fAbs < A(1)) {
                                fAbs = 0.0f;
                            }
                            this.f2973c0 = 1;
                            float f13 = this.R + (fAbs * 1.3f);
                            float f14 = this.S;
                            if (f13 > f14) {
                                f13 = f14;
                            }
                            if (D()) {
                                this.f2984i0 = fU2;
                                this.f2987l0 = f13;
                            } else {
                                boolean z10 = (this.f2995r0.g() || this.f2994q0.g()) ? false : true;
                                K(this.U, f13);
                                G(this.f2989n, fU2);
                                if (z10) {
                                    invalidate();
                                }
                            }
                        } else {
                            H(this.f2989n, fU2, 500L);
                        }
                        this.f2998x = fU2;
                        this.f2993p0 = true;
                    } else if (!D() && this.U != this.R) {
                        boolean z11 = (this.f2995r0.g() || this.f2994q0.g()) ? false : true;
                        K(this.U, this.R);
                        if (z11) {
                            invalidate();
                        }
                    }
                    this.f2990n0 = fU2;
                } else {
                    I(1.0f, this.f2969a0);
                    this.f2990n0 = motionEvent.getX();
                    this.f2998x = this.f2989n;
                }
            }
            this.f2991o0 = true;
        } else if (actionMasked == 3) {
            getParent().requestDisallowInterceptTouchEvent(false);
            if (this.f2997w) {
                this.f2994q0.d();
                this.f2995r0.d();
                fU = u(motionEvent.getX());
                if (this.f2991o0) {
                    I(this.V, 1.0f);
                    zD = D();
                    if (zD) {
                        this.f2987l0 = this.R;
                    }
                    if (!zD) {
                        f10 = this.U;
                        f11 = this.R;
                        if (f10 != f11) {
                            J(f10, f11);
                        }
                    }
                }
                if (this.f2989n != fU) {
                    if (this.f2991o0) {
                        H(this.f2989n, fU, 500L);
                    } else {
                        H(this.f2989n, fU, 500L);
                    }
                }
                this.f2998x = fU;
            }
            this.f2997w = false;
            gVar = this.f2999y;
            if (gVar != null) {
                gVar.b(this);
            }
            this.f2991o0 = false;
            this.f2993p0 = false;
        }
        return this.f2997w || super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean performClick() {
        return super.performClick();
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        if (z10) {
            this.f2980g = E();
            this.O = L();
            this.P = ContextCompat.getColor(this.J, R.color.os_seekbar_thumbinside_color);
        } else {
            this.f2980g = ContextCompat.getColor(this.J, R.color.os_gray_secondary_color);
            this.O = ContextCompat.getColor(this.J, R.color.os_gray_solid_primary_color);
            this.P = ContextCompat.getColor(this.J, R.color.os_altitude_secondary_color);
        }
        invalidate();
    }

    public void setOnProgressChangedListener(g gVar) {
        this.f2999y = gVar;
    }

    public void setProgress(float f10) {
        this.f2972c = f10;
        g gVar = this.f2999y;
        if (gVar != null) {
            gVar.c(this, getProgress(), getProgressFloat(), false);
        }
        postInvalidate();
    }

    public void setSecondTrackColor(int i10) {
        if (this.f2980g != i10) {
            this.f2980g = i10;
            invalidate();
        }
    }

    public void setThumbInsideColor(int i10) {
        if (this.P != i10) {
            this.P = i10;
            invalidate();
        }
    }

    public void setThumbOutColor(int i10) {
        if (this.O != i10) {
            this.O = i10;
            invalidate();
        }
    }

    public void setTrackColor(int i10) {
        if (this.f2978f != i10) {
            this.f2978f = i10;
            invalidate();
        }
    }

    public final float u(float f10) {
        float f11 = this.f3000z;
        if (f10 <= f11) {
            return f11;
        }
        float f12 = this.H;
        return f10 >= f12 ? f12 : f10;
    }

    public final float v(float f10) {
        return (((f10 - this.f3000z) * this.f2983i) / this.f2996v) + this.f2968a;
    }

    public void w(f fVar) {
        this.f2968a = fVar.f3006a;
        this.f2970b = fVar.f3007b;
        this.f2972c = fVar.f3008c;
        this.f2978f = fVar.f3011f;
        this.f2980g = fVar.f3012g;
        this.f2974d = fVar.f3009d;
        this.O = fVar.f3013h;
        this.P = fVar.f3014i;
        this.f2976e = fVar.f3010e;
        int i10 = fVar.f3016k;
        int i11 = fVar.f3015j;
        float f10 = (i10 - i11) * 0.5f;
        this.Q = f10;
        if (f10 < 0.0f) {
            this.Q = 0.0f;
        }
        float f11 = i11 * 0.5f;
        this.R = f11;
        if (fVar.f3017l < i11) {
            fVar.f3017l = i11;
        }
        this.S = fVar.f3017l * 0.5f;
        this.T = f11;
        this.U = f11;
        float f12 = fVar.f3018m;
        this.f2969a0 = f12;
        float f13 = this.Q;
        if (f13 != 0.0f) {
            this.f2971b0 = ((i10 * fVar.f3019n) - (i11 * f12)) / (f13 * 2.0f);
        }
        if (this.f2971b0 < 1.0f) {
            this.f2971b0 = 1.0f;
        }
        C();
        g gVar = this.f2999y;
        if (gVar != null) {
            gVar.c(this, getProgress(), getProgressFloat(), false);
        }
        this.K = null;
        requestLayout();
    }

    public final ValueAnimator x(float f10, float f11) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f10, f11);
        valueAnimatorOfFloat.setDuration(250L);
        valueAnimatorOfFloat.setInterpolator(new pj.c(0.25f, 0.0f, 0.0f, 1.0f));
        valueAnimatorOfFloat.addUpdateListener(new c());
        return valueAnimatorOfFloat;
    }

    public final ValueAnimator y() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 0.5f, 1.0f);
        valueAnimatorOfFloat.setDuration(500L);
        valueAnimatorOfFloat.setInterpolator(new pj.c(0.4f, 0.0f, 0.2f, 1.0f));
        valueAnimatorOfFloat.addUpdateListener(new d());
        valueAnimatorOfFloat.addListener(new e());
        return valueAnimatorOfFloat;
    }

    public final ValueAnimator z(float f10, float f11) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f10, f11);
        valueAnimatorOfFloat.setDuration(250L);
        valueAnimatorOfFloat.setInterpolator(new pj.c(0.4f, 0.0f, 0.2f, 1.0f));
        valueAnimatorOfFloat.addUpdateListener(new b());
        return valueAnimatorOfFloat;
    }

    public OSSeekbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OSSeekbar(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.V = 1.0f;
        this.W = 1.0f;
        this.f2973c0 = 0;
        this.f2975d0 = false;
        this.f2977e0 = false;
        this.f2991o0 = false;
        this.f2993p0 = false;
        this.f2994q0 = new xi.e();
        xi.e eVar = new xi.e();
        this.f2995r0 = eVar;
        this.J = context;
        getConfigBuilder().a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.OSSeekbar, i10, 0);
        this.f2968a = typedArrayObtainStyledAttributes.getFloat(R.styleable.OSSeekbar_osSeekbarMin, 0.0f);
        this.f2970b = typedArrayObtainStyledAttributes.getFloat(R.styleable.OSSeekbar_osSeekbarMax, 100.0f);
        this.f2972c = typedArrayObtainStyledAttributes.getFloat(R.styleable.OSSeekbar_osSeekbarProgress, this.f2968a);
        setEnabled(typedArrayObtainStyledAttributes.getBoolean(R.styleable.OSSeekbar_android_enabled, isEnabled()));
        typedArrayObtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.I = paint;
        paint.setAntiAlias(true);
        Paint.Cap cap = Paint.Cap.ROUND;
        paint.setStrokeCap(cap);
        Paint.Align align = Paint.Align.CENTER;
        paint.setTextAlign(align);
        Paint paint2 = new Paint();
        this.N = paint2;
        paint2.setAntiAlias(true);
        paint2.setDither(true);
        paint2.setStrokeCap(cap);
        paint2.setTextAlign(align);
        eVar.f20241e = 0.25f;
        eVar.f20242f = 0.25f;
        C();
        if (h.I() && getRotation() == 0.0f) {
            setRotation(180.0f);
        }
    }
}
