package com.transsion.widgetslib.view.swipmenu;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FloatValueHolder;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.widgetslib.R;
import lj.f;
import lj.g;
import lj.h;
import lj.i;
import lj.j;

/* JADX INFO: loaded from: classes2.dex */
public class OSSwipeMenuLayout extends ViewGroup implements lj.a, LifecycleObserver {
    public static final int A0 = 350;
    public static final float B0 = 400.0f;
    public static final float C0 = 1.0f;
    public static final int D0 = 500;
    public static final int E0 = 250;
    public static int F0 = 0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public static final String f2620w0 = "OSSwipeMenuLayout";

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public static boolean f2621x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public static OSSwipeMenuLayout f2622y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public static boolean f2623z0;
    public VelocityTracker H;
    public boolean I;
    public boolean J;
    public boolean K;
    public h L;
    public g M;
    public int N;
    public int O;
    public Context P;
    public lj.c Q;
    public f R;
    public lj.b S;
    public lj.e T;
    public int U;
    public int V;
    public int W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2624a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public int f2625a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2626b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public SpringAnimation f2627b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2628c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public ValueAnimator f2629c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2630d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public boolean f2631d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f2632e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public boolean f2633e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public PointF f2634f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public int f2635f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f2636g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public int f2637g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public boolean f2638h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public PointF f2639i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public int f2640i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public int f2641j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public int f2642k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public int f2643l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public int f2644m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public PointF f2645n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public int f2646n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public float f2647o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f2648p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public int f2649p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public int f2650q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public Rect f2651r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public Rect f2652s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public e f2653t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public int f2654u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Paint f2655v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public int f2656v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Paint f2657w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Paint f2658x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Paint f2659y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f2660z;

    public class a implements DynamicAnimation.OnAnimationUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f2661a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f2662b;

        public a(int i10, int i11) {
            this.f2661a = i10;
            this.f2662b = i11;
        }

