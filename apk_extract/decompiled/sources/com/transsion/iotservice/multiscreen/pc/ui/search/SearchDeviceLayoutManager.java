package com.transsion.iotservice.multiscreen.pc.ui.search;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import java.util.HashSet;
import java.util.Iterator;
import k3.sb;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/ui/search/SearchDeviceLayoutManager;", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "<init>", "()V", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class SearchDeviceLayoutManager extends RecyclerView.LayoutManager {
    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean canScrollHorizontally() {
        if (sb.b()) {
            return getItemCount() > 2;
        }
        return getItemCount() > 3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean isAutoMeasureEnabled() {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        Intrinsics.checkNotNullParameter(recycler, "recycler");
        Intrinsics.checkNotNullParameter(state, "state");
        detachAndScrapAttachedViews(recycler);
        int itemCount = getItemCount();
        if (itemCount == 0) {
            return;
        }
        int width = getWidth();
        int width2 = getWidth() - getPaddingRight();
        int i15 = 0;
        while (width2 > 0 && i15 < itemCount) {
            View viewForPosition = recycler.getViewForPosition(i15);
            Intrinsics.checkNotNullExpressionValue(viewForPosition, "getViewForPosition(...)");
            addView(viewForPosition);
            measureChildWithMargins(viewForPosition, 0, 0);
            int decoratedMeasuredWidth = getDecoratedMeasuredWidth(viewForPosition);
            int decoratedMeasuredHeight = getDecoratedMeasuredHeight(viewForPosition);
            if (sb.b()) {
                if (itemCount == 1) {
                    i8 = (width - decoratedMeasuredWidth) / 2;
                } else if (itemCount != 2) {
                    i13 = (width / 2) * i15;
                    i14 = (i15 * decoratedMeasuredWidth) / 4;
                    i8 = i13 - i14;
                } else if (i15 == 0) {
                    i11 = width / 4;
                    i12 = decoratedMeasuredWidth / 2;
                    i8 = (i11 - i12) + 30;
                } else {
                    i9 = (width * 3) / 4;
                    i10 = decoratedMeasuredWidth / 2;
                    i8 = (i9 - i10) - 30;
                }
            } else if (itemCount == 1) {
                i8 = (width - decoratedMeasuredWidth) / 2;
            } else if (itemCount != 2) {
                if (itemCount != 3) {
                    i13 = (width / 3) * i15;
                    i14 = (i15 * decoratedMeasuredWidth) / 6;
                    i8 = i13 - i14;
                } else if (i15 == 0) {
                    i11 = width / 6;
                    i12 = decoratedMeasuredWidth / 2;
                    i8 = (i11 - i12) + 30;
                } else if (i15 == 1) {
                    i8 = (width - decoratedMeasuredWidth) / 2;
                } else {
                    i9 = (width * 5) / 6;
                    i10 = decoratedMeasuredWidth / 2;
                    i8 = (i9 - i10) - 30;
                }
            } else if (i15 == 0) {
                i11 = width / 4;
                i12 = decoratedMeasuredWidth / 2;
                i8 = (i11 - i12) + 30;
            } else {
                i9 = (width * 3) / 4;
                i10 = decoratedMeasuredWidth / 2;
                i8 = (i9 - i10) - 30;
            }
            int i16 = i8;
            layoutDecorated(viewForPosition, i16, 0, i16 + decoratedMeasuredWidth, decoratedMeasuredHeight);
            i15++;
            width2 -= decoratedMeasuredWidth;
        }
        if (sb.b() || itemCount <= 3) {
            return;
        }
        scrollHorizontallyBy(1, recycler, state);
    }

    /* JADX WARN: Code duplicated, block: B:48:0x0108  */
    /* JADX WARN: Code duplicated, block: B:50:0x010e  */
    /* JADX WARN: Code duplicated, block: B:52:0x011b A[LOOP:0: B:49:0x010c->B:52:0x011b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:54:0x0123  */
    /* JADX WARN: Code duplicated, block: B:56:0x012a  */
    /* JADX WARN: Code duplicated, block: B:58:0x013b A[LOOP:1: B:55:0x0128->B:58:0x013b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:62:0x0150 A[LOOP:2: B:60:0x014a->B:62:0x0150, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:66:0x0121 A[EDGE_INSN: B:66:0x0121->B:53:0x0121 BREAK  A[LOOP:0: B:49:0x010c->B:52:0x011b], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:68:0x0141 A[EDGE_INSN: B:68:0x0141->B:59:0x0141 BREAK  A[LOOP:1: B:55:0x0128->B:58:0x013b], SYNTHETIC] */
    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int scrollHorizontallyBy(int i8, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int decoratedLeft;
        int decoratedRight;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int width;
        HashSet hashSet;
        Iterator it;
        int childCount;
        View childAt;
        int childCount2;
        View childAt2;
        Intrinsics.checkNotNullParameter(recycler, "recycler");
        Intrinsics.checkNotNullParameter(state, "state");
        int iAbs = Math.abs(i8);
        int iAbs2 = Math.abs(i8);
        if (i8 > 0) {
            View childAt3 = getChildAt(getChildCount() - 1);
            Intrinsics.checkNotNull(childAt3);
            View childAt4 = getChildAt(getChildCount() - 2);
            Intrinsics.checkNotNull(childAt4);
            int position = getPosition(childAt3);
            decoratedRight = getDecoratedRight(childAt3);
            decoratedLeft = getDecoratedLeft(childAt3) - getDecoratedRight(childAt4);
            i9 = position + 1;
            if (i9 >= getItemCount() && decoratedRight - iAbs2 < getWidth()) {
                width = decoratedRight - getWidth();
            } else if (decoratedRight - iAbs2 > getWidth()) {
                width = i8;
            }
            offsetChildrenHorizontal(-width);
            hashSet = new HashSet();
            if (i8 > 0) {
                childCount2 = getChildCount();
                for (int i15 = 0; i15 < childCount2; i15++) {
                    childAt2 = getChildAt(i15);
                    Intrinsics.checkNotNull(childAt2);
                    if (getDecoratedRight(childAt2) > 0) {
                        break;
                    }
                    hashSet.add(childAt2);
                }
            }
            if (i8 < 0) {
                for (childCount = getChildCount() - 1; -1 < childCount; childCount--) {
                    childAt = getChildAt(childCount);
                    Intrinsics.checkNotNull(childAt);
                    if (getDecoratedLeft(childAt) < getWidth()) {
                        break;
                    }
                    hashSet.add(childAt);
                }
            }
            it = hashSet.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                Object next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                removeAndRecycleView((View) next, recycler);
            }
            hashSet.clear();
            return width;
        }
        decoratedLeft = 0;
        decoratedRight = 0;
        i9 = -1;
        if (i8 < 0) {
            View childAt5 = getChildAt(0);
            Intrinsics.checkNotNull(childAt5);
            View childAt6 = getChildAt(1);
            Intrinsics.checkNotNull(childAt6);
            int position2 = getPosition(childAt5);
            int decoratedLeft2 = getDecoratedLeft(childAt5);
            int decoratedLeft3 = getDecoratedLeft(childAt6) - getDecoratedRight(childAt5);
            int i16 = position2 - 1;
            if (i16 >= 0 || decoratedLeft2 + iAbs2 <= 0) {
                if (iAbs2 + decoratedLeft2 >= 0) {
                    i10 = decoratedLeft3;
                    i11 = i16;
                    i12 = decoratedLeft2;
                }
                width = i8;
            } else {
                width = decoratedLeft2;
            }
            offsetChildrenHorizontal(-width);
            hashSet = new HashSet();
            if (i8 > 0) {
                childCount2 = getChildCount();
                while (i15 < childCount2) {
                    childAt2 = getChildAt(i15);
                    Intrinsics.checkNotNull(childAt2);
                    if (getDecoratedRight(childAt2) > 0) {
                        break;
                        break;
                    }
                    hashSet.add(childAt2);
                }
            }
            if (i8 < 0) {
                while (-1 < childCount) {
                    childAt = getChildAt(childCount);
                    Intrinsics.checkNotNull(childAt);
                    if (getDecoratedLeft(childAt) < getWidth()) {
                        break;
                        break;
                    }
                    hashSet.add(childAt);
                }
            }
            it = hashSet.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                Object next2 = it.next();
                Intrinsics.checkNotNullExpressionValue(next2, "next(...)");
                removeAndRecycleView((View) next2, recycler);
            }
            hashSet.clear();
            return width;
        }
        i10 = decoratedLeft;
        i11 = i9;
        i12 = 0;
        while (iAbs > 0 && i11 >= 0 && i11 < getItemCount()) {
            View viewForPosition = recycler.getViewForPosition(i11);
            Intrinsics.checkNotNullExpressionValue(viewForPosition, "getViewForPosition(...)");
            if (i8 > 0) {
                addView(viewForPosition);
            } else {
                addView(viewForPosition, 0);
            }
            measureChildWithMargins(viewForPosition, 0, 0);
            int decoratedMeasuredWidth = getDecoratedMeasuredWidth(viewForPosition);
            if (i8 > 0) {
                i14 = decoratedRight + i10;
                i13 = i14 + decoratedMeasuredWidth;
            } else {
                i13 = i12 - i10;
                i14 = i13 - decoratedMeasuredWidth;
            }
            int i17 = i13;
            int i18 = i14;
            layoutDecorated(viewForPosition, i18, 0, i17, getDecoratedMeasuredHeight(viewForPosition));
            if (i8 > 0) {
                i18 += decoratedMeasuredWidth;
                i11++;
            } else {
                i17 -= decoratedMeasuredWidth;
                i11--;
            }
            i12 = i17;
            decoratedRight = i18;
            if (i11 >= 0 && i11 < getItemCount()) {
                iAbs -= decoratedMeasuredWidth;
            }
        }
        width = i8;
        offsetChildrenHorizontal(-width);
        hashSet = new HashSet();
        if (i8 > 0) {
            childCount2 = getChildCount();
            while (i15 < childCount2) {
                childAt2 = getChildAt(i15);
                Intrinsics.checkNotNull(childAt2);
                if (getDecoratedRight(childAt2) > 0) {
                    break;
                    break;
                }
                hashSet.add(childAt2);
            }
        }
        if (i8 < 0) {
            while (-1 < childCount) {
                childAt = getChildAt(childCount);
                Intrinsics.checkNotNull(childAt);
                if (getDecoratedLeft(childAt) < getWidth()) {
                    break;
                    break;
                }
                hashSet.add(childAt);
            }
        }
        it = hashSet.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            Object next3 = it.next();
            Intrinsics.checkNotNullExpressionValue(next3, "next(...)");
            removeAndRecycleView((View) next3, recycler);
        }
        hashSet.clear();
        return width;
    }
}
