package com.transsion.widgetslib.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.d;
import com.transsion.widgetslib.R$attr;
import com.transsion.widgetslib.R$color;
import com.transsion.widgetslib.R$dimen;
import com.transsion.widgetslib.R$drawable;
import com.transsion.widgetslib.R$layout;
import com.transsion.widgetslib.R$styleable;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import pd.j;
import zd.o;
import zd.p;
import zd.q;
import zd.r;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0017\u001a\u00020\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001c\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010!\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001f\u0010 R\u0014\u0010$\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#¨\u0006%"}, d2 = {"Lcom/transsion/widgetslib/widget/OSSegmentedTab;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lzd/o;", "listener", "", "setOnTabSelectedListener", "(Lzd/o;)V", "", "enabled", "setSwipeEnabled", "(Z)V", "a", "Lkotlin/Lazy;", "getMCapsuleContainer", "()Landroid/widget/FrameLayout;", "mCapsuleContainer", "Landroid/view/View;", "b", "getMIndicator", "()Landroid/view/View;", "mIndicator", "Landroid/widget/LinearLayout;", "c", "getMTabContainer", "()Landroid/widget/LinearLayout;", "mTabContainer", "getAdapterCount", "()I", "adapterCount", "widgetsLib_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@SourceDebugExtension({"SMAP\nOSSegmentedTab.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OSSegmentedTab.kt\ncom/transsion/widgetslib/widget/OSSegmentedTab\n+ 2 Context.kt\nandroidx/core/content/ContextKt\n+ 3 ViewGroup.kt\nandroidx/core/view/ViewGroupKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,684:1\n52#2,9:685\n48#3:694\n51#3:696\n1#4:695\n*S KotlinDebug\n*F\n+ 1 OSSegmentedTab.kt\ncom/transsion/widgetslib/widget/OSSegmentedTab\n*L\n106#1:685,9\n438#1:694\n315#1:696\n*E\n"})
public final class OSSegmentedTab extends FrameLayout {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f3401n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Lazy mCapsuleContainer;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Lazy mIndicator;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Lazy mTabContainer;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f3405d;
    public final int e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f3406h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f3407i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f3408j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ArrayList f3409k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ValueAnimator f3410l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ValueAnimator f3411m;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSSegmentedTab(Context context) {
        this(context, null, 6, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final int getAdapterCount() {
        return this.f3409k.size();
    }

    private final FrameLayout getMCapsuleContainer() {
        Object value = this.mCapsuleContainer.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mCapsuleContainer>(...)");
        return (FrameLayout) value;
    }

    private final View getMIndicator() {
        Object value = this.mIndicator.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mIndicator>(...)");
        return (View) value;
    }

    private final LinearLayout getMTabContainer() {
        Object value = this.mTabContainer.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mTabContainer>(...)");
        return (LinearLayout) value;
    }

    public final void a(float f, float f4) {
        float paddingLeft;
        ViewGroup.LayoutParams layoutParams = getMIndicator().getLayoutParams();
        int i8 = (int) f4;
        layoutParams.width = i8;
        getMIndicator().setLayoutParams(layoutParams);
        FrameLayout mCapsuleContainer = getMCapsuleContainer();
        int width = mCapsuleContainer.getWidth();
        if (width <= 0) {
            paddingLeft = 0.0f;
        } else {
            paddingLeft = mCapsuleContainer.getLayoutDirection() != 1 ? mCapsuleContainer.getPaddingLeft() : (width - mCapsuleContainer.getPaddingRight()) - i8;
        }
        getMIndicator().setTranslationX(f - paddingLeft);
        getMIndicator().invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.f3410l;
        if (valueAnimator != null) {
            if (!valueAnimator.isRunning()) {
                valueAnimator = null;
            }
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
        }
        this.f3410l = null;
        ValueAnimator valueAnimator2 = this.f3411m;
        if (valueAnimator2 != null) {
            if (!valueAnimator2.isRunning()) {
                valueAnimator2 = null;
            }
            if (valueAnimator2 != null) {
                valueAnimator2.cancel();
            }
        }
        this.f3411m = null;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i8, int i9) {
        View childAt;
        super.onMeasure(i8, i9);
        int i10 = this.f3405d;
        if (i10 < 0 || i10 >= getMTabContainer().getChildCount() || (childAt = getMTabContainer().getChildAt(this.f3405d)) == null) {
            return;
        }
        int measuredWidth = getMIndicator().getMeasuredWidth();
        int measuredWidth2 = childAt.getMeasuredWidth();
        if (measuredWidth != measuredWidth2) {
            post(new d(childAt, this, measuredWidth2, 8));
        }
    }

    public final void setOnTabSelectedListener(o listener) {
    }

    public final void setSwipeEnabled(boolean enabled) {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSSegmentedTab(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 4, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ OSSegmentedTab(Context context, AttributeSet attributeSet, int i8, int i9) {
        this(context, (i8 & 2) != 0 ? null : attributeSet, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSSegmentedTab(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mCapsuleContainer = LazyKt.lazy(new p(this));
        this.mIndicator = LazyKt.lazy(new q(this));
        this.mTabContainer = LazyKt.lazy(new r(this));
        this.f3405d = -1;
        this.e = 400;
        this.f3409k = new ArrayList();
        FrameLayout.inflate(context, R$layout.os_capsule_tab_layout, this);
        int[] OSSegmentTab = R$styleable.OSSegmentTab;
        Intrinsics.checkNotNullExpressionValue(OSSegmentTab, "OSSegmentTab");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, OSSegmentTab, 0, 0);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        int i9 = R$styleable.OSSegmentTab_segmentTabBackground;
        int i10 = R$attr.os_fill_weak;
        int i11 = R$color.os_fill_weak_hios;
        String[] strArr = j.f8764a;
        typedArrayObtainStyledAttributes.getColor(i9, j.d(i10, context.getColor(i11), context));
        typedArrayObtainStyledAttributes.getColor(R$styleable.OSSegmentTab_segmentTabIndicatorColor, typedArrayObtainStyledAttributes.getResources().getColor(R$color.top_navigation_selected_bg));
        this.f3407i = typedArrayObtainStyledAttributes.getResources().getDimensionPixelSize(R$dimen.os_segment_tab_text_select_size);
        this.f3408j = typedArrayObtainStyledAttributes.getResources().getDimensionPixelSize(R$dimen.os_segment_tab_text_unselect_size);
        this.f3407i = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.OSSegmentTab_segmentTabSelectTextSize, this.f3407i);
        this.f3408j = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.OSSegmentTab_segmentTabUnSelectTextSize, this.f3408j);
        typedArrayObtainStyledAttributes.getColor(R$styleable.OSSegmentTab_segmentTabTextSelectedColor, j.e(getContext(), R$attr.os_text_primary, R$color.os_text_primary_hios));
        typedArrayObtainStyledAttributes.getColor(R$styleable.OSSegmentTab_segmentTabTextNormalColor, j.e(getContext(), R$attr.os_text_tertiary, R$color.os_text_tertiary_hios));
        this.f3406h = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.OSSegmentTab_segmentTabPadding, (int) TypedValue.applyDimension(1, 2.0f, typedArrayObtainStyledAttributes.getResources().getDisplayMetrics()));
        this.e = typedArrayObtainStyledAttributes.getInteger(R$styleable.OSSegmentTab_segmentTabIndicatorAnimDuration, this.e);
        typedArrayObtainStyledAttributes.getInteger(R$styleable.OSSegmentTab_segmentTabTextPadding, typedArrayObtainStyledAttributes.getResources().getDimensionPixelSize(R$dimen.os_space150));
        typedArrayObtainStyledAttributes.recycle();
        FrameLayout mCapsuleContainer = getMCapsuleContainer();
        int i12 = this.f3406h;
        mCapsuleContainer.setPadding(i12, i12, i12, i12);
        getMCapsuleContainer().setBackgroundResource(R$drawable.os_segment_tab_bg);
        getMIndicator().setBackgroundResource(R$drawable.os_segment_tab_indicator);
        ViewConfiguration.get(context).getScaledTouchSlop();
    }
}
