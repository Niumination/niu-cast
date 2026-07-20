package fl;

/* JADX INFO: loaded from: classes2.dex */
public final class l {
    @t0
    public static final short a(@os.l byte[] bArr, int i10) {
        kn.l0.p(bArr, "<this>");
        return (short) ((bArr[i10 + 1] & 255) | ((bArr[i10] & 255) << 8));
    }
}
