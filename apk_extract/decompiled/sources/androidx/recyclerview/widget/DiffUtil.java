package androidx.recyclerview.widget;

import a1.a;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
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
            int i8 = snake.f1144x - snake2.f1144x;
            return i8 == 0 ? snake.f1145y - snake2.f1145y : i8;
        }
    };

    public static abstract class Callback {
        public abstract boolean areContentsTheSame(int i8, int i9);

        public abstract boolean areItemsTheSame(int i8, int i9);

        @Nullable
        public Object getChangePayload(int i8, int i9) {
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

        public DiffResult(Callback callback, List<Snake> list, int[] iArr, int[] iArr2, boolean z2) {
            this.mSnakes = list;
            this.mOldItemStatuses = iArr;
            this.mNewItemStatuses = iArr2;
            Arrays.fill(iArr, 0);
            Arrays.fill(iArr2, 0);
            this.mCallback = callback;
            this.mOldListSize = callback.getOldListSize();
            this.mNewListSize = callback.getNewListSize();
            this.mDetectMoves = z2;
            addRootSnake();
            findMatchingItems();
        }

        private void addRootSnake() {
            Snake snake = this.mSnakes.isEmpty() ? null : this.mSnakes.get(0);
            if (snake != null && snake.f1144x == 0 && snake.f1145y == 0) {
                return;
            }
            Snake snake2 = new Snake();
            snake2.f1144x = 0;
            snake2.f1145y = 0;
            snake2.removal = false;
            snake2.size = 0;
            snake2.reverse = false;
            this.mSnakes.add(0, snake2);
        }

        private void dispatchAdditions(List<PostponedUpdate> list, ListUpdateCallback listUpdateCallback, int i8, int i9, int i10) {
            if (!this.mDetectMoves) {
                listUpdateCallback.onInserted(i8, i9);
                return;
            }
            for (int i11 = i9 - 1; i11 >= 0; i11--) {
                int i12 = i10 + i11;
                int i13 = this.mNewItemStatuses[i12];
                int i14 = i13 & 31;
                if (i14 == 0) {
                    listUpdateCallback.onInserted(i8, 1);
                    Iterator<PostponedUpdate> it = list.iterator();
                    while (it.hasNext()) {
                        it.next().currentPos++;
                    }
                } else if (i14 == 4 || i14 == 8) {
                    int i15 = i13 >> 5;
                    listUpdateCallback.onMoved(removePostponedUpdate(list, i15, true).currentPos, i8);
                    if (i14 == 4) {
                        listUpdateCallback.onChanged(i8, 1, this.mCallback.getChangePayload(i15, i12));
                    }
                } else {
                    if (i14 != 16) {
                        StringBuilder sbU = a.u(i12, "unknown flag for pos ", " ");
                        sbU.append(Long.toBinaryString(i14));
                        throw new IllegalStateException(sbU.toString());
                    }
                    list.add(new PostponedUpdate(i12, i8, false));
                }
            }
        }

        private void dispatchRemovals(List<PostponedUpdate> list, ListUpdateCallback listUpdateCallback, int i8, int i9, int i10) {
            if (!this.mDetectMoves) {
                listUpdateCallback.onRemoved(i8, i9);
                return;
            }
            for (int i11 = i9 - 1; i11 >= 0; i11--) {
                int i12 = i10 + i11;
                int i13 = this.mOldItemStatuses[i12];
                int i14 = i13 & 31;
                if (i14 == 0) {
                    listUpdateCallback.onRemoved(i8 + i11, 1);
                    Iterator<PostponedUpdate> it = list.iterator();
                    while (it.hasNext()) {
                        it.next().currentPos--;
                    }
                } else if (i14 == 4 || i14 == 8) {
                    int i15 = i13 >> 5;
                    PostponedUpdate postponedUpdateRemovePostponedUpdate = removePostponedUpdate(list, i15, false);
                    listUpdateCallback.onMoved(i8 + i11, postponedUpdateRemovePostponedUpdate.currentPos - 1);
                    if (i14 == 4) {
                        listUpdateCallback.onChanged(postponedUpdateRemovePostponedUpdate.currentPos - 1, 1, this.mCallback.getChangePayload(i12, i15));
                    }
                } else {
                    if (i14 != 16) {
                        StringBuilder sbU = a.u(i12, "unknown flag for pos ", " ");
                        sbU.append(Long.toBinaryString(i14));
                        throw new IllegalStateException(sbU.toString());
                    }
                    list.add(new PostponedUpdate(i12, i8 + i11, true));
                }
            }
        }

        private void findAddition(int i8, int i9, int i10) {
            if (this.mOldItemStatuses[i8 - 1] != 0) {
                return;
            }
            findMatchingItem(i8, i9, i10, false);
        }

        private boolean findMatchingItem(int i8, int i9, int i10, boolean z2) {
            int i11;
            int i12;
            int i13;
            if (z2) {
                i9--;
                i12 = i8;
                i11 = i9;
            } else {
                i11 = i8 - 1;
                i12 = i11;
            }
            while (i10 >= 0) {
                Snake snake = this.mSnakes.get(i10);
                int i14 = snake.f1144x;
                int i15 = snake.size;
                int i16 = i14 + i15;
                int i17 = snake.f1145y + i15;
                if (z2) {
                    for (int i18 = i12 - 1; i18 >= i16; i18--) {
                        if (this.mCallback.areItemsTheSame(i18, i11)) {
                            i13 = this.mCallback.areContentsTheSame(i18, i11) ? 8 : 4;
                            this.mNewItemStatuses[i11] = (i18 << 5) | 16;
                            this.mOldItemStatuses[i18] = (i11 << 5) | i13;
                            return true;
                        }
                    }
                } else {
                    for (int i19 = i9 - 1; i19 >= i17; i19--) {
                        if (this.mCallback.areItemsTheSame(i11, i19)) {
                            i13 = this.mCallback.areContentsTheSame(i11, i19) ? 8 : 4;
                            int i20 = i8 - 1;
                            this.mOldItemStatuses[i20] = (i19 << 5) | 16;
                            this.mNewItemStatuses[i19] = (i20 << 5) | i13;
                            return true;
                        }
                    }
                }
                i12 = snake.f1144x;
                i9 = snake.f1145y;
                i10--;
            }
            return false;
        }

        private void findMatchingItems() {
            int i8 = this.mOldListSize;
            int i9 = this.mNewListSize;
            for (int size = this.mSnakes.size() - 1; size >= 0; size--) {
                Snake snake = this.mSnakes.get(size);
                int i10 = snake.f1144x;
                int i11 = snake.size;
                int i12 = i10 + i11;
                int i13 = snake.f1145y + i11;
                if (this.mDetectMoves) {
                    while (i8 > i12) {
                        findAddition(i8, i9, size);
                        i8--;
                    }
                    while (i9 > i13) {
                        findRemoval(i8, i9, size);
                        i9--;
                    }
                }
                for (int i14 = 0; i14 < snake.size; i14++) {
                    int i15 = snake.f1144x + i14;
                    int i16 = snake.f1145y + i14;
                    int i17 = this.mCallback.areContentsTheSame(i15, i16) ? 1 : 2;
                    this.mOldItemStatuses[i15] = (i16 << 5) | i17;
                    this.mNewItemStatuses[i16] = (i15 << 5) | i17;
                }
                i8 = snake.f1144x;
                i9 = snake.f1145y;
            }
        }

        private void findRemoval(int i8, int i9, int i10) {
            if (this.mNewItemStatuses[i9 - 1] != 0) {
                return;
            }
            findMatchingItem(i8, i9, i10, true);
        }

        private static PostponedUpdate removePostponedUpdate(List<PostponedUpdate> list, int i8, boolean z2) {
            int size = list.size() - 1;
            while (size >= 0) {
                PostponedUpdate postponedUpdate = list.get(size);
                if (postponedUpdate.posInOwnerList == i8 && postponedUpdate.removal == z2) {
                    list.remove(size);
                    while (size < list.size()) {
                        list.get(size).currentPos += z2 ? 1 : -1;
                        size++;
                    }
                    return postponedUpdate;
                }
                size--;
            }
            return null;
        }

        public int convertNewPositionToOld(@IntRange(from = 0) int i8) {
            if (i8 < 0 || i8 >= this.mNewListSize) {
                StringBuilder sbU = a.u(i8, "Index out of bounds - passed position = ", ", new list size = ");
                sbU.append(this.mNewListSize);
                throw new IndexOutOfBoundsException(sbU.toString());
            }
            int i9 = this.mNewItemStatuses[i8];
            if ((i9 & 31) == 0) {
                return -1;
            }
            return i9 >> 5;
        }

        public int convertOldPositionToNew(@IntRange(from = 0) int i8) {
            if (i8 < 0 || i8 >= this.mOldListSize) {
                StringBuilder sbU = a.u(i8, "Index out of bounds - passed position = ", ", old list size = ");
                sbU.append(this.mOldListSize);
                throw new IndexOutOfBoundsException(sbU.toString());
            }
            int i9 = this.mOldItemStatuses[i8];
            if ((i9 & 31) == 0) {
                return -1;
            }
            return i9 >> 5;
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
            int i8 = this.mOldListSize;
            int i9 = this.mNewListSize;
            for (int size = this.mSnakes.size() - 1; size >= 0; size--) {
                Snake snake = this.mSnakes.get(size);
                int i10 = snake.size;
                int i11 = snake.f1144x + i10;
                int i12 = snake.f1145y + i10;
                if (i11 < i8) {
                    dispatchRemovals(arrayList, batchingListUpdateCallback, i11, i8 - i11, i11);
                }
                if (i12 < i9) {
                    dispatchAdditions(arrayList, batchingListUpdateCallback, i11, i9 - i12, i12);
                }
                for (int i13 = i10 - 1; i13 >= 0; i13--) {
                    int[] iArr = this.mOldItemStatuses;
                    int i14 = snake.f1144x;
                    if ((iArr[i14 + i13] & 31) == 2) {
                        batchingListUpdateCallback.onChanged(i14 + i13, 1, this.mCallback.getChangePayload(i14 + i13, snake.f1145y + i13));
                    }
                }
                i8 = snake.f1144x;
                i9 = snake.f1145y;
            }
            batchingListUpdateCallback.dispatchLastEvent();
        }
    }

    public static abstract class ItemCallback<T> {
        public abstract boolean areContentsTheSame(@NonNull T t3, @NonNull T t8);

        public abstract boolean areItemsTheSame(@NonNull T t3, @NonNull T t8);

        @Nullable
        public Object getChangePayload(@NonNull T t3, @NonNull T t8) {
            return null;
        }
    }

    public static class PostponedUpdate {
        int currentPos;
        int posInOwnerList;
        boolean removal;

        public PostponedUpdate(int i8, int i9, boolean z2) {
            this.posInOwnerList = i8;
            this.currentPos = i9;
            this.removal = z2;
        }
    }

    public static class Range {
        int newListEnd;
        int newListStart;
        int oldListEnd;
        int oldListStart;

        public Range() {
        }

        public Range(int i8, int i9, int i10, int i11) {
            this.oldListStart = i8;
            this.oldListEnd = i9;
            this.newListStart = i10;
            this.newListEnd = i11;
        }
    }

    public static class Snake {
        boolean removal;
        boolean reverse;
        int size;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        int f1144x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        int f1145y;
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
    public static DiffResult calculateDiff(@NonNull Callback callback, boolean z2) {
        int oldListSize = callback.getOldListSize();
        int newListSize = callback.getNewListSize();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new Range(0, oldListSize, 0, newListSize));
        int iAbs = Math.abs(oldListSize - newListSize) + oldListSize + newListSize;
        int i8 = iAbs * 2;
        int[] iArr = new int[i8];
        int[] iArr2 = new int[i8];
        ArrayList arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            Range range = (Range) arrayList2.remove(arrayList2.size() - 1);
            Snake snakeDiffPartial = diffPartial(callback, range.oldListStart, range.oldListEnd, range.newListStart, range.newListEnd, iArr, iArr2, iAbs);
            if (snakeDiffPartial != null) {
                if (snakeDiffPartial.size > 0) {
                    arrayList.add(snakeDiffPartial);
                }
                snakeDiffPartial.f1144x += range.oldListStart;
                snakeDiffPartial.f1145y += range.newListStart;
                Range range2 = arrayList3.isEmpty() ? new Range() : (Range) arrayList3.remove(arrayList3.size() - 1);
                range2.oldListStart = range.oldListStart;
                range2.newListStart = range.newListStart;
                if (snakeDiffPartial.reverse) {
                    range2.oldListEnd = snakeDiffPartial.f1144x;
                    range2.newListEnd = snakeDiffPartial.f1145y;
                } else if (snakeDiffPartial.removal) {
                    range2.oldListEnd = snakeDiffPartial.f1144x - 1;
                    range2.newListEnd = snakeDiffPartial.f1145y;
                } else {
                    range2.oldListEnd = snakeDiffPartial.f1144x;
                    range2.newListEnd = snakeDiffPartial.f1145y - 1;
                }
                arrayList2.add(range2);
                if (!snakeDiffPartial.reverse) {
                    int i9 = snakeDiffPartial.f1144x;
                    int i10 = snakeDiffPartial.size;
                    range.oldListStart = i9 + i10;
                    range.newListStart = snakeDiffPartial.f1145y + i10;
                } else if (snakeDiffPartial.removal) {
                    int i11 = snakeDiffPartial.f1144x;
                    int i12 = snakeDiffPartial.size;
                    range.oldListStart = i11 + i12 + 1;
                    range.newListStart = snakeDiffPartial.f1145y + i12;
                } else {
                    int i13 = snakeDiffPartial.f1144x;
                    int i14 = snakeDiffPartial.size;
                    range.oldListStart = i13 + i14;
                    range.newListStart = snakeDiffPartial.f1145y + i14 + 1;
                }
                arrayList2.add(range);
            } else {
                arrayList3.add(range);
            }
        }
        Collections.sort(arrayList, SNAKE_COMPARATOR);
        return new DiffResult(callback, arrayList, iArr, iArr2, z2);
    }
}
