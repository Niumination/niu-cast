package kn;

/* JADX INFO: loaded from: classes3.dex */
public final class q1 extends c1<short[]> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final short[] f9342d;

    public q1(int i10) {
        super(i10);
        this.f9342d = new short[i10];
    }

    public final void h(short s10) {
        short[] sArr = this.f9342d;
        int i10 = this.f9297b;
        this.f9297b = i10 + 1;
        sArr[i10] = s10;
    }

    @Override // kn.c1
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public int c(@os.l short[] sArr) {
        l0.p(sArr, "<this>");
        return sArr.length;
    }

    @os.l
    public final short[] j() {
        return g(this.f9342d, new short[f()]);
    }
}
