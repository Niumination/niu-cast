package com.transsion.widgetslib.view.swipmenu;

import android.graphics.Rect;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.accessibility.AccessibilityEvent;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.transsion.widgetslib.R$string;
import java.util.List;
import k3.z8;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import o.d;
import yd.a;
import yd.l;
import yd.n;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/transsion/widgetslib/view/swipmenu/SwipeMenuExploreByTouchHelper;", "Landroidx/customview/widget/ExploreByTouchHelper;", "yd/n", "widgetsLib_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SwipeMenuExploreByTouchHelper extends ExploreByTouchHelper {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Rect f3366c = new Rect(0, 0, 0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OSSwipeMenuLayout f3367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SparseArray f3368b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwipeMenuExploreByTouchHelper(OSSwipeMenuLayout mHostView) {
        super(mHostView);
        Intrinsics.checkNotNullParameter(mHostView, "mHostView");
        this.f3367a = mHostView;
        this.f3368b = new SparseArray();
    }

    public final String a(int i8) {
        OSSwipeMenuLayout oSSwipeMenuLayout = this.f3367a;
        l menuView = oSSwipeMenuLayout.getSwipeCurrentHorizontal().getMenuView();
        l menuView2 = oSSwipeMenuLayout.getSwipeCurrentHorizontal().getMenuView();
        Intrinsics.checkNotNullExpressionValue(menuView2, "mHostView.swipeCurrentHorizontal.menuView");
        int i9 = i8 - 1;
        if (i9 >= 0 && i9 < menuView2.getMenuItems().size()) {
            menuView.getMenuItems().get(i9).getClass();
            throw new ClassCastException();
        }
        String string = oSSwipeMenuLayout.getContext().getString(R$string.os_string_talkback_untagged);
        Intrinsics.checkNotNullExpressionValue(string, "mHostView.context.getStr…string_talkback_untagged)");
        return string;
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper
    public final int getVirtualViewAt(float f, float f4) {
        MotionEvent motionEventObtain = MotionEvent.obtain(0L, 0L, 0, f, f4, 0);
        OSSwipeMenuLayout oSSwipeMenuLayout = this.f3367a;
        a aVar = oSSwipeMenuLayout.f3362w;
        int measuredWidth = oSSwipeMenuLayout.getMeasuredWidth();
        oSSwipeMenuLayout.getMeasuredHeight();
        int iF = aVar.f(measuredWidth, motionEventObtain, oSSwipeMenuLayout.E);
        boolean z2 = iF > -1;
        int i8 = iF + 1;
        if (!z2) {
            i8 = Integer.MIN_VALUE;
        }
        z8.f("SwipeMenuExploreByTouch", "getVirtualViewIdForHit(" + f + "," + f4 + ") => " + i8 + " avail =" + z2);
        return i8;
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper
    public final void getVisibleVirtualViews(List virtualViewIds) {
        Intrinsics.checkNotNullParameter(virtualViewIds, "virtualViewIds");
        OSSwipeMenuLayout oSSwipeMenuLayout = this.f3367a;
        a swipeCurrentHorizontal = oSSwipeMenuLayout.getSwipeCurrentHorizontal();
        int size = virtualViewIds.size();
        boolean zG = swipeCurrentHorizontal.g(oSSwipeMenuLayout.getScrollX());
        SparseArray sparseArray = this.f3368b;
        z8.f("SwipeMenuExploreByTouch", "getVisibleVirtualViews(len=" + size + ") mHorizontal.isMenuOpen(mHostView.getScrollX()) = " + zG + " mItems.size() = " + sparseArray.size());
        int size2 = sparseArray.size() + 1;
        for (int i8 = 1; i8 < size2; i8++) {
            virtualViewIds.add(Integer.valueOf(i8));
        }
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper
    public final boolean onPerformActionForVirtualView(int i8, int i9, Bundle bundle) {
        z8.f("SwipeMenuExploreByTouch", "onPerformActionForVirtualView(id=" + i8 + ", action=" + i9);
        if (i9 != 16) {
            z8.f("SwipeMenuExploreByTouch", d.g(i8, i9, "*** action not handled in onPerformActionForVirtualView(viewId=", "action=", ")"));
            return false;
        }
        z8.f("SwipeMenuExploreByTouch", "onItemClicked(" + i8 + ")");
        OSSwipeMenuLayout oSSwipeMenuLayout = this.f3367a;
        oSSwipeMenuLayout.getSwipeCurrentHorizontal().getMenuView();
        invalidateVirtualView(i8);
        oSSwipeMenuLayout.getOnMenuItemClickListener();
        sendEventForVirtualView(i8, 1);
        return true;
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper
    public final void onPopulateEventForVirtualView(int i8, AccessibilityEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        z8.f("SwipeMenuExploreByTouch", "onPopulateEventForVirtualView(" + i8 + ")");
        n nVar = (n) this.f3368b.get(i8);
        if (nVar != null) {
            event.getText().add(nVar.getDescription());
        }
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper
    public final void onPopulateNodeForVirtualView(int i8, AccessibilityNodeInfoCompat node) {
        Rect bounds;
        Intrinsics.checkNotNullParameter(node, "node");
        z8.f("SwipeMenuExploreByTouch", "onPopulateNodeForVirtualView(view=" + i8 + ") mItems.size() = " + this.f3368b.size());
        node.setText(a(i8));
        node.setContentDescription(a(i8));
        node.setFocusable(true);
        node.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
        node.setClickable(false);
        OSSwipeMenuLayout oSSwipeMenuLayout = this.f3367a;
        a swipeCurrentHorizontal = oSSwipeMenuLayout.getSwipeCurrentHorizontal();
        l menuView = oSSwipeMenuLayout.getSwipeCurrentHorizontal().getMenuView();
        Math.signum(oSSwipeMenuLayout.getScrollX());
        if (Math.abs(Math.abs(oSSwipeMenuLayout.getScrollX()) - menuView.getMenuTotalWidth()) > 2) {
            bounds = f3366c;
        } else {
            menuView.getMenuTotalWidth();
            oSSwipeMenuLayout.getMeasuredWidth();
            oSSwipeMenuLayout.getMeasuredHeight();
            bounds = swipeCurrentHorizontal.e(menuView.f11160d);
            z8.f("SwipeMenuExploreByTouch", "getBoundsForVirtualView = " + bounds.toShortString());
            Intrinsics.checkNotNullExpressionValue(bounds, "bounds");
        }
        z8.f("SwipeMenuExploreByTouch", "bounds:" + bounds);
        node.setBoundsInParent(bounds);
    }
}
