package com.transsion.widgetslib.widget.tablayout;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.internal.ViewUtils;
import ge.h;
import ge.i;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3717a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f3718b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final GradientDrawable f3719c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3720d;
    public float e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f3721h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f3722i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f3723j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f3724k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ValueAnimator f3725l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f3726m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f3727n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final /* synthetic */ TabLayout f3728o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(TabLayout tabLayout, Context context) {
        super(context);
        this.f3728o = tabLayout;
        this.f3720d = -1;
        this.f3721h = -1;
        this.f3722i = -1;
        this.f3723j = 0;
        this.f3724k = 0;
        this.f3726m = -1;
        this.f3727n = -1;
        setWillNotDraw(false);
        this.f3718b = new Paint();
        this.f3719c = new GradientDrawable();
    }

    public final void a(TabLayout.TabView tabView, RectF rectF) {
        int contentWidth = tabView.getContentWidth();
        int iDpToPx = (int) ViewUtils.dpToPx(getContext(), 24);
        if (contentWidth < iDpToPx) {
            contentWidth = iDpToPx;
        }
        int right = (tabView.getRight() + tabView.getLeft()) / 2;
        int i8 = contentWidth / 2;
        rectF.set(right - i8, 0.0f, right + i8, 0.0f);
    }

    public final void b() {
        int left;
        int right;
        View childAt = getChildAt(this.f3720d);
        if (childAt == null || childAt.getWidth() <= 0) {
            left = -1;
            right = -1;
        } else {
            left = childAt.getLeft();
            right = childAt.getRight();
            TabLayout tabLayout = this.f3728o;
            boolean z2 = tabLayout.B;
            RectF rectF = tabLayout.e;
            if (!z2 && (childAt instanceof TabLayout.TabView)) {
                a((TabLayout.TabView) childAt, rectF);
                left = (int) rectF.left;
                right = (int) rectF.right;
            }
            if (this.e > 0.0f && this.f3720d < getChildCount() - 1) {
                View childAt2 = getChildAt(this.f3720d + 1);
                int left2 = childAt2.getLeft();
                int right2 = childAt2.getRight();
                if (!tabLayout.B && (childAt2 instanceof TabLayout.TabView)) {
                    a((TabLayout.TabView) childAt2, rectF);
                    left2 = (int) rectF.left;
                    right2 = (int) rectF.right;
                }
                float f = this.e;
                float f4 = left2 * f;
                float f10 = 1.0f - f;
                left = (int) ((left * f10) + f4);
                right = (int) ((f10 * right) + (f * right2));
            }
        }
        if (left == this.f3721h && right == this.f3722i) {
            return;
        }
        this.f3721h = left;
        this.f3722i = right;
        ViewCompat.postInvalidateOnAnimation(this);
    }

    public final void c(boolean z2, int i8, int i9) {
        View childAt = getChildAt(i8);
        if (childAt == null) {
            b();
            return;
        }
        int left = childAt.getLeft();
        int right = childAt.getRight();
        TabLayout tabLayout = this.f3728o;
        if (!tabLayout.B && (childAt instanceof TabLayout.TabView)) {
            RectF rectF = tabLayout.e;
            a((TabLayout.TabView) childAt, rectF);
            int i10 = (int) rectF.left;
            right = (int) rectF.right;
            left = i10;
        }
        int i11 = this.f3721h;
        int i12 = this.f3722i;
        if (i11 == left && i12 == right) {
            return;
        }
        if (z2) {
            this.f3726m = i11;
            this.f3727n = i12;
        }
        h hVar = new h(this, left, right, 0);
        if (!z2) {
            this.f3725l.removeAllUpdateListeners();
            this.f3725l.addUpdateListener(hVar);
            return;
        }
        ValueAnimator valueAnimator = new ValueAnimator();
        this.f3725l = valueAnimator;
        valueAnimator.setInterpolator(new ud.a());
        valueAnimator.setDuration(i9);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        valueAnimator.addUpdateListener(hVar);
        valueAnimator.addListener(new i(this, i8));
        valueAnimator.start();
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        TabLayout tabLayout = this.f3728o;
        Drawable drawable = tabLayout.f3693o;
        int height = 0;
        int intrinsicHeight = drawable != null ? drawable.getIntrinsicHeight() : 0;
        int i8 = this.f3717a;
        if (i8 >= 0) {
            intrinsicHeight = i8;
        }
        int i9 = tabLayout.f3700y;
        if (i9 == 0) {
            height = getHeight() - intrinsicHeight;
            intrinsicHeight = getHeight();
        } else if (i9 == 1) {
            height = (getHeight() - intrinsicHeight) / 2;
            intrinsicHeight = (getHeight() + intrinsicHeight) / 2;
        } else if (i9 != 2) {
            intrinsicHeight = i9 != 3 ? 0 : getHeight();
        }
        int i10 = this.f3721h;
        if (i10 >= 0 && this.f3722i > i10) {
            Drawable drawable2 = tabLayout.f3693o;
            if (drawable2 == null) {
                drawable2 = this.f3719c;
            }
            Drawable drawableWrap = DrawableCompat.wrap(drawable2);
            int i11 = this.f3721h;
            int i12 = this.f3723j;
            drawableWrap.setBounds(i11, height - i12, this.f3722i, intrinsicHeight - i12);
            Paint paint = this.f3718b;
            if (paint != null) {
                DrawableCompat.setTint(drawableWrap, paint.getColor());
            }
            drawableWrap.draw(canvas);
        }
        super.draw(canvas);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z2, int i8, int i9, int i10, int i11) {
        super.onLayout(z2, i8, i9, i10, i11);
        ValueAnimator valueAnimator = this.f3725l;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            b();
        } else {
            c(false, this.f3720d, -1);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i8, int i9) {
        super.onMeasure(i8, i9);
        if (View.MeasureSpec.getMode(i8) != 1073741824) {
            return;
        }
        TabLayout tabLayout = this.f3728o;
        boolean z2 = true;
        if (tabLayout.f3698w == 1 || tabLayout.f3701z == 2) {
            int childCount = getChildCount();
            int iMax = 0;
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = getChildAt(i10);
                if (childAt.getVisibility() == 0) {
                    iMax = Math.max(iMax, childAt.getMeasuredWidth());
                }
            }
            if (iMax <= 0) {
                return;
            }
            if (iMax * childCount <= getMeasuredWidth() - (((int) ViewUtils.dpToPx(getContext(), 16)) * 2)) {
                boolean z3 = false;
                for (int i11 = 0; i11 < childCount; i11++) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i11).getLayoutParams();
                    if (layoutParams.width != iMax || layoutParams.weight != 0.0f) {
                        layoutParams.width = iMax;
                        layoutParams.weight = 0.0f;
                        z3 = true;
                    }
                }
                z2 = z3;
            } else {
                tabLayout.f3698w = 0;
                tabLayout.s(false);
            }
            if (z2) {
                super.onMeasure(i8, i9);
            }
        }
    }
}
