package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class ChildHelper {
    private static final boolean DEBUG = false;
    private static final String TAG = "ChildrenHelper";
    final Callback mCallback;
    final Bucket mBucket = new Bucket();
    final List<View> mHiddenViews = new ArrayList();

    public static class Bucket {
        static final int BITS_PER_WORD = 64;
        static final long LAST_BIT = Long.MIN_VALUE;
        long mData = 0;
        Bucket mNext;

        private void ensureNext() {
            if (this.mNext == null) {
                this.mNext = new Bucket();
            }
        }

        public void clear(int i8) {
            if (i8 < 64) {
                this.mData &= ~(1 << i8);
                return;
            }
            Bucket bucket = this.mNext;
            if (bucket != null) {
                bucket.clear(i8 - 64);
            }
        }

        public int countOnesBefore(int i8) {
            Bucket bucket = this.mNext;
            if (bucket == null) {
                if (i8 >= 64) {
                    return Long.bitCount(this.mData);
                }
                return Long.bitCount(((1 << i8) - 1) & this.mData);
            }
            if (i8 < 64) {
                return Long.bitCount(((1 << i8) - 1) & this.mData);
            }
            return Long.bitCount(this.mData) + bucket.countOnesBefore(i8 - 64);
        }

        public boolean get(int i8) {
            if (i8 < 64) {
                return ((1 << i8) & this.mData) != 0;
            }
            ensureNext();
            return this.mNext.get(i8 - 64);
        }

        public void insert(int i8, boolean z2) {
            if (i8 >= 64) {
                ensureNext();
                this.mNext.insert(i8 - 64, z2);
                return;
            }
            long j8 = this.mData;
            boolean z3 = (Long.MIN_VALUE & j8) != 0;
            long j10 = (1 << i8) - 1;
            this.mData = ((j8 & (~j10)) << 1) | (j8 & j10);
            if (z2) {
                set(i8);
            } else {
                clear(i8);
            }
            if (z3 || this.mNext != null) {
                ensureNext();
                this.mNext.insert(0, z3);
            }
        }

        public boolean remove(int i8) {
            if (i8 >= 64) {
                ensureNext();
                return this.mNext.remove(i8 - 64);
            }
            long j8 = 1 << i8;
            long j10 = this.mData;
            boolean z2 = (j10 & j8) != 0;
            long j11 = j10 & (~j8);
            this.mData = j11;
            long j12 = j8 - 1;
            this.mData = (j11 & j12) | Long.rotateRight((~j12) & j11, 1);
            Bucket bucket = this.mNext;
            if (bucket != null) {
                if (bucket.get(0)) {
                    set(63);
                }
                this.mNext.remove(0);
            }
            return z2;
        }

        public void reset() {
            this.mData = 0L;
            Bucket bucket = this.mNext;
            if (bucket != null) {
                bucket.reset();
            }
        }

        public void set(int i8) {
            if (i8 < 64) {
                this.mData |= 1 << i8;
            } else {
                ensureNext();
                this.mNext.set(i8 - 64);
            }
        }

        public String toString() {
            if (this.mNext == null) {
                return Long.toBinaryString(this.mData);
            }
            return this.mNext.toString() + "xx" + Long.toBinaryString(this.mData);
        }
    }

    public interface Callback {
        void addView(View view, int i8);

        void attachViewToParent(View view, int i8, ViewGroup.LayoutParams layoutParams);

        void detachViewFromParent(int i8);

        View getChildAt(int i8);

        int getChildCount();

        RecyclerView.ViewHolder getChildViewHolder(View view);

        int indexOfChild(View view);

        void onEnteredHiddenState(View view);

        void onLeftHiddenState(View view);

        void removeAllViews();

        void removeViewAt(int i8);
    }

    public ChildHelper(Callback callback) {
        this.mCallback = callback;
    }

    private int getOffset(int i8) {
        if (i8 < 0) {
            return -1;
        }
        int childCount = this.mCallback.getChildCount();
        int i9 = i8;
        while (i9 < childCount) {
            int iCountOnesBefore = i8 - (i9 - this.mBucket.countOnesBefore(i9));
            if (iCountOnesBefore == 0) {
                while (this.mBucket.get(i9)) {
                    i9++;
                }
                return i9;
            }
            i9 += iCountOnesBefore;
        }
        return -1;
    }

    private void hideViewInternal(View view) {
        this.mHiddenViews.add(view);
        this.mCallback.onEnteredHiddenState(view);
    }

    private boolean unhideViewInternal(View view) {
        if (!this.mHiddenViews.remove(view)) {
            return false;
        }
        this.mCallback.onLeftHiddenState(view);
        return true;
    }

    public void addView(View view, boolean z2) {
        addView(view, -1, z2);
    }

    public void attachViewToParent(View view, int i8, ViewGroup.LayoutParams layoutParams, boolean z2) {
        int childCount = i8 < 0 ? this.mCallback.getChildCount() : getOffset(i8);
        this.mBucket.insert(childCount, z2);
        if (z2) {
            hideViewInternal(view);
        }
        this.mCallback.attachViewToParent(view, childCount, layoutParams);
    }

    public void detachViewFromParent(int i8) {
        int offset = getOffset(i8);
        this.mBucket.remove(offset);
        this.mCallback.detachViewFromParent(offset);
    }

    public View findHiddenNonRemovedView(int i8) {
        int size = this.mHiddenViews.size();
        for (int i9 = 0; i9 < size; i9++) {
            View view = this.mHiddenViews.get(i9);
            RecyclerView.ViewHolder childViewHolder = this.mCallback.getChildViewHolder(view);
            if (childViewHolder.getLayoutPosition() == i8 && !childViewHolder.isInvalid() && !childViewHolder.isRemoved()) {
                return view;
            }
        }
        return null;
    }

    public View getChildAt(int i8) {
        return this.mCallback.getChildAt(getOffset(i8));
    }

    public int getChildCount() {
        return this.mCallback.getChildCount() - this.mHiddenViews.size();
    }

    public View getUnfilteredChildAt(int i8) {
        return this.mCallback.getChildAt(i8);
    }

    public int getUnfilteredChildCount() {
        return this.mCallback.getChildCount();
    }

    public void hide(View view) {
        int iIndexOfChild = this.mCallback.indexOfChild(view);
        if (iIndexOfChild >= 0) {
            this.mBucket.set(iIndexOfChild);
            hideViewInternal(view);
        } else {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
    }

    public int indexOfChild(View view) {
        int iIndexOfChild = this.mCallback.indexOfChild(view);
        if (iIndexOfChild == -1 || this.mBucket.get(iIndexOfChild)) {
            return -1;
        }
        return iIndexOfChild - this.mBucket.countOnesBefore(iIndexOfChild);
    }

    public boolean isHidden(View view) {
        return this.mHiddenViews.contains(view);
    }

    public void removeAllViewsUnfiltered() {
        this.mBucket.reset();
        for (int size = this.mHiddenViews.size() - 1; size >= 0; size--) {
            this.mCallback.onLeftHiddenState(this.mHiddenViews.get(size));
            this.mHiddenViews.remove(size);
        }
        this.mCallback.removeAllViews();
    }

    public void removeView(View view) {
        int iIndexOfChild = this.mCallback.indexOfChild(view);
        if (iIndexOfChild < 0) {
            return;
        }
        if (this.mBucket.remove(iIndexOfChild)) {
            unhideViewInternal(view);
        }
        this.mCallback.removeViewAt(iIndexOfChild);
    }

    public void removeViewAt(int i8) {
        int offset = getOffset(i8);
        View childAt = this.mCallback.getChildAt(offset);
        if (childAt == null) {
            return;
        }
        if (this.mBucket.remove(offset)) {
            unhideViewInternal(childAt);
        }
        this.mCallback.removeViewAt(offset);
    }

    public boolean removeViewIfHidden(View view) {
        int iIndexOfChild = this.mCallback.indexOfChild(view);
        if (iIndexOfChild == -1) {
            unhideViewInternal(view);
            return true;
        }
        if (!this.mBucket.get(iIndexOfChild)) {
            return false;
        }
        this.mBucket.remove(iIndexOfChild);
        unhideViewInternal(view);
        this.mCallback.removeViewAt(iIndexOfChild);
        return true;
    }

    public String toString() {
        return this.mBucket.toString() + ", hidden list:" + this.mHiddenViews.size();
    }

    public void unhide(View view) {
        int iIndexOfChild = this.mCallback.indexOfChild(view);
        if (iIndexOfChild < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        if (this.mBucket.get(iIndexOfChild)) {
            this.mBucket.clear(iIndexOfChild);
            unhideViewInternal(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    public void addView(View view, int i8, boolean z2) {
        int childCount = i8 < 0 ? this.mCallback.getChildCount() : getOffset(i8);
        this.mBucket.insert(childCount, z2);
        if (z2) {
            hideViewInternal(view);
        }
        this.mCallback.addView(view, childCount);
    }
}
