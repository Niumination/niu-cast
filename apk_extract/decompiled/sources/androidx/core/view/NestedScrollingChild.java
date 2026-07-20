package androidx.core.view;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public interface NestedScrollingChild {
    boolean dispatchNestedFling(float f, float f4, boolean z2);

    boolean dispatchNestedPreFling(float f, float f4);

    boolean dispatchNestedPreScroll(int i8, int i9, @Nullable int[] iArr, @Nullable int[] iArr2);

    boolean dispatchNestedScroll(int i8, int i9, int i10, int i11, @Nullable int[] iArr);

    boolean hasNestedScrollingParent();

    boolean isNestedScrollingEnabled();

    void setNestedScrollingEnabled(boolean z2);

    boolean startNestedScroll(int i8);

    void stopNestedScroll();
}
