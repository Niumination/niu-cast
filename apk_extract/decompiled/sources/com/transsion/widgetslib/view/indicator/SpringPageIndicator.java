package com.transsion.widgetslib.view.indicator;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;
import androidx.annotation.ColorInt;
import com.transsion.widgetslib.R$attr;
import com.transsion.widgetslib.R$color;
import com.transsion.widgetslib.R$dimen;
import com.transsion.widgetslib.R$styleable;
import java.util.ArrayList;
import pd.j;
import td.d;
import td.e;

/* JADX INFO: loaded from: classes2.dex */
public class SpringPageIndicator extends View {
    public final ArrayList A;
    public int B;
    public int C;
    public boolean D;
    public final Path E;
    public final Path F;
    public final Path G;
    public int H;
    public int I;
    public float J;
    public final Paint K;
    public final Scroller L;
    public final RectF M;
    public final PorterDuffXfermode N;
    public final PorterDuffXfermode O;
    public int P;
    public int Q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f3274a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3275b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3276c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f3277d;
    public final int e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f3278h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f3279i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final PointF f3280j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final PointF f3281k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final PointF f3282l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final PointF f3283m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final PointF f3284n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final PointF f3285o;
    public final PointF p;
    public final PointF q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final PointF f3286r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final PointF f3287s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final PointF f3288t;
    public final PointF u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public e f3289v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final e f3290w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public e f3291x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final e f3292y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f3293z;

    public SpringPageIndicator(Context context) {
        this(context, null);
    }

    private void setAddPath(e eVar) {
        this.G.reset();
        float f = eVar.f10215c;
        int i8 = (int) (f / 6.0f);
        int i9 = (int) ((f * 3.0f) / 4.0f);
        RectF rectF = this.M;
        float f4 = i9;
        float f10 = eVar.f10213a - f4;
        rectF.left = f10;
        float f11 = i8;
        float f12 = eVar.f10214b - f11;
        rectF.top = f12;
        float f13 = i9 * 2;
        rectF.right = f10 + f13;
        float f14 = i8 * 2;
        rectF.bottom = f12 + f14;
        Path path = this.G;
        Path.Direction direction = Path.Direction.CW;
        path.addRect(rectF, direction);
        float f15 = eVar.f10213a - f11;
        rectF.left = f15;
        float f16 = eVar.f10214b - f4;
        rectF.top = f16;
        rectF.right = f15 + f14;
        rectF.bottom = f16 + f13;
        this.G.addRect(rectF, direction);
    }

    public final void a() {
        int iB;
        ArrayList arrayList = this.A;
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int size = this.A.size();
        if (!hasWindowFocus() && (iB = b(size)) < measuredWidth) {
            measuredWidth = iB;
        }
        int i8 = this.e;
        int i9 = size - 1;
        int i10 = this.f3279i;
        int iMax = Math.max(((measuredWidth - ((i9 * i10) + (i8 * 2))) / 2) + i8, this.f3276c + i8);
        int measuredHeight = getMeasuredHeight() / 2;
        for (int i11 = 0; i11 < size; i11++) {
            e eVar = (e) this.A.get(i11);
            if (i11 == this.B) {
                eVar.f10215c = i8;
            } else {
                eVar.f10215c = this.f3277d;
            }
            if (this.f3274a) {
                eVar.f10213a = ((i9 - i11) * i10) + iMax;
            } else {
                eVar.f10213a = (i11 * i10) + iMax;
            }
            eVar.f10214b = measuredHeight;
        }
        e eVar2 = this.f3290w;
        float f = measuredHeight;
        this.f3292y.f10214b = f;
        eVar2.f10214b = f;
    }

    public final int b(int i8) {
        return Math.max((this.f3276c * 2) + getPaddingRight() + getPaddingLeft(), (this.f3276c * 2) + ((i8 - 1) * this.f3279i) + (this.e * 2) + getPaddingRight() + getPaddingLeft());
    }

