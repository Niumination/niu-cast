package com.transsion.widgetslib.view.damping;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.widgetslib.R$styleable;
import com.transsion.widgetslib.view.OverBoundNestedScrollView;
import com.transsion.widgetthemes.util.Utils;
import d8.d;
import ee.k;
import java.lang.reflect.Field;
import k3.z8;
import rd.e;
import rd.l;
import rd.m;
import rd.n;

/* JADX INFO: loaded from: classes2.dex */
public class OSScrollbarLayout extends FrameLayout {
    public static final /* synthetic */ int B = 0;
    public final m A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3219b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3220c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3221d;
    public int e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f3222h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f3223i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f3224j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f3225k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f3226l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f3227m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public e f3228n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Rect f3229o;
    public ValueAnimator p;
    public View q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public d f3230r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public d f3231s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public n f3232t;
    public n u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f3233v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f3234w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f3235x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f3236y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f3237z;

    public OSScrollbarLayout(Context context) {
        super(context);
        this.f3229o = new Rect();
        this.f3233v = 0;
        this.f3237z = 0.0f;
        this.A = new m(this, 1);
        d(null);
    }

    public static void a(Animator animator) {
        if (animator != null) {
            animator.cancel();
        }
    }

    public static Object c(Object obj, String str) {
        try {
            Field declaredField = obj.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException | SecurityException e) {
            Log.e("OSScrollbarLayout", "getFieldValue error", e);
            return null;
        }
    }

    public final void b() {
        View view = this.q;
        if (view instanceof RecyclerView) {
            postDelayed(new i2.e(this, 15, (RecyclerView) view, false), 100L);
        }
        View view2 = this.q;
        if (view2 instanceof OverBoundNestedScrollView) {
            if (view2 != null) {
                if (this.f3230r == null || this.f3231s == null) {
                    if (view2 instanceof RecyclerView) {
                        RecyclerView recyclerView = (RecyclerView) view2;
                        Object objC = c(recyclerView, "mTopGlow");
                        if ((objC instanceof b8.d) && this.f3230r == null) {
                            this.f3230r = ((b8.d) objC).f1222b;
                        }
                        Object objC2 = c(recyclerView, "mBottomGlow");
                        if ((objC2 instanceof b8.d) && this.f3231s == null) {
                            this.f3231s = ((b8.d) objC2).f1222b;
                        }
                    }
                    View view3 = this.q;
                    if (view3 instanceof OverBoundNestedScrollView) {
                        OverBoundNestedScrollView overBoundNestedScrollView = (OverBoundNestedScrollView) view3;
                        if (overBoundNestedScrollView.getEdgeGlowTop() instanceof b8.d) {
                            this.f3230r = ((b8.d) overBoundNestedScrollView.getEdgeGlowTop()).f1222b;
                        }
                        if (overBoundNestedScrollView.getEdgeGlowBottom() instanceof b8.d) {
                            this.f3231s = ((b8.d) overBoundNestedScrollView.getEdgeGlowBottom()).f1222b;
                        }
                    }
                }
                try {
                    d dVar = this.f3230r;
                    if (dVar != null && this.f3232t == null) {
                        n nVar = new n(this, 0);
                        this.f3232t = nVar;
                        dVar.a(nVar);
                    }
                    d dVar2 = this.f3231s;
                    if (dVar2 != null && this.u == null) {
                        n nVar2 = new n(this, 1);
                        this.u = nVar2;
                        dVar2.a(nVar2);
                    }
                } catch (Exception e) {
                    this.u = null;
                    this.f3232t = null;
                    Log.e("OSScrollbarLayout", "onEdgeEffect error", e);
                }
            }
            postDelayed(new i2.e(this, 16, (OverBoundNestedScrollView) this.q, false), 100L);
        }
    }

