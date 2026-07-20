package com.transsion.widgetthemes.widget.actionbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import b.a;
import com.transsion.widgetsThemes.R;

/* JADX INFO: loaded from: classes2.dex */
@a({"AppCompatCustomView"})
public class ShadowButton extends ImageButton {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f3344n = "FloatButton";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final boolean f3345p = false;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f3346v = 4;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f3347w = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f3348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3349b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3350c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f3351d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f3352e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f3353f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f3354g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f3355i;

    public ShadowButton(Context context) {
        this(context, null);
    }

    public final void a(float f10, int i10) {
        this.f3348a.setShadowLayer(f10, 0.0f, f10, i10);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        float f10 = this.f3349b / 2;
        int i10 = this.f3354g;
        canvas.drawCircle(f10, i10 / 2, i10 / 2, this.f3348a);
        super.onDraw(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i10, int i11) {
        int size = View.MeasureSpec.getSize(i10);
        int size2 = View.MeasureSpec.getSize(i11);
        if (this.f3355i) {
            setMeasuredDimension((int) (size * 0.75f), (int) (((double) size2) * 0.75d));
        } else {
            setMeasuredDimension(size, size2);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        if (i10 > 0) {
            this.f3349b = i10;
            this.f3350c = i11;
            this.f3354g = (int) (i10 - (this.f3353f * 2.0f));
        }
    }

    public void setMultiWindowMode(boolean z10) {
        this.f3355i = z10;
        if (z10) {
            setShadowRadius(this.f3351d * 0.75f);
        }
        Log.i("os_fb", "FloatButton, setMultiWindowMode() isMultiWin=" + z10);
        requestLayout();
    }

    public void setShadowColor(int i10) {
        this.f3352e = i10;
        a(this.f3351d, i10);
        invalidate();
    }

    public void setShadowRadius(float f10) {
        this.f3351d = f10;
        a(f10, this.f3352e);
        invalidate();
    }

    public ShadowButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        float f10 = context.getResources().getDisplayMetrics().density;
        this.f3351d = 3.0f * f10;
        this.f3353f = 4.0f * f10;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.osFloatButton, 0, 0);
        this.f3351d = typedArrayObtainStyledAttributes.getDimension(R.styleable.osFloatButton_fbshadowRadius, this.f3351d) - f10;
        this.f3352e = typedArrayObtainStyledAttributes.getColor(R.styleable.osFloatButton_fbshadowColor, 1711516148);
        typedArrayObtainStyledAttributes.recycle();
        if (getBackground() != null) {
            this.f3354g = getBackground().getIntrinsicWidth();
        }
        setLayerType(1, null);
        Paint paint = new Paint();
        this.f3348a = paint;
        paint.setAntiAlias(true);
        if (getBackgroundTintList() != null) {
            this.f3348a.setColor(getBackgroundTintList().getDefaultColor());
        } else {
            this.f3348a.setColor(0);
        }
        a(this.f3351d, this.f3352e);
    }
}
