package androidx.recyclerview.widget;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class OpReorderer {
    final Callback mCallback;

    public interface Callback {
        AdapterHelper.UpdateOp obtainUpdateOp(int i8, int i9, int i10, Object obj);

        void recycleUpdateOp(AdapterHelper.UpdateOp updateOp);
    }

    public OpReorderer(Callback callback) {
        this.mCallback = callback;
    }

    private int getLastMoveOutOfOrder(List<AdapterHelper.UpdateOp> list) {
        boolean z2 = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).cmd != 8) {
                z2 = true;
            } else if (z2) {
                return size;
            }
        }
        return -1;
    }

    private void swapMoveAdd(List<AdapterHelper.UpdateOp> list, int i8, AdapterHelper.UpdateOp updateOp, int i9, AdapterHelper.UpdateOp updateOp2) {
        int i10 = updateOp.itemCount;
        int i11 = updateOp2.positionStart;
        int i12 = i10 < i11 ? -1 : 0;
        int i13 = updateOp.positionStart;
        if (i13 < i11) {
            i12++;
        }
        if (i11 <= i13) {
            updateOp.positionStart = i13 + updateOp2.itemCount;
        }
        int i14 = updateOp2.positionStart;
        if (i14 <= i10) {
            updateOp.itemCount = i10 + updateOp2.itemCount;
        }
        updateOp2.positionStart = i14 + i12;
        list.set(i8, updateOp2);
        list.set(i9, updateOp);
    }

    private void swapMoveOp(List<AdapterHelper.UpdateOp> list, int i8, int i9) {
        AdapterHelper.UpdateOp updateOp = list.get(i8);
        AdapterHelper.UpdateOp updateOp2 = list.get(i9);
        int i10 = updateOp2.cmd;
        if (i10 == 1) {
            swapMoveAdd(list, i8, updateOp, i9, updateOp2);
        } else if (i10 == 2) {
            swapMoveRemove(list, i8, updateOp, i9, updateOp2);
        } else {
            if (i10 != 4) {
                return;
            }
            swapMoveUpdate(list, i8, updateOp, i9, updateOp2);
        }
    }

    public void reorderOps(List<AdapterHelper.UpdateOp> list) {
        while (true) {
            int lastMoveOutOfOrder = getLastMoveOutOfOrder(list);
            if (lastMoveOutOfOrder == -1) {
                return;
            } else {
                swapMoveOp(list, lastMoveOutOfOrder, lastMoveOutOfOrder + 1);
            }
        }
    }

    public void swapMoveRemove(List<AdapterHelper.UpdateOp> list, int i8, AdapterHelper.UpdateOp updateOp, int i9, AdapterHelper.UpdateOp updateOp2) {
        boolean z2;
        int i10 = updateOp.positionStart;
        int i11 = updateOp.itemCount;
        boolean z3 = false;
        if (i10 < i11) {
            if (updateOp2.positionStart == i10 && updateOp2.itemCount == i11 - i10) {
                z2 = false;
                z3 = true;
            } else {
                z2 = false;
            }
        } else if (updateOp2.positionStart == i11 + 1 && updateOp2.itemCount == i10 - i11) {
            z2 = true;
            z3 = true;
        } else {
            z2 = true;
        }
        int i12 = updateOp2.positionStart;
        if (i11 < i12) {
            updateOp2.positionStart = i12 - 1;
        } else {
            int i13 = updateOp2.itemCount;
            if (i11 < i12 + i13) {
                updateOp2.itemCount = i13 - 1;
                updateOp.cmd = 2;
                updateOp.itemCount = 1;
                if (updateOp2.itemCount == 0) {
                    list.remove(i9);
                    this.mCallback.recycleUpdateOp(updateOp2);
                    return;
                }
                return;
            }
        }
        int i14 = updateOp.positionStart;
        int i15 = updateOp2.positionStart;
        AdapterHelper.UpdateOp updateOpObtainUpdateOp = null;
        if (i14 <= i15) {
            updateOp2.positionStart = i15 + 1;
        } else {
            int i16 = updateOp2.itemCount;
            if (i14 < i15 + i16) {
                updateOpObtainUpdateOp = this.mCallback.obtainUpdateOp(2, i14 + 1, (i15 + i16) - i14, null);
                updateOp2.itemCount = updateOp.positionStart - updateOp2.positionStart;
            }
        }
        if (z3) {
            list.set(i8, updateOp2);
            list.remove(i9);
            this.mCallback.recycleUpdateOp(updateOp);
            return;
        }
        if (z2) {
            if (updateOpObtainUpdateOp != null) {
                int i17 = updateOp.positionStart;
                if (i17 > updateOpObtainUpdateOp.positionStart) {
                    updateOp.positionStart = i17 - updateOpObtainUpdateOp.itemCount;
                }
                int i18 = updateOp.itemCount;
                if (i18 > updateOpObtainUpdateOp.positionStart) {
                    updateOp.itemCount = i18 - updateOpObtainUpdateOp.itemCount;
                }
            }
            int i19 = updateOp.positionStart;
            if (i19 > updateOp2.positionStart) {
                updateOp.positionStart = i19 - updateOp2.itemCount;
            }
            int i20 = updateOp.itemCount;
            if (i20 > updateOp2.positionStart) {
                updateOp.itemCount = i20 - updateOp2.itemCount;
            }
        } else {
            if (updateOpObtainUpdateOp != null) {
                int i21 = updateOp.positionStart;
                if (i21 >= updateOpObtainUpdateOp.positionStart) {
                    updateOp.positionStart = i21 - updateOpObtainUpdateOp.itemCount;
                }
                int i22 = updateOp.itemCount;
                if (i22 >= updateOpObtainUpdateOp.positionStart) {
                    updateOp.itemCount = i22 - updateOpObtainUpdateOp.itemCount;
                }
            }
            int i23 = updateOp.positionStart;
            if (i23 >= updateOp2.positionStart) {
                updateOp.positionStart = i23 - updateOp2.itemCount;
            }
            int i24 = updateOp.itemCount;
            if (i24 >= updateOp2.positionStart) {
                updateOp.itemCount = i24 - updateOp2.itemCount;
            }
        }
        list.set(i8, updateOp2);
        if (updateOp.positionStart != updateOp.itemCount) {
            list.set(i9, updateOp);
        } else {
            list.remove(i9);
        }
        if (updateOpObtainUpdateOp != null) {
            list.add(i8, updateOpObtainUpdateOp);
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0027  */
    /* JADX WARN: Code duplicated, block: B:12:0x002b  */
    /* JADX WARN: Code duplicated, block: B:14:0x0031  */
    /* JADX WARN: Code duplicated, block: B:17:0x0048  */
    /* JADX WARN: Code duplicated, block: B:18:0x004c  */
    /* JADX WARN: Code duplicated, block: B:20:0x0056  */
    /* JADX WARN: Code duplicated, block: B:22:0x005b  */
    /* JADX WARN: Code duplicated, block: B:24:? A[RETURN, SYNTHETIC] */
    public void swapMoveUpdate(List<AdapterHelper.UpdateOp> list, int i8, AdapterHelper.UpdateOp updateOp, int i9, AdapterHelper.UpdateOp updateOp2) {
        AdapterHelper.UpdateOp updateOpObtainUpdateOp;
        int i10;
        int i11;
        int i12;
        int i13 = updateOp.itemCount;
        int i14 = updateOp2.positionStart;
        AdapterHelper.UpdateOp updateOpObtainUpdateOp2 = null;
        if (i13 >= i14) {
            int i15 = updateOp2.itemCount;
            if (i13 < i14 + i15) {
                updateOp2.itemCount = i15 - 1;
                updateOpObtainUpdateOp = this.mCallback.obtainUpdateOp(4, updateOp.positionStart, 1, updateOp2.payload);
            }
            i10 = updateOp.positionStart;
            i11 = updateOp2.positionStart;
            if (i10 <= i11) {
                updateOp2.positionStart = i11 + 1;
            } else {
                i12 = updateOp2.itemCount;
                if (i10 < i11 + i12) {
                    int i16 = (i11 + i12) - i10;
                    updateOpObtainUpdateOp2 = this.mCallback.obtainUpdateOp(4, i10 + 1, i16, updateOp2.payload);
                    updateOp2.itemCount -= i16;
                }
            }
            list.set(i9, updateOp);
            if (updateOp2.itemCount > 0) {
                list.set(i8, updateOp2);
            } else {
                list.remove(i8);
                this.mCallback.recycleUpdateOp(updateOp2);
            }
            if (updateOpObtainUpdateOp != null) {
                list.add(i8, updateOpObtainUpdateOp);
            }
            if (updateOpObtainUpdateOp2 != null) {
                list.add(i8, updateOpObtainUpdateOp2);
            }
        }
        updateOp2.positionStart = i14 - 1;
        updateOpObtainUpdateOp = null;
        i10 = updateOp.positionStart;
        i11 = updateOp2.positionStart;
        if (i10 <= i11) {
            updateOp2.positionStart = i11 + 1;
        } else {
            i12 = updateOp2.itemCount;
            if (i10 < i11 + i12) {
                int i17 = (i11 + i12) - i10;
                updateOpObtainUpdateOp2 = this.mCallback.obtainUpdateOp(4, i10 + 1, i17, updateOp2.payload);
                updateOp2.itemCount -= i17;
            }
        }
        list.set(i9, updateOp);
        if (updateOp2.itemCount > 0) {
            list.set(i8, updateOp2);
        } else {
            list.remove(i8);
            this.mCallback.recycleUpdateOp(updateOp2);
        }
        if (updateOpObtainUpdateOp != null) {
            list.add(i8, updateOpObtainUpdateOp);
        }
        if (updateOpObtainUpdateOp2 != null) {
            list.add(i8, updateOpObtainUpdateOp2);
        }
    }
}
