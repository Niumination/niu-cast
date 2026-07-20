package com.transsion.widgetslib.view.swipmenu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import androidx.core.content.ContextCompat;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.transsion.widgetslib.R$attr;
import com.transsion.widgetslib.R$color;
import com.transsion.widgetslib.R$dimen;
import com.transsion.widgetslib.R$styleable;
import java.util.ArrayList;
import java.util.HashMap;
import k3.z8;
import o.d;
import yd.a;
import yd.b;
import yd.c;
import yd.e;
import yd.j;
import yd.k;
import yd.l;
import yd.m;
import yd.n;
import yd.o;

/* JADX INFO: loaded from: classes2.dex */
public class OSSwipeMenuLayout extends ViewGroup implements LifecycleObserver {
    public static OSSwipeMenuLayout L;
    public static boolean M;
    public static int N;
    public boolean A;
    public boolean B;
    public int C;
    public int D;
    public final boolean E;
    public final boolean F;
    public final int G;
    public final int H;
    public final SwipeMenuExploreByTouchHelper I;
    public final int J;
    public int K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3347b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3348c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f3349d;
    public final PointF e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final PointF f3350h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final PointF f3351i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f3352j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Paint f3353k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Paint f3354l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public VelocityTracker f3355m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f3356n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f3357o;
    public boolean p;
    public final l q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f3358r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f3359s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Context f3360t;
    public final c u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final c f3361v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final a f3362w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final k f3363x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f3364y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f3365z;

    public OSSwipeMenuLayout(Context context) {
        this(context, null);
    }

    public static OSSwipeMenuLayout getViewCache() {
        return L;
    }

    public final void a(int i8) {
        float f = i8;
        float f4 = this.C;
        this.K = (int) (this.K + ((Float.compare(f4, 0.0f) != 0 ? ((float) Math.pow(1.0f - ((Math.abs(f) - Math.abs(f4)) / getMeasuredWidth()), 4.0d)) * 0.6f : 0.0f) * this.C));
        super.scrollTo(Math.max(0, Math.min(getScrollX(), 0)) + this.K, 0);
    }

    public final void b() {
        ViewCompat.setAccessibilityDelegate(this, this.I);
        SwipeMenuExploreByTouchHelper swipeMenuExploreByTouchHelper = this.I;
        OSSwipeMenuLayout oSSwipeMenuLayout = swipeMenuExploreByTouchHelper.f3367a;
        a swipeCurrentHorizontal = oSSwipeMenuLayout.getSwipeCurrentHorizontal();
        oSSwipeMenuLayout.getSwipeCurrentHorizontal().getMenuView();
        z8.f("SwipeMenuExploreByTouch", "addAccessAbilityInfo: mHorizontal.getMenuView().getMenuItems().size() = " + swipeCurrentHorizontal.getMenuView().getMenuItems().size());
        SparseArray sparseArray = swipeMenuExploreByTouchHelper.f3368b;
        sparseArray.clear();
        int size = swipeCurrentHorizontal.getMenuView().getMenuItems().size() + 1;
        for (int i8 = 1; i8 < size; i8++) {
            String strA = swipeMenuExploreByTouchHelper.a(i8);
            n nVar = new n();
            nVar.f11163a = strA;
            sparseArray.put(i8, nVar);
        }
        swipeMenuExploreByTouchHelper.invalidateRoot();
    }

