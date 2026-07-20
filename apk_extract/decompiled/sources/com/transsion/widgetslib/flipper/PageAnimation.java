package com.transsion.widgetslib.flipper;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager2.widget.ViewPager2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nd.b;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u000b\u001a\u00020\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000f\u001a\u00020\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/transsion/widgetslib/flipper/PageAnimation;", "Landroidx/viewpager2/widget/ViewPager2$PageTransformer;", "<init>", "()V", "", "f", "F", "getAlphaRatio$widgetsLib_release", "()F", "setAlphaRatio$widgetsLib_release", "(F)V", "alphaRatio", "g", "getAlphaPageOutRatio$widgetsLib_release", "setAlphaPageOutRatio$widgetsLib_release", "alphaPageOutRatio", "widgetsLib_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class PageAnimation implements ViewPager2.PageTransformer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f3073a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3074b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f3075c = 0.12f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f3076d = 0.65f;
    public float e = 0.65f - 0.12f;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public float alphaRatio;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    public float alphaPageOutRatio;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public FlipperLayout f3078h;

    /* JADX INFO: renamed from: getAlphaPageOutRatio$widgetsLib_release, reason: from getter */
    public final float getAlphaPageOutRatio() {
        return this.alphaPageOutRatio;
    }

    /* JADX INFO: renamed from: getAlphaRatio$widgetsLib_release, reason: from getter */
    public final float getAlphaRatio() {
        return this.alphaRatio;
    }

    public final void setAlphaPageOutRatio$widgetsLib_release(float f) {
        this.alphaPageOutRatio = f;
    }

    public final void setAlphaRatio$widgetsLib_release(float f) {
        this.alphaRatio = f;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public final void transformPage(View page, float f) {
        ValueAnimator animator;
        FlipperLayout flipperLayout;
        ViewGroup dotLayout;
        int iIntValue;
        FlipperLayout flipperLayout2;
        Intrinsics.checkNotNullParameter(page, "page");
        boolean z2 = false;
        if (this.f3073a == null && (flipperLayout2 = this.f3078h) != null) {
            this.f3073a = Integer.valueOf(flipperLayout2.getPaddingStart());
            this.f3074b = flipperLayout2.getPaddingEnd();
            flipperLayout2.setPaddingRelative(0, flipperLayout2.getPaddingTop(), 0, flipperLayout2.getPaddingBottom());
            flipperLayout2.post(new b(flipperLayout2, 2));
        }
        Integer num = this.f3073a;
        if (num != null && ((iIntValue = num.intValue()) != page.getPaddingStart() || this.f3074b != page.getPaddingEnd())) {
            page.setPaddingRelative(iIntValue, 0, this.f3074b, 0);
        }
        if (page.getTag() == null && (flipperLayout = this.f3078h) != null && (dotLayout = flipperLayout.getDotLayout()) != null) {
            int childCount = dotLayout.getChildCount();
            for (int i8 = 0; i8 < childCount; i8++) {
                View childAt = dotLayout.getChildAt(i8);
                if (childAt.getTag() == null) {
                    childAt.setTag(Integer.valueOf(i8));
                    page.setTag(childAt);
                    break;
                }
            }
        }
        Object tag = page.getTag();
        View view = tag instanceof View ? (View) tag : null;
        FlipperLayout flipperLayout3 = this.f3078h;
        if (flipperLayout3 != null && (animator = flipperLayout3.getAnimator()) != null && animator.isRunning()) {
            z2 = true;
        }
        if (f < -1.0f) {
            page.setAlpha(0.0f);
            if (view == null) {
                return;
            }
            view.setAlpha(this.f3075c);
            return;
        }
        if (f > 1.0f) {
            page.setAlpha(0.0f);
            if (view == null) {
                return;
            }
            view.setAlpha(this.f3075c);
            return;
        }
        if (!z2) {
            if (f > 0.0f) {
                page.setAlpha(1.0f - (f * 1.0f));
                if (view != null) {
                    view.setAlpha(this.f3076d - (this.e * f));
                }
            }
            if (f <= 0.0f) {
                page.setAlpha((f * 1.0f) + 1.0f);
                if (view == null) {
                    return;
                }
                view.setAlpha((this.e * f) + this.f3076d);
                return;
            }
            return;
        }
        if (f > 0.0f) {
            float f4 = 1 - this.alphaRatio;
            page.setAlpha(1.0f - (f4 * 1.0f));
            if (view != null) {
                view.setAlpha(this.f3076d - (this.e * f4));
            }
        }
        if (f <= 0.0f) {
            page.setAlpha(((this.alphaPageOutRatio - 1) * 1.0f) + 1.0f);
            if (view == null) {
                return;
            }
            view.setAlpha(this.f3076d - (this.e * this.alphaRatio));
        }
    }
}
