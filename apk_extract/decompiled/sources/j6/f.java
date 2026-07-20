package j6;

import android.widget.FrameLayout;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6114a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6115b;

    @Override // j6.a
    public final Pair a() {
        return new Pair(Integer.valueOf(this.f6114a), Integer.valueOf(this.f6115b));
    }

    @Override // j6.a
    public final FrameLayout.LayoutParams b(int i8, int i9, int i10, int i11, FrameLayout.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(layoutParams, "layoutParams");
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.f6114a = i8;
        this.f6115b = i9;
        return layoutParams;
    }
}
