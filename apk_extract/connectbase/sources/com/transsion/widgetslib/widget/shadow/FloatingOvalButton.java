package com.transsion.widgetslib.widget.shadow;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.transsion.widgetslib.R;
import hj.h;

/* JADX INFO: loaded from: classes2.dex */
public class FloatingOvalButton extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ShadowLayout f3068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f3069b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ValueAnimator f3070c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ValueAnimator f3071d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f3072e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f3073f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public PathInterpolator f3074g;

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            FloatingOvalButton.this.f3073f = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            Log.d("FloatingOvalButton", "mCurrentScale: " + FloatingOvalButton.this.f3073f);
            FloatingOvalButton floatingOvalButton = FloatingOvalButton.this;
            floatingOvalButton.f3068a.setScaleX(floatingOvalButton.f3073f);
            FloatingOvalButton floatingOvalButton2 = FloatingOvalButton.this;
            floatingOvalButton2.f3068a.setScaleY(floatingOvalButton2.f3073f);
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            FloatingOvalButton.this.f3073f = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            Log.d("FloatingOvalButton", "mCurrentScale1: " + FloatingOvalButton.this.f3073f);
            FloatingOvalButton floatingOvalButton = FloatingOvalButton.this;
            floatingOvalButton.f3068a.setScaleX(floatingOvalButton.f3073f);
            FloatingOvalButton floatingOvalButton2 = FloatingOvalButton.this;
            floatingOvalButton2.f3068a.setScaleY(floatingOvalButton2.f3073f);
        }
    }

    public FloatingOvalButton(Context context) {
        this(context, null);
    }

    public void d(int i10, int i11) {
        Drawable drawable = getContext().getDrawable(R.drawable.os_floating_ova_btn_bg);
        drawable.setTintList(new ColorStateList(new int[][]{new int[]{android.R.attr.state_pressed}, new int[0]}, new int[]{i11, i10}));
        setImageBackground(drawable);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            f();
        } else if (action == 1 || action == 3) {
            h();
            g();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void e(int i10, int i11) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f3069b.getLayoutParams();
        layoutParams.width = i10;
        layoutParams.height = i11;
        this.f3069b.setLayoutParams(layoutParams);
        setImagePadding(this.f3072e);
    }

    public final void f() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.9f);
        this.f3070c = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(200L);
        this.f3070c.setInterpolator(this.f3074g);
        this.f3070c.addUpdateListener(new a());
        this.f3070c.start();
    }

    public final void g() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.f3073f, 1.0f);
        this.f3071d = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(150L);
        this.f3071d.setInterpolator(this.f3074g);
        this.f3071d.addUpdateListener(new b());
        this.f3071d.start();
    }

    public ImageView getImage() {
        return this.f3069b;
    }

    public ShadowLayout getShadowLayout() {
        return this.f3068a;
    }

    public final void h() {
        ValueAnimator valueAnimator = this.f3070c;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.f3070c.cancel();
    }

    public void setImageBackground(Drawable drawable) {
        this.f3069b.setBackground(drawable);
    }

    public void setImageDrawable(Drawable drawable) {
        this.f3069b.setImageDrawable(drawable);
    }

    public void setImagePadding(float f10) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f3069b.getLayoutParams();
        int i10 = (int) ((layoutParams.width - f10) / 2.0f);
        int i11 = (int) ((layoutParams.height - f10) / 2.0f);
        this.f3069b.setPadding(i10, i11, i10, i11);
    }

    public void setImageResource(int i10) {
        this.f3069b.setImageResource(i10);
    }

    public void setShadowColor(int i10) {
        this.f3068a.setShadowColor(i10);
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        if (i10 == 0) {
            this.f3068a.setVisibility(0);
            this.f3069b.setVisibility(0);
        } else if (i10 == 4) {
            this.f3068a.setVisibility(4);
            this.f3069b.setVisibility(4);
        } else if (i10 == 8) {
            this.f3068a.setVisibility(8);
            this.f3069b.setVisibility(8);
        }
        super.setVisibility(i10);
    }

    public FloatingOvalButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setClickable(true);
        this.f3068a = new ShadowLayout(context, attributeSet, 0, false);
        ImageView imageView = new ImageView(context, attributeSet);
        this.f3069b = imageView;
        this.f3068a.addView(imageView);
        addView(this.f3068a);
        this.f3072e = context.getResources().getDimensionPixelSize(R.dimen.os_fab_default_image_size);
        float dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.os_fab_default_size);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(new int[]{R.attr.os_platform_basic_color, R.attr.os_fab_bg_pressed_color, R.attr.os_fab_shadow_color});
        int color = typedArrayObtainStyledAttributes.getColor(0, context.getColor(R.color.os_platform_basic_color_hios));
        int color2 = typedArrayObtainStyledAttributes.getColor(1, context.getColor(R.color.os_fab_bg_pressed_color_hios));
        int color3 = typedArrayObtainStyledAttributes.getColor(2, context.getColor(R.color.os_fab_shadow_color_hios));
        typedArrayObtainStyledAttributes.recycle();
        int i10 = h.o().equals(h.f7214g[1]) ? 0 : color3;
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R.styleable.FloatingOvalButton);
        float dimension = typedArrayObtainStyledAttributes2.getDimension(R.styleable.FloatingOvalButton_float_image_width, dimensionPixelSize);
        float dimension2 = typedArrayObtainStyledAttributes2.getDimension(R.styleable.FloatingOvalButton_float_image_height, dimensionPixelSize);
        Drawable drawable = typedArrayObtainStyledAttributes2.getDrawable(R.styleable.FloatingOvalButton_float_image_src);
        int color4 = typedArrayObtainStyledAttributes2.getColor(R.styleable.FloatingOvalButton_float_image_background_color, color);
        int color5 = typedArrayObtainStyledAttributes2.getColor(R.styleable.FloatingOvalButton_float_image_background_pressed_color, color2);
        int color6 = typedArrayObtainStyledAttributes2.getColor(R.styleable.FloatingOvalButton_float_image_shadow_color, i10);
        typedArrayObtainStyledAttributes2.recycle();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f3069b.getLayoutParams();
        layoutParams.width = (int) dimension;
        layoutParams.height = (int) dimension2;
        this.f3069b.setLayoutParams(layoutParams);
        this.f3069b.setImageDrawable(drawable);
        d(color4, color5);
        setShadowColor(color6);
        setImagePadding(this.f3072e);
        this.f3074g = new PathInterpolator(0.45f, 0.0f, 0.55f, 1.0f);
    }
}
