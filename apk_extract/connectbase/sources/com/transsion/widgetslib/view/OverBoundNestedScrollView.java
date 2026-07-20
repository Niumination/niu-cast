package com.transsion.widgetslib.view;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ScrollingView;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import androidx.core.widget.EdgeEffectCompat;
import com.google.android.material.appbar.AppBarLayout;
import com.transsion.widgetslib.widget.OSMaskImageView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class OverBoundNestedScrollView extends FrameLayout implements NestedScrollingParent3, NestedScrollingChild3, ScrollingView {
    public static final int T = 250;
    public static final float U = 0.5f;
    public static final String V = "NestedScrollView";
    public static final int W = 250;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final int f2387a0 = -1;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final e f2388b0 = new e();

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final int[] f2389c0 = {R.attr.fillViewport};
    public int H;
    public int I;
    public final int[] J;
    public final int[] K;
    public int L;
    public int M;
    public SavedState N;
    public final NestedScrollingParentHelper O;
    public final NestedScrollingChildHelper P;
    public float Q;
    public f R;
    public g6.b S;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f2390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Rect f2391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public OverScroller f2392c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public EdgeEffect f2393d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public EdgeEffect f2394e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2395f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f2396g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f2397i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f2398n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f2399p;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public VelocityTracker f2400v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f2401w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f2402x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f2403y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f2404z;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2405a;

        public class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @NonNull
        public String toString() {
            StringBuilder sb2 = new StringBuilder("HorizontalScrollView.SavedState{");
            sb2.append(Integer.toHexString(System.identityHashCode(this)));
            sb2.append(" scrollPosition=");
            return c.a.a(sb2, this.f2405a, "}");
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f2405a);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f2405a = parcel.readInt();
        }
    }

    public class a extends h6.a {
        public a(View view) {
            super(view);
        }

        @Override // h6.a, us.b
        public boolean b() {
            return !OverBoundNestedScrollView.this.canScrollVertically(1);
        }

        @Override // h6.a, us.b
        public boolean c() {
            return !OverBoundNestedScrollView.this.canScrollVertically(-1);
        }
    }

    public class b implements AppBarLayout.OnOffsetChangedListener {
        public b() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i10) {
            if (OverBoundNestedScrollView.this.S != null) {
                if (i10 == 0) {
                    OverBoundNestedScrollView.this.S.c(true);
                    OverBoundNestedScrollView.this.S.e(false);
                    return;
                }
                OverBoundNestedScrollView.this.S.c(false);
                if (Math.abs(i10) >= appBarLayout.getTotalScrollRange()) {
                    OverBoundNestedScrollView.this.S.e(true);
                } else {
                    OverBoundNestedScrollView.this.S.e(false);
                }
            }
        }
    }

    public class c implements g6.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup.LayoutParams f2408a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f2409b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AppBarLayout f2410c;

        public c(ViewGroup.LayoutParams layoutParams, int i10, AppBarLayout appBarLayout) {
            this.f2408a = layoutParams;
            this.f2409b = i10;
            this.f2410c = appBarLayout;
        }

        @Override // g6.c
        public void a(float f10) {
            if (Float.compare(f10, 0.0f) >= 0) {
                ViewGroup.LayoutParams layoutParams = this.f2408a;
                layoutParams.height = this.f2409b + ((int) f10);
                this.f2410c.setLayoutParams(layoutParams);
            }
        }
    }

    public class d extends h6.a {
        public d(View view) {
            super(view);
        }

        @Override // h6.a, us.b
        public boolean b() {
            return !OverBoundNestedScrollView.this.canScrollVertically(1);
        }

        @Override // h6.a, us.b
        public boolean c() {
            return !OverBoundNestedScrollView.this.canScrollVertically(-1);
        }
    }

    public static class e extends AccessibilityDelegateCompat {
        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            OverBoundNestedScrollView overBoundNestedScrollView = (OverBoundNestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            accessibilityEvent.setScrollable(overBoundNestedScrollView.getScrollRange() > 0);
            accessibilityEvent.setScrollX(overBoundNestedScrollView.getScrollX());
            accessibilityEvent.setScrollY(overBoundNestedScrollView.getScrollY());
            AccessibilityRecordCompat.setMaxScrollX(accessibilityEvent, overBoundNestedScrollView.getScrollX());
            AccessibilityRecordCompat.setMaxScrollY(accessibilityEvent, overBoundNestedScrollView.getScrollRange());
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            int scrollRange;
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            OverBoundNestedScrollView overBoundNestedScrollView = (OverBoundNestedScrollView) view;
            accessibilityNodeInfoCompat.setClassName(ScrollView.class.getName());
            if (!overBoundNestedScrollView.isEnabled() || (scrollRange = overBoundNestedScrollView.getScrollRange()) <= 0) {
                return;
            }
            accessibilityNodeInfoCompat.setScrollable(true);
            if (overBoundNestedScrollView.getScrollY() > 0) {
                accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_UP);
            }
            if (overBoundNestedScrollView.getScrollY() < scrollRange) {
                accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_DOWN);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View view, int i10, Bundle bundle) {
            if (super.performAccessibilityAction(view, i10, bundle)) {
                return true;
            }
            OverBoundNestedScrollView overBoundNestedScrollView = (OverBoundNestedScrollView) view;
            if (!overBoundNestedScrollView.isEnabled()) {
                return false;
            }
            if (i10 != 4096) {
                if (i10 == 8192 || i10 == 16908344) {
                    int iMax = Math.max(overBoundNestedScrollView.getScrollY() - ((overBoundNestedScrollView.getHeight() - overBoundNestedScrollView.getPaddingBottom()) - overBoundNestedScrollView.getPaddingTop()), 0);
                    if (iMax == overBoundNestedScrollView.getScrollY()) {
                        return false;
                    }
                    overBoundNestedScrollView.P(0, iMax, true);
                    return true;
                }
                if (i10 != 16908346) {
                    return false;
                }
            }
            int iMin = Math.min(overBoundNestedScrollView.getScrollY() + ((overBoundNestedScrollView.getHeight() - overBoundNestedScrollView.getPaddingBottom()) - overBoundNestedScrollView.getPaddingTop()), overBoundNestedScrollView.getScrollRange());
            if (iMin == overBoundNestedScrollView.getScrollY()) {
                return false;
            }
            overBoundNestedScrollView.P(0, iMin, true);
            return true;
        }
    }

    public interface f {
        void a(OverBoundNestedScrollView overBoundNestedScrollView, int i10, int i11, int i12, int i13);
    }

    public OverBoundNestedScrollView(@NonNull Context context) {
        this(context, null, 0);
    }

    public static int f(int i10, int i11, int i12) {
        if (i11 >= i12 || i10 < 0) {
            return 0;
        }
        return i11 + i10 > i12 ? i12 - i11 : i10;
    }

    private float getVerticalScrollFactorCompat() {
        if (this.Q == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (!context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
            this.Q = typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return this.Q;
    }

    public static boolean w(View view, View view2) {
        if (view == view2) {
            return true;
        }
        Object parent = view.getParent();
        return (parent instanceof ViewGroup) && w((View) parent, view2);
    }

    public boolean A(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, boolean z10) {
        boolean z11;
        boolean z12;
        int overScrollMode = getOverScrollMode();
        boolean z13 = computeHorizontalScrollRange() > computeHorizontalScrollExtent();
        boolean z14 = computeVerticalScrollRange() > computeVerticalScrollExtent();
        boolean z15 = overScrollMode == 0 || (overScrollMode == 1 && z13);
        boolean z16 = overScrollMode == 0 || (overScrollMode == 1 && z14);
        int i18 = i12 + i10;
        int i19 = !z15 ? 0 : i16;
        int i20 = i13 + i11;
        int i21 = !z16 ? 0 : i17;
        int i22 = -i19;
        int i23 = i19 + i14;
        int i24 = -i21;
        int i25 = i21 + i15;
        if (i18 > i23) {
            i18 = i23;
            z11 = true;
        } else if (i18 < i22) {
            z11 = true;
            i18 = i22;
        } else {
            z11 = false;
        }
        if (i20 > i25) {
            i20 = i25;
            z12 = true;
        } else if (i20 < i24) {
            z12 = true;
            i20 = i24;
        } else {
            z12 = false;
        }
        if (z12 && !hasNestedScrollingParent(1)) {
            this.f2392c.springBack(i18, i20, 0, 0, 0, getScrollRange());
        }
        onOverScrolled(i18, i20, z11, z12);
        return z11 || z12;
    }

    public boolean B(int i10) {
        boolean z10 = i10 == 130;
        int height = getHeight();
        if (z10) {
            this.f2391b.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                int paddingBottom = getPaddingBottom() + childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
                Rect rect = this.f2391b;
                if (rect.top + height > paddingBottom) {
                    rect.top = paddingBottom - height;
                }
            }
        } else {
            this.f2391b.top = getScrollY() - height;
            Rect rect2 = this.f2391b;
            if (rect2.top < 0) {
                rect2.top = 0;
            }
        }
        Rect rect3 = this.f2391b;
        int i11 = rect3.top;
        int i12 = height + i11;
        rect3.bottom = i12;
        return E(i10, i11, i12);
    }

    public final void C() {
        VelocityTracker velocityTracker = this.f2400v;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f2400v = null;
        }
    }

    public final void D(boolean z10) {
        if (z10) {
            startNestedScroll(2, 1);
        } else {
            stopNestedScroll(1);
        }
        this.M = getScrollY();
        ViewCompat.postInvalidateOnAnimation(this);
    }

    public final boolean E(int i10, int i11, int i12) {
        int height = getHeight();
        int scrollY = getScrollY();
        int i13 = height + scrollY;
        boolean z10 = false;
        boolean z11 = i10 == 33;
        View viewM = m(z11, i11, i12);
        if (viewM == null) {
            viewM = this;
        }
        if (i11 < scrollY || i12 > i13) {
            h(z11 ? i11 - scrollY : i12 - i13);
            z10 = true;
        }
        if (viewM != findFocus()) {
            viewM.requestFocus(i10);
        }
        return z10;
    }

    public final void F(View view) {
        view.getDrawingRect(this.f2391b);
        offsetDescendantRectToMyCoords(view, this.f2391b);
        int iG = g(this.f2391b);
        if (iG != 0) {
            scrollBy(0, iG);
        }
    }

    public final boolean G(Rect rect, boolean z10) {
        int iG = g(rect);
        boolean z11 = iG != 0;
        if (z11) {
            if (z10) {
                scrollBy(0, iG);
            } else {
                J(0, iG);
            }
        }
        return z11;
    }

    public g6.b H() {
        setOverScrollMode(0);
        g6.b bVarB = g6.d.b(this, 0, new d(this));
        this.S = bVarB;
        return bVarB;
    }

    public g6.b I(AppBarLayout appBarLayout) {
        setOverScrollMode(0);
        g6.b bVarB = g6.d.b(this, 0, new a(this));
        this.S = bVarB;
        if (bVarB == null) {
            return null;
        }
        bVarB.g(true);
        this.S.f(true);
        appBarLayout.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new b());
        ViewGroup.LayoutParams layoutParams = appBarLayout.getLayoutParams();
        int i10 = layoutParams.height;
        g6.b bVar = this.S;
        if (bVar != null) {
            bVar.h(new c(layoutParams, i10, appBarLayout));
        }
        return this.S;
    }

    public final void J(int i10, int i11) {
        L(i10, i11, 250, false);
    }

    public final void K(int i10, int i11, int i12) {
        L(i10, i11, i12, false);
    }

    public final void L(int i10, int i11, int i12, boolean z10) {
        if (getChildCount() == 0) {
            return;
        }
        if (AnimationUtils.currentAnimationTimeMillis() - this.f2390a > 250) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int height = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            this.f2392c.startScroll(getScrollX(), scrollY, 0, Math.max(0, Math.min(i11 + scrollY, Math.max(0, height - height2))) - scrollY, i12);
            D(z10);
        } else {
            if (!this.f2392c.isFinished()) {
                a();
            }
            scrollBy(i10, i11);
        }
        this.f2390a = AnimationUtils.currentAnimationTimeMillis();
    }

    public final void M(int i10, int i11) {
        O(i10, i11, 250, false);
    }

    public final void N(int i10, int i11, int i12) {
        O(i10, i11, i12, false);
    }

    public void O(int i10, int i11, int i12, boolean z10) {
        L(i10 - getScrollX(), i11 - getScrollY(), i12, z10);
    }

    public void P(int i10, int i11, boolean z10) {
        O(i10, i11, 250, z10);
    }

    public final void a() {
        this.f2392c.abortAnimation();
        stopNestedScroll(1);
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view);
    }

    public boolean c(int i10) {
        View viewFindFocus = findFocus();
        if (viewFindFocus == this) {
            viewFindFocus = null;
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, i10);
        int maxScrollAmount = getMaxScrollAmount();
        if (viewFindNextFocus == null || !x(viewFindNextFocus, maxScrollAmount, getHeight())) {
            if (i10 == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i10 == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                maxScrollAmount = Math.min((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getHeight() + getScrollY()) - getPaddingBottom()), maxScrollAmount);
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i10 != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            h(maxScrollAmount);
        } else {
            viewFindNextFocus.getDrawingRect(this.f2391b);
            offsetDescendantRectToMyCoords(viewFindNextFocus, this.f2391b);
            h(g(this.f2391b));
            viewFindNextFocus.requestFocus(i10);
        }
        if (viewFindFocus == null || !viewFindFocus.isFocused() || !u(viewFindFocus)) {
            return true;
        }
        int descendantFocusability = getDescendantFocusability();
        setDescendantFocusability(131072);
        requestFocus();
        setDescendantFocusability(descendantFocusability);
        return true;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.f2392c.isFinished()) {
            return;
        }
        this.f2392c.computeScrollOffset();
        int currY = this.f2392c.getCurrY();
        int i10 = currY - this.M;
        this.M = currY;
        int[] iArr = this.K;
        iArr[1] = 0;
        dispatchNestedPreScroll(0, i10, iArr, null, 1);
        int i11 = i10 - this.K[1];
        int scrollRange = getScrollRange();
        if (i11 != 0) {
            int scrollY = getScrollY();
            A(0, i11, getScrollX(), scrollY, 0, scrollRange, 0, 0, false);
            int scrollY2 = getScrollY() - scrollY;
            int i12 = i11 - scrollY2;
            int[] iArr2 = this.K;
            iArr2[1] = 0;
            dispatchNestedScroll(0, scrollY2, 0, i12, this.J, 1, iArr2);
            i11 = i12 - this.K[1];
        }
        if (i11 != 0) {
            int overScrollMode = getOverScrollMode();
            if (overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0)) {
                k();
                if (i11 < 0) {
                    if (this.f2393d.isFinished()) {
                        this.f2393d.onAbsorb((int) this.f2392c.getCurrVelocity());
                    }
                } else if (this.f2394e.isFinished()) {
                    this.f2394e.onAbsorb((int) this.f2392c.getCurrVelocity());
                }
            }
            a();
        }
        if (this.f2392c.isFinished()) {
            stopNestedScroll(1);
        } else {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int iMax = Math.max(0, bottom - height);
        if (scrollY < 0) {
            return bottom - scrollY;
        }
        return scrollY > iMax ? bottom + (scrollY - iMax) : bottom;
    }

    public final boolean d() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin > (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || l(keyEvent);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f10, float f11, boolean z10) {
        return this.P.dispatchNestedFling(f10, f11, z10);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f10, float f11) {
        return this.P.dispatchNestedPreFling(f10, f11);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedPreScroll(int i10, int i11, int[] iArr, int[] iArr2, int i12) {
        return this.P.dispatchNestedPreScroll(i10, i11, iArr, iArr2, i12);
    }

    @Override // androidx.core.view.NestedScrollingChild3
    public void dispatchNestedScroll(int i10, int i11, int i12, int i13, @Nullable int[] iArr, int i14, @NonNull int[] iArr2) {
        this.P.dispatchNestedScroll(i10, i11, i12, i13, iArr, i14, iArr2);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int paddingLeft;
        super.draw(canvas);
        if (this.f2393d != null) {
            int scrollY = getScrollY();
            int paddingLeft2 = 0;
            if (!this.f2393d.isFinished()) {
                int iSave = canvas.save();
                int width = getWidth();
                int height = getHeight();
                int iMin = Math.min(0, scrollY);
                if (getClipToPadding()) {
                    width -= getPaddingRight() + getPaddingLeft();
                    paddingLeft = getPaddingLeft();
                } else {
                    paddingLeft = 0;
                }
                if (getClipToPadding()) {
                    height -= getPaddingBottom() + getPaddingTop();
                    iMin += getPaddingTop();
                }
                canvas.translate(paddingLeft, iMin);
                this.f2393d.setSize(width, height);
                if (this.f2393d.draw(canvas)) {
                    ViewCompat.postInvalidateOnAnimation(this);
                }
                canvas.restoreToCount(iSave);
            }
            if (this.f2394e.isFinished()) {
                return;
            }
            int iSave2 = canvas.save();
            int width2 = getWidth();
            int height2 = getHeight();
            int iMax = Math.max(getScrollRange(), scrollY) + height2;
            if (getClipToPadding()) {
                width2 -= getPaddingRight() + getPaddingLeft();
                paddingLeft2 = getPaddingLeft();
            }
            if (getClipToPadding()) {
                height2 -= getPaddingBottom() + getPaddingTop();
                iMax -= getPaddingBottom();
            }
            canvas.translate(paddingLeft2 - width2, iMax);
            canvas.rotate(180.0f, width2, 0.0f);
            this.f2394e.setSize(width2, height2);
            if (this.f2394e.draw(canvas)) {
                ViewCompat.postInvalidateOnAnimation(this);
            }
            canvas.restoreToCount(iSave2);
        }
    }

    public void e() {
        EdgeEffect edgeEffect = this.f2393d;
        if (edgeEffect instanceof g6.a) {
            ((g6.a) edgeEffect).a();
        }
        EdgeEffect edgeEffect2 = this.f2394e;
        if (edgeEffect2 instanceof g6.a) {
            ((g6.a) edgeEffect2).a();
        }
    }

    public int g(Rect rect) {
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i10 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int i11 = rect.bottom < (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin ? i10 - verticalFadingEdgeLength : i10;
        int i12 = rect.bottom;
        if (i12 > i11 && rect.top > scrollY) {
            return Math.min(rect.height() > height ? rect.top - scrollY : rect.bottom - i11, (childAt.getBottom() + layoutParams.bottomMargin) - i10);
        }
        if (rect.top >= scrollY || i12 >= i11) {
            return 0;
        }
        return Math.max(rect.height() > height ? 0 - (i11 - rect.bottom) : 0 - (scrollY - rect.top), -getScrollY());
    }

    @Override // android.view.View
    public float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + layoutParams.bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return bottom / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public EdgeEffect getEdgeGlowBottom() {
        return this.f2394e;
    }

    public EdgeEffect getEdgeGlowTop() {
        return this.f2393d;
    }

    public int getMaxScrollAmount() {
        return (int) (getHeight() * 0.5f);
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.O.getNestedScrollAxes();
    }

    public int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    @Override // android.view.View
    public float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return scrollY / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public final void h(int i10) {
        if (i10 != 0) {
            if (this.f2402x) {
                J(0, i10);
            } else {
                scrollBy(0, i10);
            }
        }
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean hasNestedScrollingParent(int i10) {
        return this.P.hasNestedScrollingParent(i10);
    }

    public void i() {
        this.f2393d = new g6.a(this, 1);
        this.f2394e = new g6.a(this, 3);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.P.isNestedScrollingEnabled();
    }

    public final void j() {
        this.f2399p = false;
        C();
        stopNestedScroll(0);
        EdgeEffect edgeEffect = this.f2393d;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            this.f2394e.onRelease();
        }
    }

    public final void k() {
        if (getOverScrollMode() == 2) {
            this.f2393d = null;
            this.f2394e = null;
        } else if (this.f2393d == null) {
            Context context = getContext();
            this.f2393d = new EdgeEffect(context);
            this.f2394e = new EdgeEffect(context);
        }
    }

    public boolean l(@NonNull KeyEvent keyEvent) {
        this.f2391b.setEmpty();
        boolean zD = d();
        int i10 = OSMaskImageView.f2731x;
        if (!zD) {
            if (!isFocused() || keyEvent.getKeyCode() == 4) {
                return false;
            }
            View viewFindFocus = findFocus();
            if (viewFindFocus == this) {
                viewFindFocus = null;
            }
            View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, OSMaskImageView.f2731x);
            return (viewFindNextFocus == null || viewFindNextFocus == this || !viewFindNextFocus.requestFocus(OSMaskImageView.f2731x)) ? false : true;
        }
        if (keyEvent.getAction() != 0) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 19) {
            return !keyEvent.isAltPressed() ? c(33) : o(33);
        }
        if (keyCode == 20) {
            return !keyEvent.isAltPressed() ? c(OSMaskImageView.f2731x) : o(OSMaskImageView.f2731x);
        }
        if (keyCode != 62) {
            return false;
        }
        if (keyEvent.isShiftPressed()) {
            i10 = 33;
        }
        B(i10);
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x004f  */
    public final View m(boolean z10, int i10, int i11) {
        ArrayList<View> focusables = getFocusables(2);
        int size = focusables.size();
        View view = null;
        boolean z11 = false;
        for (int i12 = 0; i12 < size; i12++) {
            View view2 = focusables.get(i12);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (i10 < bottom && top < i11) {
                boolean z12 = i10 < top && bottom < i11;
                if (view == null) {
                    view = view2;
                    z11 = z12;
                } else {
                    boolean z13 = (z10 && top < view.getTop()) || (!z10 && bottom > view.getBottom());
                    if (z11) {
                        if (z12 && z13) {
                            view = view2;
                        }
                    } else if (z12) {
                        view = view2;
                        z11 = true;
                    } else if (z13) {
                        view = view2;
                    }
                }
            }
        }
        return view;
    }

    @Override // android.view.ViewGroup
    public void measureChild(View view, int i10, int i11) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i10, getPaddingRight() + getPaddingLeft(), layoutParams.width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override // android.view.ViewGroup
    public void measureChildWithMargins(View view, int i10, int i11, int i12, int i13) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i10, getPaddingRight() + getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i11, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    public void n(int i10) {
        if (getChildCount() > 0) {
            this.f2392c.fling(getScrollX(), getScrollY(), 0, i10, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            D(true);
        }
    }

    public boolean o(int i10) {
        int childCount;
        boolean z10 = i10 == 130;
        int height = getHeight();
        Rect rect = this.f2391b;
        rect.top = 0;
        rect.bottom = height;
        if (z10 && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            this.f2391b.bottom = getPaddingBottom() + childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
            Rect rect2 = this.f2391b;
            rect2.top = rect2.bottom - height;
        }
        Rect rect3 = this.f2391b;
        return E(i10, rect3.top, rect3.bottom);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f2397i = false;
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) != 0 && motionEvent.getAction() == 8 && !this.f2399p) {
            float axisValue = motionEvent.getAxisValue(9);
            if (axisValue != 0.0f) {
                int verticalScrollFactorCompat = (int) (axisValue * getVerticalScrollFactorCompat());
                int scrollRange = getScrollRange();
                int scrollY = getScrollY();
                int i10 = scrollY - verticalScrollFactorCompat;
                if (i10 < 0) {
                    scrollRange = 0;
                } else if (i10 <= scrollRange) {
                    scrollRange = i10;
                }
                if (scrollRange != scrollY) {
                    super.scrollTo(getScrollX(), scrollRange);
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x007a  */
    /* JADX WARN: Code duplicated, block: B:33:0x0098  */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 2 && this.f2399p) {
            return true;
        }
        int i10 = action & 255;
        if (i10 == 0) {
            int y10 = (int) motionEvent.getY();
            if (p((int) motionEvent.getX(), y10)) {
                this.f2395f = y10;
                this.I = motionEvent.getPointerId(0);
                q();
                this.f2400v.addMovement(motionEvent);
                this.f2392c.computeScrollOffset();
                this.f2399p = !this.f2392c.isFinished();
                startNestedScroll(2, 0);
            } else {
                this.f2399p = false;
                C();
            }
        } else if (i10 == 1) {
            this.f2399p = false;
            this.I = -1;
            C();
            if (this.f2392c.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                ViewCompat.postInvalidateOnAnimation(this);
            }
            stopNestedScroll(0);
        } else if (i10 == 2) {
            int i11 = this.I;
            if (i11 != -1) {
                int iFindPointerIndex = motionEvent.findPointerIndex(i11);
                if (iFindPointerIndex == -1) {
                    Log.e(V, "Invalid pointerId=" + i11 + " in onInterceptTouchEvent");
                } else {
                    int y11 = (int) motionEvent.getY(iFindPointerIndex);
                    if (Math.abs(y11 - this.f2395f) > this.f2403y && (2 & getNestedScrollAxes()) == 0) {
                        this.f2399p = true;
                        this.f2395f = y11;
                        s();
                        this.f2400v.addMovement(motionEvent);
                        this.L = 0;
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                }
            }
        } else if (i10 == 3) {
            this.f2399p = false;
            this.I = -1;
            C();
            if (this.f2392c.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                ViewCompat.postInvalidateOnAnimation(this);
            }
            stopNestedScroll(0);
        } else if (i10 == 6) {
            z(motionEvent);
        }
        return this.f2399p;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        int measuredHeight = 0;
        this.f2396g = false;
        View view = this.f2398n;
        if (view != null && w(view, this)) {
            F(this.f2398n);
        }
        this.f2398n = null;
        if (!this.f2397i) {
            if (this.N != null) {
                scrollTo(getScrollX(), this.N.f2405a);
                this.N = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                measuredHeight = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            }
            int paddingTop = ((i13 - i11) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            int iF = f(scrollY, paddingTop, measuredHeight);
            if (iF != scrollY) {
                scrollTo(getScrollX(), iF);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.f2397i = true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (this.f2401w && View.MeasureSpec.getMode(i11) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                childAt.measure(ViewGroup.getChildMeasureSpec(i10, getPaddingRight() + getPaddingLeft() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(@NonNull View view, float f10, float f11, boolean z10) {
        if (z10) {
            return false;
        }
        dispatchNestedFling(0.0f, f11, true);
        n((int) f11);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(@NonNull View view, float f10, float f11) {
        return dispatchNestedPreFling(f10, f11);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(@NonNull View view, int i10, int i11, @NonNull int[] iArr, int i12) {
        dispatchNestedPreScroll(i10, i11, iArr, null, i12);
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(@NonNull View view, int i10, int i11, int i12, int i13, int i14, @NonNull int[] iArr) {
        y(i13, i14, iArr);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i10, int i11) {
        this.O.onNestedScrollAccepted(view, view2, i10, i11);
        startNestedScroll(2, i11);
    }

    @Override // android.view.View
    public void onOverScrolled(int i10, int i11, boolean z10, boolean z11) {
        super.scrollTo(i10, i11);
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i10, Rect rect) {
        if (i10 == 2) {
            i10 = OSMaskImageView.f2731x;
        } else if (i10 == 1) {
            i10 = 33;
        }
        View viewFindNextFocus = rect == null ? FocusFinder.getInstance().findNextFocus(this, null, i10) : FocusFinder.getInstance().findNextFocusFromRect(this, rect, i10);
        if (viewFindNextFocus == null || u(viewFindNextFocus)) {
            return false;
        }
        return viewFindNextFocus.requestFocus(i10, rect);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.N = savedState;
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f2405a = getScrollY();
        return savedState;
    }

    @Override // android.view.View
    public void onScrollChanged(int i10, int i11, int i12, int i13) {
        super.onScrollChanged(i10, i11, i12, i13);
        f fVar = this.R;
        if (fVar != null) {
            fVar.a(this, i10, i11, i12, i13);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        View viewFindFocus = findFocus();
        if (viewFindFocus == null || this == viewFindFocus || !x(viewFindFocus, 0, i13)) {
            return;
        }
        viewFindFocus.getDrawingRect(this.f2391b);
        offsetDescendantRectToMyCoords(viewFindFocus, this.f2391b);
        h(g(this.f2391b));
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i10, int i11) {
        return (i10 & 2) != 0;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(@NonNull View view, int i10) {
        this.O.onStopNestedScroll(view, i10);
        stopNestedScroll(i10);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        s();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.L = 0;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.offsetLocation(0.0f, this.L);
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                VelocityTracker velocityTracker = this.f2400v;
                velocityTracker.computeCurrentVelocity(1000, this.H);
                int yVelocity = (int) velocityTracker.getYVelocity(this.I);
                if (Math.abs(yVelocity) >= this.f2404z) {
                    int i10 = -yVelocity;
                    float f10 = i10;
                    if (!dispatchNestedPreFling(0.0f, f10)) {
                        dispatchNestedFling(0.0f, f10, true);
                        n(i10);
                    }
                } else if (this.f2392c.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    ViewCompat.postInvalidateOnAnimation(this);
                }
                this.I = -1;
                j();
            } else if (actionMasked == 2) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.I);
                if (iFindPointerIndex == -1) {
                    Log.e(V, "Invalid pointerId=" + this.I + " in onTouchEvent");
                } else {
                    int y10 = (int) motionEvent.getY(iFindPointerIndex);
                    int i11 = this.f2395f - y10;
                    if (!this.f2399p && Math.abs(i11) > this.f2403y) {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.f2399p = true;
                        i11 = i11 > 0 ? i11 - this.f2403y : i11 + this.f2403y;
                    }
                    int i12 = i11;
                    if (this.f2399p) {
                        if (dispatchNestedPreScroll(0, i12, this.K, this.J, 0)) {
                            i12 -= this.K[1];
                            this.L += this.J[1];
                        }
                        int i13 = i12;
                        this.f2395f = y10 - this.J[1];
                        int scrollY = getScrollY();
                        int scrollRange = getScrollRange();
                        int overScrollMode = getOverScrollMode();
                        boolean z10 = overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0);
                        if (A(0, i13, 0, getScrollY(), 0, scrollRange, 0, 0, true) && !hasNestedScrollingParent(0)) {
                            this.f2400v.clear();
                        }
                        int scrollY2 = getScrollY() - scrollY;
                        int[] iArr = this.K;
                        iArr[1] = 0;
                        dispatchNestedScroll(0, scrollY2, 0, i13 - scrollY2, this.J, 0, iArr);
                        int i14 = this.f2395f;
                        int i15 = this.J[1];
                        this.f2395f = i14 - i15;
                        this.L += i15;
                        if (z10) {
                            int i16 = i13 - this.K[1];
                            k();
                            int i17 = scrollY + i16;
                            if (i17 < 0) {
                                EdgeEffectCompat.onPull(this.f2393d, i16 / getHeight(), motionEvent.getX(iFindPointerIndex) / getWidth());
                                if (!this.f2394e.isFinished()) {
                                    this.f2394e.onRelease();
                                }
                            } else if (i17 > scrollRange) {
                                EdgeEffectCompat.onPull(this.f2394e, i16 / getHeight(), 1.0f - (motionEvent.getX(iFindPointerIndex) / getWidth()));
                                if (!this.f2393d.isFinished()) {
                                    this.f2393d.onRelease();
                                }
                            }
                            EdgeEffect edgeEffect = this.f2393d;
                            if (edgeEffect != null && (!edgeEffect.isFinished() || !this.f2394e.isFinished())) {
                                ViewCompat.postInvalidateOnAnimation(this);
                            }
                        }
                    }
                }
            } else if (actionMasked == 3) {
                if (this.f2399p && getChildCount() > 0 && this.f2392c.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    ViewCompat.postInvalidateOnAnimation(this);
                }
                this.I = -1;
                j();
            } else if (actionMasked == 5) {
                int actionIndex = motionEvent.getActionIndex();
                this.f2395f = (int) motionEvent.getY(actionIndex);
                this.I = motionEvent.getPointerId(actionIndex);
            } else if (actionMasked == 6) {
                z(motionEvent);
                this.f2395f = (int) motionEvent.getY(motionEvent.findPointerIndex(this.I));
            }
        } else {
            if (getChildCount() == 0) {
                return false;
            }
            boolean zIsFinished = this.f2392c.isFinished();
            this.f2399p = !zIsFinished;
            if (!zIsFinished && (parent = getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            if (!this.f2392c.isFinished()) {
                a();
            }
            this.f2395f = (int) motionEvent.getY();
            this.I = motionEvent.getPointerId(0);
            startNestedScroll(2, 0);
        }
        VelocityTracker velocityTracker2 = this.f2400v;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(motionEventObtain);
        }
        motionEventObtain.recycle();
        return true;
    }

    public final boolean p(int i10, int i11) {
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollY = getScrollY();
        View childAt = getChildAt(0);
        return i11 >= childAt.getTop() - scrollY && i11 < childAt.getBottom() - scrollY && i10 >= childAt.getLeft() && i10 < childAt.getRight();
    }

    public final void q() {
        VelocityTracker velocityTracker = this.f2400v;
        if (velocityTracker == null) {
            this.f2400v = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    public final void r() {
        this.f2392c = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f2403y = viewConfiguration.getScaledTouchSlop();
        this.f2404z = viewConfiguration.getScaledMinimumFlingVelocity();
        this.H = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (this.f2396g) {
            this.f2398n = view2;
        } else {
            F(view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z10) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return G(rect, z10);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z10) {
        if (z10) {
            C();
        }
        super.requestDisallowInterceptTouchEvent(z10);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        this.f2396g = true;
        super.requestLayout();
    }

    public final void s() {
        if (this.f2400v == null) {
            this.f2400v = VelocityTracker.obtain();
        }
    }

    @Override // android.view.View
    public void scrollTo(int i10, int i11) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int width2 = childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int height2 = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int iF = f(i10, width, width2);
            int iF2 = f(i11, height, height2);
            if (iF == getScrollX() && iF2 == getScrollY()) {
                return;
            }
            super.scrollTo(iF, iF2);
        }
    }

    public void setFillViewport(boolean z10) {
        if (z10 != this.f2401w) {
            this.f2401w = z10;
            requestLayout();
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z10) {
        this.P.setNestedScrollingEnabled(z10);
    }

    public void setOnScrollChangeListener(@Nullable f fVar) {
        this.R = fVar;
    }

    public void setSmoothScrollingEnabled(boolean z10) {
        this.f2402x = z10;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return true;
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean startNestedScroll(int i10, int i11) {
        return this.P.startNestedScroll(i10, i11);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public void stopNestedScroll(int i10) {
        this.P.stopNestedScroll(i10);
    }

    public boolean t() {
        return this.f2401w;
    }

    public final boolean u(View view) {
        return !x(view, 0, getHeight());
    }

    public boolean v() {
        return this.f2402x;
    }

    public final boolean x(View view, int i10, int i11) {
        view.getDrawingRect(this.f2391b);
        offsetDescendantRectToMyCoords(view, this.f2391b);
        return this.f2391b.bottom + i10 >= getScrollY() && this.f2391b.top - i10 <= getScrollY() + i11;
    }

    public final void y(int i10, int i11, @Nullable int[] iArr) {
        int scrollY = getScrollY();
        scrollBy(0, i10);
        int scrollY2 = getScrollY() - scrollY;
        if (iArr != null) {
            iArr[1] = iArr[1] + scrollY2;
        }
        this.P.dispatchNestedScroll(0, scrollY2, 0, i10 - scrollY2, null, i11, iArr);
    }

    public final void z(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.I) {
            int i10 = actionIndex == 0 ? 1 : 0;
            this.f2395f = (int) motionEvent.getY(i10);
            this.I = motionEvent.getPointerId(i10);
            VelocityTracker velocityTracker = this.f2400v;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    public OverBoundNestedScrollView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i10, int i11, int[] iArr, int[] iArr2) {
        return dispatchNestedPreScroll(i10, i11, iArr, iArr2, 0);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedScroll(int i10, int i11, int i12, int i13, int[] iArr, int i14) {
        return this.P.dispatchNestedScroll(i10, i11, i12, i13, iArr, i14);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return hasNestedScrollingParent(0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(@NonNull View view, int i10, int i11, @NonNull int[] iArr) {
        onNestedPreScroll(view, i10, i11, iArr, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(@NonNull View view, int i10, int i11, int i12, int i13, int i14) {
        y(i13, i14, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i10) {
        return onStartNestedScroll(view, view2, i10, 0);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i10) {
        return startNestedScroll(i10, 0);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        stopNestedScroll(0);
    }

    public OverBoundNestedScrollView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f2391b = new Rect();
        this.f2396g = true;
        this.f2397i = false;
        this.f2398n = null;
        this.f2399p = false;
        this.f2402x = true;
        this.I = -1;
        this.J = new int[2];
        this.K = new int[2];
        r();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f2389c0, i10, 0);
        setFillViewport(typedArrayObtainStyledAttributes.getBoolean(0, false));
        typedArrayObtainStyledAttributes.recycle();
        this.O = new NestedScrollingParentHelper(this);
        this.P = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        ViewCompat.setAccessibilityDelegate(this, f2388b0);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i10, int i11, int i12, int i13, int[] iArr) {
        return this.P.dispatchNestedScroll(i10, i11, i12, i13, iArr);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(@NonNull View view, int i10, int i11, int i12, int i13) {
        y(i13, 0, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i10) {
        onNestedScrollAccepted(view, view2, i10, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(@NonNull View view) {
        onStopNestedScroll(view, 0);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10) {
        if (getChildCount() <= 0) {
            super.addView(view, i10);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, i10, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }
}
