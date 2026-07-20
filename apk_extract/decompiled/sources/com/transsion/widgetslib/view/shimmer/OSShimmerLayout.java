package com.transsion.widgetslib.view.shimmer;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import com.transsion.widgetslib.R$attr;
import com.transsion.widgetslib.R$color;
import com.transsion.widgetslib.R$styleable;
import ge.h;
import ke.c;
import pd.j;

/* JADX INFO: loaded from: classes2.dex */
public class OSShimmerLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3333a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Rect f3334b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Paint f3335c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ValueAnimator f3336d;
    public Bitmap e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Bitmap f3337h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Canvas f3338i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f3339j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f3340k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f3341l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f3342m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f3343n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f3344o;
    public float p;
    public float q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public c f3345r;

    public OSShimmerLayout(Context context) {
        this(context, null);
    }

    private float[] getGradientColorDistribution() {
        float[] fArr = {0.0f, 0.5f - (f / 2.0f), (f / 2.0f) + 0.5f, 1.0f};
        float f = this.q;
        return fArr;
    }

    private Bitmap getMaskBitmap() {
        Bitmap bitmapCreateBitmap;
        if (this.f3337h == null) {
            try {
                bitmapCreateBitmap = Bitmap.createBitmap((int) (this.f3334b.width() / this.p), getHeight(), Bitmap.Config.ALPHA_8);
            } catch (OutOfMemoryError unused) {
                System.gc();
                bitmapCreateBitmap = null;
            }
            this.f3337h = bitmapCreateBitmap;
        }
        return this.f3337h;
    }

    private Animator getShimmerAnimation() {
        ValueAnimator valueAnimator = this.f3336d;
        if (valueAnimator != null) {
            return valueAnimator;
        }
        if (this.f3334b == null) {
            this.f3334b = new Rect(0, 0, (int) ((Math.tan(Math.toRadians(Math.abs(this.f3344o))) * ((double) getHeight())) + (((double) (getWidth() * this.p)) / Math.cos(Math.toRadians(Math.abs(this.f3344o))))), getHeight());
        }
        int width = getWidth() + ((int) ((((double) getHeight()) / Math.tan(Math.toRadians(Math.abs(this.f3344o)))) * 2.0d));
        int i8 = -this.f3334b.width();
        int iWidth = this.f3334b.width();
        ValueAnimator valueAnimatorOfInt = this.f3339j ? ValueAnimator.ofInt(width, 0) : ValueAnimator.ofInt(0, width);
        this.f3336d = valueAnimatorOfInt;
        valueAnimatorOfInt.setDuration(this.f3342m);
        this.f3336d.setRepeatCount(-1);
        this.f3336d.addUpdateListener(new h(this, i8, iWidth, 1));
        return this.f3336d;
    }

    public final void a() {
        if (this.f3340k) {
            b();
            c();
        }
    }

    public final void b() {
        ValueAnimator valueAnimator = this.f3336d;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.f3336d.removeAllUpdateListeners();
        }
        this.f3336d = null;
        this.f3335c = null;
        this.f3340k = false;
        this.f3338i = null;
        Bitmap bitmap = this.f3337h;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        this.f3337h.recycle();
        this.f3337h = null;
    }

    public final void c() {
        if (this.f3340k) {
            return;
        }
        if (getWidth() == 0) {
            if (this.f3345r == null) {
                this.f3345r = new c(this, 1);
                getViewTreeObserver().addOnPreDrawListener(this.f3345r);
                return;
            }
            return;
        }
        Animator shimmerAnimation = getShimmerAnimation();
        shimmerAnimation.setInterpolator(new DecelerateInterpolator());
        shimmerAnimation.start();
        this.f3340k = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        if (!this.f3340k || getWidth() <= 0 || getHeight() <= 0) {
            super.dispatchDraw(canvas);
            return;
        }
        super.dispatchDraw(canvas);
        Bitmap maskBitmap = getMaskBitmap();
        this.e = maskBitmap;
        if (maskBitmap == null) {
            return;
        }
        if (this.f3338i == null) {
            this.f3338i = new Canvas(this.e);
        }
        this.f3338i.drawColor(0, PorterDuff.Mode.CLEAR);
        this.f3338i.save();
        this.f3338i.translate(-this.f3333a, 0.0f);
        super.dispatchDraw(this.f3338i);
        this.f3338i.restore();
        if (this.f3335c == null) {
            int i8 = this.f3343n;
            int iArgb = Color.argb(0, Color.red(i8), Color.green(i8), Color.blue(i8));
            float width = getWidth() * this.p;
            float height = this.f3344o >= 0 ? getHeight() : 0.0f;
            float fCos = ((float) Math.cos(Math.toRadians(this.f3344o))) * width;
            float fSin = (((float) Math.sin(Math.toRadians(this.f3344o))) * width) + height;
            int i9 = this.f3343n;
            int[] iArr = {iArgb, i9, i9, iArgb};
            float[] gradientColorDistribution = getGradientColorDistribution();
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            ComposeShader composeShader = new ComposeShader(new LinearGradient(0.0f, height, fCos, fSin, iArr, gradientColorDistribution, tileMode), new BitmapShader(this.e, tileMode, tileMode), PorterDuff.Mode.DST_IN);
            Paint paint = new Paint();
            this.f3335c = paint;
            paint.setAntiAlias(true);
            this.f3335c.setDither(true);
            this.f3335c.setFilterBitmap(true);
            this.f3335c.setShader(composeShader);
        }
        canvas.save();
        canvas.translate(this.f3333a, 0.0f);
        Rect rect = this.f3334b;
        canvas.drawRect(rect.left, 0.0f, rect.width() / this.p, this.f3334b.height(), this.f3335c);
        canvas.restore();
        this.e = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        b();
        super.onDetachedFromWindow();
    }

    public void setAnimationReversed(boolean z2) {
        this.f3339j = z2;
        a();
    }

    public void setGradientCenterColorWidth(float f) {
        if (f <= 0.0f || 1.0f <= f) {
            throw new IllegalArgumentException(String.format("gradientCenterColorWidth value must be higher than %d and less than %d", (byte) 0, (byte) 1));
        }
        this.q = f;
        a();
    }

    public void setMaskWidth(float f) {
        if (f <= 0.0f || 1.0f < f) {
            throw new IllegalArgumentException(String.format("maskWidth value must be higher than %d and less or equal to %d", (byte) 0, (byte) 1));
        }
        this.p = f;
        a();
    }

    public void setShimmerAngle(int i8) {
        if (i8 < -45 || 45 < i8) {
            throw new IllegalArgumentException(String.format("shimmerAngle value must be between %d and %d", (byte) -45, (byte) 45));
        }
        this.f3344o = i8;
        a();
    }

    public void setShimmerAnimationDuration(int i8) {
        this.f3342m = i8;
        a();
    }

    public void setShimmerColor(int i8) {
        this.f3343n = i8;
        a();
    }

    @Override // android.view.View
    public void setVisibility(int i8) {
        super.setVisibility(i8);
        if (i8 == 0) {
            if (this.f3341l) {
                c();
            }
        } else {
            if (this.f3345r != null) {
                getViewTreeObserver().removeOnPreDrawListener(this.f3345r);
                this.f3345r = null;
            }
            b();
        }
    }

    public OSShimmerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OSShimmerLayout(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        setWillNotDraw(false);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.OSShimmerLayout, 0, 0);
        try {
            this.f3344o = typedArrayObtainStyledAttributes.getInteger(R$styleable.OSShimmerLayout_os_shimmer_angle, 45);
            this.f3342m = typedArrayObtainStyledAttributes.getInteger(R$styleable.OSShimmerLayout_os_shimmer_animation_duration, 1500);
            this.f3343n = typedArrayObtainStyledAttributes.getColor(R$styleable.OSShimmerLayout_os_shimmer_color, j.e(getContext(), R$attr.os_fill_base, R$color.os_fill_base_hios));
            this.f3341l = typedArrayObtainStyledAttributes.getBoolean(R$styleable.OSShimmerLayout_os_shimmer_auto_start, true);
            this.p = typedArrayObtainStyledAttributes.getFloat(R$styleable.OSShimmerLayout_os_shimmer_mask_width, 0.9f);
            this.q = typedArrayObtainStyledAttributes.getFloat(R$styleable.OSShimmerLayout_os_shimmer_gradient_center_color_width, 0.3f);
            this.f3339j = typedArrayObtainStyledAttributes.getBoolean(R$styleable.OSShimmerLayout_os_shimmer_reverse_animation, false);
            typedArrayObtainStyledAttributes.recycle();
            setMaskWidth(this.p);
            setGradientCenterColorWidth(this.q);
            setShimmerAngle(this.f3344o);
        } catch (Throwable th2) {
            typedArrayObtainStyledAttributes.recycle();
            throw th2;
        }
    }
}