    public final void c(int i8) {
        int i9;
        int i10;
        int size = this.A.size();
        int i11 = this.H;
        if (size < i11) {
            if (this.L.getCurrX() != 0) {
                this.L.startScroll(0, 0, 0, 0, 0);
                return;
            }
            return;
        }
        int i12 = this.f3279i;
        int i13 = (size - i11) * i12;
        boolean z2 = this.f3274a;
        if (z2 && size >= i11 && i8 < i11 - 1 && this.L.getCurrX() != i13) {
            this.L.startScroll(0, 0, i13, 0, 0);
            return;
        }
        int i14 = this.H;
        int i15 = i14 / 2;
        int i16 = 0;
        int i17 = z2 ? i13 : 0;
        if (i8 > i15 && i8 > i15 && (i9 = size - i14) != 0) {
            if (i9 <= i15) {
                i16 = i9 * i12;
            } else {
                if (i8 <= i14 - 1) {
                    i10 = i8 - i15;
                } else {
                    int i18 = (size - 1) - i8;
                    i10 = i18 > i15 ? (i8 - (i14 - 1)) + i15 : (i8 - (i14 - 1)) + i18;
                }
                i16 = i10 * i12;
            }
        }
        this.L.startScroll(i17, 0, (int) (z2 ? -i16 : i16), 0, 200);
    }

    @Override // android.view.View
    public final void computeScroll() {
        if (this.L.computeScrollOffset()) {
            scrollTo(this.L.getCurrX(), 0);
            invalidate();
        }
        super.computeScroll();
    }

    public final void d() {
        e eVar = this.f3289v;
        if (eVar != null) {
            eVar.f10215c = this.e;
        }
        for (int i8 = 0; i8 < this.A.size(); i8++) {
            if (i8 != this.B) {
                ((e) this.A.get(i8)).f10215c = this.f3277d;
            }
        }
        this.E.reset();
        this.F.reset();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        e eVar;
        if (this.A.size() <= 1) {
            return;
        }
        canvas.save();
        e eVar2 = null;
        this.K.setXfermode(null);
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        canvas.clipRect(scrollX, scrollY, getWidth() + scrollX, getHeight() + scrollY);
        this.K.setColor(this.P);
        int size = this.A.size();
        for (int i8 = 0; i8 < size; i8++) {
            if (i8 != this.B && (!this.D || i8 != this.C || this.F.isEmpty())) {
                try {
                    eVar = (e) this.A.get(i8);
                } catch (Exception unused) {
                    eVar = null;
                }
                if (eVar != null) {
                    canvas.drawCircle(eVar.f10213a, eVar.f10214b, eVar.f10215c, this.K);
                }
            }
        }
        if (this.D) {
            this.K.setColor(((double) this.J) < 1.0d ? this.P : this.Q);
            canvas.drawPath(this.F, this.K);
        }
        this.K.setColor(this.J < 1.0f ? this.Q : this.P);
        if (this.J < 1.0f) {
            this.K.setXfermode(this.N);
        } else {
            this.K.setXfermode(this.O);
        }
        if (this.E.isEmpty()) {
            try {
                eVar2 = (e) this.A.get(this.B);
            } catch (Exception unused2) {
            }
            if (eVar2 != null) {
                canvas.drawCircle(eVar2.f10213a, eVar2.f10214b, eVar2.f10215c, this.K);
            }
        } else {
            canvas.drawPath(this.E, this.K);
            this.E.reset();
        }
        canvas.restore();
    }

