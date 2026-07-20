package com.transsion.widgetslib.widget.tablayout;

import android.R;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Pools;
import androidx.core.view.GravityCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.BadgeUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeUtils;
import com.transsion.widgetslib.R$attr;
import com.transsion.widgetslib.R$color;
import com.transsion.widgetslib.R$dimen;
import com.transsion.widgetslib.R$id;
import com.transsion.widgetslib.R$layout;
import com.transsion.widgetslib.R$style;
import com.transsion.widgetslib.R$styleable;
import ee.k;
import ge.e;
import ge.f;
import ge.g;
import ge.j;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import tj.w;
import z1OoOdo.z1OoOdo.z1OoOdo.z1OoOdo.z1OoOif;

/* JADX INFO: loaded from: classes2.dex */
@ViewPager.DecorView
public class TabLayout extends HorizontalScrollView {
    public static final Pools.SynchronizedPool T = new Pools.SynchronizedPool(16);
    public boolean A;
    public boolean B;
    public final boolean C;
    public e D;
    public final ArrayList E;
    public j F;
    public ValueAnimator G;
    public ViewPager H;
    public PagerAdapter I;
    public g J;
    public TabLayoutOnPageChangeListener K;
    public ge.d L;
    public boolean M;
    public boolean N;
    public final int O;
    public final AttributeSet P;
    public boolean Q;
    public final Pools.SimplePool R;
    public z1OoOif S;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3682a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public OSTabLayout f3683b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f3684c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f3685d;
    public final RectF e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a f3686h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f3687i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f3688j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f3689k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f3690l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ColorStateList f3691m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ColorStateList f3692n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Drawable f3693o;
    public float p;
    public float q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f3694r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f3695s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f3696t;
    public final int u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f3697v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f3698w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f3699x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f3700y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f3701z;

    public static class TabLayoutOnPageChangeListener implements ViewPager.OnPageChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference f3702a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f3703b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f3704c;

