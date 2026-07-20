package qd;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.ScrollView;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import com.transsion.widgetslib.view.OverBoundNestedScrollView;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends AccessibilityDelegateCompat {
    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
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
    public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
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
    public final boolean performAccessibilityAction(View view, int i8, Bundle bundle) {
        if (super.performAccessibilityAction(view, i8, bundle)) {
            return true;
        }
        OverBoundNestedScrollView overBoundNestedScrollView = (OverBoundNestedScrollView) view;
        if (!overBoundNestedScrollView.isEnabled()) {
            return false;
        }
        if (i8 != 4096) {
            if (i8 == 8192 || i8 == 16908344) {
                int iMax = Math.max(overBoundNestedScrollView.getScrollY() - ((overBoundNestedScrollView.getHeight() - overBoundNestedScrollView.getPaddingBottom()) - overBoundNestedScrollView.getPaddingTop()), 0);
                if (iMax == overBoundNestedScrollView.getScrollY()) {
                    return false;
                }
                overBoundNestedScrollView.smoothScrollTo(0, iMax, true);
                return true;
            }
            if (i8 != 16908346) {
                return false;
            }
        }
        int iMin = Math.min(overBoundNestedScrollView.getScrollY() + ((overBoundNestedScrollView.getHeight() - overBoundNestedScrollView.getPaddingBottom()) - overBoundNestedScrollView.getPaddingTop()), overBoundNestedScrollView.getScrollRange());
        if (iMin == overBoundNestedScrollView.getScrollY()) {
            return false;
        }
        overBoundNestedScrollView.smoothScrollTo(0, iMin, true);
        return true;
    }
}
