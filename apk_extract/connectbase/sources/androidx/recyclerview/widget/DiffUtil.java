package androidx.recyclerview.widget;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import h.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DiffUtil {
    private static final Comparator<Snake> SNAKE_COMPARATOR = new Comparator<Snake>() { // from class: androidx.recyclerview.widget.DiffUtil.1
        @Override // java.util.Comparator
        public int compare(Snake snake, Snake snake2) {
            int i10 = snake.f513x - snake2.f513x;
            return i10 == 0 ? snake.f514y - snake2.f514y : i10;
        }
    };

    public static abstract class Callback {
        public abstract boolean areContentsTheSame(int i10, int i11);

        public abstract boolean areItemsTheSame(int i10, int i11);

        @Nullable
        public Object getChangePayload(int i10, int i11) {
            return null;
        }

        public abstract int getNewListSize();

        public abstract int getOldListSize();
    }

    public static class DiffResult {
        private static final int FLAG_CHANGED = 2;
        private static final int FLAG_IGNORE = 16;
        private static final int FLAG_MASK = 31;
        private static final int FLAG_MOVED_CHANGED = 4;
        private static final int FLAG_MOVED_NOT_CHANGED = 8;
        private static final int FLAG_NOT_CHANGED = 1;
        private static final int FLAG_OFFSET = 5;
        public static final int NO_POSITION = -1;
        private final Callback mCallback;
        private final boolean mDetectMoves;
        private final int[] mNewItemStatuses;
        private final int mNewListSize;
        private final int[] mOldItemStatuses;
        private final int mOldListSize;
        private final List<Snake> mSnakes;

        public DiffResult(Callback callback, List<Snake> list, int[] iArr, int[] iArr2, boolean z10) {
            this.mSnakes = list;
            this.mOldItemStatuses = iArr;
            this.mNewItemStatuses = iArr2;
            Arrays.fill(iArr, 0);
            Arrays.fill(iArr2, 0);
            this.mCallback = callback;
            this.mOldListSize = callback.getOldListSize();
            this.mNewListSize = callback.getNewListSize();
            this.mDetectMoves = z10;
            addRootSnake();
            findMatchingItems();
        }

        private void addRootSnake() {
            Snake snake = this.mSnakes.isEmpty() ? null : this.mSnakes.get(0);
            if (snake != null && snake.f513x == 0 && snake.f514y == 0) {
                return;
            }
            Snake snake2 = new Snake();
            snake2.f513x = 0;
            snake2.f514y = 0;
            snake2.removal = false;
            snake2.size = 0;
            snake2.reverse = false;
            this.mSnakes.add(0, snake2);
        }

        private void dispatchAdditions(List<PostponedUpdate> list, ListUpdateCallback listUpdateCallback, int i10, int i11, int i12) {
            if (!this.mDetectMoves) {
                listUpdateCallback.onInserted(i10, i11);
                return;
            }
            for (int i13 = i11 - 1; i13 >= 0; i13--) {
                int i14 = i12 + i13;
                int i15 = this.mNewItemStatuses[i14];
                int i16 = i15 & 31;
                if (i16 == 0) {
                    listUpdateCallback.onInserted(i10, 1);
                    Iterator<PostponedUpdate> it = list.iterator();
                    while (it.hasNext()) {
                        it.next().currentPos++;
                    }
                } else if (i16 == 4 || i16 == 8) {
                    int i17 = i15 >> 5;
                    listUpdateCallback.onMoved(removePostponedUpdate(list, i17, true).currentPos, i10);
                    if (i16 == 4) {
                        listUpdateCallback.onChanged(i10, 1, this.mCallback.getChangePayload(i17, i14));
                    }
                } else {
                    if (i16 != 16) {
                        StringBuilder sbA = b.a("unknown flag for pos ", i14, " ");
                        sbA.append(Long.toBinaryString(i16));
                        throw new IllegalStateException(sbA.toString());
                    }
                    list.add(new PostponedUpdate(i14, i10, false));
                }
            }
        }

        private void dispatchRemovals(List<PostponedUpdate> list, ListUpdateCallback listUpdateCallback, int i10, int i11, int i12) {
            if (!this.mDetectMoves) {
                listUpdateCallback.onRemoved(i10, i11);
                return;
            }
            for (int i13 = i11 - 1; i13 >= 0; i13--) {
                int i14 = i12 + i13;
                int i15 = this.mOldItemStatuses[i14];
                int i16 = i15 & 31;
                if (i16 == 0) {
                    listUpdateCallback.onRemoved(i10 + i13, 1);
                    Iterator<PostponedUpdate> it = list.iterator();
                    while (it.hasNext()) {
                        it.next().currentPos--;
                    }
                } else if (i16 == 4 || i16 == 8) {
                    int i17 = i15 >> 5;
                    PostponedUpdate postponedUpdateRemovePostponedUpdate = removePostponedUpdate(list, i17, false);
                    listUpdateCallback.onMoved(i10 + i13, postponedUpdateRemovePostponedUpdate.currentPos - 1);
                    if (i16 == 4) {
                        listUpdateCallback.onChanged(postponedUpdateRemovePostponedUpdate.currentPos - 1, 1, this.mCallback.getChangePayload(i14, i17));
                    }
                } else {
                    if (i16 != 16) {
                        StringBuilder sbA = b.a("unknown flag for pos ", i14, " ");
                        sbA.append(Long.toBinaryString(i16));
                        throw new IllegalStateException(sbA.toString());
                    }
                    list.add(new PostponedUpdate(i14, i10 + i13, true));
                }
            }
        }

        private void findAddition(int i10, int i11, int i12) {
            if (this.mOldItemStatuses[i10 - 1] != 0) {
                return;
            }
            findMatchingItem(i10, i11, i12, false);
        }

        private boolean findMatchingItem(int i10, int i11, int i12, boolean z10) {
            int i13;
            int i14;
            int i15;
            if (z10) {
                i11--;
                i14 = i10;
                i13 = i11;
            } else {
                i13 = i10 - 1;
                i14 = i13;
            }
            while (i12 >= 0) {
                Snake snake = this.mSnakes.get(i12);
                int i16 = snake.f513x;
                int i17 = snake.size;
                int i18 = i16 + i17;
                int i19 = snake.f514y + i17;
                if (z10) {
                    for (int i20 = i14 - 1; i20 >= i18; i20--) {
                        if (this.mCallback.areItemsTheSame(i20, i13)) {
                            i15 = this.mCallback.areContentsTheSame(i20, i13) ? 8 : 4;
                            this.mNewItemStatuses[i13] = (i20 << 5) | 16;
                            this.mOldItemStatuses[i20] = (i13 << 5) | i15;
                            return true;
                        }
                    }
                } else {
                    for (int i21 = i11 - 1; i21 >= i19; i21--) {
                        if (this.mCallback.areItemsTheSame(i13, i21)) {
                            i15 = this.mCallback.areContentsTheSame(i13, i21) ? 8 : 4;
                            int i22 = i10 - 1;
                            this.mOldItemStatuses[i22] = (i21 << 5) | 16;
                            this.mNewItemStatuses[i21] = (i22 << 5) | i15;
                            return true;
                        }
                    }
                }
                i14 = snake.f513x;
                i11 = snake.f514y;
                i12--;
            }
            return false;
        }

        private void findMatchingItems() {
            int i10 = this.mOldListSize;
            int i11 = this.mNewListSize;
            for (int size = this.mSnakes.size() - 1; size >= 0; size--) {
                Snake snake = this.mSnakes.get(size);
                int i12 = snake.f513x;
                int i13 = snake.size;
                int i14 = i12 + i13;
                int i15 = snake.f514y + i13;
                if (this.mDetectMoves) {
                    while (i10 > i14) {
                        findAddition(i10, i11, size);
                        i10--;
                    }
                    while (i11 > i15) {
                        findRemoval(i10, i11, size);
                        i11--;
                    }
                }
                for (int i16 = 0; i16 < snake.size; i16++) {
                    int i17 = snake.f513x + i16;
                    int i18 = snake.f514y + i16;
                    int i19 = this.mCallback.areContentsTheSame(i17, i18) ? 1 : 2;
                    this.mOldItemStatuses[i17] = (i18 << 5) | i19;
                    this.mNewItemStatuses[i18] = (i17 << 5) | i19;
                }
                i10 = snake.f513x;
                i11 = snake.f514y;
            }
        }

        private void findRemoval(int i10, int i11, int i12) {
            if (this.mNewItemStatuses[i11 - 1] != 0) {
                return;
            }
            findMatchingItem(i10, i11, i12, true);
        }

        private static PostponedUpdate removePostponedUpdate(List<PostponedUpdate> list, int i10, boolean z10) {
            int size = list.size() - 1;
            while (size >= 0) {
                PostponedUpdate postponedUpdate = list.get(size);
                if (postponedUpdate.posInOwnerList == i10 && postponedUpdate.removal == z10) {
                    list.remove(size);
                    while (size < list.size()) {
                        list.get(size).currentPos += z10 ? 1 : -1;
                        size++;
                    }
                    return postponedUpdate;
                }
                size--;
            }
            return null;
        }

        public int convertNewPositionToOld(@IntRange(from = 0) int i10) {
            if (i10 < 0 || i10 >= this.mNewListSize) {
                StringBuilder sbA = b.a("Index out of bounds - passed position = ", i10, ", new list size = ");
                sbA.append(this.mNewListSize);
                throw new IndexOutOfBoundsException(sbA.toString());
            }
            int i11 = this.mNewItemStatuses[i10];
            if ((i11 & 31) == 0) {
                return -1;
            }
            return i11 >> 5;
        }

        public int convertOldPositionToNew(@IntRange(from = 0) int i10) {
            if (i10 < 0 || i10 >= this.mOldListSize) {
                StringBuilder sbA = b.a("Index out of bounds - passed position = ", i10, ", old list size = ");
                sbA.append(this.mOldListSize);
                throw new IndexOutOfBoundsException(sbA.toString());
            }
            int i11 = this.mOldItemStatuses[i10];
            if ((i11 & 31) == 0) {
                return -1;
            }
            return i11 >> 5;
        }

        public void dispatchUpdatesTo(@NonNull RecyclerView.Adapter adapter) {
            dispatchUpdatesTo(new AdapterListUpdateCallback(adapter));
        }

        @VisibleForTesting
        public List<Snake> getSnakes() {
            return this.mSnakes;
        }

        public void dispatchUpdatesTo(@NonNull ListUpdateCallback listUpdateCallback) {
            BatchingListUpdateCallback batchingListUpdateCallback = listUpdateCallback instanceof BatchingListUpdateCallback ? (BatchingListUpdateCallback) listUpdateCallback : new BatchingListUpdateCallback(listUpdateCallback);
            List<PostponedUpdate> arrayList = new ArrayList<>();
            int i10 = this.mOldListSize;
            int i11 = this.mNewListSize;
            for (int size = this.mSnakes.size() - 1; size >= 0; size--) {
                Snake snake = this.mSnakes.get(size);
                int i12 = snake.size;
                int i13 = snake.f513x + i12;
                int i14 = snake.f514y + i12;
                if (i13 < i10) {
                    dispatchRemovals(arrayList, batchingListUpdateCallback, i13, i10 - i13, i13);
                }
                if (i14 < i11) {
                    dispatchAdditions(arrayList, batchingListUpdateCallback, i13, i11 - i14, i14);
                }
                for (int i15 = i12 - 1; i15 >= 0; i15--) {
                    int[] iArr = this.mOldItemStatuses;
                    int i16 = snake.f513x;
                    if ((iArr[i16 + i15] & 31) == 2) {
                        batchingListUpdateCallback.onChanged(i16 + i15, 1, this.mCallback.getChangePayload(i16 + i15, snake.f514y + i15));
                    }
                }
                i10 = snake.f513x;
                i11 = snake.f514y;
            }
            batchingListUpdateCallback.dispatchLastEvent();
        }
    }

    public static abstract class ItemCallback<T> {
        public abstract boolean areContentsTheSame(@NonNull T t10, @NonNull T t11);

        public abstract boolean areItemsTheSame(@NonNull T t10, @NonNull T t11);

        @Nullable
        public Object getChangePayload(@NonNull T t10, @NonNull T t11) {
            return null;
        }
    }

    public static class PostponedUpdate {
        int currentPos;
        int posInOwnerList;
        boolean removal;

        public PostponedUpdate(int i10, int i11, boolean z10) {
            this.posInOwnerList = i10;
            this.currentPos = i11;
            this.removal = z10;
        }
    }

    public static class Range {
        int newListEnd;
        int newListStart;
        int oldListEnd;
        int oldListStart;

        public Range() {
        }

        public Range(int i10, int i11, int i12, int i13) {
            this.oldListStart = i10;
            this.oldListEnd = i11;
            this.newListStart = i12;
            this.newListEnd = i13;
        }
    }

    public static class Snake {
        boolean removal;
        boolean reverse;
        int size;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        int f513x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        int f514y;
    }

    private DiffUtil() {
    }

    @NonNull
    public static DiffResult calculateDiff(@NonNull Callback callback) {
        return calculateDiff(callback, true);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x004d  */
    /* JADX WARN: Multi-variable type inference failed */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:52:0x00ca
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:272)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:237)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:80)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:49)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    private static androidx.recyclerview.widget.DiffUtil.Snake diffPartial(androidx.recyclerview.widget.DiffUtil.Callback r19, int r20, int r21, int r22, int r23, int[] r24, int[] r25, int r26) {
        /*
            Method dump skipped, instruction units count: 299
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.DiffUtil.diffPartial(androidx.recyclerview.widget.DiffUtil$Callback, int, int, int, int, int[], int[], int):androidx.recyclerview.widget.DiffUtil$Snake");
    }

    @NonNull
    public static DiffResult calculateDiff(@NonNull Callback callback, boolean z10) {
        int oldListSize = callback.getOldListSize();
        int newListSize = callback.getNewListSize();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new Range(0, oldListSize, 0, newListSize));
        int iAbs = Math.abs(oldListSize - newListSize) + oldListSize + newListSize;
        int i10 = iAbs * 2;
        int[] iArr = new int[i10];
        int[] iArr2 = new int[i10];
        ArrayList arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            Range range = (Range) arrayList2.remove(arrayList2.size() - 1);
            Snake snakeDiffPartial = diffPartial(callback, range.oldListStart, range.oldListEnd, range.newListStart, range.newListEnd, iArr, iArr2, iAbs);
            if (snakeDiffPartial != null) {
                if (snakeDiffPartial.size > 0) {
                    arrayList.add(snakeDiffPartial);
                }
                snakeDiffPartial.f513x += range.oldListStart;
                snakeDiffPartial.f514y += range.newListStart;
                Range range2 = arrayList3.isEmpty() ? new Range() : (Range) arrayList3.remove(arrayList3.size() - 1);
                range2.oldListStart = range.oldListStart;
                range2.newListStart = range.newListStart;
                if (snakeDiffPartial.reverse) {
                    range2.oldListEnd = snakeDiffPartial.f513x;
                    range2.newListEnd = snakeDiffPartial.f514y;
                } else if (snakeDiffPartial.removal) {
                    range2.oldListEnd = snakeDiffPartial.f513x - 1;
                    range2.newListEnd = snakeDiffPartial.f514y;
                } else {
                    range2.oldListEnd = snakeDiffPartial.f513x;
                    range2.newListEnd = snakeDiffPartial.f514y - 1;
                }
                arrayList2.add(range2);
                if (!snakeDiffPartial.reverse) {
                    int i11 = snakeDiffPartial.f513x;
                    int i12 = snakeDiffPartial.size;
                    range.oldListStart = i11 + i12;
                    range.newListStart = snakeDiffPartial.f514y + i12;
                } else if (snakeDiffPartial.removal) {
                    int i13 = snakeDiffPartial.f513x;
                    int i14 = snakeDiffPartial.size;
                    range.oldListStart = i13 + i14 + 1;
                    range.newListStart = snakeDiffPartial.f514y + i14;
                } else {
                    int i15 = snakeDiffPartial.f513x;
                    int i16 = snakeDiffPartial.size;
                    range.oldListStart = i15 + i16;
                    range.newListStart = snakeDiffPartial.f514y + i16 + 1;
                }
                arrayList2.add(range);
            } else {
                arrayList3.add(range);
            }
        }
        Collections.sort(arrayList, SNAKE_COMPARATOR);
        return new DiffResult(callback, arrayList, iArr, iArr2, z10);
    }
}
