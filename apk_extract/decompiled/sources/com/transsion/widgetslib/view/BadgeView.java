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
import com.transsion.widgetslib.R$attr;
import com.transsion.widgetslib.R$color;
import com.transsion.widgetslib.R$styleable;
import pd.j;
import vj.e;

/* JADX INFO: loaded from: classes2.dex */
public class BadgeView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3105b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3106c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3107d;
    public int e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f3108h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f3109i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f3110j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f3111k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f3112l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f3113m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f3114n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f3115o;
    public final Paint p;
    public final Paint q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final RectF f3116r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final RectF f3117s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f3118t;
    public final Context u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f3119v;

    public BadgeView(Context context) {
        this(context, null);
    }

    public static int a(int i8) {
        return (int) TypedValue.applyDimension(1, i8, Resources.getSystem().getDisplayMetrics());
    }

    public int getBackgroundColor() {
        return this.f3104a;
    }

    public int getRedPointType() {
        return this.f3107d;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f3118t) {
            this.p.setColor(this.f3105b);
            RectF rectF = this.f3117s;
            int i8 = this.f3112l;
            canvas.drawRoundRect(rectF, i8, i8, this.p);
            this.p.setColor(this.f3104a);
            RectF rectF2 = this.f3116r;
            int i9 = this.f3112l;
            int i10 = this.f3119v;
            canvas.drawRoundRect(rectF2, i9 - i10, i9 - i10, this.p);
        } else {
            this.p.setColor(this.f3104a);
            RectF rectF3 = this.f3117s;
            int i11 = this.f3112l;
            canvas.drawRoundRect(rectF3, i11, i11, this.p);
        }
        if (TextUtils.isEmpty(this.f3113m)) {
            return;
        }
        Paint.FontMetrics fontMetrics = this.q.getFontMetrics();
        float f = fontMetrics.bottom;
        int i12 = (int) ((this.e / 2) + (((f - fontMetrics.top) / 2.0f) - f));
        int i13 = (int) ((this.f3108h - this.f3114n) / 2.0f);
        if (!this.f3113m.contains(e.ANY_NON_NULL_MARKER)) {
            canvas.drawText(this.f3113m, i13, i12, this.q);
            return;
        }
        String str = this.f3113m;
        float f4 = i13;
        canvas.drawText(str.substring(0, str.length() - 1), f4, i12, this.q);
        this.q.setTextSize(this.f3111k);
        Paint.FontMetrics fontMetrics2 = this.q.getFontMetrics();
        float f10 = fontMetrics2.bottom;
        canvas.drawText(e.ANY_NON_NULL_MARKER, (this.f3114n - this.f3115o) + f4, (int) ((this.e / 2) + (((f10 - fontMetrics2.top) / 2.0f) - f10)), this.q);
        this.q.setTextSize(this.f3110j);
    }

    @Override // android.view.View
    public final void onMeasure(int i8, int i9) {
        super.onMeasure(i8, i9);
        setMeasuredDimension(this.f3108h, this.e);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i8) {
        this.f3104a = i8;
        setRedPointType(this.f3107d);
    }

    public void setRedPointType(int i8) {
        this.p.setColor(this.f3104a);
        this.q.setColor(this.f3106c);
        this.f3107d = i8;
        if (i8 == 0) {
            this.e = a(6);
            this.f3109i = a(0);
            this.f3110j = a(0);
            this.f3108h = this.e;
        } else if (i8 == 1) {
            this.e = a(8);
            this.f3109i = a(0);
            this.f3110j = a(0);
            this.f3108h = this.e;
        } else if (i8 == 2) {
            this.e = a(12);
            this.f3109i = a(0);
            this.f3110j = a(0);
            this.f3108h = this.e;
        } else if (i8 == 3) {
            this.e = a(14);
            int iA = a(4);
            this.f3109i = iA;
            if (this.f3118t) {
                this.f3109i = iA - this.f3119v;
            }
            this.f3110j = a(9);
            this.f3111k = a(6);
            this.q.setTextSize(this.f3110j);
            if (TextUtils.isEmpty(this.f3113m)) {
                this.f3108h = this.e;
            } else {
                if (this.f3113m.endsWith(e.ANY_NON_NULL_MARKER)) {
                    String str = this.f3113m;
                    float fMeasureText = this.q.measureText(str.substring(0, str.length() - 1));
                    this.q.setTextSize(this.f3111k);
                    float fMeasureText2 = this.q.measureText(e.ANY_NON_NULL_MARKER);
                    this.f3115o = fMeasureText2;
                    this.f3114n = fMeasureText + fMeasureText2;
                } else {
                    this.f3114n = this.q.measureText(this.f3113m);
                }
                this.f3108h = (int) (this.f3114n + (this.f3109i * 2));
            }
        } else if (i8 == 4) {
            this.e = a(16);
            int iA2 = a(4);
            int i9 = this.f3119v;
            int i10 = iA2 - i9;
            this.f3109i = i10;
            if (this.f3118t) {
                this.f3109i = i10 - i9;
            }
            this.f3110j = a(10);
            this.f3111k = a(8);
            this.q.setTextSize(this.f3110j);
            if (TextUtils.isEmpty(this.f3113m)) {
                this.f3108h = this.e;
            } else {
                if (this.f3113m.endsWith(e.ANY_NON_NULL_MARKER)) {
                    String str2 = this.f3113m;
                    float fMeasureText3 = this.q.measureText(str2.substring(0, str2.length() - 1));
                    this.q.setTextSize(this.f3111k);
                    float fMeasureText4 = this.q.measureText(e.ANY_NON_NULL_MARKER);
                    this.f3115o = fMeasureText4;
                    this.f3114n = fMeasureText3 + fMeasureText4;
                } else {
                    this.f3114n = this.q.measureText(this.f3113m);
                }
                this.f3108h = (int) (this.f3114n + (this.f3109i * 2));
            }
        } else if (i8 == 5) {
            this.e = a(20);
            int iA3 = a(4);
            this.f3109i = iA3;
            if (this.f3118t) {
                this.f3109i = iA3 - this.f3119v;
            }
            this.f3110j = a(12);
            this.f3111k = a(8);
            this.q.setTextSize(this.f3110j);
            if (TextUtils.isEmpty(this.f3113m)) {
                this.f3108h = this.e;
            } else {
                if (this.f3113m.endsWith(e.ANY_NON_NULL_MARKER)) {
                    String str3 = this.f3113m;
                    float fMeasureText5 = this.q.measureText(str3.substring(0, str3.length() - 1));
                    this.q.setTextSize(this.f3111k);
                    float fMeasureText6 = this.q.measureText(e.ANY_NON_NULL_MARKER);
                    this.f3115o = fMeasureText6;
                    this.f3114n = fMeasureText5 + fMeasureText6;
                } else {
                    this.f3114n = this.q.measureText(this.f3113m);
                }
                this.f3108h = (int) (this.f3114n + (this.f3109i * 2));
            }
        }
        this.q.setTextSize(this.f3110j);
        if (this.f3118t) {
            int i11 = this.f3108h;
            int i12 = this.f3119v;
            this.f3108h = (i12 * 2) + i11;
            this.e = (i12 * 2) + this.e;
        }
        int i13 = this.e;
        this.f3112l = i13 / 2;
        int iMax = Math.max(this.f3108h, i13);
        this.f3108h = iMax;
        this.f3117s.set(0.0f, 0.0f, iMax, this.e);
        if (this.f3118t) {
            RectF rectF = this.f3116r;
            int i14 = this.f3119v;
            rectF.set(i14, i14, this.f3108h - i14, this.e - i14);
        }
        invalidate();
        requestLayout();
    }

    public BadgeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3106c = Color.parseColor("#FFFFFF");
        this.f3107d = 0;
        this.u = context;
        this.f3116r = new RectF();
        this.f3117s = new RectF();
        Paint paint = new Paint();
        this.p = paint;
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.q = paint2;
        paint2.setAntiAlias(true);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.OSRedPointTextView);
        this.f3107d = typedArrayObtainStyledAttributes.getInt(R$styleable.OSRedPointTextView_osRedPointTextViewType, 0);
        int i8 = typedArrayObtainStyledAttributes.getInt(R$styleable.OSRedPointTextView_osRedPointTextViewNum, 0);
        this.f3113m = h0.a.g(i8, "");
        if (i8 > 99) {
            this.f3113m = "99+";
        }
        setRedPointType(this.f3107d);
        this.f3113m = this.f3113m;
        this.f3118t = typedArrayObtainStyledAttributes.getBoolean(R$styleable.OSRedPointTextView_osRedPointTextViewHaveOuterCircle, false);
        TypedArray typedArrayObtainStyledAttributes2 = this.u.obtainStyledAttributes(new int[]{R$attr.OsBgPrimary});
        this.f3104a = typedArrayObtainStyledAttributes.getColor(R$styleable.OSRedPointTextView_osRedPointTextViewBg, j.e(this.u, R$attr.os_warning_primary, R$color.os_warning_primary_hios));
        this.f3105b = typedArrayObtainStyledAttributes.getColor(R$styleable.OSRedPointTextView_osRedPointTextViewOutCircleBg, typedArrayObtainStyledAttributes2.getColor(0, this.u.getColor(R$color.os_bg_primary_color)));
        typedArrayObtainStyledAttributes2.recycle();
        typedArrayObtainStyledAttributes.recycle();
        this.f3119v = hd.a.a(this.u, 1);
        setRedPointType(this.f3107d);
    }
}
