package lm;

/* JADX INFO: loaded from: classes3.dex */
public final class c2 {
    @f1(version = "1.3")
    @t
    @an.f
    public static final long[] a(int i10, jn.l<? super Integer, a2> lVar) {
        kn.l0.p(lVar, "init");
        long[] jArr = new long[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            jArr[i11] = lVar.invoke(Integer.valueOf(i11)).f10177a;
        }
        kn.l0.p(jArr, "storage");
        return jArr;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final long[] b(long... jArr) {
        kn.l0.p(jArr, "elements");
        return jArr;
    }
}
