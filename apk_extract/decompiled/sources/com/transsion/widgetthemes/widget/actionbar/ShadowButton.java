package com.transsion.widgetthemes.widget.actionbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import com.transsion.widgetsThemes.R$styleable;

/* JADX INFO: loaded from: classes3.dex */
public class ShadowButton extends ImageButton {
    private static final int BG_INSET = 4;
    private static final boolean DEBUG = false;
    private static final int SHADOW_RADIUS = 3;
    private static final String TAG = "FloatButton";
    private float mBgInset;
    private int mBgWidth;
    private int mHeight;
    private boolean mIsMultiWin;
    private Paint mPaint;
    private int mShadowColor;
    private float mShadowRadius;
    private int mWidth;

    public ShadowButton(Context context) {
        this(context, null);
    }

    private void initShadowPaint(float f, int i8) {
        this.mPaint.setShadowLayer(f, 0.0f, f, i8);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        float f = this.mWidth / 2;
        int i8 = this.mBgWidth;
        canvas.drawCircle(f, i8 / 2, i8 / 2, this.mPaint);
        super.onDraw(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i8, int i9) {
        int size = View.MeasureSpec.getSize(i8);
        int size2 = View.MeasureSpec.getSize(i9);
        if (this.mIsMultiWin) {
            setMeasuredDimension((int) (size * 0.75f), (int) (((double) size2) * 0.75d));
        } else {
            setMeasuredDimension(size, size2);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i8, int i9, int i10, int i11) {
        super.onSizeChanged(i8, i9, i10, i11);
        if (i8 > 0) {
            this.mWidth = i8;
            this.mHeight = i9;
            this.mBgWidth = (int) (i8 - (this.mBgInset * 2.0f));
        }
    }

    public void setMultiWindowMode(boolean z2) {
        this.mIsMultiWin = z2;
        if (z2) {
            setShadowRadius(this.mShadowRadius * 0.75f);
        }
        Log.i("os_fb", "FloatButton, setMultiWindowMode() isMultiWin=" + z2);
        requestLayout();
    }

    public void setShadowColor(int i8) {
        this.mShadowColor = i8;
        initShadowPaint(this.mShadowRadius, i8);
        invalidate();
    }

    public void setShadowRadius(float f) {
        this.mShadowRadius = f;
        initShadowPaint(f, this.mShadowColor);
        invalidate();
    }

    public ShadowButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        float f = context.getResources().getDisplayMetrics().density;
        this.mShadowRadius = 3.0f * f;
        this.mBgInset = 4.0f * f;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.osFloatButton, 0, 0);
        this.mShadowRadius = typedArrayObtainStyledAttributes.getDimension(R$styleable.osFloatButton_fbshadowRadius, this.mShadowRadius) - f;
        this.mShadowColor = typedArrayObtainStyledAttributes.getColor(R$styleable.osFloatButton_fbshadowColor, 1711516148);
        typedArrayObtainStyledAttributes.recycle();
        if (getBackground() != null) {
            this.mBgWidth = getBackground().getIntrinsicWidth();
        }
        setLayerType(1, null);
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        if (getBackgroundTintList() != null) {
            this.mPaint.setColor(getBackgroundTintList().getDefaultColor());
        } else {
            this.mPaint.setColor(0);
        }
        initShadowPaint(this.mShadowRadius, this.mShadowColor);
    }
}
