package com.transsion.widgetslib.view.damping;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.transsion.widgetslib.R;
import com.transsion.widgetslib.view.LoadingView;
import com.transsion.widgetslib.view.OverBoundNestedScrollView;

/* JADX INFO: loaded from: classes2.dex */
public class OSDampingLayout extends OverBoundNestedScrollView {

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public static final String f2501s0 = "OSDampingLayout";

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public static final int f2502t0 = 300;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public static final float f2503u0 = 0.0f;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public static final float f2504v0 = 1.0f;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public static final float f2505w0 = 0.5f;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public static final float f2506x0 = 0.5f;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public static final float f2507y0 = 0.2f;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public static final float f2508z0 = 0.8f;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public int f2509d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public int f2510e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public LoadingView f2511f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public TextView f2512g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public Runnable f2513h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public float f2514i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public float f2515j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public float f2516k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public boolean f2517l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public e f2518m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public boolean f2519n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public View f2520o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public pj.c f2521p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public ValueAnimator f2522q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public ValueAnimator f2523r0;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            OSDampingLayout.this.e0();
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue instanceof Float) {
                float fFloatValue = ((Float) animatedValue).floatValue();
                OSDampingLayout.this.f2520o0.setTranslationY(fFloatValue);
                OSDampingLayout.this.f0(fFloatValue);
            }
        }
    }

    public class c implements ValueAnimator.AnimatorUpdateListener {
        public c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue instanceof Float) {
                float fFloatValue = ((Float) animatedValue).floatValue();
                OSDampingLayout.this.f2520o0.setTranslationY(fFloatValue);
                OSDampingLayout.this.f0(fFloatValue);
            }
        }
    }

    public class d extends AnimatorListenerAdapter {
        public d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            OSDampingLayout.this.f2519n0 = false;
            OSDampingLayout oSDampingLayout = OSDampingLayout.this;
            oSDampingLayout.f2517l0 = false;
            oSDampingLayout.f2512g0.setText(R.string.os_dampingl_refresh_finish);
            OSDampingLayout.this.f2511f0.f();
        }
    }

    public interface e {
        void a();
    }

    public OSDampingLayout(Context context) {
        super(context);
        a0();
    }

    private void Y(Animator animator) {
        if (animator == null || !animator.isRunning()) {
            return;
        }
        animator.cancel();
    }

    private void Z(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 1) {
            if (action == 2) {
                float f10 = this.f2516k0;
                if (f10 > 0.0f) {
                    if (f10 <= this.f2509d0) {
                        this.f2520o0.setTranslationY(f10);
                        this.f2512g0.setText(R.string.os_dampingl_down_pull_refresh);
                        f0(this.f2516k0);
                        return;
                    } else {
                        this.f2512g0.setText(R.string.os_dampingl_release_for_refresh);
                        if (this.f2520o0.getTranslationY() < this.f2509d0) {
                            d0();
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
        if (this.f2516k0 < this.f2509d0) {
            e0();
            return;
        }
        this.f2519n0 = true;
        this.f2512g0.setText(R.string.os_dampingl_refreshing);
        this.f2511f0.k();
        if (this.f2520o0.getTranslationY() < this.f2509d0) {
            d0();
        }
        e eVar = this.f2518m0;
        if (eVar != null) {
            eVar.a();
            return;
        }
        if (this.f2513h0 == null) {
            this.f2513h0 = new a();
        }
        if (getHandler() != null) {
            getHandler().postDelayed(this.f2513h0, 2000L);
        }
    }

    private void a0() {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.f2514i0 = TypedValue.applyDimension(1, 15.0f, displayMetrics);
        this.f2515j0 = TypedValue.applyDimension(1, 6.0f, displayMetrics);
        this.f2509d0 = getResources().getDimensionPixelSize(R.dimen.os_damping_layout_loading_title);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.os_damping_layout_loading_view);
        this.f2510e0 = dimensionPixelSize;
        this.f2514i0 += dimensionPixelSize;
    }

    private void d0() {
        if (this.f2522q0 == null) {
            this.f2522q0 = ValueAnimator.ofFloat(new float[0]);
        }
        if (this.f2522q0.isRunning()) {
            return;
        }
        this.f2522q0.setFloatValues(this.f2520o0.getTranslationY(), this.f2509d0);
        this.f2522q0.setDuration(50L);
        this.f2522q0.setInterpolator(new LinearInterpolator());
        this.f2522q0.addUpdateListener(new b());
        this.f2522q0.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0() {
        float translationY = this.f2520o0.getTranslationY();
        if (translationY < 0.0f) {
            return;
        }
        if (this.f2523r0 == null) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 0.0f);
            this.f2523r0 = valueAnimatorOfFloat;
            valueAnimatorOfFloat.setDuration(300L);
            this.f2523r0.setInterpolator(this.f2521p0);
            this.f2523r0.addUpdateListener(new c());
            this.f2523r0.addListener(new d());
        }
        this.f2523r0.setFloatValues(translationY, 0.0f);
        this.f2523r0.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f0(float f10) {
        try {
            int i10 = this.f2509d0;
            if (f10 > i10) {
                return;
            }
            float f11 = f10 / i10;
            this.f2512g0.setScaleX((f11 * 0.5f) + 0.5f);
            TextView textView = this.f2512g0;
            textView.setScaleY(textView.getScaleX());
            float f12 = (1.0f * f11) + 0.0f;
            this.f2512g0.setAlpha(f12);
            float f13 = this.f2514i0;
            if (f10 <= f13) {
                f13 = f10;
            }
            this.f2512g0.setTranslationY(f13);
            float f14 = f10 - this.f2510e0;
            float f15 = this.f2515j0;
            if (f14 > f15) {
                f14 = f15;
            }
            this.f2511f0.setScaleX((f11 * 0.8f) + 0.2f);
            LoadingView loadingView = this.f2511f0;
            loadingView.setScaleY(loadingView.getScaleX());
            this.f2511f0.setAlpha(f12);
            this.f2511f0.setTranslationY(f14);
        } catch (Exception e10) {
            Log.e(f2501s0, "refreshTitleLayout, error", e10);
        }
    }

    private void g0() {
        Runnable runnable;
        Y(this.f2522q0);
        Y(this.f2523r0);
        LoadingView loadingView = this.f2511f0;
        if (loadingView != null) {
            loadingView.f();
        }
        Handler handler = getHandler();
        if (handler == null || (runnable = this.f2513h0) == null) {
            return;
        }
        handler.removeCallbacks(runnable);
    }

    public void Q() {
        if (this.f2520o0 == null) {
            return;
        }
        if (this.f2516k0 != 0.0f) {
            this.f2517l0 = true;
            this.f2511f0.f();
            this.f2512g0.setText(R.string.os_dampingl_refresh_finish);
        } else {
            this.f2517l0 = false;
            if (this.f2519n0) {
                e0();
            }
        }
    }

    public boolean b0() {
        return this.f2519n0;
    }

    public void c0(float f10) {
        this.f2516k0 = f10;
        if (this.f2519n0 && f10 == 0.0f && this.f2517l0) {
            e0();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f2520o0 == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!this.f2519n0) {
            Z(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public LoadingView getLoadingView() {
        return this.f2511f0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        g0();
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() != 1) {
            return;
        }
        View childAt = getChildAt(0);
        this.f2520o0 = childAt;
        childAt.setNestedScrollingEnabled(false);
        this.f2520o0.setVerticalScrollBarEnabled(false);
        setFillViewport(true);
        this.f2521p0 = new pj.c(0.25f, 0.0f, 0.0f, 1.0f);
        ViewGroup.LayoutParams layoutParams = this.f2520o0.getLayoutParams();
        removeView(this.f2520o0);
        View viewInflate = View.inflate(getContext(), R.layout.os_damping_layout_title, null);
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.addView(this.f2520o0, -1, -1);
        frameLayout.addView(viewInflate, -1, this.f2509d0);
        addView(frameLayout, layoutParams);
        TextView textView = (TextView) findViewById(R.id.damping_text_loading);
        this.f2512g0 = textView;
        textView.setScaleX(0.5f);
        TextView textView2 = this.f2512g0;
        textView2.setScaleY(textView2.getScaleX());
        this.f2512g0.setAlpha(0.0f);
        LoadingView loadingView = (LoadingView) findViewById(R.id.loading_view);
        this.f2511f0 = loadingView;
        loadingView.setScaleX(0.2f);
        LoadingView loadingView2 = this.f2511f0;
        loadingView2.setScaleY(loadingView2.getScaleX());
        this.f2511f0.setAlpha(0.0f);
        this.f2511f0.setAutoAnim(false);
    }

    public void setOnRefreshListener(e eVar) {
        this.f2518m0 = eVar;
    }

    public void setTextColor(int i10) {
        TextView textView = this.f2512g0;
        if (textView != null) {
            textView.setTextColor(i10);
        }
    }

    public OSDampingLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        a0();
    }

    public OSDampingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        a0();
    }
}
