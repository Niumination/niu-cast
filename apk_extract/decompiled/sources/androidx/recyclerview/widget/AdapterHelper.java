package androidx.recyclerview.widget;

import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class AdapterHelper implements OpReorderer.Callback {
    private static final boolean DEBUG = false;
    static final int POSITION_TYPE_INVISIBLE = 0;
    static final int POSITION_TYPE_NEW_OR_LAID_OUT = 1;
    private static final String TAG = "AHT";
    final Callback mCallback;
    final boolean mDisableRecycler;
    private int mExistingUpdateTypes;
    Runnable mOnItemProcessedCallback;
    final OpReorderer mOpReorderer;
    final ArrayList<UpdateOp> mPendingUpdates;
    final ArrayList<UpdateOp> mPostponedList;
    private Pools.Pool<UpdateOp> mUpdateOpPool;

    public interface Callback {
        RecyclerView.ViewHolder findViewHolder(int i8);

        void markViewHoldersUpdated(int i8, int i9, Object obj);

        void offsetPositionsForAdd(int i8, int i9);

        void offsetPositionsForMove(int i8, int i9);

        void offsetPositionsForRemovingInvisible(int i8, int i9);

        void offsetPositionsForRemovingLaidOutOrNewView(int i8, int i9);

        void onDispatchFirstPass(UpdateOp updateOp);

        void onDispatchSecondPass(UpdateOp updateOp);
    }

    public static class UpdateOp {
        static final int ADD = 1;
        static final int MOVE = 8;
        static final int POOL_SIZE = 30;
        static final int REMOVE = 2;
        static final int UPDATE = 4;
        int cmd;
        int itemCount;
        Object payload;
        int positionStart;

        public UpdateOp(int i8, int i9, int i10, Object obj) {
            this.cmd = i8;
            this.positionStart = i9;
            this.itemCount = i10;
            this.payload = obj;
        }

        public String cmdToString() {
            int i8 = this.cmd;
            if (i8 == 1) {
                return "add";
            }
            if (i8 == 2) {
                return "rm";
            }
            if (i8 != 4) {
                return i8 != 8 ? "??" : "mv";
            }
            return "up";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            UpdateOp updateOp = (UpdateOp) obj;
            int i8 = this.cmd;
            if (i8 != updateOp.cmd) {
                return false;
            }
            if (i8 == 8 && Math.abs(this.itemCount - this.positionStart) == 1 && this.itemCount == updateOp.positionStart && this.positionStart == updateOp.itemCount) {
                return true;
            }
            if (this.itemCount != updateOp.itemCount || this.positionStart != updateOp.positionStart) {
                return false;
            }
            Object obj2 = this.payload;
            if (obj2 != null) {
                if (!obj2.equals(updateOp.payload)) {
                    return false;
                }
            } else if (updateOp.payload != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.cmd * 31) + this.positionStart) * 31) + this.itemCount;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + cmdToString() + ",s:" + this.positionStart + "c:" + this.itemCount + ",p:" + this.payload + "]";
        }
    }

    public AdapterHelper(Callback callback) {
        this(callback, false);
    }

    private void applyAdd(UpdateOp updateOp) {
        postponeAndUpdateViewHolders(updateOp);
    }

    private void applyMove(UpdateOp updateOp) {
        postponeAndUpdateViewHolders(updateOp);
    }

    private void applyRemove(UpdateOp updateOp) {
        boolean z2;
        byte b9;
        int i8 = updateOp.positionStart;
        int i9 = updateOp.itemCount + i8;
        byte b10 = -1;
        int i10 = i8;
        int i11 = 0;
        while (i10 < i9) {
            if (this.mCallback.findViewHolder(i10) != null || canFindInPreLayout(i10)) {
                if (b10 == 0) {
                    dispatchAndUpdateViewHolders(obtainUpdateOp(2, i8, i11, null));
                    z2 = true;
                } else {
                    z2 = false;
                }
                b9 = 1;
            } else {
                if (b10 == 1) {
                    postponeAndUpdateViewHolders(obtainUpdateOp(2, i8, i11, null));
                    z2 = true;
                } else {
                    z2 = false;
                }
                b9 = 0;
            }
            if (z2) {
                i10 -= i11;
                i9 -= i11;
                i11 = 1;
            } else {
                i11++;
            }
            i10++;
            b10 = b9;
        }
        if (i11 != updateOp.itemCount) {
            recycleUpdateOp(updateOp);
            updateOp = obtainUpdateOp(2, i8, i11, null);
        }
        if (b10 == 0) {
            dispatchAndUpdateViewHolders(updateOp);
        } else {
            postponeAndUpdateViewHolders(updateOp);
        }
    }

    private void applyUpdate(UpdateOp updateOp) {
        int i8 = updateOp.positionStart;
        int i9 = updateOp.itemCount + i8;
        int i10 = 0;
        byte b9 = -1;
        int i11 = i8;
        while (i8 < i9) {
            if (this.mCallback.findViewHolder(i8) != null || canFindInPreLayout(i8)) {
                if (b9 == 0) {
                    dispatchAndUpdateViewHolders(obtainUpdateOp(4, i11, i10, updateOp.payload));
                    i11 = i8;
                    i10 = 0;
                }
                b9 = 1;
            } else {
                if (b9 == 1) {
                    postponeAndUpdateViewHolders(obtainUpdateOp(4, i11, i10, updateOp.payload));
                    i11 = i8;
                    i10 = 0;
                }
                b9 = 0;
            }
            i10++;
            i8++;
        }
        if (i10 != updateOp.itemCount) {
            Object obj = updateOp.payload;
            recycleUpdateOp(updateOp);
            updateOp = obtainUpdateOp(4, i11, i10, obj);
        }
        if (b9 == 0) {
            dispatchAndUpdateViewHolders(updateOp);
        } else {
            postponeAndUpdateViewHolders(updateOp);
        }
    }

    private boolean canFindInPreLayout(int i8) {
        int size = this.mPostponedList.size();
        for (int i9 = 0; i9 < size; i9++) {
            UpdateOp updateOp = this.mPostponedList.get(i9);
            int i10 = updateOp.cmd;
            if (i10 == 8) {
                if (findPositionOffset(updateOp.itemCount, i9 + 1) == i8) {
                    return true;
                }
            } else if (i10 == 1) {
                int i11 = updateOp.positionStart;
                int i12 = updateOp.itemCount + i11;
                while (i11 < i12) {
                    if (findPositionOffset(i11, i9 + 1) == i8) {
                        return true;
                    }
                    i11++;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    private void dispatchAndUpdateViewHolders(UpdateOp updateOp) {
        int i8;
        int i9 = updateOp.cmd;
        if (i9 == 1 || i9 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int iUpdatePositionWithPostponed = updatePositionWithPostponed(updateOp.positionStart, i9);
        int i10 = updateOp.positionStart;
        int i11 = updateOp.cmd;
        if (i11 == 2) {
            i8 = 0;
        } else {
            if (i11 != 4) {
                throw new IllegalArgumentException("op should be remove or update." + updateOp);
            }
            i8 = 1;
        }
        int i12 = 1;
        for (int i13 = 1; i13 < updateOp.itemCount; i13++) {
            int iUpdatePositionWithPostponed2 = updatePositionWithPostponed((i8 * i13) + updateOp.positionStart, updateOp.cmd);
            int i14 = updateOp.cmd;
            if (i14 == 2 ? iUpdatePositionWithPostponed2 != iUpdatePositionWithPostponed : !(i14 == 4 && iUpdatePositionWithPostponed2 == iUpdatePositionWithPostponed + 1)) {
                UpdateOp updateOpObtainUpdateOp = obtainUpdateOp(i14, iUpdatePositionWithPostponed, i12, updateOp.payload);
                dispatchFirstPassAndUpdateViewHolders(updateOpObtainUpdateOp, i10);
                recycleUpdateOp(updateOpObtainUpdateOp);
                if (updateOp.cmd == 4) {
                    i10 += i12;
                }
                i12 = 1;
                iUpdatePositionWithPostponed = iUpdatePositionWithPostponed2;
            } else {
                i12++;
            }
        }
        Object obj = updateOp.payload;
        recycleUpdateOp(updateOp);
        if (i12 > 0) {
            UpdateOp updateOpObtainUpdateOp2 = obtainUpdateOp(updateOp.cmd, iUpdatePositionWithPostponed, i12, obj);
            dispatchFirstPassAndUpdateViewHolders(updateOpObtainUpdateOp2, i10);
            recycleUpdateOp(updateOpObtainUpdateOp2);
        }
    }

    private void postponeAndUpdateViewHolders(UpdateOp updateOp) {
        this.mPostponedList.add(updateOp);
        int i8 = updateOp.cmd;
        if (i8 == 1) {
            this.mCallback.offsetPositionsForAdd(updateOp.positionStart, updateOp.itemCount);
            return;
        }
        if (i8 == 2) {
            this.mCallback.offsetPositionsForRemovingLaidOutOrNewView(updateOp.positionStart, updateOp.itemCount);
            return;
        }
        if (i8 == 4) {
            this.mCallback.markViewHoldersUpdated(updateOp.positionStart, updateOp.itemCount, updateOp.payload);
        } else if (i8 == 8) {
            this.mCallback.offsetPositionsForMove(updateOp.positionStart, updateOp.itemCount);
        } else {
            throw new IllegalArgumentException("Unknown update op type for " + updateOp);
        }
    }

    private int updatePositionWithPostponed(int i8, int i9) {
        int i10;
        int i11;
        for (int size = this.mPostponedList.size() - 1; size >= 0; size--) {
            UpdateOp updateOp = this.mPostponedList.get(size);
            int i12 = updateOp.cmd;
            if (i12 == 8) {
                int i13 = updateOp.positionStart;
                int i14 = updateOp.itemCount;
                if (i13 < i14) {
                    i11 = i13;
                    i10 = i14;
                } else {
                    i10 = i13;
                    i11 = i14;
                }
                if (i8 < i11 || i8 > i10) {
                    if (i8 < i13) {
                        if (i9 == 1) {
                            updateOp.positionStart = i13 + 1;
                            updateOp.itemCount = i14 + 1;
                        } else if (i9 == 2) {
                            updateOp.positionStart = i13 - 1;
                            updateOp.itemCount = i14 - 1;
                        }
                    }
                } else if (i11 == i13) {
                    if (i9 == 1) {
                        updateOp.itemCount = i14 + 1;
                    } else if (i9 == 2) {
                        updateOp.itemCount = i14 - 1;
                    }
                    i8++;
                } else {
                    if (i9 == 1) {
                        updateOp.positionStart = i13 + 1;
                    } else if (i9 == 2) {
                        updateOp.positionStart = i13 - 1;
                    }
                    i8--;
                }
            } else {
                int i15 = updateOp.positionStart;
                if (i15 <= i8) {
                    if (i12 == 1) {
                        i8 -= updateOp.itemCount;
                    } else if (i12 == 2) {
                        i8 += updateOp.itemCount;
                    }
                } else if (i9 == 1) {
                    updateOp.positionStart = i15 + 1;
                } else if (i9 == 2) {
                    updateOp.positionStart = i15 - 1;
                }
            }
        }
        for (int size2 = this.mPostponedList.size() - 1; size2 >= 0; size2--) {
            UpdateOp updateOp2 = this.mPostponedList.get(size2);
            if (updateOp2.cmd == 8) {
                int i16 = updateOp2.itemCount;
                if (i16 == updateOp2.positionStart || i16 < 0) {
                    this.mPostponedList.remove(size2);
                    recycleUpdateOp(updateOp2);
                }
            } else if (updateOp2.itemCount <= 0) {
                this.mPostponedList.remove(size2);
                recycleUpdateOp(updateOp2);
            }
        }
        return i8;
    }

    public AdapterHelper addUpdateOp(UpdateOp... updateOpArr) {
        Collections.addAll(this.mPendingUpdates, updateOpArr);
        return this;
    }

    public int applyPendingUpdatesToPosition(int i8) {
        int size = this.mPendingUpdates.size();
        for (int i9 = 0; i9 < size; i9++) {
            UpdateOp updateOp = this.mPendingUpdates.get(i9);
            int i10 = updateOp.cmd;
            if (i10 != 1) {
                if (i10 == 2) {
                    int i11 = updateOp.positionStart;
                    if (i11 <= i8) {
                        int i12 = updateOp.itemCount;
                        if (i11 + i12 > i8) {
                            return -1;
                        }
                        i8 -= i12;
                    } else {
                        continue;
                    }
                } else if (i10 == 8) {
                    int i13 = updateOp.positionStart;
                    if (i13 == i8) {
                        i8 = updateOp.itemCount;
                    } else {
                        if (i13 < i8) {
                            i8--;
                        }
                        if (updateOp.itemCount <= i8) {
                            i8++;
                        }
                    }
                }
            } else if (updateOp.positionStart <= i8) {
                i8 += updateOp.itemCount;
            }
        }
        return i8;
    }

    public void consumePostponedUpdates() {
        int size = this.mPostponedList.size();
        for (int i8 = 0; i8 < size; i8++) {
            this.mCallback.onDispatchSecondPass(this.mPostponedList.get(i8));
        }
        recycleUpdateOpsAndClearList(this.mPostponedList);
        this.mExistingUpdateTypes = 0;
    }

    public void consumeUpdatesInOnePass() {
        consumePostponedUpdates();
        int size = this.mPendingUpdates.size();
        for (int i8 = 0; i8 < size; i8++) {
            UpdateOp updateOp = this.mPendingUpdates.get(i8);
            int i9 = updateOp.cmd;
            if (i9 == 1) {
                this.mCallback.onDispatchSecondPass(updateOp);
                this.mCallback.offsetPositionsForAdd(updateOp.positionStart, updateOp.itemCount);
            } else if (i9 == 2) {
                this.mCallback.onDispatchSecondPass(updateOp);
                this.mCallback.offsetPositionsForRemovingInvisible(updateOp.positionStart, updateOp.itemCount);
            } else if (i9 == 4) {
                this.mCallback.onDispatchSecondPass(updateOp);
                this.mCallback.markViewHoldersUpdated(updateOp.positionStart, updateOp.itemCount, updateOp.payload);
            } else if (i9 == 8) {
                this.mCallback.onDispatchSecondPass(updateOp);
                this.mCallback.offsetPositionsForMove(updateOp.positionStart, updateOp.itemCount);
            }
            Runnable runnable = this.mOnItemProcessedCallback;
            if (runnable != null) {
                runnable.run();
            }
        }
        recycleUpdateOpsAndClearList(this.mPendingUpdates);
        this.mExistingUpdateTypes = 0;
    }

    public void dispatchFirstPassAndUpdateViewHolders(UpdateOp updateOp, int i8) {
        this.mCallback.onDispatchFirstPass(updateOp);
        int i9 = updateOp.cmd;
        if (i9 == 2) {
            this.mCallback.offsetPositionsForRemovingInvisible(i8, updateOp.itemCount);
        } else {
            if (i9 != 4) {
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
            }
            this.mCallback.markViewHoldersUpdated(i8, updateOp.itemCount, updateOp.payload);
        }
    }

    public int findPositionOffset(int i8) {
        return findPositionOffset(i8, 0);
    }

    public boolean hasAnyUpdateTypes(int i8) {
        return (this.mExistingUpdateTypes & i8) != 0;
    }

    public boolean hasPendingUpdates() {
        return this.mPendingUpdates.size() > 0;
    }

    public boolean hasUpdates() {
        return (this.mPostponedList.isEmpty() || this.mPendingUpdates.isEmpty()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.OpReorderer.Callback
    public UpdateOp obtainUpdateOp(int i8, int i9, int i10, Object obj) {
        UpdateOp updateOpAcquire = this.mUpdateOpPool.acquire();
        if (updateOpAcquire == null) {
            return new UpdateOp(i8, i9, i10, obj);
        }
        updateOpAcquire.cmd = i8;
        updateOpAcquire.positionStart = i9;
        updateOpAcquire.itemCount = i10;
        updateOpAcquire.payload = obj;
        return updateOpAcquire;
    }

    public boolean onItemRangeChanged(int i8, int i9, Object obj) {
        if (i9 < 1) {
            return false;
        }
        this.mPendingUpdates.add(obtainUpdateOp(4, i8, i9, obj));
        this.mExistingUpdateTypes |= 4;
        return this.mPendingUpdates.size() == 1;
    }

    public boolean onItemRangeInserted(int i8, int i9) {
        if (i9 < 1) {
            return false;
        }
        this.mPendingUpdates.add(obtainUpdateOp(1, i8, i9, null));
        this.mExistingUpdateTypes |= 1;
        return this.mPendingUpdates.size() == 1;
    }

    public boolean onItemRangeMoved(int i8, int i9, int i10) {
        if (i8 == i9) {
            return false;
        }
        if (i10 != 1) {
            throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
        }
        this.mPendingUpdates.add(obtainUpdateOp(8, i8, i9, null));
        this.mExistingUpdateTypes |= 8;
        return this.mPendingUpdates.size() == 1;
    }

    public boolean onItemRangeRemoved(int i8, int i9) {
        if (i9 < 1) {
            return false;
        }
        this.mPendingUpdates.add(obtainUpdateOp(2, i8, i9, null));
        this.mExistingUpdateTypes |= 2;
        return this.mPendingUpdates.size() == 1;
    }

    public void preProcess() {
        this.mOpReorderer.reorderOps(this.mPendingUpdates);
        int size = this.mPendingUpdates.size();
        for (int i8 = 0; i8 < size; i8++) {
            UpdateOp updateOp = this.mPendingUpdates.get(i8);
            int i9 = updateOp.cmd;
            if (i9 == 1) {
                applyAdd(updateOp);
            } else if (i9 == 2) {
                applyRemove(updateOp);
            } else if (i9 == 4) {
                applyUpdate(updateOp);
            } else if (i9 == 8) {
                applyMove(updateOp);
            }
            Runnable runnable = this.mOnItemProcessedCallback;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.mPendingUpdates.clear();
    }

    @Override // androidx.recyclerview.widget.OpReorderer.Callback
    public void recycleUpdateOp(UpdateOp updateOp) {
        if (this.mDisableRecycler) {
            return;
        }
        updateOp.payload = null;
        this.mUpdateOpPool.release(updateOp);
    }

    public void recycleUpdateOpsAndClearList(List<UpdateOp> list) {
        int size = list.size();
        for (int i8 = 0; i8 < size; i8++) {
            recycleUpdateOp(list.get(i8));
        }
        list.clear();
    }

    public void reset() {
        recycleUpdateOpsAndClearList(this.mPendingUpdates);
        recycleUpdateOpsAndClearList(this.mPostponedList);
        this.mExistingUpdateTypes = 0;
    }

    public AdapterHelper(Callback callback, boolean z2) {
        this.mUpdateOpPool = new Pools.SimplePool(30);
        this.mPendingUpdates = new ArrayList<>();
        this.mPostponedList = new ArrayList<>();
        this.mExistingUpdateTypes = 0;
        this.mCallback = callback;
        this.mDisableRecycler = z2;
        this.mOpReorderer = new OpReorderer(this);
    }

    public int findPositionOffset(int i8, int i9) {
        int size = this.mPostponedList.size();
        while (i9 < size) {
            UpdateOp updateOp = this.mPostponedList.get(i9);
            int i10 = updateOp.cmd;
            if (i10 == 8) {
                int i11 = updateOp.positionStart;
                if (i11 == i8) {
                    i8 = updateOp.itemCount;
                } else {
                    if (i11 < i8) {
                        i8--;
                    }
                    if (updateOp.itemCount <= i8) {
                        i8++;
                    }
                }
            } else {
                int i12 = updateOp.positionStart;
                if (i12 > i8) {
                    continue;
                } else if (i10 == 2) {
                    int i13 = updateOp.itemCount;
                    if (i8 < i12 + i13) {
                        return -1;
                    }
                    i8 -= i13;
                } else if (i10 == 1) {
                    i8 += updateOp.itemCount;
                }
            }
            i9++;
        }
        return i8;
    }
}
