package com.transsion.widgetslib.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.NonNull;
import c0.b;
import com.transsion.widgetslib.R;
import hj.h;
import ps.d;

/* JADX INFO: loaded from: classes2.dex */
public class BadgeView extends View {
    public static final String M = "RedPointView";
    public static final int N = 0;
    public static final int O = 1;
    public static final int P = 2;
    public static final int Q = 3;
    public static final int R = 4;
    public static final int S = 5;
    public static final int T = 6;
    public static final int U = 8;
    public static final int V = 12;
    public RectF H;
    public RectF I;
    public boolean J;
    public Context K;
    public int L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2362a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2363b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2364c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2365d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2366e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2367f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f2368g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f2369i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f2370n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f2371p;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f2372v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f2373w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f2374x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Paint f2375y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Paint f2376z;

    public BadgeView(Context context) {
        this(context, null);
    }

    public static int a(int i10) {
        return (int) TypedValue.applyDimension(1, i10, Resources.getSystem().getDisplayMetrics());
    }

    public static int b(int i10) {
        if (i10 != 1) {
            return i10 != 2 ? 6 : 12;
        }
        return 8;
    }

    public final void c(@NonNull Context context, AttributeSet attributeSet) {
        this.K = context;
        this.H = new RectF();
        this.I = new RectF();
        Paint paint = new Paint();
        this.f2375y = paint;
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f2376z = paint2;
        paint2.setAntiAlias(true);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.OSRedPointTextView);
        this.f2365d = typedArrayObtainStyledAttributes.getInt(R.styleable.OSRedPointTextView_osRedPointTextViewType, 0);
        this.f2372v = d(typedArrayObtainStyledAttributes.getInt(R.styleable.OSRedPointTextView_osRedPointTextViewNum, 0));
        this.J = typedArrayObtainStyledAttributes.getBoolean(R.styleable.OSRedPointTextView_osRedPointTextViewHaveOuterCircle, false);
        TypedArray typedArrayObtainStyledAttributes2 = this.K.obtainStyledAttributes(new int[]{R.attr.OsBgPrimary});
        this.f2362a = typedArrayObtainStyledAttributes.getColor(R.styleable.OSRedPointTextView_osRedPointTextViewBg, Color.parseColor("#FF575C"));
        this.f2363b = typedArrayObtainStyledAttributes.getColor(R.styleable.OSRedPointTextView_osRedPointTextViewOutCircleBg, typedArrayObtainStyledAttributes2.getColor(0, this.K.getColor(R.color.os_bg_primary_color)));
        typedArrayObtainStyledAttributes2.recycle();
        typedArrayObtainStyledAttributes.recycle();
        this.L = h.e(this.K, 1);
        setRedPointType(this.f2365d);
    }

    public String d(int i10) {
        this.f2372v = i10 + "";
        if (i10 > 99) {
            this.f2372v = "99+";
        }
        setRedPointType(this.f2365d);
        return this.f2372v;
    }

    public int getBackgroundColor() {
        return this.f2362a;
    }

    public int getRedPointType() {
        return this.f2365d;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.J) {
            this.f2375y.setColor(this.f2363b);
            RectF rectF = this.I;
            int i10 = this.f2371p;
            canvas.drawRoundRect(rectF, i10, i10, this.f2375y);
            this.f2375y.setColor(this.f2362a);
            RectF rectF2 = this.H;
            int i11 = this.f2371p;
            int i12 = this.L;
            canvas.drawRoundRect(rectF2, i11 - i12, i11 - i12, this.f2375y);
        } else {
            this.f2375y.setColor(this.f2362a);
            RectF rectF3 = this.I;
            int i13 = this.f2371p;
            canvas.drawRoundRect(rectF3, i13, i13, this.f2375y);
        }
        if (TextUtils.isEmpty(this.f2372v)) {
            return;
        }
        Paint.FontMetrics fontMetrics = this.f2376z.getFontMetrics();
        float f10 = fontMetrics.bottom;
        int i14 = (int) ((this.f2366e / 2) + (((f10 - fontMetrics.top) / 2.0f) - f10));
        int i15 = (int) ((this.f2367f - this.f2373w) / 2.0f);
        if (!this.f2372v.contains(d.ANY_NON_NULL_MARKER)) {
            canvas.drawText(this.f2372v, i15, i14, this.f2376z);
            return;
        }
        float f11 = i15;
        canvas.drawText(b.a(this.f2372v, 1, 0), f11, i14, this.f2376z);
        this.f2376z.setTextSize(this.f2370n);
        Paint.FontMetrics fontMetrics2 = this.f2376z.getFontMetrics();
        float f12 = fontMetrics2.bottom;
        canvas.drawText(d.ANY_NON_NULL_MARKER, (this.f2373w - this.f2374x) + f11, (int) ((this.f2366e / 2) + (((f12 - fontMetrics2.top) / 2.0f) - f12)), this.f2376z);
        this.f2376z.setTextSize(this.f2369i);
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        setMeasuredDimension(this.f2367f, this.f2366e);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i10) {
        this.f2362a = i10;
        setRedPointType(this.f2365d);
    }

    public void setRedPointType(int i10) {
        this.f2375y.setColor(this.f2362a);
        this.f2376z.setColor(this.f2364c);
        this.f2365d = i10;
        if (i10 == 0) {
            this.f2366e = a(6);
            this.f2368g = a(0);
            this.f2369i = a(0);
            this.f2367f = this.f2366e;
        } else if (i10 == 1) {
            this.f2366e = a(8);
            this.f2368g = a(0);
            this.f2369i = a(0);
            this.f2367f = this.f2366e;
        } else if (i10 == 2) {
            this.f2366e = a(12);
            this.f2368g = a(0);
            this.f2369i = a(0);
            this.f2367f = this.f2366e;
        } else if (i10 == 3) {
            this.f2366e = a(14);
            int iA = a(4);
            this.f2368g = iA;
            if (this.J) {
                this.f2368g = iA - this.L;
            }
            this.f2369i = a(9);
            this.f2370n = a(6);
            this.f2376z.setTextSize(this.f2369i);
            if (TextUtils.isEmpty(this.f2372v)) {
                this.f2367f = this.f2366e;
            } else {
                if (this.f2372v.endsWith(d.ANY_NON_NULL_MARKER)) {
                    float fMeasureText = this.f2376z.measureText(b.a(this.f2372v, 1, 0));
                    this.f2376z.setTextSize(this.f2370n);
                    float fMeasureText2 = this.f2376z.measureText(d.ANY_NON_NULL_MARKER);
                    this.f2374x = fMeasureText2;
                    this.f2373w = fMeasureText + fMeasureText2;
                } else {
                    this.f2373w = this.f2376z.measureText(this.f2372v);
                }
                this.f2367f = (int) (this.f2373w + (this.f2368g * 2));
            }
        } else if (i10 == 4) {
            this.f2366e = a(16);
            int iA2 = a(4);
            int i11 = this.L;
            int i12 = iA2 - i11;
            this.f2368g = i12;
            if (this.J) {
                this.f2368g = i12 - i11;
            }
            this.f2369i = a(10);
            this.f2370n = a(8);
            this.f2376z.setTextSize(this.f2369i);
            if (TextUtils.isEmpty(this.f2372v)) {
                this.f2367f = this.f2366e;
            } else {
                if (this.f2372v.endsWith(d.ANY_NON_NULL_MARKER)) {
                    float fMeasureText3 = this.f2376z.measureText(b.a(this.f2372v, 1, 0));
                    this.f2376z.setTextSize(this.f2370n);
                    float fMeasureText4 = this.f2376z.measureText(d.ANY_NON_NULL_MARKER);
                    this.f2374x = fMeasureText4;
                    this.f2373w = fMeasureText3 + fMeasureText4;
                } else {
                    this.f2373w = this.f2376z.measureText(this.f2372v);
                }
                this.f2367f = (int) (this.f2373w + (this.f2368g * 2));
            }
        } else if (i10 == 5) {
            this.f2366e = a(20);
            int iA3 = a(4);
            this.f2368g = iA3;
            if (this.J) {
                this.f2368g = iA3 - this.L;
            }
            this.f2369i = a(12);
            this.f2370n = a(8);
            this.f2376z.setTextSize(this.f2369i);
            if (TextUtils.isEmpty(this.f2372v)) {
                this.f2367f = this.f2366e;
            } else {
                if (this.f2372v.endsWith(d.ANY_NON_NULL_MARKER)) {
                    float fMeasureText5 = this.f2376z.measureText(b.a(this.f2372v, 1, 0));
                    this.f2376z.setTextSize(this.f2370n);
                    float fMeasureText6 = this.f2376z.measureText(d.ANY_NON_NULL_MARKER);
                    this.f2374x = fMeasureText6;
                    this.f2373w = fMeasureText5 + fMeasureText6;
                } else {
                    this.f2373w = this.f2376z.measureText(this.f2372v);
                }
                this.f2367f = (int) (this.f2373w + (this.f2368g * 2));
            }
        }
        this.f2376z.setTextSize(this.f2369i);
        if (this.J) {
            int i13 = this.f2367f;
            int i14 = this.L;
            this.f2367f = (i14 * 2) + i13;
            this.f2366e = (i14 * 2) + this.f2366e;
        }
        int i15 = this.f2366e;
        this.f2371p = i15 / 2;
        int iMax = Math.max(this.f2367f, i15);
        this.f2367f = iMax;
        this.I.set(0.0f, 0.0f, iMax, this.f2366e);
        if (this.J) {
            RectF rectF = this.H;
            int i16 = this.L;
            rectF.set(i16, i16, this.f2367f - i16, this.f2366e - i16);
        }
        invalidate();
        requestLayout();
    }

    public BadgeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2364c = Color.parseColor("#FFFFFF");
        this.f2365d = 0;
        c(context, attributeSet);
    }
}
