package com.transsion.widgetslib.widget.shadow;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.transsion.widgetslib.R$attr;
import com.transsion.widgetslib.R$color;
import com.transsion.widgetslib.R$dimen;
import com.transsion.widgetslib.R$drawable;
import com.transsion.widgetslib.R$styleable;
import fe.c;
import pd.j;

/* JADX INFO: loaded from: classes2.dex */
public class FloatingOvalButton extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ShadowLayout f3635a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f3636b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ValueAnimator f3637c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ValueAnimator f3638d;
    public float e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final PathInterpolator f3639h;

    public FloatingOvalButton(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        PathInterpolator pathInterpolator = this.f3639h;
        if (action == 0) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.9f);
            this.f3637c = valueAnimatorOfFloat;
            valueAnimatorOfFloat.setDuration(200L);
            this.f3637c.setInterpolator(pathInterpolator);
            this.f3637c.addUpdateListener(new c(this, 0));
            this.f3637c.start();
        } else if (action == 1 || action == 3) {
            ValueAnimator valueAnimator = this.f3637c;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f3637c.cancel();
            }
            ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(this.e, 1.0f);
            this.f3638d = valueAnimatorOfFloat2;
            valueAnimatorOfFloat2.setDuration(150L);
            this.f3638d.setInterpolator(pathInterpolator);
            this.f3638d.addUpdateListener(new c(this, 1));
            this.f3638d.start();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public ImageView getImage() {
        return this.f3636b;
    }

    public ShadowLayout getShadowLayout() {
        return this.f3635a;
    }

    public void setImageBackground(Drawable drawable) {
        this.f3636b.setBackground(drawable);
    }

    public void setImageDrawable(Drawable drawable) {
        this.f3636b.setImageDrawable(drawable);
    }

    public void setImagePadding(float f) {
        ImageView imageView = this.f3636b;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) imageView.getLayoutParams();
        int i8 = (int) ((layoutParams.width - f) / 2.0f);
        int i9 = (int) ((layoutParams.height - f) / 2.0f);
        imageView.setPadding(i8, i9, i8, i9);
    }

    public void setImageResource(int i8) {
        this.f3636b.setImageResource(i8);
    }

    public void setShadowColor(int i8) {
        this.f3635a.setShadowColor(i8);
    }

    @Override // android.view.View
    public void setVisibility(int i8) {
        ImageView imageView = this.f3636b;
        ShadowLayout shadowLayout = this.f3635a;
        if (i8 == 0) {
            shadowLayout.setVisibility(0);
            imageView.setVisibility(0);
        } else if (i8 == 4) {
            shadowLayout.setVisibility(4);
            imageView.setVisibility(4);
        } else if (i8 == 8) {
            shadowLayout.setVisibility(8);
            imageView.setVisibility(8);
        }
        super.setVisibility(i8);
    }

    public FloatingOvalButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setClickable(true);
        ShadowLayout shadowLayout = new ShadowLayout(context, attributeSet, 0, false);
        this.f3635a = shadowLayout;
        ImageView imageView = new ImageView(context, attributeSet);
        this.f3636b = imageView;
        shadowLayout.addView(imageView);
        addView(shadowLayout);
        float dimensionPixelSize = context.getResources().getDimensionPixelSize(R$dimen.os_fab_default_image_size);
        float dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R$dimen.os_fab_default_size);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(new int[]{R$attr.os_platform_basic_color, R$attr.os_fab_bg_pressed_color, R$attr.os_fab_shadow_color});
        int color = typedArrayObtainStyledAttributes.getColor(0, context.getColor(R$color.os_platform_basic_color_hios));
        int color2 = typedArrayObtainStyledAttributes.getColor(1, context.getColor(R$color.os_fab_bg_pressed_color_hios));
        int color3 = typedArrayObtainStyledAttributes.getColor(2, context.getColor(R$color.os_fab_shadow_color_hios));
        typedArrayObtainStyledAttributes.recycle();
        color3 = j.getOsType().equals(j.f8764a[1]) ? 0 : color3;
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R$styleable.FloatingOvalButton);
        float dimension = typedArrayObtainStyledAttributes2.getDimension(R$styleable.FloatingOvalButton_float_image_width, dimensionPixelSize2);
        float dimension2 = typedArrayObtainStyledAttributes2.getDimension(R$styleable.FloatingOvalButton_float_image_height, dimensionPixelSize2);
        Drawable drawable = typedArrayObtainStyledAttributes2.getDrawable(R$styleable.FloatingOvalButton_float_image_src);
        int color4 = typedArrayObtainStyledAttributes2.getColor(R$styleable.FloatingOvalButton_float_image_background_color, color);
        int color5 = typedArrayObtainStyledAttributes2.getColor(R$styleable.FloatingOvalButton_float_image_background_pressed_color, color2);
        int color6 = typedArrayObtainStyledAttributes2.getColor(R$styleable.FloatingOvalButton_float_image_shadow_color, color3);
        typedArrayObtainStyledAttributes2.recycle();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.width = (int) dimension;
        layoutParams.height = (int) dimension2;
        imageView.setLayoutParams(layoutParams);
        imageView.setImageDrawable(drawable);
        Drawable drawable2 = getContext().getDrawable(R$drawable.os_floating_ova_btn_bg);
        drawable2.setTintList(new ColorStateList(new int[][]{new int[]{R.attr.state_pressed}, new int[0]}, new int[]{color5, color4}));
        setImageBackground(drawable2);
        setShadowColor(color6);
        setImagePadding(dimensionPixelSize);
        this.f3639h = new PathInterpolator(0.45f, 0.0f, 0.55f, 1.0f);
    }
}
