package com.transsion.widgetslib.widget.seekbar;

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
public class OSMultiSeekBar extends View {
    public c H;
    public float I;
    public float J;
    public final Paint K;
    public final Context L;
    public b M;
    public final Paint N;
    public long O;
    public long P;
    public float Q;
    public float R;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f2889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f2890b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f2891c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f2892d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f2893e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2894f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f2895g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f2896i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f2897n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f2898p;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f2899v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f2900w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f2901x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f2902y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f2903z;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            OSMultiSeekBar.this.requestLayout();
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f2905a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f2906b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f2907c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f2908d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f2909e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f2910f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f2911g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f2912h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f2913i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f2914j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public WeakReference<OSMultiSeekBar> f2915k;

        public b(OSMultiSeekBar oSMultiSeekBar) {
            if (oSMultiSeekBar != null) {
                this.f2915k = new WeakReference<>(oSMultiSeekBar);
                this.f2905a = 0.0f;
                this.f2906b = 100.0f;
                this.f2907c = 0.0f;
                this.f2908d = OSMultiSeekBar.g(3);
                this.f2909e = OSMultiSeekBar.g(3);
                this.f2914j = OSMultiSeekBar.g(8);
                this.f2910f = ContextCompat.getColor(oSMultiSeekBar.L, R.color.os_gray_primary_color);
                this.f2911g = oSMultiSeekBar.j();
                this.f2912h = OSMultiSeekBar.g(8);
                this.f2913i = oSMultiSeekBar.l();
            }
        }

        public void a() {
            if (this.f2915k.get() != null) {
                this.f2915k.get().f(this);
            }
        }

        public b b(float f10) {
            this.f2906b = f10;
            return this;
        }

        public b c(float f10) {
            this.f2905a = f10;
            this.f2907c = f10;
            return this;
        }

        public b d(int i10) {
            this.f2914j = OSMultiSeekBar.g(i10);
            return this;
        }

        public b e(float f10) {
            this.f2907c = f10;
            return this;
        }

        public b f(int i10) {
            this.f2911g = i10;
            return this;
        }

        public b g(int i10) {
            this.f2909e = OSMultiSeekBar.g(i10);
            return this;
        }

        public b h(int i10) {
            this.f2913i = i10;
            return this;
        }

        public b i(int i10) {
            this.f2912h = OSMultiSeekBar.g(i10);
            return this;
        }

        public b j(int i10) {
            this.f2910f = i10;
            return this;
        }

