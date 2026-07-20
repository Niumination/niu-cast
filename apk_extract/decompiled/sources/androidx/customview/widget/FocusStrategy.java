package androidx.customview.widget;

import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
class FocusStrategy {

    public interface BoundsAdapter<T> {
        void obtainBounds(T t3, Rect rect);
    }

    public interface CollectionAdapter<T, V> {
        V get(T t3, int i8);

        int size(T t3);
    }

    public static class SequentialComparator<T> implements Comparator<T> {
        private final BoundsAdapter<T> mAdapter;
        private final boolean mIsLayoutRtl;
        private final Rect mTemp1 = new Rect();
        private final Rect mTemp2 = new Rect();

        public SequentialComparator(boolean z2, BoundsAdapter<T> boundsAdapter) {
            this.mIsLayoutRtl = z2;
            this.mAdapter = boundsAdapter;
        }

        @Override // java.util.Comparator
        public int compare(T t3, T t8) {
            Rect rect = this.mTemp1;
            Rect rect2 = this.mTemp2;
            this.mAdapter.obtainBounds(t3, rect);
            this.mAdapter.obtainBounds(t8, rect2);
            int i8 = rect.top;
            int i9 = rect2.top;
            if (i8 < i9) {
                return -1;
            }
            if (i8 > i9) {
                return 1;
            }
            int i10 = rect.left;
            int i11 = rect2.left;
            if (i10 < i11) {
                return this.mIsLayoutRtl ? 1 : -1;
            }
            if (i10 > i11) {
                return this.mIsLayoutRtl ? -1 : 1;
            }
            int i12 = rect.bottom;
            int i13 = rect2.bottom;
            if (i12 < i13) {
                return -1;
            }
            if (i12 > i13) {
                return 1;
            }
            int i14 = rect.right;
            int i15 = rect2.right;
            if (i14 < i15) {
                return this.mIsLayoutRtl ? 1 : -1;
            }
            if (i14 > i15) {
                return this.mIsLayoutRtl ? -1 : 1;
            }
            return 0;
        }
    }

    private FocusStrategy() {
    }

    private static boolean beamBeats(int i8, @NonNull Rect rect, @NonNull Rect rect2, @NonNull Rect rect3) {
        boolean zBeamsOverlap = beamsOverlap(i8, rect, rect2);
        if (beamsOverlap(i8, rect, rect3) || !zBeamsOverlap) {
            return false;
        }
        return !isToDirectionOf(i8, rect, rect3) || i8 == 17 || i8 == 66 || majorAxisDistance(i8, rect, rect2) < majorAxisDistanceToFarEdge(i8, rect, rect3);
    }

