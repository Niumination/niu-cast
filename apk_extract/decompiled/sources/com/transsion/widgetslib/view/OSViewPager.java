package com.transsion.widgetslib.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnimationUtils;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.ViewPager;
import com.transsion.widgetslib.R$anim;
import ke.d;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import nd.g;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/transsion/widgetslib/view/OSViewPager;", "Landroidx/viewpager/widget/ViewPager;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "item", "", "setCurrentItem", "(I)V", "widgetsLib_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class OSViewPager extends ViewPager {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSViewPager(Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setCurrentItem(int item) {
        setCurrentItem(item, false);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // androidx.viewpager.widget.ViewPager
    public final void setCurrentItem(int i8, boolean z2) {
        int currentItem = !z2 ? getCurrentItem() : 0;
        super.setCurrentItem(i8, z2);
        if (z2 || currentItem == i8) {
            return;
        }
        View currentItemViewBefore = getChildAt(currentItem);
        View currentItemViewReal = getChildAt(i8);
        if (currentItemViewBefore == null || currentItemViewReal == null) {
            return;
        }
        Intrinsics.checkNotNullParameter(currentItemViewBefore, "currentItemViewBefore");
        Intrinsics.checkNotNullParameter(currentItemViewReal, "currentItemViewReal");
        currentItemViewBefore.animate().cancel();
        currentItemViewReal.animate().cancel();
        currentItemViewBefore.animate().alpha(0.0f).setDuration(50L).setInterpolator(AnimationUtils.loadInterpolator(currentItemViewBefore.getContext(), R$anim.os_page_change_alpha_out_interpolator)).setListener(new g(currentItemViewBefore, currentItemViewReal, currentItemViewBefore, 1)).start();
        if (currentItemViewReal.getAlpha() == 1.0f) {
            currentItemViewReal.setAlpha(0.0f);
        }
        currentItemViewReal.animate().alpha(1.0f).setDuration(50L).setInterpolator(AnimationUtils.loadInterpolator(currentItemViewReal.getContext(), R$anim.os_page_change_alpha_in_interpolator)).setListener(new d(currentItemViewReal, 2)).start();
    }
}