    public final void c() {
        d(this.f3364y);
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0066  */
    @Override // android.view.View
    public final void computeScroll() {
        k kVar = this.f3363x;
        j jVar = kVar.f11155b;
        boolean z2 = jVar.f11147k;
        if (z2) {
            return;
        }
        int i8 = kVar.f11154a;
        if (i8 != 0) {
            if (i8 == 1 && !z2 && !jVar.d()) {
                int i9 = jVar.f11150n;
                if (i9 == 0) {
                    int i10 = jVar.f11144h;
                    if (i10 < jVar.f11145i) {
                        int i11 = jVar.f11141c;
                        jVar.f11139a = i11;
                        jVar.f11140b = i11;
                        int i12 = (int) jVar.e;
                        jVar.f11142d = i12;
                        jVar.f = i12 > 0 ? -2000.0f : 2000.0f;
                        jVar.f11143g += (long) i10;
                        jVar.f11150n = 3;
                        jVar.c(i11, i11, (int) (i12 * 0.85f));
                        jVar.d();
                    } else {
                        jVar.b();
                    }
                } else if (i9 != 1) {
                    if (i9 == 2) {
                        jVar.f11143g += (long) jVar.f11144h;
                        jVar.c(jVar.f11141c, jVar.f11139a, 0);
                    }
                    jVar.d();
                } else {
                    jVar.b();
                }
            }
        } else if (jVar.f11150n != 3 || z2) {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - jVar.f11143g;
            int i13 = jVar.f11144h;
            if (jCurrentAnimationTimeMillis < i13) {
                float interpolation = kVar.f11156c.getInterpolation(jCurrentAnimationTimeMillis / i13);
                if (jVar.f11150n != 3) {
                    int i14 = jVar.f11139a;
                    jVar.f11140b = Math.round(interpolation * (jVar.f11141c - i14)) + i14;
                }
            } else {
                kVar.f11155b.b();
            }
        }
        this.C = this.f3363x.getCurrPos() - getScrollX();
        scrollTo(this.f3363x.getCurrPos(), 0);
        invalidate();
    }

    public final void d(int i8) {
        View view = this.f3349d;
        if (view != null) {
            view.setLongClickable(true);
        }
        a aVar = this.f3362w;
        if (aVar != null) {
            aVar.a(this.f3363x, getScrollX(), i8);
            invalidate();
        }
        L = null;
        SwipeMenuExploreByTouchHelper swipeMenuExploreByTouchHelper = this.I;
        swipeMenuExploreByTouchHelper.getClass();
        z8.f("SwipeMenuExploreByTouch", "removeAccessAbilityInfo");
        swipeMenuExploreByTouchHelper.f3368b.clear();
        swipeMenuExploreByTouchHelper.invalidateRoot();
        ViewCompat.setAccessibilityDelegate(this, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return this.I.dispatchHoverEvent(motionEvent) | super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean zIsEmpty = this.q.getMenuItems().isEmpty();
        if (!this.f3356n || zIsEmpty) {
            M = false;
            OSSwipeMenuLayout oSSwipeMenuLayout = L;
            if (oSSwipeMenuLayout != null && oSSwipeMenuLayout != this && oSSwipeMenuLayout.f3356n) {
                oSSwipeMenuLayout.B = true;
                oSSwipeMenuLayout.f3363x.f11155b.b();
                L.c();
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.f3355m == null) {
            this.f3355m = VelocityTracker.obtain();
        }
        this.f3355m.addMovement(motionEvent);
        int action = motionEvent.getAction();
        PointF pointF = this.f3350h;
        PointF pointF2 = this.f3351i;
        if (action != 0) {
            if (action == 1 || action == 3) {
                j jVar = this.f3363x.f11155b;
                if (!jVar.f11147k) {
                    jVar.b();
                }
                if (motionEvent.getAction() == 1 && this.f3362w.g(getScrollX()) && Math.abs(motionEvent.getX() - pointF2.x) < this.f3346a) {
                    a aVar = this.f3362w;
                    int measuredWidth = getMeasuredWidth();
                    getMeasuredHeight();
                    int iF = aVar.f(measuredWidth, motionEvent, this.E);
                    this.A = iF >= 0 && iF < this.q.getMenuItems().size();
                }
                if (Math.abs(motionEvent.getRawX() - pointF.x) > this.f3346a) {
                    this.f3352j = true;
                }
                if (this.p && this.f3352j) {
                    this.f3355m.computeCurrentVelocity(1000, this.f3365z);
                    int xVelocity = (int) this.f3355m.getXVelocity(this.f3347b);
                    boolean z2 = this.f3357o ? xVelocity <= 0 : xVelocity >= 0;
                    boolean z3 = Math.abs(xVelocity) > this.H;
                    int x2 = (int) (motionEvent.getX() - getScrollX());
                    int menuWidth = this.f3362w.getMenuWidth();
                    int i8 = menuWidth / 2;
                    float f = menuWidth;
                    float f4 = i8;
                    int iMin = Math.min(xVelocity > 0 ? Math.round(Math.abs(((((float) Math.sin((float) (((double) (Math.min(1.0f, (Math.abs(x2) * 1.0f) / f) - 0.5f)) * 0.4712389167638204d))) * f4) + f4) / xVelocity) * 1000.0f) * 4 : (int) (((Math.abs(x2) / f) + 1.0f) * 100.0f), 350);
                    int scrollX = getScrollX();
                    if ((scrollX >= 0 && (!this.f3357o ? z2 && z3 : !z2)) || (scrollX <= 0 && (!z2 || !z3))) {
                        L = this;
                        this.f3363x.b(scrollX);
                        invalidate();
                        b();
                    } else if (xVelocity < 0) {
                        if (this.f3357o) {
                            if (z3) {
                                g(xVelocity);
                            } else {
                                f(iMin);
                            }
                        } else if (z3) {
                            e(xVelocity);
                        } else if ((-getScrollX()) > 0) {
                            f(this.f3364y);
                        } else {
                            d(iMin);
                        }
                    } else if (xVelocity > 0) {
                        if (this.f3357o) {
                            if (z3) {
                                e(xVelocity);
                            } else if (getScrollX() > 0) {
                                f(this.f3364y);
                            } else {
                                d(iMin);
                            }
                        } else if (z3) {
                            g(xVelocity);
                        } else {
                            f(iMin);
                        }
                    } else if (Math.abs(getScrollX()) > 0) {
                        f(iMin);
                    } else {
                        d(iMin);
                    }
                } else {
                    boolean z5 = this.f3357o;
                    int i9 = this.f3364y;
                    if (z5) {
                        if (getScrollX() > this.f3346a) {
                            if (motionEvent.getX() < getWidth() - getScrollX()) {
                                c();
                            } else if (!this.A) {
                                if (Math.abs(getScrollX()) > 0) {
                                    f(i9);
                                } else {
                                    d(i9);
                                }
                            }
                        } else if ((-getScrollX()) > this.f3346a) {
                            this.f3363x.b(getScrollX());
                            invalidate();
                        } else {
                            c();
                        }
                    } else if ((-getScrollX()) > this.f3346a) {
                        if (motionEvent.getX() > (-getScrollX())) {
                            c();
                        } else if (!this.A) {
                            if (Math.abs(getScrollX()) > 0) {
                                f(i9);
                            } else {
                                d(i9);
                            }
                        }
                    } else if (getScrollX() > this.f3346a) {
                        this.f3363x.b(getScrollX());
                        invalidate();
                    } else {
                        c();
                    }
                }
                VelocityTracker velocityTracker = this.f3355m;
                if (velocityTracker != null) {
                    velocityTracker.clear();
                    this.f3355m.recycle();
                    this.f3355m = null;
                }
                M = false;
                this.p = false;
                this.A = false;
            }
        } else {
            if (M) {
                return false;
            }
            M = true;
            this.f3352j = false;
            j jVar2 = this.f3363x.f11155b;
            if (!jVar2.f11147k) {
                jVar2.b();
            }
            this.K = 0;
            this.B = false;
            OSSwipeMenuLayout oSSwipeMenuLayout2 = L;
            if (oSSwipeMenuLayout2 != null && oSSwipeMenuLayout2 != this && oSSwipeMenuLayout2.f3356n) {
                oSSwipeMenuLayout2.B = true;
                oSSwipeMenuLayout2.f3363x.f11155b.b();
                L.c();
            }
            this.e.set(motionEvent.getRawX(), motionEvent.getRawY());
            pointF.set(motionEvent.getRawX(), motionEvent.getRawY());
            pointF2.set(motionEvent.getX(), motionEvent.getY());
            this.f3347b = motionEvent.getPointerId(0);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final void e(int i8) {
        View view = this.f3349d;
        if (view != null) {
            view.setLongClickable(true);
        }
        a aVar = this.f3362w;
        if (aVar != null) {
            aVar.b(this.f3363x, getScrollX(), -i8, Math.round(getWidth() * 0.5f * 0.3f));
            if (!this.f3357o ? this.f3363x.getFinalPos() < 0 : this.f3363x.getFinalPos() > 0) {
                c();
            }
            invalidate();
        }
        L = null;
        SwipeMenuExploreByTouchHelper swipeMenuExploreByTouchHelper = this.I;
        swipeMenuExploreByTouchHelper.getClass();
        z8.f("SwipeMenuExploreByTouch", "removeAccessAbilityInfo");
        swipeMenuExploreByTouchHelper.f3368b.clear();
        swipeMenuExploreByTouchHelper.invalidateRoot();
        ViewCompat.setAccessibilityDelegate(this, null);
    }

    public final void f(int i8) {
        L = this;
        View view = this.f3349d;
        if (view != null) {
            view.setLongClickable(false);
        }
        a aVar = this.f3362w;
        if (aVar != null) {
            aVar.c(this.f3363x, getScrollX(), i8);
            invalidate();
        }
        b();
    }

    public final void g(int i8) {
        L = this;
        View view = this.f3349d;
        if (view != null) {
            view.setLongClickable(false);
        }
        a aVar = this.f3362w;
        if (aVar != null) {
            aVar.d(this.f3363x, getScrollX(), -i8, Math.round(getWidth() * 0.5f * 0.3f));
            if (!this.f3357o ? this.f3363x.getFinalPos() > 0 : this.f3363x.getFinalPos() < 0) {
                j jVar = this.f3363x.f11155b;
                SpringAnimation springAnimation = jVar.f11151o;
                if (springAnimation != null && springAnimation.isRunning()) {
                    springAnimation.cancel();
                }
                jVar.f11147k = true;
                f(this.f3364y);
            }
            invalidate();
            b();
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public e getOnMenuItemClickListener() {
        return null;
    }

    public a getSwipeCurrentHorizontal() {
        return this.f3362w;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        HashMap map = o.f11164a;
        if (map != null) {
            for (Bitmap bitmap : map.values()) {
                if (!bitmap.isRecycled()) {
                    bitmap.recycle();
                }
            }
            map.clear();
        }
        if (L != null) {
            L = null;
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        l lVar = this.q;
        if (lVar == null || lVar.getMenuItems().size() <= 0) {
            return;
        }
        canvas.save();
        int scrollX = getScrollX();
        if (!this.f3357o ? scrollX < 0 : scrollX > 0) {
            int size = this.q.getMenuItems().size();
            Math.abs(scrollX / size);
            if (size > 0) {
                if (this.f3357o) {
                    getMeasuredWidth();
                }
                d.y(this.q.getMenuItems().get(0));
                throw null;
            }
        }
        canvas.restore();
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        if (this.E && this.F) {
            int i8 = this.G;
            z8.b(null, "decorateOutlineRoundCorner size = " + i8);
            setOutlineProvider(new yd.d(i8, 0));
            setClipToOutline(true);
            int i9 = this.G;
            z8.b(null, "decorateContentRoundCorner size = " + i9);
            yd.d dVar = new yd.d(i9, 1);
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                childAt.setOutlineProvider(dVar);
                childAt.setClipToOutline(true);
            }
        }
    }

    @Override // android.view.View
    public final void onFocusChanged(boolean z2, int i8, Rect rect) {
        super.onFocusChanged(z2, i8, rect);
        this.I.onFocusChanged(z2, i8, rect);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f3356n) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 2) {
                    float rawX = motionEvent.getRawX();
                    PointF pointF = this.f3350h;
                    int i8 = (int) (rawX - pointF.x);
                    int rawY = (int) (motionEvent.getRawY() - pointF.y);
                    if (Math.abs(motionEvent.getRawX() - pointF.x) > this.f3346a && Math.abs(i8) > Math.abs(rawY)) {
                        this.e.set(motionEvent.getRawX(), motionEvent.getRawY());
                        getParent().requestDisallowInterceptTouchEvent(true);
                        return true;
                    }
                }
            } else if (this.f3357o) {
                if (getScrollX() > this.f3346a && motionEvent.getX() < getWidth() - getScrollX()) {
                    return true;
                }
            } else if ((-getScrollX()) > this.f3346a && motionEvent.getX() > (-getScrollX())) {
                return true;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z2, int i8, int i9, int i10, int i11) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8 && i12 == 0) {
                childAt.layout(paddingLeft, getPaddingTop(), childAt.getMeasuredWidth() + paddingLeft, childAt.getMeasuredHeight() + getPaddingTop());
                paddingLeft = childAt.getMeasuredWidth() + paddingLeft;
            }
        }
        if (!this.f3357o) {
            getChildCount();
        }
        if (this.f3357o) {
            getChildCount();
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i8, int i9) {
        super.onMeasure(i8, i9);
        setClickable(true);
        int measuredWidth = 0;
        this.f3348c = 0;
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            childAt.setClickable(true);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i8, i9);
                this.f3348c = Math.max(this.f3348c, childAt.getMeasuredHeight());
                this.f3349d = childAt;
                measuredWidth = childAt.getMeasuredWidth();
            }
        }
        setMeasuredDimension(getPaddingRight() + getPaddingLeft() + measuredWidth, getPaddingBottom() + getPaddingTop() + this.f3348c);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f3356n) {
            return super.onTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 2) {
            int pointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
            int i8 = this.D;
            PointF pointF = this.e;
            if (pointerId != i8) {
                this.D = motionEvent.getPointerId(motionEvent.getActionIndex());
                pointF.set(motionEvent.getRawX(), motionEvent.getRawY());
            }
            this.p = true;
            float rawX = pointF.x - motionEvent.getRawX();
            if (Math.abs(rawX) > 10.0f || Math.abs(getScrollX()) > 10) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            Math.abs(rawX);
            scrollBy((int) rawX, 0);
            pointF.set(motionEvent.getRawX(), motionEvent.getRawY());
        }
        return true;
    }

    @Override // android.view.View
    public final boolean performLongClick() {
        if (Math.abs(getScrollX()) > this.f3346a) {
            return false;
        }
        return super.performLongClick();
    }

    @Override // android.view.View
    public final void scrollBy(int i8, int i9) {
        this.C = i8;
        scrollTo(getScrollX() + i8, i9);
    }

    @Override // android.view.View
    public final void scrollTo(int i8, int i9) {
        if (this.q.getMenuItems().isEmpty()) {
            return;
        }
        if (this.B) {
            super.scrollTo(i8, i9);
            return;
        }
        int scrollX = getScrollX() + this.C;
        boolean z2 = this.f3357o;
        boolean z3 = true;
        boolean z5 = !z2 ? scrollX >= 0 : scrollX <= 0;
        if (!z2 ? scrollX <= 0 : scrollX >= 0) {
            z3 = false;
        }
        j jVar = this.f3363x.f11155b;
        if (jVar.f11150n == 3 && !jVar.f11147k) {
            super.scrollTo(i8, i9);
        } else if (z3 || z5) {
            a(scrollX);
        } else {
            super.scrollTo(i8, i9);
        }
        this.C = 0;
    }

    public void setFlashCallCallBack(b bVar) {
    }

    public void setMenuCreator(m mVar) {
        this.q.getMenuItems().clear();
        throw null;
    }

    public void setOnMenuItemClickListener(e eVar) {
    }

    public void setSwipeEnable(boolean z2) {
        this.f3356n = z2;
    }

    public OSSwipeMenuLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OSSwipeMenuLayout(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        this.e = new PointF();
        this.f3350h = new PointF();
        this.f3351i = new PointF();
        this.f3358r = 82;
        this.f3359s = 64;
        this.f3364y = 350;
        this.F = true;
        this.f3360t = context;
        this.J = pd.j.k(context);
        this.f3358r = hd.a.a(this.f3360t, this.f3358r);
        this.f3359s = hd.a.a(this.f3360t, this.f3359s);
        this.f3346a = ViewConfiguration.get(this.f3360t).getScaledTouchSlop();
        this.H = (int) (getResources().getDisplayMetrics().density * 500.0f);
        this.f3356n = true;
        this.f3357o = true;
        this.E = pd.j.f8764a[0].equalsIgnoreCase(pd.j.getOsType());
        this.G = hd.a.a(context, 8);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.SwipeMenuLayout, i8, 0);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i9 = 0; i9 < indexCount; i9++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i9);
            if (index == R$styleable.SwipeMenuLayout_SwipeMenuLayoutSwipeEnable) {
                this.f3356n = typedArrayObtainStyledAttributes.getBoolean(index, true);
            } else if (index == R$styleable.SwipeMenuLayout_SwipeMenuLayoutLeftSwipe) {
                this.f3357o = typedArrayObtainStyledAttributes.getBoolean(index, true);
            } else if (index == R$styleable.SwipeMenuLayout_SwipeMenuLayoutIsHios) {
                this.E = typedArrayObtainStyledAttributes.getBoolean(index, this.E);
            } else if (index == R$styleable.SwipeMenuLayout_SwipeMenuLayoutAutoClipCorner) {
                this.F = typedArrayObtainStyledAttributes.getBoolean(index, true);
            } else if (index == R$styleable.SwipeMenuLayout_SwipeMenuLayoutCornerSize) {
                this.G = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.G);
            }
        }
        this.f3357o = !pd.j.v();
        typedArrayObtainStyledAttributes.recycle();
        Context context2 = this.f3360t;
        boolean z2 = this.E;
        l lVar = new l();
        lVar.f11161g = true;
        lVar.f11159c = context2;
        lVar.f11157a = 0;
        lVar.f11160d = z2;
        lVar.f11158b = new ArrayList(2);
        if (z2) {
            lVar.e = lVar.f11159c.getResources().getDimensionPixelSize(R$dimen.os_dimen_sm_menu_padding);
            lVar.f = lVar.f11159c.getResources().getDimensionPixelSize(R$dimen.os_dimen_sm_menu_item_padding);
            lVar.f11162h = lVar.f11159c.getResources().getDimensionPixelSize(R$dimen.os_dimen_sm_menu_item_circle_radius);
        }
        this.q = lVar;
        if (this.f3357o && this.u == null) {
            c cVar = new c(1, lVar, 0);
            this.u = cVar;
            cVar.setScreenWidth(this.J);
            this.f3362w = this.u;
            z8.f("OSSwipeMenuLayout", "resetCurrentSwipeController: mSwipeLeftHorizontal");
        }
        if (!this.f3357o && this.f3361v == null) {
            c cVar2 = new c(-1, this.q, 1);
            this.f3361v = cVar2;
            cVar2.setScreenWidth(this.J);
            this.f3362w = this.f3361v;
            z8.f("OSSwipeMenuLayout", "resetCurrentSwipeController: mSwipeRightHorizontal");
        }
        this.f3365z = ViewConfiguration.get(getContext()).getScaledMaximumFlingVelocity();
        this.f3363x = new k(getContext());
        setWillNotDraw(false);
        this.f3353k = new Paint();
        this.f3354l = new Paint();
        this.f3353k.setAntiAlias(true);
        this.f3354l.setAntiAlias(true);
        this.f3353k.setColor(SupportMenu.CATEGORY_MASK);
        new Paint();
        new Paint();
        int i10 = context.getResources().getConfiguration().uiMode & 48;
        if (N != i10) {
            N = i10;
            Context context3 = getContext();
            HashMap map = o.f11164a;
            if (map != null) {
                for (Integer num : map.keySet()) {
                    Drawable drawable = context3.getDrawable(num.intValue());
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas = new Canvas(bitmapCreateBitmap);
                    drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                    drawable.draw(canvas);
                    map.put(num, bitmapCreateBitmap);
                }
            }
        }
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(new int[]{R$attr.os_platform_basic_color});
        typedArrayObtainStyledAttributes2.getColor(0, context.getColor(R$color.os_platform_basic_color_hios));
        typedArrayObtainStyledAttributes2.recycle();
        ContextCompat.getColor(this.f3360t, R$color.os_altitude_secondary_color);
        ContextCompat.getColor(this.f3360t, R$color.os_red_basic_color);
        ContextCompat.getColor(this.f3360t, R$color.os_red_basic_color);
        ContextCompat.getColor(this.f3360t, R$color.os_gray_solid_tertiary_color);
        new Rect();
        new Rect();
        if (this.E) {
            Color.alpha(context.getColor(R$color.os_fill_icon_toggle_color));
        }
        this.I = new SwipeMenuExploreByTouchHelper(this);
    }
}
