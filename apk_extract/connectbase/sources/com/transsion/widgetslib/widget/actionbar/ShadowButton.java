package com.transsion.widgetslib.widget.actionbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import b.a;
import com.transsion.widgetslib.R;

/* JADX INFO: loaded from: classes2.dex */
@a({"AppCompatCustomView"})
public class ShadowButton extends ImageButton {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f2811n = "FloatButton";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final boolean f2812p = false;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f2813v = 4;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f2814w = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f2815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2816b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2817c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f2818d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2819e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f2820f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f2821g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f2822i;

    public ShadowButton(Context context) {
        this(context, null);
    }

    public final void a(float f10, int i10) {
        this.f2815a.setShadowLayer(f10, 0.0f, f10, i10);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        float f10 = this.f2816b / 2;
        int i10 = this.f2821g;
        canvas.drawCircle(f10, i10 / 2, i10 / 2, this.f2815a);
        super.onDraw(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i10, int i11) {
        int size = View.MeasureSpec.getSize(i10);
        int size2 = View.MeasureSpec.getSize(i11);
        if (this.f2822i) {
            setMeasuredDimension((int) (size * 0.75f), (int) (((double) size2) * 0.75d));
        } else {
            setMeasuredDimension(size, size2);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        if (i10 > 0) {
            this.f2816b = i10;
            this.f2817c = i11;
            this.f2821g = (int) (i10 - (this.f2820f * 2.0f));
        }
    }

    public void setMultiWindowMode(boolean z10) {
        this.f2822i = z10;
        if (z10) {
            setShadowRadius(this.f2818d * 0.75f);
        }
        Log.i("os_fb", "FloatButton, setMultiWindowMode() isMultiWin=" + z10);
        requestLayout();
    }

    public void setShadowColor(int i10) {
        this.f2819e = i10;
        a(this.f2818d, i10);
        invalidate();
    }

    public void setShadowRadius(float f10) {
        this.f2818d = f10;
        a(f10, this.f2819e);
        invalidate();
    }

    public ShadowButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        float f10 = context.getResources().getDisplayMetrics().density;
        this.f2818d = 3.0f * f10;
        this.f2820f = 4.0f * f10;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.osFloatButton, 0, 0);
        this.f2818d = typedArrayObtainStyledAttributes.getDimension(R.styleable.osFloatButton_fbshadowRadius, this.f2818d) - f10;
        this.f2819e = typedArrayObtainStyledAttributes.getColor(R.styleable.osFloatButton_fbshadowColor, 1711516148);
        typedArrayObtainStyledAttributes.recycle();
        if (getBackground() != null) {
            this.f2821g = getBackground().getIntrinsicWidth();
        }
        setLayerType(1, null);
        Paint paint = new Paint();
        this.f2815a = paint;
        paint.setAntiAlias(true);
        if (getBackgroundTintList() != null) {
            this.f2815a.setColor(getBackgroundTintList().getDefaultColor());
        } else {
            this.f2815a.setColor(0);
        }
        a(this.f2818d, this.f2819e);
    }
}