        public b k(int i10) {
            this.f2908d = OSMultiSeekBar.g(i10);
            return this;
        }
    }

    public interface c {
        void a(OSMultiSeekBar oSMultiSeekBar);

        void b(OSMultiSeekBar oSMultiSeekBar, int i10, float f10, boolean z10);

        void c(OSMultiSeekBar oSMultiSeekBar);
    }

    public OSMultiSeekBar(Context context) {
        this(context, null, 0);
    }

    public static int g(int i10) {
        return (int) TypedValue.applyDimension(1, i10, Resources.getSystem().getDisplayMetrics());
    }

    public static int k(int i10) {
        return (int) TypedValue.applyDimension(2, i10, Resources.getSystem().getDisplayMetrics());
    }

    public final float d(float f10) {
        float f11 = this.I;
        if (f10 <= f11) {
            return f11;
        }
        float f12 = this.J;
        return f10 >= f12 ? f12 : f10;
    }

    public final float e() {
        return (((this.f2900w - this.I) * this.f2899v) / this.f2901x) + this.f2889a;
    }

    public void f(b bVar) {
        this.f2889a = bVar.f2905a;
        this.f2890b = bVar.f2906b;
        this.f2891c = bVar.f2907c;
        this.f2894f = bVar.f2910f;
        this.f2895g = bVar.f2911g;
        this.f2892d = bVar.f2908d;
        this.f2893e = bVar.f2909e;
        this.f2897n = bVar.f2912h;
        this.f2896i = bVar.f2913i;
        this.f2898p = bVar.f2914j;
        i();
        c cVar = this.H;
        if (cVar != null) {
            cVar.b(this, getProgress(), getProgressFloat(), false);
        }
        this.M = null;
        requestLayout();
    }

    public b getConfigBuilder() {
        if (this.M == null) {
            this.M = new b(this);
        }
        return this.M;
    }

    public float getMax() {
        return this.f2890b;
    }

    public float getMin() {
        return this.f2889a;
    }

    public c getOnProgressChangedListener() {
        return this.H;
    }

    public int getProgress() {
        return Math.round(this.f2891c);
    }

    public float getProgressFloat() {
        return this.f2891c;
    }

    public final float h(float f10) {
        return BigDecimal.valueOf(f10).setScale(1, 4).floatValue();
    }

    public final void i() {
        if (this.f2889a == this.f2890b) {
            this.f2889a = 0.0f;
            this.f2890b = 100.0f;
        }
        float f10 = this.f2889a;
        float f11 = this.f2890b;
        if (f10 > f11) {
            this.f2890b = f10;
            this.f2889a = f11;
        }
        float f12 = this.f2891c;
        float f13 = this.f2889a;
        if (f12 < f13) {
            this.f2891c = f13;
        }
        float f14 = this.f2891c;
        float f15 = this.f2890b;
        if (f14 > f15) {
            this.f2891c = f15;
        }
        float f16 = this.f2897n;
        float f17 = this.f2893e;
        if (f16 <= f17) {
            this.f2897n = g(4) + ((int) f17);
        }
        this.f2899v = this.f2890b - this.f2889a;
        setProgress(this.f2891c);
    }

    public final int j() {
        TypedValue typedValue = new TypedValue();
        return this.L.getTheme().resolveAttribute(R.attr.os_platform_basic_color, typedValue, true) ? ContextCompat.getColor(this.L, typedValue.resourceId) : ContextCompat.getColor(this.L, R.color.os_platform_basic_color_hios);
    }

    public final int l() {
        TypedValue typedValue = new TypedValue();
        return this.L.getTheme().resolveAttribute(R.attr.os_platform_basic_color, typedValue, true) ? ContextCompat.getColor(this.L, typedValue.resourceId) : ContextCompat.getColor(this.L, R.color.os_platform_basic_color_hios);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f10 = this.I;
        float f11 = this.J;
        float paddingTop = (this.f2897n * 0.5f) + getPaddingTop() + this.f2898p;
        if (!this.f2902y) {
            this.f2900w = g.a.a(this.f2891c, this.f2889a, this.f2901x / this.f2899v, f10);
        }
        this.K.setColor(this.f2894f);
        this.K.setStrokeWidth(this.f2892d);
        canvas.drawLine(this.f2900w, paddingTop, f11, paddingTop, this.K);
        this.K.setColor(this.f2895g);
        this.K.setStrokeWidth(this.f2893e);
        canvas.drawLine(f10, paddingTop, this.f2900w, paddingTop, this.K);
        this.N.setStyle(Paint.Style.FILL);
        this.N.setColor(this.f2896i);
        canvas.drawCircle(this.f2900w, paddingTop, this.f2897n * 0.5f, this.N);
    }

    @Override // android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        setMeasuredDimension(View.resolveSize(g(180), i10), getPaddingBottom() + (this.f2898p * 2) + getPaddingTop() + this.f2897n);
        this.I = (this.f2897n * 0.5f) + getPaddingLeft();
        float measuredWidth = ((getMeasuredWidth() - getPaddingRight()) - this.f2892d) - (this.f2897n * 0.5f);
        this.J = measuredWidth;
        this.f2901x = measuredWidth - this.I;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        this.f2891c = bundle.getFloat("progress");
        super.onRestoreInstanceState(bundle.getParcelable("save_instance"));
        setProgress(this.f2891c);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("save_instance", super.onSaveInstanceState());
        bundle.putFloat("progress", this.f2891c);
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
    /* JADX WARN: Code duplicated, block: B:26:0x0099  */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        c cVar;
        c cVar2;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            performClick();
            getParent().requestDisallowInterceptTouchEvent(true);
            boolean zIsEnabled = isEnabled();
            this.f2902y = zIsEnabled;
            if (zIsEnabled) {
                if (motionEvent.getX() < this.I || motionEvent.getX() > this.J) {
                    this.f2902y = false;
                    return false;
                }
                this.Q = motionEvent.getX();
                this.O = System.currentTimeMillis();
                c cVar3 = this.H;
                if (cVar3 != null) {
                    cVar3.a(this);
                }
            }
        } else if (actionMasked == 1) {
            this.P = System.currentTimeMillis();
            getParent().requestDisallowInterceptTouchEvent(false);
            if (this.f2902y) {
                float fD = d(motionEvent.getX());
                this.f2903z = fD;
                this.f2900w = fD;
                this.f2891c = e();
                cVar2 = this.H;
                if (cVar2 != null) {
                    cVar2.b(this, getProgress(), getProgressFloat(), true);
                }
            }
            this.f2902y = false;
            cVar = this.H;
            if (cVar != null) {
                cVar.c(this);
            }
        } else if (actionMasked == 2) {
            this.f2902y = isEnabled();
            this.P = System.currentTimeMillis();
            if (this.f2902y) {
                float fD2 = d(motionEvent.getX());
                float fAbs = Math.abs(fD2 - this.Q);
                this.R = fAbs;
                if (fD2 != this.f2903z && fAbs > g(1)) {
                    this.f2903z = fD2;
                    this.f2900w = fD2;
                    this.f2891c = e();
                    invalidate();
                    c cVar4 = this.H;
                    if (cVar4 != null) {
                        cVar4.b(this, getProgress(), getProgressFloat(), true);
                    }
                }
            }
        } else if (actionMasked == 3) {
            this.P = System.currentTimeMillis();
            getParent().requestDisallowInterceptTouchEvent(false);
            if (this.f2902y) {
                float fD3 = d(motionEvent.getX());
                this.f2903z = fD3;
                this.f2900w = fD3;
                this.f2891c = e();
                cVar2 = this.H;
                if (cVar2 != null) {
                    cVar2.b(this, getProgress(), getProgressFloat(), true);
                }
            }
            this.f2902y = false;
            cVar = this.H;
            if (cVar != null) {
                cVar.c(this);
            }
        }
        return this.f2902y || super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean performClick() {
        return super.performClick();
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        if (z10) {
            this.f2895g = j();
            this.f2896i = l();
        } else {
            this.f2895g = ContextCompat.getColor(this.L, R.color.os_gray_primary_color);
            this.f2896i = ContextCompat.getColor(this.L, R.color.os_gray_solid_primary_color);
        }
        invalidate();
    }

    public void setOnProgressChangedListener(c cVar) {
        this.H = cVar;
    }

    public void setProgress(float f10) {
        this.f2891c = f10;
        c cVar = this.H;
        if (cVar != null) {
            cVar.b(this, getProgress(), getProgressFloat(), false);
        }
        postInvalidate();
    }

    public void setSecondTrackColor(int i10) {
        if (this.f2895g != i10) {
            this.f2895g = i10;
            invalidate();
        }
    }

    public void setTrackColor(int i10) {
        if (this.f2894f != i10) {
            this.f2894f = i10;
            invalidate();
        }
    }

    public OSMultiSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OSMultiSeekBar(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.O = 0L;
        this.P = 0L;
        this.L = context;
        getConfigBuilder().a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.OSMultiSeekbar, i10, 0);
        this.f2889a = typedArrayObtainStyledAttributes.getFloat(R.styleable.OSMultiSeekbar_osMultiSeekbarMin, 0.0f);
        this.f2890b = typedArrayObtainStyledAttributes.getFloat(R.styleable.OSMultiSeekbar_osMultiSeekbarMax, 100.0f);
        this.f2891c = typedArrayObtainStyledAttributes.getFloat(R.styleable.OSMultiSeekbar_osMultiSeekbarProgress, this.f2889a);
        setEnabled(typedArrayObtainStyledAttributes.getBoolean(R.styleable.OSMultiSeekbar_android_enabled, isEnabled()));
        typedArrayObtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.K = paint;
        paint.setAntiAlias(true);
        Paint.Cap cap = Paint.Cap.ROUND;
        paint.setStrokeCap(cap);
        Paint.Align align = Paint.Align.CENTER;
        paint.setTextAlign(align);
        Paint paint2 = new Paint();
        this.N = paint2;
        paint2.setAntiAlias(true);
        paint2.setStrokeCap(cap);
        paint2.setTextAlign(align);
        i();
        if (h.I() && getRotation() == 0.0f) {
            setRotation(180.0f);
        }
    }
}
