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
import com.transsion.widgetslib.R$styleable;
import vj.e;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class RedPointView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3187a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3188b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3189c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3190d;
    public int e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f3191h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f3192i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f3193j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f3194k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f3195l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f3196m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f3197n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Paint f3198o;
    public final Paint p;
    public final RectF q;

    public RedPointView(Context context) {
        this(context, null);
    }

    public static int a(int i8) {
        return (int) TypedValue.applyDimension(1, i8, Resources.getSystem().getDisplayMetrics());
    }

    public int getBackgroundColor() {
        return this.f3187a;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = this.q;
        int i8 = this.f3194k;
        canvas.drawRoundRect(rectF, i8, i8, this.f3198o);
        if (TextUtils.isEmpty(this.f3195l)) {
            return;
        }
        Paint.FontMetrics fontMetrics = this.p.getFontMetrics();
        float f = fontMetrics.bottom;
        int i9 = (int) ((this.f3190d / 2) + (((f - fontMetrics.top) / 2.0f) - f));
        int i10 = (int) ((this.e - this.f3196m) / 2.0f);
        if (this.f3189c != 5 || !this.f3195l.contains(e.ANY_NON_NULL_MARKER)) {
            canvas.drawText(this.f3195l, i10, i9, this.p);
            return;
        }
        String str = this.f3195l;
        float f4 = i10;
        canvas.drawText(str.substring(0, str.length() - 1), f4, i9, this.p);
        this.p.setTextSize(this.f3193j);
        Paint.FontMetrics fontMetrics2 = this.p.getFontMetrics();
        float f10 = fontMetrics2.bottom;
        canvas.drawText(e.ANY_NON_NULL_MARKER, (this.f3196m - this.f3197n) + f4, (int) ((this.f3190d / 2) + (((f10 - fontMetrics2.top) / 2.0f) - f10)), this.p);
        this.p.setTextSize(this.f3192i);
    }

    @Override // android.view.View
    public final void onMeasure(int i8, int i9) {
        super.onMeasure(i8, i9);
        setMeasuredDimension(this.e, this.f3190d);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i8) {
        this.f3187a = i8;
        setRedPointType(this.f3189c);
    }

    public void setRedPointType(int i8) {
        this.f3198o.setColor(this.f3187a);
        this.p.setColor(this.f3188b);
        this.f3189c = i8;
        if (i8 == 0) {
            this.f3190d = a(6);
            this.f3191h = a(0);
            this.f3192i = a(0);
            this.e = this.f3190d;
        } else if (i8 == 1) {
            this.f3190d = a(8);
            this.f3191h = a(0);
            this.f3192i = a(0);
            this.e = this.f3190d;
        } else if (i8 == 2) {
            this.f3190d = a(12);
            this.f3191h = a(0);
            this.f3192i = a(0);
            this.e = this.f3190d;
        } else if (i8 == 3) {
            this.f3190d = a(14);
            this.f3191h = a(3);
            this.f3192i = a(9);
            this.f3193j = a(6);
            this.p.setTextSize(this.f3192i);
            if (TextUtils.isEmpty(this.f3195l)) {
                this.e = this.f3190d;
            } else {
                float fMeasureText = this.p.measureText(this.f3195l);
                this.f3196m = fMeasureText;
                this.e = (int) (fMeasureText + (this.f3191h * 2));
            }
        } else if (i8 == 4) {
            this.f3190d = a(19);
            this.f3191h = a(4);
            int iA = a(12);
            this.f3192i = iA;
            this.p.setTextSize(iA);
            if (TextUtils.isEmpty(this.f3195l)) {
                this.e = this.f3190d;
            } else {
                float fMeasureText2 = this.p.measureText(this.f3195l);
                this.f3196m = fMeasureText2;
                this.e = (int) (fMeasureText2 + (this.f3191h * 2));
            }
        } else if (i8 == 5) {
            this.f3190d = a(20);
            this.f3191h = a(3);
            this.f3192i = a(12);
            this.f3193j = a(9);
            this.p.setTextSize(this.f3192i);
            if (TextUtils.isEmpty(this.f3195l)) {
                this.e = this.f3190d;
            } else {
                if (this.f3195l.endsWith(e.ANY_NON_NULL_MARKER)) {
                    String str = this.f3195l;
                    float fMeasureText3 = this.p.measureText(str.substring(0, str.length() - 1));
                    this.p.setTextSize(a(9));
                    float fMeasureText4 = this.p.measureText(e.ANY_NON_NULL_MARKER);
                    this.f3197n = fMeasureText4;
                    this.f3196m = fMeasureText3 + fMeasureText4;
                } else {
                    this.f3196m = this.p.measureText(this.f3195l);
                }
                this.e = (int) (this.f3196m + (this.f3191h * 2));
            }
        }
        this.f3194k = this.f3190d / 2;
        this.p.setTextSize(this.f3192i);
        int iMax = Math.max(this.e, this.f3190d);
        this.e = iMax;
        RectF rectF = this.q;
        rectF.left = 0.0f;
        rectF.top = 0.0f;
        rectF.right = iMax;
        rectF.bottom = this.f3190d;
        invalidate();
    }

    public RedPointView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3187a = Color.parseColor("#FB2C2F");
        this.f3188b = Color.parseColor("#FFFFFF");
        this.f3189c = 0;
        this.q = new RectF(0.0f, 0.0f, this.e, this.f3190d);
        Paint paint = new Paint();
        this.f3198o = paint;
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.p = paint2;
        paint2.setAntiAlias(true);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.OSRedPointTextView);
        this.f3189c = typedArrayObtainStyledAttributes.getInt(R$styleable.OSRedPointTextView_osRedPointTextViewType, 0);
        int i8 = typedArrayObtainStyledAttributes.getInt(R$styleable.OSRedPointTextView_osRedPointTextViewNum, 0);
        this.f3195l = h0.a.g(i8, "");
        int i9 = this.f3189c;
        if ((i9 == 5 || i9 == 3) && i8 > 99) {
            this.f3195l = "99+";
        }
        setRedPointType(i9);
        this.f3195l = this.f3195l;
        typedArrayObtainStyledAttributes.recycle();
        setRedPointType(this.f3189c);
    }
}
