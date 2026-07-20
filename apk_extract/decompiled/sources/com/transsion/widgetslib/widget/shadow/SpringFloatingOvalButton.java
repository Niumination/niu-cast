package com.transsion.widgetslib.widget.shadow;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.dynamicanimation.animation.FloatValueHolder;
import com.transsion.widgetslib.R$attr;
import com.transsion.widgetslib.R$color;
import com.transsion.widgetslib.R$dimen;
import com.transsion.widgetslib.R$drawable;
import com.transsion.widgetslib.R$styleable;
import java.lang.ref.WeakReference;
import jd.e;
import jd.f;
import jd.g;
import jd.h;
import o5.c;
import pd.j;
import tj.x;

/* JADX INFO: loaded from: classes2.dex */
public class SpringFloatingOvalButton extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f3656a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h f3657b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f f3658c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public g f3659d;
    public View.OnTouchListener e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Paint f3660h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f3661i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ColorStateList f3662j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f3663k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f3664l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f3665m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f3666n;

    public SpringFloatingOvalButton(Context context) {
        this(context, null);
    }

    public ImageView getImage() {
        return this.f3656a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if ((parent instanceof ViewGroup) && !this.f3666n) {
            ViewGroup viewGroup = (ViewGroup) parent;
            viewGroup.setClipChildren(false);
            viewGroup.setClipToPadding(false);
        }
        if (this.f3665m) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.setMarginEnd(getContext().getResources().getDimensionPixelSize(R$dimen.os_fab_margin_end_default));
                marginLayoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(R$dimen.os_fab_margin_bottom_default);
                setLayoutParams(marginLayoutParams);
            }
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Context context = getContext();
        String[] strArr = j.f8764a;
        if (hd.a.c(context)) {
            return;
        }
        Paint paint = this.f3660h;
        paint.setColor(getContext().getColor(R.color.transparent));
        paint.setShadowLayer(this.f3663k, 0.0f, this.f3664l, this.f3661i);
        int width = this.f3656a.getWidth() / 2;
        canvas.drawCircle(getPaddingStart() + width, getPaddingTop() + width, width, paint);
    }

    public void setImageBackground(Drawable drawable) {
        this.f3656a.setBackground(drawable);
    }

    public void setImageBackgroundColor(int i8) {
        Drawable drawable = getContext().getDrawable(R$drawable.os_floating_ova_btn_bg);
        drawable.setTintList(new ColorStateList(new int[][]{new int[]{R.attr.state_pressed}, new int[0]}, new int[]{i8, i8}));
        setImageBackground(drawable);
    }

    public void setImageDrawable(Drawable drawable) {
        this.f3656a.setImageDrawable(drawable);
    }

    public void setImagePadding(float f) {
        ImageView imageView = this.f3656a;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) imageView.getLayoutParams();
        int i8 = (int) ((layoutParams.width - f) / 2.0f);
        int i9 = (int) ((layoutParams.height - f) / 2.0f);
        imageView.setPadding(i8, i9, i8, i9);
    }

    public void setImageResource(int i8) {
        this.f3656a.setImageResource(i8);
    }

    public void setOnAnimationEndListener(f fVar) {
        this.f3658c = fVar;
    }

    public void setOnAnimationUpdateListener(g gVar) {
        this.f3659d = gVar;
    }

    public void setOnClickListener(h hVar) {
        this.f3657b = hVar;
    }

    public void setOnFabTouchListener(View.OnTouchListener onTouchListener) {
        this.e = onTouchListener;
    }

    public void setShadowColor(int i8) {
        this.f3661i = i8;
        invalidate();
    }

    public void setUseDefaultInset(boolean z2) {
        this.f3665m = z2;
    }

    @Override // android.view.View
    public void setVisibility(int i8) {
        ImageView imageView = this.f3656a;
        if (imageView != null) {
            imageView.setVisibility(i8);
        }
        super.setVisibility(i8);
    }

    public SpringFloatingOvalButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setClickable(true);
        this.f3663k = context.getResources().getDimensionPixelSize(R$dimen.os_shadow_radius_level2);
        this.f3664l = context.getResources().getDimensionPixelSize(R$dimen.os_shadow_dy_level2);
        ImageView imageView = new ImageView(context, attributeSet);
        this.f3656a = imageView;
        addView(imageView);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R$dimen.os_shadow_ver_inset_top_level2);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R$dimen.os_fab_shadow_ver_inset_bottom_level2);
        int dimensionPixelSize3 = context.getResources().getDimensionPixelSize(R$dimen.os_fab_shadow_inset_start_level2);
        int dimensionPixelSize4 = context.getResources().getDimensionPixelSize(R$dimen.os_fab_shadow_inset_end_level2);
        float dimensionPixelSize5 = context.getResources().getDimensionPixelSize(R$dimen.os_fab_default_image_size);
        float dimensionPixelSize6 = context.getResources().getDimensionPixelSize(R$dimen.os_fab_default_size);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(new int[]{R$attr.os_platform_basic_color});
        this.f3662j = new ColorStateList(new int[][]{new int[0]}, new int[]{typedArrayObtainStyledAttributes.getColor(0, context.getColor(R$color.os_platform_basic_color_hios))});
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R$styleable.FloatingOvalButton);
        float dimension = typedArrayObtainStyledAttributes2.getDimension(R$styleable.FloatingOvalButton_float_image_width, dimensionPixelSize6);
        float dimension2 = typedArrayObtainStyledAttributes2.getDimension(R$styleable.FloatingOvalButton_float_image_height, dimensionPixelSize6);
        Drawable drawable = typedArrayObtainStyledAttributes2.getDrawable(R$styleable.FloatingOvalButton_float_image_src);
        int color = typedArrayObtainStyledAttributes2.getColor(R$styleable.FloatingOvalButton_float_image_background_color, context.getColor(R$color.os_altitude_secondary_color));
        this.f3665m = typedArrayObtainStyledAttributes2.getBoolean(R$styleable.FloatingOvalButton_float_use_default_inset, true);
        if (typedArrayObtainStyledAttributes2.hasValue(R$styleable.FloatingOvalButton_float_image_tint_color)) {
            this.f3662j = typedArrayObtainStyledAttributes2.getColorStateList(R$styleable.FloatingOvalButton_float_image_tint_color);
        }
        if (!j.f8769h || typedArrayObtainStyledAttributes2.hasValue(R$styleable.FloatingOvalButton_float_image_tint_color)) {
            drawable.setTintList(this.f3662j);
        } else {
            drawable.setTintList(context.getColorStateList(R$color.os_platform_clickable_color));
        }
        TypedArray typedArrayObtainStyledAttributes3 = context.obtainStyledAttributes(new int[]{R$attr.os_shadow_color_level2_attr});
        int color2 = typedArrayObtainStyledAttributes3.getColor(0, context.getColor(R$color.os_shadow_color_level2_hios));
        typedArrayObtainStyledAttributes3.recycle();
        this.f3661i = typedArrayObtainStyledAttributes2.getColor(R$styleable.FloatingOvalButton_float_image_shadow_color, color2);
        boolean z2 = typedArrayObtainStyledAttributes2.getBoolean(R$styleable.FloatingOvalButton_float_require_alpha, false);
        this.f3666n = z2;
        typedArrayObtainStyledAttributes2.recycle();
        if (z2) {
            setPaddingRelative(dimensionPixelSize3, dimensionPixelSize, dimensionPixelSize4, dimensionPixelSize2);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.width = (int) dimension;
        layoutParams.height = (int) dimension2;
        imageView.setLayoutParams(layoutParams);
        imageView.setImageDrawable(drawable);
        setImageBackgroundColor(color);
        setShadowColor(this.f3661i);
        setImagePadding(dimensionPixelSize5);
        e eVar = new e();
        eVar.f6154a = 0.88f;
        eVar.f = new FloatValueHolder();
        eVar.f6161j = new WeakReference(this);
        eVar.f6162k = new c(this);
        eVar.f6160i = new fe.e(this);
        eVar.f6159h = new a8.a(this, 6);
        eVar.f6158g = new x(this);
        eVar.a();
        setWillNotDraw(false);
        Paint paint = new Paint();
        this.f3660h = paint;
        paint.setAntiAlias(true);
        paint.setDither(true);
    }
}
