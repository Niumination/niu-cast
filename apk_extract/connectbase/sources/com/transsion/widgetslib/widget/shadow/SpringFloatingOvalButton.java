package com.transsion.widgetslib.widget.shadow;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FloatValueHolder;
import com.transsion.widgetslib.R;
import hj.h;

/* JADX INFO: loaded from: classes2.dex */
public class SpringFloatingOvalButton extends FrameLayout {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f3088x = 12;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f3089y = 4;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String f3090z = "SpringFloatingOvalTestB";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView f3091a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f3092b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public xi.c.h f3093c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public xi.c.f f3094d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public xi.c.g f3095e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View.OnTouchListener f3096f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f3097g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Paint f3098i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f3099n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f3100p;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f3101v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f3102w;

    public class a implements xi.c.g {
        public a() {
        }

        @Override // xi.c.g
        public void a(boolean z10, DynamicAnimation dynamicAnimation, float f10, float f11) {
            if (SpringFloatingOvalButton.this.f3095e != null) {
                SpringFloatingOvalButton.this.f3095e.a(z10, dynamicAnimation, f10, f11);
            }
        }
    }

    public class b implements xi.c.f {
        public b() {
        }

        @Override // xi.c.f
        public void a(boolean z10, DynamicAnimation dynamicAnimation, boolean z11, boolean z12, float f10, float f11) {
            if (SpringFloatingOvalButton.this.f3094d != null) {
                SpringFloatingOvalButton.this.f3094d.a(z10, dynamicAnimation, z11, z12, f10, f11);
            }
        }
    }

    public class c implements View.OnTouchListener {
        public c() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (SpringFloatingOvalButton.this.f3096f == null) {
                return false;
            }
            SpringFloatingOvalButton.this.f3096f.onTouch(view, motionEvent);
            return false;
        }
    }

    public class d implements xi.c.h {
        public d() {
        }

        @Override // xi.c.h
        public void a(View view, boolean z10) {
            if (SpringFloatingOvalButton.this.f3093c != null) {
                SpringFloatingOvalButton.this.f3093c.a(view, z10);
            }
        }
    }

    public SpringFloatingOvalButton(Context context) {
        this(context, null);
    }

    @Deprecated
    public void e(int i10, int i11) {
        Drawable drawable = getContext().getDrawable(R.drawable.os_floating_ova_btn_bg);
        drawable.setTintList(new ColorStateList(new int[][]{new int[]{android.R.attr.state_pressed}, new int[0]}, new int[]{i11, i10}));
        setImageBackground(drawable);
    }

    public void f(int i10, int i11) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f3091a.getLayoutParams();
        layoutParams.width = i10;
        layoutParams.height = i11;
        this.f3091a.setLayoutParams(layoutParams);
        setImagePadding(this.f3092b);
    }

    public ImageView getImage() {
        return this.f3091a;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f3098i.setColor(getContext().getColor(android.R.color.transparent));
        this.f3098i.setShadowLayer(h.e(getContext(), 12), 0.0f, ui.a.d(getContext(), 4), this.f3099n);
        canvas.drawCircle(getWidth() / 2, ui.a.d(getContext(), 10) + (this.f3091a.getWidth() / 2), this.f3091a.getWidth() / 2, this.f3098i);
    }

    public void setImageBackground(Drawable drawable) {
        this.f3091a.setBackground(drawable);
    }

    public void setImageBackgroundColor(int i10) {
        Drawable drawable = getContext().getDrawable(R.drawable.os_floating_ova_btn_bg);
        drawable.setTintList(new ColorStateList(new int[][]{new int[]{android.R.attr.state_pressed}, new int[0]}, new int[]{i10, i10}));
        setImageBackground(drawable);
    }

    public void setImageDrawable(Drawable drawable) {
        this.f3091a.setImageDrawable(drawable);
    }

    public void setImagePadding(float f10) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f3091a.getLayoutParams();
        int i10 = (int) ((layoutParams.width - f10) / 2.0f);
        int i11 = (int) ((layoutParams.height - f10) / 2.0f);
        this.f3091a.setPadding(i10, i11, i10, i11);
    }

    public void setImageResource(int i10) {
        this.f3091a.setImageResource(i10);
    }

    public void setOnAnimationEndListener(xi.c.f fVar) {
        this.f3094d = fVar;
    }

    public void setOnAnimationUpdateListener(xi.c.g gVar) {
        this.f3095e = gVar;
    }

    public void setOnClickListener(xi.c.h hVar) {
        this.f3093c = hVar;
    }

    public void setOnFabTouchListener(View.OnTouchListener onTouchListener) {
        this.f3096f = onTouchListener;
    }

    public void setShadowColor(int i10) {
        this.f3099n = i10;
        invalidate();
    }

    public SpringFloatingOvalButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3097g = 0;
        setClickable(true);
        ImageView imageView = new ImageView(context, attributeSet);
        this.f3091a = imageView;
        addView(imageView);
        this.f3097g = h.e(context, 18);
        setPadding(ui.a.d(context, 13), ui.a.d(context, 10), ui.a.d(context, 13), this.f3097g);
        this.f3092b = context.getResources().getDimensionPixelSize(R.dimen.os_fab_default_image_size);
        this.f3102w = context.getResources().getDimensionPixelSize(R.dimen.os_fab_default_size);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(new int[]{R.attr.os_platform_basic_color});
        this.f3101v = typedArrayObtainStyledAttributes.getColor(0, context.getColor(R.color.os_platform_basic_color_hios));
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R.styleable.FloatingOvalButton);
        float dimension = typedArrayObtainStyledAttributes2.getDimension(R.styleable.FloatingOvalButton_float_image_width, this.f3102w);
        float dimension2 = typedArrayObtainStyledAttributes2.getDimension(R.styleable.FloatingOvalButton_float_image_height, this.f3102w);
        Drawable drawable = typedArrayObtainStyledAttributes2.getDrawable(R.styleable.FloatingOvalButton_float_image_src);
        this.f3100p = typedArrayObtainStyledAttributes2.getColor(R.styleable.FloatingOvalButton_float_image_background_color, context.getColor(R.color.os_altitude_tertiary_color));
        int color = typedArrayObtainStyledAttributes2.getColor(R.styleable.FloatingOvalButton_float_image_tint_color, this.f3101v);
        this.f3101v = color;
        drawable.setTint(color);
        this.f3099n = typedArrayObtainStyledAttributes2.getColor(R.styleable.FloatingOvalButton_float_image_shadow_color, context.getColor(R.color.os_fab_shadow_color_white));
        typedArrayObtainStyledAttributes2.recycle();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f3091a.getLayoutParams();
        layoutParams.width = (int) dimension;
        layoutParams.height = (int) dimension2;
        this.f3091a.setLayoutParams(layoutParams);
        this.f3091a.setImageDrawable(drawable);
        setImageBackgroundColor(this.f3100p);
        setShadowColor(this.f3099n);
        setImagePadding(this.f3092b);
        xi.c.e eVar = new xi.c.e();
        eVar.f20208a = 1.0f;
        eVar.f20209b = 0.8f;
        eVar.f20213f = new FloatValueHolder();
        eVar.f20210c = 350.0f;
        eVar.f20211d = 250.0f;
        eVar.f20212e = 1.2f;
        eVar.B(this).u(new d()).v(new c()).n(new b()).o(new a()).p();
        setWillNotDraw(false);
        Paint paint = new Paint();
        this.f3098i = paint;
        paint.setAntiAlias(true);
        this.f3098i.setDither(true);
    }
}
