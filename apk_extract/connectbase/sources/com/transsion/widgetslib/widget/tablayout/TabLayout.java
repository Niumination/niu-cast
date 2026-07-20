package com.transsion.widgetslib.widget.tablayout;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.BoolRes;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Pools;
import androidx.core.view.GravityCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.BadgeUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeUtils;
import com.transsion.widgetslib.R;
import com.transsion.widgetslib.view.BadgeView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
@ViewPager.DecorView
public class TabLayout extends HorizontalScrollView {
    public static final int A0 = 0;
    public static final int B0 = 1;
    public static final int C0 = 2;
    public static final int D0 = 0;
    public static final int E0 = 1;
    public static final int F0 = 2;
    public static final int G0 = 3;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    @Dimension(unit = 0)
    public static final int f3131k0 = 72;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    @Dimension(unit = 0)
    public static final int f3132l0 = 8;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    @Dimension(unit = 0)
    public static final int f3133m0 = 56;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    @Dimension(unit = 0)
    public static final int f3134n0 = 54;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    @Dimension(unit = 0)
    public static final int f3135o0 = 56;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    @Dimension(unit = 0)
    public static final int f3136p0 = 24;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    @Dimension(unit = 0)
    public static final int f3137q0 = 16;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public static final int f3138r0 = -1;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public static final int f3139s0 = 300;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public static final Pools.Pool<i> f3140t0 = new Pools.SynchronizedPool(16);

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public static final String f3141u0 = "TabLayout";

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public static final int f3142v0 = 0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public static final int f3143w0 = 1;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public static final int f3144x0 = 2;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public static final int f3145y0 = 0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public static final int f3146z0 = 1;
    public float H;
    public final int I;
    public int J;
    public final int K;
    public final int L;
    public final int M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public boolean S;
    public boolean T;
    public boolean U;

    @Nullable
    public c V;
    public final ArrayList<c> W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f3147a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    @Nullable
    public c f3148a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public OSTabLayout f3149b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public ValueAnimator f3150b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3151c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    @Nullable
    public ViewPager f3152c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList<i> f3153d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    @Nullable
    public PagerAdapter f3154d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public i f3155e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public DataSetObserver f3156e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final RectF f3157f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public TabLayoutOnPageChangeListener f3158f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final h f3159g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public b f3160g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public boolean f3161h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f3162i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public boolean f3163i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public final Pools.Pool<TabView> f3164j0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f3165n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f3166p;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f3167v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ColorStateList f3168w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ColorStateList f3169x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @Nullable
    public Drawable f3170y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f3171z;

    public static class TabLayoutOnPageChangeListener implements ViewPager.OnPageChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NonNull
        public final WeakReference<TabLayout> f3172a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f3173b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f3174c;

        public TabLayoutOnPageChangeListener(TabLayout tabLayout) {
            this.f3172a = new WeakReference<>(tabLayout);
        }

        public void a() {
            this.f3174c = 0;
            this.f3173b = 0;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i10) {
            this.f3173b = this.f3174c;
            this.f3174c = i10;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i10, float f10, int i11) {
            TabLayout tabLayout = this.f3172a.get();
            if (tabLayout != null) {
                int i12 = this.f3174c;
                tabLayout.T(i10, f10, i12 != 2 || this.f3173b == 1, (i12 == 2 && this.f3173b == 0) ? false : true);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i10) {
            TabLayout tabLayout = this.f3172a.get();
            if (tabLayout == null || tabLayout.getSelectedTabPosition() == i10 || i10 >= tabLayout.getTabCount()) {
                return;
            }
            int i11 = this.f3174c;
            tabLayout.Q(tabLayout.B(i10), i11 == 0 || (i11 == 2 && this.f3173b == 0));
        }
    }

    public final class TabView extends LinearLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public i f3175a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public TextView f3176b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ImageView f3177c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public View f3178d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        public BadgeDrawable f3179e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Nullable
        public View f3180f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Nullable
        public TextView f3181g;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @Nullable
        public ImageView f3182i;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        @Nullable
        public Drawable f3183n;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f3184p;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public boolean f3185v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public float f3186w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public Paint f3187x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public final int f3188y;

        public class a implements View.OnLayoutChangeListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ View f3190a;