        @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener
        public void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f10, float f11) {
            if (OSSwipeMenuLayout.this.f2638h0 && OSSwipeMenuLayout.this.M.o()) {
                float f12 = (f10 / this.f2661a) * 2.0f;
                if (f12 <= 1.0f) {
                    int i10 = (int) ((1.0f - f12) * 255.0f);
                    OSSwipeMenuLayout oSSwipeMenuLayout = OSSwipeMenuLayout.this;
                    oSSwipeMenuLayout.f2644m0 = i10;
                    oSSwipeMenuLayout.f2658x.setAlpha(i10);
                } else {
                    OSSwipeMenuLayout oSSwipeMenuLayout2 = OSSwipeMenuLayout.this;
                    oSSwipeMenuLayout2.f2644m0 = 0;
                    oSSwipeMenuLayout2.f2658x.setAlpha(0);
                }
            }
            OSSwipeMenuLayout.this.scrollTo(this.f2662b + ((int) f10), 0);
        }
    }

    public class b implements DynamicAnimation.OnAnimationEndListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f2664a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f2665b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f2666c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ViewGroup.MarginLayoutParams f2667d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ c f2668e;

        public class a implements ValueAnimator.AnimatorUpdateListener {
            public a() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ViewGroup.MarginLayoutParams marginLayoutParams;
                float animatedFraction = valueAnimator.getAnimatedFraction();
                b bVar = b.this;
                if (bVar.f2664a != null && OSSwipeMenuLayout.this.M != null) {
                    b.this.f2664a.b(animatedFraction);
                }
                b bVar2 = b.this;
                int i10 = bVar2.f2665b;
                if ((i10 != 0 || bVar2.f2666c != 0) && (marginLayoutParams = bVar2.f2667d) != null) {
                    float f10 = 1.0f - animatedFraction;
                    marginLayoutParams.setMargins(marginLayoutParams.leftMargin, (int) (i10 * f10), marginLayoutParams.rightMargin, (int) (bVar2.f2666c * f10));
                }
                if (OSSwipeMenuLayout.this.f2638h0 && OSSwipeMenuLayout.this.M.o()) {
                    float f11 = 2.0f * animatedFraction;
                    if (f11 <= 1.0f) {
                        OSSwipeMenuLayout.this.f2659y.setAlpha((int) ((1.0f - animatedFraction) * 255.0f));
                        OSSwipeMenuLayout oSSwipeMenuLayout = OSSwipeMenuLayout.this;
                        float f12 = 1.0f - f11;
                        oSSwipeMenuLayout.f2646n0 = (int) (255.0f * f12);
                        oSSwipeMenuLayout.f2647o0 = f12;
                    } else {
                        OSSwipeMenuLayout.this.f2659y.setAlpha(0);
                        OSSwipeMenuLayout oSSwipeMenuLayout2 = OSSwipeMenuLayout.this;
                        oSSwipeMenuLayout2.f2646n0 = 0;
                        oSSwipeMenuLayout2.f2647o0 = 0.0f;
                    }
                }
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ViewGroup.LayoutParams layoutParams = OSSwipeMenuLayout.this.getLayoutParams();
                layoutParams.height = (int) fFloatValue;
                OSSwipeMenuLayout.this.setLayoutParams(layoutParams);
            }
        }

        /* JADX INFO: renamed from: com.transsion.widgetslib.view.swipmenu.OSSwipeMenuLayout$b$b, reason: collision with other inner class name */
        public class C0078b implements Animator.AnimatorListener {
            public C0078b() {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                b bVar = b.this;
                if (bVar.f2668e != null && OSSwipeMenuLayout.this.M != null) {
                    b bVar2 = b.this;
                    bVar2.f2668e.a(OSSwipeMenuLayout.this.M.c());
                }
                b bVar3 = b.this;
                if (bVar3.f2664a != null && OSSwipeMenuLayout.this.M != null) {
                    b bVar4 = b.this;
                    bVar4.f2664a.a(OSSwipeMenuLayout.this.M.c());
                }
                OSSwipeMenuLayout.f2621x0 = false;
                OSSwipeMenuLayout.this.f2660z = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b bVar = b.this;
                if (bVar.f2668e != null && OSSwipeMenuLayout.this.M != null) {
                    b bVar2 = b.this;
                    bVar2.f2668e.a(OSSwipeMenuLayout.this.M.c());
                }
                b bVar3 = b.this;
                if (bVar3.f2664a != null && OSSwipeMenuLayout.this.M != null) {
                    b bVar4 = b.this;
                    bVar4.f2664a.a(OSSwipeMenuLayout.this.M.c());
                }
                OSSwipeMenuLayout.f2621x0 = false;
                OSSwipeMenuLayout.this.f2660z = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }

        public b(d dVar, int i10, int i11, ViewGroup.MarginLayoutParams marginLayoutParams, c cVar) {
            this.f2664a = dVar;
            this.f2665b = i10;
            this.f2666c = i11;
            this.f2667d = marginLayoutParams;
            this.f2668e = cVar;
        }

        @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener
        public void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z10, float f10, float f11) {
            if (OSSwipeMenuLayout.this.f2629c0 != null && OSSwipeMenuLayout.this.f2629c0.isRunning()) {
                OSSwipeMenuLayout.this.f2629c0.cancel();
            }
            OSSwipeMenuLayout oSSwipeMenuLayout = OSSwipeMenuLayout.this;
            oSSwipeMenuLayout.f2629c0 = ValueAnimator.ofFloat(oSSwipeMenuLayout.getHeight(), 0.0f);
            OSSwipeMenuLayout.this.f2629c0.setDuration(300L);
            OSSwipeMenuLayout.this.f2629c0.addUpdateListener(new a());
            OSSwipeMenuLayout.this.f2629c0.addListener(new C0078b());
            OSSwipeMenuLayout.this.f2629c0.setInterpolator(new pj.c(0.25f, 0.0f, 0.0f, 1.0f));
            OSSwipeMenuLayout.this.f2629c0.start();
        }
    }

    public interface c {
        void a(int i10);
    }

    public interface d extends c {
        void b(float f10);
    }

    public interface e {
        void a(View view, int i10, int i11);
    }

    public OSSwipeMenuLayout(Context context) {
        this(context, null, 0);
    }

    public static void E() {
        OSSwipeMenuLayout oSSwipeMenuLayout = f2622y0;
        if (oSSwipeMenuLayout != null) {
            oSSwipeMenuLayout.s();
            f2622y0.h();
        }
    }

    public static OSSwipeMenuLayout getViewCache() {
        return f2622y0;
    }

    public static void i0() {
        i.p();
        if (f2622y0 != null) {
            f2622y0 = null;
        }
    }

    public final void C(MotionEvent motionEvent) {
        if (this.H == null) {
            this.H = VelocityTracker.obtain();
        }
        this.H.addMovement(motionEvent);
    }

    public final void D() {
        OSSwipeMenuLayout oSSwipeMenuLayout = f2622y0;
        if (oSSwipeMenuLayout == null || oSSwipeMenuLayout == this || !oSSwipeMenuLayout.I) {
            return;
        }
        oSSwipeMenuLayout.f2633e0 = true;
        oSSwipeMenuLayout.s();
        f2622y0.h();
    }

    public int F() {
        if (getChildCount() > 0) {
            return this.f2654u0;
        }
        return 0;
    }

    public int G() {
        return 0;
    }

    public void H(int i10) {
        this.f2656v0 = (int) (this.f2656v0 + (lj.d.a(i10, this.f2635f0, getMeasuredWidth()) * this.f2635f0));
        super.scrollTo(j.b(getScrollX(), this.W, this.f2625a0) + this.f2656v0, 0);
    }

    public final void I(int i10) {
        if (Math.abs(getScrollX()) > this.f2630d) {
            r0(i10);
        } else {
            i(i10);
        }
    }

    public float J(float f10) {
        return (float) Math.sin((float) (((double) (f10 - 0.5f)) * 0.4712389167638204d));
    }

    public void K(RecyclerView.ViewHolder viewHolder, c cVar) {
        M(viewHolder, cVar, null);
    }

    public void L(RecyclerView.ViewHolder viewHolder, d dVar) {
        M(viewHolder, null, dVar);
    }

    public void M(RecyclerView.ViewHolder viewHolder, c cVar, d dVar) {
        if (viewHolder != null) {
            viewHolder.setIsRecyclable(false);
        }
        lj.b bVar = this.S;
        if (bVar == null || !bVar.n(getScrollX())) {
            return;
        }
        SpringAnimation springAnimation = this.f2627b0;
        if (springAnimation != null && springAnimation.isRunning()) {
            this.f2627b0.cancel();
        }
        this.f2627b0 = new SpringAnimation(new FloatValueHolder());
        int measuredWidth = this.J ? getMeasuredWidth() - (this.M.k() / this.M.i().size()) : -(getMeasuredWidth() - (this.M.k() / this.M.i().size()));
        this.f2627b0.setSpring(new SpringForce(measuredWidth).setStiffness(400.0f).setDampingRatio(1.0f));
        this.f2627b0.addUpdateListener(new a(measuredWidth, getScrollX()));
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
        this.f2627b0.addEndListener(new b(dVar, marginLayoutParams.topMargin, marginLayoutParams.bottomMargin, marginLayoutParams, cVar));
        f2621x0 = true;
        this.f2660z = true;
        this.I = false;
        f2622y0 = null;
        this.f2627b0.start();
    }

    public final void N(Canvas canvas, int i10, int i11, float f10, int i12, float f11, Drawable drawable, boolean z10) {
        if (drawable != null && (drawable instanceof ColorDrawable)) {
            this.f2655v.setColor(((ColorDrawable) drawable).getColor());
        }
        if (i12 == i11 - 1) {
            if (drawable == null && (!this.f2638h0 || !z10)) {
                this.f2655v.setColor(this.f2642k0);
            }
            canvas.drawRect(f11, 0.0f, getMeasuredWidth() + i10, this.f2628c, this.f2655v);
            return;
        }
        if (drawable == null && (!this.f2638h0 || !z10)) {
            this.f2655v.setColor(this.f2643l0);
        }
        canvas.drawRect(f11, 0.0f, f10 + f11 + 1.0f, this.f2628c, this.f2655v);
    }

    public final void O(Canvas canvas, int i10, int i11, float f10, int i12, float f11, Drawable drawable, boolean z10) {
        if (drawable == null || (this.f2638h0 && z10)) {
            this.f2655v.setColor(0);
        } else {
            this.f2655v.setColor(((ColorDrawable) drawable).getColor());
        }
        if (i12 == i11 - 1) {
            if (drawable == null && (!this.f2638h0 || !z10)) {
                this.f2655v.setColor(this.f2642k0);
            }
            canvas.drawRect(f11, 0.0f, getMeasuredWidth() + i10, this.f2628c, this.f2655v);
            return;
        }
        if (drawable == null && (!this.f2638h0 || !z10)) {
            this.f2655v.setColor(this.f2643l0);
        }
        canvas.drawRect(f11, 0.0f, f11 + f10, this.f2628c, this.f2655v);
    }

    public final void P(Canvas canvas, int i10, int i11, float f10, int i12, float f11, Drawable drawable, boolean z10) {
        if (drawable != null) {
            this.f2655v.setColor(((ColorDrawable) drawable).getColor());
        } else if (drawable == null && this.f2638h0) {
            this.f2655v.setColor(0);
        }
        if (i12 == i11 - 1) {
            if (drawable == null && (!this.f2638h0 || !z10)) {
                this.f2655v.setColor(this.f2642k0);
            }
            canvas.drawRect(f11, 0.0f, getMeasuredWidth() + i10, this.f2628c, this.f2655v);
            return;
        }
        if (drawable == null && (!this.f2638h0 || !z10)) {
            this.f2655v.setColor(this.f2643l0);
        }
        canvas.drawRect(f11, 0.0f, f11 + f10, this.f2628c, this.f2655v);
    }

    public final void Q(Canvas canvas, int i10, int i11, float f10, i iVar, Drawable drawable) {
        float height = iVar.e().getHeight();
        float width = iVar.e().getWidth();
        float fA = t.a.a(iVar.o(), width, 2.0f, f10);
        float f11 = (this.f2628c - height) / 2.0f;
        if (drawable != null || this.f2638h0) {
            if (drawable != null) {
                this.f2655v.setColor(((ColorDrawable) drawable).getColor());
            } else if (i11 == i10 - 1) {
                this.f2655v.setColor(this.f2641j0);
            } else {
                this.f2655v.setColor(this.f2640i0);
            }
            canvas.drawCircle((width / 2.0f) + fA, (height / 2.0f) + f11, this.M.f(), this.f2655v);
        }
        canvas.drawBitmap(iVar.e(), fA, (this.f2628c - height) / 2.0f, this.f2658x);
    }

    public final void R(Canvas canvas, int i10, int i11, float f10, i iVar, Drawable drawable) {
        float fO;
        int i12;
        float height = iVar.e().getHeight();
        float width = iVar.e().getWidth();
        int i13 = i10 - 1;
        if (i11 == i13) {
            fO = ((((getMeasuredWidth() + getScrollX()) - f10) / 2.0f) - (width / 2.0f)) + f10;
            i12 = this.f2628c;
        } else {
            fO = ((iVar.o() / 2.0f) - (width / 2.0f)) + f10;
            i12 = this.f2628c;
        }
        float f11 = (i12 / 2.0f) - (height / 2.0f);
        if (drawable != null || this.f2638h0) {
            float f12 = this.M.f();
            if (drawable != null) {
                ColorDrawable colorDrawable = (ColorDrawable) drawable;
                this.f2655v.setColor(colorDrawable.getColor());
                this.f2657w.setColor(colorDrawable.getColor());
            } else {
                this.f2657w.setColor(this.f2641j0);
                this.f2655v.setColor(this.f2640i0);
            }
            if (this.f2638h0) {
                this.f2655v.setAlpha(this.f2644m0);
                this.f2657w.setAlpha(this.f2646n0);
            }
            if (i11 == i13) {
                if (this.f2638h0) {
                    f12 = (float) (((double) (this.f2647o0 + 1.0f)) * 0.5d * ((double) f12));
                }
                canvas.drawCircle((width / 2.0f) + fO, (height / 2.0f) + f11, f12, this.f2657w);
            } else {
                canvas.drawCircle((width / 2.0f) + fO, (height / 2.0f) + f11, this.M.f(), this.f2655v);
            }
        }
        Bitmap bitmapE = iVar.e();
        float width2 = bitmapE.getWidth();
        float height2 = bitmapE.getHeight();
        if (i11 != i13) {
            canvas.drawBitmap(iVar.e(), fO, f11, this.f2658x);
            return;
        }
        this.f2651r0.set((int) fO, (int) f11, (int) (fO + width2), (int) (f11 + height2));
        float f13 = this.f2647o0;
        float f14 = (float) (((double) (f13 + 1.0f)) * 0.5d * ((double) width2));
        float f15 = (float) (((double) (f13 + 1.0f)) * 0.5d * ((double) height2));
        float f16 = fO + ((width2 - f14) / 2.0f);
        float f17 = f11 + ((height2 - f15) / 2.0f);
        this.f2652s0.set((int) f16, (int) f17, (int) (f16 + f14), (int) (f17 + f15));
        canvas.drawBitmap(iVar.e(), (Rect) null, this.f2652s0, this.f2659y);
    }

    public final void S(Canvas canvas, int i10, int i11, float f10, i iVar, Drawable drawable, float f11) {
        float height = iVar.e().getHeight();
        float width = iVar.e().getWidth();
        float fA = t.a.a(f11, width, 2.0f, f10);
        float f12 = (this.f2628c - height) / 2.0f;
        if (drawable != null || this.f2638h0) {
            if (drawable != null) {
                this.f2655v.setColor(((ColorDrawable) drawable).getColor());
            } else if (i11 == i10 - 1) {
                this.f2655v.setColor(this.f2641j0);
            } else {
                this.f2655v.setColor(this.f2640i0);
            }
            canvas.drawCircle((width / 2.0f) + fA, (height / 2.0f) + f12, this.M.f(), this.f2655v);
        }
        canvas.drawBitmap(iVar.e(), fA, (this.f2628c - height) / 2.0f, this.f2658x);
    }

    public final void T(Canvas canvas, float f10, i iVar) {
        this.f2655v.setTextSize(iVar.j());
        this.f2655v.setColor(iVar.l());
        Paint.FontMetrics fontMetrics = this.f2655v.getFontMetrics();
        float fMeasureText = this.f2655v.measureText(iVar.h());
        float f11 = fontMetrics.bottom;
        canvas.drawText(iVar.h(), t.a.a(iVar.o(), fMeasureText, 2.0f, f10), (int) ((this.f2628c / 2) + (((f11 - fontMetrics.top) / 2.0f) - f11)), this.f2655v);
    }

    public final void U(Canvas canvas, int i10, int i11, float f10, int i12, float f11, i iVar) {
        int i13 = i11 - 1;
        if (i12 == i13) {
            canvas.drawRect(f11, 0.0f, getMeasuredWidth() + i10, this.f2628c, this.f2655v);
        } else {
            canvas.drawRect(f11, 0.0f, f11 + f10, this.f2628c, this.f2655v);
        }
        this.f2655v.setTextSize(iVar.j());
        this.f2655v.setColor(iVar.l());
        Paint.FontMetrics fontMetrics = this.f2655v.getFontMetrics();
        float fMeasureText = this.f2655v.measureText(iVar.h());
        float f12 = fontMetrics.bottom;
        float f13 = (this.f2628c / 2.0f) + (((f12 - fontMetrics.top) / 2.0f) - f12);
        if (i12 == i13) {
            canvas.drawText(iVar.h(), (((i10 - (i13 * f10)) - fMeasureText) / 2.0f) + f11, f13, this.f2655v);
        } else {
            canvas.drawText(iVar.h(), ((iVar.o() / 2) - (fMeasureText / 2.0f)) + f11, f13, this.f2655v);
        }
    }

    public final void V(Canvas canvas, int i10, int i11, float f10, int i12, float f11, Drawable drawable, boolean z10) {
        if (drawable != null && (drawable instanceof ColorDrawable)) {
            this.f2655v.setColor(((ColorDrawable) drawable).getColor());
        }
        if (i12 != i11 - 1) {
            if (drawable == null && (!this.f2638h0 || !z10)) {
                this.f2655v.setColor(this.f2643l0);
            }
            canvas.drawRect((-(f10 + f11)) - 1.0f, 0.0f, -f11, this.f2628c, this.f2655v);
            return;
        }
        if (drawable == null && (!this.f2638h0 || !z10)) {
            this.f2655v.setColor(this.f2642k0);
        }
        float f12 = i10;
        canvas.drawRect(f12, 0.0f, f12 + f10, this.f2628c, this.f2655v);
    }

    public final void W(Canvas canvas, int i10, int i11, float f10, int i12, float f11, Drawable drawable, boolean z10) {
        if (drawable == null || (this.f2638h0 && z10)) {
            this.f2655v.setColor(0);
        } else {
            this.f2655v.setColor(((ColorDrawable) drawable).getColor());
        }
        int i13 = i11 - 1;
        if (i12 == i13) {
            if (drawable == null && !this.f2638h0) {
                this.f2655v.setColor(this.f2642k0);
            }
            canvas.drawRect(i10, 0.0f, (-f10) * i13, this.f2628c, this.f2655v);
            return;
        }
        if (drawable == null && !this.f2638h0) {
            this.f2655v.setColor(this.f2643l0);
        }
        canvas.drawRect(-(f10 + f11), 0.0f, -f11, this.f2628c, this.f2655v);
    }

    public final void X(Canvas canvas, int i10, int i11, float f10, int i12, float f11, Drawable drawable, boolean z10) {
        if (drawable != null) {
            this.f2655v.setColor(((ColorDrawable) drawable).getColor());
        } else if (drawable == null && this.f2638h0 && z10) {
            this.f2655v.setColor(0);
        }
        if (i12 != i11 - 1) {
            if (drawable == null && (!this.f2638h0 || !z10)) {
                this.f2655v.setColor(this.f2643l0);
            }
            canvas.drawRect(-(f10 + f11), 0.0f, -f11, this.f2628c, this.f2655v);
            return;
        }
        if (drawable == null && (!this.f2638h0 || !z10)) {
            this.f2655v.setColor(this.f2642k0);
        }
        float f12 = i10;
        canvas.drawRect(f12, 0.0f, f12 + f10, this.f2628c, this.f2655v);
    }

    public final void Y(Canvas canvas, int i10, int i11, float f10, i iVar, Drawable drawable) {
        float height = iVar.e().getHeight();
        float width = iVar.e().getWidth();
        float fA = t.a.a(iVar.o(), width, 2.0f, -(f10 + iVar.o()));
        float f11 = (this.f2628c - height) / 2.0f;
        if (drawable != null || this.f2638h0) {
            if (drawable != null) {
                this.f2655v.setColor(((ColorDrawable) drawable).getColor());
            } else if (i11 == i10 - 1) {
                this.f2655v.setColor(this.f2641j0);
            } else {
                this.f2655v.setColor(this.f2640i0);
            }
            canvas.drawCircle((width / 2.0f) + fA, (height / 2.0f) + f11, this.M.f(), this.f2655v);
        }
        canvas.drawBitmap(iVar.e(), fA, f11, this.f2658x);
    }

    public final void Z(Canvas canvas, int i10, int i11, float f10, i iVar, Drawable drawable, float f11) {
        float fA;
        int i12;
        float height = iVar.e().getHeight();
        float width = iVar.e().getWidth();
        int i13 = i10 - 1;
        if (i11 == i13) {
            fA = (((((-f11) * i13) - getScrollX()) - width) / 2.0f) + getScrollX();
            i12 = this.f2628c;
        } else {
            fA = t.a.a(iVar.o(), width, 2.0f, -(f10 + iVar.o()));
            i12 = this.f2628c;
        }
        float f12 = (i12 - height) / 2.0f;
        if (drawable != null || this.f2638h0) {
            float f13 = this.M.f();
            if (drawable != null) {
                ColorDrawable colorDrawable = (ColorDrawable) drawable;
                this.f2655v.setColor(colorDrawable.getColor());
                this.f2657w.setColor(colorDrawable.getColor());
            } else {
                this.f2657w.setColor(this.f2641j0);
                this.f2655v.setColor(this.f2640i0);
            }
            if (this.f2638h0) {
                this.f2655v.setAlpha(this.f2644m0);
                this.f2657w.setAlpha(this.f2646n0);
            }
            if (i11 == i13) {
                if (this.f2638h0) {
                    f13 = (float) (((double) (this.f2647o0 + 1.0f)) * 0.5d * ((double) f13));
                }
                canvas.drawCircle((width / 2.0f) + fA, (height / 2.0f) + f12, f13, this.f2657w);
            } else {
                canvas.drawCircle((width / 2.0f) + fA, (height / 2.0f) + f12, this.M.f(), this.f2655v);
            }
        }
        Bitmap bitmapE = iVar.e();
        int width2 = bitmapE.getWidth();
        int height2 = bitmapE.getHeight();
        if (i11 != i13) {
            canvas.drawBitmap(iVar.e(), fA, f12, this.f2658x);
            return;
        }
        int i14 = (int) fA;
        int i15 = (int) f12;
        this.f2651r0.set(i14, i15, i14 + width2, i15 + height2);
        float f14 = this.f2647o0;
        float f15 = (float) (((double) (f14 + 1.0f)) * 0.5d * ((double) width2));
        float f16 = (float) (((double) (f14 + 1.0f)) * 0.5d * ((double) height2));
        float f17 = fA + ((width2 - f15) / 2.0f);
        float f18 = f12 + ((height2 - f16) / 2.0f);
        this.f2652s0.set((int) f17, (int) f18, (int) (f17 + f15), (int) (f18 + f16));
        canvas.drawBitmap(iVar.e(), (Rect) null, this.f2652s0, this.f2659y);
    }

    @Override // lj.a
    public boolean a() {
        lj.c cVar = this.Q;
        return (cVar == null || cVar.m(getScrollX())) ? false : true;
    }

    public final void a0(Canvas canvas, int i10, int i11, float f10, i iVar, Drawable drawable, float f11) {
        float fA;
        float height = iVar.e().getHeight();
        float width = iVar.e().getWidth();
        if ((-getScrollX()) < this.M.k()) {
            fA = t.a.a(f11, width, 2.0f, (this.M.e(i11) - iVar.o()) + getScrollX());
        } else {
            fA = t.a.a(f11, width, 2.0f, ((this.M.g() * (Math.abs(getScrollX()) - this.M.k())) / 2.0f) + ((((i10 - i11) * f11) + getScrollX()) - f11) + this.M.j());
        }
        float f12 = (this.f2628c - height) / 2.0f;
        if (drawable != null || this.f2638h0) {
            if (drawable != null) {
                this.f2655v.setColor(((ColorDrawable) drawable).getColor());
            } else if (i11 == i10 - 1) {
                this.f2655v.setColor(this.f2641j0);
            } else {
                this.f2655v.setColor(this.f2640i0);
            }
            canvas.drawCircle((width / 2.0f) + fA, (height / 2.0f) + f12, this.M.f(), this.f2655v);
        }
        canvas.drawBitmap(iVar.e(), fA, f12, this.f2658x);
    }

    @Override // lj.a
    public void b() {
        f(this.U);
    }

    public final void b0(Canvas canvas, float f10, i iVar) {
        this.f2655v.setTextSize(iVar.j());
        this.f2655v.setColor(iVar.l());
        Paint.FontMetrics fontMetrics = this.f2655v.getFontMetrics();
        float fMeasureText = this.f2655v.measureText(iVar.h());
        float f11 = fontMetrics.bottom;
        canvas.drawText(iVar.h(), t.a.a(iVar.o(), fMeasureText, 2.0f, -(f10 + iVar.o())), (this.f2628c / 2.0f) + (((f11 - fontMetrics.top) / 2.0f) - f11), this.f2655v);
    }

    @Override // lj.a
    public boolean c() {
        f fVar = this.R;
        return (fVar == null || fVar.m(getScrollX())) ? false : true;
    }

    public final void c0(Canvas canvas, int i10, int i11, float f10, int i12, float f11, i iVar) {
        this.f2655v.setTextSize(iVar.j());
        this.f2655v.setColor(iVar.l());
        Paint.FontMetrics fontMetrics = this.f2655v.getFontMetrics();
        float fMeasureText = this.f2655v.measureText(iVar.h());
        float f12 = fontMetrics.bottom;
        float f13 = (this.f2628c / 2.0f) + (((f12 - fontMetrics.top) / 2.0f) - f12);
        int i13 = i11 - 1;
        if (i12 == i13) {
            float f14 = i10;
            canvas.drawText(iVar.h(), (((((-f10) * i13) - f14) - fMeasureText) / 2.0f) + f14, f13, this.f2655v);
        } else {
            canvas.drawText(iVar.h(), t.a.a(iVar.o(), fMeasureText, 2.0f, -(f11 + iVar.o())), f13, this.f2655v);
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.T.b()) {
            f0();
        }
    }

    @Override // lj.a
    public boolean d() {
        return this.J ? n() : p();
    }

    public final int d0(MotionEvent motionEvent, int i10) {
        int x10 = (int) (motionEvent.getX() - getScrollX());
        int iJ = this.S.j();
        int i11 = iJ / 2;
        float f10 = iJ;
        float f11 = i11;
        return Math.min(i10 > 0 ? Math.round(Math.abs(((J(Math.min(1.0f, (Math.abs(x10) * 1.0f) / f10)) * f11) + f11) / i10) * 1000.0f) * 4 : (int) (((Math.abs(x10) / f10) + 1.0f) * 100.0f), this.U);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.I || this.M.i().isEmpty() || f2621x0) {
            f2623z0 = false;
            D();
            return super.dispatchTouchEvent(motionEvent);
        }
        C(motionEvent);
        int action = motionEvent.getAction();
        boolean z10 = true;
        if (action != 0) {
            if (action == 1 || action == 3) {
                if (!this.T.f10037b.f10055k) {
                    s();
                }
                if (motionEvent.getAction() == 1 && this.S.n(getScrollX()) && Math.abs(motionEvent.getX() - this.f2645n.x) < this.f2624a) {
                    int iF = this.S.f(getMeasuredWidth(), getMeasuredHeight(), motionEvent, this.f2638h0);
                    this.f2631d0 = iF >= 0 && iF < this.M.i().size();
                    if (this.f2653t0 != null && iF >= 0 && iF < this.M.i().size()) {
                        this.f2653t0.a(null, this.M.i().get(iF).f(), iF);
                    }
                }
                if (Math.abs(motionEvent.getRawX() - this.f2639i.x) > this.f2624a) {
                    this.f2648p = true;
                }
                if (this.K && this.f2648p) {
                    this.H.computeCurrentVelocity(1000, this.V);
                    int xVelocity = (int) this.H.getXVelocity(this.f2626b);
                    if (this.J ? xVelocity > 0 : xVelocity < 0) {
                        z10 = false;
                    }
                    boolean zP0 = p0(xVelocity);
                    int iD0 = d0(motionEvent, xVelocity);
                    int scrollX = getScrollX();
                    int i10 = this.f2625a0;
                    if ((scrollX >= i10 && (!this.J ? z10 && zP0 : !z10)) || (scrollX <= this.W && (!z10 || !zP0))) {
                        f2622y0 = this;
                        this.T.u(scrollX, this.W, i10);
                        invalidate();
                    } else if (xVelocity < 0) {
                        if (this.J) {
                            if (zP0) {
                                s0(xVelocity);
                            } else {
                                r0(iD0);
                            }
                        } else if (zP0) {
                            q0(xVelocity);
                        } else if ((-getScrollX()) > this.f2630d) {
                            j();
                        } else {
                            i(iD0);
                        }
                    } else if (xVelocity <= 0) {
                        I(iD0);
                    } else if (this.J) {
                        if (zP0) {
                            q0(xVelocity);
                        } else if (getScrollX() > this.f2630d) {
                            j();
                        } else {
                            i(iD0);
                        }
                    } else if (zP0) {
                        s0(xVelocity);
                    } else {
                        r0(iD0);
                    }
                } else if (this.J) {
                    if (getScrollX() > this.f2624a) {
                        if (motionEvent.getX() < getWidth() - getScrollX()) {
                            h();
                        } else if (!this.f2631d0) {
                            I(this.U);
                        }
                    } else if ((-getScrollX()) > this.f2624a) {
                        this.T.u(getScrollX(), this.W, this.f2625a0);
                        invalidate();
                    } else {
                        h();
                    }
                } else if ((-getScrollX()) > this.f2624a) {
                    if (motionEvent.getX() > (-getScrollX())) {
                        h();
                    } else if (!this.f2631d0) {
                        I(this.U);
                    }
                } else if (getScrollX() > this.f2624a) {
                    this.T.u(getScrollX(), this.W, this.f2625a0);
                    invalidate();
                } else {
                    h();
                }
                j0();
                f2623z0 = false;
                this.K = false;
                this.f2631d0 = false;
            }
        } else {
            if (f2623z0) {
                return false;
            }
            f2623z0 = true;
            this.f2648p = false;
            this.f2636g = true;
            if (!this.T.f10037b.f10055k) {
                s();
            }
            m0();
            D();
            this.f2634f.set(motionEvent.getRawX(), motionEvent.getRawY());
            this.f2639i.set(motionEvent.getRawX(), motionEvent.getRawY());
            this.f2645n.set(motionEvent.getX(), motionEvent.getY());
            this.f2626b = motionEvent.getPointerId(0);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // lj.a
    public boolean e() {
        return a() || p();
    }

    public final void e0(Context context, AttributeSet attributeSet, int i10) {
        this.P = context;
        this.N = hj.h.e(context, this.N);
        this.O = ui.a.d(this.P, this.O);
        this.f2624a = ViewConfiguration.get(this.P).getScaledTouchSlop();
        float f10 = getResources().getDisplayMetrics().density;
        this.f2649p0 = (int) (500.0f * f10);
        this.f2650q0 = (int) (f10 * 250.0f);
        this.I = true;
        this.J = true;
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SwipeMenuLayout, i10, 0);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i11 = 0; i11 < indexCount; i11++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i11);
            if (index == R.styleable.SwipeMenuLayout_SwipeMenuLayoutSwipeEnable) {
                this.I = typedArrayObtainStyledAttributes.getBoolean(index, true);
            } else if (index == R.styleable.SwipeMenuLayout_SwipeMenuLayoutLeftSwipe) {
                this.J = typedArrayObtainStyledAttributes.getBoolean(index, true);
            }
        }
        this.J = !ui.a.s();
        typedArrayObtainStyledAttributes.recycle();
        this.M = new g(this.P);
        l0();
        this.V = ViewConfiguration.get(getContext()).getScaledMaximumFlingVelocity();
        this.T = new lj.e(getContext());
        setWillNotDraw(false);
        this.f2655v = new Paint();
        this.f2657w = new Paint();
        this.f2655v.setAntiAlias(true);
        this.f2657w.setAntiAlias(true);
        this.f2655v.setColor(-65536);
        this.f2658x = new Paint();
        this.f2659y = new Paint();
        int i12 = context.getResources().getConfiguration().uiMode & 48;
        if (F0 != i12) {
            F0 = i12;
            i.q(getContext());
        }
        this.f2638h0 = hj.h.f7214g[0].equalsIgnoreCase(hj.h.o());
        this.f2640i0 = ContextCompat.getColor(this.P, R.color.os_altitude_secondary_color);
        this.f2641j0 = ContextCompat.getColor(this.P, R.color.os_red_basic_color);
        this.f2642k0 = ContextCompat.getColor(this.P, R.color.os_red_basic_color);
        this.f2643l0 = ContextCompat.getColor(this.P, R.color.os_gray_solid_tertiary_color);
        this.f2651r0 = new Rect();
        this.f2652s0 = new Rect();
    }

    @Override // lj.a
    public void f(int i10) {
        lj.c cVar = this.Q;
        if (cVar != null) {
            this.S = cVar;
            r0(i10);
        }
    }

    public final void f0() {
        this.f2635f0 = this.T.g() - getScrollX();
        scrollTo(this.T.g(), 0);
        invalidate();
    }

    @Override // lj.a
    public boolean g() {
        f fVar = this.R;
        return fVar != null && fVar.o(getScrollX());
    }

    public boolean g0() {
        return this.J;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // lj.a
    public void h() {
        i(this.U);
    }

    public boolean h0() {
        return this.I;
    }

    @Override // lj.a
    public void i(int i10) {
        View view = this.f2632e;
        if (view != null) {
            view.setLongClickable(true);
        }
        lj.b bVar = this.S;
        if (bVar != null) {
            bVar.a(this.T, getScrollX(), i10);
            invalidate();
        }
        f2622y0 = null;
    }

    @Override // lj.a
    public void j() {
        r0(this.U);
    }

    public final void j0() {
        VelocityTracker velocityTracker = this.H;
        if (velocityTracker != null) {
            velocityTracker.clear();
            this.H.recycle();
            this.H = null;
        }
    }

    @Override // lj.a
    public void k() {
        f fVar = this.R;
        if (fVar != null) {
            this.S = fVar;
            h();
        }
    }

    public void k0() {
        SpringAnimation springAnimation = this.f2627b0;
        if (springAnimation != null && springAnimation.isRunning()) {
            this.f2627b0.cancel();
        }
        ValueAnimator valueAnimator = this.f2629c0;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.f2629c0.cancel();
    }

    @Override // lj.a
    public void l(int i10) {
        f fVar = this.R;
        if (fVar != null) {
            this.S = fVar;
            r0(i10);
        }
    }

    public final void l0() {
        if (this.J && this.Q == null) {
            lj.c cVar = new lj.c(1, this.M);
            this.Q = cVar;
            this.S = cVar;
        }
        if (this.J || this.R != null) {
            return;
        }
        f fVar = new f(-1, this.M);
        this.R = fVar;
        this.S = fVar;
    }

    @Override // lj.a
    public boolean m() {
        return q() || g();
    }

    public final void m0() {
        this.f2656v0 = 0;
        this.f2633e0 = false;
    }

    @Override // lj.a
    public boolean n() {
        lj.c cVar = this.Q;
        return cVar != null && cVar.n(getScrollX());
    }

    public void n0(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder == null) {
            return;
        }
        viewHolder.setIsRecyclable(true);
        viewHolder.itemView.scrollTo(0, 0);
        this.I = true;
    }

    @Override // lj.a
    public void o() {
        l(this.U);
    }

    public OSSwipeMenuLayout o0(boolean z10) {
        this.J = !z10;
        l0();
        return this;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        k0();
        i0();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i10;
        float fG;
        System.currentTimeMillis();
        super.onDraw(canvas);
        g gVar = this.M;
        if (gVar == null || gVar.i().size() <= 0) {
            return;
        }
        canvas.save();
        int scrollX = getScrollX();
        if (!this.J ? scrollX < 0 : scrollX > 0) {
            if (!this.f2660z) {
                int size = this.M.i().size();
                float f10 = size;
                float fAbs = Math.abs(scrollX / f10);
                int i11 = 0;
                while (i11 < size) {
                    float f11 = i11;
                    float measuredWidth = (fAbs * f11) + (this.J ? getMeasuredWidth() : 0);
                    i iVar = this.M.i().get(i11);
                    Drawable drawableA = iVar.a();
                    Drawable drawableC = iVar.c();
                    boolean zIsEmpty = TextUtils.isEmpty(iVar.h());
                    if (!this.J) {
                        i10 = i11;
                        if (this.f2638h0 && zIsEmpty) {
                            fAbs = (-scrollX) < this.M.k() ? iVar.o() : ((Math.abs(scrollX) - (this.M.j() * 2)) - (this.M.g() * (Math.abs(scrollX) - this.M.k()))) / f10;
                            a0(canvas, size, i10, measuredWidth, iVar, drawableC, fAbs);
                        } else {
                            V(canvas, scrollX, size, fAbs, i10, measuredWidth, drawableA, zIsEmpty);
                            if (zIsEmpty) {
                                Y(canvas, size, i10, measuredWidth, iVar, drawableC);
                            } else {
                                b0(canvas, measuredWidth, iVar);
                            }
                        }
                    } else if (this.f2638h0 && zIsEmpty) {
                        if (scrollX < this.M.k()) {
                            fG = (getMeasuredWidth() + scrollX) - this.M.e(i11);
                            fAbs = iVar.o();
                        } else {
                            float fAbs2 = ((Math.abs(scrollX) - (this.M.j() * 2)) - (this.M.g() * (Math.abs(scrollX) - this.M.k()))) / f10;
                            fAbs = fAbs2;
                            fG = ((this.M.g() * (Math.abs(scrollX) - this.M.k())) / 2.0f) + (f11 * fAbs2) + getMeasuredWidth() + this.M.j();
                        }
                        S(canvas, size, i11, fG, iVar, drawableC, fAbs);
                        i10 = i11;
                    } else {
                        i10 = i11;
                        N(canvas, scrollX, size, fAbs, i11, measuredWidth, drawableA, zIsEmpty);
                        if (zIsEmpty) {
                            Q(canvas, size, i10, measuredWidth, iVar, drawableC);
                        } else {
                            T(canvas, measuredWidth, iVar);
                        }
                    }
                    i11 = i10 + 1;
                }
            }
        }
        if (this.f2660z) {
            int size2 = this.M.i().size();
            float fK = this.M.k() / this.M.i().size();
            for (int i12 = 0; i12 < size2; i12++) {
                float measuredWidth2 = (i12 * fK) + (this.J ? getMeasuredWidth() : 0);
                i iVar2 = this.M.i().get(i12);
                boolean zIsEmpty2 = TextUtils.isEmpty(iVar2.h());
                Drawable drawableA2 = iVar2.a();
                Drawable drawableC2 = iVar2.c();
                if (this.J) {
                    if (!this.f2638h0 || !zIsEmpty2) {
                        O(canvas, scrollX, size2, fK, i12, measuredWidth2, drawableA2, zIsEmpty2);
                    }
                    if (zIsEmpty2) {
                        R(canvas, size2, i12, measuredWidth2, iVar2, drawableC2);
                    } else {
                        U(canvas, scrollX, size2, fK, i12, measuredWidth2, iVar2);
                    }
                } else {
                    if (!this.f2638h0 || !zIsEmpty2) {
                        W(canvas, scrollX, size2, fK, i12, measuredWidth2, drawableA2, zIsEmpty2);
                    }
                    if (zIsEmpty2) {
                        Z(canvas, size2, i12, measuredWidth2, iVar2, drawableC2, fK);
                    } else {
                        c0(canvas, scrollX, size2, fK, i12, measuredWidth2, iVar2);
                    }
                }
            }
        }
        canvas.restore();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.I) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 2) {
                    int rawX = (int) (motionEvent.getRawX() - this.f2639i.x);
                    int rawY = (int) (motionEvent.getRawY() - this.f2639i.y);
                    if (Math.abs(motionEvent.getRawX() - this.f2639i.x) > this.f2624a && Math.abs(rawX) > Math.abs(rawY)) {
                        this.f2634f.set(motionEvent.getRawX(), motionEvent.getRawY());
                        getParent().requestDisallowInterceptTouchEvent(true);
                        return true;
                    }
                }
            } else if (this.J) {
                if (getScrollX() > this.f2624a && motionEvent.getX() < getWidth() - getScrollX()) {
                    return true;
                }
            } else if ((-getScrollX()) > this.f2624a && motionEvent.getX() > (-getScrollX())) {
                return true;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            if (childAt.getVisibility() != 8 && i14 == 0) {
                childAt.layout(paddingLeft, getPaddingTop(), childAt.getMeasuredWidth() + paddingLeft, childAt.getMeasuredHeight() + getPaddingTop());
                paddingLeft = childAt.getMeasuredWidth() + paddingLeft;
            }
        }
        u0();
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        setClickable(true);
        int measuredWidth = 0;
        this.f2628c = 0;
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            childAt.setClickable(true);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i10, i11);
                this.f2628c = Math.max(this.f2628c, childAt.getMeasuredHeight());
                this.f2632e = childAt;
                measuredWidth = childAt.getMeasuredWidth();
            }
        }
        if (this.f2660z) {
            setMeasuredDimension(measuredWidth, getLayoutParams().height);
            return;
        }
        setMeasuredDimension(getPaddingRight() + getPaddingLeft() + measuredWidth, getPaddingBottom() + getPaddingTop() + this.f2628c);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.I || f2621x0) {
            return super.onTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 2) {
            if (motionEvent.getPointerId(motionEvent.getActionIndex()) != this.f2637g0) {
                this.f2637g0 = motionEvent.getPointerId(motionEvent.getActionIndex());
                this.f2634f.set(motionEvent.getX(0), motionEvent.getY(0));
            }
            this.K = true;
            float rawX = this.f2634f.x - motionEvent.getRawX();
            if (Math.abs(rawX) > 10.0f || Math.abs(getScrollX()) > 10) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            if (Math.abs(rawX) > this.f2624a) {
                this.f2636g = false;
            }
            scrollBy((int) rawX, 0);
            this.f2634f.set(motionEvent.getRawX(), motionEvent.getRawY());
        }
        return true;
    }

    @Override // lj.a
    public boolean p() {
        f fVar = this.R;
        return fVar != null && fVar.n(getScrollX());
    }

    public boolean p0(int i10) {
        return Math.abs(i10) > this.f2649p0;
    }

    @Override // android.view.View
    public boolean performLongClick() {
        if (Math.abs(getScrollX()) > this.f2624a) {
            return false;
        }
        return super.performLongClick();
    }

    @Override // lj.a
    public boolean q() {
        lj.c cVar = this.Q;
        return cVar != null && cVar.o(getScrollX());
    }

    public void q0(int i10) {
        View view = this.f2632e;
        if (view != null) {
            view.setLongClickable(true);
        }
        lj.b bVar = this.S;
        if (bVar != null) {
            bVar.b(this.T, getScrollX(), -i10, this.W, this.f2625a0, Math.round(getWidth() * 0.5f * 0.3f));
            if (!this.J ? this.T.f10037b.f10047c < this.f2625a0 : this.T.f10037b.f10047c > this.W) {
                h();
            }
            invalidate();
        }
        f2622y0 = null;
    }

    @Override // lj.a
    public void r() {
        lj.c cVar = this.Q;
        if (cVar != null) {
            this.S = cVar;
            h();
        }
    }

    public final void r0(int i10) {
        f2622y0 = this;
        View view = this.f2632e;
        if (view != null) {
            view.setLongClickable(false);
        }
        lj.b bVar = this.S;
        if (bVar != null) {
            bVar.c(this.T, getScrollX(), i10);
            invalidate();
        }
    }

    public final void s() {
        this.T.a();
    }

    public final void s0(int i10) {
        f2622y0 = this;
        View view = this.f2632e;
        if (view != null) {
            view.setLongClickable(false);
        }
        lj.b bVar = this.S;
        if (bVar != null) {
            bVar.d(this.T, getScrollX(), -i10, this.W, this.f2625a0, Math.round(getWidth() * 0.5f * 0.3f));
            if (!this.J ? this.T.f10037b.f10047c > this.W : this.T.f10037b.f10047c < this.f2625a0) {
                t0();
                j();
            }
            invalidate();
        }
    }

    @Override // android.view.View
    public void scrollBy(int i10, int i11) {
        this.f2635f0 = i10;
        scrollTo(getScrollX() + i10, i11);
    }

    @Override // android.view.View
    public void scrollTo(int i10, int i11) {
        if (this.M.i().isEmpty()) {
            return;
        }
        if (this.f2660z) {
            super.scrollTo(i10, i11);
            return;
        }
        if (this.f2633e0) {
            super.scrollTo(i10, i11);
            return;
        }
        int scrollX = getScrollX() + this.f2635f0;
        boolean z10 = this.J;
        boolean z11 = true;
        boolean z12 = !z10 ? scrollX >= this.W : scrollX <= this.f2625a0;
        if (!z10 ? scrollX <= this.f2625a0 : scrollX >= this.W) {
            z11 = false;
        }
        if (this.T.o()) {
            super.scrollTo(i10, i11);
        } else if (z11) {
            H(scrollX - (this.J ? this.W : this.f2625a0));
        } else if (z12) {
            H(scrollX - (!this.J ? this.W : this.f2625a0));
        } else {
            super.scrollTo(i10, i11);
        }
        this.f2635f0 = 0;
    }

    public void setMenuCreator(h hVar) {
        this.L = hVar;
        this.M.i().clear();
        h hVar2 = this.L;
        g gVar = this.M;
        hVar2.a(gVar, gVar);
        this.f2654u0 = this.M.k();
        if (this.M.i().size() > 0) {
            this.f2630d = this.M.i().get(0).o() / 2;
        }
    }

    public void setOnMenuItemClickListener(e eVar) {
        this.f2653t0 = eVar;
    }

    public void setSwipeEnable(boolean z10) {
        this.I = z10;
    }

    public final void t0() {
        this.T.t();
    }

    public void u0() {
        if (this.J) {
            this.W = G();
        } else {
            this.W = -F();
        }
        if (this.J) {
            this.f2625a0 = F();
        } else {
            this.f2625a0 = G();
        }
    }

    public OSSwipeMenuLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OSSwipeMenuLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f2634f = new PointF();
        this.f2636g = true;
        this.f2639i = new PointF();
        this.f2645n = new PointF();
        this.N = 82;
        this.O = 64;
        this.U = 350;
        this.f2644m0 = 255;
        this.f2646n0 = 255;
        this.f2647o0 = 1.0f;
        e0(context, attributeSet, i10);
    }
}