    @Override // android.view.View
    public final void onMeasure(int i8, int i9) {
        int mode = View.MeasureSpec.getMode(i8);
        int size = View.MeasureSpec.getSize(i8);
        int mode2 = View.MeasureSpec.getMode(i9);
        int size2 = View.MeasureSpec.getSize(i9);
        int i10 = this.e;
        if (mode != 1073741824) {
            int paddingRight = ((((i10 * 2) + (getPaddingRight() + (size - getPaddingLeft()))) - (this.f3276c * 2)) / this.f3279i) + 1;
            if (paddingRight > 1) {
                this.H = Math.min(paddingRight, this.I);
            }
            size = b(Math.min(this.A.size(), this.H));
        }
        if (mode2 != 1073741824) {
            int i11 = i10 * 2;
            size2 = (this.f3275b * 2) + i11 + getPaddingBottom() + getPaddingTop();
        }
        setMeasuredDimension(size, size2);
        a();
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & 255) == 0) {
            float y3 = motionEvent.getY();
            if (this.A.size() == 0 || y3 > getHeight() || y3 < 0.0f) {
                return false;
            }
            float x2 = motionEvent.getX() + getScrollX();
            boolean z2 = this.f3274a;
            int i8 = this.f3279i;
            if (z2) {
                float f = i8 / 2;
                if (x2 < ((e) a1.a.i(1, this.A)).f10213a + f) {
                    this.A.size();
                } else if (x2 <= ((e) this.A.get(0)).f10213a - f) {
                    this.A.size();
                    float f4 = ((e) a1.a.i(1, this.A)).f10213a;
                }
            } else {
                float f10 = i8 / 2;
                if (x2 >= ((e) this.A.get(0)).f10213a + f10) {
                    if (x2 > ((e) a1.a.i(1, this.A)).f10213a + f10) {
                        this.A.size();
                    } else {
                        float f11 = ((e) this.A.get(0)).f10213a;
                    }
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i8) {
        super.onVisibilityChanged(view, i8);
        if (getVisibility() == 0) {
            c(this.B);
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0080  */
    public void setCurrentMarker(int i8) {
        if (i8 < 0 || i8 >= this.A.size() || i8 == this.B) {
            return;
        }
        this.B = i8;
        this.C = i8;
        e eVar = (e) this.A.get(i8);
        this.f3289v = eVar;
        this.f3291x = eVar;
        d();
        if (this.A.size() >= this.H && (!this.f3274a || i8 != this.A.size() - 1)) {
            e eVar2 = (e) this.A.get(i8);
            float f = eVar2.f10213a - eVar2.f10215c;
            int scrollX = getScrollX();
            int i9 = this.f3279i;
            if (f <= scrollX + i9) {
                c(i8);
            } else {
                e eVar3 = (e) this.A.get(i8);
                if (eVar3.f10213a + eVar3.f10215c >= (getWidth() + getScrollX()) - i9 && (i8 < this.A.size() - 1 || getScrollX() == 0)) {
                    c(i8);
                }
            }
        }
        invalidate();
    }

    public void setMarkerClickListener(d dVar) {
    }

    public void setMaxMarkerNum(int i8) {
        this.H = i8;
        this.I = i8;
    }

    public void setNormalColor(@ColorInt int i8) {
        this.P = i8;
        invalidate();
    }

    public void setSelectedColor(@ColorInt int i8) {
        this.Q = i8;
        invalidate();
    }

    public SpringPageIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.B = 0;
        this.C = 0;
        this.D = true;
        this.I = Integer.MAX_VALUE;
        setLayerType(1, null);
        this.f3274a = j.v();
        Resources resources = context.getResources();
        this.f3277d = resources.getDimensionPixelOffset(R$dimen.os_spring_page_marker_radius);
        this.e = resources.getDimensionPixelOffset(R$dimen.os_spring_page_marker_radius);
        this.f3278h = resources.getDimensionPixelOffset(R$dimen.os_spring_page_marker_radius);
        this.f3279i = resources.getDimensionPixelOffset(R$dimen.os_spring_page_marker_distance);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.PageIndicatorWrapper);
        this.P = typedArrayObtainStyledAttributes.getColor(R$styleable.PageIndicatorWrapper_normalColor, j.d(R$attr.os_comp_color_page_default, context.getColor(R$color.os_comp_color_page_default_hios), context));
        this.Q = typedArrayObtainStyledAttributes.getColor(R$styleable.PageIndicatorWrapper_selectedColor, j.d(R$attr.os_comp_color_page_focus, context.getColor(R$color.os_comp_color_page_focus_hios), context));
        typedArrayObtainStyledAttributes.recycle();
        this.f3280j = new PointF();
        this.f3281k = new PointF();
        this.f3282l = new PointF();
        this.f3283m = new PointF();
        this.f3284n = new PointF();
        this.f3285o = new PointF();
        this.f3290w = new e();
        this.f3292y = new e();
        this.p = new PointF();
        this.q = new PointF();
        this.f3286r = new PointF();
        this.f3287s = new PointF();
        this.f3288t = new PointF();
        this.u = new PointF();
        this.E = new Path();
        this.F = new Path();
        new Path();
        this.G = new Path();
        this.M = new RectF();
        new PointF();
        new PointF();
        new PointF();
        this.N = new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER);
        this.O = new PorterDuffXfermode(PorterDuff.Mode.DST_OVER);
        this.A = new ArrayList();
        Paint paint = new Paint();
        this.K = paint;
        paint.setStyle(Paint.Style.FILL);
        this.K.setAntiAlias(true);
        setBackground(null);
        this.L = new Scroller(getContext());
        int iA = hd.a.a(getContext(), 2);
        this.f3276c = iA;
        this.f3275b = iA;
    }
}
