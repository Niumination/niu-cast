package com.transsion.widgetsliquid.view;

import a4.c;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.transsion.widgetslib.R$style;
import com.transsion.widgetsliquid.R;
import hd.a;

/* JADX INFO: loaded from: classes2.dex */
public class CarouselTextView extends AppCompatTextView {
    private static final String TAG = "CarouselTextView";
    private final long INTERVAL_TIME;
    private final int MAX_CAROUSEL_COUNT;
    private int mCarouselCount;
    private boolean mIsFirstScroll;
    private boolean mIsPaused;
    private boolean mIsRtl;
    private int mMaxWidth;
    private float mMinTextSize;
    private boolean mNeedsScroll;
    private float mOriginalTextSize;
    private ValueAnimator mScrollAnimator;
    private float mScrollDistance;
    private float mTextSpacing;
    private int mTextWidth;
    private float mTotalWidth;
    private OnWidthChangedListener mWidthChangedListener;
    private int[] textColarToken;

    public interface OnWidthChangedListener {
        void onWidthChanged(int i8);
    }

    public CarouselTextView(Context context) {
        this(context, null);
    }

    private void calculateTextWidth() {
        int iMeasureText = (int) getPaint().measureText(getText() != null ? getText().toString() : "");
        this.mTextWidth = iMeasureText;
        this.mTotalWidth = iMeasureText + this.mTextSpacing;
    }

    private void handleScrollComplete() {
        int i8 = this.mCarouselCount + 1;
        this.mCarouselCount = i8;
        if (i8 >= 2) {
            stopScroll();
        } else {
            this.mIsPaused = true;
            postDelayed(new c(this, 28), 1000L);
        }
    }

    private void init() {
        setLayerType(1, null);
        setGravity(16);
        setSingleLine(true);
        setEllipsize(null);
        setTextAppearance(R$style.os_semibold_font);
        this.mIsRtl = getResources().getConfiguration().getLayoutDirection() == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleScrollComplete$1() {
        if (getWindowToken() != null) {
            this.mIsPaused = false;
            if (this.mIsFirstScroll) {
                this.mIsFirstScroll = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startScroll$0(float f, ValueAnimator valueAnimator) {
        if (this.mIsPaused) {
            return;
        }
        this.mScrollDistance = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
        if (this.mIsRtl) {
            float f4 = this.mScrollDistance;
            if (f4 > 1.0f || f4 < 0.0f) {
                return;
            }
        } else {
            float f10 = this.mScrollDistance;
            if (f10 < f - 1.0f || f10 > f) {
                return;
            }
        }
        handleScrollComplete();
    }

    private void resetScroll() {
        stopScroll();
        this.mScrollDistance = 0.0f;
        this.mCarouselCount = 0;
        this.mIsFirstScroll = true;
        this.mIsPaused = false;
        startScroll();
    }

    private void startScroll() {
        ValueAnimator valueAnimator = this.mScrollAnimator;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            calculateTextWidth();
            if (this.mNeedsScroll) {
                final float f = this.mTotalWidth;
                long j8 = (long) (30.0f * f);
                if (this.mIsRtl) {
                    this.mScrollAnimator = ValueAnimator.ofFloat(f, 0.0f);
                } else {
                    this.mScrollAnimator = ValueAnimator.ofFloat(0.0f, f);
                }
                this.mScrollAnimator.setDuration(j8);
                this.mScrollAnimator.setInterpolator(new LinearInterpolator());
                this.mScrollAnimator.setRepeatCount(-1);
                this.mScrollAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: je.a
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                        this.f6185a.lambda$startScroll$0(f, valueAnimator2);
                    }
                });
                this.mScrollAnimator.start();
            }
        }
    }

