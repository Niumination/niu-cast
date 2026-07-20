package com.transsion.widgetslib.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.PathInterpolator;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import hj.h;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class OSMaskImageView extends AppCompatImageView {
    public static final float H = 1.0f;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f2731x = 130;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f2732y = 700;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final float f2733z = 1.15f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RectF f2734a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f2735b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ValueAnimator f2736c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ValueAnimator f2737d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AnimatorSet f2738e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Paint f2739f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Bitmap f2740g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Bitmap f2741i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f2742n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f2743p;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f2744v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public AnimatorListenerAdapter f2745w;

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue instanceof Float) {
                float fFloatValue = ((Float) animatedValue).floatValue();
                OSMaskImageView.this.f2735b.reset();
                OSMaskImageView oSMaskImageView = OSMaskImageView.this;
                oSMaskImageView.f2735b.addCircle(oSMaskImageView.f2734a.centerX(), OSMaskImageView.this.f2734a.centerY(), fFloatValue, Path.Direction.CCW);
                OSMaskImageView.this.invalidate();
            }
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (!(animatedValue instanceof Integer) || OSMaskImageView.this.f2734a.isEmpty()) {
                return;
            }
            OSMaskImageView.this.f2744v = ((Integer) animatedValue).intValue();
            OSMaskImageView.this.invalidate();
        }
    }

    public class c extends AnimatorListenerAdapter {
        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            OSMaskImageView.this.f2742n = false;
            OSMaskImageView.this.setSelected(false);
        }
    }

    public class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue instanceof Float) {
                float fFloatValue = ((Float) animatedValue).floatValue();
                OSMaskImageView.this.setScaleX(fFloatValue);
                OSMaskImageView.this.setScaleY(fFloatValue);
            }
        }
    }

    public class e extends AnimatorListenerAdapter {
        public e() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
            OSMaskImageView.this.f2743p = true;
            OSMaskImageView oSMaskImageView = OSMaskImageView.this;
            oSMaskImageView.f2742n = false;
            oSMaskImageView.f2735b.reset();
            OSMaskImageView.this.invalidate();
            AnimatorListenerAdapter animatorListenerAdapter = OSMaskImageView.this.f2745w;
            if (animatorListenerAdapter != null) {
                animatorListenerAdapter.onAnimationCancel(animator);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (OSMaskImageView.this.f2736c != null && OSMaskImageView.this.f2736c.isRunning()) {
                OSMaskImageView.this.f2736c.cancel();
            }
            OSMaskImageView oSMaskImageView = OSMaskImageView.this;
            oSMaskImageView.setSelected(!oSMaskImageView.f2743p);
            OSMaskImageView.this.setScaleX(1.0f);
            OSMaskImageView.this.setScaleY(1.0f);
            AnimatorListenerAdapter animatorListenerAdapter = OSMaskImageView.this.f2745w;
            if (animatorListenerAdapter != null) {
                animatorListenerAdapter.onAnimationEnd(animator);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            OSMaskImageView.this.setSelected(false);
            OSMaskImageView oSMaskImageView = OSMaskImageView.this;
            oSMaskImageView.f2743p = false;
            oSMaskImageView.f2742n = true;
            AnimatorListenerAdapter animatorListenerAdapter = oSMaskImageView.f2745w;
            if (animatorListenerAdapter != null) {
                animatorListenerAdapter.onAnimationStart(animator);
            }
        }
    }

    public OSMaskImageView(Context context) {
        super(context);
        this.f2734a = new RectF();
        this.f2735b = new Path();
        j();
    }

    private void getSourceImage() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        this.f2740g = h.h(drawable);
        int width = getWidth();
        int height = getHeight();
        Bitmap bitmap = this.f2740g;
        if (bitmap == null || width <= 0 || height <= 0 || bitmap.getWidth() <= 0 || this.f2740g.getHeight() <= 0) {
            return;
        }
        float f10 = width;
        this.f2734a.set(0.0f, 0.0f, f10, height);
        ColorStateList imageTintList = getImageTintList();
        int colorForState = imageTintList == null ? -16776961 : imageTintList.getColorForState(new int[]{R.attr.state_selected}, -16711936);
        this.f2741i = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(this.f2741i);
        float width2 = (f10 * 1.0f) / this.f2740g.getWidth();
        canvas.scale(width2, width2);
        Paint paint = new Paint(this.f2739f);
        paint.setColor(colorForState);
        canvas.drawBitmap(this.f2740g.extractAlpha(), 0.0f, 0.0f, paint);
        if (this.f2736c == null) {
            l();
        }
        this.f2736c.setFloatValues(0.0f, (float) Math.sqrt(Math.pow((((double) this.f2734a.height()) * 1.0d) / 2.0d, 2.0d) + Math.pow((((double) this.f2734a.width()) * 1.0d) / 2.0d, 2.0d)));
    }

    private void j() {
        Paint paint = new Paint(1);
        this.f2739f = paint;
        paint.setDither(true);
        this.f2739f.setFilterBitmap(true);
        l();
        k();
        m();
    }

    public void i() {
        AnimatorSet animatorSet = this.f2738e;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    public final void k() {
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(255, 0);
        this.f2737d = valueAnimatorOfInt;
        valueAnimatorOfInt.setDuration(130L);
        this.f2737d.setInterpolator(new pj.c(0.01f, 0.0f, 0.1f, 1.0f));
        this.f2737d.addUpdateListener(new b());
        this.f2737d.addListener(new c());
    }

    public final void l() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 0.0f);
        this.f2736c = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(250L);
        this.f2736c.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.8f, 1.0f));
        this.f2736c.addUpdateListener(new a());
    }

    public final void m() {
        d dVar = new d();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 1.15f);
        valueAnimatorOfFloat.setDuration(130L);
        valueAnimatorOfFloat.setInterpolator(new pj.c(0.01f, 0.0f, 0.1f, 1.0f));
        valueAnimatorOfFloat.addUpdateListener(dVar);
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(1.15f, 1.0f);
        valueAnimatorOfFloat2.setDuration(570L);
        valueAnimatorOfFloat2.setInterpolator(new pj.c(0.33f, 0.0f, 0.0f, 1.0f));
        valueAnimatorOfFloat2.addUpdateListener(dVar);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f2738e = animatorSet;
        animatorSet.play(valueAnimatorOfFloat2).after(valueAnimatorOfFloat);
        this.f2738e.addListener(new e());
    }

    public boolean n() {
        AnimatorSet animatorSet = this.f2738e;
        return animatorSet != null && animatorSet.isRunning();
    }

    public void o(boolean z10, AnimatorListenerAdapter animatorListenerAdapter) {
        if (this.f2740g == null) {
            getSourceImage();
        }
        if (this.f2740g == null) {
            return;
        }
        this.f2745w = animatorListenerAdapter;
        if (!z10) {
            ValueAnimator valueAnimator = this.f2737d;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                if (this.f2737d == null) {
                    k();
                }
                this.f2737d.end();
                this.f2737d.start();
                return;
            }
            return;
        }
        AnimatorSet animatorSet = this.f2738e;
        if (animatorSet == null || !animatorSet.isRunning()) {
            if (this.f2736c == null) {
                l();
            }
            this.f2736c.end();
            this.f2736c.start();
            if (this.f2738e == null) {
                m();
            }
            Iterator<Animator> it = this.f2738e.getChildAnimations().iterator();
            while (it.hasNext()) {
                it.next().end();
            }
            this.f2738e.start();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.f2736c;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        AnimatorSet animatorSet = this.f2738e;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        ValueAnimator valueAnimator2 = this.f2737d;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
        Bitmap bitmap = this.f2740g;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f2740g.recycle();
            this.f2740g = null;
        }
        Bitmap bitmap2 = this.f2741i;
        if (bitmap2 == null || bitmap2.isRecycled()) {
            return;
        }
        this.f2741i.recycle();
        this.f2741i = null;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f2740g == null) {
            return;
        }
        if (!this.f2742n) {
            int iSaveLayerAlpha = canvas.saveLayerAlpha(this.f2734a, this.f2744v, 31);
            canvas.drawBitmap(this.f2741i, (Rect) null, this.f2734a, this.f2739f);
            canvas.restoreToCount(iSaveLayerAlpha);
        } else {
            canvas.save();
            canvas.clipPath(this.f2735b);
            canvas.drawBitmap(this.f2741i, (Rect) null, this.f2734a, this.f2739f);
            canvas.restore();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void setSelected(boolean z10) {
        super.setSelected(z10);
        this.f2742n = z10;
    }

    public void setSelectedAnim(boolean z10) {
        o(z10, null);
    }

    public OSMaskImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2734a = new RectF();
        this.f2735b = new Path();
        j();
    }

    public OSMaskImageView(Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f2734a = new RectF();
        this.f2735b = new Path();
        j();
    }
}
