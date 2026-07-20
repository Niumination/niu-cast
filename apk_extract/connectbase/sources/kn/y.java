package kn;

/* JADX INFO: loaded from: classes3.dex */
public final class y extends c1<double[]> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final double[] f9391d;

    public y(int i10) {
        super(i10);
        this.f9391d = new double[i10];
    }

    public final void h(double d10) {
        double[] dArr = this.f9391d;
        int i10 = this.f9297b;
        this.f9297b = i10 + 1;
        dArr[i10] = d10;
    }

    @Override // kn.c1
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public int c(@os.l double[] dArr) {
        l0.p(dArr, "<this>");
        return dArr.length;
    }

    @os.l
    public final double[] j() {
        return g(this.f9391d, new double[f()]);
    }
}
