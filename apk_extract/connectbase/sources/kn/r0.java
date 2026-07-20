package kn;

/* JADX INFO: loaded from: classes3.dex */
public final class r0 extends c1<long[]> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final long[] f9354d;

    public r0(int i10) {
        super(i10);
        this.f9354d = new long[i10];
    }

    public final void h(long j10) {
        long[] jArr = this.f9354d;
        int i10 = this.f9297b;
        this.f9297b = i10 + 1;
        jArr[i10] = j10;
    }

    @Override // kn.c1
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public int c(@os.l long[] jArr) {
        l0.p(jArr, "<this>");
        return jArr.length;
    }

    @os.l
    public final long[] j() {
        return g(this.f9354d, new long[f()]);
    }
}
