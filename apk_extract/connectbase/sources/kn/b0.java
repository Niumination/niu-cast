package kn;

/* JADX INFO: loaded from: classes3.dex */
public final class b0 extends c1<float[]> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final float[] f9291d;

    public b0(int i10) {
        super(i10);
        this.f9291d = new float[i10];
    }

    public final void h(float f10) {
        float[] fArr = this.f9291d;
        int i10 = this.f9297b;
        this.f9297b = i10 + 1;
        fArr[i10] = f10;
    }

    @Override // kn.c1
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public int c(@os.l float[] fArr) {
        l0.p(fArr, "<this>");
        return fArr.length;
    }

    @os.l
    public final float[] j() {
        return g(this.f9291d, new float[f()]);
    }
}
