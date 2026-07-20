package com.transsion.widgetsliquid.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import com.transsion.widgetslib.R$styleable;
import com.transsion.widgetslib.view.OSBigButton;
import com.transsion.widgetslib.widget.OsPressSmoothCornerDrawable;
import com.transsion.widgetsliquid.effect.OSLiquidContainerRootLayout;
import hd.a;
import pd.j;

/* JADX INFO: loaded from: classes2.dex */
public class OSLiquidBigButton extends OSLiquidContainerRootLayout {
    private static final int BIG_CORNER = 22;
    private static final String TAG = "OSLiquidBigButton";
    private static final int TINY_CORNER = 16;
    private static final int TINY_HEIGHT = 32;
    private int childHeight;
    private int childWidth;
    private SpringAnimation currentScaleAnimator;
    private boolean isTinyButton;
    private Context mContext;
    private OSBigButton mOsBigButton;
    private OsPressSmoothCornerDrawable osPressSmoothCornerDrawable;
    private SpringForce startSpring;
    private SpringForce stopSpring;

    public OSLiquidBigButton(Context context) {
        this(context, null);
    }

    private void init() {
        setPadding(0, 0, 0, 0);
        this.osPressSmoothCornerDrawable.setEnableDefRoundCorner(false);
        this.osPressSmoothCornerDrawable.setCornerRadius(getCornerRadius());
        this.mOsBigButton.setBackground(null);
        getContext();
        if (j.s()) {
            int iA = a.a(this.mContext, this.isTinyButton ? 0 : 16);
            int paddingTop = this.mOsBigButton.getPaddingTop();
            this.mOsBigButton.setPadding(iA, paddingTop, iA, paddingTop);
        }
        if (isNightMode()) {
            this.osPressSmoothCornerDrawable.setFillColor(Color.parseColor("#14FFFFFF"));
        } else if (getMixLevel() == 5) {
            this.osPressSmoothCornerDrawable.setFillColor(Color.parseColor("#33FFFFFF"));
        } else {
            this.osPressSmoothCornerDrawable.setFillColor(Color.parseColor("#CCFFFFFF"));
        }
        this.mOsBigButton.setOnTouchListener(new View.OnTouchListener() { // from class: com.transsion.widgetsliquid.view.OSLiquidBigButton.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    OSLiquidBigButton oSLiquidBigButton = OSLiquidBigButton.this;
                    oSLiquidBigButton.startPressAnimation(oSLiquidBigButton.mOsBigButton);
                    OSLiquidBigButton.this.osPressSmoothCornerDrawable.b();
                } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    OSLiquidBigButton.this.osPressSmoothCornerDrawable.a();
                    OSLiquidBigButton oSLiquidBigButton2 = OSLiquidBigButton.this;
                    oSLiquidBigButton2.stopPressAnimation(oSLiquidBigButton2.mOsBigButton);
                    if (motionEvent.getAction() == 1) {
                        OSLiquidBigButton.this.mOsBigButton.performClick();
                    }
                }
                return true;
            }
        });
        addView(this.osPressSmoothCornerDrawable, new FrameLayout.LayoutParams(-1, -1));
        addView(this.mOsBigButton, new FrameLayout.LayoutParams(-2, -2));
        this.startSpring.setDampingRatio(0.99f);
        this.startSpring.setStiffness(250.0f);
        this.startSpring.setFinalPosition(1.05f);
        this.stopSpring.setDampingRatio(0.4f);
        this.stopSpring.setStiffness(250.0f);
        this.stopSpring.setFinalPosition(1.0f);
    }

    private boolean isNightMode() {
        return (this.mContext.getResources().getConfiguration().uiMode & 48) == 32;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPressAnimation(View view) {
        this.currentScaleAnimator.cancel();
        this.currentScaleAnimator.setSpring(this.startSpring);
        this.currentScaleAnimator.addUpdateListener(new DynamicAnimation.OnAnimationUpdateListener() { // from class: com.transsion.widgetsliquid.view.OSLiquidBigButton.2
            @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener
            public void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f, float f4) {
                OSLiquidBigButton.this.setScaleY(f);
                OSLiquidBigButton.this.setScaleX(f);
            }
        });
        this.currentScaleAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPressAnimation(View view) {
        this.currentScaleAnimator.cancel();
        this.currentScaleAnimator.setSpring(this.stopSpring);
        this.currentScaleAnimator.addUpdateListener(new DynamicAnimation.OnAnimationUpdateListener() { // from class: com.transsion.widgetsliquid.view.OSLiquidBigButton.3
            @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener
            public void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f, float f4) {
                OSLiquidBigButton.this.setScaleY(f);
                OSLiquidBigButton.this.setScaleX(f);
            }
        });
        this.currentScaleAnimator.start();
    }

    @Override // com.transsion.widgetslib.view.liquid.effect.OSLiquidContainerRootLayoutInner, android.view.ViewGroup, android.view.View
    public void dispatchDraw(@NonNull Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    public OSBigButton getOsBigButton() {
        return this.mOsBigButton;
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    @Override // com.transsion.widgetslib.view.liquid.effect.OSLiquidContainerRootLayoutInner, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i8, int i9) {
        measureChild(this.mOsBigButton, i8, i9);
        if (this.mOsBigButton.getMeasuredHeight() <= 0 || this.mOsBigButton.getMeasuredWidth() <= 0) {
            super.onMeasure(i8, i9);
        } else {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.mOsBigButton.getMeasuredWidth(), BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(this.mOsBigButton.getMeasuredHeight(), BasicMeasure.EXACTLY));
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z2) {
        super.setEnabled(z2);
        setAlpha(z2 ? 1.0f : 0.4f);
        this.mOsBigButton.setEnabled(z2);
    }

    public void setText(CharSequence charSequence) {
        this.mOsBigButton.setText(charSequence);
    }

    @Override // com.transsion.widgetslib.view.liquid.effect.OSLiquidContainerRootLayoutInner, android.view.View
    public void setVisibility(int i8) {
        super.setVisibility(i8);
        this.mOsBigButton.setVisibility(i8);
        this.osPressSmoothCornerDrawable.setVisibility(i8);
    }

    public OSLiquidBigButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @RequiresApi(api = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_BIAS)
    public OSLiquidBigButton(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        this.isTinyButton = false;
        this.startSpring = new SpringForce();
        this.stopSpring = new SpringForce();
        this.mOsBigButton = new OSBigButton(context, attributeSet, i8);
        forceHasOverlappingRendering(false);
        this.osPressSmoothCornerDrawable = new OsPressSmoothCornerDrawable(context, attributeSet, i8);
        this.mContext = context;
        this.currentScaleAnimator = new SpringAnimation(this, DynamicAnimation.SCALE_X);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.osBigLiqButton);
        this.isTinyButton = typedArrayObtainStyledAttributes.getBoolean(R$styleable.osBigLiqButton_isTinyButton, false);
        typedArrayObtainStyledAttributes.recycle();
        if (this.isTinyButton) {
            setShadowCorner(a.a(this.mContext, 16));
            this.mOsBigButton.setMaxButtonHeightDp(32);
            this.mOsBigButton.setMinButtonHeightDp(32);
            this.mOsBigButton.setMaxTextLine(1);
            this.mOsBigButton.setMaxLines(1);
        } else {
            setShadowCorner(a.a(this.mContext, 22));
        }
        init();
    }
}
