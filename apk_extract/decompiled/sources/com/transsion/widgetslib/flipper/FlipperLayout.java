package com.transsion.widgetslib.flipper;

import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.AttrRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.transsion.widgetslib.R$attr;
import com.transsion.widgetslib.R$color;
import com.transsion.widgetslib.R$dimen;
import com.transsion.widgetslib.R$id;
import com.transsion.widgetslib.R$layout;
import gd.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k3.z8;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import m.c;
import nd.a;
import nd.b;
import nd.d;
import nd.e;
import nd.f;
import nd.g;
import nd.h;
import nd.i;
import nd.k;
import nd.l;
import pd.j;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\n\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\r\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007¢\u0006\u0004\b\r\u0010\u000bJ\u001b\u0010\u000f\u001a\u00020\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007¢\u0006\u0004\b\u000f\u0010\u000bJ\u001b\u0010\u0012\u001a\u00020\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0007¢\u0006\u0004\b\u0012\u0010\u000bJ\u001b\u0010\u0013\u001a\u00020\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007¢\u0006\u0004\b\u0013\u0010\u000bJ\u001b\u0010\u0014\u001a\u00020\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0007¢\u0006\u0004\b\u0014\u0010\u000bJ\r\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001b\u0010\u001aJ\u000f\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001f\u0010 J\u001d\u0010\"\u001a\u00020\u00042\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00100\u0007H\u0002¢\u0006\u0004\b\"\u0010\u000bR$\u0010(\u001a\u0004\u0018\u00010\u001c8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\u001e\"\u0004\b&\u0010'R\"\u00100\u001a\u00020)8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R$\u00108\u001a\u0004\u0018\u0001018\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001b\u0010>\u001a\u0002098BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u001b\u0010A\u001a\u0002098BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b?\u0010;\u001a\u0004\b@\u0010=R\u001b\u0010F\u001a\u00020B8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010;\u001a\u0004\bD\u0010E¨\u0006G"}, d2 = {"Lcom/transsion/widgetslib/flipper/FlipperLayout;", "Landroid/widget/LinearLayout;", "", "pst", "", "setCurrentPst", "(I)V", "", "Landroid/graphics/drawable/Drawable;", "drawableList", "setDrawableList", "(Ljava/util/List;)V", "drawableResList", "setDrawableResList", "textResList", "setPrimaryTextResList", "", "textList", "setPrimaryTextList", "setSecondaryTextResList", "setSecondaryTextList", "Landroidx/viewpager2/widget/ViewPager2;", "getViewPager", "()Landroidx/viewpager2/widget/ViewPager2;", "Landroid/widget/TextView;", "getTvPrimary", "()Landroid/widget/TextView;", "getTvSecondary", "Landroid/view/ViewGroup;", "getLayoutDot", "()Landroid/view/ViewGroup;", "getShiftWidth", "()I", "secondaryCharList", "setNoTopicTextLayoutHeight", "m", "Landroid/view/ViewGroup;", "getDotLayout$widgetsLib_release", "setDotLayout$widgetsLib_release", "(Landroid/view/ViewGroup;)V", "dotLayout", "", "o", "Z", "isCyclic$widgetsLib_release", "()Z", "setCyclic$widgetsLib_release", "(Z)V", "isCyclic", "Landroid/animation/ValueAnimator;", "r", "Landroid/animation/ValueAnimator;", "getAnimator$widgetsLib_release", "()Landroid/animation/ValueAnimator;", "setAnimator$widgetsLib_release", "(Landroid/animation/ValueAnimator;)V", "animator", "Landroid/view/animation/PathInterpolator;", "x", "Lkotlin/Lazy;", "getShiftInpt", "()Landroid/view/animation/PathInterpolator;", "shiftInpt", "y", "getAlphaInpt", "alphaInpt", "Landroid/view/View$OnTouchListener;", "D", "getOnTouchListener", "()Landroid/view/View$OnTouchListener;", "onTouchListener", "widgetsLib_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@SourceDebugExtension({"SMAP\nFlipperLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FlipperLayout.kt\ncom/transsion/widgetslib/flipper/FlipperLayout\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,615:1\n1#2:616\n1855#3,2:617\n1855#3,2:619\n1855#3,2:621\n*S KotlinDebug\n*F\n+ 1 FlipperLayout.kt\ncom/transsion/widgetslib/flipper/FlipperLayout\n*L\n345#1:617,2\n419#1:619,2\n486#1:621,2\n*E\n"})
public final class FlipperLayout extends LinearLayout {
    public static final /* synthetic */ int E = 0;
    public final PageAnimation A;
    public final FlipperLayout$onPageChangeCallback$1 B;
    public float C;

    /* JADX INFO: renamed from: D, reason: from kotlin metadata */
    public final Lazy onTouchListener;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewPager2 f3052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f3053b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f3054c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f3055d;
    public TextView e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f3056h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List f3057i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List f3058j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ArrayList f3059k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ArrayList f3060l;

    /* JADX INFO: renamed from: m, reason: collision with root package name and from kotlin metadata */
    public ViewGroup dotLayout;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public DefaultAdapter f3062n;

    /* JADX INFO: renamed from: o, reason: collision with root package name and from kotlin metadata */
    public boolean isCyclic;
    public final int p;
    public final boolean q;

    /* JADX INFO: renamed from: r, reason: collision with root package name and from kotlin metadata */
    public ValueAnimator animator;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f3065s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f3066t;
    public float u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f3067v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f3068w;

    /* JADX INFO: renamed from: x, reason: collision with root package name and from kotlin metadata */
    public final Lazy shiftInpt;

    /* JADX INFO: renamed from: y, reason: collision with root package name and from kotlin metadata */
    public final Lazy alphaInpt;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f3071z;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FlipperLayout(Context context) {
        this(context, null, 0, 14);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static void a(FlipperLayout this$0, e func) {
        ValueAnimator valueAnimatorOfPropertyValuesHolder;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(func, "$func");
        int shiftWidth = this$0.getShiftWidth();
        this$0.f3071z = shiftWidth;
        z8.d("FlipperLayout", "initAnimator, width: " + this$0.getWidth() + ", shiftDistance: " + this$0.f3071z);
        if (shiftWidth > 0) {
            Keyframe keyframeOfFloat = Keyframe.ofFloat(0.0f, 1.0f);
            Keyframe keyframeOfFloat2 = Keyframe.ofFloat(0.6f, 0.0f);
            keyframeOfFloat2.setInterpolator(this$0.getAlphaInpt());
            Unit unit = Unit.INSTANCE;
            valueAnimatorOfPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofKeyframe("pvh_alpha_page_out", keyframeOfFloat, keyframeOfFloat2, Keyframe.ofFloat(1.0f, 0.0f)), PropertyValuesHolder.ofInt("pvh_shift", 0, shiftWidth));
            valueAnimatorOfPropertyValuesHolder.setDuration(250L);
            valueAnimatorOfPropertyValuesHolder.setInterpolator(new LinearInterpolator());
        } else {
            valueAnimatorOfPropertyValuesHolder = null;
        }
        func.invoke(valueAnimatorOfPropertyValuesHolder);
    }

    public static void b(FlipperLayout this$0, Ref.IntRef currentValue, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(currentValue, "$currentValue");
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue("pvh_alpha_page_out");
        ViewPager2 viewPager2 = null;
        Float f = animatedValue instanceof Float ? (Float) animatedValue : null;
        if (f != null) {
            this$0.A.setAlphaPageOutRatio$widgetsLib_release(f.floatValue());
        }
        Object animatedValue2 = animation.getAnimatedValue("pvh_shift");
        if ((animatedValue2 instanceof Integer ? (Integer) animatedValue2 : null) != null) {
            float animatedFraction = animation.getAnimatedFraction();
            int interpolation = (int) (this$0.getShiftInpt().getInterpolation(animatedFraction) * this$0.f3071z);
            this$0.A.setAlphaRatio$widgetsLib_release(this$0.getAlphaInpt().getInterpolation(animatedFraction));
            int i8 = j.v() ? interpolation - currentValue.element : currentValue.element - interpolation;
            ViewPager2 viewPager3 = this$0.f3052a;
            if (viewPager3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            } else {
                viewPager2 = viewPager3;
            }
            viewPager2.fakeDragBy(i8);
            currentValue.element = interpolation;
        }
    }

    private final PathInterpolator getAlphaInpt() {
        return (PathInterpolator) this.alphaInpt.getValue();
    }

    private final View.OnTouchListener getOnTouchListener() {
        return (View.OnTouchListener) this.onTouchListener.getValue();
    }

    private final PathInterpolator getShiftInpt() {
        return (PathInterpolator) this.shiftInpt.getValue();
    }

    private final int getShiftWidth() {
        return ((getWidth() - getPaddingStart()) - getPaddingEnd()) - 2;
    }

    private final void setNoTopicTextLayoutHeight(List<CharSequence> secondaryCharList) {
        TextView textView = this.e;
        Intrinsics.checkNotNull(textView);
        textView.getViewTreeObserver().addOnGlobalLayoutListener(new p(this, secondaryCharList, 2));
    }

    public final void c(List list) {
        if (list.size() > 0) {
            ViewPager2 viewPager2 = this.f3052a;
            if (viewPager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                viewPager2 = null;
            }
            viewPager2.setOffscreenPageLimit(list.size());
        }
        if (!this.isCyclic || list.size() <= 0) {
            return;
        }
        Object obj = list.get(0);
        if (list.size() > 1) {
            list.add(0, list.get(CollectionsKt.getLastIndex(list)));
            list.add(obj);
        }
    }

    public final void d() {
        List list;
        if (this.f3055d == null) {
            View viewInflate = ((ViewStub) findViewById(R$id.stubTextPrimary)).inflate();
            Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type android.widget.TextView");
            TextView textView = (TextView) viewInflate;
            ViewPager2 viewPager2 = this.f3052a;
            if (viewPager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                viewPager2 = null;
            }
            if (viewPager2.getAdapter() != null && (list = this.f3057i) != null) {
                int size = list.size();
                int i8 = this.f3056h;
                if (i8 >= 0 && i8 < size) {
                    textView.setText((CharSequence) list.get(i8));
                    textView.post(new c(textView, 5));
                }
            }
            this.f3055d = textView;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (ev.getAction() == 0) {
            ev.setLocation(ev.getX(), this.f3068w);
            requestDisallowInterceptTouchEvent(false);
        } else {
            ev.setLocation(ev.getX(), ev.getY() - this.f3068w);
        }
        ViewPager2 viewPager2 = this.f3052a;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager2 = null;
        }
        return viewPager2.dispatchTouchEvent(ev);
    }

    public final void e() {
        List list;
        if (this.e == null) {
            View viewInflate = ((ViewStub) findViewById(R$id.stubTextSecondary)).inflate();
            Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type android.widget.TextView");
            TextView textView = (TextView) viewInflate;
            ViewPager2 viewPager2 = this.f3052a;
            if (viewPager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                viewPager2 = null;
            }
            if (viewPager2.getAdapter() != null && (list = this.f3058j) != null) {
                int size = list.size();
                int i8 = this.f3056h;
                if (i8 >= 0 && i8 < size) {
                    textView.setText((CharSequence) list.get(i8));
                    textView.post(new c(textView, 5));
                }
            }
            this.e = textView;
        }
    }

    public final void f() {
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            int shiftWidth = getShiftWidth();
            if (shiftWidth > 0 && this.f3071z != shiftWidth) {
                this.A.f3073a = null;
                this.f3071z = shiftWidth;
            }
            int i8 = 0;
            nd.c cVar = new nd.c(i8, this, new Ref.IntRef());
            valueAnimator.addUpdateListener(cVar);
            valueAnimator.addListener(new g(this, valueAnimator, cVar, i8));
            valueAnimator.start();
        }
    }

    public final void g() {
        ViewPager2 viewPager2;
        long jLongValue;
        ViewPager2 viewPager3;
        if (this.f3065s && this.q) {
            b bVar = this.f3054c;
            if (bVar == null) {
                this.f3054c = new b(this, 0);
            } else {
                removeCallbacks(bVar);
            }
            ArrayList arrayList = this.f3059k;
            int size = arrayList.size();
            ViewPager2 viewPager4 = this.f3052a;
            if (viewPager4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                viewPager2 = null;
            } else {
                viewPager2 = viewPager4;
            }
            int currentItem = viewPager2.getCurrentItem();
            if (currentItem < 0 || currentItem >= size) {
                jLongValue = 3000;
            } else {
                if (viewPager4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                    viewPager3 = null;
                } else {
                    viewPager3 = viewPager4;
                }
                jLongValue = ((Number) arrayList.get(viewPager3.getCurrentItem())).longValue();
            }
            if (viewPager4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                viewPager4 = null;
            }
            z8.d("FlipperLayout", "sendScrollMsg, currentItem: " + viewPager4.getCurrentItem() + ", interval: " + jLongValue);
            postDelayed(this.f3054c, jLongValue);
        }
    }

    /* JADX INFO: renamed from: getAnimator$widgetsLib_release, reason: from getter */
    public final ValueAnimator getAnimator() {
        return this.animator;
    }

    /* JADX INFO: renamed from: getDotLayout$widgetsLib_release, reason: from getter */
    public final ViewGroup getDotLayout() {
        return this.dotLayout;
    }

    public final ViewGroup getLayoutDot() {
        return this.dotLayout;
    }

    /* JADX INFO: renamed from: getTvPrimary, reason: from getter */
    public final TextView getF3055d() {
        return this.f3055d;
    }

    /* JADX INFO: renamed from: getTvSecondary, reason: from getter */
    public final TextView getE() {
        return this.e;
    }

    public final ViewPager2 getViewPager() {
        ViewPager2 viewPager2 = this.f3052a;
        if (viewPager2 != null) {
            return viewPager2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        return null;
    }

    public final void h(List dataList, Function0 adapter) {
        ViewPager2 viewPager2;
        ViewPager2 viewPager3;
        ViewPager2 viewPager4;
        int i8 = 1;
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        c(dataList);
        ViewPager2 viewPager5 = this.f3052a;
        if (viewPager5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager2 = null;
        } else {
            viewPager2 = viewPager5;
        }
        viewPager2.setAdapter((RecyclerView.Adapter) adapter.invoke());
        if (this.dotLayout == null) {
            Intrinsics.checkNotNullParameter(this, "<this>");
            int iE = j.e(getContext(), R$attr.os_comp_color_page_focus, R$color.os_comp_color_page_focus_hios) | ViewCompat.MEASURED_STATE_MASK;
            View viewInflate = ((ViewStub) findViewById(R$id.stubDots)).inflate();
            Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type android.view.ViewGroup");
            ViewGroup viewGroup = (ViewGroup) viewInflate;
            RecyclerView.Adapter adapter2 = getViewPager().getAdapter();
            if (adapter2 != null) {
                int itemCount = adapter2.getItemCount();
                if (itemCount > 1) {
                    viewGroup.setVisibility(0);
                    int dimensionPixelOffset = viewGroup.getResources().getDimensionPixelOffset(R$dimen.os_spring_page_marker_radius) * 2;
                    int dimensionPixelOffset2 = viewGroup.getResources().getDimensionPixelOffset(R$dimen.os_flipper_layout_circle_indicator_margin_lr);
                    for (int i9 = 0; i9 < itemCount; i9++) {
                        ImageView imageView = new ImageView(viewGroup.getContext());
                        imageView.setBackground(new ColorDrawable(iE));
                        imageView.setOnClickListener(new a(i9, i8, this));
                        if (this.isCyclic && (i9 == 0 || i9 == itemCount - 1)) {
                            imageView.setVisibility(8);
                        }
                        imageView.setClipToOutline(true);
                        imageView.setOutlineProvider(new ae.a(3));
                        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(dimensionPixelOffset, dimensionPixelOffset);
                        marginLayoutParams.setMarginStart(dimensionPixelOffset2);
                        marginLayoutParams.setMarginEnd(marginLayoutParams.getMarginStart());
                        Unit unit = Unit.INSTANCE;
                        viewGroup.addView(imageView, i9, marginLayoutParams);
                    }
                } else {
                    viewGroup.setVisibility(8);
                }
            }
            this.dotLayout = viewGroup;
        }
        setCurrentPst(this.f3056h);
        if (viewPager5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager3 = null;
        } else {
            viewPager3 = viewPager5;
        }
        RecyclerView.Adapter adapter3 = viewPager3.getAdapter();
        if (adapter3 != null) {
            int itemCount2 = adapter3.getItemCount();
            ArrayList arrayList = this.f3059k;
            arrayList.clear();
            for (int i10 = 0; i10 < itemCount2; i10++) {
                arrayList.add(i10, 3000L);
            }
            ArrayList<Pair> arrayList2 = this.f3060l;
            if (arrayList2 != null) {
                for (Pair pair : arrayList2) {
                    int iIntValue = ((Number) pair.getFirst()).intValue();
                    long jLongValue = ((Number) pair.getSecond()).longValue();
                    if (viewPager5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                        viewPager4 = null;
                    } else {
                        viewPager4 = viewPager5;
                    }
                    if (viewPager4.getAdapter() == null) {
                        if (this.f3060l == null) {
                            this.f3060l = new ArrayList();
                        }
                        ArrayList arrayList3 = this.f3060l;
                        if (arrayList3 != null) {
                            arrayList3.add(new Pair(Integer.valueOf(iIntValue), Long.valueOf(jLongValue)));
                        }
                    } else if (this.isCyclic) {
                        int i11 = this.p;
                        int lastIndex = iIntValue + i11;
                        if (iIntValue == 0) {
                            arrayList.set(CollectionsKt.getLastIndex(arrayList), Long.valueOf(jLongValue));
                        } else if (iIntValue == CollectionsKt.getLastIndex(arrayList)) {
                            arrayList.set(0, Long.valueOf(jLongValue));
                            lastIndex = CollectionsKt.getLastIndex(arrayList) - i11;
                        } else if (iIntValue == CollectionsKt.getLastIndex(arrayList) - (i11 * 2)) {
                            arrayList.set(0, Long.valueOf(jLongValue));
                        }
                        if (lastIndex >= 0 && lastIndex < arrayList.size()) {
                            arrayList.set(lastIndex, Long.valueOf(jLongValue));
                        }
                    } else if (iIntValue >= 0 && iIntValue < arrayList.size()) {
                        arrayList.set(iIntValue, Long.valueOf(jLongValue));
                    }
                }
                arrayList2.clear();
                this.f3060l = null;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        List list;
        super.onDetachedFromWindow();
        DefaultAdapter defaultAdapter = this.f3062n;
        if (defaultAdapter != null && (list = defaultAdapter.getList()) != null) {
            list.clear();
        }
        ViewPager2 viewPager2 = this.f3052a;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager2 = null;
        }
        viewPager2.unregisterOnPageChangeCallback(this.B);
        List list2 = this.f3057i;
        if (list2 != null) {
            list2.clear();
        }
        List list3 = this.f3058j;
        if (list3 != null) {
            list3.clear();
        }
        this.f3059k.clear();
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            valueAnimator.removeAllUpdateListeners();
        }
    }

    @Override // android.view.View
    public final void onVisibilityAggregated(boolean z2) {
        super.onVisibilityAggregated(z2);
        this.f3065s = z2;
        if (z2) {
            g();
            return;
        }
        removeCallbacks(this.f3054c);
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            if (!valueAnimator.isRunning()) {
                valueAnimator = null;
            }
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z2) {
        z8.b("FlipperLayout", "requestDisallowInterceptTouchEvent: " + z2);
        super.requestDisallowInterceptTouchEvent(z2);
    }

    public final void setAnimator$widgetsLib_release(ValueAnimator valueAnimator) {
        this.animator = valueAnimator;
    }

    public final void setCurrentPst(int pst) {
        ViewPager2 viewPager2;
        ViewPager2 viewPager3 = this.f3052a;
        if (viewPager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager2 = null;
        } else {
            viewPager2 = viewPager3;
        }
        if (viewPager2.getAdapter() == null) {
            this.f3056h = pst;
        } else {
            if (viewPager3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                viewPager3 = null;
            }
            l.a(viewPager3, this.isCyclic ? this.p + pst : pst, false);
        }
        z8.d("FlipperLayout", "setCurrentPst, pst: " + pst + ", currentPst: " + this.f3056h);
    }

    public final void setCyclic$widgetsLib_release(boolean z2) {
        this.isCyclic = z2;
    }

    public final void setDotLayout$widgetsLib_release(ViewGroup viewGroup) {
        this.dotLayout = viewGroup;
    }

    public final void setDrawableList(List<Drawable> drawableList) {
        Intrinsics.checkNotNullParameter(drawableList, "drawableList");
        h(drawableList, new h(drawableList, this));
    }

    public final void setDrawableResList(List<Integer> drawableResList) {
        Intrinsics.checkNotNullParameter(drawableResList, "drawableResList");
        h(drawableResList, new i(drawableResList, this));
    }

    public final void setPrimaryTextList(List<CharSequence> textList) {
        Intrinsics.checkNotNullParameter(textList, "textList");
        c(textList);
        this.f3057i = textList;
        d();
    }

    public final void setPrimaryTextResList(List<Integer> textResList) {
        Intrinsics.checkNotNullParameter(textResList, "textResList");
        c(textResList);
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = textResList.iterator();
        while (it.hasNext()) {
            CharSequence text = getResources().getText(((Number) it.next()).intValue());
            Intrinsics.checkNotNullExpressionValue(text, "resources.getText(element)");
            arrayList.add(text);
        }
        this.f3057i = arrayList;
        d();
    }

    public final void setSecondaryTextList(List<CharSequence> textList) {
        List list;
        Intrinsics.checkNotNullParameter(textList, "textList");
        c(textList);
        this.f3058j = textList;
        e();
        List list2 = this.f3057i;
        if (list2 == null || list2.isEmpty()) {
            List<CharSequence> list3 = this.f3058j;
            Intrinsics.checkNotNull(list3);
            setNoTopicTextLayoutHeight(list3);
            return;
        }
        List list4 = this.f3057i;
        if (list4 == null || (list = this.f3058j) == null) {
            return;
        }
        TextView textView = this.e;
        Intrinsics.checkNotNull(textView);
        textView.getViewTreeObserver().addOnGlobalLayoutListener(new nd.j(this, list, list4));
    }

    public final void setSecondaryTextResList(List<Integer> textResList) {
        Intrinsics.checkNotNullParameter(textResList, "textResList");
        c(textResList);
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = textResList.iterator();
        while (it.hasNext()) {
            CharSequence text = getResources().getText(((Number) it.next()).intValue());
            Intrinsics.checkNotNullExpressionValue(text, "resources.getText(element)");
            arrayList.add(text);
        }
        this.f3058j = arrayList;
        e();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FlipperLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 12);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FlipperLayout(Context context, AttributeSet attributeSet, @AttrRes int i8) {
        this(context, attributeSet, i8, 8);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v5, types: [androidx.viewpager2.widget.ViewPager2$OnPageChangeCallback, com.transsion.widgetslib.flipper.FlipperLayout$onPageChangeCallback$1] */
    public FlipperLayout(Context context, AttributeSet attributeSet, int i8, int i9) {
        attributeSet = (i9 & 2) != 0 ? null : attributeSet;
        i8 = (i9 & 4) != 0 ? 0 : i8;
        Intrinsics.checkNotNullParameter(context, "context");
        super(context, attributeSet, i8, 0);
        this.f3059k = new ArrayList();
        this.isCyclic = true;
        this.p = 1;
        this.q = true;
        this.shiftInpt = LazyKt.lazy(k.INSTANCE);
        this.alphaInpt = LazyKt.lazy(d.INSTANCE);
        PageAnimation pageAnimation = new PageAnimation();
        Intrinsics.checkNotNullParameter(this, "layout");
        if (pageAnimation.f3078h == null) {
            pageAnimation.f3078h = this;
            Context context2 = getContext();
            pageAnimation.f3075c = Color.alpha(j.e(context2, R$attr.os_comp_color_page_default, R$color.os_comp_color_page_default_hios)) / 255.0f;
            float fAlpha = Color.alpha(j.d(R$attr.os_comp_color_page_focus, context2.getColor(R$color.os_comp_color_page_focus_hios), context2)) / 255.0f;
            pageAnimation.f3076d = fAlpha;
            pageAnimation.e = fAlpha - pageAnimation.f3075c;
        }
        this.A = pageAnimation;
        ?? r7 = new ViewPager2.OnPageChangeCallback() { // from class: com.transsion.widgetslib.flipper.FlipperLayout$onPageChangeCallback$1
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public final void onPageScrollStateChanged(int i10) {
                ViewPager2 viewPager2;
                FlipperLayout flipperLayout = this.f3072a;
                z8.f("FlipperLayout", "onPageScrollStateChanged, state: " + i10 + ", currentPst: " + flipperLayout.f3056h);
                if (flipperLayout.q) {
                    if (i10 == 0) {
                        flipperLayout.g();
                    } else {
                        flipperLayout.removeCallbacks(flipperLayout.f3054c);
                    }
                }
                if (flipperLayout.isCyclic && i10 == 0) {
                    ViewPager2 viewPager3 = flipperLayout.f3052a;
                    ViewPager2 viewPager4 = null;
                    if (viewPager3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                        viewPager3 = null;
                    }
                    RecyclerView.Adapter adapter = viewPager3.getAdapter();
                    if (adapter != null) {
                        int itemCount = adapter.getItemCount() - 1;
                        int i11 = flipperLayout.f3056h;
                        int i12 = flipperLayout.p;
                        ViewPager2 viewPager5 = flipperLayout.f3052a;
                        if (i11 == 0) {
                            if (viewPager5 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                                viewPager2 = null;
                            } else {
                                viewPager2 = viewPager5;
                            }
                            l.a(viewPager2, itemCount - i12, false);
                        }
                        if (flipperLayout.f3056h == itemCount) {
                            if (viewPager5 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                            } else {
                                viewPager4 = viewPager5;
                            }
                            l.a(viewPager4, i12, false);
                        }
                    }
                }
            }

            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public final void onPageSelected(int i10) {
                FlipperLayout flipperLayout = this.f3072a;
                z8.b("FlipperLayout", "onPageSelected, position: " + i10 + ", currentPst: " + flipperLayout.f3056h);
                List list = flipperLayout.f3057i;
                if (list != null && i10 >= 0 && i10 < list.size()) {
                    TextView textView = flipperLayout.f3055d;
                    if (textView != null) {
                        textView.setText((CharSequence) list.get(i10));
                    }
                    TextView textView2 = flipperLayout.f3055d;
                    if (textView2 != null) {
                        textView2.post(new c(textView2, 5));
                    }
                }
                List list2 = flipperLayout.f3058j;
                if (list2 != null && i10 >= 0 && i10 < list2.size()) {
                    TextView textView3 = flipperLayout.e;
                    if (textView3 != null) {
                        textView3.setText((CharSequence) list2.get(i10));
                    }
                    TextView textView4 = flipperLayout.e;
                    if (textView4 != null) {
                        textView4.post(new c(textView4, 5));
                    }
                }
                flipperLayout.f3056h = i10;
            }
        };
        this.B = r7;
        setOrientation(1);
        LinearLayout.inflate(context, R$layout.os_flipper_layout, this);
        View viewFindViewById = findViewById(R$id.textParentLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById<LinearLayout>(R.id.textParentLayout)");
        this.f3053b = (LinearLayout) viewFindViewById;
        View viewFindViewById2 = findViewById(R$id.flipPager);
        ViewPager2 viewPager2 = (ViewPager2) viewFindViewById2;
        viewPager2.setPageTransformer(pageAnimation);
        viewPager2.registerOnPageChangeCallback(r7);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById<ViewPager2>…ChangeCallback)\n        }");
        this.f3052a = viewPager2;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R$dimen.os_flipper_layout_padding_lr);
        setPaddingRelative(dimensionPixelOffset, getPaddingTop(), dimensionPixelOffset, getResources().getDimensionPixelOffset(R$dimen.os_flipper_layout_padding_bottom));
        post(new b(this, 1));
        this.onTouchListener = LazyKt.lazy(new f(this));
    }
}
