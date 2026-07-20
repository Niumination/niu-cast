package lm;

/* JADX INFO: loaded from: classes3.dex */
public final class y1 {
    @f1(version = "1.3")
    @t
    @an.f
    public static final int[] a(int i10, jn.l<? super Integer, w1> lVar) {
        kn.l0.p(lVar, "init");
        int[] iArr = new int[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            iArr[i11] = lVar.invoke(Integer.valueOf(i11)).f10227a;
        }
        kn.l0.p(iArr, "storage");
        return iArr;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final int[] b(int... iArr) {
        kn.l0.p(iArr, "elements");
        return iArr;
    }
}
