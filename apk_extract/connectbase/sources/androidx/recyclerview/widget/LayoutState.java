package androidx.recyclerview.widget;

import android.view.View;
import rs.f;
import u.a;

/* JADX INFO: loaded from: classes.dex */
class LayoutState {
    static final int INVALID_LAYOUT = Integer.MIN_VALUE;
    static final int ITEM_DIRECTION_HEAD = -1;
    static final int ITEM_DIRECTION_TAIL = 1;
    static final int LAYOUT_END = 1;
    static final int LAYOUT_START = -1;
    int mAvailable;
    int mCurrentPosition;
    boolean mInfinite;
    int mItemDirection;
    int mLayoutDirection;
    boolean mStopInFocusable;
    boolean mRecycle = true;
    int mStartLine = 0;
    int mEndLine = 0;

    public boolean hasMore(RecyclerView.State state) {
        int i10 = this.mCurrentPosition;
        return i10 >= 0 && i10 < state.getItemCount();
    }

    public View next(RecyclerView.Recycler recycler) {
        View viewForPosition = recycler.getViewForPosition(this.mCurrentPosition);
        this.mCurrentPosition += this.mItemDirection;
        return viewForPosition;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("LayoutState{mAvailable=");
        sb2.append(this.mAvailable);
        sb2.append(", mCurrentPosition=");
        sb2.append(this.mCurrentPosition);
        sb2.append(", mItemDirection=");
        sb2.append(this.mItemDirection);
        sb2.append(", mLayoutDirection=");
        sb2.append(this.mLayoutDirection);
        sb2.append(", mStartLine=");
        sb2.append(this.mStartLine);
        sb2.append(", mEndLine=");
        return a.a(sb2, this.mEndLine, f.f14860b);
    }
}
