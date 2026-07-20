package com.github.rubensousa.gravitysnaphelper;

import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.core.text.TextUtilsCompat;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Locale;
import z1.a;
import z1.b;

/* JADX INFO: loaded from: classes.dex */
public class GravitySnapHelper extends LinearSnapHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1759b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f1760c;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public OrientationHelper f1763h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public OrientationHelper f1764i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public RecyclerView f1765j;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f1761d = false;
    public float e = 100.0f;
    public int f = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f1762g = -1.0f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final a f1766k = new a(this);

    public GravitySnapHelper(int i8) {
        if (i8 != 8388611 && i8 != 8388613 && i8 != 80 && i8 != 48 && i8 != 17) {
            throw new IllegalArgumentException("Invalid gravity value. Use START | END | BOTTOM | TOP | CENTER constants");
        }
        this.f1760c = false;
        this.f1758a = i8;
    }

    public final View a(RecyclerView.LayoutManager layoutManager, boolean z2) {
        View viewB;
        int i8 = this.f1758a;
        if (i8 == 17) {
            viewB = layoutManager.canScrollHorizontally() ? b(layoutManager, getHorizontalHelper(layoutManager), 17, z2) : b(layoutManager, getVerticalHelper(layoutManager), 17, z2);
        } else if (i8 == 48) {
            viewB = b(layoutManager, getVerticalHelper(layoutManager), GravityCompat.START, z2);
        } else if (i8 == 80) {
            viewB = b(layoutManager, getVerticalHelper(layoutManager), GravityCompat.END, z2);
        } else if (i8 != 8388611) {
            viewB = i8 != 8388613 ? null : b(layoutManager, getHorizontalHelper(layoutManager), GravityCompat.END, z2);
        } else {
            viewB = b(layoutManager, getHorizontalHelper(layoutManager), GravityCompat.START, z2);
        }
        if (viewB != null) {
            this.f1765j.getChildAdapterPosition(viewB);
        }
        return viewB;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public final void attachToRecyclerView(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f1765j;
        a aVar = this.f1766k;
        if (recyclerView2 != null) {
            recyclerView2.removeOnScrollListener(aVar);
        }
        if (recyclerView != null) {
            recyclerView.setOnFlingListener(null);
            int i8 = this.f1758a;
            if (i8 == 8388611 || i8 == 8388613) {
                this.f1759b = TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
            }
            recyclerView.addOnScrollListener(aVar);
            this.f1765j = recyclerView;
        } else {
            this.f1765j = null;
        }
        super.attachToRecyclerView(recyclerView);
    }

    public final View b(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper, int i8, boolean z2) {
        int iAbs;
        View view = null;
        if (layoutManager.getChildCount() != 0 && (layoutManager instanceof LinearLayoutManager)) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            boolean z3 = true;
            if (z2 && ((linearLayoutManager.getReverseLayout() || this.f1758a != 8388611) && (!(linearLayoutManager.getReverseLayout() && this.f1758a == 8388613) && ((linearLayoutManager.getReverseLayout() || this.f1758a != 48) && !(linearLayoutManager.getReverseLayout() && this.f1758a == 80))) ? !(this.f1758a != 17 ? linearLayoutManager.findFirstCompletelyVisibleItemPosition() != 0 : !(linearLayoutManager.findFirstCompletelyVisibleItemPosition() == 0 || linearLayoutManager.findLastCompletelyVisibleItemPosition() == linearLayoutManager.getItemCount() - 1)) : linearLayoutManager.findLastCompletelyVisibleItemPosition() == linearLayoutManager.getItemCount() - 1) && !this.f1760c) {
                return null;
            }
            int totalSpace = layoutManager.getClipToPadding() ? (orientationHelper.getTotalSpace() / 2) + orientationHelper.getStartAfterPadding() : orientationHelper.getEnd() / 2;
            boolean z5 = (i8 == 8388611 && !this.f1759b) || (i8 == 8388613 && this.f1759b);
            if ((i8 != 8388611 || !this.f1759b) && (i8 != 8388613 || this.f1759b)) {
                z3 = false;
            }
            int i9 = Integer.MAX_VALUE;
            for (int i10 = 0; i10 < linearLayoutManager.getChildCount(); i10++) {
                View childAt = linearLayoutManager.getChildAt(i10);
                if (z5) {
                    iAbs = !this.f1761d ? Math.abs(orientationHelper.getDecoratedStart(childAt)) : Math.abs(orientationHelper.getStartAfterPadding() - orientationHelper.getDecoratedStart(childAt));
                } else if (z3) {
                    iAbs = !this.f1761d ? Math.abs(orientationHelper.getDecoratedEnd(childAt) - orientationHelper.getEnd()) : Math.abs(orientationHelper.getEndAfterPadding() - orientationHelper.getDecoratedEnd(childAt));
                } else {
                    iAbs = Math.abs(((orientationHelper.getDecoratedMeasurement(childAt) / 2) + orientationHelper.getDecoratedStart(childAt)) - totalSpace);
                }
                if (iAbs < i9) {
                    view = childAt;
                    i9 = iAbs;
                }
            }
        }
        return view;
    }

    public final int c(View view, OrientationHelper orientationHelper) {
        int decoratedEnd;
        int endAfterPadding;
        if (this.f1761d) {
            decoratedEnd = orientationHelper.getDecoratedEnd(view);
            endAfterPadding = orientationHelper.getEndAfterPadding();
        } else {
            decoratedEnd = orientationHelper.getDecoratedEnd(view);
            if (decoratedEnd >= orientationHelper.getEnd() - ((orientationHelper.getEnd() - orientationHelper.getEndAfterPadding()) / 2)) {
                decoratedEnd = orientationHelper.getDecoratedEnd(view);
                endAfterPadding = orientationHelper.getEnd();
            } else {
                endAfterPadding = orientationHelper.getEndAfterPadding();
            }
        }
        return decoratedEnd - endAfterPadding;
    }

    @Override // androidx.recyclerview.widget.LinearSnapHelper, androidx.recyclerview.widget.SnapHelper
    public final int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager layoutManager, View view) {
        if (this.f1758a == 17) {
            return super.calculateDistanceToFinalSnap(layoutManager, view);
        }
        int[] iArr = new int[2];
        if (!(layoutManager instanceof LinearLayoutManager)) {
            return iArr;
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        if (linearLayoutManager.canScrollHorizontally()) {
            boolean z2 = this.f1759b;
            if (!(z2 && this.f1758a == 8388613) && (z2 || this.f1758a != 8388611)) {
                iArr[0] = c(view, getHorizontalHelper(linearLayoutManager));
            } else {
                iArr[0] = d(view, getHorizontalHelper(linearLayoutManager));
            }
        } else if (linearLayoutManager.canScrollVertically()) {
            if (this.f1758a == 48) {
                iArr[1] = d(view, getVerticalHelper(linearLayoutManager));
            } else {
                iArr[1] = c(view, getVerticalHelper(linearLayoutManager));
            }
        }
        return iArr;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0052  */
    @Override // androidx.recyclerview.widget.SnapHelper
    public final int[] calculateScrollDistance(int i8, int i9) {
        int i10;
        int i11;
        float width;
        float f;
        if (this.f1765j == null || ((this.f1763h == null && this.f1764i == null) || (this.f == -1 && this.f1762g == -1.0f))) {
            return super.calculateScrollDistance(i8, i9);
        }
        Scroller scroller = new Scroller(this.f1765j.getContext(), new DecelerateInterpolator());
        if (this.f1762g != -1.0f) {
            if (this.f1763h != null) {
                width = this.f1765j.getHeight();
                f = this.f1762g;
            } else if (this.f1764i != null) {
                width = this.f1765j.getWidth();
                f = this.f1762g;
            } else {
                i11 = Integer.MAX_VALUE;
            }
            i10 = (int) (width * f);
            i11 = i10;
        } else {
            i10 = this.f;
            if (i10 != -1) {
                i11 = i10;
            } else {
                i11 = Integer.MAX_VALUE;
            }
        }
        int i12 = -i11;
        scroller.fling(0, 0, i8, i9, i12, i11, i12, i11);
        return new int[]{scroller.getFinalX(), scroller.getFinalY()};
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public final RecyclerView.SmoothScroller createScroller(RecyclerView.LayoutManager layoutManager) {
        RecyclerView recyclerView;
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) || (recyclerView = this.f1765j) == null) {
            return null;
        }
        return new b(this, recyclerView.getContext());
    }

    public final int d(View view, OrientationHelper orientationHelper) {
        int decoratedStart;
        int startAfterPadding;
        if (this.f1761d) {
            decoratedStart = orientationHelper.getDecoratedStart(view);
            startAfterPadding = orientationHelper.getStartAfterPadding();
        } else {
            decoratedStart = orientationHelper.getDecoratedStart(view);
            if (decoratedStart < orientationHelper.getStartAfterPadding() / 2) {
                return decoratedStart;
            }
            startAfterPadding = orientationHelper.getStartAfterPadding();
        }
        return decoratedStart - startAfterPadding;
    }

    public final boolean e(int i8, boolean z2) {
        if (this.f1765j.getLayoutManager() != null) {
            if (z2) {
                RecyclerView.SmoothScroller smoothScrollerCreateScroller = createScroller(this.f1765j.getLayoutManager());
                if (smoothScrollerCreateScroller != null) {
                    smoothScrollerCreateScroller.setTargetPosition(i8);
                    this.f1765j.getLayoutManager().startSmoothScroll(smoothScrollerCreateScroller);
                    return true;
                }
            } else {
                RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = this.f1765j.findViewHolderForAdapterPosition(i8);
                if (viewHolderFindViewHolderForAdapterPosition != null) {
                    int[] iArrCalculateDistanceToFinalSnap = calculateDistanceToFinalSnap(this.f1765j.getLayoutManager(), viewHolderFindViewHolderForAdapterPosition.itemView);
                    this.f1765j.scrollBy(iArrCalculateDistanceToFinalSnap[0], iArrCalculateDistanceToFinalSnap[1]);
                    return true;
                }
            }
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.LinearSnapHelper, androidx.recyclerview.widget.SnapHelper
    public final View findSnapView(RecyclerView.LayoutManager layoutManager) {
        return a(layoutManager, true);
    }

    public final OrientationHelper getHorizontalHelper(RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.f1764i;
        if (orientationHelper == null || orientationHelper.getLayoutManager() != layoutManager) {
            this.f1764i = OrientationHelper.createHorizontalHelper(layoutManager);
        }
        return this.f1764i;
    }

    public final OrientationHelper getVerticalHelper(RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.f1763h;
        if (orientationHelper == null || orientationHelper.getLayoutManager() != layoutManager) {
            this.f1763h = OrientationHelper.createVerticalHelper(layoutManager);
        }
        return this.f1763h;
    }
}