    private void stopScroll() {
        ValueAnimator valueAnimator = this.mScrollAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.mScrollAnimator = null;
        }
    }

    public void _setMaxWidth(int i8) {
        this.mMaxWidth = i8;
    }

    public void forceScrollCheck() {
        resetScroll();
    }

    public boolean isRtl() {
        return this.mIsRtl;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        startScroll();
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        boolean z2 = this.mIsRtl;
        boolean z3 = configuration.getLayoutDirection() == 1;
        this.mIsRtl = z3;
        if (z2 != z3) {
            resetScroll();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopScroll();
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        CharSequence text = getText();
        if (text == null || text.length() == 0) {
            return;
        }
        String string = text.toString();
        TextPaint paint = getPaint();
        if (this.mTextWidth == 0) {
            calculateTextWidth();
        }
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        if (!this.mNeedsScroll) {
            canvas.drawText(string, paddingLeft, getBaseline(), paint);
            return;
        }
        if (this.mIsRtl) {
            float width = ((getWidth() - paddingRight) - this.mTextWidth) + this.mScrollDistance;
            canvas.drawText(string, width, getBaseline(), paint);
            canvas.drawText(string, width - this.mTotalWidth, getBaseline(), paint);
        } else {
            float f = paddingLeft - this.mScrollDistance;
            canvas.drawText(string, f, getBaseline(), paint);
            canvas.drawText(string, f + this.mTotalWidth, getBaseline(), paint);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int i8, int i9) {
        getPaint().setTextSize(this.mOriginalTextSize);
        calculateTextWidth();
        this.mNeedsScroll = false;
        int i10 = this.mTextWidth;
        if (i10 > this.mMaxWidth) {
            getPaint().setTextSize(this.mMinTextSize);
            calculateTextWidth();
            i10 = this.mTextWidth;
            int i11 = this.mMaxWidth;
            if (i10 > i11) {
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(i11, BasicMeasure.EXACTLY), i9);
                this.mNeedsScroll = true;
                i10 = i11;
            } else {
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(i10, BasicMeasure.EXACTLY), i9);
            }
        } else {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(i10, BasicMeasure.EXACTLY), i9);
        }
        OnWidthChangedListener onWidthChangedListener = this.mWidthChangedListener;
        if (onWidthChangedListener != null) {
            onWidthChangedListener.onWidthChanged(i10);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i8, int i9, int i10, int i11) {
        super.onSizeChanged(i8, i9, i10, i11);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i8, int i9, int i10) {
        super.onTextChanged(charSequence, i8, i9, i10);
        resetScroll();
        requestLayout();
    }

    public void setIntervalTime(long j8) {
        resetScroll();
    }

    public void setMaxCarouselCount(int i8) {
        this.mCarouselCount = 0;
        resetScroll();
    }

    public void setOnWidthChangedListener(OnWidthChangedListener onWidthChangedListener) {
        this.mWidthChangedListener = onWidthChangedListener;
    }

    public void setPaused(boolean z2) {
        this.mIsPaused = z2;
    }

    public void setTextSpacing(float f) {
        this.mTextSpacing = f;
        calculateTextWidth();
        resetScroll();
        requestLayout();
    }

    public CarouselTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CarouselTextView(Context context, @Nullable AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        this.mTextSpacing = a.a(getContext(), 20);
        this.mScrollDistance = 0.0f;
        this.mCarouselCount = 0;
        this.MAX_CAROUSEL_COUNT = 2;
        this.INTERVAL_TIME = 1000L;
        this.mIsFirstScroll = true;
        this.mIsPaused = false;
        this.mIsRtl = false;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mNeedsScroll = false;
        this.textColarToken = new int[]{R.attr.os_text_secondary};
        this.mOriginalTextSize = TypedValue.applyDimension(2, 14.0f, context.getResources().getDisplayMetrics());
        this.mMinTextSize = TypedValue.applyDimension(2, 12.0f, context.getResources().getDisplayMetrics());
        if (getTextSize() == 0.0f || getTextSize() != this.mOriginalTextSize) {
            getPaint().setTextSize(this.mOriginalTextSize);
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, this.textColarToken, i8, 0);
        int color = typedArrayObtainStyledAttributes.getColor(0, R.color.os_color_black100);
        typedArrayObtainStyledAttributes.recycle();
        getPaint().setColor(color);
        init();
    }
}
