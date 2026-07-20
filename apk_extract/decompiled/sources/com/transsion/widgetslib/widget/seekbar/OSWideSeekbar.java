package com.transsion.widgetslib.widget.seekbar;

import a1.a;
import af.f;
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
import com.transsion.widgetslib.R$attr;
import com.transsion.widgetslib.R$color;
import com.transsion.widgetslib.R$styleable;
import ee.m;
import ee.n;
import ee.o;
import java.lang.ref.WeakReference;
import pd.j;

/* JADX INFO: loaded from: classes2.dex */
public class OSWideSeekbar extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f3611a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f3612b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f3613c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f3614d;
    public final float e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f3615h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f3616i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f3617j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f3618k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f3619l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f3620m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f3621n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f3622o;
    public final int p;
    public float q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f3623r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f3624s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Paint f3625t;
    public final Context u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public n f3626v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f3627w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ValueAnimator f3628x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ValueAnimator f3629y;

    public OSWideSeekbar(Context context) {
        this(context, null);
    }

    public static int a(int i8) {
        return (int) TypedValue.applyDimension(1, i8, Resources.getSystem().getDisplayMetrics());
    }

    public final void b() {
        if (this.f3611a == this.f3612b) {
            this.f3611a = 0.0f;
            this.f3612b = 100.0f;
        }
        float f = this.f3611a;
        float f4 = this.f3612b;
        if (f > f4) {
            this.f3612b = f;
            this.f3611a = f4;
        }
        float f10 = this.f3613c;
        float f11 = this.f3611a;
        if (f10 < f11) {
            this.f3613c = f11;
        }
        float f12 = this.f3613c;
        float f13 = this.f3612b;
        if (f12 > f13) {
            this.f3613c = f13;
        }
        this.f3619l = f13 - f11;
        setProgress(this.f3613c);
    }

    public final int c() {
        TypedValue typedValue = new TypedValue();
        Context context = this.u;
        return context.getTheme().resolveAttribute(R$attr.os_platform_basic_color, typedValue, true) ? ContextCompat.getColor(context, typedValue.resourceId) : ContextCompat.getColor(context, R$color.os_platform_basic_color_hios);
    }

    public n getConfigBuilder() {
        if (this.f3626v == null) {
            n nVar = new n();
            nVar.f = new WeakReference(this);
            nVar.f4905a = 100.0f;
            nVar.f4906b = a(10);
            nVar.f4907c = a(10);
            nVar.f4908d = ContextCompat.getColor(this.u, R$color.os_gray_tertiary_color);
            nVar.e = c();
            this.f3626v = nVar;
        }
        return this.f3626v;
    }

    public float getMax() {
        return this.f3612b;
    }

    public float getMin() {
        return this.f3611a;
    }

    public o getOnProgressChangedListener() {
        return null;
    }

    public int getProgress() {
        return Math.round(this.f3613c);
    }

    public float getProgressFloat() {
        return this.f3613c;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f = this.f3623r;
        float f4 = this.f3624s;
        float paddingTop = (this.f3616i * 0.6f) + getPaddingTop() + (this.p * 2);
        if (!this.f3622o) {
            this.f3620m = a.b(this.f3613c, this.f3611a, this.f3621n / this.f3619l, f);
        }
        Paint paint = this.f3625t;
        paint.setColor(this.f3617j);
        paint.setStrokeWidth(this.f3614d);
        canvas.drawLine(f, paddingTop, f4, paddingTop, paint);
        paint.setColor(this.f3618k);
        paint.setStrokeWidth(this.f3615h);
        canvas.drawLine(f, paddingTop, this.f3620m, paddingTop, paint);
    }

    @Override // android.view.View
    public final void onLayout(boolean z2, int i8, int i9, int i10, int i11) {
        super.onLayout(z2, i8, i9, i10, i11);
    }

    @Override // android.view.View
    public final void onMeasure(int i8, int i9) {
        super.onMeasure(i8, i9);
        int paddingBottom = getPaddingBottom() + getPaddingTop() + ((int) (((double) this.f3616i) * 1.6d));
        int i10 = this.p;
        setMeasuredDimension(View.resolveSize(a(180), i8), (i10 * 2) + paddingBottom);
        this.f3623r = getPaddingLeft() + i10 + this.f3614d;
        float measuredWidth = ((getMeasuredWidth() - getPaddingRight()) - i10) - this.f3614d;
        this.f3624s = measuredWidth;
        this.f3621n = measuredWidth - this.f3623r;
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        this.f3613c = bundle.getFloat("progress");
        super.onRestoreInstanceState(bundle.getParcelable("save_instance"));
        setProgress(this.f3613c);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("save_instance", super.onSaveInstanceState());
        bundle.putFloat("progress", this.f3613c);
        return bundle;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i8, int i9, int i10, int i11) {
        super.onSizeChanged(i8, i9, i10, i11);
        post(new f(this, 19));
    }

    /* JADX WARN: Code duplicated, block: B:13:0x002d A[PHI: r1
      0x002d: PHI (r1v15 float) = (r1v5 float), (r1v6 float) binds: [B:12:0x002b, B:15:0x0033] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:22:0x0064  */
    /* JADX WARN: Code duplicated, block: B:24:0x0072  */
    /* JADX WARN: Code duplicated, block: B:26:0x007c  */
    /* JADX WARN: Code duplicated, block: B:27:0x007e  */
    /* JADX WARN: Code duplicated, block: B:29:0x0084  */
    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        ValueAnimator valueAnimator;
        float x2;
        float f;
        float f4;
        float f10 = this.f3616i;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            super.performClick();
            getParent().requestDisallowInterceptTouchEvent(true);
            boolean zIsEnabled = isEnabled();
            this.f3622o = zIsEnabled;
            if (zIsEnabled) {
                if (motionEvent.getX() < this.f3623r || motionEvent.getX() > this.f3624s) {
                    this.f3622o = false;
                    return false;
                }
                this.f3627w = motionEvent.getX();
                System.currentTimeMillis();
                ValueAnimator valueAnimator2 = this.f3629y;
                if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                    this.f3629y.cancel();
                }
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.f3615h / f10, 1.6f);
                valueAnimatorOfFloat.setDuration(250L);
                valueAnimatorOfFloat.addUpdateListener(new m(this, 0));
                this.f3628x = valueAnimatorOfFloat;
                valueAnimatorOfFloat.start();
            }
        } else if (actionMasked == 1) {
            System.currentTimeMillis();
            getParent().requestDisallowInterceptTouchEvent(false);
            if (this.f3622o) {
                x2 = motionEvent.getX();
                f = this.f3623r;
                if (x2 <= f) {
                    x2 = f;
                } else {
                    f4 = this.f3624s;
                    if (x2 >= f4) {
                        x2 = f4;
                    }
                }
                this.q = x2;
                this.f3620m = x2;
                this.f3613c = (((x2 - f) * this.f3619l) / this.f3621n) + this.f3611a;
            }
            valueAnimator = this.f3628x;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f3628x.cancel();
            }
            ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(this.f3615h / f10, 1.0f);
            valueAnimatorOfFloat2.setDuration(250L);
            valueAnimatorOfFloat2.addUpdateListener(new m(this, 1));
            this.f3629y = valueAnimatorOfFloat2;
            valueAnimatorOfFloat2.start();
            this.f3622o = false;
        } else if (actionMasked == 2) {
            this.f3622o = isEnabled();
            System.currentTimeMillis();
            if (this.f3622o) {
                float x8 = motionEvent.getX();
                float f11 = this.f3623r;
                if (x8 <= f11) {
                    x8 = f11;
                } else {
                    f11 = this.f3624s;
                    if (x8 >= f11) {
                        x8 = f11;
                    }
                }
                float fAbs = Math.abs(x8 - this.f3627w);
                if (x8 != this.q && fAbs > a(1)) {
                    this.q = x8;
                    this.f3620m = x8;
                    this.f3613c = (((x8 - this.f3623r) * this.f3619l) / this.f3621n) + this.f3611a;
                    invalidate();
                }
            }
        } else if (actionMasked == 3) {
            System.currentTimeMillis();
            getParent().requestDisallowInterceptTouchEvent(false);
            if (this.f3622o) {
                x2 = motionEvent.getX();
                f = this.f3623r;
                if (x2 <= f) {
                    x2 = f;
                } else {
                    f4 = this.f3624s;
                    if (x2 >= f4) {
                        x2 = f4;
                    }
                }
                this.q = x2;
                this.f3620m = x2;
                this.f3613c = (((x2 - f) * this.f3619l) / this.f3621n) + this.f3611a;
            }
            valueAnimator = this.f3628x;
            if (valueAnimator != null) {
                this.f3628x.cancel();
            }
            ValueAnimator valueAnimatorOfFloat3 = ValueAnimator.ofFloat(this.f3615h / f10, 1.0f);
            valueAnimatorOfFloat3.setDuration(250L);
            valueAnimatorOfFloat3.addUpdateListener(new m(this, 1));
            this.f3629y = valueAnimatorOfFloat3;
            valueAnimatorOfFloat3.start();
            this.f3622o = false;
        }
        return this.f3622o || super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void setEnabled(boolean z2) {
        super.setEnabled(z2);
        if (z2) {
            this.f3618k = c();
        } else {
            this.f3618k = ContextCompat.getColor(this.u, R$color.os_gray_secondary_color);
        }
        invalidate();
    }

    public void setOnProgressChangedListener(o oVar) {
    }

    public void setProgress(float f) {
        this.f3613c = f;
        postInvalidate();
    }

    public void setSecondTrackColor(int i8) {
        if (this.f3618k != i8) {
            this.f3618k = i8;
            invalidate();
        }
    }

    public void setTrackColor(int i8) {
        if (this.f3617j != i8) {
            this.f3617j = i8;
            invalidate();
        }
    }

    public OSWideSeekbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OSWideSeekbar(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        a(2);
        this.u = context;
        n configBuilder = getConfigBuilder();
        WeakReference weakReference = configBuilder.f;
        if (weakReference.get() != null) {
            OSWideSeekbar oSWideSeekbar = (OSWideSeekbar) weakReference.get();
            oSWideSeekbar.getClass();
            oSWideSeekbar.f3611a = 0.0f;
            oSWideSeekbar.f3612b = configBuilder.f4905a;
            oSWideSeekbar.f3613c = 0.0f;
            float f = configBuilder.f4906b;
            oSWideSeekbar.f3614d = f;
            float f4 = configBuilder.f4907c;
            oSWideSeekbar.f3615h = f4;
            oSWideSeekbar.f3617j = configBuilder.f4908d;
            oSWideSeekbar.f3618k = configBuilder.e;
            oSWideSeekbar.e = f;
            oSWideSeekbar.f3616i = f4;
            oSWideSeekbar.b();
            oSWideSeekbar.f3626v = null;
            oSWideSeekbar.requestLayout();
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.OSWideSeekbar, i8, 0);
        this.f3611a = typedArrayObtainStyledAttributes.getFloat(R$styleable.OSWideSeekbar_osWideSeekbarMin, 0.0f);
        this.f3612b = typedArrayObtainStyledAttributes.getFloat(R$styleable.OSWideSeekbar_osWideSeekbarMax, 100.0f);
        this.f3613c = typedArrayObtainStyledAttributes.getFloat(R$styleable.OSWideSeekbar_osWideSeekbarProgress, this.f3611a);
        setEnabled(typedArrayObtainStyledAttributes.getBoolean(R$styleable.OSWideSeekbar_android_enabled, isEnabled()));
        typedArrayObtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.f3625t = paint;
        paint.setAntiAlias(true);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setTextAlign(Paint.Align.CENTER);
        new Rect();
        this.p = a(2);
        b();
        if (j.v() && getRotation() == 0.0f) {
            setRotation(180.0f);
        }
    }
}
