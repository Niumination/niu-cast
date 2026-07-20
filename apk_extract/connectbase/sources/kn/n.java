package kn;

/* JADX INFO: loaded from: classes3.dex */
public final class n extends c1<boolean[]> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final boolean[] f9324d;

    public n(int i10) {
        super(i10);
        this.f9324d = new boolean[i10];
    }

    public final void h(boolean z10) {
        boolean[] zArr = this.f9324d;
        int i10 = this.f9297b;
        this.f9297b = i10 + 1;
        zArr[i10] = z10;
    }

    @Override // kn.c1
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public int c(@os.l boolean[] zArr) {
        l0.p(zArr, "<this>");
        return zArr.length;
    }

    @os.l
    public final boolean[] j() {
        return g(this.f9324d, new boolean[f()]);
    }
}
