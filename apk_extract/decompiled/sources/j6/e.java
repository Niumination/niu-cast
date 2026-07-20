package j6;

import android.widget.FrameLayout;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6112a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6113b;

    @Override // j6.a
    public final Pair a() {
        return new Pair(Integer.valueOf(this.f6112a), Integer.valueOf(this.f6113b));
    }

    @Override // j6.a
    public final FrameLayout.LayoutParams b(int i8, int i9, int i10, int i11, FrameLayout.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(layoutParams, "layoutParams");
        float f = i8;
        float f4 = i9;
        float f10 = i10 / i11;
        if (f / f4 > f10) {
            i8 = (int) (f10 * f4);
        } else {
            i9 = (int) (f / f10);
        }
        Pair pair = new Pair(Integer.valueOf(i8), Integer.valueOf(i9));
        int iIntValue = ((Number) pair.component1()).intValue();
        int iIntValue2 = ((Number) pair.component2()).intValue();
        if (iIntValue <= 0 && iIntValue2 <= 0) {
            return layoutParams;
        }
        this.f6112a = iIntValue;
        this.f6113b = iIntValue2;
        layoutParams.width = iIntValue;
        layoutParams.height = iIntValue2;
        layoutParams.gravity = 17;
        return layoutParams;
    }
}
