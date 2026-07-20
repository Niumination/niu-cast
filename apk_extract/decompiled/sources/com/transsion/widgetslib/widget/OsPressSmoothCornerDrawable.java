package com.transsion.widgetslib.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.transsion.widgetslib.R$attr;
import com.transsion.widgetslib.R$color;
import pd.j;
import zd.t;

/* JADX INFO: loaded from: classes2.dex */
public class OsPressSmoothCornerDrawable extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f3425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f3426b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ViewPropertyAnimator f3427c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f3428d;
    public float e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f3429h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f3430i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f3431j;

    public OsPressSmoothCornerDrawable(Context context) {
        this(context, null);
    }

    public final void a() {
        ViewPropertyAnimator viewPropertyAnimator = this.f3427c;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            this.f3427c = null;
        }
        if (getAlpha() - 0.0f > 0.001f) {
            setAlpha(1.0f);
        }
        this.f3427c = animate().alpha(0.0f).setDuration(200L).withEndAction(new t(this, 1));
    }

    public final void b() {
        ViewPropertyAnimator viewPropertyAnimator = this.f3427c;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            this.f3427c = null;
        }
        this.f3427c = animate().alpha(1.0f).setDuration(100L).withEndAction(new t(this, 0));
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        super.draw(canvas);
        boolean z2 = this.f3428d;
        RectF rectF = this.f3426b;
        if (!z2) {
            int height = getHeight();
            int i8 = this.f3429h;
            int i9 = height - i8;
            rectF.set(this.f3431j, i8, getWidth() - this.f3431j, i9);
            float f = i9 - (i8 >> 1);
            canvas.drawRoundRect(rectF, f, f, this.f3425a);
            return;
        }
        int measuredHeight = getMeasuredHeight();
        int i10 = this.f3430i;
        int i11 = measuredHeight - i10;
        int measuredWidth = getMeasuredWidth() - i10;
        float f4 = i10;
        rectF.set(f4, f4, measuredWidth, i11);
        float f10 = this.e;
        canvas.drawRoundRect(rectF, f10, f10, this.f3425a);
    }

    public void setBackgroundLeftRightMargin(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        this.f3431j = f;
        invalidate();
    }

    public void setCornerRadius(float f) {
        this.e = f;
        this.f3428d = true;
    }

    public void setEnableDefRoundCorner(boolean z2) {
        this.f3428d = z2;
    }

    public void setFillColor(int i8) {
        this.f3425a.setColor(i8);
        invalidate();
    }

    public OsPressSmoothCornerDrawable(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OsPressSmoothCornerDrawable(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8, 0);
        this.f3425a = new Paint(1);
        this.f3426b = new RectF();
        this.f3428d = false;
        this.e = 0.0f;
        this.f3431j = 0.0f;
        Paint paint = new Paint();
        this.f3425a = paint;
        paint.setAntiAlias(true);
        this.f3425a.setStyle(Paint.Style.FILL);
        this.f3425a.setColor(j.e(context, R$attr.os_fill_weaker, R$color.os_fill_weaker_xos));
        setBackground(null);
        setAlpha(0.0f);
        this.f3429h = hd.a.a(context, 4);
        this.f3430i = hd.a.a(context, 0);
    }
}
