package com.transsion.widgetslib.view.letter;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Handler;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import com.transsion.widgetslib.R$dimen;
import com.transsion.widgetslib.R$styleable;
import io.github.inflationx.calligraphy3.HasTypeface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import k3.z8;
import m.c;
import pd.j;
import r2.w;
import vd.a;
import vd.b;

/* JADX INFO: loaded from: classes2.dex */
public class LetterSelectorLayout extends FrameLayout implements HasTypeface {
    public static final List g0 = Arrays.asList("☆", "#", "…", "♤", "☆", "Λ");

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final String f3294h0 = "LetterSelectorLayout";
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public final int G;
    public final int H;
    public final int I;
    public final boolean J;
    public final RectF K;
    public final RectF L;
    public final RectF M;
    public final ArrayMap N;
    public final RectF O;
    public final RectF P;
    public final ArrayList Q;
    public String R;
    public int S;
    public final ArrayList T;
    public boolean U;
    public boolean V;
    public final boolean W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ValueAnimator f3295a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public final int f3296a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ValueAnimator f3297b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public int f3298b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ValueAnimator f3299c;
    public float c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public w f3300d;
    public float d0;
    public c e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public int f3301e0;
    public boolean f0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f3302h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f3303i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f3304j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f3305k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f3306l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Paint f3307m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Paint f3308n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Paint f3309o;
    public final Paint p;
    public final Paint q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Paint f3310r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f3311s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f3312t;
    public float u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f3313v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final boolean f3314w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final ArrayList f3315x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final List f3316y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f3317z;

    public LetterSelectorLayout(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        new DecelerateInterpolator();
        this.f3307m = new Paint(1);
        this.f3308n = new Paint(1);
        this.f3309o = new Paint(1);
        this.p = new Paint(1);
        this.q = new Paint(1);
        this.f3310r = new Paint(1);
        this.f3313v = false;
        this.f3314w = true;
        this.f3315x = new ArrayList();
        this.f3316y = Arrays.asList(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "X", "Y", "Z");
        this.G = -16731411;
        this.H = -1;
        this.I = -8750470;
        this.J = true;
        this.K = new RectF();
        this.L = new RectF();
        this.M = new RectF();
        this.N = new ArrayMap();
        this.O = new RectF();
        this.P = new RectF();
        this.Q = new ArrayList();
        this.S = -1;
        this.T = new ArrayList();
        this.V = true;
        this.W = true;
        this.f3296a0 = 1000;
        new Paint();
        new Rect();
        this.f0 = false;
        d(context, attributeSet);
    }

