package r1;

/* JADX INFO: loaded from: classes.dex */
public final class t implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f9299b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final q1.a f9300c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f9301d;

    public t(String str, int i8, q1.a aVar, boolean z2) {
        this.f9298a = str;
        this.f9299b = i8;
        this.f9300c = aVar;
        this.f9301d = z2;
    }

    @Override // r1.b
    public final l1.d a(j1.x xVar, j1.j jVar, s1.c cVar) {
        return new l1.u(xVar, cVar, this);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("ShapePath{name=");
        sb2.append(this.f9298a);
        sb2.append(", index=");
        return a1.a.r(sb2, this.f9299b, '}');
    }
}