    private static boolean beamsOverlap(int i8, @NonNull Rect rect, @NonNull Rect rect2) {
        if (i8 != 17) {
            if (i8 != 33) {
                if (i8 != 66) {
                    if (i8 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return rect2.right >= rect.left && rect2.left <= rect.right;
        }
        return rect2.bottom >= rect.top && rect2.top <= rect.bottom;
    }

    public static <L, T> T findNextFocusInAbsoluteDirection(@NonNull L l4, @NonNull CollectionAdapter<L, T> collectionAdapter, @NonNull BoundsAdapter<T> boundsAdapter, @Nullable T t3, @NonNull Rect rect, int i8) {
        Rect rect2 = new Rect(rect);
        if (i8 == 17) {
            rect2.offset(rect.width() + 1, 0);
        } else if (i8 == 33) {
            rect2.offset(0, rect.height() + 1);
        } else if (i8 == 66) {
            rect2.offset(-(rect.width() + 1), 0);
        } else {
            if (i8 != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            rect2.offset(0, -(rect.height() + 1));
        }
        int size = collectionAdapter.size(l4);
        Rect rect3 = new Rect();
        T t8 = null;
        for (int i9 = 0; i9 < size; i9++) {
            T t10 = collectionAdapter.get(l4, i9);
            if (t10 != t3) {
                boundsAdapter.obtainBounds(t10, rect3);
                if (isBetterCandidate(i8, rect, rect3, rect2)) {
                    rect2.set(rect3);
                    t8 = t10;
                }
            }
        }
        return t8;
    }

    public static <L, T> T findNextFocusInRelativeDirection(@NonNull L l4, @NonNull CollectionAdapter<L, T> collectionAdapter, @NonNull BoundsAdapter<T> boundsAdapter, @Nullable T t3, int i8, boolean z2, boolean z3) {
        int size = collectionAdapter.size(l4);
        ArrayList arrayList = new ArrayList(size);
        for (int i9 = 0; i9 < size; i9++) {
            arrayList.add(collectionAdapter.get(l4, i9));
        }
        Collections.sort(arrayList, new SequentialComparator(z2, boundsAdapter));
        if (i8 == 1) {
            return (T) getPreviousFocusable(t3, arrayList, z3);
        }
        if (i8 == 2) {
            return (T) getNextFocusable(t3, arrayList, z3);
        }
        throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
    }

    private static <T> T getNextFocusable(T t3, ArrayList<T> arrayList, boolean z2) {
        int size = arrayList.size();
        int iLastIndexOf = (t3 == null ? -1 : arrayList.lastIndexOf(t3)) + 1;
        if (iLastIndexOf < size) {
            return arrayList.get(iLastIndexOf);
        }
        if (!z2 || size <= 0) {
            return null;
        }
        return arrayList.get(0);
    }

    private static <T> T getPreviousFocusable(T t3, ArrayList<T> arrayList, boolean z2) {
        int size = arrayList.size();
        int iIndexOf = (t3 == null ? size : arrayList.indexOf(t3)) - 1;
        if (iIndexOf >= 0) {
            return arrayList.get(iIndexOf);
        }
        if (!z2 || size <= 0) {
            return null;
        }
        return arrayList.get(size - 1);
    }

    private static int getWeightedDistanceFor(int i8, int i9) {
        return (i9 * i9) + (i8 * 13 * i8);
    }

    private static boolean isBetterCandidate(int i8, @NonNull Rect rect, @NonNull Rect rect2, @NonNull Rect rect3) {
        if (!isCandidate(rect, rect2, i8)) {
            return false;
        }
        if (isCandidate(rect, rect3, i8) && !beamBeats(i8, rect, rect2, rect3)) {
            return !beamBeats(i8, rect, rect3, rect2) && getWeightedDistanceFor(majorAxisDistance(i8, rect, rect2), minorAxisDistance(i8, rect, rect2)) < getWeightedDistanceFor(majorAxisDistance(i8, rect, rect3), minorAxisDistance(i8, rect, rect3));
        }
        return true;
    }

    private static boolean isCandidate(@NonNull Rect rect, @NonNull Rect rect2, int i8) {
        if (i8 == 17) {
            int i9 = rect.right;
            int i10 = rect2.right;
            return (i9 > i10 || rect.left >= i10) && rect.left > rect2.left;
        }
        if (i8 == 33) {
            int i11 = rect.bottom;
            int i12 = rect2.bottom;
            return (i11 > i12 || rect.top >= i12) && rect.top > rect2.top;
        }
        if (i8 == 66) {
            int i13 = rect.left;
            int i14 = rect2.left;
            return (i13 < i14 || rect.right <= i14) && rect.right < rect2.right;
        }
        if (i8 != 130) {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        int i15 = rect.top;
        int i16 = rect2.top;
        return (i15 < i16 || rect.bottom <= i16) && rect.bottom < rect2.bottom;
    }

    private static boolean isToDirectionOf(int i8, @NonNull Rect rect, @NonNull Rect rect2) {
        if (i8 == 17) {
            return rect.left >= rect2.right;
        }
        if (i8 == 33) {
            return rect.top >= rect2.bottom;
        }
        if (i8 == 66) {
            return rect.right <= rect2.left;
        }
        if (i8 == 130) {
            return rect.bottom <= rect2.top;
        }
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }

    private static int majorAxisDistance(int i8, @NonNull Rect rect, @NonNull Rect rect2) {
        return Math.max(0, majorAxisDistanceRaw(i8, rect, rect2));
    }

    private static int majorAxisDistanceRaw(int i8, @NonNull Rect rect, @NonNull Rect rect2) {
        int i9;
        int i10;
        if (i8 == 17) {
            i9 = rect.left;
            i10 = rect2.right;
        } else if (i8 == 33) {
            i9 = rect.top;
            i10 = rect2.bottom;
        } else if (i8 == 66) {
            i9 = rect2.left;
            i10 = rect.right;
        } else {
            if (i8 != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            i9 = rect2.top;
            i10 = rect.bottom;
        }
        return i9 - i10;
    }

    private static int majorAxisDistanceToFarEdge(int i8, @NonNull Rect rect, @NonNull Rect rect2) {
        return Math.max(1, majorAxisDistanceToFarEdgeRaw(i8, rect, rect2));
    }

    private static int majorAxisDistanceToFarEdgeRaw(int i8, @NonNull Rect rect, @NonNull Rect rect2) {
        int i9;
        int i10;
        if (i8 == 17) {
            i9 = rect.left;
            i10 = rect2.left;
        } else if (i8 == 33) {
            i9 = rect.top;
            i10 = rect2.top;
        } else if (i8 == 66) {
            i9 = rect2.right;
            i10 = rect.right;
        } else {
            if (i8 != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            i9 = rect2.bottom;
            i10 = rect.bottom;
        }
        return i9 - i10;
    }

    private static int minorAxisDistance(int i8, @NonNull Rect rect, @NonNull Rect rect2) {
        if (i8 != 17) {
            if (i8 != 33) {
                if (i8 != 66) {
                    if (i8 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return Math.abs(((rect.width() / 2) + rect.left) - ((rect2.width() / 2) + rect2.left));
        }
        return Math.abs(((rect.height() / 2) + rect.top) - ((rect2.height() / 2) + rect2.top));
    }
}
