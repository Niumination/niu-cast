package com.transsion.widgetslib.widget.seekbar;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.transsion.widgetslib.R;
import hj.h;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes2.dex */
public class OSSectionSeekbar extends View {
    public int H;
    public int I;
    public int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public boolean O;
    public float P;
    public float Q;
    public int R;
    public float S;
    public float T;
    public float U;
    public boolean V;
    public final int W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2916a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public SparseArray<String> f2917a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f2918b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public float f2919b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f2920c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public d f2921c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f2922d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public float f2923d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f2924e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public float f2925e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2926f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public final Paint f2927f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f2928g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public final Paint f2929g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public final Rect f2930h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f2931i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public final Context f2932i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public c f2933j0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f2934n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f2935p;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f2936v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f2937w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f2938x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f2939y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f2940z;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            OSSectionSeekbar.this.requestLayout();
        }
    }

    public interface b {
        SparseArray<String> a(int i10, SparseArray<String> sparseArray);
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f2942a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f2943b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f2944c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f2945d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f2946e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f2947f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f2948g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f2949h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f2950i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f2951j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f2952k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f2953l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f2954m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f2955n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f2956o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f2957p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f2958q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f2959r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f2960s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int f2961t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public int f2962u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public int f2963v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public WeakReference<OSSectionSeekbar> f2964w;

        public c(OSSectionSeekbar oSSectionSeekbar) {
            if (oSSectionSeekbar != null) {
                this.f2964w = new WeakReference<>(oSSectionSeekbar);
                this.f2942a = 0.0f;
                this.f2943b = 100.0f;
                this.f2944c = 0.0f;
                this.f2947f = OSSectionSeekbar.h(3);
                this.f2948g = OSSectionSeekbar.h(3);
                this.f2949h = OSSectionSeekbar.n(12);
                this.f2950i = OSSectionSeekbar.h(6);
                this.f2951j = OSSectionSeekbar.h(3);
                this.f2952k = OSSectionSeekbar.h(3);
                this.f2953l = OSSectionSeekbar.h(8);
                this.f2954m = OSSectionSeekbar.h(14);
                this.f2955n = OSSectionSeekbar.h(6);
                this.f2956o = 5;
                this.f2945d = false;
                this.f2946e = true;
                this.f2957p = ContextCompat.getColor(oSSectionSeekbar.f2932i0, R.color.os_gray_tertiary_color);
                this.f2958q = oSSectionSeekbar.m();
                this.f2959r = oSSectionSeekbar.o();
                this.f2960s = ContextCompat.getColor(oSSectionSeekbar.f2932i0, R.color.os_altitude_secondary_color);
                this.f2961t = ContextCompat.getColor(oSSectionSeekbar.f2932i0, R.color.os_text_tertiary_color);
                this.f2962u = ContextCompat.getColor(oSSectionSeekbar.f2932i0, R.color.os_fill_solid_tertiary_color);
            }
        }

        public void a() {
            if (this.f2964w.get() != null) {
                this.f2964w.get().g(this);
            }
        }

        public c b(boolean z10) {
            this.f2946e = z10;
            return this;
        }

        public c c(int i10) {
            this.f2962u = i10;
            return this;
        }

        public c d(int i10) {
            this.f2955n = OSSectionSeekbar.h(i10);
            return this;
        }

        public c e() {
            this.f2945d = true;
            return this;
        }

        public c f(float f10) {
            this.f2943b = f10;
            return this;
        }

        @Deprecated
        public c g(float f10) {
            this.f2942a = f10;
            this.f2944c = f10;
            return this;
        }

        public c h(int i10) {
            this.f2952k = OSSectionSeekbar.h(i10);
            return this;
        }

        public c i(float f10) {
            this.f2944c = f10;
            return this;
        }

        public c j(int i10) {
            this.f2958q = i10;
            return this;
        }

        public c k(int i10) {
            this.f2948g = OSSectionSeekbar.h(i10);
            return this;
        }

        public c l(int i10) {
            this.f2956o = i10;
            return this;
        }

        public c m(int i10) {
            this.f2961t = i10;
            return this;
        }

        public c n(int i10) {
            this.f2963v = i10;
            return this;
        }

        public c o(int i10) {
            this.f2949h = OSSectionSeekbar.n(i10);
            return this;
        }

        public c p(int i10) {
            this.f2951j = OSSectionSeekbar.h(i10);
            return this;
        }

        public c q(int i10) {
            this.f2950i = OSSectionSeekbar.h(i10);
            return this;
        }

        public c r(int i10) {
            this.f2953l = OSSectionSeekbar.h(i10);
            return this;
        }

        public c s(int i10) {
            this.f2960s = i10;
            return this;
        }

        public c t(int i10) {
            this.f2959r = i10;
            return this;
        }

        public c u(int i10) {
            this.f2954m = OSSectionSeekbar.h(i10);
            return this;
        }

        public c v(int i10) {
            this.f2957p = i10;
            return this;
        }

        public c w(int i10) {
            this.f2947f = OSSectionSeekbar.h(i10);
            return this;
        }
    }

    public interface d {
        void a(OSSectionSeekbar oSSectionSeekbar);

        void b(OSSectionSeekbar oSSectionSeekbar, int i10, float f10, boolean z10);

        void c(OSSectionSeekbar oSSectionSeekbar);
    }

    public OSSectionSeekbar(Context context) {
        this(context, null, 0);
    }

    public static int h(int i10) {
        return (int) TypedValue.applyDimension(1, i10, Resources.getSystem().getDisplayMetrics());
    }

    public static int n(int i10) {
        return (int) TypedValue.applyDimension(2, i10, Resources.getSystem().getDisplayMetrics());
    }

    public final float d(float f10) {
        float f11 = this.f2923d0;
        if (f10 <= f11) {
            return f11;
        }
        float f12 = this.f2925e0;
        if (f10 >= f12) {
            return f12;
        }
        float f13 = 0.0f;
        int i10 = 0;
        while (i10 <= this.f2934n) {
            float f14 = this.U;
            f13 = (i10 * f14) + this.f2923d0;
            if (f13 <= f10 && f10 - f13 <= f14) {
                break;
            }
            i10++;
        }
        float f15 = f10 - f13;
        float f16 = this.U;
        return f15 <= f16 / 2.0f ? f13 : ((i10 + 1) * f16) + this.f2923d0;
    }

    public final int e() {
        return Math.round((this.f2922d / this.P) * this.f2934n);
    }

    public final float f() {
        float f10;
        float f11;
        if (h.I()) {
            f10 = ((this.f2925e0 - this.S) * this.P) / this.T;
            f11 = this.f2918b;
        } else {
            f10 = ((this.S - this.f2923d0) * this.P) / this.T;
            f11 = this.f2918b;
        }
        return f10 + f11;
    }

    public void g(c cVar) {
        this.f2918b = cVar.f2942a;
        this.f2920c = cVar.f2943b;
        this.f2922d = cVar.f2944c;
        this.f2924e = cVar.f2945d;
        this.f2926f = cVar.f2947f;
        this.f2928g = cVar.f2948g;
        this.f2935p = cVar.f2953l;
        this.f2936v = cVar.f2954m;
        this.f2939y = cVar.f2955n;
        this.f2937w = cVar.f2950i;
        this.f2938x = cVar.f2951j;
        this.N = cVar.f2952k;
        this.f2940z = cVar.f2957p;
        this.H = cVar.f2958q;
        this.I = cVar.f2959r;
        this.J = cVar.f2960s;
        this.K = cVar.f2962u;
        this.f2934n = cVar.f2956o;
        this.f2931i = cVar.f2949h;
        this.L = cVar.f2961t;
        this.M = cVar.f2963v;
        this.O = cVar.f2946e;
        k();
        d dVar = this.f2921c0;
        if (dVar != null) {
            dVar.b(this, getProgress(), getProgressFloat(), false);
        }
        this.f2933j0 = null;
        requestLayout();
    }

    public c getConfigBuilder() {
        if (this.f2933j0 == null) {
            this.f2933j0 = new c(this);
        }
        return this.f2933j0;
    }

    public float getMax() {
        return this.f2920c;
    }

    public float getMin() {
        return this.f2918b;
    }

    public d getOnProgressChangedListener() {
        return this.f2921c0;
    }

    public int getProgress() {
        return Math.round(this.f2922d);
    }

    public float getProgressFloat() {
        return this.f2922d;
    }

    public final String i(float f10) {
        return String.valueOf(j(f10));
    }

    public final float j(float f10) {
        return BigDecimal.valueOf(f10).setScale(1, 4).floatValue();
    }

    public final void k() {
        if (this.f2918b == this.f2920c) {
            this.f2918b = 0.0f;
            this.f2920c = 100.0f;
        }
        float f10 = this.f2918b;
        float f11 = this.f2920c;
        if (f10 > f11) {
            this.f2920c = f10;
            this.f2918b = f11;
        }
        float f12 = this.f2922d;
        float f13 = this.f2918b;
        if (f12 < f13) {
            this.f2922d = f13;
        }
        float f14 = this.f2922d;
        float f15 = this.f2920c;
        if (f14 > f15) {
            this.f2922d = f15;
        }
        int i10 = this.f2928g;
        int i11 = this.f2926f;
        if (i10 < i11) {
            this.f2928g = h(2) + i11;
        }
        int i12 = this.f2935p;
        int i13 = this.f2928g;
        if (i12 <= i13) {
            this.f2935p = h(4) + i13;
        }
        int i14 = this.f2936v;
        int i15 = this.f2935p;
        if (i14 < i15) {
            this.f2936v = h(6) + i15;
        }
        if (this.f2934n <= 0) {
            this.f2934n = 10;
        }
        float f16 = this.f2920c - this.f2918b;
        this.P = f16;
        float f17 = f16 / this.f2934n;
        this.Q = f17;
        if (f17 < 1.0f) {
            this.f2924e = true;
        }
        if (this.M < 1) {
            this.M = 1;
        }
        l();
        setProgress(this.f2922d);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x002b  */
    /* JADX WARN: Code duplicated, block: B:18:0x0030  */
    public final void l() {
        String strValueOf;
        boolean z10 = this.M > 1 && this.f2934n % 2 == 0;
        for (int i10 = 0; i10 <= this.f2934n; i10++) {
            float f10 = this.f2918b;
            float f11 = this.Q;
            float f12 = i10;
            float f13 = (f11 * f12) + f10;
            if (!z10) {
                SparseArray<String> sparseArray = this.f2917a0;
                if (this.f2924e) {
                    strValueOf = i(f13);
                } else {
                    strValueOf = String.valueOf((int) f13);
                }
                sparseArray.put(i10, strValueOf);
            } else if (i10 % this.M == 0) {
                f13 = (f11 * f12) + f10;
                SparseArray<String> sparseArray2 = this.f2917a0;
                if (this.f2924e) {
                    strValueOf = i(f13);
                } else {
                    strValueOf = String.valueOf((int) f13);
                }
                sparseArray2.put(i10, strValueOf);
            }
        }
    }

    public final int m() {
        TypedValue typedValue = new TypedValue();
        return this.f2932i0.getTheme().resolveAttribute(R.attr.os_platform_basic_color, typedValue, true) ? ContextCompat.getColor(this.f2932i0, typedValue.resourceId) : ContextCompat.getColor(this.f2932i0, R.color.os_platform_basic_color_hios);
    }

    public final int o() {
        TypedValue typedValue = new TypedValue();
        return this.f2932i0.getTheme().resolveAttribute(R.attr.os_platform_basic_color, typedValue, true) ? ContextCompat.getColor(this.f2932i0, typedValue.resourceId) : ContextCompat.getColor(this.f2932i0, R.color.os_platform_basic_color_hios);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float paddingTop = (this.f2936v * 0.5f) + getPaddingTop() + this.N;
        this.f2927f0.setColor(this.L);
        this.f2927f0.setTextSize(this.f2931i);
        float f10 = this.f2923d0;
        float f11 = this.f2925e0;
        float fHeight = (this.f2936v * 0.5f) + paddingTop + this.N + this.f2937w + this.f2930h0.height();
        for (int i10 = 0; i10 <= this.f2934n; i10++) {
            float f12 = h.I() ? f11 - (i10 * this.U) : (i10 * this.U) + f10;
            this.f2927f0.setColor(this.K);
            if (i10 > this.R) {
                canvas.drawCircle(f12, paddingTop, this.f2939y * 0.5f, this.f2927f0);
            }
            this.f2927f0.setColor(this.L);
            if (this.f2917a0.get(ui.a.s() ? this.f2934n - i10 : i10, null) != null && this.O) {
                canvas.drawText(this.f2917a0.get(i10), f12, fHeight, this.f2927f0);
            }
        }
        if (!this.V) {
            if (h.I()) {
                this.S = f11 - ((this.f2922d - this.f2918b) * (this.T / this.P));
            } else {
                this.S = g.a.a(this.f2922d, this.f2918b, this.T / this.P, f10);
            }
        }
        this.f2927f0.setColor(this.H);
        this.f2927f0.setStrokeWidth(this.f2928g);
        if (h.I()) {
            canvas.drawLine(this.S, paddingTop, f11, paddingTop, this.f2927f0);
        } else {
            canvas.drawLine(f10, paddingTop, this.S, paddingTop, this.f2927f0);
        }
        this.f2927f0.setColor(this.f2940z);
        this.f2927f0.setStrokeWidth(this.f2926f);
        if (ui.a.s()) {
            canvas.drawLine(f10, paddingTop, this.S, paddingTop, this.f2927f0);
        } else {
            canvas.drawLine(this.S, paddingTop, f11, paddingTop, this.f2927f0);
        }
        this.f2929g0.setColor(this.I);
        this.f2929g0.setStyle(Paint.Style.STROKE);
        int i11 = this.f2936v;
        int i12 = this.f2935p;
        float f13 = (i11 - i12) * 0.5f;
        float f14 = i12 >> 1;
        this.f2929g0.setStrokeWidth(f13);
        canvas.drawCircle(this.S, paddingTop, (0.5f * f13) + f14, this.f2929g0);
        this.f2929g0.setStyle(Paint.Style.FILL);
        this.f2929g0.setColor(this.J);
        canvas.drawCircle(this.S, paddingTop, f14, this.f2929g0);
    }

    @Override // android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        int paddingBottom = getPaddingBottom() + (this.N * 2) + getPaddingTop() + this.f2936v;
        this.f2927f0.setTextSize(this.f2931i);
        String str = this.f2917a0.get(0);
        this.f2927f0.getTextBounds(str, 0, str.length(), this.f2930h0);
        if (this.O) {
            paddingBottom = this.f2938x + this.f2930h0.height() + paddingBottom + this.f2937w;
        }
        setMeasuredDimension(View.resolveSize(h(180), i10), paddingBottom);
        this.f2923d0 = getPaddingLeft() + this.f2935p;
        this.f2925e0 = (getMeasuredWidth() - getPaddingRight()) - this.f2935p;
        this.f2927f0.setTextSize(this.f2931i);
        this.f2923d0 = getPaddingLeft() + Math.max(this.f2935p, this.f2930h0.width() / 2.0f) + this.W;
        String str2 = this.f2917a0.get(this.f2934n);
        this.f2927f0.getTextBounds(str2, 0, str2.length(), this.f2930h0);
        float measuredWidth = ((getMeasuredWidth() - getPaddingRight()) - Math.max(this.f2935p, this.f2930h0.width() / 2.0f)) - this.W;
        this.f2925e0 = measuredWidth;
        float f10 = measuredWidth - this.f2923d0;
        this.T = f10;
        this.U = (f10 * 1.0f) / this.f2934n;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        this.f2922d = bundle.getFloat("progress");
        this.R = e();
        super.onRestoreInstanceState(bundle.getParcelable("save_instance"));
        setProgress(this.f2922d);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("save_instance", super.onSaveInstanceState());
        bundle.putFloat("progress", this.f2922d);
        return bundle;
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        post(new a());
    }

    /* JADX WARN: Code duplicated, block: B:17:0x004b  */
    /* JADX WARN: Code duplicated, block: B:19:0x0058  */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        d dVar;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            performClick();
            getParent().requestDisallowInterceptTouchEvent(true);
            boolean zIsEnabled = isEnabled();
            this.V = zIsEnabled;
            if (zIsEnabled) {
                float fD = d(motionEvent.getX());
                this.f2919b0 = fD;
                this.S = fD;
                this.f2922d = f();
                this.R = e();
                invalidate();
                d dVar2 = this.f2921c0;
                if (dVar2 != null) {
                    dVar2.c(this);
                }
            }
        } else if (actionMasked == 1) {
            getParent().requestDisallowInterceptTouchEvent(false);
            this.V = false;
            dVar = this.f2921c0;
            if (dVar != null) {
                dVar.b(this, getProgress(), getProgressFloat(), true);
                this.f2921c0.a(this);
            }
        } else if (actionMasked == 2) {
            boolean zIsEnabled2 = isEnabled();
            this.V = zIsEnabled2;
            if (zIsEnabled2) {
                float fD2 = d(motionEvent.getX());
                if (fD2 != this.f2919b0) {
                    this.f2919b0 = fD2;
                    this.S = fD2;
                    this.f2922d = f();
                    this.R = e();
                    invalidate();
                    d dVar3 = this.f2921c0;
                    if (dVar3 != null) {
                        dVar3.b(this, getProgress(), getProgressFloat(), true);
                    }
                }
            }
        } else if (actionMasked == 3) {
            getParent().requestDisallowInterceptTouchEvent(false);
            this.V = false;
            dVar = this.f2921c0;
            if (dVar != null) {
                dVar.b(this, getProgress(), getProgressFloat(), true);
                this.f2921c0.a(this);
            }
        }
        return this.V || super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean performClick() {
        return super.performClick();
    }

    public void setCustomSectionTextArray(b bVar) {
        this.f2917a0 = bVar.a(this.f2934n, this.f2917a0);
        for (int i10 = 0; i10 <= this.f2934n; i10++) {
            if (this.f2917a0.get(i10) == null) {
                this.f2917a0.put(i10, "");
            }
        }
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        if (z10) {
            this.H = m();
            this.I = o();
        } else {
            this.H = ContextCompat.getColor(this.f2932i0, R.color.os_gray_secondary_color);
            this.I = ContextCompat.getColor(this.f2932i0, R.color.os_gray_solid_primary_color);
        }
        invalidate();
    }

    public void setOnProgressChangedListener(d dVar) {
        this.f2921c0 = dVar;
    }

    public void setProgress(float f10) {
        this.f2922d = (Math.round((f10 / this.P) * this.f2934n) * this.P) / this.f2934n;
        this.R = e();
        d dVar = this.f2921c0;
        if (dVar != null) {
            dVar.b(this, getProgress(), getProgressFloat(), false);
        }
        postInvalidate();
    }

    public void setSecondTrackColor(int i10) {
        if (this.H != i10) {
            this.H = i10;
            invalidate();
        }
    }

    public void setThumbInsideColor(int i10) {
        if (this.J != i10) {
            this.J = i10;
            invalidate();
        }
    }

    public void setThumbOutColor(int i10) {
        if (this.I != i10) {
            this.I = i10;
            invalidate();
        }
    }

    public void setTrackColor(int i10) {
        if (this.f2940z != i10) {
            this.f2940z = i10;
            invalidate();
        }
    }

    public OSSectionSeekbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OSSectionSeekbar(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f2916a = "OSSectionSeekbar";
        this.f2917a0 = new SparseArray<>();
        this.f2932i0 = context;
        getConfigBuilder().a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.OSSectionSeekbar, i10, 0);
        this.f2918b = typedArrayObtainStyledAttributes.getFloat(R.styleable.OSSectionSeekbar_osSectionSeekbarMin, 0.0f);
        this.f2920c = typedArrayObtainStyledAttributes.getFloat(R.styleable.OSSectionSeekbar_osSectionSeekbarMax, 100.0f);
        this.f2922d = typedArrayObtainStyledAttributes.getFloat(R.styleable.OSSectionSeekbar_osSectionSeekbarProgress, this.f2918b);
        this.R = e();
        this.f2934n = typedArrayObtainStyledAttributes.getInteger(R.styleable.OSSectionSeekbar_osSectionSeekbarSectionCount, 5);
        this.O = typedArrayObtainStyledAttributes.getBoolean(R.styleable.OSSectionSeekbar_osSectionSeekbarDisplayCharacters, true);
        setEnabled(typedArrayObtainStyledAttributes.getBoolean(R.styleable.OSSectionSeekbar_android_enabled, isEnabled()));
        typedArrayObtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.f2927f0 = paint;
        paint.setAntiAlias(true);
        Paint.Cap cap = Paint.Cap.ROUND;
        paint.setStrokeCap(cap);
        Paint.Align align = Paint.Align.CENTER;
        paint.setTextAlign(align);
        Paint paint2 = new Paint();
        this.f2929g0 = paint2;
        paint2.setAntiAlias(true);
        paint2.setStrokeCap(cap);
        paint2.setTextAlign(align);
        this.f2930h0 = new Rect();
        this.W = h(2);
        k();
    }
}
