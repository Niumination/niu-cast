package l2;

import android.widget.FrameLayout;
import kn.l0;
import lm.t0;

/* JADX INFO: loaded from: classes.dex */
public final class h implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f9652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9653b;

    @Override // l2.e
    @os.l
    public FrameLayout.LayoutParams a(int i10, int i11, int i12, int i13, @os.l FrameLayout.LayoutParams layoutParams) {
        l0.p(layoutParams, "layoutParams");
        t0<Integer, Integer> t0VarB = b(i10, i11, i12, i13);
        int iIntValue = t0VarB.component1().intValue();
        int iIntValue2 = t0VarB.component2().intValue();
        if (iIntValue <= 0 && iIntValue2 <= 0) {
            return layoutParams;
        }
        this.f9652a = iIntValue;
        this.f9653b = iIntValue2;
        layoutParams.width = iIntValue;
        layoutParams.height = iIntValue2;
        layoutParams.gravity = 17;
        return layoutParams;
    }

    public final t0<Integer, Integer> b(int i10, int i11, int i12, int i13) {
        float f10 = i10;
        float f11 = i11;
        float f12 = i12 / i13;
        if (f10 / f11 > f12) {
            i11 = (int) (f10 / f12);
        } else {
            i10 = (int) (f12 * f11);
        }
        return new t0<>(Integer.valueOf(i10), Integer.valueOf(i11));
    }

    @Override // l2.e
    @os.l
    public t0<Integer, Integer> getRealSize() {
        return new t0<>(Integer.valueOf(this.f9652a), Integer.valueOf(this.f9653b));
    }
}
