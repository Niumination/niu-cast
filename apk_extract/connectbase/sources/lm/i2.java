package lm;

/* JADX INFO: loaded from: classes3.dex */
public final class i2 {
    @f1(version = "1.3")
    @t
    @an.f
    public static final short[] a(int i10, jn.l<? super Integer, g2> lVar) {
        kn.l0.p(lVar, "init");
        short[] sArr = new short[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            sArr[i11] = lVar.invoke(Integer.valueOf(i11)).f10193a;
        }
        kn.l0.p(sArr, "storage");
        return sArr;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final short[] b(short... sArr) {
        kn.l0.p(sArr, "elements");
        return sArr;
    }
}
