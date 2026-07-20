package com.transsion.widgetslib.widget.actionbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import com.transsion.widgetslib.R$styleable;

/* JADX INFO: loaded from: classes2.dex */
public class ShadowButton extends ImageButton {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f3466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f3468c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3469d;
    public final float e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f3470h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f3471i;

    public ShadowButton(Context context) {
        this(context, null);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas canvas) {
        float f = this.f3467b / 2;
        int i8 = this.f3470h;
        canvas.drawCircle(f, i8 / 2, i8 / 2, this.f3466a);
        super.onDraw(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onMeasure(int i8, int i9) {
        int size = View.MeasureSpec.getSize(i8);
        int size2 = View.MeasureSpec.getSize(i9);
        if (this.f3471i) {
            setMeasuredDimension((int) (size * 0.75f), (int) (((double) size2) * 0.75d));
        } else {
            setMeasuredDimension(size, size2);
        }
    }

    @Override // android.view.View
    public final void onSizeChanged(int i8, int i9, int i10, int i11) {
        super.onSizeChanged(i8, i9, i10, i11);
        if (i8 > 0) {
            this.f3467b = i8;
            this.f3470h = (int) (i8 - (this.e * 2.0f));
        }
    }

    public void setMultiWindowMode(boolean z2) {
        this.f3471i = z2;
        if (z2) {
            setShadowRadius(this.f3468c * 0.75f);
        }
        Log.i("os_fb", "FloatButton, setMultiWindowMode() isMultiWin=" + z2);
        requestLayout();
    }

    public void setShadowColor(int i8) {
        this.f3469d = i8;
        float f = this.f3468c;
        this.f3466a.setShadowLayer(f, 0.0f, f, i8);
        invalidate();
    }

    public void setShadowRadius(float f) {
        this.f3468c = f;
        this.f3466a.setShadowLayer(f, 0.0f, f, this.f3469d);
        invalidate();
    }

    public ShadowButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        float f = context.getResources().getDisplayMetrics().density;
        this.f3468c = 3.0f * f;
        this.e = 4.0f * f;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.osFloatButton, 0, 0);
        this.f3468c = typedArrayObtainStyledAttributes.getDimension(R$styleable.osFloatButton_fbshadowRadius, this.f3468c) - f;
        this.f3469d = typedArrayObtainStyledAttributes.getColor(R$styleable.osFloatButton_fbshadowColor, 1711516148);
        typedArrayObtainStyledAttributes.recycle();
        if (getBackground() != null) {
            this.f3470h = getBackground().getIntrinsicWidth();
        }
        setLayerType(1, null);
        Paint paint = new Paint();
        this.f3466a = paint;
        paint.setAntiAlias(true);
        if (getBackgroundTintList() != null) {
            paint.setColor(getBackgroundTintList().getDefaultColor());
        } else {
            paint.setColor(0);
        }
        float f4 = this.f3468c;
        this.f3466a.setShadowLayer(f4, 0.0f, f4, this.f3469d);
    }
}
