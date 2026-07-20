package kn;

/* JADX INFO: loaded from: classes3.dex */
public final class s extends c1<char[]> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final char[] f9355d;

    public s(int i10) {
        super(i10);
        this.f9355d = new char[i10];
    }

    public final void h(char c10) {
        char[] cArr = this.f9355d;
        int i10 = this.f9297b;
        this.f9297b = i10 + 1;
        cArr[i10] = c10;
    }

    @Override // kn.c1
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public int c(@os.l char[] cArr) {
        l0.p(cArr, "<this>");
        return cArr.length;
    }

    @os.l
    public final char[] j() {
        return g(this.f9355d, new char[f()]);
    }
}