    public final void d(TypedArray typedArray) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int iApplyDimension = (int) TypedValue.applyDimension(1, 6.0f, displayMetrics);
        int iApplyDimension2 = (int) TypedValue.applyDimension(1, 2.0f, displayMetrics);
        int iApplyDimension3 = (int) TypedValue.applyDimension(1, 3.0f, displayMetrics);
        if (typedArray == null) {
            this.f3220c = iApplyDimension;
            this.f3221d = iApplyDimension2;
            this.e = iApplyDimension3;
        } else {
            this.f3220c = typedArray.getDimensionPixelOffset(R$styleable.OSScrollbarLayout_os_scrollbar_margin_right, iApplyDimension);
            this.f3221d = typedArray.getDimensionPixelOffset(R$styleable.OSScrollbarLayout_os_scrollbar_margin_top, iApplyDimension2);
            this.e = typedArray.getDimensionPixelOffset(R$styleable.OSScrollbarLayout_os_scrollbar_width, iApplyDimension3);
            typedArray.recycle();
        }
        this.f3218a = (int) TypedValue.applyDimension(1, 8.0f, displayMetrics);
        this.f3219b = (int) TypedValue.applyDimension(1, 60.0f, displayMetrics);
    }

    public final void e(float f) {
        if (this.f3228n == null || !this.f3227m) {
            return;
        }
        a(this.p);
        if (this.f3228n.getAlpha() != 1.0f) {
            this.f3228n.setAlpha(1.0f);
        }
        float fAbs = Math.abs(f);
        Rect rect = this.f3229o;
        if (f > 0.0f) {
            int i8 = (int) (this.f3226l - fAbs);
            rect.bottom = i8;
            int i9 = this.f3218a + this.f3225k;
            if (i8 <= i9) {
                rect.bottom = i9;
            }
        } else if (f < 0.0f) {
            j((int) fAbs);
        } else {
            rect.top = this.f3225k;
            rect.bottom = this.f3226l;
            g();
        }
        ViewGroup.LayoutParams layoutParams = this.f3228n.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = rect.width();
            layoutParams.height = rect.height();
            updateViewLayout(this.f3228n, layoutParams);
        }
    }

    public final void f() {
        if (this.f3228n == null || !this.f3227m) {
            return;
        }
        if (this.p == null) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.p = valueAnimatorOfFloat;
            valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
            this.p.setDuration(this.q.getScrollBarFadeDuration());
            this.p.addUpdateListener(new k(this, 6));
        }
        this.p.cancel();
        this.f3228n.setAlpha(1.0f);
        this.p.setStartDelay(((long) this.q.getScrollBarDefaultDelayBeforeFade()) * 4);
        this.p.start();
    }

    public final void g() {
        Handler handler = getHandler();
        if (handler == null || !this.f3227m) {
            return;
        }
        m mVar = this.A;
        if (handler.hasCallbacks(mVar)) {
            handler.removeCallbacks(mVar);
        }
        handler.postDelayed(mVar, 100L);
    }

    public final void h(int i8) {
        if (this.f3228n != null) {
            this.f3227m = true;
            a(this.p);
            if (this.f3228n.getAlpha() != 1.0f) {
                this.f3228n.setAlpha(1.0f);
            }
            float f = this.f3221d + (((i8 * 1.0f) / this.f3224j) * this.f3222h);
            float translationY = this.f3228n.getTranslationY();
            if (this.f3233v != 1) {
                this.f3228n.setTranslationY(f);
            } else if (this.f3234w) {
                if (f > translationY) {
                    this.f3228n.setTranslationY(f);
                }
            } else if (f < translationY) {
                this.f3228n.setTranslationY(f);
            }
            this.f3237z = this.f3228n.getTranslationY();
        }
    }

    public final void i(View view, int i8, int i9) {
        if (view == null) {
            return;
        }
        int height = getHeight();
        int width = getWidth();
        Drawable verticalScrollbarThumbDrawable = view.getVerticalScrollbarThumbDrawable();
        if (width <= 0 || height <= 0 || height >= i8 || verticalScrollbarThumbDrawable == null || verticalScrollbarThumbDrawable.getBounds().isEmpty()) {
            Handler handler = getHandler();
            if (handler != null) {
                Runnable runnable = this.A;
                if (handler.hasCallbacks(runnable)) {
                    handler.removeCallbacks(runnable);
                }
            }
            a(this.p);
            e eVar = this.f3228n;
            if (eVar != null) {
                eVar.setAlpha(0.0f);
            }
            z8.b("OSScrollbarLayout", "updateScrollBar, mHasScrollBar: " + this.f3227m + ", mViewScrollBar:" + this.f3228n);
            this.f3227m = false;
            return;
        }
        if (this.f3223i == i8 && this.f3235x == height && this.f3236y == width) {
            h(i9);
            return;
        }
        if (this.f3228n == null) {
            e eVar2 = new e(getContext(), 1);
            this.f3228n = eVar2;
            addView(eVar2);
            this.f3228n.setBackgroundColor(Color.parseColor("#7FA1A1A1"));
            bringChildToFront(this.f3228n);
        }
        int width2 = (view.getWidth() - this.e) - this.f3220c;
        e eVar3 = this.f3228n;
        if (Utils.isRtl()) {
            width2 = -width2;
        }
        eVar3.setTranslationX(width2);
        z8.b("OSScrollbarLayout", "updateScrollBar, mScrollRange: " + this.f3223i + ", scrollRange: " + i8 + ", mHeight: " + this.f3235x + ", height: " + height + ", mWidth: " + this.f3236y + ", width: " + width);
        Rect bounds = verticalScrollbarThumbDrawable.getBounds();
        ViewGroup.LayoutParams layoutParams = this.f3228n.getLayoutParams();
        if (layoutParams != null) {
            int iHeight = bounds.height();
            layoutParams.height = iHeight;
            layoutParams.width = this.e;
            int i10 = this.f3219b;
            if (iHeight < i10) {
                if (i10 > height) {
                    this.f3219b = height;
                }
                layoutParams.height = this.f3219b;
            }
            updateViewLayout(this.f3228n, layoutParams);
        }
        this.f3224j = i8 - height;
        int i11 = (height - (this.f3221d * 2)) - layoutParams.height;
        this.f3222h = i11;
        if (i11 < 0) {
            this.f3222h = 0;
        }
        this.f3223i = i8;
        this.f3235x = height;
        this.f3236y = width;
        post(new m(this, 0));
        h(i9);
    }

    public final void j(int i8) {
        int i9 = i8 + this.f3225k;
        Rect rect = this.f3229o;
        rect.top = i9;
        int i10 = this.f3218a;
        int i11 = i9 + i10;
        int i12 = this.f3226l;
        if (i11 >= i12) {
            rect.top = i12 - i10;
        }
        this.f3228n.setTranslationY(this.f3237z + rect.top);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a(this.p);
        Handler handler = getHandler();
        if (handler != null) {
            handler.removeCallbacks(this.A);
        }
    }

    @Override // android.view.View
    public final void onSizeChanged(int i8, int i9, int i10, int i11) {
        super.onSizeChanged(i8, i9, i10, i11);
        i(this.q, 0, 0);
    }

    @Override // android.view.View
    public final void onVisibilityAggregated(boolean z2) {
        super.onVisibilityAggregated(z2);
        if (z2) {
            f();
        } else {
            a(this.p);
        }
    }

    public void setOverScrollView(View view) {
        if (view == null) {
            return;
        }
        this.q = view;
        view.setVerticalScrollbarThumbDrawable(new ColorDrawable(0));
        view.setVerticalScrollBarEnabled(true);
        if (view instanceof RecyclerView) {
            this.f3233v = 1;
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.addOnScrollListener(new rd.k(this, recyclerView));
        }
        if (view instanceof OverBoundNestedScrollView) {
            OverBoundNestedScrollView overBoundNestedScrollView = (OverBoundNestedScrollView) view;
            overBoundNestedScrollView.setOnScrollChangeListener(new l(this, overBoundNestedScrollView));
        }
        b();
    }

    public OSScrollbarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3229o = new Rect();
        this.f3233v = 0;
        this.f3237z = 0.0f;
        this.A = new m(this, 1);
        d(context.obtainStyledAttributes(attributeSet, R$styleable.OSScrollbarLayout));
    }

    public OSScrollbarLayout(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        this.f3229o = new Rect();
        this.f3233v = 0;
        this.f3237z = 0.0f;
        this.A = new m(this, 1);
        d(context.obtainStyledAttributes(attributeSet, R$styleable.OSScrollbarLayout, i8, 0));
    }
}
