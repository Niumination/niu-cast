package cf;

/* JADX INFO: loaded from: classes3.dex */
public final class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final qj.f f1569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1570b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1571c;

    public j0(qj.f fVar, int i8) {
        this.f1569a = fVar;
        this.f1570b = i8;
    }

    public final void a(byte[] bArr, int i8, int i9) {
        this.f1569a.L(bArr, i8, i9);
        this.f1570b -= i9;
        this.f1571c += i9;
    }
}