        public TabLayoutOnPageChangeListener(TabLayout tabLayout) {
            this.f3702a = new WeakReference(tabLayout);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrollStateChanged(int i8) {
            this.f3703b = this.f3704c;
            this.f3704c = i8;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrolled(int i8, float f, int i9) {
            TabLayout tabLayout = (TabLayout) this.f3702a.get();
            if (tabLayout != null) {
                int i10 = this.f3704c;
                tabLayout.p(i8, f, i10 != 2 || this.f3703b == 1, (i10 == 2 && this.f3703b == 0) ? false : true);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageSelected(int i8) {
            TabLayout tabLayout = (TabLayout) this.f3702a.get();
            if (tabLayout == null || tabLayout.getSelectedTabPosition() == i8 || i8 >= tabLayout.getTabCount()) {
                return;
            }
            int i9 = this.f3704c;
            tabLayout.n(tabLayout.h(i8), i9 == 0 || (i9 == 2 && this.f3703b == 0));
        }
    }

    public final class TabView extends LinearLayout {
        public static final /* synthetic */ int p = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public b f3705a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public TextView f3706b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ImageView f3707c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public View f3708d;
        public BadgeDrawable e;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public View f3709h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public TextView f3710i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public ImageView f3711j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final Drawable f3712k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f3713l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final Paint f3714m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final int f3715n;

        public TabView(Context context) {
            GradientDrawable gradientDrawable;
            super(context);
            this.f3713l = 1;
            int color = getContext().getColor(R$color.os_warning_primary_hios);
            Color.parseColor("#FFFFFF");
            if (TabLayout.this.f3694r != 0) {
                Drawable drawable = getResources().getDrawable(TabLayout.this.f3694r);
                this.f3712k = drawable;
                if (drawable != null && drawable.isStateful()) {
                    this.f3712k.setState(getDrawableState());
                }
            } else {
                this.f3712k = null;
            }
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setColor(0);
            ColorStateList colorStateList = TabLayout.this.f3692n;
            Drawable rippleDrawable = gradientDrawable2;
            if (colorStateList != null) {
                GradientDrawable gradientDrawable3 = new GradientDrawable();
                gradientDrawable3.setCornerRadius(126.0f);
                gradientDrawable3.setColor(-1);
                boolean z2 = TabLayout.this.C;
                if (z2) {
                    gradientDrawable = gradientDrawable2;
                    gradientDrawable = null;
                }
                rippleDrawable = new RippleDrawable(colorStateList, gradientDrawable, z2 ? null : gradientDrawable3);
            }
            ViewCompat.setBackground(this, rippleDrawable);
            TabLayout.this.invalidate();
            ViewCompat.setPaddingRelative(this, TabLayout.this.f3687i, TabLayout.this.f3688j, TabLayout.this.f3689k, TabLayout.this.f3690l);
            setGravity(17);
            setOrientation(!TabLayout.this.A ? 1 : 0);
            setClickable(true);
            ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), PointerIconCompat.TYPE_HAND));
            setWillNotDraw(false);
            Context context2 = getContext();
            String[] strArr = pd.j.f8764a;
            hd.a.a(context2, 6);
            Paint paint = new Paint();
            this.f3714m = paint;
            paint.setAntiAlias(true);
            this.f3714m.setDither(true);
            this.f3714m.setColor(color);
            if (pd.j.s()) {
                this.f3714m.setTextSize(context.getResources().getDimensionPixelSize(R$dimen.os_ultra_small_tab_badgeview_num_size));
                context.getResources().getDimensionPixelSize(R$dimen.os_ultra_small_tab_badgeview_height);
                context.getResources().getDimensionPixelSize(R$dimen.os_ultra_small_tab_badgeview_padding);
                this.f3715n = context.getResources().getDimensionPixelSize(R$dimen.os_ultra_small_tab_badgeview_text_size);
                context.getResources().getDimensionPixelSize(R$dimen.os_ultra_small_tab_badgeview_plus_text_size);
            } else {
                this.f3714m.setTextSize(context.getResources().getDimensionPixelSize(R$dimen.os_tab_badgeview_num_size));
                context.getResources().getDimensionPixelSize(R$dimen.os_tab_badgeview_height);
                context.getResources().getDimensionPixelSize(R$dimen.os_tab_badgeview_padding);
                this.f3715n = context.getResources().getDimensionPixelSize(R$dimen.os_tab_badgeview_text_size);
                context.getResources().getDimensionPixelSize(R$dimen.os_tab_badgeview_plus_text_size);
            }
            this.f3714m.setTextSize(this.f3715n);
            new RectF();
            setOnTouchListener(new c());
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public BadgeDrawable getBadge() {
            return this.e;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getContentWidth() {
            View[] viewArr = {this.f3706b, this.f3707c, this.f3709h};
            int iMax = 0;
            int iMin = 0;
            boolean z2 = false;
            for (int i8 = 0; i8 < 3; i8++) {
                View view = viewArr[i8];
                if (view != null && view.getVisibility() == 0) {
                    iMin = z2 ? Math.min(iMin, view.getLeft()) : view.getLeft();
                    iMax = z2 ? Math.max(iMax, view.getRight()) : view.getRight();
                    z2 = true;
                }
            }
            return iMax - iMin;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @NonNull
        public BadgeDrawable getOrCreateBadge() {
            if (this.e == null) {
                this.e = BadgeDrawable.create(getContext());
            }
            f();
            BadgeDrawable badgeDrawable = this.e;
            if (badgeDrawable != null) {
                return badgeDrawable;
            }
            throw new IllegalStateException("Unable to create badge");
        }

        public final FrameLayout d(View view) {
            if ((view == this.f3707c || view == this.f3706b) && BadgeUtils.USE_COMPAT_PARENT) {
                return (FrameLayout) view.getParent();
            }
            return null;
        }

        @Override // android.view.ViewGroup, android.view.View
        public final void drawableStateChanged() {
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            Drawable drawable = this.f3712k;
            if ((drawable == null || !drawable.isStateful()) ? false : this.f3712k.setState(drawableState)) {
                invalidate();
                TabLayout.this.invalidate();
            }
        }

        public final void e() {
            if (this.e == null || this.f3708d == null) {
                return;
            }
            setClipChildren(true);
            setClipToPadding(true);
            BadgeDrawable badgeDrawable = this.e;
            View view = this.f3708d;
            BadgeUtils.detachBadgeDrawable(badgeDrawable, view, d(view));
            this.f3708d = null;
        }

        public final void f() {
            b bVar;
            b bVar2;
            if (this.e != null) {
                if (this.f3709h != null) {
                    e();
                    return;
                }
                if (this.f3707c != null && (bVar2 = this.f3705a) != null && bVar2.getIcon() != null) {
                    View view = this.f3708d;
                    ImageView imageView = this.f3707c;
                    if (view == imageView) {
                        g(imageView);
                        return;
                    }
                    e();
                    ImageView imageView2 = this.f3707c;
                    if (this.e == null || imageView2 == null) {
                        return;
                    }
                    setClipChildren(false);
                    setClipToPadding(false);
                    BadgeUtils.attachBadgeDrawable(this.e, imageView2, d(imageView2));
                    this.f3708d = imageView2;
                    return;
                }
                if (this.f3706b == null || (bVar = this.f3705a) == null || bVar.getTabLabelVisibility() != 1) {
                    e();
                    return;
                }
                View view2 = this.f3708d;
                TextView textView = this.f3706b;
                if (view2 == textView) {
                    g(textView);
                    return;
                }
                e();
                TextView textView2 = this.f3706b;
                if (this.e == null || textView2 == null) {
                    return;
                }
                setClipChildren(false);
                setClipToPadding(false);
                BadgeUtils.attachBadgeDrawable(this.e, textView2, d(textView2));
                this.f3708d = textView2;
            }
        }

        public final void g(View view) {
            BadgeDrawable badgeDrawable = this.e;
            if (badgeDrawable == null || view != this.f3708d) {
                return;
            }
            BadgeUtils.setBadgeDrawableBounds(badgeDrawable, view, d(view));
        }

        @Nullable
        public b getTab() {
            return this.f3705a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v0, types: [android.widget.LinearLayout, com.transsion.widgetslib.widget.tablayout.TabLayout$TabView] */
        /* JADX WARN: Type inference failed for: r2v13 */
        /* JADX WARN: Type inference failed for: r2v14, types: [android.view.ViewGroup] */
        /* JADX WARN: Type inference failed for: r2v20 */
        /* JADX WARN: Type inference failed for: r2v21, types: [android.view.ViewGroup] */
        /* JADX WARN: Type inference failed for: r2v26 */
        /* JADX WARN: Type inference failed for: r2v27 */
        /* JADX WARN: Type inference failed for: r4v2, types: [android.view.LayoutInflater] */
        /* JADX WARN: Type inference failed for: r6v6, types: [android.view.LayoutInflater] */
        public final void h() {
            ?? r7;
            ?? r10;
            b bVar = this.f3705a;
            View customView = bVar != null ? bVar.getCustomView() : null;
            if (customView != null) {
                ViewParent parent = customView.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(customView);
                    }
                    addView(customView);
                }
                this.f3709h = customView;
                TextView textView = this.f3706b;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f3707c;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f3707c.setImageDrawable(null);
                }
                TextView textView2 = (TextView) customView.findViewById(R.id.text1);
                this.f3710i = textView2;
                if (textView2 != null) {
                    this.f3713l = TextViewCompat.getMaxLines(textView2);
                }
                this.f3711j = (ImageView) customView.findViewById(R.id.icon);
            } else {
                View view = this.f3709h;
                if (view != null) {
                    removeView(view);
                    this.f3709h = null;
                }
                this.f3710i = null;
                this.f3711j = null;
            }
            boolean z2 = false;
            if (this.f3709h == null) {
                ImageView imageView2 = this.f3707c;
                TabLayout tabLayout = TabLayout.this;
                if (imageView2 == null) {
                    if (BadgeUtils.USE_COMPAT_PARENT) {
                        FrameLayout frameLayout = new FrameLayout(getContext());
                        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
                        addView(frameLayout, 0);
                        r10 = frameLayout;
                    } else {
                        r10 = this;
                    }
                    ImageView imageView3 = (ImageView) LayoutInflater.from(getContext()).inflate(R$layout.design_layout_tab_icon, r10, false);
                    this.f3707c = imageView3;
                    r10.addView(imageView3, 0);
                    Pools.SynchronizedPool synchronizedPool = TabLayout.T;
                    tabLayout.getClass();
                    r10.setBackground(null);
                }
                if (bVar != null && bVar.getIcon() != null) {
                    DrawableCompat.wrap(bVar.getIcon()).mutate();
                }
                if (this.f3706b == null) {
                    if (BadgeUtils.USE_COMPAT_PARENT) {
                        FrameLayout frameLayout2 = new FrameLayout(getContext());
                        frameLayout2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
                        addView(frameLayout2);
                        r7 = frameLayout2;
                    } else {
                        r7 = this;
                    }
                    TextView textView3 = (TextView) LayoutInflater.from(getContext()).inflate(R$layout.os_design_layout_tab_text, r7, false);
                    this.f3706b = textView3;
                    textView3.setId(R$id.os_id_tab_layout_text_view_id);
                    if (pd.j.z(getContext())) {
                        TextView textView4 = this.f3706b;
                        textView4.setPadding(textView4.getPaddingLeft(), getContext().getResources().getDimensionPixelSize(R$dimen.os_tab_text_top_offset), this.f3706b.getPaddingRight(), this.f3706b.getPaddingBottom());
                    }
                    r7.addView(this.f3706b);
                    Pools.SynchronizedPool synchronizedPool2 = TabLayout.T;
                    tabLayout.getClass();
                    r7.setBackground(null);
                }
                ColorStateList colorStateList = tabLayout.f3691m;
                if (colorStateList != null) {
                    this.f3706b.setTextColor(colorStateList);
                }
                i(this.f3706b, this.f3707c);
                f();
                ImageView imageView4 = this.f3707c;
                if (imageView4 != null) {
                    imageView4.addOnLayoutChangeListener(new d(this, imageView4));
                }
                TextView textView5 = this.f3706b;
                if (textView5 != null) {
                    textView5.addOnLayoutChangeListener(new d(this, textView5));
                }
            } else {
                TextView textView6 = this.f3710i;
                if (textView6 != null || this.f3711j != null) {
                    i(textView6, this.f3711j);
                }
            }
            if (bVar != null && !TextUtils.isEmpty(bVar.f3731c)) {
                setContentDescription(bVar.f3731c);
            }
            if (bVar != null) {
                TabLayout tabLayout2 = bVar.f;
                if (tabLayout2 == null) {
                    throw new IllegalArgumentException("Tab not attached to a TabLayout");
                }
                if (tabLayout2.getSelectedTabPosition() == bVar.f3732d) {
                    z2 = true;
                }
            }
            setSelected(z2);
        }

        public final void i(TextView textView, ImageView imageView) {
            b bVar = this.f3705a;
            Drawable drawableMutate = (bVar == null || bVar.getIcon() == null) ? null : DrawableCompat.wrap(this.f3705a.getIcon()).mutate();
            b bVar2 = this.f3705a;
            CharSequence text = bVar2 != null ? bVar2.getText() : null;
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
            boolean zIsEmpty = TextUtils.isEmpty(text);
            if (textView != null) {
                if (imageView != null && imageView.getVisibility() == 0) {
                    textView.setVisibility(8);
                } else if (zIsEmpty) {
                    textView.setVisibility(8);
                    textView.setText((CharSequence) null);
                } else {
                    textView.setText(text);
                    this.f3705a.getClass();
                    textView.setVisibility(0);
                    setVisibility(0);
                }
            }
            if (imageView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                int iDpToPx = (zIsEmpty || imageView.getVisibility() != 0) ? 0 : (int) ViewUtils.dpToPx(getContext(), 8);
                if (TabLayout.this.A) {
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
            b bVar3 = this.f3705a;
            CharSequence charSequence = bVar3 != null ? bVar3.f3731c : null;
            if (zIsEmpty) {
                setTooltipText(charSequence);
            } else {
                setTooltipText(null);
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public final void onDraw(Canvas canvas) {
            super.onDraw(canvas);
        }

        @Override // android.view.View
        public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            BadgeDrawable badgeDrawable = this.e;
            if (badgeDrawable != null && badgeDrawable.isVisible()) {
                accessibilityNodeInfo.setContentDescription(((Object) getContentDescription()) + ", " + ((Object) this.e.getContentDescription()));
            }
            AccessibilityNodeInfoCompat accessibilityNodeInfoCompatWrap = AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo);
            accessibilityNodeInfoCompatWrap.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, this.f3705a.getPosition(), 1, false, isSelected()));
            if (isSelected()) {
                accessibilityNodeInfoCompatWrap.setClickable(false);
                accessibilityNodeInfoCompatWrap.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
            }
            accessibilityNodeInfoCompatWrap.setRoleDescription("Tab");
        }

        @Override // android.widget.LinearLayout, android.view.View
        public final void onMeasure(int i8, int i9) {
            int size = View.MeasureSpec.getSize(i8);
            int mode = View.MeasureSpec.getMode(i8);
            TabLayout tabLayout = TabLayout.this;
            int tabMaxWidth = tabLayout.getTabMaxWidth();
            if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                i8 = View.MeasureSpec.makeMeasureSpec(tabLayout.f3695s, Integer.MIN_VALUE);
            }
            super.onMeasure(i8, i9);
            if (this.f3706b != null) {
                float f = tabLayout.p;
                int i10 = this.f3713l;
                ImageView imageView = this.f3707c;
                if (imageView == null || imageView.getVisibility() != 0) {
                    TextView textView = this.f3706b;
                    if (textView != null && textView.getLineCount() > 1) {
                        f = tabLayout.q;
                    }
                } else {
                    i10 = 1;
                }
                float textSize = this.f3706b.getTextSize();
                this.f3706b.getLineCount();
                int maxLines = TextViewCompat.getMaxLines(this.f3706b);
                if (f != textSize || (maxLines >= 0 && i10 != maxLines)) {
                    this.f3706b.setTextSize(0, f);
                    this.f3706b.setMaxLines(i10);
                    super.onMeasure(i8, i9);
                }
            }
        }

        @Override // android.view.View
        public final boolean performClick() {
            boolean zPerformClick = super.performClick();
            if (this.f3705a == null) {
                return zPerformClick;
            }
            if (!zPerformClick) {
                playSoundEffect(0);
            }
            b bVar = this.f3705a;
            TabLayout tabLayout = bVar.f;
            if (tabLayout == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            tabLayout.n(bVar, true);
            return true;
        }

        @Override // android.view.View
        public void setSelected(boolean z2) {
            isSelected();
            super.setSelected(z2);
            TextView textView = this.f3706b;
            if (textView != null) {
                textView.setSelected(z2);
                TabLayout tabLayout = TabLayout.this;
                if (z2) {
                    if (tabLayout.N) {
                        this.f3706b.setTextAppearance(R$style.os_semibold_font);
                    } else {
                        this.f3706b.setTextAppearance(R$style.os_semibold_font);
                    }
                } else if (tabLayout.N) {
                    this.f3706b.setTextAppearance(R$style.os_regular_fontweight);
                } else {
                    this.f3706b.setTextAppearance(R$style.os_regular_fontweight);
                }
            }
            ImageView imageView = this.f3707c;
            if (imageView != null) {
                imageView.setSelected(z2);
            }
            View view = this.f3709h;
            if (view != null) {
                view.setSelected(z2);
            }
        }

        public void setTab(@Nullable b bVar) {
            if (bVar != this.f3705a) {
                this.f3705a = bVar;
                h();
            }
        }
    }

    public TabLayout(@NonNull Context context) {
        this(context, null);
    }

    @Dimension(unit = 0)
    private int getDefaultHeight() {
        ArrayList arrayList = this.f3684c;
        int size = arrayList.size();
        for (int i8 = 0; i8 < size; i8++) {
            b bVar = (b) arrayList.get(i8);
            if (bVar != null && bVar.getIcon() != null && !TextUtils.isEmpty(bVar.getText())) {
                if (this.A) {
                    break;
                }
                return Math.round(ViewUtils.dpToPx(getContext(), 72));
            }
        }
        return this.f3682a;
    }

    private int getTabMinWidth() {
        int i8 = this.f3696t;
        if (i8 != -1) {
            return i8;
        }
        int i9 = this.f3701z;
        if (i9 == 0 || i9 == 2) {
            return this.f3697v;
        }
        return 0;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.f3686h.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void setSelectedTabView(int i8) {
        a aVar = this.f3686h;
        int childCount = aVar.getChildCount();
        if (i8 < childCount) {
            int i9 = 0;
            while (i9 < childCount) {
                View childAt = aVar.getChildAt(i9);
                boolean z2 = true;
                childAt.setSelected(i9 == i8);
                if (i9 != i8) {
                    z2 = false;
                }
                childAt.setActivated(z2);
                i9++;
            }
        }
    }

    public final void a(b bVar, boolean z2) {
        ArrayList arrayList = this.f3684c;
        int size = arrayList.size();
        if (bVar.f != this) {
            throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
        }
        bVar.f3732d = size;
        arrayList.add(size, bVar);
        int size2 = arrayList.size();
        for (int i8 = size + 1; i8 < size2; i8++) {
            ((b) arrayList.get(i8)).f3732d = i8;
        }
        TabView tabView = bVar.f3733g;
        tabView.setSelected(false);
        tabView.setActivated(false);
        int position = bVar.getPosition();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        if (this.f3701z == 1 && this.f3698w == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
        } else {
            layoutParams.width = -2;
            layoutParams.weight = 0.0f;
        }
        this.f3686h.addView(tabView, position, layoutParams);
        if (z2) {
            TabLayout tabLayout = bVar.f;
            if (tabLayout == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            tabLayout.n(bVar, true);
        }
        OSTabLayout oSTabLayout = this.f3683b;
        if (oSTabLayout != null) {
            oSTabLayout.b();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final void addView(View view) {
        b(view);
    }

    public final void b(View view) {
        if (!(view instanceof TabItem)) {
            throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
        }
        TabItem tabItem = (TabItem) view;
        b bVarL = l();
        CharSequence charSequence = tabItem.f3679a;
        if (charSequence != null) {
            if (TextUtils.isEmpty(bVarL.f3731c) && !TextUtils.isEmpty(charSequence)) {
                bVarL.f3733g.setContentDescription(charSequence);
            }
            bVarL.f3730b = charSequence;
            TabView tabView = bVarL.f3733g;
            if (tabView != null) {
                tabView.h();
            }
        }
        Drawable drawable = tabItem.f3680b;
        if (drawable != null) {
            bVarL.f3729a = drawable;
            TabLayout tabLayout = bVarL.f;
            if (tabLayout.f3698w == 1 || tabLayout.f3701z == 2) {
                tabLayout.s(true);
            }
            TabView tabView2 = bVarL.f3733g;
            if (tabView2 != null) {
                tabView2.h();
            }
            if (BadgeUtils.USE_COMPAT_PARENT) {
                TabView tabView3 = bVarL.f3733g;
                int i8 = TabView.p;
                BadgeDrawable badgeDrawable = tabView3.e;
                if (badgeDrawable != null && badgeDrawable.isVisible()) {
                    bVarL.f3733g.invalidate();
                }
            }
        }
        int i9 = tabItem.f3681c;
        if (i9 != 0) {
            bVarL.e = LayoutInflater.from(bVarL.f3733g.getContext()).inflate(i9, (ViewGroup) bVarL.f3733g, false);
            TabView tabView4 = bVarL.f3733g;
            if (tabView4 != null) {
                tabView4.h();
            }
        }
        if (!TextUtils.isEmpty(tabItem.getContentDescription())) {
            bVarL.f3731c = tabItem.getContentDescription();
            TabView tabView5 = bVarL.f3733g;
            if (tabView5 != null) {
                tabView5.h();
            }
        }
        a(bVarL, this.f3684c.isEmpty());
    }

    public final void c(int i8) {
        if (i8 == -1) {
            return;
        }
        if (getWindowToken() != null && ViewCompat.isLaidOut(this)) {
            a aVar = this.f3686h;
            int childCount = aVar.getChildCount();
            for (int i9 = 0; i9 < childCount; i9++) {
                if (aVar.getChildAt(i9).getWidth() > 0) {
                }
            }
            int scrollX = getScrollX();
            int iE = e(i8, 0.0f);
            if (scrollX != iE) {
                g();
                this.G.setIntValues(scrollX, iE);
                this.G.start();
            }
            ValueAnimator valueAnimator = aVar.f3725l;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                aVar.f3725l.cancel();
            }
            aVar.c(true, i8, this.f3699x);
            return;
        }
        p(i8, 0.0f, true, true);
    }

    public final void d() {
        int i8 = this.f3701z;
        int iMax = (i8 == 0 || i8 == 2) ? Math.max(0, 0 - this.f3687i) : 0;
        a aVar = this.f3686h;
        ViewCompat.setPaddingRelative(aVar, iMax, 0, 0, 0);
        int i9 = this.f3701z;
        if (i9 == 0) {
            int i10 = this.f3698w;
            if (i10 == 0) {
                Log.w("TabLayout", "MODE_SCROLLABLE + GRAVITY_FILL is not supported, GRAVITY_START will be used instead");
            } else if (i10 == 1) {
                aVar.setGravity(1);
            } else if (i10 == 2) {
            }
            aVar.setGravity(GravityCompat.START);
        } else if (i9 == 1 || i9 == 2) {
            if (this.f3698w == 2) {
                Log.w("TabLayout", "GRAVITY_START is not supported with the current tab mode, GRAVITY_CENTER will be used instead");
            }
            aVar.setGravity(1);
        }
        s(true);
    }

    public final int e(int i8, float f) {
        int i9 = this.f3701z;
        if (i9 != 0 && i9 != 2) {
            return 0;
        }
        a aVar = this.f3686h;
        View childAt = aVar.getChildAt(i8);
        int i10 = i8 + 1;
        View childAt2 = i10 < aVar.getChildCount() ? aVar.getChildAt(i10) : null;
        int width = childAt != null ? childAt.getWidth() : 0;
        int width2 = childAt2 != null ? childAt2.getWidth() : 0;
        int left = ((width / 2) + childAt.getLeft()) - (getWidth() / 2);
        int i11 = (int) ((width + width2) * 0.5f * f);
        return ViewCompat.getLayoutDirection(this) == 0 ? left + i11 : left - i11;
    }

    public final void f() {
        z1OoOif z1oooif = this.S;
        if (z1oooif != null) {
            z1oooif.a();
            return;
        }
        z1OoOif z1oooif2 = null;
        if (b8.g.f1225a) {
            Class cls = b8.g.f1226b;
            if (b8.g.a(cls, this)) {
                z1oooif2 = new z1OoOif(new w(this, 18));
                z1oooif2.f11257z = new qf.c(cls, this);
            }
        }
        this.S = z1oooif2;
    }

    public final void g() {
        if (this.G == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.G = valueAnimator;
            valueAnimator.setInterpolator(new ud.a());
            this.G.setDuration(this.f3699x);
            this.G.addUpdateListener(new k(this, 2));
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    public int getSelectedTabPosition() {
        b bVar = this.f3685d;
        if (bVar != null) {
            return bVar.getPosition();
        }
        return -1;
    }

    public int getTabCount() {
        return this.f3684c.size();
    }

    public int getTabGravity() {
        return this.f3698w;
    }

    public int getTabIndicatorGravity() {
        return this.f3700y;
    }

    public int getTabMaxWidth() {
        return this.f3695s;
    }

    public int getTabMode() {
        return this.f3701z;
    }

    public int getTabPaddingBottom() {
        return this.f3690l;
    }

    public int getTabPaddingEnd() {
        return this.f3689k;
    }

    public int getTabPaddingStart() {
        return this.f3687i;
    }

    public int getTabPaddingTop() {
        return this.f3688j;
    }

    @Nullable
    public ColorStateList getTabTextColors() {
        return this.f3691m;
    }

    public float getTabTextSize() {
        return this.p;
    }

    public final b h(int i8) {
        if (i8 < 0 || i8 >= getTabCount()) {
            return null;
        }
        return (b) this.f3684c.get(i8);
    }

    public final void i(TypedArray typedArray) {
        if (typedArray == null || this.Q) {
            return;
        }
        int dimensionPixelSize = typedArray.getDimensionPixelSize(R$styleable.TabLayout_tabPadding, 0);
        this.f3690l = dimensionPixelSize;
        this.f3688j = dimensionPixelSize;
        this.f3689k = dimensionPixelSize;
        this.f3687i = dimensionPixelSize;
        this.f3687i = typedArray.getDimensionPixelSize(R$styleable.TabLayout_tabPaddingStart, dimensionPixelSize);
        this.f3688j = typedArray.getDimensionPixelSize(R$styleable.TabLayout_tabPaddingTop, this.f3688j);
        this.f3689k = typedArray.getDimensionPixelSize(R$styleable.TabLayout_tabPaddingEnd, this.f3689k);
        this.f3690l = typedArray.getDimensionPixelSize(R$styleable.TabLayout_tabPaddingBottom, this.f3690l);
        this.Q = typedArray.getBoolean(R$styleable.TabLayout_isFixPadding, false);
    }

    public final void j() {
        if (getTabMode() == 0) {
            int dimensionPixelOffset = getContext().getResources().getDimensionPixelOffset(R$dimen.os_tab_item_scroll_padding_start);
            this.f3689k = dimensionPixelOffset;
            this.f3687i = dimensionPixelOffset;
        }
    }

    public final void k(boolean z2) {
        this.N = z2;
        Resources.Theme theme = getContext().getTheme();
        if (this.N) {
            this.p = getResources().getDimensionPixelOffset(R$dimen.os_tab_first_level_title_size);
            this.q = getResources().getDimensionPixelSize(R$dimen.os_tab_first_level_title_size);
            this.f3691m = getResources().getColorStateList(R$color.os_text_tertiary_hios, theme);
        } else {
            this.p = getResources().getDimensionPixelOffset(R$dimen.os_tab_second_level_title_size);
            this.q = getResources().getDimensionPixelSize(R$dimen.os_tab_second_level_title_size);
            this.f3691m = getResources().getColorStateList(R$color.os_text_tertiary_hios, theme);
        }
        this.f3691m = new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.PRESSED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{pd.j.e(getContext(), R$attr.os_text_primary, R$color.os_text_primary_hios), getContext().getColor(R$color.os_text_secondary_press_color), this.f3691m.getDefaultColor()});
        Resources resources = getContext().getResources();
        this.f3682a = this.N ? resources.getDimensionPixelOffset(R$dimen.os_tab_default_height_first_level) : resources.getDimensionPixelOffset(R$dimen.os_tab_default_height_second_level);
        int dimensionPixelOffset = resources.getDimensionPixelOffset(this.N ? R$dimen.os_tab_default_selected_bottom_offset_fl : R$dimen.os_tab_default_selected_bottom_offset_sl);
        a aVar = this.f3686h;
        if (aVar.f3723j != dimensionPixelOffset) {
            aVar.f3723j = dimensionPixelOffset;
            ViewCompat.postInvalidateOnAnimation(aVar);
        }
        requestLayout();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final b l() {
        b bVar = (b) T.acquire();
        if (bVar == null) {
            bVar = new b();
            bVar.f3732d = -1;
        }
        bVar.f = this;
        Pools.SimplePool simplePool = this.R;
        TabView tabView = simplePool != null ? (TabView) simplePool.acquire() : null;
        if (tabView == null) {
            tabView = new TabView(getContext());
        }
        tabView.setTab(bVar);
        tabView.setFocusable(true);
        tabView.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(bVar.f3731c)) {
            tabView.setContentDescription(bVar.f3730b);
        } else {
            tabView.setContentDescription(bVar.f3731c);
        }
        bVar.f3733g = tabView;
        return bVar;
    }

    public final void m() {
        int currentItem;
        a aVar = this.f3686h;
        for (int childCount = aVar.getChildCount() - 1; childCount >= 0; childCount--) {
            TabView tabView = (TabView) aVar.getChildAt(childCount);
            aVar.removeViewAt(childCount);
            if (tabView != null) {
                tabView.setTab(null);
                tabView.setSelected(false);
                this.R.release(tabView);
            }
            requestLayout();
        }
        Iterator it = this.f3684c.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            it.remove();
            bVar.f = null;
            bVar.f3733g = null;
            bVar.f3729a = null;
            bVar.f3730b = null;
            bVar.f3731c = null;
            bVar.f3732d = -1;
            bVar.e = null;
            T.release(bVar);
        }
        this.f3685d = null;
        PagerAdapter pagerAdapter = this.I;
        if (pagerAdapter != null) {
            int count = pagerAdapter.getCount();
            for (int i8 = 0; i8 < count; i8++) {
                b bVarL = l();
                CharSequence pageTitle = this.I.getPageTitle(i8);
                if (TextUtils.isEmpty(bVarL.f3731c) && !TextUtils.isEmpty(pageTitle)) {
                    bVarL.f3733g.setContentDescription(pageTitle);
                }
                bVarL.f3730b = pageTitle;
                TabView tabView2 = bVarL.f3733g;
                if (tabView2 != null) {
                    tabView2.h();
                }
                a(bVarL, false);
            }
            ViewPager viewPager = this.H;
            if (viewPager == null || count <= 0 || (currentItem = viewPager.getCurrentItem()) == getSelectedTabPosition() || currentItem >= getTabCount()) {
                return;
            }
            n(h(currentItem), true);
        }
    }

    public final void n(b bVar, boolean z2) {
        b bVar2 = this.f3685d;
        ArrayList arrayList = this.E;
        if (bVar2 == bVar) {
            if (bVar2 != null) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    ((e) arrayList.get(size)).getClass();
                }
                c(bVar.getPosition());
                return;
            }
            return;
        }
        int position = bVar != null ? bVar.getPosition() : -1;
        if (z2) {
            if ((bVar2 == null || bVar2.getPosition() == -1) && position != -1) {
                p(position, 0.0f, true, true);
            } else {
                c(position);
            }
            if (position != -1) {
                setSelectedTabView(position);
            }
        }
        this.f3685d = bVar;
        if (bVar2 != null) {
            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                ((e) arrayList.get(size2)).getClass();
            }
        }
        if (bVar != null) {
            for (int size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                ((j) ((e) arrayList.get(size3))).f5176a.setCurrentItem(bVar.getPosition());
            }
        }
    }

    public final void o(PagerAdapter pagerAdapter, boolean z2) {
        g gVar;
        PagerAdapter pagerAdapter2 = this.I;
        if (pagerAdapter2 != null && (gVar = this.J) != null) {
            pagerAdapter2.unregisterDataSetObserver(gVar);
        }
        this.I = pagerAdapter;
        if (z2 && pagerAdapter != null) {
            if (this.J == null) {
                this.J = new g(this);
            }
            pagerAdapter.registerDataSetObserver(this.J);
        }
        m();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this);
        if (this.H == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                q((ViewPager) parent, true);
            }
        }
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        AttributeSet attributeSet = this.P;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.TabLayout, this.O, R$style.OSTablayout);
            i(typedArrayObtainStyledAttributes);
            j();
            typedArrayObtainStyledAttributes.recycle();
            for (int i8 = 0; i8 < getTabCount(); i8++) {
                ViewCompat.setPaddingRelative(h(i8).f3733g, this.f3687i, this.f3688j, this.f3689k, this.f3690l);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.M) {
            setupWithViewPager(null);
            this.M = false;
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        TabView tabView;
        Drawable drawable;
        int i8 = 0;
        while (true) {
            a aVar = this.f3686h;
            if (i8 >= aVar.getChildCount()) {
                super.onDraw(canvas);
                return;
            }
            View childAt = aVar.getChildAt(i8);
            if ((childAt instanceof TabView) && (drawable = (tabView = (TabView) childAt).f3712k) != null) {
                drawable.setBounds(tabView.getLeft(), tabView.getTop(), tabView.getRight(), tabView.getBottom());
                tabView.f3712k.draw(canvas);
            }
            i8++;
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, getTabCount(), false, 1));
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0075  */
    /* JADX WARN: Code duplicated, block: B:32:0x007f  */
    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i8, int i9) {
        int defaultHeight = getDefaultHeight();
        int mode = View.MeasureSpec.getMode(i9);
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                i9 = View.MeasureSpec.makeMeasureSpec(getPaddingBottom() + getPaddingTop() + defaultHeight, BasicMeasure.EXACTLY);
            }
        } else if (getChildCount() == 1 && View.MeasureSpec.getSize(i9) >= defaultHeight) {
            getChildAt(0).setMinimumHeight(defaultHeight);
        }
        int size = View.MeasureSpec.getSize(i8);
        if (View.MeasureSpec.getMode(i8) != 0) {
            int iDpToPx = this.u;
            if (iDpToPx <= 0) {
                iDpToPx = (int) (size - ViewUtils.dpToPx(getContext(), 56));
            }
            this.f3695s = iDpToPx;
        }
        super.onMeasure(i8, i9);
        if (getChildCount() == 1) {
            View childAt = getChildAt(0);
            int i10 = this.f3701z;
            if (i10 == 0) {
                if (childAt.getMeasuredWidth() < getMeasuredWidth()) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), BasicMeasure.EXACTLY), HorizontalScrollView.getChildMeasureSpec(i9, getPaddingBottom() + getPaddingTop(), childAt.getLayoutParams().height));
                }
            } else if (i10 != 1) {
                if (i10 == 2) {
                    if (childAt.getMeasuredWidth() < getMeasuredWidth()) {
                        childAt.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), BasicMeasure.EXACTLY), HorizontalScrollView.getChildMeasureSpec(i9, getPaddingBottom() + getPaddingTop(), childAt.getLayoutParams().height));
                    }
                }
            } else if (childAt.getMeasuredWidth() != getMeasuredWidth()) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), BasicMeasure.EXACTLY), HorizontalScrollView.getChildMeasureSpec(i9, getPaddingBottom() + getPaddingTop(), childAt.getLayoutParams().height));
            }
            if (childAt.getMeasuredWidth() > getMeasuredWidth()) {
                f();
            } else {
                r();
            }
        }
    }

    public final void p(int i8, float f, boolean z2, boolean z3) {
        int iRound = Math.round(i8 + f);
        if (iRound >= 0) {
            a aVar = this.f3686h;
            if (iRound >= aVar.getChildCount()) {
                return;
            }
            if (z3) {
                ValueAnimator valueAnimator = aVar.f3725l;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    aVar.f3725l.cancel();
                }
                aVar.f3720d = i8;
                aVar.e = f;
                aVar.b();
            }
            ValueAnimator valueAnimator2 = this.G;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.G.cancel();
            }
            scrollTo(e(i8, f), 0);
            if (z2) {
                setSelectedTabView(iRound);
            }
        }
    }

    public final void q(ViewPager viewPager, boolean z2) {
        ViewPager viewPager2 = this.H;
        if (viewPager2 != null) {
            TabLayoutOnPageChangeListener tabLayoutOnPageChangeListener = this.K;
            if (tabLayoutOnPageChangeListener != null) {
                viewPager2.removeOnPageChangeListener(tabLayoutOnPageChangeListener);
            }
            ge.d dVar = this.L;
            if (dVar != null) {
                this.H.removeOnAdapterChangeListener(dVar);
            }
        }
        j jVar = this.F;
        ArrayList arrayList = this.E;
        if (jVar != null) {
            arrayList.remove(jVar);
            this.F = null;
        }
        if (viewPager != null) {
            this.H = viewPager;
            if (this.K == null) {
                this.K = new TabLayoutOnPageChangeListener(this);
            }
            TabLayoutOnPageChangeListener tabLayoutOnPageChangeListener2 = this.K;
            tabLayoutOnPageChangeListener2.f3704c = 0;
            tabLayoutOnPageChangeListener2.f3703b = 0;
            viewPager.addOnPageChangeListener(tabLayoutOnPageChangeListener2);
            j jVar2 = new j(viewPager);
            this.F = jVar2;
            if (!arrayList.contains(jVar2)) {
                arrayList.add(jVar2);
            }
            PagerAdapter adapter = viewPager.getAdapter();
            if (adapter != null) {
                o(adapter, true);
            }
            if (this.L == null) {
                this.L = new ge.d(this);
            }
            ge.d dVar2 = this.L;
            dVar2.f5167a = true;
            viewPager.addOnAdapterChangeListener(dVar2);
            p(viewPager.getCurrentItem(), 0.0f, true, true);
        } else {
            this.H = null;
            o(null, false);
        }
        this.M = z2;
    }

    public final void r() {
        z1OoOif z1oooif = this.S;
        if (z1oooif != null) {
            if (z1oooif.f11242h != z1oooif.f11240c) {
                Log.e("BounceEffect", "detaching while overscroll is in effect.");
                return;
            }
            tk.a aVar = z1oooif.f11239b;
            aVar.getView().setOnTouchListener(null);
            if (!(aVar.getView() instanceof ViewPager2) || ((ViewPager2) aVar.getView()).getChildAt(0) == null) {
                return;
            }
            ((ViewPager2) aVar.getView()).getChildAt(0).setOnTouchListener(null);
        }
    }

    public final void s(boolean z2) {
        int i8 = 0;
        while (true) {
            a aVar = this.f3686h;
            if (i8 >= aVar.getChildCount()) {
                return;
            }
            View childAt = aVar.getChildAt(i8);
            childAt.setMinimumWidth(getTabMinWidth());
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            if (this.f3701z == 1 && this.f3698w == 0) {
                layoutParams.width = 0;
                layoutParams.weight = 1.0f;
            } else {
                layoutParams.width = -2;
                layoutParams.weight = 0.0f;
            }
            if (z2) {
                childAt.requestLayout();
            }
            i8++;
        }
    }

    public void setDefaultSelectedIndicatorRadius(int i8) {
        a aVar = this.f3686h;
        if (aVar.f3724k != i8) {
            aVar.f3724k = i8;
            aVar.f3719c.setCornerRadius(i8);
            ViewCompat.postInvalidateOnAnimation(aVar);
        }
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f) {
        super.setElevation(f);
        MaterialShapeUtils.setElevation(this, f);
    }

    public void setFixPadding(boolean z2) {
        this.Q = z2;
    }

    public void setInlineLabel(boolean z2) {
        if (this.A == z2) {
            return;
        }
        this.A = z2;
        int i8 = 0;
        while (true) {
            a aVar = this.f3686h;
            if (i8 >= aVar.getChildCount()) {
                d();
                return;
            }
            View childAt = aVar.getChildAt(i8);
            if (childAt instanceof TabView) {
                TabView tabView = (TabView) childAt;
                tabView.setOrientation(!TabLayout.this.A ? 1 : 0);
                TextView textView = tabView.f3710i;
                if (textView == null && tabView.f3711j == null) {
                    tabView.i(tabView.f3706b, tabView.f3707c);
                } else {
                    tabView.i(textView, tabView.f3711j);
                }
            }
            i8++;
        }
    }

    public void setInlineLabelResource(@BoolRes int i8) {
        setInlineLabel(getResources().getBoolean(i8));
    }

    @Deprecated
    public void setOnTabSelectedListener(@Nullable f fVar) {
        setOnTabSelectedListener((e) fVar);
    }

    public void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        g();
        this.G.addListener(animatorListener);
    }

    public void setSelectedIndicatorBottomOffset(int i8) {
        a aVar = this.f3686h;
        if (aVar.f3723j != i8) {
            aVar.f3723j = i8;
            ViewCompat.postInvalidateOnAnimation(aVar);
        }
    }

    public void setSelectedTabIndicator(@Nullable Drawable drawable) {
        if (this.f3693o != drawable) {
            this.f3693o = drawable;
            ViewCompat.postInvalidateOnAnimation(this.f3686h);
        }
    }

    public void setSelectedTabIndicatorColor(@ColorInt int i8) {
        a aVar = this.f3686h;
        Paint paint = aVar.f3718b;
        if (paint.getColor() != i8) {
            paint.setColor(i8);
            ViewCompat.postInvalidateOnAnimation(aVar);
        }
    }

    public void setSelectedTabIndicatorGravity(int i8) {
        if (this.f3700y != i8) {
            this.f3700y = i8;
            ViewCompat.postInvalidateOnAnimation(this.f3686h);
        }
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i8) {
        a aVar = this.f3686h;
        if (aVar.f3717a != i8) {
            aVar.f3717a = i8;
            ViewCompat.postInvalidateOnAnimation(aVar);
        }
    }

    public void setTabChildEnable(boolean z2) {
        TabView tabView;
        int tabCount = getTabCount();
        for (int i8 = 0; i8 < tabCount; i8++) {
            b bVarH = h(i8);
            if (bVarH != null && (tabView = bVarH.f3733g) != null) {
                tabView.setEnabled(z2);
            }
        }
    }

    public void setTabGravity(int i8) {
        if (this.f3698w != i8) {
            this.f3698w = i8;
            d();
        }
    }

    public void setTabIndicatorFullWidth(boolean z2) {
        this.B = z2;
        ViewCompat.postInvalidateOnAnimation(this.f3686h);
    }

    public void setTabMode(int i8) {
        if (i8 != this.f3701z) {
            this.f3701z = i8;
            j();
            d();
            for (int i9 = 0; i9 < getTabCount(); i9++) {
                ViewCompat.setPaddingRelative(h(i9).f3733g, this.f3687i, this.f3688j, this.f3689k, this.f3690l);
            }
            if (getTabMode() == 0) {
                f();
            } else {
                r();
            }
        }
    }

    public void setTabTextColors(@Nullable ColorStateList colorStateList) {
        if (this.f3691m != colorStateList) {
            this.f3691m = colorStateList;
            ArrayList arrayList = this.f3684c;
            int size = arrayList.size();
            for (int i8 = 0; i8 < size; i8++) {
                TabView tabView = ((b) arrayList.get(i8)).f3733g;
                if (tabView != null) {
                    tabView.h();
                }
            }
        }
    }

    public void setTabTextSize(float f) {
        this.p = f;
    }

    @Deprecated
    public void setTabsFromPagerAdapter(@Nullable PagerAdapter pagerAdapter) {
        o(pagerAdapter, false);
    }

    public void setupWithViewPager(@Nullable ViewPager viewPager) {
        q(viewPager, false);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    public TabLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final void addView(View view, int i8) {
        b(view);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    @Deprecated
    public void setOnTabSelectedListener(@Nullable e eVar) {
        e eVar2 = this.D;
        ArrayList arrayList = this.E;
        if (eVar2 != null) {
            arrayList.remove(eVar2);
        }
        this.D = eVar;
        if (eVar == null || arrayList.contains(eVar)) {
            return;
        }
        arrayList.add(eVar);
    }

    public TabLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        this.f3684c = new ArrayList();
        this.e = new RectF();
        this.f3695s = Integer.MAX_VALUE;
        this.E = new ArrayList();
        this.R = new Pools.SimplePool(12);
        Context context2 = getContext();
        this.P = attributeSet;
        this.O = i8;
        setHorizontalScrollBarEnabled(false);
        a aVar = new a(this, context2);
        this.f3686h = aVar;
        super.addView(aVar, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R$styleable.TabLayout, i8, R$style.OSTablayout);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.TabLayout_tabIndicatorHeight, -1);
        if (aVar.f3717a != dimensionPixelSize) {
            aVar.f3717a = dimensionPixelSize;
            ViewCompat.postInvalidateOnAnimation(aVar);
        }
        int color = typedArrayObtainStyledAttributes.getColor(R$styleable.TabLayout_tabIndicatorColor, context2.getColor(R$color.os_platform_basic_color_hios));
        Paint paint = aVar.f3718b;
        if (paint.getColor() != color) {
            paint.setColor(color);
            ViewCompat.postInvalidateOnAnimation(aVar);
        }
        int dimensionPixelOffset = context2.getResources().getDimensionPixelOffset(R$dimen.os_tab_default_selected_indicator_radius);
        if (aVar.f3724k != dimensionPixelOffset) {
            aVar.f3724k = dimensionPixelOffset;
            aVar.f3719c.setCornerRadius(dimensionPixelOffset);
            ViewCompat.postInvalidateOnAnimation(aVar);
        }
        setSelectedTabIndicator(MaterialResources.getDrawable(context2, typedArrayObtainStyledAttributes, R$styleable.TabLayout_tabIndicator));
        setSelectedTabIndicatorGravity(typedArrayObtainStyledAttributes.getInt(R$styleable.TabLayout_tabIndicatorGravity, 0));
        setTabIndicatorFullWidth(typedArrayObtainStyledAttributes.getBoolean(R$styleable.TabLayout_tabIndicatorFullWidth, false));
        i(typedArrayObtainStyledAttributes);
        this.f3692n = MaterialResources.getColorStateList(context2, typedArrayObtainStyledAttributes, R$styleable.TabLayout_tabRippleColor);
        this.f3699x = ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION;
        this.f3696t = -1;
        this.u = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.TabLayout_tabMaxWidth, -1);
        this.f3694r = typedArrayObtainStyledAttributes.getResourceId(R$styleable.TabLayout_tabBackground, 0);
        this.f3701z = typedArrayObtainStyledAttributes.getInt(R$styleable.TabLayout_OsTabMode, 1);
        this.f3698w = typedArrayObtainStyledAttributes.getInt(R$styleable.TabLayout_OsTabGravity, 0);
        this.A = typedArrayObtainStyledAttributes.getBoolean(R$styleable.TabLayout_tabInlineLabel, true);
        this.C = typedArrayObtainStyledAttributes.getBoolean(R$styleable.TabLayout_tabUnboundedRipple, false);
        this.f3697v = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.TabLayout_scrollableTabMinWidth, 0);
        typedArrayObtainStyledAttributes.recycle();
        d();
        j();
        if (getTabMode() == 0) {
            f();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public final void addView(View view, ViewGroup.LayoutParams layoutParams) {
        b(view);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final void addView(View view, int i8, ViewGroup.LayoutParams layoutParams) {
        b(view);
    }

    public void setSelectedTabIndicator(@DrawableRes int i8) {
        if (i8 != 0) {
            setSelectedTabIndicator(getResources().getDrawable(i8));
        } else {
            setSelectedTabIndicator((Drawable) null);
        }
    }
}
