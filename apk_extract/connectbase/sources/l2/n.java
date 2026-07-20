package l2;

import f2.a0;
import kn.l0;

/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final n f9679a = new n();

    @os.l
    public final float[] a(int i10, int i11, @os.l a0 a0Var, @os.l float[] fArr) {
        l0.p(a0Var, "rect");
        l0.p(fArr, dc.d.f3685p);
        int i12 = a0Var.f5666a;
        float f10 = i10;
        fArr[0] = i12 / f10;
        int i13 = a0Var.f5667b;
        float f11 = i11;
        fArr[1] = i13 / f11;
        fArr[2] = i12 / f10;
        int i14 = a0Var.f5669d;
        fArr[3] = (i13 + i14) / f11;
        int i15 = a0Var.f5668c;
        fArr[4] = (i12 + i15) / f10;
        fArr[5] = i13 / f11;
        fArr[6] = (i12 + i15) / f10;
        fArr[7] = (i13 + i14) / f11;
        return fArr;
    }

    @os.l
    public final float[] b(@os.l float[] fArr) {
        l0.p(fArr, dc.d.f3685p);
        float f10 = fArr[0];
        float f11 = fArr[1];
        fArr[0] = fArr[2];
        fArr[1] = fArr[3];
        fArr[2] = fArr[6];
        fArr[3] = fArr[7];
        fArr[6] = fArr[4];
        fArr[7] = fArr[5];
        fArr[4] = f10;
        fArr[5] = f11;
        return fArr;
    }
}
