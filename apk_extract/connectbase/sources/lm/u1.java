package lm;

/* JADX INFO: loaded from: classes3.dex */
public final class u1 {
    @f1(version = "1.3")
    @t
    @an.f
    public static final byte[] a(int i10, jn.l<? super Integer, s1> lVar) {
        kn.l0.p(lVar, "init");
        byte[] bArr = new byte[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            bArr[i11] = lVar.invoke(Integer.valueOf(i11)).f10218a;
        }
        kn.l0.p(bArr, "storage");
        return bArr;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final byte[] b(byte... bArr) {
        kn.l0.p(bArr, "elements");
        return bArr;
    }
}
