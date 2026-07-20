package com.transsion.widgetslib.view.damping;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowMetrics;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import com.transsion.widgetslib.R;
import com.transsion.widgetslib.view.LoadingView;
import com.transsion.widgetslib.view.OverBoundNestedScrollView;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class DampingLayout extends OverBoundNestedScrollView {
    public static final String M0 = "DampingLayout";
    public static final int N0 = 300;
    public static final float O0 = 0.0f;
    public static final float P0 = 1.0f;
    public static final float Q0 = 0.5f;
    public static final float R0 = 0.5f;
    public static final float S0 = 0.2f;
    public static final float T0 = 0.8f;
    public int A0;
    public int B0;
    public int C0;
    public int D0;
    public boolean E0;
    public View F0;
    public final Rect G0;
    public ValueAnimator H0;
    public Activity I0;
    public float J0;
    public int K0;
    public final Runnable L0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public int f2464d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public int f2465e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public LoadingView f2466f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public TextView f2467g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public Runnable f2468h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public float f2469i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public float f2470j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public float f2471k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public boolean f2472l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public m f2473m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public boolean f2474n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public View f2475o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public pj.c f2476p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public ValueAnimator f2477q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public ValueAnimator f2478r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public g6.b f2479s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public int f2480t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public boolean f2481u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public int f2482v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public int f2483w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public final int f2484x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public final int f2485y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public int f2486z0;

    public class a implements DynamicAnimation.OnAnimationUpdateListener {
        public a() {
        }

        @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener
        public void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f10, float f11) {
            if (DampingLayout.this.F0 == null) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = DampingLayout.this.F0.getLayoutParams();
            DampingLayout.this.G0.top = (int) Math.abs(f10);
            DampingLayout dampingLayout = DampingLayout.this;
            Rect rect = dampingLayout.G0;
            int i10 = rect.top;
            int i11 = dampingLayout.f2482v0;
            int i12 = i10 + i11;
            int i13 = layoutParams.height;
            if (i12 >= i13) {
                rect.top = i13 - i11;
            }
            dampingLayout.F0.layout(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DampingLayout.this.G0.set(DampingLayout.this.F0.getLeft(), DampingLayout.this.F0.getTop(), DampingLayout.this.F0.getRight(), DampingLayout.this.F0.getBottom());
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DampingLayout dampingLayout = DampingLayout.this;
            dampingLayout.g0(dampingLayout.H0);
            DampingLayout dampingLayout2 = DampingLayout.this;
            dampingLayout2.H0.setStartDelay(dampingLayout2.getScrollBarDefaultDelayBeforeFade());
            DampingLayout.this.H0.start();
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DampingLayout.this.l0();
        }
    }

    public class e implements g6.c {
        public e() {
        }

        @Override // g6.c
        public void a(float f10) {
            DampingLayout.this.h0(f10);
        }
    }

    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DampingLayout.this.q0();
        }
    }

    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (DampingLayout.this.computeVerticalScrollRange() > DampingLayout.this.getHeight()) {
                DampingLayout dampingLayout = DampingLayout.this;
                dampingLayout.g0(dampingLayout.H0);
                View view = DampingLayout.this.F0;
                if (view != null && view.getAlpha() != 1.0f) {
                    DampingLayout.this.F0.setAlpha(1.0f);
                }
                DampingLayout.this.t0();
            }
        }
    }

    public class h implements ValueAnimator.AnimatorUpdateListener {
        public h() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue instanceof Float) {
                float fFloatValue = ((Float) animatedValue).floatValue();
                DampingLayout.this.f2475o0.setTranslationY(fFloatValue);
                DampingLayout.this.r0(fFloatValue);
            }
        }
    }

    public class i implements ValueAnimator.AnimatorUpdateListener {
        public i() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue instanceof Float) {
                float fFloatValue = ((Float) animatedValue).floatValue();
                DampingLayout.this.f2475o0.setTranslationY(fFloatValue);
                DampingLayout.this.r0(fFloatValue);
            }
        }
    }

    public class j extends AnimatorListenerAdapter {
        public j() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            DampingLayout.this.f2474n0 = false;
            DampingLayout dampingLayout = DampingLayout.this;
            dampingLayout.f2472l0 = false;
            dampingLayout.f2467g0.setText(R.string.os_dampingl_refresh_finish);
            DampingLayout.this.f2466f0.f();
        }
    }

    public class k implements ValueAnimator.AnimatorUpdateListener {
        public k() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (DampingLayout.this.F0 == null) {
                return;
            }
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue instanceof Float) {
                DampingLayout.this.F0.setAlpha(((Float) animatedValue).floatValue());
            }
        }
    }

    public class l implements DynamicAnimation.OnAnimationUpdateListener {
        public l() {
        }

        @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener
        public void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f10, float f11) {
            if (DampingLayout.this.F0 == null) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = DampingLayout.this.F0.getLayoutParams();
            DampingLayout dampingLayout = DampingLayout.this;
            Rect rect = dampingLayout.G0;
            int i10 = (int) (layoutParams.height - f10);
            rect.bottom = i10;
            int i11 = dampingLayout.f2482v0;
            if (i10 <= i11) {
                rect.bottom = i11;
            }
            dampingLayout.F0.layout(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    public interface m {
        void a();
    }

    public DampingLayout(Context context) {
        this(context, null);
    }

    private ViewGroup getBarLayoutAttach() {
        if (this.K0 != 1) {
            Activity activity = this.I0;
            if (activity == null || activity.getWindow() == null) {
                return null;
            }
            return (ViewGroup) this.I0.getWindow().findViewById(android.R.id.content);
        }
        if (!(getParent() instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        if ((viewGroup instanceof FrameLayout) || (viewGroup instanceof RelativeLayout)) {
            return viewGroup;
        }
        int iIndexOfChild = viewGroup.indexOfChild(this);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        viewGroup.removeView(this);
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.addView(this);
        viewGroup.addView(frameLayout, iIndexOfChild, layoutParams);
        return frameLayout;
    }

    public void Q() {
        if (this.f2471k0 == 0.0f) {
            this.f2472l0 = false;
            if (this.f2474n0) {
                q0();
            }
        } else {
            this.f2472l0 = true;
            this.f2466f0.f();
            this.f2467g0.setText(R.string.os_dampingl_refresh_finish);
        }
        postDelayed(new g(), 60L);
        awakenScrollBars();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f2479s0 == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.f2474n0 && this.f2480t0 == 0) {
            i0(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.transsion.widgetslib.view.OverBoundNestedScrollView, android.view.View
    public void draw(Canvas canvas) {
        int safeInsetLeft;
        Activity activity;
        WindowMetrics currentWindowMetrics;
        WindowInsets windowInsets;
        super.draw(canvas);
        int iComputeVerticalScrollRange = computeVerticalScrollRange();
        int height = getHeight();
        Drawable verticalScrollbarThumbDrawable = getVerticalScrollbarThumbDrawable();
        if (height <= 0 || height >= iComputeVerticalScrollRange || verticalScrollbarThumbDrawable == null || verticalScrollbarThumbDrawable.getBounds().isEmpty()) {
            if (this.E0 && this.F0 != null) {
                g0(this.H0);
                this.F0.setAlpha(0.0f);
            }
            this.E0 = false;
            return;
        }
        if (this.B0 == iComputeVerticalScrollRange && this.C0 == height) {
            return;
        }
        if (this.F0 == null) {
            ViewGroup barLayoutAttach = getBarLayoutAttach();
            if (barLayoutAttach == null) {
                return;
            }
            n nVar = new n(getContext());
            this.F0 = nVar;
            barLayoutAttach.addView(nVar);
            this.F0.setBackgroundColor(Color.parseColor("#7FA1A1A1"));
            barLayoutAttach.bringChildToFront(this.F0);
        }
        if (this.K0 == 1) {
            int right = ((getRight() - getLeft()) - this.f2486z0) - this.f2484x0;
            View view = this.F0;
            if (hj.h.I()) {
                right = -right;
            }
            view.setTranslationX(right);
            this.J0 = getTop();
        } else {
            int[] iArr = new int[2];
            getLocationInWindow(iArr);
            int i10 = iArr[0];
            int i11 = iArr[1];
            int right2 = (((getRight() + i10) - getLeft()) - this.f2486z0) - this.f2484x0;
            if (!hj.h.I() || (activity = this.I0) == null || activity.getWindowManager() == null || (currentWindowMetrics = this.I0.getWindowManager().getCurrentWindowMetrics()) == null || currentWindowMetrics.getBounds() == null) {
                safeInsetLeft = 0;
            } else {
                Rect bounds = currentWindowMetrics.getBounds();
                safeInsetLeft = (getResources().getConfiguration().orientation != 2 || (windowInsets = currentWindowMetrics.getWindowInsets()) == null || windowInsets.getDisplayCutout() == null) ? 0 : windowInsets.getDisplayCutout().getSafeInsetLeft();
                right2 = (((i10 + this.f2486z0) + this.f2484x0) - bounds.width()) + safeInsetLeft;
            }
            int identifier = getResources().getIdentifier("status_bar_height", dc.d.f3680k, "android");
            int dimensionPixelSize = identifier > 0 ? getResources().getDimensionPixelSize(identifier) : 0;
            Activity activity2 = this.I0;
            this.J0 = (i11 - dimensionPixelSize) - ((activity2 == null || activity2.getActionBar() == null) ? 0 : this.I0.getActionBar().getHeight());
            Activity activity3 = this.I0;
            if (activity3 != null && activity3.getWindow() != null && this.I0.getWindow().getAttributes().layoutInDisplayCutoutMode == 1) {
                this.J0 = i11;
                right2 -= safeInsetLeft;
            }
            this.F0.setTranslationX(right2);
        }
        Rect bounds2 = verticalScrollbarThumbDrawable.getBounds();
        ViewGroup.LayoutParams layoutParams = this.F0.getLayoutParams();
        int iHeight = bounds2.height();
        layoutParams.height = iHeight;
        layoutParams.width = this.f2486z0;
        int i12 = this.f2483w0;
        if (iHeight < i12) {
            if (i12 > height) {
                this.f2483w0 = height;
            }
            layoutParams.height = this.f2483w0;
        }
        ((ViewGroup) this.F0.getParent()).updateViewLayout(this.F0, layoutParams);
        this.D0 = iComputeVerticalScrollRange - height;
        int i13 = (height - layoutParams.height) - (this.f2485y0 * 2);
        this.A0 = i13;
        if (i13 < 0) {
            this.A0 = 0;
        }
        this.B0 = iComputeVerticalScrollRange;
        this.C0 = height;
        postDelayed(new b(), 100L);
        u0(getScrollY());
    }

    public final void g0(Animator animator) {
        if (animator == null || !animator.isRunning()) {
            return;
        }
        animator.cancel();
    }

    public LoadingView getLoadingView() {
        return this.f2466f0;
    }

    public final void h0(float f10) {
        o0(f10);
        this.f2471k0 = f10;
        if (this.f2474n0 && f10 == 0.0f && this.f2472l0) {
            q0();
        }
    }

    public final void i0(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 1) {
            if (action == 2) {
                float f10 = this.f2471k0;
                if (f10 > 0.0f) {
                    if (f10 <= this.f2464d0) {
                        this.f2475o0.setTranslationY(f10);
                        this.f2467g0.setText(R.string.os_dampingl_down_pull_refresh);
                        r0(this.f2471k0);
                        return;
                    } else {
                        this.f2467g0.setText(R.string.os_dampingl_release_for_refresh);
                        if (this.f2475o0.getTranslationY() < this.f2464d0) {
                            p0();
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            if (action != 3) {
                return;
            }
        }
        if (this.f2471k0 < this.f2464d0) {
            q0();
            return;
        }
        this.f2474n0 = true;
        this.f2467g0.setText(R.string.os_dampingl_refreshing);
        this.f2466f0.k();
        if (this.f2475o0.getTranslationY() < this.f2464d0) {
            p0();
        }
        m mVar = this.f2473m0;
        if (mVar != null) {
            mVar.a();
            return;
        }
        if (this.f2468h0 == null) {
            this.f2468h0 = new f();
        }
        if (getHandler() != null) {
            getHandler().postDelayed(this.f2468h0, 2000L);
        }
    }

    public final void j0() {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.f2469i0 = TypedValue.applyDimension(1, 15.0f, displayMetrics);
        this.f2470j0 = TypedValue.applyDimension(1, 6.0f, displayMetrics);
        this.f2464d0 = getResources().getDimensionPixelSize(R.dimen.os_damping_layout_loading_title);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.os_damping_layout_loading_view);
        this.f2465e0 = dimensionPixelSize;
        this.f2469i0 += dimensionPixelSize;
        this.f2482v0 = (int) TypedValue.applyDimension(1, 8.0f, displayMetrics);
        this.f2483w0 = (int) TypedValue.applyDimension(1, 60.0f, displayMetrics);
        if (getContext() instanceof Activity) {
            this.I0 = (Activity) getContext();
        }
        setVerticalScrollbarThumbDrawable(new ColorDrawable(0));
        setVerticalScrollBarEnabled(true);
    }

    public final void k0() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.H0 = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        this.H0.setDuration(getScrollBarFadeDuration());
        this.H0.addUpdateListener(new k());
    }

    public final void l0() {
        if (this.f2479s0 != null) {
            return;
        }
        g6.b bVarH = H();
        this.f2479s0 = bVarH;
        if (bVarH == null) {
            return;
        }
        this.f2479s0.h(new e());
        n0();
    }

    public boolean m0() {
        return this.f2474n0;
    }

    public final void n0() {
        SpringAnimation springAnimation;
        SpringAnimation springAnimation2;
        if ((getEdgeGlowTop() instanceof g6.a) && (springAnimation2 = ((g6.a) getEdgeGlowTop()).f6418b) != null) {
            springAnimation2.addUpdateListener(new l());
        }
        if (!(getEdgeGlowBottom() instanceof g6.a) || (springAnimation = ((g6.a) getEdgeGlowBottom()).f6418b) == null) {
            return;
        }
        springAnimation.addUpdateListener(new a());
    }

    public final void o0(float f10) {
        if (!this.E0 || this.F0 == null) {
            return;
        }
        g0(this.H0);
        if (this.F0.getAlpha() != 1.0f) {
            this.F0.setAlpha(1.0f);
        }
        ViewGroup.LayoutParams layoutParams = this.F0.getLayoutParams();
        float fAbs = Math.abs(f10);
        if (f10 > 0.0f) {
            Rect rect = this.G0;
            int i10 = (int) (layoutParams.height - fAbs);
            rect.bottom = i10;
            int i11 = this.f2482v0;
            if (i10 <= i11) {
                rect.bottom = i11;
            }
        } else if (f10 < 0.0f) {
            Rect rect2 = this.G0;
            int i12 = (int) fAbs;
            rect2.top = i12;
            int i13 = this.f2482v0;
            int i14 = i12 + i13;
            int i15 = layoutParams.height;
            if (i14 >= i15) {
                rect2.top = i15 - i13;
            }
        } else {
            Rect rect3 = this.G0;
            rect3.top = 0;
            rect3.bottom = layoutParams.height;
            t0();
        }
        View view = this.F0;
        Rect rect4 = this.G0;
        view.layout(rect4.left, rect4.top, rect4.right, rect4.bottom);
    }

    @Override // com.transsion.widgetslib.view.OverBoundNestedScrollView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        int i10;
        super.onAttachedToWindow();
        if (this.f2480t0 == 0 || (i10 = this.K0) == 0) {
            l0();
        } else if (i10 == 1) {
            postDelayed(new d(), 100L);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        s0();
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() != 1) {
            return;
        }
        View childAt = getChildAt(0);
        this.f2475o0 = childAt;
        childAt.setNestedScrollingEnabled(false);
        this.f2475o0.setVerticalScrollBarEnabled(false);
        if (this.f2480t0 == 0) {
            setFillViewport(true);
            this.f2476p0 = new pj.c(0.25f, 0.0f, 0.0f, 1.0f);
            ViewGroup.LayoutParams layoutParams = this.f2475o0.getLayoutParams();
            removeView(this.f2475o0);
            View viewInflate = View.inflate(getContext(), R.layout.os_damping_layout_title, null);
            FrameLayout frameLayout = new FrameLayout(getContext());
            frameLayout.addView(viewInflate, -1, this.f2464d0);
            frameLayout.addView(this.f2475o0, -1, -1);
            addView(frameLayout, layoutParams);
            TextView textView = (TextView) findViewById(R.id.damping_text_loading);
            this.f2467g0 = textView;
            textView.setScaleX(0.5f);
            TextView textView2 = this.f2467g0;
            textView2.setScaleY(textView2.getScaleX());
            this.f2467g0.setAlpha(0.0f);
            LoadingView loadingView = (LoadingView) findViewById(R.id.loading_view);
            this.f2466f0 = loadingView;
            loadingView.setScaleX(0.2f);
            LoadingView loadingView2 = this.f2466f0;
            loadingView2.setScaleY(loadingView2.getScaleX());
            this.f2466f0.setAlpha(0.0f);
            this.f2466f0.setAutoAnim(false);
        }
    }

    @Override // com.transsion.widgetslib.view.OverBoundNestedScrollView, android.view.View
    public void onScrollChanged(int i10, int i11, int i12, int i13) {
        super.onScrollChanged(i10, i11, i12, i13);
        u0(i11);
        t0();
    }

    @Override // android.view.View
    public void onVisibilityAggregated(boolean z10) {
        super.onVisibilityAggregated(z10);
        if (!z10) {
            g0(this.H0);
            return;
        }
        if (this.H0 == null) {
            k0();
        }
        View view = this.F0;
        if (view != null) {
            view.setAlpha(1.0f);
        }
        this.H0.setStartDelay(((long) getScrollBarDefaultDelayBeforeFade()) * 4);
        this.H0.start();
    }

    public final void p0() {
        if (this.f2477q0 == null) {
            this.f2477q0 = ValueAnimator.ofFloat(new float[0]);
        }
        if (this.f2477q0.isRunning()) {
            return;
        }
        this.f2477q0.setFloatValues(this.f2475o0.getTranslationY(), this.f2464d0);
        this.f2477q0.setDuration(50L);
        this.f2477q0.setInterpolator(new LinearInterpolator());
        this.f2477q0.addUpdateListener(new h());
        this.f2477q0.start();
    }

    public final void q0() {
        float translationY = this.f2475o0.getTranslationY();
        if (translationY < 0.0f) {
            return;
        }
        if (this.f2478r0 == null) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 0.0f);
            this.f2478r0 = valueAnimatorOfFloat;
            valueAnimatorOfFloat.setDuration(300L);
            this.f2478r0.setInterpolator(this.f2476p0);
            this.f2478r0.addUpdateListener(new i());
            this.f2478r0.addListener(new j());
        }
        this.f2478r0.setFloatValues(translationY, 0.0f);
        this.f2478r0.start();
    }

    public final void r0(float f10) {
        try {
            int i10 = this.f2464d0;
            if (f10 > i10) {
                return;
            }
            float f11 = f10 / i10;
            this.f2467g0.setScaleX((f11 * 0.5f) + 0.5f);
            TextView textView = this.f2467g0;
            textView.setScaleY(textView.getScaleX());
            float f12 = (1.0f * f11) + 0.0f;
            this.f2467g0.setAlpha(f12);
            float f13 = this.f2469i0;
            if (f10 <= f13) {
                f13 = f10;
            }
            this.f2467g0.setTranslationY(f13);
            float f14 = f10 - this.f2465e0;
            float f15 = this.f2470j0;
            if (f14 > f15) {
                f14 = f15;
            }
            this.f2466f0.setScaleX((f11 * 0.8f) + 0.2f);
            LoadingView loadingView = this.f2466f0;
            loadingView.setScaleY(loadingView.getScaleX());
            this.f2466f0.setAlpha(f12);
            this.f2466f0.setTranslationY(f14);
        } catch (Exception e10) {
            Log.e(M0, "refreshTitleLayout, error", e10);
        }
    }

    public final void s0() {
        g0(this.f2477q0);
        g0(this.f2478r0);
        g0(this.H0);
        LoadingView loadingView = this.f2466f0;
        if (loadingView != null) {
            loadingView.f();
        }
        Handler handler = getHandler();
        if (handler != null) {
            Runnable runnable = this.f2468h0;
            if (runnable != null) {
                handler.removeCallbacks(runnable);
            }
            handler.removeCallbacks(this.L0);
        }
    }

    public void setBarWidth(int i10) {
        this.f2486z0 = i10;
    }

    public void setDampingMode(int i10) {
        this.f2480t0 = i10;
    }

    public void setLimitDampingEdge(boolean z10) {
        this.f2481u0 = z10;
    }

    public void setOnRefreshListener(m mVar) {
        this.f2473m0 = mVar;
    }

    public void setTextColor(int i10) {
        TextView textView = this.f2467g0;
        if (textView != null) {
            textView.setTextColor(i10);
        }
    }

    public void setUseScene(int i10) {
        this.K0 = i10;
    }

    public final void t0() {
        Handler handler = getHandler();
        if (handler != null) {
            if (handler.hasCallbacks(this.L0)) {
                handler.removeCallbacks(this.L0);
            }
            handler.postDelayed(this.L0, 100L);
        }
    }

    public final void u0(int i10) {
        if (this.F0 != null) {
            this.E0 = true;
            g0(this.H0);
            if (this.F0.getAlpha() != 1.0f) {
                this.F0.setAlpha(1.0f);
            }
            this.F0.setTranslationY(this.J0 + (((i10 * 1.0f) / this.D0) * this.A0) + this.f2485y0);
        }
    }

    public DampingLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static class n extends View {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Path f2499a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final RectF f2500b;

        public n(Context context) {
            super(context);
            this.f2499a = new Path();
            this.f2500b = new RectF();
        }

        @Override // android.view.View
        public void draw(Canvas canvas) {
            this.f2499a.reset();
            this.f2500b.set(0.0f, 0.0f, getWidth(), getHeight());
            this.f2499a.addRoundRect(this.f2500b, getWidth() / 2.0f, getWidth() / 2.0f, Path.Direction.CCW);
            canvas.clipPath(this.f2499a);
            super.draw(canvas);
        }

        public n(Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2499a = new Path();
            this.f2500b = new RectF();
        }

        public n(Context context, @Nullable AttributeSet attributeSet, int i10) {
            super(context, attributeSet, i10);
            this.f2499a = new Path();
            this.f2500b = new RectF();
        }
    }

    public DampingLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.G0 = new Rect();
        this.L0 = new c();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.DampingLayout, i10, 0);
        this.f2480t0 = typedArrayObtainStyledAttributes.getInt(R.styleable.DampingLayout_os_damping_mode, 0);
        this.K0 = typedArrayObtainStyledAttributes.getInt(R.styleable.DampingLayout_os_damping_bar_use_scene, 0);
        this.f2484x0 = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.DampingLayout_os_damping_bar_margin_right, (int) TypedValue.applyDimension(1, 6.0f, displayMetrics));
        this.f2485y0 = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.DampingLayout_os_damping_bar_margin_top, 0);
        this.f2486z0 = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.DampingLayout_os_damping_bar_width, (int) TypedValue.applyDimension(1, 3.0f, displayMetrics));
        this.f2481u0 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.DampingLayout_os_limit_damping_edge, true);
        typedArrayObtainStyledAttributes.recycle();
        j0();
    }
}
