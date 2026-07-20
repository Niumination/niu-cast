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
import ps.d;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class RedPointView extends View {
    public static final String H = "RedPointView";
    public static final int I = 0;
    public static final int J = 1;
    public static final int K = 2;
    public static final int L = 3;
    public static final int M = 4;
    public static final int N = 5;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2414b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2415c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2416d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2417e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2418f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f2419g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f2420i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f2421n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f2422p;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f2423v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f2424w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Paint f2425x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Paint f2426y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public RectF f2427z;

    public RedPointView(Context context) {
        this(context, null);
    }

    public static int a(int i10) {
        return (int) TypedValue.applyDimension(1, i10, Resources.getSystem().getDisplayMetrics());
    }

    public final void b(@NonNull Context context, AttributeSet attributeSet) {
        this.f2427z = new RectF(0.0f, 0.0f, this.f2417e, this.f2416d);
        Paint paint = new Paint();
        this.f2425x = paint;
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f2426y = paint2;
        paint2.setAntiAlias(true);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.OSRedPointTextView);
        this.f2415c = typedArrayObtainStyledAttributes.getInt(R.styleable.OSRedPointTextView_osRedPointTextViewType, 0);
        this.f2422p = c(typedArrayObtainStyledAttributes.getInt(R.styleable.OSRedPointTextView_osRedPointTextViewNum, 0));
        typedArrayObtainStyledAttributes.recycle();
        setRedPointType(this.f2415c);
    }

    public String c(int i10) {
        this.f2422p = i10 + "";
        int i11 = this.f2415c;
        if ((i11 == 5 || i11 == 3) && i10 > 99) {
            this.f2422p = "99+";
        }
        setRedPointType(i11);
        return this.f2422p;
    }

    public int getBackgroundColor() {
        return this.f2413a;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = this.f2427z;
        int i10 = this.f2421n;
        canvas.drawRoundRect(rectF, i10, i10, this.f2425x);
        if (TextUtils.isEmpty(this.f2422p)) {
            return;
        }
        Paint.FontMetrics fontMetrics = this.f2426y.getFontMetrics();
        float f10 = fontMetrics.bottom;
        int i11 = (int) ((this.f2416d / 2) + (((f10 - fontMetrics.top) / 2.0f) - f10));
        int i12 = (int) ((this.f2417e - this.f2423v) / 2.0f);
        if (this.f2415c != 5 || !this.f2422p.contains(d.ANY_NON_NULL_MARKER)) {
            canvas.drawText(this.f2422p, i12, i11, this.f2426y);
            return;
        }
        float f11 = i12;
        canvas.drawText(b.a(this.f2422p, 1, 0), f11, i11, this.f2426y);
        this.f2426y.setTextSize(this.f2420i);
        Paint.FontMetrics fontMetrics2 = this.f2426y.getFontMetrics();
        float f12 = fontMetrics2.bottom;
        canvas.drawText(d.ANY_NON_NULL_MARKER, (this.f2423v - this.f2424w) + f11, (int) ((this.f2416d / 2) + (((f12 - fontMetrics2.top) / 2.0f) - f12)), this.f2426y);
        this.f2426y.setTextSize(this.f2419g);
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        setMeasuredDimension(this.f2417e, this.f2416d);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i10) {
        this.f2413a = i10;
        setRedPointType(this.f2415c);
    }

    public void setRedPointType(int i10) {
        this.f2425x.setColor(this.f2413a);
        this.f2426y.setColor(this.f2414b);
        this.f2415c = i10;
        if (i10 == 0) {
            this.f2416d = a(6);
            this.f2418f = a(0);
            this.f2419g = a(0);
            this.f2417e = this.f2416d;
        } else if (i10 == 1) {
            this.f2416d = a(8);
            this.f2418f = a(0);
            this.f2419g = a(0);
            this.f2417e = this.f2416d;
        } else if (i10 == 2) {
            this.f2416d = a(12);
            this.f2418f = a(0);
            this.f2419g = a(0);
            this.f2417e = this.f2416d;
        } else if (i10 == 3) {
            this.f2416d = a(14);
            this.f2418f = a(3);
            this.f2419g = a(9);
            this.f2420i = a(6);
            this.f2426y.setTextSize(this.f2419g);
            if (TextUtils.isEmpty(this.f2422p)) {
                this.f2417e = this.f2416d;
            } else {
                float fMeasureText = this.f2426y.measureText(this.f2422p);
                this.f2423v = fMeasureText;
                this.f2417e = (int) (fMeasureText + (this.f2418f * 2));
            }
        } else if (i10 == 4) {
            this.f2416d = a(19);
            this.f2418f = a(4);
            int iA = a(12);
            this.f2419g = iA;
            this.f2426y.setTextSize(iA);
            if (TextUtils.isEmpty(this.f2422p)) {
                this.f2417e = this.f2416d;
            } else {
                float fMeasureText2 = this.f2426y.measureText(this.f2422p);
                this.f2423v = fMeasureText2;
                this.f2417e = (int) (fMeasureText2 + (this.f2418f * 2));
            }
        } else if (i10 == 5) {
            this.f2416d = a(20);
            this.f2418f = a(3);
            this.f2419g = a(12);
            this.f2420i = a(9);
            this.f2426y.setTextSize(this.f2419g);
            if (TextUtils.isEmpty(this.f2422p)) {
                this.f2417e = this.f2416d;
            } else {
                if (this.f2422p.endsWith(d.ANY_NON_NULL_MARKER)) {
                    float fMeasureText3 = this.f2426y.measureText(b.a(this.f2422p, 1, 0));
                    this.f2426y.setTextSize(a(9));
                    float fMeasureText4 = this.f2426y.measureText(d.ANY_NON_NULL_MARKER);
                    this.f2424w = fMeasureText4;
                    this.f2423v = fMeasureText3 + fMeasureText4;
                } else {
                    this.f2423v = this.f2426y.measureText(this.f2422p);
                }
                this.f2417e = (int) (this.f2423v + (this.f2418f * 2));
            }
        }
        this.f2421n = this.f2416d / 2;
        this.f2426y.setTextSize(this.f2419g);
        int iMax = Math.max(this.f2417e, this.f2416d);
        this.f2417e = iMax;
        RectF rectF = this.f2427z;
        rectF.left = 0.0f;
        rectF.top = 0.0f;
        rectF.right = iMax;
        rectF.bottom = this.f2416d;
        invalidate();
    }

    public RedPointView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2413a = Color.parseColor("#FB2C2F");
        this.f2414b = Color.parseColor("#FFFFFF");
        this.f2415c = 0;
        b(context, attributeSet);
    }
}
