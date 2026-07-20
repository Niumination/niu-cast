package kn;

/* JADX INFO: loaded from: classes3.dex */
public final class k0 extends c1<int[]> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final int[] f9316d;

    public k0(int i10) {
        super(i10);
        this.f9316d = new int[i10];
    }

    public final void h(int i10) {
        int[] iArr = this.f9316d;
        int i11 = this.f9297b;
        this.f9297b = i11 + 1;
        iArr[i11] = i10;
    }

    @Override // kn.c1
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public int c(@os.l int[] iArr) {
        l0.p(iArr, "<this>");
        return iArr.length;
    }

    @os.l
    public final int[] j() {
        return g(this.f9316d, new int[f()]);
    }
}
