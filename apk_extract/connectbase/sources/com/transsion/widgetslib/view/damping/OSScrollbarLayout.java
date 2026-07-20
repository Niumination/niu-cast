package com.transsion.widgetslib.view.damping;

import android.animation.Animator;
import android.animation.ValueAnimator;
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
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.widgetslib.R;
import com.transsion.widgetslib.view.OverBoundNestedScrollView;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class OSScrollbarLayout extends FrameLayout {
    public static final int P = 1;
    public static final int Q = 0;
    public static final String R = "OSScrollbarLayout";
    public View H;
    public SpringAnimation I;
    public SpringAnimation J;
    public DynamicAnimation.OnAnimationUpdateListener K;
    public DynamicAnimation.OnAnimationUpdateListener L;
    public int M;
    public boolean N;
    public final Runnable O;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2528a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2529b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2530c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2531d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2532e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2533f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f2534g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f2535i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f2536n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f2537p;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f2538v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f2539w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public View f2540x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Rect f2541y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public ValueAnimator f2542z;

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue instanceof Float) {
                OSScrollbarLayout.this.f2540x.setAlpha(((Float) animatedValue).floatValue());
            }
        }
    }

    public class b extends RecyclerView.OnScrollListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView f2544a;

        public b(RecyclerView recyclerView) {
            this.f2544a = recyclerView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i10, int i11) {
            super.onScrolled(recyclerView, i10, i11);
            OSScrollbarLayout.this.N = i11 > 0;
            OSScrollbarLayout.this.D(this.f2544a, this.f2544a.computeVerticalScrollRange(), this.f2544a.computeVerticalScrollOffset());
            OSScrollbarLayout.this.A();
        }
    }

    public class c implements View.OnScrollChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OverBoundNestedScrollView f2546a;

        public c(OverBoundNestedScrollView overBoundNestedScrollView) {
            this.f2546a = overBoundNestedScrollView;
        }

        @Override // android.view.View.OnScrollChangeListener
        public void onScrollChange(View view, int i10, int i11, int i12, int i13) {
            OSScrollbarLayout oSScrollbarLayout = OSScrollbarLayout.this;
            OverBoundNestedScrollView overBoundNestedScrollView = this.f2546a;
            oSScrollbarLayout.D(overBoundNestedScrollView, overBoundNestedScrollView.computeVerticalScrollRange(), this.f2546a.computeVerticalScrollOffset());
            OSScrollbarLayout.this.A();
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView f2548a;

        public d(RecyclerView recyclerView) {
            this.f2548a = recyclerView;
        }

        @Override // java.lang.Runnable
        public void run() {
            int iComputeVerticalScrollRange = this.f2548a.computeVerticalScrollRange();
            if (OSScrollbarLayout.this.f2534g == iComputeVerticalScrollRange) {
                return;
            }
            OSScrollbarLayout.this.f2534g = iComputeVerticalScrollRange;
            int iComputeVerticalScrollOffset = this.f2548a.computeVerticalScrollOffset();
            OSScrollbarLayout oSScrollbarLayout = OSScrollbarLayout.this;
            oSScrollbarLayout.f2535i = 0;
            oSScrollbarLayout.D(this.f2548a, oSScrollbarLayout.f2534g, iComputeVerticalScrollOffset);
            OSScrollbarLayout.this.y();
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OverBoundNestedScrollView f2550a;

        public e(OverBoundNestedScrollView overBoundNestedScrollView) {
            this.f2550a = overBoundNestedScrollView;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // java.lang.Runnable
        public void run() {
            int iComputeVerticalScrollRange = this.f2550a.computeVerticalScrollRange();
            if (OSScrollbarLayout.this.f2534g == iComputeVerticalScrollRange) {
                return;
            }
            OSScrollbarLayout oSScrollbarLayout = OSScrollbarLayout.this;
            oSScrollbarLayout.f2534g = iComputeVerticalScrollRange;
            oSScrollbarLayout.f2535i = 0;
            OverBoundNestedScrollView overBoundNestedScrollView = this.f2550a;
            oSScrollbarLayout.D(overBoundNestedScrollView, iComputeVerticalScrollRange, overBoundNestedScrollView.computeVerticalScrollOffset());
            OSScrollbarLayout.this.y();
        }
    }

    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            OSScrollbarLayout oSScrollbarLayout = OSScrollbarLayout.this;
            oSScrollbarLayout.f2537p = oSScrollbarLayout.f2540x.getTop();
            OSScrollbarLayout oSScrollbarLayout2 = OSScrollbarLayout.this;
            oSScrollbarLayout2.f2538v = oSScrollbarLayout2.f2540x.getBottom();
            OSScrollbarLayout oSScrollbarLayout3 = OSScrollbarLayout.this;
            Rect rect = oSScrollbarLayout3.f2541y;
            int left = oSScrollbarLayout3.f2540x.getLeft();
            OSScrollbarLayout oSScrollbarLayout4 = OSScrollbarLayout.this;
            rect.set(left, oSScrollbarLayout4.f2537p, oSScrollbarLayout4.f2540x.getRight(), OSScrollbarLayout.this.f2538v);
        }
    }

    public class g implements DynamicAnimation.OnAnimationUpdateListener {
        public g() {
        }

        @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener
        public void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f10, float f11) {
            if (OSScrollbarLayout.this.f2540x == null) {
                return;
            }
            OSScrollbarLayout.this.E(f10);
            OSScrollbarLayout oSScrollbarLayout = OSScrollbarLayout.this;
            View view = oSScrollbarLayout.f2540x;
            Rect rect = oSScrollbarLayout.f2541y;
            view.layout(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    public class h implements DynamicAnimation.OnAnimationUpdateListener {
        public h() {
        }

        @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener
        public void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f10, float f11) {
            if (OSScrollbarLayout.this.f2540x == null) {
                return;
            }
            OSScrollbarLayout.this.F((int) Math.abs(f10));
            OSScrollbarLayout oSScrollbarLayout = OSScrollbarLayout.this;
            View view = oSScrollbarLayout.f2540x;
            Rect rect = oSScrollbarLayout.f2541y;
            view.layout(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            OSScrollbarLayout oSScrollbarLayout = OSScrollbarLayout.this;
            oSScrollbarLayout.r(oSScrollbarLayout.f2542z);
            OSScrollbarLayout.this.y();
        }
    }

    public OSScrollbarLayout(Context context) {
        super(context);
        this.f2541y = new Rect();
        this.M = 0;
        this.O = new i();
        u(null);
    }

    public final void A() {
        Handler handler = getHandler();
        if (handler == null || !this.f2539w) {
            return;
        }
        if (handler.hasCallbacks(this.O)) {
            handler.removeCallbacks(this.O);
        }
        handler.postDelayed(this.O, 100L);
    }

    public final void B(int i10) {
        if (this.f2540x != null) {
            this.f2539w = true;
            r(this.f2542z);
            if (this.f2540x.getAlpha() != 1.0f) {
                this.f2540x.setAlpha(1.0f);
            }
            float f10 = this.f2531d + (((i10 * 1.0f) / this.f2536n) * this.f2533f);
            float translationY = this.f2540x.getTranslationY();
            if (this.M != 1) {
                this.f2540x.setTranslationY(f10);
                return;
            }
            if (this.N) {
                if (f10 > translationY) {
                    this.f2540x.setTranslationY(f10);
                }
            } else if (f10 < translationY) {
                this.f2540x.setTranslationY(f10);
            }
        }
    }

    public void C() {
        if (this.H == null) {
            return;
        }
        try {
            Method declaredMethod = View.class.getDeclaredMethod("awakenScrollBars", null);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(this.H, null);
            s();
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e10) {
            Log.e(R, "invoke awakenScrollBars error", e10);
        }
    }

    public final void D(View view, int i10, int i11) {
        if (view == null) {
            return;
        }
        int height = view.getHeight();
        Drawable verticalScrollbarThumbDrawable = view.getVerticalScrollbarThumbDrawable();
        if (height <= 0 || height >= i10 || verticalScrollbarThumbDrawable == null || verticalScrollbarThumbDrawable.getBounds().isEmpty()) {
            Handler handler = getHandler();
            if (handler != null && handler.hasCallbacks(this.O)) {
                handler.removeCallbacks(this.O);
            }
            if (this.f2539w && this.f2540x != null) {
                r(this.f2542z);
                this.f2540x.setAlpha(0.0f);
            }
            this.f2539w = false;
            return;
        }
        if (this.f2534g == i10 && this.f2535i == height) {
            B(i11);
            return;
        }
        if (this.f2540x == null) {
            j jVar = new j(getContext());
            this.f2540x = jVar;
            addView(jVar);
            this.f2540x.setBackgroundColor(Color.parseColor("#7FA1A1A1"));
            bringChildToFront(this.f2540x);
        }
        int width = (view.getWidth() - this.f2532e) - this.f2530c;
        View view2 = this.f2540x;
        if (hj.h.I()) {
            width = -width;
        }
        view2.setTranslationX(width);
        Rect bounds = verticalScrollbarThumbDrawable.getBounds();
        ViewGroup.LayoutParams layoutParams = this.f2540x.getLayoutParams();
        int iHeight = bounds.height();
        layoutParams.height = iHeight;
        layoutParams.width = this.f2532e;
        int i12 = this.f2529b;
        if (iHeight < i12) {
            if (i12 > height) {
                this.f2529b = height;
            }
            layoutParams.height = this.f2529b;
        }
        updateViewLayout(this.f2540x, layoutParams);
        this.f2536n = i10 - height;
        int i13 = (height - (this.f2531d * 2)) - layoutParams.height;
        this.f2533f = i13;
        if (i13 < 0) {
            this.f2533f = 0;
        }
        this.f2534g = i10;
        this.f2535i = height;
        postDelayed(new f(), 60L);
        B(i11);
    }

    public final void E(float f10) {
        Rect rect = this.f2541y;
        int i10 = (int) (this.f2538v - f10);
        rect.bottom = i10;
        int i11 = this.f2528a;
        int i12 = this.f2537p;
        if (i10 <= i11 + i12) {
            rect.bottom = i11 + i12;
        }
    }

    public final void F(int i10) {
        Rect rect = this.f2541y;
        int i11 = i10 + this.f2537p;
        rect.top = i11;
        int i12 = this.f2528a;
        int i13 = i11 + i12;
        int i14 = this.f2538v;
        if (i13 >= i14) {
            rect.top = i14 - i12;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        z();
    }

    @Override // android.view.View
    public void onVisibilityAggregated(boolean z10) {
        super.onVisibilityAggregated(z10);
        if (z10) {
            y();
        } else {
            r(this.f2542z);
        }
    }

    public final void r(Animator animator) {
        if (animator != null) {
            animator.cancel();
        }
    }

    public final void s() {
        View view = this.H;
        if (view instanceof RecyclerView) {
            postDelayed(new d((RecyclerView) view), 100L);
        }
        if (this.H instanceof OverBoundNestedScrollView) {
            w();
            postDelayed(new e((OverBoundNestedScrollView) this.H), 100L);
        }
    }

    public void setOverScrollView(View view) {
        if (view == null) {
            return;
        }
        this.H = view;
        view.setVerticalScrollbarThumbDrawable(new ColorDrawable(0));
        view.setVerticalScrollBarEnabled(true);
        if (view instanceof RecyclerView) {
            this.M = 1;
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.addOnScrollListener(new b(recyclerView));
        }
        if (view instanceof OverBoundNestedScrollView) {
            OverBoundNestedScrollView overBoundNestedScrollView = (OverBoundNestedScrollView) view;
            overBoundNestedScrollView.setOnScrollChangeListener(new c(overBoundNestedScrollView));
        }
        s();
    }

    public final Object t(Object obj, String str) {
        try {
            Field declaredField = obj.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException | SecurityException e10) {
            Log.e(R, "getFieldValue error", e10);
            return null;
        }
    }

    public final void u(TypedArray typedArray) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int iApplyDimension = (int) TypedValue.applyDimension(1, 6.0f, displayMetrics);
        int iApplyDimension2 = (int) TypedValue.applyDimension(1, 2.0f, displayMetrics);
        int iApplyDimension3 = (int) TypedValue.applyDimension(1, 3.0f, displayMetrics);
        if (typedArray == null) {
            this.f2530c = iApplyDimension;
            this.f2531d = iApplyDimension2;
            this.f2532e = iApplyDimension3;
        } else {
            this.f2530c = typedArray.getDimensionPixelOffset(R.styleable.OSScrollbarLayout_os_scrollbar_margin_right, iApplyDimension);
            this.f2531d = typedArray.getDimensionPixelOffset(R.styleable.OSScrollbarLayout_os_scrollbar_margin_top, iApplyDimension2);
            this.f2532e = typedArray.getDimensionPixelOffset(R.styleable.OSScrollbarLayout_os_scrollbar_width, iApplyDimension3);
            typedArray.recycle();
        }
        this.f2528a = (int) TypedValue.applyDimension(1, 8.0f, displayMetrics);
        this.f2529b = (int) TypedValue.applyDimension(1, 60.0f, displayMetrics);
    }

    public final void v() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.f2542z = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        this.f2542z.setDuration(this.H.getScrollBarFadeDuration());
        this.f2542z.addUpdateListener(new a());
    }

    public final void w() {
        View view = this.H;
        if (view == null) {
            return;
        }
        if (this.I == null || this.J == null) {
            if (view instanceof RecyclerView) {
                RecyclerView recyclerView = (RecyclerView) view;
                Object objT = t(recyclerView, "mTopGlow");
                if ((objT instanceof g6.a) && this.I == null) {
                    this.I = ((g6.a) objT).f6418b;
                }
                Object objT2 = t(recyclerView, "mBottomGlow");
                if ((objT2 instanceof g6.a) && this.J == null) {
                    this.J = ((g6.a) objT2).f6418b;
                }
            }
            View view2 = this.H;
            if (view2 instanceof OverBoundNestedScrollView) {
                OverBoundNestedScrollView overBoundNestedScrollView = (OverBoundNestedScrollView) view2;
                if (overBoundNestedScrollView.getEdgeGlowTop() instanceof g6.a) {
                    this.I = ((g6.a) overBoundNestedScrollView.getEdgeGlowTop()).f6418b;
                }
                if (overBoundNestedScrollView.getEdgeGlowBottom() instanceof g6.a) {
                    this.J = ((g6.a) overBoundNestedScrollView.getEdgeGlowBottom()).f6418b;
                }
            }
        }
        try {
            if (this.I != null && this.K == null) {
                g gVar = new g();
                this.K = gVar;
                this.I.addUpdateListener(gVar);
            }
            if (this.J == null || this.L != null) {
                return;
            }
            h hVar = new h();
            this.L = hVar;
            this.J.addUpdateListener(hVar);
        } catch (Exception e10) {
            this.L = null;
            this.K = null;
            Log.e(R, "onEdgeEffect error", e10);
        }
    }

    public void x(float f10) {
        if (this.f2540x == null || !this.f2539w) {
            return;
        }
        r(this.f2542z);
        if (this.f2540x.getAlpha() != 1.0f) {
            this.f2540x.setAlpha(1.0f);
        }
        float fAbs = Math.abs(f10);
        if (f10 > 0.0f) {
            E(fAbs);
        } else if (f10 < 0.0f) {
            F((int) fAbs);
        } else {
            Rect rect = this.f2541y;
            rect.top = this.f2537p;
            rect.bottom = this.f2538v;
            A();
        }
        View view = this.f2540x;
        Rect rect2 = this.f2541y;
        view.layout(rect2.left, rect2.top, rect2.right, rect2.bottom);
    }

    public final void y() {
        if (this.f2540x == null || !this.f2539w) {
            return;
        }
        if (this.f2542z == null) {
            v();
        }
        this.f2542z.cancel();
        this.f2540x.setAlpha(1.0f);
        this.f2542z.setStartDelay(((long) this.H.getScrollBarDefaultDelayBeforeFade()) * 4);
        this.f2542z.start();
    }

    public final void z() {
        r(this.f2542z);
        Handler handler = getHandler();
        if (handler != null) {
            handler.removeCallbacks(this.O);
        }
    }

    public static class j extends View {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Path f2556a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final RectF f2557b;

        public j(Context context) {
            super(context);
            this.f2556a = new Path();
            this.f2557b = new RectF();
        }

        @Override // android.view.View
        public void draw(Canvas canvas) {
            this.f2556a.reset();
            this.f2557b.set(0.0f, 0.0f, getWidth(), getHeight());
            this.f2556a.addRoundRect(this.f2557b, getWidth() / 2.0f, getWidth() / 2.0f, Path.Direction.CCW);
            canvas.clipPath(this.f2556a);
            super.draw(canvas);
        }

        public j(Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2556a = new Path();
            this.f2557b = new RectF();
        }

        public j(Context context, @Nullable AttributeSet attributeSet, int i10) {
            super(context, attributeSet, i10);
            this.f2556a = new Path();
            this.f2557b = new RectF();
        }
    }

    public OSScrollbarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2541y = new Rect();
        this.M = 0;
        this.O = new i();
        u(context.obtainStyledAttributes(attributeSet, R.styleable.OSScrollbarLayout));
    }

    public OSScrollbarLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f2541y = new Rect();
        this.M = 0;
        this.O = new i();
        u(context.obtainStyledAttributes(attributeSet, R.styleable.OSScrollbarLayout, i10, 0));
    }
}
