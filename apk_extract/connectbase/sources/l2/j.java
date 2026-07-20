package l2;

import android.widget.FrameLayout;
import kn.l0;
import lm.t0;

/* JADX INFO: loaded from: classes.dex */
public final class j implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f9656a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9657b;

    @Override // l2.e
    @os.l
    public FrameLayout.LayoutParams a(int i10, int i11, int i12, int i13, @os.l FrameLayout.LayoutParams layoutParams) {
        l0.p(layoutParams, "layoutParams");
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.f9656a = i10;
        this.f9657b = i11;
        return layoutParams;
    }

    @Override // l2.e
    @os.l
    public t0<Integer, Integer> getRealSize() {
        return new t0<>(Integer.valueOf(this.f9656a), Integer.valueOf(this.f9657b));
    }
}
