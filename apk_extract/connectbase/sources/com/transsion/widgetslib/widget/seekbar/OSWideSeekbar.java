package com.transsion.widgetslib.widget.seekbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
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
public class OSWideSeekbar extends View {
    public static final long V = 0;
    public float H;
    public e I;
    public float J;
    public float K;
    public final Paint L;
    public final Rect M;
    public final Context N;
    public d O;
    public long P;
    public long Q;
    public float R;
    public float S;
    public ValueAnimator T;
    public ValueAnimator U;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f3021a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f3022b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f3023c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f3024d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f3025e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f3026f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f3027g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f3028i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f3029n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f3030p;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f3031v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f3032w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f3033x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f3034y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f3035z;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            OSWideSeekbar.this.requestLayout();
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            OSWideSeekbar oSWideSeekbar = OSWideSeekbar.this;
            oSWideSeekbar.f3026f = ((Float) valueAnimator.getAnimatedValue()).floatValue() * oSWideSeekbar.f3027g;
            OSWideSeekbar oSWideSeekbar2 = OSWideSeekbar.this;
            oSWideSeekbar2.f3024d = ((Float) valueAnimator.getAnimatedValue()).floatValue() * oSWideSeekbar2.f3025e;
            OSWideSeekbar.this.invalidate();
        }
    }

    public class c implements ValueAnimator.AnimatorUpdateListener {
        public c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            OSWideSeekbar oSWideSeekbar = OSWideSeekbar.this;
            oSWideSeekbar.f3026f = ((Float) valueAnimator.getAnimatedValue()).floatValue() * oSWideSeekbar.f3027g;
            OSWideSeekbar oSWideSeekbar2 = OSWideSeekbar.this;
            oSWideSeekbar2.f3024d = ((Float) valueAnimator.getAnimatedValue()).floatValue() * oSWideSeekbar2.f3025e;
            OSWideSeekbar.this.invalidate();
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f3039a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f3040b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f3041c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f3042d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f3043e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f3044f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f3045g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public WeakReference<OSWideSeekbar> f3046h;

        public d(OSWideSeekbar oSWideSeekbar) {
            if (oSWideSeekbar != null) {
                this.f3046h = new WeakReference<>(oSWideSeekbar);
                this.f3039a = 0.0f;
                this.f3040b = 100.0f;
                this.f3041c = 0.0f;
                this.f3042d = OSWideSeekbar.l(10);
                this.f3043e = OSWideSeekbar.l(10);
                this.f3044f = ContextCompat.getColor(oSWideSeekbar.N, R.color.os_gray_tertiary_color);
                this.f3045g = oSWideSeekbar.o();
            }
        }

        public void a() {
            if (this.f3046h.get() != null) {
                this.f3046h.get().i(this);
            }
        }

        public d b(float f10) {
            this.f3040b = f10;
            return this;
        }

        public d c(float f10) {
            this.f3039a = f10;
            this.f3041c = f10;
            return this;
        }

        public d d(float f10) {
            this.f3041c = f10;
            return this;
        }

        public d e(int i10) {
            this.f3045g = i10;
            return this;
        }

        public d f(int i10) {
            this.f3043e = OSWideSeekbar.l(i10);
            return this;
        }

        public d g(int i10) {
            this.f3044f = i10;
            return this;
        }

        public d h(int i10) {
            this.f3042d = OSWideSeekbar.l(i10);
            return this;
        }
    }

    public interface e {
        void a(OSWideSeekbar oSWideSeekbar);

        void b(OSWideSeekbar oSWideSeekbar);

        void c(OSWideSeekbar oSWideSeekbar, int i10, float f10, boolean z10);
    }

    public OSWideSeekbar(Context context) {
        this(context, null, 0);
    }

    public static int l(int i10) {
        return (int) TypedValue.applyDimension(1, i10, Resources.getSystem().getDisplayMetrics());
    }

    public static int p(int i10) {
        return (int) TypedValue.applyDimension(2, i10, Resources.getSystem().getDisplayMetrics());
    }

    public final float g(float f10) {
        float f11 = this.J;
        if (f10 <= f11) {
            return f11;
        }
        float f12 = this.K;
        return f10 >= f12 ? f12 : f10;
    }

    public d getConfigBuilder() {
        if (this.O == null) {
            this.O = new d(this);
        }
        return this.O;
    }

    public float getMax() {
        return this.f3022b;
    }

    public float getMin() {
        return this.f3021a;
    }

    public e getOnProgressChangedListener() {
        return this.I;
    }

    public int getProgress() {
        return Math.round(this.f3023c);
    }

    public float getProgressFloat() {
        return this.f3023c;
    }

    public final float h() {
        return (((this.f3032w - this.J) * this.f3031v) / this.f3033x) + this.f3021a;
    }

    public void i(d dVar) {
        this.f3021a = dVar.f3039a;
        this.f3022b = dVar.f3040b;
        this.f3023c = dVar.f3041c;
        int i10 = dVar.f3042d;
        this.f3024d = i10;
        int i11 = dVar.f3043e;
        this.f3026f = i11;
        this.f3028i = dVar.f3044f;
        this.f3029n = dVar.f3045g;
        this.f3025e = i10;
        this.f3027g = i11;
        n();
        e eVar = this.I;
        if (eVar != null) {
            eVar.c(this, getProgress(), getProgressFloat(), false);
        }
        this.O = null;
        requestLayout();
    }

    public final ValueAnimator j() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.f3026f / this.f3027g, 1.6f);
        valueAnimatorOfFloat.setDuration(250L);
        valueAnimatorOfFloat.addUpdateListener(new b());
        return valueAnimatorOfFloat;
    }

    public final ValueAnimator k() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.f3026f / this.f3027g, 1.0f);
        valueAnimatorOfFloat.setDuration(250L);
        valueAnimatorOfFloat.addUpdateListener(new c());
        return valueAnimatorOfFloat;
    }

    public final float m(float f10) {
        return BigDecimal.valueOf(f10).setScale(1, 4).floatValue();
    }

    public final void n() {
        if (this.f3021a == this.f3022b) {
            this.f3021a = 0.0f;
            this.f3022b = 100.0f;
        }
        float f10 = this.f3021a;
        float f11 = this.f3022b;
        if (f10 > f11) {
            this.f3022b = f10;
            this.f3021a = f11;
        }
        float f12 = this.f3023c;
        float f13 = this.f3021a;
        if (f12 < f13) {
            this.f3023c = f13;
        }
        float f14 = this.f3023c;
        float f15 = this.f3022b;
        if (f14 > f15) {
            this.f3023c = f15;
        }
        this.f3031v = f15 - f13;
        setProgress(this.f3023c);
    }

    public final int o() {
        TypedValue typedValue = new TypedValue();
        return this.N.getTheme().resolveAttribute(R.attr.os_platform_basic_color, typedValue, true) ? ContextCompat.getColor(this.N, typedValue.resourceId) : ContextCompat.getColor(this.N, R.color.os_platform_basic_color_hios);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f10 = this.J;
        float f11 = this.K;
        float paddingTop = (this.f3027g * 0.6f) + getPaddingTop() + (this.f3035z * 2);
        if (!this.f3034y) {
            this.f3032w = g.a.a(this.f3023c, this.f3021a, this.f3033x / this.f3031v, f10);
        }
        this.L.setColor(this.f3028i);
        this.L.setStrokeWidth(this.f3024d);
        canvas.drawLine(f10, paddingTop, f11, paddingTop, this.L);
        this.L.setColor(this.f3029n);
        this.L.setStrokeWidth(this.f3026f);
        canvas.drawLine(f10, paddingTop, this.f3032w, paddingTop, this.L);
    }

    @Override // android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        setMeasuredDimension(View.resolveSize(l(180), i10), (this.f3035z * 2) + getPaddingBottom() + getPaddingTop() + ((int) (((double) this.f3027g) * 1.6d)));
        this.J = getPaddingLeft() + this.f3035z + this.f3024d;
        float measuredWidth = ((getMeasuredWidth() - getPaddingRight()) - this.f3035z) - this.f3024d;
        this.K = measuredWidth;
        this.f3033x = measuredWidth - this.J;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        this.f3023c = bundle.getFloat("progress");
        super.onRestoreInstanceState(bundle.getParcelable("save_instance"));
        setProgress(this.f3023c);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("save_instance", super.onSaveInstanceState());
        bundle.putFloat("progress", this.f3023c);
        return bundle;
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        post(new a());
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0061  */
    /* JADX WARN: Code duplicated, block: B:21:0x0072  */
    /* JADX WARN: Code duplicated, block: B:23:0x0088  */
    /* JADX WARN: Code duplicated, block: B:31:0x00b1  */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ValueAnimator valueAnimator;
        e eVar;
        e eVar2;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            performClick();
            getParent().requestDisallowInterceptTouchEvent(true);
            boolean zIsEnabled = isEnabled();
            this.f3034y = zIsEnabled;
            if (zIsEnabled) {
                if (motionEvent.getX() < this.J || motionEvent.getX() > this.K) {
                    this.f3034y = false;
                    return false;
                }
                this.R = motionEvent.getX();
                this.P = System.currentTimeMillis();
                ValueAnimator valueAnimator2 = this.U;
                if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                    this.U.cancel();
                }
                ValueAnimator valueAnimatorJ = j();
                this.T = valueAnimatorJ;
                valueAnimatorJ.start();
                e eVar3 = this.I;
                if (eVar3 != null) {
                    eVar3.a(this);
                }
            }
        } else if (actionMasked == 1) {
            this.Q = System.currentTimeMillis();
            getParent().requestDisallowInterceptTouchEvent(false);
            if (this.f3034y) {
                float fG = g(motionEvent.getX());
                this.H = fG;
                this.f3032w = fG;
                this.f3023c = h();
                eVar2 = this.I;
                if (eVar2 != null) {
                    eVar2.c(this, getProgress(), getProgressFloat(), true);
                }
            }
            valueAnimator = this.T;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.T.cancel();
            }
            ValueAnimator valueAnimatorK = k();
            this.U = valueAnimatorK;
            valueAnimatorK.start();
            this.f3034y = false;
            eVar = this.I;
            if (eVar != null) {
                eVar.b(this);
            }
        } else if (actionMasked == 2) {
            this.f3034y = isEnabled();
            this.Q = System.currentTimeMillis();
            if (this.f3034y) {
                float fG2 = g(motionEvent.getX());
                float fAbs = Math.abs(fG2 - this.R);
                this.S = fAbs;
                if (fG2 != this.H && fAbs > l(1)) {
                    this.H = fG2;
                    this.f3032w = fG2;
                    this.f3023c = h();
                    invalidate();
                    e eVar4 = this.I;
                    if (eVar4 != null) {
                        eVar4.c(this, getProgress(), getProgressFloat(), true);
                    }
                }
            }
        } else if (actionMasked == 3) {
            this.Q = System.currentTimeMillis();
            getParent().requestDisallowInterceptTouchEvent(false);
            if (this.f3034y) {
                float fG3 = g(motionEvent.getX());
                this.H = fG3;
                this.f3032w = fG3;
                this.f3023c = h();
                eVar2 = this.I;
                if (eVar2 != null) {
                    eVar2.c(this, getProgress(), getProgressFloat(), true);
                }
            }
            valueAnimator = this.T;
            if (valueAnimator != null) {
                this.T.cancel();
            }
            ValueAnimator valueAnimatorK2 = k();
            this.U = valueAnimatorK2;
            valueAnimatorK2.start();
            this.f3034y = false;
            eVar = this.I;
            if (eVar != null) {
                eVar.b(this);
            }
        }
        return this.f3034y || super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean performClick() {
        return super.performClick();
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        if (z10) {
            this.f3029n = o();
        } else {
            this.f3029n = ContextCompat.getColor(this.N, R.color.os_gray_secondary_color);
        }
        invalidate();
    }

    public void setOnProgressChangedListener(e eVar) {
        this.I = eVar;
    }

    public void setProgress(float f10) {
        this.f3023c = f10;
        e eVar = this.I;
        if (eVar != null) {
            eVar.c(this, getProgress(), getProgressFloat(), false);
        }
        postInvalidate();
    }

    public void setSecondTrackColor(int i10) {
        if (this.f3029n != i10) {
            this.f3029n = i10;
            invalidate();
        }
    }

    public void setTrackColor(int i10) {
        if (this.f3028i != i10) {
            this.f3028i = i10;
            invalidate();
        }
    }

    public OSWideSeekbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OSWideSeekbar(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f3030p = l(2);
        this.P = 0L;
        this.Q = 0L;
        this.N = context;
        getConfigBuilder().a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.OSWideSeekbar, i10, 0);
        this.f3021a = typedArrayObtainStyledAttributes.getFloat(R.styleable.OSWideSeekbar_osWideSeekbarMin, 0.0f);
        this.f3022b = typedArrayObtainStyledAttributes.getFloat(R.styleable.OSWideSeekbar_osWideSeekbarMax, 100.0f);
        this.f3023c = typedArrayObtainStyledAttributes.getFloat(R.styleable.OSWideSeekbar_osWideSeekbarProgress, this.f3021a);
        setEnabled(typedArrayObtainStyledAttributes.getBoolean(R.styleable.OSWideSeekbar_android_enabled, isEnabled()));
        typedArrayObtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.L = paint;
        paint.setAntiAlias(true);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setTextAlign(Paint.Align.CENTER);
        this.M = new Rect();
        this.f3035z = l(2);
        n();
        if (h.I() && getRotation() == 0.0f) {
            setRotation(180.0f);
        }
    }
}
