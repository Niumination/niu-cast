package com.transsion.widgetslib.widget.seekbar;

import af.f;
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
import com.transsion.widgetslib.R$attr;
import com.transsion.widgetslib.R$color;
import com.transsion.widgetslib.R$styleable;
import ee.a;
import ee.b;
import java.lang.ref.WeakReference;
import pd.j;

/* JADX INFO: loaded from: classes2.dex */
public class OSMultiSeekBar extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f3528a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f3529b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f3530c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f3531d;
    public final float e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f3532h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f3533i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f3534j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f3535k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f3536l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f3537m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f3538n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f3539o;
    public boolean p;
    public float q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f3540r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f3541s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Paint f3542t;
    public final Context u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public a f3543v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Paint f3544w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f3545x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f3546y;

    public OSMultiSeekBar(Context context) {
        this(context, null);
    }

    public static int a(int i8) {
        return (int) TypedValue.applyDimension(1, i8, Resources.getSystem().getDisplayMetrics());
    }

    public final void b() {
        if (this.f3528a == this.f3529b) {
            this.f3528a = 0.0f;
            this.f3529b = 100.0f;
        }
        float f = this.f3528a;
        float f4 = this.f3529b;
        if (f > f4) {
            this.f3529b = f;
            this.f3528a = f4;
        }
        float f10 = this.f3530c;
        float f11 = this.f3528a;
        if (f10 < f11) {
            this.f3530c = f11;
        }
        float f12 = this.f3530c;
        float f13 = this.f3529b;
        if (f12 > f13) {
            this.f3530c = f13;
        }
        float f14 = this.f3535k;
        float f15 = this.e;
        if (f14 <= f15) {
            this.f3535k = a(4) + ((int) f15);
        }
        this.f3537m = this.f3529b - this.f3528a;
        setProgress(this.f3530c);
    }

    public final int c() {
        TypedValue typedValue = new TypedValue();
        Context context = this.u;
        return context.getTheme().resolveAttribute(R$attr.os_platform_basic_color, typedValue, true) ? ContextCompat.getColor(context, typedValue.resourceId) : ContextCompat.getColor(context, R$color.os_platform_basic_color_hios);
    }

    public final int d() {
        TypedValue typedValue = new TypedValue();
        Context context = this.u;
        return context.getTheme().resolveAttribute(R$attr.os_platform_basic_color, typedValue, true) ? ContextCompat.getColor(context, typedValue.resourceId) : ContextCompat.getColor(context, R$color.os_platform_basic_color_hios);
    }

    public a getConfigBuilder() {
        if (this.f3543v == null) {
            a aVar = new a();
            aVar.f4848i = new WeakReference(this);
            aVar.f4842a = 100.0f;
            aVar.f4843b = a(3);
            aVar.f4844c = a(3);
            aVar.f4847h = a(8);
            aVar.f4845d = j.e(this.u, R$attr.os_fill_weak, R$color.os_fill_weak_hios);
            aVar.e = c();
            aVar.f = a(8);
            aVar.f4846g = d();
            this.f3543v = aVar;
        }
        return this.f3543v;
    }

    public float getMax() {
        return this.f3529b;
    }

    public float getMin() {
        return this.f3528a;
    }

    public b getOnProgressChangedListener() {
        return null;
    }

    public int getProgress() {
        return Math.round(this.f3530c);
    }

    public float getProgressFloat() {
        return this.f3530c;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f = this.f3540r;
        float f4 = this.f3541s;
        float paddingTop = (this.f3535k * 0.5f) + getPaddingTop() + this.f3536l;
        if (!this.p) {
            this.f3538n = a1.a.b(this.f3530c, this.f3528a, this.f3539o / this.f3537m, f);
        }
        Paint paint = this.f3542t;
        paint.setColor(this.f3532h);
        paint.setStrokeWidth(this.f3531d);
        canvas.drawLine(this.f3538n, paddingTop, f4, paddingTop, paint);
        paint.setColor(this.f3533i);
        paint.setStrokeWidth(this.e);
        canvas.drawLine(f, paddingTop, this.f3538n, paddingTop, paint);
        Paint paint2 = this.f3544w;
        paint2.setStyle(Paint.Style.FILL);
        paint2.setColor(this.f3534j);
        canvas.drawCircle(this.f3538n, paddingTop, this.f3535k * 0.5f, paint2);
    }

    @Override // android.view.View
    public final void onLayout(boolean z2, int i8, int i9, int i10, int i11) {
        super.onLayout(z2, i8, i9, i10, i11);
    }

    @Override // android.view.View
    public final void onMeasure(int i8, int i9) {
        super.onMeasure(i8, i9);
        setMeasuredDimension(View.resolveSize(a(180), i8), getPaddingBottom() + (this.f3536l * 2) + getPaddingTop() + this.f3535k);
        this.f3540r = (this.f3535k * 0.5f) + getPaddingLeft();
        float measuredWidth = ((getMeasuredWidth() - getPaddingRight()) - this.f3531d) - (this.f3535k * 0.5f);
        this.f3541s = measuredWidth;
        this.f3539o = measuredWidth - this.f3540r;
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        this.f3530c = bundle.getFloat("progress");
        super.onRestoreInstanceState(bundle.getParcelable("save_instance"));
        setProgress(this.f3530c);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("save_instance", super.onSaveInstanceState());
        bundle.putFloat("progress", this.f3530c);
        return bundle;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i8, int i9, int i10, int i11) {
        super.onSizeChanged(i8, i9, i10, i11);
        post(new f(this, 18));
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0029 A[PHI: r3
      0x0029: PHI (r3v18 float) = (r3v7 float), (r3v8 float) binds: [B:13:0x0027, B:16:0x002f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:25:0x0065  */
    /* JADX WARN: Code duplicated, block: B:27:0x0073  */
    /* JADX WARN: Code duplicated, block: B:29:0x007d  */
    /* JADX WARN: Code duplicated, block: B:30:0x007f  */
    /* JADX WARN: Code duplicated, block: B:32:0x0085  */
    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        float x2;
        float f;
        float f4;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            super.performClick();
            getParent().requestDisallowInterceptTouchEvent(true);
            boolean zIsEnabled = isEnabled();
            this.p = zIsEnabled;
            this.f3546y = false;
            if (zIsEnabled) {
                if (motionEvent.getX() < this.f3540r || motionEvent.getX() > this.f3541s) {
                    this.p = false;
                    return false;
                }
                this.f3545x = motionEvent.getX();
                System.currentTimeMillis();
            }
        } else if (actionMasked == 1) {
            System.currentTimeMillis();
            getParent().requestDisallowInterceptTouchEvent(false);
            if (this.p) {
                x2 = motionEvent.getX();
                f = this.f3540r;
                if (x2 <= f) {
                    x2 = f;
                } else {
                    f4 = this.f3541s;
                    if (x2 >= f4) {
                        x2 = f4;
                    }
                }
                this.q = x2;
                this.f3538n = x2;
                this.f3530c = (((x2 - f) * this.f3537m) / this.f3539o) + this.f3528a;
            }
            this.p = false;
        } else if (actionMasked == 2) {
            this.p = isEnabled();
            System.currentTimeMillis();
            if (this.p) {
                float x8 = motionEvent.getX();
                float f10 = this.f3540r;
                if (x8 <= f10) {
                    x8 = f10;
                } else {
                    f10 = this.f3541s;
                    if (x8 >= f10) {
                        x8 = f10;
                    }
                }
                float fAbs = Math.abs(x8 - this.f3545x);
                if (x8 != this.q && (fAbs > a(1) || this.f3546y)) {
                    this.q = x8;
                    this.f3538n = x8;
                    this.f3546y = true;
                    this.f3530c = (((x8 - this.f3540r) * this.f3537m) / this.f3539o) + this.f3528a;
                    invalidate();
                }
            }
        } else if (actionMasked == 3) {
            System.currentTimeMillis();
            getParent().requestDisallowInterceptTouchEvent(false);
            if (this.p) {
                x2 = motionEvent.getX();
                f = this.f3540r;
                if (x2 <= f) {
                    x2 = f;
                } else {
                    f4 = this.f3541s;
                    if (x2 >= f4) {
                        x2 = f4;
                    }
                }
                this.q = x2;
                this.f3538n = x2;
                this.f3530c = (((x2 - f) * this.f3537m) / this.f3539o) + this.f3528a;
            }
            this.p = false;
        }
        return this.p || super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void setEnabled(boolean z2) {
        super.setEnabled(z2);
        if (z2) {
            this.f3533i = c();
            this.f3534j = d();
        } else {
            int i8 = R$attr.os_fill_weak;
            int i9 = R$color.os_fill_weak_hios;
            Context context = this.u;
            this.f3533i = j.e(context, i8, i9);
            this.f3534j = j.e(context, R$attr.os_grayfill_base, R$color.os_grayfill_base_hios);
        }
        invalidate();
    }

    public void setOnProgressChangedListener(b bVar) {
    }

    public void setProgress(float f) {
        this.f3530c = f;
        postInvalidate();
    }

    public void setSecondTrackColor(int i8) {
        if (this.f3533i != i8) {
            this.f3533i = i8;
            invalidate();
        }
    }

    public void setTrackColor(int i8) {
        if (this.f3532h != i8) {
            this.f3532h = i8;
            invalidate();
        }
    }

    public OSMultiSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OSMultiSeekBar(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        this.u = context;
        a configBuilder = getConfigBuilder();
        WeakReference weakReference = configBuilder.f4848i;
        if (weakReference.get() != null) {
            OSMultiSeekBar oSMultiSeekBar = (OSMultiSeekBar) weakReference.get();
            oSMultiSeekBar.getClass();
            oSMultiSeekBar.f3528a = 0.0f;
            oSMultiSeekBar.f3529b = configBuilder.f4842a;
            oSMultiSeekBar.f3530c = 0.0f;
            oSMultiSeekBar.f3532h = configBuilder.f4845d;
            oSMultiSeekBar.f3533i = configBuilder.e;
            oSMultiSeekBar.f3531d = configBuilder.f4843b;
            oSMultiSeekBar.e = configBuilder.f4844c;
            oSMultiSeekBar.f3535k = configBuilder.f;
            oSMultiSeekBar.f3534j = configBuilder.f4846g;
            oSMultiSeekBar.f3536l = configBuilder.f4847h;
            oSMultiSeekBar.b();
            oSMultiSeekBar.f3543v = null;
            oSMultiSeekBar.requestLayout();
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.OSMultiSeekbar, i8, 0);
        this.f3528a = typedArrayObtainStyledAttributes.getFloat(R$styleable.OSMultiSeekbar_osMultiSeekbarMin, 0.0f);
        this.f3529b = typedArrayObtainStyledAttributes.getFloat(R$styleable.OSMultiSeekbar_osMultiSeekbarMax, 100.0f);
        this.f3530c = typedArrayObtainStyledAttributes.getFloat(R$styleable.OSMultiSeekbar_osMultiSeekbarProgress, this.f3528a);
        setEnabled(typedArrayObtainStyledAttributes.getBoolean(R$styleable.OSMultiSeekbar_android_enabled, isEnabled()));
        typedArrayObtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.f3542t = paint;
        paint.setAntiAlias(true);
        Paint.Cap cap = Paint.Cap.ROUND;
        paint.setStrokeCap(cap);
        Paint.Align align = Paint.Align.CENTER;
        paint.setTextAlign(align);
        Paint paint2 = new Paint();
        this.f3544w = paint2;
        paint2.setAntiAlias(true);
        paint2.setStrokeCap(cap);
        paint2.setTextAlign(align);
        b();
        if (j.v() && getRotation() == 0.0f) {
            setRotation(180.0f);
        }
    }
}
