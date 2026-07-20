package l2;

import f2.a0;
import kn.l0;

/* JADX INFO: loaded from: classes.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final p f9682a = new p();

    @os.l
    public final float[] a(int i10, int i11, @os.l a0 a0Var, @os.l float[] fArr) {
        l0.p(a0Var, "rect");
        l0.p(fArr, dc.d.f3685p);
        float f10 = i10;
        fArr[0] = b(a0Var.f5666a / f10);
        float f11 = i11;
        fArr[1] = c(a0Var.f5667b / f11);
        fArr[2] = b(a0Var.f5666a / f10);
        fArr[3] = c((a0Var.f5667b + a0Var.f5669d) / f11);
        fArr[4] = b((a0Var.f5666a + a0Var.f5668c) / f10);
        fArr[5] = c(a0Var.f5667b / f11);
        fArr[6] = b((a0Var.f5666a + a0Var.f5668c) / f10);
        fArr[7] = c((a0Var.f5667b + a0Var.f5669d) / f11);
        return fArr;
    }

    public final float b(float f10) {
        return (f10 * 2.0f) - 1.0f;
    }

    public final float c(float f10) {
        return (((f10 * 2.0f) - 2.0f) * (-1.0f)) - 1.0f;
    }
}
