package kn;

/* JADX INFO: loaded from: classes3.dex */
public final class p extends c1<byte[]> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final byte[] f9330d;

    public p(int i10) {
        super(i10);
        this.f9330d = new byte[i10];
    }

    public final void h(byte b10) {
        byte[] bArr = this.f9330d;
        int i10 = this.f9297b;
        this.f9297b = i10 + 1;
        bArr[i10] = b10;
    }

    @Override // kn.c1
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public int c(@os.l byte[] bArr) {
        l0.p(bArr, "<this>");
        return bArr.length;
    }

    @os.l
    public final byte[] j() {
        return g(this.f9330d, new byte[f()]);
    }
}