    public final void a() {
        if (getHandler() != null) {
            getHandler().removeCallbacks(this.f3300d);
        }
        ValueAnimator valueAnimator = this.f3295a;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f3295a.cancel();
        }
        ValueAnimator valueAnimator2 = this.f3297b;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            this.f3297b.cancel();
        }
        ValueAnimator valueAnimator3 = this.f3299c;
        if (valueAnimator3 == null || !valueAnimator3.isRunning()) {
            return;
        }
        this.f3299c.cancel();
    }

    public final int b(int i8) {
        return (int) TypedValue.applyDimension(1, i8, getResources().getDisplayMetrics());
    }

    public final void c(RectF rectF, vd.c cVar) {
        ArrayList arrayList = this.T;
        int iIndexOf = arrayList.indexOf(cVar);
        ArrayList arrayList2 = this.Q;
        int iIndexOf2 = arrayList2.indexOf(rectF);
        if (this.U) {
            int size = arrayList2.size();
            int size2 = arrayList.size();
            ArrayMap arrayMap = this.N;
            int i8 = 0;
            if (iIndexOf2 == 0 && iIndexOf > 0) {
                int i9 = iIndexOf - 1;
                int i10 = 0;
                for (int i11 = i9; i11 < i9 + size; i11++) {
                    if (i10 < size && i11 < size2) {
                        arrayMap.put((RectF) arrayList2.get(i10), (vd.c) arrayList.get(i11));
                    }
                    i10++;
                }
            }
            if (iIndexOf2 == size - 1 && iIndexOf < size2 - 1) {
                int iIndexOf3 = arrayList.indexOf(arrayMap.get(arrayList2.get(0))) + 1;
                for (int i12 = iIndexOf3; i12 < size + iIndexOf3; i12++) {
                    if (i8 < size && i12 < size2) {
                        arrayMap.put((RectF) arrayList2.get(i8), (vd.c) arrayList.get(i12));
                    }
                    i8++;
                }
            }
        }
        this.f3301e0 = iIndexOf2;
    }

    public final void d(Context context, AttributeSet attributeSet) {
        setWillNotDraw(false);
        setClickable(true);
        this.d0 = getContext().getResources().getDimensionPixelOffset(R$dimen.os_letter_panel_height_gap);
        this.B = context.getResources().getDimensionPixelSize(R$dimen.os_letter_top_padding);
        this.C = context.getResources().getDimensionPixelSize(R$dimen.os_letter_bottom_padding);
        this.D = context.getResources().getDimensionPixelSize(R$dimen.os_letter_padding);
        this.f3311s = getContext().getResources().getDimensionPixelSize(R$dimen.os_letter_size);
        this.f3312t = getContext().getResources().getDimensionPixelSize(R$dimen.os_letter_max_size);
        this.u = getContext().getResources().getDimensionPixelSize(R$dimen.os_letter_indicator_size);
        this.f3317z = getContext().getResources().getDimensionPixelOffset(R$dimen.letter_indicator_radius);
        this.A = b(24);
        float f = this.f3311s;
        Paint paint = this.f3307m;
        paint.setTextSize(f);
        paint.setColor(0);
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        float f4 = this.f3312t;
        Paint paint2 = this.f3308n;
        paint2.setTextSize(f4);
        paint2.setColor(0);
        int i8 = this.I;
        Paint paint3 = this.f3310r;
        paint3.setColor(i8);
        paint3.setTextSize(this.f3311s);
        int i9 = this.H;
        Paint paint4 = this.q;
        paint4.setColor(i9);
        paint4.setTextSize(this.u);
        int i10 = this.G;
        Paint paint5 = this.p;
        paint5.setColor(i10);
        paint5.setStyle(style);
        b(64);
        float f10 = this.f3311s;
        Paint paint6 = this.f3309o;
        paint6.setTextSize(f10);
        paint6.setTextSize(this.f3312t);
        paint6.setTextSize(this.u);
        if (this.f3295a == null) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 200.0f);
            this.f3295a = valueAnimatorOfFloat;
            valueAnimatorOfFloat.setDuration(200L);
            this.f3295a.addUpdateListener(new a(this, 0));
            this.f3295a.addListener(new b(this, 0));
            this.f3295a.setInterpolator(new ie.a(0.2f, 0.1f));
        }
        if (this.f3297b == null) {
            ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 200.0f);
            this.f3297b = valueAnimatorOfFloat2;
            valueAnimatorOfFloat2.setDuration(200L);
            this.f3297b.addUpdateListener(new a(this, 1));
            this.f3297b.addListener(new b(this, 1));
            this.f3297b.setInterpolator(new ie.a(0.4f, 1.0f));
            this.f3300d = new w(this, 2);
            this.e = new c(this, 17);
        }
        if (this.f3299c == null) {
            ValueAnimator valueAnimatorOfFloat3 = ValueAnimator.ofFloat(0.0f, 100.0f);
            this.f3299c = valueAnimatorOfFloat3;
            valueAnimatorOfFloat3.setDuration(150L);
            this.f3299c.addUpdateListener(new a(this, 2));
            this.f3299c.setInterpolator(new ie.a(0.4f, 1.0f));
        }
        b(3);
        this.c0 = b(14);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.OSLetterSelectorLayout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i11);
                if (index == R$styleable.OSLetterSelectorLayout_os_letter_slide_outside) {
                    this.f3305k = typedArrayObtainStyledAttributes.getBoolean(index, false);
                } else if (index == R$styleable.OSLetterSelectorLayout_os_letter_fixed_width) {
                    this.f3306l = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.V) {
            ArrayList arrayList = this.Q;
            if (arrayList.size() <= 0) {
                return;
            }
            canvas.save();
            canvas.clipRect(this.P);
            for (int i8 = 0; i8 < arrayList.size(); i8++) {
            }
            canvas.restore();
            if (TextUtils.isEmpty(this.R) || !this.f3303i) {
                return;
            }
            canvas.save();
            int i9 = this.f3302h;
            Paint paint = this.q;
            paint.setAlpha(i9);
            int i10 = this.f3302h;
            Paint paint2 = this.p;
            paint2.setAlpha(i10);
            RectF rectF = this.K;
            canvas.drawCircle(rectF.centerX(), rectF.centerY(), this.f3317z, paint2);
            canvas.save();
            paint.measureText(this.R);
            throw null;
        }
    }

    public final boolean e(float f, float f4) {
        return this.T.size() != 0 && this.Q.size() != 0 && this.J && this.O.contains(f, f4);
    }

    public int getAllLetterMaxHeight() {
        return 0;
    }

    public int getPanelWidth() {
        return this.f3298b0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.N.clear();
        this.Q.clear();
        this.T.clear();
        Handler handler = getHandler();
        if (handler.hasCallbacks(this.e)) {
            handler.removeCallbacks(this.e);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.T.size() == 0 || !this.V) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() != 0 || !e(motionEvent.getX(), motionEvent.getY())) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        requestDisallowInterceptTouchEvent(true);
        return true;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i8, int i9, int i10, int i11) {
        int i12;
        int i13;
        super.onSizeChanged(i8, i9, i10, i11);
        this.E = i8;
        this.F = i9;
        ArrayList arrayList = this.f3315x;
        if (arrayList != null && arrayList.size() != 0) {
            int width = getWidth();
            int height = getHeight();
            if (width != 0 && height != 0) {
                if (this.E != width) {
                    this.E = width;
                }
                if (this.F != height) {
                    this.F = height;
                }
                ArrayMap arrayMap = this.N;
                arrayMap.clear();
                ArrayList arrayList2 = this.Q;
                arrayList2.clear();
                ArrayList arrayList3 = this.T;
                arrayList3.clear();
                boolean z2 = getLayoutDirection() == 1;
                boolean z3 = this.f3314w;
                this.f3313v = (z2 && z3) || !(z2 || z3);
                int size = arrayList.size();
                for (int i14 = 0; i14 < size; i14++) {
                    if (!TextUtils.isEmpty((String) arrayList.get(i14))) {
                        throw null;
                    }
                }
                int i15 = this.B;
                RectF rectF = new RectF();
                rectF.top = i15;
                if (j.o(getContext())) {
                    int iA = this.f3306l;
                    if (iA == 0) {
                        iA = hd.a.a(getContext(), 8) + (this.D * 2) + ((int) 0.0f);
                    }
                    this.f3298b0 = iA;
                } else {
                    int i16 = this.f3306l;
                    if (i16 == 0) {
                        i16 = ((int) 0.0f) + (this.D * 2);
                    }
                    this.f3298b0 = i16;
                }
                float fMax = Math.max(this.c0, getAllLetterMaxHeight() + this.d0);
                this.c0 = fMax;
                rectF.bottom = rectF.top + fMax;
                if (this.f3313v) {
                    rectF.left = 0.0f;
                    if (j.o(getContext())) {
                        rectF.left = hd.a.a(getContext(), 4);
                    }
                    rectF.right = rectF.left + this.f3298b0;
                } else {
                    rectF.right = this.E;
                    if (j.o(getContext())) {
                        rectF.right = this.E - hd.a.a(getContext(), 4);
                    }
                    rectF.left = rectF.right - this.f3298b0;
                }
                float fHeight = rectF.height();
                if (fHeight != 0.0f) {
                    boolean z5 = this.W;
                    if (z5) {
                        this.C = 0;
                        i15 = 0;
                    }
                    int i17 = this.F;
                    float f = (i17 - i15) - this.C;
                    int i18 = z5 ? ((int) (f / fHeight)) - 2 : (int) (f / fHeight);
                    if (i18 >= 1) {
                        boolean z10 = size > i18;
                        this.U = z10;
                        if (!z10) {
                            i18 = size;
                        }
                        if (z5) {
                            int i19 = (int) ((i17 - (i18 * fHeight)) / 2.0f);
                            if (i19 < 0) {
                                i19 = 0;
                            }
                            this.C = i19;
                            float f4 = i19;
                            rectF.top = f4;
                            rectF.bottom = f4 + fHeight;
                        }
                        RectF rectF2 = this.O;
                        rectF2.set(rectF);
                        String str = "mIsOverUnits: " + this.U + ", mSelectedRectIndex: " + this.f3301e0 + ", paintLen: " + i18;
                        String str2 = f3294h0;
                        z8.b(str2, str);
                        boolean z11 = this.f3301e0 >= i18;
                        if (this.U) {
                            if (z11) {
                                this.f3301e0 = i18 - 1;
                            }
                            if (TextUtils.isEmpty(this.R) || !arrayList.contains(this.R) || (i13 = this.S) <= -1) {
                                i13 = -1;
                                i12 = 0;
                            } else {
                                i12 = i13 - this.f3301e0;
                            }
                            z8.b(str2, "noSpaceShowSelectedRect: " + z11 + ", topLetterIndex: " + i12 + ", mSelectedRectIndex: " + this.f3301e0 + ", mSelectedLetter: " + this.R + ", indexSelectedLetter: " + i13);
                        } else {
                            i12 = 0;
                        }
                        for (int i20 = 0; i20 < i18; i20++) {
                            RectF rectF3 = new RectF(rectF.left, rectF.top, rectF.right, rectF.bottom);
                            arrayList2.add(rectF3);
                            float f10 = rectF.bottom;
                            rectF.top = f10;
                            rectF.bottom = f10 + fHeight;
                            int i21 = i20 + i12;
                            if (i21 > -1 && i21 < size) {
                                arrayMap.put(rectF3, (vd.c) arrayList3.get(i21));
                            }
                        }
                        RectF rectF4 = this.M;
                        float f11 = rectF.left;
                        float f12 = rectF.top;
                        float f13 = fHeight * 2.0f;
                        rectF4.set(f11, f12, rectF.right, f12 + f13);
                        rectF2.bottom = rectF4.bottom;
                        RectF rectF5 = this.L;
                        float f14 = rectF.left;
                        float f15 = rectF2.top;
                        rectF5.set(f14, f15 - f13, rectF.right, f15);
                        rectF2.top = rectF5.top;
                        RectF rectF6 = this.P;
                        rectF6.set(rectF2);
                        int iWidth = this.f3306l;
                        if (iWidth == 0) {
                            iWidth = (int) rectF6.width();
                        }
                        this.f3298b0 = iWidth;
                        if (arrayList2.size() > 0) {
                            int dimensionPixelOffset = getResources().getDimensionPixelOffset(R$dimen.os_letter_bubble_size);
                            float f16 = this.f3298b0 + this.A;
                            if (!this.f3313v) {
                                f16 = (this.E - f16) - dimensionPixelOffset;
                            }
                            float f17 = dimensionPixelOffset;
                            this.K.set(f16, 0.0f, f16 + f17, f17);
                        }
                    }
                }
            }
        }
        invalidate();
    }

    /* JADX WARN: Code duplicated, block: B:50:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:61:0x00c6  */
    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        ValueAnimator valueAnimator;
        ValueAnimator valueAnimator2;
        if ((this.T.size() == 0 || !this.V) || !this.V) {
            if (this.f0) {
                this.f0 = false;
            }
            return super.onTouchEvent(motionEvent);
        }
        float x2 = motionEvent.getX();
        float y3 = motionEvent.getY();
        if (motionEvent.getAction() == 0 && !e(x2, y3)) {
            return false;
        }
        int action = motionEvent.getAction();
        ArrayList<RectF> arrayList = this.Q;
        ArrayMap arrayMap = this.N;
        if (action == 0) {
            requestDisallowInterceptTouchEvent(true);
            this.f0 = true;
            for (RectF rectF : arrayList) {
                if (rectF.contains(x2, y3)) {
                }
            }
        } else if (action == 1) {
            this.f0 = false;
            valueAnimator = this.f3295a;
            if ((valueAnimator != null || !valueAnimator.isRunning()) && (valueAnimator2 = this.f3297b) != null && !valueAnimator2.isRunning()) {
                a();
                if (getHandler() != null && this.f3303i) {
                    getHandler().postDelayed(this.f3300d, this.f3296a0);
                }
            }
        } else if (action == 2) {
            if (!this.O.contains(x2, y3)) {
                if (!this.f3305k) {
                    return true;
                }
                if (arrayList != null && !arrayList.isEmpty()) {
                    x2 = ((RectF) arrayList.get(0)).left;
                }
            }
            this.f0 = true;
            boolean zContains = this.L.contains(x2, y3);
            boolean zContains2 = this.M.contains(x2, y3);
            if (zContains || zContains2) {
                return true;
            }
            for (RectF rectF2 : arrayList) {
                if (rectF2.contains(x2, y3)) {
                }
            }
        } else if (action == 3) {
            this.f0 = false;
            valueAnimator = this.f3295a;
            if (valueAnimator != null) {
                a();
                if (getHandler() != null) {
                    getHandler().postDelayed(this.f3300d, this.f3296a0);
                }
            } else {
                a();
                if (getHandler() != null) {
                    getHandler().postDelayed(this.f3300d, this.f3296a0);
                }
            }
        }
        return true;
    }

    @Override // android.view.View
    public final void onVisibilityAggregated(boolean z2) {
        super.onVisibilityAggregated(z2);
        if (getHandler() != null && this.f3300d != null) {
            getHandler().removeCallbacks(this.f3300d);
        }
        a();
        this.f3303i = false;
    }

    public void setSelectedLetter(String str) {
        ArrayList arrayList = this.f3315x;
        if (arrayList == null || str == null || str.equals(this.R)) {
            return;
        }
        setSelectedLetter(arrayList.indexOf(str));
    }

    public void setShowSelector(boolean z2) {
        this.V = z2;
    }

    public void setSlideOutside(boolean z2) {
        this.f3305k = z2;
    }

    @Override // io.github.inflationx.calligraphy3.HasTypeface
    public void setTypeface(Typeface typeface) {
        Paint paint = this.f3307m;
        if (paint != null) {
            paint.setTypeface(typeface);
        }
        Paint paint2 = this.f3308n;
        if (paint2 != null) {
            paint2.setTypeface(typeface);
        }
        Paint paint3 = this.f3309o;
        if (paint3 != null) {
            paint3.setTypeface(typeface);
        }
        Paint paint4 = this.p;
        if (paint4 != null) {
            paint4.setTypeface(typeface);
        }
        Paint paint5 = this.q;
        if (paint5 != null) {
            paint5.setTypeface(typeface);
        }
        Paint paint6 = this.f3310r;
        if (paint6 != null) {
            paint6.setTypeface(typeface);
        }
    }

    public void setVibrateAble(boolean z2) {
    }

    public void setSelectedLetter(int i8) {
        String str;
        ArrayMap arrayMap;
        ArrayList arrayList = this.f3315x;
        if (arrayList == null || i8 < 0 || i8 >= arrayList.size() || (str = (String) arrayList.get(i8)) == null || str.equals(this.R)) {
            return;
        }
        if (this.U) {
            if (!TextUtils.isEmpty(str) && i8 >= 0) {
                ArrayList arrayList2 = this.Q;
                Iterator it = arrayList2.iterator();
                while (true) {
                    boolean zHasNext = it.hasNext();
                    arrayMap = this.N;
                    if (!zHasNext) {
                        break;
                    }
                }
                ArrayList arrayList3 = this.T;
                int size = arrayList3.size();
                int size2 = arrayList2.size();
                if (this.S < i8) {
                    int i9 = size2 - 1;
                    int i10 = i8;
                    for (int i11 = i9; i10 >= 0 && i10 < size && i11 >= 0; i11--) {
                        arrayMap.put((RectF) arrayList2.get(i11), (vd.c) arrayList3.get(i10));
                        i10--;
                    }
                    this.f3301e0 = i9;
                } else {
                    int i12 = 0;
                    for (int i13 = i8; i12 < size2 && i13 < size; i13++) {
                        arrayMap.put((RectF) arrayList2.get(i12), (vd.c) arrayList3.get(i13));
                        i12++;
                    }
                    this.f3301e0 = 0;
                }
            }
        } else {
            this.f3301e0 = i8;
        }
        this.R = str;
        this.S = i8;
        invalidate();
    }

    public LetterSelectorLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        new DecelerateInterpolator();
        this.f3307m = new Paint(1);
        this.f3308n = new Paint(1);
        this.f3309o = new Paint(1);
        this.p = new Paint(1);
        this.q = new Paint(1);
        this.f3310r = new Paint(1);
        this.f3313v = false;
        this.f3314w = true;
        this.f3315x = new ArrayList();
        this.f3316y = Arrays.asList(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "X", "Y", "Z");
        this.G = -16731411;
        this.H = -1;
        this.I = -8750470;
        this.J = true;
        this.K = new RectF();
        this.L = new RectF();
        this.M = new RectF();
        this.N = new ArrayMap();
        this.O = new RectF();
        this.P = new RectF();
        this.Q = new ArrayList();
        this.S = -1;
        this.T = new ArrayList();
        this.V = true;
        this.W = true;
        this.f3296a0 = 1000;
        new Paint();
        new Rect();
        this.f0 = false;
        d(context, attributeSet);
    }

    public LetterSelectorLayout(Context context) {
        super(context);
        new DecelerateInterpolator();
        this.f3307m = new Paint(1);
        this.f3308n = new Paint(1);
        this.f3309o = new Paint(1);
        this.p = new Paint(1);
        this.q = new Paint(1);
        this.f3310r = new Paint(1);
        this.f3313v = false;
        this.f3314w = true;
        this.f3315x = new ArrayList();
        this.f3316y = Arrays.asList(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "X", "Y", "Z");
        this.G = -16731411;
        this.H = -1;
        this.I = -8750470;
        this.J = true;
        this.K = new RectF();
        this.L = new RectF();
        this.M = new RectF();
        this.N = new ArrayMap();
        this.O = new RectF();
        this.P = new RectF();
        this.Q = new ArrayList();
        this.S = -1;
        this.T = new ArrayList();
        this.V = true;
        this.W = true;
        this.f3296a0 = 1000;
        new Paint();
        new Rect();
        this.f0 = false;
        d(context, null);
    }
}
