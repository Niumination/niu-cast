package com.transsion.widgetslib.widget.shadow;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;
import com.transsion.widgetslib.R;
import hj.h;

/* JADX INFO: loaded from: classes2.dex */
public class ShadowLayout extends FrameLayout {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final float f3077i = 10.0f;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final float f3078n = 3.3f;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f3079p = -2138535800;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final float f3080v = 0.1f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f3081a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f3082b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3083c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f3084d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f3085e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Drawable f3086f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Bitmap f3087g;

    public ShadowLayout(Context context) {
        this(context, null);
    }

    public final void a() {
        int i10 = (int) (this.f3085e + this.f3084d);
        setPadding(i10, i10, i10, i10);
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Bitmap bitmap = this.f3087g;
        if (bitmap != null && !bitmap.isRecycled()) {
            canvas.drawBitmap(this.f3087g, 0.0f, 0.0f, this.f3082b);
        }
        super.dispatchDraw(canvas);
    }

    public int getShadowColor() {
        return this.f3083c;
    }

    public float getShadowDistance() {
        return this.f3085e;
    }

    public float getShadowRadius() {
        return this.f3084d;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Bitmap bitmap = this.f3087g;
        if (bitmap != null) {
            bitmap.recycle();
            this.f3087g = null;
            this.f3086f = null;
        }
    }

    public void setShadowColor(int i10) {
        this.f3083c = i10;
        this.f3086f.setTint(i10);
        Bitmap bitmap = this.f3087g;
        if (bitmap != null) {
            bitmap.recycle();
        }
        Context context = this.f3081a;
        this.f3087g = h.c(context, this.f3086f, (int) (((this.f3085e + this.f3084d) * 2.0f) + context.getResources().getDimensionPixelSize(R.dimen.os_fab_default_size)));
        a();
    }

    public void setShadowDistance(float f10) {
        this.f3085e = f10;
        a();
    }

    public void setShadowRadius(float f10) {
        this.f3084d = Math.max(0.1f, f10);
        if (isInEditMode()) {
            return;
        }
        a();
    }

    public ShadowLayout(Context context, AttributeSet attributeSet, boolean z10) {
        this(context, attributeSet, 0, z10);
    }

    public ShadowLayout(Context context, AttributeSet attributeSet, int i10, boolean z10) {
        super(context, attributeSet, i10);
        Paint paint = new Paint(1);
        this.f3082b = paint;
        this.f3081a = context;
        setWillNotDraw(false);
        setLayerType(2, paint);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ShadowLayout);
        try {
            try {
                setShadowRadius(typedArrayObtainStyledAttributes.getDimension(R.styleable.ShadowLayout_os_shadow_radius, TypedValue.applyDimension(1, 10.0f, getResources().getDisplayMetrics())));
                setShadowDistance(typedArrayObtainStyledAttributes.getDimension(R.styleable.ShadowLayout_os_shadow_distance, TypedValue.applyDimension(1, 3.3f, getResources().getDisplayMetrics())));
                this.f3086f = context.getDrawable(R.drawable.img_shadow);
                if (z10) {
                    setShadowColor(typedArrayObtainStyledAttributes.getColor(R.styleable.ShadowLayout_os_shadow_color, f3079p));
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public ShadowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, true);
    }

    public ShadowLayout(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, true);
    }
}