            public a(View view) {
                this.f3190a = view;
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                if (this.f3190a.getVisibility() == 0) {
                    TabView.this.x(this.f3190a);
                }
            }
        }

        public TabView(Context context) {
            super(context);
            this.f3184p = 1;
            int color = Color.parseColor("#FF575C");
            this.f3188y = color;
            z(context);
            ViewCompat.setPaddingRelative(this, TabLayout.this.f3162i, TabLayout.this.f3165n, TabLayout.this.f3166p, TabLayout.this.f3167v);
            setGravity(17);
            setOrientation(!TabLayout.this.S ? 1 : 0);
            setClickable(true);
            ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), PointerIconCompat.TYPE_HAND));
            setWillNotDraw(false);
            this.f3186w = hj.h.e(getContext(), BadgeView.b(0)) / 2.0f;
            Paint paint = new Paint();
            this.f3187x = paint;
            paint.setAntiAlias(true);
            this.f3187x.setDither(true);
            this.f3187x.setColor(color);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public BadgeDrawable getBadge() {
            return this.f3179e;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getContentWidth() {
            View[] viewArr = {this.f3176b, this.f3177c, this.f3180f};
            int iMax = 0;
            int iMin = 0;
            boolean z10 = false;
            for (int i10 = 0; i10 < 3; i10++) {
                View view = viewArr[i10];
                if (view != null && view.getVisibility() == 0) {
                    iMin = z10 ? Math.min(iMin, view.getLeft()) : view.getLeft();
                    iMax = z10 ? Math.max(iMax, view.getRight()) : view.getRight();
                    z10 = true;
                }
            }
            return iMax - iMin;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @NonNull
        public BadgeDrawable getOrCreateBadge() {
            if (this.f3179e == null) {
                this.f3179e = BadgeDrawable.create(getContext());
            }
            w();
            BadgeDrawable badgeDrawable = this.f3179e;
            if (badgeDrawable != null) {
                return badgeDrawable;
            }
            throw new IllegalStateException("Unable to create badge");
        }

        public final void A() {
            setOrientation(!TabLayout.this.S ? 1 : 0);
            TextView textView = this.f3181g;
            if (textView == null && this.f3182i == null) {
                B(this.f3176b, this.f3177c);
            } else {
                B(textView, this.f3182i);
            }
        }

        public final void B(@Nullable TextView textView, @Nullable ImageView imageView) {
            i iVar = this.f3175a;
            Drawable drawableMutate = (iVar == null || iVar.g() == null) ? null : DrawableCompat.wrap(this.f3175a.g()).mutate();
            i iVar2 = this.f3175a;
            CharSequence charSequenceL = iVar2 != null ? iVar2.l() : null;
            if (imageView != null) {
                if (drawableMutate != null) {
                    imageView.setImageDrawable(drawableMutate);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable(null);
                }
            }
            boolean zIsEmpty = TextUtils.isEmpty(charSequenceL);
            if (textView != null) {
                if (imageView != null && imageView.getVisibility() == 0) {
                    textView.setVisibility(8);
                } else if (zIsEmpty) {
                    textView.setVisibility(8);
                    textView.setText((CharSequence) null);
                } else {
                    textView.setText(charSequenceL);
                    if (this.f3175a.f3220g == 1) {
                        textView.setVisibility(0);
                    } else {
                        textView.setVisibility(8);
                    }
                    setVisibility(0);
                }
            }
            if (imageView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                int iDpToPx = (zIsEmpty || imageView.getVisibility() != 0) ? 0 : (int) ViewUtils.dpToPx(getContext(), 8);
                if (TabLayout.this.S) {
                    if (iDpToPx != MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams)) {
                        MarginLayoutParamsCompat.setMarginEnd(marginLayoutParams, iDpToPx);
                        marginLayoutParams.bottomMargin = 0;
                        imageView.setLayoutParams(marginLayoutParams);
                        imageView.requestLayout();
                    }
                } else if (iDpToPx != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = iDpToPx;
                    MarginLayoutParamsCompat.setMarginEnd(marginLayoutParams, 0);
                    imageView.setLayoutParams(marginLayoutParams);
                    imageView.requestLayout();
                }
            }
            i iVar3 = this.f3175a;
            CharSequence charSequence = iVar3 != null ? iVar3.f3217d : null;
            if (zIsEmpty) {
                setTooltipText(charSequence);
            } else {
                setTooltipText(null);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        public void drawableStateChanged() {
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            Drawable drawable = this.f3183n;
            if ((drawable == null || !drawable.isStateful()) ? false : this.f3183n.setState(drawableState)) {
                invalidate();
                TabLayout.this.invalidate();
            }
        }

        @Nullable
        public i getTab() {
            return this.f3175a;
        }

        public final void i(@Nullable View view) {
            if (view == null) {
                return;
            }
            view.addOnLayoutChangeListener(new a(view));
        }

        public final float j(@NonNull Layout layout, int i10, float f10) {
            return (f10 / layout.getPaint().getTextSize()) * layout.getLineWidth(i10);
        }

        @NonNull
        public final FrameLayout k() {
            FrameLayout frameLayout = new FrameLayout(getContext());
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            return frameLayout;
        }

        public final void l(@NonNull Canvas canvas) {
            Drawable drawable = this.f3183n;
            if (drawable != null) {
                drawable.setBounds(getLeft(), getTop(), getRight(), getBottom());
                this.f3183n.draw(canvas);
            }
        }

        @Nullable
        public final FrameLayout m(@NonNull View view) {
            if ((view == this.f3177c || view == this.f3176b) && BadgeUtils.USE_COMPAT_PARENT) {
                return (FrameLayout) view.getParent();
            }
            return null;
        }

        public final boolean n() {
            return this.f3179e != null;
        }

        public void o() {
            this.f3185v = false;
            invalidate();
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onDraw(Canvas canvas) {
            TextView textView;
            super.onDraw(canvas);
            if (this.f3185v && (textView = this.f3176b) != null && textView.getVisibility() == 0) {
                canvas.drawCircle(hj.h.I() ? this.f3176b.getLeft() - this.f3186w : this.f3176b.getRight() + this.f3186w, (this.f3176b.getTop() + this.f3186w) - ui.a.d(getContext(), 2), this.f3186w, this.f3187x);
            }
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            BadgeDrawable badgeDrawable = this.f3179e;
            if (badgeDrawable != null && badgeDrawable.isVisible()) {
                accessibilityNodeInfo.setContentDescription(((Object) getContentDescription()) + ", " + ((Object) this.f3179e.getContentDescription()));
            }
            AccessibilityNodeInfoCompat accessibilityNodeInfoCompatWrap = AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo);
            accessibilityNodeInfoCompatWrap.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, this.f3175a.i(), 1, false, isSelected()));
            if (isSelected()) {
                accessibilityNodeInfoCompatWrap.setClickable(false);
                accessibilityNodeInfoCompatWrap.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
            }
            accessibilityNodeInfoCompatWrap.setRoleDescription("Tab");
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i10, int i11) {
            int size = View.MeasureSpec.getSize(i10);
            int mode = View.MeasureSpec.getMode(i10);
            int tabMaxWidth = TabLayout.this.getTabMaxWidth();
            if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                i10 = View.MeasureSpec.makeMeasureSpec(TabLayout.this.J, Integer.MIN_VALUE);
            }
            super.onMeasure(i10, i11);
            if (this.f3176b != null) {
                float f10 = TabLayout.this.f3171z;
                int i12 = this.f3184p;
                ImageView imageView = this.f3177c;
                if (imageView == null || imageView.getVisibility() != 0) {
                    TextView textView = this.f3176b;
                    if (textView != null && textView.getLineCount() > 1) {
                        f10 = TabLayout.this.H;
                    }
                } else {
                    i12 = 1;
                }
                float textSize = this.f3176b.getTextSize();
                this.f3176b.getLineCount();
                int maxLines = TextViewCompat.getMaxLines(this.f3176b);
                if (f10 != textSize || (maxLines >= 0 && i12 != maxLines)) {
                    this.f3176b.setTextSize(0, f10);
                    this.f3176b.setMaxLines(i12);
                    super.onMeasure(i10, i11);
                }
            }
        }

        public final void p() {
            ViewGroup viewGroup;
            if (BadgeUtils.USE_COMPAT_PARENT) {
                FrameLayout frameLayoutK = k();
                addView(frameLayoutK, 0);
                viewGroup = frameLayoutK;
            } else {
                viewGroup = this;
            }
            ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_icon, viewGroup, false);
            this.f3177c = imageView;
            viewGroup.addView(imageView, 0);
            if (TabLayout.this.f3151c) {
                viewGroup.setBackgroundResource(R.drawable.os_press_primary_bg);
            } else {
                viewGroup.setBackground(null);
            }
        }

        @Override // android.view.View
        public boolean performClick() {
            boolean zPerformClick = super.performClick();
            if (this.f3175a == null) {
                return zPerformClick;
            }
            if (!zPerformClick) {
                playSoundEffect(0);
            }
            this.f3175a.p();
            return true;
        }

        public final void q() {
            FrameLayout frameLayoutK;
            if (BadgeUtils.USE_COMPAT_PARENT) {
                frameLayoutK = k();
                addView(frameLayoutK);
            } else {
                frameLayoutK = this;
            }
            TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.os_design_layout_tab_text, (ViewGroup) frameLayoutK, false);
            this.f3176b = textView;
            textView.setId(R.id.os_id_tab_layout_text_view_id);
            frameLayoutK.addView(this.f3176b);
            if (TabLayout.this.f3151c) {
                frameLayoutK.setBackgroundResource(R.drawable.os_press_primary_bg);
            } else {
                frameLayoutK.setBackground(null);
            }
        }

        public final void r() {
            if (this.f3178d != null) {
                v();
            }
            this.f3179e = null;
        }

        public void s() {
            setTab(null);
            setSelected(false);
        }

        @Override // android.view.View
        public void setSelected(boolean z10) {
            isSelected();
            super.setSelected(z10);
            TextView textView = this.f3176b;
            if (textView != null) {
                textView.setSelected(z10);
                if (z10) {
                    if (TabLayout.this.f3163i0) {
                        this.f3176b.setTextAppearance(R.style.os_medium_fontweight);
                    } else {
                        this.f3176b.setTextAppearance(R.style.os_medium_fontweight);
                    }
                } else if (TabLayout.this.f3163i0) {
                    this.f3176b.setTextAppearance(R.style.os_regular_fontweight);
                } else {
                    this.f3176b.setTextAppearance(R.style.os_regular_fontweight);
                }
            }
            ImageView imageView = this.f3177c;
            if (imageView != null) {
                imageView.setSelected(z10);
            }
            View view = this.f3180f;
            if (view != null) {
                view.setSelected(z10);
            }
        }

        public void setTab(@Nullable i iVar) {
            if (iVar != this.f3175a) {
                this.f3175a = iVar;
                y();
            }
        }

        public void t() {
            this.f3185v = true;
            invalidate();
        }

        public final void u(@Nullable View view) {
            if (n() && view != null) {
                setClipChildren(false);
                setClipToPadding(false);
                BadgeUtils.attachBadgeDrawable(this.f3179e, view, m(view));
                this.f3178d = view;
            }
        }

        public final void v() {
            if (n() && this.f3178d != null) {
                setClipChildren(true);
                setClipToPadding(true);
                BadgeDrawable badgeDrawable = this.f3179e;
                View view = this.f3178d;
                BadgeUtils.detachBadgeDrawable(badgeDrawable, view, m(view));
                this.f3178d = null;
            }
        }

        public final void w() {
            i iVar;
            i iVar2;
            if (n()) {
                if (this.f3180f != null) {
                    v();
                    return;
                }
                if (this.f3177c != null && (iVar2 = this.f3175a) != null && iVar2.g() != null) {
                    View view = this.f3178d;
                    ImageView imageView = this.f3177c;
                    if (view == imageView) {
                        x(imageView);
                        return;
                    } else {
                        v();
                        u(this.f3177c);
                        return;
                    }
                }
                if (this.f3176b == null || (iVar = this.f3175a) == null || iVar.j() != 1) {
                    v();
                    return;
                }
                View view2 = this.f3178d;
                TextView textView = this.f3176b;
                if (view2 == textView) {
                    x(textView);
                } else {
                    v();
                    u(this.f3176b);
                }
            }
        }

        public final void x(@NonNull View view) {
            if (n() && view == this.f3178d) {
                BadgeUtils.setBadgeDrawableBounds(this.f3179e, view, m(view));
            }
        }

        public final void y() {
            i iVar = this.f3175a;
            View viewF = iVar != null ? iVar.f() : null;
            if (viewF != null) {
                ViewParent parent = viewF.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(viewF);
                    }
                    addView(viewF);
                }
                this.f3180f = viewF;
                TextView textView = this.f3176b;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f3177c;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f3177c.setImageDrawable(null);
                }
                TextView textView2 = (TextView) viewF.findViewById(android.R.id.text1);
                this.f3181g = textView2;
                if (textView2 != null) {
                    this.f3184p = TextViewCompat.getMaxLines(textView2);
                }
                this.f3182i = (ImageView) viewF.findViewById(android.R.id.icon);
            } else {
                View view = this.f3180f;
                if (view != null) {
                    removeView(view);
                    this.f3180f = null;
                }
                this.f3181g = null;
                this.f3182i = null;
            }
            if (this.f3180f == null) {
                if (this.f3177c == null) {
                    p();
                }
                if (iVar != null && iVar.g() != null) {
                    DrawableCompat.wrap(iVar.g()).mutate();
                }
                if (this.f3176b == null) {
                    q();
                }
                ColorStateList colorStateList = TabLayout.this.f3168w;
                if (colorStateList != null) {
                    this.f3176b.setTextColor(colorStateList);
                }
                B(this.f3176b, this.f3177c);
                w();
                i(this.f3177c);
                i(this.f3176b);
            } else {
                TextView textView3 = this.f3181g;
                if (textView3 != null || this.f3182i != null) {
                    B(textView3, this.f3182i);
                }
            }
            if (iVar != null && !TextUtils.isEmpty(iVar.f3217d)) {
                setContentDescription(iVar.f3217d);
            }
            setSelected(iVar != null && iVar.m());
        }

        public final void z(Context context) {
            GradientDrawable gradientDrawable;
            if (TabLayout.this.I != 0) {
                Drawable drawable = getResources().getDrawable(TabLayout.this.I);
                this.f3183n = drawable;
                if (drawable != null && drawable.isStateful()) {
                    this.f3183n.setState(getDrawableState());
                }
            } else {
                this.f3183n = null;
            }
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setColor(0);
            Drawable rippleDrawable = gradientDrawable2;
            if (TabLayout.this.f3169x != null) {
                GradientDrawable gradientDrawable3 = new GradientDrawable();
                gradientDrawable3.setCornerRadius(126.0f);
                gradientDrawable3.setColor(-1);
                ColorStateList colorStateList = TabLayout.this.f3169x;
                boolean z10 = TabLayout.this.U;
                if (z10) {
                    gradientDrawable = gradientDrawable2;
                    gradientDrawable = null;
                }
                rippleDrawable = new RippleDrawable(colorStateList, gradientDrawable, z10 ? null : gradientDrawable3);
            }
            ViewCompat.setBackground(this, rippleDrawable);
            TabLayout.this.invalidate();
        }
    }

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            TabLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
        }
    }

    public class b implements ViewPager.OnAdapterChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f3193a;

        public b() {
        }

        public void a(boolean z10) {
            this.f3193a = z10;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnAdapterChangeListener
        public void onAdapterChanged(@NonNull ViewPager viewPager, @Nullable PagerAdapter pagerAdapter, @Nullable PagerAdapter pagerAdapter2) {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.f3152c0 == viewPager) {
                tabLayout.R(pagerAdapter2, this.f3193a);
            }
        }
    }

    @Deprecated
    public interface c<T extends i> {
        void a(T t10);

        void b(T t10);

        void c(T t10);
    }

    public @interface d {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface e {
    }

    public interface f extends c<i> {
    }

    public class g extends DataSetObserver {
        public g() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            TabLayout.this.H();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            TabLayout.this.H();
        }
    }

    public class h extends LinearLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f3196a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NonNull
        public final Paint f3197b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NonNull
        public final GradientDrawable f3198c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f3199d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f3200e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f3201f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f3202g;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f3203i;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public ValueAnimator f3204n;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f3205p;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public int f3206v;

        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f3208a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f3209b;

            public a(int i10, int i11) {
                this.f3208a = i10;
                this.f3209b = i11;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                h hVar = h.this;
                hVar.g(AnimationUtils.lerp(hVar.f3205p, this.f3208a, animatedFraction), AnimationUtils.lerp(h.this.f3206v, this.f3209b, animatedFraction));
            }
        }

        public class b extends AnimatorListenerAdapter {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f3211a;

            public b(int i10) {
                this.f3211a = i10;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                h hVar = h.this;
                hVar.f3199d = this.f3211a;
                hVar.f3200e = 0.0f;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                h.this.f3199d = this.f3211a;
            }
        }

        public h(Context context) {
            super(context);
            this.f3199d = -1;
            this.f3201f = -1;
            this.f3202g = -1;
            this.f3203i = -1;
            this.f3205p = -1;
            this.f3206v = -1;
            setWillNotDraw(false);
            this.f3197b = new Paint();
            this.f3198c = new GradientDrawable();
        }

        public void c(int i10, int i11) {
            ValueAnimator valueAnimator = this.f3204n;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f3204n.cancel();
            }
            l(true, i10, i11);
        }

        public final void d(@NonNull TabView tabView, @NonNull RectF rectF) {
            int contentWidth = tabView.getContentWidth();
            int iDpToPx = (int) ViewUtils.dpToPx(getContext(), 24);
            if (contentWidth < iDpToPx) {
                contentWidth = iDpToPx;
            }
            int right = (tabView.getRight() + tabView.getLeft()) / 2;
            int i10 = contentWidth / 2;
            rectF.set(right - i10, 0.0f, right + i10, 0.0f);
        }

        @Override // android.view.View
        public void draw(@NonNull Canvas canvas) {
            Drawable drawable = TabLayout.this.f3170y;
            int height = 0;
            int intrinsicHeight = drawable != null ? drawable.getIntrinsicHeight() : 0;
            int i10 = this.f3196a;
            if (i10 >= 0) {
                intrinsicHeight = i10;
            }
            int i11 = TabLayout.this.Q;
            if (i11 == 0) {
                height = getHeight() - intrinsicHeight;
                intrinsicHeight = getHeight();
            } else if (i11 == 1) {
                height = (getHeight() - intrinsicHeight) / 2;
                intrinsicHeight = (getHeight() + intrinsicHeight) / 2;
            } else if (i11 != 2) {
                intrinsicHeight = i11 != 3 ? 0 : getHeight();
            }
            int i12 = this.f3202g;
            if (i12 >= 0 && this.f3203i > i12) {
                Drawable drawable2 = TabLayout.this.f3170y;
                if (drawable2 == null) {
                    drawable2 = this.f3198c;
                }
                Drawable drawableWrap = DrawableCompat.wrap(drawable2);
                drawableWrap.setBounds(this.f3202g, height, this.f3203i, intrinsicHeight);
                Paint paint = this.f3197b;
                if (paint != null) {
                    DrawableCompat.setTint(drawableWrap, paint.getColor());
                }
                drawableWrap.draw(canvas);
            }
            super.draw(canvas);
        }

        public boolean e() {
            int childCount = getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                if (getChildAt(i10).getWidth() <= 0) {
                    return true;
                }
            }
            return false;
        }

        public float f() {
            return this.f3199d + this.f3200e;
        }

        public void g(int i10, int i11) {
            if (i10 == this.f3202g && i11 == this.f3203i) {
                return;
            }
            this.f3202g = i10;
            this.f3203i = i11;
            ViewCompat.postInvalidateOnAnimation(this);
        }

        public void h(int i10, float f10) {
            ValueAnimator valueAnimator = this.f3204n;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f3204n.cancel();
            }
            this.f3199d = i10;
            this.f3200e = f10;
            k();
        }

        public void i(int i10) {
            if (this.f3197b.getColor() != i10) {
                this.f3197b.setColor(i10);
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        public void j(int i10) {
            if (this.f3196a != i10) {
                this.f3196a = i10;
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        public final void k() {
            int left;
            int right;
            View childAt = getChildAt(this.f3199d);
            if (childAt == null || childAt.getWidth() <= 0) {
                left = -1;
                right = -1;
            } else {
                left = childAt.getLeft();
                right = childAt.getRight();
                TabLayout tabLayout = TabLayout.this;
                if (!tabLayout.T && (childAt instanceof TabView)) {
                    d((TabView) childAt, tabLayout.f3157f);
                    RectF rectF = TabLayout.this.f3157f;
                    left = (int) rectF.left;
                    right = (int) rectF.right;
                }
                if (this.f3200e > 0.0f && this.f3199d < getChildCount() - 1) {
                    View childAt2 = getChildAt(this.f3199d + 1);
                    int left2 = childAt2.getLeft();
                    int right2 = childAt2.getRight();
                    TabLayout tabLayout2 = TabLayout.this;
                    if (!tabLayout2.T && (childAt2 instanceof TabView)) {
                        d((TabView) childAt2, tabLayout2.f3157f);
                        RectF rectF2 = TabLayout.this.f3157f;
                        left2 = (int) rectF2.left;
                        right2 = (int) rectF2.right;
                    }
                    float f10 = this.f3200e;
                    left = (int) (((1.0f - f10) * left) + (left2 * f10));
                    right = (int) (((1.0f - f10) * right) + (right2 * f10));
                }
            }
            g(left, right);
        }

        public final void l(boolean z10, int i10, int i11) {
            View childAt = getChildAt(i10);
            if (childAt == null) {
                k();
                return;
            }
            int left = childAt.getLeft();
            int right = childAt.getRight();
            TabLayout tabLayout = TabLayout.this;
            if (!tabLayout.T && (childAt instanceof TabView)) {
                d((TabView) childAt, tabLayout.f3157f);
                RectF rectF = TabLayout.this.f3157f;
                left = (int) rectF.left;
                right = (int) rectF.right;
            }
            int i12 = this.f3202g;
            int i13 = this.f3203i;
            if (i12 == left && i13 == right) {
                return;
            }
            if (z10) {
                this.f3205p = i12;
                this.f3206v = i13;
            }
            a aVar = new a(left, right);
            if (!z10) {
                this.f3204n.removeAllUpdateListeners();
                this.f3204n.addUpdateListener(aVar);
                return;
            }
            ValueAnimator valueAnimator = new ValueAnimator();
            this.f3204n = valueAnimator;
            valueAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
            valueAnimator.setDuration(i11);
            valueAnimator.setFloatValues(0.0f, 1.0f);
            valueAnimator.addUpdateListener(aVar);
            valueAnimator.addListener(new b(i10));
            valueAnimator.start();
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
            super.onLayout(z10, i10, i11, i12, i13);
            ValueAnimator valueAnimator = this.f3204n;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                k();
            } else {
                l(false, this.f3199d, -1);
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i10, int i11) {
            super.onMeasure(i10, i11);
            if (View.MeasureSpec.getMode(i10) != 1073741824) {
                return;
            }
            TabLayout tabLayout = TabLayout.this;
            boolean z10 = true;
            if (tabLayout.O == 1 || tabLayout.R == 2) {
                int childCount = getChildCount();
                int iMax = 0;
                for (int i12 = 0; i12 < childCount; i12++) {
                    View childAt = getChildAt(i12);
                    if (childAt.getVisibility() == 0) {
                        iMax = Math.max(iMax, childAt.getMeasuredWidth());
                    }
                }
                if (iMax <= 0) {
                    return;
                }
                if (iMax * childCount <= getMeasuredWidth() - (((int) ViewUtils.dpToPx(getContext(), 16)) * 2)) {
                    boolean z11 = false;
                    for (int i13 = 0; i13 < childCount; i13++) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i13).getLayoutParams();
                        if (layoutParams.width != iMax || layoutParams.weight != 0.0f) {
                            layoutParams.width = iMax;
                            layoutParams.weight = 0.0f;
                            z11 = true;
                        }
                    }
                    z10 = z11;
                } else {
                    TabLayout tabLayout2 = TabLayout.this;
                    tabLayout2.O = 0;
                    tabLayout2.a0(false);
                }
                if (z10) {
                    super.onMeasure(i10, i11);
                }
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onRtlPropertiesChanged(int i10) {
            super.onRtlPropertiesChanged(i10);
        }
    }

    public static class i {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final int f3213j = -1;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public Object f3214a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public Drawable f3215b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public CharSequence f3216c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public CharSequence f3217d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Nullable
        public View f3219f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @Nullable
        public TabLayout f3221h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @NonNull
        public TabView f3222i;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f3218e = -1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @d
        public int f3220g = 1;

        @NonNull
        public i A(@Nullable CharSequence charSequence) {
            if (TextUtils.isEmpty(this.f3217d) && !TextUtils.isEmpty(charSequence)) {
                this.f3222i.setContentDescription(charSequence);
            }
            this.f3216c = charSequence;
            B();
            return this;
        }

        public void B() {
            TabView tabView = this.f3222i;
            if (tabView != null) {
                tabView.y();
            }
        }

        @Nullable
        public BadgeDrawable d() {
            return this.f3222i.getBadge();
        }

        @Nullable
        public CharSequence e() {
            TabView tabView = this.f3222i;
            if (tabView == null) {
                return null;
            }
            return tabView.getContentDescription();
        }

        @Nullable
        public View f() {
            return this.f3219f;
        }

        @Nullable
        public Drawable g() {
            return this.f3215b;
        }

        @NonNull
        public BadgeDrawable h() {
            return this.f3222i.getOrCreateBadge();
        }

        public int i() {
            return this.f3218e;
        }

        @d
        public int j() {
            return this.f3220g;
        }

        @Nullable
        public Object k() {
            return this.f3214a;
        }

        @Nullable
        public CharSequence l() {
            return this.f3216c;
        }

        public boolean m() {
            TabLayout tabLayout = this.f3221h;
            if (tabLayout != null) {
                return tabLayout.getSelectedTabPosition() == this.f3218e;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public void n() {
            this.f3222i.r();
        }

        public void o() {
            this.f3221h = null;
            this.f3222i = null;
            this.f3214a = null;
            this.f3215b = null;
            this.f3216c = null;
            this.f3217d = null;
            this.f3218e = -1;
            this.f3219f = null;
        }

        public void p() {
            TabLayout tabLayout = this.f3221h;
            if (tabLayout == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            tabLayout.P(this);
        }

        @NonNull
        public i q(@StringRes int i10) {
            TabLayout tabLayout = this.f3221h;
            if (tabLayout != null) {
                return r(tabLayout.getResources().getText(i10));
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        @NonNull
        public i r(@Nullable CharSequence charSequence) {
            this.f3217d = charSequence;
            B();
            return this;
        }

        @NonNull
        public i s(@LayoutRes int i10) {
            return t(LayoutInflater.from(this.f3222i.getContext()).inflate(i10, (ViewGroup) this.f3222i, false));
        }

        @NonNull
        public i t(@Nullable View view) {
            this.f3219f = view;
            B();
            return this;
        }

        @NonNull
        public i u(@DrawableRes int i10) {
            TabLayout tabLayout = this.f3221h;
            if (tabLayout != null) {
                return v(tabLayout.getResources().getDrawable(i10));
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        @NonNull
        public i v(@Nullable Drawable drawable) {
            this.f3215b = drawable;
            TabLayout tabLayout = this.f3221h;
            if (tabLayout.O == 1 || tabLayout.R == 2) {
                tabLayout.a0(true);
            }
            B();
            if (BadgeUtils.USE_COMPAT_PARENT && this.f3222i.n() && this.f3222i.f3179e.isVisible()) {
                this.f3222i.invalidate();
            }
            return this;
        }

        public void w(int i10) {
            this.f3218e = i10;
        }

        @NonNull
        public i x(@d int i10) {
            this.f3220g = i10;
            TabLayout tabLayout = this.f3221h;
            if (tabLayout.O == 1 || tabLayout.R == 2) {
                tabLayout.a0(true);
            }
            B();
            if (BadgeUtils.USE_COMPAT_PARENT && this.f3222i.n() && this.f3222i.f3179e.isVisible()) {
                this.f3222i.invalidate();
            }
            return this;
        }

        @NonNull
        public i y(@Nullable Object obj) {
            this.f3214a = obj;
            return this;
        }

        @NonNull
        public i z(@StringRes int i10) {
            TabLayout tabLayout = this.f3221h;
            if (tabLayout != null) {
                return A(tabLayout.getResources().getText(i10));
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface j {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface k {
    }

    public static class l implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ViewPager f3223a;

        public l(ViewPager viewPager) {
            this.f3223a = viewPager;
        }

        @Override // com.transsion.widgetslib.widget.tablayout.TabLayout.c
        public void a(i iVar) {
        }

        @Override // com.transsion.widgetslib.widget.tablayout.TabLayout.c
        public void b(@NonNull i iVar) {
            this.f3223a.setCurrentItem(iVar.i());
        }

        @Override // com.transsion.widgetslib.widget.tablayout.TabLayout.c
        public void c(i iVar) {
        }
    }

    public TabLayout(@NonNull Context context) {
        this(context, null);
    }

    @Dimension(unit = 0)
    private int getDefaultHeight() {
        int size = this.f3153d.size();
        for (int i10 = 0; i10 < size; i10++) {
            i iVar = this.f3153d.get(i10);
            if (iVar != null && iVar.g() != null && !TextUtils.isEmpty(iVar.l())) {
                if (this.S) {
                    break;
                }
                return 72;
            }
        }
        return this.f3163i0 ? 56 : 54;
    }

    private int getTabMinWidth() {
        int i10 = this.K;
        if (i10 != -1) {
            return i10;
        }
        int i11 = this.R;
        if (i11 == 0 || i11 == 2) {
            return this.M;
        }
        return 0;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.f3159g.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void setSelectedTabView(int i10) {
        int childCount = this.f3159g.getChildCount();
        if (i10 < childCount) {
            int i11 = 0;
            while (i11 < childCount) {
                View childAt = this.f3159g.getChildAt(i11);
                boolean z10 = true;
                childAt.setSelected(i11 == i10);
                if (i11 != i10) {
                    z10 = false;
                }
                childAt.setActivated(z10);
                i11++;
            }
        }
    }

    @NonNull
    public static ColorStateList t(int i10, int i11) {
        return new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{i11, i10});
    }

    public final void A() {
        if (this.f3150b0 == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.f3150b0 = valueAnimator;
            valueAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
            this.f3150b0.setDuration(this.P);
            this.f3150b0.addUpdateListener(new a());
        }
    }

    @Nullable
    public i B(int i10) {
        if (i10 < 0 || i10 >= getTabCount()) {
            return null;
        }
        return this.f3153d.get(i10);
    }

    public boolean C() {
        return this.U;
    }

    public void D(boolean z10) {
        this.f3163i0 = z10;
        V();
    }

    public boolean E() {
        return this.S;
    }

    public boolean F() {
        return this.T;
    }

    @NonNull
    public i G() {
        i iVarV = v();
        iVarV.f3221h = this;
        iVarV.f3222i = w(iVarV);
        return iVarV;
    }

    public void H() {
        int currentItem;
        J();
        PagerAdapter pagerAdapter = this.f3154d0;
        if (pagerAdapter != null) {
            int count = pagerAdapter.getCount();
            for (int i10 = 0; i10 < count; i10++) {
                i(G().A(this.f3154d0.getPageTitle(i10)), false);
            }
            ViewPager viewPager = this.f3152c0;
            if (viewPager == null || count <= 0 || (currentItem = viewPager.getCurrentItem()) == getSelectedTabPosition() || currentItem >= getTabCount()) {
                return;
            }
            P(B(currentItem));
        }
    }

    public boolean I(i iVar) {
        return f3140t0.release(iVar);
    }

    public void J() {
        for (int childCount = this.f3159g.getChildCount() - 1; childCount >= 0; childCount--) {
            O(childCount);
        }
        Iterator<i> it = this.f3153d.iterator();
        while (it.hasNext()) {
            i next = it.next();
            it.remove();
            next.o();
            I(next);
        }
        this.f3155e = null;
    }

    @Deprecated
    public void K(@Nullable c cVar) {
        this.W.remove(cVar);
    }

    public void L(@NonNull f fVar) {
        K(fVar);
    }

    public void M(@NonNull i iVar) {
        if (iVar.f3221h != this) {
            throw new IllegalArgumentException("Tab does not belong to this TabLayout.");
        }
        N(iVar.i());
    }

    public void N(int i10) {
        i iVar = this.f3155e;
        int i11 = iVar != null ? iVar.i() : 0;
        O(i10);
        i iVarRemove = this.f3153d.remove(i10);
        if (iVarRemove != null) {
            iVarRemove.o();
            I(iVarRemove);
        }
        int size = this.f3153d.size();
        for (int i12 = i10; i12 < size; i12++) {
            this.f3153d.get(i12).w(i12);
        }
        if (i11 == i10) {
            P(this.f3153d.isEmpty() ? null : this.f3153d.get(Math.max(0, i10 - 1)));
        }
    }

    public final void O(int i10) {
        TabView tabView = (TabView) this.f3159g.getChildAt(i10);
        this.f3159g.removeViewAt(i10);
        if (tabView != null) {
            tabView.s();
            this.f3164j0.release(tabView);
        }
        requestLayout();
    }

    public void P(@Nullable i iVar) {
        Q(iVar, true);
    }

    public void Q(@Nullable i iVar, boolean z10) {
        i iVar2 = this.f3155e;
        if (iVar2 == iVar) {
            if (iVar2 != null) {
                x(iVar);
                m(iVar.i());
                return;
            }
            return;
        }
        int i10 = iVar != null ? iVar.i() : -1;
        if (z10) {
            if ((iVar2 == null || iVar2.i() == -1) && i10 != -1) {
                S(i10, 0.0f, true);
            } else {
                m(i10);
            }
            if (i10 != -1) {
                setSelectedTabView(i10);
            }
        }
        this.f3155e = iVar;
        if (iVar2 != null) {
            z(iVar2);
        }
        if (iVar != null) {
            y(iVar);
        }
    }

    public void R(@Nullable PagerAdapter pagerAdapter, boolean z10) {
        DataSetObserver dataSetObserver;
        PagerAdapter pagerAdapter2 = this.f3154d0;
        if (pagerAdapter2 != null && (dataSetObserver = this.f3156e0) != null) {
            pagerAdapter2.unregisterDataSetObserver(dataSetObserver);
        }
        this.f3154d0 = pagerAdapter;
        if (z10 && pagerAdapter != null) {
            if (this.f3156e0 == null) {
                this.f3156e0 = new g();
            }
            pagerAdapter.registerDataSetObserver(this.f3156e0);
        }
        H();
    }

    public void S(int i10, float f10, boolean z10) {
        T(i10, f10, z10, true);
    }

    public void T(int i10, float f10, boolean z10, boolean z11) {
        int iRound = Math.round(i10 + f10);
        if (iRound < 0 || iRound >= this.f3159g.getChildCount()) {
            return;
        }
        if (z11) {
            this.f3159g.h(i10, f10);
        }
        ValueAnimator valueAnimator = this.f3150b0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f3150b0.cancel();
        }
        scrollTo(q(i10, f10), 0);
        if (z10) {
            setSelectedTabView(iRound);
        }
    }

    public void U(int i10, int i11) {
        setTabTextColors(t(i10, i11));
    }

    public final void V() {
        Resources.Theme theme = getContext().getTheme();
        if (this.f3163i0) {
            this.f3171z = getResources().getDimensionPixelOffset(R.dimen.os_tab_first_level_title_size);
            this.H = getResources().getDimensionPixelSize(R.dimen.os_tab_first_level_title_size);
            this.f3168w = getResources().getColorStateList(R.color.os_text_secondary_color, theme);
        } else {
            this.f3171z = getResources().getDimensionPixelOffset(R.dimen.os_tab_second_level_title_size);
            this.H = getResources().getDimensionPixelSize(R.dimen.os_tab_second_level_title_size);
            this.f3168w = getResources().getColorStateList(R.color.os_text_secondary_color, theme);
        }
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{R.attr.os_platform_basic_color});
        int color = typedArrayObtainStyledAttributes.getColor(0, getResources().getColor(R.color.os_platform_basic_color_hios));
        typedArrayObtainStyledAttributes.recycle();
        this.f3168w = t(this.f3168w.getDefaultColor(), color);
    }

    public void W(@Nullable ViewPager viewPager, boolean z10) {
        X(viewPager, z10, false);
    }

    public final void X(@Nullable ViewPager viewPager, boolean z10, boolean z11) {
        ViewPager viewPager2 = this.f3152c0;
        if (viewPager2 != null) {
            TabLayoutOnPageChangeListener tabLayoutOnPageChangeListener = this.f3158f0;
            if (tabLayoutOnPageChangeListener != null) {
                viewPager2.removeOnPageChangeListener(tabLayoutOnPageChangeListener);
            }
            b bVar = this.f3160g0;
            if (bVar != null) {
                this.f3152c0.removeOnAdapterChangeListener(bVar);
            }
        }
        c cVar = this.f3148a0;
        if (cVar != null) {
            K(cVar);
            this.f3148a0 = null;
        }
        if (viewPager != null) {
            this.f3152c0 = viewPager;
            if (this.f3158f0 == null) {
                this.f3158f0 = new TabLayoutOnPageChangeListener(this);
            }
            this.f3158f0.a();
            viewPager.addOnPageChangeListener(this.f3158f0);
            l lVar = new l(viewPager);
            this.f3148a0 = lVar;
            d(lVar);
            PagerAdapter adapter = viewPager.getAdapter();
            if (adapter != null) {
                R(adapter, z10);
            }
            if (this.f3160g0 == null) {
                this.f3160g0 = new b();
            }
            this.f3160g0.a(z10);
            viewPager.addOnAdapterChangeListener(this.f3160g0);
            S(viewPager.getCurrentItem(), 0.0f, true);
        } else {
            this.f3152c0 = null;
            R(null, false);
        }
        this.f3161h0 = z11;
    }

    public final void Y() {
        int size = this.f3153d.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f3153d.get(i10).B();
        }
    }

    public final void Z(@NonNull LinearLayout.LayoutParams layoutParams) {
        if (this.R == 1 && this.O == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
        } else {
            layoutParams.width = -2;
            layoutParams.weight = 0.0f;
        }
    }

    public void a0(boolean z10) {
        for (int i10 = 0; i10 < this.f3159g.getChildCount(); i10++) {
            View childAt = this.f3159g.getChildAt(i10);
            childAt.setMinimumWidth(getTabMinWidth());
            Z((LinearLayout.LayoutParams) childAt.getLayoutParams());
            if (z10) {
                childAt.requestLayout();
            }
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view) {
        l(view);
    }

    @Deprecated
    public void d(@Nullable c cVar) {
        if (this.W.contains(cVar)) {
            return;
        }
        this.W.add(cVar);
    }

    public void e(@NonNull f fVar) {
        d(fVar);
    }

    public void f(@NonNull i iVar) {
        i(iVar, this.f3153d.isEmpty());
    }

    public void g(@NonNull i iVar, int i10) {
        h(iVar, i10, this.f3153d.isEmpty());
    }

    public int getSelectedTabPosition() {
        i iVar = this.f3155e;
        if (iVar != null) {
            return iVar.i();
        }
        return -1;
    }

    public int getTabCount() {
        return this.f3153d.size();
    }

    public int getTabGravity() {
        return this.O;
    }

    public int getTabIndicatorGravity() {
        return this.Q;
    }

    public int getTabMaxWidth() {
        return this.J;
    }

    public int getTabMode() {
        return this.R;
    }

    @Nullable
    public ColorStateList getTabTextColors() {
        return this.f3168w;
    }

    public void h(@NonNull i iVar, int i10, boolean z10) {
        if (iVar.f3221h != this) {
            throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
        }
        s(iVar, i10);
        k(iVar);
        if (z10) {
            iVar.p();
        }
        OSTabLayout oSTabLayout = this.f3149b;
        if (oSTabLayout != null) {
            oSTabLayout.h();
        }
    }

    public void i(@NonNull i iVar, boolean z10) {
        h(iVar, this.f3153d.size(), z10);
    }

    public final void j(@NonNull TabItem tabItem) {
        i iVarG = G();
        CharSequence charSequence = tabItem.f3128a;
        if (charSequence != null) {
            iVarG.A(charSequence);
        }
        Drawable drawable = tabItem.f3129b;
        if (drawable != null) {
            iVarG.v(drawable);
        }
        int i10 = tabItem.f3130c;
        if (i10 != 0) {
            iVarG.s(i10);
        }
        if (!TextUtils.isEmpty(tabItem.getContentDescription())) {
            iVarG.r(tabItem.getContentDescription());
        }
        f(iVarG);
    }

    public final void k(@NonNull i iVar) {
        TabView tabView = iVar.f3222i;
        tabView.setSelected(false);
        tabView.setActivated(false);
        this.f3159g.addView(tabView, iVar.i(), u());
    }

    public final void l(View view) {
        if (!(view instanceof TabItem)) {
            throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
        }
        j((TabItem) view);
    }

    public final void m(int i10) {
        if (i10 == -1) {
            return;
        }
        if (getWindowToken() == null || !ViewCompat.isLaidOut(this) || this.f3159g.e()) {
            S(i10, 0.0f, true);
            return;
        }
        int scrollX = getScrollX();
        int iQ = q(i10, 0.0f);
        if (scrollX != iQ) {
            A();
            this.f3150b0.setIntValues(scrollX, iQ);
            this.f3150b0.start();
        }
        this.f3159g.c(i10, this.P);
    }

    public final void n(int i10) {
        if (i10 == 0) {
            Log.w(f3141u0, "MODE_SCROLLABLE + GRAVITY_FILL is not supported, GRAVITY_START will be used instead");
        } else if (i10 == 1) {
            this.f3159g.setGravity(1);
            return;
        } else if (i10 != 2) {
            return;
        }
        this.f3159g.setGravity(GravityCompat.START);
    }

    public final void o() {
        int i10 = this.R;
        ViewCompat.setPaddingRelative(this.f3159g, (i10 == 0 || i10 == 2) ? Math.max(0, this.N - this.f3162i) : 0, 0, 0, 0);
        int i11 = this.R;
        if (i11 == 0) {
            n(this.O);
        } else if (i11 == 1 || i11 == 2) {
            if (this.O == 2) {
                Log.w(f3141u0, "GRAVITY_START is not supported with the current tab mode, GRAVITY_CENTER will be used instead");
            }
            this.f3159g.setGravity(1);
        }
        a0(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this);
        if (this.f3152c0 == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                X((ViewPager) parent, true, true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f3161h0) {
            setupWithViewPager(null);
            this.f3161h0 = false;
        }
    }

    @Override // android.view.View
    public void onDraw(@NonNull Canvas canvas) {
        for (int i10 = 0; i10 < this.f3159g.getChildCount(); i10++) {
            View childAt = this.f3159g.getChildAt(i10);
            if (childAt instanceof TabView) {
                ((TabView) childAt).l(canvas);
            }
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, getTabCount(), false, 1));
    }

    /* JADX WARN: Code duplicated, block: B:36:? A[RETURN, SYNTHETIC] */
    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int iRound = Math.round(ViewUtils.dpToPx(getContext(), getDefaultHeight()));
        int mode = View.MeasureSpec.getMode(i11);
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                i11 = View.MeasureSpec.makeMeasureSpec(getPaddingBottom() + getPaddingTop() + iRound, 1073741824);
            }
        } else if (getChildCount() == 1 && View.MeasureSpec.getSize(i11) >= iRound) {
            getChildAt(0).setMinimumHeight(iRound);
        }
        int size = View.MeasureSpec.getSize(i10);
        if (View.MeasureSpec.getMode(i10) != 0) {
            int iDpToPx = this.L;
            if (iDpToPx <= 0) {
                iDpToPx = (int) (size - ViewUtils.dpToPx(getContext(), 56));
            }
            this.J = iDpToPx;
        }
        super.onMeasure(i10, i11);
        if (getChildCount() == 1) {
            View childAt = getChildAt(0);
            int i12 = this.R;
            if (i12 == 0) {
                if (childAt.getMeasuredWidth() >= getMeasuredWidth()) {
                    return;
                }
            } else if (i12 != 1) {
                if (i12 != 2) {
                    return;
                }
                if (childAt.getMeasuredWidth() >= getMeasuredWidth()) {
                    return;
                }
            } else if (childAt.getMeasuredWidth() == getMeasuredWidth()) {
                return;
            }
            childAt.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), ViewGroup.getChildMeasureSpec(i11, getPaddingBottom() + getPaddingTop(), childAt.getLayoutParams().height));
        }
    }

    public void p(OSTabLayout oSTabLayout) {
        this.f3149b = oSTabLayout;
    }

    public final int q(int i10, float f10) {
        int i11 = this.R;
        if (i11 != 0 && i11 != 2) {
            return 0;
        }
        View childAt = this.f3159g.getChildAt(i10);
        int i12 = i10 + 1;
        View childAt2 = i12 < this.f3159g.getChildCount() ? this.f3159g.getChildAt(i12) : null;
        int width = childAt != null ? childAt.getWidth() : 0;
        int width2 = childAt2 != null ? childAt2.getWidth() : 0;
        int left = ((width / 2) + childAt.getLeft()) - (getWidth() / 2);
        int i13 = (int) ((width + width2) * 0.5f * f10);
        return ViewCompat.getLayoutDirection(this) == 0 ? left + i13 : left - i13;
    }

    public void r() {
        this.W.clear();
    }

    public final void s(@NonNull i iVar, int i10) {
        iVar.w(i10);
        this.f3153d.add(i10, iVar);
        int size = this.f3153d.size();
        while (true) {
            i10++;
            if (i10 >= size) {
                return;
            } else {
                this.f3153d.get(i10).w(i10);
            }
        }
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f10) {
        super.setElevation(f10);
        MaterialShapeUtils.setElevation(this, f10);
    }

    public void setInlineLabel(boolean z10) {
        if (this.S != z10) {
            this.S = z10;
            for (int i10 = 0; i10 < this.f3159g.getChildCount(); i10++) {
                View childAt = this.f3159g.getChildAt(i10);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).A();
                }
            }
            o();
        }
    }

    public void setInlineLabelResource(@BoolRes int i10) {
        setInlineLabel(getResources().getBoolean(i10));
    }

    @Deprecated
    public void setOnTabSelectedListener(@Nullable f fVar) {
        setOnTabSelectedListener((c) fVar);
    }

    public void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        A();
        this.f3150b0.addListener(animatorListener);
    }

    public void setSelectedTabIndicator(@Nullable Drawable drawable) {
        if (this.f3170y != drawable) {
            this.f3170y = drawable;
            ViewCompat.postInvalidateOnAnimation(this.f3159g);
        }
    }

    public void setSelectedTabIndicatorColor(@ColorInt int i10) {
        this.f3159g.i(i10);
    }

    public void setSelectedTabIndicatorGravity(int i10) {
        if (this.Q != i10) {
            this.Q = i10;
            ViewCompat.postInvalidateOnAnimation(this.f3159g);
        }
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i10) {
        this.f3159g.j(i10);
    }

    public void setTabChildEnable(boolean z10) {
        TabView tabView;
        int tabCount = getTabCount();
        for (int i10 = 0; i10 < tabCount; i10++) {
            i iVarB = B(i10);
            if (iVarB != null && (tabView = iVarB.f3222i) != null) {
                tabView.setEnabled(z10);
            }
        }
    }

    public void setTabGravity(int i10) {
        if (this.O != i10) {
            this.O = i10;
            o();
        }
    }

    public void setTabIndicatorFullWidth(boolean z10) {
        this.T = z10;
        ViewCompat.postInvalidateOnAnimation(this.f3159g);
    }

    public void setTabMode(int i10) {
        if (i10 != this.R) {
            this.R = i10;
            o();
        }
    }

    public void setTabTextColors(@Nullable ColorStateList colorStateList) {
        if (this.f3168w != colorStateList) {
            this.f3168w = colorStateList;
            Y();
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(@Nullable PagerAdapter pagerAdapter) {
        R(pagerAdapter, false);
    }

    public void setupWithViewPager(@Nullable ViewPager viewPager) {
        W(viewPager, true);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    @NonNull
    public final LinearLayout.LayoutParams u() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        Z(layoutParams);
        return layoutParams;
    }

    public i v() {
        i iVarAcquire = f3140t0.acquire();
        return iVarAcquire == null ? new i() : iVarAcquire;
    }

    @NonNull
    public final TabView w(@NonNull i iVar) {
        Pools.Pool<TabView> pool = this.f3164j0;
        TabView tabViewAcquire = pool != null ? pool.acquire() : null;
        if (tabViewAcquire == null) {
            tabViewAcquire = new TabView(getContext());
        }
        tabViewAcquire.setTab(iVar);
        tabViewAcquire.setFocusable(true);
        tabViewAcquire.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(iVar.f3217d)) {
            tabViewAcquire.setContentDescription(iVar.f3216c);
        } else {
            tabViewAcquire.setContentDescription(iVar.f3217d);
        }
        return tabViewAcquire;
    }

    public final void x(@NonNull i iVar) {
        for (int size = this.W.size() - 1; size >= 0; size--) {
            this.W.get(size).a(iVar);
        }
    }

    public final void y(@NonNull i iVar) {
        for (int size = this.W.size() - 1; size >= 0; size--) {
            this.W.get(size).b(iVar);
        }
    }

    public final void z(@NonNull i iVar) {
        for (int size = this.W.size() - 1; size >= 0; size--) {
            this.W.get(size).c(iVar);
        }
    }

    public TabLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i10) {
        l(view);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    @Deprecated
    public void setOnTabSelectedListener(@Nullable c cVar) {
        c cVar2 = this.V;
        if (cVar2 != null) {
            K(cVar2);
        }
        this.V = cVar;
        if (cVar != null) {
            d(cVar);
        }
    }

    public TabLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f3147a = f3141u0;
        this.f3153d = new ArrayList<>();
        this.f3157f = new RectF();
        this.J = Integer.MAX_VALUE;
        this.W = new ArrayList<>();
        this.f3164j0 = new Pools.SimplePool(12);
        Context context2 = getContext();
        setHorizontalScrollBarEnabled(false);
        h hVar = new h(context2);
        this.f3159g = hVar;
        super.addView(hVar, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R.styleable.TabLayout, i10, R.style.OSTablayout);
        hVar.j(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabIndicatorHeight, -1));
        hVar.i(typedArrayObtainStyledAttributes.getColor(R.styleable.TabLayout_tabIndicatorColor, 0));
        setSelectedTabIndicator(MaterialResources.getDrawable(context2, typedArrayObtainStyledAttributes, R.styleable.TabLayout_tabIndicator));
        setSelectedTabIndicatorGravity(typedArrayObtainStyledAttributes.getInt(R.styleable.TabLayout_tabIndicatorGravity, 0));
        setTabIndicatorFullWidth(typedArrayObtainStyledAttributes.getBoolean(R.styleable.TabLayout_tabIndicatorFullWidth, true));
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabPadding, 0);
        this.f3167v = dimensionPixelSize;
        this.f3165n = dimensionPixelSize;
        this.f3166p = dimensionPixelSize;
        this.f3162i = dimensionPixelSize;
        this.f3162i = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingStart, dimensionPixelSize);
        this.f3165n = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingTop, this.f3165n);
        this.f3166p = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingEnd, this.f3166p);
        this.f3167v = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingBottom, this.f3167v);
        this.f3169x = MaterialResources.getColorStateList(context2, typedArrayObtainStyledAttributes, R.styleable.TabLayout_tabRippleColor);
        this.P = 300;
        this.K = -1;
        this.L = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_tabMaxWidth, -1);
        this.I = typedArrayObtainStyledAttributes.getResourceId(R.styleable.TabLayout_tabBackground, 0);
        this.N = 0;
        this.R = typedArrayObtainStyledAttributes.getInt(R.styleable.TabLayout_OsTabMode, 1);
        this.O = typedArrayObtainStyledAttributes.getInt(R.styleable.TabLayout_OsTabGravity, 0);
        this.S = typedArrayObtainStyledAttributes.getBoolean(R.styleable.TabLayout_tabInlineLabel, true);
        this.U = typedArrayObtainStyledAttributes.getBoolean(R.styleable.TabLayout_tabUnboundedRipple, false);
        this.M = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.TabLayout_scrollableTabMinWidth, 0);
        typedArrayObtainStyledAttributes.recycle();
        o();
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        l(view);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        l(view);
    }

    public void setSelectedTabIndicator(@DrawableRes int i10) {
        if (i10 != 0) {
            setSelectedTabIndicator(getResources().getDrawable(i10));
        } else {
            setSelectedTabIndicator((Drawable) null);
        }
    }
}
